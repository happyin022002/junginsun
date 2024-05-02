/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0083Event.java
*@FileTitle : Weekly L/F by POL/POD
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.11.22 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchWeeklyLfByPolPodListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ju Sun Young
 * @see ESM_SPC_0083HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0083Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchWeeklyLfByPolPodListVO searchWeeklyLfByPolPodListVO = null;
	/** Table Value Object Multi Data 처리 */
	private SearchWeeklyLfByPolPodListVO[] searchWeeklyLfByPolPodListVOs = null;

	public EsmSpc0083Event(){}

	public void setSearchWeeklyLfByPolPodListVO(SearchWeeklyLfByPolPodListVO searchWeeklyLfByPolPodListVO){
		this. searchWeeklyLfByPolPodListVO = searchWeeklyLfByPolPodListVO;
	}

	public SearchWeeklyLfByPolPodListVO getSearchWeeklyLfByPolPodListVO(){
		return searchWeeklyLfByPolPodListVO;
	}

	public void setSearchWeeklyLfByPolPodListVO(SearchWeeklyLfByPolPodListVO[] searchWeeklyLfByPolPodListVOs){
		if (searchWeeklyLfByPolPodListVOs != null) {
			SearchWeeklyLfByPolPodListVO[] tmpVOs = new SearchWeeklyLfByPolPodListVO[searchWeeklyLfByPolPodListVOs.length];
			System.arraycopy(searchWeeklyLfByPolPodListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchWeeklyLfByPolPodListVOs = tmpVOs;
		}
	}

	public SearchWeeklyLfByPolPodListVO[] getSearchWeeklyLfByPolPodListVOS(){
		SearchWeeklyLfByPolPodListVO[] rtnVOs = null;
		if (this.searchWeeklyLfByPolPodListVOs != null) {
			rtnVOs = new SearchWeeklyLfByPolPodListVO[searchWeeklyLfByPolPodListVOs.length];
			System.arraycopy(searchWeeklyLfByPolPodListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	private ConditionVO conditionVO  = null;

	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	

}