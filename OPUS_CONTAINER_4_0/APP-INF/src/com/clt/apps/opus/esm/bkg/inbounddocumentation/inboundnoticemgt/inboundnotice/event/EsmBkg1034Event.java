/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1034Event.java
*@FileTitle : Pick-Up Notice Template(Manual Send)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupWdVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgPkupNtcStupVO;

/**
 * ESM_BKG_1034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
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
//	public void setBkgPkupWdVOs(PkupWdVO[] bkgPkupWdVOs) {
//		this.bkgPkupWdVOs = bkgPkupWdVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgPkupWdVOs(PkupWdVO[] bkgPkupWdVOs) {
		if (bkgPkupWdVOs != null) {
			PkupWdVO[] tmpVOs = new PkupWdVO[bkgPkupWdVOs.length];
			System.arraycopy(bkgPkupWdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgPkupWdVOs = tmpVOs;
		}		
	} 	

	/**
	 * @return the bkgPkupWdVOs
	 */
//	public PkupWdVO[] getBkgPkupWdVOs() {
//		return bkgPkupWdVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public PkupWdVO[] getBkgPkupWdVOs() {
		PkupWdVO[] tmpVOs = null;
		if (this.bkgPkupWdVOs != null) {
			tmpVOs = new PkupWdVO[bkgPkupWdVOs.length];
			System.arraycopy(bkgPkupWdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
	
}
