/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0551.js
*@FileTitle  : SSR Create
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/    
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;

// Event handler processing by button click event  */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
            case "btn_New":
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                formObject.reset();
                break;
            case "btn_DownExcel":
                if(sheetObject1.RowCount() < 1){//no data
                  ComShowCodeMessage("COM132501");
                }else{
                  sheetObject1.Down2Excel({HiddenColumn:-1});
                }
                if(sheetObject2.RowCount() < 1){//no data
                  ComShowCodeMessage("COM132501");
                }else{
                  sheetObject2.Down2Excel({HiddenColumn:-1});
                }
                break;
//            case "btn_Print":
//                doActionIBSheet(sheetObject1,formObject,RDPRINT);
//                break;
            case "btn_BLList":
                doActionIBSheet(sheetObject1,formObject,COMMAND01);
                break;
            case "btn_SSRView":
                doActionIBSheet(sheetObject1,formObject,COMMAND02);
                break;
            case "btn_Download":
                //doActionIBSheet(sheetObject1,formObject,MULTI);
                
            	if(validateForm(sheetObject1,formObject,MULTI)){
            		var dnldCnt = sheetObject2.GetCellValue( sheetObject2.GetSelectRow(), "dnld" );
					if(dnldCnt != "0"){

						if (!ComShowCodeConfirm("BKG08247")) {
		    				return false;
		    			}
						formObject.chk_down.value = "Y";
						doActionIBSheet(sheetObject1,formObject,MULTI);
						
					} else {
						if(!ComShowCodeConfirm('BKG95003', 'download')){
		    				return false;
		    			}
						// dnld count가 0일 경우 chk_down "C" 넘김
						formObject.chk_down.value = "C";
						doActionIBSheet(sheetObject1,formObject,MULTI);
					}
				}
                
                break;
            case "btn_calendar":
                var cal=new ComCalendarFromTo();
                cal.select(formObject.s_vps_eta_dt, formObject.e_vps_eta_dt, 'yyyy-MM-dd');
                break;  
            case "btn_addLane":
                doActionIBSheet(sheetObject1,formObject,COMMAND03);
                break;          
			case "btn_Delete":
				if(formObject.vvd.value==""){
					ComShowCodeMessage("COM130201","VVD to delete data") // Please input {?msg1}.
					ComSetFocus(formObject.vvd)
					return false;
				}
				if(!ComShowCodeConfirm("BKG01188")) return; // Do you want to delete all saved data?
				doActionIBSheet(sheetObject1,formObject, MULTI05);
				break;  
         } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

//function callbackYNC(returnVal){
//	var sheetObject1=sheetObjects[0];
//    var sheetObject2=sheetObjects[1];
//    var formObject=document.form;
//    
//	if(returnVal!=undefined){
//		formObject.chk_down.value = returnVal;
//		doActionIBSheet(sheetObject1,formObject,MULTI);
//	} else {
//		return false;
//	}
//}


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
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    //selDateToCalendar();
    initControl();
}

function initControl() {
    var formObject=document.form;
    //axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    //axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    formObject.s_vps_eta_dt.focus();
}

function selDateToCalendar(){
    var now=new Date();
    var year=now.getFullYear();
    var month=now.getMonth() + 1;
    var day=now.getDate();
    if(month < 10) month='0' + month;
    if(day < 10) day='0' + day;
    var dateval='' + year + '-' + month + '-' + day;
    document.form.e_vps_eta_dt.value=dateval;
    document.form.s_vps_eta_dt.value=dateval;
    document.form.e_vps_eta_dt.focus();
}

/**
 * handling buttons on loading
 */
