/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0054Event.java
*@FileTitle : Space Allocation Model Execute Log
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2009.11.18 서관영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESM_SPC_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seo Kwan Young
 * @see ESM_SPC_0054HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0054Event extends EventSupport {

    private static final long serialVersionUID = 1L;
	
	private ConditionVO conditionVO  = null;

	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
}