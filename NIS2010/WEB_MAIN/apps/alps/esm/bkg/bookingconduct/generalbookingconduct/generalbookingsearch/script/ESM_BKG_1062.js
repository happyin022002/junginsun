/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1062.js
*@FileTitle : TAA Search
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2010.01.25 김병규
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
     * @class ESM_BKG_1062 : ESM_BKG_1062 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1062() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

    /**
    * Customer Inquiry(공통Popup) 호출후 Return받는 함수. <br>
    * <br><b>Example :</b>
    * <pre>
    *     callBackShpr(arrBal);
    * </pre>
    * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
    * @return 없음
    * @author 김병규
    * @version 2009.07.22
    */    	
   function callBackShpr(rArray){
  		var formObject = document.form;
  		if(rArray != null){
  			formObject.s_cust_cnt_cd.value = rArray[0][3].substring(0,2);
  			formObject.s_cust_seq.value = rArray[0][3].substring(2);
  			formObject.s_cust_nm.value = rArray[0][4];
  		}  		    	 
    }	    

   /**
    * Customer Inquiry(공통Popup) 호출후 Return받는 함수. <br>
    * <br><b>Example :</b>
    * <pre>
    *     callBackCnee(arrBal);
    * </pre>
    * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
    * @return 없음
    * @author 김병규
    * @version 2009.07.22
    */    	
   function callBackCnee(rArray){
  		var formObject = document.form;
  		if(rArray != null){
  			formObject.c_cust_cnt_cd.value = rArray[0][3].substring(0,2);
  			formObject.c_cust_seq.value = rArray[0][3].substring(2);
  			formObject.c_cust_nm.value = rArray[0][4];
  		}  		    	 
    }	     
   	/* 개발자 작업	*/
 // 공통전역변수

    var comboObjects = new Array();
    var comboCnt = 0;     
    
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

					case "btn_Retrieve":
						if(validateForm(formObject)){
							doActionIBSheet(sheetObject,formObject,IBSEARCH);	
						}    																
					break; 
					case "btn_Shpr":
		        		var custCd = formObject.s_cust_cnt_cd.value+formObject.s_cust_seq.value;
		        		ComOpenPopup('/hanjin/COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd='+custCd, 770, 470, "callBackShpr", '0,1,1,1,1,1,1', true);									
					break; 
					case "btn_Cnee":
						var custCd = formObject.c_cust_cnt_cd.value+formObject.c_cust_seq.value;
		        		ComOpenPopup('/hanjin/COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd='+custCd, 770, 470, "callBackCnee", '0,1,1,1,1,1,1', true);															
					break;     							
					case "btn_Select":
						comPopupSend(sheetObject, formObject);	
					break;
					
					case "btn_Taa":
						var rArray = getCheckedRowsByName(sheetObject, "chk");
						if(rArray != null){
							var taaNo = rArray[0][5];
							if(ComIsNull(taaNo)){
							   return false;
							}
							if(taaNo.length > 3){
							   if(taaNo.substring(0,3) == "DUM"){
								   return false;
							   }
							}else{
							   return false;
							}
						}
						var pgmNo = "ESM_PRI_3007";        // TAA Main Program No
						var pgmUrl = "/hanjin/ESM_PRI_3007.do"        // TAA Main 화면 url
						var params = "&cond_taa_no=" + taaNo;    // 조회할 TAA NO 입력. 이 부분만 수정하시면 됨.
						var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
						var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
						var sUrl = "alpsMain.screen?parentPgmNo=" + parentPgmNo + src;

						var iWidth = 1024;
						var iHeight = 700;

						// 화면 중앙에 팝업창을 위치시키기 위한 소스이므로 안써도 무방.
						// 안 쓸 경우 하단의 팝업 옵션에서 left와 top은 삭제
						var leftpos = (screen.width - iWidth) / 2;
						if (leftpos < 0)
						    leftpos = 0;
						var toppos = (screen.height - iHeight) / 2;
						if (toppos < 0)
						    toppos = 0;

						var sFeatures = "status=no, resizable=yes, scrollbars=yes, width="+iWidth+", height="+iHeight+", left="+leftpos+", top="+toppos;
						ComOpenWindow(sUrl, "", sFeatures);	   
					break;
    								    
