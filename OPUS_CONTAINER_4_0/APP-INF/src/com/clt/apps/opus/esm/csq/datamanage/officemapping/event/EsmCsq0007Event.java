/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0007Event.java
*@FileTitle      : Lane-Office Relation Setting_New Lane Add Pop-up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.20
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.20 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_CSQ_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0007Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}