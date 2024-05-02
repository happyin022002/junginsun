/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0040.js
*@FileTitle : Re Handle Reseon CodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
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
     * @class vop_opf_0037 : vop_opf_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;


var firstCode = "";
var secondCode = "";

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

						case "btn_I":
								alert(srcName);
								break;

						case "btn_C":
								alert(srcName);
								break;
								
								
						case "btn_OK":
								var openerSheet = window.dialogArguments.document.t6sheet1;

								with(openerSheet){
									var prefix = "t6sheet1_";

									openerSheet.CellValue(openerSheet.SelectRow, prefix + "shift_rsn") = firstCode + "" + secondCode;
								}

								window.close();
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

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
        }

		if(document.form.shift_rsn.value != ""){
			firstCode = document.form.shift_rsn.value.substring(0, 1);
			secondCode = document.form.shift_rsn.value.substring(1);
		}
		initDefaultSheet(sheetObjects[0], document.form);

		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		//Sheet1 Default Data Setting..

    }

    
    /**
     * Sheet1  Default Data Setting.
     * 화면을 브라우저에서 로딩시에 기본적으로 보여줄 데이터를 세팅한다.
     */
    function initDefaultSheet(sheetObj, formObj){
    	var prefix = "sheet1_";
    	sheetObj.DataInsert();
    	sheetObj.DataInsert();
    	sheetObj.CellText(1, prefix+"rstwg_rsn_cd") = "B";
    	sheetObj.CellText(1, prefix+"rstwg_rsn_cd_full_desc") = "Cell to Cell restow (1 move)";
    	sheetObj.CellText(2, prefix+"rstwg_rsn_cd") = "Q";
    	sheetObj.CellText(2, prefix+"rstwg_rsn_cd_full_desc") = "Via the Quay restow (2 moves)";
		//초기에 세팅...
		if(firstCode == ""){
			sheetObj.CellValue(1, "sheet1_rstwg_sel") = "1";
			firstCode = sheetObj.CellValue(1, prefix + "rstwg_rsn_cd");
			sheetObj.SelectRow = sheetObj.HeaderRows;
		}else{
			sheetObj.SelectRow = (firstCode == "B" ? sheetObj.HeaderRows : sheetObj.HeaderRows + 1);
			sheetObj.CellValue(sheetObj.SelectRow, "sheet1_rstwg_sel") = "1";
		}
    }

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;

		with (sheetObj) {
			// 높이 설정
			style.height = 342;
			//전체 너비 설정
			style.width = mainTable[0].clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

		   //전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Code|Shifting Method|Select";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]\
			var prefix = sheetID + "_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		true,		prefix + "ibFlag");
			InitDataProperty(0, cnt++ , dtData,				40,		daCenter,		true,		prefix + "rstwg_rsn_cd",			false,		"",				dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,				230,	daLeft,			true,		prefix + "rstwg_rsn_cd_full_desc",	false,		"",				dfNone,				0,		true,		true);
			InitDataProperty(0, cnt++ , dtRadioCheck,		40,		daCenter,		true,		prefix + "rstwg_sel",				false,		"",				dfNone,				0,		true,		true);
			

			CountPosition = 0;
		}
    }
	
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
			if(secondCode == ""){
				sheetObj.CellValue(1, "sheet2_rstwg_sel") = "1";
				secondCode = sheetObj.CellValue(1, "sheet2_rstwg_rsn_cd");
			}else{
				for(var idxRow = sheetObj.HeaderRows; idxRow < sheetObj.LastRow; idxRow++){
					if(sheetObj.CellValue(idxRow, "sheet2_rstwg_rsn_cd") == secondCode){
						sheetObj.SelectRow = idxRow;
						sheetObj.CellValue(sheetObj.SelectRow, "sheet2_rstwg_sel") = "1";
						break;
					}
				}
			}
		}
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;

				sheetObj.DoSearch("VOP_OPF_0075GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
				break;

			case IBSAVE:        //저장
				break;

			case IBINSERT:      // 입력
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

	function sheet1_OnClick(sheetObj, Row, Col){
		if(sheetObj.CellValue(Row, "sheet1_rstwg_sel") != "1"){
			for(var idxRow = 0; idxRow < sheetObj.LastRow; idxRow++){
				sheetObj.CellValue(Row, "sheet1_rstwg_sel") = "0";
			}
			sheetObj.CellValue(Row, "sheet1_rstwg_sel") = "1";
			firstCode = sheetObj.CellValue(Row, "sheet1_rstwg_rsn_cd");
		}
	}

	function sheet2_OnClick(sheetObj, Row, Col){
		if(sheetObj.CellValue(Row, "sheet2_rstwg_sel") != "1"){
			for(var idxRow = 0; idxRow < sheetObj.LastRow; idxRow++){
				sheetObj.CellValue(Row, "sheet2_rstwg_sel") = "0";
			}
			sheetObj.CellValue(Row, "sheet2_rstwg_sel") = "1";
			secondCode = sheetObj.CellValue(Row, "sheet2_rstwg_rsn_cd");
		}
	}
