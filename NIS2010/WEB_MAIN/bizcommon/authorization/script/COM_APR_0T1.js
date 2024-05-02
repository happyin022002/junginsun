/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COM_APR_0T1.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : SSY
*@LastVersion : 1.0
* 2015.07.09 심성윤
* 1.0 최초 생성
* 2015.07.09 심성윤 최초 생성
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
     * @class Error Message Management : Error Message Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function errormessagemanagement() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

  	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var IBSAVE02    = 32;//명단 로드
	var closeChk = false;
	var chkSelfApro = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            	case "btn_Search":
            		if ( document.getElementById("search_text").value == "" ) return;	
            		findXML(document.getElementById("search").value, document.getElementById("search_text").value);
            		break;
            		
            	
                    
//            	case "btn_save":
//        	        if(formObject.sub_sys_cd.value == "") {
//        	        	ComShowCodeMessage("COM12113", "Module");
//        	        	return;
//        	        }
//        	        doActionIBSheet(sheetObject2, formObject, IBSAVE);
//        	        break;
        	       
            	case "btns_add":
            		var selrow = sheetObjects[0].SelectRow;
                    if ( selrow > 0 ){
                    	sheet1_OnDblClick("", "", "", "");
            		}     	        
            		break;

         	    case "btns_del":
         	    	var selrow = sheetObjects[1].SelectRow;
                    if ( selrow > 0 ){
                    	sheet2_OnDblClick("", "", "", "");
            		}    
         	    	break;
         	    	
         	   case "btns_up":
        	    	var selrow = sheetObjects[1].SelectRow;
        	    	 if ( selrow > 0 ){
        	    		 changeUpApproval();
        	    	 }
        	    	break;
        	    	
         	   case "btns_down":
       	    	 	var selrow = sheetObjects[1].SelectRow;
	       	    	 if ( selrow > 0 ){
	    	    		 changeDownApproval();
	    	    	 }
       	    	 	break;
         	    	
//        	    case "btn_confirm":
//        	        doActionIBSheet(sheetObject2, formObject, IBSAVE);
//        	        break; 	
         	    	
        	    case "btn_ok":
        	    	closeChk = true;
        	    	var rowCount = sheetObject2.RowCount;
        	    	if(rowCount ==1){
        	    		validSelfApproval();
        	    		
        	    	}else{
        	    		returnAuthApprovalRoute();
        	    	}
        	    	
        	        break;
        	        
        	    case "btn_close":
        	    	closeChk = false;
        	    	delRqstNo();        	    	
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
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
    	
        // 기저장된 Approval Route 조회
        var formObject = document.form;
        var mode = formObject.mode.value;
        var sheetObjectUser2 = sheetObjects[1];
        doActionIBSheet(sheetObjectUser2, formObject, IBSEARCH);
        
        //Del버튼 클릭시  GW의 Usr Id와 맵핑 시키기위하여 Usr Id조회
        //EP ID가 Null일 경우 Usr Id조회함.
        formObject.f_cmd.value = SEARCH06;
        
        var sXml = sheetObjectUser2.GetSaveXml("COM_APR_0T1GS2.do",FormQueryString(formObject));
        //alert(sXml);
        if(sXml != ""){
        	formObject.ep_id.value =ComGetEtcData(sXml,"ep_id");
        }        
 	
    }
