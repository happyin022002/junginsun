/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.  
*@FileName   : CoCoa.js
*@FileTitle  : COA business common js
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	// COA 추가 메세지
	msgs['COA10001'] = 'Please enter correct date.\n\n Format : YYYY-WW';
	msgs['COA10002'] = 'Please enter {?msg1}.';
	msgs['COA10003'] = '{?msg1} can be processed only {?msg2}.';
	msgs['COA10004'] = '{?msg1} is invalid PORT.';
	msgs['COA10005'] = 'There is no data retrieved on {?msg1}.\n\n Please retrieve {?msg1} first.'; 
	msgs['COA10006'] = 'Process completed.';
	msgs['COA10007'] = 'A maximum of {?msg1} weeks can be entered.';
	msgs['COA10008'] = 'Can not exceed {?msg1}.';
	msgs['COA10009'] = 'Please enter {?msg1} correctly.\n\n Format : {?msg2}';
	msgs['COA10010'] = 'Please enter group name to save.';
	msgs['COA10011'] = '{?msg2} of {?msg1} should be equal to or less than {?msg3}.'; 
	msgs['COA10012'] = '{?msg2} of {?msg1} should be equal to {?msg3}.';
	msgs['COA10013'] = 'It differs from number of {?msg1}.';
	msgs['COA10014'] = 'Please save {?msg1} first.';
	msgs['COA10015'] = 'Please check {?msg1} first.';
	msgs['COA10016'] = '3rd value of {?msg1} differs from {?msg2}.';
	msgs['COA10017'] = 'Can create after retrieve.';
	msgs['COA10018'] = '{?msg1} process has been completed normally.';
	msgs['COA10019'] = 'Do you want to create selected data?';
	msgs['COA10020'] = 'Do you want to create data?';
	msgs['COA10021'] = 'Do you want to reset data?';
	msgs['COA10022'] = 'There are {?msg1} data on saved vessel information.\n\n Please check.';
	msgs['COA10024'] = 'It can not be exceeded by {?msg1} weeks.\n\n Please select {?msg2} data.';
	msgs['COA10025'] = 'Do you want to execute BSA batch?';
	msgs['COA10026'] = 'Please select {?msg1}.';
	msgs['COA10027'] = '{?msg1} is invalid VVD or has no ETD.';
	msgs['COA10028'] = 'Do you want to delete the selected data?';
	msgs['COA10029'] = 'You can delete maximum number in the same group.';
	msgs['COA10030'] = 'It is impossible to delete under level X.';
	msgs['COA10031'] = 'It is impossible to delete level X.';
	msgs['COA10032'] = 'Please select a line with a Route No. when there are more than two Route.';
	msgs['COA10033'] = 'Do you apply to P/L Chart?' ;
	msgs['COA10034'] = 'You can only retreive the Sales Office, Sub Ofc 1, Sub Ofc2 Level.' ;
	msgs['COA10035'] = 'Please choose within the same terminal only.' ;
	msgs['COA10036'] = 'Do you wish to apply BSA 0 function?';
	msgs['COA10037'] = 'The data earlier than July 2007 and 27wk 2007 are not available.\nPlease refer to DW, CRM, etc.';
	msgs['COA10038'] = 'The inquiry period is limited to {?msg1}.';
	msgs['COA10039'] = 'You can add rows after retrieving data.';
	msgs['COA10040'] = 'There is no relevant data.';
	msgs['COA10041'] = 'You are reqeusted to insert proper Port or Lane code to apply Temp P/C.';
	msgs['COA10042'] = 'Requested Temp Route is alreayd registered.\nPlease check and use actually registered Route.';
	msgs['COA10043'] = 'vessel code [{?msg1}] is duplicated. Please enter another code.';
	msgs['COA10044'] = 'Slot Price is missing.';
	msgs['COA10045'] = 'There is already Route Projection data.';
	msgs['COA10046'] = 'Durations are not match.\pPlease calculation again after control sheet data .';	
	msgs['COA10047'] = 'Please make Route Projection Data before Saving.';
    msgs['COA10048'] = 'Please fill in frequency data.';
    msgs['COA10049'] = '1st save is successed.';
  	msgs['COA10050'] = '2st save is successed.';
 	msgs['COA10051'] = 'Source month can\'t be preceded by target month \nor shouldn\'t be the same as target month.';
    msgs['COA10052'] = 'Do you want to Copy From Source Data To Target Data?';
    msgs['COA10053'] = 'It\'s not possible to proceed with "CREATION" when the selected date is before the creation date';
    msgs['COA10054'] = 'Pass word is missing. Will you close this window?';
    msgs['COA10055'] = 'Wrong password. Please try again ';
    msgs['COA10056'] = 'OP is not available for Trade Profit.';
    msgs['COA10057'] = 'Port tariff creation has been restricted for the past period before October2010 or week40 of y2010.\nYou may inquire the past tariff before week40 of y2010 but can\'t re-create the old tariff.';
    msgs['COA10058'] = 'This class is not empty';
    msgs['COA10059'] = 'There is no unit cost registered on this route. Please contact NOA for correct rate quotation.';
    msgs['COA10060'] = 'This option is not able to use in this screen.';
    msgs['COA10061'] = 'Do you want to save?';
    msgs['COA10062'] = 'Do you want to interface Month VVD data?';
    msgs['COA10063'] = 'Firts 2 charactor of Sub group cost code must be same with Main group cost code.';
    msgs['COA10064'] = 'There is child data on Sub group cost code.';
    msgs['COA10065'] = 'There is no contents to save.';
    msgs['COA10066'] = 'There is child data on C/A code.';
    msgs['COA10067'] = '{?msg1} must be {?msg2} characters long.';
    msgs['COA10068'] = 'Resister Sub Group Cost Code. - Main Group Cost Code({?msg1}).';
    msgs['COA10069'] = 'Average RPB was created. \n\n Do you want to create data?';				//SJH.20141105.ADD
    msgs['COA10070'] = 'First 2 charactor of Port data must be same with Country data.';		//SJH.20141105.ADD
    msgs['COA10071'] = 'Validation has not been made  or \nif the data has changed, please retry Validation.';	//SJH.20141105.ADD
    msgs['COA10072'] = 'Data is truncated at a maximum of ({?msg1}) lines. {?msg2}';			//SJH.20141105.ADD
    msgs['COA10073'] = 'A maximum of {?msg1} months can be entered.';
    msgs['COA10074'] = 'Average cost was created. \n\n Do you want to create data?';				//SJH.20141105.ADD

    msgs['COA00001'] = 'BackEndJob Request Fail!';
    msgs['COA00002'] = 'Created BackEndJob File exist already!';
    msgs['COA00003'] = '{?msg1} is Processing...';//Batch Processing 이 진행 중임을 표시
    msgs['COA00004'] = '{?msg1} saved successfully.';
    msgs['COA00005'] = '{?msg1} is failed. Please {?msg2} again.';
    msgs['COA00006'] = 'Do you want to save?';
    msgs['COA00007'] = 'There is no contents to save.';
    msgs['COA10075'] = 'Batch Job Process Fail!';												//20150817.ADD
    msgs['COA10076'] = '{?msg1} is invalid VVD or has no ETD.';									//20151126.ADD
    
    /**
     * 화면에서 Enter클릭시 Retrieve를 처리하도록함.
     *   <form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
     *
     */
    function keyEnter(){
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        if(ComGetEvent("keycode") == 13){
            doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }
    }
   
    /**
     * input box의 maxlength를 입력하면 input text의 길이와 maxlength를 체크하여 다음 컨트롤로 자동으로 이동한다.
     *      onKeyUp = "javascript:autoMoveTab(this, txtToDate);"
     *
     * @param obj1 : 이동 하기 전 input box
     * @param obj2 : 이동 할 input box
     */
    function moveTab(obj1, obj2){
        var keyValue=ComGetEvent("keycode");
        if(obj1.maxLength == obj1.value.length &&
           keyValue != '9'                     &&            // Tab
           keyValue != '16'                    ){          // 역 Tab
			if (obj2.type == "text" ||  obj2.type == "password" || obj2.type == "textarea") {
				obj2.select();
			} else {
    			obj2.focus();
			}
        }
    }
    /**
     * 영대문자만 입력되도록 함
     *    onKeyPress="onlyEng();"
     */
    function onlyEng(){
        var keyValue=ComGetEvent("keycode");
        if((keyValue >= 97 && keyValue <= 122) || (keyValue >= 65 && keyValue <= 90)) {
            if(keyValue > 90) {
                event.keyCode=65 + keyValue - 97;
            }
            event.returnValue=true;
        }else{
            event.returnValue=false;
        }
        return true;
    }
    /**
     * 영대문자와 숫자만 입력되도록 함
     *     onKeyPress="onlyEngNumber();"
     */
    function onlyEngNumber(){
        var keyValue=ComGetEvent("keycode");
        if((keyValue >= 97 && keyValue <= 122) ||
           (keyValue >= 65 && keyValue <= 90)  ||
           (keyValue >= 48 && keyValue <= 57)  ||
            keyValue == 8 || keyValue == 46 || keyValue == 9) {
            if(keyValue > 90) {
                event.keyCode=65 + keyValue - 97;
            }
            event.returnValue=true;
        }else{
            event.returnValue=false;
        }
        return true;
    }
    /**
     * 숫자와 dash(-)만 입력 가능하도록 한다
     */
    function onlyNumberDash(event){
        var keyValue=ComGetEvent("keycode");
        /* 0 ~ 9 : 48 ~ 57, 키패드 0 ~ 9 : 96 ~ 105 ,8 : backspace, 46 : delete, 9 : tab */
        if((keyValue >= 48 && keyValue <= 57) || (keyValue >= 96 && keyValue <= 105) || keyValue == 8 || keyValue == 46 || keyValue == 9){
            event.returnValue=true;
        } else {
            event.returnValue=false;
        }
        return true;
    }
    /**
     * 숫자와 두번째 인자로 들어온 char만 허용
     */
    function onlyNumberDot(event){
        var keyValue=ComGetEvent("keycode");
        // 0 ~ 9 : 48 ~ 57, 키패드 0 ~ 9 : 96 ~ 105 ,. : 190
        if((keyValue >= 48 && keyValue <= 57 ) ||
             ( keyValue >= 96 && keyValue <= 105) ||
             keyValue == 8 || keyValue == 46 || keyValue == 9|| keyValue == 190){
            event.returnValue=true;
        } else {
            event.returnValue=false;
        }
        return true;
    }
    /**
     * 날자의 유효성체크 후 dash입력하여 리턴한다.
     *
     * @param obj  object
     */
    function validDate(obj){
        var str=obj.value.replace(/\/|\-|\./g,"");
        if(obj.value.length>0){
            if(!ComIsDate(obj)){
                ComShowMessage(ComGetMsg("COM12132", "", ""));
            }else{
                addDateDash(obj);
            }
        }
    }
    /**
     * 입력값이 유효한 일자인지 확인하고
     * 일자 형식에 맞추어 Dash[-]를 추가한다.
     *
     * @param obj  object
     * @return 구분자가 추가된 일자 형식의 문자열
     */
    function addDateDash(obj){
        if (ComIsEmpty(obj)) return false;
        var numstr=obj.value.replace(/\/|\-|\./g,"");
        if (numstr.length < 6) {
            obj.value='';
            ComShowMessage(ComGetMsg('COA10009','Date','YYYYMM')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
    		obj.focus();            
            return false;
        } // end if
        if (numstr.length == 6){
            if (!isValidYYYYMM(obj)) return false;
            var rxSplit=new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])');
            numstr=numstr.replace(rxSplit, '$1'+'-'+'$2');
        } else {
            if (!ComIsDate(obj)) return false;
            var rxSplit=new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])');
            numstr=numstr.replace(rxSplit, '$1'+'-'+'$2'+'-'+'$3');
        } // end if
        obj.value=numstr;
        return true;
    }
    /**
     * 원하는 위치에 Dash를 넣어준다.
     *
     * @param obj object
     * @param dash를 넣을 위치
     */
    function addDash(obj, cnt){
        var value=obj.value.replace(/\/|\-|\./g,"");
        var rtnValue="";
        if(value.length > cnt){
            rtnValue=value.substring(0, cnt)+"-"+value.substring(cnt);
            obj.value=rtnValue;
        }
    }
    /**
      * 입력된 문자열이 일자 Format YYYYWW이 맞는지를 확인 - (/, -, .) 제거되고 비교
     * @param obj        object
      * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
      * @param ch         세팅할 구분자('/', '-', .....)
      * @param isN        널스트링 허용여부
      * @return true 일자 , false
     */
    function isValidYYYYWW(obj , isSet, ch,  isN) {
       rtn=true;
        str=obj.value.replace(/\/|\-|\./g,"");
        if (!ComIsNumber(obj,"/") && !ComIsNumber(obj,"-") && !ComIsNumber(obj,"-")) rtn=false;
        if (str.length != 6) rtn=false;
        var year="";
        var week="";
        if(rtn) {
          year=str.substring(0,4);
          week=str.substring(4,6);          
          if (ComParseInt( year ) >= 1900  && (ComParseInt(week)>0 && ComParseInt( week) <= 53)) rtn=true;
          else rtn=false;
        }
        if(rtn){
           if(isSet) obj.value=year + ch + week;
        } else {
            if(isN && str == '') {
              rtn=true;
            } else {
              ComShowMessage(ComGetMsg('COA10001'));
              if(isSet) obj.value="";
              obj.focus();
           }
        }
        return rtn;
    }
    /**
      * 입력된 문자열이 일자 Format YYYYMM이 맞는지를 확인 - (/, -, .) 제거되고 비교
      * @param obj        object
      * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
      * @param ch         세팅할 구분자('/', '-', .....)
      * @param isN        널스트링 허용여부
      * @return true 일자 , false
     */
    function isValidYYYYMM(obj , isSet, ch, isN) {
        rtn=true;
        str=obj.value.replace(/\/|\-|\./g,"");
        if (!ComIsNumber(obj,'/') && !ComIsNumber(obj, '-') && !ComIsNumber(obj, '-')) rtn=false;
        if (str.length != 6) rtn=false;
        var year="";
        var month="";
        if(rtn){
          year=str.substring(0,4);
          month=str.substring(4,6);
          //1007년 데이터 처리를 위해, 1008년 데이터 처리 추가
          if((ComParseInt( year ) == 1007 || ComParseInt( year ) == 1008)  && ComIsMonth(month))  rtn=true;
          else if (ComParseInt( year ) >= 1900  && ComIsMonth(month)) rtn=true;
          else rtn=false;
        }
        if(rtn){
           if(isSet) obj.value=year + ch + month;
        } else {
           if(isN && str == '') {
              rtn=true;
            } else {              
              ComShowMessage(ComGetMsg('COM12180'));
              if(isSet) obj.value="";
              obj.focus();
           }
        }
        return rtn;
    }
    /**
     * 1을 001, 100로 세팅할 때 사용
     *     ex) onBlur="fillSpace(this, 2, '0', 'left');"
     *
     * str : 원본 문자열
     * spaceNum : 리턴 받고자하는 문자열의 총길이
     * spaceStr : 채울 값
     * flag :  왼쪽(left) 오른쪽(right)
     */
    function fillSpace(obj, spaceNum, spaceStr, flag){
        var i=0;
        var val=obj.value;
        var fillString="";
        if(val.length>0){
            for(i=0;i<(spaceNum - val.length); i++){
                fillString=fillString + spaceStr;
            }
        }
        if(flag == "left"){
            obj.value=fillString + val;
        } else if(flag == "right"){
            obj.value=val + fillString;
        }
    }
    /**
     * from, to날짜의 유효성 체크
     * obj1:앞날짜
     * obj2:뒤날짜
     */
     function isLateDate(obj1, obj2){
       str1=obj1.value.replace(/\/|\-|\./g,"");
       str2=obj2.value.replace(/\/|\-|\./g,"");
       if(ComParseInt(str1)>ComParseInt(str2)){
         ComShowMessage(ComGetMsg('COM12133', "To Date", "From Date", "many more"));
         obj2.value="";
         obj2.focus();
       }
     }
    /**
     * 앞뒤를 비교하여 뒤가 크면 true<br>단순히 true, false만 리턴
     * val1:앞날짜
     * val2:뒤날짜
     */
     function isLateDate2(val1, val2){
       rtn=true;
       str1=val1.replace(/\/|\-|\./g,"");
       str2=val2.value.replace(/\/|\-|\./g,"");
       if(ComParseInt(str1)>ComParseInt(str2)){
         rtn=false;
       }
       return rtn;
     }
  
  
  /**
   * 1을 001, 100로 세팅할 때 사용
   *     ex) fillZero('sss',2,'0','left');
   *
   * str : 원본 문자열
   * spaceNum : 리턴 받고자하는 문자열의 총길이
   * spaceStr : 채울 값
   * flag :  왼쪽(left) 오른쪽(right)
   *
   * Author : kevin.kim (2006.12.18)
   */
  function fillZero(str, spaceNum, spaceStr, flag){
    var i=0;
    var ret="";
    var fillString="";
    if(str.length>0){
      for(i=0;i<(spaceNum - str.length); i++){
        fillString=fillString + spaceStr;
      }
    }
    if(flag == "left"){
      ret=fillString + str;
    } else if(flag == "right"){
      ret=str + fillString;
    }
    return ret;
  }
 
 
    /**
     * 입력된 문자열이 년 Format YYYY이 맞는지를 확인
     *
     * @param obj        object
     * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
     * @param isN        널스트링 허용여부
     * @return true, false
     */
    function isValidYear(obj, isSet, isN) {
    	var rtn=true;
    	var str=obj.value;
    	if(!(str.length == 4)) { rtn=false; }
    	if (!(ComParseInt(str) >= 1900 && ComParseInt(str) <= 9999)) {
    		rtn=false;
    	}
    	if(isN && str == "") { rtn=true; }
    	if(rtn == false) {
    		ComShowMessage(ComGetMsg('COA10009','Year','YYYY')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
    		if(isSet) { obj.value=""; }
    		obj.focus();
    	}
    	return rtn;
    }
    /**
     * 입력된 문자열이 주 Format WW이 맞는지를 확인
     *
     * @param obj        object
     * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
     * @param isN        널스트링 허용여부
     * @return true, false
     */
    function isValidWeek(obj, isSet, isN) {
    	var rtn=true;
    	var str=obj.value;
    	str=fillZero(str,2,'0','left');
    	//if (!isNumSlash(obj) && !isNumPeriod(obj) && !isNumDash(obj)) { rtn = false; }
    	if (!(ComParseInt(str) >= 0 && ComParseInt(str) <= 53)) {
    		rtn=false;
    	}
    	if(isN && str == "") { rtn=true; }
    	if(rtn == false) {
    		ComShowMessage(ComGetMsg('COA10009','Week','WW')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
    		if(isSet) { obj.value=""; }
    		obj.focus();
    	}
    	return rtn;
    }
    /**
     * 입력된 문자열이 월 Format MM이 맞는지를 확인
     *
     * @param obj        object
     * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
     * @param isN        널스트링 허용여부
     * @return true, false
     */
    function isValidMonth(obj, isSet, isN) {
    	var rtn=true;
    	var str=obj.value;
    	str=fillZero(str,2,'0','left');
    	//if (!isNumSlash(obj) && !isNumPeriod(obj) && !isNumDash(obj)) { rtn = false; }
    	if (!(ComParseInt(str) >= 1 && ComParseInt(str) <= 12)) {
    		rtn=false;
    	}
    	if (!ComIsMonth(str)) {
    		rtn=false;
    	}
    	if(isN && str == "") { rtn=true; }
    	if(rtn == false) {
    		ComShowMessage(ComGetMsg('COA10009','Month','MM')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
    		if(isSet) { obj.value=""; }
    		obj.focus();
    	}
    	return rtn;
    }
    /**
     * sheet의 height를 계산한다.
     * (2007.2.14 - Kevin.KIM)
     *
     * @param sheetObj : sheet
     * @param retType : 추출방법 (MAX:최대값,MIN:최소값)
     * @param scrollCnt : 스크롤 여부 (0:없음, 1:있음) --> 단, MAX만 적용
     * @return heightCnt
     */
    function getSheetHeightCnt(sheetObj, retType, scrollCnt) {
		var basCnt=20;  //기본 height
		var maxCnt=100; //허용가능한 최대 height
		var heightCnt=0;
    	with (sheetObj) {
			if (retType.toUpperCase() == "MAX") {
        	    heightCnt=maxCnt;
           	    if (RowCount()> 0) {
       	            heightCnt=HeaderRows()+ LastRow()+ scrollCnt + 1; //예비 +1
        	    } else { //조회된 데이터가 없으면
        	        heightCnt=basCnt;
        	    }
			} if (retType.toUpperCase() == "MIN") {
       	        heightCnt=basCnt;
			}
    	}
        if (heightCnt > maxCnt) {
            heightCnt=maxCnt;
        }
        if (heightCnt < basCnt) {
            heightCnt=basCnt;
        }
    	return heightCnt;
    }
    /**
     * Excel Dowload시 사용
     * 사용 : var rtn = selectDownExcelMethod(sheetObj);
     * (2007.4.13 - Kevin.KIM)
     *
     * @param sheetObj : sheet
     * @return String
     *         NODATA = Not Found Data
     *         AY = Down2Excel(0, false, false, true);
     *         DY = Down2Excel(-1, false, false, true);
     *         AN = SpeedDown2Excel(0, false, false);
     *         DN = SpeedDown2Excel(-1, false, false);
     *         CANCEL = Cancel + Window Close
     */
    function selectDownExcelMethod(sheetObj, sheetIdx){
    	if(sheetObj.RowCount()== 0){
    		ComShowCodeMessage("COM132501");
    		return "NODATA";
    	}

    	if (sheetIdx==undefined || sheetIdx==null) {
    		sheetIdx="";
    	}
    	
    	var sFeature="";
    	sFeature=sFeature + "dialogHeight:230px;"
    	sFeature=sFeature + "dialogWidth:352px;"
    	sFeature=sFeature + "center:yes;"
    	sFeature=sFeature + "resizable:no;"
    	sFeature=sFeature + "scroll:no;"
    	sFeature=sFeature + "status:no;"
    	setTimeout( function () {
            ComOpenPopup("ESM_COA_3002.do?sheetidx="+sheetIdx, 350, 200, "callBackExcelDown","0,0", true);
         } , 100);
    }    
    
    function callBackExcelDown(execType){
   	 $(document).find(".opus_design_grid").addClass("excelCellColor");
   	callBackExcelMethod(execType);
      setTimeout(function(){
          $(document).find(".opus_design_grid").removeClass("excelCellColor");
      },10);
   }
   
    /******************************************************************************************************/
    /**                                        Sheet 관련 function                                        */
    /******************************************************************************************************/
    /**
     * getSearchXml()메소드를 이용하여 가져온 xml string을 sheet에 loading 하지 않고
     * etcData의 내용을 뽑아 오는 함수
     *
     * @param fName ETC의  key필드명
     * @param xml string
     * @param index
     */
    function searchEtcData(fName, xmlStr, index) {
    	var ind=0;
    	if (index !="" && index != undefined) ind=index;
    	if(xmlStr == null || xmlStr == "") return;
        var xmlDoc = ComGetXmlDoc(xmlStr);
        if (xmlDoc == null) return;
        var xmlRoot = xmlDoc.documentElement;
        if (xmlRoot == null)  return;
        var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(parseInt(ind));
        if(etcDataNode == null) return;
        var etcNodes=etcDataNode.childNodes;
        if(etcDataNode == null) return;
        var clength=etcNodes.length;
        var rtnValue="";
		for ( var i = 0; i < etcNodes.length; i++) {
			if (etcNodes[i].nodeType != 1)
				continue;
			if (etcNodes[i].attributes[0].nodeValue == fName) {
				if (etcNodes[i].firstChild == null) {
					return "";
				} else {
					if(fName == "Exception"){
						if(etcNodes[i].firstChild.nodeValue =="" || etcNodes[i].firstChild.nodeValue == " "){
							return etcNodes[i].firstChild.wholeText;
						}
					}
					return etcNodes[i].firstChild.nodeValue;
				}
			}
		}
        return rtnValue;
    }
     
   
    /**
     * HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 키보드로 입력되는 값을 숫자만으로 제어한다. <br>
     * 예를 들어 다음과 같이 사용한다.<br>
     *     &lt;input type="text" name="txtAmt" <font color="red">onKeyPress="ComKeyOnlyNumber(this)"</font>&gt; <br>
     * 인자로 사용되는 sSubChar 인자는 숫자이외에 부가적으로 입력할수 있는 문자를 여러개 연결하여 설정한다.<br>
     * <font color="red">주의!</font> style="ime-mode:disabled"은 반드시 설정해야 기능이 정확히 처리된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this)"&gt;
     *     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-")"&gt;
     *     &lt;input type="text" name="txtAmt" onKeyPress="ComKey(this, "-.,")"&gt;
     * </pre>
     * @param {object} obj      필수,대상 HTML태그(Object)
     * @param {string} sSubChar 선택,숫자이외의 부가 글자
     * @returns 없음 <br>
     * @see #ComKeyOnlyAlphabet
     */
    function CoaKeyOnlyNumber(obj,sSubChar){
        try {
	        var keyValue=ComGetEvent("keycode");
            //ComDebug('key  = '+keyValue);
            if((keyValue >= 48 && keyValue <= 57) //숫자
                    || keyValue == 8
                    || keyValue == 9
                    || keyValue == 37
                    || keyValue == 38
                    || keyValue == 39
                    || keyValue == 40
                    || keyValue == 46) {
                event.returnValue=true;
            } else if(sSubChar != undefined && sSubChar != null && sSubChar.constructor==String && sSubChar.length > 0) {
            	//SubChar가 여러개 설정된 경우 여러개 글자 모두 처리한다.
            	for(var i=0; i<sSubChar.length; i++) {
            		//ComDebug("sSubChar.charAt(" + i + ")=" + sSubChar.charAt(i));
            		if (keyValue == sSubChar.charCodeAt(i)) {
		                event.returnValue=true;
		                return;
            		}
            	}
                event.returnValue=false;
            } else {
                event.returnValue=false;
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
	/**
	* @param : 
	* sample	: get_NowYear();
	* @return 	: 현재 년도
	* 설명		: 현재 년도 가지고 오기
	**/
	function get_NowYear()
	{
		today=new Date()
		return 	""+today.getFullYear();
	}
	/**
	* @param : 
	* sample	: get_NowMonth();
	* @return 	: 현재 월
	* 설명		: 현재 월 가지고 오기
	**/
	function get_NowMonth()
	{
		today=new Date()
		month1=today.getMonth()+1;
		return 	month1.toString();
	}
    /******************************************************************************************************/
    /**  Cost_yrmon, Sls_yrmon 으로 인해 화면의 컨트롤응 공통화합                                             */
    /******************************************************************************************************/
// -- -----------------------------------------------------------------------------------------
// Period 관련 변경내역	
// -- -----------------------------------------------------------------------------------------
/**
 * Month/Week 에 따라서 화면에 컨트롤을 변경시켜준다.
 * SJH.20150106.MOD
 **/
function chkWM(param1, param2){
	if(param1 == 'W'){ 		
		document.all.div_week.style.display="inline";
		document.all.div_month.style.display="none";
		if(param2 == '2') {
			document.form.f_mon.disabled = true;
			document.form.f_fm_wk.disabled = false;
			document.form.f_to_wk.disabled = false;
		} else if(param2 == '3') {
			document.form.f_fm_mon.disabled = true;
			document.form.f_to_mon.disabled = true;
			document.form.f_wk.disabled = false;					
		} else {
			document.form.f_fm_mon.disabled = true;
			document.form.f_to_mon.disabled = true;
			document.form.f_fm_wk.disabled = false;
			document.form.f_to_wk.disabled = false;			
		}
		document.form.f_yearM.value = document.form.f_year.value;		//SJH.20150106.ADD
		document.form.f_year.value  = document.form.f_yearW.value;		//SJH.20150106.ADD
	} else { 		
	    document.all.div_week.style.display="none";
	    document.all.div_month.style.display="inline";
	    if(param2 == '2') {
	    	document.form.f_mon.disabled = false;
			document.form.f_fm_wk.disabled = true;
			document.form.f_to_wk.disabled = true;
	    } else if(param2 == '3') {	
			document.form.f_fm_mon.disabled = false;
			document.form.f_to_mon.disabled = false;
			document.form.f_wk.disabled = true;	    	
		} else {
			document.form.f_fm_mon.disabled = false;
			document.form.f_to_mon.disabled = false;
			document.form.f_fm_wk.disabled = true;
			document.form.f_to_wk.disabled = true;			
		}
	    document.form.f_yearW.value = document.form.f_year.value;		//SJH.20150106.ADD
		document.form.f_year.value  = document.form.f_yearM.value;		//SJH.20150106.ADD
 	}
}

/**
 * YYYY-MM/WW Month/Week 에 따라서 화면에 컨트롤을 변경시켜준다.
 * SJH.20150107.MOD, 20150113.MOD
 * param1 : M/W type (라디오 선택사항)
 * param2 : 디자인스타일 (라디오가 M만있느냐? W도 있느냐)
 * param3 : value
 **/
function chkYWM(param1, param2){	
	var formObj=document.form;
    var d=document.all;
    with(formObj){
    	d.div_month.style.display="inline";
    	if(param2 == "2")	{ 
    		d.div_week.style.display="none";	
    		d.f_yrtype[0].style.display="none"; 
    	} else	{ 
    		d.div_week.style.display="inline";	
    		d.f_yrtype[0].style.display="inline"; 
    	}
    	if(param1 == 'M'|| d.f_yrtype[0].checked){
    		if(param1!="") {
    			f_yearW.value=f_yearweek.value;
    			f_yearweek.value = f_yearM.value;		
    		}
    		document.getElementById("f_yearweek").setAttribute("dataformat","ym");
    		f_yearweek.value = ComGetMaskedValue(f_yearweek, "ym");
    	} else {
    		if(param1!="") {
    			f_yearM.value=f_yearweek.value;
    			f_yearweek.value = f_yearW.value;
    		}
    		document.getElementById("f_yearweek").setAttribute("dataformat","yw");
    		f_yearweek.value = ComGetMaskedValue(f_yearweek, "yw");
     	}
    	setPeriod(f_yearweek);    	
    }
}
/**
 * YYYY-MM : [Year-Month]
 * 위 항목을 화면에 디스플레이 함
 *
 * html 부분에 넣어 준다.
 * <script language="javascript">coaPeriod();</script>
 */
function coaPeriod(){
	document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
	document.write("\n <table class='search' border='0'> ");
	document.write("\n 	<tr> ");
	document.write("\n 		<th width='9%'>YYYY-MM</th> ");
	document.write("\n 		<td width='16%'> ");
	document.write("\n 			<input type='text' class='input1' name='f_yearmonth' style='width:70px;text-align:center;ime-mode:disabled' dataformat='ym'> ");
	document.write("\n 		</td> ");
	document.write("\n 		<td colspan='6'><div id='div_period'></div></td> ");
	document.write("\n 	</tr> ");
	document.write("\n </table> ");
}
	/**
	 * M : [Year, Month] Week : [Year, Month, Fm_week, To_week]
	 * 위 항목을 화면에 디스플레이 함
	 *
	 * html 부분에 넣어 준다.
	 * <script language="javascript">initPeriod();</script>
	 * initPeriod->coaPeriod1
	 * 
	 * SJH.20150106.ADD/MOD : 여기저기 꼬여있어서 타입을 나눌수밖에 없다.
	 */
	function coaPeriod1(sType, oType){ 	//style, office여부
		 document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
		 document.write("\n 	<input type='hidden' name='f_yearM' id='f_yearM'> ");
		 document.write("\n 	<input type='hidden' name='f_yearW' id='f_yearW'> ");
		 if(sType == "3")	
			 document.write("\n <input type='hidden' name='f_yearweek' id='f_yearweek'> ");
		 document.write("\n <table border='0'>");
		 document.write("\n 	<colgroup> ");
		 if(sType != "3") {
			 document.write("\n 		<col width='50px'  />");
			 document.write("\n 		<col width='160px' />");
			 document.write("\n 		<col width='30px'  />");
			 document.write("\n 		<col width='60px'  />");
			 document.write("\n 		<col width='150px' />");			 
		 } else {
			 document.write("\n 		<col width='30px'  />");
			 document.write("\n 		<col width='40px'  />");
			 document.write("\n 		<col width='90px' />");			 
		 }
		 document.write("\n 		<col width='*' />");
		 document.write("\n  	</colgroup>");
		 document.write("\n 	<tr> ");
		 if(sType != "3") {
			 document.write("\n 	<th>W/M</th> ");
			 document.write("\n 	<td> ");
			 document.write("\n 		<div id='div_wm' style='display:inline;border:solid 0;'> ");
			 if(oType == "O") {
				 document.write("\n 	<input type='radio' value='W' name='f_chkprd' id='f_chkprd' class='trans' onClick=\"chkWM('W',"+sType+"); setPeriod(this); changeCostYrmon(this.value);\" checked><label for='rdo1'>Week</label> ");
			     document.write("\n 	<input type='radio' value='M' name='f_chkprd' id='f_chkprd' class='trans' onClick=\"chkWM('M',"+sType+"); setPeriod(this); changeCostYrmon(this.value);\"><label for='rdo2'>Month</label> ");
			 } else { 
				 document.write("\n 	<input type='radio' value='W' name='f_chkprd' id='f_chkprd' class='trans' onClick=\"chkWM('W',"+sType+"); setPeriod(this);\" checked><label for='rdo1'>Week</label>");
				 document.write("\n 	<input type='radio' value='M' name='f_chkprd' id='f_chkprd' class='trans' onClick=\"chkWM('M',"+sType+"); setPeriod(this);\"><label for='rdo2'>Month</label>");
			 }
			 document.write("\n 		</div> ");
			 document.write("\n 	</td> ");
		 }
		 document.write("\n 		<td>Year</td> ");
		 if(oType == "O") {
			 document.write("\n 	<td><input type='text' style='width:40px;text-align:center;ime-mode:disabled;' class='input1' name='f_year' id='f_year' maxlength='4' dataformat='yyyy' onChange='setPeriod(this); changeCostYrmon(this.value);' onKeyDown='ComKeyEnter();'></td> "); 
		 } else {
			 document.write("\n 	<td><input type='text' style='width:40px;text-align:center;ime-mode:disabled;' class='input1' name='f_year' id='f_year' maxlength='4' dataformat='yyyy' onChange='setPeriod(this);' onKeyDown='ComKeyEnter();'></td> ");
		 }
		 document.write("\n 		<td> ");
		 document.write("\n 		    <div id='div_month' style='display:none;border:solid 0;width:150px;'> ");
		 document.write("\n 		    <label>Month</label>");
		 //TYPE 2인경우
		 if(sType == "2") {
			 if(oType == "O") {
				 document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_mon' id='f_mon' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this); changeCostYrmon(this.value);}\" disabled>");
			 } else {
				 document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_mon' id='f_mon' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\" disabled>");
			 }
		 } else {
		     if(oType == "O") {
		    	 document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_fm_mon' id='f_fm_mon' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this); changeCostYrmon(this.value);}\" disabled>~");
		         document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_to_mon' id='f_to_mon' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this); changeCostYrmon(this.value);}\" disabled>");
		     } else {
		    	 document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_fm_mon' id='f_fm_mon' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\" disabled>~");
		         document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_to_mon' id='f_to_mon' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\" disabled>");
		     }
		 }
		 document.write("\n 			</div> ");
		 document.write("\n 		    <div id='div_week' style='display:inline;border:solid 0;width:150px;'> ");
		 document.write("\n 		    <label>Week</label>");
		//TYPE 3인경우
		 if(sType == "3") {			 
			 if(oType == "O") {
				 document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_wk' id='f_wk' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this); changeCostYrmon(this.value);}\" >");			     
			 } else {
				 document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_wk' id='f_wk' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\" >");			     
			 } 	
		 } else {
			 if(oType == "O") {
				 document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_fm_wk' id='f_fm_wk' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this); changeCostYrmon(this.value);}\" >~");
			     document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_to_wk' id='f_to_wk' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this); changeCostYrmon(this.value);}\">");
			 } else {
				 document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_fm_wk' id='f_fm_wk' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\" >~");
			     document.write("\n 		<input type='text' style='width:30px;text-align:center;ime-mode:disabled' class='input1' name='f_to_wk' id='f_to_wk' maxlength='2' dataformat='num' onKeyDown='ComKeyEnter();' onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\">");
			 } 			 
		 }
		 document.write("\n 			</div> ");
		 document.write("\n 		</td> ");
		 document.write("\n 		<td><div id='div_period' style=\"width:200px\"></div></td> ");
		 document.write("\n 	</tr> ");
		 document.write("\n </table> ");
		 document.write("\n<!--  -------------------------------------------------------------------------------------------- --> ");
	}
	
	/**
	 * YYYY-MM, YYYY-WW : [Year-Month/Week]
	 * 위 항목을 화면에 디스플레이 함
	 *
	 * html 부분에 넣어 준다.
	 * <script language="javascript">coaPeriod2();</script>
	 * SJH.20150107.ADD
	 */
	function coaPeriod2(sType){
		 document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
		 document.write("\n 	<input type='hidden' name='f_yearM' id='f_yearM'> ");
		 document.write("\n 	<input type='hidden' name='f_yearW' id='f_yearW'> ");
		 document.write("\n <table border='0'>");
		 document.write("\n 	<colgroup> ");
		 if(sType == "2") {
			 document.write("\n 	<col width='85px' />");	 
		 } else {
			 document.write("\n 	<col width='200px' />");	
		 }
		 document.write("\n 		<col width='75px' />");			 
		 document.write("\n 		<col width='*'    />");
		 document.write("\n  	</colgroup>");
		 document.write("\n 	<tr> ");
		 document.write("\n 		<td id='td_p' name='td_p'>");
		 document.write("\n 		<div id='div_month' style='display:inline;border:solid 0;'> ");
		 document.write("\n 		    <label><b>YYYY-MM</b></label>");
	 	 document.write("\n 			<input type='radio' value='M' name='f_yrtype' id='f_yrtype' class='trans' onClick=\"chkYWM('M',"+sType+"); \"checked>");
	 	 document.write("\n 		</div> ");
	 	 document.write("\n 		<div id='div_week' style='display:inline;border:solid 0;'> ");
	 	 document.write("\n 			<label><b>YYYY-WW</b></label>");
	 	 document.write("\n 			<input type='radio' value='W' name='f_yrtype' id='f_yrtype' class='trans' onClick=\"chkYWM('W',"+sType+"); \">");
	 	 document.write("\n 		</div> ");
	 	 document.write("\n 		</td> "); 
		 document.write("\n 		<td> ");
		 document.write("\n 			<input type='text' class='input1' style='width:60px; text-align:center' name='f_yearweek' id='f_yearweek' maxlength='6' dataformat='ym' onChange=\"chkYWM('',"+sType+"); \">");
		 document.write("\n 		</td> ");
		 document.write("\n 		<td><div id='div_period' style=\"width:200px\"></div></td> ");
		 document.write("\n 	</tr> ");
		 document.write("\n </table> ");
		 document.write("\n<!--  -------------------------------------------------------------------------------------------- --> ");
	}	

	 /**
	  * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
	  * @param{form} str  Form 객체  
	  * @param{exElmNms} str   exElmNms값들은 form elemente name으로 구성하지 않을 값들이다. 
	  */
	  function coaFormQueryString(form, exElmNms, isUse) {
	      if (typeof form != "object" ) {
	          //Msg : Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag. <== 모듈별 Error Msg 등록하여 사용
	    	  alert("Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
	          //showMsg("");
	          return "";
	      }
	      var name=new Array(form.elements.length);
	      var value=new Array(form.elements.length);
	      var j=0;
	      var plain_text="";
	      //사용가능한 컨트롤을 배열로 생성한다.
	      len=form.elements.length;
	      for (i=0; i < len; i++) {
	        //클래스 아이디로 제품을 구분함-아래는 HTMl제품
	        switch (form.elements[i].type) {
	          case "button":
	          case "reset":
	          case "submit":
	                                break;
	          case "radio":
	          case "checkbox":
	              if (!checkExcludeElements(form.elements[i].name, exElmNms, isUse) && form.elements[i].checked == true) {
	            	  name[j]=form.elements[i].name;
	                  value[j]=form.elements[i].value;
                      j++;                      
                  }
	          break;
	          case "select-one":
	              var ind=form.elements[i].selectedIndex;
	              if(!checkExcludeElements(form.elements[i].name, exElmNms, isUse) && ind >= 0 && form.elements[i].options[ind].value != '') {
	            	  name[j]=form.elements[i].name;
	                  value[j]=form.elements[i].options[ind].value;
	                  j++;
	              } 
	          break;
	          case "select-multiple":
	              var llen=form.elements[i].length;
	              var increased=0;
	              for( k=0; k < llen; k++) {
	                  if (!checkExcludeElements(form.elements[i].name, exElmNms, isUse) && form.elements[i].options[k].selected && form.elements[i].options[k].value != '') {
	                	  name[j]=form.elements[i].name;
	                      value[j]=form.elements[i].options[k].value;
	                      j++;
	                      increased++;
	                  }
	              }
	                      break;
	          default:
	        	
	               if(form.elements[i].value.length >0 ) {
	            	   if(exElmNms!=null && exElmNms!='' && exElmNms!=undefined){
	            		   if(!checkExcludeElements(form.elements[i].name, exElmNms, isUse)){
	            			   if(form.elements[i].parentNode.className == "MAINCTL_DIV"){
		                    	   if (form.elements[i].value == "All"){
		                    		   name[j]=form.elements[i].name;
			                   		   value[j]="";
		                    	   } else{
		                    		   name[j]=form.elements[i].name;
		                    		   value[j]=form.elements[i].value;
		                    	   }
		                    	} else {
	                    		   name[j]=form.elements[i].name;
	                    		   value[j]=form.elements[i].value;
	                    	   }
	                         j++;
	                       }
	            	   } else {
	                       if(form.elements[i].parentNode.className == "MAINCTL_DIV"){
	                    	   if (form.elements[i].value == "All"){
	                    		   name[j]=form.elements[i].name;
		                   		   value[j]="";
	                    	   } else {
	                    		   name[j]=form.elements[i].name;
	                    		   value[j]=form.elements[i].value;
	                    	   }
	                    	} else {
                    		   name[j]=form.elements[i].name;
                    		   value[j]=form.elements[i].value;
                    	   }
	                       j++;
	                   }
	               }
	        	}
	        }
          for (i=0; i < j; i++) {
              if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
          }
          
	    //마지막에 &를 없애기 위함
	    if (plain_text != "")
	      plain_text=plain_text.substr(0, plain_text.length -1);
	      return plain_text;
	}
    function checkExcludeElements(elmNm, exElmNms, isUse){
	    var arr_exElmNms='';
	    var rstTF=false;
	    try{
	        if(exElmNms != null && exElmNms != '' && exElmNms != undefined){	
	            arr_exElmNms=exElmNms.split('|');
	            for(var i=0; i < arr_exElmNms.length; i++){
	                if(arr_exElmNms[i] != "") {
	                    if(elmNm==null || elmNm=='' || elmNm==undefined){
	                        rstTF=true;
	                        break;
	                    }else if(elmNm == arr_exElmNms[i]){
	                    	if( isUse == true)
	                    		rstTF=false;
	                    	else 
	                    		rstTF=true;
	                        break;
	                    }
	                    else {
	                    	if( isUse == true){
		                        rstTF=true;
	                    	}
	                    }
	                }
	            }
	        }
	    }catch(e){
	        rstTF=true;
	    }
	    return rstTF;
	 }
    /**
     * IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
     * <b>Example :</b>
     * <pre>
     *     ComCoaSetIBCombo(sheetObj,sXml,"trd_cd",false,1);
     * </pre>
     *
     * @param {string} sheetObj 필수
     * @param {string} sXml 필수, Combo에 채울 데이터(IBSheet를 통해 받아온 xml 문자열.)
     * @param {string} title 필수, Combo field명(IBSheet SaveName).
     * @param {string} iBlank 선택, Combo의 첫번째로우를 블랭크로 설정
     * @param {string} sCol 선택, 멀티콤보일경우 콤보를 선택하면 콤보에 보여질 순서설정(0:코드 or 1:description)
     * @param {string} iRow 선택, 생성할 선택 Row 
     * @param {string} dCode 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Code값
     * @param {string} dText 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Text값
	 * @param {string} bFlag multicombo 용 XML 파일을 Sheet 내에서 Combo 형태로 사용할 경우, Text 에 Code+"\t"+Text 형태로 만들어 사용할 수 있게 해 줌	      
     * (코드|디스크립션 형태가 아닐 경우는 0으로 설정해야함)
     * @return 없음
     * @version 2010.08.01
     * 			2015.02.25
     */
    function ComCoaSetIBCombo(sheetObj, sXml, title, iBlank, sCol,iRow, dCode, dText, bFlag, cdFlag){
        var showCol=0;
        var cdText="";        
        if (ComGetTotalRows(sXml) == "0") return;
        if (bFlag == undefined || bFlag == ""){
            bFlag=false;
        }
        if (cdFlag == undefined || cdFlag == ""){
        	cdFlag=false;
        }        
        if (sCol != undefined && sCol !=""){
            showCol=sCol;
        }
        if (iBlank == undefined || iBlank == ""){
            iBlank=false;
        }
        if (iRow == undefined || iBlank == ""){
        	iRow=0;
        }        
        if(cdFlag == true) cdText = "code";
        else cdText = "name";
        var arrData=ComXml2ComboString(sXml, "code", cdText);
        if (bFlag == true && arrData != null){
            var arrCode=arrData[0].split("|");
            var arrName=arrData[1].split("|");
            var conData="";
            for(i=0; i < arrName.length;i++){
                if(i==0){
                    arrName[i]=arrCode[i]+"\t"+arrName[i];
                }else{
                    arrName[i]="|"+arrCode[i]+"\t"+arrName[i];
                }
                conData=conData.concat(arrName[i]);
            }
            arrData[1]=conData;
        }
        if(iBlank){
            arrData[0]=" |" + arrData[0];
            arrData[1]=" |" + arrData[1];
        }
        if (arrData != null){
        	if (iRow == 0){
        		sheetObj.SetColProperty(title, {ComboText:arrData[1], ComboCode:arrData[0]} );
        	}else{
        		sheetObj.CellComboItem(iRow,title, {ComboText:arrData[1], ComboCode:arrData[0]} );
        	}
        }
    }
	/**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function ComCoaSetPeriod(obj){
        var formObj=document.form;
        if(obj == null){
            return;
        }
        if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            if(obj.name == "f_to_mon" ){
                formObj.f_fm_mon.value="";
            } else if (obj.name == "f_to_wk"){
                formObj.f_fm_wk.value="";
            }
            return false;
        } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if(obj.name == "f_fm_mon") return false;
            if(obj.name == "f_fm_wk") return false;
        }        
        if(chkValidSearch()){
            var sheetObj=sheetObjects[0];
            formObj.f_cmd.value=SEARCH02; 
            var sValue=ComSearchEtcData(sheetObj, "initPeriodGS.do", FormQueryString(formObj), "period");
			if (sValue!=undefined)
				$("#div_period").html("("+sValue +")");
        }
    } 
    /**
     * month, week가 변경되었을때 Period를 변경한다.
     * YYYY-MM YYYY-WW 타입
     */
    function ComCoaSetPeriod2(obj){
        var formObj=document.form;
        if (null==obj) return;
        if (""==obj.value) {  //to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            if ("f_to_mon"==obj.name) {
                ComSetObjValue(formObj.f_fm_mon,"");
            } else if ("f_to_wk"==obj.name) {
                ComSetObjValue(formObj.f_fm_wk,"");
            }
            return false;
        } else {  // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if ("f_fm_mon"==obj.name) return false;
            if ("f_fm_wk"==obj.name) return false;
        }
        var sheetObj=sheetObjects[0];
    	formObj.f_cmd.value=SEARCH03;    	
 		var sValue=ComSearchEtcData(sheetObj,"initPeriodGS.do", FormQueryString(formObj), "period"); 		
		if (sValue!=undefined) {
			$("#div_period").html(sValue);
		}
    }
	/**
	 * year-month가 변경되었을때 Period를 변경한다.
	 */
	function ComCoaSetPeriod3(obj){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        if (null==obj) return;
    	formObj.f_cmd.value=SEARCH04;
 		var sValue=ComSearchEtcData(sheetObj,"initPeriodGS.do", FormQueryString(formObj), "period");
		if (sValue!=undefined) {
			$("#div_period").html(sValue);
		}
	}
	 /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function ComCoaSetPeriod4(obj){
        var formObj=document.form;
        if(obj == null){
            return;
        }
        if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            if (obj.name == "f_to_wk"){
                formObj.f_fm_wk.value="";
            }
            return false;
        } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if(obj.name == "f_fm_wk") return false;
        }
        if(chkValidSearch()){
            var sheetObj=sheetObjects[0];
        	formObj.f_cmd.value=SEARCH05;
     		var sValue=ComSearchEtcData(sheetObj,"initPeriodGS.do", FormQueryString(formObj), "period");
    		if (sValue!=undefined) {
				$("#div_period").html("("+sValue +")");
    		}
        }
    } 
     /**
 	 * year-week가 변경되었을때 Period를 변경한다.
 	 */
 	function ComCoaSetPeriod5(obj){
        var formObj=document.form;
        if(obj == null){
            return;
        }
        if(obj.value == ""){      
            return false;
        } else {
        	f_yearweek.value=f_year.value+f_wk.value; 
        }
        if(chkValidSearch()){
            var sheetObj=sheetObjects[0];
            formObj.f_cmd.value=SEARCH06; 
            var sValue=ComSearchEtcData(sheetObj, "initPeriodGS.do", FormQueryString(formObj), "period");
			if (sValue!=undefined)
				$("#div_period").html(sValue);
        }
    }  	
 	/**
  	 * Location을 Check한다.
  	 */
  	function ComCoaCheckLocCd(f_type_cd, obj){
  		 var formObj=document.form;
  		 var sheetObj=sheetObjects[0];
  		 var param="f_cmd="+SEARCH07;
  		 param=param + "&f_type_cd="+f_type_cd+"&f_loc_cd="+ComGetObjValue(obj);
 		var rtnValue=ComSearchEtcData(sheetObj,"CommonUtilGS.do", param, "rtnValue");
		if (rtnValue!=undefined) {
  			isValidLocation(obj,rtnValue);
  		 }
  	}  
  	function ComCoaGetEtcData(xml, name){
  		if (ComGetEtcData(xml, name) == undefined){
  			return "";
  		}else{
  			return ComGetEtcData(xml, name);
  		}
  	}
    /**
     * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 Array형태로 변환한다. <br>
     * <b>Example :</b>
     *
     * <pre>
     * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
     * var arrData = ComCoaXml2Array(xmlStr, &quot;user_id|user_nm|status&quot;);
     *
     * 결과: 35X 3 크기의 결과 Array.
     * </pre>
     *
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열
     * @param {string} colList 필수, XML문자열에서 추출하고자하는 컬럼명(Savename). "|"로 연결한다.
     * @return array   [조회된row수 X 컬럼수] 크기의 string array.
     * @author 최성민
     * @version 2011.02.28
     */
    function ComCoaXml2Array(xmlStr, colList) {
        var rtnArr=new Array();
        if (xmlStr == null || xmlStr == "" || colList == null || colList == "") {
            return;
        }
        try {
            var xmlDoc = ComGetXmlDoc(xmlStr);
            if (xmlDoc == null) return;
            var xmlRoot = xmlDoc.documentElement;
            if (xmlRoot == null)  return;
            var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
            if (dataNode == null || dataNode.attributes.length < 2) {
                return;
            }
            var col=dataNode.getAttribute("COLORDER");
            var colArr=col.split("|");
            var sep=dataNode.getAttribute("COLSEPARATOR");
            var total=dataNode.getAttribute("TOTAL");
            var dataChildNodes=dataNode.childNodes;
            if (dataChildNodes == null) {
                return;
            }
            var colListArr=colList.split("|");
            var colListIdx=Array();
            for (var i=0; i < colListArr.length; i++) {
                for (var j=0; j < colArr.length; j++) {
                    if (colListArr[i] == colArr[j]) {
                        colListIdx[i]=j;
                        break;
                    }
                }
            }
            for (var i=0; i < dataChildNodes.length; i++) {
                if (dataChildNodes[i].nodeType != 1) {
                    continue;
                }
                var arrData=null;
                if (sep == null || sep == "") {
                    arrData=new Array();
                    var trChildNodes=dataChildNodes[i].childNodes;
                    for (var j=0; j < trChildNodes.length; j++) {
                        if (trChildNodes[j].nodeType != 1) {
                            continue;
                        }
                        arrData.push(trChildNodes[j].firstChild.nodeValue);
                    }
                } else {
                    arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
                }
                var subDataArr=new Array();
                for (var j=0; j < colListIdx.length; j++) {
                    subDataArr[j]=arrData[colListIdx[j]];
                }
                rtnArr[i]=(subDataArr);
            }
        } catch (err) {
            ComFuncErrMsg(err.message);
        }
        return rtnArr;
    }
    
    //SJH.20141106.ADD
    function getIbComboObjValue(obj){
        if (obj.GetSelectCode()== "All" ){
            return "";
        }
        return obj.GetSelectCode();
    } 
    
    /**
     * sheet의 height(zoom-in/out)
     * SJH.20141230.ADD : Zoom in out 공통
     */
    function getToggleSheetHeight(sheetObj, sheetHeight, divZoomInObj, divZoomOutObj, divInDisp, divOutDisp, optSz) {
		if ( sheetObj.RowCount() < 1 ) return;
		if(optSz=="0") sheetObj.SetSheetHeight( sheetHeight );
		else resizeSheet();
		divZoomInObj.style.display=divInDisp;
		divZoomOutObj.style.display=divOutDisp;					   
        if (parent && parent.syncHeight) {
            parent.syncHeight();
        }  
    }
    
    /**
     * Check mandatory input when searching
     * SJH.20150106.ADD : coaperiod1에 관련 validation check
     */
    function chkValidSearch(){
        var formObj=document.form;
        var d=document;
        with(formObj){   
                if(f_year.value == ""){
                    ComShowMessage(ComGetMsg("COM12114","Year",""));
                    f_year.focus();
                    return false;
                }
                if(!isValidYear(f_year,false,true)) return false;
                
                if(d.getElementById("f_chkprd") && f_chkprd[0].checked && d.getElementById("f_to_wk") && f_to_wk.value == "") {
                    ComShowMessage(ComGetMsg("COM12114", "week", ""));
                    f_to_wk.focus();
                    return false;                	
                }
                if(d.getElementById("f_chkprd") && f_chkprd[0].checked && d.getElementById("f_fm_wk") && f_fm_wk.value == "") {
                    ComShowMessage(ComGetMsg("COM12114", "week", ""));
                    f_fm_wk.focus();
                    return false;                	
                }
                if(d.getElementById("f_chkprd") && f_chkprd[0].checked && d.getElementById("f_to_wk") &&  ComParseInt(f_fm_wk.value) > ComParseInt(f_to_wk.value)) {
                    ComShowMessage(ComGetMsg("COA10011","Week","From","To"));
                    f_to_wk.focus();
                    return false;              	
                }
                if (!d.getElementById("f_chkprd") && d.getElementById("f_wk") && f_wk.value == ""){
                    ComShowMessage(ComGetMsg("COM12114", "week", ""));
                    f_wk.focus();
                    return false;
                }
                
                if(d.getElementById("f_chkprd") && f_chkprd[0].checked && d.getElementById("f_fm_wk") && !isValidWeek(f_fm_wk,false,true)) return false;
                if(d.getElementById("f_chkprd") && f_chkprd[0].checked && d.getElementById("f_to_wk") && !isValidWeek(f_to_wk,false,true)) return false;
                if(!d.getElementById("f_chkprd") && d.getElementById("f_wk") && !isValidWeek(f_wk,false,true)) return false;
                
                if (d.getElementById("f_chkprd") && !f_chkprd[0].checked && d.getElementById("f_to_mon") && f_to_mon.value == ""){
                    ComShowMessage(ComGetMsg("COM12114", "Month", ""))
                    f_to_mon.focus();
                    return false;
                }
                if (d.getElementById("f_chkprd") && !f_chkprd[0].checked && d.getElementById("f_fm_mon") && f_fm_mon.value == ""){
                    ComShowMessage(ComGetMsg("COM12114", "Month", ""))
                    f_fm_mon.focus();
                    return false;
                }
                if(d.getElementById("f_chkprd") && !f_chkprd[0].checked && d.getElementById("f_to_mon") && ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
                	ComShowMessage(ComGetMsg("COA10011","Month","From","To"));
                	f_to_mon.focus();
                    return false;          	
                } 
                if (d.getElementById("f_chkprd") && !f_chkprd[0].checked && d.getElementById("f_mon") && f_mon.value == ""){
                    ComShowMessage(ComGetMsg("COM12114", "Month", ""))
                    f_mon.focus();
                    return false;
                }                
                if(d.getElementById("f_chkprd") && !f_chkprd[0].checked && d.getElementById("f_fm_mon") && !isValidMonth(f_fm_mon,false,true)) return false;
                if(d.getElementById("f_chkprd") && !f_chkprd[0].checked && d.getElementById("f_to_mon") && !isValidMonth(f_to_mon,false,true)) return false;  
                if(d.getElementById("f_chkprd") && !f_chkprd[0].checked && d.getElementById("f_mon") && !isValidMonth(f_mon,false,true)) return false; 
            }        
        	
        	if(typeof(chkValidSearchIndv)=='function') {
        		if(!chkValidSearchIndv()) return false;
        	}
        	
        return true;
    }
    
    /**
     * Check mandatory input when searching
     * SJH.20150107.ADD : coaperiod1에 관련 validation check
     */
    function chkValidSearch2(){
    	var formObj = document.form;
    	with(formObj){
            if(f_yearweek.value == "") {
                if(f_yrtype[0].checked){
                    // [COM12114] : Check for the fom YYYY-MM
                    ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                    f_yearweek.focus();
                    return false;
                }
                else{
                    // [COM12114] : Check for the fom YYYY-WW
                    ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                    f_yearweek.focus();
                    return false;
                }
            }
            if(f_yearweek.value.replace("-","").length != 6) {
                if(f_yrtype[0].checked){
                    // [COM12114] : Check for the fom YYYY-MM
                    ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                    f_yearweek.focus();
                    return false;
                }
                else{
                    // [COM12114] : Check for the fom YYYY-WW
                    ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                    f_yearweek.focus();
                    return false;
                }
            }      
            if(f_yrtype[0].checked == true){    
            	if (!isValidYYYYMM(document.form.f_yearweek)) return false;
            }else{    
            	if (!isValidYYYYWW(document.form.f_yearweek)) return false;
            }
        }
        return true;
    }
    
    /**
     * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
     * IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
     * Return되는 배열의 0번째는 Code문자열, 1번째는 Text문자열이 담겨있다. <b>Example :</b>
     * 
     * <pre>
     * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
     * var arrData = ComXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
     * 
     * </pre>
     * 
     * @param {string}
     *            xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
     * @param {string}
     *            codeCol 필수, Combo의 Code컬럼명.
     * @param {string}
     *            textCol 필수, Combo의 Text컬럼명.
     * @return array Code연결 문자열과 Text연결 문자열이 담긴 배열.
     * @author SJH
     * @version 2015.02.05
     */
    function CoaXml2ComboString(xmlStr, codeCol, textCol, selStr) {
    	var rtnArr = new Array();
    	var rtnSel = selStr.split(",");

    	if (xmlStr == null || xmlStr == "") {
    		return;
    	}
    	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
    		return;
    	}

    	try {
    		var xmlDoc = ComGetXmlDoc(xmlStr);
    		if (xmlDoc == null) return;

    		var xmlRoot = xmlDoc.documentElement;
    		
    		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
    		if (dataNode == null || dataNode.attributes.length < 3) return;

    		var col = dataNode.getAttribute("COLORDER");
    		var colArr = col.split("|");
    		var sep = dataNode.getAttribute("COLSEPARATOR");
    		var total = dataNode.getAttribute("TOTAL");

    		var dataChildNodes = dataNode.childNodes;
    		if (dataChildNodes == null) return;

    		var colListIdx = Array();
    		for ( var i = 0; i < colArr.length; i++) {
    			if (colArr[i] == codeCol) {
    				colListIdx[0] = i;
    			}
    			if (colArr[i] == textCol) {
    				colListIdx[1] = i;
    			}
    		}

    		var sCode = "";
    		var sText = "";
    		for ( var i = 0; i < dataChildNodes.length; i++) {
    			if (dataChildNodes[i].nodeType != 1) continue;

    			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
    			
    			if(rtnSel.length > 0) {
        			for ( var z = 0; z < rtnSel.length; z++) {
        				if(arrData[colListIdx[0]]==rtnSel[z]) {
        					sCode += arrData[colListIdx[0]]+"|";
        					sText += arrData[colListIdx[1]]+"|";
        				}
        			}    				
    			} else {
    				sCode += arrData[colListIdx[0]];
					sText += arrData[colListIdx[1]];
    			}    			
    		}

    		// mig-IBSheet7은 마지막에 "|"가 있을 경우 문제가 발생할 수 있다.
    		if (sCode.length > 0 && sCode.charAt(sCode.length - 1) == '|')
    			sCode = sCode.substring(sCode, sCode.length - 1);
    		if (sText.length > 0 && sText.charAt(sText.length - 1) == '|')
    			sText = sText.substring(sText, sText.length - 1);
    		
    		rtnArr.push(sCode);
    		rtnArr.push(sText);
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}

    	return rtnArr;
    }
    
    
  //20150616.ADD
    /**
     * IBSheet에서 주어진 조건에 맞는 행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
     * saveColName 파라미터를 이용하여 원하는 컬럼을 지정할수 있고, <br>
     * sCol, sValue 파라미터를 이용하여 원하는 행의 조건을 줄수 있다.(필터링) <br>
     * saveColName의 값이 없으면 전체 컬럼을 대상으로 진행되고, <br>
     * sCol, sValue 값이 없으면 전체 행을 대상으로 진행된다. <br>
     * Sheet의 전체 데이터에 대해 스캔이 이루어지므로, 데이터양이 너무 많을 경우 속도가 저하될수 있음에 유의한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sXml = ComPriSheet2Xml(sheetObj);
     *     sXml = ComPriSheet2Xml(sheetObj, "col1|col2|col3|col4");
     *     sXml = ComPriSheet2Xml(sheetObj, null, "svc_scp_cd|gline_seq", "ACE|1", true);
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {string}  saveColName 선택,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
     *                              지정하지 않으면, 전체 컬럼을 대상으로 한다.
     * @param {string}  sCol        선택, 행조회시 기준이 되는 컬럼의 SaveName. "|"로 연결
     *                              지정하지 않으면, 전체 행을 대상으로 한다.
     * @param {string}  sValue      선택, 행조회시 기준이 되는 컬럼의 값(Value). "|"로 연결
     *                              지정하지 않으면, 전체 행을 대상으로 한다.
     * @param {bool}    bRowDel     선택, 원본행삭제여부, default=false.
     * @param {bool}    bIsStyled   선택, 열과 행의 색상 Editable정보 포함 여부, default=false. ComPriSheet2StyledXml 참조
     * @return string,  Sheet의 데이터를 조회XML로 구성한 문자열
     * @author 박성수
     * @version 2009.05.07
     */
    function ComPriSheet2Xml(sheetObj, saveColName, sCol, sValue, bRowDel, bIsStyled)  {
        try {
            if ((!sheetObj) || (!sheetObj.IBSheetVersion))  return "";
            var allXml="";
            var sColSep="☜☞";
            var allRows=false;
            var arrPrcdRow=new Array();
            if (saveColName == undefined || saveColName == null || saveColName == "") {
                saveColName=IBS_ConcatSaveName(sheetObj);
            }
            var arrCol=saveColName.split("|");
            var condNames=new Array();
            var condValues=new Array();
            if (sCol == undefined || sCol == null || sCol == "" || sValue == undefined || sValue == null || sValue == "") {
                allRows=true;
            } else {
                condNames=sCol.split("|");
                condValues=sValue.split("|");
            }
            var aryTR=new Array();
            var aryTD=new Array(arrCol.length);
            if (sheetObj.RowCount()> 0) {
                for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
                    var isMatch=true;
                    if (!allRows) {
                        for (var j=0; j < condNames.length; j++) {
                            isMatch=true;
                            if (sheetObj.GetCellValue(i, condNames[j]) != condValues[j]) {
                                isMatch=false;
                                break;
                            }
                        }
                    }
                    
                    if (!isMatch)  continue;

                    if (bIsStyled) {
                        var sheetFontColor=sheetObj.GetDataFontColor();
                        var sheetBackColor=sheetObj.GetDataBackColor();
                        var sheetBackColorAlt=sheetObj.GetDataAlternateBackColor();
                        var sTr="";
                        sTr += "\t<TR";
                        var rowFontColor=sheetObj.GetRowFontColor(i);
                        if (rowFontColor !=  "" && rowFontColor != sheetFontColor) {
                            var radixVal=parseInt(rowFontColor.substring(0, 2), 16) + "," + parseInt(rowFontColor.substring(2, 4), 16) + "," + parseInt(rowFontColor.substring(4, 6), 16);
                            sTr += " COLOR=\"" + radixVal + "\"";
                        }
                        var rowBackColor=sheetObj.GetRowBackColor(i);
                        if (rowBackColor !=  "" && rowBackColor != sheetBackColor && rowBackColor != sheetBackColorAlt) {
                            var radixVal=parseInt(rowBackColor.substring(0, 2), 16) + "," + parseInt(rowBackColor.substring(2, 4), 16) + "," + parseInt(rowBackColor.substring(4, 6), 16);
                            sTr += " BGCOLOR=\"" + radixVal + "\"";
                        }
                        var rowEditable=new String(sheetObj.GetRowEditable(i)).toUpperCase();
                        sTr += " EDIT=\"" + rowEditable + "\"";
                        for (var j=0; j < arrCol.length; j++) {
                            aryTD[j]="";
                            aryTD[j] += "\t\t<TD";
                            var cellFontColor=sheetObj.GetCellFontColor(i, arrCol[j]);
                            if (cellFontColor !=  "" && cellFontColor != sheetFontColor && cellFontColor != rowFontColor) {
                                var radixVal=parseInt(cellFontColor.substring(0, 2), 16) + "," + parseInt(cellFontColor.substring(2, 4), 16) + "," + parseInt(cellFontColor.substring(4, 6), 16);
                                aryTD[j] += " COLOR=\"" + radixVal + "\"";
                            }
                            var cellBackColor=sheetObj.GetCellBackColor(i, arrCol[j]);
                            if (cellBackColor !=  "" && cellBackColor != sheetBackColor
                                    && cellBackColor != sheetBackColorAlt && cellBackColor != rowBackColor) {
                                var radixVal=parseInt(cellBackColor.substring(0, 2), 16) + "," + parseInt(cellBackColor.substring(2, 4), 16) + "," + parseInt(cellBackColor.substring(4, 6), 16);
                                aryTD[j] += " BGCOLOR=\"" + radixVal + "\"";
                            }
                            var cellEditable=new String(sheetObj.GetCellEditable(i, arrCol[j])).toUpperCase()
                            if (cellEditable !=  "" && cellEditable != rowEditable) {
                                aryTD[j] += " EDIT=\"" + cellEditable + "\"";
                            }
                            if (sheetObj.GetToolTipText(i, arrCol[j]) != "") {
                                var sTxt=sheetObj.GetToolTipText(i, arrCol[j]).replace(/&/g, "&amp;").replace(/\"/g, "&quot;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
                                aryTD[j] += " TOOL-TIP=\"" + sTxt + "\"";
                            }
                            aryTD[j] += "><![CDATA[" + new String(sheetObj.GetCellValue(i, arrCol[j])) + "]]></TD>";
                        }
                        sTr += ">\n" + aryTD.join("\n")+ "\t</TR>";
                        aryTR.push(sTr);
                    } else {
                        for (var j=0; j < arrCol.length; j++) {
                        	aryTD[j]=String(sheetObj.GetCellValue(i, arrCol[j]));
                        }
                        aryTR.push("\t<TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>");
                    }
                    arrPrcdRow.push(i);
                }
            }
            allXml += "<?xml version='1.0'  ?>\n";
            allXml += "<SHEET>\n";
            allXml += "  <DATA TOTAL='" + arrPrcdRow.length + "' COLORDER='" + saveColName + "'";
            if (!bIsStyled) {
                allXml += " COLSEPARATOR='" + sColSep + "'";
            }
            allXml += ">\n";
            allXml += aryTR.join("\n");
            allXml += "  </DATA>\n";
            allXml += "</SHEET>";
            if (bRowDel) {
                if (allRows) {
                    sheetObj.RemoveAll();
                } else {
                    sheetObj.RowDelete(arrPrcdRow.join("|"), false);
                }
            }
            return allXml;
        } catch(err) { ComFuncErrMsg(err.message); }
    }    
    
    /******************************************************************************************************/
    /**                                        Sheet 관련 function                                        */
    /******************************************************************************************************/
   
    /**
     * IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 ETC-DATA로 넣은 KEY의 값을 리턴한다.
     * 단, 본 함수는 공통함수 ComGetEtcData와 유사한 함수로 와 ComGetEtcData은 ETC-DATA가 1개일 경우이며 
     *     현재 함수는 ETC-DATA가 2개일 경우에 사용한다.
     * <br><b>Example :</b>
     * <pre>
     *     xmlStr = mySheet.GetSearchXml("list.jsp");
     *     sValue = ComGetEtcData(xmlStr, "UserId");
     *     예를 들어 xmlStr의 내용이 아래와 같다면 sValue의 값은 "ibs006"이 된다.
     *     xmlStr ======================================================
     *       &lt;?xml version='1.0' ?&gt;
     *       &lt;SHEET&gt;
     *         &lt;ETC-DATA&gt;
     *              &lt;ETC KEY="UserId"&gt;ibs006&lt;/ETC&gt;
     *              &lt;ETC KEY="UserName"&gt;khlee&lt;/ETC&gt;
     *         &lt;/ETC-DATA&gt;
     *       &lt;/SHEET&gt;
     *     xmlStr ======================================================
     * </pre>
     * @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
     * @param   {string} etcName    필수,xml 문자열에서 추출하고자하는 ETC Key이름
     * @return  string, ETC-DATA로 넣은 KEY의 값
     * @version 3.4.0.50
     * @author 20151126.ADD
     */
    function GetEtcDataForExceptional(xmlStr,etcName, no){
        if(xmlStr == null  || xmlStr == "" || etcName == null || etcName == "") return;
        try {
        	
    		var xmlDoc = ComGetXmlDoc(xmlStr);
    		if (xmlDoc == null) return;
    		var xmlRoot = xmlDoc.documentElement;
    		
            var etcDataNode;
            if(no == null || no == '' || no == 'undefined'){
            	etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(1);
            }
            else {
            	etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(eval(no));
            }
            if(etcDataNode == null) return;
            var etcNodes=etcDataNode.childNodes;
            if(etcDataNode == null) return;
            for(var i=0;i<etcNodes.length;i++){
              if(etcNodes[i].nodeType!=1 || etcNodes[i].attributes.length == 0) continue;
//              if(etcNodes[i].attributes[0].text==etcName) {
        	  if(etcNodes[i].attributes[0].nodeValue==etcName) {
                if (etcNodes[i].firstChild==null) {
                  return "";
                } else {
                  return etcNodes[i].firstChild.nodeValue;
                }
              }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }      