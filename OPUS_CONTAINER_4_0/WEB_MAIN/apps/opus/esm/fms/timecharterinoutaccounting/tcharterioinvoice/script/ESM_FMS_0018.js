/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0018.js
*@FileTitle  : Owner’s Account
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Ship Yard Select ? Pop up : Ship Yard Select ? Pop up definition of biz script for creation screen
     */

    // common global variables 
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_Retrieve":
		            if(!initConfirm()) return;
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
			 		break;
            	case "btn_autoFilter":
		            if(!initConfirm()) return;
					doActionIBSheet(sheetObject,formObject,IBSEARCH, "autoFilter");
			 		break;
    			case "btn_new":
    				if(!initConfirm()) return;
    		 		ComResetAll();
                    break;
    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
    			case "btn_saveToFile":
    				if(!initConfirm()) return;
    				if(sheetObjects[0].RowCount()== 0) {
    		 			ComShowCodeMessage("FMS00016");
    		 			return;
    		 		}
    				sheetObjects[0].SetColHidden("apply",1);
     				sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
     				sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
    				sheetObjects[0].SetColHidden("apply",0);
    				//speedDown2Excel(sheetObject, 1);
    				//speedDown2Excel(sheetObject1, 2);
                    break;
    			case "btn_effDt1":
    				var cal=new ComCalendar();
    				cal.setDisplayType('date');
					cal.select(form.eff_dt1, 'yyyy-MM-dd');
                    break;
    			case "btn_effDt2":
    				var cal=new ComCalendar();
    				cal.setDisplayType('date');
					cal.select(form.eff_dt2, 'yyyy-MM-dd');
                    break;
    			case "btn_vslPop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 470, "setVslCd", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0022");
					break;
    			case "btn_locPop":
    				ComOpenPopup("COM_ENS_051.do", 720, 430, "setLocCd", "1,0,1,1,1", false, false, null, null, null, "com_ens_051");
					break;
    			case "btn_vslCdClr":
     				form.vsl_cd.value="";
     				form.vsl_eng_nm.value="";
     				break;
     			case "btn_locCdClr":
     				form.loc_cd.value="";
     				form.loc_nm.value="";
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
        for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
    	initControl();
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * adding first-served functions after loading screen.
     */
    	 function sheet_OnLoadFinish(sheetObj) { 
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * adding first-served functions after loading screen.
     */
	 function sheet1_OnLoadFinish(sheetObj) { 
    	sheetObj.SetWaitImageVisible(0);
        doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
		sheetObj.SetWaitImageVisible(1);
    }
   /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObj){
           
                var HeadTitle="|Seq|Match|Type|VVD Cd|USD|Amount|LCL|Amount|Original Slip No.|Description|Eff. date|Ex. Rate|Acct code|Cntr code|Approval|Manhour|Apply||||||||||";
                var headCount=ComCountHeadTitle(HeadTitle);
                cnt=0;

                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ 
                     {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					{Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"stl_flg" },
					{Type:"Combo",     Hidden:0, Width:89,   Align:"Center",  ColMerge:0,   SaveName:"flet_ppay_rlt_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
					{Type:"Text",      Hidden:0,  Width:83,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Float",     Hidden:0,  Width:89,   Align:"Right",   ColMerge:1,   SaveName:"n1st_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Float",     Hidden:0,  Width:89,   Align:"Right",   ColMerge:0,   SaveName:"n2nd_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"org_slp_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:215,  Align:"Left",    ColMerge:0,   SaveName:"ap_desc",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:250 },
					{Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Float",     Hidden:0,  Width:52,   Align:"Right",   ColMerge:0,   SaveName:"act_xch_rt_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"apro_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"man_hr_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Image",     Hidden:0, Width:66,   Align:"Center",  ColMerge:1,   SaveName:"apply",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_func_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_team_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_iss_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_ser_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_seq_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

					InitColumns(cols);
					SetSheetHeight(320);
					SetEditable(1);
					SetImageList(0,"img/btn_apply.gif");
            			}


    			break;
    		case 2:      //t1sheet1 init
    		      with(sheetObj){
             var HeadTitle="|Seq|Match|Type|VVD Cd|USD|Amount|LCL|Amount|Original Slip No.|Description|Eff. date|Ex. Rate|Acct code|Cntr code|Approval|Manhour||||||||||";
             var headCount=ComCountHeadTitle(HeadTitle);
             (headCount, 10, 0, true);
             cnt=0;
             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"stl_flg" },
                 {Type:"Combo",     Hidden:0, Width:89,   Align:"Center",  ColMerge:0,   SaveName:"flet_ppay_rlt_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:83,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:89,   Align:"Right",   ColMerge:1,   SaveName:"n1st_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n2nd_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:89,   Align:"Right",   ColMerge:0,   SaveName:"n2nd_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"org_slp_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:215,  Align:"Left",    ColMerge:0,   SaveName:"ap_desc",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:250 },
                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:52,   Align:"Right",   ColMerge:0,   SaveName:"act_xch_rt_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"apro_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"man_hr_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_func_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_team_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_iss_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_ser_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"slp_seq_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);
             SetSheetHeight(140);
             SetEditable(1);
                      }
               break;
        }
    }
   /**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
 	function initControl() {
 		DATE_SEPARATOR="-";
 		//Axon Event Handling1. Event Catch
 		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form); 	//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
 		axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form); 	//- form Code Handling to onkeypress Event of All Controls having dataformat attribute
 		axon_event.addListener  ('keypress', 'engnum_keypress', 'loc_cd'); //loc_cd by engnum_press
        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); // Input only Upper case English or Numeric when inserting Veesel Code
 		axon_event.addListenerForm  ('keypress'        , 'eng_keypress'  , form); 	//- form Code Handling to onkeypress Event of All Controls
 		axon_event.addListenerForm  ('change'          , 'obj_change'    , form); 	//- form Code Handling to OnChange Event of All Controls
 		axon_event.addListenerFormat('focus'           , 'obj_activate'  , form);
 	}
    /**
     * Handling IBSheet's process<br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction,objNm,row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:     
        		if(objNm == "vsl_cd") {
        			formObj.f_cmd.value=SEARCH01;
     	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", FormQueryString(formObj));
    	   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
    	   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
    	   				formObj.vsl_eng_nm.value=vslEngNm;
    	   				form.btn_vslCdClr.checked=true;
    				} else {
    					form.btn_vslCdClr.checked=false;
    					formObj.vsl_cd.value="";
    					ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
    					return;
    				}
        		} else if(objNm == "loc_cd") {
        			formObj.f_cmd.value=SEARCH03;
     	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", FormQueryString(formObj));
    	   			var locNm=ComGetEtcData(sXml, "locNm");
    	   			if(typeof locNm != "undefined" && locNm != "" ) {
    	   				formObj.loc_nm.value=locNm;
    	   				form.btn_locCdClr.checked=true;
    				} else {
    					form.btn_locCdClr.checked=false;
    					formObj.loc_cd.value="";
    					ComAlertFocus(formObj.loc_cd, ComGetMsg("FMS00006", "KK Code"));
    					return;
    				}
        		} else {
        			if(validateForm(sheetObj,formObj,sAction,objNm)) {
        				if(objNm == "autoFilter") {
        					formObj.f_cmd.value=SEARCH01;
        					formObj.searchType.value="A";
        				} else {
        					formObj.f_cmd.value=SEARCH;
        					formObj.searchType.value="S";
        				}
 						var sXml=sheetObj.GetSearchData("ESM_FMS_0018GS.do", FormQueryString(formObj));
	       	   	  		var arrXml=sXml.split("|$$|");
	       	   	  		if (arrXml.length > 0) {
	       	   	  			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	       	   	  		}
	       	   	  		if (arrXml.length > 1) {
	       	   	  			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
	       	   	  		} else {
	       	   	  			sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
	       	   	  		}
	       	   	  		setCellEditable(sheetObjects[0]);
	       	   	  		setCellEditable(sheetObjects[1]);
        			}
        		}
        		break;
        	case IBSAVE:        
	        	if(validateForm(sheetObj,formObj,sAction)) {
		        	formObj.f_cmd.value=MULTI;
			  	  	var sParam="";
			  	  	var sParamSheet1=sheetObjects[0].GetSaveString();
			  	  	var sParamSheet2=sheetObjects[1].GetSaveString();
				  	sParam += FormQueryString(formObj) + "&" + sParamSheet1 + "&" + sParamSheet2;
 				  	var sXml=sheetObj.GetSaveData("ESM_FMS_0018GS.do", sParam);
				  	var arrXml=sXml.split("|$$|");
				  	if (arrXml.length > 0) {
 				  		sheetObjects[0].LoadSaveData(arrXml[0]);
				  	}
				  	if (arrXml.length > 1) {
 				  		sheetObjects[1].LoadSaveData(arrXml[1]);
				  	} else {
 				  		sheetObjects[1].LoadSaveData(arrXml[0]);
				  	}
				  	setImageButton(sheetObj);
				  	form.plusSum.value="0";
				  	form.minusSum.value="0";
				  	setCellEditable(sheetObjects[0]);
				  	setCellEditable(sheetObjects[1]);
	        	}
    			break;
        	case IBROWSEARCH:  
	   			CoFmsGetCombo("GRID", formObj, sheetObj, "CD01751", "flet_ppay_rlt_cd", "flet_ppay_rlt_cdText", "Y");
    			break;
        }
    }
    /**
     * Checking Validation of Effective Date in onblur Event of HTML Control<br>
     **/
    function obj_deactivate(){
    	if((ComGetEvent("name") == "effDt1") ||
    	   (ComGetEvent("name") == "effDt2")) {
    		ComChkObjValid(event.srcElement);
    	} else {
    		ComChkObjValid(event.srcElement);
    	}
    }
    /**
     * Only insert Numeric by onkeypress Event of HTML Control<br>
     **/
