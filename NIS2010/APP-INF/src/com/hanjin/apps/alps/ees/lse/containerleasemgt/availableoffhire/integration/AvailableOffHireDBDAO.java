/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailableOffHireDBDAO.java
*@FileTitle : Available Off Hire Q'ty List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.29 장준우
* 1.0 Creation
* history
* 2014-08-11 길정권 [CHM-201431528] ALPS LSE-Office Hire 절차 변경(e-mail 기능 / Confirm 기능/LSO때 MST로 Interface하는 기능)
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireContainerListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireSummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireYardCodeVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS AvailableOffHireDBDAO <br>
 * - ALPS-ContainerLeaseMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jang Jun-Woo
 * @see AvailableOffHireBCImpl 참조
 * @since J2EE 1.6
 */
public class AvailableOffHireDBDAO extends DBDAOSupport {

	/**
     * 지역별 반납가능 대상 장비의 현황을 조회합니다.<br>
     *
     * @param  SearchParamVO searchParamVO
     * @return List<AvailableOffHireSummaryVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<AvailableOffHireSummaryVO> searchAvailableOffHireContainerSummaryData(SearchParamVO searchParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvailableOffHireSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> arrLstmCd  = null;
				List<String> arrCntrTpszCd = null;
				List<String> arrCnMvStsCd = null;

				if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
					arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
					param.put("lstm_cd_seq", arrLstmCd);
					velParam.put("lstm_cd_seq", arrLstmCd);
				}
				
				if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}

				if ( !JSPUtil.getNull(searchParamVO.getCnmvStsCd()).equals("") ) {
					arrCnMvStsCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCnmvStsCd(),",","|"));
					param.put("cnmv_sts_cd_seq", arrCnMvStsCd);
					velParam.put("cnmv_sts_cd_seq", arrCnMvStsCd);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new AvailableOffHireDBDAOAvailableOffHireContainerSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOffHireSummaryVO.class);
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
     * 선택된 반납가능 대상 장비의 내역을 조회합니다.<br>
     *
     * @param  SearchParamVO searchParamVO
     * @return List<AvailableOffHireDetailVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<AvailableOffHireDetailVO> searchAvailableOffHireContainerDetailData(SearchParamVO searchParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvailableOffHireDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> arrLstmCd  = null;
				List<String> arrCntrTpszCd = null;
				List<String> arrCnMvStsCd = null;

				if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
					arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
					param.put("lstm_cd_seq", arrLstmCd);
					velParam.put("lstm_cd_seq", arrLstmCd);
				}

				if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}

				if ( !JSPUtil.getNull(searchParamVO.getCnmvStsCd()).equals("") ) {
					arrCnMvStsCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCnmvStsCd(),",","|"));
					param.put("cnmv_sts_cd_seq", arrCnMvStsCd);
					velParam.put("cnmv_sts_cd_seq", arrCnMvStsCd);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new AvailableOffHireDBDAOAvailableOffHireContainerDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOffHireDetailVO.class);
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
	 * 선택된 반납가능 대상 장비의 내역을 생성합니다.<br>
	 *
	 * @param  AvailableOffHireDetailVO availableOffHireDetailVO
	 * @throws DAOException
	 */
	public void addAvailableOffHireContainerDetailData(AvailableOffHireDetailVO availableOffHireDetailVO) throws DAOException {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(availableOffHireDetailVO != null){
				Map<String, String> mapVO = availableOffHireDetailVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new AvailableOffHireDBDAOAvailableOffHireContainerDetailCSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * 지역별 지정된 반납대상 장비의 현황을 조회합니다.<br>
     *
     * @param  SearchParamVO searchParamVO
     * @return List<AvailableOffHireConfirmVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<AvailableOffHireConfirmVO> searchAvailableOffHireContainerConfirmData(SearchParamVO searchParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvailableOffHireConfirmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> arrLstmCd  = null;
				List<String> arrCntrTpszCd = null;
				List<String> arrCnMvStsCd = null;
				List<String> arrCntrList = null;

				if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
					arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
					param.put("lstm_cd_seq", arrLstmCd);
					velParam.put("lstm_cd_seq", arrLstmCd);
				}

				if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
					velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}

				if ( !JSPUtil.getNull(searchParamVO.getCnmvStsCd()).equals("") ) {
					arrCnMvStsCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCnmvStsCd(),",","|"));
					param.put("cnmv_sts_cd_seq", arrCnMvStsCd);
					velParam.put("cnmv_sts_cd_seq", arrCnMvStsCd);
				}

				if ( !JSPUtil.getNull(searchParamVO.getCntrList()).equals("") ) {
					arrCntrList = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrList(),",","|"));
		        	param.put("cntr_list", arrCntrList);
		        	velParam.put("cntr_list", arrCntrList);        			
		        }
			}

			dbRowset = new SQLExecuter("").executeQuery(new AvailableOffHireDBDAOAvailableOffHireContainerConfirmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOffHireConfirmVO.class);
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
	 * 선정된 대상장비의 내역을 반납확정 자료로 일괄갱신합니다.<br>
	 *
	 * @param  List<AvailableOffHireConfirmVO> availableOffHireConfirmVOs
	 * @throws DAOException
	 */
	public void modifyAvailableOffHireContainerConfirmData(List<AvailableOffHireConfirmVO> availableOffHireConfirmVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int updCnt[] = null;

			if(availableOffHireConfirmVOs.size() > 0) {
				updCnt = sqlExe.executeBatch(new AvailableOffHireDBDAOAvailableOffHireContainerConfirmUSQL(), availableOffHireConfirmVOs, null);
				for(int i = 0; i < updCnt.length; i++) {
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 선정된 대상장비의 내역 및 반납확정 자료를 일괄삭제합니다.<br>
	 *
	 * @param  List<AvailableOffHireConfirmVO> availableOffHireConfirmVOs
	 * @throws DAOException
	 */
	public void removeAvailableOffHireContainerConfirmData(List<AvailableOffHireConfirmVO> availableOffHireConfirmVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int delCnt[] = null;

			if(availableOffHireConfirmVOs.size() > 0) {
				delCnt = sqlExe.executeBatch(new AvailableOffHireDBDAOAvailableOffHireContainerConfirmDSQL(), availableOffHireConfirmVOs, null);
				for(int i = 0; i < delCnt.length; i++) {
					if(delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 선정된 대상장비의 반납상태 정보를 갱신합니다.<br>
	 *
	 * @param  AvailableOffHireConfirmVO availableOffHireConfirmVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAvailableOffHireContainerStatusData(AvailableOffHireConfirmVO availableOffHireConfirmVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(availableOffHireConfirmVO != null){
				Map<String, String> mapVO = availableOffHireConfirmVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new AvailableOffHireDBDAOAvailableOffHireContainerStatusUSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return trxCnt;
	}

	/**
	 * 선정된 대상장비의 반납상태 정보를 삭제합니다.<br>
	 *
	 * @param  AvailableOffHireConfirmVO availableOffHireConfirmVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeAvailableOffHireContainerStatusData(AvailableOffHireConfirmVO availableOffHireConfirmVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(availableOffHireConfirmVO != null){
				Map<String, String> mapVO = availableOffHireConfirmVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new AvailableOffHireDBDAOAvailableOffHireContainerStatusDSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return trxCnt;
	}

	/**
     * AvailableOffHire Yard 코드 목록을 조회합니다.<br>
     *
     * @param  SearchParamVO searchParamVO
     * @return List<AvailableOffHireYardCodeVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<AvailableOffHireYardCodeVO> searchAvailableOffHireYardCodeListData(SearchParamVO searchParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvailableOffHireYardCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new AvailableOffHireDBDAOAvailableOffHireYardCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOffHireYardCodeVO.class);
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
     * AvailableOffHire Container 목록을 조회합니다.<br>
     *
     * @param  AvailableOffHireContainerListVO availableOffHireContainerListVO
     * @return List<AvailableOffHireContainerListVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<AvailableOffHireContainerListVO> searchAvailableOffHireContainerListData(AvailableOffHireContainerListVO availableOffHireContainerListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvailableOffHireContainerListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(availableOffHireContainerListVO != null){
				
				Map<String, String> mapVO = availableOffHireContainerListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> arrLstmCd  = null;
				List<String> arrCnMvStsCd = null;

				if ( !JSPUtil.getNull(availableOffHireContainerListVO.getLstmCd()).equals("") ) {
					arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(availableOffHireContainerListVO.getLstmCd(),",","|"));
					param.put("lstm_cd_seq", arrLstmCd);
					velParam.put("lstm_cd_seq", arrLstmCd);
				}

				if ( !JSPUtil.getNull(availableOffHireContainerListVO.getCnmvStsCd()).equals("") ) {
					arrCnMvStsCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(availableOffHireContainerListVO.getCnmvStsCd(),",","|"));
					param.put("cnmv_sts_cd_seq", arrCnMvStsCd);
					velParam.put("cnmv_sts_cd_seq", arrCnMvStsCd);
				}

			}

			dbRowset = new SQLExecuter("").executeQuery(new AvailableOffHireDBDAOAvailableOffHireLocationContainerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOffHireContainerListVO.class);
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
     * AvailableOffHire Container 목록을 조회합니다.<br>
     *
     * @param  AvailableOffHireContainerListVO availableOffHireContainerListVO
     * @return List<AvailableOffHireContainerListVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<AvailableOffHireContainerListVO> searchAvailableOffHireOriginContainerListData(AvailableOffHireContainerListVO availableOffHireContainerListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvailableOffHireContainerListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(availableOffHireContainerListVO != null){
				
				Map<String, String> mapVO = availableOffHireContainerListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> arrLstmCd  = null;
				List<String> arrCnMvStsCd = null;
				List<String> arrSccList = null;

				if ( !JSPUtil.getNull(availableOffHireContainerListVO.getLstmCd()).equals("") ) {
					arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(availableOffHireContainerListVO.getLstmCd(),",","|"));
					param.put("lstm_cd_seq", arrLstmCd);
					velParam.put("lstm_cd_seq", arrLstmCd);
				}

				if ( !JSPUtil.getNull(availableOffHireContainerListVO.getCnmvStsCd()).equals("") ) {
					arrCnMvStsCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(availableOffHireContainerListVO.getCnmvStsCd(),",","|"));
					param.put("cnmv_sts_cd_seq", arrCnMvStsCd);
					velParam.put("cnmv_sts_cd_seq", arrCnMvStsCd);
				}

				if ( !JSPUtil.getNull(availableOffHireContainerListVO.getSccList()).equals("") ) {
					arrSccList = JSPUtil.convertStringToArrayList(JSPUtil.replace(availableOffHireContainerListVO.getSccList(),",","|"));
					param.put("scc_list_seq", arrSccList);
					velParam.put("scc_list_seq", arrSccList);
				}
				
			}

			dbRowset = new SQLExecuter("").executeQuery(new AvailableOffHireDBDAOAvailableOffHireOriginLocationContainerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOffHireContainerListVO.class);
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