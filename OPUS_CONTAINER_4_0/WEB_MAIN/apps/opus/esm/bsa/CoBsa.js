/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : Bsa.js
*@FileTitle  : BSA 공통 자바스크립트
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	if(msgs == undefined){
		msgs=new Array();
	}
	// BSA 추가 메세지
	msgs['BSA10001']='Please enter correct date.\n\n Format : YYYY-WW';
	msgs['BSA10002']='Please enter {?msg1}.';
	msgs['BSA10003']='{?msg1} can be processed only {?msg2}.';
	msgs['BSA10004']='{?msg1} is invalid PORT.';
	msgs['BSA10005']='There is no data retrieved on {?msg1}.\n\n Please retrieve {?msg1} first.';
	msgs['BSA10006']='Process completed.';
	msgs['BSA10007']='A maximum of {?msg1} weeks can be entered.';
	msgs['BSA10008']='Can not exceed {?msg1}.';
	msgs['BSA10009']='Please enter {?msg1} correctly.\n\n Format : {?msg2}';
	msgs['BSA10010']='Please enter group name to save.';
	msgs['BSA10011']='{?msg2} of {?msg1} should be equal to or less than {?msg3}.';
	msgs['BSA10012']='{?msg2} of {?msg1} should be equal to {?msg3}.';
	msgs['BSA10013']='It differs from number of {?msg1}.';
	msgs['BSA10014']='Please save {?msg1} first.';
	msgs['BSA10015']='Please check {?msg1} first.';
	msgs['BSA10016']='3rd value of {?msg1} differs from {?msg2}.';
	msgs['BSA10017']='Can create after retrieve.';
	msgs['BSA10018']='{?msg1} process has been completed normally.';
	msgs['BSA10019']='Do you want to create BSA with selected data?';
	msgs['BSA10020']='Do you want to create data?';
	msgs['BSA10021']='Do you want to reset data?';
	msgs['BSA10022']='There are {?msg1} data on saved vessel information.\n\n Please check.';
	msgs['BSA10024']='It can not be exceeded by {?msg1} weeks.\n\n Please select {?msg2} data.';
	msgs['BSA10025']='Do you want to execute BSA batch?';
	msgs['BSA10026']='Please select {?msg1}.';
	msgs['BSA10027']='{?msg1} is invalid VVD or has no ETD.';
	msgs['BSA10028']='Do you want to delete the selected data?';
	msgs['BSA10029']='You can delete maximum number in the same group.';
	msgs['BSA10030']='It is impossible to delete under level X.';
	msgs['BSA10031']='It is impossible to delete level X.';
	msgs['BSA10032']='Please select a line with a Route No. when there are more than two Route.';
	msgs['BSA10033']='Do you apply to P/L Chart?' ;
	msgs['BSA10034']='You can only retreive the Sales Office, Sub Ofc 1, Sub Ofc2 Level.' ;
	msgs['BSA10035']='Please choose within the same terminal only.' ;
	msgs['BSA10036']='Do you wish to apply BSA 0 function?';
	msgs['BSA10037']='The data earlier than July 2007 and 27wk 2007 are not available.\nPlease refer to DW, CRM, etc.';
	msgs['BSA10038']='The inquiry period is limited to {?msg1}.';
	msgs['BSA10039']='You can add rows after retrieving data.';
	msgs['BSA10040']='There is no relevant data.';
	msgs['BSA10041']='You are reqeusted to insert proper Port or Lane code to apply Temp P/C.';
	msgs['BSA10042']='Requested Temp Route is alreayd registered.\nPlease check and use actually registered Route.';
	msgs['BSA10043']='{?msg1} is invalid MDM Carrier Code.';
	msgs['BSA10044']='All current BSA data will be deleted.';
	msgs['BSA10045']='The order of the dates seems not to be correct.  Please check VVD again.';
	msgs['BSA10046']='Slot price is missing. Please input "slot price"';
	msgs['BSA10047']='Data was saved successfully.';
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
        if(obj1.maxLength == obj1.value.length &&  keyValue != '9' &&  keyValue != '16' ){          // 역 Tab
			if (obj2.type == "text" ||  obj2.type == "password" || obj2.type == "textarea") {
				obj2.select();
			} else {
    			obj2.focus();
			}
        }
    }
    
    function moveTab1(obj1){
        var keyValue=ComGetEvent("keycode");
        if(obj1.maxLength == obj1.value.length &&  keyValue != '9' &&  keyValue != '16' ){          // 역 Tab
        	if(form.chkPrd.value == "W") {
        		form.txtFmWeek.select();
        	}
        	else if(form.chkPrd.value == "M") {
        		form.txtFmMonth.select();
			}
        }
    }
    /**
     * 영대문자만 입력되도록 함
     *    onKeyPress="onlyEng();"
     */
    function onlyEng(){
    	alert('ex) format="enguponly"');
       
        return true;
    }
    /**
     * 영대문자와 숫자만 입력되도록 함
     *     onKeyPress="onlyEngNumber();"
     */
    function onlyEngNumber(){
    	alert('ex) format="enguponly"');
        return true;
    }
    /**
     * 숫자와 dash(-)만 입력 가능하도록 한다
     */
    function onlyNumberDash(event){
    	alert('ex)  format="num" otherchar="-"');
        return true;
    }

   
    
 
   
  /**
   * -n일자를 구함
   * str : YYYYMMDD형태의 일자
   * offset : 계산할 수 = ...,2,1,0,-1,-2,...
   *
   * Author : kevin.kim (2006.12.18)
   */
	function getOffsetDate(str,offset)
	{
    if(str.length != 8) {
    	return
    }
    var yyyy=str.substring(0,4);
    var mm=str.substring(4,6);
    var dd=str.substring(6,8);
		plann=eval(offset);         //+ 몇일
		var dayStr=mm+"-"+dd+"-"+yyyy;
		var Meet=new Date(dayStr);
    //annitime = Meet.getTime()+plann*1000*3600*24-1
    annitime=Meet.getTime() + plann * 1000 * 3600 * 24;
    var anniday=new Date();
    anniday.setTime(annitime);
    var plusyear=(anniday.getFullYear()<100)?"19"+anniday.getFullYear():anniday.getFullYear();
    var plusmonth=anniday.getMonth()+1;
    var plusday=anniday.getDate();
    return plusyear + "-" + fillZero(plusmonth,2,'0','left') + "-" + fillZero(plusday,2,'0','left') ;
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
	var str = String(str);
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
    		ComShowCodeMessage('BSA10009','Year','YYYY'); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
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
    		ComShowCodeMessage('BSA10009','Week','WW'); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
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
    		ComShowCodeMessage('BSA10009','Month','MM'); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
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
//  2014.12.30 김용습 - 왼쪽 시트 다운엑셀 용
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
    	sFeature=sFeature + "dialogWidth:302px;"
    	sFeature=sFeature + "center:yes;"
    	sFeature=sFeature + "resizable:no;"
    	sFeature=sFeature + "scroll:no;"
    	sFeature=sFeature + "status:no;"
    	setTimeout( function () {
    		ComOpenPopup("ESM_BSA_3002.do?sheetidx="+sheetIdx, 350, 200, "callBackExcelDown","0,0", true);
    	 } , 100);
    }
    
