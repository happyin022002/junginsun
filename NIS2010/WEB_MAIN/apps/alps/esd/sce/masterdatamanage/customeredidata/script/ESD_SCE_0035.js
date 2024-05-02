// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;



var isSearch = false;

var selRow = 0;
var isFirst1 = 0;
var isFirst2 = 0;
var grp_cust;

var firstSel = -1;

// 공통전역변수
var PageNo =1 ;
var etaDate1 = "";
var etaDate2 = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject0 = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
         var prefix1 = "sheet1_";
         var prefix2 = "sheet2_";
//         var prefix3 = "sheet3_";
         
         /*******************************************************/
         var formObject = document.form;

    		var srcName = window.event.srcElement.getAttribute("name");
    		if(srcName != 'vvd' &&
	    		srcName != 'bkg_no_' &&
	    		srcName != 'bl_no_' &&
	    		srcName != 'cntr_no_' &&
	    		srcName != 'por' &&
	    		srcName != 'pol' &&
	    		srcName != 'pod' &&
	    		srcName != 'del' &&
	    		srcName != 'cs_grp_id' &&
	    		srcName != 'edi_sts'){
	    		formObject.vvd.value = toUpperCase(formObject.vvd.value);
	    		formObject.bkg_no_.value = toUpperCase(formObject.bkg_no_.value);
	    		formObject.bl_no_.value = toUpperCase(formObject.bl_no_.value);
	    		formObject.cntr_no_.value = toUpperCase(formObject.cntr_no_.value);
	    		formObject.edi_sts.value = toUpperCase(formObject.edi_sts.value);
	    		formObject.por.value = toUpperCase(formObject.por.value);
	    		formObject.pol.value = toUpperCase(formObject.pol.value);
	    		formObject.pod.value = toUpperCase(formObject.pod.value);
	    		formObject.del.value = toUpperCase(formObject.del.value);
	    		formObject.cs_grp_id.value = toUpperCase(formObject.cs_grp_id.value);
    		}

            switch(srcName) {
        	    case "btn_retrieve":
                    doActionIBSheet0(sheetObject0,formObject,IBSEARCH);
                    doActionIBSheet1(sheetObject1,formObject,IBSEARCH);
//                    doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
        	        break;
                case "btn_new":
                    sheetObject0.removeAll();
                    sheetObject1.removeAll();
//                    sheetObject2.removeAll();
                    formObject.reset();
                    break;

                case "btn_cop":

                   if(beforetab == 0){

                       var rowCHK = "";
                       var ii = 0;

                       for(var i = 1 ; i < sheetObject0.rowcount+1 ; i++){

                            rowCHK = sheetObject0.CellText(i,"flag");
                            if(rowCHK == 1){
                        	   ii = ii + 1;
                    	   }
                       }

                       if(ii > 1){
                           alert("Multi Row Selected!!");

                           return;
                       }
                       
                       formObject.f_cmd.value = "" ;
                       formObject.cop_no.value = sheetObject0.CellText(sheetObject0.SelectRow,prefix1 + "cop_no");
                       formObject.bkg_no.value = sheetObject0.CellText(sheetObject0.SelectRow,prefix1 + "bkg_no");
                       formObject.cntr_no.value = sheetObject0.CellText(sheetObject0.SelectRow,prefix1 + "cntr_no");
                       formObject.pgmNo.value = 'ESD_SCE_0006';
                       formObject.dist1.value = 'COP_VALUE';
                       formObject.dist2.value = 'COP_VALUE';
					 //  formObject.action = 'ESD_SCE_0006.do';

					 //  formObject.submit();
					   window.open ("ESD_SCE_0006.do?cop_no="+formObject.cop_no.value+"&bkg_no="+formObject.bkg_no.value+"&cntr_no="+formObject.cntr_no.value+"&pgmNo="+formObject.pgmNo.value+"&dist1="+formObject.dist1.value+"&dist2="+formObject.dist2.value, null, "scroll=no, status=no, help=no ,width=1000,height=600");
                   }else if(beforetab == 1){
                       formObject.f_cmd.value = "" ;
                       formObject.cop_no.value = sheetObject1.CellText(sheetObject1.SelectRow,prefix2 + "cop_no");
                       formObject.bkg_no.value = sheetObject1.CellText(sheetObject1.SelectRow,prefix2 + "bkg_no");
                       formObject.cntr_no.value = sheetObject1.CellText(sheetObject1.SelectRow,prefix2 + "cntr_no");
                       formObject.pgmNo.value = 'ESD_SCE_0006';
                       formObject.dist1.value = 'COP_VALUE';
                       formObject.dist2.value = 'COP_VALUE';
					 //  formObject.action = 'ESD_SCE_0006.do';
					 //  formObject.submit();
					   window.open ("ESD_SCE_0006.do?cop_no="+formObject.cop_no.value+"&bkg_no="+formObject.bkg_no.value+"&cntr_no="+formObject.cntr_no.value+"&pgmNo="+formObject.pgmNo.value+"&dist1="+formObject.dist1.value+"&dist2="+formObject.dist2.value, null, "scroll=no, status=no, help=no ,width=1000,height=600");
		                
                   }
//                   else if(beforetab == 2){	// 통합될 경우 삭제만 하면 됨
//                       formObject.f_cmd.value = "" ;
//                       formObject.cop_no.value = sheetObject2.CellText(sheetObject2.SelectRow,prefix3 + "cop_no");
//                       formObject.bkg_no.value = sheetObject2.CellText(sheetObject2.SelectRow,prefix3 + "bkg_no");
//                       formObject.cntr_no.value = sheetObject2.CellText(sheetObject2.SelectRow,prefix3 + "cntr_no");
//                       formObject.pgmNo.value = 'ESD_SCE_0006';
//                       formObject.dist1.value = 'COP_VALUE';
//                       formObject.dist2.value = 'COP_VALUE';
//					 //  formObject.action = 'ESD_SCE_0006.do';
//					  // formObject.submit();
//					   window.open ("ESD_SCE_0006.do?cop_no="+formObject.cop_no.value+"&bkg_no="+formObject.bkg_no.value+"&cntr_no="+formObject.cntr_no.value+"&pgmNo="+formObject.pgmNo.value+"&dist1="+formObject.dist1.value+"&dist2="+formObject.dist2.value, null, "scroll=no, status=no, help=no ,width=1000,height=600");
//		                
//                   }
    	              // onDetailScreen();

                    break;

                case "btn_save":
                	if(beforetab == 0){
                		openPopupSave('SAVE');
                	}else if(beforetab == 1){
                		var prefix = "sheet2_";
                        if(sheetObject1.CheckedRows("flag")>0){
                    	    var chkrow = 0;

                            if(sheetObject1.CheckedRows("flag") < 100){
                                for(var i = 0 ; i < sheetObject1.CheckedRows("flag"); i++){
                    	    		chkrow = sheetObject1.FindCheckedRow("flag").split('|')[i];
               	    		
                    	    		if(sheetObject1.CellValue(chkrow, prefix+"act_dt1") == '' || sheetObject1.CellValue(chkrow, prefix+"act_dt2")  == ''){
                         	    		alert("Please, Insert Event DT");
                    	    			return;
                    	    		}else if(sheetObject1.CellValue(chkrow, prefix+"nod_cd") == '' || sheetObject1.CellValue(chkrow, prefix+"nod_cd").length < 5 ){
                         	    		alert("Please, Insert LOC");
                    	    			return;
                    	    		}
                    	    		
                    	    		if(sheetObject1.CellValue(chkrow, prefix+"dtl_nod_cd") != '' ){
                    	    			if(sheetObject1.CellValue(chkrow, prefix+"dtl_nod_cd").indexOf(sheetObject1.CellValue(chkrow, prefix+"nod_cd")) == -1) {
                    	    				if(!ComShowConfirm(ComGetMsg('SCE90048',''))){
	                    	    				return;
	                    	    			}
                    	    			}
                    	    		}                    	    		
                                }
                                doActionIBSheet1(sheetObject1,formObject,IBSAVE);
                            } else {
                                var retVal = window.showModalDialog("ESD_SCE_0091.do", "RowLimited", "scroll:no;status:no;resizable:no;help:no;dialogWidth:600px;dialogHeight:180px");

                                if(typeof retVal != "undefined"){
                                    var arr_val = retVal.split(",");

                                    var temp_row = arr_val[0];
                                    var temp_row1 = arr_val[1];

                                    sheetObject1.CheckAll("flag") = 0 ;
                                    for(temp_row;temp_row <= temp_row1;temp_row++ ){
                                       sheetObject1.CellValue(temp_row, "flag") = 'Y';
                                    }

                                    targetBlocking(sheetObject1,2);

                                    for(var i = 0 ; i < sheetObject1.CheckedRows("flag"); i++){
                        	    		chkrow = sheetObject1.FindCheckedRow("flag").split('|')[i];
                             	    		
                        	    		if(sheetObject1.CellValue(chkrow, prefix+"act_dt1") == '' || sheetObject1.CellValue(chkrow, prefix+"act_dt2")  == ''){
                             	    		alert("Please, Insert Event DT");
                        	    			return;
                        	    		}else if(sheetObject1.CellValue(chkrow, prefix+"nod_cd") == '' || sheetObject1.CellText(chkrow, prefix+"nod_cd").length < 5){
                             	    		alert("Please, Insert LOC");
                        	    			return;
                        	    		}
                        	    		if(sheetObject1.CellValue(chkrow, prefix+"dtl_nod_cd") != '' ){
                        	    			if(sheetObject1.CellValue(chkrow, prefix+"dtl_nod_cd").indexOf(sheetObject1.CellValue(chkrow, prefix+"nod_cd")) == -1) {
                        	    				if(!ComShowConfirm(ComGetMsg('SCE90048',''))){
    	                    	    				return;
    	                    	    			}
                        	    			}
                        	    		}                        	    		
                                    }
                                    doActionIBSheet1(sheetObject1,formObject,IBSAVE);
                                }
                            }
                        }else{
                            alert("Please, Check CheckBox");
                        }
                	}
//                	else if(beforetab == 2){
//                		var prefix = "sheet3_";                		
//                        if(sheetObject2.CheckedRows("flag")>0){
//                    	    var chkrow = 0;
//                            if(sheetObject2.CheckedRows("flag") < 100){
//                                for(var i = 0 ; i < sheetObject2.CheckedRows("flag"); i++){
//                    	    		chkrow = sheetObject2.FindCheckedRow("flag").split('|')[i];
//                    	    		if(sheetObject2.CellValue(chkrow, prefix+"act_dt1") == '' || sheetObject2.CellValue(chkrow, prefix+"act_dt2") == ''){
//                         	    		alert("Please, Insert Event DT");
//                    	    			return;
//                    	    		}else if(sheetObject2.CellValue(chkrow, prefix+"nod_cd") == '' || sheetObject2.CellText(chkrow, prefix+"nod_cd").length  <5){
//                         	    		alert("Please, Insert LOC");
//                    	    			return;
//                    	    		}
//                                }
//                                doActionIBSheet2(sheetObject2,formObject,IBSAVE);
//                            } else {
//                                var retVal = window.showModalDialog("ESD_SCE_0091.do", "RowLimited", "scroll:no;status:no;resizable:no;help:no;dialogWidth:550px;dialogHeight:180px");
//
//                                if(typeof retVal != "undefined"){
//                                    var arr_val = retVal.split(",");
//
//                                    var temp_row = arr_val[0];
//                                    var temp_row1 = arr_val[1];
//
//                                    sheetObject2.CheckAll("flag") = 0 ;
//                                    for(temp_row;temp_row <= temp_row1;temp_row++ ){
//                                       sheetObject2.CellValue(temp_row, "flag") = 'Y';
//                                    }
//
//                                    targetBlocking(sheetObject2,2);
//
//                                    for(var i = 0 ; i < sheetObject2.CheckedRows("flag"); i++){
//                        	    		chkrow = sheetObject2.FindCheckedRow("flag").split('|')[i];
//                        	    		if(sheetObject2.CellValue(chkrow, prefix+"act_dt1") == '' || sheetObject2.CellValue(chkrow, prefix+"act_dt2")  == ''){
//                             	    		alert("Please, Insert Event DT");
//                        	    			return;
//                        	    		}else if(sheetObject2.CellValue(chkrow, prefix+"nod_cd") == '' || sheetObject2.CellText(chkrow, prefix+"nod_cd").length  <5){
//                             	    		alert("Please, Insert LOC");
//                        	    			return;
//                        	    		}
//                                    }
//                                    doActionIBSheet2(sheetObject2,formObject,IBSAVE);
//                                }
//                            }
//                        }else{
//                            alert("Please, Check CheckBox");
//                        }
//                	}

                    break;
                case "btng_send":
                	if(beforetab == 0){
                		openPopupSave('SEND');
                	}else if(beforetab == 1){
                		var prefix = "sheet2_";                		
                        if(sheetObject1.CheckedRows("flag")>0){
                    	    var chkrow = 0;
                    	    if(sheetObject1.CheckedRows("flag") < 100){
                                for(var i = 0 ; i < sheetObject1.CheckedRows("flag"); i++){
                    	    		chkrow = sheetObject1.FindCheckedRow("flag").split('|')[i];
                    	    		if(sheetObject1.CellValue(chkrow, prefix+"act_dt1") == '' || sheetObject1.CellValue(chkrow, prefix+"act_dt2") == ''){
                         	    		alert("Please, Insert Event DT");
                    	    			return;
                    	    		}else if(sheetObject1.CellValue(chkrow, prefix+"nod_cd") == '' || sheetObject1.CellText(chkrow, prefix+"nod_cd").length < 5){
                         	    		alert("Please, Insert LOC");
                    	    			return;
                    	    		}
                    	    		if(sheetObject1.CellValue(chkrow, prefix+"dtl_nod_cd") != '' ){
                    	    			if(sheetObject1.CellValue(chkrow, prefix+"dtl_nod_cd").indexOf(sheetObject1.CellValue(chkrow, prefix+"nod_cd")) == -1) {
                    	    				if(!ComShowConfirm(ComGetMsg('SCE90048',''))){
	                    	    				return;
	                    	    			}
                    	    			}
                    	    		}                    	    		
                                }
                                doActionIBSheet1(sheetObject1,formObject,IBINSERT);
                          } else {
                                var retVal = window.showModalDialog("ESD_SCE_0091.do", "RowLimited", "scroll:no;status:no;resizable:no;help:no;dialogWidth:550px;dialogHeight:180px");

                                if(typeof retVal != "undefined"){
                                    var arr_val = retVal.split(",");

                                    var temp_row = arr_val[0];
                                    var temp_row1 = arr_val[1];

                                    sheetObject1.CheckAll("flag") = 0 ;
                                    for(temp_row;temp_row <= temp_row1;temp_row++ ){
                                       sheetObject1.CellValue(temp_row, "flag") = 'Y';
                                    }

                                    targetBlocking(sheetObject1,2);

                                    for(var i = 0 ; i < sheetObject1.CheckedRows("flag"); i++){
                        	    		chkrow = sheetObject1.FindCheckedRow("flag").split('|')[i];
                        	    		if(sheetObject1.CellValue(chkrow, prefix+"act_dt1") == '' || sheetObject1.CellValue(chkrow, prefix+"act_dt2")  == ''){
                             	    		alert("Please, Insert Event DT");
                        	    			return;
                        	    		}else if(sheetObject1.CellValue(chkrow, prefix+"nod_cd") == '' || sheetObject1.CellText(chkrow, prefix+"nod_cd").length  <5){
                             	    		alert("Please, Insert LOC");
                        	    			return;
                        	    		}
                        	    		if(sheetObject1.CellValue(chkrow, prefix+"dtl_nod_cd") != '' ){
                        	    			if(sheetObject1.CellValue(chkrow, prefix+"dtl_nod_cd").indexOf(sheetObject1.CellValue(chkrow, prefix+"nod_cd")) == -1) {
                        	    				if(!ComShowConfirm(ComGetMsg('SCE90048',''))){
    	                    	    				return;
    	                    	    			}
                        	    			}
                        	    		}                        	    		
                                    }
                                    doActionIBSheet1(sheetObject1,formObject,IBINSERT);
                                }
                          }
                        }else{
                            alert("Please, Check CheckBox");
                        }
                	}
//                	else if(beforetab == 2){
//                		var prefix = "sheet3_";                		
//                        if(sheetObject2.CheckedRows("flag")>0){
//                    	    var chkrow = 0;
//                    	    if(sheetObject2.CheckedRows("flag") < 100){
//                                for(var i = 0 ; i < sheetObject2.CheckedRows("flag"); i++){
//                    	    		chkrow = sheetObject2.FindCheckedRow("flag").split('|')[i];
//                    	    		if(sheetObject2.CellValue(chkrow, prefix+"act_dt1") == '' || sheetObject2.CellValue(chkrow, prefix+"act_dt2")  == ''){
//                         	    		alert("Please, Insert Event DT");
//                    	    			return;
//                    	    		}else if(sheetObject2.CellValue(chkrow, prefix+"nod_cd") == '' || sheetObject2.CellText(chkrow, prefix+"nod_cd").length  <5){
//                         	    		alert("Please, Insert LOC");
//                    	    			return;
//                    	    		}
//                                }
//                        		doActionIBSheet2(sheetObject2,formObject,IBINSERT);
//                    	    } else {
//                    	        var retVal = window.showModalDialog("ESD_SCE_0091.do", "RowLimited", "scroll:no;status:no;resizable:no;help:no;dialogWidth:550px;dialogHeight:180px");
//
//                                if(typeof retVal != "undefined"){
//                                    var arr_val = retVal.split(",");
//
//                                    var temp_row = arr_val[0];
//                                    var temp_row1 = arr_val[1];
//
//                                    sheetObject2.CheckAll("flag") = 0 ;
//                                    for(temp_row;temp_row <= temp_row1;temp_row++ ){
//                                       sheetObject2.CellValue(temp_row, "flag") = 'Y';
//                                    }
//
//                                    targetBlocking(sheetObject2,2);
//
//                                    for(var i = 0 ; i < sheetObject2.CheckedRows("flag"); i++){
//                        	    		chkrow = sheetObject2.FindCheckedRow("flag").split('|')[i];
//                        	    		if(sheetObject2.CellValue(chkrow, prefix+"act_dt1") == '' || sheetObject2.CellValue(chkrow, prefix+"act_dt2")  == ''){
//                             	    		alert("Please, Insert Event DT");
//                        	    			return;
//                        	    		}else if(sheetObject2.CellValue(chkrow, prefix+"nod_cd") == '' || sheetObject2.CellText(chkrow, prefix+"nod_cd").length  <5){
//                             	    		alert("Please, Insert LOC");
//                        	    			return;
//                        	    		}
//                                    }
//                                    doActionIBSheet2(sheetObject2,formObject,IBINSERT);
//                                }
//                    	    }
//                        }else{
//                            alert("Please, Check CheckBox");
//                        }
//                	}
                    break;
                case "btn_saveas":
                	if(beforetab == 0){
                		doActionIBSheet0(sheetObject0,formObject,IBDOWNEXCEL);
                	}else if(beforetab == 1){
                		doActionIBSheet1(sheetObject1,formObject,IBDOWNEXCEL);
                	}
//                	else if(beforetab == 2){
//                		doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
//                	}
                	break;
            
//                case "btn_calendar":
//                   	cal = new calendarPopupFromTo();
//                   	cal.displayType = "date";
//					cal.select(formObject.bookingDate1, 'bookingDate1',formObject.bookingDate2, 'bookingDate2', 'yyyy-MM-dd');
//                break ;
            } // end switch

    }

    // Customer 입력 받는 메소드(POP UP 에서 호출한다.)
    function openCustomer(){
//    	window.open ("ESD_SCE_0062.do", "list", "scrollbars=no,resizable=yes,fullscreen=no,width=500,height=500");
    	var newWin = window.showModalDialog("ESD_SCE_0062.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:500px");
    }

    // BKG_NO, BL_NO, CNTR_NO 입력 받는 메소드(POP UP 에서 호출한다.)
    function openAddPaste(dist){
    	var formObject = document.form;
    	var cntr_no = formObject.cntr_no_.value;
    	var bkg_no = formObject.bkg_no_.value;
    	var bl_no = formObject.bl_no_.value;
    	var vvd = formObject.vvd.value;
    //	window.open ("ESD_SCE_0064.do?dist="+dist+"&cntr_no="+cntr_no, "list", "scrollbars=no,resizable=yes,fullscreen=no,width=400,height=380");
    	if (dist == 'cntr_no_'){
    		var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
        }else {
        	var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
        }
//    	else if(dist == 'bkg_no_') {
//    		var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist+"&dest_no="+bkg_no, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
//        }else if(dist == 'bl_no_' ){
//    		var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist+"&dest_no="+bl_no, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
//        }else if(dist == 'vvd'){
//    		var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist+"&dest_no="+vvd, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
//        }
    	
    }

    function openPopupSave(dist){
    	var prefix = "sheet1_";
    	var formObject = document.form;
		var sheetObj =  sheetObjects[0];
		var prefix = "sheet1_";
		var iCheckRow2 = sheetObj.FindCheckedRow("flag");
		var arrRow = iCheckRow2.split("|");
		var bkg_no = '';
		var bkg_no_split = '';
		var cntr_no = '';
		var edi_sts = '';
		var split = '';
		var cs_grp_id = '';
		var edi_sts ='';

		for (idx=0; idx<arrRow.length-1; idx++)
		{
			if(idx == 0){
				bkg_no = sheetObj.CellText(arrRow[idx],prefix +'bkg_no');
				bkg_no_split = split;
				cntr_no = sheetObj.CellText(arrRow[idx],prefix +'cntr_no');
			}else{
				bkg_no = bkg_no + "|" + sheetObj.CellText(arrRow[idx], prefix + 'bkg_no');
				bkg_no_split = bkg_no_split + "|" + split;
				cntr_no = cntr_no + "|" + sheetObj.CellText(arrRow[idx],prefix+ 'cntr_no');
			}

			cs_grp_id = formObject.cs_grp_id.value;
		}
    	if(dist == 'SAVE'){
    		if( sheetObj.CheckedRows("flag") < 1 ) {
				ComShowMessage("Please select at least one.");
				return false;
			}
			//window.open(URL,name,specs,replace)
//    		window.open ("ESD_SCE_0065.do?bkg_no="+ bkg_no + "&bkg_no_split="+bkg_no_split+"&cntr_no=" + cntr_no + "&cs_grp_id=" + cs_grp_id
//    		, "list", "scrollbars=nofullscreen=no,width=500,height=180");
//    		window.open ("ESD_SCE_0065.do?cs_grp_id=" + cs_grp_id, "list", "scrollbars=no,resizable=yes,fullscreen=no,width=540,height=200");
    		var newWin = window.showModalDialog("ESD_SCE_0065.do?cs_grp_id="+cs_grp_id, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:540px;dialogHeight:200px");
//-1
//    		window.open ("ESD_SCE_0065.do?cs_grp_id=" + cs_grp_id, "list", "scrollbars=nofullscreen=no,width=500,height=180");
//
//              var frm = document.form ;
//              var url    = "ESD_SCE_0065.do?bkg_no="+ bkg_no + "&bkg_no_split="+bkg_no_split+"&cntr_no=" + cntr_no + "&cs_grp_id=" + cs_grp_id ;// +"scrollbars=no,fullscreen=no,width=550,height=180";
//              var title  = "list";
//
//                 frm.target = title;                    //form.target 이 부분이 빠지면 form값 전송이 되지 않습니다.
//              alert("2");
//              frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
//              alert("3");
//              frm.method = "post";
//              alert(frm.cntr_no.value);
//              frm.submit();
//              alert("5");
//-2
//var frm = document.form2;
//frm.method="post";
//frm.target="list";
//frm.action="ESD_SCE_0065.do?bkg_no="+ bkg_no + "&bkg_no_split="+bkg_no_split+"&cntr_no=" + cntr_no + "&cs_grp_id=" + cs_grp_id;
//alert("1");
//window.open ("ESD_SCE_0065.do?cs_grp_id=" + cs_grp_id, "list", "scrollbars=nofullscreen=no,width=550,height=180");
//frm.submit();
//-3
// window.open ("ESD_SCE_0065.do?cs_grp_id=" + cs_grp_id, "oNewWin", "scrollbars=nofullscreen=no,width=550,height=180");
// var frm = document.form;
// alert("1");
//   //frm.action = "ESD_SCE_0065.do?bkg_no="+ bkg_no + "&bkg_no_split="+bkg_no_split+"&cntr_no=" + cntr_no + "&cs_grp_id=" + cs_grp_id;
//   frm.action = "ESD_SCE_0065.do";
// alert("2");
//   frm.target = "oNewWin";
// alert("3");
//   frm.submit();
// alert("4");


    	}else if (dist == 'SEND'){
    		if( sheetObj.CheckedRows("flag") < 1 ) {
				ComShowMessage("Please select at least one.");
				return false;
			}
    		
    		edi_sts = formObject.edi_sts.value;
//    		window.open ("ESD_SCE_0066.do?bkg_no="+ bkg_no + "&bkg_no_split="+bkg_no_split
//    		+"&cntr_no=" + cntr_no  + '&cs_grp_id=' + cs_grp_id
//            , "list"
//            , "scrollbars=no,fullscreen=no,width=550,height=180");
    //	window.open ("ESD_SCE_0066.do?cs_grp_id=" + cs_grp_id+"&edi_sts1="+edi_sts, "list", "scrollbars=no,resizable=yes,fullscreen=no,width=540,height=200");
    		var newWin = window.showModalDialog("ESD_SCE_0066.do?cs_grp_id="+cs_grp_id+"&edi_sts1="+edi_sts, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:540px;dialogHeight:200px");
    	}
    }

    function addValueNo(dist, multi_value){
    	var multis = multi_value.split('\n');
     	multi_value = '';
    	for(var i = 0 ; i < multis.length ; i++){
    		if(multis[i] != ''){
    			//cntr_no에서 호출하는 경우와 bl_no에서 호출하는경우를 분기를 함
    			if (dist == 'cntr_no_'){
    				if(i == 0){
    					multi_value = CheckDigitSplit1(multis[i]);
    				}else{
    						multi_value = multi_value + ',' + CheckDigitSplit1(multis[i]);
    				}
    			}else{
    				if(i == 0){
    					multi_value = multis[i];
    				}else{
    					multi_value = multi_value + ',' + multis[i];
    				}
    			}
	   		}
    	}
    	
    	if(multi_value != ''){
//    		if(document.getElementById(dist).value != ''){
//    			document.getElementById(dist).value = document.getElementById(dist).value + ',' + multi_value;
//    		}else{
                if (dist == 'cntr_no_'){
    			document.getElementById(dist).value = multi_value;
    			document.getElementById("cntr_no_nonbit").value = multi_value;
    			document.getElementById("cntr_no_split").value = "";
                }else {
                document.getElementById(dist).value = multi_value;	
                }
    			
//    		}
    	}
    }
     

    function addVVDNo(vvds, dist, loc_cd){
    	var formObject = document.form;
    	if(vvds != ''){
    		document.getElementById('vvd').value = vvds;
    		if(dist == 'D'){
	    		formObject.pol.value = toUpperCase(loc_cd);
    		}else{
    			formObject.pod.value = toUpperCase(loc_cd);
    		}
    	}
    }

    function addEdiStsNo(edi_sts){
    	if(edi_sts != ''){
//    		if(document.getElementById('vvd').value != ''){
//    			document.getElementById('vvd').value = document.getElementById('vvd').value + ',' + vvds;
//    		}else{
    			document.getElementById('edi_sts').value = edi_sts;
//    		}
    	}
    }

    function openVVDList(){
//    	window.open ("ESD_SCE_0063.do", "list", "scrollbars=no,resizable=yes,fullscreen=no,width=600,height=450");
    	var newWin = window.showModalDialog("ESD_SCE_0063.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:450px");
    }

    function openEdiStsList(){
    	var formObject = document.form;
    	var edi_grp_cd = toUpperCase(formObject.cs_grp_id.value);
//    	window.open ("ESD_SCE_0067.do?edi_grp_cd=" + edi_grp_cd , "list", "scrollbars=no,resizable=yes,fullscreen=no,width=800,height=450");
    	var newWin = window.showModalDialog("ESD_SCE_0067.do?edi_grp_cd=" + edi_grp_cd , window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:450px");
    }

    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
        }
        return str;
    }
    function toLowerCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toLowerCase(); //소문자는 대문자로
        }
        return str;
    }

   function researchScreen(){

    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }
     
     function setComboObject(combo_obj) {
     	comboObjects[comboCnt++] = combo_obj;
     }
     
     
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObject = document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
        comboObjects[0].Text = "ALL";
        comboObjects[0].CheckIndex(0) = true;
        formObject.search.value ="0";
       
    }

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

		var  xs = document.form.edi_sts.value;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                	//서버와의 연결시간이 초과하여 10분으로 설정을 한다.
                	sheetObj.RequestTimeOut = 1800;
                	var varNewTitle = xs.replace(/,/g, '|');
                	var aryTitle;
					if (varNewTitle.length > 0){
						aryTitle = varNewTitle.split("|");
					}else{
						aryTitle = new Array();
					}
					varNewTitle = '';
					if(aryTitle.length > 0){
                		for( var k = 0; k < aryTitle.length ; k++){
                			varNewTitle = varNewTitle + '|' + aryTitle[k] + '|' + aryTitle[k] + '|' + aryTitle[k];
                		}
                	}
                	if(varNewTitle != ''){
                		varNewTitle = varNewTitle;
                	}

                    var colCnt = aryTitle.length;
                	var colcount = colCnt*3 + 12 ;

                	sheetObj.MessageText("MessageShowLevel")="";

                    //전체 너비 설정
                    style.height = 190 ;
                    style.height = GetSheetHeight(12) ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo( 1, 1, 10, 300);
                    MassOfSearch = 0;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                   InitColumnInfo(colcount, 1, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

  				    var modbsize = 70 ;
                    var ydbsize = 110;
                    //20071107 History: var HeadTitle = "|VVD|BKG NO.|BKG NO.|CNTR NO.|POR|POL|POD|DEL||"+varNewTitle ;
                    var HeadTitle = "|VVD|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL|cop_no|ts_port|rail"+ varNewTitle ;
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    //데이터속성     [ROW, COL,  DATATYPE,   WIDTH,   DATAALIGN, COLMERGE,   SAVENAME,       KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet1_";  
                    
                    InitDataProperty(0, cnt++ , dtCheckBox,     20,    daCenter,  false,            "flag",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    prefix + "vvd",         false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    prefix +"bkg_no",         false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    prefix +"bl_no",          false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    prefix +"cntr_no",        false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"por_cd",            false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"pol_cd",            false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"pod_cd",            false,          "",      dfNone,      0,     false,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"del_cd",            false,          "",      dfNone,      0,     false,       true,          30);
					InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,  prefix +"cop_no",      false,          "",      dfNone,   0,     false,       false,          30);

					//20071107 History: InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,    "bl_no",      false,          "",      dfNone,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,    prefix +"ts_port",      false,          "",      dfNone,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,    prefix +"rail",      false,          "",      dfNone,   0,     false,       false,          30);

					for(var k = 0 ; k <  aryTitle.length ; k++ ){
						    var addtionalSts = toLowerCase(aryTitle[k]);
						    
							InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,    prefix +addtionalSts + '_1',       false,          "",      dfDateYmd,      0,     false,       true,          30) ;
							InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,    prefix +addtionalSts+'_2',       false,          "",      dfTimeHms,      0,     false,       true,          30) ;
							InitDataProperty(0, cnt++ , dtHidden,       70,   daCenter,  true,    prefix +addtionalSts+'_3',       false,          "",      dfNone,      0,     false,       true,          30) ;
					}
			

               }
                break;
               case 2:      //sheet1 init
               with (sheetObj) {
               	    //서버와의 연결시간이 초과하여 10분으로 설정을 한다.
               	    sheetObj.RequestTimeOut = 600;
                    // 높이 설정
                    style.height = GetSheetHeight(12) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                	sheetObj.MessageText("MessageShowLevel")="";

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]

                   //////////////////// MERGE를 하지 않기 위해서 막은 부분(2007.10.15) START ////////////////////////////////

                   // MergeSheet = msPrevColumnMerge;

                   //////////////////// MERGE를 하지 않기 위해서 막은 부분(2007.10.15) END ////////////////////////////////


  				   //20071018 유저의 요구에 의해 헤드컬럼 MERGE
				   MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    //InitRowInfo( 1, 1, 10, 300);
                    InitRowInfo( 1, 1, 10, 300);
                    MassOfSearch = 0;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(28, 0, 0, false);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
