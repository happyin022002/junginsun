/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_PRD_0054.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : noh seung bae
*@LastVersion : 1.0 
* 2010.02.10 noh seung bae
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
     * @fileoverview 
     * @author 한진해운
     */


// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var retValidate = 0;
var formObject = null;
var ioType = "I"; // form.io_type.value 에서 가져올 수도 있으나 저장당시 io_type.value 값이 변경될 수 있다. 그래서 retrieve 당시 저장 함
var isUsa = false; // rowadd, rowcopy 할 때 미주인지 검사해서 wrs, inv billing patter 활성화 비활성화 처리
var orgNode = "";
var destNode = "";
 
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    	
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	/*******************************************************/
	var param ;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_retrieve":
				if(!ComChkRequired(formObject)) return;
				formObject.f_cmd.value = SEARCHLIST;
				sheetObject.DoSearch4Post("ESD_PRD_0054GS.do", PrdFQString(formObject));
				ioType = formObject.io_type[0].checked ? formObject.io_type[0].value : formObject.io_type[1].value;
				// org_node, dest_node 폼에 값이 둘다 미주일경우
				isUsa = (("US CA MX".indexOf(formObject.org_node.value.substring(0,2)) > -1)
					&& ("US CA MX".indexOf(formObject.dest_node.value.substring(0,2)) > -1));
				orgNode = formObject.org_node.value;
				destNode = formObject.dest_node.value;
				break;

			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;

			case "btn_save":
				formObject.f_cmd.value = MULTI;
				//var rst = sheetObject.DoSave("ESD_PRD_0054GS.do", PrdFQString(formObject));

				var saveStr = sheetObject.GetSaveString(false);
				if(saveStr == ""){
					sheetObject.MessageText("WarningTitle")  = "ALPS Warning";
					alert( sheetObject.MessageText("UserMsg13"));
					break;
				}
				saveStr += "&"+PrdFQString(formObject);
				var xml = sheetObject.GetSaveXml("ESD_PRD_0054GS.do", saveStr);
				//alert(xml);
				sheetObject.LoadSearchXml(xml,true, -1, true);
				var rows = sheetObject.EtcData("result").split("^"); // row 구분자

				for(i=3, s=sheetObject.Rows+1; i<s; i++){
					// 0=seq번호, 1=success or fail, 2=메시지
					for(k=0; k<rows.length; k++){
						var cols = rows[k].split("|"); // col 구분자
						if(sheetObject.CellValue(i, "seq_no") == cols[0]){
							sheetObject.CellValue2(i, "error_code") = cols[1];
							sheetObject.ToolTipText(i, "error_code") = cols[2];
							if(cols[1] == "Success"){
								if(sheetObject.CellValue(i, "del_chk") == 1){
									// 밑에 이거 쓰면 row 가 꼬여서 안됩니다. 현업한이 없애주세요 하면 안된다고 하세요. 또 삭제 실패했을 경우 메시지 처리도 해야 하구요.
									//sheetObject.RowDelete(i); 
									sheetObject.CellEditable(i, "check") = 0;
									sheetObject.CellEditable(i, "del_chk") = false;
								}else{ // 아니면 status 를 R로
									sheetObject.RowStatus(i) = "R";
									sheetObject.CellEditable(i, "wrs_full_cmdt") = false;
									sheetObject.CellEditable(i, "inlnd_rout_inv_bil_patt_cd") = false;
								}
							}
							break;
						}
					}

				}
				break;
        	         
			case "btn_loadexcel":
				sheetObject.LoadExcel();
				break;

			case "btn_downexcel":
				sheetObject.Down2Excel(-1, false, false, true);
				break;
                
			case "btng_rowadd":
				var Row = sheetObject.DataInsert();
				sheetObject.CellValue2(sheetObject.SelectRow, "pctl_io_bnd_cd") = ioType;
				sheetObject.CellEditable(Row, "wrs_full_cmdt") = isUsa;
				sheetObject.CellEditable(Row, "inlnd_rout_inv_bil_patt_cd") = isUsa;
				sheetObject.CellValue2(Row, "rout_org_nod_cd") = orgNode;
				sheetObject.CellValue2(Row, "rout_dest_nod_cd") = destNode;
				break;

			case "btng_rowcopy":

				var checkCount = 0;
				for(i=3, s=sheetObject.Rows+1 ; i<s; i++){
					if(sheetObject.CellValue(i, "del_chk") == 1 ){
						continue;
					}
					if(sheetObject.CellValue(i, "check") == 1){
						sheetObject.CellValue2(i, "check") = 0;
						sheetObject.SelectCell(i, "check");
						sheetObject.DataCopy();
						if(sheetObject.CellValue(i+1, "prio_seq") > 2 ){
							sheetObject.CellValue2(i+1, "prio_seq") = "1";
						}
						sheetObject.CellEditable(i+1, "wrs_full_cmdt") = isUsa;
						sheetObject.CellEditable(i+1, "inlnd_rout_inv_bil_patt_cd") = isUsa;
						if(!isUsa){
							sheetObject.CellValue2(i+1, "wrs_full_cmdt") = 0;
							sheetObject.CellValue2(i+1, "inlnd_rout_inv_bil_patt_cd") = "";
						}
						++checkCount;
					}
				}
				if(checkCount == 0){
					var Row = sheetObject.DataCopy();
					if(sheetObject.CellValue(Row, "prio_seq") > 2 ){
						sheetObject.CellValue2(Row, "prio_seq") = "1";
					}
					sheetObject.CellValue2(Row, "check") = 0;
					sheetObject.CellEditable(Row, "wrs_full_cmdt") = isUsa;
					sheetObject.CellEditable(Row, "inlnd_rout_inv_bil_patt_cd") = isUsa;
					if(!isUsa){
						sheetObject.CellValue2(Row, "wrs_full_cmdt") = 0;
						sheetObject.CellValue2(Row, "inlnd_rout_inv_bil_patt_cd") = "";
					}

				}
				break;

			case "org_node_pop":
				param = "?loc_cd="+formObject.org_node.value;
				ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;
			case "dest_node_pop":
				param = "?loc_cd="+formObject.dest_node.value;
				ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;
 			   					   				   		
		} // end switch
            
    	
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
function setSheetObject(sheet_obj){

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
function loadPage() {
	formObject = document.form;

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
        
	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keypress', 'PrdComKeyEnter' , 'org_node', 'dest_node');
		
}
     
/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:      //IBSheet1 init
			with (sheetObj) {
				//전체 너비 설정
				style.height = GetSheetHeight(23) ;
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(107, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				//var HeadTitle = "Del.|CHK|Priority|VerificationResult|VerificationResult|ORG Node|DEST Node|HUB Nod|R.P|BKG|WRS|Route|Tmp Flg|FREE SHTL|Total T/T|C.User|C.Date|U.User|U.Date|D.User|D.Date|Remarks|Rout SEQ|Hub Search Gb|Front Gb|Undefine Nod|Gu|Ori|ORG.LOC|Node|DEST.LOC|Node" ;
				//var HeadTitle = "Del.|CHK|Priority|STS|ErrType|ORG Node|DEST Node|HUB Nod|R.P|BKG|WRS|Route|Tmp Flg|FREE SHTL|Total T/T|C.User|C.Date|U.User|U.Date|D.User|D.Date|Remarks|Rout SEQ|Hub Search Gb|Front Gb|Undefine Nod|Gu|Ori|ORG.LOC|Node|DEST.LOC|Node" ;
				var HeadTitle0 = "Del.|CHK|Seq|Verification\nResult|Verification\nResult|ORG Node|DEST Node|Priority|BKG|WRS|Tmp Flg|FREE SHTL|INV Billing & Pattern|Route Plan|wrs_mty_cmdt_cd|pctl_io_bnd_cd|hub_loc_cd|Rout SEQ|Hub Search Gb|Front Gb|Undefine Nod|Gu|Ori|ORG.LOC|Node|DEST.LOC|Node"
				+"|1ST Node|Mode|S/P\nCode|S/P\nName|T/T\n(DD.HH)|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark|n1st_trsp_agmt_ofc_cty_cd|n1st_trsp_agmt_seq|n1st_agmt_ref_no"
				+"|2ND Node|Mode|S/P\nCode|S/P\nName|T/T\n(DD.HH)|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark|n2st_trsp_agmt_ofc_cty_cd|n1st_trsp_agmt_seq|n2st_agmt_ref_no"
				+"|3RD Node|Mode|S/P\nCode|S/P\nName|T/T\n(DD.HH)|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark|n3st_trsp_agmt_ofc_cty_cd|n1st_trsp_agmt_seq|n3st_agmt_ref_no"
				+"|4TH Node|Mode|S/P\nCode|S/P\nName|T/T\n(DD.HH)|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark|n4st_trsp_agmt_ofc_cty_cd|n1st_trsp_agmt_seq|n4st_agmt_ref_no"
				+"|5TH Node|Mode|S/P\nCode|S/P\nName|T/T\n(DD.HH)|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark|n5st_trsp_agmt_ofc_cty_cd|n1st_trsp_agmt_seq|n5st_agmt_ref_no"
				+"|6TH Node|Mode|S/P\nCode|S/P\nName|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark";
				var HeadTitle1 = "Del.|CHK|Seq|STS|Err Code|ORG Node|DEST Node|Priority|BKG|WRS|Tmp Flg|FREE SHTL|INV Billing & Pattern|Route Plan|wrs_mty_cmdt_cd|pctl_io_bnd_cd|hub_loc_cd|Rout SEQ|Hub Search Gb|Front Gb|Undefine Nod|Gu|Ori|ORG.LOC|Node|DEST.LOC|Node"
				+"|1ST Node|Mode|S/P\nCode|S/P\nName|T/T\n(DD.HH)|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark|n1st_trsp_agmt_ofc_cty_cd|n1st_trsp_agmt_seq|n1st_agmt_ref_no"
				+"|2ND Node|Mode|S/P\nCode|S/P\nName|T/T\n(DD.HH)|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark|n2st_trsp_agmt_ofc_cty_cd|n1st_trsp_agmt_seq|n2st_agmt_ref_no"
				+"|3RD Node|Mode|S/P\nCode|S/P\nName|T/T\n(DD.HH)|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark|n3st_trsp_agmt_ofc_cty_cd|n1st_trsp_agmt_seq|n3st_agmt_ref_no"
				+"|4TH Node|Mode|S/P\nCode|S/P\nName|T/T\n(DD.HH)|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark|n4st_trsp_agmt_ofc_cty_cd|n1st_trsp_agmt_seq|n4st_agmt_ref_no"
				+"|5TH Node|Mode|S/P\nCode|S/P\nName|T/T\n(DD.HH)|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark|n5st_trsp_agmt_ofc_cty_cd|n1st_trsp_agmt_seq|n5st_agmt_ref_no"
				+"|6TH Node|Mode|S/P\nCode|S/P\nName|AGMT No|Reference\nNo|Combine\nMode|C/TOFC|Junction|Remark";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheck,   50,    daCenter,  true,    "del_chk",                   false,          "",       dfNone,    0,     true ,      true, -1, false, true, "", true);
				InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,    "check",                     false,          "",       dfNone,    0,     true ,      true, -1, false, true, "undelete", false);
				InitDataProperty(0, cnt++ , dtSeq,        50,    daCenter,  true,    "seq_no",                    false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,    "ibflag",                    false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "error_code",                false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "rout_org_nod_cd",           true ,          "",       dfNone,    0,     false,      true, 7);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "rout_dest_nod_cd",          true ,          "",       dfNone,    0,     false,      true, 7);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "prio_seq",                  true ,          "",       dfNone,    0,     false,      true, 1);

				InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,  true,    "inlnd_rout_bkg_flg",        true ,          "",       dfNone,    0,     false,      true, -1, true, true, "", true);
				InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,  true,    "wrs_full_cmdt",             false,          "",       dfNone,    0,     false,      false, -1, false, true, "", true);
				InitDataProperty(0, cnt++ , dtCheckBox,   70,    daCenter,  true,    "inlnd_rout_tmp_flg",        false,          "",       dfNone,    0,     false,      true,1, false, true, "", true);
				InitDataProperty(0, cnt++ , dtCheckBox,   80,    daCenter,  true,    "inlnd_rout_incl_sttl_flg",  false,          "",       dfNone,    0,     false,      true,1 ,false, true,"Free shuttle move include", true);
				InitDataProperty(0, cnt++ , dtCombo,      160,   daCenter,  true,    "inlnd_rout_inv_bil_patt_cd",false,          "",       dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++ , dtCombo,      160,   daCenter,  true,    "rout_pln_cd",               false,          "",       dfNone,    0,     false,      true);

				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "wrs_mty_cmdt_cd",           false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "pctl_io_bnd_cd",            false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "hub_loc_cd",                false,          "",       dfNone,    0,     false,      true);

				// 밑에 히든 값은 참고로 나둡니다.
				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "rout_seq",                  false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "hub_search_gb",             false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "front_gb",                  false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "undefine_nod",              false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "group_gubun",               false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "ori_prio_seq",              true,           "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     80,    daCenter,  true,    "org_loc",                   false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "org_loc_type",              false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     80,    daCenter,  true,    "dest_loc",                  false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "dest_loc_type",             false,          "",       dfNone,    0,     false,      true);

				InitDataProperty(0, cnt++, dtPopupEdit , 80,    daCenter,  true,    "n1st_node"                ,   true ,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtCombo ,     50,    daCenter,  true,    "tm1"                      ,   true ,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtPopupEdit , 60,    daCenter,  true,    "vndr1"                    ,   true ,         "",       dfNone,    0,     false,     true, 6);
				InitDataProperty(0, cnt++, dtData ,      150,   daLeft,    true,    "sp_name1"                 ,   false,         "",       dfNone,    0,     false,     false);
				InitDataProperty(0, cnt++, dtData ,      70,    daCenter,  true,    "fmt_tztm_hrs1"            ,   true ,         "",       dfNone,    0,     false,     true, 4);
				InitDataProperty(0, cnt++, dtData ,      80,    daCenter,  true,    "agmt_no1"                 ,   false,         "",       dfNone,    0,     false,     true, 9);
				InitDataProperty(0, cnt++, dtData ,      65,    daCenter,  true,    "agmt_ref_no1"             ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCheckBox ,  70,    daCenter,  true,    "com_flg1"                 ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtCombo ,     100,   daCenter,  true,    "rd_crr_tp1"               ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      60,    daCenter,  true,    "junc_nm1"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      100,   daLeft,    true,    "inlnd_rout_rmk1"          ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n1st_trsp_agmt_ofc_cty_cd",   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n1st_trsp_agmt_seq"       ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n1st_agmt_ref_no"         ,   false,         "",       dfNone,    0,     false,     true );

				InitDataProperty(0, cnt++, dtPopupEdit , 80,    daCenter,  true,    "n2nd_node"                ,   true ,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtCombo ,     40,    daCenter,  true,    "tm2"                      ,   false,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtPopupEdit , 50,    daCenter,  true,    "vndr2"                    ,   false,         "",       dfNone,    0,     false,     true, 6);
				InitDataProperty(0, cnt++, dtData ,      150,   daLeft,    true,    "sp_name2"                 ,   false,         "",       dfNone,    0,     false,     false);
				InitDataProperty(0, cnt++, dtData ,      50,    daCenter,  true,    "fmt_tztm_hrs2"            ,   false,         "",       dfNone,    0,     false,     true, 4);
				InitDataProperty(0, cnt++, dtData ,      80,    daCenter,  true,    "agmt_no2"                 ,   false,         "",       dfNone,    0,     false,     true, 9);
				InitDataProperty(0, cnt++, dtData ,      65,    daCenter,  true,    "agmt_ref_no2"             ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCheckBox ,  70,    daCenter,  true,    "com_flg2"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCombo ,     100,   daCenter,  true,    "rd_crr_tp2"               ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      60,    daCenter,  true,    "junc_nm2"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      100,   daLeft,    true,    "inlnd_rout_rmk2"          ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n2nd_trsp_agmt_ofc_cty_cd",   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n2nd_trsp_agmt_seq"       ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n2nd_agmt_ref_no"         ,   false,         "",       dfNone,    0,     false,     true );

				InitDataProperty(0, cnt++, dtPopupEdit , 80,    daCenter,  true,    "n3rd_node"                ,   false,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtCombo ,     40,    daCenter,  true,    "tm3"                      ,   false,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtPopupEdit , 50,    daCenter,  true,    "vndr3"                    ,   false,         "",       dfNone,    0,     false,     true, 6);
				InitDataProperty(0, cnt++, dtData ,      150,   daLeft,    true,    "sp_name3"                 ,   false,         "",       dfNone,    0,     false,     false);
				InitDataProperty(0, cnt++, dtData ,      50,    daCenter,  true,    "fmt_tztm_hrs3"            ,   false,         "",       dfNone,    0,     false,     true, 4);
				InitDataProperty(0, cnt++, dtData ,      80,    daCenter,  true,    "agmt_no3"                 ,   false,         "",       dfNone,    0,     false,     true, 9);
				InitDataProperty(0, cnt++, dtData ,      65,    daCenter,  true,    "agmt_ref_no3"             ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCheckBox ,  70,    daCenter,  true,    "com_flg3"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCombo ,     100,   daCenter,  true,    "rd_crr_tp3"               ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      60,    daCenter,  true,    "junc_nm3"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      100,   daLeft,    true,    "inlnd_rout_rmk3"          ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n3rd_trsp_agmt_ofc_cty_cd",   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n3rd_trsp_agmt_seq"       ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n3rd_agmt_ref_no"         ,   false,         "",       dfNone,    0,     false,     true );

				InitDataProperty(0, cnt++, dtPopupEdit , 80,    daCenter,  true,    "n4th_node"                ,   false,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtCombo ,     40,    daCenter,  true,    "tm4"                      ,   false,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtPopupEdit , 50,    daCenter,  true,    "vndr4"                    ,   false,         "",       dfNone,    0,     false,     true, 6);
				InitDataProperty(0, cnt++, dtData ,      150,   daLeft,    true,    "sp_name4"                 ,   false,         "",       dfNone,    0,     false,     false);
				InitDataProperty(0, cnt++, dtData ,      50,    daCenter,  true,    "fmt_tztm_hrs4"            ,   false,         "",       dfNone,    0,     false,     true, 4);
				InitDataProperty(0, cnt++, dtData ,      80,    daCenter,  true,    "agmt_no4"                 ,   false,         "",       dfNone,    0,     false,     true, 9);
				InitDataProperty(0, cnt++, dtData ,      65,    daCenter,  true,    "agmt_ref_no4"             ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCheckBox ,  70,    daCenter,  true,    "com_flg4"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCombo ,     100,   daCenter,  true,    "rd_crr_tp4"               ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      60,    daCenter,  true,    "junc_nm4"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      100,   daLeft,    true,    "inlnd_rout_rmk4"          ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n4th_trsp_agmt_ofc_cty_cd",   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n4th_trsp_agmt_seq"       ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n4th_agmt_ref_no"         ,   false,         "",       dfNone,    0,     false,     true );

				InitDataProperty(0, cnt++, dtPopupEdit , 80,    daCenter,  true,    "n5th_node"                ,   false,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtCombo ,     40,    daCenter,  true,    "tm5"                      ,   false,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtPopupEdit , 50,    daCenter,  true,    "vndr5"                    ,   false,         "",       dfNone,    0,     false,     true, 6);
				InitDataProperty(0, cnt++, dtData ,      150,   daLeft,    true,    "sp_name5"                 ,   false,         "",       dfNone,    0,     false,     false);
				InitDataProperty(0, cnt++, dtData ,      50,    daCenter,  true,    "fmt_tztm_hrs5"            ,   false,         "",       dfNone,    0,     false,     true, 4);
				InitDataProperty(0, cnt++, dtData ,      80,    daCenter,  true,    "agmt_no5"                 ,   false,         "",       dfNone,    0,     false,     true, 9);
				InitDataProperty(0, cnt++, dtData ,      65,    daCenter,  true,    "agmt_ref_no5"             ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCheckBox ,  70,    daCenter,  true,    "com_flg5"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCombo ,     100,   daCenter,  true,    "rd_crr_tp5"               ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      60,    daCenter,  true,    "junc_nm5"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      100,   daLeft,    true,    "inlnd_rout_rmk5"          ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n5th_trsp_agmt_ofc_cty_cd",   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n5th_trsp_agmt_seq"       ,   false,         "",       dfNone,    0,     false,     true );
				InitDataProperty(0, cnt++, dtHidden ,    80,    daCenter,  true,    "n5th_agmt_ref_no"         ,   false,         "",       dfNone,    0,     false,     true );

				InitDataProperty(0, cnt++, dtPopupEdit , 80,    daCenter,  true,    "n6th_node"                ,   false,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtCombo ,     40,    daCenter,  true,    "tm6"                      ,   false,         "",       dfNone,    0,     false,     true, 7);
				InitDataProperty(0, cnt++, dtPopupEdit , 50,    daCenter,  true,    "vndr6"                    ,   false,         "",       dfNone,    0,     false,     true, 6);
				InitDataProperty(0, cnt++, dtData ,      150,   daLeft,    true,    "sp_name6"                 ,   false,         "",       dfNone,    0,     false,     false);
				InitDataProperty(0, cnt++, dtData ,      80,    daCenter,  true,    "agmt_no6"                 ,   false,         "",       dfNone,    0,     false,     true, 9);
				InitDataProperty(0, cnt++, dtData ,      65,    daCenter,  true,    "agmt_ref_no6"             ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCheckBox ,  70,    daCenter,  true,    "com_flg6"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtCombo ,     100,   daCenter,  true,    "rd_crr_tp6"               ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      60,    daCenter,  true,    "junc_nm6"                 ,   false,         "",       dfNone,    0,     false,     true);
				InitDataProperty(0, cnt++, dtData ,      100,   daCenter,  true,    "inlnd_rout_rmk6"          ,   false,         "",       dfNone,    0,     false,     true );





				//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
				//InitDataCombo (0, "prio_seq", " |", " |");
				InitDataCombo (0, "inlnd_rout_inv_bil_patt_cd", inlnd_rout_inv_bil_patt_cdText, inlnd_rout_inv_bil_patt_cdCode );
				InitDataCombo (0, "rout_pln_cd",                rout_pln_cdText, rout_pln_cdCode);


				//InitUserFormat2(0, "tot_tt", "##D##H" , "D|H" );
		            
				//InitDataValid(0, "hub",            vtEngUpOther, "1234567890");
				//InitDataValid(0, "rout_pln_cd",    vtEngUpOther, "1234567890");
				InitDataValid(0, "org_loc",        vtEngUpOther, "1234567890");
				InitDataValid(0, "org_loc_type",   vtEngUpOther, "1234567890");
				InitDataValid(0, "dest_loc",       vtEngUpOther, "1234567890");
				InitDataValid(0, "dest_loc_type",  vtEngUpOther, "1234567890");
				InitDataValid(0, "prio_seq",       vtCharOnly,   "12");
				//InitDataValid(0, "old_prio_seq",   vtEngUpOther, "1234567890");
				//InitDataValid(0, "force_prio_flg", vtEngUpOther, "1234567890");


				InitDataCombo(0, "tm1", trsp_mod_cdText, trsp_mod_cdCode);
				InitDataCombo(0, "tm2", trsp_mod_cdText, trsp_mod_cdCode);
				InitDataCombo(0, "tm3", trsp_mod_cdText, trsp_mod_cdCode);
				InitDataCombo(0, "tm4", trsp_mod_cdText, trsp_mod_cdCode);
				InitDataCombo(0, "tm5", trsp_mod_cdText, trsp_mod_cdCode);
				InitDataCombo(0, "tm6", trsp_mod_cdText, trsp_mod_cdCode);

				InitDataCombo(0, "rd_crr_tp1", rail_crr_tp_cdText, rail_crr_tp_cdCode);
				InitDataCombo(0, "rd_crr_tp2", rail_crr_tp_cdText, rail_crr_tp_cdCode);
				InitDataCombo(0, "rd_crr_tp3", rail_crr_tp_cdText, rail_crr_tp_cdCode);
				InitDataCombo(0, "rd_crr_tp4", rail_crr_tp_cdText, rail_crr_tp_cdCode);
				InitDataCombo(0, "rd_crr_tp5", rail_crr_tp_cdText, rail_crr_tp_cdCode);
				InitDataCombo(0, "rd_crr_tp6", rail_crr_tp_cdText, rail_crr_tp_cdCode);
				}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObject,sAction) {
	var uid ;
	var sXml ;
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case SEARCH02:
			formObject.f_cmd.value = SEARCH02;

			uid= "ESD_PRD_0054";
			sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObject));
              
			sheetObj.LoadSearchXml(sXml,true, -1, true);
			retValidate = sheetObjects[0].EtcData("rowCount");
			break;
		case SEARCH05:
			formObject.f_cmd.value = SEARCH05;
			uid= "ESD_PRD_0054";
			sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObject));
              
			sheetObj.LoadSearchXml(sXml,true, -1, true);
			retValidate = sheetObjects[0].EtcData("rowCount");
              
			break;
	}
}


