/*=========================================================
*Copyright(c) 2133 CyberLogitec
*@FileName       : EsmCsq0015Event.java
*@FileTitle      : Basic Data Relation Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2133.05.03
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2133.05.03 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_CSQ_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0015Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}