//                    InitHeadMode(false, true, false, true, false,false);

                    InitHeadMode(true, true, true, true, false,false);
                    //20071105HISTORY:var HeadTitle = "VVD|BKG NO.|BKG NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT|EDI PROCESS DT|ADD";
                    //20071105CHANGE: CUST STS컬럼 추가
                    //20071107 History: var HeadTitle = "VVD|BKG NO.|BKG NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT|EDI PROCESS DT|ADD";
                    //20071107 History: var HeadTitle = "VVD|BKG NO.|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT|EDI PROCESS DT|ADD";
                    var HeadTitle = "VVD|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|SEQ|Missing Type|Event DT|Event DT|LOC|EDI PROCESS DT(KST)|EDI PROCESS DT(KST)|EDI PROCESS DT(LCL)|EDI PROCESS DT(LCL)|ADD|cop_no||ts_port|rail|FF REF NO|ISA#";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    // 헤더 툴팁
                    var sTipErrMsg = "[ Err Msg ]" +
                    "\nS : Success" +
                    "\nZ : Missing All"+
                    "\nA : Date is same as before, VE is not sent" +
                    "\nB : Not a target event for transmission. Data is saved temporarily" +
                    "\nC : DEL nation code does not match up with the EDI setup on edi.smlines.com" +
                    "\nD : VE can not be sent prior to VDL or VDT status" +
                    "\nE : DEL continent does not match up with the EDI setup on edi.smlines.com" +
                    "\nF : This event will be sent as scheduled" +
                    "\nG : Data does not meet the F.O.C Compliance. This event is not sent." +
                    "\nH : Date is same as before, VE is not sent" +
                    "\nI : AD will be sent when the BKG term is Door at DEL and MVMT is ID status." +
                    "\nJ : VE can not be sent prior to VDL or VDT status" +
                    "\nK : It will not be sent if the final location of ARN is not same with NT location." +
                    "\nL : AG will not be sent when the BKG is not Door Term at DEL" +
                    "\nM : POR continent does not match up with the EDI setup on edi.smlines.com" +
                    "\nN : POR nation code does not match up with the EDI setup on edi.smlines.com" +
                    "\nO : NT will not be sent after COP process has done" +
                    "\nP : The event is not sent due to no relating customer code or S/C No registered on edi.smlines.com." +
                    "\nX : Disable to send event for Unknown reasons";

                    //데이터속성     [ROW, COL,  DATATYPE,   WIDTH,   DATAALIGN, COLMERGE,   SAVENAME,       KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet2_"; 
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    prefix + "vvd",         false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    prefix +"bkg_no",         false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    prefix +"bl_no",           false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    prefix +"cntr_no",        false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"por_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"pol_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"pod_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"del_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtCheckBox,     60,    daCenter,  false,           "flag",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"edi_sts_cd",    false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"edi_sub_sts_cd",    false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"edi_snd_knt",    false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,      prefix +"err_msg",      false,          "",      dfNone,   0,     false,       false,          30,  false,    true,    sTipErrMsg);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    prefix +"act_dt1",      false,          "",      dfDateYmd,   0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"act_dt2",      false,          "",      dfTimeHms,   0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"nod_cd",      false,          "",      dfEngUpKey,   0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    prefix +"cre_dt1",      false,          "",      dfDateYmd,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"cre_dt2",      false,          "",      dfTimeHms,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    prefix +"gmt_dt1",      false,          "",      dfDateYmd,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"gmt_dt2",      false,          "",      dfTimeHms,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtImage,        70,    daCenter,  true,    prefix +"rbtn",      false,          "",      dfNone,   0,     true,       true,          30);
 					InitDataProperty(0, cnt++ , dtHidden,       70,    daCenter,  true,    prefix +"cop_no",      false,          "",      dfNone,   0,     true,       false,          30);
 					//20071107 History: InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,    "bl_no",      false,          "",      dfNone,   0,     true,       false,          30);
					InitDataProperty(0, cnt++ , dtHiddenStatus, 25,    daCenter,  false,   prefix +"ibflg",     	  false,          "",       dfNone,   		0,     false,      false, 30);
					InitDataProperty(0, cnt++ , dtHidden,       70,    daCenter,  true,    prefix +"ts_port",      false,          "",      dfNone,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtHidden,       70,    daCenter,  true,    prefix +"rail",      false,          "",      dfNone,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,      prefix +"flt_file_ref_no",      false,          "",      dfNone,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,      prefix +"edi_ctrl_no",      false,          "",      dfNone,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtHidden,       70,    daCenter,  true,    prefix +"dtl_nod_cd",      false,          "",      dfNone,   0,     false,       false,          30);                    

                    ToolTipOption = "balloon:true; width:620; backcolor:#ffffff; forecolor:#14358B; icon:0;";
              		ImageList("0") = "/hanjin/img/alps/button/btng_rowadd.gif" ;
              		CountPosition = 4;
              }
                break;
