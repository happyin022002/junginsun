/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AvailabilityDBDAO.java
*@FileTitle : Availability Inquiry
*Open Issues :
*Change history :
*2007-09-05 Jung-Jae Kim : 2007-09-05: B/L# 12자리.
*@LastModifyDate : 2007-09-05
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.1
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.availability.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.trs.servicesio.availability.event.EmptyAvailabilityInquiry;
import com.clt.apps.opus.esd.trs.servicesio.availability.event.EmptyAvailabilityInquiryRequest;
import com.clt.apps.opus.esd.trs.servicesio.availability.event.ExpPap0004Event;
import com.clt.apps.opus.esd.trs.servicesio.common.document.AvailabilityList;
import com.clt.apps.opus.esd.trs.servicesio.eursoack.integration.EurSoAckManageDBDAOaddEurSoAckListUSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsTrspSoPkupCntrVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author doomi
 * @see WSInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class AvailabilityDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
		
    /**
     * searchAvailabilityPeriodList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
	public Object[] searchAvailabilityPeriodList(Event et) throws DAOException {
	DBRowSet rs = null;
	Object[] result = new Object[2];
	try{
        ExpPap0004Event event = (ExpPap0004Event)et;
        String r_vendorCode							= event.getVendorCode();
        String r_period_flg							= event.getPeriod_flg();					//period_flg                                 
		String r_from_dt							= event.getFrom_dt();						//Dispatched Date                          
		String r_to_dt								= event.getTo_dt();							//Dispatched Date                          
		
		String r_cgor_frt_pay_ind_flg				= event.getFreight_collect_flg();        	//F : Freight Collect 여부          
		String r_cgor_org_bl_rcvr_ind_flg			= event.getOriginal_bl_flg();           	//O : Original B/L 회수 여부      
		String r_cgor_cstms_acpt_re_ind_flg			= event.getCustoms_flg();      				//C : 세관통관여부                   
		String r_cntr_pkup_no_flg					= event.getCntr_pkup_no_flg();         		//Pickup Number  여부                   
		String r_avl_sts_flg						= event.getAvailable_sts_flg();  			// Available Status
		      	
		String vndr_tmp[] = r_vendorCode.split("-");			
		
		if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
			throw new Exception("Please enter Vendor Code.");
		}		
	// query parameter
	Map<String, Object> param = new HashMap<String, Object>();
    if (vndr_tmp != null && vndr_tmp.length == 2) {
    	param.put("vndr_tmp", vndr_tmp[1]);
    }else {
    	param.put("vndr_tmp", vndr_tmp[0]);
    }
	param.put("r_from_dt", r_from_dt);
	param.put("r_to_dt", r_to_dt);
	param.put("r_cgor_frt_pay_ind_flg", r_cgor_frt_pay_ind_flg);
	param.put("r_cgor_org_bl_rcvr_ind_flg", r_cgor_org_bl_rcvr_ind_flg);
	param.put("r_cgor_cstms_acpt_re_ind_flg",r_cgor_cstms_acpt_re_ind_flg);
	
	// velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	velParam.put("r_period_flg", r_period_flg);
	velParam.put("r_cgor_frt_pay_ind_flg", r_cgor_frt_pay_ind_flg);
	velParam.put("r_cgor_org_bl_rcvr_ind_flg", r_cgor_org_bl_rcvr_ind_flg);
	velParam.put("r_cgor_cstms_acpt_re_ind_flg", r_cgor_cstms_acpt_re_ind_flg);
	velParam.put("r_cntr_pkup_no_flg", r_cntr_pkup_no_flg);
	velParam.put("r_avl_sts_flg", r_avl_sts_flg);
    SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    AvailabilityDBDAOsearchAvailabilityPeriodListRSQL template = new AvailabilityDBDAOsearchAvailabilityPeriodListRSQL();	        
    rs = sqlExe.executeQuery(template,param,velParam);
    int i = 1;
    ArrayList args = new ArrayList();
    
    while(rs.next()) {
    	String eq_no = checkString(rs.getString("eq_no"));
		String bkg_no = checkString(rs.getString("bkg_no"));
		
    	AvailabilityList aval = new AvailabilityList();            		
    	aval.setSeq(i++); 
		aval.setEq_no(eq_no);		
		aval.setEq_tpsz_cd(checkString(rs.getString("eq_tpsz_cd")));		
		aval.setEq_tpsz_nm(checkString(rs.getString("eq_tpsz_nm")));		
		aval.setIso_cd(checkString(rs.getString("iso_cd")));
		aval.setIso_nm(checkString(rs.getString("iso_nm")));
		aval.setCntr_wgt(checkString(rs.getString("cntr_wgt")));	
		aval.setFreight_collect_flg(checkString(rs.getString("f")));		//F							
		aval.setOriginal_bl_flg(checkString(rs.getString("o")));		//O							
		aval.setCustoms_flg(checkString(rs.getString("c")));	//C
		aval.setEta_rail_dest_dt(checkString(rs.getString("lst_nod_pln_dt")));  
		aval.setTrsp_wo_no(checkString(rs.getString("trsp_wo_no")));	//W/O No				
		aval.setBl_no(checkString(rs.getString("bl_no")));
		aval.setBkg_no(bkg_no);
		aval.setCop_no(checkString(rs.getString("cop_no")));
		//2008-05-19 by KJJ
		//Available Date와 Last Free Date를 보이는 것에는 로직 제한 없도록 변경 by COL
		aval.setAval_dt(checkString(rs.getString("aval_dt")));		
		aval.setLst_free_dt(checkString(rs.getString("lst_free_dt")));	
		 
		//2007-10-10 by KJJ: cstms_acpt_flg column 값이 Y,W 둘다 list에 보이도록 수정 요청 by SHIN
		if ((rs.getString("f").trim().equals("Y") 
				&& rs.getString("o").trim().equals("Y") 
				&& (rs.getString("c").trim().equals("Y") || rs.getString("c").trim().equals("W")) ) 
				&& rs.getString("pkup_no") != null && !rs.getString("pkup_no").equals("")
				&& !checkString(rs.getString("lst_free_dt")).equals("")){
				
				aval.setAvail_nm("Available");
				aval.setCntr_pkup_no(checkString(rs.getString("pkup_no")));	//Pickup Number
				
				//first release date insert
				//masterSPP로 로긴할 때는 update 안되도록 막음.
//				2010-03-16 PkupRlsDt Update 로직제거
//	    		if(vndr_tmp != null){
//					if(vndr_tmp.length == 2 && "S".equals(vndr_tmp[0])){
//						updFirstRlsDt(bkg_no,eq_no);
//					}
//				}
		}else{
				aval.setAvail_nm("Unavailable");
				aval.setCntr_pkup_no("");	//Pickup Number		
		}
		aval.setWoFmtTpCd(checkString(rs.getString("wo_fmt_tp_cd")));
		args.add(aval);
    }
    result[0] = (AvailabilityList[])args.toArray(new AvailabilityList[0]);
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
     * searchAvailabilityNoList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchAvailabilityNoList(Event et) throws DAOException {
        DBRowSet rs = null;

        Object[] result = new Object[2];

        try {
            ExpPap0004Event event = (ExpPap0004Event)et;
            String r_vendorCode							= event.getVendorCode();
            String r_trsp_wo_no		= event.getTrsp_wo_no();		
       	 	String r_eq_no			= event.getEq_no();						
    		String r_bkg_no			= event.getBkg_no();					
    		String r_bl_no				= event.getBl_no();						

    		String vndr_tmp[] = r_vendorCode.split("-");

    		if(!"M".equals(vndr_tmp[0])){
	    		if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
	    			throw new Exception("Please enter Vendor Code.");
	    		}
    		}

    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
            if (vndr_tmp != null && !"M".equals(vndr_tmp[0])) {
            	if(vndr_tmp.length == 2){
            		param.put("vndr_tmp", vndr_tmp[1]);
            	}else {
            		param.put("vndr_tmp", vndr_tmp[0]);
            	}
            }    		
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();
			//W/O No
    		List<String> woNo = new ArrayList();
    		woNo  = this.seperationParameter(r_trsp_wo_no, ","); 
			velParam.put("wo_no", woNo);
			
			//Eq No
    		List<String> eqNo = new ArrayList();
    		eqNo  = this.seperationParameter(r_eq_no, ","); 
			velParam.put("EqNo", eqNo);			

 			//Booking No
    		List<String> bkgNo = new ArrayList();
    		bkgNo  = this.seperationParameter(r_bkg_no, ","); 
			velParam.put("BkgNo", bkgNo);
			
     	  	//Billing No
			//2008-05-19 by KJJ
			//B/L# 12자리  bl_no||bl_no_tp||bl_no_chk
    		List<String> blNo = new ArrayList();
    		blNo  = this.seperationParameter(r_bl_no.toUpperCase(), ","); 
			velParam.put("BlNo", blNo);
			
			//VendorCode
			velParam.put("vndr_dvsn", vndr_tmp[0]);
			
			/*
			velParam.put("vndr_tmp", vndr_tmp);
			if(vndr_tmp!=null && vndr_tmp.length > 0){
				velParam.put("vndr_tmp", vndr_tmp[0]);
			}
			*/
			
		    SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
		    AvailabilityDBDAOsearchAvailabilityNoListRSQL template = new AvailabilityDBDAOsearchAvailabilityNoListRSQL();	        
		    rs = sqlExe.executeQuery(template,param,velParam);			


            int i = 1;
            ArrayList args = new ArrayList();
            
            while(rs.next()) {

            	String eq_no = checkString(rs.getString("eq_no"));
				String bkg_no = checkString(rs.getString("bkg_no"));
				//String bkg_no_split = checkString(rs.getString("bkg_no_split"));
				
            	AvailabilityList aval = new AvailabilityList();
            	aval.setSeq(i++); 
				aval.setEq_no(eq_no);		
				aval.setEq_tpsz_cd(checkString(rs.getString("eq_tpsz_cd")));		
				aval.setEq_tpsz_nm(checkString(rs.getString("eq_tpsz_nm")));		
				aval.setIso_cd(checkString(rs.getString("iso_cd")));
				aval.setIso_nm(checkString(rs.getString("iso_nm")));
				aval.setCntr_wgt(checkString(rs.getString("cntr_wgt")));	
				aval.setFreight_collect_flg(checkString(rs.getString("f")));						
				aval.setOriginal_bl_flg(checkString(rs.getString("o")));							
				aval.setCustoms_flg(checkString(rs.getString("c")));	
				aval.setEta_rail_dest_dt(checkString(rs.getString("lst_nod_pln_dt")));
				aval.setTrsp_wo_no(checkString(rs.getString("trsp_wo_no")));		
				aval.setBl_no(checkString(rs.getString("bl_no")));

				aval.setBkg_no(bkg_no);
				aval.setCop_no(checkString(rs.getString("cop_no")));
				// 2008-05-19 by KJJ
				// Available Date와 Last Free Date를 보이는 것에는 로직 제한 없도록 변경 by COL
				aval.setAval_dt(checkString(rs.getString("aval_dt")));		
				aval.setLst_free_dt(checkString(rs.getString("lst_free_dt")));				
				 
				
				if ((rs.getString("f").trim().equals("Y") 
						&& rs.getString("o").trim().equals("Y") 
						&& (rs.getString("c").trim().equals("Y") || rs.getString("c").trim().equals("W")) ) 
						&& rs.getString("pkup_no") != null && !rs.getString("pkup_no").equals("")
						&& !checkString(rs.getString("lst_free_dt")).equals("")){
					
							aval.setAvail_nm("Available");
							aval.setCntr_pkup_no(checkString(rs.getString("pkup_no")));	//Pickup Number
							
				    		// masterSPP로 로긴할 때는 update 안되도록 막음.
//							2010-03-16 PkupRlsDt Update 로직제거
//							if (vndr_tmp != null && !"M".equals(vndr_tmp[0])) {
//								updFirstRlsDt(bkg_no,eq_no);
//							}
				}else{
							aval.setAvail_nm("Unavailable");
							aval.setCntr_pkup_no("");	//Pickup Number		
				}
				aval.setWoFmtTpCd(checkString(rs.getString("wo_fmt_tp_cd")));
				args.add(aval);
            }
            
            result[0] = (AvailabilityList[])args.toArray(new AvailabilityList[0]);
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
    public static String checkString(String strString)
    {
        if( strString == null || strString.trim().equals("") )
        	return "";
        
        return strString;
    }
    
    /**
     * pickup container number가 처음으로 release 될때 date update
     * 
     * @param bkg_no
     * @param cntr_no
     * @throws DAOException
     */
    public void updFirstRlsDt(String bkg_no,  String cntr_no) throws DAOException{
    	int resultCount = 0;
        try{
            Map<String, Object> uParam = new HashMap<String, Object>();
            uParam.put("bkg_no", bkg_no);
            uParam.put("cntr_no", cntr_no);
            
			SQLExecuter sqlUpex = new SQLExecuter("DEFAULT");	        
			EurSoAckManageDBDAOaddEurSoAckListUSQL upTemplate = new EurSoAckManageDBDAOaddEurSoAckListUSQL();
	        resultCount=sqlUpex.executeUpdate(upTemplate,uParam,null);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
    }
    
    /**
     * pickup container number가 처음으로 release 될때 date update
     * 
     * @param bkgNoList
     * @param cntrNoList
     * @throws DAOException
     */
    public void updFirstRlsDt(ArrayList bkgNoList,ArrayList cntrNoList) throws DAOException{
        
        try{

        	Collection<TrsTrspSoPkupCntrVO> updateVoList = new ArrayList<TrsTrspSoPkupCntrVO>();
				        
	        for (int i=0,cnt=1;i<bkgNoList.size();i++,cnt=1) {
	        	TrsTrspSoPkupCntrVO updateVo = new TrsTrspSoPkupCntrVO();
	        	String bkg_no = (String)bkgNoList.get(i);
	        	String cntr_no = (String)cntrNoList.get(i);
	        	updateVo.setBkgNo(bkg_no);
	        	updateVo.setCntrNo(cntr_no);
	        	updateVoList.add(updateVo);
	        }   
	        
			SQLExecuter sqlUpex = new SQLExecuter("DEFAULT");	        
			AvailabilityDBDAOupdFirstRlsDtUSQL upTemplate = new AvailabilityDBDAOupdFirstRlsDtUSQL();
			sqlUpex.executeBatch(upTemplate, updateVoList, null,null);

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
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
	
	/**
     * searchEmptyAvailabilityList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchEmptyAvailabilityList(Event et) throws DAOException {
    	DBRowSet rs = null;
        Object[] result = new Object[2];

        try {
        	
            ExpPap0004Event event = (ExpPap0004Event)et;
            EmptyAvailabilityInquiryRequest arg = event.getEmptyAvailabilityInquiryRequest();
                  	
			if(arg.getVendorCode() == null || arg.getVendorCode().equals("")) {
    			throw new Exception("Please enter Vendor Code.");
    		}
			
			String dt_to = arg.getPeriodEndDate();
			String dt_fr = arg.getPeriodStartDate();
			String wo_vndr_seq = arg.getVendorCode();
			String dor_nod_cd = arg.getDorNodCd();
			String to_nod_cd = arg.getToNodCd();
			String dvsn = arg.getStatus();
			
			String period_type = arg.getPeriodType();
			String wo_no = arg.getWorkOrderNo();
			String eq_no = arg.getEquipmentNo();
			
			Map<String, Object> param = new HashMap<String, Object>();
		    param.put("dt_to"       , dt_to);
		    param.put("wo_vndr_seq" , wo_vndr_seq);
		    param.put("dt_fr"       , dt_fr);
		    param.put("dor_nod_cd"  , dor_nod_cd);
		    param.put("dvsn"        , dvsn);
		    param.put("to_nod_cd"   , to_nod_cd);
		   
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("period_type", period_type);
			
			List<String> woNo = new ArrayList();
    		woNo  = this.seperationParameter(wo_no, ","); 
			velParam.put("wo_no", woNo);
			
			List<String> eqNo = new ArrayList();
			eqNo  = this.seperationParameter(eq_no, ","); 
			velParam.put("eq_no", eqNo);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
		    AvailabilityDBDAOsearchEmptyAvailabilityListRSQL template = new AvailabilityDBDAOsearchEmptyAvailabilityListRSQL();	        
		    rs = sqlExe.executeQuery(template,param,velParam);
            
	        ArrayList args = new ArrayList();
            
            while(rs.next()) {
            	EmptyAvailabilityInquiry aval = new EmptyAvailabilityInquiry();            		
				aval.setEq_no             (checkString(rs.getString("eq_no"           )));
				aval.setEq_tpsz_cd        (checkString(rs.getString("eq_tpsz_cd"      )));
				aval.setCntr_tpsz_iso_cd  (checkString(rs.getString("cntr_tpsz_iso_cd")));
				aval.setIso_nm            (checkString(rs.getString("iso_nm"          )));
				aval.setDor_nod_cd        (checkString(rs.getString("dor_nod_cd"      )));
				aval.setDor_nod_name      (checkString(rs.getString("dor_nod_name"    )));
				aval.setDor_loc_nm        (checkString(rs.getString("dor_loc_nm"      )));
				aval.setDor_yd_addr       (checkString(rs.getString("dor_yd_addr"     )));
				aval.setDor_zip_cd        (checkString(rs.getString("dor_zip_cd"      )));
				aval.setDor_fctry_nm      (checkString(rs.getString("dor_fctry_nm"    )));
				aval.setDor_ofc_eng_nm    (checkString(rs.getString("dor_ofc_eng_nm"  )));
				aval.setDor_phn_no        (checkString(rs.getString("dor_phn_no"      )));
				aval.setTo_nod_cd         (checkString(rs.getString("to_nod_cd"       )));
				aval.setTo_loc_nm         (checkString(rs.getString("to_loc_nm"       )));
				aval.setTo_nod_name       (checkString(rs.getString("to_nod_name"     )));
				aval.setTo_yd_addr        (checkString(rs.getString("to_yd_addr"      )));
				aval.setTo_zip_cd         (checkString(rs.getString("to_zip_cd"       )));
				aval.setTo_ofc_eng_nm     (checkString(rs.getString("to_ofc_eng_nm"   )));
				aval.setTo_phn_no         (checkString(rs.getString("to_phn_no"       )));
				aval.setAvb_sts           (checkString(rs.getString("avb_sts"         )));
				aval.setAvb_dt            (checkString(rs.getString("avb_dt"          )));
				aval.setFirt_free_dt      (checkString(rs.getString("firt_free_dt"    )));
				aval.setLast_free_dt      (checkString(rs.getString("last_free_dt"    )));
				aval.setCop_fsh_dt        (checkString(rs.getString("cop_fsh_dt"      )));
				
				 
				args.add(aval);
            }
            result[0] = (EmptyAvailabilityInquiry[])args.toArray(new EmptyAvailabilityInquiry[0]);
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
}

