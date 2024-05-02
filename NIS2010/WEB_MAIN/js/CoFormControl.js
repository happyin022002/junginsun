/**
===============================================================================
프로그램  명  : 폼컨트롤 관련 공통 함수 정의 Script
프로그램개요  : 폼컨트롤 관련 기능을 정의한다.
작   성   자  : 이경희
작   성   일  : 2008-11
===============================================================================
수정자/수정일 :
수정사유/내역 :
===============================================================================
*/


    /*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 HTML태그(Object) 관련 함수가 정의되어 있다.이 파일에서 제공하는 함수를 사용하기 위해서는 먼저 CoCommon.js 파일과 CoMessage.js파일을 include하여야 한다.
     * @author 한진해운
     */

    /**
     * @class CoFormControl : HTML태그(Object) 관련 각종 함수들을 정의하며 파일에서 제공하는 함수를 사용하기 위해서는 먼저 <font color="red">CoCommon.js 파일과 CoMessage.js파일</font>을 include하여야 한다.
     */
    function CoFormControl() {
        this.ComAlertFocus         = ComAlertFocus;
        this.ComSetFocus           = ComSetFocus;
        this.ComEnableObject       = ComEnableObject;
        this.ComEnableManyObjects  = ComEnableManyObjects;
        this.ComShowObject         = ComShowObject;
        this.ComShowManyObjects    = ComShowManyObjects;
        this.ComClearObject        = ComClearObject;
        this.ComClearManyObjects   = ComClearManyObjects;
        this.ComAddSeparator       = ComAddSeparator;
        this.ComClearSeparator     = ComClearSeparator;
        this.ComKeyOnlyNumber      = ComKeyOnlyNumber;
        this.ComKeyOnlyAlphabet    = ComKeyOnlyAlphabet;
        this.ComKeyEnter           = ComKeyEnter;
        this.ComSetNextFocus       = ComSetNextFocus;
        this.ComClearCombo         = ComClearCombo;
        this.ComAddComboItem       = ComAddComboItem;
        this.ComChkRequired        = ComChkRequired;
        this.ComGetObjValue        = ComGetObjValue;
        this.ComSetObjValue        = ComSetObjValue;
        this.ComGetObjText         = ComGetObjText;
        this.ComGetCookie          = ComGetCookie;
        this.ComSetCookie          = ComSetCookie;
        this.ComClearCookie        = ComClearCookie;
        this.ComResetAll           = ComResetAll;
        this.ComChkValid           = ComChkValid;
        this.ComChkObjValid        = ComChkObjValid;
    }

    /*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
    /** FOMR CONTROL - form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값 */
    var INIT        = 0;
    var ADD         = 1;
    var SEARCH      = 2;
    var SEARCHLIST  = 3;
    var MODIFY      = 4;
    var REMOVE      = 5;
    var REMOVELIST  = 6;
    var MULTI       = 7;
    var PRINT       = 8;
    var REPLY       = 9;

    /** FOMR CONTROL - DEFAULT COMMAND 01 ~ 60 */
    var COMMAND01 = 11;
    var COMMAND02 = 12;
    var COMMAND03 = 13;
    var COMMAND04 = 14;
    var COMMAND05 = 15;
    var COMMAND06 = 16;
    var COMMAND07 = 17;
    var COMMAND08 = 18;
    var COMMAND09 = 19;
    var COMMAND10 = 20;
    var COMMAND11 = 21;
    var COMMAND12 = 22;
    var COMMAND13 = 23;
    var COMMAND14 = 24;
    var COMMAND15 = 25;
    var COMMAND16 = 26;
    var COMMAND17 = 27;
    var COMMAND18 = 28;
    var COMMAND19 = 29;
    var COMMAND20 = 30;
    var COMMAND21 = 31;
    var COMMAND22 = 32;
    var COMMAND23 = 33;
    var COMMAND24 = 34;
    var COMMAND25 = 35;
    var COMMAND26 = 36;
    var COMMAND27 = 37;
    var COMMAND28 = 38;
    var COMMAND29 = 39;
    var COMMAND30 = 40;
    var COMMAND31 = 41;
    var COMMAND32 = 42;
    var COMMAND33 = 43;
    var COMMAND34 = 44;
    var COMMAND35 = 45;
    var COMMAND36 = 46;
    var COMMAND37 = 47;
    var COMMAND38 = 48;
    var COMMAND39 = 49;
    var COMMAND40 = 50;
    var COMMAND41 = 51;
    var COMMAND42 = 52;
    var COMMAND43 = 53;
    var COMMAND44 = 54;
    var COMMAND45 = 55;
    var COMMAND46 = 56;
    var COMMAND47 = 57;
    var COMMAND48 = 58;
    var COMMAND49 = 59;
    var COMMAND50 = 60;
    var COMMAND51 = 61;
    var COMMAND52 = 62;
    var COMMAND53 = 63;
    var COMMAND54 = 64;
    var COMMAND55 = 65;
    var COMMAND56 = 66;
    var COMMAND57 = 67;
    var COMMAND58 = 68;
    var COMMAND59 = 69;
    var COMMAND60 = 70;
    

    /*================================
     * 설계자의 요청에 의한 상수 추가
     * SEARCH01 ~ 40
     * MODIFY01~20
     * REMOVE01~20
     * MULTI01~20
     * 상수의 int 값으로는 101 ~ 220 까지 사용하기로 함
     =================================*/

    var SEARCH01 = 101;
    var SEARCH02 = 102;
    var SEARCH03 = 103;
    var SEARCH04 = 104;
    var SEARCH05 = 105;
    var SEARCH06 = 106;
    var SEARCH07 = 107;
    var SEARCH08 = 108;
    var SEARCH09 = 109;
    var SEARCH10 = 110;
    var SEARCH11 = 111;
    var SEARCH12 = 112;
    var SEARCH13 = 113;
    var SEARCH14 = 114;
    var SEARCH15 = 115;
    var SEARCH16 = 116;
    var SEARCH17 = 117;
    var SEARCH18 = 118;
    var SEARCH19 = 119;
    var SEARCH20 = 120;
    
    var SEARCH21 = 201;
    var SEARCH22 = 202;
    var SEARCH23 = 203;
    var SEARCH24 = 204;
    var SEARCH25 = 205;
    var SEARCH26 = 206;
    var SEARCH27 = 207;
    var SEARCH28 = 208;
    var SEARCH29 = 209;
    var SEARCH30 = 210;
    var SEARCH31 = 211;
    var SEARCH32 = 212;
    var SEARCH33 = 213;
    var SEARCH34 = 214;
    var SEARCH35 = 215;
    var SEARCH36 = 216;
    var SEARCH37 = 217;
    var SEARCH38 = 218;
    var SEARCH39 = 219;
    var SEARCH40 = 220;

    var SEARCHLIST01 = 121;
    var SEARCHLIST02 = 122;
    var SEARCHLIST03 = 123;
    var SEARCHLIST04 = 124;
    var SEARCHLIST05 = 125;
    var SEARCHLIST06 = 126;
    var SEARCHLIST07 = 127;
    var SEARCHLIST08 = 128;
    var SEARCHLIST09 = 129;
    var SEARCHLIST10 = 130;
    var SEARCHLIST11 = 131;
    var SEARCHLIST12 = 132;
    var SEARCHLIST13 = 133;
    var SEARCHLIST14 = 134;
    var SEARCHLIST15 = 135;
    var SEARCHLIST16 = 136;
    var SEARCHLIST17 = 137;
    var SEARCHLIST18 = 138;
    var SEARCHLIST19 = 139;
    var SEARCHLIST20 = 140;

    var MODIFY01 = 141;
    var MODIFY02 = 142;
    var MODIFY03 = 143;
    var MODIFY04 = 144;
    var MODIFY05 = 145;
    var MODIFY06 = 146;
    var MODIFY07 = 147;
    var MODIFY08 = 148;
    var MODIFY09 = 149;
    var MODIFY10 = 150;
    var MODIFY11 = 151;
    var MODIFY12 = 152;
    var MODIFY13 = 153;
    var MODIFY14 = 154;
    var MODIFY15 = 155;
    var MODIFY16 = 156;
    var MODIFY17 = 157;
    var MODIFY18 = 158;
    var MODIFY19 = 159;
    var MODIFY20 = 160;


    var REMOVE01 = 161;
    var REMOVE02 = 162;
    var REMOVE03 = 163;
    var REMOVE04 = 164;
    var REMOVE05 = 165;
    var REMOVE06 = 166;
    var REMOVE07 = 167;
    var REMOVE08 = 168;
    var REMOVE09 = 169;
    var REMOVE10 = 170;
    var REMOVE11 = 171;
    var REMOVE12 = 172;
    var REMOVE13 = 173;
    var REMOVE14 = 174;
    var REMOVE15 = 175;
    var REMOVE16 = 176;
    var REMOVE17 = 177;
    var REMOVE18 = 178;
    var REMOVE19 = 179;
    var REMOVE20 = 180;

    var MULTI01 = 181;
    var MULTI02 = 182;
    var MULTI03 = 183;
    var MULTI04 = 184;
    var MULTI05 = 185;
    var MULTI06 = 186;
    var MULTI07 = 187;
    var MULTI08 = 188;
    var MULTI09 = 189;
    var MULTI10 = 190;
    var MULTI11 = 191;
    var MULTI12 = 192;
    var MULTI13 = 193;
    var MULTI14 = 194;
    var MULTI15 = 195;
    var MULTI16 = 196;
    var MULTI17 = 197;
    var MULTI18 = 198;
    var MULTI19 = 199;
    var MULTI20 = 200;
    
    var CofieldFlag = false;
    var pastEventNum = 0;
    var pastEventObj = null;

    /**
     * 메세지를 알리는 메세지박스 표시 후 지정된 HTML태그(Object)로 focus를 옮긴다. <br>
     * HTML태그(Object)가 input type="text"인 경우 focus 설정과 함께 글자를 블록으로 select설정 까지 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComAlertFocus(txtDate,           ComGetMsg('COM12130','Period','First Element'));
     *     ComAlertFocus(formObj.fm_prd_dt, "From Date is Later than To Date");
     * </pre>
     * @param {object} obj     필수,메시지 표시 후 focus를 가질 HTML태그(Object)
     * @param {string} message 필수,메세지박스에 보여질 메세지
     * @return 없음
     * @see #ComSetFocus
     * @see #ComSetNextFocus
     */
    function ComAlertFocus(obj, message) {
    	try{
    		if ( message != '') ComShowMessage( message );
    		ComSetFocus(obj);
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * 인자로 받은 HTML태그(Object)로 focus를 옮긴다. focus를 설정하고, 글자를 블록으로 select 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComSetFocus(txtDate);   //결과 : txtDate 컨트롤에 포커스를 설정한다.
     * </pre>
     * @param {object} obj     필수,focus를 가질 HTML태그(Object)
     * @return 없음
     * @see #ComAlertFocus
     * @see #ComSetNextFocus
     */
    function ComSetFocus(obj) {
    	//obj가 숨겨져 있는 경우 focus설정하면 에러가 발생함
        try {
            obj.focus();
            
            //글자가 있는 경우 블럭으로 선택할수 있도록 한다.
            if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
            
            //OnChange이벤트를 Cancel하여 다른 Object로의 포커스 이동을 막는다.
			if(event.srcElement == obj && event.type=="change") event.returnValue=false; 
        } catch(err) {;}
    }

    /**
     * 인자로 받은 HTML태그(Object)의 사용 가능/불가능 상태를 변경한다. <br>
     * &lt;input type="text"&gt;와 &lt;input type="password"&gt;의 경우 readOnly속성과 backgroundColor,color를 변경하고,  <br>
     * &lt;img&gt;의 경우 disable속성과  cursor,filter를 변경한다. <br>
     * 그외 HTML태그(Object) disable속성을 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComEnableObject(txtName,  true);   // 결과 : &lt;input type="text" name="txtName"&gt;을 enable 상태로 설정한다.
     *     ComEnableObject(txtName,  false);  // 결과 : &lt;input type="text" name="txtName"&gt;을 disable 상태로 설정한다.
     *     ComEnableObject(btn_save, true);   // 결과 : &lt;img name="btn_save"&gt;을 enable 상태로 설정한다.
     *     ComEnableObject(btn_save, false);  // 결과 : &lt;img name="btn_save"&gt;을 disable 상태로 설정한다.
     * </pre>
     * @param {object} obj     필수,대상 HTML태그(Object)
     * @param {bool}   bEnable 필수,사용 가능/불가능 여부를 true/false로 설정한다.
     * @return 없음
     * @see #ComEnableManyObjects
     */
    function ComEnableObject(obj, bEnable)
    {
        try {
        	//disabled나 readOnly 설정하기
            switch( obj.type ) {
                case "password" :
                case "text" :
                	obj.readOnly = !bEnable;
                    break;
                default:
                     if(obj.tagName != "OBJECT")  //20150127 Ibsheet exit
                                obj.disabled = !bEnable;
//                    obj.disabled = !bEnable;
            }

			//설정에 따라 css 처리하기
            switch( obj.type ) {
                case "select-one" :
                case "text" :
                    if (bEnable){
                        if (obj.className=="input2_1"){	//회색바탕 - 필수입력 빨강색
                        	obj.className = "input2";	//흰색바탕 - 필수입력 빨강색
                        } else {
                        	obj.className = "input";    //흰색바탕
                        }
                    } else {
                        if (obj.className=="input2"){	//희색바탕 - 필수입력 빨강색
                        	obj.className = "input2_1";	//회색바탕 - 필수입력 빨강색
                        } else {
                        	obj.className = "input2";   //회색바탕
                        }
                    }
                    break;

                case "textarea":
                    if (bEnable){
                    	obj.className = "textarea";
                    } else {
                    	obj.className = "textarea2";
                    }
                    break;

				default :
                    if (obj.tagName=="IMG") {
                        if (bEnable){
                            obj.style.cursor = "hand";
                            obj.style.filter="";
                        } else {
                            obj.style.cursor = "default";
                            obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
                        }
                    }
            }

        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * 인자로 받은 모든 HTML태그(Object)들의 사용 가능/불가능 상태를 변경한다. {@link #ComEnableObject}함수를 이용하여 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComEnableManyObjects(true, txtName, btn_save);  //두번째 인자부터 마지막인자까지 설정된 모든컨트롤을 enable 상태로 변경한다.
     *     ComEnableManyObjects(false, txtName, btn_save); //두번째 인자부터 마지막인자까지 설정된 모든컨트롤을 disable 상태로 변경한다.
     * </pre>
     * @param {bool}   bEnable 필수,사용 가능/불가능 여부를 true/false로 설정한다.
     * @param {object} objs    필수,대상 HTML태그(Object)들로 원하는 개수만큼 여러개 설정한다.
     * @return 없음
     * @see #ComEnableObject
     */
    function ComEnableManyObjects(bEnable, objs) {
        try {
            var args = arguments;

            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) ComEnableObject(args[i], bEnable);
            } // end for
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * 인자로 받은 HTML태그(Object)의 obj.style.display 속성을 변경하여 화면에 표시여부를 변경시킨다. <br>
     * 주로 Tab형태 div 태그를 사용할때 이 함수를 사용한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComShowObject(txtName,  true);   // 결과 : txtName컨트롤을 show한다.
     *     ComShowObject(txtName,  false);  // 결과 : txtName컨트롤을 hide한다.
     * </pre>
     * @param {object} obj     필수,대상 HTML태그(Object)
     * @param {bool}   bShow   필수,표시여부를 true/false로 설정한다.
     * @return 없음
     * @see #ComShowManyObjects
     */
    function ComShowObject(obj, bShow) {
        try {
            if (bShow) {
                obj.style.display = "";
            } else {
                obj.style.display = "none";
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * 인자로 받은 모든 HTML태그(Object)들의 화면에 표시여부를 변경한다. {@link #ComShowObject}함수를 이용하여 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComShowManyObjects(true, txtName, btn_save);  //두번째 인자부터 마지막인자까지 설정된 모든컨트롤을 show한다.
     *     ComShowManyObjects(false, txtName, btn_save); //두번째 인자부터 마지막인자까지 설정된 모든컨트롤을 hide한다.
     * </pre>
     * @param {bool}   bShow   필수,화면에 표시여부를 true/false로 설정한다.
     * @param {object} objs    필수,대상 HTML태그(Object)들로 원하는 개수만큼 여러개 설정한다.
     * @return 없음
     * @see #ComShowObject
     */
    function ComShowManyObjects(bShow, objs) {
        try {
            var args = ComShowManyObjects.arguments;

            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) ComShowObject(args[i], bShow);
            } // end for
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * 인자로 받은 HTML태그(Object)의 value값을 초기화시킨다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComClearObject(txtName);   // 결과 : text태그의 값은 value=""로 설정한다.
     *     ComClearObject(sltCity);   // 결과 : select태그의 값은 첫번째Item을 선택한다.
     *     ComClearObject(chkYn);     // 결과 : checkbox태그나 radio태그의 체크를 푼다.
     * </pre>
     * @param {object} obj     필수,대상 HTML태그(Object)
     * @return 없음
     * @see #ComClearManyObjects
     */
    function ComClearObject(obj) {
        try {
            switch( obj.type ) {
                case "select-one" :
                     obj.selectedIndex='0';
                case "radio" :
                case "checkbox" :
                     obj.checked=false;
                     break;
                case "text" :
                case "password" :
                     obj.value="";
                     break;
                default:
            } // end switch
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * 인자로 받은 모든 HTML태그(Object)들의 value값을 초기화시킨다. {@link #ComClearObject}함수를 이용하여 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComClearManyObjects(txtName, btn_save);  //두번째 인자부터 마지막인자까지 설정된 모든컨트롤들의 value값을 초기화시킨다
     * </pre>
     * @param {object} objs    필수,대상 HTML태그(Object)들로 원하는 개수만큼 여러개 설정한다.
     * @return 없음
     * @see #ComClearObject
     * @see #ComResetAll
     */
    function ComClearManyObjects(objs) {
        try {
            var args = arguments;

            for(var i=0; i<args.length; i++) {
                if (args[i].tagName != undefined) ComClearObject(args[i]);
            } // end for
        } catch(err) { ComFuncErrMsg(err.message); }
    }



    /**
     * HTML태그(Object)의 value값이 포멧에 맞는 값인지 확인하고, 포멧에 맞게 구분자를 포함하여 value 값을 변경한다. <br>
     * sFormat 인자값은 다음 중 선택하여 설정하여, 인자를 설정하지 않으면 HTML태그(Object)의 dataformat 속성값을 가져온다. 예를 들어 다음과 같다. <br>
     * &lt;input type="text" name="txtDate" <font color="red">dataformat="ymd"</font>&gt; <br>
     * 위와같이 설정하지 않는다면 sFormat 인자값은 다음과 같이 설정한다. <br>
     * sFormat="ymd"    : 년월일 형태인 "yyyy-mm-dd" 포멧인 경우<br>
     * sFormat="ym"     : 년월 형태인 "yyyy-mm" 포멧인 경우<br>
     * sFormat="hms"    : 시분초 형태인 "hh:mm:ss" 포멧인 경우<br>
     * sFormat="hm"     : 시분 형태인 "hh:mm" 포멧인 경우<br>
     * sFormat="jumin"  : 주민등록번호 형태인 "######-#######" 포멧인 경우<br>
     * sFormat="saupja" : 사업자등록번호 형태인 "###-##-#####" 포멧인 경우<br>
     * sFormat="int"    : 정수 형태인 "#,###" 포멧인 경우<br>
     * sFormat="float"  : 실수 형태인 "#,###.###" 포멧인 경우<br>
     * sFormat="han"    : 키보드 자동 한글 모드, 한글+숫자 입력 가능<br>
     * sFormat="eng"    : 키보드 자동 영문 모드, 영문+숫자 입력 가능<br>
     * sFormat="engup"  : 키보드 자동 영문 모드, 영문+숫자 입력 가능<br>
     * sFormat="engdn"  : 키보드 자동 영문 모드, 영문+숫자 입력 가능<br>
     * sFormat인자값도 설정되고 HTML태그(Object)의 dataformat 속성값도 있다면 sFormat인자값을 포멧으로 생각한다. <br><br>
     * 이 함수와 {@link #ComClearSeparator}함수는 HTML태그의 이벤트에서 다음과 같이 호출하여 사용할 수 있다.<br>
     * &lt;input type="text" name="txtDate" <font color="red">dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"</font> &gt; <br>
     * <br><b>Example :</b>
     * <pre>
     *     ret = ComAddSeparator(txtDate)       //결과 : txtDate.value="20081101"인 경우 txtDate.value="2008-11-01"로 변경하고, ret=true이다.
     *     &lt;input type="text" name="txtDate" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"&gt; //html태그에 설정하는 경우
     * </pre>
     * @param {object} obj     필수,대상 HTML태그(Object)
     * @param {string} sFormat 선택,포멧구분, default=HTML태그(Object)의 dataformat 속성값
     * @returns bool <br>
     *          true  : value값이 포멧에 맞아서 value에 포멧구분자를 포함하여 value값을 변경한 경우<br>
     *          false : value=""이거나 value값이 포멧에 맞지 않아서 값변경 실패한 경우<br>
     *          undefined : sFormat 인자값이 없으면서 HTML태그에 dataformat속성값도 없는 경우<br>
     * @see #ComClearSeparator
     * @see CoCommon#ComGetMaskedValue
     */
    function ComAddSeparator(obj, sFormat) {
        try {
            if (ComIsEmpty(obj)) return true;

            //sFormat인자값이 없는 경우 태그의 dataformat 속성값을 가져온다.
            sFormat = getDataFormat(obj, sFormat)
            if (sFormat=="") return true;

            var sResultVal      = ComGetMaskedValue(obj, sFormat);

            if (sResultVal=="") {
                //?-값이맞지않는경우 sResultVal=""이 되어 obj.value=""이 됨. 이때 값을 지워버려야할지 값을지우지말고 그냥 포커스를 잃지 않고 계속포커스 상태로 두어야할지 몰겠음
                //류현수수석과 협의 하여 값을 지우지 않고 "형식이 맞지 않습니다."라는 경고 메시지 표시 후 포커스를 그대로 두기로 함
                //obj.value   = sResultVal;
                ComShowMessage("'" + obj.value + "' is not valid. Please enter a valid value");

            	//포커스 나갈수 있는 경우 : 이벤트를 통해서 함수가 호출되고, 값이 공백이거나 readonly인 경우
            	var canFocusOut = (event.srcElement == obj && (obj.value=="" || obj.getAttribute("readOnly")==true));

            	if(canFocusOut) {
            		event.returnValue = true;
            	} else {
                	//값이 정확할때 까지 포커스가 나가지 않아야 하는 경우
                	event.cancelBubble = true;
                	event.returnValue = false;
                	obj.focus(); 
                	obj.select(); 
                }
                return false;
            } else {
                obj.value   = sResultVal;
                return true;
            }

            return (sResultVal != "");
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * HTML태그(Object)의 value값에 포멧구분자를 제거한 값으로 value값을 변경한다. <br>
     * sFormat 인자값은 다음 중 선택하여 설정하여, 인자를 설정하지 않으면 HTML태그(Object)의 dataformat 속성값을 가져온다. 예를 들어 다음과 같다. <br>
     * &lt;input type="text" name="txtDate" <font color="red">dataformat="ymd"</font>&gt; <br>
     * 위와같이 설정하지 않는다면 sFormat 인자값은 다음과 같이 설정한다. <br>
     * sFormat="ymd"    : 년월일 형태인 "yyyy-mm-dd" 포멧인 경우<br>
     * sFormat="ym"     : 년월 형태인 "yyyy-mm" 포멧인 경우<br>
     * sFormat="hms"    : 시분초 형태인 "hh:mm:ss" 포멧인 경우<br>
     * sFormat="hm"     : 시분 형태인 "hh:mm" 포멧인 경우<br>
     * sFormat="jumin"  : 주민등록번호 형태인 "######-#######" 포멧인 경우<br>
     * sFormat="saupja" : 사업자등록번호 형태인 "###-##-#####" 포멧인 경우<br>
     * sFormat="int"    : 정수 형태인 "#,###" 포멧인 경우<br>
     * sFormat="float"  : 실수 형태인 "#,###.###" 포멧인 경우<br>
     * sFormat="han"    : 키보드 자동 한글 모드, 한글+숫자 입력 가능<br>
     * sFormat="eng"    : 키보드 자동 영문 모드, 영문+숫자 입력 가능<br>
     * sFormat="engup"  : 키보드 자동 영문 모드, 영문+숫자 입력 가능<br>
     * sFormat="engdn"  : 키보드 자동 영문 모드, 영문+숫자 입력 가능<br>
     * sFormat인자값도 설정되고 HTML태그(Object)의 dataformat 속성값도 있다면 sFormat인자값을 포멧으로 생각한다.<br><br>
     * 이 함수와 {@link #ComAddSeparator}함수는 HTML태그의 이벤트에서 다음과 같이 호출하여 사용할 수 있다.<br>
     * &lt;input type="text" name="txtDate" <font color="red">dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"</font> &gt; <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComClearSeparator(txtDate)              //txtDate의 사용자정의 속성인 dataformat을 읽어서 다음 결과 처럼 처리함
     *                                             //결과 : txtDate.value="2008-11-01"인 경우 txtDate.value="20081101"로 변경한다.
     *     &lt;input type="text" name="txtDate" <font color="red">dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"</font>&gt; //html태그에 설정하는 경우
     *
     *     ComClearSeparator(txtDate, "ym", "/")   //결과 : txtDate.value="2008/11"인 경우 txtDate.value="200811"로 변경한다.
     *     ComClearSeparator(txtDate, "",   "-")   //결과 : sFormat이 없어도, sDelim설정만으로도 처리함
     * </pre>
     * @param {object} obj     필수,대상 HTML태그(Object)
     * @param {string} sFormat 선택,포멧구분, default=HTML태그(Object)의 dataformat 속성값
     * @param {string} sDelim  선택,포멧구분, default=sFormat 인자값에 따라 결정
     * @returns 없음 <br>
     * @see #ComAddSeparator
     * @see CoCommon#ComGetUnMaskedValue
     */
    function ComClearSeparator(obj,sFormat,sDelim)
    {
        try{
            if (typeof(obj) != "object" ) return;

            //sFormat인자값이 없는 경우 태그의 dataformat 속성값을 가져온다.
            sFormat = getDataFormat(obj, sFormat)

            //한영 키보드 조정 - 여기서 조정하는것보다 Tag 안쪽에 적는것이 정확함.
            //<input type="text" name="txtEng"   dataformat="eng"  style="ime-mode:disabled">
            switch(sFormat) {
                case "ymd":     //yyyy-mm-dd
                case "ymdhms":     //yyyy-mm-dd
                case "ymdhm":     //yyyy-mm-dd
                case "yyyy":     //yyyy
                case "ym":      //yyyy-mm
                case "hms":     //hh:mm:ss
                case "hm":      //hh:mm
                case "jumin":   //######-#######
                case "saupja":  //###-##-#####
                case "int":     //#,###
                case "float":   //#,###.###
                case "eng":
                case "engup":
                case "engdn":
                    obj.style.imeMode = "disabled" ;
                    break;
                case "han":
                    obj.style.imeMode = "active" ;
            }

            //마스크 구분자가 없는 경우 처리
            sDelim = getFormatDelim(sFormat, sDelim);
            if (sDelim==undefined || sDelim==null || sDelim=="") return;

            if(sFormat == "ymdhms" || sFormat == "ymdhm")
            	obj.value = ComTrimAll(obj.value," ", "-", ":");
            else
            	obj.value = ComTrimAll(obj.value,sDelim);
            
            if (obj.type == 'text' && obj.value.length >=1 && obj.onfocus==null) obj.onfocus = new Function("this.select()");

			//event.returnValue=true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 키보드로 입력되는 값을 숫자만으로 제어한다. <br>
     * 예를 들어 다음과 같이 사용한다.<br>
     *     &lt;input type="text" name="txtAmt" <font color="red">onKeyPress="ComKeyOnlyNumber(this)"</font>&gt; <br>
     * 인자로 사용되는 sSubChar 인자는 숫자이외에 부가적으로 입력할수 있는 문자를 여러개 연결하여 설정한다.<br>
     * <font color="red">주의!</font> style="ime-mode:disabled"은 반드시 설정해야 기능이 정확히 처리된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this)"&gt;
     *     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-")"&gt;
     *     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-.,")"&gt;
     * </pre>
     * @param {object} obj      필수,대상 HTML태그(Object)
     * @param {string} sSubChar 선택,숫자이외의 부가 글자
     * @returns 없음 <br>
     * @see #ComKeyOnlyAlphabet
     */
    function ComKeyOnlyNumber(obj,sSubChar)
    {
        try {
	        var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

            if(keyValue >= 48 && keyValue <= 57) {//숫자
                event.returnValue = true;

            } else if(sSubChar != undefined && sSubChar != null && sSubChar.constructor==String && sSubChar.length > 0) {
            	//SubChar가 여러개 설정된 경우 여러개 글자 모두 처리한다.
            	for(var i=0; i<sSubChar.length; i++) {
             		if (keyValue == sSubChar.charCodeAt(i)) {
		                event.returnValue = true;
		                return;
            		}
            	}
                event.returnValue = false;
            } else {
                event.returnValue = false;
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 키보드로 입력되는 값을 영문대문자 또는 영문소문자로 자동 변경 제어한다. <br>
     * 예를 들어 다음과 같이 사용한다.<br>
     *     &lt;input type="text" name="txtName" <font color="red">style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')"</font>&gt; <br>
     * 인자로 사용되는 sFlag 인자의 설정값은 다음과 같다. <br>
     * sFlag = "upper"      : 영문대문자만 입력할수 있고, 대문자로 자동 변환된다. <br>
     * sFlag = "lower"      : 영문소문자만 입력할수 있고, 소문자로 자동 변환된다. <br>
     * sFlag = "uppernum"   : 영문대문자와 숫자만 입력할수 있고, 대문자로 자동 변환된다. <br>
     * sFlag = "lowernum"   : 영문소문자와 숫자만 입력할수 있고, 소문자로 자동 변환된다. <br>
     * sFlag = "num"        : 영문과 숫자 입력할수 있고, 자동 변환없이 그대로 표시한다. <br>
     * sFlag = 설정안한경우 : 영문만 입력할수 있고, 자동변환없이 그대로 표시한다. <br>
     * <font color="red">주의!</font> style="ime-mode:disabled"은 반드시 설정해야 기능이 정확히 처리된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComKeyOnlyAlphabet('lower');
     *     ComKeyOnlyAlphabet('uppernum',"32|64");    //스페이스와 @문자 입력도 입력가능
     * </pre>
     * @param {string} sFlag 선택,영문모드, default=""
     * @param {string} KeyCodes 선택,예외  키코드, default=""
     * @returns 없음 <br>
     * @see #ComKeyOnlyNumber
     */
    function ComKeyOnlyAlphabet(sFlag, KeyCodes)
    {
        try {
	        var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            var bCanNum  = false;
            var flag = false;

            if (sFlag==undefined || sFlag==null || sFlag.constructor!=String) sFlag="";
            sFlag = sFlag.toLowerCase();
            if (KeyCodes==undefined || KeyCodes==null) flag=false;
            else{
                var KeyArray = KeyCodes.split("|");
                for(var i =0;i<KeyArray.length;i++){
                	if(KeyArray[i] == keyValue) flag = true;
                }
            }
            
            if (sFlag.length >= 3){
                if (sFlag.substr(sFlag.length-3)=="num") bCanNum=true;
                if (sFlag.length > 5) sFlag = sFlag.substr(0,5);
            }
            if(keyValue >= 97 && keyValue <= 122){                  //소문자
                if (sFlag=="upper") event.keyCode = keyValue + 65 - 97;
                event.returnValue = true;
            } else if(keyValue >= 65 && keyValue <= 90){            //대문자
                if (sFlag=="lower") event.keyCode = keyValue + 97 - 65;
                event.returnValue = true;
            } else if(bCanNum && keyValue >= 48 && keyValue <= 57) {//숫자
                event.returnValue = true;
            } else if(flag) {									    //예외문자.
                event.returnValue = true;
            } else {
                event.returnValue = false;
            }
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * HTML태그(Object)의 onKeyDown 이벤트에서 이 함수를 호출할수 있으며, Enter키를 눌렀을때 자동화 기능을 처리한다. <br>
     * 인자로 사용되는 sFlag 인자의 설정값은 다음과 같다. <br>
     * sFlag = 설정안한경우      : sFlag="Search"의 경우와 동일하게 처리한다.<br>
     * sFlag = "Search"          : Enter키가 누르면 조회버튼(btn_Retrieve 또는 btn_retrieve)이 눌린것처럼 처리한다.OnKeyDown에서 호출할것!<br>
     * sFlag = "NextFocus"       : Enter키를 누르면 Tab키를 누른것 처럼 다음 입력필드로 포커스를 이동한다.OnKeyDown에서 호출할것!<br>
     * sFlag = "LengthNextFocus" : 입력필드의 maxlength길이만큼 모두 입력되면 자동으로 포커스를 다음으로 이동하고, Enter키를 누르면 길이에 관계없이 Tab을 누른것처럼 옆으로 이동한다. OnKeyUp에서 호출할 것!<br>
     * sFlag = Function명문자열  : 특정Function명 문자열을 인자로 받아서 Enter키를 누르면 해당 함수를 호출한다. OnKeyDown에서 호출할 것!<br>
     * sFlag = "LengthNextFocus"는 OnKeyUp이벤트에서 호출하여야 하고, 나머지는 모두 OnKeyDown이벤트에서 호출해야 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;form name="form" onKeyDown="ComKeyEnter()"&gt; 					//조회조건Form에서 주로 사용
     *     &lt;form name="form" onKeyDown="ComKeyEnter('NextFocus')"&gt;		//저장Form에서 주로 사용
     *     &lt;form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')"&gt;	//저장Form에서 주로 사용
     * </pre>
     * @param {string} sFlag 선택,키처리 구분, default="Search"
     * @see #ComSetNextFocus
     */
    function ComKeyEnter(sFlag)
    {
        try {
        	var keyValue = null;
        	if(event == undefined || event == null) {
        		keyValue = 13;
        	}else
        		keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

            if (sFlag==undefined || sFlag==null || sFlag.constructor!=String || sFlag.trim() == "") sFlag="search";

            switch(sFlag.toLowerCase()) {
            	case "search" :
            		//Enter키를 누르면 조회버튼을 눌린것 처럼 처리
            		if (keyValue != 13) return;
            		var obj = document.getElementById("btn_Retrieve");
            		if (obj==null) obj = document.getElementById("btn_retrieve");
            		if (obj) obj.fireEvent("onclick");
            		break;
           		
            	case "nextfocus":
            		//Enter키를 누르면 Tab키를 누른것 처럼 처리
            		if (keyValue == 13) event.keyCode = 9;
            		break;

            	case "lengthnextfocus":
            		//입력필드는 maxlength만큼 모두 입력하면 Enter키를 누르지 않아도 자동이동하고,
            		//그외의 경우 Enter키를 누르면 Tab키를 누른것 처럼 처리
			        var iMaxLen=event.srcElement.getAttribute("maxLength");
			        var sValue =event.srcElement.getAttribute("value");
			        var bFocusProcess = false;
			        
			        //Enter키를 눌렀을 때
			        if (keyValue == 13)  {
			        	//Enter키를 누른것이 IBSheet가 아닌 경우만 처리한다.
			        	if (event.srcElement.classid != CLSID_IBSHEET) {
				        	bFocusProcess=true;
				        }
			        //iMaxLen 속성이 없거나 Value 속성이 없는것들은 처리하지 않는다.
			        } else if(iMaxLen!=null && sValue!=null) {
			            if(iMaxLen==sValue.lengthByte()){
			                //if(!((keyValue==37)||(keyValue==39)||(keyValue==46)||(keyValue==8)||(keyValue==9))){
			                //참고:http://cdmanii.tistory.com/153
			                if (!((keyValue>=8   && keyValue<=40)  ||  //BackSpace~아래방향키키
			                      (keyValue>=45  && keyValue<=46)  ||  //Insert,Delete키
			                      (keyValue>=91  && keyValue<=93)  ||  //기능키
			                      (keyValue>=112 && keyValue<=123) ||  //F1~F12키
			                      (keyValue>=144 && keyValue<=145) )) {//NumLock,ScrollLock
			                	
					            bFocusProcess=true;
			                }
			            } 
			        } 
		            
		            //포커스를 다음 컨트롤로 옮기는 처리를 해야 하는 경우
		            if (bFocusProcess)  ComSetNextFocus();

            	default :
            		//Enter키를 누르면 sFlag 명의 자바스크립트 함수를 호출 한다.
            	    if (keyValue==13 && ComFuncCheck(sFlag)) ComFunc();

            }

        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동한다.<br>
     * 인자를 설정하지 않으면 event.srcElement를 Object로 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComSetNextFocus(form.txtDate1); 	//form.txtDate1의 다음 Object인 form.txtDate2로 포커스를 이동한다.
     * </pre>
     * @param {object} obj     필수,HTML태그(Object)
     * @see #ComAlertFocus
     * @see #ComSetFocus
     * @see #ComKeyEnter
     */
    function ComSetNextFocus(obj) 
    {
        try {
	    	if (obj==null || obj==undefined) obj = event.srcElement;
	    	if (obj==null) return;
	        
			var objs   = document.all;
			
			//sourceIndex속성은 obj의 document.all의 순번임
			for (var i=obj.sourceIndex+1; i<objs.length; i++) {
        		try { 
        			//Name=null or Type=null인 것들은 거의 Editable인것이 아님
        			if (objs[i].getAttribute("name") == null || objs[i].getAttribute("type") == null) continue;

        			//disabled이거나 readOnly일때 그 다음 컨트롤 찾기
        			if (objs[i].getAttribute("readOnly") || objs[i].getAttribute("isDisabled")) continue;

        			objs[i].focus(); 
                    break;
        		} catch(error) {;}
			}
		
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * sFormat이 있는 경우 : sFormat을 소문자로 변환하여 반환한다. <br>
     * sFormat이 없는 경우 + Object에 dataformat 속성이 있는 경우 : dataformat 속성값을 소문자로 변환하여 반환한다. <br>
     * sFormat이 없는 경우 + Object에 dataformat 속성이 없는 경우 : "" 반환한다. <br>
     * 이 함수는 이파일(CoFormControl.js)에서만 사용하기 위한 목적으로 만들졌다.
     */
    function getDataFormat(obj, sFormat){
        try {
            if (sFormat==undefined || sFormat==null || sFormat.constructor!=String || sFormat=="") {
                if (obj.dataformat==undefined) return "";
                return obj.dataformat.toLowerCase();
            }else{
                return sFormat.toLowerCase();
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * &lt;select&gt;태그 Object에 있는 모든 Item을 제거한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComClearCombo(sltCity);
     * </pre>
     * @param {object} obj     필수,Select HTML태그(Object)
     * @return 없음
     * @see #ComAddComboItem
     */
    function ComClearCombo(obj)
    {
        try {
            if (obj == null) return;

            for (var idx = obj.length-1; idx >= 0; idx--) {
                obj.options[idx] = null;
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * &lt;select&gt;태그 Object에 새로운 Item을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComAddComboItem(sltCity, "서울", "001");
     *     ComAddComboItem(sltCity, "대전", "002");
     *     ComAddComboItem(sltCity, "대구", "003");
     *     ComAddComboItem(sltCity, "부산", "004");
     * </pre>
     * @param {object} obj     필수,Select HTML태그(Object)
     * @param {string} sText   필수,Item의 표시글자
     * @param {string} sValue  필수,Item의 숨겨진 값
     * @return 없음
     * @see #ComClearCombo
     */
    function ComAddComboItem(obj, sText, sValue)
    {
        try {
            if (obj == null) return;

            var iLen = obj.length;
            if (iLen == 0) {
                option1 = new Option(sText, sValue, true);
            } else {
                option1 = new Option(sText, sValue);
            }
            obj.options[iLen] = option1;
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    //var Msg_Required = "은(는) 필수입력사항 입니다.";
    var Msg_Required = " is mandatory item." ;

    /**
     * 폼 개체 안에 컨트롤의 필수 입력 여부를 확인한다. <br>
     * 필수 입력 여부를 확인하기 위해서는 HTML태그(Object)안에 사용자 정의 속성인 required속성과 caption속성을 설정해주어야 한다. 다음과 같이 설정한다. <br>
     *     &lt;input type="text" name="bmk_cd" <font color="red">required caption="비목코드"</font>&gt; <br>
     * &lt;input type="radio"&gt;의 경우 같은 name으로 여러개를 만든다면 첫번째 태그에만 required속성과 caption속성을 설정해준다. 예를 들어 다음과 같다. <br>
     *     &lt;input type="radio" name="rdoCity" value="01" required caption="도시"&gt;서울<br>
     *     &lt;input type="radio" name="rdoCity" value="02"&gt;대전<br>
     *     &lt;input type="radio" name="rdoCity" value="03"&gt;대구<br>
     * <br><b>Example :</b>
     * <pre>
     *     if(!ComChkRequired(document.frmMaster)) return;   //frmMaster폼안에 모든 오브젝트의 필수입력여부를 확인한다.
     * </pre>
     * @param {form} frm     필수,대상 Form 오브젝트
     * @returns bool
     *          false - 필수입력 항목에 값이 없는 경우
     *          true  - 모두 입력된 경우
     * @see #ComChkValid
     */
    function ComChkRequired(frm) {

        try {
            var elems = frm.elements;

            for(var i = 0; i < elems.length; i++) {
                var elem = elems[i];

                if(elem.getAttribute("required") == null || elem.getAttribute("disabled")) continue;

                //radio인 경우 같은이름으로 여러개 있는 경우
                if (elem.type =="radio") {
                    if (elem.name == null || elem.name=="") continue;
                    var eRadio = document.all[elem.name];
                    //첫번째 radio만 "required"속성이 있는지 체크한다.
                    if(eRadio.length>1) i += (eRadio.length-1);
                    sVal = ComGetObjValue(eRadio);
                } else {
                    sVal = ComGetObjValue(elem)
                }

                if (ComTrim(sVal)=="") {
                    var sTitle = (elem.getAttribute("caption")==null)?elem.name:elem.getAttribute("caption");
                    ComShowMessage("'" + sTitle + "' " + Msg_Required);

                    //컨트롤이 숨겨져 있을수도 있으므로 에러 감싼다.
                    try{ elem.focus(); } catch(ee) {;}

                    return false;

                }
            } // end of for(i)
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }

    }

    /**
     * 인자로 받은 HTML태그(Object) 오브젝트,IBMultiCombo의 value를 리턴한다. <br>
     * &lt;input type="radio"&gt;의 경우 같은이름의 여러개 Radio컨트롤 중 선택(체크)된 하나의 Radio컨트롤의 value를 반환한다. <br>
     * &lt;input type="checkbox"&gt;의 경우 체크되었을때 컨트롤의 value를 반환한다. <br>
     * &lt;select&gt;의 경우 선택된 Item의 value를 반환한다. <br>
     * &lt;select multiple&gt;의 경우 여러개 선택된 Item의 value를 "|"로 연결하여 반환한다. <br>
     * 그외의 경우 value를 반환한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ret = ComGetObjValue(txtName)         //결과 : "한진해운"
     *     ret = ComGetObjValue(sltCity)         //결과 : "04"
     *     ret = ComGetObjValue(rdoCity)         //결과 : "01"
     *     ret = ComGetObjValue(chkYn)           //결과 : "Y"
     *     ret = ComGetObjValue(sltCityMulti)    //결과 : "01|02|04" 3개 Item이 선택된 경우
     * </pre>
     * @param {object} obj    필수,HTML태그(Object) 오브젝트
     * @return string,HTML태그(Object) 오브젝트의 value
     * @see #ComGetObjText
     * @see #ComSetObjValue
     */
    function ComGetObjValue(obj){
        try {
            //아래는 HTML오브젝트
            if(obj.classid==undefined){
                var sType = obj.type;

                //type을 읽을수 있다는것은 Radio전체가 아니라 radio[0]... 임
                if (sType=="radio") {
                    if (obj.name == null || obj.name=="") {
                        if (obj.checked) return obj.value;
                        else return "";
                    }
                    obj = document.all[obj.name];
                //Radio전체로는 obj.type으로 알수 없음.  radio[0].. 등 만 알수 있음
                }else if(obj.type == undefined && obj.length != undefined && obj[0].type == "radio") {
                    sType = "radio";
                }

                switch (sType) {
                    case "radio":
                        if (obj.length != null) {
                            for(var i=0; i<obj.length; i++) {
                                if (obj[i].checked) return obj[i].value;
                            }
                        } else {
                            if (obj.checked) return obj.value;
                        }
                        break;
                    case "checkbox":
                        if (obj.checked) return obj.value;
                        break;
                    case "select-one":
                        if(obj.selectedIndex >= 0)  return obj[obj.selectedIndex].value;
                        break;
                    case "select-multiple":
                        var sRet = "";
                        for(var idx= 0; idx<obj.length; idx++) {
                            //선택된 모든 Item의 value를 "|"로 연결한다.
                            if (obj.options[idx].selected) sRet += "|" + obj.options[idx].value;
                        }
                        if (sRet == "") return "";
                        return sRet.substr(1);  //맨앞의 "|"를 제거
                    default:
                        if (obj.value != undefined) return obj.value;
                }
            //아래는 ActiveX 오브젝트
            } else {
                if(obj.classid==CLSID_IBMCOMBO) {//IBMultiCombo 경우
                    return obj.Code;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }

        return "";
    }


    /**
     * 인자로 받은 HTML태그(Object) 오브젝트,IBMultiCombo의 value를 특정값(sValue)으로 변경한다. <br>
     * &lt;select multiple&gt;의 경우 여러개 Item을 선택할 경우 sValue인자로 선택할 Item의 value를 "|"로 연결한 문자열로 설정한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComSetObjValue(frmMain.txtName, "한진")       //결과 : txtName.value="한진해운"
     *     ComSetObjValue(frmMain.sltCity, "02")         //결과 : sltCity.options[idx].value="04"인 Item의 sltCity.options[idx].selected = true로 변경
     *     ComSetObjValue(frmMain.rdoCity, "02")         //결과 : rdoCity[idx]="01"인 Itemd의 rdoCity[idx].checked=true로 변경
     *     ComSetObjValue(frmMain.chkYn, "Y")            //결과 : chkYn.checked="Y"
     *     ComSetObjValue(frmMain.sltCityMulti, "01|03") //결과 : sltCityMulti.options[idx].value가 "01" 또는 "02" 또는 "04"인 Item의 selected=true로 변경
     * </pre>
     * @param {object} obj      필수,HTML태그(Object) 오브젝트
     * @param {string} sValue   필수,변경할 value
     * @param {bool}   bArgTrim 선택,sValue인자값을 스페이스제거(Trim)하여 비교할지여부, default=false
     * @return 없음
     */
    function ComSetObjValue(obj, sValue, bArgTrim){
        try {
            if (bArgTrim==undefined || bArgTrim == null) bArgTrim=false;

            if (bArgTrim) sValue = ComTrim(sValue);

            //아래는 HTML오브젝트
            if(obj.classid==undefined){
                var sType = obj.type;
                //type을 읽을수 있다는것은 Radio전체가 아니라 radio[0]... 임
                if (sType=="radio") {
                    if (obj.name == null || obj.name=="") {
                        if (obj.checked) return obj.value;
                        else return "";
                    }

                    obj = document.all[obj.name];
                //Radio전체로는 obj.type으로 알수 없음.  radio[0].. 등 만 알수 있음
                }else if(obj.type == undefined && obj.length != undefined && obj[0].type == "radio") {
                    sType = "radio";
                }

                switch (sType) {
                    case "radio":
                        if (obj.length != null) {
                            for(var i=0; i<obj.length; i++) {
                                if (obj[i].value == sValue) {
                                    obj[i].checked=true;
                                    break;
                                }
                            }
                        } else {
                            if (obj.value == sValue) obj.checked=true;
                        }
                        break;
                    case "checkbox":
                        obj.checked = sValue;
                        break;
                    case "select-one":
                        for (var idx = 0; idx < obj.length; idx++) {
                            if (obj[idx].value == sValue) {
                                obj[idx].selected = true;
                                break;
                            }
                        }
                        break;
                    case "select-multiple":
                        var aryValue = sValue.split("|");
                        if (bArgTrim){
                            for (i=0; i<aryValue.length; i++) {
                                aryValue[i] = ComTrim(aryValue[i]);
                            }
                        }

                        for(var idx= 0; idx<obj.length; idx++) {
                            var bSelected = false;
                            for (i=0; i<aryValue.length; i++) {
                                if (obj[idx].value == aryValue[i])  {
                                    bSelected = true;
                                    break;
                                }
                            }
                            obj[idx].selected = bSelected;
                        }
                        break;
                    default:
                        if (obj.value != undefined) obj.value = sValue;
                }
            //아래는 ActiveX 오브젝트
            } else {
                if(obj.classid==CLSID_IBMCOMBO) {//IBMultiCombo 경우
                    obj.Code = sValue;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     * 인자로 받은 HTML태그(Object) 오브젝트,IBMultiCombo의 text를 리턴한다. <br>
     * &lt;select&gt;의 경우 선택된 Item의 text를 반환한다. <br>
     * &lt;select multiple&gt;의 경우 여러개 선택된 Item의 text를 "|"로 연결하여 반환한다. <br>
     * IBMultiCombo의 경우 선택된 Item의 Text를 반환한다. <br>
     * 그외 HTML태그(Object) 오브젝트인 경우 text속성이 없으므로 coc_getObjValue와 동일하게 value를 반환한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     ret = ComGetObjText(txtName)         //결과 : "한진해운"
     *     ret = ComGetObjText(sltCity)         //결과 : "부산"
     *     ret = ComGetObjText(sltCityMulti)    //결과 : "서울|대전|부산" 3개 Item이 선택된 경우
     * </pre>
     * @param {object} obj    필수,HTML태그(Object) 오브젝트
     * @return string,HTML태그(Object) 오브젝트,IBMultiCombo의 text
     */
    function ComGetObjText(obj){
        try {
            //아래는 HTML오브젝트
            if(obj.classid==undefined){
                var sType = obj.type;
                //type을 읽을수 있다는것은 Radio전체가 아니라 radio[0]... 임
                if (sType=="radio") {
                    if (obj.name == null || obj.name=="") {
                        if (obj.checked) return obj.value;
                        else return "";
                    }
                    obj = document.all[obj.name];
                //Radio전체로는 obj.type으로 알수 없음.  radio[0].. 등 만 알수 있음
                }else if(obj.type == undefined && obj.length != undefined && obj[0].type == "radio") {
                    sType = "radio";
                }

                switch (sType) {
                    case "select-one":
                        if(obj.selectedIndex >= 0)  return obj[obj.selectedIndex].text;
                        break;
                    case "select-multiple":
                        var sRet = "";
                        for(var idx= 0; idx<obj.length; idx++) {
                            //선택된 모든 Item의 value를 "|"로 연결한다.
                            if (obj.options[idx].selected) sRet += "|" + obj.options[idx].text;
                        }
                        if (sRet == "") return "";
                        return sRet.substr(1);  //맨앞의 "|"를 제거
                    default:
                        return ComGetObjValue(obj);
                }
            //아래는 ActiveX 오브젝트
            } else {
                if(obj.classid==CLSID_IBMCOMBO) {//IBMultiCombo 경우
                    return obj.Text;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }

        return "";
    }


    /**
     * 특정이름의 Cookie를 생성한다. <br>
     * @param {string} cookieName    필수,Cookie이름
     * @param {string} cookieValue   필수,Cookie값
     * @param {string} expires       필수,만기일자 Date 오브젝트
     * @return 없음
     * @see #ComGetCookie
     * @see #ComClearCookie
     */
    function ComSetCookie(cookieName, cookieValue, expires) {
        try {
            document.cookie =
                escape(cookieName) + '=' + escape(cookieValue)
                + (expires ? '; expires=' + expires.toGMTString() : '')
                + '; path=/';

                /*
                + (path ? '; path=' + path : '')
                + (domain ? '; domain=' + domain : '')
                + (secure ? '; secure' : '');
                */
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * 특정이름의 Cookie의 값을 가져온다. <br>
     * @param {string} cookieName    필수,Cookie이름
     * @return string, Cookie값
     * @see #ComSetCookie
     * @see #ComClearCookie
     */
    function ComGetCookie(cookieName) {
        try {
            var cookieValue = '';
            var posName = document.cookie.indexOf(escape(cookieName) + '=');
            if (posName != -1) {
                var posValue = posName + (escape(cookieName) + '=').length;
                var endPos = document.cookie.indexOf(';', posValue);
                if (endPos != -1) cookieValue = unescape(document.cookie.substring(posValue, endPos));
                else cookieValue = unescape(document.cookie.substring(posValue));
            }
        } catch(err) { ComFuncErrMsg(err.message); }

        return (cookieValue);
    }

    /**
     * 특정이름의 Cookie를 제거한다. <br>
     * @param {string} cookieName    필수,Cookie이름
     * @return 없음
     * @see #ComGetCookie
     * @see #ComSetCookie
     */
    function ComClearCookie(cookieName) {
        try {
            var now = new Date();
            var yesterday = new Date(now.getTime() - 1000 * 60 * 60 * 24);
            ComSetCookie(cookieName, 'cookieValue', yesterday);
            ComSetCookie(cookieName, 'cookieValue', yesterday);
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     * document 안에 있는 모든 Object의 값을 초기화한다. <br>
     * Form.reset()하고, IBSheet.RemoveAll()처리한다. IBMultiCombo의 경우 id="myCombo"이면 "initComboValue_myCombo()" 라는 <br>
     * 자바스크립트 함수가 정의되어 있다면 해당 함수를 호출하고, 해당 함수가 없다면 아무것도도 선택되지 않도록 IBMultiCombo.Code2="-1";로 설정한다. <br>
     * @return 없음
     * @see #ComClearManyObjects
     */
    function ComResetAll(){

        try {
            for(var i=0; i<document.forms.length; i++){
                document.forms[i].reset();
            }

            var objs = document.getElementsByTagName("OBJECT");

            for(var i = 0 ; i < objs.length ; i++){
                var sObjId = objs[i].classid;
                switch(sObjId){
                    case CLSID_IBSHEET: //IBSheet
                        objs[i].RemoveAll();
                        break;
                    case CLSID_IBMCOMBO: //IBMultiCombo 경우
                        var id = objs[i].id;
                        var funcName = "initComboValue_" + id;
                        if (ComFuncCheck(funcName)) {
                            ComFunc();
                        } else {
                            objs[i].Code2="-1";
                        }
                        break;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * 폼 개체 안에 모든 컨트롤의 Validation을 확인한다. <br>
     * 모든 컨트롤이 아닌 특정 하나의 컨트롤을 체크하고자 한다면 {@link #ComChkObjValid} 함수를 이용한다. <br>
     * bMsg 인자가 true이면 Validation이 정확하지 않은 경우 경고 메시지를 표시한다. <br>
     * bTrim 인자가 true이면 obj.value 확인 시 값을 trim하여 validation을 확인한다. <br>
     * bMasked 인자가 true이면 Validation이 정확한 경우 Format에 맞게 Masking 한값을 obj.value에 설정한다. <br>
     * Validation을 확인하기 위해서는 각 컨트롤 태그에 maxlength속성과 사용자 정의 속성인 required, minlength, caption, dataformat, fullfill, cofield, maxnum, minnum속성을 설정해주어야 한다. 다음과 같이 설정한다. <br>
     *     &lt;input type="text" name="txtDate" <font color="red">caption="입사일" maxlength="10" dataformat="ymd" required  fullfill maxnum="100" minnum="0" cofield="" </font>&gt; <br>
     * 위와 같은 속성을 설정함으로써 이 함수는 다음과 같은 처리를 한다. <br>
     * (1) maxlength  : 입력 최대 길이 확인, UTF-8기준으로 길이를 체크하므로, 한글은 3Byte로 된다.<br>
     * (2) minlength  : 입력 최소 길이 확인, 값이 있다면 최소 길이만큼 입력해야 한다. <br>
     * (3) dataformat : 데이타 포멧으로 Validation 확인<br>
     * <pre>
     *  - "ymd"      : yyyy-mm-dd
     *  - "ym"       : yyyy-mm
     *  - "hms"      : hh:mm:ss
     *  - "hm"       : hh:mm
     *  - "saupja"   : ###-##-#####
     *  - "jumin"    : ######-#######
     *  - "int"      : #,###
     *  - "float"    : #,###.###
     *  - "eng"      : 영문만
     *  - "engup"    : 영문 대문자만
     *  - "engdn"    : 영문 소문자만
     * </pre>
     * (4) required  : 필수입력 여부 확인, 값이 ""이면 에러 메시지 표시<br>
     * (5) caption   : EndUser를 위한 메시지 처리를 위한 컨트롤 표시 title<br>
     * (6) fullfill  : maxlength속성 만큼 글자를 모두 입력해야 하는 경우, 값이 ""이면 체크 안함<br>
     * (7) pointcount: dataformat="float" 인 경우 소숫점 아랫자리 수<br>
     * (8) maxnum    : 숫자인 경우 최대값<br>
     * (9) minnum    : 숫자인 경우 최소값<br>
     * (10) cofield  : 기간인 경우 시작일과 종료일 html태그에 이 속성을 설정해야 하며, 시작일은 종료일 name을 종료일은 시작일 name을 설정한다. <br>
     * <br>
     * &lt;input type="radio"&gt;의 경우 같은 name으로 여러개를 만든다면 첫번째 태그에만 위 속성을 설정해준다. 예를 들어 다음과 같다. <br>
     *     &lt;input type="radio" name="rdoCity" value="01" required caption="도시"&gt;서울<br>
     *     &lt;input type="radio" name="rdoCity" value="02"&gt;대전<br>
     *     &lt;input type="radio" name="rdoCity" value="03"&gt;대구<br>
     * 위 속성은 필요한것만 골라서 사용한다. 굳이 모든 속성을 다 설정할 필요는 없다. 그러나 속성을 하나라도 추가 한다면 caption속성은 설정해야 메시지 처리에 가독성을 높일수 있다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     if(!ComChkValid(document.frmMaster)) return;   //frmMaster폼안에 모든 오브젝트의 Validation을 확인한다.
     * </pre>
     * @param {form}   frm          필수,대상 Form 오브젝트
     * @param {bool}   bMsg         선택,각종메시지 표시 여부, default=true
     * @param {bool}   bTrim        선택,데이터 Trim후 확인할지 여부, default=true
     * @param {bool}   bMasked      선택,Validation이 정확하면 Format에 맞게 Masking한 값을 obj.value에 설정하지 여부, default=false
     * @returns bool <br>
     *          false - Validation이 정확하지 않은 경우<br>
     *          true  - Validation이 정확한 경우
     * @see #ComChkObjValid
     * @see #ComChkRequired
     */
    function ComChkValid(frm, bMsg, bTrim, bMasked){
        try {
            var elems   = frm.elements;
            var oldRadio = "";
            if (bMsg==undefined || bMsg==null)          bMsg = true;
            if (bTrim==undefined || bTrim==null)        bTrim = true;
            if (bMasked==undefined || bMasked==null)    bMasked = false;

            for(var i = 0; i < elems.length; i++) {
                var elem = elems[i];

                //radio인 경우 같은 이름으로 여러개 있는 경우
                if (elem.type =="radio") {
                    if (elem.name == null || elem.name=="") continue;
                    var elem = document.all[elem.name];
                    //첫번째 radio만 "required"속성이 있는지 체크한다. 나머지 건너뛰기
                    if(oldRadio == elem.name) continue;
                    else{
                        //Validation을 체크하여 false가 나오면 종료함
                        oldRadio = elem.name;
                        if (!ComChkObjValid(elem, bMsg, bTrim, bMasked)) return false;
                    }
                }else {
                    //Validation을 체크하여 false가 나오면 종료함
                    if (!ComChkObjValid(elem, bMsg, bTrim, bMasked)) return false;
                }

            }
        } catch(err) { ComFuncErrMsg(err.message); }

        return true;
    }


    /**
     * 하나의 컨트롤의 Validation을 확인한다. <br>
     * 각 하나의 컨트롤이 아닌 Form안에 있는 전체를 체크하고자 한다면 {@link #ComChkValid} 함수를 이용한다. <br>
     * Validation을 확인하기 위해서는 maxlength 속성과 사용자 정의 속성인 required, caption, minlength, dataformat, fullfill, cofield, maxnum, minnum속성을 설정해주어야 한다. 다음과 같이 설정한다. <br>
     *     &lt;input type="text" name="txtDate" <font color="red">caption="입사일" maxlength="10" dataformat="ymd" required  fullfill maxnum="100" minnum="0" cofield="" </font>&gt; <br>
     * 위와 같은 속성을 설정함으로써 이 함수는 다음과 같은 처리를 한다. <br>
     * (1) maxlength  : 입력 최대 길이 확인, UTF-8기준으로 길이를 체크하므로, 한글은 3Byte로 된다.<br>
     * (2) minlength  : 입력 최소 길이 확인, 값이 있다면 최소 길이만큼 입력해야 한다. <br>
     * (3) dataformat : 데이타 포멧으로 Validation 확인<br>
     * <pre>
     *  - "ymd"      : yyyy-mm-dd
     *  - "ym"       : yyyy-mm
     *  - "hms"      : hh:mm:ss
     *  - "hm"       : hh:mm
     *  - "saupja"   : ###-##-#####
     *  - "jumin"    : ######-#######
     *  - "int"      : #,###
     *  - "float"    : #,###.###
     *  - "eng"      : 영문만
     *  - "engup"    : 영문 대문자만
     *  - "engdn"    : 영문 소문자만
     * </pre>
     * (4) required  : 필수입력 여부 확인, 값이 ""이면 에러 메시지 표시<br>
     * (5) caption   : EndUser를 위한 메시지 처리를 위한 컨트롤 표시 title<br>
     * (6) fullfill  : maxlength속성 만큼 글자를 모두 입력해야 하는 경우, 값이 ""이면 체크 안함<br>
     * (7) pointcount: dataformat="float" 인 경우 소숫점 아랫자리 수<br>
     * (8) maxnum    : 숫자인 경우 최대값<br>
     * (9) minnum    : 숫자인 경우 최소값<br>
     * (10) cofield  : 기간인 경우 시작일과 종료일 html태그에 이 속성을 설정해야 하며, 시작일은 종료일 name을 종료일은 시작일 name을 설정한다. <br>
     * <br>
     * &lt;input type="radio"&gt;의 경우 같은 name으로 여러개를 만든다면 첫번째 태그에만 위 속성을 설정해준다. 예를 들어 다음과 같다. <br>
     *     &lt;input type="radio" name="rdoCity" value="01" required caption="도시"&gt;서울<br>
     *     &lt;input type="radio" name="rdoCity" value="02"&gt;대전<br>
     *     &lt;input type="radio" name="rdoCity" value="03"&gt;대구<br>
     * dataformat="float"인 경우 maxLength와 pointcount를 설정한다. DB에 number(5,2)로 설정되었다면 maxLength="6"으로 소숫점을 포함하여 설정하고, pointcount="2"로 DB와 동일하게 설정한다.<br>
     * 위 속성은 필요한것만 골라서 사용한다. 굳이 모든 속성을 다 설정할 필요는 없다. 그러나 속성을 하나라도 추가 한다면 caption속성은 설정해야 메시지 처리에 가독성을 높일수 있다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     if(!ComChkObjValid(frmMaster.txtName)) return;   //frmMaster폼안의 txtName 오브젝트의 Validation을 확인한다.
     * </pre>
     * @param {object} obj          필수,대상 HTML태그(Object)
     * @param {bool}   bMsg         선택,각종메시지 표시 여부, default=true
     * @param {bool}   bTrim        선택,데이터 Trim후 확인할지 여부, default=true
     * @param {bool}   bMasked      선택,Validation이 정확하면 Format에 맞게 Masking한값을 obj.value에 설정하지 여부, default=true
     * @returns bool <br>
     *          false - Validation이 정확하지 않은 경우<br>
     *          true  - Validation이 정확한 경우
     * @see #ComChkValid
     */
    function ComChkObjValid(obj, bMsg, bTrim, bMasked){

        try {
            var sTitle  = "";
            var sMsg    = "";
            //다음 배열은 순서가 중요함
            var props   = new Array("required", "dataformat", "maxLength", "minlength", "fullfill", "maxnum", "minnum", "pointcount", "cofield");

            if (bMsg==undefined || bMsg==null)            bMsg = true;
            if (bTrim==undefined || bTrim==null)          bTrim = true;
            if (bMasked==undefined || bMasked==null)      bMasked = true;

            var sFormat     = "";
            var sVal        = "";
            var maskValue   = "";
            var iMaxLen=0, iMaxVal=null, iMinVal=null;

            sVal = ComGetObjValue(obj)
            if (obj.type=="radio") {
                if (obj.name == null || obj.name=="") return true;
                //radio의 경우 radio의 첫번째 요소를 Object로 설정한다.
                var eRadio = document.all[obj.name];
                obj=eRadio[0];
            }else if(obj.type == undefined && obj.length != undefined && obj[0].type == "radio") {
                //radio의 경우 radio의 첫번째 요소를 Object로 설정한다.
                obj = obj[0];
            }

            sTitle = (obj.getAttribute("caption")==null)?obj.name:obj.getAttribute("caption");


            if(bTrim) sVal = ComTrim(sVal);
            maskValue = sVal;

            //체크할 속성 확인하기
            for(var j=0; j<props.length; j++){
	
                var attriVal = obj.getAttribute(props[j]);
                 
                if (attriVal == null) continue;

                switch(props[j]) {
                    case "required":    //필수 입력 확인
                        if(sVal==""){
                        	sMsg = "'" + sTitle + "' " +Msg_Required;
                        	j = 99;
                        }
                        break;
                    case "dataformat":  //포멧 확인
                        sFormat = attriVal;
		                //루프를 돌다가 "dataformat"을 지나게 되면 그때부터는 마스크구분자 없는 값으로 다른 Validation(길이,min,max 등)을 확인한다.
		                if (sFormat!="") sVal = ComGetUnMaskedValue(sVal, sFormat);

                        if (sVal== "") continue;

                        //마스크값도 가져오지만 포멧Validation도 ComGetMaskedValue 함수에서 체크한다.
                        maskValue = ComGetMaskedValue(obj, sFormat);

                        if (sVal != maskValue && sFormat.indexOf("eng")>=0) obj.value = maskValue;
 
                        if (maskValue!= "") continue;
                        switch(sFormat) {
                            case "ymd":     //yyyy-mm-dd
	                            sMsg = ComGetMsg('COM12134', sTitle);
                        		j=99;
                                break;   
                            case "ymdhms":     //yyyy-mm-dd
	                            sMsg = ComGetMsg('COM12187', 'yyyy-mm-dd hh:mm:ss');
	                     		j=99;
	                            break;   
                            case "ymdhm":     //yyyy-mm-dd
                                sMsg = ComGetMsg('COM12187', 'yyyy-mm-dd hh:mm');
                         		j=99;
                                break;   
                            case "ym":      //yyyy-mm
                                sMsg = ComGetMsg('COM12134', sTitle);
                                sMsg = sMsg.substring(0, sMsg.length-3);
                        		j=99;
                               break;
                            case "yw":      //yyyy-ww
                                sMsg = "'" + sTitle + "' is not valid. Please enter a correct date.\n\n Format : YYYY-WW";
                            	j=99;
                                break;
                            case "yyyy":      //yyyy
	                            sMsg = "'" + sTitle + "' is not valid. Please enter a correct date.\n\n Format : YYYY";
                    			j=99;
	                            break;
                            case "hms":     //hh:mm:ss
                                sMsg = "'" + sTitle + "' is not valid. Please enter a correct time.\n\n Format : HH:MM:SS";
                            	j=99;
                                break;
                            case "hm":      //hh:mm
                                sMsg = "'" + sTitle + "' is not valid. Please enter a correct time.\n\n Format : HH:MM";
                            	j=99;
                            	break;
                            case "int":     //정수
                                sMsg = "'" + sTitle + "' is not valid. Please enter an correct integer format.";
                            	j=99;    
                            	break;
                            case "float":   //실수
                                sMsg = "'" + sTitle + "' is not valid. Please enter a correct float(real type) format.";
                            	j=99;    
                            	break; 
                            case "jumin":   //######-#######
                                sMsg = "'" + sTitle + "' is not valid. Please enter correct a identification no.\n\n Format : ######-#######";
                            	j=99;
                            	break;
                            case "saupja":  //###-##-#####
                                sMsg = "'" + sTitle + "' is not valid. Please enter correct a saupja no.\n\n Format : ###-##-#####";
                            	j=99;
                            	break;
                        }
                        break;
                    case "maxLength":   //입력최대길이 확인
                        if (sVal== "") continue;
                        iMaxLen = attriVal;
                        if(ComGetLenByByte(sVal) > iMaxLen){
                        	sMsg = ComGetMsg('COM12142', sTitle, attriVal);
                        	j=99;
                        }
                        break;
                    case "minlength":   //입력최소길이 확인
                        if (sVal== "") continue;
                        if(ComGetLenByByte(sVal) < attriVal) {
                        	sMsg = ComGetMsg('COM12143', sTitle, attriVal);
                        	j=99;
                        }
                        break;
                    case "fullfill":    //전체입력 확인
                        if (sVal== "") continue;
                        if(ComGetLenByByte(sVal) != iMaxLen) {
                        	sMsg = ComGetMsg('COM12174', sTitle, iMaxLen);
                        	j=99;
                        }
                        break;
                    case "maxnum":      //최대값 확인
                    	iMaxVal = attriVal;
                        if (sVal== "") continue;
                        if (!ComIsMoneyNumber(sVal, true, true, true)) {
                            sMsg = ComGetMsg('COM12178');
                        	j=99;
                        } else if(!ComIsMoneyNumber(attriVal, true, false, false)) {
                            sMsg = "is not valid. Please enter an correct number format. maxnum=" + attriVal;
                        	j=99;
                        } else if (parseFloat(sVal) > parseFloat(attriVal)) {
                            sMsg = "'" + sTitle + "' have to be less than " + attriVal;
                        	j=99;
                        }
                        break;
                    case "minnum":      //최소값 확인
                    	iMinVal = attriVal;
                        if (sVal== "") continue;
                        if (!ComIsMoneyNumber(sVal, true, true, true)) {
                            sMsg = ComGetMsg('COM12178');
                        	j=99;
                        } else if(!ComIsMoneyNumber(attriVal, true, false, false)) {
                            sMsg = "is not valid. Please enter an correct number format. minnum=" + attriVal;
                        	j=99;
                       } else if (parseFloat(sVal) < parseFloat(attriVal)) {
                            sMsg = "'" + sTitle + "' have to be greater than " + attriVal;
                        	j=99;
                        }
                        break;
                    case "pointcount":	//소숫점 아랫자리수 확인
                        if (sVal== "") continue;

                        if (!ComIsMoneyNumber(sVal, true, true, true)) {
                            sMsg = ComGetMsg('COM12178');
                        	j=99;
                        } else if(!ComIsMoneyNumber(attriVal, false, false, false)) {
                            sMsg = "is not valid. Please enter an correct number format. pointcount=" + attriVal;
                        	j=99;
                        } else {
	                        var iLeftLen = iMaxLen-attriVal-1;
                        	var iNum = sVal;
	                        var iPointNum = 0;
	                        
                        	if(sVal.indexOf(".") >= 0) {
	                        	iNum = sVal.split(".")[0];		//소숫점 윗자리값
		                        iPointNum = sVal.split(".")[1];	//소숫점 아랫자리값
                        	}
                        	
                        	if (iPointNum.length > attriVal) {
                        		//소숫점 아래 자리수가 너무 많은 경우
                                sMsg = "'" + sTitle + "' is not valid decimal point. Please enter a maximum " + attriVal + " decimal point";
                            	j=99;
                            } else if (iMaxLen<100 && iLeftLen>0) {
                            	//"iMaxLen<100" 이조건 반드시 필요함. 
                            	//maxLength속성을 설정하지 않으면 기본적으로 2147483647로 설정되므로 너무 커서 메모리 오류 발생함

                            	//iMaxVal은 "maxnum"속성을 읽어서 미리 설정된 값이고, iMinVal은 "minnum"속성을 읽어서 미리 설정된 값임
                            	//만약 두개 속성중 하나라도 없었다면 다음 코드를 통해서 체크한다.
                            	if (iMaxVal==null) iMaxVal = eval(ComLpad("9",iLeftLen,"9") + "." + ComLpad("9",attriVal,"9"));
                            	if (iMinVal==null) iMinVal = eval("-" + ComLpad("9",iLeftLen,"9") + "." + ComLpad("9",attriVal,"9"));
                        		//소숫점 윗 자리수가 너무 많거나 작은 경우 & 사용자정의속성인 maxnum과 minnum이 없는 경우
	                        	if (parseFloat(iNum) > parseFloat(iMaxVal)) {
	                                sMsg = "'" + sTitle + "' have to be less than " +iMaxVal;
	                            	j=99;
	                        	} else if(parseFloat(iNum) < parseFloat(iMinVal)) {
	                                sMsg = "'" + sTitle + "' have to be greater than " +iMinVal;
	                            	j=99;
		                        }
                            }
                        }
                    	break;
                    case "cofield":      //기간확인
                        switch(sFormat) {
                            case "ymd":     //yyyy-mm-dd
                            case "ymdhms":     //yyyy-mm-dd
                            case "ymdhm":     //yyyy-mm-dd
                            case "ym":      //yyyy-mm
                            case "yw":      //yyyy-ww
                            case "yyyy":      //yyyy   
                            case "hms":     //hh:mm:ss
                            case "hm":      //hh:mm
                                var coObj = eval("document.all." + attriVal);
                                var coVal =  ComGetObjValue(coObj);
                                if (coVal != "" && sVal == "")          //현재Obj는 값이 없고, CoObj만 값이 있는 경우
                                    obj.value = coVal;
                                else if (coVal == "" && sVal != "")     //현재Obj는 값이 있고, CoObj만 값이 없는 경우
                                    coObj.value = maskValue;
                                else {  //둘다 있는 경우
	                                var startDate, endDate;
	                                //sourceIndex속성은 obj의 document.all의 순번임, 
	                                //따라서 sourceIndex속성값이 작으면 시작일이고, 크면 종료일이다.
	                                if (obj.sourceIndex < coObj.sourceIndex) {
	                                	startDate=maskValue;
	                                	endDate = coVal;
	                                } else {
	                                	startDate=coVal;
	                                	endDate = maskValue;
	                                }
	                                
	                                //기간체크
	                                if (startDate > endDate && !CofieldFlag) {
	                                	if (obj.sourceIndex < coObj.sourceIndex){
		                                	CofieldFlag = true;
		                                	sTitle2 = (coObj.getAttribute("caption")==null)?"end date":coObj.getAttribute("caption");
	                                		sMsg=ComGetMsg("COM12133", "'" + sTitle+ "'", "'" + sTitle2 + "'", "earlier");
	                                	} else {
		                                	CofieldFlag = false;
		                                	sTitle2 = (coObj.getAttribute("caption")==null)?"start date":coObj.getAttribute("caption");
                                			sMsg=ComGetMsg("COM12133", "'" + sTitle+ "'", "'" + sTitle2 + "'", "later");
	                                	}
	                                	j=99;
	                                }else
	                                	CofieldFlag = false;
                                }
                                break;
                        }
                        break;
                }

                if (sMsg!="") {
                	if(event == null){
                		if (bMsg) ComShowMessage(sMsg);
 		                obj.focus(); 
		                obj.select(); 
                	}else{
                	//포커스 나갈수 있는 경우 : 이벤트를 통해서 함수가 호출되고, 값이 공백이거나 readonly인 경우
	                	var canFocusOut = (event.srcElement == obj && (sVal=="" || obj.getAttribute("readOnly")==true));
	                	
	                    if (bMsg && !canFocusOut) ComShowMessage(sMsg);
	
	                    //컨트롤이 숨겨져 있을수도 있으므로 에러 감싼다.
	                    try{                     	
	                    	if(canFocusOut) {
	                    		event.returnValue = true;
	                    	} else {
	                			//값이 정확할때 까지 포커스가 나가지 않아야 하는 경우
//		                    	event.cancelBubble = true;
	                			if(pastEventNum == 0){
	                				pastEventNum = 1;
	                				pastEventObj = event.srcElement.name;
	                			}else if(pastEventNum ==1){
	                				pastEventNum = 2;
	                			}else{
	                				pastEventNum =0;
	                				if(pastEventObj == event.srcElement.name)
	                					event.stopPropagation();
	                			}
		                    	event.returnValue = false;
		                    	obj.focus(); 
		                    	obj.select(); 
		                    	event.stopPropagation( );
		                    }
	
	                    } catch(ee) {;}
	                }
                    return false;
                }
            }

            if (bMasked && sFormat != "") {
                obj.value = ComGetMaskedValue(obj, sFormat);
            }
        } catch(err) { ComFuncErrMsg(err.message); }
        
        return true;
    }
    
    /**
	* @param     : obj => 객체
	* sample	: <input name="up" type="text" onblur="upper(this)"  />
	* @return 	: 
	* 설명		: 대문자로 만들기
	**/
	function upper(obj){
		str = obj.value;
		str = str.toUpperCase();
		obj.value = str;
	}
	
	/**
 * event가 발생한 object 또는 ojbect의 다양한 속성을 가져온다. IE/Chrome/FireFox 경우 처리<br>
 * <br><b>Example :</b>
 * <pre>
 *     ComGetEvent();
 *     ComGetEvent("name");
 *     ComGetEvent("keycode");
 *     ComGetEvent("value");
 *     ComGetEvent("dataformat");
 *     ComGetEvent("maxlength");
 * </pre>
 * @return 없음
 */
function ComGetEvent(sArgName){
	var obj = event.target || event.srcElement;
	if (sArgName==undefined || sArgName == null) return obj;
	
	switch(sArgName){
		case "type":
			return event.type;
		case "name":
			if(obj.className == "underline" && obj.parentElement.type == "button") {
				return obj.parentElement.name || obj.parentElement.id;
			}
			else {
				return obj.name || obj.id;
			}
		case "keycode":
			return event.keyCode || event.which || event.charCode;
		case "value":
			return obj.value;
		case "shiftKey":
			return event.shiftKey;
		case "ctrlKey":
			return event.ctrlKey;
		default: //ex) "dataformat", "maxlength"
			var argVal = obj.getAttribute(sArgName);
			if (argVal==null) return;
			return argVal;
	}
	return;
}
