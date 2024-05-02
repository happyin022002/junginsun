/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : esm_bkg_0003.js
*@FileTitle : Customer Advisory Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.01
*@LastModifier : Lee In Young
*@LastVersion : 1.0
* 2011.07.01 Lee In Young
* 1.0 Creation
* ===============================================================================
* History
* 2012.03.22 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
* 2012.09.17 김보배 [CHM-201220181] [BKG] ALPS Bkg/Doc Customer Advisory Send 기능 보완 요청 (30초룰 해제)
* 2013.02.19 김보배 [CHM-201322482] [BKG] 개발:Split 01-Customer Advisory 기능 추가 (BST Download)
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
     * @class esm_bkg_0003 : esm_bkg_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0003() {
    	this.processButtonClick		= tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
var IBUPLOAD = "IBUPLOAD";
var IBDOWNLOAD = "IBDOWNLOAD";
var IBTEMPLATE = "IBTEMPLATE";
var IBSENDFAX = "IBSENDFAX";
var IBSENDEMAIL = "IBSENDEMAIL";
    
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;
 
 var shCustNmFax;
 var cnCustNmFax;
 var nfCustNmFax;
 var shCustNmEml;
 var cnCustNmEml;
 var nfCustNmEml;
 
 //전역변수
 var intervalId = "";
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var shtCnt = 0;
 	         var sheet1 = sheetObjects[0];
 	         var sheet2 = sheetObjects[1];
 	         var sheet3 = sheetObjects[2];
          /*******************************************************/ 
          
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
	             case "btn_retrieve":
			         if(validateForm(formObject, SEARCH)){
			        	 doActionIBSheet(formObject,SEARCH); 
			         }	            	 
	     	        break;
	
	     	    case "btn_downExcel":
	     	    	if(validateForm(formObject, IBDOWNLOAD)){
		     	    	sheet3.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "0");
		     	    	
	     	    	}
	     	        break;
	     	    
	     	    case "btn_uploadExcel":
	     	    	if(validateForm(formObject, IBUPLOAD)){
		    			var columns = "1=>sheet2_cntr_no";
		     	    	var ret = sheet2.LoadExcel(-1,1,"","-1","-1","",false,false,columns);
	     	    	}
	                break;

	     	    case "btn_uploadDownload":	                
			         if(validateForm(formObject, SEARCH)){
			        	 if(ComShowCodeConfirm("BKG95003","BST Download")) {
			        		 doActionIBSheet(formObject,MULTI05); 
			        	 }
			         }	
	     	    	break;
	                
				case "btn_save":
		        	 doActionIBSheet(formObject,MULTI);
		        	 break;
		        	 
				case "btn_history":
		            var goUrl = "";
		            var param = "";
		            goUrl = "/hanjin/ESM_BKG_0005.do?";

		            param += "1=1";
		            param += "&autoSearchFlg=Y";
		            param += "&" + FormQueryString(formObject);

		            //선택되지 않을경우는 No Action
		            //location.href=goUrl + param;
		            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0005",1024,600,true);
		            break;	 
				
				case "btn_fax":
					 doActionIBSheet(formObject,IBSENDFAX);
					 break; 
				
				case "btn_email":
					doActionIBSheet(formObject,IBSENDEMAIL);
					break;
				
				case "btn_template":
					if(validateForm(formObject, IBTEMPLATE)){
			            var goUrl = "";
			            var param = "";
			            goUrl = "/hanjin/ESM_BKG_0004.do?";
			            var dirCd = "E";
			            var ofc_cd = formObject.ofc_cd.value;
			            param += "pgmNo=ESM_BKG_0004&vvd="+formObject.vvd.value+"&dir_cd="+dirCd+"&ofc_cd="+ofc_cd+"&rmk_use_flg=Y&search_type=parents";

//			            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0004",900,570,true);
			            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0004",900,650,true);
					}
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
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      * @param tab_obj
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;
     }     
     
     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      * @param tabObj
      * @param tabNo
      */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Fax" , -1 );
                    InsertTab( cnt++ , "E-Mail" , -1 );

                    }
                break;

        }
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
         
         initControl();
         document.form.vvd.focus();
         
         doActionIBSheet(document.form, INIT);
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
    	    //Axon 이벤트 처리1. 이벤트catch
	     	var formObject = document.form;
	        axon_event.addListenerForm('click', 'obj_click', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	        axon_event.addListenerForm('keyup', 'obj_keyup', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); //- 포커스 나갈때
	        axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
     }

      /**
       * IBSheet Object를 배열로 등록
       * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
       * 배열은 소스 상단에 정의
       * @param sheet_obj
       */
      function setSheetObject(sheet_obj){
         sheetObjects[sheetCnt++] = sheet_obj;
      }
      
      /**
       * 화면 개체가 변경되었을 때의 이벤트 처리
       * @return
       */
      function obj_keyup() {
      }
      /**
        * Form Object가 Deactive될때 발생하는 이벤트를 처리한다.(포커스 나갈때)
        * @return
        */
      function obj_deactivate(){
    	  
      	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	
    	if(srcName == "cust_seq"){
    		// Customer Country Code가 존재할 경우에만 CustName을 검색, Customer Type을 활성화
    		if(formObject.cust_cnt_cd.value != ""){
    			doActionIBSheet(formObject, SEARCH01);
    			formObject.bkg_cust_tp_cd.disabled = false;
    		} else {
    			formObject.bkg_cust_tp_cd.disabled = true;
    		}
    	}
      }
      
      /**
      * 더블클릭 이벤트 발생시
      * @param sheetObj
      * @param Row
      * @param Col
      * @param Value
      **/
      function sheet1_OnDblClick(sheetObj, Row, Col, Value){
          var colName = sheetObj.ColSaveName(Col);

          if((colName == "sh_cust_nm_fax" ) || (colName == "cn_cust_nm_fax" ) || (colName == "nf_cust_nm_fax" ) ||
       		  (colName == "sh_cust_nm_eml" ) || (colName == "cn_cust_nm_eml" ) || (colName == "nf_cust_nm_eml" )){
              if(sheetObj.RowHeight(Row) == 20){
                  sheetObj.RowHeight(Row) = 0;
                  sheetObj.ColWidth(Col) = 0;

              }else{
                  sheetObj.RowHeight(Row) = 20;
                  sheetObj.ColWidth(Col)  = 180;

              }
          }
          
          if( colName == "cntr_no"){
              sheetObj.CellEditable(Row, colName) = false;
              ComShowMemoPad(sheetObj, Row, colName, true, 180, 100, 200 );
          }
      }
      

     /**
        * 시트 초기설정값, 헤더 정의
        * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
        * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
        * @param sheetObj
        * @param sheetNo
        */
       function initSheet(sheetObj,sheetNo) {

           var cnt = 0;
           var sheetID = sheetObj.id;
           switch(sheetID) {
           	case "sheet1":      //sheet1
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
  		             InitRowInfo( 1, 1, 9, 50);
  		
  		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
  		             InitHeadMode(true, true, true, true, false,false);
  		             var HeadTitle = "|Seq.|||Source Type|VVD|B/L No.|CNTR No.|POR|POL|POD|DEL";
  		             HeadTitle += "|SHPR Name||FAX No.||Status|CNEE Name||FAX No.||Status|Notify Name||Fax No.||Status|Contract Customer Name|Account Class||Fax No.||Status";				// Fax 			 
  		             HeadTitle += "|SHPR Name||e-Mail No.||Status|CNEE Name||e-Mail No.||Status|Notify Name||e-Mail No.||Status|Contract Customer Name|Account Class||e-Mail No.||Status"; 	// Email 
//  		             HeadTitle += "||||||||||||";
  		             HeadTitle += "|||||";
  		
  		             var headCount = ComCountHeadTitle(HeadTitle);

  		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  		             InitColumnInfo(headCount, 0, 0, true);
  		             
  		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  		             InitHeadRow(0, HeadTitle, true);
  		             //데이터속성    [	ROW, COL,   DATATYPE,		WIDTH,  DATAALIGN, 	COLMERGE,   SAVENAME,   		KEYFIELD, 	CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  		             // Fax
 					 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
  		             InitDataProperty(0, cnt++ , dtSeq,       		30,    	daCenter,  	false,    	"seq",          	false,          "",       dfNone,   	0,     		false,      true);
 					 InitDataProperty(0, cnt++ , dtDummyCheck,   	40,   	daCenter,   true,    	"fax_chk",	        false,  		"",    	  dfNone,		0,  		true,  		true,-1,false,true,"Check");
 					 InitDataProperty(0, cnt++ , dtDummyCheck,   	40,   	daCenter,   true,    	"eml_chk",	        false,  		"",    	  dfNone,		0,  		true,  		true,-1,false,true,"Check");
  		             InitDataProperty(0, cnt++ , dtData,      		80,     daCenter,  	false,    	"src_dat_tp_cd",	false,          "",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,     daCenter,  	false,    	"vvd",       		false,          "",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		90,   	daCenter,  	false,   	"bl_no",    		false,          "",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daLeft,  	false,   	"cntr_no",    		false,          "",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,  	false,    	"por_cd",       	false,          "",       dfNone,    	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,  	false,    	"pol_cd",       	false,          "",       dfNone,    	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,  	false,    	"pod_cd",  		   	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,  	false,    	"del_cd",   		false,          "",       dfNone, 		0,    		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		170,   	daLeft,  	false,    	"sh_cust_nm_fax",  	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtDummyCheck,  	20,    	daCenter,  	false,    	"sh_fax_evnt_flg", 	false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,  	false,    	"sh_fax_no",      	false,          "",       dfNone, 		0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	80,   	daCenter,  	false,   	"sh_fax_ntc_snd_rslt_cd",false,     "",       dfNone,     	0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"sh_fax_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		false,       true);

  		             InitDataProperty(0, cnt++ , dtData,      		170,   	daLeft,  	false,    	"cn_cust_nm_fax",  	false,          "",       dfNone, 		0,    		false,      true);
  		             InitDataProperty(0, cnt++ , dtDummyCheck,      20,    	daCenter,  	false,    	"cn_fax_evnt_flg", 	false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,  	false,    	"cn_fax_no", 		false,          "",       dfNone, 		0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	80,   	daCenter,  	false,   	"cn_fax_ntc_snd_rslt_cd",false,     "",       dfNone,     	0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"cn_fax_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		false,       true);

  		             InitDataProperty(0, cnt++ , dtData,     		170,   	daLeft,  	false,    	"nf_cust_nm_fax",	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtDummyCheck,      20,    	daCenter,  	false,    	"nf_fax_evnt_flg",  false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,  	false,    	"nf_fax_no",    	false,          "",       dfNone, 		0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	80,   	daCenter,  	false,   	"nf_fax_ntc_snd_rslt_cd",false,     "",       dfNone,     	0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"nf_fax_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		false,       true);
  		             
  		             InitDataProperty(0, cnt++ , dtData,     		170,   	daLeft,  	false,    	"ctrt_fax_nm",	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,  	false,   	"acct_clss_fax",false,     "",       dfNone,     	0,     		false,       true);
  		             InitDataProperty(0, cnt++ , dtDummyCheck,      20,    	daCenter,  	false,    	"ctrt_fax_evnt_flg",  false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,  	false,    	"ctrt_fax_no",    	false,          "",       dfNone, 		0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	80,   	daCenter,  	false,   	"ctrt_fax_ntc_snd_rslt_cd",false,     "",       dfNone,     	0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"ctrt_fax_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		false,       true);
  		             
  		           
//  		             InitDataProperty(0, cnt++ , dtDummyCheck,      	100,    	daCenter,  	false,    	"key_acct_flg",  false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
//  		             InitDataProperty(0, cnt++ , dtDummyCheck,      	100,    	daCenter,  	false,    	"glo_acct_flg",  false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
//  		             InitDataProperty(0, cnt++ , dtDummyCheck,      	100,    	daCenter,  	false,    	"rgn_acct_flg",  false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
//  		             InitDataProperty(0, cnt++ , dtDummyCheck,      	100,    	daCenter,  	false,    	"lcl_acct_flg",  false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);

  		             // Email
  		             InitDataProperty(0, cnt++ , dtData,      		190,   	daLeft,  	false,    	"sh_cust_nm_eml",  	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtDummyCheck,  	20,    	daCenter,  	false,    	"sh_email_evnt_flg",false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
 		             InitDataProperty(0, cnt++ , dtData,      		180,  	daLeft,  	false,    	"sh_eml",	      	false,          "",       dfNone, 		0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	80,   	daCenter,  	false,   	"sh_eml_ntc_snd_rslt_cd",false,     "",       dfNone,     	0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"sh_eml_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		false,       true);

  		             InitDataProperty(0, cnt++ , dtData,      		190,   	daLeft,  	false,    	"cn_cust_nm_eml", 	false,          "",       dfNone, 		0,    		false,      true);
 		             InitDataProperty(0, cnt++ , dtDummyCheck,      20,    	daCenter,  	false,    	"cn_email_evnt_flg",false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
  		             InitDataProperty(0, cnt++ , dtData,      		180,   	daLeft,  	false,    	"cn_eml",	      	false,          "",       dfNone, 		0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	80,   	daCenter,  	false,   	"cn_eml_ntc_snd_rslt_cd",false,     "",       dfNone,     	0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"cn_eml_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		false,       true);

  		             InitDataProperty(0, cnt++ , dtData,     		190,   	daLeft,  	false,    	"nf_cust_nm_eml",	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtDummyCheck,      20,    	daCenter,  	false,    	"nf_email_evnt_flg",false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
  		             InitDataProperty(0, cnt++ , dtData,      		180,   	daLeft,  	false,    	"nf_eml",	      	false,          "",       dfNone, 		0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	80,   	daCenter,  	false,   	"nf_eml_ntc_snd_rslt_cd",false,     "",       dfNone,     	0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"nf_eml_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		false,       true);
  		             
  		             InitDataProperty(0, cnt++ , dtData,     		190,   	daLeft,  	false,    	"ctrt_eml_nm",	false,          	"",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,  	false,   	"acct_clss_eml",false,     			"",       dfNone,     	0,     		false,       true);
  		             InitDataProperty(0, cnt++ , dtDummyCheck,      20,    	daCenter,  	false,    	"ctrt_email_evnt_flg",false,        "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
  		             InitDataProperty(0, cnt++ , dtData,      		220,   	daLeft,  	false,    	"ctrt_cust_eml",	      	false,  "",       dfNone, 		0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	80,   	daCenter,  	false,   	"ctrt_eml_ntc_snd_rslt_cd",false,   "",       dfNone,     	0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"ctrt_eml_ntc_snd_rslt_nm",false,   "",       dfNone,     	0,     		false,       true);
  		          
  		            
  		             // Hidden
  		             InitDataProperty(0, cnt++ , dtHidden,      	20,    	daCenter,  	false,    	"sh_cust_nm",	   	false,          "",       dfNone, 		0,    		false,      true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	20,    	daCenter,  	false,    	"cn_cust_nm",	   	false,          "",       dfNone, 		0,    		false,      true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	20,    	daCenter,  	false,    	"nf_cust_nm",	   	false,          "",       dfNone, 		0,    		false,      true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	80,   	daCenter,  	false,   	"bkg_no",    		false,          "",       dfNone,     	0,     		true,       true);
//  		             InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	false,   	"sh_fax_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		true,       true);
//  		             InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	false,   	"cn_fax_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		true,       true);
//  		             InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	false,   	"nf_fax_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		true,       true);
//  		             InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	false,   	"sh_eml_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		true,       true);
//  		             InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	false,   	"cn_eml_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		true,       true);
//  		             InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	false,   	"nf_eml_ntc_snd_rslt_nm",false,     "",       dfNone,     	0,     		true,       true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"file_key",			false,     		"",       dfNone,     	0,     		true,       true);
  		             
  		             InitDataValid(0, "sh_fax_no", vtNumericOther, "-,");
  		             InitDataValid(0, "cn_fax_no", vtNumericOther, "-,");
  		             InitDataValid(0, "nf_fax_no", vtNumericOther, "-,");
  		             InitDataValid(0, "ctrt_fax_no", vtNumericOther, "-,");
  		             
  		             FrozenCols = 6;
  	                 CountFormat           = "[SELECTDATAROW / TOTALROWS]";
  	                 ShowButtonImage = 2;
  	                 CountPosition = 2;
  	                 AutoRowHeight = false;
  	                 Ellipsis = true;
  	                 
  	                 WaitImageVisible = false;
 
  		         }
  		         break;
  		         
           	case "sheet2":      //sheet2
 		         with (sheetObj) {
 		             // 높이 설정
 		             style.height = 220;
 		             //전체 너비 설정
 		             SheetWidth = mainTable.clientWidth;
 		
 		             //Host정보 설정[필수][HostIp, Port, PagePath]
 		             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 		
 		             //전체Merge 종류 [선택, Default msNone]
 		             MergeSheet = msNone;
 		
 		             //전체Edit 허용 여부 [선택, Default false]
 		             Editable = true;
 		
 		             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 		             InitRowInfo( 1, 1, 9, 50);
 		
 		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 		             InitColumnInfo(2, 0, 0, true);
 		
 		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
 		             InitHeadMode(true, true, true, true, false,false)
 		             var HeadTitle = "|CNTR No.";
 		
 		             var prefix2 = "sheet2_";
 		             
 		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 		             InitHeadRow(0, HeadTitle, false);
 		             //데이터속성    [	ROW, COL,   DATATYPE,		WIDTH,  DATAALIGN, 	COLMERGE,   SAVENAME,   		KEYFIELD, 	CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,			daCenter,	true,		prefix2 + "ibflag");
 		             InitDataProperty(0, cnt++ , dtData,      		100,    	daCenter,  	false,    	prefix2 + "cntr_no",  	   	false,          "",       dfNone, 		0,     		false,      true);
 		             
 		             WaitImageVisible = false;
 		         }
 		         break;
 		         
           	case "sheet3":      //sheet3
		         with (sheetObj) {
		             // 높이 설정
		             style.height = 100;
		             //전체 너비 설정
		             SheetWidth = mainTable.clientWidth;
		
		             //Host정보 설정[필수][HostIp, Port, PagePath]
		             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		             //전체Merge 종류 [선택, Default msNone]
		             MergeSheet = msNone;
		
		             //전체Edit 허용 여부 [선택, Default false]
		             Editable = true;
		
		             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		             InitRowInfo( 1, 1, 9, 50);
		
		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
		             InitHeadMode(true, true, true, true, false,false);
		             var HeadTitle = "|Seq.|SRC_DAT_TP_CD|BKG No.|B/L No.|POR|POL(Booking)|POD(Booking)|DEL|Shipper|Shipper Address|Consignee|Consignee Address|TEU|FEU";
		             HeadTitle += "|Trunk VVD|Container No.(TP/SZ)|Commodity|Customs Description|B.OFC|BKG Staff|C.OFC|C.SREP|L.OFC|L.SREP"; 			 
		             HeadTitle += "|S/C No.|RFA No.|TAA No.|Forwarder Name|Notify Name|Notify Address|Also Notify Name|Contract Customer Name"; 
		
		             var headCount = ComCountHeadTitle(HeadTitle);

  		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  		             InitColumnInfo(headCount, 0, 0, true);
		             
		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		             InitHeadRow(0, HeadTitle, true);
		             //데이터속성    [	ROW, COL,   DATATYPE,		WIDTH,  DATAALIGN, 	COLMERGE,   SAVENAME,   		KEYFIELD, 	CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		             // Fax
		             InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
		             InitDataProperty(0, cnt++ , dtSeq,       		30,    	daCenter,  	false,    	"seq",          	false,          "",       dfNone,   	0,     		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		80,     daCenter,  	false,    	"src_dat_tp_cd",	false,          "",       dfNone,     	0,     		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"bkg_no",    		false,          "",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"bl_no",    		false,          "",       dfNone,     	0,     		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,    	"por_cd",       	false,          "",       dfNone,    	0,     		false,      true);
		             
		             InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,    	"pol_cd",       	false,          "",       dfNone,    	0,     		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,    	"pod_cd",  		   	false,          "",       dfNone, 		0,     		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,    	"del_cd",   		false,          "",       dfNone, 		0,    		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,    	"sh_cust_nm",	   	false,          "",       dfNone, 		0,    		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"sh_cust_addr",		false,     		"",       dfNone,     	0,     		true,       true);
		             
		             InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,    	"cn_cust_nm",	   	false,          "",       dfNone, 		0,    		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"cn_cust_addr",		false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"teu",				false,    		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"feu",				false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,     daCenter,  	false,    	"vvd",       		false,          "",       dfNone,     	0,     		false,      true);
		             
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"cntr_no1",			false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"cmdt_cd",			false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"cstms_desc",		false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"bkg_ofc_cd",		false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"doc_usr_id",		false,     		"",       dfNone,     	0,     		true,       true);
		             
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"ctrt_ofc_cd",		false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"ctrt_srep_cd",		false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"ob_sls_ofc_cd",	false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"ob_srep_cd",		false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"sc_no",			false,     		"",       dfNone,     	0,     		true,       true);
		             
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"rfa_no",			false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"taa_no",			false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"fn_cust_nm",		false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,    	"nf_cust_nm",	   	false,          "",       dfNone, 		0,    		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"nf_cust_addr",		false,     		"",       dfNone,     	0,     		true,       true);
		             
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"an_cust_nm",		false,     		"",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"ctrt_eml_nm",		false,     		"",       dfNone,     	0,     		true,       true);
		             
		             FrozenCols = 6;
	                 CountFormat           = "[SELECTDATAROW / TOTALROWS]";
	                 ShowButtonImage = 2;
	                 CountPosition = 2;
	                 AutoRowHeight = false;
	                 Ellipsis = true;
	                 
	                 WaitImageVisible = false;

		         }
		         break;
           	case "sheet4":      //sheet2
		         with (sheetObj) {
		             // 높이 설정
		             style.height = 220;
		             //전체 너비 설정
		             SheetWidth = mainTable.clientWidth;
		
		             //Host정보 설정[필수][HostIp, Port, PagePath]
		             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		             //전체Merge 종류 [선택, Default msNone]
		             MergeSheet = msNone;
		
		             //전체Edit 허용 여부 [선택, Default false]
		             Editable = true;
		
		             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		             InitRowInfo( 1, 1, 9, 50);
		
		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		             InitColumnInfo(2, 0, 0, true);
		
		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
		             InitHeadMode(true, true, true, true, false,false)
		             var HeadTitle = "|";
		
		             
		             
		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		             InitHeadRow(0, HeadTitle, false);
		             //데이터속성    [	ROW, COL,   DATATYPE,		WIDTH,  DATAALIGN, 	COLMERGE,   SAVENAME,   		KEYFIELD, 	CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		             InitDataProperty(0, cnt++ , dtData,      		100,    	daCenter,  	false,    	"file_path_rmk",  	   		false,          "",       dfNone, 		0,     		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		100,    	daCenter,  	false,    	"eml_subj_ctnt_seq",  	   	false,          "",       dfNone, 		0,     		false,      true);
		             
		             WaitImageVisible = false;
		         }
		         break;
           }
       }
       
    	/**
        * Sheet 관련 프로세스 처리
        * @param sheetObj
        * @param sAction
        */
	     function doActionIBSheet(formObj,sAction) {
	         switch(sAction) {
				case INIT:    // COMBO SETTING
					formObj.f_cmd.value = INIT;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0003GS.do",sParam);
					
					ComXml2ComboItem(sXml, formObj.src_dat_tp_cd, "val", "name");
					formObj.src_dat_tp_cd.InsertItem(0, "ALL", "A");	
					formObj.src_dat_tp_cd.Code = "A";
					break;
	         	
				case SEARCH:    //조회
					
					
					sheetObjects[0].CheckAll2("fax_chk")=1;
					sheetObjects[0].CheckAll2("sh_fax_evnt_flg")=1;
					sheetObjects[0].CheckAll2("cn_fax_evnt_flg")=1;
					sheetObjects[0].CheckAll2("nf_fax_evnt_flg")=1;
					sheetObjects[0].CheckAll2("ctrt_fax_evnt_flg")=1;
					
					sheetObjects[0].CheckAll2("eml_chk")=1;
					sheetObjects[0].CheckAll2("sh_email_evnt_flg")=1;
					sheetObjects[0].CheckAll2("cn_email_evnt_flg")=1;
					sheetObjects[0].CheckAll2("nf_email_evnt_flg")=1;
					sheetObjects[0].CheckAll2("ctrt_email_evnt_flg")=1;
					
					ComOpenWait(true);
					
//					if(formObj.clss_type[0].checked) {
//						formObj.search_clss_type.value = "KA";
//					}else if (formObj.clss_type[1].checked){
//						formObj.search_clss_type.value = "GA";
//					}else if (formObj.clss_type[2].checked){
//						formObj.search_clss_type.value = "RA";
//					}else if (formObj.clss_type[3].checked){
//						formObj.search_clss_type.value = "LA";
//					}else{
//						formObj.search_clss_type.value = "";
//					}
					
					formObj.f_cmd.value = SEARCH;
					sheetObjects[0].RemoveAll();
					var sParam = FormQueryString(formObj);
					var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0003GS.do",sParam);
					sheetObjects[0].LoadSearchXml(sXml);
					sheetObjects[2].LoadSearchXml(sXml);
					var cntrCnt = ComGetEtcData(sXml, "cntr_cnt").split('@');
					formObj.total_cntr_cnt.value = (cntrCnt[0] == undefined || cntrCnt[0] == "") ? 0 : cntrCnt[0];
					formObj.excel_cntr_cnt.value = (cntrCnt[1] == undefined || cntrCnt[1] == "") ? 0 : cntrCnt[1];
					formObj.bst_cntr_cnt.value = (cntrCnt[2] == undefined || cntrCnt[2] == "") ? 0 : cntrCnt[2];
					 
					formObj.sel_seq.value = ComGetEtcData(sXml, "sel_seq"); 
					
					ComOpenWait(false);
					
					break;
				
				case SEARCH01: //고객정보 조회
					formObj.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0003GS.do", sParam);
					var custNm = ComGetEtcData(sXml, "cust_nm");
					if(custNm == undefined){
						custNm = "";
					}
					formObj.cust_nm.value = custNm;
					break;
				
				case MULTI04:	// Excel Upload
					formObj.f_cmd.value = MULTI04;
	
	                var sParam = FormQueryString(formObj);

	                var sParamSheet1 = sheetObjects[1].GetSaveString();
	    			if (sParamSheet1 != "") {
	    				sParam += "&" + sParamSheet1;
	    			}
	    			
		
	                ComOpenWait(true);	                
	                var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_0003GS.do", sParam);	
//	                sheetObjects[1].RemoveAll(); 
	                var key = ComGetEtcData(sXml, "KEY");
					intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
//	                sheetObjects[1].LoadSaveXml(sXml);

					
	                break;
				
				case MULTI:		// Save
					if(!validateForm(formObj,MULTI))
						return;
					formObj.f_cmd.value = MULTI;
					ComOpenWait(true);
					var sParam = FormQueryString(formObj);
	                sParam = sParam + "&" + ComGetPrefixParam("sheet1_");
	                sheetObjects[0].DoSave("ESM_BKG_0003GS.do", sParam, -1, false);
	                ComOpenWait(false);
	                break;
				
		        case IBSENDFAX: // Fax
		        	if(sheetObjects[0].checkedrows("fax_chk") < 1){
		    	        //Fax만 보낼 수 있는 UI 에서 경고 메세지 :
		    	        //=> BKG40018 : Please select at least one row by mouse click in order to Fax
		    	        ComShowCodeMessage("BKG40018");
		    	        return;
		    	    }
		        	
		        	formObj.f_cmd.value = SEARCH;
		        	formObj.dir_cd.value = "E"; // 생성될 때 E, W, S, N 동시에 생성 되므로 그냥 E로 조회 하는 것 같음 
					sheetObjects[3].DoSearch("ESM_BKG_0004GS.do", FormQueryString(formObj));
					
					if(sheetObjects[3].RowCount > 0){
						formObj.sel_seq.value = sheetObjects[3].CellValue(1, "eml_subj_ctnt_seq");
						if(sheetObjects[0].RowCount > 0){
							for(var i = 1 ; i <= sheetObjects[0].RowCount ; i++ ){
								sheetObjects[0].CellValue2(i,"file_key") = sheetObjects[3].CellValue(1, "file_path_rmk");
							}
						}							
					}
		        	
		        	//if(ComShowConfirm(ComGetMsg("BKG08222",formObj.ofc_cd.value + " [" + formObj.sel_seq.value + "]"))){
		        	if(ComShowConfirm(ComGetMsg("BKG08281",formObj.sel_seq.value,formObj.ofc_cd.value))){	
		        		
		        		fncSendFaxMulti(sheetObjects[0],formObj);
		        	}
		            break;
		            
		        case IBSENDEMAIL: // EMail
		        	
		        	if(sheetObjects[0].checkedrows("eml_chk") < 1){
		    	        //Fax만 보낼 수 있는 UI 에서 경고 메세지 :
		    	        //=> BKG40019 : Please select at least one row by mouse click in order to E-mail
		    	        ComShowCodeMessage("BKG40019");
		    	        return;
		    	    }
		        	
		        	formObj.f_cmd.value = SEARCH;
		        	formObj.dir_cd.value = "E"; // 생성될 때 E, W, S, N 동시에 생성 되므로 그냥 E로 조회 하는 것 같음 
					sheetObjects[3].DoSearch("ESM_BKG_0004GS.do", FormQueryString(formObj));
					
					if(sheetObjects[3].RowCount > 0){
						formObj.sel_seq.value = sheetObjects[3].CellValue(1, "eml_subj_ctnt_seq");
						if(sheetObjects[0].RowCount > 0){
							for(var i = 1 ; i <= sheetObjects[0].RowCount ; i++ ){
								sheetObjects[0].CellValue2(i,"file_key") = sheetObjects[3].CellValue(1, "file_path_rmk");
							}
						}							
					}
					
		        	//if(ComShowConfirm(ComGetMsg("BKG08222",formObj.ofc_cd.value + " [" + formObj.sel_seq.value + "]"))){
		        	if(ComShowConfirm(ComGetMsg("BKG08281",formObj.sel_seq.value,formObj.ofc_cd.value))){	
		        		fncSendMailMulti(sheetObjects[0],formObj);
		        	}
		            break;
		            
		        case MULTI05:    //조회			
		        	
		        	sheetObjects[0].RemoveAll(); 
					sheetObjects[0].CheckAll2("fax_chk")=1;
					sheetObjects[0].CheckAll2("sh_fax_evnt_flg")=1;
					sheetObjects[0].CheckAll2("cn_fax_evnt_flg")=1;
					sheetObjects[0].CheckAll2("nf_fax_evnt_flg")=1;
					sheetObjects[0].CheckAll2("ctrt_fax_evnt_flg")=1;
					
					sheetObjects[0].CheckAll2("eml_chk")=1;
					sheetObjects[0].CheckAll2("sh_email_evnt_flg")=1;
					sheetObjects[0].CheckAll2("cn_email_evnt_flg")=1;
					sheetObjects[0].CheckAll2("nf_email_evnt_flg")=1;
					sheetObjects[0].CheckAll2("ctrt_email_evnt_flg")=1;
					
					ComOpenWait(true);
					
					formObj.f_cmd.value = MULTI05;
	                var sParam = FormQueryString(formObj);
	                var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0003GS.do", sParam);	
	                sheetObjects[0].RemoveAll(); 
	                
	                // 중복체크
	                var errCd = ComGetEtcData(sXml, "err");
//	                if (errCd=="err") {
//	                	sheetObjects[0].LoadSaveXml(sXml);
//	                	formObj.cntr_cnt.value = "0";
//						ComShowCodeMessage('BKG00547');	
//						ComOpenWait(false);
//						break;
//					}
	                
	                if (errCd=="cntIsZero") {
	                	sheetObjects[0].LoadSaveXml(sXml);
	                	formObj.cntr_cnt.value = "0";
	                	ComShowCodeMessage('BKG03055');	
	                	ComOpenWait(false);
	                	break;
	                }
	                
	                // 에러가 아니면 KEY로 BackEndJob 상태 체크
	                var key = ComGetEtcData(sXml, "KEY");
					intervalId = setInterval("doActionBackEndResultForBST(sheetObjects[0], '" + key + "');", 3000);
	                sheetObjects[0].LoadSaveXml(sXml);
	                
					break;		            
	         }
	     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      * @param formObj
      * @param sAction
      */
     function validateForm(formObj,sAction){
    	  switch(sAction) {
    	  	case SEARCH:      //조회
    	  		if(ComIsNull(formObj.vvd)){
    	  			ComShowCodeMessage("BKG00115");
    	  			ComSetFocus(formObj.vvd);
    	  			return false;
    	  		}
    	  		
    	  		if(!ComChkValid(formObj)){
    	  			return false;
    	  		}

    	  		if(formObj.e_dir_cd.checked == false && formObj.w_dir_cd.checked == false && formObj.s_dir_cd.checked == false && formObj.n_dir_cd.checked == false){
    	  			ComShowCodeMessage("BKG00145");
    	  			return false;
    	  		}
    	  		
    	  		if(formObj.bkg_no.value != "" && formObj.cntr_no.value !=""){
    	  			ComShowCodeMessage("BKG95130");
    	  			ComSetFocus(formObj.bkg_no);
    	  			return false;
    	  		}
    	  		
    	  		return true;
    	  		break;

    	  	case MULTI:      //저장

	            if(!ComChkValid(formObj)){
			    	 ComShowCodeMessage('BKG00501');
			    	 return false;
			    }
    	  		if(formObj.e_dir_cd.checked == false && formObj.w_dir_cd.checked == false && formObj.s_dir_cd.checked == false && formObj.n_dir_cd.checked == false){
    	  			ComShowCodeMessage("BKG00145");
    	  			return false;
    	  		}
				return true;
				break;
			
    	  	case IBDOWNLOAD: // download
    	  		if(sheetObjects[2].LastRow == 0){
    	  			ComShowCodeMessage("BKG00109");
    	  			return false;
    	  		}
    	  		return true;
    	  		break;
    	  		
    	  	case IBUPLOAD: // upload
    	  		if(ComIsNull(formObj.vvd)){
    	  			ComShowCodeMessage("BKG00115");
    	  			ComSetFocus(formObj.vvd);
    	  			return false;
    	  		}
    	  		
    	  		if(!ComChkValid(formObj)){
    	  			return false;
    	  		}
    	  		
    	  		if(formObj.e_dir_cd.checked == false && formObj.w_dir_cd.checked == false && formObj.s_dir_cd.checked == false && formObj.n_dir_cd.checked == false){
    	  			ComShowCodeMessage("BKG00145");
    	  			return false;
    	  		}
    	  		return true;
    	  		break;
    	  		
    	  	case IBSENDFAX: // Fax Send

    	  		// Fax에 체크가 되어있는지 검증
    		    var maxRow = sheetObjects[0].LastRow;
    		    for(i=1;i <= maxRow ; i++){
    				if(sheetObjects[0].CellValue( i, "sh_fax_evnt_flg") == "0" && 
    						sheetObjects[0].CellValue( i, "cn_fax_evnt_flg") == "0" &&
    						sheetObjects[0].CellValue( i, "nf_fax_evnt_flg") == "0" &&
    						sheetObjects[0].CellValue( i, "ctrt_fax_evnt_flg") == "0")
    					//=> BKG40018 : Please select at least one row by mouse click in order to Fax
    					ComShowCodeMessage('BKG40018');
    					return true;
    		    }
    		    return false;
    	  		break;
    	  		
    	  	case IBSENDEMAIL: // EMail Send

    	  		// EMail에 체크가 되어있는지 검증
    		    var maxRow = sheetObjects[0].LastRow;
    		    for(i=1;i <= maxRow ; i++){
    				if(sheetObjects[0].CellValue( i, "sh_email_evnt_flg") == "0" && 
    						sheetObjects[0].CellValue( i, "cn_email_evnt_flg") == "0" &&
    						sheetObjects[0].CellValue( i, "nf_email_evnt_flg") == "0" &&
    						sheetObjects[0].CellValue( i, "ctrt_email_evnt_flg") == "0" )
    					//=> BKG40019 : Please select at least one row by mouse click in order to E-mail
    					ComShowCodeMessage('BKG40019');
    					return true;
    		    }
    		    return false;
    	  		break;
    	  		
    	  	case IBTEMPLATE: // template
    	  		if(ComIsNull(formObj.vvd)){
    	  			ComShowCodeMessage("BKG00115");
    	  			ComSetFocus(formObj.vvd);
    	  			return false;
    	  		}
    	  		
    	  		if(!ComChkValid(formObj)){
    	  			return false;
    	  		}
    	  		if(formObj.e_dir_cd.checked == false && formObj.w_dir_cd.checked == false && formObj.s_dir_cd.checked == false && formObj.n_dir_cd.checked == false){
    	  			ComShowCodeMessage("BKG00145");
    	  			return false;
    	  		}
    	  		return true;
    	  		break;
    	  }    	  
     }


     /**
      * sheet1 OnClick후 이벤트 
      * @param {ibsheet} sheetObj 해당 시트   
      * @param {long} row 해당 셀의 Row Index
      * @param {long} col 해당 셀의 Column Index
      * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
     function sheet1_OnClick(sheetObj , row, col, value) {  
    	var formObj = document.form; 

        var colSaveName = sheetObj.ColSaveName(col);

        switch(colSaveName) {
	    	case "cntr_no" :
	    		/* 긴 문자열 MemoPad 처리*/
	    		if(sheetObj.CellValue(row,col) != "") {
	    			ComShowMemoPad(sheetObj, null, null, true, 250, 80);
	    		}
	    		break;
	        }
        
     }     

 	/**
      * Tab Change 이벤트
      * @param tabObj
      * @param nItem
      */
    function tab1_OnChange(tabObj , nItem)
    {

        var objs = document.all.item("tabLayer");
        var sheetObj = sheetObjects[0];
        if(nItem == 0){//Fax

            sheetObj.ColHidden("fax_chk") = false;
            sheetObj.ColHidden("sh_fax_evnt_flg") = false;
            sheetObj.ColHidden("sh_cust_nm_fax") = false;
            sheetObj.ColHidden("sh_fax_no") = false;
            sheetObj.ColHidden("cn_fax_evnt_flg") = false;
            sheetObj.ColHidden("cn_cust_nm_fax") = false;
            sheetObj.ColHidden("cn_fax_no") = false;
            sheetObj.ColHidden("nf_fax_evnt_flg") = false;
            sheetObj.ColHidden("nf_cust_nm_fax") = false;
            sheetObj.ColHidden("nf_fax_no") = false;
            sheetObj.ColHidden("ctrt_fax_nm") = false;
            sheetObj.ColHidden("ctrt_fax_evnt_flg") = false;
            sheetObj.ColHidden("ctrt_fax_no") = false;
            sheetObj.ColHidden("acct_clss_fax") = false;

            sheetObj.ColHidden("sh_fax_ntc_snd_rslt_nm") = false;
            sheetObj.ColHidden("cn_fax_ntc_snd_rslt_nm") = false;
            sheetObj.ColHidden("nf_fax_ntc_snd_rslt_nm") = false;
            sheetObj.ColHidden("ctrt_fax_ntc_snd_rslt_nm") = false;
            
            sheetObj.ColHidden("eml_chk") = true;
            sheetObj.ColHidden("sh_email_evnt_flg") = true;
            sheetObj.ColHidden("sh_cust_nm_eml") = true;
            sheetObj.ColHidden("sh_eml") = true;
            sheetObj.ColHidden("cn_email_evnt_flg") = true;
            sheetObj.ColHidden("cn_cust_nm_eml") = true;
            sheetObj.ColHidden("cn_eml") = true;
            sheetObj.ColHidden("nf_email_evnt_flg") = true;
            sheetObj.ColHidden("nf_cust_nm_eml") = true;
            sheetObj.ColHidden("nf_eml") = true;
            sheetObj.ColHidden("ctrt_eml_nm") = true;
            sheetObj.ColHidden("ctrt_email_evnt_flg") = true;
            sheetObj.ColHidden("ctrt_cust_eml") = true;
            sheetObj.ColHidden("acct_clss_eml") = true;
            
            sheetObj.ColHidden("sh_eml_ntc_snd_rslt_nm") = true;
            sheetObj.ColHidden("cn_eml_ntc_snd_rslt_nm") = true;
            sheetObj.ColHidden("nf_eml_ntc_snd_rslt_nm") = true;
            sheetObj.ColHidden("ctrt_eml_ntc_snd_rslt_nm") = true;
            
            ComBtnEnable("btn_fax");
            ComBtnDisable("btn_email");


        }else if(nItem == 1){//E-Mail

            sheetObj.ColHidden("fax_chk") = true;
            sheetObj.ColHidden("sh_fax_evnt_flg") = true;
            sheetObj.ColHidden("sh_cust_nm_fax") = true;
            sheetObj.ColHidden("sh_fax_no") = true;
            sheetObj.ColHidden("cn_fax_evnt_flg") = true;
            sheetObj.ColHidden("cn_cust_nm_fax") = true;
            sheetObj.ColHidden("cn_fax_no") = true;
            sheetObj.ColHidden("nf_fax_evnt_flg") = true;
            sheetObj.ColHidden("nf_cust_nm_fax") = true;
            sheetObj.ColHidden("nf_fax_no") = true;
            sheetObj.ColHidden("ctrt_fax_evnt_flg") = true;
            sheetObj.ColHidden("ctrt_fax_nm") = true;
            sheetObj.ColHidden("ctrt_fax_no") = true;
            sheetObj.ColHidden("acct_clss_fax") = true;
            
            sheetObj.ColHidden("sh_fax_ntc_snd_rslt_nm") = true;
            sheetObj.ColHidden("cn_fax_ntc_snd_rslt_nm") = true;
            sheetObj.ColHidden("nf_fax_ntc_snd_rslt_nm") = true;
            sheetObj.ColHidden("ctrt_fax_ntc_snd_rslt_nm") = true;
            

            sheetObj.ColHidden("eml_chk") = false;
            sheetObj.ColHidden("sh_email_evnt_flg") = false;
            sheetObj.ColHidden("sh_cust_nm_eml") = false;
            sheetObj.ColHidden("sh_eml") = false;
            sheetObj.ColHidden("cn_email_evnt_flg") = false;
            sheetObj.ColHidden("cn_cust_nm_eml") = false;
            sheetObj.ColHidden("cn_eml") = false;
            sheetObj.ColHidden("nf_email_evnt_flg") = false;
            sheetObj.ColHidden("nf_cust_nm_eml") = false;
            sheetObj.ColHidden("nf_eml") = false;
            sheetObj.ColHidden("ctrt_eml_nm") = false;
            sheetObj.ColHidden("ctrt_email_evnt_flg") = false;
            sheetObj.ColHidden("ctrt_cust_eml") = false;
            sheetObj.ColHidden("acct_clss_eml") = false;
            
            sheetObj.ColHidden("sh_eml_ntc_snd_rslt_nm") = false;
            sheetObj.ColHidden("cn_eml_ntc_snd_rslt_nm") = false;
            sheetObj.ColHidden("nf_eml_ntc_snd_rslt_nm") = false;
            sheetObj.ColHidden("ctrt_eml_ntc_snd_rslt_nm") = false;

            ComBtnEnable("btn_email");
            ComBtnDisable("btn_fax");

        }
        beforetab = nItem;

        return;


        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";

        //--------------- 요기가 중요 --------------------------//
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    //------------------------------------------------------//



    }
    
	/**
    * 조회 완료 후 실행
    * Fax,Email에서 공통으로 사용하는 Customer Name을 해당 시트에 셋팅
    * @param sheetObj
    * @param ErrMsg
    */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {

	    var maxRow = sheetObj.LastRow;
	    var cellValue = "";
	    for(i=1;i <= maxRow ; i++){
			sheetObj.CellValue2( i, "sh_cust_nm_fax") = sheetObj.CellValue(i, "sh_cust_nm");
			sheetObj.CellValue2( i, "sh_cust_nm_eml") = sheetObj.CellValue(i, "sh_cust_nm");
			sheetObj.CellValue2( i, "cn_cust_nm_fax") = sheetObj.CellValue(i, "cn_cust_nm");
			sheetObj.CellValue2( i, "cn_cust_nm_eml") = sheetObj.CellValue(i, "cn_cust_nm");
			sheetObj.CellValue2( i, "nf_cust_nm_fax") = sheetObj.CellValue(i, "nf_cust_nm");
			sheetObj.CellValue2( i, "nf_cust_nm_eml") = sheetObj.CellValue(i, "nf_cust_nm");

			// Sheet 내용을 임의로 변경했으므로 Read Type으로 수정한다.
			sheetObj.CellValue2( i, "ibflag") = "R";
			
			var faxCheck = false;
			
			// FaxNo 혹은 EMail주소가 있으면 해당 event Flag를 체크한다.
			if(sheetObj.CellValue( i, "sh_fax_no") != "" 
				&& sheetObj.CellValue( i, "sh_fax_no") != "N/A" 
					&& sheetObj.CellValue( i, "sh_fax_no") != "n/a") {
				sheetObj.CellValue2( i, "sh_fax_evnt_flg") = "1";
				faxCheck = true;
			}
			if(sheetObj.CellValue( i, "cn_fax_no") != "" 				
				&& sheetObj.CellValue( i, "cn_fax_no") != "N/A" 
					&& sheetObj.CellValue( i, "cn_fax_no") != "n/a") {
				sheetObj.CellValue2( i, "cn_fax_evnt_flg") = "1";
				faxCheck = true;
			}
			if(sheetObj.CellValue( i, "nf_fax_no") != ""
				&& sheetObj.CellValue( i, "nf_fax_no") != "N/A" 
					&& sheetObj.CellValue( i, "nf_fax_no") != "n/a") {
				sheetObj.CellValue2( i, "nf_fax_evnt_flg") = "1";
				faxCheck = true;
			}
			if(sheetObj.CellValue( i, "ctrt_fax_no") != ""
				&& sheetObj.CellValue( i, "ctrt_fax_no") != "N/A" 
					&& sheetObj.CellValue( i, "ctrt_fax_no") != "n/a") {
				sheetObj.CellValue2( i, "ctrt_fax_evnt_flg") = "1";
				faxCheck = true;
			}
			if (faxCheck) {
				sheetObj.CellValue2( i, "fax_chk") = "1";
			} else {
				sheetObj.CellValue2( i, "fax_chk") = "0";
			}
			
			var emlCheck = false;
			if(sheetObj.CellValue( i, "sh_eml") != ""
				&& sheetObj.CellValue( i, "sh_eml") != "N/A" 
					&& sheetObj.CellValue( i, "sh_eml") != "n/a") {
				sheetObj.CellValue2( i, "sh_email_evnt_flg") = "1";
				emlCheck = true;
			}
			if(sheetObj.CellValue( i, "cn_eml") != ""
				&& sheetObj.CellValue( i, "cn_eml") != "N/A" 
					&& sheetObj.CellValue( i, "cn_eml") != "n/a") {
				sheetObj.CellValue2( i, "cn_email_evnt_flg") = "1";
				emlCheck = true;
			}
			if(sheetObj.CellValue( i, "nf_eml") != ""
				&& sheetObj.CellValue( i, "nf_eml") != "N/A" 
					&& sheetObj.CellValue( i, "nf_eml") != "n/a") {
				sheetObj.CellValue2( i, "nf_email_evnt_flg") = "1";
				emlCheck = true;
			}
			if(sheetObj.CellValue( i, "ctrt_cust_eml") != ""
				&& sheetObj.CellValue( i, "ctrt_cust_eml") != "N/A" 
					&& sheetObj.CellValue( i, "ctrt_cust_eml") != "n/a") {
				sheetObj.CellValue2( i, "ctrt_email_evnt_flg") = "1";
				emlCheck = true;
			}
			
			if (emlCheck) {
				sheetObj.CellValue2( i, "eml_chk") = "1";
			} else{
				sheetObj.CellValue2( i, "eml_chk") = "0";
			}
			
			// 전송 상태에 따라 글자색을 변경한다.
			// Fax
            sentColorSet(sheetObj, i, "sh_fax_no", sheetObj.CellValue( i,"sh_fax_ntc_snd_rslt_cd"), "fax");
            sentColorSet(sheetObj, i, "cn_fax_no", sheetObj.CellValue( i,"cn_fax_ntc_snd_rslt_cd"), "fax");
            sentColorSet(sheetObj, i, "nf_fax_no", sheetObj.CellValue( i,"nf_fax_ntc_snd_rslt_cd"), "fax");
            sentColorSet(sheetObj, i, "ctrt_fax_no", sheetObj.CellValue( i,"ctrt_fax_ntc_snd_rslt_cd"), "fax");
            // Email
            sentColorSet(sheetObj, i, "sh_eml", sheetObj.CellValue( i,"sh_eml_ntc_snd_rslt_cd"), "email");
            sentColorSet(sheetObj, i, "cn_eml", sheetObj.CellValue( i,"cn_eml_ntc_snd_rslt_cd"), "email");
            sentColorSet(sheetObj, i, "nf_eml", sheetObj.CellValue( i,"nf_eml_ntc_snd_rslt_cd"), "email");
            sentColorSet(sheetObj, i, "ctrt_cust_eml", sheetObj.CellValue( i,"ctrt_eml_ntc_snd_rslt_cd"), "email");
            
            // 풍선 도움말 설정
            sheetObj.ToolTipText( i, "sh_fax_no") = sheetObj.CellValue( i, "sh_fax_ntc_snd_rslt_nm");
            sheetObj.ToolTipText( i, "cn_fax_no") = sheetObj.CellValue( i, "cn_fax_ntc_snd_rslt_nm");
            sheetObj.ToolTipText( i, "nf_fax_no") = sheetObj.CellValue( i, "nf_fax_ntc_snd_rslt_nm");
            sheetObj.ToolTipText( i, "ctrt_fax_no") = sheetObj.CellValue( i, "ctrt_fax_ntc_snd_rslt_nm");
            
            sheetObj.ToolTipText( i, "sh_eml") = sheetObj.CellValue( i, "sh_eml_ntc_snd_rslt_nm");
            sheetObj.ToolTipText( i, "cn_eml") = sheetObj.CellValue( i, "cn_eml_ntc_snd_rslt_nm");
            sheetObj.ToolTipText( i, "nf_eml") = sheetObj.CellValue( i, "nf_eml_ntc_snd_rslt_nm");
            sheetObj.ToolTipText( i, "ctrt_cust_eml") = sheetObj.CellValue( i, "ctrt_eml_ntc_snd_rslt_nm");
	    }
	}

	/**
    * 엑셀업로드후 저장
    * @param sheetObj
    * @return
    */
   function sheet2_OnLoadExcel(sheetObj){

	   var formObj = document.form;
	   
		if(!ComShowConfirm(ComGetMsg("BKG00498", " the Excel Upload data"))) {
			sheetObjects[1].RemoveAll();
        	return false;
        }
	   
	   // 엑셀업로드 한 내용을 DB에 저장
	   doActionIBSheet(formObj,MULTI04);
   }
   
   /**
    * Upload 후 조회 이벤트를 수행
    * @param sheetObj
    * @param errMessage
    */
   function sheet2_OnSaveEnd(sheetObj,errMessage){
	   var formObj = document.form;
	   if (formObj.f_cmd.value == MULTI04) {
		    if (errMessage != ""){
		    	return;
		    }
	
		   // 조회
	 	   doActionIBSheet(formObj,SEARCH);
	   }
   }

   /**
    * Fax 발송
    * @param sheetObj
    * @param formObj
    */
   function fncSendFaxMulti(sheetObj,formObj){
	   
	    if(sheetObj.checkedrows("fax_chk") < 1){
	        //Fax만 보낼 수 있는 UI 에서 경고 메세지 :
	        //=> BKG40018 : Please select at least one row by mouse click in order to Fax
	        ComShowCodeMessage("BKG40018");
	        return;
	    }
	    
	    if(!ComShowCodeConfirm("BKG40037","Customer Advisory")){
	        return;
	    }

	    
//	    //메일 주소가 없거나, no-email 일 경우 return 처리
//		for(i=1; i <= sheetObj.LastRow ; i++){ 
//			var ctFaxFlg = sheetObj.CellValue( i,"ctrt_fax_evnt_flg");
//			var ctCustFax = sheetObj.CellValue( i,"ctrt_fax_no");
//			var shFaxFlg = sheetObj.CellValue( i,"sh_fax_evnt_flg");
//			var shCustFax = sheetObj.CellValue( i,"sh_fax_no");
//			var cnFaxFlg = sheetObj.CellValue( i,"cn_fax_evnt_flg");
//			var cnCustFax = sheetObj.CellValue( i,"cn_fax_no");
//			var nfFaxFlg = sheetObj.CellValue( i,"nf_fax_evnt_flg");
//			var nfCustFax = sheetObj.CellValue( i,"nf_fax_no");
//			
//			if(sheetObj.CellValue( i, "fax_chk")=="1"){
//
//		    	if(((ctFaxFlg =="1") &&(ctCustFax =="")) ||
//		    	((shFaxFlg =="1") &&(shCustFax ==""))||
//		    	((cnFaxFlg =="1") &&(cnCustFax ==""))||
//		    	((nfFaxFlg =="1") &&(nfCustFax =="")))
//		    	{
//		    		ComShowCodeMessage("BKG43046");
//		    			return;
//		    		}
//		    	}
//		    }
	    
	    
	    formObj.f_cmd.value = MULTI02;
	    var sParam = FormQueryString(formObj);
//	    sheetObj.WaitImageVisible=false;
	    
	    sheetObj.DoSave("ESM_BKG_0003GS.do", sParam, "fax_chk", false);
	    
	    // Fax 전송 후 ChkBox 초기화
	    var maxRow = sheetObj.LastRow;
	    var cellValue = "";
	    for(i=1;i <= maxRow ; i++){
			sheetObj.CellValue( i, "fax_chk") = "0";
	    }
   }
   
   /**
    * EMail 발송
    * @param sheetObj
    * @param formObj
    */
   function fncSendMailMulti(sheetObj,formObj){

	    if(sheetObj.checkedrows("eml_chk") < 1){
	        //Fax만 보낼 수 있는 UI 에서 경고 메세지 :
	        //=> BKG40019 : Please select at least one row by mouse click in order to E-mail
	        ComShowCodeMessage("BKG40019");
	        return;
	    }
	    
	    if(!ComShowCodeConfirm("BKG40038","Customer Advisory")){
	        return;
	    }
	    
	    //메일 주소가 없거나, no-email 일 경우 return 처리
	for(i=1; i <= sheetObj.LastRow ; i++){ 
		var ctEmailFlg = sheetObj.CellValue( i,"ctrt_email_evnt_flg");
		var ctCustEml = sheetObj.CellValue( i,"ctrt_cust_eml");
		var shEmailFlg = sheetObj.CellValue( i,"sh_email_evnt_flg");
		var shCustEml = sheetObj.CellValue( i,"sh_eml");
		var cnEmailFlg = sheetObj.CellValue( i,"cn_email_evnt_flg");
		var cnCustEml = sheetObj.CellValue( i,"cn_eml");
		var nfEmailFlg = sheetObj.CellValue( i,"nf_email_evnt_flg");
		var nfCustEml = sheetObj.CellValue( i,"nf_eml");
		
		if(sheetObj.CellValue( i, "eml_chk")=="1"){

	    	if(((ctEmailFlg =="1") &&(ctCustEml ==""|| ctCustEml =="no general e-mail"||ctCustEml =="NO E-MAIL"||ctCustEml =="no email")) ||
	    	((shEmailFlg =="1") &&(shCustEml ==""|| shCustEml =="no general e-mail"||shCustEml =="NO E-MAIL"||shCustEml =="no email"))||
	    	((cnEmailFlg =="1") &&(cnCustEml ==""|| cnCustEml =="no general e-mail"||cnCustEml =="NO E-MAIL"||cnCustEml =="no email"))||
	    	((nfEmailFlg =="1") &&(nfCustEml ==""|| nfCustEml =="no general e-mail"||nfCustEml =="NO E-MAIL"||nfCustEml =="no email")))
	    	{
	    		ComShowCodeMessage("BKG43045");
	    			return;
	    		}
	    	}
	    }
	    
	    
	    formObj.f_cmd.value = MULTI03;
	    var sParam = FormQueryString(formObj);
       
	    sheetObj.DoSave("ESM_BKG_0003GS.do", sParam, "eml_chk", false);
	    
	    // EMail 전송 후 ChkBox 초기화
	    var maxRow = sheetObj.LastRow;
	    var cellValue = "";
	    for(i=1;i <= maxRow ; i++){
			sheetObj.CellValue( i, "eml_chk") = "0";
	    }
	    
	}
   
   /**
    * vvd가 입력되었을때만 해당 버튼(Retreieve, Upload, Template)을 활성화
    * 사용하지 않는 기능
    */
   function setActiveBtn(){
	   var formObj = document.form;
	   var vvd = formObj.vvd.value;
	   
	   if(vvd == ""){
		   ComBtnDisable("btn_retrieve");
		   ComBtnDisable("btn_uploadExcel");
		   ComBtnDisable("btn_template");
	   } else {
		   ComBtnEnable("btn_retrieve");
		   ComBtnEnable("btn_uploadExcel");
		   ComBtnEnable("btn_template");
	   }
	   
   }
   
   /**
    * 개별 Fax, Email가 하나라도 체크되어 있으면 전체 Chk가 체크되게 제어 
    * @param sheetObj
    * @param Row
    * @param Col
    */
   function sheet1_OnChange(sheetObj, Row, Col) {
	    var colName = sheetObj.ColSaveName(Col);

	    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    //하나라도 체크시 앞에 체크박스 체크[FAX]
	    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    if(beforetab == 0){

	    	// 1. FaxNo가 입력되면 FaxFlag를 Check
	    	// 	  FaxNo가 삭제되면 FaxFlag를 Uncheck
	        if(colName == "sh_fax_no"
	                || colName == "cn_fax_no"
	                || colName == "nf_fax_no" || colName == "ctrt_fax_no"){

	                if(sheetObj.CellValue(Row,Col) != ""){
	                    sheetObj.CellValue2(Row,Col -1 ) = "1";
	                }else{
	                    sheetObj.CellValue2(Row,Col -1 ) = "0";
	                }
	        }
	        
	    	// 2. Fax Event Flag가 1개라도 체크되면 왼쪽 전체 Flag가 Check
	    	//    Fax Event Flag가 모두 언체크되면 왼쪽 전체 Flag가 Uncheck

	    	var faxChkFlg = sheetObj.CellValue(Row, "fax_chk");
	    	var shFaxFlg = sheetObj.CellValue(Row, "sh_fax_evnt_flg");
	    	var cnFaxFlg = sheetObj.CellValue(Row, "cn_fax_evnt_flg");
	    	var nfFaxFlg = sheetObj.CellValue(Row, "nf_fax_evnt_flg");
	    	var ctFaxFlg = sheetObj.CellValue(Row, "ctrt_fax_evnt_flg");

	        if(colName == "sh_fax_evnt_flg" || 
	        	colName == "cn_fax_evnt_flg" || 
	        	colName == "nf_fax_evnt_flg" || colName == "ctrt_fax_evnt_flg" ||(colName == "fax_chk" && faxChkFlg != "0")){
	        	
	        	if(shFaxFlg == "1"|| cnFaxFlg == "1"|| nfFaxFlg == "1"|| ctFaxFlg == "1"){
        			sheetObj.CellValue2(Row, "fax_chk") = "1";
	        			
	        	} else if(shFaxFlg == "0" || cnFaxFlg == "0" || nfFaxFlg == "0"|| ctFaxFlg == "0"){

	        		if(shFaxFlg == "0" && cnFaxFlg == "0" && nfFaxFlg == "0"&& ctFaxFlg == "0"){
	        			sheetObj.CellValue2(Row, "fax_chk") = "0";
	                } else {
	                	sheetObj.CellValue2(Row, "fax_chk") = "1";
	                }
	            }
	        	
	        	// 3. FaxNo가 존재하지 않으면 Fax Event Flag를 제어하지 못하도록 설정
                if(sheetObj.CellValue(Row,Col+1) != ""
                	&& sheetObj.CellValue(Row,Col+1) != "N/A"
                		&& sheetObj.CellValue(Row,Col+1) != "n/a") {
                    sheetObj.CellValue2(Row,Col) = sheetObj.CellValue(Row,Col);
                }else{
                    sheetObj.CellValue(Row,Col) = "0";
                }
	        }
	    }
	    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    //하나라도 체크시 앞에 체크박스 체크(EMAIL)
	    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    else if(beforetab == 1){

	    	// 1. Email에 값이 있을 경우, Focus Out시 Email 포맷에 대한 Valdation 체크
	        if(colName == "sh_eml" || 
		        	colName == "cn_eml" || 
		        	colName == "nf_eml"||colName == "ctrt_cust_eml"){

	        	if(sheetObj.CellValue(Row,Col) != ""){
	        		var splitEmlAddrs =  sheetObj.CellValue(Row,Col);
	        		splitEmlAddrs = splitEmlAddrs.split(";");
	        	
	        		for(var i=0; i<splitEmlAddrs.length; i++){
			            if(!ComIsEmailAddr(splitEmlAddrs[i])){
			            	
			                ComShowCodeMessage("BKG40021" , splitEmlAddrs[i]);
			                sheetObj.CellValue2(Row, Col) = "";
			                sheetObj.SelectCell(Row, Col);
			                
			                switch (colName) {
		                		case "sh_eml" : sheetObj.CellValue2(Row, "sh_email_evnt_flg") = "0"; break;
			                	case "cn_eml" : sheetObj.CellValue2(Row, "cn_email_evnt_flg") = "0"; break;
			                	case "nf_eml" : sheetObj.CellValue2(Row, "nf_email_evnt_flg") = "0"; break;
			                	case "ctrt_cust_eml" : sheetObj.CellValue2(Row, "ctrt_email_evnt_flg") = "0"; break;
			                }
			                
			                return;
			            }
	        		}
	        	}
	        	
	        	
		    	//    Email 주소가 입력되면 EmailFlag를 Check
		    	// 	  Email 주소가 삭제되면 EmailFlag를 Uncheck
                if(sheetObj.CellValue(Row,Col) != ""){
                    sheetObj.CellValue2(Row,Col -1 ) = "1";
                }else{
                    sheetObj.CellValue2(Row,Col -1 ) = "0";
                }

	        }
	        
	    	// 2. EMail Event Flag가 1개라도 체크되면 왼쪽 전체 Flag가 Check
	    	//    EMail Event Flag가 모두 언체크되면 왼쪽 전체 Flag가 Uncheck
	        
	    	var emlChkFlg = sheetObj.CellValue(Row, "eml_chk");
	    	var shEmlFlg = sheetObj.CellValue(Row, "sh_email_evnt_flg");
	    	var cnEmlFlg = sheetObj.CellValue(Row, "cn_email_evnt_flg");
	    	var nfEmlFlg = sheetObj.CellValue(Row, "nf_email_evnt_flg");
	    	var ctEmlFlg = sheetObj.CellValue(Row, "ctrt_email_evnt_flg");
	    	
	        if(colName == "sh_email_evnt_flg" || 
	        	colName == "cn_email_evnt_flg" || 
	        	colName == "nf_email_evnt_flg" || colName == "ctrt_email_evnt_flg" || (colName == "eml_chk" && emlChkFlg != "0") ){

	        	if(shEmlFlg == "1"|| cnEmlFlg == "1"|| nfEmlFlg == "1" ||ctEmlFlg =="1"){
        			sheetObj.CellValue2(Row, "eml_chk") = "1";
	        			
	        	} else if(shEmlFlg == "0" || cnEmlFlg == "0" || nfEmlFlg == "0" ||ctEmlFlg =="0"){

	        		if(shEmlFlg == "0" && cnEmlFlg == "0" && nfEmlFlg == "0"&& ctEmlFlg == "0"){
	        			sheetObj.CellValue2(Row, "eml_chk") = "0";
	                } else {
	                	sheetObj.CellValue2(Row, "eml_chk") = "1";
	                }
	            }
	        	
	        	// 3. EMail 주소가 존재하지 않으면 EMail Event Flag를 제어하지 못하도록 설정
                if(sheetObj.CellValue(Row,Col+1) != ""
                	&& sheetObj.CellValue(Row,Col+1) != "N/A"
                		&& sheetObj.CellValue(Row,Col+1) != "n/a") {
                    sheetObj.CellValue2(Row,Col) = sheetObj.CellValue(Row,Col);
                }else{
                    sheetObj.CellValue(Row,Col) = "0";
                }
	        }
	    }

	}
   
   /**
    * 개별 Fax, Email가 하나라도 체크되어 있으면 전체 Chk가 체크되게 제어 
    * @param sheetObj
    * @param Row
    * @param Col
    */
   function sheet1_OnAfterEdit(sheetObj, Row, Col) {
	    var colName = sheetObj.ColSaveName(Col);

	    if(beforetab == 0){

	        if(colName == "sh_fax_no"
	            || colName == "cn_fax_no"
	            || colName == "nf_fax_no" ||colName == "ctrt_fax_no" ){

	            if(sheetObj.CellValue(Row,Col) != ""){
	                sheetObj.CellValue(Row,Col -1 ) = "1";
	            }else{
	                sheetObj.CellValue(Row,Col -1 ) = "0";
	            }
	        }


	    }else if(beforetab == 1){
	        if(colName == "sh_eml"
	            || colName == "cn_eml"
	            || colName == "nf_eml" ||colName == "ctrt_cust_eml" ){

	            if(sheetObj.CellValue(Row,Col) != ""){
	                sheetObj.CellValue(Row,Col -1 ) = "1";
	            }else{
	                sheetObj.CellValue(Row,Col -1 ) = "0";
	            }
	        }
	    }
   }
   
   /**
    * 전송 상태에 따라 색을 설정한다.
    * @param sheetObj
    * @param Row
    * @param ColName
    * @param SentRslt
    * @param Diff
    */
   function sentColorSet(sheetObj, Row, ColName, SentRslt, Diff){

	   if(Diff == "fax"){
	       if(SentRslt == "6"){  // 실패,빨간색
	           sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(255,0,0);
	       }else if(SentRslt == "5"){  // 성공,파란색
	           sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(0,0,255);
	       }else if(SentRslt == ""){  // 검은색
	           sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(0,0,0);
	       }else {  // 진행중,핑크색
	           sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(255,0,192);
	       }
	   } else if(Diff == "email") {
           if(SentRslt == "4"){  // 실패,빨간색
               sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(255,0,0);
           }else if(SentRslt == "3"){//성공,파란색
        	   sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(0,0,255);
           }else if(SentRslt == ""){  // 검은색
               sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(0,0,0);
           }else {  // 진행중,핑크색
               sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(255,0,192);
           }
	   }
	   
   }
   
   
   /**
    * BackEndJob 실행결과조회<br>
    * 
    * @param sheetObj
    * @param sKey
    */
   function doActionValidationResult(sheetObj, sKey) {
	   var formObj = document.form;
	   var sXml = sheetObj.GetSearchXml("ESM_BKG_0003GS.do?f_cmd=" + SEARCH02 + "&key=" + sKey);
	   var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	   
	   // 에러가 발생했을 경우 대기사항을 종료한다.
	   if (!ComBkgErrMessage(sheetObj, sXml)) {
		   clearInterval(intervalId);
		   ComOpenWait(false);
		   return;
	   }
	   if (sJbStsFlg == "SUCCESS") {
		   clearInterval(intervalId);
		   ComOpenWait(false);
		   // 성공메시지 보여주고
		   ComShowCodeMessage('BKG06022');	
		   doActionIBSheet(formObj,SEARCH); // 재조회		   
		   return;
	   } else if (sJbStsFlg == "FAIL") {
		   //에러
		   clearInterval(intervalId);
		   ComOpenWait(false);
		   // 에러메시지 보여주고
		   ComShowMessage(ComResultMessage(sXml));
	   }
   }
   
   /**
    * BackEndJob 실행결과조회<br>
    * 
    * @param sheetObj
    * @param sKey
    */
   function doActionBackEndResultForBST(sheetObj, sKey) {
	   
	   var sXml = sheetObj.GetSearchXml("ESM_BKG_0003GS.do?f_cmd=" + SEARCH02 + "&key=" + sKey);
	   var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	   var formObj = document.form;
	   
	   // 에러가 발생했을 경우 대기사항을 종료한다.
	   if (!ComBkgErrMessage(sheetObj, sXml)) {
		   clearInterval(intervalId);
		   ComOpenWait(false);
		   return;
	   }
	   if (sJbStsFlg == "SUCCESS") {
		   clearInterval(intervalId);
		   ComOpenWait(false);
		   // 성공메시지 보여주고
		   doActionIBSheet(formObj,SEARCH);
		   ComShowCodeMessage('BKG06022');	
		   
		   return;
	   } else if (sJbStsFlg == "FAIL") {
		   //에러
		   clearInterval(intervalId);
		   ComOpenWait(false);
		   // 에러메시지 보여주고
		   ComShowMessage(ComResultMessage(sXml));
	   }
   }
   
   // BKG_NO 입력 받는 메소드(POP UP 에서 호출한다.)
   function openAddPaste(param){
   	var formObj = document.form;
	formObj.searchPopupParam.value = param;
		
   	var _Width = '400';
	var _Height = '420';
	var _searchParam = "";
	if(param == "bkg_no"){
		_searchParam = "ESM_BKG_9457.do?bkg_no="+formObj.bkg_no.value;
	} else {
		_searchParam = "ESM_BKG_9457.do?cntr_no="+formObj.bkg_no.value;
	}
	
   	var newWin = ComOpenWindow(_searchParam, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
   }
   
   // Pop UP 에서 입력된 No 를 전달 받는다.
   function addValueNo(multi_value){
	   	var multis = multi_value.split('\n');
	    	multi_value = '';
	   	for(var i = 0 ; i < multis.length ; i++){
				if(i == 0){
					multi_value = multis[i];
				}else{
					multi_value = multi_value + ',' + multis[i];
				}
	  		}
	   	if(multi_value != ''){
	   		document.getElementById(document.form.searchPopupParam.value).value = multi_value;
	   	}
	}
	/* 개발자 작업  끝 */
     