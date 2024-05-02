
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

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
            
                case "btn_close":
					window.close();
                    break; 
                case "btn_ok":
                	if(validation()==true){
                		if(confirm('Do you want to save?')){
                			var callFunc = formObject.callFunc.value;
                			var valChk = true;
                			sheetObject.CellValue2(1, "etc_rmk") = formObject.valRmk.value;
                			
                			doActionIBSheet(sheetObject, formObject, IBSAVE);
                			
                			if(callFunc != ''){
                				// ESD_PRD_0080화면을 다시 호출
                				eval('window.dialogArguments.'+callFunc)(valChk);   
                				
                				window.close();
                			}
                		}
                	}
                	break; 
                case "valChkRadio":
                	showRmk();
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
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        var formObj = document.form;

		for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		sheetObjects[0].DataInsert(-1);
		sheetObjects[0].CellValue2(1, "pctl_no") = formObj.pctl_no.value;
		sheetObjects[0].CellValue2(1, "rout_val_chk_cd") = formObj.valChkRadio[0].value;
		ComEnableObject(document.getElementById("valRmk1"), true);
		ComEnableObject(document.getElementById("valRmk2"), false);
		ComEnableObject(document.getElementById("valRmk3"), false);
		ComEnableObject(document.getElementById("valRmk4"), false);
     }

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {
             case "sheet1":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
 					style.height = 0;

 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;

 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(1, 1, 20, 100);

 					var HeadTitle1 = "|pctl_no|rout_val_chk_cd|etc_rmk";
 					var headCount = ComCountHeadTitle(HeadTitle1);
 										
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, true, true, false,false);

 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle1, true);
                    
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
 					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"pctl_no",			false,      "",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"rout_val_chk_cd",	false,      "",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"etc_rmk",			false,		"",				dfNone,		0,			true,		true);
 					
 					WaitImageVisible=false;
                }
             break;
 			
         }
     }

 	// Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 		    case IBSAVE: //저장
 		    	ComOpenWait(true);
 		    	formObj.f_cmd.value = ADD;
//	 		    sheetObj.RowStatus(1) = "I";
 		     	var SaveStr = ComGetSaveString(sheetObj);
 		     	var sXml = sheetObj.GetSaveXml("ESD_PRD_0083GS.do", SaveStr + "&" + PrdFQString(formObj));
// 		     	sheetObj.LoadSaveXml(sXml);
// 		     	sheetObj.DoSave("ESD_PRD_0083.do", PrdFQString(formObj));
 		     	ComOpenWait(false);
 	        break;
 	         
         }
     }     
     
     
     /**
      * Radio 버튼 중 Remark textbox 활성화 해야할 경우 처리해준다
      */     
    function showRmk() {
    	var formObj = document.form;
    	var len = formObj.valChkRadio.length;
    	ComEnableObject(formObj.valRmk1, false);
    	ComEnableObject(formObj.valRmk2, false);
    	ComEnableObject(formObj.valRmk3, false);
    	ComEnableObject(formObj.valRmk4, false);
 
    	for(i=0;i<len;i++){
    		if(formObj.valChkRadio[i].checked==true){
    			sheetObjects[0].CellValue2(1, "rout_val_chk_cd") = formObj.valChkRadio[i].value;
    		}
    	}
    	
    	if(formObj.valChkRadio[0].checked==true){
    		ComEnableObject(formObj.valRmk1, true);
    		formObj.valRmk1.className = "input";    //흰색바탕 _ ComEnableObject() 의 예외사항 처리
    	} else if(formObj.valChkRadio[1].checked==true){
    		ComEnableObject(formObj.valRmk2, true);
    		formObj.valRmk2.className = "input";    //흰색바탕
    	} else if(formObj.valChkRadio[2].checked==true){
    		ComEnableObject(formObj.valRmk3, true);
    		formObj.valRmk3.className = "input";    //흰색바탕
    	} else if(formObj.valChkRadio[6].checked==true){
    		ComEnableObject(formObj.valRmk4, true);
    		formObj.valRmk4.className = "input";    //흰색바탕
    	}
       	formObj.valRmk1.value="";
    	formObj.valRmk2.value="";
    	formObj.valRmk3.value="";
    	formObj.valRmk4.value="";
    	
    }

      /**
       * Remark textbox 의 값입력 체크
       */           
    function validation() {
    	var formObj = document.form;
    	formObj.valRmk.value="";
    	
    	if(formObj.valChkRadio[0].checked==true){
    		if(formObj.valRmk1.value==""){
    			alert("Please surely make a comment for using of the route.");
    			return false;
    		} else {
    			formObj.valRmk.value=formObj.valRmk1.value;
    		}
    	} else if(formObj.valChkRadio[1].checked==true){
    		if(formObj.valRmk2.value==""){
    			alert("Please surely make a comment for using of the route.");
    			return false;
    		} else {
    			formObj.valRmk.value=formObj.valRmk2.value;
    		}
    	} else if(formObj.valChkRadio[2].checked==true){
    		if(formObj.valRmk3.value==""){
    			alert("Please surely make a comment for using of the route.");
    			return false;
    		} else {
    			formObj.valRmk.value=formObj.valRmk3.value;
    		}
    	} else if(formObj.valChkRadio[6].checked==true){
    		if(formObj.valRmk4.value==""){
    			alert("Please surely make a comment for using of the route.");
    			return false;
    		} else {
    			formObj.valRmk.value=formObj.valRmk4.value;
    		}
    	}
    	return true;
    }
      