function sheet1_OnSearchEnd(sheetObj,ErrMsg){
	if(sheetObj.RowCount>0) {
		ComBtnEnable("btn_save");
	}

	for(var i=2; i<sheetObj.Rows; i++){
		// hub_search_gb 가 디비에서 공백 하드코딩으로 값이 넘어온다.
		if(sheetObj.CellValue(sheetObj.SelectRow,"hub_search_gb") == "Y"){
			sheetObj.CellValue2(i, "rnllws" )= 'R';
			sheetObj.RowStatus(i) = 'I';
		}

		//var usaStr = "US CA";
		//var rdStr = "RD";
		//sheetObj.CellEditable(i, "rd_crr_tp1") =
		//usaStr.indexOf(sheetObj.CellValue(i, "n1st_node").substring(0, 2)) > -1
		//&& usaStr.indexOf(sheetObj.CellValue(i, "n2nd_node").substring(0, 2)) > -1
		//&& rdStr == sheetObj.CellValue(i, "tm1");

		//sheetObj.CellEditable(i, "rd_crr_tp2") =
		//usaStr.indexOf(sheetObj.CellValue(i, "n2nd_node").substring(0, 2)) > -1
		//&& usaStr.indexOf(sheetObj.CellValue(i, "n3rd_node").substring(0, 2)) > -1
		//&& rdStr == sheetObj.CellValue(i, "tm2");

		//sheetObj.CellEditable(i, "rd_crr_tp3") =
		//usaStr.indexOf(sheetObj.CellValue(i, "n3rd_node").substring(0, 2)) > -1
		//&& usaStr.indexOf(sheetObj.CellValue(i, "n4th_node").substring(0, 2)) > -1
		//&& rdStr == sheetObj.CellValue(i, "tm3");

		//sheetObj.CellEditable(i, "rd_crr_tp4") =
		//usaStr.indexOf(sheetObj.CellValue(i, "n4th_node").substring(0, 2)) > -1
		//&& usaStr.indexOf(sheetObj.CellValue(i, "n5th_node").substring(0, 2)) > -1
		//&& rdStr == sheetObj.CellValue(i, "tm4");

		//sheetObj.CellEditable(i, "rd_crr_tp5") =
		//usaStr.indexOf(sheetObj.CellValue(i, "n5th_node").substring(0, 2)) > -1
		//&& usaStr.indexOf(sheetObj.CellValue(i, "n6th_node").substring(0, 2)) > -1
		//&& rdStr == sheetObj.CellValue(i, "tm5");
	}

}  
    
