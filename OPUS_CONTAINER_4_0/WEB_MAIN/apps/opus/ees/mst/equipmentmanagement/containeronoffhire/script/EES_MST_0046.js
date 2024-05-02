/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0046.js
*@FileTitle  : Manufacture Date & Manufacturer Inquiry and Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends 
 * @class ees_mst_0046 : ees_mst_0046 business script for
 */
	 // common static variable
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 var IBSEARCH01=29;
	 var IBSEARCH02=30;
	 var tcnt=0;
	 var blurflg=false;
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
     // Event handler processing by button name */
     function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
         try {
             var srcName=ComGetEvent("name");
             if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
	     		case "btns_vndr":	// Lessor Code 가져오기 팝업
	     			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0C1.do', 700, 540, "vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "0,0,1,1,1,1", true);
				break;	           	
				case "btn_retrieve":
					if (formObject.vndr_seq.value == "") {
						ComShowCodeMessage("MST00001", "Lessor");
					} else {
						formObject.cntr_nos.value="";
						sheetObject1.RemoveAll();
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
				break;
				case "btn_loadexcel" :
					sheetObject1.RemoveAll();
					var ccheck = sheetObject1.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",Append:false});
					
				break;
				case "btn_downexcel" :
					if(sheetObject1.RowCount() < 1){//no data
		        	     ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	        	    }
				break;	
				
				case "btn_new":
					sheetObject1.RemoveAll();
					formObject.vndr_seq.value="";
					formObject.vndr_lgl_eng_nm.value="";
					formObject.lstmcd.value=""
					formObject.cntr_nos.value="";
					formObject.md_flg[1].checked=true;
					formObject.m_flg[1].checked=true;
					formObject.agmt_seq.value="";
					formObject.agmt_cty_cd.value="HHO";
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE)
				break;
					
                case "ComOpenPopupWithTargetAgmtNo": //agmt no
                	if (formObject.agmt_seq.readOnly == false)
                		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 855, 580, 'setPopData_Agreement', '0,0,1', true); 			                	
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
      * registering IBsheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     
     
     function sheet1_OnLoadExcel(sheetObj,  result, code, msg) {
    	 if(isExceedMaxRow(msg))return;
    	 if (result) {
    		  formObject = document.form;
    		  sheetObject1 = sheetObj;
    		  formObject.cntr_nos.value="";
				for (var i=1; i <= sheetObject1.RowCount(); i++){
					if (formObject.cntr_nos.value == ""){
						formObject.cntr_nos.value=sheetObject1.GetCellValue(i,"cntr_no");
					} else {
						formObject.cntr_nos.value=formObject.cntr_nos.value + "," + sheetObject1.GetCellValue(i,"cntr_no");
					}
					var tmpmftdt=sheetObject1.GetCellValue(i,"mft_dt");
					var mftdt=tmpmftdt.replace(/-/gi,"");
					if (isNumber(mftdt) == false || mftdt == "")
						sheetObject1.SetCellValue(i,"ceflg","E");
					var tmpmftrvndrseq=sheetObject1.GetCellValue(i,"mftr_vndr_seq");
					if (isNumber(tmpmftrvndrseq) == false || tmpmftrvndrseq == "")
						sheetObject1.SetCellValue(i,"beflg","E");
				}
				
				
				if (sheetObject1.RowCount()> 0){
				    doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				} else {
          		return;							
				}					
    	  }
    	}

     
     
     
     function setSheetObject(sheet_obj){        
         sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         //IBsheet initailizing하기
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet(sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
     }
     
 	 function initControl() {
 		var formObj=document.form;
 		axon_event.addListenerFormat('blur',	'obj_blur',          form);   //- handling OnBeforeDeactivate event of all control except rdoCity 		
        axon_event.addListenerFormat('focus',   'obj_focus',         form);   //- handling OnBeforeDeactivate event of all control that has dataformat attribute
        axon_event.addListenerForm('change',	'obj_change',	formObj); 
        // axon_event.addListener('keydown',		'ComKeyEnter',	     'form'); //- when key down
 	    // axon_event.addListenerFormat('keypress','obj_keypress',	     form);   //- when key down
  	}
 	 
// 	function obj_keypress(){
//	    obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    var vKeyCode=event.keyCode;
//	    switch(obj.dataformat) {
//	        case "engup":
//	            if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum');	  
//	            if(obj.name=="agmt_cty_cd") ComKeyOnlyAlphabet('upper');
//	            if(obj.name=="agmt_seq") ComKeyOnlyNumber('int');
//	            break;
//	        case "ymd":
//	        	if(obj.name=="hire_date") ComKeyOnlyNumber('int', "-");
//	        	break;
//	    }
//	}
	//Axon handling event2. 이벤트처리함수
	function obj_blur(){
		var formObj=document.form;
		var obj=event.srcElement;
	    if (event.srcElement.name == "hire_date"){
	    }
	    else {
            //Validation  check(lenth, format, max, min etc)
            ComChkObjValid(obj);
	    }
	}
	//Axon handling event2. 이벤트처리함수
	function obj_focus(){
		var formObj=document.form;
		var obj=event.srcElement;
	    if (event.srcElement.name == "hire_date"){		
	    	ComClearSeparator(formObj.hire_date, "ymd");
	    	ComSetFocus(formObj.hire_date);
	    }	
	}	
	
	/**
	 * Handling in case of HTML Control Value change.
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		switch(ComGetEvent("name")) {
    		case "vndr_seq":
    			if(formObj.vndr_seq.value == ""){
					formObj.vndr_lgl_eng_nm.value = "";
					ComSetFocus(formObj.vndr_seq);
    			} else {
    				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
    			}
        		
			   	break;
		}
	}
	
     /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // t1sheet1 init
            	    with(sheetObj){
		               var HeadTitle1="|CNTR No.|TP/SZ|Term|On Hire Date|On Hire Yard|Manufacture Date|Manufacturer Code|Manufacturer Name|a|b|c|d|e";
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
		                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"onh_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"onh_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"mft_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"mftr_vndr_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",  ColMerge:0,   SaveName:"mftr_vndr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"aeflg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"beflg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ceflg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"deflg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eeflg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               InitColumns(cols);
		               SetEditable(1);
		               SetShowButtonImage(1);
		               //SetSheetHeight(410);
		               resizeSheet();
               		}
                 break;
         }
     }
     // handling process for sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //retrieve
            if(validateForm(sheetObj,formObj,sAction)){
				 var aecnt=0;
				 var becnt=0;
				 var cecnt=0;
				 var decnt=0;
				 var eecnt=0;            	
				 var tmpCntrNo="";
        		 var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
        		 var arrRow=dupRows.split(",");
		         if (dupRows != ""){
		        	 //error message : Data is duplicated, Please check data again.	       			 
		             for( var t=0; t<arrRow.length; t++){
		            	 tmpCntrNo=tmpCntrNo + sheetObj.GetCellValue(arrRow[t],"cntr_no")+",";
//			         	for (var i = 1; i <= sheetObj.RowCount; i++){
		            	 if (sheetObj.GetCellValue(arrRow[t],"cntr_no")   == sheetObj.GetCellValue(arrRow[t],"cntr_no") ){
			       			     sheetObj.SelectCell(arrRow[t], "cntr_no", true);
			       			     sheetObj.SetCellValue(arrRow[t],"deflg","E");
			       			     decnt++;
			       			     sheetObj.SetCellFontColor(arrRow[t],"cntr_no","#FF0000");
//			       			     break;
			            	 }
//			             }
		             }
		             ComShowCodeMessage("MST00002", tmpCntrNo);
		         }
				 if (formObj.cntr_nos.value != ""){
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);				
					formObj.f_cmd.value=SEARCH;
		     	    var sParam=ComGetSaveString(sheetObjects[0]);
		     	    sParam += "&" + FormQueryString(formObj);
		     	    var sXml="";
		     	    sXml = sheetObj.GetSearchData("EES_MST_0046GS.do", sParam);
		     	    
		     	    var chk=sXml.indexOf("ERROR");
					if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchData(sXml,{Sync:0} );
					   return;
					} else {
					   sheetObj.LoadSearchData(sXml,{Sync:0} );
					} 		   
				    
				    ComOpenWait(false);
				 } else {
	                 sheetObj.SetWaitImageVisible(0);
	                 ComOpenWait(true); 						
					 formObj.f_cmd.value=SEARCH01;
		     	     var sParam=ComGetSaveString(sheetObjects[0]);
		     	     sParam += "&" + FormQueryString(formObj);
		     	     var sXml=sheetObj.GetSearchData("EES_MST_0046GS.do", sParam);
		     	     ComOpenWait(false);
		     	     var chk=sXml.indexOf("ERROR");
					 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchData(sXml,{Sync:0} );
					   return;
					 } else {
					   sheetObj.LoadSearchData(sXml,{Sync:0} );
					 } 					 
				 }
             }
			break;
			case IBSAVE:
		        var chkUpdate=false;
		        for (var i=1; i <= sheetObj.RowCount(); i++){
		        	if (sheetObj.GetRowStatus(i) == "U"){
		        		chkUpdate=true;
		        		break;
		        	}	
		        }
		        if (!chkUpdate){
		        	ComShowCodeMessage("MST00012");
		        	return;
		        }
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);				
		    	formObj.f_cmd.value=MULTI;
     	        var sParam=ComGetSaveString(sheetObjects[0]);
     	        sParam += "&" + FormQueryString(formObj);
     	        var sXml=sheetObj.GetSaveData("EES_MST_0046GS.do", sParam);
     	        ComOpenWait(false);
				var chk=sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					return;
				} else {  	     	        
					ComShowCodeMessage("MST01025");
				}
				for(var i=sheetObj.RowCount(); i >= 1; i--){
					if (sheetObj.GetCellValue(i,"aeflg") != "E" &&
						sheetObj.GetCellValue(i,"beflg") != "E" &&
						sheetObj.GetCellValue(i,"ceflg") != "E" &&
						sheetObj.GetCellValue(i,"deflg") != "E"){
						sheetObj.RowDelete(i,false);
					}
				}				
			break;
			
			case IBSEARCH_ASYNC01:	//retrieve(Form Lessor No. inserting)
				
				var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
				sheetObj.SetWaitImageVisible(1);
				if ( sXml != "" ) {
					if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
						ComSetObjValue(formObj.vndr_lgl_eng_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
						ComSetNextFocus(formObj.vndr_seq);
					} else {
						ComShowCodeMessage("MST02032");
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetObjValue(formObj.vndr_lgl_eng_nm, "");
						ComSetFocus(formObj.vndr_seq);
					}
				} else {
					ComShowCodeMessage("MST02032");
					ComSetObjValue(formObj.vndr_seq, "");
					ComSetFocus(formObj.vndr_seq);
				}
				break;
			
         }
         sheetObj.ShowDebugMsg(false);
     }
     
     
     /**
      * calling event after retrieving Sheet
 	 * @param sheetObj
 	 * @param ErrMsg
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     	//do nothing
    	 var formObj=document.form;
    	 var sheetObj = sheetObjects[0];
    	 var aecnt=0;
		 var becnt=0;
		 var cecnt=0;
		 var decnt=0;
		 var eecnt=0;            	
		 var tmpCntrNo="";
		 if (formObj.cntr_nos.value != ""){
			 for (var i=1; i <= sheetObj.RowCount(); i++){
			    	sheetObj.SetRowStatus(i,"U");
			    	if (sheetObj.GetCellValue(i,"aeflg") == "E"){ //Term Error
			    		sheetObj.SetCellFontColor(i,"lstm_cd","#FF0000");
						sheetObj.SetRowStatus(i,"R");//대상이아닌경우 Status를 R로 변경
					    aecnt++;
					}
			    	if (sheetObj.GetCellValue(i,"beflg") == "E"){ //Manufacturer Code Error
			    		sheetObj.SetCellFontColor(i,"mftr_vndr_seq","#FF0000");
						sheetObj.SetRowStatus(i,"R");//대상이아닌경우 Status를 R로 변경
					    becnt++;
					}
			    	var retval=sheetObj.GetCellValue(i,"mft_dt");
					retval=sReplace_str(retval, "-","");
					var retalt=false;
					if (retval.length == 8){
					   retalt=isValidDay(retval.substr(0,4),retval.substr(4,2),retval.substr(6,2));
					   if (!retalt){
						   sheetObj.SetCellValue(i,"ceflg","E");
					   }
					} else {
						if (retval!="")sheetObj.SetCellValue(i,"ceflg","E");
					}   
					if (sheetObj.GetCellValue(i,"ceflg") == "E"){ //Manufacturer Date Error
						sheetObj.SetCellFontColor(i,"mft_dt","#FF0000");
						sheetObj.SetRowStatus(i,"R");//대상이아닌경우 Status를 R로 변경
					    cecnt++;
					}
					if (sheetObj.GetCellValue(i,"deflg") == "E"){ //Manufacturer container 중복 Error
						sheetObj.SetCellFontColor(i,"cntr_no","#FF0000");
						sheetObj.SetRowStatus(i,"R");
					    decnt++;
					}
					if (sheetObj.GetCellValue(i,"cntr_tpsz_cd") == ""){ //존재하지않는 컨테이너
						sheetObj.SetCellFontColor(i,"cntr_no","#FF0000");
					    sheetObj.SetCellValue(i,"deflg",'E');
						sheetObj.SetRowStatus(i,"R");
					    decnt++;
					}
				}
			    if (aecnt > 0 || becnt > 0 || cecnt > 0 || decnt > 0){
			    	ComShowCodeMessage("MST01026");
			    }
		 }
    	 
     	ComOpenWait(false);
     }
     
     
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
    function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
    	var formObj=document.form;
    	var sName=SheetObj.ColSaveName(Col);
     	var celltxt=SheetObj.GetEditText();
     	var celltxt1=SheetObj.GetCellValue(Row, "cntr_no");
    }
    function setsheetRowColorBlack(cnt){
   	 	 var formObj=document.form;
	   	 for (var i=1; i <= 25; i++){
	   		 sheetObjects[0].SetCellFontColor(cnt,i,"#000000");
	   	 }
    }
    function setsheetRowColorRed(cnt){
	   	 var formObj=document.form;
	   	 for (var i=1; i <= 25; i++){
	   		 sheetObjects[0].SetCellFontColor(cnt,i,"#FF0000");
	   	 }
    }
    function isNumber(input) {
        var chars="0123456789";
        return containsCharsOnly(input,chars);
        //return true;
    } 
    /**
     * inserting값이 특정 문자(chars)만으로 되어있는지 checking
     * 특정 문자만 허용하려 할 때 사용
     * ex) if (!containsCharsOnly(form.blood,"ABO")) {
     *         alert("혈액형 필드에는 A,B,O 문자만 사용할 수 있습니다.");
     *     }
     */
    function containsCharsOnly(input,chars) {
        for (var inx=0; inx < input.length; inx++) {
           if (chars.indexOf(input.charAt(inx)) == -1)
               return false;
        }
        return true;
    }
   	/**
   	 * handling Currency Pop-up Return Value <br>
   	 * @param {arry} Return value array of returned Values Pop-up screen
   	 * @param  Row index
   	 * @param Col index
   	 * @paramsheet Array index
   	 */
  	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
  	    var formObj=document.form;
  	    var sheetObj=sheetObjects[0];
  	    if ( aryPopupData.length > 0 ) {
  	    	formObj.agmt_cty_cd.value = aryPopupData[0][4]; 
  	    	formObj.agmt_seq.value = aryPopupData[0][5]; 
  	    }
  	} 	 
  	
	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}