//    2014.12.30 김용습 - 오른쪽 시트 다운엑셀 용
    function selectDownExcelMethod2(sheetObj, sheetIdx){
    	if(sheetObj.RowCount()== 0){
    		ComShowCodeMessage("COM132501");
    		return "NODATA";
    	}

    	if (sheetIdx==undefined || sheetIdx==null) {
    		sheetIdx="";
    	}
    	
    	var sFeature="";
    	sFeature=sFeature + "dialogHeight:230px;"
    	sFeature=sFeature + "dialogWidth:302px;"
    	sFeature=sFeature + "center:yes;"
    	sFeature=sFeature + "resizable:no;"
    	sFeature=sFeature + "scroll:no;"
    	sFeature=sFeature + "status:no;"
    	setTimeout( function () {
    		ComOpenPopup("ESM_BSA_3002.do?sheetidx="+sheetIdx, 350, 200, "callBackExcelDown2","0,0", true);
    	 } , 100);
    }
    
//  2014.12.30 김용습 - 왼쪽 시트 다운엑셀 용
    function callBackExcelDown(execType){
   	 	$(document).find(".opus_design_grid").addClass("excelCellColor");
   	 	callBackExcelMethod(execType);
        setTimeout(function(){
           $(document).find(".opus_design_grid").removeClass("excelCellColor");
       },10);

   }
    
