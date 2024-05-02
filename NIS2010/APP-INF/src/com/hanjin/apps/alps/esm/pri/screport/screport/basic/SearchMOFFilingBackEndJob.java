/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchMOFFilingBackEndJob.java
*@FileTitle : MOT Filing (Formatted)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchKoreaMOTListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOFListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * Korea MOF Filing (Formatted) 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */
public class SearchMOFFilingBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = 1658687229319513392L;

	private SCReportDBDAO dbDao = new SCReportDBDAO();
	
	private RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO;

	/**
	 * Korea MOF Filing (Formatted) 리스트 조회조건을 셋팅한다. <br>
	 * 
	 * @param RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO
	 */
	public void setRsltSearchKoreaMOTListVO(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO) {
		this.rsltSearchKoreaMOTListVO = rsltSearchKoreaMOTListVO;
	}

	/**
	 * MOF Filing (Formatted) 리스트를 조회한다. <br>
	 *  
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("unchecked")	
	public List doStart() throws Exception {
		List<RsltSearchMOFListVO> list = new ArrayList<RsltSearchMOFListVO>();
		try {
			Map<String, String> mapVO = rsltSearchKoreaMOTListVO.getColumnValues();
            //Contract Type Multi Select
            String type = mapVO.get("f_ctrt_tp");
            
            // SC
			if(type.indexOf("S")!=-1){
				list = dbDao.searchMOFFilingFormattedSCList(this.rsltSearchKoreaMOTListVO);
			}
			
			// RFA
			if(type.indexOf("R")!=-1){
				List<RsltSearchMOFListVO> rfaList = dbDao.searchMOFFilingFormattedRFAList(this.rsltSearchKoreaMOTListVO);
				
				if(list.size() > 0) {
					list.addAll(rfaList);
				} else {
					list = rfaList;
				}
			}
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}

}
