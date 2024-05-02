/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfEdiEvent.java
*@FileTitle : coprar
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.10 
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;


import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * MQ에서 전문을 받는다<br>
 * <br>
 * <br>
 *
 * @author Yang Jae Kim
 * @see 
 * @since J2EE 1.6
 */

public class OpfEdiEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	public String flatFile = null;
	public String route		= null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
	
}