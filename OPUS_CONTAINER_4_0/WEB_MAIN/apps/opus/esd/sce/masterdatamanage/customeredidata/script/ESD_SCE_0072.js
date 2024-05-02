﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0072.js
*@FileTitle  : EDI Performance Report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var isSearch=false;
var selRow=0;
var isFirst1=0;
var isFirst2=0;
var pageNo=1 ;
// Event handler processing by button click event
document.onclick=processButtonClick;

// Event handler processing by button name
    function processButtonClick(){
    	var sheetObj=sheet;
    	/*******************************************************/
    	var formObj=document.form;
    	try{
    	    var srcName=ComGetEvent("name");
    	    formObj.pol.value=toUpperCase(formObj.pol.value);
            formObj.pod.value=toUpperCase(formObj.pod.value);
            formObj.vvd.value=toUpperCase(formObj.vvd.value);
            formObj.del.value=toUpperCase(formObj.del.value);
            formObj.por.value=toUpperCase(formObj.por.value);
            formObj.edi_sts.value=toUpperCase(formObj.edi_sts.value);
            formObj.bkg_no.value=toUpperCase(formObj.bkg_no.value);
            formObj.bl_no.value=toUpperCase(formObj.bl_no.value);
            formObj.cntr_no.value=toUpperCase(formObj.cntr_no.value);
    	    switch(srcName){
    	        case "btn_retrieve":
    	           var arr_bkg_no=formObj.bkg_no.value.split(",");
       	           var arr_bl_no=formObj.bl_no.value.split(",");
       	           var arr_cntr_no=formObj.cntr_no.value.split(",");
       	           var arr_vvd=formObj.vvd.value.split(",");
                   if(arr_bkg_no.length < 100 && arr_bl_no.length < 100 && arr_cntr_no.length < 100 && arr_vvd.length < 100){
                       doActionIBSheet(sheetObj,formObj,IBSEARCH);
                   } else {
                       ComShowMessage('Bkg_NO/Bl_NO/Cntr_NO/VVD is limited to 100');
                   }
    	           break;
    	        case "btn_new":
				   formObj.reset();
				   sheetObj = sheetObj.Reset();
				   sheetObjects[0] = sheetObj;
    	           break;
    	        case "btn_saveas":
    	           doActionIBSheet(sheet,formObj,IBDOWNEXCEL);
    	           break;
    	    }
    	}catch(e){
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111')) ;
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        makingFirstSelectionBox();
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
    
    function onChangeSelectionBox(){
    	var formObj=document.form;
    	var user_id=formObj.user_id.value;
	    var cs_grp_id=formObj.cs_grp_id.value;
	    formObj.f_cmd.value=SEARCH03;
    	var url="ESD_SCE_0072GS.do?f_cmd="+ SEARCH03 +"&cs_grp_id="+ cs_grp_id;
    	createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange=getChangeSelectionBoxResult;
		request.send(null);    	
	       //formObj.f_cmd.value = SEARCH03;
        //sheetObjects[0].DoSearch("ESD_SCE_0072GS.do", SceFrmQryString(formObj));
    }
    
    var vContainer_edi_sts=new Array(2);
    function getChangeSelectionBoxResult(){
    	initVcontainer(vContainer_edi_sts);
    	if( request.readyState == 4 ) {
    		if( request.status == 200 ) {
    			var delimination="☜☞";
    			var docXml=request.responseXML;
    			var rIndex=docXml.getElementsByTagName("TR").length;
    			var cIndex1=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"edi_sts");
    			var cIndex2=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cust_cd");
    			var fRow=docXml.getElementsByTagName("TR")[0].firstChild.nodeValue;
			    if(rIndex >0) {
			    	vContainer_edi_sts[0]=(fRow.split(delimination))[cIndex1];//edi_sts setting
			    	vContainer_edi_sts[1]=(fRow.split(delimination))[cIndex2];//cust_cd setting
			    }else{
                	initVcontainer(vContainer_edi_sts);
			    }
    		} else {
    			return;
    		}//if
    	}//if
    }
    
    function makingFirstSelectionBox(){
    	var formObj=document.form;
    	var user_id=formObj.user_id.value;
    	var style="COMBO";
    	var url="ESD_SCE_0072GS.do?f_cmd="+ SEARCH05 +"&user_id="+ user_id + "&style=" + style;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange=getXMLValues;
		request.send(null);
    }
    
    function searchingCntEct(){
    	var formObj=document.form;
    	var tp_id=formObj.tp_id.value;
    	var url="ESD_SCE_0072GS.do?f_cmd="+ SEARCHLIST02 +"&tp_id="+ tp_id;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange=getCntEct;
		request.send(null);   	
    }
    
    function initVcontainer(array){
  	     for(var n=0;n<array.length;n++){
        	array[n]="";
         }//for  
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
    						docXml.getElementsByTagName("ETC")[n].getAttribute("KEY").indexOf('tp_id_cnt') != -1) {    			
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
    			if(rIndex >0) {     				
    				etc_value_container[0]=cnt;//count setting    			    
    				if(cnt >0){
    					fRow=docXml.getElementsByTagName("TR")[0].firstChild.nodeValue;  
    					etc_value_container[1]=(fRow.split(delimination))[cIndex1]; //tp_id setting
    					etc_value_container[2]=(fRow.split(delimination))[cIndex2]; //cust_cd setting
    					etc_value_container[3]=(fRow.split(delimination))[cIndex3]; //cs_grp_id setting
    					etc_value_container[4]=(fRow.split(delimination))[cIndex4]; //edi_sts setting
    					etc_value_container[5]=(fRow.split(delimination))[cIndex5]; //cs_desc setting 
    				}//if
                } else { 
                  initVcontainer(etc_value_container);
                }//if
			}else{
				return;
			}//if
    	}//if
    }
    
    function getXMLAttribute(xml,attribute,index1,index2){ 
		var data=xml.getElementsByTagName(attribute)[index1];
		var data_attribute=data.attributes[index2].nodeValue; 
		return data_attribute;
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
    
    function getTextXML(){
		var textDoc=request.responseText();
    	return textDoc;
    }
    
    var codeArray=new Array();
    var valueArray2=new Array();
    var valueArray3=new Array();
    var valueArray4=new Array();
    function getXMLValues() {
    	initVcontainer(codeArray);
    	initVcontainer(valueArray2);
    	initVcontainer(valueArray3);
    	initVcontainer(valueArray4);
    	if( request.readyState == 4 ) {
    		if( request.status == 200 ) {
    			var docXml=request.responseXML;
    			var subXml=null;
    			var text_ofc="";
    			var rIndex=docXml.getElementsByTagName("TR").length;
    			var cIndex=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"d");
    			var cIndex2=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"a");
    			var cIndex3=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"b");
    			var cIndex4=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"c");
    			if(cIndex >= 0){
        			var delimination="☜☞";
        			for( var n=0; n < rIndex; n++ ) {
        				var row=docXml.getElementsByTagName("TR")[n].firstChild.nodeValue;
        				codeArray[n]=(row.split(delimination))[cIndex];
        				valueArray2[n]=(row.split(delimination))[cIndex2];
        				valueArray3[n]=(row.split(delimination))[cIndex3];
        				valueArray4[n]=(row.split(delimination))[cIndex4];
        			}//for
        			if( codeArray.length < 1 ) {	
        				makingSelectBox(0);
        			}else{	
        				makingSelectBox(1);
        			}
    			}else{
    				return;
    			}//if
    		}//if
    	}//if
    }
    
    function makingSelectBox(v){
    	var selectText="";
    	var optionText="<option value=''></option>"
        var valueText="";
    	var selectText_head="<select name='mycust'  onChange=javascript:onValueChange('mycust',this.form) style='width:164;'>";
    	var selectText_tail="</select>";
    	switch(v){
    	case 0:
    		selectText=selectText_head + selectText_tail;
    	    break;
    	case 1:
    		   for(var i=0; i<codeArray.length;i++){
    			   valueText=valueArray2[i] + "%" +  valueArray3[i]  + "%" +  valueArray4[i];//원래 구분자가 % 로 되어있었음 
    			   optionText +=  "<OPTION value='"+ valueText +"'>"+ codeArray[i] +"</OPTION>";
    		   }//for
    		   selectText=selectText_head + optionText + selectText_tail;
    		break;
    	default:
    		selectText=selectText_head + selectText_tail;
    		break;
    	}
    	document.all.cSelection.innerHTML=selectText;
    }
    
    function initSheet(sheetObj,sheetNo){
        var cnt=0;
        var xs=document.form.edi_sts.value;
        var os=document.form.cust_cd.value;
        var chmissontime=document.form.missOntime[0].checked;
    	sheetObj.SetWaitTimeOut(600);
        switch(sheetNo){
            case 1:
            	with(sheetObj){
	            	var varNewTitle=xs.replace(/,/g, '|');
	            	var varNewTitle1=os.replace(/,/g, '|');
	            	var aryTitle;
	            	var aryTitle1;
	            	if (varNewTitle.length > 0){
	            		aryTitle=varNewTitle.split("|");
	            		aryTitle1=varNewTitle1.split("|");
	            	}else{
	            		aryTitle=new Array();
	            		aryTitle1=new Array();
	            	}
	            	varNewTitle='';
	            	varNewTitle1='';
	            	if(aryTitle.length > 0){
	            		for( var k=0; k < aryTitle.length ; k++){
	            			varNewTitle=varNewTitle + '|' + aryTitle[k] ;
	            		}
	            	}
	            	if(aryTitle1.length > 0){
	            		for( var k=0; k < aryTitle1.length ; k++){
	            			varNewTitle1=varNewTitle1 + '|' + aryTitle1[k] ;
	            		}
	            	}
	            	if(varNewTitle != ''){
	            		varNewTitle=varNewTitle;
	            	}
	            	if(varNewTitle1 != ''){
	            		varNewTitle1=varNewTitle1;
	            	}
	            	var colCnt=aryTitle.length;
	            	var colcount=colCnt + 3 ;
	            	var HeadTitle="";
	            	var HeadTitle1="";
	            	if(chmissontime){
	            		HeadTitle="COM STS|EDI_CD"+varNewTitle+"|PFMC";
	            		HeadTitle1="CUST STS|EDI_CD"+varNewTitle1+"|%";
	            	} else {
	            		HeadTitle="day|EDI_CD"+varNewTitle+"|PFMC";
	            		HeadTitle1="per(%)|EDI_CD"+varNewTitle1+"|%";
	            	}

	            	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	        		
	            	var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"},
	            	                { Text:HeadTitle1, Align:"Center"} ];
	            	InitHeaders(headers, info);
	
	            	var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"title",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            	
	            	if(aryTitle.length != 0){
	            		cols.push({Type:"Text",      Hidden:1,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"edi_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            	for(var k = 0; k < aryTitle.length ; k++){
		            		cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:aryTitle[k],    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 });
		            	}
		            	cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pfmc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	            	} else {
	            	    cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"edi_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            	    cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"pfmc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	            	}
	            	 
	            	InitColumns(cols);
	
	            	SetEditable(0);
	            	sheetObj.SetCellBackColor(0,0,"#D3DCBC");
	            	sheetObj.SetCellBackColor(1,0,"#D3DCBC");
	            	sheetObj.SetCellBackColor(0,"pfmc","#B0FA9E");
	            	sheetObj.SetCellBackColor(1,"pfmc","#B0FA9E");
//	            	SetSheetHeight(200);
	            	resizeSheet(); 
            	}
            	break;
        }
    }
    
    function openCustomer(){
        var temp_mycust=document.form.mycust.value;
        if(temp_mycust == ''){
        	ComOpenPopup('ESD_SCE_0062.do', 600, 430, "findCustomer", "1,0,1,1,1,1,1", true);
        } else {
            ComShowMessage('My Performance has been selected already. Please remove My Performance first before changing settings.');
        }
    }
    
    function findCustomer(rtnVal) {
    	form.cs_grp_id.value = rtnVal.edi_grp;
    	form.tp_id.value = rtnVal.tp_id;
    	form.grp_nm.value = rtnVal.edi_nm;
    	
    	onObjectFocusout(document.form);
    }
    
    function doActionIBSheet(sheetObj,formObj,sAction){
        sheetObj.ShowDebugMsg(false);
        switch(sAction){
        	case IBSEARCH:
        		if(validateForm(formObj)){
    				formObj.f_cmd.value=SEARCH04;

                    var sXml = sheetObj.GetSearchData("ESD_SCE_0072GS.do", SceFrmQryString(formObj) );
                    sheetObj.LoadSearchData(sXml,{Sync:1});
                	var cust_cd=sheet.GetEtcData("cust_cd");
                    var edi_sts=sheet.GetEtcData("edi_sts");
                    formObj.cust_cd.value=cust_cd;
                    formObj.edi_sts.value=edi_sts;
                    sheetObj=sheetObj.Reset();
                    sheetObjects[0] = sheetObj;
                    initSheet(sheetObj,1);
                    sheetObj.RemoveAll();
        			
                    if(formObj.missOntime[0].checked){    	//missing Inquery
                        formObj.f_cmd.value=SEARCH01;
        			} else {								//on-time Performance
                        formObj.f_cmd.value=SEARCH02;
        			}
                    

                    sheetObj.DoSearch("ESD_SCE_0072GS.do", SceFrmQryString(formObj) );
        		}
        		break;
            case IBDOWNEXCEL:

            	if(sheetObj.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{
            		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
            	}
            	break;
        }
    }
    
    function validateForm(formObj){
        var result=false ;
        if(!ComIsEmpty(formObj.cs_grp_id)){          	
       	    var formObject=document.form;                       	        	    
       	    if(!ComIsEmpty(formObject.podetadate1) && !ComIsEmpty(formObject.podetadate2)){
       	     formObject.podetadate1_hidden.value=dateConverting(formObject.podetadate1.value);
       	     formObject.podetadate2_hidden.value=dateConverting(formObject.podetadate2.value);   
       	    }else{
          	     formObject.podetadate1_hidden.value="";
           	     formObject.podetadate2_hidden.value="";       	    	
       	    }
       	    if(!ComIsEmpty(formObject.poletddate1) && !ComIsEmpty(formObject.poletddate2)){
     	          formObject.poletddate1_hidden.value=dateConverting(formObject.poletddate1.value);
     	          formObject.poletddate2_hidden.value=dateConverting(formObject.poletddate2.value); 
       	    }else{
   	          formObject.poletddate1_hidden.value="";
 	          formObject.poletddate2_hidden.value="";       	    	
       	    }    	
            result=true;
            if(!ComIsEmpty(formObj.vvd) || !ComIsEmpty(formObj.bkg_no)
            || !ComIsEmpty(formObj.bl_no) || !ComIsEmpty(formObj.cntr_no)){
            	 var formObject=document.form;                       	        	    
            	    if(!ComIsEmpty(formObject.podetadate1) && !ComIsEmpty(formObject.podetadate2)){
            	     formObject.podetadate1_hidden.value=dateConverting(formObject.podetadate1.value);
            	     formObject.podetadate2_hidden.value=dateConverting(formObject.podetadate2.value);   
            	    }else{
               	     formObject.podetadate1_hidden.value="";
            	     formObject.podetadate2_hidden.value="";  
            	    }
            	    if(!ComIsEmpty(formObject.poletddate1) && !ComIsEmpty(formObject.poletddate2)){
          	          formObject.poletddate1_hidden.value=dateConverting(formObject.poletddate1.value);
          	          formObject.poletddate2_hidden.value=dateConverting(formObject.poletddate2.value); 
            	    }else{
            	          formObject.poletddate1_hidden.value="";
              	          formObject.poletddate2_hidden.value="";            	    	
            	    }
                result=true;
            } else {
                if(!ComIsEmpty(formObj.poletddate1) || !ComIsEmpty(formObj.poletddate2)
                 || !ComIsEmpty(formObj.podetadate1) || !ComIsEmpty(formObj.podetadate2)  ){
                    if(!ComIsEmpty(formObj.poletddate1) || !ComIsEmpty(formObj.poletddate2)){
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
                                 if((ComParseInt(ComGetDaysBetween(formObj.poletddate1.value, formObj.poletddate2.value)) > 2) ){
                                      ComShowMessage("The period of T.VVD ETD is limited to 3 days in case POL doesn't have a full location code.");
                                      result=false
                                 } else {
                                   	 var formObject=document.form;                       	 
                                	 formObject.poletddate1_hidden.value=dateConverting(formObject.poletddate1.value);
                                	 formObject.poletddate2_hidden.value=dateConverting(formObject.poletddate2.value); 
                                	 if(ComIsEmpty(formObject.podetaDate1) || ComIsEmpty(formObject.podetaDate2)){
                                  	     formObject.podetadate1_hidden.value="";
                                   	     formObject.podetadate2_hidden.value="" 
                                	 }//if                               	 
                                     result=true;
                                 }
                             } else {
                                 if((ComParseInt(ComGetDaysBetween(formObj.poletddate1.value, formObj.poletddate2.value)) > 4) ){
                                      ComShowMessage("The period of T.VVD ETD is limited to 5 days.");    // 5일까지 조회 가능~~
                                      result=false;
                                 } else {
                                  	 var formObject=document.form;                       	 
                                	 formObject.poletddate1_hidden.value=dateConverting(formObject.poletddate1.value);
                                	 formObject.poletddate2_hidden.value=dateConverting(formObject.poletddate2.value);    
                                	 if(ComIsEmpty(formObject.podetaDate1) || ComIsEmpty(formObject.podetaDate2)){
                                  	     formObject.podetadate1_hidden.value="";
                                   	     formObject.podetadate2_hidden.value="" 
                                	 }//if                                	 
                                     result=true;
                                 }
                             }
                        }
                    }
                    if(!ComIsEmpty(formObj.podetadate1) || !ComIsEmpty(formObj.podetadate2)){
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
                                 if((ComParseInt(ComGetDaysBetween(formObj.podetadate1.value, formObj.podetadate2.value)) > 2) ){
                                      ComShowMessage("The period of T.VVD ETA is limited to 3 days in case POD doesn't have a full location code.");    // 5일까지 조회 가능~~
                                      result=false
                                 } else {
                                  	 var formObject=document.form;                       	 
                                	 formObject.podetadate1_hidden.value=dateConverting(formObject.podetadate1.value);
                                	 formObject.podetadate2_hidden.value=dateConverting(formObject.podetadate2.value);  
                                	 if(ComIsEmpty(formObject.poletdDate1) || ComIsEmpty(formObject.poletdDate2)){
                             	          formObject.poletddate1_hidden.value="";
                            	          formObject.poletddate2_hidden.value="";  
                               	 }//if                                	 
                                     result=true;
                                 }
                            } else {
                                if((ComParseInt(ComGetDaysBetween(formObj.podetadate1.value, formObj.podetadate2.value)) > 4) ){
                                      ComShowMessage("The period of T.VVD ETA is limited to 5 days.");    // 5일까지 조회 가능~~
                                      result=false;
                                 } else {
                                     //데이터베이스형에 맞추어진 데로 변형함 YYYMMDD형
                                  	 var formObject=document.form;                       	 
                                	 formObject.podetadate1_hidden.value=dateConverting(formObject.podetadate1.value);
                                	 formObject.podetadate2_hidden.value=dateConverting(formObject.podetadate2.value);
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
        } else {
            ComShowMessage(ComGetMsg('COM12113',"EDI Customer Group."));
            result=false;
        }
        return result;
    }
    
    function openESD009Screen(cs_grp_id, tp_id, grp_nm){
    	var formObject=document.form;
    	formObject.cs_grp_id.value=cs_grp_id;
    	formObject.tp_id.value=tp_id;
    	formObject.grp_nm.value=grp_nm;
    	formObject.mycust.value="";
    	onObjectFocusout(formObject);
    }
    
    function inputBoxFilling(formObj){
    	var cs_grp_id=formObj.cs_grp_id.value;
    	var style="COMBO";
    	var url="ESD_SCE_0072GS.do?f_cmd="+ SEARCHLIST01 +"&cs_grp_id="+ cs_grp_id + "&style=" + style;
    	if(cs_grp_id != '' && cs_grp_id !=""){
		    createHttpRequest();
		    request.open("GET", url, false);
		    request.onreadystatechange=fillingFromXml;
		    request.send(null);
		}else{
			return;
		}
    }
    
    function fillingFromXml(){
       	if( request.readyState == 4 ) {
    		if( request.status == 200 ) {
    			var formObj=document.form;
    			var docXml=request.responseXML;
    			var rIndex=docXml.getElementsByTagName("TR").length; 
    			if(rIndex > 0){
    		    	var delimination="☜☞";
    				var row=docXml.getElementsByTagName("TR")[0].firstChild.nodeValue;
    				var tempValueArray=new Array();
    				tempValueArray=row.split(delimination);
    				var cIndex1=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"tp_id");
    				var cIndex2=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"cs_desc");
    				var cIndex3=getFieldNameIndex(getFiledNames(getXMLAttribute(docXml,"DATA",0,0)),"edi_sts");
    				
    				alert(cIndex1 + " " + cIndex2 + " " + cIndex3);
    				
    				/*filling in the empty input box's*/
    				if(cIndex1 >=0 && cIndex2 >=0 && cIndex3 >=0)
    				{
    					formObj.tp_id.value=tempValueArray[cIndex1];
    					formObj.grp_nm.value=tempValueArray[cIndex2];
    					formObj.edi_sts.value=tempValueArray[cIndex3];
    					alert(formObj.edi_sts.value);
    				}//if
    			}
        		else
        		{
        			formObj.cs_grp_id.value=""		  
        			formObj.tp_id.value="";
        			formObj.grp_nm.value="";
        			formObj.edi_sts.value="";
        		}//if
    		}
    	}else{
    		return;
    	}
    }
    
//    function onObjectFocusout(formObj){
//        if(formObj.mycust.value == ''){
//        	formObj.cs_grp_id.value=toUpperCase(formObj.cs_grp_id.value);
//        	var sheetObj=sheet;
//        	sheetObj.ShowDebugMsg(false);
//        	inputBoxFilling(formObj);
//        } else {
//            ComShowMessage('My Performance has been selected already. Please remove My Performance first before changing settings.');
//        }
//    }
    
    function onObjectFocusout(formObj){
    	if(formObj.mycust.value == ''){
    		formObj.cs_grp_id.value=toUpperCase(formObj.cs_grp_id.value);
	    	var sheetObj=sheet;
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
                	//formObj.mycust.value = ComGetEtcData(sXml,"cs_grp_id")+"%"+ComGetEtcData(sXml,"tp_id")+"%"+ ComGetEtcData(sXml,"grp_nm") ;
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
    
    
    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); 
        }
        return str;
    }
    
    function openEDIsts(){
    	var formObject=document.form;
    	if(formObject.mycust.value == ''){
    		var cs_grp_id="";
            if(ComTrim(formObject.cs_grp_id.value) != '' && ComTrim(formObject.cs_grp_id.value) != "")   
            	cs_grp_id=formObject.cs_grp_id.value.toUpperCase();
   	     	var url="ESD_SCE_0067.do?edi_grp_cd=" + cs_grp_id + "&diff=1"  + "&f_cmd=" + SEARCH + "&cs=99988888";
   	        var newWin =  ComOpenWindow(url ,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:430px" , true);
    	} else {
    	    ComShowMessage('My Performance has been selected already. Please remove My Performance first before changing settings.');
    	}
    }
    
    function openMyReport(){
        var formObject=document.form;
        var selCnt=formObject.mycust.length;
        var edi_grp_cd=toUpperCase(formObject.cs_grp_id.value);
        if(selCnt == 0){
        	var newWin =  ComOpenWindow("ESD_SCE_0073.do?newOld=1",  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:570px" , true);
        } else {
        	var newWin =  ComOpenWindow("ESD_SCE_0073.do?newOld=2",  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:570px" , true);
        }
    }
    
    function addEdiStsNo(edi_sts,cust_cd){
    	if(edi_sts != ''){
    		document.getElementById('edi_sts').value=edi_sts;
    		document.getElementById('cust_cd').value=cust_cd;
    	}
    }
    
    function openVVDList(){
    	var newWin =  ComOpenWindow("ESD_SCE_0063.do",  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:570px" , true);
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
    
    function onEnterKey(){
    }
    
    var etc_value_container=new Array(6);
    function onObjectTpId(formObj){
    	if(formObj.cs_grp_id.value == "" && (formObj.tp_id.value != "" && ComTrim(formObj.tp_id.value) != "")){//전병석 수정
    		formObj.tp_id.value=toUpperCase(formObj.tp_id.value);
            var sheetObj=sheet;
            sheetObj.ShowDebugMsg(false);
            initVcontainer(etc_value_container);
            searchingCntEct();
            var result_cnt=etc_value_container[0];
            var result_tp_id=etc_value_container[1];
            var cust_cd=etc_value_container[2];
            var cs_grp_id=etc_value_container[3];
            var edi_sts=etc_value_container[4];
            var cs_desc=etc_value_container[5];
            document.getElementById('cust_cd').value=cust_cd;           
            var param="?tp_id="+ result_tp_id;
            if(result_cnt > 1){
            	var newWin =  ComOpenWindow("ESD_SCE_0068.do"+param,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:390px" , true);
            } else {
            	formObj.tp_id.value=result_tp_id;
            	formObj.cust_cd.value=cust_cd;
            	formObj.cs_grp_id.value=cs_grp_id;
            	formObj.edi_sts.value=edi_sts;
            	formObj.grp_nm.value=cs_desc;
            }
        }
    }
     
    function openCalendar(diff){
        var formObject=document.form;
        var from_date="";
        var to_date="";
        var obj_from_date="";
        var obj_to_date="";
        var cal=new ComCalendarFromTo();
        switch(diff){
           case '1':
               from_date="poletddate1";
               to_date="poletddate2";
               obj_from_date=formObject.poletddate1;
               obj_to_date=formObject.poletddate2;  
               cal.displayType="date";
               cal.select(obj_from_date,obj_to_date, 'yyyy-MM-dd');                 
           break;
           case '2':
             from_date="podetadate1";
             to_date="podetadate2";
             obj_from_date=formObject.podetadate1;
             obj_to_date=formObject.podetadate2;              
             cal.displayType="date";
             cal.select(obj_from_date,obj_to_date, 'yyyy-MM-dd'); 
           break;
        }
    }
    
    function dateConverting(date){
    	if(date != ''){
    		return ComTrimAll(date, "-");  
    	}//if
    	return '';
    }
    
    function sheet_OnSearchEnd(sheetObj,ErrMsg){
    	var formObj=document.form;
        var chmissontime=document.form.missOntime[0].checked;
        var colortemp1="#BDFFCE";
        var colortemp2="#FEFFCD";
        with(sheetObj){
            if(chmissontime){            	
                sheetObj.SetCellBackColor(2,0,colortemp1);
                sheetObj.SetCellBackColor(3,0,colortemp1);
                sheetObj.SetCellBackColor(3,"pfmc",colortemp2);

                sheetObj.SetCellFont("FontSize",3,"pfmc",9);

                sheetObj.SetCellFont("FontBold",3,"pfmc",1);
            } else {
                sheetObj.SetCellBackColor(2,0,colortemp1);
                sheetObj.SetCellBackColor(3,0,colortemp1);
                sheetObj.SetCellBackColor(4,0,colortemp1);
                sheetObj.SetCellBackColor(5,0,colortemp1);
                sheetObj.SetCellBackColor(6,0,colortemp1);
                sheetObj.SetCellBackColor(7,0,colortemp1);
                sheetObj.SetCellBackColor(8,0,colortemp1);
                sheetObj.SetCellBackColor(9,0,colortemp1);
                sheetObj.SetCellBackColor(3,"pfmc",colortemp2);

                sheetObj.SetCellFont("FontSize",3,"pfmc",9);

                sheetObj.SetCellFont("FontBold",3,"pfmc",1);
                sheetObj.SetCellBackColor(5,"pfmc",colortemp2);

                sheetObj.SetCellFont("FontSize",5,"pfmc",9);

                sheetObj.SetCellFont("FontBold",5,"pfmc",1);
                sheetObj.SetCellBackColor(7,"pfmc",colortemp2);

                sheetObj.SetCellFont("FontSize",7,"pfmc",9);
                sheetObj.SetCellFont("FontBold",7,"pfmc",1);
                sheetObj.SetCellBackColor(9,"pfmc",colortemp2);
                sheetObj.SetCellFont("FontSize",9,"pfmc",9);
                sheetObj.SetCellFont("FontBold",9,"pfmc",1);
            }
        }
    }
    
    function sheet_OnMouseMove(sheetObj,Button, Shift, X, Y){
        var sText=sheetObj.GetCellText(sheetObj.MouseRow(), sheetObj.MouseCol());
        var col=sheetObj.MouseCol();
        var row=sheetObj.MouseRow();
        if(sText != "" && sText != "0" && (row == 2 || row == 4 || row == 6 || row == 8) && col != 0 ){
            sheetObj.SetMousePointer("Hand");
        } else {
            sheetObj.SetMousePointer("Default");
        }
    }
    
    function sheet_OnMouseUp(sheetObj,button,shift,x,y){
    	with(sheetObj){
    		var formObj=document.form;
            var cs_grp_id=formObj.cs_grp_id.value;
            var trs_mode=formObj.trs_mode_.value;
            var vvd=formObj.vvd.value;
            var por=formObj.por.value;
            var pol=formObj.pol.value;
            var pod=formObj.pod.value;
            var del=formObj.del.value;
            var fromddt=formObj.poletddate1.value;     //ETD
            var toddt=formObj.poletddate2.value;
            var fromadt=formObj.podetadate1.value;     //ETA
            var toadt=formObj.podetadate2.value;
            var bkgno=formObj.bkg_no.value;
            var blno=formObj.bl_no.value;
            var cntrno=formObj.cntr_no.value;
            var copsts=formObj.cop_status.value;
            var upCol=sheetObj.ColSaveName(sheetObj.MouseCol());
            var left=sheetObj.ColLeft(sheetObj.MouseCol());
            var wth=sheetObj.GetColWidth(sheetObj.MouseCol());
            var sang=wth/2 + left;
            var hyun=x - left;
            var cust_sts=sheetObj.GetCellText(1,sheetObj.MouseCol());
            if(document.form.f_cmd.value == '101'){ // missing 일 경우
                if((upCol != "") && (sheetObj.MouseCol()!= 0)){
                    if(sheetObj.MouseRow()== 2){
                        var temp=sheetObj.GetCellText(2,sheetObj.MouseCol());
                        var arr_temp=temp.split("/");
                        if(temp != "" && arr_temp.length == 2){
                            if(sang > x){					// missing 
                                var param_temp="?diff=1&missing_cnt="+arr_temp[0]+"&missing_status="+upCol+"&cs_grp_id="+cs_grp_id+"&trs_mode="+trs_mode+"&vvd="+vvd+"&por="+por+"&pol="+pol+"&cust_sts="+cust_sts
                                                  +"&pod="+pod+"&del="+del+"&fromddt="+fromddt+"&toddt="+toddt+"&fromadt="+fromadt+"&toadt="+toadt+"&bkg_no="+bkgno+"&bl_no="+blno+"&cntr_no="+cntrno+"&copsts="+copsts;
                                if(arr_temp[0] != "0"){
                                    var retVal =  ComOpenWindow("ESD_SCE_0074_POP.do"+param_temp,  "list",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1200px;dialogHeight:630px" , true);
                                }
                            } else {						// total
                                var param_temp="?diff=2&missing_cnt="+arr_temp[1]+"&missing_status="+upCol+"&cs_grp_id="+cs_grp_id+"&trs_mode="+trs_mode+"&vvd="+vvd+"&por="+por+"&pol="+pol+"&cust_sts="+cust_sts
                                                +"&pod="+pod+"&del="+del+"&fromddt="+fromddt+"&toddt="+toddt+"&fromadt="+fromadt+"&toadt="+toadt+"&bkg_no="+bkgno+"&bl_no="+blno+"&cntr_no="+cntrno+"&copsts="+copsts;
                                if(arr_temp[1] != "0"){
                                    var retVal =  ComOpenWindow("ESD_SCE_0074_POP.do"+param_temp,  "list",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1200px;dialogHeight:630px" , true);
                                } 
                            }
                            if (typeof retVal != "undefined" && retVal) {
                                doActionIBSheet(sheetObj,formObj,IBSEARCH);
                            }
                        }
                    }
                 }
            } else if(document.form.f_cmd.value == '102'){	// on-time 
            	if((upCol != "") && (sheetObj.MouseCol()!= 0)){
            		if((sheetObj.MouseRow()== 2) || (sheetObj.MouseRow()== 4) || (sheetObj.MouseRow()== 6) || (sheetObj.MouseRow()== 8)){
            			var temp=sheetObj.GetCellText(sheetObj.MouseRow(),sheetObj.MouseCol());
                        var temp12=sheetObj.GetCellText(0,sheetObj.MouseCol());
                        var arr_temp=temp.split("/");
                        if(temp != "" && temp != "0" && arr_temp.length == 2){
                            var title_Row=sheetObj.GetCellText(sheetObj.MouseRow(),0);
                            if(sang > x){    				// missing count
                                  var param_temp="?diff=3&missing_cnt="+arr_temp[0]+"&clickday="+sheetObj.MouseRow()+"&title_row="+title_Row+"&missing_status="+temp12+"&cs_grp_id="+cs_grp_id+"&trs_mode="+trs_mode
                                                +"&vvd="+vvd+"&por="+por+"&pol="+pol+"&pod="+pod+"&del="+del+"&cust_sts="+cust_sts+"&fromddt="+fromddt+"&toddt="+toddt+"&fromadt="+fromadt+"&toadt="+toadt
                                                +"&bkg_no="+bkgno+"&bl_no="+blno+"&cntr_no="+cntrno+"&copsts="+copsts;
                                  if(arr_temp[0] != "0"){
                                      var retVal =  ComOpenWindow("ESD_SCE_0074_POP.do"+param_temp,  "list",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1200px;dialogHeight:630px" , true);
                                  }
                            } else {          // total 
                                  var param_temp="?diff=4&missing_cnt="+arr_temp[1]+"&clickday=0&title_row="+title_Row+"&missing_status="+temp12+"&cs_grp_id="+cs_grp_id+"&trs_mode="+trs_mode
                                              +"&vvd="+vvd+"&por="+por+"&pol="+pol+"&pod="+pod+"&del="+del+"&cust_sts="+cust_sts+"&fromddt="+fromddt+"&toddt="+toddt+"&fromadt="+fromadt+"&toadt="+toadt
                                              +"&bkg_no="+bkgno+"&bl_no="+blno+"&cntr_no="+cntrno+"&copsts="+copsts;
                                  if(arr_temp[1] != "0"){
                                      var retVal =  ComOpenWindow("ESD_SCE_0074_POP.do"+param_temp,  "list",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1200px;dialogHeight:630px" , true);
                                  }
                            }
                            if (typeof retVal != "undefined" && retVal) {
                                doActionIBSheet(sheetObj,formObj,IBSEARCH);
                            }
                        }
            		}
            	}
            }
    	}
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
    	       } else {
         	       var arr_mycust=temp_mycust.split("%");
        	       formObj.cs_grp_id.value=arr_mycust[0];
        	       formObj.tp_id.value=arr_mycust[1];
        	       formObj.grp_nm.value=arr_mycust[2];
        	       onChangeSelectionBox();
        	       formObj.edi_sts.value=vContainer_edi_sts[0];
        	       formObj.cust_cd.value=vContainer_edi_sts[1];
               }
               break;
        }
    }
    
    function open073Reloading(){
    	var sheetObj=sheet;
        var formObject=document.form;
    	sheetObj.RemoveAll();
    	formObject.reset();
    }
    
    function open073Screen(reportName, temp_edi_sts, temp_cust_sts){
        var arr_temp=reportName.split("%");
        var formObject=document.form;
        formObject.cs_grp_id.value=arr_temp[0];
        formObject.tp_id.value=arr_temp[1];
        formObject.grp_nm.value=arr_temp[2];
        formObject.edi_sts.value=temp_edi_sts;
        formObject.cust_cd.value=temp_cust_sts;
        formObject.mycust.value=reportName;
    }
    
    function openESD068Screen(cs_grp_id, tp_id, grp_nm){
        var formObject=document.form;
        formObject.cs_grp_id.value=cs_grp_id;
    	onObjectFocusout(formObject);
    	formObject.cs_grp_id.value=cs_grp_id;
    	formObject.tp_id.value=tp_id;
    	formObject.grp_nm.value=grp_nm;
    }
    
    function openAddPaste(dist){
    	var newWin =  ComOpenWindow("ESD_SCE_0064.do?dist="+dist,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px" , true);
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
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    } 
    //error script 
    function openfunction(){}