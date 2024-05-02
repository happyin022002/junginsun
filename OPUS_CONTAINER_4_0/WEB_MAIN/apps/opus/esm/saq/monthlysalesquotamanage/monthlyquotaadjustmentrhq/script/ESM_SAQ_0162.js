/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0162.js
*@FileTitle  : Office Add
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
	var height=15;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var isParentRefresh=false;
    var pWindow="";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/*******************************************************/
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
//    		var srcObj=window.event.srcElement;
//    		if(window.event){
//    		      srcObj = window.event.srcElement;
//    		   }else{
//    			   srcObj = event.target;
//    		   }
//    		if(srcObj.GetEnable()!= undefined && !srcObj.GetEnable()) return;
    		switch(srcName) {
    		    case "btn_rowadd":
//    		         rowAdd(sheetObj);
    		         sheetObj.DataInsert(-1);
    		         break;
    			case "btn_save":
    			    if (validationData(sheetObj) == false) return;
    			    doActionIBSheet(sheetObj,formObj,IBSAVE);
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function loadPage(){
        var sheetObj=sheetObjects[0];
    	var formObj=document.form;
        pWindow=window;
    	pWindow.isParentRefresh=false;
//    	ComBtnDisable("btn_save");
    	for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }	
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var formObj=document.form;
        switch(sheetNo) {
    		case 1:      
    			with (sheetObj) {
	    	        var HeadTitle="|Sub-Trade|Lane|Area|Regional Office";
	    	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	    	        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	    	        var headers = [{ Text:HeadTitle, Align:"Center"}];
	    	        InitHeaders(headers, info);
	    	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	    	               {Type:"Combo",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sub_trd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	               {Type:"Combo",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lane",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	               {Type:"Combo",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"area",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	               {Type:"Combo",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"contract",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	    	        InitColumns(cols);
	    	        SetEditable(1);
	    	        SetSheetHeight(ComGetSheetHeight(sheetObj,height));
	
	    	        // shearch 시  init시 세팅하지 않아서 값이 세팅되지 않는것을 막기 위해서 사용
	    	        // 즉 콤보에 일치하지 않는 데이터 일경우 조회한 값을 보여준다.
	    	        InitComboNoMatchText(1,"",1);
	    	        
	    	        var params="f_cmd="+SEARCHLIST
			        + "&mcode=SaqMonQtaRhqOfficeAddSubtrd"
			        + "&mqta_step_cd=" + formObj.mqta_step_cd.value
					+ "&bse_yr="       + formObj.bse_yr.value
					+ "&trd_cd="       + formObj.trd_cd.value 
					+ "&dir_cd="       + formObj.dir_cd.value
					+ "&mqta_ver_no="  + formObj.mqta_ver_no.value;    	        
	                var rtn=getCodeXmlList("SaqMonQtaRhqOfficeAddSubtrd", params);
	                var arrData=SaqXml2ComboItem(rtn, "code", "text");
	                arrData[0]=" |" + arrData[0];
	                SetColProperty("sub_trd", {ComboText:arrData[0], ComboCode:arrData[0]} );
                
    	        }
    			break;
        }
    }
    // add row
//    function rowAdd(sheetObj) {
//        var formObj=document.form;
//        //sub_trd List
//        var params="f_cmd="+SEARCHLIST
//    		        + "&mcode=SaqMonQtaRhqOfficeAddSubtrd"
//    		        + "&mqta_step_cd=" + formObj.mqta_step_cd.value
//    				+ "&bse_yr="       + formObj.bse_yr.value
//    				+ "&trd_cd="       + formObj.trd_cd.value 
//    				+ "&dir_cd="       + formObj.dir_cd.value
//    				+ "&mqta_ver_no="  + formObj.mqta_ver_no.value;
//        createCodeSheetObject();
//        with(sheetObj){
//        	DoSearch("ESM_SAQ_CODGS.do", params );
//            var text="| "; 
//            for(var i=1 ; i <= RowCount(); i++){
//                text=text + "|" + GetCellText(i, "CODE");
//            }
//        }
//        var insertRow=sheetObj.DataInsert(-1);
//        sheetObj.InitCellProperty(insertRow, "sub_trd" ,{ Type:"Combo"} );
//        sheetObj.InitCellProperty(insertRow, "lane"    ,{ Type:"Combo"} );
//        sheetObj.InitCellProperty(insertRow, "area"    ,{ Type:"Combo"} );
//        sheetObj.InitCellProperty(insertRow, "contract",{ Type:"Combo"} );
//        sheetObj.CellComboItem(insertRow,"sub_trd", {ComboText:text, ComboCode:text} );
//    	sheetObj.CellComboItem(insertRow,"lane", {ComboText:"", ComboCode:""} );
//    	sheetObj.CellComboItem(insertRow,"area", {ComboText:"", ComboCode:""} );
//    	sheetObj.CellComboItem(insertRow,"contract", {ComboText:"", ComboCode:""} );
//    	ComBtnEnable("btn_save");
//    }
    function initData(sheetObj){
        var sRow=sheetObj.FindStatusRow("R");
        var arrRow=sRow.split(";");
        for (idx=0; idx<arrRow.length-1; idx++){
            sheetObj.SetRowEditable(arrRow[idx],0);
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
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //retrieve
    			formObj.f_cmd.value=SEARCHLIST;
    			sheetObj.DoSearch("ESM_SAQ_0162GS.do", saqFormString(formObj) );
    			break;
    		case IBSAVE:        //save
    		    formObj.f_cmd.value=MODIFY01;
    		    rhqAdjSheet.DoSave("ESM_SAQ_0162GS.do", saqFormString(formObj), "ibflag", false);
    		    break;
    	}
    }
    function rhqAdjSheet_OnSearchEnd(sheetObj, ErrMsg){
        initData(sheetObj);
    }
    function rhqAdjSheet_OnChange(sheetObj, row, col, value){
        var formObj=document.form;
        if(sheetObj.ColSaveName(col) == "sub_trd"){
            sheetObj.SetCellValue(row, "lane","");
            if(sheetObj.GetComboInfo(row, "sub_trd", "SelectedIndex") == 0){
                sheetObj.CellComboItem(row,"lane", {ComboText:"", ComboCode:""} );
            }else{
                var params="f_cmd="+SEARCHLIST
            		        + "&mcode=SaqMonQtaRhqOfficeAddLane"
            		        + "&mqta_step_cd=" + formObj.mqta_step_cd.value
            				+ "&bse_yr="       + formObj.bse_yr.value
            				+ "&trd_cd="       + formObj.trd_cd.value 
            				+ "&dir_cd="       + formObj.dir_cd.value
            				+ "&mqta_ver_no="  + formObj.mqta_ver_no.value
            				+ "&sub_trd_cd="   + sheetObj.GetCellValue(row, "sub_trd");
                createCodeSheetObject();
                with(codeSheet){
//                	DoSearch("ESM_SAQ_CODGS.do", params );
                	var sXml=GetSearchData("ESM_SAQ_CODGS.do", params);
                    if (sXml != "") LoadSearchData(sXml,{Sync:1} );
                	
                    var text="";
                    for(var i=1 ; i <= RowCount(); i++){
                        text=text + "|" + GetCellText(i, "CODE");
                    }
                }
                sheetObj.CellComboItem(row,"lane", {ComboText:text, ComboCode:text} );
            }
        }
        if(sheetObj.ColSaveName(col) == "lane"){
            sheetObj.SetCellValue(row, "area","");
            sheetObj.SetCellValue(row, "contract","");
            if(sheetObj.GetComboInfo(row, "lane", "SelectedIndex") == 0){
                sheetObj.CellComboItem(row,"area", {ComboText:"", ComboCode:""} );
            }else{
                var params="f_cmd="+SEARCHLIST
                		    + "&mcode=SaqMonQtaRhqOfficeAddArea"
                            + "&rhq_cd="       + formObj.rhq_cd.value
                            + "&mqta_step_cd=" + formObj.mqta_step_cd.value
                			+ "&bse_yr="       + formObj.bse_yr.value
                			+ "&bse_qtr_cd="   + formObj.bse_qtr_cd.value
                			+ "&trd_cd="       + formObj.trd_cd.value 
                			+ "&dir_cd="       + formObj.dir_cd.value
                			+ "&mqta_ver_no="  + formObj.mqta_ver_no.value
                			+ "&rlane_cd="     + sheetObj.GetCellValue(row, "lane");
                createCodeSheetObject();
                with(codeSheet){
//                	DoSearch("ESM_SAQ_CODGS.do", params );
                	var sXml=GetSearchData("ESM_SAQ_CODGS.do", params);
                    if (sXml != "") LoadSearchData(sXml,{Sync:1} );  
                    
                    var text="";
                    for(var i=1 ; i <= RowCount(); i++){
                        text=text + "|" + GetCellText(i, "CODE");
                    }
                    sheetObj.CellComboItem(row,"area", {ComboText:text, ComboCode:text} );
                }
            }
        }
        if(sheetObj.ColSaveName(col) == "lane" || sheetObj.ColSaveName(col) == "area"){
            sheetObj.SetCellValue(row, "contract","");
            var params="f_cmd="+SEARCHLIST
        		        + "&mcode=SaqMonQtaRhqOfficeAddContOffice"
                        + "&rhq_cd="       + formObj.rhq_cd.value
                        + "&mqta_step_cd=" + formObj.mqta_step_cd.value
        			    + "&bse_yr="       + formObj.bse_yr.value
        			    + "&bse_qtr_cd="   + formObj.bse_qtr_cd.value
        		    	+ "&trd_cd="       + formObj.trd_cd.value 
        			    + "&dir_cd="       + formObj.dir_cd.value
        		    	+ "&mqta_ver_no="  + formObj.mqta_ver_no.value
        		    	+ "&rlane_cd="     + sheetObj.GetCellValue(row, "lane")
        		    	+ "&area_cd="      + sheetObj.GetCellValue(row, "area");
            createCodeSheetObject();
            with(codeSheet){
//            	DoSearch("ESM_SAQ_CODGS.do", params );
            	var sXml=GetSearchData("ESM_SAQ_CODGS.do", params);
                if (sXml != "") LoadSearchData(sXml,{Sync:1} );
                
                var text=""; 
                for(var i=1 ; i <= RowCount(); i++){
                    text=text + "|" + GetCellText(i, "CODE");
                }
            }
            sheetObj.CellComboItem(row,"contract", {ComboText:text, ComboCode:text} );
        }
    }
    function rhqAdjSheet_OnSaveEnd(sheetObj, ErrMsg){
        if(sheetObj.GetEtcData("status") == "OK"){
            sheetObj.SetEtcData("status","NO");
            //isParentRefresh = true;
            pWindow.isParentRefresh=true;
            ComBtnDisable("btn_save");
            var msgList=sheetObj.GetEtcData("saveList");
            if (msgList != "") {
    			var msg=getMsg("SAQ90152", msgList);
    			showMsgWindow(msg, "0");	
            }
        }
        var formObj=document.form;
        doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }
    function validationData(sheetObj){
        var duprows = sheetObj.ColValueDupRows("sub_trd|lane|area|contract");
        var arrRow=duprows.split(",");
        if(arrRow != "") {
            for(idx=arrRow.length; idx>0; idx--){
                sheetObj.RowDelete(arrRow[idx-1], false);
            }
        }
        //no support[check again]CLT var colTrans=sheetObj.GetTransColText("I", "ibflag");
//        var colTrans = sheetObj.GetTransColText("I", "ibflag");
//        var arrCol=colTrans.split(";");
//        for(i=0; i<arrCol.length-1; i++){
//            row=arrCol[i].split("=");
//            if(sheetObj.GetComboInfo(row[0], "sub_trd" , "SelectedIndex") == 0)
//               sheetObj.RowDelete(row[0], false);
//        }
        return true;
    }
    
    function callBackReturnString(rtnValue){
    	return rtnValue;
    }
