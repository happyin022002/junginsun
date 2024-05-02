/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_SCE_0119.js
*@FileTitle : VSL SKD e-mailing Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.06 박준용
* 1.0 Creation
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;

document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			case "btn_delete":
				if( validateFormDel(sheetObj, formObj) ) {
					if(!confirm('Are you sure to delete?')) return false;
					doActionIBSheet(sheetObj,formObj,IBDELETE);					
				}				
				break;
			case "btn_save":
				if( validateForm(sheetObj, formObj) ) {
					doActionIBSheet(sheetObj,formObj,IBSAVE);
				}			
				break;
	  		case "btn_rowadd":
				doActionIBSheet(sheetObj,formObj,IBINSERT);
				break;
	  		case "btn_copy":
	  			rowCopy();
				break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(getMsg('COM12111')) ;
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
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj = document.form;
	var sheetObject= sheetObjects[0];
	
	doActionIBSheet(sheetObject,formObj,IBSEARCH);
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
                InitColumnInfo(35, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                var HeadTitle0 = "Chk|Customer\nCode|Lane\nCode|Port|Trans\nDur|Trans\nDur|Day|Day|Day|Day|Day|Day|Day|Time|e-mail Address" ;
                var HeadTitle1 = "Chk|Customer\nCode|Lane\nCode|Port|Trans\nDur|Trans\nDur|Sun|Mon|Tue|Wed|Thu|Fri|Sat|Time|e-mail Address" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 40, 	  daCenter,  true, 	  "chk", 			  false, 		  "", 	    dfNone, 		0, 	    true, 		true);//check box
                InitDataProperty(0, cnt++, dtData,	  150,      daLeft,  true,    "eml_grp_id",       false,          "",       dfNone,			0,     false,       true, 50);
                InitDataProperty(0, cnt++, dtData,	   50,    daCenter,  true,    "vsl_slan_cd",      false,          "",       dfEngUpKey,     	0,      true,       true, 3);
                InitDataProperty(0, cnt++, dtData,	   50,    daCenter,  true,    "to_port_cd",		  false,          "",       dfEngUpKey,     	0,      true,       true, 5);                
                InitDataProperty(0, cnt++, dtData,     45,    daCenter,  true,    "vskd_dur_id",      false,          "",       dfNone,     	0,      true,       true, 3);
                InitDataProperty(0, cnt++, dtData,     45,    daCenter,  true,    "unit",     		  false,          "",       dfNone,     	0,     false,      false, 5);                
				InitDataProperty(0, cnt++, dtCheckBox, 45,    daCenter,  true,    "eml_snd_dys_ctnt_sun", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtCheckBox, 45,    daCenter,  true,    "eml_snd_dys_ctnt_mon", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtCheckBox, 45,    daCenter,  true,    "eml_snd_dys_ctnt_tue", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtCheckBox, 45,    daCenter,  true,    "eml_snd_dys_ctnt_web", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtCheckBox, 45,    daCenter,  true,    "eml_snd_dys_ctnt_thr", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtCheckBox, 45,    daCenter,  true,    "eml_snd_dys_ctnt_fri", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtCheckBox, 45,    daCenter,  true,    "eml_snd_dys_ctnt_sat", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtCombo,	   45,    daCenter,  true,    "eml_snd_hr",       false,          "",       dfNone,     	0,      true,       true, 2);
				InitDataProperty(0, cnt++, dtData,	  100,    daCenter,  true,    "subsc_eml",     	  false,          "",       dfNone,     	0,      true,       true, 4000);
				InitDataProperty(0, cnt++, dtStatus,    0,    daCenter,  true,    "ibflag",  		  false,    	  "",  		dfNone,     	0,      true,   	true, 0);
				InitDataProperty(0, cnt++, dtHidden,    0,    daCenter,  true,    "eml_jb_id",     	  false,          "",       dfNone,     	0,     false,       true, 20);
				InitDataProperty(0, cnt++, dtHidden,    0,    daCenter,  true,    "svc_st_dt",     	  false,          "",       dfNone,     	0,     false,       true, 8);
				InitDataProperty(0, cnt++, dtHidden,    0,    daCenter,  true,    "svc_end_dt",       false,          "",       dfNone,     	0,     false,       true, 8);
				InitDataProperty(0, cnt++, dtHidden,    0,    daCenter,  true,    "eml_grp_id_his",   false,          "",       dfNone,			0,      true,       true, 20);
				InitDataProperty(0, cnt++, dtHidden,    0,    daCenter,  true,    "eml_snd_hr_his",   false,          "",       dfNone,			0,      true,       true, 2);
				InitDataProperty(0, cnt++, dtHidden, 	0,    daCenter,  true,    "eml_snd_dys_ctnt_sun_his", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtHidden, 	0,    daCenter,  true,    "eml_snd_dys_ctnt_mon_his", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtHidden, 	0,    daCenter,  true,    "eml_snd_dys_ctnt_tue_his", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtHidden, 	0,    daCenter,  true,    "eml_snd_dys_ctnt_web_his", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtHidden, 	0,    daCenter,  true,    "eml_snd_dys_ctnt_thr_his", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtHidden, 	0,    daCenter,  true,    "eml_snd_dys_ctnt_fri_his", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtHidden, 	0,    daCenter,  true,    "eml_snd_dys_ctnt_sat_his", false,          "",       dfNone,     	0,      true,       true, 50);
				InitDataProperty(0, cnt++, dtHidden,    0,    daCenter,  true,    "vsl_slan_cd_his",      false,          "",       dfNone,     	0,      true,       true, 3);
                InitDataProperty(0, cnt++, dtHidden,    0,    daCenter,  true,    "to_port_cd_his",		  false,          "",       dfNone,     	0,      true,       true, 5);
                InitDataProperty(0, cnt++, dtHidden,    0,    daCenter,  true,    "fm_port_cd_his",		  false,          "",       dfNone,     	0,      true,       true, 5);
                InitDataProperty(0, cnt++, dtHidden,    0,    daCenter,  true,    "eml_grp_cd_desc_his",  false,          "",       dfNone,     	0,      true,       true, 4000);
                InitDataProperty(0, cnt++, dtHidden,    0,    daCenter,  true,    "vskd_dur_id_his",      false,          "",       dfNone,     	0,      true,       true, 3);
                InitDataProperty(0, cnt++, dtHidden,	0,    daCenter,  true,    "subsc_seq_his",     	  false,          "",       dfNone,     	0,      true,       true, 100);
                InitDataProperty(0, cnt++, dtHidden,	0,    daCenter,  true,    "subsc_eml_his",     	  false,          "",       dfNone,     	0,      true,       true, 4000);
				
				sheetObj.ColHidden("ibflag") = true;
				InitDataCombo(0, 'eml_snd_hr', " |00|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23", " |00|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23");
				
                style.height = GetSheetHeight(16) ;
           }
            break;

    }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:	  //조회
			formObj.f_cmd.value = SEARCH01;
	        sheetObj.DoSearch4Post("ESD_SCE_0119GS.do", SceFrmQryString(formObj));
			break;
		case IBINSERT:
			var row = 0;
			row = sheetObj.DataInsert(-1);
			sheetObj.CellValue2(row, "unit") = "days";									
			break;
		case IBDELETE:
			formObj.f_cmd.value = REMOVE01;
			sheetObj.DoSave("ESD_SCE_0119GS.do", SceFrmQryString(formObj), "chk", false, true);
			break;
		case IBSAVE:
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESD_SCE_0119GS.do", SceFrmQryString(formObj), -1, false, true);
			break;
	}
}

