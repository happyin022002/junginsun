/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0003Event.java
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
import com.clt.syscommon.common.table.CsqDirConvVO;


/**
 * ESM_CSQ_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0003Event(){}
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqDirConvVO csqDirConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqDirConvVO[] csqDirConvVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public void setCsqDirConvVO(CsqDirConvVO csqDirConvVO){
		this. csqDirConvVO = csqDirConvVO;
	}

	public void setCsqDirConvVOS(CsqDirConvVO[] csqDirConvVOs){
		this. csqDirConvVOs = csqDirConvVOs;
	}

	public CsqDirConvVO getCsqDirConvVO(){
		return csqDirConvVO;
	}

	public CsqDirConvVO[] getCsqDirConvVOS(){
		return csqDirConvVOs;
	}
}