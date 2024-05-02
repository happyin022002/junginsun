/**
===============================================================================
프로그램  명  : IBSheet에서 제공하는 공통 Javascript
프로그램개요  : IBSheet의 기능을 편하게 쓸수 있는 각종 함수를 정의한다.
작   성   자  : 아이비리더스
작   성   일  : 2003-07-01
최 종  버 전  : IBSheet 2.9.0.0
===============================================================================
수정자/수정일 : 이경희/2008.11.31
수정사유/내역 : jsdoc을 위한 주석, 일부함수 CoObject.js로 이동, IBS_CopyFormToRow,IBS_CopyRowToForm 함수 추가
===============================================================================
*/

    /*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview IBSheet에서 사용하는 공통 Javascript 함수를 정의한다.
     * @author (주)아이비리더스
     * @since 2003-07-01
     * @version 3.4.0.50
     */

    /**
     *
     * @class IBSheetInfo : IBSheet에서 사용하는 각종 자바스크립트 함수와 상수를 정의한다.
     */
    function IBSheetInfo() {
        this.FormQueryString        = FormQueryString       ;   //Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다.
        this.FormQueryStringEnc     = FormQueryStringEnc    ;   //Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩한다.
        this.FormQueryStringOrg     = FormQueryStringOrg    ;   //Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다.
        this.IBS_ConcatSaveName     = IBS_ConcatSaveName    ;   //SaveName을 구분자로 조합하여 반환한다.
        this.IBS_CopyFormToRow      = IBS_CopyFormToRow     ;   //Form의 각 컨트롤에 값을 Sheet의 특정행의 각 컬럼에 복사한다.
        this.IBS_CopyRowToForm      = IBS_CopyRowToForm     ;   //Sheet의 특정행의 값을 Form의 각 컨트롤에 값을 복사한다.
        this.IBS_EtcDataToForm      = IBS_EtcDataToForm     ;   //Sheet에 존재하는 EtcData의 값을 폼의 객체에 채운다.
        this.IBS_GetDataSearchXml   = IBS_GetDataSearchXml  ;   //Sheet의 데이터를 조회XML로 구성하여 반환한다.
        this.IBS_Sheet2SheetCheck   = IBS_Sheet2SheetCheck  ;   //2개 Sheet에서 데이터 이동하기, 체크된 데이터만 이동하기
        this.IBS_Sheet2SheetStatus  = IBS_Sheet2SheetStatus ;   //2개 Sheet에서 데이터 이동하기, 특정 트랜잭션 상태만 이동하기
        this.IBS_DoSearchSax        = IBS_DoSearchSax       ;
        this.ComGetComboText        = ComGetComboText       ;
        this.ComSetIBCombo          = ComSetIBCombo       	;
        this.IBS_SaveGridSetting	= IBS_SaveGridSetting	;
        this.IBS_RestoreGridSetting	= IBS_RestoreGridSetting;
        this.IBS_DelGridSetting		= IBS_DelGridSetting	;
        
    }

    /*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

    /* 페이지의 파일명을 제외한 기본 위치 url
     * 예를 들어 http://211.41.15.40:7001/Sample_IBSheet/sheet/me.html이 현재페이지 이면
     * page_path 값은 "/Sample_IBSheet/sheet/" 이다
    **/
    var page_path = location.pathname;
    page_path = page_path.substr(0,page_path.lastIndexOf("/")+1);
    //모달로 열었을때는 처음에 "/"로 시작하지 않을수 있음
    if (page_path.charAt(0) != "/") page_path = "/" + page_path;

    /* MergeSheet 속성에 설정 값 */
    msNone            = 0;      // 머지 없음
    msAll             = 1;      // 전부 머지 가능
    msPrevColumnMerge = 2;      // 앞 컬럼이 머지 된 경우 해당 행 안에서 머지 가능
    msHeaderOnly      = 5;      // 해더만 머지

    /* InitDataProperty 함수에 DataType 인자에 설정 하는 값 */
    dtNull            = -1;     // 없음
    dtData            = 0;      // 일반 데이터
    dtStatus          = 1;      // 트랜잭션 상태
    dtDelCheck        = 2;      // 삭제 체크 박스
    dtDelCheckEx      = 3;      // 삭제 체크 박스 + 실제 지움
    dtCheckBox        = 4;      // 선택 체크 박스
    dtHidden          = 5;      // 숨겨진 데이터
    dtCombo           = 6;      // 콤보 형 데이터
    dtComboEdit       = 7;      // 콤보 형 데이터 + Edit가능
    dtPopup           = 8;      // 팝업 버튼 형 데이터 + OnPopup 이벤트 발생 + 값에 대한 포멧기능무시
    dtPopupEdit       = 9;      // 팝업 버튼 형 데이터 + OnPopup 이벤트 발생 + Edit 가능 + 값에 대한 포멧기능무시
    dtFileUp          = 10;     // 파일 업로드 형 데이터
    dtResult          = 11;     // 트랜잭션 결과
    dtAutoSum         = 12;     // 자동 계산 컬럼
    dtAutoSumEx       = 13;     // 자동 계산 + 삭제된 행 계산 제외
    dtAutoAvg         = 14;     // 자동 평균 컬럼
    dtAutoAvgEx       = 15;     // 자동 평균 + 삭제된 행 계산 제외
    dtImage           = 16;     // 이미지 형
    dtSeq             = 17;     // 시퀀스
    dtPassword        = 18;     // 패스워드
    dtHiddenStatus    = 19;     // dtStatus + 숨겨짐
    dtImageText       = 20;     // 이미지 + 텍스트
    dtDataSeq         = 21;     // 데이터 순번
    dtPopupFormat     = 22;     // 팝업 버튼 형 데이터 + OnPopup 이벤트 발생 + 값에대한포멧기능사용
    dtPopupEditFormat = 23;     // 팝업 버튼 형 데이터 + OnPopup 이벤트 발생 + Edit 가능  + 값에 대한 포멧기능사용
    dtDummyCheck      = 24;     // Dummy 체크박스
    dtRadioCheck      = 25;     // Dummy 체크박스


    /* InitDataProperty 함수에 DataAlign 인자에 설정 하는 값 */
    daNull            = -1;     // 없음
    daLeft            = 0;      // 좌측 가운데 정렬
    daCenter          = 1;      // 가운데 가운데 정렬
    daRight           = 2;      // 우측 가운데 정렬
    daLeftTop         = 3;      // 좌측 상단 정렬
    daLeftBottom      = 4;      // 좌측 하단 정렬
    daCenterTop       = 5;      // 가운데 상단 정렬
    daCenterBottom    = 6;      // 가운데 바닥 정렬
    daRightTop        = 7;      // 우측 상단 정렬
    daRightBottom     = 8;      // 우측 바닥 정렬


    /*InitDataProperty 함수에 DataFormat 인자에 설정 하는 값 */
    dfNull            = -1;     // 없음
    dfNone            = 0;      // 포멧 없음
    dfDateYmd         = 1;      // 날짜-년월일 YYYY.MM.DD
    dfDateYm          = 2;      // 날짜-년월 YYYY.MM
    dfDateMd          = 3;      // 날짜-월일 MM.DD
    dfTimeHms         = 4;      // 시간-시분초 HH:MM:SS
    dfTimeHm          = 5;      // 시간-시분 HH:MM
    dfIdNo            = 6;      // 주민등록번호
    dfSaupNo          = 7;      // 사업자 번호
    dfCardNo          = 8;      // 카드 번호
    dfPostNo          = 9;      // 우편번호
    dfInteger         = 10;     // 정수(Default 0)
    dfFloat           = 11;     // 실수(Default 0.0)
    dfNullInteger     = 12;     // 정수(Default null)
    dfNullFloat       = 13;     // 실수(Default null)
    dfNumber          = 14;     // 숫자
    dfHanKey          = 15;     // 한글 입력 모드
    dfEngKey          = 16;     // 영문 입력 모드
    dfEngUpKey        = 17;     // 영문 대문자 입력 모드
    dfEngDnKey        = 18;     // 영문 소문자 입력 모드
    dfUserFormat      = 19;     // 사용자 설정형 포멧
    dfUserFormat2     = 20;     // 사용자 설정형 포멧, 마스크 구분자가 2개인 경우
    dfFloatOrg        = 21;     // AM3107 FloatOrg 추가함 (합계시 소실 없음)
    dfNullFloatOrg    = 22;     // AM3107 NullFloatOrg 추가함 (합계시 소실 없음)

    /*GetDataProperty 함수에서 DataPropertyChoice 인자에 설정 하는 값 */
    dpDataType        = 0;      // 데이터 타입
    dpDataAlign       = 1;      // 데이터 정렬
    dpDataFormat      = 2;      // 데이터 포멧
    dpSaveName        = 3;      // 저장 변수명
    dpKeyField        = 4;      // 필수 입력 여부
    dpCalcuLogic      = 5;      // 계산 공식
    dpPointCount      = 6;      // 소숫점 이하 자리 개수
    dpUpdateEdit      = 7;      // 수정 가능 여부
    dpInsertEdit      = 8;      // 입력 가능 여부
    dpEditLen         = 9;      // 입력 길이
    dpFullInput       = 10;     // 전체 입력 여부
    dpColumnSort      = 11;     // 소트 가능 여부
    dpVisAllCheck     = 12;     // 전체 CheckBox 여부
    dpSaveStatus      = 13;     // 저장 상태 코드
    dpFormatFix       = 14;     // 포멧 고정 여부
    dpValidType       = 15;     // Validation Type
    dpValidChar       = 16;     // Validation Char

    poDefault         = 0;      // 페이지에 설정된 값 그대로
    poPortrait        = 1;      // 세로 페이지
    poLandscape       = 2;      // 가로 페이지

    /* SelectionMode 속성에 설정하는 값 */
    smSelectionFree   = 0;      // 자유 선택 모드
    smSelectionRow    = 1;      // 행단위 선택 모드
    smSelectionCol    = 2;      // 컬럼단위 선택 모드
    smSelectionList   = 3;      // 행단위 랜덤 선택 모드

    /* BasicImeMode 속성에 설정하는 값 */
    imeAuto           = 0;      // 마지막 상태를 그대로 사용
    imeHan            = 1;      // 기본 상태를 한글 입력 상태로 함
    imeEng            = 2;      // 기본 상태를 영문 입력 상태로 함

    /* GridLine 속성에 설정하는 값 */
    glNone            = 0;      // 선없음
    glFlat            = 1;      // 기본선
    glFlatHorz        = 4;      // 평면가로선만 있고, 세로선은 없음
    glFlatVert        = 8;      // 평면세로선만 있고, 가로선은 없음


    /* InitDataValid 함수에서 ValidType 인자에 설정하는 값 - 2.4.0.0 */
    vtNone            = 0;      // 자동으로 처리
    vtCharOnly        = 1;      // ValidChart에 설정된 글자만 처리
    vtNumericOnly     = 2;      // 숫자만 입력
    vtEngOnly         = 3;      // 영문만 입력
    vtHanOnly         = 4;      // 한글만 입력
    vtNumericOther    = 5;      // 숫자+기타글자
    vtEngOther        = 6;      // 영문+기타글자
    vtHanOther        = 7;      // 한글+기타글자
    vtExceptChar      = 8;      // ValidChart에 설정된 글자만 빼고 모두 입력
    vtEngUpOnly       = 9;      // 영문대문자만 입력, 키보드 입력시 소문자를 입력해도 자동 대문자로 표시
    vtEngDnOnly       = 10;     // 영문소문자만 입력, 키보드 입력시 대문자로 입력해도 자동 소문자로 표시
    vtEngUpOther      = 11;     // 영문대문자+기타글자, 키보드 입력시 소문자를 입력해도 자동 대문자로 표시
    vtEngDnOther      = 12;     // 영문소문자+기타글자, 키보드 입력시 대문자로 입력해도 자동 소문자로 표시

    /* FocusStyle 속성에 설정하는 값 - 2.4.0.0 */
    fsNone            = 0;      // 모양 없음
    fsLight           = 1;      // 점선 모양 (기본모양)
    fsHeavy           = 2;      // 굵은 회색 테두리 모양
    fsSolid           = 3;      // SelectBackColor 색상의 실선
    fsRaised          = 4;      // 입체적으로 나온 모양
    fsInset           = 5;      // 안으로 들어간 모양


    /**
     * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     var sCondParam=FormQueryString(document.frmSearch); //결과:"txtname=이경희&rdoYn=1&sltMoney=원화";
     * </pre>
     * @param {form} form Form 오브젝트
     * @return string
     * @version 1.0.0.0
     * @see #FormQueryStringEnc
     */
    function FormQueryString(form) {

        if (typeof form != "object" || form.tagName != "FORM") {
            alert("Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
            return "";
        }

        var name = new Array(form.elements.length);
        var value = new Array(form.elements.length);
        var j = 0;
        var plain_text="";

        //사용가능한 컨트롤을 배열로 생성한다.
        len = form.elements.length;
        for (i = 0; i < len; i++) {
          //클래스 아이디로 제품을 구분함-아래는 HTMl제품
          if(form.elements[i].classid==undefined){
        	  //전송전에 폼의 마스크를 제거한다.
//        	  ComClearSeparator(form.elements[i]);
          switch (form.elements[i].type) {
            case "button":
            case "reset":
            case "submit":
              break;
            case "radio":
            case "checkbox":
                        if (form.elements[i].checked == true) {
                            name[j] = form.elements[i].name;
                            value[j] = form.elements[i].value;
                            j++;
                        }
                        break;
                case "select-one":
                        name[j] = form.elements[i].name;
                        var ind = form.elements[i].selectedIndex;
                        if(ind >= 0) {
                            if (form.elements[i].options[ind].value != '')
                                value[j] = form.elements[i].options[ind].value;
                            else
                                value[j] = '';
                        } else {
                            value[j] = "";
                        }
                        j++;
                        break;
                case "select-multiple":
                        name[j] = form.elements[i].name;
                        var llen = form.elements[i].length;
                        var increased = 0;
                        for( k = 0; k < llen; k++) {
                            if (form.elements[i].options[k].selected) {
                                name[j] = form.elements[i].name;
                                if (form.elements[i].options[k].value != '')
                                    value[j] = form.elements[i].options[k].value;
                                else
                                    value[j] = '';
                                j++;
                                increased++;
                            }
                        }
                        if(increased > 0) {
                            j--;
                        } else {
                            value[j] = "";
                        }
                        j++;
                        break;
                    default :
                        name[j] = form.elements[i].name;
                        value[j] = form.elements[i].value;
                        j++;
            }
    	  	//전송후에 폼의 마스크를 다시 셋팅한다.
//          ComAddSeparator(form.elements[i]);
        //IB에서 제공하는 컨트롤의 값을 조합한다.
        }else{
          switch(form.elements[i].classid){
            case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  // IBMaskEdit 경우
              name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
                    value[j] = form.elements[i].Value;
                    j++;
              break;
            case CLSID_IBMCOMBO: // IBMultiCombo 경우
              name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
              		if(form.elements[i].UseCode)
              			value[j] = form.elements[i].Code;
              		else
              			value[j] = form.elements[i].Text;
                    j++;
                    break;
          }
        }
        }

        // QueryString을 조합한다.
        //   1) Explorer 5.5 이상일 경우, encodeURIComponent() 를 이용하여 URL Encode
        //   2) 기타 경우는 IB Sheet 를 이용하여 URL Encode
        var webBrowserName = navigator.appName;
        var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
                                                            navigator.appVersion.indexOf("MSIE") + 8)

        if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
            for (i = 0; i < j; i++) {
                // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
                if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
            }
        } else {
            var tmpUrlEncodeSheet    = document.getElementById("formquerystring");

            if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
            {
                //인코딩을 위해 숨겨진IBSheet를 만든다.
                var sTag = ComGetSheetObjectTag("formquerystring");
                form.insertAdjacentHTML('afterEnd', sTag);
            }

            for (i = 0; i < j; i++) {
                // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
                if (name[i] != '') plain_text += name[i]+ "=" + formquerystring.UrlEncoding(value[i]) + "&";
            }
        }


      //마지막에 &를 없애기 위함
      if (plain_text != "")
        plain_text = plain_text.substr(0, plain_text.length -1);
        return plain_text;
    }

    /**
     * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     var sCondParam=FormQueryStringEnc(document.frmSearch, mySheet1);
     *     원본:"txtname=이경희&rdoYn=1&sltMoney=원화";
     *     결과:"txtname=%C0%CC%B0%E6%C8%F1&rdoYn=1&sltMoney=%BF%F8%C8%AD";                //UTF16인 경우
     *     결과:"txtname=%EC%9D%B4%EA%B2%BD%ED%9D%AC&rdoYn=1&sltMoney=%EC%9B%90%ED%99%94"; //UTF8인 경우
     * </pre>
     * @param {form}    form     필수,Form 오브젝트
     * @param {ibsheet} sheet    필수,한글을 인코딩할 Sheet의 Object id
     * @return string
     * @version 1.0.0.0
     * @see #FormQueryString
     */
    function FormQueryStringEnc(form, sheet) {
      if (typeof form != "object" || form.tagName != "FORM") {
    	  alert("Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
        return "";
      }

      if (typeof sheet != "object" || sheet.tagName != "OBJECT") {
    	  alert("Error : Please contact the administrator\n" + "Detail : FORM Parameter of FormQueryStringEnc Function is not a IBSheet.");
        return "";
      }

        var name = new Array(form.elements.length);
        var value = new Array(form.elements.length);
        var j = 0;
        var plain_text="";

        //사용가능한 컨트롤을 배열로 생성한다.
        len = form.elements.length;
        for (i = 0; i < len; i++) {
          //클래스 아이디로 제품을 구분함-아래는 HTMl제품
          if(form.elements[i].classid==undefined){
//        	  ComClearSeparator(form.elements[i]);
          switch (form.elements[i].type) {
            case "button":
            case "reset":
            case "submit":
              break;
            case "radio":
            case "checkbox":
                        if (form.elements[i].checked == true) {
                            name[j] = form.elements[i].name;
                            value[j] = form.elements[i].value;
                            j++;
                        }
                        break;
                case "select-one":
                        name[j] = form.elements[i].name;
                        var ind = form.elements[i].selectedIndex;
                        if(ind >= 0) {
                            if (form.elements[i].options[ind].value != '')
                                value[j] = form.elements[i].options[ind].value;
                            else
                                value[j] = '';
                        } else {
                            value[j] = "";
                        }
                        j++;
                        break;
                case "select-multiple":
                        name[j] = form.elements[i].name;
                        var llen = form.elements[i].length;
                        var increased = 0;
                        for( k = 0; k < llen; k++) {
                            if (form.elements[i].options[k].selected) {
                                name[j] = form.elements[i].name;
                                if (form.elements[i].options[k].value != '')
                                    value[j] = form.elements[i].options[k].value;
                                else
                                    value[j] = '';
                                j++;
                                increased++;
                            }
                        }
                        if(increased > 0) {
                            j--;
                        } else {
                            value[j] = "";
                        }
                        j++;
                        break;
                    default :
                        name[j] = form.elements[i].name;
                        value[j] = form.elements[i].value;
                        j++;
            }
  	  	//전송후에 폼의 마스크를 다시 셋팅한다.
 //         ComAddSeparator(form.elements[i]);
       //IB에서 제공하는 컨트롤의 값을 조합한다.
        }else{
          switch(form.elements[i].classid){
            case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  // IBMaskEdit 경우
              name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
                    value[j] = form.elements[i].Value;
                    j++;
              break;
            case CLSID_IBMCOMBO: // IBMultiCombo 경우
              name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
        		if(form.elements[i].UseCode)
          			value[j] = form.elements[i].Code;
          		else
          			value[j] = form.elements[i].Text;
                    j++;
                    break;
          }
        }
        }

      //QueryString을 조합한다.
        for (i = 0; i < j; i++) {
            if (name[i] != '') plain_text += name[i]+ "=" + sheet.UrlEncoding(value[i]) + "&";
        }

      //마지막에 &를 없애기 위함
      if (plain_text != "")
        plain_text = plain_text.substr(0, plain_text.length -1);
        return plain_text;
    }

    /**
     * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     var sCondParam=FormQueryStringOrg(document.frmSearch); //결과:"txtname=이경희&rdoYn=1&sltMoney=원화";
     * </pre>
     * @param {form} form Form 오브젝트
     * @return string
     * @version 1.0.0.0
     * @see #FormQueryStringEnc
     */
	function FormQueryStringOrg(form) {
	  if (typeof form != "object" || form.tagName != "FORM") {
		  alert("Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
	    return "";
	  }
	
	  var name = new Array(form.elements.length);
	  var value = new Array(form.elements.length);
	  var j = 0;
	  var plain_text="";
	
	  //사용가능한 컨트롤을 배열로 생성한다.
	  len = form.elements.length;
	  for (i = 0; i < len; i++) {
//    	  ComClearSeparator(form.elements[i]);
	    switch (form.elements[i].type) {
	      case "button":
	      case "reset":
	      case "submit":
	        break;
	      case "radio":
	      case "checkbox":
	          if (form.elements[i].checked == true) {
	            name[j] = form.elements[i].name;
	            value[j] = form.elements[i].value;
	            j++;
	          }
	          break;
	      case "select-one":
	          name[j] = form.elements[i].name;
	          var ind = form.elements[i].selectedIndex;
	          if(ind >= 0) {
	            if (form.elements[i].options[ind].value != '')
	              value[j] = form.elements[i].options[ind].value;
	            else
	              value[j] = form.elements[i].options[ind].text;
	          } else {
	            value[j] = "";
	          }
	          j++;
	          break;
	      case "select-multiple":
	          name[j] = form.elements[i].name;
	          var llen = form.elements[i].length;
	          var increased = 0;
	          for( k = 0; k < llen; k++) {
	            if (form.elements[i].options[k].selected) {
	              name[j] = form.elements[i].name;
	              if (form.elements[i].options[k].value != '')
	                value[j] = form.elements[i].options[k].value;
	              else
	                value[j] = form.elements[i].options[k].text;
	              j++;
	              increased++;
	            }
	          }
	          if(increased > 0) {
	            j--;
	          } else {
	            value[j] = "";
	          }
	          j++;
	          break;
	        default :
	          name[j] = form.elements[i].name;
	          value[j] = form.elements[i].value;
	          j++;
	    }
	  	//전송후에 폼의 마스크를 다시 셋팅한다.
//	    ComAddSeparator(form.elements[i]);
	  }

  //QueryString을 조합한다.
  for (i = 0; i < j; i++) {
     if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
  }

  //마지막에 &를 없애기 위함
  if (plain_text != "")
    plain_text = plain_text.substr(0, plain_text.length -1);
  return plain_text;
}

    /**
     * 2개 Sheet에서 행을 이동하는데 특정 컬럼(chkCol)이 체크된 행만 이동한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     IBS_Sheet2SheetCheck(mySheet1, mySheet2, 2);     //mySheet1의 2컬럼이 체크된 행만 mySheet2로 이동한다.
     *     IBS_Sheet2SheetCheck(mySheet1, mySheet2, "chk"); //mySheet1의 SaveName="chk"인 컬럼이 체크된 행만 mySheet2로 이동한다.
     * </pre>
     * @param {ibsheet}     fromSheet 이동 원본 Sheet의 Object id
     * @param {ibsheet}     toSheet   이동 대상 Sheet의 Object id
     * @param {int,string}  chkCol    체크박스 컬럼의 인덱스 또는 SaveName
     * @return 없음
     * @version 2.4.0.0
     * @see #IBS_Sheet2SheetStatus
     */
    function IBS_Sheet2SheetCheck(fromSheet, toSheet, chkCol)  {

      //함수 인자 유효성 확인
      if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
        return alert("Error : Please contact the administrator\n" + "Detail : fromSheet Parameter of Sheet2SheetCheck Functiont is not a IBSheet.");
      else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
        return alert("Error : Please contact the administrator\n" + "Detail : toSheet Parameter of Sheet2SheetCheck Functiont is not a IBSheet.");
      else if (chkCol < 0 || chkCol > fromSheet.LastCol)
    	  return alert("Error : Please contact the administrator\n" + "Detail : chkCol Paramter of Sheet2SheetCheck Function is not in area of column.");
      
      //데이터 행의 개수 확인
      var toRow = toSheet.RowCount;

      fromSheet.Redraw = false;
      toSheet.Redraw = false;

      //원본에서 역순으로 Check 된 데이터를 확인하여 이동
      for (ir = fromSheet.RowCount; ir>= 1; ir--) {
        //Check 되지 않은 경우 건너뜀
        if (fromSheet.CellValue(ir, chkCol) == '0') continue;

        //데이터 행 추가
        toRow = toSheet.DataInsert(toRow);

        //데이터 옮기기
        for (ic = 0; ic<=fromSheet.LastCol; ic++) {
          //체크 컬럼은 빼고 옮김
          if (ic == chkCol) continue;
          toSheet.CellValue(toRow,ic) = fromSheet.CellValue(ir,ic);
        }

        //원본에서 지움
        fromSheet.RowDelete(ir, false);
        toRow--;
      }

      toSheet.Redraw = true;
      fromSheet.Redraw = true;
    }


    /**
     * 2개 Sheet에서 행을 이동하는데 특정 트랜잭션 상태(sStatus)의 행만 이동한다. <br>
     * 트랜잭션 상태 코드는 조회("R"), 입력("I"), 수정("U"), 삭제("D")로 나눠지며, 이동해야할 트랜잭션상태코드를 "|"로 연결하여 조합한다. <br>
     * 예를 들어 다음 샘플을 참고한다.
     * <br><b>Example :</b>
     * <pre>
     *     IBS_Sheet2SheetStatus(mySheet1, mySheet2, "U");  //mySheet1에서 트랜잭션상태가 "수정"인 행만 mySheet2로 이동한다.
     *     IBS_Sheet2SheetStatus(mySheet1, mySheet2, "U|D");//mySheet1에서 트랜잭션상태가 "수정" 또는 "삭제"인 행만 mySheet2로 이동한다.
     * </pre>
     * @param {ibsheet}     fromSheet 이동 원본 Sheet의 Object id
     * @param {ibsheet}     toSheet   이동 대상 Sheet의 Object id
     * @param {string}      sStatus   트랜잭션상태코드
     * @return 없음
     * @version 2.4.0.0
     * @see #IBS_Sheet2SheetCheck
     */
    function IBS_Sheet2SheetStatus(fromSheet, toSheet, sStatus)  {

      //함수 인자 유효성 확인
      if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
        return alert("Error : Please contact the administrator\n" + "Detail : fromSheet Parameter of Sheet2SheetStatus Function is not a IBSheet.");
      else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
        return alert("Error : Please contact the administrator\n" + "Detail : toSheet Parameter of Sheet2SheetStatus Function is not a IBSheet.");

      //데이터 행의 개수 확인
      var fromRow = 0;

      var sRow = fromSheet.FindStatusRow(sStatus);
      var arrRow = sRow.split(";");

      var rowXml = "";
      var allXml = "<?xml version='1.0'  ?><SHEET>  <DATA>";

      //원본에서 역순으로 특정 상태의 행을 이동한다.
      for (ir = 0; ir < arrRow.length-1; ir++) {
        fromRow = arrRow[ir];

        //옮길 데이터를 xml로 구성한다.
        rowXml = "<TR>";
        for (ic = 0; ic<=fromSheet.LastCol; ic++) {
          rowXml += "<TD>" + fromSheet.CellValue(fromRow,ic) + "</TD>";
        }
        rowXml += "</TR>";

        allXml += rowXml;

      }

      //원본에서 역순으로 특정 상태의 행을 이동한다.
      for (ir = arrRow.length-2; ir >=0 ; ir--) {
        fromRow = arrRow[ir];
        //원본에서 지움
        fromSheet.RowDelete(fromRow, false);
      }
      allXml += "</DATA></SHEET>";

      toSheet.LoadSearchXml(allXml, true);
    }


    /**
     * Sheet의 모든 행을 조회XML 문자열로 구성하여 리턴한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sXml = IBS_GetDataSearchXml(mySheet);
     * </pre>
     * @param {ibsheet} sheet_obj  Sheet의 Object id
     * @return string
     * @version 2.4.0.0
     */
    function IBS_GetDataSearchXml(sheet_obj)  {

      //함수 인자 유효성 확인
      if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
    	  alert("Error : Please contact the administrator\n" + "Detail : sheet_obj Parameter of Data2SearchXml Function is not a IBSheet.");
        return "";
      }

      var rowXml = "";
      var allXml = "<?xml version='1.0'  ?>\n<SHEET>\n  <DATA TOTAL='"+ sheet_obj.TotalRows +"'>\n";

      for (ir = sheet_obj.HeaderRows; ir <= sheet_obj.LastRow; ir++) {
        rowXml = "    <TR>";
        for (ic = 0; ic<= sheet_obj.LastCol; ic++) {
          //셀의 값을 변수에 저장한다.
          var sValue = String(sheet_obj.CellValue(ir,ic));

          //특수문자(&, <, >)가 포함된 경우만 CDATA로 감싼다
          if (sValue.indexOf("&") > -1 || sValue.indexOf("<") > -1 || sValue.indexOf(">") > -1) {
            sValue = "<![CDATA[" + sValue + "]]>";
          }

          //XML을 만든다.
          rowXml += "<TD>" + sValue + "</TD>";
        }
        rowXml += "</TR>\n";

        allXml += rowXml;
      }

      allXml += "  </DATA>\n</SHEET>";

      return allXml;
    }


    /**
     * 각 컬럼의 Alias인 SaveName을 특정 구분자(delim)으로 조합하여 리턴한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sXml = IBS_ConcatSaveName(mySheet,"|");
     * </pre>
     * @param {ibsheet}     sheet  Sheet의 Object id
     * @param {string}      delim  문자열연결 구분자
     * @return string
     * @version 2.4.0.0
     */
    function IBS_ConcatSaveName(sheet, delim)
    {
      if (delim == null) delim = "|";
      
      //한진해운공통 - 맨 마지막에 "|"가 하나 더 붙는 문제를 해결하기 위해 아래 소스를 모두 수정함
      /*
      var savenames = "";
      for ( var n = 0; n <= sheet.LastCol; n++ )
      {
        savenames += sheet.ReadDataProperty(0, n, dpSaveName) + delim;
      }
      return savenames;
      */
      var savenames = new Array();
      for ( var n = 0; n <= sheet.LastCol; n++ )
      {
        savenames[n] = sheet.ReadDataProperty(0, n, dpSaveName);
      }
      return savenames.join(delim);
    }

    /**
     * Sheet에 존재하는 EtcData의 값을 폼의 객체에 채운다. 주로 조회 함수 사용후 이 함수를 사용한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     IBS_EtcDataToForm(document.frmData, mySheet);
     * </pre>
     * @param {form}    form     필수,Form 오브젝트
     * @param {ibsheet} ibsheet  필수,Sheet의 Object id
     * @return string
     * @version 2.4.0.0
     */
    function IBS_EtcDataToForm(form,ibsheet){
      if (typeof form != "object" || form.tagName != "FORM") {
        return alert("Error : Please contact the administrator\n" + "Detail : form Parameter of IBS_EtcDataToForm Function is not a FORM Tag.");
      }  else if (typeof ibsheet != "object" || ibsheet.tagName != "OBJECT") {
        return alert("Error : Please contact the administrator\n" + "Detail : ibsheet Parameter of IBS_EtcDataToForm Function is not a IBSheet Tag.");
      }

      //form을 리셋한다.
      form.reset();
      var j = 0;

      //사용가능한 컨트롤을 배열로 생성한다.
      len = form.elements.length;
      for (i = 0; i < len; i++) {
        if(form.elements[i].classid == undefined){
          var xvalue = ibsheet.EtcData(form.elements[i].name);
          if ( xvalue == undefined)  continue;
          switch (form.elements[i].type) {
            case "button":
            case "reset":
            case "submit":
              break;
            case "radio":
              var eRadio = document.all[form.elements[i].name];
              var idx = 0;
              for(var k = 0; k < eRadio.length; k++) {
                if (eRadio[k].value == xvalue) {
                  idx = k;
                  break;
                }
              }
              eRadio[idx].checked = true;
              break;
            case "checkbox":
              form.elements[i].checked = xvalue;
              break;
            case "select-one":
                var eOpt = form.elements[i].options;
                var idx = 0;
                if(eOpt != null && eOpt.length != null && eOpt.length >= 1) {
                  var opt_len = eOpt.length;
                  for(var k = 0; k < opt_len; k++) {
                    if(eOpt[k].value == xvalue) {
                      idx = k;
                      break;
                    }
                  }
                }
                form.elements[i].selectedIndex = idx;
                break;
              case "select-multiple":  //선택될 값이 '|' 를 구분자로 입력되어있다고 가정한다.
                var eOpt = form.elements[i].options;
                var idx = 0;
                if(eOpt != null && eOpt.length != null && eOpt.length >= 1) {
                  var opt_len = eOpt.length;
                  var tvalue = xvalue.split("|");
                  var tval_len = tvalue.length;
                  for(var k = 0; k < opt_len; k++) {
                    for(var m = 0; m < tval_len;m++){
                      if(eOpt[k].value==tvalue[m])  eOpt[k].selected = true;
                    }
                  }
                }
                break;
              default :
                 form.elements[i].value = xvalue;
            }//switch
        }else{
          var xvalue = ibsheet.EtcData(form.elements[i].id);
          if ( xvalue == undefined)  continue;
          switch(form.elements[i].classid){
            case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E"://마스크에디트 경우
              form.elements[i].Value = xvalue;
              break;
            case CLSID_IBMCOMBO: //콤보의 경우
              if(form.elements[i].UseCode){
                form.elements[i].Code = xvalue;
              }else{
                form.elements[i].Index = xvalue;
              }
              break;
          }//switch
        }//if classid
      }//for
    }

    /**
     * 이 함수는 대량의 데이터를 조회시 조회속도를 개선하기 위해서 Sax를 이용한 조회 함수이다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     IBS_DoSearchSax(mySheet,"EES_EQR_060.xml",FormQueryString(formObj));
     * </pre>
     * @param   {ibsheet} sheetobj      필수,IBSheet Object ID
     * @param   {string}  PageUrl       필수,조회 처리할 페이지 파일 이름
     * @param   {string}  CondParam     선택,조회조건 QueryString
     * @param   {string}  PageParam     선택,페이지 조건 QueryString
     * @param   {bool}    IsAppend      선택,조회된 내용을 이어서 쓸지 여부
     * @param   {number}  AppendRow     선택,IsAppend 인자가 true인 경우 이어쓸 행의 Row Index
     * @return  bool, 조회 완료 여부
     * @version 3.1.0.0
     */
    function IBS_DoSearchSax(sheetobj, PageUrl, CondParam, PageParam, UsePost, IsAppend, AppendRow)
    {
      //함수의 인자 유효성 확인
      if (typeof sheetobj != "object" || sheetobj.tagName != "OBJECT") {
        return alert("Error : Please contact the administrator\n" + "Detail : sheetobj Parameter of IBS_SpeedDoSearch Function is not a IBSheet Tag.");
      }

      if (CondParam == "undefined") CondParam = "";
      if (PageParam == "undefined") PageParam = "";
      if (UsePost   == "undefined") UsePost   = false;
      if (IsAppend == "undefined")  IsAppend  = false;
      if (AppendRow == "undefined") AppendRow = -1;

      //MassOfSearch=1인 경우 Sax를 사용하지 않고, DoSearch를 그대로 이용한다.
      if (sheetobj.MassOfSearch==1) {
        if (UsePost){
          return sheetobj.DoSearch(PageUrl, CondParam, PageParam, IsAppend, AppendRow);
        }else{
          return sheetobj.DoSearch4Post(PageUrl, CondParam, PageParam, IsAppend, AppendRow);
        }
      }

      //1. 서버를 연결하여 조회결과를 XML로 가져온다.
      var s_Xml = sheetobj.GetSearchXml(PageUrl, CondParam, PageParam, UsePost);

      //2. 가져온 조회XML에서 SAX가 파싱할수 없는 특수문자를 제거한다.
      s_Xml=s_Xml.replace(/[\u0000-\u0008\u000B-\u000C\u000E-\u001F\uD800-\uDB7F\uDB80-\uDBFF\uDC00-\uDFFF\uFFFE\uFFFF]/g, " ");

      //3. 특수문자가 걸러진 XML을 파싱하여 Sheet로 로드한다.
      return sheetobj.LoadSearchXml4Sax(s_Xml, IsAppend, AppendRow);
    }



    /**
     * Sheet의 특정행의 값을 Form의 각 컨트롤에 값을 복사한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     IBS_CopyRowToForm(mySheet, document.mainForm);
     *     IBS_CopyRowToForm(mySheet, document.mainForm, mySheet.SelectedRow);
     *     IBS_CopyRowToForm(mySheet, document.mainForm, 1, "str_");
     *
     *     &lt;script for="mySheet" event="OnSelectCell(or,oc,nr,nc)"&gt;
     *       if(nr &lt; HeaderRows || nr &gt; LastRow||RowCount  == 0) return mainForm.reset();
     *       if(or==nr) return;
     *
     *       IBS_CopyRowToForm(mySheet, mainForm);
     *     &lt;/script&gt;
     * </pre>
     * @param   {ibsheet} sheetobj  필수,IBSheet Object ID
     * @param   {form}    formobj   필수,html의 Form 오브젝트 Name
     * @param   {int}     row       선택,IBSheet의 복사할 행번호, 인자를 설정하지 않으면 현재 선택된 행이 됨
     * @param   {string}  prefix    선택,Form 안에 있는 컨트롤의 이름앞에 붙는 문자열, 예)"obj_CardNo"이면 이인자는 "obj_"임, 인자를 설정하지 않으면 "frm_"가 기본임
     * @return  없음
     * @version 3.4.0.50
     * @see #IBS_CopyFormToRow
     */
    function IBS_CopyRowToForm(sheetobj, formobj, row, prefix){
      //함수의 인자 유효성 확인-시작
      if (sheetobj==null || typeof sheetobj != "object" || sheetobj.tagName != "OBJECT") {
        return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 sheetobj 인자는 IBSheet 태그가 아닙니다.");
      } else if (formobj==null || typeof formobj != "object" || formobj.tagName != "FORM") {
        return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 formobj 인자는 FORM 태그가 아닙니다.");
      } else if (row!=null && (isNaN(row) || row < 0 || row > sheetobj.LastRow)) {
        return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 row 인자값이 잘못되었습니다.");
      }
      //함수의 인자 유효성 확인-종료

      //HTML컨트롤의 name 앞에 붙는 글자
      if (prefix == null || prefix=="") prefix = "frm_";
      if (row == null) row=sheetobj.SelectRow;

      //Sheet의 컬럼개수만큼 찾아서 HTML의 Form 각 Control에 값을 설정한다.
      //컬럼개수만큼 루프 실행
      for(var col=0;col<=sheetobj.LastCol ;col++){
        //컬럼의 별명을 문자열로 가져온다.
        var col_alias = sheetobj.ColSaveName(col)
        if (col_alias=="") continue;
        var sheetvalue = sheetobj.CellValue(row,col);

        //폼에 있는 해당 이름의 컨트롤을 가져온다.예)"frm_CardNo"
        var frmchild = formobj.elements(prefix +col_alias);

        //폼에 해당하는 이름의 컨트롤이 없는 경우는 계속 진행한다.
        if(frmchild==null) continue;

        var sType = frmchild.type;
        //radio의 경우 frmchild가 배열형태가 되므로, frmchild.type으로는 타입을 알수 없다.
        if (sType==undefined && frmchild.length>0) sType=frmchild[0].type;

        //타입별로 값을 설정한다.
        switch(sType) {
          case "button":
          case "reset":
          case "submit":
            break;
          case "radio":
            for (idx=0; idx<frmchild.length; idx++) {
             if(frmchild[idx].value == sheetvalue) {
                frmchild[idx].checked=true;
                break;
              }
            }
            break;
          case "checkbox":
            frmchild.checked = (sheetvalue==1);
            break;
          default :
            frmchild.value = sheetvalue;
        }//end of switch
      }//end of for(col)
    }

 /**
     * Form의 각 컨트롤에 값을 Sheet의 특정행의 각 컬럼에 복사한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     IBS_CopyFormToRow(document.mainForm, mySheet);
     *     IBS_CopyFormToRow(document.mainForm, mySheet, mySheet.SelectRow);
     *     IBS_CopyFormToRow(document.mainForm, mySheet, 1, "str_");
     * </pre>
     * @param   {form}    formobj   필수,html의 Form 오브젝트 Name
     * @param   {ibsheet} sheetobj  필수,IBSheet Object ID
     * @param   {int}     row       선택,IBSheet의 붙여넣을 행번호, 인자를 설정하지 않으면 현재 선택된 행이 됨
     * @param   {string}  prefix    선택,Form 안에 있는 컨트롤의 이름앞에 붙는 접두사 문자열, 예)"obj_CardNo"이면 이인자는 "obj_"임, 인자를 설정하지 않으면 "frm_"가 기본임
     * @return  없음
     * @version 3.4.0.50
     * @see #IBS_CopyRowToForm
     */
    function IBS_CopyFormToRow(formobj, sheetobj, row, prefix){
      //함수의 인자 유효성 확인-시작
      if (sheetobj==null || typeof sheetobj != "object" || sheetobj.tagName != "OBJECT") {
        return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 sheetobj 인자는 IBSheet 태그가 아닙니다.");
      }else if (formobj==null || typeof formobj != "object" || formobj.tagName != "FORM") {
        return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 formobj 인자는 FORM 태그가 아닙니다.");
      }else if (row!=null && (isNaN(row) || row < 0 || row > sheetobj.LastRow)) {
        return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 row 인자값이 잘못되었습니다.");
      }

      //HTML컨트롤의 name 앞에 붙는 글자
      if (prefix == null || prefix=="") prefix = "frm_";
      if (row == null) row=sheetobj.SelectRow;

      sheetobj.Redraw=false;

      //Sheet의 컬럼개수만큼 찾아서 HTML의 Form 각 Control에 값을 설정한다.
      //컬럼개수만큼 루프 실행
      for(var col=0;col<=sheetobj.LastCol ;col++){
        //컬럼의 별명을 문자열로 가져온다.
        var col_alias = sheetobj.ColSaveName(col)
        if (col_alias=="") continue;

        //폼에 있는 해당 이름의 컨트롤을 가져온다.예)"frm_CardNo"
        var frmchild = formobj.elements(prefix +col_alias);

        //폼에 해당하는 이름의 컨트롤이 없는 경우는 계속 진행한다.
        if(frmchild==null) continue;

        var sType = frmchild.type;
        var sValue;
        //radio의 경우 frmchild가 배열형태가 되므로, frmchild.type으로는 타입을 알수 없다.
        if (sType==undefined && frmchild.length>0) sType=frmchild[0].type;

        //타입별로 값을 설정한다.
        switch(sType) {
          case undefined:
          case "button":
          case "reset":
          case "submit":
            break;
          case "radio":
            for (idx=0; idx<frmchild.length; idx++) {
             if(frmchild[idx].checked) {
                sValue = frmchild[idx].value;
                break;
              }
            }
            break;
          case "checkbox":
            sValue =(frmchild.checked)?1:0;
            break;
          default :
            sValue = frmchild.value;
        }//end of switch

        sheetobj.CellValue2(row,col) = sValue;

      }//end of for(col)

      sheetobj.Redraw=true;
    }

	/**
	 * 시트의 콤보중 컬럼이 여러개 일때 선택된 값중 원하는 컬럼의 값을 리턴한다.
     * <br><b>Example :</b>
     * <pre>
     *     ComGetComboText(sheetObj, row, col,1);
     * </pre>
	 * 
	 * @param {ibsheet}     sheetObj  필수, IBSheet Object ID
	 * @param {int}  		row       필수, 대상 Col index
	 * @param {int}         col       필수, 대상 Row index
	 * @param {int}         ishowcol  선택, . default=0
	 * @return 없슴
	 */
    function ComGetComboText(sheetObj, Row, Col, iGetCol) {

	    if (iGetCol==undefined || iGetCol==null) iGetCol = 0;
	
		var sText = sheetObj.GetComboInfo(Row,Col,"Text");
	  	var idx   = sheetObj.GetComboInfo(Row,Col, "SelectedIndex");
	  	var arrText = sText.split("|");
	    var values = arrText[idx].split("\t");
	    return values[iGetCol];
	
    }
	 
    /**
     * IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
     * <b>Example :</b>
     * <pre>
     *     ComSetIBCombo(sheetObj,sXml,"rcv_de_term_cd",false,1);
     * </pre>
     *
     * @param {string} sheetObj 필수
     * @param {string} sXml 필수, Combo에 채울 데이터(IBSheet를 통해 받아온 xml 문자열.)
     * @param {string} title 필수, Combo field명(IBSheet SaveName).
     * @param {string} iBlank 선택, Combo의 첫번째로우를 블랭크로 설정
     * @param {string} sCol 선택, 멀티콤보일경우 콤보를 선택하면 콤보에 보여질 순서설정(0:코드 or 1:description)
     * @param {string} dCode 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Code값
     * @param {string} dText 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Text값
	 * @param {string} bFlag multicombo 용 XML 파일을 Sheet 내에서 Combo 형태로 사용할 경우, Text 에 Code+"\t"+Text 형태로 만들어 사용할 수 있게 해 줌	      
     * (코드|디스크립션 형태가 아닐 경우는 0으로 설정해야함)
     * @return 없슴
     * @author 공백진
     * @version 2009.04.30
     */
    function ComSetIBCombo(sheetObj, sXml, title, iBlank, sCol, dCode, dText, bFlag){
        var showCol = 0;
        if (bFlag == undefined || bFlag == ""){
            bFlag = false;
        }
        if (sCol != undefined && sCol !=""){
            showCol = sCol;
        }
        if (iBlank == undefined || iBlank == ""){
            iBlank = false;
        }
        var arrData = ComXml2ComboString(sXml, "cd", "nm");
        if (bFlag == true && arrData != null){
            var arrCode = arrData[0].split("|");
            var arrName = arrData[1].split("|");
            var conData = "";
            for(i=0; i < arrName.length;i++){
                if(i==0){
                    arrName[i] = arrCode[i]+"\t"+arrName[i];
                }else{
                    arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
                }
                conData = conData.concat(arrName[i]);
            }

            arrData[1] = conData;
        }

        if(iBlank){
            arrData[0] = " |" + arrData[0];
            arrData[1] = " |" + arrData[1];
        }

        if (arrData != null){
            sheetObj.InitDataCombo(0,title, arrData[1], arrData[0],dText, dCode, showCol);
        }

    }
	 
	/*
	* function명 : IBS_SaveGridSetting()
	* 기능
	*  - Sheet 세팅 저장 (Cookie, DB)
	*    : Column 배열순서, Column 정렬 옵션(ASC/DESC), Column Size
	*    : Cookie => UserData => DB 방식으로 변경
	*    : IFrame 방식 / Ajax / behavior:url(#default#download) 중 택일
	*      (표준에 맞는가, 속도는 어떤 방식이 제일 빠른가) => behavior를 이용하는 것이 무난할 것으로 보임
	*    : Framework을 타게 할 것인가? (.do / .screen) => 속도면에서는 떨어짐
	*/
	function IBS_SaveGridSetting(usr_id, scrn_id, sheetObj, bMsgOut) {
		try {
			if(bMsgOut != null && !bMsgOut) {
				IBS_bMsgOut = bMsgOut;
			} else {
				IBS_bMsgOut = true;
			}
			
			var sh_id = sheetObj.id;
			var hdr_desc = "";
			
			var colSeq = "";
			var colSize = "";
			var colOrder = "";
			
			// 1. Column 배열 순서
			with(sheetObj) {
				for(var i=0; i<=LastCol; i++) {
					if(i == 0)
						colSeq += ColSaveName(i);
					else
						colSeq += "|" + ColSaveName(i);
				}
			}
			
			// 2. Column Size
			with(sheetObj) {
				for(var i=0; i<=LastCol; i++) {
					if(i == 0)
						colSize += ColWidth(i);
					else
						colSize += "|" + ColWidth(i);
				}
			}
			
			hdr_desc = colSeq + "||" + colSize	
			sendIBHeaderRequest("SAVE", usr_id, scrn_id, sh_id, hdr_desc)		
		} catch(e) {
			
		}
	}

	/*
	 * function명 : IBS_RestoreGridSetting()
	 * 기능
	 *  - Cookie/DB에 저장된 IBSheet 세팅 적용
	 *    : Column 배열순서, Column 정렬 옵션(ASC/DESC), Column Size
	 *    : Cookie => UserData => DB 방식으로 변경
	 */
	 function IBS_RestoreGridSetting(usr_id, scrn_id, sheetObj, bMsgOut) {
		try {
			
			// 결과 Message 출력 여부 세팅
			if(bMsgOut != null && !bMsgOut) {
				IBS_bMsgOut = bMsgOut;
			} else {
				IBS_bMsgOut = true;
			}
			
			var sh_id = sheetObj.id;
			sendIBHeaderRequest("SEARCH", usr_id, scrn_id, sh_id);

		} catch(e) {
			
		}
	}
	
	/*
	 * function명 : IBS_DelGridSetting()
	 * 기능
	 *  - Cookie/DB에 저장된 IBSheet 세팅 삭제
	 *    : Column 배열순서, Column 정렬 옵션(ASC/DESC), Column Size
	 */
	 function IBS_DelGridSetting(usr_id, scrn_id, sheetObj, bMsgOut) {
		try {
			// 결과 Message 출력 여부 세팅
			if(bMsgOut != null && !bMsgOut) {
				IBS_bMsgOut = bMsgOut;
			} else {
				IBS_bMsgOut = true;
			}
			
			var sh_id = sheetObj.id;
			
			sendIBHeaderRequest("DEL", usr_id, scrn_id, sh_id)

		} catch(e) {
			
		}
	}
	 
	function sendIBHeaderRequest(mode, usr_id, scrn_id, sh_id, hdr_desc) {
		var userIframe = document.all.ibs_udataIframe;
		var userFrm = document.all.ibs_udataFrm;
		var userInputMode = document.all.ibs_udataMode;
		var userInputUsrId = document.all.ibs_udataUsrId;
		var userInputScrnId = document.all.ibs_udataScrnId;
		var userInputShId = document.all.ibs_udataShId;
		var userInputHdrDesc = document.all.ibs_udataHdrDesc;
		var userInputMsgOut = document.all.ibs_udataMsgOut;
			
		if(!userIframe) {
			userIframe = document.createElement("<iframe name='ibs_udataIframe' id='ibs_udataIframe' style='display:none'></iframe>");
			userFrm = document.createElement("<form name='ibs_udataFrm' method='post'></form>");
			userInputMode = document.createElement("<input type='hidden' name='ibs_udataMode'>");
			userInputUsrId = document.createElement("<input type='hidden' name='ibs_udataUsrId'>");
			userInputScrnId = document.createElement("<input type='hidden' name='ibs_udataScrnId'>");
			userInputShId = document.createElement("<input type='hidden' name='ibs_udataShId'>");
			userInputHdrDesc = document.createElement("<input type='hidden' name='ibs_udataHdrDesc'>");
			userInputMsgOut = document.createElement("<input type='hidden' name='ibs_udataMsgOut'>");
			
			userFrm.appendChild(userInputMode);
			userFrm.appendChild(userInputUsrId);
			userFrm.appendChild(userInputScrnId);
			userFrm.appendChild(userInputShId);
			userFrm.appendChild(userInputHdrDesc);
			userFrm.appendChild(userInputMsgOut);
			
			document.body.appendChild(userIframe);
			document.body.appendChild(userFrm);
		} 
		userInputMode.value = mode;
		userInputUsrId.value = usr_id;
		userInputScrnId.value = scrn_id;
		userInputShId.value = sh_id;
		userInputHdrDesc.value = hdr_desc;
		userInputMsgOut.value = IBS_bMsgOut;
		
		userFrm.target = "ibs_udataIframe";
		userFrm.action = "/hanjin/syscommon/common/ibsheet/IBS_common.jsp";
		userFrm.submit();
	}
