/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAO.java
*@FileTitle : SPCLCmpnApprovalDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.03 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration.FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintDetailListRSQL;
import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration.FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintMasterListRSQL;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.basic.SPCLCmpnApprovalBCImpl;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalPrintDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalPrintMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnCSRValidCheckVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnCSRDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnCSRHeaderVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnCSRINFtoAPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ComAproCsrDtlVO;


/**
 * ALPS SPCLCmpnApprovalDBDAO <br>
 * - ALPS-ACMApproval system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM YOUNG-OH
 * @see SPCLCmpnApprovalBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class SPCLCmpnApprovalDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation 목록을 조회<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO spcLCmpnApprovalMasterVO
	 * @return List<SPCLCmpnApprovalMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SPCLCmpnApprovalMasterVO> searchSPCLCmpnApprovalMaster(SPCLCmpnApprovalMasterVO spcLCmpnApprovalMasterVO) throws DAOException {
		 DBRowSet dbRowset = null;
		List<SPCLCmpnApprovalMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (spcLCmpnApprovalMasterVO != null) {
				Map<String, String> mapVO= spcLCmpnApprovalMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnApprovalMasterVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation (Detail)목록을 조회<br>
	 *
	 * @param SPCLCmpnApprovalDetailVO spCLCmpnApprovalDetailVO
	 * @return List<SPCLCmpnApprovalDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SPCLCmpnApprovalDetailVO> searchSPCLCmpnApprovalDetail(SPCLCmpnApprovalDetailVO spCLCmpnApprovalDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SPCLCmpnApprovalDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (spCLCmpnApprovalDetailVO != null) {
				Map<String, String> mapVO= spCLCmpnApprovalDetailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnApprovalDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation 엑셀다운 목록을 조회(Excel)<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO
	 * @return List<SPCLCmpnApprovalMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SPCLCmpnApprovalMasterVO> searchSPCLCmpnApprovalExcelDown(SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SPCLCmpnApprovalMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (spCLCmpnApprovalMasterVO != null) {
				Map<String, String> mapVO= spCLCmpnApprovalMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalExcelDownRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnApprovalMasterVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation RD프린트 목록을 조회(Master)<br>
	 *
	 * @param SPCLCmpnApprovalPrintMasterVO spCLCmpnApprovalPrintMasterVO
	 * @return List<SPCLCmpnApprovalPrintMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SPCLCmpnApprovalPrintMasterVO> searchSPCLCmpnApprovalPrintMaster(SPCLCmpnApprovalPrintMasterVO spCLCmpnApprovalPrintMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SPCLCmpnApprovalPrintMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (spCLCmpnApprovalPrintMasterVO != null) {
				Map<String, String> mapVO= spCLCmpnApprovalPrintMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnApprovalPrintMasterVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation RD프린트 목록을 조회(Detail)<br>
	 *
	 * @param SPCLCmpnApprovalPrintDetailVO spCLCmpnApprovalPrintDetailVO
	 * @return List<SPCLCmpnApprovalPrintDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SPCLCmpnApprovalPrintDetailVO> searchSPCLCmpnApprovalPrintDetail(SPCLCmpnApprovalPrintDetailVO spCLCmpnApprovalPrintDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SPCLCmpnApprovalPrintDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (spCLCmpnApprovalPrintDetailVO != null) {
				Map<String, String> mapVO= spCLCmpnApprovalPrintDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnApprovalPrintDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request BKG CREATE DATE CHECK<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO
	 * @return List<SPCLCmpnCSRBkgCreDtCheckVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SPCLCmpnCSRValidCheckVO> searchSPCLCmpnCSRValidCheck(SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SPCLCmpnCSRValidCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (spCLCmpnApprovalMasterVO != null) {
				Map<String, String> mapVO= spCLCmpnApprovalMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRValidCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnCSRValidCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request HEADER 정보 조회<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO
	 * @return SPCLCmpnCSRHeaderVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SPCLCmpnCSRHeaderVO searchSPCLCmpnCSRHeader(SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		SPCLCmpnCSRHeaderVO rtnVO = null;
		List<SPCLCmpnCSRHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (spCLCmpnApprovalMasterVO != null) {
				Map<String, String> mapVO= spCLCmpnApprovalMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRHeaderRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnCSRHeaderVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request GL_DT 조회<br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchSPCLCmpnCSRGLDT(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		List<SPCLCmpnCSRHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (spCLCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO= spCLCmpnCSRHeaderVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRGLDTRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnCSRHeaderVO.class);
			if(list != null && list.size() > 0) {
				rtnValue = list.get(0).getGlDt();
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request AP CSR NO 조회<br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void addSPCLCmpnCSRAPCSRNO(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if (spCLCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = spCLCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnApprovalDBDAOAddSPCLCmpnCSRAPCSRNOCSQL(), Arrays.asList(spCLCmpnCSRHeaderVO), velParam);
				for (int i=0; i<insCnt.length; i++) {
					log.debug("insCnt[i]=>"+insCnt[i]);
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * REV VVD를 변경.<br>
	 * 
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @exception DAOException
	 */
	public void modifySPCLCmpnCSRRevVVD(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(spCLCmpnCSRHeaderVO != null){
				Map<String, String> mapVo = spCLCmpnCSRHeaderVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRRevVVDUSQL(), param,velParam);
			log.debug("result=>"+result);
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request ACM_FF_CMPN CSR_NO 변경 <br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void modifySPCLCmpnCSRMasterCSRNO(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if (spCLCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = spCLCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRMasterCSRNOUSQL(), Arrays.asList(spCLCmpnCSRHeaderVO), velParam);
				for (int i=0; i<updCnt.length; i++) {
					log.debug("updCnt[i]=>"+updCnt[i]);
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request AP_INV_HDR 정보 입력<br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void addSPCLCmpnCSRHeader(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if (spCLCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = spCLCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnApprovalDBDAOAddSPCLCmpnCSRHeaderCSQL(), Arrays.asList(spCLCmpnCSRHeaderVO), velParam);
				for (int i=0; i<insCnt.length; i++) {
					log.debug("insCnt[i]=>"+insCnt[i]);
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @return List<SPCLCmpnCSRDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SPCLCmpnCSRDetailVO> searchSPCLCmpnCSRDetail(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SPCLCmpnCSRDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (spCLCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO= spCLCmpnCSRHeaderVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnCSRDetailVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param List<SPCLCmpnCSRDetailVO> spCLCmpnCSRDetailVOs
	 * @throws DAOException
	 */
	public void addSPCLCmpnCSRDetail(List<SPCLCmpnCSRDetailVO> spCLCmpnCSRDetailVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (spCLCmpnCSRDetailVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnApprovalDBDAOAddSPCLCmpnCSRDetailCSQL(), spCLCmpnCSRDetailVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					log.debug("insCnt[i]=>"+insCnt[i]);
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void modifySPCLCmpnCSRDetail(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(spCLCmpnCSRHeaderVO != null){
				Map<String, String> mapVo = spCLCmpnCSRHeaderVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRDetailUSQL(), param,velParam);
			log.debug("result=>"+result);
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
//			int updCnt[] = null;
//			if (spCLCmpnCSRDetailVOs.size() > 0) {
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRDetailUSQL(), spCLCmpnCSRDetailVOs, null);
//				for (int i=0; i<updCnt.length; i++) {
//					log.debug("updCnt[i]=>"+updCnt[i]);
//					if (updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to Update No"+ i + " SQL");
//				}
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnCSRDetailVO spCLCmpnCSRDetailVO
	 * @throws DAOException
	 */
	public void modifySPCLCmpnCSRACMBkgInfo(SPCLCmpnCSRDetailVO spCLCmpnCSRDetailVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(spCLCmpnCSRDetailVO != null){
				Map<String, String> mapVo = spCLCmpnCSRDetailVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRACMBkgInfoUSQL(), param,velParam);
			log.debug("result=>"+result);
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
//			int updCnt[] = null;
//			if (spCLCmpnCSRDetailVOs.size() > 0) {
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRACMBkgInfoUSQL(), spCLCmpnCSRDetailVOs, null);
//				for (int i=0; i<updCnt.length; i++) {
//					log.debug("updCnt[i]=>"+updCnt[i]);
//					if (updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to Update No"+ i + " SQL");
//				}
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void modifySPCLCmpnCSRHeader(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if (spCLCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = spCLCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRHeaderUSQL(), Arrays.asList(spCLCmpnCSRHeaderVO), velParam);
				for (int i=0; i<updCnt.length; i++) {
					log.debug("updCnt[i]=>"+updCnt[i]);
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @return ComAproCsrDtlVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ComAproCsrDtlVO searchSPCLCmpnCSRInfo(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		ComAproCsrDtlVO rtnVO = null;
		List<ComAproCsrDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (spCLCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO= spCLCmpnCSRHeaderVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComAproCsrDtlVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			} else {
				rtnVO = new ComAproCsrDtlVO();
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void modifySPCLCmpnCSRACMMaster(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if (spCLCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = spCLCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRACMMasterUSQL(), Arrays.asList(spCLCmpnCSRHeaderVO), velParam);
				for (int i=0; i<updCnt.length; i++) {
					log.debug("updCnt[i]=>"+updCnt[i]);
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void modifySPCLCmpnCSRHeader2(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if (spCLCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = spCLCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRHeader2USQL(), Arrays.asList(spCLCmpnCSRHeaderVO), velParam);
				for (int i=0; i<updCnt.length; i++) {
					log.debug("updCnt[i]=>"+updCnt[i]);
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnCSRDetailVO spCLCmpnCSRDetailVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSPCLCmpnCSRDetailVVDCNTCheck(SPCLCmpnCSRDetailVO spCLCmpnCSRDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (spCLCmpnCSRDetailVO != null) {
				Map<String, String> mapVO= spCLCmpnCSRDetailVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRDetailVVDCNTCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("vvd_count");
			} else {
				rtnValue = "";
			}
			log.debug("rtnValue=>"+rtnValue);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnCSRDetailVO spCLCmpnCSRDetailVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSPCLCmpnCSRDetailVVDCDCheck(SPCLCmpnCSRDetailVO spCLCmpnCSRDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (spCLCmpnCSRDetailVO != null) {
				Map<String, String> mapVO= spCLCmpnCSRDetailVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRDetailVVDCDCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("vvd_cd");
			} else {
				rtnValue = "";
			}
			log.debug("rtnValue=>"+rtnValue);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param String vvd_cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSPCLCmpnCSRDetailVVDCOMLVLCheck(String vvd_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (vvd_cd != null) {
				
				param.put("vvd_cd", vvd_cd );
				velParam.put("vvd_cd", vvd_cd );
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRDetailVVDCOMLVLCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("lvl");
			} else {
				rtnValue = "";
			}
			log.debug("rtnValue=>"+rtnValue);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param String vvd_lvl
	 * @param String acct_cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSPCLCmpnCSRDetailVVDLVLFLGCheck(String vvd_lvl, String acct_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (vvd_lvl != null) {
				param.put("vvd_lvl", vvd_lvl );
				velParam.put("vvd_lvl", vvd_lvl );
				param.put("acct_cd", acct_cd );
				velParam.put("acct_cd", acct_cd );
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRDetailVVDLVLFLGCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("vvd_lvl_flg");
			} else {
				rtnValue = "";
			}
			log.debug("rtnValue=>"+rtnValue);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
	 * @return List<SPCLCmpnCSRINFtoAPVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SPCLCmpnCSRINFtoAPVO> searchSPCLINFtoAP(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SPCLCmpnCSRINFtoAPVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (spCLCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO= spCLCmpnCSRHeaderVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRINFtoAPRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnCSRINFtoAPVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}