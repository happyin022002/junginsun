/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri9124Event.java
*@FileTitle : Pricing File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_9124 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_9124HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_9124HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri9124Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** File Upload Key */
	private List<String> keys = null;

	public EsmPri9124Event(){}
	
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
}