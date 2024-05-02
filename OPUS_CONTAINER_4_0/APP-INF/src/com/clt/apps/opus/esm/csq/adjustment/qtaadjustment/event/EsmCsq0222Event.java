/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsmCsq0222Event.java
*@FileTitle      : QTA Edit_Office Add for IAS Sector
*@Open Issues    :
*@Change history :
*@LastModifyDate : 2014.01.23
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2014.01.23 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event;

import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.ManageQtaEditIasSectorVO;
import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_CSQ_0222 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0222HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0222HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0222Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmCsq0222Event(){}

	private ConditionVO conditionVO = null;

	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	/** Table Value Object Multi Data 처리 */
	private ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOs = null;

	public void setManageQtaEditIasSectorVOS(ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOs){
		this. manageQtaEditIasSectorVOs = manageQtaEditIasSectorVOs;
	}

	public ManageQtaEditIasSectorVO[] getManageQtaEditIasSectorVOS(){
		return manageQtaEditIasSectorVOs;
	}

}