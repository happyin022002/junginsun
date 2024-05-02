/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonDBDAO.java
*@FileTitle : ETC LesCommon Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.29 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.basic.LseCommonBCImpl;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.CdListVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.LseRntlCostAcctOrdVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.SearchInvoiceNoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.MstContainerVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;

/**
 * LseCommonDBDAO <br>
 * LseCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jang Jun-Woo
 * @see LseCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class LseCommonDBDAO extends DBDAOSupport {

	/**
	 * Location - Port 코드목록을 조회합니다.<br>
	 *
	 * @param  String locCd
	 * @return List<MdmLocationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmLocationVO> searchLocationPortData(String locCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);

			dbRowset = new SQLExecuter("").executeQuery(new LseCommonDBDAOSearchLocationPortRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmLocationVO.class);
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
	 * Vessel SKD 목록을 조회합니다.<br>
	 *
	 * @param  String vvdCd
	 * @return List<VskVslPortSkdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskVslPortSkdVO> searchVesselSkdData(String vvdCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("vvd_cd", vvdCd);

			dbRowset = new SQLExecuter("").executeQuery(new LseCommonDBDAOSearchVesselSkdRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO.class);
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
	 * 컨테이너 정보 조회합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return List<MstContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MstContainerVO> searchContainerInfoBrieflyData(String cntrNo) throws DAOException {

		DBRowSet dbRowset = null;
		List<MstContainerVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("").executeQuery(new LseCommonDBDAOSearchContainerInfoRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MstContainerVO.class);
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
	 * Office 코드목록을 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return List<MdmOrganizationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmOrganizationVO> searchOfficeCodeData(String ofcCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmOrganizationVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery(new LseCommonDBDAOSearchOfficeCodeRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO.class);
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
	 * Vessel SVC Lane 목록을 조회합니다.<br>
	 *
	 * @param  String slanCd
	 * @return List<MdmVslSvcLaneVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> searchServiceLaneData(String slanCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("slan_cd", slanCd);

			dbRowset = new SQLExecuter("").executeQuery(new LseCommonDBDAOSearchServiceLaneRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO.class);
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
	 * Container Use Company 리스트 조회<br>
	 * 
	 * @param  CdListVO cdListVO
	 * @return List<CdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CdListVO> searchCntrUseCoCdListData(CdListVO cdListVO) throws DAOException {
		return searchCdNmListData(cdListVO);
	}
	
	/**
	 * Container Use Company 리스트 조회<br>
	 * 
	 * @param  CdListVO cdListVO
	 * @return List<CdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CdListVO> searchCompanyListData(CdListVO cdListVO) throws DAOException {
		List<CdListVO> list = searchCdNmListData(cdListVO);
		return list;
	}
	
	/**
	 * LP Term Lessor 리스트 조회<br>
	 * 
	 * @param  CdListVO cdListVO
	 * @return List<CdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CdListVO> searchVndrSeqListData(CdListVO cdListVO) throws DAOException {
		List<CdListVO> list = searchCdNmListData(cdListVO);
		return list;
	}
	
	/**
	 * EDM code 및 name 리스트 조회<br>
	 * 
	 * @param  CdListVO cdListVO
	 * @return List<CdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CdListVO> searchCdNmListData(CdListVO cdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cdListVO != null) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("edm_cd", cdListVO.getEdmCd());

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new LseCommonDBDAOSearchCdNmListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CdListVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<LseRntlCostAcctOrdVO> searchRentalCostAccountOrdData() throws DAOException {
		DBRowSet dbRowset = null;
		List<LseRntlCostAcctOrdVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new LseCommonDBDAOSearchRentalCostAccountOrdDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, LseRntlCostAcctOrdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * 
	 * @param lseRntlCostAcctOrdVOs
	 * @throws DAOException
	 */
	public void addRentalCostAccountOrdData(List<LseRntlCostAcctOrdVO> lseRntlCostAcctOrdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (lseRntlCostAcctOrdVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new LseCommonDBDAOAddRentalCostAccountOrdDataCSQL(), lseRntlCostAcctOrdVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 
	 * @param lseRntlCostAcctOrdVOs
	 * @throws DAOException
	 */
	public void modifyRentalCostAccountOrdData(List<LseRntlCostAcctOrdVO> lseRntlCostAcctOrdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (lseRntlCostAcctOrdVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new LseCommonDBDAOModifyRentalCostAccountOrdDataUSQL(), lseRntlCostAcctOrdVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 
	 * @param lseRntlCostAcctOrdVOs
	 * @throws DAOException
	 */
	public void removeRentalCostAccountOrdData(List<LseRntlCostAcctOrdVO> lseRntlCostAcctOrdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (lseRntlCostAcctOrdVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new LseCommonDBDAORemoveRentalCostAccountOrdDataDSQL(), lseRntlCostAcctOrdVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * Retriving Charge Type Code<br>
	 * 
	 * @return List<LseRntlCostAcctOrdVO>
	 * @throws DAOException
	 */
	public List<LseRntlCostAcctOrdVO> searchChargeTpCd() throws DAOException {
		DBRowSet dbRowset = null;
		List<LseRntlCostAcctOrdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LseCommonDBDAOSearchChargeTpCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LseRntlCostAcctOrdVO .class);
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
	 *Retriving Lease Term Code<br>
	 * 
	 * @return List<LseRntlCostAcctOrdVO>
	 * @throws DAOException
	 */  
	public List<LseRntlCostAcctOrdVO> searchLeaseTerm() throws DAOException {
		DBRowSet dbRowset = null;
		List<LseRntlCostAcctOrdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LseCommonDBDAOSearchLeaseTermCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LseRntlCostAcctOrdVO .class);
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
	 * Retriving Lease Term Code<br>
	 * @param intgCdId String
	 * @return List<CommonListVO>
	 * @throws DAOException
	 */
 	@SuppressWarnings("unchecked")
	public List<CommonListVO> searchComIntgCdListData(String intgCdId) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			
			Map<String, String> mapVO = new HashMap();
			mapVO.put("ingt_cd_id", intgCdId);

			param.putAll(mapVO); 
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LSECommonDBDAOSearchComIntgCdCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonListVO .class);			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
 	
 	/**
	 * InvoiceNo의 중복정보를 체크한다 : 공통
	 * @param SearchInvoiceNoVO searchInvoiceNoVO
	 * @return List<SearchInvoiceNoVO>
	 * @exception DAOException
	 */
 	@SuppressWarnings("unchecked")
	public List<SearchInvoiceNoVO> searchInvoiceNo(SearchInvoiceNoVO searchInvoiceNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInvoiceNoVO> resultVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();
		try{
			
			//query parameter
			param.putAll(searchInvoiceNoVO.getColumnValues());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LseCommonDBDAOSearchInvoiceNoRSQL(), param, vparam);
			resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceNoVO.class);

			if(!resultVOs.isEmpty()){
				log.info("\n[][checkInvoiceNo] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> inv_no :" + searchInvoiceNoVO.getInvNo());
				throw new DAOException((new ErrorHandler("CSR10005", new String[]{searchInvoiceNoVO.getInvNo()})).getMessage());
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVOs;
	}
 	
 	
 	/**
	 * Retriving BLD UP DATE<br>
	 * @param schDate String
	 * @param agmtSeq String
	 * @return String
	 * @throws DAOException
	 */
 	@SuppressWarnings("unchecked")
	public String searchBldUpDateCheckData(String schDate, String agmtSeq) throws DAOException {
 		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String check = "";
		try {
			if(schDate.length() > 7) {
				param.put("date_gubun", "YYYYMMDD");
				velParam.put("date_gubun", "YYYYMMDD");
			}else{
				param.put("date_gubun", "YYYYMM");
				velParam.put("date_gubun", "YYYYMM");
			}
			param.put("sch_date", schDate);
			param.put("agmt_seq", agmtSeq);

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new LseCommonDBDAOSearchBldUpDateCheckRSQL(),
					param, velParam);
			if (dbRowset.next()) {
				check = dbRowset.getString(1);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
}