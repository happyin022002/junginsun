/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : VesselReportDBDAO.java
*@FileTitle : VesselReportDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-23
*@LastModifier : Jeong-Seon An , Yoon-Jung Lee
*@LastVersion : 1.0
* 2007-07-23 Jeong-Seon An , Yoon-Jung Lee
* 2007-08-20 Jeong-Seon An , Yoon-Jung Lee
* 1.0 최초 생성
* 2008-01-21 Jeong-Seon An : 화면검색옵션 강화
* 조합 1. ETA 조합 2. ETA + VVD 조합 3. ETA+ EQ Office 
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.integration;
  
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.basic.COPSearchBCImpl;
import com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORInfoVO;
import com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * SCE에 대한 DB 처리를 담당<br>
 * - SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeong-Seon An , Yoon-Jung Lee
 * @see COPSearchBCImpl 참조
 * @since J2EE 1.4
 */
public class VesselReportDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
     * US INLAND OPERATION REPORT 조회 리스트
     * 
     * @param SearchUSIORInfoVO usiorInfo
     * @param String ofcCd
     * @return List<SearchUSIORListVO>
     * @throws DAOException
     */
    public DBRowSet searchUSIORList(SearchUSIORInfoVO usiorInfo, String ofcCd) throws DAOException {
    	
    	log.debug("searchUSIORList를 실행합니다.");
    	DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	if (usiorInfo != null) {
        		usiorInfo.setOfcCd(ofcCd);
				Map<String, String> mapVO = usiorInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			    log.debug("PARAM:"+ param);
			    log.debug("velParam:"+ velParam);
			}
        	
        	//s_bkg_no MULTI 처리
			if (velParam.get("s_bkg_no") != null && !((String) velParam.get("s_bkg_no")).trim().equals("")) {
				velParam.put("s_bkg_no", ((String) velParam.get("s_bkg_no")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[s_bkg_no]  - " + ((String[])velParam.get("s_bkg_no")).length);
			}//if
        	
			//s_cntr_no MULTI 처리
			if (velParam.get("s_cntr_no") != null && !((String) velParam.get("s_cntr_no")).trim().equals("")) {
				velParam.put("s_cntr_no", ((String) velParam.get("s_cntr_no")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[s_cntr_no]  - " + ((String[])velParam.get("s_cntr_no")).length);
			}//if	
				
        	//s_neweq_office MULTI 처리 
			if (velParam.get("s_neweq_office") != null
					&& !((String) velParam.get("s_neweq_office")).trim().equals("")
					&& !((String) velParam.get("s_neweq_office")).equals("ALL")) {
				velParam.put("s_neweq_office", ((String) velParam.get("s_neweq_office")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[s_neweq_office]  - " + ((String[])velParam.get("s_neweq_office")).length);
			}//if
			
			//s_rail_dest MULTI 처리 
			if (velParam.get("s_rail_dest") != null && !((String) velParam.get("s_rail_dest")).trim().equals("")) {
				velParam.put("s_rail_dest", ((String) velParam.get("s_rail_dest")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[s_rail_dest]  - " + ((String[])velParam.get("s_rail_dest")).length);
			}//if
			
			//s_pol_pod MULTI 처리 
			if (velParam.get("s_pol_pod") != null
					&& !((String) velParam.get("s_pol_pod")).trim().equals("")
					&& !((String)velParam.get("s_pol_pod")).equals("ALL")) {
				velParam.put("s_pol_pod", ((String) velParam.get("s_pol_pod")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[s_pol_pod]  - " + ((String[])velParam.get("s_pol_pod")).length);
			}//if
			
			if (velParam.get("eqmt_ofc") != null && !((String) velParam.get("eqmt_ofc")).trim().equals("")) {
				velParam.put("eqmt_ofc", ((String) velParam.get("eqmt_ofc")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[eqmt_ofc]  - " + ((String[])velParam.get("eqmt_ofc")).length);
			}
			
			if (velParam.get("port_cd") != null && !((String) velParam.get("port_cd")).trim().equals("")) {
				velParam.put("port_cd", ((String) velParam.get("port_cd")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[port_cd]  - " + ((String[])velParam.get("port_cd")).length);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VesselReportDBDAOSearchUSIORListRSQL(),
					param, velParam);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	 
    /**
     * US INLAND OPERATION REPORT DOWN ONLY 리스트
     * 
     * @param SearchUSIORInfoVO usiorInfo
     * @param String ofcCd
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchUSIORInquiry(SearchUSIORInfoVO usiorInfo, String ofcCd) throws DAOException {
    	log.debug("searchUSIORList를 실행합니다.");
    	DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	if (usiorInfo != null) {
        		usiorInfo.setOfcCd(ofcCd);
				Map<String, String> mapVO = usiorInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			    log.debug("PARAM:"+ param);
			    log.debug("velParam:"+ velParam);
			}
        	
        	if (velParam.get("s_bkg_no") != null && !((String) velParam.get("s_bkg_no")).trim().equals("")) {
				velParam.put("s_bkg_no", ((String) velParam.get("s_bkg_no")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[s_bkg_no]  - " + ((String[])velParam.get("s_bkg_no")).length);
			}//if
        	
			//s_cntr_no MULTI 처리
			if (velParam.get("s_cntr_no") != null && !((String) velParam.get("s_cntr_no")).trim().equals("")) {
				velParam.put("s_cntr_no", ((String) velParam.get("s_cntr_no")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[s_cntr_no]  - " + ((String[])velParam.get("s_cntr_no")).length);
			}//if	
				
        	//s_neweq_office MULTI 처리 
			if (velParam.get("s_neweq_office") != null
					&& !((String) velParam.get("s_neweq_office")).trim().equals("")
					&& !((String) velParam.get("s_neweq_office")).equals("ALL")) {
				velParam.put("s_neweq_office", ((String) velParam.get("s_neweq_office")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[s_neweq_office]  - " + ((String[])velParam.get("s_neweq_office")).length);
			}//if
			
			//s_rail_dest MULTI 처리 
			if (velParam.get("s_rail_dest") != null && !((String) velParam.get("s_rail_dest")).trim().equals("")) {
				velParam.put("s_rail_dest", ((String) velParam.get("s_rail_dest")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[s_rail_dest]  - " + ((String[])velParam.get("s_rail_dest")).length);
			}//if
			
			//s_pol_pod MULTI 처리 
			if (velParam.get("s_pol_pod") != null
					&& !((String) velParam.get("s_pol_pod")).trim().equals("")
					&& !((String)velParam.get("s_pol_pod")).equals("ALL")) {
				velParam.put("s_pol_pod", ((String) velParam.get("s_pol_pod")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[s_pol_pod]  - " + ((String[])velParam.get("s_pol_pod")).length);
			}//if
			
			if (velParam.get("eqmt_ofc") != null && !((String) velParam.get("eqmt_ofc")).trim().equals("")) {
				velParam.put("eqmt_ofc", ((String) velParam.get("eqmt_ofc")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[eqmt_ofc]  - " + ((String[])velParam.get("eqmt_ofc")).length);
			}
			
			if (velParam.get("port_cd") != null && !((String) velParam.get("port_cd")).trim().equals("")) {
				velParam.put("port_cd", ((String) velParam.get("port_cd")).toUpperCase().split(","));
				log.debug("###EsdSce0035  Prams[port_cd]  - " + ((String[])velParam.get("port_cd")).length);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VesselReportDBDAOSearchUSIORListRSQL(),
					param, velParam);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
    
    /**
	  * 조회조건(combo)을 위한 West Cost, East Cost에 따른 Location 조회<br>
	  * 
	  * @param  String costDiv
	  * @return List<SearchUSIORListVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public List<SearchUSIORListVO> searchCostPod(String costDiv) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchUSIORListVO> list = null;
		 
		 Map<String, Object> param    = new HashMap<String, Object>();
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 param.put("cost_div", 		costDiv);
			 velParam.put("cost_div", 		costDiv);
			 log.error("cost_div ========>" + costDiv);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchCostPodListRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUSIORListVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * 조회조건(combo)을 위한 Equipment Office Code 조회<br>
	  * 
	  * @return List<SearchUSIORListVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public List<SearchUSIORListVO> searchEqmtOfcCd() throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchUSIORListVO> list = null;
		 
		 Map<String, Object> param    = new HashMap<String, Object>();
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselReportDBDAOSearchEqmtOfcCdRSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUSIORListVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 }         
           
}