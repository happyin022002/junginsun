/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : fns_joo_0086.js
*@FileTitle : Add Carriers POP UP화면
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.05
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.01.04 김영오
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @extends 
     * @class fns_joo_0086 : fns_joo_0086 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0086() {
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
// var comboObjects = new Array();
// var comboCnt = 0;
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var prefix = "sheet1_";
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

             case "btn_Close":
            	 self.close();
                 break;		 
/*			 
			 case "btn_new":	
			 	sheetObject.RemoveAll();	
				sheetObjects[1].RemoveAll();	
				sheetObjects[2].RemoveAll();		
				for(i=0;i<sheetObjects.length;i++){
		            ComConfigSheet (sheetObjects[i] );
		            initSheet(sheetObjects[i],i+1);
		            ComEndConfigSheet(sheetObjects[i]);
		        }
				
		        for(k=0;k<tabObjects.length;k++){
		            initTab(tabObjects[k],k+1);
		        }
				 
			    for ( var k = 0; k < comboObjects.length; k++) {
					initCombo(comboObjects[k], k + 1);
				}
             break;
			 
             case "btns_add":
            	 UF_addRow(-1);
                 break;
				 
			 case "btns_insert":
				//var row = sheetObject.DataInsert(-1);
				UF_addRow(-1);
				break;
				
			 case "btns_del":
				//JooRowHideDelete(sheetObject, prefix+"del_chk");
				
				rowDeleteProc(sheetObjects[0]);
				
				break;

			 case "btn_downexcel":
				sheetObject.SpeedDown2Excel(-1);
				break;
				
			 case "btn_retrieve":
				doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
				break; // end switch
*/				
			 case "btn_save": //저장
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
				
				}
     	}catch(e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('JOO00001');
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
/* 2012.06.04		 
		 for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		 }
*/
		doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
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
                    style.height = 120;
					//style.height = 180;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle = "|Sel|Lane|Rep.\nCarrier|Carrier1|Carrier2|Carrier3|Carrier4|Carrier5|Carrier6|Carrier7|Carrier8|Carrier9|Carrier10|old_rlane_cd|old_jo_rep_crr_cd|old1|old2|old3|old4|old5|old6|old7|old8|old9|old10|flag1|flag2|flag3|flag4|flag5|flag6|flag7|flag8|flag9|flag10|add_chk|jo_ref_no";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  prefix +"ibflag");
					InitDataProperty(0, cnt++,  dtHidden, 	30, 	daCenter, 	false, 	prefix +"del_chk");
					InitDataProperty(0, cnt++ , dtData,		65,  	daCenter,	false,  prefix +"rlane_cd", 		false,    "",      	dfNone, 	2,  false,  false);
					InitDataProperty(0, cnt++ , dtData,		65,  	daCenter,	false,  prefix +"jo_rep_crr_cd", 	false,    "",      	dfNone, 	2,  false,  false);
					
					InitDataProperty(0, cnt++ , dtData,		65,		daCenter,	false,  prefix +"jo_crr_cd1",  		false,    "",      	dfNone,   	0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,		65,		daCenter,	false,  prefix +"jo_crr_cd2",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		65,		daCenter,	false,  prefix +"jo_crr_cd3",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		65,  	daCenter,	false,  prefix +"jo_crr_cd4",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		65,  	daCenter,	false,  prefix +"jo_crr_cd5", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					
					InitDataProperty(0, cnt++ , dtData,		65,  	daCenter,	false,  prefix +"jo_crr_cd6", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		65,   	daCenter,	false,  prefix +"jo_crr_cd7", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		65,   	daCenter,	false,  prefix +"jo_crr_cd8", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		65,  	daCenter,	false,  prefix +"jo_crr_cd9", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		65,  	daCenter,	false,  prefix +"jo_crr_cd10", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					
					InitDataProperty(0, cnt++ , dtHidden,	40,  	daCenter,	false,  prefix +"old_rlane_cd", 	false,    "",      	dfNone, 	2,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,  	daCenter,	false,  prefix +"old_jo_rep_crr_cd",false,    "",      	dfNone, 	2,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"old_jo_crr_cd1",  	false,    "",      	dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"old_jo_crr_cd2",  	false,    "",      	dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"old_jo_crr_cd3",  	false,    "",      	dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"old_jo_crr_cd4",  	false,    "",      	dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"old_jo_crr_cd5",  	false,    "",      	dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"old_jo_crr_cd6",  	false,    "",      	dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"old_jo_crr_cd7",  	false,    "",      	dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"old_jo_crr_cd8",  	false,    "",      	dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"old_jo_crr_cd9",  	false,    "",      	dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"old_jo_crr_cd10",  false,    "",      	dfNone,   	0,     false,       true);
					
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"iud_flag1",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"iud_flag2",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"iud_flag3",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"iud_flag4",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"iud_flag5",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"iud_flag6",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"iud_flag7",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"iud_flag8",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"iud_flag9",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"iud_flag10",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"add_chk",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	false,  prefix +"jo_ref_no",  			false,         "",      								dfNone,   	0,     false,       true);

					InitDataValid(0, prefix+"jo_crr_cd2", vtEngUpOnly); //영문대문자
					InitDataValid(0, prefix+"jo_crr_cd3", vtEngUpOnly); //영문대문자
					InitDataValid(0, prefix+"jo_crr_cd4", vtEngUpOnly); //영문대문자
					InitDataValid(0, prefix+"jo_crr_cd5", vtEngUpOnly); //영문대문자
					InitDataValid(0, prefix+"jo_crr_cd6", vtEngUpOnly); //영문대문자
					InitDataValid(0, prefix+"jo_crr_cd7", vtEngUpOnly); //영문대문자
					InitDataValid(0, prefix+"jo_crr_cd8", vtEngUpOnly); //영문대문자
					InitDataValid(0, prefix+"jo_crr_cd9", vtEngUpOnly); //영문대문자
					InitDataValid(0, prefix+"jo_crr_cd10", vtEngUpOnly); //영문대문자

/*					InitDataCombo(0, prefix+"jo_rep_crr_cd"   	, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
					InitDataCombo(0, prefix+"jo_crr_cd1"   		, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
					InitDataCombo(0, prefix+"jo_crr_cd2"   		, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
					InitDataCombo(0, prefix+"jo_crr_cd3"   		, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
					InitDataCombo(0, prefix+"jo_crr_cd4"   		, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
					InitDataCombo(0, prefix+"jo_crr_cd5"   		, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
					InitDataCombo(0, prefix+"jo_crr_cd6"   		, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
					InitDataCombo(0, prefix+"jo_crr_cd7"   		, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
					InitDataCombo(0, prefix+"jo_crr_cd8"   		, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
					InitDataCombo(0, prefix+"jo_crr_cd9"   		, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
					InitDataCombo(0, prefix+"jo_crr_cd10"   	, " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM", " |ACL|APL|BDS|BTL|CCN|CMA|CNC|COS|CSA|CSC|CSL|DNA|EAS|EMC|ESL|GMD|HAL|HAS|HJS|HMM|HPL|HSH|IMS|IRA|KKL|KMD|LNL|LTO|MIS|MLL|MOL|MSC|MSK|NIS|NOR|NSS|NYK|OCL|OEL|PAC|PEL|PIL|RCL|SCI|SEA|SEN|SFD|SID|SMT|SNK|SNL|STX|TML|UAC|UFS|USL|VCS|WAN|XPR|YML|ZIM");
*/
              		}
                break;
				
				case 2:      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 120;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle = "|Sel|Lane|Rep.\nCarrier|Carrier|oldJoCrrCd1|oldJoCrrCd2|oldJoCrrCd3|iudFlag|";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  prefix +"ibflag");
					InitDataProperty(0, cnt++,  dtCheckBox, 	30, 	daCenter, 	false, 	prefix +"del_chk");
					InitDataProperty(0, cnt++ , dtData,			65,  	daCenter,	false,  prefix +"rlane_cd", 		false,         "",      								dfNone, 	2,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,  	daCenter,	false,  prefix +"jo_rep_crr_cd", 		false,         "",      								dfNone, 	2,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  prefix +"jo_crr_cd",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	false,  prefix +"old_jo_crr_cd1",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	false,  prefix +"old_jo_crr_cd2",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	false,  prefix +"old_jo_crr_cd3",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  prefix +"iud_flag",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,		65,		daCenter,	false,  prefix +"jo_ref_no",  			false,         "",      								dfNone,   	0,     false,       true);
			   }
                break;
				
				case 3:      //sheet3 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 120;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle = "|Sel|Lane|Rep.\nCarrier|Carrier||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++,  dtCheckBox, 	30, 	daCenter, 	false, 	"del_chk");
					InitDataProperty(0, cnt++ , dtData,			65,  	daCenter,	false,  "rlane_cd", 		false,         "",      								dfNone, 	2,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,  	daCenter,	false,  "jo_rep_crr_cd", 		false,         "",      								dfNone, 	2,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_crr_cd1",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_crr_cd2",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_crr_cd3",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_crr_cd4",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_crr_cd5",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_crr_cd6",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_crr_cd7",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_crr_cd8",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_crr_cd9",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_crr_cd10",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,		65,		daCenter,	false,  "jo_ref_no",  			false,         "",      								dfNone,   	0,     false,       true);
			   }
                break;
         }
     }

  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
         	case IBSEARCH:      //조회
       	   	  	if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
	        		formObj.f_cmd.value = SEARCH;
					formObj.save_chk.value = "";
					formObj.add_chk.value = "";
					//sheetObj.DoSearch("FNS_JOO_0086GS.do", ComReplaceStr(FormQueryString(formObj),"-",""));
					sheetObj.DoSearch("FNS_JOO_0086GS.do", FormQueryString(formObj));
	  	   	  	}	
                break;
				
           	case IBSAVE:       //저장
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				formObj.f_cmd.value = MULTI;
				var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
				if (SaveStr == ""){
					ComShowCodeMessage("JOO00036");
					return false;
				}
				
				if (!ComShowCodeConfirm("JOO00046")){
					return false;
				}
				
				//저장 시 기존 데이터 값, 삭제 Flag값 처리 
				for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
				{
					var joCrrCd1 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd1")," ");
					var joCrrCd2 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd2")," ");
					var joCrrCd3 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd3")," ");
					var joCrrCd4 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd4")," ");
					var joCrrCd5 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd5")," ");
					var joCrrCd6 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd6")," ");
					var joCrrCd7 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd7")," ");
					var joCrrCd8 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd8")," ");
					var joCrrCd9 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd9")," ");
					var joCrrCd10 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd10")," ");
					var iudFlag1 =ComTrimAll(sheetObj.CellValue(i, prefix+"iud_flag1")," ");
					var iudFlag2 =ComTrimAll(sheetObj.CellValue(i, prefix+"iud_flag2")," ");
					var iudFlag3 =ComTrimAll(sheetObj.CellValue(i, prefix+"iud_flag3")," ");
					var iudFlag4 =ComTrimAll(sheetObj.CellValue(i, prefix+"iud_flag4")," ");
					var iudFlag5 =ComTrimAll(sheetObj.CellValue(i, prefix+"iud_flag5")," ");
					var iudFlag6 =ComTrimAll(sheetObj.CellValue(i, prefix+"iud_flag6")," ");
					var iudFlag7 =ComTrimAll(sheetObj.CellValue(i, prefix+"iud_flag7")," ");
					var iudFlag8 =ComTrimAll(sheetObj.CellValue(i, prefix+"iud_flag8")," ");
					var iudFlag9 =ComTrimAll(sheetObj.CellValue(i, prefix+"iud_flag9")," ");
					var iudFlag10 =ComTrimAll(sheetObj.CellValue(i, prefix+"iud_flag10")," ");
					var iJoRefNo  =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_ref_no")," ");

					if(joCrrCd1 != "")
					{
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd1;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd1");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag1");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if(joCrrCd2 != "")
					{
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd2;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd2");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag2");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if(joCrrCd3 != "")
					{
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd3;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd3");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag3");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if(joCrrCd4 != "")
					{
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd4;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd4");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag4");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if(joCrrCd5 != "")
					{
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd5;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd5");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag5");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if(joCrrCd6 != "")
					{
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd6;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd6");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag6");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if(joCrrCd7 != "")
					{
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd7;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd7");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag7");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if(joCrrCd8 != "")
					{ 
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd8;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd8");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag8");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if(joCrrCd9 != "")
					{
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd9;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd9");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag9");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if(joCrrCd10 != "")
					{
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd10;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd10");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag10");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					
					if (joCrrCd1 == "" && iudFlag1 == "D") {
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd1;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd1");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag1");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if (joCrrCd2 == "" && iudFlag2 == "D") {
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd2;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd2");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag2");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if (joCrrCd3 == "" && iudFlag3 == "D") {
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd3;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd3");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag3");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if (joCrrCd4 == "" && iudFlag4 == "D") {
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd4;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd4");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag4");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if (joCrrCd5 == "" && iudFlag5 == "D") {
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd5;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd5");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag5");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if (joCrrCd6 == "" && iudFlag6 == "D") {
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd6;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd6");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag6");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if (joCrrCd7 == "" && iudFlag7 == "D") {
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd7;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd7");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag7");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if (joCrrCd8 == "" && iudFlag8 == "D") {
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd8;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd8");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag8");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if (joCrrCd9 == "" && iudFlag9 == "D") {
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd9;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd9");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag9");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					if (joCrrCd10 == "" && iudFlag10 == "D") {
						var addRow = sheetObjects[1].DataInsert();
						sheetObjects[1].cellValue(addRow,prefix+"jo_crr_cd") = joCrrCd10;
						sheetObjects[1].cellValue(addRow,prefix+"rlane_cd") 	 = sheetObj.CellValue(i, prefix+"rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObj.CellValue(i, prefix+"jo_rep_crr_cd");					
						
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObj.CellValue(i, prefix+"old_rlane_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObj.CellValue(i, prefix+"old_jo_rep_crr_cd");
						sheetObjects[1].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObj.CellValue(i, prefix+"old_jo_crr_cd10");
						sheetObjects[1].cellValue(addRow,prefix+"iud_flag") = sheetObj.CellValue(i, prefix+"iud_flag10");
						sheetObjects[1].cellValue(addRow,prefix+"jo_ref_no") = iJoRefNo;
					}
					
				}
				
				var SaveStr = ComGetSaveString(sheetObjects[1]);
				 
				 
				 //B.CRE_DT, 쿼리 파티션니..

				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("FNS_JOO_0086GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchXml(sXml);
				doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
				ComOpenWait(false);
                break;
        }
    }
     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
    	//필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;
        return true;
    }

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */
/* 2012.06.04
function initCombo(comboObj, comboNo) {
	var formObj = document.form

	switch (comboObj.id) {
	
	case "jo_crr_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 3;
		}
		var comboItems = ("ALL, |"+gCrrCd).split("|");
		UF_addComboItem(comboObj, comboItems);
		comboObj.Text2 = "ALL";
		
		break;
		
	case "rlane_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("50");
			DropHeight = 160;
			ValidChar(2, 1);//영문대문자+숫자만 입력가능
			MaxLength = 5;
		}
		comboObj.InsertItem(0, "ALL", " ");
		comboObj.Text2 = "ALL";
		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObj ,"rlane_cd");
		break;
	}
}

function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
		comboObj.Enable = false;
		//doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObj ,"rlane_cd");
		
		comboObj.Enable = true;
}

//조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
			if (sComboObj.id == "rlane_cd") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH16;
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+"&super_cd1="+formObj.jo_crr_cd.Code);
                ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code");
				sComboObj.InsertItem(0, "ALL", " ");
				sComboObj.Index2 = 0;
				var formObject = document.form;
				formObject.rlane_cd.focus();
			}									
	        break;
    }
}
*/
/*
	function UF_addRow(i){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		var row;
		if (i == undefined || i == null || i == ""){
			row = sheetObj.DataInsert();
		}else{
			row = sheetObj.DataInsert(-1);		
		}		
		sheetObj.cellValue(row,prefix+"iud_flag1") = "I";
		sheetObj.cellValue(row,prefix+"iud_flag2") = "I";
		sheetObj.cellValue(row,prefix+"iud_flag3") = "I";
		sheetObj.cellValue(row,prefix+"iud_flag4") = "I";
		sheetObj.cellValue(row,prefix+"iud_flag5") = "I";
		sheetObj.cellValue(row,prefix+"iud_flag6") = "I";
		sheetObj.cellValue(row,prefix+"iud_flag7") = "I";
		sheetObj.cellValue(row,prefix+"iud_flag8") = "I";
		sheetObj.cellValue(row,prefix+"iud_flag9") = "I";
		sheetObj.cellValue(row,prefix+"iud_flag10") = "I";
		sheetObj.cellValue(row,prefix+"add_chk") = "Y";
		
		formObj.f_cmd.value = SEARCH16;
		formObj.add_chk.value = "Y";
				
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
		var rlaneCdList = ComGetEtcData(sXml,"rlane_combo_sheet");
        sheetObj.CellComboItem(row, prefix+"rlane_cd" , rlaneCdList, rlaneCdList);
		sheetObj.SelectCell(row,prefix+"rlane_cd",true);
		//sheetObj.SelectCell(Row,prefix+"rlane_cd",true);
		return row;
	}
*/	
/**
 * 조회 후 Hidden그리드에서 화면에 보여주는 그리드로 데이터 처리
 * @param {Object} sheetObj
 * @param {Object} ErrMsg
 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj)
		{
			var formObj = document.form;
//			formObj.f_cmd.value = SEARCH16;
//			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
//			var rlaneCdList = ComGetEtcData(sXml,"rlane_combo_sheet");			
			for(var i=sheetObjects[2].HeaderRows ;i<=sheetObjects[2].LastRow;i++){				
				var addRow = sheetObjects[0].DataInsert(-1);
				
		        //sheetObjects[0].cellValue(addRow, prefix+"rlane_cd" , rlaneCdList, rlaneCdList);
				sheetObjects[0].cellValue(addRow,prefix+"rlane_cd") = sheetObjects[2].CellValue(i, "rlane_cd");	
				sheetObjects[0].cellValue(addRow,prefix+"jo_rep_crr_cd") = sheetObjects[2].CellValue(i, "jo_rep_crr_cd");
				sheetObjects[0].cellValue(addRow,prefix+"jo_crr_cd1") = sheetObjects[2].CellValue(i, "jo_crr_cd1");
				sheetObjects[0].cellValue(addRow,prefix+"jo_crr_cd2") = sheetObjects[2].CellValue(i, "jo_crr_cd2");
				sheetObjects[0].cellValue(addRow,prefix+"jo_crr_cd3") = sheetObjects[2].CellValue(i, "jo_crr_cd3");
				sheetObjects[0].cellValue(addRow,prefix+"jo_crr_cd4") = sheetObjects[2].CellValue(i, "jo_crr_cd4");
				sheetObjects[0].cellValue(addRow,prefix+"jo_crr_cd5") = sheetObjects[2].CellValue(i, "jo_crr_cd5");
				sheetObjects[0].cellValue(addRow,prefix+"jo_crr_cd6") = sheetObjects[2].CellValue(i, "jo_crr_cd6");
				sheetObjects[0].cellValue(addRow,prefix+"jo_crr_cd7") = sheetObjects[2].CellValue(i, "jo_crr_cd7");
				sheetObjects[0].cellValue(addRow,prefix+"jo_crr_cd8") = sheetObjects[2].CellValue(i, "jo_crr_cd8");
				sheetObjects[0].cellValue(addRow,prefix+"jo_crr_cd9") = sheetObjects[2].CellValue(i, "jo_crr_cd9");
				sheetObjects[0].cellValue(addRow,prefix+"jo_crr_cd10") = sheetObjects[2].CellValue(i, "jo_crr_cd10");
				
				sheetObjects[0].cellValue(addRow,prefix+"old_rlane_cd") = sheetObjects[2].CellValue(i, "rlane_cd");	
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_rep_crr_cd") = sheetObjects[2].CellValue(i, "jo_rep_crr_cd");
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_crr_cd1") = sheetObjects[2].CellValue(i, "jo_crr_cd1");
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_crr_cd2") = sheetObjects[2].CellValue(i, "jo_crr_cd2");
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_crr_cd3") = sheetObjects[2].CellValue(i, "jo_crr_cd3");
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_crr_cd4") = sheetObjects[2].CellValue(i, "jo_crr_cd4");
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_crr_cd5") = sheetObjects[2].CellValue(i, "jo_crr_cd5");
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_crr_cd6") = sheetObjects[2].CellValue(i, "jo_crr_cd6");
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_crr_cd7") = sheetObjects[2].CellValue(i, "jo_crr_cd7");
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_crr_cd8") = sheetObjects[2].CellValue(i, "jo_crr_cd8");
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_crr_cd9") = sheetObjects[2].CellValue(i, "jo_crr_cd9");
				sheetObjects[0].cellValue(addRow,prefix+"old_jo_crr_cd10") = sheetObjects[2].CellValue(i, "jo_crr_cd10");
				sheetObjects[0].cellValue(addRow,prefix+"jo_ref_no")       = sheetObjects[2].CellValue(i, "jo_ref_no");
			}
			formObj.save_chk.value = "Y";
		}
	}

/**
 * Carrier값(Carrier1~10) 변경 시 이벤트 처리
 * @param {Object} sheetObj
 * @param {Object} Row
 * @param {Object} Col
 * @param {Object} Value
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	var joRepCrrCd =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_rep_crr_cd")," ");
	var joCrrCd1 =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_crr_cd1")," ");
	var joCrrCd2 =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_crr_cd2")," ");
	var joCrrCd3 =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_crr_cd3")," ");
	var joCrrCd4 =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_crr_cd4")," ");
	var joCrrCd5 =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_crr_cd5")," ");
	var joCrrCd6 =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_crr_cd6")," ");
	var joCrrCd7 =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_crr_cd7")," ");
	var joCrrCd8 =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_crr_cd8")," ");
	var joCrrCd9 =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_crr_cd9")," ");
	var joCrrCd10 =ComTrimAll(sheetObj.CellValue(Row, prefix+"jo_crr_cd10")," ");
		
	var oldjoRepCrrCd =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_rep_crr_cd")," ");
	var oldjoCrrCd1 =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_crr_cd1")," ");
	var oldjoCrrCd2 =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_crr_cd2")," ");
	var oldjoCrrCd3 =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_crr_cd3")," ");
	var oldjoCrrCd4 =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_crr_cd4")," ");
	var oldjoCrrCd5 =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_crr_cd5")," ");
	var oldjoCrrCd6 =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_crr_cd6")," ");
	var oldjoCrrCd7 =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_crr_cd7")," ");
	var oldjoCrrCd8 =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_crr_cd8")," ");
	var oldjoCrrCd9 =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_crr_cd9")," ");
	var oldjoCrrCd10 =ComTrimAll(sheetObj.CellValue(Row, prefix+"old_jo_crr_cd10")," ");
	var addChk =ComTrimAll(sheetObj.CellValue(Row, prefix+"add_chk")," ");

	if (formObj.add_chk.value == 'Y') {
		if (sName == prefix+"jo_rep_crr_cd"){
			sheetObj.CellValue(Row, prefix+"jo_crr_cd1") = sheetObj.CellValue(Row, prefix+"jo_rep_crr_cd");
		}		
	}
	
	if (formObj.save_chk.value == 'Y') {		
		//Rep.Carrier변경 시 Carrier1값 동일하게 변경 처리
		if (sName == prefix+"jo_rep_crr_cd"){
			if (joRepCrrCd != oldjoRepCrrCd) {
				sheetObj.CellValue(Row, prefix+"jo_crr_cd1") = sheetObj.CellValue(Row, prefix+"jo_rep_crr_cd");
			}
		}

		if (sName == prefix+"jo_crr_cd1"){
			if (joCrrCd1 != oldjoCrrCd1) {
				sheetObj.CellValue(Row, prefix+"iud_flag1") = "U";
			}			
			if (addChk == "Y") {
				sheetObj.CellValue(Row, prefix+"iud_flag1") = "I";
			}
			if (joCrrCd1 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag1") = "D";
			}
			if (joCrrCd1 != "" && oldjoCrrCd1 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag1") = "I";
			}
		}
		
		if (sName == prefix+"jo_crr_cd2"){			
			if (joCrrCd2 != '' && (joCrrCd2 == joCrrCd1 || joCrrCd2 == joCrrCd3 || joCrrCd2 == joCrrCd4 || joCrrCd2 == joCrrCd5 || joCrrCd2 == joCrrCd6
				 || joCrrCd2 == joCrrCd7 || joCrrCd2 == joCrrCd8 || joCrrCd2 == joCrrCd9 || joCrrCd2 == joCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd2") = oldjoCrrCd2;
				sheetObj.SelectCell(Row, prefix+"jo_crr_cd2");
				return;
			}
			if( !validationCarrier(sheetObj, formObj, Row, prefix+"jo_crr_cd2", prefix+"iud_flag2", joCrrCd2, oldjoCrrCd2) ) {
				return;
			}
			if (joCrrCd2 != oldjoCrrCd2) {
				sheetObj.CellValue(Row, prefix+"iud_flag2") = "U";
			} else {
				sheetObj.CellValue(Row, prefix+"iud_flag2") = "";
			}
			if (addChk == "Y") {
				sheetObj.CellValue(Row, prefix+"iud_flag2") = "I";
			}
			if (joCrrCd2 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag2") = "D";
			}
			if (joCrrCd2 != "" && oldjoCrrCd2 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag2") = "I";
			}
		}
				
		if (sName == prefix+"jo_crr_cd3"){
			if (joCrrCd3 != '' && (joCrrCd3 == joCrrCd1 || joCrrCd3 == joCrrCd2 || joCrrCd3 == joCrrCd4 || joCrrCd3 == joCrrCd5 || joCrrCd3 == joCrrCd6
				 || joCrrCd3 == joCrrCd7 || joCrrCd3 == joCrrCd8 || joCrrCd3 == joCrrCd9 || joCrrCd3 == joCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd3") = oldjoCrrCd3;
				sheetObj.SelectCell(Row, prefix+"jo_crr_cd3");
				return;
			}
			if( !validationCarrier(sheetObj, formObj, Row, prefix+"jo_crr_cd3", prefix+"iud_flag3", joCrrCd3, oldjoCrrCd3) ) {
				return;
			}
			if (joCrrCd3 != oldjoCrrCd3) {
				sheetObj.CellValue(Row, prefix+"iud_flag3") = "U";
			} else {
				sheetObj.CellValue(Row, prefix+"iud_flag3") = "";
			}
			if (addChk == "Y") {
				sheetObj.CellValue(Row, prefix+"iud_flag3") = "I";
			}
			if (joCrrCd3 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag3") = "D";
			}
			if (joCrrCd3 != "" && oldjoCrrCd3 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag3") = "I";
			}
		}
		
		if (sName == prefix+"jo_crr_cd4"){
			if (joCrrCd4 != '' && (joCrrCd4 == joCrrCd1 || joCrrCd4 == joCrrCd2 || joCrrCd4 == joCrrCd3 || joCrrCd4 == joCrrCd5 || joCrrCd4 == joCrrCd6
				 || joCrrCd4 == joCrrCd7 || joCrrCd4 == joCrrCd8 || joCrrCd4 == joCrrCd9 || joCrrCd4 == joCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd4") = oldjoCrrCd4;
				sheetObj.SelectCell(Row, prefix+"jo_crr_cd4");
				return;
			}
			if( !validationCarrier(sheetObj, formObj, Row, prefix+"jo_crr_cd4", prefix+"iud_flag4", joCrrCd4, oldjoCrrCd4) ) {
				return;
			}
			if (joCrrCd4 != oldjoCrrCd4) {
				sheetObj.CellValue(Row, prefix+"iud_flag4") = "U";
			} else {
				sheetObj.CellValue(Row, prefix+"iud_flag4") = "";
			}
			if (addChk == "Y") {
				sheetObj.CellValue(Row, prefix+"iud_flag4") = "I";
			}
			if (joCrrCd4 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag4") = "D";
			}
			if (joCrrCd4 != "" && oldjoCrrCd4 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag4") = "I";
			}
		}
		
		if (sName == prefix+"jo_crr_cd5"){
			if (joCrrCd5 != '' && (joCrrCd5 == joCrrCd1 || joCrrCd5 == joCrrCd2 || joCrrCd5 == joCrrCd3 || joCrrCd5 == joCrrCd4 || joCrrCd5 == joCrrCd6
				 || joCrrCd5 == joCrrCd7 || joCrrCd5 == joCrrCd8 || joCrrCd5 == joCrrCd9 || joCrrCd5 == joCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd5") = oldjoCrrCd5;
				sheetObj.SelectCell(Row, prefix+"jo_crr_cd5");
				return;
			}
			if( !validationCarrier(sheetObj, formObj, Row, prefix+"jo_crr_cd5", prefix+"iud_flag5", joCrrCd5, oldjoCrrCd5) ) {
				return;
			}
			if (joCrrCd5 != oldjoCrrCd5) {
				sheetObj.CellValue(Row, prefix+"iud_flag5") = "U";
			} else {
				sheetObj.CellValue(Row, prefix+"iud_flag5") = "";
			}
			if (addChk == "Y") {
				sheetObj.CellValue(Row, prefix+"iud_flag5") = "I";
			}
			if (joCrrCd5 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag5") = "D";
			}
			if (joCrrCd5 != "" && oldjoCrrCd5 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag5") = "I";
			}
		}
		
		if (sName == prefix+"jo_crr_cd6"){
			if (joCrrCd6 != '' && (joCrrCd6 == joCrrCd1 || joCrrCd6 == joCrrCd2 || joCrrCd6 == joCrrCd3 || joCrrCd6 == joCrrCd4 || joCrrCd6 == joCrrCd5
				 || joCrrCd6 == joCrrCd7 || joCrrCd6 == joCrrCd8 || joCrrCd6 == joCrrCd9 || joCrrCd6 == joCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd6") = oldjoCrrCd6;
				sheetObj.SelectCell(Row, prefix+"jo_crr_cd6");
				return;
			}
			if( !validationCarrier(sheetObj, formObj, Row, prefix+"jo_crr_cd6", prefix+"iud_flag6", joCrrCd6, oldjoCrrCd6) ) {
				return;
			}
			if (joCrrCd6 != oldjoCrrCd6) {
				sheetObj.CellValue(Row, prefix+"iud_flag6") = "U";
			} else {
				sheetObj.CellValue(Row, prefix+"iud_flag6") = "";
			}
			if (addChk == "Y") {
				sheetObj.CellValue(Row, prefix+"iud_flag6") = "I";
			}
			if (joCrrCd6 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag6") = "D";
			}
			if (joCrrCd6 != "" && oldjoCrrCd6 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag6") = "I";
			}
		}
		
		if (sName == prefix+"jo_crr_cd7"){
			if (joCrrCd7 != '' && (joCrrCd7 == joCrrCd1 || joCrrCd7 == joCrrCd2 || joCrrCd7 == joCrrCd3 || joCrrCd7 == joCrrCd4 || joCrrCd7 == joCrrCd5
				 || joCrrCd7 == joCrrCd6 || joCrrCd7 == joCrrCd8 || joCrrCd7 == joCrrCd9 || joCrrCd7 == joCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd7") = oldjoCrrCd7;
				sheetObj.SelectCell(Row, prefix+"jo_crr_cd7");
				return;
			}
			if( !validationCarrier(sheetObj, formObj, Row, prefix+"jo_crr_cd7", prefix+"iud_flag7", joCrrCd7, oldjoCrrCd7) ) {
				return;
			}
			if (joCrrCd7 != oldjoCrrCd7) {
				sheetObj.CellValue(Row, prefix+"iud_flag7") = "U";
			} else {
				sheetObj.CellValue(Row, prefix+"iud_flag7") = "";
			}
			if (addChk == "Y") {
				sheetObj.CellValue(Row, prefix+"iud_flag7") = "I";
			}
			if (joCrrCd7 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag7") = "D";
			}
			if (joCrrCd7 != "" && oldjoCrrCd7 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag7") = "I";
			}
		}
		
		if (sName == prefix+"jo_crr_cd8"){
			if (joCrrCd8 != '' && (joCrrCd8 == joCrrCd1 || joCrrCd8 == joCrrCd2 || joCrrCd8 == joCrrCd3 || joCrrCd8 == joCrrCd4 || joCrrCd8 == joCrrCd5
				 || joCrrCd8 == joCrrCd6 || joCrrCd8 == joCrrCd7 || joCrrCd8 == joCrrCd9 || joCrrCd8 == joCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd8") = oldjoCrrCd8;
				sheetObj.SelectCell(Row, prefix+"jo_crr_cd8");
				return;
			}
			if( !validationCarrier(sheetObj, formObj, Row, prefix+"jo_crr_cd8", prefix+"iud_flag8", joCrrCd8, oldjoCrrCd8) ) {
				return;
			}
			if (joCrrCd8 != oldjoCrrCd8) {
				sheetObj.CellValue(Row, prefix+"iud_flag8") = "U";
			} else {
				sheetObj.CellValue(Row, prefix+"iud_flag8") = "";
			}
			if (addChk == "Y") {
				sheetObj.CellValue(Row, prefix+"iud_flag8") = "I";
			}
			if (joCrrCd8 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag8") = "D";
			}
			if (joCrrCd8 != "" && oldjoCrrCd8 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag8") = "I";
			}
		}
		
		if (sName == prefix+"jo_crr_cd9"){
			if (joCrrCd9 != '' && (joCrrCd9 == joCrrCd1 || joCrrCd9 == joCrrCd2 || joCrrCd9 == joCrrCd3 || joCrrCd9 == joCrrCd4 || joCrrCd9 == joCrrCd5
				 || joCrrCd9 == joCrrCd6 || joCrrCd9 == joCrrCd7 || joCrrCd9 == joCrrCd8 || joCrrCd9 == joCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd9") = oldjoCrrCd9;
				sheetObj.SelectCell(Row, prefix+"jo_crr_cd9");
				return;
			}
			if( !validationCarrier(sheetObj, formObj, Row, prefix+"jo_crr_cd9", prefix+"iud_flag9", joCrrCd9, oldjoCrrCd9) ) {
				return;
			}
			if (joCrrCd9 != oldjoCrrCd9) {
				sheetObj.CellValue(Row, prefix+"iud_flag9") = "U";
			} else {
				sheetObj.CellValue(Row, prefix+"iud_flag9") = "";
			}
			if (addChk == "Y") {
				sheetObj.CellValue(Row, prefix+"iud_flag9") = "I";
			}
			if (joCrrCd9 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag9") = "D";
			}
			if (joCrrCd9 != "" && oldjoCrrCd9 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag9") = "I";
			}
		}		
		
		if (sName == prefix+"jo_crr_cd10"){
			if (joCrrCd10 != '' && (joCrrCd10 == joCrrCd1 || joCrrCd10 == joCrrCd2 || joCrrCd10 == joCrrCd3 || joCrrCd10 == joCrrCd4 || joCrrCd10 == joCrrCd5
				 || joCrrCd10 == joCrrCd6 || joCrrCd10 == joCrrCd7 || joCrrCd10 == joCrrCd8 || joCrrCd10 == joCrrCd9)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd10") = oldjoCrrCd10;
				sheetObj.SelectCell(Row, prefix+"jo_crr_cd10");
				return;
			}
			if( !validationCarrier(sheetObj, formObj, Row, prefix+"jo_crr_cd10", prefix+"iud_flag10", joCrrCd10, oldjoCrrCd10) ) {
				return;
			}
			if (joCrrCd10 != oldjoCrrCd10) {
				sheetObj.CellValue(Row, prefix+"iud_flag10") = "U";
			} else {
				sheetObj.CellValue(Row, prefix+"iud_flag10") = "";
			}
			if (addChk == "Y") {
				sheetObj.CellValue(Row, prefix+"iud_flag10") = "I";
			}
			if (joCrrCd10 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag10") = "D";
			}
			if (joCrrCd10 != "" && oldjoCrrCd6 == "") {
				sheetObj.CellValue(Row, prefix+"iud_flag10") = "I";
			}
		}
	}
}

/**
 * 그리드 Row Delete버튼 이벤트 처리
 * @param {Object} sheetObj
 */
