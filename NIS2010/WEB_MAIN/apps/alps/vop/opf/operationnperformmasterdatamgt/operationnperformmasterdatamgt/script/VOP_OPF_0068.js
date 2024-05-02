/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0068.js
*@FileTitle : TPR Target Ports Register
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.19 장석현
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
     * @class vop_opf_0068 : vop_opf_0068 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0068() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
		this.setComboObject			= setComboObject;
    }
    
   	/* 개발자 작업	*/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
        var sheetObject1  = sheetObjects[0];   //t1sheet1
         
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
				
				switch(srcName) {

						case "btn_Retrieve":
								doActionIBSheet(sheetObjects, formObject, IBSEARCH);
								break;

						case "btn_Save":
								doActionIBSheet(sheetObjects, formObject, IBSAVE);
								break;

						case "btn_Add":
							if(ComIsBtnEnable("btn_Save")){
								sheet_closs(sheetObjects[0], sheetObjects[1], sheetObjects[0].SelectRow, "sheet1_", "sheet2_", "Y");
							}
								break;

						case "btn_Delete":
							if(ComIsBtnEnable("btn_Save")){
								sheet_closs(sheetObjects[1], sheetObjects[0], sheetObjects[1].SelectRow, "sheet2_", "sheet1_", "N");
							}
								break;
								
						case "btn_Close":
								window.close();
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

	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++] = combo_obj;
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(strOfcCd) {

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}

		doActionIBSheet(sheetObjects,document.form,IBSEARCH);
		
 		var ofcCd = strOfcCd;
 	//	if(ofcCd == "SELOPA"){
 			ComEnableObject(document.all.btn_Delete, true);
 			ComEnableObject(document.all.btn_Add, true);
 			ComBtnEnable("btn_Save");
 	//	}else{
 		//	ComEnableObject(document.all.btn_Delete, false);
 		//	ComEnableObject(document.all.btn_Add, false); 			
 		//	ComBtnDisable("btn_Save");
 			
 			
 		//}
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
				var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
				with (sheetObj) {
                    // 높이 설정
                    style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|All M/V Calling Ports|All M/V Calling Ports|All M/V Calling Ports|All M/V Calling Ports";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,		true,		prefix + "no");
                    InitDataProperty(0, cnt++ , dtAutoSum,		80,		daCenter,		true,		prefix + "loc_cd",		false,		"",				dfNone,				0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		false,		prefix + "conti_cd",		false,		"",				dfNone,				0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		false,		prefix + "vop_port_flg",	false,		"",				dfNone,				0,		true,		true);

					CountPosition = 0;
										
				}
				
				break;
							
            case "sheet2":
				with (sheetObj) {
                    // 높이 설정
                    style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|TPR Target Ports|TPR Target Ports|TPR Target Ports|TPR Target Ports";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					//dtHiddenStatus
					var prefix = "sheet2_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,		true,		prefix + "no");
                    InitDataProperty(0, cnt++ , dtAutoSum,		80,		daCenter,		true,		prefix + "loc_cd",			false,		"",				dfNone,				0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,		prefix + "conti_cd",		false,		"",				dfNone,				0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		false,		prefix + "vop_port_flg",	false,		"",				dfNone,				0,		true,		true);

					CountPosition = 0;
										
				}
				break;
							
		}
    }

	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "rhq":    //R/D Term-post
				var i=0;
				with(comboObj) {
					InsertItem(i++,  "ALL",		"%");
					InsertItem(i++,  "NYCRA",   "NYCRA");
					InsertItem(i++,  "HAMRU",   "HAMRU");
					InsertItem(i++,  "SELIB",   "SELIB");
					InsertItem(i++,  "TYOIB",   "TYOIB");
					InsertItem(i++,  "SHARC",   "SHARC");
					InsertItem(i++,  "SINRS",	"SINRS");
					InsertItem(i++,  "VVOIA", 	"VVOIA");

					Code = "%";
				}
				break;
		}
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
				var arr = new Array("sheet1_","sheet2_");

				document.form.conti_cd.value = document.rhq.Code; 
				var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_0068GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));

				var arrXml = sXml.split("|$$|");
				//alert(sXml);
				for(var i = 0; i < arrXml.length; i++){ 
					sheetObjects[i].Redraw = false;    
					if(i > 0) {
						sheetObjects[i].WaitImageVisible = false;	
					}  
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
					sheetObjects[i].Redraw = true; 
				}

				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}//end if
				
				formObj.f_cmd.value = MULTI;
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return;
								  
				sParam += "&" + FormQueryString(formObj);
				
				var sXml = sheetObjects[0].GetSaveXml("VOP_OPF_0068GS.do", sParam);
				//alert(">>결과:"+sXml);
				sheetObjects[0].LoadSaveXml(sXml);     
				
				sXml = ComDeleteMsg(sXml);
				
				sheetObjects[1].LoadSaveXml(sXml);   

				break;

					
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

		
		function sheet1_OnSearchEnd(sheetObj, ErrMsg)
		{
			with(sheetObj)
			{
				sheetObj.SumText(0, 2) = RowCount;
				CellAlign(LastRow, "loc_cd") = daRight;
			}
		}
		
		
		function sheet2_OnSearchEnd(sheetObj, ErrMsg)
		{
			with(sheetObj)
			{
				sheetObj.SumText(0, 2) = RowCount;
				CellAlign(LastRow, "loc_cd") = daRight;
			}
		}

		function sheet1_OnDblClick(sheetObj, Row, Col){
			if(ComIsBtnEnable("btn_Save")){
				sheet_closs(sheetObj, sheetObjects[1], Row, "sheet1_", "sheet2_", "Y");
			}
		}

		function sheet2_OnDblClick(sheetObj, Row, Col){
			if(ComIsBtnEnable("btn_Save")){
				sheet_closs(sheetObj, sheetObjects[0], Row, "sheet2_", "sheet1_", "N");
			}
		}

		function sheet_closs(sheetOrg, sheetCopy, Row, prefixOrg, prefixCopy, vopPortFlg){
			var loc_cd = sheetOrg.CellValue(Row, prefixOrg + "loc_cd");
			var conti_cd = sheetOrg.CellValue(Row, prefixOrg + "conti_cd");
			sheetOrg.RowDelete(Row, false);

			var insert_row = sheetCopy.DataInsert(-1);
			
			sheetCopy.CellValue(insert_row, prefixCopy + "loc_cd") = loc_cd;
			sheetCopy.CellValue(insert_row, prefixCopy + "conti_cd") = conti_cd;
			sheetCopy.CellValue(insert_row, prefixCopy + "vop_port_flg") = vopPortFlg;

			sheetOrg.SumText(0, 2) = sheetOrg.RowCount;
			sheetCopy.SumText(0, 2) = sheetCopy.RowCount;
		}

		function rhq_OnChange(){
			document.form.conti_cd.value = document.rhq.Code; 
			doActionIBSheet(sheetObjects, document.form, IBSEARCH);
		}

	/* 개발자 작업  끝 */