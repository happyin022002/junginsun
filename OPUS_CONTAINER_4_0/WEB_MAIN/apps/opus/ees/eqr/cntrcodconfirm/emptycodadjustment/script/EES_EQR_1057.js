/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1057.js
*@FileTitle  : HR/ DMG MTY CNTR List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;

    document.onclick=processButtonClick;
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var sheetObject2=sheetObjects[2];
         var formObject=document.form;
         try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
	            case "btn_retrieve":
	                doActionIBSheet( sheetObject , formObject , IBSEARCH );
	            break;
	            case "btn_downexcel":
	            	if(sheetObjects[0].RowCount() < 1 && sheetObjects[1].RowCount() < 1 && sheetObjects[2].RowCount() < 1){
	            		ComShowCodeMessage("EQR01104");
	            	}else{
	            		if(sheetObjects[0].RowCount() > 0)sheetObjects[0].Down2Excel({ HiddenColumn:-1});
	            		if(sheetObjects[1].RowCount() > 0)sheetObjects[1].Down2Excel({ HiddenColumn:-1});
	            		if(sheetObjects[2].RowCount() > 0)sheetObjects[2].Down2Excel({ HiddenColumn:-1});
	            	}
	            break;
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
     * IBSheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    function initControl(){
        axon_event.addListenerForm  ( 'blur', 'obj_deactivate' , document.form ); 
        document.form.vvd.focus();
    }     
    /**
     * Sheet 
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        setHeadTitle();
    }
 	function sheet1_OnLoadFinish(sheetObj) {
        sheetObj.SetWaitImageVisible(0);
        doActionIBSheet(sheetObj, document.form,IBSEARCH_ASYNC01);
        doActionIBSheet(sheetObj, document.form , IBSEARCH );
        sheetObj.SetSelectRow(0);
        sheetObjects[1].SetSelectRow(0);
        sheetObjects[2].SetSelectRow(0);
		sheetObj.SetWaitImageVisible(1);
	} 
    function setHeadTitle(){
        var tVal=document.form.version.value;
        if ( tVal == "H" ) {
            HEADTITLE.innerText="Hanger Rack MTY CNTR List";            
        }else if ( tVal == "D" ) {
            HEADTITLE.innerText="Damage MTY CNTR List";
        }
    }    
 	/**
     * define sheet default
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1": 
                with(sheetObj){
	              var HeadTitle1="CNTR No.|TP/SZ|POL|POD|Bay|HB|BKG No.";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bay_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xxx",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetCountPosition(0);
	              SetSheetHeight(200);
            	}
                break;
            case "sheet2":      //sheet1 init
                with(sheetObj){
	              var HeadTitle1="CNTR No.|TP/SZ|POL|POD|Bay|HB|BKG No.";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bay_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xxx",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetCountPosition(0);
	              SetSheetHeight(200);
            	}
            	break;
            case "sheet3":      //sheet1 init
                with(sheetObj){
	              var HeadTitle1="Source|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var sumLine="|d2| + |d4| + |d5| + |d7| + |r2| + |r5| + |r9| + |o2| + |s2| + |o4| + |s4| + |o5| + |f2| + |a2| + |f4| + |a4| + |f5| " ;
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"src",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:47,   Align:"Right",   ColMerge:0,   SaveName:"total",  KeyField:0,   CalcLogic:sumLine,Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"d2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"d4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"d5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"d7",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"r2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"r5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"r9",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"o2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"s2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"o4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"s4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"o5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"f2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"a2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"f4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"a4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:46,   Align:"Right",   ColMerge:0,   SaveName:"f5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetCountPosition(0);
	              SetSheetHeight(100);
            	}
                break;
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:    
                if(validateForm(sheetObj,formObj,sAction)){
                    if (sheetObj.id == 'sheet1') { 
                        for( var i=0 ; i < sheetObjects.length ; i++ ){
                            sheetObjects[i].RemoveAll();
                        }               
                		sheetObj.SetWaitImageVisible(0);
                		ComOpenWait(true);
                        formObj.f_cmd.value=SEARCH;    
                        var sXml=sheetObj.GetSearchData("EES_EQR_1057GS.do", FormQueryString(formObj));
                        var arrXml=sXml.split("|$$|");
                        for( var i=0 ; i < arrXml.length ; i++ ){  
                            sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
                        }
                		sheetObj.SetWaitImageVisible(1);
                		ComOpenWait(false);
                    }                     
                } else {
                    return;
                }
            break;
            case IBSEARCH_ASYNC01:      // VVD
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value=SEARCH01;
                    sheetObj.SetWaitImageVisible(0);
                    var sXml=sheetObj.GetSearchData("EES_EQR_1056GS.do",FormQueryString(formObj));
                    var sCheck=ComGetEtcData(sXml, "pod_list");
                    if ( sCheck == "" ){
                        ComShowCodeMessage("EQR90185");
                        document.form.vvd.value="";
                        document.form.vvd.focus();
                        return false;
                    }else{
                        ComClearCombo( formObj.pod );
                        ComAddComboItem( formObj.pod , "" , "" );
                        var arrTpSz=sCheck.split("|");
                        for ( var i=0 ; i < arrTpSz.length ; i++ ){
                            ComAddComboItem( formObj.pod , arrTpSz[i] , arrTpSz[i] );
                        }
                    }                    
                    sheetObj.SetWaitImageVisible(1);
                } else {
                    return;
                }
            break;
        }
    }
    /**
     * validate input value
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(sAction == IBSEARCH){
                if(vvd.value == ""){
                    ComShowCodeMessage("EQR90213","VVD Code ");
                    ComSetFocus(vvd);
                    return false;
                }
            }
        }
        return true;
    }
    // Search end event
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
            sheetObj.SetCellText(1,0 ,"Master");
            sheetObj.SetCellText(2,0 ,"MTY BKG");
        }
    }    
    //Axon event
    function obj_deactivate() {
        switch (ComGetEvent("name")) {
            case "vvd":
                if(ComGetEvent().value != ""){
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH_ASYNC01 );
                }
            break;
        }           
        return true;
    }    
