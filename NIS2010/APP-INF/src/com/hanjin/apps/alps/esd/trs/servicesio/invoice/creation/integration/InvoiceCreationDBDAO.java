/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationDBDAO.java
*@FileTitle : SPP TRS Invoice Creation DBDAO 
*Open Issues :
*Change history :
* 2007-01-02 sunghwan cho : 신규 작성
* 2007-02-05 subghwan cho : getServiceOrderNo 추가
* 2007-03-23 subghwan cho : cre_ofc_cd 추가 쿼리
* 2007-04-09 sunghwan cho : Creation Inquiry SQL에서 SO 순서 변경
* 2007-04-10 sunghwan cho : parentVendorCode 추가 체크
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.4
=========================================================
History
2012.02.15 윤권영 [CHM-201216122][SPP] Cancelled W/O 에 대한 Invoice 처리 불가 메세지 추가(1건)
2012.02.20 윤권영 [CHM-201216122][SPP] Cancelled W/O 에 대한 Invoice 처리 불가 메세지 추가건 추가수정(1건)
2012.02.22 윤권영 [] 품질 결함 수정-사용하지 않는 지역 변수를 점검한다 : checkExistWorkOrderNo 사용하지 않는 지역변수를 삭제 적용.(1건)
2012.03.02 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다 : @return 에 대한 return; 를 추가적용(1건)
2012.03.13 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다 : 메소드 주석 @return 삭제(1건)
2012.06.26 윤권영 [CHM-201218604][SPP] 조회하는 W/O 와 login S/P 의 code 불일치시 Alert 기능 추가(1건)
2012.09.05 윤권영 [CHM-201219971]Master user의 조회 권한 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

