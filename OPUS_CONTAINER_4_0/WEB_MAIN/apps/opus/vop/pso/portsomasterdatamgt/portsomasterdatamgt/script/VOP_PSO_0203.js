/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_pso_0203.js
*@FileTitle  : Bank Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class vop_pso_0203 : business script for vop_pso_0203
     */
    function vop_pso_0203() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
 // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var tblData="";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             var sheetObject1=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
            switch(srcName) {
    					case "btn_Close":
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
         * adding first-served functions after loading screen
         */
        function loadPage() {
        	fillData();
        }
        /**
         * Filling data when open
         * 
         */
        function fillData(){
//        	var datas = tblData.split("|$$|");
        	var datas=tblData.split("@");
        	for(var i=0; i<datas.length; i++ ){
        		var strId="dbData"+(i+1) ;
        		if(datas[i].trim()!=="")
        			document.getElementById("dbData"+(i+1)).innerHTML=datas[i];
        	}
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
            }
            return true;
        }
