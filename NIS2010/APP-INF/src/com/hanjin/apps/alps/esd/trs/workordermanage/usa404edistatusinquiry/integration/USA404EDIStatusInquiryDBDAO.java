/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAO.java
*@FileTitle : USA 404 EDI Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-28 kim_sang_geun
* 1.0 최초 생성
* N200902230090 2009-03-10 [EDI] 미주 Rail 998, 404 FF 통합
* N200903170080 2009-03-27 [EDI] CPRS 404 EDI 보완 요청
* N200903260080 2009-04-07 [TRS-US Rail] AES No 관련 보완 요청
* N200904030180 2009-04-15 [TRS_Rail EDI] DG 관련 항목 추가 및 Shipper 정보 누락관련 보완요청
* N200904290040 2009-05-15 [EDI-TRS] Rail EDI (404) CUST 정보 보완요청
* N200905250130 [TRS]US RAIL EDI 발송시 RF CNTR Temp 체크 로직 추가
* N200905270080 [TRS]US RAIL EDI  DG CGO에 대한 Flash point 추가 전송관련 보완
* N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
* S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
* N200906100030 2009-06-15 [EDI-TRS/Dom. EDI-404] Rail Interchage에 대한 Contract no 보완
* 1.46 2010.11.23 이재위 [] [TRS] OPMS Design/Development Verification 을 위한 소스 점검
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.basic.USA404EDIStatusInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.vo.MessageEdiSendInfoVO;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.vo.Multi01USA404EDIStatusInquiryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspCfmMsgHisVO;
import com.hanjin.syscommon.common.table.TrsTrspEdiRailOrdVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kim_sang_geun
 * @see USA404EDIStatusInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class USA404EDIStatusInquiryDBDAO extends DBDAOSupport {

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSA404EDIStatusInquiry(EsdTrs0028Event event) throws DAOException {		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList st    = null;
		
		List<String> vvd = new ArrayList();
		List<String> bkg = new ArrayList();
		List<String> bl = new ArrayList();
		List<String> cntr = new ArrayList();
		
		try {
			
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(event != null && !"".equals(event.getTrunkVvd())){
				st = CommonUtil.seperationParameter(event.getTrunkVvd(), ",");
				vvd.addAll(st);
			}
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			
			if(event != null && !"".equals(event.getBkgNo())){
				st = CommonUtil.seperationParameter(event.getBkgNo(), ",");
				bkg.addAll(st);
			}
			param.put("bkg", bkg);
			velParam.put("bkg", bkg);
			
			if(event != null && !"".equals(event.getBillNo())){
				st = CommonUtil.seperationParameter(event.getBillNo(), ",");
				bl.addAll(st);
			}
			param.put("bl", bl);
			velParam.put("bl", bl);
			
			if(event != null && !"".equals(event.getCntrNo())){
				st = CommonUtil.seperationParameter(event.getCntrNo(), ",");
				cntr.addAll(st);
			}
			param.put("cntr", cntr);
			velParam.put("cntr", cntr);
			
			if( !"".equals(event.getBkgNo()) ){
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearchUsa404EdiStatusInquiryBkgRSQL(), param, velParam);
			}else{
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearchUsa404EdiStatusInquiryRSQL(), param, velParam);				
			}
			
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search02USA404EDIStatusInquiry(EsdTrs0028Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			Map<String, String> condiParams = event.getColumnValues();
			param.put("trsp_so_ofc_cty_cd", condiParams.get("f_trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq"       , condiParams.get("f_trsp_so_seq"));
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearch02USA404EDIStatusInquiryRSQL(), param, param);
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}		
		return dbRowset;
	}
	
	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send
	 * 
	 * @param list
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search03USA404EDIStatusSend(List<Object> list) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String strsp_edi_snd_no = "";
		String insert_count = "0";
		if( list.size() > 0 ) {
			strsp_edi_snd_no = String.valueOf(list.get(0));
			insert_count = String.valueOf(list.get(1));
		}
		
		try{			
			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);
			
			// 404 EDI FF 생성
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearch03USA404EDIStatusSendRSQL(), param, velParam);
						
			if( dbRowset.getRowCount() < 1 ) {
				throw new DAOException(new ErrorHandler("TRS00015").getMessage());
			} else if( Integer.parseInt(insert_count) != dbRowset.getRowCount() ) {
				throw new DAOException(new ErrorHandler("TRS00015").getMessage());
			}
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}		
		return dbRowset;
	}



	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send
	 * 
	 * @param param
	 * @param velParam
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search03SubUSA404EDIStatusSend(Map<String, Object> param, Map<String, Object> velParam) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		
		try{
			// 404 EDI FF 생성
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearch03SubUSA404EDIStatusSendRSQLRSQL(), param, velParam);							
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}		
		return dbRowset;
	}

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send
	 * 
	 * @param list
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUS404EDIResendList(List<Object> list) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String strsp_edi_snd_no = "";
		String insert_count = "0";
		if( list.size() > 0 ) {
			strsp_edi_snd_no = String.valueOf(list.get(0));
			insert_count = String.valueOf(list.get(1));
		}
		
		try{			
			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);
			
			// 404 EDI FF 생성
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearch03USA404EDIResendListRSQL(), param, velParam);
						
			if( dbRowset.getRowCount() < 1 ) {
				throw new DAOException(new ErrorHandler("TRS00015").getMessage());
			} else if( Integer.parseInt(insert_count) != dbRowset.getRowCount() ) {
				throw new DAOException(new ErrorHandler("TRS00015").getMessage());
			}
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send
	 * 
	 * @param param
	 * @param velParam
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet resendUS404EDIResend(Map<String, Object> param, Map<String, Object> velParam) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;

		try {
			// 404 EDI FF 생성
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOResendUS404EdiResendRSQL(), param, velParam);
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
	

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send Cancel
	 * 
	 * @param list
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search04USA404EDIStatusSend(List<Object> list) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String strsp_edi_snd_no = "";
		String insert_count = "0";
		if( list.size() > 0 ) {
			strsp_edi_snd_no = String.valueOf(list.get(0));
			insert_count = String.valueOf(list.get(1));
		}
		
		try{			
			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);
			
			// 404 EDI FF 생성
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearch04USA404EDIStatusSendRSQL(), param, velParam);
						
			if( dbRowset.getRowCount() < 1 ) {
				throw new DAOException(new ErrorHandler("TRS00015").getMessage());
			} else if( Integer.parseInt(insert_count) != dbRowset.getRowCount() ) {
				throw new DAOException(new ErrorHandler("TRS00015").getMessage());
			}		
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 404EDI Send Cancel
	 * 
	 * @param param
	 * @param velParam
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search04SubUSA404EDIStatusSend(Map<String, Object> param, Map<String, Object> velParam) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		
		try {			
			// 404 EDI FF 생성
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearch04SubUSA404EDIStatusSendRSQL(), param, velParam);
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		} 
		return dbRowset;
	}
	

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList multiTrsTrspEdiRailOrderVos(EsdTrs0028Event event) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFull = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListEmpty = new ArrayList<TrsTrspEdiRailOrdVO>();
		
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
	  	
		int insCnt[] = null;
		int q = 1;
		int z = 0;
		int r = 0;
		
		String sso_seq = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddssSS"); //"MMMddyy"
		String sdateformat = sf.format(new Date());
		String strsp_edi_snd_no = event.getUserId()+""+sdateformat; //TRSP_EDI_SND_NO
		
		ArrayList arr_edi_snd_no = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
		arr_edi_snd_no.add(z++, strsp_edi_snd_no);
		
		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);
			
			for(int i = 0; i < model.length; i++){							
				if ( model[i].getIbflag().equals("I")){
					r++;
					
					if( sso_seq.equals(model[i].getTrspSoSeq()) ) {
						q++;
					} else q=1;
					
					model[i].setBilIssKnt(Integer.toString(q));					
					sso_seq = model[i].getTrspSoSeq();
					
					if("F".equals(model[i].getCgoTpCd())){
						trsTrspEdiRailOrdVoListFull.add(model[i]);
					}else{
						trsTrspEdiRailOrdVoListEmpty.add(model[i]);						
					}
				}
			}
			
			// Full, Empty에 따른 분기
			if(trsTrspEdiRailOrdVoListFull.size() > 0){
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrdCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrdCSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrdUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrdUSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiTempCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiTempCSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				
				log.error("==== 404 EDI Parameter:::: " + (String)new USA404EDIStatusInquiryDBDAOInsert404EdiTempCSQL().getSQL());
				log.error("==== 404 EDI Parameter:::: " + param);
				log.error("==== 404 EDI Parameter:::: " + velParam);
				
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
			
			if(trsTrspEdiRailOrdVoListEmpty.size() > 0){
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrdCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrdCSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOUpdateEqrRepoIfUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdateEqrRepoIfUSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd2USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd2USQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiTempCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiTempCSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				
				log.error("==== 404 EDI Parameter:::: " + (String)new USA404EDIStatusInquiryDBDAOInsert404EdiTempCSQL().getSQL());
				log.error("==== 404 EDI Parameter:::: " + param);
				log.error("==== 404 EDI Parameter:::: " + velParam);
				
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
			arr_edi_snd_no.add(z++, String.valueOf(r));
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arr_edi_snd_no;
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList modifyUS404EDIResendRailBilOrd(EsdTrs0028Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoList = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListWo = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListIns = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListUpd = new ArrayList<TrsTrspEdiRailOrdVO>();
		
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
	  	
		int insCnt[] = null;
		int r = 0;
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddssSS"); //"MMMddyy"
		String sdateformat = sf.format(new Date());
		String strsp_edi_snd_no = event.getUserId()+""+sdateformat; //TRSP_EDI_SND_NO
		
		ArrayList arr_edi_snd_no = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
		arr_edi_snd_no.add(0, strsp_edi_snd_no);		

		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);
			
			for(int i = 0; i < model.length; i++){							
				if ( model[i].getIbflag().equals("I")){
					r++;
					
					trsTrspEdiRailOrdVoList.add(model[i]);
				}
				
				if( "I".equals(model[i].getBilIssStsCd()) ){
					trsTrspEdiRailOrdVoListWo.add(model[i]);
				}else{
					param.put("trspSoOfcCtyCd", model[i].getTrspSoOfcCtyCd());
					param.put("trspSoSeq", model[i].getTrspSoSeq());
					
					velParam.put("trspSoOfcCtyCd", model[i].getTrspSoOfcCtyCd());
					velParam.put("trspSoSeq", model[i].getTrspSoSeq());
					
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearch404EdiResendSoRSQL(), param, velParam);
					
					if( dbRowset!= null && dbRowset.next() ) {
						if( dbRowset.getString(1).equals("0") ){
							trsTrspEdiRailOrdVoListIns.add(model[i]);
						}else{
							trsTrspEdiRailOrdVoListUpd.add(model[i]);															
						}
					}
				}
			}
			
			if(trsTrspEdiRailOrdVoList.size() > 0){
				// USA404EDIStatusInquiryDBDAOInsert404EdiResendTrsTrspEdiTmpCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiResendTrsTrspEdiTmpCSQL(), trsTrspEdiRailOrdVoList, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
			
			if(trsTrspEdiRailOrdVoListWo.size() > 0){
				// USA404EDIStatusInquiryDBDAOUpdate404EdiResendTrsTrspEdiRailOrdUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiResendTrsTrspEdiRailOrdUSQL(), trsTrspEdiRailOrdVoListWo, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}				
			}
			
			if(trsTrspEdiRailOrdVoListUpd.size() > 0){
				// USA404EDIStatusInquiryDBDAOUpdate404EdiResendTrsTrspEdiRailOrdUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiResendSoUSQL(), trsTrspEdiRailOrdVoListUpd, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}				
			}
			
			if(trsTrspEdiRailOrdVoListIns.size() > 0){
				// USA404EDIStatusInquiryDBDAOUpdate404EdiResendTrsTrspEdiRailOrdUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiResendSoCSQL(), trsTrspEdiRailOrdVoListIns, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}		
			}
			
			arr_edi_snd_no.add(1, String.valueOf(r));
		
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arr_edi_snd_no;
	}

	/**
	 * @param event
	 * @throws DAOException
	 */
	public void multiRollbackTrsTrspEdiRailOrderVos(EsdTrs0028Event event) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoList = new ArrayList<TrsTrspEdiRailOrdVO>();
		
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
		
		int insCnt[] = null;
		
		try{
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			for(int i = 0; i < model.length; i++){							
				if ( model[i].getIbflag().equals("I")){					
					trsTrspEdiRailOrdVoList.add(model[i]);
				}
			}
			
			if(trsTrspEdiRailOrdVoList.size() > 0){
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrdCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOMulti404EdiRollbackUSQL(), trsTrspEdiRailOrdVoList, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
	}

	/**
	 * @param event
	 * @throws DAOException
	 */
	public void addUSA404EDIResendRollback(EsdTrs0028Event event) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoList = new ArrayList<TrsTrspEdiRailOrdVO>();
		
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
		
		int insCnt[] = null;
		
		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			for(int i = 0; i < model.length; i++){							
				if ( model[i].getIbflag().equals("I")){					
					trsTrspEdiRailOrdVoList.add(model[i]);
				}
			}
			
			if(trsTrspEdiRailOrdVoList.size() > 0){
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrdCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdateUSA404EdiResendRollbackUSQL(), trsTrspEdiRailOrdVoList, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @throws DAOException
	 */
	public void multi01USA404EDIStatusInquiry(EsdTrs0028Event event) throws DAOException {
		Collection<Multi01USA404EDIStatusInquiryVO> insModels = new ArrayList<Multi01USA404EDIStatusInquiryVO>();
		
		Multi01USA404EDIStatusInquiryVO[] multiVos = event.getConfirmationMsgSendVos();
		
		String sSndOfcCd = event.getCtrlOfcCd();
		String sSndUsrId = event.getUserId();
		
		try{
			if( multiVos != null ){
				for( int i=0; i<multiVos.length; i++ ){
					if(multiVos[i].getIbflag().equals("I")){
						insModels.add(multiVos[i]);
					}
				}
			}
			Map<String,Object> param_wrk = new HashMap<String,Object>();
			param_wrk.put("snd_ofc_cd", sSndOfcCd);
			param_wrk.put("snd_usr_id", sSndUsrId);
			
			int[] insCnt  = null;
			if( insModels.size() > 0 ){
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new USA404EDIStatusInquiryDBDAOMulti01USA404EDIStatusInquiryCSQL(), insModels, param_wrk, param_wrk);
			}
			if(insCnt != null){
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to INSERT No"+ i + " SQL");
					}
				}
			}
			
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList multi02TrsTrspEdiRailOrderVos(EsdTrs0028Event event) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFullRbb = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFull = new ArrayList<TrsTrspEdiRailOrdVO>();		
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListEmpty = new ArrayList<TrsTrspEdiRailOrdVO>();
		
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
	  	
		int insCnt[] = null;
		int q = 1;
		int z = 0;
		int r = 0;
		
		String sso_seq = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddssSS"); //"MMMddyy"
		String sdateformat = sf.format(new Date());
		String strsp_edi_snd_no = event.getUserId()+""+sdateformat; //TRSP_EDI_SND_NO
		
		ArrayList arr_edi_snd_no = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
		arr_edi_snd_no.add(z++, strsp_edi_snd_no);
		
		try{
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);
			
			for(int i = 0; i < model.length; i++){
				r++;				
				
				if( sso_seq.equals(model[i].getTrspSoSeq()) ) {
					q++;
				} else q=1;
				
				model[i].setBilIssKnt(Integer.toString(q));				
				sso_seq = model[i].getTrspSoSeq();
				
				if("F".equals(model[i].getCgoTpCd()) && "RBB".equals(model[i].getWoRjctRsn())){
					trsTrspEdiRailOrdVoListFullRbb.add(model[i]);					
				}else if("F".equals(model[i].getCgoTpCd()) && !"RBB".equals(model[i].getWoRjctRsn())){
					trsTrspEdiRailOrdVoListFull.add(model[i]);					
				}else{
					trsTrspEdiRailOrdVoListEmpty.add(model[i]);					
				}	
			}
			
			// trsTrspEdiRailOrdVoListFullRbb 수행
			if(trsTrspEdiRailOrdVoListFullRbb.size() > 0){
				param.put("woRjctRsn", "RBB");
				velParam.put("woRjctRsn", "RBB");
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
			
			// trsTrspEdiRailOrdVoListFull 수행
			if(trsTrspEdiRailOrdVoListFull.size() > 0){
				param.put("woRjctRsn", "");
				velParam.put("woRjctRsn", "");
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}	
			
			// trsTrspEdiRailOrdVoListEmpty 수행
			if(trsTrspEdiRailOrdVoListEmpty.size() > 0){				
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOUpdateEqrRepoIf2USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdateEqrRepoIf2USQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}	
			arr_edi_snd_no.add(z++, String.valueOf(r));	
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arr_edi_snd_no;
	}
	
	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multi02TrsTrspEdiRailOrderVoRbb(EsdTrs0028Event event) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFullRbb = new ArrayList<TrsTrspEdiRailOrdVO>();
		
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
	  	
		int insCnt[] = null;
		
		try{
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			for(int i = 0; i < model.length; i++){				
				if("F".equals(model[i].getCgoTpCd()) && "RBB".equals(model[i].getWoRjctRsn())){
					trsTrspEdiRailOrdVoListFullRbb.add(model[i]);					
				}	
			}
			
			// trsTrspEdiRailOrdVoListFullRbb 수행
			if(trsTrspEdiRailOrdVoListFullRbb.size() > 0){
				param.put("woRjctRsn", "RBB");
				velParam.put("woRjctRsn", "RBB");
				
				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 404EDI Cancellation EDI Send
	 * 
	 * @param event
	 * @param h
	 * @return
	 * @throws DAOException
	 */
	public ArrayList multi02TrsTrspEdiRailOrderVoForSpp(EsdTrs0028Event event, int h) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFullRbb = new ArrayList<TrsTrspEdiRailOrdVO>();
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListFull = new ArrayList<TrsTrspEdiRailOrdVO>();		
		List<TrsTrspEdiRailOrdVO> trsTrspEdiRailOrdVoListEmpty = new ArrayList<TrsTrspEdiRailOrdVO>();
		
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
	  	
		int insCnt[] = null;
		int q = 1;
		int z = 0;
		int r = 0;
		
		String sso_seq = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddssSS"); //"MMMddyy"
		String sdateformat = sf.format(new Date());
		String strsp_edi_snd_no = event.getUserId()+""+sdateformat; //TRSP_EDI_SND_NO
		
		ArrayList arr_edi_snd_no = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
		arr_edi_snd_no.add(z++, strsp_edi_snd_no);
		
		try{
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("strsp_edi_snd_no", strsp_edi_snd_no);
			velParam.put("strsp_edi_snd_no", strsp_edi_snd_no);
			
			r++;				
			
			if( sso_seq.equals(model[h].getTrspSoSeq()) ) {
				q++;
			} else q=1;
			
			model[h].setBilIssKnt(Integer.toString(q));				
			sso_seq = model[h].getTrspSoSeq();
			
			if("F".equals(model[h].getCgoTpCd()) && "RBB".equals(model[h].getWoRjctRsn())){
				trsTrspEdiRailOrdVoListFullRbb.add(model[h]);					
			}else if("F".equals(model[h].getCgoTpCd()) && !"RBB".equals(model[h].getWoRjctRsn())){
				trsTrspEdiRailOrdVoListFull.add(model[h]);					
			}else{
				trsTrspEdiRailOrdVoListEmpty.add(model[h]);					
			}
			
			// trsTrspEdiRailOrdVoListFullRbb 수행
			if(trsTrspEdiRailOrdVoListFullRbb.size() > 0){
				param.put("woRjctRsn", "RBB");
				velParam.put("woRjctRsn", "RBB");
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2SPPCSQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2SPPCSQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4SPPUSQL(), trsTrspEdiRailOrdVoListFullRbb, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
			
			// trsTrspEdiRailOrdVoListFull 수행
			if(trsTrspEdiRailOrdVoListFull.size() > 0){
				param.put("woRjctRsn", "");
				velParam.put("woRjctRsn", "");
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2SPPCSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2SPPCSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4SPPUSQL(), trsTrspEdiRailOrdVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}	
			
			// trsTrspEdiRailOrdVoListEmpty 수행
			if(trsTrspEdiRailOrdVoListEmpty.size() > 0){				
				// USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiRailOrd2SPPCSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOUpdateEqrRepoIf2USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdateEqrRepoIf2SPPUSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOInsert404EdiTemp2CSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOInsert404EdiTemp2SPPCSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4USQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd4SPPUSQL(), trsTrspEdiRailOrdVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}	
			arr_edi_snd_no.add(z++, String.valueOf(r));
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arr_edi_snd_no;
	}

	/**
	 * USA404EDIStatusInquiry의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @throws DAOException
	 */
	public void multi03TrsTrspEdiRailOrderVos(EsdTrs0028Event event) throws DAOException {				
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspEdiRailOrdVO> updateVoList = new ArrayList<TrsTrspEdiRailOrdVO>();
		
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
	  	
		int insCnt[] = null;

		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			for(int i = 0; i < model.length; i++){							
				if ( model[i].getIbflag().equals("U")){					
					updateVoList.add(model[i]);
				}				
			}
			
			if(updateVoList.size() > 0){
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAOUpdate404EdiRailOrd3USQL(), updateVoList, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}		
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * sending (interface)
	 * USA404EDIStatusInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Correction Search View(Update)
	 * 
	 * @param sOfc_cty_cd
	 * @param sSo_seq
	 * @return
	 * @throws DAOException
	 */
	public ArrayList batchUSA404ComfirmedMessageAuto(String sOfc_cty_cd, String sSo_seq) throws DAOException {
		// DB ResultSet
		DBRowSet rs = null;		

		ArrayList arrResponse = new ArrayList();

		String strspSoOfcCtyCd = "";
		String strspSoSeq = "";
		String ssndSeq = "";
		String seqNo = "";
		String seqTpszCd = "";
		String sprovVndrSeq = "";
		String sprovUsrId = "";
		String sprovFaxNo = "";
		String sprovEml = "";
		String sshprCustNm = "";
		String sshprFaxNo = "";
		String ssndDt = "";
		String sofcCd = "";
		String screUsrId = "";
		String sprovCfmMzdCd = "";

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("trspSoOfcCtyCd",sOfc_cty_cd);
			param.put("trspSoSeq",sSo_seq);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USA404EDIStatusInquiryDBDAObatchUSA404ComfirmedMessageAutoRSQL template = new USA404EDIStatusInquiryDBDAObatchUSA404ComfirmedMessageAutoRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);

			// 결과를 DBRowset에 담는다.
			Collection<TrsTrspCfmMsgHisVO> insertVoList = new ArrayList<TrsTrspCfmMsgHisVO>();
			while( rs.next() ) {
				strspSoOfcCtyCd = rs.getString("TRSP_SO_OFC_CTY_CD");
				strspSoSeq = rs.getString("TRSP_SO_SEQ");
				seqNo = rs.getString("EQ_NO");
				seqTpszCd = rs.getString("EQ_TPSZ_CD");
				sprovVndrSeq = rs.getString("PROV_VNDR_SEQ");
				sprovUsrId = rs.getString("PROV_USR_ID");
				sprovFaxNo = rs.getString("PROV_FAX_NO");
				sprovEml = rs.getString("PROV_EML");
				sshprCustNm = rs.getString("SHPR_CUST_NM");
				sshprFaxNo = rs.getString("SHPR_FAX_NO");
				ssndDt = rs.getString("SND_DT");
				sofcCd = rs.getString("CRE_OFC_CD");
				screUsrId = rs.getString("CRE_USR_ID");
				sprovCfmMzdCd = rs.getString("PROV_CFM_MZD_CD");

				TrsTrspCfmMsgHisVO vo = new TrsTrspCfmMsgHisVO();
				vo.setTrspSoOfcCtyCd(strspSoOfcCtyCd);
				vo.setTrspSoSeq(strspSoSeq);
				vo.setEqNo(seqNo);
				vo.setEqTpszCd(seqTpszCd);
				vo.setRltTrkrSeq(sprovVndrSeq);
				vo.setRltTrkrNm(sprovUsrId);
				vo.setRltTrkrFaxNo(sprovFaxNo);
				vo.setRltTrkrEml(sprovEml);
				vo.setShprCustNm(sshprCustNm);
				vo.setShprFaxNo(sshprFaxNo);
				vo.setSndDt(ssndDt);
				vo.setSndOfcCd(sofcCd);
				vo.setSndUsrId(screUsrId);
				insertVoList.add(vo);
				
				MessageEdiSendInfoVO esd012_eventResponse = new MessageEdiSendInfoVO();
				esd012_eventResponse.setTrspSoOfcCtyCd(strspSoOfcCtyCd);
				esd012_eventResponse.setTrspSoSeq(strspSoSeq);
				esd012_eventResponse.setSndSeq(ssndSeq);
				esd012_eventResponse.setProvVndrSeq(sprovVndrSeq);
				esd012_eventResponse.setProvUsrId(sprovUsrId);
				esd012_eventResponse.setProvFaxNo(sprovFaxNo);
				esd012_eventResponse.setProvEml(sprovEml);
				esd012_eventResponse.setShprCustNm(sshprCustNm);
				esd012_eventResponse.setShprFaxNo(sshprFaxNo);
				esd012_eventResponse.setSndDt(ssndDt);
				esd012_eventResponse.setOfcCd(sofcCd);
				esd012_eventResponse.setCreUsrId(screUsrId);
				esd012_eventResponse.setProvCfmMzdCd(sprovCfmMzdCd);
				arrResponse.add(esd012_eventResponse);
			}
			if(insertVoList.size() > 0){
				sqlExe.executeBatch((ISQLTemplate)new USA404EDIStatusInquiryDBDAObatchUSA404ComfirmedMessageAutoCSQL(), insertVoList, null, null);
			}
			
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arrResponse;
	}
	
	/**
	 * O/B FULL REEFER CNTR 404 EDI 발송 이전 CNTR#, 온도 누락에 대한 VERIFY<br>
	 * 404EDI Send Verify
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifyObReeferCntr(EsdTrs0028Event event) throws DAOException {		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
		
		String rfCount = "";
		String cCount = "";
		String numSoBkg = "";
		
		try {			
			for(int i = 0; i < model.length; i++){
				param.put("trspSoOfcCtyCd", model[i].getTrspSoOfcCtyCd());
				velParam.put("trspSoOfcCtyCd", model[i].getTrspSoOfcCtyCd());
				
				param.put("trspSoSeq", model[i].getTrspSoSeq());
				velParam.put("trspSoSeq", model[i].getTrspSoSeq());
				
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearchVerifyObReeferCntrRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					rfCount = dbRowset.getString(8);
					cCount = dbRowset.getString(9);			
					
					if( dbRowset.getRow() > 0 && (!rfCount.equals(cCount) || "0".equals(rfCount))) {
						if("".equals(numSoBkg)){
							numSoBkg = model[i].getTrspSoOfcCtyCd() + model[i].getTrspSoSeq() + "(" + model[i].getBkgNo() + ")";							
						}else{
							numSoBkg = numSoBkg + ", " + model[i].getTrspSoOfcCtyCd() + model[i].getTrspSoSeq() + "(" + model[i].getBkgNo() + ")";							
						}						
					}
				}
			}			
			if( !"".equals(numSoBkg)){
				throw new DAOException(new ErrorHandler("TRS50108", new String[] {numSoBkg}).getMessage());
			}					
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return null;
	}
	
	/**
	 * O/B FULL DG CNTR 404 EDI 발송 이전 DG 정보 누락에 대한 VERIFY<br>
	 * 404EDI Send Verify
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifyObDgCntr(EsdTrs0028Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
		
		String rfCount = "";
		String cCount = "";
		String numSoBkg = "";
		
		try {			
			for(int i = 0; i < model.length; i++){
				param.put("trspSoOfcCtyCd", model[i].getTrspSoOfcCtyCd());
				velParam.put("trspSoOfcCtyCd", model[i].getTrspSoOfcCtyCd());
				
				param.put("trspSoSeq", model[i].getTrspSoSeq());
				velParam.put("trspSoSeq", model[i].getTrspSoSeq());
				
				param.put("vndrSeq", model[i].getVndrSeq());
				velParam.put("vndrSeq", model[i].getVndrSeq());
				
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USA404EDIStatusInquiryDBDAOSearchVerifyObDgCntrRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					rfCount = dbRowset.getString(8);
					cCount = dbRowset.getString(9);			
					
					if( dbRowset.getRow() > 0 && (!rfCount.equals(cCount) || "0".equals(rfCount))) {
						if("".equals(numSoBkg)){
							numSoBkg = model[i].getTrspSoOfcCtyCd() + model[i].getTrspSoSeq() + "(" + model[i].getBkgNo() + ")";							
						}else{
							numSoBkg = numSoBkg + ", " + model[i].getTrspSoOfcCtyCd() + model[i].getTrspSoSeq() + "(" + model[i].getBkgNo() + ")";							
						}						
					}
				}
			}			
			if( !"".equals(numSoBkg)){
				throw new DAOException(new ErrorHandler("TRS50109", new String[] {numSoBkg}).getMessage());
			}
		} catch (SQLException se) {			
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return null;
	}
}