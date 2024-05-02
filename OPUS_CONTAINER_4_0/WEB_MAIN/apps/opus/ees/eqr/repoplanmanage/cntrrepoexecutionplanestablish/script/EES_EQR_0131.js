/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0131.js
*@FileTitle  : Send Fax or e-mail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
// common static variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var parmObj=new Array();
    var frmObj=new Array();
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
    	 var sheetObject=sheetObjects[0];
    	 
    	 /*******************************************************/
    	 var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_send":
    				//ComOpenWait(true); 
    				//document.form.param.value = "";
    				if( document.all.chk_email.checked == true && document.form.email.value == ""   ) {
    				    ComShowCodeMessage("EQR90001", "e-mail address ");
    				    return ;
    				}
    				if( document.all.chk_fax.checked == true && document.form.fax.value == ""   ) {
    				   ComShowCodeMessage("EQR90001", " Fax number ");
    				    return ;
    				}
    				if( document.all.chk_email.checked == true && document.all.chk_fax.checked == true ) {
    				    document.all.send_mode.value="A";
    				}
    				else if( document.all.chk_email.checked == true && document.all.chk_fax.checked != true ) {
    				    document.all.send_mode.value="E";
    				}
    				else if( document.all.chk_email.checked != true && document.all.chk_fax.checked == true ) {
    				    document.all.send_mode.value="F";
    				}
    				else if (document.all.chk_email.checked != true && document.all.chk_fax.checked != true ){
    				    ComShowCodeMessage("EQR90001", "issue Type");
    				    return ;
    				}
    				// setting format receiver 1;receiver fax1, receiver 2;receiver fax2
    				if (document.form.fax.value != "" ) {
    	               document.form.fax.value=replaceAll(document.form.fax.value, "-", "" );
    				}
    				
    				document.form.f_cmd.value=MULTI;
    				document.form.action="EES_EQR_0131.do";
    				document.form.target="iframe_rdsend";
    				document.form.submit();
    	 			break;
    			case "btn_email":
    				ComOpenWindowCenter('EES_EQR_0132.do?target=E&job_cd=EQR001','EesEqr0132','450','450',true);
//    				window.showModalDialog('EES_EQR_0132.do?target=E&job_cd=EQR001&pgmNo=EES_EQR_0132', window, "scroll:no;status:no;help:no;dialogWidth:450px;dialogHeight:410px");
              		break;
      			case "btn_fax":
      				ComOpenWindowCenter('EES_EQR_0132.do?target=F&job_cd=EQR001','EesEqr0132','450','450',true);
//      				window.showModalDialog('EES_EQR_0132.do?target=F&job_cd=EQR001&pgmNo=EES_EQR_0132', window, "scroll:no;status:no;help:no;dialogWidth:450px;dialogHeight:410px");
              		break;
    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
                    ComShowCodeMessage("EQR90004");
                } else {
                    ComShowMessage(e.message);
                }
    	}
    }
    /**
     * registering IBSheet Object as list
     * comSheetObject(id)
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
    	for(i=0;sheetObjects!=null && i<sheetObjects.length;i++){
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
        // Preview RD Init
        rdInit(viewer);
    	// Preview RD Open
    	rdOpen();
    }
    /**
     * opening rd file
     */
    function rdOpen() {
        var opener=window.dialogArguments;
        if (!opener) opener =window.opener	;
        if (!opener) opener = parent;
        var sheetObj=opener.sheetObjects[0];
        var formObject=opener.document.form;
        var repo_plan_id="";
        var ref_id="'";
        //var tp_sz=opener.comboObjects[2].text ;
        var tp_sz=opener.comboObjects[1].GetSelectText();
        var week="";
        var rowcount=sheetObj.RowCount();
        if(document.form.btn_mode.value == "F") {
           document.form.chk_fax.checked=true;
        } else if(document.form.btn_mode.value == "E" ) {
           document.form.chk_email.checked=true;
        }
        for (ir=1; ir <= rowcount; ir++) {
        	if(sheetObj.GetCellValue(ir,2 ) == "1") {
        		ref_id +=  sheetObj.GetCellValue(ir,"t1_ref_id");
                ref_id +=  "','";
                repo_plan_id=sheetObj.GetCellValue(ir,"t1_repo_pln_id");
                week=sheetObj.GetCellValue( ir, "t1_pln_yrwk");
            }
        }
        ref_id=ref_id.substring(0,ref_id.length-2);
    	var rdParam='/rp ['+repo_plan_id+']';
    	rdParam += '['+ref_id+']';
    	rdParam += '['+tp_sz+']';
    	rdParam += '[' + document.form.user_ofc.value  + ' / ' + document.form.user_name.value + ']';
        rdParam += '/rfonttype60';
    	document.form.repo_pln_id.value=repo_plan_id;
    	document.form.ref_id.value=ref_id;
    	document.form.tpsz.value=tp_sz;
    	document.form.week.value=week;
     	viewer.openFile(RD_path +'apps/opus/ees/eqr/repoplanmanage/cntrrepoexecutionplanestablish/script/REP_EES_EQR_0131.mrd', RDServer+rdParam, {timeout:1800});
    }
    /**
     * initializing rd
     */
    function rdInit(rdObj){
    	viewer.hideToolbarItem(Array["xls"]);
    	viewer.hideToolbarItem(Array["hwp"]);
    	viewer.hideToolbarItem(Array["ppt"]);
    	viewer.hideToolbarItem(Array["doc"]);
    }
    /**
     * setting email/fax info 
     */
    function settingValue(sender, target) {
       if(target == "E") {
          document.form.email.value=sender
          if (sender != ""){
              document.form.chk_email.checked=true;
          }
       } else{
          document.form.fax.value=sender
           if (sender != ""){
              document.form.chk_fax.checked=true;
          }
       }
    }
