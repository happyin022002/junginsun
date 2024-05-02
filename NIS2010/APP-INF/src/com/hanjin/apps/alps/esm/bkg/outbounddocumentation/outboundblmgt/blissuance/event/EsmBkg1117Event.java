/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1117Event.java
*@FileTitle : Reject Message Edit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.01 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1117 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1117HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_1117HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1117Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsmBkg1117Event(){}
	
	
	private String bkgNo = null;
	private String remark = null;
	private String srStsCd = null;

	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}
	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the srStsCd
	 */
	public String getSrStsCd() {
		return srStsCd;
	}
	/**
	 * @param srStsCd the srStsCd to set
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	

	
}