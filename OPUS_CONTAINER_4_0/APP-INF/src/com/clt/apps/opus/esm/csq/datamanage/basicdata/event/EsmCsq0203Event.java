/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0203Event.java
*@FileTitle      : POL-POD Management for IAS Sector_Add Creation
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.07
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2014.01.07 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchAddPolPodPairForSectorVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_CSQ_0203 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0203HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0203HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0203Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0203Event(){}
	
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