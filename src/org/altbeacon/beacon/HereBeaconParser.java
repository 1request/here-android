/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-14
 */
package org.altbeacon.beacon;


/**
 *
 */
public class HereBeaconParser extends BeaconParser {
	private static final String TAG = "HereBeaconParser";

	/**
	 * 
	 */
	public HereBeaconParser() {
		super();
		this.setBeaconLayout("m:14-17=0215,i:18-33,i:34-35,i:36-37,p:38-39,d:40-79");
	}
	
}
