/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmCoa0130Event.java
*@FileTitle : ReportViewManagement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박수훈
*@LastVersion : 1.1
* 2006.02.20 박은주  최초 생성
* 2009.07.23 박수훈  Alps New Framework 적용[0130]
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchReportViewListVO;
import com.hanjin.syscommon.common.table.CoaRptAuthMgmtVO;


/**
 * ESM_COA_0130 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0130HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_COA_0130HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0130Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchReportViewListVO searchReportViewListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchReportViewListVO[] searchReportViewListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaRptAuthMgmtVO coaRptAuthMgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaRptAuthMgmtVO[] coaRptAuthMgmtVOs = null;

	public EsmCoa0130Event(){}
	
	public void setSearchReportViewListVO(SearchReportViewListVO searchReportViewListVO){
		this. searchReportViewListVO = searchReportViewListVO;
	}

	public void setSearchReportViewListVOS(SearchReportViewListVO[] searchReportViewListVOs){
		this. searchReportViewListVOs = searchReportViewListVOs;
	}

	public void setCoaRptAuthMgmtVO(CoaRptAuthMgmtVO coaRptAuthMgmtVO){
		this. coaRptAuthMgmtVO = coaRptAuthMgmtVO;
	}

	public void setCoaRptAuthMgmtVOS(CoaRptAuthMgmtVO[] coaRptAuthMgmtVOs){
		this. coaRptAuthMgmtVOs = coaRptAuthMgmtVOs;
	}

	public SearchReportViewListVO getSearchReportViewListVO(){
		return searchReportViewListVO;
	}

	public SearchReportViewListVO[] getSearchReportViewListVOS(){
		return searchReportViewListVOs;
	}

	public CoaRptAuthMgmtVO getCoaRptAuthMgmtVO(){
		return coaRptAuthMgmtVO;
	}

	public CoaRptAuthMgmtVO[] getCoaRptAuthMgmtVOS(){
		return coaRptAuthMgmtVOs;
	}

}