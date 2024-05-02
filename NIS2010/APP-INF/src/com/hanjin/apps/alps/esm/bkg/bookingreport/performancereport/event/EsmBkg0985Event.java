/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0985Event.java
*@FileTitle : Queue Detail Return Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailReturnInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchQueueDetailReturnReasonCdListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0985 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0985HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0985HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0985Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocQueueDetailReturnInVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private DocQueueDetailReturnInVO[] infoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchQueueDetailReturnReasonCdListVO searchQueueDetailReturnReasonCdListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchQueueDetailReturnReasonCdListVO[] searchQueueDetailReturnReasonCdListVOs = null;
	
	
	
	public EsmBkg0985Event(){}


	public DocQueueDetailReturnInVO getInfoVO() {
		return infoVO;
	}


	public void setInfoVO(DocQueueDetailReturnInVO infoVO) {
		this.infoVO = infoVO;
	}


	public DocQueueDetailReturnInVO[] getInfoVOs() {
		DocQueueDetailReturnInVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = new DocQueueDetailReturnInVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setInfoVOs(DocQueueDetailReturnInVO[] infoVOs){
		if(infoVOs != null){
			DocQueueDetailReturnInVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}


	public SearchQueueDetailReturnReasonCdListVO getSearchQueueDetailReturnReasonCdListVO() {
		return searchQueueDetailReturnReasonCdListVO;
	}


	public void setSearchQueueDetailReturnReasonCdListVO(
			SearchQueueDetailReturnReasonCdListVO searchQueueDetailReturnReasonCdListVO) {
		this.searchQueueDetailReturnReasonCdListVO = searchQueueDetailReturnReasonCdListVO;
	}


	public SearchQueueDetailReturnReasonCdListVO[] getSearchQueueDetailReturnReasonCdListVOs() {
		SearchQueueDetailReturnReasonCdListVO[] rtnVOs = null;
		if (this.searchQueueDetailReturnReasonCdListVOs != null) {
			rtnVOs = new SearchQueueDetailReturnReasonCdListVO[searchQueueDetailReturnReasonCdListVOs.length];
			System.arraycopy(searchQueueDetailReturnReasonCdListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
 

	public void setSearchQueueDetailReturnReasonCdListVOs(SearchQueueDetailReturnReasonCdListVO[] searchQueueDetailReturnReasonCdListVOs){
		if(searchQueueDetailReturnReasonCdListVOs != null){
			SearchQueueDetailReturnReasonCdListVO[] tmpVOs = Arrays.copyOf(searchQueueDetailReturnReasonCdListVOs, searchQueueDetailReturnReasonCdListVOs.length);
			this.searchQueueDetailReturnReasonCdListVOs = tmpVOs;
		}
	}

	
	
	
}