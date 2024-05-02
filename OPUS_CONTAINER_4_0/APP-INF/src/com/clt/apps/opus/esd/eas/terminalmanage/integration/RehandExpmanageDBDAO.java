/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RehandExpmanageDBDAO.java
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-04
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2008-01-04 Jun Ho Kim
* 1.0 최초 생성
* 2010.09.01 박성진 [소스품질] 주석 및 변수 변경
=========================================================*/
package com.clt.apps.opus.esd.eas.terminalmanage.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.eas.terminalmanage.basic.RehandExpmanageBCImpl;
import com.clt.apps.opus.esd.eas.terminalmanage.event.EsdEas0001Event;
import com.clt.apps.opus.esd.eas.terminalmanage.event.EsdEas0901Event;
import com.clt.apps.opus.esd.eas.terminalmanage.vo.TrsExpnAudRmkVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-RehandExpmanage에 대한 DB 처리를 담당<br>
 * - ENIS-RehandExpmanage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jun Ho Kim
 * @see RehandExpmanageBCImpl 참조
 * @since J2EE 1.4
 */
public class RehandExpmanageDBDAO extends DBDAOSupport {

	/**
	 * SpecialSOCheck의 모든 목록을 가져온다.<br>
	 * 
	 * @param EsdEas0001Event event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRehandTPBCheckList(EsdEas0001Event event) throws DAOException {
		DBRowSet dRs = null;
		try {
		
			String input_port		=  null;
			String input_fmMonth  	=  null;
			String input_toMonth    =  null;
			String input_office  	=  null;
			String input_vvd 		=  null;
			
			input_port    	=  event.getPort();
			input_fmMonth	=  event.getFmMonth();
			input_toMonth 	=  event.getToMonth();
			input_office   	=  event.getOffice();
			input_vvd     	=  event.getVvd();
			
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("input_port",input_port);
			param.put("input_fmMonth",input_fmMonth);
			param.put("input_toMonth",input_toMonth);
			param.put("input_office",input_office);
			param.put("input_vvd",input_vvd);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL template = new RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);	
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
		return dRs;
	}
	
	
	/**
	 * Expense Audit Remark 조회.<br>
	 * 
	 * @param EsdEas0901Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRehandExpnAudRmk(EsdEas0901Event event) throws DAOException {

		DBRowSet dRs = null;
		try {
			
//			TrsExpnAudRmkVO [] TrsExpnAudRmkVOs = event.getTrsExpnAudRmkVOs();
			String bkgNo		=  null;
			String expntpcd  	=  null;
//			int i = TrsExpnAudRmkVOs.length;
//
//			log.info("여기여기:::"+i);
//			bkgNo    	=  TrsExpnAudRmkVOs[i].getBkgNo();
//			expntpcd	=  TrsExpnAudRmkVOs[i].getEasExpnTpCd();

			bkgNo    	=  event.getBkgNo();
			expntpcd	=  event.getExpnTpCd();
			
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkgno",bkgNo);
			param.put("expntpcd",expntpcd);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			RehandExpmanageDBDAOsearchRehandExpnAudRmkRSQL template = new RehandExpmanageDBDAOsearchRehandExpnAudRmkRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);	
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
		return dRs;
	}
	
	/**
	 * Expense Audit Remark 추가/수정. 4341.11.24<br>
	 * 
	 * @param EsdEas0901Event event 
	 * @throws DAOException
	 */
	public void multiRehandExpnAudRmk(EsdEas0901Event event) throws DAOException {

		DBRowSet dRs = null;
		int iSeq = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsExpnAudRmkVO [] trsExpnAudRmkVOs = event.getTrsExpnAudRmkVOs();
		
		try {	
			for(int f=0; trsExpnAudRmkVOs != null && f < trsExpnAudRmkVOs.length; f++){
			
				param.put("bkgno",trsExpnAudRmkVOs[f].getBkgNo());
				param.put("expntpcd",trsExpnAudRmkVOs[f].getEasExpnTpCd());
		
				dRs = new SQLExecuter().executeQuery(new RehandExpmanageDBDAOmultiRehandExpnAudRmkSeqRSQL(), param,param);
			
				if(dRs.next()){
				iSeq	= dRs.getInt("RMKSEQ"); 
				}
				param.put("bkgno",trsExpnAudRmkVOs[f].getBkgNo());
				param.put("expntpcd",trsExpnAudRmkVOs[f].getEasExpnTpCd());
				param.put("creofc",trsExpnAudRmkVOs[f].getCreOfcCd());
				param.put("creusrid",trsExpnAudRmkVOs[f].getUpdUsrId());
				param.put("updusrid",trsExpnAudRmkVOs[f].getUpdUsrId());
				param.put("ctnt",trsExpnAudRmkVOs[f].getRmkCtnt());
				String opCode = trsExpnAudRmkVOs[f].getOpCode();

				if(opCode.equals("U")){
			
					param.put("etntseq",trsExpnAudRmkVOs[f].getRmkCtntSeq());
								
					new SQLExecuter().executeUpdate(new RehandExpmanageDBDAOmultiRehandExpnAudRmkInsUpdUSQL(), param,param);
				}else if(opCode.equals("I")){
			
					param.put("etntseq", iSeq );		
						
					new SQLExecuter().executeUpdate(new RehandExpmanageDBDAOmultiRehandExpnAudRmkInsCSQL(), param,param);
				}
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
	}
	
	
}