/**
 * Sheet에서 Change 이벤트를 발생시킴.
 */
function sheet_OnChange (sheetObj , row , col ){
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	
	switch(colName){
		case('eml_grp_id'):
			for(var i = 2; i < sheetObj.RowCount+2; i++){
				if( sheetObjects[0].CellValue(i, "eml_grp_id") == sheetObjects[0].CellValue(row, "eml_grp_id") && row != i){
					sheetObjects[0].CellValue2(row, "svc_st_dt") = sheetObjects[0].CellValue(i, "svc_st_dt");
					sheetObjects[0].CellValue2(row, "eml_grp_id_his") = sheetObjects[0].CellValue(i, "eml_grp_id");
					sheetObjects[0].CellValue2(row, "eml_snd_hr_his") = sheetObjects[0].CellValue(i, "eml_snd_hr");
					sheetObjects[0].CellValue2(row, "eml_snd_dys_ctnt_sun_his") = sheetObjects[0].CellValue(i, "eml_snd_dys_ctnt_sun");
					sheetObjects[0].CellValue2(row, "eml_snd_dys_ctnt_mon_his") = sheetObjects[0].CellValue(i, "eml_snd_dys_ctnt_mon");
					sheetObjects[0].CellValue2(row, "eml_snd_dys_ctnt_tue_his") = sheetObjects[0].CellValue(i, "eml_snd_dys_ctnt_tue");
					sheetObjects[0].CellValue2(row, "eml_snd_dys_ctnt_web_his") = sheetObjects[0].CellValue(i, "eml_snd_dys_ctnt_web");
					sheetObjects[0].CellValue2(row, "eml_snd_dys_ctnt_thr_his") = sheetObjects[0].CellValue(i, "eml_snd_dys_ctnt_thr");
					sheetObjects[0].CellValue2(row, "eml_snd_dys_ctnt_fri_his") = sheetObjects[0].CellValue(i, "eml_snd_dys_ctnt_fri");
					sheetObjects[0].CellValue2(row, "eml_snd_dys_ctnt_sat_his") = sheetObjects[0].CellValue(i, "eml_snd_dys_ctnt_sat");
					
					if( sheetObj.CellValue(i, "subsc_eml_his") != "" ){
						sheetObj.CellValue2(row, "svc_end_dt") = "COPY";	
					}
					break;
				}else{
					sheetObj.CellValue2(row, "svc_end_dt") = "";
				}
			}
		break;
	
		case('vsl_slan_cd'):	
			formObj.laneCdVerify.value = sheetObj.CellValue(row, "vsl_slan_cd").toUpperCase();
			sheetObj.CellValue2(row, "vsl_slan_cd") = formObj.laneCdVerify.value;
			formObj.f_cmd.value = SEARCH02;
        	sheetObj.DoSearch4Post("ESD_SCE_0119GS.do", SceFrmQryString(formObj));
		break;
		
		case('to_port_cd'):
			formObj.portCdVerify.value = sheetObj.CellValue(row, "to_port_cd").toUpperCase();
			sheetObj.CellValue2(row, "to_port_cd") = formObj.portCdVerify.value;
			formObj.f_cmd.value = SEARCH03;
        	sheetObj.DoSearch4Post("ESD_SCE_0119GS.do", SceFrmQryString(formObj));
		break;
		
		case('eml_snd_hr'):
			if( sheetObj.CellValue(row, "eml_snd_hr") == "" ){
				for(var i = 2; i < sheetObj.RowCount+2; i++){
					if( sheetObj.CellValue(row, "eml_grp_id") != "" && 
						sheetObj.CellValue(row, "eml_grp_id") == sheetObj.CellValue(i, "eml_grp_id") ){
						sheetObj.CellValue(i, "eml_snd_hr") = "";
					}
				}
			}else{
				for(var i = 2; i < sheetObj.RowCount+2; i++){
					if( sheetObj.CellValue(row, "eml_grp_id") != "" &&
						sheetObj.CellValue(row, "eml_grp_id") == sheetObj.CellValue(i, "eml_grp_id") ){
						sheetObj.CellValue(i, "eml_snd_hr") = sheetObj.CellValue(row, "eml_snd_hr");
					}
				}
			}	
		break;
		
		case('eml_snd_dys_ctnt_sun'):
		case('eml_snd_dys_ctnt_mon'):
		case('eml_snd_dys_ctnt_tue'):
		case('eml_snd_dys_ctnt_web'):
		case('eml_snd_dys_ctnt_thr'):
		case('eml_snd_dys_ctnt_fri'):
		case('eml_snd_dys_ctnt_sat'):
			if( sheetObj.CellValue(row, col) == "" ){
				for(var i = 2; i < sheetObj.RowCount+2; i++){
					if( sheetObj.CellValue(row, "eml_grp_id") != "" && 
						sheetObj.CellValue(row, "eml_grp_id") == sheetObj.CellValue(i, "eml_grp_id") ){
						sheetObj.CellValue(i, col) = "";
					}
				}
			}else{
				for(var i = 2; i < sheetObj.RowCount+2; i++){
					if( sheetObj.CellValue(row, "eml_grp_id") != "" &&
						sheetObj.CellValue(row, "eml_grp_id") == sheetObj.CellValue(i, "eml_grp_id") ){
						sheetObj.CellValue(i, col) = "1";
					}
				}
			}			
		break;
	}
}

