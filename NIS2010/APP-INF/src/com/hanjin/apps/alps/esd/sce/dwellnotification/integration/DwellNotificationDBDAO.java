/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LaneServiceDBDAO.java
 *@FileTitle : LaneServiceDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.07.15
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2010.07.15 함대성
 * 1.0 Creation
===============================================================================================
* History
* 2011.12.28 전준영 [CHM-201115163] E-mailing Service List for Dwell/Delay Notification상에 조회 Column 추가요건반영
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0140Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0146Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0150Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0152Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0154Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0160Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellNofifySendStsVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellNotifyLMTDateVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwllNtfcSrchVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DewllNotifiySetupExpContainerVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchDwellReasonByVVDVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchDwellVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellRnsVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchOneTimeSndHistVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchMSExptVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchMSExptSaveVO;
import com.hanjin.syscommon.common.table.SceDwllCustSvcListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010-LaneServiceDBDAO<br>
 * - NIS2010-CustomerScheduleEdi에 대한 Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HAM DAE SUNG
 * @see
 * @since J2EE 1.4
 */
public class DwellNotificationDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Dwell Type별 목록 조회 <br>
	 * 
	 * @param event EsdSce01410vent
	 * @return eventResponse EventResponse
	 * @throws DAOException
	 */
	public EventResponse searchDwellList(EsdSce0140Event event) throws DAOException {
			
		//GeneralEventResponse eventResponse = new GeneralEventResponse();
		EventResponse eventResponse = new GeneralEventResponse();
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = new DBRowSet();
		StringTokenizer st = null;
		try {
				SearchDwellVO searchDwellVO = event.getSearchDwellVO();
				ArrayList<String> scNoArr = new ArrayList<String>(); 
				param.putAll(searchDwellVO.getColumnValues());	
				log.debug ("==sc==" + searchDwellVO.getColumnValues());
			    if( !"".equals(searchDwellVO.getScNo2())){
					param.put("sc_no", searchDwellVO.getScNo()+searchDwellVO.getScNo2());
				}else{
					String sc_no = searchDwellVO.getScNo();
					int i = 0;
					st = new StringTokenizer(sc_no, ",");
					while( st.hasMoreTokens() ) {
						scNoArr.add(i++,st.nextToken());
					}
					param.put("scNoArr", scNoArr);
					param.put("sc_no", "");					
				}

				param.put("search_dt", (searchDwellVO.getSearchDt()).replaceAll("-", ""));
//				param.put("rail_so_flg", event.getRail_so_flg());
				dRs = new SQLExecuter("DEFAULT").executeQuery(new DwellNotificationDBDAOSearchDwellRSQL(), param,param);
				eventResponse.setRs(dRs);	

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * DWELL REASON 의 입력 내역을 조회 <br>
	 * 
	 * @param event EsdSce01410vent
	 * @return eventResponse EventResponse
	 * @throws DAOException
	 */
	public EventResponse searchDwellResonByVVD(EsdSce0140Event event) throws DAOException {
			
		//GeneralEventResponse eventResponse = new GeneralEventResponse();
		EventResponse eventResponse = new GeneralEventResponse();
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = new DBRowSet();
		try {
				param.put("fr_eta_dt", (event.getFr_eta_dt()).replaceAll("-", ""));
				param.put("to_eta_dt", (event.getTo_eta_dt()).replaceAll("-", ""));
				param.put("vvd_cd", event.getVvd_cd());
				param.put("port_cd", event.getPort_cd());
				
				dRs = new SQLExecuter("DEFAULT").executeQuery(new DwellNotificationDBDAOSearchDwellReasonByVVDRSQL(), param,param);
				eventResponse.setRs(dRs);	

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * DWELL REASON의 E-mailing 내역을 조회 <br>
	 * 
	 * @param event EsdSce01410vent
	 * @return eventResponse EventResponse
	 * @throws DAOException
	 */
	public EventResponse searchDwellEmailList(EsdSce0140Event event) throws DAOException {
			
		//GeneralEventResponse eventResponse = new GeneralEventResponse();
		EventResponse eventResponse = new GeneralEventResponse();
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = new DBRowSet();
		try {
				param.put("eml_snd_dt", (event.getEml_snd_dt()));
				param.put("sc_no", event.getSc_no());
				param.put("dwll_tm_tp_cd", event.getDwll_tm_tp_cd());
				param.put("eml_addr", event.getEml_addr());
				param.put("cntr_no", event.getCntr_no());
				param.put("cust_cd", event.getCust_cd());
				
				dRs = new SQLExecuter("DEFAULT").executeQuery(new DwellNotificationDBDAOSearchDwellEmailListRSQL(), param,param);
				eventResponse.setRs(dRs);	

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * DWELL REASON 의 입력 내역을 입력 또는 수정 <br>
	 * 
	 * @param event EsdSce01410vent
	 * @throws DAOException
	 */
	public void updateDwellResonByVVD(EsdSce0140Event event) throws DAOException {
			
		Map<String, Object> param = new HashMap<String, Object>();
		List<SearchDwellReasonByVVDVO> dwllUpdList = new ArrayList<SearchDwellReasonByVVDVO>();
		List<SearchDwellReasonByVVDVO> dwllInsList = new ArrayList<SearchDwellReasonByVVDVO>();
		try {
			SearchDwellReasonByVVDVO[] dwllArray = event.getDwellRsnByVvdVOs(); 
			for(int i=0; i<dwllArray.length; i++){
				if( "".equals(dwllArray[i].getDwllRsnSeq()) || dwllArray[i].getDwllRsnSeq() == null ){
					dwllInsList.add(dwllArray[i]);
				}else{
					dwllUpdList.add(dwllArray[i]);
				}

			}
			if( dwllInsList.size()>0){
				int insCnt[] = null;			
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new DwellNotificationDBDAOUpdateDwellResonByVVDCSQL(),dwllInsList, param,param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}	
			}
			if( dwllUpdList.size()>0){
				int updCnt[] = null;
				updCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new DwellNotificationDBDAOUpdateDwellResonByVVDUSQL(),dwllUpdList, param,param);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
	}
	
	/**
	 * Dwell Type별 Total Count 값 조회 <br>
	 * 
	 * @param event EsdSce0140Event
	 * @return eventResponse EventResponse
	 * @throws DAOException
	 */
	public EventResponse searchDwellTotalCnt(EsdSce0140Event event) throws DAOException {
			
		//GeneralEventResponse eventResponse = new GeneralEventResponse();
		EventResponse eventResponse = new GeneralEventResponse();
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = new DBRowSet();	
		StringTokenizer st = null;
		try {
			
			SearchDwellVO searchDwellVO = event.getSearchDwellVO();
			ArrayList<String> scNoArr = new ArrayList<String>(); 
			param.putAll(searchDwellVO.getColumnValues());		

			if( !"".equals(searchDwellVO.getScNo2())){
				param.put("sc_no", searchDwellVO.getScNo()+searchDwellVO.getScNo2());
			}else{
				String sc_no = searchDwellVO.getScNo();
				int i = 0;
				st = new StringTokenizer(sc_no, ",");
				while( st.hasMoreTokens() ) {
					scNoArr.add(i++,st.nextToken());
				}
				param.put("scNoArr", scNoArr);
				param.put("sc_no", "");					
			}
			param.put("search_dt", (searchDwellVO.getSearchDt()).replaceAll("-", ""));
			dRs = new SQLExecuter("DEFAULT").executeQuery(new DwellNotificationDBDAOSearchDwellTotalCntRSQL(), param,param);
			eventResponse.setRs(dRs);	

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * Microsoft Exception List 값 조회 <br>
	 * 
	 * @param event EsdSce0146Event
	 * @return eventResponse EventResponse
	 * @throws DAOException
	 */
	public EventResponse searchMSExptList(EsdSce0146Event event) throws DAOException {
			
		//GeneralEventResponse eventResponse = new GeneralEventResponse();
		EventResponse eventResponse = new GeneralEventResponse();
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = new DBRowSet();	
	
		try {
			
			SearchMSExptVO searchMSExptVO = event.getSearchMSExptVO(); 
			param.putAll(searchMSExptVO.getColumnValues());
			
			//bkg_no MULTI 처리
			if (param.get("bl_no_") != null
					&& !((String) param.get("bl_no_")).trim().equals("")) {
				param.put("bl_no_", ((String) param.get("bl_no_")).toUpperCase()
						.split(","));
			}
			
			//cntr_no MULTI 처리
			if (param.get("cntr_no_") != null
					&& !((String) param.get("cntr_no_")).trim().equals("")) {
				param.put("cntr_no_", ((String) param.get("cntr_no_")).toUpperCase()
						.split(","));
			}
			
			//VVD MULTI 처리
			if (param.get("vvd_") != null
					&& !((String) param.get("vvd_")).trim().equals("")) {
				param.put("vvd_", ((String) param.get("vvd_")).toUpperCase()
						.split(","));
			} 

			dRs = new SQLExecuter("DEFAULT").executeQuery(new DwellNotificationDBDAOSearchMSExptRSQL(), param, param);
			eventResponse.setRs(dRs);	

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * Microsoft Exception List 값 저장 <br>
	 * 
	 * @param SearchMSExptSaveVO searchMSExptSaveVO
	 * @return eventResponse EventResponse
	 * @throws DAOException
	 */
	public EventResponse modifyMSExptList(SearchMSExptSaveVO searchMSExptSaveVO) throws DAOException {
			
		//GeneralEventResponse eventResponse = new GeneralEventResponse();
		EventResponse eventResponse = new GeneralEventResponse();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
		try {

			if(searchMSExptSaveVO != null){
				Map<String, String> mapVO = searchMSExptSaveVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDAOInsertMSExptListCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
			throw new DAOException("Fail to insert No SQL");	

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * Email List 조회.<br>
	 * 
	 * @param EsdSce0154Event event
	 * @return List<DwllNtfcSrchVO>
	 * @exception DAOException
	 */
	public List<DwllNtfcSrchVO> searchDwllNtfcSvcList(EsdSce0154Event event) throws DAOException {
		DBRowSet dbRowset = null;
		List<DwllNtfcSrchVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DwllNtfcSrchVO dwllVO = event.getDwllNtfcSrchVO();
		
		try{
			if(dwllVO != null){
				Map<String, String> mapVO = dwllVO .getColumnValues();
				mapVO.put("sc_head_cnt", dwllVO.getScpfxcdlist().size() + "");
				mapVO.put("cust_cnt_cd", event.getCustCntCd());
				mapVO.put("cust_seq", event.getCustSeq());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("scpfxcdArr", dwllVO.getScpfxcdlist());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwllNtfcSvcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DwllNtfcSrchVO .class);
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
		 * Email List 조회(단건, Row Add일 경우)<br>
		 * 
		 * @param DwllNtfcSrchVO dwllVO
		 * @return DwllNtfcSrchVO
		 * @exception DAOException
		 */
		public DwllNtfcSrchVO searchDwllNtfcSvcItem(DwllNtfcSrchVO dwllVO) throws DAOException {
			DBRowSet dbRowset = null;
			
			DwllNtfcSrchVO returnvo = new DwllNtfcSrchVO();
			String redata[] = new String[10];
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwllNtfcSvcItemRSQL(), param, velParam);
				if (dbRowset.next()){
					redata[0] = JSPUtil.getNull(dbRowset.getString("CTRT_PTY_NM"),"");
					redata[1] = JSPUtil.getNull(dbRowset.getString("prop_mqc_qty"),"");
					redata[2] = JSPUtil.getNull(dbRowset.getString("unit_nm"),"");
					redata[3] = JSPUtil.getNull(dbRowset.getString("prop_ofc_cd"),"");
					redata[4] = JSPUtil.getNull(dbRowset.getString("eff_dt"),"");
					redata[5] = JSPUtil.getNull(dbRowset.getString("exp_dt"),"");
					redata[6] = JSPUtil.getNull(dbRowset.getString("EMAIL_LIST_CNT"),"");
					redata[7] = JSPUtil.getNull(dbRowset.getString("DWLL_EXPT_RMK"),"");
					redata[8] = JSPUtil.getNull(dbRowset.getString("CUST_CD"),"");
					redata[9] = JSPUtil.getNull(dbRowset.getString("SC_NO"),"");
				}else{
					redata[0] = "";
					redata[1] = "";
					redata[2] = "";
					redata[3] = "";
					redata[4] = "";
					redata[5] = "";
					redata[6] = "";
					redata[7] = "";
					redata[8] = "";
					redata[9] = "";
				}
				returnvo.setResultStrArray(redata);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return returnvo;
		}
		 
		 
		 /**
			 * Dwell Notification Exception List 저장 <br>
			 * 
			 * @param List<DwllNtfcSrchVO> insertVoList
			 * @exception DAOException
			 */
			public void addDwllNtfcExptForSvc(List<DwllNtfcSrchVO> insertVoList) throws DAOException{
				int updCnt[] = null;
				try {
					SQLExecuter sqlExe = new SQLExecuter("");
					if(insertVoList.size() > 0){
						updCnt = sqlExe.executeBatch((ISQLTemplate)new DwellNotificationDBDAOAddDwllNtfcExptForSvcCSQL(), insertVoList,null);
						for(int i = 0; i < updCnt.length; i++){
							if(updCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}
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
			 * email 삭제 <br>
			 * 
			 * @param List<DwllNtfcSrchVO> deleteVoList
			 * @exception DAOException
			 */
			public void deleteDwllNtfcExptForSvc(List<DwllNtfcSrchVO> deleteVoList) throws DAOException{
				int updCnt[] = null;
				try {
					SQLExecuter sqlExe = new SQLExecuter("");
					if(deleteVoList.size() > 0){
						updCnt = sqlExe.executeBatch((ISQLTemplate)new DwellNotificationDBDAODeleteDwllNtfcExptDSQL(), deleteVoList,null);
						for(int i = 0; i < updCnt.length; i++){
							if(updCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}
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
		 * [Email] 정보를 [조회] 합니다.<br>
		 * 
		 * @param DwllNtfcSrchVO dwllVO
		 * @return List<searchDwllNtfcSvcList>
		 * @exception DAOException
		 */
		public List<DwllNtfcSrchVO> searchDwllNtfcSvcPopUpList(DwllNtfcSrchVO dwllVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<DwllNtfcSrchVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwllNtfcSvcPopUpListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, DwllNtfcSrchVO .class);
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
		 * EMAIL정보가 중복 체크를 합니다.<br>
		 * 
		 * @param String custcd
		 * @param String subsceml
		 * @param String ntfcseq
		 * @return DwllNtfcSrchVO
		 * @exception DAOException
		 */
		public DwllNtfcSrchVO searchDwllNtfcSvcListDtl(String custcd, String subsceml , String ntfcseq) throws DAOException {
			DBRowSet dbRowset = null;
			
			DwllNtfcSrchVO returnvo = new DwllNtfcSrchVO();
			String redata[] = new String[2];
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("cust_cd",custcd);
				param.put("ntfc_seq", ntfcseq);
				param.put("subsc_eml", subsceml);
				
				velParam.put("cust_cd",custcd);
				velParam.put("ntfc_seq", ntfcseq);
				velParam.put("subsc_eml", subsceml);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDADAOSearchDwllNtfcSvcListDtlRSQL(), param, velParam);
				if (dbRowset.next()){
					redata[0] = JSPUtil.getNull(dbRowset.getString("ERR_CHK"),"");
					redata[1] = JSPUtil.getNull(dbRowset.getString("NTFC_SEQ"),"");
				}else{
					redata[0] = "";
					redata[1] = "";
				
				}
				returnvo.setResultStrArray(redata);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return returnvo;
		}

		 /**
		 * email 저장 <br>
		 * 
		 * @param DwllNtfcSrchVO dwllNtfcSrchVO
		 * @exception DAOException
		 */
		public void insertDwllNtfcSvcListDtl(DwllNtfcSrchVO dwllNtfcSrchVO) throws DAOException {
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(dwllNtfcSrchVO != null){
					Map<String, String> mapVO = dwllNtfcSrchVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDADAOInsertDwllNtfcSvcListDtlCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		 /**
		 * email 저장 <br>
		 * 
		 * @param DwllNtfcSrchVO dwllNtfcSrchVO
		 * @exception DAOException
		 */
		public void updateDwllNtfcSvcListDtl(DwllNtfcSrchVO dwllNtfcSrchVO) throws DAOException {
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(dwllNtfcSrchVO != null){
					Map<String, String> mapVO = dwllNtfcSrchVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDADAOUpdateDwllNtfcSvcListDtlUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}

		 /**
		 * email Detail List 저장 <br>
		 * 
		 * @param DwllNtfcSrchVO dwllNtfcSrchVO
		 * @exception DAOException
		 */
		public void modifyDwllNtfcSvcListDtl(DwllNtfcSrchVO dwllNtfcSrchVO) throws DAOException {
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(dwllNtfcSrchVO != null){
					Map<String, String> mapVO = dwllNtfcSrchVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDADAOModifyDwllNtfcSvcListDtlUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}

		/**
		 * E-mail Sending Exception List 조회.<br>
		 * 
		 * @param DwllNtfcSrchVO dwllVO
		 * @return List<DwllNtfcSrchVO>
		 * @exception DAOException
		 */
		public List<DwllNtfcSrchVO> searchDwllNtfcExptList(DwllNtfcSrchVO dwllVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<DwllNtfcSrchVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO .getColumnValues();
					velParam.put("scpfxcdArr", dwllVO.getScpfxcdlist());
					velParam.put("cust_cnt_cd", dwllVO.getCustCntCd());
					velParam.put("cust_seq", dwllVO.getCustSeq());
					velParam.put("f_expt_flg", dwllVO.getFExptFlg());
					velParam.put("ctrt_eff_dt1" , dwllVO.getCtrteffdt().replace("-", ""));
					velParam.put("ctrt_exp_dt1", dwllVO.getCtrtexpdt().replace("-", ""));
					param.put("ctrt_eff_dt1" , dwllVO.getCtrteffdt().replace("-", ""));
					param.put("ctrt_exp_dt1", dwllVO.getCtrtexpdt().replace("-", ""));
					param.put("ofc_cd", dwllVO.getOfcCd());
					param.put("scust_cnt_cd", dwllVO.getIbflag());
					param.put("cust_cnt_cd", dwllVO.getCustCntCd());
					param.put("cust_seq", dwllVO.getCustSeq());
					param.put("f_expt_flg", dwllVO.getFExptFlg());
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwllNtfcExptListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DwllNtfcSrchVO .class);
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
		 * E-mail Sending Exception List 저장을 한다. <br>
		 * 
		 * @param List<DwllNtfcSrchVO> insModels
		 * @exception DAOException
		 */
		public void addDwllNtfcExpt(List<DwllNtfcSrchVO> insModels) throws DAOException {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(insModels.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new DwellNotificationDBDAOAddDwllNtfcExptCSQL(), insModels,null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
		 * E-mail Sending Exception List 삭제한다. <br>
		 * 
		 * @param List<DwllNtfcSrchVO> insModels
		 * @exception DAOException
		 */
		public void deleteDwllNtfcExpt(List<DwllNtfcSrchVO> insModels) throws DAOException {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(insModels.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new DwellNotificationDBDAODeleteDwllNtfcExptDSQL(), insModels,null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
		 * E-mail Sending Exception History 저장을 한다. <br>
		 * 
		 * @param List<DwllNtfcSrchVO> insModels
		 * @exception DAOException
		 */
		public void addDwllNtfcExptHistory(List<DwllNtfcSrchVO> insModels) throws DAOException {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(insModels.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new DwellNotificationDBDAOAddDwllNtfcExptHistoryCSQL(), insModels,null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
		 * Dwell Type별 E-Mail로 발송된 CNTR 개수를 조회 <br>
		 * 
		 * @param event EsdSce0150vent
		 * @return List<DwellNofifySendStsVO>
		 * @throws DAOException
		 */
		public List<DwellNofifySendStsVO> searchDwellNofifySendSts(EsdSce0150Event event) throws DAOException {
				
			List<DwellNofifySendStsVO> list = null;
			DBRowSet dbRowset = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			try {
				
				param.put("start_dt", (event.getStartDt()).replaceAll("-", ""));				
				param.put("end_dt", (event.getEndDt()).replaceAll("-", ""));	
				param.put("sc_no", event.getScNo());
				param.put("sc_no2", event.getScNo2());
				param.put("cust_cnt_cd", event.getCustCntCd());
				param.put("cust_seq", event.getCustSeq());
				velParam.put("scpfxArr", event.getScpfxArr());
				velParam.put("sc_no2", event.getScNo2());
				velParam.put("cust_cnt_cd", event.getCustCntCd());
				velParam.put("cust_seq", event.getCustSeq());
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOsearchDwellNofifySendStsRSQL(), param, velParam);
				
//				dbRowset = new SQLExecuter("").executeQuery(
//						(ISQLTemplate) new DwellNotificationDBDAOsearchDwellNofifySendStsRSQL(), param, velParam);
								
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DwellNofifySendStsVO. class);	
				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ee) {
				log.error(ee.getMessage(), ee);
				throw new DAOException(ee.getMessage());
			} 
			
			return list;
		}		
		
		/**
		 * Dwell Type별 E-Mail로 발송된 CNTR 개수를 Customer Code별 조회 <br>
		 * 
		 * @param event EsdSce0152vent
		 * @return List<DwellNofifySendStsVO>
		 * @throws DAOException
		 */
		public List<DwellNofifySendStsVO> searchDwellNofifySendStsDtl(EsdSce0152Event event) throws DAOException {
				
			List<DwellNofifySendStsVO> list = null;
			DBRowSet dbRowset = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			try {
				
				param.put("start_dt", (event.getStartDt()).replaceAll("-", ""));				
				param.put("end_dt", (event.getEndDt()).replaceAll("-", ""));	
				param.put("sc_no", event.getScNo());
				param.put("cust_cd", event.getCustCd());

				velParam.put("sc_no", event.getScNo2());
				velParam.put("cust_cd", event.getCustCd());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOsearchDwellNofifySendStsDtlRSQL(), param, velParam);				
							
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DwellNofifySendStsVO. class);	
				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ee) {
				log.error(ee.getMessage(), ee);
				throw new DAOException(ee.getMessage());
			} 
			
			return list;
		}
		
		/**
		 * Dwell Notification은 USNYC기준으로 화면 표시하도록 처리된다.
		 * 이에 대응해서 화면 처리가 되도록 정보를 제공
		 * @return DwellNotifyLMTDateVO
		 * @throws EventException
		 */
		public DwellNotifyLMTDateVO searchDwellNotifyLMTDate() throws DAOException {
			DwellNotifyLMTDateVO lmtDate = new DwellNotifyLMTDateVO();
			Map<String, Object> param = new HashMap<String, Object>();
			try {
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwellNotifyLMTDateRSQL(), param, param);
				if (dbRowset.getRowCount() > 0) {
					dbRowset.next();
					lmtDate.setDfltEmlSndDt(dbRowset.getString("DFLT_EML_SND_DT"));
					lmtDate.setDfltFmSndDt(dbRowset.getString("DFLT_FM_SND_DT"));
					lmtDate.setDfltToSndDt(dbRowset.getString("DFLT_TO_SND_DT"));
				}
				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ee) {
				log.error(ee.getMessage(), ee);
				throw new DAOException(ee.getMessage());
			} 
			return lmtDate;
		}
		/**
		 * Set up for Exception by Container List 조회.<br>
		 * 
		 * @param DewllNotifiySetupExpContainerVO dwllVO
		 * @return List<DewllNotifiySetupExpContainerVO>
		 * @exception DAOException
		 */
		public List<DewllNotifiySetupExpContainerVO> searchDwllNtfcExptCntList(DewllNotifiySetupExpContainerVO dwllVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<DewllNotifiySetupExpContainerVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwllNtfcExptCntListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DewllNotifiySetupExpContainerVO .class);
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
		 * Set up for Exception by Container List 조회.<br>
		 * 
		 * @param String cntr_no
		 * @return String[]
		 * @exception DAOException
		 */
		public String[] addDwllNtfcExptCntCtmMov(String cntr_no) throws DAOException {
			DBRowSet dbRowset = null;
			String[] cntrMov = new String[4];
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("cntr_no", cntr_no);				
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOAddDwllNtfcExptCntCtmMovRSQL(), param, velParam);
				if (dbRowset.getRowCount() > 0) {
					dbRowset.next();
					cntrMov[0]=  dbRowset.getString("CNTR_NO");
					cntrMov[1]=  dbRowset.getString("CNMV_YR");
					cntrMov[2]=  dbRowset.getString("CNMV_ID_NO");
					cntrMov[3]=  dbRowset.getString("CNMV_CYC_NO");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return cntrMov;
		}
		 /**
		 * Set up for Exception by Container List 저장을 한다. <br>
		 * 
		 * @param DewllNotifiySetupExpContainerVO dwllVO
		 * @exception DAOException
		 */
		public void addDwllNtfcExptCnt(DewllNotifiySetupExpContainerVO dwllVO) throws DAOException {
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDAOAddDwllNtfcExptCntCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
				
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
		}
		 /**
		 * [Master Bkg의 단건에 대한 조회]<br>
		 * 
		 * @param DewllNotifiySetupExpContainerVO dwllVO
		 * @return DewllNotifiySetupExpContainerVO
		 * @exception DAOException
		 */
		public DewllNotifiySetupExpContainerVO searchDwllNtfcExptCntMastBkg(DewllNotifiySetupExpContainerVO dwllVO) throws DAOException {
			DBRowSet dbRowset = null;
			DBRowSet dbRowset1 = null;
			
			DewllNotifiySetupExpContainerVO returnvo = new DewllNotifiySetupExpContainerVO();
			String reData = "";
			int keyCnt = 0;
			String msg = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwllNtfcExptCntMastBkgRSQL(), param, velParam);
				if (dbRowset.next()){
					reData = JSPUtil.getNull(dbRowset.getString("BKG_NO"),"");
					
				}
				
				if(dwllVO != null){
					dwllVO.setMstBkgNo(reData);
					Map<String, String> mapVO = dwllVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
				dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwllNtfcExptCntDupRSQL(), param, velParam);
				if (dbRowset1.next()){
					keyCnt = dbRowset1.getInt("cnt");
					if (keyCnt > 0 ){
						msg = "Error";
					}
					
				}
				returnvo.setMstBkgNo(reData);
				returnvo.setRow(dwllVO!=null?dwllVO.getRow():null);
				returnvo.setMsg(msg);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return returnvo;
		}

		 /**
		 * Set up for Exception by Container List history 저장 <br>
		 * 
		 * @param DewllNotifiySetupExpContainerVO dwllVO
		 * @exception DAOException
		 */
		public void addDwllNtfcExptCntHistory(DewllNotifiySetupExpContainerVO dwllVO) throws DAOException{
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDAOAddDwllNtfcExptCntHistoryCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
		}

		 /**
		 * Set up for Exception by Container List 삭제 저장 <br>
		 * 
		 * @param DewllNotifiySetupExpContainerVO dwllVO
		 * @exception DAOException
		 */
		public void modifyDwllNtfcExptCnt(DewllNotifiySetupExpContainerVO dwllVO) throws DAOException {
			
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDAOModifyDwllNtfcExptCntUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}	
		
		/**
		 * Customer Type Code 조회.<br>
		 * @param String custCd
		 * @return DBRowSet
		 * @throws EventException
		 */
		public DBRowSet searchRvisCntrCustTpCd(String custCd) throws DAOException {
			DBRowSet dbRowset = null; 
			Map<String, Object> param = new HashMap<String, Object>();//parameter	
				try {
					if(custCd != null){
						param.put("cust_cd"    ,custCd);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchRvisCntrCustTpCdRSQL(), param, null);
				} catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());			
				} catch(Exception ex){
					log.error(ex.getMessage(),ex);			
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}

				return dbRowset;
		}
		
		/**
		 * 해당 SC No를 조회한다.<br>
		 * @param String custCd
		 * @return DBRowSet
		 * @throws EventException
		 */
		public DBRowSet searchScNoInfo(String custCd) throws DAOException {
			DBRowSet dbRowset = null; 
			Map<String, Object> param = new HashMap<String, Object>();//parameter	
				try {
					if(custCd != null){
						param.put("cust_cd"    ,custCd);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchScNoInfoRSQL(), param, null);
				} catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());			
				} catch(Exception ex){
					log.error(ex.getMessage(),ex);			
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}

				return dbRowset;
		}
		
		/**
		 * Candidate Inquiry by Dwell Type별 목록 조회 <br>
		 * 
		 * @param event EsdSce0160vent
		 * @return eventResponse EventResponse
		 * @throws DAOException
		 */
		public EventResponse searchDwellCandidateList(EsdSce0160Event event) throws DAOException {
				
			//GeneralEventResponse eventResponse = new GeneralEventResponse();
			EventResponse eventResponse = new GeneralEventResponse();
			Map<String, Object> param = new HashMap<String, Object>();
			DBRowSet dRs = new DBRowSet();
			StringTokenizer st = null;
			try {
					SearchDwellVO searchDwellVO = event.getSearchDwellVO();
					ArrayList<String> scNoArr = new ArrayList<String>(); 
					param.putAll(searchDwellVO.getColumnValues());		
					
					if( !"".equals(searchDwellVO.getScNo2())){
						param.put("sc_no", searchDwellVO.getScNo()+searchDwellVO.getScNo2());
					}else{
						String sc_no = searchDwellVO.getScNo();
						int i = 0;
						st = new StringTokenizer(sc_no, ",");
						while( st.hasMoreTokens() ) {
							scNoArr.add(i++,st.nextToken());
						}
						param.put("scNoArr", scNoArr);
						param.put("sc_no", "");					
					}

					param.put("search_dt", (searchDwellVO.getSearchDt()).replaceAll("-", ""));
//					param.put("rail_so_flg", event.getRail_so_flg());
					dRs = new SQLExecuter("DEFAULT").executeQuery(new DwellNotificationDBDAOSearchDwellCandidateListRSQL(), param,param);
					eventResponse.setRs(dRs);	

				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ee) {
				log.error(ee.getMessage(), ee);
				throw new DAOException(ee.getMessage());
			} 
			
			return eventResponse;
		}
		/**
		 * Set up for Exception by Container List 조회.<br>
		 * 
		 * @param String cntr_no1
		 * @param String search_dt
		 * @return String[]
		 * @exception DAOException
		 */
		public String[] searchCandtHisInfo(String cntr_no1, String search_dt) throws DAOException {
			DBRowSet dbRowset = null;
			String[] candiInfo = new String[2];
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("cntr_no", cntr_no1);
				param.put("search_dt", search_dt.replaceAll("-", ""));
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchCandtHisInfoRSQL(), param, velParam);
				if (dbRowset.next()) {
					candiInfo[0]=  dbRowset.getString("SC_CUST_CNT_CD");
					candiInfo[1]=  dbRowset.getString("SC_CUST_SEQ");
				}else{
					candiInfo[0]=  "";
					candiInfo[1]=  "";
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return candiInfo;
		}
		
		
		/**
		 * email LIst 정보 조회.<br>
		 * 
		 * @param String[] mainInfo
		 * @return List<SceDwllCustSvcListVO>
		 * @exception DAOException
		 */
		public List<SceDwllCustSvcListVO> searchSceDwllCustSvcList(String[] mainInfo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SceDwllCustSvcListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
					//Map<String, String> mapVO = dwllVO .getColumnValues();
				//	param.putAll(mapVO);
				//	velParam.putAll(mapVO);
					param.put("cust_cnr_cd",mainInfo[0].toString());
					param.put("cust_seq",mainInfo[1].toString());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchSceDwllCustSvcListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SceDwllCustSvcListVO .class);
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
		 * Email 정보를 추가를 한다. 조회.<br>
		 * 
		 * @param SceDwllCustSvcListVO sceDwllCustSvcListVO
		 * @exception DAOException
		 */
		public void addSceDwllCustSvcList(SceDwllCustSvcListVO sceDwllCustSvcListVO) throws DAOException {
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
			//	param.put("cntr_no", cntr_no);				
				
				if(sceDwllCustSvcListVO != null){
					Map<String, String> mapVO = sceDwllCustSvcListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDAOAddSceDwllCustSvcListCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}

		/**
		 * Email 정보를 추가를 한다.<br>
		 * 
		 * @param String cust_cd
		 * @param String cust_seq
		 * @return int
		 * @throws DAOException 
		 * @exception DAOException
		 */
		public int searchMaxNtfcSeq(String cust_cd, String cust_seq) throws DAOException {
			DBRowSet dbRowset = null;
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
					//Map<String, String> mapVO = dwllVO .getColumnValues();
				//	param.putAll(mapVO);
				//	velParam.putAll(mapVO);
					param.put("cust_cnr_cd",cust_cd);
					param.put("cust_seq",cust_seq);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchMaxNtfcSeqRSQL(), param, velParam);
				if (dbRowset.next()){
					result = dbRowset.getInt("SEQ");
				}
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		
		}
		
		/**
		 * Candidate Email 정보를 조회 합니다.<br>
		 * 
		 * @param DwllNtfcSrchVO dwllVO
		 * @return List<searchDwllNtfcSvcList>
		 * @exception DAOException
		 */
		public List<DwllNtfcSrchVO> searchCandidateDwllNtfcSvcPopUpList(DwllNtfcSrchVO dwllVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<DwllNtfcSrchVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchCandidateDwllNtfcSvcPopUpListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, DwllNtfcSrchVO .class);
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
		 * Candidate email 저장 <br>
		 * 
		 * @param DwllNtfcSrchVO dwllNtfcSrchVO
		 * @exception DAOException
		 */
		public void insertCandidateDwllNtfcSvcListDtl(DwllNtfcSrchVO dwllNtfcSrchVO) throws DAOException {
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(dwllNtfcSrchVO != null){
					Map<String, String> mapVO = dwllNtfcSrchVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDAOInsertCandidateDwllNtfcSvcListDtlCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		 /**
		 * Candidate email 저장 <br>
		 * 
		 * @param DwllNtfcSrchVO dwllNtfcSrchVO
		 * @exception DAOException
		 */
		public void updateCandidateDwllNtfcSvcListDtl(DwllNtfcSrchVO dwllNtfcSrchVO) throws DAOException {
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(dwllNtfcSrchVO != null){
					Map<String, String> mapVO = dwllNtfcSrchVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDAOUpdateCandidateDwllNtfcSvcListDtlUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}

		 /**
		 * Candidate email 저장 <br>
		 * 
		 * @param DwllNtfcSrchVO dwllNtfcSrchVO
		 * @exception DAOException
		 */
		public void modifyCandidateDwllNtfcSvcListDtl(DwllNtfcSrchVO dwllNtfcSrchVO) throws DAOException {
			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(dwllNtfcSrchVO != null){
					Map<String, String> mapVO = dwllNtfcSrchVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DwellNotificationDBDAOModifyCandidateDwllNtfcSvcListDtlUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * [Dwll raason 의 단건에 대한 조회]<br>
		 * 
		 * @param DwellRnsVO dwllVO
		 * @return DwellRnsVO
		 * @exception DAOException
		 */
		public DwellRnsVO searchDwellRsn(DwellRnsVO dwllVO) throws DAOException {
			DBRowSet dbRowset = null;
			
			DwellRnsVO returnvo = new DwellRnsVO();
			String redata[] = new String[1];
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				if (dwllVO!=null && "T96".equals(dwllVO.getDwllTmTpCd())){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwllReasonT96RSQL(), param, velParam);
				}else {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwllReasonD72RSQL(), param, velParam);
				}
				if (dbRowset.next()){
					redata[0] = JSPUtil.getNull(dbRowset.getString("DWLL_RSN"),"");
				}else{
					redata[0] = "";
		
				}
				returnvo.setResultStrArray(redata);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return returnvo;
		}
		
		 /**
		 * Dwll rsn  저장을 한다. <br>
		 * 
		 * @param List<DwellRnsVO> upsModels
		 * @exception DAOException
		 */
		public void addDwellRsn(List<DwellRnsVO> upsModels) throws DAOException {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(upsModels.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new DwellNotificationDBDAOAddDwellRsnUSQL(), upsModels,null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
		 * Customer Code 유/무 조회.<br>
		 * @param String custCd
		 * @return DBRowSet
		 * @throws EventException
		 */
		public DBRowSet checkCustCd(String custCd) throws DAOException {
			DBRowSet dbRowset = null; 
			Map<String, Object> param = new HashMap<String, Object>();//parameter	
				try {
					if(custCd != null){
						param.put("cust_cd"    ,custCd);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOCheckCustCdRSQL(), param, null);
				} catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());			
				} catch(Exception ex){
					log.error(ex.getMessage(),ex);			
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}

				return dbRowset;
		}
		
		/**
		 * Dwell Notification Exception 항목 단건 조회
		 * 
		 * @param DwllNtfcSrchVO dwllVO
		 * @return List<searchDwllNtfcSvcList>
		 * @exception DAOException
		 */
		public DwllNtfcSrchVO searchDwllNtfcExptItem(DwllNtfcSrchVO dwllVO) throws DAOException {
			DBRowSet dbRowset = null;
			
			DwllNtfcSrchVO returnvo = new DwllNtfcSrchVO();
			String redata[] = new String[13];
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(dwllVO != null){
					Map<String, String> mapVO = dwllVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchDwllNtfcExptItemRSQL(), param, velParam);
				if (dbRowset.next()){
					redata[0] = JSPUtil.getNull(dbRowset.getString("CTRT_PTY_NM"),"");
					redata[1] = JSPUtil.getNull(dbRowset.getString("TML_DWLL_FLG"),""); 
					redata[2] = JSPUtil.getNull(dbRowset.getString("ENR_DWLL_FLG"),""); 
					redata[3] = JSPUtil.getNull(dbRowset.getString("DEST_DWLL_FLG"),""); 
					redata[4] = JSPUtil.getNull(dbRowset.getString("eff_dt"),"");
					redata[5] = JSPUtil.getNull(dbRowset.getString("exp_dt"),"");
					redata[6] = JSPUtil.getNull(dbRowset.getString("VSL_DLAY_FLG"),""); 
					redata[7] = JSPUtil.getNull(dbRowset.getString("DWLL_EXPT_RMK"),"");
					redata[8] = JSPUtil.getNull(dbRowset.getString("CUST_CD"),"");
					redata[9] = JSPUtil.getNull(dbRowset.getString("SC_NO"),""); 
					redata[10] = JSPUtil.getNull(dbRowset.getString("EXPT_SET_USR_ID"),"");
					redata[11] = JSPUtil.getNull(dbRowset.getString("EXPT_SET_DT"),"");
					redata[12] = JSPUtil.getNull(dbRowset.getString("EXPT_SET_USR_NAME"),"");
				}else{
					redata[0] = "";
					redata[1] = "";
					redata[2] = "";
					redata[3] = "";
					redata[4] = "";
					redata[5] = "";
					redata[6] = "";
					redata[7] = "";
					redata[8] = "";
					redata[9] = "";
					redata[10] = "";
					redata[11] = "";
					redata[12] = "";
				}
				returnvo.setResultStrArray(redata);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return returnvo;
		}
		
		/**
		 * Candidate Email 정보를 조회 합니다.<br>
		 * 
		 * @param SearchOneTimeSndHistVO searchOneTimeSndHistVO
		 * @return List<SearchOneTimeSndHistVO>
		 * @exception DAOException
		 */
		public List<SearchOneTimeSndHistVO> searchOneTimeSndHistList(SearchOneTimeSndHistVO searchOneTimeSndHistVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchOneTimeSndHistVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchOneTimeSndHistVO != null){
					Map<String, String> mapVO = searchOneTimeSndHistVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DwellNotificationDBDAOSearchOneTimeSndHistRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOneTimeSndHistVO .class);
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
		 * Candidate  Type tab별 Total Count 값 조회 <br>
		 * 
		 * @param event EsdSce0160Event
		 * @return eventResponse EventResponse
		 * @throws DAOException
		 */
		public EventResponse searchDwellCandidateTotalCnt(EsdSce0160Event event) throws DAOException {
				
			//GeneralEventResponse eventResponse = new GeneralEventResponse();
			EventResponse eventResponse = new GeneralEventResponse();
			Map<String, Object> param = new HashMap<String, Object>();
			DBRowSet dRs = new DBRowSet();	
			StringTokenizer st = null;
			try {
				
				SearchDwellVO searchDwellVO = event.getSearchDwellVO();
				ArrayList<String> scNoArr = new ArrayList<String>(); 
				param.putAll(searchDwellVO.getColumnValues());		
				
				if( !"".equals(searchDwellVO.getScNo2())){
					param.put("sc_no", searchDwellVO.getScNo()+searchDwellVO.getScNo2());
				}else{
					String sc_no = searchDwellVO.getScNo();
					int i = 0;
					st = new StringTokenizer(sc_no, ",");
					while( st.hasMoreTokens() ) {
						scNoArr.add(i++,st.nextToken());
					}
					param.put("scNoArr", scNoArr);
					param.put("sc_no", "");					
				}
				param.put("search_dt", (searchDwellVO.getSearchDt()).replaceAll("-", ""));
				dRs = new SQLExecuter("DEFAULT").executeQuery(new DwellNotificationDBDAOSearchDwellCandidateTotalCntRSQL(), param,param);
				eventResponse.setRs(dRs);	

				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ee) {
				log.error(ee.getMessage(), ee);
				throw new DAOException(ee.getMessage());
			} 
			
			return eventResponse;
		}
}