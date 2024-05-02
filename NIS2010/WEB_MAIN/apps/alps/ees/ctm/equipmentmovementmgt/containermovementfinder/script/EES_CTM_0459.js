/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1949.js
*@FileTitle : Load Factor by Trade-RD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.28 우경민
* 1.0 Creation
=========================================================*/

	// 공통전역변수
	var docObjects = new Array();
	var sheetCnt = 0;

	var rdObjects = new Array();
	var rdCnt = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject 	= docObjects[0];
         var sheetObject1 = docObjects[1];
         var sheetObject2 = docObjects[2];

         /*******************************************************/
         var formObject = document.form;

         var rdObject = rdObjects[0];

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {

				case "btn_close":
					window.close();
	        break;

				case "btng_print":
					rdObject.PrintDialog();
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
       	rdOpen();
		//rdObjects[0].PrintDialog();
    }



     /**
     * print화면 오픈
     * print화면 오픈
     * print할수 있는 화면 오픈
     */
	function rdOpen(){

		var fromObj = new Array();
		var rdObj = new Array();

        fromObj = document.form;                            // RD 로 보내기 위해 배열로담는다

        cntr_no = opener.document.form.p_cntrno.value
        chk_dgt = opener.document.form.check_digit.value
        tpsz_cd = opener.document.form.ctnr_tpsz_cd.value
        p_date1 = opener.document.form.p_date1.value
        p_date2 = opener.document.form.p_date2.value

        usr_id  = opener.document.form.user_id.value;
        ofc_cd  = opener.document.form.ofc_cd.value;
        cntCd   = opener.document.form.cnt_cd.value;

		rdObjects[0].AutoAdjust = true;
//		rdObjects[0].HideToolbar();
//		rdObjects[0].HideStatusbar();
		rdObjects[0].ViewShowMode(0);
		if (cntCd == 'US' )
			param = "/rpaper [LETTER] /rp [" + cntr_no + chk_dgt + "][" +chk_dgt + "][" + p_date1 + "][" + p_date2 + "][" + tpsz_cd + "][" + usr_id + "][" + ofc_cd + "]";
		else
			param = "/rpaper [A4] /rp [" + cntr_no + chk_dgt + "][" +chk_dgt + "][" + p_date1 + "][" + p_date2 + "][" + tpsz_cd + "][" + usr_id + "][" + ofc_cd + "]";
		
		//param = "/rp [" + cntr_no + chk_dgt + "][" +chk_dgt + "][" + p_date1 + "][" + p_date2 + "][" + tpsz_cd + "][" + usr_id + "][" + ofc_cd + "]";
		rdObjects[0].setbackgroundcolor(255,255,255);
		rdObjects[0].SetPageLineColor(255,255,255);
		rdObjects[0].FileOpen(RD_path+'apps/alps/ees/ctm/equipmentmovementmgt/containermovementfinder/report/EES_CTM_0459.mrd', RDServer+param);
		//rdObjects[0].FileOpen('http://localhost:7001/hanjin/apps/alps/ees/ctm/equipmentmovementmgt/containermovementfinder/report/EES_CTM_0459.mrd', param);
	}