//    
//    /**
//     * 결재라인에 결재자가 아무도 없을 때 처리 이벤트 <br>
//     * 경고창 출력 후 팝업창 종료 <br>
//     * CHM-201534125 - 심성윤<br>
//     **/
//    function chkDft(){
//    	var formObject = document.form;
//        var apro_step = '';
//        
//  		if(!opener)
//  			opener = window.dialogArguments;
//
//      	apro_step = opener.document.all[formObject.target_obj_nm.value].value;
//
//      	//결재라인이 비어 있을 때
//      	if(apro_step == ''){
//      		alert("There is no approval line.\n"+"Please use IT Support on ALPS to send your request.");
//      		window.close();
//      	}    	
//    }
//    

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
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle = "Name|Dept|Title|" ;
					var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     90,   	daLeft,  	false,    	"NAME",        	false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,   false,    	"TEAMNM",       false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     0,    	daLeft,    	false,    	"BUJAE",        false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,   0,    	daCenter,  	false,    	"CN",       	false,          "",       dfNone,     0,     false,       false);
                    
                    CountPosition = 0;
                }
                break;
                
            case "sheet2":     //IBSheet2 init
            	with (sheetObj) {
	                //전체 너비 설정
	                style.height = 322;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle = "|No|Name|Dept|Title|" ;
	               
	                var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
	                //데이터속성    [	ROW, COL,  	DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    	daCenter,  	true,    	"ibflag",           	false,        "",       dfNone,   		0,     false,      false);
	                InitDataProperty(0, cnt++ , dtData,      	30,    	daCenter,  	false, 		"auth_apro_rout_usr_seq",    			false,          "",       dfNone,   	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	90,    daLeft,  	false,   	"auth_apro_usr_nm",      	false,          "",       dfNone,     	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	90,    daCenter,  	false,    	"auth_apro_ofc_cd",      	false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,      	85,    	daLeft,    	false,    	"auth_apro_usr_jb_tit_nm",   false,          "",       dfNone,     0,     false,       false);
	                InitDataProperty(0, cnt++ , dtHidden,     	0,    	daLeft,    	false,    	"auth_apro_usr_id",      	false,          "",       dfNone,     0,     false,       false);
	                
	                CountPosition = 0
	                CellBackColor(0,"name") = RgbColor(222,251,248);
	                CellBackColor(0,"mail") = CellBackColor(0,"name")  ;

	           }
            break;

        }
    }

     /* Sheet관련 프로세스 처리 */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
         
           case IBSAVE02:
	            formObj.f_cmd.value = MULTI01;
            	formObj.frst_apro_usr_id.value = sheetObj.CellValue(sheetObj.RowCount, "auth_apro_usr_id");
            	 
	            var SaveStr = sheetObj.GetSaveString();
	            var sXml = sheetObj.GetSaveXml("COM_APR_0T1GSRoute.do", SaveStr + "&" + FormQueryString(formObj));

	            if ("F"==ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
			    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
			     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
			     		ComShowMessage(rmsg[3]);
			     	} else {
			     		sheetObjects[1].LoadSaveXml(sXml);
					}
				}else{
					 window.close();
				}
  		   break;
         
            case IBSAVE:        //저장
	            // 모두 재입력을 원칙으로 함
	            for(var i=0; i<sheetObj.RowCount; i++) {
	                sheetObj.CellValue2(i + 1, "ibflag") = "I";
	            }
            	
//    			formObj.f_cmd.value = MULTI02;
//    			alert('auth_rqst_knt : ' + document.form.auth_rqst_knt.value + '<<<<<');
    			var auth_rqst_knt = document.form.auth_rqst_knt.value;
    			if (auth_rqst_knt!=null && auth_rqst_knt!=''){
    				if (!isNaN(auth_rqst_knt)){
    					if (Number(auth_rqst_knt) > 1){
            				formObj.f_cmd.value = MULTI02;
    					} else if (Number(auth_rqst_knt) == 1){
    	    				formObj.f_cmd.value = MULTI;
    					} else {
    						ComShowMessage('Approval Request Count should be bigger than 0');
            				return false;	
    					}
    				} else {
        				ComShowMessage(ComGetMsg('COM12122','Approval Request Count')); // msgs['COM12122'] = '{?msg1} can only contain numbers.';
        				return false;
    				}
    			} else {
    				formObj.f_cmd.value = MULTI;
    			}
    			
    			var SaveStr = sheetObj.GetSaveString();
    			var sXml = sheetObj.GetSaveXml("COM_APR_0T1GSRoute.do", SaveStr + "&" + FormQueryString(formObj));
    			
    			sheetObj.LoadSaveXml(sXml);
    			
    			var authAproRqstNo = ComGetEtcData(sXml,"AUTH_APRO_RQST_NO");
