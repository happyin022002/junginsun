/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0941Event.java
*@FileTitle : Consignee Code Error Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.07.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0941 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0941HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mangeon
 * @see ESM_BKG_0941HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0941Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Customer Code Error Report 조회용  */
	private ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearchVO = null;
	
	/** Customer Code Error Report 수정용  */
	private ArrNtcCustCodeErrListVO[] arrNtcCustCodeErrListVOs = null;
	
	/**
	 * 생성자
	 */
	public EsmBkg0941Event(){}

	/**
	 * setter
	 * @return
	 */
	public ArrNtcCustCodeErrSearchVO getArrNtcCustCodeErrSearchVO() {
		return arrNtcCustCodeErrSearchVO;
	}

	/**
	 * getter
	 * @param arrNtcCustCodeErrSearchVO
	 */
	public void setArrNtcCustCodeErrSearchVO(
			ArrNtcCustCodeErrSearchVO arrNtcCustCodeErrSearchVO) {
		this.arrNtcCustCodeErrSearchVO = arrNtcCustCodeErrSearchVO;
	}

	/**
	 * getter
	 */
	public ArrNtcCustCodeErrListVO[] getArrNtcCustCodeErrListVOs() {
		return arrNtcCustCodeErrListVOs;
	}

	/**
	 * setter
	 */
	public void setArrNtcCustCodeErrListVOs(
			ArrNtcCustCodeErrListVO[] arrNtcCustCodeErrListVOs) {
		this.arrNtcCustCodeErrListVOs = arrNtcCustCodeErrListVOs;
	}
	
}