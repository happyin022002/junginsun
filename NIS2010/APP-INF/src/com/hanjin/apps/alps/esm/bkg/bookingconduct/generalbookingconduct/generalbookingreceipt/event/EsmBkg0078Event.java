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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgReactivateVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0077HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0078Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String bkgNo = null;
	private String trunkVVD = null;
	private String polCd = null;
	private String podCd = null;
	private String sts = null;
	private String cxlRsn = null;
	private BkgReactivateVO bkgReactivateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgReactivateVO[] bkgReactivateVOs = null;	

	public EsmBkg0078Event(){}
	
	public void setBkgReactivateVO(BkgReactivateVO bkgReactivateVO){
		this. bkgReactivateVO = bkgReactivateVO;
	}

	public BkgReactivateVO getBkgReactivateVO(){
		return bkgReactivateVO;
	}

	public void setBkgReactivateVOs(BkgReactivateVO[] bkgReactivateVOs){
		if(bkgReactivateVOs != null){
			BkgReactivateVO[] tmpVOs = new BkgReactivateVO[bkgReactivateVOs.length];
			System.arraycopy(bkgReactivateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgReactivateVOs = tmpVOs;
		}
	}

	public BkgReactivateVO[] getBkgReactivateVOs(){
		BkgReactivateVO[] rtnVOs = null;
		if (this.bkgReactivateVOs != null) {
			rtnVOs = new BkgReactivateVO[bkgReactivateVOs.length];
			System.arraycopy(bkgReactivateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	/**
	 * @return tVvd
	 */
	public String getTrunkVVD() {
		return trunkVVD;
	}

	public void setTrunkVVD(String trunkVVD) {
		this.trunkVVD = trunkVVD;
	}
	/**
	 * @return polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	/**
	 * @return podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	/**
	 * @return sts
	 */
	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * @return cxlRsn
	 */
	public String getCxlRsn() {
		return cxlRsn;
	}

	public void setCxlRsn(String cxlRsn) {
		this.cxlRsn = cxlRsn;
	}	
	
	
}