/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityGuidelineDAO.java
*@FileTitle : Commondity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.basic.RFAGroupCommodityGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.PriRgGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.RsltPriRgGrpCmdtDtlVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriRgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriRgGrpCmdtVO;
import com.clt.syscommon.common.table.PriRgMnVO;


/**
 *  RFAGroupCommodityGuidelineDAO <br>
 * - SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kong Back Jin
 * @see RFAGroupCommodityGuidelineBCImpl 참조
 * @since J2EE 1.4
 */
public class RFAGroupCommodityGuidelineDBDAO extends DBDAOSupport {

	/**
	 * PRI_RG_GRP_CMDT을 조회합니다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<PriRgGrpCmdtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriRgGrpCmdtVO> searchGroupCommodityGuidelineList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRgGrpCmdtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(priRgGrpCmdtVO != null){
				Map<String, String> mapVO = priRgGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRgGrpCmdtVO .class);
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
	 * PRI_RG_GRP_CMDT_DTL을 조회합니다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<RsltPriRgGrpCmdtDtlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriRgGrpCmdtDtlVO> searchGroupCommodityGuidelineDtlList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRgGrpCmdtDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		
		try{
			if(priRgGrpCmdtVO != null){
				Map<String, String> mapVO = priRgGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRgGrpCmdtDtlVO .class);
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
	 * PRI_RG_GRP_CMDT을 생성합니다.<br>
	 * 
	 * @param List<PriRgGrpCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addmanageGroupCommodityGuidelineS(List<PriRgGrpCmdtVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_RG_GRP_CMDT_DTL을 생성합니다.<br>
	 * 
	 * @param List<PriRgGrpCmdtDtlVO> insModels
	 * @exception DAOException
	 */
	public void addmanageGroupCommodityGuidelineDtl(List<PriRgGrpCmdtDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtDtlVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * PRI_RG_GRP_CMDT을 수정합니다.<br>
	 * 
	 * @param List<PriRgGrpCmdtVO> updModels
	 * @exception DAOException
	 */
	public void modifymanageGroupCommodityGuidelineS(List<PriRgGrpCmdtVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * PRI_RG_GRP_CMDT_DTL을 수정합니다.<br>
	 * 
	 * @param List<PriRgGrpCmdtDtlVO> updModels
	 * @exception DAOException
	 */
	public void modifymanageGroupCommodityGuidelineDtl(List<PriRgGrpCmdtDtlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtDtlVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**
	 * PRI_RG_GRP_CMDT을 삭제합니다.<br>
	 * 
	 * @param List<PriRgGrpCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removemanageGroupCommodityGuidelineS(List<PriRgGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * PRI_RG_GRP_CMDT_DTL을 삭제합니다.<br>
	 * 
	 * @param List<PriRgGrpCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removemanageGroupCommodityGuidelineDtlS(List<PriRgGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtDtlAllVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**
	 * PRI_RG_GRP_CMDT_DTL을 삭제합니다.<br>
	 * 
	 * @param List<PriRgGrpCmdtDtlVO> delModels
	 * @exception DAOException
	 */
	public void removemanageGroupCommodityGuidelineDtl(List<PriRgGrpCmdtDtlVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtDtlVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	
	/**
	 * PRI_RG_GRP_CMDT을 삭제합니다.<br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainGroupCommodity(PriRgMnVO priRgMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priRgMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgMnDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}	

	/**
	 * PRI_RG_GRP_CMDT_DTL을 삭제합니다.<br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainGroupCommodityDetail(PriRgMnVO priRgMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priRgMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgMnDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}		
		
	/**
	 * RATE에서 사용하는 COMMODITY 를 조회한다.
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchGroupCommodityInUse(PriRgGrpCmdtVO priRgGrpCmdtVO) throws DAOException {
		DBRowSet dbRowsetDtl = null;
		List<RsltCdListVO> listDtl = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRgGrpCmdtVO != null) {
				Map<String, String> mapVO = priRgGrpCmdtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowsetDtl = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGroupCommodityGuidelineDBDAOCheckGroupCommodityInUseVORSQL(), param, velParam);

			listDtl = (List) RowSetUtil.rowSetToVOs(dbRowsetDtl, RsltCdListVO.class);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return listDtl;
	}	

    /**
     * Copy 한 RFA Guideline Group Commodity 정보를 생성합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @exception DAOException
     */
    public void addGlineCopyGroupCommodity(RsltRfaGlineCopyVO rsltRfaGlineCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = rsltRfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFAGroupCommodityGuidelineDBDAOGlineCopyCmdtCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return;
    }

    /**
     * Copy 한 RFA Guideline Group Commodity Detail 정보를 생성합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @exception DAOException
     */
    public void addGlineCopyGroupCommodityDetail(RsltRfaGlineCopyVO rsltRfaGlineCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = rsltRfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate(
                    (ISQLTemplate) new RFAGroupCommodityGuidelineDBDAOGlineCopyCmdtDtlCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return;
    }
    
	/**
	 * SCGroupCommodityGuidelineDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<PriRgGrpCmdtExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriRgGrpCmdtExcelVO> searchGroupCommodityGuidelineExcelList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRgGrpCmdtExcelVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(priRgGrpCmdtVO != null){
				Map<String, String> mapVO = priRgGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAGroupCommodityGuidelineDBDAOPriRgGrpCmdtExcelRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRgGrpCmdtExcelVO .class);
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
