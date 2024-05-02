/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : message.js
*@FileTitle : Message
*Open Issues :
*Change history :
*@LastModifyDate : 2009.01.02
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.01.02 정인선
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview Message  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     * @author 한진해운
     */

    /**
     * @extends Message
     * @class Message : Message 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function message() {
        this.processButtonClick     = processButtonClick;
        this.setSheetObject     	= setSheetObject;
        this.loadPage     			= loadPage;
        this.initSheet     			= initSheet;
        this.doActionIBSheet     	= doActionIBSheet;
        this.setTabObject    		= setTabObject;
        this.initTab     			= initTab;
        this.validateForm     		= validateForm;
     
    }

    /*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var tabLoad = new Array();
    tabLoad[0]= 0;
    tabLoad[1]= 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * 버튼의 name으로 구분하여 구분하여 프로세스를 분기처리하는 이벤트핸들러이다. <br>
	 * 화면의 버튼이 Click되었을때 호출되며, document.onclick에 의해서 호출되는 함수이다. <br>
	 **/
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];

         /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				case "btn_close":
					window.close();
				break; 
				
				case "btn_t1address":
					ComOpenPopup("orgchart.screen", 800, 420, 'getPopupData', '0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0');
				break;							

				case "btn_t2reply":
					messageReply();
				break;		
				
				case "btn_t2delete":
					messageUpdate("D",0);
				break;		
				
				case "btn_t2keep":
					messageUpdate("K",0);
				break;	

				case "btn_t3delete":
					messageUpdate("D",1);
				break;		
				
				case "btn_t3keep":
					messageUpdate("K",1);
				break;	

				case "btn_t4reply":
					messageReplySavedBox();
				break;		
				
				case "btn_t4delete":
					messageUpdate("D",2);
				break
				
				case "btn_send":
					doActionIBSheet(sheetObjects[2],formObject,IBINSERT);
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
     * 페이지에 생성된 IBSheet Object를 sheetObjects배열에 등록한다. <br>
     * sheetObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComSheetObject} 함수에 의해서 IBSheet Object가 생성되면서 자동 호출된다. <br>
     * @param {ibsheet} sheet_obj    IBSheet Object
     **/
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * body.onload 이벤트에서 호출되는 함수로 페이지 로드완료 후 선처리해야할 기능을 추가한다. <br>
     * HTML컨트롤의 각종 이벤트와 IBSheet, IBTab 등을 초기화 한다. <br>
     **/
    function loadPage(selectNo) {
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1,selectNo);
        }
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);		
    }

    /**
     * 페이지에 있는 IBSheet Object를 초기화 한다. <br>
     * IBSheet가 여러개일 경우 개수만큼 case를 추가하여 IBSheet 초기화 모듈을 구성한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
        	case "t2sheet1":
        		with (sheetObj) {
	                // 높이 설정
	            	style.height = 140;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(10, 0, 0, true);
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false);
	                var HeadTitle = "||From|Content|Send Time|Read Time||||";
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 		DATAALIGN, 	COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    		daCenter,  	false,   	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,     35,    		daCenter,  	false,   	"DelChk");
	                InitDataProperty(0, cnt++ , dtData,      	80,    		daCenter,  	false,     	"sndr_usr_nm",		false,    	"",      	dfNone, 			0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      	345,   		daLeft,    	false,     	"msg_ctnt",     false,    	"",      	dfNone, 			0,     false);
	                InitDataProperty(0, cnt++ , dtData,      	100,    	daCenter,  	false,     	"snd_dt",      	false,    	"",      	dfUserFormat2,		0,     false,       true);
	                InitDataProperty(0, cnt++ , dtData,      	0,    		daCenter,  	false,     	"rcv_dt",      	false,    	"",      	dfUserFormat2,		0,     false,       true);
	                InitDataProperty(0, cnt++ , dtHidden,  	  	0,    		daCenter,  	false,   	"kep_flg");
	                InitDataProperty(0, cnt++ , dtHidden,  	  	0,    		daCenter,  	false,   	"msg_id");
	                InitDataProperty(0, cnt++ , dtHidden,  	  	0,    		daCenter,  	false,   	"delt_flg");
	                InitDataProperty(0, cnt++ , dtHidden,  	  	0,    		daCenter,  	false,   	"sndr_usr_id");
	                
					InitUserFormat2(0, "snd_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, "rcv_dt", "####-##-## ##:##", "-|:" );
					EditableColorDiff = false;
					Ellipsis = true;
					AutoRowHeight = false;
					WaitImageVisible = false;
        		}
        		break;

            case "t3sheet1":
                with (sheetObj) {
	                // 높이 설정
	                style.height = 140;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(10, 0, 0, true);
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false);
	                var HeadTitle = "||To|Content|Send Time|Read Time||||";
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  false,   "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,     35,    	daCenter,  false,   "DelChk");
	                InitDataProperty(0, cnt++ , dtData,      	80,    	daCenter,  false,   "rcvr_usr_nm",      false,    	"",      	dfNone, 		0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      	335,   	daLeft,    false,   "msg_ctnt",     false,    	"",      	dfNone, 		0,     false,       true);
	                InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,  	"snd_dt",      	false,    	"",      	dfUserFormat2,	0,     false,       true);
	                InitDataProperty(0, cnt++ , dtData,      	0,    	daCenter,  false,   "rcv_dt",      	false,    	"",      	dfUserFormat2,	0,     false,       true);
	                InitDataProperty(0, cnt++ , dtHidden,  	  	0,    	daCenter,  false,   "kep_flg");
	                InitDataProperty(0, cnt++ , dtHidden,  	  	0,    	daCenter,  false,   "msg_id");
	                InitDataProperty(0, cnt++ , dtHidden,  	  	0,    	daCenter,  false,   "delt_flg");
	                InitDataProperty(0, cnt++ , dtHidden,  	  	0,    	daCenter,  false,   "rcvr_usr_id");
	                
	                InitUserFormat2(0, "snd_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, "rcv_dt", "####-##-## ##:##", "-|:" );
					EditableColorDiff = false;
					Ellipsis = true;
					AutoRowHeight = false;
					WaitImageVisible = false;
                }
                break;     
                              
            case "t4sheet1":
                with (sheetObj) {
	                // 높이 설정
	                style.height = 140;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(12, 0, 0, true);
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false);
	                var HeadTitle = "||From/To|Div|Content|Send Time|Read Time|||||";
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	                //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  	false,   "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,      35,    daCenter,  	false,   "DelChk");
	                InitDataProperty(0, cnt++ , dtData,      	 100,   daCenter,  	false,   "usr_nm",			false,    "",      dfNone, 			0,     false,       true);
	                InitDataProperty(0, cnt++ , dtData,      	 40,   	daCenter,  	false,   "div",			false,    "",      dfNone, 			0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,      	 270,   daLeft,    	false,   "msg_ctnt", 	false,    "",      dfNone, 			0,     false,       true);
	                InitDataProperty(0, cnt++ , dtData,      	 100,   daCenter,  	false,   "snd_dt",   	false,    "",      dfUserFormat2,	0,     false,       true);
	                InitDataProperty(0, cnt++ , dtData,      	 0,    	daCenter,  	false,   "rcv_dt",   	false,    "",      dfUserFormat2,	0,     false,       true);
	                InitDataProperty(0, cnt++ , dtHidden,  	  	 0,    	daCenter,  	false,   "msg_id");
	                InitDataProperty(0, cnt++ , dtHidden,  	  	 0,    	daCenter,  	false,   "delt_flg");
	                InitDataProperty(0, cnt++ , dtHidden,  	  	 0,    	daCenter,  	false,   "rcvr_usr_id");
	                InitDataProperty(0, cnt++ , dtHidden,  	  	 0,    	daCenter,   false,   "kep_flg");
	                InitDataProperty(0, cnt++ , dtHidden,  	  	 0,    	daCenter,  	false,   "usr_id");
	                InitUserFormat2(0, "snd_dt", "####-##-## ##:##", "-|:" );
	                InitUserFormat2(0, "rcv_dt", "####-##-## ##:##", "-|:" );
	                EditableColorDiff = false;
	                Ellipsis = true;
	                AutoRowHeight = false;
	                WaitImageVisible = false;
                }
                break;                            
        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //전체조회
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("MessageGS.do" , FormQueryString(formObj) + "&archive=");
				var arrXml = sXml.split("|$$|");
				if (arrXml[0].length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
				if (arrXml[1].length > 0) sheetObjects[1].LoadSearchXml(arrXml[1]);
				if (arrXml[2].length > 0) sheetObjects[2].LoadSearchXml(arrXml[2]);		
			break;
			
			case IBSAVE:        //Tab 저장
				formObj.f_cmd.value = MODIFY;
				var sheetString = sheetObj.GetSaveString();
				var sXml = sheetObj.GetSaveXml("MessageGS.do", FormQueryString(formObj) + "&" + sheetString);
				sheetObj.LoadSaveXml(sXml);
			break;
			
			case IBINSERT:      //쪽지보내기
				ComOpenWait(true);
				if(sheetObj == null) if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = ADD;
				var sheetString = sheetObj.GetSaveString();
				if(sheetString == "") sheetString = "ibflag=I";
				var sXml = sheetObj.GetSaveXml("MessageGS.do", FormQueryString(formObj) + "&" + sheetString);
				sheetObj.LoadSaveXml(sXml);
				formObj.rcvr_usr_id.value = "";
				formObj.rcvr_usr_nm.value = "";
				formObj.msg_ctnt.value = "";
				formObj.kep_flg.checked = false;
				getList();
				ComOpenWait(false);
			break;
        }
    }

    /**
     * 페이지에 생성된 IBTab Object를 tabObjects 배열에 등록한다. <br>
     * tabObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComTabObject} 함수에 의해서 IBTab Object가 생성되면서 자동 호출된다. <br>
     * @param {ibtab} tab_obj    IBTab Object
     **/
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }

    /**
     * 페이지에 있는 IBTab Object를 초기화 한다. <br>
     * IBTab가 여러개일 경우 개수만큼 case를 추가하여 IBTab 초기화 모듈을 구성한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBTab Object를 초기화 한다. <br>
     * @param {ibtab}   tabObj      IBTab Object
     * @param {int}     tabNo       tabObjects 배열에서 순번
     **/
    function initTab(tabObj , tabNo, selectNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "New Message" , -1 );
                    InsertTab( cnt++ , "Inbox" , -1 );
                    InsertTab( cnt++ , "Outbox" , -1 );
                    InsertTab( cnt++ , "Savedbox" , -1 );
                    SelectedIndex = selectNo;
                }
             break;
         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem){
        var objs = document.all.item("tabLayer");
    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 //필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;
        return true;
    }
    
    function getList(){
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

    /**
     * 보낸 쪽지함 보관 메소드..
     */
    function messageUpdate(flag,sheetNum){
    	var iCheckRow = sheetObjects[ComParseInt(sheetNum)].FindCheckedRow("DelChk");
    	if(iCheckRow == "") return;
    	var arrRow = iCheckRow.split("|");
    	var div = "RCV";
    	for (idx=0; idx<arrRow.length-1; idx++){
        	if ( ComParseInt(sheetNum) == 0 ) div = "RCV";
        	else if ( ComParseInt(sheetNum) == 1 ) div = "SND";
        	else if ( ComParseInt(sheetNum) == 2 ) div = sheetObjects[2].CellValue(arrRow[idx],"div");
    		if(flag == "K"){
    			//alert('MessageGS.do?f_cmd=4&div='+div+'&rcvDt=NO&msgId='+sheetObjects[ComParseInt(sheetNum)].CellValue(arrRow[idx],"msg_id")+'&kepFlg=OK&deltFlg=NO');
    			sheetObjects[ComParseInt(sheetNum)].GetSaveXml('MessageGS.do?f_cmd=4&div='+div+'&rcvDt=NO&msgId='+sheetObjects[ComParseInt(sheetNum)].CellValue(arrRow[idx],"msg_id")+'&kepFlg=OK&deltFlg=NO');
    		}else if(flag == "D"){
    			//alert('MessageGS.do?f_cmd=4&div='+div+'&rcvDt=NO&msgId='+sheetObjects[ComParseInt(sheetNum)].CellValue(arrRow[idx],"msg_id")+'&kepFlg=NO&deltFlg=OK');
    			sheetObjects[ComParseInt(sheetNum)].GetSaveXml('MessageGS.do?f_cmd=4&div='+div+'&rcvDt=NO&msgId='+sheetObjects[ComParseInt(sheetNum)].CellValue(arrRow[idx],"msg_id")+'&kepFlg=NO&deltFlg=OK');
    		}
    	}
    	getList();
    }
    
    function contentLen(){
    	if(ComGetLenByByte(document.form.msg_ctnt) < 4001){
    		document.getElementById("ctntCount").innerText = ComGetLenByByte(document.form.msg_ctnt);
    	}else{
    		var temp = document.form.msg_ctnt.value.length;
    		alert('Is more than 4000 bytes..!!');
    		document.form.msg_ctnt.value = document.form.msg_ctnt.value.substring(0,ComParseInt(temp)-1);
    	}
	}
    
    function messageReply() {
    	if ( sheetObjects[0].RowCount == 0 ) return;
    	var selectRow = sheetObjects[0].SelectRow;
    	document.getElementById("rcvr_usr_id").value = sheetObjects[0].CellValue(selectRow, "sndr_usr_id");
    	document.getElementById("rcvr_usr_nm").value = sheetObjects[0].CellValue(selectRow, "sndr_usr_nm");
    	document.getElementById("msg_ctnt").value = "\n\n-----Original Message-----\n"+sheetObjects[0].CellValue(selectRow, "msg_ctnt");
    	tabObjects[0].SelectedIndex = 0;
    }
    
    function messageReplySavedBox() {
    	if ( sheetObjects[2].RowCount == 0 ) return;
    	var selectRow = sheetObjects[2].SelectRow;
    	if ( sheetObjects[2].CellValue(selectRow, "div") == "SND" ) return;
    	document.getElementById("rcvr_usr_id").value = sheetObjects[2].CellValue(selectRow, "usr_id");
    	document.getElementById("rcvr_usr_nm").value = sheetObjects[2].CellValue(selectRow, "usr_nm");
    	document.getElementById("msg_ctnt").value = "\n\n-----Original Message-----\n"+sheetObjects[2].CellValue(selectRow, "msg_ctnt");
    	tabObjects[0].SelectedIndex = 0;
    }
    
    function t2sheet1_OnDblClick(sheetObj, Row,Col){
    	var readtime = sheetObj.CellValue(Row,"rcv_dt");
    	if(readtime == ''){
    		sheetObj.CellValue(Row,"rcv_dt") = ComGetNowInfo("ymd") + " " + ComGetNowInfo("hms");
        	sheetObj.GetSaveXml('MessageGS.do?f_cmd=4&div=RCV&rcvDt=OK&msgId='+sheetObj.CellValue(Row,"msg_id")+'&kepFlg=NO&deltFlg=NO');
    	}
    	document.form.to_ctnt.value = sheetObj.CellValue(Row,"msg_ctnt");
    }
    
    function t3sheet1_OnDblClick(sheetObj, Row,Col){
    	document.form.from_ctnt.value = sheetObj.CellValue(Row,"msg_ctnt");
    }
    
    function t4sheet1_OnDblClick(sheetObj, Row,Col){
    	var readtime = sheetObj.CellValue(Row,"rcv_dt");
    	if(readtime == "" && sheetObj.CellValue(Row,"div") == "RCV"){
    		sheetObj.CellValue(Row,"rcv_dt") = ComGetNowInfo("ymd") + " " + ComGetNowInfo("hms");
    		sheetObj.GetSaveXml('MessageGS.do?f_cmd=4&div=RCV&rcvDt=OK&msgId='+sheetObj.CellValue(Row,"msg_id")+'&kepFlg=NO&deltFlg=NO');
    	}
    	document.form.archive_ctnt.value = sheetObj.CellValue(Row,"msg_ctnt");
    }

    function getPopupData(arrData) {
    	var names = "";
    	var ids = "";
    	for ( var i = 0 ; i < arrData.length ; i++ ) {
    		names += arrData[i][3];
    		ids += arrData[i][6];
    		if ( i != arrData.length-1 ) {names += ","; ids += ",";}
    	}
    	if ( document.getElementById("rcvr_usr_nm").value == "" ) {
	    	document.getElementById("rcvr_usr_nm").value = names;
	    	document.getElementById("rcvr_usr_id").value = ids;
    	} else {
	    	document.getElementById("rcvr_usr_nm").value += ","+names;
	    	document.getElementById("rcvr_usr_id").value += ","+ids;
    	}
    }
