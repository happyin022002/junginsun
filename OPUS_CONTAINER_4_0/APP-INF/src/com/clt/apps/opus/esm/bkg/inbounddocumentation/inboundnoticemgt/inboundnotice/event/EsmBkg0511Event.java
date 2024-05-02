/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0511Event.java
*@FileTitle : Hold Notice: Pre-Hold Notice Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HoldNoticeFormVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgHldWdDtlVO;
import com.clt.syscommon.common.table.BkgHldWdVO;


/**
 * ESM_BKG_0511 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0511HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0511HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0511Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Office Code */
	String ofcCd = "";
	
	/** POD Code */
	String podCd = "";
	
	/** Notice Type Code */
	String ntcTpCd = "";

	private BkgHldWdVO bkgHldWdVO = null;
	
	private BkgHldWdDtlVO bkgHldWdDtlVO = null;
	
	private BkgHldWdDtlVO[] bkgHldWdDtlVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private HoldNoticeFormVO holdNoticeFormVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private HoldNoticeFormVO[] holdNoticeFormVOs = null;

	public EsmBkg0511Event(){}


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
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}
	
	/**
	 * @param ntcTpCd the ntcTpCd to set
	 */
	public void setNtcTpCd(String ntcTpCd) {
		this.ntcTpCd = ntcTpCd;
	}

	/**
	 * @return the ntcTpCd
	 */
	public String getNtcTpCd() {
		return ntcTpCd;
	}

	/**
	 * @param holdNoticeFormVO the holdNoticeFormVO to set
	 */
	public void setHoldNoticeFormVO(HoldNoticeFormVO holdNoticeFormVO) {
		this.holdNoticeFormVO = holdNoticeFormVO;
	}
	
	/**
	 * @return the holdNoticeFormVO
	 */
	public HoldNoticeFormVO getHoldNoticeFormVO() {
		return holdNoticeFormVO;
	}

	/**
	 * @param holdNoticeFormVOs the holdNoticeFormVOs to set
	 */
//	public void setHoldNoticeFormVOs(HoldNoticeFormVO[] holdNoticeFormVOs) {
//		this.holdNoticeFormVOs = holdNoticeFormVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setHoldNoticeFormVOs(HoldNoticeFormVO[] holdNoticeFormVOs) {
		if (holdNoticeFormVOs != null) {
			HoldNoticeFormVO[] tmpVOs = new HoldNoticeFormVO[holdNoticeFormVOs.length];
			System.arraycopy(holdNoticeFormVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.holdNoticeFormVOs = tmpVOs;
		}		
	}
	
	/**
	 * @return the holdNoticeFormVOs
	 */
//	public HoldNoticeFormVO[] getHoldNoticeFormVOs() {
//		return holdNoticeFormVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public HoldNoticeFormVO[] getHoldNoticeFormVOs() {
		HoldNoticeFormVO[] tmpVOs = null;
		if (this.holdNoticeFormVOs != null) {
			tmpVOs = new HoldNoticeFormVO[holdNoticeFormVOs.length];
			System.arraycopy(holdNoticeFormVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	

	/**
	 * @param bkgHldWdVO the bkgHldWdVO to set
	 */
	public void setBkgHldWdVO(BkgHldWdVO bkgHldWdVO) {
		this.bkgHldWdVO = bkgHldWdVO;
	}


	/**
	 * @return the bkgHldWdVO
	 */
	public BkgHldWdVO getBkgHldWdVO() {
		return bkgHldWdVO;
	}


	/**
	 * @param bkgHldWdDtlVO the bkgHldWdDtlVO to set
	 */
	public void setBkgHldWdDtlVO(BkgHldWdDtlVO bkgHldWdDtlVO) {
		this.bkgHldWdDtlVO = bkgHldWdDtlVO;
	}

	/**
	 * @return the bkgHldWdDtlVO
	 */
	public BkgHldWdDtlVO getBkgHldWdDtlVO() {
		return bkgHldWdDtlVO;
	}


	/**
	 * @param bkgHldWdDtlVOs the bkgHldWdDtlVOs to set
	 */
//	public void setBkgHldWdDtlVOs(BkgHldWdDtlVO[] bkgHldWdDtlVOs) {
//		this.bkgHldWdDtlVOs = bkgHldWdDtlVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgHldWdDtlVOs(BkgHldWdDtlVO[] bkgHldWdDtlVOs) {
		if (bkgHldWdDtlVOs != null) {
			BkgHldWdDtlVO[] tmpVOs = new BkgHldWdDtlVO[bkgHldWdDtlVOs.length];
			System.arraycopy(bkgHldWdDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgHldWdDtlVOs = tmpVOs;
		}		
	} 

	/**
	 * @return the bkgHldWdDtlVOs
	 */
//	public BkgHldWdDtlVO[] getBkgHldWdDtlVOs() {
//		return bkgHldWdDtlVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgHldWdDtlVO[] getBkgHldWdDtlVOs() {
		BkgHldWdDtlVO[] tmpVOs = null;
		if (this.bkgHldWdDtlVOs != null) {
			tmpVOs = new BkgHldWdDtlVO[bkgHldWdDtlVOs.length];
			System.arraycopy(bkgHldWdDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	

}