function SetButtonStatus(){
		// Customs Common Code 테이블의 EU Staff 인 경우에만 Data Delete 버튼 활성화
		if(sheetObjects[0].GetCellValue(1, "eu_stf_flg")=="Y"){
			document.getElementById("btn_Delete").style.display='';
		}else{
			document.getElementById("btn_Delete").style.display='none';
		}		
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
            with(sheetObj){
                var HeadTitle1="|Seq.|Lane|VVD|SSR No.|Vessel Name|Lloyd No.|Call Date|A|Last  EDI|B/L|DNLD|DIFF|POD|SEND ID|SEND Date|Receive Date|eu_stf_flg|";
                var headCount=ComCountHeadTitle(HeadTitle1);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ssr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"vvd_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"lloyd_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"eta_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"msg_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"edi_sts",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_count",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dnld_count",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"diff",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",      KeyField:0,   CalcLogic:"",   Format:"YmdHm",        PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",      KeyField:0,   CalcLogic:"",   Format:"YmdHm",        PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eu_stf_flg",  KeyField:0,   CalcLogic:"",   Format:"",             PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];

	            InitColumns(cols);
	            SetEditable(1);
	            SetCountPosition(0);
	            SetSheetHeight(235);
            }
            break;
        case "sheet2":
            with(sheetObj){
                var HeadTitle1="|Seq.|POL|POL ATD|POD|BDR|BDR Date|B/L|DNLD|DIFF|pol_clpt_ind_seq|pod_clpt_ind_seq";
                var headCount=ComCountHeadTitle(HeadTitle1);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"pol_atd",   KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bdr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"bdr_date",  KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dnld",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"diff",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                   
			                {Type:"Text",      Hidden:1,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"pol_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                {Type:"Text",      Hidden:1,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"pod_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                //SetColProperty("pol_atd", {Format:"####-##-####:##"} );
                //SetColProperty("bdr_date", {Format:"####-##-####:##"} );
                SetSheetHeight(275);
            }
            break;
    }
}

// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
        case IBSEARCH:    
            if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_BKG_0551GS.do", FormQueryString(formObj) );

            }
            break;
        case MULTI:        
            if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value=MULTI;
                var vVvd=formObj.vvd1.value;
                var vPol=formObj.pol1.value;
                var chkDown = formObj.chk_down.value;
                
                var selectPolSeq = sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"pol_clpt_ind_seq");
     			var selectPodSeq = sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"pod_clpt_ind_seq");
     			var vPod = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"port_cd");
     			
     			
                sheetObj.SetRowStatus(1,"U");
//                sheetObj.DoSave("ESM_BKG_0551GS.do?vvd=" + vVvd +"&pol=" + vPol +"&pod=" + vPod, FormQueryString(formObj));
     			sheetObj.DoSave("ESM_BKG_0551GS.do?vvd=" + vVvd + "&pol=" + vPol+ "&chk_down=" + chkDown+ "&pod=" + vPod + "&pol_clpt_ind_seq=" + selectPolSeq+ "&pod_clpt_ind_seq=" + selectPodSeq, FormQueryString(formObj), -1, 0);
                
                
            }
            break;
        case IBINSERT:     
            break;
//        case RDPRINT:        // print
//            if(validateForm(sheetObj,formObj,sAction)) return false;
//            break;    
        case COMMAND01:
            if(validateForm(sheetObj,formObj,sAction)) 
            	ComOpenWindowCenter("ESM_BKG_0063_POP.do?pgmNo=ESM_BKG_0063&popup=y&vvd=" + formObj.vvd1.value , "ESM_BKG_0063", 1200, 690, false);
            break;  
        case COMMAND02:
            if(validateForm(sheetObj,formObj,sAction)) 
                ComOpenWindowCenter("ESM_BKG_0494_POP.do?pgmNo=ESM_BKG_0494&popup=y&vvd=" + formObj.vvd1.value , "ESM_BKG_0494", 1000, 470, false);
            break;  
        case COMMAND03:
                ComOpenWindowCenter("ESM_BKG_1095.do" , "ESM_BKG_1095", 400, 430, false);
            break;              
		case MULTI05: // 데이터 삭제
			formObj.f_cmd.value=MULTI05;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0551GS.do", FormQueryString(formObj));
			sheetObj.LoadSaveData(sXml,{Sync:1} );
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
			break;
    }
}

/**
 * handler  EDI Code mapping to EDI DESC 
 * @return
 */
