/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1600HTMLAction.java
*@FileTitle : Charge Amend Request
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthDetailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRefUserVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1600 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1600HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Lee Nam Kyung
 * @see ESM_BKG_1600HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1600Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String bkgNo = null;
	private String chgCd = null;
	private BkgBlNoVO bkgBlNoVO = null;
	private ChargeAmendAuthVO chargeAmendAuthVO = null;
	private ChargeAmendAuthDetailVO[] chargeAmendAuthDetailVOs = null;
	private ChargeAmendAuthRefUserVO[] chargeAmendAuthRefUserVOs = null;
	
	public EsmBkg1600Event(){}

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
	 * @return the chgCd
	 */
	public String getChgCd() {
		return chgCd;
	}
	/**
	 * @param chgCd the chgCd to set
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @return the chargeAmendAuthVO
	 */
	public ChargeAmendAuthVO getChargeAmendAuthVO() {
		return chargeAmendAuthVO;
	}

	/**
	 * @param chargeAmendAuthVO the chargeAmendAuthVO to set
	 */
	public void setChargeAmendAuthVO(ChargeAmendAuthVO chargeAmendAuthVO) {
		this.chargeAmendAuthVO = chargeAmendAuthVO;
	}

	/**
	 * @return the chargeAmendAuthDetailVOs
	 */
	public ChargeAmendAuthDetailVO[] getChargeAmendAuthDetailVOs() {
		ChargeAmendAuthDetailVO[] rtnVOs = null;
		if (this.chargeAmendAuthDetailVOs != null) {
			rtnVOs = Arrays.copyOf(chargeAmendAuthDetailVOs, chargeAmendAuthDetailVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param chargeAmendAuthDetailVOs the chargeAmendAuthDetailVOs to set
	 */
	public void setChargeAmendAuthDetailVOs(ChargeAmendAuthDetailVO[] chargeAmendAuthDetailVOs){
		if(chargeAmendAuthDetailVOs != null){
			ChargeAmendAuthDetailVO[] tmpVOs = Arrays.copyOf(chargeAmendAuthDetailVOs, chargeAmendAuthDetailVOs.length);
			this.chargeAmendAuthDetailVOs = tmpVOs;
		}
	}

	/**
	 * @return the chargeAmendAuthRefUserVOs
	 */
	public ChargeAmendAuthRefUserVO[] getChargeAmendAuthRefUserVOs() {
		ChargeAmendAuthRefUserVO[] rtnVOs = null;
		if (this.chargeAmendAuthRefUserVOs != null) {
			rtnVOs = Arrays.copyOf(chargeAmendAuthRefUserVOs, chargeAmendAuthRefUserVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param chargeAmendAuthRefUserVOs the chargeAmendAuthRefUserVOs to set
	 */
	public void setChargeAmendAuthRefUserVOs(ChargeAmendAuthRefUserVO[] chargeAmendAuthRefUserVOs){
		if(chargeAmendAuthRefUserVOs != null){
			ChargeAmendAuthRefUserVO[] tmpVOs = Arrays.copyOf(chargeAmendAuthRefUserVOs, chargeAmendAuthRefUserVOs.length);
			this.chargeAmendAuthRefUserVOs = tmpVOs;
		}
	}
}