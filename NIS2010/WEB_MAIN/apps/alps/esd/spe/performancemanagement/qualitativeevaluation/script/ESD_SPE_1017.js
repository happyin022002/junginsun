/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1017.js
*@FileTitle : S/P Qualitative Evaulation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
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
     * @class ESD_SPE_1017 : ESD_SPE_1017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1017() {
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


	//공통전역변수
    var frm = null;
    var ipageNo =1 ;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var selectVal;
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

          
            
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;  

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
        	    case "btn_Close":
        	            self.close();
            	        break;
        	    case "btn_OK":
                    comPopupOK();
        	        break;
        	    case "btn_save":
 					doActionIBSheet(sheetObject,document.form,IBSAVE);
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
    	frm = document.form;
        for(i=0;i<sheetObjects.length;i++){
   			 //-시작 환경 설정 함수 이름 변경
   			 ComConfigSheet(sheetObjects[i]);
   			 initSheet(sheetObjects[i],i+1);
   			 //-마지막 환경 설정 함수 추가
   			 ComEndConfigSheet(sheetObjects[i]);                
        }
      	initControl();
      	sheet1_OnLoadFinishLoad(sheetObjects[0]);
    }
        
    function initControl() {
      	var formObject = document.form;
          //Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
      }

      //업무 자바스크립트 OnKeyPress 이벤트 처리
      function keypressFormat() {
      	obj = event.srcElement;
    	    if(obj.dataformat == null) return;
    	    window.defaultStatus = obj.dataformat;
    	    switch(obj.dataformat) {
    	        case "engup":
    	        	ComKeyOnlyAlphabet('upper');
    	            break;
    	            
    	        case "number":
    	        	ComKeyOnlyNumber(obj);
    	            break;
    	    }
      }
        
      /**
       * 시트 초기설정값, 헤더 정의
       * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
       * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
       */
      function initSheet(sheetObj,sheetNo) {
    	  var cnt = 0;
    	  switch(sheetNo) {
    	  	case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(21) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    var HeadTitle = "|EG ID|EVR_USR_ID|Year|SP Code|SVC Category|KPI ID|QUAL SEQ|EV_MON|GRD CHK CD|WGT RSLT RT|Area|Evaluation Factors|Weight|Grade A|Grade A|Grade B|Grade B|Grade C|Grade C" ;
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    HeadRowHeight = 12;
                  //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,	daCenter,  false,	 "ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,     0,	daCenter,  false,    "eg_id",        	 false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,	daCenter,  false,    "evr_usr_id",     	 false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,	daCenter,  false,    "ev_yr",          	 false,          "",       dfNone,       0,     false,       true);                    
                    InitDataProperty(0, cnt++ , dtHidden,     0,	daLeft,    false,    "sp_seq",        	 false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,	daLeft,    false,    "ev_svc_cate_cd",	 false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "sp_kpi_id",		 false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "qual_ev_seq",		 false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "ev_mon",		     false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "ev_grd_chk_cd",    false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,	daLeft,    false,    "ev_wgt_rslt_rt",	 false,          "",       dfNone,       0,     false,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,       150,  daLeft,    false,    "ev_area_ctnt",	 false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       340,  daLeft,    false,    "ev_fctr_ctnt",	 false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  false,    "ev_wgt_rt", 		 false,          "",       dfNone,       0,     false,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,       100,  daLeft,    false,    "n1st_ev_grd_ctnt", false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,	  30,   daCenter,  false,    "grade_a", 		 false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       100,  daLeft,    false,    "n2nd_ev_grd_ctnt", false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,   daLeft,    false,    "grade_b"         , false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       100,  daLeft,    false,    "n3rd_ev_grd_ctnt", false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,   daLeft,    false,    "grade_c"         , false,          "",       dfNone,       0,     true,       true);
                    
               }
               break;        

            }
        }
        
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg = false;
    
        switch(sAction) {
                        
           case IBSEARCH:         // 조회
        	    sheetObj.RemoveAll();
				frm.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(frm);

				var sXml = sheetObj.GetSearchXml("ESD_SPE_1017GS.do", sParam);
				sheetObj.loadSearchXml(sXml);
				calScore(sheetObj);
				break;
				
			case IBSAVE:// SAVE LOGIC
				if(!validateForm(sheetObj,frm,sAction)) return false;
				if (!ComShowCodeConfirm("COM130101")) return; // Do you want to save {?msg1}?
				
				frm.f_cmd.value = MULTI01;
				var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
		        var sXml = sheetObjects[0].GetSaveXml("ESD_SPE_1017GS.do", sParam);
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				var avgScore = ComGetEtcData(sXml, "avgScore");
				if (State != "S") {
				
				
					ComShowCodeMessage('COM130103', 'Data');
					ComOpenWait(false);
					return false;
				} else if (State == "S") {

					if(avgScore != ""){
						frm.s_score.value = avgScore;
					}
					ComShowCodeMessage('COM130102', 'Data');
					//doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
					// close window
					comPopupOK(sheetObj,frm);
					
				}
							
				break;
        	   
           break;

        }
    }
    /**
     * sheet1 편집처리후 이벤트
     * @param {long} row 해당 셀의 Row Index
     * @param {long} col 해당 셀의 Column Index
     * @param {string} col 해당 셀의 value 
     * 
     */
    function sheet1_OnChange(sheetObj, row, col ,value) {
    	// checked = 1, unckecked = 0

    	//if( changeCnt > 10){
    	//	return false;
    	//}else{
    	//}
    	// 가중치 결과 계산
    	
    	if (col == sheetObj.SaveNameCol("grade_a") ){
    		if( value == "1"){
    			sheetObj.CellValue2(sheetObj.SelectRow,"ev_grd_chk_cd") = "A";
    			sheetObj.CellValue2(sheetObj.SelectRow,"grade_b") = 0;
    			sheetObj.CellValue2(sheetObj.SelectRow,"grade_c") = 0;
    		}else{
    			sheetObj.CellValue2(sheetObj.SelectRow,"ev_grd_chk_cd") = "";
    		}
    	}else if (col == sheetObj.SaveNameCol("grade_b") ){
    		if( value == "1"){
    			sheetObj.CellValue2(sheetObj.SelectRow,"ev_grd_chk_cd") = "B";
    			sheetObj.CellValue2(sheetObj.SelectRow,"grade_a") = 0;
    			sheetObj.CellValue2(sheetObj.SelectRow,"grade_c") = 0;
    		}else{
    			sheetObj.CellValue2(sheetObj.SelectRow,"ev_grd_chk_cd") = "";
    		}

    	}else if (col == sheetObj.SaveNameCol("grade_c")) {
    		if( value == "1"){
    			sheetObj.CellValue2(sheetObj.SelectRow,"ev_grd_chk_cd") = "C";
    			sheetObj.CellValue2(sheetObj.SelectRow,"grade_a") = 0;
    			sheetObj.CellValue2(sheetObj.SelectRow,"grade_b") = 0;
    		}else{
    			sheetObj.CellValue2(sheetObj.SelectRow,"ev_grd_chk_cd") = "";
    		}
    	}
    	
		var weight = sheetObj.CellValue(row,"ev_wgt_rt");
		var gradeA = sheetObj.CellValue(row,"grade_a");
		var gradeB = sheetObj.CellValue(row,"grade_b");
		var gradeC = sheetObj.CellValue(row,"grade_c");
		
		var score = 0;
		
		if( gradeA == "1"){
			score = Number(score) + Number(weight * 1);
		}else if(gradeB == "1"){
			score = Number(score) + Number(weight * 0.5);
		}else if(gradeC == "1"){
			score = Number(score) + Number(weight * 0);
		}
		sheetObj.CellValue2(row,"ev_wgt_rslt_rt") = score;
    	calScore(sheetObj);
    }
    
    function calScore(sheetObj){
    	var score = 0;
    	
    	// CELL format변경
		for( var idx = parseInt(sheetObj.HeaderRows); idx <= sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
			var weight = sheetObj.CellValue(idx,"ev_wgt_rt");
			var gradeA = sheetObj.CellValue(idx,"grade_a");
			var gradeB = sheetObj.CellValue(idx,"grade_b");
			var gradeC = sheetObj.CellValue(idx,"grade_c");
			
			if( gradeA == "1"){
				score = Number(score) + Number(weight * 1);
			}else if(gradeB == "1"){
				score = Number(score) + Number(weight * 0.5);
			}
		}
		var formObject = document.form;
		formObject.s_score.value = score;
    }
    
    function comPopupOK(sheetObj,formObject) {
    	var formObject = document.form;
    	
    	var return_val = formObject.s_score.value;
    	var rArray = null; //행데이터를 담고 있는 배열
    	var cArray = null; //열데이터를 담고 있는 배열
    	
    	var sheetIdx = frm.sheetIdx.value; //부모창의 sheet index 값
    	var row = frm.row.value; //부모창의 sheet 의 선택된 row 값
    	var col = frm.col.value; //부모창의 sheet 의 선택된 col 값
    	
    	opener.getESD_POPUP1017(rArray,return_val,sheetIdx,row,col);  //호출하는 부모js에 getTRS_ENS_906펑션을 붙여넣으면됩니다.
    	window.close();
    		
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBSEARCH :
				break;
			case IBSAVE :
				
				for( var idx = parseInt(sheetObj.HeaderRows); idx <= sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
					
					if(sheetObj.CellValue(idx,"grade_a")==0 && sheetObj.CellValue(idx,"grade_b")==0 && sheetObj.CellValue(idx,"grade_c")==0 && sheetObj.CellValue(idx,"ev_wgt_rt")!=0 ){
						
						ComShowCodeMessage('SPE10013');
						return false;
					}
					
				}
				
				break;
    	}
       
        return true;
    }
    /**
     * Sheet 로딩 후 이벤트 <br>
     * body 태그의 onLoadFinish 이벤트핸들러 구현 <br>
     * @param  sheetObj
     * @return 없음
     * @author 
     * @version 2013.03.21
     */ 	  
    function sheet1_OnLoadFinishLoad(sheetObj){
    	doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
    }
	/* 개발자 작업  끝 */    