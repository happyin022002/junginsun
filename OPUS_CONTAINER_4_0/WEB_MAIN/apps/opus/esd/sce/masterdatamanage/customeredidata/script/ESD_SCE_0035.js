/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0035.js
*@FileTitle  : Customer EDI Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

// Global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var isSearch=false;
var selRow=0;
var isFirst1=0;
var isFirst2=0;
var grp_cust;
var firstSel=-1;
// Global variable
var PageNo=1 ;
//Event handler processing by button click event
document.onclick=processButtonClick;

    //Event handler processing by button name
	function processButtonClick(){
		/***** Setting variable over two sheet at tab *****/
        var sheetObject0=t0sheet;
        var sheetObject1=t1sheet;
        var sheetObject2=t2sheet;
        var prefix1="sheet1_";
        var prefix2="sheet2_";
        var prefix3="sheet3_";
        /*******************************************************/
        var formObject=document.form;
    		var srcName=ComGetEvent("name");
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
    			formObject.vvd.value=toUpperCase(formObject.vvd.value);
	    		formObject.bkg_no_.value=toUpperCase(formObject.bkg_no_.value);
	    		formObject.bl_no_.value=toUpperCase(formObject.bl_no_.value);
	    		formObject.cntr_no_.value=toUpperCase(formObject.cntr_no_.value);
	    		formObject.edi_sts.value=toUpperCase(formObject.edi_sts.value);
	    		formObject.por.value=toUpperCase(formObject.por.value);
	    		formObject.pol.value=toUpperCase(formObject.pol.value);
	    		formObject.pod.value=toUpperCase(formObject.pod.value);
	    		formObject.del.value=toUpperCase(formObject.del.value);
	    		formObject.cs_grp_id.value=toUpperCase(formObject.cs_grp_id.value);
    		}
            switch(srcName) {
        	    case "btn_retrieve":
                    doActionIBSheet0(sheetObject0,formObject,IBSEARCH);
                    doActionIBSheet1(sheetObject1,formObject,IBSEARCH);
                    doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
        	        break;
                case "btn_new":
                	sheetObjects[0] = sheetObjects[0].Reset();
                	sheetObjects[1] = sheetObjects[1].Reset();
                	sheetObjects[2] = sheetObjects[2].Reset();
                	
                	initSheet(sheetObjects[0],1);
                	initSheet(sheetObjects[1],2);
                	initSheet(sheetObjects[2],3);
                	
                    formObject.reset();
                    tabObjects[0].SetSelectedIndex(0);
                    break;
                case "btn_cop":
                   if(beforetab == 0){
                       var rowCHK="";
                       var ii=0;
                       for(var i=1 ; i < sheetObject0.rowcount+1 ; i++){
                            rowCHK=sheetObject0.GetCellValue(i,"flag");
                            if(rowCHK == 1){
                        	   ii=ii + 1;
                    	   }
                       }
                                             if(ii > 1){
                           alert("Multi Row Selected!!");
                           return;
                       }
                       formObject.f_cmd.value="" ;
                       if(sheetObject0.GetSelectRow()>0){
	                       formObject.cop_no.value=sheetObject0.GetCellValue(sheetObject0.GetSelectRow(),prefix1 + "cop_no");
	                       formObject.bkg_no.value=sheetObject0.GetCellValue(sheetObject0.GetSelectRow(),prefix1 + "bkg_no");
	                       formObject.cntr_no.value=sheetObject0.GetCellValue(sheetObject0.GetSelectRow(),prefix1 + "cntr_no");
                       }
                       formObject.pgmNo.value='ESD_SCE_0006';
                       formObject.dist1.value='COP_VALUE';
                       formObject.dist2.value='COP_VALUE';
                       formObject.action='ESD_SCE_0006.do?parentPgmNo=ESD_SCE_M001';
					   formObject.submit();
                   }else if(beforetab == 1){
                       formObject.f_cmd.value="" ;
                       if(sheetObject1.GetSelectRow()>0){
	                       formObject.cop_no.value=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),prefix2 + "cop_no");
	                       formObject.bkg_no.value=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),prefix2 + "bkg_no");
	                       formObject.cntr_no.value=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),prefix2 + "cntr_no");
                       }
                       formObject.pgmNo.value='ESD_SCE_0006';
                       formObject.dist1.value='COP_VALUE';
                       formObject.dist2.value='COP_VALUE';
					   formObject.action='ESD_SCE_0006.do?parentPgmNo=ESD_SCE_M001';
					   formObject.submit();
                   }else if(beforetab == 2){
                       formObject.f_cmd.value="" ;
                       if(sheetObject2.GetSelectRow()>1){
	                       formObject.cop_no.value=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(),prefix3 + "cop_no");
	                       formObject.bkg_no.value=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(),prefix3 + "bkg_no");
	                       formObject.cntr_no.value=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(),prefix3 + "cntr_no");
                       }
                       formObject.pgmNo.value='ESD_SCE_0006';
                       formObject.dist1.value='COP_VALUE';
                       formObject.dist2.value='COP_VALUE';
					   formObject.action='ESD_SCE_0006.do?parentPgmNo=ESD_SCE_M001';
					   formObject.submit();
                   }
    	              // onDetailScreen();
                    break;
                case "btn_save":
                	if(beforetab == 0){
                		openPopupSave('SAVE');
                	}else if(beforetab == 1){
                		var prefix="sheet2_";
                        if(sheetObject1.CheckedRows("flag")>0){
                    	    var chkrow=0;
                            if(sheetObject1.CheckedRows("flag") < 100){
                                for(var i=0 ; i < sheetObject1.CheckedRows("flag"); i++){
                    	    		chkrow=sheetObject1.FindCheckedRow("flag").split('|')[i];
                    	    		if(sheetObject1.GetCellValue(chkrow, prefix+"act_dt1") == '' || sheetObject1.GetCellValue(chkrow, prefix+"act_dt2")  == ''){
                         	    		alert("Please, Insert Event DT");
                    	    			return;
                    	    		}else if(sheetObject1.GetCellValue(chkrow, prefix+"nod_cd") == '' || sheetObject1.GetCellValue(chkrow, prefix+"nod_cd").length < 5 ){
                         	    		alert("Please, Insert LOC");
                    	    			return;
                    	    		}
                    	    		if(sheetObject1.GetCellValue(chkrow, prefix+"dtl_nod_cd") != '' ){
                    	    			if(sheetObject1.GetCellValue(chkrow, prefix+"dtl_nod_cd").indexOf(sheetObject1.GetCellValue(chkrow, prefix+"nod_cd")) == -1) {
                    	    				if(!ComShowConfirm(ComGetMsg('SCE90048',''))){
	                    	    				return;
	                    	    			}
                    	    			}
                    	    		}                    	    		
                                }
                                doActionIBSheet1(sheetObject1,formObject,IBSAVE);
                            } else {
                                var retVal =  ComOpenWindow("ESD_SCE_0091.do",  "RowLimited",  "scroll:no;status:no;resizable:no;help:no;dialogWidth:600px;dialogHeight:180px" , true);
                                if(typeof retVal != "undefined"){
                                    var arr_val=retVal.split(",");
                                    var temp_row=arr_val[0];
                                    var temp_row1=arr_val[1];
                                    sheetObject1.CheckAll("flag",0 );
                                    for(temp_row;temp_row <= temp_row1;temp_row++ ){
                                       sheetObject1.SetCellValue(temp_row, "flag",'Y');
                                    }
                                    targetBlocking(sheetObject1,2);
                                    for(var i=0 ; i < sheetObject1.CheckedRows("flag"); i++){
                        	    		chkrow=sheetObject1.FindCheckedRow("flag").split('|')[i];
                        	    		if(sheetObject1.GetCellValue(chkrow, prefix+"act_dt1") == '' || sheetObject1.GetCellValue(chkrow, prefix+"act_dt2")  == ''){
                             	    		alert("Please, Insert Event DT");
                        	    			return;
                        	    		}else if(sheetObject1.GetCellValue(chkrow, prefix+"nod_cd") == '' || sheetObject1.GetCellValue(chkrow, prefix+"nod_cd").length < 5){
                             	    		alert("Please, Insert LOC");
                        	    			return;
                        	    		}
                        	    		if(sheetObject1.GetCellValue(chkrow, prefix+"dtl_nod_cd") != '' ){
                        	    			if(sheetObject1.GetCellValue(chkrow, prefix+"dtl_nod_cd").indexOf(sheetObject1.GetCellValue(chkrow, prefix+"nod_cd")) == -1) {
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
                	}else if(beforetab == 2){
                		var prefix="sheet3_";                		
                        if(sheetObject2.CheckedRows("flag")>0){
                    	    var chkrow=0;
                            if(sheetObject2.CheckedRows("flag") < 100){
                                for(var i=0 ; i < sheetObject2.CheckedRows("flag"); i++){
                    	    		chkrow=sheetObject2.FindCheckedRow("flag").split('|')[i];
                    	    		if(sheetObject2.GetCellValue(chkrow, prefix+"act_dt1") == '' || sheetObject2.GetCellValue(chkrow, prefix+"act_dt2") == ''){
                         	    		alert("Please, Insert Event DT");
                    	    			return;
                    	    		}else if(sheetObject2.GetCellValue(chkrow, prefix+"nod_cd") == '' || sheetObject2.GetCellValue(chkrow, prefix+"nod_cd").length  <5){
                         	    		alert("Please, Insert LOC");
                    	    			return;
                    	    		}
                                }
                                doActionIBSheet2(sheetObject2,formObject,IBSAVE);
                            } else {
                                var retVal =  ComOpenWindow("ESD_SCE_0091.do",  "RowLimited",  "scroll:no;status:no;resizable:no;help:no;dialogWidth:550px;dialogHeight:180px" , true);
                                if(typeof retVal != "undefined"){
                                    var arr_val=retVal.split(",");
                                    var temp_row=arr_val[0];
                                    var temp_row1=arr_val[1];
                                    sheetObject2.CheckAll("flag",0 );
                                    for(temp_row;temp_row <= temp_row1;temp_row++ ){
                                       sheetObject2.SetCellValue(temp_row, "flag",'Y');
                                    }
                                    targetBlocking(sheetObject2,2);
                                    for(var i=0 ; i < sheetObject2.CheckedRows("flag"); i++){
                        	    		chkrow=sheetObject2.FindCheckedRow("flag").split('|')[i];
                        	    		if(sheetObject2.GetCellValue(chkrow, prefix+"act_dt1") == '' || sheetObject2.GetCellValue(chkrow, prefix+"act_dt2")  == ''){
                             	    		alert("Please, Insert Event DT");
                        	    			return;
                        	    		}else if(sheetObject2.GetCellValue(chkrow, prefix+"nod_cd") == '' || sheetObject2.GetCellValue(chkrow, prefix+"nod_cd").length  <5){
                             	    		alert("Please, Insert LOC");
                        	    			return;
                        	    		}
                                    }
                                    doActionIBSheet2(sheetObject2,formObject,IBSAVE);
                                }
                            }
                        }else{
                            alert("Please, Check CheckBox");
                        }
                	}
                    break;
                case "btn_send":
                	if(beforetab == 0){
                		openPopupSave('SEND');
                	}else if(beforetab == 1){
                		var prefix="sheet2_";                		
                        if(sheetObject1.CheckedRows("flag")>0){
                    	    var chkrow=0;
                    	    if(sheetObject1.CheckedRows("flag") < 100){
                                for(var i=0 ; i < sheetObject1.CheckedRows("flag"); i++){
                    	    		chkrow=sheetObject1.FindCheckedRow("flag").split('|')[i];
                    	    		if(sheetObject1.GetCellValue(chkrow, prefix+"act_dt1") == '' || sheetObject1.GetCellValue(chkrow, prefix+"act_dt2") == ''){
                         	    		alert("Please, Insert Event DT");
                    	    			return;
                    	    		}else if(sheetObject1.GetCellValue(chkrow, prefix+"nod_cd") == '' || sheetObject1.GetCellValue(chkrow, prefix+"nod_cd").length < 5){
                         	    		alert("Please, Insert LOC");
                    	    			return;
                    	    		}
                    	    		if(sheetObject1.GetCellValue(chkrow, prefix+"dtl_nod_cd") != '' ){
                    	    			if(sheetObject1.GetCellValue(chkrow, prefix+"dtl_nod_cd").indexOf(sheetObject1.GetCellValue(chkrow, prefix+"nod_cd")) == -1) {
                    	    				if(!ComShowConfirm(ComGetMsg('SCE90048',''))){
	                    	    				return;
	                    	    			}
                    	    			}
                    	    		}                    	    		
                                }
                                doActionIBSheet1(sheetObject1,formObject,IBINSERT);
                          } else {
                                var retVal =  ComOpenWindow("ESD_SCE_0091.do",  "RowLimited",  "scroll:no;status:no;resizable:no;help:no;dialogWidth:550px;dialogHeight:180px" , true);
                                if(typeof retVal != "undefined"){
                                    var arr_val=retVal.split(",");
                                    var temp_row=arr_val[0];
                                    var temp_row1=arr_val[1];
                                    sheetObject1.CheckAll("flag",0 );
                                    for(temp_row;temp_row <= temp_row1;temp_row++ ){
                                       sheetObject1.SetCellValue(temp_row, "flag",'Y');
                                    }
                                    targetBlocking(sheetObject1,2);
                                    for(var i=0 ; i < sheetObject1.CheckedRows("flag"); i++){
                        	    		chkrow=sheetObject1.FindCheckedRow("flag").split('|')[i];
                        	    		if(sheetObject1.GetCellValue(chkrow, prefix+"act_dt1") == '' || sheetObject1.GetCellValue(chkrow, prefix+"act_dt2")  == ''){
                             	    		alert("Please, Insert Event DT");
                        	    			return;
                        	    		}else if(sheetObject1.GetCellValue(chkrow, prefix+"nod_cd") == '' || sheetObject1.GetCellValue(chkrow, prefix+"nod_cd").length  <5){
                             	    		alert("Please, Insert LOC");
                        	    			return;
                        	    		}
                        	    		if(sheetObject1.GetCellValue(chkrow, prefix+"dtl_nod_cd") != '' ){
                        	    			if(sheetObject1.GetCellValue(chkrow, prefix+"dtl_nod_cd").indexOf(sheetObject1.GetCellValue(chkrow, prefix+"nod_cd")) == -1) {
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
                	}else if(beforetab == 2){
                		var prefix="sheet3_";                		
                        if(sheetObject2.CheckedRows("flag")>0){
                    	    var chkrow=0;
                    	    if(sheetObject2.CheckedRows("flag") < 100){
                                for(var i=0 ; i < sheetObject2.CheckedRows("flag"); i++){
                    	    		chkrow=sheetObject2.FindCheckedRow("flag").split('|')[i];
                    	    		if(sheetObject2.GetCellValue(chkrow, prefix+"act_dt1") == '' || sheetObject2.GetCellValue(chkrow, prefix+"act_dt2")  == ''){
                         	    		alert("Please, Insert Event DT");
                    	    			return;
                    	    		}else if(sheetObject2.GetCellValue(chkrow, prefix+"nod_cd") == '' || sheetObject2.GetCellValue(chkrow, prefix+"nod_cd").length  <5){
                         	    		alert("Please, Insert LOC");
                    	    			return;
                    	    		}
                                }
                        		doActionIBSheet2(sheetObject2,formObject,IBINSERT);
                    	    } else {
                    	        var retVal =  ComOpenWindow("ESD_SCE_0091.do",  "RowLimited",  "scroll:no;status:no;resizable:no;help:no;dialogWidth:550px;dialogHeight:180px" , true);
                                if(typeof retVal != "undefined"){
                                    var arr_val=retVal.split(",");
                                    var temp_row=arr_val[0];
                                    var temp_row1=arr_val[1];
                                    sheetObject2.CheckAll("flag",0 );
                                    for(temp_row;temp_row <= temp_row1;temp_row++ ){
                                       sheetObject2.SetCellValue(temp_row, "flag",'Y');
                                    }
                                    targetBlocking(sheetObject2,2);
                                    for(var i=0 ; i < sheetObject2.CheckedRows("flag"); i++){
                        	    		chkrow=sheetObject2.FindCheckedRow("flag").split('|')[i];
                        	    		if(sheetObject2.GetCellValue(chkrow, prefix+"act_dt1") == '' || sheetObject2.GetCellValue(chkrow, prefix+"act_dt2")  == ''){
                             	    		alert("Please, Insert Event DT");
                        	    			return;
                        	    		}else if(sheetObject2.GetCellValue(chkrow, prefix+"nod_cd") == '' || sheetObject2.GetCellValue(chkrow, prefix+"nod_cd").length  <5){
                             	    		alert("Please, Insert LOC");
                        	    			return;
                        	    		}
                                    }
                                    doActionIBSheet2(sheetObject2,formObject,IBINSERT);
                                }
                    	    }
                        }else{
                            alert("Please, Check CheckBox");
                        }
                	}
                	break;
                case "btn_saveas":
                	if(beforetab == 0){
                		doActionIBSheet0(sheetObject0,formObject,IBDOWNEXCEL);
                	}else if(beforetab == 1){
                		doActionIBSheet1(sheetObject1,formObject,IBDOWNEXCEL);
                	}else if(beforetab == 2){
                		doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
                	}
                	break;
            } // end switch
    }
	
    // halding edit th customer info
    function openCustomer(){
    	ComOpenPopup('ESD_SCE_0062.do', 700, 400, "findCustomer", "1,0", false);
    }
    
    function findCustomer(rtnVal) {
    	form.cs_grp_id.value = rtnVal.edi_grp;
    	form.tp_id.value = rtnVal.tp_id;
    	form.grp_nm.value = rtnVal.grp_nm;
    }
    
    // BKG_NO, BL_NO, CNTR_NO 입력 받는 메소드(POP UP 에서 호출한다.)
    function openAddPaste(dist){
    	var newWin =  ComOpenWindow("ESD_SCE_0064.do?dist="+dist,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px" , true);
    }
    
    function openPopupSave(dist){
    	var prefix="sheet1_";
    	var formObject=document.form;
		var sheetObj=t0sheet;
		var prefix="sheet1_";
		var iCheckRow2=sheetObj.FindCheckedRow("flag");
		var arrRow=iCheckRow2.split("|");
		var bkg_no='';
		var bkg_no_split='';
		var cntr_no='';
		var edi_sts='';
		var split='';
		var cs_grp_id='';
		//for (idx=0; idx<arrRow.length-1; idx++)
		for (idx=0; idx<arrRow.length; idx++)
		{
			if(idx == 0){
				bkg_no=sheetObj.GetCellValue(arrRow[idx],prefix +'bkg_no');
				bkg_no_split=split;
				cntr_no=sheetObj.GetCellValue(arrRow[idx],prefix +'cntr_no');
			}else{
				bkg_no=bkg_no + "|" + sheetObj.GetCellValue(arrRow[idx], prefix + 'bkg_no');
				bkg_no_split=bkg_no_split + "|" + split;
				cntr_no=cntr_no + "|" + sheetObj.GetCellValue(arrRow[idx],prefix+ 'cntr_no');
			}
			cs_grp_id=formObject.cs_grp_id.value;
		}
    	if(dist == 'SAVE'){
    		if( sheetObj.CheckedRows("flag") < 1 ) {
				ComShowMessage("Please select at least one.");
				return false;
			}
    		var newWin =  ComOpenWindow("ESD_SCE_0065.do?cs_grp_id="+cs_grp_id,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:540px;dialogHeight:230px" , true);
    	}else if (dist == 'SEND'){
    		if( sheetObj.CheckedRows("flag") < 1 ) {
				ComShowMessage("Please select at least one.");
				return false;
			}
    		var newWin =  ComOpenWindow("ESD_SCE_0066.do?cs_grp_id="+cs_grp_id,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:540px;dialogHeight:230px" , true);
    	}
    }
    
    function addValueNo(dist, multi_value){
    	var multis=multi_value.split('\n');
    	multi_value='';
    	for(var i=0 ; i < multis.length ; i++){
    		if(multis[i] != ''){
    			if(i == 0){
    				multi_value=multis[i];
    			}else{
    				multi_value=multi_value + ',' + multis[i];
    			}
	   		}
    	}
    	if(multi_value != ''){
    		document.getElementById(dist).value=multi_value;
    	}
    }
    
    function addVVDNo(vvds, dist, loc_cd){
    	var formObject=document.form;
    	if(vvds != ''){
    		document.getElementById('vvd').value=vvds;
    		if(dist == 'D'){
	    		formObject.pol.value=toUpperCase(loc_cd);
    		}else{
    			formObject.pod.value=toUpperCase(loc_cd);
    		}
    	}
    }
    
    function addEdiStsNo(edi_sts){
    	if(edi_sts != ''){
    		document.getElementById('edi_sts').value=edi_sts;
    	}
    }
    
    function openVVDList(){
    	var newWin =  ComOpenWindow("ESD_SCE_0063.do",  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:570px" , true);
    }
    
    function openEdiStsList(){
    	var formObject=document.form;
    	var edi_grp_cd=toUpperCase(formObject.cs_grp_id.value);
    	var newWin =  ComOpenWindow("ESD_SCE_0067.do?edi_grp_cd=" + edi_grp_cd ,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:450px" , true);
    }
    
    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //changing to upper character
        }
        return str;
    }
    
    function toLowerCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toLowerCase(); //changing to upper character
        }
        return str;
    }
    
    function researchScreen(){
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        tabObjects[0].SetSelectedIndex(0);
    }
    
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
		var xs=document.form.edi_sts.value;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case 't0sheet':      //sheet1 init
                with(sheetObj){
                	sheetObj.SetWaitTimeOut(1800);
                	var varNewTitle=xs.replace(/,/g, '|');
                	var aryTitle;
                	if (varNewTitle.length > 0){
                		aryTitle=varNewTitle.split("|");
                	}else{
                		aryTitle=new Array();
                	}
                	varNewTitle='';
                	if(aryTitle.length > 0){
                		for( var k=0; k < aryTitle.length ; k++){
                			varNewTitle=varNewTitle + '|' + aryTitle[k] + '|' + aryTitle[k] + '|' + aryTitle[k];
                		}
                	}
                	if(varNewTitle != ''){
                		varNewTitle=varNewTitle;
                	}
                	var colCnt=aryTitle.length;
                	//var colcount=colCnt*3 + 12 ;
                	//var modbsize=70 ;
                	//var ydbsize=110;
                	var HeadTitle="|VVD|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL|cop_no|ts_port|rail"+ varNewTitle ;
                	var prefix="sheet1_";

                	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );

                	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                	var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	InitHeaders(headers, info);

                	var cols = [ {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"flag",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cop_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_port",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rail",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 } ];
                	for(var k = 0 ; k <  aryTitle.length ; k++ ){
                		var addtionalSts = toLowerCase(aryTitle[k]);
                    	cols.push({Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+addtionalSts+'_1',KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 });
                    	cols.push({Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+addtionalSts+'_2',KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 });
                    	cols.push({Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+addtionalSts+'_3',KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 });
                    }
         
                    InitColumns(cols);
                    SetEditable(1);
//                	SetSheetHeight(300);
                    resizeSheet(); 
            	}
                break;
            case 't1sheet':      //sheet1 init
                with(sheetObj){
                	sheetObj.SetWaitTimeOut(600);
                	var HeadTitle="VVD|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT(KST)|EDI PROCESS DT(KST)|EDI PROCESS DT(LCL)|EDI PROCESS DT(LCL)|ADD|cop_no||ts_port|rail|FF REF NO";
//                	var HeadTitle="VVD|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|OSCAR\nSTS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT(KST)|EDI PROCESS DT(KST)|EDI PROCESS DT(LCL)|EDI PROCESS DT(LCL)|ADD|cop_no||ts_port|rail|FF REF NO";
                	var prefix="sheet2_";

                	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                	var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	InitHeaders(headers, info);

                	var cols = [ {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"por_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"flag",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_sub_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             //{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_cgo_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_snd_knt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"act_dt1",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"act_dt2",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30,  InputCaseSensitive:1},
                	             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt1",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt2",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"gmt_dt1",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"gmt_dt2",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Image",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rbtn",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cop_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Status",    Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_port",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rail",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"flt_file_ref_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtl_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 } ];
               
                	InitColumns(cols);

                	SetEditable(1);
                	SetImageList("0","/opuscntr/img/opus/button/btng_rowadd.gif");
                	SetCountPosition(4);
                	SetSheetHeight(340);
            	}
                break;
            case 't2sheet':     //sheet2 init
                with(sheetObj){
                	sheetObj.SetWaitTimeOut(600);
                	var HeadTitle="VVD|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT(KST)|EDI PROCESS DT(KST)|EDI PROCESS DT(LCL)|EDI PROCESS DT(LCL)|ADD|cop_no||ts_port|rail|FF REF NO";
                	var prefix="sheet3_";

                	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                	var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	InitHeaders(headers, info);

                	var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"por_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"CheckBox",  Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"flag",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_sub_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_snd_knt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"act_dt1",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"act_dt2",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30, InputCaseSensitive:1},
                	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt1",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt2",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"gmt_dt1",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"gmt_dt2",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Image",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rbtn",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                	             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cop_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Status",    Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_port",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rail",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"flt_file_ref_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 } ];
               
                	InitColumns(cols);

                	SetEditable(1);
                	SetImageList("0","/opuscntr/img/opus/button/btng_rowadd.gif");
                	SetSheetHeight(340);
            	}
                break;
        }
    }
    
    var iPageNo = 1;
    function t0sheet_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
        if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
        doActionIBSheet0(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
    }
    
    var iPageNo2 = 1;
    function t1sheet_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
        if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
        doActionIBSheet1(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo2);
    }
    
    var iPageNo3 = 1;
    function t2sheet_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
        if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
        doActionIBSheet2(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo3);
    }
    
    // handling process of sheet
    function doActionIBSheet0(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg(false);
        isSearch=true;
        grp_cust=formObj.cs_grp_id.value;
        switch(sAction) {
        	case IBSEARCH:      //retrieving
        		if(validateForm(formObj)){
        			sheetObj = sheetObj.Reset();
        			sheetObjects[0] = sheetObj;
        			ComConfigSheet (sheetObj );
                    initSheet(sheetObj,1);
                    ComEndConfigSheet(sheetObj);
                 	
    		        formObj.f_cmd.value=SEARCH01;
//    		        sheetObj.DoSearch("ESD_SCE_0035GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
    		        
    		        var sXml = sheetObj.GetSearchData("ESD_SCE_0035GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
    		        if(sXml != null) sheetObj.LoadSearchData(sXml,{Sync:1})
    		        
			    }else{
			    	isSearch=false;
			    }
                formObj.dist1.value='N';
                break;
        	case IBSEARCHAPPEND:  // retrieving page
        		formObj.f_cmd.value=SEARCH01;
        		sheetObj.DoSearch("ESD_SCE_0035GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_")+"&"+ "i_page=" + PageNo,{Append:true} );
        		break;
        	case IBDOWNEXCEL:        //download to excel
        		if(sheetObj.RowCount() < 1){//no data
        			ComShowCodeMessage("COM132501");
        		}else{
        			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        		}
        		break;
        }
    }
    
    // handling process of sheet
    function doActionIBSheet1(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg(false);
        isSearch=true;
        switch(sAction) {
           case IBSEARCH:      //retrieving
                 if(validateForm(formObj)){
                    initSheet(sheetObj,2);
                    sheetObj.RemoveAll();
    		        formObj.f_cmd.value=SEARCH02;
    		        //At the moment User search new data set, Initiating the Check Box count Number.
            	    initCkCount();
            	    sheetObj.DoSearch("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" +  ComGetPrefixParam("sheet2_") );
			     }else{
			         isSearch=false;
			     }
                formObj.dist1.value='N';
                break;
           case IBSEARCHAPPEND:  // retrieving page
                formObj.f_cmd.value=SEARCH02;
                sheetObj.DoSearch("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet2_")+"&"+ "i_page=" + PageNo,{Append:true} );
           break;
           case IBSAVE :
           		formObj.f_cmd.value=MULTI01;
           		initCkCount();
                sheetObj.DoSave("ESD_SCE_0035GS.do",SceFrmQryString(formObj) + "&" +  ComGetPrefixParam("sheet2_"),"flag");
                t1sheet_OnSearchEnd(sheetObj,'');
                sheetObj.CheckAll("flag",0 );
           break;
           case IBINSERT :
           		formObj.f_cmd.value=MULTI02;
           		initCkCount();
           		sheetObj.DoSave("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" +  ComGetPrefixParam("sheet2_"),"flag");
           		t1sheet_OnSearchEnd(sheetObj,'');
           		sheetObj.CheckAll("flag",0 );
           break;
           case IBDOWNEXCEL:        //download to excel
        	   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObj), SheetDesign:1,Merge:1 });
        	   break;
        }
    }
    
    // handling process of sheet
    function doActionIBSheet2(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //retrieving
        	   if(validateForm(formObj)){
        		   initSheet(sheetObj,3);
                   sheetObj.RemoveAll();
        		   formObj.f_cmd.value=SEARCH03;
        		   sheetObj.DoSearch("ESD_SCE_0035GS.do", SceFrmQryString(formObj) +  "&" + ComGetPrefixParam("sheet3_") );
        	   } else{
        		   isSearch=false;
        	   }
               formObj.dist2.value='N';
               break;
            case IBSAVE :
           		formObj.f_cmd.value=MULTI03;
           		sheetObj.DoSave("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet3_"),"flag");
           		t2sheet_OnSearchEnd(sheetObj,'');
           		sheetObj.CheckAll("flag",0 );
           		break;
			case IBINSERT :
				formObj.f_cmd.value=MULTI04;
				sheetObj.DoSave("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet3_"),"flag");
				t2sheet_OnSearchEnd(sheetObj,'');
				sheetObj.CheckAll("flag",0 );
				break;
			case IBSEARCHAPPEND:  // retrieving page
				formObj.f_cmd.value=SEARCH03;
				sheetObj.DoSearch("ESD_SCE_0035GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("sheet3_")+"&"+ "i_page=" + PageNo,{Append:true} );
				break;
			case IBDOWNEXCEL:        //download to excel
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObj), SheetDesign:1,Merge:1 });
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
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "Summary Report" , "");
					InsertItem( "Detail Report-COP" , "");
					InsertItem( "Detail Report-Others " , "");
                }
                break;
         }
    }
    
    //Initiating Check Box for Flag
    function initCkCount(){
    	document.form.ckCount.value=0;
    }
    
    function t1sheet_OnChange(sheetObj, Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) == "flag" && sheetObj.RowCount()>= 0)
			document.form.ckCount.value=sheetObj.CheckedRows("flag");
    }
    
    /**
    * Event when clicking Tab
    * activating selected tab items
    */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    
    function openESD009Screen(cs_grp_id, tp_id, grp_nm){
    	//Customer 돋보기 버튼으로 customer 정보 입력
    	var formObject=document.form;
    	formObject.cs_grp_id.value=cs_grp_id;
    	onObjectFocusout(formObject);
    	formObject.cs_grp_id.value=cs_grp_id;
    	formObject.tp_id.value=tp_id;
    	formObject.grp_nm.value=grp_nm;
    	formObject.mycust.value=cs_grp_id+"%"+tp_id+"%"+grp_nm ;
    }
        
    function openESD068Screen(cs_grp_id, tp_id, grp_nm){
        var formObject=document.form;
        formObject.cs_grp_id.value=cs_grp_id;
    	onObjectFocusout(formObject);
        formObject.cs_grp_id.value=cs_grp_id;
    	formObject.tp_id.value=tp_id;
    	formObject.grp_nm.value=grp_nm;
    }
    
    // setting event of double clicked on tab
    function t0sheet_OnDblClick(sheetObj,Row,Col){
    	var prefix="sheet1_";
    	var formObject=document.form;
        var colName=sheetObj.ColSaveName(Col);
        var temp_rail=sheetObj.GetCellValue(Row,prefix + "rail");
        var temp_tsport=sheetObj.GetCellValue(Row,prefix+ "ts_port");
        var temp_delcd=sheetObj.GetCellValue(Row,prefix+ "del_cd");
        var temp_rail_sub1=temp_rail.substring(0,1);
        var temp_rail_sub2=temp_rail.substring(1,2);
        var temp_delcd_sub=temp_delcd.substring(0,2);
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
                //(colName == "AVL_day") || (colName == "AVL_time")  ||
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
                  && sheetObj.GetCellValue(Row, Col) == ""
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
                var bkg_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "bkg_no");
                var cntr_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "cntr_no");
                var vvd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "vvd");
    			var bl_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "bl_no");
                var por_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "por_cd");
                var pol_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "pol_cd");
                var pod_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "pod_cd");
                var del_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "del_cd");
                var cop_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "cop_no");
                var edi_grp_cd=formObject.cs_grp_id.value;
                var paramUrl="bkg_no="+ bkg_no +"&cntr_no=" + cntr_no+"&cop_no=" + cop_no
                + "&vvd="+vvd+"&por_cd="+por_cd+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&bl_no="+bl_no + "&edi_grp_cd="+edi_grp_cd;
                var newWin =  ComOpenWindow("ESD_SCE_0060.do?"+paramUrl,  "list",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:450px" , true);
            }else if(Col >= 9){
            	var bkg_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "bkg_no");
            	var cntr_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "cntr_no");
            	var edi_sts=sheetObj.GetCellProperty(Row, Col, "SaveName").split("_")[1];
            	    if(edi_sts != "") edi_sts=toUpperCase(edi_sts);
            	var edi_grp_cd=formObject.cs_grp_id.value;
        		var paramUrl="bkg_no="+ bkg_no +"&cntr_no=" + cntr_no + "&edi_sts=" +
        			edi_sts  + "&edi_grp_cd="+edi_grp_cd;
                var newWin =  ComOpenWindow("ESD_SCE_0061.do?"+paramUrl,  "list",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:500px" , true);
            }
        }
    }
    
    function t1sheet_OnDblClick(sheetObj,Row,Col){
    	var prefix="sheet2_";
        if(Col < 8){
            var formObject=document.form;
            var bkg_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "bkg_no");
            var cntr_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "cntr_no");
            var vvd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "vvd");
			var bl_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "bl_no");
            var por_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "por_cd");
            var pol_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "pol_cd");
            var pod_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "pod_cd");
            var del_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "del_cd");
            var cop_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "cop_no");
            var edi_grp_cd=formObject.cs_grp_id.value;
            var paramUrl="bkg_no="+ bkg_no +"&cntr_no=" + cntr_no+"&cop_no=" + cop_no
                    + "&vvd="+vvd+"&por_cd="+por_cd+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&bl_no="+bl_no + "&edi_grp_cd="+edi_grp_cd;
            var newWin =  ComOpenWindow("ESD_SCE_0060.do?"+paramUrl,  "list",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:450px" , true);
        }
    }
    
    function t2sheet_OnDblClick(sheetObj,Row,Col){
        var prefix="sheet3_";
        if(Col < 8 ){
           var formObject=document.form;
            var bkg_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "bkg_no");
            var cntr_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "cntr_no");
            var vvd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "vvd");
			var bl_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "bl_no");
            var por_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "por_cd");
            var pol_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "pol_cd");
            var pod_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "pod_cd");
            var del_cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "del_cd");
            var cop_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix + "cop_no");
            var edi_grp_cd=formObject.cs_grp_id.value;
            var paramUrl="bkg_no="+ bkg_no +"&cntr_no=" + cntr_no+"&cop_no=" + cop_no
            + "&vvd="+vvd+"&por_cd="+por_cd+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&bl_no="+bl_no + "&edi_grp_cd="+edi_grp_cd;
            var newWin =  ComOpenWindow("ESD_SCE_0060.do?"+paramUrl,  "list",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:450px" , true);
        }
    }
    
    function t1sheet_OnClick(sheetObj,Row,Col){
    	var prefix="sheet2_";
    	//if(Col == 19 && sheetObj.GetCellValue(Row, prefix + "rbtn") == 0){
    	if(Col == 19 && sheetObj.GetCellValue(Row, prefix + "rbtn") == "/opuscntr/img/opus/button/btng_rowadd.gif"){
    		if(sheetObj.GetCellValue(Row,prefix + "edi_snd_knt") == ''){
  		  		return;
  		  	}
  		  	if(sheetObj.GetCellValue(Row+1,prefix + "ibflg") == 'INS'){
  		  		return;
  		  	}
		  //setting default value
  		  	var Row2=sheetObj.DataInsert();
  		  	var seq=0;
            sheetObj.SetCellImage(Row2,prefix + "rbtn",0);
  		  	sheetObj.SetCellValue(Row2, prefix + "vvd",sheetObj.GetCellValue(Row,prefix + "vvd"));
  		  	sheetObj.SetCellValue(Row2, prefix + "bkg_no",sheetObj.GetCellValue(Row,prefix + "bkg_no"));
  		  	sheetObj.SetCellValue(Row2, prefix + "cntr_no",sheetObj.GetCellValue(Row,prefix + "cntr_no"));
  		  	sheetObj.SetCellValue(Row2, prefix + "por_cd",sheetObj.GetCellValue(Row,prefix + "por_cd"));
  		  	sheetObj.SetCellValue(Row2, prefix + "pol_cd",sheetObj.GetCellValue(Row,prefix + "pol_cd"));
  		  	sheetObj.SetCellValue(Row2, prefix + "pod_cd",sheetObj.GetCellValue(Row,prefix + "pod_cd"));
  		  	sheetObj.SetCellValue(Row2, prefix + "del_cd",sheetObj.GetCellValue(Row,prefix + "del_cd"));
  		  	sheetObj.SetCellValue(Row2, prefix + "nod_cd",sheetObj.GetCellValue(Row,prefix + "nod_cd"));
  		  	sheetObj.SetCellValue(Row2, prefix + "edi_sts_cd",sheetObj.GetCellValue(Row,prefix + "edi_sts_cd"));
  		  	sheetObj.SetCellValue(Row2, prefix + "edi_sub_sts_cd",sheetObj.GetCellValue(Row,prefix + "edi_sub_sts_cd"));
  		  	if(sheetObj.GetCellValue(Row,prefix + "edi_snd_knt") == ''){
  		  		seq=0;
  		  	}else{
  		  		seq=Number(sheetObj.GetCellValue(Row,prefix +"edi_snd_knt"));
  		  	}
  		  	//sheetObj.SetCellValue(Row2, prefix +"edi_snd_knt")=seq+1;
  		  	sheetObj.SetCellValue(Row2, prefix +"edi_snd_knt",seq+1);
  		  	sheetObj.SetRowBackColor(Row2,"#C8F5FF");
    	}
    }
    
    function t2sheet_OnClick(sheetObj,Row,Col){
    	var prefix="sheet3_";
    	//if(Col == 19 && sheetObj.GetCellValue(Row, prefix + "rbtn") == 0){
    	if(Col == 19 && sheetObj.GetCellValue(Row, prefix + "rbtn") == "/opuscntr/img/opus/button/btng_rowadd.gif"){
    		if(sheetObj.GetCellValue(Row,prefix + "edi_snd_knt") == ''){
    			return;
    		}
	  		if(sheetObj.GetCellValue(Row+1,prefix + "ibflg") == 'INS'){
	  			return;
	  		}
			//setting default value
			var Row2=sheetObj.DataInsert();
			var seq=0;
     		sheetObj.SetCellImage(Row2,prefix + "rbtn",0);
            sheetObj.SetCellValue(Row2, prefix + "vvd",sheetObj.GetCellValue(Row,prefix + "vvd"));
            sheetObj.SetCellValue(Row2, prefix + "bkg_no",sheetObj.GetCellValue(Row,prefix + "bkg_no"));
            sheetObj.SetCellValue(Row2, prefix + "cntr_no",sheetObj.GetCellValue(Row,prefix + "cntr_no"));
            sheetObj.SetCellValue(Row2, prefix + "por_cd",sheetObj.GetCellValue(Row,prefix + "por_cd"));
            sheetObj.SetCellValue(Row2, prefix + "pol_cd",sheetObj.GetCellValue(Row,prefix + "pol_cd"));
            sheetObj.SetCellValue(Row2, prefix + "pod_cd",sheetObj.GetCellValue(Row,prefix + "pod_cd"));
            sheetObj.SetCellValue(Row2, prefix + "del_cd",sheetObj.GetCellValue(Row,prefix + "del_cd"));
            sheetObj.SetCellValue(Row2, prefix + "nod_cd",sheetObj.GetCellValue(Row,prefix + "nod_cd"));
            sheetObj.SetCellValue(Row2, prefix + "edi_sts_cd",sheetObj.GetCellValue(Row,prefix + "edi_sts_cd"));
            sheetObj.SetCellValue(Row2, prefix + "edi_sub_sts_cd",sheetObj.GetCellValue(Row,prefix + "edi_sub_sts_cd"));
            if(sheetObj.GetCellValue(Row,prefix +  "edi_snd_knt") == ''){
            	seq=0;
            }else{
            	seq=Number(sheetObj.GetCellValue(Row,prefix + "edi_snd_knt"));
            }
            sheetObj.SetCellValue(Row2, prefix + "edi_snd_knt",seq+1);
     		sheetObj.SetRowBackColor(Row2,"#C8F5FF");
    	}
    }
    
    function researchScreen(){
    	var sheetObject0=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        var sheetObject2=sheetObjects[2];
        var formObject=document.form;
    	doActionIBSheet0(sheetObject0,formObject,IBSEARCH);
        doActionIBSheet1(sheetObject1,formObject,IBSEARCH);
        doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
    }
    
    /**
    * handling process for input validation
    */
    function validateForm(formObj){
        var result=false ;
        if(!ComIsEmpty(formObj.cs_grp_id)){
       	    var formObject=document.form;                       	        	    
       	    if(!ComIsEmpty(formObject.podetaDate1) && !ComIsEmpty(formObject.podetaDate2)){
       	     formObject.podetadate1_hidden.value=dateConverting(formObject.podetaDate1.value);
       	     formObject.podetadate2_hidden.value=dateConverting(formObject.podetaDate2.value);   
       	    }else{
          	     formObject.podetadate1_hidden.value="";
           	     formObject.podetadate2_hidden.value="" 
       	    }
       	    if(!ComIsEmpty(formObject.poletdDate1) && !ComIsEmpty(formObject.poletdDate2)){
     	          formObject.poletddate1_hidden.value=dateConverting(formObject.poletdDate1.value);
     	          formObject.poletddate2_hidden.value=dateConverting(formObject.poletdDate2.value); 
       	    }else{
   	          formObject.poletddate1_hidden.value="";
 	          formObject.poletddate2_hidden.value="";
       	    }        	
            result=true;
            if(!ComIsEmpty(formObj.vvd) || !ComIsEmpty(formObj.bkg_no_)
            || !ComIsEmpty(formObj.bl_no_) || !ComIsEmpty(formObj.cntr_no_)){
            	//format : YYYMMDD
           	 var formObject=document.form;                       	        	    
           	    if(!ComIsEmpty(formObject.podetaDate1) && !ComIsEmpty(formObject.podetaDate2)){
           	     formObject.podetadate1_hidden.value=dateConverting(formObject.podetaDate1.value);
           	     formObject.podetadate2_hidden.value=dateConverting(formObject.podetaDate2.value);   
           	    }else{
              	     formObject.podetadate1_hidden.value="";
               	     formObject.podetadate2_hidden.value=""; 
           	    }
           	    if(!ComIsEmpty(formObject.poletdDate1) && !ComIsEmpty(formObject.poletdDate2)){
         	          formObject.poletddate1_hidden.value=dateConverting(formObject.poletdDate1.value);
         	          formObject.poletddate2_hidden.value=dateConverting(formObject.poletdDate2.value); 
           	    }else{
       	          formObject.poletddate1_hidden.value="";
     	          formObject.poletddate2_hidden.value="";        	    	
           	    }           	
                result=true;
            } else {
                if(!ComIsEmpty(formObj.poletdDate1) || !ComIsEmpty(formObj.poletdDate2)
                 || !ComIsEmpty(formObj.podetaDate1) || !ComIsEmpty(formObj.podetaDate2)  ){
                    if(!ComIsEmpty(formObj.poletdDate1) || !ComIsEmpty(formObj.poletdDate2)){
                        if(ComIsEmpty(formObj.pol)){
                             ComShowMessage('Either location or country code of POL is required.');
                             formObj.pol.focus();
                             result=false;
                        } else {
                             var temp_pol=formObj.pol.value.length;
                             if(temp_pol < 2){
                                 ComShowMessage('POL requires a country code 2 words long at least.');
                                 result=false;
                             } else if(temp_pol >= 2 && temp_pol < 5){
                                 if((ComParseInt(ComGetDaysBetween(formObj.poletdDate1.value, formObj.poletdDate2.value)) > 2) ){
                                      ComShowMessage("The period of T.VVD ETD is limited to 3 days in case POL doesn't have a full location code.");
                                      result=false
                                 } else {
                                	 //format : YYYMMDD
                                  	 var formObject=document.form;                       	 
                                	 formObject.poletddate1_hidden.value=dateConverting(formObject.poletdDate1.value);
                                	 formObject.poletddate2_hidden.value=dateConverting(formObject.poletdDate2.value);      
                                	 if(ComIsEmpty(formObject.podetaDate1) || ComIsEmpty(formObject.podetaDate2)){
                                  	     formObject.podetadate1_hidden.value="";
                                   	     formObject.podetadate2_hidden.value="" 
                                	 }//if
                                     result=true;
                                 }
                             } else {
                                 if((ComParseInt(ComGetDaysBetween(formObj.poletdDate1.value, formObj.poletdDate2.value)) > 4) ){
                                      ComShowMessage("The period of T.VVD ETD is limited to 5 days.");    // 5일까지 조회 가능~~
                                      result=false;
                                 } else {
                                	//format : YYYMMDD
                                  	 var formObject=document.form;                       	 
                                	 formObject.poletddate1_hidden.value=dateConverting(formObject.poletdDate1.value);
                                	 formObject.poletddate2_hidden.value=dateConverting(formObject.poletdDate2.value);  
                                	 if(ComIsEmpty(formObject.podetaDate1) || ComIsEmpty(formObject.podetaDate2)){
                                  	     formObject.podetadate1_hidden.value="";
                                   	     formObject.podetadate2_hidden.value="" 
                                	 }//if
                                     result=true;
                                 }
                             }
                        }
                    }
                    if(!ComIsEmpty(formObj.podetaDate1) || !ComIsEmpty(formObj.podetaDate2)){
                        if(ComIsEmpty(formObj.pod)){
                             ComShowMessage('Either location or country code of POD is required.');
                             formObj.pod.focus();
                             result=false;
                        } else {
                            var tmep_pod=formObj.pod.value.length;
                            if(tmep_pod < 2){
                                ComShowMessage('POD requires a country code 2 words long at least.');
                                result=false;
                            } else if(tmep_pod >= 2 && tmep_pod < 5){
                                 if((ComParseInt(ComGetDaysBetween(formObj.podetaDate1.value, formObj.podetaDate2.value)) > 2) ){
                                      ComShowMessage("The period of T.VVD ETA is limited to 3 days in case POD doesn't have a full location code.");    // 5일까지 조회 가능~~
                                      result=false
                                 } else {
                                  	 var formObject=document.form;                       	 
                                	 formObject.podetadate1_hidden.value=dateConverting(formObject.podetaDate1.value);
                                	 formObject.podetadate2_hidden.value=dateConverting(formObject.podetaDate2.value); 
                                	 if(ComIsEmpty(formObject.poletdDate1) || ComIsEmpty(formObject.poletdDate2)){
                              	          formObject.poletddate1_hidden.value="";
                             	          formObject.poletddate2_hidden.value="";  
                                	 }//if
                                     result=true;
                                 }
                            } else {
                                if((ComParseInt(ComGetDaysBetween(formObj.podetaDate1.value, formObj.podetaDate2.value)) > 4) ){
                                      ComShowMessage("The period of T.VVD ETA is limited to 5 days.");    // 5일까지 조회 가능~~
                                      result=false;
                                 } else {
                                	//format : YYYMMDD
                                  	 var formObject=document.form;                       	 
                                	 formObject.podetadate1_hidden.value=dateConverting(formObject.podetaDate1.value);
                                	 formObject.podetadate2_hidden.value=dateConverting(formObject.podetaDate2.value);
                                	 if(ComIsEmpty(formObject.poletdDate1) || ComIsEmpty(formObject.poletdDate2)){
                             	          formObject.poletddate1_hidden.value="";
                            	          formObject.poletddate2_hidden.value="";  
                               	     }//if                               	 
                                     result=true;
                                 }
                            }
                        }
                    }
                } else {
                	ComShowMessage(ComGetMsg('COM12113',"one of followings: VVD,BKG NO,CNTR NO or BL NO."));
                    result=false;
                }
            }
        }else{
        	ComShowMessage(ComGetMsg('COM12113',"EDI Customer Group."));
            result=false;
        }
        return result;
    }
    
    function chkVVD(formObj, ComIsEmptyVVD){
    	var result=true ;
   		var emptyVVd=ComIsEmptyVVD!=null ? ComIsEmptyVVD : ComIsEmpty(formObj.vvd) ;
   		if(!emptyVVd){
   		   if(ComIsEmpty(formObj.por) && ComIsEmpty(formObj.pol) && ComIsEmpty(formObj.pod) && ComIsEmpty(formObj.del)){
			    // && ComIsEmpty(formObj.DEL) ){
	            ComShowMessage(ComGetMsg('SCE90025'));
	            formObj.por.focus() ;
	            result=false ;
	        }
	        if(formObj.vvd.value.length < 9){
	        	ComShowMessage(ComGetMsg('SCE90035'));
	            formObj.vvd.focus() ;
	        	result=false ;
	        }
		}
		return result ;
    }
    
    function onValueChange(selectName, formObj){
    	switch(selectName){
    	    case 'mycust' :
    	       var temp_mycust=formObj.mycust.value;
    	       if(temp_mycust == ""){
    	          formObj.cs_grp_id.value="";
        	      formObj.tp_id.value="";
        	      formObj.grp_nm.value="";
        	      formObj.edi_sts.value="";
        	      sheetObj.RemoveEtcData();
    	       } else {
        	       var arr_mycust=temp_mycust.split("%");
        	       formObj.cs_grp_id.value=arr_mycust[0];
        	       formObj.tp_id.value=arr_mycust[1];
        	       formObj.grp_nm.value=arr_mycust[2];
        	       formObj.edi_sts.value="";
                   var sheetObj=sheetObjects[1];
                   //initiating the value of ETC Data
                   sheetObj.RemoveEtcData();
                   formObj.f_cmd.value=MULTI05;
                   //sheetObj.DoSearch("ESD_SCE_0035GS.do",SceFrmQryString(formObj) );
//                   var sXml=sheetObj.GetSearchData("ESD_SCE_0035GS.do", FormQueryString(document.form));
//                   var sXml=sheetObj.GetSearchData("ESD_SCE_0035GS.do", SceFrmQryString(document.form));
                   var edi_sts_str=ComSearchEtcData(sheetObj, "ESD_SCE_0035GS.do", SceFrmQryString(formObj), "edi_sts");
//                   var edi_sts_str =sheetObj.ComGetEtcData(sXml,"edi_sts");
//                	   sheetObj.LoadSearchData(sXml,{Sync:1} );
                   if(edi_sts_str != null){ 
                	     formObj.edi_sts.value=edi_sts_str;
                   }else{
                	     formObj.edi_sts.value="";
                   }
    	       }
    	       break;
    	}
	}
    
	// changing cell color of excluding from target.
	function targetBlocking(sheetObj,diff){
	    var rowCnt=sheetObj.RowCount();
        var shts_port="";
        var sh_rail="";
        var sh_del="";
        var sh_edists="";
        var temp_sh_rail1="";
        var temp_sh_rail2="";
        var temp_sh_del="";
        var cust_edi_sts_cd="";
        var prefix='';
        var cust_edi_sts=document.form.edi_sts.value;
        var varNewTitle=cust_edi_sts.replace(/,/g, '|');
        var aryTitle;
		if (varNewTitle.length > 0){
			aryTitle=varNewTitle.split("|");
		}else{
			aryTitle=new Array();
		}
	    if(diff == 1){
	    	prefix='sheet1_';
    	    for(var i=1; i <= rowCnt; i++){
    	    	shts_port=sheetObj.GetCellValue(i,prefix + "ts_port");
    	    	sh_rail=sheetObj.GetCellValue(i,prefix + "rail");
    	    	sh_del=sheetObj.GetCellValue(i,prefix + "del_cd");             
    	    	temp_sh_rail1=sh_rail.substring(0,1);
    	    	temp_sh_rail2=sh_rail.substring(1,2);
    	    	temp_sh_del=sh_del.substring(0,2);
    	    	if(temp_sh_rail1 == "X"){                                  //not outbound
    	    		sheetObj.SetCellBackColor(i,"ALO_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"ALO_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"RLO_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"RLO_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"ARO_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"ARO_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"URO_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"URO_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"FOTRDO_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"FOTRDO_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"FOTRAD_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"FOTRAD_time","#555555");
    	    	}
    	    	if(temp_sh_rail2 == "X"){                                     //not inbound
    	    		sheetObj.SetCellBackColor(i,"ALN_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"ALN_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"RLN_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"RLN_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"ARN_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"ARN_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"URN_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"URN_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"FITRAD_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"FITRAD_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"FITRDO_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"FITRDO_time","#555555");
    	    		//sheetObj.SetCellBackColor(i,"AVL_day","#555555");
    	    		//sheetObj.SetCellBackColor(i,"AVL_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"ACN_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"ACN_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AFN_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AFN_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AON_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AON_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"NT_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"NT_time","#555555");
    	    	}
    	    	if(sh_rail == "II"){                                  // exists inbount - rail shipment
    	    		sheetObj.SetCellBackColor(i,"AVL_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AVL_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"ACL_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"ACL_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AFL_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AFL_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AOL_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AOL_time","#555555");
    	    	}
    	    	if(shts_port == ""){                                    // exists  t/s  shipment
    	    		sheetObj.SetCellBackColor(i,"VAT_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"VAT_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"UVT_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"UVT_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AET_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AET_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"VDT_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"VDT_time","#555555");
    	    	}
    	    	if(temp_sh_del != "US" && temp_sh_del != "CA"){
    	    		sheetObj.SetCellBackColor(i,"CT_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"CT_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"CC_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"CC_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"CU_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"CU_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"HR_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"HR_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"PA_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"PA_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"PQ_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"PQ_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AVN_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AVN_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AVL_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AVL_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"ACN_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"ACN_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"ACL_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"ACL_time","#555555");
    	    	}
    	    	if((temp_sh_del != "CA") && (temp_sh_del != "MX")){
    	    		sheetObj.SetCellBackColor(i,"OB_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"OB_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AFN_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AFN_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AFL_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AFL_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AON_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AON_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"AOL_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"AOL_time","#555555");
    	    	}
    	    	if((temp_sh_del != "US") && (temp_sh_del != "CA") && (temp_sh_del != "MX")){
    	    		sheetObj.SetCellBackColor(i,"NFR_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"NFR_time","#555555");
    	    		sheetObj.SetCellBackColor(i,"FTP_day","#555555");
    	    		sheetObj.SetCellBackColor(i,"FTP_time","#555555");
    	    	}
    	    	if((grp_cust == 'USA00285')){    //special customer 
    	    		for( var k=0; k < aryTitle.length ; k++){
    	    			if(aryTitle[k] == "ARN"){
    	    				cust_edi_sts_cd=sheetObj.GetCellValue(i,"ARN_sts");
    	    				if(cust_edi_sts_cd == 'X1' && temp_sh_rail2 != 'I'){
    	    					sheetObj.SetCellBackColor(i,"ARN_day","#555555");
    	    					sheetObj.SetCellBackColor(i,"ARN_time","#555555");
    	    				}
    	    			} else if(aryTitle[k] == "VAD"){
    	    				cust_edi_sts_cd=sheetObj.GetCellValue(i,"VAD_sts");
    	    				if(cust_edi_sts_cd == 'X1' && temp_sh_rail2 != 'X'){
    	    					sheetObj.SetCellBackColor(i,"VAD_day","#555555");
    	    					sheetObj.SetCellBackColor(i,"VAD_time","#555555");
    	    				}
    	    			}
    	    		}
    	    	}
    	    }
	    } else if(diff == 2 || diff == 3){
	    	if(diff == 2){
	    		prefix='sheet2_';
	    	}else if(diff == 3){
	    		prefix='sheet3_';
	    	}//if
	        for(var i=1; i <= rowCnt; i++){
	        	shts_port=sheetObj.GetCellValue(i,prefix + "ts_port");
	        	sh_rail=sheetObj.GetCellValue(i,prefix + "rail");
	        	sh_edists=sheetObj.GetCellValue(i,prefix + "edi_sts_cd");
	        	sh_del=sheetObj.GetCellValue(i,prefix + "del_cd");
	        	cust_edi_sts_cd=sheetObj.GetCellValue(i,prefix + "edi_sub_sts_cd");
	        	temp_sh_rail1=sh_rail.substring(0,1);
	        	temp_sh_rail2=sh_rail.substring(1,2);
	        	temp_sh_del=sh_del.substring(0,2);
	        	if((temp_sh_rail1 == "X") && ((sh_edists == "ALO") || (sh_edists == "RLO") || (sh_edists == "ARO") || (sh_edists == "URO") || (sh_edists == "FOTRDO") || (sh_edists == "FOTRAD") )){                                  //outbound가 아닐 경우
	        		sheetObj.SetCellEditable(i,"flag",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt1",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt2",0);
                    sheetObj.SetCellEditable(i,prefix + "nod_cd",0);
                    sheetObj.SetCellBackColor(i,prefix + "act_dt1","#555555");
                    sheetObj.SetCellBackColor(i,prefix +"act_dt2","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "nod_cd","#555555");
                    sheetObj.SetCellValue(i, "flag",'N');
	        	}
                if((temp_sh_rail2 == "X") && ( (sh_edists == "RLN") || (sh_edists == "ARN") || (sh_edists == "URN") || (sh_edists == "FITRAD") || (sh_edists == "FITRDO") || (sh_edists == "NT") )){
                    sheetObj.SetCellEditable(i,"flag",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt1",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt2",0);
                    sheetObj.SetCellEditable(i,prefix + "nod_cd",0);
                    sheetObj.SetCellBackColor(i,prefix + "act_dt1","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "act_dt2","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "nod_cd","#555555");
                    sheetObj.SetCellValue(i, "flag",'N');
	        	}
	        	if((sh_rail == "II") && ((sh_edists == "AVL") || (sh_edists == "ACL") || (sh_edists == "AFL") || (sh_edists == "AOL"))){
                    sheetObj.SetCellEditable(i,"flag",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt1",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt2",0);
                    sheetObj.SetCellEditable(i,prefix + "nod_cd",0);
                    sheetObj.SetCellBackColor(i,prefix + "act_dt1","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "act_dt2","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "nod_cd","#555555");
                    sheetObj.SetCellValue(i, "flag",'N');
	        	}
	        	if((shts_port == "") && ((sh_edists == "VAT") || (sh_edists == "UVT") || (sh_edists == "AET") || (sh_edists == "VDT"))){
                    sheetObj.SetCellEditable(i,"flag",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt1",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt2",0);
                    sheetObj.SetCellEditable(i,prefix + "nod_cd",0);
                    sheetObj.SetCellBackColor(i,prefix + "act_dt1","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "act_dt2","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "nod_cd","#555555");
                    sheetObj.SetCellValue(i, "flag",'N');
	        	}
	        	if((temp_sh_del != "US") && (temp_sh_del != "CA") && ((sh_edists == "CT") || (sh_edists == "CC") || (sh_edists == "CU") || (sh_edists == "HR") || (sh_edists == "PA") || (sh_edists == "PQ") || (sh_edists == "AVN")
                   || (sh_edists == "ACN") || (sh_edists == "ACL"))){
                    sheetObj.SetCellEditable(i,"flag",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt1",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt2",0);
                    sheetObj.SetCellEditable(i,prefix + "nod_cd",0);
                    sheetObj.SetCellBackColor(i,prefix + "act_dt1","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "act_dt2","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "nod_cd","#555555");
                    sheetObj.SetCellValue(i, "flag",'N');
	        	}
	        	if(((temp_sh_del != "CA") && (temp_sh_del != "MX")) && ((sh_edists == "OB") || (sh_edists == "AFN") || (sh_edists == "AFL") || (sh_edists == "AON") || (sh_edists == "AOL"))){
                    sheetObj.SetCellEditable(i,"flag",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt1",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt2",0);
                    sheetObj.SetCellEditable(i,prefix + "nod_cd",0);
                    sheetObj.SetCellBackColor(i,prefix + "act_dt1","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "act_dt2","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "nod_cd","#555555");
                    sheetObj.SetCellValue(i, "flag",'N');
	        	}
	        	if(((temp_sh_del != "US") && (temp_sh_del != "CA") && (temp_sh_del != "MX")) && ((sh_edists == "NFR") || (sh_edists == "FTR"))){
                    sheetObj.SetCellEditable(i,"flag",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt1",0);
                    sheetObj.SetCellEditable(i,prefix + "act_dt2",0);
                    sheetObj.SetCellEditable(i,prefix + "nod_cd",0);
                    sheetObj.SetCellBackColor(i,prefix + "act_dt1","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "act_dt2","#555555");
                    sheetObj.SetCellBackColor(i,prefix + "nod_cd","#555555");
                    sheetObj.SetCellValue(i, "flag",'N');
	        	}
	        	if((grp_cust == 'USA00285') && (cust_edi_sts_cd == 'X1')){    // special customer
	        		if((sh_edists == 'ARN') && (temp_sh_rail2 != 'I')){                      //   Rail shipment
	        			sheetObj.SetCellEditable(i,"flag",0);
	        			sheetObj.SetCellEditable(i,prefix + "act_dt1",0);
	        			sheetObj.SetCellEditable(i,prefix + "act_dt2",0);
	        			sheetObj.SetCellEditable(i,prefix + "nod_cd",0);
	        			sheetObj.SetCellBackColor(i,prefix + "act_dt1","#555555");
	        			sheetObj.SetCellBackColor(i,prefix + "act_dt2","#555555");
	        			sheetObj.SetCellBackColor(i,prefix + "nod_cd","#555555");
	        			sheetObj.SetCellValue(i, "flag",'N');
	        		} else if((sh_edists == 'VAD') && (temp_sh_rail2 != 'X')){               //   Local shipment
	        			sheetObj.SetCellEditable(i,"flag",0);
	        			sheetObj.SetCellEditable(i,prefix + "act_dt1",0);
	        			sheetObj.SetCellEditable(i,prefix + "act_dt2",0);
	        			sheetObj.SetCellEditable(i,prefix + "nod_cd",0);
	        			sheetObj.SetCellBackColor(i,prefix + "act_dt1","#555555");
	        			sheetObj.SetCellBackColor(i,prefix + "act_dt2","#555555");
	        			sheetObj.SetCellBackColor(i,prefix + "nod_cd","#555555");
	        			sheetObj.SetCellValue(i, "flag",'N');
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
        with(sheetObj){
            targetBlocking(sheetObj,2);
        }
    }
    
    function t2sheet_OnSearchEnd(sheetObj,ErrMsg){
        with(sheetObj){
            targetBlocking(sheetObj,3);
        }
    }
    
    // checking calendar
    function openCalendar(diff){
        var formObject=document.form;
        var from_date="";
        var to_date="";
        var obj_from_date="";
        var obj_to_date="";
        var cal=new ComCalendarFromTo();
        switch(diff){
           case '1':
             from_date="poletdDate1";
             to_date="poletdDate2";
             obj_from_date=formObject.poletdDate1;
             obj_to_date=formObject.poletdDate2;
             cal.displayType="date";
             cal.select(obj_from_date,obj_to_date, 'yyyy-MM-dd');      
           break;
           case '2':
             from_date="podetaDate1";
             to_date="podetaDate2";
             obj_from_date=formObject.podetaDate1;
             obj_to_date=formObject.podetaDate2;
             cal.displayType="date";
             cal.select(obj_from_date,obj_to_date, 'yyyy-MM-dd');                  
           break;
        }
    }
    
    function onObjectFocusout(formObj){
    	if(formObj.mycust.value == ''){
    		formObj.cs_grp_id.value=toUpperCase(formObj.cs_grp_id.value);
	    	var sheetObj=sheetObjects[1];
	    	sheetObj.ShowDebugMsg(false);
	    	formObj.f_cmd.value=MULTI05;
	    	sheetObj.RemoveEtcData();
	    	if(formObj.cs_grp_id.value !=''){  
//parameter changed[check again]CLT
	    		
	    		//sheetObj.DoSearch("ESD_SCE_0035GS.do",SceFrmQryString(formObj) );
	    		var sXml=sheetObj.GetSearchData("ESD_SCE_0035GS.do", SceFrmQryString(formObj));
	    		if(sXml.length>0){
                	
                	formObj.cs_grp_id.value = ComGetEtcData(sXml,"cs_grp_id");
                	formObj.tp_id.value = ComGetEtcData(sXml,"tp_id");
                	formObj.grp_nm.value = ComGetEtcData(sXml,"grp_nm");
                	formObj.mycust.value = ComGetEtcData(sXml,"cs_grp_id")+"%"+ComGetEtcData(sXml,"tp_id")+"%"+ ComGetEtcData(sXml,"grp_nm") ;
                	formObj.edi_sts.value = ComGetEtcData(sXml,"edi_sts");
                }
                
  		      	ComEtcDataToForm(formObj,sheetObj);
  		      	/*초기화*/
  		      	if(formObj.tp_id.value == ''){
  		      		formObj.cs_grp_id.value=''
  		      	}
	    	}
    	}
    }
    
    function initVcontainer(array){
    	//initializing data
        for(var n=0;n<array.length;n++){
        	array[n]="";
        }//for  
    }
    
    var request=null;
    function createHttpRequest() {
    	try{
    		request=new XMLHttpRequest();
    	} catch(trymicrosoft) {
    		try{
    			request=new ActiveXObject("Msxml2.XMLHTTP");
    		} catch(othermicosoft) {
    			try{
    				request=new ActiveXObject("Microsoft.XMLHTTP");
    			} catch(failed) {
    				request=null;
    			}
    		}
    	}
    	if( request == null ) {
    		ComShowMessage("Erroe Request XMLHttp");
    	}
    }
    
    function searchingCntEct(){
    	var formObj=document.form;
    	var tp_id=formObj.tp_id.value;
    	var url="ESD_SCE_0035GS.do?f_cmd="+ MULTI06 +"&tp_id="+ tp_id;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange=getCntEct;
		request.send(null);   	
    }
    
    function getFiledNames(colorder){
    	if(colorder != ""){
    		return colorder.split("|");
    	}else{
    		return;
    	}
    }
    
    function getFieldNameIndex(array,fName){
    	var index=-1;
    	for(var n=0;n<array.length;n++){
    		if(array[n] == fName) 
    			{
    			  index=n;
    			  break;
    			}
    	}//for
    	return index;
    }
    
    function getXMLAttribute(xml,attribute,index1,index2){
		var data=xml.getElementsByTagName(attribute)[index1];
		var data_attribute=data.attributes[index2].nodeValue; 
		return data_attribute;
    }
    
    function getCntEct(){
    	var cnt=0;
    	if( request.readyState == 4 ) {
    		if( request.status == 200 ) 
    		    {
    			  var delimination="☜☞";
    			  var docXml=request.responseXML;
    			  var rIndex=docXml.getElementsByTagName("ETC").length;
    			  for(var n=0;n<=rIndex;n++){
    				  if(docXml.getElementsByTagName("ETC")[n].getAttribute("KEY") != "" &&
    				     docXml.getElementsByTagName("ETC")[n].getAttribute("KEY").indexOf('tp_id_cnt') != -1)
    				  {    			
    					  cnt=docXml.getElementsByTagName("ETC")[n].firstChild.nodeValue;
    					  break;
    				  }
    			  }
    			  var cIndex1=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"tp_id");   			  
    			  var cIndex2=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cust_cd");
    			  var cIndex3=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cs_grp_id"); 
    			  var cIndex4=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"edi_sts"); 
    			  var cIndex5=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cs_desc");
    			  var fRow=null;
    			  if(rIndex >0)
                  {     				
    			    etc_value_container[0]=cnt;//count setting    			    
    			    if(cnt >0){
    			    	fRow=docXml.getElementsByTagName("TR")[0].firstChild.nodeValue;  
        			    etc_value_container[1]=(fRow.split(delimination))[cIndex1]; //tp_id setting
        			    etc_value_container[2]=(fRow.split(delimination))[cIndex2]; //cust_cd setting
        			    etc_value_container[3]=(fRow.split(delimination))[cIndex3]; //cs_grp_id setting
        			    //etc_value_container[4] = (fRow.split(delimination))[cIndex4]; //edi_sts setting
						var ediStsArray=(fRow.split(delimination))[cIndex4].split(",");
						var str="";
						for(var i=0; i<ediStsArray.length; i++){
							var cnt=0;							
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
						etc_value_container[4]=str; //edi_sts setting
        			    etc_value_container[5]=(fRow.split(delimination))[cIndex5]; //cs_desc setting 
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
    
    var etc_value_container=new Array(6);
    function onObjectTpId(formObj){
        if(formObj.cs_grp_id.value == "" && (formObj.tp_id.value != "" && ComTrim(formObj.tp_id.value) != "")){//전병석 수정
            formObj.tp_id.value=toUpperCase(formObj.tp_id.value);
            var sheetObj=sheetObjects[0];
            sheetObj.ShowDebugMsg(false);
            initVcontainer(etc_value_container);
            searchingCntEct();
        	/*new source*/                        
            var result_cnt=etc_value_container[0];
            var result_tp_id=etc_value_container[1];
            var cust_cd=etc_value_container[2];
            var cs_grp_id=etc_value_container[3];
            var edi_sts=etc_value_container[4];
            var cs_desc=etc_value_container[5];
            var param="?tp_id="+ result_tp_id;
            if(result_cnt > 1){
            	var newWin =  ComOpenWindow("ESD_SCE_0068.do"+param,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:390px" , true);
            } else {
                //IBS_EtcDataToForm2(formObj,sheetObj) ;
            	formObj.tp_id.value=result_tp_id;
            	formObj.cs_grp_id.value=cs_grp_id;
            	formObj.edi_sts.value=edi_sts;
            	formObj.grp_nm.value=cs_desc;
            }
        }
    }
    
    function openfunction(){
    	var formObject=document.form;
       	formObject.action="ESD_SCE_0035.do";
        formObject.f_cmd.value="" ;
        formObject.submit();
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
    function onEnterKey(){
    }
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }