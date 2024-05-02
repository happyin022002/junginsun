/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0145.jsp
*@FileTitle  : Lane History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/*------------------Code for JSDoc creation below ------------------*/
/**
 * @extends 
 * @class ESM_COA_0145 : ESM_COA_0145 Business script for the UI
 */
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
var sheet_height=14; // sheet height
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		 if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
        	    case "btn_Save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;
        	    case "btn_Rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	    case "btn_Close":
					//20150522.ADD
					if (!opener) opener=parent; //이 코드 추가할것
					opener.retrieve();
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg("COM12111", "", ""));
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
		loadingMode=true;
	    for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	    for(k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
		loadingMode=false;
	}
	/**
	 * Setting multicombo items
	 */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
			SetDropHeight(300);
			Index=0;
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
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
              var HeadTitle="Del.|STS|SEQ|Trade|Sub Trade|S.Lane|R.Lane|Bound|IOC|Lane T/P|Step Up/Down|VVD|From|To.";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
                     {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lane_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"stup_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lane_aply_fm_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lane_aply_to_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);//Editkind[optional,Defaultfalse]
//              SetSheetHeight(ComGetSheetHeight(sheetObj,sheet_height));
			  resizeSheet();
              SetColProperty(0 ,"vvd_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
            }
            break;
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
    //VVD --> edt-date
    function getEdtDate(result) {
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	var tmpRow=0;
    	if(result == null || result == "" || result == "null"){
    		ComShowMessage(ComGetMsg('COA10027',selValue));
    		sheetObject1.SelectCell(selRow, "vvd_cd",true);
    	} else {
    		sheetObject1.SetCellValue(selRow,"lane_aply_fm_dt",result);
    	}
    }   
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var formObj=document.form;
        sheetObj.SetRowEditable(1,0);
    }
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
    	var formObj=document.form;
    	with(sheetObj) {
    	    // If you change the from_date  it is changed as to_date of the previous data
    		if (ColSaveName(Col) == "lane_aply_fm_dt") {
    			if (Row > 1) {
    				//Day-1 output logic
    				//CellValue2(Row-1,"lane_aply_to_dt") = getOffsetDate(Value,-1);
                    SetCellValue(Row-1,"lane_aply_to_dt",ComGetDateAdd(Value, "D", -1, "-"),0);
    			}
    		}
    		// It's displayed of the ETD_Date of the first loading port when the VVD is changed
    		if (ColSaveName(Col) == "vvd_cd") {
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
    			selRow=Row;
    			selValue=Value;
				formObj.f_cmd.value=SEARCHLIST02;
	        	formObj.f_vsl_cd.value=Value.substring(0,4);
	        	formObj.f_skd_voy_no.value=Value.substring(4,8);
	        	formObj.f_skd_dir_cd.value=Value.substring(8,9);
 				var sXml=sheetObj.GetSearchData("ESM_COA_0145GS2.do", coaFormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (0 < arrXml.length) {
					parent.getEdtDate(ComGetEtcData(arrXml[0],"edtDate"));
				}
				ComOpenWait(false);
    		}
    		// Dosen't be "step up/down" in case of "SC"			20150522.ADD : MAIN하고 다름 맞춰주기 자율에 맡기도록..
//    		if(ColSaveName(Col) == "vsl_lane_tp_cd"){
//if(GetCellValue(Row, "vsl_lane_tp_cd") == "SC") {
//        		    SetCellValue(Row, "stup_flg","0");
//        		    SetCellEditable(Row, "stup_flg",0);
//    		    } else {
//        		    SetCellEditable(Row, "stup_flg",1);
//    		    }
//    		}
    	}
    }
	/**
	 * Handling process about the sheet object
	 */ 
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
	    	case IBCLEAR:          //Inquiry
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
 				var sXml=sheetObj.GetSearchData("ESM_COA_0145GS2.do", coaFormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (0 < arrXml.length) {
					ComCoaSetIBCombo(sheetObj, arrXml[0], "vsl_lane_tp_cd", true, 0);
				}
				ComOpenWait(false);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case IBSEARCH:      //Inquiry
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// Prohibit button click when a business transaction is processing 
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCHLIST01;
 				sheetObj.DoSearch("ESM_COA_0145GS.do", coaFormQueryString(formObj) );
				ComOpenWait(false);
				break;
			case IBSAVE:        //Save
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// Prohibit button click when a business transaction is processing 
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI01;
				sheetObj.DoSave("ESM_COA_0145GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
				ComOpenWait(false);
				break;
			case IBINSERT:      // Insert
			    sheetObj.DataCopy(); //copy row
//				sheetObj.DataCopy(-1); 
                var num=0;
                for(i=1; i<sheetObj.LastRow()+1; i++){
                	if(parseInt(num)<parseInt(sheetObj.GetCellValue(i, "lane_seq"))) {
                		num=sheetObj.GetCellValue(i, "lane_seq");
                    }
    		        sheetObj.SetRowEditable(i+1,1);
                }
                num=parseInt(num) + 1;
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "lane_seq",num,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "stup_flg","0",0);
				
				break;
		}
	}
   /**
     * Handling process for form object input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            for(var i=1; i<=sheetObj.LastRow(); i++){
var lane_aply_fm_dt=sheetObj.GetCellValue(i,"lane_aply_fm_dt");
var lane_aply_to_dt=sheetObj.GetCellValue(i,"lane_aply_to_dt");
if(sheetObj.GetCellValue(i,"ibflag") != "R"){
                    if(lane_aply_fm_dt == "") {
                        ComShowMessage(ComGetMsg("COM12114","From Date"));
                        sheetObj.SelectCell(i, "lane_aply_fm_dt");
                        return false;
                    }
                    if(lane_aply_to_dt == "") {
                        ComShowMessage(ComGetMsg("COM12114","To Date"));
                        sheetObj.SelectCell(i, "lane_aply_to_dt");
                        return false;
                    }
                }
            } 
        }
        return true;
    }

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
    
    //20150522.ADD
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	ComOpenWait(false);
        if(ErrMsg == ""){
            // [COA10006] : The processes was completed
            ComShowMessage(ComGetMsg("COA10006"));
        }else{
            ComShowMessage(ComGetMsg("COM132101"));
        }	
        doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
