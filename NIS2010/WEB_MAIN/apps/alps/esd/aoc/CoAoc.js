
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CoAoc.js
*@FileTitle : Aoc Common javascript
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 박찬민
*@LastVersion : 1.01
* 2012.10.04 박찬민
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2015.04.17 최성환 [CHM-201534870] DG, Overweight 정보 미입력 시 Confirm 차단 기능 생성(AOC90050,AOC90051)
=========================================================*/

// --------------------------------------------------------
// 메세지 관련
// 샘플 msgs["GEM01001"] = "{?msg1} {?msg2}하십시오.";
// -------------------------------------------------------

	// AOC 관련 메세지 
	msgs['AOC90001'] = "There is no data to delete.";
	msgs['AOC90002'] = "{?msg1} is not selected.";
	msgs['AOC90003'] = "There is no data retrieved.";
	msgs['AOC90004'] = "function processButtonClick Object Error";
	msgs['AOC90005'] = "Batch creation in progress.";
	msgs['AOC90006'] = "Unconfirmed/Error occurred cost tariffs were selected. Are you sure to overwrite those tariffs?";
	msgs['AOC90007'] = "Please select row(s) which you want to apply the cost adjustment to.";
	msgs['AOC90008'] = "Cost Tariff No has been already confirmed.";
	msgs['AOC90009'] = "Please input either flat rate or percentage for special commodity cost.";
	msgs['AOC90010'] = "Please specify the location group.";
	msgs['AOC90011'] = "This tariff cannot be modified hereafter.\n\nAre you sure you want to proceed?";
	msgs['AOC90012'] = "Tariffs with Error/Progressing/Cancelled status cannot be shown in detail.";
	msgs['AOC90013'] = "Smaller value than the previous row cannot be inputted.";
	msgs['AOC90014'] = "Excel Header Name Error!! Please check header names and make them same as the current screen.";
	msgs['AOC90015'] = "Without conversion rate, batch creation cannot be started.";
	msgs['AOC90016'] = "Please check after dry tab retrieved.";
	msgs['AOC90017'] = "Tariffs with other than 'Waiting' status cannot be cancelled.";
	msgs['AOC90018'] = "Are you sure you want to cancel the batch creation?";
	msgs['AOC90019'] = "More than 999 location group cannot be created. Please adjust the interval amount and try again.";
	msgs['AOC90020'] = "[Error] Pls check the file again. There are two possible reasons.\n1) Loaded data has nothing changed.\n2) Incompatible tariff sequence. In this case, pls newly download and use the excel file of the latest tariff No.";
	msgs['AOC90021'] = "Please input the mandatory inquiry option.";
	msgs['AOC90022'] = "Please input either DATE or EFFECTIVE AS OF.";
	msgs['AOC90023'] = "There are remaining data that could not be displayed all together. Please use ‘Down Excel without Displaying’ button on the top right side of the screen.";
	msgs['AOC90024'] = "For confirmation, please go to cost management screen.\nDirect confirmation is possible only when the result of batch is '0'.";
	msgs['AOC90025'] = "{?msg1}\nAre you sure you want to proceed?";
	msgs['AOC90026'] = "Only confirmed cost tariff(s) can be cancelled.";
	msgs['AOC90027'] = "Cannot be cancelled since guideline tariff has already been created.";
	msgs['AOC90028'] = "Are you sure you want to change the status to 'Updated'?";
	msgs['AOC90029'] = "Are you sure you want to confirm these tariffs?";
	msgs['AOC90030'] = "Cannot be cancelled since guideline tariff has already been created.";
	msgs['AOC90031'] = "Each Class code could not be selected in more than two drop down box at the same time.";
	msgs['AOC90032'] = "One value, at least, must be selected to use this function";
	msgs['AOC90033'] = "Are you sure to proceed? {?msg1}";
	msgs['AOC90034'] = "There is no data having tariff No. inserted";
	msgs['AOC90035'] = "There is a reefer rate for the inland route you are trying to delete.\nWhen you click 'Yes', those routes for Dry and Reefer will be deleted.";
	msgs['AOC90036'] = "The selected route is duplicated, It's already existing in 'RF' IHC module.{?msg1}";
	msgs['AOC90037'] = "The selected routes are successfully copied to 'RF' IHC tab.";
	msgs['AOC90038'] = "Pls check if country code belongs to the region of subj. RHQ";
	msgs['AOC90039'] = "Can not be selected more than {?msg1}";
	msgs['AOC90040'] = "The data with incompatible tariff seq. is included in loaded file. Pls newly download and use the excel file of latest tariff No.";
	msgs['AOC90041'] = "LOC group is not completely assigned for both CNY and HKD currency.";
	msgs['AOC90042'] = "Re-batch function is only for Error status.";
	msgs['AOC90043'] = 'The inquiry period is limited to {?msg1}.';
	msgs['AOC90044'] = '{?msg1}';
	msgs['AOC90045'] = "BKG Detail screen can't be displayed if number of selected booking exceeds 200";
	msgs['AOC90046'] = "Overweight sector needs to be modified according to validation rule. Pls check the row colored in red.";
	msgs['AOC90047'] = "To Overweight range must be greater than From.";
	msgs['AOC90048'] = "There is no route registered in RF tab. Are you sure to proceed with the confirmation?";
	msgs['AOC90049'] = "There is '0' or minus value for {?msg1} total cost. Pls update cells marked in red";
	
	msgs['AOC90050'] = "There is no DG, OverWeight data to confirm.";
	msgs['AOC90051'] = "Please input maximum available weight to Overweight (Ton) To column.";


