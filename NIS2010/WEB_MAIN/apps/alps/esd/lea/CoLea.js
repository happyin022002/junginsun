/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CoLea.js
*@FileTitle : LEA공통기능을 호출하는 function을 구성
*Open Issues :
*Change history : 2007-02-13
*@LastModifyDate : 2007-02-13
*@LastModifier : 
*@LastVersion :
* 1.0 Creation
=========================================================*/
	msgs['LEA90001'] = 'Please enter a valid date format: YYYY-MM'						;
	msgs['LEA90002'] = 'Invalid data input {?msg1}'										;
	msgs['LEA90003'] = 'Nothing selected'												;    
	msgs['LEA90004'] = 'Please enter {?msg1} or {?msg2} or {?msg3}'			 			;    
	msgs['LEA90005'] = 'The parameter has been designated by mistake'					;
	msgs['LEA90006'] = 'Please enter a valid email format: xxx@xxxx.xxx'				;
	msgs['LEA90007'] = 'Please check conditions before starting batch.'					;
	msgs['LEA90008'] = 'No data found.'													;
	msgs['LEA90009'] = 'Not saved manual input.'										;
	msgs['LEA90010'] = 'Completed ERP interface'										;
	msgs['LEA90011'] = 'Not confirmed.'													;
	msgs['LEA90012'] = 'Confirmed.'														;
	msgs['LEA90013'] = 'Not confirmed accrual batch condition item.'					;
	msgs['LEA90014'] = 'Please, Save setting values!'									;
	msgs['LEA90015'] = 'Batch for Exe.Month {?msg1} has been completed and confirmed.'	;
	msgs['LEA90016'] = 'Can only contain numbers or {?msg1}'							;
	msgs['LEA90017'] = 'Please enter {?msg1} in English letters'						;
	msgs['LEA90018'] = '{?msg1} must be {?msg2} digits English numbers.'				;
	msgs['LEA90019'] = '{?msg1} must be {?msg2} digits English letters.'				;
	msgs['LEA90020'] = '{?msg1} must be greater than or equal to {?msg2}' 				;
	msgs['LEA90021'] = 'Please enter {?msg1}'											;
	msgs['LEA90022'] = 'Period is limited to {?msg1} week.'								;
	msgs['LEA90023'] = 'Mail has been sent.'											;
    msgs['LEA90024'] = 'Update has been completed!'										;
    msgs['LEA90025'] = 'Batch started.'													;
    msgs['LEA90026'] = 'Data Saved Successfully!';
    msgs['LEA90027'] = 'Data Save Action Failed!';
    msgs['LEA90028'] = 'The inquiry period is limited to {?msg1} months.';
    msgs['LEA90029'] = 'There are remaining data not being displayed. Please scroll the bar down to get them all.';
    msgs['LEA90030'] = '{?msg1} must be earlier than {?msg2}.';
    msgs['LEA90031'] = 'Please check G/L Month Period! G/L Month conditions should be in the same year.';
    
    
    
    /*=========================================================
    *Copyright(c) 2006 CyberLogitec
    *@FileName : LEA_Common.js
    *@FileTitle : LEA공통기능을 호출하는 function을 구성
    *Open Issues :
    *Change history :
    *@LastModifyDate : 2007-02-13
    *@LastModifier : Yeon Jin Park
    *@LastVersion : 1.0
    * 2007-04-02 Yeon Jin Park
    * 1.0 최초 생성
    * 1.1 ALPS 전환
    =========================================================*/

    	/*****************************************************************
    		
    		이 JS FILE은 외부에서 LEA공통기능을 호출하는 function을 구성

    	******************************************************************/


    	String.prototype.trim = function(){
    		return this.replace(/(^\s*)|(\s*$)/g, "");
    	}

        
        /**
          * 입력된 문자열이 숫자 만을 포함하고 있는지 여부 리턴
          * 오류가 있을 경우 메세지를 표시하고 focus 이동
          * @param obj   Object
          * @return true - 숫자만을 포함하고 있는 경우
         */
        function lea_comm_isNumberMessage(obj, len) {

        	if(obj.value == "ALL" || obj.value == "" || obj.value == null) return false;
        	
        		//function name change : removeDash ==> ComTrimAll(obj, sChar)
        		var str = ComTrimAll(obj.value, '-');

        	//function name change : isNumber2 ==> ComIsNumber
            if (!ComIsNumber(str)) {
                //ComShowMessage("Please enter only number.");
                ComShowMessage(ComGetMsg("COM12122", obj.desc));
                obj.value = "";
                return false;
            }
            if(str.length > len){
            	//ComShowMessage("Please enter "+len+" characters long.");
            	ComShowMessage(ComGetMsg("COM12173", obj.desc,len));
            	obj.value = "";
            	return false;
            }
            return true;
        }

    	/**
    	* @param     : obj	=> 객체
    	* sample	: <input type ="text" name ="date" onblur="lea_com_convertYymm(this)">
    	* @return 	: 
    	* 설명		: 년월(YYYY-MM)을 검사 하여 보여주기 
    	**/
    	function lea_com_convertYymm(obj)
    	{
    		//function name change : delete_Char ==> ComClearSeparator
    		//obj.value = ComClearSeparator(obj.value, '-'); // value 문자열 중 '-' 문자를 삭제함

    		obj.value = ComReplaceStr(obj.value, '-', ''); // value 문자열 중 '-' 문자를 삭제함
    		
    		switch(obj.value.length)
    		{
    			case 0 :
    				return;
    				break;
    			case 4 :
    				if (parseInt(obj.value.substring(0,2),10) > 80 )	obj.value = "19"+obj.value;
    				else												obj.value = "20"+obj.value;
    				break;
    			case 6 :
    				break;
    			default :
    				obj.focus();
    				return;
    				break;
    		}
    		var realDate 	= ComIsDate(obj.value + "01");
    		if (!realDate)
    		{
    			//ComShowMessage('잘못된 날짜입니다.');
    			ComShowMessage(ComGetMsg("LEA90001"));
    			obj.value	= "";
    			obj.focus();
    			return;
    		}
    		str = obj.value;
    		str = str.substring(0,4) + "-" + str.substring(4,6);
    		obj.value = str;
    	}
    	
    	/**
    	* @param     : src	=> 
    	* sample	: <input type ="text" name ="date" onblur="lea_com_convertYymm(this)">
    	* @return 	: 
    	* 설명		: 년월(YYYY-MM)을 검사 하여 보여주기 
    	**/
    	function lea_com_convertYymm2(sr)
    	{

    		//function name 변경 : delete_Char ==>> ComClearSeparator 	(X) 
    		//function name 변경 : delete_Char ==>> ComReplaceStr 		(O)
    		//usage : ComClearSeparator(txtDate, "ym", "/")
    		////var src = ComClearSeparator(sr, 'ym', '-');	
    		
    		////j:var src	= ComReplaceStr(sr, '-');
    		var src	= ComReplaceStr(sr, '-', '');
    		
    		switch(src.length)
    		{
    			case 0 :
    				return;
    				break;
    			case 4 :
    				if (parseInt(src.substring(0,2),10)  > 80 ){
    					src = "19"+src;
    				}else{
    					src = "20"+src;
    				}
    				break;
    			case 6 :
    				break;
    			default :
    				return;
    				break;
    		}
    		
    		//function name 변경 : chk_Date ==>> ComIsDate
    		var realDate = ComIsDate(src + "01");	
    		
    		if (!realDate)	return;
    		
    		str = src;
    		str = str.substring(0,4) + "-" + str.substring(4,6);
    		
    		return str;
    	}

    	/**
    	* @param : 
    	* sample	: get_NowYymm('-');get_Yymm('/');
    	* @return 	: 현재 년월(YYYY-MM)
    	* 설명		: 현재 년월 가지고 오기
    	**/
    	function lea_comm_getNowExeYymm()
    	{
    	
    		var delimiter ="";
    		if (arguments[0] == null)
    		{
    			delimiter = "-" ;
    		}
    		else
    		{
    			delimiter = arguments[0] ;
    		}
    		year1	= get_NowYear();
    		month2	= get_NowMonth()-1;
    	
    		//common function name change : fullZero ==>> ComLpad | string.lpad()
    		//usage : ComLpad(obj, iLen, padStr) 세번째 인자 "0"
    		return year1 + delimiter + ComLpad(month2,2);	
    	}

    	/**
    	* @param : 
    	* sample	:
    	* @return 	: boolean
    	* 설명		: YYYYMM 날짜 유효성 확인.
    	**/
    		function lea_comm_checkValidYYYYMM(obj){
    			if(obj.value == "" || obj.value == null) return false;
    			if(!isValidYYYYMM(obj)){
    				//ComShowMessage( "Please enter a valid date.");
    				ComShowMessage( ComGetMsg("LEA90001"));
      			obj.value = "";
      			return false;
    			}
    		}
    	/**
    	* @param : 
    	* sample	: get_NowYymm('-');get_Yymm('/');
    	* @return 	: 현재 년월(YYYY-MM)
    	* 설명		: 현재 년월 가지고 오기
    	**/
    	function lea_comm_checkFromDateToDate(fromObj, toObj)
    	{
    		var returnVal	= true;
    		if(fromObj.value == "" || fromObj.value == null){
    			ComShowMessage( ComGetMsg("LEA90021", fromObj.desc));
    			returnVal = false;
    			return returnVal;
    		}
    		if(toObj.value == "" || toObj.value == null){
    			ComShowMessage( ComGetMsg("LEA90021", toObj.desc));
    			returnVal = false;
    			return returnVal;
    		}

    		fromValue	= fromObj.value	+ "-01";
    	    tovalue 	= toObj.value	+ "-01";
    	    
    	    //common function name change : getDaysBetween2 ==>> ComGetDaysBetween
    		//usage : ComGetDaysBetween    
    		var day_gab = ComGetDaysBetween(fromValue, tovalue);
    		if(day_gab < 0){ 
    			ComShowMessage( ComGetMsg("LEA90020", toObj.desc, fromObj.desc));
    			returnVal = false;
    			return returnVal;
    		}
    		return returnVal;
    	}

    		

    /**
     * 단일 Object Validation
     *
     * @param : obj    - validation할 object
     * 예 : fnChkEmptyObj(obj)
     *      해당 object에 desc= ""를 기술해놓는다.
     */
     	function lea_comm_fnChkEmptyObj(obj){
    		if (obj.type == "text" || obj.type == "textarea" ||
    		    obj.type == "password" || obj.type == "file" ) {
    		  if ((obj.value == null || obj.value == '' || obj.value == 'ALL') && obj.name != 'frm_bkg_no_split') {
    		    //ComShowMessage("Please enter " +obj.desc);
    				ComShowMessage( ComGetMsg("LEA90021", obj.desc));
    			  obj.focus();
    		    return false;
    		  }
    		}

    		else if (obj.type.indexOf('select') != -1) {
    		  if (obj.selectedIndex == -1) {
    		    //ComShowMessage("Please select "+obj.desc);
    				ComShowMessage( ComGetMsg("COM12113", obj.desc));
    			  obj.focus();
    		    return false;
    		  }
    		}
    		else if (obj.type == 'radio') {
    		  var group = formObj[obj.name];
    		  var checked = false;
    		  if (!group.length)
    		    checked = obj.checked;
    		  else
    		    for (var r = 0; r < group.length; r++)
    		      if ((checked = group[r].checked))
    		        break;
    		  if (!checked) {
    		    //ComShowMessage("Please select "+ obj.desc );
    		    ComShowMessage(ComGetMsg("COM12113", obj.desc));
    		    obj.focus();
    		    return false;
    		  }
    		}
    		else if (obj.type == 'checkbox') {
    		  var group = formObj[obj.name];
    		  if (group.length) {
    		    var checked = false;
    		    for (var r = 0; r < group.length; r++)
    		      if ((checked = group[r].checked))
    		        break;
    		    if (!checked) {
    		      //ComShowMessage("Please select "+ obj.desc);
    		      ComShowMessage(ComGetMsg("COM12113", obj.desc));
    		      obj.focus();
    		      return false;
    		    }
    		  }
    		}

    		return true;
    	}

    /**
     * 필수입력 Form Validation
     *
     * @param : obj    - validation할 object
     * 예 : validChkForm(formObj)
     *      해당 object에 valid="1"  desc= ""를 기술해놓는다.
     */
    	function lea_comm_validChkForm(formObj){
    		for (var e = 0; e < formObj.elements.length; e++) {
        var el = formObj.elements[e];
        	if(el.valid == '1'){
        		if(!lea_comm_fnChkEmptyObj(el)) return false;
    		  }
      	}

      	return true;
    	}
    /**
     *  ; 로 구분된 여러 E-Mail를 check한다.
     *
     * @param : obj    - validation할 object
     * 예 : lea_comm_CheckEmail(obj)
     *    
     */
    	function lea_comm_CheckEmail(obj)
    	{
    			if(obj.value == "" || obj.value == null) return false;
    			var str = obj.value;
    			var arrStr = str.split(";");
    			for(i=0;i<arrStr.length;i++){
    	     if (!lea_com_isEmailAddrStr(arrStr[i]) ){
    	     		 ComShowMessage(ComGetMsg("LEA90006"));
    	     		//ComShowMessage("Please enter a valid email format: xxx@xxxx.xxx");
    		     	obj.focus();
    		     	return false;
    				}
    			}
    	     return true ;
    	}
    	
    /**
     * E-Mail를 check한다.
     *
     * @param : emailVal    - validation할 object
     * 예 : lea_com_isEmailAddrStr(formObjemailVal)
     *    
     */
    	
    	function lea_com_isEmailAddrStr(src) {
    	  var format = /^\s*[\w\~\-\.]+\@[\w\~\-]+(\.[\w\~\-]+)+\s*$/g;
    	  if(src.search(format) < 0){
    	  	return false;
    	  }
    	  
    	  return true;
    	}
    	
        /**
         * 입력값이 숫자,날짜 구분자(.)로 되어있는지 체크
         * @param obj   Object
         * @return true 숫자,날짜 구분자(.)로 되어있는 경우
         */
    	function lea_com_isNumPeriod(obj){
    		if(obj.value == "" || obj.value == null) return false;
    		if(!isNumPeriod(obj)){
    			 ComShowMessage(ComGetMsg("LEA90016","Period(.)"));
    	    //ComShowMessage("Can only contain numbers or Period(.)");
    	    obj.value="";
    	    obj.focus();
    	    return false;
    		}
    		return true;
    	}

    /**
     * IP를 check한다.
     *
     * @param : emailVal    - validation할 object
     * 예 : lea_com_isEmailAddrStr(formObjemailVal)
     *    
     */
    /*	
    	 function lea_com_isIPStr(obj) {
    		var str = obj.value;
    	  //var format = [\w\-]+(\.\[\w\-]+) ;
    	  if(str.search(format) < 0){
    	  	ComShowMessage("Please enter a valid IP format:xxx.xxx.xxx.xxx");
    	  	return false;
    	  }
    	  
    	  return true;
    	}
    */
    /**
     * enterKey발생시 특정 Event를 실행한다.
     *
     * @param : funcNm    - 실행할 function Name
     * 예 : lea_com_isEmailAddrStr(formObjemailVal)
     *    
     */

        function lea_com_enterKeyEvent(funcNm)
        {
    		if (funcNm == undefined || funcNm == null || funcNm.trim() == '')		return false;
    		if (event.keyCode == 13){ //입력 Key값이 13 = Enter Key
    			eval(funcNm+'()');    //Enter 값을 누르면 Retrieve Btn과 같은 처리
    		}
        }
        
        function lea_com_select(obj){
        	obj.focus();
    		
        	if ( obj.type == "text" || obj.type == "password" || obj.type == "textarea")	obj.select();
        }
        
        /**
          * 입력값이 알파벳,숫자로 되어있는지 체크
          * 오류가 있을 경우 메세지를 표시하고 focus 이동
          * @param obj   Object
          * @return true - 알파벳,숫자만을 포함하고 있는 경우
         */
        function lea_comm_isAlphaNumMessage(obj,len) {
        	//function name change : isAlphaNum ==> ComIsAlphabet(obj,sFlag) 두번째 인자 "n"
            if (!ComIsAlphabet(obj, "n")) {
                //ComShowMessage("Can only contain english letters or numbers");
                ComShowMessage(ComGetMsg("COM12128",obj.desc));
                obj.value = "";
                return false;
            }
            if(obj.value.length > len){
            	//ComShowMessage("Must not be over " + len + " characters long.");
            	ComShowMessage(ComGetMsg("COM12142",obj.desc,len));
            	obj.value = "";
            	return false;
            }
            return true;
        }

        
        /**
          * 입력값이 알파벳,숫자로 되어있는지 체크
          * 오류가 있을 경우 메세지를 표시하고 focus 이동
          * @param obj   Object
          * @return true - 알파벳,숫자만을 포함하고 있는 경우
         */
        function lea_comm_isAlphaMessage(obj,len) {
            if (!ComIsAlphabet(obj)) {
               // ComShowMessage("Can only contain english letters");
            	ComShowMessage(ComGetMsg("LEA90017",obj.desc));
                obj.value = "";
                return false;
            }
            if(obj.value.length > len){
            	//ComShowMessage("Must not be over " + len + " characters long.");
            	ComShowMessage(ComGetMsg("COM12142",obj.desc));
            	obj.value = "";
            	return false;
            }
            return true;
        }

        /**
          * Exe.Year-Month Rev.Year-Month 비교 체크
          * 오류가 있을 경우 메세지를 표시하고 focus 이동
          * @param obj1   Object
          * @param obj2   Object
          * @return true
         */
        
