/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0223.js
*@FileTitle : FQA Result Detail Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.09 함형석
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
     * @class ees_mnr_0223 : ees_mnr_0223 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0223() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
    
var comboObjects = new Array();
var comboCnt = 0;    

var comboValue = "";   

var uploadObjects = new Array();
var uploadCnt = 0;

//파일Seq저장변수 (추가될때 )
var uploadFileSeq = "";  

//audit Result History콤보 변경조회후 S/Provider,Yard,audit Date 변경안되게
var noClick = "";

//조회 클릭시 상태를 저장
var retrieveClick = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

						case "btn_Retrieve":
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
								break;
						case "btn_New":
							doActionIBSheet(sheetObject1,formObject,IBCLEAR);
								break;
						case "btn_Close":
							self.close();
		                    break;
							
							
                    } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	initControl(); 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }	

		vndr_seq_confirm();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);   		
		
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do");  		
    }

	function initUpload(uploadObj, uploadNo) {
	   uploadObj.Files = "";
	}

    /**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {        
	    var formObject = document.form
	    switch(comboNo) {    
	          case 1: 
	           with (comboObj) { 
	      	   	 
        	   SetColAlign("left|left");        
		       SetColWidth("80|100");      
			   DropHeight = 160;  
		    }      
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
		var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
                	var prefix="sheet1_";
                    // 높이 설정
                    style.height = 382;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Seq.|Evaluation Summary|Max Point|Point|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //dtAutoSumEx 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	    50,		daCenter,	true,		 prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,			    40,		daCenter,	true,		 prefix + "S",					false,	"",		dfNone);
					InitDataProperty(0, cnt++ , dtData,				300,	daLeft,		true,		 prefix + "ev_desc",			false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtAutoSumEx,		80,		daRight,	true,		 prefix + "max_pnt_no",			false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtAutoSumEx,		80,		daRight,	true,		 prefix + "pnt_no",				true,	"",		dfNone,				0,			true,		true);					
					InitDataProperty(0, cnt++ , dtData,				80,		daLeft,		true,		 prefix + "fld_aud_rmk",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daLeft,		true,	     prefix + "ofc_cd",	            false,	"",		dfNone,				0,		    false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,			80,		daLeft,		true,	     prefix + "file_seq",	        false,	"",		dfNone,				0,		    false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "vndr_seq",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "yd_cd",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "fld_aud_dt",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "fld_aud_dtl_seq",	false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "pnt_calc_flg",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "cre_usr_id",			false,	"",		dfNone,				0,			true,		true);
					  
					InitDataValid(0,    prefix + "max_pnt_no",   vtNumericOnly);
					InitDataValid(0,    prefix + "pnt_no", vtNumericOther, "."); 
					MultiSelection = false;   
					SelectionMode = smSelectionRow;     
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
					CountPosition = 0;  
                }
         		  break;
		         		
            
            case "sheet2":
                with (sheetObj) {
                    var prefix="sheet2_";
                    // 높이 설정
                    style.height = 82;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Seq.|Attach FQA Detail|Download Attachment";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	 prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	 prefix + "del_chk")
					InitDataProperty(0, cnt++ , dtPopup,      	180,    daCenter,  	false,   prefix + "org_file_nm",    true,       "",      dfNone,      0,     false,		true,	50);
					InitDataProperty(0, cnt++ , dtImage,      	60,   	daCenter,  	false,   prefix + "file_dw",   		false,      "",      dfNone,      0,     false,		true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   prefix + "file_path_nm",   false,      "",      dfNone,      0,     true,      true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   prefix + "file_path",   	false,      "",      dfNone,      0,     true,      true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   prefix + "file_seq",   	false,      "",      dfNone,      0,     true,      true);										
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  	 prefix + "file_dtl_seq",	false,		"",		 dfNone,	  0,	 false,		false);
	 					
					CountPosition = 0;
					
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
					ShowButtonImage = 1;
					}
		         	break;	         	

             }
     }

	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	form); //- 변경될때.
	}           

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

	 //페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록
	function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++] = uploadObj;
	}

    /** 
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){    
    	comboObjects[comboCnt++] = combo_obj;  
	}      
		   
	/**
	 * HTML Control의 deactivate 이벤트 <br>
	 **/
	function obj_deactivate(){    
		obj = event.srcElement;       
		if(obj.name == "fld_aud_dt"){    
		    var formObject = document.form;
			formObject.combo1.Code = document.form.fld_aud_dt.value; 
		}  
	    ComChkObjValid(event.srcElement); 
	} 

	/**
	 * HTML Control의 activate 이벤트 <br>
	 **/
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        

	function obj_change(){    
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
	    		case "vndr_seq":   
	        		vndr_seq_confirm();  
					//doActionIBSheet(sheetObj,formObj,IBSEARCH);
				   	break;  
	    		case "yd_cd":         
					yd_cd_confirm();
					//doActionIBSheet(sheetObj,formObj,IBSEARCH);
				   	break;   
			}       
	    } 
	}    
	
	/**
	 * HTML Control의 keypress 이벤트 <br>
	 **/     
	function obj_keypress(){     
	    obj = event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
			              
	    switch(obj.dataformat) {  
	        case "ymd":   
	        case "int":    
				ComKeyOnlyNumber(obj); 
	            break;     
	        case "float":   
	            ComKeyOnlyNumber(obj, "-.");
	            break; 
	        case "eng":   
	            ComKeyOnlyAlphabet();
				break;   
	        case "engup": 
	            if(obj.name=="vndr_seq"){ 
					ComKeyOnlyNumber(obj);     
				}else{
					ComKeyOnlyAlphabet('uppernum');	
				}  			
	            break;	  
	    }
	} 
	
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function combo1_OnChange(comboObj,Index_Code, Text){
		var sheetObject1 = sheetObjects[0];
		var comboValue = Index_Code.split('|');
		var formObj = document.form;
		if(typeof comboValue != "undefined" && comboValue != "") {
      	   formObj.yd_cd.value = comboValue[0];
      	   formObj.fld_aud_dt.value = comboValue[1];
        }
		noClick = "Y";
		fieldEnableYN();
		
		//Retrive 기능
		doActionIBSheet(sheetObject1,formObj,IBSEARCH);
	}  

 	/**  
	 * sheet1 ChangeSum 이벤트      
	 * @param {IBSheet}  sheetObj   
	 * @param {String}  Row
	 */    
	function sheet1_OnChangeSum(sheetObj, Row)
	{
		var prefix = "sheet1_";   
		with(sheetObj)
		{  
			SumText(0, prefix+ "max_pnt_no") = sheet1_ChangeMax(sheetObj);
			sheet1_ChangeSum2(sheetObj);
		}
	}

	/**  
	 * sheet1 ChangeMax 이벤트      
	 * @param {IBSheet}  sheetObj   
	 */  
	function sheet1_ChangeMax(sheetObj)
	{
		var prefix = "sheet1_";   
		var arrRow = sheetObj.RowCount;
        var max=0;

        for (idx=1; idx<(arrRow + 1); idx++){ 

            var row = idx;
            if(sheetObj.CellValue(row, prefix+ "del_chk")!="" || sheetObj.CellValue(row, prefix+ "del_chk") == null){
			   max +=  eval(sheetObj.CellValue(row, prefix+ "max_pnt_no")); 
            }
        } 
        return max;
	}

	/**  
	 * sheet1 ChangeSum2 이벤트      
	 * @param {IBSheet}  sheetObj   
	 */  
	function sheet1_ChangeSum2(sheetObj)
	{
		var prefix = "sheet1_";   
		var arrRow = sheetObj.RowCount;
        var max=0;
        var pnt=0;
        for (idx=1; idx<(arrRow + 1); idx++){ 
 
            var row = idx;
            if(sheetObj.CellValue(row, prefix+ "del_chk")!="" || sheetObj.CellValue(row, prefix+ "del_chk") == null){
               max +=  eval(sheetObj.CellValue(row, prefix+ "max_pnt_no")); 
			   if(sheetObj.CellValue(row, prefix+ "pnt_no")!=""){
			   		pnt +=  eval(sheetObj.CellValue(row, prefix+ "pnt_no")); 
			   }
            }
        } 
        var total = eval(pnt*(100/max)).toFixed(2);

        var formObj = document.form;
        if(Number(total) != 'NaN')  formObj.total.value = total;
        if(formObj.total.value=='NaN') formObj.total.value = '0';
 
	}

   /**
    * sheet1에서 발생하는 OnChange이벤트를 처리한다.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(Col == 2){
			sheet1_OnChangeSum(sheetObj, Row);
		}	
		if(Col == 5){
			var max = sheetObj.CellValue(Row, "sheet1_max_pnt_no"); 
			var pnt = sheetObj.CellValue(Row, "sheet1_pnt_no");
			    
			if(pnt == null || pnt == ""){
				ComShowMessage(ComGetMsg('MNR00167'));
				sheetObj.SelectCell(Row, "sheet1_pnt_no", true);
				return;             
			} else if(eval(max) < eval(pnt)){
				ComShowCodeMessage("MNR00166");
				sheetObj.CellValue2(Row,"sheet1_pnt_no") = "";
				sheetObj.SelectCell(Row, "sheet1_pnt_no", true);
				return;
			}  
		}
	}

	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix = "sheet2_";
      
        if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
		
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;

		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}
	
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
          case IBSEARCH:      //조회
        	  if(validateForm(sheetObj,formObj,sAction)){
	               formObj.f_cmd.value = SEARCH;

				    retrieveClick = 1;
	    		    var aryPrefix = new Array("sheet1_", "sheet2_");
	    		    var sXml = sheetObj.GetSearchXml("EES_MNR_0223GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
	    		
					var arrXml = sXml.split("|$$|"); 
					if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
					if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);				
				    
					for(var i = 1 ; i <= sheetObjects[0].RowCount ; i ++){
						 sheetObjects[0].CellEditable(i,1) = false;              
						 sheetObjects[0].CellEditable(i,3) = false;            
						 sheetObjects[0].CellEditable(i,4) = false;            
						 sheetObjects[0].CellEditable(i,5) = false;            
						 sheetObjects[0].CellEditable(i,6) = false; 
						 if(sheetObjects[0].CellValue(i, 5) != "" ){
							 sheetObjects[0].CellValue2(i, 2) = '1';
							 sheetObjects[0].CellEditable(i,5) = true;  
							 sheetObjects[0].CellEditable(i,6) = true; 
						 }
					 } 
				    //sheet1_ChangeSum(sheetObj);
					sheet1_OnChangeSum(sheetObj, 0);
					
					//조회후 저장여부 확인
					formObj.key_value.value = ComGetNowInfo();
        	  }    
              break;

          case IBCLEAR:      // new 
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
        	    formObj.reset();
        	   
        	    form.fld_aud_dt.value = ComGetNowInfo();
        	    //조회버튼 클릭 초기화 	
				retrieveClick = 0;
				//쉬트 초기화
				 for(i=0;i<sheetObjects.length;i++){ 
			            sheetObjects[i].RemoveAll();    
			     }  
				 //콤보데이타 초기화
				 for(var i = 0; i < comboObjects.length;i++){ 
			 		 comboObjects[i].RemoveAll();	
			     }    
				//====================================================================
				//공통코드 호출 시작
				//====================================================================
				 var arrXml = MnrComSearchGrid(sheetObjects[0],"com_code_search_ind");				 
				 sheetObjects[0].LoadSearchXml(arrXml[0]);
				 //end
				   
				 for(var i = 1 ; i <= sheetObjects[0].RowCount ; i ++){
					 sheetObjects[0].CellEditable(i,1) = false;              
					 sheetObjects[0].CellEditable(i,3) = false;            
					 sheetObjects[0].CellEditable(i,4) = false;            
					 sheetObjects[0].CellEditable(i,5) = false;            
					 sheetObjects[0].CellEditable(i,6) = false;                    
				 } 
				 noClick = "";
				 uploadFileSeq = "";
				 fieldEnableYN();
				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);
               break;

         }
         sheetObj.ShowDebugMsg = false;
     }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의)      */
    function validateForm(sheetObj,formObj,sAction){
    	var prefix = "sheet1_";
    	switch (sAction) {
	 	    case IBSEARCH: // 조회
				if(formObj.vndr_seq.value == "" || formObj.vndr_seq.value == null) {
					ComAlertFocus(formObj.vndr_seq, ComGetMsg('MNR00003'));
					return;
				} else if(formObj.fld_aud_dt.value == "") {
					ComAlertFocus(formObj.fld_aud_dt, ComGetMsg('MNR00003'));
					return;
    	        }
				break;  
   	    }
   	    return true;    
    }
 
 	//audit Result History콤보 변경조회만  S/Provider,Yard,audit Date 변경안되게 처리
	function fieldEnableYN(){
		var formObj = document.form;
		if(noClick=="Y"){
			MnrFormSetReadOnly(formObj,true,"vndr_seq|fld_aud_dt|yd_cd");   
		}else{
			MnrFormSetReadOnly(formObj,false,"vndr_seq|fld_aud_dt|yd_cd");   
		}
	}

	/**  
	 * vndr_seq 존재여부 체크     
	 */  
	function vndr_seq_confirm(){
		var formObj = document.form;
		if(formObj.vndr_seq.value != "" && noClick!="Y" && Number(formObj.vndr_seq.value)){ 
			
			var sCondition = new Array ( 
			 	new Array("MdmVendor",formObj.vndr_seq.value,"COMMON"), //서비스 프로바이더 조회 
				new Array("MnrFldQltyAudRslt",ComLpad(formObj.vndr_seq.value, 6, "0")+formObj.ofc_cd.value,"COMMON") //audit_result_history 조회
			)                            
			//조회 값이 있다면 세팅
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
			//콤보 설정
			for(var i = 0; i < comboList.length;i++){
				if(comboList[i] != null){
					//쉬트콤보별 초기화
					sheetComboText = "";
					sheetComboCode = "";
					for(var j = 0; j < comboList[i].length;j++){ 
					
						var tempText = comboList[i][j].split("|");
						//서비스 프로바이더 조회 
						if(i==0) {
							formObj.vndr_lgl_eng_nm.value  = tempText[1]; 		
						//audit_result_history 조회						
						}else if(i==1){
							comboObjects[0].InsertItem(j, comboList[i][j] ,comboList[i][j] );
						}
				
					}
					comboObjects[0].Code2 = ""; 
				}else{
					if(i==0) {
						ComShowCodeMessage("MNR00005", "Service Provider");              
						ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); 
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}
				}
			}
		} else {
			ComShowCodeMessage("MNR00005", "Service Provider");              
			ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); 
			ComSetObjValue(formObj.vndr_seq, "");
			ComSetFocus(formObj.vndr_seq);
		}
	}

	/**  
	 * yd_cd 존재여부 체크     
	 */  
	function yd_cd_confirm(){
		var formObj = document.form;
		if(formObj.yd_cd.value != "" && noClick!="Y"){ 
			var retArray = MnrGeneralCodeCheck(sheetObjects[0],"YARD",formObj.yd_cd.value);      
			if(retArray == null){    
				ComShowCodeMessage("MNR00165",formObj.yd_cd.value); 
				formObj.yd_cd.value = "";
				formObj.yd_cd.focus();
			}else{
				return;
			}
		}  
	}

 
	/**
	 * audit_result_history 조회 <br>
	 **/
	function audit_result_history_search() {  

		var formObj = document.form;

	   	//콤보데이타 조회 
		var sCondition = new Array (   
			new Array("MnrFldQltyAudRslt",ComLpad(formObj.vndr_seq.value, 6, "0")+formObj.ofc_cd.value,"COMMON")
		)                   
		var comboList = MnrComSearchCombo(sheetObj,sCondition);

      	//콤보데이타 초기화
	    for(var i = 0; i < comboObjects.length;i++){ 
	 		 comboObjects[i].RemoveAll();	
	   	}    
		
		for(var i = 0; i < comboList.length;i++){ 
	 		if(comboList[i] != null){
				
	 			for(var j = 0; j < comboList[i].length;j++){ 
	 				comboObjects[i].InsertItem(j, comboList[i][j] ,comboList[i][j] );
	 			}  
	 		} 
	 		comboObjects[i].Code2 = "";    
	 	}   
	}	
	   