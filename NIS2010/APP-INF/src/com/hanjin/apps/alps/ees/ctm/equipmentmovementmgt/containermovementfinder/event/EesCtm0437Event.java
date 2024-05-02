/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0437Event.java
*@FileTitle : Correction History  Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 두기민
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchCorrectionHistoryVO;


/**
 * ees_ctm_0437 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_ctm_0437HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Doo, Ki-min
 * @see ees_ctm_0437HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCtm0437Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEdiMsgVO searchEdiMsgVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCorrectionHistoryVO searchCorrectionHistoryVO = null;

	public EesCtm0437Event(){}

	public void setSearchEdiMsgVO(SearchEdiMsgVO searchEdiMsgVO){
		this. searchEdiMsgVO = searchEdiMsgVO;
	}

	public void setSearchCorrectionHistoryVO(SearchCorrectionHistoryVO searchCorrectionHistoryVO){
		this. searchCorrectionHistoryVO = searchCorrectionHistoryVO;
	}

	public SearchEdiMsgVO getSearchEdiMsgVO(){
		return searchEdiMsgVO;
	}

	public SearchCorrectionHistoryVO getSearchCorrectionHistoryVO(){
		return searchCorrectionHistoryVO;
	}

}