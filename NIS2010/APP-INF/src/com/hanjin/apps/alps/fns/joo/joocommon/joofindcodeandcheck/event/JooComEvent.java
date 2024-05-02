/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JooComEvent.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.07 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;


/**
 * JOOCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  JOOCommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see JOOCommonHTMLAction 참조
 * @since J2EE 1.4
 */

public class JooComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooCodeParamVO jooCodeInfoVO = null;
	
	private EstmConditionVO estmConditionVO = null; 
	
	private SlipConditionVO slipConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooCodeParamVO[] jooCodeInfoVOs = null;

	public JooComEvent(){}
	
	public void setJooCodeParamVO(JooCodeParamVO jooCodeInfoVO){
		this. jooCodeInfoVO = jooCodeInfoVO;
	}

	public void setJooCodeParamVOS(JooCodeParamVO[] jooCodeInfoVOs){
		if (jooCodeInfoVOs != null) {
			JooCodeParamVO[] tmpVOs = new JooCodeParamVO[jooCodeInfoVOs.length];
			System.arraycopy(jooCodeInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooCodeInfoVOs = tmpVOs;
		}		
	}

	public JooCodeParamVO getJooCodeParamVO(){
		return jooCodeInfoVO;
	}

	public JooCodeParamVO[] getJooCodeParamVOS(){
		JooCodeParamVO[] rtnVOs = null;
		if (this.jooCodeInfoVOs != null) {
			rtnVOs = new JooCodeParamVO[jooCodeInfoVOs.length];
			System.arraycopy(jooCodeInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public EstmConditionVO getEstmConditionVO() {
		return estmConditionVO;
	}

	public void setEstmConditionVO(EstmConditionVO estmConditionVO) {
		this.estmConditionVO = estmConditionVO;
	}

	public SlipConditionVO getSlipConditionVO() {
		return slipConditionVO;
	}

	public void setSlipConditionVO(SlipConditionVO slipConditionVO) {
		this.slipConditionVO = slipConditionVO;
	}
	
	
}