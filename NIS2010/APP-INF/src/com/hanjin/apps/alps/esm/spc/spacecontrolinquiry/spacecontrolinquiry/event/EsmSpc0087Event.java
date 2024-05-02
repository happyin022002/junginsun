/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSpc0087Event.java
*@FileTitle : T/S Plan & Guide
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2016.03.17 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchTsPlanGuideListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jongkyu Weon
 * @see ESM_SPC_0087HTMLAction 참조
 * @since J2EE 1.6
 */


public class EsmSpc0087Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTsPlanGuideListVO searchTsPlanGuideListVO = null;
	/** Table Value Object Multi Data 처리 */
	private SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs= null;
	
	public EsmSpc0087Event(){}
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public void setSearchTsPlanGuideListVO(SearchTsPlanGuideListVO searchTsPlanGuideListVO){
		this. searchTsPlanGuideListVO = searchTsPlanGuideListVO;
	}

	public SearchTsPlanGuideListVO getSearchTsPlanGuideListVO(){
		return searchTsPlanGuideListVO;
	}

	public void setSearchTsPlanGuideListVOS(SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs){
		if (searchTsPlanGuideListVOs != null) {
			SearchTsPlanGuideListVO[] tmpVOs = new SearchTsPlanGuideListVO[searchTsPlanGuideListVOs.length];
			System.arraycopy(searchTsPlanGuideListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchTsPlanGuideListVOs = tmpVOs;
		}
	}

	public SearchTsPlanGuideListVO[] getSearchTsPlanGuideListVOS(){
		SearchTsPlanGuideListVO[] rtnVOs = null;
		if (this.searchTsPlanGuideListVOs != null) {
			rtnVOs = new SearchTsPlanGuideListVO[searchTsPlanGuideListVOs.length];
			System.arraycopy(searchTsPlanGuideListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}