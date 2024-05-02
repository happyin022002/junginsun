/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1174Event.java
*@FileTitle : NMC (Non-Manipulation Certificate)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.07
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2014.04.07 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1174 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1174HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 조인영
 * @see ESM_BKG_1174HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1174Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsmBkg1174Event(){}

	private String bkg_no = null;
	private String bl_no = null;
	private String cntr_no = null;
	
	public String getBkg_no() {
		return bkg_no;
	}
	public void setBkg_no(String bkg_no) {
		this.bkg_no = bkg_no;
	}
	public String getBl_no() {
		return bl_no;
	}
	public void setBl_no(String bl_no) {
		this.bl_no = bl_no;
	}
	public String getCntr_no() {
		return cntr_no;
	}
	public void setCntr_no(String cntr_no) {
		this.cntr_no = cntr_no;
	}

	

}