function sheet_OnDblClick(sheetObj, row, col ){
var colName = sheetObj.ColSaveName(col);
	
	switch(colName){
		case('eml_grp_id'):
			var newWin = window.showModalDialog("ESD_SCE_0062.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:500px");
		break;
	
		case('vsl_slan_cd'):
			sUrl = "/hanjin/VOP_VSK_0202.do?vsl_slan_cd=" + sheetObj.CellValue(row, "vsl_slan_cd");
			ComOpenPopup(sUrl, 422, 470, "returnLaneCdHelp", "0,0", true);
		break;
		
		case('to_port_cd'):
			openLocPopSheet(sheetObj, row, false, "to_port_cd");
		break;
		
		case('subsc_eml'):
			var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+sheetObj.CellValue(row, "subsc_eml"), window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
		break;
	}
}

function openESD009Screen(cs_grp_id, tp_id, grp_nm){
	var sRow = "";
	var sheetObj = sheetObjects[0];
	
	sRow = sheetObj.SelectRow; 
	
	if( sheetObj.CellValue(sRow, "eml_grp_id_his") == "" ){
		sheetObj.CellValue(sRow, "eml_grp_id") = grp_nm.substring(0, 50);		
	}	
}

function openfunction(){
	var formObject = document.form;
	
	formObject.action = "ESD_SCE_0119.do";
	
	formObject.f_cmd.value = "" ;
    formObject.submit();
}

