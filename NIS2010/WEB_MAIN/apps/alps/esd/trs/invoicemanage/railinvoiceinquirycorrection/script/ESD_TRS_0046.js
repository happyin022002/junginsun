/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0046 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0046() {
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
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// ??????

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

/* ???????? ?? ???? ?????? ?? */
document.onclick = processButtonClick;

/* ?? ???? ???? ????? ?????? ?????? */
function processButtonClick(){
	 /***** ?? ??? 2? ??? ??? ?? ???? ???? ??? *****/
	 var sheetObject = sheetObjects[0];
	 /*******************************************************/
	 var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_reset":
				sheetObject.RemoveAll();
				formObject.reset();
				break;

			case "btn_minimize":
				Mincount = (Mincount+1)%2 ;
				Minimize(Mincount);
				break;

			case "btns_calendar":
				var cal2 = new ComCalendarFromTo();
				cal2.displayType = "date";
				cal2.select(document.form.fmdate, document.form.todate, 'yyyyMMdd');
				break;

			case 'btns_no_cd':
				rep_Multiful_inquiry(srcName);
				break;

			case 'btng_provider':
				rep_OnPopupClick();
				break;

			case "btng_downinexcel1":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btng_downinexcel2":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btng_holdsave":
				 doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;

            case "btng_invoicedelete":
                var stsRow = "";
                var chkRow = sheetObject.FindCheckedRow("ibcheck");
                var arrRow = chkRow.split("|");
                for (idx=0; idx<arrRow.length-1; idx++)
                {
                    stsRow = sheetObject.CellValue(arrRow[idx] , "trsp_inv_aud_sts_cd");
                    if(!(stsRow == "SV" || stsRow == "CF" || stsRow == "RC" ))
                    {
                        ComShowCodeMessage("TRS90144");
                        return false;
                    }
                }
                doActionIBSheet(sheetObject,formObject,IBDELETE);
                break;

			case "btng_invconfrimcancel":
                var stsRow = "";
                var chkRow = sheetObject.FindCheckedRow("ibcheck");
                var arrRow = chkRow.split("|");
                for (idx=0; idx<arrRow.length-1; idx++)
                {
                    stsRow = sheetObject.CellValue(arrRow[idx] , "trsp_inv_aud_sts_cd");
                    if(!(stsRow == "CF"))
                    {
                         ComShowCodeMessage("TRS90144");
                        return false;
                    }
                }
				 doActionIBSheet2(sheetObject,formObject,IBSAVE );
				break;

			case "btng_invaudit":
				 invoiceAuditInquiry(sheetObject , 'Y');
				break;

			case "btng_detailinquiry":
				 invoiceAuditInquiry(sheetObject , 'N');
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

/**
 * IBSheet Object? ??? ??
 * ?? ?? ???? ????? ??? ?? ? ??? ?? ????? ??? ? ??
 * ??? ?? ??? ??
 */
function setSheetObject(sheet_obj){

   sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet ?? ?? ? ???
 * body ??? onLoad ?????? ??
 * ??? ?????? ??? ?? ????? ?? ??? ????
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

	//khlee-?? ?? ?? ?? ?? ??
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	//khlee-??? ?? ?? ?? ??
		ComEndConfigSheet(sheetObjects[i]);
	}
      getRailVendorComboList(document.form.combo_svc_provider , combo_svc_providerCode , combo_svc_providerText , '');                           // Serveic Provider ?? ?? (Rail Load) ??
      initVendorCombo(document.combo_svc_provider);
      changeObjectColor("btng_invoicedelete", "red", "input2");
}

/**
 * ?? ?????, ?? ??
 * param : sheetObj ==> ??????, sheetNo ==> ?????? ??? ???? ?? ????
 * ??? ??? ?? ?? ??? case? ???? ?? ?????? ????
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				// ?? ??
				style.height = GetSheetHeight(15);
				//?? ?? ??
				SheetWidth = mainTable.clientWidth;

				//Host?? ??[??][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//??Merge ?? [??, Default msNone]
				MergeSheet = msHeaderOnly;

			   //??Edit ?? ?? [??, Default false]
				Editable = true;

				//?????[??][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//??????[??][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(25, 1, 0, true);

				// ???? ??? ? ?? ?? ??? ????
				InitHeadMode(true, true, true, true, false,false)

				 var HeadTitle = "|Status|Hold|Invoice No|S/P|S/P|W/O\nCurrency|W/O Fuel\nAmount|W/O Total\nAmount|Invoice\nCurrency|Invoice\nBasic Amount|Invoice\nTotalAMT|Date|Date|Date|Date|Date|CSR No|Payment\nMethod|Check/\nT.T No|Invoice Remark|Invoice Creation|Invoice Creation" ;
                 var HeadTitle1= "|Status|Hold|Invoice No|Code|Name|W/O\nCurrency|W/O Fuel\nAmount|W/O Total\nAmount|Invoice\nCurrency|Invoice\nBasic Amount|Invoice\nTotalAMT|Issue|Received|Paid|G/L|Status\nUpdated|CSR No|Payment\nMethod|Check/\nT.T No|Invoice Remark|Office|User ID" ;

				//?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//?????    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++ , dtDummyCheck, 30,		daCenter,			true,    "ibcheck",				false,			"",			dfNone,			0,			true,			false	);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,			true,    "trsp_inv_aud_sts_nm",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtCheckBox,	45,		daCenter,			true,    "inv_hld_flg",				false,			"",			dfNone,			0,			true,			false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daLeft,			    true,    "inv_no",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 60,		daLeft,				true,    "inv_vndr_seq",				false,			"",			dfNone,			0,			false,			false	);

				InitDataProperty(0, cnt++ , dtData,	 120,		daCenter,			true,    "inv_vndr_nm",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 70,		daCenter,			true,    "curr_cd",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,	 80,		daRight,			true,    "fuel_scg_amt",				false,			"",			dfFloat,			2,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 80,		daRight,			true,    "wo_tot_amt",				false,			"",			dfFloat,			2,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 80,		daCenter,			true,    "inv_curr_cd",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 85,		daRight,			true,    "inv_bzc_amt",				false,			"",			dfFloat,			2,			false,			false	);

				InitDataProperty(0, cnt++ , dtData,	  80,		daCenter,			true,    "inv_ttl_amt",				false,			"",			dfFloat,			2,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	  80,		daCenter,			true,    "inv_iss_dt",				false,			"",			dfDateYmd,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	  80,		daCenter,			true,    "inv_rcv_dt",				false,			"",			dfDateYmd,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	  80,		daCenter,			true,    "pay_dt",				false,			"",			dfDateYmd,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	  80,		daCenter,			true,    "gl_dt",				false,			"",			dfDateYmd,				0,			false,			false	);

				InitDataProperty(0, cnt++ , dtData,	  80,		daCenter,			true,    "upd_dt",				false,			"",			dfDateYmd,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 120,		daCenter,			true,    "csr_no",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			true,    "inv_pay_mzd_cd",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			true,    "inv_chk_trns_no",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 100,		daCenter,			true,    "inv_remark",				false,			"",			dfNone,			0,			false,			false	);

				InitDataProperty(0, cnt++ , dtData,	 60,		daCenter,			true,    "cre_ofc_cd",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	 50,		daCenter,			true,    "cre_usr_id",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtStatus,      0,   daCenter,  false,    "ibflag");
				InitDataProperty(0, cnt++ , dtHidden,	   0,  daCenter,  true,		 "trsp_inv_aud_sts_cd");

				RangeBackColor(1, 12, 1, 23) = RgbColor(222, 251, 248);   // ENIS
				ColHidden('ibflag')						= true;

				HeadRowHeight = 22 ;

		   }
			break;
	}
}


// Sheet?? ???? ??
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //??
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_TRS_0046GS.do", TrsFrmQryString(formObj));
			break;

		case IBSAVE:        //Hold ??
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESD_TRS_0046GS.do", TrsFrmQryString(formObj) , -1 , false);
			break;

       case IBDELETE:
    		var formObj = document.form;
    		var sheetObj = sheetObjects[0];
    		var checkList = sheetObj.FindCheckedRow('ibcheck');
    		var checkArray = checkList.split('|');
    		if(checkList == ''){
    			ComShowCodeMessage('TRS90215');
    			return false;
    		}
    		
    	   	if(!confirm(ComGetMsg('TRS90409'))) return false;
			formObj.f_cmd.value = REMOVE;
			sheetObj.DoSave("ESD_TRS_0046GS.do", TrsFrmQryString(formObj) , "ibcheck" , false);
			break;

	   case IBDOWNEXCEL:        //?? ????
		  sheetObj.Down2Excel(-1, false, false, true);
		  break;
	}
}
// Sheet?? ???? ??
function doActionIBSheet2(sheetObj,formObj,sAction  ) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //??

			break;

		case IBSAVE:        //??
			formObj.f_cmd.value = MULTI02;
			formObj.inv_aud_sts_cd.value= 'SV';
			sheetObj.DoSave("ESD_TRS_0046GS.do", TrsFrmQryString(formObj) ,"ibcheck" , false);
			break;

       case IBDELETE:
			formObj.f_cmd.value = REMOVE;
			sheetObj.DoSave("ESD_TRS_0046GS.do", TrsFrmQryString(formObj) , "ibcheck" , false);
			break;

	   case IBDOWNEXCEL:        //?? ????
		  sheetObj.Down2Excel(-1, false, false, true);
		  break;

	}
}

function sheet1_OnSaveEnd(sheetObj , errMsg)
{
    if ( errMsg == "")
        doActionIBSheet(sheetObj , document.form, IBSEARCH);
}


function sheet1_OnChange(sheetObj , row , col , value)
{
    if(sheetObj.ColSaveName(col) == "inv_hld_flg")
    {
        if ( sheetObj.CellValue(row , "trsp_inv_aud_sts_cd") != "CF")
        {
            ComShowCodeMessage("TRS90144");
            sheetObj.CellValue2(row , "inv_hld_flg") = 0;
            return;
        }
    }
}

	function invoiceAuditInquiry(sheetObj ,  editflag){
       var chkRowCount = sheetObj.CheckedRows  ("ibcheck");

       if ( chkRowCount != "1")
       {
           ComShowCodeMessage("TRS90141");
           return false;
       }

       var chkRow = sheetObj.FindCheckedRow("ibcheck");
       chkRow = chkRow.substring( 0 , chkRow.length-1);

       if ( editflag == "Y" ){
           if (!( sheetObj.CellValue( chkRow , "trsp_inv_aud_sts_cd") == 'SV' ||  sheetObj.CellValue( chkRow , "trsp_inv_aud_sts_cd") == 'DA'  ))
           {
               ComShowCodeMessage("TRS90059");
               return false;
           }
       }
       document.AuditForm.inv_no.value = sheetObj.CellValue(chkRow , "inv_no");
       document.AuditForm.inv_vndr_seq.value = sheetObj.CellValue(chkRow , "inv_vndr_seq");
       document.AuditForm.editflag.value = editflag ;
       if ( editflag == "N" )
       {
           window.open('', 'OpenAudit', "scroll:no,status:no,help:no,width=1030,Height=550");
    	   document.AuditForm.target = "OpenAudit";
       }
	   document.AuditForm.action = 'ESD_TRS_0038.screen';
	   document.AuditForm.submit();

	}

  /**
 * MInimize ??? ??? ??
 */
function Minimize(nItem)
{

	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
		objs.style.display = "none";


		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(19);
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

/**
 * rep_commodity????
 */
function rep_Multiful_inquiry(btn_obj)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //?? ???? ????
		var rep_cmdt_cd_val ="";   //?? ???? ????
		var cmdt_desc_val ="";   //?? ???? ????
		var classId ="getTRS_ENS_906";
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : ???? ?? ??? ???..
 */
function getTRS_ENS_906(rowArray, x1) {
	var obj = eval('document.form.'+x1.substring(x1.indexOf('btns_')+5));
	obj.value = rowArray;
}

/**
function combo_svc_provider_OnKeyDown(combo, keycode,shift)
{
	if(keycode == 13)
	{
		searchVendorName(combo);
	}
}

function searchVendorName(combo)
{
	var formObject = document.form;
	formObject.f_cmd.value = SEARCH11;
	formObject.TRSP_SO_VNDR_NO.value = combo.Text;

	document.form.svc_provider.value = combo.GetText(combo.Text,1);
}
*/
/**
 * service provider combo ??? textfield? ? ???? ???
 **/
function combo_svc_provider_OnChange(combo, Index_Code, Text)
{
	document.form.svc_provider.value = combo.GetText(Index_Code,1);
}

/**
 * rep_commodity????
 */
function rep_OnPopupClick()
{

		var formObject = document.form;
		var cmdt_cd_val ="";   //?? ???? ????
		var rep_cmdt_cd_val ="";   //?? ???? ????
		var cmdt_desc_val ="";   //?? ???? ????
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');

}

/**
 * rep_commodity???? : ???? ?? ??? ???..
 */
function getCOM_ENS_rep(rowArray) {

	var formObj = document.form;
	var comboObj = document.combo_svc_provider;

	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];

		comboObj.InsertItem(comboObj.GetCount(), colArray2+'|'+colArray3, colArray2);

		comboObj.Text = colArray2;
		document.form.svc_provider.value = comboObj.GetText(comboObj.Text, 1);
	}
}


