/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ees_dmt_6012.js
 *@FileTitle : Pre-Advice Report (Vessel Loading)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : Cho won joo
 *@LastVersion : 1.0
 * 2012.06.22  Cho won joo
 * 1.0 Creation
 * 2012.08.29  Cho won joo 
 * ------------------------------------------------------

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
 * @class EES_DMT_6012 : EES_DMT_6012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_dmt_6012() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.tsTpCd_OnChange=tsTpCd_OnChange;
}
/* 개발자 작업 */
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;
var intervalId = "";

var comboObjects = new Array();
var comboCnt = 0;

// File 관련 명칭
var FILE_NM 			    = "file_nm";
var FILE_SIZE			    = "file_size";
var FILE_PATH 			    = "file_path";
var FILE_DIV_CD             = "aft_bkg_file_div_cd";
var URL_FILE_DOWNLOAD 	    = "/hanjin/FileDownload";
var FILE_SAV_ID 		    = "file_sav_id";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

		 var sheetObject = sheetObjects[0];
         var formObject = document.form;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
				case "btn_DownExcel":					
					doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
					break;
					
				case "btn_New":
					if (ComIsBtnEnable("btn_New")) 
						doActionNew();
					break; 

				case "btn_Close":
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
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * 
      * @param {IBMultiCombo}
      *            combo_obj IBMultiCombo Object
      */
     function setComboObject(combo_obj) {
     	comboObjects[comboCnt++] = combo_obj;
     }
     
