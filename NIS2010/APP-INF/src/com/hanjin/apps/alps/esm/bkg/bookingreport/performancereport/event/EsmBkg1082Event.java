/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmBkg1082Event.java
*@FileTitle : 2 weeks Daily Booking Trend by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.02.04 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchBookingTrendReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportInVO;


/**
 * ESM_BKG_1082 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1082HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_1082HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg1082Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBookingTrendReportVO searchBookingTrendReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBookingTrendReportVO[] searchBookingTrendReportVOs = null;

	public EsmBkg1082Event(){}
	
	public void setSearchBookingTrendReportVO(SearchBookingTrendReportVO searchBookingTrendReportVO){
		this. searchBookingTrendReportVO = searchBookingTrendReportVO;
	}

//	public void setSearchBookingTrendReportVOS(SearchBookingTrendReportVO[] searchBookingTrendReportVOs){
//		this. searchBookingTrendReportVOs = searchBookingTrendReportVOs;
//	}

	public SearchBookingTrendReportVO getSearchBookingTrendReportVO(){
		return searchBookingTrendReportVO;
	}

//	public SearchBookingTrendReportVO[] getSearchBookingTrendReportVOS(){
//		return searchBookingTrendReportVOs;
//	}
	
	//2015.03.01 Secure Coding 적용 [CWE-495]
	public SearchBookingTrendReportVO[] getSearchBookingTrendReportVOS(){
		SearchBookingTrendReportVO[] rtnVOs = null;
		if (this.searchBookingTrendReportVOs != null) {
			rtnVOs = new SearchBookingTrendReportVO[searchBookingTrendReportVOs.length];
			System.arraycopy(searchBookingTrendReportVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	//2015.03.01 Secure Coding 적용[CWE-496]
	public void setSearchBookingTrendReportVOS(SearchBookingTrendReportVO[] searchBookingTrendReportVOs){
		if (searchBookingTrendReportVOs != null) {
			SearchBookingTrendReportVO[] tmpVOs = new SearchBookingTrendReportVO[searchBookingTrendReportVOs.length];
			System.arraycopy(searchBookingTrendReportVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchBookingTrendReportVOs = tmpVOs;
		}
	}	

}