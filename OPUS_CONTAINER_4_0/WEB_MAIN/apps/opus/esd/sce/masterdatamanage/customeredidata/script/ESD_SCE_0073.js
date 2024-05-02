/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0073.js
*@FileTitle  : My Performance Report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

// global variable
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var selectVal;
var isSearch=false;
//Event handler processing by button click event
document.onclick=processButtonClick;

	//Event handler processing by button name
    function processButtonClick(){
    	/***** Setting variable over two sheet at tab *****/
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        formObject.cs_grp_id.value=toUpperCase(formObject.cs_grp_id.value);
        formObject.tp_id.value=toUpperCase(formObject.tp_id.value);
        formObject.grp_nm.value=toUpperCase(formObject.grp_nm.value);
        form.edi_grp_id.value=formObject.cs_grp_id.value;
        form.tp_cd.value=formObject.tp_id.value;
        form.edi_grp_desc.value=formObject.grp_nm.value;
 		form.edi_cgo_rmk.value=formObject.mycust.value;
// 		var opener=window.dialogArguments;
//        if (!opener) opener=parent;
		var opener = window.dialogArguments;
		if (!opener) opener=window.opener;  //이 코드 추가할것
		if (!opener) opener=parent; //이 코드 추가할것
		
        try{
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_retrieve":
                	if(formObject.cs_grp_id.value != ""){
                		doActionIBSheet(sheetObject,formObject,IBSEARCH);
                	} else {
                		ComShowMessage("Please select EDI Customer Group.");
                	}
                	break;
                case "btn_new":
               	 	form.newOld.value="1";
               	 	form.action="ESD_SCE_0073.do";
               	 	form.submit();
               	 	break;
                case "btn_save":
                	if(formObject.mycust.value == "" || formObject.cs_grp_id.value == ""){
                		ComShowMessage("Please, Select EDI Customer Group.");
                		break;
                	}
                  	if(sheetObject.CheckedRows("edi_grp_cd")>0){
                  		var chkrow=0;
                  		for(var i=0 ; i < sheetObject.CheckedRows("edi_grp_cd"); i++){
                  			chkrow=sheetObject.FindCheckedRow("edi_grp_cd").split('|')[i];
                  		}
                  	} else {
                       	ComShowMessage("Please, Check CheckBox");
                       	break;
                   	}
                  	doActionIBSheet(sheetObject,formObject,IBINSERT);
                  	if((formObject.newOld.value == "1") || (formObject.newOld.value == "2")){    // esd_sce_072 page일 경우만 reloading 된다....
                  		//opener.open073Reloading();                        
                  	}
                  	break;
                case "btn_save1":
                	if(formObject.mycust.value == ""){
                		ComShowMessage("Report name is required.");
                		break;
                	}
                	if(sheetObject.CheckedRows("edi_grp_cd")>0){
                		var chkrow=0;
                   		for(var i=0 ; i < sheetObject.CheckedRows("edi_grp_cd"); i++){
                           chkrow=sheetObject.FindCheckedRow("edi_grp_cd").split('|')[i];
                   		}
                	} else {
                		ComShowMessage("Please select at least one.");
                		break;
                	}
                	doActionIBSheet(sheetObject,formObject,IBSAVE);
                	if(formObject.newOld.value == "2"){
                		//opener.open073Reloading();                        
                	}
                	break;
                case "btn_ok":
                	var chkcnt=sheetObject.CheckedRows(0);
                	if(chkcnt < 1){
                		ComShowMessage('Please select at least one.');
                		return false;
                	}
	        	   	var reportName=formObject.mycust.value;
	        	   	var chkrow=sheetObject.FindCheckedRow(0).split('|');
	        	   	var temp_edi_sts="";
	        	   	var temp_cust_sts="";
	        	   	var edi_sts="";
	        	   	var cust_sts="";
	        	   	for(var k=0 ; k < chkcnt ; k++){
	        	   		edi_sts=sheetObject.GetCellValue(chkrow[k], "edi_stnd_sts_cd");
	        	   		cust_sts=sheetObject.GetCellValue(chkrow[k], "cust_edi_sts_cd");
	        	   	    if(k == 0){
	        	   	        temp_edi_sts=edi_sts;
	        	   	        temp_cust_sts=cust_sts;
	        	   	    } else {
	        	   	        temp_edi_sts=temp_edi_sts +","+ edi_sts;
	        	   	        temp_cust_sts=temp_cust_sts +","+ cust_sts;
	        	   	    }
	        	   	}
	        	   	opener.open073Screen(reportName, temp_edi_sts,temp_cust_sts);
	        	   	ComClosePopup(); 
	        	   	break;
                case "btn_ok1":
                	var chkcnt=sheetObject.CheckedRows(0);
                	if(chkcnt < 1){
	        	   		ComShowMessage('Please select at least one.');
	        	   		return false;
	        	   	}
                	var reportName=formObject.cs_grp_id.value+"%"+formObject.tp_id.value+"%"+formObject.grp_nm.value;
                	var chkrow=sheetObject.FindCheckedRow(0).split('|');
                	var temp_edi_sts="";
                	var temp_cust_sts="";
                	var edi_sts="";
                	var cust_sts="";
                	for(var k=0 ; k < chkcnt ; k++){
	        	   		edi_sts=sheetObject.GetCellValue(chkrow[k], "edi_stnd_sts_cd");
	        	   		cust_sts=sheetObject.GetCellValue(chkrow[k], "cust_edi_sts_cd");
	        	   	    if(k == 0){
	        	   	        temp_edi_sts=edi_sts;
	        	   	        temp_cust_sts=cust_sts;
	        	   	    } else {
	        	   	        temp_edi_sts=temp_edi_sts +","+ edi_sts;
	        	   	        temp_cust_sts=temp_cust_sts +","+ cust_sts;
	        	   	    }
	        	   	}
                	opener.open073Screen(reportName, temp_edi_sts,temp_cust_sts);
                	ComClosePopup(); 
                	break;
                case "btn_close":
                	opener.openfunction();
                	if((formObject.newOld.value == "4") || (formObject.newOld.value == "3")){
                		if(formObject.sendClose.value == "reload"){
                		}
                	}
                	ComClosePopup(); 
                	break;
                case "btng_cntrlist":
                	window.open ("ESD_SCE_0073.do?newOld=2", "performance", "scrollbars=no,resizable=yes,fullscreen=no,width=580,height=480");
                	break;
            }
        } catch(e) {
        	if( e == "[object Error]") {
        		ComShowCodeMessage(getMsg('COM12111'));
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    function loadPage(){
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        if(document.form.newOld.value == "4"){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
    
    function initSheet(sheetObj,sheetNo,etdeta) {
        var cnt=0;
        switch(sheetNo) {
            case 1:
            	with(sheetObj){
            		var HeadTitle="|EDI STS|Cust STS|Description" ;

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );

            		var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"edi_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_stnd_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_edi_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"edi_sts_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            		             {Type:"Status",    Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	 
            		InitColumns(cols);

            		SetEditable(1);
//            		SetSheetHeight(200);
            		resizeSheet(); 
            	}
            	break;
        }
    }
    
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //retrieving(opened the popup window)
                formObj.f_cmd.value=SEARCH01;
                selectVal=FormQueryString(formObj);
//method change[check again]CLT
                sheetObj.DoSearch("ESD_SCE_0073GS.do", selectVal );
                break;
            case IBINSERT:        // modifyng new ui
            	var chkrow=sheetObj.FindCheckedRow(1).split('|');
                formObj.f_cmd.value=SEARCH02; 
//parameter changed[check again]CLT]
                var sXml=sheetObj.GetSearchData("ESD_SCE_0073GS.do", FormQueryString(formObj));
				var cust_cnt=ComGetEtcData(sXml, "cust_cnt");
                if(cust_cnt == '0'){
                	formObj.f_cmd.value=MULTI;
                	
                	sheetObj.DoSave("ESD_SCE_0073GS.do", FormQueryString(formObj),'edi_grp_cd');
                	
//                	var saveXml=sheetObj.GetSaveData("ESD_SCE_0073GS.do",  FormQueryString(formObj));
// 					if(saveXml != null) {
// 						sheetObj.LoadSaveData(saveXml);
// 						//ComShowMessage("SAVED SUCCESSFULLY");             
// 					}
                	
                	formObj.f_cmd.value=SEARCH01;
                	selectVal=FormQueryString(formObj);
                	sheetObj.DoSearch("ESD_SCE_0073GS.do", selectVal , {Sync:2});
                	for(var k=0; k < chkrow.length-1;k++){
                		sheetObj.SetCellValue(chkrow[k],0,"Y");
                	}
                	formObj.sendClose.value="reload";                    
                } else {
                    ComShowMessage("Already Exisiting in my Cust");
                }
                break;
            case IBSAVE:      // modifying to ibsave 
                formObj.f_cmd.value=MULTI01;
                sheetObj.DoSave("ESD_SCE_0073GS.do", FormQueryString(formObj),'edi_grp_cd');
                ComShowMessage("SAVED SUCCESSFULLY");
                formObj.f_cmd.value=SEARCH01;
                selectVal=FormQueryString(formObj);
//method change[check again]CLT
                sheetObj.DoSearch("ESD_SCE_0073GS.do", selectVal );
                formObj.sendClose.value="reload"; 
                break;
        }
    }
    
    
    function t1sheet_OnSaveEnd(sheetObj , Code, ErrMsg){
    		ComShowMessage("SAVED SUCCESSFULLY");
    }

    
    function onValueChange(selectName, formObj){
        switch(selectName){
            case 'mycust' :
               var temp_mycust=formObj.mycust.value;
    	       var arr_mycust=temp_mycust.split("%");
               if(arr_mycust[0] == ""){
        	       formObj.cs_grp_id.value="";
        	       formObj.tp_id.value="";
        	       formObj.grp_nm.value="";
               } else {
                   formObj.cs_grp_id.value=arr_mycust[0];
        	       formObj.tp_id.value=arr_mycust[1];
        	       formObj.grp_nm.value=arr_mycust[2];
               }
    	   break;
        }
    }
    
    function onObjectFocusout(formObj){
        if(formObj.cs_grp_id.value != ""){
        	formObj.cs_grp_id.value=toUpperCase(formObj.cs_grp_id.value);
	        var formObject=document.form;
	        var sheetObj=sheetObjects[0];
	        sheetObj.ShowDebugMsg(false);
	        formObj.f_cmd.value=SEARCHLIST03; 
	        form.edi_grp_id.value=toUpperCase(formObject.cs_grp_id.value);
//parameter changed[check again]CLT
	        var sXml=sheetObj.GetSearchData("ESD_SCE_0073GS.do", FormQueryString(formObj));
			var call_cs_grp_id=ComGetEtcData(sXml, "edi_grp_id");
			if(call_cs_grp_id == undefined) {
				call_cs_grp_id="";
			}
			var call_tp_id=ComGetEtcData(sXml, "tp_id");
			if(call_tp_id == undefined) {
				call_tp_id="";
			}
			var call_grp_nm=ComGetEtcData(sXml, "grp_nm");
			if(call_grp_nm == undefined) {
				call_grp_nm="";
			}
			formObject.cs_grp_id.value=call_cs_grp_id;
			formObject.tp_id.value=call_tp_id;
			formObject.grp_nm.value=call_grp_nm;
	      }
    }
    
    function openCustomer(){
    	sUrl="ESD_SCE_0062.do?mycust=2";
    	//var newWin =  ComOpenWindow("ESD_SCE_0062.do?mycust=2",  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:510px" , true);
    	ComOpenPopup(sUrl, 500, 470, "findCustomer", "1,0,1,1,1,1,1", true);
    }
    
    function findCustomer(rtnVal) {
    	var formObject=document.form;
    	formObject.cs_grp_id.value = rtnVal.edi_grp;
    	formObject.tp_id.value = rtnVal.tp_id;
    	formObject.grp_nm.value = rtnVal.grp_nm;
    }
    
    function openESD009Screen(cs_grp_id, tp_id, grp_nm){
    	var formObject=document.form;
    	formObject.cs_grp_id.value=cs_grp_id;
    	formObject.tp_id.value=tp_id;
    	formObject.grp_nm.value=grp_nm;
    }
    
    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //changing to upper character
        }  
        return str;      
    }
    
    // setting popup over two tp_id
    function onObjectTpId(formObj){
		//if(formObj.cs_grp_id.value == ""){
		if(formObj.tp_id.value != ""){
    		formObj.tp_id.value=toUpperCase(formObj.tp_id.value);
    		var sheetObj=sheetObjects[0];
    		sheetObj.ShowDebugMsg(false);
			formObj.f_cmd.value=SEARCHLIST02; 
			form.tp_cd.value=toUpperCase(formObj.tp_id.value);
//parameter changed[check again]CLT
            var sXml=sheetObj.GetSearchData("ESD_SCE_0073GS.do", FormQueryString(formObj));
			var result_cnt=ComGetEtcData(sXml, "tp_id_cnt");
			var result_tp_id=ComGetEtcData(sXml, "tp_id");
            var result_cs_grp_id=ComGetEtcData(sXml, "cs_grp_id");
            var result_grp_nm=ComGetEtcData(sXml, "grp_nm");
            var result_edi_sts=ComGetEtcData(sXml, "edi_sts");
            if(result_cs_grp_id != undefined) {
            	formObj.cs_grp_id.value=result_cs_grp_id;	
            } else {
            	formObj.cs_grp_id.value="";
            }
            if(result_tp_id != undefined) {
            	formObj.tp_id.value=result_tp_id;	
            } else { 
            	formObj.tp_id.value="";
            } 
            if(result_grp_nm != undefined) {
            	formObj.grp_nm.value=result_grp_nm;	
            } else {
            	formObj.grp_nm.value="";
            }
            var param="?tp_id="+result_tp_id;
			if(result_cnt > 1){
				var newWin =  ComOpenWindow("ESD_SCE_0068.do"+param,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:500px" , true);
            } else {
            	ComEtcDataToForm(formObj,sheetObj) ;            
            }
        }
    }

    function openESD068Screen(cs_grp_id, tp_id, grp_nm){
    	var formObject=document.form;
        formObject.cs_grp_id.value=cs_grp_id;
    	onObjectFocusout(formObject);
        formObject.cs_grp_id.value=cs_grp_id;    	
    	formObject.tp_id.value=tp_id;
    	formObject.grp_nm.value=grp_nm;
    }
    
    function resizeSheet(){ // auto-sizing
        ComResizeSheet(sheetObjects[0]);
    } 