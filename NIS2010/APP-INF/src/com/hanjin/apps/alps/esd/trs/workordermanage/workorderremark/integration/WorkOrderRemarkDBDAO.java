/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderRemarkDBDAO.java
*@FileTitle : Office별로 Cost/Trans Mode 및 IN/OUT Bound 별 W/O에 공통 적용할 비고 사항을 관리하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-08
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-11-08 poong_yeon
* 1.0 최초 생성
* 
* 2011.12.09 민정호 [CLT-111121293] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.event.EsdTrs0078Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.vo.WorkOrderRemarkVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * ESD-WorkOrderManage에 대한 DB 처리를 담당<br>
 * - ESD-WorkOrderManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong_yeon
 * @see WorkOrderRemarkBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderRemarkDBDAO extends DBDAOSupport {

	
	/**
	 * WorkOrderRemark의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 * @author choice
	 * @deprecated
	 */
	public DBRowSet searchWorkOrderRemark(EsdTrs0078Event event) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		HashMap hashParam = event.getHashParam();
//
//		StringBuffer queryStr = new StringBuffer();
//		
//		queryStr.append(" SELECT  															\n ");
//		queryStr.append(" WO_INSTR_OFC_CD												, 	\n ");
//		queryStr.append(" TRSP_BND_CD													, 	\n ");
//		queryStr.append(" TRSP_COST_MOD_CD												,	\n ");
//		queryStr.append(" TRSP_CRR_MOD_CD												, 	\n ");
//		queryStr.append(" WO_INSTR_RMK  												,	\n ");
//		queryStr.append(" TO_CHAR(UPD_DT, 'YYYYMMDD') CRE_DT 							,	\n ");
//		queryStr.append(" UPD_USR_ID CRE_USR_ID											,	\n ");
//		queryStr.append(" CRE_OFC_CD	  													\n ");
//		queryStr.append(" FROM TRS_TRSP_WRK_ORD_INSTR 										\n ");
//		queryStr.append(" WHERE WO_INSTR_OFC_CD			 							= ?		\n ");
//		/* 2008.04.29 ETS OPEN */
//		queryStr.append(" AND HJL_NO IS NULL												\n ");
//
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//			
//			// 쿼리에 변수 세팅. 
//			ps.setString(i++, (String) hashParam.get("FORM_USR_OFC_CD"));
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			rs = ps.executeQuery();
//
//			// 결과를 DBRowset에 담는다.
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return dRs;
		return null;		
	}

	/**
	 * WorkOrderRemark의 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * @param event 데이타 모델
	 * @throws DAOException
	 */
	public void addWorkOrderRemark(EsdTrs0078Event event) throws DAOException {
	}

	/**
	 * WorkOrderRemark의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param event 데이타 모델
	 * @throws DAOException
	 */
	public void modifyWorkOrderRemark(EsdTrs0078Event event) throws DAOException {
	}

	/**
	 * WorkOrderRemark의 데이타 모델을 DB에서 삭제한다.<br>
	 * 
	 * @param event 데이타 모델
	 * @throws DAOException
	 */
	public void removeWorkOrderRemark(EsdTrs0078Event event) throws DAOException {
		// INSERT / UPDATE / DELETE STORAGE
		Collection<WorkOrderRemarkVO> delModels = new ArrayList<WorkOrderRemarkVO>();
		
		// GRID ROWS DATA
		WorkOrderRemarkVO[]  multiVos  = event.getWorkOrderRemarkVOs();
		
		try{
			if( multiVos != null ){
				for( int i=0; i<multiVos.length; i++ ){
					if(multiVos[i].getIbflag().equals("D")){
						delModels.add(multiVos[i]);
					}
				}
			}
			//-----------------------------------------------------------------------------------------------------------------------------
			// START [ DELETE ]
			//-----------------------------------------------------------------------------------------------------------------------------
			int[] delCnt  = null;
			if( delModels.size() > 0 ){
				delCnt = new SQLExecuter("DEFAULT").executeBatch(new WorkOrderRemarkDBDAOMultiWorkOrderRemarkDSQL(), delModels, null, null);
			}
			if(delCnt != null){
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to DELETE No"+ i + " SQL");
					}
				}
			}
			//-----------------------------------------------------------------------------------------------------------------------------
			// END [ DELETE ]
			//-----------------------------------------------------------------------------------------------------------------------------
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * WorkOrderRemark의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event 여러 데이타 모델
	 * @see EsdTrs0078Event
	 * @throws DAOException
	 */
	public void multiWorkOrderRemark(EsdTrs0078Event event) throws DAOException {
		
		log.debug("\n\n :::::::::::::::::::::::: multiWorkOrderRemark ::::::::::::::::::::::: ");
		
		// INSERT / UPDATE / DELETE STORAGE
		Collection<WorkOrderRemarkVO> insModels = new ArrayList<WorkOrderRemarkVO>();
		Collection<WorkOrderRemarkVO> updModels = new ArrayList<WorkOrderRemarkVO>();
		Collection<WorkOrderRemarkVO> delModels = new ArrayList<WorkOrderRemarkVO>();
		
		// GRID ROWS DATA
		WorkOrderRemarkVO[]  multiVos  = event.getWorkOrderRemarkVOs();
		
		try{
			if( multiVos != null ){
				for( int i=0; i<multiVos.length; i++ ){
					if(multiVos[i].getIbflag().equals("I")){
						insModels.add(multiVos[i]);
					}
					if(multiVos[i].getIbflag().equals("U")){
						updModels.add(multiVos[i]);
					}
					if(multiVos[i].getIbflag().equals("D")){
						delModels.add(multiVos[i]);
					}
				}
			}
			//-----------------------------------------------------------------------------------------------------------------------------
			// START [ INSERT ] , [ UPDATE ] , [ DELETE ]
			//-----------------------------------------------------------------------------------------------------------------------------
			
			//INSERT-----------------------------------------------------------------------------------------------------------------------
			int[] insCnt  = null;
			if( insModels.size() > 0 ){
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new WorkOrderRemarkDBDAOMultiWorkOrderRemarkCSQL(), insModels, null, null);
			}
			if(insCnt != null){
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to INSERT No"+ i + " SQL");
					}
				}
			}
			//UPDATE-----------------------------------------------------------------------------------------------------------------------
			int[] updCnt  = null;
			if( updModels.size() > 0 ){
				updCnt = new SQLExecuter("DEFAULT").executeBatch(new WorkOrderRemarkDBDAOMultiWorkOrderRemarkUSQL(), updModels, null, null);
			}
			if(updCnt != null){
				for(int i=0;i<updCnt.length;i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to UPDATE No"+ i + " SQL");
					}
				}
			}
			//DELETE-----------------------------------------------------------------------------------------------------------------------
			int[] delCnt  = null;
			if( delModels.size() > 0 ){
				delCnt = new SQLExecuter("DEFAULT").executeBatch(new WorkOrderRemarkDBDAOMultiWorkOrderRemarkDSQL(), delModels, null, null);
			}
			if(delCnt != null){
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to DELETE No"+ i + " SQL");
					}
				}
			}
			//-----------------------------------------------------------------------------------------------------------------------------
			// END [ INSERT ] , [ UPDATE ] , [ DELETE ]
			//-----------------------------------------------------------------------------------------------------------------------------
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * WorkOrderRemark의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 * @author choice
	 * @since  2009.08.17
	 */
	public DBRowSet searchWorkOrderRemarkList(EsdTrs0078Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			WorkOrderRemarkVO workOrderRemarkVO = event.getWorkOrderRemarkVO();
			if( workOrderRemarkVO != null ){
				Map<String, String> condiParams = workOrderRemarkVO.getColumnValues();
				param.putAll(condiParams);
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new WorkOrderRemarkDBDAOSearchWorkOrderRemarkListRSQL(), param, param);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}
}
