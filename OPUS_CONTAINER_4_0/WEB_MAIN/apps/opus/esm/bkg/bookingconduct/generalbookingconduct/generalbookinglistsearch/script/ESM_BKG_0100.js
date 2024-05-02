/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1096.js
*@FileTitle  : Email(Edit)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
 function processButtonClick(){
     /***** using extra sheet valuable if there are more 2 sheets *****/
     /*******************************************************/
     var formObject = document.form;
     try {
         var srcName = ComGetEvent("name");
         switch(srcName) {
             case "btn_Send":
            	 var contents = CKEDITOR.instances.edt_contents.getData();
            	 if(contents == ''){
            		 ComShowMessage('Please input Contents information');
            		 break;
            	 }
            	 
            	 var formObj = document.form;
            	 var calllFunc = formObj.calllFunc.value;
            	 if (ComFuncCheck("opener." + calllFunc)) ComFunc(CKEDITOR.instances.edt_contents.getData());
            	 else if (ComFuncCheck("parent." + calllFunc)) ComFunc(CKEDITOR.instances.edt_contents.getData());
            	 ComClosePopup(); 
                 break;
             case "btn_Close":
            	 ComClosePopup(); 
                 break;
         } // end switch
     } catch(e) {
         if ( e == "[object Error]") {
             ComShowCodeMessage("COM12111");
         } else {
        	 ComShowCodeMessage(e.message);
         }
     }
 }
 
 /**
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
  */
 function loadPage() {

 }
