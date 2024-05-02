/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1132Event.java
*@FileTitle : C.OFC & C.REP PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : JSY
*@LastVersion : 1.0
* 2011.10.11 JSY
* 1.0 Creation
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.OfcRepInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1132 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1132HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_1132HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1132Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OfcRepInputVO ofcRepInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OfcRepInputVO[] ofcRepInputVOs = null;

	
	public EsmBkg1132Event(){}
	
	public void setOfcRepInputVO(OfcRepInputVO ofcRepInputVO){
		this. ofcRepInputVO = ofcRepInputVO;
	}

	public void setOfcRepInputVOs(OfcRepInputVO[] ofcRepInputVOs){
		this. ofcRepInputVOs = ofcRepInputVOs;
	}

	public OfcRepInputVO getOfcRepInputVO(){
		return ofcRepInputVO;
	}

	public OfcRepInputVO[] getOfcRepInputVOs(){
		return ofcRepInputVOs;
	}

	
}