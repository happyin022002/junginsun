/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingCancelManageDBDAO.java
*@FileTitle : Rail Billing Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
* 2012.12.24 변종건 [CHM-201221767-01] Rail billing Cancel 로직 수정(TRS)
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.event.RailBillingCancelEvent;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see RailBillingCancelManageBCImpl 참조
 * @since J2EE 1.4
 */
public class RailBillingCancelManageDBDAO extends DBDAOSupport {
	
	//2012.12.24 변종건 [CHM-201221767-01] Rail billing Cancel 로직 수정(TRS)
	//기존 처리 로직 주석 처리( SPP를 통한 기존 Cancel 처리 기능을 블럭 처리하고 동일 명칭의 메소드로 새 소스 적용 - 유저의 원복 처리 요청이 있을 것을 대비함 )
//	/**
//	 * DB에 반영.(추가, 수정)<br>
//	 * 
//	 * @param et
//	 * @param z
//	 * @return
//	 * @throws DAOException
//	 */
//	public ArrayList multiCancelRailBillingList(Event et, int z) throws DAOException {		
//		// PDTO(Data Transfer Object including Parameters)
//		DBRowSet rs1 = null;
//		DBRowSet rs = null;
////		DBRowSet rs2 = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		RailBillingCancelEvent event = (RailBillingCancelEvent)et;
//		String[] sTrspSoOfcCtyCd 	 = event.getTrsp_so_ofc_cty_cd();
//		String[] sTrspSoSeq 	     = event.getTrsp_so_seq();	
//		String[] cxlRqstRsn 	     = event.getCxl_rqst_rsn();
//		String rVendorSeq	         = event.getVendor_seq();
//		
//		int j = 0; 							//TRSP_SO_SEQ 담는 객체
//		ArrayList arrSeq = new ArrayList(); //TRSP_SO_SEQ 넘기기 위한 객체
//		
//		try{
//			
//			if(rVendorSeq == null || rVendorSeq.equals("") ){ throw new Exception("VNDR_SEQ is mandatory"); }
//			if(sTrspSoOfcCtyCd[z] == null || sTrspSoOfcCtyCd[z].equals("") ){ throw new Exception("SO_NO is mandatory"); }
//			if(sTrspSoSeq[z] == null || sTrspSoSeq[z].equals("") ){ throw new Exception("SO_SEQUENCE is mandatory"); }
//			
//			param.put("vndrSeq", rVendorSeq);
//			velParam.put("vndrSeq", rVendorSeq);
//			
//			rs1 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingCancelManageDBDAOMultiCancelRailBillingListOfcCdRSQL(), param, velParam);
//			
//			if (rs1 != null && rs1.next()){		
//				
//				param.put("trspSoOfcCtyCd", sTrspSoOfcCtyCd[z]);
//				velParam.put("trspSoOfcCtyCd", sTrspSoOfcCtyCd[z]);
//				
//				param.put("trspSoSeq", sTrspSoSeq[z]);
//				velParam.put("trspSoSeq", sTrspSoSeq[z]);
//				
//				rs = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingCancelManageDBDAOMultiCancelRailBillingListSoSeqRSQL(), param, velParam);
//				
//				if (rs != null && rs.next() ) {				
//					arrSeq.add(j++, rs.getString("TRSP_SO_SEQ")); //TRSP_SO_SEQ : 객체를 넘긴다.
//					
//					// 분기 1-1. EDI 발송전 (Y 인 경우)
//					if (rs.getString("SPND_FLG") != null && rs.getString("SPND_FLG").equals("Y")) {
//						
//						param.put("ofcCd", rs1.getString("OFC_CD"));
//						velParam.put("ofcCd", rs1.getString("OFC_CD"));
//						
//						param.put("cxlRqstRsn", cxlRqstRsn[z]);
//						velParam.put("cxlRqstRsn", cxlRqstRsn[z]);
//						
//						new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSoUSQL(), param, velParam);						
//						
//						rs2 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSoRSQL(), param, velParam);
//						
//						String cgoTpCd = null; 
//						
//						if ( rs2 != null && rs2.next()) {								
//							cgoTpCd = rs2.getString("CGO_TP_CD");								
//							// 분기 2-1. (COP)
////							if( cgoTpCd != null && cgoTpCd.equals("F") ) {
////								
////							//	분기 2-2. (EQR_REPO_EXE_SO_IF)
////							} else 
//							if ( cgoTpCd != null && cgoTpCd.equals("M") ) {													
//								
//								new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailBillingCancelManageDBDAOMultiCancelRailBillingListEqrUSQL(), param, velParam);	
//							}
//						}
//						
//					// 분기 1-2. EDI 발송후 (Y 가 아닌 경우)	
//					} else { 		
//						
//						param.put("ofcCd", rs1.getString("OFC_CD"));
//						velParam.put("ofcCd", rs1.getString("OFC_CD"));
//						
//						param.put("cxlRqstRsn", cxlRqstRsn[z]);
//						velParam.put("cxlRqstRsn", cxlRqstRsn[z]);
//						
//						new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSo2USQL(), param, velParam);
////					} 												
//				}else {
//					throw new Exception("processing fail");		
//				}
//			} else {
//				 throw new Exception("OFC_CD is not valid");					
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(new ErrorHandler(e).getMessage(), e);
//		}	
//		return arrSeq;
//	}
	
