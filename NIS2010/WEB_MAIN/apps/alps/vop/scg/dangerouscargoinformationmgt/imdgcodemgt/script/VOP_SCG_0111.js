/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_SCG_0111.js
*@FileTitle : DG Cargo Package Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.07
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.06.07 KIM HYUN HWA
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
     * @class VOP_SCG_0111 : VOP_SCG_0111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_SCG_0111() {
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

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var opener = window.dialogArguments;

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

    				case "btn_retrieve":
    					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    					break;    				
    				
    				case "btn_select":
    					
    					var row1 = sheetObjects[0].FindText("selChk", "1", 0, 2);    					
    					
    					//var row2 = row1.replace("|","");  
    					
    					if(row1 < 1){   						
    						
    						return;
    					}
    					
    					if(document.getElementById("pck_tp_seq").value == "1"){
    						
    						opener.document.getElementById("out_imdg_pck_cd1").value = sheetObjects[0].CellValue(row1, "imdg_pck_cd");	
    						opener.document.getElementById("out_imdg_pck_desc1").value = sheetObjects[0].CellValue(row1, "imdg_pck_desc");	
    						
    					}else if(document.getElementById("pck_tp_seq").value == "2"){
    						
    						opener.document.getElementById("out_imdg_pck_cd2").value = sheetObjects[0].CellValue(row1, "imdg_pck_cd");	
    						opener.document.getElementById("out_imdg_pck_desc2").value = sheetObjects[0].CellValue(row1, "imdg_pck_desc");
    						
    					}else if(document.getElementById("pck_tp_seq").value == "3"){
    						
    						opener.document.getElementById("intmd_imdg_pck_cd1").value = sheetObjects[0].CellValue(row1, "imdg_pck_cd");	
    						opener.document.getElementById("intmd_imdg_pck_desc1").value = sheetObjects[0].CellValue(row1, "imdg_pck_desc");
    						
    					}else if(document.getElementById("pck_tp_seq").value == "4"){
    						
    						opener.document.getElementById("intmd_imdg_pck_cd2").value = sheetObjects[0].CellValue(row1, "imdg_pck_cd");	
    						opener.document.getElementById("intmd_imdg_pck_desc2").value = sheetObjects[0].CellValue(row1, "imdg_pck_desc");  
    						
    					}else if(document.getElementById("pck_tp_seq").value == "5"){
    						
    						opener.document.getElementById("in_imdg_pck_cd1").value = sheetObjects[0].CellValue(row1, "imdg_pck_cd");	
    						opener.document.getElementById("in_imdg_pck_desc1").value = sheetObjects[0].CellValue(row1, "imdg_pck_desc");
    						
    					}else{
    						
    						opener.document.getElementById("in_imdg_pck_cd2").value = sheetObjects[0].CellValue(row1, "imdg_pck_cd");	
    						opener.document.getElementById("in_imdg_pck_desc2").value = sheetObjects[0].CellValue(row1, "imdg_pck_desc");    						
    					}    					
    					
    					window.close();
    					
    					break;
    							
    				case "btn_close":
    					
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
            checkRetrieve();
            
            
        }
         
         
         function initControl() {    	  
     	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)    	   
     	    
     	    axon_event.addListenerForm('keydown','obj_keydown', 	form);   
     	    axon_event.addListenerForm('change','obj_change', form);
      }   
         
         function checkRetrieve(){      	              

        	 document.getElementById("imdg_pck_tp_cd").value = opener.document.getElementById("imdg_pck_tp_cd").value;
             document.getElementById("imdg_pck_cd").value = opener.document.getElementById("temp_pck_tp_cd").value;           
             document.getElementById("pck_tp_seq").value = opener.document.getElementById("pck_tp_seq").value;
        	 
             if(document.getElementById("imdg_pck_tp_cd").value == "O"){
            	 document.getElementById("imdg_pck_cd_text").innerHTML = "( Outer )";
            }else if(document.getElementById("imdg_pck_tp_cd").value == "M"){
            	 document.getElementById("imdg_pck_cd_text").innerHTML = "( Intemediate )";
            }else{
            	 document.getElementById("imdg_pck_cd_text").innerHTML = "( Inner )";
            }
             
             if(document.getElementById("imdg_pck_cd").value != ""){
             	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
             }
        	 
         }
         
       
       function obj_keydown(){
   		
   		if (event.keyCode == 13){ // Enter Key
   			
   			switch (event.srcElement.name) {	
   				
   				case "imdg_pck_cd":
   					document.getElementById("imdg_pck_cd").value = (document.getElementById("imdg_pck_cd").value).toUpperCase();
   					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 	
   				break;
   				
   				case "imdg_pck_desc":    					
   					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 	
   				break;
   				
   				
   			}
   		}
   	}   
       
       function obj_change(){
      		
      		switch (event.srcElement.name) {	
      				
      			case "imdg_pck_cd":
      				document.getElementById("imdg_pck_cd").value = (document.getElementById("imdg_pck_cd").value).toUpperCase();
      				 	
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

    		switch(sheetObj.id) {
    			case "sheet1":      //sheet1 init
    				with (sheetObj) {

    					// 높이 설정
    					style.height = 430;
    					
    					//전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 15, 100);

    					var HeadTitle1 = "|Sel.|Code|Description";
    					var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
    					
    					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,   	"ibflag");
    					
    					InitDataProperty(0, cnt++ , dtRadioCheck,	40,	daCenter,	true,	"selChk",	false,	"",      dfNone,	0,true,	true);
    					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"imdg_pck_cd",	false,	"",      dfNone,	0,false,	true);
    					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,	"imdg_pck_desc",	false,	"",      dfNone,	0,false,	true);
    				
    					CountPosition = 0;
    				
    				}
    			break;


        }
    }


        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

    				case IBSEARCH:      //조회
    				if(validateForm(sheetObj,formObj,sAction)) {
    					formObj.f_cmd.value = SEARCH;
    					sheetObj.DoSearch("VOP_SCG_0043GS.do", FormQueryString(formObj));   
    					
    					if(document.getElementById("imdg_pck_desc").value == "" && sheetObj.RowCount == "1"){
    						document.getElementById("imdg_pck_desc").value = sheetObjects[0].CellValue(1, "imdg_pck_desc")
    					}
    				}
    				break;   				
            }
        }


        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
            }

            return true;
        }
        
	/* 개발자 작업  끝 */