//  2014.12.30 김용습 - 오른쪽 시트 다운엑셀 용
    function callBackExcelDown2(execType){
   	 	$(document).find(".opus_design_grid").addClass("excelCellColor");
   	 	callBackExcelMethod2(execType);
        setTimeout(function(){
           $(document).find(".opus_design_grid").removeClass("excelCellColor");
       },10);

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
   
    /******************************************************************************************************/
    /**  Cost_yrmon, Sls_yrmon 으로 인해 화면의 컨트롤응 공통화합                                             */
    /******************************************************************************************************/
    /**
     * Month/Week 에 따라서 화면에 컨트롤을 변경시켜준다.
     */
    function chkWM(param1, param2){
    	if(param1 == 'W'){
		    document.all.div_week.style.display="inline";
			document.all.div_month.style.display="none";
			setPeriod(document.form.txtToWeek);
    	} else {
		    document.all.div_week.style.display="none";
			document.all.div_month.style.display="inline";
			if(param2 == '1') {
			    setPeriod(document.form.txtToMonth);
			} else {
			    setPeriod(document.form.txtMonth);
			}
    	}
    }
    /**
	  * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
	  * @param{form} str  Form 객체  
	  * @param{chkElmNms} str   chkElmNms값들만 form elemente name으로 구성한다. 
	  */  
	  function bsaFormString(form, chkElmNms) {
		  var checkRequired;
			 if (typeof form != "object") {
				 	ComShowMessage("");
					return "";
			    }


		    if (checkRequired == null) checkRequired = false;

		    var name = new Array(form.elements.length);
		    var value = new Array(form.elements.length);
		    var j = 0;
		    var plain_text = "";

		    //사용가능한 컨트롤을 배열로 생성한다.
		    len = form.elements.length;
		    for (i = 0; i < len; i++) {
		    	
		        var prev_j = j;
		        switch (form.elements[i].type) {
		            case "button":
		            case "reset":
		            case "submit":
		                break;
		            case "radio":
		            case "checkbox":
		                if (form.elements[i].checked == true) {
		                    name[j] = IBS_getName(form.elements[i]);
		                    value[j] = form.elements[i].value;
		                    j++;
		                }
		                break;
		            case "select-one":
		                name[j] = IBS_getName(form.elements[i]);
		                var ind = form.elements[i].selectedIndex;
		                if (ind >= 0) {

		                    value[j] = form.elements[i].options[ind].value;

		                } else {
		                    value[j] = "";
		                }
		                j++;
		                break;
		            case "select-multiple":
		                name[j] = IBS_getName(form.elements[i]);
		                var llen = form.elements[i].length;
		                var increased = 0;
		                for (k = 0; k < llen; k++) {
		                    if (form.elements[i].options[k].selected) {
		                        name[j] = IBS_getName(form.elements[i]);

		                        value[j] = form.elements[i].options[k].value;

		                        j++;
		                        increased++;
		                    }
		                }
		                if (increased > 0) {
		                    j--;
		                } else {
		                    value[j] = "";
		                }
		                j++;
		                break;
		            default:
		            	 if(form.elements[i].value.length >0 ) {
			            	   if(chkElmNms!=null && chkElmNms!='' && chkElmNms!=undefined){
			            		   if(checkExcludeElements(form.elements[i].name, chkElmNms)){
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

		    //QueryString을 조합한다.
		    for (i = 0; i < j; i++) {
		        if (name[i] != '') plain_text += name[i] + "=" + encodeURIComponent(value[i]) + "&";
		    }

		    //마지막에 &를 없애기 위함
		    if (plain_text != "") plain_text = plain_text.substr(0, plain_text.length - 1);
		    return plain_text;
		}

	  function checkExcludeElements(elmNm, chkElmNms){
		  var arr_chkElmNms='';
		  var rstTF=false;
		  try{
		    if(chkElmNms != null && chkElmNms != '' && chkElmNms != undefined){
		    	arr_chkElmNms=chkElmNms.split(',');
			     for(var i=0; i < arr_chkElmNms.length; i++){
			      if(arr_chkElmNms[i] != "") {
			       if(elmNm==null || elmNm=='' || elmNm==undefined){
			        rstTF=true;
			        break;
			       }else if(elmNm == arr_chkElmNms[i]){
			        rstTF=true;
			        break;
			       }
			      }
			     }	     
		     }
		}catch(e){
		  rstTF=true;
		}	   
	   return rstTF;
	  }
	/** fromString생성에 필요한 인자값을 지정하여 화면마다필요한 값을 지정한다.
	 * BSAManageBC 사용 인자들 
	*/
	 function getParam(curPgmNo, optType){
		 var sType='';
		 var rtnStr='';
		 var param='';	
		 var defaultParam='';
		 if(optType ==null || optType =="" || optType ==undefined ){
			  defaultParam='f_cmd,txtSDate,txtEDate,cobTrade,cobLane,cobDir,rdoOp_cd';
		 }else{
			  sType=optType;
			  defaultParam='f_cmd';
		 }
//							 'itrkey1,'+ 
//							 'itrkey2,'+
//							 'rdoOp_cd,'+
//							 'rdoType,'+
//							 'rdoType2,'+
//							 'cobCarrier,'+
//							 'crr_cd,'+
//							 'header2,'+
//							 'jHeader,'+
//							 'sHeader,'+
//							 'bsa_op_jb_cd,'+
//							 'bsa_op_jb_cd2,'+
//							 'rdoOp_jb_cd,'+
//							 'rdoOp_jb_cd2';
		 switch (curPgmNo){
		 case "ESM_BSA_0021":
			 if(sType=='S'){
				 param=',rdoOp_cd,bsa_op_jb_cd,bsa_op_jb_cd2,jHeader,sHeader';
			 }else{
				 param=',rdoType';
			 }
			 break;
		 case "ESM_BSA_0023":
			 param=',bsa_op_cd,crr_cd';
			 break;
		 case "ESM_BSA_0024":
			 if(sType=='S'){
				 param=',rdoOp_cd,rdoOp_jb_cd,rdoOp_jb_cd2,jHeader,sHeader';
			 }else{
				 param=',rdoOp_jb_cd,rdoOp_jb_cd2';
			 }
			 break;
		 case "ESM_BSA_0026":
			 param=',rdoType,cobCarrier';
			 break;
		 case "ESM_BSA_0028":
			 param=',rdoType,rdoType2,bsa_op_jb_cd,crr_cd,header2';
			 break;
		 case "ESM_BSA_0120":
			 param=',bsa_op_cd';
			 break;
		 case "ESM_BSA_0122":
			 param=',pBsa_fm_dt,'+
					 'pBsa_to_dt,'+ 
					 'pTrd_cd,'+
					 'pRlane_cd,'+
					 'pDir_cd,'+
					 'pVop_cd,'+
					 'pVsl_capa,'+
					 'pBsa_seq,'+
					 'pBsa_op_jb_cd,'+
					 'pBsa_op_cd';
			 break;
		 case "ESM_BSA_0162":
			 if(sType=='S'){
				 param=',bsa_op_jb_cd,crr_cd';
			 }else{
				 param=',bsa_op_jb_cd,crr_cd';
			 }
			 break;
		 case "ESM_BSA_0172":
			 if(sType=='S'){
				 param=',header2,rdoType';
			 }else{
				 param=',header2,rdoType';
			 }
			 break;
		 }
		 rtnStr=defaultParam+param;
		 return rtnStr;
	 }
	 /** fromString생성에 필요한 인자값을 지정하여 화면마다필요한 값을 지정한다.
		 * SPCManage 사용 인자들 
		*/
		 function getParam2(curPgmNo, optType){
			 var sType='';
			 var rtnStr='';
			 var param='';	
			 var defaultParam='';
			 if(optType ==null || optType =="" || optType ==undefined ){
				  defaultParam='f_cmd,chkPrd,txtYear,txtFmMonth,txtToMonth,txtFmWeek,txtToWeek,'
								 +'cobTrade,cobLane,cobDir,cobIOC,txtVsl_cd,txtSkd_voy_no,txtDir_cd';
			 }else{
				  sType=optType;
				  defaultParam='f_cmd';
			 }
			 switch (curPgmNo){
			 case "ESM_BSA_0030":
				 if(sType=='S'){
					 param='';
				 }else{
					 param=',rdoPerf';
				 }
				 break;
			 case "ESM_BSA_0032":
				 if(sType=='S'){
					 param='';
				 }else{
					 param=',rdoCode,cobCarrier';
				 }
				 break;
			 case "ESM_BSA_0104":
				 if(sType=='S'){
					 param=',header,rdoOpJob';
				 }else{
					 param=',header,rdoOpJob';
				 }
				 break;
			 case "ESM_BSA_0121":
				 if(sType=='S'){
					 param=',pPort_etd_dt,pTrd_cd,pRlane_cd,pVsl_cd,pSkd_voy_no,pDir_cd,sRow,pBsa_op_jb_cd';
				 }else{
					 param=',pPort_etd_dt,pTrd_cd,pRlane_cd,pVsl_cd,pSkd_voy_no,pDir_cd,sRow,pBsa_op_jb_cd';
				 }
				 break;
			 case "ESM_BSA_0143":
				 param=',isExcludZero';
				 break;			 
			 }
			 rtnStr=defaultParam+param;
			 return rtnStr;
		 }
	/**
	 * Year, Fm_month, To_month, Fm_week, To_week
	 * 위 항목을 화면에 디스플레이 함
	 *
	 * html 부분에 넣어 준다.
	 * <script language="javascript">initPeriod();</script>
	 */
	 function initPeriod(){
		    document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
	        document.write("\n <table border='0'> ");
	        document.write("\n 	<tr class='h23'> ");
	        document.write("\n 		<th width='30px'>W/M</th> ");
	        document.write("\n 		<td width='160px'> ");
	        document.write("\n 			<div id='div_wm' style='display:inline;border:solid 0;'> ");
	        document.write("\n 			<input type='radio' value='W' name='chkPrd' id='chkPrd_01' class='trans' onClick=\"chkWM('W','1');\" checked><label for='chkPrd_01'><strong> Week</strong></label>");
	        document.write("\n 			<input type='radio' value='M' name='chkPrd' id='chkPrd_02' class='trans' onClick=\"chkWM('M','1');\"><label for='chkPrd_02'><strong> Month</strong></label>");
	        document.write("\n 			</div> ");
	        document.write("\n 		</td> ");
	        document.write("\n 		<th width='25px' class='sm'>Year</th> ");
	        document.write("\n 		<td width='60px'><input type='text' style='width:40px;text-align:center;' class='input1' name='txtYear' maxlength='4' onKeyPress='ComKeyOnlyNumber(window);' onKeyUp='moveTab1(this);' onChange='setPeriod(this);'></td> ");
	        document.write("\n 		<td class='sm'> ");
	        document.write("\n 		    <div id='div_month' style='display:none;border:solid 0;width:130px;height:16px'> ");
	        document.write("\n 		    Month&nbsp;");
	        document.write("\n 			<input type='text' style='width:30px;text-align:center;' class='input1' name='txtFmMonth' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"fillSpace(this, 2, '0', 'left');\" onKeyUp='moveTab(this, txtToMonth);' onChange=\"fillSpace(this, 2, '0', 'left');setPeriod(this);\" >&nbsp;&nbsp;~&nbsp; ");
	        document.write("\n 			<input type='text' style='width:30px;text-align:center;' class='input1' name='txtToMonth' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"fillSpace(this, 2, '0', 'left');\" onChange=\"fillSpace(this, 2, '0', 'left');setPeriod(this);\"> ");
	        document.write("\n 			</div> ");
	        document.write("\n 		    <div id='div_week' style='display:inline;border:solid 0;width:130px;height:16px'> ");
	        document.write("\n 		    Week&nbsp;");
	        document.write("\n 			<input type='text' style='width:30px;text-align:center;' class='input1' name='txtFmWeek' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"fillSpace(this, 2, '0', 'left');\" onKeyUp='moveTab(this, txtToWeek);' onChange=\"fillSpace(this, 2, '0', 'left');setPeriod(this);\" >&nbsp;&nbsp;~&nbsp; ");
	        document.write("\n 			<input type='text' style='width:30px;text-align:center;' class='input1' name='txtToWeek' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"fillSpace(this, 2, '0', 'left');\" onKeyUp=\"ComKeyEnter('LengthNextFocus');\" onChange=\"fillSpace(this, 2, '0', 'left');setPeriod(this);\"> ");
	        document.write("\n 			</div> ");
	        document.write("\n 		</td> ");
	        document.write("\n 		<th class='sm'><div id='div_period'></div></th> ");
	        document.write("\n 	</tr> ");
	        document.write("\n </table> ");
	        document.write("\n<!--  -------------------------------------------------------------------------------------------- --> ");
	    }
	 /**
		 * Year, Fm_month, To_month, Fm_week, To_week
		 * 위 항목을 화면에 디스플레이 함
		 * POP UP 용으로 만듬 
		 * html 부분에 넣어 준다.
		 * <script language="javascript">initPeriod();</script>
		 */
		 function initPeriod2(){
			    document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
		        document.write("\n <table border='0'> ");
		        document.write("\n 	<tr class='h23'> ");
		        document.write("\n 		<th width='50px'>&nbsp;&nbsp;W/M</th> ");
		        document.write("\n 		<td width='140px'> ");
		        document.write("\n 			<div id='div_wm' style='display:inline;border:solid 0;'> ");
		        document.write("\n 			<input type='radio' value='W' name='chkPrd' class='trans' onClick=\"chkWM('W','1');\" checked>&nbsp;Week ");
		        document.write("\n 			<input type='radio' value='M' name='chkPrd' class='trans' onClick=\"chkWM('M','1');\">&nbsp;Month ");
		        document.write("\n 			</div> ");
		        document.write("\n 		</td> ");
		        document.write("\n 		<th width='25px' class='sm'>Year</th> ");
		        document.write("\n 		<td width='60px'><input type='text' style='width:40px;text-align:center;' class='input1' name='txtYear' maxlength='4' onKeyPress='ComKeyOnlyNumber(window);' onKeyUp='moveTab1(this);'  onChange='setPeriod(this);'></td> ");
		        document.write("\n 		<td class='sm'> ");
		        document.write("\n 		    <div id='div_month' style='display:none;border:solid 0;width:130px;height:16px'> ");
		        document.write("\n 		    Month&nbsp;");
		        document.write("\n 			<input type='text' style='width:30px;text-align:center;' class='input1' name='txtFmMonth' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"fillSpace(this, 2, '0', 'left');\" onKeyUp='moveTab(this, txtToMonth);' onChange='setPeriod(this);' >&nbsp;&nbsp;~&nbsp; ");
		        document.write("\n 			<input type='text' style='width:30px;text-align:center;' class='input1' name='txtToMonth' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"fillSpace(this, 2, '0', 'left');\" onChange=\"fillSpace(this, 2, '0', 'left');setPeriod(this);\"> ");
		        document.write("\n 			</div> ");
		        document.write("\n 		    <div id='div_week' style='display:inline;border:solid 0;width:130px;height:16px'> ");
		        document.write("\n 		    Week&nbsp;");
		        document.write("\n 			<input type='text' style='width:30px;text-align:center;' class='input1' name='txtFmWeek' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"fillSpace(this, 2, '0', 'left');\" onKeyUp='moveTab(this, txtToWeek);' onChange='setPeriod(this);' >&nbsp;&nbsp;~&nbsp; ");
		        document.write("\n 			<input type='text' style='width:30px;text-align:center;' class='input1' name='txtToWeek' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"fillSpace(this, 2, '0', 'left');\" onKeyUp=\"ComKeyEnter('LengthNextFocus');\" onChange=\"fillSpace(this, 2, '0', 'left');setPeriod(this);\"> ");
		        document.write("\n 			</div> ");
		        document.write("\n 		</td> ");
		        document.write("\n 		<th class='sm'><div id='div_period'></div></th> ");
		        document.write("\n 	</tr> ");
		        document.write("\n </table> ");
		        document.write("\n<!--  -------------------------------------------------------------------------------------------- --> ");
		    }
		 /**
		  * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
		  * 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
		  * <b>Example :</b>
		  * 
		  * <pre>
		  * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
		  * var arrData = ComXmlString(xmlStr, nm);
		  * 
		  * </pre>
		  * 
		  * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
		  * @param {string} Text컬럼명.
		  * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
		  */
		 function ComXmlString(xmlStr, codeCol) {
		 	var rtnArr=new Array();
		 	if (xmlStr == null || xmlStr == "") {
		 		return rtnArr;
		 	}
		 	if (codeCol == null || codeCol == "") {
		 		return rtnArr;
		 	}
		 	try {
		          var xmlDoc = ComGetXmlDoc(xmlStr);
		          if (xmlDoc == null) return;
		          var xmlRoot = xmlDoc.documentElement;
		          
		 		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		 		if (dataNode == null || dataNode.attributes.length < 3) {
		 			return rtnArr;
		 		}
		 		var col=dataNode.getAttribute("COLORDER");
		 		var colArr=col.split("|");
		 		var sep=dataNode.getAttribute("COLSEPARATOR");
		 		var total=dataNode.getAttribute("TOTAL");
		 		var dataChildNodes=dataNode.childNodes;
		 		if (dataChildNodes == null) {
		 			return rtnArr;
		 		}
		 		var colListIdx=Array();
		 		for ( var i=0; i < colArr.length; i++) {
		 			if (colArr[i] == codeCol) {
		 				colListIdx[0]=i;
		 			}
		 		}
		 		var sCode="";
		 		for ( var i=0; i < dataChildNodes.length; i++) {
		 			if (dataChildNodes[i].nodeType != 1) {
		 				continue;
		 			}
		 			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
		 			sCode += arrData[colListIdx[0]];
		 			if (i != dataChildNodes.length - 1) {
		 				sCode += "|";
		 			}
		 		}

				if(sCode.length > 0 &&  sCode.slice(-1) == "|"){
					sCode = sCode.substring(0,sCode.length-1)
				}
		 		rtnArr.push(sCode);
		 	} catch (err) {
		 		ComFuncErrMsg(err.message);
		 	}
		 	return rtnArr;
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
		     */
		    function comSetIBCombo(sheetObj, sXml, title, iBlank, sCol,iRow, dCode, dText, bFlag, addAll){
		        var showCol=0;
		        if (ComGetTotalRows(sXml) == "0") return;
		        if (bFlag == undefined || bFlag == ""){
		            bFlag=false;
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
		        var arrData=ComXml2ComboString(sXml, "code", "name");
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
	        	var addAllCode="";
	        	var addAllName="";
		        if(addAll == true){
		        	addAllCode="A|";
		        	addAllName="ALL|";
		        }
		        if(iBlank){
		            arrData[0]=" |" + arrData[0];
		            arrData[1]=" |" + arrData[1];
		        }
		        if (arrData != null){
		        	if (iRow == 0){
		        		sheetObj.SetColProperty(title, {ComboText:addAllName+arrData[1], ComboCode:addAllCode+arrData[0]} );
		        	}else{
		        		sheetObj.CellComboItem(iRow,title, {ComboText:addAllName+arrData[1], ComboCode:addAllCode+arrData[0]} );
		        	}
		        }
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
		        var val = obj.value;
		        var fillString = "";

		        if(val.length>0){
		            for(i=0;i<(spaceNum - val.length); i++){
		                fillString = fillString + spaceStr;
		            }
		        }

		        if(flag == "left"){
		            obj.value = fillString + val;
		        } else if(flag == "right"){
		            obj.value = val + fillString;
		        }
		    }