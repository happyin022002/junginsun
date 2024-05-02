/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EES_COMMONHTMLAction.java
*@FileTitle         : common data search
*Open Issues     :
*@LastModifyDate : 2009-07-30
*@LastModifier   : 정은호
*@LastVersion    : 2.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commonSC로 실행요청<br>
 * - commonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 
 * @see EesCommonEvent , EES_COMMONEventResponse 참조
 * @since J2EE 1.6
 */
public class EES_COMMONHTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_COMMONHTMLAction 객체를 생성
	 */
	public EES_COMMONHTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EES_COMMONEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		
		FormCommand f_cmd = FormCommand.fromRequest(request);
		EesCommonEvent event = null;    	
		
    	// Retrieve 버튼 클릭시
		String planIdFlag = JSPUtil.getParameter(request, "planIdFlag".trim(), "");
		
		String yyyyww = "";
		String seq = "";
		String localDate = JSPUtil.getParameter(request, "localDate".trim(), "");// TEST
		
		
		if(planIdFlag.equals("")) {
	    	yyyyww	= JSPUtil.getParameter(request, "yyyyww".trim(), "");
	    	seq = JSPUtil.getParameter(request, "seq".trim(),"");    	
		} else if(planIdFlag.equals("1")) {
			yyyyww	= JSPUtil.getParameter(request, "yyyyww1".trim(), "");
	    	seq = JSPUtil.getParameter(request, "seq1".trim(),"");   
		} else if(planIdFlag.equals("2")) {
			yyyyww	= JSPUtil.getParameter(request, "yyyyww2".trim(), "");
	    	seq = JSPUtil.getParameter(request, "seq2".trim(),"");   
		}
   	    
    	// Retrieve 버튼 클릭시
		if (f_cmd.isCommand(FormCommand.SEARCHLIST01)) {
			
	        event = new EesCommonEvent(yyyyww, seq);
	        
		}
		
		String eccCd = JSPUtil.getParameter(request, "eccCd".trim(), "");
		String row1   = JSPUtil.getParameter(request, "Row".trim(),"");
		String col1   = JSPUtil.getParameter(request, "Col".trim(),"");
    	// ECC Code Validation Check
		if (f_cmd.isCommand(FormCommand.SEARCHLIST02)) {
			
	        event = new EesCommonEvent(eccCd);	 
	        event.getEesCommonConditionVO().setCol(col1);
	        event.getEesCommonConditionVO().setRow(row1);
		}
		
		//Repo Plan ID
		if (f_cmd.isCommand(FormCommand.SEARCHLIST03)) {
	        event = new EesCommonEvent(yyyyww, seq, localDate, 0);
		}
			

		// LOC Code Validation Check
		if (f_cmd.isCommand(FormCommand.SEARCHLIST04)) {
        	String loccode_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String loccode_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
			String locCd 			  = JSPUtil.getParameter(request, "locCd".trim(), "");
			String type  			  = JSPUtil.getParameter(request, "type".trim(), "");
			
	        //event = new EES_COMMONEvent(locCd, type,"");
			
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLoccodeRow(loccode_row);
        	event.getEesCommonConditionVO().setLoccodeColname(loccode_colname);
        	event.getEesCommonConditionVO().setLocCd(locCd);
        	event.getEesCommonConditionVO().setType(type);

		}

		// LOC Code Validation Check
		if (f_cmd.isCommand(FormCommand.SEARCHLIST07)) {
        	String loccode_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String loccode_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
			
			String locCd  = JSPUtil.getParameter(request, "locCd".trim(), "");
			String type   = JSPUtil.getParameter(request, "type".trim(), "");			
			String mlocCd = JSPUtil.getParameter(request, "mlocCd".trim(), "");
			String mtype  = JSPUtil.getParameter(request, "mtype".trim(), "");
	       
			//event = new EES_COMMONEvent(mlocCd, mtype, locCd, type, "");
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLoccodeRow(loccode_row);
        	event.getEesCommonConditionVO().setLoccodeColname(loccode_colname);
        	event.getEesCommonConditionVO().setLocCd(locCd);
        	event.getEesCommonConditionVO().setType(type);   
        	event.getEesCommonConditionVO().setMlocCd(mlocCd);
        	event.getEesCommonConditionVO().setMtype(mtype);           	

		}
		
		// --------- SEARCH LOC YARD COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST05) || f_cmd.isCommand(FormCommand.SEARCH15)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
		}    	

		// --------- SEARCH VENDOR Company COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH04)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
		}     	
    	
		// --------- SEARCH VENDOR COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST06)) {
        	String vendor_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String vendor_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String vendor_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setVendorRow(vendor_row);
        	event.getEesCommonConditionVO().setVendorColname(vendor_colname);
        	event.getEesCommonConditionVO().setVendorSearchword(vendor_searchword);
		}     	    	
    	
		// --------- SEARCH VVD COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST08)) {
        	String vvd_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String vvd_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String vvd_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 검색정보
        	String repoPlanId     = JSPUtil.getParameter(request, "repo_id".trim(),"");    // 검색정보
        	String pln_yrwk       = JSPUtil.getParameter(request, "pln_yrwk".trim(),"");      // 검색정보
        	
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setVvdRow(vvd_row);
        	event.getEesCommonConditionVO().setVvdColname(vvd_colname);
        	event.getEesCommonConditionVO().setVvdSearchword(vvd_searchword);
        	event.getEesCommonConditionVO().setVvdRepoplanid(repoPlanId);
        	event.getEesCommonConditionVO().setVvdPlnyrwk(pln_yrwk);
		}    	    	

		// --------- SEARCH LOC YARD-ECC COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST09)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_colname1   = JSPUtil.getParameter(request, "colname1".trim(),"");      // ecc column name
        	String locyard_searchword = JSPUtil.getParameter(request, "locyard".trim(),"");    // 검색정보
        	String locyard_ecc = JSPUtil.getParameter(request, "ecc".trim(),"");              // 검색정보    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardColname1(locyard_colname1);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
        	event.getEesCommonConditionVO().setLocyardEcc(locyard_ecc);
		}
    	
    	// SCNR_ID
		if (f_cmd.isCommand(FormCommand.SEARCHLIST10)) {
			String scnrId = "";
			String plnyrwk       = JSPUtil.getParameter(request, "plnyrwk".trim(),"");      // 검색정보
			
	        event = new EesCommonEvent();
	        
	        event.getEesCommonConditionVO().setPlnyrwk(plnyrwk);
	        event.getEesCommonConditionVO().setScnrId(scnrId);
		} 	    	
		   	
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST11)) {
    		event = new EesCommonEvent();
    		event.getEesCommonConditionVO().setCountry(JSPUtil.getParameter(request , "country".trim(),""));
    	}
    	
    	
    	// ----- currency Week & Gap week --------------
		if (f_cmd.isCommand(FormCommand.SEARCHLIST12)) {
			String gapmonth       = JSPUtil.getParameter(request, "gapmonth".trim(),"");      // 검색정보
			
	        event = new EesCommonEvent();
	        event.getEesCommonConditionVO().setGapmonth(gapmonth);
		} 	  
		
		//----- Week Valid Check --------------
		//주차가 한개인 화면(ex. EES_EQR_042)
		if (f_cmd.isCommand(FormCommand.SEARCHLIST14)) {
			String gapmonth   = JSPUtil.getParameter(request, "gapmonth".trim(),"");      // 검색정보
			String gubun      = JSPUtil.getParameter(request, "gubun".trim(),"");      // Load : onload시 
			String fm_yr      = JSPUtil.getParameter(request, "fm_yr".trim(),""); 
			String fm_wk      = JSPUtil.getParameter(request, "fm_wk".trim(),"");
			String editmonth  = JSPUtil.getParameter(request, "editmonth".trim(),""); 
			
			
	        event = new EesCommonEvent();
	        event.getEesCommonConditionVO().setGapmonth(gapmonth);
	        event.getEesCommonConditionVO().setGubun(gubun);
	        event.getEesCommonConditionVO().setFmYr(fm_yr);
	        event.getEesCommonConditionVO().setFmWk(fm_wk);
	        event.getEesCommonConditionVO().setEditmonth(editmonth);
	        
		}
		
		//주차가 여러개 인 화면(ex. EES_EQR_037)
		if (f_cmd.isCommand(FormCommand.SEARCHLIST15)) {
			String gapmonth   = JSPUtil.getParameter(request, "gapmonth".trim(),"");      // 검색정보
			String gubun      = JSPUtil.getParameter(request, "gubun".trim(),"");      // Load : onload시 
			String fm_yrwk      = JSPUtil.getParameter(request, "fm_yrwk".trim(),""); 
			String to_yrwk      = JSPUtil.getParameter(request, "to_yrwk".trim(),"");
			String at_yrwk      = JSPUtil.getParameter(request, "at_yrwk".trim(),"");
			String editmonth  = JSPUtil.getParameter(request, "editmonth".trim(),""); 
			
	        event = new EesCommonEvent();
	        event.getEesCommonConditionVO().setGapmonth(gapmonth);
	        event.getEesCommonConditionVO().setGubun(gubun);
	        event.getEesCommonConditionVO().setFmYrwk(fm_yrwk);
	        event.getEesCommonConditionVO().setToYrwk(to_yrwk);
	        event.getEesCommonConditionVO().setAtYrwk(at_yrwk);
	        event.getEesCommonConditionVO().setEditmonth(editmonth);
	        
		}
		
		// 기준 주차를 기준으로 일주일의 년 , 월 ,일 날짜를 가져와서 grid 안에 순서대로 나열한다.
		if (f_cmd.isCommand(FormCommand.SEARCHLIST16)){
            // 기준 주차
			String searchword = JSPUtil.getParameter(request , "yearWeekly".trim(),"");  
            // GRID에 저정 시킬 시작 ROW 컬럼
			String row        = JSPUtil.getParameter(request , "Row".trim() , "");   
            // GRID 에 저장된 save 이름
			String savename   = JSPUtil.getParameter(request , "Col1".trim() ,"");  
			
			event = new EesCommonEvent();
			event.getEesCommonConditionVO().setWeeklySearchword(searchword);
			event.getEesCommonConditionVO().setWeeklyRow(row);
			event.getEesCommonConditionVO().setWeeklySavename(savename);
			
		}

		// --------- SEARCH WEEK DATE PERIOD -----------------------
		// using in 059.js
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST17)) {
        	String weekperiod_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String weekperiod_colname1   = JSPUtil.getParameter(request, "colname1".trim(),"");      // column name
        	String weekperiod_colname2   = JSPUtil.getParameter(request, "colname2".trim(),"");      // column name
        	String weekperiod_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 검색정보
        	String weekperiod_division   = JSPUtil.getParameter(request, "division".trim(),"");    // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setWeekperiodRow(weekperiod_row);
        	event.getEesCommonConditionVO().setWeekperiodColname1(weekperiod_colname1);
        	event.getEesCommonConditionVO().setWeekperiodColname2(weekperiod_colname2);
        	event.getEesCommonConditionVO().setWeekperiodSearchword(weekperiod_searchword);
        	event.getEesCommonConditionVO().setWeekperiodDivision(weekperiod_division);
		}
    	
		// --------- SEARCH ETA DATE -----------------------
		// using in 059.js
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST18)) {
        	String searcheta_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String searcheta_colname    = JSPUtil.getParameter(request, "colname".trim(),"");      // column name
        	String searcheta_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 검색정보
        	String searcheta_fryard 	= JSPUtil.getParameter(request, "fryard".trim(),"");        // 검색정보
        	String searcheta_toyard 	= JSPUtil.getParameter(request, "toyard".trim(),"");        // 검색정보
        	String searcheta_item 		= JSPUtil.getParameter(request, "item".trim(),"");          // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setSearchetaRow(searcheta_row);
        	event.getEesCommonConditionVO().setSearchetaColname(searcheta_colname);
        	event.getEesCommonConditionVO().setSearchetaSearchword(searcheta_searchword);
        	event.getEesCommonConditionVO().setSearchetaFryard(searcheta_fryard);
        	event.getEesCommonConditionVO().setSearchetaToyard(searcheta_toyard);
        	event.getEesCommonConditionVO().setSearchetaItem(searcheta_item);
		}    	

    	//--------- SEARCH 임대사 YARD COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST19)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 검색정보
        	String locyard_div_cd = JSPUtil.getParameter(request, "div_cd".trim(),"");    // 검색정보
        	String locyard_vndr_seq = JSPUtil.getParameter(request, "vndr_seq".trim(),"");    // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
        	event.getEesCommonConditionVO().setLocyardDivCd(locyard_div_cd);
        	event.getEesCommonConditionVO().setLocyardVndrSeq(locyard_vndr_seq);
		}

		// --------- SEARCH LOC YARD(vessel) COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST20)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
		}  

		// --------- SEARCH VENDOR INFO BY SEQ -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH)) {
        	String seq_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String seq_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setSeqRow(seq_row);
        	event.getEesCommonConditionVO().setSeqSearchword(seq_searchword);
		}   
    	
		// --------- SEARCH LOC YARD COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH01) || f_cmd.isCommand(FormCommand.SEARCH17) || f_cmd.isCommand(FormCommand.SEARCH19)) {
        	String locyardInitial_row     = JSPUtil.getParameter(request, "row".trim(),"");    // row정보
        	String locyardInitial_colname = JSPUtil.getParameter(request, "colname".trim(),"");// column name
        	String locyardInitial_ecc     = JSPUtil.getParameter(request, "ecc".trim(),"");    // 검색정보
        	String locyardInitial_vsl     = JSPUtil.getParameter(request, "vsl".trim(),"");    // 검색정보
        	String locyardInitial_item    = JSPUtil.getParameter(request, "item".trim(),"");   // VSL, INLAND(WATER)
        	String locyardfromInitial_ecc     = JSPUtil.getParameter(request, "from_ecc".trim(),"");    // 검색정보
        	
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardinitialRow(locyardInitial_row);
        	event.getEesCommonConditionVO().setLocyardinitialColname(locyardInitial_colname);
        	event.getEesCommonConditionVO().setLocyardinitialEcc(locyardInitial_ecc);
        	event.getEesCommonConditionVO().setLocyardinitialVsl(locyardInitial_vsl);
        	event.getEesCommonConditionVO().setLocyardinitialItem(locyardInitial_item);        	
        	event.getEesCommonConditionVO().setLocyardColname1(locyardfromInitial_ecc);
		}       	

		// --------- SEARCH LOC YARD EXIST -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH02)) {
        	String locyardExist_row     = JSPUtil.getParameter(request, "row".trim(),"");    // row정보
        	String locyardExist_colname = JSPUtil.getParameter(request, "colname".trim(),"");// column name
        	String locyardExist_ecc     = JSPUtil.getParameter(request, "ecc".trim(),"");    // 검색정보
        	String locyardExist_locyard = JSPUtil.getParameter(request, "locyard".trim(),"");    // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardexistRow(locyardExist_row);
        	event.getEesCommonConditionVO().setLocyardexistColname(locyardExist_colname);
        	event.getEesCommonConditionVO().setLocyardexistEcc(locyardExist_ecc);
        	event.getEesCommonConditionVO().setLocyardexistLocyard(locyardExist_locyard);
 
    	}    
    	
		// --------- SEARCH LOC YARD EXIST -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH03)) {
    		
        	String locyardExistCompany_row     = JSPUtil.getParameter(request, "row".trim(),"");    // row정보
        	String locyardExistCompany_colname = JSPUtil.getParameter(request, "colname".trim(),"");// column name
        	String locyardExistCompany_ecc     = JSPUtil.getParameter(request, "ecc".trim(),"");    // 검색정보
        	String locyardExistCompany_locyard = JSPUtil.getParameter(request, "locyard".trim(),"");    // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardexistcompanyRow(locyardExistCompany_row);
        	event.getEesCommonConditionVO().setLocyardexistcompanyColname(locyardExistCompany_colname);
        	event.getEesCommonConditionVO().setLocyardexistcompanyEcc(locyardExistCompany_ecc);
        	event.getEesCommonConditionVO().setLocyardexistcompanyLocyard(locyardExistCompany_locyard);
 
    	}      
    	
		// --------- SEARCH VVD EXIST SEARCH -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH05)) {
        	String vvdExist_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String vvdExist_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String vvdExist_colname1   = JSPUtil.getParameter(request, "colname1".trim(),"");      // ecc column name
        	String vvdExist_searchword = JSPUtil.getParameter(request, "vvd".trim(),"");           // 검색정보 
        	String vvdExist_division   = JSPUtil.getParameter(request, "division".trim(),"");      // etd, eta 검색을 구분
        	String vvdExist_repoplnid  = JSPUtil.getParameter(request, "repoplnid".trim(),"");     // 검색정보 - repo plan id
        	String vvdExist_ecccd 	   = JSPUtil.getParameter(request, "ecccd".trim(),"");         // 검색정보 - ecc cd
        	String vvdExist_plnyrwk    = JSPUtil.getParameter(request, "plnyrwk".trim(),"");       // 검색정보 - pln yrwk
        	String vvdExist_scnrid     = JSPUtil.getParameter(request, "scnr_id".trim(),"");       // 검색정보 - scnr id
            
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setVvdexistRow(vvdExist_row);
        	event.getEesCommonConditionVO().setVvdexistColname(vvdExist_colname);
        	event.getEesCommonConditionVO().setVvdexistColname1(vvdExist_colname1);
        	event.getEesCommonConditionVO().setVvdexistSearchword(vvdExist_searchword);
        	event.getEesCommonConditionVO().setVvdexistDivision(vvdExist_division);
        	event.getEesCommonConditionVO().setVvdexistRepoplnid(vvdExist_repoplnid);
        	event.getEesCommonConditionVO().setVvdexistEcccd(vvdExist_ecccd);
        	event.getEesCommonConditionVO().setVvdexistPlnyrwk(vvdExist_plnyrwk);
        	event.getEesCommonConditionVO().setVvdexistScnrid(vvdExist_scnrid);

		}    	
    	
		// --------- SEARCH VVD INLAND COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH06)) {
        	String vvdInland_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String vvdInland_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String vvdInland_fmecc      = JSPUtil.getParameter(request, "fm_ecc".trim(),"");        // 검색정보 fm_ecc
        	String vvdInland_toecc      = JSPUtil.getParameter(request, "to_ecc".trim(),"");        // 검색정보 to_ecc
        	String vvdInland_etaweek    = JSPUtil.getParameter(request, "eta_week".trim(),"");      // 검색정보 eta_week
	
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setVvdinlandRow(vvdInland_row);
        	event.getEesCommonConditionVO().setVvdinlandColname(vvdInland_colname);
        	event.getEesCommonConditionVO().setVvdinlandFmecc(vvdInland_fmecc);
        	event.getEesCommonConditionVO().setVvdinlandToecc(vvdInland_toecc);
        	event.getEesCommonConditionVO().setVvdinlandEtaweek(vvdInland_etaweek);
        

		}  
    	
    	
