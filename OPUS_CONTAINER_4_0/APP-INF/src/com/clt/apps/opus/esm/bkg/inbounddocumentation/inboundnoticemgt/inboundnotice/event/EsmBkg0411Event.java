/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0411Event.java
*@FileTitle : Pick up Notice Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcHrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupWdVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgPkupNtcStupVO;


/**
 * ESM_BKG_0411 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0411HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
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
	 * @param bkgPkupNtcHrVOs the bkgPkupNtcHrVOs to set
	 */
//	public void setBkgPkupNtcHrVOs(PkupNtcHrVO[] bkgPkupNtcHrVOs) {
//		this.bkgPkupNtcHrVOs = bkgPkupNtcHrVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgPkupNtcHrVOs(PkupNtcHrVO[] bkgPkupNtcHrVOs) {
		if (bkgPkupNtcHrVOs != null) {
			PkupNtcHrVO[] tmpVOs = new PkupNtcHrVO[bkgPkupNtcHrVOs.length];
			System.arraycopy(bkgPkupNtcHrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgPkupNtcHrVOs = tmpVOs;
		}		
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
	
	/**
	 * @return the bkgPkupNtcHrVOs
	 */
//	public PkupNtcHrVO[] getBkgPkupNtcHrVOs() {
//		return bkgPkupNtcHrVOs;
//	}	
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public PkupNtcHrVO[] getBkgPkupNtcHrVOs() {
		PkupNtcHrVO[] tmpVOs = null;
		if (this.bkgPkupNtcHrVOs != null) {
			tmpVOs = new PkupNtcHrVO[bkgPkupNtcHrVOs.length];
			System.arraycopy(bkgPkupNtcHrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
}