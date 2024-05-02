/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1515.js
*@FileTitle : E-BKG Handling Office Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.10
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2014.06.10 문동선
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
     * @class esm_bkg_1515 : esm_bkg_1515 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1515() { 
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
var sheetObjects = new Array();
var sheetCnt = 0;
var maxCtrl = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

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
    	  
         for(i=0;i<sheetObjects.length;i++){
        	 
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);

             ComEndConfigSheet(sheetObjects[i]);
         }           
         
		 initControl();

		 ComBtnDisable("btn_save");
		 ComBtnDisable("btn_history");
		 ComBtnDisable("btn_excel");
		 
	     var formObj = document.form;		 
	     formObj.f_cmd.value = SEARCH; 
		 var sParam = "f_cmd="+formObj.f_cmd.value+"&yd_cd="+"&edi_rcv_id="+"&edi_snd_id="+"&full_rlse_edi_cd=";				
		 sheetObjects[1].DoSearch("ESM_BKG_1515GS.do", sParam);

     }

       /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects 배열에서 순번
       */
      function initControl() {
      	var formObject = document.form;
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          axon_event.addListener('keydown', 'ComKeyEnter', 'form');          
      }
      
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "engnum":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet('num');
	            break;    
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
 				var sheetID = sheetObj.id;
 				switch(sheetID) {

 					case "sheet1":
 							with (sheetObj) {

 								style.height = 422;
 						
		 						//전체 너비 설정
		 						SheetWidth = mainTable.clientWidth;
		 		
		 						//Host정보 설정[필수][HostIp, Port, PagePath]
		 						if (location.hostname != "")
		 							InitHostInfo(location.hostname, location.port, page_path);
		 		
		 						//전체Merge 종류 [선택, Default msNone]
		 						MergeSheet = msHeaderOnly;
		 		
		 						//전체Edit 허용 여부 [선택, Default false]
		 						Editable = true;
		 		
		 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		 						InitRowInfo(1, 1, 15, 50);
		 		
		 						var HeadTitle1 = "|Seq.|YD|POD YARD|POD YARD|YARD Description|POD|POD Description|Rcv ID|Snd ID|EDI Type|Lane1|Lane2|Lane3|Lane4|Lane5|Lane6|Lane7|Lane8|Lane9|Lane10|Create Dt|Create ID|Update Dt|Update ID";
		 		
		 						var headCount = ComCountHeadTitle(HeadTitle1);
		 		
		 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		 						InitColumnInfo(headCount, 0, 0, true);
		 		
		 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
		 						//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
		 						InitHeadMode(true, true, true, true, false, false)
		 		
		 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		 						InitHeadRow(0, HeadTitle1, true);
		 						
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,			0,		daCenter,		true,		"ibflag");
 								InitDataProperty(0,		cnt++ , dtSeq,					40,		daCenter,		true,		"Seq",				false,		"",		dfNone,					0,		false,	false); 								
 								
 								InitDataProperty(0,	 	cnt++, 	dtHidden, 				60, 	daCenter, 		true, 		"yd_cd", 		true, 		"", 		dfNone, 			0, 	false, 		false, 		5);
 								InitDataProperty(0,	 	cnt++, 	dtData, 				60, 	daCenter, 		true, 		"pod_cd", 		true, 		"", 		dfNone, 			0, 	false, 		false, 		5);
 								InitDataProperty(0, 	cnt++, 	dtData, 				30, 	daCenter, 		true, 		"pod_yd_no", 	true, 		"", 		dfNone, 			0, 	false, 		false, 		2);
 								InitDataProperty(0, 	cnt++, 	dtData, 		   		140, 	daLeft, 		true, 		"yd_desc", 		false, 		"", 		dfNone, 			0, 	false, 		false);
 								InitDataProperty(0, 	cnt++, 	dtData, 				60, 	daCenter, 		true, 		"pod_cd_cpy", 	false, 		"", 		dfNone, 			0, 	false, 		false, 		5);
 								InitDataProperty(0, 	cnt++, 	dtData, 		 	  	140, 	daLeft, 		true, 		"pod_desc", 	false, 		"", 		dfNone, 			0, 	false, 		false);
 								
 								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"edi_rcv_id",		false,		"",		dfNone,					0,		true,	true, 20);
 								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"edi_snd_id",		false,		"",		dfNone,					0,		true,	true, 20);
 								InitDataProperty(0,		cnt++ , dtCombo,				80,		daCenter,		true,		"full_rlse_edi_cd",	false,		"",		dfNone,					0,		true,	true, 100); 								
 								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd1",			false,		"",		dfNone,					0,		true,	true, 3); 								
 								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd2",			false,		"",		dfNone,					0,		true,	true, 3);
 								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd3",			false,		"",		dfNone,					0,		true,	true, 3);
 								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd4",			false,		"",		dfNone,					0,		true,	true, 3);
 								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd5",			false,		"",		dfNone,					0,		true,	true, 3);
 								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd6",			false,		"",		dfNone,					0,		true,	true, 3);
 								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd7",			false,		"",		dfNone,					0,		true,	true, 3);
 								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd8",			false,		"",		dfNone,					0,		true,	true, 3);
 								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd9",			false,		"",		dfNone,					0,		true,	true, 3);
 								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd10",		false,		"",		dfNone,					0,		true,	true, 3);
 								InitDataProperty(0,		cnt++ , dtHidden,				120,	daCenter,		true,		"cre_dt",			false,		"",		dfNone,					0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtHidden,				100,	daCenter,		true,		"cre_usr_id",		false,		"",		dfNone,					0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		true,		"upd_dt",			false,		"",		dfNone,					0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					80,	daCenter,		true,		"upd_usr_id",		false,		"",		dfNone,					0,		false,	false); 								

 								InitDataCombo(0, "full_rlse_edi_cd", 	" |FO|FOC", 	" |1|2");
 								InitDataValid(0, "pod_cd", vtEngUpOnly, "");
 								InitDataValid(0, "pod_yd_no", vtEngOther, "1234567890");							
 								InitDataValid(0, "edi_snd_id", vtEngUpOther, "0123456789");
 								InitDataValid(0, "slan_cd1", vtEngUpOther, "0123456789"); 								
 								InitDataValid(0, "slan_cd2", vtEngUpOther, "0123456789");
 								InitDataValid(0, "slan_cd3", vtEngUpOther, "0123456789");
 								InitDataValid(0, "slan_cd4", vtEngUpOther, "0123456789");
 								InitDataValid(0, "slan_cd5", vtEngUpOther, "0123456789");
 								InitDataValid(0, "slan_cd6", vtEngUpOther, "0123456789");
 								InitDataValid(0, "slan_cd7", vtEngUpOther, "0123456789");
 								InitDataValid(0, "slan_cd8", vtEngUpOther, "0123456789");
 								InitDataValid(0, "slan_cd9", vtEngUpOther, "0123456789");
 								InitDataValid(0, "slan_cd10", vtEngUpOther, "0123456789");					
 						}
 						break;
 					

 					case "sheet2":
							with (sheetObj) {

								style.height = 422;
						
	 						//전체 너비 설정
	 						SheetWidth = mainTable.clientWidth;
	 		
	 						//Host정보 설정[필수][HostIp, Port, PagePath]
	 						if (location.hostname != "")
	 							InitHostInfo(location.hostname, location.port, page_path);
	 		
	 						//전체Merge 종류 [선택, Default msNone]
	 						MergeSheet = msHeaderOnly;
	 		
	 						//전체Edit 허용 여부 [선택, Default false]
	 						Editable = true;
	 		
	 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	 						InitRowInfo(1, 1, 15, 50);
	 		
	 						var HeadTitle1 = "|Seq.|YD|POD YARD|POD YARD|YARD Description|POD|POD Description|Rcv ID|Snd ID|EDI Type|Lane1|Lane2|Lane3|Lane4|Lane5|Lane6|Lane7|Lane8|Lane9|Lane10|Create Dt|Create ID|Update Dt|Update ID";
	 		
	 						var headCount = ComCountHeadTitle(HeadTitle1);
	 		
	 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 						InitColumnInfo(headCount, 0, 0, true);
	 		
	 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 						//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
	 						InitHeadMode(true, true, true, true, false, false)
	 		
	 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 						InitHeadRow(0, HeadTitle1, true);
	 						
								
								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
								InitDataProperty(0,		cnt++ , dtHiddenStatus,			0,		daCenter,		true,		"ibflag");
								InitDataProperty(0,		cnt++ , dtSeq,					40,		daCenter,		true,		"Seq",				false,		"",		dfNone,					0,		false,	false); 								
								
								InitDataProperty(0,	 	cnt++, 	dtHidden, 				60, 	daCenter, 		true, 		"yd_cd", 		true, 		"", 		dfNone, 			0, 	false, 		false, 		5);
								InitDataProperty(0,	 	cnt++, 	dtData, 				60, 	daCenter, 		true, 		"pod_cd", 		true, 		"", 		dfNone, 			0, 	false, 		false, 		5);
								InitDataProperty(0, 	cnt++, 	dtData, 				30, 	daCenter, 		true, 		"pod_yd_no", 	true, 		"", 		dfNone, 			0, 	false, 		false, 		2);
								InitDataProperty(0, 	cnt++, 	dtData, 		   		140, 	daLeft, 		true, 		"yd_desc", 		false, 		"", 		dfNone, 			0, 	false, 		false);
								InitDataProperty(0, 	cnt++, 	dtData, 				60, 	daCenter, 		true, 		"pod_cd_cpy", 	false, 		"", 		dfNone, 			0, 	false, 		false, 		5);
								InitDataProperty(0, 	cnt++, 	dtData, 		 	  	140, 	daLeft, 		true, 		"pod_desc", 	false, 		"", 		dfNone, 			0, 	false, 		false);
								
								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"edi_rcv_id",		false,		"",		dfNone,					0,		true,	true, 20);
								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"edi_snd_id",		false,		"",		dfNone,					0,		true,	true, 20);
								InitDataProperty(0,		cnt++ , dtCombo,				80,		daCenter,		true,		"full_rlse_edi_cd",	false,		"",		dfNone,					0,		true,	true, 100); 								
								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd1",			false,		"",		dfNone,					0,		true,	true, 3); 								
								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd2",			false,		"",		dfNone,					0,		true,	true, 3);
								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd3",			false,		"",		dfNone,					0,		true,	true, 3);
								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd4",			false,		"",		dfNone,					0,		true,	true, 3);
								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd5",			false,		"",		dfNone,					0,		true,	true, 3);
								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd6",			false,		"",		dfNone,					0,		true,	true, 3);
								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd7",			false,		"",		dfNone,					0,		true,	true, 3);
								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd8",			false,		"",		dfNone,					0,		true,	true, 3);
								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd9",			false,		"",		dfNone,					0,		true,	true, 3);
								InitDataProperty(0,		cnt++ , dtData,					46,		daCenter,		true,		"slan_cd10",		false,		"",		dfNone,					0,		true,	true, 3);
								InitDataProperty(0,		cnt++ , dtHidden,				120,	daCenter,		true,		"cre_dt",			false,		"",		dfNone,					0,		false,	false);
								InitDataProperty(0,		cnt++ , dtHidden,				100,	daCenter,		true,		"cre_usr_id",		false,		"",		dfNone,					0,		false,	false);
								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		true,		"upd_dt",			false,		"",		dfNone,					0,		false,	false);
								InitDataProperty(0,		cnt++ , dtData,					80,	daCenter,		true,		"upd_usr_id",		false,		"",		dfNone,					0,		false,	false); 								

								InitDataCombo(0, "full_rlse_edi_cd", 	" |FO|FOC", 	" |1|2");
								InitDataValid(0, "pod_cd", vtEngUpOnly, "");
								InitDataValid(0, "pod_yd_no", vtEngOther, "1234567890");							
								InitDataValid(0, "edi_snd_id", vtEngUpOther, "0123456789");
								InitDataValid(0, "slan_cd1", vtEngUpOther, "0123456789"); 								
								InitDataValid(0, "slan_cd2", vtEngUpOther, "0123456789");
								InitDataValid(0, "slan_cd3", vtEngUpOther, "0123456789");
								InitDataValid(0, "slan_cd4", vtEngUpOther, "0123456789");
								InitDataValid(0, "slan_cd5", vtEngUpOther, "0123456789");
								InitDataValid(0, "slan_cd6", vtEngUpOther, "0123456789");
								InitDataValid(0, "slan_cd7", vtEngUpOther, "0123456789");
								InitDataValid(0, "slan_cd8", vtEngUpOther, "0123456789");
								InitDataValid(0, "slan_cd9", vtEngUpOther, "0123456789");
								InitDataValid(0, "slan_cd10", vtEngUpOther, "0123456789");					
						}
						break;

						
 			}
 	}
      
      
   // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
      function processButtonClick(){
           /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  		   var sheetObject1 = sheetObjects[0];
           /*******************************************************/
           var formObject = document.form;

      	try {
      		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					ComBtnEnable("btn_save");
					ComBtnEnable("btn_history");
					ComBtnEnable("btn_excel");
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
				break;
				
				case "btn_delete":
					sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "ibflag") = "D";
				break;
				
				case "btn_add":
					 addRow();
					ComBtnEnable("btn_save");
					ComBtnEnable("btn_history");
					ComBtnEnable("btn_excel");					 
				break;
				
				case "btn_excel":
			    	sheetObjects[0].SpeedDown2Excel();
				break;
				
		        case "btn_history":
		        	fncBtnHistory();
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
       * 시트에 키필드 Validation 체크 및 해당 코드의 description 조회
       */
  	function sheet1_OnChange(sheetObj, rowIdx, colIdx, value) {
      	var formObj = document.form;
		
		if( colIdx == sheetObj.SaveNameCol("pod_cd") ){
			var pod_desc_val = doActionIBSheet(sheetObjects[0], document.form, SEARCH03, rowIdx, colIdx, 1, "pod_cd="+sheetObj.CellValue(rowIdx, "pod_cd"));
			sheetObj.CellValue2(rowIdx, "pod_desc") = pod_desc_val;
			sheetObj.CellValue2(rowIdx, "pod_cd_cpy") = sheetObj.CellValue(rowIdx, "pod_cd");
			if( pod_desc_val == "" ){
				ComShowCodeMessage("COM132201","POD Code");
				sheetObj.CellValue2(rowIdx, "pod_cd") = "";
				sheetObj.CellValue2(rowIdx, "pod_cd_cpy") = "";
				return;
			}
		} else if( colIdx == sheetObj.SaveNameCol("pod_yd_no") ){
			sheetObj.CellValue(rowIdx, "pod_yd_no") = sheetObj.CellValue(rowIdx, "pod_yd_no").toUpperCase();
			var yd_desc_val = doActionIBSheet(sheetObjects[0], document.form, SEARCH02, rowIdx, colIdx, 1, "pod_yd_no="+sheetObj.CellValue(rowIdx, "pod_cd") + sheetObj.CellValue(rowIdx, "pod_yd_no"));
			sheetObj.CellValue2(rowIdx, "yd_desc") = yd_desc_val;
			if( sheetObj.CellValue(rowIdx, "pod_yd_no") != "" && yd_desc_val == "" ){
				ComShowCodeMessage("BKG01078",sheetObj.CellValue(rowIdx, "pod_yd_no"));
				sheetObj.CellValue2(rowIdx, "pod_yd_no") = "";
				return;
			}
		// SLAN 유효성 체크
		} else if( (colIdx != sheetObj.SaveNameCol("edi_rcv_id")) && (colIdx != sheetObj.SaveNameCol("edi_snd_id") )&& (colIdx != sheetObj.SaveNameCol("full_rlse_edi_cd")) ){			
			formObj.strSlanCd.value = sheetObj.CellValue(rowIdx, colIdx);
			if(formObj.strSlanCd.value != ""){
				doActionIBSheet(sheetObj, formObj, SEARCH04, rowIdx, colIdx);
			}
		}
		
     }
      
   // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo, param) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH; 
				sheetObj.DoSearch("ESM_BKG_1515GS.do", FormQueryString(formObj));
			break;

			case IBSAVE:         //저장
 				
				formObj.f_cmd.value = MULTI;
				var saveParam = ComGetSaveString(sheetObjects[0]);
				if(sheetObj.isDataModified == false || saveParam == ""){
					ComShowCodeMessage('BKG00260');
					return;
				}

				//중복 확인 하는 부분
				var newList = new Array();
				var chkecData = new Array();
				
				//입력한 자료
				var j=0;				
				for(var i = 1; i <= sheetObjects[0].RowCount; i++){
					if ( sheetObjects[0].CellValue(i, "ibflag") == "I") {
						j++;						
						newList[j] = sheetObjects[0].CellValue(i, "pod_cd")+sheetObjects[0].CellValue(i, "pod_yd_no");
					}
				}
				//기존자료
				for(var i = 1; i <= sheetObjects[1].RowCount; i++){
					chkecData[i] = sheetObjects[1].CellValue(i, "pod_cd")+sheetObjects[1].CellValue(i, "pod_yd_no");
				}
				
				//입력한 자료 중복
				for(var i=1; i<newList.length; i++){
					for(var j=1; j<newList.length; j++){
						if((i != j) &&(newList[i] == newList[j])){
							ComShowCodeMessage("BKG03056",newList[j]);
							return;
						}
					}
				}
								
				//기존 & 입력한 자료 중복				
				for(var i=1; i<chkecData.length; i++){
					for(var j=1; j<newList.length; j++){
						if(chkecData[i] == newList[j]){
							ComShowCodeMessage("BKG03056",newList[j]);
							return;
						}
					}
				}
				sheetObj.DoSave("ESM_BKG_1515GS.do", FormQueryString(formObj));
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

			break;
			
			case IBDELETE:      // 삭제
				ComRowHideDelete(sheetObj, "Del");
			break;
			
			case SEARCH02: //Yard Description 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + param);
				return ComGetEtcData(sXml, "YD_DESC");
			break;
				
			case SEARCH03: //Location Description 조회
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0354GS.do", FormQueryString(formObj) + "&" + param);
				return ComGetEtcData(sXml, "LOC_DESC");
			break;
		
           case SEARCH04:      //조회
	        	  formObj.f_cmd.value = SEARCH02;
	        	  sheetObj.WaitImageVisible = false;
	        	  ComOpenWait(true);
	        	  var sXml = sheetObj.GetSaveXml("ESM_BKG_1098GS.do", FormQueryString(formObj));
	        	  var valResult = ComGetEtcData(sXml, "slan_cd");
	        	  if(valResult == '' || valResult == 'INVALID'){
					  ComShowCodeMessage('BKG00068', 'LANE');
					  sheetObj.CellValue2(Row, Col) = "";
				  }
	        	  ComOpenWait(false);
            break;
			
         }
         
         ComOpenWait(false);
     }

      
    /**
     * 로우추가이벤트 처리 
     */  
     function addRow(){
       		var formObject = document.form;
       		var row = sheetObjects[0].DataInsert(-1);
   			sheetObjects[0].CellEditable(row, "pod_yd_no") = true;
   			sheetObjects[0].CellEditable(row, "pod_cd") = true;
   			sheetObjects[0].CellEditable(row, "edi_rcv_id") = true;
   			sheetObjects[0].CellEditable(row, "edi_snd_id") = true;
   			sheetObjects[0].CellEditable(row, "full_rlse_edi_cd") = true;
   			sheetObjects[0].CellValue2(row, "cre_usr_id") = formObject.usr_id.value;
   			sheetObjects[0].CellValue2(row, "cre_dt") = setDate();
   			sheetObjects[0].CellValue2(row, "upd_usr_id") = formObject.usr_id.value;
   			sheetObjects[0].CellValue2(row, "upd_dt") = setDate();
     }

     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj, formObj, sAction) {
     	
     	switch (sAction) {
	        case IBSEARCH: // 조회시 확인
	     		if(!ComChkValid(formObj)) return false;
	     		break;
	        case IBSAVE: // 저장시 확인
	 		//if(!ComChkValid(formObj)) return false;
	 		break;

     	}
     }

     
     /**
      * History
      */     
     function fncBtnHistory(){
    	    var goUrl = "";
    	    var param = "";
    	    var formObj = document.form;
    	    formObj.f_cmd.value = SEARCH01;

    	    var sheetObjMaster = sheetObjects[0];
    	    selRow = sheetObjMaster.SelectRow;
    	    
    	    goUrl = "/hanjin/ESM_BKG_1515_1.do";
    	    param += "?f_cmd="+formObj.f_cmd.value;
    	    param += "&yd_cd="+sheetObjMaster.CellValue(selRow,"yd_cd");

    	    ComOpenWindowCenter(goUrl + param,"ESM_BKG_1516",1000,420,true);
     }
     
     /**
      * 현재 날짜,시간 구하기
      */
     function setDate() {
     	var d = new Date;
     	var s = leadingZeros(d.getFullYear(), 4) + '-' + leadingZeros(d.getMonth() + 1, 2) + '-' + leadingZeros(d.getDate(), 2) + ' '
     			+ leadingZeros(d.getHours(), 2) + ':' + leadingZeros(d.getMinutes(), 2);
     	return s;
     }
     
     /**
      * 한자리 숫자 앞에 '0' 붙이기
      */
     function leadingZeros(n, digits) {
     	var zero = '';
     	n = n.toString();
     	
     	if (n.length < digits) {
     		for (i = 0; i < digits - n.length; i++)
     			zero += '0';
     	}
     	return zero + n;
     }     
     
	/* 개발자 작업  끝 */