/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0140.js
*@FileTitle : Email(Edit)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2014.08.27 최도순
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
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
     * @class FNS_INV_0140 : FNS_INV_0140 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_INV_0140() {
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
    }

    
     
    function initControl() {
		CKEDITOR.instances.edt_contents.setData("We’ve attached the BLs, so please check and send the remittance by due date");
		CKEDITOR.config.toolbar = [
			["NewPage","Preview","Print","-","Bold","Italic","Underline","Strike","-","TextColor","BGColor","-","Link"],
			"/",
			["Format","Font","FontSize","-","Source"]
	    ];
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
                    var HeadTitle1 = "ibflag|edt_to_eml|edt_cc_eml|edt_from_eml|edt_subject|edt_contents";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus, 90, daLeft, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_to_eml",      false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_cc_eml",      false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_from_eml",    false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_subject",     false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   90, daLeft, false, "edt_contents",    false, "", dfNone, 0, false, false, 0, false, false);
                    CountPosition = 0;
                }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case MULTI : //Email
	    		var win = window.dialogArguments;
	    		sheetObj.DataInsert();
				sheetObj.CellValue2(1,"edt_to_eml") = ComGetObjValue(formObj.edt_to_eml);
				sheetObj.CellValue2(1,"edt_cc_eml") = ComGetObjValue(formObj.edt_cc_eml);
				sheetObj.CellValue2(1,"edt_from_eml") = ComGetObjValue(formObj.edt_from_eml);
				sheetObj.CellValue2(1,"edt_subject") = ComGetObjValue(formObj.edt_subject);
				sheetObj.CellValue2(1,"edt_contents") = CKEDITOR.instances.edt_contents.getData();
				//ComSetObjValue(win.document.form.elements["edt_bkg_no_list"],sheetObj.CellValue(1,"edt_bkg_no_list"));
				ComSetObjValue(win.document.form.elements["edt_to_eml"     ],sheetObj.CellValue(1,"edt_to_eml"     ));
				ComSetObjValue(win.document.form.elements["edt_cc_eml"     ],sheetObj.CellValue(1,"edt_cc_eml"     ));
				ComSetObjValue(win.document.form.elements["edt_from_eml"   ],sheetObj.CellValue(1,"edt_from_eml"   ));
				ComSetObjValue(win.document.form.elements["edt_subject"    ],sheetObj.CellValue(1,"edt_subject"    ));
				ComSetObjValue(win.document.form.elements["edt_contents"   ],sheetObj.CellValue(1,"edt_contents"   ));
				
				var arrRow = ComFindText(win.sheetObjects[0],"chk", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						win.sheetObjects[0].CellValue2(arrRow[i],"cust_eml") = sheetObj.CellValue(1,"edt_to_eml");
					}
					win.sendFaxEml(win.sheetObjects[0],'E');
					
					this.close();
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
    			if (ComIsNull(formObj.edt_to_eml)) {
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
 	
 	 function ComFindText(sheetObj, colName, colValue){
         //함수 인자 유효성 확인
         if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT")
           return alert("ComFindText 함수의 sheetObj 인자는 IBSheet가 아닙니다.");

         var idxs = new Array();
         for(yn=sheetObj.HeaderRows ;yn<=sheetObj.LastRow ;yn++ ) {
           if(sheetObj.RowStatus(yn) != 'D' && sheetObj.CellValue(yn, colName) == colValue){
             idxs.push(''+yn);
           }
         }
         return idxs;
       }

 	
 	 