//            case 3:     //sheet2 init
//                with (sheetObj) {
//                	//서버와의 연결시간이 초과하여 10분으로 설정을 한다.
//                	sheetObj.RequestTimeOut = 600;
//                    // 높이 설정
//                    style.height = GetSheetHeight(12) ;
//                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
//
//                	sheetObj.MessageText("MessageShowLevel")="";
//
//                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                    //전체Merge 종류 [선택, Default msNone]
//
//                   //////////////////// MERGE를 하지 않기 위해서 막은 부분(2007.10.15) START ////////////////////////////////
//
//                   // MergeSheet = msPrevColumnMerge;
//
//                   //////////////////// MERGE를 하지 않기 위해서 막은 부분(2007.10.15) END ////////////////////////////////
//
//
//  				   //20071018 유저의 요구에 의해 헤드컬럼 MERGE
//				   MergeSheet = msHeaderOnly;
//
//
//                   //전체Edit 허용 여부 [선택, Default false]
//                    Editable = true;
//
//                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=50]
//                    InitRowInfo( 1, 1, 10, 300);
//
//                    MassOfSearch = 0;
//
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(25, 0, 0, false);
//
//                    // 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
//                    InitHeadMode(true, true, true, true, false,false);
//
//                    //20071105HISTORY:var HeadTitle = "VVD|BKG NO.|BKG NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT|EDI PROCESS DT|ADD";
//                    //20071105CHANGE: CUST STS컬럼 추가
//                    //20071107 History: var HeadTitle = "VVD|BKG NO.|BKG NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT|EDI PROCESS DT|ADD";
//                    //20071107 History: var HeadTitle = "VVD|BKG NO.|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT|EDI PROCESS DT|ADD";
//                    var HeadTitle = "VVD|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT(KST)|EDI PROCESS DT(KST)|EDI PROCESS DT(LCL)|EDI PROCESS DT(LCL)|ADD|cop_no||ts_port|rail|FF REF NO";
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle, true);
//
//                    //데이터속성     [ROW, COL,  DATATYPE,   WIDTH,   DATAALIGN, COLMERGE,   SAVENAME,       KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    var prefix ="sheet3_";
//                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    prefix +"vvd",         false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    prefix +"bkg_no",         false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    prefix +"bl_no",           false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    prefix +"cntr_no",        false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"por_cd",            false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"pol_cd",            false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"pod_cd",            false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    prefix +"del_cd",            false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtCheckBox,     60,    daCenter,  false,            "flag",          false,          "",      dfNone,      0,     true,       true,          30);
//                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"edi_sts_cd",    false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"edi_sub_sts_cd",    false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"edi_snd_knt",    false,          "",      dfNone,      0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    prefix +"act_dt1",      false,          "",      dfDateYmd,   0,     true,       true,          30);
//                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"act_dt2",      false,          "",      dfTimeHms,   0,     true,       true,          30);
//                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"nod_cd",      false,          "",      dfEngUpKey,   0,     true	,       true,          30);
//                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    prefix +"cre_dt1",      false,          "",      dfDateYmd,   0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"cre_dt2",      false,          "",      dfTimeHms,   0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    prefix +"gmt_dt1",      false,          "",      dfDateYmd,   0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    prefix +"gmt_dt2",      false,          "",      dfTimeHms,   0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtImage,         70,    daCenter,  true,   prefix +"rbtn",      false,          "",      dfNone,   0,     true,       true,          30);
//					InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,  prefix +"cop_no",      false,          "",      dfNone,   0,     true,       false,          30);
// 					//20071107 History: InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,    "bl_no",      false,          "",      dfNone,   0,     true,       false,          30);
//                    InitDataProperty(0, cnt++ , dtHiddenStatus,   25,    daCenter,  false, prefix +"ibflg",     	  false,          "",       dfNone,   		0,     false,      false, 30);
//                    InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,  prefix +"ts_port",      false,          "",      dfNone,   0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,  prefix +"rail",      false,          "",      dfNone,   0,     false,       false,          30);
//                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,      prefix +"flt_file_ref_no",      false,          "",      dfNone,   0,     false,       false,          30);
//
//                    ImageList("0") = "/hanjin/img/alps/button/btng_rowadd.gif" ;
//              }
//                break;
        }
      // setTempInit();

    }

    function setTempInit(){
    	var formObject = document.form;
    	formObject.grp_nm.value = 'CRU7';
    	formObject.cs_grp_id.value = 'CRU7';
    	formObject.vvd.value = 'HJOL0040E';
		formObject.pod.value = 'USSEA';

    }

    function onEnterKey(){
//    	var formObject = document.form;
//    	var sheetObject = sheetObjects[0];
//         var sheetObject1 = sheetObjects[1];
//         var sheetObject2 = sheetObjects[2];
//		if (event.keyCode == 13) {
//			doActionIBSheet1(sheetObject,formObject,IBSEARCH);
//    	    doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
//    	    doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
//		}
    }

    function CheckDigit(obj){
        var rtnval = cntrCheckDigit(obj);
        obj.value  = rtnval;
    }

    
 // Container No. 의 CheckDigit 을 설정.
    function CheckDigitSplit( obj, bitTarget, valueTarget){
    	var cntrNo = obj.value;
    	var orginNo = obj.value;
        if (cntrNo.length < 10){
    		document.getElementById(bitTarget).value = '';
    		document.getElementById(valueTarget).value = cntrNo;
    		return;
    	}
    	ComChkObjValid(obj, 'eng_num', true, 10);
    	var sum = 0;
     	cntrNo = cntrNo.toUpperCase();

    	//for(var i=0;i<10;i++){
    	//	sum = sum + ComGetCntrChkDgt( cntrNo.charAt(i),i);
    	//}
     	if (orginNo.length == 10){
     		sum = ComGetCntrChkDgt( cntrNo.substr(0,10));
     		//alert("  "+	cntrNo.substr(0,10));
     		//alert('sum:'+sum);		
     		var mod = sum % 11;

     		if (mod == 10) mod =0;

     		if( isNaN(mod)){
     			document.getElementById(bitTarget).value = '';
     			document.getElementById(valueTarget).value = obj.value;
     		}else{
     			obj.value = 	cntrNo.substr(0,10);
     			document.getElementById(bitTarget).value = mod;
     			document.getElementById(valueTarget).value = obj.value + mod;
     		}
     	}else {
     		document.getElementById(bitTarget).value = '';
 			document.getElementById(valueTarget).value = obj.value;
     	}
     		
    }
    
    // Container No. 의 CheckDigit 을 설정.
     function CheckDigitSplit1(obj){ 
    	 var formObject = document.form
    	var cntrNo = obj;
    	var cnrtNoStr = obj;
    	var returnvalue = "";
    	if (cntrNo.length < 10){
    		//document.getElementById(bitTarget).value = '';
    		//document.getElementById(valueTarget).value = cntrNo;
    		return cnrtNoStr;
    	}
    	ComChkObjValid(formObject.cntr_no_, 'eng_num', true, 10);
    	var sum = 0;
     	cntrNo = cntrNo.toUpperCase();

    	//for(var i=0;i<10;i++){
    	//	sum = sum + ComGetCntrChkDgt( cntrNo.charAt(i),i);
    	//}
    	sum = ComGetCntrChkDgt( cntrNo.substr(0,10));
     
    	var mod = sum % 11;

    	if (mod == 10) mod =0;

    	if( isNaN(mod)){
    		//document.getElementById(bitTarget).value = '';
    		//document.getElementById(valueTarget).value = obj.value;
    		returnvalue = cnrtNoStr;
    		return returnvalue;
    	}else{
    		cnrtNoStr = cntrNo.substr(0,10);
    		//document.getElementById(bitTarget).value = mod;
    		//document.getElementById(valueTarget).value = obj.value + mod;
    		returnvalue = cnrtNoStr + mod;
    		return returnvalue;
    		
    	}
    }
    
    function t0sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
       // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
    
       doActionIBSheet0(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
       
    }

    function t1sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
       // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
       doActionIBSheet1(sheetObjects[1], document.form, IBSEARCHAPPEND, true, PageNo);
    }

