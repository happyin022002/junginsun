/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0805.js
*@FileTitle  : Adjustment Request Message
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
    var curTab=1;
    var beforetab=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var processCloseCase="0";


  	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
  	function loadPage() {
  		var opener=window.dialogArguments;
        if (!opener) opener=window.parent;
        
  		var n3pty_stl_tp_cd=window.parent.document.form.n3pty_stl_tp_cd.value;
  		if( n3pty_stl_tp_cd == "W" ){
  			document.all.adjRmk2.style.display="";
  		}
  		
  		document.form.s_ra_rmk1.focus();
  	}
  
  	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		
  		 var formObject=document.form;
  		 if(curTab == 2)
  			formObject=document.form2;
  		try {
  			var srcName=ComGetEvent("name");
  			switch(srcName) {
  				case "btn_save":
  				    var rtnVal=new Array(3);
  				    rtnVal[0]=document.form.s_file_no.value;
  				    rtnVal[1]=document.form.s_ra_rmk1.value;
  				    rtnVal[2]=document.form.s_ra_rmk2.value;
                      if ( rtnVal==null || rtnVal.length==0){
                          ComShowMessage(ComGetMsg("TPB90045"));
                          return;
                      } else {
                             window.returnValue=rtnVal;
                             if(window.parent) {                            	 
                            	 eval('window.parent.callback0805')(rtnVal);
         					 }		
                             ComClosePopup(); 
                      }
  					break;					
  				case "btn_close":
  				    window.returnValue=null;
  				    ComClosePopup(); 
  				    break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg("COM12111"));
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}

