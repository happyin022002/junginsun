/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4105.js
*@FileTitle : Remark(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : Mun Jung Cheol
*@LastVersion : 1.0
* 2009.09.25 Mun Jung Cheol
* 1.0 Creation
=========================================================*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
    * @extends 
    * @class ui_dmt_4105 : ui_dmt_4105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function ui_dmt_4105() {
        this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }

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
                    
                case "btn_new":
                    var formObject = document.form;
                    formObject.remark01.value="";
                    formObject.remark02.value="";
                break;
                    
                case "btn_save":
                    doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break; 
                    
                case "btn_close":
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
        ComConfigSheet (sheetObjects[0] );
        initSheet(sheetObjects[0],1);
        ComEndConfigSheet(sheetObjects[0]);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        dmt4105.innerText = "Payer";
        
        axon_event.addListener  ( 'keyup' , 'obj_keyup' , 'remark01' );
        axon_event.addListener  ( 'keyup' , 'obj_keyup' , 'remark02' );
        axon_event.addListener  ( 'keypress' , 'obj_keypress' , 'remark01' , 'remark02' );
    }

    function obj_keyup() {
        ComChkObjValid(event.srcElement,false);
    }
    
//    SetAppendReport
//------------------------------------------------------------------ 
//Function : obj_keydown1() 
//Description : 입력한 글자수를 체크 
//Argument : Object Name(글자수를 제한할 컨트롤) 
//Return : 
//------------------------------------------------------------------ 
function obj_keyup1() { 
    
    var ls_str = document.form.remark01.value; // 이벤트가 일어난 컨트롤의 value 값 
    var li_str_len = ls_str.length; // 전체길이 
    
    // 변수초기화 
    var li_max = 85; // 제한할 글자수 크기 
    var i = 0; // for문에 사용 
    var li_byte = 0; // 한글일경우는 2 그밗에는 1을 더함 
    var li_len = 0; // substring하기 위해서 사용 
    var ls_one_char = ""; // 한글자씩 검사한다 
    var ls_str2 = ""; // 글자수를 초과하면 제한할수 글자전까지만 보여준다. 
    
    for ( i4 = 0 ; i4 < li_str_len ; i4++ ) {
        
        // 한글자추출 
        ls_one_char = ls_str.charAt(i4); 
        
        // 한글이면 2를 더한다. 
        if ( escape( ls_one_char ).length > 4 ) { 
            li_byte += 2; 
        } else { // 그밗의 경우는 1을 더한다. 
            li_byte++; 
        } 
        
        // 전체 크기가 li_max를 넘지않으면 
        if ( li_byte <= li_max ) { 
            li_len = i4 + 1; 
        }
        
    } 
    
    // 전체길이를 초과하면 
    if ( li_byte > li_max ) { 
//        alert( li_max + " 글자를 초과 입력할수 없습니다. \n 초과된 내용은 자동으로 삭제 됩니다. "); 
        ls_str2 = ls_str.substr(0, li_len); 
        document.form.remark01.value = ls_str2; 
    } 
    
    document.form.remark01.focus();

} 

//
//------------------------------------------------------------------ 
//Function : obj_keypress() 
//Description : Enter키를 못치게한다. 
//Argument : 
//Return : 
//------------------------------------------------------------------ 
function obj_keypress () { 
    if(event.keyCode == 13) 
    event.returnValue=false; 
}

// 
//------------------------------------------------------------------
//한글을 2바이트 씩 계산하여 입력받은 문자열이 DB에 저장될 때 총 몇바이트를 차지하는지 계산한다. 
//엔터(\r\n)는 2바이트를 차지한다. 
//@param val : 입력받은 문자열 
//------------------------------------------------------------------
function cal_length( val ) { 
    
    // 입력받은 문자열을 escape() 를 이용하여 변환한다. 
    // 변환한 문자열 중 유니코드(한글 등)는 공통적으로 %uxxxx로 변환된다. 
    var temp_estr = escape(val); 
    var s_index = 0; 
    var e_index = 0; 
    var temp_str = ""; 
    var cnt = 0; 
    
    // 문자열 중에서 유니코드를 찾아 제거하면서 갯수를 센다. 
    while ( ( e_index = temp_estr.indexOf( "%u" , s_index ) ) >= 0 ) { // 제거할 문자열이 존재한다면
        temp_str += temp_estr.substring(s_index, e_index); 
        s_index = e_index + 6; 
        cnt ++; 
    } 
    
    temp_str += temp_estr.substring(s_index); 
    
    temp_str = unescape(temp_str); // 원래 문자열로 바꾼다. 
    
    // 유니코드는 2바이트 씩 계산하고 나머지는 1바이트씩 계산한다. 
    return ( ( cnt * 2 ) + temp_str.length ) + ""; 
    
} 
    
    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo) {
        var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    Visible = false;
               }
            break;            
        }
    }     

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
                if ( document.form.tjspno.value == "4012" ) {
                    formObj.f_cmd.value = SEARCH01;
                    sheetObj.Reset();
                    initSheet(sheetObjects[0], 0);
                    var sXml = sheetObj.GetSearchXml("EES_DMT_4105GS.do",FormQueryString(formObj));
                    var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark != undefined && rtnRemark != '' ) {
                        var paryInfoArr = rtnRemark.split("\n");
                        if ( !ComIsEmpty(paryInfoArr[0]) ) {
                            document.form.remark01.value= paryInfoArr[0];
                        } else {
                            document.form.remark01.value= "";
                        }
                        if ( !ComIsEmpty(paryInfoArr[1]) ) {
                            document.form.remark02.value = paryInfoArr[1];
                        } else {
                            document.form.remark02.value= "";
                        }                        
                    }
                }else{
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.Reset();
                    initSheet(sheetObjects[0], 0);
                    var sXml = sheetObj.GetSearchXml("EES_DMT_4105GS.do",FormQueryString(formObj));
                    var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark != undefined && rtnRemark != '' ) {
                        var paryInfoArr = rtnRemark.split("\n");
                        if ( !ComIsEmpty(paryInfoArr[0]) ) {
                            document.form.remark01.value= paryInfoArr[0];
                        } else {
                            document.form.remark01.value= "";
                        }
                        if ( !ComIsEmpty(paryInfoArr[1]) ) {
                            document.form.remark02.value = paryInfoArr[1];
                        } else {
                            document.form.remark02.value= "";
                        } 
                    }                   
                }
            break;

            case IBSAVE:        //저장
                document.form.rmrk.value = document.form.remark01.value + "\n" + document.form.remark02.value;
                if ( document.form.tjspno.value == "4012" ) {
                    formObj.f_cmd.value = MULTI01;
                    var sXml = sheetObj.GetSaveXml("EES_DMT_4105GS.do", FormQueryString(formObj));
                    alert(dmtGetMsgText(sXml));
//                    sheetObjects[0].LoadSaveXml(sXml);
                } else {
                    formObj.f_cmd.value = MULTI;
                    var sXml = sheetObj.GetSaveXml("EES_DMT_4105GS.do", FormQueryString(formObj));
                    alert(dmtGetMsgText(sXml));
//                    sheetObjects[0].LoadSaveXml(sXml);
                }
                window.close();
            break;

        }
    }

function dmtGetMsgText(xmlStr){

    try {
        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;

        var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(msgNode == null) 
         return;
        else
         return msgNode.firstChild.nodeValue;
   } catch(err) { ComFuncErrMsg(err.message); }
   
}    
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){

        }
        return true;
    }
