/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0074Event.java
*@FileTitle : Estimate Performance Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.16 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;


/**
 * FNS_JOO_0074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0074HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0074HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0074Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EstmConditionVO estmConditionVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EstmActRsltVO estmActRsltVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EstmActRsltVO[] estmActRsltVOs = null;

	public FnsJoo0074Event(){}

	public EstmConditionVO getEstmConditionVO() {
		return estmConditionVO;
	}

	public void setEstmConditionVO(EstmConditionVO estmConditionVO) {
		this.estmConditionVO = estmConditionVO;
	}
	
	public void setEstmActRsltVO(EstmActRsltVO estmActRsltVO){
		this. estmActRsltVO = estmActRsltVO;
	}

	public void setEstmActRsltVOS(EstmActRsltVO[] estmActRsltVOs){
		if (estmActRsltVOs != null) {
			EstmActRsltVO[] tmpVOs = new EstmActRsltVO[estmActRsltVOs.length];
			System.arraycopy(estmActRsltVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.estmActRsltVOs = tmpVOs;
		}		
	}

	public EstmActRsltVO getEstmActRsltVO(){
		return estmActRsltVO;
	}

	public EstmActRsltVO[] getEstmActRsltVOS(){
		EstmActRsltVO[] rtnVOs = null;
		if (this.estmActRsltVOs != null) {
			rtnVOs = new EstmActRsltVO[estmActRsltVOs.length];
			System.arraycopy(estmActRsltVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}