//    function t2sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
//       // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
//       doActionIBSheet2(sheetObjects[2], document.form, IBSEARCHAPPEND, true, PageNo);
//    }

// Sheet관련 프로세스 처리
    function doActionIBSheet0(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg = false;
        grp_cust = formObj.cs_grp_id.value;

        switch(sAction) {
           case IBSEARCH:      //조회
                 if(validateForm(formObj)){
                	formObj.search.value = '1';
                 	initSheet(sheetObj,1);
                 	sheetObj.removeAll();
    		        formObj.f_cmd.value = SEARCH01;
    		        /*
    		         * ETD와 ETA에 대해 하나의 Calendar만 쓰고 있으므로 COMBO BOX의 선택에 따라 ETA인 경우
    		         * 해당 Calendar form의 date를 히든 값인 podetaDate1와 podetaDate2에 각각 셋팅해준 후 조회
    		         */
    		        if(formObj.etd_eta.value == "ETA"){
    		        	formObj.podetaDate1.value = formObj.poletdDate1.value;
    		        	formObj.podetaDate2.value = formObj.poletdDate2.value;
                     	etaDate1 = formObj.poletdDate1.value;
                     	etaDate2 = formObj.poletdDate2.value;
                     	formObj.poletdDate1.value = "";
                     	formObj.poletdDate2.value = "";
                     	sheetObj.DoSearch4Post("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
                     	formObj.poletdDate1.value = etaDate1;
                     	formObj.poletdDate2.value = etaDate2;
                     	formObj.podetaDate1.value = "";
                     	formObj.podetaDate2.value = "";
    		        }else{
    		        	sheetObj.DoSearch4Post("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
    		        }
			     }else {
			    	 formObj.search.value = '0'; 
			     }
           
              formObj.dist1.value = 'N';
              break;

           case IBSEARCHAPPEND:  // 페이징 조회
               formObj.f_cmd.value = SEARCH01;
	           if(formObj.etd_eta.value == "ETA"){
		        	formObj.podetaDate1.value = formObj.poletdDate1.value;
	            	formObj.podetaDate2.value = formObj.poletdDate2.value;
	            	etaDate1 = formObj.poletdDate1.value;
	            	etaDate2 = formObj.poletdDate2.value;
	            	formObj.poletdDate1.value = "";
	            	formObj.poletdDate2.value = "";
	            	sheetObj.DoSearch4Post("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet1_"), "i_page=" + PageNo, true);
	            	formObj.poletdDate1.value = etaDate1;
	            	formObj.poletdDate2.value = etaDate2;
	            	formObj.podetaDate1.value = "";
	             	formObj.podetaDate2.value = "";
		        }else{
		        	sheetObj.DoSearch4Post("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet1_"), "i_page=" + PageNo, true);
		        }
           		break;

           case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;
        }
    }
  // Sheet관련 프로세스 처리
    function doActionIBSheet1(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //조회
                 if(formObj.search.value == '1'){
                    initSheet(sheetObj,2);
                    sheetObj.removeAll();
    		        formObj.f_cmd.value = SEARCH02;
    		        //At the moment User search new data set, Initiating the Check Box count Number.
            	    initCkCount();
            	    if(formObj.etd_eta.value == "ETA"){
            	    	etaDate1 = formObj.poletdDate1.value;
                     	etaDate2 = formObj.poletdDate2.value;
    		        	formObj.podetaDate1.value = formObj.poletdDate1.value;
                     	formObj.podetaDate2.value = formObj.poletdDate2.value;
                     	formObj.poletdDate1.value = "";
                     	formObj.poletdDate2.value = "";
                     	sheetObj.DoSearch4Post("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" +  ComGetPrefixParam("sheet2_"));
                     	formObj.poletdDate1.value = etaDate1;
                     	formObj.poletdDate2.value = etaDate2;
                     	formObj.podetaDate1.value = "";
                     	formObj.podetaDate2.value = "";
    		        }else{
    		        	sheetObj.DoSearch4Post("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" +  ComGetPrefixParam("sheet2_"));
    		        }
			     }
                formObj.dist1.value = 'N';
                break;

           case IBSEARCHAPPEND:  // 페이징 조회
                formObj.f_cmd.value = SEARCH02;
	           	if(formObj.etd_eta.value == "ETA"){
	           		etaDate1 = formObj.poletdDate1.value;
	            	etaDate2 = formObj.poletdDate2.value;
		        	formObj.podetaDate1.value = formObj.poletdDate1.value;
	            	formObj.podetaDate2.value = formObj.poletdDate2.value;
	            	formObj.poletdDate1.value = "";
	            	formObj.poletdDate2.value = "";
	            	sheetObj.DoSearch4Post("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet2_"), "i_page=" + PageNo, true);
	            	formObj.poletdDate1.value = etaDate1;
	            	formObj.poletdDate2.value = etaDate2;
	            	formObj.podetaDate1.value = "";
	            	formObj.podetaDate2.value = "";
		        }else{
		        	sheetObj.DoSearch4Post("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet2_"), "i_page=" + PageNo, true);
		        }
           break;

           case IBSAVE :
           		formObj.f_cmd.value = MULTI01;
           		initCkCount();
                sheetObj.DoSave("ESD_SCE_0035GS.do",SceFrmQryString(formObj) + "&" +  ComGetPrefixParam("sheet2_"),"flag");
                t1sheet_OnSearchEnd(sheetObj,'');
                sheetObj.CheckAll("flag") = 0 ;
           break;

           case IBINSERT :
           		formObj.f_cmd.value = MULTI02;
           		initCkCount();
           		sheetObj.DoSave("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" +  ComGetPrefixParam("sheet2_"),"flag");
           		t1sheet_OnSearchEnd(sheetObj,'');
           		sheetObj.CheckAll("flag") = 0 ;
           break;

           case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;
        }
    }

//  // Sheet관련 프로세스 처리
//    function doActionIBSheet2(sheetObj,formObj,sAction,a,PageNo) {
//        sheetObj.ShowDebugMsg = false;
//        switch(sAction) {
//           case IBSEARCH:      //조회
////               if(isSearch){
//                     if(formObj.search.value == '1'){
//                        initSheet(sheetObj,3);
//                        sheetObj.removeAll();
//        		        formObj.f_cmd.value = SEARCH03;
//        			    sheetObj.DoSearch4Post("ESD_SCE_0035GS.do", SceFrmQryString(formObj) +  "&" + ComGetPrefixParam("sheet3_"));
//    			    } 
////               }
//               formObj.dist2.value = 'N';
//               break;
//            case IBSAVE :
//           		formObj.f_cmd.value = MULTI03;
//           		sheetObj.DoSave("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet3_"),"flag");
//           		t2sheet_OnSearchEnd(sheetObj,'');
//           		sheetObj.CheckAll("flag") = 0 ;
//			break;
//
//			case IBINSERT :
//				formObj.f_cmd.value = MULTI04;
//				sheetObj.DoSave("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet3_"),"flag");
//				t2sheet_OnSearchEnd(sheetObj,'');
//				sheetObj.CheckAll("flag") = 0 ;
//			break;
//			case IBSEARCHAPPEND:  // 페이징 조회
//
//				formObj.f_cmd.value = SEARCH03;
//				sheetObj.DoSearch4Post("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet3_"), "i_page=" + PageNo, true);
//			break;
//
//			case IBDOWNEXCEL:        //엑셀 다운로드
//				sheetObj.Down2Excel(-1, false, false, true);
//			break;
//        }
//    }

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Summary Report" , -1 );
                    InsertTab( cnt++ , "Detail Report-COP" , -1 );
//                    InsertTab( cnt++ , "Detail Report-Others " , -1 );
                }
             break;

         }
    }
   //Initiating Check Box for Flag
    function initCkCount(){
    	document.form.ckCount.value = 0;
    }
	// Detail Report-COP tab 에서 check 된 row 수를 count 하여 명시한다.
    function t1sheet_OnChange(sheetObj, Row, Col, Value) {
    	var formObject = document.form;
    	var rowPostion = formObject.tab1_position.value
		if (sheetObj.ColSaveName(Col) == "flag" && sheetObj.RowCount >= 0){
			document.form.ckCount.value = sheetObj.CheckedRows("flag");
			if(sheetObj.CellValue(Row,"flag") == "1"){
				if(rowPostion < Row){
					formObject.tab1_position.value = Row;
				}
			}
		}
    	
    	
    }
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {


        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;

    }
//    function t1sheet_OnMouseDown(sheetObj, Button, Shift, X, Y){
//
//    }
    function t2sheet_OnMouseMove(sheetObj, Button, Shift, X, Y){

       //풍선도움말 만들기
      if (sheetObj.MouseCol == 9)
          MouseToolTipText = sheetObj.CellText(sheetObj.MouseRow,14);
      else
          MouseToolTipText = "";

          sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol) = MouseToolTipText;
    }

    function t3sheet_OnMouseMove(sheetObj, Button, Shift, X, Y){

       //풍선도움말 만들기
      if (sheetObj.MouseCol == 9)
          MouseToolTipText = sheetObj.CellText(sheetObj.MouseRow,13);
      else
          MouseToolTipText = "";

          sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol) = MouseToolTipText;
    }

    function openESD009Screen(cs_grp_id, tp_id, grp_nm){

    	var formObject = document.form;
    	formObject.cs_grp_id.value = cs_grp_id;
    	onObjectFocusout(formObject);

    	formObject.cs_grp_id.value = cs_grp_id;
    	formObject.tp_id.value = tp_id;
    	formObject.grp_nm.value = grp_nm;
    	formObject.mycust.value = cs_grp_id+"%"+tp_id+"%"+grp_nm ;
    }

    // reloading 하는것이 싫으면 ajax 를 이용 ~~ test는 확실이 안해 놨음~~