var old_prio_seq = 0;
function sheet1_OnChange(sheetObj,Row,Col,Value) {

	var isRail = (sheetObj.CellValue(Row,"tm1" ) == "RD"
		|| sheetObj.CellValue(Row,"tm2" ) == "RD"
		|| sheetObj.CellValue(Row,"tm3" ) == "RD"
		|| sheetObj.CellValue(Row,"tm4" ) == "RD"
		|| sheetObj.CellValue(Row,"tm5" ) == "RD");


	if( sheetObj.ColSaveName(Col)=="wrs_full_cmdt" ) {
		if(Value == 1){
			/*
			 * WRS 가 체크 되어 있는지 확인 (FROM, TO)
			 */
			var org_nod_cd = sheetObj.CellValue(Row,"rout_org_nod_cd");
			var dest_nod_cd = sheetObj.CellValue(Row,"rout_dest_nod_cd");

			var arrRow = sheetObj.FindCheckedRow ("wrs_full_cmdt" ).split("|");
			for (idx=0; idx<arrRow.length-1; idx++){
				if(Row == arrRow[idx] || org_nod_cd != sheetObj.CellValue(arrRow[idx],"rout_org_nod_cd") ||  dest_nod_cd != sheetObj.CellValue(arrRow[idx],"rout_dest_nod_cd")  ){
					continue;
				} else {
					if(confirm(ComGetMsg('PRD90087'))) {
						//'WRS indicator is duplicated for the same corridor.
						// Please select one WRS indicator only for this route and try it once again. Continue?';
						break;
					} else {
						sheetObj.CellValue2(Row,"wrs_full_cmdt") = 0;
						return;
					}
				}
			}
                  
			sheetObj.CellValue2(Row,"inlnd_rout_bkg_flg") = 1;
			if( (sheetObj.CellValue(Row,"prio_seq") != 1 )){
				if(confirm(ComGetMsg('PRD90088'))) {
					//'The prioirity will be changed to \'1\' automatically. Continue?';
					old_prio_seq = sheetObj.CellValue(Row,"prio_seq");
					sheetObj.CellValue2(Row,"prio_seq") = 1;
				} else {
					old_prio_seq = sheetObj.CellValue(Row,"prio_seq");
					sheet1_OnPopupClick(sheetObj, Row, Col);
				}
                      
			}
		}else {
			if(old_prio_seq != 0){
				//wrs를 수정한후 해제시 prio_seq 를 auto 로 1로 바꾸었으면 원복 시킴
				sheetObj.CellValue2(Row,"prio_seq") = old_prio_seq;
				old_prio_seq = 0;
			}
		}

		if(check_inv_bil(sheetObj, Row, isRail)) return false;

		// 정확히 할 수는 없습니다. 1~5중에 하나라도 정상이면(false) 정상처리
		if(check_vndr(sheetObj, sheetObj.CellValue(Row,"vndr1"))
			&& check_vndr(sheetObj, sheetObj.CellValue(Row,"vndr2"))
			&& check_vndr(sheetObj, sheetObj.CellValue(Row,"vndr3"))
			&& check_vndr(sheetObj, sheetObj.CellValue(Row,"vndr4"))
			&& check_vndr(sheetObj, sheetObj.CellValue(Row,"vndr5"))) return false;

		// 정확히 할 수는 없습니다. 1~5중에 하나라도 정상이면(false) 정상처리
		if(check_rd_crr_tp(sheetObj, sheetObj.CellValue(Row,"rd_crr_tp1"), sheetObj.CellValue(Row, "tm1"))
			&& check_rd_crr_tp(sheetObj, sheetObj.CellValue(Row,"rd_crr_tp2"), sheetObj.CellValue(Row, "tm2"))
			&& check_rd_crr_tp(sheetObj, sheetObj.CellValue(Row,"rd_crr_tp3"), sheetObj.CellValue(Row, "tm3"))
			&& check_rd_crr_tp(sheetObj, sheetObj.CellValue(Row,"rd_crr_tp4"), sheetObj.CellValue(Row, "tm4"))
			&& check_rd_crr_tp(sheetObj, sheetObj.CellValue(Row,"rd_crr_tp5"), sheetObj.CellValue(Row, "tm5"))) return false;

	}else if(sheetObj.ColSaveName(Col).indexOf("vndr") > -1){
		if( check_vndr(sheetObj, Value)) return false;

		if(Value.length > 0){
			formObject.f_cmd.value = SEARCH08;
			var uid= "ESD_PRD_0057";
			var sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+Value+"&"+PrdFQString(formObject));

			sheetObj.LoadSearchXml(sXml,true, -1, true);
			var retValidate = sheetObj.EtcData("rowCount");
			var comData2 = sheetObj.EtcData("comData2");
			//rowcount 가 1보다 작으면
			var colNameNo = sheetObj.ColSaveName(Col).substring(sheetObj.ColSaveName(Col).length -1);
			if(retValidate < 1) {
				sheetObj.CellValue2(Row,"sp_name"+colNameNo) = "";
				sheetObj.CellValue2(Row, Col) = "";
				sheetObj.SelectCell(Row, Col);
			}else {
				sheetObj.CellValue2(sheetObj.selectRow, "sp_name"+colNameNo) = comData2;
			}
		}

	}else if(sheetObj.ColSaveName(Col) == "inlnd_rout_inv_bil_patt_cd" || sheetObj.ColSaveName(Col) == "rout_pln_cd" ){
		if(check_inv_bil(sheetObj, Row, isRail)) return false;

	}else if(sheetObj.ColSaveName(Col) == "agmt_no1" || sheetObj.ColSaveName(Col) == "agmt_ref_no1" ){
		if(check_agmt(sheetObj, sheetObj.CellValue(Row,"agmt_no1"), sheetObj.CellValue(Row,"agmt_ref_no1"), sheetObj.CellValue(Row, "tm1"))) return false;
	}else if(sheetObj.ColSaveName(Col) == "agmt_no2" || sheetObj.ColSaveName(Col) == "agmt_ref_no2"){
		if(check_agmt(sheetObj, sheetObj.CellValue(Row,"agmt_no2"), sheetObj.CellValue(Row,"agmt_ref_no2"), sheetObj.CellValue(Row, "tm2"))) return false;
	}else if(sheetObj.ColSaveName(Col) == "agmt_no3" || sheetObj.ColSaveName(Col) == "agmt_ref_no3" ){
		if(check_agmt(sheetObj, sheetObj.CellValue(Row,"agmt_no3"), sheetObj.CellValue(Row,"agmt_ref_no3"), sheetObj.CellValue(Row, "tm3"))) return false;
	}else if(sheetObj.ColSaveName(Col) == "agmt_no4" || sheetObj.ColSaveName(Col) == "agmt_ref_no4" ){
		if(check_agmt(sheetObj, sheetObj.CellValue(Row,"agmt_no4"), sheetObj.CellValue(Row,"agmt_ref_no4"), sheetObj.CellValue(Row, "tm4"))) return false;
	}else if(sheetObj.ColSaveName(Col) == "agmt_no5" || sheetObj.ColSaveName(Col) == "agmt_ref_no5"){
		if(check_agmt(sheetObj, sheetObj.CellValue(Row,"agmt_no5"), sheetObj.CellValue(Row,"agmt_ref_no5"), sheetObj.CellValue(Row, "tm5"))) return false;

	}else if(sheetObj.ColSaveName(Col) == "rd_crr_tp1"){
		if(check_rd_crr_tp(sheetObj, Value, sheetObj.CellValue(Row, "tm1"))) return false;
	}else if(sheetObj.ColSaveName(Col) == "rd_crr_tp2"){
		if(check_rd_crr_tp(sheetObj, Value, sheetObj.CellValue(Row, "tm2"))) return false;
	}else if(sheetObj.ColSaveName(Col) == "rd_crr_tp3"){
		if(check_rd_crr_tp(sheetObj, Value, sheetObj.CellValue(Row, "tm3"))) return false;
	}else if(sheetObj.ColSaveName(Col) == "rd_crr_tp4"){
		if(check_rd_crr_tp(sheetObj, Value, sheetObj.CellValue(Row, "tm4"))) return false;
	}else if(sheetObj.ColSaveName(Col) == "rd_crr_tp5"){
		if(check_rd_crr_tp(sheetObj, Value, sheetObj.CellValue(Row, "tm5"))) return false;

	}else if( sheetObj.ColSaveName(Col)=="junc_nm1" ) {
		if(check_junc(sheetObj, Value, sheetObj.CellValue(Row, "tm1"))) return false;
	}else if( sheetObj.ColSaveName(Col)=="junc_nm2" ) {
		if(check_junc(sheetObj, Value, sheetObj.CellValue(Row, "tm2"))) return false;
	}else if( sheetObj.ColSaveName(Col)=="junc_nm3" ) {
		if(check_junc(sheetObj, Value, sheetObj.CellValue(Row, "tm3"))) return false;
	}else if( sheetObj.ColSaveName(Col)=="junc_nm4" ) {
		if(check_junc(sheetObj, Value, sheetObj.CellValue(Row, "tm4"))) return false;
	}else if( sheetObj.ColSaveName(Col)=="junc_nm5" ) {
		if(check_junc(sheetObj, Value, sheetObj.CellValue(Row, "tm5"))) return false;

	}else if( sheetObj.ColSaveName(Col)=="tm1" ) {
		if(check_inv_bil(sheetObj, Row, isRail)) return false;
		if(check_agmt(sheetObj, sheetObj.CellValue(Row,"agmt_no1"), sheetObj.CellValue(Row,"agmt_ref_no1"), Value)) return false;
		if(check_rd_crr_tp(sheetObj, sheetObj.CellValue(Row,"rd_crr_tp1"), Value)) return false;
		if(check_junc(sheetObj, sheetObj.CellValue(Row,"junc_nm1"), Value)) return false;
	}else if( sheetObj.ColSaveName(Col)=="tm2" ) {
		if(check_inv_bil(sheetObj, Row, isRail)) return false;
		if(check_agmt(sheetObj, sheetObj.CellValue(Row,"agmt_no2"), sheetObj.CellValue(Row,"agmt_ref_no2"), Value)) return false;
		if(check_rd_crr_tp(sheetObj, sheetObj.CellValue(Row,"rd_crr_tp2"), Value)) return false;
		if(check_junc(sheetObj, sheetObj.CellValue(Row,"junc_nm2"), Value)) return false;
	}else if( sheetObj.ColSaveName(Col)=="tm3" ) {
		if(check_inv_bil(sheetObj, Row, isRail)) return false;
		if(check_agmt(sheetObj, sheetObj.CellValue(Row,"agmt_no3"), sheetObj.CellValue(Row,"agmt_ref_no3"), Value)) return false;
		if(check_rd_crr_tp(sheetObj, sheetObj.CellValue(Row,"rd_crr_tp3"), Value)) return false;
		if(check_junc(sheetObj, sheetObj.CellValue(Row,"junc_nm3"), Value)) return false;
	}else if( sheetObj.ColSaveName(Col)=="tm4" ) {
		if(check_inv_bil(sheetObj, Row, isRail)) return false;
		if(check_agmt(sheetObj, sheetObj.CellValue(Row,"agmt_no4"), sheetObj.CellValue(Row,"agmt_ref_no4"), Value)) return false;
		if(check_rd_crr_tp(sheetObj, sheetObj.CellValue(Row,"rd_crr_tp4"), Value)) return false;
		if(check_junc(sheetObj, sheetObj.CellValue(Row,"junc_nm4"), Value)) return false;
	}else if( sheetObj.ColSaveName(Col)=="tm5" ) {
		if(check_inv_bil(sheetObj, Row, isRail)) return false;
		if(check_agmt(sheetObj, sheetObj.CellValue(Row,"agmt_no5"), sheetObj.CellValue(Row,"agmt_ref_no5"), Value)) return false;
		if(check_rd_crr_tp(sheetObj, sheetObj.CellValue(Row,"rd_crr_tp5"), Value)) return false;
		if(check_junc(sheetObj, sheetObj.CellValue(Row,"junc_nm5"), Value)) return false;
        
	//  bkg_flg cheak => prio_seq is not 0.
	}else if(sheetObj.ColSaveName(Col) == "inlnd_rout_bkg_flg" ) {
		if(sheetObj.CellValue(Row,"prio_seq" ) == 0 ) {
			sheetObj.CellValue2(Row,"inlnd_rout_bkg_flg" ) = 0;
			ComShowMessage(ComGetMsg('PRD90089'));
			sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
			return false;
		}
	}else if(sheetObj.ColSaveName(Col) == "del_chk" ) {
		if(sheetObj.RowStatus(Row) == "D" && Value != 0){
			if(confirm(ComGetMsg('PRD90078'))){
			}else{
				sheetObj.CellValue2(Row, "del_chk") = 0;
			}
		}

	}else if(sheetObj.ColSaveName(Col) == "check" ) {
		if(sheetObj.RowStatus(Row) == "U"){
			sheetObj.RowStatus(Row) = "R";
		}
	}
        
}

