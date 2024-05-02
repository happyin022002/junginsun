/*=======================================================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : VOP_OPF_9401.js
 *@FileTitle : Port Time Performance Dashboard Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.06.08
 *@LastModifier :
 *@LastVersion : 1.0
 * 2012.06.08
 * 1.0 Creation
 * 2012.06.08 허철용 [CHM-201217512-01] PTRP 화면에 Dashboard 기능 추가
 * 2012.07.11 문동선 [CHM-201218855-01] Base line 입력화면 추가 / Dashboard에 반영
========================================================================================*/

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
 * @class VOP_OPF_9401 : VOP_OPF_9401 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_OPF_9401() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var chartData = '';

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

			case "btn_save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
	            break;

			case "btn_print":
				var msg = "/rdata [~";
				msg += chartData;
				msg += "~";
				msg += "//EOR//~";
				
				for(var i=sheetObj.HeaderRows; i<sheetObj.RowCount+sheetObj.HeaderRows; i++) {
					msg +=  sheetObj.CellValue(i, "vvd") + "@";
					msg +=  sheetObj.CellValue(i, "vvd_rmk") + "@";
					msg +=  sheetObj.CellValue(i, "vvd_rhq_rmk") + "@~";
				}

				msg += "] /rnl [~]";
				
				msg += " /rv condition [";
				msg += "Duration : " + formObj.fr_dt.value + "~" + formObj.to_dt.value + "        ";
				msg += "Port : " + formObj.port_cd.value + "        ";
				msg += "Lane : " + formObj.slan_cd.value;
				msg += "] title [Port Time Performance Dashboard Report] ";

				var strPath = "";
				strPath = "apps/alps/vop/opf/porttimeperformancemgt/porttimeperformancemgt/report/VOP_OPF_1401.mrd";
				
				formObj.rdViewer.FileOpen(RD_path+strPath, msg);
				formObj.rdViewer.CMPrint();
				
	            break;

			case "btn_close":
				window.close();
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Calendar From To 선택 후 호출하는 함수
 */
function cal_end_func(){
	sheetObjects[0].RemoveAll();
}

/**
* IBSheet Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* Sheet 기본 설정 및 초기화
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	document.form.fr_dt.value           = s_fr_dt;
	document.form.to_dt.value           = s_to_dt;
	document.form.kpi_tgt_yr.value      = s_kpi_tgt_yr;
	document.form.kpi_ver_seq.value     = s_kpi_ver_seq;
	document.form.rhq_ofc_cd.value      = v_rhq;
	document.form.port_cd.value         = v_vps_port_cd;
	document.form.slan_cd.value         = v_slan_cd;
	document.form.port_kpi_dir_cd.value = v_port_kpi_dir_cd;
	document.form.clpt_ind_seq.value    = v_clpt_ind_seq;
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
* 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
* {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {int}     sheetNo     sheetObjects 배열에서 순번
**/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;

	//Axon 이벤트 처리1. 이벤트 catch
	axon_event.addListenerFormat('beforedeactivate'	, 'obj_deactivate'	, formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  	, 'obj_activate'  	, formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  	, formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerFormat('keyup'           	, 'obj_keyup'     	, formObj);
}

