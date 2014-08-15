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
		this.setBeaconLayout("m:2-3=ff4c,i:7-22,i:23-24,i:25-26,p:27-27,d:28-28");
	}
	
}
