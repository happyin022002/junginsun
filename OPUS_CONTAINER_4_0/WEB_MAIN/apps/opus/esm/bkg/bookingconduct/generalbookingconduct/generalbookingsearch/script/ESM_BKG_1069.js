/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1069.js
*@FileTitle  : Route Detail inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var comboObjects=new Array();
var comboCnt=0; 
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {                
				case "btn_close":
					ComClosePopup(); 
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
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    	for(var j=0; j<comboObjects.length; j++){
            initCombo(comboObjects[j]);
        }
    	org_trns_mod_cd.SetDropHeight(250);
    	org_trns_mod_cd.SetColWidth(0, "20");
    	org_trns_mod_cd.SetColWidth(1, "100");
    	dest_trns_mod_cd.SetDropHeight(250);
    	dest_trns_mod_cd.SetColWidth(0, "20");
    	dest_trns_mod_cd.SetColWidth(1, "100");
    	doActionIBSheet(sheetObjects[1],document.form,INIT);
    }
     /**
      * setting combo initial values and header 
      * @param {IBMultiCombo} comboObj  comboObj
      */
     function initCombo(comboObj) {
     	comboObj.SetMultiSelect(0);
//      	comboObj.UseCode = true;
     //no support[check again]CLT 	comboObj.LineColor="#ffffff";
     	comboObj.SetColAlign(0, "left");
     	comboObj.SetColAlign(1, "left");
     	comboObj.SetMultiSeparator("|");
     }
     /**
      * registering IBCombo Object as list
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
         comboObjects[comboCnt++]=combo_obj;
     }
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:
                with(sheetObj){
	             var HeadTitle="Seq.|POL|POL|POD|POD|VVD|Lane|POL ETD|POL ETD|POD ETA|POD ETA";
	
	             SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	
	             var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vps_etd_dt_date",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vps_etd_dt_time",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt_date",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt_time",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              
	             InitColumns(cols);
	             SetCountPosition(0);
	           //ScrollBar=2;
	             SetShowButtonImage(2);
	             SetWaitImageVisible(0);
	             SetSheetHeight(146);
             }
            break;
        	case 2:
        	    with(sheetObj){
	              var HeadTitle="|";
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];
	               
	              InitColumns(cols);
	              SetSheetHeight(100);
        		}
        	break;
        }
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
		    case INIT:      //Default
				formObj.f_cmd.value=INIT;
 				var sXml=sheetObj.GetSearchData("ESM_BKG_1069GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (0 < arrXml.length) {
					ComBkgXml2ComboItem(arrXml[0], org_trns_mod_cd, "val", "name");
					ComBkgXml2ComboItem(arrXml[0], dest_trns_mod_cd, "val", "name");
					org_trns_mod_cd.SetSelectIndex(0);
					dest_trns_mod_cd.SetSelectIndex(0);
				}
				doActionIBSheet(sheetObjects[0],document.form,SEARCH);
			break;
		    case SEARCH:      //retrieve
	        	 formObj.f_cmd.value=SEARCH;              	
				 var resultXml=sheetObj.GetSearchData("ESM_BKG_1069GS.do", FormQueryString(formObj));
				 var arrXml=resultXml.split("|$$|"); 	
				 var etcXml=arrXml[0];
				 var org_trns_mod_cd_etc = ComGetEtcData(etcXml, "org_trns_mod_cd");
				 var dest_trns_mod_cd_etc = ComGetEtcData(etcXml, "dest_trns_mod_cd");
				 if(org_trns_mod_cd_etc == ""){
					 org_trns_mod_cd_etc ="N";
				 }
				 if(dest_trns_mod_cd_etc == ""){
					 dest_trns_mod_cd_etc ="N";
				 }					 
				 BkgEtcDataXmlToForm(etcXml, formObj);
				 document.getElementById("vps_eta_dt_date").value=ComGetEtcData(etcXml, "vps_eta_dt_date");
				 document.getElementById("vps_eta_dt_time").value=ComGetEtcData(etcXml, "vps_eta_dt_time");
				 document.getElementById("por_cd").value=ComGetEtcData(etcXml, "por_cd");
				 document.getElementById("por_nod_cd").value=ComGetEtcData(etcXml, "por_nod_cd");
				 document.getElementById("pol_cd").value=ComGetEtcData(etcXml, "pol_cd");
				 document.getElementById("pol_nod_cd").value=ComGetEtcData(etcXml, "pol_nod_cd");
				 document.getElementById("pod_cd").value=ComGetEtcData(etcXml, "pod_cd");
				 document.getElementById("pod_nod_cd").value=ComGetEtcData(etcXml, "pod_nod_cd");
				 document.getElementById("del_cd").value=ComGetEtcData(etcXml, "del_cd");
				 document.getElementById("del_nod_cd").value=ComGetEtcData(etcXml, "del_nod_cd");
				 org_trns_mod_cd.SetSelectCode(org_trns_mod_cd_etc);
				 dest_trns_mod_cd.SetSelectCode(dest_trns_mod_cd_etc);
				 sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
            break;
        }
    }
