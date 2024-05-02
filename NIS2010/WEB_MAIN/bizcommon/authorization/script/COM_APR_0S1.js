/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COM_APR_0S1.js
*@FileTitle : Authorization Program Configuration
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.13
*@LastModifier : Sung Yoon Shim
*@LastVersion : 1.0
* 2014.07.13
* 1.0 Creation
* ----------------------------------------------------------
* History
=========================================================*/
/**
 * @extends
 * @class COM_APR_0S1 : COM_APR_0S1 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function COM_APR_0S1() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;



// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){

    var sheetObject = sheetObjects[0];
    
    /*******************************************************/
    var formObject = document.form;
    
    try {
		var srcName = window.event.srcElement.getAttribute("name");
		 

		switch (srcName) {

		case "btng_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
				
			break;
			
		case "btng_modify":
            var sRow = sheetObject.FindCheckedRow("checkbox");
            var arrRow = sRow.split("|");   
            var authPgmSeq = sheetObject.cellvalue(arrRow[0],"auth_pgm_seq");
            var authPgmBtnSeq = sheetObject.cellvalue(arrRow[0],"auth_pgm_btn_seq");
            var authPgmFldSeq = sheetObject.cellvalue(arrRow[0],"auth_pgm_fld_seq");
	    	var param = "COM_APR_0S2.do?auth_pgm_seq="+authPgmSeq+"&auth_pgm_btn_seq="+authPgmBtnSeq+"&auth_pgm_fld_seq="+authPgmFldSeq+"&modify=1";
	    	var url = "/hanjin/"+param;
	    	alert(url);
	    	ComOpenWindowCenter(url, "COM_APR_0S2",800, 300, '', 'none', true); 
	    	
	    	break;
	    	
		case "btng_create":
            var sRow = sheetObject.FindCheckedRow("checkbox");
            var arrRow = sRow.split("|");     
	    	var param = "COM_APR_0S2.do?";
	    	var url = "/hanjin/"+param;
	    	ComOpenWindowCenter(url, "COM_APR_0S2",800, 300, '', 'none', true); 
	    	
	    	break;
		}
		
    }catch(e) {
		if( e == "[object Error]") {
			showErrMessage(getMsg('CSR23028')); //ComShowMessage(OBJECT_ERROR);
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage() {
	
	
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);

        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    ComBtnDisable("btng_modify");
    
}


function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {
         case 1:      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 370;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false] 
                Editable = true;
                
                MultiSelection = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 10, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				 InitColumnInfo(18, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

				var HeadTitle1 = "|||||System||Menu||||Field|||Button|||App Type" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                sheetObj.FrozenCols = 2;
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");				
				InitDataProperty(0, cnt++ , dtCheckBox,           30,     daCenter , true,   "checkbox",     false,          "");
				InitDataProperty(0, cnt++ , dtHidden,			 150,	  daCenter,			false,    "auth_pgm_seq",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,			 150,	  daCenter,			false,    "auth_pgm_btn_seq",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,			 150,	  daCenter,			false,    "auth_pgm_fld_seq",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,				 150,	  daCenter,			false,    "sub_sys_cd",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,			 150,	  daCenter,			false,    "pgm_no",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,				 150,	  daCenter,			false,    "pgm_nm",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,			 150,	  daCenter,			false,    "pgm_use_flg",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,			 150,	  daCenter,			false,    "pgm_rmk",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,			 150, 	  daCenter,			false,    "pgm_fld_id",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,				 150, 	  daCenter,			false,    "pgm_fld_nm",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,			 150,	  daCenter,			false,    "fld_use_flg",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,			 150,	  daCenter,			false,    "pgm_btn_id",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,				 150,	  daCenter,			false,    "pgm_btn_nm",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,			 150,	  daCenter,			false,    "btn_use_flg",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtHidden,			 150,	  daCenter,			false,    "auth_apro_tp_cd",				false,			"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,				 150,	  daCenter,			false,    "auth_apro_tp_nm",				false,			"",			dfNone,			0,			false,			false	);
				
				
         	}
            break;
    }
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
       case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch("COM_APR_0S1GS.do", FormQueryString(formObj));
		    break;
		    
//       case IBSAVE:        //전송
//    	    
//			formObj.f_cmd.value = MULTI;
//			var param = sheetObj.GetSaveString(false,true,1);
//			var sXml = sheetObj.GetSaveXml("COM_CSR_0015GS.do", "f_cmd="+ComGetObjValue(formObj.f_cmd)+"&"+ param);
//			sheetObj.LoadSaveXml(sXml,true);
//			retrieve();
//            break;
      
    }
}

function retrieve() {	
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}

function sheet1_OnSearchEnd() {
	var sheetObj = sheetObjects[0];
	
	
	ComBtnDisable("btng_modify");
}

function sheet1_OnChange(sheetObj , row , col, value)
{
	var formObj = document.form;
	var sName = sheetObj.ColSaveName(col);
	var rows = sheetObj.Rows;

	//기존 로직 
	if (sName == "checkbox") {
			if(row > 0 && row < rows) {
								
				//한개 선택한 경우에만 Detail, Approval Step, Approval Step & Comments, Files, Disapprove 버튼 활성화
				if(sheetObj.CheckedRows("checkbox") == 1) {		  					
					ComBtnEnable("btng_modify");
				} else {
					ComBtnDisable("btng_modify");
				}
			}
	}
	
}

