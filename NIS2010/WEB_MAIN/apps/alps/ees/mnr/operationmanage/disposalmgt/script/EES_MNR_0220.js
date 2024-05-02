	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0220.js	 	
	 *@FileTitle : Disposal Price File Import_Pop Up
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.23	
	 *@LastModifier : 권영법 	
	 *@LastVersion : 1.0 
	 * 2009.09.23 권영법     
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
	 * @class EES_MNR_0220 : EES_MNR_0220 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0220() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	} 
	
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//TS타입일 경우 타입사이즈 배열  eq_type 별 3가지 모두 틀림 
	var uTpSz = new Array();    
	var gTpSz = new Array();  
	var zTpSz = new Array();   
	var selTpSz = new Array(); 
	
	//검증작업을 한데이타만 부모화면으로 이동가능
	var verifyCheck = false;     
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_FileImport": 		
				var preCnt = sheetObject.RowCount;	
				for(var i = 1; i <= sheetObject.RowCount; i++){
					sheetObject.CellValue(i,"del_check") = "1";
				}					
				sheetObject.LoadExcel(-1, 1, "", -1, -1, "", true,false,"");
								
				for(var i = 1; i <= sheetObject.RowCount; i++){ 		
					if(sheetObject.CellValue(i,"del_check") == "1"){
						sheetObject.CellValue(i,"orgIbflag") = "D";	
					} else {							
						sheetObject.RowStatus(i) = "I";  	
						sheetObject.CellValue(i,"orgIbflag") = "I";		 						  
					}				
					sheetObject.CellEditable(i,"checkbox") = false;	       
				}				
					   	
				if(preCnt > 0){		
					ComRowHideDelete(sheetObject, "del_check");
				}				
				break; 					    	
				
			case "btn_new":
				doActionIBSheet(sheetObjects[0],formObject,IBCLEAR)
				break;
	
			case "btn_ok":
				if(sheetObject.FindCheckedRow("checkbox") == ""){ 
					ComShowCodeMessage("MNR00038","SELECT ");             	   
				} else if(!verifyCheck){  
					ComShowCodeMessage("MNR00157");          		 	  
				} else {     
					comPopupOK_220(sheetObject,formObject); 	
				}                                   
				break; 
	
			case "btn_Save":    
				doActionIBSheet(sheetObject, formObject, IBSAVE); 
				break;        
	
			case "btn_RowAdd":                  
				doActionIBSheet(sheetObject, formObject, IBINSERT);        
				break; 
	
			case "btn_RowDel":                     
				doActionIBSheet(sheetObject, formObject, IBDELETE);        
				break;        
			case "btn_downExcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				break;			
			case "btn_close":    
				self.close();  
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
	

	 function setPopUpParam_COM_ENS_051(array) {

	 	if(array == null)return;
	 	var formObj = document.form;
	 	var str = array + "";
	 	var arr = str.split(",");

	 	sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"inp_msg2")=arr[3];
	 	
	 		

	 }   
	 
	 function setPopUpParam_COM_ENS_071(array) {

	 	if(array == null)return;
	 	var formObj = document.form;
	 	var str = array + "";
	 	var arr = str.split(",");

	 	sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"inp_msg2")=arr[3];
		 	
		 		

	}   	
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	
		var Text=""
	
			
			if(window.dialogArguments!=undefined)
			{
				if(window.dialogArguments.document.form.combo_eq_knd_cd!=undefined)
				{
					Text=window.dialogArguments.document.form.combo_eq_knd_cd.Code;
					selTpSz=window.dialogArguments.selTpSz;
				}
	
			}else{
				initTpszSize();
				if(Text == "U"){
					selTpSz = uTpSz;  	
				} else if(Text == "G"){
					selTpSz = gTpSz; 
				} else {
					selTpSz = zTpSz;   
				}  	
			}
	
	
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i + 1);	
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]); 
		}
		
		var sheetObj=sheetObjects[0]
  		//콤보조회
  		var sCondition = new Array (
  				new Array("MnrGenCd","CD00048", "COMMON") //Disposal Tariff Group Code Sheet Combo 			
  				,new Array("MdmCurrency",""   ,"COMMON")  //Currecy Code Sheet Combo
  		);
  		var comboList = MnrComSearchCombo(sheetObj,sCondition);
  		//쉬트 설정
  		var sheetComboText = "";
  		var sheetComboCode = "";
  		var sheetComboCodeText = "";
  		var sheetComboDefault = "";
  		for(var i = 0; i < comboList.length;i++){
  			//쉬트콤보별 초기화
  			sheetComboText = "";
  			sheetComboCode = "";
  			sheetComboCodeText = "";
  			sheetComboDefault = ""; 
  			if(comboList[i] != null){
  				for(var j = 0; j < comboList[i].length;j++){ 
  					var tempText = comboList[i][j].split("|");   
  					sheetComboText +=  tempText[1] + "|";
  					sheetComboCode +=  tempText[0] + "|";
  					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
  					if(j ==0){	
  						sheetComboDefault = tempText[0];  
  					}
  				}

  				//쉬트 콤보 설정
  				if(i == 0) {
  					sheetObjects[0].InitDataCombo(0, "inp_msg1", sheetComboText, sheetComboCode, sheetComboDefault);
  				}else if(i==1){
  					sheetObjects[0].InitDataCombo(0, "inp_msg3", sheetComboCode, sheetComboCode, sheetComboDefault);
  				}
  			}
  		}
  		
  		
  		
  		if(window.dialogArguments != undefined)
  		{
  			SourceSheet=window.dialogArguments.sheetObjects[0];
  			var Row=0;
  			for(var i=SourceSheet.HeaderRows;i<=SourceSheet.LastRow;i++)
  				Row = sheetObj.DataInsert(-1); 
  		
  			for(var i=3;i<=SourceSheet.LastCol;i++)
  			{
  				
  				if(i>=6)
  					SourceSheet.Copy2SheetCol(sheetObjects[0],i,i+ 2,1,Row,-1,0,false,false);
  				else
  					SourceSheet.Copy2SheetCol(sheetObjects[0],i,i+ 1,1,Row,-1,0,false,false);
  			}	
			
  			var j=0; 
  			for(var i=sheetObjects[0].HeaderRows;i<=sheetObjects[0].LastRow;i++)
  			{
  					if(SourceSheet.CellValue(i,"sheet1_ibflag")=="D")
  					{
  						sheetObjects[0].RowStatus(i)="R";
  						sheetObjects[0].CellValue(i,"del_check")="1";
  						j++;	
  					} else {
  						sheetObjects[0].RowStatus(i)=SourceSheet.RowStatus(i);
  					}
  			}
  			
  			if(j > 0)	ComRowHideDelete(sheetObjects[0], "del_check");
  		}
  	
  		MnrWaitControl(false);		
	}
	 
	
	//EQ_TYPE별 타입사이를 조회해서 각 배열에 담는다.  
	function initTpszSize()
	{
//	 	var arrXml = MnrComSearchGrid(sheetObjects[0],"type_size_search_ind","order_by_col_nm");
	 	var arrXml = MnrComSearchGrid(sheetObjects[0],"type_size_search_ind","");	
		if(arrXml != null)
		{          
			for(var i = 0; i < arrXml.length; i++)
			{   
				if(i == 0){	       
					uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");    	
				} else if(i == 1){  
					zTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");  
				} else if(i == 2){    
					gTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");       	
				}	  	 
			}  	 
		}	  
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) 
		{
		case 1:
			with (sheetObj) 
			{
	
				// 높이 설정
				style.height = 210;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
	
				var HeadTitle1 = "|Sel.|Del.|Seq.|TYPE|Office\nLocation|Currency|System Verify Result";
				if(selTpSz.length > 0)						
				{
					for(var i=0;i<selTpSz.length;i++)
					{
						HeadTitle1+="|" + selTpSz[i];
						HeadTitle1+="|" + selTpSz[i]+"_Seq";
	
					}
				}else{
	
					HeadTitle1+="|D2|D4|D5|D7|F2|F4|O2|O4|R2"
				}
				HeadTitle1+="|orgIbflag";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
					
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "";
				InitDataProperty(0, cnt++ , dtHiddenStatus,		50,   	daCenter,	true,   prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,   		40,    	daCenter,  	false,	"checkbox",     	false,  "", dfNone,		0,	true,	true);           
				InitDataProperty(0, cnt++ , dtDummyCheck,   	40,    	daCenter,  	false,  "del_check",     	false,  "", dfNone,		0,	true,	true);               
				InitDataProperty(0, cnt++ , dtDataSeq,      	40,   	daCenter, 	true,   "Seq");
				InitDataProperty(0, cnt++ , dtCombo,        	50,   	daCenter, 	true,   prefix+"inp_msg1",  false,  "",	dfNone, 	0, 	true,  	true);
				InitDataValid(   0,    cnt,  vtEngUpOther, "0123456789");  
				InitDataProperty(0, cnt++ , dtPopupEditFormat,	60,   	daCenter, 	true,   prefix+"inp_msg2",  false,  "", dfEngUpKey,	0, 	true,  	true,	6);
				InitDataProperty(0, cnt++ , dtCombo,        	60,   	daCenter, 	true,   prefix+"inp_msg3",	false,  "", dfNone, 	0, 	true,  	true);
				InitDataProperty(0, cnt++ , dtData,         	130,	daLeft, 	true,   prefix+"inp_msg4",  false,	"", dfNone,		0,	false,	false);

				if(selTpSz.length>0)
				{
					for(var i=0;i<selTpSz.length;i++)
					{
						InitDataProperty(0, cnt++ , dtData,     60,   daRight, true,   prefix+selTpSz[i],         false,  "", dfFloat,	2, true,  true,	13);
						InitDataProperty(0, cnt++ , dtHidden,	60,   daRight, true,   prefix+selTpSz[i]+"_Seq",  false,  "", dfNone,	0, true,  true);

					}
				}else{
	
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"D2",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"D4",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"D5",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"D7",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"F2",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"F4",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"O2",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"O4",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"R2",         false,  "", dfFloat,	2, true,  true,	13);
	
				}
	
				InitDataProperty(0, cnt++ , dtHidden,         60,   daRight, true,   prefix+"orgIbflag",         false,  "", dfNone,	0, true,  true);

	
				CountPosition = 0;
	
			}
			break;
			
		case 2:
			with (sheetObj) 
			{
	
				// 높이 설정
				style.height = 0;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
	
				var HeadTitle1 = "|Sel|Del|Seq|TYPE|Office\nLocation|Currency|Verify\nResult";
				
	
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "";
				InitDataProperty(0, cnt++ , dtHiddenStatus,	50, daCenter,	true,   prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,   	40,	daCenter,  	false,	"checkbox",     	false,  "", dfNone,	0,	true,	true);           
				InitDataProperty(0, cnt++ , dtDummyCheck,   40, daCenter,  	false,  "del_check",     	false,  "", dfNone,	0,	true,	true);               
				InitDataProperty(0, cnt++ , dtDataSeq,      40, daCenter, 	true,   "Seq");
				InitDataProperty(0, cnt++ , dtCombo,        50, daCenter, 	true,   prefix+"inp_msg1",	false,  "",	dfNone, 0, 	true,	true);
				InitDataProperty(0, cnt++ , dtData,         60, daCenter, 	true,   prefix+"inp_msg2",  false,  "", dfNone, 0, 	true,  	true);
				InitDataProperty(0, cnt++ , dtData,        	60, daCenter, 	true,   prefix+"inp_msg3",  false,  "", dfNone, 0, 	true,  	true);
				InitDataProperty(0, cnt++ , dtData,         60, daRight, 	true,   prefix+"inp_msg5",  false,  "", dfNone,	0, 	true,  	true);
	
				CountPosition = 0;
	
			}
			break;			
	
		}
	}
	 

		function inp_msg1_AND_inp_msg2_UniqueCheck()
		{
			var sInpMsg1="";  //sheet
			var sInpMsg2=""; //sheet
			var chkOk=false;
			sheetObj=sheetObjects[0];
			sheetObj.ColumnSort("inp_msg1|inp_msg2", "ASC");
			for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
			{
				if(sheetObj.RowStatus(i)=="D") continue;
				var checkEqNo=sheetObj.CellValue(i, "inp_msg2"); //sheet
				if(checkEqNo=="") continue;
				sheetObj.CellFont("FontBold", i, "inp_msg2") = false;
				if(chkOk==false)
				{

					sInpMsg1=sheetObj.CellValue(i, "inp_msg1");  //sheet
					sInpMsg2=sheetObj.CellValue(i, "inp_msg2"); //sheet
					chkOk=true;
					continue;
				}else{
					if(sInpMsg1 ==sheetObj.CellValue(i, "inp_msg1")
							&& sInpMsg2 ==sheetObj.CellValue(i, "inp_msg2")
					)
					{
						var sSeq=sheetObj.CellValue(i, "Seq");
						sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq) - 1, "inp_msg1") = true;
						sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq) - 1, "inp_msg2") = true;
						sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq), "inp_msg1") = true;
						sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq), "inp_msg2") = true;


						ComShowCodeMessage("MNR00006","Type and Office and Location");
						sheetObj.SelectCell(sheetObj.FindText("Seq",sSeq), "inp_msg2",true);

					
						return false;

					}else
					{
						sInpMsg1=sheetObj.CellValue(i, "inp_msg1");  //sheet
						sInpMsg2=sheetObj.CellValue(i, "inp_msg2"); //sheet
					} 

				}
			}
			sheetObj.ColumnSort("Seq", "ASC"); //정렬 초기화
			return true;
		}
	
	//오피스코드 벨리데이션 체크  
	function sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var retArray =  null;        
		 if (sheetObj.ColSaveName(Col) == "inp_msg2"){   
			//2. 해당 Type 빈값일 경우
			var strGrpCD =ComTrimAll(sheetObj.CellValue(Row, "inp_msg1")," ");
			if(strGrpCD=="")
			{
				ComShowCodeMessage("MNR00036","Type");
				sheetObj.CellValue2(Row ,Col) = "";    
				sheetObj.SelectCell(Row, "inp_msg1",	true);
				return; 
			}
			sheet1_ofc_loc_cd_Check(sheetObj,Row,Col,strGrpCD);  	
		}		
	}

	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) != "inp_msg2") return;

		//2. 해당 Unit Type 빈값일 경우
		var strCostDtlCD =ComTrimAll(sheetObj.CellValue(Row, "inp_msg1")," ");
		if(strCostDtlCD=="")
		{
			ComShowCodeMessage("MNR00036","Type");
			sheetObj.SelectCell(Row, "inp_msg1",	true);
			return; 
		}
		if(strCostDtlCD=="CNT")
		{
			document.form.mnr_disp_trf_grp_cd.value=strCostDtlCD;
			ComOpenPopup("COM_ENS_051.do", 810, 450, 'setPopUpParam_COM_ENS_051', '1,0', true);
		}
		else
		{
			document.form.mnr_disp_trf_grp_cd.value=strCostDtlCD;
			ComOpenPopup("COM_ENS_071.do", 810, 450, 'setPopUpParam_COM_ENS_071', '1,0', true);
		}
	}   
						
	function sheet1_ofc_loc_cd_Check(sheetObj,Row,Col,strGrpCD){
		var OfficeMLocCd = sheetObj.CellValue(Row ,Col); 
		var retArray=null;
		if(strGrpCD=="RHQ")
		{
			checkOffice=OfficeMLocCd+"\|2";   
		    retArray = MnrGeneralCodeCheck(sheetObj,"OFC",checkOffice);  
		}else if(strGrpCD=="OFC"){
			checkOffice=OfficeMLocCd+"\|none"; 
		    retArray = MnrGeneralCodeCheck(sheetObj,"OFC",checkOffice);  
		}else if(strGrpCD=="CNT"){
			checkOffice=OfficeMLocCd;
		    retArray = MnrGeneralCodeCheck(sheetObj,"MLOC",checkOffice);  
		}
		
	    
		if(retArray == null){           
			if(strGrpCD=="CNT")
				ComShowCodeMessage("MNR00165",OfficeMLocCd,"LOCATION"); 
			else
				ComShowCodeMessage("MNR00165",OfficeMLocCd,"OFFICE"); 	
			sheetObj.CellValue2(Row ,Col) = "";      
			sheetObj.SelectCell(Row ,Col);                      
		} else {	  
			sheetObj.CellFont("FontBold", Row, "inp_msg1",sheetObj.LastRow,"inp_msg1") = false;
			sheetObj.CellFont("FontBold", Row, "inp_msg2",sheetObj.LastRow,"inp_msg2") = false;
			return;    
		}   		
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction))return;
			formObj.f_cmd.value = MULTI;   

			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
				if(sheetObj.CellValue(i,"ibflag") != "D")
				{
					sheetObj.CellValue(i,"orgIbflag") = sheetObj.CellValue(i,"ibflag"); 
					sheetObj.RowStatus(i) = "I";      
				}
			}          