/**
 * [Lane Code] Button Click 후 Pop-up에서 호출.
 * @param rtnObjs
 * @return
 */
function returnLaneCdHelp(rtnObjs){
	var sRow = "";
	var sheetObj = sheetObjects[0];
	
	sRow = sheetObj.SelectRow; 
	
	if(rtnObjs){
		var rtnDatas = rtnObjs[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				sheetObj.CellValue2(sRow, "vsl_slan_cd") = rtnDatas[1];				
			}
		}
	}
}

function addValueNo(dist, multi_value){
	var sRow = "";
	var sheetObj = sheetObjects[0];
	
	sRow = sheetObj.SelectRow; 
	
	var multis = multi_value.split('\n');

	multi_value = '';
	for(var i = 0 ; i < multis.length ; i++){
		if(multis[i] != ''){
			if(i == 0){
				multi_value = multis[i];
			}else{
				multi_value = multi_value + ';' + multis[i];
			}
   		}
	}
	
	if(multi_value != ''){
		sheetObj.CellValue(sRow, "subsc_eml") = multi_value.replace(/\r/gi, '');
	}
}

/**
 * save시 중복 여부 체크
 */
function validateForm(sheetObj, formObj){
	var firstVal = "";
	var SecondVal = "";
	var rowCur = 2;
	
	for(var i = 0; i < sheetObj.Rows-2; i++){
		firstVal = sheetObj.CellValue(Number(rowCur+i),'eml_grp_id') + sheetObj.CellValue(Number(rowCur+i),'vsl_slan_cd')
					+ sheetObj.CellValue(Number(rowCur+i),'to_port_cd') + sheetObj.CellValue(Number(rowCur+i),'vskd_dur_id')
					+ sheetObj.CellValue(Number(rowCur+i),'eml_snd_hr') + sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_sun')
					+ sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_mon') + sheetObj.CellValue(Number(rowCur+i),'vskd_dur_id')
					+ sheetObj.CellValue(Number(rowCur+i),'to_port_cd') + sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_tue')
					+ sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_web') + sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_thr')
					+ sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_fri') + sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_sat');
		
		if( sheetObj.CellValue(Number(rowCur+i),'eml_grp_id') == "" ) {
			errMsg = sheetObj.CellValue(0,'eml_grp_id') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;				
		}else if( sheetObj.CellValue(Number(rowCur+i),'vsl_slan_cd') == "" ){
			errMsg = sheetObj.CellValue(0,'vsl_slan_cd') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}else if( sheetObj.CellValue(Number(rowCur+i),'to_port_cd') == "" ){
			errMsg = sheetObj.CellValue(0,'to_port_cd') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}else if( sheetObj.CellValue(Number(rowCur+i),'vskd_dur_id') == "" ){
			errMsg = sheetObj.CellValue(0,'vskd_dur_id') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}else if( sheetObj.CellValue(Number(rowCur+i),'eml_snd_hr') == "" ){
			errMsg = sheetObj.CellValue(0,'eml_snd_hr') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}else if( sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_sun') == "" &&
				  sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_mon') == "" &&
				  sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_tue') == "" &&
				  sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_web') == "" &&
				  sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_thr') == "" &&
				  sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_fri') == "" &&
				  sheetObj.CellValue(Number(rowCur+i),'eml_snd_dys_ctnt_sat') == "" ){
			errMsg = sheetObj.CellValue(0,'eml_snd_dys_ctnt_sun') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}else if( sheetObj.CellValue(Number(rowCur+i),'subsc_eml') == "" ){
			errMsg = sheetObj.CellValue(0,'subsc_eml') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}
		
		for(var j = i+1; j < sheetObj.Rows-2; j++){
			SecondVal = sheetObj.CellValue(Number(rowCur+j),'eml_grp_id') + sheetObj.CellValue(Number(rowCur+j),'vsl_slan_cd')
						+ sheetObj.CellValue(Number(rowCur+j),'to_port_cd') + sheetObj.CellValue(Number(rowCur+j),'vskd_dur_id')
						+ sheetObj.CellValue(Number(rowCur+j),'eml_snd_hr') + sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_sun')
						+ sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_mon') + sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_tue')
						+ sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_web') + sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_thr')
						+ sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_fri') + sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_sat');
						
			if( sheetObj.CellValue(Number(rowCur+j),'eml_grp_id') == "" ) {
				errMsg = sheetObj.CellValue(0,'eml_grp_id') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;				
			}else if( sheetObj.CellValue(Number(rowCur+j),'vsl_slan_cd') == "" ){
				errMsg = sheetObj.CellValue(0,'vsl_slan_cd') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}else if( sheetObj.CellValue(Number(rowCur+j),'to_port_cd') == "" ){
				errMsg = sheetObj.CellValue(0,'to_port_cd') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}else if( sheetObj.CellValue(Number(rowCur+j),'vskd_dur_id') == "" ){
				errMsg = sheetObj.CellValue(0,'vskd_dur_id') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}else if( sheetObj.CellValue(Number(rowCur+j),'eml_snd_hr') == "" ){
				errMsg = sheetObj.CellValue(0,'eml_snd_hr') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}else if( sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_sun') == "" &&
					  sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_mon') == "" &&
					  sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_tue') == "" &&
					  sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_web') == "" &&
					  sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_thr') == "" &&
					  sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_fri') == "" &&
					  sheetObj.CellValue(Number(rowCur+j),'eml_snd_dys_ctnt_sat') == "" ){
				errMsg = sheetObj.CellValue(0,'eml_snd_dys_ctnt_sun') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}else if( sheetObj.CellValue(Number(rowCur+j),'subsc_eml') == "" ){
				errMsg = sheetObj.CellValue(0,'subsc_eml') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}
			
			if( firstVal != "" || SecondVal != "" ){
				if( firstVal == SecondVal ){				
					errMsg = sheetObj.CellValue(i,'eml_grp_id') + " duplicated. Please remain one of them.";
					ComShowMessage(errMsg.replace(/\n/gi, ' '));
					return false;	
				}				
			}			
		}
	}
	return true;
}

