/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0071.js
*@FileTitle : EQ Receivable Charge Summary by Lessor & Month
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
  
   	/* developer job */
	// common global variables
	var docObjects = new Array();
	var sheetCnt = 0;
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */
	document.onclick = processButtonClick;
	
	/* Event handler processing by button name */
    function processButtonClick(){
         /**********/
         var sheetObject 	= docObjects[0];
      
         /*******************************************************/
         var formObject = document.form; 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {				
				case "btn_close":
					ComClosePopup(); 
	        break;

				case "btng_print":					
					viewer.print({isServerSide:true});
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
                errMsg = getMsg("TES22506" );
                showErrMessage(errMsg);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
     */
    function loadPage() {
       	rdOpen();	
		//viewer.print({isServerSide:true})();
    }

    /**
     * print화면 오픈
     * print화면 오픈
     * print할수 있는 화면 오픈
     */
	function rdOpen(){		
		var sXml="";
		var i=0;
		var j=0;
		var opener_obj=window.dialogArguments;
		if (!opener_obj) {
			opener_obj=parent; 
		}
		var opener_sheet_obj1=opener_obj.sheet1;
		var fromObj=new Array();
		var rdObj=new Array();
		fromObj[1]=document.form; // putting in list to send to RD
		rdObj[0]=opener_sheet_obj1;
         
        sXml = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
		
		sheetCnt = 1;
		//i = 시트 카운트,
		for(i=0;i<1;i++){
			sheetCnt = i+1;
			if(rdObj[i].RowCount() ==0){
				sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
 				for(j=0;j<=rdObj[i].LastCol;j++){
					sXml +="<TD></TD>";
 				}
				sXml +="</TR></DATA></SHEET"+sheetCnt+">";
			}else{
				sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt); 					
			}			
		}	
		var period_stdt = opener_obj.document.form.period_stdt.value;
		var period_eddt = opener_obj.document.form.period_eddt.value;
		var payable     = opener_obj.document.form.payable.value;
		var tysz        = opener_obj.document.form.tysz.value;
		var arrTpsz     = tysz.replaceStr("|", ",").split(",");
		payable_text    = "";
		if(payable == "T"){
        	payable_text = "Total Amount";	
        }else{
        	payable_text = "S/O Amount";
        }
		sXml +="<ETC>" ;  
		sXml +="<PERIOD>" + period_stdt + " ~ " + period_eddt + " (" + payable_text + ") " + "</PERIOD>" ; 

        var j = 0;
		for(var i = 0 ; i < arrTpsz.length  ; i++ ){		    
			j = i + 1;
			if(j < 10){
			    sXml +="<TITLE0" + j + ">"  + arrTpsz[i] +  "</TITLE0" + j + ">";
		    }else{
			    sXml +="<TITLE" + j + ">"  + arrTpsz[i] +  "</TITLE" + j + ">";
		    }
		}
		sXml +="</ETC>" ;		
		sXml +="</SHEET>";

		if ( rdObj[0].RowCount()  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
		{
		    errMsg = 'No data found.';
		    showErrMessage(errMsg);
		    return;
		}
	
		viewer.setRData(sXml);
	  viewer.openFile(RD_path+'apps/opus/ees/lse/containerrentalcost/payablerentalcost/report/EES_LSE_0071.mrd',RDServer, {timeout:1800});
	}

	/* end of developer job */