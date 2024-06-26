﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0108.js
*@FileTitle  : S/C Performance Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    //  ===================================================================================
    //  전역변수
    //  ===================================================================================
    //  공통전역변수
    //  컬럼변수
    //  업무전역변수
    var gBefRdoSummaryType="S";
    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /** 
     * IBMultiCombo Object를 comboObjects 배열에 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} combo_obj : IBMultiCombo Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
    }
    
    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function loadPage() {
        var form=document.form;	
        //html컨트롤 이벤트초기화
        axon_event.addListenerForm('click', 'obj_click', form);	 
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
    
    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
    document.onclick=processButtonClick;
    /** 
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function processButtonClick(){
        var form=document.form;
        var subForm=subframe.document.form;
        var rdoDateObj=form.rdoDate;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                case "btn_DoJob":
                    subframe.mainCallButtonClick(srcName);
                    break;
                case "btn_retrieve":
                    subframe.mainCallButtonClick(srcName);
                    break;
                case "btn_bl_list":
                    subframe.mainCallButtonClick(srcName);
                    break;
                case "btn_downexcel":
                    subframe.mainCallButtonClick(srcName);
                    break;
            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    
    /** 
     * 0108_02화면에서 Type을 변경 후 Type변수에 변경된 값을 Setting한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 공백진
     * @version 2009.11.24
     */ 
    function setRdoSummaryType(){
        gBefRdoSummaryType=form.rdoSummaryType[1].value; 
    }
    
    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    /**
     * Object 의 Onclick 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */
    function obj_click(event){
    	var form=document.form;
        
    	if(event.srcElement != null) {
        	var obj= event.srcElement;
        } else {
        	var obj= event.target;
        }
        
        switch(ComGetEvent("name")){
            case "rdoSummaryType":
                if(gBefRdoSummaryType == obj.value ) return;	 		
                if(obj.value == "D") {
                    form.action="ESM_PRI_0108_02.do";
                    form.target="subframe";
                    form.submit();
                }else{
                    form.action="ESM_PRI_0108_01.do";
                    form.target="subframe";
                    form.submit();
                }
                gBefRdoSummaryType=obj.value; 
                break;
        }
    }
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    //  ===================================================================================
    //  서버 조회/저장
    //  ===================================================================================