function check_vndr(sheetObj, value ){
	if("105475 105484 108386 108386".indexOf(value) > -1 && sheetObj.CellValue(sheetObj.SelectRow,"wrs_full_cmdt") ==  1){
		ComShowMessage(ComGetMsg('PRD90086'));
		sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
		return true;
	}
	return false;
}

function check_inv_bil(sheetObj, Row, isRail){
	if(sheetObj.CellValue(Row,"inlnd_rout_inv_bil_patt_cd") == "" && sheetObj.CellValue(Row,"wrs_full_cmdt") ==  1 ){
		ComShowMessage(ComGetMsg('PRD90086'));
		sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
		return true;
	}else if(sheetObj.CellValue(Row,"inlnd_rout_inv_bil_patt_cd") == "" && isRail){
		ComShowMessage(ComGetMsg('PRD90017'));
		sheetObj.CellValue2(sheetObj.SelectRow, sheetObj.SelectCol) = "";
		sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
		return true;
	}else if(sheetObj.CellValue(Row,"rout_pln_cd") == "" && isRail){
		ComShowMessage(ComGetMsg('PRD90018'));
		sheetObj.CellValue2(sheetObj.SelectRow, sheetObj.SelectCol) = "";
		sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
		return true;
	}
	return false;
}

function check_agmt(sheetObj, value1, value2, tm){
	if(tm == "RD"){
		if(value1 == "" || value2 == "" ){
			//미주 Rail 일경우 AGMT NO(Reference No) 는 필수 입니다.
			ComShowMessage(ComGetMsg('PRD90037'));
			sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
			return true;
		}
	}else{
		if(value1 != "" || value2 != "" ){
			//미주 Rail 일경우만  AGMT NO(Reference No) 입력 가능 합니다.
			ComShowMessage(ComGetMsg('PRD90039'));
			sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
			return true;
		}
	}
	return false;
}
function check_rd_crr_tp(sheetObj, value, tm){
	if(value.substring(0, 1) == "T" && sheetObj.CellValue(sheetObj.SelectRow,"wrs_full_cmdt") ==  1){
		ComShowMessage(ComGetMsg('PRD90086'));
		sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
		return true;
	}else if(tm == "RD"){
		if(value == "" ){
			//미주 Rail 일경우 C/TOFC  는 필수 입니다.
			ComShowMessage(ComGetMsg('PRD90038'));
			sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
			return true;
		}
	}else{
		if(value != "" ){
			//미주 Rail 일경우만 C/TOFC  입력 가능 합니다.
			ComShowMessage(ComGetMsg('PRD90040'));
			sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
			return true;
		}
	}
	return false;
}

