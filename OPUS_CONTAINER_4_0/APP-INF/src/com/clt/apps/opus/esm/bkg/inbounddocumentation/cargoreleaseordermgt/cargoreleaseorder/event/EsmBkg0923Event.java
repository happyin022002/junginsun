/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0923Event.java
*@FileTitle : Cargo Release Order_Do List Check Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0923 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0923HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0923HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0923Event extends EventSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2261069293441189767L;

	/** 검색조건 */
	private String blNo = null;
	
	
	public EsmBkg0923Event(){}


	public String getBlNo() {
		return blNo;
	}


	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}


	
}