//     /**
//      * IBTab Object를 배열로 등록
//      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
//      * 배열은 소스 상단에 정의
//      */
//     function setTabObject(tab_obj){
//         tabObjects[tabCnt++] = tab_obj;
//     }
           
     /**
      * OP DATE  기간 선택 달력 띄우기
      */
     function callDatePop(val){
		var formObj = document.form;
        var cal = new ComCalendarFromTo();
        cal.select(formObj.s_fm_dt, formObj.s_to_dt, 'yyyy-MM-dd');
   	}




    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	
    	var formObj = document.form;

        for(i=0;i<sheetObjects.length;i++){
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			ComEndConfigSheet(sheetObjects[i]);
  		}        
		
		initControl();
		
		if ( parseInt(ComGetLenByByte(ComGetObjValue(formObj.cust_cd))) > 0 ) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} else if ( parseInt(ComGetLenByByte(ComGetObjValue(formObj.dar_no))) > 0 ) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
		}
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
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , formObject ); //- 포커스 나갈때
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		
	}
	
    /**
     * 키보드가 눌릴 때 dataformat으로 세팅하고 엔터키를 누를때 조회한다.
    * @author  김민정
     */
  function obj_KeyPress(){
      var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
      var srcName = event.srcElement.getAttribute("name");
      var srcValue = event.srcElement.getAttribute("value");

      switch(event.srcElement.dataformat) {
          case "ymd":
        	  ComKeyOnlyNumber(event.srcElement);
        	  if (srcValue.length == 4) {
        		  document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
        	  }
        	  if (srcValue.length > 4 && srcValue.indexOf('-') < 0) {
        		  return;
        	  }
        	  if (srcValue.length == 7) {
        		  document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
        	  }
              break;
          case "ymdhm":
        	  ComKeyOnlyNumber(event.srcElement);
        	  if (srcValue.length == 4) {
        		  document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
        	  }
        	  if (srcValue.length == 7) {
        		  document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
        	  }
        	  if (srcValue.length == 10) {
        		  document.form.elements[srcName].value = srcValue.substring(0,10) + " "
        	  }
        	  if (srcValue.length == 13) {
        		  document.form.elements[srcName].value = srcValue.substring(0,13) + ":"
        	  }
              break;
          case "ym":
              ComKeyOnlyNumber(event.srcElement);
              if (srcValue.length == 4) {
                document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
              }
              break;
          case "yw":
          case "jumin":
          case "saupja":  //숫자 + "-"
              ComKeyOnlyNumber(event.srcElement, "-"); break;
          case "hms":
              ComKeyOnlyNumber(event.srcElement, ":");
              if (srcValue.length == 2) {
            	  document.form.elements[srcName].value = srcValue.substring(0,2) + ":"
              }
              if (srcValue.length == 5) {
            	  document.form.elements[srcName].value = srcValue.substring(0,5) + ":"
              }
              break;
          case "hm":    //숫자 + ":"
              ComKeyOnlyNumber(event.srcElement, ":");
              if (srcValue.length == 2) {
            	  document.form.elements[srcName].value = srcValue.substring(0,2) + ":"
              }
              break;
          case "yy":    //숫자 + "0"
              ComKeyOnlyNumber(event.srcElement, "0"); break;
          case "int":    //숫자
              ComKeyOnlyNumber(event.srcElement);  break;
          case "float":  //숫자+"."
              ComKeyOnlyNumber(event.srcElement, "."); break;
          case "signedfloat":  //숫자+".-"
            ComKeyOnlyNumber(event.srcElement, ".-"); break;
          case "commafloat":  //숫자+",-"
                ComKeyOnlyNumber(event.srcElement, ",-"); break;
          case "dashfloat":  //숫자+",-"
            ComKeyOnlyNumber(event.srcElement, "-"); break;
          case "eng":    //영문 + 숫자
            // 영문은 기본 대문자로 한다.(포멧에 대소문자 구분 + 숫자가 없음)
              ComKeyOnlyAlphabet('uppernum'); break;
          case "engup":  //영문대문자
              ComKeyOnlyAlphabet('upper'); break;
          case "engdn":  //영문소문자
              ComKeyOnlyAlphabet('upper'); break;
          case "engupnum"://숫자+"영문대분자"입력하기
          	  ComKeyOnlyAlphabet('uppernum'); break;
          case "engnum"://숫자+"영문대소"입력하기
      	  	  ComKeyOnlyAlphabet('num'); break;
          case "engupspace": //영문대문자 + Space
              if(event.keyCode != 32) {
                  ComKeyOnlyAlphabet('uppernum');
              }
          case "engupspace2": //영문대문자 + Space
	          if(event.keyCode != 32) {
	        	  ComKeyOnlyAlphabet('upper');
	          }
              break;
          case "engupspecial": // 영문대문자 + Space + &-,.
              ComKeyOnlyAlphabet('uppernum', "32|38|45|44|46");
              break;
          case "etc": //모든 문자 가능하지만 영문은 대문자로
              if(keyValue >= 97 && keyValue <= 122) {//소문자
                  event.keyCode = keyValue + 65 - 97;
              }
          	  break;
          default:     //영문 + 숫자
              ComKeyOnlyAlphabet('uppernum'); break;
        }
    }
     
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

		var sheetID = sheetObj.id;
				
        switch(sheetID) {

		      case "sheet1":      //sheet1 init
			        with (sheetObj) {
			
			        	var cnt = 0;
			            // 높이 설정
			            style.height = 400;
			            
			            //전체 너비 설정
			            SheetWidth = 100;
			
			            //Host정보 설정[필수][HostIp, Port, PagePath]
			            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			            //전체Merge 종류 [선택, Default msNone]
			            MergeSheet = msHeaderOnly;
			
			           //전체Edit 허용 여부 [선택, Default false]
			            Editable = true;
			
			            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			            InitRowInfo(1, 1, 4);
			
			            var HeadTitle1 = "|Customer Code|Customer Name|DAR Nbr|Approval Date|Guarantee type|Payment Guarantee letter|File Size ";
						var headCount = ComCountHeadTitle(HeadTitle1)+3;					
			
			            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			            InitColumnInfo(headCount, 0, 0, true);
			
			            // 해더에서 처리할 수 있는 각종 기능을 설정한다
			            InitHeadMode(true, true, true, true, false,false)
			            
			            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			            InitHeadRow(0, HeadTitle1, true);
			
			            //데이터속성    [ ROW,  COL,    DATATYPE,     WIDTH,    DATAALIGN, COLMERGE, SAVENAME, 	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,	"ibflag");
						InitDataProperty(0, cnt++ , dtData,			 120,	daCenter,	false,	"cust_cd",		false,		"", 	dfNone,		0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,			 200,	daLeft,		false,	"cust_nm",		false,		"", 	dfNone,		0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,			 120,	daCenter,	false,	"dar_no",		false,		"", 	dfNone,		0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,			 120,	daCenter,	false,	"apro_dt",  	false,		"", 	dfDateYmd,	0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,			 120,	daCenter,	false,	"gnte_ltr_nm",  false,		"", 	dfNone,		0,			false,		false);
	              		InitDataProperty(0, cnt++, dtPopup, 		 200,   daLeft, 	false, 	FILE_NM, 		false, 		"", 	dfNone, 	0, 			false, 		false);
	              		InitDataProperty(0, cnt++, dtData, 			 50, 	daCenter, 	false, 	FILE_SIZE, 		false, 		"", 	dfNone, 	0, 			false, 		false);
	              		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, 	false, 	FILE_PATH);
	              		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, 	false, 	FILE_SAV_ID);
	              		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, 	false, 	FILE_DIV_CD);
			       }
			       break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				sheetObjects[0].RemoveAll();

				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("EES_DMT_6014GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObjects[0].LoadSearchXml(arrXml[0]);
				}
				break;
							
			case IBDOWNEXCEL:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.Down2Excel(-1, false, false, true);
				break;

        }
  	}
   
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBSEARCH:
				//if(!ComChkRequired(formObj)) return false;
				break;

			case IBDOWNEXCEL:
				if(sheetObjects[0].RowCount == 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;	
    	}
        return true;
    }

 	/**
 	 * t1sheet1 클릭 이벤트 발생
 	 */
 	function sheet1_OnClick(sheetObj, Row, Col, Value) {
    	fnDownloadAtchFile(sheetObj, Row, Col);
 	}

	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 **/
	function fnDownloadAtchFile(sheetObj, Row, Col) {
		
		if (Col != 6) return;
 
		// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		if (sheetObj.CellText(Row, FILE_NM) == "") {
			return;
		}
		// 파일이 존재시 다운로드 받는다.
		var fileSavId = sheetObj.CellValue(Row, FILE_SAV_ID);
		var exist     = fnSaveFileExist(fileSavId, sheetObj);

		// 서버에 파일존재유무확인
		if (eval(exist)) {
			var param = "key=" + fileSavId;
			hiddenFrame.location.href = URL_FILE_DOWNLOAD + "?" + param;
		}
		else {
			alert("Attached File is deleted due to storage server capacity");
		}	
	} 	

	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 **/
	function downloadFileINT(fileSavId) {	
		var param = "key=" + fileSavId;
		hiddenFrame.location.href = URL_FILE_DOWNLOAD + "?" + param;	
	}

	/**
	 * 용량계산하기  <br>
	 * @param {String} 	_val 		파일용량
	 * @param {String} 	r_value    	MB/KB계산 
	 **/
	function getSize(_val) {

		var r_value = _val;
		var _value = Math.round(_val / 1024);

		if (_value > 0) {
			r_value = _value;
			_value = Math.round(_value / 1024);
			if (_value > 0) {
				_value = _value + " MB"
			} 
			else {
				_value = r_value + " KB"
			}
		} 
		else {
			_value = r_value + " Bytes"
		}
		return _value;
	}	


    /**
     * Retrieve 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */		
    function doActionNew() {
        var formObj = document.form;
        
        //조회된 결과 그리드를 지워준다.
        sheetObjects[0].RemoveAll();
        
        //조회필드를 지워준다.
        with(formObj) {        
	        ComClearObject(cust_cd);
	        ComClearObject(cust_nm);
	        ComClearObject(dar_no);
		}
		ComSetFocus(formObj.cust_cd);
		
    }

	function obj_blur(){
         //입력Validation 확인하기 + 마스크구분자 넣기
         var obj = event.srcElement;
         
         if(obj.name == 'cust_cd') {
        	 doActionText(sheetObjects[0], document.form, obj, SEARCH20);
         }
	}

	//Customer 체크
	function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.cust_cd)));

        if(cust_len == 0){
            ComSetObjValue(formObj.cust_cd, "");
            ComSetObjValue(formObj.cust_nm, "");
        	return;
        }
       
        if(cust_len > 2) {
			var char_chk = ComGetObjValue(formObj.cust_cd).substring(0,2);
			//2자리가 영문자이면 CUSTOMER 조회
			if(ComIsAlphabet(char_chk)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
				ComSetObjValue(formObj.s_cust_cd, formObj.cust_cd.value);
			//아니면 VENDOR 조회
			}else{
				ComSetObjValue(formObj.s_cust_gubun, "1");
				ComSetObjValue(formObj.s_cust_cd, formObj.cust_cd.value);
			}
		}else{
			ComShowCodeMessage("DMT00165", "Customer");
            ComSetObjValue(formObj.cust_cd, "");
            ComSetObjValue(formObj.cust_nm, "");
            ComSetFocus(formObj.cust_cd);
			return;
		}

        ComSetObjValue(formObj.f_cmd, formCmd);
        var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
        var custCd = ComGetEtcData(sXml, "PAYER_CODE");
        var custNm = ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg = ComGetEtcData(sXml, "DELT_FLG");

        if(custNm == null || custNm == "" || custNm == undefined) {
            ComSetFocus(formObj.cust_cd);
            document.form.cust_cd.value = "";
            document.form.cust_nm.value = "";   
            ComShowCodeMessage("DMT00165", "Customer");
        } else {
        	document.form.cust_nm.value = custNm;
            document.form.cust_cd.value = custCd;
        }
        sheetObj.WaitImageVisible = true;
    } 
	
	/*
	 * 각 공통팝업창 호출 함수 
	 */
	function openPopup(flag, arg) {
	  		
		var sheetObj = sheetObjects[0];
		var formObj	= document.form;
		var sUrl	= '';
		var sWidth	= '';
		var sHeight	= '';
		
		with(sheetObj) {
	  		switch(flag) {
	  			case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					break;	
	  			case 'dar_no':		// BKG No. 멀티입력 팝업 호출
	  				returntitle = 'DAR No.';
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	  				break;
	  		} // switch-end
		} // with-end
		
		if(sUrl.indexOf('.do') != -1) {
			//var sWinName = ComReplaceStr(sUrl, '.do', '');
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
		} else if(sUrl != '') {
	  		ComOpenWindow('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/' + sUrl,'p'
						,'scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=' + sWidth + ',height=' + sHeight + ',left=0,top=0');
		}
	}
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value = aryPopupData[0][3];
        document.form.cust_nm.value = aryPopupData[0][4];
    }

    /*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }
    

	/**
	 * 파일존재유무판단  
	 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
	 * param :file_id
	 * return :boolean
	 */
	function fnSaveFileExist(fileSavId, sheetObj) {
		var formObj = document.form;
		var param   = "&f_cmd=" + SEARCH26 + "&file_sav_id=" + fileSavId;
		var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", param);
		var exist   = ComGetEtcData(sXml, "is_exists");
		return exist;
	}