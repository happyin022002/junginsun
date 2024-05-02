/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchChargeSummaryBlInquiryBackEndJob.java
*@FileTitle : Charge Summary Report - BL Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.27
*@LastModifier : 이혜민
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportBlInquiryVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 *  대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 이혜민
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */
public class SearchChargeSummaryBlInquiryBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = 6952105465428416158L;

	private  SCReportDBDAO dbDao = new SCReportDBDAO();
	
	private RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO; 

	/**
	 * Charge Summary Report - BL Inquiry 조회 조건을 셋팅한다. <br>
	 *  
	 * @param RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO
	 */	
	public void setRptSearchChargeSummaryReportBlInquiryVO(RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO) {
		this.rptSearchChargeSummaryReportBlInquiryVO = rptSearchChargeSummaryReportBlInquiryVO;
	}

	/**
	 * Charge Summary Report - BL Inquiry 조회한다.
	 *  
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("unchecked")		
	public List doStart() throws Exception {
    	DBRowSet rowSet = null;
    	List<Object> sList = new ArrayList();
		String[] sTitle = null;
		String[] sColum = null;
		int colCnt = 0;
		try {
			rowSet = dbDao.searchChargeSummaryBlInquiry(this.rptSearchChargeSummaryReportBlInquiryVO);
			sList.add( rowSet );
			//엑셀다운 로드시 헤더 세팅..
			if("Y".equals(rptSearchChargeSummaryReportBlInquiryVO.getFExcel())){
				rowSet.next();
				colCnt = rowSet.getMetaData().getColumnCount();
				sTitle = new String[colCnt];
				sColum = new String[colCnt];

				for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
					sTitle[k-1] = JSPUtil.getNull(rowSet.getString(k));
					sColum[k-1] = rowSet.getMetaData().getColumnLabel(k);
				}
				sList.add( sTitle );
				sList.add( sColum );
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return sList;
	}
}