//    			alert("length : "+authAproRqstNo.length+"  No. : "+ authAproRqstNo);
    			
    			
    			if(authAproRqstNo == null || authAproRqstNo =="" || authAproRqstNo == undefined || authAproRqstNo.length < 30){
	   				 ComShowMessage("Invalid Request No. : " + authAproRqstNo);
	   				 window.close();
    			}else{
     				opener = window.dialogArguments;        		
                    opener.document.all[formObj.target_obj_nm.value].value = authAproRqstNo;               
                    window.close();
    			}
                
    			
            break;
            
            case IBSEARCH:      //조회
            	formObj.f_cmd.value = SEARCH01;
            	sheetObj.DoSearch("COM_APR_0T1GS2.do", FormQueryString(formObj));
            break;
            
            case IBSEARCH_ASYNC02: //Self-결재 해당 조회
            	formObj.f_cmd.value = SEARCH02;
            	var SaveStr = sheetObj.GetSaveString(true);
    			var sXml = sheetObj.GetSaveXml("COM_APR_0T1GS2.do", SaveStr + "&" + FormQueryString(formObj));
            	chkSelfApro = ComGetEtcData(sXml,"CHK_SELF_APRO");
        	break;
            
          
         }
     }


     // OrganTree 로 부터 받은 HashMap 결과를 시트에 바인딩
    function loadData(data) {
    	var sheetObject = sheetObjects[0];

    	var sheetXml = "<SHEET><DATA COLSEPARATOR='|'>";
    	for( var i = 0 ; i < data.length ; i++ ) {
    		sheetXml += "<TR><![CDATA[";
    		sheetXml += data[i].getPos(1) + "|" + data[i].getPos(0) + "|" + data[i].getPos(7) + "|" + data[i].getPos(4);	//data[i].get("TEAM");
    		sheetXml += "]]></TR>";
    	}
    	sheetObject.LoadSearchXml(sheetXml+"</DATA></SHEET>");
     }
     
    function sheet1_OnDblClick(sheetObj, row, col, value) {
    	var formObject = document.form;
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
  
        var selrow = sheetObject1.SelectRow;
        if ( selrow > 0 )
        {
            var usr_id = sheetObject1.CellValue(selrow, "CN");
            var usr_nm = sheetObject1.CellValue(selrow, "NAME");
            var ofc_cd = sheetObject1.CellValue(selrow, "TEAMNM"); 
            var title  = sheetObject1.CellValue(selrow, "BUJAE");
            
            // Duplication(중복) 체크
            for(var i=0; i<sheetObject2.RowCount; i++) {
                if(sheetObject2.CellValue(i + 1, "auth_apro_usr_id") == usr_id) {
                    ComShowMessage(usr_id + " is already added");
                    return;
                }
            }
            /*
            if(ofc_cd.length > 6){
                ComShowMessage(ofc_cd + " is wrong code");
                return;
            }
            */
            
            /**
             * I/F된 CSR은 결재라인 추가 불가하도록 한다.
             */
            var csr_no = formObject.csr_no.value;
            if(csr_no != "" && csr_no != undefined){
	        	formObject.f_cmd.value = SEARCH05;
	       	 	var sXml = sheetObject2.GetSaveXml("COM_APR_0T1GS2.do",FormQueryString(formObject));
	            if ("F" == ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
			    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
			     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
			     		ComShowMessage(rmsg[3]);
			     	} else {
			     		sheetObject2.LoadSaveXml(sXml);
			     		return;
					}
				}
            }
       	 	
            // 대상 Sheet로 데이타 이행
            row = sheetObject2.DataInsert(0);
			sheetObject2.CellValue2(row, "auth_apro_usr_nm") =  usr_nm;
			sheetObject2.CellValue2(row, "auth_apro_ofc_cd") =  ofc_cd;            			
			sheetObject2.CellValue2(row, "auth_apro_usr_jb_tit_nm")  =  title; 
			sheetObject2.CellValue2(row, "auth_apro_usr_id") =  usr_id;
			
            // APPROVAL SEQ 재정렬
            var rowCount = sheetObject2.RowCount;
            for(var i=0; i<rowCount; i++) {
                  sheetObject2.CellValue2(i + 1, "auth_apro_rout_usr_seq") = rowCount - i;
            }
            /*
            var rowCount = sheetObject2.RowCount;
            for(var i=0; i<rowCount; i++) {
                  sheetObject2.CellValue2(i + 1, "apro_seq") = i+1;
            }*/
        }
    }
    
 // 소속 Office 자동 펼침 처리
    function officeSearch() {
	 	findXML('TEAMNM', document.getElementById("ofc_cd").value);
    }
    
    //DEL Button 클릭시 처리 로직
    function sheet2_OnDblClick(sheetObj, row, col, value) {
    	var formObject = document.form;
    	var sheetObject2 = sheetObjects[1];
        var selrow = sheetObject2.SelectRow;
        var csr_no = formObject.csr_no.value;
        var apro_rqst_seq = sheetObject2.CellValue(selrow,"auth_apro_rout_usr_seq");
        var apro_usr_id = sheetObject2.CellValue(selrow,"auth_apro_usr_id");
        var apro_cfm_scrn_flg = ComTrimAll(formObject.apro_cfm_scrn_flg);
        var ep_id = ComTrimAll(formObject.ep_id);
        
        //(Only)Approval Confirm화면에서 Edit Approval Step Delete시 자기 자신을 삭제하는지 못하도록 한다.
        // EP ID : GW에서 별도로사용하는 User Id(COM_USER의 USR_ID와 맵핑됨.)
//        if(apro_cfm_scrn_flg !="" && apro_cfm_scrn_flg != undefined && apro_cfm_scrn_flg != null){
//        	if(ep_id !="" && ep_id != undefined && ep_id != null){
//        		if(apro_usr_id !="" && apro_usr_id != undefined && apro_usr_id != null){
//        			if(ep_id == apro_usr_id){
//        				ComShowMessage("The approved route cannot be deleted.");
//        				return;
//        			}
//        		}
//            }
//        }
        
        //승인된 결제라이는 삭제할 수 없다.
//        if(csr_no != "" && csr_no != undefined){
//        	formObject.f_cmd.value = SEARCH04;
//        	 var sXml = sheetObject2.GetSaveXml("COM_APR_0T1GS2.do","apro_rout_seq="+apro_rqst_seq+"&" + FormQueryString(formObject));
//            if ("F" == ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
//		    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
//		     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
//		     		ComShowMessage(rmsg[3]);
//		     	} else {
//		     		sheetObject2.LoadSaveXml(sXml);
//		     		return;
//				}
//			}
//        }
  
        if(selrow > 0) {
            sheetObject2.RowDelete(selrow, false);
        }
        
        // APPROVAL SEQ 재정렬
        var rowCount = sheetObject2.RowCount;
        for(var i=0; i<rowCount; i++) {
              sheetObject2.CellValue2(i + 1, "auth_apro_rout_usr_seq") = rowCount - i;
        }
    }
    
    
    
    
    function sheet2_OnSaveEnd(sheet2, ErrMsg){    	
    	//기능 살려둠
    	
    }
    
    function returnAuthApprovalRoute() {
    	var formObject = document.form;
        var sheetObject2 = sheetObjects[1];
        //alert(sheetObject2.RowCount);
        
        if(sheetObject2.RowCount > 0){
        	doActionIBSheet(sheetObject2, formObject, IBSAVE);
        }else{
        	
        	/*
        	 * msgs['CSR25020'] = 'There is no Approval Step.\n\n Please check again.';
			 * msgs['CSR25021'] = 'Approval Request has been completed.';
        	 */
        	ComShowMessage('There is no Approval Step.\n\nPlease check again.');
        }
        
    }
    
    function delRqstNo(){
    	if(closeChk == false){
	    	var formObject = document.form;
	    	opener = window.dialogArguments;        		
	        opener.document.all[formObject.target_obj_nm.value].value = "";
    	}
    }

    
    /*
     * 선택된 결재자 아래로 한칸 식 내리기
     */
    function changeDownApproval(){
    	var formObject = document.form;
    	var sheetObject2 = sheetObjects[1];
        var selrow = sheetObject2.SelectRow;

        if(selrow > 0) {
        	if(sheetObject2.CellValue(selrow, "auth_apro_rout_usr_seq")==1){
        		//ComShowMessage('최하단입니다.');
        	}else{
	        	var temp1 = sheetObject2.CellValue(selrow+1, "auth_apro_usr_nm");
	        	var temp2 = sheetObject2.CellValue(selrow+1, "auth_apro_ofc_cd");            			
	        	var temp3 = sheetObject2.CellValue(selrow+1, "auth_apro_usr_jb_tit_nm"); 
	        	var temp4 = sheetObject2.CellValue(selrow+1, "auth_apro_usr_id");
	        	
	        	sheetObject2.CellValue(selrow+1, "auth_apro_usr_nm") = sheetObject2.CellValue(selrow, "auth_apro_usr_nm") ;
	        	sheetObject2.CellValue(selrow+1, "auth_apro_ofc_cd") = sheetObject2.CellValue(selrow, "auth_apro_ofc_cd") ;
	        	sheetObject2.CellValue(selrow+1, "auth_apro_usr_jb_tit_nm") = sheetObject2.CellValue(selrow, "auth_apro_usr_jb_tit_nm");
	        	sheetObject2.CellValue(selrow+1, "auth_apro_usr_id") = sheetObject2.CellValue(selrow, "auth_apro_usr_id");  
	        	
	        	
	
	        	sheetObject2.CellValue(selrow, "auth_apro_usr_nm") = temp1;
	        	sheetObject2.CellValue(selrow, "auth_apro_ofc_cd") = temp2;
	        	sheetObject2.CellValue(selrow, "auth_apro_usr_jb_tit_nm") = temp3;
	        	sheetObject2.CellValue(selrow, "auth_apro_usr_id") = temp4;
	        	
	        	sheetObject2.SelectCell(selrow+1, 0);  
        	}
            
        }
        
        // APPROVAL SEQ 재정렬
        var rowCount = sheetObject2.RowCount;
        for(var i=0; i<rowCount; i++) {
              sheetObject2.CellValue2(i + 1, "auth_apro_rout_usr_seq") = rowCount - i;
        }
    }
    
    
    /*
     * 선택된 결재자 위로 한칸 씩 올리기
     */
    function changeUpApproval(){
    	var formObject = document.form;
    	var sheetObject2 = sheetObjects[1];
        var selrow = sheetObject2.SelectRow;

        if(selrow > 0) {
        	if(sheetObject2.CellValue(selrow, "auth_apro_rout_usr_seq")==sheetObject2.RowCount){
        		//ComShowMessage('최상단입니다.');
        	}else{
	        	var temp1 = sheetObject2.CellValue(selrow-1, "auth_apro_usr_nm");
	        	var temp2 = sheetObject2.CellValue(selrow-1, "auth_apro_ofc_cd");            			
	        	var temp3 = sheetObject2.CellValue(selrow-1, "auth_apro_usr_jb_tit_nm"); 
	        	var temp4 = sheetObject2.CellValue(selrow-1, "auth_apro_usr_id");
	        	
	        	sheetObject2.CellValue(selrow-1, "auth_apro_usr_nm") = sheetObject2.CellValue(selrow, "auth_apro_usr_nm") ;
	        	sheetObject2.CellValue(selrow-1, "auth_apro_ofc_cd") = sheetObject2.CellValue(selrow, "auth_apro_ofc_cd") ;
	        	sheetObject2.CellValue(selrow-1, "auth_apro_usr_jb_tit_nm") = sheetObject2.CellValue(selrow, "auth_apro_usr_jb_tit_nm");
	        	sheetObject2.CellValue(selrow-1, "auth_apro_usr_id") = sheetObject2.CellValue(selrow, "auth_apro_usr_id");  
	        	
	        	
	
	        	sheetObject2.CellValue(selrow, "auth_apro_usr_nm") = temp1;
	        	sheetObject2.CellValue(selrow, "auth_apro_ofc_cd") = temp2;
	        	sheetObject2.CellValue(selrow, "auth_apro_usr_jb_tit_nm") = temp3;
	        	sheetObject2.CellValue(selrow, "auth_apro_usr_id") = temp4;
	        	
	        	sheetObject2.SelectCell(selrow-1, 0);
        	}
            
        }
        
        // APPROVAL SEQ 재정렬
        var rowCount = sheetObject2.RowCount;
        for(var i=0; i<rowCount; i++) {
              sheetObject2.CellValue2(i + 1, "auth_apro_rout_usr_seq") = rowCount - i;
        }
    }

    
    /*
     * 결재자가 한명이며 동일 인물로 설정 할 때 Valid 
     */
    function validSelfApproval(){
    	var formObject = document.form;
    	var sheetObject2 = sheetObjects[1];
    	doActionIBSheet(sheetObject2, formObject, IBSEARCH_ASYNC02);
    	
    	if(chkSelfApro == "N"){
    		returnAuthApprovalRoute();
    	}else{
    		ComShowMessage("You cannot set yourself as Approval Staff.");
    	}
    	
    }
    
//    function sheet2_OnSearchEnd(){
//    	var formObject = document.form;
//    	var sheetObject2 = sheetObjects[1];
//    	var rowCount = sheetObject2.RowCount;
//    	alert(sheetObject2.CellValue(1,"auth_apro_usr_id"));
//    }
    
	/* 개발자 작업  끝 */