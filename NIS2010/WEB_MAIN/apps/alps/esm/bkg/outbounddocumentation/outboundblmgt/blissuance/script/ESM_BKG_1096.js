/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1096.js
*@FileTitle : Email(Edit)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : Ilmin Lee
*@LastVersion : 1.0
* 2010.05.26 Ilmin Lee
* 1.0 Creation
* History
===============================================================================
2011.03.31 조원주 [CHM-201109864] Customer E-Mail Address 입력 column 추가
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
     * @class esm_bkg_1096 : esm_bkg_1096 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1096() {
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
 var userFileCnt=0; //사용자 파일 Cnt
 var userAllFileAttachSize=0 //사용자 첨부 파일 총 크기.
 var uploadObjects = new Array(); 
 var uploadCnt=0;

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
                case "btn_Send":
    				if(!validateForm(sheetObject,formObject,MULTI)) {
    					return false;
    				}
                    doActionIBSheet(sheetObject,formObject,MULTI);
                    break;
                case "btn_Attach":
    				addFile();
    				break;
    				
                case "btn_Close":
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
      * It sets a Upload Object.
      * @param uploadObj
      * @return
      */
     function setUploadObject(uploadObj){
     	uploadObjects[uploadCnt++] = uploadObj;
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
        
    	for(var i=0;i<uploadObjects.length;i++){
    		popupConfigUpload(uploadObjects[i],"/hanjin/ESM_BKG_1096GS.do");
    	}	
    	
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

     /**
      * It configures a popup Upload.
      * @param uploadObj
      * @param sPageUrl
      * @return
      */
     function popupConfigUpload(uploadObj, sPageUrl){	
         try {
         	ComConfigUpload(uploadObj, sPageUrl);
     		uploadObj.SetLimit(100, 5000, 5000);
         } catch(err) { ComFuncErrMsg(err.message); }
     }
     
    function initControl() {
	   	if (document.getElementById("ui_id").value == "ESM_BKG_0079_02C") {
	   		document.form.email.value = opener.document.form.eml.value;
	   		ComBtnDisable("btn_ok");
		}
    }

    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet_search
                cnt = 0;
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 0;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
                    var HeadTitle1 = "ibflag|edt_bkg_no_list|edt_ntc_knd_cd|edt_to_eml|edt_cc_eml|edt_from_eml|edt_subject|edt_contents|fntRcvEml|com_fileKey";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus, 90, daLeft, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_bkg_no_list", false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_ntc_knd_cd",  false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_to_eml",      false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_cc_eml",      false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_from_eml",    false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_subject",     false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_contents",    false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "fnt_rcv_eml",    false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "com_fileKey",    false, "", dfNone, 0, false, false, 0, false, false);
                    CountPosition = 0;
                }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH : //조회
	        	formObj.f_cmd.value = SEARCH;
	            var sXml = sheetObj.GetSearchXml("ESM_BKG_1096GS.do", FormQueryString(formObj));
	       		sheetObj.LoadSearchXml(sXml);
	       		options.innerHTML = sheetObj.CellValue(1,"fnt_rcv_eml");
            break;

        	case MULTI : //Email
	    		var ui_id = ComGetObjValue(formObj.ui_id);
	    		var win = window.dialogArguments;
				sheetObj.CellValue2(1,"edt_to_eml") = ComGetObjValue(formObj.edt_to_eml);
				sheetObj.CellValue2(1,"edt_cc_eml") = ComGetObjValue(formObj.edt_cc_eml);
				sheetObj.CellValue2(1,"edt_from_eml") = ComGetObjValue(formObj.edt_from_eml);
				sheetObj.CellValue2(1,"edt_subject") = ComGetObjValue(formObj.edt_subject);
				sheetObj.CellValue2(1,"edt_contents") = CKEDITOR.instances.edt_contents.getData();
				ComSetObjValue(win.document.form.elements["edt_ntc_knd_cd" ],sheetObj.CellValue(1,"edt_ntc_knd_cd" ));
				ComSetObjValue(win.document.form.elements["edt_bkg_no_list"],sheetObj.CellValue(1,"edt_bkg_no_list"));
				ComSetObjValue(win.document.form.elements["edt_to_eml"     ],sheetObj.CellValue(1,"edt_to_eml"     ));
				ComSetObjValue(win.document.form.elements["edt_cc_eml"     ],sheetObj.CellValue(1,"edt_cc_eml"     ));
				ComSetObjValue(win.document.form.elements["edt_from_eml"   ],sheetObj.CellValue(1,"edt_from_eml"   ));
				ComSetObjValue(win.document.form.elements["edt_subject"    ],sheetObj.CellValue(1,"edt_subject"    ));
				ComSetObjValue(win.document.form.elements["edt_contents"   ],sheetObj.CellValue(1,"edt_contents"   ));
				//Fax/EDI
				if ("ESM_BKG_0095"==ui_id) {
					setPreFileInfoThatWillAttachMail();
					var upObj = uploadObjects[0];
					formObj.f_cmd.value = SEARCH01;
					if(upObj.FileCount != 0){
							doActionUpload();
					}
					ComSetObjValue(win.document.form.elements["com_fileKey" ],sheetObj.CellValue(1,"com_fileKey" ));
					var arrRow = ComFindText(win.sheetObjects[0], "slct_flg", 1);
					if (arrRow && 1==arrRow.length) {
						win.sheetObjects[0].CellValue2(arrRow[0],"eml") = sheetObj.CellValue(1,"edt_to_eml");
						if(!win.validateForm(win.sheetObjects[0],win.document.form,"btn_Email")) return false;
						win.doActionIBSheet(win.sheetObjects[0],win.document.form,"btn_Email");
					}
					
				//Booking Receipt Notice (Fax/Email)
				} else if ("ESM_BKG_0098"==ui_id) {
					setPreFileInfoThatWillAttachMail();
					var upObj = uploadObjects[0];
					formObj.f_cmd.value = SEARCH01;
					if(upObj.FileCount != 0){
							doActionUpload();
					}
					ComSetObjValue(win.document.form.elements["com_fileKey" ],sheetObj.CellValue(1,"com_fileKey" ));
					var arrRow = ComFindText(win.sheetObjects[0], "slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							win.sheetObjects[0].CellValue2(arrRow[i],"eml") = sheetObj.CellValue(1,"edt_to_eml");
						}
						if(!win.validateForm(win.sheetObjects[0],win.document.form,"btn_GroupEmail")) return false;
						win.doActionIBSheet(win.sheetObjects[0],win.document.form,"btn_GroupEmail");
					}
				//Draft B/L & Waybill (Fax/E-Mail) - Outbound
				} else if ("ESM_BKG_0218_01"==ui_id) {
					var arrRow = ComFindText(win.sheetObjects[0],win.sheetObjects[0].id+"slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							win.sheetObjects[0].CellValue2(arrRow[i],win.sheetObjects[0].id+"eml") = sheetObj.CellValue(1,"edt_to_eml");
						}
						if(!win.validateForm(win.sheetObjects[0],win.document.form,"btn_groupemail_t1sht1")) return false;
						win.doActionIBSheet(win.sheetObjects[0],win.document.form,"btn_groupemail_t1sht1");
					}
				//Draft B/L & Waybill (Fax/E-Mail) - Inbound
				} else if ("ESM_BKG_0218_02"==ui_id) {
					var arrRow = ComFindText(win.sheetObjects[1],win.sheetObjects[1].id+"slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							win.sheetObjects[1].CellValue2(arrRow[i],win.sheetObjects[1].id+"eml") = sheetObj.CellValue(1,"edt_to_eml");
						}
						if(!win.validateForm(win.sheetObjects[1],win.document.form,"btn_groupemail_t2sht1")) return false;
						win.doActionIBSheet(win.sheetObjects[1],win.document.form,"btn_groupemail_t2sht1");
					}
				} else if ("ESM_BKG_0252"==ui_id) {
					var arrRow = ComFindText(win.sheetObjects[0], "Check", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							win.sheetObjects[0].CellValue2(arrRow[i],"ntc_eml") = sheetObj.CellValue(1,"edt_to_eml");
						}
						win.makeRdParam(win.rdObjects[0],win.document.form,win.sheetObjects[0]);
						win.doActionIBSheet(win.sheetObjects[0],win.document.form,"EMAIL");
					}
				} else if ("ESM_BKG_0381"==ui_id) {
					window.close();
					win.doActionIBSheet(win.sheetObjects[0],win.document.form,"btn_email_edit");
				}
				
            break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
    		case MULTI:
    			//@ A/N 에서 호출 할때는 체크하지 않는다.
    			if (ComGetObjValue(formObj.ui_id) != "ESM_BKG_0381" && ComIsNull(formObj.edt_to_eml)) {
                    ComShowCodeMessage("BKG00245");  //E-mail is invalid {?msg1}. Please check it again.
                    formObj.edt_to_eml.select();
                    return false;
    			}
    		break;
    	}
        return true;
    }

 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			if (2==Rows) {
				/*CKEDITOR toolbar
				['Source','-','Save','NewPage','Preview','-','Templates'],
		        ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
		        ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
		        ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
		        '/',
		        ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
		        ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote','CreateDiv'],
		        ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
		        ['Link','Unlink','Anchor'],
		        ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
		        '/',
		        ['Styles','Format','Font','FontSize'],
		        ['TextColor','BGColor'],
		        ['Maximize', 'ShowBlocks','-','About']*/
				var formObj = document.form;
				ComSetObjValue(formObj.edt_to_eml,CellValue(1,"edt_to_eml"));
				ComSetObjValue(formObj.edt_cc_eml,CellValue(1,"edt_cc_eml"));
				ComSetObjValue(formObj.edt_from_eml,CellValue(1,"edt_from_eml"));
				ComSetObjValue(formObj.edt_subject,CellValue(1,"edt_subject"));
				setTimeout(function(){CKEDITOR.instances.edt_contents.setData(CellValue(1,"edt_contents"));},10);
				
				CKEDITOR.config.toolbar = [
					["NewPage","Preview","Print","-","Bold","Italic","Underline","Strike","-","TextColor","BGColor","-","Link"],
					"/",
					["Format","Font","FontSize","-","Source"]
			    ];
			}
		}
	}

 	 //업로드 Object 에 파일을 첨부한다.
 	function addFile(){
 		var upObj = uploadObjects[0];
 		var fileLocation = upObj.AddFile();
 		var fileSize = upObj.GetFileSize(fileLocation);

 		//파일 중복 업로드 체크
 		for(var i=0;i<userFileCnt;i++){
 			var userFileLoc = document.getElementById("userFileFullLocation"+i).value;
 			if(fileLocation == userFileLoc){
 				return;
 			}
 		}
 	
 		//파일 선택 안했을 경우 체크
 		if(fileLocation == "" || fileLocation == " "){
 			return
 		}
 	
 		//파일하나의 사이즈 제한.
 		if(fileSize > 5000000){		
 			alert("File isn't over the size of 5MB ["+fileSize+"]");
 			return;
 		}
 	
 		userAllFileAttachSize = userAllFileAttachSize+fileSize;
 		
 		//총 파일의 사이즈 제한.
 		if(userAllFileAttachSize > 5000000){
 			alert("Sum of Attached File isn't over the size of 5MB ["+userAllFileAttachSize+"]");
 			userAllFileAttachSize = userAllFileAttachSize-userAllFileAttachSize;
 			return;
 		}
 
 		var arrFileLoction = fileLocation.lastIndexOf("\\");
 		var fileName = fileLocation.substring(arrFileLoction+1);
 		var userFileDelButton = document.createElement("<input type=\"button\" name=\"userFileDelButton"+userFileCnt+"\" value=\"Del\" onclick=deleteUserAttachFile("+userFileCnt+")>"); 
 		document.getElementById("userAttachFile").insertBefore(userFileDelButton);
 		var fileButton = document.createElement("<input type=\"button\" name=\"userFileButton"+userFileCnt+"\" value=\""+fileName+"\" >"); 
 		document.getElementById("userAttachFile").insertBefore(fileButton);
 		var fileFullLocation = document.createElement("<input type=\"hidden\" name=\"userFileFullLocation"+userFileCnt+"\" value=\""+fileLocation+"\" >"); 
 		document.getElementById("userAttachFile").insertBefore(fileFullLocation);
 	
 		userFileCnt = userFileCnt+1;
 	}
 	
 	
 	//선택한 사용자 첨부 파일을 삭제한다.
 	function deleteUserAttachFile(idx){
 		
 		var parentNode = document.getElementById("userAttachFile");
 		var toRemoveFileButton = document.getElementById("userFileButton"+idx);
 		var toRemoveDelButton = document.getElementById("userFileDelButton"+idx);
 		var toRemoveFileFullLocation = document.getElementById("userFileFullLocation"+idx).value;
 		parentNode.removeChild(toRemoveFileButton);
 		parentNode.removeChild(toRemoveDelButton);
 		
 		var upObj = uploadObjects[0];
 		upObj.DeleteFile(toRemoveFileFullLocation);
 		var toRemoveFileSize = upObj.GetFileSize(toRemoveFileFullLocation);
 		userAllFileAttachSize = userAllFileAttachSize-toRemoveFileSize;
 	}
 	
 	/**
 	 * Delete a pre user File Object.
 	 * @param idx
 	 * @return
 	 */
 	function deletePreFileInfo(idx){
 		var parentNode = document.getElementById("userAttachFile");
 		var toRemoveInfoDelButton = document.getElementById("fileInfoDelButton"+idx);
 		var toRemoveInfoButton = document.getElementById("fileInfo"+idx);
 		var toRemoveInfoObject = document.getElementById("fileInfoObj"+idx);
 		parentNode.removeChild(toRemoveInfoDelButton);
 		parentNode.removeChild(toRemoveInfoButton);
 		parentNode.removeChild(toRemoveInfoObject);	
 		var preFileForLoop = document.getElementById("com_PreFileForLoop").value;
 		var toDeleteIndex = preFileForLoop.indexOf(idx)
 		document.getElementById("com_PreFileForLoop").value =preFileForLoop.substring(0,toDeleteIndex)+preFileForLoop.substring(toDeleteIndex+2);
 	}
 	
 	//프로그램에서 미리 정의한 사용자 첨부 파일을 메일에 첨부한다.
 	function setPreFileInfoThatWillAttachMail(){
 		var preFileForLoop = document.getElementById("com_PreFileForLoop").value;
 		if(preFileForLoop == "" || preFileForLoop == " "){
 			return;
 		}
 		preFileForLoop = preFileForLoop.substring(0, preFileForLoop.length-1);
 		var arrayFileLoop = preFileForLoop.split(";");
 		var preFullFileKeys = "";
 		for(var i=0;i < arrayFileLoop.length;i++){
 			var preFileIndex = arrayFileLoop[i];
 			var preFileKey = document.getElementById("fileInfoObj"+preFileIndex).value;
 			preFullFileKeys = preFullFileKeys + preFileKey;
 			preFullFileKeys = preFullFileKeys + ";";		
 		}
 		document.getElementById("com_fileKey").value = preFullFileKeys;
 	}
 	
 	
 	/**
 	 * It uploads a file.
 	 * @param sAction
 	 * @return
 	 */
 	function doActionUpload(){
 		var upObj = uploadObjects[0];
 		upObj.ParamDecoding = true;
 		upObj.ParamUTF8 = true;
 		upObj.ExtendParam =  FormQueryStringEnc(document.form,upObj);
		var sXml = upObj.DoUpload(true);
		if (sXml.length > 0){
			var etcValue = ComGetEtcData(sXml, "fileKey");
			sheetObjects[0].CellValue(1,"com_fileKey") = etcValue;
			
		}
 	}
 	 