//    		function lea_com_checkExeymRevym(obj1, obj2){
//    			if(obj1.value == "" || obj1.value == null) return false;
//    			if(obj2.value == "" || obj2.value == null) return false;
////    			var day1 = get_Year(obj1.value)	+ "-01-01";
////    			var day2 = get_Year(obj2.value)	+ "-01-01";
//    			
//    	    	//common function name change : getDaysBetween2 ==>> ComGetDaysBetween
//    			if(ComGetDaysBetween(day1, day2) != 0){
//    				ComShowMessage("Please enter equal year "+obj1.desc+" or "+obj2.desc );
//    				obj2.focus();
//    				return false;
//    			}
//    			return true;
//    		}
        /**
         * 입력값이 숫자,대시(-)로 되어있는지 체크
         * @param obj   Object
         * @return true 숫자,대시(-)로 되어있는 경우
         */
    	function lea_com_isNumDash(obj){
    		if(obj.value == "" || obj.value == null) return false;
    		if(!isNumDash(obj)){
    			// ComShowMessage(ComGetMsg("COM12122",obj.desc));
    	    //ComShowMessage("Can only contain numbers or dash(-)");
          ComShowMessage(ComGetMsg("LEA90016","dash(-)"));
    	    obj.value="";
    	    obj.focus();
    	    return false;
    		}
    		return true;
    	}
    		
    		
    		
    	/**
    	 * 해당 Sheet 의 subsum행 여부를 리턴.
    	 *
    	 */
    	function lea_com_isSubSumRow(sheetObj,row){
    		var returnVal = false;
    		var sRow = sheetObj.FindSubSumRow();
    		var arrRow = sRow.split("|");
      	for (i=0; i<arrRow.length-1; i++){ 
      		if(arrRow[i] == row){
      			returnVal = true;
      		}
      	}
    		return returnVal;
    	}	
        /**
          * 입력값이 한글로 되어있는지 체크
          * 오류가 있을 경우 메세지를 표시하고 focus 이동
          * @param obj   Object
          * @return true - 한글을 포함하지 않는 경우
         */
        function lea_comm_isKoreanMessage(obj) {
        	   if (lea_comm_isKorean(obj)) {
               // ComShowMessage("Can not contain korean ");
                obj.value = "";
                return false;
            }
            
            return true;
        }
        
        /**
          * 입력값이 한글로 되어있는지 체크
          * 오류가 있을 경우 메세지를 표시하고 focus 이동
          * @param obj   Object
          * @return true - 한글만을 포함하고 있는 경우
         */

    	function lea_comm_isKorean(obj)
    	{
    	 if ( obj.value == "" ) return false;
    	
    	    var rtnLen = 0 ;
    	 
    	    for (i=0; i<obj.value.length; i++)
    	    {   
    	        // 한글인 경우 길이가 UniCode 값은 10000 이상이다.
    	        if(obj.value.charCodeAt(i) > 10000 )
    	        {
    	         rtnLen++;
    	        }
    	    }
    	    
    	    if ( rtnLen > 0 )
    	     return true;
    	    else
    	     return false;
    	}



