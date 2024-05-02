/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0411Event.java
*@FileTitle : Pick up Notice Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.06.12 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcHrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupWdVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgPkupNtcStupVO;


/**
 * ESM_BKG_0411 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0411HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
 * @see ESM_BKG_0411HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0411Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** PickUp Notice Send Type Code(A:Auto, M:Manual) */
	private String ntcSndTpCd = "";
	
	/** Office Code */
	private String ofcCd = "";
	
	/** DEL Code */
	private String delCd = ""; 
	
	/** PickUp Notice Sequence No. */
	private String pkupNtcSeq = ""; // 전체 삭제 시 이용

	/** PickUp Notice Setup Table Value Object 조회 조건 및 단건 처리  */
	private BkgPkupNtcStupVO bkgPkupNtcStupVO = null;
	
	/** PickUp Notice Word Table Value Object Multi Data 처리 */
	private PkupWdVO[] bkgPkupWdVOs = null;
		
	/** PickUp Notice Hour Table Value Object Multi Data 처리 */
	private PkupNtcHrVO[] bkgPkupNtcHrVOs = null;
	

	public EsmBkg0411Event(){}
	
	
	/**
	 * @param pkUpNtcSndTpCd the pkUpNtcSndTpCd to set
	 */
	public void setNtcSndTpCd(String ntcSndTpCd) {
		this.ntcSndTpCd = ntcSndTpCd;
	}
	
	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @param delCd the delCd to set
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * @param pkupNtcSeq the pkupNtcSeq to set
	 */
	public void setPkupNtcSeq(String pkupNtcSeq) {
		this.pkupNtcSeq = pkupNtcSeq;
	}
	
	/**
	 * @param bkgPkupNtcStupVO
	 */
	public void setBkgPkupNtcStupVO(BkgPkupNtcStupVO bkgPkupNtcStupVO){
		this. bkgPkupNtcStupVO = bkgPkupNtcStupVO;
	}

	/**
	 * @param bkgPkupWdVOs the bkgPkupWdVOs to set
	 */
	public void setBkgPkupWdVOs(PkupWdVO[] bkgPkupWdVOs) {
		this.bkgPkupWdVOs = bkgPkupWdVOs;
	}

	/**
	 * @param bkgPkupNtcHrVOs the bkgPkupNtcHrVOs to set
	 */
	public void setBkgPkupNtcHrVOs(PkupNtcHrVO[] bkgPkupNtcHrVOs) {
		this.bkgPkupNtcHrVOs = bkgPkupNtcHrVOs;
	}
	

	/**
	 * @return the pkUpNtcSndTpCd
	 */
	public String getNtcSndTpCd() {
		return ntcSndTpCd;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}
	
	/**
	 * @return the delCd
	 */
	public String getDelCd() {
		return delCd;
	}
	
	/**
	 * @return the pkupNtcSeq
	 */
	public String getPkupNtcSeq() {
		return pkupNtcSeq;
	}
	
	/**
	 * @return
	 */
	public BkgPkupNtcStupVO getBkgPkupNtcStupVO(){
		return bkgPkupNtcStupVO;
	}

	/**
	 * @return the bkgPkupWdVOs
	 */
	public PkupWdVO[] getBkgPkupWdVOs() {
		return bkgPkupWdVOs;
	}

	/**
	 * @return the bkgPkupNtcHrVOs
	 */
	public PkupNtcHrVO[] getBkgPkupNtcHrVOs() {
		return bkgPkupNtcHrVOs;
	}	
}