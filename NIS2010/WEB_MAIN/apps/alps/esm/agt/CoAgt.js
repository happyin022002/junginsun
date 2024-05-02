 //  AGT 추가 메세지
	msgs['AGT10001'] = 'Please enter {?msg1}.';
	msgs['AGT10002'] = 'There is no data on {?msg1}.\n\n Please retrieve {?msg1} first.';
	msgs['AGT10003'] = 'The range of VAT(%) is between 0.00% and 99.99%.';
	msgs['AGT10004'] = 'There is no data.\n\n Please retrieve or enter data first.';    
	msgs['AGT10005'] = 'There are {?msg2} data on {?msg1}.';
	msgs['AGT10006'] = 'Please insert {?msg1}one by one.';
	msgs['AGT10007'] = '{?msg1} need new insert item.\n\n Please add row.';
	msgs['AGT10008'] = '{?msg1} does not match.';
	msgs['AGT10009'] = 'Please enter correct date.';
	msgs['AGT10010'] = 'There is no data modified.';
	msgs['AGT10011'] = 'This row has been approved so it can not modified or deleted.';
	msgs['AGT10012'] = '{?msg1} row has been approved so can not be approved agin.';
	msgs['AGT10013'] = '{?msg1} row is now in approval waiting status so its approval can not be cancelled.';
	msgs['AGT10014'] = 'If Office Code is different, it is impossible to approve at a time.\n\n Please check again.';
	msgs['AGT10015'] = '{?msg1}Please check I/F Option.';
	msgs['AGT10016'] = 'If you want to print report, please select just one item.';
	msgs['AGT10017'] = 'Please enter {?msg1} correctly.';
	msgs['AGT10018'] = '{?msg1} row has been approved so can not re-calculate.';
	msgs['AGT10019'] = '{?msg1} row is not target for approval.\n\n Please check again.';
	msgs['AGT10020'] = 'Each CHG consists of maximum of 3 Characters.\n\n {?msg1}';
	msgs['AGT10021'] = '{?msg1} row could not be interfaced because there is no AR_OFC data.\n\n Please check again.';
	msgs['AGT10022'] = 'There is no contents to {?msg1}';
	msgs['AGT10023'] = '{?msg1} Items.\n\n Do you want to {?msg2}';
	msgs['AGT10024'] = '{?msg1} row is being entered.\n\n Please save first.';
	msgs['AGT10025'] = 'Service Provider/Office of {?msg1} data could not be found.\n\n Please check again.';
	msgs['AGT10026'] = 'Exchange rate of {?msg2} of {?msg1}\n\n Please check again.';
	msgs['AGT10027'] = 'Could not {?msg1}.\n\n Please check Status.';
	msgs['AGT10028'] = '{?msg1} row could not be {?msg2}ed.\n\n Please check again.';
	msgs['AGT10029'] = 'Please enter group name which will be saved.';
	msgs['AGT10030'] = 'Please select group name which will be deleted.'; 
	msgs['AGT10031'] = '0 (zero) value could not be entered on Commission column.'; 
	msgs['AGT10032'] = '0 (zero) value could not be entered on B/L AMT.';
	msgs['AGT10033'] = 'Receipient e-mail address does not exsit.';
    msgs['AGT10034'] = 'You are requested to designate the proper approval authority prior to Approval Request.';
    msgs['AGT00067'] = '{?msg1}CSR No does not cancel!\n\nBecause interface status is success!';
    msgs['AGT00078'] = 'You are out of authority for this Office.';
    msgs['AGT00079'] = 'Save {?msg1}.';
    msgs['AGT00080'] = 'Could not {?msg1}.\n\n Please check again.';
    msgs['AGT00081'] = 'Wrong {?msg1} format is entered.\n\n Please check again.';
    msgs['AGT00082'] = '{?msg1} does not exsit.\n\n Please check again.';
    msgs['AGT00083'] = '{?msg1} does already exist!\n\n Please check up!';
    msgs['AGT00084'] = 'This row has been deleted.';
    msgs['AGT00085'] = 'Please select {?msg1}';
    msgs['AGT00086'] = 'ASA From~To Date vs Effective Date does not match! Please check up ASA Info!';
    msgs['AGT00087'] = 'Reject Success!';
    msgs['AGT00088'] = 'Cancel Success!';                                                                                           
    msgs['AGT00089'] = '{?msg1} should be above 0(zero).!';
	msgs['AGT10090'] = 'There is(are) ‘{?msg1}’ status booking(s). Please exclude ‘{?msg1}’ status booking(s).';
	msgs['AGT00091'] = '{?msg1} does already Interface!\n\n Please check up!';
	msgs['AGT10092'] = 'There is canceled booking[{?msg1}]. Please exclude canceled booking.';//CHM-201113085
	
	/**
	* @param    : obj => 객체
	* sample	: <input name="up" type="text" onKeyUp="upper2(this);"/>
	* @return 	: 
	* 설명		: 대문자로 만들기
	**/
    function upper2(obj) {
        
        var str = "";
		var key = window.event.keyCode;

		// 영문 소문자인 경우에만 Upper한다.
		if ( key >= 65 && key <= 90 ) {
    		str = obj.value;
    		str = str.toUpperCase();
    		obj.value = str;
        } else {
			window.event.returnValue = true;
			return true;
        }      
    }

	/**
	* @param    : obj => 객체
	* sample	: <input type="text" name="sdate" style="width:75" onkeydown="onlyNumberMinus(this);" onBlur="javascript:checkYYYYMMDDDash2(this);" maxlength="10">
	* @return 	: 
	* 설명		: Dash 날짜형식 만들기 and 체크 (YYYY-MM-DD)
	**/    
    function checkYYYYMMDDDash2(obj) {

	    obj.value = obj.value.replace(/\/|\-|\./g,"");
	    
        var str = obj.value;

        if(str.length > 6) {
           obj.value = str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
        } else if(str.length > 4 && str.length <= 6) {
           obj.value = str.substring(0, 4) + "-" + str.substring(4, 6);
        }
        
        if( str.length > 0 ) {    
            if(isDate(obj) == false) {
                showErrMessage(getMsg('AGT10009'));
                obj.select();
                return false;
            }
        }
        return true;
    }
    
	/**
	* @param    : obj => 객체
	* sample	: <input type="text" name="sdate" style="width:75" onkeydown="onlyNumberMinus(this);" onBlur="javascript:checkYYYYMMDDDash2(this);" maxlength="10">
	* @return 	: 
	* 설명		: Dash 날짜형식 만들기 and 체크 (YYYY-MM-DD)
	**/    
    function checkYYYYMMDDDash3(obj) {

	    obj.value = obj.value.replace(/\/|\-|\./g,"");
	    
        var str = obj.value;

        if(str.length > 6) {
           obj.value = str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
        } else if(str.length > 4 && str.length <= 6) {
           obj.value = str.substring(0, 4) + "-" + str.substring(4, 6);
        }
        
        if( str.length > 0 ) {    
            if(isDate(obj) == false) {
                return false;
            }
        }
        return true;
    }
    
	/**
	* @param    : obj => 객체
	* sample	: <input type="text" name="date1" style="width:60;" onkeydown="onlyNumberMinus(this);" onBlur="javascript:checkYYYYMMDash2(this);" maxlength="7">
	* @return 	: 
	* 설명		: Dash 날짜형식 만들기 and 체크 (YYYY-MM)
	**/ 	
	function checkYYYYMMDash2(obj) {

	    obj.value = obj.value.replace(/\/|\-|\./g,"");
	    
        var str = obj.value;	    

	    if(str.length > 4) {
            obj.value = str.substring(0, 4) + "-" + str.substring(4, 6);
	    }
	    
	    if( str.length > 0 ) {
            if(isValidYYYYMM(obj) == false) {
                showErrMessage(getMsg('AGT10009'));
                obj.select();
                return false;
            }
        }
        
        return true;
	}

	/**
	* @param    : obj => 객체
	* sample	: <input type="text" name="date1" style="width:60;" onkeydown="onlyNumberMinus(this);" onBlur="javascript:checkYYYYMMDash2(this);" maxlength="7">
	* @return 	: 
	* 설명		: Dash 날짜형식 만들기 and 체크 (YYYY-MM)
	**/ 	
	function checkYYYYMMDash3(obj) {

	    obj.value = obj.value.replace(/\/|\-|\./g,"");
	    
        var str = obj.value;	    

	    if(str.length > 4) {
            obj.value = str.substring(0, 4) + "-" + str.substring(4, 6);
	    }
	    
	    if( str.length > 0 ) {
            if(isValidYYYYMM(obj) == false) {
                return false;
            }
        }
        
        return true;
	}
	
	/**
	* @param    : obj => window
	* sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyDown="onlyAlphabet2(window)"  >
	* @return 	: 
	* 설명		: 리얼타임으로 알파벳만 입력할때
	**/
	function onlyAlphabet2(obj)
	{
		var key = obj.event.keyCode;
		
		if ( key == 13  || key == 9 )
		{   // 엔터,TAB
			return true;
		}
		if(obj.event.shiftKey == true){ 
			obj.event.returnValue = false;
			return true;
	    } 
		if (key == 91 || key == 92 || key == 93 || key == 229 || key == 21 || key == 25 || key == 19 ) return true;
	
		if (key >= 112 && key <= 123) {       // function key
			obj.event.returnValue = true;
			return true;
		}
	
		if ((key == 40) || (key == 38 )) {    // 위, 아래 화살표
			obj.event.returnValue = true;
			return true;
		}
	
		if ( key >= 65 && key <= 90 ) {   // 알파벳 key
			obj.event.returnValue = true;
			return true;
		}

		if (( key == 37)||( key == 39 )||( key == 46)||( key == 8 ) ) {  // 좌,우 화살표,DEL,BACKS,-
			obj.event.returnValue = true;
			return true;
		}
		if (obj.event.altKey || obj.event.shiftKey || obj.event.ctrlKey) 
		{ 
			obj.event.returnValue = true;
			return true;
		}
		if (( key > 36) && ( key < 41 )) 
		{    // 좌,상,우,하 화살표
			obj.event.returnValue = true;
			return true;
		}
		if (( key > 32) && ( key < 37 )) 
		{    // Page-Up, Page-Down, End, Home
			obj.event.returnValue = true;
			return true;
		}
		if (( key == 45) || ( key == 46 ) || ( key == 144 )) 
		{    // Insert,Delete,NumLock
			obj.event.returnValue = true;
			return true;
		}
		if (( key == 46)||( key == 8 )||( key == 17)||( key == 18 )||( key == 20)||( key == 27 )) 
		{  // DEL,BACKS,Ctrl,Alt,CapsLock,Esc
			obj.event.returnValue = true;
			return true;
		}
		obj.event.returnValue=false;
		return false;
	}	
	
	/**
	* @param    : obj => window
	* sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyDown="onlyAlphabetNumber2(window)"  >
	* @return 	: 
	* 설명		: 리얼타임으로 알파벳만 입력할때
	**/
	function onlyAlphabetNumber2(obj)
	{
		var key = obj.event.keyCode;
		
		if ( key == 13  || key == 9 )
		{   // 엔터,TAB
			return true;
		}
		if(obj.event.shiftKey == true){ 
			obj.event.returnValue = false;
			return true;
	    } 
		if (key == 91 || key == 92 || key == 93 || key == 229 || key == 21 || key == 25 || key == 19 ) return true;
	
		if (key >= 112 && key <= 123) {       // function key
			obj.event.returnValue = true;
			return true;
		}
	
		if ((key == 40) || (key == 38 )) {    // 위, 아래 화살표
			obj.event.returnValue = true;
			return true;
		}
	
		if ( key >= 65 && key <= 90 ) {   // 알파벳 key
			obj.event.returnValue = true;
			return true;
		}

		if (( key > 95) && ( key < 106 )) {   // 우측 키패드 숫자 key
			obj.event.returnValue = true;
			return true;
		}
	
		if (( key > 47) && ( key < 58 )) {    // 키보드 상단 숫자 key
			obj.event.returnValue = true;
			return true;
		}
		
		if (( key == 37)||( key == 39 )||( key == 46)||( key == 8 ) ) {  // 좌,우 화살표,DEL,BACKS,-
			obj.event.returnValue = true;
			return true;
		}
		if (obj.event.altKey || obj.event.shiftKey || obj.event.ctrlKey) 
		{ 
			obj.event.returnValue = true;
			return true;
		}
		if (( key > 36) && ( key < 41 )) 
		{    // 좌,상,우,하 화살표
			obj.event.returnValue = true;
			return true;
		}
		if (( key > 32) && ( key < 37 )) 
		{    // Page-Up, Page-Down, End, Home
			obj.event.returnValue = true;
			return true;
		}
		if (( key == 45) || ( key == 46 ) || ( key == 144 )) 
		{    // Insert,Delete,NumLock
			obj.event.returnValue = true;
			return true;
		}
		if (( key == 46)||( key == 8 )||( key == 17)||( key == 18 )||( key == 20)||( key == 27 )) 
		{  // DEL,BACKS,Ctrl,Alt,CapsLock,Esc
			obj.event.returnValue = true;
			return true;
		}
		obj.event.returnValue=false;
		return false;
	}
	
	/**
	* @param    : str => cust_cnt_cd + cust_seq
	* sample	: checkCustomer(value);
	* @return 	: 
	* 설명		: Customer 포멧 체크
	**/
	function checkCustomer(str) {
        var cust_cnt_cd = str.substring(0, 2);
        var cust_seq = str.substring(2, str.length);
        var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        
        if( cust_cnt_cd.length <= 0 ||
            containsCharsOnly2(cust_cnt_cd, chars) == false ||
            cust_seq.length <= 0 ||
            isNumber2(cust_seq) == false )
        {
		    return false;
		}
		
		return true;
	}
	
	/**
     * 첫번째인자의 날짜에 두번째일자수를 뺀 날짜를 yyyy-MM-dd 형식으로 리턴한다.
     * @param dateValue yyyyMMdd 또는 yyyy-MM-dd 형식의 날짜포맷
     * @param daya 가감일수
     * @param flag true/false
     * @return 가감된 일자(yyyy-MM-dd)
     */
    function getCalcDate(dateValue, day, flag) {
	    var numstr = dateValue.replace(/\/|\-|\./g,"");
	
	    if (numstr.length != 8){
	        return dateValue;
	    }
	
		//기준일
		var basic = new Date(0);
	    var user_day = new Date(numstr.substr(0,4), parseInt2(numstr.substr(4,2))-1, parseInt2(numstr.substr(6)));
	    var rtn_day = "";

	    if(flag == true){
		    rtn_day = new Date((1000*60*60*24*(((user_day-basic)/(1000*60*60*24))+day)));
		}else{
			rtn_day = new Date((1000*60*60*24*(((user_day-basic)/(1000*60*60*24))-day)));
		}
	
	    var year  = rtn_day.getYear();
	    var month = rtn_day.getMonth() + 1 ;
	    var day   = rtn_day.getDate();
	
	    if (month < 10) {
	        month = "0" + month;
	    }
	
	    if (day < 10) {
	        day = "0" + day;
	    }
	
	    var rtn_date = year + "-" + month + "-" + day;
	
	    return rtn_date;
	}

	/**
     * Inputbox에서 Enter Key Event 발생시 조회 실행한다.
     * sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyUp="checkEnter(this)"  >
     */
	function checkEnter() {
		if ( window.event.keyCode == 13 ) {
		    document.btn_retrieve.click(); // 조회 실행
		}
	}
	
	/**
     * Inputbox에서 Enter Key Event 발생시 날짜 체크 후 조회 실행한다.
     * @param    : obj => 객체
     * sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyUp="checkEnterYYYYMMDD(this)"  >
     */
    function checkEnterYYYYMMDD(obj) {

        if( onlyNumberMinus(obj) == false ) {
            return false;
        } else {
            if ( window.event.keyCode == 13 ) {

        	    if(checkYYYYMMDDDash3(obj) == false) {
        	        obj.blur();
        	        return false;
        	    }
        	    document.btn_retrieve.click(); // 조회 실행
            }
        }

        return true;
    }

	/**
     * Inputbox에서 Enter Key Event 발생시 날짜 체크 후 조회 실행한다.
     * @param    : obj => 객체
     * sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyUp="checkEnterYYYYMM(this)"  >
     */
    function checkEnterYYYYMM(obj) {

        if( onlyNumberMinus(obj) == false ) {
            return false;
        } else {
            if ( window.event.keyCode == 13 ) {

        	    if(checkYYYYMMDash3(obj) == false) {
        	        obj.blur();
        	        return false;
        	    }
        	    document.btn_retrieve.click(); // 조회 실행
            }
        }

        return true;
    }
    
    /**
	* @param    : obj => window
	* sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyDown="onlyNumber(window)"  >
	* @return 	: 
	* 설명		: 리얼타임으로 숫자만 입력할때
	**/
    function onlyNumber(obj)
	{
		var key = window.event.keyCode;
		
        if ( key == 13  || key == 9 )
		{   // 엔터,TAB
			return true;
		}
		
		if (( key == 37)||( key == 39 )||( key == 46)||( key == 8 ) ) {  // 좌,우 화살표,DEL,BACKS,-
			window.event.returnValue = true;
			return true;
		}
		
		if ((key == 40) || (key == 38 )) {    // 위, 아래 화살표
			window.event.returnValue = true;
			return true;
		}
		
		if (( key > 36) && ( key < 41 )) 
		{    // 좌,상,우,하 화살표
			window.event.returnValue = true;
			return true;
		}
         
        if (( key > 95) && ( key < 106 )) {   // 우측 키패드 숫자 key
			window.event.returnValue = true;
			return true;
		}
	
		if (( key > 47) && ( key < 58 )) {    // 키보드 상단 숫자 key
			window.event.returnValue = true;
			return true;
		}
		
		window.event.returnValue = false;
		return false;
	}

	/**
	 * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
	 * @param{form}	str	 Form 객체  
	 * @param{exElmNms}	str	  exElmNms값들은 form elemente name으로 구성하지 않을 값들이다. 
	 */	 
	 function agtQryStr(form, exElmNms) {

	     if (typeof form != "object" || form.tagName != "FORM") {
	         alert("Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
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
//	     	  ComClearSeparator(form.elements[i]);
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
	                    	 if(exElmNms!=null && exElmNms!='' && exElmNms!=undefined){
	                    		 if(!checkExElm(form.elements[i].name, exElmNms)){
	 		                    	name[j] = form.elements[i].name;
			                     	value[j] = form.elements[i].value;
			                     	j++;
	                    		 }
	                    	 } else {
		                    	name[j] = form.elements[i].name;
		                     	value[j] = form.elements[i].value;
		                     	j++;
	                    	 }
	                     }
	         }
	 	  	//전송후에 폼의 마스크를 다시 셋팅한다.
//	       ComAddSeparator(form.elements[i]);
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
	         var tmpUrlEncodeSheet    = document.getElementById("formquerystring");

	         if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
	         {
	             //인코딩을 위해 숨겨진IBSheet를 만든다.
	             var sTag = ComGetSheetObjectTag("formquerystring");
	             form.insertAdjacentHTML('afterEnd', sTag);
	         }

	         for (i = 0; i < j; i++) {
	             // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
	             if (name[i] != '') plain_text += name[i]+ "=" + formquerystring.UrlEncoding(value[i]) + "&";
	         }
	     }


	   //마지막에 &를 없애기 위함
	   if (plain_text != "")
	     plain_text = plain_text.substr(0, plain_text.length -1);
	     return plain_text;
	 }
	  
	 function checkExElm(elmNm, exElmNms){
		 var arr_exElmNms = '';
		 var rstTF = false;

		try{
			 if(exElmNms != null && exElmNms != '' && exElmNms != undefined){
					arr_exElmNms = exElmNms.split('|');
					 
					for(var i =0; i < arr_exElmNms.length; i++){
						if(arr_exElmNms[i] != "") {
							if(elmNm==null || elmNm=='' || elmNm==undefined){
								rstTF = true;
								break;
							}else if(elmNm == arr_exElmNms[i]){
								rstTF = true;
								break;
							}
						}
					}
					
				 }
		}catch(e){
			rstTF = true;
		}

		 
		 return rstTF;
	 }