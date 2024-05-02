/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1034Event.java
*@FileTitle : Pick-Up Notice Template(Manual Send)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.06.29 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupWdVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgPkupNtcStupVO;

/**
 * ESM_BKG_1034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
 * @see ESM_BKG_1034HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1034Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Office Code */
	private String ofcCd = "";
	
	
	/** PickUp Notice Setup Table Value Object 조회 조건 및 단건 처리  */
	private BkgPkupNtcStupVO bkgPkupNtcStupVO = null;
	
	/** PickUp Notice Word Table Value Object Multi Data 처리 */
	private PkupWdVO[] bkgPkupWdVOs = null;
		
	
	public EsmBkg1034Event() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param bkgPkupNtcStupVO the bkgPkupNtcStupVO to set
	 */
	public void setBkgPkupNtcStupVO(BkgPkupNtcStupVO bkgPkupNtcStupVO) {
		this.bkgPkupNtcStupVO = bkgPkupNtcStupVO;
	}

	/**
	 * @return the bkgPkupNtcStupVO
	 */
	public BkgPkupNtcStupVO getBkgPkupNtcStupVO() {
		return bkgPkupNtcStupVO;
	}

	/**
	 * @param bkgPkupWdVOs the bkgPkupWdVOs to set
	 */
	public void setBkgPkupWdVOs(PkupWdVO[] bkgPkupWdVOs) {
		this.bkgPkupWdVOs = bkgPkupWdVOs;
	}

	/**
	 * @return the bkgPkupWdVOs
	 */
	public PkupWdVO[] getBkgPkupWdVOs() {
		return bkgPkupWdVOs;
	}

}
