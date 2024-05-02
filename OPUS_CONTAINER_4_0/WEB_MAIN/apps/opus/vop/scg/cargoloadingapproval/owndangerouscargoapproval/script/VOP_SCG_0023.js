/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0023.js
*@FileTitle  : SPCL CGO Approved Details
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0023 : business script for vop_scg_0023
     */
//    function vop_scg_0023() {
//    	this.processButtonClick=processButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var nexttab=-1;
    var searchTab=-1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
	var comboCnt=0;
	var map1_ct=0; 
	var sheet1RowCt=0;
    var searchEndBlk=true;
    
    var vvdRequChk = false;
    var bkgRequChk = false;
    
    var arrVal    = new Array();	//BookingUtilDBDAOBkgComboRSQL > CD02146 肄붾뱶濡??ㅻ뜑?뺣낫媛?졇?ㅺ린
    var arrValAry = new Array();
     
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick() {
        var tabObj=tabObjects[0];
        /*******************************************************/
        var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrive":
                	doActionIBSheet(sheetObjects[getIdx()],formObj,IBSEARCH,'BTN');
                    break;
                case "btn_stowage_instruction":
                	doActionIBSheet(sheetObjects[0],formObj,COMMAND01,'BTN');
                    break;                    
                case "btn_new":
                	if(!validateForm(sheetObjects[getIdx()],formObj,IBCLEAR,'BTN')) return;
                	ComResetAll();
                	ComSetFocus(rgn_shp_opr_cd);
                	ComAddSeparator(document.form.from_eta_dt);
                    ComAddSeparator(document.form.to_eta_dt);
                    btnEnabled(sheetObjects[getIdx()], false);
                    searchTab=-1;
                    break;
                case "btn_Save":
                	doActionIBSheet(sheetObjects[getIdx()],formObj,IBSAVE,'BTN');
                	break;
                case "btn_t1appl0":
                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].GetSelectRow());
                    break;
                case "btn_t1appl1":
                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].GetSelectRow());
                    break;
                case "btn_t1appl2":
                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].GetSelectRow());
                    break;
                case "btn_t1appl3":
                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].GetSelectRow());
                    break;
                case "btn_t1appl4":
                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].GetSelectRow());
                    break;
//                case "btn_t1appl5":
//                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].GetSelectRow());
//                    break;                    
                case "btn_t1downExcel0":
                    var paramObj=new Object();
                    paramObj.title="[DG]SPCL CGO Approved Details";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObjects[getIdx()]);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObjects[getIdx()]);
                    var url=ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj); 
                    if(sheetObjects[getIdx()].RowCount() < 1){//no data
                    	ComShowCodeMessage("COM132501");
       	       		}else{
//       	       			sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]), SheetDesign:1,Merge:1 });
	       	       		//怨듯넻?묒??ㅼ슫濡쒕뱶 - ?곷떒??씠??쟻??
       	       			var str = sheetObjects[getIdx()].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	    	       		sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]), SheetDesign:1,Merge:1,ReportXML:str});       	       			
       	       		}
//                	sheetObjects[getIdx()].SpeedDown2Excel(-1,false,false,"","",false,false,"[DG]SPCL CGO Approved Details",false,"");                	
                    break;
                case "btn_t1downExcel1":
                    var paramObj=new Object();
                    paramObj.title="[Awkward]SPCL CGO Approved Details";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObjects[getIdx()]);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObjects[getIdx()]);
                    var url=ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj);  
                    if(sheetObjects[getIdx()].RowCount() < 1){//no data
                  		 ComShowCodeMessage("COM132501");
      	       		}else{
//      	       			sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]), SheetDesign:1,Merge:1 });
      	       			//怨듯넻?묒??ㅼ슫濡쒕뱶 - ?곷떒??씠??쟻??
      	       			var str = sheetObjects[getIdx()].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	    	       		sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]), SheetDesign:1,Merge:1,ReportXML:str});          	       			
      	       		}
//                	sheetObjects[getIdx()].SpeedDown2Excel(-1,false,false,"","",false,false,"[Awkward]SPCL CGO Approved Details",false,"");                	
                    break;
                case "btn_t1downExcel2":
                    var paramObj=new Object();
                    paramObj.title="[Break Bulk]SPCL CGO Approved Details";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObjects[getIdx()]);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObjects[getIdx()]);
                    var url=ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj);  
                    if(sheetObjects[getIdx()].RowCount() < 1){//no data
                  		 ComShowCodeMessage("COM132501");
      	       		}else{
//      	       			sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]), SheetDesign:1,Merge:1 });
	       	       		var str = sheetObjects[getIdx()].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	    	       		sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]), SheetDesign:1,Merge:1,ReportXML:str});         	       			
      	       		}
//                	sheetObjects[getIdx()].SpeedDown2Excel(-1,false,false,"","",false,false,"[Break Bulk]SPCL CGO Approved Details",false,"");                	
                    break;
                case "btn_t1downExcel3":
                    var paramObj=new Object();
                    paramObj.title="[45']SPCL CGO Approved Details";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObjects[getIdx()]);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObjects[getIdx()]);
                    var url=ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj);
                    if(sheetObjects[getIdx()].RowCount() < 1){//no data
                  		 ComShowCodeMessage("COM132501");
      	       		}else{
//      	       			sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]), SheetDesign:1,Merge:1 });
      	       			var str = sheetObjects[getIdx()].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	    	       		sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]), SheetDesign:1,Merge:1,ReportXML:str});         	       			
      	       		}
//                	sheetObjects[getIdx()].SpeedDown2Excel(-1,false,false,"","",false,false,"[45']SPCL CGO Approved Details",false,"");                	
                    break;
                case "btn_t1downExcel4":
                    var paramObj=new Object();
                    paramObj.title="[Reefer]SPCL CGO Approved Details";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObjects[getIdx()]);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObjects[getIdx()]);
                    var url=ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj);
                    if(sheetObjects[getIdx()].RowCount() < 1){//no data
                  		 ComShowCodeMessage("COM132501");
      	       		}else{
//      	       			sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]), SheetDesign:1,Merge:1 });
      	       			var str = sheetObjects[getIdx()].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	    	       		sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]), SheetDesign:1,Merge:1,ReportXML:str});         	       			
      	       		}
