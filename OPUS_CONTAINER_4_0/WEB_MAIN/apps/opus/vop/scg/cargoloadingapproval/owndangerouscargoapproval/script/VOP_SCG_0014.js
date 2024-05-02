/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : VOP_SCG_0014.js
 *@FileTitle: SPCL CGO APVL for Own BKG
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/23
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
     * @class vop_scg_0014 : business script for vop_scg_0014
     */
//    function vop_scg_0014() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
    // common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
	var tabIndex=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var auth_cd=null;
    var scg_flg=null;
    var arrVal    = new Array();	//BookingUtilDBDAOBkgComboRSQL > CD02146 코드로 헤더정보가져오기
    var arrValAry = new Array();
    var mergeRowCnt0014=0;
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var shtCnt=0;
 
    	var t2sheet1=sheetObjects[0];
    	var t3sheet1=sheetObjects[1];
    	var t4sheet1=sheetObjects[2];
    	var t5sheet1=sheetObjects[3];
    	var t6sheet1=sheetObjects[4];
    	var t7sheet1=sheetObjects[5];
    	var formObject=document.form;
    	/*******************************************************/
    	try {
    		var srcName=ComGetEvent("name");
    	    if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
	 			case "btn_SlanCd1": case "btn_SlanCd2": case "btn_SlanCd3": case "btn_SlanCd4": case "btn_SlanCd5": case "btn_SlanCd6": case "btn_SlanCd7": case "btn_SlanCd8": case "btn_SlanCd9":  case "btn_SlanCd10": case "btn_SlanCd11":
	 				onPopupClick(srcName, "Lane");
	 				break;
	 			case "btn_Vessel":
	 				onPopupClick(srcName, "Vessel");
	 				break;
     			case "btn_Retrieve":
     				formObject.retrieve_flg.value="Y";
     				formObject.t1retrieve_flg.value="N";
     				formObject.t2retrieve_flg.value="N";
     				formObject.t3retrieve_flg.value="N";
     				formObject.t4retrieve_flg.value="N";
     				formObject.t5retrieve_flg.value="N";
     				formObject.t6retrieve_flg.value="N";

     				if (ComGetObjValue(formObject.dg_cancel) == "Y") {
     					doActionIBSheet(sheetObjects[tabIndex],formObject,SEARCH03);
     	    		 } else {
     	    			doActionIBSheet(sheetObjects[tabIndex],formObject,IBSEARCH);
     	    		 }

     				break;
     			case "btn_New":
     				if (!validateForm(sheetObjects[tabIndex],formObject,IBCLEAR)) return;
     				comboObjects[0].SetSelectIndex(-1);
//     				comboObjects[0].SetSelectCode("",true);
//     				comboObjects[0].RemoveAll();
//     				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
 					clearAll();
 					RequestDtDisabled('input2', true, "N");
 					initSendDgEdiButtion("N");
     				break;
     			case "btn_Save":
					doActionIBSheet(sheetObjects[tabIndex],formObject,IBSAVE);
     				break;
     			case "btn_t2ApplDetails": case "btn_t3ApplDetails": case "btn_t4ApplDetails": case "btn_t5ApplDetails": case "btn_t6ApplDetails": case "btn_t7ApplDetails":

     				var sheetNM = srcName;

     				if(sheetNM.indexOf("btn_t2")>=0){
     					sheetNM = t2sheet1;
     				}else if(sheetNM.indexOf("btn_t3")>=0){
     					sheetNM = t3sheet1;
     				}else if(sheetNM.indexOf("btn_t4")>=0){
     					sheetNM = t4sheet1;
     				}else if(sheetNM.indexOf("btn_t5")>=0){
     					sheetNM = t5sheet1;
     				}else if(sheetNM.indexOf("btn_t6")>=0){
     					sheetNM = t6sheet1;
     				}else if(sheetNM.indexOf("btn_t7")>=0){
     					sheetNM = t7sheet1;
     				}

	 				onPopupClick(sheetNM, srcName.substring(4));

     				break;
				case "from_eta_flg":
					checkPostEta();
   	                break;
				case "btn_t2SendDgEdiRequest":
					doActionIBSheet(sheetObjects[tabIndex],formObject,MULTI01);
 					break;
				case "btn_t2SendDgEmlRequest":
					doActionIBSheet(sheetObjects[tabIndex],formObject,MULTI02);
 					break;
				case "btn_t7SendDgEmlRequest":
					//doActionIBSheet(sheetObjects[tabIndex],formObject,MULTI02);
					sendReqMail(sheetObjects[tabIndex], sheetObjects[tabIndex].GetSelectRow(), formObject);
 					break; 					
				case "btn_Calendar":
                	var cal=new ComCalendarFromTo();
                	cal.select(formObject.rqst_from_dt, formObject.rqst_to_dt, 'yyyy-MM-dd');
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
     * register IBCombo Object created in page as comboObjects list
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
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

         for(i=0, k=1;i<sheetObjects.length;i++){
        	 //
             ComConfigSheet(sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             //
             ComEndConfigSheet(sheetObjects[i]);
             ComBtnDisable("btn_t"+k+"ApplDetails");
        	 k++;
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
         }
         
         tab1.SetTabHidden(3, true);

         //tab1.DeleteItem(0, "");
         for(var k=0; k < comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }

         resizeSheet();

         ComBtnDisable("btn_t2SendDgEdiRequest");
         //ComBtnDisable("btn_t2SendDgEmlRequest");
         $("#btn_t2SendDgEmlRequest").hide();
         ComBtnDisable("btn_t7SendDgEmlRequest");
         
         RequestDtDisabled('input2', true, "N");
         
         t2sheet1_OnLoadFinish(sheetObjects[0]);

     }
      function t2sheet1_OnLoadFinish(sheetObj) {
         //Initializing html control event
         initControl();
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
     }
     /**
      * initializing Combo
      * param : comboObj, comboNo
      * adding case as numbers of counting comboes
      */
      function initCombo(comboObj, comboNo) {
    	  switch(comboObj.options.id) {
    	  	case "rgn_shp_opr_cd":
    	  		var i=0;
    	  		with(comboObj) {
    	  			SetTitle("Code|Description");
					SetColAlign(0, "center");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "150");
    	  			SetDropHeight(200);
   	         	}
    	  		break;
    	  }
      }
      
      // Handling business javascript OnChange event
         function obj_change() {         	
         	with(ComGetEvent()) {
     	    	switch(name){
     		    	case "dg_cancel":
     		          if (ComGetObjValue(formObj.dg_cancel) == "Y") {
     		        	  RequestDtDisabled('input1', false, "Y");
     		        	  initSendDgEdiButtion("Y");
     		        	  sheetObjects[0].SetColHidden("email_chk_box",1);
     		        	  sheetObjects[0].SetColEditable ("spcl_cgo_auth_cd",0);
     		        	  ComBtnDisable("btn_Save");
            		  } else {
            			  RequestDtDisabled('input2', true, "N");
            			  initSendDgEdiButtion("N");
            			  sheetObjects[0].SetColHidden("email_chk_box",0);
            			  sheetObjects[0].SetColEditable ("spcl_cgo_auth_cd",1);
            			  ComBtnEnable("btn_Save");
            		  }
     		          sheetObjects[0].SetCountFormat("[0 / 0]");
     		    	  sheetObjects[0].RemoveAll();
     		         
     		          break;
     	    	}
         	}
         } 
         
         function obj_blur() {
        	 var formObj=document.form;
        	 switch(ComGetEvent("name")){
        	 	case "slan_cd1": case "slan_cd2": case "slan_cd3": case "slan_cd4": case "slan_cd5": case "slan_cd6": case "slan_cd7": case "slan_cd8": case "slan_cd9": case "slan_cd10": case "slan_cd11":
    	       		 var objName="slan_cd";
    	       		 var srcName=ComGetEvent("name");
    	    		 var sInt;
    	    		 if (srcName.indexOf(objName) > -1) {
    	    			 sInt=srcName.substring(objName.length, srcName.length);
    	    		 }else{
    	    			 sInt=srcName.substring(srcName.length-1, srcName.length);
    	    		 }
        	 		// var sInt = event.srcElement.name.substring(event.srcElement.name.length-1, event.srcElement.name.length);
        	 		var sLen=eval("formObj.slan_cd"+sInt+".value.length");
        	 		if (sLen == 3) {
        	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
        	 		}else if (sLen != 0) {
             			ComShowCodeMessage('SCG50006',"Lane Code"+sInt, "3");
             			event.srcElement.focus();
             	     	event.srcElement.select();
        	    		return false;
        	 		}
        	 		break;
        	 	case "vsl_cd":
        	 		var sLen=formObj.vsl_cd.value.length;
        	 		if (sLen == 4) {
        	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
        	 		}else if (sLen != 0) {
             			ComShowCodeMessage('SCG50006',"Vessel Code", "4");
             			event.srcElement.focus();
             			event.srcElement.select();
        	    		return false;
        	 		}
        	 		break;
        	 }
         }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
    	 var cnt=0;
         var sheetID=sheetObj.id ;
         switch(sheetID) {
         	case "t2sheet1":
         		with (sheetObj) {
	                var HeadTitle="No.||EDI|Email|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|DG Ref No|Elapsed\n(day)|EDI\nSent|Mail\nSent|EDI\nSent|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle   += "Sequence|Sequence|TPSZ|TP|UN No.\n/Seq.|UN No.\n/Seq.|Class|Sub\nrisks|MP|PG|LQ|EQ|R|FP(℃)|Weight (kg)|Weight (kg)|PSA|HCDG|UPD DT|";
	                HeadTitle   += " | | | | | | | | | | | | | | | | |";
	                var HeadTitle1="No.|| ||Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|DG Ref No|Elapsed\n(day)|EDI\nSent|Mail\nSent|EDI\nSent|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle1  += "CNTR|CGO|TPSZ|TP|UN No.\n/Seq.|UN No.\n/Seq.|Class|Sub\nrisks|MP|PG|LQ|EQ|R|FP(℃)|Gross|Net|PSA|HCDG|UPD_DT|";
	                HeadTitle1  += " | | | | | | | | | | | | | | | | |";
	                
	                var headCount=ComCountHeadTitle(HeadTitle);
	//                (headCount, 10, 0, true);

	                SetConfig( { SearchMode:2, MergeSheet:9, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	                var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"},
	                                { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);

	                var cols = [
	                           {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"num",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                           {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rank_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	                           {Type:"CheckBox",  Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"edi_chk_box"     },
	                           {Type:"CheckBox",  Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"email_chk_box"   },
	                           {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"booking_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       
		                       {Type:"Text",      Hidden:0,  Width:105,   Align:"Left",    ColMerge:0,   SaveName:"dcgo_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rqst_day",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
		                       
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"edi_snd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"eml_snd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_his_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_his_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Seq",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		                       {Type:"ComboEdit", Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:3 },
		                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:85,   Align:"Left",    ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dg_cntr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cgo_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"dg_tp",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"mrn_polut_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"imdg_expt_qty_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"rsd_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"flsh_pnt_cdo_temp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"net_wgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"psa_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       
		                       //2016-07-01
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0 },
		                       //2016-07-01
		                       
		                       {Type:"Status",    Hidden:1, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"vsl_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       //{Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"net_wgt_sum",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,    Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"crr_code",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"edi_chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"eml_chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_rqst_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"rgn_shp_opr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"mapg_trsm_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"mapg_trsm_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"mapg_trsm_spcl_cgo_cate_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"mapg_prnr_spcl_cgo_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,    Align:"Center",  ColMerge:0,   SaveName:"mapg_edi_trsm_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"imdg_segr_grp_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cfr_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"edi_status",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"flt_file_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"eml_addr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"pre_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"edi_msg_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"itm_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"edi_chk_type",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"eml_chk_type",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }
		                       ];

	                InitColumns(cols);
	                SetEditable(1);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                SetMergeCell(0, 5, 2, 3);
	                //SetMergeCell(0, 23, 2, 2);
	                //SetColHidden("seqNo",1);
                }
         		break;
         	case "t3sheet1":
         		with (sheetObj) {
	                var HeadTitle="No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle += "CNTR\nSeq.|TPSZ|Commodity|Over All (cm)|Over All (cm)|Over All (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|";
	                HeadTitle += "Over Dimension (cm)|Post\nExtd|Weight (kg)|Weight (kg)|Void\n(FEU)|UPD_DT|";
	                HeadTitle += " | | | | | | | | | | |";
	                var HeadTitle1="No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle1 += "CNTR\nSeq.|TPSZ|Commodity|L|W|H|FWD|AFT|Left|Right|Height|";
	                HeadTitle1 += "Post\nExtd|Gross|Net|Void\n(FEU)|UPD_DT|";
	                HeadTitle1 += " | | | | | | | | | | |";
	                var headCount=ComCountHeadTitle(HeadTitle);
	//                (headCount, 10, 0, true);
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"},
	                            { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);

	                var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"num",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"booking_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rqst_day",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"eml_snd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Seq",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		                       {Type:"ComboEdit", Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:3 },
		                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:85,   Align:"Left",    ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_len",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_wdt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_hgt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ovr_fwrd_len",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ovr_bkwd_len",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ovr_lf_len",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ovr_rt_len",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ovr_hgt",                 KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"xtd_ovr_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"net_wgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ovr_void_slt_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
		                       
		                       //2016-07-01
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0 },
		                       //2016-07-01
		                       
		                       {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       //{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"rsd_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];

	                InitColumns(cols);
	                SetEditable(1);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                SetMergeCell(0, 2, 2, 3);
	                SetColHidden("seqNo",1);
                }
         		break;
         	case "t4sheet1":
         		with (sheetObj) {
	                var HeadTitle="No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle += "CGO\nSeq.|Commodity|Length\n(cm)|Width\n(cm)|Height\n(cm)|Gross\nWeight (kg)|Void\n(FEU)|UPD_DT|";
	                HeadTitle += " | | | | | | | | | |";
	                var HeadTitle1="No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle1 += "CGO\nSeq.|Commodity|Length\n(cm)|Width\n(cm)|Height\n(cm)|Gross\nWeight (kg)|Void\n(FEU)|UPD_DT|";
	                HeadTitle1 += " | | | | | | | | | |";
	                var headCount=ComCountHeadTitle(HeadTitle);
	//                (headCount, 10, 0, true);

	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"},
	                            { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);

	                var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"num",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:105,   Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"booking_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rqst_day",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"eml_snd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Seq",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			                       {Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:3 },
			                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:1,  Width:85,   Align:"Left",    ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dim_len",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0 },
			                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dim_wdt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0 },
			                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dim_hgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0 },
			                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0 },
			                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ovr_void_slt_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
			                       
			                       //2016-07-01
			                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0 },
			                       //2016-07-01
			                       
			                       {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       //{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                       {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"crr_code",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];

	                InitColumns(cols);
	                SetEditable(1);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                SetMergeCell(0, 2, 2, 3);
	                SetColHidden("seqNo",1);
         		}
         		break;
         	case "t5sheet1":
         		with (sheetObj) {
	                var HeadTitle="No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle += "CNTR\nSeq.|TPSZ|Commodity|Length\n(cm)|Width\n(cm)|Height\n(cm)|Gross\nWeight(kg)|UPD_DT|";
	                HeadTitle += " | | | | | | | | | |";
	                var HeadTitle1="No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle1 += "CNTR\nSeq.|TPSZ|Commodity|Length\n(cm)|Width\n(cm)|Height\n(cm)|Gross\nWeight(kg)|UPD_DT|";
	                HeadTitle1 += " | | | | | | | | | |";
	                var headCount=ComCountHeadTitle(HeadTitle);
	//                (headCount, 10, 0, true);

	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"},
	                            { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);

	                var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"num",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:105,   Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"booking_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rqst_day",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"eml_snd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Seq",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		                       {Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:3 },
		                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:85,   Align:"Left",    ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_len",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_wdt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dim_hgt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0 },
		                       
		                       //2016-07-01
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0 },
		                       //2016-07-01
		                       
		                       {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       //{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"crr_code",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];

	                InitColumns(cols);
	                SetEditable(1);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                SetMergeCell(0, 2, 2, 3);
	                SetColHidden("seqNo",1);
                }
         		break;
         	case "t6sheet1":
         		with (sheetObj) {

	                var HeadTitle="No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle += "CNTR\nSeq.|TPSZ|Commodity|Voltage|Temperature|Temperature|Vent\n(% Open)|CMH|Gross\nWeight (kg)|UPD_DT|";
	                HeadTitle += " | | | | | | | | | | |";
	                var HeadTitle1="No.|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle1 += "CNTR\nSeq.|TPSZ|Commodity|Voltage|°C|°F|Vent\n(% Open)|CMH|Gross\nWeight (kg)|UPD_DT|";
	                HeadTitle1 += " | | | | | | | | | | |";
	                var headCount=ComCountHeadTitle(HeadTitle);
	//                (headCount, 10, 0, true);
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"},
	                            { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);

	                var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"num",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"booking_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rqst_day",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"eml_snd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Seq",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		                       {Type:"ComboEdit", Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:3 },
		                       {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:85,   Align:"Left",    ColMerge:0,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"rc_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"vltg_no",                 KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cdo_temp",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fdo_temp",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
		                       {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vent_rto",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cbm_per_hr_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0 },
		                       
		                       //2016-07-01
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0 },
		                       //2016-07-01
		                       		                       
		                       {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_rqst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       //{Type:"Text",      Hidden:1, Width:85,   Align:"Left",    ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"org_spcl_cgo_auth_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"crr_code",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];

	                InitColumns(cols);
	                SetEditable(1);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                SetMergeCell(0, 2, 2, 3);
	                //SetColHidden("seqNo",1);
                }
         		break;
         	case "t7sheet1":
         		with (sheetObj) {
	                var HeadTitle="No.||EDI|Email|Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|EDI\nSent|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle   += "CNTR|TPSZ|TPSZ|TP|QTY|UN No.\n/Seq.|UN No.\n/Seq.|Class|Commodity|Sub\nrisks|MP|PG|LQ|EQ|FP(℃)|Gross\nWeight (kg)|Weight (kg)|UPD_DT|";
	                HeadTitle   += "DG|AW|BB|RF|ibflag|stwg_cd|stwg_seq|stwg_flg|bkg_no|spcl_cgo_apro_rqst_seq|vsl_pre_pst_cd|vsl_seq|spcl_cgo_cate_cd|rgn_shp_opr_cd|dcgo_seq|awk_cgo_seq|bb_cgo_seq|rc_seq|spcl_cgo_auth_seq|";
	                HeadTitle   += arrVal[0];
//	                HeadTitle   +="AB|AF|AF|AL|BC|MU\nPG|OB\nSG|OB\nSS|OD|OD\nAS|OD\nAL|OD\nBC|OD\nFT|UD|UD\nAB|UT|UT\nAB|UW|";
	                var HeadTitle1="No.|| ||Lane|VVD CD|VVD CD|VVD CD|VSL\nOPR|POL|ETA|POD|BKG No.|Elapsed\n(day)|EDI\nSent|Mail\nSent|seq|APVL|RJT\nCD|RMK|APVL\nRef. No.|";
	                HeadTitle1  += "CNTR|TPSZ|TPSZ|TP|QTY|UN No.\n/Seq.|UN No.\n/Seq.|Class|Commodity|Sub\nrisks|MP|PG|LQ|EQ|FP(℃)|Gross\nWeight (kg)|Net|UPD_DT|";
	                HeadTitle1  += "DG|AW|BB|RF|ibflag|stwg_cd|stwg_seq|stwg_flg|bkg_no|spcl_cgo_apro_rqst_seq|vsl_pre_pst_cd|vsl_seq|spcl_cgo_cate_cd|rgn_shp_opr_cd|dcgo_seq|awk_cgo_seq|bb_cgo_seq|rc_seq|spcl_cgo_auth_seq|";
	                HeadTitle1  += arrVal[0];
//	                HeadTitle1  +="AB|AF|AF|AL|BC|MU\nPG|OB\nSG|OB\nSS|OD|OD\nAS|OD\nAL|OD\nBC|OD\nFT|UD|UD\nAB|UT|UT\nAB|UW|";
	                var headCount=ComCountHeadTitle(HeadTitle);
//	                (headCount, 10, 0, true);

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
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"booking_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rqst_day",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"edi_snd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Seq",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seqNo",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		                       {Type:"ComboEdit", Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:3 },
		                       {Type:"Text",      Hidden:0, Width:170,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:85,   Align:"Left",    ColMerge:1,   SaveName:"apro_ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
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
		                       
		                       //2016-07-01
		                       {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0 },
		                       //2016-07-01
		                       
		                       //2016-03-14
		                       {Type:"CheckBox",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"  },
		                       {Type:"CheckBox",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"  },
		                       {Type:"CheckBox",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,TrueValue:"Y", FalseValue:"N"  },
		                       {Type:"CheckBox",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"  },
		                       
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
		                    	   //2016-03-14
		                    	   cols.push({Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0, SaveName:""+arrValAry[n], KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:13, ImgHeight:13, TrueValue:"Y", FalseValue:"N" });                         
		                       }

	                InitColumns(cols);
	                SetEditable(1);
	                SetRowHeight(20);
	                SetWaitTimeOut(300);
	                SetMergeCell(0, 5, 2, 3);
	                SetMergeCell(0, 22, 2, 2);
	                SetImageList(0, "js/ibsheet/Main/chk0R.gif");
	                SetImageList(1, "js/ibsheet/Main/chk1.gif");
	    			SetShowButtonImage(1);
	                //SetColHidden("seqNo",1);
                }
         		break;
         }
     }
     
     //business javascript OnKeyPress event Catch
     function initControl() {
//    	 axon_event.addListener ('keydown', 	'ComKeyEnter', 	'form');
    	 axon_event.addListenerForm('click', 	'obj_click', 	document.form);
//    	 axon_event.addListenerForm('keypress', 'obj_keypress',	document.form);
//    	 axon_event.addListenerForm('keyup',	'obj_keyup', 	document.form);
    	 axon_event.addListenerForm('blur', 	'obj_blur', 	document.form);
    	 axon_event.addListenerForm('change',   'obj_change', 	document.form);
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
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg(false);
         //no support[check again]CLT sheetObj.IsBufferedScroll=true;
         switch(sAction) {
         	case IBSEARCH_ASYNC01: //RSO retrieve
         		sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
				break;
         	case IBSEARCH_ASYNC02: //checkLane retrieve
         		sheetObj.SetWaitImageVisible(0);
         		formObj.f_cmd.value=SEARCH02;
         		var sName=ComGetEvent("name");
          		var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do" , FormQueryString(formObj)+"&vsl_slan_cd="+event.srcElement.value);
         		var arrData=ComScgXml2Array(sXml, "vsl_slan_cd");
         		if (arrData != null && arrData.length > 0) {
         			ComSetNextFocus(event.srcElement);
         		}else{
         			ComShowCodeMessage('SCG50010',"Data" );
         			event.srcElement.value="";
         			event.srcElement.focus();
					return false;
         		}
         		break;
         		
         	case IBSEARCH_ASYNC03: //RJT CD retrieve
         		
         		sheetObj.SetWaitImageVisible(0);
         		formObj.f_cmd.value		= SEARCH;
	 			var formParams			= "";
	     		formParams 				+= "f_cmd="+ComGetObjValue(formObj.f_cmd);
          		var sXml				= sheetObj.GetSearchData("VOP_SCG_0031GS.do", formParams);
         		var arrData				= ComScgXml2Array(sXml, "spcl_cgo_cate_cd|spcl_cgo_lod_rjct_rsn_cd|rjct_rsn_cd_desc");
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
	         			}else{
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
         		
         	case IBSEARCH_ASYNC04: // Vessel retrieve
         		sheetObj.SetWaitImageVisible(0);
         		formObj.f_cmd.value=COMMAND16;
          		var sXml=sheetObj.GetSearchData("VOP_VSK_0219GS.do" , FormQueryString(formObj)+"&vsl_cd="+event.srcElement.value+"&op=0219");
         		var arrData=ComScgXml2Array(sXml, "vsl_cd");
         		if (arrData != null && arrData.length > 0) {
         		}else{
         			ComShowCodeMessage('SCG50010',"Data" );
         			event.srcElement.value="";
         			event.srcElement.focus();
					return false;
         		}
         		break;
         		
         	case IBSEARCH:      //retrieve
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			mergeRowCnt0014 = 0;
         		formObj.f_cmd.value=SEARCH;
         		sheetObj.RemoveAll();
         		if (tabIndex == 0) {
         			scg_flg="DG2";
             		formObj.t1retrieve_flg.value="Y";
         		}else if (tabIndex == 1) {
         			scg_flg="AWK";
             		formObj.t2retrieve_flg.value="Y";
         		}else if (tabIndex == 2) {
         			scg_flg="BB";
             		formObj.t3retrieve_flg.value="Y";
         		}else if (tabIndex == 3) {
         			scg_flg="45";
             		formObj.t4retrieve_flg.value="Y";
         		}else if (tabIndex == 4) {
         			scg_flg="RF";
             		formObj.t5retrieve_flg.value="Y";
         		}else if (tabIndex == 5) {
         			scg_flg="SS";
             		formObj.t6retrieve_flg.value="Y";
         		}
         		var formParams="";
         		formParams += "auth_flg="        +ComGetObjValue(formObj.auth_flg);
         		formParams += "&f_cmd="          +ComGetObjValue(formObj.f_cmd);
         		formParams += "&pagerows="       +ComGetObjValue(formObj.pagerows);
         		//2016-06-23 BKG NO, DG REF NO 추가 
         		formParams +="&booking_no="  +ComGetObjValue(formObj.booking_no);
         	    formParams +="&dcgo_ref_no="  +ComGetObjValue(formObj.dcgo_ref_no);
         		//2016-06-23 BKG NO, DG REF NO 추가
         		formParams += "&rgn_shp_opr_cd=" +comboObjects[0].GetSelectCode();
         		formParams += "&slan_cd1="       +ComGetObjValue(formObj.slan_cd1);
         		formParams += "&slan_cd2="       +ComGetObjValue(formObj.slan_cd2);
         		formParams += "&slan_cd3="       +ComGetObjValue(formObj.slan_cd3);
         		formParams += "&slan_cd4="       +ComGetObjValue(formObj.slan_cd4);
         		formParams += "&slan_cd5="       +ComGetObjValue(formObj.slan_cd5);
         		formParams += "&slan_cd6="       +ComGetObjValue(formObj.slan_cd6);
         		formParams += "&slan_cd7="       +ComGetObjValue(formObj.slan_cd7);
         		formParams += "&slan_cd8="       +ComGetObjValue(formObj.slan_cd8);
         		formParams += "&slan_cd9="       +ComGetObjValue(formObj.slan_cd9);
         		formParams += "&slan_cd10="      +ComGetObjValue(formObj.slan_cd10);
         		formParams += "&slan_cd11="      +ComGetObjValue(formObj.slan_cd11);
         		formParams += "&val_opr_tp_cd="  +ComGetObjValue(formObj.val_opr_tp_cd);
         		formParams += "&vsl_cd="         +ComGetObjValue(formObj.vsl_cd);
         		formParams += "&dg_cancel="      +ComGetObjValue(formObj.dg_cancel);
         		formParams += "&rqst_from_dt="   +ComGetObjValue(formObj.rqst_from_dt);
         		formParams += "&rqst_to_dt="     +ComGetObjValue(formObj.rqst_to_dt);

         		if (formObj.from_eta_flg.checked == true && ComGetObjValue(formObj.from_eta_dt) != "") {
         			formParams += "&from_eta_dt=" +ComGetObjValue(formObj.from_eta_dt);
         		}
         		sheetObj.SetWaitImageVisible(0);
         		ComOpenWait(true);
         		//var sXml=sheetObj.GetSearchData("VOP_SCG_0014GS.do", formParams+"&scg_flg="+scg_flg);
         		//sheetObj.LoadSearchData(sXml,{Sync:1} );
    			
         		sheetObj.DoSearch("VOP_SCG_0014GS.do", formParams+"&scg_flg="+scg_flg);
         		
//    			sheetObj.HideFilterRow();
                break;
                
         	case SEARCH03:      //dg cancel
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			mergeRowCnt0014 = 0;
         		formObj.f_cmd.value=SEARCH03;
         		sheetObj.RemoveAll();
         		if (tabIndex == 0) {
         			scg_flg="DG2";
             		formObj.t1retrieve_flg.value="Y";
         		}
         		var formParams="";
         		formParams += "auth_flg="        +ComGetObjValue(formObj.auth_flg);
         		formParams += "&f_cmd="          +ComGetObjValue(formObj.f_cmd);
         		formParams += "&pagerows="       +ComGetObjValue(formObj.pagerows);
         		formParams += "&rgn_shp_opr_cd=" +comboObjects[0].GetSelectCode();
         		formParams += "&slan_cd1="       +ComGetObjValue(formObj.slan_cd1);
         		formParams += "&slan_cd2="       +ComGetObjValue(formObj.slan_cd2);
         		formParams += "&slan_cd3="       +ComGetObjValue(formObj.slan_cd3);
         		formParams += "&slan_cd4="       +ComGetObjValue(formObj.slan_cd4);
         		formParams += "&slan_cd5="       +ComGetObjValue(formObj.slan_cd5);
         		formParams += "&slan_cd6="       +ComGetObjValue(formObj.slan_cd6);
         		formParams += "&slan_cd7="       +ComGetObjValue(formObj.slan_cd7);
         		formParams += "&slan_cd8="       +ComGetObjValue(formObj.slan_cd8);
         		formParams += "&slan_cd9="       +ComGetObjValue(formObj.slan_cd9);
         		formParams += "&slan_cd10="      +ComGetObjValue(formObj.slan_cd10);
         		formParams += "&slan_cd11="      +ComGetObjValue(formObj.slan_cd11);
         		formParams += "&val_opr_tp_cd="  +ComGetObjValue(formObj.val_opr_tp_cd);
         		formParams += "&vsl_cd="         +ComGetObjValue(formObj.vsl_cd);
         		formParams += "&dg_cancel="      +ComGetObjValue(formObj.dg_cancel);
         		formParams += "&rqst_from_dt="   +ComGetObjValue(formObj.rqst_from_dt);
         		formParams += "&rqst_to_dt="     +ComGetObjValue(formObj.rqst_to_dt);

         		if (formObj.from_eta_flg.checked == true && ComGetObjValue(formObj.from_eta_dt) != "") {
         			formParams += "&from_eta_dt=" +ComGetObjValue(formObj.from_eta_dt);
         		}

          		var sXml=sheetObj.GetSearchData("VOP_SCG_0014GS.do", formParams+"&scg_flg="+scg_flg);
    			sheetObj.LoadSearchData(sXml,{Sync:1} );
    			
//    			sheetObj.HideFilterRow();
                break;
                
         	case IBSAVE:        //save
         		if(validateForm(sheetObj,formObj,sAction)) {
         			formObj.f_cmd.value=MULTI;
             		if (tabIndex == 0) {
             			scg_flg="DG2";
             		}else if (tabIndex == 1) {
             			scg_flg="AWK";
             		}else if (tabIndex == 2) {
             			scg_flg="BB";
             		}else if (tabIndex == 3) {
             			scg_flg="45";
             		}else if (tabIndex == 4) {
             			scg_flg="RF";
             		}else if (tabIndex == 5) {
             			scg_flg="SS";
             		}
         			var sParam=ComGetSaveString(sheetObj);
         			if (sParam == "") return;
         			var formParams="";
	         		formParams += "auth_flg="        +ComGetObjValue(formObj.auth_flg);
	         		formParams += "&f_cmd="          +ComGetObjValue(formObj.f_cmd);
	         		formParams += "&pagerows="       +ComGetObjValue(formObj.pagerows);
	         		formParams += "&rgn_shp_opr_cd=" +comboObjects[0].GetSelectCode();
	         		formParams += "&slan_cd1="       +ComGetObjValue(formObj.slan_cd1);
	         		formParams += "&slan_cd2="       +ComGetObjValue(formObj.slan_cd2);
	         		formParams += "&slan_cd3="       +ComGetObjValue(formObj.slan_cd3);
	         		formParams += "&slan_cd4="       +ComGetObjValue(formObj.slan_cd4);
	         		formParams += "&slan_cd5="       +ComGetObjValue(formObj.slan_cd5);
	         		formParams += "&slan_cd6="       +ComGetObjValue(formObj.slan_cd6);
	         		formParams += "&slan_cd7="       +ComGetObjValue(formObj.slan_cd7);
	         		formParams += "&slan_cd8="       +ComGetObjValue(formObj.slan_cd8);
	         		formParams += "&slan_cd9="       +ComGetObjValue(formObj.slan_cd9);
	         		formParams += "&slan_cd10="      +ComGetObjValue(formObj.slan_cd10);
	         		formParams += "&slan_cd11="      +ComGetObjValue(formObj.slan_cd11);
	         		formParams += "&val_opr_tp_cd="  +ComGetObjValue(formObj.val_opr_tp_cd);
	         		formParams += "&vsl_cd="         +ComGetObjValue(formObj.vsl_cd);
         			sParam += "&" + formParams;
         			
         			ComOpenWait(true);
        			
        			setTimeout( function () {
              			var sXml=sheetObj.GetSaveData("VOP_SCG_0014GS.do", sParam+"&scg_flg="+scg_flg);
              			sheetObj.LoadSaveData(sXml);
              			doActionIBSheet(sheetObj,document.form,IBSEARCH);
        			} , 300);

        			
         		}
         		break;
         		
         	case MULTI01: //send dg edi request
         		if(validateForm(sheetObj,formObj,sAction)) {
         			formObj.f_cmd.value = MULTI01;
             		if (tabIndex == 0) {
             			scg_flg="DG2";
             		}/*else if (tabIndex == 1) {
             			scg_flg="DG2";
             		}*/else if (tabIndex == 1) {
             			scg_flg="AWK";
             		}else if (tabIndex == 2) {
             			scg_flg="BB";
             		}else if (tabIndex == 3) {
             			scg_flg="45";
             		}else if (tabIndex == 4) {
             			scg_flg="RF";
             		}else if (tabIndex == 5) {
             			scg_flg="SS";
             		}
             		
         			var sParam=ComGetSaveString(sheetObj);
         			if (sParam == "") return;
         			var formParams	="";
	         		formParams 		+= "auth_flg="        +ComGetObjValue(formObj.auth_flg);
	         		formParams 		+= "&f_cmd="          +ComGetObjValue(formObj.f_cmd);
	         		formParams 		+= "&pagerows="       +ComGetObjValue(formObj.pagerows);
	         		formParams 		+= "&rgn_shp_opr_cd=" +comboObjects[0].GetSelectCode();
         			sParam 			+= "&" + formParams;
          			var sXml		= sheetObj.GetSaveData("VOP_SCG_0014GS.do", sParam+"&scg_flg="+scg_flg);

          			
          			if(ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S") {
          				ComShowCodeMessage("SCG50037", "Data");
          			}else{
          				ComShowCodeMessage("SCG50060");		//Sending DG EDI is failed.//
          			}

          			if (ComGetObjValue(formObj.dg_cancel) == "Y") {
          				doActionIBSheet(sheetObj,document.form,SEARCH03);
          			} else {
          				doActionIBSheet(sheetObj,document.form,IBSEARCH);
          			}

         		}
         		break;
         		
         	case MULTI02: //send dg email request
         		if(validateForm(sheetObj,formObj,sAction)) {
         			formObj.f_cmd.value = MULTI02;
             		if (tabIndex == 0) {
             			scg_flg="DG2";
             		}/*else if (tabIndex == 1) {
             			scg_flg="DG2";
             		}*/else if (tabIndex == 1) {
             			scg_flg="AWK";
             		}else if (tabIndex == 2) {
             			scg_flg="BB";
             		}else if (tabIndex == 3) {
             			scg_flg="45";
             		}else if (tabIndex == 4) {
             			scg_flg="RF";
             		}else if (tabIndex == 5) {
             			scg_flg="SS";
             		}
             		
             		if(sheetObj.IsDataModified()) {
             		
	         			var sParam=ComGetSaveString(sheetObj);
	         			if (sParam == "") return;
	         			var formParams="";
		         		formParams += "auth_flg="        +ComGetObjValue(formObj.auth_flg);
		         		formParams += "&f_cmd="          +ComGetObjValue(formObj.f_cmd);
		         		formParams += "&pagerows="       +ComGetObjValue(formObj.pagerows);
		         		formParams += "&rgn_shp_opr_cd=" +comboObjects[0].GetSelectCode();
	         			sParam += "&" + formParams;
	          			var sXml=sheetObj.GetSaveData("VOP_SCG_0014GS.do", sParam+"&scg_flg="+scg_flg);
	          			sheetObj.LoadSaveData(sXml);
	
	          			if(ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S") {
	          				ComShowCodeMessage("SCG50038", "Data");
	          				doActionIBSheet(sheetObj,document.form,IBSEARCH);
	          			}
	          			
             		}
         		}
         		break;
         }
         
  		sheetObj.SetWaitImageVisible(1);
     }
     /**
      * register IBTab Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
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
     }
     /**
      * Related event when clicking Tab
      * selected tab element activates.
      */
     function tab1_OnChange(tabObj , nItem){
    	 var formObj=document.form;
    	 var objs=document.all.item("tabLayer");
    	 var tabSelectedIdx=ComGetObjValue(formObj.tabSelectedIdx);
    	 objs[nItem].style.display="Inline";
    	 objs[beforetab].style.display="none";
    	 //--------------- important point --------------------------//
    	 objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	 //------------------------------------------------------//
    	 if (!validateForm(sheetObjects[tabSelectedIdx],formObj,IBCLEAR)) return;
    	 beforetab=nItem;
    	 tabIndex=nItem;
    	 if (tabIndex == 0 && document.form.retrieve_flg.value == "Y" && document.form.t1retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	 }else if (tabIndex == 1 && document.form.retrieve_flg.value == "Y" && document.form.t2retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    	 }else if (tabIndex == 2 && document.form.retrieve_flg.value == "Y" && document.form.t3retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
    	 }else if (tabIndex == 3 && document.form.retrieve_flg.value == "Y" && document.form.t4retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
    	 }else if (tabIndex == 4 && document.form.retrieve_flg.value == "Y" && document.form.t5retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);
    	 }else if (tabIndex == 5 && document.form.retrieve_flg.value == "Y" && document.form.t6retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[5],document.form,IBSEARCH);
    	 }
    	 ComSetObjValue(formObj.tabSelectedIdx, nItem);

    	 resizeSheet();

     }
     /**
      * handling process for input validation
      */
//     var t7sheet1=sheetObjects[5];
//     else if (tabIndex == 5) {
//			scg_flg="SS";
//		}
     function validateForm(sheetObj,formObj,sAction){
    	 if (sAction == IBSAVE){
    		 for (var i=1; i<=sheetObj.LastRow(); i++){
    			 if(sheetObj.GetCellValue(i,"spcl_cgo_auth_cd") == "N" && sheetObj.GetCellValue(i,"spcl_cgo_auth_rjct_cd") == "") {
    				 ComShowCodeMessage('SCG50007', 'Rejection Code');
    				 sheetObj.SelectCell(i,"spcl_cgo_auth_rjct_cd");
    				 return;
    			 }
    			 //2016-02-19 'SS' - AAA - Remark Check 불필요 
    			 if(sheetObj.GetCellValue(i,"spcl_cgo_auth_cd") == "N" && sheetObj.GetCellValue(i,"spcl_cgo_auth_rjct_cd") == "AAA"  && sheetObj.GetCellValue(i,"spcl_cgo_auth_rmk") == "") {
        			 ComShowCodeMessage('SCG50007', 'Reject Remark(s)');
    				 sheetObj.SelectCell(i,"spcl_cgo_auth_rjct_cd");
    		    	 onPopupClick(sheetObj, sheetObj.id);
    				 return;
    			 }
    			 
				if(sheetObj.GetCellValue(i,"spcl_cgo_auth_cd") == "P" && sheetObj.GetCellValue(i,"spcl_cgo_auth_rjct_cd") == "AAA"  && sheetObj.GetCellValue(i,"spcl_cgo_auth_rmk") == "") {
        			 ComShowCodeMessage('SCG50007', 'Reject Remark(s)');
    				 sheetObj.SelectCell(i,"spcl_cgo_auth_rjct_cd");
    		    	 onPopupClick(sheetObj, sheetObj.id);
    				 return;
    			 }
    		 }
    	 } else if (sAction == MULTI01) { //EDI Validation
    		     		 
    		 var ediChkBoxCnt = 0;
    		 for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
    			 if(sheetObj.GetCellValue(i,"edi_chk_box") == "1" && sheetObj.GetCellEditable(i, "edi_chk_box") && sheetObj.GetCellValue(i, "edi_snd_no") != "Y")
    				 ediChkBoxCnt++;
    		 }
    		 
    		 if(ediChkBoxCnt <= 0){
    			 ComShowCodeMessage('SCG50011', 'EDI ');//'Please select {?msg1}'
    			 return false;
    		 }
    		 
    		 /*
    		 for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
    			 if(sheetObj.GetCellValue(i,"edi_chk_box") == "1" &&
    	    			    (sheetObj.GetCellValue(i,"spcl_cgo_auth_cd") != "P"
    	    				  || sheetObj.GetCellValue(i,"mapg_edi_trsm_sts_cd") == "Y"
    	    				  || sheetObj.GetCellValue(i,"edi_chk") != "Y")) {
    	    				 ComShowCodeMessage('SCG50007', 'edi ');
    	    				 sheetObj.SelectCell(i,"edi_chk");
    	    				 return false;
    	    	 }
    		 }*/
    		 
    	 } else if (sAction == MULTI02) {//Email Validation 
    		 var emailChkBoxCnt = 0;
    		 for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
    			 if(sheetObj.GetCellValue(i,"email_chk_box") == "1" && sheetObj.GetCellEditable(i, "email_chk_box") && sheetObj.GetCellValue(i, "eml_snd_no") != "Y")
    				 emailChkBoxCnt++;
    		 }
    		 
    		 if(emailChkBoxCnt <= 0){
    			 ComShowCodeMessage('SCG50011', 'Email ');//'Please select {?msg1}'
    			 return false;
    		 }
    	 } else if (sAction == IBSEARCH) {
    		 if (comboObjects[0].GetSelectCode()== "") {
				 ComShowCodeMessage('SCG50011','RSO');
    			 //rgn_shp_opr_cd.focus();
    			 return;
    		 }

    		 if (ComGetObjValue(formObj.dg_cancel) == "Y") {

    		 }
    	 }else if (sAction == IBCLEAR) {
			if(sheetObj.IsDataModified()) {	//@@sheetObj에 변경이 없는데 IsDataModified가 1이 나옴
				var msg1="";
				/*if (formObj.tabSelectedIdx.value == "0") {
					msg1="DG - Part I";
				}else */
				if (formObj.tabSelectedIdx.value == "0") {
					msg1="DG - Part II";
				}else if (formObj.tabSelectedIdx.value == "1") {
					msg1="Awkward";
				}else if (formObj.tabSelectedIdx.value == "2") {
					msg1="Break-Bulk";
				}else if (formObj.tabSelectedIdx.value == "3") {
					msg1="45'";
				}else if (formObj.tabSelectedIdx.value == "4") {
					msg1="Reefer";
				}else if (formObj.tabSelectedIdx.value == "5") {
					msg1="Special Stow";
				}
				if(ComShowCodeConfirm('SCG50003', msg1)) {
					doActionIBSheet(sheetObj,formObj,IBSAVE);
					return true;
				}
			}
    	 }
         return true;
     }
     /**
      * Setting color according to approval code and reject code combo activation
      */
     function setAuthStat(sheetObj, row)
     {
     	with(sheetObj)
     	{
     		var auth=GetCellText(row, "spcl_cgo_auth_cd").substring(0,1);
      		SetCellFont("FontBold", row, "spcl_cgo_auth_cd",1);
			switch(auth)
			{
				case "R": case "S":
 					SetCellFontColor(row, "spcl_cgo_auth_cd","#FF862B");
 					//2016-02-19 R 일때, RJT_CD, RMK 빈 값 처리
 					SetCellText(row, "spcl_cgo_auth_rjct_cd" ,"");
 					SetCellText(row, "spcl_cgo_auth_rmk" ,"");
 					SetCellEditable(row, "spcl_cgo_auth_rjct_cd",0);
 					SetCellEditable(row, "spcl_cgo_auth_rmk",0);
					SetCellText(row, "apro_ref_no" ,"");
					//CellEditable(row, "apro_ref_no") = false;
					break;
				case "Y":
 					SetCellFontColor(row, "spcl_cgo_auth_cd","#4D964B");
					SetCellText(row, "spcl_cgo_auth_rjct_cd" ,"");
					SetCellText(row, "spcl_cgo_auth_rmk" ,"");
					SetCellEditable(row, "spcl_cgo_auth_rjct_cd",0);
					SetCellEditable(row, "spcl_cgo_auth_rmk",0);
					break;
				case "N":
					SetCellFontColor(row, "spcl_cgo_auth_cd","#FF0000");
					SetCellEditable(row, "spcl_cgo_auth_rjct_cd",1);
					SetCellText(row, "apro_ref_no" ,"");
					//CellEditable(row, "apro_ref_no") = false;
					//2016-06-22
					SetCellEditable(row, "spcl_cgo_auth_rmk",0);
					//2016-06-22
					break;
				case "P":
					SetCellFontColor(row, "spcl_cgo_auth_cd","#2663E0");
 					//2016-02-19 R 일때, RJT_CD, RMK 빈 값 처리
 					SetCellText(row, "spcl_cgo_auth_rjct_cd" ,"");
					//2016-06-22
 					SetCellText(row, "spcl_cgo_auth_rmk" ,"");
					//2016-06-22
					SetCellEditable(row, "spcl_cgo_auth_rjct_cd",0);
					SetCellEditable(row, "spcl_cgo_auth_rmk",0);
					SetCellText(row, "apro_ref_no" ,"");
					//CellEditable(row, "apro_ref_no") = false;
					break;
			}
     		var rjctCd=GetCellText(row, "spcl_cgo_auth_rjct_cd");
			switch(rjctCd)
			{
				default:
 					SetCellFontColor(row, "spcl_cgo_auth_rjct_cd","#FF0000");
					break;
			}
     	}
     }
     
     function setMergeRecordCnt(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	 var formObj=document.form;
    	 switch(sheetObj.id)
    	 {
			case "t2sheet1":
				formObj=formObj.t2OwnBox;
				break;
			case "t3sheet1":
				formObj=formObj.t3OwnBox;
				break;
			case "t4sheet1":
				formObj=formObj.t4OwnBox;
				break;
			case "t5sheet1":
				formObj=formObj.t5OwnBox;
				break;
			case "t6sheet1":
				formObj=formObj.t6OwnBox;
				break;
			case "t7sheet1":
				formObj=formObj.t7OwnBox;
				break;
    	 }

		 var showRowCnt = 0;
		 var selectShowRow = 0
		 
    	 if (formObj.checked){
    		 for (var i=2; i <= sheetObj.LastRow(); i ++) {
    			 if(!sheetObj.GetRowHidden(i)){
    				 showRowCnt++;
    			 }
    		 }
    		 for (var i=2; i <= sheetObj.LastRow(); i ++) {
    			 if(!sheetObj.GetRowHidden(i)){
    				 selectShowRow++;
    				 if(i == NewRow) {
    					 break;
    				 }
    			 }
    		 }
    	 }else{
    		 showRowCnt = sheetObj.RowCount();
    		 selectShowRow = sheetObj.GetSelectRow() - 1;
    	 }

    	 sheetObj.SetCountFormat("["+ selectShowRow +" / "+ showRowCnt +"]");

     }
     
     //Handling Box for OWN VSL Color
     function setOwnBox(sheetObj) {
    	 var formObj=document.form;
    	 switch(sheetObj.id)
    	 {
			case "t2sheet1":
				formObj=formObj.t2OwnBox;
				break;
			case "t3sheet1":
				formObj=formObj.t3OwnBox;
				break;
			case "t4sheet1":
				formObj=formObj.t4OwnBox;
				break;
			case "t5sheet1":
				formObj=formObj.t5OwnBox;
				break;
			case "t6sheet1":
				formObj=formObj.t6OwnBox;
				break;
			case "t7sheet1":
				formObj=formObj.t7OwnBox;
				break;
    	 }

		 var showRowCnt = 0;
		 var strHiddenRow= "";
    	 if (formObj.checked){
    		 //sheetObj.SetRowHidden(i,1) 처리시 속도 향상
    		 for (var i=sheetObj.LastRow(); i >= 2; i --) {
    			 if (ConstantMgr.getCompanyCode() == sheetObj.GetCellText(i, "crr_cd")) {
    				 //sheetObj.SetRowBackColor(i,"#FFFFC8");//
    				 for(var k=0; k <=40; k++){
    					 sheetObj.SetCellBackColor(i, k, "#FFFFC8");	 
    					 
    					 if (sheetObj.GetCellValue(i,"itm_sts_cd") == "N") {
    						 sheetObj.SetCellBackColor(i, "cntr_cgo_seq", "#66FF66");
    					 }else if  ( sheetObj.GetCellValue(i,"itm_sts_cd") == "U") {
    						 sheetObj.SetCellBackColor(i, "cntr_cgo_seq", "#FFFF00");
    					 }
    				 }
    				 
    				 showRowCnt++;
    			 }else{
    				 //sheetObj.SetRowBackColor(i, "#FFFFFF");//
    				 strHiddenRow = strHiddenRow + i + "|";
    				 //sheetObj.SetRowHidden(i,1);
    			 }
    			 //if(sheetObj.GetCellValue(i, "crr_cd") != 'NYK'){
   					 //sheetObj.SetRowHidden(i,1);
    			 //}
    		 }
    		 //sheetObj.RenderSheet(1);
    		 sheetObj.SetRowHidden(strHiddenRow,1);
    		 
    	 }else{
    		//sheetObj.SetRowHidden(i,0) 처리시 속도 향상
    		 for (var i=2; i <= sheetObj.LastRow(); i ++) {
    			 showRowCnt++;
   				 //sheetObj.SetRowBackColor(i, "#FFFFFF");//
				 if(sheetObj.GetCellBackColor(i, 0).toUpperCase() == "#FFFFC8"){
					 for(var k=0; k <=40; k++){
	
						 sheetObj.SetCellBackColor(i, k, "");	 
						 
						 if (sheetObj.GetCellValue(i,"itm_sts_cd") == "N") {
							 sheetObj.SetCellBackColor(i, "cntr_cgo_seq", "#66FF66");
						 }else if  (sheetObj.GetCellValue(i,"itm_sts_cd") == "U") {
							 sheetObj.SetCellBackColor(i, "cntr_cgo_seq", "#FFFF00");
						 }						 
					 }
				 }
   				 if(sheetObj.GetCellValue(i, "crr_cd") != ConstantMgr.getCompanyCode()){
   					     strHiddenRow = strHiddenRow + i + "|";
    			 }
    		 }
    		 sheetObj.SetRowHidden(strHiddenRow,0);
    	 }

    	 var firstRow = 0;
    	 if(showRowCnt == 0){
    		 firstRow = 0;
    	 }else{
    		 firstRow = 1;
    	 }
    	 sheetObj.SetCountFormat("["+ firstRow  +" / "+ showRowCnt +"]");
    	 sheetObj.SetSelectRow(2, 1)
 
     }
     

     function obj_click() {
   	 	switch(ComGetEvent("name")){
   	 		case "t2OwnBox": case "t3OwnBox": case "t4OwnBox": case "t5OwnBox": case "t6OwnBox": case "t7OwnBox": 
   	 			setOwnBox(sheetObjects[tabIndex]);
   	 			break;
   	 	}
//    	 sheetObjects[tabIndex].HideFilterRow();
     }
     
     function t2sheet1_OnRowSearchEnd(sheetObj, row) {
    	 with(sheetObj)
    	 {
    		 var befBkgNo   = "";
    		 var befVVD     = "";
    		 var spclAuthCd = "";
    		 
    		 var i = row;

			 befBkgNo   = GetCellText(i-1, "bkg_no");
			 befVVD     = GetCellText(i-1, "vsl_cd")+GetCellText(i-1, "skd_voy_no")+GetCellText(i-1, "skd_dir_cd");
			 spclAuthCd = GetCellText(i-1, "spcl_cgo_auth_cd");

			 if(GetCellValue(i, "edi_chk_type") == "1"){
				 sheetObj.InitCellProperty(i, "edi_chk_box",{ Type:"CheckBox",Align: "Center", Edit: 0} ); //CheckBox
				 SetCellValue(i,"edi_chk_box", "", 0);
				 SetCellEditable(i, "edi_chk_box", 1);
			 }else{
				//alert(GetCellValue(i,"edi_snd_no") +"------"+ GetCellValue(i,"edi_chk_box") + "------" + GetCellValue(i,"edi_chk_type") + "------" + GetCellValue(i,"edi_snd_his_flg"));
				 sheetObj.InitCellProperty(i, "edi_chk_box",{ Type:"Text",Align: "Center", Edit: 0} );
				 SetCellValue(i,"edi_chk_box", "", 0);
				 //2016-06-20 CRR_CD / ACT_CRR_CD 가 바뀌는 경우, 이전 OPR로 EDI가 발송되어 Box가 Checked 된 것에 대한 빈값 처리
				 SetCellValue(i,"edi_snd_no", "", 0);
			 }
			 
			 if(GetCellValue(i, "eml_chk_type") == "1"){
				 sheetObj.InitCellProperty(i, "email_chk_box",{ Type:"CheckBox",Align: "Center", Edit: 0} ); //CheckBox
				 SetCellValue(i,"email_chk_box", "", 0);
				 SetCellEditable(i, "email_chk_box", 1);
			 }else{
				 sheetObj.InitCellProperty(i, "email_chk_box",{ Type:"Text",Align: "Center", Edit: 0} );
				 SetCellValue(i,"email_chk_box", "", 0);
			 }
			 
			 setAuthStat(sheetObj, i);

			 if (befBkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
				 SetCellText(i, "num" ,mergeRowCnt0014);
				 if (GetCellValue(i,"edi_snd_no") == "Y") {
    				 SetCellValue(i,"edi_chk_box", "1", 0);
					 SetCellEditable(i, "edi_chk_box", 0);
    			 } else if (GetCellValue(i,"edi_chk") != "Y" || GetCellValue(i,"spcl_cgo_auth_cd") != "P" || GetCellValue(i,"spcl_cgo_auth_cd") != spclAuthCd) {
					 //checkBoxVis(sheetObj, LastRow(), mergeRowCnt0014, "edi_chk_box");
//					 sheetObj.InitCellProperty(i, "edi_chk_box",{ Type:"Text",Align: "Center", Edit: 0} );
//					 sheetObj.SetCellValue(i,"edi_chk_box", "", 0);
//					 
//					 sheetObj.InitCellProperty(i-1, "edi_chk_box",{ Type:"Text",Align: "Center", Edit: 0} );
//					 sheetObj.SetCellValue(i-1,"edi_chk_box", "", 0);
					 
				 } else if (GetCellValue(i,"edi_msg_sts_cd") == "X") {
					 SetCellValue(i,"edi_chk_box", "1", 0);
					 SetCellValue(i,"edi_snd_no", "Y", 0);
					 SetCellEditable(i, "edi_chk_box", 0);
    			 }

				 if (GetCellValue(i,"eml_chk") == "S") {
					 SetCellValue(i,"email_chk_box", "1", 0);
					 SetCellEditable(i, "email_chk_box", 0);
				 } else if (GetCellValue(i,"eml_chk") == "N" || GetCellValue(i,"spcl_cgo_auth_cd") != "P" || GetCellValue(i,"spcl_cgo_auth_cd") != spclAuthCd) {
					 
					 //checkBoxVis(sheetObj, LastRow(), mergeRowCnt0014, "email_chk_box");
//					 sheetObj.InitCellProperty(i, "email_chk_box",{ Type:"Text",Align: "Center", Edit: 0} );
//					 sheetObj.SetCellValue(i,"email_chk_box", "", 0);
//					 
//					 sheetObj.InitCellProperty(i-1, "email_chk_box",{ Type:"Text",Align: "Center", Edit: 0} );
//					 sheetObj.SetCellValue(i-1,"email_chk_box", "", 0);
				 }
			 }else{
				 mergeRowCnt0014++;
				 SetCellText(i, "num" ,mergeRowCnt0014);
				 if (GetCellValue(i,"edi_snd_no") == "Y") {
    				 SetCellValue(i,"edi_chk_box", "1", 0);
					 SetCellEditable(i, "edi_chk_box", 0);
    			 } else if (GetCellValue(i,"edi_chk") != "Y" || GetCellValue(i,"spcl_cgo_auth_cd") != "P") {
//    				 InitCellProperty(i, "edi_chk_box",{ Type:"Text",Align: "Center", Edit: 0} );
//					 SetCellValue(i,"edi_chk_box", "", 0);
				 } else if (GetCellValue(i,"edi_msg_sts_cd") == "X") {
					 SetCellValue(i,"edi_chk_box", "1", 0);
					 SetCellValue(i,"edi_snd_no", "Y", 0);
					 SetCellEditable(i, "edi_chk_box", 0);
    			 }

				 if (GetCellValue(i,"eml_chk") == "S") {
					 SetCellValue(i,"email_chk_box", "1", 0);
					 SetCellEditable(i, "email_chk_box", 0);
				 } else if (GetCellValue(i,"eml_chk") == "N" || GetCellValue(i,"spcl_cgo_auth_cd") != "P") {
					 //InitCellProperty(i, "email_chk_box",{ Type:"Text",Align: "Center", Edit: 0} );
					 //SetCellValue(i,"email_chk_box", "", 0);
				 }
			 }

			 if (GetCellValue(i,"edi_status") == "R") {
				 //InitCellProperty(i, "email_chk_box",{ Type:"Text",Align: "Center", Edit: 0} );
				 //SetCellValue(i,"email_chk_box", "", 0);
			 }
			 
			 if (GetCellValue(i,"itm_sts_cd") == "N") {
				 SetCellBackColor(i, "cntr_cgo_seq", "#66FF66");
			 }else if  (GetCellValue(i,"itm_sts_cd") == "U") {
				 SetCellBackColor(i, "cntr_cgo_seq", "#FFFF00");
			 }
			 
			 setSpclCgoAuthCdArr(sheetObj, i, "spcl_cgo_auth_cd", GetCellText(i, "spcl_cgo_auth_cd"));
			 SetRowStatus(i,"R");

    	 }
    	 
     }
     
     function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 var formObject=document.form;
    	 with(sheetObj)
    	 {
    		 //Handling Box for Own VSL
			 setOwnBox(sheetObj);
			 
			 if(sheetObj.TotalRows > 0) {
				 ComBtnEnable("btn_t2ApplDetails");
				 ComBtnEnable("btn_t2SendDgEdiRequest");
				 
				 if (ComGetObjValue(formObject.dg_cancel) != "Y") {
					 //ComBtnEnable("btn_t2SendDgEmlRequest");
					 $("#btn_t2SendDgEmlRequest").show();
				 }

			 }
    	 }
		 ComOpenWait(false);
     }
     
     function t3sheet1_OnRowSearchEnd(sheetObj, row) {
    	 with(sheetObj)
    	 {
    		 var befBkgNo   = "";
    		 var befVVD     = "";
    		 var i = row;
    		 
    		 befBkgNo   = GetCellText(i-1, "bkg_no");
			 befVVD     = GetCellText(i-1, "vsl_cd")+GetCellText(i-1, "skd_voy_no")+GetCellText(i-1, "skd_dir_cd");
			 
			 setAuthStat(sheetObj, i);
			 
			 if (befBkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
				 SetCellText(i, "num" ,mergeRowCnt0014);
			 }else{
				 mergeRowCnt0014++;
				 SetCellText(i, "num" ,mergeRowCnt0014);
			 }
			 setSpclCgoAuthCdArr(sheetObj, i, "spcl_cgo_auth_cd", GetCellText(i, "spcl_cgo_auth_cd"));
			 SetRowStatus(i,"R");

    	 } 
     }
     function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
//    		 var j=0;
//    		 var befBkgNo="";
//    		 var befVVD="";
//    		 for (var i=2; i <= LastRow(); i ++)
//    		 {
//    			 setAuthStat(sheetObj, i);
//    			 if (befBkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
//    				 SetCellText(i, "num" ,j);
//    			 }else{
//    				 j++;
//    				 SetCellText(i, "num" ,j);
//    			 }
//    			 befBkgNo=GetCellText(i, "bkg_no");
//    			 befVVD=GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd");
//    			 setSpclCgoAuthCdArr(sheetObj, i, "spcl_cgo_auth_cd", GetCellText(i, "spcl_cgo_auth_cd"));
//    			 SetRowStatus(i,"R");
//    		 }
    		 //Handling Box for Own VSL
			 setOwnBox(sheetObj);
			 if(sheetObj.TotalRows > 0) ComBtnEnable("btn_t3ApplDetails");
    	 }
    	 ComOpenWait(false);
     }
     function t4sheet1_OnRowSearchEnd(sheetObj, row) {
    	 with(sheetObj)
    	 {
    		 var befBkgNo   = "";
    		 var befVVD     = "";
    		 var i = row;
    		 
    		 befBkgNo   = GetCellText(i-1, "bkg_no");
			 befVVD     = GetCellText(i-1, "vsl_cd")+GetCellText(i-1, "skd_voy_no")+GetCellText(i-1, "skd_dir_cd");
			 
			 setAuthStat(sheetObj, i);
			 
			 if (befBkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
				 SetCellText(i, "num" ,mergeRowCnt0014);
			 }else{
				 mergeRowCnt0014++;
				 SetCellText(i, "num" ,mergeRowCnt0014);
			 }
			 setSpclCgoAuthCdArr(sheetObj, i, "spcl_cgo_auth_cd", GetCellText(i, "spcl_cgo_auth_cd"));
			 SetRowStatus(i,"R");
			 
    	 }    	 
     }
     function t4sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
//    		 var j=0;
//    		 var befBkgNo="";
//    		 var befVVD="";
//    		 for (var i=2; i <= LastRow(); i ++)
//    		 {
//    			 setAuthStat(sheetObj, i);
//    			 if (befBkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
//    				 SetCellText(i, "num" ,j);
//    			 }else{
//    				 j++;
//    				 SetCellText(i, "num" ,j);
//    			 }
//    			 befBkgNo=GetCellText(i, "bkg_no");
//    			 befVVD=GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd");
//    			 setSpclCgoAuthCdArr(sheetObj, i, "spcl_cgo_auth_cd", GetCellText(i, "spcl_cgo_auth_cd"));
//    			 SetRowStatus(i,"R");
//    		 }
    		 //Handling Box for Own VSL
			 setOwnBox(sheetObj);
			 if(sheetObj.TotalRows > 0) ComBtnEnable("btn_t4ApplDetails");
    	 }
    	 ComOpenWait(false);
     }
     function t5sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 var j=0;
    		 var befBkgNo="";
    		 var befVVD="";
    		 for (var i=2; i <= LastRow(); i ++)
    		 {
    			 setAuthStat(sheetObj, i);
    			 if (befBkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
    				 SetCellText(i, "num" ,j);
    			 }else{
    				 j++;
    				 SetCellText(i, "num" ,j);
    			 }
    			 befBkgNo=GetCellText(i, "bkg_no");
    			 befVVD=GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd");
    			 setSpclCgoAuthCdArr(sheetObj, i, "spcl_cgo_auth_cd", GetCellText(i, "spcl_cgo_auth_cd"));
    			 SetRowStatus(i,"R");
    		 }
    		 //Handling Box for Own VSL
			 setOwnBox(sheetObj);
			 if(sheetObj.TotalRows > 0) ComBtnEnable("btn_t5ApplDetails");
    	 }
     }
     function t6sheet1_OnRowSearchEnd(sheetObj, row) {
    	 with(sheetObj)
    	 {
    		 var befBkgNo   = "";
    		 var befVVD     = "";
    		 var i = row;

			 setAuthStat(sheetObj, i);
			 
    		 befBkgNo   = GetCellText(i-1, "bkg_no");
			 befVVD     = GetCellText(i-1, "vsl_cd")+GetCellText(i-1, "skd_voy_no")+GetCellText(i-1, "skd_dir_cd");
			 
			 if (befBkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
				 SetCellText(i, "num" ,mergeRowCnt0014);
			 }else{
				 mergeRowCnt0014++;
				 SetCellText(i, "num" ,mergeRowCnt0014);
			 }
			 
			 SetCellValue(i, "org_spcl_cgo_auth_cd",GetCellValue(i, "spcl_cgo_auth_cd"),0);
			 
			 setSpclCgoAuthCdArr(sheetObj, i, "spcl_cgo_auth_cd", GetCellText(i, "spcl_cgo_auth_cd"));
			 SetRowStatus(i,"R");

    	 }
     }
     function t6sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