/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID)
	{
		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 140;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				var HeadTitle  = "|VVD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|VPS_PORT_CD|CLPT_IND_SEQ|RHQ_CD|SLAN_CD|Remarks (BBO)|Remarks (RHQ)";

				var headCount = ComCountHeadTitle(HeadTitle);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle , true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//				InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, false, 	"ibflag");
				InitDataProperty(0, cnt++, dtHiddenStatus,  10, daCenter, false, 	"ibflag");
				InitDataProperty(0, cnt++, dtData        ,  80, daCenter, false, 	"vvd"			, false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      ,  10, daCenter, false, 	"vsl_cd"		, false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      ,  10, daCenter, false, 	"skd_voy_no"    , false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden	     ,  10, daCenter, false, 	"skd_dir_cd"   	, false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      ,  10, daCenter, false, 	"vps_port_cd"   , false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      ,  10, daCenter, false, 	"clpt_ind_seq"  , false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      ,  10, daCenter, false, 	"rhq_cd"		, false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      ,  10, daCenter, false, 	"slan_cd"       , false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData  	     , 450, daLeft  , false,	"vvd_rmk"       , false, "", dfNone, 0, true , true,	4000,	false,	true,	"",	false,	"IU" );
				InitDataProperty(0, cnt++, dtData  	     ,  20, daLeft  , false,	"vvd_rhq_rmk"   , false, "", dfNone, 0, true , true,	4000,	false,	true,	"",	false,	"IU" );
		
				WaitImageVisible=false;
			}
			break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			sheetObjects[0].WaitImageVisible=false;
			sheetObj.Redraw = false;
			ComOpenWait(true);

			var sXml = sheetObj.GetSearchXml("VOP_OPF_9401GS.do", FormQueryString(formObj));
			
			var arrXml = sXml.split("|$$|");
			// ------------------------------------------------------------
			// RD Chart 구성 데이터 생성
			// ------------------------------------------------------------
			if (arrXml.length > 0) {
				var list = SheetXml2ListMap(arrXml[0]);
				var msg = "/rdata [~";
				var graphVO;
				
				if(list.length > 0) {
					
					var row;
					chartData = "";		//차트데이터 초기화
					
					var baselineData = doActionIBSheet(sheetObj, formObj, "IBSEARCH02"); //Baseline 데이터 
					if(baselineData != ""){
						chartData += baselineData;	
					}				
					
					for (var i=0; i<list.length; i++) {
						graphVO = list[i];
						chartData += graphVO["vvd_cd"] + "@";
						chartData += graphVO["steam_in_time"] + "@";
						chartData += graphVO["arrival_time"] + "@";
						chartData += graphVO["operation_time_t"] + "@";
						chartData += graphVO["departure_time"] + "@";
						chartData += graphVO["gross_crane_prod"] + "@";
						
						if(i < list.length -1)
							chartData += "~";

						// VVD Remark Grid Setting
						if(graphVO["vvd_cd"] != "YTD AVG" && graphVO["vvd_cd"] != "KPI")
						{
							row = sheetObj.DataInsert(-1);

							sheetObj.CellValue2(row, "vvd"         ) = graphVO["vvd_cd"];
							sheetObj.CellValue2(row, "vsl_cd"      ) = graphVO["vvd_cd"].substr(0,4);
							sheetObj.CellValue2(row, "skd_voy_no"  ) = graphVO["vvd_cd"].substr(4,4);
							sheetObj.CellValue2(row, "skd_dir_cd"  ) = graphVO["skd_dir_cd"];
							sheetObj.CellValue2(row, "vps_port_cd" ) = graphVO["port_cd"];
							sheetObj.CellValue2(row, "clpt_ind_seq") = graphVO["clpt_ind_seq"];
							sheetObj.CellValue2(row, "rhq_cd"      ) = graphVO["rhq"];
							sheetObj.CellValue2(row, "slan_cd"     ) = graphVO["slan_cd"];
						}
					}
					
					msg += chartData + "~";
					
					//VVD Remark 내용을 보이지 않기위함
					msg += "//EOR//~";
					msg += "@@~";
					
					msg += "] /rnl [~]";
					
					msg += " /rv condition [";
					msg += "Duration : " + formObj.fr_dt.value + "~" + formObj.to_dt.value + "        ";
					msg += "Port : " + formObj.port_cd.value + "        ";
					msg += "Lane : " + formObj.slan_cd.value;
					msg += "] title [Port Time Performance Dashboard Report] ";
					
					var strPath = "";
					strPath = "apps/alps/vop/opf/porttimeperformancemgt/porttimeperformancemgt/report/VOP_OPF_9401.mrd";
					
//					formObj.rdViewer.AutoAdjust = true;
//					formObj.rdViewer.HideToolbar();
					formObj.rdViewer.HideStatusBar();
					
					//VVD Remark 정보 조회
					doActionIBSheet(sheetObj, formObj, "IBSEARCH01");

					formObj.rdViewer.FileOpen(RD_path+strPath, msg);
					
				} else {
					ComShowCodeMessage("OPF00001", "Dashboard Data");
				}
			}

			ComOpenWait(false);
			sheetObj.Redraw = true;
			break;

		case "IBSEARCH01": //조회
			formObj.f_cmd.value = SEARCH01;
			sheetObj.WaitImageVisible=false;
			sheetObj.Redraw = false;
			ComOpenWait(true);
			
			var param = FormQueryString(formObj);
			var saveString = sheetObj.GetSaveString();
			param += "&" + saveString;
			var sXml = sheetObj.GetSaveXml("VOP_OPF_9401GS.do", param);
			sheetObj.LoadSearchXml(sXml);

			ComOpenWait(false);
			sheetObj.Redraw = true;
			break;
			
		case "IBSEARCH02": // Baseline 조회
			formObj.f_cmd.value = SEARCH02;
			sheetObj.WaitImageVisible=false;
			sheetObj.Redraw = false;
			ComOpenWait(true);
		
			if(formObj.port_kpi_dir_cd.value == ""){
				formObj.port_kpi_dir_cd.value = "A";
			}
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("VOP_OPF_9401GS.do", param);
			var arrXml = sXml.split("|$$|");
			var rtnStr = "";

			if (arrXml.length > 0) {
				var list = SheetXml2ListMap(arrXml[0]);
				var graphVO;

				if(list.length > 0) {	
					graphVO = list[0];
					rtnStr += "Base Line" + "@";
					rtnStr += graphVO["stm_in_hrs"] + "@";
					rtnStr += graphVO["vsl_arr_hrs"] + "@";
					rtnStr += graphVO["tml_op_hrs"] + "@";
					rtnStr += graphVO["vsl_dep_hrs"] + "@";
					rtnStr += graphVO["grs_crn_prod_hrs"] + "@~";
				}
			}	

			ComOpenWait(false);
			sheetObj.Redraw = true;
			return rtnStr;

			break;

		case IBSAVE: //저장
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false;
			sheetObj.Redraw = false;
			ComOpenWait(true);
			
			var param = FormQueryString(formObj);
			var saveString = sheetObj.GetSaveString();
			param += "&" + saveString;
			var sXml = sheetObj.GetSaveXml("VOP_OPF_9401GS.do", param);

			ComOpenWait(false);
			sheetObj.Redraw = true;
			
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				ComShowCodeMessage("OPF50006", "Remark Description");
				
				//VVD Remark 정보 조회
				//doActionIBSheet(sheetObj, formObj, "IBSEARCH");
				//window.close();
				loadPage();
			}
			
			break;
	}
}