//                	sheetObjects[getIdx()].SpeedDown2Excel(-1,false,false,"","",false,false,"[Reefer]SPCL CGO Approved Details",false,"");                	
                    break;
                case "btn_t1downExcel5":
                    var paramObj=new Object();
                    paramObj.title="[Special Stowage]SPCL CGO Approved Details";
                    paramObj.columnwidth=ComScgGetExcelDown(sheetObjects[getIdx()]);
                    paramObj.cols=ComScgGetExcelDownCols(sheetObjects[getIdx()]);
                    var url=ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj);
                    if(sheetObjects[getIdx()].RowCount() < 1){//no data
                  		 ComShowCodeMessage("COM132501");
      	       		}else{
      	       			var str = sheetObjects[getIdx()].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");

	       	       		 var sobj = sheetObjects[getIdx()]
		       	         var lc = sobj.LastCol();
		       	         var checkBoxCol = "";
		       	         for(var i=0;i<=lc;i++){
		       	         	if( 0 ==sobj.GetColHidden(i) && sobj.GetCellProperty(0,i,"Type") == "CheckBox" ){
		       	         		checkBoxCol += "|"+ i;
		       	         	}
		       	         }

	    	       		sheetObjects[getIdx()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[getIdx()]) + checkBoxCol, SheetDesign:1,Merge:1,ReportXML:str});         	       			
      	       		}
                    break;                    
                case "btn_SlanCd":
	 				onPopupClick(srcName, "Lane");
	 				break;
                case "btn_VVDpop":
	 				onPopupClick(srcName, "VVD");
	 				break;
                case "btn_Pol":
	 				onPopupClick(srcName, "POL");
	 				break;
                case "btn_Pod":
	 				onPopupClick(srcName, "POD");
	 				break;
                case "btn_Carrier":
	 				onPopupClick(srcName, "Carrier");
	 				break;
                case "btn_UNNo":
	 				onPopupClick(srcName, "UNNo");
	 				break;
                case "btn_Calendar":
                	var cal=new ComCalendarFromTo();                	
                	cal.select(formObj.from_eta_dt, formObj.to_eta_dt, 'yyyy-MM-dd');
                	//var calFormObj = document.getElementById(cal.divName+"IFrame").contentWindow.document;
                	//calFormObj.getElementById("from").value = ComGetObjValue(formObj.from_eta_dt);
                	//calFormObj.getElementById("to").value = ComGetObjValue(formObj.to_eta_dt);
	 				break;
                case "btn_t1mail1": case "btn_t1mail3":
                	sendReqMail(sheetObjects[getIdx()], sheetObjects[getIdx()].GetSelectRow(), formObj);
                    break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    
    
	/**
	 * Setting Parameter for RD
	 * 
	 * @param formObj
	 * @return
	 */
	function setQueryStr(formObj){
		var qryStr	= "";
		
		qryStr += "/rv rso_cd[" 		+ formObj.rgn_shp_opr_cd.value + "]";
		qryStr += " auth_flg["			+ ComGetObjValue(formObj.auth_flg)        + "]";  // ComGetObjValue(formObj.auth_flg)  formObj.auth_flg.value 
		qryStr += " vsl_slan_cd["		+ formObj.slan_cd1.value       + "]";
		qryStr += " vsl_cd[" 			+ formObj.vsl_cd.value         + "]";
		qryStr += " skd_voy_no[" 		+ formObj.skd_voy_no.value     + "]";
		qryStr += " skd_dir_cd[" 		+ formObj.skd_dir_cd.value     + "]";
		
		qryStr += " pol_cd["			+ formObj.pol_cd.value         + "]";
		qryStr += " pod_cd["			+ formObj.pod_cd.value         + "]";
		qryStr += " cgo_opr_cd["		+ formObj.cgo_opr_cd.value     + "]";
		qryStr += " bkg_ref_no["		+ formObj.booking_no.value     + "]";
		qryStr += " dcgo_ref_no["		+ formObj.dcgo_ref_no.value    + "]";
		qryStr += " apro_ref_no["		+ formObj.apro_ref_no.value    + "]";
		
		qryStr += " imdg_un_no[" 		+ formObj.imdg_un_no.value     + "]";
		qryStr += " imdg_un_no_seq["	+ formObj.imdg_un_no_seq.value + "]";
		qryStr += " imdg_class_cd[" 	+ formObj.imdg_clss_cd.value   + "]";
		
		qryStr += " shpr_nm[" 			+ formObj.prp_shp_nm.value     + "]";
		qryStr += " from_eta_dt["		+ ComReplaceStr(formObj.from_eta_dt, "-", "")    + "]";
		qryStr += " to_eta_dt["			+ ComReplaceStr(formObj.to_eta_dt, "-", "")      + "]";
		qryStr += " upd_usr_id["		+ formObj.user_id.value        + "]";
		
        return qryStr;
	}    
    
    /**
     * sending request mail
     */
    function sendReqMail(sheetObj, Row, formObj) {      	
    	if(Row == -1) {
  			//ComShowCodeMessage("SCG50034");	//'Please use after Retrieve.'
  			return;
  		} else {  		  	
//  			var crr_cd=sheetObj.GetCellValue(Row, "crr_cd");
//  			var bkg_ref_no=sheetObj.GetCellValue(Row, "bkg_ref_no");
//  			var spcl_cgo_rqst_seq=sheetObj.GetCellValue(Row, "spcl_cgo_rqst_seq");
//		  	var rgn_shp_opr_cd= comboObjects[0].GetSelectCode();
//		  	
		  	
  			var crr_cd=sheetObj.GetCellValue(Row, "cgo_opr_cd");
  			var bkg_ref_no=sheetObj.GetCellValue(Row, "bkg_no");
  			var spcl_cgo_rqst_seq=sheetObj.GetCellValue(Row, "spcl_cgo_rqst_seq");
  			var spcl_cgo_apro_rqst_seq=sheetObj.GetCellValue(Row, "spcl_cgo_apro_rqst_seq");
  			var vsl_pre_pst_cd=sheetObj.GetCellValue(Row, "vsl_pre_pst_cd");
  			var vsl_seq=sheetObj.GetCellValue(Row, "vsl_seq");
  			var slan_cd=sheetObj.GetCellValue(Row, "slan_cd");
  			var rgn_shp_opr_cd=sheetObj.GetCellValue(Row, "rgn_shp_opr_cd");
		  	var rgn_shp_opr_cd= comboObjects[0].GetSelectCode();
		  	
		  	var scg_flg="AK";
		  	var send_type="P0";
		  	var user_id=ComGetObjValue(formObj.user_id);
		  	
		  	mailObj.crr_cd=crr_cd;
		  	mailObj.bkg_ref_no=bkg_ref_no;
		  	mailObj.bkg_no=bkg_ref_no;
		  	mailObj.spcl_cgo_rqst_seq=spcl_cgo_rqst_seq;
		  	mailObj.spcl_cgo_apro_rqst_seq=spcl_cgo_apro_rqst_seq;
		  	mailObj.vsl_pre_pst_cd=vsl_pre_pst_cd;
		  	mailObj.vsl_seq=vsl_seq;
		  	mailObj.slan_cd=slan_cd;
		  	mailObj.rgn_shp_opr_cd=rgn_shp_opr_cd;
		  	mailObj.scg_flg=scg_flg;
		  	mailObj.send_type=send_type;
		  	mailObj.user_id=user_id;

		  	ComScgSendMail(sheetObj, formObj, mailObj);
  		}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	
		 document.form.f_cmd.value=SEARCHLIST01;
		 var param=FormQueryString(document.form);
		 param=param + "&cm_code=CD02146";
 		 var sXml=sheetObjects[0].GetSearchData("ESM_Booking_UtilGS.do", param);
		 var arrXml=sXml.split("|$$|");

		 if (arrXml[0].length > 0) {
			arrVal=ComXml2ComboString(arrXml[0], "val", "name");
			arrValAry = arrVal[0].split("|");
		 }    	
    	
        for(i=0;i<sheetObjects.length;i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        resizeSheet();
        for(k=0;k<tabObjects.length;k++) {
            initTab(tabObjects[k],k+1);
//            tabObjects[k].SetSelectedIndex(0);
        }
        
        tab1.SetTabHidden(3, true);
        //Initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
       	 	initCombo(comboObjects[k], k + 1);
        }
        initControl();
        
        $("#from_eta_dt").attr("value", ComGetDateAdd(null, "d", -7));
        $("#to_eta_dt").attr("value"  , ComGetDateAdd(null, "d", 40));
        
        t1sheet1_OnLoadFinish(t1sheet1);
    }
    /**
     * Button deactivate/activate
     */
    function btnEnabled(sheetObj, what) {
    	var sheetNo=getIdx();
    	with(sheetObj) {    		
	      	//SetEnable(what);
	      	if(what) {
	      		if(RowCount()!= 0) {
		      		ComBtnEnable("btn_t1appl"+sheetNo);
		      		ComBtnEnable("btn_t1downExcel"+sheetNo);
		      		ComBtnEnable("btn_t1mail"+sheetNo);
	      		}
	      	} else {
	      		ComBtnDisable("btn_t1appl"+sheetNo);
		      	ComBtnDisable("btn_t1downExcel"+sheetNo);
		      	ComBtnDisable("btn_t1mail"+sheetNo);
	      	}
    	}
    }
    /**
     * Handling t1sheet1 OnLoadFinish Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
  function t1sheet1_OnLoadFinish(sheetObj) {	
    	 btnEnabled(sheetObj, false);
    	 doActionIBCombo(comboObjects[0],1);
    	 doActionIBCombo(comboObjects[1],2);
    	 
		initControl();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
    }
   /**
    * Handling t2sheet1 OnLoadFinish Event
    * param : sheetObj ==> sheet object, ErrMsg ==> result Message
    * 
    */
    function t2sheet1_OnLoadFinish(sheetObj) {	
   		btnEnabled(sheetObj, false);
   }  
   /**
    * Handling t3sheet1 OnLoadFinish Event
    * param : sheetObj ==> sheet object, ErrMsg ==> result Message
    * 
    */
  function t3sheet1_OnLoadFinish(sheetObj) {	
   	 	btnEnabled(sheetObj, false);
   }  
   /**
    * Handling t5sheet1 OnLoadFinish Event
    * param : sheetObj ==> sheet object, ErrMsg ==> result Message
    * 
    */
   function t5sheet1_OnLoadFinish(sheetObj) {	
   	 	btnEnabled(sheetObj, false);
   }
   /**
    * Handling t7sheet1 OnLoadFinish Event
    * param : sheetObj ==> sheet object, ErrMsg ==> result Message
    * 
    */
   function t7sheet1_OnLoadFinish(sheetObj) {	
   	 	btnEnabled(sheetObj, false);
   }
    /**
     * Handling t1sheet1 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//    	searchEndBlk = true;
    	if(searchEndBlk) {
	    	//Initializing MPA1
	    	map1_ct=0;
	    	sheet1RowCt=0;
	    	sheetObj.FrozenCols=12;
	    	//sheetObj.MergeSheet= msPrevColumnMerge + msHeaderOnly;
	  		with (sheetObj) {	
	 			if(RowCount()!= 0) {
	 				//ColumnSort("cgo_opr_cd|bkg_ref_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd","ASC");
	 				btnEnabled(sheetObj, true);
	 				var seqNo=0;
	 	    		var rqstSeq1=-1, rqstSeq2=-1;
	 	    		var net_wgt_sum, psa_no, flsh_pnt_cdo_temp, mpa1_yn;
	  				for ( var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
	  					//In case of own company, BKG COMP fixed setting
	  					if(GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') SetCellValue(checkRow, "cgo_opr_cd", ConstantMgr.getCompanyCode(),0); 
	  					if(GetCellValue(checkRow, "rsd_flg") == '') SetCellValue(checkRow, "rsd_flg", 'N',0);
	  					setAuthStat(sheetObj, checkRow);
//	  					if(GetCellValue(checkRow, "cgo_opr_cd") == ConstantMgr.getCompanyCode() && GetCellValue(checkRow, "spcl_cgo_auth_cd") == "Y")
//	  						//CellEditable(checkRow, "apro_ref_no") = true;
//	  						if(GetCellValue(checkRow, "cgo_opr_cd") != ConstantMgr.getCompanyCode())
//	  						SetCellEditable(checkRow, "spcl_cgo_auth_cd",1);
//	  					SetCellValue(checkRow, "auth_sts_cd",GetCellValue(checkRow, "spcl_cgo_auth_cd"),0);
//	  					SetCellValue(checkRow, "org_auth_sts_cd",GetCellValue(checkRow, "spcl_cgo_auth_cd"),0);
	  					//MPA1 decision
	  					net_wgt_sum=GetCellValue(checkRow, "net_wgt_sum");
	  					psa_no=GetCellValue(checkRow, "psa_no");
	  					flsh_pnt_cdo_temp=GetCellValue(checkRow, "flsh_pnt_cdo_temp");
	  					if(net_wgt_sum == "-1") {
	  						mpa1_yn="N";
	  					} else {
	  						if(psa_no == '1' || (flsh_pnt_cdo_temp != '' && parseInt(flsh_pnt_cdo_temp,10) < -25)) {
	  							mpa1_yn="Y";
	  							map1_ct++;
	  						} else mpa1_yn="N";
	  					}  					
	  					SetCellValue(checkRow, "mpa1_yn",mpa1_yn,0);

						rqstSeq1=GetCellValue(checkRow, "crr_cd")+""+
				                 GetCellValue(checkRow, "bkg_no")+""+
				                 GetCellValue(checkRow, "vsl_cd")+""+
				                 GetCellValue(checkRow, "skd_voy_no")+""+
				                 GetCellValue(checkRow, "skd_dir_cd")+""+
				                 GetCellValue(checkRow, "pol_cd")+""+
				                 GetCellValue(checkRow, "pod_cd")+""+
				                 GetCellValue(checkRow, "cgo_opr_cd")
		                 
	  					if(rqstSeq1 != rqstSeq2) seqNo++;
	  					SetCellValue(checkRow, "seqNum",seqNo,0);
	 	    			rqstSeq2=rqstSeq1;
//	 	    			for(var checkCol=0; checkCol<SaveNameCol("seqNo"); checkCol++) {
//	 	    				if(GetCellValue(checkRow, checkCol) == ''){
//	 	 	    					SetCellValue(checkRow, checkCol,' ',0);
//	 	    				}
//	 	    			}
//	  					SetRowStatus(checkRow,'R');
	  				} 
	  				sheet1RowCt=RowCount();
	  				//MPA1 Filtering
	  				filterMpa1List(sheetObj, document.form, sheet1RowCt, 'search'); 
	  			} else {
	  				btnEnabled(sheetObj, false);
	  				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
	  			}
	  		}
	  		//2016-11-04 
	  		resizeSheet();
    	}
    	ComOpenWait(false);
    }
    /**
     * Handling t2sheet1 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
      	//perform in case retrieved data exists		
    	with (sheetObj) {		
 			if(RowCount()!= 0) {
 				ColumnSort("cgo_opr_cd|bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd","ASC","",1);
 				btnEnabled(sheetObj, true);
 				var seqNo=0;
 	    		var rqstSeq1=-1, rqstSeq2=-1;
				for ( var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
					//perform in case retrieved data exists
					if(GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') SetCellValue(checkRow, "cgo_opr_cd",ConstantMgr.getCompanyCode(),0);
					setAuthStat(sheetObj, checkRow);
//					if(GetCellValue(checkRow, "cgo_opr_cd") == ConstantMgr.getCompanyCode() && GetCellValue(checkRow, "spcl_cgo_auth_cd") == "Y")
//						//CellEditable(checkRow, "apro_ref_no") = true;
//						if(GetCellValue(checkRow, "cgo_opr_cd") != ConstantMgr.getCompanyCode())
//						SetCellEditable(checkRow, "spcl_cgo_auth_cd",1);
//					SetCellValue(checkRow, "auth_sts_cd",GetCellValue(checkRow, "spcl_cgo_auth_cd"),0);
//					SetCellValue(checkRow, "org_auth_sts_cd",GetCellValue(checkRow, "spcl_cgo_auth_cd"),0);
					if(GetCellValue(checkRow, "spcl_cntr_seq") == '') SetCellValue(checkRow, "spcl_cntr_seq",GetCellValue(checkRow, "awk_cgo_seq"),0);
					if(GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
						rqstSeq1=GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+GetCellValue(checkRow, "bkg_no")+""+GetCellValue(checkRow, "vsl_cd")+""+GetCellValue(checkRow, "skd_voy_no")+""+GetCellValue(checkRow, "skd_dir_cd");
  					} else {
  						rqstSeq1=GetCellValue(checkRow, "spcl_cgo_rqst_seq");
  					}
  					if(rqstSeq1 != rqstSeq2) seqNo++;
  					SetCellValue(checkRow, "seqNum",seqNo,0);
 	    			rqstSeq2=rqstSeq1;
 	    			for(var checkCol=0; checkCol<SaveNameCol("seqNo"); checkCol++) {
 	    				if(GetCellValue(checkRow, checkCol) == '') SetCellValue(checkRow, checkCol,' ',0);
 	    			}
					SetRowStatus(checkRow,'R');
				} 
				if(GetCellValue(HeaderRows(), "cgo_opr_cd") != ConstantMgr.getCompanyCode()) {
					ComBtnDisable("btn_t1appl1");
					ComBtnEnable("btn_t1mail1");
				} else {
					ComBtnEnable("btn_t1appl1");
					ComBtnDisable("btn_t1mail1");
				}
			} else {
  				btnEnabled(sheetObj, false);
  			}
		}
    	ComOpenWait(false);
    }
    /**
     * Handling t3sheet1 OnSearchEnd Event 
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
      	//perform in case retrieved data exists
		with (sheetObj) {		
 			if(RowCount()!= 0) {
 				ColumnSort("cgo_opr_cd|bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd","ASC");
 				btnEnabled(sheetObj, true);
 				var seqNo=0;
 	    		var rqstSeq1=-1, rqstSeq2=-1;
				for ( var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
					//perform in case retrieved data exists
					if(GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') SetCellValue(checkRow, "cgo_opr_cd",ConstantMgr.getCompanyCode(),0);
					setAuthStat(sheetObj, checkRow);
//					if(GetCellValue(checkRow, "cgo_opr_cd") == ConstantMgr.getCompanyCode() && GetCellValue(checkRow, "spcl_cgo_auth_cd") == "Y")
//						//CellEditable(checkRow, "apro_ref_no") = true;
//						if(GetCellValue(checkRow, "cgo_opr_cd") != ConstantMgr.getCompanyCode())
//						SetCellEditable(checkRow, "spcl_cgo_auth_cd",1);
					SetCellValue(checkRow, "spcl_cntr_seq",GetCellValue(checkRow, "bb_cgo_seq"),0);
//					SetCellValue(checkRow, "auth_sts_cd",GetCellValue(checkRow, "spcl_cgo_auth_cd"),0);
//					SetCellValue(checkRow, "org_auth_sts_cd",GetCellValue(checkRow, "spcl_cgo_auth_cd"),0);
					if(GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
						rqstSeq1=GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+GetCellValue(checkRow, "bkg_no")+""+GetCellValue(checkRow, "vsl_cd")+""+GetCellValue(checkRow, "skd_voy_no")+""+GetCellValue(checkRow, "skd_dir_cd");
  					} else {
  						rqstSeq1=GetCellValue(checkRow, "spcl_cgo_rqst_seq");
  					}
  					if(rqstSeq1 != rqstSeq2) seqNo++;
  					SetCellValue(checkRow, "seqNum",seqNo,0);
 	    			rqstSeq2=rqstSeq1;
 	    			for(var checkCol=0; checkCol<SaveNameCol("seqNo"); checkCol++) {
 	    				if(GetCellValue(checkRow, checkCol) == '') SetCellValue(checkRow, checkCol,' ',0);
 	    			}
					SetRowStatus(checkRow,'R');
				} 
			} else {
  				btnEnabled(sheetObj, false);
  			}
		}
		ComOpenWait(false);
    }
    /**
     * Handling t5sheet1 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
       	//perform in case retrieved data exists
 		with (sheetObj) {		
 			if(RowCount()!= 0) {
 				ColumnSort("cgo_opr_cd|bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd","ASC");
 				btnEnabled(sheetObj, true);
 				var seqNo=0;
 	    		var rqstSeq1=-1, rqstSeq2=-1;
 				for ( var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
 					//perform in case retrieved data exists
 					if(GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') SetCellValue(checkRow, "cgo_opr_cd",ConstantMgr.getCompanyCode(),0);
 					setAuthStat(sheetObj, checkRow);
// 					if (GetCellValue(checkRow, "spcl_cgo_auth_cd") == "Y")
//						//CellEditable(checkRow, "apro_ref_no") = true;
// 						if(GetCellValue(checkRow, "cgo_opr_cd") != ConstantMgr.getCompanyCode())
// 						SetCellEditable(checkRow, "spcl_cgo_auth_cd",1);
 					SetCellValue(checkRow, "spcl_cntr_seq",GetCellValue(checkRow, "rc_seq"),0);
// 					SetCellValue(checkRow, "auth_sts_cd",GetCellValue(checkRow, "spcl_cgo_auth_cd"),0);
// 					SetCellValue(checkRow, "org_auth_sts_cd",GetCellValue(checkRow, "spcl_cgo_auth_cd"),0);
 					if(GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
 						rqstSeq1=GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+GetCellValue(checkRow, "bkg_no")+""+GetCellValue(checkRow, "vsl_cd")+""+GetCellValue(checkRow, "skd_voy_no")+""+GetCellValue(checkRow, "skd_dir_cd");
  					} else {
  						rqstSeq1=GetCellValue(checkRow, "spcl_cgo_rqst_seq");
  					}
  					if(rqstSeq1 != rqstSeq2) seqNo++;
  					SetCellValue(checkRow, "seqNum",seqNo,0);
 	    			rqstSeq2=rqstSeq1;
 	    			for(var checkCol=0; checkCol<SaveNameCol("seqNo"); checkCol++) {
 	    				if(GetCellValue(checkRow, checkCol) == '') SetCellValue(checkRow, checkCol,' ',0);
 	    			}
 					SetRowStatus(checkRow,'R');
 				} 
 			} else {
  				btnEnabled(sheetObj, false);
  			}
 		}
 		ComOpenWait(false);
    }
    /**
     * Handling t7sheet1 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function t7sheet1_OnSearchEnd(sheetObj, ErrMsg) {
       	//perform in case retrieved data exists
 		with (sheetObj) {		
 			if(RowCount()!= 0) {
 				//ColumnSort("cgo_opr_cd|bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd","ASC");
 				btnEnabled(sheetObj, true);
 				var seqNo=0;
 	    		var rqstSeq1=-1, rqstSeq2=-1;
 	    		var compCode = ConstantMgr.getCompanyCode();
 				for ( var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
 					//perform in case retrieved data exists
 					if(GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') SetCellValue(checkRow, "cgo_opr_cd", compCode, 0);
 					setAuthStat(sheetObj, checkRow);
// 					if (GetCellValue(checkRow, "spcl_cgo_auth_cd") == "Y")
//						//CellEditable(checkRow, "apro_ref_no") = true;
// 						if(GetCellValue(checkRow, "cgo_opr_cd") != ConstantMgr.getCompanyCode())
// 						SetCellEditable(checkRow, "spcl_cgo_auth_cd",1);
 					SetCellValue(checkRow, "spcl_cntr_seq",GetCellValue(checkRow, "rc_seq"),0);
// 					SetCellValue(checkRow, "auth_sts_cd",GetCellValue(checkRow, "spcl_cgo_auth_cd"),0);
// 					SetCellValue(checkRow, "org_auth_sts_cd",GetCellValue(checkRow, "spcl_cgo_auth_cd"),0);
 					if(GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
 						rqstSeq1=GetCellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+GetCellValue(checkRow, "bkg_no")+""+GetCellValue(checkRow, "vsl_cd")+""+GetCellValue(checkRow, "skd_voy_no")+""+GetCellValue(checkRow, "skd_dir_cd");
  					} else {
  						rqstSeq1=GetCellValue(checkRow, "spcl_cgo_rqst_seq");
  					}
  					if(rqstSeq1 != rqstSeq2) seqNo++;
  					SetCellValue(checkRow, "seqNum",seqNo,0);
 	    			rqstSeq2=rqstSeq1;
 	    			for(var checkCol=0; checkCol<SaveNameCol("seqNo"); checkCol++) {
 	    				if(GetCellValue(checkRow, checkCol) == '') SetCellValue(checkRow, checkCol,' ',0);
 	    			}
 					SetRowStatus(checkRow,'R');
 				} 
 			} else {
  				btnEnabled(sheetObj, false);
  			}
 			
	   		 var j=0;
			 var befBkgNo="";
			 var befVVD="";
			 for (var i=2; i <= LastRow(); i ++){
				 setAuthStat(sheetObj, i);
				 if (befBkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
					 SetCellText(i, "num" ,j);
				 }else{
					 j++;
					 SetCellText(i, "num" ,j);
				 }
				 befBkgNo=GetCellText(i, "bkg_no");
				 befVVD=GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd");
				 SetCellValue(i, "org_spcl_cgo_auth_cd",GetCellValue(i, "spcl_cgo_auth_cd"),0);
				
//	    		 if(GetCellValue(i, "dcgo_flg") == "Y"){
//	    			 SetCellImage(i, "dcgo_flg", 1);
//	    		 }else{
//	    			 SetCellImage(i, "dcgo_flg", 0);
//	    		 }
//	    		 
//	    		 if(GetCellValue(i, "awk_cgo_flg") == "Y"){
//	    			 SetCellImage(i, "awk_cgo_flg", 1);
//	    		 }else{
//	    			 SetCellImage(i, "awk_cgo_flg", 0);
//	    		 }
//	    		 
//	    		 if(GetCellValue(i, "bb_cgo_flg") == "Y"){
//	    			 SetCellImage(i, "bb_cgo_flg", 1);
//	    		 }else{
//	    			 SetCellImage(i, "bb_cgo_flg", 0);
//	    		 }
//	    		 
//	    		 if(GetCellValue(i, "rc_flg") == "Y"){
//	    			 SetCellImage(i, "rc_flg", 1);
//	    		 }else{
//	    			 SetCellImage(i, "rc_flg", 0);
//	    		 }
	    		 
				 for(var j=0; j<arrValAry.length; j++){
					 var colnum = arrValAry[j];

		    		 if(GetCellText(i, "stwg_cd") == GetCellProperty(i, colnum, "SaveName")){
		    			 SetCellValue(i, colnum, "Y", 0);
		    		 }	 
//		    			 SetCellImage(i, colnum, 1);
//		    		 }else{
//		    			 SetCellImage(i, colnum, 0);
//		    		 }
				 }
				 
				 SetRowStatus(i,"R");
			 }
 			
 		}
 		$(".GridMain1 .GridMain2 .GMBool1RO").css("background-image", "url('js/ibsheet/Main/chk1.gif')");
 		ComOpenWait(false);
    }
    
    function makeOnlyCheckBoxCol(sobj){
	    var lc = sobj.LastCol();
	    var rtnStr = "";
	    for(var i=0;i<=lc;i++){
	    	if(sobj.GetCellProperty(0,i,"Type") == "CheckBox"){
	    		rtnStr += "|"+ i;
	    	}
	    }
	    return rtnStr.substring(1);
	}

    /**
     * Handling t1sheet1 OnChange Event
     * param : sheetObj ==> sheet object, changed Row ==> Row, changed Col ==> Col
     */
 	function t1sheet1_OnDblClick(sheetObj,Row,Col,Value){	
    	with(sheetObj) {
    		doPopDetails(sheetObj, Row);
    	}
 		return;
 	}
 	/**
     * Handling t2sheet1 OnChange Event
     * param : sheetObj ==> sheet object, changed Row ==> Row, changed Col ==> Col
     */
 	function t2sheet1_OnDblClick(sheetObj,Row,Col,Value){	
    	with(sheetObj) {
      		doPopDetails(sheetObj, Row);
      	}
 		return;
 	}
 	/**
     * Handling t3sheet1 OnChange Event
     * param : sheetObj ==> sheet object, changed Row ==> Row, changed Col ==> Col
     */
 	function t3sheet1_OnDblClick(sheetObj,Row,Col,Value){	
    	with(sheetObj) {
      		doPopDetails(sheetObj, Row);
      	}
 		return;
 	}
 	/**
     * Handling t5sheet1 OnChange Event
     * param : sheetObj ==> sheet object, changed Row ==> Row, changed Col ==> Col
     */
 	function t5sheet1_OnDblClick(sheetObj,Row,Col,Value){	
    	with(sheetObj) {
      		doPopDetails(sheetObj, Row);
      	}
 		return;
 	}
    /**
     * Handling t1sheet1 OnSelectCell Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting Row, OldCol ==> before selecting Col, selected NewRow ==> NewRow, selected NewCol ==> NewCol
     * 
     */
    function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	var t1Mpa1Yn=document.form.t1Mpa1.checked;
    	var t1Mpa1SelCt=0;
    	with(sheetObj) {
 	    	for(var i=HeaderRows(); i<=LastRow(); i++) {
 	    		if(t1Mpa1Yn && !GetRowHidden(i) && NewRow>=i) {
 	    			t1Mpa1SelCt++
 	    		}
 	    	}
 	     	if (t1Mpa1Yn) {
 	     		SetCountFormat("["+t1Mpa1SelCt+" / "+map1_ct+"]");
 	     	}
     	}
    }
    /**
     * Handling t2sheet1 OnSelectCell Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting Row, OldCol ==> before selecting Col, selected NewRow ==> NewRow, selected NewCol ==> NewCol
     * 
     */
    function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	with(sheetObj) {
 	     	if(GetCellValue(NewRow, "cgo_opr_cd") != ConstantMgr.getCompanyCode()) {
 	     		ComBtnDisable("btn_t1appl1");
 	     		ComBtnEnable("btn_t1mail1");
 	     	} else {
 	     		ComBtnEnable("btn_t1appl1");
 	     		ComBtnDisable("btn_t1mail1");
 	     	}
     	}
    }
    /**
     * Handling t7sheet1 OnSelectCell Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting Row, OldCol ==> before selecting Col, selected NewRow ==> NewRow, selected NewCol ==> NewCol
     * 
     */
    function t7sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	var t1Mpa1Yn=document.form.t1Mpa1.checked;
    	var t1Mpa1SelCt=0;
    	with(sheetObj) {
 	    	for(var i=HeaderRows(); i<=LastRow(); i++) {
 	    		if(t1Mpa1Yn && !GetRowHidden(i) && NewRow>=i) {
 	    			t1Mpa1SelCt++
 	    		}
 	    	}
 	     	if (t1Mpa1Yn) {
 	     		SetCountFormat("["+t1Mpa1SelCt+" / "+map1_ct+"]");
 	     	}
     	}
    	$(".GridMain1 .GridMain2 .GMBool1RO").css("background-image", "url('js/ibsheet/Main/chk1.gif')");
    }
    /**
     * Related event when selecting Combo
     * move focus
     */
    function rgn_shp_opr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
         if(newText != '') ComSetFocus(document.form.auth_flg[0]);
    }     
    function setAuthStat(sheetObj, Row) {
    	with(sheetObj) { 
    		var authStsCd=GetCellValue(Row, "spcl_cgo_auth_cd");
    		var authStsColor="#FF862B";
     		SetCellFont("FontBold", Row, "spcl_cgo_auth_cd",1);
			switch(authStsCd) {
				case "Y":
					authStsColor="#4D964B";
					break;					
				case "N":
					authStsColor="#FF0000";
					break;					
				case "P":
					authStsColor="#2663E0";
					break;
			}
 			SetCellFontColor(Row, "spcl_cgo_auth_cd",authStsColor);
    	}    	
    }
    /**
  	 * Dangerous CGO Application Details for Partner Lines (Pop-Up)<br>
  	 */
  	function doPopDetails(sheetObj, Row) {
  		if(Row == -1 || sheetObj.GetTotalRows()== 0) {
  			ComShowCodeMessage("SCG50034");	//'Please use after Retrieve.'
  		} else {

			var bkg_company=sheetObj.GetCellValue(Row, "cgo_opr_cd");
			var tabIdx=getIdx();
			if(tabIdx == 0) {
				if(bkg_company != ConstantMgr.getCompanyCode()) {
					
		  			var rgn_shp_opr_cd=sheetObj.GetCellValue(Row, "rgn_shp_opr_cd");
				  	if(rgn_shp_opr_cd == '') rgn_shp_opr_cd=rgn_shp_opr_cd.GetSelectCode();
				  	var sParam=Array();
				  	sParam[0]="rgn_shp_opr_cd="+rgn_shp_opr_cd;
//				  	var paramNm="";
//					for(var col=1; col<=sheetObj.LastCol(); col++){
//						paramNm=sheetObj.ColSaveName(col);
//						if(paramNm != "diff_rmk"){
//							sParam[col]=paramNm+"="+encodeURIComponent(sheetObj.GetCellValue(Row, col));	
//						}
//					} 
					sParam[1] ="cgo_opr_cd="+encodeURIComponent(sheetObj.GetCellValue(Row, "cgo_opr_cd"));
					sParam[2] ="bkg_ref_no="+encodeURIComponent(sheetObj.GetCellValue(Row, "bkg_ref_no"));
					sParam[3] ="prnr_cgo_rqst_seq="+encodeURIComponent(sheetObj.GetCellValue(Row, "prnr_cgo_rqst_seq"));
					sParam[4] ="vsl_cd="+encodeURIComponent(sheetObj.GetCellValue(Row, "vsl_cd"));
					sParam[5] ="skd_voy_no="+encodeURIComponent(sheetObj.GetCellValue(Row, "skd_voy_no"));
					sParam[6] ="skd_dir_cd="+encodeURIComponent(sheetObj.GetCellValue(Row, "skd_dir_cd"));
					sParam[7] ="crr_cd="+encodeURIComponent(sheetObj.GetCellValue(Row, "crr_cd"));
					sParam[8] ="spcl_cgo_rqst_seq="+encodeURIComponent(sheetObj.GetCellValue(Row, "spcl_cgo_rqst_seq"));
					sParam[9] ="slan_cd="+encodeURIComponent(sheetObj.GetCellValue(Row, "slan_cd"));
					sParam[10]="pol_cd="+encodeURIComponent(sheetObj.GetCellValue(Row, "pol_cd"));
					sParam[11]="pol_clpt_ind_seq="+encodeURIComponent(sheetObj.GetCellValue(Row, "pol_clpt_ind_seq"));
					sParam[12]="eta_dt=";
					sParam[13]="pod_cd="+encodeURIComponent(sheetObj.GetCellValue(Row, "pod_cd"));
					sParam[14]="pod_clpt_ind_seq="+encodeURIComponent(sheetObj.GetCellValue(Row, "pod_clpt_ind_seq"));
					sParam[15]="spcl_cntr_seq="+encodeURIComponent(sheetObj.GetCellValue(Row, "spcl_cntr_seq"));
					sParam[16]="spcl_cgo_seq="+encodeURIComponent(sheetObj.GetCellValue(Row, "spcl_cgo_seq"));
					sParam[17]="src_tp_cd=";
					
					ComOpenWindowCenter("VOP_SCG_1022.do?mode=view&"+sParam.join("&"), "winViewDtl", "1170", "700", true);
				} else {
					var scg_flg="SCG_DG";
					ComOpenPopup("VOP_SCG_0015.do?type=P&scg_flg="+scg_flg+"&bkg_no="+encodeURIComponent(sheetObj.GetCellText(sheetObj.GetSelectRow(), "bkg_no"))
							                   +"&vvd_cd="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "vsl_cd")
							                              +sheetObj.GetCellText(sheetObj.GetSelectRow(), "skd_voy_no")
							                              +sheetObj.GetCellText(sheetObj.GetSelectRow(), "skd_dir_cd")
							                   +"&dcgo_seq="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "dcgo_seq")
							                   +"&dg_cntr_seq="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "spcl_cntr_seq")
							                   +"&cntr_cgo_seq="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "spcl_cgo_seq")
							                   +"&spcl_cgo_apro_rqst_seq="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "spcl_cgo_apro_rqst_seq")
							     , 1150, 668, "", '0,0', 1, 0, sheetObj.GetSelectRow(), 0, tabIdx, "VOP_SCG_0015"); 
							    //, true, false, sheetObj.GetSelectRow(), 0, tabIdx, "VOP_SCG_0015");
					
