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
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireRegisterVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireSummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireYardCodeVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration.RuLabelManagementDBDAOAddRuLabelAttachManagementDataCSQL;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration.RuLabelManagementDBDAOAddRubelManagementDataCSQL;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * AvailableOffHireDBDAO <br>
 * ContainerLeaseMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
				List<String> arrLabelValueList = null;
				List<String> arrCntrNo = null;
				
				if ( !JSPUtil.getNull(searchParamVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 

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
				
				if ( !JSPUtil.getNull(searchParamVO.getCntrNo()).equals("") ) {
					arrCntrNo = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrNo(),",","|"));
					param.put("cntr_no", arrCntrNo);
					velParam.put("cntr_no", arrCntrNo);
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
				List<String> arrComplexPk = null;
				List<String> arrComplexPk2 = null;
				List<String> arrLabelValueList = null;
				List<String> arrCntrNo = null;
				
				if ( !JSPUtil.getNull(searchParamVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 

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

				if ( !JSPUtil.getNull(searchParamVO.getComplexPk()).equals("") ) {
					arrComplexPk = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getComplexPk(),",","|"));
					param.put("complex_pk_seq", arrComplexPk);
					velParam.put("complex_pk_seq", arrComplexPk);
				}

				if ( !JSPUtil.getNull(searchParamVO.getComplexPk2()).equals("") ) {
					arrComplexPk2 = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getComplexPk2(),",","|"));
					param.put("complex_pk2_seq", arrComplexPk2);
					velParam.put("complex_pk2_seq", arrComplexPk2);
				}
				
				if ( !JSPUtil.getNull(searchParamVO.getCntrNo()).equals("") ) {
					arrCntrNo = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrNo(),",","|"));
					param.put("cntr_no", arrCntrNo);
					velParam.put("cntr_no", arrCntrNo);
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
				List<String> arrLabelValueList = null;
				List<String> arrCntrNo = null;
				
				if ( !JSPUtil.getNull(searchParamVO.getRstr_usg_lbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getRstr_usg_lbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				

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
				
				if ( !JSPUtil.getNull(searchParamVO.getCntrNo()).equals("") ) {
					arrCntrNo = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrNo(),",","|"));
					param.put("cntr_no", arrCntrNo);
					velParam.put("cntr_no", arrCntrNo);
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
     * 
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
	 * 
	 * EES_LSE_0023 : retrieve Target Location <br>
	 * Target Location 설정을 위해 조회합니다.<br>	 
	 * @author Ji yeon Jeon
	 * @category EES_LSE_0023
	 * @category addAvailableOffHireContainerLocationData     
	 * @param AvailableOffHireRegisterVO availableOffHireRegisterVO
	 * @return List<AvailableOffHireRegisterVO>
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<AvailableOffHireRegisterVO> addAvailableOffHireContainerLocationData(AvailableOffHireRegisterVO availableOffHireRegisterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvailableOffHireRegisterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(availableOffHireRegisterVO != null){
				Map<String, String> mapVO = availableOffHireRegisterVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AvailableOffHireDBDAOAvailableOffHireContainerLocationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOffHireRegisterVO.class);
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
	 * EES_LSE_0023 : retrieve Target Location <br>
	 * Target Location이 설정된 data를 조회합니다.<br>	 
	 * @author Ji yeon Jeon
	 * @category EES_LSE_0023
	 * @category addAvailableOffHireContainerTargetData     
	 * @param AvailableOffHireRegisterVO availableOffHireRegisterVO
	 * @return List<AvailableOffHireRegisterVO>
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<AvailableOffHireRegisterVO> addAvailableOffHireContainerTargetData(AvailableOffHireRegisterVO availableOffHireRegisterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvailableOffHireRegisterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrLstmList  = null;
		List<String> arrTpszList  = null;
		List<String> arrLoccdList = null;
		
		try {
				Map<String, String> mapVO = availableOffHireRegisterVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if ( !JSPUtil.getNull(availableOffHireRegisterVO.getLstmCd()).equals("") ) {
					arrLstmList = JSPUtil.convertStringToArrayList(JSPUtil.replace(availableOffHireRegisterVO.getLstmCd(),",","|"));
					param.put("lstm_list", arrLstmList);
					velParam.put("lstm_list", arrLstmList);
				}
				
				if ( "ALL".equals(availableOffHireRegisterVO.getLstmCd()) || availableOffHireRegisterVO.getLstmCd() == "") {
					param.put("lstm_type_val", "ALL");
					velParam.put("lstm_type_val", "ALL");
					param.put("lstm_list", "");
					velParam.put("lstm_list", "");
				}
				
				if ( !JSPUtil.getNull(availableOffHireRegisterVO.getCntrTpszCd()).equals("") ) {
					arrTpszList = JSPUtil.convertStringToArrayList(JSPUtil.replace(availableOffHireRegisterVO.getCntrTpszCd(),",","|"));
					param.put("cntr_tpsz_list", arrTpszList);
					velParam.put("cntr_tpsz_list", arrTpszList);
				}
				
				if ( !JSPUtil.getNull(availableOffHireRegisterVO.getLocCd()).equals("") ) {
					arrLoccdList = JSPUtil.convertStringToArrayList(JSPUtil.replace(availableOffHireRegisterVO.getLocCd(),",","|"));
					param.put("loc_cd_list", arrLoccdList);
					velParam.put("loc_cd_list", arrLoccdList);
				}
			dbRowset = new SQLExecuter("").executeQuery(new AvailableOffHireDBDAOAvailableOffHireContainerTargetLocationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOffHireRegisterVO.class);
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
	 * 
	 * EES_LSE_0023 : Retrieve Agreement datan <br>
	 * agreement 정보를 조회합니다.<br>	 
	 * @author Ji yeon Jeon
	 * @category EES_LSE_0023
	 * @category searchTargetOffHireContainerAgreementData     
	 * @param AvailableOffHireRegisterVO availableOffHireRegisterVO
	 * @return List<AvailableOffHireRegisterVO>
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<AvailableOffHireRegisterVO> searchTargetOffHireContainerAgreementData(AvailableOffHireRegisterVO availableOffHireRegisterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AvailableOffHireRegisterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(availableOffHireRegisterVO != null){
				Map<String, String> mapVO = availableOffHireRegisterVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AvailableOffHireDBDAOTargetOffHireContainerAgreementRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AvailableOffHireRegisterVO.class);
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
	 * 
	 * EES_LSE_0023 : Save Target Location <br>
	 * Target Location을 저장합니다.<br>	 
	 * @author Ji yeon Jeon
	 * @category EES_LSE_0023
	 * @category modifyTargetOffHireContainerLocationData     
	 * @param AvailableOffHireRegisterVO  availableOffHireRegisterVO
	 * @throws DAOException, Exception
	 */
	public void modifyTargetOffHireContainerLocationData(AvailableOffHireRegisterVO  availableOffHireRegisterVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(availableOffHireRegisterVO != null){
				Map<String, String> mapVO = availableOffHireRegisterVO.getColumnValues();
				param.putAll(mapVO);
			    velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int addCnt = sqlExe.executeUpdate((ISQLTemplate)new AvailableOffHireDBDAOTargetOffHireContainerLocationCSQL(), param, velParam);

			if(addCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 
	 * EES_LSE_0023 : Save Target Location <br>
	 * Target Location을 수정시 삭제후 저장합니다.<br>	 
	 * @author Ji yeon Jeon
	 * @category EES_LSE_0023
	 * @category modifyTargetOffHireContainerLocationData     
	 * @param List<AvailableOffHireRegisterVO>  availableOffHireRegisterVOs
	 * @throws DAOException, Exception
	 */
	public void deleteTargetOffHireContainerLocationData(List<AvailableOffHireRegisterVO>  availableOffHireRegisterVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(availableOffHireRegisterVOs.size() > 0){
				
				delCnt = sqlExe.executeBatch((ISQLTemplate) new AvailableOffHireDBDAOTargetOffHireContainerLocationDSQL(), availableOffHireRegisterVOs, null);
				
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}