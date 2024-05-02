/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0213.js
*@FileTitle  : Warranty Alert_Pop Up 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ess_mnr_0213 : business script for ess_mnr_0213.
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
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
					case "btn1_Retrieve": 
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					case "btn1_New": 
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break; 	
					case "btn1_OK":
						ComClosePopup();
					break;	
					case "btn1_Close":
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
            initSheet(sheetObjects[i],i + 1); 
        }       
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    } 
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) { 
            case "sheet1":
                with (sheetObj) {
            		SetVisible(false);
            	}
			break;  		
        }	
    }	
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //retrieving
				if(validateForm(sheetObj,formObj,sAction)){ 
					formObj.f_cmd.value=SEARCH;   
					var sXml=sheetObj.GetSearchData("EES_MNR_0213GS.do", FormQueryString(formObj));
					var arrResult=MnrXmlToArray(sXml); 
					if(arrResult != null){     
						formObj.fm_warr_dt.value="Fm " +  arrResult[0][5];		 			 							  					  	  	   	
						formObj.to_warr_dt.value="To " +  arrResult[0][0]; 		 			 							  					  	  	   	
						formObj.eq_mkr_nm.value=arrResult[0][2];   		 			 							  					  	  	   	
						formObj.eq_mdl_nm.value=arrResult[0][4];     		 			 							  					  	  	   	
						formObj.warr_rmk.value=arrResult[0][3];            		 			 							  					  	  	   	
					} else {     
						ComClosePopup(); 
					} 	 	   
				}    
				break;  
			case IBCLEAR:      //initializing    
				break;
        }     
    }
    /**
     * handling process for input validation
     */         
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){      
			if(sAction==IBSEARCH) {        
				if (!ComChkValid(formObj)) return false;        
			} 	 	
        }       	
        return true; 
    }