/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CLMInquiryDBDAO.java
*@FileTitle : ServiceProvicerVisibility Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-02
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.basic.ClmInquiryBCImpl;
import com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.event.ClmInquiry;
import com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.event.SppSce0003Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * SPP-SCE 에 대한 DB 처리를 담당<br>
 * - SPP-SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yeon-jin park
 * @see ClmInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class ClmInquiryDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
     * 조회 이벤트 처리<br>
     * Cntr CLM Inquiry 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param et Event
     * @return 
     * @exception DAOException
     */
	public Object[] getCntrClmInquiry(Event et) throws DAOException{
		DBRowSet rs = null;
        Object[] result = new Object[2];
        
        log.debug("CLMInquiryDBDAO  getCntrClmInquiry ");

        try{
        	SppSce0003Event event = (SppSce0003Event)et;
        	/*
        	String bkg_no 		= (event.getBkg_no().trim().length() > 11 ? event.getBkg_no().trim().substring(0,11) : event.getBkg_no().trim());
        	String bkg_no_split = (event.getBkg_no().trim().length() > 11 ? event.getBkg_no().trim().substring(11,13) : "  ");
        	String cop_no		= event.getCop_no().trim();
        	*/
        	String cntr_no 		= event.getCntr_no().trim();
        	  
        	Map<String, Object> param = new HashMap<String, Object>();
		    param.put("cntr_no"       , cntr_no);
		    
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			ClmInquiryDBDAOgetCntrClmInquiryRSQL template = new ClmInquiryDBDAOgetCntrClmInquiryRSQL();	        
		    rs = sqlExe.executeQuery(template,param,velParam);
            
            ArrayList<ClmInquiry> args = new ArrayList<ClmInquiry>();
            
            while(rs.next()){
            	ClmInquiry clm = new ClmInquiry();
            	clm.setCntr_no(rs.getString("cntr_no"));
            	clm.setCnmv_yr(rs.getString("cnmv_yr"));
            	clm.setCnmv_id_no(rs.getString("cnmv_id_no"));
            	clm.setClm_seq(rs.getString("clm_seq"));
            	clm.setFull_mty(rs.getString("full_mty"));
            	clm.setEvent_nm(rs.getString("event_nm"));
            	clm.setCrrnt_loc(rs.getString("crrnt_loc"));
            	clm.setCrrnt_state(rs.getString("crrnt_state"));
            	clm.setArr_date(rs.getString("arr_date"));
            	clm.setArr_time(rs.getString("arr_time"));
            	clm.setClm_crr_nm(rs.getString("clm_crr_nm"));
            	clm.setTrsp_mod_tp_cd(rs.getString("trsp_mod_tp_cd"));
            	clm.setFm_nod_cd(rs.getString("fm_nod_cd"));
            	clm.setFm_ste_cd(rs.getString("fm_ste_cd"));
            	clm.setTo_nod_cd(rs.getString("to_nod_cd"));
            	clm.setTo_ste_cd(rs.getString("to_ste_cd"));
            	clm.setTrn_no(rs.getString("trn_no"));
            	clm.setFcar_no(rs.getString("fcar_no"));
            	
            	args.add(clm);
            	
            }
            log.debug("CLMInquiryDBDAO getCntrClmInquiry  args.size() " + args.size());


   			result[0] = (ClmInquiry[])args.toArray(new ClmInquiry[0]);
    		result[1] = new Integer(args.size());
            log.debug("CLMInquiryDBDAO getCntrClmInquiry result length " + result.length);

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            //log.error("\n SQL : \n" + ((LoggableStatement)ps).getQueryString());
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
//        }finally{
        }
        return result;
	}

}
