/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : BiddingCandidateDBDAO.java
 *@FileTitle :Bidding Candidate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.01
 *@LastModifier : SHIN DONG IL
 *@LastVersion : 1.0
 * 2015.06.01 SHIN DONG IL
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.basic.BiddingCandidateRegistrationBCImpl;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.event.EsdTrs0300Event;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.vo.BiddingCandidateRegistrationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * Bidding Candidate 에 대한 DB 처리를 담당<br>
 * - Bidding Candidate Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHIN DONG IL
 * @see BiddingCandidateRegistrationBCImpl 참조
 * @since J2EE 1.6
 */
public class BiddingCandidateRegistrationDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e EsdTrs0300Event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchSpotBidCnddtTermList(EsdTrs0300Event e) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        String spotBidOfcCd = e.getSpotBidOfcCd();
        String trspCrrModCd = e.getTrspCrrModCd();
        
        List<String> listSpotBidOfcCd = new ArrayList();
	
		try {
			
			if(!spotBidOfcCd.equals("")){
				String arrSpotBidOfcCd[] = spotBidOfcCd.split(",");
				for(int i=0;i<arrSpotBidOfcCd.length;i++){   
					listSpotBidOfcCd.add(arrSpotBidOfcCd[i]);   
				} 
			}
			param.put("spot_bid_ofc_cd", listSpotBidOfcCd);
			param.put("trsp_crr_mod_cd", trspCrrModCd);
			
			//dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtTermListRSQL(), param, param);
			dbRowset = new SQLExecuter("").executeQuery(new BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtTermListRSQL(), param, param);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e EsdTrs0300Event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchSpotBidCnddtVndrList(EsdTrs0300Event e) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        String spotBidCnddtTermSeq = e.getSpotBidCnddtTermSeq();
        String vndrSeq = e.getVndrSeq();
	
		try {
			param.put("spot_bid_cnddt_term_seq", spotBidCnddtTermSeq);
			param.put("vndr_seq", vndrSeq);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtVndrListRSQL(), param, param);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e EsdTrs0300Event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public void addSpotBidCnddtTerm(EsdTrs0300Event e) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        String spotBidOfcCd = e.getSpotBidOfcCd();
        String trspCrrModCd = e.getTrspCrrModCd();
	
		try {
			BiddingCandidateRegistrationVO[] model = e.getBiddingCandidateRegistrationVOs();
			
			//dbRowset = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermCSQL(), param, param);
			
			
			if( model != null && model.length > 0 ){								
				for( int i=0; i<model.length; i++ ){
					//if(!(model[i].getCurrCd().equalsIgnoreCase(model[i].getOrgCurrCd()) && model[i].getNegoAmt().equalsIgnoreCase(model[i].getOrgNegoAmt()))){

					param.clear();

					param.put("cre_ofc_cd",	e.getCreOfcCd());
					param.put("cre_usr_id",	e.getCreUsrId());

					param.put("spot_bid_ofc_cd",	model[i].getSpotBidOfcCd());		
					param.put("trsp_crr_mod_cd",	model[i].getTrspCrrModCd());					
					param.put("fm_nod_cd",			model[i].getFmNodCd());
					param.put("via_nod_cd",			model[i].getViaNodCd());
					param.put("dor_nod_cd",			model[i].getDorNodCd());
					param.put("to_nod_cd",			model[i].getToNodCd());

					/***** WorkOrderPreviewTemp Insert 시작*****/
					int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermCSQL(), param, param);

					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");
					}
					
					// History
					if(insCnt > 0){
						int intHisCnt = new SQLExecuter("DEFAULT").executeUpdate(new BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermHisCSQL(), param, param);
						
						if(intHisCnt == Statement.EXECUTE_FAILED){
							throw new DAOException("Fail to insert SQL");
						}
					} else {
						//throw new EventException(new ErrorHandler("TRS50104").getMessage());
						throw new DAOException("Duplicated data exists.");
					}
					/***** WorkOrderPreviewTemp Insert 끝*****/	
					//}
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
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e EsdTrs0300Event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public void delSpotBidCnddtTerm(EsdTrs0300Event e) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        String spotBidOfcCd = e.getSpotBidOfcCd();
        String trspCrrModCd = e.getTrspCrrModCd();
	
		try {
			BiddingCandidateRegistrationVO[] model = e.getBiddingCandidateRegistrationVOs();
			
			//dbRowset = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermCSQL(), param, param);
			
			
			if( model != null && model.length > 0 ){								
				for( int i=0; i<model.length; i++ ){
					//if(!(model[i].getCurrCd().equalsIgnoreCase(model[i].getOrgCurrCd()) && model[i].getNegoAmt().equalsIgnoreCase(model[i].getOrgNegoAmt()))){

					param.clear();

					param.put("cre_ofc_cd",	e.getCreOfcCd());
					param.put("cre_usr_id",	e.getCreUsrId());

					param.put("spot_bid_cnddt_term_seq",	model[i].getSpotBidCnddtTermSeq());

					/***** WorkOrderPreviewTemp Insert 시작*****/
					
					int insVndrCnt = new SQLExecuter("DEFAULT").executeUpdate(new BiddingCandidateRegistrationDBDAOdelSpotBidCnddtVndrUSQL(), param, param);
					
					
					int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new BiddingCandidateRegistrationDBDAOdelSpotBidCnddtTermUSQL(), param, param);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");
					}
					/***** WorkOrderPreviewTemp Insert 끝*****/	
					//}
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
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e EsdTrs0300Event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public void addSpotBidCnddtVndr(EsdTrs0300Event e) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        String spotBidOfcCd = e.getSpotBidOfcCd();
        String trspCrrModCd = e.getTrspCrrModCd();
	
		try {
			BiddingCandidateRegistrationVO[] model = e.getBiddingCandidateRegistrationVOs();

			if( model != null && model.length > 0 ){								
				for( int i=0; i<model.length; i++ ){
					//if(!(model[i].getCurrCd().equalsIgnoreCase(model[i].getOrgCurrCd()) && model[i].getNegoAmt().equalsIgnoreCase(model[i].getOrgNegoAmt()))){

					param.clear();

					param.put("cre_ofc_cd",	e.getCreOfcCd());
					param.put("cre_usr_id",	e.getCreUsrId());

					param.put("spot_bid_cnddt_term_seq",	model[i].getSpotBidCnddtTermSeq());		
					param.put("vndr_seq",					model[i].getVndrSeq());					
					param.put("spot_bid_vndr_eml",			model[i].getSpotBidVndrEml());
					param.put("sp_ptal_exist_flg",			model[i].getSpPtalExistFlg());

					/***** WorkOrderPreviewTemp Insert 시작*****/
					int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new BiddingCandidateRegistrationDBDAOaddSpotBidCnddtVndrCSQL(), param, param);

					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");
					}
					
					if(insCnt > 0){
						int insHisCnt = new SQLExecuter("DEFAULT").executeUpdate(new BiddingCandidateRegistrationDBDAOaddSpotBidCnddtVndrHisCSQL(), param, param);
						
						if(insHisCnt == Statement.EXECUTE_FAILED){
							throw new DAOException("Fail to insert SQL");
						}
					}
					
					/***** WorkOrderPreviewTemp Insert 끝*****/	
					//}
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
	 * Bidding Candidate 조회<br>
	 * 
	 * @param e EsdTrs0300Event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public void delSpotBidCnddtVndr(EsdTrs0300Event e) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        String spotBidOfcCd = e.getSpotBidOfcCd();
        String trspCrrModCd = e.getTrspCrrModCd();
	
		try {
			BiddingCandidateRegistrationVO[] model = e.getBiddingCandidateRegistrationVOs();
			
			//dbRowset = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermCSQL(), param, param);
			
			
			if( model != null && model.length > 0 ){								
				for( int i=0; i<model.length; i++ ){
					//if(!(model[i].getCurrCd().equalsIgnoreCase(model[i].getOrgCurrCd()) && model[i].getNegoAmt().equalsIgnoreCase(model[i].getOrgNegoAmt()))){

					param.clear();

					param.put("cre_ofc_cd",	e.getCreOfcCd());
					param.put("cre_usr_id",	e.getCreUsrId());

					param.put("spot_bid_cnddt_term_seq",	model[i].getSpotBidCnddtTermSeq());
					param.put("vndr_seq",					model[i].getVndrSeq());

					/***** WorkOrderPreviewTemp Insert 시작*****/

					int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new BiddingCandidateRegistrationDBDAOdelSpotBidCnddtVndrUSQL(), param, param);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");
					}
					/***** WorkOrderPreviewTemp Insert 끝*****/	
					//}
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
}