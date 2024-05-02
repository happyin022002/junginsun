/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementRailScgDAO.java
*@FileTitle : Agreement Rail Surcharge
*Open Issues :
*Change history :
*@LastModifyDate : 2010-08-12
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2010-05-17 pjy	   	1.0  최초 생성
* 2010-08-12 Sun, CHOI	1.1 Agreement Reference No 조회 컬럼 추가 및 조회 조건 추가
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0223Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0233Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0234Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.RailSurchargeAgmtTmpVO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.RailSurchargeAgmtVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * @author jong hyek choi
 * @see DBDAOSupport
 * @since J2EE 1.6
 */
public class AgreementRailScgDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRailFuelScgAgmt(EsdTrs0223Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("fmAgmtNo", event.getFmAgmtNo());
			velParam.put("fmAgmtNo", event.getFmAgmtNo());
			
			param.put("railRoadCode", event.getRailRoadCode());
			velParam.put("railRoadCode", event.getRailRoadCode());
			
			param.put("effDt", event.getEffDt());
			velParam.put("effDt", event.getEffDt());
			
			param.put("agmtRefNo", event.getAgmtRefNo());
			velParam.put("agmtRefNo", event.getAgmtRefNo());
			
			log.debug("event.getAgmtRefNo()=============>>>>>>>>>"+event.getAgmtRefNo());
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementRailScgDBDAOSearchRailFuelScgAgmtRSQL(), param, velParam);
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
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 저장
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multiRailFuelScgAgmt(EsdTrs0223Event event) throws DAOException {
		DBRowSet dbRowset = null;
		DBRowSet dbRowsetSeq = null;
		
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<RailSurchargeAgmtVO> insertVoList = new ArrayList<RailSurchargeAgmtVO>();
		List<RailSurchargeAgmtVO> updateVoList = new ArrayList<RailSurchargeAgmtVO>();
		List<RailSurchargeAgmtVO> insertHisVoList = new ArrayList<RailSurchargeAgmtVO>();
		
		RailSurchargeAgmtVO[] model = event.getRailSurchargeAgmtVos();
		
		int insCnt[] = null;
		
		try {
			velParam.put("sUsrId", event.getSUsrId());
			velParam.put("sctrlOfcCd", event.getSctrlOfcCd());
			
			for( int i=0; i<model.length; i++ ) {
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new AgreementRailScgDBDAOSearchRailScgAgmtHisSeqRSQL(), null, null);
				if(dbRowset.next()) {
					model[i].setTrspAgmtRtHisSeq( String.valueOf( dbRowset.getInt(1) ) );
				}
						
				model[i].setTrspAgmtOfcCtyCd( model[i].getAgmtNo().substring(0, 3) );
				model[i].setTrspAgmtSeq( model[i].getAgmtNo().substring(3) );				
				model[i].setTrspRailScgCd( "FSG" );
				model[i].setCurrCd( "XXX" );
				
				if( model[i].getComScgAplyFlg().equals("1") ){
					model[i].setAgmtRoutAllFlg( "Y" );
					model[i].setFmNodCd( "" );
					model[i].setFmNodYard("");
					model[i].setToNodCd( "" );
					model[i].setToNodYard("");
					//model[i].setCgoTpCd( "" );
					model[i].setTrspRailRto( "" );
				}else{
					model[i].setAgmtRoutAllFlg( "N" );				
				}
				
				model[i].setDeltFlg( "N" );
				
				if( model[i].getIbflag().equals("I") && model[i].getRlt2().equals("") ){
					dbRowsetSeq = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new AgreementRailScgDBDAOSearchRailScgAgmtSeqRSQL(), null, null);
					if(dbRowsetSeq.next()) {
						model[i].setTrspAgmtScgSeq( String.valueOf( dbRowsetSeq.getInt(1) ) );
					}
					
					insertVoList.add(model[i]);					
				}else if( ( model[i].getIbflag().equals("I") && !model[i].getRlt2().equals("") ) ||
						  model[i].getIbflag().equals("U") ){
					updateVoList.add(model[i]);				
				}
				insertHisVoList.add(model[i]);
			}	
			
			// Fuel Surcharge History Insert
			if(insertHisVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAOMultiRailFuelFixScgAgmtHisCSQL(), insertHisVoList, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
			}
			
			// Fuel Surcharge Insert
			if(insertVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAOInsertRailFuelFixScgAgmtCSQL(), insertVoList, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
			}
			
			// Fuel Surcharge Update
			if(updateVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAOUpdateRailFuelScgAgmtUSQL(), updateVoList, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
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
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 삭제
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void deleteRailFuelScgAgmt(EsdTrs0223Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		List<RailSurchargeAgmtVO> deleteVoList = new ArrayList<RailSurchargeAgmtVO>();
		List<RailSurchargeAgmtVO> deleteHisVoList = new ArrayList<RailSurchargeAgmtVO>();
		
		RailSurchargeAgmtVO[] model = event.getRailSurchargeAgmtVos();
		
		int insCnt[] = null;
		
		try {	
			velParam.put("sUsrId", event.getSUsrId());
			velParam.put("sctrlOfcCd", event.getSctrlOfcCd());
			
			for( int i=0; i<model.length; i++ ) {
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new AgreementRailScgDBDAOSearchRailScgAgmtHisSeqRSQL(), null, null);
				if(dbRowset.next()) {
					model[i].setTrspAgmtRtHisSeq( String.valueOf( dbRowset.getInt(1) ) );
				}
						
				model[i].setTrspAgmtOfcCtyCd( model[i].getAgmtNo().substring(0, 3) );
				model[i].setTrspAgmtSeq( model[i].getAgmtNo().substring(3) );				
				model[i].setTrspRailScgCd( "FSG" );
				model[i].setCurrCd( "XXX" );
				
				if( model[i].getAgmtRoutAllFlg().equals("1") ){
					model[i].setAgmtRoutAllFlg( "Y" );
					model[i].setFmNodCd( "00" );
					model[i].setToNodCd( "00" );					
				}else{
					model[i].setAgmtRoutAllFlg( "N" );				
				}
				
				model[i].setDeltFlg( "Y" );
				
				deleteHisVoList.add(model[i]);
				deleteVoList.add(model[i]);
			}	
			
			// Fuel Surcharge History 삭제
			if(deleteHisVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAOMultiRailFuelFixScgAgmtHisCSQL(), deleteHisVoList, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
			}
			
			// Fuel Surcharge 삭제
			if(deleteVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAODeleteRailFuelFixScgAgmtDSQL(), deleteVoList, null);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
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
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRailFixScgAgmt(EsdTrs0223Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("fmAgmtNo", event.getFmAgmtNo());
			velParam.put("fmAgmtNo", event.getFmAgmtNo());
			
			param.put("railRoadCode", event.getRailRoadCode());
			velParam.put("railRoadCode", event.getRailRoadCode());
			
			param.put("effDt", event.getEffDt());
			velParam.put("effDt", event.getEffDt());
			
			param.put("agmtRefNo", event.getAgmtRefNo());
			velParam.put("agmtRefNo", event.getAgmtRefNo());
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementRailScgDBDAOSearchRailFixScgAgmtRSQL(), param, velParam);
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
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 저장
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multiRailFixScgAgmt(EsdTrs0223Event event) throws DAOException {
		DBRowSet dbRowset = null;
		DBRowSet dbRowsetSeq = null;		
		
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<RailSurchargeAgmtVO> insertVoList = new ArrayList<RailSurchargeAgmtVO>();
		List<RailSurchargeAgmtVO> updateVoList = new ArrayList<RailSurchargeAgmtVO>();
		List<RailSurchargeAgmtVO> insertHisVoList = new ArrayList<RailSurchargeAgmtVO>();
		
		RailSurchargeAgmtVO[] model = event.getRailSurchargeAgmtVos();
		
		int insCnt[] = null;
		
		try {
			velParam.put("sUsrId", event.getSUsrId());
			velParam.put("sctrlOfcCd", event.getSctrlOfcCd());
			
			for( int i=0; i<model.length; i++ ) {
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new AgreementRailScgDBDAOSearchRailScgAgmtHisSeqRSQL(), null, null);
				if(dbRowset.next()) {
					model[i].setTrspAgmtRtHisSeq( String.valueOf( dbRowset.getInt(1) ) );
				}
						
				model[i].setTrspAgmtOfcCtyCd( model[i].getAgmtNo().substring(0, 3) );
				model[i].setTrspAgmtSeq( model[i].getAgmtNo().substring(3) );
				
				if( model[i].getAgmtRoutAllFlg().equals("1") ){
					model[i].setAgmtRoutAllFlg( "Y" );
					model[i].setFmNodCd( "00" );
					model[i].setToNodCd( "00" );					
				}else{
					model[i].setAgmtRoutAllFlg( "N" );				
				}
				
				if( model[i].getCurrCd().equals("") ){
					model[i].setCurrCd( "XXX" );
				}
				
				model[i].setDeltFlg( "N" );
				
				if( model[i].getIbflag().equals("I") && model[i].getRlt2().equals("") ){
					dbRowsetSeq = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new AgreementRailScgDBDAOSearchRailScgAgmtSeqRSQL(), null, null);
					if(dbRowsetSeq.next()) {
						model[i].setTrspAgmtScgSeq( String.valueOf( dbRowsetSeq.getInt(1) ) );
					}
					
					insertVoList.add(model[i]);					
				}else if( ( model[i].getIbflag().equals("I") && !model[i].getRlt2().equals("") ) ||
							model[i].getIbflag().equals("U") ){
					updateVoList.add(model[i]);				
				}
				insertHisVoList.add(model[i]);
			}	
			
			// Fixed Surcharge Insert
			if(insertVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAOInsertRailFuelFixScgAgmtCSQL(), insertVoList, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
			}
			
			// Fixed Surcharge Update
			if(updateVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAOUpdateRailFixScgAgmtUSQL(), updateVoList, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
			}
			
			// Fixed Surcharge History Insert
			if(insertHisVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAOMultiRailFuelFixScgAgmtHisCSQL(), insertHisVoList, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
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
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 삭제
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void deleteRailFixScgAgmt(EsdTrs0223Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<RailSurchargeAgmtVO> deleteVoList = new ArrayList<RailSurchargeAgmtVO>();
		List<RailSurchargeAgmtVO> deleteHisVoList = new ArrayList<RailSurchargeAgmtVO>();
		
		RailSurchargeAgmtVO[] model = event.getRailSurchargeAgmtVos();
		
		int insCnt[] = null;
		
		try {	
			velParam.put("sUsrId", event.getSUsrId());
			velParam.put("sctrlOfcCd", event.getSctrlOfcCd());
			
			for( int i=0; i<model.length; i++ ) {
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new AgreementRailScgDBDAOSearchRailScgAgmtHisSeqRSQL(), null, null);
				if(dbRowset.next()) {
					model[i].setTrspAgmtRtHisSeq( String.valueOf( dbRowset.getInt(1) ) );
				}
						
				model[i].setTrspAgmtOfcCtyCd( model[i].getAgmtNo().substring(0, 3) );
				model[i].setTrspAgmtSeq( model[i].getAgmtNo().substring(3) );
				
				if( model[i].getAgmtRoutAllFlg().equals("1") ){
					model[i].setAgmtRoutAllFlg( "Y" );
					model[i].setFmNodCd( "00" );
					model[i].setToNodCd( "00" );					
				}else{
					model[i].setAgmtRoutAllFlg( "N" );					
				}
				
				if( model[i].getCurrCd().equals("") ){
					model[i].setCurrCd( "XXX" );
				}
				
				model[i].setDeltFlg( "Y" );
				
				deleteHisVoList.add(model[i]);
				deleteVoList.add(model[i]);
			}	
			
			// Fixed Surcharge History 삭제
			if(deleteHisVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAOMultiRailFuelFixScgAgmtHisCSQL(), deleteHisVoList, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
			}
			
			// Fixed Surcharge 삭제
			if(deleteVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAODeleteRailFuelFixScgAgmtDSQL(), deleteVoList, null);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
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
	 * Verify시 필요한 Sequence를 조회한다.<br>
	 *
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRailFuelFixScgAgmtVerifySeq() throws DAOException {
		DBRowSet dRs = null;
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementRailScgDBDAOSearchRailFuelFixScgAgmtVerifySeqRSQL(), null, null);
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
	 * Rail Surcharge AgreementFileImport 의 Verify 수행<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public EsdTrs0223Event insertRailFuelFixScgAgmtVerifyData(EsdTrs0223Event event) throws DAOException {
		List<RailSurchargeAgmtTmpVO> tmpVoList = new ArrayList<RailSurchargeAgmtTmpVO>();
		
		RailSurchargeAgmtTmpVO[] model = event.getRailSurchargeAgmtTmpVos();
		
		try{						
			for( int i=0; i<model.length; i++ ) {
				if( !model[i].getAgmtNo().equals("") ){
					model[i].setTrspAgmtOfcCtyCd( model[i].getAgmtNo().substring(0, 3) );
					model[i].setTrspAgmtSeq( model[i].getAgmtNo().substring(3) );					
				}				
				model[i].setAgmtRailTmpSeq(event.getAgmtRailTmpSeq());
				
				if( event.getScgKnd().equals("FSG") ){
					model[i].setTrspRailScgCd( "FSG" );					
				}
				
				if( model[i].getCurrCd().equals("") ){
					model[i].setCurrCd( "XXX" );
				}
				
				if( model[i].getAgmtRoutAllFlg().equals("1") ){
					model[i].setAgmtRoutAllFlg( "Y" );
					//model[i].setFmNodCd( "00" );
					//model[i].setToNodCd( "00" );					
				}else{
					model[i].setAgmtRoutAllFlg( "N" );					
				}
				
				tmpVoList.add(model[i]);
			}	
			
			new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementRailScgDBDAOInsertRailFuelFixScgAgmtVerifyDataCSQL(), tmpVoList, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return event;
	}
	
	/**
	 * Fuel Type AgreementFileImport 의 Verify 수행<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifyAgmtFuel(EsdTrs0223Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("agmtRailTmpSeq", event.getAgmtRailTmpSeq());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementRailScgDBDAOVerifyAgmtFuelRSQL(), param, param);
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
	 * Fix Type AgreementFileImport 의 Verify 수행<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifyAgmtFix(EsdTrs0223Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("agmtRailTmpSeq",event.getAgmtRailTmpSeq());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementRailScgDBDAOVerifyAgmtFixRSQL(), param, param);
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
	 * Rail Surcharge AgreementFileImport 의 Verify 수행<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public EsdTrs0223Event deleteRailFuelFixScgAgmtVerifyData(EsdTrs0223Event event) throws DAOException {		
		Map<String,Object> param = new HashMap<String,Object>();
		try{
			param.put("agmtRailTmpSeq", event.getAgmtRailTmpSeq());			
			
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new AgreementRailScgDBDAODeleteRailFuelFixScgAgmtVerifyDataDSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return event;
	}
	
	/**
	 * Agreement No 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAgmtNo(EsdTrs0233Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dRs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("comboSvcProvider", event.getComboSvcProvider());
			velParam.put("comboSvcProvider", event.getComboSvcProvider());
			
			param.put("agmtRefNo", event.getAgmtRefNo());
			velParam.put("agmtRefNo", event.getAgmtRefNo());
			
			param.put("ctrtOfcCd", event.getCtrtOfcCd());
			velParam.put("ctrtOfcCd", event.getCtrtOfcCd());
			
			param.put("agmt_no", event.getAgmtNo());
			velParam.put("agmt_no", event.getAgmtNo());
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementRailScgDBDAOSearchAgmtNoRSQL(), param, velParam);
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
	 * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge History 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRailScgAgmtHis(EsdTrs0234Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dRs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("fmYard", event.getFmYard());
			velParam.put("fmYard", event.getFmYard());
			
			param.put("toYard", event.getToYard());
			velParam.put("toYard", event.getToYard());
			
			param.put("fmEffDate", event.getFmEffDate());
			velParam.put("fmEffDate", event.getFmEffDate());
			
			param.put("toEffDate", event.getToEffDate());
			velParam.put("toEffDate", event.getToEffDate());
			
			if( event.getRouteAll().equals("") ){
				param.put("routeAll", "N");
				velParam.put("routeAll", "N");				
			}else{
				param.put("routeAll", event.getRouteAll());
				velParam.put("routeAll", event.getRouteAll());				
			}			
			
			param.put("selScg", event.getSelScg());
			velParam.put("selScg", event.getSelScg());
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementRailScgDBDAOSearchRailScgAgmtHisRSQL(), param, velParam);
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
	 * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge History Popup 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRailScgAgmtHisPop(EsdTrs0234Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dRs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("agmtOfcPop", event.getAgmtNoPop().substring(0, 3));
			velParam.put("agmtOfcPop", event.getAgmtNoPop().substring(0, 3));
			
			param.put("agmtSeqPop", event.getAgmtNoPop().substring(3));
			velParam.put("agmtSeqPop", event.getAgmtNoPop().substring(3));
			
			param.put("vndrSeqPop", event.getVndrSeqPop());
			velParam.put("vndrSeqPop", event.getVndrSeqPop());
			
			param.put("trspRailScgCdPop", event.getTrspRailScgCdPop());
			velParam.put("trspRailScgCdPop", event.getTrspRailScgCdPop());
			
			if( event.getAgmtRoutAllFlgPop().equals("1")){
				param.put("agmtRoutAllFlgPop", "Y");
				velParam.put("agmtRoutAllFlgPop", "Y");				
			}else{
				param.put("agmtRoutAllFlgPop", "N");
				velParam.put("agmtRoutAllFlgPop", "N");				
			}			
			
			if( event.getFmNodCdPop().equals("") ){
				param.put("fmNodCdPop", "00");
				velParam.put("fmNodCdPop", "00");
			}else{
				param.put("fmNodCdPop", event.getFmNodCdPop());
				velParam.put("fmNodCdPop", event.getFmNodCdPop());
			}
			
			if( event.getToNodCdPop().equals("") ){
				param.put("toNodCdPop", "00");
				velParam.put("toNodCdPop", "00");
			}else{
				param.put("toNodCdPop", event.getToNodCdPop());
				velParam.put("toNodCdPop", event.getToNodCdPop());
			}
			
			param.put("cgoTpCdPop", event.getCgoTpCdPop());
			velParam.put("cgoTpCdPop", event.getCgoTpCdPop());
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementRailScgDBDAOSearchRailScgAgmtHisPopRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
}