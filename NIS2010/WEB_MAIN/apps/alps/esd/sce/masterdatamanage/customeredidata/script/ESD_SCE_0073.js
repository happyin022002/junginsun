// 공통전역변수
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;

var isSearch = false;

var comboObjects = new Array();
var comboCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;
         formObject.cs_grp_id.value = toUpperCase(formObject.cs_grp_id.value);
         formObject.tp_id.value = toUpperCase(formObject.tp_id.value);
         formObject.grp_nm.value = toUpperCase(formObject.grp_nm.value);
         form.edi_grp_id.value = formObject.cs_grp_id.value;
         form.tp_cd.value = formObject.tp_id.value;
         form.edi_grp_desc.value = formObject.grp_nm.value;
 				 form.edi_cgo_rmk.value = formObject.mycust.Text;
 				var opener = window.dialogArguments;		 
         try{
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
                 case "btn_retrieve":
                 		
                    if(formObject.cs_grp_id.value != ""){
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    } else {
                        ComShowMessage("Please select EDI Customer Group.");
                    }
                    break;
                 
                 case "btn_save":
              		
                	 if(formObject.mycust.Text == ""){
                        ComShowMessage("Report name is required.");
                        break;
                    }
                	 
                    if(formObject.mycust.Text == "" || formObject.cs_grp_id.value == ""){
                        ComShowMessage("Please, Select EDI Customer Group.");
                        break;
                    }
                   	if(sheetObject.CheckedRows("s_use_flg")>0){
                        var chkrow = 0;
                        for(var i = 0 ; i < sheetObject.CheckedRows("s_use_flg"); i++){
                            chkrow = sheetObject.FindCheckedRow("s_use_flg").split('|')[i];
                        }
                    } else {
                        ComShowMessage("Please, Check CheckBox");
                        break;
                    }
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    var rptName = formObject.mycust.Text;
                    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
                    comboObjects[0].Text = rptName;
                    
                    break;
                 
                 case "btn_ok":

                	 
                    var chkcnt = sheetObject.RowCount + 1;
                    if(chkcnt < 2){
	    				ComShowMessage('Please select at least one.');
	    			return false;
                    }
                    
                    if(formObject.openPgmNo.value == "ESD_SCE_0072"){
	                    var reportName = formObject.mycust.text;
	                    var ediCdInfo = formObject.cs_grp_id.value+"%"+formObject.tp_id.value+"%"+formObject.grp_nm.value;
	                	var temp_edi_sts = "";
	        	    	var temp_cust_sts = "";
	        	    	var temp_basic_form = "";
	        	    	var y= 0;
	        	    	var z= 0;
	                    for(var k = 1 ; k < chkcnt ; k++){
	                    	if(sheetObject.CellValue(k,"s_use_flg")=="1" && sheetObject.CellValue(k,"s_hidden_flg")=="1" && sheetObject.CellValue(k,"s_edi_sts_flg")=="N"){
	                    		if(y=="0"){
	                    			y=1;
	                    			temp_basic_form = sheetObject.CellValue(k,"s_rpt_col_nm");
	                    		}else{
	                    			temp_basic_form = temp_basic_form +","+ sheetObject.CellValue(k,"s_rpt_col_nm");
	                    		}
	                    	}
	                    	if(sheetObject.CellValue(k,"s_use_flg")=="1" && sheetObject.CellValue(k,"s_hidden_flg")=="1" && sheetObject.CellValue(k,"s_edi_sts_flg")=="Y"){
	                    		if(z=="0"){
	                    			z=1;
	                    			temp_edi_sts = sheetObject.CellValue(k,"s_rpt_col_nm").substring(0,sheetObject.CellValue(k,"s_rpt_col_nm").length -2);
	                    		}else{
	                    		temp_edi_sts = temp_edi_sts +","+ sheetObject.CellValue(k,"s_rpt_col_nm").substring(0,sheetObject.CellValue(k,"s_rpt_col_nm").length -2);
	                    		}
	                    	}
	                    }
	                    

	                    opener.open073Screen(reportName, ediCdInfo, temp_edi_sts,temp_cust_sts, temp_basic_form);
	                    opener.doActionIBSheet(opener.sheetObjects[2], opener.document.form, IBSEARCH_ASYNC01); 
                    }
                    
                    if(formObject.openPgmNo.value == "ESD_SCE_0090"){
                    	opener.doActionIBSheet1(opener.sheetObjects[1],opener.document.form,IBSEARCH);    
                    }
	                    self.close();
                    	
                    break;
                    
                 case "btn_close":
                    self.close();
                    break;
                    
                 case "btng_cntrlist":
                    window.open ("ESD_SCE_0073.do?newOld=2", "performance", "scrollbars=no,resizable=yes,fullscreen=no,width=580,height=480");
                    break;
                    
                 case "btn_delete":
                	 	if(document.form.mycust.text==""){
                	 		ComShowMessage("There is no report name to delete");
                	 	}else{
                	 		 if(ComShowConfirm("Do you want to delete this report name?")){
	                	 		 document.form.f_cmd.value = REMOVE01; 
	                		     var sXml = sheetObjects[0].GetSearchXml("ESD_SCE_0073GS.do", SceFrmQryString(document.form));
	                		     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);  
	                		     sheetObjects[0].RemoveAll();
	                		     document.form.cs_grp_id.value = "";
	                		     document.form.tp_id.value = "";
	                		     document.form.grp_nm.value = "";
                	 		 }
                	 	}
                     break;
             }
         } catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage(getMsg('COM12111'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
    }
    
    function loadPage(){
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // Combo 추가
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	var opener = window.dialogArguments;
    	var formObject = document.form ;
    	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
    	if(formObject.openPgmNo.value == "ESD_SCE_0072"){
    		if(opener.document.form.cs_grp_id.value !=""){
    			formObject.cs_grp_id.value=opener.document.form.cs_grp_id.value;
    			onObjectFocusout(formObject);
//    				if(opener.document.form.cs_grp_id.Text !=""){
//    					comboObjects[0].Text2 = opener.document.form.mycust.Text;
//    				}
//    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    		}
    	}
    	if(formObject.openPgmNo.value == "ESD_SCE_0090" && formObject.newOld.value == "4"){
    		comboObjects[0].Text = formObject.openRepNm.value;
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }
    
    function initCombo(comboObj, comboNo) {
    	switch (comboObj.id) {
    	case "mycust":
    		with (comboObj) {
    			DropHeight = 260;
    			MultiSelect = false;
    			MaxSelect = 1;
    			UseAutoComplete = false;
    			MaxLength = 30;
    			IMEMode = 0;
    			ValidChar(2, 1);
    			SetColWidth("50|200");
    			UseEdit=true;
    			UseCode=true;
    		}
    		break;
    	}
    }
    
    // Combo 변경시 이벤트 처리
    function mycust_OnChange(comboObj, code, text) {
    	var formObj = document.form ;
    	if(formObj.mycust.Code != ""){
    		var values  = formObj.mycust.Code.split("%");
    		if( values[0] != undefined){
    			formObj.cs_grp_id.value       = values[0];
    		}
    		if( values[1] != undefined){
    			formObj.tp_id.value       = values[1];
    		}
    		if( values[2] != undefined){
    			formObj.grp_nm.value      = values[2];
    		}
    	}else if(formObj.mycust.Text == ""){
    		formObj.cs_grp_id.value = "";
    		formObj.tp_id.value = "";
    		formObj.grp_nm.value = "";
    		sheetObjects[0].RemoveAll();
    	}
    	if(formObj.mycust.Code!=""){
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
	}
    
    function initSheet(sheetObj,sheetNo,etdeta) {
        var cnt = 0;

        switch(sheetNo) {
            case 1:
                with(sheetObj){
                    style.height = GetSheetHeight(13) ;
                    SheetWidth = mainTable.clientWidth;
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    MergeSheet = msNone;
                    Editable = true;
                    InitRowInfo( 1, 1, 9, 50);
                    InitColumnInfo(10, 0, 0, true);
                    InitHeadMode(false, true, true, true, false,false);
                    var HeadTitle = "||Column Seq|Column Name|Column Desc|s_edi_sts_flg|CUST EDI STS|s_hidden_flg|s_cre_usr_id|s_edi_grp_cd" ;
                    InitHeadRow(0, HeadTitle, false);
                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus,   25,    daCenter,  false,    "ibflag",     	  false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtCheckBox,  50,    daCenter,  false,    "s_use_flg",           false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  false,    "s_rpt_col_seq",        false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  false,    "s_rpt_col_nm",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  false,    "s_rpt_col_desc",        false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       100,    daCenter,  false,    "s_edi_sts_flg",        false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  false,    "s_cust_edi_sts_cd",        false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       100,    daCenter,  false,    "s_hidden_flg",        false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       100,    daCenter,  false,    "s_cre_usr_id",        false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,       100,    daCenter,  false,    "s_edi_grp_cd",        false,          "",       dfNone,   	0,     false,       true);
                }
                break;
        }
    }
    
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
				
        switch(sAction) {
        	case IBSEARCH_ASYNC01:	//콤보 조회
        		comboObjects[0].RemoveAll();
        		formObj.f_cmd.value = SEARCHLIST;
        		var sXml = sheetObj.GetSearchXml("ESD_SCE_0073GS.do", FormQueryString(formObj));
        		ComSceXml2ComboItem(sXml, formObj.mycust, "code", "text");
        		comboObjects[0].InsertItem(0, ''); 
			break;	
			
            case IBSEARCH:
                    formObj.f_cmd.value = SEARCH01;
                    selectVal = SceFrmQryString(formObj);
                    sheetObj.DoSearch4Post("ESD_SCE_0073GS.do", selectVal); 

                    var chkcnt = sheetObj.RowCount + 1;
        	    	for(var k = 1 ; k < chkcnt ; k++){
        	    	    if(k > 0 && sheetObjects[0].CellValue(k,"s_hidden_flg")!="1"){
        	    	    	sheetObjects[0].RowHidden(k)=true;
        	    	    	sheetObjects[0].CellValue(k,"s_use_flg")=0;
        	    	    }
        	    	    if(k > 0 && (sheetObjects[0].CellValue(k,"s_rpt_col_seq")=="1" || sheetObjects[0].CellValue(k,"s_rpt_col_seq")=="2" || sheetObjects[0].CellValue(k,"s_rpt_col_seq")=="3")){
        	    	    	sheetObjects[0].RowEditable(k)=false;
        	    	    }
        	    	}
                    
            break;
            
            case IBINSERT:
            	
        		formObj.f_cmd.value = MULTI;
                sheetObj.DoAllSave("ESD_SCE_0073GS.do", SceFrmQryString(formObj));
                ComShowMessage("SAVED SUCCESSFULLY");
              
            break;
        }
    }
    
    
    function onObjectFocusout(formObj){
        if(formObj.cs_grp_id.value != ""){
        	formObj.cs_grp_id.value = toUpperCase(formObj.cs_grp_id.value);
	        var formObject = document.form;
	        var sheetObj = sheetObjects[0];
	        
	        sheetObj.ShowDebugMsg = false;
	        formObj.f_cmd.value = SEARCHLIST03; 
	        form.edi_grp_id.value = toUpperCase(formObject.cs_grp_id.value);
	        //sheetObj.DoSearch("ESD_SCE_0073GS.do",SceFrmQryString(formObject));
	        var sXml = sheetObj.GetSearchXml("ESD_SCE_0073GS.do", SceFrmQryString(formObj));
	        		
					var call_cs_grp_id = ComGetEtcData(sXml, "edi_grp_id");
					if(call_cs_grp_id == undefined) {
						call_cs_grp_id = "";
					}
					var call_tp_id = ComGetEtcData(sXml, "tp_id");
					if(call_tp_id == undefined) {
						call_tp_id = "";
					}
					var call_grp_nm = ComGetEtcData(sXml, "grp_nm");
					if(call_grp_nm == undefined) {
						call_grp_nm = "";
					}
					formObj.cs_grp_id.value = call_cs_grp_id;
					formObj.tp_id.value = call_tp_id;
					formObj.grp_nm.value = call_grp_nm;
	      }
        if(formObj.cs_grp_id.value == ""){
        	comboObjects[0].Text="";
        	formObj.tp_id.value = "";
			formObj.grp_nm.value = "";
        }
        
        if(formObj.cs_grp_id.value!=""){
        	var grpCd = formObject.cs_grp_id.value+"%"+toUpperCase(formObject.tp_id.value)+"%"+toUpperCase(formObject.grp_nm.value);
        	if(comboObjects[0].GetText(grpCd,0)){
        		comboObjects[0].Text = comboObjects[0].GetText(grpCd,0);
        	}else {
            	comboObjects[0].Text2 ="";
        	}
        }
    	if(formObj.cs_grp_id.value != "" && formObject.mycust.Text==""){
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }
    
    function openCustomer(){	// 팝업 오픈
//    	window.open ("ESD_SCE_0062.do?mycust=2", "list12", "scrollbars=no,resizable=yes,fullscreen=no,width=500,height=510");
    	var newWin = window.showModalDialog("ESD_SCE_0062.do?mycust=2", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:510px");
    	onObjectFocusout(document.form);
    }

    function openESD009Screen(cs_grp_id, tp_id, grp_nm){	// 사용 안됨
    	var formObject = document.form;
    	formObject.cs_grp_id.value = cs_grp_id;
    	formObject.tp_id.value = tp_id;
    	formObject.grp_nm.value = grp_nm;

//    	onObjectFocusout(formObject);
    }
    
    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
        }  
        return str;      
    }
    
    // tp_id가 2개 이상일 경우 팝업~~
    function onObjectTpId(formObj){	
    		//if(formObj.cs_grp_id.value == ""){
    		if(formObj.tp_id.value != ""){
        		formObj.tp_id.value = toUpperCase(formObj.tp_id.value);
            var sheetObj = sheetObjects[0];
            sheetObj.ShowDebugMsg = false;
						
			formObj.f_cmd.value = SEARCHLIST02; 
            form.tp_cd.value = toUpperCase(formObj.tp_id.value);
            //sheetObj.DoSearch("ESD_SCE_0073GS.do",SceFrmQryString(formObj));
            var sXml = sheetObj.GetSearchXml("ESD_SCE_0073GS.do", SceFrmQryString(formObj));
						var result_cnt = ComGetEtcData(sXml, "tp_id_cnt");
						var result_tp_id = ComGetEtcData(sXml, "tp_id");
            var result_cs_grp_id = ComGetEtcData(sXml, "cs_grp_id");
            var result_grp_nm = ComGetEtcData(sXml, "grp_nm");
            var result_edi_sts = ComGetEtcData(sXml, "edi_sts");
            if(result_cs_grp_id != undefined) {
            	formObj.cs_grp_id.value = result_cs_grp_id;	
            } else {
            	formObj.cs_grp_id.value = "";
            }
            if(result_tp_id != undefined) {
            	formObj.tp_id.value = result_tp_id;	
            } else {
            	formObj.tp_id.value = "";
            }
            if(result_grp_nm != undefined) {
            	formObj.grp_nm.value = result_grp_nm;	
            } else {
            	formObj.grp_nm.value = "";
            }
                        
            var param = "?tp_id="+result_tp_id;
						
						if(result_cnt > 1){
//                window.open ("ESD_SCE_0068.do"+param, "list", "scrollbars=no,resizable=yes,fullscreen=no,width=600,height=390");
				var newWin = window.showModalDialog("ESD_SCE_0068.do"+param, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:390px");
            } else {
            		ComEtcDataToForm(formObj,sheetObj) ;            
            }
        }
    }
    function openESD068Screen(cs_grp_id, tp_id, grp_nm){
    	  var formObject = document.form;
        formObject.cs_grp_id.value = cs_grp_id;
    	onObjectFocusout(formObject);
        formObject.cs_grp_id.value = cs_grp_id;    	
    	formObject.tp_id.value = tp_id;
    	formObject.grp_nm.value = grp_nm;
    }