//    	function lea_com_setRevToYymm(obj1, obj2, obj3){
//    		
//    		if(obj1.value == "")	return;
//    		
//    		obj2.value = "";
//    		obj2.value = obj1.value.substr(0,4) +'-01' ;	
//    		obj3.value = "";
//    		obj3.value = obj1.value ;	
//    		
//    	}
    	
    	function lea_com_setRevToYymm(obj1, obj2, obj3){
    		
    	      if(obj1.value == "") 
    	          return;
    	          obj2.value = "";
    	          obj2.value =obj1.value.substr(0,4) +'-01' ; 
    	          
    	          if(parseInt(obj1.value.substr(5,7))==4){
    	           obj2.value = (parseInt(obj1.value.substr(0,4))-1+'-')+'12';       
    	          }else if(parseInt(obj1.value.substr(5,7))==3){
    	           obj2.value = (parseInt(obj1.value.substr(0,4))-1+'-')+'11';
    	          }else if(parseInt(obj1.value.substr(5,7))==2){
    	           obj2.value = (parseInt(obj1.value.substr(0,4))-1+'-')+'10';
    	          }else if(parseInt(obj1.value.substr(5,7))==1){
    	           obj2.value = (parseInt(obj1.value.substr(0,4))-1+'-')+'09';
    	          }
    	          
    	          obj3.value = "";
    	          obj3.value =obj1.value ; 
    	         
      }


    	function getPageURL(){
    	
    		var url = window.location+"";
    		var startIndex = url.indexOf('/hanjin/');
    		var endIndex = url.indexOf('.do');
    		url = url.substring(startIndex+8, endIndex);
    	
    		return url;
    	}
    	
    	

    		

    	  /**
         * IB MULTI COMBO 데이터로 변환하기
         * 
         * ex) LeaXml2ComboString(sXml, "code", "name");
         */ 	
    	function LeaXml2ComboString(xmlStr, codeCol, textCol) {
    		var rtnArr = new Array();
    		
    		if (xmlStr == null || xmlStr == '')	return;
    		if (codeCol == null || codeCol == '' || textCol == null || textCol == '')	return;

    		try {
    			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    			xmlDoc.loadXML(xmlStr);

    			var xmlRoot = xmlDoc.documentElement;
    			if (xmlRoot == null) {
    				return;
    			}

    			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
    			if (dataNode == null || dataNode.attributes.length < 3) {
    				return;
    			}

    			var col = dataNode.getAttribute("COLORDER");
    			var colArr = col.split("|");
    			var sep = dataNode.getAttribute("COLSEPARATOR");
    			var total = dataNode.getAttribute("TOTAL");

    			var dataChildNodes = dataNode.childNodes;
    			if (dataChildNodes == null) {
    				return;
    			}
    			
    			var colListIdx = Array();
    			for ( var i = 0; i < colArr.length; i++) {
    				if (colArr[i] == codeCol) {
    					colListIdx[0] = i;
    				}
    				if (colArr[i] == textCol) {
    					colListIdx[1] = i;
    				} 
    			}
    			   
    			var retStr = "";
    			
    			for ( var i = 0; i < dataChildNodes.length; i++) {
    				if (dataChildNodes[i].nodeType != 1) {
    					continue;
    				}
    				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
    				
    				retStr = arrData[colListIdx[0]] + '|'  + arrData[colListIdx[1]];
    				rtnArr.push(retStr);               
    			}
    					               
    		} catch (err) {
    			ComFuncErrMsg(err.message); 
    		}

    		return rtnArr;
    	}	
    	
    	
    	
    	/**
    	  * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
    	  * @param{form} str  Form 객체  
    	  * @param{exElmNms} str   exElmNms값들은 form elemente name으로 구성하지 않을 값들이다. 
    	  */  

    	  function leaFormQueryString(form, exElmNms) {                        
    	      if (typeof form != "object" || form.tagName != "FORM") {
    	          //Msg : Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag. <== 모듈별 Error Msg 등록하여 사용
    	          showMsg("");
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
    	                        if(!checkExcludeElements(form.elements[i].name, exElmNms)){
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

    	      //IB에서 제공하는 컨트롤의 값을 조합한다.
    	      }else{
    	        switch(form.elements[i].classid){
    	          case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":          // IBMaskEdit 경우
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
    	   
    	  function checkExcludeElements(elmNm, exElmNms){
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
    	 



    			