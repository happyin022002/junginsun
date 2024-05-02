/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0040.jsp
*@FileTitle  : Port Tariff
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
*            : SJH.20150108.MOD : 전반수정
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheet_height=290; // sheet height
var zoomFlag="close"; // Zoom Flag
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var isYyyyMmRetrieved=true; // yyyymm or yyyyww

var EXCEL_LOAD_FLG = false;	//check excell loading
var pop_rtn_value = "";
var sRow=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
    var sheetObject =  sheetObjects[0];
    var sheetObject1 = sheetObjects[1]; 
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name"); 
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {     
            case "btn_Create":
                doActionIBSheet(sheetObject,formObject,IBCREATE);
                break;
            case "btn_Retrieve":
            	clearSheet();												//SJH.20150108.MOD
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

            case "btng_Save":
                doActionIBSheet2(sheetObject1, formObject, IBSAVE);			//SJH.20150108.MOD
                break;                   
                      
            case "btn_Save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
                
            case "btn_Copy":
                doActionIBSheet(sheetObject,formObject,IBCOPYROW);			//SJH.20150206.ADD
                break;                
                
            case "btn_rowadd":      // Not used
                doActionIBSheet(sheetObject,formObject,IBINSERT);
                break;
                
            case "btn_Downexcel":
                if(sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                }
                break;
            case "bu_zoom_in":												//SJH.20150108.MOD
                if ( sheetObject.RowCount() < 1 ) return;
                sheetObject.SetSheetHeight( sheetObject.GetSheetHeight(sheet_height) * 2 );
                div_zoom_in.style.display="none";
                div_zoom_out.style.display="inline";
                if (parent && parent.syncHeight) {
                    parent.syncHeight();
                }
                break;
                
            case "bu_zoom_out":
                if ( sheetObject.RowCount() < 1 ) return;
                sheetObject.SetSheetHeight( sheet_height );
                div_zoom_in.style.display="inline";
                div_zoom_out.style.display="none";
                if (parent && parent.syncHeight) {
                    parent.syncHeight();
                }
                break;
                
            case "btn_loadexcel":
                doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
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
 * Change period when the month, week changed
 */
function setPeriod(obj){
    var formObj=document.form;
    colChange();
    
    ComCoaSetPeriod2(obj);
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    loadingMode=false;
}

/**
  * Setting multicombo items
  */
function initCombo(comboObj, comboId) {
    with (comboObj) {
        SetDropHeight(300);
        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
        SetSelectIndex(0);
    }
}

/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
    case 1:      //sheet1 init
        with(sheetObj){
    		//SJH.20141222.MOD : 헤더 1줄->2줄 폭 수정..
            //var HeadTitle="STS|YYYY-MM|Week|Service Lane|Dir.|Vessel Class|Port|Yard|Local Currency||Port Local|Canal Local|Port USD|Canal USD|tml_cd|upload_flg";
            var HeadTitle0  = "STS|SEL||Status|YYYY-MM|Week|S.Lane|Vessel|Voyage|Dir.|Port Expense|Port Expense|Port Count|Port Count|Port Count|VVD";   
            var HeadTitle1  = "STS|SEL||Status|YYYY-MM|Week|S.Lane|Vessel|Voyage|Dir.|Final|PSO|Total|COA|PSO|VVD";
            
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
            
            var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle0, Align:"Center"},
                            { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);
                      
            var cols = [{Type:"Status",    Hidden:1,	Width:30, 	Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"CheckBox",  Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk_flag", 		KeyField:0, 	CalcLogic:"",   Format:"",  	PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pso_max_seq",      KeyField:0,   	CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Combo",     Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cost_sts",         KeyField:0,   	CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",   	KeyField:0,   	CalcLogic:"",   Format:"Ym",  	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",  		KeyField:0,   	CalcLogic:"",   Format:"",     	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  	Width:60,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",       	KeyField:0,   	CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",       	KeyField:0,   	CalcLogic:"",   Format:"",   	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0, 	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",    	KeyField:0,   	CalcLogic:"",   Format:"",   	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0, 	Width:60,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",  		KeyField:0,   	CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"AutoSum",   Hidden:0, 	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"pso_cost_ttl_amt",	KeyField:0,   	CalcLogic:"",   Format:"Float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"AutoSum",   Hidden:0, 	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"pso_cost_pso_ttl_amt",	KeyField:0,	CalcLogic:"",   Format:"Float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"AutoSum",   Hidden:0, 	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"ttl_cnt",    		KeyField:0,   	CalcLogic:"",   Format:"Float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"AutoSum",   Hidden:0, 	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"coa_cnt",     		KeyField:0,   	CalcLogic:"",   Format:"Float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"AutoSum",   Hidden:0, 	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"pso_cnt",          KeyField:0,   	CalcLogic:"",   Format:"Float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, 	Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vvd",          	KeyField:0,   	CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
                       
            InitColumns(cols);                        

            InitDataCombo (0, "cost_sts", "C|E|T|N", "C|E|T|N");
            //SetEditable(1);//Editkind[optional,Defaultfalse]
            SetCountPosition(4);			//SJH.20141223.ADD
            //SetColProperty(0 ,"cost_wk" , {AcceptKeys:"N"});
            //SetColProperty(0 ,"slan_cd" , {AcceptKeys:"E"});
            //SetColProperty(0 ,"port"    , {AcceptKeys:"E"   , InputCaseSensitive:1});
            //SetColProperty(0 ,"cy"      , {AcceptKeys:"E|N" , InputCaseSensitive:1});
           
            SetSheetHeight(sheet_height) ;
        }
        break;
        
        
    case 2:   
        with(sheetObj){
    		//SJH.20141222.MOD : TITLE변경..
            var HeadTitle   = "STS|||||Port|CY|Currency|Port Expense|Port Expense|CreDt|";
            var HeadTitle1  = "STS|||||Port|CY|Currency|COA|PSO|CreDt|"; 
            
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
            
            var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"},
                            { Text:HeadTitle1, Align:"Center"} ];
            
            InitHeaders(headers, info);
                      
            var cols = [{Type:"Status",    Hidden:0,	Width:50, 	Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"Text",      Hidden:1,  	Width:55,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",       	KeyField:0,   	CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1,  	Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",       	KeyField:0,   	CalcLogic:"",   Format:"",   	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",    	KeyField:1,   	CalcLogic:"",   Format:"",   	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, 	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",  		KeyField:0,   	CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        
                        {Type:"Text",      Hidden:0, 	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",  		KeyField:0,   	CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0, 	Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cy_cd",  			KeyField:0,   	CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0, 	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",  		KeyField:0,   	CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        
                        {Type:"AutoSum",   Hidden:0, 	Width:130,  Align:"Right",   ColMerge:1,   SaveName:"port_usd_amt",		KeyField:0,   	CalcLogic:"",   Format:"Float",	PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"AutoSum",   Hidden:0, 	Width:130,  Align:"Right",   ColMerge:1,   SaveName:"port_pso_amt",		KeyField:0,		CalcLogic:"",   Format:"Float",	PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, 	Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   	CalcLogic:"",   Format:"Float",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:1, 	Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cre_dt",     		KeyField:0,   	CalcLogic:"",   Format:"Float",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
                        
                        
            InitColumns(cols);
                        
            SetCountPosition(4);			//SJH.20141223.ADD                
            SetSheetHeight(235) ;
        }
        break;
    }
}

//SJH.20150108.ADD
function colChange(){
    var formObj=document.form;
    if ( formObj.f_yrtype[0].checked ) {
        sheetObjects[0].SetColHidden("cost_wk",1);
    } else if ( formObj.f_yrtype[1].checked ) {
        sheetObjects[0].SetColHidden("cost_wk",0);
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

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    ComOpenWait(false);
    sheetObj.SetSumText(0,0,"");
    sheetObj.SetSumText(0,3,"TOTAL");  
}

/**
 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 */
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	if (Col == "chk_flag"){
      ComSyncAllCheck(sheetObj, "chk_flag", Value);
	}
}

/**
 * sheet1을 더블클릭하여 상세조회한다
 */
 function sheet1_OnDblClick(sheetObj , row, col){	 
	 doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);			//SJH.20150108.MOD
}
 
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);// Prohibit button click when a business transaction is processing
    
    switch(sAction) {
	case IBCREATE:      //생성	SJH.20150108.MOD
        if(!validateForm(sheetObj,formObj,sAction)) return false;
		
		var iCheckRow = sheetObj.CheckedRows("chk_flag");
		if (iCheckRow ==0 ) {
			ComOpenWait(false);
			ComShowCodeMessage("COA10015", "Target VVD");
			break;
		}
		
        ComOpenWait(true);
        formObj.f_cmd.value=MULTI02;
        ComAddSeparator_Local(formObj.f_yearweek, "-");
        var sParam = sheetObj.GetSaveString(0);
        if (sheetObj.IsDataModified() && sParam == "") return; //IsDataModified keyfield check
        sParam= sParam + "&"+FormQueryString(formObj);
        var sXml=sheetObj.GetSaveData("ESM_COA_0040GS.do", sParam );
        sheetObj.LoadSaveData(sXml, {Sync:1});

        ComOpenWait(false);
        var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
        ComOpenWait(false);
      
		switch(BatchStatus){
		case "4"://작업실행완료						
//			ComShowMessage(ComGetMsg("COA20066", "Port Expense Calculation", "10")); 
			ComShowMessage("Master data creation is running by batch process. It will take several minutes according to the data volume for processing. Please try to retrieve to check the result after certain period.");
			break;
		case "5":// Error 발생
			ComShowMessage("Port Expense Simulation Excution");
			break;
		case "6"://해당 작업이 진행 중 
			ComShowCodeMessage("COA00003", "Port Expense Simulation");
			break;
		default: break;							
		} 
        sheetObj.SetEtcData("BatchStatus","");
        chkYWM('',"1");	
        
		if (BatchStatus =="4"){
			clearSheet();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}        
        break;


	case IBCLEAR:          //조회
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value = INIT;

		var sXml = sheetObj.GetSearchData("ESM_COA_0040GS2.do", coaFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		
		//SJH.20150107.ADD
		formObj.f_yearM.value=ComGetNowInfo("yy")+ComGetNowInfo("mm").lpad(2, "0"); 
		formObj.f_yearW.value=ComGetEtcData(arrXml[0], "fYear")+ComGetEtcData(arrXml[0], "prevWeek"); 
		
		if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], f_selslane, "code", "name");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], f_selrlane, "code", "name");
		
		formObj.f_yearweek.value=ComGetMaskedValue(ComGetNowInfo("yy")+ComGetNowInfo("mm").lpad(2, "0"),"ym","-");
        document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";
        colChange();
		
		ComOpenWait(false);
		break;	

    case IBSEARCH:      //조회, SJH.20150107.MOD : 정리
        if(!validateForm(sheetObj,formObj,sAction)) return false;
        
		ComOpenWait(true);		
        formObj.f_cmd.value = SEARCHLIST01;
        sheetObj.DoSearch("ESM_COA_0040GS.do", coaFormQueryString(formObj));
        break;

    case IBSAVE:        //저장, SJH.20150107.MOD : 정리
        if(!validateForm(sheetObj,formObj,sAction)) return false;

		ComOpenWait(true);
		formObj.f_cmd.value = MULTI01;
		// PSO DATA중 0인 값을 COA로 SAVE하려는지 확인
		var pso_save_flag = true;
		//cre_usr_id가 Null인것은 IB Flag를 'I'로 강제 setting
		for(var i=sheetObj.HeaderRows();i<=(sheetObj.RowCount() + sheetObj.HeaderRows() -1);i++) {
			if (sheetObj.GetCellValue(i,"pso_cost_pso_ttl_amt") == 0 && sheetObj.GetCellValue(i,"chk_flag")==1 ) { // 0값이 존재하는 Port가 있으면 message를 뿌려준다.
				pso_save_flag = false;
				break;
			}
		}    	
		
		if (pso_save_flag){ // Save 해도 되면 
			// create status를 가진 것 중 check flag="Y" 인것을 찾아서 표시해준다.
			var chk_cnt = getCoaDataList(sheetObj);
			if (chk_cnt >0){   
				chk_msg = "Overwrite COA Data for "+chk_cnt+" VVDs?\n";
			  if (ComShowConfirm(chk_msg)){
				sheetObj.DoSave("ESM_COA_0040GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
			  }
			} else {
				sheetObj.DoSave("ESM_COA_0040GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
			}
		} else {
			ComShowMessage(ComGetMsg("COA10060"));
		}
                       
        ComOpenWait(false);
        break;
        
    case IBCOPYROW:        //SJH.20150206.ADD : PSO->COA COPY
        if(!validateForm(sheetObj,formObj,sAction)) return false;

		ComOpenWait(true);
		formObj.f_cmd.value = MULTI03;		
		sheetObj.DoSave("ESM_COA_0040GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);                       
        ComOpenWait(false);
        break;
     
    case IBDOWNEXCEL:        // Excell download
		var excelType=selectDownExcelMethod(sheetObj);
        break;
        
    case IBLOADEXCEL:                  // excell loading
        if(formObj.f_yrtype[1].checked) {
            ComShowMessage(ComGetMsg("COA10003", "Load Excel", "YYYY-MM"));
            return false;
        }
        
		//20150716.MOD/ADD/DEL
		sheetObj.SetWaitImageVisible(0);
    	sheetObj.RemoveAll();
    	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
    	
        //SJH.20141222.ADD : 토탈있는경우 제
        var lastRow=sheetObj.GetCellValue(sheetObj.LastRow()-1, "sYM");
        if(lastRow == "" || lastRow == "TOTAL") {
            sheetObj.RowDelete(sheetObj.LastRow()-1, false);
        }        
        break;
    }
    
}

//Sheet관련 프로세스 처리
function doActionIBSheet2(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);// Prohibit button click when a business transaction is processing  
    switch(sAction) {
        case IBSEARCH:      //조회
        case IBSEARCHAPPEND:    //조회
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            ComOpenWait(true);           
			
           	formObj.f_cmd.value = SEARCHLIST04;
           	if(sAction==IBSEARCH) {
           		var sRow=sheetObjects[0].GetSelectRow();
               	formObj.f_slan_cd2.value = sheetObjects[0].GetCellValue(sRow,"slan_cd");
               	formObj.f_vsl_cd2.value = sheetObjects[0].GetCellValue(sRow,"vsl_cd");
               	formObj.f_skd_voy_no2.value = sheetObjects[0].GetCellValue(sRow,"skd_voy_no");
               	formObj.f_dir_cd2.value = sheetObjects[0].GetCellValue(sRow,"skd_dir_cd");           		
           	}
           	var param = "&f_cmd=" + formObj.f_cmd.value + "&f_yrtype="+ComGetObjValue(formObj.f_yrtype)+"&f_yearweek="+formObj.f_yearweek.value.replace("-","")
           	          + "&f_slan_cd="+formObj.f_slan_cd2.value
        	          + "&f_vsl_cd="+formObj.f_vsl_cd2.value+"&f_skd_voy_no="+formObj.f_skd_voy_no2.value+"&f_dir_cd="+formObj.f_dir_cd2.value ;

           	var sXml = sheetObj.GetSearchData("ESM_COA_0040GS2.do", param);				
   			sheetObj.LoadSearchData(sXml,{Sync:1} );
   			
   			var pso_cre_dt = ComGetEtcData(sXml, "pso_cre_dt");		
   			formObj.f_rqst_dt.value = ComGetMaskedValue(pso_cre_dt,"ymd");
   			
   			ComOpenWait(false);
            break;
  
        case IBSAVE:  		//SJH.20150108.MOD   
			ComOpenWait(true);			
			
          	formObj.f_cmd.value = MULTI04;     						
			sheetObj.DoSave("ESM_COA_0040GS2.do", coaFormQueryString(formObj));

			ComOpenWait(false);
			
            break;
    }
}

