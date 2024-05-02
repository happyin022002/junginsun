/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : USATruckWoAckManageDBDAO.java
*@FileTitle : USATruck WO 신고 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-08
*@LastModifier : Park Jun-Yong
*@LastVersion : 1.0
* 2008-07-08 Park Jun-Yong
* 1.0 최초 생성
* N200903270090_테스트 결과서(TD담당)_ AFTT 990 개발 및 204 보완 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetail;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailList;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0002Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration.WorkOrderDetailDBDAOsearchWorkOrderDetailRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Jun-Yong
 * @see USATruckWoAckManageBCImpl 참조
 * @since J2EE 1.4
 */
public class USATruckEdiWoAckManageDBDAO extends DBDAOSupport {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param edi_ctrl_seq
	 * @param edi_rcv_rslt_cd
	 * @return
	 * @throws DAOException
	 */
	public int addUSATruckEdiWoAckManageList(String edi_ctrl_seq, String edi_rcv_rslt_cd) throws DAOException {
				  
		int resultCount1 = 0;
		DBRowSet rs = null;
	
		try {
			if(edi_ctrl_seq == null || edi_ctrl_seq.equals("") ){ throw new Exception("EDI_CTRL_SEQ is mandatory"); }										
			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("edi_ctrl_seq", edi_ctrl_seq);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USATruckEdiWoAckManageDBDAOaddUSATruckEdiWoAckManageListRSQL template = new USATruckEdiWoAckManageDBDAOaddUSATruckEdiWoAckManageListRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);
			
			if ( rs!= null && rs.next()){
				if (searchUSATruckEdiWoAckManageList(edi_ctrl_seq)){	
					Map<String, Object> uparam = new HashMap<String, Object>();
					uparam.put("edi_rcv_rslt_cd", edi_rcv_rslt_cd);
					uparam.put("cre_ofc_cd", rs.getString("CRE_OFC_CD"));
					if("214".equals(rs.getString("EDI_RCV_MSG_TP_CD"))){
						uparam.put("edi_rcv_msg_tp_cd", rs.getString("EDI_RCV_MSG_TP_CD"));
					}else{
						uparam.put("edi_rcv_msg_tp_cd", "997");				
					}	
					uparam.put("edi_ctrl_seq",edi_ctrl_seq);
					USATruckEdiWoAckManageDBDAOaddUSATruckEdiWoAckManageListUSQL utemplate = new USATruckEdiWoAckManageDBDAOaddUSATruckEdiWoAckManageListUSQL();	        
					resultCount1 = sqlExe.executeUpdate(utemplate,uparam,uparam);
				} else {
					throw new Exception("edi_ctrl_seq data does not exist.");
				}		
				
				log.info(" resultCount1 : " + resultCount1);
				 
				if (resultCount1 <  0) {
					throw new DAOException("processing fail");
					//throw new DAOException(new ErrorHandler("COM11001").getMessage());
				}			
			}			
							
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		
		return resultCount1; 
	}