//					var auth_cd=sheetObjects[0].GetCellText(Row, "org_auth_sts_cd");
//					ComOpenPopup("VOP_SCG_0015.do?type=P&scg_flg="+scg_flg+"&bkg_no="+sheetObjects[0].GetCellText(Row, "bkg_no")+"&vvd_cd="+sheetObjects[0].GetCellText(Row, "vsl_cd")+sheetObjects[0].GetCellText(Row, "skd_voy_no")+sheetObjects[0].GetCellText(Row, "skd_dir_cd")+"&dg_cntr_seq="+sheetObjects[0].GetCellText(Row, "dg_cntr_seq")+"&cntr_cgo_seq="+sheetObjects[0].GetCellText(Row, "cntr_cgo_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[0].GetCellText(Row, "spcl_cgo_apro_rqst_seq"), 1150, 1010, "", '0,0', 1, 0, Row, 0, 0, "VOP_SCG_0015"); //790					
				}
			} else if(tabIdx == 1 || tabIdx == 3) {
				if(bkg_company == ConstantMgr.getCompanyCode()) {
					var scg_flg="SCG_AWK";
					if(tabIdx == 3) scg_flg="SCG_45";
					ComOpenPopup("VOP_SCG_0016.do?type=P&scg_flg="+scg_flg+"&bkg_no="+encodeURIComponent(sheetObj.GetCellText(sheetObj.GetSelectRow(), "bkg_no"))
							                   +"&vvd_cd="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "vsl_cd")
							                              +sheetObj.GetCellText(sheetObj.GetSelectRow(), "skd_voy_no")
							                              +sheetObj.GetCellText(sheetObj.GetSelectRow(), "skd_dir_cd")
							                   +"&awk_cgo_seq="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "awk_cgo_seq")
							                   +"&spcl_cgo_apro_rqst_seq="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "spcl_cgo_apro_rqst_seq")
							     , 1150, 840, "", '0,0', 1, 0, sheetObj.GetSelectRow(), 0, tabIdx, "VOP_SCG_0016");
				}
			} else if(tabIdx == 2) {				
				ComOpenPopup("VOP_SCG_0017.do?type=P&scg_flg=SCG_BB&bkg_no="+encodeURIComponent(sheetObj.GetCellText(sheetObj.GetSelectRow(), "bkg_no"))
						                   +"&vvd_cd="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "vsl_cd")
						                              +sheetObj.GetCellText(sheetObj.GetSelectRow(), "skd_voy_no")
						                              +sheetObj.GetCellText(sheetObj.GetSelectRow(), "skd_dir_cd")
						                   +"&bb_cgo_seq="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "bb_cgo_seq")
						                   +"&spcl_cgo_apro_rqst_seq="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "spcl_cgo_apro_rqst_seq")
						     , 1023, 780, "", '0,0', 1, 0, sheetObj.GetSelectRow(), 0, tabIdx, "VOP_SCG_0017");
			} else if(tabIdx == 4) {				
				ComOpenPopup("VOP_SCG_0018.do?type=P&scg_flg=SCG_RF&bkg_no="+encodeURIComponent(sheetObj.GetCellText(sheetObj.GetSelectRow(), "bkg_no"))
						                   +"&vvd_cd="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "vsl_cd")
						                              +sheetObj.GetCellText(sheetObj.GetSelectRow(), "skd_voy_no")
						                              +sheetObj.GetCellText(sheetObj.GetSelectRow(), "skd_dir_cd")
						                   +"&rc_seq="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "rc_seq")
						                   +"&spcl_cgo_apro_rqst_seq="+sheetObj.GetCellText(sheetObj.GetSelectRow(), "spcl_cgo_apro_rqst_seq")
						     , 1023, 700, "", '0,0', 1, 0, sheetObj.GetSelectRow(), 0, tabIdx, "VOP_SCG_0018");
			}
  		}
  	}
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "t1sheet1":      
                with (sheetObj) {
	                
	                var HeadTitle1="No.|Lane|VVD CD|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|VSL\nOPR|BKG\nCOMP|BKG\nRef. No.|DG Ref No|Mail\nSent|BKG\nSTS||APVL|RJT\nCD|RMK";
	                HeadTitle1  += "|APVL\nRef. No.|Sequence|Sequence|TPSZ|TP|UN No.\n/Seq.|UN No.\n/Seq.|Class|PSN";
	                HeadTitle1  += "|Sub\nrisks|MP|PG|LQ|EQ|R|FP\n(℃)|Weight (kg)|Weight (kg)|PSA|RQST DT|APVL DT|POL ETA|Remarks|Seg Group|STG|Cargo ST||||||||||||||||||||||";
	                
	                var HeadTitle2="No.|Lane|VVD CD|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|VSL\nOPR|BKG\nCOMP|BKG\nRef. No.|DG Ref No|Mail\nSent|BKG\nSTS||APVL|RJT\nCD|RMK";
	                HeadTitle2  += "|APVL\nRef. No.|CNTR|CGO|TPSZ|TP|UN No.\n/Seq.|UN No.\n/Seq.|Class|PSN";
	                HeadTitle2  += "|Sub\nrisks|MP|PG|LQ|EQ|R|FP\n(℃)|Gross|Net|PSA|RQST DT|APVL DT|POL ETA|Remarks|Seg Group|STG|Cargo ST||||||||||||||||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                //(headCount, 12, 0, true);
	
	                //::2015-06-25:://SetConfig( { SearchMode:0, MergeSheet:7, Page:20, DataRowMerge:0 } );
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                            { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",    Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seqNum",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vsl_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:17,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:42,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",     		        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cgo_opr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dcgo_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_his_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       
		                       {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"spcl_cgo_seq" },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       
		                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       
		                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cntr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dg_tp",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prp_shp_nm",	            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mrn_polut_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_expt_qty_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rsd_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"flsh_pnt_cdo_temp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"net_wgt",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"psa_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"auth_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:120,   Align:"Center", ColMerge:0,   SaveName:"diff_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",   ColMerge:0,   SaveName:"imdg_segr_grp_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"stg_cate",		        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"dcgo_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"net_wgt_sum" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mpa1_yn" },
		                       {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_seq" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rc_seq" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_seq" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rgn_shp_opr_cd" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_no" },
		                       //{Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_rqst_seq" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_ref_no" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"auth_sts_cd" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"org_auth_sts_cd" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"prnr_cgo_rqst_seq" },
		                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cfr_flg" } ];
		                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(319);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                //SetColProperty("spcl_cgo_auth_cd", {ComboText:"R|Y|N", ComboCode:"R|Y|N"} );
	                SetMergeCell(0, 2, 2, 4);	//VVD CD
	                SetMergeCell(0, 7, 2, 2);	//POL
	                SetMergeCell(0, 9, 2, 2);	//POD
	                SetMergeCell(0, 27, 2, 2);	//UN No.
	                //SetRangeBackColor(1,0,1,36,"#555555");
                }
                break;
            case "t2sheet1":    
                with (sheetObj) {
	                
	                var HeadTitle1="No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
	                HeadTitle1     += "|RJT\nCD|RMK|APVL\nRef. No.|CNTR\nSeq.|TPSZ|Over All (cm)|Over All (cm)|Over All (cm)|Over Dimension (cm)|Over Dimension (cm)";
	                HeadTitle1     += "|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Post\nExtd|Gross\nWeight (kg)|Void\n(FEU)|Commodity|RQST\nDT|APVL\nDT||||||||||||||||||||";
	                var HeadTitle2="No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
	                HeadTitle2     += "|RJT\nCD|RMK|APVL\nRef. No.|CNTR\nSeq.|TPSZ|L|W|H|FWD|AFT";
	                HeadTitle2     += "|Left|Right|Height|Post\nExtd|Gross\nWeight (kg)|Void\n(FEU)|Commodity|RQST\nDT|APVL\nDT||||||||||||||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
//	                (headCount, 12, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                            { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seqNum",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:17,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cgo_opr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"seqNo",                    KeyField:0,   CalcLogic:"spcl_cntr_seq" },
	                       {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       
	                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       
	                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cntr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_len",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_wdt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_hgt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ovr_fwrd_len",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ovr_bkwd_len",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ovr_lf_len",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ovr_rt_len",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"ovr_hgt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"post_extd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ovr_void_slt_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"auth_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crr_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_seq" },
	                       {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rc_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rgn_shp_opr_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_no" },
	                       //{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_rqst_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_ref_no" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"auth_sts_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"org_auth_sts_cd" } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(340);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                SetMergeCell(0, 2, 2, 3);	//VVD CD
	                SetMergeCell(0, 6, 2, 2);	//POL
	                SetMergeCell(0, 8, 2, 2);	//POD
	                //SetColProperty("spcl_cgo_auth_cd", {ComboText:"R|Y|N", ComboCode:"R|Y|N"} );
	                SetRangeBackColor(1,0,1,33,"#555555");
                }
                break;
            case "t3sheet1":    
                with (sheetObj) {
	                
	                var HeadTitle1="No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
	                HeadTitle1     += "|RJT\nCD|RMK|APVL\nRef. No.|CGO\nSeq.|Length\n(cm)|Width\n(cm)|Height\n(cm)";
	                HeadTitle1     += "|Gross\nWeight (kg)|Void\n(FEU)|Commodity|RQST\nDT|APVL\nDT||||||||||||||||||";
	                var HeadTitle2="No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
	                HeadTitle2     += "|RJT\nCD|RMK|APVL\nRef. No.|CGO\nSeq.|Length\n(cm)|Width\n(cm)|Height\n(cm)";
	                HeadTitle2     += "|Gross\nWeight (kg)|Void\n(FEU)|Commodity|RQST\nDT|APVL\nDT||||||||||||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
//	                (headCount, 12, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                            { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seqNum",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:17,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cgo_opr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"spcl_cntr_seq" },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       
	                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       
	                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cntr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"dim_len",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"dim_wdt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"dim_hgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ovr_void_slt_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"auth_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crr_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_seq" },
	                       {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rc_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rgn_shp_opr_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_no" },
	                       //{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"auth_sts_cd" },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"org_auth_sts_cd" } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(340);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                SetMergeCell(0, 2, 2, 3);
	                SetMergeCell(0, 6, 2, 2);
	                SetMergeCell(0, 8, 2, 2);
	                //SetColProperty("spcl_cgo_auth_cd", {ComboText:"R|Y|N", ComboCode:"R|Y|N"} );
	                SetRangeBackColor(1,0,1,26,"#555555");
                }
                break;
            case "t4sheet1":    
                with (sheetObj) {
	                
	                var HeadTitle1="No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
	                HeadTitle1     += "|RJT\nCD|RMK|APVL\nRef. No.|CNTR\nSeq.|TPSZ";
	                HeadTitle1     += "|Gross\nWeight (kg)|Commodity|RQST\nDT|APVL\nDT||||||||||||||||||||";
	                var HeadTitle2="No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
	                HeadTitle2     += "|RJT\nCD|RMK|APVL\nRef. No.|CNTR\nSeq.|TPSZ";
	                HeadTitle2     += "|Gross\nWeight (kg)|Commodity|RQST\nDT|APVL\nDT||||||||||||||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
//	                (headCount, 12, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                            { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seqNum",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:17,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cgo_opr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"spcl_cntr_seq" },
		                       {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       
		                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       
		                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cntr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"auth_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crr_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_seq" },
		                       {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rc_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rgn_shp_opr_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_no" },
		                       //{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_rqst_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_ref_no" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"auth_sts_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"org_auth_sts_cd" } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(340);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                SetMergeCell(0, 2, 2, 3);	//VVD CD
	                SetMergeCell(0, 6, 2, 2);	//POL
	                SetMergeCell(0, 8, 2, 2);	//POD
	                //SetColProperty("spcl_cgo_auth_cd", {ComboText:"R|Y|N", ComboCode:"R|Y|N"} );
	                SetRangeBackColor(1,0,1,23,"#555555");
                }
                break;
            case "t5sheet1":    
                with (sheetObj) {	               
	                var HeadTitle1="No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
	                HeadTitle1     += "|RJT\nCD|RMK|APVL\nRef. No.|CNTR\nSeq.|TPSZ";
	                HeadTitle1     += "|Gross\nWeight (kg)|Commodity|RQST\nDT|APVL\nDT||||||||||||||||||";
	                var HeadTitle2="No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
	                HeadTitle2     += "|RJT\nCD|RMK|APVL\nRef. No.|CNTR\nSeq.|TPSZ";
	                HeadTitle2     += "|Gross\nWeight (kg)|Commodity|RQST\nDT|APVL\nDT||||||||||||||||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);
//	                (headCount, 12, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                            { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seqNum",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:17,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cgo_opr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"spcl_cntr_seq" },
		                       {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       
		                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       
		                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cntr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"auth_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crr_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_seq" },
		                       {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rc_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rgn_shp_opr_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_no" },
		                       //{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"auth_sts_cd" },
		                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"org_auth_sts_cd" } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(340);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                SetMergeCell(0, 2, 2, 3);
	                SetMergeCell(0, 6, 2, 2);
	                SetMergeCell(0, 8, 2, 2);
	                //SetColProperty("spcl_cgo_auth_cd", {ComboText:"R|Y|N", ComboCode:"R|Y|N"} );
	                SetRangeBackColor(1,0,1,23,"#555555");
                }
                break;
         	case "t7sheet1":
         		with (sheetObj) {
                var HeadTitle="No.||EDI|Email|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG\nCOMP|BKG \nRef. No.|Elapsed\n(day)|EDI\nSent|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
                HeadTitle   += "CNTR|TPSZ|TPSZ|TP|QTY|UN No.\n/Seq.|UN No.\n/Seq.|Class|Commodity|Sub\nrisks|MP|PG|LQ|EQ|FP(℃)|Gross\nWeight (kg)|Gross\nWeight (kg)|";
                HeadTitle   += "DG|AW|BB|RF|ibflag|stwg_cd|stwg_seq|stwg_flg|bkg_no|spcl_cgo_apro_rqst_seq|vsl_pre_pst_cd|vsl_seq|spcl_cgo_cate_cd|rgn_shp_opr_cd|dcgo_seq|awk_cgo_seq|bb_cgo_seq|rc_seq|spcl_cgo_auth_seq|";
                HeadTitle   += arrVal[0];
//                HeadTitle   +="AB|AF|AF|AL|BC|MU\nPG|OB\nSG|OB\nSS|OD|OD\nAS|OD\nAL|OD\nBC|OD\nFT|UD|UD\nAB|UT|UT\nAB|UW|";
                var HeadTitle1="No.|| ||Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG\nCOMP|BKG \nRef. No.|Elapsed\n(day)|EDI\nSent|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
                HeadTitle1  += "CNTR|TPSZ|TPSZ|TP|QTY|UN No.\n/Seq.|UN No.\n/Seq.|Class|Commodity|Sub\nrisks|MP|PG|LQ|EQ|FP(℃)|Gross\nWeight (kg)|Net|";
                HeadTitle1  += "DG|AW|BB|RF|ibflag|stwg_cd|stwg_seq|stwg_flg|bkg_no|spcl_cgo_apro_rqst_seq|vsl_pre_pst_cd|vsl_seq|spcl_cgo_cate_cd|rgn_shp_opr_cd|dcgo_seq|awk_cgo_seq|bb_cgo_seq|rc_seq|spcl_cgo_auth_seq|";
                HeadTitle1  += arrVal[0];
//                HeadTitle1  +="AB|AF|AF|AL|BC|MU\nPG|OB\nSG|OB\nSS|OD|OD\nAS|OD\nAL|OD\nBC|OD\nFT|UD|UD\nAB|UT|UT\nAB|UW|";
                var headCount=ComCountHeadTitle(HeadTitle);
//                (headCount, 10, 0, true);

                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"},
                            { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [
                           {Type:"Seq",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"num",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                           {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rank_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                           //{Type:"Text",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                           {Type:"CheckBox",  Hidden:1,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"edi_chk_box"     },
                           {Type:"CheckBox",  Hidden:1,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"email_chk_box"   },
                           {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cgo_opr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"booking_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rqst_day",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"edi_snd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Seq",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"ComboEdit", Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	                       
	                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       
	                       {Type:"Text",      Hidden:0,  Width:116,  Align:"Left",    ColMerge:1,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dg_cntr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cgo_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"dg_tp",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"op_cntr_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"mrn_polut_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"imdg_expt_qty_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"flsh_pnt_cdo_temp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0 },
	                       {Type:"Float",     Hidden:1,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"net_wgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0 },
	                       
	                       {Type:"CheckBox",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                       {Type:"CheckBox",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                       {Type:"CheckBox",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                       {Type:"CheckBox",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                       {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"stwg_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"stwg_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       //ScgAuthorizationVO 셋팅용
	                       {Type:"Text",      Hidden:1, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"stwg_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"vsl_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"rgn_shp_opr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"rc_seq",            	    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }
	                       ];

	                       for (var n=0; n < arrValAry.length; n++) {
	                    	   cols.push({Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0, SaveName:""+arrValAry[n], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" });
	                       }

                InitColumns(cols);
                SetEditable(1);
                SetRowHeight(20);
                SetWaitTimeOut(300);
                SetMergeCell(0, 5, 2, 3);
                SetMergeCell(0, 23, 2, 2);
                SetImageList(0, "js/ibsheet/Main/chk0R.gif");
                SetImageList(1, "js/ibsheet/Main/chk1.gif");
    			SetShowButtonImage(1);
                //SetColHidden("seqNo",1);              
                }
         		break;                  
        }
    }
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }

    // event Catch Listener
    function initControl() {
         // Axon event handling1. event catch
//         axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
        // axon_event.addListenerFormat ('focus',    'obj_focus',      form);
         axon_event.addListenerFormat ('blur',     'obj_focusout',   form);
//         axon_event.addListenerForm   ('keyup',    'obj_keyup',      form);
//         axon_event.addListener       ('keydown',  'ComKeyEnter',   'form');
//         axon_event.addListenerForm   ('change',   'obj_change', 	 form);
         axon_event.addListenerForm   ('click',    'obj_click', 	 form); 
    }
    // Handling business javascript OnFocus event
    function obj_focus() {
    	switch(ComGetEvent("name")){ 
	    	case "from_eta_dt":	case "to_eta_dt":	
	    		ComClearSeparator(ComGetEvent());
	        	break;
    	}
    }
    // Handling business javascript OnFocusOut event
    function obj_focusout() {
    	pastEventNum=0;
    	var formObj=document.form;
    	with(ComGetEvent()) {
	    	switch(name) { 
		    	case "slan_cd1":
		    		searchLaneCheck();						//Lane Check
		        	break;
		    	case "vsl_cd":	
		    		if(value.length == 0) {
		    			ComSetObjValue(formObj.vsl_eng_nm, "");
		    		}
		    		if(value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '' && ComGetObjValue(formObj.skd_dir_cd) != '') {
		    			searchVVDCheck();						//VVD Check
		    		}else{
		    			vvdRequChk = false;
		    			searchPolObjCtl();
		    		}
		        	break;
		    	case "skd_voy_no":	
		    		if(value != '' && ComGetObjValue(formObj.skd_voy_no) != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_dir_cd) != '') {
		    			searchVVDCheck();						//VVD Check
		    		}else{
		    			vvdRequChk = false;
		    			searchPolObjCtl();
		    		}
		        	break;
		    	case "skd_dir_cd":	
		    		if(value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {
		    			searchVVDCheck();						//VVD Check
		    		}else{
		    			vvdRequChk = false;
		    			searchPolObjCtl();
		    		}
		        	break;
		    	case "pol_cd": case "pod_cd":	 
		    		searchPortCheck(ComGetEvent());		//Port Check
		        	break;
		    	case "cgo_opr_cd":	
		    		searchCarrierCheck(ComGetEvent());	//Carrier Check
		        	break;
		    	case "imdg_un_no":	
		    		searchUNNoCheck(ComGetEvent());		//UN No. Check
		        	break;
		    	case "imdg_un_no_seq":	
		    		searchUNNoCheck(ComGetEvent());		//UN No. Seq. Check
		        	break;
		    	case "from_eta_dt":	
		    		ComAddSeparator(ComGetEvent());
		    		break;
		    	case "to_eta_dt":
		    		//limit retrieving period
		    		if (ComAddSeparator(ComGetEvent())) {
			    		if (ComGetObjValue(formObj.from_eta_dt) != '' && ComGetObjValue(formObj.to_eta_dt) != '') {
	    		        	//if(ComGetDaysBetween(ComGetObjValue(formObj.from_eta_dt), ComGetObjValue(formObj.to_eta_dt)) > 31) {
    		        			//ComShowCodeMessage('SCG50032', 'month');
    		        			//value="";
    		        			//ComSetFocus(ComGetEvent());
	    		        	//}else{
//						    	formObj.from_eta_dt.className="input1";
//						    	formObj.to_eta_dt.className="input1";
//						    	formObj.vsl_cd.className="input";
//						    	formObj.skd_voy_no.className="input";
//						    	formObj.skd_dir_cd.className="input";
	    		        	//}
			    		}
		    		}
		        	break;
		    	case "booking_no":
		    		if(ComGetObjValue(formObj.booking_no) != ''){
		    			bkgRequChk = true;
		    		}else{
		    			bkgRequChk = false;
		    		}
		    		searchPolObjCtl();
		    		break;
	    	}
	    }
    } 
    // Handling business javascript OnKeyPress event
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(ComGetEvent("name")){
	    	    	case "slan_cd1":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	    	case "vsl_cd":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "skd_voy_no":	
	        	    	ComKeyOnlyNumber(ComGetEvent());
	    	        	break;
	    	        case "skd_dir_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "pol_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "pod_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "cgo_opr_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "booking_no":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "apro_ref_no":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "imdg_un_no":	
	    	        	ComKeyOnlyNumber(ComGetEvent());
	    	        	break;
	    	        case "imdg_un_no_seq":	
	    	        	ComKeyOnlyNumber(ComGetEvent());
	    	        	break;
	    	        case "prp_shp_nm":	
	    	        	ComKeyOnlyAlphabet('uppernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|58|59|60|61|62|63|64|91|92|93|94|95|96|123|124|125|126');
	    	        	break;
    	    	}
    	    	break;
    	    default:
    	    	//common standard:only english,number
    	    	ComKeyOnlyAlphabet("num");
    	    	break;     
    	}
    }  
    // Handling business javascript OnKeyUp event
    function obj_keyup() {
    	if(event.keyCode != 9) obj_nextfocus(ComGetEvent());
    } 
    // move focus - recieved parameter HTML tag(Object)'s next HTML tag(Object)
    function obj_nextfocus(obj) {
    	var formObj=document.form;
    	var objMaxLength=obj.getAttribute("maxlength");
    	var objValue=obj.getAttribute("value");
    	if (ComChkLen(objValue, objMaxLength) == 2) {
    		ComSetNextFocus(obj);
    		if(obj.name == 'vsl_cd') formObj.skd_voy_no.select();
    		else if(obj.name == 'skd_voy_no') formObj.skd_dir_cd.select();
    	}
    }
    // Handling business javascript OnChange event
    function obj_change() {
    	var formObj=document.form;
    	with(ComGetEvent()) {
	    	switch(name){
		    	case "vsl_cd":		
		    		ComSetObjValue(formObj.skd_voy_no, "");
	    			ComSetObjValue(formObj.skd_dir_cd, "");
	    			ComSetObjValue(formObj.vsl_eng_nm, "");
		        	break;
		    	case "skd_voy_no":		
	    			ComSetObjValue(formObj.skd_dir_cd, "");
	    			//ComSetObjValue(formObj.vsl_eng_nm, "");
		        	break;
		    	case "skd_dir_cd":	    			
	    			//ComSetObjValue(formObj.vsl_eng_nm, "");
		        	break;
	    	}
    	}
    }
    // Handling business javascript OnClick event
    function obj_click() {
   	 	var formObj=document.form; 	 		
   	 	switch(ComGetEvent("name")){
   	 		case "t1Mpa1":
   	 			if(sheet1RowCt>0) filterMpa1List(sheetObjects[getIdx()], formObj, 'click');
   	 			break;
   	 	}
    }
    //Handling Only MPA1
    function filterMpa1List(sheetObj, formObj, sheet1RowCt, source) {
    	with(sheetObj) {
    		//if(source == 'click')     		
    		var seqNo=0;
    		var rqstSeq1=-1, rqstSeq2=-1;
    		var firstRow;
    		var strHiddenRow= "";
    		var merge = 1;
	    	if (formObj.t1Mpa1.checked) {
	    		for ( var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
	    			if(GetCellValue(checkRow, "mpa1_yn") == 'N'){
	    				strHiddenRow = strHiddenRow + checkRow + "|";
	    				//SetRowHidden(checkRow,true);
//	    				GetRowHidden(checkRow,true);
//	    				sheetObj.SetRowHidden("1|2|3|4|5|6|7|8|9|10|11", 1);
	    			}else{
	    				if(rqstSeq2 == -1) firstRow=checkRow;
						rqstSeq1=GetCellValue(checkRow, "crr_cd")+""+
				                 GetCellValue(checkRow, "bkg_no")+""+
				                 GetCellValue(checkRow, "vsl_cd")+""+
				                 GetCellValue(checkRow, "skd_voy_no")+""+
				                 GetCellValue(checkRow, "skd_dir_cd")+""+
				                 GetCellValue(checkRow, "pol_cd")+""+
				                 GetCellValue(checkRow, "pod_cd")+""+
				                 GetCellValue(checkRow, "cgo_opr_cd")
		
			   			if(rqstSeq1 != rqstSeq2){
			   				seqNo++;
			   				rqstSeq2=rqstSeq1;
			    				if(merge > 1) {
			    					SetMergeCell(checkRow-merge, SaveNameCol("bkg_no"), merge, 1);
		 	    					SetMergeCell(checkRow-merge, SaveNameCol("eml_snd_his_flg"), merge, 1); 
			    				}
			    				merge = 1;
			   			}else{
			   				merge++;
			   			} 					
	  					SetCellValue(checkRow, "seqNum",seqNo,0);
	 	    			//rqstSeq2=rqstSeq1;
	    			}
	    		}
 	    		if(merge > 1) {
 	    			SetMergeCell(checkRow-merge, SaveNameCol("bkg_no"), merge, 1);
 					SetMergeCell(checkRow-merge, SaveNameCol("eml_snd_his_flg"), merge, 1); 
 	    		}
	    		SetRowHidden(strHiddenRow,true);
	    		if(map1_ct == 0) {
//	    			if(sheet1RowCt != 0) {
//		    			DataInsert(-1,0);
//		    			for ( var mCol=0; mCol <= SaveNameCol("flsh_pnt_cdo_temp"); mCol++) {
//		    				if(mCol == SaveNameCol("seqNo")) {
//		    					InitCellProperty(GetSelectRow(), mCol,{ Type:"Null",Align:"Null",Format:"dfNull",PointCount:-1,EditLen:-1} );
//		    				}
//		    			}
//		    			FrozenCols=0;
//		    			MergeSheet=msAll;
////		    			GetRowMerge(SetSelectRow)(1);
//		    			GetRowMerge(SetSelectRow);
//		    			SetRowStatus(GetSelectRow(),'R');
//	    			}
	    			SetCountFormat("[0 / 0]");
	    			btnEnabled(sheetObj, false);
	    		} else {
	    			if(GetCellValue(LastRow(), 1) == "NoData") {	//@@ MessageText("NoData")
	    				RowDelete(LastRow(), false);
	    				FrozenCols=12;
	    				MergeSheet=msPrevColumnMerge + msHeaderOnly;
    				}
	    			SetCountFormat("[1 / "+map1_ct+"]");
	    			SelectCell(firstRow, "seqNum");
	    			btnEnabled(sheetObj, true);
	    		}
	    	} else {
	    		
	    		for (var checkRow=HeaderRows(); checkRow <= LastRow(); checkRow++) {
	    			strHiddenRow = strHiddenRow + checkRow + "|";
	    			//SetRowHidden(checkRow,0);
					rqstSeq1=GetCellValue(checkRow, "crr_cd")+""+
			                 GetCellValue(checkRow, "bkg_no")+""+
			                 GetCellValue(checkRow, "vsl_cd")+""+
			                 GetCellValue(checkRow, "skd_voy_no")+""+
			                 GetCellValue(checkRow, "skd_dir_cd")+""+
			                 GetCellValue(checkRow, "pol_cd")+""+
			                 GetCellValue(checkRow, "pod_cd")+""+
			                 GetCellValue(checkRow, "cgo_opr_cd")

	    			if(rqstSeq1 != rqstSeq2){
	    				seqNo++;
	    				rqstSeq2=rqstSeq1;
 	    				if(merge > 1) {
 	    					SetMergeCell(checkRow-merge, SaveNameCol("bkg_no"), merge, 1);
 	    					SetMergeCell(checkRow-merge, SaveNameCol("eml_snd_his_flg"), merge, 1); 
 	    				}
 	    				merge = 1;
	    			}else{
	    				merge++;
	    			}
  					SetCellValue(checkRow, "seqNum",seqNo,0);
 	    			//rqstSeq2=rqstSeq1;
	    		}
   		
 	    		if(merge > 1) {
 	    			SetMergeCell(checkRow-merge, SaveNameCol("bkg_no"), merge, 1);
 					SetMergeCell(checkRow-merge, SaveNameCol("eml_snd_his_flg"), merge, 1); 
 	    		}
 	    		
	    		SetRowHidden(strHiddenRow, 0);
	    		//alert(SearchRows() +"=="+ RowCount())
	    		if(RowCount()== 0) {
	    		//if(SearchRows()== 0) {
	    			SetCountFormat("[0 / 0]");
	    			btnEnabled(sheetObj, false);
	    		} else {
	    			if(map1_ct == 0) {
	    				if(GetCellValue(LastRow(), 1) == "NoData") {	////@@ MessageText("NoData")
		    				RowDelete(LastRow(), false);
		    				FrozenCols=12;
		    				MergeSheet=msPrevColumnMerge + msHeaderOnly;
	    				}
	    			}
	    			SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
	    			btnEnabled(sheetObj, true);
	    		}
	    	}
	    	//if(source == 'click') 
    	}
    }
    var arrRjctCdDG="";
    var arrRjctCdAK="";
    var arrRjctCdBB="";
    var arrRjctCdRF="";
    var arrRjctCdSS="";
    var arrRjctNmDG="";
    var arrRjctNmAK="";
    var arrRjctNmBB="";
    var arrRjctNmRF="";
    var arrRjctNmSS="";    
    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction,source) {
        sheetObj.ShowDebugMsg(false);
        var tabStr="";
   		if(getIdx() == 0) {
   			tabStr="DG";   			
   		} else if(getIdx() == 1) {
   			tabStr="AWK";
   		} else if(getIdx() == 2) {
   			tabStr="BB";
   		} else if(getIdx() == 3) {
   			tabStr="45";
   		} else if(getIdx() == 4) {
   			tabStr="RF";
   		} else if(getIdx() == 5) {
   			tabStr="SS";
   		}
//   		ComSetObjValue(formObj.scg_flg, (ComGetObjValue(formObj.auth_flg) == "U") ? "DGALL" : "SCG_"+tabStr);
   		ComSetObjValue(formObj.scg_flg,  "SCG_"+tabStr);
   		
        switch(sAction) {
	     	case IBSEARCH_ASYNC01: //RSO retrieve
	     		sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
				break;        
         	case IBSEARCH_ASYNC03: //RJT CD retrieve
         		sheetObj.SetWaitImageVisible(0);
         		formObj.f_cmd.value=SEARCH;
	 			var formParams="";
	     		formParams += "f_cmd="+ComGetObjValue(formObj.f_cmd);
          		var sXml=sheetObj.GetSearchData("VOP_SCG_0031GS.do", formParams);
         		var arrData=ComScgXml2Array(sXml, "spcl_cgo_cate_cd|spcl_cgo_lod_rjct_rsn_cd|rjct_rsn_cd_desc");

         		for (var i=0; i < arrData.length; i++) {

         			try{
	         			if (arrData[i][0] == "DG") {
	         				arrRjctCdDG += "|"+arrData[i][1];
	         				arrRjctNmDG += "|"+arrData[i][1]+"\t"+arrData[i][2];
	         			}else if (arrData[i][0] == "AK"){
	         				arrRjctCdAK += "|"+arrData[i][1];
	         				arrRjctNmAK += "|"+arrData[i][1]+"\t"+arrData[i][2];
	         			}else if (arrData[i][0] == "BB"){
	         				arrRjctCdBB += "|"+arrData[i][1];
	         				arrRjctNmBB += "|"+arrData[i][1]+"\t"+arrData[i][2];
	         			}else if (arrData[i][0] == "RF"){
	         				arrRjctCdRF += "|"+arrData[i][1];
	         				arrRjctNmRF += "|"+arrData[i][1]+"\t"+arrData[i][2];
	         			}else if (arrData[i][0] == "SS"){
	         				arrRjctCdSS += "|"+arrData[i][1];
	         				arrRjctNmSS += "|"+arrData[i][1]+"\t"+arrData[i][2];
	         			}
         			}catch (exception) {
         				//
         			}finally{
         				//
         			}
         		}
         		//sheetObjects[0].SetColProperty("sheet1_imdg_crr_rstr_expt_cd", {ComboText:aEtcData[1], ComboCode:aEtcData[0]} );
         		sheetObjects[0].SetColProperty("spcl_cgo_auth_rjct_cd", {ComboText:""+arrRjctNmDG, ComboCode:""+arrRjctCdDG} );
         		sheetObjects[1].SetColProperty("spcl_cgo_auth_rjct_cd", {ComboText:""+arrRjctNmAK, ComboCode:""+arrRjctCdAK} );
         		sheetObjects[2].SetColProperty("spcl_cgo_auth_rjct_cd", {ComboText:""+arrRjctNmBB, ComboCode:""+arrRjctCdBB} );
         		sheetObjects[3].SetColProperty("spcl_cgo_auth_rjct_cd", {ComboText:""+arrRjctNmAK, ComboCode:""+arrRjctCdAK} );
         		sheetObjects[4].SetColProperty("spcl_cgo_auth_rjct_cd", {ComboText:""+arrRjctNmRF, ComboCode:""+arrRjctCdRF} );
         		sheetObjects[5].SetColProperty("spcl_cgo_auth_rjct_cd", {ComboText:""+arrRjctNmSS, ComboCode:""+arrRjctCdSS} );
         		break;        
           	case IBSEARCH:      //retrieve

           		if(!validateForm(sheetObj,formObj,sAction,source)) return;
           		sheetObj.RemoveAll();
           		ComClearSeparator(formObj.from_eta_dt);
           		ComClearSeparator(formObj.to_eta_dt);
				formObj.f_cmd.value=SEARCH;
				//sheetObj.SetWaitImageVisible(1);

				ComOpenWait(true);
				
                setTimeout( function () {
                	var sXml=sheetObj.GetSearchData("VOP_SCG_0023GS.do", FormQueryString(formObj));
    				ComAddSeparator(formObj.from_eta_dt);
    				ComAddSeparator(formObj.to_eta_dt);
//    				var arrXml=sXml.split("|$$|");
//    				var xmlStr="";
    				sheetObj.SetColProperty("spcl_cgo_auth_cd", {ComboText:"R|Y|N", ComboCode:"R|Y|N"} );
//    				if(arrXml.length > 0){					
//    					for(var i=0; i<arrXml.length; i++) {
//    						xmlStr=arrXml[i];
//    						 
//    						var sTotal = ComScgGetTotalValue(arrXml[i]);
//    						
//    						if(sTotal > 0){
//    							if(tabStr != "SS"){
//    								//xmlStr=ComReplaceStr(xmlStr, "booking_no"      , "bkg_no");
////    								xmlStr=ComReplaceStr(xmlStr, "dg_cntr_seq"     , "spcl_cntr_seq");
////   								xmlStr=ComReplaceStr(xmlStr, "cntr_cgo_seq"    , "spcl_cgo_seq");
//    								
////    								xmlStr=ComReplaceStr(xmlStr, "ovr_fwrd_len"    , "fwrd_ovr_dim_len");  //awk own, partner
////    								xmlStr=ComReplaceStr(xmlStr, "ovr_bkwd_len"    , "bkwd_ovr_dim_len");  //awk own, partner
////    								xmlStr=ComReplaceStr(xmlStr, "ovr_lf_len"      , "lf_sd_ovr_dim_len"); //awk own, partner
////    								xmlStr=ComReplaceStr(xmlStr, "ovr_rt_len"      , "rt_sd_ovr_dim_len"); //awk own, partner
////    								xmlStr=ComReplaceStr(xmlStr, "ovr_hgt"         , "hgt_ovr_dim_len");   //awk own, partner
////    								xmlStr=ComReplaceStr(xmlStr, "ovr_void_slt_qty", "void_slt_qty");      //awk,bb
////    								xmlStr=ComReplaceStr(xmlStr, "cmdt_nm",          "cmdt_desc"); //awwk, bb, rf, ss
//    								//other --> own
//    								//xmlStr=ComReplaceStr(xmlStr, "bkg_ref_no",  "bkg_no");
////    								xmlStr=ComReplaceStr(xmlStr, "cgo_rqst_dt", "rqst_dt");
////    								xmlStr=ComReplaceStr(xmlStr, "auth_sts_cd", "spcl_cgo_auth_cd");
//    							}
//    							sheetObj.LoadSearchData(xmlStr,{Append:1 , Sync:1} );
//    						}
//    					}
//    					sheetObj.RenderSheet(1);
//    				}
//
//    				if(sheetObj.RowCount()== 0) {
//    					var emptyXml="<SHEET>	<DATA  TOTAL='0'> </DATA> </SHEET>";
//    					sheetObj.LoadSearchData(emptyXml);
//    				}
    				sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
    				
    				if(source == 'BTN') searchTab=getIdx();
    				else if(source == 'SAVTAB') tabObjects[0].SetSelectedIndex(nexttab);                
				} , 100);
	               
	               

 				
				break;
				
           	case COMMAND01:      //click 'STOWAGE INSTRUCTION'
           		//alert(!validateForm(sheetObj,formObj,sAction,source));
           		if(!validateForm(sheetObj,formObj,sAction,source)) return;
           		
           		ComClearSeparator	(formObj.from_eta_dt	);
           		ComClearSeparator	(formObj.to_eta_dt		);
				ComAddSeparator		(formObj.from_eta_dt	);
				ComAddSeparator		(formObj.to_eta_dt		);
				
				//////////////////////////////////////////////////////////////////////
                
            	var rdParam								= setQueryStr(formObj);
				formObj.com_mrdPath.value				= "apps/opus/vop/scg/cargoloadingapproval/owndangerouscargoapproval/report/VOP_SCG_5923_1.mrd";
			    formObj.com_mrdArguments.value			= rdParam;
			    formObj.com_mrdBodyTitle.value			= "Stowage Instruction Report";
				formObj.com_mrdSaveDialogFileName.value	= "Stowage Instruction Report";
				ComOpenRDPopupModal();
				
				//////////////////////////////////////////////////////////////////////
				
				break;				
				
           case IBSAVE:        //save
           		var sParam=ComGetSaveString(sheetObj);
				if (sParam == "") return;
	            if(validateForm(sheetObj,formObj,sAction,source)) {
	    			formObj.f_cmd.value=MULTI;
	    			sParam="";
	    			sParam += ComSetPrifix(sheetObj.GetSaveString(), "sheet_");
	    			sParam += "&" + FormQueryString(formObj);
	    			var sXml=sheetObj.GetSaveData("VOP_SCG_0023GS.do", sParam);
	    			sheetObj.LoadSaveData(sXml);
	    			doActionIBSheet(sheetObj,formObj,IBSEARCH,'SAV'+source);
	    		}
               	break;
        }
    }
    // Combo related process handling
    function doActionIBCombo(comboObj, comboNo) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
        sheetObj.ShowDebugMsg(false);
        switch(comboNo) {
	  		case 1:    
	  			formObj.f_cmd.value=SEARCH01;
	  			sheetObj.SetWaitImageVisible(0);
         		var sXml=sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
        		sheetObj.SetWaitImageVisible(1);
        		ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
        		//var initSelTxt = comboObj.FindIndex("ASR", 0);
        		//comboObj.Text = initSelTxt;
        		ComSetFocus(rgn_shp_opr_cd);
	  			break;  
	  		case 2:    
	  			formObj.f_cmd.value=SEARCH02;
	  			sheetObj.SetWaitImageVisible(0);
         		var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
        		sheetObj.SetWaitImageVisible(1);
        		ComXml2ComboItem(sXml, imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
        		var count=imdg_clss_cd.GetItemCount();
        		if(count <= 10) {
            		imdg_clss_cd.SetDropHeight(19*count);
            		imdg_clss_cd.SetColWidth(0, "52");
           		} else {
           			imdg_clss_cd.SetDropHeight(19*10);
           		}
        		ComSetFocus(imdg_clss_cd);
	  			break;  
        }
    }
    /**
     * Check Sheet
     */
    function getIdx() {
    	return tabObjects[0].GetSelectedIndex();
    }
    /**
     * Lane Check
     */
    function searchLaneCheck() {
     	var formObj=document.form;
     	var sheetObj=sheetObjects[getIdx()];
     	var slan_cd1=ComGetObjValue(formObj.slan_cd1);
     	if(slan_cd1 != '') {
	     	var sParam=Array();
	 	  	sParam[0]="vsl_slan_cd="+slan_cd1;
	 	  	sParam[3]="f_cmd="+SEARCH02;
	 	  	sheetObj.SetWaitImageVisible(0);
 	     	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	     	sheetObj.SetWaitImageVisible(1);
	     	var vsl_slan_cd=ComScgXml2Array(sXml, "vsl_slan_cd");
	  	   	if(vsl_slan_cd == null) {
	  	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	  		    ComSetFocus(formObj.slan_cd1);
	  		    formObj.slan_cd1.select();
	  	   	}
     	}
    }
    /**
     * Vessel Name retrieve
     */
    function searchVVDCheck() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[getIdx()];
    	var sParam=Array();
	  	sParam[0]="vsl_cd="+ComGetObjValue(formObj.vsl_cd);
	  	sParam[1]="skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
	  	sParam[2]="skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
	  	sParam[3]="f_cmd="+SEARCH05;
	  	if(sParam.join("").length > 38) {
	  		sheetObj.SetWaitImageVisible(0);
 	    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	    	sheetObj.SetWaitImageVisible(1);
	    	var vsl_eng_nm=ComScgXml2Array(sXml, "vsl_eng_nm");
	 	   	if(vsl_eng_nm == null) {
	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	 		    ComSetObjValue(formObj.vsl_eng_nm, "");
	 		    ComSetObjValue(formObj.skd_dir_cd, "");
	 		    ComSetObjValue(formObj.skd_voy_no, "");
	 		    ComSetObjValue(formObj.vsl_cd, "");
	 		    ComSetFocus(formObj.vsl_cd);
	 	   	} else {
		    	formObj.vsl_cd.className="input1";
		    	formObj.skd_voy_no.className="input1";
		    	formObj.skd_dir_cd.className="input1";
		    	formObj.from_eta_dt.className="input";
		    	formObj.to_eta_dt.className="input";
	 	   		ComSetObjValue(formObj.vsl_eng_nm, vsl_eng_nm);
	 	   		ComSetFocus(formObj.btn_retrive);
	 	   	}
	 	    vvdRequChk = true;
	  	}else{
	  		vvdRequChk = false;
	  	}
	  	searchPolObjCtl();
    }
    
    function searchPolObjCtl() {
    	if(vvdRequChk || bkgRequChk){
    	    $("#from_eta_dt").attr("value", "");
    	    $("#to_eta_dt").attr("value"  , "");
      		document.querySelector("#from_eta_dt").setAttribute('class', 'input');
      		document.querySelector("#to_eta_dt").setAttribute('class', 'input');
//      		document.querySelector("#from_eta_dt").removeAttribute('required');
//    		document.querySelector("#to_eta_dt").removeAttribute('required');
    	}else{
    	    $("#from_eta_dt").attr("value", ComGetDateAdd(null, "d", 0));
    	    $("#to_eta_dt").attr("value", ComGetDateAdd(null, "d", 15));
    	    document.querySelector("#from_eta_dt").setAttribute('class', 'input1');
      		document.querySelector("#to_eta_dt").setAttribute('class', 'input1');
//    		document.querySelector("#from_eta_dt").setAttribute('required', 'true');
//    		document.querySelector("#to_eta_dt").setAttribute('required', 'true');
    	}
    }
    
    /**
     * Port Validation
     */
    function searchPortCheck(obj) {
     	var formObj=document.form;
     	var sheetObj=sheetObjects[getIdx()];
     	var sParam=Array();
 	  	sParam[0]="port_cd="+obj.value;
 	  	sParam[3]="f_cmd="+SEARCH09;
 	  	if(sParam.join("").length > 17) {
 	  		sheetObj.SetWaitImageVisible(0);
  	    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
 	    	sheetObj.SetWaitImageVisible(1);
 	    	var port_cd_nm=ComGetEtcData(sXml,"port_cd_nm");   //port_cd_nm  
 	 	   	if(port_cd_nm == '') {
 	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	 		    ComSetObjValue(obj, ""); 	 		    
 	 		    ComSetFocus(obj);
 	 	   	} else {
 	 	   		ComSetNextFocus(obj);
 	 	   	}
 	  	}
    }
    /**
     * Carrier Validation
     */
    function searchCarrierCheck(obj) {
     	var formObj=document.form;
     	var sheetObj=sheetObjects[getIdx()];
     	var sParam=Array();
 	  	sParam[0]="crr_cd="+obj.value;
 	  	sParam[3]="f_cmd="+SEARCH01;
 	  	if(sParam.join("").length > 17) {
 	  		sheetObj.SetWaitImageVisible(0);
  	    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
 	    	sheetObj.SetWaitImageVisible(1);
 	    	var crrData=ComScgXml2Array(sXml, "crr_cd");
 		   	if(crrData == null) {
 			    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 			    ComSetObjValue(obj, ""); 	 		    
	 		    ComSetFocus(obj);
 		   	} else {
 	 	   		ComSetNextFocus(obj);
 	 	   	}
 	  	}
    }
    /**
     * UN No. Validation
     */
    function searchUNNoCheck(obj) {
    	if(obj.value == '') return;
     	var formObj=document.form;
     	var sheetObj=sheetObjects[getIdx()];
     	switch(ComGetEvent("name")) {
     		case "imdg_un_no":
     			formObj.f_cmd.value=SEARCH01;
     			break;
     		case "imdg_un_no_seq":
     			formObj.f_cmd.value=SEARCH05; 	
     			break;
     	}
     	var imdgUnNo=formObj.imdg_un_no.value;
     	if(imdgUnNo != '') {
	     	var param=FormQueryString(formObj) ;
	     	sheetObj.SetWaitImageVisible(0);
 	        var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
	        sheetObj.SetWaitImageVisible(1);
	     	var sTotal=ComScgGetTotalValue(sXml);
	     	if( sTotal == "0"){
	     		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	     		ComSetObjValue(obj, ""); 	 		    
	 		    ComSetFocus(obj);
	        } else {
	        	if(obj.name == 'imdg_un_no_seq') {
	        		var imdg_clss_cd=ComScgXml2Array(sXml, "imdg_clss_cd");
	        		imdg_clss_cd.SetSelectText(imdg_clss_cd,false);
	        	}
	 	   		ComSetNextFocus(obj);
	 	   	}
     	} else {
			ComShowCodeMessage("SCG50007", "UN No.");	//'Please input {?msg1}.'
			obj.value="";
			ComSetFocus(formObj.imdg_un_no);
		}
    }
    /**
     * UN No. Pop Call Back
     */
    function callBackUNNo(aryPopupData) {
    	var formObj=document.form;
    	ComSetObjValue(formObj.imdg_un_no,     aryPopupData[0][2]); 
    	ComSetObjValue(formObj.imdg_un_no_seq, aryPopupData[0][3]);
    	imdg_clss_cd.SetSelectText(aryPopupData[0][4],false);
    }
    /**
      * registering IBTab Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
     */
    function setTabObject(tab_obj) {
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * register IBCombo Object created in page as comboObjects list
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "DG" , "");
					InsertItem( "Awkward" , "");
					InsertItem( "Break-Bulk" , "");
					InsertItem( "45'" , "");
					InsertItem( "Reefer" , "");
					InsertItem( "Special Stow" , "");
                }
             break;
         }
         tabObj.SetSelectedIndex(0);
    }
    /**
    * setting combo initial values and header
    * param : comboObj, comboNo
    * adding case as numbers of counting comboes
     */ 
    function initCombo(comboObj, comboNo) {
    	switch(comboObj.options.id) {
	  		case "rgn_shp_opr_cd":  
	  			with(comboObj) {
					SetColAlign(0, "center");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "150");
	  				SetTitle("Code|Description");
	  				SetDropHeight(200);
	  			}
	  			break;  
	  		case "imdg_clss_cd":  
	  			with(comboObj) {	
	  				SetEnable(1);
	  			}
	  			break;  
	  	}
    }
    /**
     * Related event when clicking Tab
     * selected tab element activates.
     */
    function tab1_OnChange(tabObj , nItem) {
    	
    	//NYK:BY TOP:2014-11-24:START//
    	if(nItem == 0){
    		ComBtnEnable	("btn_stowage_instruction");
    	}else{
    		ComBtnDisable	("btn_stowage_instruction");
    	}
    	//NYK:BY TOP:2014-11-24:FINISH//
    	
    	//::2015-06-25:://if(sheetObjects[beforetab].IsDataModified()) {
    		//::2015-06-25:://if (ComShowCodeConfirm("SCG50003")) {	//'Data was changed. Do you want to save it?'	
    		//::2015-06-25:://	nexttab=nItem;
    		//::2015-06-25:://	tabObj.SetSelectedIndex(beforetab);
    		//::2015-06-25:://	doActionIBSheet(sheetObjects[beforetab],document.form,IBSAVE,'TAB');
    		//::2015-06-25:://	return;
    		//::2015-06-25:://}
    	//::2015-06-25:://}
    	
    	var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	for(var i=0; i<objs.length; i++) {
    		if(i != nItem){
    			objs[i].style.display="none";
    			objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    		}
    	}
    	beforetab=nItem;
    	var searchFlg=false;
    	for(var i=0; i<sheetCnt; i++) {
    		if (searchTab != -1 && searchTab != i && beforetab == i) searchFlg=true;
    	}
	   	if(searchFlg) {
	   		doActionIBSheet(sheetObjects[beforetab],document.form,IBSEARCH,'TAB');
    	}
	   	else {
	   		if(sheetObjects[nItem].RowCount()==0)
	   			btnEnabled(sheetObjects[nItem], false);
	   	}
	   	//resizeSheet();
	   	ComResizeSheet(sheetObjects[beforetab]);
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction,source) {
    	 switch(sAction) {
	    	case IBSEARCH:
	    		//Check requirement of Irregulars Type
	    		 if (comboObjects[0].GetSelectCode()== "") {
					 ComShowCodeMessage('SCG50011','RSO');
	    			 //formObj.rgn_shp_opr_cd.focus();
	    			 return;
	    		 }
//		    	if(ComGetObjValue(document.all.rgn_shp_opr_cd) == '') {
//		    		ComAlertFocus(document.all.rgn_shp_opr_cd, "'RSO' " +Msg_Required);
//		    		
//		    		return;
//		    	}
			  	var strVvdCd = ComGetObjValue(formObj.vsl_cd)+ComGetObjValue(formObj.skd_voy_no)+ComGetObjValue(formObj.skd_dir_cd);
			  	var bkgRefNo = ComGetObjValue(formObj.booking_no);
			  	var laneCd   = ComGetObjValue(formObj.slan_cd1);
		    	if( strVvdCd == "" 
		    		&& ComGetObjValue(formObj.from_eta_dt) == "" 
		    		&& ComGetObjValue(formObj.to_eta_dt) == ""
		    		&& bkgRefNo == ""
		    		&& laneCd == "") {
					 ComShowCodeMessage('SCG50007','VVD CD or Lane or BKG Ref No. or POL ETA');
	    			 formObj.vsl_cd.focus();
		    		return;
		    	}
	    		//Check Validation in all control in form object
		    	if(!ComChkValid(formObj, true, false, false)) 
		    		return false;
	    		break;
	    		
	    	case COMMAND01:
	    		 if (comboObjects[0].GetSelectCode() == "") {
					 ComShowCodeMessage('SCG50011','RSO');
	    			 return false;
	    		 }

	    		 var strVvdCd = ComGetObjValue(formObj.vsl_cd)+ComGetObjValue(formObj.skd_voy_no)+ComGetObjValue(formObj.skd_dir_cd);
			  	 var bkgRefNo = ComGetObjValue(formObj.booking_no);
			  	 var laneCd   = ComGetObjValue(formObj.slan_cd1);
		    	 if( strVvdCd == "" 
		    	 	 && ComGetObjValue(formObj.from_eta_dt) == "" 
		    		 && ComGetObjValue(formObj.to_eta_dt) == ""
		    		 && bkgRefNo == ""
		    		 && laneCd == "") {
					 ComShowCodeMessage('SCG50007','VVD CD or Lane or BKG Ref No. or POL ETA');
	    			 formObj.vsl_cd.focus();
		    		 return;
		    	 }
	    		 //Check Validation in all control in form object
		    	 if(!ComChkValid(formObj, true, false, false)) 
		    		 return false;
	    		 break;	    		
	    		
	    	case IBSAVE:	
	    		//'Do you want to save?'
	    		if(source != 'TAB'){
	    			if(!ComShowCodeConfirm('SCG50001', 'data')) return false;	//'Do you want to save {?msg1}?'
	    		}
		    	break;
		    	
	    	case IBCLEAR:
	    		//::2015-06-25:://if(sheetObj.IsDataModified()) {
	    		//::2015-06-25:://	if(ComShowCodeConfirm('SCG50003')) {	//'Data was changed. Do you want to save it?'
	    		//::2015-06-25:://		doActionIBSheet(sheetObj,formObj,IBSAVE,'BTN');
	    		//::2015-06-25:://		return false;
	    		//::2015-06-25:://	}
	    		//::2015-06-25:://}
	    		break;
		}
	    return true;
    }
	/**
	 * Handling data from Port Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function returnPolHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=null;
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.pol_cd.value=rtnDatas;
				}
			}
		}
	}
	function returnPodHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=null;
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.pod_cd.value=rtnDatas;
				}
			}
		}
	}
    function returnSvcLaneCdHelp(rtnObjs){
    	var formObj=document.form;
		var sheetObj=null;
		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.slan_cd1.value=rtnDatas[1];
				}
			}
		}
    }
    /**
     * When clicking popup in retriving condition
     */
    function onPopupClick(srcName, srcType){
    	var sUrl = "";
    	var formObj = document.form;
    	
    	if (srcType == "Lane") {
    		ComOpenPopup('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=' + formObj.slan_cd1.value, 500, 470, "returnSvcLaneCdHelp", "0,0", true);
   	 	} else if (srcType == "VVD") {
   	 		//VVD select popup open	
			var vsl_cd=ComGetObjValue(formObj.vsl_cd);
        	if(vsl_cd == ""){
        		sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
        		ComOpenPopupWithTarget(sUrl, 480, 480, "vsl_cd:vsl_cd|vsl_eng_nm:vsl_eng_nm", "0,0", true);
        	}else{
        		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
        		ComOpenPopupWithTarget(sUrl, 480, 480, "skd_voy_no:skd_voy_no|skd_dir_cd:skd_dir_cd", "0,0", true);
        	}
   	 	} else if (srcType == "POL" || srcType == "POD") {
   	 		helper = "";
   	 		var pol_pod = "";
   	 		if (srcType == "POL") {
   	 			pol_pod = ComGetObjValue(formObj.pol_cd);
   	 			helper = "returnPolHelp";
   	 		}else{
   	 			pol_pod = ComGetObjValue(formObj.pod_cd);
   	 			helper = "returnPodHelp"; 			
   	 		}
			sUrl="/opuscntr/VOP_VSK_0043.do?port_cd=" + pol_pod;
    		ComOpenPopup(sUrl, 422, 530, helper, "0,0", true);   	 		
//   	 		ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 428, 520, "loc_cd:"+srcType.toLowerCase()+"_cd", "0,0,1,1", true);
   	 	} else if (srcType == "Carrier") {
	 		ComOpenPopupWithTarget('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(formObj.cgo_opr_cd), 600, 470, "crr_cd:cgo_opr_cd", "0,0,1,1,1", true);
//   	 		ComOpenPopup('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(formObj.cgo_opr_cd), 600, 400, 'getCrr_cd', "1,0,1", true);
   	 	} else if (srcType == "UNNo") {
   	 		var imdg_un_no=ComGetObjValue(formObj.imdg_un_no);
   	 		var imdg_un_no_seq=ComGetObjValue(formObj.imdg_un_no_seq);
   	 		ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq, 940, 440, "callBackUNNo", "0,0,1,1,1,1,1,1,1,1", true, false);
   	 	}
    }
