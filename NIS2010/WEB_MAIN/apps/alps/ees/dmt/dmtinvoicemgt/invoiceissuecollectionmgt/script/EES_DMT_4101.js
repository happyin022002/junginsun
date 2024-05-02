/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4101.js
*@FileTitle : Sheet Setting Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : Mun Jung Cheol
*@LastVersion : 1.0
* 2009.10.01 Mun Jung Cheol
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
    * @class ui_dmt_4101 : ui_dmt_4101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function ui_dmt_4101() {
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
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
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
                    formObject.reset();
                    comboObjects[0].Code = formObject.tftp2.value;
                    formObject.shttpp.value = formObject.sheetp.value;
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;
                    
                case "btn_save":
            		//버튼권한 추가(2010.04.08)
            		if(ComGetObjValue(formObject.sec_invoice) == "N") {
            			ComShowCodeMessage("DMT01145", "Save");
            			return;
            		}
            		
                    if ( formObject.h_user_office.value == formObject.issoff.value ) {
                        if ( ComShowConfirm( ComGetMsg("DMT01132") ) ) {
                            if ( document.form.copyFlag.value == "Y" ) {
                                document.form.ofad01.value = document.form.hOfad01.value;
                                document.form.ofad02.value = document.form.hOfad02.value;
                                document.form.ofad03.value = document.form.hOfad03.value;
                                document.form.head01.value = document.form.hHead01.value;
                                document.form.head02.value = document.form.hHead02.value;
                                document.form.head03.value = document.form.hHead03.value;
                                document.form.head04.value = document.form.hHead04.value;
                                document.form.head05.value = document.form.hHead05.value;
                                document.form.head06.value = document.form.hHead06.value;
                                document.form.head07.value = document.form.hHead07.value;
                                document.form.head08.value = document.form.hHead08.value;
                                document.form.head09.value = document.form.hHead09.value;
                                document.form.head10.value = document.form.hHead10.value;
                                document.form.foot01.value = document.form.hFoot01.value;
                                document.form.foot02.value = document.form.hFoot02.value;
                                document.form.foot03.value = document.form.hFoot03.value;
                                document.form.foot04.value = document.form.hFoot04.value;
                                document.form.foot05.value = document.form.hFoot05.value;
                                document.form.foot06.value = document.form.hFoot06.value;
                                document.form.foot07.value = document.form.hFoot07.value;
                                document.form.foot08.value = document.form.hFoot08.value;
                                document.form.foot09.value = document.form.hFoot09.value;
                                document.form.foot10.value = document.form.hFoot10.value;
                                document.form.foot11.value = document.form.hFoot11.value;
                                document.form.foot12.value = document.form.hFoot12.value;
                                document.form.foot13.value = document.form.hFoot13.value;
                                document.form.foot14.value = document.form.hFoot14.value;
                                doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                                document.form.copyFlag.value = "N";
                                ComBtnEnable("btn_copy");
                            } else {
                                doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                                document.form.copyFlag.value = "N";
                                ComBtnEnable("btn_copy");
                            }
                        } else {
                            return false;
                        }
                    } else {
                        ComShowMessage(msgs["DMT01133"]);
                        return false;
                    }
                break; 
                    
                case "btn_close":
                    window.close();
                break;
                
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;
                
                case "btn_copy":
            		//버튼권한 추가(2010.04.08)
            		if(ComGetObjValue(formObject.sec_invoice) == "N") {
            			ComShowCodeMessage("DMT01145", "Copy");
            			return;
            		}
            		
                    document.form.hOfad01.value = document.form.ofad01.value;
                    document.form.hOfad02.value = document.form.ofad02.value;
                    document.form.hOfad03.value = document.form.ofad03.value;
                    document.form.hHead01.value = document.form.head01.value;
                    document.form.hHead02.value = document.form.head02.value;
                    document.form.hHead03.value = document.form.head03.value;
                    document.form.hHead04.value = document.form.head04.value;
                    document.form.hHead05.value = document.form.head05.value;
                    document.form.hHead06.value = document.form.head06.value;
                    document.form.hHead07.value = document.form.head07.value;
                    document.form.hHead08.value = document.form.head08.value;
                    document.form.hHead09.value = document.form.head09.value;
                    document.form.hHead10.value = document.form.head10.value;
                    document.form.hFoot01.value = document.form.foot01.value;
                    document.form.hFoot02.value = document.form.foot02.value;
                    document.form.hFoot03.value = document.form.foot03.value;
                    document.form.hFoot04.value = document.form.foot04.value;
                    document.form.hFoot05.value = document.form.foot05.value;
                    document.form.hFoot06.value = document.form.foot06.value;
                    document.form.hFoot07.value = document.form.foot07.value;
                    document.form.hFoot08.value = document.form.foot08.value;
                    document.form.hFoot09.value = document.form.foot09.value;
                    document.form.hFoot10.value = document.form.foot10.value;
                    document.form.hFoot11.value = document.form.foot11.value;
                    document.form.hFoot12.value = document.form.foot12.value;
                    document.form.hFoot13.value = document.form.foot13.value;
                    document.form.hFoot14.value = document.form.foot14.value;
                    document.form.copyFlag.value = "Y";
                    ComBtnDisable("btn_copy");
                break;
                
                case "btn_del":
            		//버튼권한 추가(2010.04.08)
            		if(ComGetObjValue(formObject.sec_invoice) == "N") {
            			ComShowCodeMessage("DMT01145", "Delete");
            			return;
            		}                	
                	
                    if ( formObject.h_user_office.value == formObject.issoff.value ) {                    
                        if ( ComShowConfirm( ComGetMsg("DMT01134") ) ) {
                            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                        } else {
                            return false;
                        }
                    } else {
                        ComShowMessage(msgs["DMT01135"]);
                        return false;
                    }
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

    function setComboObject(combo_obj) {  
        comboObjects[comboCnt++] = combo_obj;  
    }
    
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
        var formObject = document.form
        
        switch(comboNo) {  
                
            case 1: 
                with (comboObj) { 
                    MultiSelect = false; 
                    UseAutoComplete = true; 
                    SetColAlign("left|left");   
                    SetColWidth("50|300");
                    DropHeight = 160;
                }
                comboObj.InsertItem( 0 , "DMIF|DEMURRAGE INBOUND LADEN CONTAINER"     , "DMIF" );
                comboObj.InsertItem( 1 , "DTIC|DETENTION INBOUND CONTAINER"           , "DTIC" );
                comboObj.InsertItem( 2 , "DMOF|DEMURRAGE OUTBOUND LADEN CONTAINER"    , "DMOF" );
                comboObj.InsertItem( 3 , "DTOC|DETENTION OUTBOUND CONTAINER"          , "DTOC" );
                comboObj.InsertItem( 4 , "CTIC|COMBINED DETENTION INBOUND CONTAINER"  , "CTIC" );                
                comboObj.InsertItem( 5 , "CTOC|COMBINED DETENTION OUTBOUND CONTAINER" , "CTOC" );
                comboObj.Code = formObject.tftp2.value;
                formObject.shttpp.value = formObject.sheetp.value;
            break;
            
         } 
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
        axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
        initCombo(comboObjects[0],1);
        
            if ( document.form.shttpp.value == "I" || document.form.shttpp.value == "D" ) {
                div_view01.style.display = "none";
                div_view02.style.display = "";
            } else if ( document.form.shttpp.value == "G" || document.form.shttpp.value == "O" ) {
                div_view01.style.display = "";
                div_view02.style.display = "none";
            }        
        
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'ofad01' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'ofad02' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'ofad03' );
        
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'head01' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'head02' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'head03' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'head04' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'head05' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'head06' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'head07' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'head08' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'head09' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'head10' );
        
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot01' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot02' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot03' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot04' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot05' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot06' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot07' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot08' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot09' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot10' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot11' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot12' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot13' );
        axon_event.addListener ( 'keyup' , 'obj_keyup' , 'foot14' );
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
    }
    
    function obj_keyup() {
//        if ( ComGetLenByByte( ComGetObjValue( event.srcElement ) ) >= 85 ) {
//            return false;
//        }
        updateChar(event.srcElement, 85);
        //ComChkObjValid(event.srcElement,false);
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
        formObj.trftpp.value = ComGetObjValue(comboObjects[0]);
        switch(sAction) {
            case IBSEARCH:      //조회
sheetObj.WaitImageVisible = true;            
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.Reset();
                    initSheet(sheetObjects[0], 0);
                    
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                    
                    var sXml = sheetObj.GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    
ComOpenWait(false);
                    
                    var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark != undefined && rtnRemark != '' ) {
                        var paryInfoArr = rtnRemark.split("|");
                        document.form.ofad01.value = paryInfoArr[ 0];
                        document.form.ofad02.value = paryInfoArr[ 1];
                        document.form.ofad03.value = paryInfoArr[ 2];
                        document.form.head01.value = paryInfoArr[ 3];
                        document.form.head02.value = paryInfoArr[ 4];
                        document.form.head03.value = paryInfoArr[ 5];
                        document.form.head04.value = paryInfoArr[ 6];
                        document.form.head05.value = paryInfoArr[ 7];
                        document.form.head06.value = paryInfoArr[ 8];
                        document.form.head07.value = paryInfoArr[ 9];
                        document.form.head08.value = paryInfoArr[10];
                        document.form.head09.value = paryInfoArr[11];
                        document.form.head10.value = paryInfoArr[12];
                        document.form.foot01.value = paryInfoArr[13];
                        document.form.foot02.value = paryInfoArr[14];
                        document.form.foot03.value = paryInfoArr[15];
                        document.form.foot04.value = paryInfoArr[16];
                        document.form.foot05.value = paryInfoArr[17];
                        document.form.foot06.value = paryInfoArr[18];
                        document.form.foot07.value = paryInfoArr[19];
                        document.form.foot08.value = paryInfoArr[20];
                        document.form.foot09.value = paryInfoArr[21];
                        document.form.foot10.value = paryInfoArr[22];
                        document.form.foot11.value = paryInfoArr[23];
                        document.form.foot12.value = paryInfoArr[24];
                        document.form.foot13.value = paryInfoArr[25];
                        document.form.foot14.value = paryInfoArr[26];
                    } else {
                        document.form.ofad01.value = "";
                        document.form.ofad02.value = "";
                        document.form.ofad03.value = "";
                        document.form.head01.value = "";
                        document.form.head02.value = "";
                        document.form.head03.value = "";
                        document.form.head04.value = "";
                        document.form.head05.value = "";
                        document.form.head06.value = "";
                        document.form.head07.value = "";
                        document.form.head08.value = "";
                        document.form.head09.value = "";
                        document.form.head10.value = "";
                        document.form.foot01.value = "";
                        document.form.foot02.value = "";
                        document.form.foot03.value = "";
                        document.form.foot04.value = "";
                        document.form.foot05.value = "";
                        document.form.foot06.value = "";
                        document.form.foot07.value = "";
                        document.form.foot08.value = "";
                        document.form.foot09.value = "";
                        document.form.foot10.value = "";
                        document.form.foot11.value = "";
                        document.form.foot12.value = "";
                        document.form.foot13.value = "";
                        document.form.foot14.value = "";
                    }
            break;

            case IBSAVE: // SAVE
                formObj.f_cmd.value = MULTI;
            
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
            
                var sXml = sheetObj.GetSaveXml("EES_DMT_4101GS.do", FormQueryString(formObj));
                
ComOpenWait(false);
                
                //sheetObjects[0].LoadSaveXml(sXml);
            break;

            case IBSEARCH_ASYNC01: // DELETE
                formObj.f_cmd.value = MULTI01;
                
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                
                var sXml = sheetObj.GetSaveXml("EES_DMT_4101GS.do", FormQueryString(formObj));
                doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH );
                
