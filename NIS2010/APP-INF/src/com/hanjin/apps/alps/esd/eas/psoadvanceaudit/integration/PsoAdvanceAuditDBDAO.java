/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAO.java
*@FileTitle : Port (Service) Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 2014-12-05 Do-Hyun Kim
* 1.0 최초 생성
* 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청

=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event.EsdEas0301Event;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event.EsdEas0302Event;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditBatchVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditCreSetVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * PsoAdvanceAuditDBDAO PDTO(Data Transfer Object including Parameters)<br>
 * @author Do-Hyun Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class PsoAdvanceAuditDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Port (Service) Charge 조회.<br>
	 * 
	 * @category EDS_EAS_0301
	 * @param EsdEas0301Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchPreAuditList(EsdEas0301Event event) throws DAOException {
		DBRowSet dRs = null;
		log.debug("\n searchPreAuditList chargeType=" + event.getChargeType());
		try{
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("rhq"			, event.getRhq());
			param.put("office"		, event.getOffice());
			param.put("period1"		, event.getPeriod1());
			param.put("period2"		, event.getPeriod2());
			param.put("chargeType"	, event.getChargeType());
			param.put("accountCode"	, event.getAccountCode());
			param.put("costCode"	, event.getCostCode());
			param.put("portCode"	, event.getPortCode());
			param.put("spNo"		, event.getSpNo());
			param.put("auditStatus"	, event.getAuditStatus());
			param.put("contractType", event.getContractType());
			param.put("yardCd"		, event.getYardCd());
			param.put("vesselClass"	, event.getVesselClass());
			param.put("diff"		, event.getDiff());
			param.put("diffNum"		, event.getDiffNum());
			param.put("csr_no"		, event.getCsrNo());
			param.put("inv_no"		, event.getInvNo());
			param.put("if_status"	, event.getIfStatus());
			param.put("vessel"		, event.getVessel());
			param.put("remark"		, event.getRemark());
			param.put("divChargeType"	, event.getDivChargeType());
			param.put("sExpnAudStsCd"	, event.getSExpnAudStsCd());
			param.put("portlChargeType"	, event.getPortlChargeType());
			param.put("serviceChargeType"	, event.getServiceChargeType());
			param.put("canalChargeType"	, event.getCanalChargeType());
			param.put("otherChargeType"	, event.getOtherChargeType());
			
			//invoice no.
			String r_InvNo		= JSPUtil.getNull(event.getInvNo());
			List<String> invNos = new ArrayList<String>();
			if (!r_InvNo.equals("")) {
				String arrInvNo[] = event.getInvNo().split(",");
				for(int i=0;i<arrInvNo.length;i++){   
					invNos.add(arrInvNo[i]);   
				}
			}
			
			param.put("invNos",invNos);
			
			//csr no.
			String r_CsrNo		= JSPUtil.getNull(event.getCsrNo());
			List<String> csrNos = new ArrayList<String>();
			if (!r_CsrNo.equals("")) {
				String arrCsrNo[] = event.getCsrNo().split(",");
				for(int i=0;i<arrCsrNo.length;i++){   
					csrNos.add(arrCsrNo[i]);   
				}
			}
			param.put("csrNos",csrNos);
							
	        dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoAdvanceAuditDBDAOSearchPreAuditListRSQL(), param, param);

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}
	
	/**
	 * Port (Service) Charge 조회.<br>
	 * 
	 * @category EDS_EAS_0301
	 * @param EsdEas0301Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchPreAuditList2(EsdEas0301Event event) throws DAOException {
		DBRowSet dRs = null;
		log.debug("\n searchPreAuditList2 chargeType=" + event.getChargeType());
		
		try{
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("rhq"			, event.getRhq());
			param.put("office"		, event.getOffice());
			param.put("period1"		, event.getPeriod1());
			param.put("period2"		, event.getPeriod2());
			param.put("chargeType"	, event.getChargeType());
			param.put("accountCode"	, event.getAccountCode());
			param.put("costCode"	, event.getCostCode());
			param.put("portCode"	, event.getPortCode());
			param.put("spNo"		, event.getSpNo());
			param.put("auditStatus"	, event.getAuditStatus());
			param.put("contractType", event.getContractType());
			param.put("yardCd"		, event.getYardCd());
			param.put("vesselClass"	, event.getVesselClass());
			param.put("diff"		, event.getDiff());
			param.put("diffNum"		, event.getDiffNum());
			param.put("csr_no"		, event.getCsrNo());
			param.put("inv_no"		, event.getInvNo());
			param.put("if_status"	, event.getIfStatus());
			param.put("vessel"		, event.getVessel());
			param.put("remark"		, event.getRemark());
			param.put("divChargeType"	, event.getDivChargeType());
			param.put("sExpnAudStsCd"	, event.getSExpnAudStsCd());
			param.put("portlChargeType"	, event.getPortlChargeType());
			param.put("serviceChargeType"	, event.getServiceChargeType());
			param.put("canalChargeType"	, event.getCanalChargeType());
			param.put("otherChargeType"	, event.getOtherChargeType());
			
			//invoice no.
			String r_InvNo		= JSPUtil.getNull(event.getInvNo());
			List<String> invNos = new ArrayList<String>();
			if (!r_InvNo.equals("")) {
				String arrInvNo[] = event.getInvNo().split(",");
				for(int i=0;i<arrInvNo.length;i++){   
					invNos.add(arrInvNo[i]);   
				}
			}
			
			param.put("invNos",invNos);
			
			//csr no.
			String r_CsrNo		= JSPUtil.getNull(event.getCsrNo());
			List<String> csrNos = new ArrayList<String>();
			if (!r_CsrNo.equals("")) {
				String arrCsrNo[] = event.getCsrNo().split(",");
				for(int i=0;i<arrCsrNo.length;i++){   
					csrNos.add(arrCsrNo[i]);   
				}
			}
			param.put("csrNos",csrNos);
			
			if( "2".equals(event.getDivChargeType())) {//manaul 일경우 기존 로직
				log.debug("\n 기존로직=====");
		        dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoAdvanceAuditDBDAOSearchPreAuditListRSQL(), param, param);
	
			} else {//auto일 경우 신규로직
				log.debug("\n 신규로직=====");
		        dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoAdvanceAuditDBDAOSearchPreAuditList2RSQL(), param, param);
				
			}
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}

	
	/**
	 * Port (Service) Charge - Confirm - DB에 반영한다.(변경)<br>
	 *
	 * @category EDS_EAS_0301
	 * @param event EsdEas0301Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	public void modifyAutoAuditFlg(EsdEas0301Event event, SignOnUserAccount account) throws DAOException {
		
		try {
			int insCnt = 0;
			PreAuditListVO[] models = event.getPreAuditListVOs();
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("upd_usr_id"	, account.getUsr_id());
    		for(int f=0; models != null && f < models.length; f++) {
    			if (models[f].getSel().length() > 0 || models[f].getAtchFileLnkId() != null) {
    				if (models[f].getSel().equals("1") || models[f].getAtchFileLnkId() != null) {
    					param.put("select_flg"				, models[f].getSelectFlg()); 
    					param.put("iss_cty_cd"				, models[f].getIssCtyCd()); 
    					param.put("so_seq"					, models[f].getSoSeq()); 
    					param.put("so_dtl_seq"				, models[f].getSoDtlSeq());
    					if(!"".equals(models[f].getsSaveTpCd()) && models[f].getsSaveTpCd() != null){
    						param.put("s_save_tp_cd"			, models[f].getsSaveTpCd());
    					}else{
    						param.put("s_save_tp_cd"			, "C");
    					}
    					param.put("port_chg_aud_rslt_rmk"	, models[f].getPortChgAudRsltRmk()); 
    					param.put("atch_file_lnk_id"		, models[f].getAtchFileLnkId()); 
    					param.put("expn_aud_rslt_cd"		, models[f].getExpnAudRsltCd()); 
    					
    					param.put("inv_aud_curr_cd"			, models[f].getInvAudCurrCd()); 
    					param.put("inv_aud_diff_amt"		, models[f].getInvAudDiffAmt()); 
    					param.put("inv_aud_usd_diff_amt"	, models[f].getInvAudUsdDiffAmt()); 

						insCnt =	new SQLExecuter().executeUpdate((ISQLTemplate)new PsoAdvanceAuditDBDAOUpdatePreAuditUSQL(), param, param);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update " + " SQL");						
				    	}
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
	 * Port (Service) Charge에 관련 Account를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param EsdEas0301Event event
	 * @return List<PreAuditListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<PreAuditListVO> searchAuditFlgAccount(EsdEas0301Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreAuditListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("chargeType"	, event.getChargeType());
		param.put("divChargeType"	, event.getDivChargeType());
		param.put("rhq"	, event.getRhq());
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoAdvanceAuditDBDAOSearchAccountRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreAuditListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Port (Service) Charge에 관련 Cost를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param EsdEas0301Event event
	 * @return List<PreAuditListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<PreAuditListVO> searchAuditFlgCost(EsdEas0301Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreAuditListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("chargeType"	, event.getChargeType());
		param.put("divChargeType"	, event.getDivChargeType());
		param.put("rhq"	, event.getRhq());
		param.put("acct_cd"	, event.getAccountCode());
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoAdvanceAuditDBDAOSearchCostRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreAuditListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * S/P No. name 조회.<br>
	 * 
	 * @category EDS_EAS_0301
	 * @param EsdEas0301Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public String searchAuditFlgSpName(EsdEas0301Event event) throws DAOException {
		DBRowSet dRs = null;
		String spName = "";
		
		try{
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("office"		, event.getOffice());
			param.put("spNo"		, event.getSpNo());			
        
	        dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoAdvanceAuditDBDAOSearchspNameRSQL(), param, param);

	        if(dRs != null){
				if(dRs.next()){
					spName = dRs.getString("VNDR_LGL_ENG_NM");
				}
			}
	        
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return spName;
	}
	
	
	/**
	 * Port (Service) Charge에 관련 VesselClass를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param EsdEas0301Event event
	 * @return List<PreAuditListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<PreAuditListVO> searchAuditFlgVslClass(EsdEas0301Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreAuditListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("contractType", event.getContractType());
		param.put("vesselClass"	, event.getVesselClass());
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoAdvanceAuditDBDAOSearchVslClassRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreAuditListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Port (Service) Charge에 관련 VesselClass관련 Vessel를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param EsdEas0301Event event
	 * @return List<PreAuditListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<PreAuditListVO> searchAuditFlgVslClassVessel(EsdEas0301Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreAuditListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("contractType", event.getContractType());
		param.put("vesselClass"	, event.getVesselClass());
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoAdvanceAuditDBDAOSearchVslClassVesselRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreAuditListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
 

	/**
	 * Port (Service) Charge History 조회.<br>
	 * 
	 * @category EDS_EAS_0302
	 * @param EsdEas0302Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchPreAuditHistoryList(EsdEas0302Event event) throws DAOException {
		DBRowSet dRs = null;
		
		try{
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("issCtyCd"	        , event.getIssCtyCd());
//			param.put("soSeq"		        , event.getSoSeq());
//			param.put("soDtlSeq"	        , event.getSoDtlSeq());
			param.put("rhq"			        , event.getRhq());
			param.put("vesselClass"	        , event.getVesselClass());
			param.put("vessel"		        , event.getVessel());
			param.put("period1"		        , event.getPeriod1());
			param.put("period2"		        , event.getPeriod2());
			param.put("country"		        , event.getCountry());
			param.put("portCode"	        , event.getPortCode());
			param.put("yardCd"		        , event.getYardCd());
			param.put("accountCode"	        , event.getAccountCode());
			param.put("costCode"	        , event.getCostCode());
			param.put("vvd"			        , event.getVvd());
			
	        dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoAdvanceAuditDBDAOSearchPreAuditHistoryListRSQL(), param, param);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		} 
		return dRs;
	}
	
	
	 /**
	  * Pre-Audit Criterion setting 내역을 조회한다.<br>
	  * 
	  * @param PreAuditCreSetVO preAuditCreSetVO
	  * @return List<PreAuditCreSetVO>
	  * @exception DAOException
	  */
	 public List<PreAuditCreSetVO> searchPsoConfig(PreAuditCreSetVO preAuditCreSetVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<PreAuditCreSetVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(preAuditCreSetVO != null){
				 Map<String, String> mapVO = preAuditCreSetVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoadvanceauditDBDAOsearchPsoConfigRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreAuditCreSetVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	
	 
	 
	 /**
	  * Pre-Audit Criterion setting 내역을 저장한다.<br>
	  * 
	  * @param PreAuditCreSetVO preAuditCreSetVO
	  * @exception DAOException
	  */
	 public void multiPsoConfig(PreAuditCreSetVO preAuditCreSetVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(preAuditCreSetVO != null){
				 //query parameter
				 Map<String, String> param = preAuditCreSetVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new PsoadvanceauditDBDAOMultiPsoConfigUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
			 }	
			 
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }	
	 
	/***************************************************************************************************************/
	 
	 /**
	  * Pso Invoice Charge  를 저장한다.<br>
	  * 
	  * @param PreAuditBatchVO preAuditBatchVO
	  * @exception DAOException
	  */
	 public void confirmPsoPreAudit(PreAuditBatchVO preAuditBatchVO) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 DBRowSet dbRowset = null;
			 if(preAuditBatchVO != null){
				 //query parameter
				 Map<String, String> mapVO = preAuditBatchVO.getColumnValues();
				 param.putAll(mapVO);

				 //실시간 배치대상에 이미 포함되어 있는지를 검사한다.
				 dbRowset = sqlExe.executeQuery((ISQLTemplate) new PsoAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL() , param, param);
				 String progFlg = "";

				 if(dbRowset.next()){
					 progFlg = dbRowset.getString("prog_flg");
					 if (progFlg.equals("Y")) {
						 throw new DAOException((new ErrorHandler("EAS99999",new String[]{"It is included in the re-batch target."})).getMessage());
					 }
				 }
				 
				 int result = sqlExe.executeUpdate((ISQLTemplate) new PsoAdvanceAuditDBDAOconfirmPsoPreAuditCSQL() , param, param);

				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
			 }	

		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	 
	/**
	 * Pso Invoice Auto Audit 대상을 조회한다.<br>
	 * 
	 * @param PreAuditBatchVO conditionVO
	 * @return List<PreAuditBatchVO>
	 * @exception EventException
	 */
	public List<PreAuditBatchVO> searchPsoAutoAudList(PreAuditBatchVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<PreAuditBatchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		try{
				 Map<String, String> mapVO = conditionVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
//			    if(conditionVO.getSInvNo() != null && conditionVO.getSInvNo().length() > 0) {
			    if(conditionVO.getInvNo() != null && conditionVO.getInvNo().length() > 0) {
					List<String> invNos = new ArrayList<String>();
//					String[] arrInvNo = conditionVO.getSInvNo().split(",");
					String[] arrInvNo = conditionVO.getInvNo().split(",");
					for(int i = 0; i < arrInvNo.length; i++) {
						invNos.add(arrInvNo[i]);
					}
					param.put("invNos", invNos);
					velParam.put("invNos", invNos);
				}

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PsoAdvanceAuditDBDAOsearchPsoAutoAudListRSQL(), param, velParam);
			 
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreAuditBatchVO.class);
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
	  * Audit History를 저장한다.<br>
	  * 
	  * @param PreAuditBatchVO psoPreAudListVO
	  * @exception DAOException
	  */
	 public void addAutoAuditHis(PreAuditBatchVO psoPreAudListVO) throws DAOException {
		 
		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(psoPreAudListVO != null){
				 //query parameter
				 Map<String, String> mapVO = psoPreAudListVO.getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate) new PsoAdvanceAuditDBDAOAddAutoAuditHistoryCSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
			 }	
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	 /**
	  * Auto Audit 내역을 삭제한다.<br>
	  * 
	  * @param PreAuditBatchVO psoPreAudListVO
	  * @exception DAOException
	  */
	 public void removeAutoAudit(PreAuditBatchVO psoPreAudListVO) throws DAOException {
		 
		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(psoPreAudListVO != null){
				 //query parameter
				 Map<String, String> mapVO = psoPreAudListVO.getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate) new PsoAdvanceAuditDBDAORemoveAutoAuditDSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
			 }	
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	 /**
	  * 실시간 배치 대상의 상태코드를 완료로 변경한다.<br>
	  * 
	  * @param PreAuditBatchVO psoPreAudListVO
	  * @exception DAOException
	  */
	 public void updateBatchStatus(PreAuditBatchVO psoPreAudListVO) throws DAOException {
		 
		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(psoPreAudListVO != null){
				 //query parameter
				 Map<String, String> mapVO = psoPreAudListVO.getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate) new PsoAdvanceAuditDBDAOupdateBatchStatusUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
			 }	
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	 /**
	  * 실시간 배치 대상을 저장한다.<br>
	  * 
	  * @param PreAuditBatchVO psoPreAudListVO
	  * @exception DAOException
	  */
	 public void saveReBatchTarget(PreAuditBatchVO psoPreAudListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(psoPreAudListVO != null){
				//query parameter
				Map<String, String> mapVO = psoPreAudListVO.getColumnValues();
				param.putAll(mapVO);

				//실시간 배치대상에 이미 포함되어 있는지를 검사한다.
				dbRowset = sqlExe.executeQuery((ISQLTemplate) new PsoAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL(), param, param);
				String progFlg = "";
				
				if(dbRowset.next()){
					progFlg = dbRowset.getString("prog_flg");
					if (progFlg.equals("Y")) {
						throw new DAOException((new ErrorHandler("EAS99999",new String[]{"It is already included in batch target."})).getMessage());
					}
				}
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new PsoAdvanceAuditDBDAOsaveReBatchTargetCSQL() , param, param);
				if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
			 }	
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
}