//    		 var j=0;
//    		 var befBkgNo="";
//    		 var befVVD="";
//    		 for (var i=2; i <= LastRow(); i ++)
//    		 {
//    			 setAuthStat(sheetObj, i);
//    			 if (befBkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
//    				 SetCellText(i, "num" ,j);
//    			 }else{
//    				 j++;
//    				 SetCellText(i, "num" ,j);
//    			 }
//    			 befBkgNo=GetCellText(i, "bkg_no");
//    			 befVVD=GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd");
//    			 SetCellValue(i, "org_spcl_cgo_auth_cd",GetCellValue(i, "spcl_cgo_auth_cd"),0);
//    			 
//    			 setSpclCgoAuthCdArr(sheetObj, i, "spcl_cgo_auth_cd", GetCellText(i, "spcl_cgo_auth_cd"));
//    			 SetRowStatus(i,"R");
//    		 }
    		 //Handling Box for Own VSL
			 setOwnBox(sheetObj);
			 if(sheetObj.TotalRows > 0) ComBtnEnable("btn_t6ApplDetails");
    	 }
    	 ComOpenWait(false);
     }
     function t7sheet1_OnRowSearchEnd(sheetObj, row) {
    	 with(sheetObj)
    	 {
    		 var befBkgNo   = "";
    		 var befVVD     = "";
        	 var i = row;
    		 
    		 setAuthStat(sheetObj, i);
    		 
			 SetCellText(i, "num" , i-1);

    		 SetCellValue(i, "org_spcl_cgo_auth_cd",GetCellValue(i, "spcl_cgo_auth_cd"),0);
//    		 2016-03-14
//    		 if(GetCellValue(i, "dcgo_flg") == "Y"){
//    			 SetCellImage(i, "dcgo_flg", 1);
//    		 }else{
//    			 SetCellImage(i, "dcgo_flg", 0);
//    		 }
//    		 
//    		 if(GetCellValue(i, "awk_cgo_flg") == "Y"){
//    			 SetCellImage(i, "awk_cgo_flg", 1);
//    		 }else{
//    			 SetCellImage(i, "awk_cgo_flg", 0);
//    		 }
//    		 
//    		 if(GetCellValue(i, "bb_cgo_flg") == "Y"){
//    			 SetCellImage(i, "bb_cgo_flg", 1);
//    		 }else{
//    			 SetCellImage(i, "bb_cgo_flg", 0);
//    		 }
//    		 
//    		 if(GetCellValue(i, "rc_flg") == "Y"){
//    			 SetCellImage(i, "rc_flg", 1);
//    		 }else{
//    			 SetCellImage(i, "rc_flg", 0);
//    		 }
    		 
			 for(var j=0; j<arrValAry.length; j++){
				 var colnum = arrValAry[j];

	    		 if(GetCellText(i, "stwg_cd") == GetCellProperty(i, colnum, "SaveName")){
	    			 SetCellValue(i, colnum, "Y", 0);
	    		 }
//2016-03-14	    		 
//	    			 SetCellImage(i, colnum, 1);
//	    		 }else{
//	    			 SetCellImage(i, colnum, 0);
//	    		 }
			 }
		 
			 SetRowStatus(i,"R");
    	 }
     }
     function t7sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
