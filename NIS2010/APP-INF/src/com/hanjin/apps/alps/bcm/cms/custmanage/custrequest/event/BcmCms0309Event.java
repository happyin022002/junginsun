/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : BcmCms0309Event.java
*@FileTitle : customer
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.07
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.event;

import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CMS_0309 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CMS_0309HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CMS_0309HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCms0309Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerVO customerVO = null;
	
	private String custSeq = null;
	
	private String custCntCd = null;
	
	private String custCd = null;
		
	private String locCd = null;
	
	private String ofcCd = null;

	private String vndrSeq = null;
	
	private String capiCurrCd = null;
	
	private String prfRepCmdtCd = null;
	
	private String srepCd = null;
	
	private String custGrpId = null;
	
	private String trdCd = null;
	
	private String rqstNo = null;
	
	private String creflag = null;
	
	private String saveflag = null;
	
	private String custRgstNo = null;
	
    ///////////////////////////////////////
    
	private String isNewYn = null;

	public BcmCms0309Event(){}

	public void setRqstNo(String rqstNo){
		this.rqstNo = rqstNo;
	}
	
	public String getRqstNo(){
		return rqstNo;
	}

	public void setCreflag(String creflag){
		this.creflag = creflag;
	}
	
	public String getCreflag(){
		return creflag;
	}

	public void setSaveflag(String saveflag){
		this.saveflag = saveflag;
	}
	
	public String getSaveflag(){
		return saveflag;
	}

	public void setIsNewYn(String isNewYn){
		this.isNewYn = isNewYn;
	}
	
	public String getIsNewYn(){
		return isNewYn;
	}

	public void setCustSeq(String custSeq){
		this. custSeq = custSeq;
	}
	
	public String getCustSeq(){
		return custSeq;
	}
	
	public void setCustGrpId(String custGrpId){
		this. custGrpId = custGrpId;
	}
	
	public String getCustGrpId(){
		return custGrpId;
	}
	
	public void setSrepCd(String srepCd){
		this. srepCd = srepCd;
	}
	
	public String getSrepCd(){
		return srepCd;
	}
	
	public void setTrdCd(String trdCd){
		this. trdCd = trdCd;
	}
	
	public String getTrdCd(){
		return trdCd;
	}
	
	public void setCustCd(String custCd){
		this. custCd = custCd;
	}
	
	public String getCustCd(){
		return custCd;
	}
	
	public void setCapiCurrCd(String capiCurrCd){
		this. capiCurrCd = capiCurrCd;
	}
	
	public String getCapiCurrCd(){
		return capiCurrCd;
	}
	
	public void setPrfRepCmdtCd(String prfRepCmdtCd){
		this. prfRepCmdtCd = prfRepCmdtCd;
	}
	
	public String getPrfRepCmdtCd(){
		return prfRepCmdtCd;
	}
	
	public void setVndrSeq(String vndrSeq){
		this. vndrSeq = vndrSeq;
	}
	
	public String getVndrSeq(){
		return vndrSeq;
	}
	
	public void setLocCd(String locCd){
		this. locCd = locCd;
	}
	
	public String getLocCd(){
		return locCd;
	}
	
	public void setOfcCd(String ofcCd){
		this. ofcCd = ofcCd;
	}
	
	public String getOfcCd(){
		return ofcCd;
	}
	
	public void setCustCntCd(String custCntCd){
		this. custCntCd = custCntCd;
	}
	
	public String getCustCntCd(){
		return custCntCd;
	}
	
	public void setCustRgstNo(String custRgstNo){
		this. custRgstNo = custRgstNo;
	}
	
	public String getCustRgstNo(){
		return custRgstNo;
	}
	
	public void setCustomerVO(CustomerVO customerVO){
		this. customerVO = customerVO;
	}
	
	public CustomerVO getCustomerVO(){
		return customerVO;
	}
}