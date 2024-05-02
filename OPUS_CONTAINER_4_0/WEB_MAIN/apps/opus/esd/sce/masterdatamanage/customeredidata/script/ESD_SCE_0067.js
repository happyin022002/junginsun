/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0067.js
*@FileTitle  : Vessel SKD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
// Common global variable
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var selectVal;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
          var sheetObject=sheetObjects[0];
         var formObject=document.form;
         var opener=window.dialogArguments;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
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
        	    	var edi_sts='';
        	    	var cust_sts='';
        	    	for(var a=0 ; a < chkcnt ; a++){
        	    		chkrow=sheetObject.FindCheckedRow(0).split('|')[a];
        	    		if(a == 0){
        	    			edi_sts=sheetObject.GetCellValue(chkrow, "stnd_cd");
        	    		}else{
        	    			edi_sts=edi_sts + ',' + sheetObject.GetCellValue(chkrow, "stnd_cd");
        	    		}
        	    	}
                    // 2010-03-21 edi_sts 중복 수정 시작
					var ediStsArray=edi_sts.split(",");
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
					edi_sts=str;
                    // 2010-03-21 edi_sts 중복 수정 끝
                    var diff=formObject.diff.value
                    if(diff == 1){
                        for(var a=0 ; a < chkcnt ; a++){
                            chkrow=sheetObject.FindCheckedRow(0).split('|')[a];
                            if(a == 0){
                            	cust_sts=sheetObject.GetCellValue(chkrow, "cust_cd");
            	    		}else{
            	    			cust_sts=cust_sts + ',' + sheetObject.GetCellValue(chkrow, "cust_cd");
            	    		}
                        }
                    }                    
                    if(diff == 1){
                    	parent.addEdiStsNo(edi_sts,cust_sts);
                    	 if (!opener) opener=parent; 
         				ComClosePopup(); 
                    } else {
                    	parent.addEdiStsNo(edi_sts);
                    	 if (!opener) opener=parent; 
         				ComClosePopup(); 
                    }
                   
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
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
        //alert(formObject.edi_grp_cd.value);
      	 doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
                //(4, 0, 0, true);
             var HeadTitle="|EDI Status|Description|CUST Status" ;

             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"stnd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"cs_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"cust_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
              
             InitColumns(cols);

             SetEditable(1);
//             SetSheetHeight(300);
             resizeSheet();
                      }


                break;
        } 
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:                    
                formObj.f_cmd.value=SEARCH;                
                selectVal=SceFrmQryString(formObj);
                //alert("IBSEARCH["+selectVal+"]");
                 sheetObj.DoSearch("ESD_SCE_0067GS.do", selectVal );
           break;
        }
    }
    function resizeSheet(){ // auto-sizing
        ComResizeSheet(sheetObjects[0]);
    } 
