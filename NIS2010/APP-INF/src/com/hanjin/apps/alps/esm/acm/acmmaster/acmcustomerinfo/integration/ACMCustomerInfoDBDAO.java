/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCustomerInfoDBDAO.java
*@FileTitle : ACMCustomerInfoDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.03 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.basic.ACMCustomerInfoBCImpl;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.CustVendorMatchForSCompVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FACExSettingVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FFCmpnExSettingVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FFVendorMatchVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ACMCustomerInfoDBDAO <br>
 * - ALPS-ACMMaster system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see ACMCustomerInfoBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ACMCustomerInfoDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0019]
	 * FF-Vendor Match for FF Compensation 목록을 조회<br>
	 *
	 * @param FFVendorMatchVO ffVendorMatchVO
	 * @return List<FFVendorMatchVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFVendorMatchVO> searchFFVendorMatch(FFVendorMatchVO ffVendorMatchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFVendorMatchVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffVendorMatchVO != null) {
				Map<String, String> mapVO = ffVendorMatchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCustomerInfoDBDAOSearchFFVendorMatchListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFVendorMatchVO.class);
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
	 * [ESM_ACM_0019]
	 * ACM_FF_VNDR_MTCH 테이블에서 FF_CNT_CD와 FF_SEQ의 중복 체크<br>
	 *
	 * @param FFVendorMatchVO ffVendorMatchVO
	 * @return List<FFVendorMatchVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFVendorMatchVO> getCustomerFromFFVenderMatch(FFVendorMatchVO ffVendorMatchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFVendorMatchVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffVendorMatchVO != null) {
				Map<String, String> mapVO = ffVendorMatchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCustomerInfoDBDAOGetCustomerFromFFVendorMatchInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFVendorMatchVO.class);
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
	 * [ESM_ACM_0019]
	 * FF vs Shipper Interest Info for Brokerage 목록을 일괄적으로 생성<br>
	 *
	 * @param List<FFVendorMatchVO> ffVendorMatchVOList
	 * @throws DAOException
	 */
	public void addFFVendorMatch(List<FFVendorMatchVO> ffVendorMatchVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (ffVendorMatchVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAOAddFFVendorMatchListCSQL(), ffVendorMatchVOList, null);
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
	 * [ESM_ACM_0019]
	 * FF vs Shipper Interest Info for Brokerage 목록을 일괄적으로 수정<br>
	 *
	 * @param List<FFVendorMatchVO> ffVendorMatchVOList
	 * @throws DAOException
	 */
	public void modifyFFVendorMatch(List<FFVendorMatchVO> ffVendorMatchVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (ffVendorMatchVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAOModifyFFVendorMatchListUSQL(), ffVendorMatchVOList, null);
				for (int i=0; i<updCnt.length; i++) {
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
	 * [ESM_ACM_0019]
	 * FF vs Shipper Interest Info for Brokerage 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<FFVendorMatchVO> ffVendorMatchVOList
	 * @throws DAOException
	 */
	public void removeFFVendorMatch(List<FFVendorMatchVO> ffVendorMatchVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (ffVendorMatchVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAORemoveFFVendorMatchListDSQL(), ffVendorMatchVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
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
	 * [ESM_ACM_0020]
	 * FF Compensation Exclusion Setting 목록을 조회<br>
	 *
	 * @param FFCmpnExSettingVO ffCmpnExSettingVO
	 * @return List<FFCmpnExSettingVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnExSettingVO> searchFFCmpnExSetting(FFCmpnExSettingVO ffCmpnExSettingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnExSettingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnExSettingVO != null) {
				Map<String, String> mapVO = ffCmpnExSettingVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCustomerInfoDBDAOSearchFFCmpnExSettingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnExSettingVO.class);
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
	 * [ESM_ACM_0020]
	 * ACM_FF_EXCLU_SET 테이블에서 FF_CNT_CD와 FF_SEQ의 중복 체크<br>
	 *
	 * @param FFCmpnExSettingVO ffCmpnExSettingVO
	 * @return List<FFCmpnExSettingVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnExSettingVO> getCustomerFromFFExclusion(FFCmpnExSettingVO ffCmpnExSettingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnExSettingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnExSettingVO != null) {
				Map<String, String> mapVO = ffCmpnExSettingVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCustomerInfoDBDAOGetCustomerFromFFCmpnExSettingInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnExSettingVO.class);
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
	 * [ESM_ACM_0020]
	 * FF vs Shipper Interest Info for Brokerage 목록을 일괄적으로 생성<br>
	 *
	 * @param List<FFCmpnExSettingVO> ffCmpnExSettingVOList
	 * @throws DAOException
	 */
	public void addFFCmpnExSetting(List<FFCmpnExSettingVO> ffCmpnExSettingVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (ffCmpnExSettingVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAOAddFFCmpnExSettingListCSQL(), ffCmpnExSettingVOList, null);
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
	 * [ESM_ACM_0020]
	 * FF vs Shipper Interest Info for Brokerage 목록을 일괄적으로 수정<br>
	 *
	 * @param List<FFCmpnExSettingVO> ffCmpnExSettingVOList
	 * @throws DAOException
	 */
	public void modifyFFCmpnExSetting(List<FFCmpnExSettingVO> ffCmpnExSettingVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (ffCmpnExSettingVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAOModifyFFCmpnExSettingListUSQL(), ffCmpnExSettingVOList, null);
				for (int i=0; i<updCnt.length; i++) {
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
	 * [ESM_ACM_0020]
	 * FF vs Shipper Interest Info for Brokerage 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<FFCmpnExSettingVO> ffCmpnExSettingVOList
	 * @throws DAOException
	 */
	public void removeFFCmpnExSetting(List<FFCmpnExSettingVO> ffCmpnExSettingVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (ffCmpnExSettingVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAORemoveFFCmpnExSettingListDSQL(), ffCmpnExSettingVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
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
	 * [ESM_ACM_0021]
	 * FAC Exclusion Setting 목록을 조회<br>
	 *
	 * @param FACExSettingVO facExSettingVO
	 * @return List<FACExSettingVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FACExSettingVO> searchFACExSetting(FACExSettingVO facExSettingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FACExSettingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (facExSettingVO != null) {
				Map<String, String> mapVO = facExSettingVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCustomerInfoDBDAOSearchFACExSettingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FACExSettingVO.class);
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
	 * [ESM_ACM_0021]
	 * ACM_FAC_EXCLU_SET 테이블에서 FF_CNT_CD와 FF_SEQ의 중복 체크<br>
	 *
	 * @param FACExSettingVO facExSettingVO
	 * @return List<FACExSettingVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FACExSettingVO> getCustomerFromFACExSetting(FACExSettingVO facExSettingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FACExSettingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (facExSettingVO != null) {
				Map<String, String> mapVO = facExSettingVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCustomerInfoDBDAOGetCustomerFromFACExSettingInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FACExSettingVO.class);
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
	 * [ESM_ACM_0021]
	 * FAC Exclusion Setting 목록을 일괄적으로 생성<br>
	 *
	 * @param List<FACExSettingVO> facExSettingVOList
	 * @throws DAOException
	 */
	public void addFACExSetting(List<FACExSettingVO> facExSettingVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (facExSettingVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAOAddFACExSettingListCSQL(), facExSettingVOList, null);
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
	 * [ESM_ACM_0021]
	 * FAC Exclusion Setting 목록을 일괄적으로 수정<br>
	 *
	 * @param List<FACExSettingVO> facExSettingVOList
	 * @throws DAOException
	 */
	public void modifyFACExSetting(List<FACExSettingVO> facExSettingVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (facExSettingVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAOModifyFACExSettingListUSQL(), facExSettingVOList, null);
				for (int i=0; i<updCnt.length; i++) {
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
	 * [ESM_ACM_0021]
	 * FAC Exclusion Setting 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<FACExSettingVO> facExSettingVOList
	 * @throws DAOException
	 */
	public void removeFACExSetting(List<FACExSettingVO> facExSettingVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (facExSettingVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAORemoveFACExSettingListDSQL(), facExSettingVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
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
	 * [ESM_ACM_0022]
	 * Customer-Vendor Match for Special Compensation 목록을 조회<br>
	 *
	 * @param CustVendorMatchForSCompVO custVendorMatchForSCompVO
	 * @return List<CustVendorMatchForSCompVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustVendorMatchForSCompVO> searchCustVendorMatchForSComp(CustVendorMatchForSCompVO custVendorMatchForSCompVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustVendorMatchForSCompVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (custVendorMatchForSCompVO != null) {
				Map<String, String> mapVO = custVendorMatchForSCompVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCustomerInfoDBDAOSearchCustVendorMatchForSCompListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustVendorMatchForSCompVO.class);
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
	 * [ESM_ACM_0022]
	 * ACM_SPCL_CUST_VNDR_MTCH 테이블에서 CUST_CNT_CD와 CUST_SEQ의 중복 체크<br>
	 *
	 * @param CustVendorMatchForSCompVO custVendorMatchForSCompVO
	 * @return List<CustVendorMatchForSCompVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustVendorMatchForSCompVO> getCustomerFromCustVendorMatchForSComp(CustVendorMatchForSCompVO custVendorMatchForSCompVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustVendorMatchForSCompVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (custVendorMatchForSCompVO != null) {
				Map<String, String> mapVO = custVendorMatchForSCompVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCustomerInfoDBDAOGetCustomerFromCustVendorMatchForSCompInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustVendorMatchForSCompVO.class);
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
	 * [ESM_ACM_0022]
	 * FF vs Shipper Interest Info for Brokerage 목록을 일괄적으로 생성<br>
	 *
	 * @param List<CustVendorMatchForSCompVO> custVendorMatchForSCompVOList
	 * @throws DAOException
	 */
	public void addCustVendorMatchForSComp(List<CustVendorMatchForSCompVO> custVendorMatchForSCompVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (custVendorMatchForSCompVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAOAddCustVendorMatchForSCompListCSQL(), custVendorMatchForSCompVOList, null);
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
	 * [ESM_ACM_0022]
	 * FF vs Shipper Interest Info for Brokerage 목록을 일괄적으로 수정<br>
	 *
	 * @param List<CustVendorMatchForSCompVO> custVendorMatchForSCompVOList
	 * @throws DAOException
	 */
	public void modifyCustVendorMatchForSComp(List<CustVendorMatchForSCompVO> custVendorMatchForSCompVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (custVendorMatchForSCompVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAOModifyCustVendorMatchForSCompListUSQL(), custVendorMatchForSCompVOList, null);
				for (int i=0; i<updCnt.length; i++) {
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
	 * [ESM_ACM_0022]
	 * FF vs Shipper Interest Info for Brokerage 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<CustVendorMatchForSCompVO> custVendorMatchForSCompVOList
	 * @throws DAOException
	 */
	public void removeCustVendorMatchForSComp(List<CustVendorMatchForSCompVO> custVendorMatchForSCompVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (custVendorMatchForSCompVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMCustomerInfoDBDAORemoveCustVendorMatchForSCompListDSQL(), custVendorMatchForSCompVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
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

}