/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmBkg1083Event.java
*@FileTitle : B/L Detail 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.02.17 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchBookingTrendReportVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_1083HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1083Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBookingTrendReportVO searchBookingTrendReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBookingTrendReportVO[] searchBookingTrendReportVOs = null;

	public EsmBkg1083Event(){}
	
	public void setSearchBookingTrendReportVO(SearchBookingTrendReportVO searchBookingTrendReportVO){
		this. searchBookingTrendReportVO = searchBookingTrendReportVO;
	}

	public void setSearchBookingTrendReportVOS(SearchBookingTrendReportVO[] searchBookingTrendReportVOs){
		if(searchBookingTrendReportVOs != null){
			SearchBookingTrendReportVO[] tmpVOs = Arrays.copyOf(searchBookingTrendReportVOs, searchBookingTrendReportVOs.length);
			this.searchBookingTrendReportVOs = tmpVOs;
		}
	}

	public SearchBookingTrendReportVO getSearchBookingTrendReportVO(){
		return searchBookingTrendReportVO;
	}

	public SearchBookingTrendReportVO[] getSearchBookingTrendReportVOS(){
		SearchBookingTrendReportVO[] rtnVOs = null;
		if(this.searchBookingTrendReportVOs != null){
			rtnVOs= Arrays.copyOf(searchBookingTrendReportVOs, searchBookingTrendReportVOs.length);
		}
		return rtnVOs;
	}

}