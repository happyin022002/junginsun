/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0112.js
*@FileTitle : Exception Office Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2008-08-06 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

                case "dbtn_retrieve":
                    doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
                    break;

			    			case "btn_new":
			    				sheetObject.RemoveAll();
			    				formObject.reset();
			    				break;
			
			    			case "dbtn_new":
			    				sheetObject2.RemoveAll();
			    				formObject.reset();
			    				break;
	
	        	    case "dbtn_save":
	        	               //alert("dbtn_save");
	        	               //if(validationSAVE(sheetObject2){
	        	               //    alert("dbtn_save OK");
	    	                       doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC02);
	        	               //}
	
	        	        break;
	
	        	    case "dbtng_rowadd":
	    	            doActionIBSheet(sheetObject2,formObject,IBINSERT);
	        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
				ComShowCodeMessage('COM12111') ;
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
                    style.height = 400 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                    InitHeadMode(true, true, true, true, false,false);

                    //var HeadTitle = "Del.|STS|Exception Type|Description|Exception Category" ;
										var HeadTitle = "SEQ|Office|Office Name|Office Type|Location" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   // InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,       40,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      190,    daCenter,  false,    "ofc_eng_nm",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "ofc_type",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,       0,     false,       true);
                		InitDataProperty(0, cnt++ , dtHidden,      116,    daCenter,  true,    "mst_ofc_cd",        false,          "",       dfNone,       0,     false,       false);


                    var nums    = "1234567890" ;
                    var spChars = "!@#$%^&*()_+<>?,./'\" " ;

                    InitDataValid(0, 2, vtEngOther, nums);
                    InitDataValid(0, 3, vtEngOther, nums + spChars);
                    InitDataValid(0, 4, vtEngOther, nums + spChars);

                    //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
                    //InitDataCombo (0, "r_act_flg", "Y|N", "Y|N");
               }
                break;
            case 2:      //IBSheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    style.height = 400 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 16, 200);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                     InitHeadMode(true, true, true, true, false,false);

										//var HeadTitle1 = "Del.|SEQ|Office|Mapping Office|Mapping Office Name|Mapping Location|User ID|Created Date" ;
										var HeadTitle1 = "Del.|SEQ|Office|Mapping Office|Mapping Office Name|Mapping Location" ;
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtSeq,           50,    daCenter,   true,    "f_seq",               false,         "",       dfNone,   	0,          true,       true);
										InitDataProperty(0, cnt++ , dtDelCheck,      40,    daCenter,   true,   "fDelCheck",           false,         "",       dfNone,   	0,          true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,           40,    daCenter,   true,    "f_seq",               false,         "",       dfNone,   	0,          true,       true);
										InitDataProperty(0, cnt++ , dtData,	    70,	daLeft,	true,	"f_ofc_cd",     false,          "",       dfNone,   	0,			false,       true);
										//InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,	"f_ofc_nm",		false,          "",       dfNone,   	0,			false,       false,		300);
										InitDataProperty(0, cnt++ , dtData,		100,	    daLeft,	false,	"f_mapg_ofc_cd", false,          "",       dfNone,   	0,			false,       true,		300);
										InitDataProperty(0, cnt++ , dtData,			190,	daLeft,		true,	"f_mapg_ofc_nm",		false,          "",       dfEngKey,   0,			false,       true,		300);
                    InitDataProperty(0, cnt++ , dtData,			70,	daLeft,		true,	"f_loc_cd",	false,          "",       dfEngKey,	0,			false,       true,		500);
										//InitDataProperty(0, cnt++ , dtData,			100,	daLeft,	true,	"f_usr_id",	         	false,         "",       dfNone,   	0,			false,     false,		20);
										//InitDataProperty(0, cnt++ , dtData,			150,	daLeft,	true,	"r_cre_dt",		        false,         "",       dfNone,   	0,			false,     false,		20);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,        30,    daCenter,   true,   "f_ibflag",            false,         "",       dfNone,   	0,          true,       true);

                    var nums    = "1234567890" ;
                    var spChars = "!@#$%^&*()_+<>?,./'\" " ;
               }
                break;
        }
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
/*
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
      	doActionIBSheet(sheetObject,formObject,IBSEARCH);
*/
    }



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var sheetObject2 = sheetObjects[1];
        switch(sAction) {
					
           case IBSEARCH:      //조회
           	    formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESD_SCE_0112Search.do", SceFrmQryString(formObj));

                break;

           case IBINSERT:      // 입력
                 sheetObj.DataInsert(-1);
                 sheetObj.CellValue2(sheetObj.SelectRow, "f_ofc_cd") = formObj.mst_ofc_cd.value;
                break;

           case IBDOWNEXCEL:        //엑셀 다운로드

              sheetObj.Down2Excel(-1, false, false, true);
              break;

           case IBSEARCH_ASYNC01:
           		  formObj.f_cmd.value = SEARCH01;
           		  sheetObj.DoSearch4Post("ESD_SCE_0112GS2.do", SceFrmQryString(formObj));
              break;

           case IBSEARCH_ASYNC02:
							if(validateForm(sheetObj,formObj,sAction)){
								//alert("SceFrmQryString(formObj)-->"+SceFrmQryString(formObj));
                formObj.f_cmd.value = MULTI01;
                sheetObj.DoSave("ESD_SCE_0112GS2.do", SceFrmQryString(formObj));
                formObj.f_cmd.value = SEARCH01;//03 -> 01
                sheetObj.DoSearch4Post("ESD_SCE_0112GS2.do", SceFrmQryString(formObj));
              }
              break;
           case IBSEARCH_ASYNC03:
           			formObj.f_cmd.value = SEARCH03;
                sheetObj.DoSearch4Post("ESD_SCE_0112GS2.do", SceFrmQryString(formObj));
              break;

        }
    }

    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg==""){
			var formObj = document.form ;
			doActionIBSheet(sheetObj,formObj,IBSEARCH) ;
			doActionIBSheet(sheetObj, null, formObj, IBSEARCH) ;
			ComShowCodeMessage('SCE90005') ;
		}
	}

    function sheet1_OnDblClick(sheetObj,Row,Col){
      if(Col>0){
      	  var mst_ofc_cd=sheetObj.CellValue(Row,1);
          document.form.f_ofc_cd.value=mst_ofc_cd;
          doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC03);
      }
    }