//    function obj_keypress(){
//    	switch(event.srcElement.dataformat){
//			case "int":
//		        ComKeyOnlyNumber(event.srcElement);
//				break;
//			case "float":
//		        ComKeyOnlyNumber(event.srcElement, ".");
//				break;
//			default:
//		        ComKeyOnlyNumber(event.srcElement);
//    	}
//    }
    /**
     * Only insert English and Numefic by onkeypress Event of HTML Control<br>
     **/
    function eng_keypress() {
		ComKeyOnlyAlphabet('upper');
    }
     /**
      * Only insert English/Numeric by onkeypress Event of HTML Control <br>
      **/
     function engnum_keypress() {
         ComKeyOnlyAlphabet('uppernum');
     } 
    /**
     * Checking Validation when Vessel Code, Location is changed in onchange Event of HTML Control<br>
     **/
    function obj_change() {
    	if((ComGetEvent("name") == "vsl_cd")) {
    		form.vsl_eng_nm.value="";
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
    	} else if((ComGetEvent("name") == "loc_cd")) { 
    		form.loc_nm.value="";
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"loc_cd");
     	}
    }
    /**
     * Checking VVD Code's Validation
     */
    function checkVvdCode(sheetObj, formObj, row) {
    	formObj.f_cmd.value=SEARCH06;
    	var vvdCd=sheetObj.GetCellValue(row, "vvd_cd");
		if(vvdCd.trim() == "") {
			// VVD Code is Madatory Field 
			ComShowCodeMessage("FMS00004", "VVD Code");
			sheetObj.SelectCell(row,"vvd_cd");
			return false;
		}
 		var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do?vvd_cd="+vvdCd, FormQueryString(formObj));
		if(CoFmsShowXmlMessage(sXml) != "") {
			sheetObj.SetCellValue(row,"vvd_cd"," ",0);
			//sheetObj.CellValue2(row,"vvd_cd1") = " ";
			alert(CoFmsShowXmlMessage(sXml));
			sheetObj.SelectCell(row,"vvd_cd");
			return false;
		}
		return true;
    }
    /**
     * Checking Description insert<br>
     */
    function checkApDesc(sheetObj, formObj, row) {
    	var apDesc=sheetObj.GetCellValue(row, "ap_desc");
		if(apDesc.trim() == "") {
			sheetObj.SetCellValue(row,"ap_desc"," ");
			// Description is Mandatory Field
			ComShowCodeMessage("FMS00004", "Description");
			sheetObj.SelectCell(row,"ap_desc");
			return false;
		}
		return true;
    }
    /**
     * Checking VVD Code and Description insert<br>
     */
    function checkCell(sheetObj, formObj) {
    	var ibflag;
    	for(var row=1; row<=sheetObj.LastRow(); row++) {
    		ibflag=sheetObj.GetCellValue(row, "ibflag");
			if(ibflag == "U") {
				if(!checkApDesc(sheetObj, formObj, row)) {
					return false;
				}
				if(!checkVvdCode(sheetObj, formObj, row)) {
					return false;
				}
			}
		}
    	return true;
    }
    /**
     * Checking Validation about screen form input value <br>
     */
    function validateForm(sheetObj,formObj,sAction,objNm){
        if(sAction == IBSAVE) {
        	if((sheetObjects[0].IsDataModified()== false)&& (sheetObjects[1].IsDataModified()== false)) {
        		ComShowCodeMessage("FMS00007");
	     		return false;
        	}
	     	if((formObj.plusSum.value.replace(/,/,'')*1) != (formObj.minusSum.value.replace(/,/,'')*-1)) {
	     		ComShowCodeMessage("FMS01149");
	     		return false;
	     	}
	    	if(!checkCell(sheetObjects[0], formObj)) {
	     		return false;
	     	}
	     	if(!checkCell(sheetObjects[1], formObj)) {
	     		return false;
	     	}
    	 } else {
	    	if (!ComChkValid(formObj)) return false;
	    	if(objNm == "autoFilter") {
	    		if(formObj.vsl_cd.value == "") {
	    			// Vessel Code is Mandatory Field
	    			ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00004", "Vessel Code"));
	    			return false;
	    		}
	    	}
    	 }
         return true;
    }
    /**
	 * Setting Vessel information selected in Vessel Code PopUp into Form Item<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		form.btn_vslCdClr.checked=true;
	}
    /**
	 * Setting Location information selected in Location Code PopUp into Form Item <br>
	 * @param {arry} aryPopupData
	 */
	function setLocCd(aryPopupData) {
		form.loc_cd.value=aryPopupData[0][3];
		form.loc_nm.value=aryPopupData[0][4];
		form.btn_locCdClr.checked=true;
	}
    /**
     * Checking Continueing when changed data is existing <br>
     **/
    function initConfirm() {
    	var okYn=true;
    	if(sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
    		okYn=ComShowCodeConfirm("FMS00002");
    	}
    	return okYn;
    }
    /**
     * Insert Image into Sheet and Changing Font of VVD, Original Slip No<br>
     */
    function setImageButton(sheetObj) {
        for(var row=1; row<=sheetObj.LastRow(); row++) {
        	sheetObj.SetCellImage(row,"apply",0);
 			sheetObj.SetCellFont("FontName", row, "vvd_cd","Courier New");
 			sheetObj.SetCellFont("FontName", row, "org_slp_no","Courier New");
    	}
    }
    /**
     * Applying Apply image Button when OnSearchEnd Event in Sheet is occurred <br>
     */
    function sheet_OnSearchEnd(sheetObj, ErrMsg) {
    	setImageButton(sheetObj)
    	form.plusSum.value="0";
 	}
    /**
     * Changing Font of VVD CD, Original Slip No. when OnSearchEnd Event is occurred<br>
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 form.minusSum.value="0";
    	 for(var row=1; row<=sheetObj.LastRow(); row++) {
   			sheetObj.SetCellFont("FontName", row, "vvd_cd","Courier New");
   			sheetObj.SetCellFont("FontName", row, "org_slp_no","Courier New");
      	}
 	}
    /**
     * Getting total Amount of Sheet<br>
     */
    function setPlusSum(sheetObj, row) {
    	var plusSum=0;
    	if(sheetObj.GetCellValue(row, "stl_flg") == "1") {
    		plusSum=form.plusSum.value.replace(/,/g,'')*1 + sheetObj.GetCellValue(row, "n1st_amt")*1;
    	} else {
    		plusSum=form.plusSum.value.replace(/,/g,'')*1 - sheetObj.GetCellValue(row, "n1st_amt")*1;
    	}
    	form.plusSum.value=ComAddComma(CoFmsRound(plusSum, 2));
    }
    /**
     * Getting total Amount of Sheet1 <br>
     */
    function setMinusSum(sheetObj, row) {
    	var minusSum=0;
    	if(sheetObj.GetCellValue(row, "stl_flg") == "1") {
    		minusSum=form.minusSum.value.replace(/,/g,'')*1 + sheetObj.GetCellValue(row, "n1st_amt")*1;
    	} else {
    		minusSum=form.minusSum.value.replace(/,/g,'')*1 - sheetObj.GetCellValue(row, "n1st_amt")*1;
    	}
    	form.minusSum.value=ComAddComma(CoFmsRound(minusSum, 2));
    }
    /**
     * When OnChange Event is occurred, Checking Validation of VVD Code and Setting activation state of type by Check of Match<br>
     */
    function sheet_OnChange(sheetObj, row, col, value) {
    	if(col == 4) {
    		var vvdCd=sheetObj.GetCellValue(row, "vvd_cd");
     		if(vvdCd.trim() != "") {
     			if(!checkVvdCode(sheetObj, this.form, row)) {
     				return;
     			}
     		}
     	}
    	// 1. Setting activation state of type by Check of Match
    	// 2. Getting total Amount of Checked Match
     	if(col == 2) {
     		if(sheetObj.GetCellValue(row, "stl_flg") == 1) {
        		sheetObj.SetCellValue(row, "flet_ppay_rlt_cd","",0);
        	}
        	setPlusSum(sheetObj, row);
        	setCellEditable2(sheetObj, row);
        }
        if(col == 3) {
        	if(sheetObj.GetCellValue(row, "flet_ppay_rlt_cd") != "") {
        		sheetObj.SetCellValue(row, "stl_flg",0,0);
        	}
        }
    }
    /**
     * Checking Validation of VVD code when OnChange Event of Sheet1 is occured<br>
     */
    function sheet1_OnChange(sheetObj, row, col, value) {
    	if(col == 4) {
    		var vvdCd=sheetObj.GetCellValue(row, "vvd_cd");
    		if(vvdCd.trim() != "") {
    			checkVvdCode(sheetObj, this.form, row);
    		}
     	} 
        if(col == 2) {
        	if(sheetObj.GetCellValue(row, "stl_flg") == 1) {
        		sheetObj.SetCellValue(row, "flet_ppay_rlt_cd","",0);
        	}
        	setMinusSum(sheetObj, row);
        	setCellEditable2(sheetObj, row);
        }
        if(col == 3) {
        	if(sheetObj.GetCellValue(row, "flet_ppay_rlt_cd") != "") {
        		sheetObj.SetCellValue(row, "stl_flg",0,0);
        	}
        }
    }
    /**
     * When OnClick Event of Sheet is occurred, Launching Manhour List PopUp in case FMS Approval = 'N'<br>
     */
    function sheet_OnClick(sheetObj, row, col, value) {
    	 if(col == 17) {
    		 if(sheetObj.GetCellValue(row, "apro_flg") == "N") {
    			 if(   sheetObj.GetCellValue(row, "stl_flg") == 0
    					 && sheetObj.GetCellValue(row, "flet_ppay_rlt_cd") == "O") {
    				 var slpTpCd=sheetObj.GetCellValue(row, "slp_tp_cd");
					var slpFuncCd=sheetObj.GetCellValue(row, "slp_func_cd");
					var slpTeamCd=sheetObj.GetCellValue(row, "slp_team_cd");
					var slpIssDt=sheetObj.GetCellValue(row, "slp_iss_dt");
					var slpSerNo=sheetObj.GetCellValue(row, "slp_ser_no");
					var slpSeqNo=sheetObj.GetCellValue(row, "slp_seq_no");
					var orgSlpNo=sheetObj.GetCellValue(row, "org_slp_no");
					var vvdCd=sheetObj.GetCellValue(row, "vvd_cd");
					var effDt=sheetObj.GetCellValue(row, "eff_dt");
					var apDesc=sheetObj.GetCellValue(row, "ap_desc");
		    		 var param="?slpTpCd=" + slpTpCd + "&slpFuncCd=" + slpFuncCd +
		    		 			 "&slpTeamCd=" + slpTeamCd + "&slpIssDt=" + slpIssDt +
		    		 			 "&slpSerNo=" + slpSerNo + "&slpSeqNo=" + slpSeqNo +
		    		 			 "&orgSlpNo=" + orgSlpNo + "&vvdCd=" + vvdCd +
		    		 			 "&effDt=" + effDt + "&apDesc=" + apDesc;
		    		 ComOpenWindowCenter("ESM_FMS_0007.do" + param, "ESM_FMS_0007", 1024, 495);
    			 }
    		 }
    	 }
    }
    /**
     * When OnClick Event of Sheet1 is occurred, Launching Manhour List PopUp in case FMS Approval = 'N' <br>
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
    	if(col == 2) {
if(sheetObj.GetCellValue(row, "apro_flg") == "N") {
	   			 setCellEditable2(sheetObj, row);
	   		 }
    	}
    }
    /**
     * When OnMouseMove Event of Sheet is occurred, Changing shape of mouse cursor to Default in case FMS Approval = 'Y' <br>
     */
    function sheet_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    	if(sheetObj.MouseCol()== 17) {
    		if(sheetObj.GetCellValue(sheetObj.MouseRow(), "apro_flg") == "N") {
    			if(sheetObj.GetCellValue(sheetObj.MouseRow(), "stl_flg") == 1) {
    				sheetObj.SetDataLinkMouse("apply",0);
    			} else {
    				if(sheetObj.GetCellValue(sheetObj.MouseRow(), "flet_ppay_rlt_cd") == "O") {
    					sheetObj.SetDataLinkMouse("apply",1);
    				} else {
    					sheetObj.SetDataLinkMouse("apply",0);
    				}
    			}
    		} else {
    			sheetObj.SetDataLinkMouse("apply",0);
    		}
    	} else {
    		sheetObj.SetDataLinkMouse("apply",0);
    	}
    }
    /**
     * When OnBeforeEdit Event of Sheet is occurred, Removing Space before Editing in case Description is just Space <br>
     */
    function sheet_OnBeforeEdit(sheetObj,row,col) {
    	if(col == 3) {
    		if (sheetObj.GetCellValue(row,"ap_desc") == " ") {
    		    sheetObj.SetCellValue(row,"ap_desc","");
    		}
    	}
        if(col == 4) {
        	if (sheetObj.GetCellValue(row,"vvd_cd") == " ") {
    		    sheetObj.SetCellValue(row,"vvd_cd","");
    		}
    	}
    }
    /**
     * When OnAfterEdit Event of Sheet is occurred, Setting Space temporary as sheet can be broken in case Description has no data <br>
     */
    function sheet_OnAfterEdit(sheetObj,row,col) {
    	if(col == 3) {
    		if (sheetObj.GetCellValue(row,"ap_desc") == "") {
    	    	sheetObj.SetCellValue(row,"ap_desc"," ",0);
    		}
    	}
    	if(col == 4) {
    		if (sheetObj.GetCellValue(row,"vvd_cd") == "") {
    	    	sheetObj.SetCellValue(row,"vvd_cd"," ",0);
    		}
    	}
    }
    /**
     * When OnBeforeEdit Event of Sheet1 is occurred, Removing Space before Editing in case Description is just Space<br>
     */
    function sheet1_OnBeforeEdit(sheetObj,row,col) {
    	if(col == 3) {
    		if (sheetObj.GetCellValue(row,"ap_desc") == " ") {
    		    sheetObj.SetCellValue(row,"ap_desc","");
    		}
    	}
        if(col == 4) {
        	if (sheetObj.GetCellValue(row,"vvd_cd") == " ") {
    		    sheetObj.SetCellValue(row,"vvd_cd","");
    		}
    	}
    }
    /**
     * When OnAfterEdit Event of Sheet1 is occurred, Setting Space temporary as sheet can be broken in case Description has no data<br>
     */
    function sheet1_OnAfterEdit(sheetObj,row,col) {
    	if(col == 3) {
    		if (sheetObj.GetCellValue(row,"ap_desc") == "") {
    	    	sheetObj.SetCellValue(row,"ap_desc"," ",0);
    		}
    	}
    	if(col == 4) {
    		if (sheetObj.GetCellValue(row,"vvd_cd") == "") {
    	    	sheetObj.SetCellValue(row,"vvd_cd"," ",0);
    		}
    	}
    }
    /**
     * Prevent Modifying in case csr_slp_flg(apro_flg) = 'Y'
     */
    function setCellEditable(sheetObj) {
    	for(var i=1; i<=sheetObj.LastRow(); i++) {
    		if(sheetObj.GetCellValue(i, "apro_flg") == "Y") {
     			sheetObj.SetCellEditable(i, "stl_flg",0);
     			sheetObj.SetCellEditable(i, "flet_ppay_rlt_cd",0);
     			sheetObj.SetCellEditable(i, "ap_desc",0);
     			sheetObj.SetCellEditable(i, "vvd_cd",0);
     		} else {
     			setCellEditable2(sheetObj, i);
     		}
     	}
    }
    /**
     * Inserting data into temporary Sheet to Excel print 2Row as 1Row <br>
     */
    function speedDown2Excel(sheetObj, sheetNo) {
    	if(sheetObjects[0].RowCount()== 0) {
 			ComShowCodeMessage("FMS00016");
 			return;
 		}
    	var targetSheetObj;
    	if(sheetNo == 1) {
    		targetSheetObj=sheetObjects[2];
    	} else if(sheetNo == 2) {
    		targetSheetObj=sheetObjects[3];
    	}
    	for(var i=2; i<=sheetObj.LastRow(); i+=2) {
    		var row=targetSheetObj.DataInsert();
    		if(sheetObj.GetCellValue(i,"stl_flg") == 1) {
    			targetSheetObj.SetCellValue(row,"stl_flg","Y",0);
    		} else {
    			targetSheetObj.SetCellValue(row,"stl_flg","N",0);
    		}
    		targetSheetObj.SetCellText(row,"flet_ppay_rlt_cd" ,sheetObj.GetCellText(i,"flet_ppay_rlt_cd"));
    		targetSheetObj.SetCellValue(row,"acct_cd",sheetObj.GetCellValue(i,"acct_cd"),0);
			targetSheetObj.SetCellValue(row,"ctr_cd",sheetObj.GetCellValue(i,"ctr_cd"),0);
			targetSheetObj.SetCellValue(row,"eff_dt",sheetObj.GetCellValue(i,"eff_dt"),0);
			targetSheetObj.SetCellValue(row,"n1st_curr_cd",sheetObj.GetCellValue(i,"n1st_curr_cd"),0);
			targetSheetObj.SetCellValue(row,"n1st_amt",sheetObj.GetCellValue(i,"n1st_amt"),0);
			targetSheetObj.SetCellValue(row,"n2nd_curr_cd",sheetObj.GetCellValue(i,"n2nd_curr_cd"),0);
			targetSheetObj.SetCellValue(row,"n2nd_amt",sheetObj.GetCellValue(i,"n2nd_amt"),0);
			targetSheetObj.SetCellValue(row,"act_xch_rt_amt",sheetObj.GetCellValue(i,"act_xch_rt_amt"),0);
			targetSheetObj.SetCellValue(row,"apro_flg",sheetObj.GetCellValue(i,"apro_flg"),0);
			targetSheetObj.SetCellValue(row,"ap_desc",sheetObj.GetCellValue(i+1,"ap_desc"),0);
			targetSheetObj.SetCellValue(row,"vvd_cd",sheetObj.GetCellValue(i+1,"vvd_cd"),0);
			targetSheetObj.SetCellValue(row,"org_slp_no",sheetObj.GetCellValue(i+1,"org_slp_no"),0);
			targetSheetObj.SetCellValue(row,"man_hr_flg",sheetObj.GetCellValue(i+1,"man_hr_flg"),0);
    	}
     	targetSheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(targetSheetObj), SheetDesign:1,Merge:1 });
    	targetSheetObj.RemoveAll();
    }
    /**
     * Setting Activation of Type, Description, VVD Code by Check of Match <br>
     */
    function setCellEditable2(sheetObj, row) {
    	if(sheetObj.GetCellValue(row, "stl_flg") == "1") {
		 	sheetObj.SetCellEditable(row, "flet_ppay_rlt_cd",0);
  			sheetObj.SetCellEditable(row, "ap_desc",0);
  			sheetObj.SetCellEditable(row, "vvd_cd",0);
		 } else {
			sheetObj.SetCellEditable(row, "flet_ppay_rlt_cd",1);
   			sheetObj.SetCellEditable(row, "ap_desc",1);
   			sheetObj.SetCellEditable(row, "vvd_cd",1);
		 }
    }
    /**
     * Removing Mask Separator in onfocus Event of HTML Control<br>
     */
    function obj_activate() {
        ComClearSeparator(ComGetEvent());
    }
    /**
     * Setting scroll position of sheet2 as saem when OnScroll Event is occurred <br>
     */
  	 function sheet_OnScroll(sheetObj, olGetTopRow, oldLeftCol, newGetTopRow, newLeftCol) {
    	sheetObjects[1].SetHighLeftCol(newGetHighLeftCol());
    }
    /**
     * Setting scroll position of sheet2 as saem when OnScroll Event is occurred <br>
     */
    	 function sheet1_OnScroll(sheetObj, olGetTopRow, oldLeftCol, newGetTopRow, newLeftCol) {
    	sheetObjects[0].SetHighLeftCol(newGetHighLeftCol());
    }
