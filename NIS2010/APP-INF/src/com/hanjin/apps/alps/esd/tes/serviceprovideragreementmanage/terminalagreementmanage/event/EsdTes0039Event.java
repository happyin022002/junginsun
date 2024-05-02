/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0039Event.java
*@FileTitle : Terminal Agreement Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.07.09 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.SearchTerminalAgreeementSummaryListVO;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.TesAgreementManageCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlAgmtHdrVO;


/**
 * ESD_TES_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_0039HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTes0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesCommonVO 					tesCommonVO							= null;
	private TesAgreementManageCommonVO 		tesAgreementManageCommonVO			= null;
	private TesTmlAgmtHdrVO 				tesTmlAgmtHdrVO						= null;
	private SearchTerminalAgreeementSummaryListVO searchTerminalAgreeementSummaryListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TesCommonVO[]					tesCommonVOs						= null;
	private TesAgreementManageCommonVO[]	tesAgreementManageCommonVOs			= null;
	private TesTmlAgmtHdrVO[] 				tesTmlAgmtHdrVOs					= null;
	private SearchTerminalAgreeementSummaryListVO[] searchTerminalAgreeementSummaryListVOs = null;

	public EsdTes0039Event(){}

	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}

	public void setTesCommonVO(TesCommonVO tesCommonVO) {
		this.tesCommonVO = tesCommonVO;
	}

	public TesAgreementManageCommonVO getTesAgreementManageCommonVO() {
		return tesAgreementManageCommonVO;
	}

	public void setTesAgreementManageCommonVO(
			TesAgreementManageCommonVO tesAgreementManageCommonVO) {
		this.tesAgreementManageCommonVO = tesAgreementManageCommonVO;
	}

	public TesTmlAgmtHdrVO getTesTmlAgmtHdrVO() {
		return tesTmlAgmtHdrVO;
	}

	public void setTesTmlAgmtHdrVO(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) {
		this.tesTmlAgmtHdrVO = tesTmlAgmtHdrVO;
	}

	public SearchTerminalAgreeementSummaryListVO getSearchTerminalAgreeementSummaryListVO() {
		return searchTerminalAgreeementSummaryListVO;
	}

	public void setSearchTerminalAgreeementSummaryListVO(
			SearchTerminalAgreeementSummaryListVO searchTerminalAgreeementSummaryListVO) {
		this.searchTerminalAgreeementSummaryListVO = searchTerminalAgreeementSummaryListVO;
	}

	public TesCommonVO[] getTesCommonVOs() {
		return tesCommonVOs;
	}

	public void setTesCommonVOs(TesCommonVO[] tesCommonVOs) {
		this.tesCommonVOs = tesCommonVOs;
	}

	public TesAgreementManageCommonVO[] getTesAgreementManageCommonVOs() {
		return tesAgreementManageCommonVOs;
	}

	public void setTesAgreementManageCommonVOs(
			TesAgreementManageCommonVO[] tesAgreementManageCommonVOs) {
		this.tesAgreementManageCommonVOs = tesAgreementManageCommonVOs;
	}

	public TesTmlAgmtHdrVO[] getTesTmlAgmtHdrVOs() {
		return tesTmlAgmtHdrVOs;
	}

	public void setTesTmlAgmtHdrVOs(TesTmlAgmtHdrVO[] tesTmlAgmtHdrVOs) {
		this.tesTmlAgmtHdrVOs = tesTmlAgmtHdrVOs;
	}

	public SearchTerminalAgreeementSummaryListVO[] getSearchTerminalAgreeementSummaryListVOs() {
		return searchTerminalAgreeementSummaryListVOs;
	}

	public void setSearchTerminalAgreeementSummaryListVOs(
			SearchTerminalAgreeementSummaryListVO[] searchTerminalAgreeementSummaryListVOs) {
		this.searchTerminalAgreeementSummaryListVOs = searchTerminalAgreeementSummaryListVOs;
	}
	

}