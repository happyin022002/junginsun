/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderCCManageDBDAO.java
*@FileTitle : Transportation Report & Code
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 조풍연
*@LastVersion : 1.1
* 2006.11.07 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.12.14  최 선	1.1 [CHM-201007747] W/O CC 상 오류 수정요청
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.basic.WorkOrderCCManageBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.event.EsdTrs0072Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.vo.TrsTrspWrkOrdCcEmlVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.vo.TrsTrspWrkOrdCcFaxVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ESD-WorkOrderManage에 대한 DB 처리를 담당<br>
 * - ESD-WorkOrderManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author poong_yeon
 * @see WorkOrderCCManageBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderCCManageDBDAO extends DBDAOSupport {

	/**
	 * WorkOrderCCManage의 모든 목록을 가져온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchWorkOrderCCManageList(EsdTrs0072Event event) throws DAOException {
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("vndr_seq", event.getComboSvcProvider());     
			param.put("ofc_Cd"	, event.getControlOfficeCd());
			param.put("loc_cd"	, event.getLocationCd());
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderCCManageDBDAOSearchWorkOrderCCManageListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}

	/**
	 * WorkOrderCCManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchWorkOrderCCFaxList(EsdTrs0072Event event) throws DAOException {
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("vndr_seq", event.getSelectedVndrSeq());     
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderCCManageDBDAOSearchWorkOrderCCFaxListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}

	/**
	 * WorkOrderCCManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchWorkOrderCCEmailList(EsdTrs0072Event event) throws DAOException {

		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("vndr_seq", event.getSelectedVndrSeq());     
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new WorkOrderCCManageDBDAOSearchWorkOrderCCEmailListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}

	/**
	 * WorkOrderCCManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @throws DAOException
	 */
	public void multiWorkOrderCCManageList(EsdTrs0072Event event) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
//		DBRowSet rs = null;		
		final String	fax			= "FAX";
		final String	email		= "EMAIL";

		String	faxEmailIndicator	= null;
		String	selectedVndrSeq		= null;
		String	selectedCtrlOfcCd	= null;
		String	selectedLocCd		= null;
		String	loginUserOfcCd		= null;
		String	loginUserId			= null;		

		faxEmailIndicator	= event.getFaxEmailIndicator() == null || "".equals(event.getFaxEmailIndicator()) ? "" : event.getFaxEmailIndicator();
		selectedVndrSeq		= event.getSelectedVndrSeq() == null || "".equals(event.getSelectedVndrSeq()) ? "" : event.getSelectedVndrSeq();
		selectedCtrlOfcCd	= event.getSelectedCtrlOfcCd() == null || "".equals(event.getSelectedCtrlOfcCd()) ? "" : event.getSelectedCtrlOfcCd();
		selectedLocCd		= event.getSelectedLocCd() == null || "".equals(event.getSelectedLocCd()) ? "" : event.getSelectedLocCd();
		loginUserOfcCd		= event.getLoginUserOfcCd() == null || "".equals(event.getLoginUserOfcCd())	? "" : event.getLoginUserOfcCd();
		loginUserId			= event.getLoginUserId() == null || "".equals(event.getLoginUserId()) ? "" : event.getLoginUserId();
		
		try {
			
			param.put("vndr_seq"	, selectedVndrSeq);			/* VNDR_SEQ      				*/
			param.put("wo_cc_ofc_cd", selectedCtrlOfcCd);		/* WO_CC_OFC_CD      			*/
			param.put("vndr_loc_cd"	, selectedLocCd);			/* VNDR_LOC_CD      			*/
			param.put("cre_ofc_cd"	, loginUserOfcCd);			/* CRE_OFC_CD      				*/
			param.put("cre_usr_id"	, loginUserId);				/* CRE_USR_ID     				*/
			param.put("upd_usr_id"	, loginUserId);				/* UPD_USR_ID      				*/
			
			int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderCCManageDBDAOSaveCCMstUSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
			
			if(fax.equals(faxEmailIndicator)){
				multiWorkOrderCCFaxList(event);
			}
			
			if(email.equals(faxEmailIndicator)){
				multiWorkOrderCCEmlList(event);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}
	
	/**
	 * WorkOrderCCManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 삭제, 수정)<br>
	 *
	 * @param event
	 * @throws DAOException
	 */
	public void multiWorkOrderCCFaxList(EsdTrs0072Event event) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
//		DBRowSet dRs = null;		

		String	selectedVndrSeq		= null;
		String	loginUserId			= null;		

		selectedVndrSeq		= event.getSelectedVndrSeq() == null || "".equals(event.getSelectedVndrSeq()) ? "" : event.getSelectedVndrSeq();
		loginUserId			= event.getLoginUserId() == null || "".equals(event.getLoginUserId()) ? "" : event.getLoginUserId();
		
		try {
			
			String trsChk 		= "";
//			String currFaxNo 	= "";

			int insCnt = 0; 
			int updCnt = 0; 
//			int delCnt = 0; 
			int i = 0;
			
			param.put("vndr_seq", selectedVndrSeq);
			param.put("cre_usr_id"	, loginUserId);				/* CRE_USR_ID     				*/
			param.put("upd_usr_id"	, loginUserId);				/* UPD_USR_ID      				*/
			
			TrsTrspWrkOrdCcFaxVO[]	models	= event.getTrsTrspWrkOrdCcFaxs();
			TrsTrspWrkOrdCcFaxVO	model	= null;
			
			// INSERT/UPDATE 전 해당 VENDOR 내역 삭제
			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderCCManageDBDAODeleteFaxDSQL(), param, param);
			
			for(i=0; models != null && i<models.length; i++){		
				
				model 	= models[i];			
				trsChk 	= model.getTrsChk();

				param.put("wo_fax_no", model.getWoFaxNo());
				
				if ("1".equals(trsChk)) {
					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderCCManageDBDAOInsertFaxCSQL(), param, param);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");
					}
				}
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}
	
	/**
	 * WorkOrderCCManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @throws DAOException
	 */
	public void multiWorkOrderCCEmlList(EsdTrs0072Event event) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
//		DBRowSet dRs = null;		

		String	selectedVndrSeq	= null;
		String	loginUserId		= null;		
		selectedVndrSeq			= event.getSelectedVndrSeq() == null || "".equals(event.getSelectedVndrSeq()) ? "" : event.getSelectedVndrSeq();
		loginUserId				= event.getLoginUserId() == null || "".equals(event.getLoginUserId()) ? "" : event.getLoginUserId();
		
		try {
			
			String trsChk 		= "";
//			String currEmlNo 	= "";

			int insCnt = 0; 
			int updCnt = 0; 
//			int delCnt = 0; 
			int i = 0;
			
			param.put("vndr_seq"	, selectedVndrSeq);
			param.put("cre_usr_id"	, loginUserId);				/* CRE_USR_ID     				*/
			param.put("upd_usr_id"	, loginUserId);				/* UPD_USR_ID      				*/
			
			TrsTrspWrkOrdCcEmlVO[]	models	= event.getTrsTrspWrkOrdCcEmls();
			TrsTrspWrkOrdCcEmlVO	model	= null;
			
			// INSERT/UPDATE 전 해당 VENDOR 내역 삭제
			updCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderCCManageDBDAODeleteEmlDSQL(), param, param);
			
			for(i=0; models !=null &&  i<models.length; i++){	
				
				model 	= models[i];			
				trsChk 	= model.getTrsChk();
				
				param.put("wo_eml", model.getWoEml());
				
				if ("1".equals(trsChk)) {
					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new WorkOrderCCManageDBDAOInsertEmlCSQL(), param, param);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}	
}
