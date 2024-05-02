/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EES_COMMONHTMLAction.java
*@FileTitle         : common data search
*Open Issues     :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr HTML DOM Value Parsing<br>
 *
 * @author 
 * @see EesCommonEvent , EES_COMMONEventResponse 
 * @since J2EE 1.6
 */
public class EES_COMMONHTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_COMMONHTMLAction 
	 */
	public EES_COMMONHTMLAction() {
	}

	/**
	 * HTML DOM Value Parsing<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		
		FormCommand f_cmd = FormCommand.fromRequest(request);
		EesCommonEvent event = null;    	
		
    	// Retrieve 
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
   	    
    	// Retrieve 
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
        	String loccode_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
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
        	String loccode_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
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
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST05)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
		}    	

		// --------- SEARCH VENDOR Company COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH04)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
		}     	
    	
		// --------- SEARCH VENDOR COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST06)) {
        	String vendor_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String vendor_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String vendor_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setVendorRow(vendor_row);
        	event.getEesCommonConditionVO().setVendorColname(vendor_colname);
        	event.getEesCommonConditionVO().setVendorSearchword(vendor_searchword);
		}     	    	
    	
		// --------- SEARCH VVD COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST08)) {
        	String vvd_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String vvd_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String vvd_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 
        	String repoPlanId     = JSPUtil.getParameter(request, "repo_id".trim(),"");    // 
        	String pln_yrwk       = JSPUtil.getParameter(request, "pln_yrwk".trim(),"");      // 
        	
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setVvdRow(vvd_row);
        	event.getEesCommonConditionVO().setVvdColname(vvd_colname);
        	event.getEesCommonConditionVO().setVvdSearchword(vvd_searchword);
        	event.getEesCommonConditionVO().setVvdRepoplanid(repoPlanId);
        	event.getEesCommonConditionVO().setVvdPlnyrwk(pln_yrwk);
		}    	    	

		// --------- SEARCH LOC YARD-ECC COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST09)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_colname1   = JSPUtil.getParameter(request, "colname1".trim(),"");      // ecc column name
        	String locyard_searchword = JSPUtil.getParameter(request, "locyard".trim(),"");    // 
        	String locyard_ecc = JSPUtil.getParameter(request, "ecc".trim(),"");              //     		
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
			String plnyrwk       = JSPUtil.getParameter(request, "plnyrwk".trim(),"");      // 
			
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
			String gapmonth       = JSPUtil.getParameter(request, "gapmonth".trim(),"");      // 
			
	        event = new EesCommonEvent();
	        event.getEesCommonConditionVO().setGapmonth(gapmonth);
		} 	  
		
		//----- Week Valid Check --------------
		if (f_cmd.isCommand(FormCommand.SEARCHLIST14)) {
			String gapmonth   = JSPUtil.getParameter(request, "gapmonth".trim(),"");      // 
			String gubun      = JSPUtil.getParameter(request, "gubun".trim(),"");      // Load : onload 
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
		
		if (f_cmd.isCommand(FormCommand.SEARCHLIST15)) {
			String gapmonth   = JSPUtil.getParameter(request, "gapmonth".trim(),"");      // 
			String gubun      = JSPUtil.getParameter(request, "gubun".trim(),"");      // Load : onload 
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
		
		if (f_cmd.isCommand(FormCommand.SEARCHLIST16)){

			String searchword = JSPUtil.getParameter(request , "yearWeekly".trim(),"");  
			String row        = JSPUtil.getParameter(request , "Row".trim() , "");   
			String savename   = JSPUtil.getParameter(request , "Col1".trim() ,"");  
			
			event = new EesCommonEvent();
			event.getEesCommonConditionVO().setWeeklySearchword(searchword);
			event.getEesCommonConditionVO().setWeeklyRow(row);
			event.getEesCommonConditionVO().setWeeklySavename(savename);
			
		}

		// --------- SEARCH WEEK DATE PERIOD -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST17)) {
        	String weekperiod_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String weekperiod_colname1   = JSPUtil.getParameter(request, "colname1".trim(),"");      // column name
        	String weekperiod_colname2   = JSPUtil.getParameter(request, "colname2".trim(),"");      // column name
        	String weekperiod_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 
        	String weekperiod_division   = JSPUtil.getParameter(request, "division".trim(),"");    // 
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setWeekperiodRow(weekperiod_row);
        	event.getEesCommonConditionVO().setWeekperiodColname1(weekperiod_colname1);
        	event.getEesCommonConditionVO().setWeekperiodColname2(weekperiod_colname2);
        	event.getEesCommonConditionVO().setWeekperiodSearchword(weekperiod_searchword);
        	event.getEesCommonConditionVO().setWeekperiodDivision(weekperiod_division);
		}
    	
		// --------- SEARCH ETA DATE -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST18)) {
        	String searcheta_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String searcheta_colname    = JSPUtil.getParameter(request, "colname".trim(),"");      // column name
        	String searcheta_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 
        	String searcheta_fryard 	= JSPUtil.getParameter(request, "fryard".trim(),"");        // 
        	String searcheta_toyard 	= JSPUtil.getParameter(request, "toyard".trim(),"");        // 
        	String searcheta_item 		= JSPUtil.getParameter(request, "item".trim(),"");          // 
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setSearchetaRow(searcheta_row);
        	event.getEesCommonConditionVO().setSearchetaColname(searcheta_colname);
        	event.getEesCommonConditionVO().setSearchetaSearchword(searcheta_searchword);
        	event.getEesCommonConditionVO().setSearchetaFryard(searcheta_fryard);
        	event.getEesCommonConditionVO().setSearchetaToyard(searcheta_toyard);
        	event.getEesCommonConditionVO().setSearchetaItem(searcheta_item);
		}    	

    	//--------- SEARCH YARD COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST19)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 
        	String locyard_div_cd = JSPUtil.getParameter(request, "div_cd".trim(),"");    // 
        	String locyard_vndr_seq = JSPUtil.getParameter(request, "vndr_seq".trim(),"");    // 
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
        	event.getEesCommonConditionVO().setLocyardDivCd(locyard_div_cd);
        	event.getEesCommonConditionVO().setLocyardVndrSeq(locyard_vndr_seq);
		}

		// --------- SEARCH LOC YARD(vessel) COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST20)) {
        	String locyard_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String locyard_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String locyard_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardRow(locyard_row);
        	event.getEesCommonConditionVO().setLocyardColname(locyard_colname);
        	event.getEesCommonConditionVO().setLocyardSearchword(locyard_searchword);
		}  

		// --------- SEARCH VENDOR INFO BY SEQ -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH)) {
        	String seq_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String seq_searchword = JSPUtil.getParameter(request, "searchword".trim(),"");    // 
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setSeqRow(seq_row);
        	event.getEesCommonConditionVO().setSeqSearchword(seq_searchword);
		}   
    	
		// --------- SEARCH LOC YARD COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH01) || f_cmd.isCommand(FormCommand.SEARCH12)) {
        	String locyardInitial_row     = JSPUtil.getParameter(request, "row".trim(),"");    // row
        	String locyardInitial_colname = JSPUtil.getParameter(request, "colname".trim(),"");// column name
        	String locyardInitial_ecc     = JSPUtil.getParameter(request, "ecc".trim(),"");    // 
        	String locyardInitial_vsl     = JSPUtil.getParameter(request, "vsl".trim(),"");    // 
        	String locyardInitial_item    = JSPUtil.getParameter(request, "item".trim(),"");   // VSL, INLAND(WATER)
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardinitialRow(locyardInitial_row);
        	event.getEesCommonConditionVO().setLocyardinitialColname(locyardInitial_colname);
        	event.getEesCommonConditionVO().setLocyardinitialEcc(locyardInitial_ecc);
        	event.getEesCommonConditionVO().setLocyardinitialVsl(locyardInitial_vsl);
        	event.getEesCommonConditionVO().setLocyardinitialItem(locyardInitial_item);
		}       	

		// --------- SEARCH LOC YARD EXIST -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH02)) {
        	String locyardExist_row     = JSPUtil.getParameter(request, "row".trim(),"");    // row
        	String locyardExist_colname = JSPUtil.getParameter(request, "colname".trim(),"");// column name
        	String locyardExist_ecc     = JSPUtil.getParameter(request, "ecc".trim(),"");    // 
        	String locyardExist_locyard = JSPUtil.getParameter(request, "locyard".trim(),"");    // 
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardexistRow(locyardExist_row);
        	event.getEesCommonConditionVO().setLocyardexistColname(locyardExist_colname);
        	event.getEesCommonConditionVO().setLocyardexistEcc(locyardExist_ecc);
        	event.getEesCommonConditionVO().setLocyardexistLocyard(locyardExist_locyard);
 
    	}    
    	  
		// --------- SEARCH LOC YARD EXIST -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH03)) {
    		
        	String locyardExistCompany_row     = JSPUtil.getParameter(request, "row".trim(),"");    // row
        	String locyardExistCompany_colname = JSPUtil.getParameter(request, "colname".trim(),"");// column name
        	String locyardExistCompany_ecc     = JSPUtil.getParameter(request, "ecc".trim(),"");    // 
        	String locyardExistCompany_locyard = JSPUtil.getParameter(request, "locyard".trim(),"");    // 
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setLocyardexistcompanyRow(locyardExistCompany_row);
        	event.getEesCommonConditionVO().setLocyardexistcompanyColname(locyardExistCompany_colname);
        	event.getEesCommonConditionVO().setLocyardexistcompanyEcc(locyardExistCompany_ecc);
        	event.getEesCommonConditionVO().setLocyardexistcompanyLocyard(locyardExistCompany_locyard);
 
    	}      
    	
		// --------- SEARCH VVD EXIST SEARCH -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH05)) {
        	String vvdExist_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String vvdExist_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String vvdExist_colname1   = JSPUtil.getParameter(request, "colname1".trim(),"");      // ecc column name
        	String vvdExist_searchword = JSPUtil.getParameter(request, "vvd".trim(),"");           //  
        	String vvdExist_division   = JSPUtil.getParameter(request, "division".trim(),"");      // etd, eta 
        	String vvdExist_repoplnid  = JSPUtil.getParameter(request, "repoplnid".trim(),"");     // repo plan id
        	String vvdExist_ecccd 	   = JSPUtil.getParameter(request, "ecccd".trim(),"");         // ecc cd
        	String vvdExist_plnyrwk    = JSPUtil.getParameter(request, "plnyrwk".trim(),"");       // pln yrwk
        	String vvdExist_scnrid     = JSPUtil.getParameter(request, "scnr_id".trim(),"");       // scnr id
            
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
        	String vvdInland_row        = JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String vvdInland_colname    = JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String vvdInland_fmecc      = JSPUtil.getParameter(request, "fm_ecc".trim(),"");        // fm_ecc
        	String vvdInland_toecc      = JSPUtil.getParameter(request, "to_ecc".trim(),"");        // to_ecc
        	String vvdInland_etaweek    = JSPUtil.getParameter(request, "eta_week".trim(),"");      // eta_week
	
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setVvdinlandRow(vvdInland_row);
        	event.getEesCommonConditionVO().setVvdinlandColname(vvdInland_colname);
        	event.getEesCommonConditionVO().setVvdinlandFmecc(vvdInland_fmecc);
        	event.getEesCommonConditionVO().setVvdinlandToecc(vvdInland_toecc);
        	event.getEesCommonConditionVO().setVvdinlandEtaweek(vvdInland_etaweek);
        

		}  
    	
    	
//    	 --------- SEARCH  duplicate_check POD  -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCH07)) {
        	String pod_row        	= JSPUtil.getParameter(request, "row".trim(),"");           // row
        	String pod_colname    	= JSPUtil.getParameter(request, "colname".trim(),"");       // column name
        	String pod_wk      		= JSPUtil.getParameter(request, "pln_yrwk".trim(),"");        //  week
        	String pod_fixed     	= JSPUtil.getParameter(request, "past_repo_pln_flg".trim(),"");        //  fixed
        	String pod_lane   		= JSPUtil.getParameter(request, "land_cd".trim(),"");      //  lane
        	String pod_vvd     		= JSPUtil.getParameter(request , "vvd".trim(),"");
        	String pod_pol    		= JSPUtil.getParameter(request, "fm_ecc_cd".trim(),"");      //  pol
        	String pod_etd    		= JSPUtil.getParameter(request, "fm_etd_dt".trim(),"");      //  etd
        	String pod_pod    		= JSPUtil.getParameter(request, "to_ecc_cd".trim(),"");      //  pod
        	String pod_etb    		= JSPUtil.getParameter(request, "to_etb_dt".trim(),"");      //  etb
	        String pod_repo_pln_id  = JSPUtil.getParameter(request, "repo_pln_id".trim(), "");  //  repo_pln_id

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
		if (f_cmd.isCommand(FormCommand.SEARCH08)) {
			String gapmonth   = JSPUtil.getParameter(request, "gapmonth".trim(),"");      // 
			String gubun      = JSPUtil.getParameter(request, "gubun".trim(),"");      // Load : onload 
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
    	

		//VESSEL SKD
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

		//		 --------- SEARCH Bay Port COMBO BOX -----------------------
    	if(f_cmd.isCommand(FormCommand.SEARCHLIST13)) {
        	String vvd = JSPUtil.getParameter(request, "vvd".trim(),"");    //
    		
        	event = new EesCommonEvent();	
        	
        	event.getEesCommonConditionVO().setVvd(vvd);
		}
    	
    	//   LANE
		if (f_cmd.isCommand(FormCommand.SEARCH10)) {
			String vsl_cd      		= JSPUtil.getParameter(request, "vsl_cd".trim(),"");      
			String skd_voy_no  	= JSPUtil.getParameter(request, "skd_voy_no".trim(),"");   
			String skd_dir_cd  	= JSPUtil.getParameter(request, "skd_dir_cd".trim(),""); 
			String row				= JSPUtil.getParameter(request, "row".trim(),"");
        	String scnrid			= JSPUtil.getParameter(request, "scnr_id".trim(),"");       //  scnr id
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
		
		request.setAttribute("Event", event);
		return  event;
	}

	/**
	 * HttpRequest attribute
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest attribute<br>
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}