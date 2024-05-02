/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAO.java
*@FileTitle : FACCommCalculationDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2012.05.16 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.basic.FACCommCalculationBCImpl;
import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo.SearchACMContractInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo.SearchAgnBookingInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo.SearchBKGQTYInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo.SearchFACAGMTRateInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo.SearchRevLanebndInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo.SearchSADateVO;
import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo.SearchZeroSumVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS FACCommCalculationDBDAO <br>
 * - OPUS-ACMCalculation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Park, Sung-Jin
 * @see FACCommCalculationBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class FACCommCalculationDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate Booking 정보를 가져온다.<br>
	 *
	 * @param String bkg_no
	 * @return SearchAgnBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO searchBookingInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAgnBookingInfoVO> list = null;
		SearchAgnBookingInfoVO bkgInfo = new SearchAgnBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchBookingInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				bkgInfo = list.get(0);
            }

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgInfo;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String comm_proc_rslt_rsn
	 * @exception DAOException
	 */
	public void modifyFACMasterErrorMSG(String bkg_no, String comm_proc_rslt_rsn) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("comm_proc_rslt_rsn", comm_proc_rslt_rsn);
				velParam.put("comm_proc_rslt_rsn", comm_proc_rslt_rsn);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOModifyFACMasterErrorMSGUSQL(), param, velParam);
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @exception DAOException
	 */
	public void modifyFACMasterEMSG(SearchAgnBookingInfoVO searchAgnBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOModifyFFMasterEMSGUSQL(), param, velParam);
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @exception DAOException
	 */
	public void modifyFACMasterEMSGU(SearchAgnBookingInfoVO searchAgnBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOModifyFFMasterEMSGUUSQL(), param, velParam);
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @exception DAOException
	 */
	public void modifyFACDetailEMSG(SearchAgnBookingInfoVO searchAgnBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOModifyFFDetailEMSGUSQL(), param, velParam);
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String comm_proc_rslt_rsn
	 * @exception DAOException
	 */
	public void modifyFACAGNBKGInfo(String bkg_no, String comm_proc_rslt_rsn) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("comm_proc_rslt_rsn", comm_proc_rslt_rsn);
				velParam.put("comm_proc_rslt_rsn", comm_proc_rslt_rsn);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOModifyAGNBKGInfoUSQL(), param, velParam);
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return SearchZeroSumVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchZeroSumVO searchZeroSum(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		SearchZeroSumVO ZeroSum = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchZeroSumRSQL(), param, velParam);
			List<SearchZeroSumVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchZeroSumVO.class);
			if(list != null && list.size() > 0) {
				ZeroSum = list.get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ZeroSum;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @exception DAOException
	 */
	public void removeACMAgnCommChg(String bkg_no) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAORemoveACMAgnCommChgDSQL(), param, null);
				if (delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @exception DAOException
	 */
	public void removeACMAgnCommTrsp(String bkg_no) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAORemoveACMAgnCommTrspDSQL(), param, null);
				if (delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + " SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return List<SearchSADateVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSADateVO> searchSADate(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSADateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchSADateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSADateVO.class);
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
	 * [ESM_ACM_0028]
	 * * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchSADateVO searchSADateVO
	 * @return SearchSADateVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchSADateVO searchSADateOfSU(SearchSADateVO searchSADateVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchSADateVO != null) {
				Map<String, String> mapVO= searchSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchSADateOfSURSQL(), param, velParam);
				List<SearchSADateVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSADateVO.class);
				if(list != null && list.size() > 0) {
					searchSADateVO.setVpsEtaDt(list.get(0).getVpsEtaDt());
					searchSADateVO.setVpsEtdDt(list.get(0).getVpsEtdDt());
					searchSADateVO.setSinwaTsSaDt(list.get(0).getSinwaTsSaDt());
	            }
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchSADateVO;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchSADateVO searchSADateVO
	 * @return SearchSADateVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchSADateVO searchSADateOfTrunkDt(SearchSADateVO searchSADateVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchSADateVO != null) {
				Map<String, String> mapVO= searchSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchSADateOfTrunkDtRSQL(), param, velParam);
				List<SearchSADateVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSADateVO.class);
				if(list != null && list.size() > 0) {
					searchSADateVO.setVpsEtaDt(list.get(0).getVpsEtaDt());
					searchSADateVO.setVpsEtdDt(list.get(0).getVpsEtdDt());
	            }
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchSADateVO;
	}

	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return SearchACMContractInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchACMContractInfoVO searchACMContractInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		SearchACMContractInfoVO cntInfo = new SearchACMContractInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchACMContractInfoRSQL(), param, velParam);
			List<SearchACMContractInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchACMContractInfoVO.class);
			if(list != null && list.size() > 0) {
				cntInfo = list.get(0);
            }else{
            	cntInfo = null;
            }

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntInfo;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return SearchBKGQTYInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchBKGQTYInfoVO searchBKGQTYInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		SearchBKGQTYInfoVO bkgQtyInfo = new SearchBKGQTYInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchBKGQTYInfoRSQL(), param, velParam);
			List<SearchBKGQTYInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBKGQTYInfoVO.class);
			if(list != null && list.size() > 0) {
				bkgQtyInfo = list.get(0);
            }else{
            	bkgQtyInfo = null;
            }

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgQtyInfo;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return SearchRevLanebndInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchRevLanebndInfoVO searchRevLanebndInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		SearchRevLanebndInfoVO RevLanebndInfo = new SearchRevLanebndInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchRevLanebndInfoRSQL(), param, velParam);
			List<SearchRevLanebndInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRevLanebndInfoVO.class);
			if(list != null && list.size() > 0) {
				RevLanebndInfo = list.get(0);
            }

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return RevLanebndInfo;
	}

	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchRevLanebndInfoVO searchRevLanebndInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @exception DAOException
	 */
	public void modifyACMBKGInfo(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchRevLanebndInfoVO searchRevLanebndInfoVO, SearchSADateVO searchSADateVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchRevLanebndInfoVO.getColumnValues();
				Map<String, String> mapVO2= searchSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOModifyACMBKGInfoUSQL(), param, velParam);
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	 public String searchFACSeq(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String fac_seq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchFACSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				fac_seq = dbRowset.getString("FAC_SEQ");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fac_seq;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String fac_seq
	 * @return String
	 * @exception DAOException
	 */
	public String searchFACDataCheck(String bkg_no, String fac_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String fac = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("fac_seq", fac_seq);
				velParam.put("fac_seq", fac_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchFACDataChekRSQL(), param, velParam);
			if (dbRowset.next()) {
				fac = dbRowset.getString("FAC");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fac;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String fac_seq
	 * @return String
	 * @exception DAOException
	 */
	public String searchFACDtlDataCheck(String bkg_no, String fac_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String facDtl = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("fac_seq", fac_seq);
				velParam.put("fac_seq", fac_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchFACDtlDataChekRSQL(), param, velParam);
			if (dbRowset.next()) {
				facDtl = dbRowset.getString("FAC_DTL");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return facDtl;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String fac_seq
	 * @return String
	 * @exception DAOException
	 */
	public String searchFACCancelDataCheck(String bkg_no, String fac_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String fac = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("fac_seq", fac_seq);
				velParam.put("fac_seq", fac_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchFACCancelDataChekRSQL(), param, velParam);
			if (dbRowset.next()) {
				fac = dbRowset.getString("FAC");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fac;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @exception DAOException
	 */
	public void addFACMasterCancel(SearchAgnBookingInfoVO searchAgnBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOAddFACMasterCancelCSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return SearchAgnBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO searchFACCancelAmt(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		SearchAgnBookingInfoVO searchAgnBookingInfoVO = new SearchAgnBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchFACCancelAmtRSQL(), param, velParam);
			List<SearchAgnBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				searchAgnBookingInfoVO = list.get(0);
            }

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchAgnBookingInfoVO;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String fac_seq
	 * @exception DAOException
	 */
	public void removeFACChgDetail(String bkg_no, String fac_seq) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("fac_seq", fac_seq);
				velParam.put("fac_seq", fac_seq);
			}
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAORemoveFACChgDetailDSQL(), param, velParam);
				if (delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String fac_seq
	 * @exception DAOException
	 */
	public void removeFACDetail(String bkg_no, String fac_seq) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("fac_seq", fac_seq);
				velParam.put("fac_seq", fac_seq);
			}
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAORemoveFACDetailDSQL(), param, velParam);
				if (delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String fac_seq
	 * @exception DAOException
	 */
	public void removeFACCancelDetail(String bkg_no, String fac_seq) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("fac_seq", fac_seq);
				velParam.put("fac_seq", fac_seq);
			}
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAORemoveFACCancelDetailDSQL(), param, velParam);
				if (delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String fac_seq
	 * @exception DAOException
	 */
	public void removeFACMaster(String bkg_no, String fac_seq) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("fac_seq", fac_seq);
				velParam.put("fac_seq", fac_seq);
			}
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAORemoveFACMasterDSQL(), param, velParam);
				if (delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String fac_seq
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO searchFacDivCd(String bkg_no, String fac_seq) throws DAOException {
		DBRowSet dbRowset = null;
		SearchAgnBookingInfoVO searchAgnBookingInfoVO = new SearchAgnBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("fac_seq", fac_seq);
				velParam.put("fac_seq", fac_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchFacDivCdRSQL(), param, velParam);
			List<SearchAgnBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				searchAgnBookingInfoVO = list.get(0);
            }

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchAgnBookingInfoVO;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ppd_ofc_cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchPpdOfcCdCheck(String bkg_no, String ppd_ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ppd_ofc_cd", ppd_ofc_cd);
				velParam.put("ppd_ofc_cd", ppd_ofc_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchPpdOfcCdCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getString("CNT");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchN3pdBfrOfcCd(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String n3pdBfrOfcCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchN3pdBfrOfcCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				n3pdBfrOfcCd = dbRowset.getString("N3RD_BFR_OFC_CD");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return n3pdBfrOfcCd;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String chg_ppd_ofc_cd
	 * @return SearchAgnBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO searchChgARAPOfcCd(String chg_ppd_ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		SearchAgnBookingInfoVO searchAgnBookingInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chg_ppd_ofc_cd != null) {
				param.put("chg_ppd_ofc_cd", chg_ppd_ofc_cd);
				velParam.put("chg_ppd_ofc_cd", chg_ppd_ofc_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchChgARAPOfcCdRSQL(), param, velParam);
			List<SearchAgnBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				searchAgnBookingInfoVO = list.get(0);
            }

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchAgnBookingInfoVO;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ppd_ofc_cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAROfcIsCheck(String bkg_no, String ppd_ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ppd_ofc_cd", ppd_ofc_cd);
				velParam.put("ppd_ofc_cd", ppd_ofc_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchAROfcIsCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getString("CNT");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchACMContractInfoVO searchACMContractInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchFACCustShprInterestInfo(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchACMContractInfoVO searchACMContractInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String fac = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchACMContractInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchFACCustShprInterestInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				fac = dbRowset.getString("FAC");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fac;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchMemoCheck(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String memoChk = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchMemoCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				memoChk = dbRowset.getString("MEMO_CHECK");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return memoChk;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String ppd_ofc_cd
	 * @return SearchAgnBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO searchARAPOfcCd(String ppd_ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		SearchAgnBookingInfoVO searchAgnBookingInfoVO = new SearchAgnBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ppd_ofc_cd != null) {
				param.put("ppd_ofc_cd", ppd_ofc_cd);
				velParam.put("ppd_ofc_cd", ppd_ofc_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchARAPOfcCdRSQL(), param, velParam);
			List<SearchAgnBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				searchAgnBookingInfoVO = list.get(0);
            }

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchAgnBookingInfoVO;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String ar_ofc_cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAgnDivFlg(String ar_ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String agnDivFlg = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ar_ofc_cd != null) {
				param.put("ar_ofc_cd", ar_ofc_cd);
				velParam.put("ar_ofc_cd", ar_ofc_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchAgnDivFlgRSQL(), param, velParam);
			if (dbRowset.next()) {
				agnDivFlg = dbRowset.getString("AGN_DIV_FLG");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return agnDivFlg;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgChgCdRtCnt(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchBkgChgCdRtCntRSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getString("CNT");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgChgRtCnt(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchBkgChgRtCntRSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getString("CNT");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}

	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchACMContractInfoVO searchACMContractInfoVO
	 * @param String ofcCd
	 * @return List<SearchFACAGMTRateInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchFACAGMTRateInfoVO> searchFACAGMTRateInfo(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchACMContractInfoVO searchACMContractInfoVO, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFACAGMTRateInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchACMContractInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.put("ofc_cd", ofcCd);
				velParam.put("ofc_cd", ofcCd);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchFACAGMTRateInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFACAGMTRateInfoVO.class);
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
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @param SearchFACAGMTRateInfoVO facAGMTRateInfo
	 * @return SearchAgnBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO searchCalcFACCommBAInfo(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchSADateVO searchSADateVO, SearchFACAGMTRateInfoVO facAGMTRateInfo) throws DAOException {
		DBRowSet dbRowset = null;

		SearchAgnBookingInfoVO searchAgnBookingInfoInVO = new SearchAgnBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchSADateVO.getColumnValues();
				Map<String, String> mapVO2= facAGMTRateInfo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchCalcFACCommBAInfoRSQL(), param, velParam);
			List<SearchAgnBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				searchAgnBookingInfoInVO = list.get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchAgnBookingInfoInVO;
	}

	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @param SearchFACAGMTRateInfoVO facAGMTRateInfo
	 * @return SearchAgnBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO searchCalcFACCommBFInfo(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchSADateVO searchSADateVO, SearchFACAGMTRateInfoVO facAGMTRateInfo) throws DAOException {
		DBRowSet dbRowset = null;

		SearchAgnBookingInfoVO searchAgnBookingInfoInVO = new SearchAgnBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchSADateVO.getColumnValues();
				Map<String, String> mapVO2= facAGMTRateInfo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchCalcFACCommBFInfoRSQL(), param, velParam);
			List<SearchAgnBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				searchAgnBookingInfoInVO = list.get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchAgnBookingInfoInVO;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @param SearchFACAGMTRateInfoVO facAGMTRateInfo
	 * @param String facChgCtntDiv
	 * @return SearchAgnBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO searchCalcFACCommBSInfo(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchSADateVO searchSADateVO, SearchFACAGMTRateInfoVO facAGMTRateInfo, String facChgCtntDiv) throws DAOException {
		DBRowSet dbRowset = null;

		SearchAgnBookingInfoVO searchAgnBookingInfoInVO = new SearchAgnBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchSADateVO.getColumnValues();
				Map<String, String> mapVO2= facAGMTRateInfo.getColumnValues();


				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
				param.put("fac_chg_ctnt_div", facChgCtntDiv);
				velParam.put("fac_chg_ctnt_div", facChgCtntDiv);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchCalcFACCommBSInfoRSQL(), param, velParam);
			List<SearchAgnBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				searchAgnBookingInfoInVO = list.get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchAgnBookingInfoInVO;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @param SearchFACAGMTRateInfoVO facAGMTRateInfo
	 * @param String facChgCtntDiv
	 * @return SearchAgnBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO searchCalcFACCommDRInfo(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchSADateVO searchSADateVO, SearchFACAGMTRateInfoVO facAGMTRateInfo, String facChgCtntDiv) throws DAOException {
		DBRowSet dbRowset = null;

		SearchAgnBookingInfoVO searchAgnBookingInfoInVO = new SearchAgnBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchSADateVO.getColumnValues();
				Map<String, String> mapVO2= facAGMTRateInfo.getColumnValues();


				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
				param.put("fac_chg_ctnt_div", facChgCtntDiv);
				velParam.put("fac_chg_ctnt_div", facChgCtntDiv);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchCalcFACCommDRInfoRSQL(), param, velParam);
			List<SearchAgnBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				searchAgnBookingInfoInVO = list.get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchAgnBookingInfoInVO;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchRevLanebndInfoVO searchRevLanebndInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @return SearchSADateVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchSADateVO searchACMBKGInfo(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchRevLanebndInfoVO searchRevLanebndInfoVO, SearchSADateVO searchSADateVO) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSADateVO saDate = new SearchSADateVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchRevLanebndInfoVO.getColumnValues();
				Map<String, String> mapVO2= searchSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOModifyACMBKGInfoUSQL(), param, velParam);
			List<SearchSADateVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSADateVO.class);
			if(list != null && list.size() > 0) {
				saDate = list.get(0);
            }

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return saDate;
	}

		/**
		 * [ESM_ACM_0028]
		 * FAC Audit Re-Calculate <br>
		 *
		 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
		 * @param SearchRevLanebndInfoVO searchRevLanebndInfoVO
		 * @param SearchSADateVO searchSADateVO
		 * @param SearchACMContractInfoVO searchACMContractInfoVO
		 * @param SearchFACAGMTRateInfoVO searchFACAGMTRateInfoVO
		 * @param SearchBKGQTYInfoVO searchBKGQTYInfoVO
		 * @exception DAOException
		 */
	public void addFACMaster(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchRevLanebndInfoVO searchRevLanebndInfoVO, SearchSADateVO searchSADateVO, SearchACMContractInfoVO searchACMContractInfoVO, SearchFACAGMTRateInfoVO searchFACAGMTRateInfoVO, SearchBKGQTYInfoVO searchBKGQTYInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchRevLanebndInfoVO.getColumnValues();
				Map<String, String> mapVO2= searchSADateVO.getColumnValues();
				Map<String, String> mapVO3= searchACMContractInfoVO.getColumnValues();
				Map<String, String> mapVO4= searchFACAGMTRateInfoVO.getColumnValues();
				Map<String, String> mapVO5= searchBKGQTYInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
				param.putAll(mapVO3);
				velParam.putAll(mapVO3);
				param.putAll(mapVO4);
				velParam.putAll(mapVO4);
				param.putAll(mapVO5);
				velParam.putAll(mapVO5);

			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOAddFACMasterCSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchRevLanebndInfoVO searchRevLanebndInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @return int
	 * @exception DAOException
	 */
	public int addFACDetailB(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchRevLanebndInfoVO searchRevLanebndInfoVO, SearchSADateVO searchSADateVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchRevLanebndInfoVO.getColumnValues();
				Map<String, String> mapVO2= searchSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
			}
			 insCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOAddFACDetailBCSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchRevLanebndInfoVO searchRevLanebndInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @return int
	 * @exception DAOException
	 */
	public int addFACDetailC(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchRevLanebndInfoVO searchRevLanebndInfoVO, SearchSADateVO searchSADateVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchRevLanebndInfoVO.getColumnValues();
				Map<String, String> mapVO2= searchSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
			}
			 insCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOAddFACDetailCCSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchRevLanebndInfoVO searchRevLanebndInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @param String facChgCtntDiv
	 * @exception DAOException
	 */
	public void addFACChgDetailBA(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchRevLanebndInfoVO searchRevLanebndInfoVO, SearchSADateVO searchSADateVO, String facChgCtntDiv) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchRevLanebndInfoVO.getColumnValues();
				Map<String, String> mapVO2= searchSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
				param.put("fac_chg_ctnt_div", facChgCtntDiv);
				velParam.put("fac_chg_ctnt_div", facChgCtntDiv);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOAddFACChgDetailBACSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchRevLanebndInfoVO searchRevLanebndInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @param String facChgCtntDiv
	 * @exception DAOException
	 */
	public void addFACChgDetailBF(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchRevLanebndInfoVO searchRevLanebndInfoVO, SearchSADateVO searchSADateVO, String facChgCtntDiv) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchRevLanebndInfoVO.getColumnValues();
				Map<String, String> mapVO2= searchSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
				param.put("fac_chg_ctnt_div", facChgCtntDiv);
				velParam.put("fac_chg_ctnt_div", facChgCtntDiv);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOAddFACChgDetailBFCSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param SearchAgnBookingInfoVO searchAgnBookingInfoVO
	 * @param SearchRevLanebndInfoVO searchRevLanebndInfoVO
	 * @param SearchSADateVO searchSADateVO
	 * @param String facChgCtntDiv
	 * @exception DAOException
	 */
	public void addFACChgDetailBS(SearchAgnBookingInfoVO searchAgnBookingInfoVO, SearchRevLanebndInfoVO searchRevLanebndInfoVO, SearchSADateVO searchSADateVO, String facChgCtntDiv) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchAgnBookingInfoVO != null) {
				Map<String, String> mapVO= searchAgnBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchRevLanebndInfoVO.getColumnValues();
				Map<String, String> mapVO2= searchSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
				param.put("fac_chg_ctnt_div", facChgCtntDiv);
				velParam.put("fac_chg_ctnt_div", facChgCtntDiv);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOAddFACChgDetailBSCSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @exception DAOException
	 */
	public void modifyFACDetailComp(String bkg_no) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOModifyFACDetailCompUSQL(), param, velParam);
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 해당 데이타가 null인 경우 공백을 리턴한다.<br>
	 *
	 * @param String str
	 * @return String 결과값
	 * @throws SQLException, Exception
	 */
	public String checkNull( String str ) {

		if(str == null) {
			str = "";
		}

		return str.trim();
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param double round_val
	 * @return double
	 * @exception DAOException
	 */
	public double searchRoundValue(double round_val) throws DAOException {
		DBRowSet dbRowset = null;
		double result_val = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("round_val", round_val);
			velParam.put("round_val", round_val);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchRoundValueRSQL(), param, velParam);
			if (dbRowset.next()) {
				result_val = dbRowset.getDouble("ROUND_VAL");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result_val;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO searchFACMaster(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		SearchAgnBookingInfoVO searchAgnBookingInfoVO = new SearchAgnBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACCommCalculationDBDAOSearchFACMasterRSQL(), param, velParam);
			List<SearchAgnBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				searchAgnBookingInfoVO = list.get(0);
            }

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchAgnBookingInfoVO;
	}
	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @exception DAOException
	 */
	public void addFACMasterHistory(String bkg_no) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FACCommCalculationDBDAOAddFACMasterHistoryCSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

}