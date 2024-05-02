/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0063.js
*@FileTitle  : Vessel SKD Query(Common Popup)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var selectVal;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
         var opener=window.dialogArguments;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		if (!opener) opener=parent; 
            switch(srcName) {
        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;
              case "btns_calendar1":
                         var cal=new ComCalendar();
            		 cal.select(formObject.sdate, 'yyyy-MM-dd');
        	        break;
        	    case "btns_calendar2":
        	         var cal=new ComCalendar();
            		 cal.select(formObject.edate, 'yyyy-MM-dd');
        	        break;
              	case "btn_close":
              		ComClosePopup(); 
        	        break;
        	    case "btn_ok":
                    var chkcnt=sheetObject.CheckedRows(0);
        	    	if(chkcnt < 1){
        	    		ComShowMessage('Select check item');
        	    		return false;
        	    	}
        	    	var chkrow=0;
        	    	var vvds='';
        	    	for(var a=0 ; a < chkcnt ; a++){
        	    		chkrow=sheetObject.FindCheckedRow(0).split('|')[a];
        	    		if(a == 0){
        	    			vvds=sheetObject.GetCellValue(chkrow, "vvd");
        	    		}else{
        	    			vvds=vvds + ',' + sheetObject.GetCellValue(chkrow, "vvd");
        	    		}
        	    	}
        	    	parent.addVVDNo(vvds, formObject.etdeta.value,formObject.loc_cd.value );
        	    	if (!opener) opener=parent; 
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
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
    }
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo,etdeta) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
               // (5, 0, 0, true);
		             var HeadTitle="|VVD|Lane|POL|ETD" ;
		             if(etdeta == 'A'){
		             HeadTitle="|VVD|Lane|POD|ETA" ;
		             }
		
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"slan_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"pold",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Date",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"etda",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(1);
//		             SetSheetHeight(300);
		             resizeSheet();
                      }


                break;
        } 
    }
     function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
       doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    } 
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:     
                if(!validateForm(sheetObj,formObj,sAction)) {
                  return false;
                }
                formObj.f_cmd.value=SEARCH;                
                selectVal=SceFrmQryString(formObj);
                initSheet(sheetObjects[0],1,formObj.etdeta.value);  
                sheetObj.RemoveAll();
                 sheetObj.DoSearch("ESD_SCE_0063GS.do", selectVal );
           break;
           case IBSEARCHAPPEND:  
                formObj.f_cmd.value=SEARCH;              
                 sheetObj.DoSearch("ESD_SCE_0063GS.do", selectVal+"&"+ "iPage=" + PageNo,{Append:true} );
           break;
        }
    }
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(formObj.sdate.value=="" || formObj.edate.value=="") {
      	        ComShowMessage("You must input period");
      	        if(formObj.sdate.value=="") {
      	          ComSetFocus(formObj.sdate);
      	          return false;
      	        }
      	        if(formObj.edate.value=="") {
      	          ComSetFocus(formObj.edate);
      	          return false;
      	        }  
      	    }
      	    var dateinfo=formObj.sdate.value.split("-");	
			var src=new Date(dateinfo[0], dateinfo[1]-1, dateinfo[2]);
			src.setDate(src.getDate() + 14);
			var dateinfo2=formObj.edate.value.split("-");			
			var src2=new Date(dateinfo2[0], dateinfo2[1]-1, dateinfo2[2]);
			if(src < src2){
				ComShowMessage("Inquiry period is 2 weeks");
  	    		ComSetFocus(formObj.edate);
  	        	return false;
			}
			// 조회기간 제한 END
      	    if(formObj.etdeta.value == 'D'){
      	    	if(formObj.pol_cd.value == ''){
      	    		ComShowMessage("You must input POL");
      	    		ComSetFocus(formObj.pol_cd);
      	        	return false;
      	    	}
      	    	formObj.loc_cd.value=formObj.pol_cd.value;
      	    }else{
      	    	if(formObj.pod_cd.value == ''){
      	    		ComShowMessage("You must input POD");
      	    		ComSetFocus(formObj.pod_cd);
      	        	return false;
      	    	}
      	    	formObj.loc_cd.value=formObj.pod_cd.value;
      	    }
        }
   	    if(!ComIsEmpty(formObj.sdate) && !ComIsEmpty(formObj.edate)){
   	     formObj.sdate_hidden.value=dateConverting(formObj.sdate.value);
   	     formObj.edate_hidden.value=dateConverting(formObj.edate.value);   
   	    }else{
      	     formObj.sdate_hidden.value="";
       	     formObj.edate_hidden.value="" 
   	    }
        return true;
    }
    /* 
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
    
    function resizeSheet(){ // auto-sizing
        ComResizeSheet(sheetObjects[0]);
    } 
