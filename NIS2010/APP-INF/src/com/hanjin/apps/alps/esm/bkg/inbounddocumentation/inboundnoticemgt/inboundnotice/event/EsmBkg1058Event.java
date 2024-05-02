/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1058Event.java
*@FileTitle : MT Return Yard for Pickup Notice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.08.10 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupCntrRtnYdVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgPkupCntrRtnYdVO;


/**
 * ESM_BKG_1058 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1058HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
 * @see ESM_BKG_1058HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1058Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PkupCntrRtnYdVO pkupCntrRtnYdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgPkupCntrRtnYdVO[] bkgPkupCntrRtnYdVOs = null;

	/** Location Code */
	private String locCd = "";

	/** Validation Code Type */
	private String chkTp = "";
	
	public EsmBkg1058Event(){}
	
	public void setPkupCntrRtnYdVO(PkupCntrRtnYdVO pkupCntrRtnYdVO){
		this. pkupCntrRtnYdVO = pkupCntrRtnYdVO;
	}

	public void setBkgPkupCntrRtnYdVOS(BkgPkupCntrRtnYdVO[] bkgPkupCntrRtnYdVOs){
		this. bkgPkupCntrRtnYdVOs = bkgPkupCntrRtnYdVOs;
	}

	public PkupCntrRtnYdVO getPkupCntrRtnYdVO(){
		return pkupCntrRtnYdVO;
	}

	public BkgPkupCntrRtnYdVO[] getBkgPkupCntrRtnYdVOS(){
		return bkgPkupCntrRtnYdVOs;
	}

	/**
	 * @param locCd the locCd to set
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * @return the locCd
	 */
	public String getLocCd() {
		return locCd;
	}

	/**
	 * @param chkTp the chkTp to set
	 */
	public void setChkTp(String chkTp) {
		this.chkTp = chkTp;
	}

	/**
	 * @return the chkTp
	 */
	public String getChkTp() {
		return chkTp;
	}

}