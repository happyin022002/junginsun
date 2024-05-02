/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0005.js
*@FileTitle : Canal booking status for Panama
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.12 김성광
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
     * @class vop_pso_0013 : vop_pso_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0013() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initControl 			= initControl;
    	this.obj_deactivate         = obj_deactivate;
    	this.obj_activate 			= obj_activate;
    	this.obj_keyup 				= obj_keyup;
    	this.obj_keypress 			= obj_keypress;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnScrollNext 	= sheet1_OnScrollNext;
    	this.sheet1_OnMouseMove 	= sheet1_OnMouseMove;
    	this.sheet1_OnChange 		= sheet1_OnChange;
    	this.sheet1_OnMouseDown 	= sheet1_OnMouseDown;
    	this.noDataUnCheckedHeader 	= noDataUnCheckedHeader;
    	this.setChecking 			= setChecking;
    }
    
   	/* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

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
            
	            case "btn_DownExcel":
	        	    if(sheetObject1.RowCount <= 0){
	        	        ComCodeMsgByNoRelatedData();  // There is no related data!
	        	        return;
	        	    }else{
	        	        if(sheetObject1.RowCount > 0){
	        	        	sheetObject1.Down2Excel(-1,true,true,true,"","",false,false,"Canal booking status for Panama");  //hidden 필드내려받지않음.
	        	        }
	        	    } 
	        	    break;            
            	
	            case "btns_Calendar":
	            	var cal = new ComCalendarFromTo();
	            	cal.select(formObject.str_dt,  formObject.end_dt,  'yyyy-MM-dd');
	            	break;

	            case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
	            case "btn_Save":
	            	doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
	            	break;
	            	
				default : break;
				
            } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("SPP01003");
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

            for(i=0;i<sheetObjects.length;i++){
            	//khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            initControl();

        }
        
        /**
         * Form데이터포멧 키 프레스 관련 
         */
         function initControl() {
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBlur 이벤트에 코드 처리        	 
			 axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form); 
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnFocus 이벤트에 코드 처리
			 axon_event.addListenerFormat('focus', 	'obj_activate',    	form);
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyUp 이벤트에 코드 처리
			 axon_event.addListenerFormat('keyup',  'obj_keyup',    	form); 	
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyPress 이벤트에 코드 처리
			 axon_event.addListenerFormat('keypress', 'obj_keypress',   form);
			   
	         setToday(document.form.str_dt, "ymd"); 
	         //document.form.str_dt.value = "20090501";  //test용
	         document.form.end_dt.value = ComGetDateAdd(document.form.str_dt.value, "M", 1);

	         document.form.end_dt.focus();
	         document.form.str_dt.focus();
	         
	         //header 색상 변경
			 sheetObjects[0].CellBackColor(1, "sheet1_"+"b_sts_cd") = sheetObjects[0].CellBackColor(0, 0);
			 sheetObjects[0].CellBackColor(1, "sheet1_"+"c_sts_cd") = sheetObjects[0].CellBackColor(0, 0);
			 sheetObjects[0].CellBackColor(1, "sheet1_"+"a_sts_cd") = sheetObjects[0].CellBackColor(0, 0);
      	 }  
         
         /*
         * OnBlur 이벤트에 코드 처리
         */
         function obj_deactivate(){
     	     obj = event.srcElement;
             if(!ComChkObjValid(event.srcElement)) return;
             
             var formObj = document.form;
             var srcName = obj.getAttribute("name");
             switch(srcName){
                 case "str_dt":
                 case "end_dt":
                	 if(formObj.str_dt.value=="" || formObj.end_dt.value=="") break;
                	 //from date 와 to date 에 입력한 날짜의 유효성 체크. from 값이 to 값보다 항상 작게 입력.
                	 checkFromTo(formObj.str_dt, formObj.end_dt);
                	 break;
                	 
                 default:
                	 break;
             }
         }
        
         /*
         * OnFocus 이벤트에 코드 처리
         */
         function obj_activate(){
       	     obj = event.srcElement;
             ComClearSeparator(event.srcElement);    
             ComShowFocusCursor(obj);  //특정 event 로 인해서 사라진 포커스를 보여줌.
         }  
         
         /*
          * OnKeyUp 이벤트에 코드 처리
          */ 
         function obj_keyup(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
    	           case "str_dt":
        	    	   ComKeyEnter('LengthNextFocus');  //maxlength 까지 값이 입력되면 자동으로 다음 object 로 커서 이동.
        		       break;
        		   default:
        			   break;
        	   }
         }
          
         /*
          * OnKeyPress 이벤트 처리
          */
          function obj_keypress(){
         	  obj = event.srcElement;
           	  var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
         	    
           	  if(obj.dataformat == null) return;
         	    
         	  if(keyValue == 13 ){
         	    	//필수 입력 조건인 WorkMonth의 값이 설정 되어있는가를 확인한다.
         	    	var formObj = document.form;
             	  	
			  	 	if(ComIsEmpty(formObj.str_dt.value)){
			  	 		ComCodeMsgByEmptyData("str_dt");
			  	 		formObj.str_dt.focus();
			  	 		return;
			  	 	}  
			  	 	if(ComIsEmpty(formObj.end_dt.value)){
			  	 		ComCodeMsgByEmptyData("end_dt");
			  	 		formObj.end_dt.focus();
			  	 		return;
			  	 	}              	  	
             	  	
             	  	//조회
             	  	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            	  	
         	    	return true;
         	  }
         	    
           	  window.defaultStatus = obj.dataformat;        	  
        	  
              switch(event.srcElement.dataformat){
          	      case "ymd":
          	        //숫자만입력하기
          	        ComKeyOnlyNumber(event.srcElement);          	        
          	        break;
          	        
          	      default:
          	        //숫자만입력하기
          	        ComKeyOnlyNumber(event.srcElement);
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
    	  var sheetid = sheetObj.id;
    	  var onepagerows = document.form.pagerows.value;
          switch(sheetid) {

    				case "sheet1":
    					with (sheetObj) {
    							// 높이 설정
    							style.height = 360;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host 정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = true;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(2, 1, 3, onepagerows);  //100 -  페이지처리시 페이지당 레코드수

    							var HeadTitle1 = "|VVD|Lane|Vessel Name|Coastal Schedule|Coastal Schedule|Coastal Schedule|Booking |Cancel |Auction |Hidden1|Hidden2|Hidden3|Hidden4";
    							var HeadTitle2 = "|VVD|Lane|Vessel Name|ETA|ETB|ETD|Booking|Cancel|Auction|Hidden1|Hidden2|Hidden3|Hidden4";	  
    							
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다. [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
    							InitHeadMode(true, true, true, true, false, false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							InitHeadRow(1, HeadTitle2, true);

    							var prefix = "sheet1_";
    							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"vvd",		false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"vsl_slan_cd",false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			128,	daCenter,	true,	prefix+"vsl_nm",	false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			98,		daCenter,	true,	prefix+"vps_eta_dt",false,	"",	dfNone,		0,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtData,			98,		daCenter,	true,	prefix+"vps_etb_dt",false,	"",	dfNone,		0,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtData,			98,		daCenter,	true,	prefix+"vps_etd_dt",false,	"",	dfNone,		0,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtCheckBox,		66,		daCenter,	true,	prefix+"b_sts_cd",	false,	"",	dfNone,		0,	true,	true);
    							InitDataProperty(0, cnt++ , dtCheckBox,		57,		daCenter,	true,	prefix+"c_sts_cd",	false,	"",	dfNone,		0,	true,	true);
    							InitDataProperty(0, cnt++ , dtCheckBox,		63,		daCenter,	true,	prefix+"a_sts_cd",	false,	"",	dfNone,		0,	true,	true);
    							
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"pso_bztp_cd");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"vsl_cd");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"skd_voy_no");
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"skd_dir_cd");

    							CountFormat = "[SELECTDATAROW / TOTALROWS]";  //페이지처리시 전체 데이터수를 표시.
    																	      //default 설정은 CoObject.js => "[SELECTDATAROW / ROWCOUNT]"
    							
    						}
    						break;
    						
            }
        }

        /*
         * Sheet관련 프로세스 처리 
         */
        function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

              case IBSEARCH:      //조회
              	if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id == "sheet1"){
						var prefix = "sheet1_";
						formObj.f_cmd.value = SEARCH;
						ComClearFormSeparator(formObj);  //마스크  제거
						var CondParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
						var PageParam = "i_page=1";
						
    					//헤더의 체크박스 체크 후 조회를 할 경우 해당 체크박스가 해제 되지 않는 현상때문에
    					//체크박스 해제시킨 후 조회함.
    					sheetObj.CheckAll2(prefix+"b_sts_cd") = 0;
    					sheetObj.CheckAll2(prefix+"c_sts_cd") = 0;
    					sheetObj.CheckAll2(prefix+"a_sts_cd") = 0;
    					
						sheetObj.DoSearch4Post("EXP_SPP_0005GS.do", CondParam, PageParam);
						ComSetFormSeparator(formObj);  //마스크 다시 셋팅
						
    					//조회된 건수가 없으면 break
    					if(sheetObj.TotalRows==0) break;  //TotalRows : R 상태의 데이터 수

					}
              	}
    		    break;
    		    
              case IBSEARCHAPPEND:  //페이지처리
                if(validateForm(sheetObj,formObj,IBSEARCH)){            	  
	           		if(sheetObj.id == "sheet1"){
	           			var prefix = "sheet1_";
	  	            	formObj.f_cmd.value = SEARCH;
	  	            	ComClearFormSeparator(formObj);  //마스크  제거
	  	            	var PageParam = "i_page=" + PageNo;
	  	                sheetObj.DoSearch4Post("EXP_SPP_0005GS.do", CondParam, PageParam, true);  //true - 조회된 내용을 이어서(append) 쓸지 여부
	  	                ComSetFormSeparator(formObj);  //마스크 다시 셋팅
	  	              
	  	                //조회된 건수가 없으면 break
	  	                if(sheetObj.TotalRows==0) break;  //TotalRows : R 상태의 데이터 수	  	

	           		}
                }
                  break;    		    

    		  case IBSAVE:        //저장
                if(validateForm(sheetObj,formObj,sAction)){
	           		if(sheetObj.id == "sheet1"){
	           			var prefix = "sheet1_";
	           			
	  	    		  	//transaction 발생한 건이 없을 경우 return
	  					if (!sheetObj.IsDataModified) {				
	  						ComCodeMsgByNoContentsSave();
	  						return; 
	  					}
	           			
	  	            	formObj.f_cmd.value = MULTI;
	  	            	
	  	    		    ComClearFormSeparator(formObj);  //마스크  제거 
	  					var sParam = FormQueryStringOrg(formObj);
	  					ComSetFormSeparator(formObj);  //마스크 다시 셋팅
	  					
	  					var sParam1 = sheetObj.GetSaveString();
	  					
	  					if (sParam1 == "") {
	  						ComCodeMsgByNoContentsSave();
	  						return; 
	  					}
	  					
	  	    		  	// 저장하시겠습니까?
	  	    			if(!ComCodeMsgBySave()) return;   
	  	    		  	
	  					sParam = sParam + "&" + sParam1;
	  					
	  	    		  	//저장. 저장 후 OnSaveEnd 이벤트 발생
	  					//sheetObj.ShowDebugMsg = true;
	  	    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0005GS.do", sParam);
	  	    			//sheetObj.ShowDebugMsg = false;
	  	    			sheetObj.LoadSaveXml(sXml);  //저장된 내용 sheet 에 반영 후 OnSaveEnd 이벤트 발생
	  	    										 //저장 후 새로 조회하지 않아도 됨.
	  	    			
	  	    			//OnSaveEnd 후에 실행된다.
	                	if(ComSaveXml2ScssTF(sXml, "TR-ALL", 0)){
	                		//저장 성공 후 work
	                		
	                	}	  					
	           		}
                }
                break;
            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
             switch(sAction){
		       	 case IBSEARCH:	//조회
			  	 	if(ComIsEmpty(formObj.str_dt.value)){
			  	 		ComCodeMsgByEmptyData("str_dt");
			  	 		return false;
			  	 	}  
			  	 	if(ComIsEmpty(formObj.end_dt.value)){
			  	 		ComCodeMsgByEmptyData("end_dt");
			  	 		return false;
			  	 	}          	 	
			  	 	break;
			  	 	
		       	 case IBSAVE:  //SAVE
			  	 	if(ComIsEmpty(formObj.str_dt.value)){
			  	 		ComCodeMsgByEmptyData("str_dt");
			  	 		return false;
			  	 	}  
			  	 	if(ComIsEmpty(formObj.end_dt.value)){
			  	 		ComCodeMsgByEmptyData("end_dt");
			  	 		return false;
			  	 	} 		       	 
		       	    break;
			  	 	
	             default:
		            break;			  	 	
             }
             return true;
        }
         
        /**
     	 * sheet1_OnScrollNext 페이지처리
     	 */
     	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
     		//OnePageRows - InitRowInfo 에서 설정한 한페이지당 row count. document.form.pagerows.value 와 동일.
     		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
     	}
     	
     	/**
     	* sheet1_OnMouseMove 이벤트 처리. 
     	* tooltip 처리
     	*/
     	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {	
      		var prefix = "sheet1_";
      		var Row = sheetObj.MouseRow;
      		var Col = sheetObj.MouseCol;
      		var colId = sheetObj.ColSaveName(Col);
     		if (Row>=sheetObj.TopRow && colId==prefix+"vsl_nm"){
     			sheetObj.MouseToolTipText = sheetObj.CellText(Row, Col);		   
     		} else {
     			sheetObj.MouseToolTipText = "";
     		}      
     	}     	 
     	 
        /**
      	 * sheet1_OnChange 이벤트 처리. 
      	 * sheet1 의 데이터가 있는 행에 대해서만.
      	 * 데이터행의 체크박스 처리를 위해서 이 이벤트를 활용했음.
      	 */
      	function sheet1_OnChange(sheetObj, Row, Col, Value) {
      		//alert(Row +"/"+ Col +"/"+ Value);
      	    //[체크된값]이 아니면 실행하지 않는다.
      		if(Value==0) return;
      		
      		var prefix = "sheet1_";
      		var colId = sheetObj.ColSaveName(Col);
  			switch(colId){
				case prefix+"b_sts_cd":
						//sheetObj.CellValue2(Row, prefix+"b_sts_cd") = 1;
						sheetObj.CellValue2(Row, prefix+"c_sts_cd") = 0;
						sheetObj.CellValue2(Row, prefix+"a_sts_cd") = 0;
					break;
				case prefix+"c_sts_cd":
						sheetObj.CellValue2(Row, prefix+"b_sts_cd") = 0;
						//sheetObj.CellValue2(Row, prefix+"c_sts_cd") = 1;
						sheetObj.CellValue2(Row, prefix+"a_sts_cd") = 0;
					break;
				case prefix+"a_sts_cd":
						sheetObj.CellValue2(Row, prefix+"b_sts_cd") = 0;
						sheetObj.CellValue2(Row, prefix+"c_sts_cd") = 0;
						//sheetObj.CellValue2(Row, prefix+"a_sts_cd") = 1;
					break;
					
				default:
					break;
			}      		
      	}  
      	
        /**
      	 * sheet1_OnMouseDown 이벤트 처리. 
      	 * sheet1 의 어떤 영역이든 마우스가 눌러졌을때.
      	 * 헤더행의 체크박스 처리를 위해서 이 이벤트를 활용했음.
    	 * 이벤트작동순서 : OnMouseDown=>OnBeforeCheck=>(AllowCheck이 True 인 경우 이벤트 지속)=>OnClick=>OnClick2=>OnChange 이벤트
      	 */
      	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) { 
      		//alert(sheetObj.MouseRow +"/"+ sheetObj.MouseCol);
      		var prefix = "sheet1_";
      		var Row = sheetObj.MouseRow;
      		var Col = sheetObj.MouseCol;
      		var colId = sheetObj.ColSaveName(Col);
      		
      		//데이터행의 최상단행보다 작은 헤더 영역에서 이벤트 발생시
      		if(Row>=0 && Row<sheetObj.TopRow){
      			switch(colId){
      				case prefix+"b_sts_cd":
      				    //데이터가 없을 경우 헤더의 체크박스가 체크되지 않도록 처리.
      					if(noDataUnCheckedHeader(sheetObj, prefix+"b_sts_cd")) break;
      					//setChecking(sheetObj, prefix+"c_sts_cd");
      					//setChecking(sheetObj, prefix+"a_sts_cd");
      					break;
      					
      				case prefix+"c_sts_cd":
      				    //데이터가 없을 경우 헤더의 체크박스가 체크되지 않도록 처리.
      					if(noDataUnCheckedHeader(sheetObj, prefix+"c_sts_cd")) break;
      					//setChecking(sheetObj, prefix+"b_sts_cd");
      					//setChecking(sheetObj, prefix+"a_sts_cd");
      					break;
      					
      				case prefix+"a_sts_cd":
      				    //데이터가 없을 경우 헤더의 체크박스가 체크되지 않도록 처리.
      					if(noDataUnCheckedHeader(sheetObj, prefix+"a_sts_cd")) break;
      					//setChecking(sheetObj, prefix+"b_sts_cd");
      					//setChecking(sheetObj, prefix+"c_sts_cd");
      					break;
      					
      				default:
      					break;
      			}
      		}//
      		
      		//데이터 행에서 이벤트 발생시.
      		else if(Row>=sheetObj.TopRow){
      			
          		var prefix = "sheet1_";
          		var colId = sheetObj.ColSaveName(Col);
      			switch(colId){
    				case prefix+"b_sts_cd":
    				case prefix+"c_sts_cd":
    				case prefix+"a_sts_cd":
    					
    					//Coastal Schedule 값이 존재하지 않을 경우 체크박스 체크되지 않도록 처리. 
    	           		//sheet1_OnBeforeCheck 에서 처리하려고 했지만 되지 않음.
    	           		if(   sheetObj.CellValue(Row, prefix+"vps_eta_dt")!=''
    	           		   && sheetObj.CellValue(Row, prefix+"vps_etb_dt")!=''
    	           		   && sheetObj.CellValue(Row, prefix+"vps_etd_dt")!=''){
    	           			break; 
    	           		}
    	           		
    					sheetObj.RowEditable(Row) = false;
    					//비록 Editable 불가능이지만 화면상에는 EditableColor(default:RGB(255,255,255)) 색으로 표시함.
    					sheetObj.CellBackColor(Row, prefix+"b_sts_cd") = sheetObj.EditableColor;
    					sheetObj.CellBackColor(Row, prefix+"c_sts_cd") = sheetObj.EditableColor;
    					sheetObj.CellBackColor(Row, prefix+"a_sts_cd") = sheetObj.EditableColor;
    					break;
    					
    				default:
    					break;
      			}
      		}//
      		
      		
      	}
      	
      	/**
      	 * 데이터가 없을 경우 헤더의 체크박스가 체크되지 않도록 처리.
      	 */ 
      	function noDataUnCheckedHeader(sheetObj, colId){
			if(sheetObj.RowCount==0){
					sheetObj.CheckAll2(colId) = 2;
					return true;
			}
			return false;
      	}
      	
        /**
       	 * 체크된 행 번호 읽기. 
       	 * 헤더의 체크 해제. 
       	 * 체크된 행의 번호를 받아서 체크 재셋팅한다.
       	 */
      	function setChecking(sheetObj, colId){
       	    sheetObj.Redraw = false;       		 
      		//체크된 행 번호 읽기
			var iCheckRows = sheetObj.FindCheckedRow(colId);  
			//헤더의 체크 해제
			sheetObj.CheckAll2(colId) = 0;
			//체크 재셋팅
      	    var arrRow = iCheckRows.split("|");
      	    var intArrLen = arrRow.length-1;
      	    for (idx=0; idx<intArrLen; idx++){
      	    	sheetObj.CellValue2(arrRow[idx], colId) = 1;
      	    }
      	    sheetObj.Redraw = true;
      	}

      	
      	

	/* 개발자 작업  끝 */