/*    function openESD009Screen(cs_grp_id, tp_id, grp_nm){
       var formObject = document.form;
       formObject.cs_grp_id.value = cs_grp_id;
       onObjectFocusout(formObject);

       formObject.cs_grp_id.value = cs_grp_id;
       formObject.tp_id.value = tp_id;
       formObject.grp_nm.value = grp_nm;

       var tempCnt = formObject.mycust.options.length;
       var tempKey = cs_grp_id+"%"+tp_id+"%"+grp_nm ;
       var tempValue = "["+cs_grp_id+"] ["+tp_id+"] "+grp_nm ;
       formObject.mycust.options[0] = new Option(tempValue,tempKey);
       formObject.mycust.value = cs_grp_id+"%"+tp_id+"%"+grp_nm ;
    }
*/
    function openESD068Screen(cs_grp_id, tp_id, grp_nm){
        var formObject = document.form;
        formObject.cs_grp_id.value = cs_grp_id;
    	onObjectFocusout(formObject);
        formObject.cs_grp_id.value = cs_grp_id;
    	formObject.tp_id.value = tp_id;
    	formObject.grp_nm.value = grp_nm;
    }
    // Tab 별 Double 클릭시 발생하는 이벤트를 정의한다.
    function t0sheet_OnDblClick(sheetObj,Row,Col){
    	var prefix = "sheet1_";
    	var formObject = document.form;
 
        var colName = sheetObj.ColSaveName(Col);
        var temp_rail = sheetObj.cellValue(Row,prefix + "rail");
        var temp_tsport = sheetObj.CellValue(Row,prefix+ "ts_port");
        var temp_delcd = sheetObj.cellValue(Row,prefix+ "del_cd");

        var temp_rail_sub1 = temp_rail.substring(0,1);
        var temp_rail_sub2 = temp_rail.substring(1,2);
        var temp_delcd_sub = temp_delcd.substring(0,2);
        if((temp_tsport == "") && ((colName == "VAT_day") || (colName == "VAT_time") ||
              (colName == "UVT_day") || (colName == "UVT_time")   ||
              (colName == "AET_day") || (colName == "AET_time")   ||
              (colName == "VDT_day") || (colName == "VDT_time")   ||
              (colName == "VAT_day") || (colName == "VAT_time")  )) {
            return;
        } else if((temp_rail_sub1 == "X") && ((colName == "ALO_day") || (colName == "ALO_time")  ||
               (colName == "RLO_day") || (colName == "RLO_time")  ||
               (colName == "ARO_day") || (colName == "ARO_time")  ||
               (colName == "URO_day") || (colName == "URO_time")  ||
               (colName == "FOTRDO_day") || (colName == "FOTRDO_time")  ||
               (colName == "FOTRAD_day") || (colName == "FOTRAD_time")   )){
            return;
        } else if(((temp_rail_sub2 == "X")) && ((colName == "ALN_day") || (colName == "ALN_time")   ||
                (colName == "RLN_day") || (colName == "RLN_time")  ||
                (colName == "ARN_day") || (colName == "ARN_time")  ||
                (colName == "URN_day") || (colName == "URN_time")  ||
                (colName == "FITRAD_day") || (colName == "FITRAD_time")  ||
                (colName == "FITRDO_day") || (colName == "FITRDO_time")  ||
                (colName == "AVN_day") || (colName == "AVN_time")  ||
                (colName == "ACN_day") || (colName == "ACN_time")  ||
                (colName == "AFN_day") || (colName == "AFN_time")  ||
                (colName == "AON_day") || (colName == "AON_time")  ||
                (colName == "NT_day") || (colName == "NT_time"))){
            return;
        } else if(((temp_rail == "II")) && ((colName == "AVL_day") || (colName == "AVL_time") ||
                 (colName == "ACL_day") || (colName == "ACL_time") ||
                 (colName == "AFL_day") || (colName == "AFL_time") ||
                 (colName == "AOL_day") || (colName == "AOL_time") )){
            return;
        } else if(((temp_delcd_sub == "US")) && ((colName == "CT_day") || (colName == "CT_time") ||
                  (colName == "CC_day") || (colName == "CC_time") ||
                  (colName == "CU_day") || (colName == "CU_time") ||
                  (colName == "HR_day") || (colName == "HR_time") ||
                  (colName == "PA_day") || (colName == "PA_time") ||
                  (colName == "PQ_day") || (colName == "PQ_time") ||
                  (colName == "AVN_day") || (colName == "AVN_time") ||
                  (colName == "AVL_day") || (colName == "AVL_time") ||
                  (colName == "ACN_day") || (colName == "ACN_time") ||
                  (colName == "ACL_day") || (colName == "ACL_time") )

                  && sheetObj.CellValue(Row, Col) == ""
                  ){
            return;
        } else if(((temp_delcd_sub == "CA") || (temp_delcd_sub == "MX")) && ((colName == "OB_day") || (colName == "OB_time") ||
                  (colName == "AFN_day") || (colName == "AFN_time") ||
                  (colName == "AFL_day") || (colName == "AFL_time") ||
                  (colName == "AON_day") || (colName == "AON_time") ||
                  (colName == "AOL_day") || (colName == "AOL_time") )){
            return;
        } else if(((temp_delcd_sub == "US") || (temp_delcd_sub == "CA") || (temp_delcd_sub == "MX") ) && ((colName == "NFR_day") || (colName == "NFR_time") ||
                  (colName == "FTR_day") || (colName == "FTR_time") )){
            return;
        } else {
            if(Col < 9 && Col > 0){
                var bkg_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "bkg_no");
                var cntr_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "cntr_no");
                var vvd = sheetObj.CellText(sheetObj.SelectRow,prefix + "vvd");
    			var bl_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "bl_no");
                var por_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "por_cd");
                var pol_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "pol_cd");
                var pod_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "pod_cd");
                var del_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "del_cd");
                var cop_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "cop_no");
                var edi_grp_cd = formObject.cs_grp_id.value;

//                window.open ("ESD_SCE_0060.do?bkg_no="+ bkg_no + "&cntr_no=" + cntr_no+"&cop_no=" + cop_no
//                + "&vvd="+vvd+"&por_cd="+por_cd+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&bl_no="+bl_no + "&edi_grp_cd="+edi_grp_cd
//                , "list"
//                , "scrollbars=no,resizable=yes,fullscreen=no,width=1000,height=450");
                
                var paramUrl = "bkg_no="+ bkg_no +"&cntr_no=" + cntr_no+"&cop_no=" + cop_no
                + "&vvd="+vvd+"&por_cd="+por_cd+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&bl_no="+bl_no + "&edi_grp_cd="+edi_grp_cd;
        
                var newWin = window.showModalDialog("ESD_SCE_0060.do?"+paramUrl, "list", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:450px");
        
            }else if(Col >= 9){
            	var bkg_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "bkg_no");
            	var cntr_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "cntr_no");
            	var edi_sts = sheetObj.ReadDataProperty(Row, Col, dpSaveName).split("_")[1];
            	    if(edi_sts != "") edi_sts = toUpperCase(edi_sts);
            	var edi_grp_cd = formObject.cs_grp_id.value;

//        		window.open ("ESD_SCE_0061.do?bkg_no="+ bkg_no +"&cntr_no=" + cntr_no + "&edi_sts=" + 
//        				edi_sts  + "&edi_grp_cd="+edi_grp_cd
//                , "list"
//                , "scrollbars=yes,resizable=yes,fullscreen=no,width=1000,height=500");

        		var paramUrl = "bkg_no="+ bkg_no +"&cntr_no=" + cntr_no + "&edi_sts=" +
        			edi_sts  + "&edi_grp_cd="+edi_grp_cd;
        
                var newWin = window.showModalDialog("ESD_SCE_0061.do?"+paramUrl, "list", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:500px");
                
            }
        }
    }

    function t1sheet_OnDblClick(sheetObj,Row,Col){
        //alert("t1sheet:"+sheetObj.cellValue(Row, "sheet2_rbtn")+" Col:"+Col);
        //20071107 History: if(sheetObj.cellValue(Row, "btn")==0){
            //alert("1:"+sheetObj.cellValue(Row, "btn"));
    	   var prefix = "sheet2_";
            if(Col < 8){
                var formObject = document.form;
                var bkg_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "bkg_no");
                var cntr_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "cntr_no");
                var vvd = sheetObj.CellText(sheetObj.SelectRow,prefix + "vvd");
    			var bl_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "bl_no");
                var por_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "por_cd");
                var pol_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "pol_cd");
                var pod_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "pod_cd");
                var del_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "del_cd");
                var cop_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "cop_no");
                var edi_grp_cd = formObject.cs_grp_id.value;

//                window.open ("ESD_SCE_0060.do?bkg_no="+ bkg_no +"&cntr_no=" + cntr_no+"&cop_no=" + cop_no
//                + "&vvd="+vvd+"&por_cd="+por_cd+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&bl_no="+bl_no + "&edi_grp_cd="+edi_grp_cd
//                , "list"
//                , "scrollbars=no,resizable=yes,fullscreen=no,width=1000,height=450");
                
                var paramUrl = "bkg_no="+ bkg_no +"&cntr_no=" + cntr_no+"&cop_no=" + cop_no
                        + "&vvd="+vvd+"&por_cd="+por_cd+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&bl_no="+bl_no + "&edi_grp_cd="+edi_grp_cd;
                
                var newWin = window.showModalDialog("ESD_SCE_0060.do?"+paramUrl, "list", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:450px");
            }
        //20071107 History: }
    }

//    function t2sheet_OnDblClick(sheetObj,Row,Col){
//        //alert("t2sheet:"+sheetObj.cellValue(Row, "btn"));
//        //20071107 History: if(sheetObj.cellValue(Row, "btn")==0){
//            //alert("2:"+sheetObj.cellValue(Row, "btn"));
// 	        var prefix = "sheet3_";
//            if(Col < 8 ){
//               var formObject = document.form;
//                var bkg_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "bkg_no");
//                var cntr_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "cntr_no");
//                var vvd = sheetObj.CellText(sheetObj.SelectRow,prefix + "vvd");
//    			var bl_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "bl_no");
//                var por_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "por_cd");
//                var pol_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "pol_cd");
//                var pod_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "pod_cd");
//                var del_cd = sheetObj.CellText(sheetObj.SelectRow,prefix + "del_cd");
//                var cop_no = sheetObj.CellText(sheetObj.SelectRow,prefix + "cop_no");
//                var edi_grp_cd = formObject.cs_grp_id.value;
//
////                window.open ("ESD_SCE_0060.do?bkg_no="+ bkg_no +"&cntr_no=" + cntr_no+"&cop_no=" + cop_no
////                + "&vvd="+vvd+"&por_cd="+por_cd+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&bl_no="+bl_no + "&edi_grp_cd="+edi_grp_cd
////                , "list"
////                , "scrollbars=no,resizable=yes,fullscreen=no,width=1000,height=450");
//                
//                var paramUrl = "bkg_no="+ bkg_no +"&cntr_no=" + cntr_no+"&cop_no=" + cop_no
//                + "&vvd="+vvd+"&por_cd="+por_cd+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&bl_no="+bl_no + "&edi_grp_cd="+edi_grp_cd;
//        
//                var newWin = window.showModalDialog("ESD_SCE_0060.do?"+paramUrl, "list", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:450px");
//            }
//        //20071107 History: }
//    }
    function t1sheet_OnClick(sheetObj,Row,Col){
   	
    	var prefix = "sheet2_";
    	if(Col == 20 && sheetObj.cellValue(Row, prefix + "rbtn") == 0){
	  		  if(sheetObj.CellText(Row,prefix + "edi_snd_knt") == ''){
	  		  	return;
	  		  }
	  		  if(sheetObj.CellText(Row+1,prefix + "ibflg") == 'INS'){
	  		  	return;
	  		  }
			  //생성 후 기본값 설정하기
			  var Row2 = sheetObj.DataInsert();
			  var seq = 0;
			  sheetObj.CellImage(Row2,prefix + "rbtn") = 0;
              sheetObj.cellValue(Row2, prefix + "vvd") = sheetObj.CellText(Row,prefix + "vvd");
              sheetObj.cellValue(Row2, prefix + "bkg_no") = sheetObj.CellText(Row,prefix + "bkg_no");
              sheetObj.cellValue(Row2, prefix + "cntr_no") = sheetObj.CellText(Row,prefix + "cntr_no");
              sheetObj.cellValue(Row2, prefix + "por_cd") = sheetObj.CellText(Row,prefix + "por_cd");
              sheetObj.cellValue(Row2, prefix + "pol_cd") = sheetObj.CellText(Row,prefix + "pol_cd");
              sheetObj.cellValue(Row2, prefix + "pod_cd") = sheetObj.CellText(Row,prefix + "pod_cd");
              sheetObj.cellValue(Row2, prefix + "del_cd") = sheetObj.CellText(Row,prefix + "del_cd");
              sheetObj.cellValue(Row2, prefix + "nod_cd") = sheetObj.CellText(Row,prefix + "nod_cd");
              sheetObj.cellValue(Row2, prefix + "edi_sts_cd") = sheetObj.CellText(Row,prefix + "edi_sts_cd");
              sheetObj.cellValue(Row2, prefix + "edi_sub_sts_cd") = sheetObj.CellText(Row,prefix + "edi_sub_sts_cd");
              if(sheetObj.CellText(Row,prefix + "edi_snd_knt") == ''){
              	seq = 0;
              }else{
              	seq = Number(sheetObj.CellText(Row,prefix +"edi_snd_knt"));
              }
              sheetObj.cellValue(Row2, prefix +"edi_snd_knt") = seq+1;

     		  sheetObj.RowBackColor(Row2) = sheetObj.RgbColor(200,245,255);
    	}
    }

