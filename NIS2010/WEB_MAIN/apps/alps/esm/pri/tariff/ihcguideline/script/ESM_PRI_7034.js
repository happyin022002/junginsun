/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7034.js
 *@FileTitle : Inland add-on inquiry in local currency (TRO)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.11.19
 *@LastModifier : 서미진
 *@LastVersion : 1.0
=========================================================
* History                                                                                               
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

function ESM_PRI_7034() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
	this.setTabObject = setTabObject;
}

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

document.onclick = processButtonClick;

function processButtonClick() {
	var form = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_new":
			doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
			break;
			
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
			
		case "btn_pnt_loc_cd" :
		case "btn_bse_port_loc_cd" :
			 var sUrl = "/hanjin/ESM_PRI_4026.do?";
             sUrl += "group_cmd=" + PRI_SP_SCP;
             sUrl += "&location_cmd=L";
             sUrl += "&svc_scp_cd=" + form.svc_scp_cd.Code;
             var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
             if (rtnVal != null){
                 if(srcName == "btn_pnt_loc_cd") {
                     form.pnt_loc_cd.value = rtnVal.cd;
                 }else if(srcName == "btn_bse_port_loc_cd"){
                     form.bse_port_loc_cd.value = rtnVal.cd;
                 }
             }
             break;
             
        case "btn_calendar": 
        	if(!document.getElementById(srcName).disabled){
                var cal = new ComCalendar();                
                cal.select(document.form.acc_dt, 'yyyy-MM-dd');
        	}
            break; 
            
        case "btn_down_excel":    
        	doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
            break;
		}
	} catch (e) {

	}
}

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * IBTab Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setTabObject(tab_obj);
 * </pre>
 * @param {ibtab} tab_obj 필수 IBTab Object
 * @return 없음
 * @author 공백진
 * @version 2012.04.17
 */        
 function setTabObject(tab_obj) {
     tabObjects[tabCnt++] = tab_obj;
 }
 
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	// loading 시 In bound 선택하도록 셋팅
	comboObjects[0].Code = 'D' ;
	initControl();
	document.form.acc_dt.value = ComGetNowInfo();
}


function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	 case "sheet1":
         with (sheetObj) {
             // 높이 설정
             style.height = 450;
             //전체 너비 설정
             SheetWidth = mainTable.clientWidth;              

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
             Editable = false;

             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]  
             InitRowInfo( 3, 1, 20, 100);
 
				var HeadTitle1 = "ibflag|Seq|RTSeq|Point|Description|Rail\nHub|Base\nPort|Term|Trans\nMode|Tariff (USD)|Tariff (USD)|Tariff (USD)|Tariff (USD)|Tariff (USD)|Tariff (USD)|" +
									 "Total Cost (USD)|Total Cost (USD)|Total Cost (USD)|Total Cost (USD)|Total Cost (USD)|Total Cost (USD)|M/B Ratio\n(%, in SCC)|M/B Ratio (%, in SCC)|" +
									 "IHC_TRF_NO|AMDT_SEQ|SVC_SCP_CD|ORG_DEST_TP_CD";  
				var HeadTitle2 = "ibflag|Seq|RTSeq|Point|Description|Rail\nHub|Base\nPort|Term|Trans\nMode|" +
									 "Rail|Rail|Truck|Truck|Total|Total|Rail|Rail|Truck|Truck|Total|Total|M/B Ratio\n(%, in SCC)|M/B Ratio (%, in SCC)|" +
									 "IHC_TRF_NO|AMDT_SEQ|SVC_SCP_CD|ORG_DEST_TP_CD";  		
				var HeadTitle3 = "ibflag|Seq|RTSeq|Point|Description|Rail\nHub|Base\nPort|Term|Trans\nMode|" +
									 "20'|40'|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'|" +
									 "IHC_TRF_NO|AMDT_SEQ|SVC_SCP_CD|ORG_DEST_TP_CD";   

             var headCount = ComCountHeadTitle(HeadTitle1);
			
             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(headCount, 0 , 0, true);
		
             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(false, true, true, true, false, false);           
	
             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  dtHiddenStatus
             InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                                                               
			 InitHeadRow(1, HeadTitle2, true);  
             InitHeadRow(2, HeadTitle3, true);

             //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             InitDataProperty(0, cnt++, 	dtHiddenStatus,	30, 		daCenter, 	true, 	"ibflag"); 
             InitDataProperty(0, cnt++, 	dtDataSeq,   		40,    		daCenter,  	true,  	"Seq");       
             InitDataProperty(0, cnt++, 	dtHidden,    		40,    		daCenter,  	true,  	"rt_seq", false, "", dfNone, 0, false, false);        
             InitDataProperty(0, cnt++, 	dtData, 			50, 		daCenter, 	true, 	"pnt_loc_cd", false, "", dfNone, 0, false, false);                                       
             InitDataProperty(0, cnt++, 	dtData, 			120, 		daLeft,	 		true, 	"pnt_loc_nm", false, "", dfNone, 0, false, false);                                 
             InitDataProperty(0, cnt++, 	dtData, 			50, 		daCenter, 	true, 	"hub_loc_cd", false, "", dfNone, 0, false, false);                     
             InitDataProperty(0, cnt++, 	dtData, 			50, 		daCenter, 	true, 	"bse_port_loc_cd", false, "", dfNone, 0, false, false);       
             InitDataProperty(0, cnt++, 	dtCombo, 		70, 		daCenter, 	true, 	"rcv_de_term_cd", false, "", dfNone, 0, false, false);   
             InitDataProperty(0, cnt++, 	dtCombo,			80, 		daCenter, 	true, 	"prc_trsp_mod_cd", false, "", dfNone, 0, false, false);     
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"gline_20ft_rail_frt_rt_amt", false, "", dfFloat, 2, false, false, 9);
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"gline_40ft_rail_frt_rt_amt", false, "", dfFloat, 2, false, false, 9);
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"gline_20ft_trk_frt_rt_amt", false, "", dfFloat, 2, false, false, 9);
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"gline_40ft_trk_frt_rt_amt", false, "", dfFloat, 2, false, false, 9);
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"gline_20ft_frt_rt_amt", false, "", dfFloat, 2, false, false, 9);
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"gline_40ft_frt_rt_amt", false, "", dfFloat, 2, false, false, 9);   
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"cost_20ft_rail_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"cost_40ft_rail_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);  
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"cost_20ft_trk_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"cost_40ft_trk_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9); 
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"cost_20ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"cost_40ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9); 
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"mb_20ft_rto", false, "", dfNullFloat, 2, false, false, 9);                            
             InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"mb_40ft_rto", false, "", dfNullFloat, 2, false, false, 9);
             InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"ihc_trf_no", false, "", dfNone, 0, false, false); 
             InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"amdt_seq", false, "", dfNone, 0, false, false); 
             InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"svc_scp_cd", false, "", dfNone, 0, false, false);          
             InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"org_dest_tp_cd", false, "", dfNone, 0, false, false); 
             InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);      
             InitDataCombo(0, "rcv_de_term_cd", termCdText, termCdValue);     
             sheetObj.SetMergeCell (0, 21, 2, 2);  
             WaitImageVisible = false;  
             Ellipsis = true;
 		}
         break;
	}
}

