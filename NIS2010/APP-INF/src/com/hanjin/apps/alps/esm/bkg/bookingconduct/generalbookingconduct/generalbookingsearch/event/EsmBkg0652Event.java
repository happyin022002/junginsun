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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCreCustInqCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CustSrepVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCustCntcPsonVO;


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
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCreCustInqCondVO bkgCreCustInqCondVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCreCustInqCondVO[] bkgCreCustInqCondVOs = null;
	

	private String custCntCd	 			= null;
	private String custSeq 				= null;
	private String detailCustCntCd	 	= null;
	private String detailCustSeq 		= null;
	private String custNm 				= null;
	private String ofcCd 					= null;


	public EsmBkg0652Event(){}

	public void setBkgCustCntcPsonVO(BkgCustCntcPsonVO bkgCustCntcPsonVO){
		this. bkgCustCntcPsonVO = bkgCustCntcPsonVO;
	}

	public void setBkgCustCntcPsonVOS(BkgCustCntcPsonVO[] bkgCustCntcPsonVOs){
		this. bkgCustCntcPsonVOs = bkgCustCntcPsonVOs;
	}
	
	public void setBkgCreCustInqCondVO(BkgCreCustInqCondVO bkgCreCustInqCondVO){
		this. bkgCreCustInqCondVO = bkgCreCustInqCondVO;
	}

	public void setBkgCreCustInqCondVOS(BkgCreCustInqCondVO[] bkgCreCustInqCondVOs){
		this. bkgCreCustInqCondVOs = bkgCreCustInqCondVOs;
	}

	public void setBkgCreCustCntrVO(BkgCreCustomerVO bkgCreCustCntrVO){
		this. bkgCreCustCntrVO = bkgCreCustCntrVO;
	}

	public void setBkgCreCustCntrVOS(BkgCreCustomerVO[] bkgCreCustCntrVOs){
		this. bkgCreCustCntrVOs = bkgCreCustCntrVOs;
	}

	public void setCustSrepVO(CustSrepVO custSrepVO){
		this. custSrepVO = custSrepVO;
	}

	public void setCustSrepVOS(CustSrepVO[] custSrepVOs){
		this. custSrepVOs = custSrepVOs;
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

	public void setOfcCd(String ofcCd){
		this. ofcCd = ofcCd;
	}

	public BkgCustCntcPsonVO getBkgCustCntcPsonVO(){
		return bkgCustCntcPsonVO;
	}

	public BkgCustCntcPsonVO[] getBkgCustCntcPsonVOS(){
		return bkgCustCntcPsonVOs;
	}
	
	public BkgCreCustInqCondVO getBkgCreCustInqCondVO(){
		return bkgCreCustInqCondVO;
	}

	public BkgCreCustInqCondVO[] getBkgCreCustInqCondVOS(){
		return bkgCreCustInqCondVOs;
	}


	public BkgCreCustomerVO getBkgCreCustCntrVO(){
		return bkgCreCustCntrVO;
	}

	public BkgCreCustomerVO[] getBkgCreCustCntrVOS(){
		return bkgCreCustCntrVOs;
	}

	public CustSrepVO getCustSrepVO(){
		return custSrepVO;
	}

	public CustSrepVO[] getCustSrepVOs(){
		return custSrepVOs;
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
}