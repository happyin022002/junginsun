/**
===============================================================================
프로그램  명  : 대기 이미지 관련 공통 함수 정의 Script
프로그램개요  : 대기 이미지 관련 기능을 정의한다.
작   성   자  : 이경희
작   성   일  : 2008-11
===============================================================================
수정자/수정일 : 
수정사유/내역 : 
===============================================================================
*/

    /*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 대기이미지 처리 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @class CoWait : 대기이미지 처리 관련 함수가 정의한다.
     */
    function CoWait() {
        this.ComOpenWait         = ComOpenWait;
        this.ComOpenWaitCallFunc = ComOpenWaitCallFunc;
    }

    /*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
    var waitW   = 249;
    var waitH   = 76;
    var waitImage = "/hanjin/img/waiting.gif";
    
    var WAIT_DIV_NAME = "_DivWait_";
    var WAIT_FRAME_NAME = "_iFrameWait_";
    var WAIT_DIV_NAME2 = "DivWait2";
    var WAIT_FRAME_NAME2 = "iFrameWait2";
   var waitDoc = null;
    var isOpenWaitWindow = false;
    
    //Top의 WAS와 현재페이지의 WAS가 다른 경우가 있어서 아래와 같이 처리한다.
    try {
        waitDoc = top.document
    } catch(err) {
        waitDoc = document;
    }
    
    //2008.12.01-이미지가 잘 로드되지 않거나 보이지 않는 문제를 해결하기 위해 페이지가 로드되면 대기이미지Frame을 미리 로드시켜두기 위해 아래 코드 사용
    document.onreadystatechange = initWaitFrame;

    /**
     * 대기상태 여부와 대기이미지표시여부를 설정 변경한다. <br>
     * 특정 스크립트가 호출되는 동안 키보드나 마우스를 대기상태로 만들고자 할때 flag인자를 true로 설정하고, 이때 대기이미지까지 표시하고자 한다면 bOpenLayer인자를 true로 설정하여 이 함수를 호출한다. <br>
     * 특정 스크립트가 완료되어 키보드나 마우스를 원래상태로 하고, 대기이미지도 숨기고자 한다면 flag 인자를 false로 설정하여 이 함수를 호추한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    ComOpenWait(true);          //setBkgCargo함수와 doActionIBSheet함수가 완료될때 까지 대기상태 유지
     *    setBkgCargo();
     *    doActionIBSheet(sheetObject,formObject,COMMAND01)
     *    ComOpenWait(false);
     * </pre>
     * @param {bool}   flag         필수,키보드나 마우스를 대기상태(true)/일반상태(false)
     * @param {bool}   bOpenLayer   선택,대기이미지(Waiting) 표시 여부, default=true
     * @return 없음
     * @see #ComOpenWaitCallFunc
     */
    function ComOpenWait(flag, bOpenLayer){
        try {
            if(flag == isOpenWaitWindow ) return;// 이미 Wait화면이 오픈된 경우나 Wait화면이 Close된 상태에서 다시 close할때 return한다.
            if(waitDoc.getElementById(WAIT_DIV_NAME)==null && !flag) return;
            if(waitDoc.getElementById(WAIT_DIV_NAME)==null && flag) initWaitFrame();

//            isOpenWaitWindow = flag;
            if (flag == true) {
                isOpenWaitWindow = flag;
            }
            
            try {
                var childWaitDoc = waitDoc.getElementById("main").contentWindow.document;
            } catch(err) {
                var childWaitDoc = waitDoc;
            }

            var divobj  = waitDoc.getElementById(WAIT_DIV_NAME);
            var waitImg = waitDoc.getElementById(WAIT_FRAME_NAME);

            if(flag) {
                ComComboObjsEnable(false, childWaitDoc);
                //위치를 살짝 바꾸는것은 그래야 나중에 div태그가 잘 보이기 때문임
                //divobj.style.left = 0;
                //divobj.style.top = 0;

                //인자를 설정하지 않은 경우 default=true로 설정하기 위함
                if (bOpenLayer==undefined || bOpenLayer==null) bOpenLayer = true;
                if(bOpenLayer)  {
                    //브라우저의 크기가 변경될수 있으므로 iFrame의 위치를 수정한다.
                    //var leftPos=(divobj.clientWidth-waitW)/2;       if(leftPos<0)   leftPos=0;
                    //var topPos =(divobj.clientHeight-waitH)/2;      if(topPos<0)    topPos=0;

                    var leftPos=(divobj.clientWidth-waitW)/2 + waitDoc.body.scrollLeft ;       if(leftPos<0)   leftPos=0;
                    var topPos =(divobj.clientHeight-waitH)/2 + waitDoc.body.scrollTop  ;      if(topPos<0)    topPos=0;


                    waitImg.style.left = leftPos;
                    waitImg.style.top  = topPos;
                    //ComDebug("wait div=" + divobj.clientWidth +"," +divobj.clientHeight);

                    //waitImg.style.visibility="visible";
                    waitImg.style.display="inline";
                } else {
                    //waitImg.style.visibility="hidden";
                    waitImg.style.display="none";
                }
                
                /*
                ComDebug("wait div top scrollTop=" + waitDoc.body.scrollTop);
                ComDebug("wait div top clientTop=" + waitDoc.body.clientTop);
                ComDebug("wait div top offsetTop=" + waitDoc.body.offsetTop);
                */

                //스크롤바를 없애는것은 대기이미지가 그려지지 않은 영역으로 움직이지 않도록 하기 위함
                //waitDoc.body.scroll = "no";
                
                //위치를 바뀌주고, visible후 focus를 설정해주어야 대기이미지가 잘 보임
                divobj.style.left = waitDoc.body.scrollLeft;
                divobj.style.top =  waitDoc.body.scrollTop;

                divobj.style.visibility="visible";
                divobj.focus();
                if(bOpenLayer)  {
                waitImg.style.visibility="visible";
                waitImg.focus();
                }
                window.defaultStatus="Processing......";
                window.status="Processing......";
                top.window.document.body.style.cursor="wait";
                window.document.body.style.cursor="wait";
                try {window.event.cancelBubble=true;} catch(ex) {}
            } else {
                top.window.document.body.style.cursor="default";
                window.document.body.style.cursor="default";
                window.defaultStatus="";
                window.status="";

                divobj.style.visibility="hidden";
                divobj.style.left = 0;
                divobj.style.top = 0;

                waitImg.style.visibility="hidden";
                waitImg.style.left = 0;
                waitImg.style.top = 0;

                //waitDoc.body.scroll = "yes";
                ComComboObjsEnable(true,childWaitDoc);
            }
//            isOpenWaitWindow = flag;
            if (flag == false) {
                isOpenWaitWindow = flag;
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }

 
    //IBCombo의 상태정보 저장
    var ORI_IBCOMBO_STATUS = new Array();
    //IBSheet의 상태정보 저장
    var ORI_IBSHEET_STATUS = new Array();
    //IBTab의 상태정보 저장
    var ORI_IBTAB_STATUS = new Array();
    //Select Box의 상태정보 저장
    var ORI_SELECT_STATUS = new Array();
    var idx_combo=0;
    var idx_ibtab=0;
    var idx_ibsheet=0;
    var idx_select=0;

    /**
     * UI에 있는 ActiveX(IBMultiCombo, IBTab, IBSheet)를 Enable 또는 Disable 한다.
     * 이 때 Object들을 참조 하기 위한 class_id 상수값은 CoObject.js의 값을 참조한다.
     * 또한 해당 UI에 iframe이 포함 돼 있을경우 iframe안의 ActiveX Object들까지 모두 Enable 또는 Disable 한다.
     *
     * <br><b>Example :</b>
     * <pre>
     *    ComComboObjsEnable(true,childWaitDoc);
     * </pre>
     * @param {bool}   flag         필수,Object들의 상태를 Enable(true)/Disable(flase)로 바꾼다.
     * @param {object}   childWaitDoc   필수,ActiveX Object들을 포함하는 document object
     * @param {int}     depth   선택, recursive function 이기 때문에 현재의 depth
     * @return 없음
     */
    function ComComboObjsEnable (flag,childWaitDoc,depth) {
        var formObj = childWaitDoc.form;
        if (formObj == undefined) return;
        if (depth == undefined) depth = 0;

        if (depth == 0) {
            idx_combo=0;
            idx_ibtab=0;
            idx_ibsheet=0;
            idx_select=0;
        }
        len = formObj.elements.length;

        if (flag == false) {
            for (i = 0 ; i < len ; i++) {
                if (formObj.elements[i].classid!=undefined) {
                    switch (formObj.elements[i].classid) {
                        case CLSID_IBMCOMBO: // IBMultiCombo 경우
                            if (formObj.elements[i].Enable == false) {
                                ORI_IBCOMBO_STATUS[idx_combo++] = "false";
                            } else {
                                ORI_IBCOMBO_STATUS[idx_combo++] = "true";
                            }
                            formObj.elements[i].Enable = false;
                            break;
                        case CLSID_IBTAB : //IBTab
                            if (formObj.elements[i].Enable == false) {
                                ORI_IBTAB_STATUS[idx_ibtab++] = "false";
                            } else {
                                ORI_IBTAB_STATUS[idx_ibtab++] = "true";
                            }
                            formObj.elements[i].Enable = false;
                            break;
                        case CLSID_IBSHEET : //IBSheet
                            if (formObj.elements[i].Enable == false) {
                                ORI_IBSHEET_STATUS[idx_ibsheet++] = "false";
                            } else {
                                ORI_IBSHEET_STATUS[idx_ibsheet++] = "true";
                            }
                            formObj.elements[i].Enable = false;
                            break; 
                    }
                } else if (formObj.elements[i].type == "select-one") {
                    ORI_SELECT_STATUS[idx_select++] = formObj.elements[i].disabled ;
                    formObj.elements[i].disabled = true;
                }
            }
        } else {
            ///
            var obj = null;
            for (i = 0; i < len; i++) {
                if (formObj.elements[i].classid!=undefined) {
                    switch (formObj.elements[i].classid) {
                        case CLSID_IBMCOMBO: // IBMultiCombo 경우
//                            if (ORI_IBCOMBO_STATUS[idx_combo++] == "true") {
//                                formObj.elements[i].Enable = true;
//                            } else {
//                                formObj.elements[i].Enable = false;
//                            }
                            
                            ///////
                            obj = ORI_IBCOMBO_STATUS[idx_combo++];
                            if (obj != undefined) {
                                if (obj == "true") {
                                    formObj.elements[i].Enable = true;
                                } else {
                                    formObj.elements[i].Enable = false;
                                }
                            }
                            
                            break;
                        case CLSID_IBTAB : //IBTab
//                            if (ORI_IBTAB_STATUS[idx_ibtab++] == "true") {
//                                formObj.elements[i].Enable = "true";
//                            } else {
//                                formObj.elements[i].Enable = "false";
//                            }
                            
                            //////
                            obj = ORI_IBTAB_STATUS[idx_ibtab++];
                            if (obj != undefined) {
                                if (obj == "true") {
                                    formObj.elements[i].Enable = true;
                                } else {
                                    formObj.elements[i].Enable = false;
                                }
                            }
                            
                            break;
                        case CLSID_IBSHEET : //IBSheet
//                            if (ORI_IBSHEET_STATUS[idx_ibsheet++] == "true") {
//                                formObj.elements[i].Enable = true;
//                            } else {
//                                formObj.elements[i].Enable = false;
//                            }
                            
                            ///////
                            obj = ORI_IBSHEET_STATUS[idx_ibsheet++];
                            if (obj != undefined) {
                                if (obj == "true") {
                                    formObj.elements[i].Enable = true;
                                } else {
                                    formObj.elements[i].Enable = false;
                                }
                            }
                            
                            break;
                    }
                } else if (formObj.elements[i].type == "select-one") {
                    formObj.elements[i].disabled = ORI_SELECT_STATUS[idx_select++];
                }
            }
        }
        // iframe 안의 object에 대한 내용을 Enable
	try {
        var iframeObj = childWaitDoc.getElementsByTagName("iframe");
        if (iframeObj.length != undefined) {
            var ifrmLen = iframeObj.length;
            for (var idxFrame = 0 ; idxFrame < ifrmLen ; idxFrame++) {
            	var vflag = flag;
           	var viframe = iframeObj[idxFrame];
            	var vcontentWindow = viframe.contentWindow;
            	var vdocument = vcontentWindow.document;
            	ComComboObjsEnable(flag, vdocument ,depth+1) ;
            	/*if(iframeObj[idxFrame].contentWindow != null){
            		ComComboObjsEnable(flag,iframeObj[idxFrame].contentWindow.document ,depth+1) ;
            	}else{
            		ComComboObjsEnable(flag,iframeObj[idxFrame].document ,depth+1) ;
            	}*/
            }
        }
	} catch(e) {
	}
    }

 
    /**
     * 첫번째 인자로 받은 특정 javascript Function을 호출하고, 그 함수가 실행되는 동안 대기이미지(Waiting)를 표시한다. <br>
     * 그 함수의 실행이 끝나면 대기이미지(Waiting)가 사라지고, 키보드나 마우스의 대기상태도 원래상태로 복원된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    ComOpenWaitCallFunc("setBkgCargo"); //setBkgCargo() 함수가 호출시작하면 대기상태로 되고, 실행완료되면 원래상태로 복원된다.
     *
     *    //아래의 3줄의 코드는 위의 1줄 코드와 동일하다.
     *    ComOpenWait(true);
     *    setBkgCargo();
     *    ComOpenWait(false);
     * </pre>
     * @param {string} sFunc        필수,호출할 Function 문장 전체
     * @param {bool}   bOpenLayer   선택,대기이미지(Waiting) 표시 여부, default=false
     * @return 없음
     * @see #ComOpenWait
     */
    function ComOpenWaitCallFunc(sFunc, bOpenLayer) {
        try{
            ComOpenWait(true, bOpenLayer);
            setTimeout(sFunc+"();ComOpenWait(false);", 100)
            /*
            if(ComFuncCheck(sFunc)) {
                ComFunc();
                ComOpenWait(false);
            } else {
                ComShowMessage("[ComOpenWaitCallFunc]" +sFunc + "함수는 정의되어 있지 않습니다.");
            }
            */
        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     * 대기이미지를 처리하기 위한 대기Frame을 document 안에 생성 처리한다.<br>
     * 이 함수는 이파일(CoWait.js)에서만 사용하기 위한 목적으로 만들졌다.
     * <br><b>Example :</b>
     * <pre>
     *    initWaitFrame();
     * </pre>
     * @return 없음
     * @see #ComOpenWait
     */
    function initWaitFrame() {
        try {
            if (document.readyState!="complete") return;
            document.onreadystatechange = null;
            
            if (waitDoc != null && waitDoc.getElementById(WAIT_DIV_NAME)!=null) return;
            //대기 이미지를 위한 DIV 만들기
            var _divWait=waitDoc.createElement("<div id='"+WAIT_DIV_NAME+"' style='filter:alpha(opacity=20);background-color:gray;position:absolute; cursor:wait; left:0px; top:0px; width:100%; height:99.9%; z-index:100; visibility:hidden;'/>");
            waitDoc.body.insertBefore(_divWait);
            //DIV안에 iFrame 만들기(대기이미지가 select or object태그 아래로 숨겨지지 않도록 하기 위함)
            //var _frameWait = waitDoc.createElement("<IFRAME id='"+WAIT_FRAME_NAME+"' src='"+waitImage +"' frameborder=0 marginHeight=0 marginWidth=0 width="+waitW+" height="+waitH+" style='position:absolute;' />");
            //_divWait.appendChild(_frameWait);         
        } catch(err) { ComFuncErrMsg(err.message); }
    }

 
    /**
     * 대기이미지가 보이는 동안 화면의 버튼은 클릭 이벤트가 동작하지 않도록한다.<br>
     * 이 함수는 이파일(CoWait.js)에서만 사용하기 위한 목적으로 만들졌다.
     * ComBtnsEnable(false);
     * ComBtnsEnable(true);
     */
    function ComBtnsEnable(flag){
        if (flag==undefined || flag==null) flag = true ;
            var tds = document.getElementsByTagName("td");  
        for(var i = 0; i < tds.length; i++) {           
            var td=tds[i];
            if (td.className.length > 0 && td.name != undefined){
                if(flag)
                    td.name=td.name.replace(/•/i, "");
                else
                    if(td.name.indexOf('•') == -1 ) td.name="•"+td.name; 
                //ComDebug(td.name);
            }
        }

    }
