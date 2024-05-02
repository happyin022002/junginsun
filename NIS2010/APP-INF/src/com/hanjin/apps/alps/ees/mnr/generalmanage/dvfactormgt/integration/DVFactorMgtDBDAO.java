/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DVFactorMgt.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.20 김완규
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
*                                      - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
*                                      - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.basic.DVFactorMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealInquiryVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealNoCreationVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.CustomMnrEqDpcVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DVFactorINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DvLeasedUnitINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DvLeasedUnitVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * alps DVFactorMgtDBDAO <br>
 * - alps-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author pms
 * @see DVFactorMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class DVFactorMgtDBDAO extends DBDAOSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * [EES_MNR_0107]DV Factor의 정보를 조회 합니다. <br>
	 *
	 * @param DVFactorINVO dVFactorINVO
	 * @return List<CustomMnrEqDpcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrEqDpcVO> searchDVFactorListData(DVFactorINVO dVFactorINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrEqDpcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dVFactorINVO != null){
				if (dVFactorINVO.getEqKndCd() != null && dVFactorINVO.getEqKndCd().trim().length() > 0) {
					param.put("eq_knd_cd", dVFactorINVO.getEqKndCd());
					velParam.put("eq_knd_cd", dVFactorINVO.getEqKndCd());
					param.put("eq_dpc_yr", dVFactorINVO.getEqDpcYr());
					velParam.put("eq_dpc_yr", dVFactorINVO.getEqDpcYr());
					param.put("eq_dpc_rt", dVFactorINVO.getEqDpcRt());
					velParam.put("eq_dpc_rt", dVFactorINVO.getEqDpcRt());
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DVFactorMgtDBDAOsearchDVFactorListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqDpcVO .class);
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
	 * [EES_MNR_0107]DV Factor의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrEqDpcVO> customMnrEqDpcVOs
	 * @exception DAOException
	 */
	public void modifyDVFactorData(List<CustomMnrEqDpcVO> customMnrEqDpcVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMnrEqDpcVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DVFactorMgtDBDAOmodifyDVFactorDataUSQL(), customMnrEqDpcVOs,null);

				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0249]DV Leased Unit의 정보를 조회 합니다. <br>
	 * @param DvLeasedUnitINVO dvLeasedUnitINVO
	 * @return List<DvLeasedUnitVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DvLeasedUnitVO> searchDvLeasedUnitListData(DvLeasedUnitINVO dvLeasedUnitINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DvLeasedUnitVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DVFactorMgtDBDAOsearchDvLeasedUnitRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DvLeasedUnitVO .class);
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
	 * [EES_MNR_0249]DV Leased Unit의 정보를 수정 합니다. <br>
	 *
	 * @param DvLeasedUnitVO dvLeasedUnitVO
	 * @exception DAOException
	 */
	public void modifyDvLeasedUnitListData(DvLeasedUnitVO dvLeasedUnitVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dvLeasedUnitVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DVFactorMgtDBDAOmodifyDvLeasedUnitRSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to DVFactorMgtDBDAOmodifyDvLeasedUnitRSQL UPDATE SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0249]DV Leased Unit의 정보를 등록 합니다. <br>
	 *
	 * @param DvLeasedUnitVO dvLeasedUnitVO
	 * @exception DAOException
	 */
	public void createHangerInventoryData(DvLeasedUnitVO dvLeasedUnitVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dvLeasedUnitVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DVFactorMgtDBDAOcreateDvLeasedUnitCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to DVFactorMgtDBDAOcreateDvLeasedUnitCSQL INSERT SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [EES_MNR_0249]DV Leased Unit의 정보를 삭제 합니다. <br>
	 *
	 * @param DvLeasedUnitVO dvLeasedUnitVO
	 * @exception DAOException
	 */
	public void removeHangerInventoryData(DvLeasedUnitVO dvLeasedUnitVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dvLeasedUnitVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DVFactorMgtDBDAOdeleteDvLeasedUnitDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to DVFactorMgtDBDAOdeleteDvLeasedUnitDSQL DERETE SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0253]Container Seal No-Creation의 정보를 조회 합니다. <br>
	 * @param ContainerSealNoCreationVO ContainerSealNoCreationVO
	 * @return List<ContainerSealNoCreationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ContainerSealNoCreationVO> searchContainerSealNoCreationData(ContainerSealNoCreationVO containerSealNoCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ContainerSealNoCreationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (containerSealNoCreationVO.getFrYear() != null && containerSealNoCreationVO.getPlnMonth().trim().length() > 0) {
			Map<String, String> mapVO = containerSealNoCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DVFactorMgtDBDAOsearchContainerSealNoCreationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContainerSealNoCreationVO .class);
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
	 * [EES_MNR_0253]Container Seal No-Creation의 정보를 등록 합니다. <br>
	 *
	 * @param List<ContainerSealNoCreationVO> containerSealNoCreationVOs
	 * @exception DAOException
	 */
	public void createContainerSealNoCreationData(List<ContainerSealNoCreationVO> containerSealNoCreationVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insertCnt[] = null;
			if(containerSealNoCreationVOs.size() > 0){
				insertCnt = sqlExe.executeBatch((ISQLTemplate)new DVFactorMgtDBDAOcreateContainerSealNoCreationCSQL(), containerSealNoCreationVOs, null);

				for(int i = 0; i < insertCnt.length; i++){
					if(insertCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0253]Container Seal No-Creation의 정보를 수정 합니다. <br>
	 *
	 * @param List<ContainerSealNoCreationVO> containerSealNoCreationVOs
	 * @exception DAOException
	 */
	public void modifyContainerSealNoCreationData(List<ContainerSealNoCreationVO> containerSealNoCreationVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insertCnt[] = null;
			if(containerSealNoCreationVOs.size() > 0){
				insertCnt = sqlExe.executeBatch((ISQLTemplate)new DVFactorMgtDBDAOmodifyContainerSealNoCreationUSQL(), containerSealNoCreationVOs, null);
				for(int i = 0; i < insertCnt.length; i++){
					if(insertCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0253]Container Seal No-Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param List<ContainerSealNoCreationVO> containerSealNoCreationVOs
	 * @exception DAOException
	 */
	public void removeContainerSealNoCreationData(List<ContainerSealNoCreationVO> containerSealNoCreationVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insertCnt[] = null;
			if(containerSealNoCreationVOs.size() > 0){
				insertCnt = sqlExe.executeBatch((ISQLTemplate)new DVFactorMgtDBDAOdeleteContainerSealNoCreationDSQL(), containerSealNoCreationVOs, null);
				for(int i = 0; i < insertCnt.length; i++){
					if(insertCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0253]Container Seal No-Creation의 정보를 Validation을 체크한다.<br>
	 * @category [EES_MNR_0249]DV Leased Unit의 정보
	 * @category searchContainerSealNoCreationChkData
	 * @param ContainerSealNoCreationVO containerSealNoCreationVO
	 * @return List<ContainerSealNoCreationVO>
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ContainerSealNoCreationVO> searchContainerSealNoCreationChkData(ContainerSealNoCreationVO containerSealNoCreationVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<ContainerSealNoCreationVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(containerSealNoCreationVO != null){
				list = new ArrayList<ContainerSealNoCreationVO>();
				Map<String, String> mapVO = containerSealNoCreationVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DVFactorMgtDBDAOsearchContainerSealNoCreationChkRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContainerSealNoCreationVO .class);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [EES_MNR_0254] Container Seal Inquiry 카운트(Out of Range) 조회<br>
	 *
	 * @param ContainerSealInquiryVO containerSealInquiryVO
	 * @return String
	 * @throws DAOException
	 */
	 public String searchContainerSealInquiryCount(ContainerSealInquiryVO containerSealInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		String returnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(containerSealInquiryVO != null){
				Map<String, String> mapVO = containerSealInquiryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DVFactorMgtDBDAOsearchContainerSealInquiryCountRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("OUT_QTY");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * [EES_MNR_0254] Container Seal Inquiry 목록 조회<br>
	 *
	 * @param ContainerSealInquiryVO containerSealInquiryVO
	 * @return List<ContainerSealInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ContainerSealInquiryVO> searchContainerSealInquiryList(ContainerSealInquiryVO containerSealInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ContainerSealInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(containerSealInquiryVO != null){
				Map<String, String> mapVO = containerSealInquiryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DVFactorMgtDBDAOsearchContainerSealInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContainerSealInquiryVO.class);
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
