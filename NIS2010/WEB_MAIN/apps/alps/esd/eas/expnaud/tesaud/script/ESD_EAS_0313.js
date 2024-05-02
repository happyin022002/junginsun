/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_EAS_0313.js
*@FileTitle : Storage Calculation - Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9012602
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015-02-02 9012602 			1.0	최초 생성
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
     * @class ESD_EAS_0313 : ESD_EAS_0313 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

   	/* 개발자 작업	*/
    /* 공통전역변수 */
  //var calPop = new calendarPopupGrid();  

function ESD_EAS_0321(){
 	this.processButtonClick     = processButtonClick;
 	this.setSheetObject         = setSheetObject;
 	this.setComboObject         = setComboObject;
 	this.setTabObject           = setTabObject;
 	this.loadPage               = loadPage;
 	this.initSheet              = initSheet;        
 	this.initControl            = initControl;
 	this.initTab                = initTab;
 	this.doActionIBSheet        = doActionIBSheet;
 	this.validateForm           = validateForm;
 	this.initCombo				= initCombo;
 }

  var sheetObjects = new Array();
  var sheetCnt = 0;
  var frm ="";

  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  

	/**
	 * 글입력시 max length 체크해서 false 리턴함
	 * @param {object}	obj		input object
	 * @return 
	 */
	function chkInput(obj) {
		if (obj.maxLength < ComGetLenByByte(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
	}

	/** 
	 * 숫자인지 체크함
	 * @param {object}	obj		input object
	 * @return
	*/	
	function isNum(obj){
		//숫자만..
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}
	
	/**
	 * 숫자인지 체크함, 숫자값에 대시를 넣어준다
	 * @param {object}	obj		input object
	 * @return
	 */
	function isNum1(obj){
			//숫자만..
			if (!ComIsNumber(obj,"-")){
				obj.value = '';
			}
		}

	/**
	 * 영문과 숫자인지 체크함
	 * @param {object}	obj		input object
	 * @return
	 */	
	function isApNum(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj,"n")){
			obj.value = '';
		}
	}

	/**
	 * 영문인지 체크함
	 * @param {object}	obj		input object
	 * @return
	 */	
  function isAlpha(obj) {
      if(!ComIsAlphabet(obj)) {
         obj.value = "";
      }

  }

	/**
	 * 한글 및 영문 길이 체크
	 * @param {string}	scr		체크할 문자
	 * @return
	 */		 
  function getStrLen(src) {
		// 한글 및 영문 str의 길이를 구함
		src = new String(src);
		var byteLength = 0;
		for (var inx = 0; inx < src.length; inx++) {
			var oneChar = escape(src.charAt(inx));
			if (oneChar.length == 1) {
				byteLength ++;
			} else if (oneChar.indexOf("%u") != -1) {
				byteLength += 2;
			} else if (oneChar.indexOf("%") != -1) {
				byteLength += oneChar.length/3;
			}
		}
		return byteLength;
	}
  
  	/**
  	 * IBSheet Object를 배열로 등록
  	 * ComSheetObject(id)에서 호출한다
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++] = sheet_obj;
  		// 1-1. jsp에서 선언된 sheet Object들을 배열화 한다.(sheet Object가 여러개일수 있으므로)
  	}
  	
  	
  	
  	
  	 /**
     * Date/Status Combo 속성 설정
     **/
    function initCombo (comboObj, comboNo) {
    	switch(comboObj.id) {
  		   case "tml_inv_tp_cd": 
				with (comboObj) {
					InsertItem(0, "MR Storage",    	"ST");
		            InsertItem(1, "Off Dock",    	"OF");
	    		
		    		MultiSelect = false;
		    		UseCode = true;
		    	    Code = "ST";

		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;		    		
		            CheckCode("") = true;
				}
				break;	 
  		 case "io_bnd_cd": 
				with (comboObj) {
			        InsertItem(0, "All",    "A");
		            InsertItem(1, "I/B",    "I");
		            InsertItem(2, "O/B",    "O");
		            
		            Code = "A";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
				break;	
    	}     
  	}

    
  	 /**
  	  * combo object 를 배열로 등록
  	  * @param {combo}	combo_obj	combo
  	  * @return
  	  */
  	 function setComboObject(combo_obj){
  	     comboObjects[comboCnt++] = combo_obj;
  	 }  
  	

  	/**
  	 * 공통 Node popup
  	 */
  	function openHireYardPopup(objName) {
  		var formObject = document.form;
  		var cmdt_cd_val ="";   //향후 사용가능 예정변수
  		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
  		var cmdt_desc_val ="";   //향후 사용가능 예정변수
  		var classId = objName;
  		var xx1 = ""; //CONTI
  		var xx2 = ""; //SUB CONTI
  		var xx3 = ""; //COUNTRY
  		var xx4 = ""; //STATE
  		var xx5 = ""; //CONTROL OFFIC
  		var xx6 = ""; //LOC CODE
  		var xx7 = ""; //LOC NAME
  		var xx8 = "";
  		var xx9 = "";
  		if( objName == "getDorLoc" ) {
  			v6 = "zone"
  		} else {
  			v6 = "yard";
  		}
  		
  		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
  		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
  	}
  	
  	/**
  	 * From Node 팝업에 대한 리턴값
  	 */
  	function getFromNode(rowArray) {
  		var formObject = document.form;
  		var colArray = rowArray[0];
  		var node = colArray[3];
  		var lvLoc = node.substring(0, 5);
  		var lvYard = node.substring(5, 7);
  		formObject.search_fm_loc.value = lvLoc;
  		getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
  		document.search_fm_yard.CODE = lvYard;
  	}
  	
  	
  	/**
  	 * Sheet 기본 설정 및 초기화 
  	 * body 태그의 onLoad 이벤트핸들러 구현
  	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  	 */
  	function loadPage() {
  		 frm = document.form;
  		for(i=0;i<sheetObjects.length;i++){
  		   //khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		
  		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
  	 		initCombo(comboObjects[k], k+1);
  	 	}
  		
  		initSet(false);
  	}

  	
  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  				with (sheetObj) {
  					var cnt = 0;
  					
//  					style.height = 440;
  					style.height = GetSheetHeight(18);
  					//전체 너비 설정
  					//SheetWidth = 785;
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msAll;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  				// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
  					var rowPerpage = 10000;
  					document.form.pagerows.value = rowPerpage;
  					sheetObj.InitRowInfo(1, 1, 13, rowPerpage);

  					
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//  					InitRowInfo( 1, 1, 10);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					sheetObj.InitColumnInfo(25, 0, 0, false);
  		
  					// 해더에서 처리할 수 있는 각종 기능을 설정한다[SortEnable, ColumnMove, AllCheckEnable, UserResize, RowMove, Head3D]
  					sheetObj.InitHeadMode(true, true, false, true, false, false)
  					
//   					var HeadTitle1 = "|Seq|RHQ|Cost Office|INV Office|Yard|S/P Code|S/P Name|INV No|Calculated Type|Cost Code|Cntr No.|Type/Size|I/O|DG|Year \n Month|Stay \n Days|F/Days|Paid \n Days|Exclude \n Days|Over \n Days|UOM|Rate|AGMT \n Curr|Exch \n Rate|Amount|Remarks|3rd Party";
   					var HeadTitle1 = "|Seq|RHQ|Cost Office|INV Office|Yard|S/P Code|S/P Name|INV No|INV User|CNTR No.|Type/\nSize|Gate In|Gate Out|Stay Days|MVMT Gate In|MVMT Gate Out|MVMT\nStay Days|I/O|F/M|T/S|DG|B/B|Verify\nResult|Remark";

  					
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					sheetObj.InitHeadRow(0, HeadTitle1, true);  					
  					sheetObj.InitColumnInfo(ComCountHeadTitle(HeadTitle1), 9, 0, false);
  					
  					//데이터속성	[   ROW,   COL,	DATATYPE, 	  WIDTH,	DATAALIGN,  COLMERGE,	SAVENAME,   	   KEYFIELD,	CALCULOGIC,   DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					sheetObj.InitDataProperty( 0, cnt++,	dtHiddenStatus,	 40,	daCenter,	   false,	"ibflag");
  					sheetObj.InitDataProperty( 0, cnt++, dtDataSeq,      40,    daCenter,      false,    "seq"	,			false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 60,    daCenter,      false,    "rhq",				false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData, 		 70, 	daCenter,	   false, 	 "cost_ofc_cd",   	false, 	"", 	dfNone, 		0, 		false, 		false );
  					sheetObj.InitDataProperty( 0, cnt++, dtData, 		 70, 	daCenter,	   false, 	 "inv_ofc_cd", 		false, 	"", 	dfNone, 		0, 		false, 		false );
  					sheetObj.InitDataProperty( 0, cnt++, dtData, 		 60, 	daCenter,	   false, 	 "yd_cd", 			false, 	"", 	dfNone, 		0, 		false, 		false );
  					sheetObj.InitDataProperty( 0, cnt++, dtData, 		 65, 	daCenter,	   false, 	 "vndr_seq", 		false, 	"", 	dfNone, 		0, 		false, 		false );
  					sheetObj.InitDataProperty( 0, cnt++, dtData, 		 160, 	daLeft,	   false, 	 "vndr_lgl_eng_nm", false, 	"", 	dfNone, 		0, 		false, 		false );
  					sheetObj.InitDataProperty( 0, cnt++, dtData, 		 95, 	daLeft,	   false, 	 "inv_no",			false, 	"", 	dfNone, 		0, 		false, 		false );
  					sheetObj.InitDataProperty( 0, cnt++, dtData, 		 100, 	daLeft,	   false, 	 "cre_usr_nm",		false, 	"", 	dfNone, 		0, 		false, 		false );
  					sheetObj.InitDataProperty( 0, cnt++, dtData, 		 90, 	daCenter,	   false, 	 "cntr_no",   	false, 	"", 	dfNone, 		0, 		false, 		false );
  					sheetObj.InitDataProperty( 0, cnt++, dtData, 		 50, 	daCenter,	   false, 	 "cntr_tpsz_cd",		false, 	"", 	dfNone, 		0, 		false, 		false );
  					sheetObj.InitDataProperty( 0, cnt++, dtData, 		 100, 	daCenter,	   	   false, 	 "inv_gate_in_dt", 		false, 	"", 	dfNone, 		0, 		false, 		false );
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 100,    daCenter,      false,    "inv_gate_out_dt",	false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 65,    daRight,      false,    "inv_stay_dys",		false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 100,    daCenter,      false,    "mvmt_gate_in_dt",		false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 100,    daCenter,      false,    "mvmt_gate_out_dt",		false,  "",     dfNone,    	0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 65,    daRight,      false,    "mvmt_stay_dys",		false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 50,    daCenter,      false,    "io_bnd_cd",		false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 60,    daCenter,      false,    "cntr_sty_cd",			false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 80,    daCenter,      false,    "locl_ts_ind_cd",false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 70,    daCenter,      false,    "dcgo_clss_cd",			false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 60,    daCenter,      false,    "bb_cgo_flg",	false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 60,    daCenter,       false,    "dscr_ind_cd",			false,  "",     dfNone,    	0,    	false,    	false);
  					sheetObj.InitDataProperty( 0, cnt++, dtData,      	 150,    daLeft,      false,    "cntr_rmk",			false,  "",     dfNone,    		0,    	false,    	false);
  					sheetObj.CountFormat = "[ SELECTDATAROW / TOTALROWS ]";
  				}
  				break;
  		}
  	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 var sheetObject = sheetObjects[0];
  		 var formObject = document.form;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
  				case "btns_calendar1":  					
	  				var cal = new ComCalendar();
	  				cal.select(formObject.fm_prd_dt,'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":  					
	  				var cal = new ComCalendar();
	  				cal.select(formObject.to_prd_dt,'yyyy-MM-dd');  					
  					break;  
  					
  				case "btn_yard":
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "COM_ENS_061";
					var param = '?classId='+classId;
					var chkStr = dispaly.substring(0,3)
					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 480, 'getYard', dispaly);
						
					} else {
						ComShowMessage(ComGetMsg('TES10004')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
						return;
					}
					break;

  				 case "btn_vndr":
                     var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
           	       	var classId = "COM_ENS_0C1";

           		   		var param = '?classId='+classId;

           		   		var chkStr = dispaly.substring(0,3)

                          // radio PopUp
                          if(chkStr == "1,0") {
                              ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getVender', dispaly);
                         } else {
                         	ComShowCodeMessage('TES21906'); //showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                              return;
                         }
           	        break;
           	        
				case "btn_cost_ofc_cd":
					var dispaly = '1,0,1,1,1,1,1,1,1,1,1,1';
					var classId = "COM_ENS_071";
					var param = '?classId='+classId;
					var chkStr = dispaly.substring(0,3)

					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_071.do' + param,  770,  450, 'getCostOfc', dispaly, true);
					} else {
						ComShowMessage(ComGetMsg('TES10004')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
						return;
					}
					break

				case "btn_inv_ofc_cd" :
	          	     var formObject = document.form;
	        			var cmdt_cd_val ="";   //향후 사용가능 예정변수
	        			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	        			var cmdt_desc_val ="";   //향후 사용가능 예정변수
	        			var classId ="getCOM_ENS_ofc";
	        			var xx1="";  //CONTI
	        			var xx2="";  //SUB CONTI
	        			var xx3="";  //COUNTRY
	        			var xx4="";  //STATE
	        			var xx5="";  //CONTROL OFFIC
	        			var xx6="";  //LOC CODE
	        			var xx7="";  //LOC NAME
	        			var xx8="";
	        			var xx9="";

	        			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	        			ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'getInvOfc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	          	        break;
					
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject, formObject, IBSEARCH);
  					break;
  				case "btn_new":
  					formObject.reset();
  					initSet(true);
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg('COM12111'));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
 	
	/**
	 *  yard 값을 가져옴
	 *  @param(array}	rowArray	array object
	 *	@return
	 */	 
	 function getYard(rowArray) {
        //showErrMessage("getYard");
    	var colArray = rowArray[0];
    	document.all.yd_cd.value = colArray[3];
    	//document.all.yd_cd_name.value = colArray[4];
     }
	 
	/**
	 *  vndr code 값을 가져옴
	 *  @param(array}	rowArray	array object
	 *	@return
	 */
     function getVender(rowArray) {
       // showErrMessage("getVender");
    	var colArray = rowArray[0];
    	//document.all.vndr_seq.value = colArray[2].substr(2,6);
    	document.all.vndr_seq.value = colArray[6];
    	document.all.vndr_seq_name.value = colArray[4];
     }

	/**
	 *  office code 값을 가져옴
	 *  @param(array}	rowArray	array object
	 *	@return
	 */	 
     function getOffice(rowArray){
        //showErrMessage("getOffice");
        var colArray = rowArray[0];
        document.all.cost_ofc_cd = colArray[3];
     }

	/**
	 *  cost code 값을 가져옴
	 *  @param(array}	rowArray	array object
	 *	@return
	 */	 	 
     function getCostOfc(rowArray) {

		var formObject = document.form;

		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			document.form.cost_ofc_cd.value = colArray[3];
		}

	 }

	/**
	 *  invoice code 값을 가져옴
	 *  @param(array}	rowArray	array object
	 *	@return
	 */	 	 
	 function getInvOfc(rowArray) {
		var formObject = document.form;

		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			document.form.inv_ofc_cd.value = colArray[3];
		}

	 }
	 
	 
	 
	 /**
	 *  enter 체크해서 처리하는 부분
	 *  @param(funcNm) function name
	 *	@return
	 */	 
	function enterCheck(funcNm){
		if (event.keyCode == 13){
			retrieve();
		}        
	}
 
	/**
	* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	*/
	function vender_change(){
		var frm = document.form;
		// s/p 코드값이 변경되면 기존 저장값을 초기화 해야한다.

		if(frm.vndr_seq.value =="" ){
			frm.vndr_seq.value="";
			frm.vndr_seq_name.value="";

			return;
		}else {
			frm.s_vndr_seq.value = frm.vndr_seq.value;

			frm.f_cmd.value = SEARCH05;
			var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
			var vndrNm = EasXmlString(sXml,"vndr_nm");
			if(vndrNm==0){
				ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
				frm.vndr_seq.value="";
				frm.vndr_seq_name.value="";
				return;
			}else{
				frm.vndr_seq_name.value = vndrNm;
			}
		}
	
	}	  
	
	
	/**
	* Cost Office  에 값이 존재하는지 체크 한다.
	*/ 
	function  costOffice_change(){
		var frm = document.form;
	   var costOfcCd = frm.cost_ofc_cd.value;
	   frm.respb_ofc_cd.value = costOfcCd;
	   if(costOfcCd ==""){
		   return;
	   }
	   frm.f_cmd.value = SEARCH07;
	   var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	   var isflag = EasXmlString(sXml,"isflag");
	   if(isflag==0){
		   ComShowCodeMessage('COM132202', 'Cost Office'); //사용할수 없는 Cost Office 
		   frm.cost_ofc_cd.value="";
	   }
	}	  
	
	
	/**
	* Invoice Office 에 값이 존재하는지 체크 한다.
	*/ 
	function  invoiceOffice_change(){
		var frm = document.form;
	   var invOfcCd = frm.inv_ofc_cd.value;
	   frm.respb_ofc_cd.value = invOfcCd;

	   if(invOfcCd ==""){
		   return;
	   }
	   frm.f_cmd.value = SEARCH07;
	   var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	   var isflag = EasXmlString(sXml,"isflag");
	   if(isflag==0){
		   ComShowCodeMessage('COM132202', 'Invoice Office'); //사용할수 없는 Resp. Office 
		   frm.inv_ofc_cd.value="";
	   }
	}	  
	
	/**
	* Location 에 값이 존재하는지 체크 한다.
	*/
	function yd_cd_change(){
	   var frm = document.form;
	   var lvobj = frm.yd_cd.value;
	   if(lvobj ==""){
	   return;
	   }
	   frm.f_cmd.value = SEARCH17;
	   var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	   var isflag = EasXmlString(sXml,"isflag");
	   if(isflag==0){
		   ComShowCodeMessage('COM132202', 'Yard Code'); //사용할수 없는 Location 
		   frm.yd_cd.value="";
	   }
	   
	}	
	
	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj, formObj, sAction, PageNo) {

  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
		   case IBSEARCH:	  //조회
			   	if(!validateForm(sheetObj,formObj,sAction)) {
 					return false;
 				}

				formObj.f_cmd.value = SEARCHLIST03;

				sheetObj.RemoveAll(); 
				var pageParam = FormQueryString(formObj) + "&page_no=1";
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0321GS.do", pageParam, true);
				sheetObj.LoadSearchXml(sXml, true); 
				break;
		   case IBSEARCHAPPEND:
			   formObj.f_cmd.value = SEARCHLIST01;
				var pageParam = FormQueryString(formObj) + "&page_no=" + PageNo;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0321GS.do", pageParam, true);
				sheetObj.LoadSearchXml(sXml, true);
				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //엑셀내려받기
  				sheetObj.SpeedDown2Excel(true);
  				break;
			break;	
  				
  		}
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			if(!ComChkValid(formObj)) return false;
  		}
  		switch(sAction) {
  		case IBSEARCH:      //조회
			var vDaysBetweenMax = 92;
			var vndrSeqFlg = false;
	        with(formObj){
				if(ComIsNull(inv_date_type)) {
					ComAlertFocus(inv_date_type, ComGetMsg("COM130201", "Invoice Date Type"));
					return false;
				} else if(ComIsNull(fm_prd_dt)) {
					ComAlertFocus(fm_prd_dt, ComGetMsg("COM130201", "Invoice Date"));
					return false;
				} else if(ComIsNull(to_prd_dt)) {
					ComAlertFocus(to_prd_dt, ComGetMsg("COM130201", "Invoice Date"));
					return false;
				} else if(ComIsNull(yd_cd)) {
					ComAlertFocus(yd_cd, ComGetMsg("COM130403", "Yard Code"));
					return false;
				} else if(!ComIsNull(vndr_seq)) {
					vndrSeqFlg = true;
					vDaysBetweenMax = 183;
				}
				
				var vDaysBetween = ComGetDaysBetween(fm_prd_dt , to_prd_dt) ;  // 조회 기간
				if ( vDaysBetween > vDaysBetweenMax ) {
					if(vndrSeqFlg)
						ComShowCodeMessage("EAS90088");
					else
						ComShowCodeMessage("EAS90087");
					
					fm_prd_dt.focus();
					return false;
				}
	        }
			break;
		}
		return true;
  	}
  	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet_OnSearchEnd(sheetObj,errMsg){
  		if (errMsg != null) {
  	        ComShowMessage(errMsg);
  	    }
  	}
  	
  	function sheet1_OnClick(sheetObj, Row,Col,Value){
  		if ( sheetObj.ColSaveName(Col) == "blahblah" ) { 
  		
  		}
  	}
  	
  	
  	/** 
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
     */  	
	function sheet1_OnLoadFinish(sheetObj){
		var formObj = document.form;
	}
  	
   	
  	/**
  	 * sheet 조회시 발생하는 이벤트
  	 * @param {sheet}	sheetObj	콤보에서 사용할 데이터 관련 sheet
  	 * @param {string}	ErrMsg		error message
  	 * @return
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){ 

  	    if(errMsg!=null){
  	        ComShowMessage(errMsg);
  	    }
      
  	    ComEtcDataToForm(document.form, sheetObj);
  	}
  	    
 
  	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
  		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, PageNo);
    }

  	
  	/**
  	 * Subject Code combo 값 변경 시 발생
  	 * 선택된 코드로 Detail Code 가져오기
  	 * @param {combo object}	comObj		Subject Code combo
  	 * @param {string}			text		선택된 값
  	 * @return
  	 */
  	function tml_inv_tp_cd_OnChange(comObj,text)
  	{
  	   document.form.tml_inv_tp_cd.value = comObj.Code;     
  	} 
  	
  	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "fm_prd_dt":
			case "to_prd_dt":
				if(!ComChkObjValid(obj)){
					obj.value = "";
					obj.focus();
				};
			break;
		}
	} 	
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "fm_prd_dt":
//			getMonthBetween(obj);
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "to_prd_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		}
	}
	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "fm_prd_dt":
			ComClearSeparator(obj, "ymd" )
			obj.select();
			break;	
		case "to_prd_dt":
			ComClearSeparator(obj, "ymd" )
			obj.select();
			break;	
		}
	}

	function initSet(flg) {
		var formObj = document.form;
		ComSetObjValue(formObj.pagerows, "10000");
		ComSetObjValue(formObj.fm_prd_dt, ComGetDateAdd(null, "d", -91, "-"));
		ComSetObjValue(formObj.to_prd_dt, ComGetNowInfo());
		if(flg){
			sheetObjects[0].RemoveAll();
		}
	}
	/* 개발자 작업  끝 */