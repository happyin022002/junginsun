/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0004.js
*@FileTitle : Lease Term Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.04 이호선
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
     * @class ees_mst_0004 : ees_mst_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0004() {
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
 var sheet1 = null;
//html form
 var frm = null;

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
				case "btn_downexcel":
					sheetObject1.Down2Excel(-1,false,false,true,"","",false,false,"",false,"1");
				break;
				
				case "btn_save":
				   if(strOfcCd == "SELCON"){
					   //Purchase option이 "Y"일때 CHECK
				       for(var i=1; i<=sheetObject1.RowCount; i++){ 		
				    	  if(sheetObject1.CellValue(i,6) == "Y"){
				    		  if (sheetObject1.CellValue(i,7) == "" || sheetObject1.CellValue(i,7) == "0" || sheetObject1.CellValue(i,7) == "0.00"){
				    			 ComShowCodeMessage("MST00001","Purchase Price" );
				    			 sheetObject1.CellValue(i,7) = "";
				    			 sheetObject1.SelectCell(i,7, true);
				      		     return;
				    		  } 
				    	  }
				    	  
				    	  //필수항목 Check
				    	  for (var j=1; j <= 8; j++){
					          if( j == "3" || j == "4" || j == "6" || j == "8"){
					          	if (j == "3" && sheetObject1.CellValue(i,j).length == 1){
					       			ComShowCodeMessage("MST00001","Lease Term");
					       			sheetObject1.CellValue(i,j) = "";
					       			sheetObject1.SelectCell(i, j, true);
					        		return;
					          	}
					          	if (sheetObject1.CellValue(i,j) == ""){
					        		ComShowCodeMessage("MST00001","Lease Term,Description,Purchase Option,Display Sequence");
					        		sheetObject1.CellValue(i,j) = "";
					        		sheetObject1.SelectCell(i, j, true);
					        		return;
					          	}
					          }
				    	  }
				    	  
				    	  var lstm_cd = sheetObject1.CellValue(i,"lstm_cd");
				    	  if (lstm_cd.trim() == ""){
		       			     ComShowCodeMessage("MST00001","Lease Term");
		       			     sheetObject1.SelectCell(i,3, true);
		         		     return;				    		  
				    	  }
			           }
				       
		        		// 동일한 lstm_cd가 있으면  첫번째 중복행에 대해서  메세지 출력
		        		var dupRows = sheetObject1.ColValueDupRows("lstm_cd");
		        		var arrRow = dupRows.split(",");

				        if (dupRows != ""){
			       			 //오류메시지 : 데이터가 중복됩니다.
			       			 ComShowCodeMessage("MST00002", sheetObject1.CellValue(arrRow[0],3));
			       			 sheetObject1.SelectCell(arrRow[0], 3, true);
			       			 return;				        	
				        } 
				        
		        		// 동일한 dp_seq 있으면  첫번째 중복행에 대해서  메세지 출력
		        		dupRows = sheetObject1.ColValueDupRows("dp_seq");
		        		arrRow = dupRows.split(",");
				        if (dupRows != ""){
			       			 //오류메시지 : 데이터가 중복됩니다.
			       			 ComShowCodeMessage("MST00002", sheetObject1.CellValue(arrRow[0],8));
			       			 sheetObject1.SelectCell(arrRow[0], 8, true);
			       			 return;				        	
				        } 	
				        
				        doActionIBSheet(sheetObject1, formObject, IBSAVE);
				   }
				break;
				
				case "btn_add":
					if(strOfcCd == "SELCON"){
						sheetObject1.DataInsert();
					}
				break;
				
				case "btn_del":
   					if(strOfcCd == "SELCON")
   					{
	   					if(sheetObject1.FindCheckedRow("del_chk")=="")
	   					{
	   						ComShowCodeMessage("MST00010");
	   					}
	   					else if(ComShowCodeConfirm("MST00005")) 
	   					{ 
	   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
	   					}
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
      * Form 이벤트 등록
      */
     function initControl() {
         // change
         axon_event.addListenerForm('change', 'obj_change', frm);
      	 // focus in
         axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);         
     }     

     /**
      * HTML Control Foucs in
      */
     function obj_change(){
     }
     
     function obj_deactivate(){
     }
    // ===================================================================================
    // Sheet 이벤트 처리
    // ===================================================================================
    /**
     * sheet1 편집처리후 이벤트 
     * pur_opt_flg : pur_opt_flg 
     * @param {long} row 해당 셀의 Row Index
     * @param {long} col 해당 셀의 Column Index
     * @param {string} col 해당 셀의 value  
     * 
     */
     function sheet1_OnChange(sheet , row , col , value) {
  	    
	    var pur_opt_flg = sheet.CellValue(row,"pur_opt_flg");
	    var lstm_cd = sheet.CellValue(row,"lstm_cd");
	    
	    if (sheet.CellValue(row, "lstm_cd") == "OW" && pur_opt_flg == "Y") {
	    	ComShowCodeMessage("MST01029");
			sheet.CellValue(row, "pur_opt_flg") = "N";
	    }
	    if (pur_opt_flg == "N"){
	    	sheet.CellValue(row, "pur_prc") =	"0";
	    }
     }
    
 	//입력완료시 필수항목 및 필수항목 길이 체크
 	function sheet1_OnAfterEdit(sheetObj,Row,Col){
 		
 		var sName = sheetObj.ColSaveName(Col); 		
 		
 		var lstm_cd = sheetObj.CellValue(Row,"lstm_cd");
        
        for(var i=1; i<=sheetObj.RowCount; i++)
        {
            //Purchase option이 "Y"일때 CHECK
        	if(sheetObj.CellValue(i,6) == "Y" && sheetObj.CellValue(i,3) != "OW"){
        		if (sheetObj.CellValue(i,7) == "" || sheetObj.CellValue(i,7) == "0" || sheetObj.CellValue(i,7) == "0.00"){
       			     ComShowCodeMessage("MST00001", "Purchase Price");
       			     sheetObj.SelectCell(i,7, true);
         		     return;
       		    }         		
        	 }	
        	
        	 // sheet내의 lstm_cd 키 중복 체크.
	       	 if(i != Row)		// 자기자신이 아니면 중복체크를 한다.
	       	 {
	       		 var cur_code = sheetObj.CellValue(i,"lstm_cd");
	       		 if(lstm_cd == cur_code && lstm_cd != "")
	       		 {
	       			 //오류메시지 : 데이터가 중복됩니다.
	       			 ComShowCodeMessage("MST00002",cur_code);
	       		     sheetObj.SelectCell(Row, 2, true);
	       			 return;
	       		 }
	       	 }
        }//End for 		
 		
        //필수항목 Check
        //if( Col == "3" || Col == "4" || Col == "6" || Col == "8"){
        if (sName == "lstm_cd" || sName == "lstm_nm" || sName == "pur_opt_flg" || sName == "dp_seq"){
        	if (sName == "lstm_cd" && sheetObj.CellValue(Row,Col).length == 1){
     			 ComShowCodeMessage("MST00001","Lease Term");
      		     sheet1.CellValue(Row,Col) = "";
      		     sheet1.SelectCell(Row, Col-1, true);
      			 return;
        	}
        	if (sheetObj.CellValue(Row,Col) == ""){
      			 ComShowCodeMessage("MST00001","Lease Term,Description,Purchase Option,Display Sequence");
      		     sheet1.CellValue(Row,Col) = "";
      		     sheet1.SelectCell(Row, Col-1, true);
      			 return;
        	}
        }
        
        //Purchase option이 Yes 인경우에 Purchase Price가 값이 없거나 0일 경우 처리
      	
 	}
 	
 	/**
 	 * 셀을 클릭했을때 발생하는 이벤트 <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {ibsheet} row     	sheetObj의 선택된 Row
 	 * @param {ibsheet} col     	sheetObj의 선택된 Col
 	 **/
 	function sheet1_OnClick(sheetObj, row, col) {
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
    	 //전역 변수 설정 
    	 frm = document.form;    	  
    	 sheet1 = sheetObjects[0];
         for(i=0;i<sheetObjects.length;i++){
	         //khlee-시작 환경 설정 함수 이름 변경
	         ComConfigSheet (sheetObjects[i] );
	         initSheet(sheetObjects[i],i+1);
	         //khlee-마지막 환경 설정 함수 추가
	         ComEndConfigSheet(sheetObjects[i]);
         }
         //Form 이벤트 등록
         initControl();  
     }

     function sheet1_OnLoadFinish(sheetObj) {
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
     }

      /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 448;
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
                     InitColumnInfo(10, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     var HeadTitle = "||Seq.|Lease Term|Description|Lease Period(Years)|Purchase Option|Purchase Price(USD)|Display\nSequence|Remark(s)";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     var prefix="sheet1_";
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,   false, 	 "ibflag");
 	                 InitDataProperty(0, cnt++ , dtDummyCheck,	 40,   daCenter,  false,   	 "del_chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,    	 50,   daCenter,  false,     "Seq");
                     InitDataProperty(0, cnt++ , dtData, 		 90,   daCenter,  false,     "lstm_cd",      true,          "",      dfNone, 			0,     false,      true,	2);
                     InitDataProperty(0, cnt++ , dtData,     	 220,  daLeft,    false,     "lstm_nm",    	 true,          "",      dfNone, 			0,     true,       true,    50);
                     InitDataProperty(0, cnt++ , dtData, 		 120,  daCenter,  false,     "lse_prd_ctnt", false,         "",      dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,     	 120,  daCenter,  false,     "pur_opt_flg",  true,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData, 		 130,  daRight,  false,      "pur_prc",      false,         "",      dfNullFloat,	    2,     true,       true,    7);
                     InitDataProperty(0, cnt++ , dtCombo,     	 80,   daCenter,  false,     "dp_seq",    	 true,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,     	 140,  daLeft,  false,     "diff_rmk",     false,         "",      dfNone, 			0,     true,       true,    50);
	  					//데이타 조작용 히든    
 					 InitDataCombo(0, "pur_opt_flg", "No|Yes", "N|Y");
 					 InitDataCombo(0, "dp_seq", "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15", "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15");
 					 //각 필드마다 입력 형태 CHECK
 					 InitDataValid(0, "lstm_cd", vtEngUpOnly); //대문자만 
 					 InitDataValid(0, "lstm_nm", vtEngUpOther, "0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ ");   //영문만 
 					 InitDataValid(0, "lse_prd_ctnt", vtEngUpOther, "0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ "); //영문과 숫자
 					 InitDataValid(0, "diff_rmk", vtEngOther, "0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ ");   //영문만
                }
                 break;
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         var selrow = sheetObj.SelectRow;
         switch(sAction) {
            case IBSEARCH:      //조회
			   if(sheetObj.id == "sheet1") {
				  sheetObj.WaitImageVisible=false;
				  ComOpenWait(true);				   
				  formObj.f_cmd.value = SEARCH;
				  sheetObj.DoSearch("EES_MST_0004GS.do", FormQueryString(formObj));
				  ComOpenWait(false);
			   }
            break;
 			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					var sel_code = sheetObj.CellValue(selrow,"lstm_cd");
					var cur_code = "";
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("EES_MST_0004GS.do", FormQueryString(formObj));
					ComOpenWait(false);
				}
            break;
 			case IBDELETE:      // 삭제
	   	   		if (sheetObj.id == 'sheet1') {  
	   	   		    sheetObj.SelectFontBold = false;
		   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObj,"del_chk"); 
						sheetObj.SelectFontBold = true;
					}
				}    			
			break;
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }

 	/** 
 	 * 쉬트가 여러게일 경우 해당 쉬트를 감춘다.
 	 * @param 	{IBSheet} 	sheetObj	프로세스 처리될 시트오브젝트 
 	 * 차후에 공통합수로 뺀다.  
 	 */   	 	       
 	function MstAllSheetHidden(sheetObj){    
 		for (var idx=1; idx <= sheetObj.RowCount; idx++){
 			sheetObj.RowHidden(idx) = true;      	 
 		}  	
 	}          
	/* 개발자 작업  끝 */