/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0122.js
*@FileTitle  : Damage Flagging/Unflagging 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/* developer job	*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var uTpSz=new Array();
var gTpSz=new Array();
var zTpSz=new Array();
var err1 = "";
var err2 = "";
var appendPageNo = 1;
var appendCondParam = "";
var rtv_total = 0;
	
// Event handler processing by button click event
document.onclick=processButtonClick;

// Event handler processing by button name
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrive":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
		        case "btn_new":
                    doActionIBSheet(sheetObject,formObject,IBCLEAR);
                    break;
		        case "btn_save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
		        case "btn_downExcel":
		        	if(sheetObject.RowCount() < 1){//no data
		        		ComShowCodeMessage("COM132501");
		        	}else{
		        		sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
		        	}		        	
                    break;
		        case "btns_popup":
                    ComOpenPopup('/opuscntr/COM_ENS_061.do', 766, 553, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;
		        case "btn_loadExcel":
					  allSheetClr();
					  ComOpenPopup('/opuscntr/EES_MNR_0139.do?eq_type=' + eq_knd_cd.GetSelectCode(), 798, 550, 'getEES_MNR_0139', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;
		        case "btns_req_multy2":
                    rep_Multiful_inquiry("eq_tpsz_cd");
                    break;
		        case "btns_calendar":
                    var cal=new ComCalendar();
	                cal.select(formObject.mnr_dmg_flg_dt, 'yyyy-MM-dd');
	                break;
				// inputting multi
				case "eq_no_multi":
				    rep_Multiful_inquiry("eq_list");
				    break;
				case "btn_more":
	                doActionIBSheet(sheetObject, formObject, IBSEARCHAPPEND);
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
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
		MnrWaitControl(true);
   		initControl();
        for(i=0;i<sheetObjects.length;i++){
        	//
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
        	//
            ComEndConfigSheet(sheetObjects[i]);
        }
		// initializing IBMultiCombo
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1);
	    }
		for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }
		MnrOfficeLevel(currOfcCd,rhqOfcCd);
//		alert(DateDiff(d, |7|, ComGetNowInfo("ymd")) + 1);
		setTpSzArray(sheetObjects[0]);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
	function setTpSzArray(sheetObj){
		var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind");
		if(arrXml != null){
		    for(var i=0; i < arrXml.length; i++){
				if(i == 0){
					uTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){
					zTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){
					gTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
		    }
		}
	}
	/**
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject.
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * setting combo basic info
	 * @param	{IBMultiCombo}	combo_obj	ComboObject.
	 * @param	{Number}	comboNo		ComboObject tag serial number
	 * adding case as numbers of counting combos
	 */
	function initCombo (comboObj, comboNo) {
	    //var cnt  = 0 ;
	    var formObject=document.form;
	    switch(comboNo) {
	          case 1:
			  case 2:
	           with (comboObj) {
				  SetColAlign(0, "left");
				   SetDropHeight(160);
		       }
	           break;
			   case 3:
			   with (comboObj) {
					SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "80");
					SetDropHeight(200);
			   }
	    }
	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
            	with(sheetObj){
            		var HeadTitle="|Seq.|Flag|EQ Type|EQ No.|TP/SZ|Yard|Flag Date|Over Days|Remark(s)";

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                      KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mnr_dmg_flg",              KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",                    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mnr_dmg_flg_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
            		             {Type:"PopupEdit", Hidden:0, Width:120,   Align:"Center",  ColMerge:0,   SaveName:"mnr_dmg_flg_dt",           KeyField:1,   CalcLogic:"",   Format:"YmdHm",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            		             {Type:"Int",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"mnr_dmg_flg_dt_over_day",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"mnr_sts_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 }];
            					 
            		InitColumns(cols);

            		SetEditable(1);
                    //conversion of function[check again]CLT					InitDataValid(0,  "mnr_dmg_flg_yd_cd", vtEngUpOther,"0123456789");
            		SetColProperty(0 ,"mnr_dmg_flg_yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            		SetShowButtonImage(2);
            		SetSelectionMode(smSelectionRow);
//            		SetSheetHeight(422);
            		resizeSheet( sheetObj );
            	}
            	break;
            case 2:      //t1sheet1 init
            	with(sheetObj){
            		var HeadTitle="Status";
            		var Title1=90;
            		var Title2=90
            		var  MANU=80;
            		var  Owner=50;
            		var drCnt=0;

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

            		var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
            		             {Type:"Text",      Hidden:0,  Width:Title1,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:MANU, Align:"Center",  ColMerge:0,   SaveName:"MANU",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Title2,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Owner,Align:"Left",    ColMerge:0,   SaveName:"Owner",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            		             
            		             [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
            		             {Type:"Text",      Hidden:0,  Width:Title1,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:MANU, Align:"Center",  ColMerge:0,   SaveName:"Lease",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Title2,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Owner,Align:"Center",  ColMerge:0,   SaveName:"Disposal",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            		             
            		             [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
            		             {Type:"Text",      Hidden:0,  Width:Title1,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:MANU, Align:"Center",  ColMerge:0,   SaveName:"Off",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Title2,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Owner,Align:"Center",  ColMerge:0,   SaveName:"Imm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }] ];
                
            		InitColumns(cols, 3);

            		SetEditable(0);
            		SetCountPosition(0);
            		SetRowHidden(0, 1);
                    drCnt++;
                    cnt=0;
                    drCnt++;
                    cnt=0;
                    SetDataRowHeight(10);
                    shtClear(sheetObj);
                    SetSheetHeight(80);
            	}
            	break;
            case 3:      //t1sheet1 init
                with(sheetObj){
            		var HeadTitle="Status";
            		var Title1=90;
            		var Title2=90
            		var  TYPE=80;
            		var  Status=50;
            		var drCnt=0;

            		SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
            		             {Type:"Text",      Hidden:0,  Width:Title1,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:TYPE, Align:"Center",  ColMerge:0,   SaveName:"TYPE",      KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Title2,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Status,Align:"Left",    ColMerge:0,   SaveName:"Status",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            		             [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
            		             {Type:"Text",      Hidden:0,  Width:Title1,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:TYPE, Align:"Center",  ColMerge:0,   SaveName:"Yard",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Title2,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Status,Align:"Center",  ColMerge:0,   SaveName:"Date",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            		             [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
            		             {Type:"Text",      Hidden:0,  Width:Title1,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:TYPE, Align:"Left",    ColMerge:0,   SaveName:"Provider",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Title2,Align:"Center",  ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Status,Align:"Left",    ColMerge:0,   SaveName:"Cost",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }] ];
               
            		InitColumns(cols, 3);

            		SetEditable(0);
            		SetCountPosition(0);
            		SetRowHidden(0, 1);
            		drCnt++;
            		cnt=0;
            		drCnt++;
            		cnt=0;
            		SetDataRowHeight(10);
            		shtClear(sheetObj);
            		SetSheetHeight(80);
            	}
                break;
            case 4:      //t1sheet1 init
                with(sheetObj){
            		var HeadTitle="Status";
            		var Title1=90;
            		var  Title2=90;
            		var MVSTS=80;
            		var  MVSTDT=50;
            		var drCnt=0;

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

            		var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
            		             {Type:"Text",      Hidden:0,  Width:Title1,Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:MVSTS,Align:"Center",  ColMerge:0,   SaveName:"STS",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:Title2,Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:MVSTDT,Align:"Center",  ColMerge:0,   SaveName:"Date",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(0);
            		SetCountPosition(0);
            		SetRowHidden(0, 1);
                    SetDataRowHeight(10);
                    shtClear(sheetObj);
                    SetSheetHeight(65);
            	}
                break;
            case 5:      //sheet5 init
                with(sheetObj){
            		var HeadTitle="|Seq.|Yard|Date|Flag|Method|Created Date|Remark(s)";

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mnr_flg_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"mnr_flg_inp_dt",     KeyField:0,   CalcLogic:"",   Format:"YmdHm",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"mnr_flg_inp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mnr_flg_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
            		             ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetCountPosition(0);
                    //conversion of function[check again]CLT 					InitDataValid(0,  "mnr_flg_yd_cd", vtEngUpOther,"0123456789");
            		SetColProperty(0 ,"mnr_flg_yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            		SetSelectionMode(smSelectionRow);
//            		SetSheetHeight(190);
            		resizeSheet( sheetObj );
            	}
                break;
        }
    }
    // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	switch(sAction) {
        	case IBSEARCH:      //retrieving
                if(validateForm(sheetObj,formObj,sAction)){
                	allSheetClr();
				 	if(sheetObj.id =="sheet1"){
						formObj.f_cmd.value=SEARCH;
						//method change[check again]CLT
						rowTotal = 0;
						rtv_total=rowTotal;					
						if(Number(rowTotal) > formObj.pagerows.value) {
							ComBtnEnable("btn_more");
						}else{
							ComBtnDisable("btn_more");
						}
							
						appendPageNo=1;
						appendCondParam = FormQueryString(formObj);	
						sheetObj.DoSearch("EES_MNR_0122GS.do",FormQueryString(formObj) );
					}
				  }
                break;
			case IBSAVE:        //saving
				if(validateForm(sheetObj,formObj,sAction)){
					var sParam = sheetObj.GetSaveString(false);
					sParam=ComSetPrifix(sParam,"sheet1_");
					if(eq_knd_cd.GetSelectCode() == "U"){
						formObj.f_cmd.value = MULTI01;
						
						var sXml = sheetObj.GetSaveData("EES_MNR_0122GS.do", FormQueryString(formObj)+"&"+sParam);
						var opCntrs = ComGetEtcData(sXml,"op_cntrs");
						
						if(opCntrs != ""){
							if(!ComShowCodeConfirm("MNR00386", opCntrs)){
								return;
							}
						}
					}
					
					formObj.f_cmd.value=MULTI;
					
//					sheetObj.DoSave("EES_MNR_0122GS.do", FormQueryString(formObj),-1,false);
					var sXml = sheetObj.GetSaveData("EES_MNR_0122GS.do", FormQueryString(formObj)+"&"+sParam);
					err1 =  ComGetEtcData(sXml,"error1");
					err2 =  ComGetEtcData(sXml,"error2");
//					sheetObj.LoadSaveData(sXml);
					if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S") {
						if(err1 == "" && err2 == ""){
							ComShowCodeMessage("MNR00023",'');
						}else{
							if(err1 != ""){
								ComShowMessage(err1);
							}
							if(err2 != ""){
								ComShowMessage(err2);
							}
						}
					}else {    
						showErrorMsg(sXml);  
					}
				}
				break;
			case IBCLEAR: //  retrieving Combo Data and initializing sheet
                MnrWaitControl(true);
                sheetObj.SetWaitImageVisible(0);
				formObj.reset();
				// setting initial value
				formObj.mnr_flg_tp_cd.value=coMnrFlgDamageTypeCd;
				//initialzing IBMultiCombo combo
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].SetSelectCode("-1");
					comboObjects[i].RemoveAll();
				}
				//sheet combo variable
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboDefault="";
				var sCondition=new Array (
				    new Array("MnrGenCd","","CUSTOM9"),
					new Array("MnrGenCd","CD00005", "COMMON")
				)
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//setting IBMultiCombo-EQ_TYPE
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
						if(j == 0){
							eq_knd_cd.SetSelectCode(tempText[0]);
							sheetComboDefault=tempText[0];
						}
					}
				}
				//sheetObjects[0] setting EQ_KND_CD
				sheetComboText=MnrDelLastDelim(sheetComboText);
				sheetComboCode=MnrDelLastDelim(sheetComboCode);
				sheetObj.InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode,sheetComboDefault);
				//setting IBMultiCombo-flag_type
				flag_type.InsertItem(0, "ALL" ,"ALL");
				flag_type.InsertItem(1, "Flagged" ,"Y");
				flag_type.InsertItem(2, "Unflagged" ,"N");
				flag_type.SetSelectCode("ALL");
				//setting sheetObjects[4] mnr_flg_inp_tp_cd
				sheetComboText="";
				sheetComboCode="";
				sheetComboDefault="";
				if(comboList[1] != null){
			 		for(var j=0; j < comboList[1].length;j++){
						var tempText=comboList[1][j].split("|");
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						if(j ==0){
							sheetComboDefault=tempText[0];
						}
					}
				}
				//setting sheet combo.
				sheetComboText=MnrDelLastDelim(sheetComboText);
				sheetComboCode=MnrDelLastDelim(sheetComboCode);
				sheetObjects[4].InitDataCombo (0, "mnr_flg_inp_tp_cd", sheetComboText, sheetComboCode,sheetComboDefault);
				
				
				rtv_total = 0;
				formObj.pagerows.value=10000;
				
      	   		allSheetClr();
				sheetObj.SetWaitImageVisible(1);
                MnrWaitControl(false);
                
                if(strMnrOfficeLevel=="L3"){
					formObj.mnr_dmg_flg_yd_cd.value = getOfcLccCode(sheetObjects[0], currOfcCd);
					ComEnableObject(formObj.mnr_dmg_flg_yd_cd,false);
					ComEnableObject(formObj.btns_popup, false);
				}
				break;
				
			case IBSEARCHAPPEND:
	    		if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.DoSearch("EES_MNR_0122GS.do", appendCondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );  	   
		        
				break;
        }
    }
	function allSheetClr(){
		//initializing sheet
		for(i=0;i<sheetObjects.length;i++){
			shtClear(sheetObjects[i]);
		}
	}
	/**
     * retrieving history table
     */
	function doActionIBSheet2(sheetObj,formObj,sAction) {
        switch(sAction) {
           case IBSEARCH:      //retrieving
			    if(sheetObj.id =="sheet5"){
					formObj.f_cmd.value=SEARCH01;
					sheetObj.SetWaitImageVisible(0);
					sheetObj.DoSearch("EES_MNR_0122GS.do",FormQueryString(formObj) );
					sheetObj.SetWaitImageVisible(1);
				}
                break;
		}
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
     * initializing Tab
     * setting Tab items.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                }
             break;
         }
    }
	function initControl() {
	    //Axon handling event1. event catch
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  
	    //axon_event.addListenerFormat('focus',   'obj_activate',    form);            
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            
	}
	//Axon handling event2. handling event
	function obj_deactivate(){
	    ComChkObjValid(ComGetEvent());
	}
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	function obj_keypress(){
	    obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "ymd":
	        case "int":
				ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
				break;
	        case "engup":
				if(obj.name == "mnr_dmg_flg_yd_cd")
					ComKeyOnlyAlphabet('uppernum');
				else
					ComKeyOnlyAlphabet('uppernum','44');
	            break;
	    }
	}
	//eq_tpsz_cd multicombo click event