function changeEDICodeToEDIDesc(sCode){
    switch ( sCode ){
        case 'NN' :
            return 'Initial';
        break;
        case 'ON' :
            return 'Sending';
        break;
        case 'OA' :
            return 'Sent';
        break;
        case 'RN' :
            return 'Replacing'
        break;
        case 'RA' :
            return 'Replaced'
        break; 
        case 'CN' :
            return 'Cancelling'
        break;
        case 'CA' :
            return 'Cancelled'
        break;
        case 'OE' :
            return 'Error(S)'
        break;
        case 'CE' :
            return 'Error(C)'
        break;
        case 'RE' :
            return 'Error(R)'
        break;
    }
}
	
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
	    switch (sAction) {
	        case IBSEARCH: 
	            if (!ComChkValid(formObj)) return false;
	            if(formObj.s_vps_eta_dt.value == '')
	             {
	                 ComShowCodeMessage('BKG00626');
	                 ComSetFocus(formObj.s_vps_eta_dt)
	                 return false;
	             }
	             if(formObj.e_vps_eta_dt.value == '')
	             {
	                 ComShowCodeMessage('BKG00626');
	                 formObj.date_to.focus();
	                 return false;
	             }
	             var diffDate=ComGetDaysBetween( formObj.s_vps_eta_dt.value, formObj.e_vps_eta_dt.value)
	             var y=formObj.s_vps_eta_dt.value.substring( 0, 4 );
	             var m=formObj.s_vps_eta_dt.value.substring( 5, 7 );
	             var lastDay=ComGetLastDay( y, parseInt( m, 10 ) );
	             if ( diffDate+1 > lastDay ){
	                 ComShowCodeMessage('BKG01080');
	                 return false;
	             }   
	             return true;
	        break;
	        case MULTI:
	        	if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ssr_no") == "") 
	            { 
	                ComShowCodeMessage('BKG00886', 'SSR No.');
	                formObj.vvd1.focus();
	                return false;
	            }
	        	if (formObj.vvd1.value.length != 9 || (formObj.pol1.value.length != 5 ) ) 
	            { 
	                ComShowCodeMessage('BKG00886');
	                formObj.vvd1.focus();
	                return false;
	            }
	            return true;
	        break;
	        case COMMAND01:
	            return true;
	            break;
	        case COMMAND02:
	            return true;
	            break;  
	    }
	}
	
	/**
	 * handling sheet double click
	 * @param row
	 * @param col
	 * @return
	 */
	function sheet1_OnClick(sheetObj, row, col) {
	    var vVvd=sheetObj.GetCellValue( row, 3 );
	    var vPod=sheetObj.GetCellValue( row, 13 );
	    document.form.f_cmd.value=SEARCH01;
	    sheetObjects[1].DoSearch("ESM_BKG_0551GS.do?vvd="+vVvd+"&pod="+vPod, FormQueryString(document.form) );
	    document.form.vvd1.value=vVvd;      
	
	}
	
	/**
	 * handling sheet2 double click 
	 * @param row
	 * @param col
	 * @return
	 */
	function sheet2_OnClick(sheetObj, row, col) {
	    var vPol=sheetObj.GetCellValue( row, 2 );
	    document.form.pol1.value=vPol;      
	}   
	
	/**
	 * handling search condition input
	 */
	function obj_KeyUp() {
	    var formObject=document.form;
	    var srcName=ComGetEvent("name");
	    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	    var srcValue=window.event.srcElement.getAttribute("value");
	    if (ComChkLen(srcValue, srcMaxLength) == "2") {
	        ComSetNextFocus();
	    }
	}
	
	function sheet1_OnSearchEnd(sheetObj, Code, Msg) { 
		var formObj=document.form;
	    if( sheetObj.RowCount()== 0 ){
	        var vSSR=formObj.svc_rqst_no.value;
	        if( '' != vSSR  ){
	            ComShowCodeMessage('BKG06107', vSSR); // None of B/L Data is found with the SSR: [{?msg1}]
	        }else{
	            ComShowCodeMessage('BKG06106'); // The Vessel doesn't call at BEANR, Please check Vessel schedule once again.
	        }
	        sheetObjects[1].RemoveAll();
	        formObj.vvd1.value='';
	        formObj.pol1.value='';
	    }
	    else {
	        formObj.vvd1.value=sheetObj.GetCellValue( 1, 3 );
	    }
	    SetButtonStatus();
	}
	
	function sheet2_OnSearchEnd(sheetObj, Code, Msg) { 
		
		var formObj=document.form;
	    if( sheetObjects[1].RowCount()== 0 ){
	        ComShowCodeMessage('BKG06108');
	    }
	    var vPol=sheetObjects[1].GetCellValue( 1, 2 ) ;
	    var vIsYNToBDR='Y' ;
	    for( var i=1; i<sheetObjects[1].RowCount()+1; i++ ){
	        //var diff = sheetObjects[1].CellValue( i, 9 );
	        var vBDR=sheetObjects[1].GetCellValue( i, 'bdr' );
	        if( 'N' == vBDR )
	            vIsYNToBDR='N' ;
	    }
	    if ( 'N' == vIsYNToBDR )
	         ComShowCodeMessage('BKG06109');
	    if(sheetObjects[1].RowCount() > 0)    formObj.pol1.value=vPol;    
	}
	

	/**
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		
		if (document.form.f_cmd.value == MULTI) {
			
			if (ErrMsg == "" || ErrMsg == "0") {
                doActionIBSheet(sheetObj,document.form,IBSEARCH); // 재조회
                sheetObjects[1].RemoveAll();
			} else {
				ComShowCodeMessage('BKG01089');
			}
		}
	}

