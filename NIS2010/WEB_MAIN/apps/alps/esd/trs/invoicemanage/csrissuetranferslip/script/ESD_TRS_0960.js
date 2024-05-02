/**
 * @class ESD_TRS_0960
 */
function ESD_TRS_0960() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

var comboObjects = new Array();
var comboCnt = 0 ; 

document.onclick = processButtonClick;

    function processButtonClick(){
        
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];

        var formObject = document.form;

        var checkflag = false;
        var confirmflag = false;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btng_detailinquiry":
                	
                  /* if( 'trs' != document.form.mode.value )   return; 2007.10.08 - Detail button ???*/
  
                   var chkRowCount = sheetObject.CheckedRows  ("chk");
            
                   if ( chkRowCount != "1")
                   {
                       ComShowCodeMessage("TRS90141");
                       return false;
                   }
            
                   var chkRow = sheetObject.FindCheckedRow("chk");
                   chkRow = chkRow.substring( 0 , chkRow.length-1);
                   
               	   var flag = sheetObject.CellValue(chkRow , "flag");
                   
                   document.AuditForm.inv_no.value = sheetObject.CellValue(chkRow , "inv_no");
                   document.AuditForm.inv_vndr_seq.value = sheetObject.CellValue(chkRow , "inv_vndr_seq");
                   document.AuditForm.editflag.value = "N" ;
                   document.AuditForm.mode.value = "search";
                   document.AuditForm.mode_tab.value = "C";   //A(Auditing tab)-Default Value, C(Confirm tab)
          		   document.AuditForm.pgmNo.value = "ESD_TRS_0038";
                 
             	   if ( flag == "R")
            	   {
            	       window.open('', 'OpenAudit', "scroll:no,status:no,help:no,width=1010,Height=550");
                	   document.AuditForm.action = 'ESD_TRS_0038.screen';
            	   } else {
            	       window.open('', 'OpenAudit', "scroll:no,status:no,help:no,width=1010,Height=600");
            	       document.AuditForm.action = 'ESD_TRS_0033.screen';
            	   }
               	   document.AuditForm.target = "OpenAudit";
            	   document.AuditForm.submit();
	   
                break;   

                case "btn_close":
                    self.close();
                break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("TRS90392");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    

    function setSheetObject(sheet_obj){ 
     	
       sheetObjects[sheetCnt++] = sheet_obj;
       
    }

    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }         
        
			ComEnableObject(document.form.csr_no, false);
			ComEnableObject(document.form.vndr_no, false); 
			ComEnableObject(document.form.vndr_nm, false);
			ComEnableObject(document.form.inv_cnt, false);
			ComEnableObject(document.form.csr_curr_cd, false);
			ComEnableObject(document.form.csr_amt, false);         
			ComEnableObject(document.form.asa_no, false);
			ComEnableObject(document.form.cost_ofc, false);	
			ComEnableObject(document.form.max_iss_dt, false);	
			ComEnableObject(document.form.max_rcv_dt, false);	
			ComEnableObject(document.form.vndr_term_nm, false);	
			ComEnableObject(document.form.payment_due_dt, false);	
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
			
    }

    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:
                with (sheetObj) {

                    style.height = GetSheetHeight(13);

                    SheetWidth = mainTable.clientWidth;

                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    MergeSheet = msHeaderOnly;

                    Editable = true;

                    InitRowInfo( 1, 1, 9, 100);

                    InitColumnInfo(14, 1, 0, true);

                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.||Invoice No.|Net Amount|Tax Amount|W.H.T Amount|S.B.C Amount|Total Amount|INV ISS Data|INV RCV Data|INV CFM Data" ;

                    InitHeadRow(0, HeadTitle, true);

					InitDataProperty(0, cnt++ , dtSeq,	 		   30,	 daCenter,		false,    "",					false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtCheckBox, 	   30,	 daCenter,		false,    "chk",					false,			"",			dfNone,					0,			true,			true	);
					InitDataProperty(0, cnt++ , dtData,            80,   daCenter,      false,    "inv_no",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            80,    daRight,      false,    "inv_bzc_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            75,    daRight,      false,    "inv_tax_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            85,    daRight,      false,    "inv_whld_tax_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            85,    daRight,      false,    "inv_sbc_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            85,    daRight,      false,    "inv_ttl_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            70,   daCenter,      false,    "inv_iss_dt",               false,          "",         dfDateYmd,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            78,   daCenter,      false,    "inv_rcv_dt",               false,          "",         dfDateYmd,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            60,   daCenter,      false,    "inv_cfm_dt",               false,          "",         dfDateYmd,         0,          false,          false   );
					InitDataProperty(0, cnt++ , dtHidden,			1,	  daRight,		false,    "inv_vndr_seq",		false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,			1,	  daRight,		false,    "flag",		false,			"",			dfNone,					0,			false,			false	);										
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	1,	  daRight,		false,    "ibflag",				false,			"",			dfNone,					0,			false,			false	);
               }
                break;
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
          case IBSEARCH:
              	formObj.f_cmd.value = SEARCH;                	
               	sheetObj.DoSearch4Post("ESD_TRS_0960GS.do", TrsFrmQryString(formObj));
                break; 
          }
    }
    
    function sheet1_OnSearchEnd(sheetObj , ErrMsg)
    {
        if (ErrMsg != "")  return ;
        
        sxml1 = sheetObj.EtcData("sxml1");
        ComEtcDataToForm(document.form ,sheetObj);
        sheetObj.RemoveEtcData();
        sheetObjects[0].LoadSearchXml(sxml1);
        ComChkObjValid(document.form.max_iss_dt);
        ComChkObjValid(document.form.max_rcv_dt);

        if (! ComIsNumber(document.form.vndr_term_nm) )
        {
           document.form.vndr_term_nm.value = "KR H/O Payment_60";
        }
    }
      