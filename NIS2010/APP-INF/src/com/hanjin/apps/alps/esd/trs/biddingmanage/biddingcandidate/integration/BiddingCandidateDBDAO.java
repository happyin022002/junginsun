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
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.basic.BiddingCandidateBCImpl;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.event.EsdTrs0940Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.vo.SpotBidVndrVO;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.vo.SpotBidSoVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;

/**
 * Bidding Candidate 에 대한 DB 처리를 담당<br>
 * - Bidding Candidate Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHIN DONG IL
 * @see BiddingCandidateBCImpl 참조
 * @since J2EE 1.6
 */
public class BiddingCandidateDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Bidding Candidate 조회<br>
	 * 
	 * @param event EsdTrs0940Event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchBiddingCandidateList(EsdTrs0940Event event) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		SpotBidSoVO[] spotBidSoVOs = event.getSpotBidSoVOs();
		List<String> arr_so_no = new ArrayList();
        for(int i =0 ; i<spotBidSoVOs.length;i++){
			if(spotBidSoVOs[i].getSpotBidFlg().equals("Y")){
				arr_so_no.add(i,spotBidSoVOs[i].getTrspSoOfcCtyCd()+spotBidSoVOs[i].getTrspSoSeq());
			}
        }     
        
        param.put("usr_ofc_cd", event.getUsr_ofc_cd());
        param.put("tran_mod_cd", event.getSel_transmode());
        param.put("arr_so_no", arr_so_no);
	
		try {
			//S/O Route와 일치하는 S/O조회
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateDBDAOSearchBiddingCandidateRouteRSQL(), param, param);
			if(dbRowset.getRowCount()== 0){
				//S/O Route와 일치하지 한고 Trans mode만 일치하는 S/P조회				
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateDBDAOSearchBiddingCandidateListRSQL(), param, param);
			}
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
	 * Vendor  조회<br>
	 * 
	 * @param event EsdTrs0940Event
	 * @return dbRowset DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInvitationVendor(EsdTrs0940Event event) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        param.put("vndr_seq", event.getVndr_seq());
	
		try {
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateDBDAOSearchInvitationVendorRSQL(), param, param);
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
	 * ESD_TRS_0940 OK Event처리 
	 * Spot Bidding data생성
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount 
	 * @exception DAOException
	 */
	public void multiSpotBidManage(Event e,SignOnUserAccount account) throws DAOException{
		EsdTrs0940Event event = (EsdTrs0940Event)e;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> paramVndr = new HashMap<String, Object>();
		
		try {
			SpotBidSoVO[] spotBidSoVOs = event.getSpotBidSoVOs();
			SpotBidVndrVO[] spotBidVndrVOs = event.getSpotBidVndrVOs();
			String vndr_valid_flg = "Y";
			for(int i =0 ; i<spotBidSoVOs.length;i++){

					String spot_bid_no = "";
					param.put("cre_ofc_cd",account.getOfc_cd());
					param.put("trsp_so_ofc_cty_cd", spotBidSoVOs[i].getTrspSoOfcCtyCd());
					param.put("trsp_so_seq", 	 spotBidSoVOs[i].getTrspSoSeq());
					//Spot Bid No 채번
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateDBDAOSearchBiddingNoRSQL(), param, param);
					
					while(dbRowset.next()){
						spot_bid_no = dbRowset.getString("SPOT_BID_NO");
					}
					param.put("spot_bid_no",	spot_bid_no);
					param.put("spot_bid_flg", 	spotBidSoVOs[i].getSpotBidFlg());
					param.put("spot_bid_due_dt",spotBidSoVOs[i].getSpotBidDueDt()+spotBidSoVOs[i].getSpotBidDueDtHms());
					param.put("usr_id", 		account.getUsr_id());
	
					//Service Order Update
					new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new BiddingCandidateDBDAOModifySvcOrdSpotBiddingCandidateUSQL(), param, param);
					
					//SPOT BID DATA INSERT
					new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new BiddingCandidateDBDAOInsertSpotBidCSQL(), param, param);
					
					for(int k=0; k< spotBidVndrVOs.length;k++){
						if(vndr_valid_flg.equals("Y")){
							//SPOT BID VENDOR DATA INSERT	
							paramVndr.put("trsp_so_ofc_cty_cd", spotBidSoVOs[i].getTrspSoOfcCtyCd());
							paramVndr.put("trsp_so_seq", 	 	spotBidSoVOs[i].getTrspSoSeq());
							paramVndr.put("spot_bid_no", 		spot_bid_no);
							paramVndr.put("vndr_seq", 	 		spotBidVndrVOs[k].getVndrSeq());
							paramVndr.put("cre_ofc_cd",  		account.getOfc_cd());
							paramVndr.put("usr_id",      		account.getUsr_id());
							paramVndr.put("trsp_crr_mod_cd",	spotBidVndrVOs[k].getTrspCrrModCd());
							paramVndr.put("fm_nod_cd",	 		spotBidVndrVOs[k].getFmNodCd());
							paramVndr.put("via_nod_cd",	 		spotBidVndrVOs[k].getViaNodCd());
							paramVndr.put("dor_nod_cd",	 		spotBidVndrVOs[k].getDorNodCd());
							paramVndr.put("to_nod_cd",	 		spotBidVndrVOs[k].getToNodCd());
							new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new BiddingCandidateDBDAOInsertSpotBidVndrCSQL(), paramVndr, paramVndr);
						}
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
	 * @param spotBidVndrVO SpotBidVndrVO
	 * @param spotBidSoVOs SpotBidSoVO[]
	 * @param account SignOnUserAccount
	 * @return dbRowset DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet multiSpotBiddingInvitationSoList(SpotBidVndrVO spotBidVndrVO, SpotBidSoVO[] spotBidSoVOs,SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		DBRowSet dbRowsetClone = null;
		List<String> arr_so_no = new ArrayList();
	
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> paramIns = new HashMap<String, Object>();
        
        for(int i =0 ; i<spotBidSoVOs.length;i++){
			if(spotBidSoVOs[i].getSpotBidFlg().equals("Y")){
				arr_so_no.add(i,spotBidSoVOs[i].getTrspSoOfcCtyCd()+spotBidSoVOs[i].getTrspSoSeq());
			}
        }
        
        param.put("arr_so_no", arr_so_no);
	
		try {
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateDBDAOSearchBiddingInvitationSoListRSQL(), param, param);
			dbRowsetClone = (DBRowSet) dbRowset.clone();
			while(dbRowset.next()){
				paramIns.put("spot_bid_no",				dbRowset.getString("SPOT_BID_NO"));
				paramIns.put("spot_bid_cnddt_term_seq",	spotBidVndrVO.getSpotBidCnddtTermSeq());
				paramIns.put("vndr_seq",				spotBidVndrVO.getVndrSeq());
				paramIns.put("modi_spot_bid_vndr_eml",	spotBidVndrVO.getVndrEmlAddr());
				paramIns.put("cre_ofc_cd",				account.getOfc_cd());
				paramIns.put("usr_id",					account.getUsr_id());
				paramIns.put("trsp_so_ofc_cty_cd",		dbRowset.getString("TRSP_SO_OFC_CTY_CD"));
				paramIns.put("trsp_so_seq",				dbRowset.getString("TRSP_SO_SEQ"));
				paramIns.put("trsp_crr_mod_cd",			spotBidVndrVO.getTrspCrrModCd());
				paramIns.put("fm_nod_cd",	 			spotBidVndrVO.getFmNodCd());
				paramIns.put("via_nod_cd",	 			spotBidVndrVO.getViaNodCd());
				paramIns.put("dor_nod_cd",	 			spotBidVndrVO.getDorNodCd());
				paramIns.put("to_nod_cd",	 			spotBidVndrVO.getToNodCd());
				  
				new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new BiddingCandidateDBDAOInsertSpotBiddingInvitationCSQL(), paramIns, paramIns); 
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowsetClone;
	}	
	
	/**
	 * Bidding Candidate 조회<br>
	 * 
	 * @param singleTransportationVOS singleTransportationVOS
	 * @return dbRowset DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpotBiddingInvataionVndr(SingleTransportationVO[] singleTransportationVOS) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        List<String> arr_bid_no = new ArrayList();
        int arr_cnt = 0;
        for(int i=0; i<singleTransportationVOS.length;i++){
        	if(singleTransportationVOS[i].getSpotBidFlg().equals("Y")){
        		arr_bid_no.add(arr_cnt,singleTransportationVOS[i].getSpotBidNo());
        		arr_cnt++;
        	}
        }
        param.put("arr_bid_no", arr_bid_no);
	
		try {
			if(arr_bid_no.size() > 0){
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateDBDAOSearchSpotBiddingInvataionVndrRSQL(), param, param);
			}
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
	 * @param singleTransportationVOS singleTransportationVOS
	 * @param account SignOnUserAccount
	 * @return upd_cnt Integer
	 * @throws DAOException
	 */
	public Integer modifySpotBiddingStatus(SingleTransportationVO[] singleTransportationVOS,SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        List<String> arr_bid_no = new ArrayList(); 
        int upd_cnt = 0; 
        int arr_cnt = 0;
        for(int i=0; i<singleTransportationVOS.length;i++){
        	if(singleTransportationVOS[i].getSpotBidFlg().equals("Y")){
        		arr_bid_no.add(arr_cnt,singleTransportationVOS[i].getSpotBidNo());
        		arr_cnt++;
        	}
        }
        param.put("arr_bid_no", arr_bid_no);
        param.put("usr_id",account.getUsr_id());

		try {
			if(arr_bid_no.size() > 0){
			 upd_cnt =	new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new BiddingCandidateDBDAOModifySpotBiddingStatusUSQL(), param, param);
			}
		return upd_cnt;
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
	 * @param singleTransportationVOS singleTransportationVOS
	 * @param vndr_seq String
	 * @return dbRowset DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpotBiddingCancelContents(SingleTransportationVO[] singleTransportationVOS,String vndr_seq) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        List<String> arr_bid_no = new ArrayList(); 
        int arr_cnt = 0;
        for(int i=0; i<singleTransportationVOS.length;i++){
        	if(singleTransportationVOS[i].getSpotBidFlg().equals("Y")){
        		arr_bid_no.add(arr_cnt,singleTransportationVOS[i].getSpotBidNo());
        		arr_cnt++;
        	}
        }
        param.put("arr_bid_no", arr_bid_no);
        param.put("vndr_seq",vndr_seq);
	
		try {
			if(arr_bid_no.size() > 0){
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateDBDAOSearchSpotBiddingCancelContentsRSQL(), param, param);
			}
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
	 * @param vndr_seq String 
	 * @param dbRowset DBRowSet
	 * @return dbRowset DBRowSet
	 * @throws DAOException
	 */
	public String searchInvitationVendorReceiveEmail(String vndr_seq,DBRowSet dbRowset) throws DAOException {
		DBRowSet rowSet = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        List<String> arr_bid_no = new ArrayList(); 
        String vndr_eml_addr = "";
        int arr_cnt = 0;
        
        try {
			while(dbRowset.next()){
				if(!dbRowset.getString("SPOT_BID_NO").equals("")){
					arr_bid_no.add(arr_cnt,dbRowset.getString("SPOT_BID_NO"));
					arr_cnt++;
				}
			}
			
	        param.put("vndr_seq",vndr_seq);
	        param.put("arr_bid_no", arr_bid_no);
	        
			if(arr_bid_no.size() > 0){
				rowSet = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateDBDAOSearchSpotBiddingCancelReceiverRSQL(), param, param);
				while(rowSet.next()){
					vndr_eml_addr = rowSet.getString("VNDR_EML_ADDR");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vndr_eml_addr;
	}
			
	
	/**
	 * Bidding Candidate 조회<br>
	 * 
	 * @param singleTransportationVOS singleTransportationVOS
	 * @param vndr_seq String 
	 * @return dbRowset DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpotBiddingCancelReceiver(SingleTransportationVO[] singleTransportationVOS,String vndr_seq) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        List<String> arr_bid_no = new ArrayList(); 
        int arr_cnt = 0;
        
        for(int i=0; i<singleTransportationVOS.length;i++){
        	if(singleTransportationVOS[i].getSpotBidFlg().equals("Y")){
        		arr_bid_no.add(arr_cnt,singleTransportationVOS[i].getSpotBidNo());
        		arr_cnt++;
        	}
        }
        param.put("arr_bid_no", arr_bid_no);
        param.put("vndr_seq",vndr_seq);
	
		try {
			if(arr_bid_no.size() > 0){
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BiddingCandidateDBDAOSearchSpotBiddingCancelReceiverRSQL(), param, param);
			}
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
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return arrlist
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
	

}