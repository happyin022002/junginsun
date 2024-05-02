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
* 2009.07.23 박수훈  OPUS New Framework 적용[0130]
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.event;

import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchReportViewListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaRptAuthMgmtVO;
import java.util.Arrays;									//SJH.20150507.소스품질

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
	
	//SJH.20150507.소스품질
	public void setSearchReportViewListVOS(SearchReportViewListVO[] searchReportViewListVOs){
		if(searchReportViewListVOs != null){
			SearchReportViewListVO[] tmpVOs = Arrays.copyOf(searchReportViewListVOs, searchReportViewListVOs.length);
			this.searchReportViewListVOs = tmpVOs;
		}
	}

	public void setCoaRptAuthMgmtVO(CoaRptAuthMgmtVO coaRptAuthMgmtVO){
		this. coaRptAuthMgmtVO = coaRptAuthMgmtVO;
	}
	
	//SJH.20150507.소스품질
	public void setCoaRptAuthMgmtVOS(CoaRptAuthMgmtVO[] coaRptAuthMgmtVOs){
		if(coaRptAuthMgmtVOs != null){
			CoaRptAuthMgmtVO[] tmpVOs = Arrays.copyOf(coaRptAuthMgmtVOs, coaRptAuthMgmtVOs.length);
			this.coaRptAuthMgmtVOs = tmpVOs;
		}
	}

	public SearchReportViewListVO getSearchReportViewListVO(){
		return searchReportViewListVO;
	}
	
	//SJH.20150507.소스품질
	public SearchReportViewListVO[] getSearchReportViewListVOS(){
		SearchReportViewListVO[] rtnVOs = null;
		if (this.searchReportViewListVOs != null) {
			rtnVOs = Arrays.copyOf(searchReportViewListVOs, searchReportViewListVOs.length);
		}
		return rtnVOs;
	}

	public CoaRptAuthMgmtVO getCoaRptAuthMgmtVO(){
		return coaRptAuthMgmtVO;
	}
	//SJH.20150507.소스품질
	public CoaRptAuthMgmtVO[] getCoaRptAuthMgmtVOS(){
		CoaRptAuthMgmtVO[] rtnVOs = null;
		if (this.coaRptAuthMgmtVOs != null) {
			rtnVOs = Arrays.copyOf(coaRptAuthMgmtVOs, coaRptAuthMgmtVOs.length);
		}
		return rtnVOs;
	}

}