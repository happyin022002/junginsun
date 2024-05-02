/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0081Event.java
*@FileTitle : Loading by POL/POD
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.26
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.08.26 김민아
* 1.0 Creation
* 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ju Sun Young
 * @see ESM_SPC_0081HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0081Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ConditionVO conditionVO  = null;

	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	

}