// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
  
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    function processButtonClick(){
    	  var sheetObject0 = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];

        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {
            case "btng_add1":
                // mycust가 1일 경우 버튼 들 숨겨라~~~
//                window.open ("ESD_SCE_0062.do?mycust=1", "list", "scrollbars=no,resizable=yes,fullscreen=no,width=500,height=510");
            	var newWin = window.showModalDialog("ESD_SCE_0062.do?mycust=1", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:500px");
                break;

            case "btng_add2":
//                window.open ("ESD_SCE_0073.do?newOld=3", "performance", "scrollbars=no,resizable=yes,fullscreen=no,width=500,height=480");
            	var newWin = window.showModalDialog("ESD_SCE_0073.do?newOld=3&pgmNo=ESD_SCE_0090", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:470px");
                break;

            case "btn_save1":
                if(formObject.f_cnt.value < 1 ){
//                    ComShowMessage('first delete button');
                    return false;
                }
                doActionIBSheet0(sheetObject0,formObject,IBDELETE);
                formObject.f_cnt.value = 0;
                break;

            case "btn_save2":
                if(formObject.f_cnt1.value < 1 ){
//                    ComShowMessage('first delete button');
                    return false;
                }
                doActionIBSheet1(sheetObject1,formObject,IBDELETE);
                formObject.f_cnt1.value = 0;
                break;

            case "btn_delete1":
                deletefunction(sheetObject0,formObject,1);
//                doActionIBSheet0(sheetObject0,formObject,IBDELETE);
//                sheetObject0.RemoveAll();
//                formObject.reset();
                break;

            case "btn_delete2":
                deletefunction(sheetObject1,formObject,2);
//                doActionIBSheet1(sheetObject1,formObject,IBDELETE);
                break;
        }
    }

    function deletefunction(sheetObject,formObject,custPer){
        var chkcnt = sheetObject.CheckedRows(0);
        if(chkcnt < 1 ){
            ComShowMessage('Please select at least one.');
            return false;
        }
        var chkrow = sheetObject.FindCheckedRow(0).split('|');
        var temp_group_id = "";
        var temp_tp_id = "";
        var temp_group_name = "";
        var group_id = "";
        var tp_id = "";
        var group_name = "";

//        if(diff == 1){
            for(var k = 0 ; k < chkcnt ; k++){
                group_id = sheetObject.CellValue(chkrow[k],"edi_grp_cd");
                tp_id = sheetObject.CellValue(chkrow[k],"cust_trd_prnr_id");
                group_name = sheetObject.CellValue(chkrow[k],"edi_grp_desc");

                if(k == 0){
                    temp_group_id = group_id;
                    temp_tp_id = tp_id;
                    temp_group_name = group_name;
                } else {
                    temp_group_id = temp_group_id +","+ group_id;
                    temp_tp_id = temp_tp_id +","+ tp_id;
                    temp_group_name = temp_group_name +","+group_name;
                }
                sheetObject.RowHidden(chkrow[k]) = true;
            }
//       }
        formObject.f_group_id.value = temp_group_id;
        formObject.f_tp_id.value = temp_tp_id;
        formObject.f_group_name.value = temp_group_name;
        if(custPer == "1"){
            formObject.f_cnt.value = chkcnt;
        } else {
            formObject.f_cnt1.value = chkcnt;
        }
    }

    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
        }
        var formObject = document.form;
        doActionIBSheet0(sheetObjects[0],formObject,IBSEARCH);
        doActionIBSheet1(sheetObjects[1],formObject,IBSEARCH);
    }

    function initSheet(sheetObj,sheetNo){
        var cnt = 0 ;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    style.height = GetSheetHeight(5) ;
                    sheetObj.MessageText("MessageShowLevel")="";

                    SheetWidth = mainTable.clientWidth;
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				MergeSheet = msHeaderOnly;
    				Editable = true;
    				InitRowInfo( 1, 1, 10, 50);
    				InitColumnInfo(4, 1, 0, true);
    				InitHeadMode(true, true, false, true, false,false);

    				var HeadTitle = "|Group ID|Customer TP ID|Group Name";

    				InitHeadRow(0, HeadTitle, true);

    				/*InitDataProperty(0, cnt++ , dtCheckBox,     30,    daCenter,  false,    "flag",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         150,    daCenter,  true,    "group_no",         false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         180,    daCenter,  true,    "cutomer_no",         false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         200,    daCenter,  true,    "group_name",        false,          "",      dfNone,      0,     false,       true,          30);*/
					InitDataProperty(0, cnt++ , dtCheckBox,     30,    daCenter,  false,    "ibflag",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         150,    daCenter,  true,    "edi_grp_cd",         false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         180,    daCenter,  true,    "cust_trd_prnr_id",         false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         200,    daCenter,  true,    "edi_grp_desc",        false,          "",      dfNone,      0,     false,       true,          30);
                }
                break;

            case 2:
                with (sheetObj) {
                    style.height = GetSheetHeight(5) ;

                    sheetObj.MessageText("MessageShowLevel")="";

                    SheetWidth = mainTable.clientWidth;

                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    MergeSheet = msHeaderOnly;

    				Editable = true;

    				InitRowInfo( 1, 1, 10, 50);

    				InitColumnInfo(5, 1, 0, true);

    				InitHeadMode(true, true, false, true, false,false)

    				var HeadTitle = "|Report Name|Group ID|Group Name";

    				InitHeadRow(0, HeadTitle, true);

    				/*InitDataProperty(0, cnt++ , dtCheckBox,     30,    daCenter,  false,    "flag",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         230,    daCenter,  true,    "group_no",         false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         150,    daCenter,  true,    "cutomer_no",         false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         150,    daCenter,  true,    "group_name",        false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtHidden,       120,    daCenter,  true,    "tp_id",        false,          "",      dfNone,      0,     false,       true,          30);*/
					InitDataProperty(0, cnt++ , dtCheckBox,     30,    daCenter,  false,    "ibflag",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         230,    daCenter,  true,    "edi_cgo_rmk",         false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         150,    daCenter,  true,    "edi_grp_cd",         false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         150,    daCenter,  true,    "edi_grp_desc",        false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtHidden,       120,    daCenter,  true,    "cust_trd_prnr_id",        false,          "",      dfNone,      0,     false,       true,          30);
                }
                break;
        }
    }

    function doActionIBSheet0(sheetObj,formObj,sAction){
        sheetObj.ShowDebugMsg = false;

        switch(sAction){
            case IBSEARCH:      // search
//               initSheet(sheetObj,1);
//               sheetObj.removeAll();
               formObj.f_cmd.value = SEARCH01;
			   sheetObj.DoSearch4Post("ESD_SCE_0090GS.do", SceFrmQryString(formObj));
               break;

            case IBDELETE:
               formObj.f_cmd.value = REMOVE01;
               sheetObj.DoSave("ESD_SCE_0090GS.do", SceFrmQryString(formObj),"ibflag");
               formObj.f_cmd.value = SEARCH01;
               sheetObj.DoSearch4Post("ESD_SCE_0090GS.do", SceFrmQryString(formObj));
               break;
        }
    }

    function doActionIBSheet1(sheetObj,formObj,sAction){
        sheetObj.ShowDebugMsg = false;

        switch(sAction){
            case IBSEARCH:      // search
               formObj.f_cmd.value = SEARCH02;
               sheetObj.DoSearch4Post("ESD_SCE_0090GS.do", SceFrmQryString(formObj));
               break;

            case IBDELETE:
               formObj.f_cmd.value = REMOVE02;
               sheetObj.DoSave("ESD_SCE_0090GS.do", SceFrmQryString(formObj),"ibflag");
               formObj.f_cmd.value = SEARCH02;
               sheetObj.DoSearch4Post("ESD_SCE_0090GS.do", SceFrmQryString(formObj));
               break;

        }
    }

    function t1sheet_OnSearchEnd(sheetObj,ErrMsg){
       with(sheetObj){
           var rowCnt = sheetObj.Rowcount;
           if(rowCnt != 0){
               for(var i = 1 ; i <= (rowCnt) ; i++){
                   sheetObj.CellFontUnderline(i,1) = true;
               }
           }
       }
    }

    function t1sheet_OnDblClick(sheetObj,Row,Col){
    		var formObject = document.form;
        var colName = sheetObj.ColSaveName(Col);
        var repNm = sheetObj.cellValue(Row,"edi_cgo_rmk");
        var groupId = sheetObj.cellValue(Row,"edi_grp_cd");
        var groupNm = sheetObj.cellValue(Row,"edi_grp_desc");
        var tpId = sheetObj.cellValue(Row,"cust_trd_prnr_id");
        
        if(colName == "edi_cgo_rmk") {
            var param = "&repNm="+encodeURIComponent(repNm)+"&grpId="+groupId+"&grpNm="+groupNm+"&tpId="+tpId;
//            window.open("ESD_SCE_0073.do?newOld=4"+param, "performance", "scrollbars=no,resizable=yes,fullscreen=no,width=500,height=480");
            var newWin = window.showModalDialog("ESD_SCE_0073.do?newOld=4&pgmNo=ESD_SCE_0090"+param, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:470px");
        }
    }

    function t1sheet_OnMouseMove(sheetObj,Button, Shift, X, Y){
        var sText = sheetObj.CellText(sheetObj.MouseRow, sheetObj.MouseCol);
        var col = sheetObj.MouseCol;
        var row = sheetObj.MouseRow;
        if(col == 1 && sText !=""){
            sheetObj.MousePointer = "Hand";
        } else {
            sheetObj.MousePointer = "Default";
        }
    }

    function openfunction(){
        var formObject = document.form;
        formObject.action = "ESD_SCE_0090.do?pgmNo=ESD_SCE_0090&sysCommUiTitle=My Page&sysCommUiNavigation=Service Delivery > SCEM > Visibility";
    	formObject.submit();
    }