	/**
	 * DB에 반영.(추가, 수정)<br>
	 * 
	 * @param et
	 * @param z
	 * @return
	 * @throws DAOException
	 */
	public ArrayList multiCancelRailBillingList(Event et, int z) throws DAOException {		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet rs1 = null;
		DBRowSet rs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		RailBillingCancelEvent event = (RailBillingCancelEvent)et;
		String[] sTrspSoOfcCtyCd 	 = event.getTrsp_so_ofc_cty_cd();
		String[] sTrspSoSeq 	     = event.getTrsp_so_seq();	
		String[] cxlRqstRsn 	     = event.getCxl_rqst_rsn();
		String rVendorSeq	         = event.getVendor_seq();
		
		int j = 0; 							//TRSP_SO_SEQ 담는 객체
		ArrayList arrSeq = new ArrayList(); //TRSP_SO_SEQ 넘기기 위한 객체
		
		try{
			
			if(rVendorSeq == null || rVendorSeq.equals("") ){ throw new Exception("VNDR_SEQ is mandatory"); }
			if(sTrspSoOfcCtyCd[z] == null || sTrspSoOfcCtyCd[z].equals("") ){ throw new Exception("SO_NO is mandatory"); }
			if(sTrspSoSeq[z] == null || sTrspSoSeq[z].equals("") ){ throw new Exception("SO_SEQUENCE is mandatory"); }
			
			param.put("vndrSeq", rVendorSeq);
			velParam.put("vndrSeq", rVendorSeq);
			
			rs1 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingCancelManageDBDAOMultiCancelRailBillingListOfcCdRSQL(), param, velParam);
			
			if (rs1 != null && rs1.next()){		
				
				param.put("trspSoOfcCtyCd", sTrspSoOfcCtyCd[z]);
				velParam.put("trspSoOfcCtyCd", sTrspSoOfcCtyCd[z]);
				
				param.put("trspSoSeq", sTrspSoSeq[z]);
				velParam.put("trspSoSeq", sTrspSoSeq[z]);
				
				rs = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingCancelManageDBDAOMultiCancelRailBillingListSoSeqRSQL(), param, velParam);
				
				if (rs != null && rs.next() ) {				
					arrSeq.add(j++, rs.getString("TRSP_SO_SEQ")); //TRSP_SO_SEQ : 객체를 넘긴다.

					param.put("ofcCd", rs1.getString("OFC_CD"));
					velParam.put("ofcCd", rs1.getString("OFC_CD"));
					
					param.put("cxlRqstRsn", cxlRqstRsn[z]);
					velParam.put("cxlRqstRsn", cxlRqstRsn[z]);
					
					new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSo2USQL(), param, velParam);
				}else {
					throw new Exception("processing fail");
				}
			} else {
				 throw new Exception("OFC_CD is not valid");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
		return arrSeq;
	}
}