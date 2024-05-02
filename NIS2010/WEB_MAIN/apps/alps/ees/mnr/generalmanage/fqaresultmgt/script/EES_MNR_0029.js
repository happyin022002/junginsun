	/*=========================================================
	*Copyright(c) 2009 CyberLogitec
	*@FileName : EES_MNR_0029.js
	*@FileTitle : FQA Result Creation
	*Open Issues :
	*Change history :
	*@LastModifyDate : 2009.05.21
	*@LastModifier : 함형석
	*@LastVersion : 1.0
	* 2009.06.22 함형석
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
     * @class ees_mnr_0029 : ees_mnr_0029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0029() {
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
						case "btn_Save":
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
								break;
						case "btn_New":
							doActionIBSheet(sheetObject1,formObject,IBCLEAR);
								break;
						case "btn_Delete":
							doActionIBSheet(sheetObject1,formObject,IBDELETE);
								break;
						case "btn_vndr":
						    if(noClick!="Y"){
								ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1', true);
							}
							break;
						case "btn_yd":
							if(noClick!="Y"){
								ComOpenPopup('/hanjin/COM_ENS_061.do', 766, 460, 'getCOM_ENS_061', "1,0,1,1,1,1,1,1,1,1,1,1", true);
							}
							break;
						case "calendar":
							if(noClick!="Y"){
		                    	var cal = new ComCalendar();
		                    	cal.select(form.fld_aud_dt, 'yyyy-MM-dd');
							}
		                    break;
						case "btn_RowAdd": 
							sheet_DataInsert(sheetObject2,'');
								break;
						case "btn_RowDel":
							rowRemove(sheetObject2, "");
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
		MnrWaitControl(true);
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
		var formObj = document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);   
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

					var HeadTitle1 = "|Seq.|Sel|Evaluation Summary|Max Point|Point|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //dtAutoSumEx 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	    50,		daCenter,	true,		 prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,			    40,		daCenter,	true,		 prefix + "S",						false,	"",		dfNone);
					InitDataProperty(0, cnt++ , dtCheckBox,			50,		daCenter,	true,		 prefix + "del_chk",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				300,	daLeft,		true,		 prefix + "ev_desc",				false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtAutoSumEx,		80,		daRight,	true,		 prefix + "max_pnt_no",				false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtAutoSumEx,		80,		daRight,	true,		 prefix + "pnt_no",					true,	"",		dfNone,				0,			true,		true);					
					InitDataProperty(0, cnt++ , dtData,				80,		daLeft,		true,		 prefix + "fld_aud_rmk",			false,	"",		dfNone,				0,			true,		true, 4000);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daLeft,		true,	     prefix + "ofc_cd",	                false,	"",		dfNone,				0,		    false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,			80,		daLeft,		true,	     prefix + "file_seq",	            false,	"",		dfNone,				0,		    false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "vndr_seq",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "yd_cd",					false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "fld_aud_dt",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "fld_aud_dtl_seq",		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "pnt_calc_flg",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,		 prefix + "cre_usr_id",				false,	"",		dfNone,				0,			true,		true);
					  
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
                    var prefix="";
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
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	 	prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	 	prefix + "del_chk")
					InitDataProperty(0, cnt++ , dtPopup,      	180,    daCenter,  	false,   	prefix + "org_file_nm",     true,           "",      dfNone,    0,     	false,		true,	50);
					InitDataProperty(0, cnt++ , dtImage,      	60,   	daCenter,  	false,   	prefix + "file_dw",   		false,          "",      dfNone,    0,     	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   	prefix + "file_path_nm",   	false,          "",      dfNone,    0,     	true,      	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   	prefix + "file_path",   	false,          "",      dfNone,    0,     	true,      	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   	prefix + "file_seq",   		false,          "",      dfNone,    0,     	true,      	true);										
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  		prefix + "file_dtl_seq",	false,			"",		 dfNone,	0,		false,		false);
	 					
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
	    var formObj = document.form;
		obj = event.srcElement;       
		if(obj.name == "fld_aud_dt"){    
			formObj.aud_rslt_his.Code = formObj.fld_aud_dt.value; 
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
				   	break;  
	    		case "yd_cd":         
					yd_cd_confirm();
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
		var formObj = document.form;
		var prefix = "sheet1_";   
		var arrRow = sheetObj.RowCount;
        var max=0;
        var pnt=0;
        for (idx=1; idx<(arrRow + 1); idx++){ 
 
            var row = idx;
            if(sheetObj.CellValue(row, prefix+ "del_chk")!="" || sheetObj.CellValue(row, prefix+ "del_chk") == null){
               max +=  eval(sheetObj.CellValue(row, prefix+ "max_pnt_no")); 
               pnt +=  eval(sheetObj.CellValue(row, prefix+ "pnt_no")); 
            }
        } 
        var total = eval(pnt*(100/max)).toFixed(2);
        
        if(Number(total) != 'NaN')  formObj.total.value = total;
        if(formObj.total.value=='NaN') formObj.total.value = '0';
 
	}

	/* ********* Event Functions ************* */ 
	/**  
	 * sheet1 SaveEnd 이벤트      
	 * @param {IBSheet}  sheetObj 콤보오브젝트  
	 * @param  {String}    ErrMsg   에러메시지 
	 */  
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if(retrieveClick=='2'){
			if (ErrMsg == "") { 
				ComShowCodeMessage("MNR00020",'');   
			} else { 
				ComShowCodeMessage("MNR00008",ErrMsg);  
			} 
		}else{
			if (ErrMsg == "") { 
				ComShowCodeMessage("MNR00023",'');   
			} else if(ErrMsg.indexOf("MNR00185")<=0){
				ComShowCodeMessage("MNR00008",ErrMsg);  
			}
		}
		
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
		if(sheetObj.CellValue(Row,"sheet1_del_chk")=="1"){
			// 수정가능
		   	sheetObj.CellEditable(Row, 5) = true;  
		   	sheetObj.CellEditable(Row, 6) = true;   
		}else{
			// 수정불가   
		   	sheetObj.CellEditable(Row, 5) = false;  
		   	sheetObj.CellEditable(Row, 6) = false; 
		   	sheetObj.CellValue2(Row, "sheet1_pnt_no") = "";
		   	sheetObj.CellValue2(Row, "sheet1_fld_aud_rmk") = "";   
		   	sheetObj.RowStatus(Row) = "R";       
		}

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
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet2_OnPopupClick(sheetObj,Row,Col){

	    var upObj = uploadObjects[0];     
		var prefix = "";
	 	var fileName = sheetObj.OpenFileDialog("파일선택");
	 	if(fileName.indexOf("\\") !=-1) {
	 		sheetObj.CellValue2(Row, prefix+ "org_file_nm")= fileName;     			
	 		upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
	    	var ret = upObj.AddFile(fileName);     			     			
	    	fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
	 		sheetObj.CellValue2(Row, Col)= fileName;		 		
			sheetObj.CellValue2(Row, prefix+ "file_dw")= '1';
	 		var file_seq = sheetObj.CellValue(Row, prefix+ "file_seq");
			var file_dtl_seq = sheetObj.CellValue(Row, prefix+ "file_dtl_seq");
			if(file_dtl_seq=="") file_dtl_seq=Row;
			var ibflag='U';
			if(file_seq=="" || uploadFileSeq!="") ibflag='I'; // 최초 저장시 및 저장된 파일 없을때 ibflag을 I로 Setting			
			if(file_seq!="" && uploadFileSeq!="") ibflag='U';

			if(uploadFileSeq != "") {
				file_seq = uploadFileSeq;
			}	     		
			
	 		var sParam = "f_cmd="+COMMAND01;
	 		sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code				
	 		sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
	 		sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경   		
			upObj.ExtendParam = sParam;

			var sXml = upObj.DoUpload(true);	
				
			uploadFileSeq = ComGetEtcData(sXml,"seqValue");
			if(uploadFileSeq != "" && uploadFileSeq != undefined){ 
				var fileXml = SearchFileUpload(sheetObjects[1],uploadFileSeq);
				sheetObjects[1].LoadSearchXml(fileXml);   				
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
		var prefix = "";
      
        if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
		
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;

		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}
	
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function aud_rslt_his_OnChange(comboObj,Index_Code, Text){
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

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
          case IBSEARCH:      //조회
        	  if(validateForm(sheetObj,formObj,sAction)){
	               formObj.f_cmd.value = SEARCH;

				    retrieveClick = 1;
	    		    var aryPrefix = new Array("sheet1_", "");
	    		    var sXml = sheetObj.GetSearchXml("EES_MNR_0029GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
	    		
					var arrXml = sXml.split("|$$|"); 
					sheetObjects[0].Redraw = false;
					
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
					sheetObjects[0].Redraw = true;
					//조회후 저장여부 확인
					formObj.key_value.value = ComGetNowInfo();
        	  }    
              break;
          case IBSAVE:        //저장
        	  if(validateForm(sheetObj,formObj,sAction)){
		            formObj.f_cmd.value = MULTI;  
		
	                //2.IBSheet 데이터 QueryString으로 묶기
					var sParam = ComGetSaveString(sheetObjects);
					if (sParam == "") return;
	
	                //3.Form 데이터 QueryString으로 묶기
					var aryPrefix = new Array("sheet1_", "");
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);

					//4. 서버에 request전달하고, reponse 받기
					var sXml = sheetObj.GetSaveXml("EES_MNR_0029GS.do", sParam); 
	                var arrXml = sXml.split("|$$|");

		    		if (arrXml.length > 0) sheetObjects[0].LoadSaveXml(arrXml[0]);
					if (arrXml.length > 1) sheetObjects[1].LoadSaveXml(arrXml[1]);	
					
 					audit_result_history_search();
					
					noClick = "";
					fieldEnableYN();
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
				 sheetObjects[0].Redraw = false;
				 sheetObjects[0].LoadSearchXml(arrXml[0]);
				 //end
				   
				 for(var i = 1 ; i <= sheetObjects[0].RowCount ; i ++){
					 sheetObjects[0].CellEditable(i,1) = false;              
					 sheetObjects[0].CellEditable(i,3) = false;            
					 sheetObjects[0].CellEditable(i,4) = false;            
					 sheetObjects[0].CellEditable(i,5) = false;            
					 sheetObjects[0].CellEditable(i,6) = false;                    
				 } 
				 
				 form.fld_aud_dt.value = ComGetNowInfo();
				 sheetObjects[0].Redraw = true;
				 noClick = "";
				 uploadFileSeq = "";
				 formObj.key_value.value = "";
				 fieldEnableYN();
				MnrWaitControl(false);
               break;
          case IBDELETE:      // 삭제
        	  if(validateForm(sheetObj,formObj,sAction)){
	        	    formObj.f_cmd.value = REMOVE;
	        	    retrieveClick = 2;
	        	    var sParam = ComGetSaveString(sheetObjects);
				    // if (sParam == "") return;
			    	var prefix = 'sheet1_';

			    	var aryPrefix = new Array("sheet1_", "");
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					//4. 서버에 request전달하고, reponse 받기
					var sXml = sheetObj.GetSaveXml("EES_MNR_0029GS.do", sParam);
						
					sheetObjects[0].LoadSaveXml(sXml);
					sheetObjects[1].LoadSaveXml(sXml);								 
        	   }
        	  
        	//clear 
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
			 fieldEnableYN();
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
	 	    case IBSAVE: // 저장
				if(retrieveClick=='0' && (formObj.vndr_seq.value == "" || formObj.vndr_seq.value == null)) {
					ComAlertFocus(formObj.vndr_seq, ComGetMsg('MNR00003'));
					return;
				} else if(retrieveClick=='0' && formObj.fld_aud_dt.value == "") {
					ComAlertFocus(formObj.fld_aud_dt, ComGetMsg('MNR00003'));
					return;
				}else if(formObj.yd_cd.value == "") {
					ComAlertFocus(formObj.yd_cd, ComGetMsg('MNR00003'));
					return;
				}else if(!sheetObjects[0].FindStatusRow("I|U") && sheetObjects[1].FindStatusRow("I|U")){
					ComShowMessage(ComGetMsg('MNR00167'));
					return;
				}else if(formObj.yd_cd.value != null || formObj.yd_cd.value != ""){
					 var aaa = formObj.yd_cd.value;  
					 var bbb = formObj.vndr_seq.value;
					 
				    for (var idx = 1; idx <= sheetObj.RowCount; idx++){   
				        if(sheetObj.CellValue(idx,"sheet1_del_chk") == '1'){  
				        	sheetObj.CellValue2(idx,"sheet1_yd_cd") = aaa;       
				        	sheetObj.CellValue2(idx,"sheet1_vndr_seq") = bbb;            
							sheetObj.CellValue2(idx,"sheet1_fld_aud_dt")= form.fld_aud_dt.value;
							sheetObj.CellValue2(idx,"sheet1_ofc_cd")= formObj.ofc_cd.value;
							sheetObj.CellValue2(idx,"sheet1_pnt_calc_flg")='Y';   
				        }                 
				    }	
				}
				
				for (idx = 1; idx <= sheetObj.RowCount; idx++){  
					 if(sheetObj.CellValue(idx,"sheet1_del_chk") == '1'){   
						var max = sheetObj.CellValue(idx, "sheet1_max_pnt_no"); 
						var pnt = sheetObj.CellValue(idx, "sheet1_pnt_no");
						    
						if(pnt == null || pnt == ""){
							ComShowMessage(ComGetMsg('MNR00167'));
							sheetObj.SelectCell(idx, "sheet1_pnt_no", true);
							return;         
						} else if(eval(max) < eval(pnt)){
							ComShowCodeMessage("MNR00166");
							sheetObj.CellValue2(idx,"sheet1_pnt_no") = "";
							sheetObj.SelectCell(idx, "sheet1_pnt_no", true);
							return;   
						}  
						
						if(uploadFileSeq!=""){
							sheetObj.CellValue(idx, "sheet1_file_seq")=uploadFileSeq;
						}
					}    

				}	  
			    break;  
	 	    case IBDELETE: // 삭제
	 	    	
	 	    	if(!ComShowCodeConfirm("MNR00026")){return false;} //저장의사 확인
				if(retrieveClick=='0' && formObj.vndr_seq.value == "") {
					ComAlertFocus(formObj.vndr_seq, ComGetMsg('MNR00027'));
					return;
				}else if(retrieveClick=='0' && formObj.fld_aud_dt.value == "") {
					ComAlertFocus(formObj.fld_aud_dt, ComGetMsg('MNR00027'));
					return;
				}else if(retrieveClick=='0' && formObj.yd_cd.value == "") {
					ComAlertFocus(formObj.yd_cd, ComGetMsg('MNR00027'));
					return;
				}else if(sheetObj.CellValue(1,prefix + "cre_usr_id")!= formObj.usr.value){
					ComShowMessage(ComGetMsg('MNR00168'));
					return;
    	        }else{
					var sRow = sheetObj.FindStatusRow("R");
					var prefix = "sheet1_";   
			        var arrRow = sRow.split(";");
			        for (idx=0; idx<(arrRow.length - 1); idx++){ 
			            var row = arrRow[idx];
						sheetObj.RowStatus(row)= "D";
			        }	
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
			//서비스 프로바이더 조회 
			var sCondition = new Array ( 
				new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
			)                            
			//조회 값이 있다면 세팅
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
			if(comboList[0] != null){
				var tempText = comboList[0][0].split("|"); 
				formObj.vndr_lgl_eng_nm.value  = tempText[1];  
	
				audit_result_history_search();    
			} else {       
				ComShowCodeMessage("MNR00005", "Service Provider");              
				ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); 
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
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
	
	function rowRemove(sheetObj, prefix) {
		if(sheetObj.FindCheckedRow(prefix + "del_chk") != ""){
			RemoveFileUpload(sheetObj);
		} else {     
			ComShowCodeMessage("MNR00150");   	   
		}
	}
	/**
	 * COM_ENS_061 의 값을 받은 함수      
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
   	 var formObj = document.form; 
		        
	   if(aryPopupData[0][3] != null && aryPopupData[0][3] != ""){
		   formObj.yd_cd.value = aryPopupData[0][3];
	   }         
   }
    /**
     * getCOM_ENS_0C1 의 값을 받은 함수   
	 * @param	{String[][]}	aryPopupData	팝업화면에서 리턴받은 배열값
     */   
    function getCOM_ENS_0C1(aryPopupData, row, col, sheetIdx){
   	 
	   	var formObj = document.form;
	   	var vndrSeq = "";
	   	var vndrNm = "";
	   	var i = 0;
	   	 
	   	for(i = 0; i < aryPopupData.length; i++){
		   	vndrSeq = vndrSeq + aryPopupData[i][2];
		   	 
		   	if(aryPopupData.length == 1){
		    	vndrNm = vndrNm + aryPopupData[i][4];
		   	}
		   		 
		   	if(i < aryPopupData.length - 1){
		   		vndrSeq = vndrSeq + ",";
		   	}
	   	}
	   	 
	   	formObj.vndr_seq.value = vndrSeq;
	   	formObj.vndr_lgl_eng_nm.value = vndrNm;
	   	 
		audit_result_history_search();

    }

	/**
	 * audit_result_history 조회 <br>
	 **/
	function audit_result_history_search() {  
	
		var formObj = document.form;
      	//콤보데이타 초기화
	    for(var i = 0; i < comboObjects.length;i++){ 
	 		 comboObjects[i].RemoveAll();	
	   	}    
	   	//콤보데이타 조회 
		var sCondition = new Array (   
			new Array("MnrFldQltyAudRslt",ComLpad(formObj.vndr_seq.value, 6, "0")+formObj.ofc_cd.value,"COMMON")
		)                   
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
 		if(comboList[0] != null){
 			for(var j = 0; j < comboList[0].length;j++){ 
 				formObj.aud_rslt_his.InsertItem(j, comboList[0][j] ,comboList[0][j] );
 			}  
 		} 
 		formObj.aud_rslt_his.Code2 = "";    

	}		

    /**
     * IBSheet의 각 탭에 대한 Row를 추가한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @param {String} 	flag   		Row Add/Row Ins의 구분값
     * @return {없음}
     **/
	function sheet_DataInsert(sheetObj,prefix){
		
		var prefix = "";

		uploadFileSeq = sheetObj.CellValue(1,prefix + "file_seq");
		if(uploadFileSeq==undefined){
			uploadFileSeq="";
		}

		var row = sheetObj.SelectRow;
		var col = sheetObj.SelectCol;
		
		for(i=1;i<=sheetObj.RowCount;i++){
			if (sheetObj.CellValue(i,prefix + "org_file_nm")==""){
				ComShowMessage(ComGetMsg('MNR00024'));
				sheetObj.SelectCell(i,prefix + "org_file_nm");
				return;
			}
		}

		var row =sheetObj.DataInsert(-1);
	}	