ComOpenWait(false);
                
            break;
            
        }
    }

    function obj_change(){
        obj = event.srcElement;
        if(obj.name == "shttpp"){
            if ( obj.value == "I" || obj.value == "D" ) {
                div_view01.style.display = "none";
                div_view02.style.display = "";
            } else if ( obj.value == "G" || obj.value == "O" ) {
                div_view01.style.display = "";
                div_view02.style.display = "none";
            }
            doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH );
        }
    }
    
    function combo1_OnChange( comboObj , idx_cd , text ){
        with(comboObj){
            doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH );
        }
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){

        }
        return true;
    }

     
function updateChar(obj, length_limit) {
    var length = calculate_msglen(obj.value);
    var tTxtVal = obj.value;
    if (length >= length_limit) {
        ComShowCodeMessage( "DMT00104" , "Length" , "85" );
        obj.value = assert_msglen(obj.value, 85);
        return false;
    }
}

function calculate_msglen(message) {
    var nbytes = 0;

    for (i=0; i<message.length; i++) {
        var ch = message.charAt(i);
        if(escape(ch).length > 4) {
            nbytes += 2;
        } else if (ch == '\n') {
            if (message.charAt(i-1) != '\r') {
                nbytes += 1;
            }
        } else if (ch == '<' || ch == '>') {
            nbytes += 4;
        } else {
            nbytes += 1;
        }
    }

    return nbytes;
}

function assert_msglen(message, maximum) {
    var inc = 0;
    var nbytes = 0;
    var msg = "";
    var msglen = message.length;

    for (i=0; i<msglen; i++) {
        var ch = message.charAt(i);
        if (escape(ch).length > 4) {
            inc = 2;
        } else if (ch == '\n') {
            if (message.charAt(i-1) != '\r') {
                inc = 1;
            }
        } else if (ch == '<' || ch == '>') {
            inc = 4;
        } else {
            inc = 1;
        }
        if ((nbytes + inc) > maximum) {
            break;
        }
        nbytes += inc;
        msg += ch;
    }
    return msg;
}     