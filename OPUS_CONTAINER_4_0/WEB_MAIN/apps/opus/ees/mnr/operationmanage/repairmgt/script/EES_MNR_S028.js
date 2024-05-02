/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S028.js
*@FileTitle  : M&R Repair Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운  
 */ 
/**	 	
 * @extends   
 * @class EES_MNR_S028 : EES_MNR_S028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */ 
/* 개발자 작업	*/ 	
//공통전역변수   fds
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0; 
var tpmWoType="";
//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_calendar":          
			var cal=new ComCalendarFromTo();
			cal.select(formObject.fm_est_dt, formObject.to_est_dt, 'yyyy-MM-dd');
			break;
		case "btn_Print":	
			if(sheetObjects[1].RowCount()== 0){
				ComShowCodeMessage("MNR00310"); 			
			} else {
				//있다면  RD 호출
				if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd")) != '' && sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq") != ''){
					var mnr_ord_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq");
					var mnr_ord_ofc_cty_cd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd");
					var user_nm=formObject.user_nm.value;    
					var rdParam='/rv mnr_ord_ofc_cty_cd['+ mnr_ord_ofc_cty_cd +'] mnr_ord_seq[' + mnr_ord_seq + '] user_nm[' + user_nm + ']';
					if(wo_type.GetSelectCode()== 'SPL'){
						formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0183.mrd';
						formObject.com_mrdBodyTitle.value="Simple Work Order";
					} else if(wo_type.GetSelectCode()== "EXT"){
						formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0187.mrd';
						formObject.com_mrdBodyTitle.value="Extra Work Order";
					} else if(wo_type.GetSelectCode()== "RFS"){
						formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0231.mrd';
						formObject.com_mrdBodyTitle.value="Reefer Spare Part Work Order";					
					} else {  	
						formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0182.mrd';
						formObject.com_mrdBodyTitle.value="Repair Work Order";
					} 				
					formObject.com_mrdArguments.value=rdParam;
					ComOpenRDPopup();
				} else {		
					var eqno=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rqst_eq_no");
					var seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_seq");
					var verNo=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_ver_no");
					formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0181.mrd';
					var rdParam='/rv rqst_eq_no[' + eqno + '] rpr_rqst_seq[' + seq + '] rpr_rqst_ver_no[' + verNo + '] is_tpb[N]';
					formObject.com_mrdArguments.value=rdParam;
					formObject.com_mrdBodyTitle.value="Repair Estimate";
					ComOpenRDPopup();
				}					
			}	
			break; 
		case "btn_New": 
			doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
			break;
		case "btn_DownExcel": 
			if(sheetObjects[1].RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
				}

 			
			break;		
		case "btn_Retrieve": 
			doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
			break;
		case "btn_Detail":	 
			if(sheetObjects[1].RowCount()== 0){
				ComShowCodeMessage("MNR00309");			
			} else {
				//견적서 팝업 호출 
				if(wo_type.GetSelectCode()== 'EST'){
					if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rqst_eq_no")) != ''){
						var rqstEqNo=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rqst_eq_no");
						var rprRqstSeq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_seq");
						rprRqstVerNo=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_ver_no");
						var eqKndCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"eq_knd_cd");
						ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd+"&spp_type=Y", 1024, 768, '', '0,0', false);   		
					}    			
				} else {
					//work order 팝업호출    
					var mnrOrdOfcCtyCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd");
					var mnrOrdSeq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq");
					var costOfcCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"cost_ofc_cd");
					retArray=MnrGeneralCodeCheck(sheetObjects[0],"WORKORD",mnrOrdOfcCtyCd + "," + mnrOrdSeq);      
					if(retArray == null){                   
						ComShowCodeMessage("MNR00165","This Work Order : " + mnrOrdOfcCtyCd + mnrOrdSeq);       				
						return;       
					}  
					if(wo_type.GetSelectCode()== 'SPL'){
						if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd")) != ''
							&& MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq")) != ''){
							ComOpenPopup('EES_MNR_0226.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 670, '', '0,0', true);   
						}   
					} else if(wo_type.GetSelectCode()== 'EXT'){
						if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd")) != ''
							&& MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq")) != ''){
							ComOpenPopup('EES_MNR_0227.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 530, '', '0,0', true);   
						}    
					} else if(wo_type.GetSelectCode()== 'RFS'){
						if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd")) != ''
							&& MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq")) != ''){
							ComOpenPopup('EES_MNR_0228.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 500, '', '0,0', true);   
						}    
					}
				}  
			}	
			break;
			//멀티입력
		case "eq_no_multi1":  
			rep_Multiful_inquiry("rqst_eq_no"); 
			break;	
			//멀티입력
		case "eq_no_multi2": 
			if(wo_type.GetSelectCode()== 'EST'){
				rep_Multiful_inquiry("rqst_ref_no"); 
			}      
			break; 	
			//멀티입력
		case "eq_no_multi3": 
			rep_Multiful_inquiry("wo_no"); 
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	MnrWaitControl(true);
	initControl();
	for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i + 1);
        //khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++){ 
		initCombo(comboObjects[k],k + 1);   
	} 	   
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetObj.id) { 
	case "sheet1": 		
		with (sheetObj) {
			SetVisible(false);
		}	
		break;
	case "sheet2":      // sheet1 init
	    with(sheetObj){
//		      (26	, 0, 0, true);
		      var HeadTitle1="|Sel.|Seq.|Service Provider|EQ No.|T/S|Est Date|Estimate No.|Curr|Est Amount|System Verify Result|DMG Flag|TPB|W/O No|W/O Issue DT|W/O Send Method|Send Dt|Invoice No|Invoice Amount|Status|Remark(s)";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		             {Type:"Text",      Hidden:1, Width:160,  Align:"Left",    ColMerge:0,   SaveName:"vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rqst_eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"est_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:"rqst_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"total_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"mnr_vrfy_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dmg_flag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"wo_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"iss_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"trsm_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mnr_ord_snd_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"inv_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"status",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"ord_hdr_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_ver_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_ord_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_ord_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(1);
		      SetSheetHeight(360);
            }
		break;
	}
}
// Sheet관련 프로세스 처리 
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {	
	case IBSEARCH:      //목록조회    
		if(validateForm(sheetObj,formObj,sAction)){    
			formObj.f_cmd.value=SEARCH;  
			if(formObj.temp_tpb_only.checked){
				formObj.tpb_only.value="Y"; 
			} else {
				formObj.tpb_only.value="N";  
			}  
			var sParam=FormQueryString(formObj);
 			sheetObj.DoSearch("EES_MNR_S028GS.do",sParam );
		} 	        
		break; 
	case IBCLEAR:      // 초기화 
		MnrWaitControl(true);
		sheetObj.SetWaitImageVisible(0);
		//START 
		formObj.reset(); 
		//콤보 초기화	  
		for(var i=0; i < comboObjects.length;i++){ 
			comboObjects[i].SetSelectCode("-1");
			comboObjects[i].RemoveAll();
		}	
		var sCondition=new Array (		 		 
			//MultiCombo  
			new Array("MnrGenCd","CD00020", "COMMON"),
			new Array("MnrGenCd","","CUSTOM9"),
			//쉬트 콤보 
			new Array("MnrGenCd","CD00082", "COMMON"),    	
			new Array("MnrGenCd","CD00004", "COMMON"), 
			new Array("MnrGenCd","CD00016", "COMMON")  	    
		)		 			
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		//*** W/O Type		
		var comboDefValue=""; 	
		if(comboList[0] != null){ 	       
			for(var j=0; j < comboList[0].length;j++){ 
				var tempText=comboList[0][j].split("|");  
				wo_type.InsertItem(j, tempText[1] ,tempText[0]);
				if(j == 0){	 	
					comboDefValue=tempText[0];  
				}	  	 		 
			}     			  	    
		}  		
		wo_type.SetSelectCode(comboDefValue);
		//*** EQ_TYPE	
		if(comboList[1] != null){	
			eq_knd_cd.InsertItem(0, 'ALL' ,'A');        
			for(var j=1; j < comboList[1].length + 1;j++){ 
				var tempText=comboList[1][j - 1].split("|");	  
				eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
			}				    
		} 
		eq_knd_cd.SetSelectCode('A');
		var sheetComboText="";  
		var sheetComboCode="";
		var sheetComboDefault=new Array();
		var comboSaveNames=new Array(); 
		comboSaveNames[0]="status";
		comboSaveNames[1]="mnr_vrfy_tp_cd"; 
		comboSaveNames[2]="trsm_mod_cd";          
		for(var i=2; i < comboList.length;i++){
		 	if(comboList[i] != null){
				sheetComboText=""; 
				sheetComboCode="";	
				sheetComboDefault=""; 
		 		for(var j=0; j < comboList[i].length;j++){ 
					var tempText=comboList[i][j].split("|");    
					sheetComboText +=  tempText[1] + "|";  
					sheetComboCode +=  tempText[0] + "|";  
					if(j == 0){
						sheetComboDefault[i - 2]=tempText[0];           	
					} 		   
				}		
				sheetComboCode=MnrDelLastDelim(sheetComboCode); 																				
		     	sheetComboText=MnrDelLastDelim(sheetComboText);  	
				sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 2], sheetComboText, sheetComboCode ,sheetComboDefault[i - 2]); 
			}				      
		}
		//기본 초기값 
		formObj.vndr_seq.value=strVndrSeq;
		formObj.fm_est_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "D", -7);
		formObj.to_est_dt.value=ComGetNowInfo("ymd");  
		//END 
		sheetObj.SetWaitImageVisible(1);
		MnrWaitControl(false);  
		break;
	}
}
/**  
 * IBCombo Object를 배열로 등록
 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj){	     
	comboObjects[comboCnt++]=combo_obj;  
} 
/**   
 * Combo 기본 설정    
 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */     