//    	 --------- SEARCH  duplicate_check POD  -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH07)) {
        	String pod_row        	= JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String pod_colname    	= JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String pod_wk      		= JSPUtil.getParameter(request, "pln_yrwk".trim(),"");        // 검색정보 week
        	String pod_fixed     	= JSPUtil.getParameter(request, "past_repo_pln_flg".trim(),"");        // 검색정보 fixed
        	String pod_lane   		= JSPUtil.getParameter(request, "land_cd".trim(),"");      // 검색정보 lane
        	String pod_vvd     		= JSPUtil.getParameter(request , "vvd".trim(),"");
        	String pod_pol    		= JSPUtil.getParameter(request, "fm_ecc_cd".trim(),"");      // 검색정보 pol
        	String pod_etd    		= JSPUtil.getParameter(request, "fm_etd_dt".trim(),"");      // 검색정보 etd
        	String pod_pod    		= JSPUtil.getParameter(request, "to_ecc_cd".trim(),"");      // 검색정보 pod
        	String pod_etb    		= JSPUtil.getParameter(request, "to_etb_dt".trim(),"");      // 검색정보 etb
	        String pod_repo_pln_id  = JSPUtil.getParameter(request, "repo_pln_id".trim(), "");  // 검색정보 repo_pln_id
	        
