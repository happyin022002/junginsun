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
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.SearchTerminalAgreeementSummaryListVO;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.TesAgreementManageCommonVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlAgmtHdrVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


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
	private TesTmlSoHdrVO					tesTmlSoHdrVO					= null;
	
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
		TesCommonVO[] rtnVOs = null;
		if (this.tesCommonVOs != null) {
			rtnVOs = Arrays.copyOf(tesCommonVOs, tesCommonVOs.length);
		}
		return rtnVOs;
	}

	public void setTesCommonVOs(TesCommonVO[] tesCommonVOs){
		if(tesCommonVOs != null){
			TesCommonVO[] tmpVOs = Arrays.copyOf(tesCommonVOs, tesCommonVOs.length);
			this.tesCommonVOs = tmpVOs;
		}
	}

	public TesAgreementManageCommonVO[] getTesAgreementManageCommonVOs() {
		TesAgreementManageCommonVO[] rtnVOs = null;
		if (this.tesAgreementManageCommonVOs != null) {
			rtnVOs = Arrays.copyOf(tesAgreementManageCommonVOs, tesAgreementManageCommonVOs.length);
		}
		return rtnVOs;
	}

	public void setTesAgreementManageCommonVOs(TesAgreementManageCommonVO[] tesAgreementManageCommonVOs){
		if(tesAgreementManageCommonVOs != null){
			TesAgreementManageCommonVO[] tmpVOs = Arrays.copyOf(tesAgreementManageCommonVOs, tesAgreementManageCommonVOs.length);
			this.tesAgreementManageCommonVOs = tmpVOs;
		}
	}

	public TesTmlAgmtHdrVO[] getTesTmlAgmtHdrVOs() {
		TesTmlAgmtHdrVO[] rtnVOs = null;
		if (this.tesTmlAgmtHdrVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlAgmtHdrVOs, tesTmlAgmtHdrVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlAgmtHdrVOs(TesTmlAgmtHdrVO[] tesTmlAgmtHdrVOs){
		if(tesTmlAgmtHdrVOs != null){
			TesTmlAgmtHdrVO[] tmpVOs = Arrays.copyOf(tesTmlAgmtHdrVOs, tesTmlAgmtHdrVOs.length);
			this.tesTmlAgmtHdrVOs = tmpVOs;
		}
	}

	public SearchTerminalAgreeementSummaryListVO[] getSearchTerminalAgreeementSummaryListVOs() {
		SearchTerminalAgreeementSummaryListVO[] rtnVOs = null;
		if (this.searchTerminalAgreeementSummaryListVOs != null) {
			rtnVOs = Arrays.copyOf(searchTerminalAgreeementSummaryListVOs, searchTerminalAgreeementSummaryListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchTerminalAgreeementSummaryListVOs(SearchTerminalAgreeementSummaryListVO[] searchTerminalAgreeementSummaryListVOs){
		if(searchTerminalAgreeementSummaryListVOs != null){
			SearchTerminalAgreeementSummaryListVO[] tmpVOs = Arrays.copyOf(searchTerminalAgreeementSummaryListVOs, searchTerminalAgreeementSummaryListVOs.length);
			this.searchTerminalAgreeementSummaryListVOs = tmpVOs;
		}
	}

	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}
	

}