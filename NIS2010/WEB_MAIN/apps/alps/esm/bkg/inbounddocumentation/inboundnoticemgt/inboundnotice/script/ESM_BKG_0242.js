/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0242.js
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.04.28 박성호
* 1.0 Creation
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
     * @class esm_bkg_0242 : esm_bkg_0242 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0242() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.obj_keypress 			= obj_keypress;

    }

   	/* 개발자 작업	*/


// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var shtCnt = 0;

         var t1sheet1Obj = sheetObjects[shtCnt++];
         var t2sheet1Obj = sheetObjects[shtCnt++];
         var t3sheet1Obj = sheetObjects[shtCnt++];

                 /*******************************************************/
         var formObject = document.form;

    	//try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            	case "btn_master":
					if(formObject.cust_cnt_cd[beforetab].value != "" && formObject.cust_seq[beforetab].value != ""){
						var goUrl = "";
						var param = "";
						goUrl = "/hanjin/ESM_BKG_0240.do?";

						param += "1=1";
						param += "&cust_cnt_cd="+formObject.cust_cnt_cd[beforetab].value;
						param += "&cust_seq="+formObject.cust_seq[beforetab].value;
						param += "&pgmNo=ESM_BKG_0240";

						opener.location.href=goUrl + param;
					}else{
						alert("Data가 존재하지 않습니다");
					}
                	break;

            	//case "btn_save":
				//	alert("btn_save");
                //	break;

            	case "btn_close":
					window.close();
                	break;




            } // end switch
    	//}catch(e) {
    	//	if( e == "[object Error]") {
    	//		ComShowMessage(OBJECT_ERROR);
    	//	} else {
    	//		ComShowMessage(e);
    	//	}
    	//}
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

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);


        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		ComOpenWait(true);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);

		//alert(document.form.tab_idx.value);
		if (document.form.tab_idx.value != "null" && document.form.tab_idx.value != '') {
			tabObjects[0].SelectedIndex = document.form.tab_idx.value;
		}
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var sheetID = sheetObj.id;

        var cnt = 0;

        switch(sheetID) {
            case "t1sheet1":      // t1sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 60;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|bkg_no|bkg_cust_tp_cd|cust_cnt_cd|cust_seq|mdm_name|bl_name|address|rep_cmdt|Fax No|E-Mail";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,		"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"bkg_no",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"bkg_cust_tp_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"cust_cnt_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"cust_seq",				false,		"",	dfNone,		0,		true,		true);

                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"mdm_name",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"bl_name",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"address",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"rep_cmdt",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	false,		"fax_no",			false,		"",	dfNone,		0,		true,		true);

                    InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	false,		"email",			false,		"",	dfNone,		0,		true,		true);

                    ScrollBar = 0;
                    CountPosition = 0;

                    ColHidden("fax_no") = false;

                    ColHidden("email") = false;


               }
                break;

             case "t2sheet1":      // t1sheet1 init
                with (sheetObj) {
                	// 높이 설정
                    style.height = 60;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|bkg_no|bkg_cust_tp_cd|cust_cnt_cd|cust_seq|mdm_name|bl_name|address|rep_cmdt|Fax No|E-Mail";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,		"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"bkg_no",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"bkg_cust_tp_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"cust_cnt_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"cust_seq",				false,		"",	dfNone,		0,		true,		true);

                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"mdm_name",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"bl_name",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"address",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"rep_cmdt",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	false,		"fax_no",			false,		"",	dfNone,		0,		true,		true);

                    InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	false,		"email",			false,		"",	dfNone,		0,		true,		true);

                    ScrollBar = 0;

                   CountPosition = 0;
                    ColHidden("fax_no") = false;

                    ColHidden("email") = false;

               }
                break;


             case "t3sheet1":      // t1sheet1 init
                with (sheetObj) {
                	// 높이 설정
                    style.height = 60;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|bkg_no|bkg_cust_tp_cd|cust_cnt_cd|cust_seq|mdm_name|bl_name|address|rep_cmdt|Fax No|E-Mail";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,		"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"bkg_no",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"bkg_cust_tp_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"cust_cnt_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"cust_seq",				false,		"",	dfNone,		0,		true,		true);

                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"mdm_name",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"bl_name",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"address",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,					100,		daCenter,	false,		"rep_cmdt",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	false,		"fax_no",			false,		"",	dfNone,		0,		true,		true);

                    InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	false,		"email",			false,		"",	dfNone,		0,		true,		true);

                    ScrollBar = 0;
					//<7.29>7. 하단 Sheet 부분에 Page 표시 문구 삭제 바람
                    CountPosition = 0;

                    ColHidden("fax_no") = false;

                    ColHidden("email") = false;


               }
                break;






        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
        	   formObj.f_cmd.value = SEARCH01;
                 //if(validateForm(sheetObj,formObj,sAction)){
						if ( sheetObj.id == "t1sheet1"){
                 			formObj.bkg_cust_tp_cd.value = "C";
						}else if ( sheetObj.id == "t2sheet1"){
							formObj.bkg_cust_tp_cd.value =  "N";
						}else if ( sheetObj.id == "t3sheet1"){
							formObj.bkg_cust_tp_cd.value = "A";
						}

						sheetObj.DoSearch("ESM_BKG_0242GS.do",FormQueryString(formObj));
                 //}


                break;

			 case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction))
                  alert (" Save .. ");
                break;

			case IBINSERT:      // 입력
                break;
        }
    }




    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Consignee" , -1 );
                    InsertTab( cnt++ , "Notify" , -1 );
                    InsertTab( cnt++ , "Also Notify" , -1 );

                }
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {


        var objs = document.all.item("tabLayer");

	    	objs[nItem].style.display = "Inline";
	    	objs[beforetab].style.display = "none";

	    	/*
	 			if(nItem==0 &&tabLoad[0]!=1)
					frameLayer0.document.location = 'tab1.jsp?frame=Tab1';
				else if(nItem==1 &&tabLoad[1]!=1)
					frameLayer1.document.location = 'tab3.jsp?frame=Tab2';
	    	*/


	    	//--------------- 요기가 중요 --------------------------//
	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	    	//------------------------------------------------------//
	    	beforetab= nItem;

	    	//탭변화에 따라 자동으로 실행
	    	//doActionIBSheet(sheetObjects[nItem],document.form,IBSEARCH);
	    	if(nItem != 1){
	    		ComBtnDisable("btn_master");
	    	}else{
	    		ComBtnEnable("btn_master");
	    	}


    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	//sheetObj.SpeedDown2Excel();
    	//ComOpenWait(false);
    	var formObj = document.form;
    	if (ErrMsg == "") {
    		if(sheetObj.RowCount > 0){
		    	formObj.cust_cnt_cd[0].value = sheetObj.CellText(1,"cust_cnt_cd");
		    	formObj.cust_seq[0].value = sheetObj.CellText(1,"cust_seq");
				fncCustSeqBlur(formObj.cust_seq[0]);
		    	formObj.mdm_name[0].value = sheetObj.CellText(1,"mdm_name");
		    	formObj.bl_name[0].value = sheetObj.CellText(1,"bl_name");
		    	formObj.address[0].value = sheetObj.CellText(1,"address");
		    	formObj.rep_cmdt[0].value = sheetObj.CellText(1,"rep_cmdt");
				formObj.fax_no[0].value = sheetObj.CellText(1,"fax_no");
				formObj.email[0].value = sheetObj.CellText(1,"email");
				ComOpenWait(false);
    		}
    	}else {
            ComShowMessage(ErrMsg);
        }


    }

    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	if (ErrMsg == "") {
    		if(sheetObj.RowCount > 0){
		    	formObj.cust_cnt_cd[1].value = sheetObj.CellText(1,"cust_cnt_cd");
		    	formObj.cust_seq[1].value = sheetObj.CellText(1,"cust_seq");
				//<7.29>2.CUST_SEQ 항목은 6자리 고정 ( LPAD( CUST_SEQ,6) 처리
				fncCustSeqBlur(formObj.cust_seq[1]);
		    	formObj.mdm_name[1].value = sheetObj.CellText(1,"mdm_name");
		    	formObj.bl_name[1].value = sheetObj.CellText(1,"bl_name");
		    	formObj.address[1].value = sheetObj.CellText(1,"address");
		    	formObj.rep_cmdt[1].value = sheetObj.CellText(1,"rep_cmdt");
				formObj.fax_no[1].value = sheetObj.CellText(1,"fax_no");
				formObj.email[1].value = sheetObj.CellText(1,"email");
				ComOpenWait(false);
    		}
    	}else {
            ComShowMessage(ErrMsg);
        }
    }

    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	if (ErrMsg == "") {
    		if(sheetObj.RowCount > 0){
		    	formObj.cust_cnt_cd[2].value = sheetObj.CellText(1,"cust_cnt_cd");
		    	formObj.cust_seq[2].value = sheetObj.CellText(1,"cust_seq");
				fncCustSeqBlur(formObj.cust_seq[2]);
		    	formObj.mdm_name[2].value = sheetObj.CellText(1,"mdm_name");
		    	formObj.bl_name[2].value = sheetObj.CellText(1,"bl_name");
		    	formObj.address[2].value = sheetObj.CellText(1,"address");
		    	formObj.rep_cmdt[2].value = sheetObj.CellText(1,"rep_cmdt");
				formObj.fax_no[2].value = sheetObj.CellText(1,"fax_no");
				formObj.email[2].value = sheetObj.CellText(1,"email");
				ComOpenWait(false);
    		}
    	}else {
            ComShowMessage(ErrMsg);
        }
    }


		/**
		 * seq 에서 포커스를 떠날시
		 * 숫자를 자동으로 앞에 0을 넣어 6자리로 만들기
		 * @param obj
		 * @return
		 */
		function fncCustSeqBlur(obj){
			var orgV = obj.value;
			//alert(obj.value);
			if(orgV != "" ){
				obj.value = fncSeqTo6(orgV);
			}else{
				obj.value = "";
			}



		}
		/**
		 * 숫자를 자동으로 앞에 0을 넣어 6자리로 만들기
		 * @param str
		 * @return
		 */
		function fncSeqTo6(str){
			var currentObjLen = str.length;

			var retStr = "";
			for(var i=0;i<6-currentObjLen;i++){
				retStr += "0";
			}
			return retStr + str;
		}


	/* 개발자 작업  끝 */
