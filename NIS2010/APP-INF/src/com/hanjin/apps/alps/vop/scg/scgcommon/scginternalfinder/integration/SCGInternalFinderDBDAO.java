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
package com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBCImpl;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.CheckUNNumberVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.SearchUNNumberVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.CheckPckCdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgSpclProviVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoVO;
import com.hanjin.syscommon.common.table.ScgIrrTpCdVO;


/**
 * ALPS SCGInternalFinderDBDAO <br>
 * - ALPS-SCGCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Dohyoung Lee
 * @see SCGInternalFinderBCImpl 참조
 * @since J2EE 1.6
 */
public class SCGInternalFinderDBDAO extends DBDAOSupport {

	/**
	 * UN No.를 조회 합니다. <br>
	 * 
	 * @param  String unNumberCode
	 * @return List<CheckUNNumberVO>
	 * @throws DAOException
	 */
	public List<CheckUNNumberVO> checkUNNumber(String unNumberCode) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckUNNumberVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(unNumberCode != null){
		    	param.put("imdg_un_no", unNumberCode);
		    	velParam.put("imdg_un_no", unNumberCode);
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
     * IMDG UN Number 의 Seq List 를 조회 합니다. <br>
     * 
     * @param  ScgImdgUnNoVO scgImdgUnNoVO
     * @return List<ScgImdgUnNoVO>
     * @throws DAOException
     */
    public List<ScgImdgUnNoVO> searchImdgUnNoSeqList(ScgImdgUnNoVO scgImdgUnNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ScgImdgUnNoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
 
         
        try{
 
            Map<String, String> mapVO = scgImdgUnNoVO.getColumnValues();
            param.putAll(mapVO);         
            velParam.putAll(param);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchImdgUnNoSeqListRSQL(), param, velParam);
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

    /**
     * IMDG UN No, IMDG UN No Seq 의 Class, Sub Risk, PG 를 조회 합니다. <br>
     * 
     * @param  ScgImdgUnNoVO scgImdgUnNoVO
     * @return List<PartnerApprovalRequestVO>
     * @throws DAOException
     */
    public List<PartnerApprovalRequestVO> searchClassSubRiskPGData(ScgImdgUnNoVO scgImdgUnNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PartnerApprovalRequestVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
 
         
        try{
 
            Map<String, String> mapVO = scgImdgUnNoVO.getColumnValues();
            param.putAll(mapVO);         
            velParam.putAll(param);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOSearchClassSubRiskPGRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PartnerApprovalRequestVO .class);
            
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param pckCd
	 * @return List<CheckPckCdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CheckPckCdVO> checkPckCd(String pckCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CheckPckCdVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(pckCd != null){
				 param.put("imdg_pck_instr_cd", pckCd);
				 velParam.put("imdg_pck_instr_cd", pckCd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGInternalFinderDBDAOCheckPckCdRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckPckCdVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
    
}