//			var sParam = "";
//			var aryPrefix = new Array( "sheet1_");
//			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);

			var sParam = sheetObj.GetSaveString(false, true); 
			if (sParam == "") return;
			sParam += "&" + FormQueryString(formObj);  
			var sXml = sheetObj.GetSaveXml("EES_MNR_0220GS.do", sParam);

			sheetObjects[1].LoadSaveXml(sXml); 

			//체크된 로우에 색상을 입힌다.     
			for(var i = 1; i <= sheetObjects[1].RowCount; i++){  
				
				if(sheetObjects[1].CellValue(i,"checkbox") == 1){    
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);	
					//success 된것은 수정하지 못하게 한다.
					sheetObj.CellEditable(i,"inp_msg1") = false;
					sheetObj.CellEditable(i,"inp_msg2") = false;
					sheetObj.CellEditable(i,"inp_msg3") = false; 
					sheetObj.CellValue(i,"checkbox") =sheetObjects[1].CellValue(i,"checkbox"); 
					sheetObj.CellValue(i,"inp_msg4") =sheetObjects[1].CellValue(i,"inp_msg5"); 
				} else {                 
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
					sheetObj.CellValue(i,"inp_msg4") =sheetObjects[1].CellValue(i,"inp_msg5"); 
					//실패한건은 선택할수 없다. 
					sheetObj.CellEditable(i,"checkbox") = false;  
				}                          
			}        
			
			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
				if(sheetObj.CellValue(i,"ibflag") != "D")			
				{	
					sheetObj.RowStatus(i) = sheetObj.CellValue(i,"orgIbflag");  	  
				}				
			}          	
			verifyCheck = true;
			
			//verifyCheck에 사용된 eqtype을 저장한다. 

			break;      

		case IBINSERT:  // ROWADD                   
			var Row = sheetObj.DataInsert(-1); 
			sheetObj.CellValue2(Row,"inp_msg1") = ""; 
			sheetObj.CellValue2(Row,"inp_msg2") = ""; 
			sheetObj.CellValue2(Row,"inp_msg3") = ""; 
			sheetObj.CellEditable(Row,"checkbox") = false; 
			verifyCheck = false;                       
			break; 

		case IBDELETE:  // ROWDELETE   
			ComRowHideDelete(sheetObj, "del_check");
			break;
			
		case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화 
			MnrWaitControl(true);

			sheetObj.WaitImageVisible=false;

			//쉬트 초기화
			sheetObj.RemoveAll();  
			verifyCheck = false;  
			sheetObj.WaitImageVisible=true;
			MnrWaitControl(false);  
			break; 		

		case IBDOWNEXCEL:
			var cnt=sheetObj.RowCount;
			if(cnt <= 0){	
				var Row = sheetObj.DataInsert(-1); 
			}		
										 					
			//4   /apps/alps/ees/mnr/operationmanage/disposalmgt/xml/EES_MNR_0220_FORMAT.xml	
			sheetObj.SpeedDown2Excel(-1, false,false,"", "",false,false,"",false,"1|2|3|7"); 
			if(cnt <= 0){	       	
				sheetObj.RemoveAll(); 	
			}			
			break;	
		}
	}
	
	/**
	 * 추가로 넘겨야 될값이 많아서 따로 구현한다.
	 */
	function comPopupOK_220(sheetObj,formObject) {
		var formObject = document.form; 
		               
		window.dialogArguments.setPopUpParam_EES_MNR_0220(sheetObj);   //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.
		window.close();                 
	}   
	

	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	 function validateForm(sheetObj,formObj,sAction){
	 		with(formObj){
	  			if(sAction==IBSAVE)
	  			{
	  				
	  			  var sTypeText = sheetObj.GetComboInfo(0,"inp_msg1", "Text");
	  			  var arrTypeText = sTypeText.split("|");
	  			  
	  			  var sCurrencyText = sheetObj.GetComboInfo(0,"inp_msg3", "Text");
	  			  var arrCurrencyText = sCurrencyText.split("|");
	 				for(var i=sheetObjects[0].HeaderRows ;i<=sheetObjects[0].LastRow;i++)
	 				{

	 					//2. 해당  Type 빈값일 경우
	 					var checkData =ComTrimAll(sheetObjects[0].CellText(i, "inp_msg1")," ");
	 					if(checkData=="")
	 					{
	 						ComShowCodeMessage("MNR00036","Type");
	 						sheetObjects[0].SelectCell(i, "inp_msg1",true);
	 						return false; 
	 					}
	 					for(var j=0;j<arrTypeText.length;j++)
	 					{
	 						
	 						if(sheetObjects[0].CellText(i,"inp_msg1") == arrTypeText[j])
	 						{
	 							break;
	 						}
	 						if(j==arrTypeText.length - 1)
	 						{
	 							ComShowCodeMessage("MNR00165",sheetObjects[0].CellText(i, "inp_msg1"),"Type");
	 							sheetObjects[0].CellText(i, "inp_msg1")="";
	 							sheetObjects[0].SelectCell(i, "inp_msg1",true);
	 							return false; 
	 						}
	 					}
	 					
	 					//3. Office,Location를 Mandatory에 대한 체크를 수행 한다.
	 					var checkData =ComTrimAll(sheetObjects[0].CellValue(i, "inp_msg2")," ");
	 					if(checkData=="")
	 					{
	 						ComShowCodeMessage("MNR00172","Office,Location");
	 						sheetObjects[0].SelectCell(i, "inp_msg2",true);
	 						return false; 
	 					}		
	 					
	 					//4.Currency를 Mandatory에 대한 체크를 수행 한다.
	 					var checkData =ComTrimAll(sheetObjects[0].CellText(i, "inp_msg3")," ");
	 					if(checkData=="")
	 					{
	 						ComShowCodeMessage("MNR00036","Currency");
	 						sheetObjects[0].SelectCell(i, "inp_msg3",true);
	 						return false; 
	 					}
	 					
	 					//5.Currency를 Validation에 대한 체크를 수행 한다.
	 					for(var j=0;j<arrCurrencyText.length;j++)
	 					{
	 						if(sheetObjects[0].CellText(i,"inp_msg3")==arrCurrencyText[j])
	 						{
 								break;
 							}
	 						if(j==arrCurrencyText.length - 1)
	 						{
	 							ComShowCodeMessage("MNR00118");
	 							sheetObjects[0].CellText(i, "inp_msg3")="";
	 							sheetObjects[0].SelectCell(i, "inp_msg3",true);
	 							return false; 
	 						}
	 					}

	 					
	 				}
	 				
					if(!inp_msg1_AND_inp_msg2_UniqueCheck())
					{
						return false; 
					}
 	  			}
	 		}
	 		
	 	return true;
	 }
