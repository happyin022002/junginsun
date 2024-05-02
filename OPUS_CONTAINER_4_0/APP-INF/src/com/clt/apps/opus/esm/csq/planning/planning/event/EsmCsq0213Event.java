/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsmCsq0213Event.java
*@FileTitle      : QTA Set up for IAS Sector by Head Office
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2014.01.23 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CsqSctrLodRevVO;


/**
 * ESM_CSQ_0213 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_CSQ_0213HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0213HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0213Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsqSctrLodRevVO csqSctrLodRevVO = null;

	/** Table Value Object Multi Data 처리 */
	private CsqSctrLodRevVO[] csqSctrLodRevVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmCsq0213Event(){}


	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	public void setCsqSctrLodRevVO(CsqSctrLodRevVO csqSctrLodRevVO){
		this. csqSctrLodRevVO = csqSctrLodRevVO;
	}

	public void setCsqSctrLodRevVOS(CsqSctrLodRevVO[] csqSctrLodRevVOs){
		this. csqSctrLodRevVOs = csqSctrLodRevVOs;
	}

	public CsqSctrLodRevVO getCsqSctrLodRevVO(){
		return csqSctrLodRevVO;
	}

	public CsqSctrLodRevVO[] getCsqSctrLodRevVOS(){
		return csqSctrLodRevVOs;
	}

}