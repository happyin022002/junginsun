/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0369Event.java
*@FileTitle : B/L Rider
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.16 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderOutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_BKG_0369 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_0369HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0369HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0369Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg0369Event(){}

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