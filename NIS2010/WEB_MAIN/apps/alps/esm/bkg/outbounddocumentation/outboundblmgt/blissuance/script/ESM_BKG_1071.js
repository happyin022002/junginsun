/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1071.js
*@FileTitle : Multi Fax / E-Mail / EDI Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.11.05 이일민
* 1.0 Creation
=========================================================*/

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
        var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_Close":
				window.close();
				break;
        } // end switch
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
    	for (var i=0; i<sheetObjects.length; i++) {
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
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
            case "sheet1":      //sheet1 init
            	with (sheetObj) {

                    // 높이 설정
                    style.height = 342;
                    //전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "Sent Result|Sent Result|Sent Result|Sent Result|Sent Result|Freight Option|Freight Option|Freight Option|Freight Option|Freight Option";
                    var HeadTitle2 = "Fax / E-mail / EDI|Result|Date|By|Office|A|C|P|N|F";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData, 140, daCenter, true, "fax_eml",     false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "snd_result",  false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "snd_date",    false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 90,	daCenter, true, "snd_usr_id",  false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 80,	daCenter, true, "snd_ofc_cd",  false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 25,	daCenter, true, "frt_all_flg", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 25,	daCenter, true, "frt_clt_flg", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 25,	daCenter, true, "frt_ppd_flg", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 25,	daCenter, true, "frt_chg_flg", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 25,	daCenter, true, "frt_arr_flg", false, "", dfNone, 0, false, false);
                }
                break;
        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:      //조회
				if (validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == "sheet1") {
						formObj.elements["f_cmd"].value = SEARCH;
					    var sXml = sheetObj.GetSearchXml("ESM_BKG_1071GS.do", FormQueryString(formObj));
						ufRedrawSheet(sheetObj,sXml);
						ComEtcDataXmlToForm(sXml, formObj);
					}
				}
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
     
    function ufRedrawSheet(sheetObject,sXml) {
       	var arrXml = sXml.split("|$$|");
   		sheetObject.Redraw = false;
   		sheetObject.LoadSearchXml(arrXml[0]);
   		sheetObject.Redraw = true;
    }
