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
	* 설명		: 리얼타임으로 알파벳만 Insert할때
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
	* 설명		: 리얼타임으로 알파벳만 Insert할때
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

		if (( key > 95) && ( key < 106 )) {   // 우측 키패드 Number key
			obj.event.returnValue = true;
			return true;
		}
	
		if (( key > 47) && ( key < 58 )) {    // 키보드 상단 Number key
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
     * Inputbox에서 Enter Key Event 발생시 Retrieve 실행한다.
     * sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyUp="checkEnter(this)"  >
     */
	function checkEnter() {
		if ( window.event.keyCode == 13 ) {
		    document.btn_retrieve.click(); // Retrieve 실행
		}
	}
	
	/**
     * Inputbox에서 Enter Key Event 발생시 날짜 체크 후 Retrieve 실행한다.
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
        	    document.btn_retrieve.click(); // Retrieve 실행
            }
        }

        return true;
    }

	/**
     * Inputbox에서 Enter Key Event 발생시 날짜 체크 후 Retrieve 실행한다.
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
        	    document.btn_retrieve.click(); // Retrieve 실행
            }
        }

        return true;
    }
    
    /**
	* @param    : obj => window
	* sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyDown="onlyNumber(window)"  >
	* @return 	: 
	* 설명		: 리얼타임으로 Number만 Insert할때
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
         
        if (( key > 95) && ( key < 106 )) {   // 우측 키패드 Number key
			window.event.returnValue = true;
			return true;
		}
	
		if (( key > 47) && ( key < 58 )) {    // 키보드 상단 Number key
			window.event.returnValue = true;
			return true;
		}
		
		window.event.returnValue = false;
		return false;
	}