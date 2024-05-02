/**
 * @class ESD_TRS_0048
 */
function ESD_TRS_0048() {
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

document.onclick = processButtonClick;

    function processButtonClick(){
         var sheetObject = sheetObjects[0];

         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btng_save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                    
                case "btn_close":
                    self.close();
                break;

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                errMsg = ComGetMsg("TRS90392" );
                ComShowMessage(errMsg);
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
            case 1:      //sheet1 init
                with (sheetObj) {

                    style.height = GetSheetHeight(11);

                    SheetWidth = mainTable.clientWidth;

                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    MergeSheet = msHeaderOnly;

                    Editable = true;

                    InitRowInfo( 1, 1, 9, 100);

                    InitColumnInfo(13, 0, 0, true);

                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "SEQ|Incorrect\nOnes|Invoice No.|Net\nAmount|Tax\nAmount|W.H.T\nAmount|Total\nAmount|Issue\nDate|Receive\nDate|Confirm\nDate";

                    InitHeadRow(0, HeadTitle, true);

                    InitDataProperty(0, cnt++ , dtSeq,             30,   daCenter,     false,    "",               false,          "",         dfNone,         0,          true,          true   );
                    InitDataProperty(0, cnt++ , dtCheckBox,        60,   daCenter,     false,    "chk",               false,          "",         dfNone,         0,          true,          true   );
                    InitDataProperty(0, cnt++ , dtData,            95,   daCenter,     false,    "inv_no",               false,          "",         dfNone,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            85,   daRight,      false,    "inv_bzc_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            75,   daRight,      false,    "inv_vat_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            75,   daRight,      false,    "inv_whld_tax_amt",               false,          "",         dfFloat,          2,          false,          false   );                    
                    InitDataProperty(0, cnt++ , dtData,            85,   daRight,      false,    "inv_ttl_amt",               false,          "",         dfFloat,          2,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            75,   daCenter,     false,    "inv_iss_dt",               false,          "",         dfDateYmd,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            75,   daCenter,     false,    "inv_rcv_dt",               false,          "",         dfDateYmd,         0,          false,          false   );
                    InitDataProperty(0, cnt++ , dtData,            75,   daCenter,     false,    "inv_cfm_dt",               false,          "",         dfDateYmd,         0,          false,          false   );
					InitDataProperty(0, cnt++ , dtHidden,			1,		daRight,		false,    "inv_vndr_seq",		false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,			1,		daRight,		false,    "flag",		false,			"",			dfNone,					0,			false,			false	);										
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	1,		daRight,		false,    "ibflag",				false,			"",			dfNone,					0,			false,			false	);
               }
                break;
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:

                formObj.f_cmd.value = SEARCH;                  
                sheetObj.DoSearch4Post("ESD_TRS_0048GS.do", TrsFrmQryString(formObj));
              break;
              
            case IBSAVE:
                formObj.f_cmd.value = MULTI01;
                sheetObj.DoAllSave("ESD_TRS_0048GS.do", TrsFrmQryString(formObj));               
                break;
        }
    }

    function validateForm(sheetObj,formObj,sAction){

        return true;
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

      function sheet1_OnSaveEnd(sheetObj , errMsg)    
      {
          var opener_obj = window.dialogArguments;

          if ( errMsg != "") return ;
          
          if ( document.form.selrow.value != "")
          {
             opener_obj.document.form.sheet1.RowDelete( document.form.selrow.value , false);              
          }

          document.form.selrow.value = "";

      }

    function Minimize(nItem)
    {

        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
            objs.style.display = "none";


            sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
            sheetObjects[0].focus();
            sheetObjects[0].ViewRows  =20;

        }
        else
        {
            objs.style.display = "inline";

            sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
            sheetObjects[0].focus();
            sheetObjects[0].ViewRows  =10;

        }

    }