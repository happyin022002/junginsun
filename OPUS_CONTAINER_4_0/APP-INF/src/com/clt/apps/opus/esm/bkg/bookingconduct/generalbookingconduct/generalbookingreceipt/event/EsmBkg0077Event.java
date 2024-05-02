/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0077Event.java
*@FileTitle : Booking Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.09 김병규
* 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgForCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ManualBookingCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0077HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0077Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private VslSkdVO vslSkdVO = null;
	private BlCustomerInfoVO blCustomerInfoVO = null;
	private BkgForCopyVO bkgForCopyVO = null;
	private String copyCnt = "";
	private String vvdModifyFlg = "";
	private String pctlNo = null;
	private String closeBkgFlag = "";
	private String mailOpenFlag = "";	

	private String cbfBkgFlag = "";
	
	private ManualBookingCopyVO manualBookingCopyVO = null;
	private ManualBookingCopyVO[] manualBookingCopyVOs = null;
	/** Table Value Object Multi Data 처리 */
	private VslSkdVO[] vslSkdVOs = null;	

	public EsmBkg0077Event(){}
	
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this. bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
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
	
	public ManualBookingCopyVO getManualBookingCopyVO(){
		return manualBookingCopyVO;
	}

	public ManualBookingCopyVO[] getManualBookingCopyVOs(){
		ManualBookingCopyVO[] tmpVOs = null;
		if (this. manualBookingCopyVOs != null) {
			tmpVOs = Arrays.copyOf(manualBookingCopyVOs, manualBookingCopyVOs .length);
		}
		return tmpVOs;
	}
	
	public void setBlCustomerInfoVO(BlCustomerInfoVO blCustomerInfoVO){
		this. blCustomerInfoVO = blCustomerInfoVO;
	}
	public BlCustomerInfoVO getBlCustomerInfoVO(){
		return blCustomerInfoVO;
	}	
	
	public void setBkgForCopyVO(BkgForCopyVO bkgForCopyVO){
		this. bkgForCopyVO = bkgForCopyVO;
	}
	public BkgForCopyVO getBkgForCopyVO(){
		return bkgForCopyVO;
	}		
	
	public void setCopyCnt(String copyCnt){
		this.copyCnt = copyCnt;
	}
	
	public String getCopyCnt(){
		return copyCnt;
	}
	
	public void setVvdModifyFlg(String vvdModifyFlg){
		this.vvdModifyFlg = vvdModifyFlg;
	}
	
	public String getVvdModifyFlg(){
		return vvdModifyFlg;
	}	
	
	public void setPctlNo(String pctlNo){
		this. pctlNo = pctlNo;
	}

	public String getPctlNo(){
		return pctlNo;
	}	
	
	public void setCloseBkgFlag(String closeBkgFlag){
		this. closeBkgFlag = closeBkgFlag;
	}

	public String getCloseBkgFlag(){
		return closeBkgFlag;
	}		
	
	public void setMailOpenFlag(String mailOpenFlag){
		this. mailOpenFlag = mailOpenFlag;
	}

	public String getMailOpenFlag(){
		return mailOpenFlag;
	}

	public String getCbfBkgFlag() {
		return cbfBkgFlag;
	}

	public void setCbfBkgFlag(String cbfBkgFlag) {
		this.cbfBkgFlag = cbfBkgFlag;
	}		
	
	public void setManualBookingCopyVO(ManualBookingCopyVO manualBookingCopyVO){
		this.manualBookingCopyVO = manualBookingCopyVO;
	}

	public void setManualBookingCopyVOs(ManualBookingCopyVO[] manualBookingCopyVOs){
		if (manualBookingCopyVOs != null) {
			ManualBookingCopyVO[] tmpVOs = Arrays.copyOf(manualBookingCopyVOs, manualBookingCopyVOs .length);
			this. manualBookingCopyVOs = tmpVOs;
		}
	}
	
}