function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "svc_scp_cd":
		with (comboObj) {
			DropHeight = 260;
			MultiSelect = false;
			MaxSelect = 1;
			UseAutoComplete = true;
			MaxLength = 3;
			IMEMode = 0;
			ValidChar(2, 0);
			SetColWidth("50|350");
		}
		break;
		
	case "org_dest_tp_cd" :	
        var i = 0;
        with (comboObj) {
			DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
			MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
			MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
			UseAutoComplete = true;  
            InsertItem(i++, "In bound", "D");
			InsertItem(i++, "Out bound", "O");
        }
        break;
        
	case "rcv_de_term_cd":
		var i = 0;
		with (comboObj) {
			DropHeight = 260;
			MultiSelect = false;
			MaxSelect = 1;
			UseAutoComplete = true;
			IMEMode = 0;
            InsertItem(i++, "", "");
			InsertItem(i++, "CY", "Y");
			InsertItem(i++, "Door", "D");
		}
		break;
	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		case IBSEARCH:    // retrieve sheet 
            if (!validateForm(sheetObjects[0],document.form,sAction)) {
                return false;
            }  
        	ComOpenWait(true); //->waiting->start
 			formObj.f_cmd.value = SEARCH01;	 			
 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7034GS.do", FormQueryString(formObj));	 	 	 
 			sheetObj.LoadSearchXml(sXml);	
 			ComOpenWait(false); //->waiting->End
            break;
			
		case IBCREATE :
			sheetObj.RemoveAll();
			formObj.reset();
			comboObjects[0].Index = 0 ;
			comboObjects[1].Index = -1 ;
			comboObjects[2].Index = 0 ;
			document.form.acc_dt.value = ComGetNowInfo();
			formObj.svc_scp_cd.focus();
			break;
			
		case IBDOWNEXCEL:
			sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
			break;
		}	
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false);
	}
}

function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if(comboObjects[0].Code == '') {
			ComShowCodeMessage("COM130403", "In/Out");
			return false;
		}

		if(comboObjects[1].Code == '') {
			ComShowCodeMessage("COM130403", "Service Scope");
			return false;
		}
		
		if(formObj.acc_dt.value == '') {
			ComShowCodeMessage("COM130403", "Access Date");
			formObj.acc_dt.focus();
			return false;
		}
		
		if(!ComChkValid(formObj)) {
			return false;
		}
		break;
	}
	return true;
}

/**
 * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *     initControl()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 공백진
 * @version 2012.04.17
 */    
 function initControl() {
	        //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
	    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	 }

/**
 * Onbeforedeactivate  event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_deactivate()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 공백진
 * @version 2012.04.17
 */        
function obj_deactivate() {
   var formObj = document.form;
   var sheetObj = sheetObjects[0]; 
   var eleName = event.srcElement.name;

   switch(eleName){
	      case "acc_dt":
		      ComChkObjValid(event.srcElement);   
		      break;
   }        
}  

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author 서미진
 * @version 2010.11.01
 */
function org_dest_tp_cd_OnChange(comboObj, code, text) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH25;
	// RHQ_CD 는 JSP 에 코딩해놨음
	formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD   
	var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");     
	formObj.svc_scp_cd.focus();
}
