/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0203Event.java
*@FileTitle      : POL-POD Management for IAS Sector_Add Creation
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.07
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.07 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchAddPolPodPairForSectorVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0203 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0203HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0203HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0203Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0203Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAddPolPodPairForSectorVO searchAddPolPodPairForSectorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAddPolPodPairForSectorVO[] searchAddPolPodPairForSectorVOs = null;
	
	public void setSearchAddPolPodPairForSectorVO(SearchAddPolPodPairForSectorVO searchAddPolPodPairForSectorVO){
		this. searchAddPolPodPairForSectorVO = searchAddPolPodPairForSectorVO;
	}

	public void setSearchAddPolPodPairForSectorVOS(SearchAddPolPodPairForSectorVO[] searchAddPolPodPairForSectorVOs){
		this. searchAddPolPodPairForSectorVOs = searchAddPolPodPairForSectorVOs;
	}

	public SearchAddPolPodPairForSectorVO getSearchAddPolPodPairForSectorVO(){
		return searchAddPolPodPairForSectorVO;
	}

	public SearchAddPolPodPairForSectorVO[] getSearchAddPolPodPairForSectorVOS(){
		return searchAddPolPodPairForSectorVOs;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}