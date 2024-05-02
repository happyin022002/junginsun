/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0207Event.java
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

import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderOutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_BKG_0207 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_0207HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0207HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0207Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsmBkg0207Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private SpclRiderInVO spclRiderInVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  출력VO   */
	private SpclRiderOutVO spclRiderOutVO = null;


	/**
	 * @return the spclRiderInVO
	 */
	public SpclRiderInVO getSpclRiderInVO() {
		return spclRiderInVO;
	}

	/**
	 * @param spclRiderInVO the spclRiderInVO to set
	 */
	public void setSpclRiderInVO(SpclRiderInVO spclRiderInVO) {
		this.spclRiderInVO = spclRiderInVO;
	}

	/**
	 * @return the spclRiderOutVO
	 */
	public SpclRiderOutVO getSpclRiderOutVO() {
		return spclRiderOutVO;
	}

	/**
	 * @param spclRiderOutVO the spclRiderOutVO to set
	 */
	public void setSpclRiderOutVO(SpclRiderOutVO spclRiderOutVO) {
		this.spclRiderOutVO = spclRiderOutVO;
	}




}