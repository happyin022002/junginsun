/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGInternalFinderDBDAO.java
*@FileTitle : SCG COMMON
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.02 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBCImpl;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.CheckUNNumberVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchImdgAmdtMstVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchUNNumberVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;
import com.clt.syscommon.common.table.ScgImdgUnNoVO;
import com.clt.syscommon.common.table.ScgIrrTpCdVO;


/**
 * OPUS SCGInternalFinderDBDAO <br>
 * - OPUS-SCGCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Dohyoung Lee
 * @see SCGInternalFinderBCImpl 참조
 * @since J2EE 1.6
 */
public class SCGInternalFinderDBDAO extends DBDAOSupport {

	/**
	 * UN No.를 조회 합니다. <br>
	 * 
	 * @param  ScgImdgUnNoVO scgImdgUnNoVO
	 * @return List<CheckUNNumberVO>
	 * @throws DAOException
	 */
	public List<CheckUNNumberVO> checkUNNumber(ScgImdgUnNoVO scgImdgUnNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckUNNumberVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgUnNoVO != null){
				Map<String, String> mapVO = scgImdgUnNoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOCheckUNNumberRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckUNNumberVO .class);
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
	 * Class 를 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgClssCdVO>
	 * @throws DAOException
	 */
	public List<ScgImdgClssCdVO> searchUNClass() throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgClssCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchUNClassRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgClssCdVO .class);
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
	 * Special Provision 의 List를 조회 합니다. <br>
	 * 
	 * @param  String spclProviNo
	 * @return List<ScgImdgSpclProviVO>
	 * @throws DAOException
	 */
	public List<ScgImdgSpclProviVO> checkSpclProvi(String spclProviNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgSpclProviVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spclProviNo != null){
		    	param.put("imdg_spcl_provi_no", spclProviNo);
		    	velParam.put("imdg_spcl_provi_no", spclProviNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOCheckSpclProviRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSpclProviVO .class);
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
	 * Irregular Type 의 List를 조회 합니다. <br>
	 * 
	 * @param  ScgIrrTpCdVO scgIrrTpCdVO
	 * @return List<ScgIrrTpCdVO>
	 * @throws DAOException
	 */
	public List<ScgIrrTpCdVO> searchIrregularType(ScgIrrTpCdVO scgIrrTpCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgIrrTpCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgIrrTpCdVO != null){
				Map<String, String> mapVO = scgIrrTpCdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOScgIrrTpCdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgIrrTpCdVO .class);
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
	 * IMDG UN Number 의 List를 조회 합니다. <br>
	 * 
	 * @param  SearchUNNumberVO searchUNNumberVO
	 * @return List<SearchUNNumberVO>
	 * @throws DAOException
	 */
	public List<SearchUNNumberVO> searchUNNumber(SearchUNNumberVO searchUNNumberVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUNNumberVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		
 
        String currentPage =  searchUNNumberVO.getIpage();
        String startPart   =  "";
        String endPart     =  "";
        if( currentPage == null ){currentPage="";}
        if ( !currentPage.equals("")){
            startPart    =   Integer.parseInt(  searchUNNumberVO.getPagerows() ) *  (Integer.parseInt( currentPage ) - 1) + 1+ "";
            endPart      =   Integer.parseInt(  searchUNNumberVO.getPagerows() ) *  (Integer.parseInt( currentPage )    )    + "";             
        }
         
		try{
 
			Map<String, String> mapVO = searchUNNumberVO.getColumnValues();
			param.putAll(mapVO);
            param.put("startpart", startPart);
            param.put("endpart"  , endPart);			
			velParam.putAll(param);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchUNNumberRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUNNumberVO .class);
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
     * IMDG UN Number 의 Total 건수를 조회 합니다. <br>
     * 
     * @param  SearchUNNumberVO searchUNNumberVO
     * @return String
     * @throws DAOException
     */
 
    public String searchUNNumberTotalCnt(SearchUNNumberVO searchUNNumberVO) throws DAOException {
        DBRowSet dbRowset = null;
        String totalcnt = "0";
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
 
         
        try{
 
            Map<String, String> mapVO = searchUNNumberVO.getColumnValues();
            param.putAll(mapVO);         
            velParam.putAll(param);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchUNNumberTotalCntRSQL(), param, velParam);
            if( dbRowset.next() ){
                totalcnt =   dbRowset.getString("TOTAL_CNT");  
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return totalcnt;
    }   
    
    /**
     * 
     * SPCL CGO Irregular List 의 UN No. 를 Check 합니다. <br>
     * 
     * @param  SearchUNNumberVO searchUNNumberVO
     * @author jang kang cheol
     * @throws DAOException
     * @return List<SearchUNNumberVO>
     * @author jang kang cheol
     */
    public List<SearchUNNumberVO> checkIrrUnNoList(SearchUNNumberVO searchUNNumberVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchUNNumberVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{            
            Map<String, String> mapVO = searchUNNumberVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);            
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOCheckIrrUnNoListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUNNumberVO .class);
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
	 * UN No.를 콤보형태로 조회 합니다. <br>
	 * 
	 * @param  ScgImdgUnNoVO scgImdgUnNoVO
	 * @return List<CheckUNNumberVO>
	 * @throws DAOException
	 */
	public List<CheckUNNumberVO> searchUNNo(ScgImdgUnNoVO scgImdgUnNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckUNNumberVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgUnNoVO != null){
				Map<String, String> mapVO = scgImdgUnNoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchUNNumberComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckUNNumberVO .class);
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
     * 특정Port의 RSO 조회 합니다. <br>
     * 
     * @param LocationVO locationVO
     * @return String
     * @throws EventException
     */
 
    public String searchRSOforSpecificPort(LocationVO locationVO) throws DAOException {
    	
        DBRowSet 	dbRowset 	= null;
        String		sRtnValue	= null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
         
        try{
 
            Map<String, String> mapVO = locationVO.getColumnValues();
            
            param.putAll(mapVO);         

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchRSOforSpecificPortRSQL(), param, null);
            if( dbRowset.next() ){
            	sRtnValue =   dbRowset.getString("RGN_SHP_OPR_CD");  
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return sRtnValue;
    }  
    
    /**
     * 로그인 User의 RSO 조회 합니다. <br>
     * 
     * @param String usrId
     * @return String
     * @throws EventException
     */
 
    public String searchRSOforUser(String usrId) throws DAOException {
    	
        DBRowSet 	dbRowset 	= null;
        String		sRtnValue	= null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
         
        try{
 
            param.put("usr_id", usrId);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchRSOforUserRSQL(), param, null);
            if( dbRowset.next() ){
            	sRtnValue =   dbRowset.getString("RGN_SHP_OPR_CD");  
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return sRtnValue;
    }  
    
    
    /**
	 * SCG_IMDG_AMDT_MST 정보를조회 합니다. <br>
	 * 
	 * @param  SearchImdgAmdtMstVO searchImdgAmdtMstVO
	 * @return List<SearchImdgAmdtMstVO>
	 * @throws DAOException
	 */
	public List<SearchImdgAmdtMstVO> searchImdgAmdtMst(SearchImdgAmdtMstVO searchImdgAmdtMstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchImdgAmdtMstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchImdgAmdtMstVO != null){
				Map<String, String> mapVO = searchImdgAmdtMstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchImdgAmdtMstRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchImdgAmdtMstVO .class);
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
	 * SCG_IMDG_AMDT_MST List 정보를조회 합니다. <br>
	 * 
	 * @param  SearchImdgAmdtMstVO searchImdgAmdtMstVO
	 * @return List<SearchImdgAmdtMstVO>
	 * @throws DAOException
	 */
	public List<SearchImdgAmdtMstVO> searchImdgAmdtMstList(SearchImdgAmdtMstVO searchImdgAmdtMstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchImdgAmdtMstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchImdgAmdtMstVO != null){
				Map<String, String> mapVO = searchImdgAmdtMstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchImdgAmdtMstListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchImdgAmdtMstVO .class);
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
	 * SCG_IMDG_UN_NO 의  IMDG_AMDT_NO 정보를조회 합니다. <br>
	 * 
	 * @param  ScgImdgUnNoVO scgImdgUnNoVO
	 * @return List<ScgImdgUnNoVO>
	 * @throws DAOException
	 */
	public List<ScgImdgUnNoVO> searchImdgAmdtNo(ScgImdgUnNoVO scgImdgUnNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgUnNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgUnNoVO != null){
				Map<String, String> mapVO = scgImdgUnNoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchImdgAmdtNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgUnNoVO .class);
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