/****** aoc_common start *********/
/*
 * Node를 비교하기 위해서 만든 function
 * Java의 HashTable과 비슷한 기능을 한다.
 */
var nodeCount = 0;
function objInit() {
	this.nodeObject = new Object();
	this.HPut = HPut;
	this.HGet = HGet;
	this.HDel = HDel;
	nodeCount = 0;
}

function HPut(key, value) {
	obj = this.nodeObject;
	flag = 0;
	for(var n in obj) {
		if(n == key) {
			obj[key] = value;
			flag = 1;
		}
	}
	if(flag == 0) {
		obj[key] = value;
	}
	nodeCount++;
}

function HGet(key) {
	obj = this.nodeObject;
	return obj[key];
}

function HDel(key) {
    this.HPut(key, null);
	nodeCount--;
}

// 공통으로 사용할 스크립트 소스
/**
 * sep에 해당하는 char를 제거하는 스크립트
 */
function doSepRemove(obj, sep) {
	var ch = "";
	var lvobj = "";
	for(var i=0; i<obj.length; i++) {
		if(obj.charAt(i) == sep) {
			ch = "";
		} else {
			ch = obj.charAt(i);
		}
		lvobj = lvobj + ch;
	}
	return lvobj;
}

/**
 * 날짜에 대한 유효성을 체크.
 */
function doDatecheck(obj) {
	if( obj.length == 8 ) {
		objy = obj.substring(0, 4);
		objm = obj.substring(4, 6);
		objd = obj.substring(6);
	} else {
		return false;
	}
	var lverr = 0; // 에러 변수
	var lvmonday = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	if( objy%1000 != 0 && objy%4 == 0 )
		lvmonday[1] = 29; //윤년
	if( objd > lvmonday[objm-1] || objd < 1 )
		lverr = 1; //year check
	if( objm < 1 || objm > 12 )
		lverr = 1; //month check
	if( objm%1!=0 || objy%1!=0 || objd%1!=0 ) 
		lverr = 1; //number check
	if( lverr == 1 ) {
		return false;
	} else {
		return true;
	}
}

/**
 * 한글 여부에 대한 유효성을 체크.
 */
