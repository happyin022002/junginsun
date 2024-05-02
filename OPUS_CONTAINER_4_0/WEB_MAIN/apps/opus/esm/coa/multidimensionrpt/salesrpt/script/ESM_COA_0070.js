/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0070.js
*@FileTitle  : Weekly Sales Report By Office 1
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheetNo=1;
var baseHeight=11;
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var TmrID;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var sheet_height=250; 		// sheet height : SJH.20141230.ADD
/* Event handler processing by button click event */
document.onclick=processButtonClick;
    /**
     * Event handler processing by button name
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
    				if(tabObjects[0].GetSelectedIndex()==0){
                       doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    				}else if(tabObjects[0].GetSelectedIndex()==1){
                       doActionIBSheet2(sheetObject3,formObject,IBSEARCH);
    				}
                    break;
                case "btn_downexcel":
                	//SJH.20150109.MOD
    				if(tabObjects[0].GetSelectedIndex()==0){
                    	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
     				} else {
                    	doActionIBSheet2(sheetObject3,formObject,IBDOWNEXCEL);
     				}
                    break;
                case "btn_new":
                    sheet1.RemoveAll();
                    sheet2.RemoveAll();
                    sheet3.RemoveAll();
                    sheet4.RemoveAll();
                    formObject.reset();
                    //20150709.ADD
                    doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
            		for (k=0; k < comboObjects.length; k++) {
            			initCombo(comboObjects[k], k+1);
            		}                    
                    break;
                case "bu_zoom_in1": //SJH.20141230.MOD
                	getToggleSheetHeight(sheet1, (sheetObject1.GetSheetHeight(sheet_height) * 2), div_zoom_in1, div_zoom_out1, "none", "inline", "0");
                    break;
                case "bu_zoom_in2": //SJH.20141230.MOD
                	getToggleSheetHeight(sheet2, (sheetObject2.GetSheetHeight(sheet_height) * 2), div_zoom_in2, div_zoom_out2, "none", "inline", "0");
                    break;
                case "bu_zoom_in3": //SJH.20141230.MOD
                	getToggleSheetHeight(sheet3, (sheetObject3.GetSheetHeight(sheet_height) * 2), div_zoom_in3, div_zoom_out3, "none", "inline", "0");
                    break;
                case "bu_zoom_in4": //SJH.20141230.MOD
                	getToggleSheetHeight(sheet4, (sheetObject4.GetSheetHeight(sheet_height) * 2), div_zoom_in4, div_zoom_out4, "none", "inline", "0");
                    break;                    
                case "bu_zoom_out1": //SJH.20141230.MOD
                	getToggleSheetHeight(sheet1, sheet_height, div_zoom_in1, div_zoom_out1, "inline", "none", "0");
                    break;
                case "bu_zoom_out2": //SJH.20141230.MOD
                	getToggleSheetHeight(sheet2, sheet_height, div_zoom_in2, div_zoom_out2, "inline", "none", "0");
                    break;
                case "bu_zoom_out3": //SJH.20141230.MOD
                	getToggleSheetHeight(sheet3, sheet_height, div_zoom_in3, div_zoom_out3, "inline", "none", "0");
                    break;
                case "bu_zoom_out4": //SJH.20141230.MOD
                	getToggleSheetHeight(sheet4, sheet_height, div_zoom_in4, div_zoom_out4, "inline", "none", "0");
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
			* initializing sheet
			* implementing onLoad event handler in body tag
			* adding first-served functions after loading screen.
     */
	function loadPage() {
    	 var formObject=document.form; 
		loadingMode=true;
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);	
		//SJH.20140904.MOD
		for (k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k+1);
		}		
		for (i=0; i < sheetObjects.length; i++) {
			//Sheet configuration setting function(start)
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// Sheet configuration setting function(end)
			ComEndConfigSheet(sheetObjects[i]);
		}
		//viewSheet();
		for (k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
			tabObjects[k].SetSelectedIndex(0);			//SJH.20140904.ADD
		}
		loadingMode=false;
	}
     /**
     * Multi-combo handling
		 * initializing Tab
		 * setting Tab items
     */
	function initCombo(comboObj, comboNo) {
		with (comboObj) {
			SetDropHeight(300);
			ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
			comboObj.SetSelectIndex(0);					//SJH.20140904.ADD			
		}
	} 
    /**
		* setting sheet initial values and header
		* param : sheetObj, sheetNo
		* adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var header=" | ";
        var suffix1="";
        var suffix2="";
        var perfix="Seq.";
        var label1="";
        var formObj=document.form;
        var currWeek="";
        var prevWeek=formObj.f_pre_week.value;
        var rptItem=f_rpt_item.GetSelectCode();
        var tCnt=0;
        var saveNM1="";
        var saveNM2="";
        var saveCD="";
        var tmpCD="";
        var tmpSZ="";
        var colSize=""; 
		if(tabObjects[0].GetSelectedIndex()==0){
           currWeek=formObj.f_wk.value;
		}else if(tabObjects[0].GetSelectedIndex()==1){
           currWeek=formObj.f_fm_wk.value;
		}
        // Header entries are changed when the report select-box changing
        //----------------------------------------------------------------------
        if(rptItem == "T"){        	
            if(formObj.f_ofc_sts.checked){
                 saveNM1=saveNM1 + "Office|Office|";
                 saveNM2=saveNM2 + "Level1|Level2|";
                 tmpCD=tmpCD   + "ofc_lvl1|ofc_lvl2|";
                 tmpSZ=tmpSZ   + "50|50|";
            }
            saveNM1=saveNM1 + "Trade|";
            saveNM2=saveNM2 + "Trade|";
            tmpCD=tmpCD   + "trd_cd|";
            tmpSZ=tmpSZ   + "50|";
            if(formObj.f_dir_sts.checked) {
                saveNM1=saveNM1 + "Bound|";
                saveNM2=saveNM2 + "Bound|";
                tmpCD=tmpCD   + "dir_cd|";
                tmpSZ=tmpSZ   + "50|";
            }
            if(tabObjects[0].GetSelectedIndex()==1 & formObj.f_wk_sts.checked) {
                saveNM1=saveNM1 + "Week|";
                saveNM2=saveNM2 + "Week|";
                tmpCD=tmpCD   + "wk_sts|";
                tmpSZ=tmpSZ   + "50|";
            }
            saveCD=tmpCD.split("|");
            colSize=tmpSZ.split("|");
            tCnt=saveCD.length-1;
        } else if(rptItem == "S") {
            if(formObj.f_ofc_sts.checked){
                 saveNM1=saveNM1 + "Office|Office|";
                 saveNM2=saveNM2 + "Level1|Level2|";
                 tmpCD=tmpCD   + "ofc_lvl1|ofc_lvl2|";
                 tmpSZ=tmpSZ   + "50|50|";
            }
            saveNM1=saveNM1 + "Trade|Sub-Trade|";
            saveNM2=saveNM2 + "Trade|Sub-Trade|";
            tmpCD=tmpCD   + "trd_cd|sub_trd_cd|";
            tmpSZ=tmpSZ   + "50|70|";
            if(formObj.f_dir_sts.checked) {
                saveNM1=saveNM1 + "Bound|";
                saveNM2=saveNM2 + "Bound|";
                tmpCD=tmpCD   + "dir_cd|";
                tmpSZ=tmpSZ   + "50|";
            }
            if(tabObjects[0].GetSelectedIndex()==1 & formObj.f_wk_sts.checked) {
                saveNM1=saveNM1 + "Week|";
                saveNM2=saveNM2 + "Week|";
                tmpCD=tmpCD   + "wk_sts|";
                tmpSZ=tmpSZ   + "50|";
            }
            saveCD=tmpCD.split("|");
            colSize=tmpSZ.split("|");
            tCnt=saveCD.length-1;
        } else if(rptItem == "L") {
            if(formObj.f_ofc_sts.checked){
                 saveNM1=saveNM1 + "Office|Office|";
                 saveNM2=saveNM2 + "Level1|Level2|";
                 tmpCD=tmpCD   + "ofc_lvl1|ofc_lvl2|";
                 tmpSZ=tmpSZ   + "50|50|";
            }
            saveNM1=saveNM1 + "Trade|Sub-Trade|Lane|";
            saveNM2=saveNM2 + "Trade|Sub-Trade|Lane|";
            tmpCD=tmpCD   + "trd_cd|sub_trd_cd|rlane_cd|";
            tmpSZ=tmpSZ   + "50|70|80|";
            if(formObj.f_dir_sts.checked) {
                saveNM1=saveNM1 + "Bound|";
                saveNM2=saveNM2 + "Bound|";
                tmpCD=tmpCD   + "dir_cd|";
                tmpSZ=tmpSZ   + "50|";
            }
            if(tabObjects[0].GetSelectedIndex()==1 & formObj.f_wk_sts.checked) {
                saveNM1=saveNM1 + "Week|";
                saveNM2=saveNM2 + "Week|";
                tmpCD=tmpCD   + "cost_wk|";
                tmpSZ=tmpSZ   + "50|";
            }
            saveCD=tmpCD.split("|");
            colSize=tmpSZ.split("|");
            tCnt=saveCD.length-1;
        } else if(rptItem == "V") {
			if(tabObjects[0].GetSelectedIndex()==0){
                if(formObj.f_ofc_sts.checked){
                     saveNM1=saveNM1 + "Office|Office|";
                     saveNM2=saveNM2 + "Level1|Level2|";
                     tmpCD=tmpCD   + "ofc_lvl1|ofc_lvl2|";
                     tmpSZ=tmpSZ   + "50|50|";
                }
                saveNM1=saveNM1 + "Trade|Sub-Trade|Lane|VVD|";
                saveNM2=saveNM2 + "Trade|Sub-Trade|Lane|VVD|";
                tmpCD=tmpCD   + "trd_cd|sub_trd_cd|rlane_cd|vvd|";
                tmpSZ=tmpSZ   + "50|70|80|100|";
                if(formObj.f_dir_sts.checked) {
                    saveNM1=saveNM1 + "Bound|";
                    saveNM2=saveNM2 + "Bound|";
                    tmpCD=tmpCD   + "dir_cd|";
                    tmpSZ=tmpSZ   + "50|";
                }              
                saveCD=tmpCD.split("|");
                colSize=tmpSZ.split("|");
                tCnt=saveCD.length-1;
			}else if(tabObjects[0].GetSelectedIndex()==1){
                if(formObj.f_ofc_sts.checked){
                     saveNM1=saveNM1 + "Office|Office|";
                     saveNM2=saveNM2 + "Level1|Level2|";
                     tmpCD=tmpCD   + "ofc_lvl1|ofc_lvl2|";
                     tmpSZ=tmpSZ   + "50|50|";
                }                
                saveNM1=saveNM1 + "Week|Trade|Sub-Trade|Lane|VVD|";
                saveNM2=saveNM2 + "Week|Trade|Sub-Trade|Lane|VVD|";
                tmpCD=tmpCD   + "cost_wk|trd_cd|sub_trd_cd|rlane_cd|vvd|";
                tmpSZ=tmpSZ   + "40|50|70|80|100|";
                if(formObj.f_dir_sts.checked) {
                    saveNM1=saveNM1 + "Bound|";
                    saveNM2=saveNM2 + "Bound|";
                    tmpCD=tmpCD   + "dir_cd|";
                    tmpSZ=tmpSZ   + "50|";
                }                
                saveCD=tmpCD.split("|");
                colSize=tmpSZ.split("|");                
                tCnt=saveCD.length-1;
			}
        }
        //----------------------------------------------------------------------
        // Setting the title related week
        if(currWeek != ""){
            if(ComParseInt(currWeek.substring(1)) == 1 && (ComParseInt(currWeek)<10 ||  ComParseInt(currWeek)>20))     suffix1="st";
            else if(ComParseInt(currWeek.substring(1)) == 2 && (ComParseInt(currWeek)<10 ||  ComParseInt(currWeek)>20))suffix1="nd";
            else if(ComParseInt(currWeek.substring(1)) == 3 && (ComParseInt(currWeek)<10 ||  ComParseInt(currWeek)>20))suffix1="rd";
            else suffix1="th";
            if(ComParseInt(prevWeek.substring(5)) == 1 && (ComParseInt(prevWeek.substring(4))<10 ||  ComParseInt(prevWeek.substring(4))>20))      suffix2="st";
            else if(ComParseInt(prevWeek.substring(5)) == 2  && (ComParseInt(prevWeek.substring(4))<10 ||  ComParseInt(prevWeek.substring(4))>20))suffix2="nd";
            else if(ComParseInt(prevWeek.substring(5)) == 3  && (ComParseInt(prevWeek.substring(4))<10 ||  ComParseInt(prevWeek.substring(4))>20))suffix2="rd";
            else suffix2="th";
            header=prevWeek.substring(2,4)+"/"+prevWeek.substring(4) + suffix2 +"|"+ formObj.f_year.value.substring(2)+"/"+currWeek + suffix1;
            label1=ComParseInt(currWeek) + suffix1;
        }
        //SJH.20150109.MOD
//        document.getElementById("div_label1").innerHTML="<div id='div_label1'><b>Weekly Sales Report -</b><font color='#FF008F'>"+label1+"</font></div>";
//        document.getElementById("div_label2").innerHTML="<div id='div_label2'><b>Weekly Sales Report -</b><font color='#FF008F'>"+label1+"</font></div>";
        //----------------------------------------------------------------------
        switch(sheetNo) {
           case 1:      //sheet1 init
                with (sheetObj) {
	        	    var HeadTitle="";
	        	    var HeadTitle1="";
	        	    var fixd_cnt=0;
	        	    HeadTitle=saveNM1 + "Load|Load|Load|Freight Revenue|Freight Revenue|Freight Revenue|CM|CM|CM|RPB|RPB|RPB|CMB|CMB|CMB|BSA Capa|BSA Capa|BSA Capa|L/F(%)|L/F(%)|L/F(%)" ;
	        	    HeadTitle1=saveNM2 + header+"|Change(%)|"+header+"|Change(%)|"+header+"|Change(%)|"+header+"|Change|"+header+"|Change|"+header+"|Change|"+header+"|Change|"  ;
	        	    //fixd_cnt=21;
	        	    //(fixd_cnt + tCnt, tCnt, 0, true);             //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        	    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        	    var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	    var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
	        	    InitHeaders(headers, info);
	        	    var cols = [];
	        	    for(j=0; j<tCnt; j++){
	        	    	cols.push({Type:"Text",      Hidden:0,  Width:colSize[j],Align:"Center",  ColMerge:1,   SaveName:saveCD[j],        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	        	    }
	        	   
	        	    cols.push({Type:"AutoSum", 		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prev_load",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"curr_load",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",    	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"load_chng",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prev_rev",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"curr_rev",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",  		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rev_chng",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prev_cm",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"curr_cm",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cm_chng",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prev_rpb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"curr_rpb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",  		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rpb_chng",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prev_cmb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"curr_cmb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cmb_chng",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prev_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"curr_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",  		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"bsa_capa_chng",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prev_lf",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"curr_lf",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"lf_chng",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });

	        	    InitColumns(cols);
	        	    SetEditable(0);//Editkind[optional,Defaultfalse]
	        	    SetImageList(0,"/opuscntr/img/button/btns_positivechange.gif");
	        	    SetImageList(1,"/opuscntr/img/button/btns_negativechange.gif");
	        	    SetSheetHeight(sheet_height);		//SJH.20141230.MOD
        	    }
                break;
            case 2:      //sheet2 init
                with (sheetObj) {
	                var fixd_cnt=0;
	                fixd_cnt=12;
	                (fixd_cnt + tCnt, tCnt, 0, true);                                     //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                var HeadTitle=saveNM1 + "REV Increase/Decrease|REV Increase/Decrease|REV Increase/Decrease|Cost Increase/Decrease|Cost Increase/Decrease|Cost Increase/Decrease|Load Share(%)|Load Share(%)|Load Share(%)|BKG CM Share(%)|BKG CM Share(%)|BKG CM Share(%)" ;
	                var HeadTitle1=saveNM2 + "by Load|by RPB|Change|by Load|by CPB|Change|"+header+"|Change|"+header+"|Change" ;
	               
		                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		                var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
		                InitHeaders(headers, info);
		                var cols =  [];
		                for(j=0; j<tCnt; j++){
		                	cols.push({Type:"Text",      Hidden:0,  Width:colSize[j],Align:"Center",  ColMerge:1,   SaveName:saveCD[j],          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                }
		                
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"by_load_grev",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"by_rpb_grev",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"|by_load_grev|+|by_rpb_grev|",Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"by_load_cost",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"by_cpb_cost",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"|by_load_cost|+|by_cpb_cost|",Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"prev_load_share",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"curr_load_share",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"load_share",       KeyField:0,   CalcLogic:"|curr_load_share|-|prev_load_share|",Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"prev_cm_share",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"curr_cm_share",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cm_share",         KeyField:0,   CalcLogic:"|curr_cm_share|-|prev_cm_share|",Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
		                
		                InitColumns(cols);
		                SetEditable(0);//Editkind[optional,Defaultfalse]
		                SetSheetHeight(sheet_height);		//SJH.20141230.MOD
		                
                }
                break;
            case 3:      //sheet3 init
                with (sheetObj) {
	                var HeadTitle="";
	                var HeadTitle1="";
	                var fixd_cnt=0;
	                HeadTitle=saveNM1 + "Load|Load|Load|Freight Revenue|Freight Revenue|Freight Revenue|CM|CM|CM|RPB|RPB|RPB|CMB|CMB|CMB|BSA Capa|BSA Capa|BSA Capa|L/F(%)|L/F(%)|L/F(%)" ; //21
	                HeadTitle1=saveNM2 + "QTA|PFMC|Change(%)|QTA|PFMC|Change(%)|QTA|PFMC|Change(%)|QTA|PFMC|Change|QTA|PFMC|Change|QTA|PFMC|Change|QTA|PFMC|Change(%) " ;//21
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"},  { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols =  [];
	                for(j=0; j<tCnt; j++){
	                	//SJH.20140904.MOD
	                	cols.push({Type:"Text",      Hidden:0,  Width:colSize[j],Align:"Center",  ColMerge:1,   SaveName:saveCD[j],        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });	                	
	                }
	                //SJH.20140904.ADD
	        	    cols.push({Type:"AutoSum", 		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"qta_load",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"coa_load",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",    	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"load_chng",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"qta_rev",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"coa_rev",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",  		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rev_chng",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"qta_cm",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"coa_cm",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cm_chng",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"qta_rpb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"coa_rpb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",  		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rpb_chng",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"qta_cmb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"coa_cmb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cmb_chng",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"qta_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"coa_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"AutoSum",  		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"bsa_capa_chng",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"qta_lf",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   	Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"coa_lf",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    cols.push({Type:"Float",   		Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"lf_chng",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	        	    
	                InitColumns(cols);
	                SetEditable(0);//Editkind[optional,Defaultfalse]
	                SetImageList(0,"/opuscntr/img/button/btns_positivechange.gif");
	                SetImageList(1,"/opuscntr/img/button/btns_negativechange.gif");
	                SetSheetHeight(sheet_height);		//SJH.20140904.ADD
                }
                break;
            case 4:      //sheet4 init
                with (sheetObj) {
	                var fixd_cnt=0;
	                fixd_cnt=12;
	                (fixd_cnt + tCnt, tCnt, 0, true);                                     //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                var HeadTitle=saveNM1 + "REV Increase/Decrease|REV Increase/Decrease|REV Increase/Decrease|Cost Increase/Decrease|Cost Increase/Decrease|Cost Increase/Decrease|Load Share(%)|Load Share(%)|Load Share(%)|BKG CM Share(%)|BKG CM Share(%)|BKG CM Share(%)" ;
	                var HeadTitle1=saveNM2 + "by Load|by RPB|Change|by Load|by CPB|Change|QTA|PFMC|Change|QTA|PFMC|Change" ;
	                if(getComboObjValue(f_pro_vw) == "R" && getComboObjValue(f_pro_lvl) == "O"){ //Office Profit
		                HeadTitle=HeadTitle  + "|BKG OP Share(%)|BKG OP Share(%)|BKG OP Share(%)";
		                HeadTitle1=HeadTitle1 + "|QTA|PFMC|Change";
	                }
	               
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );	
	                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);	
	                var cols = [ ];
	                for(j=0; j<tCnt; j++){	
	                	//SJH.20140904.ADD
	                	cols.push({Type:"Text",      Hidden:0,  Width:colSize[j],Align:"Center",  ColMerge:1,   SaveName:saveCD[j],          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                	//cols = [   {Type:"Text",      Hidden:0,  Width:colSize[j],Align:"Center",  ColMerge:1,   SaveName:saveCD[j],         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
	                }
	                //SJH.20140904.ADD
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"by_load_grev",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"by_rpb_grev",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"|by_load_grev|+|by_rpb_grev|",Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"by_load_cost",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"by_cpb_cost",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"|by_load_cost|+|by_cpb_cost|",Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"qta_load_share",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"coa_load_share",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"load_share",       KeyField:0,   CalcLogic:"|coa_load_share|-|qta_load_share|",Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"qta_cm_share",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"coa_cm_share",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cm_share",         KeyField:0,   CalcLogic:"|coa_cm_share|-|qta_cm_share|",Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
	                
	                InitColumns(cols);
	                SetEditable(0);//Editkind[optional,Defaultfalse]
	                SetSheetHeight(sheet_height);		//SJH.20141230.MOD
                }
                break;
        }
    }
    /**
     * Loading the data of the sheet
     */
    function reInitSheet(sheetObj, sheetNo, loadXml){
        try{
            // sheet Initialize
        	if(sheetObj.id=="sheet1")
    		{
	            sheet1.RenderSheet(0);
	            sheet1.SetVisible(0);
	            sheet1.RemoveAll();
	            sheet1.Reset();
	            ComConfigSheet(sheet1);
	            initSheet(sheet1, 1);
	            ComEndConfigSheet(sheet1);
	            sheet1.SetVisible(1);
	            sheet1.RenderSheet(1);
    		}
        	if(sheetObj.id=="sheet2")
    		{
        		sheet2.RenderSheet(0);
        		sheet2.SetVisible(0);
        		sheet2.RemoveAll();
        		sheet2.Reset();
	            ComConfigSheet(sheet2);
	            initSheet(sheet2, 2);
	            ComEndConfigSheet(sheet2);
	            sheet2.SetVisible(1);
	            sheet2.RenderSheet(1);
    		}
        	if(sheetObj.id=="sheet3")
    		{
        		sheet3.RenderSheet(0);
        		sheet3.SetVisible(0);
        		sheet3.RemoveAll();
        		sheet3.Reset();
	            ComConfigSheet(sheet3);
	            initSheet(sheet3, 3);
	            ComEndConfigSheet(sheet3);
	            sheet3.SetVisible(1);
	            sheet3.RenderSheet(1);
    		}
	    	if(sheetObj.id=="sheet4")
			{
	    		sheet4.RenderSheet(0);
	    		sheet4.SetVisible(0);
	    		sheet4.RemoveAll();
	    		sheet4.Reset();
	            ComConfigSheet(sheet4);
	            initSheet(sheet4, 4);
	            ComEndConfigSheet(sheet4);
	            sheet4.SetVisible(1);
	            sheet4.RenderSheet(1);
			}
        }catch(e){
            ComShowMessage("\n function name : reInitSheet"
                + "\n message       : " + e.message
                + "\n name          : " + e.name
                + "\n number        : " + e.number
                + "\n filename      : " + e.filename
                + "\n linenumber    : " + e.linenumber +"\n");
        }
    }
    /**
 * initializing Tab
 * setting Tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    InsertItem( "   VS Pre Week   " , "");
                    InsertItem( "     VS QTA      " , "");			//SJH.20140904.ADD
                }
             break;
        }
    }
     /**
		* registering IBCombo Object as list
		* adding process for list in case of needing batch processing with other items 
		* defining list on the top of source
     */
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
			* registering IBTab Object as list
			* adding process for list in case of needing batch processing with other items 
			* defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Handling after sheet1 retrieved : enter the total amount recalculated
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
        var sheetObj3=sheetObjects[2];
        var formObj=document.form;

        if(eval(sheetObj.GetSumValue(0, "prev_load")) > 0){
               sheetObj.SetSumValue(0, "load_chng",eval("((" + sheetObj.GetSumValue(0,"curr_load")+ "/" + sheetObj.GetSumValue(0, "prev_load") + ")-1)*100").toFixed(2));
//               sheetObj.SetSumValue(0, "prev_rpb",ComAddThreeDigitComma(eval("(" + sheetObj.GetSumValue(0,"prev_rev")+ "/" + sheetObj.GetSumValue(0, "prev_load") + ")"),2));
               sheetObj.SetSumValue(0, "prev_rpb",eval("(" + sheetObj.GetSumValue(0,"prev_rev")+ "/" + sheetObj.GetSumValue(0, "prev_load") + ")").toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "load_chng","0.00");
             sheetObj.SetSumValue(0, "prev_rpb","0.00");
        }
        
        
        if(eval(sheetObj.GetSumValue(0, "prev_rev")) > 0){
               sheetObj.SetSumValue(0, "rev_chng",eval("((" + sheetObj.GetSumValue(0,"curr_rev")+ "/" + sheetObj.GetSumValue(0, "prev_rev") + ")-1)*100").toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "rev_chng","0.00");
        }
        if(eval(sheetObj.GetSumValue(0, "prev_cm")) > 0){
               sheetObj.SetSumValue(0, "cm_chng",eval("((" + sheetObj.GetSumValue(0,"curr_cm")+ "/" + sheetObj.GetSumValue(0, "prev_cm") + ")-1)*100").toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "cm_chng","0.00");
        }
        if(eval(sheetObj.GetSumValue(0, "curr_load")) > 0){
//               sheetObj.SetSumValue(0, "curr_rpb",ComAddThreeDigitComma(eval("(" + sheetObj.GetSumValue(0,"curr_rev")+ "/" + sheetObj.GetSumValue(0, "curr_load") + ")"),2));
               sheetObj.SetSumValue(0, "curr_rpb",eval("(" + sheetObj.GetSumValue(0,"curr_rev")+ "/" + sheetObj.GetSumValue(0, "curr_load") + ")").toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "curr_rpb","0.00");
        }    

        if(eval(sheetObj.GetSumValue(0, "prev_rpb")) > 0){
        	sheetObj.SetSumValue(0, "rpb_chng",ComAddThreeDigitComma(eval(sheetObj.GetSumValue(0,"curr_rpb")) - eval(sheetObj.GetSumValue(0, "prev_rpb")),2));
//        	sheetObj.SetSumValue(0, "rpb_chng",eval(sheetObj.GetSumValue(0,"curr_rpb")) - eval(sheetObj.GetSumValue(0, "prev_rpb")).toFixed(2));
        } else {
        	sheetObj.SetSumValue(0, "rpb_chng","0.00");
        }
        
        if(eval(sheetObj.GetSumValue(0, "prev_load")) > 0){
               sheetObj.SetSumValue(0, "prev_cmb",eval(sheetObj.GetSumValue(0,"prev_cm") / sheetObj.GetSumValue(0, "prev_load")).toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "prev_cmb","0.00");
        }
        if(eval(sheetObj.GetSumValue(0, "curr_load")) > 0){
               sheetObj.SetSumValue(0, "curr_cmb",eval(sheetObj.GetSumValue(0,"curr_cm") / sheetObj.GetSumValue(0, "curr_load")).toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "curr_cmb","0.00");
        } 
        
        if(eval(sheetObj.GetSumValue(0, "prev_cmb")) > 0){
           sheetObj.SetSumValue(0, "cmb_chng",eval(sheetObj.GetSumValue(0,"curr_cmb") - sheetObj.GetSumValue(0, "prev_cmb")).toFixed(2));
        } else {
            sheetObj.SetSumValue(0, "cmb_chng","0.00");
        }

        if(eval(sheetObj.GetSumValue(0, "prev_bsa_capa")) > 0){
        	sheetObj.SetSumValue(0, "bsa_capa_chng",ComAddThreeDigitComma(eval(sheetObj.GetSumValue(0,"curr_bsa_capa")+ " - " + sheetObj.GetSumValue(0, "prev_bsa_capa")).toFixed(2),2));
        } else {
            sheetObj.SetSumValue(0, "bsa_capa_chng","0.00");
        }
      
        if(eval(sheetObj.GetSumValue(0, "curr_bsa_capa"))>0){
        	sheetObj.SetSumValue(0, "curr_lf",eval("("+sheetObj.GetSumValue(0, "curr_load")+"/"+sheetObj.GetSumValue(0, "curr_bsa_capa")+")*100").toFixed(2));
        }else{
        	sheetObj.SetSumValue(0, "curr_lf","0.00");
        }
           
        if(eval(sheetObj.GetSumValue(0, "prev_bsa_capa"))>0){
        	sheetObj.SetSumValue(0, "prev_lf",eval("("+sheetObj.GetSumValue(0, "prev_load")+"/"+sheetObj.GetSumValue(0, "prev_bsa_capa")+")*100").toFixed(2));
        }else{
        	sheetObj.SetSumValue(0, "prev_lf","0.00");
        }

        if(eval(sheetObj.GetSumValue(0, "prev_lf")) > 0){
        	sheetObj.SetSumValue(0, "lf_chng",eval(sheetObj.GetSumValue(0,"curr_lf") +"-"+ sheetObj.GetSumValue(0, "prev_lf")).toFixed(2));
        } else {   
        	sheetObj.SetSumValue(0, "lf_chng","0.00");
        }
       
       
        if(getComboObjValue(f_ofc_lvl1) == "1" && getComboObjValue(f_ofc_cd) == "" && !formObj.f_ofc_sts.checked){
            sheetObj.SetColHidden("prev_bsa_capa",0);
            sheetObj.SetColHidden("curr_bsa_capa",0);
            sheetObj.SetColHidden("bsa_capa_chng",0);
            sheetObj.SetColHidden("prev_lf",0);
            sheetObj.SetColHidden("curr_lf",0);
            sheetObj.SetColHidden("lf_chng",0);
        } else {
            sheetObj.SetColHidden("prev_bsa_capa",1);
            sheetObj.SetColHidden("curr_bsa_capa",1);
            sheetObj.SetColHidden("bsa_capa_chng",1);
            sheetObj.SetColHidden("prev_lf",1);
            sheetObj.SetColHidden("curr_lf",1);
            sheetObj.SetColHidden("lf_chng",1);
        }
        sheetObj.SetSumValue(0,"prev_cmb",ComAddThreeDigitComma(sheetObj.GetSumValue(0,"prev_cmb"),2));
        sheetObj.SetSumValue(0,"curr_cmb",ComAddThreeDigitComma(sheetObj.GetSumValue(0,"curr_cmb"),2));
        sheetObj.SetSumValue(0,"prev_rpb",ComAddThreeDigitComma(sheetObj.GetSumValue(0,"prev_rpb"),2));
        sheetObj.SetSumValue(0,"curr_rpb",ComAddThreeDigitComma(sheetObj.GetSumValue(0,"curr_rpb"),2));
        sheetObj.SetSumText(0,0, "TOTAL");        
    }
    /**
     * Handling after sheet2 retrieved : recalculate the total amount
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg){
    	var formObj=document.form;
        sheetObj.SetSumValue(0, "load_share",ComParseInt(sheetObj.GetSumValue(0, "curr_load_share")) - ComParseInt(sheetObj.GetSumValue(0, "prev_load_share")));
        sheetObj.SetSumValue(0, "cm_share",ComParseInt(sheetObj.GetSumValue(0, "curr_cm_share")) - ComParseInt(sheetObj.GetSumValue(0, "prev_cm_share")));
           
        sheetObj.SetSumText(0,0, "TOTAL");   
    }
    /**
     * Handling after sheet3 retrieved : enter the total amount recalculated
     */
    function sheet3_OnSearchEnd(sheetObj, errMsg) {
        var formObj=document.form;
        
        if(eval(sheetObj.GetSumValue(0, "qta_load")) > 0){
               sheetObj.SetSumValue(0, "load_chng",eval("(" + sheetObj.GetSumValue(0,"coa_load")+ "/" + sheetObj.GetSumValue(0, "qta_load") + ")*100").toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "load_chng","0.00");
        }
        if(eval(sheetObj.GetSumValue(0, "qta_rev")) > 0){
               sheetObj.SetSumValue(0, "rev_chng",eval("(" + sheetObj.GetSumValue(0,"coa_rev")+ "/" + sheetObj.GetSumValue(0, "qta_rev") + ")*100").toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "rev_chng","0.00");
        }
        if(eval(sheetObj.GetSumValue(0, "qta_cm")) > 0){
               sheetObj.SetSumValue(0, "cm_chng",eval("(" + sheetObj.GetSumValue(0,"coa_cm")+ "/" + sheetObj.GetSumValue(0, "qta_cm") + ")*100").toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "cm_chng","0.00");
        }
        if(parseInt(sheetObj.GetSumValue(0, "qta_load")) > 0){
               sheetObj.SetSumValue(0,"qta_cmb",eval(sheetObj.GetSumValue(0,"qta_cm")+"/"+sheetObj.GetSumValue(0, "qta_load")).toFixed(2));
        } else {
             sheetObj.SetSumValue(0,"qta_cmb","0.00");
        }
        if(parseInt(sheetObj.GetSumValue(0, "coa_load")) > 0){
               sheetObj.SetSumValue(0,"coa_cmb",eval(sheetObj.GetSumValue(0,"coa_cm")+"/"+sheetObj.GetSumValue(0, "coa_load")).toFixed(2));
        } else {
             sheetObj.SetSumValue(0,"coa_cmb","0.00");
        }
        if(eval(sheetObj.GetSumValue(0, "qta_cmb")) > 0){
               sheetObj.SetSumValue(0, "cmb_chng",eval("(" + sheetObj.GetSumValue(0,"coa_cmb")+ "-" + sheetObj.GetSumValue(0, "qta_cmb") + ")").toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "cmb_chng","0.00");
        }
        if(eval(sheetObj.GetSumValue(0, "qta_load")) > 0){
               sheetObj.SetSumValue(0, "qta_rpb",eval("(" + sheetObj.GetSumValue(0,"qta_rev")+ "/" + sheetObj.GetSumValue(0, "qta_load") + ")").toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "qta_rpb","0.00");
        }
        if(eval(sheetObj.GetSumValue(0, "coa_load")) > 0){
               sheetObj.SetSumValue(0, "coa_rpb",eval("(" + sheetObj.GetSumValue(0,"coa_rev")+ "/" + sheetObj.GetSumValue(0, "coa_load") + ")").toFixed(2));
        } else {
             sheetObj.SetSumValue(0, "coa_rpb","0.00");
        }     
        
       sheetObj.SetSumValue(0, "rpb_chng",eval(sheetObj.GetSumValue(0,"coa_rpb")+ "-" + sheetObj.GetSumValue(0, "qta_rpb")).toFixed(2));
       if(parseInt(sheetObj.GetSumValue(0, "qta_bsa_capa"))>0){
           sheetObj.SetSumValue(0, "qta_lf",eval("("+sheetObj.GetSumValue(0, "qta_load")+"/"+sheetObj.GetSumValue(0, "qta_bsa_capa")+")*100").toFixed(2));
        }else{
             sheetObj.SetSumValue(0, "qta_lf","0.00");
        }
           if(parseInt(sheetObj.GetSumValue(0, "coa_bsa_capa"))>0){
               sheetObj.SetSumValue(0, "coa_lf",eval("("+sheetObj.GetSumValue(0, "coa_load")+"/"+sheetObj.GetSumValue(0, "coa_bsa_capa")+")*100").toFixed(2));
        }else{
             sheetObj.SetSumValue(0, "coa_lf","0.00");
        }      
           sheetObj.SetSumValue(0, "lf_chng",eval(sheetObj.GetSumValue(0,"coa_lf")+"-"+ sheetObj.GetSumValue(0, "qta_lf")).toFixed(2));
        if(getComboObjValue(f_ofc_lvl1) == "1" && getComboObjValue(f_ofc_cd) == "" && !formObj.f_ofc_sts.checked && !formObj.f_rf_sts.checked){
            sheetObj.SetColHidden("qta_bsa_capa",0);
            sheetObj.SetColHidden("coa_bsa_capa",0);
            sheetObj.SetColHidden("bsa_capa_chng",0);
            sheetObj.SetColHidden("qta_lf",0);
            sheetObj.SetColHidden("coa_lf",0);
            sheetObj.SetColHidden("lf_chng",0);
        } else {
            sheetObj.SetColHidden("qta_bsa_capa",1);
            sheetObj.SetColHidden("coa_bsa_capa",1);
            sheetObj.SetColHidden("bsa_capa_chng",1);
            sheetObj.SetColHidden("qta_lf",1);
            sheetObj.SetColHidden("coa_lf",1);
            sheetObj.SetColHidden("lf_chng",1);
        }
        sheetObj.SetSumText(0, "TOTAL");     
    }
    /**
     * Handling after sheet3 retrieved : enter the total amount recalculated
     */
    function sheet4_OnSearchEnd(sheetObj, errMsg){
    	var formObj=document.form;
           sheetObj.SetSumValue(0, "load_share",ComParseInt(sheetObj.GetSumValue(0, "coa_load_share")) - ComParseInt(sheetObj.GetSumValue(0, "qta_load_share")));
           sheetObj.SetSumValue(0, "cm_share",ComParseInt(sheetObj.GetSumValue(0, "coa_cm_share")) - ComParseInt(sheetObj.GetSumValue(0, "qta_cm_share")));
           sheetObj.SetSumText(0,0, "TOTAL");     
    }
	/**
		* Event when clicking Tab
		* activating selected tab items
	 */
	function tab1_OnChange(tabObj , nItem){		
		var objs=document.all.item("tabLayer");
		var formObj=document.form;
		objs[nItem].style.display="Inline";
		for(var i = 0; i<objs.length; i++){
		       if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		       }
		      }
		beforetab=nItem;
		if(nItem == 0){
			tr0.style.display="block";
			tr1.style.display="none";
			tr2.style.display="none";
			tr3.style.display="none";
		}else if(nItem == 1){
			tr0.style.display="none";
			tr1.style.display="block";		
			tr2.style.display="block";
			tr3.style.display="block";
		}
		chgOffice(f_ofc_lvl1);
	}
	/**
		* window display
	 */
	function InvOnChange( dst , m  ){
		document.getElementById(dst).style.display=m;
	}
    /**
     * Date Period is cleared If you choose seq.
     */
    function clearDatePeriod(){
        document.form.f_wk.value="";
        document.getElementById("div_period").innerHTML="<div id='div_period'></div>";
    }
     /**
      * Change the office combo in case of changing the office level
      */
     function f_ofc_lvl1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
     	 if (loadingMode == true) return;  
     	 chgOffice(comboObj);
     }
    /**
     * In case of changing the H/Q office
     */
    function chgOffice(obj){
    	 var formObj=document.form;
         var sheetObj=sheetObjects[0];
         if(obj.GetSelectText()!= ""){
         	formObj.f_cmd.value=SEARCHLIST13;
  			var sXml=sheetObj.GetSearchData("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
 			var arrXml=sXml.split("|$$|");
 			if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], f_ofc_cd, "code", "code");
 			f_ofc_cd.SetSelectIndex(0);
         }
    }
    /**
     * Change R.Lane combo in case of changing the trade
     */
	function f_trd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if (loadingMode == true)
			return;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if (comboObj.GetSelectText()!= "") {
			formObj.f_cmd.value=SEARCHLIST11;
 			var sXml=sheetObj.GetSearchData("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_rlane_cd, "code", "code");
			f_rlane_cd.SetSelectIndex(0);
		}
	}
  	/**
  	 * Change the column in case of changing the Office View
  	 */
  	function f_ofc_vw_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
  		if (loadingMode == true)
  			return;
  		//viewSheet();
  	}
  	//SJH.20150109.MOD
  	function setPeriod(obj) {  		
  		ComCoaSetPeriod(obj);
  	}
    //SJH.20150109.ADD
    function setPeriod2(obj){
   	 if (loadingMode == true)
   		return;
   	 var formObj=document.form; 
        with(formObj){
		   if(f_year2 == null || f_wk == null){
	           return;
	       }
	       if(f_year2.value == "" || f_wk.value == ""){      
	           return false;
	       }
	       if(!isValidYear(f_year2,false,true)) return false;
	       if(!isValidWeek(f_wk,false,true)) return false;
	       
	       f_yearweek.value=f_year2.value+f_wk.value; 
	       
           var sheetObj=sheetObjects[0];
           formObj.f_cmd.value=SEARCH06; 
           var sValue=ComSearchEtcData(sheetObj, "initPeriodGS.do", FormQueryString(formObj), "period");
			if (sValue!=undefined)
				$("#div_period1").html(sValue);
       }
    }
    /**
     * Change period when the month, week was changed
     */  	
	/*
     * Getting a list of the ofc_cd in case of changing on year and month values
     */
    function changeCostYrmon(val){    	
        if(val != '') chgOffice(f_ofc_lvl1);		//SJH.2015010.MOD
    }   
    /**
     * Handling process about the sheet object
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var sheetObj2=sheetObjects[1];
        var sheetObj3=sheetObjects[2];
        var sheetObj4=sheetObjects[3];
        switch(sAction) {
        	case IBCLEAR:          //Inquiry
        		sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
				formObj.f_cmd.value=INIT;
 				var sXml=sheetObj.GetSearchData("ESM_COA_0070GS3.do", coaFormQueryString(formObj));
				//var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				var arrXml=sXml.split("|$$|");
				
	          	//SJH.20150102.ADD/MOD
				formObj.f_year2.value=ComGetEtcData(arrXml[0], "prevWeekY");
	            formObj.f_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
	            document.getElementById("div_period1").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";
	            
	        	//SJH.20150109.ADD/MOD
	        	formObj.f_yearM.value=ComGetNowInfo("yy");        	
	            formObj.f_year.value=ComGetNowInfo("yy");
	            formObj.f_fm_mon.value=ComGetNowInfo("mm").lpad(2, "0");
	            formObj.f_to_mon.value=ComGetNowInfo("mm").lpad(2, "0");	
	            formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
	            formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
	            formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
	            formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");            
	            document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";
	            
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_pro_vw, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_ofc_vw, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], f_pro_lvl, "code", "name");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], f_ofc_lvl1, "code", "name");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], f_ofc_cd, "code", "code");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], f_ofc_lvl2, "code", "name");
				if (arrXml.length > 6)
					ComXml2ComboItem(arrXml[6], f_trd_cd, "code", "code");
				if (arrXml.length > 7)
					ComXml2ComboItem(arrXml[7], f_rlane_cd, "code", "code");
				if (arrXml.length > 8)
					ComXml2ComboItem(arrXml[8], f_skd_dir_cd, "code", "code");
				if (arrXml.length > 9)
					ComXml2ComboItem(arrXml[9], f_rpt_item, "code", "name");				
				ComOpenWait(false);
				break;
            case IBSEARCH:      //Inquiry
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // Prohibit button click when a business transaction is processing 
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
	            setTimeout( function () {
	                formObj.f_cmd.value=SEARCHLIST01;
	                var sXml=sheetObj.GetSearchData("ESM_COA_0070GS.do", coaFormQueryString(formObj));
	                formObj.f_pre_week.value = ComGetEtcData(sXml, "f_pre_week"); 
	                                
	                var sXml1 = ComGetEtcData(sXml, "sXml1"); 
	                var sXml2 = ComGetEtcData(sXml, "sXml2"); 
	
	                sheet1 = sheet1.Reset();
		            initSheet(sheet1, 1);
		            sheet2 = sheet2.Reset();
		            initSheet(sheet2, 2);
	
				    sheet1.LoadSearchData(sXml1,{Sync:0} );
				    sheet2.LoadSearchData(sXml2,{Sync:0} );
				    ComOpenWait(false);
	            }, 100);
                break;
            case IBDOWNEXCEL:        // Excell download
            	//SJH.20150105.MOD
        		if(sheet1.RowCount() < 1){//no data
        			  ComShowCodeMessage("COM132501");
        			  return;
        		}        	
        	  	var excelType=selectDownExcelMethod(sheet1);
                break;
        }
    }
    
    //SJH.20150109.MOD
	function callBackExcelMethod(excelType){
		if(tabObjects[0].GetSelectedIndex()==0){
			var sheetObj1 = sheet1;
			var sheetObj2 = sheet2;
		} else {
			var sheetObj1 = sheet3;
			var sheetObj2 = sheet4;
		}
		sheetObj1.Down2ExcelBuffer(true);
	    switch (excelType) {
		    case "AY":
		    	sheetObj1.Down2Excel({ HiddenColumn:0, SheetName:sheetObj1.id, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	sheetObj2.Down2Excel({ HiddenColumn:0, SheetName:sheetObj2.id, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		        break;
		    case "AN":
		    	sheetObj1.Down2Excel({ HiddenColumn:0, SheetName:sheetObj1.id, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	sheetObj2.Down2Excel({ HiddenColumn:0, SheetName:sheetObj2.id, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	break;
		    case "DY":
		    	sheetObj1.Down2Excel({ HiddenColumn:1, SheetName:sheetObj1.id, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	sheetObj2.Down2Excel({ HiddenColumn:1, SheetName:sheetObj2.id, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
		    case "DN":
		    	sheetObj1.Down2Excel({ HiddenColumn:1, SheetName:sheetObj1.id, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	sheetObj2.Down2Excel({ HiddenColumn:1, SheetName:sheetObj2.id, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
		} 
	    sheetObj1.Down2ExcelBuffer(false);  	    
   	}	
	
    function doActionIBSheet2(sheetObj, formObj, sAction){
        sheetObj.ShowDebugMsg(false);
        var sheetObj3=sheetObjects[2];
        var sheetObj4=sheetObjects[3];
        switch(sAction) {
            case IBSEARCH:      //Inquiry
            	//SJH.20140904.MOD
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // Prohibit button click when a business transaction is processing 
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
	            setTimeout( function () {
	                formObj.f_cmd.value=SEARCHLIST02;
	                var sXml=sheetObj.GetSearchData("ESM_COA_0070GS2.do", coaFormQueryString(formObj));
	                formObj.f_pre_week.value = ComGetEtcData(sXml, "f_pre_week"); 
	                
	                var sXml3 = ComGetEtcData(sXml, "sXml3"); 
	                var sXml4 = ComGetEtcData(sXml, "sXml4");                 
	                
//				    reInitSheet(sheetObj3, 3, sXml3);
//				    reInitSheet(sheetObj4, 4, sXml4);
				    
	                sheet3 = sheet3.Reset();				//SJH.20141230.MOD
		            initSheet(sheet3, 3);
		            sheet4 = sheet4.Reset();
		            initSheet(sheet4, 4);			    
				    
		            sheet3.LoadSearchData(sXml3,{Sync:0} );
		            sheet4.LoadSearchData(sXml4,{Sync:0} );
				    ComOpenWait(false);	   
	            }, 100); 
                break;
                
            case IBDOWNEXCEL:        // Excell download                
            	//SJH.20150105.MOD
        		if(sheet3.RowCount() < 1){//no data
        			  ComShowCodeMessage("COM132501");
        			  return;
        		}        	
        	  	var excelType=selectDownExcelMethod(sheet3);
                break;
        }
    }

    /**
     * Handling process for form object input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	//SJH.20150109.MOD
        	if(tabObjects[0].GetSelectedIndex()==0){
     		   if(f_year2 == null || f_wk == null){
    	           return;
    	       }
    	       if(f_year2.value == "" || f_wk.value == ""){      
    	           return false;
    	       }
    	       if(!isValidYear(f_year2,false,true)) return false;
    	       if(!isValidWeek(f_wk,false,true)) return false;
        	} else {
        		if(!chkValidSearch()) return false;  			//SJH.20150105.ADD 
        	}
        	
            if(parseInt(f_ofc_lvl1.value) > parseInt(f_ofc_lvl2.value)){
                ComShowCodeMessage("COM12114","Level 2");		//SJH.20150109.MOD 
                return false;
            }
        }
        return true;
    }
     function getComboObjValue(obj){
 	 	if (ComGetObjValue(obj) == "All") return "";
 	 	return ComGetObjValue(obj);
 	 } 
     
     //
     
     