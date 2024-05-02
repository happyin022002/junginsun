/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0205Event.java
*@FileTitle      : Sector-Office Relation Setting_Add Creation for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.08
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2014.01.08 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchAddSectorOfcRelSetVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_CSQ_0205 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0205HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0205HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0205Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0205Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAddSectorOfcRelSetVO searchAddSectorOfcRelSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOs = null;
	
	public void setSearchAddSectorOfcRelSetVO(SearchAddSectorOfcRelSetVO searchAddSectorOfcRelSetVO){
		this. searchAddSectorOfcRelSetVO = searchAddSectorOfcRelSetVO;
	}

	public void setSearchAddSectorOfcRelSetVOS(SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOs){
		this. searchAddSectorOfcRelSetVOs = searchAddSectorOfcRelSetVOs;
	}

	public SearchAddSectorOfcRelSetVO getSearchAddSectorOfcRelSetVO(){
		return searchAddSectorOfcRelSetVO;
	}

	public SearchAddSectorOfcRelSetVO[] getSearchAddSectorOfcRelSetVOS(){
		return searchAddSectorOfcRelSetVOs;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}