/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0106Event.java
 *@FileTitle : Approval Opinion
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.19
 *@LastModifier : 박창준
 *@LastVersion : 1.0
 * 2009.06.19 박창준
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM-0106] Approval Opinion
 * CPS_GEM_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Changjune
 * @see CPS_GEM_0106HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0106Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private  String genExpnRqstNo = "";

	/**
	 * @return the genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return genExpnRqstNo;
	}

	/**
	 * @param genExpnRqstNo the genExpnRqstNo to set
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}
	
	private  String genExpnCd = "";

	/**
	 * @return the genExpnCd
	 */
	public String getGenExpnCd() {
		return genExpnCd;
	}

	/**
	 * @param genExpnCd the genExpnCd to set
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	private  String genExpnItmNo = "";

	/**
	 * @return the genExpnItmNo
	 */
	public String getGenExpnItmNo() {
		return genExpnItmNo;
	}

	/**
	 * @param genExpnItmNo the genExpnItmNo to set
	 */
	public void setGenExpnItmNo(String genExpnItmNo) {
		this.genExpnItmNo = genExpnItmNo;
	}



}