/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0682.js
*@FileTitle : Korea Cargo Release (D/O)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.05.22 임진영
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn1_Save":
                    doActionIBSheet(sheetObjects[0], formObject,IBSAVE);
                    break;
                case "btn1_Close":
                    self.close();
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
    function loadPage(date, id) {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        //입력 행 추가
        var j = sheetObjects[0].DataInsert(-1);
        

        if (document.form.remark.value != "") {
        	sheetObjects[0].CellValue(j, "sheet1_remark")  = document.form.remark.value;
            sheetObjects[0].CellValue(j, "sheet1_date")    = ComGetMaskedValue(document.form.evnt_dt.value, "ymd");
            sheetObjects[0].CellValue(j, "sheet1_id")      = document.form.evnt_usr_id.value;
        	sheetObjects[0].CellEditable(j, "sheet1_remark") = false;
        	document.getElementById("id_save").style.display='none';
        } else {
        	sheetObjects[0].CellValue(j, "sheet1_remark")  = '';
            sheetObjects[0].CellValue(j, "sheet1_date")    = date.substring(0,16);
            sheetObjects[0].CellValue(j, "sheet1_id")      = id;
        	sheetObjects[0].CellEditable(j, "sheet1_remark") = true;
        	document.getElementById("id_save").style.display='';
        }
        
        //추가된 행의 사업자명에 포거스를 준다.
        sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, "sheet1_remark", true);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 45;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "|Remark for Release|Input Date|Staff ID";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    var prefix = "sheet1_";
                    
                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH, DATAALIGN,   COLMERGE,   SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus ,30,     daCenter,   false,      prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,         250,    daLeft,     true,       prefix + "remark",      true,       "",         dfNone,     0,          true,       true, 4000);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "date",        false,      "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++ , dtData,         0,      daCenter,   true,       prefix + "id",          false,      "",         dfNone,     0,          false,      false);

                    //InitUserFormat2(0, "date", "####-##-## ##:##", "-|:" );

                    CountPosition = 0;
                }
                break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
                if ("sheet1" == sheetObj.id) sheetObj.DoSearch("UI_BKG_0954_DATA1.html");

                break;

            case IBSAVE:        //저장
                if(!validateForm(sheetObj,formObj,sAction)) return;
            	
            	//DB 저장 모듈 추가(안진응)
	            formObj.f_cmd.value = MODIFY;
	        	formObj.h_rmk.value = sheetObj.CellValue(1, "sheet1_remark");
	            
	            var aryPrefix = new Array("sheet1_");    //prefix 문자열 배열
	
	            var sParam1 = sheetObjects[0].GetSaveString(true);
	
	            var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
	
	            var sXml = sheetObj.GetSaveXml("ESM_BKG_0954GS.do", sparam);
	
	            sheetObjects[0].LoadSaveXml(sXml);
	            sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
            
                break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        with(formObj){

            //필수입력값 체크
            if(sheetObj.CellValue(1, "sheet1_remark") ==''){
                ComShowCodeMessage('BKG00548');
                sheetObj.SelectCell(1, "sheet1_remark", true);
                return false;
            }

            //입력 자리수 체크
            if( ComChkLenByByte(sheetObj.CellValue(1, "sheet1_remark"), 4000) == 0){
                ComShowCodeMessage("BKG00440"); //입력가능 자릿수를 초과하였습니다.
                sheetObj.SelectCell(1, "sheet1_remark", true);
                return false;
            }
        }
        return true;
    }

     /**
      * sheet1를 저장하고 나서 처리할 사항
      */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
         if (ErrMsg == "") {
        	ComShowCodeMessage("BKG00166"); //Data Saved Successfully!!
        	window.returnValue = sheetObj.CellValue(1, "sheet1_remark");
            self.close();
         }
    }
     