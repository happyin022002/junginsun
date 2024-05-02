/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0071Event.java
*@FileTitle : FNS_INV_0071
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.15 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.MRIInputVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0071 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0071HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0071Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String svrId = null;
	private String rhqCd = null;
	private String ofcCd = null;
	private String blNo = null;
	private String bkgNo = null;
	private String bnd = null;
	private String chgCd = null;	
	private String arIfNo = null;
	private String locCd = null;
	private String effDt = null;
	private String masterInv = null;
	
	private String pageType = null;		
	
	private MRIInputVO mriInputVO = null;
	private VVDCustomerVO vvdCustomerVo = null;
	
	private String mstIfNo = null;
	
	
	/**
	 * @return the mstIfNo
	 */
	public String getMstIfNo() {
		return mstIfNo;
	}

	/**
	 * @param mstIfNo the mstIfNo to set
	 */
	public void setMstIfNo(String mstIfNo) {
		this.mstIfNo = mstIfNo;
	}

	public String getSvrId() {
		return svrId;
	}

	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}

	public String getRhqCd() {
		return rhqCd;
	}

	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}	

	public String getBnd() {
		return bnd;
	}

	public void setBnd(String bnd) {
		this.bnd = bnd;
	}	
	
	public String getChgCd() {
		return chgCd;
	}

	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}

	/**
	 * @return the arIfNo
	 */
	public String getArIfNo() {
		return arIfNo;
	}

	/**
	 * @param arIfNo the arIfNo to set
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}

	/**
	 * @return the locCd
	 */
	public String getLocCd() {
		return locCd;
	}

	/**
	 * @param locCd the locCd to set
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * @return the effDt
	 */
	public String getEffDt() {
		return effDt;
	}

	/**
	 * @param effDt the effDt to set
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	public String getMasterInv() {
		return masterInv;
	}

	public void setMasterInv(String masterInv) {
		this.masterInv = masterInv;
	}

	public MRIInputVO getMriInputVO() {
		return mriInputVO;
	}

	public void setMriInputVO(MRIInputVO mriInputVO) {
		this.mriInputVO = mriInputVO;
	}    

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	
	public VVDCustomerVO getVvdCustomerVo() {
		return vvdCustomerVo;
	}

	public void setVvdCustomerVo(VVDCustomerVO vvdCustomerVo) {
		this.vvdCustomerVo = vvdCustomerVo;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceCreationVO aRInvoiceCreationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceCreationVO[] aRInvoiceCreationVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BKGInvoiceVO bKGInvoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BKGInvoiceVO[] bKGInvoiceVOs = null;

	public FnsInv0071Event(){}
	
	public void setARInvoiceCreationVO(ARInvoiceCreationVO aRInvoiceCreationVO){
		this. aRInvoiceCreationVO = aRInvoiceCreationVO;
	}

	public void setARInvoiceCreationVOS(ARInvoiceCreationVO[] aRInvoiceCreationVOs){
		if (aRInvoiceCreationVOs != null) {
			ARInvoiceCreationVO[] tmpVOs = new ARInvoiceCreationVO[aRInvoiceCreationVOs.length];
			System.arraycopy(aRInvoiceCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceCreationVOs = tmpVOs;
		}
	}

	public void setBKGInvoiceVO(BKGInvoiceVO bKGInvoiceVO){
		this. bKGInvoiceVO = bKGInvoiceVO;
	}

	public void setBKGInvoiceVOS(BKGInvoiceVO[] bKGInvoiceVOs){
		if (bKGInvoiceVOs != null) {
			BKGInvoiceVO[] tmpVOs = new BKGInvoiceVO[bKGInvoiceVOs.length];
			System.arraycopy(bKGInvoiceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bKGInvoiceVOs = tmpVOs;
		}
	}

	public ARInvoiceCreationVO getARInvoiceCreationVO(){
		return aRInvoiceCreationVO;
	}

	public ARInvoiceCreationVO[] getARInvoiceCreationVOS(){
		ARInvoiceCreationVO[] rtnVOs = null;
		if (this.aRInvoiceCreationVOs != null) {
			rtnVOs = new ARInvoiceCreationVO[aRInvoiceCreationVOs.length];
			System.arraycopy(aRInvoiceCreationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public BKGInvoiceVO getBKGInvoiceVO(){
		return bKGInvoiceVO;
	}

	public BKGInvoiceVO[] getBKGInvoiceVOS(){
		BKGInvoiceVO[] rtnVOs = null;
		if (this.bKGInvoiceVOs != null) {
			rtnVOs = new BKGInvoiceVO[bKGInvoiceVOs.length];
			System.arraycopy(bKGInvoiceVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}