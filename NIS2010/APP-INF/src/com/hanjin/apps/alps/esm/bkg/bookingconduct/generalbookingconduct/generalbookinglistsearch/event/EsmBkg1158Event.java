/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1158Event.java
*@FileTitle : Pre-checking for Code Accuracy
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_1158 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1158HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author DaeYoung Ryu
 * @see ESM_BKG_1158HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1158Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ArrNtcSearchVO arrNtcSearchVO = null;
	private ArrNtcInfoListVO arrNtcVO = null;
	private ArrNtcInfoListVO[] arrNtcVOs = null;
	private CustCdEvaluationVO[] custCdEvaluationVO = null;
	
	//[672-02] 조회용
	private ArrNtcCustListVO[] arrNtcCustListVOS = null;


	public EsmBkg1158Event(){}


	public ArrNtcSearchVO getArrNtcSearchVO() {
		return arrNtcSearchVO;
	}


	public void setArrNtcSearchVO(ArrNtcSearchVO arrNtcSearchVO) {
		this.arrNtcSearchVO = arrNtcSearchVO;
	}


	public ArrNtcInfoListVO getArrNtcVO() {
		return arrNtcVO;
	}


	public void setArrNtcVO(ArrNtcInfoListVO arrNtcVO) {
		this.arrNtcVO = arrNtcVO;
	}


	public CustCdEvaluationVO[] getCustCdEvaluationVO() {
		return custCdEvaluationVO;
	}


	public void setCustCdEvaluationVO(CustCdEvaluationVO[] custCdEvaluationVO) {
		this.custCdEvaluationVO = custCdEvaluationVO;
	}


	/**
	 * @param arrNtcVOs the arrNtcVOs to set
	 */
	public void setArrNtcVOs(ArrNtcInfoListVO[] arrNtcVOs) {
		this.arrNtcVOs = arrNtcVOs;
	}


	/**
	 * @return the arrNtcVOs
	 */
	public ArrNtcInfoListVO[] getArrNtcVOs() {
		return arrNtcVOs;
	}

	/**
	 * 
	 * @return
	 */
	public ArrNtcCustListVO[] getArrNtcCustListVOS() {
		return arrNtcCustListVOS;
	}

	/**
	 * 
	 * @param arrNtcCustListVOS
	 */
	public void setArrNtcCustListVOS(ArrNtcCustListVO[] arrNtcCustListVOS) {
		this.arrNtcCustListVOS = arrNtcCustListVOS;
	}
	
	
	
}