	/**
	 *  ReceiveInterface(Receive) 처리한다.<br>
	 * - N200903270090_테스트 결과서(TD담당)_ AFTT 990 개발 및 204 보완 요청
	 * 
	 * @param edi_so_no
	 * @param edi_rcv_rslt_cd
	 * @return
	 * @throws DAOException
	 */
	public int addUSATruckEdi990WoAckManageList(String edi_so_no, String edi_rcv_rslt_cd) throws DAOException {
				  
		int resultCount1 = 0; 
		// Connection Interface  	
		DBRowSet rs = null;
		try {		
			if(edi_so_no == null || edi_so_no.equals("") ){ throw new Exception("EDI_CTRL_SEQ is mandatory"); }										

			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("edi_so_no", edi_so_no);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListRSQL template = new USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);
			
			if ( rs!= null && rs.next()){
					Map<String, Object> uparam = new HashMap<String, Object>();
					uparam.put("edi_rcv_rslt_cd", edi_rcv_rslt_cd);
					uparam.put("cre_ofc_cd", rs.getString("CRE_OFC_CD"));
					if("214".equals(rs.getString("EDI_RCV_MSG_TP_CD"))){
						uparam.put("edi_rcv_msg_tp_cd", rs.getString("EDI_RCV_MSG_TP_CD"));
					}else{
						uparam.put("edi_rcv_msg_tp_cd","990");
					}		
					uparam.put("edi_so_no", edi_so_no);
					USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListUSQL utemplate = new USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListUSQL();	        
					resultCount1 = sqlExe.executeUpdate(utemplate,uparam,uparam); 					
					
				} else {
					throw new Exception("SO_NO data does not exist.");
				}
			
				log.info(" resultCount1 : " + resultCount1);
				 
				if (resultCount1 <  0) {
					throw new DAOException("processing fail");
					//throw new DAOException(new ErrorHandler("COM11001").getMessage());
				}			
						
							
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		
		return resultCount1; 
	}

	
	/**
	 * USATruckEdiWoAckManageList<br>
	 * 
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchUSATruckEdiWoAckManageList(String pk1) throws DAOException{
		boolean isSuccessful = false;
		DBRowSet rs = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("edi_ctrl_seq", pk1);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			USATruckEdiWoAckManageDBDAOsearchUSATruckEdiWoAckManageListRSQL template = new USATruckEdiWoAckManageDBDAOsearchUSATruckEdiWoAckManageListRSQL();	        
			rs = sqlExe.executeQuery(template,param,null);            

			if ( rs!= null && rs.next()){
				log.debug("rs.getString(1) : "+rs.getString(1));
				if( !rs.getString(1).equals("0") ){
					isSuccessful = true;
				} else {
					throw new Exception("NOT EXISTS IN TRS 204 TRUCK EDI HISTORY.");
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
		return isSuccessful;	
	}
	
	
	/**
	 * W/O No 조회.<br>
	 * 
	 * @param ackhd
	 * @param edi_ctrl_seq
	 * @param edi_so_no
	 * @return
	 * @throws DAOException
	 */
	public String searchWorkOrderNo(String ackhd, String edi_ctrl_seq, String edi_so_no) throws DAOException {
		String trsp_wo_no = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
	    Map<String, Object> velParam = new HashMap<String, Object>();
		try{
            velParam.put("ackhd", ackhd );
			param.put("edi_ctrl_seq", edi_ctrl_seq );
			param.put("edi_so_no", edi_so_no );
			
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		USATruckEdiWoAckManageDBDAOsearchWorkOrderNoRSQL template = new USATruckEdiWoAckManageDBDAOsearchWorkOrderNoRSQL();	        
    		dbRowset = sqlExe.executeQuery(template,param,velParam);
    		
			if( dbRowset.next()){
				trsp_wo_no = dbRowset.getString("TRSP_WO_NO");
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
		
		return trsp_wo_no;
	}
	
	
    /**
     * searchWorkOrderPeriodList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param trsp_wo_no
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchWorkOrderDetailList(String trsp_wo_no) throws DAOException {
        Object[] result = new Object[2];
        DBRowSet rs = null;
        try {
			String r_trsp_wo_no	= trsp_wo_no;
			String r_trsp_wo_seq = "";
			if(r_trsp_wo_no != null && r_trsp_wo_no.length() > 4) {
				r_trsp_wo_seq = r_trsp_wo_no.substring(3,r_trsp_wo_no.length());
				r_trsp_wo_no = r_trsp_wo_no.substring(0,3);
			}
					
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no);
    		param.put("trsp_wo_seq", r_trsp_wo_seq);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		USATruckEdiWoAckManageDBDAOsearchWorkOrderDetailListRSQL template = new USATruckEdiWoAckManageDBDAOsearchWorkOrderDetailListRSQL();	        
            rs = sqlExe.executeQuery(template,param,null);
     
			int i=1;
            ArrayList args = new ArrayList();
            
            while(rs.next()) {
            	WorkOrderDetailList wo = new WorkOrderDetailList();
            	wo.setSeq(i++);
            	wo.setValidity(checkString(rs.getString("validity"))); 
            	wo.setTrsp_so_no(checkString(rs.getString("trsp_so_no"))); 	
            	wo.setEq_no(checkString(rs.getString("eq_no"))); 		
				wo.setEq_tpsz_cd(checkString(rs.getString("eq_tpsz_cd"))); 	
				wo.setEq_tpsz_nm(checkString(rs.getString("eq_tpsz_nm"))); 	
				wo.setIso_cd(checkString(rs.getString("iso_cd"))); 
				wo.setIso_nm(checkString(rs.getString("iso_nm"))); 
				wo.setApnt_dt(checkString(rs.getString("apnt_dt"))); 		
				wo.setDeli_dt(checkString(rs.getString("de_dt"))); 		
				wo.setReject_rsn(checkString(rs.getString("wo_rjct_rsn"))); 		
				wo.setBkg_no(checkString(rs.getString("bkg_no")));
				wo.setOrg_bkg_no(checkString(rs.getString("org_bkg_no")));
            	wo.setDor_nod_cd(checkString(rs.getString("dor_nod_cd")));
            	wo.setTrsp_bnd_cd(checkString(rs.getString("trsp_bnd_cd")));
            	wo.setDor_pkup_cntr_no(checkString(rs.getString("dor_pkup_cntr_no")));
            	wo.setWo_amt(rs.getDouble("wo_amt"));
            	wo.setWo_cre_dt(checkString(rs.getString("wo_cre_dt")));
            	wo.setLocl_cop_cre_dt(checkString(rs.getString("locl_cop_cre_dt")));
            	wo.setCnmv_vdsts_dt(checkString(rs.getString("cnmv_vdsts_dt")));
            	wo.setSpot_bid_no(checkString(rs.getString("spot_bid_no")));
            	wo.setTrsp_cost_dtl_mod_nm(checkString(rs.getString("trsp_cost_dtl_mod_nm")));
            	args.add(wo);
            }
            
            result[0] = (WorkOrderDetailList[])args.toArray(new WorkOrderDetailList[0]);
            result[1] = new Integer(args.size());

            
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
        
        return result;
    }
    
    /**
     * searchWorkOrderDetail Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * @param trsp_wo_no
     * @return
     * @throws DAOException
     */
    public Object searchWorkOrderDetail(String trsp_wo_no) throws DAOException {
        Object result = null;
        DBRowSet rs = null;
        try {
			String r_trsp_wo_no	= trsp_wo_no;
			String r_trsp_wo_seq = "";
			if(r_trsp_wo_no != null && r_trsp_wo_no.length() > 4) {
				r_trsp_wo_seq = r_trsp_wo_no.substring(3,r_trsp_wo_no.length());
				r_trsp_wo_no = r_trsp_wo_no.substring(0,3);
			}
   			
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no);
    		param.put("trsp_wo_seq", r_trsp_wo_seq);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		USATruckEdiWoAckManageDBDAOsearchWorkOrderDetailRSQL template = new USATruckEdiWoAckManageDBDAOsearchWorkOrderDetailRSQL();	        
            rs = sqlExe.executeQuery(template,param,null);
			
            while(rs.next()) { 
            	WorkOrderDetail wo = new WorkOrderDetail();            	
            	wo.setFr_code(checkString(rs.getString("fm_code"))); 		
				wo.setFr_full_nm(checkString(rs.getString("fm_full_name"))); 		
				wo.setFr_address(checkString(rs.getString("fm_address"))); 			
				wo.setFr_tel(checkString(rs.getString("fm_tel"))); 						
				wo.setFr_fax(checkString(rs.getString("fm_fax"))); 				
				wo.setFr_pic(checkString(rs.getString("fm_pic"))); 			
				wo.setVia_code(checkString(rs.getString("via_code"))); 		
				wo.setVia_full_nm(checkString(rs.getString("via_full_name"))); 		
				wo.setVia_address(checkString(rs.getString("via_address"))); 			
				wo.setVia_tel(checkString(rs.getString("via_tel"))); 						
				wo.setVia_fax(checkString(rs.getString("via_fax"))); 				
				wo.setVia_pic(checkString(rs.getString("via_pic"))); 			
				wo.setTo_code(checkString(rs.getString("to_code"))); 		
				wo.setTo_full_nm(checkString(rs.getString("to_full_name"))); 		
				wo.setTo_address(checkString(rs.getString("to_address"))); 			
				wo.setTo_tel(checkString(rs.getString("to_tel"))); 						
				wo.setTo_fax(checkString(rs.getString("to_fax"))); 				
				wo.setTo_pic(checkString(rs.getString("to_pic"))); 			
				wo.setDoor_code(checkString(rs.getString("dor_code"))); 		
				wo.setDoor_full_nm(checkString(rs.getString("dor_full_name"))); 		
				wo.setDoor_address(checkString(rs.getString("dor_address"))); 			
				wo.setDoor_tel(checkString(rs.getString("dor_tel"))); 						
				wo.setDoor_fax(checkString(rs.getString("dor_fax"))); 				
				wo.setDoor_pic(checkString(rs.getString("dor_pic")));
				wo.setZn_nm(checkString(rs.getString("zn_nm")));
				wo.setEdi_snd_dt(checkString(rs.getString("edi_snd_dt")));
				wo.setWo_vndr_seq(checkString(rs.getString("wo_vndr_seq")));
				wo.setVndr_nm(checkString(rs.getString("vndr_nm")));
				wo.setPhn_no(checkString(rs.getString("phn_no")));
				wo.setVndr_eml(checkString(rs.getString("vndr_eml")));
				wo.setUsr_eml(checkString(rs.getString("usr_eml")));
				result = wo;
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
        
        return result;
    }    
    
	/**
	 * Object가 null일 경우 Blank String으로 반환한다.
	 * @param strString
	 * @return String 입력 Object가 null일 경우 "" 반환,
	 * 이외의 경우에는 입력 Object의 toString() 반환
	 */ 
 	public static String checkString(String strString)
	{
	    if( strString == null || strString.trim().equals("") )
	    	return "";
	    
	    return strString;
	}
    
}