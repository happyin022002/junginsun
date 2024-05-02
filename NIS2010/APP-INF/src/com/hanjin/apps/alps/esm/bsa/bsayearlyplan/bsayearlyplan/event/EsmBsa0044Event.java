/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBsa0044Event.java
*@FileTitle : BSA Creation/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.31
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.31 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.31 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event;

import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.BsaYearlyPlanConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BSA_0044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see ESM_BSA_0044HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0044Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** 조회 조건 단건처리 */
	private BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO = null;

		/** Constructor */
	public EsmBsa0044Event(){}	
	
	/** Search Condition Getter */
	public BsaYearlyPlanConditionVO getBsaYearlyPlanConditionVO() {
		return bsaYearlyPlanConditionVO;
	}

	/** Search Condition Setter */
	public void setBsaYearlyPlanConditionVO(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO) {
		this.bsaYearlyPlanConditionVO = bsaYearlyPlanConditionVO;
	}
}