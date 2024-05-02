/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtDBDAO.java
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.02 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.basic.TariffMgtBCImpl;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfDtlVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfHdrVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfInQueryVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrRprTrfDtlVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrRprTrfHdrVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomTariffApprovalVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtListVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffRegionVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.RepairTariffMgtINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffApprovalINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * COM TariffMgtDBDAO <br>
 * - COM-AgreementManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author WanGyu Kim
 * @see TariffMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class TariffMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * [EES_MNR_0188]M&R Tariff No Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param TariffPopupINVO tariffPopupINVO
	 * @param SignOnUserAccount account
	 * @return List<CustomMnrRprTrfHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomMnrRprTrfHdrVO> searchRepairTariffPopUpListData(TariffPopupINVO tariffPopupINVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrRprTrfHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tariffPopupINVO != null){
				Map<String, String> mapVO = tariffPopupINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("access_system", account.getAccess_system());
				velParam.put("access_system", account.getAccess_system());

				param.put("user_ofc_cd", account.getOfc_cd());
				velParam.put("user_ofc_cd", account.getOfc_cd());

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchRepairTariffPopUpListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprTrfHdrVO .class);
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
	  * [EES_MNR_0015] M&R Tariff No Combolist의 정보를 조회 합니다. <br>
	  *
	  * @param TariffPopupINVO tariffPopupINVO
	  * @return List<CustomMnrRprTrfHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprTrfHdrVO> searchRepairTariffComboListData(TariffPopupINVO tariffPopupINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrRprTrfHdrVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(tariffPopupINVO != null){
				 Map<String, String> mapVO = tariffPopupINVO .getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchRepairTariffComboListDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprTrfHdrVO .class);
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
	  * [EES_MNR_0215]Tariff Detail Information_Pop_Up의 정보를 조회 합니다. <br>
	  *
	  * @param RepairTariffMgtINVO repairTariffMgtINVO
	  * @param SignOnUserAccount account
	  * @return List<CustomMnrRprTrfHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprTrfHdrVO> searchRepairTariffHeaderData(RepairTariffMgtINVO repairTariffMgtINVO, SignOnUserAccount account) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrRprTrfHdrVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(repairTariffMgtINVO != null){
				 Map<String, String> mapVO = repairTariffMgtINVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 param.put("access_system", account.getAccess_system());
				 velParam.put("access_system", account.getAccess_system());
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchRepairTariffHeaderDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprTrfHdrVO .class);
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
	  * [EES_MNR_0154]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	  *
	  * @param DisposalTariffINVO disposalTariffINVO
	  * @return List<CustomMnrDispTrfHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrDispTrfHdrVO> searchDisposalTariffHeaderData(DisposalTariffINVO disposalTariffINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrDispTrfHdrVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(disposalTariffINVO != null){
				 Map<String, String> mapVO = disposalTariffINVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchDisposalTariffHeaderDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispTrfHdrVO .class);
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
	  * [EES_MNR_0154]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	  *
	  * @param DisposalTariffEffDtINVO disposalTariffEffDtINVO
	  * @return List<DisposalTariffEffDtListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DisposalTariffEffDtListVO> searchDisposalTariffEffDtListData(DisposalTariffEffDtINVO disposalTariffEffDtINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DisposalTariffEffDtListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(disposalTariffEffDtINVO != null){
				 Map<String, String> mapVO = disposalTariffEffDtINVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchDisposalTariffEffDtListDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispTrfHdrVO .class);
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
	  * [EES_MNR_0232] Disposal Tariff by Region의 정보를 조회 합니다. <br>
	  *
	  * @param DisposalTariffEffDtINVO disposalTariffEffDtINVO
	  * @return List<DisposalTariffEffDtListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DisposalTariffEffDtListVO> searchDisposalTariffInqueryEffDtListData(DisposalTariffEffDtINVO disposalTariffEffDtINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DisposalTariffEffDtListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(disposalTariffEffDtINVO != null){
				 Map<String, String> mapVO = disposalTariffEffDtINVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchDisposalTariffInqueryEffDtListDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispTrfHdrVO .class);
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
	  * [EES_MNR_0215]Tariff Detail Information_Pop_Up의 정보를 조회 합니다. <br>
	  *
	  * @param RepairTariffMgtINVO repairTariffMgtINVO
	  * @return List<CustomMnrRprTrfDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprTrfDtlVO> searchRepairTariffDetailData(RepairTariffMgtINVO repairTariffMgtINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrRprTrfDtlVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(repairTariffMgtINVO != null){
				 Map<String, String> mapVO = repairTariffMgtINVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchRepairTariffDetailDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprTrfDtlVO .class);
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
	  * [EES_MNR_0154]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	  *
	  * @param DisposalTariffINVO disposalTariffINVO
	  * @return List<CustomMnrDispTrfDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrDispTrfDtlVO> searchDisposalTariffDetailData(DisposalTariffINVO disposalTariffINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrDispTrfDtlVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(disposalTariffINVO != null){
				 Map<String, String> mapVO = disposalTariffINVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchDisposalTariffDetailDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispTrfDtlVO .class);
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
	  * [EES_MNR_0232]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	  *
	  * @param DisposalTariffINVO disposalTariffINVO
	  * @return List<CustomMnrDispTrfDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrDispTrfInQueryVO> searchDisposalTariffInqueryListData(DisposalTariffINVO disposalTariffINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrDispTrfInQueryVO> customMnrDispTrfInQueryVOS = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(disposalTariffINVO != null){
				 Map<String, String> mapVO = disposalTariffINVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchDisposalTariffInqueryListDataRSQL(), param, velParam);
			 customMnrDispTrfInQueryVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispTrfInQueryVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return customMnrDispTrfInQueryVOS;
	 }

	 /**
	  * [EES_MNR_0014]M&R Standard Tariff Creation & Inquiry의 정보를 조회 합니다. <br>
	  *
	  * @param String preTrfNo
	  * @return String
	  * @exception DAOException
	  */
	 public String searchRepairTariffNoData(String preTrfNo) throws DAOException {
		 DBRowSet dbRowset = null;
		 String trfNo = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(preTrfNo != null){
				 param.put("pre_trf_no", preTrfNo);
				 velParam.put("pre_trf_no", preTrfNo);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchRepairTariffNoDataRSQL(), param, velParam);

			 if(dbRowset.next()){
				 trfNo = dbRowset.getString(1);
			 }

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return trfNo;
	 }


	 /**
	  * [EES_MNR_0154]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	  *
	  * @return String
	  * @exception DAOException
	  */
	 public String searchDisposalTariffSeqData() throws DAOException {
		 DBRowSet dbRowset = null;
		 String trfNo = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchDisposalTariffSeqDataRSQL(), param, velParam);

			 if(dbRowset.next()){
				 trfNo = dbRowset.getString(1);
			 }

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return trfNo;
	 }

	 /**
	  * [EES_MNR_0014]M&R Standard Tariff Creation & Inquiry의 정보를 체크 합니다. <br>
	  *
	  * @param String effDt
	  * @param String eqKndCd
	  * @param String mnrTrfKndCd
	  * @param String vndrSeq
	  * @return int
	  * @exception DAOException
	  */
	 public int checkRepairTariffHeaderData(String effDt, String eqKndCd, String mnrTrfKndCd, String vndrSeq) throws DAOException {
		 DBRowSet dbRowset = null;
		 int cnt = 0;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(effDt != null && eqKndCd != null){
				 param.put("eff_dt", effDt);
				 param.put("eq_knd_cd", eqKndCd);
				 param.put("mnr_trf_knd_cd", mnrTrfKndCd);
				 param.put("vndr_seq", vndrSeq);
				 velParam.put("eff_dt", effDt);
				 velParam.put("eq_knd_cd", eqKndCd);
				 velParam.put("mnr_trf_knd_cd", mnrTrfKndCd);
				 velParam.put("vndr_seq", vndrSeq);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOcheckRepairTariffHeaderDataRSQL(), param, velParam);

			 if(dbRowset.next()){
				 cnt = dbRowset.getInt(1);
			 }

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return cnt;
	 }

	 /**
	  * [EES_MNR_0154]Disposal Tariff by Region의 정보를 체크 합니다. <br>
	  *
	  * @param String effDt
	  * @param String eqKndCd
	  * @param String mnrDispTrfTpCd
	  * @return int
	  * @exception DAOException
	  */
	 public int checkDisposalTariffHeaderData(String effDt, String eqKndCd, String mnrDispTrfTpCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 int cnt = 0;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(effDt != null && eqKndCd != null){
				 param.put("eff_dt", effDt);
				 param.put("eq_knd_cd", eqKndCd);
				 param.put("mnr_disp_trf_tp_cd", mnrDispTrfTpCd);
				 velParam.put("eff_dt", effDt);
				 velParam.put("eq_knd_cd", eqKndCd);
				 velParam.put("mnr_disp_trf_tp_cd", mnrDispTrfTpCd);

			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOcheckDisposalTariffHeaderDataRSQL(), param, velParam);

			 if(dbRowset.next()){
				 cnt = dbRowset.getInt(1);
			 }

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return cnt;
	 }


	 /**
	  * [EES_MNR_0014]M&R Standard Tariff Creation & Inquiry의 정보를 추가 합니다. <br>
	  *
	  * @param List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs
	  * @exception DAOException
	  */
	public void addRepairTariffHeaderData(List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrRprTrfHdrVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOaddRepairTariffHeaderDataCSQL(), customMnrRprTrfHdrVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrDispTrfHdrVO> customMnrDispTrfHdrVOs
	 * @exception DAOException
	 */
	public void addDisposalTariffHeaderData(List<CustomMnrDispTrfHdrVO> customMnrDispTrfHdrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrDispTrfHdrVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOaddDisposalTariffHeaderDataCSQL(), customMnrDispTrfHdrVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [EES_MNR_0014]M&R Standard Tariff Creation & Inquiry의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs
	 * @exception DAOException
	 */
	public void removeRepairTariffHeaderData(List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs) throws DAOException,Exception {

		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrRprTrfHdrVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOremoveRepairTariffHeaderDataDSQL(), customMnrRprTrfHdrVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrDispTrfHdrVO> customMnrDispTrfHdrVOs
	 * @exception DAOException
	 */
	public void removeDisposalTariffHeaderData(List<CustomMnrDispTrfHdrVO> customMnrDispTrfHdrVOs) throws DAOException,Exception {

		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrDispTrfHdrVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOremoveDisposalTariffHeaderDataDSQL(), customMnrDispTrfHdrVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [EES_MNR_0014]M&R Standard Tariff Creation & Inquiry의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVOs
	 * @exception DAOException
	 */
	public void addRepairTariffDetailData(List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if(customMnrRprTrfDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOaddRepairTariffDetailDataCSQL(), customMnrRprTrfDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrDispTrfDtlVO> customMnrDispTrfDtlVOs
	 * @exception DAOException
	 */
	public void addDisposalTariffDetailData(List<CustomMnrDispTrfDtlVO> customMnrDispTrfDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if(customMnrDispTrfDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOaddDisposalTariffDetailDataCSQL(), customMnrDispTrfDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [EES_MNR_0014]M&R Standard Tariff Creation & Inquiry의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVOs
	 * @exception DAOException
	 */
	public void modifyRepairTariffDetailData(List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVOs) throws DAOException,Exception {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMnrRprTrfDtlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOmodifyRepairTariffDetailDataUSQL(), customMnrRprTrfDtlVOs,null);
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
	 * [EES_MNR_0154]Disposal Tariff by Region의 Header 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrDispTrfHdrVO> customMnrDispTrfHdrVOs
	 * @exception DAOException
	 */
	public void modifyDisposalTariffHeaderData(List<CustomMnrDispTrfHdrVO> customMnrDispTrfHdrVOs) throws DAOException,Exception {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMnrDispTrfHdrVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOmodifyDisposalTariffHeaderDataUSQL(), customMnrDispTrfHdrVOs,null);
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
	 * [EES_MNR_0154]Disposal Tariff by Region의 Detail 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrDispTrfDtlVO> customMnrDispTrfDtlVOs
	 * @exception DAOException
	 */
	public void modifyDisposalTariffDetailData(List<CustomMnrDispTrfDtlVO> customMnrDispTrfDtlVOs) throws DAOException,Exception {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMnrDispTrfDtlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOmodifyDisposalTariffDetailDataUSQL(), customMnrDispTrfDtlVOs,null);
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
	 * [EES_MNR_0014]M&R Standard Tariff Creation & Inquiry의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVOs
	 * @exception DAOException
	 */
	public void removeRepairTariffDetailData(List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVOs) throws DAOException,Exception {

		try {
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrRprTrfDtlVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOremoveRepairTariffDetailDataDSQL(), customMnrRprTrfDtlVOs,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrDispTrfDtlVO> customMnrDispTrfDtlVOs
	 * @exception DAOException
	 */
	public void removeDisposalTariffDetailData(List<CustomMnrDispTrfDtlVO> customMnrDispTrfDtlVOs) throws DAOException,Exception {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int delCnt[] = null;
			if(customMnrDispTrfDtlVOs.size() > 0){
				param.put("mnr_del_chk", customMnrDispTrfDtlVOs.get(0).getMnrDispTrfDtlSeq());
				velParam.put("mnr_del_chk", customMnrDispTrfDtlVOs.get(0).getMnrDispTrfDtlSeq());
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOremoveDisposalTariffDetailDataDSQL(), customMnrDispTrfDtlVOs, param, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [EES_MNR_0011]M&R Local Tariff Creation & Verify의 정보를 조회 합니다. <br>
	 *
	 * @param RepairTariffMgtINVO repairTariffMgtINVO
	 * @return List<CustomMnrRprTrfDtlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprTrfDtlVO> searchDefaultRepairTariffDetailData(RepairTariffMgtINVO repairTariffMgtINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrRprTrfDtlVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(repairTariffMgtINVO != null){
				 Map<String, String> mapVO = repairTariffMgtINVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchDefaultRepairTariffDetailDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprTrfDtlVO .class);
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
	  * [EES_MNR_0171]M&R Tariff Inquiry의 정보를 조회 합니다. <br>
	  *
	  * @param TariffApprovalINVO tariffApprovalINVO
	  * @param SignOnUserAccount account
	  * @return List<CustomTariffApprovalVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomTariffApprovalVO> searchRepairTariffApprovalListData(TariffApprovalINVO tariffApprovalINVO,SignOnUserAccount account) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomTariffApprovalVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(tariffApprovalINVO != null){
				 Map<String, String> mapVO = tariffApprovalINVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);

				 param.put("access_system", account.getAccess_system());
				 velParam.put("access_system", account.getAccess_system());
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchRepairTariffApprovalListDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomTariffApprovalVO .class);
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
	  * [EES_MNR_0136]M&R Regional Tariff Approval의 정보를 수정 합니다. <br>
	  *
	  * @param List<CustomTariffApprovalVO> customTariffApprovalVOs
	  * @exception DAOException
	  */
	public void modifyRepairTariffStatusData(List<CustomTariffApprovalVO> customTariffApprovalVOs) throws DAOException,Exception {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customTariffApprovalVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TariffMgtDBDAOmodifyRepairTariffStatusDataUSQL(), customTariffApprovalVOs,null);
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
	  * [EES_MNR_0154] 분기별 매각기준 가격정보 현황을 조회합니다. <br>
	  *
	  * @param DisposalTariffRegionVO disposalTariffRegionVO
	  * @return List<DisposalTariffRegionVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DisposalTariffRegionVO> searchDisposalTariffRegionListData(DisposalTariffRegionVO disposalTariffRegionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DisposalTariffRegionVO> resultVOs = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(disposalTariffRegionVO != null){
				 Map<String, String> mapVO = disposalTariffRegionVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchDisposalTariffRegionListRSQL(), param, velParam);
			 resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, DisposalTariffRegionVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return resultVOs;
	 }

	/**
	 * [EES_MNR_0154] 분기별 매각기준 가격정보의 존재여부를 조회합니다. <br>
	 *
	 * @param  DisposalTariffRegionVO disposalTariffRegionVO
	 * @return boolean
	 * @throws DAOException
	 * @throws Exception
	 */
	public boolean searchDisposalTariffRegionExistData(DisposalTariffRegionVO disposalTariffRegionVO) throws DAOException {
		boolean existFlag = false;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(disposalTariffRegionVO != null) {
				Map<String, String> mapVO = disposalTariffRegionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter().executeQuery(new TariffMgtDBDAOsearchDisposalTariffRegionExistRSQL(), param, velParam);
			existFlag = dbRowset.next();
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return existFlag;
	}

	/**
	 * [EES_MNR_0154] 분기별 매각기준 가격정보를 일괄 생성합니다.<br>
	 *
	 * @param  List<DisposalTariffRegionVO> disposalTariffRegionVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDisposalTariffRegionListData(List<DisposalTariffRegionVO> disposalTariffRegionVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int insCnt[] = null;
			if(disposalTariffRegionVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new TariffMgtDBDAOaddDisposalTariffRegionInfoCSQL(), disposalTariffRegionVOs, null);
				for(int i = 0; i < insCnt.length; i++) {
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * [EES_MNR_0154] 분기별 매각기준 가격정보를 일괄 갱신합니다.<br>
	 *
	 * @param  List<DisposalTariffRegionVO> disposalTariffRegionVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyDisposalTariffRegionListData(List<DisposalTariffRegionVO> disposalTariffRegionVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int updCnt[] = null;
			if(disposalTariffRegionVOs.size() > 0) {
				updCnt = sqlExe.executeBatch(new TariffMgtDBDAOmodifyDisposalTariffRegionInfoUSQL(), disposalTariffRegionVOs, null);
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
	 * [EES_MNR_0154] 분기별 매각기준 가격정보를 일괄 삭제합니다.<br>
	 *
	 * @param  List<DisposalTariffRegionVO> disposalTariffRegionVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeDisposalTariffRegionListData(List<DisposalTariffRegionVO> disposalTariffRegionVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int delCnt[] = null;
			if(disposalTariffRegionVOs.size() > 0) {
				delCnt = sqlExe.executeBatch(new TariffMgtDBDAOremoveDisposalTariffRegionInfoDSQL(), disposalTariffRegionVOs, null);
				for(int i = 0; i < delCnt.length; i++) {
					if(delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	  * [EES_MNR_0232] 분기별 지역별 매각기준 가격정보 현황을 조회합니다. <br>
	  *
	  * @param DisposalTariffQuarterVO disposalTariffQuarterVO
	  * @return List<DisposalTariffQuarterVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DisposalTariffQuarterVO> searchDisposalTariffQuarterListData(DisposalTariffQuarterVO disposalTariffQuarterVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DisposalTariffQuarterVO> resultVOs = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(disposalTariffQuarterVO != null){
				 Map<String, String> mapVO = disposalTariffQuarterVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffMgtDBDAOsearchDisposalTariffQuarterListRSQL(), param, velParam);
			 resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, DisposalTariffQuarterVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return resultVOs;
	 }
}