/*
function rowDeleteProc(sheetObj) {
	var rowChk = "";
	var formObj = document.form;
	
	for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++){
		rowChk = sheetObj.CellValue(i, prefix+"del_chk");
		var joCrrCd1 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd1")," ");
		var joCrrCd2 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd2")," ");
		var joCrrCd3 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd3")," ");
		var joCrrCd4 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd4")," ");
		var joCrrCd5 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd5")," ");
		var joCrrCd6 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd6")," ");
		var joCrrCd7 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd7")," ");
		var joCrrCd8 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd8")," ");
		var joCrrCd9 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd9")," ");
		var joCrrCd10 =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_crr_cd10")," ");
	
		if (rowChk == 1) {
			if (joCrrCd1 != "") {
				sheetObj.CellValue(i, prefix+"iud_flag1") = "D";
			}
			if (joCrrCd2 != "") {
				sheetObj.CellValue(i, prefix+"iud_flag2") = "D";
			}
			if (joCrrCd3 != "") {
				sheetObj.CellValue(i, prefix+"iud_flag3") = "D";
			}
			if (joCrrCd4 != "") {
				sheetObj.CellValue(i, prefix+"iud_flag4") = "D";
			}
			if (joCrrCd5 != "") {
				sheetObj.CellValue(i, prefix+"iud_flag5") = "D";
			}
			if (joCrrCd6 != "") {
				sheetObj.CellValue(i, prefix+"iud_flag6") = "D";
			}
			if (joCrrCd7 != "") {
				sheetObj.CellValue(i, prefix+"iud_flag7") = "D";
			}
			if (joCrrCd8 != "") {
				sheetObj.CellValue(i, prefix+"iud_flag8") = "D";
			}
			if (joCrrCd9 != "") {
				sheetObj.CellValue(i, prefix+"iud_flag9") = "D";
			}
			if (joCrrCd10 != "") {
				sheetObj.CellValue(i, prefix+"iud_flag10") = "D";
			}
			sheetObj.RowHidden(i)= true;		//행 숨기기
		}
	}
}
*/
/*
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
*/
function validationCarrier(sheetObj, formObj, Row, Col, flgCol, newValue, oldValue) {
	if( newValue.length == 3 ) {
		formObj.f_cmd.value = SEARCHLIST12;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code="+newValue);
		var outValue = ComGetEtcData(sXml,"CHECK");
		if( outValue == "E" ) {
			if(!ComShowCodeConfirm("JOO00193")) {
				if(oldValue == "") {
					sheetObj.CellValue(Row, flgCol) = "";
				} else {
					sheetObj.CellValue(Row, flgCol) = "D";
				}
				sheetObj.CellValue2(Row, Col) = "";
				sheetObj.SelectCell(Row, Col);
				return false;
			}
		}
	} else {
		if( newValue != "" ) {
			ComShowCodeMessage("JOO00194");
			sheetObj.SelectCell(Row, Col);
			return false;
		}
	}
	return true;
}
	/* 개발자 작업  끝 */