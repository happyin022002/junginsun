/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0008Event.java
*@FileTitle      : Basic Data Creation
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.13
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.13 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_CSQ_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0008Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}