//	function eq_tpsz_cd_OnCheckClick(comboObj, index, code) {
//		MnrAllChkMultiCombo(comboObj,index);
//	}
	
	 var selComboIndex, selComboCode;
	 function eq_tpsz_cd_OnSelect(comboObj ,index, text , code) {
	  selComboIndex = index;
	  selComboCode = code;
	 }
	 
	 function eq_tpsz_cd_OnChange(comboObj) {
	     ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	 }
    /**
     * Event when clicking Tab
     * activating selected tab items.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSEARCH) {
				if (!ComChkValid(formObj)) return false;
				if(ComGetObjValue(formObj.mnr_dmg_flg_yd_cd) == "" && ComGetObjValue(formObj.eq_list) == ""){
					ComShowCodeMessage("MNR00223");
					return false;
				}
				
				if(ComGetObjValue(formObj.mnr_dmg_flg_yd_cd) != ""){
					if(ComGetObjValue(formObj.mnr_dmg_flg_yd_cd).length != 5 && ComGetObjValue(formObj.mnr_dmg_flg_yd_cd).length != 7){
						ComShowCodeMessage("MNR00374");
						ComSetFocus(formObj.mnr_dmg_flg_yd_cd);
						return false;
					}else{
						if(ComGetObjValue(formObj.mnr_dmg_flg_yd_cd).length == 5 )
							flg_yd_type.value = "L";
						else
							flg_yd_type.value = "Y";
					}
				}
				
			}   else if(sAction==IBSAVE){
				//checking whether saving or not saving
				if(!ComShowCodeConfirm("MNR00160","")){return false;}
			}
        }
        return true;
    }
	/**
	 * COM_ENS_061 receiving function values ​​from Pop-up
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "")
    	 	formObj.mnr_dmg_flg_yd_cd.value=aryPopupData[0][3];
    }
	/**
	 * getEES_MNR_139 receiving function values ​​from Pop-up
	 * @param Array[][]     aryPopupData		[0]EQNO   [1]YARD  [2]FLAGDATE
	 * @param Array[]       arrRetVal 	        [0]EQ_TYPE    [1]FLAG or UNFLAG
	 */
	function getEES_MNR_139(rArray,ret_val){
    	 var formObj=document.form;
		 var firstSelect=0;
		 eq_knd_cd.SetSelectCode(ret_val[0]);
    	 var mnr_dmg_flg="0";
		 if(ret_val[1] == "Y"){
		 	mnr_dmg_flg="1";
		 } else {
		 	mnr_dmg_flg="0";
		 }
		 for(var i=0;i <  rArray.length;i++){
		 	 var Row=sheetObjects[0].DataInsert(-1);
			 if(i == 0)
			 	 firstSelect=Row;
			 sheetObjects[0].SetCellValue(Row,"eq_knd_cd",eq_knd_cd.GetSelectCode(),0);
			 sheetObjects[0].SetCellValue(Row,"mnr_dmg_flg",mnr_dmg_flg,0);
			 sheetObjects[0].SetCellValue(Row,"eq_no",rArray[i][0],0);
			 sheetObjects[0].SetCellValue(Row,"mnr_dmg_flg_yd_cd",rArray[i][1],0);
			 sheetObjects[0].SetCellValue(Row,"mnr_dmg_flg_dt",rArray[i][2],0);
			 sheetObjects[0].SetCellValue(Row,"eq_tpsz_cd",rArray[i][3],0);
		 }
		 // retrieving after loading excel
		 if(firstSelect != 0) {
		 	sheetObjects[0].SelectCell(firstSelect, "eq_no");
		 	var keyvalue=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"eq_no");
			var formObj=document.form;
			formObj.eq_no.value=keyvalue;
		    // retrieving detail
		    doActionIBSheet2(sheetObjects[4], formObj, IBSEARCH);
		 }
    }
	/**
	 * eq_knd_cd Change event
	 * @param	{IBMultiCombo}		comboObj	comboObject
	 * @param 	{Number} 			Index_Code 	selected row
	 * @param 	{String} 			Text 		selected Text
	 */
	function eq_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;
		var comboValue=comboObj.GetSelectCode();
		eq_tpsz_cd.RemoveAll();
		var selTpSz=new Array();
		if(comboValue == "U"){
			selTpSz=uTpSz;
		} else if(comboValue == "G"){
			selTpSz=gTpSz;
		} else {
			selTpSz=zTpSz;
		}
		//setting default 'ALL'
		eq_tpsz_cd.InsertItem(0,"ALL","ALL");
		for(var i=1;i < (selTpSz.length + 1);i++){
			eq_tpsz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]);
		}
	}
	/**
	 * flag_type Change event
	 * @param	{IBMultiCombo}		comboObj	comboObject
	 * @param 	{Number} 			Index_Code 	selected row
	 * @param 	{String} 			Text 		selected Text
	 */
	function flag_type_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formobj=document.form;
		if(comboObj.GetSelectCode()== "N"){
			ComSetObjValue(formobj.mnr_dmg_flg_dt_over_day,"");
			MnrFormSetReadOnly(formobj,true,"mnr_dmg_flg_dt_over_day");
		} else {
			ComSetObjValue(formobj.mnr_dmg_flg_dt_over_day,"");
			MnrFormSetReadOnly(formobj,false,"mnr_dmg_flg_dt_over_day");
		}
	}
	function sheet1_OnPopupClick(sheetObj, row,col){
        if (sheetObj.ColSaveName(col) != "mnr_dmg_flg_dt") return;
        var cal=new ComCalendarGrid();
        cal.select(sheetObj, row, col, 'yyyy-MM-dd HH:mm');
    }
	//retrieving detail after list
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		var formObj=document.form;
		if (sheetObj.SearchRows()== 0) return;
		var sEqNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"eq_no");
	    var sEqType=eq_knd_cd.GetSelectCode();
	    var sTotalLossDate="";
		// retrieving history detail
		formObj.eq_no.value=sEqNo;
