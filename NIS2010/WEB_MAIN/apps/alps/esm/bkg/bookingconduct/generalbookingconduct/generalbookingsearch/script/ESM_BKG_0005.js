/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : esm_bkg_0005.js
*@FileTitle : Customer Advisory History
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.01
*@LastModifier : Lee In Young
*@LastVersion : 1.0
* 2011.07.01 Lee In Young
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
     * @class esm_bkg_0005 : esm_bkg_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0005() {
    	this.processButtonClick		= tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
var IBUPLOAD = "IBUPLOAD";
var IBDOWNLOAD = "IBDOWNLOAD";
    
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var beforetab = 1;
 
 var shCustNmFax;
 var cnCustNmFax;
 var nfCustNmFax;
 var shCustNmEml;
 var cnCustNmEml;
 var nfCustNmEml;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var shtCnt = 0;
 	         var sheet1 = sheetObjects[0];
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
		     	    	sheet1.SpeedDown2Excel(-1);
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
         
         doActionIBSheet(document.form, INIT);
         
         initControl();
         
         if (parAutoSearchFlg == "Y" ) {

        	 doActionIBSheet(document.form,SEARCH);
         }
         
         document.form.vvd.focus();
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
	        
	        // Parameter Setting
	        formObject.vvd.value = parVvd;
	        if(parEDirCd == "E"){
	        	formObject.e_dir_cd.checked = true;
	        }
	        if(parWDirCd == "W"){
	        	formObject.w_dir_cd.checked = true;
	        }
	        if(parSDirCd == "S"){
	        	formObject.s_dir_cd.checked = true;
	        }
	        if(parNDirCd == "N"){
	        	formObject.n_dir_cd.checked = true;
	        }
	        formObject.pol_cd.value = parPolCd;
	        formObject.pod_cd.value = parPodCd;
	        formObject.del_cd.value = parDelCd;
	        formObject.cust_cnt_cd.value = parCustCntCd;
	        formObject.cust_seq.value = parCustSeq;
    		if(formObject.cust_cnt_cd.value != ""){
    			doActionIBSheet(formObject, SEARCH01);
    			formObject.bkg_cust_tp_cd.disabled = false;
    		} else {
    			formObject.bkg_cust_tp_cd.disabled = true;
    		}
	        for(var i =	0 ; i< formObject.bkg_cust_tp_cd.options.length; i++){
	        	if(formObject.bkg_cust_tp_cd.options[i].value == parBkgCustTpCd){
	        		formObject.bkg_cust_tp_cd.options[i].selected = true;
	        	}
	        }
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

          if( colName == "snt_rmk"){
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
  		
  		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  		             InitColumnInfo(18, 0, 0, true);
  		
  		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
  		             InitHeadMode(true, true, true, true, false,false);
  		             var HeadTitle = "|Seq.|VVD|B/L No.|CNTR No.|POL|POD|DEL|Cust TP|Cust Name|Fax/Email Address|Sent Body Remark|Sent Result|Sent Date|Sent Office|Sent ID|||";
  		
  		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  		             InitHeadRow(0, HeadTitle, true);
  		             //데이터속성    [	ROW, COL,   DATATYPE,		WIDTH,  DATAALIGN, 	COLMERGE,   SAVENAME,   		KEYFIELD, 	CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  		             // Fax
 					 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
  		             InitDataProperty(0, cnt++ , dtSeq,       		30,    	daCenter,  	false,    	"seq",          	false,          "",       dfNone,   	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,     daCenter,  	false,    	"vvd",       		false,          "",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,   	daCenter,  	false,   	"bl_no",    		false,          "",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,  	false,   	"cntr_no",    		false,          "",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,  	false,    	"pol_cd",       	false,          "",       dfNone,    	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,  	false,    	"pod_cd",  		   	false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,  	false,    	"del_cd",   		false,          "",       dfNone, 		0,    		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,  	false,    	"cust_tp",			false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		200,   	daLeft,  	false,    	"cust_nm",  		false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,    	  	150,   	daCenter,  	false,   	"snt_fax_no_eml",	false,		    "",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		170,   	daLeft,  	false,    	"snt_rmk",		  	false,          "",       dfNone, 		0,    		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		80,    	daCenter,  	false,    	"snt_rslt_ctnt", 	false,          "",       dfNone, 		0,     		false,      true,-1,false,true,"",false);
  		             InitDataProperty(0, cnt++ , dtData,      		100,  	daCenter,  	false,    	"ntc_snd_rqst_dt",	false,          "",       dfNone, 		0,     		false,      true,-1,false,true,"",false);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,  	false,    	"snt_ofc_cd", 		false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtData,      		100,   	daCenter,  	false,    	"snt_usr_id", 		false,          "",       dfNone, 		0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	0,   	daCenter,  	false,   	"snt_rslt_cd",		false,     		"",       dfNone,     	0,     		false,      true);
  		             InitDataProperty(0, cnt++ , dtHidden,      	0,   	daCenter,  	false,   	"ntc_via_cd",		false,     		"",       dfNone,     	0,     		false,      true);

  		             FrozenCols = 6;
  	                 CountFormat           = "[SELECTDATAROW / TOTALROWS]";
  	                 ShowButtonImage = 2;
  	                 CountPosition = 2;
  	                 AutoRowHeight = false;
  	                 Ellipsis = true;
 
  		         }
  		         break;
  		         
           }
       }
       
    	/**
        * Sheet 관련 프로세스 처리
        * @param formObj
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
					formObj.f_cmd.value = SEARCH;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0005GS.do",sParam);
					sheetObjects[0].LoadSearchXml(sXml);
					break;
				
				case SEARCH01: //고객정보 조회
					formObj.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0005GS.do", sParam);
					var custNm = ComGetEtcData(sXml, "cust_nm");
					if(custNm == undefined){
						custNm = "";
					}
					formObj.cust_nm.value = custNm;
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
    	  		return true;
    	  		break;

    	  	case IBDOWNLOAD: // download
    	  		if(sheetObjects[0].LastRow == 0){
    	  			ComShowCodeMessage("BKG00109");
    	  			return false;
    	  		}
    	  		return true;
    	  		break;
    	  		
    	  }    	  
     }


	/**
    * 조회 완료 후 실행
    * 전송 상태에 따라 글자색을 변경한다.
    * @param sheetObj
    * @param ErrMsg
    */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {

	    var maxRow = sheetObj.LastRow;
	    var cellValue = "";
	    for(i=1;i <= maxRow ; i++){
			
			// 전송 상태에 따라 글자색을 변경한다.
            sentColorSet(sheetObj, i, "snt_fax_no_eml", sheetObj.CellValue( i,"snt_rslt_cd"));
            
	    }
	}

   /**
    * 전송 상태에 따라 색을 설정한다.
    * @param sheetObj
    * @param Row
    * @param ColName
    * @param SentRslt
    */
   function sentColorSet(sheetObj, Row, ColName, SentRslt){

       if(SentRslt == "F"){  // 실패,빨간색
           sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(255,0,0);
       }else if(SentRslt == "S"){  // 성공,파란색
           sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(0,0,255);
       }else if(SentRslt == "W"){  // 진행중,핑크색
    	   sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(255,0,192);
       }else {  // 겅은색
           sheetObj.CellFontColor(i,ColName) = sheetObj.RgbColor(0,0,0);
       }
   }
	/* 개발자 작업  끝 */
     