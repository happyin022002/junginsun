/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0652Event.java
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.04 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgMdmCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CustSrepVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgCustCntcPsonVO;


/**
 * ESM_BKG_0652 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0652HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Byung Kyu
 * @see ESM_BKG_0652HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0652Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCustCntcPsonVO bkgCustCntcPsonVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgCustCntcPsonVO[] bkgCustCntcPsonVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCreCustomerVO bkgCreCustCntrVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgCreCustomerVO[] bkgCreCustCntrVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustSrepVO custSrepVO = null;

	/** Table Value Object Multi Data 처리 */
	private CustSrepVO[] custSrepVOs = null;

	private String custCntCd	 			= null;
	private String custSeq 				= null;
	private String detailCustCntCd	 	= null;
	private String detailCustSeq 		= null;
	private String custNm 				= null;
	private String ofcCd 					= null;
	private String locCd 					= null;

	private BkgMdmCustomerVO bkgMdmCustomerVO = null;
	
	public EsmBkg0652Event(){}

	public void setBkgCustCntcPsonVO(BkgCustCntcPsonVO bkgCustCntcPsonVO){
		this. bkgCustCntcPsonVO = bkgCustCntcPsonVO;
	}

	public void setBkgCustCntcPsonVOS(BkgCustCntcPsonVO[] bkgCustCntcPsonVOs){
		if (bkgCustCntcPsonVOs != null) {
			BkgCustCntcPsonVO[] tmpVOs = Arrays.copyOf(bkgCustCntcPsonVOs, bkgCustCntcPsonVOs .length);
			this. bkgCustCntcPsonVOs = tmpVOs;
		}
	}

	public void setBkgCreCustCntrVO(BkgCreCustomerVO bkgCreCustCntrVO){
		this. bkgCreCustCntrVO = bkgCreCustCntrVO;
	}

	public void setBkgCreCustCntrVOS(BkgCreCustomerVO[] bkgCreCustCntrVOs){
		if (bkgCreCustCntrVOs != null) {
			BkgCreCustomerVO[] tmpVOs = Arrays.copyOf(bkgCreCustCntrVOs, bkgCreCustCntrVOs .length);
			this. bkgCreCustCntrVOs = tmpVOs;
		}
	}

	public void setCustSrepVO(CustSrepVO custSrepVO){
		this. custSrepVO = custSrepVO;
	}

	public void setCustSrepVOS(CustSrepVO[] custSrepVOs){
		if (custSrepVOs != null) {
			CustSrepVO[] tmpVOs = Arrays.copyOf(custSrepVOs, custSrepVOs .length);
			this. custSrepVOs = tmpVOs;
		}
	}

	public void setCustCntCd(String custCntCd){
		this. custCntCd = custCntCd;
	}

	public void setCustSeq(String custSeq){
		this. custSeq = custSeq;
	}

	public void setDetailCustCntCd(String detailCustCntCd){
		this. detailCustCntCd = detailCustCntCd;
	}

	public void setDetailCustSeq(String detailCustSeq){
		this. detailCustSeq = detailCustSeq;
	}

	public void setCustNm(String custNm){
		this. custNm = custNm;
	}
	
	public void setLocCd(String locCd){
		this. locCd = locCd;
	}

	public void setOfcCd(String ofcCd){
		this. ofcCd = ofcCd;
	}

	public BkgCustCntcPsonVO getBkgCustCntcPsonVO(){
		return bkgCustCntcPsonVO;
	}

	public BkgCustCntcPsonVO[] getBkgCustCntcPsonVOS(){
		BkgCustCntcPsonVO[] tmpVOs = null;
		if (this. bkgCustCntcPsonVOs != null) {
			tmpVOs = Arrays.copyOf(bkgCustCntcPsonVOs, bkgCustCntcPsonVOs .length);
		}
		return tmpVOs;
	}

	public BkgCreCustomerVO getBkgCreCustCntrVO(){
		return bkgCreCustCntrVO;
	}

	public BkgCreCustomerVO[] getBkgCreCustCntrVOS(){
		BkgCreCustomerVO[] tmpVOs = null;
		if (this. bkgCreCustCntrVOs != null) {
			tmpVOs = Arrays.copyOf(bkgCreCustCntrVOs, bkgCreCustCntrVOs .length);
		}
		return tmpVOs;
	}

	public CustSrepVO getCustSrepVO(){
		return custSrepVO;
	}

	public CustSrepVO[] getCustSrepVOs(){
		CustSrepVO[] tmpVOs = null;
		if (this. custSrepVOs != null) {
			tmpVOs = Arrays.copyOf(custSrepVOs, custSrepVOs .length);
		}
		return tmpVOs;
	}

	public String getCustCntCd(){
		return custCntCd;
	}

	public String getCustSeq(){
		return custSeq;
	}

	public String getDetailCustCntCd(){
		return detailCustCntCd;
	}

	public String getDetailCustSeq(){
		return detailCustSeq;
	}

	public String getCustNm(){
		return custNm;
	}
	
	public String getOfcCd(){
		return ofcCd;
	}

	public String getLocCd(){
		return locCd;
	}

	public BkgMdmCustomerVO getBkgMdmCustomerVO() {
		return bkgMdmCustomerVO;
	}

	public void setBkgMdmCustomerVO(BkgMdmCustomerVO bkgMdmCustomerVO) {
		this.bkgMdmCustomerVO = bkgMdmCustomerVO;
	}
	
}