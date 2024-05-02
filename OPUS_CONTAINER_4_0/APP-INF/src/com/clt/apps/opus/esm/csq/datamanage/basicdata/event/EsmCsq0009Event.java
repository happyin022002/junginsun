/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0009Event.java
*@FileTitle      : Basic Data Creation Popup
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.15
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.15 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_CSQ_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0009Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	public EsmCsq0009Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
}