//	        log.info("==============HTMLACT==>" + pod_row);
//	        log.info("==============pod_eta==>" + pod_eta);
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setPodRow(pod_row);
        	event.getEesCommonConditionVO().setPodColname(pod_colname);
        	event.getEesCommonConditionVO().setPodWk(pod_wk);
        	event.getEesCommonConditionVO().setPodFixed(pod_fixed);
        	event.getEesCommonConditionVO().setPodLane(pod_lane);
        	event.getEesCommonConditionVO().setPodVvd((pod_vvd));
        	event.getEesCommonConditionVO().setPodPol(pod_pol);
        	event.getEesCommonConditionVO().setPodEtd(pod_etd);
        	event.getEesCommonConditionVO().setPodPod(pod_pod);
        	event.getEesCommonConditionVO().setPodEta(pod_etb);
        	event.getEesCommonConditionVO().setPodRepoPlnId(pod_repo_pln_id);

		} 
    	
//    	----- Week Valid Check --------------
		//주차가 한개인 화면(ex. EES_EQR_072)에서 현재 주차에서 -8주차인 화면 
		if (f_cmd.isCommand(FormCommand.SEARCH08)) {
			String gapmonth   = JSPUtil.getParameter(request, "gapmonth".trim(),"");      // 검색정보
			String gubun      = JSPUtil.getParameter(request, "gubun".trim(),"");      // Load : onload시 
			String fm_yr      = JSPUtil.getParameter(request, "fm_yr".trim(),""); 
			String fm_wk      = JSPUtil.getParameter(request, "fm_wk".trim(),"");
			String editmonth  = JSPUtil.getParameter(request, "editmonth".trim(),""); 
			
//			log.debug("\n GAPMonth " + gapmonth);
//			log.debug("\n gubun " + gubun);
//			log.debug("\n fm_yr " + fm_yr);
//			log.debug("\n fm_wk " + fm_wk);
			
	        event = new EesCommonEvent();
	        event.getEesCommonConditionVO().setGapmonth(gapmonth);
	        event.getEesCommonConditionVO().setGubun(gubun);
	        event.getEesCommonConditionVO().setFmYr(fm_yr);
	        event.getEesCommonConditionVO().setFmWk(fm_wk);
	        event.getEesCommonConditionVO().setEditmonth(editmonth);
	        
		}
    	

		//VESSEL SKD을 VSK_VSL_PORT_SKD에서 조회를 해온다.  
		if (f_cmd.isCommand(FormCommand.SEARCH09)) {
			String vsl_cd      		= JSPUtil.getParameter(request, "vsl_cd".trim(),"");      
			String skd_voy_no  		= JSPUtil.getParameter(request, "skd_voy_no".trim(),"");   
			String skd_dir_cd  		= JSPUtil.getParameter(request, "skd_dir_cd".trim(),"");  
			String vsl_port_cd 		= JSPUtil.getParameter(request, "vsl_port_cd".trim(),""); 
			String fm_wk       		= JSPUtil.getParameter(request, "fm_wk".trim(),""); 
			String to_wk       		= JSPUtil.getParameter(request, "to_wk".trim(),"");
			String eta_dt_colname   = JSPUtil.getParameter(request, "eta_dt_colname".trim(),"");
			String etb_dt_colname   = JSPUtil.getParameter(request, "etb_dt_colname".trim(),"");
			String etd_dt_colname   = JSPUtil.getParameter(request, "etd_dt_colname".trim(),"");
			String yd_cd_colname	= JSPUtil.getParameter(request, "yd_cd_colname".trim(),"");
			String row              = JSPUtil.getParameter(request, "Row".trim(),"");
			String slan_cd          = JSPUtil.getParameter(request, "slan_cd".trim(),"");
			
//			log.debug("\n vsl_cd " + vsl_cd);
//			log.debug("\n skd_voy_no " + skd_voy_no);
//			log.debug("\n skd_dir_cd " + skd_dir_cd);
//			log.debug("\n vsl_port_cd " + vsl_port_cd);
//			log.debug("\n fm_wk " + fm_wk);
//			log.debug("\n to_wk " + to_wk);
//			log.debug("\n eta_dt_colname " + eta_dt_colname);
//			log.debug("\n etb_dt_colname " + etb_dt_colname);
//			log.debug("\n etd_dt_colname " + etd_dt_colname);
//			log.debug("\n etd_dt_colname " + etd_dt_colname);
//			log.debug("\n slan_cd :" + slan_cd);
			
	        event = new EesCommonEvent();
	        event.getEesCommonConditionVO().setVslCd(vsl_cd);
	        event.getEesCommonConditionVO().setSkdDirCd(skd_dir_cd);
	        event.getEesCommonConditionVO().setSkdVoyNo(skd_voy_no);
	        event.getEesCommonConditionVO().setVslPortCd(vsl_port_cd);
	        event.getEesCommonConditionVO().setFmWk(fm_wk);
	        event.getEesCommonConditionVO().setToWk(to_wk);
	        event.getEesCommonConditionVO().setEtaDtColname(eta_dt_colname);
	        event.getEesCommonConditionVO().setEtbDtColname(etb_dt_colname);
	        event.getEesCommonConditionVO().setEtdDtColname(etd_dt_colname);
	        event.getEesCommonConditionVO().setSlanCd(slan_cd);
	        event.getEesCommonConditionVO().setYdCdColname(yd_cd_colname);
	        event.getEesCommonConditionVO().setRow(row);
	        
		}
		// 신규프로젝트 No  - [ S2Q-09P-004 ]
		// 해당 VVD에 따른 Bay Port 조회
		
		//		 --------- SEARCH Bay Port COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST13)) {
        	String vvd = JSPUtil.getParameter(request, "vvd".trim(),"");    // 검색정보
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setVvd(vvd);
		}
    	
    	//   LANE을 VVD로 VSK_VSL_PORT_SKD에서 조회를 해온다.  
		if (f_cmd.isCommand(FormCommand.SEARCH10)) {
			String vsl_cd      		= JSPUtil.getParameter(request, "vsl_cd".trim(),"");      
			String skd_voy_no  	= JSPUtil.getParameter(request, "skd_voy_no".trim(),"");   
			String skd_dir_cd  	= JSPUtil.getParameter(request, "skd_dir_cd".trim(),""); 
			String row				= JSPUtil.getParameter(request, "row".trim(),"");
        	String scnrid			= JSPUtil.getParameter(request, "scnr_id".trim(),"");       // 검색정보 - scnr id
        	String etbSYr			= JSPUtil.getParameter(request, "etbSYr".trim(), "");
        	String etbSWk			= JSPUtil.getParameter(request, "etbSWk".trim(), "");
        	String etbEYr			= JSPUtil.getParameter(request, "etbEYr".trim(), "");
        	String etbEWk			= JSPUtil.getParameter(request, "etbEWk".trim(), "");
			
	        event = new EesCommonEvent();
	        event.getEesCommonConditionVO().setScnrId(scnrid);
	        event.getEesCommonConditionVO().setVslCd(vsl_cd);
	        event.getEesCommonConditionVO().setSkdDirCd(skd_dir_cd);
	        event.getEesCommonConditionVO().setSkdVoyNo(skd_voy_no);
	        event.getEesCommonConditionVO().setRow(row);			
	        // Preiod
    		event.getEesCommonConditionVO().setFrYyyy(etbSYr);
    		event.getEesCommonConditionVO().setFrWeek(etbSWk);
    		event.getEesCommonConditionVO().setToYyyy(etbEYr);
    		event.getEesCommonConditionVO().setToWeek(etbEWk);
	        
		}
		
		// EQR All-Weeks' Plan Access Grant Check
		if (f_cmd.isCommand(FormCommand.SEARCH11)) {
	        event = new EesCommonEvent();
		}
		
		// --------- SEARCH LOC YARD-ECC COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH14)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_colname1   = JSPUtil.getParameter(request, "colname1".trim(),"");      // ecc column name
        	String locyard_searchword = JSPUtil.getParameter(request, "locyard".trim(),"");    // 검색정보
        	String locyard_ecc = JSPUtil.getParameter(request, "ecc".trim(),"");              // 검색정보    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardColname1(locyard_colname1);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
        	event.getEesCommonConditionVO().setLocyardEcc(locyard_ecc);
		}
    	
    	
    	
    	if(f_cmd.isCommand(FormCommand.SEARCH16) || f_cmd.isCommand(FormCommand.SEARCH20)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row정보
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_colname1   = JSPUtil.getParameter(request, "colname1".trim(),"");      // ecc column name
        	String locyard_searchword = JSPUtil.getParameter(request, "locyard".trim(),"");    // 검색정보
        	String locyard_ecc = JSPUtil.getParameter(request, "ecc".trim(),"");              // 검색정보    	
        	
        	String locfmyard_searchword = JSPUtil.getParameter(request, "locfmyard".trim(),"");    // 검색정보
        	String loctoyard_searchword = JSPUtil.getParameter(request, "loctoyard".trim(),"");    // 검색정보
        	
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardColname1(locyard_colname1);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
        	event.getEesCommonConditionVO().setLocFmyardSearchword(locfmyard_searchword);
        	event.getEesCommonConditionVO().setLocToyardSearchword(loctoyard_searchword);
        	event.getEesCommonConditionVO().setLocyardEcc(locyard_ecc);
		}
    	
    	if (f_cmd.isCommand(FormCommand.SEARCH18)) {
			
	        event = new EesCommonEvent(yyyyww, seq);
	        
		}
    	
    	if (f_cmd.isCommand(FormCommand.SEARCH21)) {
			
	        event = new EesCommonEvent();
	        
		}
    	
    	if (f_cmd.isCommand(FormCommand.SEARCH22)) {
			
			String exectype = JSPUtil.getParameter(request, "exectype".trim(),"");  
			String fmContiCd = JSPUtil.getParameter(request, "fm_conti_cd".trim(),"");  
			String toContiCd = JSPUtil.getParameter(request, "to_conti_cd".trim(),"");  
        	
			event = new EesCommonEvent();	
			
			event.getEesCommonConditionVO().setYyyyww(yyyyww);
			event.getEesCommonConditionVO().setSeq(seq);
			event.getEesCommonConditionVO().setExectype(exectype);
			event.getEesCommonConditionVO().setFmContiCd(fmContiCd);
			event.getEesCommonConditionVO().setToContiCd(toContiCd);
			
	        
		}
    	 	
		
		request.setAttribute("Event", event);
		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}