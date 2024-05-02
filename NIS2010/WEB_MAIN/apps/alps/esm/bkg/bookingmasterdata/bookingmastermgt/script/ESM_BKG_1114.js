/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : esm_bkg_1114.js
*@FileTitle : booking master data
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.09
*@LastModifier : 김현화
*@LastVersion : 1.0
* 2010.12.09 김현화
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
     * @class esm_bkg_1114 : esm_bkg_1114 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1114() {
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
 var iPage =1 ;
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var maxCtrl = 0;
 
 var comboObjects = new Array();
 var comboCnt = 0;
 
 var prefix = "sheet1_";


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
     
     function setComboObject(combo_obj){
     	comboObjects[comboCnt++] = combo_obj;
     }

     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
    	  ComBtnSetInquiry();
         for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
         }     
         
  		  doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
          ComSetFocus(document.form.cnt_cd);	
		  initControl();
		  
		  // Country 혹은 ZIP Code 에 값이 있으면 Retrieve 이벤트를 수행
		  ComSetObjValue(document.form.cnt_cd, document.form.sheet_cnt_cd.value);

    	  if(document.form.sheet_cnt_cd.value != "" || document.form.zip_cd.value != ""){
    	   	  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	  }
		 
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
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form'); 
           
          

      }
       /**
        * 콤보 초기설정값
        * @param {IBMultiCombo} comboObj  comboObj
        */
        function initCombo(comboObj) {
        	comboObj.DropHeight = 150;
        	
        }  
       
       
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		switch(event.srcElement.dataformat){
//	        case "engdn":
//	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        case "engup":
//	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//	            ComKeyOnlyAlphabet('upper');
//	            break;
//	        case "engupnum":
//	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//	            ComKeyOnlyAlphabet('uppernum');
//	            break;
	         case "etc": //모든 문자 가능하지만 영문은 대문자로
             if(keyValue >= 97 && keyValue <= 122) {//소문자
                 event.keyCode = keyValue + 65 - 97;
             }
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
 								
 								// 높이 설정
 								style.height = 350;
 								//전체 너비 설정
 								SheetWidth = mainTable.clientWidth;

 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msNone;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = true;

 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(1, 1, 3, 4999);
 								
 								var HeadTitle1 = "|Sel|Del.|Seq.|Zip Code|Country|State|City|Street P.O Box (Address)|By|Update Date";

 								var headCount = ComCountHeadTitle(HeadTitle1);

 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount+3, 0, 0, true);

 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, true, true, false,false);
 
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,	cnt++ , dtHiddenStatus,	 10,   daCenter,	true,	prefix +"ibflag");
  		             if(window.location.pathname.lastIndexOf("_Q") != -1){
 							    InitDataProperty(0,	cnt++ , dtRadioCheck,	 40,   daCenter,	true,	prefix +"Del",	       	 false,	"",		dfNone,		0,		true,	true);
		             }else { 		
								InitDataProperty(0,	cnt++ , dtDelCheck,		 40,   daCenter,	true,	prefix +"Del",	       	 false,	"",		dfNone,		0,		true,	true);
		             };							
 								InitDataProperty(0,	cnt++ , dtData,		     50,   daCenter,    true,	prefix +"delt_flg",	     false,	"",		dfNone,		0,		true,	false);
 								InitDataProperty(0,	cnt++ , dtSeq,		  	 50,   daCenter,	true,	prefix +"Seq",		     false,	"",		dfNone,		0,		true,	false); 								
 								InitDataProperty(0,	cnt++ , dtData,			 80,   daCenter,	true,	prefix +"zip_cd",	     true,	"",		dfNone,		0,		true,	true, 10);
								InitDataProperty(0,	cnt++ , dtData,			 80,   daCenter,	true,	prefix +"cnt_cd",	     true,	"",		dfNone,		0,		true,	false, 2);
  								InitDataProperty(0,	cnt++ , dtData,			 80,   daLeft,	    true,	prefix +"ste_nm",        false,	"",		dfNone,		0,		true,	true, 30);
								InitDataProperty(0,	cnt++ , dtData,			 80,   daLeft,	    true,	prefix +"cty_nm",        false,	"",		dfNone,		0,		true,	true, 30);
 								InitDataProperty(0,	cnt++ , dtData,			 250,  daLeft,		true,	prefix +"zip_dtl_addr",	 false,	"",		dfNone,		0,		true,	true, 100);
 								InitDataProperty(0,	cnt++ , dtData,			 60,   daCenter,	true,	prefix +"evnt_usr_id",   false,	"",		dfNone,		0,		true,	false);
 								InitDataProperty(0,	cnt++ , dtData,			 100,  daCenter,	true,	prefix +"evnt_dt",       false,	"",		dfNone,		0,		true,	false);
 								InitDataProperty(0,	cnt++ , dtHidden,		   0,  daCenter,	true,	prefix +"usr_nm",        false,	"",		dfNone,		0,		true,	false);
 								InitDataProperty(0,	cnt++ , dtHidden,		   0,  daCenter,	true,	prefix +"zip_cd_seq",    false,	"",		dfNone,		0,		true,	false);
 								InitDataProperty(0,	cnt++ , dtHidden,	 	   0,  daCenter,	true,	prefix +"saveCheck",     false,	"",		dfNone,		0,		true,	false);
 								
 								InitDataValid(0,    prefix +"cnt_cd",   vtEngUpOnly);
 								//InitDataValid(0,    "ste_nm",   vtEngUpOther);
 								//InitDataValid(0,    "cty_nm",   vtEngUpOther);
 								//InitDataValid(0,    "zip_dtl_addr",   vtUpOnly);
 								CountFormat = "[SELECTDATAROW / TOTALROWS]";
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
  							 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  						break;
  						
  						case "btn_Save":
  							 doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
  						break;
 						
  						case "btn_Delete":

  							 doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
  						break;
  						
  						case "btn_Add":
  							
  							var row = sheetObject1.DataInsert(-1);

  							sheetObject1.CellValue(row, prefix + "cnt_cd") = comboObjects[0].Code;
  							
  						break;
  						
  						case "btn_down_excel":
  							
  						 	if (sheetObject1.RowCount == 0 ) {
  						   		ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
  						   	    return;
  					  						   		
  							} else {
  								//ComOpenWait(true);
  								sheetObject1.SpeedDown2Excel(-1);
  								//ComOpenWait(false);
  						   	}

  						break;
  						
  						case "btn_Load_Excel":
  							sheetObject1.LoadExcel();
  							//sheetObject1.LoadExcel(1, 1, "", "-1", "-1", "", false, false, "1=>zip_cd");
  						break;
  						
  						case "btn_New":
   							 ComResetAll();
  		                	 doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
  			   				// ComBtnEnable("btn_Add");
  		    				// ComBtnEnable("btn_Delete");
  		    				// ComBtnEnable("btn_Save"); 
  		                	
    					break;
  						
  						
						case "btn_Select":
							zipCodePopupOK();
  						break;
 						
  						case "btn_close":
  		                    if(sheetObject1.IsDataModified){
  		                        if(ComShowCodeConfirm("BKG00168")){
  		                            window.close();
  		                        }
  		                    }else{
  		                        window.close();
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
   
      function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
          // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
      doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, PageNo);
       } 
      
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction, PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			case IBCLEAR:      //Combo조회

				formObj.f_cmd.value = SEARCH01;
			
			    //ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1114GS.do", FormQueryString(formObj));
				ComBkgXml2ComboItem2(sXml, formObj.cnt_cd, "cnt_cd", "cnt_nm" );
				
			break;
				
			case IBSEARCH:      //조회
			 if(validateForm(sheetObj,formObj,sAction)){   
			     formObj.f_cmd.value = SEARCH;   
			  
			     sheetObj.WaitImageVisible = false;
			     ComOpenWait(true);
		         sheetObj.DoSearch4Post("ESM_BKG_1114GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			 }						
		    break;
			
			case IBSAVE:        //100건씩 저장
				
		      	   	if(!validateForm(sheetObj,formObj,sAction)) return;
		    	   	if(sheetObj.RowCount == 0) return;
		    	   	
					formObj.f_cmd.value = MULTI;
					
					var paramSub = FormQueryString(formObj);
					
					// 입력, 수정, 삭제 인 행을 알아오기
					var sRow = sheetObj.FindStatusRow("I|U|D");

					// 받은 결과를 배열로 생성한다
					var arrRow = sRow.split(";");

					// 저장작업에 필요한 상수
					var xml = "";
					var last = arrRow.length - 1;
					
					// 한번에 저장하고 싶은 건수
					var count = 100;

					// 저장하기 전 작업
					ComOpenWait(true);
					
					// 실제 저장로직

					for(var idx=0; idx<last; idx+=count){
						
						for(var x=0; x<count; x++)
							if(idx+x<last)
								sheetObj.CellValue2(arrRow[idx+x], prefix + "saveCheck") = 1; //100건을 체크한다.
							
						var sheetData = sheetObj.GetSaveString(false, true, prefix + "saveCheck");
						xml = sheetObj.GetSaveXml("ESM_BKG_1114GS.do", paramSub + "&" + sheetData);
							
						if(xml.indexOf("OK")<0){
							alert("Failed to save");
							return;
						}
						
						for(var x=0; x<count; x++)
							if(idx+x<last)
								sheetObj.CellValue2(arrRow[idx+x], prefix + "saveCheck") = ""; //100건을 체크해제한다.
							
					}
					
					sheetObj.LoadSaveXml(xml);
					// 실제 저장로직 끝

					
					doActionIBSheet(sheetObj,formObj,IBSEARCH);

					break;		
						
			case IBDELETE:      // 삭제	 					
	        					
			      ComRowHideDelete(sheetObj, prefix + "Del");
			break;
			
            
             case IBSEARCHAPPEND:  // 페이징 조회
        
        		formObj.f_cmd.value = SEARCH;
                sheetObj.WaitImageVisible=true;  
        		sheetObj.DoSearch4Post("ESM_BKG_1114GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"), "iPage=" + PageNo, true);
        	break; 
 					
 			
 					
         }
         
        ComOpenWait(false);
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	     with(formObj){
        	  
         	 if (!ComChkValid(formObj)) return false;
         	 if (comboObjects[0].Code == "" ){
         		 if (sAction == IBSEARCH){
         			 ComShowCodeMessage('BKG00545', 'Country');
         			 formObj.cnt_cd.focus();
          		 }
         		 return false;
         	 }
         	 	 
          }

          return true;
      }
      /**
       * IBSheet 그리드에 입력된 zip code 의 중복 여부를 체크한다.
       */
      function dupSaupjaCheck(sheetObj) {
          var dRow = sheetObj.ColValueDup(prefix + "zip_cd", false);
          if (dRow != -1) {
              ComShowCodeMessage('COM12115', 'Zip Cpde: ['+sheetObj.CellValue(dRow, prefix + "zip_cd")+']');
              sheetObj.SelectCell(dRow, sheetObj.SaveNameCol(prefix + "zip_cd"));
              return false;
          } else {
              return true;
          }
      }

  	function sheet1_OnMouseMove(Button, Shift, X, Y) {
		//window.status = "OnMouseMove Row=" + Row + ", Col=" + Col + ", Text=" + sText;

		Row = sheetObjects[0].MouseRow;
		Col = sheetObjects[0].MouseCol;
		
        var colSaveName = sheetObjects[0].ColSaveName(Col);
		
		if(colSaveName == prefix + "evnt_usr_id") {
			sText = sheetObjects[0].CellText(Row, prefix + "usr_nm");
        } else {
		sText = "";
		}

		//풍선도움말 만들기
		sheetObjects[0].MouseToolTipText = sText;
		  
	}
    
  	function zipCodePopupOK() {
  		
  		var selectedRowForSave = sheetObjects[0].SelectRow;
  		var selectedDel = sheetObjects[0].CellValue(selectedRowForSave, prefix + "Del");

	  	  if(sheetObjects[0].TotalRows == 0 || selectedDel == 0){
	  				ComShowCodeMessage("COM12189");
	  				return;
		  }
  		
  		var retObj = getZipCodeInfoRows(selectedRowForSave);

  		if(callbackMethod == null){
  			self.close();
  		}else{
  			self.close();
  			callbackMethod(retObj);
  		}
  	}
  	
	function getZipCodeInfoRows(idx) {
		if(sheetObjects[0].TotalRows == 0) 
			return null;
		
		var cArray = new Array(); //열데이터를 담고 있는 배열
		cArray[0] = sheetObjects[0].CellValue(idx, prefix + "cty_nm");
		cArray[1] = sheetObjects[0].CellValue(idx, prefix + "ste_nm");
		cArray[2] = sheetObjects[0].CellValue(idx, prefix + "cnt_cd");
		cArray[3] = sheetObjects[0].CellValue(idx, prefix + "zip_cd");
		cArray[4] = sheetObjects[0].CellValue(idx, prefix + "zip_dtl_addr");

    	return cArray;
	}

	/* 개발자 작업  끝 */