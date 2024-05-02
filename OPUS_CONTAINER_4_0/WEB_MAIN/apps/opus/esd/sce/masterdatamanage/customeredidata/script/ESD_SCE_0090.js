/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : something.js
*@FileTitle  : Some Title 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

// Global variable
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event
document.onclick=processButtonClick;

    function processButtonClick(){
    	var sheetObject0=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
        var srcName=ComGetEvent("name");
        switch(srcName) {
        	case "btng_add1":
        		var newWin =  ComOpenWindow("ESD_SCE_0062.do?mycust=1",  window,  "width=700,height=470,scroll:no;status:no;resizable:yes;help:no;" , false);
                break;
            case "btng_add2":
//            	var newWin =  ComOpenWindow("ESD_SCE_0073.do?newOld=3",  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:700px;dialogHeight:470px" , true);
            	var newWin =  ComOpenWindow("ESD_SCE_0073.do?newOld=3",  window,  "width=700,height=470,scroll:no;status:no;resizable:yes;help:no;" , false);
                break;                                                                                  
            case "btn_save1":
                if(formObject.f_cnt.value < 1 ){
                    return false;
                }
                doActionIBSheet0(sheetObject0,formObject,IBDELETE);
                formObject.f_cnt.value=0;
                break;
            case "btn_save2":
                if(formObject.f_cnt1.value < 1 ){
                    return false;
                }
                doActionIBSheet1(sheetObject1,formObject,IBDELETE);
                formObject.f_cnt1.value=0;
                break;
            case "btn_delete1":
                deletefunction(sheetObject0,formObject,1);
                break;
            case "btn_delete2":
                deletefunction(sheetObject1,formObject,2);
                break;
        }
    }
    
    function deletefunction(sheetObject,formObject,custPer){
        var chkcnt=sheetObject.GetSelectRow();
        if(chkcnt < 1 ){
            ComShowMessage('Please select at least one.');
            return false;
        }
        var chkrow=sheetObject.FindCheckedRow(0).split('|');
        var temp_group_id="";
        var temp_tp_id="";
        var temp_group_name="";
        var group_id="";
        var tp_id="";
        var group_name="";
        for(var k=0 ; k < chkcnt ; k++){
        	group_id=sheetObject.GetCellValue(chkrow[k],"edi_grp_cd");
        	tp_id=sheetObject.GetCellValue(chkrow[k],"cust_trd_prnr_id");
        	group_name=sheetObject.GetCellValue(chkrow[k],"edi_grp_desc");
            if(k == 0){
                temp_group_id=group_id;
                temp_tp_id=tp_id;
                temp_group_name=group_name;
            } else {
                temp_group_id=temp_group_id +","+ group_id;
                temp_tp_id=temp_tp_id +","+ tp_id;
                temp_group_name=temp_group_name +","+group_name;
            }
            sheetObject.SetRowHidden(chkrow[k],1);
        }
        formObject.f_group_id.value=temp_group_id;
        formObject.f_tp_id.value=temp_tp_id;
        formObject.f_group_name.value=temp_group_name;
        if(custPer == "1"){
            formObject.f_cnt.value=chkcnt;
        } else {
            formObject.f_cnt1.value=chkcnt;
        }
    }
    
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
        }
        var formObject=document.form;
        doActionIBSheet0(sheetObjects[0],formObject,IBSEARCH);
        doActionIBSheet1(sheetObjects[1],formObject,IBSEARCH);
    }
    
    function initSheet(sheetObj,sheetNo){
        var cnt=0 ;
        switch(sheetNo) {
            case 1:      //sheet1 init
            	with(sheetObj){
            		var HeadTitle="|Group ID|Customer TP ID|Group Name";

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ 
            		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
            		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"edi_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
            		             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"cust_trd_prnr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
            		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"edi_grp_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetSheetHeight(300);
            	}
            	break;
            case 2:
                with(sheetObj){
            		var HeadTitle="|Report Name|Group ID|Group Name";

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ 
            		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
            		             {Type:"Text",      Hidden:0,  Width:230,  Align:"Center",  ColMerge:1,   SaveName:"edi_cgo_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
            		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"edi_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
            		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"edi_grp_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
            		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cust_trd_prnr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
//            		SetSheetHeight(150);
            		resizeSheet(); 
            	}
                break;
        }
    }
    
    function doActionIBSheet0(sheetObj,formObj,sAction){
        sheetObj.ShowDebugMsg(false);
        switch(sAction){
            case IBSEARCH:      // search
               formObj.f_cmd.value=SEARCH01;
//method change[check again]CLT
               sheetObj.DoSearch("ESD_SCE_0090GS.do", FormQueryString(formObj) );
               break;
            case IBDELETE:
               formObj.f_cmd.value=REMOVE01;
               sheetObj.DoSave("ESD_SCE_0090GS.do", FormQueryString(formObj),"ibflag");
               formObj.f_cmd.value=SEARCH01;
//method change[check again]CLT
               sheetObj.DoSearch("ESD_SCE_0090GS.do", FormQueryString(formObj) );
               break;
        }
    }
    
    function doActionIBSheet1(sheetObj,formObj,sAction){
        sheetObj.ShowDebugMsg(false);
        switch(sAction){
            case IBSEARCH:      // search
               formObj.f_cmd.value=SEARCH02;
//method change[check again]CLT
               sheetObj.DoSearch("ESD_SCE_0090GS.do", FormQueryString(formObj) );
               break;
            case IBDELETE:
               formObj.f_cmd.value=REMOVE02;
               sheetObj.DoSave("ESD_SCE_0090GS.do", FormQueryString(formObj),"ibflag");
               formObj.f_cmd.value=SEARCH02;
//method change[check again]CLT
               sheetObj.DoSearch("ESD_SCE_0090GS.do", FormQueryString(formObj) );
               break;
        }
    }
    
    function t1sheet_OnSearchEnd(sheetObj,ErrMsg){
       with(sheetObj){
           var rowCnt=sheetObj.Rowcount;
           if(rowCnt != 0){
               for(var i=1 ; i <= (rowCnt) ; i++){
//parameter changed[check again]CLT
            	   sheetObj.SetCellFontUnderline(i,1,1);
               }
           }
       }
    }
    
    function t1sheet_OnDblClick(sheetObj,Row,Col){
    	var formObject=document.form;
        var colName=sheetObj.ColSaveName(Col);
        var repNm=sheetObj.GetCellValue(Row,"edi_cgo_rmk");
        var groupId=sheetObj.GetCellValue(Row,"edi_grp_cd");
        var groupNm=sheetObj.GetCellValue(Row,"edi_grp_desc");
        var tpId=sheetObj.GetCellValue(Row,"cust_trd_prnr_id");
        if(colName == "edi_cgo_rmk") {
            var param="&repNm="+encodeURIComponent(repNm)+"&grpId="+groupId+"&grpNm="+groupNm+"&tpId="+tpId;
            var newWin =  ComOpenWindow("ESD_SCE_0073.do?newOld=4"+param,  window,  "width=700,height=470,scroll:no;status:no;resizable:yes;help:no;" , false);
                                                                                     
        }
    }
    
    function t1sheet_OnMouseMove(sheetObj,Button, Shift, X, Y){
        var sText=sheetObj.GetCellText(sheetObj.MouseRow(), sheetObj.MouseCol());
        var col=sheetObj.MouseCol();
        var row=sheetObj.MouseRow();
        if(col == 1 && sText !=""){
            sheetObj.SetMousePointer("Hand");
        } else {
            sheetObj.SetMousePointer("Default");
        }
    }
    
    function openfunction(){
        var formObject=document.form;
        doActionIBSheet0(sheetObjects[0],formObject,IBSEARCH);
        doActionIBSheet1(sheetObjects[1],formObject,IBSEARCH);
        
        //formObject.action="ESD_SCE_0090.do?pgmNo=ESD_SCE_0090&sysCommUiTitle=My Page&sysCommUiNavigation=Service Delivery > SCEM > Visibility";
    	//formObject.submit();
    }
    function resizeSheet(){
        ComResizeSheet(sheetObjects[1]);
    } 