function initCombo (comboObj, comboNo) {   
	var formObject=document.form
	switch(comboNo) {      
	default :   
		with (comboObj) { 
		SetColAlign(0, "left");
		SetDropHeight(200);
	}   	   
	break;	 	
	} 		
} 
/** 
 * rep_Multiful_inquiry의 리턴처리 메서드
 * @param	{Array}		rowArray	반환되는 Array
 * @param	{String}	return_val	반환되는 form element명
 */
function getMnr_Multi(rowArray,ret_val) { 
	var formObj=document.form; 	 
	var tempText="";       
	//초기화     
	eval("document.form." + ret_val + ".value='';"); 
	for(var i=0; i < rowArray.length; i++) {     
		tempText +=  rowArray[i] + ',';      
	}     
	//마지막에 ,를 없애기 위함      
	tempText=MnrDelLastDelim(tempText);		
	eval("document.form." + ret_val + ".value='" + tempText + "';"); 
} 
function sheet2_OnDblClick(sheetObj,Row,Col){
		var formObj=document.form;       
		if(wo_type.GetSelectCode()== 'EST'){
			if(MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"rqst_eq_no")) != ''){
				//있다면 팝업호출 
				var rqstEqNo=sheetObjects[1].GetCellValue(Row,"rqst_eq_no");
				var rprRqstSeq=sheetObjects[1].GetCellValue(Row,"rpr_rqst_seq");
				var rprRqstVerNo=sheetObjects[1].GetCellValue(Row,"rpr_rqst_ver_no");
				var eqKndCd=sheetObjects[1].GetCellValue(Row,"eq_knd_cd");
				ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd+"&spp_type=Y", 1024, 768, '', '0,0', false);   		
			}  		 			
		} else { 
			//work order 팝업호출    
			var mnrOrdOfcCtyCd=sheetObjects[1].GetCellValue(Row,"mnr_ord_ofc_cty_cd");
			var mnrOrdSeq=sheetObjects[1].GetCellValue(Row,"mnr_ord_seq");
			retArray=MnrGeneralCodeCheck(sheetObjects[0],"WORKORD",mnrOrdOfcCtyCd + "," + mnrOrdSeq);
			if(retArray == null){                   
				ComShowCodeMessage("MNR00165","This Work Order : " + mnrOrdOfcCtyCd + mnrOrdSeq);       				
				return;       
			} 
			if(wo_type.GetSelectCode()== 'SPL'){
				if(MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0226.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 670, '', '0,0', true);   
				}    
			}else if(wo_type.GetSelectCode()== 'EXT'){
				if(MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0227.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 530, '', '0,0', true);   
				}     
			}else if(wo_type.GetSelectCode()== 'RFS'){
				if(MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0228.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 500, '', '0,0', true);   
				}    
			}
		}  	
	}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){ 	       
		switch(sAction) { 	 
		case IBSEARCH:
			if (!ComChkValid(formObj)) return false;
			var arrWoNo=formObj.wo_no.value.split(",");
			if(arrWoNo!=""){
				for(i=0;i<arrWoNo.length;i++){
					if(isNaN(arrWoNo[i].substr(3)) || arrWoNo[i].substr(3)==""){
						ComShowCodeMessage("MNR00010","W/O No");
						return false;
					}
				}
			}
			break;	
		}   
	}
	return true;
}
function resetCombo3(type,formObj){ 
	status_cd.RemoveAll(); 
	status_cd.SetDropHeight(200);
	var sCondition=new Array ( 
			new Array("MnrGenCd","CD00082", "COMMON")
	)	
	var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
	if(comboList[0] != null){ 	
		status_cd.InsertItem(0,"ALL","ALL");   
		if(type == "EST"){    
			for(var j=0; j < comboList[0].length;j++){ 
				var tempText=comboList[0][j].split("|");
				status_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);  	
			}        			  	    
		} else {
			var tempCnt=1;
			for(var j=0; j < comboList[0].length;j++){  
				var tempText=comboList[0][j].split("|");    
				if(tempText[0].substring(0,1) != 'H' && tempText[0].substring(0,1) != 'S'){  
					status_cd.InsertItem(tempCnt, tempText[1] ,tempText[0]);    
					tempCnt++;  
				} 
			}   	         			  	    
		}
		status_cd.SetSelectCode("ALL");
	}
}	
//콤보 이벤트  					
function wo_type_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
	var formObj=document.form;		 		         
	sheetObjects[1].RemoveAll();
	resetCombo3(comboObj.GetSelectCode(),formObj);
	if(comboObj.GetSelectCode()== 'EST'){
//		sheetObjects[1].ReturnColumn();
		sheetObjects[1].SetColHidden("rqst_eq_no",0);
		sheetObjects[1].SetColHidden("eq_tpsz_cd",0);
		sheetObjects[1].SetColHidden("est_dt",0);
		sheetObjects[1].SetColHidden("rqst_ref_no",0);
		sheetObjects[1].SetColHidden("curr_cd",0);
		sheetObjects[1].SetColHidden("total_amt",0);
		sheetObjects[1].SetColHidden("mnr_vrfy_tp_cd",0);
		sheetObjects[1].SetColHidden("dmg_flag",0);
		sheetObjects[1].SetColHidden("n3pty_flg",0);
		ComSetObjValue(formObj.rqst_ref_no,""); 	
		MnrFormSetReadOnly(formObj,false,"rqst_ref_no");  	
	} else {           
		sheetObjects[1].SetColHidden("rqst_eq_no",1);
		sheetObjects[1].SetColHidden("eq_tpsz_cd",1);
		sheetObjects[1].SetColHidden("est_dt",1);
		sheetObjects[1].SetColHidden("rqst_ref_no",1);
		//sheetObjects[1].ColHidden("curr_cd") = true; 		
		sheetObjects[1].SetColHidden("total_amt",1);
		sheetObjects[1].SetColHidden("mnr_vrfy_tp_cd",1);
		sheetObjects[1].SetColHidden("dmg_flag",1);
		sheetObjects[1].SetColHidden("n3pty_flg",1);
		ComSetObjValue(formObj.rqst_ref_no,"");  
		MnrFormSetReadOnly(formObj,true,"rqst_ref_no");  	
		//wo_type변경시  Curr컬럼 이동
		if(tpmWoType == 'EST'){
			sheetObjects[1].MoveColumnPos("curr_cd", "inv_no");
		}		
	}  
	tpmWoType=comboObj.GetSelectCode();
}    
function initControl() {        
	//Axon 이벤트 처리1. 이벤트catch  
	var formObject=document.form;       
	axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
//	axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
}             
//Axon 이벤트 처리2. 이벤트처리함수   
function obj_deactivate(){      
	ComChkObjValid(event.srcElement); 
} 
function obj_activate(){   
	ComClearSeparator(event.srcElement);
}        
function obj_keypress(){   
	obj=event.srcElement;    
	if(obj.dataformat == null) return; 
	window.defaultStatus=obj.dataformat;
	switch(obj.dataformat) {   
	case "ymd":   
	case "int":       
		ComKeyOnlyNumber(obj); 
		break;     
	case "float":    
		ComKeyOnlyNumber(obj, "-.");
		break; 
	case "eng":    
		ComKeyOnlyAlphabet();
		break;   
	case "engup":  
		ComKeyOnlyAlphabet('uppernum','44');	
		break; 
	}         
}
/* 개발자 작업  끝 */
