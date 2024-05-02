/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailTransitReportDBDAO.java
*@FileTitle : RailTransitReportDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
* 
* 2009-02-19 iskim
* 	(1) N200902130040	[SCEM] RTR 조회 대상 보완 요청 
* 		delt_flg = 'Y' 인건은 조회 되지 않게 수정
* 2009-03-04 iskim
* 	(1) R200903040003	2월 소스품질 검토 결과 follow-up
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.integration;
   
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.basic.COPSearchBCImpl;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * SCE에 대한 DB 처리를 담당<br>
 * - SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seong-mun Kang
 * @see COPSearchBCImpl 참조
 * @since J2EE 1.4
 */
public class RailTransitReportDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/*============================================= 강성문 =========================================================*/
	/**
     * Car Location Message 총조회수
     * 
     * @param SearchCLMListOptionsVO schClmlOpts
     * @return int
     * @throws DAOException
     */
	  public int searchCLMCount(SearchCLMListOptionsVO schClmlOpts)throws DAOException{
	  	log.debug("searchCLMCount 실행합니다.");
	  	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schClmlOpts != null) {
				Map<String, String> mapVO = schClmlOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchCLMCountRSQL(),
					param, velParam);
		    if(dbRowset.getRowCount()>0){
		    	dbRowset.next();
		    	return dbRowset.getInt(1);
		    }else{
		    	return 0;
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
    
    /**
     * Car Location Message 조회 리스트
     * 
     * @param SearchCLMListOptionsVO schClmlOpts
     * @return DBRowSet
     * @throws DAOException
     */
    
    public DBRowSet searchCLMList(SearchCLMListOptionsVO schClmlOpts)throws DAOException{
    	log.debug("searchCLMListR를 실행합니다.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schClmlOpts != null) {
				Map<String, String> mapVO = schClmlOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}						
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchCLMListRSQL(),
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
     * Car Location Message (POP-UP) 총조회수
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return int
     * @throws DAOException
     */
    public int searchCLMCountPop(SearchRTRInfoVO rtrInfo) throws DAOException {
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	if (rtrInfo != null) {
				Map<String, String> mapVO = rtrInfo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
	        	param.put("cntr_no", rtrInfo.getRCntrNo());
			}
			
			log.debug("param==" + param);
			log.debug("velParam==" + velParam);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchCLMCountRSQL(),
					param, velParam);
			
			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				log.debug("temp === " + temp);
				return temp;
        	}
			return 0;
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /**
     * Car Location Message (POP-UP) 조회 리스트
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchCLMListPop(SearchRTRInfoVO rtrInfo) throws DAOException {
    	log.debug("searchCLMListPop-을 실행합니다.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	if (rtrInfo != null) {
				Map<String, String> mapVO = rtrInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
	        	param.put("cntr_no", rtrInfo.getRCntrNo());
	        	param.put("i_page", rtrInfo.getCurPage());
			    log.debug("PARAM:"+ param);
			    log.debug("velParam:"+ velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchCLMListRSQL(),
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
     * 
     * @param StringBuffer queryStr
     * @param RequestDataSetBC dataSet
     * @param String name
     * @param String alias
     * @param String type
     */
    public void setConditionQuery(StringBuffer queryStr, RequestDataSetBC dataSet, String name, String alias, String type){
    	if(dataSet.get(name)!=null  && !dataSet.get(name).equals("")){
    		queryStr.append(getConditionQuery(dataSet,name,alias,type)) ;
    	}
    	else if(name.equals("bkg_no_split")){
    		dataSet.put(name,"  ") ;
    		queryStr.append(getConditionQuery(dataSet,name,alias,type)) ;
    	}
    }
    
    /**
     * 
     * @param RequestDataSetBC dataSet
     * @param String name
     * @param String alias
     * @param String type
     * @return String
     */
    public String getConditionQuery(RequestDataSetBC dataSet, String name, String alias, String type){
    	StringBuffer condition = new StringBuffer() ;
    	condition.append(type.toUpperCase() + "     ") ;
    	if(alias==null || alias.equals("")){
    		condition.append(name + " = ") ;
    	}
    	else{
    		condition.append(alias + "." + name + " = ") ;
    	}
    	
    	condition.append("'" + JSPUtil.replace(dataSet.get(name).toString(),"'","''") + "' \n") ;
    	
    	return condition.toString() ;
    }
	
	
}