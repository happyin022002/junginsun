/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0423Event.java
*@FileTitle : Queue List
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.05.30 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchQueueSummaryInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0423 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0423HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김상수
 * @see ESM_BKG_0423HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0423Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchQueueSummaryInVO searchQueueSummaryInVO = null;


	public EsmBkg0423Event(){}


	public SearchQueueSummaryInVO getSearchQueueSummaryInVO() {
		return searchQueueSummaryInVO;
	}

	public void setSearchQueueSummaryInVO(SearchQueueSummaryInVO searchQueueSummaryInVO) {
		this.searchQueueSummaryInVO = searchQueueSummaryInVO;
	}

}