//    		 var j=0;
//    		 var befBkgNo="";
//    		 var befVVD="";
////    		 var rnkGbn = 0;
//    		 for (var i=2; i <= LastRow(); i ++){
//    			 setAuthStat(sheetObj, i);
////    			 if (befBkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
////    				 SetCellText(i, "num" ,j);
////    			 }else{
////    				 j++;
////    				 SetCellText(i, "num" ,j);
////    			 }
//    			 //번호매기기
//    			 SetCellText(i, "num" ,i-1);
//    			 
//    			 befBkgNo=GetCellText(i, "bkg_no");
//    			 befVVD=GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd");
//    			 SetCellValue(i, "org_spcl_cgo_auth_cd",GetCellValue(i, "spcl_cgo_auth_cd"),0);
//    			 //SetRowStatus(i,"R");
//    			 
////    			 var flgAry = new Array();
//    			 var colAry = new Array();
//    			 colAry = makeOnlyCheckBoxCol(sheetObj).split("|");
//    			 for(var j=0; j<colAry.length; j++){
//    				 var colnum = colAry[j];
//
//    	    		 if(GetCellText(i, "stwg_cd") == GetCellProperty(i, colnum, "SaveName")){
//    	    			 SetCellValue(i, colnum, "Y", 0);
//    	    		 }
//    	    		 
////    	    		 if(GetCellText(i, "dcgo_flg") == "Y"){
////    	    			 flgAry.push("DG");
////		    		 }else if(GetCellText(i, "awk_cgo_flg") == "Y"){
////		    			 flgAry.push("AWK");
////		    		 }else if(GetCellText(i, "bb_cgo_flg") == "Y"){
////		    			 flgAry.push("BB");
////		    		 }else if(GetCellText(i, "rc_flg") == "Y"){
////		    			 flgAry.push("RF");
////		    		 }
//    	    		 
//    				 //색상조절
////    	    		 if(GetCellText(i, colnum) == "Y"){
////    	    			 //console.log(">>>>>>>>>>>>>"+GetCellProperty(1, colAry[j], "SaveName"));
////        	    		 SetCellBackColor(i, colnum, "Green");
////        			 }
//    			 }
//    			 SetRowStatus(i,"R");
//    			 //DG, AW, BB, RF 체크박스
////    			 for(var k=0; k < flgAry.length(); k++){
////    				 if(k == rnkGbn){
////    					 
////    				 }
////    				 
////    				 if(GetCellText(i, "stwg_cd")){
////    					 
////    				 }
//////    	    		 if(GetCellText(i, "dcgo_flg") == "Y"){
//////    	    			 
//////    	    		 }else if(GetCellText(i, "awk_cgo_flg") == "Y"){
//////    	    			 
//////    	    		 }else if(GetCellText(i, "bb_cgo_flg") == "Y"){
//////    	    			 
//////    	    		 }else if(GetCellText(i, "rc_flg") == "Y"){
//////    	    			 
//////    	    		 }
////    			 }
//    			 
//    		 }
    		 //Handling Box for Own VSL
			 setOwnBox(sheetObj);
			 //if(sheetObj.TotalRows > 0) ComBtnEnable("btn_t7ApplDetails");
			 if(sheetObj.TotalRows > 0) {
				 ComBtnEnable("btn_t7SendDgEmlRequest");
			 }
    	 }
    	 //2016-03-14
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

     function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)
     {
    	 setMergeRecordCnt(sheetObj, OldRow, OldCol, NewRow, NewCol)
		 //setOwnBox(sheetObj);
//		 sheetObj.SetRowBackColor(NewRow,"#E7FAF6");//
     }
     function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)
     {
    	 setMergeRecordCnt(sheetObj, OldRow, OldCol, NewRow, NewCol)
		 //setOwnBox(sheetObj);
//		 sheetObj.SetRowBackColor(NewRow,"#E7FAF6");//
     }
     function t4sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)
     {
    	 setMergeRecordCnt(sheetObj, OldRow, OldCol, NewRow, NewCol)
		 //setOwnBox(sheetObj);
//		 sheetObj.SetRowBackColor(NewRow,"#E7FAF6");//
     }
     function t5sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)
     {
    	 setMergeRecordCnt(sheetObj, OldRow, OldCol, NewRow, NewCol)
		 //setOwnBox(sheetObj);
//		 sheetObj.SetRowBackColor(NewRow,"#E7FAF6");//
     }
     function t6sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)
     {
    	 setMergeRecordCnt(sheetObj, OldRow, OldCol, NewRow, NewCol)
		 //setOwnBox(sheetObj);
//		 sheetObj.SetRowBackColor(NewRow,"#E7FAF6");//
     }
     function t7sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)
     {
    	 setMergeRecordCnt(sheetObj, OldRow, OldCol, NewRow, NewCol)
		 //setOwnBox(sheetObj);
//		 sheetObj.SetRowBackColor(NewRow,"#E7FAF6");//
     }
     
     function t2sheet1_OnCheckAllEnd(sheetObj, Col, Value) {
    	 
    	 var sRow    = sheetObj.FindCheckedRow(Col);
    	 var arrRow  = sRow.split("|");
    	 
    	 var crrCd   = "";
    	 var lanCd   = "";
    	 var melBool = false;
    	 var mel_msg = "";
    	 for(var nRow = 0; nRow < arrRow.length-1; nRow++) { 
    		 if (sheetObj.GetCellText(arrRow[nRow], "email_chk_box") == "1" && sheetObj.GetCellText(arrRow[nRow], "eml_addr") == "") {    			 
    			 melBool = true;
    			 sheetObj.SetCellValue(arrRow[nRow], "email_chk_box", "0");
    			 
    			 if (crrCd != sheetObj.GetCellValue(arrRow[nRow], "crr_cd") || lanCd != sheetObj.GetCellValue(arrRow[nRow], "slan_cd")) {
    				 mel_msg = mel_msg + "[" + sheetObj.GetCellValue(arrRow[nRow], "crr_cd")  + ", " + sheetObj.GetCellValue(arrRow[nRow], "slan_cd") +"]"+ "\n";
    				 crrCd = sheetObj.GetCellValue(arrRow[nRow], "crr_cd");
    				 lanCd = sheetObj.GetCellValue(arrRow[nRow], "slan_cd");
    			 }
    		 }
    	 }
    	 
    	 if (melBool) {
    		 ComShowCodeMessage("SCG50039" , mel_msg);
    	 }
     }

     function t2sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	    		 	 if("Combo" == sheetObj.GetCellProperty(Row, Col, "Type")){
	    		 		return;
	    	         }
	    	         //auth_cd = sheetObj.GetCellText(Row, "spcl_cgo_auth_cd");
    		 		 //setSpclCgoAuthCdArr(sheetObj, Row, Col, auth_cd);
	    			 break;
	    		 case "apro_ref_no":
	    			 if (GetCellText(Row, "spcl_cgo_auth_cd") == "Y" && GetCellText(Row, "crr_code") != ConstantMgr.getCompanyCode()) {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    			 break;
	    		 case "email_chk_box":
	    			 if (GetCellText(Row, "email_chk_box") == "1" && GetCellText(Row, "eml_addr") == "") {
	    				 var mel_msg = "";
	    				 mel_msg = mel_msg + "[" + GetCellValue(Row, "crr_cd")  + ", " + GetCellValue(Row, "slan_cd") +"]"+ "\n";
	    				 
	    				 SetCellValue(Row, "email_chk_box", 0);
	    				 ComShowCodeMessage("SCG50039" , mel_msg);
	    			 }
	    			 break;
    		 }
    	 }
     }
     function t3sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	    		 	 if("Combo" == sheetObj.GetCellProperty(Row, Col, "Type")){
		    		 		return;
		    	     }
		    	     //auth_cd = sheetObj.GetCellText(Row, "spcl_cgo_auth_cd");
	    		 	 //setSpclCgoAuthCdArr(sheetObj, Row, Col, sheetObj.GetCellText(Row, "spcl_cgo_auth_cd"));
	      			break;
	    		 case "apro_ref_no":
	    			 if (GetCellText(Row, "spcl_cgo_auth_cd") == "Y" && GetCellText(Row, "crr_code") != ConstantMgr.getCompanyCode()) {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    			 break;
    		 }
    	 }
     }
     function t4sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	    		 	 if("Combo" == sheetObj.GetCellProperty(Row, Col, "Type")){
		    		 		return;
		    	     }
		    	     //auth_cd = sheetObj.GetCellText(Row, "spcl_cgo_auth_cd");
	    		 	 //setSpclCgoAuthCdArr(sheetObj, Row, Col, sheetObj.GetCellText(Row, "spcl_cgo_auth_cd"));
	      			break;
	    		 case "apro_ref_no":
	    			 if (GetCellText(Row, "spcl_cgo_auth_cd") == "Y" && GetCellText(Row, "crr_code") != ConstantMgr.getCompanyCode()) {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    			 break;
    		 }
    	 }
     }
     function t5sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	    		 	 if("Combo" == sheetObj.GetCellProperty(Row, Col, "Type")){
		    		 		return;
		    	     }
		    	     //auth_cd = sheetObj.GetCellText(Row, "spcl_cgo_auth_cd");
	    		 	 //setSpclCgoAuthCdArr(sheetObj, Row, Col, sheetObj.GetCellText(Row, "spcl_cgo_auth_cd"));
	      			break;
	    		 case "apro_ref_no":
	    			 if (GetCellText(Row, "spcl_cgo_auth_cd") == "Y") {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    			 break;
    		 }
    	 }
     }
     function t6sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	    		 	 if("Combo" == sheetObj.GetCellProperty(Row, Col, "Type")){
		    		 		return;
		    	     }
		    	     //auth_cd = sheetObj.GetCellText(Row, "spcl_cgo_auth_cd");
	    		 	 //setSpclCgoAuthCdArr(sheetObj, Row, Col, sheetObj.GetCellText(Row, "spcl_cgo_auth_cd"));
	      			break;
	    		 case "apro_ref_no":
	    			 if (GetCellText(Row, "spcl_cgo_auth_cd") == "Y") {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    			 break;
    		 }
    	 }
     }
     function t7sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
	    		 case "spcl_cgo_auth_cd":
	    		 	 if("Combo" == sheetObj.GetCellProperty(Row, Col, "Type")){
		    		 		return;
		    	     }
		    	     auth_cd = sheetObj.GetCellText(Row, "spcl_cgo_auth_cd");
	    		 	 setSpclCgoAuthCdArrALL(sheetObj, Row, Col, sheetObj.GetCellText(Row, "spcl_cgo_auth_cd"));
	      			break;
	    		 case "apro_ref_no":
	    			 if (GetCellText(Row, "spcl_cgo_auth_cd") == "Y") {
	    				 ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	    			 }
	    		break;
    		 }
    	 }
    	 //2016-03-14
    	 $(".GridMain1 .GridMain2 .GMBool1RO").css("background-image", "url('js/ibsheet/Main/chk1.gif')");
     }

     function t2sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t2ApplDetails");
     }
     function t3sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t3ApplDetails");
     }
     function t4sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t4ApplDetails");
     }
     function t5sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t5ApplDetails");
     }
     function t6sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t6ApplDetails");
     }
     /* 팝업없음
     function t7sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 onPopupClick(sheetObj, "t7ApplDetails");
     }*/

     function t2sheet1_OnChange(sheetObj, Row, Col, Val, oldVal)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (GetCellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo=GetCellText(Row, "bkg_no");
    				 var befVVD=GetCellText(Row, "vsl_cd")+GetCellText(Row, "skd_voy_no")+GetCellText(Row, "skd_dir_cd");
    				 var authNo=GetCellText(Row, "apro_ref_no");
    	    		 for (var i=2; i <= LastRow(); i ++)
    	    		 {
    	    			 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
    	    				 setSpclCgoAuthCdArr(sheetObj, i, Col, "ALL");
    	    		 		 SetCellValue(i, "spcl_cgo_auth_cd","Y");
   	    				     SetCellValue(i, "apro_ref_no",authNo);
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 } 					
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode=GetComboInfo(Row, Col, "Code");
    			 var arrCode=sCode.split("|");
    			 var j=0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 SetCellValue(Row, "spcl_cgo_auth_rjct_cd","",0);
					 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm="";
	    			 if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm=arrRjctNmDG.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == GetCellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 SetCellValue(Row, "spcl_cgo_auth_rmk",arrRjctCdNm[i].split("\t")[1],0);
	    					 }
	    				 }
	    			 }else if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
	    			 }
				 }
    			 break;
    		 }
    	 }
     }
     function t3sheet1_OnChange(sheetObj, Row, Col, Val, oldVal)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (GetCellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo=GetCellText(Row, "bkg_no");
    				 var befVVD=GetCellText(Row, "vsl_cd")+GetCellText(Row, "skd_voy_no")+GetCellText(Row, "skd_dir_cd");
    				 var authNo=GetCellText(Row, "apro_ref_no");
    	    		 for (var i=2; i <= LastRow(); i ++)
    	    		 {
       	    			 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
       	    				 setSpclCgoAuthCdArr(sheetObj, i, Col, "ALL");
       	    				 
       	    				 SetCellValue(i, "spcl_cgo_auth_cd","Y");
    	    				 SetCellValue(i, "apro_ref_no",authNo);
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 }
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode=GetComboInfo(Row, Col, "Code");
    			 var arrCode=sCode.split("|");
    			 var j=0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 SetCellValue(Row, "spcl_cgo_auth_rjct_cd","",0);
					 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm="";
	    			 if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm=arrRjctNmAK.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == GetCellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 SetCellValue(Row, "spcl_cgo_auth_rmk",arrRjctCdNm[i].split("\t")[1],0);
	    					 }
	    				 }
					}else if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
	    			 }
				 }
    			 break;
    		 }
    	 }
     }
     function t4sheet1_OnChange(sheetObj, Row, Col, Val, oldVal)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (GetCellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo=GetCellText(Row, "bkg_no");
    				 var befVVD=GetCellText(Row, "vsl_cd")+GetCellText(Row, "skd_voy_no")+GetCellText(Row, "skd_dir_cd");
    				 var authNo=GetCellText(Row, "apro_ref_no");
    	    		 for (var i=2; i <= LastRow(); i ++)
    	    		 {
       	    			 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
       	    			 	 setSpclCgoAuthCdArr(sheetObj, i, Col, "ALL");
       	    				
       	    				 SetCellValue(i, "spcl_cgo_auth_cd","Y");
    	    				 SetCellValue(i, "apro_ref_no",authNo);
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 }
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode=GetComboInfo(Row, Col, "Code");
    			 var arrCode=sCode.split("|");
    			 var j=0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 SetCellValue(Row, "spcl_cgo_auth_rjct_cd","",0);
					 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm="";
	    			 if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm=arrRjctNmBB.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == GetCellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 SetCellValue(Row, "spcl_cgo_auth_rmk",arrRjctCdNm[i].split("\t")[1],0);
	    					 }
	    				 }
	    			 }else if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
	    			 }
				 }
    			 break;
    		 }
    	 }
     }
     function t5sheet1_OnChange(sheetObj, Row, Col, Val, oldVal)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (GetCellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo=GetCellText(Row, "bkg_no");
    				 var befVVD=GetCellText(Row, "vsl_cd")+GetCellText(Row, "skd_voy_no")+GetCellText(Row, "skd_dir_cd");
    				 var authNo=GetCellText(Row, "apro_ref_no");
    	    		 for (var i=2; i <= LastRow(); i ++)
    	    		 {
    	    			 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
    	    				 setSpclCgoAuthCdArr(sheetObj, i, Col, "ALL");
    	    				 SetCellValue(i, "spcl_cgo_auth_cd","Y");
    	    				 SetCellValue(i, "apro_ref_no",authNo);
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 }
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode=GetComboInfo(Row, Col, "Code");
    			 var arrCode=sCode.split("|");
    			 var j=0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 SetCellValue(Row, "spcl_cgo_auth_rjct_cd","",0);
					 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm="";
	    			 if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm=arrRjctNmAK.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == GetCellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 SetCellValue(Row, "spcl_cgo_auth_rmk",arrRjctCdNm[i].split("\t")[1],0);
	    					 }
	    				 }
	    			 }else if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
	    			 }
				 }
    			 break;
    		 }
    	 }
     }
     function t6sheet1_OnChange(sheetObj, Row, Col, Val, oldVal)
     {
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
    			 if (GetCellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo=GetCellText(Row, "bkg_no");
    				 var befVVD=GetCellText(Row, "vsl_cd")+GetCellText(Row, "skd_voy_no")+GetCellText(Row, "skd_dir_cd");
    				 var authNo=GetCellText(Row, "apro_ref_no");
    	    		 for (var i=2; i <= LastRow(); i ++)
    	    		 {
       	    			 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
       	    			     setSpclCgoAuthCdArr(sheetObj, i, Col, "ALL");
       	    				 SetCellValue(i, "spcl_cgo_auth_cd","Y");
    	    				 SetCellValue(i, "apro_ref_no",authNo);
    	    				 setAuthStat(sheetObj, i);
    	    			 }
    	    		 }
    			 }else{
    				 setAuthStat(sheetObj, Row);
    			 }
    			 break;
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode=GetComboInfo(Row, Col, "Code");
    			 var arrCode=sCode.split("|");
    			 var j=0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 SetCellValue(Row, "spcl_cgo_auth_rjct_cd","",0);
					 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm="";
	    			 if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 arrRjctCdNm=arrRjctNmRF.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == GetCellValue(Row, "spcl_cgo_auth_rjct_cd")) {
	    						 SetCellValue(Row, "spcl_cgo_auth_rmk",arrRjctCdNm[i].split("\t")[1],0);
	    					 }
	    				 }
	    			 }else if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
						 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
	    			 }
				 }
    			 break;
    		 }
    	 }
     }
     
     /** TAB : SPECIAL STOWAGE **/
     function t7sheet1_OnChange(sheetObj, Row, Col, Val, oldVal)
     {
    	
    	 with(sheetObj)
    	 {
    		 var colname=ColSaveName(Col);
    		 switch(colname)
    		 {
    		 case "spcl_cgo_auth_cd":
				 //var bkgNo=GetCellText(Row, "bkg_no");
				 //var befVVD=GetCellText(Row, "vsl_cd")+GetCellText(Row, "skd_voy_no")+GetCellText(Row, "skd_dir_cd");
				 //var authNo=GetCellText(Row, "apro_ref_no");
    			 //if (GetCellValue(Row, "spcl_cgo_auth_cd") == "Y") {
    	    	//	 for (var i=2; i <= LastRow(); i ++)
    	    	//	 {
       	    	//		 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
    	    	//			 SetCellValue(i, "spcl_cgo_auth_cd","Y");
    	    	//			 SetCellValue(i, "apro_ref_no",authNo);
    	    	//			 setAuthStat(sheetObj, i);
    	    	//		 }
    	    	//	 }
    			 //}else if(GetCellValue(Row, "spcl_cgo_auth_cd") == "N") {
    	    	//	 for (var i=2; i <= LastRow(); i ++)
    	    	//	 {
       	    	//		 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
    	    	//			 SetCellValue(i, "spcl_cgo_auth_cd","N");
    	    	//			 SetCellValue(i, "apro_ref_no",authNo);
    	    	//			 setAuthStat(sheetObj, i);
    	    	//		 }
    	    	//	 }
    		 	 //}else if(GetCellValue(Row, "spcl_cgo_auth_cd") == "P") {
    	    	//	 for (var i=2; i <= LastRow(); i ++)
    	    	//	 {
       	    	//		 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
    	    	//			 SetCellValue(i, "spcl_cgo_auth_cd","P");
    	    	//			 SetCellValue(i, "apro_ref_no",authNo);
    	    	//			 setAuthStat(sheetObj, i);
    	    	//		 }
    	    	//	 }
    		 	 //}else{
    	    	//	 for (var i=2; i <= LastRow(); i ++)
    	    	//	 {
       	    	//		 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
    	    	//			 SetCellValue(i, "spcl_cgo_auth_cd", GetCellValue(Row, "spcl_cgo_auth_cd"));
    	    	//			 SetCellValue(i, "apro_ref_no",authNo);
    	    	//			 setAuthStat(sheetObj, i);
    	    	//		 }
    	    	//	 }
    			 //}/*else{
    			//	 setAuthStat(sheetObj, Row);
    			 //}*/
    			 //if (GetCellValue(Row, "spcl_cgo_auth_cd") == "A") {
    				 var bkgNo=GetCellText(Row, "bkg_no");
    				 var befVVD=GetCellText(Row, "vsl_cd")+GetCellText(Row, "skd_voy_no")+GetCellText(Row, "skd_dir_cd");
    				 
    				 var polCd=GetCellText(Row, "pol_cd");
    				 var podCd=GetCellText(Row, "pod_cd");
    				 
    				 var authNo=GetCellText(Row, "apro_ref_no");
    				 
    				 for (var i=2; i <= LastRow(); i ++)
    	    		 {
    					 console.log(i+" ,bkgNo="+bkgNo + ",befVVD="+befVVD + ",bk="+GetCellText(i, "bkg_no") + "vv="+GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd"))
    					 
    					 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd") && polCd == GetCellText(i, "pol_cd") && podCd == GetCellText(i, "pod_cd")) {
       	    			     //setSpclCgoAuthCdArr(sheetObj, i, Col, "ALL");
       	    				 SetCellValue(i, "spcl_cgo_auth_cd",Val, 0);
    	    				 SetCellValue(i, "apro_ref_no",authNo, 0);
    	    				 setAuthStat(sheetObj, i);
    	    			 }

    	    		 }
 						//2016-06-22
	    				 if(GetCellValue(Row, "spcl_cgo_auth_cd") == "Y"||GetCellValue(Row, "spcl_cgo_auth_cd") == "P"){
   	    					 SetCellEditable(Row, "spcl_cgo_auth_rmk", 1);
   	        				 }
	 					//2016-06-22
    				 

    			 //}else{
    			//	 setAuthStat(sheetObj, Row);
    			 //}    			 
    			 
    			 break;
    			 
    		 case "spcl_cgo_auth_rjct_cd":
    			 var sCode=GetComboInfo(Row, Col, "Code");
    			 var arrCode=sCode.split("|");
    			 var j=0;
				 for(var i=0; i <= arrCode.length-1; i++) {
					 if (Val == arrCode[i]) {
						 j++;
					 }
				 }
				 if (j == 0) {
					 SetCellValue(Row, "spcl_cgo_auth_rjct_cd","",0);
					 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
				 }else {
	    			 setAuthStat(sheetObj, Row);
	    			 var arrRjctCdNm="";
	    			 var rjctCd = GetCellValue(Row, "spcl_cgo_auth_rjct_cd");
	    			 var rjctNm = "";
	    			 if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") != "AAA") {
	    				 SetCellEditable(Row, "spcl_cgo_auth_rmk", 0);
	    				 arrRjctCdNm=arrRjctNmSS.split("|");
	    				 for(var i=0; i <= arrRjctCdNm.length-1; i++) {
	    					 if (arrRjctCdNm[i].split("\t")[0] == GetCellValue(Row, "spcl_cgo_auth_rjct_cd") && GetCellValue(Row, "spcl_cgo_auth_rjct_cd") != "") {
	    						 rjctNm = arrRjctCdNm[i].split("\t")[1];
	    						 //SetCellValue(Row, "spcl_cgo_auth_rmk",rjctNm,0);
	    					 }
	    				 }
	    			 }else if (GetCellValue(Row, "spcl_cgo_auth_rjct_cd") == "AAA") {
	    				 SetCellEditable(Row, "spcl_cgo_auth_rmk", 1);
						 SetCellValue(Row, "spcl_cgo_auth_rmk","",0);
	    			 }
	    			 //spcl_cgo_auth_rjct_cd
					 var bkgNo=GetCellText(Row, "bkg_no");
					 var befVVD=GetCellText(Row, "vsl_cd")+GetCellText(Row, "skd_voy_no")+GetCellText(Row, "skd_dir_cd");
					 var authNo=GetCellText(Row, "apro_ref_no");
    	    		 for (var i=2; i <= LastRow(); i ++)
    	    		 {
       	    			 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
    	    				 SetCellValue(i, "spcl_cgo_auth_rjct_cd", rjctCd, 0);
    	    				 SetCellValue(i, "spcl_cgo_auth_rmk", rjctNm, 0);
    	    			 }
    	    		 }
				 }
    			 break;
    		 case	 "spcl_cgo_auth_rmk":
				 var bkgNo=GetCellText(Row, "bkg_no");
				 var befVVD=GetCellText(Row, "vsl_cd")+GetCellText(Row, "skd_voy_no")+GetCellText(Row, "skd_dir_cd");
				 var rjctNm=GetCellText(Row, "spcl_cgo_auth_rmk");
	    		 for (var i=2; i <= LastRow(); i ++)
	    		 {
   	    			 if (bkgNo == GetCellText(i, "bkg_no") && befVVD == GetCellText(i, "vsl_cd")+GetCellText(i, "skd_voy_no")+GetCellText(i, "skd_dir_cd")) {
	    				 SetCellValue(i, "spcl_cgo_auth_rmk", rjctNm, 0);
	    			 }
	    		 }
    			 break;
    		 }
    	 }
     }
     

     var sInt = 0;
     function returnSvcLaneCdHelp(rtnObjs){
    	 var rtnArray=rtnObjs[0];
     	var formObj=document.form;
     	var rtnDatas=rtnObjs;
     	if(rtnObjs.length > 0){
     		if(sInt == 1){
     			formObj.slan_cd1.value=rtnArray[1]; //vessel code
     		}else if(sInt == 2){
     			formObj.slan_cd2.value=rtnArray[1];
     		}else if(sInt == 3){
     			formObj.slan_cd3.value=rtnArray[1];
     		}else if(sInt == 4){
     			formObj.slan_cd4.value=rtnArray[1];
     		}else if(sInt == 5){
     			formObj.slan_cd5.value=rtnArray[1];
     		}else if(sInt == 6){
     			formObj.slan_cd6.value=rtnArray[1];
     		}else if(sInt == 7){
     			formObj.slan_cd7.value=rtnArray[1];
     		}else if(sInt == 8){
     			formObj.slan_cd8.value=rtnArray[1];
     		}else if(sInt == 9){
     			formObj.slan_cd9.value=rtnArray[1];
     		}else if(sInt == 10){
     			formObj.slan_cd10.value=rtnArray[1];
     		}else if(sInt == 11){
     			formObj.slan_cd11.value=rtnArray[1];
     		}
     	}
     }
     /**
      * @@ 수정
      * Clicking popup in IBSheet Object
      */
     function onPopupClick(srcName, srcType){
    	 //@@
    	 var getRow = "";
    	 if(srcType.indexOf("ApplDetails") > 0 || srcType.indexOf("sheet") > 0){
    		 getRow = srcName.GetSelectRow();
    	 }

    	 if (srcType == "Lane") {
    		 var objName="btn_SlanCd";
//    		 var sInt;
    		 if (srcName.indexOf(objName) > -1) {
    			 sInt=srcName.substring(objName.length, srcName.length);
    		 }else{
    			 sInt=srcName.substring(srcName.length-1, srcName.length);
    		 }
    		 //ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0202.do', 460,480, "sheet1_vsl_slan_cd:slan_cd"+sInt, "0,0", true);
    		 ComOpenPopup('/opuscntr/VOP_VSK_0202.do', 460, 470, "returnSvcLaneCdHelp", "0,0", true);
    	 }else if (srcType == "Vessel") {
    		 ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0219.do?op=0219', 480, 500, "vsl_cd:vsl_cd", "0,0", true);
    	 }else if (srcType == "t2ApplDetails" || srcType == "t2sheet1") {
    		 if (getRow< 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{

    			 ComOpenPopup("VOP_SCG_0015.do?type=O&scg_flg=DG2&bkg_no="+sheetObjects[0].GetCellText(getRow, "bkg_no")+"&vvd_cd="+sheetObjects[0].GetCellText(getRow, "vsl_cd")+sheetObjects[0].GetCellText(getRow, "skd_voy_no")+sheetObjects[0].GetCellText(getRow, "skd_dir_cd")+"&dg_cntr_seq="+sheetObjects[0].GetCellText(getRow, "dg_cntr_seq")+"&cntr_cgo_seq="+sheetObjects[0].GetCellText(getRow, "cntr_cgo_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[0].GetCellText(getRow, "spcl_cgo_apro_rqst_seq")+"&cfr_flg="+sheetObjects[0].GetCellText(getRow, "cfr_flg")+"&dcgo_seq="+sheetObjects[0].GetCellText(getRow, "dcgo_seq"), 1150, 668, "", '0,0', 1, 0, getRow, 0, 1, "VOP_SCG_0015"); //790
    		 }
    	 }else if (srcType == "t3ApplDetails" || srcType == "t3sheet1") {
    		 if (getRow< 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 ComOpenPopup("VOP_SCG_0016.do?typ=O&scg_flg=AWK&bkg_no="+sheetObjects[1].GetCellText(getRow, "bkg_no")+"&vvd_cd="+sheetObjects[1].GetCellText(getRow, "vsl_cd")+sheetObjects[1].GetCellText(getRow, "skd_voy_no")+sheetObjects[1].GetCellText(getRow, "skd_dir_cd")+"&awk_cgo_seq="+sheetObjects[1].GetCellText(getRow, "awk_cgo_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[1].GetCellText(getRow, "spcl_cgo_apro_rqst_seq"), 1150, 730, "", '0,0', 1, 0, getRow, 0, 2, "VOP_SCG_0016"); //1023, 780
    		 }
    	 }else if (srcType == "t4ApplDetails" || srcType == "t4sheet1") {
    		 if (getRow< 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 ComOpenPopup("VOP_SCG_0017.do?type=O&scg_flg=BB&bkg_no="+sheetObjects[2].GetCellText(getRow, "bkg_no")+"&vvd_cd="+sheetObjects[2].GetCellText(getRow, "vsl_cd")+sheetObjects[2].GetCellText(getRow, "skd_voy_no")+sheetObjects[2].GetCellText(getRow, "skd_dir_cd")+"&bb_cgo_seq="+sheetObjects[2].GetCellText(getRow, "bb_cgo_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[2].GetCellText(getRow, "spcl_cgo_apro_rqst_seq"), 1023, 780, "", '0,0', 1, 0, getRow, 0, 3, "VOP_SCG_0017");
    		 }
    	 }else if (srcType == "t5ApplDetails" || srcType == "t5sheet1") {
    		 if (getRow< 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 ComOpenPopup("VOP_SCG_0016.do?type=O&scg_flg=45&bkg_no="+sheetObjects[3].GetCellText(getRow, "bkg_no")+"&vvd_cd="+sheetObjects[3].GetCellText(getRow, "vsl_cd")+sheetObjects[3].GetCellText(getRow, "skd_voy_no")+sheetObjects[3].GetCellText(getRow, "skd_dir_cd")+"&awk_cgo_seq="+sheetObjects[3].GetCellText(getRow, "awk_cgo_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[3].GetCellText(getRow, "spcl_cgo_apro_rqst_seq"), 1150, 730, "", '0,0', 1, 0, getRow, 0, 4, "VOP_SCG_0016"); //1023, 627
    		 }
    	 }else if (srcType == "t6ApplDetails" || srcType == "t6sheet1") {
    		 if (getRow< 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 ComOpenPopup("VOP_SCG_0018.do?type=O&scg_flg=RF&bkg_no="+sheetObjects[4].GetCellText(getRow, "bkg_no")+"&vvd_cd="+sheetObjects[4].GetCellText(getRow, "vsl_cd")+sheetObjects[4].GetCellText(getRow, "skd_voy_no")+sheetObjects[4].GetCellText(getRow, "skd_dir_cd")+"&rc_seq="+sheetObjects[4].GetCellText(getRow, "rc_seq")+"&spcl_cgo_apro_rqst_seq="+sheetObjects[4].GetCellText(getRow, "spcl_cgo_apro_rqst_seq"), 1023, 700, "", '0,0', 1, 0, getRow, 0, 5, "VOP_SCG_0018");
    		 }
    	 }/*팝업없음
    	  else if (srcType == "t7ApplDetails" || srcType == "t7sheet1") {
    	  */

     }
     function clearAll() {
    	 var formObj=document.form;
    	 formObj.reset();
     	 ComSetObjValue(formObj.rqst_from_dt , ComGetDateAdd(null, "d", -7));
         ComSetObjValue(formObj.rqst_to_dt  , ComGetDateAdd(null, "d", 0));
    	 sheetObjects[0].SetCountFormat("[0 / 0]");
    	 sheetObjects[1].SetCountFormat("[0 / 0]");
    	 sheetObjects[2].SetCountFormat("[0 / 0]");
    	 sheetObjects[3].SetCountFormat("[0 / 0]");
    	 sheetObjects[4].SetCountFormat("[0 / 0]");
    	 sheetObjects[5].SetCountFormat("[0 / 0]");
         sheetObjects[0].RemoveAll();
    	 sheetObjects[1].RemoveAll();
    	 sheetObjects[2].RemoveAll();
    	 sheetObjects[3].RemoveAll();
    	 sheetObjects[4].RemoveAll();
    	 sheetObjects[5].RemoveAll();
    	 
    	 checkPostEta();
     }
  	function checkPostEta(){
 		var formObj=document.form;
 		if (formObj.from_eta_flg.checked == true) {
    		document.getElementById("from_eta_dt").disabled=false;
 			document.getElementById("from_eta_dt").className="input1";
    		document.getElementById("from_eta_dt").value="10";
 		}else{
    		document.getElementById("from_eta_dt").disabled=true;
 			document.getElementById("from_eta_dt").className="input2";
    		document.getElementById("from_eta_dt").value="";
 		}
 	}

  	function rgn_shp_opr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
  		//@@document.form.rgn_shp_opr_cde_text.value 콤보 텍스트 객체명을 인식못함
    	document.form.rgn_shp_opr_cd_text.value = rgn_shp_opr_cd.GetSelectCode();
    }

    function rgn_shp_opr_cd_OnBlur() {
    	document.form.rgn_shp_opr_cd_text.value = rgn_shp_opr_cd.GetSelectText();
    }

    function setSpclCgoAuthCdArr(sheetObj, Row, Col, auth_cd) {
	   	 var cText = "Y|Y(all)|N|P";
	   	 var cCode = "Y|A|N|P";
	   	 if(auth_cd!="" && !(auth_cd=="Y"|| auth_cd=="A" || auth_cd=="N" || auth_cd=="P")){
	   		 cText = cText + "|" + auth_cd;
	   		 cCode = cCode + "|" + auth_cd;
	   	 }
	   	 
	   	 if (auth_cd == "ALL") {
	   		cText = sheetObj.GetComboInfo(Row, Col, "Text");
	   		cCode = sheetObj.GetComboInfo(Row, Col, "Code");
	   	 }
	   	 sheetObj.InitCellProperty(Row, Col,{ Type:"Combo",Align:"Center", ComboText:cText, ComboCode:cCode} );
    }
    
    function setSpclCgoAuthCdArrALL(sheetObj, Row, Col, auth_cd){
	   	 var cText = "Y|N|P";
	   	 var cCode = "Y|N|P";
	   	 if(auth_cd!="" && !(auth_cd=="A" || auth_cd=="N" || auth_cd=="P")){
	   		 cText = cText + "|" + auth_cd;
	   		 cCode = cCode + "|" + auth_cd;
	   	 }
	   	 sheetObj.InitCellProperty(Row, Col,{ Type:"Combo",Align:"Center", ComboText:cText, ComboCode:cCode} );
//	   	 var cText = "Y|Y(all)|N|P";
//	   	 var cCode = "Y|A|N|P";
//	   	 if(auth_cd!="" && !(auth_cd=="Y"|| auth_cd=="A" || auth_cd=="N" || auth_cd=="P")){
//	   		 cText = cText + "|" + auth_cd;
//	   		 cCode = cCode + "|" + auth_cd;
//	   	 }
//	   	 sheetObj.InitCellProperty(Row, Col,{ Type:"Combo",Align:"Center", ComboText:cText, ComboCode:cCode} );
   }
    
    function checkBoxVis(sheetObj, last, j, column) {
    	for (var x=2; x <= last; x++) {
			 if (sheetObj.GetCellText(x, "num") == j) {
				 sheetObj.InitCellProperty(x, column,{ Type:"Text",Align: "Center", Edit: 0} );
				 sheetObj.SetCellValue(x,column, "", 0);
				 sheetObj.SetRowStatus(x,"R");
			 }
		 }
    }
    
    function RequestDtDisabled(clsnm, able, dgStatus) {
    	
    	formObj = document.form;
    	ComSetObjValue(formObj.rqst_from_dt , ComGetDateAdd(null, "d", -7));
        ComSetObjValue(formObj.rqst_to_dt  , ComGetDateAdd(null, "d", 0));
        $("#rqst_from_dt").attr('class',clsnm);
        $("#rqst_to_dt").attr('class'  ,clsnm);
        $("#rqst_from_dt").attr("disabled",able);
        $("#rqst_to_dt").attr("disabled",able);
        if (dgStatus == "Y") {
        	ComBtnEnable("btn_Calendar");
        }else {
        	ComBtnDisable("btn_Calendar");
        }
        
    }
    
    function initSendDgEdiButtion(dgStatus){
    	var formObj = document.form;
        if (dgStatus == "Y") {
        	$("#btn_t2SendDgEdiRequest").text("Send DG Cancel EDI");
        	ComBtnEnable("btn_t2SendDgEdiRequest");
        	//ComBtnDisable("btn_t2SendDgEmlRequest");
        	$("#btn_t2SendDgEmlRequest").hide();
        }else {
            $("#btn_t2SendDgEdiRequest").text("Send DG EDI");
        	ComBtnEnable("btn_t2SendDgEdiRequest");
        	//ComBtnEnable("btn_t2SendDgEmlRequest");
        	$("#btn_t2SendDgEmlRequest").show();
        }
    }
    
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }
    
    /**
     * sending request mail
     */
    function sendReqMail(sheetObj, Row, formObj) {      	
    	if(Row == -1) {
  			//ComShowCodeMessage("SCG50034");	//'Please use after Retrieve.'
  			return;
  		} else {  		  	
  			var crr_cd=sheetObj.GetCellValue(Row, "crr_cd");
  			var bkg_ref_no=sheetObj.GetCellValue(Row, "booking_no");
  			var spcl_cgo_rqst_seq=sheetObj.GetCellValue(Row, "spcl_cgo_rqst_seq");
  			var spcl_cgo_apro_rqst_seq=sheetObj.GetCellValue(Row, "spcl_cgo_apro_rqst_seq");
  			var vsl_pre_pst_cd=sheetObj.GetCellValue(Row, "vsl_pre_pst_cd");
  			var vsl_seq=sheetObj.GetCellValue(Row, "vsl_seq");
  			var slan_cd=sheetObj.GetCellValue(Row, "slan_cd");
  			var rgn_shp_opr_cd=sheetObj.GetCellValue(Row, "rgn_shp_opr_cd");
		  	var rgn_shp_opr_cd= comboObjects[0].GetSelectCode();
		  	var scg_flg="SS";
		  	var send_type="0";
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

		  	ComScgSendMail(sheetObj, formObj, mailObj, true, "VOP_SCG_0014GS.do", "authPending()");
  		}
    }
    function authPending() {
    	
		 var bkgNo=sheetObjects[5].GetCellText(sheetObjects[5].GetSelectRow(), "bkg_no");
		 var befVVD=sheetObjects[5].GetCellText(sheetObjects[5].GetSelectRow(), "vsl_cd") +
		            sheetObjects[5].GetCellText(sheetObjects[5].GetSelectRow(), "skd_voy_no") +
		            sheetObjects[5].GetCellText(sheetObjects[5].GetSelectRow(), "skd_dir_cd");
		 
		 var polCd=sheetObjects[5].GetCellText(sheetObjects[5].GetSelectRow(), "pol_cd");
		 var podCd=sheetObjects[5].GetCellText(sheetObjects[5].GetSelectRow(), "pod_cd");
		 
		 for (var i=2; i <= sheetObjects[5].LastRow(); i ++)
		 {
			 if (bkgNo == sheetObjects[5].GetCellText(i, "bkg_no") && befVVD == sheetObjects[5].GetCellText(i, "vsl_cd")+sheetObjects[5].GetCellText(i, "skd_voy_no")+sheetObjects[5].GetCellText(i, "skd_dir_cd") && polCd == sheetObjects[5].GetCellText(i, "pol_cd") && podCd == sheetObjects[5].GetCellText(i, "pod_cd")) {
				 sheetObjects[5].SetCellValue( i , "spcl_cgo_auth_cd","P");	 
			 }
		 }
		 
    }