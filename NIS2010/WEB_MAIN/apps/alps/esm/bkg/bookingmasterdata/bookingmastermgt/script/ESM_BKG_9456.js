/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_9456.js
*@FileTitle :Chinese Agent Set-up(China 24hr Manifest)
*Open Issues :
*Change history :
*@LastModifyDate :2011.07.11
*@LastModifier : Kim HyunHwa
*@LastVersion : 1.0
* 2011.07.11 Kim HyunHwa
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
     * @class esm_bkg_9456 : esm_bkg_9456 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_9456() {
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
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
					case "btn_save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
					
					case "btn_downexcel":
						sheetObject.SpeedDown2Excel(-1);
					break;			
					
					case "btn_add":
						doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
					break;
					
					case "btn_del":
						doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
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
	
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);
			}
			initControl();
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
        	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
        	axon_event.addListenerFormat('keypress',  'obj_KeyPress',    formObject); //- 키보드 입력할때
        	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');

        	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
 
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
                        style.height = 400;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;  
                        

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;
                      
                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                         InitRowInfo(2, 1, 15, 100);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)                       
 
                        var HeadTitle1 = "| |Control Office|POD|Lane|Agent No.\n(Manifest)|Agent Name|Full Agent Name|PIC|TEL|Email|Address|Receiving ID|Sending ID|Remark(s)|Creation|Creation|Creation";
                        var HeadTitle2 = "| |Control Office|POD|Lane|Agent No.\n(Manifest)|Agent Name|Full Agent Name|PIC|TEL|Email|Address|Receiving ID|Sending ID|Remark(s)|Date|By|Office";
                        var headCount = ComCountHeadTitle(HeadTitle1);
                        
                        
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);                        
                    

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);                       
                        
                        //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
 						InitDataProperty(0,	cnt++,	dtDelCheck,		30, 	daCenter,	true,	"del_chk", 		     false,		"",		 dfNone,	0,		true,	    true);                    
 						InitDataProperty(0, cnt++ , dtData,			100,  	daCenter,	true,	"agn_ctrl_ofc_cd",   true,		"",      dfNone,	0,		false,		true,	6);
						InitDataProperty(0, cnt++ , dtData,			50,	    daCenter,	true,	"pod_cd",	         true,		"",      dfNone,	0,		false,		true,	5);
						InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	true,	"slan_cd",	         true,		"",      dfNone,	0,		false,		true,   3);
						InitDataProperty(0, cnt++ , dtData,		    85,    daCenter,	true,	"chn_cstms_agn_cd",  true,		"",      dfNone,	0,		false,		true,   2);
						InitDataProperty(0, cnt++ , dtData,		    130,	daCenter,	true,	"chn_cstms_agn_nm",	 false,		"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		    130,	daCenter,	true,	"chn_cstms_agn_full_nm",	 false,		"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		    130,	daCenter,	true,	"chn_cstms_agn_pic_nm",	 false,		"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		    130,	daCenter,	true,	"chn_cstms_agn_phn_no",	 false,		"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		    130,	daCenter,	true,	"chn_cstms_agn_eml",	 false,		"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,		    130,	daCenter,	true,	"chn_cstms_agn_addr",	 false,		"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"edi_rcv_id",	     true,		"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"edi_snd_id",	     false,		"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	true,	"chn_cstms_agn_rmk", false,		"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"upd_dt",		     false,		"",      dfDateYmd,	0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"upd_usr_id",	     false,		"",      dfNone,	0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"cre_ofc_cd",        false,		"",      dfNone,	0,		false,		false);
						
						InitDataValid(0,  "agn_ctrl_ofc_cd",   vtEngUpOther,	'0123456789');
						InitDataValid(0,  "pod_cd",  vtEngUpOther,	'0123456789');
						InitDataValid(0,  "slan_cd", vtEngUpOther,	'0123456789');
						InitDataValid(0,  "chn_cstms_agn_cd", vtEngUpOther,	'0123456789');
						InitDataValid(0,  "edi_rcv_id", vtEngUpOther,	'0123456789-');
						
						
						FocusEditMode = -1;
					//	SelectionMode = smSelectionList;
					//	SelectHighLight = false;
						//CountPosition = 0;
                   }
                    break;

            }
        }

		
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
	            case IBCLEAR: // 화면 로딩시 코드 조회
	            	
					formObj.f_cmd.value = COMMAND01;
					var param = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("ESM_BKG_9456GS.do", param);
					
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0) 
						ComBkgXml2ComboItem(arrXml[0], formObj.chn_cstms_agn, "chn_cstms_agn_cd", "chn_cstms_agn_cd");
					    formObj.chn_cstms_agn.InsertItem(0,"ALL","ALL");
					
					break;	
	           case IBSEARCH:      //조회
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value = SEARCH;
		        	  sheetObj.WaitImageVisible = false;
		        	  
						if(document.form.chn_cstms_agn.Text =="" ){
			    			 document.form.chn_cstms_agn_cd.value ="";
			    			 document.form.chn_cstms_agn_nm.value ="";
						}
						
		        	  ComOpenWait(true);
		        	  sheetObj.DoSearch("ESM_BKG_9456GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam(""));
		        	  
		        	  ComOpenWait(false);
		          }	
	               	break;
	
	           case IBSAVE:        //저장
					if(validateForm(sheetObj,formObj,sAction)){
						 
						if(!chkDuplicate()) return;	 
						
						sheetObj.WaitImageVisible = false;
			        	ComOpenWait(true);
						formObj.f_cmd.value = MULTI;
						
						sheetObj.DoSave("ESM_BKG_9456GS.do", FormQueryString(formObj));
	
			        

			        	var chn_cstms_agn = document.form.chn_cstms_agn.Code;
			        	var agn_cd = chn_cstms_agn.split("|"); 
			        	
						doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
						if (chn_cstms_agn !="" ||chn_cstms_agn !="ALL"){
			        	document.form.chn_cstms_agn.Code = chn_cstms_agn;
			        	document.form.chn_cstms_agn_nm.value = agn_cd[1];
						}
						ComOpenWait(false);

					}
					break;
	           
				case IBINSERT:      // 입력
					//신규행 추가
	 				sheetObj.DataInsert(-1);
	 			
					break;
				case IBDELETE:      // 삭제
					//행 삭제 FLAG처리
					sheetObj.CellValue2(sheetObj.SelectRow, "ibflag") = "D";
					ComRowHideDelete(sheetObj, "del_chk");
					break;	
            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	switch(sAction) {
	            case IBSAVE: // 저장시 확인
	         		if (!ComChkValid(formObj)){
	         			 return false;
	         		}
	               
	         		break;
            }
            return true;
        }
        function sheet1_OnChange(sheetObj, Row,Col,Value){
//        	with (sheetObj) {
//	        	 //SaveName을 이용하여 컬럼 번호을 가져온다.
//	            var iCol = SaveNameCol("slan_cd_disp");
//	        	 
//	        	if (Col == iCol) {
//	        		
//	        		var sText  = GetComboInfo(Row,Col, "Text");
//	        		
//	        		var idx   = GetComboInfo(Row,Col, "SelectedIndex");
//					var arrText = sText.split("|");
//					var schText	= arrText[idx];	
//					if (schText == undefined) return;
//					
//					var skd_dir_cd	= schText.split("\t");
//					CellValue2(Row,"skd_dir_cd") = skd_dir_cd[1];
//					CellValue2(Row,"slan_cd") = skd_dir_cd[0];
//	        	}		
//        	}
         }
        
        
        /** 
         * Agent code 선택시 Name을 보여줌. <br>
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * @param  {object} comboObj :Agent code 따른 폼 오브젝트
         * @param  {String} Index_Code : 선택한 Agent code의 value(Agent code+name) 값
         * @param  {String} Text : 선택한 Agent code의 text 값
         * @return 없음
         * @see #
         * @author Kim Hyun Hwa
         * @version 2011.07.15
         */
        function chn_cstms_agn_OnChange(comboObj,Index_Code, Text,Code){
        	 var chn_cstms_agn_nm =  Text.split("|");
        	        	 
       	 if(Index_Code == "" || Index_Code == null){

       		 if(Text != ""){
       		   //  chn_cstms_agn_nm = Index_Code.split("|");
       			// document.form.chn_cstms_agn_cd.value = chn_cstms_agn_nm[0];
        		// document.form.chn_cstms_agn_nm.value = chn_cstms_agn_nm[1];
       		  }
       		 else{
    			 document.form.chn_cstms_agn_cd.value ="";
    			 document.form.chn_cstms_agn_nm.value ="";
       		 }
       			 
         }else{
        	  if(Index_Code!="ALL") {
       	      chn_cstms_agn_nm = Index_Code.split("|");
       	      document.form.chn_cstms_agn_cd.value = chn_cstms_agn_nm[0];
              document.form.chn_cstms_agn_nm.value = chn_cstms_agn_nm[1];
              }
        	  else
        	  {
     			 document.form.chn_cstms_agn_cd.value ="";
    			 document.form.chn_cstms_agn_nm.value ="";
        	  }
         }
      }
         
         //같은 POD 와 LANE 에 두개 이상의 agent 코드가 나올 수 없다.  
         function chkDuplicate(){
        	
        	 var formObj = document.form;
        	 var cnt = sheetObjects[0].RowCount+1;
        	 var sheetObj = sheetObjects[0];
        	 for (var ix = 1; ix <= cnt; ix++ ){
        		
        		 var pod_cd = sheetObj.CellValue(ix,"pod_cd");
        		 var lane_cd = sheetObj.CellValue(ix,"slan_cd");
        		 var pod_lane = pod_cd + lane_cd;
        		  if (sheetObj.CellValue(ix,"ibflag") == "I" || sheetObj.RowStatus(ix) == "U"){
        			  for( var j = 1; j <= cnt; j++){
    	    		 	var pod_cd2 = sheetObj.CellValue(j,"pod_cd");
        		 		var lane_cd2 = sheetObj.CellValue(j,"slan_cd");
        		 		var pod_lane2 = pod_cd2 + lane_cd2;
        		 		
        		 		if(ix != j && pod_lane == pod_lane2){
        		 			
        		 			ComShowCodeMessage('BKG03056',"POD: " + pod_cd + ", LANE: " + lane_cd);
    	    			 	 sheetObj.SelectCell(ix, "pod_cd");   			 	 
    	    			 	 return false ;
        		 		}
    	    		 }
        		 }
        		 
        	 }
        	 return true;
         }
        
        
	/* 개발자 작업  끝 */