/**
 * Vo List를 array[array[name]]형태로 변환 
 * @param {xml} xmlStr 조회 결과 (SC에서 setRsVoList , setRsVo 호출시) 
 */
 function SheetXml2ListMap(xmlStr) {
 	
 	var rtnArr = new Array();

 	if (xmlStr == null || xmlStr == "") {
 		return rtnArr;
 	}

 	try {
 		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
 		xmlDoc.loadXML(xmlStr);

 		var xmlRoot = xmlDoc.documentElement;
 		if (xmlRoot == null) {
 			return rtnArr;
 		}

 		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
 		if (dataNode == null || dataNode.attributes.length < 3) {
 			return rtnArr;
 		}

 		var col = dataNode.getAttribute("COLORDER");
 		var colArr = col.split("|");
 		var sep = dataNode.getAttribute("COLSEPARATOR");
 		var total = dataNode.getAttribute("TOTAL");

 		if (total == 0) {
 			return rtnArr;
 		}
 		
 		var dataChileNodes = dataNode.childNodes;
 		if (dataChileNodes == null) {
 			return rtnArr;
 		}

 		for ( var i = 0; i < dataChileNodes.length; i++) {
 			if (dataChileNodes[i].nodeType != 1) {
 				continue;
 			}
 			
 			var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

 			var subDataArr = new Array();
 			
 			for ( var j = 0; j < arrData.length; j++) {
 				subDataArr[colArr[j]] = arrData[j];
 			}
 			
 			rtnArr[i] = (subDataArr);
 		}

 	} catch (err) {
 		ComFuncErrMsg(err.message);
 	}

 	return rtnArr;
 }

/* 개발자 작업  끝 */