/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0075Event.java
*@FileTitle : E-mail / Print - window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.21 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0075 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0075HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0075HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0075Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private List<String> keys = null;
	
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
}