function check_junc(sheetObj, value, tm ){
	if(tm == "RD" && value == "" ){
		ComShowMessage(ComGetMsg('PRD90081'));
		//'Input data check Junction';
		sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
		return true;
	}else if(value != "" ){
		ComShowMessage(ComGetMsg('PRD90081'));
		//'Input data check Junction';
		sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
		return true;
	}
	return false;
}

  
    
/**
 * 시트에서 PRIORITY 팝업 호출
 * - ComOpenWindowCenter() 호출 : row, col 정보를 Parameter로 전달  
 */
function sheet1_OnPopupClick(sheetObj, row, col){   
	var param ;
	if( sheetObj.ColSaveName(col).indexOf("_node") > -1  ){
		param = "?loc_cd="+sheetObj.CellValue(row, col);
		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);

	}else if ( sheetObj.ColSaveName(col) == "prio_seq"
		|| (sheetObj.RowStatus(row) =="U"  && sheetObj.ColSaveName(col)=="wrs_full_cmdt" && sheetObj.CellValue(row,"wrs_full_cmdt") =="1" )) {
		var oriLoc   = sheetObj.CellValue(sheetObj.SelectRow ,"rout_org_nod_cd");
		var destLoc  = sheetObj.CellValue(sheetObj.SelectRow ,"rout_dest_nod_cd");
		var rout_seq = sheetObj.CellValue(sheetObj.SelectRow ,"rout_seq");
		var irgCd    = formObject.io_type[0].checked ? formObject.io_type[0].value : formObject.io_type[1].value;
		var typeCd   = formObject.node_type[0].checked ? formObject.node_type[0].value : formObject.node_type[1].value;
		param = '?f_cmd=' + SEARCH12 +'&i_org_cd='+ oriLoc +'&i_dest_cd='+destLoc+"&i_select_row=" + sheetObj.SelectRow + "&i_select_col=" + sheetObj.SelectCol+"&r_inbound="+irgCd+"&r_btn_irg_cd="+irgCd+"&r_btn_nod_ty_cd="+typeCd+"&rout_seq="+rout_seq;
		myWin = ComOpenWindowCenter('ESD_PRD_0058.do'+param, 'compop', 800, 480, false);
		myWin.focus();
             
	}else if ( sheetObj.ColSaveName(col).indexOf("vndr") > -1  ){
		var loc_cd_val = sheetObj.CellValue(row, col);
		var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
		param = "?pts_vndr_cd="+loc_cd_val+"&classId=COM_ENS_0C1";
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param , 620, 450, 'getVendor', dispaly, true, false, row, col, 1);
	}
   
}  
         

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObject,sAction){
	return true;
}
     