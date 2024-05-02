/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0079.js
*@FileTitle : E-mail / Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.29 정윤태
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
     * @class E-mail / Print : E-mail / Print 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0079() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnChangeSum	    = sheet1_OnChangeSum;
    	this.setUploadObject		= setUploadObject;
    	this.setEmail				= setEmail;
    	this.contentLen				= contentLen;
    	this.rowRemove				= rowRemove;
    	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
    	this.setFileUpload			= setFileUpload;
    	this.initEditor				= initEditor;
    	this.chBlockStyle			= chBlockStyle;
    	this.chFontColor			= chFontColor;
    	this.chSelectionCommand		= chSelectionCommand;
    	this.strReplace				= strReplace;
    }

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var uploadObjects = new Array();
	var uploadCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
				case "btn_rowAdd":
					var row = sheetObject.DataInsert(-1);
	
	                break;
	                
				case "btn_rowDel":
					if(checkBoxCheckYn(sheetObject, "DelChk")) {
	            		rowRemove(sheetObject, "");
	            	}
					break;

                case "btn_new":
                		formObject.recipient.value = "";
                		TextEditor.document.body.innerHTML = "";
                		formObject.content.value = "";
                		formObject.subject.value = formObject.title.value;
                		document.getElementById("ctntCount").innerText = 0;
                		
                		ComResetAll();
                		
                		formObject.all.font_style.disabled = false;
                		formObject.all.font_size.disabled = false;
                		formObject.all.font_color.disabled = false;
                		formObject.all.font_etc.disabled = false;
                		
                		document.all.i_edit.style.display = "";
                		document.all.i_text.style.display = "none";
                		
                		formObject.email_mode.selectedIndex = 0;
                		
                		ComBtnEnable("btn_E-mail");
                		
                    break;

                case "btn_E-mail":
                	doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

                case "btn_close":
                	window.close();
                    break;
                    
                case "btn_email":
                	ComOpenPopup("ESM_FMS_0084.do", 550, 385, "setEmail", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0084");
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
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            
            sheetObjects[i].ExtendLastCol = false;
        }
        
        //UPLOAD 환경 설정
        for(var i=0;i<uploadObjects.length;i++){
		    //1. 기본 환경 설정
		    ComConfigUpload(uploadObjects[i], "/hanjin/ESM_FMS_0079GS.do");
		}
        
        TextEditor.document.designMode = "On";
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;
    	 
        switch(sheetObj.id) {
            case "sheet1":      //t1sheet1 init
                with(sheetObj) {
            	
            	//var prefix = "cef_";
            	
                // 높이 설정
                style.height = 100;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(4, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)
                
                var HeadTitle = "|Sel|File Upload|File Path";

                //var HeadTitle = "|Sel|Certi File Upload|From|To|Contents|File Path|File Chtr Tp Cd|File Seq|File Download|File Sav Id ";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,  true,	"ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,   40,    	daCenter,  false,   "DelChk");
				InitDataProperty(0, cnt++ , dtPopup,      	319,    daLeft,    false,   "file_nm",     	true,           "",      dfNone,      0,     false,		true,	50);
                InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   "file_path",   	false,          "",      dfNone,      0,     true,      true);
                
                DataLinkMouse("file_nm") = true;
                
                ImageList(0)= "/hanjin/img/ico_attach.gif";

				ShowButtonImage = 1;
				
                	
            		/*
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    */
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
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					/*
					if(!ComIsEmailAddr(formObj.recipient)) {
						formObj.recipient.value = "";
						ComAlertFocus(form.recipient, ComGetMsg('FMS01147'));
						return;
					}
					*/
					
					//자동 메일 설정(로그인한 사람에게 메일을 자동으로 보낸다
					//form.recipient.value = form.recipient.value + ";" + form.from.value;
					//SELCTF 이경민과장님 요청으로 개인 메일로 전송되지 않게 수정 2018.02.14
					form.recipient.value = form.recipient.value;
					
					if(formObj.email_mode.value == "E") {
						//불필요한 HTML 테크 삭제
						var content = TextEditor.document.body.innerHTML;
						
						formObj.content.value = strReplace(strReplace(content, "<P>", ""),"</P>","");
	
						if(formObj.content.value == "" 
						   || formObj.content.value=="<P>&nbsp;</P>"
						   || formObj.content.value=="&nbsp;") {
							formObj.content.value = formObj.msg_ctnt.value;
							formObj.contentYn.value = "N";
						} else {
							contentLen();
						}
					} else {
						if(formObj.content.value == "") {
						    formObj.content.value = formObj.msg_ctnt.value;
							formObj.contentYn.value = "N";
						}
					}

        			formObj.f_cmd.value = MULTI;
 
        			//1.IBUpload에 파일 추가하기
     			   	var upObj = uploadObjects[0];
     	
     			   	upObj.Files="";	//-먼저기존파일을 모두 지운후 추가함

     			   	var paramFile = setFileUpload(sheetObjects[0]);
        			
        			ComBtnDisable("btn_E-mail");
        			
        			//첨부파일이 없는 경우
        			if (upObj.LocalFiles == "") {
        			
        				sheetObj.DoSearch("ESM_FMS_0079GS.do", FormQueryString(formObj));
        			
        			//첨부 파일이 있는 경우
        			} else {
        				
        				ComOpenWait(true);
        				
        				//2.IBSheet 데이터 QueryString으로 묶기
    					var arrSheets = new Array(sheetObjects[0]);
    					var sParam = ComGetSaveString(arrSheets, true);
    					if (sParam == "") return;
    					
    					//3.Form 데이터 QueryString으로 묶기				
    					var aryPrefix = new Array("");				
    					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
    					sParam += "&" + paramFile;
    					
    					//4. 서버에 request전달하고, reponse 받기
    					upObj.ExtendParam = sParam;
    					
    					upObj.ParamDecoding = true;

    					var sXml = upObj.DoUpload(true);
    					
    					var arrXml = sXml.split("|$$|");
    					
    					sheetObj.LoadSearchXml(arrXml[0]);
    					
    					ComOpenWait(false);
        				
        			}
        			
        			if(formObj.contentYn.value == "N") {
        				formObj.content.value = "";
        				formObj.contentYn.value = "";
        			}
        			
        			//ComBtnEnable("btn_E-mail");
        		}
                break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction){
    	if(form.recipient.value == "") {
    		ComAlertFocus(form.recipient, ComGetMsg('FMS01146'));
    		return false;
    	}
    	
    	if(form.subject.value == "") {
    		ComAlertFocus(form.subject, ComGetMsg('FMS01191'));
    		return false;
    	}

        return true;
    }
    
    /**
     * E-mail List Select 팝업창에서 선택한 이메일을 설정한다.<br>
     * @param aryPopupData
     */
    function setEmail(aryPopupData) {
    	//email 값 초기화
    	form.recipient.value = "";
    	
    	var recipient = "";
    	
    	var idx = 0;
    	var chkCnt = aryPopupData.length;
    	
        for(var i=0; i<aryPopupData.length; i++) {
        	idx++;
        	
 		    var emailData = aryPopupData[i];
 		    
 		    if(chkCnt == 1) {
 		    	recipient = emailData.cntc_pson_eml;
 		    } else {
 		    	if(chkCnt == idx) {
 		    		recipient += emailData.cntc_pson_eml;
 		    	} else {
 		    		recipient += emailData.cntc_pson_eml+";";
 		    	}
 		    }
    	}
        
        form.recipient.value = recipient;
    	 
    	//form.recipient.value = aryPopupData[0][4];
    }
    
    /**
     * E-mail 내용의 자리수를 제한한다.<br>
     * @param {form}	formObj		Form Object(내용)
     */
    function contentLen(){
    	if(ComGetLenByByte(document.form.content) < 10001){
    		document.getElementById("ctntCount").innerText = ComGetLenByByte(document.form.content);
    	}else{
    		var temp = document.form.content.value.length;
    		ComShowCodeMessage('FMS01190');
    		document.form.content.value = document.form.content.value.substring(0,ComParseInt(temp)-1);
    	}
	} 
    
    /**
     * row 삭제하기. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     **/
	function rowRemove(sheetObj, prefix) {
		var sRow = sheetObj.FindCheckedRow(prefix + "DelChk");
		if (sRow == "") return;
		
		//가져온 행을 배열로 반든다.
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		for (var idx=arrRow.length-2; idx>=0; idx--){
			var row = arrRow[idx];
			
			sheetObj.RowHidden(row)= true;
			sheetObj.RowStatus(row)= "D";
		}
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		var fileName = sheetObj.OpenFileDialog(ComGetMsg('FMS01074'));
		
		if(fileName.indexOf("\\") !=-1) {
			sheetObj.CellValue2(Row, "file_path")= fileName;

			fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
			sheetObj.CellValue2(Row, Col)= fileName;
		}
	}

    /**
     * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	변수 구분값
     **/
	function setFileUpload(sheetObj) {
		//트랜잭션 상태가 "입력"인 행을 찾아 온다.
		var sRow = sheetObj.FindStatusRow("I");
		var upObj = uploadObjects[0];
		var arrRow = sRow.split(";");
		
		for (idx=0; idx<arrRow.length-1; idx++){ 
			var row = arrRow[idx];
			
			//파일 경로 가져오기
			var sFile = sheetObj.CellValue(row,"file_path");		
			if (sFile=="") ComShowMessage(ComGetMsg('FMS01075'));
			
			//IBUpload에 파일 추가하기
			var ret = upObj.AddFile(sFile);
		}
		
		var param = "file_cnt=" + (arrRow.length-1); 

		return param; 
	}

    /**
     * Page loading 후 Iframe 세팅 <br>
     **/
    function initEditor() {
    	TextEditor.document.body.style.padding = "1px";
    	TextEditor.document.body.style.font = "9pt 굴림";
        TextEditor.document.body.style.fontSize = "12px";
        TextEditor.document.body.style.lineHeight = "0px";
        TextEditor.document.body.style.padding = "10px 10px 10px 0px";
    }
    
    /**
     * 입력된 내용의 글꼴/크기를 변경한다 <br>
     * @param {String} 	param 	선택된 값
     * @param {String} 	cmd 	글꼴/크기 구분값
     **/
    function chBlockStyle(param, cmd) {
    	var ed=TextEditor.document.selection.createRange();
    	ed.execCommand(cmd, false, param);
    }
    
    /**
     * 입력된 내용의 색깔을 변경한다 <br>
     * @param {String} 	param 	선택된 값
     * @param {String} 	cmd 	글꼴 구분값
     **/
    function chFontColor(param,cmd){
    	var ed
    	ed = TextEditor.document.selection.createRange();
    	ed.execCommand(cmd, false, param);
    }
    
    /**
     * 입력된 내용을 기타 옵션에 맞게 변경한다 <br>
     * @param {String} 	Btn 	form Object
     * @param {String} 	cmd 	기타 옵션 구분값
     **/
    function chSelectionCommand(Btn, cmd) {
    	TextEditor.focus();
    	var EdRange=TextEditor.document.selection.createRange();
    	EdRange.execCommand(cmd);
    }

    /**
     * 입력된 내용을 기타 옵션에 맞게 변경한다 <br>
     * @param {String} 	Btn 	form Object
     * @param {String} 	cmd 	기타 옵션 구분값
     **/
    function chMode(val) {
    	if(val == "E") {
    		document.all.font_style.disabled = false;
    		document.all.font_size.disabled = false;
    		document.all.font_color.disabled = false;
    		document.all.font_etc.disabled = false;
    		
    		document.all.i_edit.style.display = "";
    		document.all.i_text.style.display = "none";
    		
    		//TextEditor.document.body.innerHTML = document.form.content.value;
    		document.form.content.value = "";
    		TextEditor.focus();
    	} else {
    		document.all.font_style.disabled = true;
    		document.all.font_size.disabled = true;
    		document.all.font_color.disabled = true;
    		document.all.font_etc.disabled = true;
    		
    		document.all.i_edit.style.display = "none";
    		document.all.i_text.style.display = "";
    		
    		//document.form.content.value = TextEditor.document.body.innerHTML;
    		TextEditor.document.body.innerHTML = "";
    		document.form.content.focus();
    	}
    }

    /**
     * 입력된 내용을 기타 옵션에 맞게 변경한다 <br>
     * @param {String} 	strOriginal 	내용
     * @param {String} 	strFind 		찾을 문자
     * @param {String} 	strChange 		변경할 문자
     **/
    function strReplace(strOriginal, strFind, strChange){ 
        var position; 
        position = strOriginal.indexOf(strFind);  

        while (position != -1){ 
          strOriginal = strOriginal.replace(strFind, strChange); 
          position = strOriginal.indexOf(strFind); 
        } 
        
        return strOriginal;
    } 
    
    //붙여넣기의 경우 줄간격 조정 2017.05.25
    function chLineHeight() {
    	var str = window.clipboardData.getData('Text');
    
    	str = str.replace(/\r\n/g,"\r\n\r\n");
    	
    	window.clipboardData.setData('Text', str);
    }