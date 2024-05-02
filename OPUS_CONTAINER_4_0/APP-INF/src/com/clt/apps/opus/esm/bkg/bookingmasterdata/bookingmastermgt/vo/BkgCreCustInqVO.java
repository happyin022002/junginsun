/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCreCustInqVO.java
*@FileTitle : BkgCreCustInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.04 김병규 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.syscommon.common.table.BkgCustCntcPsonVO;


public class BkgCreCustInqVO {
	
	List<BkgCreCustomerVO> bkgCreCustomer 	= new ArrayList<BkgCreCustomerVO>();
	List<BkgCustCntcPsonVO> bkgCustCntcPson 		= new ArrayList<BkgCustCntcPsonVO>();
	List<CustSrepVO> custSrep = new ArrayList<CustSrepVO>();
	
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCreCustomerVO[] bkgcrecustomervos = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCustCntcPsonVO[] bkgcustcntcpsonvos = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustSrepVO[] custsrepvos = null;
	
	
	
	public BkgCreCustomerVO[] getBkgCreCustomerVOs() {
		return bkgcrecustomervos;
	}
	public void setBkgCreCustomerVOs(BkgCreCustomerVO[] bkgcrecustomervos) {
		this.bkgcrecustomervos = bkgcrecustomervos;
	}
	public BkgCustCntcPsonVO[] getBkgCustCntcPsonVOs() {
		return bkgcustcntcpsonvos;
	}
	public void setBkgCustCntcPsonVOs(BkgCustCntcPsonVO[] bkgcustcntcpsonvos) {
		this.bkgcustcntcpsonvos = bkgcustcntcpsonvos;
	}
	public CustSrepVO[] getCustSrepVOs() {
		return custsrepvos;
	}
	public void setCustSrepVOs(CustSrepVO[] custsrepvos) {
		this.custsrepvos = custsrepvos;
	}
	
	public List<BkgCreCustomerVO> getBkgCreCustomer() {
		return bkgCreCustomer;
	}
	public void setBkgCreCustomerr(List<BkgCreCustomerVO> bkgCreCustomer) {
		this.bkgCreCustomer = bkgCreCustomer;
	}
	public List<BkgCustCntcPsonVO> getBkgCustCntcPson() {
		return bkgCustCntcPson;
	}
	public void setBkgCustCntcPson(List<BkgCustCntcPsonVO> bkgCustCntcPson) {
		this.bkgCustCntcPson = bkgCustCntcPson;
	}
	public List<CustSrepVO> getCustSrep() {
		return custSrep;
	}
	public void setCustSrep(List<CustSrepVO> custSrep) {
		this.custSrep = custSrep;
	}
	
}
