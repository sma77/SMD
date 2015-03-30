/***********************************************************
 *      This software is part of the ProM package          *
 *             http://www.processmining.org/               *
 *                                                         *
 *            Copyright (c) 2003-2006 TU/e Eindhoven       *
 *                and is licensed under the                *
 *            Common Public License, Version 1.0           *
 *        by Eindhoven University of Technology            *
 *           Department of Information Systems             *
 *                 http://is.tm.tue.nl                     *
 *                                                         *
 **********************************************************/

package org.prom5.mining.geneticmining.population.duplicates;

import java.util.Random;

import org.prom5.framework.models.heuristics.HeuristicsNet;
import org.prom5.mining.geneticmining.geneticoperations.Crossover;
import org.prom5.mining.geneticmining.geneticoperations.Mutation;
import org.prom5.mining.geneticmining.population.BuildPopulation;
import org.prom5.mining.geneticmining.selection.SelectionMethod;

/**
 * <p>Title: Duplicate Tasks Build Next Generation</p>
 * <p>Description: Uses elistim and the genetic operator to build the populatio for the next
 * iteration of the genetic algorithm.</p>
 * @author Ana Karla A. de Medeiros
 * @version 1.0
 */

public class DTBuildNextGeneration implements BuildPopulation {
	private double elitismRate = 0;
	private SelectionMethod selectionMethod = null;
	private Random generator = null;
	private double crossoverRate = 0;
	private double mutationRate = 0;
	private Crossover crossover = null;
	private Mutation mutation = null;

	public DTBuildNextGeneration(SelectionMethod selectionMethod,
			Random generator, double crossoverRate, double mutationRate,
			double elitismRate, Crossover crossover, Mutation mutation) {

		this.selectionMethod = selectionMethod;
		this.generator = generator;

		this.elitismRate = elitismRate;
		this.crossoverRate = crossoverRate;
		this.mutationRate = mutationRate;

		this.crossover = crossover;
		this.mutation = mutation;

	}

	/*
	 * Creates a new population based on the old population. The genetic operator (crossover and
	 * mutation are used to build the next generation. A percentage of the  best individuals (elite)
	 * of the old population is directly copied to the new population.
	 * @param oldPopulation <b>increasingly</b> sorted array.
	 * @return new population.
	 */

	public HeuristicsNet[] build(HeuristicsNet[] oldPopulation) {
		double numElite = 0;
		double random = 0;
		int indexNewPopulation = 0;
		int numOffsprings = 2;
		HeuristicsNet[] newPopulation = null;
		HeuristicsNet[] selectedParents = null;
		HeuristicsNet[] offsprings = null;

		//copying the best individuals to next generation...
		numElite = oldPopulation.length * elitismRate;
		newPopulation = new HeuristicsNet[oldPopulation.length];

		//NOTE: we assume that the array oldPopulation is increasingly sorted!!!
		indexNewPopulation = 0;
		for (int indexOldPopulation = (oldPopulation.length - 1);
									  indexNewPopulation < numElite; indexNewPopulation++,
									  indexOldPopulation--) {
			newPopulation[indexNewPopulation] = oldPopulation[indexOldPopulation].copyNet();
		}

		while (indexNewPopulation < newPopulation.length) {

			//applying tournament selection...
			selectedParents = new HeuristicsNet[numOffsprings];
			for (int i = 0; i < selectedParents.length; i++) {
				selectedParents[i] = selectionMethod.select(oldPopulation)[0];
			}
			//applying crossover operation...
			random = generator.nextDouble();
			if (random < crossoverRate) {
				offsprings = crossover.doCrossover(selectedParents);

			} else {
				//no crossover
				offsprings = selectedParents;
			}

			//applying mutation operation for offsprings...
			if (mutationRate > 0) {
				for (int i = 0; i < offsprings.length; i++) {
					mutation.doMutation(offsprings[i]);
				}
			}

			for (int i = 0; i < offsprings.length && indexNewPopulation < newPopulation.length; i++) {
				newPopulation[indexNewPopulation] = offsprings[i];
				indexNewPopulation++;
			}

		}

		return newPopulation;
	}

}
