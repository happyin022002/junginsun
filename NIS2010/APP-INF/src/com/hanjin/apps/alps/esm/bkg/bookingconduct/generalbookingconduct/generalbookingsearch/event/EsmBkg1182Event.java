/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg1182Event.java
*@FileTitle : Booking Attachment
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
* 2015.02.05 [CHM-201432844] 제안제도 : BKG Creation 화면에 Attachment 기능 추가
*            (ESM_BKG_0369 그대로 옮겨 옴)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderOutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_BKG_1182 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_1182HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_1182HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1182Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg1182Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private BlRiderInVO blRiderInVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  출력VO   */
	private BlRiderOutVO blRiderOutVO = null;


	/**
	 * @return the blRiderInVO
	 */
	public BlRiderInVO getBlRiderInVO() {
		return blRiderInVO;
	}
	/**
	 * @param blRiderInVO the blRiderInVO to set
	 */
	public void setBlRiderInVO(BlRiderInVO blRiderInVO) {
		this.blRiderInVO = blRiderInVO;
	}
	/**
	 * @return the blRiderOutVO
	 */
	public BlRiderOutVO getBlRiderOutVO() {
		return blRiderOutVO;
	}
	/**
	 * @param blRiderOutVO the blRiderOutVO to set
	 */
	public void setBlRiderOutVO(BlRiderOutVO blRiderOutVO) {
		this.blRiderOutVO = blRiderOutVO;
	}




}