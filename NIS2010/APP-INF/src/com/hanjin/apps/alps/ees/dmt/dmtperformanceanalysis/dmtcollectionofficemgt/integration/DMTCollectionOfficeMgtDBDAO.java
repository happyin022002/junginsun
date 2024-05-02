/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCollectionReportDBDAO.java
*@FileTitle : Current Collection Status by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.18 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.CollectionOfficeFinderVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.OfficeYardListVO;


/**
 * ALPS ChargeCollectionReportDBDAO <br>
 * - ALPS-DMTPerformanceAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang HyoKeun
 * @see ChargeCollectionReportBCImpl 참조
 * @since J2EE 1.6
 */
public class DMTCollectionOfficeMgtDBDAO extends DBDAOSupport {

    /**
    * [DEM/DET Office Inquiry by Yard] 정보를 [SEARCH] 합니다.<br>
    * 
    * @param CollectionOfficeFinderVO collectionOfficeFinderVO
    * @return List<OfficeYardListVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<OfficeYardListVO> searchCollectionOfficeList ( CollectionOfficeFinderVO collectionOfficeFinderVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<OfficeYardListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

            if ( collectionOfficeFinderVO != null ) {

                Map<String, String> mapVO = collectionOfficeFinderVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
/*----------------------------------------------------------------------------------------*/                
                
                String tempDEMDETOFF = (String)collectionOfficeFinderVO.getDemdetoff();
                List<String> tempDEMDETOFFList = new ArrayList<String>();
                
                StringTokenizer st = new StringTokenizer(tempDEMDETOFF, ",");
                while (st.hasMoreTokens()) {
                    tempDEMDETOFFList.add(st.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/

                velParam.put("tempDEMDETOFFList", tempDEMDETOFFList);

            }

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCollectionOfficeMgtDBDAOSearchCollectionOfficeListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeYardListVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    /**
     * [Yard Exception Cost] 정보를 [SEARCH] 합니다.<br>
     * 
     * @param DmtYdExptCostParmVO dmtYdExptCostParmVO
     * @return List<DmtYdExptCostVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
     public List<DmtYdExptCostVO> searchYardExceptionCost( DmtYdExptCostParmVO dmtYdExptCostParmVO  ) throws DAOException {
         DBRowSet dbRowset = null;
         List<DmtYdExptCostVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
        try{
             if ( dmtYdExptCostParmVO != null ) {

                 Map<String, String> mapVO = dmtYdExptCostParmVO.getColumnValues();
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
                 
                 String dmtOfcCd = (String)dmtYdExptCostParmVO.getOfcCd();
                 List<String> dmtOfcList = new ArrayList<String>();
                 
                 StringTokenizer st = new StringTokenizer(dmtOfcCd, ",");
                 while (st.hasMoreTokens()) {
                	 dmtOfcList.add(st.nextToken());
                 }
                 velParam.put("dmtOfcList", dmtOfcList);
               
             }
             

             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCollectionOfficeMgtDBDAOSearchYardExceptionCostRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtYdExptCostVO .class);
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     }


     /**
  	 * Yard Exception Cost 정보를 [저장] 합니다.<br>
  	 * 
  	 * @param DmtYdExptCostVO dmtYdExptCostVO
  	 * @throws DAOException
  	 */
  	public void createYardExceptionCost(DmtYdExptCostVO dmtYdExptCostVO) throws DAOException,Exception {
  		Map<String, Object> param = new HashMap<String, Object>();
  		try {
  			Map<String, String> mapVO = dmtYdExptCostVO.getColumnValues();
			param.putAll(mapVO);
			
  			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DMTCollectionOfficeMgtDBDAOAddYardExceptionCostCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
 
  		} catch (SQLException se) {
  			log.error(se.getMessage(),se);
  			throw new DAOException(new ErrorHandler(se).getMessage());
  		}catch(Exception ex){
  			log.error(ex.getMessage(),ex);
  			throw new DAOException(new ErrorHandler(ex).getMessage());
  		}
  	}    

 	/**
 	 *  Yard Exception Cost 정보를 [수정] 합니다.<br>
 	 * 
 	 * @param DmtYdExptCostVO dmtYdExptCostVO
 	 * @throws DAOException
 	 */
 	public void modifyYardExceptionCost(DmtYdExptCostVO dmtYdExptCostVO) throws DAOException,Exception {
 		Map<String, Object> param = new HashMap<String, Object>();
  		try {
  			Map<String, String> mapVO = dmtYdExptCostVO.getColumnValues();
			param.putAll(mapVO);
 			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
 
 			int result = sqlExe.executeUpdate((ISQLTemplate)new DMTCollectionOfficeMgtDBDAOModifyYardExceptionCostUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
 		
 		} catch (SQLException se) {
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 	}     
    
	
	/**
	 * 다건의  Yard Exception Cost 정보를 Confirm 합니다.<br>
	 * 
	 * @param List<DmtYdExptCostVO> dmtYdExptCostVOs
	 * @param  String cfmCancel
	 * @throws DAOException
	 */
	public void confirmYardExceptionCost(List<DmtYdExptCostVO> dmtYdExptCostVOs, String cfmCancel) throws DAOException,Exception {
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int delCnt[] = null;
			if(dmtYdExptCostVOs.size() > 0){
				velParam.put("cfm_cancel", cfmCancel);
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new DMTCollectionOfficeMgtDBDAOConfirmYardExceptionCostUSQL(), dmtYdExptCostVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	 /**
	  * [YardExceptionCost 중복 Check 합니다.<br>
	  * @param String ydCd
	  * @param String effDt
	  * @param String expDt
	  * @return String
	  * @throws DAOException
	  */
	 public String checkCostDup(String ydCd, String effDt, String expDt) throws DAOException {
		 DBRowSet dbRowset = null;
		 String ydExptCost = ""; 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
      	 
		 try {
			 param.put("yd_cd", ydCd);
			 param.put("eff_dt", effDt);
			 param.put("exp_dt", expDt);
			 dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCollectionOfficeMgtDBDAOCheckCostDupRSQL(),param,null);
			 if(dbRowset.next()){
				 ydExptCost = dbRowset.getString("expt_cost");
           }  			 
       } catch(SQLException se) {
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return ydExptCost;
	 }
	 
	 /**
	 	 *  Yard Exception Cost 정보를 [삭제] 합니다.<br>
	 	 * 
	 	 * @param DmtYdExptCostVO dmtYdExptCostVO
	 	 * @throws DAOException
	 	 */
	 	public void deleteYardExceptionCost(DmtYdExptCostVO dmtYdExptCostVO) throws DAOException,Exception {
	 		Map<String, Object> param = new HashMap<String, Object>();
	  		try {
	  			Map<String, String> mapVO = dmtYdExptCostVO.getColumnValues();
				param.putAll(mapVO);
	 			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
	 
	 			int result = sqlExe.executeUpdate((ISQLTemplate)new DMTCollectionOfficeMgtDBDAODeleteYardExceptionCostDSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
	 		
	 		} catch (SQLException se) {
	 			log.error(se.getMessage(),se);
	 			throw new DAOException(new ErrorHandler(se).getMessage());
	 		}catch(Exception ex){
	 			log.error(ex.getMessage(),ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage());
	 		}
	 	}  
  
}