//    function t2sheet_OnClick(sheetObj,Row,Col){
//    	var prefix = "sheet3_";
//    	if(Col == 19 && sheetObj.cellValue(Row, prefix + "rbtn") == 0){
//	  		  if(sheetObj.CellText(Row,prefix + "edi_snd_knt") == ''){
//	  		  	return;
//	  		  }
//	  		  if(sheetObj.CellText(Row+1,prefix + "ibflg") == 'INS'){
//	  		  	return;
//	  		  }
//			  //생성 후 기본값 설정하기
//			  var Row2 = sheetObj.DataInsert();
//			  var seq = 0;
//			  sheetObj.CellImage(Row2,prefix + "rbtn") = 0;
//
//              sheetObj.cellValue(Row2, prefix + "vvd") = sheetObj.CellText(Row,prefix + "vvd");
//              sheetObj.cellValue(Row2, prefix + "bkg_no")  = sheetObj.CellText(Row,prefix + "bkg_no");
//              sheetObj.cellValue(Row2, prefix + "cntr_no") = sheetObj.CellText(Row,prefix + "cntr_no");
//              sheetObj.cellValue(Row2, prefix + "por_cd") = sheetObj.CellText(Row,prefix + "por_cd");
//              sheetObj.cellValue(Row2, prefix + "pol_cd") = sheetObj.CellText(Row,prefix + "pol_cd");
//              sheetObj.cellValue(Row2, prefix + "pod_cd") = sheetObj.CellText(Row,prefix + "pod_cd");
//              sheetObj.cellValue(Row2, prefix + "del_cd") = sheetObj.CellText(Row,prefix + "del_cd");
//              sheetObj.cellValue(Row2, prefix + "nod_cd") = sheetObj.CellText(Row,prefix + "nod_cd");
//              sheetObj.cellValue(Row2, prefix + "edi_sts_cd") = sheetObj.CellText(Row,prefix + "edi_sts_cd");
//              sheetObj.cellValue(Row2, prefix + "edi_sub_sts_cd") = sheetObj.CellText(Row,prefix + "edi_sub_sts_cd");
//              if(sheetObj.CellText(Row,prefix +  "edi_snd_knt") == ''){
//              	seq = 0;
//              }else{
//              	seq = Number(sheetObj.CellText(Row,prefix + "edi_snd_knt"));
//              }
//              sheetObj.cellValue(Row2, prefix + "edi_snd_knt") = seq+1;
//
//     		  sheetObj.RowBackColor(Row2) = sheetObj.RgbColor(200,245,255);
//    	}
//    }

    function researchScreen(){
    	var sheetObject0 = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
//        var sheetObject2 = sheetObjects[2];

        var formObject = document.form;

    	doActionIBSheet0(sheetObject0,formObject,IBSEARCH);
        doActionIBSheet1(sheetObject1,formObject,IBSEARCH);
//        doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObj){
        var result = false ;
        if(!ComIsEmpty(formObj.cs_grp_id)){
       	    var formObject = document.form; 
       	    etaDate1 = formObject.poletdDate1.value;
       	    etaDate2 = formObject.poletdDate2.value;
       	    if(formObject.etd_eta.value == "ETA"){
       	    	formObject.podetaDate1.value = formObject.poletdDate1.value;
       	    	formObject.podetaDate2.value = formObject.poletdDate2.value;
       	    	formObject.poletdDate1.value = "";
       	    	formObject.poletdDate2.value = "";
       	    }else {
	         	formObject.podetaDate1.value = "";
	          	formObject.podetaDate2.value = "";
	        }
       	    if(!ComIsEmpty(formObject.podetaDate1) && !ComIsEmpty(formObject.podetaDate2)){
       	     formObject.podetadate1_hidden.value =  dateConverting(formObject.podetaDate1.value);
       	     formObject.podetadate2_hidden.value  = dateConverting(formObject.podetaDate2.value);   
       	    }else{
          	     formObject.podetadate1_hidden.value =  "";
           	     formObject.podetadate2_hidden.value  = "" 
       	    }
       	    if(!ComIsEmpty(formObject.poletdDate1) && !ComIsEmpty(formObject.poletdDate2)){
     	          formObject.poletddate1_hidden.value =  dateConverting(formObject.poletdDate1.value);
     	          formObject.poletddate2_hidden.value  = dateConverting(formObject.poletdDate2.value); 
       	    }else{
   	          formObject.poletddate1_hidden.value =  "";
 	          formObject.poletddate2_hidden.value  = "";
       	    }
       	    
//       	    if (!ComIsEmpty(formObj.fm_dt1) || !ComIsEmpty(formObj.to_dt1)){
//        	 //데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
//             	formObject.fm_dt.value =  dateConverting(formObject.fm_dt1.value);
//       	     	formObject.to_dt.value  = dateConverting(formObject.to_dt1.value);
//       	    }else {
//       	   		formObject.fm_dt.value =  "";
//       	   		formObject.to_dt.value  = "";  
//       	    }
            result =  true;
            if(!ComIsEmpty(formObj.vvd) || !ComIsEmpty(formObj.bkg_no_)
            || !ComIsEmpty(formObj.bl_no_) || !ComIsEmpty(formObj.cntr_no_)){
            	//데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
           	 var formObject = document.form;                       	        	    
           	    if(!ComIsEmpty(formObject.podetaDate1) && !ComIsEmpty(formObject.podetaDate2)){
           	     formObject.podetadate1_hidden.value =  dateConverting(formObject.podetaDate1.value);
           	     formObject.podetadate2_hidden.value  = dateConverting(formObject.podetaDate2.value);   
           	    }else{
              	     formObject.podetadate1_hidden.value =  "";
               	     formObject.podetadate2_hidden.value  = ""; 
           	    }
           	    if(!ComIsEmpty(formObject.poletdDate1) && !ComIsEmpty(formObject.poletdDate2)){
         	          formObject.poletddate1_hidden.value =  dateConverting(formObject.poletdDate1.value);
         	          formObject.poletddate2_hidden.value  = dateConverting(formObject.poletdDate2.value); 
           	    }else{
       	          formObject.poletddate1_hidden.value =  "";
     	          formObject.poletddate2_hidden.value  = "";        	    	
           	    }           	
                result =  true;
            } else {
                if(!ComIsEmpty(formObj.poletdDate1) || !ComIsEmpty(formObj.poletdDate2)
                 || !ComIsEmpty(formObj.podetaDate1) || !ComIsEmpty(formObj.podetaDate2)
                 || !ComIsEmpty(formObj.fm_dt1) || !ComIsEmpty(formObj.to_dt1)){
                    if(!ComIsEmpty(formObj.poletdDate1) || !ComIsEmpty(formObj.poletdDate2)){
                        if(ComIsEmpty(formObj.pol)){
                             ComShowMessage('Either location or country code of POL is required.');
                             formObj.pol.focus();
                             result = false;
                        } else {
                             var temp_pol = formObj.pol.value.length;
                             if(temp_pol < 2){
                                 ComShowMessage('POL requires a country code 2 words long at least.');
                                 result = false;
                             } else if(temp_pol >= 2 && temp_pol < 5){
                                 if((ComParseInt(ComGetDaysBetween(formObj.poletdDate1.value, formObj.poletdDate2.value)) > 2) ){
                                      ComShowMessage("The period of T.VVD ETD is limited to 3 days in case POL doesn't have a full location code.");
                                      result = false
                                 } else {
                                    	//데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
                                  	 var formObject = document.form;                       	 
                                	 formObject.poletddate1_hidden.value =  dateConverting(formObject.poletdDate1.value);
                                	 formObject.poletddate2_hidden.value  = dateConverting(formObject.poletdDate2.value);      
                                	 if(ComIsEmpty(formObject.podetaDate1) || ComIsEmpty(formObject.podetaDate2)){
                                  	     formObject.podetadate1_hidden.value =  "";
                                   	     formObject.podetadate2_hidden.value  = "" 
                                	 }//if

                                     result = true;
                                 }
                             } else {
                                 if((ComParseInt(ComGetDaysBetween(formObj.poletdDate1.value, formObj.poletdDate2.value)) > 4) ){
                                      ComShowMessage("The period of T.VVD ETD is limited to 5 days.");    // 5일까지 조회 가능~~
                                      result = false;
                                 } else {
                                 	//데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
                                  	 var formObject = document.form;                       	 
                                	 formObject.poletddate1_hidden.value =  dateConverting(formObject.poletdDate1.value);
                                	 formObject.poletddate2_hidden.value  = dateConverting(formObject.poletdDate2.value);  
                                	 if(ComIsEmpty(formObject.podetaDate1) || ComIsEmpty(formObject.podetaDate2)){
                                  	     formObject.podetadate1_hidden.value =  "";
                                   	     formObject.podetadate2_hidden.value  = "" 
                                	 }//if
                                	 
                                     result = true;
                                 }
                             }
                        }
                    }

                    if(!ComIsEmpty(formObj.podetaDate1) || !ComIsEmpty(formObj.podetaDate2)){
                        if(ComIsEmpty(formObj.pod)){
                             ComShowMessage('Either location or country code of POD is required.');
                             formObj.pod.focus();
                             result = false;
                        } else {
                            var tmep_pod = formObj.pod.value.length;
                            if(tmep_pod < 2){
                                ComShowMessage('POD requires a country code 2 words long at least.');
                                result = false;
                            } else if(tmep_pod >= 2 && tmep_pod < 5){
                            	
                                 if((ComParseInt(ComGetDaysBetween(formObj.podetaDate1.value, formObj.podetaDate2.value)) > 2) ){
                                      ComShowMessage("The period of T.VVD ETA is limited to 3 days in case POD doesn't have a full location code.");    // 5일까지 조회 가능~~
                                      result = false
                                 } else {
                                  	 var formObject = document.form;                       	 
                                	 formObject.podetadate1_hidden.value =  dateConverting(formObject.podetaDate1.value);
                                	 formObject.podetadate2_hidden.value  = dateConverting(formObject.podetaDate2.value); 
                                	 
                                	 if(ComIsEmpty(formObject.poletdDate1) || ComIsEmpty(formObject.poletdDate2)){
                              	          formObject.poletddate1_hidden.value =  "";
                             	          formObject.poletddate2_hidden.value  = "";  
                                	 }//if
                                	 
                                     result = true;
                                 }
                            } else {
                                if((ComParseInt(ComGetDaysBetween(formObj.podetaDate1.value, formObj.podetaDate2.value)) > 4) ){
                                      ComShowMessage("The period of T.VVD ETA is limited to 5 days.");    // 5일까지 조회 가능~~
                                      result = false;
                                 } else {
                                     //데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
                                  	 var formObject = document.form;                       	 
                                	 formObject.podetadate1_hidden.value =  dateConverting(formObject.podetaDate1.value);
                                	 formObject.podetadate2_hidden.value  = dateConverting(formObject.podetaDate2.value);
                                	 if(ComIsEmpty(formObject.poletdDate1) || ComIsEmpty(formObject.poletdDate2)){
                             	          formObject.poletddate1_hidden.value =  "";
                            	          formObject.poletddate2_hidden.value  = "";  
                               	     }//if                               	 
                                	 
                                     result = true;
                                 }
                            }
                        }
                    }
                    
                    if(!ComIsEmpty(formObj.fm_dt1) || !ComIsEmpty(formObj.to_dt1)){
                   	 	if((ComParseInt(ComGetDaysBetween(formObj.fm_dt1.value, formObj.to_dt1.value)) > 30) ){
                            ComShowMessage("The period of Event Date is limited to 31 days.");    // 31일까지 조회 가능~~
                            result = false;
                   	 	}else {
                   	 		var formObject = document.form;                       	 
                   	 		formObject.fm_dt.value =  dateConverting(formObject.fm_dt1.value);
                   	 		formObject.to_dt.value  = dateConverting(formObject.to_dt1.value);
                   	 		if(ComIsEmpty(formObject.fm_dt1) || ComIsEmpty(formObject.to_dt1)){
                   			 formObject.fm_dt.value =  "";
              	              	formObject.to_dt.value  = "";  
                   	 		}//if     
                   		 result = true;
                         }
                   }
                 } else {
                	ComShowMessage(ComGetMsg('COM12113',"one of followings: VVD,BKG NO,CNTR NO or BL NO."));
                    result = false;
                }
            }
        }else{
        	ComShowMessage(ComGetMsg('COM12113',"EDI Customer Group."));
            result = false;
        }
        formObject.poletdDate1.value = etaDate1;
     	formObject.poletdDate2.value = etaDate2;
        return result;
    }

   function chkVVD(formObj, ComIsEmptyVVD){
   		var result   = true ;
   		var emptyVVd = ComIsEmptyVVD!=null ? ComIsEmptyVVD : ComIsEmpty(formObj.vvd) ;

   		if(!emptyVVd){
   		   if(ComIsEmpty(formObj.por) && ComIsEmpty(formObj.pol) && ComIsEmpty(formObj.pod) && ComIsEmpty(formObj.del)){
			    // && ComIsEmpty(formObj.DEL) ){
	            ComShowMessage(ComGetMsg('SCE90025'));
	            formObj.por.focus() ;
	            result = false ;
	        }
	        if(formObj.vvd.value.length < 9){
	        	ComShowMessage(ComGetMsg('SCE90035'));
	            formObj.vvd.focus() ;
	        	result = false ;
	        }
		}

		return result ;
   	}

    function onValueChange(selectName, formObj){

    	switch(selectName){
    	    case 'mycust' :
    	       var temp_mycust = formObj.mycust.value;
    	       if(temp_mycust == ""){
    	          formObj.cs_grp_id.value = "";
        	      formObj.tp_id.value = "";
        	      formObj.grp_nm.value = "";
        	      formObj.edi_sts.value = "";
        	      sheetObj.RemoveEtcData();
    	       } else {
        	       var arr_mycust = temp_mycust.split("%");

        	       formObj.cs_grp_id.value = arr_mycust[0];
        	       formObj.tp_id.value = arr_mycust[1];
        	       formObj.grp_nm.value = arr_mycust[2];
        	       formObj.edi_sts.value = "";
                   var sheetObj = sheetObjects[1];
                   //initiating the value of ETC Data
                   sheetObj.RemoveEtcData();
                   formObj.f_cmd.value = MULTI05;
                   sheetObj.DoSearch("ESD_SCE_0035GS.do",SceFrmQryString(formObj));
                   var edi_sts_str = sheetObj.EtcData("edi_sts");
                   if(edi_sts_str != null){ 
                	     formObj.edi_sts.value = sheetObj.EtcData("edi_sts");
                   }else{
                	     formObj.edi_sts.value = "";
                   }
//                   if(formObj.edi_sts.value == ""){
//                       alert("No shipment status was found for the selected customer.");
//                   }
    	       }
    	    break;
    	}
	}

    //Missing 사유 색깔 변경
    function mssingRsnColor(sheetObj){
    	var rowCnt = sheetObj.RowCount;
    	for(var i=1; i <= rowCnt; i++){
    		if(!(sheetObj.CellValue(i,"sheet2_err_msg")=="X" || sheetObj.CellValue(i,"sheet2_err_msg")=="S" || sheetObj.CellValue(i,"sheet2_err_msg")=="")){
    			sheetObj.CellFontColor(i,"sheet2_err_msg") = sheetObj.RgbColor(255, 0, 0);
    		}
    	}	
    }
    
	// 발생 대상에서 제외 되는 셀은 색깔을 변경~~
	function targetBlocking(sheetObj,diff){
	    var rowCnt = sheetObj.RowCount;
        var shts_port = "";
        var sh_rail = "";
        var sh_del = "";
        var sh_edists = "";
        var temp_sh_rail1 = "";
        var temp_sh_rail2 = "";
        var temp_sh_del = "";
        var cust_edi_sts_cd = "";
        var prefix = '';
        var cust_edi_sts = document.form.edi_sts.value;
        var varNewTitle = cust_edi_sts.replace(/,/g, '|');
        var aryTitle;
		if (varNewTitle.length > 0){
			aryTitle = varNewTitle.split("|");
		}else{
			aryTitle = new Array();
		}

	    if(diff == 1){
	    	prefix = 'sheet1_';
    	    for(var i=1; i <= rowCnt; i++){
              shts_port = sheetObj.CellValue(i,prefix + "ts_port");
              sh_rail = sheetObj.cellValue(i,prefix + "rail");
              sh_del = sheetObj.cellValue(i,prefix + "del_cd");             
              temp_sh_rail1 = sh_rail.substring(0,1);
              temp_sh_rail2 = sh_rail.substring(1,2);
              temp_sh_del = sh_del.substring(0,2);
              if(temp_sh_rail1 == "X"){                                  //outbound가 아닐 경우
                 sheetObj.CellBackColor (i,"ALO_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"ALO_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"RLO_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"RLO_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"ARO_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"ARO_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"URO_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"URO_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"FOTRDO_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"FOTRDO_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"FOTRAD_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"FOTRAD_time") =  sheetObj.RgbColor(222, 251, 248);
              }
              if(temp_sh_rail2 == "X"){                                     //inbound가 아닐 경우
                 sheetObj.CellBackColor (i,"ALN_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"ALN_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"RLN_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"RLN_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"ARN_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"ARN_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"URN_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"URN_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"FITRAD_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"FITRAD_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"FITRDO_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"FITRDO_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"AVN_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"AVN_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"ACN_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"ACN_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"AFN_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"AFN_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"AON_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"AON_time") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"NT_day") =  sheetObj.RgbColor(222, 251, 248);
                 sheetObj.CellBackColor (i,"NT_time") =  sheetObj.RgbColor(222, 251, 248);
              }
              if(sh_rail == "II"){                                  // inbount 구간 rail shipment 일 경우
                  sheetObj.CellBackColor (i,"AVL_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AVL_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"ACL_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"ACL_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AFL_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AFL_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AOL_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AOL_time") =  sheetObj.RgbColor(222, 251, 248);
              }
              if(shts_port == ""){                                    //   t/s 가 없는 shipment 일 경우
                  sheetObj.CellBackColor (i,"VAT_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"VAT_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"UVT_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"UVT_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AET_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AET_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"VDT_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"VDT_time") =  sheetObj.RgbColor(222, 251, 248);
              }
              if(temp_sh_del != "US"){
                  sheetObj.CellBackColor (i,"CT_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"CT_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"CC_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"CC_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"CU_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"CU_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"HR_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"HR_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"PA_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"PA_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"PQ_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"PQ_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AVN_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AVN_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AVL_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AVL_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"ACN_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"ACN_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"ACL_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"ACL_time") =  sheetObj.RgbColor(222, 251, 248);
              }
              if((temp_sh_del != "CA") && (temp_sh_del != "MX")){
                  sheetObj.CellBackColor (i,"OB_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"OB_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AFN_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AFN_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AFL_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AFL_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AON_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AON_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AOL_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"AOL_time") =  sheetObj.RgbColor(222, 251, 248);
              }
              if((temp_sh_del != "US") && (temp_sh_del != "CA") && (temp_sh_del != "MX")){
                  sheetObj.CellBackColor (i,"NFR_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"NFR_time") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"FTP_day") =  sheetObj.RgbColor(222, 251, 248);
                  sheetObj.CellBackColor (i,"FTP_time") =  sheetObj.RgbColor(222, 251, 248);
              }

              if((grp_cust == 'USA00285')){    // 특정 화주
                  for( var k = 0; k < aryTitle.length ; k++){
                      if(aryTitle[k] == "ARN"){
                          cust_edi_sts_cd = sheetObj.cellValue(i,"ARN_sts");
                          if(cust_edi_sts_cd == 'X1' && temp_sh_rail2 != 'I'){
                              sheetObj.CellBackColor (i,"ARN_day") =  sheetObj.RgbColor(222, 251, 248);
                              sheetObj.CellBackColor (i,"ARN_time") =  sheetObj.RgbColor(222, 251, 248);
                          }
                      } else if(aryTitle[k] == "VAD"){
                          cust_edi_sts_cd = sheetObj.cellValue(i,"VAD_sts");
                          if(cust_edi_sts_cd == 'X1' && temp_sh_rail2 != 'X'){
                              sheetObj.CellBackColor (i,"VAD_day") =  sheetObj.RgbColor(222, 251, 248);
                              sheetObj.CellBackColor (i,"VAD_time") =  sheetObj.RgbColor(222, 251, 248);
                          }
                      }
                  }
              }
           }
	    } else if(diff == 2 || diff == 3){
	    	
	    	if(diff == 2){
	    		prefix = 'sheet2_';
	    	}else if(diff == 3){
	    		prefix = 'sheet3_';
	    	}//if
	    	
	        for(var i=1; i <= rowCnt; i++){
	           shts_port = sheetObj.CellValue(i,prefix + "ts_port");
               sh_rail = sheetObj.cellValue(i,prefix + "rail");
               sh_edists = sheetObj.cellValue(i,prefix + "edi_sts_cd");
               sh_del = sheetObj.cellValue(i,prefix + "del_cd");
               cust_edi_sts_cd = sheetObj.cellValue(i,prefix + "edi_sub_sts_cd");

               temp_sh_rail1 = sh_rail.substring(0,1);
               temp_sh_rail2 = sh_rail.substring(1,2);
               temp_sh_del = sh_del.substring(0,2);

               if((temp_sh_rail1 == "X") && ((sh_edists == "ALO") || (sh_edists == "RLO") || (sh_edists == "ARO") || (sh_edists == "URO") || (sh_edists == "FOTRDO") || (sh_edists == "FOTRAD") )){                                  //outbound가 아닐 경우
            	    sheetObj.CellEditable(i,"flag")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt1")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt2")= false;
                    sheetObj.CellEditable(i,prefix + "nod_cd") = false;
                    sheetObj.CellBackColor (i,prefix + "act_dt1") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix +"act_dt2") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "nod_cd") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellValue(i, "flag") = 'N';
               }

               if((temp_sh_rail2 == "X") && ((sh_edists == "ALN") || (sh_edists == "RLN") || (sh_edists == "ARN") || (sh_edists == "URN") || (sh_edists == "FITRAD") || (sh_edists == "FITRDO") || (sh_edists == "AVN")
                    || (sh_edists == "ACN") || (sh_edists == "AFN") || (sh_edists == "AON") || (sh_edists == "NT") )){
                    sheetObj.CellEditable(i,"flag")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt1")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt2")= false;
                    sheetObj.CellEditable(i,prefix + "nod_cd")= false;
                    sheetObj.CellBackColor (i,prefix + "act_dt1") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "act_dt2") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "nod_cd") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellValue(i, "flag") = 'N';
               }

               if((sh_rail == "II") && ((sh_edists == "AVL") || (sh_edists == "ACL") || (sh_edists == "AFL") || (sh_edists == "AOL"))){
                    sheetObj.CellEditable(i,"flag")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt1")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt2")= false;
                    sheetObj.CellEditable(i,prefix + "nod_cd") = false;
                    sheetObj.CellBackColor (i,prefix + "act_dt1") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "act_dt2") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "nod_cd") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellValue(i, "flag") = 'N';
               }

               if((shts_port == "") && ((sh_edists == "VAT") || (sh_edists == "UVT") || (sh_edists == "AET") || (sh_edists == "VDT"))){
                    sheetObj.CellEditable(i,"flag")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt1")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt2")= false;
                    sheetObj.CellEditable(i,prefix + "nod_cd") = false;
                    sheetObj.CellBackColor (i,prefix + "act_dt1") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "act_dt2") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "nod_cd") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellValue(i, "flag") = 'N';
               }

               if(((temp_sh_del != "US")) && ((sh_edists == "CT") || (sh_edists == "CC") || (sh_edists == "CU") || (sh_edists == "HR") || (sh_edists == "PA") || (sh_edists == "PQ") || (sh_edists == "AVN")
                   || (sh_edists == "ACN") || (sh_edists == "ACL"))){
                    sheetObj.CellEditable(i,"flag")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt1")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt2")= false;
                    sheetObj.CellEditable(i,prefix + "nod_cd") = false;
                    sheetObj.CellBackColor (i,prefix + "act_dt1") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "act_dt2") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "nod_cd") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellValue(i, "flag") = 'N';
               }

               if(((temp_sh_del != "CA") && (temp_sh_del != "MX")) && ((sh_edists == "OB") || (sh_edists == "AFN") || (sh_edists == "AFL") || (sh_edists == "AON") || (sh_edists == "AOL"))){
                    sheetObj.CellEditable(i,"flag")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt1")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt2")= false;
                    sheetObj.CellEditable(i,prefix + "nod_cd") = false;
                    sheetObj.CellBackColor (i,prefix + "act_dt1") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "act_dt2") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "nod_cd") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellValue(i, "flag") = 'N';
               }

               if(((temp_sh_del != "US") && (temp_sh_del != "CA") && (temp_sh_del != "MX")) && ((sh_edists == "NFR") || (sh_edists == "FTR"))){
                    sheetObj.CellEditable(i,"flag")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt1")= false;
                    sheetObj.CellEditable(i,prefix + "act_dt2")= false;
                    sheetObj.CellEditable(i,prefix + "nod_cd") = false;
                    sheetObj.CellBackColor (i,prefix + "act_dt1") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "act_dt2") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellBackColor (i,prefix + "nod_cd") =  sheetObj.RgbColor(222, 251, 248);
                    sheetObj.CellValue(i, "flag") = 'N';
               }
               if((grp_cust == 'USA00285') && (cust_edi_sts_cd == 'X1')){    // 특정 화주
                   if((sh_edists == 'ARN') && (temp_sh_rail2 != 'I')){                      //   Rail shipment
                       sheetObj.CellEditable(i,"flag")= false;
                       sheetObj.CellEditable(i,prefix + "act_dt1")= false;
                       sheetObj.CellEditable(i,prefix + "act_dt2")= false;
                       sheetObj.CellEditable(i,prefix + "nod_cd") = false;
                       sheetObj.CellBackColor (i,prefix + "act_dt1") =  sheetObj.RgbColor(222, 251, 248);
                       sheetObj.CellBackColor (i,prefix + "act_dt2") =  sheetObj.RgbColor(222, 251, 248);
                       sheetObj.CellBackColor (i,prefix + "nod_cd") =  sheetObj.RgbColor(222, 251, 248);
                       sheetObj.CellValue(i, "flag") = 'N';
                   } else if((sh_edists == 'VAD') && (temp_sh_rail2 != 'X')){               //   Local shipment
                       sheetObj.CellEditable(i,"flag")= false;
                       sheetObj.CellEditable(i,prefix + "act_dt1")= false;
                       sheetObj.CellEditable(i,prefix + "act_dt2")= false;
                       sheetObj.CellEditable(i,prefix + "nod_cd") = false;
                       sheetObj.CellBackColor (i,prefix + "act_dt1") =  sheetObj.RgbColor(222, 251, 248);
                       sheetObj.CellBackColor (i,prefix + "act_dt2") =  sheetObj.RgbColor(222, 251, 248);
                       sheetObj.CellBackColor (i,prefix + "nod_cd") =  sheetObj.RgbColor(222, 251, 248);
                       sheetObj.CellValue(i, "flag") = 'N';
                  }
               }
	        }
	    }
	}

    function t0sheet_OnSearchEnd(sheetObj,ErrMsg){
          with (sheetObj) {
              targetBlocking(sheetObj,1);
         }
    }

    function t1sheet_OnSearchEnd(sheetObj,ErrMsg){
    	var formObject = document.form;
    	var rowPostion = formObject.tab1_position.value
    	var newRowPostion = eval(rowPostion)+ eval(9);
        with(sheetObj){
            targetBlocking(sheetObj,2);
            mssingRsnColor(sheetObj);
            if(rowPostion != 1){
            	sheetObj.SelectCell(newRowPostion, "flag");  // flag 위치로 포커스 이동
            	formObject.tab1_position.value = "1";
            }
        }
    }

