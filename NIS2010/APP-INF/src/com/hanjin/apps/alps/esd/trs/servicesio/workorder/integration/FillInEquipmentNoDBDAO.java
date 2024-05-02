/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FillInEquipmentNoDBDAO.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
* 2007-08-31 Jung-Jae Kim : 정원근 SS 요청 번복. revised_bkg_no >> bkg_no 로 급수정.
*@LastModifyDate : 2007-08-31
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.2
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory; 
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.FillInEquipmentNoList;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0003Event;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author doomi
 * @see WSInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class FillInEquipmentNoDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * searchFillInEquipmentNoList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchFillInEquipmentNoList(Event et) throws DAOException {
    	
    	DBRowSet rs = null;
        Object[] result = new Object[2];

        try {

            ExpPap0003Event event = (ExpPap0003Event)et;
            
			String r_trsp_wo_no	  = event.getTrsp_wo_no();		
			String r_trsp_wo_seq  = "";
			
			if( r_trsp_wo_no != null && r_trsp_wo_no.length() > 3) {
				r_trsp_wo_seq = r_trsp_wo_no.substring(3);
				r_trsp_wo_no  = r_trsp_wo_no.substring(0,3);
			}
			String r_vender_cd	= event.getVendorCode();		
			
	   		if(event.getTrsp_wo_no() == null || event.getTrsp_wo_no().equals("")) {
    			throw new Exception("Please enter WorkOrderNumber");
    		}
			
	   		if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please enter Vendor Code");
    		}

    		Map<String, Object> param = new HashMap<String, Object>();
    		
    	    param.put("vndr_seq", r_vender_cd);
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no);
    		param.put("trsp_wo_seq", r_trsp_wo_seq);
    		   		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    	
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		FillInEquipmentNoDBDAOsearchFillInEquipmentNoListRSQL template = new FillInEquipmentNoDBDAOsearchFillInEquipmentNoListRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);

            int i=1;
            ArrayList args = new ArrayList();
            
            while(rs.next()) {
            	FillInEquipmentNoList wo = new FillInEquipmentNoList();
            	wo.setSeq(i++);
				wo.setEq_no(checkString(rs.getString("cntr_no"))); 		
				wo.setEq_tpsz_cd(checkString(rs.getString("cntr_tpsz_cd"))); 
				wo.setEq_tpsz_nm(checkString(rs.getString("eq_tpsz_nm"))); 				
				wo.setBkg_no(checkString(rs.getString("bkg_no"))); 						
				wo.setBkg_status_cd(checkString(rs.getString("bkg_status_cd"))); 
				wo.setBkg_status_nm(checkString(rs.getString("bkg_status_nm"))); 
				wo.setBl_no(checkString(rs.getString("bl_no"))); 
				wo.setOrg_bkg_no(checkString(rs.getString("org_bkg_no")));
				wo.setSo_eq_flg(checkString(rs.getString("so_eq_flg")));
				//wo.setCtm_scac_chk_flg(checkString(rs.getString("ctm_scac_chk_flg")));
				wo.setCtm_scac_chk_flg("Y");
				args.add(wo);
            }
      		
            result[0] = (FillInEquipmentNoList[])args.toArray(new FillInEquipmentNoList[0]);
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
     * searchFillInEquipmentNoExcelPrint Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchFillInEquipmentNoExcelPrint(Event et) throws DAOException {
    	
    	DBRowSet rs = null;
        Object[] result = new Object[2];

        try {
        	
            ExpPap0003Event event = (ExpPap0003Event)et;
            String r_trsp_so_no	  = event.getTrsp_so_no();		
            
	   		if(event.getTrsp_so_no() == null || event.getTrsp_so_no().equals("")) {
    			throw new Exception("Please enter ServiceOrderNumber");
    		}

    		Map<String, Object> param = new HashMap<String, Object>();
    	    Map<String, Object> velParam = new HashMap<String, Object>();
    	    
    		ArrayList tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_trsp_so_no, ","); 
    		velParam.put("trsp_wo_ofc_cty_cd", tmpArrList);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		FillInEquipmentNoDBDAOsearchFillInEquipmentNoExcelPrintRSQL template = new FillInEquipmentNoDBDAOsearchFillInEquipmentNoExcelPrintRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);

            int i=1;
            ArrayList args = new ArrayList();
           
            while(rs.next()) {
            	FillInEquipmentNoList wo = new FillInEquipmentNoList();
            	wo.setSeq(i++); 
				wo.setEq_no(checkString(rs.getString("eq_no"))); 		
				wo.setEq_tpsz_cd(checkString(rs.getString("eq_tpsz_cd"))); 
				wo.setEq_tpsz_nm(checkString(rs.getString("eq_tpsz_nm"))); 				
				wo.setBkg_no(checkString(rs.getString("bkg_no"))); 						
				wo.setBkg_status_cd(checkString(rs.getString("bkg_status_cd"))); 
				wo.setBkg_status_nm(checkString(rs.getString("bkg_status_nm"))); 
				wo.setBl_no(checkString(rs.getString("bl_no"))); 
            	args.add(wo);
            }

            result[0] = (FillInEquipmentNoList[])args.toArray(new FillInEquipmentNoList[0]);
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
     * Object가 null일 경우 Blank String으로 반환한다.
     * @param strString 
     * @return String 입력 Object가 null일 경우 "" 반환,
     *         이외의 경우에는 입력 Object의 toString() 반환 
     */
    public static String checkString(String strString) {
        
    	if( strString == null || strString.trim().equals("") )
        	return "";
        
        return strString;
    }
    /**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return ArrayList
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