//		for(var i = sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
//			if(sheetObj.GetCellValue(i, "mnr_dmg_flg_dt") != ""){
//				var flgDt = sheetObj.GetCellValue(i, "mnr_dmg_flg_dt").substring(0,4) + "-" + sheetObj.GetCellValue(i, "mnr_dmg_flg_dt").substring(4,6) + "-" + sheetObj.GetCellValue(i, "mnr_dmg_flg_dt").substring(6,8);
//				var diff = sheet_dateDiff(flgDt, ComGetNowInfo("ymd")) + 1;
//				sheetObj.SetCellValue(i, "mnr_dmg_flg_dt_over_day", diff);
//				sheetObj.SetRowStatus(i, "R");
//			}else{
//				sheetObj.SetCellValue(i, "mnr_dmg_flg_dt_over_day", "");
//				sheetObj.SetRowStatus(i, "R");
//			}
//		}
		
		if(appendPageNo == 1){
    		rtv_total = sheetObj.GetEtcData("rtv_total");
    	}
    	if (sheetObj.RowCount()< rtv_total) {
            // setting page number for APPEND retrieving
            appendPageNo=Math.ceil(sheetObj.RowCount()/ formObj.pagerows.value) + 1;
            ComBtnEnable("btn_more");
        } else {
        	appendPageNo = 1;
            ComBtnDisable("btn_more");
        }	

	    doActionIBSheet2(sheetObjects[4], formObj, IBSEARCH);
		// retrieving EQ detail
		shtSetData(sheetObj,sEqType,sEqNo,sTotalLossDate);
		 
	}
	//showing message after saving
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			if(err1 == "" && err2 == ""){
				ComShowCodeMessage("MNR00023",'');
			}else{
				if(err1 != ""){
					ComShowMessage(err1);
				}
				if(err2 != ""){
					ComShowMessage(err2);
				}
			}
			
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
	function sheet1_OnDblClick(sheetObj,Row,Col){
		var formObj=document.form;
		if(Col != 6 && Col != 7 && Col != 9){
			var sEqNo=sheetObj.GetCellValue(Row ,"eq_no");
		    var sEqType=eq_knd_cd.GetSelectCode();
		    var sTotalLossDate="";
			// retrieving history detail
			formObj.eq_no.value=sEqNo;
		    doActionIBSheet2(sheetObjects[4], formObj, IBSEARCH);
			// retrieving EQ detail
			shtSetData(sheetObj,sEqType,sEqNo,sTotalLossDate);
		}
	}
	//checking yard validation
	function sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var retArray=null;
		if(sheetObj.ColSaveName(Col) == "mnr_dmg_flg_yd_cd"){
			var checkYard=sheetObj.GetCellValue(Row ,Col);
		    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
			if(retArray == null){
				ComShowCodeMessage("MNR00165",checkYard,"YARD");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			} else {
				return;
			}
		} else if(sheetObj.ColSaveName(Col) == "mnr_dmg_flg"){
			sheetObj.SetCellValue(Row ,"mnr_dmg_flg_dt",ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm"),0);
			var flgDt = sheetObj.GetCellValue(Row, "mnr_dmg_flg_dt").substring(0,4) + "-" + sheetObj.GetCellValue(Row, "mnr_dmg_flg_dt").substring(4,6) + "-" + sheetObj.GetCellValue(Row, "mnr_dmg_flg_dt").substring(6,8);
			var diff = sheet_dateDiff(flgDt, ComGetNowInfo("ymd")) + 1;
			sheetObj.SetCellValue(Row, "mnr_dmg_flg_dt_over_day", diff);
			
			if(sheetObj.GetCellValue(Row, "mnr_dmg_flg") == 1){
				sheetObj.SetCellValue(Row, "mnr_sts_rmk", "", 0);
			}
		}
	}
    // adding data on freeform sheet
    function shtSetData(sheetObj,sEqType,sEqNo,sTotalLossDate){
   	    var formObj=document.form;
   		var sCostType="";
		if(eq_knd_cd.GetSelectCode()== "U"){
			sCostType="MRDRRC";
		} else if(eq_knd_cd.GetSelectCode()== "G"){
			sCostType="MRGSRC";
		} else {
			sCostType="MRZSRC";
		}
		var sXml=MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr=MnrXmlToArray(sXml);
	 	//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr != null){
			with(sheetObjects[1]){
				var cnt=1;
                SetCellValue(cnt,2,retArr[0][7],0);		//manu_dt,lessor_nm
                SetCellValue(cnt,4,retArr[0][16],0);
                cnt++;
                SetCellValue(cnt,2,retArr[0][19],0);	//lstm_cd,dsp_flag
                SetCellValue(cnt,4,retArr[0][14],0);
                cnt++;
                SetCellValue(cnt,2,retArr[0][12],0);	//off_hire,imm_ext
                SetCellValue(cnt,4,retArr[0][0],0);
			}
			with(sheetObjects[2]){
				var cnt=1;
				SetCellText(cnt,2 ,retArr[0][30]);		//rpr_type,status
				SetCellText(cnt,4 ,retArr[0][23]);
                cnt++;
                SetCellText(cnt,2 ,retArr[0][4]);		//rpr_yd,rpr_dt
                SetCellText(cnt,4 ,retArr[0][32]);
                cnt++;
//				if(retArr[0][5] != null && retArr[0][5] != ""){
					SetCellText(cnt,2 ,retArr[0][5]);//sp_name     retArr[0][5]
					SetCellText(cnt,3 ,retArr[0][5]);//sp_name     retArr[0][5]
					SetCellText(cnt,4 ,retArr[0][5]);//sp_name     retArr[0][5]
//				}
				SetMergeCell(3,2,1,3); 
			}
			with(sheetObjects[3]){
				var cnt=1;
                SetCellText(cnt,2 ,retArr[0][13]);//mvmt_cd
                SetCellText(cnt,4 ,retArr[0][2]);//mvmt_dt
			}
		}
    }
    // setting title and design on freeform
    function shtClear(sheetObj){
    	var shtID=sheetObj.id;
    	switch(shtID)
    	{
   			case "sheet1":
				with(sheetObj)
                {
				 	RemoveAll();
				}
				break;
            case "sheet2":
                with(sheetObj){
                    RemoveAll();
                    var Row=DataInsert(-1);
                    var cnt=1;
                    SetCellValue(cnt,1,"M/facture DT",0);
                    SetCellValue(cnt,3,"Owner/Lessor",0);
                    cnt++;
                    SetCellValue(cnt,1,"Lease Term",0);
                    SetCellValue(cnt,3,"Disposal Flag",0);
                    cnt++;
                    SetCellValue(cnt,1,"Off-Hire",0);
                    SetCellValue(cnt,3,"Imm.Exit",0);
                    var titleColor="#E8EFF9";
                    SetColBackColor(1,titleColor);
                    SetColBackColor(3,titleColor);
                    SetCellFont("FontBold", 1, 1, LastRow(), 1,1 );
                    SetCellFont("FontBold", 1, 3, LastRow(), 3,1 );
                }
                break;
            case "sheet3":
                with(sheetObj)
                {
                    RemoveAll();
                    DataInsert(-1);
                    var cnt=1;
                    SetCellText(cnt,1 ,"Repair Type");
                    SetCellText(cnt,3 ,"Status");
                    cnt++;
                    SetCellText(cnt,1 ,"Repair Yard");
                    SetCellText(cnt,3 ,"Repair Date");
                    cnt++;
                    SetCellText(cnt,1 ,"S/Provider");
                    SetCellText(cnt,2 ," ");
                    SetCellText(cnt,3 ," ");
                    SetCellText(cnt,4 ," ");
					SetRowMerge(cnt,1);
                    var titleColor="#E8EFF9";
                    SetColBackColor(1,titleColor);
                    SetColBackColor(3,titleColor);
                    SetCellFont("FontBold", 1, 1, LastRow(), 1,1 );
                    SetCellFont("FontBold", 1, 3, LastRow(), 3,1 );
                }
                break;
            case "sheet4":
                with(sheetObj)
                {
                    RemoveAll();
                    DataInsert(-1);
                    var cnt=1;
                    SetCellText(cnt,1 ,"MVMT STS");
                    SetCellText(cnt,3 ,"MVMT Date");
                    var titleColor="#E8EFF9";
                    SetColBackColor(1,titleColor);
                    SetColBackColor(3,titleColor);
                    SetCellFont("FontBold", 1, 1, LastRow(), 1,1 );
                    SetCellFont("FontBold", 1, 3, LastRow(), 3,1 );
                }
                break;
            case "sheet5":
            	with(sheetObj)
                {
					RemoveAll();
				}
				break;
    	}
    	sheetObj.RenderSheet;
    }
	/**
	 * getting rep_Multiful_inquiry
	 * 
	 * Location : in case of Single choice
	 */
	function getMnr_Multi(rowArray,ret_val) {
		var formObj=document.form;
		var tempText="";
		//initializing
		formObj.eq_list.value='';
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//clearing comma(,)
		tempText=MnrDelLastDelim(tempText);
		tempText=tempText.toUpperCase();
		eval("document.form." + ret_val + ".value='" + tempText + "';");
	}
	/* developer job */