import java.util.Iterator;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.SppTrsI01Event;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * DB Data Access Object<br>
 * - SPP TRS Invoice Creation DBDAO<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceCreationDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
	
    /**
     * searchInvoiceCreationList<br>
     * - Invoice가 신청 안된 Service Order의 Equipment List를 출력한다.<br>
     * - 조회조건 : 로그인 Vendor의 정상 WO(Reject WO제외)중 Invoice 신청되지 않은 Equipment<br>
     * 
     * @param et Event
     * @return invoiceCreationData InvoiceCreationInquiry[]
     * @exception DAOException
     */
    public InvoiceCreationInquiry[] searchInvoiceCreationList(Event et) throws DAOException {
    	DBRowSet rs = null;
    	InvoiceCreationInquiry[] invoiceCreationData = null;
        try {
        	
        	SppTrsI01Event event = (SppTrsI01Event)et;
        	String vndr_cd = event.getVendorCode();
        	String r_trsp_wo_no = event.getWorkOrderNo();
        	String r_trsp_so_no = event.getServiceOrderNo();
        	String r_eq_no = event.getEquipmentNo();
        	String r_bl_no = event.getBillOfLadingNo();
        	String r_bkg_no = event.getBookingNo();
        	
        	String vndr_tmp[] = vndr_cd.split("-");

    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		String tmpVndrSeq = "";
    		String tmpVndrDvsn = "S";
    	    if (vndr_tmp != null && vndr_tmp.length == 2) {
    	    	tmpVndrSeq = vndr_tmp[1];
    	    	tmpVndrDvsn = vndr_tmp[0];
    	    }else {
    	    	tmpVndrSeq = vndr_tmp[0];
    	    }
    	    param.put("vndr_dvsn", tmpVndrDvsn);
    	    param.put("vndr_seq", tmpVndrSeq);
    		
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		ArrayList tmpArrList = new ArrayList();
    		
    		tmpArrList  = this.seperationParameter(r_trsp_wo_no, ","); 
			velParam.put("trsp_wo_ofc_cty_cd", tmpArrList);
			tmpArrList = new ArrayList();
			r_trsp_so_no = r_trsp_so_no.replaceAll("'", "");
			tmpArrList  = this.seperationParameter(r_trsp_so_no, ","); 
			velParam.put("trsp_so_ofc_cty_cd", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_eq_no, ","); 
			velParam.put("eq_no", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_bl_no, ","); 
			velParam.put("bl_no", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_bkg_no, ","); 
			velParam.put("bkg_no", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(tmpVndrSeq, ",");

			velParam.put("sp_cd", tmpArrList);
			
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceCreationDBDAOsearchInvoiceCreationListRSQL template = new InvoiceCreationDBDAOsearchInvoiceCreationListRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);

            ArrayList noticeArray = new ArrayList();
            String tempWONo = "";
            int subSEQ = 0;
            
            while(rs.next()) {
            	InvoiceCreationInquiry invoiceCreation = new InvoiceCreationInquiry();
            	if ( rs.getString("wo_no").equals(tempWONo) ) {
            		subSEQ++;
            	} else {
            		tempWONo = rs.getString("wo_no");
            		subSEQ = 1;
            	}
            	
            	//Invoice Creation 과 Invoice Creation Detail 에서 공통으로 필요한 항목
            	invoiceCreation.setSeq(rs.getInt("rownum"));
            	invoiceCreation.setWorkOrderNo(rs.getString("wo_no"));
            	invoiceCreation.setSubSeq(subSEQ);
            	invoiceCreation.setEquipmentNo(rs.getString("eq_no"));
            	invoiceCreation.setTypeSize(rs.getString("eq_tpsz_nm"));
            	invoiceCreation.setBookingNo(rs.getString("bkg_no"));
            	invoiceCreation.setFromNode(rs.getString("fm_yard_nm"));
            	invoiceCreation.setViaNode(rs.getString("via_yard_nm"));
            	invoiceCreation.setToNode(rs.getString("to_yard_nm"));
            	invoiceCreation.setDoorNode(rs.getString("dor_yard_nm"));
            	invoiceCreation.setWorkOrderType(rs.getString("trsp_cost_dtl_mod_cd"));
            	invoiceCreation.setEquipmentNoType(rs.getString("eq_knd_cd"));
            	invoiceCreation.setEquipmentNoType_nm(rs.getString("eq_tp_nm"));
            	invoiceCreation.setTpsz_cd(rs.getString("eq_tpsz_cd"));
            	invoiceCreation.setTpsz_iso_cd(rs.getString("cntr_tpsz_iso_cd"));
            	invoiceCreation.setBl_no(rs.getString("bl_no"));
            	invoiceCreation.setFromNode_cd(rs.getString("fm_nod_cd"));
            	invoiceCreation.setViaNode_cd(rs.getString("via_nod_cd"));
            	invoiceCreation.setToNode_cd(rs.getString("to_nod_cd"));
            	invoiceCreation.setDoorNode_cd(rs.getString("dor_nod_cd"));
            	invoiceCreation.setVndr_seq(rs.getString("vndr_seq"));
            	invoiceCreation.setVendorCode(rs.getString("vndr_seq"));
            	invoiceCreation.setParentVendorCode(rs.getString("prnt_vndr_seq"));
            	invoiceCreation.setApnt_dt(rs.getString("apnt_dt"));
            	invoiceCreation.setDe_dt(rs.getString("de_dt"));
            	invoiceCreation.setOfficeCode(rs.getString("cre_ofc_cd"));
            	invoiceCreation.setServiceOrderNo(rs.getString("so_no"));
            	//2007-07-10 wo_currency invoice currency비교하기위해 추가
            	invoiceCreation.setWoCurrencyCode(rs.getString("curr_cd"));
            	invoiceCreation.setTrsp_bnd_cd(rs.getString("trsp_bnd_cd"));
            	invoiceCreation.setCgo_tp_cd(rs.getString("cgo_tp_cd"));
            	invoiceCreation.setTrsp_so_tp_cd(rs.getString("trsp_so_tp_cd"));
            	invoiceCreation.setWo_cre_dt(rs.getString("wo_cre_dt"));
            	invoiceCreation.setLocl_cop_cre_dt(rs.getString("locl_cop_cre_dt"));
            	//2015.09.02
            	// Door Delivery Date 입력시 Local Cop Creation Date Validation을 위해 추가
            	invoiceCreation.setCnmv_vdsts_dt(rs.getString("cnmv_vdsts_dt"));
            	
            	//2015.10.07
            	// W/O Detail 에 Bid No 컬럼 추가
            	invoiceCreation.setSpot_bid_no(rs.getString("spot_bid_no"));
            	
            	noticeArray.add(invoiceCreation);
            }
            invoiceCreationData = (InvoiceCreationInquiry[])noticeArray.toArray(new InvoiceCreationInquiry[0]);
           
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
        return invoiceCreationData;
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
     * checkExistWorkOrderNo<BR>
     * 
     * @param et Event
     * @throws DAOException
     */
    public void checkExistWorkOrderNo(Event et) throws DAOException {
    	
		DBRowSet rs = null;
    	ArrayList tmpList = null;
    	ArrayList tmpList1 = null;
    	ArrayList tmpList2 = null;
    	ArrayList tmpArrList = null;
    	TreeSet t = new TreeSet();
		String notExtFlg = "N";
		
	    try {
	    	
	    	SppTrsI01Event event = (SppTrsI01Event)et;
	    	String wo_no = event.getWorkOrderNo();
	    	String vndr_seq = event.getVendorCode();
	    	String vndr_dvsn = "S";
	    	
	    	String vndr_tmp[] = vndr_seq.split("-");
	    	if (vndr_tmp != null && vndr_tmp.length == 2) {
	    		vndr_dvsn = vndr_tmp[0];
	    		vndr_seq = vndr_tmp[1];
    	    }else {
    	    	vndr_seq = vndr_tmp[0];
    	    }
	    	
		    	tmpArrList = new ArrayList();
	    		tmpArrList  = this.seperationParameter(wo_no, ","); 
	    		for(int i=0; i<tmpArrList.toArray().length; i++ ){
		    		t.add((String) tmpArrList.get(i));    		
	    		}
	    		
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	    		tmpArrList = new ArrayList();
	    		tmpArrList  = this.seperationParameter(vndr_seq, ",");

				velParam.put("sp_cd", tmpArrList);
	    		
		    	tmpArrList = new ArrayList();
		    	Iterator it = t.iterator();
	
		    	while(it.hasNext()){
		    		tmpArrList.add((String) it.next());	//중복값을 제거하기 위해
		    	}
		    	
		    	tmpList = new ArrayList();
		    	tmpList1 = new ArrayList();
		    	tmpList2 = new ArrayList();
		    	Map<String, Object> param = new HashMap<String, Object>();
		    	for(int i=0; i<tmpArrList.toArray().length; i++){
		    		param.put("WO_NO", tmpArrList.get(i));
		    		param.put("VNDR_SEQ", vndr_seq);
		
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					InvoiceCreationDBDAOcheckExistWorkOrderNoRSQL template = new InvoiceCreationDBDAOcheckExistWorkOrderNoRSQL();
					rs = sqlExe.executeQuery(template,param,velParam);
			    					
					if(rs != null && rs.next()){
						notExtFlg = rs.getString("notExtFlg");
						if("1".equals(notExtFlg)){
							tmpList1.add(tmpArrList.get(i));
						}else if("2".equals(notExtFlg)){
							tmpList2.add(tmpArrList.get(i));
						}
					}else{
						tmpList.add(tmpArrList.get(i));
					}
		    	}
		    	
		    	String errWoNo = "";
		    	
		    	if(tmpList.toArray().length > 0){
		    		if(tmpList.toArray().length == 1 ){
		    			errWoNo = (String) tmpList.get(0);
		        	}else{
		        		for(int i=0 ; i<tmpList.toArray().length ; i++ ){
		        			if(i == 0)
		        				errWoNo = (String) tmpList.get(i);
		        			if(i > 0)
		        				errWoNo = errWoNo+","+(String) tmpList.get(i);
		        		}
		        	}
		    		throw new EventException("There is no existing W/O number. Verify W/O number again.\\n(W/O No. : "+errWoNo+")");
		    	}
		    	if(!"M".equals(vndr_dvsn)){
			    	if(tmpList1.toArray().length > 0){
			    		if(tmpList1.toArray().length == 1 ){
			    			errWoNo = (String) tmpList1.get(0);
			        	}else{
			        		for(int i=0 ; i<tmpList1.toArray().length ; i++ ){
			        			if(i == 0)
			        				errWoNo = (String) tmpList1.get(i);
			        			if(i > 0)
			        				errWoNo = errWoNo+","+(String) tmpList1.get(i);
			        		}
			        	}
			    		throw new EventException("S/P code over the W/O No. is not compatible with it under your account.\\n(W/O No. : "+errWoNo+")");
			    	}
		    	}
		    	if(tmpList2.toArray().length > 0){
		    		if(tmpList2.toArray().length == 1 ){
		    			errWoNo = (String) tmpList2.get(0);
		        	}else{
		        		for(int i=0 ; i<tmpList2.toArray().length ; i++ ){
		        			if(i == 0)
		        				errWoNo = (String) tmpList2.get(i);
		        			if(i > 0)
		        				errWoNo = errWoNo+","+(String) tmpList2.get(i);
		        		}
		        	}
		    		throw new EventException("W/O under the invoice is cancelled status on SML’s internal system. Please contact SML traffic office first to verify the problem.\\n(Cancelled W/O No. : "+errWoNo+")");
		    	}
	    	
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return;
    }
}