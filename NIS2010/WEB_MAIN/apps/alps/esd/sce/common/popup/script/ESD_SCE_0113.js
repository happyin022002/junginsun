/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0113.js
*@FileTitle : Exception Office Mapping/Office팝업
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2008-08-06 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 var sheetObjects = new Array();
var sheetCnt = 0;
var selRow = 0;
var selCol = 0;
var selOfc = "";

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
	var dist=document.form.dist.value;
/*	
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1,dist);

		ComEndConfigSheet(sheetObjects[i]);
	}
*/	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1,dist);
            ComEndConfigSheet(sheetObjects[i]);
        }

        var sheetObject = sheetObjects[0];
        var formObject = document.form;
      	doActionIBSheet(sheetObject,formObject,IBSEARCH);	
	
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {

    	    case "btn_retrieve":
    	    	//if( validateForm(formObject) ){
		            doActionIBSheet(sheetObject,formObject,IBSEARCH);
		        //}
    	        break;

    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;

            case "btn_close":
	            self.close();
    	        break;

			case "btn_ok":
				PopupOK(sheetObject, formObject);
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

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo,dist) {		
    var cnt = 0;

    switch(sheetNo) {
        case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(10) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 50);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    if(dist=="popmstofccd"){
                        var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                    }else if(dist=="mstofccd"){
                        var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                    }else if(dist=="mapgofccd"){
                        var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                    }

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					if(dist=="popmstofccd"){
	                    InitDataProperty(0, cnt++ , dtRadioCheck,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);                    
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      200,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                    	InitDataProperty(0, cnt++ , dtHidden,      10,    daCenter,  true,    "mst_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
					}else if(dist=="mstofccd"){
	                    InitDataProperty(0, cnt++ , dtRadioCheck,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);                    
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      200,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                    	InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mst_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
                    }else if(dist=="mapgofccd"){
	                    InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);                    
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      200,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                    	InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mapg_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
                    }               
                    


               }
            break;
        case 9:      //IBSheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = GetSheetHeight(10) ;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 50);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(6, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)
                if(dist=="popmstofccd"){
                    var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                }else if(dist=="mstofccd"){
                    var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                }else if(dist=="mapgofccd"){
                    var HeadTitle = "|SEQ|Office|Office Name|Location" ;
                }

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, false);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
                InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);
                    if(dist=="popmstofccd"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mst_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
                    }else if(dist=="mstofccd"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mst_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
                    }else if(dist=="mapgofccd"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mapg_ofc_cd",        false,          "",       dfNone,       0,     false,       false);
                    }  
                

           }
            break;

    }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH04;

			//delHypen(formObj.sdate);
			//delHypen(formObj.edate);
			sheetObj.DoSearch4Post("ESD_SCE_0113GS.do", SceFrmQryString(formObj));
			break;
	   case IBDOWNEXCEL:        //엑셀 다운로드
		  sheetObj.Down2Excel(-1, false, false, true);
		  break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
/*--
function validateForm(formObj){
    with(formObj){
 	    if(formObj.sdate.value=="" || formObj.edate.value=="") {
  	        ComShowMessage("You must input period");

  	        if(formObj.sdate.value=="" || !chkDateValue(formObj.sdate.value) )  {
  	          //setFocus(formObj.sdate);
  	          formObj.sdate.focus() ;
  	          return false;
  	        }

  	        if(formObj.edate.value=="" || !chkDateValue(formObj.edate.value) ) {
  	          //setFocus(formObj.edate);
  	          formObj.edate.focus() ;
  	          return false;
  	        }
  	    }

  	    if( formObj.seletad.value == "ETA" ){
	  	    if(formObj.selpod.value=="") {
	  	        ComShowMessage("You must input POD");
	  	        //setFocus(formObj.selpod);
	  	        formObj.selpod.focus() ;
	  	        return false;
	  	    }
  	    } else{
	  	    if(formObj.selpol.value=="") {
	  	        ComShowMessage("You must input POL");
	  	        //setFocus(formObj.selpol);
	  	        formObj.selpol.focus() ;
	  	        return false;
	  	    }
  	    }
    }

    return true;
}
--*/

// mapping office팝업창에서 ok버튼 클릭시
function PopupOK(sheetObj, formObject){

	var rcc_val	   = "";	// Target Object에 세팅할 값
	var lcc_val	   = "";
	
	var rows = sheetObj.Rows;
	var iCheckRow = sheetObj.CheckedRows("check");
	//var dist = sheetObj.ColSaveName(5);	
	var dist=document.form.dist.value;
	var opener = window.dialogArguments;
	
	if(rows==1 && iCheckRow == 0) {
		return null;
	}else if(rows > 1 && iCheckRow == 0) {
		ComShowMessage("Please check row") ;
		return null;
	}
	else {
		var ik = 0;
  		if(dist=="popmstofccd"){
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				popmstofc_val = sheetObj.CellValue(i, "ofc_cd");
	
		  			} else {
		  				popmstofc_val = popmstofc_val + "," + sheetObj.CellValue(i, "ofc_cd");
	                }
	                ik++;
	     		}
	  		}
		}else if(dist=="mstofccd"){
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				mstofc_val = sheetObj.CellValue(i, "ofc_cd");
	
		  			} else {
		  				mstofc_val = mstofc_val + "," + sheetObj.CellValue(i, "ofc_cd");
	                }
	                ik++;
	     		}
	  		}		
		}else if(dist=="mapgofccd"){
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				mapgofc_val = sheetObj.CellValue(i, "ofc_cd");
		  				mapgofcnm_val = sheetObj.CellValue(i, "ofc_eng_nm");
		  				mapgloccd_val = sheetObj.CellValue(i, "loc_cd");
	
		  			} else {
		  				mapgofc_val = mapgofc_val + "," + sheetObj.CellValue(i, "ofc_cd");
		  				mapgofcnm_val = mapgofcnm_val + "|" + sheetObj.CellValue(i, "ofc_eng_nm");
		  				mapgloccd_val = mapgloccd_val + "," + sheetObj.CellValue(i, "loc_cd");		  				
	                }
	                ik++;
	     		}
	  		}		
		}							
  	}
  	
  	if(dist=="popmstofccd"){
  	  	opener.popmst_ofc_code(popmstofc_val);
  	}else if(dist=="mstofccd"){
   	  	opener.mst_ofc_code(mstofc_val); 	  	  	   	  	
  	}else if(dist=="mapgofccd"){
   	  	opener.mapg_ofc_code(mapgofc_val,mapgofcnm_val,mapgloccd_val,iCheckRow); 	  	  	   	  	
  	}
  	self.close();

}