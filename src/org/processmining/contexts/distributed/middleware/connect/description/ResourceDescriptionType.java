//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, v2.1-b02-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2008.08.01 at 12:14:32 PM CEST
//

package org.processmining.contexts.distributed.middleware.connect.description;

// import javax.xml.bind.annotation.XmlAccessType;
// import javax.xml.bind.annotation.XmlAccessorType;
// import javax.xml.bind.annotation.XmlElement;
// import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ResourceDescriptionType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ResourceDescriptionType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;availableMemory&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot;/&gt;
 *         &lt;element name=&quot;dataList&quot; type=&quot;{}DataList&quot;/&gt;
 *         &lt;element name=&quot;maxMemory&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot;/&gt;
 *         &lt;element name=&quot;noCPU&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;loadAvg&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot;/&gt;
 *         &lt;element name=&quot;URI&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "ResourceDescriptionType", propOrder = {
//    "availableMemory",
//    "dataList",
//    "maxMemory",
//    "noCPU",
//    "loadAvg",
//    "uri"
//})
public class ResourceDescriptionType {

	protected double availableMemory;
	//    @XmlElement(required = true)
	protected DataList dataList;
	protected double maxMemory;
	protected long noCPU;
	protected double loadAvg;
	//    @XmlElement(name = "URI", required = true)
	protected String uri;

	/**
	 * Gets the value of the availableMemory property.
	 * 
	 */
	public double getAvailableMemory() {
		return availableMemory;
	}

	/**
	 * Sets the value of the availableMemory property.
	 * 
	 */
	public void setAvailableMemory(double value) {
		availableMemory = value;
	}

	/**
	 * Gets the value of the dataList property.
	 * 
	 * @return possible object is {@link DataList }
	 * 
	 */
	public DataList getDataList() {
		return dataList;
	}

	/**
	 * Sets the value of the dataList property.
	 * 
	 * @param value
	 *            allowed object is {@link DataList }
	 * 
	 */
	public void setDataList(DataList value) {
		dataList = value;
	}

	/**
	 * Gets the value of the maxMemory property.
	 * 
	 */
	public double getMaxMemory() {
		return maxMemory;
	}

	/**
	 * Sets the value of the maxMemory property.
	 * 
	 */
	public void setMaxMemory(double value) {
		maxMemory = value;
	}

	/**
	 * Gets the value of the noCPU property.
	 * 
	 */
	public long getNoCPU() {
		return noCPU;
	}

	/**
	 * Sets the value of the noCPU property.
	 * 
	 */
	public void setNoCPU(long value) {
		noCPU = value;
	}

	/**
	 * Gets the value of the loadAvg property.
	 * 
	 */
	public double getLoadAvg() {
		return loadAvg;
	}

	/**
	 * Sets the value of the loadAvg property.
	 * 
	 */
	public void setLoadAvg(double value) {
		loadAvg = value;
	}

	/**
	 * Gets the value of the uri property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getURI() {
		return uri;
	}

	/**
	 * Sets the value of the uri property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setURI(String value) {
		uri = value;
	}

	//	private String logicalNameOfData(String s){
	//		return s.substring(s.lastIndexOf("/")+1);
	//		//return s;
	//	}

	//	private  void process(File dir) {
	//		// TODO Auto-generated method stub
	//		if (dir.isFile()){
	//			DataElement d = new DataElement();
	//			d.setLogicalName(logicalNameOfData(dir.getParent()));
	//			d.setPhysicalName(dir.getAbsolutePath());
	//			d.setFileSize(dir.length());
	//			if (dataList==null)
	//				dataList = new DataList();
	//			dataList.getDataList().add(d);
	//			//occupiedMemory = occupiedMemory + d.getFileSize();
	//		}
	//			
	//	}

	/**
	 * This method uses Operating System in order to set the properties
	 * informations are gathered from /proc directory in Linux
	 * 
	 */
	public boolean setOSProperties(int port) {

		//		OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
		//
		//		loadAvg = os.getSystemLoadAverage() / os.getAvailableProcessors();
		//
		//		//loadAvg = 0;
		//
		//		maxMemory = Runtime.getRuntime().maxMemory();
		//		availableMemory = Runtime.getRuntime().freeMemory();
		//
		//		noCPU = Runtime.getRuntime().availableProcessors();
		//
		//		try {
		//			uri = java.net.InetAddress.getLocalHost().getCanonicalHostName() + ":" + port;
		//		} catch (UnknownHostException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		return true;

	}

	// Process all files and directories under dir
	//	private void visitAllDirsAndFiles(File dir) {
	//	
	//
	//	    process(dir);
	//	
	//	    if (dir.isDirectory()) {
	//	        String[] children = dir.list();
	//	        for (int i=0; i<children.length; i++) {
	//	            visitAllDirsAndFiles(new File(dir, children[i]));
	//	        }
	//	    }
	//	}

}
