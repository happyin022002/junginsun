/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0081.js
*@FileTitle  : Product Catalog - Optimal Route Validation Check
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/ 
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_close":
                	ComClosePopup(); 
                    break; 
                case "btn_ok":
                	if(validation()==true){
                		if(confirm('Do you want to save?')){
                			var callFunc=formObject.callFunc.value;
                			var valChk=true;
                			sheetObject.SetCellValue(1, "etc_rmk",formObject.valRmk.value,0);
                			doActionIBSheet(sheetObject, formObject, IBSAVE);
                			if(callFunc != ''){
                				// calling ESD_PRD_0080
                				//eval('window.dialogArguments.'+callFunc)(valChk);
                				ComPopUpReturnValue(valChk);
                				ComClosePopup(); 
                			}
                		}
                	}
                	break; 
                case "valChkRadio":
                	showRmk();
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
        var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(1, "pctl_no",formObj.pctl_no.value,0);
		sheetObjects[0].SetCellValue(1, "rout_val_chk_cd",formObj.valChkRadio[0].value,0);
		ComEnableObject(document.getElementById("valRmk1"), true);
		ComEnableObject(document.getElementById("valRmk2"), false);
		ComEnableObject(document.getElementById("valRmk3"), false);
		ComEnableObject(document.getElementById("valRmk4"), false);
     }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetObj.id) {
         	case "sheet1":
		         with(sheetObj){
		           var HeadTitle1="|pctl_no|rout_val_chk_cd|etc_rmk";
		           var headCount=ComCountHeadTitle(HeadTitle1);
		
		           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		           var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pctl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rout_val_chk_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"etc_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(1);
		           SetWaitImageVisible(0);
		           SetVisible(0);
		         }
             break;
         }
     }
 	// handling of Sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 		    case IBSAVE: //저장
 		    	ComOpenWait(true);
 		    	formObj.f_cmd.value=ADD;
//	 		    sheetObj.RowStatus(1) = "I";
 		     	var SaveStr=ComGetSaveString(sheetObj);
  		     	var sXml=sheetObj.GetSaveData("ESD_PRD_0083GS.do", SaveStr + "&" + PrdFQString(formObj));
 		     	//sheetObj.LoadSaveData(sXml);
// 		     	sheetObj.DoSave("ESD_PRD_0083.do", PrdFQString(formObj));
 		     	ComOpenWait(false);
 	        break;
         }
     }     
     /**
      * handling to activate radio button of Remark textbox
      */     
    function showRmk() {
    	var formObj=document.form;
    	var len=formObj.valChkRadio.length;
    	ComEnableObject(formObj.valRmk1, false);
    	ComEnableObject(formObj.valRmk2, false);
    	ComEnableObject(formObj.valRmk3, false);
    	ComEnableObject(formObj.valRmk4, false);
    	for(i=0;i<len;i++){
    		if(formObj.valChkRadio[i].checked==true){
    			sheetObjects[0].SetCellValue(1, "rout_val_chk_cd",formObj.valChkRadio[i].value,0);
    		}
    	}
    	if(formObj.valChkRadio[0].checked==true){
    		ComEnableObject(formObj.valRmk1, true);
    		formObj.valRmk1.className="input";    
    	} else if(formObj.valChkRadio[1].checked==true){
    		ComEnableObject(formObj.valRmk2, true);
    		formObj.valRmk2.className="input";    
    	} else if(formObj.valChkRadio[2].checked==true){
    		ComEnableObject(formObj.valRmk3, true);
    		formObj.valRmk3.className="input";    
    	} else if(formObj.valChkRadio[6].checked==true){
    		ComEnableObject(formObj.valRmk4, true);
    		formObj.valRmk4.className="input";    
    	}
       	formObj.valRmk1.value="";
    	formObj.valRmk2.value="";
    	formObj.valRmk3.value="";
    	formObj.valRmk4.value="";
    }
      /**
       * inputting value into Remark textbox 
       */           
    function validation() {
    	var formObj=document.form;
    	formObj.valRmk.value="";
    	if(formObj.valChkRadio[0].checked==true){
    		if(formObj.valRmk1.value==""){
    			alert("Please surely make a comment for using of the route.");
    			return false;
    		} else {
    			formObj.valRmk.value=formObj.valRmk1.value;
    		}
    	} else if(formObj.valChkRadio[1].checked==true){
    		if(formObj.valRmk2.value==""){
    			alert("Please surely make a comment for using of the route.");
    			return false;
    		} else {
    			formObj.valRmk.value=formObj.valRmk2.value;
    		}
    	} else if(formObj.valChkRadio[2].checked==true){
    		if(formObj.valRmk3.value==""){
    			alert("Please surely make a comment for using of the route.");
    			return false;
    		} else {
    			formObj.valRmk.value=formObj.valRmk3.value;
    		}
    	} else if(formObj.valChkRadio[6].checked==true){
    		if(formObj.valRmk4.value==""){
    			alert("Please surely make a comment for using of the route.");
    			return false;
    		} else {
    			formObj.valRmk.value=formObj.valRmk4.value;
    		}
    	}
    	return true;
    }