// Office 팝업 &&&
function openOfcPopUp(multi, dist){
	if(dist=="mapgofccd"){
		var addpara = '&txtmstofccd='+document.form.mapg_ofc_cd.value;
	}else{
		var addpara = '&txtmstofccd='+document.form.mst_ofc_cd.value;
	}
//	window.open ("ESD_SCE_0113.do?dist="+dist+addpara, "list", "scrollbars=no,fullscreen=no,width=600,height=420");
	var newWin = window.showModalDialog("ESD_SCE_0113.do?dist="+dist+addpara, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:600px");
}

// ESD_SCE_0113.js에서 master office code PopupOK함수에서 호출 &&&
function mst_ofc_code(strval) {
	document.form.mst_ofc_cd.value = strval;
    document.form.f_ofc_cd.value = strval;
    var sheetObject = sheetObjects[0];
    var formObject = document.form;
    if(strval==""){
    }else{
  		doActionIBSheet(sheetObject,formObject,IBSEARCH);
  	}
}

// ESD_SCE_0113.js에서 mapg office code PopupOK함수에서 호출 &&&
function mapg_ofc_code(mapgofc_val,mapgofcnm_val,mapgloccd_val,iCheckRow){
		//alert("mapg_ofc_code : " + "mapgofc_val == " + mapgofc_val + ", mapgofcnm_val == " + mapgofcnm_val + ", mapgloccd_val == " + mapgloccd_val + ", iCheckRow == " + iCheckRow);
		var sheetObject = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];
    var rows = sheetObject2.Rows;
//    if(rows==2){
//    	var rows=rows-1;
//    }
		
   	for(i=1; i<=iCheckRow; i++){
   		sheetObject2.DataInsert(-1);
   	}

		var split_mapgofc_val = mapgofc_val.split(",");
		var split_mapgofcnm_val = mapgofcnm_val.split("|");
		var split_mapgloccd_val = mapgloccd_val.split(",");

   	for(i=0; i<iCheckRow; i++){
   		
   		sheetObject2.CellValue2(rows+i,2)=document.form.f_ofc_cd.value;
   		sheetObject2.CellValue2(rows+i,3)=split_mapgofc_val[i];
   		sheetObject2.CellValue2(rows+i,4)=split_mapgofcnm_val[i];
   		sheetObject2.CellValue2(rows+i,5)=split_mapgloccd_val[i];
   	}
//   	alert("CheckRow = "  + iCheckRow);
//  	if (iCheckRow == 0 && sheetObject.RowCount == 1) {
//  		document.form.mapg_ofc_cd.value = mapgofc_val;
//  		alert("bb");
//  	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){

			var row           = null ;
			//var copExptTpCD   = null ;
			var chgRows       = sheetObj.FindStatusRow("I|U").split(";") ;
			var chgRows2       = sheetObj.FindStatusRow("D").split(";") ;

			var all_rowcnt = sheetObj.RowCount;
			//alert("all_rowcnt-->"+all_rowcnt);
			//alert("chgRows-->"+chgRows);
			//alert("chgRows2-->"+chgRows2);
			if(all_rowcnt=="0"){
				return false;
			}
			for( var i = 1; i <= all_rowcnt; i++ ){
				if( i != 0 ) {

					if(sheetObj.CellValue(i, 'f_ofc_cd') == "" ){
						ComShowMessage('Input  Office!');
						sheetObj.SelectCell(i, 'f_ofc_cd');
						return false;
					}
					if(sheetObj.CellValue(i, 'f_mapg_ofc_cd') == "" ){
						ComShowMessage('Input  Mapping Office!');
						sheetObj.SelectCell(i, 'f_mapg_ofc_cd');
						return false;
					}
					/*
					if(sheetObj.CellValue(i, 'f_mapg_ofc_nm') == "" ){
						ComShowMessage('Input  Mapping Office Name!');
						sheetObj.SelectCell(i, 'f_mapg_ofc_nm');
						return false;
					}
					*/
				}
		}
			if(chgRows== "" && chgRows2== ""){
				ComShowMessage('Please input data!');
				return false;

			}


	return true;
}