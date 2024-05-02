/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0041Event.java
*@FileTitle : Space-Reallocation Model Run 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2009.11.24 서관영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;


/**
 * ESM_SPC_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seo Kwan Young
 * @see ESM_SPC_0041HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0041Event extends EventSupport {

	 private static final long serialVersionUID = 1L;
		
	 private ConditionVO conditionVO  = null;

     public ConditionVO getConditionVO() {
			return conditionVO;
		}

	 public void setConditionVO(ConditionVO conditionVO) {
			this.conditionVO = conditionVO;
		}
}