function dohancheck(obj) {
	var lveng = /[^a-z|A-Z]/;
	if( lveng.test(obj) ) {
	    errMsg = ComGetMsg('COM12123','This field');
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}

/**
 * 영문과 숫자에 대한 유효성을 체크.
 */
function doengnumcheck(obj) {
	var lveng = /[^a-z|A-Z|,|0-9|]/;
	if( lveng.test(obj) ) {
		errMsg = ComGetMsg('COM12127','This field');
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}

/**
 * 날짜에 빼기에 대한 유효성을 체크
 */
function dateCalcuration(objFrom, objTo) {
	var lvfrmDate = doSepRemove(doSepRemove(objFrom, " "), "-");
	var lvtoDate = doSepRemove(doSepRemove(objTo, " "), "-");
	var lvFrom = lvfrmDate.substring(4, 6)+"-"+lvfrmDate.substring(6)+"-"+lvfrmDate.substring(0, 4);
	var lvTo = lvtoDate.substring(4, 6)+"-"+lvtoDate.substring(6)+"-"+lvtoDate.substring(0, 4);
	var fromDay = new Date(lvFrom);
	var toDay = new Date(lvTo);
	var objFT = (toDay.getTime()-fromDay.getTime()) / (24*60*60*1000);
	return objFT;
}

/**
 * 일자에 '-'제거 및 입력하는 함수
 *
 */
function delHypen(obj) { //hypen제거
	var lvobj = doSepRemove(obj.value, "-");
	obj.value = lvobj;
}
function getHypen(obj) { //hypen입력
	if( obj.value.length == 8 ) {
		obj.value = obj.value.substring(0, 4)+"-"+obj.value.substring(4,6)+"-"+obj.value.substring(6);
	}
}

/**
 * 숫자 소수점 2자리...리턴
 *
 */
 function myRound(src, pos) { 
		if (pos == null || pos==undefined )
		{
			pos = 2;
		}
		src = deleteComma(src);
		var posV = Math.pow(10, pos);
		var retNum = new String(Math.round(src*posV)/posV);

		var strArray = retNum.split('.');

		var dec = strArray[0];
		var dbl = strArray[1];

		if(isNaN(dec)) dec = '0';
		if(isNaN(dbl)){
			dbl = '';
			dbl = rpad(dbl, pos, '0');
		}else{
			dbl = rpad(dbl, pos, '0');
		}
		return dec+'.'+dbl;
}


/**
 * 대문자로 바꾼는 함수.
 */
function setgetUpper(obj) {
	return obj.value = obj.value.toUpperCase();
}

/**
 * 컨테이너 번호 Check Digit 계산 함수.
 */

function cntrCheckDigit(cntrNo){

 if (cntrNo.length != 10){

  return cntrNo;

 } 

 var sum = 0;
 cntrNo = cntrNo.toUpperCase();

 for(var i=0;i<10;i++){

  sum = sum + productValue( cntrNo.charAt(i),i);

 }

 var mod = sum % 11;

 if (mod == 10) mod =0;
 
 if (isNaN(mod)) return cntrNo;

 return cntrNo+mod;

 

}

/**
 * 컨테이너 번호 Check Digit 계산 함수 -product Value 계산 하는 로직을 포함한 메소드
 */
 
function productValue(str,position){

 var strMap = new Array("10","12","13","14","15","16","17","18","19","20","21","23","24","25","26","27","28","29","30","31","32","34","35","36","37","38");

 

 var num = new Number(str);

 if (isNaN(num)){

  var index = new Number(str.charCodeAt(0)-65) ;

  var strNum = strMap[index];


  return strNum * Math.pow(2, position);

 } else {

  return num* Math.pow(2, position);

 }

}

function multiCntrChkDgt(cntrList){
	if(cntrList == undefined || cntrList == '') return cntrList;

	var cntrArray = cntrList.split(',');
	var newCntrList = '';

	for(var i=0; i<cntrArray.length; i++){
		newCntrList += cntrCheckDigit(cntrArray[i]);
		if(i < cntrArray.length-1) newCntrList += ',';
	}
	return newCntrList;
}

/****** aoc_common end *********/

/****** comboUtil start ********/
var comboObjects = new Array();
var comboCnt = 0 ;

/**
 * IBCombo Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/****** comboUtil end ********/

/****** stringUtil start *********/
String.prototype.trim = function(){
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function chkAmtPos_JPY(src){
	src = deleteComma(src);
	if(isNaN(src)) src = '0';
	src = Number(src);
	var retNum = new String(Math.round(src));
	return retNum;
}

function chkAmtPos(src, pos){
	
	if (pos == null || pos==undefined )
	{
		pos = 2;
	}
	src = deleteComma(src);
	var posV = Math.pow(10, pos);
	var retNum = new String(Math.round(src*posV)/posV);

	var strArray = retNum.split('.');

	var dec = strArray[0];
	var dbl = strArray[1];

	if(isNaN(dec)) dec = '0';
	if(isNaN(dbl)){
		dbl = '';
		dbl = rpad(dbl, pos, '0');
	}else{
		dbl = rpad(dbl, pos, '0');
	}
	return dec+'.'+dbl;
}

function deleteComma(src){
	
	var src = String(src);
	if (src==null || ComTrim(src)==''){
		return '';
	}
	return src.replace(/,/gi,'');
}

function addComma(src){
	
	var src = String(src);
	if (src==null || ComTrim(src)==''){
		return '';
	}
	var re = /(-?\d+)(\d{3})/;
	while (re.test(src)) {
		src = src.replace(re, "$1,$2");
	}
	return  src;
}

function rpad(src, len, padStr){
	var retStr = "";
	var padCnt = Number(len) - String(src).length;
	for(var i=0;i<padCnt;i++) retStr += String(padStr);
	return src+retStr;
}

function lpad(src, len, padStr){
	var retStr = "";
	var padCnt = Number(len) - String(src).length;
	for(var i=0;i<padCnt;i++) retStr += String(padStr);
	return retStr+src;
}

function get_only_num(obj) {
	var str = escape(obj);
	var returnNum = '';
	for (i=0; i<str.length; i++){
		if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57 )
		returnNum += str.charAt(i);
	}
	
	return returnNum;
}

/**
 * uppercase
 **/
function value_upper(obj){
	obj.value = obj.value.toUpperCase();
}

function checkDateFormat(dt){
	
	var date_regexp = "^(\\d{4}\\d{2}\\d{2})$";
	
	if (!checkFormat(dt, date_regexp)){
		return false;
	}
	return true;
}

function checkFormat(value, regexp){
	
		re = new RegExp(regexp,"gi"); 
		
		if (!re.test(value)){
			return false;
		}
	return true;
}


function toHtml(str){
	str = str.replace(/&/g,'@amp;');
	str = str.replace(/</g,'@lt;');
	str = str.replace(/>/g,'@gt;');
	str = str.replace(/,/g,'@#44;');
	str = str.replace(/\"/g,'@quot;');
	str = str.replace(/\'/g,'@acute;');
	str = str.replace(/\n/g,'@ffd;');
	str = str.replace(/\r/g,'@cgrtn;');
	return str;
}

function getPageURL(){

	var url = window.location+"";
	var startIndex = url.indexOf('/hanjin/');
	var endIndex = url.indexOf('.do');
	url = url.substring(startIndex+8, endIndex);

	return url;
}

/******** stringUtil end ***********/

/**
 * Focus 이동
 * 사용예: onKeyup="javascript:moveFocus(this, this.form.to_prd_dt, 10);"
 * 
 * @param {Object}		fromFormElement		from Form Element
 * @param {Object}		toFormElement		이동할 요소
 * @param {int,String}	numleng				number length
 **/
function moveFocus(fromFormElement, toFormElement, numleng) {
    var eleLeng = fromFormElement.value.length;
    if (eleLeng>=numleng){toFormElement.focus();}
}

/**
 * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     var sCondParam=AocFrmQryString(document.frmSearch); //결과:"txtname=이경희&rdoYn=1&sltMoney=원화";
 * </pre>
 * @param {form} form Form 오브젝트
 * @return string
 * @version 1.0.0.0
 * @see #AocFrmQryStringEnc
 */
function AocFrmQryString(form) {

    if (typeof form != "object" || form.tagName != "FORM") {
        alert("Error : Please contact the administrator\n" + "Detail : Parameter of AocFrmQryString Function is not a FORM Tag.");
        return "";
    }

    var name = new Array(form.elements.length);
    var value = new Array(form.elements.length);
    var j = 0;
    var plain_text="";

    //사용가능한 컨트롤을 배열로 생성한다.
    len = form.elements.length;
    for (i = 0; i < len; i++) {
      //클래스 아이디로 제품을 구분함-아래는 HTMl제품
      if(form.elements[i].classid==undefined){
    	  //전송전에 폼의 마스크를 제거한다.
//    	  ComClearSeparator(form.elements[i]);
      switch (form.elements[i].type) {
        case "button":
        case "reset":
        case "submit":
          break;
        case "radio":
        case "checkbox":
                    if (form.elements[i].checked == true) {
                        name[j] = form.elements[i].name;
                        value[j] = form.elements[i].value;
                        j++;
                    }
                    break;
            case "select-one":
                    name[j] = form.elements[i].name;
                    var ind = form.elements[i].selectedIndex;
                    if(ind >= 0) {
                        if (form.elements[i].options[ind].value != '')
                            value[j] = form.elements[i].options[ind].value;
                        else
                            value[j] = '';
                    } else {
                        value[j] = "";
                    }
                    j++;
                    break;
            case "select-multiple":
                    name[j] = form.elements[i].name;
                    var llen = form.elements[i].length;
                    var increased = 0;
                    for( k = 0; k < llen; k++) {
                        if (form.elements[i].options[k].selected) {
                            name[j] = form.elements[i].name;
                            if (form.elements[i].options[k].value != '')
                                value[j] = form.elements[i].options[k].value;
                            else
                                value[j] = '';
                            j++;
                            increased++;
                        }
                    }
                    if(increased > 0) {
                        j--;
                    } else {
                        value[j] = "";
                    }
                    j++;
                    break;
                default :
                    if(form.elements[i].value.length >0 ) {
                    	name[j] = form.elements[i].name;
                    	value[j] = form.elements[i].value;
                    	
                    	j++;
                    }
        }
	  	//전송후에 폼의 마스크를 다시 셋팅한다.
//      ComAddSeparator(form.elements[i]);
    //IB에서 제공하는 컨트롤의 값을 조합한다.
    }else{
      switch(form.elements[i].classid){
        case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  // IBMaskEdit 경우
          name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
                value[j] = form.elements[i].Value;
                j++;
          break;
        case CLSID_IBMCOMBO: // IBMultiCombo 경우
          name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
          		if(form.elements[i].UseCode)
          			value[j] = form.elements[i].Code;
          		else
          			value[j] = form.elements[i].Text;
                j++;
                break;
      }
    }
    }

    // QueryString을 조합한다.
    //   1) Explorer 5.5 이상일 경우, encodeURIComponent() 를 이용하여 URL Encode
    //   2) 기타 경우는 IB Sheet 를 이용하여 URL Encode
    var webBrowserName = navigator.appName;
    var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
                                                        navigator.appVersion.indexOf("MSIE") + 8)

    if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
        for (i = 0; i < j; i++) {
            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
            if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
        }
    } else {
        var tmpUrlEncodeSheet    = document.getElementById("AocFrmQryString");

        if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
        {
            //인코딩을 위해 숨겨진IBSheet를 만든다.
            var sTag = ComGetSheetObjectTag("AocFrmQryString");
            form.insertAdjacentHTML('afterEnd', sTag);
        }

        for (i = 0; i < j; i++) {
            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
            if (name[i] != '') plain_text += name[i]+ "=" + AocFrmQryString.UrlEncoding(value[i]) + "&";
        }
    }


  //마지막에 &를 없애기 위함
  if (plain_text != "")
    plain_text = plain_text.substr(0, plain_text.length -1);
    return plain_text;
}
 
  
  function changeObjectColor(objId, color, className){
       document.getElementById(objId).style.color = color;
  }

//날자포맷의 하이픈('-') 제거 : yyyy-mm-dd ==> yyyymmdd
function removeBarDate(obj) {
	var value = "";
	for ( var i = 0; i < obj.value.length; i++ ) {
		var ch = obj.value.charAt(i);
		if ( ch != '-' ) value = value + ch;
	}
	obj.value = value;
	obj.select();
}


//날자포맷의 하이픈('-') 삽입 : yyyymmdd ==> yyyy-mm-dd
function addBarDate(obj) {
	if( obj.value.length == 8 ){
		obj.value = obj.value.substr(0,4) + '-' + obj.value.substr(4,2) + '-' + obj.value.substr(6,2);
	}
}


function aocBlurDate(obj){
    if( obj.value == "" ){
	    return;
    }
    if( !ComIsDate(obj) ){
		ComShowCodeMessage('COM12179');
		obj.focus();
		return ;
	} else{
	    addBarDate(obj);
	}
}