/**
 * 삭제시 CHECK가 되어있는지 유효성검증 프로세스 처리
 */
function validateFormDel(sheetObj, formObj){
	if( sheetObj.CheckedRows("chk") < 1 ) {
		errMsg = "Please Retrieve First";
		ComShowMessage(errMsg);
		return false;
	}
	
	var checkList = sheetObj.FindCheckedRow('chk');
	var checkArray = checkList.split('|');
	
	for (ir = checkArray.length-2; ir >=0 ; ir--) {
		if( sheetObj.CellEditable(checkArray[ir], "eml_grp_id") ){
			sheetObj.RowDelete(checkArray[ir], false);
	  	}
  	}
	
	if( sheetObj.CheckedRows("chk") < 1 ){
		return false;
	}
	
	return true;
}

function sheet_OnSaveEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
	} else {
		var formObj = document.form;
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
}

function sheet_OnSearchEnd(sheetObj,errMsg) {
	var formObj = document.form;
	
	if( errMsg.length > 0 ) {
		if( formObj.f_cmd.value == SEARCH02 ){
			sheetObj.CellValue2(sheetObj.SelectRow, "vsl_slan_cd") = "";
		}else if( formObj.f_cmd.value == SEARCH03 ){
			sheetObj.CellValue2(sheetObj.SelectRow, "to_port_cd") = "";
		}
	}
}

/**
 * Row Copy
 */
function rowCopy(){
	sheetObjects[0].DataCopy();
	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "eml_grp_id") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "eml_grp_id");
	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "svc_end_dt") = "COPY";
	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "vsl_slan_cd_his") = "";
	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "to_port_cd_his") = "";
	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "vskd_dur_id_his") = "";
	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "subsc_seq_his") = "";
	sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "subsc_eml_his") = "";
}