/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1165.js
*@FileTitle : Edit Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.16
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.07.16 조원주
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
     * @class esm_bkg_1165 : esm_bkg_1165 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1165() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;

 var por_cd;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        /*******************************************************/
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_ok":
                    comPopupOK();
                    break;

                case "btn_close":
                    window.close();
                    break;


            } // end switch
        } catch(e) {
            if ( e == "[object Error]") {
                ComShowCodeMessage("COM12111");
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
        for (var i=0; i<sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
      
        initControl();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

    function initControl() {
	   	if (document.getElementById("ui_id").value == "ESM_BKG_0079_02C") {
	   		document.form.email.value = opener.document.form.eml.value;
	   		ComBtnDisable("btn_ok");
		}
    }





    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }

    // 부모창의 function을 호출
    function comPopupOK() {
        if (!opener) opener = window.dialogArguments;  // 모달창인 경우는 window 객체로부터 opener를 획득
        var formObj2 = document.form2;
        var func     = formObj2.elements["func"    ].value;
        var pop_mode = formObj2.elements["pop_mode"].value;
        var sheetIdx = formObj2.elements["sheetIdx"].value;
        var row      = formObj2.elements["row"     ].value;
        var col      = formObj2.elements["col"     ].value;
        
        var shCustNm     = formObj2.elements["sh_cust_nm"    ].value;
        var shCustAddr = formObj2.elements["sh_cust_addr"].value;
        var cnCustNm = formObj2.elements["cn_cust_nm"].value;
        var cnCustAddr      = formObj2.elements["cn_cust_addr"     ].value;
        var nfCustNm      = formObj2.elements["nf_cust_nm"     ].value;
        var nfCustAddr      = formObj2.elements["nf_cust_addr"     ].value;
        var shNme = document.form.sh_cust_nm.value;
        var shAddr = document.form.sh_cust_addr.value;
        var cnNm = document.form.cn_cust_nm.value;
        var cnAddr = document.form.cn_cust_addr.value;
        var nfNm = document.form.nf_cust_nm.value;
        var nfAddr = document.form.nf_cust_addr.value;
        var exNme = document.form.ex_cust_nm.value;
        

        if (""==func) {
            window.close();
            return;
        } else {
            func = eval("opener."+func);
            var item = document.form.getElementsByTagName("input");
            var rArray =  new Array(1);
            rArray[0] = new Array(item.length);
      
                    rArray[0][0] = shNme;
                    rArray[0][1] = shAddr;
                    rArray[0][2] = cnNm;
                    rArray[0][3] = cnAddr;
                    rArray[0][4] = nfNm;
                    rArray[0][5] = nfAddr;
                    rArray[0][6] = exNme;
    
            try {

                    func(rArray);
                    window.close();
               
            } catch(e) {
                ComShowCodeMessage("COM12111");
            }
        }
    }

/* 개발자 작업  끝 */
