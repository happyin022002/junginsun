/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0654Event.java
*@FileTitle : RFA Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.21 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0654 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0654HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0654HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0654Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RfaListInputVO rfaListInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RfaListInputVO[] rfaListInputVOs = null;

	public EsmBkg0654Event(){}
	
	public void setRfaListInputVO(RfaListInputVO rfaListInputVO){
		this. rfaListInputVO = rfaListInputVO;
	}

	public void setRfaListInputVOs(RfaListInputVO[] rfaListInputVOs){
		this. rfaListInputVOs = rfaListInputVOs;
	}

	public RfaListInputVO getRfaListInputVO(){
		return rfaListInputVO;
	}

	public RfaListInputVO[] getRfaListInputVOS(){
		return rfaListInputVOs;
	}

}