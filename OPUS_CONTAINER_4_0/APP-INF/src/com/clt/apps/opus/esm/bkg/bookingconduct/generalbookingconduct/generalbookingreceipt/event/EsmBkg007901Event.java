/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg007901Event.java
*@FileTitle : BKG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.PriRpHdrVO;

/**
 * ESM_BKG_0079_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0079_01HTMLAction 참조 
 * @since J2EE 1.4
 */

public class EsmBkg007901Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BookingCreationVO bookingCreationVO = null;
	private BookingSaveValidationVO bookingSaveValidationVO = null;
	private BkgUsrDfltSetVO bkgUserDfltSetVO = null;
	private BkgBlNoVO bkgBlNoVO = null;
	private VslSkdVO vslSkdVO = null;
	private BkgVvdVO bkgVvdVO = null;
	private BkgBookingInfoVO bkgBookingInfoVO = null;
	private BkgQuantityVO bkgQuantityVO = null;
	private BlCustomerInfoVO blCustomerInfoVO = null;
	private BkgQtyDtlVO bkgQtyDtlVO = null;
	private PriRpHdrVO priRpHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BookingCreationVO[] bookingCreationVOs = null;

	private VslSkdVO[] vslSkdVOs = null;
	private BkgVvdVO[] bkgVvdVOs = null;
	private BkgQuantityVO[] bkgQuantityVOs = null;
	private BkgQtyDtlVO[] bkgQtyDtlVOs = null;

	private String cmdtCd = null;
	private String newStsCd = null;
	private String pctlNo = null;
	
	private String caRsnCd = null;
	private String caRemark = null;
	private String bkgNo = null;
	
	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public EsmBkg007901Event(){}

	public void setBookingCreationVO(BookingCreationVO bookingCreationVO){
		this. bookingCreationVO = bookingCreationVO;
	}

	public void setBookingCreationVOS(BookingCreationVO[] bookingCreationVOs){
		if (bookingCreationVOs != null) {
			BookingCreationVO[] tmpVOs = Arrays.copyOf(bookingCreationVOs, bookingCreationVOs .length);
			this. bookingCreationVOs = tmpVOs;
		}
	}

	public BookingSaveValidationVO getBookingSaveValidationVO() {
		return bookingSaveValidationVO;
	}

	public void setBookingSaveValidationVO(BookingSaveValidationVO bookingSaveValidationVO) {
		this.bookingSaveValidationVO = bookingSaveValidationVO;
	}

	public BookingCreationVO getBookingCreationVO(){
		return bookingCreationVO;
	}

	public BookingCreationVO[] getBookingCreationVOS(){
		BookingCreationVO[] tmpVOs = null;
		if (this. bookingCreationVOs != null) {
			tmpVOs = Arrays.copyOf(bookingCreationVOs, bookingCreationVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgUsrDfltSetVO(BkgUsrDfltSetVO bkgUserDfltSetVO){
		this. bkgUserDfltSetVO = bkgUserDfltSetVO;
	}

	public BkgUsrDfltSetVO getBkgUsrDfltSetVO(){
		return bkgUserDfltSetVO;
	}

	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public void setCmdtCd(String cmdtCd){
		this. cmdtCd = cmdtCd;
	}

	public String getCmdtCd(){
		return cmdtCd;
	}

	public void setVslSkdVO(VslSkdVO vslSkdVO){
		this. vslSkdVO = vslSkdVO;
	}

	public void setVslSkdVOs(VslSkdVO[] vslSkdVOs){
		if (vslSkdVOs != null) {
			VslSkdVO[] tmpVOs = Arrays.copyOf(vslSkdVOs, vslSkdVOs .length);
			this. vslSkdVOs = tmpVOs;
		}
	}

	public VslSkdVO getVslSkdVO(){
		return vslSkdVO;
	}

	public VslSkdVO[] getVslSkdVOs(){
		VslSkdVO[] tmpVOs = null;
		if (this. vslSkdVOs != null) {
			tmpVOs = Arrays.copyOf(vslSkdVOs, vslSkdVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgVvdVO(BkgVvdVO bkgVvdVO){
		this. bkgVvdVO = bkgVvdVO;
	}

	public void setBkgVvdVOs(BkgVvdVO[] bkgVvdVOs){
		if (bkgVvdVOs != null) {
			BkgVvdVO[] tmpVOs = Arrays.copyOf(bkgVvdVOs, bkgVvdVOs .length);
			this. bkgVvdVOs = tmpVOs;
		}
	}

	public BkgVvdVO getBkgVvdVO(){
		return bkgVvdVO;
	}

	public BkgVvdVO[] getBkgVvdVOs(){
		BkgVvdVO[] tmpVOs = null;
		if (this. bkgVvdVOs != null) {
			tmpVOs = Arrays.copyOf(bkgVvdVOs, bkgVvdVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgBookingInfoVO(BkgBookingInfoVO bkgBookingInfoVO){
		this. bkgBookingInfoVO = bkgBookingInfoVO;
	}
	public BkgBookingInfoVO getBkgBookingInfoVO(){
		return bkgBookingInfoVO;
	}

	public void setBkgQuantityVO(BkgQuantityVO bkgQuantityVO){
		this. bkgQuantityVO = bkgQuantityVO;
	}

	public void setBkgQuantityVOs(BkgQuantityVO[] bkgQuantityVOs){
		if (bkgQuantityVOs != null) {
			BkgQuantityVO[] tmpVOs = Arrays.copyOf(bkgQuantityVOs, bkgQuantityVOs .length);
			this. bkgQuantityVOs = tmpVOs;
		}
	}

	public BkgQuantityVO getBkgQuantityVO(){
		return bkgQuantityVO;
	}

	public BkgQuantityVO[] getBkgQuantityVOs(){
		BkgQuantityVO[] tmpVOs = null;
		if (this. bkgQuantityVOs != null) {
			tmpVOs = Arrays.copyOf(bkgQuantityVOs, bkgQuantityVOs .length);
		}
		return tmpVOs;
	}

	public void setBlCustomerInfoVO(BlCustomerInfoVO blCustomerInfoVO){
		this. blCustomerInfoVO = blCustomerInfoVO;
	}
	public BlCustomerInfoVO getBlCustomerInfoVO(){
		return blCustomerInfoVO;
	}

	public void setNewStsCd(String newStsCd){
		this. newStsCd = newStsCd;
	}

	public String getNewStsCd(){
		return newStsCd;
	}

	public void setPctlNo(String pctlNo){
		this. pctlNo = pctlNo;
	}

	public String getPctlNo(){
		return pctlNo;
	}
	
	public void setBkgQtyDtlVO(BkgQtyDtlVO bkgQtyDtlVO){
		this. bkgQtyDtlVO = bkgQtyDtlVO;
	}

	public void setBkgQtyDtlVOs(BkgQtyDtlVO[] bkgQtyDtlVOs){
		if (bkgQtyDtlVOs != null) {
			BkgQtyDtlVO[] tmpVOs = Arrays.copyOf(bkgQtyDtlVOs, bkgQtyDtlVOs .length);
			this. bkgQtyDtlVOs = tmpVOs;
		}
	}

	public BkgQtyDtlVO getBkgQtyDtlVO(){
		return bkgQtyDtlVO;
	}

	public BkgQtyDtlVO[] getBkgQtyDtlVOs(){
		BkgQtyDtlVO[] tmpVOs = null;
		if (this. bkgQtyDtlVOs != null) {
			tmpVOs = Arrays.copyOf(bkgQtyDtlVOs, bkgQtyDtlVOs .length);
		}
		return tmpVOs;
	}	
	
	private String custCntCd = null;
	public void setCustCntCd(String custCntCd){
		this. custCntCd = custCntCd;
	}

	public String getCustCntCd(){
		return custCntCd;
	}	
	private String custSeq = null;	
	public void setCustSeq(String custSeq){
		this. custSeq = custSeq;
	}

	public String getCustSeq(){
		return custSeq;
	}		
	

	public String getCaRsnCd() {
		return caRsnCd;
	}

	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
	}

	public String getCaRemark() {
		return caRemark;
	}

	public void setCaRemark(String caRemark) {
		this.caRemark = caRemark;
	}

	public PriRpHdrVO getPriRpHdrVO() {
		return priRpHdrVO;
	}

	public void setPriRpHdrVO(PriRpHdrVO priRpHdrVO) {
		this.priRpHdrVO = priRpHdrVO;
	}
}