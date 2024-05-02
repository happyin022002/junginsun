/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationDBDAO.java
*@FileTitle : FFCommCalculationDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2012.05.16 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.basic.FFCommCalculationBCImpl;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchACMFFContractInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchFFAGMTRateInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchFFBKGQTYInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchFFBookingInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchFFRevLanebndInfoVO;
import com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo.SearchFFSADateVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS FFCommCalculationDBDAO <br>
 * - OPUS-FFCalculation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Park, Sung-Jin
 * @see FFCommCalculationBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class FFCommCalculationDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate Booking 정보를 가져온다.<br>
	 *
	 * @param String bkg_no
	 * @return SearchFFBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchFFBookingInfoVO searchBookingInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFFBookingInfoVO> list = null;
		SearchFFBookingInfoVO bkgInfo = new SearchFFBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchBookingInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFBookingInfoVO.class);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String comm_proc_rslt_rsn
	 * @exception DAOException
	 */
	public void modifyFFMasterErrorMSG(String bkg_no, String comm_proc_rslt_rsn) throws DAOException {
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
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOModifyFFMasterErrorMSGUSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String comm_proc_rslt_rsn
	 * @exception DAOException
	 */
	public void modifyFFAGNBKGInfo(String bkg_no, String comm_proc_rslt_rsn) throws DAOException {
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
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOModifyAGNBKGInfoUSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return List<SearchFFSADateVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchFFSADateVO> searchSADate(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFFSADateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchSADateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFSADateVO.class);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFSADateVO searchFFSADateVO
	 * @return SearchFFSADateVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchFFSADateVO searchSADateOfSU(SearchFFSADateVO searchFFSADateVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchFFSADateVO != null) {
				Map<String, String> mapVO= searchFFSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchSADateOfSURSQL(), param, velParam);
				List<SearchFFSADateVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFSADateVO.class);
				if(list != null && list.size() > 0) {
					searchFFSADateVO.setVpsEtaDt(list.get(0).getVpsEtaDt());
					searchFFSADateVO.setVpsEtdDt(list.get(0).getVpsEtdDt());
					searchFFSADateVO.setSinwaTsSaDt(list.get(0).getSinwaTsSaDt());
	            }
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchFFSADateVO;
	}

	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFSADateVO searchFFSADateVO
	 * @return SearchFFSADateVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchFFSADateVO searchSADateOfTrunkDt(SearchFFSADateVO searchFFSADateVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchFFSADateVO != null) {
				Map<String, String> mapVO= searchFFSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchSADateOfTrunkDtRSQL(), param, velParam);
				List<SearchFFSADateVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFSADateVO.class);
				if(list != null && list.size() > 0) {
					searchFFSADateVO.setVpsEtaDt(list.get(0).getVpsEtaDt());
					searchFFSADateVO.setVpsEtdDt(list.get(0).getVpsEtdDt());
	            }
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchFFSADateVO;
	}

	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return SearchACMFFContractInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchACMFFContractInfoVO searchACMContractInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		SearchACMFFContractInfoVO cntInfo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchACMFFContractInfoRSQL(), param, velParam);
			List<SearchACMFFContractInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchACMFFContractInfoVO.class);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return SearchFFBKGQTYInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchFFBKGQTYInfoVO searchBKGQTYInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		SearchFFBKGQTYInfoVO bkgQtyInfo = new SearchFFBKGQTYInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchFFBKGQTYInfoRSQL(), param, velParam);
			List<SearchFFBKGQTYInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFBKGQTYInfoVO.class);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return SearchFFRevLanebndInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchFFRevLanebndInfoVO searchRevLanebndInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		SearchFFRevLanebndInfoVO RevLanebndInfo = new SearchFFRevLanebndInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchFFRevLanebndInfoRSQL(), param, velParam);
			List<SearchFFRevLanebndInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFRevLanebndInfoVO.class);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @param SearchFFRevLanebndInfoVO searchFFRevLanebndInfoVO
	 * @param SearchFFSADateVO searchFFSADateVO
	 * @exception DAOException
	 */
	public void modifyACMBKGInfo(SearchFFBookingInfoVO searchFFBookingInfoVO, SearchFFRevLanebndInfoVO searchFFRevLanebndInfoVO, SearchFFSADateVO searchFFSADateVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchFFRevLanebndInfoVO.getColumnValues();
				Map<String, String> mapVO2= searchFFSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOModifyACMBKGInfoUSQL(), param, velParam);
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
	 * Brokerage Calculation<br>
	 * bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 *
	 * @param SearchFFBookingInfoVO BkgInfolist
	 * @return boolean Brokerage 여부
	 * @throws DAOException
	 */
	public boolean createActualFFCommCheck(SearchFFBookingInfoVO BkgInfolist) throws DAOException {

		String por_cnt_cd		= BkgInfolist.getPorCntCd();
		String pol_cnt_cd		= BkgInfolist.getPolCntCd();
		String bkg_ofc_loc_cd	= BkgInfolist.getBkgOfcLocCd();
		String bkg_ofc_cnt_cd	= "";
		try {

			if(bkg_ofc_loc_cd.length() > 4){
				bkg_ofc_cnt_cd = bkg_ofc_loc_cd.substring(0, 2);
			}
			// FF가 아니면 Return 한다.
			
			if(!( "US".equals(por_cnt_cd) || "CA".equals(por_cnt_cd) ) && !( "US".equals(pol_cnt_cd) || "CA".equals(pol_cnt_cd) )) {
				if( !("MX".equals(pol_cnt_cd) && "US".equals(bkg_ofc_cnt_cd)) ){
					return false;
				}
			}

		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return true;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	 public String searchFFSeq(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String ff_cmpn_seq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchFFSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				ff_cmpn_seq = dbRowset.getString("FF_CMPN_SEQ");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ff_cmpn_seq;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ff_cmpn_seq
	 * @return String
	 * @exception DAOException
	 */
	public String searchFFDataCheck(String bkg_no, String ff_cmpn_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String ff = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ff_cmpn_seq", ff_cmpn_seq);
				velParam.put("ff_cmpn_seq", ff_cmpn_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchFFDataChekRSQL(), param, velParam);
			if (dbRowset.next()) {
				ff = dbRowset.getString("FF");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ff;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ff_cmpn_seq
	 * @exception DAOException
	 */
	public void removeFFChgDetail(String bkg_no, String ff_cmpn_seq) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ff_cmpn_seq", ff_cmpn_seq);
				velParam.put("ff_cmpn_seq", ff_cmpn_seq);
			}
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAORemoveFFChgDetailDSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @exception DAOException
	 */
	public void removeFFChgDetailNotIF(String bkg_no) throws DAOException {
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
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAORemoveFFChgDetailNotIFDSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ff_cmpn_seq
	 * @exception DAOException
	 */
	public void removeFFDetail(String bkg_no, String ff_cmpn_seq) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ff_cmpn_seq", ff_cmpn_seq);
				velParam.put("ff_cmpn_seq", ff_cmpn_seq);
			}
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAORemoveFFDetailDSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @exception DAOException
	 */
	public void removeFFDetailNotIF(String bkg_no) throws DAOException {
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
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAORemoveFFDetailNotIFDSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ff_cmpn_seq
	 * @exception DAOException
	 */
	public void removeFFMaster(String bkg_no, String ff_cmpn_seq) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ff_cmpn_seq", ff_cmpn_seq);
				velParam.put("ff_cmpn_seq", ff_cmpn_seq);
			}
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAORemoveFFMasterDSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @exception DAOException
	 */
	public void removeFFMasterNotIF(String bkg_no) throws DAOException {
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
			 int delCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAORemoveFFMasterNotIFDSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCanadaCheck(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String canadaChk = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchCanadaCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				canadaChk = dbRowset.getString("CANADA_CHK");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return canadaChk;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchCustomerCheck(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String customerChk = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchCustomerCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				customerChk = dbRowset.getString("CUSTOMER_CHK");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return customerChk;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchFFCode(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String vndrCntSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchFFCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				vndrCntSeq = dbRowset.getString("VNDR_CNT_SEQ");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vndrCntSeq;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchVndrSeqCheck(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String vendor = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchVndrSeqCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				vendor = dbRowset.getString("VENDOR");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vendor;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchFFCustShprInterestInfo(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String ff = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchFFCustShprInterestInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				ff = dbRowset.getString("FF");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ff;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchMemoCheckRSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @param SearchFFSADateVO searchFFSADateVO
	 * @return List<SearchFFAGMTRateInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchFFAGMTRateInfoVO> searchFFAGMTRateInfo(SearchFFBookingInfoVO searchFFBookingInfoVO, SearchFFSADateVO searchFFSADateVO) throws DAOException {
		DBRowSet dbRowset = null;
//		SearchFFAGMTRateInfoVO searchFFAGMTRateInfoVO = new SearchFFAGMTRateInfoVO();
		List<SearchFFAGMTRateInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchFFSADateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(mapVO1);
				velParam.putAll(mapVO1);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchFFAGMTRateInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFAGMTRateInfoVO.class);
//			if(list != null && list.size() > 0) {
//				searchFFAGMTRateInfoVO = list.get(0);
//            }

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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ff_bkg_rt
	 * @return SearchFFBookingInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchFFBookingInfoVO searchCalcFFCommBAInfo(String bkg_no, String ff_bkg_rt) throws DAOException {
		DBRowSet dbRowset = null;
		SearchFFBookingInfoVO BkgInfo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ff_bkg_rt", ff_bkg_rt);
				velParam.put("ff_bkg_rt", ff_bkg_rt);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchCalcFFCommBAInfoRSQL(), param, velParam);
			List<SearchFFBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				BkgInfo = list.get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return BkgInfo;
	}

	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ff_bkg_rt
	 * @return SearchFFBookingInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchFFBookingInfoVO searchCalcFFCommBFInfo(String bkg_no, String ff_bkg_rt) throws DAOException {
		DBRowSet dbRowset = null;
		SearchFFBookingInfoVO BkgInfo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ff_bkg_rt", ff_bkg_rt);
				velParam.put("ff_bkg_rt", ff_bkg_rt);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchCalcFFCommBFInfoRSQL(), param, velParam);
			List<SearchFFBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				BkgInfo = list.get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return BkgInfo;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ff_bkg_rt
	 * @param SearchFFAGMTRateInfoVO searchFFAGMTRateInfoVO
	 * @return SearchFFBookingInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchFFBookingInfoVO searchCalcFFCommBSInfo(String bkg_no, String ff_bkg_rt, SearchFFAGMTRateInfoVO searchFFAGMTRateInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		SearchFFBookingInfoVO BkgInfo = null;
		List<String> arrLabelValueList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ff_bkg_rt", ff_bkg_rt);
				velParam.put("ff_bkg_rt", ff_bkg_rt);
				
				if (!JSPUtil.getNull(searchFFAGMTRateInfoVO.getFfChgCtnt()).equals("")) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchFFAGMTRateInfoVO.getFfChgCtnt(), ",", "|"));
					param.put("ff_chg_ctnt_div", arrLabelValueList);
					velParam.put("ff_chg_ctnt_div", arrLabelValueList);
				}
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchCalcFFCommBSInfoRSQL(), param, velParam);
			List<SearchFFBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				BkgInfo = list.get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return BkgInfo;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return SearchFFBookingInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchFFBookingInfoVO searchCalcFFCommCSInfo(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFFBookingInfoVO> list = null;
		SearchFFBookingInfoVO searchFFBookingInfoVO = new SearchFFBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchCalcFFCommCSInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				searchFFBookingInfoVO = list.get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchFFBookingInfoVO;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return SearchFFBookingInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchFFBookingInfoVO searchOldIfCommFFCode(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFFBookingInfoVO> list = null;
		SearchFFBookingInfoVO fFBookingInfoVO = new SearchFFBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchOldIfCommFFCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFFBookingInfoVO.class);
			if(list != null && list.size() > 0) {
				fFBookingInfoVO = list.get(0);
            }
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fFBookingInfoVO;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchNewFFSeq(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String newFFCmpnSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchNewFFSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				newFFCmpnSeq = dbRowset.getString("NEW_FF_CMPN_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return newFFCmpnSeq;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @exception DAOException
	 */
	public void addFFCommIF(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommIFCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return int
	 * @exception DAOException
	 */
	public int addFFCommDtailIFB(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommDetailIFBCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return int
	 * @exception DAOException
	 */
	public int addFFCommDtailIFC(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommDetailIFCCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @exception DAOException
	 */
	public void addFFCommChgDetailIFBA(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommChgDetailIFBACSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @exception DAOException
	 */
	public void addFFCommChgDetailIFBF(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommChgDetailIFBFCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @param SearchFFAGMTRateInfoVO searchFFAGMTRateInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addFFCommChgDetailIFBS(SearchFFBookingInfoVO searchFFBookingInfoVO, SearchFFAGMTRateInfoVO searchFFAGMTRateInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		List<String> arrLabelValueList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
//				param.put("ff_chg_ctnt_div", ff_chg_ctnt_div);
//				velParam.put("ff_chg_ctnt_div", ff_chg_ctnt_div);
				
				if (!JSPUtil.getNull(searchFFAGMTRateInfoVO.getFfChgCtnt()).equals("")) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchFFAGMTRateInfoVO.getFfChgCtnt(), ",", "|"));
					param.put("ff_chg_ctnt_div", arrLabelValueList);
					velParam.put("ff_chg_ctnt_div", arrLabelValueList);
				}
				
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommChgDetailIFBSCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchFFMasterPPDAmt(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String ppdAmt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchFFMasterPPDAmtRSQL(), param, velParam);
			if (dbRowset.next()) {
				ppdAmt = dbRowset.getString("PPD_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ppdAmt;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @param SearchFFRevLanebndInfoVO searchFFRevLanebndInfoVO
	 * @param SearchFFSADateVO searchFFSADateVO
	 * @param SearchACMFFContractInfoVO searchACMFFContractInfoVO
	 * @param SearchFFAGMTRateInfoVO searchFFAGMTRateInfoVO
	 * @param SearchFFBKGQTYInfoVO searchFFBKGQTYInfoVO
	 * @exception DAOException
	 */
	public void addFFCommMaster(SearchFFBookingInfoVO searchFFBookingInfoVO, SearchFFRevLanebndInfoVO searchFFRevLanebndInfoVO, SearchFFSADateVO searchFFSADateVO, SearchACMFFContractInfoVO searchACMFFContractInfoVO, SearchFFAGMTRateInfoVO searchFFAGMTRateInfoVO, SearchFFBKGQTYInfoVO searchFFBKGQTYInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();
				Map<String, String> mapVO1= searchFFRevLanebndInfoVO.getColumnValues();
				Map<String, String> mapVO2= searchFFSADateVO.getColumnValues();
				Map<String, String> mapVO3= searchACMFFContractInfoVO.getColumnValues();
				Map<String, String> mapVO4= searchFFAGMTRateInfoVO.getColumnValues();
				Map<String, String> mapVO5= searchFFBKGQTYInfoVO.getColumnValues();

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
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommMasterCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return int
	 * @exception DAOException
	 */
	public int addFFCommDtailB(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommDetailBCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return int
	 * @exception DAOException
	 */
	public int addFFCommDtailC(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommDetailCCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @exception DAOException
	 */
	public void addFFCommChgDetailBA(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommChgDetailBACSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @exception DAOException
	 */
	public void addFFCommChgDetailBF(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommChgDetailBFCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @param SearchFFAGMTRateInfoVO searchFFAGMTRateInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addFFCommChgDetailBS(SearchFFBookingInfoVO searchFFBookingInfoVO, SearchFFAGMTRateInfoVO searchFFAGMTRateInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		List<String> arrLabelValueList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
//				param.put("ff_chg_ctnt_div", ff_chg_ctnt_div);
//				velParam.put("ff_chg_ctnt_div", ff_chg_ctnt_div);
				
			}
			
			if (!JSPUtil.getNull(searchFFAGMTRateInfoVO.getFfChgCtnt()).equals("")) {
				arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchFFAGMTRateInfoVO.getFfChgCtnt(), ",", "|"));
				param.put("ff_chg_ctnt_div", arrLabelValueList);
				velParam.put("ff_chg_ctnt_div", arrLabelValueList);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommChgDetailBSCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchFFCustNameCheck(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String custNm = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchFFCustNameCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				custNm = dbRowset.getString("CUST_NM");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return custNm;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @exception DAOException
	 */
	public void modifyFFCommDetail(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int upsCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOModifyFFCommDetailUSQL(), param, velParam);
				if (upsCnt == Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ff_cmpn_seq
	 * @return String
	 * @exception DAOException
	 */
	public String searchFFCancelDataCheck(String bkg_no, String ff_cmpn_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String ff = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ff_cmpn_seq", ff_cmpn_seq);
				velParam.put("ff_cmpn_seq", ff_cmpn_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchFFCancelDataChekRSQL(), param, velParam);
			if (dbRowset.next()) {
				ff = dbRowset.getString("FF");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ff;
	}
	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param String bkg_no
	 * @param String ff_cmpn_seq
	 * @param String comm_proc_rslt_rsn
	 * @exception DAOException
	 */
	public void addFFCommMasterCancelIF(String bkg_no, String ff_cmpn_seq, String comm_proc_rslt_rsn) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkg_no != null) {
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
				param.put("ff_cmpn_seq", ff_cmpn_seq);
				velParam.put("ff_cmpn_seq", ff_cmpn_seq);
				param.put("comm_proc_rslt_rsn", comm_proc_rslt_rsn);
				velParam.put("comm_proc_rslt_rsn", comm_proc_rslt_rsn);
			}
			 int insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOAddFFCommMasterCancelIFCSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @exception DAOException
	 */
	public void modifyFFMasterEMSG(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOModifyFFMasterEMSGUSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @exception DAOException
	 */
	public void modifyFFMasterEMSGU(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOModifyFFMasterEMSGUUSQL(), param, velParam);
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
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
	 *
	 * @param SearchFFBookingInfoVO searchFFBookingInfoVO
	 * @exception DAOException
	 */
	public void modifyFFDetailEMSG(SearchFFBookingInfoVO searchFFBookingInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (searchFFBookingInfoVO != null) {
				Map<String, String> mapVO= searchFFBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 int updCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCommCalculationDBDAOModifyFFDetailEMSGUSQL(), param, velParam);
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
	 * @param str String
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
	 * 해당 데이터를 원하는 소수점 짜리로 반올림해서 리턴한다.<br>
	 *
	 * @param roundValue double
	 * @param c int 소수점 자리수
	 * @return String 결과값
	 * @throws Exception
	 */
	 public double roundValue(double roundValue, int c) {
		 double returnDouble = 0;

		 try{
			 BigDecimal bd = new BigDecimal(roundValue);
			 returnDouble = Double.parseDouble(bd.setScale(c, BigDecimal.ROUND_HALF_UP)+"");
		 }catch (Exception e) {
				log.error(e.getMessage(), e);
		 }
         return returnDouble;
	 }
	/**
	 * 해당 데이터를 원하는 소수점 짜리로 반올림해서 리턴한다.<br>
	 *
	 * @param roundValue double
	 * @param c int 소수점 자리수
	 * @return String 결과값
	 * @throws Exception
	 */
	 public double roundDownValue(double roundValue, int c) {
		 double returnDouble = 0;

		 try{
			 BigDecimal bd = new BigDecimal(roundValue);
			 returnDouble = Double.parseDouble(""+bd.setScale(c, BigDecimal.ROUND_DOWN)+"");
		 }catch (Exception e) {
				log.error(e.getMessage(), e);
		 }
	     return returnDouble;
	 }

	/**
	 * [ESM_ACM_0027]
	 * FF Audit Re-Calculate <br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCommCalculationDBDAOSearchRoundValueRSQL(), param, velParam);
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

}