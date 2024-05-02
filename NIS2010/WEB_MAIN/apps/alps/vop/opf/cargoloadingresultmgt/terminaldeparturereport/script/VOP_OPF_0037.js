/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0037.js
*@FileTitle : Excludefrom TPR Save
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

				case "btn_Save":
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;

				case "btn_Delete":
					doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
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
        var formObj = document.form;
        if( formObj.status1.value == "R"){
            document.all.btn_save_table.style.display = "none";
        }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

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
                    style.height = 230;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|No|Reason Cd|key_of_remark|Reason for Excluding from TPR|Check";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"No");
                    InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,			true,		"tml_prod_rpt_rsn_cd",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,			true,		"key_of_remark",			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			370,	daLeft,			true,		"tml_prod_rpt_rsn_desc",	false,		"",				dfNone,				0,		true,		true);
                    //InitDataProperty(0, cnt++ , dtRadioCheck,	40,		daCenter,		true,		"tdr_rpt_rsn_cd",			false,		"",				dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,		true,		"tdr_rpt_rsn_cd",			false,		"",				dfNone,				0,		true,		true);
                    
					CountPosition = 0;
										
				}
			break;
		}
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("VOP_OPF_0037GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));

				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = false;	
				sheetObj.LoadSearchXml(sXml); 
				sheetObj.Redraw = true; 
				
				for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
					if(sheetObj.CellValue(idxRow, "tdr_rpt_rsn_cd") == "1"){
						var arrData = sheetObj.CellValue(idxRow, "key_of_remark").split("_/");
						formObj.tml_prod_rpt_rsn_rmk.value = arrData[arrData.length - 1];
					}
				}
				break;

			case IBSAVE:        //저장
				var checkedRow = false;
				var delRow = 0; 
				var classNm =  "";
				for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
					if(sheetObj.CellValue(idxRow, "tdr_rpt_rsn_cd") == "1"){
						
						formObj.tml_prod_rpt_rsn_cd.value = sheetObj.CellValue(idxRow, "tml_prod_rpt_rsn_cd");
						
						if(sheetObj.CellValue(idxRow, "tml_prod_rpt_rsn_cd") == "OTH"){
							if(formObj.tml_prod_rpt_rsn_rmk.value == ""){
								ComShowCodeMessage("COM130201", "Remark");
								formObj.tml_prod_rpt_rsn_rmk.focus();
								return;
							}
						}

						checkedRow = true;

						var keyValue =  formObj.vsl_cd.value + "_/" +
									    formObj.skd_voy_no.value + "_/" + 
									    formObj.skd_dir_cd.value + "_/" + 
									    formObj.clpt_ind_seq.value + "_/" + 
									    formObj.port_cd.value + "_/" + 
									    formObj.tml_prod_rpt_rsn_cd.value + "_/" + 
										formObj.tml_prod_rpt_rsn_rmk.value + "_/";
									    

						sheetObj.CellValue2(idxRow, "key_of_remark") = keyValue;
						sheetObj.RowStatus(idxRow) = "U";
						classNm = "#e41010";
					}else if(sheetObj.CellValue(idxRow, "key_of_remark") != "" && sheetObj.CellValue(idxRow, "tdr_rpt_rsn_cd") == "0"){
						delRow = idxRow;
					}
				}
				
				if(!checkedRow){
					if( delRow > 0 ){
						var keyValue =  formObj.vsl_cd.value + "_/" +
									    formObj.skd_voy_no.value + "_/" + 
									    formObj.skd_dir_cd.value + "_/" + 
									    formObj.clpt_ind_seq.value + "_/" + 
									    formObj.port_cd.value + "_/" + 
										formObj.tml_prod_rpt_rsn_rmk.value + "_/";

						sheetObj.CellValue2(delRow, "key_of_remark") = keyValue;
						sheetObj.RowStatus(delRow) = "D";
						classNm = "#514747";
					}else{
						ComShowCodeMessage("COM12113", "Code"); 
						return;
					}
				}

				formObj.f_cmd.value = MULTI01;
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return;
				sParam +=  "&" + FormQueryString(formObj);

				var sXml = sheetObj.GetSaveXml("VOP_OPF_0037GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				
				if(sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0){
					window.dialogArguments.document.all("btn_ExcludefromTPR").style.color = classNm;
					window.close();
				}
				break;
			case IBDELETE:        //저장
				var checkedRow = false;
				for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
					if(sheetObj.CellValue(idxRow, "tdr_rpt_rsn_cd") == "1"){

						var keyValue =  formObj.vsl_cd.value + "_/" +
									    formObj.skd_voy_no.value + "_/" + 
									    formObj.skd_dir_cd.value + "_/" + 
									    formObj.clpt_ind_seq.value + "_/" + 
									    formObj.port_cd.value + "_/" ;

						sheetObj.CellValue2(idxRow, "key_of_remark") = keyValue;
						checkedRow = true;
						sheetObj.RowStatus(idxRow) = "D";
					}
				}

				formObj.f_cmd.value = MULTI01;
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return;
				sParam +=  "&" + FormQueryString(formObj);

				var sXml = sheetObj.GetSaveXml("VOP_OPF_0037GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				
				if(sXml.indexOf("OK") > 0){
					window.dialogArguments.document.all("btn_ExcludefromTPR").className = "btn1";
					window.close();
				}
				break;
        }
    }

    /**
    * 초기 이벤트 등록 
    */
    function initControl() {
		axon_event.addListener('keypress', 'net_work_keypress', 'net_work', '');		
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
	
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		if(sheetObj.ColSaveName(Col) ==  "tdr_rpt_rsn_cd"){
			if(sheetObj.CellValue(Row, "tdr_rpt_rsn_cd") == "1"){
				for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
					if(Row != idxRow){
						sheetObj.CellValue(idxRow, "tdr_rpt_rsn_cd") = "0";
					}
				}

				if(sheetObj.CellValue(Row, "tml_prod_rpt_rsn_cd") == "OTH"){
					document.form.tml_prod_rpt_rsn_rmk.className = "textarea1";
				}else{
					document.form.tml_prod_rpt_rsn_rmk.className = "textarea";
				}
			}else{
				document.form.tml_prod_rpt_rsn_rmk.className = "textarea";
			}

			document.form.tml_prod_rpt_rsn_rmk.value = "";
		}
	}
