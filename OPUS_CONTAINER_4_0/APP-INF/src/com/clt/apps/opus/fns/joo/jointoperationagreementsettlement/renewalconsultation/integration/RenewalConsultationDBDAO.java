/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAO.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.04.24 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ActualDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ConsultationConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.SettlementTargetVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.basic.RenewalMasterDataMgtBCImpl;
import com.clt.apps.opus.fns.joo.joocommonutil.BizComJooUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS JointOperationMasterDataMgtDBDAO <br>
 * - OPUS-JointOperationMasterDataMgtSC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Hee Dong
 * @see RenewalMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class RenewalConsultationDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Retrieve : Select Target VVD For Settlement Creation화면 조회.
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
	 * @return List<SettlementTargetVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SettlementTargetVO> searchSettlementTargetList(SettlementTargetVO settlementTargetVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SettlementTargetVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			if (settlementTargetVO != null) {
				Map<String, String> mapVO = settlementTargetVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//2015.07.10 Modify : Item : ALL을 제외한 S/H, OPR, 그외 Item.
				itemList = BizComJooUtil.getSeperationParameterList(settlementTargetVO.getJoStlItmCds(), ",");
				if(itemList != null && itemList.size() > 0){
					param.put("jo_stl_itm_cds"		, itemList);
					velParam.put("jo_stl_itm_cds"	, itemList);
				}else{
					param.put("jo_stl_itm_cds"		, "");
					velParam.put("jo_stl_itm_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchSettlementTargetListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SettlementTargetVO.class);
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
	 * Create : Select Target VVD For Settlement Creation화면 조회.
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
	 * @return List<SettlementTargetVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SettlementTargetVO> calculateSettlementTargetList(SettlementTargetVO settlementTargetVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SettlementTargetVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			if (settlementTargetVO != null) {
				Map<String, String> mapVO = settlementTargetVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//2015.07.10 Modify : Item : ALL을 제외한 S/H, OPR, 그외 Item.
				itemList = BizComJooUtil.getSeperationParameterList(settlementTargetVO.getJoStlItmCds(), ",");
				if(itemList != null && itemList.size() > 0){
					param.put("jo_stl_itm_cds"		, itemList);
					velParam.put("jo_stl_itm_cds"	, itemList);
				}else{
					param.put("jo_stl_itm_cds"		, "");
					velParam.put("jo_stl_itm_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOCalculateSettlementTargetListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SettlementTargetVO.class);
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
	 * Check : Invoice Detail 존재 여부 체크.
	 * 
	 * @category FNS_JOO_0101
	 * @param InvoiceDetailVO invoiceDetailVO
	 * @return String
	 * @exception EventException
	 */
	public String checkExistInvoiceDetail(InvoiceDetailVO invoiceDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(invoiceDetailVO != null){
				Map<String, String> mapVO = invoiceDetailVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOCheckExistInvoiceDetailRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("EXIST_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
	
	/**
	 * Settlement Target 삭제.
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeSettlementTarget(SettlementTargetVO settlementTargetVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementTargetVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalConsultationDBDAORemoveSettlementTargetDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Settlement Target Insert
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSettlementTarget(SettlementTargetVO settlementTargetVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementTargetVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalConsultationDBDAOAddSettlementTargetCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Settlement Target 수정
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySettlementTarget(SettlementTargetVO settlementTargetVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementTargetVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalConsultationDBDAOModifySettlementTargetUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Settlement Target Max STL_VVD_SEQ.
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMaxStlVvdSeq(SettlementTargetVO settlementTargetVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(settlementTargetVO != null){
				Map<String, String> mapVO = settlementTargetVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchMaxStlVvdSeqRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("MAX_STL_VVD_SEQ");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
	
	/**
	 * Retrieve : Select actual payer/receiver for slip 조회.
	 * 
	 * @category FNS_JOO_0104
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvoiceVO> searchActualPayerReceiverList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//2015.07.10 Modify : Item : ALL을 제외한 S/H, OPR, 그외 Item.
				itemList = BizComJooUtil.getSeperationParameterList(consultationConditionVO.getJoStlItmCds(), ",");
				if(itemList != null && itemList.size() > 0){
					param.put("jo_stl_itm_cds"		, itemList);
					velParam.put("jo_stl_itm_cds"	, itemList);
				}else{
					param.put("jo_stl_itm_cds"		, "");
					velParam.put("jo_stl_itm_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchActualPayerReceiverListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceVO.class);
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
	 * Calculate : Select actual payer/receiver for slip Auto 조회.
	 * 
	 * @category FNS_JOO_0104
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvoiceDetailVO> calculateActualPayerReceiverList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//2015.07.10 Modify : Item : ALL을 제외한 S/H, OPR, 그외 Item.
				itemList = BizComJooUtil.getSeperationParameterList(consultationConditionVO.getJoStlItmCds(), ",");
				if(itemList != null && itemList.size() > 0){
					param.put("jo_stl_itm_cds"		, itemList);
					velParam.put("jo_stl_itm_cds"	, itemList);
				}else{
					param.put("jo_stl_itm_cds"		, "");
					velParam.put("jo_stl_itm_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOCalculateActualPayerReceiverListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceDetailVO.class);
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
	 * New Invoice No.
	 * 
	 * @category FNS_JOO_0104
	 * @param InvoiceVO invoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String searchNewInvoiceNo(InvoiceVO invoiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(invoiceVO != null){
				Map<String, String> mapVO = invoiceVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchNewInvoiceNoRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("NEW_INV_NO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}


	/**
	 * Save : Select actual payer/receiver for slip Auto 저장.
	 *        > Invoice
	 * 
	 * @category FNS_JOO_0104
	 * @param InvoiceVO invoiceVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addInvoice(InvoiceVO invoiceVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = invoiceVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalConsultationDBDAOAddInvoiceCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}



	/**
	 * Save : Select actual payer/receiver for slip Auto 저장.
	 *        Invoice Detail
	 * 
	 * @category FNS_JOO_0104
	 * @param InvoiceDetailVO invoiceDetailVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addInvoiceDetail(InvoiceDetailVO invoiceDetailVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = invoiceDetailVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalConsultationDBDAOAddInvoiceDetailCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Save : Select actual payer/receiver for slip Auto 저장.
	 *        JOO_STL_TGT.ACT_AMT = NULL, STL_TGT_FLG = N, STL_RMK = NULL
	 * 
	 * @category FNS_JOO_0104
	 * @param SettlementTargetVO settlementTargetVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySettlementTargetActAmt(SettlementTargetVO settlementTargetVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementTargetVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalConsultationDBDAOModifySettlementTargetActAmtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Retrieve : Actual Detail Invoice No Combo Item 조회.
	 * 
	 * @category FNS_JOO_0105
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<ActualDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ActualDetailVO> searchInvoiceNoList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActualDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchInvoiceNoListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ActualDetailVO.class);
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
	 * Retrieve : Actual Detail 조회.
	 * 
	 * @category FNS_JOO_0105
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<ActualDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ActualDetailVO> searchActualDetailList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActualDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (consultationConditionVO != null) {
				List<String> itemList = new ArrayList<String>();
				
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//2015.07.10 Modify : Item : ALL을 제외한 S/H, OPR, 그외 Item.
				itemList = BizComJooUtil.getSeperationParameterList(consultationConditionVO.getJoStlItmCds(), ",");
				if(itemList != null && itemList.size() > 0){
					param.put("jo_stl_itm_cds"		, itemList);
					velParam.put("jo_stl_itm_cds"	, itemList);
				}else{
					param.put("jo_stl_itm_cds"		, "");
					velParam.put("jo_stl_itm_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchActualDetailListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ActualDetailVO.class);
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
	 * Retrieve : Invoice Creation 대상 조회.
	 * 
	 * @category FNS_JOO_0102
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvoiceVO> searchInvoiceTargetList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> joCrrList = new ArrayList<String>();
			
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//2015.07.10 Modify : Item : ALL을 제외한 S/H, OPR, 그외 Item.
				joCrrList = BizComJooUtil.getSeperationParameterList(consultationConditionVO.getJoCrrCds(), ",");
				if(joCrrList != null && joCrrList.size() > 0){
					param.put("jo_crr_cds"		, joCrrList);
					velParam.put("jo_crr_cds"	, joCrrList);
				}else{
					param.put("jo_crr_cds"		, "");
					velParam.put("jo_crr_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchInvoiceTargetListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceVO.class);
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
	 * Retrieve : Invoice Creation 대상 Detail 조회.
	 * 
	 * @category FNS_JOO_0102
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvoiceDetailVO> searchInvoiceTargetDetailList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> joCrrList = new ArrayList<String>();
			
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//2015.07.10 Modify : Item : ALL을 제외한 S/H, OPR, 그외 Item.
				joCrrList = BizComJooUtil.getSeperationParameterList(consultationConditionVO.getJoCrrCds(), ",");
				if(joCrrList != null && joCrrList.size() > 0){
					param.put("jo_crr_cds"		, joCrrList);
					velParam.put("jo_crr_cds"	, joCrrList);
				}else{
					param.put("jo_crr_cds"		, "");
					velParam.put("jo_crr_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchInvoiceTargetDetailListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceDetailVO.class);
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
	 * Retrieve : CSR Creation 조회.
	 * 
	 * @category FNS_JOO_0103
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<SlipProcessVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SlipProcessVO> searchCsrCreationList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlipProcessVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> crrList = new ArrayList<String>();
				crrList = BizComJooUtil.getSeperationParameterList(consultationConditionVO.getJoCrrCds(), ",");
				if(crrList != null && crrList.size() > 0){
					param.put("jo_crr_cds"		, crrList);
					velParam.put("jo_crr_cds"	, crrList);
				}else{
					param.put("jo_crr_cds"		, "");
					velParam.put("jo_crr_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchCsrCreationListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SlipProcessVO.class);
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
	 * Update JOO_INVOICE 전표번호.
	 * 
	 * @category FNS_JOO_0103
	 * @param SlipProcessVO slipProcessVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyInvoiceForCsr(SlipProcessVO slipProcessVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = slipProcessVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalConsultationDBDAOModifyInvoiceForCsrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Retrieve : SLIP 대상을 조회
	 * 
	 * @category FNS_JOO_0103
	 * @param SlipProcessVO slipProcessVO
	 * @return List<SlipProcessVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SlipProcessVO> calculateSlipTargetList(SlipProcessVO slipProcessVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlipProcessVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (slipProcessVO != null) {
				Map<String, String> mapVO = slipProcessVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOCalculateSlipTargetListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SlipProcessVO.class);
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
	 * Retrieve : Invoice Delete 대상 조회.
	 * 
	 * @category FNS_JOO_0106
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvoiceVO> searchInvoiceDeleteList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> crrList = new ArrayList<String>();
				crrList = BizComJooUtil.getSeperationParameterList(consultationConditionVO.getJoCrrCds(), ",");
				if(crrList != null && crrList.size() > 0){
					param.put("jo_crr_cds"		, crrList);
					velParam.put("jo_crr_cds"	, crrList);
				}else{
					param.put("jo_crr_cds"		, "");
					velParam.put("jo_crr_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchInvoiceDeleteListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceVO.class);
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
	 * Retrieve : Invoice No Delete 대상의 Settlement Target Update 목록 조회.
	 * 
	 * @category FNS_JOO_0106
	 * @param InvoiceDetailVO invoiceDetailVO
	 * @return List<SettlementTargetVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SettlementTargetVO> searchSettlementTargetListForDelInvoiceNo(InvoiceDetailVO invoiceDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SettlementTargetVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invoiceDetailVO != null) {
				Map<String, String> mapVO = invoiceDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchSettlementTargetListForDelInvoiceNoRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SettlementTargetVO.class);
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
	 * Check : 삭제하는 Invoice에 전표번호  존재 여부 체크.
	 * 
	 * @category FNS_JOO_0106
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String checkExistInvoiceSlipForInvoiceNo(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(consultationConditionVO != null){
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOCheckExistInvoiceSlipForInvoiceNoRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("EXIST_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
	

	
	/**
	 * Retrieve : Invoice에서 삭제 할 Invoice No에 대한 목록 조회.
	 * 
	 * @category FNS_JOO_0106
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvoiceVO> searchInvoiceListForDelInvoiceNo(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchInvoiceListForDelInvoiceNoRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceVO.class);
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
	 * Invoice Detail 삭제.
	 * 
	 * @category FNS_JOO_0106
	 * @param InvoiceDetailVO invoiceDetailVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeInvoiceDetail(InvoiceDetailVO invoiceDetailVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = invoiceDetailVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalConsultationDBDAORemoveInvoiceDetailDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Invoice 삭제.
	 * 
	 * @category FNS_JOO_0106
	 * @param InvoiceVO invoiceVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeInvoice(InvoiceVO invoiceVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = invoiceVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalConsultationDBDAORemoveInvoiceDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * modify : invoice 삭제시 해당 데이타의 금액과 Invoice No 을 Remark에 Update한다.
	 * 
	 * @category FNS_JOO_0106
	 * @param SettlementTargetVO settlementTargetVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySettlementTargetForDelInvoiceNo(SettlementTargetVO settlementTargetVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementTargetVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalConsultationDBDAOModifySettlementTargetForDelInvoiceNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Retrieve : Invoice Inquiry Summary 조회.
	 * 
	 * @category FNS_JOO_0107
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvoiceVO> searchInvoiceReportSummaryList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> crrList = new ArrayList<String>();
				crrList = BizComJooUtil.getSeperationParameterList(consultationConditionVO.getJoCrrCds(), ",");
				if(crrList != null && crrList.size() > 0){
					param.put("jo_crr_cds"		, crrList);
					velParam.put("jo_crr_cds"	, crrList);
				}else{
					param.put("jo_crr_cds"		, "");
					velParam.put("jo_crr_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchInvoiceReportSummaryListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceVO.class);
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
	 * Retrieve : Invoice Inquiry Detail 조회.
	 * 
	 * @category FNS_JOO_0107
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvoiceDetailVO> searchInvoiceReportDetailList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> crrList = new ArrayList<String>();
				crrList = BizComJooUtil.getSeperationParameterList(consultationConditionVO.getJoCrrCds(), ",");
				if(crrList != null && crrList.size() > 0){
					param.put("jo_crr_cds"		, crrList);
					velParam.put("jo_crr_cds"	, crrList);
				}else{
					param.put("jo_crr_cds"		, "");
					velParam.put("jo_crr_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchInvoiceReportDetailListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceDetailVO.class);
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
	 * STL_VVD_SEQ : stl_vvd_seq 조회.
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExistStlVvdSeq(SettlementTargetVO settlementTargetVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(settlementTargetVO != null){
				Map<String, String> mapVO = settlementTargetVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchExistStlVvdSeqRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("STL_VVD_SEQ");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
	
	/**
	 * Retrieve : Summary Settlement Target 조회.
	 * 
	 * @category FNS_JOO_0108
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InvoiceVO> searchSettlementTargetSummaryList(ConsultationConditionVO consultationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			if (consultationConditionVO != null) {
				Map<String, String> mapVO = consultationConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//2015.07.10 Modify : Item : ALL을 제외한 S/H, OPR, 그외 Item.
				itemList = BizComJooUtil.getSeperationParameterList(consultationConditionVO.getJoStlItmCds(), ",");
				if(itemList != null && itemList.size() > 0){
					param.put("jo_stl_itm_cds"		, itemList);
					velParam.put("jo_stl_itm_cds"	, itemList);
				}else{
					param.put("jo_stl_itm_cds"		, "");
					velParam.put("jo_stl_itm_cds"	, "");
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalConsultationDBDAOSearchSettlementTargetSummaryListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


}
