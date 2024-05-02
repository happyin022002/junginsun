/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ContractNoDBDAO.java
*@FileTitle : Contract No 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-11
*@LastModifier : sangyool pak
*@LastVersion : 1.0
* 2006-08-11 sangyool pak
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.contractno.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.bizcommon.contractno.basic.ContractNoBCImpl;
import com.hanjin.bizcommon.contractno.vo.SearchContractNoListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ENIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - ENIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author sangyool pak
 * @see ContractNoBCImpl 참조
 * @since J2EE 1.4
 */
public class ContractNoDBDAO extends DBDAOSupport {

    /**
     * ContractNo의 모든 목록을 가져온다.<br>
     * 
     * @param contTp
     * @param contNo
     * @param custNm
     * @param sdate
     * @param edate
     * @param iPage
     * @param ofcCd
     * @param ctrtCustSlsOfcCd
     * @return
     * @throws DAOException
     */
    public List<SearchContractNoListVO> searchContractNoList(String contTp, String contNo, String custNm, String sdate, String edate, int iPage, String ofcCd, String  ctrtCustSlsOfcCd) throws DAOException {
		
    	// PDTO(Data Transfer Object including Parameters)
    	List<SearchContractNoListVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
 
        
        // 페이징 처리
		int currentPage = iPage;
		int startPart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
		int endPart     = Constants.PAGE_SIZE_5000 * currentPage;
		
		param.put("startpart", startPart);
		param.put("endpart", endPart);
		try{
			if(!contTp.equals("") && !contNo.equals("")) {
				param.put("cont_tp", contTp + contNo);
				velParam.put("cont_tp", contTp);
				velParam.put("sc_seq_no", "A");
    		}else if(!contTp.equals("")){
    			param.put("cont_tp", contTp);
				velParam.put("cont_tp", contTp);
				velParam.put("sc_seq_no", "A");
    		}else if(!contNo.equals("")){
    			param.put("cont_tp", contNo);
				velParam.put("cont_tp", contNo);
				velParam.put("sc_seq_no", "B");
    		}
        	if(!custNm.equals("")) {
        		param.put("cust_lgl_eng_nm", custNm);
				velParam.put("custnm", custNm);
    		}
        	if(!custNm.equals("")) {
        		param.put("cust_lgl_eng_nm", custNm);
				velParam.put("custnm", custNm);
    		}
        	if(!edate.equals("")&& !sdate.equals("")) {
        		param.put("sdate", sdate);
        		velParam.put("sdate", sdate);
        		param.put("edate", edate);
        		velParam.put("edate", edate);
    		}
        	if(!ofcCd.equals("")) {
        		param.put("ofc_cd", ofcCd);
        		velParam.put("ofc_cd", ofcCd);
        		
    		}
        	if(!ctrtCustSlsOfcCd.equals("")){
        		param.put("ctrt_cust_sls_ofc_cd", ctrtCustSlsOfcCd);
        		velParam.put("ctrt_cust_sls_ofc_cd", ctrtCustSlsOfcCd);
        	}

        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new ContractNoDBDAOTotalContractNoRSQL(), param, velParam);
			int cnt = 0;
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContractNoDBDAOSearchContractNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContractNoListVO.class);
			if (cnt > 0)
				list.get(0).setMaxRows(cnt);  
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}