/**
* Download Excel
*/
//SJH.20150108.ADD
function callBackExcelMethod(excelType) {	
	var sheetObj = sheetObjects[0];
	sheetObjects[0].Down2ExcelBuffer(true);
    switch (excelType) {
	    case "AY":
	    	sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetName:'sheet1', SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	    	sheetObjects[1].Down2Excel({ HiddenColumn:0, SheetName:'sheet2', SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	        break;
	    case "AN":
	    	sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetName:'sheet1', SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	    	sheetObjects[1].Down2Excel({ HiddenColumn:0, SheetName:'sheet2', SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	    	break;
	    case "DY":
	    	sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetName:'sheet1', SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	sheetObjects[1].Down2Excel({ HiddenColumn:1, SheetName:'sheet2', SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	    case "DN":
	    	sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetName:'sheet1', SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	sheetObjects[1].Down2Excel({ HiddenColumn:1, SheetName:'sheet2', SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	} 
    sheetObjects[0].Down2ExcelBuffer(false);  
}

/**
 * Handling process for form object input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(!chkValidSearch2()) return false;         
    }
    return true;
}
/**
 * Return validation results of the port, cy (From ESM_COA_5127)
 */
function isValidNode(result){
    var sheetObj=sheetObjects[0];
    if(!result){
        ComShowMessage(ComGetMsg("COM12114","Port, CY",""));
        sheetObj.SelectCell(sRow, "cy");
    }
}


/**
 * Handling process for form object input validation, Not used
 */
function Null_CheckForm(sheetObj,formObj,sAction){
    var rt=false;
    if(ComIsNull(sheetObj.GetCellValue(0 ,"locl_curr_cd"))) {
        ComShowMessage(ComGetMsg('COA10002', 'locl_curr_cd'));
        ComSetFocus(formObj.locl_curr_cd);
        rt=false;
    } else {
        rt=true;
    }
    return rt;
}

function ComAddSeparator_Local(obj, sFormat) {
    try {
        obj.value=obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
    } catch(err) { ComFuncErrMsg(err.message); }
}


/* 
   다시한번 동일 주차에 대해 재Creation 이후 혹은 재Creation 없이 전체 save
   하고자 할경우에는 메뉴얼로 수정/저장 되어 PSO금액과 다른 COA 저장값이 
   존재한다는 것을 POP-UP 창으로 알려주어 User가 인식하게끔 해준다.      
*/
function getCoaDataList(sheetObj){
	var check_flag;
	var tariff_sts;
	var rtn_msg="";
    var rtn_cnt = 0;
	for(var i=sheetObj.HeaderRows();i <(sheetObj.SearchRows()+sheetObj.HeaderRows());i++) {
		check_flag = sheetObj.GetCellValue(i,"chk_flag");
		tariff_sts = sheetObj.GetCellValue(i,"cost_sts");
		
		if (check_flag == 1 && tariff_sts == "C"){
			rtn_cnt++;
		}
	}
	return rtn_cnt;
}

function checkCreate(sheetObject) {
	var rtValue = true;
	if(sheetObject.RowCount()<1) {//조회를 하지 않은 경우
		ComShowMessage(ComGetMsg('COA10005', 'Target VVD')); 
		rtValue = false;
	} else if(sheetObject.CheckedRows("chk_flag")<1){//체크박스 선택 안한경우
		ComShowMessage(ComGetMsg('COA10015', 'Target VVD')); 
		rtValue = false;
	}
	return rtValue;
}

/* shee2 search end*/
function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    sheetObj.SetSumText(0,0,"");
    sheetObj.SetSumText(0,"port_cd","TOTAL");
       
    for(var i=sheetObj.HeaderRows();i<=(sheetObj.RowCount() + sheetObj.HeaderRows() -1);i++) {
		sheetObj.SetCellEditable(i, "port_usd_amt", 1);      		
    }
    sheetObj.FitColWidth();
}

/* shee2 save end*/
function sheet2_OnSaveEnd(sheetObj, ErrMsg){
	if(document.form.f_cmd.value==MULTI04){
	    if(ErrMsg == ""){
	        // [COM130102] : Success
	    	ComShowMessage(ComGetMsg("COM130102","Data"));
	    }else{
	        ComShowMessage(ComGetMsg("COM132101"));
	    }
	    doActionIBSheet2(sheetObjects[1],document.form, IBSEARCHAPPEND);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}	
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[1]);
}
//SJH.20150108.ADD
function clearSheet() {
	var formObj=document.form;
	sheet1.RemoveAll();
	sheet2.RemoveAll();
	formObj.f_slan_cd2.value="";
	formObj.f_vsl_cd2.value="";
	formObj.f_skd_voy_no2.value="";
	formObj.f_dir_cd2.value="";
	formObj.f_rqst_dt.value="";	
}

/* SJH..20150206.ADD
 * shee1 save end*/
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	if(document.form.f_cmd.value==MULTI03){
	    if(ErrMsg == ""){
	        // [COM130102] : Success
	    	ComShowMessage(ComGetMsg("COA10006"));
	    }else{
	        ComShowMessage(ComGetMsg("COM132101"));
	    }
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}	
}