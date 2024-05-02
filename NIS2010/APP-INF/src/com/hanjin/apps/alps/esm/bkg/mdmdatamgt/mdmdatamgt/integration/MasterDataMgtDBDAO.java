/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : MasterDataMgtDBDAO.java
*@FileTitle : MDM DATA Management
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.28
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.basic.MasterDataMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.MdmStateVO;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchBkgIdaSacMstVO;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchMdmChargeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgIdaSacMstVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;


/**
 * ALPS MasterDataMgtDBDAO <br>
 * - ALPS-MdmDataMgtSC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SONG Min Seok
 * @see MasterDataMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class MasterDataMgtDBDAO extends DBDAOSupport {


	/**
	 * MDM_CHARGE LIST 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @author SONG Min Seok
	 * @param SearchMdmChargeVO paramVO
	 * @return List<SearchMdmChargeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMdmChargeVO> searchMdmChargeList (SearchMdmChargeVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMdmChargeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(paramVO != null){
				Map<String, String> mapVO = paramVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MasterDataMgtDBDAOSearchMdmChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMdmChargeVO .class);
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
     * India SAC Master LIST 데이타 모델에 해당되는 값을 불러온다.<br>
     * @author SONG Min Seok
     * @param SearchBkgIdaSacMstVO paramVO
     * @return List<SearchMdmChargeVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
    public List<SearchBkgIdaSacMstVO> searchIndiaSacMasterList (SearchBkgIdaSacMstVO paramVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchBkgIdaSacMstVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(paramVO != null){
                Map<String, String> mapVO = paramVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MasterDataMgtDBDAOSearchBkgIdaSacMstRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBkgIdaSacMstVO .class);
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
	 * MDM_CHARGE의 정보중 mdm에서 interface 되지 않는 일부 정보를 update한다.<br>
	 * @author SONG Min Seok
	 * @param List<MdmChargeVO> mdmChargeVOs
	 * @exception  DAOException
	 */
    public void modifyMdmChargeList(List<MdmChargeVO> mdmChargeVOs) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();           
 
            if (mdmChargeVOs.size() > 0) {
                for(int i = 0 ; i < mdmChargeVOs.size() ; i++){
                    if(mdmChargeVOs.get(i) != null){
                        Map<String, String> mapVO = mdmChargeVOs.get(i).getColumnValues();

                        param.putAll(mapVO);
                        velParam.putAll(mapVO);             
                        
                        int updCnt = sqlExe.executeUpdate((ISQLTemplate)new MasterDataMgtDBDAOSearchMdmChargeUSQL(), param,velParam);
                        if(updCnt == Statement.EXECUTE_FAILED)
                            throw new EventException(new ErrorHandler("BKG08059", new String[] { mdmChargeVOs.get(i).getChgCd(), String.valueOf(i) }).getUserMessage());                       
                    }   
                }
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }	
    
	/**
	 * MDM State 정보 조회<br>
	 * @author Lim Jin Young
	 * @param List<mdmStateVOs> mdmStateVOs
	 * @exception  DAOException
	 */
    public List<MdmStateVO> searchMdmStateList(MdmStateVO  paramVO) throws DAOException {
    	DBRowSet dbRowset = null;
		List<MdmStateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(paramVO != null){
				Map<String, String> mapVO = paramVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MasterDataMgtDBDAOSearchMdmStateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmStateVO .class);
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
	 * MDM State의 일부 정보를 update한다.<br>
	 * @author Lim Jin Young
	 * @param List<MdmChargeVO> mdmStateVOs
	 * @exception  DAOException
	 */
    public void modifyMdmState(List<MdmStateVO> mdmStateVOs) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();           

            if (mdmStateVOs.size() > 0) {
                for(int i = 0 ; i < mdmStateVOs.size() ; i++){
                    if(mdmStateVOs.get(i) != null){
                        Map<String, String> mapVO = mdmStateVOs.get(i).getColumnValues();

                        param.putAll(mapVO);
                        velParam.putAll(mapVO);             
                        
                        int updCnt = sqlExe.executeUpdate((ISQLTemplate)new MasterDataMgtDBDAOMdmStateUSQL(), param,velParam);
                        if(updCnt == Statement.EXECUTE_FAILED)
                            throw new EventException(new ErrorHandler("BKG08059", new String[] { mdmStateVOs.get(i).getChgCd(), String.valueOf(i) }).getUserMessage());                       
                    }   
                }
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }	
    
    
    
    /**
     * India SAC Master 정보를  update한다.<br>
     * @author SONG Min Seok
     * @param List<BkgIdaSacMstVO> bkgIdaSacMstVOs
     * @exception  DAOException
     */
    public void manageBkgIdaSacMstList(List<BkgIdaSacMstVO> bkgIdaSacMstVOs) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();           

            if (bkgIdaSacMstVOs.size() > 0) {
                for(int i = 0 ; i < bkgIdaSacMstVOs.size() ; i++){
                    if(bkgIdaSacMstVOs.get(i) != null){
                        Map<String, String> mapVO = bkgIdaSacMstVOs.get(i).getColumnValues();

                        param.putAll(mapVO);
                        velParam.putAll(mapVO);             
                         
                        int updCnt = sqlExe.executeUpdate((ISQLTemplate)new MasterDataMgtDBDAOBkgIdaSacMstUSQL(), param,velParam);
                        if(updCnt == Statement.EXECUTE_FAILED)
                            throw new EventException(new ErrorHandler("BKG08059", new String[] { bkgIdaSacMstVOs.get(i).getIdaSacCd(), String.valueOf(i) }).getUserMessage());                       
                    }   
                }
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }   
	 
}


