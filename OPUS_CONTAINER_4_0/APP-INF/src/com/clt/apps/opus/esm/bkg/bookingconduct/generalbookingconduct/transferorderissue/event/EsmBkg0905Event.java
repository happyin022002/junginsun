/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0905Event.java
*@FileTitle : TRO-Container Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroActCustExtVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgTroActCustVO;
import com.clt.syscommon.common.table.BkgTroActRepVO;


/**
 * ESM_BKG_0905 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0905HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0905HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0905Event extends EventSupport {

	private static final long serialVersionUID = 2378968962113618873L;

	/** param 용 */
	private String contiCd      = null;
	private String cntCd        = null;
	private String vndrSeq      = null;  
	private String bkgNo        = null;
	private String dorLocCd     = null;
	private String actShprCntCd = null;
	private String actShprSeq   = null;
	private String actShprNm    = null;

	private String custCntCd       = null;
	private String custSeq         = null;
	private String custNm          = null;  //cust_lgl_eng_nm, 
	private String ofcCd           = null;
	private String troActCustKndCd = null;
	private String troActRepSeq    = null;
	private String type			   = null;
		
	private BkgBlNoVO bkgBlNoVO = null;


	/** Table Value Object 조회 조건 및 단건 처리  */
	//private BkgMdmCustomerCndiVO bkgMdmCustomerCndiVO = null;
	private BkgTroActCustExtVO   bkgTroActCustExtVO  = null;
	//private BkgTroActRepCndiVO   bkgTroActRepCndiVO  = null;


	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgTroActCustVO bkgTroActCustVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgTroActCustVO[] bkgTroActCustVOS = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgTroActRepVO bkgTroActRepVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgTroActRepVO[] bkgTroActRepVOS = null;


	/* container VO */
	private TroActCustVO troActCustVO = null;	//TroActCustVO -> TroActCustVO


	public BkgTroActCustExtVO getBkgTroActCustExtVO() {
		return bkgTroActCustExtVO;
	}
	public void setBkgTroActCustExtVO(BkgTroActCustExtVO bkgTroActCustExtVO) {
		this.bkgTroActCustExtVO = bkgTroActCustExtVO;
	}
	public BkgTroActCustVO getBkgTroActCustVO() {
		return bkgTroActCustVO;
	}
	public void setBkgTroActCustVO(BkgTroActCustVO bkgTroActCustVO) {
		this.bkgTroActCustVO = bkgTroActCustVO;
	}
	public BkgTroActCustVO[] getBkgTroActCustVOS() {
		BkgTroActCustVO[] tmpVOs = null;
		if (this. bkgTroActCustVOS != null) {
			tmpVOs = Arrays.copyOf(bkgTroActCustVOS, bkgTroActCustVOS .length);
		}
		return tmpVOs;
	}
	public void setBkgTroActCustVOS(BkgTroActCustVO[] bkgTroActCustVOS) {
		if (bkgTroActCustVOS != null) {
			BkgTroActCustVO[] tmpVOs = Arrays.copyOf(bkgTroActCustVOS, bkgTroActCustVOS .length);
			this. bkgTroActCustVOS = tmpVOs;
		}
	}
	public BkgTroActRepVO getBkgTroActRepVO() {
		return bkgTroActRepVO;
	}
	public void setBkgTroActRepVO(BkgTroActRepVO bkgTroActRepVO) {
		this.bkgTroActRepVO = bkgTroActRepVO;
	}
	public BkgTroActRepVO[] getBkgTroActRepVOS() {
		BkgTroActRepVO[] tmpVOs = null;
		if (this. bkgTroActRepVOS != null) {
			tmpVOs = Arrays.copyOf(bkgTroActRepVOS, bkgTroActRepVOS .length);
		}
		return tmpVOs;
	}
	public void setBkgTroActRepVOS(BkgTroActRepVO[] bkgTroActRepVOS) {
		if (bkgTroActRepVOS != null) {
			BkgTroActRepVO[] tmpVOs = Arrays.copyOf(bkgTroActRepVOS, bkgTroActRepVOS .length);
			this. bkgTroActRepVOS = tmpVOs;
		}
	}

	public TroActCustVO getTroActCustVO() {
		return troActCustVO;
	}
	public void setTroActCustVO(TroActCustVO troActCustVO) {
		this.troActCustVO = troActCustVO;
	}
	
	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	/**
	 * @return the contiCd
	 */
	public String getContiCd() {
		return contiCd;
	}
	/**
	 * @param contiCd the contiCd to set
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	/**
	 * @return the cntCd
	 */
	public String getCntCd() {
		return cntCd;
	}
	/**
	 * @param cntCd the cntCd to set
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	/**
	 * @return the vndrSeq
	 */
	public String getVndrSeq() {
		return vndrSeq;
	}
	/**
	 * @param vndrSeq the vndrSeq to set
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
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
	 * @return the dorLocCd
	 */
	public String getDorLocCd() {
		return dorLocCd;
	}
	/**
	 * @param dorLocCd the dorLocCd to set
	 */
	public void setDorLocCd(String dorLocCd) {
		this.dorLocCd = dorLocCd;
	}
	/**
	 * @return the actShprCntCd
	 */
	public String getActShprCntCd() {
		return actShprCntCd;
	}
	/**
	 * @param actShprCntCd the actShprCntCd to set
	 */
	public void setActShprCntCd(String actShprCntCd) {
		this.actShprCntCd = actShprCntCd;
	}
	/**
	 * @return the actShprSeq
	 */
	public String getActShprSeq() {
		return actShprSeq;
	}
	/**
	 * @param actShprSeq the actShprSeq to set
	 */
	public void setActShprSeq(String actShprSeq) {
		this.actShprSeq = actShprSeq;
	}
	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}
	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}
	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	/**
	 * @return the custNm
	 */
	public String getCustNm() {
		return custNm;
	}
	/**
	 * @param custNm the custNm to set
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}
	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	/**
	 * @return the troActCustKndCd
	 */
	public String getTroActCustKndCd() {
		return troActCustKndCd;
	}
	/**
	 * @param troActCustKndCd the troActCustKndCd to set
	 */
	public void setTroActCustKndCd(String troActCustKndCd) {
		this.troActCustKndCd = troActCustKndCd;
	}
	/**
	 * @return the troActRepSeq
	 */
	public String getTroActRepSeq() {
		return troActRepSeq;
	}
	/**
	 * @param troActRepSeq the troActRepSeq to set
	 */
	public void setTroActRepSeq(String troActRepSeq) {
		this.troActRepSeq = troActRepSeq;
	}
	/**
	 * @return the actShprNm
	 */
	public String getActShprNm() {
		return actShprNm;
	}
	
	/**
	 * @param actShprNm the actShprNm to set
	 */
	public void setActShprNm(String actShprNm) {
		this.actShprNm = actShprNm;
	}
	
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the actShprNm to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}