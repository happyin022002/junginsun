/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0002Event.java
*@FileTitle      : Lane Master
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqQtaLaneMgmtVO;


/**
 * ESM_CSQ_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_CSQ_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_CSQ_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqQtaLaneMgmtVO csqQtaLaneMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsqQtaLaneMgmtVO[] csqQtaLaneMgmtVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public EsmCsq0002Event(){}

	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	public void setCsqQtaLaneMgmtVO(CsqQtaLaneMgmtVO csqQtaLaneMgmtVO){
		this. csqQtaLaneMgmtVO = csqQtaLaneMgmtVO;
	}

	public void setCsqQtaLaneMgmtVOS(CsqQtaLaneMgmtVO[] csqQtaLaneMgmtVOs){
		this. csqQtaLaneMgmtVOs = csqQtaLaneMgmtVOs;
	}

	public CsqQtaLaneMgmtVO getCsqQtaLaneMgmtVO(){
		return csqQtaLaneMgmtVO;
	}

	public CsqQtaLaneMgmtVO[] getCsqQtaLaneMgmtVOS(){
		return csqQtaLaneMgmtVOs;
	}

}