//    								var rArray = getCheckedRowsByName(sheetObject, "chk");
//    								if(rArray != null){
//        								var taaNo = rArray[0][5];
//        								var isPop = true;
//        								if(ComIsNull(taaNo)){
//    									   isPop = false;
//        								}
//        								if(isPop && taaNo.length > 3){
//    									   if(taaNo.substring(0,3) == "DUM"){
//    										   isPop = false;
//    									   }
//        								}else{
//    									   isPop = false;
//        								}
//        								if(isPop){
//    								      var pgmNo = "ESM_PRI_2019";
//    								      var pgmUrl = "/hanjin/ESM_PRI_2019.do";
//    								      var params = "&s_rfa_no=" + rfaNo;  //==> RFA No.
//    								      var parentPgmNo = pgmNo.substring(0, 8) + 'M001';   
//    								      var src = "&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
//    								      var sFeatures = "status=no; dialogWidth=1024px; dialogHeight=700px; resizable=no; scrollbars=yes";   
//    								      var winObj = window.showModalDialog("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);									      
//        								}     									
//    								}
					case "btn_Close":
						window.close();
					break;


                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COM12111");     
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
  * 콤보 초기설정값
  * @param {IBMultiCombo} comboObj  comboObj
  */
	function initCombo(comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.SetColAlign("left|left");
		comboObj.MultiSeparator = "|";	
	}
  /**
   * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
   * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
   **/
   function setComboObject(combo_obj){
     comboObjects[comboCnt++] = combo_obj;
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

   	    // IBMultiCombo초기화
   	    for(var j=0; j<comboObjects.length; j++){
   	        initCombo(comboObjects[j]);
   	    }	    
			
	}

 	 function sheet1_OnLoadFinish(sheetObj) {   
		 sheetObj.WaitImageVisible = false;   
		 doActionIBSheet(sheetObjects[0],document.form,INIT);
		    
		 initControl();    
		 sheetObj.WaitImageVisible = true;   
	 }       	 
	 
	function initControl() {
   	 	var formObject = document.form;
   	
        axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
                        style.height = 240;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 3, 100);

    					          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(9, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle = "|TP|Customer Code|Customer Code|Customer Name|TAA Number|Sales OFC|Service Scope|Service Scope";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtRadioCheck, 	30,    daCenter,  		false,     	"chk");     
                        InitDataProperty(0, cnt++ , dtData,           	30,   	daCenter,    	false,     	"cust_tp_cd",   		false,    "",      dfNone, 		0,     false,    false);                        
                        InitDataProperty(0, cnt++ , dtData,		  		50,   	daCenter,    	false,     	"cust_cnt_cd",   		false,    "",      dfNone, 		0,     false,    false);      
                        InitDataProperty(0, cnt++ , dtData,           	70,   	daCenter,    	false,     	"cust_seq",   	 		false,    "",      dfNone, 		0,     false,    false);
                        InitDataProperty(0, cnt++ , dtData, 	 			330,  	daLeft,	    	false,     	"cust_lgl_eng_nm", 	false,    "",      dfNone, 		0,     false,    false);
                        InitDataProperty(0, cnt++ , dtData,          	100,  	daCenter,   	false,     	"taa_no",    			false,    "",      dfNone, 		0,     false,    false);                                                                                                           
                        InitDataProperty(0, cnt++ , dtData,          	80,   	daCenter,    	false,     	"sales_ofc",      		false,    "",      dfNone, 		0,     false,    false);
                        InitDataProperty(0, cnt++ , dtData, 	 			35,   	daCenter,    	false,     	"svc_scp_cd",   		false,    "",      dfNone, 		0,     false,    false);
                        InitDataProperty(0, cnt++ , dtData, 	 			200,   	daCenter,    	false,     	"svc_scp_nm",   		false,    "",      dfNone, 		0,     false,    false);
              
              
                   }
                    break;
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
				case INIT:      // 최초로딩시
					formObj.f_cmd.value = INIT;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESM_BKG_1062GS.do" , FormQueryString(formObj));
					ComOpenWait(false); 
					var arrXml = sXml.split("|$$|");  
					if (arrXml.length > 0){
	    				ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "svc_scp_cd", "svc_scp_nm");
					}     	        						
					if (arrXml.length > 1){	
						sheetObj.LoadSearchXml(arrXml[1]);
					}       		
				break;            
				case IBSEARCH:      //조회
					formObj.f_cmd.value = SEARCH;
					ComOpenWait(true);
					sheetObj.DoSearch("ESM_BKG_1062GS.do" , FormQueryString(formObj));
					ComOpenWait(false); 
				break;
            }
        }

    	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    	{		
    		if(ErrMsg == ""){
    			if(sheetObj.RowCount < 1){
    				var idx = sheetObj.DataInsert(-1);
    				sheetObj.CellValue(idx, "cust_lgl_eng_nm") = "DUMMY CUSTOMER";
    				sheetObj.CellValue(idx, "taa_no") = "DUM0000001";
    			}
    		}
    	}      
      
    	// Scope Combo List 선택시
    	function svc_scp_cd_list_OnChange(Code, Text){
    		document.form.svc_scp_cd.value = comboObjects[0].Code;
    	}      
    	
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(formObj){
        	 if(ComIsNull(formObj.s_cust_cnt_cd.value) && ComIsNull(formObj.c_cust_cnt_cd.value)){
        		 ComShowCodeMessage("BKG00625");
        		 return false;
        	 }

            return true;
        }

     	//double click -> select
         function sheet1_OnDblClick(sheetObj , row, col) {  
        	 	var formObj = document.form;
        	 	sheetObj.CellValue2(row,"chk") = "1";
        	 	comPopupSend(sheetObj, formObj);
         }     

         /**
          * 화면정보를 Main에 전달한다.
          */     
 		function comPopupSend(sheetObj, formObj){
 			var calllFunc = formObj.calllFunc.value;
 			var rArray = getCheckedRowsByName(sheetObj, "chk");
         	if(rArray == null) {
				ComShowCodeMessage("COM12114", "row");
				return;
			}else{
	 			eval('window.dialogArguments.'+calllFunc)(rArray);
	 			window.close();
			}
 		}     	
         
	/* 개발자 작업  끝 */