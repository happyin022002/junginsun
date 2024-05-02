/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0172.js
*@FileTitle  : VGM EDI (Multi)
*@author     : CLT
*@version    : 1.0
*@since      : 2016/07/06
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var iStep = 0;  //0:first, 1:reSearch

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
	    var sheetObject1=sheetObjects[0];
	    var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_retrieve":
            	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
            	break;
			case "btn_EDITransmission":
				  var iCheckRow=sheetObjects[1].FindCheckedRow("slct_flg");
				  if(iCheckRow.length==0){
					  ComShowCodeMessage("BKG00155");
				  }else{
					  var arrRow=iCheckRow.split("|");
					doActionIBSheet(sheetObjects[0],formObject,"btn_EDITransmission");	
				  }
			    break; 
			case "btn_Yard":
				 var param="?pgmNo=ESM_BKG_0096&bkg_no="+ComGetObjValue(formObject.bkg_no);
				 param+="&callSheetIdx=2";
				 ComOpenPopup("ESM_BKG_0096.do"+param, 600, 400, '','1,0,1,1,1', true);
			    break; 
			case "btn_Close":
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
        for(var i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
        	ComEndConfigSheet(sheetObjects[i]);
        }
		if(!opener) {
			opener=parent;
		}
        document.form.bkg_nos.value = opener.form.bkg_no_list.value;
        document.form.cntr_nos.value = opener.form.cntr_no_list.value;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        case 'sheet1':      //sheet1 init
            with(sheetObj){
                var HeadTitle1="|BKG NO|CNTR NO|YARD|VGM|VGM";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Text",  Hidden:0, Width:100,   Align:"Left",  ColMerge:0,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Float",      Hidden:0,  Width:80,  Align:"Right",    ColMerge:0,   SaveName:"vgm_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",            PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:30,  Align:"Left",    ColMerge:0,   SaveName:"vgm_wgt_ut_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:1,  Width:30,  Align:"Left",    ColMerge:0,   SaveName:"bkg_ord",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
                
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                SetShowButtonImage(1);
                SetExtendLastCol(0);
                SetWaitTimeOut(30);
                SetSheetHeight(350);
            }
            break;
            case 'sheet2':      //sheet2 init
                with(sheetObj){
                    var HeadTitle1="|Sel.|EDI Kind|Code|Receiver(TP ID)|EDI Sender ID|";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slct_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"ntc_knd_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ref_code",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"edi_receive_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"edi_snd_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ntc_knd_cd"} ];
                    
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetCountPosition(0);
                    SetShowButtonImage(1);
                    SetExtendLastCol(0);
                    SetSheetHeight(350);
                }
                break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
		case IBSEARCH:      //Retrieve
            formObj.f_cmd.value=SEARCH;
            var rXml=sheetObj.GetSearchData("ESM_BKG_0172GS.do", FormQueryString(formObj));
			if(rXml.substring(1, 6) == "ERROR"){
				ComShowMessage(ComResultMessage(rXml));
			    ComOpenWait(false); 
				return false;
			}
			var arrXml=rXml.split("|$$|");
            var sheet1=arrXml[0];
			var sheet2=arrXml[1];
			sheetObjects[0].LoadSearchData(sheet1,{Sync:1} );
			sheetObjects[1].LoadSearchData(sheet2,{Sync:1} );
		    break;
		case "btn_EDITransmission":
			formObj.f_cmd.value=MULTI01;
        	var slt =  sheetObjects[1].GetSelectRow();
			formObj.slct_flg.value = sheetObjects[1].GetCellValue(slt,"slct_flg");
			formObj.ref_code.value = sheetObjects[1].GetCellValue(slt,"ref_code");
			formObj.edi_receive_id.value = sheetObjects[1].GetCellValue(slt,"edi_receive_id");
			formObj.ntc_knd_cd.value = sheetObjects[1].GetCellValue(slt,"ntc_knd_cd");
			formObj.edi_snd_id.value = sheetObjects[1].GetCellValue(slt,"edi_snd_id");
			var params=FormQueryString(formObj) + "&" + sheetObjects[0].GetSaveString(1);
//			params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
 			sXml=sheetObj.GetSaveData("ESM_BKG_0172GS.do", params);
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowMessage(msgs['BKG00693']);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			} else {
				sheetObj.LoadSaveData(sXml);
			}
		break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
		switch(sAction) {
		
			}
        }
        return true;
    }
	function sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
            for(i=1 ; i<=LastRow(); i++) {
                if (sheetObj.GetCellValue(i,"ntc_knd_cd").substr(1,1) == "M"){
                	SetCellEditable(i,"slct_flg",1);
                	SetCellEditable(i,"ref_code",1);
                	SetCellEditable(i,"edi_receive_id",1);
                	SetCellEditable(i,"edi_snd_id",1);
                }
            }
		}
	}
	/*
	* sheet1 OnChange Event
	*/
	function sheet2_OnChange(sheetObj,Row, Col, Value) {
		with (sheetObj) {
			var arrRow=ComFindText(sheetObj, "slct_flg", 1);
			if (arrRow && 0<arrRow.length) {
				for (var i=0; i<arrRow.length; i++) {
                    if (Row!=arrRow[i]) {
						SetCellValue(arrRow[i],"slct_flg",0,0);
					}
				}
			}
		}
	}

