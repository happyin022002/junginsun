/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1090Event.java
*@FileTitle : CAF Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.03 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAdjustmentVO;


/**
 * ESM_BKG_1090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1090HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_1090HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1090Event extends EventSupport { 

	private static final long serialVersionUID = 1L;
	private String bkgNo = "";
	private String caFlg = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeAdjustmentVO chargeAdjustmentVO = null;

	/** Table Value Object Multi Data 처리 */
	private ChargeAdjustmentVO[] chargeAdjustmentVOs = null;

	public EsmBkg1090Event(){}
	
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}
	
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}

	public String getCaFlg() {
		return caFlg;
	}

	public void setChargeAdjustmentVO(ChargeAdjustmentVO chargeAdjustmentVO){
		this. chargeAdjustmentVO = chargeAdjustmentVO;
	}

	public void setChargeAdjustmentVOS(ChargeAdjustmentVO[] chargeAdjustmentVOs){
		if(chargeAdjustmentVOs != null){
			ChargeAdjustmentVO[] tmpVOs = Arrays.copyOf(chargeAdjustmentVOs, chargeAdjustmentVOs.length);
			this.chargeAdjustmentVOs = tmpVOs;
		}
	}

	public ChargeAdjustmentVO getChargeAdjustmentVO(){
		return chargeAdjustmentVO;
	}

	public ChargeAdjustmentVO[] getChargeAdjustmentVOS(){
		ChargeAdjustmentVO[] rtnVOs = null;
		if (this.chargeAdjustmentVOs != null) {
			rtnVOs = Arrays.copyOf(chargeAdjustmentVOs, chargeAdjustmentVOs.length);
		}
		return rtnVOs;
	}

}