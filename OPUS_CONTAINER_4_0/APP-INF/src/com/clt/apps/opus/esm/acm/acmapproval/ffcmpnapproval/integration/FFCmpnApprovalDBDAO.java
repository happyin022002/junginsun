/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalDBDAO.java
*@FileTitle : FFCmpnApprovalDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.03 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.basic.FFCmpnApprovalBCImpl;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalPrintDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalPrintMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnCSRValidCheckVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnCSRDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnCSRHeaderVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnCSRINFtoAPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ComAproCsrDtlVO;


/**
 * OPUS FFCmpnApprovalDBDAO <br>
 * - OPUS-ACMApproval system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM YOUNG-OH
 * @see FFCmpnApprovalBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class FFCmpnApprovalDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation (Master)목록을 조회<br>
	 *
	 * @param FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO
	 * @return List<FFCmpnApprovalMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnApprovalMasterVO> searchFFCmpnApprovalMaster(FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnApprovalMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnApprovalMasterVO != null) {
				Map<String, String> mapVO= ffCmpnApprovalMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnApprovalMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnApprovalMasterVO.class);
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
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation (Detail)목록을 조회<br>
	 *
	 * @param FFCmpnApprovalDetailVO ffCmpnApprovalDetailVO
	 * @return List<FFCmpnApprovalDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnApprovalDetailVO> searchFFCmpnApprovalDetail(FFCmpnApprovalDetailVO ffCmpnApprovalDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnApprovalDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnApprovalDetailVO != null) {
				Map<String, String> mapVO= ffCmpnApprovalDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnApprovalDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnApprovalDetailVO.class);
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
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation 엑셀다운 목록을 조회(Excel)<br>
	 *
	 * @param FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO
	 * @return List<FFCmpnApprovalMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnApprovalMasterVO> searchFFCmpnApprovalExcelDown(FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnApprovalMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnApprovalMasterVO != null) {
				Map<String, String> mapVO= ffCmpnApprovalMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnApprovalExcelDownRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnApprovalMasterVO.class);
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
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation RD프린트 목록을 조회(Master)<br>
	 *
	 * @param FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO
	 * @return List<FFCmpnApprovalPrintMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnApprovalPrintMasterVO> searchFFCmpnApprovalPrint(FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnApprovalPrintMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnApprovalPrintMasterVO != null) {
				Map<String, String> mapVO= ffCmpnApprovalPrintMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnApprovalPrintMasterVO.class);
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
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation CSR_RD프린트 목록을 조회(Master)<br>
	 *
	 * @param FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO
	 * @return List<FFCmpnApprovalPrintMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnApprovalPrintMasterVO> searchFFCmpnApprovalPrintMaster(FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnApprovalPrintMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnApprovalPrintMasterVO != null) {
				Map<String, String> mapVO= ffCmpnApprovalPrintMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnApprovalPrintMasterVO.class);
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
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation CSR_RD프린트 목록을 조회(Detail)<br>
	 *
	 * @param FFCmpnApprovalPrintDetailVO ffCmpnApprovalPrintDetailVO
	 * @return List<FFCmpnApprovalPrintDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnApprovalPrintDetailVO> searchFFCmpnApprovalPrintDetail(FFCmpnApprovalPrintDetailVO ffCmpnApprovalPrintDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnApprovalPrintDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnApprovalPrintDetailVO != null) {
				Map<String, String> mapVO= ffCmpnApprovalPrintDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnApprovalPrintDetailVO.class);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request BKG CREATE DATE CHECK<br>
	 *
	 * @param FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO
	 * @return List<FFCmpnCSRValidCheckVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<FFCmpnCSRValidCheckVO> searchFFCmpnCSRValidCheck(FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<FFCmpnCSRValidCheckVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if (ffCmpnApprovalMasterVO != null) {
				 Map<String, String> mapVO= ffCmpnApprovalMasterVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnCSRValidChekRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnCSRValidCheckVO.class);

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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request HEADER 정보 조회<br>
	 *
	 * @param FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO
	 * @return FFCmpnCSRHeaderVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public FFCmpnCSRHeaderVO searchFFCmpnCSRHeader(FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnCSRHeaderVO> list = null;
		FFCmpnCSRHeaderVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnApprovalMasterVO != null) {
				Map<String, String> mapVO= ffCmpnApprovalMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnCSRHeaderRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnCSRHeaderVO.class);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request GL_DT 조회<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchFFCmpnCSRGLDT(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		String glDt = null;
		List<FFCmpnCSRHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO= ffCmpnCSRHeaderVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnCSRGLDTRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnCSRHeaderVO.class);
			log.debug("<><><><>==========>>"+list.isEmpty());
			log.debug("<><><><>==========>>"+list.size());
			if(list == null){
				log.debug("<><><><>==========null >>");
			} else {
				log.debug("<><><><>=====not ====null >>");
			}
			if(list != null && list.size() > 0) {
				glDt = list.get(0).getGlDt();
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return glDt;
	}

	/**
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request AP CSR NO 조회<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void addFFCmpnCSRAPCSRNO(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (ffCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = ffCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);

				insCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnApprovalDBDAOAddFFCmpnCSRAPCSRNOCSQL(), Arrays.asList(ffCmpnCSRHeaderVO), velParam);
				for (int i=0; i<insCnt.length; i++) {
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * REV VVD를 변경.<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @exception DAOException
	 */
	public void modifyFFCmpnCSRRevVVD(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(ffCmpnCSRHeaderVO != null){
				Map<String, String> mapVo = ffCmpnCSRHeaderVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnCSRRevVVDUSQL(), param,velParam);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request ACM_FF_CMPN CSR_NO 변경 <br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void modifyFFCmpnCSRMasterCSRNO(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (ffCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = ffCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);

				updCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnCSRMasterCSRNOUSQL(), Arrays.asList(ffCmpnCSRHeaderVO), velParam);
				log.debug("updCnt.length=>"+updCnt.length);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request AP_INV_HDR 정보 입력<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void addFFCmpnCSRHeader(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (ffCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = ffCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);

				insCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnApprovalDBDAOAddFFCmpnCSRHeaderCSQL(), Arrays.asList(ffCmpnCSRHeaderVO), velParam);
				log.debug("insCnt=>"+insCnt);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @return List<FFCmpnCSRDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnCSRDetailVO> searchFFCmpnCSRDetail(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnCSRDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO= ffCmpnCSRHeaderVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnCSRDetailVO.class);
			log.debug("[searchFFCmpnCSRDetail] list=>"+list);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param List<FFCmpnCSRDetailVO> ffCmpnCSRDetailVOs
	 * @throws DAOException
	 */
	public void addFFCmpnCSRDetail(List<FFCmpnCSRDetailVO> ffCmpnCSRDetailVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (ffCmpnCSRDetailVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnApprovalDBDAOAddFFCmpnCSRDetailCSQL(), ffCmpnCSRDetailVOs, null);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void modifyFFCmpnCSRDetail(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(ffCmpnCSRHeaderVO != null){
				Map<String, String> mapVo = ffCmpnCSRHeaderVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnCSRDetailUSQL(), param,velParam);
			log.debug("result=>"+result);
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
//			int updCnt[] = null;
//			if (ffCmpnCSRHeaderVO != null) {
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnCSRDetailUSQL(), ffCmpnCSRDetailVOs, null);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnCSRDetailVO ffCmpnCSRDetailVO
	 * @throws DAOException
	 */
	public void modifyFFCmpnCSRACMBkgInfo(FFCmpnCSRDetailVO ffCmpnCSRDetailVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(ffCmpnCSRDetailVO != null){
				Map<String, String> mapVo = ffCmpnCSRDetailVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnCSRACMBkgInfoUSQL(), param,velParam);
			log.debug("result=>"+result);
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int updCnt[] = null;
//			if (ffCmpnCSRDetailVOs.size() > 0) {
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnCSRACMBkgInfoUSQL(), ffCmpnCSRDetailVOs, null);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void modifyFFCmpnCSRHeader(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (ffCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = ffCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);

				updCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnCSRHeaderUSQL(), Arrays.asList(ffCmpnCSRHeaderVO), velParam);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @return FFCmpnCSRHeaderVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ComAproCsrDtlVO searchFFCmpnCSRInfo(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComAproCsrDtlVO> list = null;
		ComAproCsrDtlVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO= ffCmpnCSRHeaderVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnCSRInfoRSQL(), param, velParam);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void modifyFFCmpnCSRACMMaster(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (ffCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = ffCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);

				updCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnCSRACMMasterUSQL(), Arrays.asList(ffCmpnCSRHeaderVO), velParam);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @throws DAOException
	 */
	public void modifyFFCmpnCSRHeader2(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (ffCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO = ffCmpnCSRHeaderVO.getColumnValues();
				velParam.putAll(mapVO);

				updCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnCSRHeader2USQL(), Arrays.asList(ffCmpnCSRHeaderVO), velParam);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
	 * @return List<FFCmpnCSRINFtoAPVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnCSRINFtoAPVO> searchFFINFtoAP(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnCSRINFtoAPVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnCSRHeaderVO != null) {
				Map<String, String> mapVO= ffCmpnCSRHeaderVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnCSRINFtoAPRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnCSRINFtoAPVO.class);

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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnCSRDetailVO ffCmpnCSRDetailVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchFFCmpnCSRDetailVVDCNTCheck(FFCmpnCSRDetailVO ffCmpnCSRDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnCSRDetailVO != null) {
				Map<String, String> mapVO= ffCmpnCSRDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailVVDCNTCheckRSQL(), param, velParam);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnCSRDetailVO ffCmpnCSRDetailVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchFFCmpnCSRDetailVVDCDCheck(FFCmpnCSRDetailVO ffCmpnCSRDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnCSRDetailVO != null) {
				Map<String, String> mapVO= ffCmpnCSRDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailVVDCDCheckRSQL(), param, velParam);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param String vvd_cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchFFCmpnCSRDetailVVDCOMLVLCheck(String vvd_cd) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailVVDCOMLVLCheckRSQL(), param, velParam);
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
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param String vvd_lvl
	 * @param String acct_cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchFFCmpnCSRDetailVVDLVLFLGCheck(String vvd_lvl, String acct_cd) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailVVDLVLFLGCheckRSQL(), param, velParam);
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
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param String csr_no
	 * @return result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyFFApprovalRequesttoEP(String csr_no) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if (csr_no != null) {
				param.put("csr_no", csr_no );
				velParam.put("csr_no", csr_no );
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnApprovalRequesttoEPUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param String csr_no
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws EventException
	 */
	public DBRowSet searchFFActualINFtoAP(String csr_no) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (csr_no != null) {
				param.put("csr_no", csr_no );
				velParam.put("csr_no", csr_no );
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnApprovalDBDAOSearchFFCmpnActualINFtoAPRSQL(), param, velParam);
			if ( 1 > dbRowset.getRowCount())
			{
				//CSR No has already Interfaced! Please check up CSR No[$]
				throw new DAOException((new ErrorHandler("AGT00029", csr_no)).getMessage());
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
    }
	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param String title_name
	 * @param String csr_no
	 * @return result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyApprovalStep(String title_name, String csr_no) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if (csr_no != null) {
				param.put("csr_no", csr_no );
				velParam.put("csr_no", csr_no );
				param.put("title_name", title_name );
				velParam.put("title_name", title_name );
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new FFCmpnApprovalDBDAOModifyApprovalStepUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * modifyApprovalStep<br>
	 *
	 * @param String csr_no
	 * @return int
	 * @throws DAOException
	 */
	public int modifyFFCmpnApInvHdr(String csr_no) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (csr_no != null) {
				param.put("csr_no", csr_no);
				velParam.put("csr_no", csr_no);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnApInvHdrUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
	/**
	 * modifyApprovalStep<br>
	 *
	 * @param boolean isSuccess
	 * @param String csr_no
	 * @return result
	 * @throws DAOException
	 */
	public int modifyFFInfo(boolean isSuccess, String csr_no) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (csr_no != null) {
				param.put("csr_no", csr_no);
				velParam.put("csr_no", csr_no);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			if (isSuccess){
				result = sqlExe.executeUpdate((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnInfoSuccessUSQL(), param,velParam);
			}else{
				result = sqlExe.executeUpdate((ISQLTemplate)new FFCmpnApprovalDBDAOModifyFFCmpnInfoFailUSQL(), param,velParam);
			}
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return result;
	}
}