/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0002Event.java
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event;

import java.util.Arrays;

import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgSalesRepVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustCoverTeamVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.MoreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamActivityInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustHistVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustPreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchKeyManVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmCustAddrVO;



/**
 * ESM_SAM_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONGJINHO
 * @see ESM_SAM_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerVO searchCustomerVO = null;
	private SearchKeyManVO searchKeyManVO = null;
	private MdmCustAddrVO mdmCustAddrVO = null;
	private SamCustPreInfoVO samCustPreInfoVO = null;
	private CustCoverTeamVO custCoverTeamVO = null;
	private SamActivityInfoVO samActivityInfoVO = null;
	private MoreInfoVO moreInfoVO = null;
	private SamCustHistVO samCustHistVO = null;
	private BkgSalesRepVO bkgSalesRepVO = null;
	

	
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerVO[] searchCustomerVOs = null;
	private SearchKeyManVO[] searchKeyManVOs = null;
	private MdmCustAddrVO[] mdmCustAddrVOs = null;
	private String customerCode = ""; 
	private SamCustPreInfoVO[] samCustPreInfoVOs = null;
	private CustCoverTeamVO[] custCoverTeamVOs = null;
	private SamActivityInfoVO[] samActivityInfoVOs = null;
	private MoreInfoVO[] moreInfoVOs = null;
	private SamCustHistVO[] samCustHistVOs = null;
	private BkgSalesRepVO[] bkgSalesRepVOs = null;
	private String Check_String = ""; 
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerAddressVO customerAddressVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerAddressVO[] customerAddressVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCustomerVO mdmCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCustomerVO[] mdmCustomerVOs = null;
	
	
	
	
	/**
	 * @return the custCntCd
	 */
	public String getCustomerCode() {
		return customerCode;                 
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;        
	}

	public EsmSam0002Event(){}
	
	public void setSearchCustomerVO(SearchCustomerVO searchCustomerVO){
		this. searchCustomerVO = searchCustomerVO;
	}

	public void setSearchCustomerVOS(SearchCustomerVO[] searchCustomerVOs){
		if(searchCustomerVOs != null){
			SearchCustomerVO[] tmpVOs = Arrays.copyOf(searchCustomerVOs, searchCustomerVOs.length);
			this.searchCustomerVOs = tmpVOs;
		}
	}

	public SearchCustomerVO getSearchCustomerVO(){
		return searchCustomerVO;
	}

	public SearchCustomerVO[] getSearchCustomerVOS(){
		SearchCustomerVO[] rtnVOs = null;
		if (this.searchCustomerVOs != null) {
			rtnVOs = Arrays.copyOf(searchCustomerVOs, searchCustomerVOs.length);
		}
		return rtnVOs;
	}
	
	public void setBkgSalesRepVO(BkgSalesRepVO bkgSalesRepVO){
		this. bkgSalesRepVO = bkgSalesRepVO;
	}

	public void setBkgSalesRepVOS(BkgSalesRepVO[] bkgSalesRepVOs){
		if(bkgSalesRepVOs != null){
			BkgSalesRepVO[] tmpVOs = Arrays.copyOf(bkgSalesRepVOs, bkgSalesRepVOs.length);
			this.bkgSalesRepVOs = tmpVOs;
		}
	}

	public BkgSalesRepVO getBkgSalesRepVO(){
		return bkgSalesRepVO;
	}

	public BkgSalesRepVO[] getBkgSalesRepVOS(){
		BkgSalesRepVO[] rtnVOs = null;
		if (this.bkgSalesRepVOs != null) {
			rtnVOs = Arrays.copyOf(bkgSalesRepVOs, bkgSalesRepVOs.length);
		}
		return rtnVOs;
	}
	
	public void setMoreInfoVO(MoreInfoVO moreInfoVO){
		this. moreInfoVO = moreInfoVO;
	}

	public void setMoreInfoVOS(MoreInfoVO[] moreInfoVOs){
		if(moreInfoVOs != null){
			MoreInfoVO[] tmpVOs = Arrays.copyOf(moreInfoVOs, moreInfoVOs.length);
			this.moreInfoVOs = tmpVOs;
		}
	}

	public MoreInfoVO getMoreInfoVO(){
		return moreInfoVO;
	}

	public MoreInfoVO[] getMoreInfoVOS(){
		MoreInfoVO[] rtnVOs = null;
		if (this.moreInfoVOs != null) {
			rtnVOs = Arrays.copyOf(moreInfoVOs, moreInfoVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustCoverTeamVO(CustCoverTeamVO custCoverTeamVO){
		this. custCoverTeamVO = custCoverTeamVO;
	}

	public void setCustCoverTeamVOS(CustCoverTeamVO[] custCoverTeamVOs){
		if(custCoverTeamVOs != null){
			CustCoverTeamVO[] tmpVOs = Arrays.copyOf(custCoverTeamVOs, custCoverTeamVOs.length);
			this.custCoverTeamVOs = tmpVOs;
		}
	}

	public CustCoverTeamVO getCustCoverTeamVO(){
		return custCoverTeamVO;
	}

	public CustCoverTeamVO[] getCustCoverTeamVOS(){
		CustCoverTeamVO[] rtnVOs = null;
		if (this.custCoverTeamVOs != null) {
			rtnVOs = Arrays.copyOf(custCoverTeamVOs, custCoverTeamVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSamActivityInfoVO(SamActivityInfoVO samActivityInfoVO){
		this. samActivityInfoVO = samActivityInfoVO;
	}

	public void setSamActivityInfoVOS(SamActivityInfoVO[] samActivityInfoVOs){
		if(samActivityInfoVOs != null){
			SamActivityInfoVO[] tmpVOs = Arrays.copyOf(samActivityInfoVOs, samActivityInfoVOs.length);
			this.samActivityInfoVOs = tmpVOs;
		}
	}

	public SamActivityInfoVO getSamActivityInfoVO(){
		return samActivityInfoVO;
	}

	public SamActivityInfoVO[] getSamActivityInfoVOS(){
		SamActivityInfoVO[] rtnVOs = null;
		if (this.samActivityInfoVOs != null) {
			rtnVOs = Arrays.copyOf(samActivityInfoVOs, samActivityInfoVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSamCustHistVO(SamCustHistVO samCustHistVO){
		this. samCustHistVO = samCustHistVO;
	}

	public void setSamCustHistVOS(SamCustHistVO[] samCustHistVOs){
		if(samCustHistVOs != null){
			SamCustHistVO[] tmpVOs = Arrays.copyOf(samCustHistVOs, samCustHistVOs.length);
			this.samCustHistVOs = tmpVOs;
		}
	}

	public SamCustHistVO getSamCustHistVO(){
		return samCustHistVO;
	}

	public SamCustHistVO[] getSamCustHistVOS(){
		SamCustHistVO[] rtnVOs = null;
		if (this.samCustHistVOs != null) {
			rtnVOs = Arrays.copyOf(samCustHistVOs, samCustHistVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSamCustPreInfoVO(SamCustPreInfoVO samCustPreInfoVO){
		this. samCustPreInfoVO = samCustPreInfoVO;
	}

	public void setSamCustPreInfoVOS(SamCustPreInfoVO[] samCustPreInfoVOs){
		if(samCustPreInfoVOs != null){
			SamCustPreInfoVO[] tmpVOs = Arrays.copyOf(samCustPreInfoVOs, samCustPreInfoVOs.length);
			this.samCustPreInfoVOs = tmpVOs;
		}
	}

	public SamCustPreInfoVO getSamCustPreInfoVO(){
		return samCustPreInfoVO;
	}

	public SamCustPreInfoVO[] getSamCustPreInfoVOS(){
		SamCustPreInfoVO[] rtnVOs = null;
		if (this.samCustPreInfoVOs != null) {
			rtnVOs = Arrays.copyOf(samCustPreInfoVOs, samCustPreInfoVOs.length);
		}
		return rtnVOs;
	}
	
	
	public void setMdmCustAddrVO(MdmCustAddrVO mdmCustAddrVO){
		this. mdmCustAddrVO = mdmCustAddrVO;
	}

	public void setMdmCustAddrVOS(MdmCustAddrVO[] mdmCustAddrVOs){
		if(mdmCustAddrVOs != null){
			MdmCustAddrVO[] tmpVOs = Arrays.copyOf(mdmCustAddrVOs, mdmCustAddrVOs.length);
			this.mdmCustAddrVOs = tmpVOs;
		}
	}

	public MdmCustAddrVO getMdmCustAddrVO(){
		return mdmCustAddrVO;
	}

	public MdmCustAddrVO[] getMdmCustAddrVOS(){
		MdmCustAddrVO[] rtnVOs = null;
		if (this.mdmCustAddrVOs != null) {
			rtnVOs = Arrays.copyOf(mdmCustAddrVOs, mdmCustAddrVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSearchKeyManVO(SearchKeyManVO searchKeyManVO){
		this. searchKeyManVO = searchKeyManVO;
	}

	public void setSearchKeyManVOS(SearchKeyManVO[] searchKeyManVOs){
		if(searchKeyManVOs != null){
			SearchKeyManVO[] tmpVOs =  Arrays.copyOf(searchKeyManVOs, searchKeyManVOs.length);
			this.searchKeyManVOs = tmpVOs;
		}
	}

	public SearchKeyManVO getSearchKeyManVO(){
		return searchKeyManVO;
	}

	public SearchKeyManVO[] getSearchKeyManVOS(){
		SearchKeyManVO[] rtnVOs = null;
		if (this.searchKeyManVOs != null) {
			rtnVOs = Arrays.copyOf(searchKeyManVOs, searchKeyManVOs.length);
		}
		return rtnVOs;
	}

	public CustomerAddressVO getCustomerAddressVO() {
		return customerAddressVO;
	}

	public void setCustomerAddressVO(CustomerAddressVO customerAddressVO) {
		this.customerAddressVO = customerAddressVO;
	}

	public CustomerAddressVO[] getCustomerAddressVOs() {
		CustomerAddressVO[] rtnVOs = null;
		if (this.customerAddressVOs != null) {
			rtnVOs = Arrays.copyOf(customerAddressVOs, customerAddressVOs.length);
		}
		return rtnVOs;
	}

	public void setCustomerAddressVOs(CustomerAddressVO[] customerAddressVOs) {
		if(customerAddressVOs != null){
			CustomerAddressVO[] tmpVOs = Arrays.copyOf(customerAddressVOs, customerAddressVOs.length);
			this.customerAddressVOs = tmpVOs;
		}
	}
	
	public String getCheck_String() {
		return Check_String;
	}

	public void setCheck_String(String check_String) {
		Check_String = check_String;
	}

	public MdmCustomerVO getMdmCustomerVO() {
		return mdmCustomerVO;
	}

	public void setMdmCustomerVO(MdmCustomerVO mdmCustomerVO) {
		this.mdmCustomerVO = mdmCustomerVO;
	}

	public MdmCustomerVO[] getMdmCustomerVOs() {
		MdmCustomerVO[] rtnVOs = null;
		if (this.mdmCustomerVOs != null) {
			rtnVOs = Arrays.copyOf(mdmCustomerVOs, mdmCustomerVOs.length);
		}
		return rtnVOs;
	}

	public void setMdmCustomerVOs(MdmCustomerVO[] mdmCustomerVOs) {
		if(mdmCustomerVOs != null){
			MdmCustomerVO[] tmpVOs = Arrays.copyOf(mdmCustomerVOs, mdmCustomerVOs.length);
			this.mdmCustomerVOs = tmpVOs;
		}
	}
	
	


}