//    function t2sheet_OnSearchEnd(sheetObj,ErrMsg){
//        with(sheetObj){
//            targetBlocking(sheetObj,3);
//        }
//    }

    // 달력 check
    function openCalendar(diff){
        var formObject = document.form;
        var from_date = "";
        var to_date = "";
        var obj_from_date = "";
        var obj_to_date = "";
        var cal = new ComCalendarFromTo();
        switch(diff){

           case '1':
             from_date =  "poletdDate1";
             to_date = "poletdDate2";
             obj_from_date = formObject.poletdDate1;
             obj_to_date = formObject.poletdDate2;
             cal.displayType = "date";
             cal.select(obj_from_date,obj_to_date, 'yyyy-MM-dd');      
           break;

//           case '2':
//             from_date =  "podetaDate1";
//             to_date = "podetaDate2";
//             obj_from_date = formObject.podetaDate1;
//             obj_to_date = formObject.podetaDate2;
//             cal.displayType = "date";
//             cal.select(obj_from_date,obj_to_date, 'yyyy-MM-dd');                  
//           break;
           case '3':
               from_date =  "fm_dt1";
               to_date = "to_dt1";
               obj_from_date = formObject.fm_dt1;
               obj_to_date = formObject.to_dt1;
               cal.displayType = "date";
               cal.select(obj_from_date,obj_to_date, 'yyyy-MM-dd');                  
             break;
        }
    }

    function onObjectFocusout(formObj){
	   if(formObj.mycust.value == ''){
	    	formObj.cs_grp_id.value = toUpperCase(formObj.cs_grp_id.value);
	    	var sheetObj = sheetObjects[1];
	    	sheetObj.ShowDebugMsg = false;
	    	formObj.f_cmd.value = MULTI05;
	    	sheetObj.RemoveEtcData();
	    	if(formObj.cs_grp_id.value !=''){  
	    	  sheetObj.DoSearch("ESD_SCE_0035GS.do",SceFrmQryString(formObj));

  		      ComEtcDataToForm(formObj,sheetObj);
  		      /*초기화*/
  		      if(formObj.tp_id.value == ''){
  		    	formObj.cs_grp_id.value = ''
  		      }
	    	}
	   }
//	   else{
//		     ComShowMessage('My Performance has been selected already. Please remove My Performance first before changing settings.');
//	   }//if
	   
    }
	  
	function onbuttondisable(){
		ComBtnDisable("btn_retrieve"); 		
	}
	
	
	 function onObjectFocusout1(formObj){
	      if(formObj.cs_grp_id.value.length  > 6){
	 	    	formObj.cs_grp_id.value = toUpperCase(formObj.cs_grp_id.value);
	 	    	var sheetObj = sheetObjects[1];
	 	    	sheetObj.ShowDebugMsg = false;
	 	    	formObj.f_cmd.value = MULTI05;
	 	    	sheetObj.RemoveEtcData();
	 	    	if(formObj.cs_grp_id.value !=''){  
	 	    	  sheetObj.DoSearch("ESD_SCE_0035GS.do",SceFrmQryString(formObj));

	   		      ComEtcDataToForm(formObj,sheetObj);
	   		      /*초기화*/
	   		      if(formObj.tp_id.value == ''){
	   		    	formObj.cs_grp_id.value = ''
	   		      }
	 	    	}
	 	    	ComBtnEnable("btn_retrieve");	
	 	   }
//	 	   else{
//	 		     ComShowMessage('My Performance has been selected already. Please remove My Performance first before changing settings.');
//	 	   }//if
	 	   
	     }

    //customer 에서 tp_id 가 2개 이상일 경우에 팝업 창을 띄운다...
    /*
    function onObjectTpId(formObj){
        var temp_gid = formObj.cs_grp_id.value;

        if(temp_gid == ""){
            var formObject = document.form;
            formObject.tp_id.value = toUpperCase(formObject.tp_id.value);
            var sheetObj = sheetObjects[1];
            sheetObj.ShowDebugMsg = false;
        	formObj.f_cmd.value = COMMAND06;
        	sheetObj.DoSearch("ESD_SCE_0035GS.do",SceFrmQryString(formObject));
            var result_cnt = sheetObj.EtcData("tp_id_cnt");
            var result_tp_id = sheetObj.EtcData("tp_id");

            var param = "?tp_id="+result_tp_id;
            if(result_cnt > 1){
                window.open ("ESD_SCE_0068.do"+param, "list", "scrollbars=no,resizable=yes,fullscreen=no,width=800,height=390");
            } else {
                IBS_EtcDataToForm2(formObject,sheetObj) ;
            }
        }
    }
    */
    function initVcontainer(array){
    	  //데이터 초기화
          for(var n=0;n<array.length;n++){
          	array[n] = "";
           }//for  
    }
    
    var request = null;
    function createHttpRequest() {
    	try{
    		request = new XMLHttpRequest();
    	} catch(trymicrosoft) {
    		try{
    			request = new ActiveXObject("Msxml2.XMLHTTP");
    		} catch(othermicosoft) {
    			try{
    				request = new ActiveXObject("Microsoft.XMLHTTP");
    			} catch(failed) {
    				request = null;
    			}
    		}
    	}
    	if( request == null ) {
    		ComShowMessage("Erroe Request XMLHttp");
    	}
    }
    
    function searchingCntEct(){
    	var formObj = document.form;
    	var tp_id = formObj.tp_id.value;
    	var url = "ESD_SCE_0035GS.do?f_cmd="+ MULTI06 +"&tp_id="+ tp_id;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = getCntEct;
		request.send(null);   	
    }
    
    function getFiledNames(colorder){
    	if(colorder != ""){
    		return colorder.split("|");
    	}else{
    		
    		return;
    	}
    }
    
    function getFieldNameIndex(array,fName){//행의 인덱스를 가지고 오는 함수 
    	var index = -1;
    	for(var n=0;n<array.length;n++){
    		if(array[n] == fName) 
    			{
    			  index = n;
    			  break;
    			}
    		
    	}//for
    	return index;
    }
    
    function getXMLAttribute(xml,attribute,index1,index2){//어트리뷰트를 가지고 오는 함수 
    	
		var data = xml.getElementsByTagName(attribute)[index1];
		var data_attribute = data.attributes[index2].nodeValue; 
		return data_attribute;
    }
    
    function getCntEct(){
    	var cnt = 0;
    	if( request.readyState == 4 ) {
    		if( request.status == 200 ) 
    		    {
    			  var delimination = "☜☞";
    			  var docXml = request.responseXML;
    			  var rIndex  = docXml.getElementsByTagName("ETC").length;
    			  for(var n=0;n<=rIndex;n++){
    				  if(docXml.getElementsByTagName("ETC")[n].getAttribute("KEY") != "" &&
    				     docXml.getElementsByTagName("ETC")[n].getAttribute("KEY").indexOf('tp_id_cnt') != -1)
    				  {    			
    					  cnt = docXml.getElementsByTagName("ETC")[n].firstChild.nodeValue;
    					  break;
    				  }
    			  }
    	
    			  var cIndex1  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"tp_id");   			  
    			  var cIndex2  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cust_cd");
    			  var cIndex3  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cs_grp_id"); 
    			  var cIndex4  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"edi_sts"); 
    			  var cIndex5  = getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cs_desc");


                
    			  var fRow = null;
    			  if(rIndex >0)
                  {     				
    			    etc_value_container[0] = cnt;//count setting    			    
    			    if(cnt >0){
    			    	fRow = docXml.getElementsByTagName("TR")[0].firstChild.nodeValue;  
        			    etc_value_container[1] = (fRow.split(delimination))[cIndex1]; //tp_id setting
        			    etc_value_container[2] = (fRow.split(delimination))[cIndex2]; //cust_cd setting
        			    etc_value_container[3] = (fRow.split(delimination))[cIndex3]; //cs_grp_id setting
        			    /* 중복되는 edi_sts 발생할수 있음 . 중복된 edi_sts 제거*/
        			    //etc_value_container[4] = (fRow.split(delimination))[cIndex4]; //edi_sts setting
						var ediStsArray = (fRow.split(delimination))[cIndex4].split(",");
						var str = "";
						for(var i=0; i<ediStsArray.length; i++){
							var cnt = 0;							
							for(var k=0; k<ediStsArray.length; k++){
								if(ediStsArray[i] == ediStsArray[k]){
									cnt++;
								}
							}
							if( i== 0){
								str += ediStsArray[i];								
							}else{
								if(cnt == 2){
									if(str.indexOf(ediStsArray[i]) == -1){
										str += ","+ediStsArray[i];									
									}
								}else{
									str += ","+ediStsArray[i];		
								}								
							}
						}
					
						etc_value_container[4] = str; //edi_sts setting
			
        			    etc_value_container[5] = (fRow.split(delimination))[cIndex5]; //cs_desc setting 
    			    }//if

                  }
                  else
                  { 
                	  initVcontainer(etc_value_container);
                  }//if
                  
    			}else{
    				return;
    			}//if

    		}//if
    }
    var etc_value_container =  new Array(6);
    // tp_id가 2개 이상일 경우 팝업~~
    function onObjectTpId(formObj){
        if(formObj.cs_grp_id.value == "" && (formObj.tp_id.value != "" && ComTrim(formObj.tp_id.value) != "")){//전병석 수정
            formObj.tp_id.value = toUpperCase(formObj.tp_id.value);
            var sheetObj = sheetObjects[0];
            sheetObj.ShowDebugMsg = false;
            
            //formObj.f_cmd.value = COMMAND02;
        	//sheetObj.DoSearch("ESD_SCE_0072GS.do",SceFrmQryString(formObj));
            //변수초기화
            initVcontainer(etc_value_container);
            searchingCntEct();
        	//alert(etc_value_container[0]);
        	//alert(etc_value_container[1]);
        	//alert(etc_value_container[2]);
            
        	/*예전소스*/
            //var result_cnt = sheetObj.EtcData("tp_id_cnt");
            //var result_tp_id = sheetObj.EtcData("tp_id");
            //var cust_cd = sheetObj.EtcData("cust_cd");
            //document.getElementById('cust_cd').value = sheetObj.EtcData("cust_cd");
            
        	/*바뀐소스*/
            
            
            var result_cnt   = etc_value_container[0];
            var result_tp_id = etc_value_container[1];
            var cust_cd      = etc_value_container[2];
            var cs_grp_id    = etc_value_container[3];
            var edi_sts      = etc_value_container[4];
            var cs_desc      = etc_value_container[5];
            var param = "?tp_id="+ result_tp_id;
            if(result_cnt > 1){
//                window.open ("ESD_SCE_0068.do"+param, "list", "scrollbars=no,resizable=no,fullscreen=no,width=600,height=390");
            	var newWin = window.showModalDialog("ESD_SCE_0068.do"+param, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:390px");
            } else {
                //IBS_EtcDataToForm2(formObj,sheetObj) ;
            	
            	formObj.tp_id.value = result_tp_id;
            	formObj.cs_grp_id.value = cs_grp_id;
            	formObj.edi_sts.value = edi_sts;
            	formObj.grp_nm.value = cs_desc;
            	
            }
        }
    }
    

    function openfunction(){
       var formObject = document.form;
       //if(formObj.tp_id.value == ""){
           //formObject.action = "ESD_SCE_0035.do?sysCommUiTitle=Customer EDI Monitoring&sysCommUiNavigation=Service Delivery > SCEM > Visibility";
       	   formObject.action = "ESD_SCE_0035.do";
           formObject.f_cmd.value = "" ;
           formObject.submit();    	   
       //}else{
           /*
           //2010-03-21 위 action 주석처리하고 재조회 처리하도록 수정
           var sheetObject0 = sheetObjects[0];
           var sheetObject1 = sheetObjects[1];
           var sheetObject2 = sheetObjects[2];       
           doActionIBSheet0(sheetObject0,formObject,IBSEARCH);
           doActionIBSheet1(sheetObject1,formObject,IBSEARCH);
           doActionIBSheet2(sheetObject2,formObject,IBSEARCH);    
           */	   
       //}

   

              
    }

    function rowLimit(from_row, end_row){

    }
    
    /* Function added by Jun Byoung Suk on Data 2009-09-14
     * Purpose      :Converting Date format 
     * Parameters   :String type of date
     * Return Result:Date format without dashed Lines(-)
     * */
    function dateConverting(date){
    	if(date != ''){
    		return ComTrimAll(date, "-");  
    	}//if
    	return '';
    }



    function initCombo(comboObj, comboNo) {
    	var i=0;
    	switch (comboObj.id) {
    	case 'missing_type':
    		with (comboObj) {
    			DropHeight = 260;
    			MultiSelect = true;
    			MultiSeparator=",";
    			UseAutoComplete = true;
    			InsertItem(i++,'ALL','');
    			InsertItem(i++,'S|Success                                                                                    ','S');
    			InsertItem(i++,'Z|Missing All                                                                                    ','Z');
    			InsertItem(i++,'A|Date is same as before, VE is not sent                                                       ','A');
    			InsertItem(i++,'B|Not a target event for transmission. Data is saved temporarily                                ','B');
    			InsertItem(i++,'C|DEL nation code does not match up with the EDI setup on edi.smlines.com                        ','C');
    			InsertItem(i++,'D|VE can not be sent prior to VDL or VDT status                                                 ','D');
    			InsertItem(i++,'E|DEL continent does not match up with the EDI setup on edi.smlines.com                          ','E');
    			InsertItem(i++,'F|This event will be sent as scheduled                                                          ','F');
    			InsertItem(i++,'G|Data does not meet the F.O.C Compliance. This event is not sent.                              ','G');
    			InsertItem(i++,'H|Date is same as before, VE is not sent                                                        ','H');
    			InsertItem(i++,'I|AD will be sent when the BKG term is Door at DEL and MVMT is ID status.                       ','I');
    			InsertItem(i++,'J|VE can not be sent prior to VDL or VDT status                                                 ','J');
    			InsertItem(i++,'K|It will not be sent if the final location of ARN is not same with NT location.                ','K');
    			InsertItem(i++,'L|AG will not be sent when the BKG is not Door Term at DEL                                      ','L');
    			InsertItem(i++,'M|POR continent does not match up with the EDI setup on edi.smlines.com                          ','M');
    			InsertItem(i++,'N|POR nation code does not match up with the EDI setup on edi.smlines.com                        ','N');
    			InsertItem(i++,'O|NT will not be sent after COP process has done                                                ','O');
    			InsertItem(i++,'P|The event is not sent due to no relating customer code or S/C No registered on edi.smlines.com.','P');
    			InsertItem(i++,'X|Disable to send event for Unknown reasons                                                     ','X');
    			MaxLength = 0;
    			IMEMode = 0;
    			ValidChar(2, 0);
    			SetColWidth("30|550");
    			
    		}
    		break;
    	}
    }
    
	function missing_type_OnCheckClick(comboObj, index, code) {
		if( index == "0" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Text = "ALL";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Text = "ALL";
				comboObj.CheckIndex(0) = true;
			}
		} else if( index == "2" ){
			if( comboObj.CheckIndex(2) == false ){
				comboObj.Code = "Z";
				comboObj.CheckIndex(2) = false;
			} else{
				comboObj.Code = "Z";
				comboObj.CheckIndex(2) = true;
			}
		} else {
			comboObj.CheckIndex(2) = false;
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function combo_Clear(comboObj){
		var comboCnt = comboObj.GetCount();
		for(var i=0 ; i < comboCnt ; i++){
			comboObj.CheckIndex(i) = false;
		}
	}
    
    // 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	function t1sheet_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		if (sheetObj.MouseRow > 0) {
			if (sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg") {
					sheetObj.MouseToolTipText = "";
				if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="S" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "Success";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="A" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "Date is same as before, VE is not sent";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="B" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "Not a target event for transmission. Data is saved temporarily";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="C" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "DEL nation code does not match up with the EDI setup on edi.smlines.com";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="D" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "VE can not be sent prior to VDL or VDT status";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="E" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "DEL continent does not match up with the EDI setup on edi.smlines.com";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="F" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "This event will be sent as scheduled";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="G" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "Data does not meet the F.O.C Compliance. This event is not sent.";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="H" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "Date is same as before, VE is not sent";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="I" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "AD will be sent when the BKG term is Door at DEL and MVMT is ID status.";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="J" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "VE can not be sent prior to VDL or VDT status";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="K" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "It will not be sent if the final location of ARN is not same with NT location.";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="L" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "AG will not be sent when the BKG is not Door Term at DEL";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="M" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "POR continent does not match up with the EDI setup on edi.smlines.com";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="N" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "POR nation code does not match up with the EDI setup on edi.smlines.com";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="O" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "NT will not be sent after COP process has done";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="P" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "The event is not sent due to no relating customer code or S/C No registered on edi.smlines.com.";
				}else if(sheetObjects[1].CellValue(sheetObj.MouseRow,sheetObj.MouseCol)=="X" && sheetObj.ColSaveName(sheetObj.MouseCol) == "sheet2_err_msg"){
					sheetObj.MouseToolTipText = "Disable to send event for Unknown reasons";
				}else {
					sheetObj.MouseToolTipText = "";
				}
			}else {
				sheetObj.MouseToolTipText = "";
			}
		}else {
			sheetObj.MouseToolTipText = "";
		}
	}
    

