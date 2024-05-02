/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0112HTMLAction.java
*@FileTitle : Expense Plan Creation by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnDtlVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnHdrVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.RepairExpensePlanGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.RepairExpensePlanINVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.Screen0112VO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.planmanage 화면을 통해 서버로 전송되는 HTML DOM 
 *   객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PlanManageSC로 실행요청<br>
 * - PlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author chung young hun
 * @see PlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0112HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0112HTMLAction 객체를 생성
	 */
	public EES_MNR_0112HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0112Event event = new EesMnr0112Event();
		RepairExpensePlanGRPVO  repairExpensePlanGRPVO    = new RepairExpensePlanGRPVO();
		RepairExpensePlanINVO   repairExpensePlanINVO     = new RepairExpensePlanINVO();
		repairExpensePlanINVO = (RepairExpensePlanINVO)getVO(request, RepairExpensePlanINVO.class);
		
		repairExpensePlanINVO.setMnrPlnOfcCd(request.getParameter("combo1"));
		repairExpensePlanINVO.setMnrOfcCd(request.getParameter("combo2"));
		repairExpensePlanINVO.setMnrPlnFlg(nvl(request.getParameter("mnr_pln_flg")));
		repairExpensePlanINVO.setHoofc(nvl(request.getParameter("hoofc")));
		repairExpensePlanINVO.setDelall(request.getParameter("delall"));
		repairExpensePlanGRPVO.setRepairExpensePlanINVO(repairExpensePlanINVO);


		
		if(command.isCommand(FormCommand.MULTI)) {
			//screenvo를 먼저 생성한다.   화면용 vo가 존재한다.
			Screen0112VO[] sheet1 = (Screen0112VO[])getVOs(request, Screen0112VO.class, "sheet1_");
			Screen0112VO[] sheet2 = (Screen0112VO[])getVOs(request, Screen0112VO.class, "sheet2_");
			CustomMnrPlnHdrVO[]  hdrvos   = null;
			CustomMnrPlnDtlVO[]  dtlvos   = null;
			

			if(sheet1 != null){
				//Plan Office가 SELCON이면 Sheet2의  office를 hdrvos에 넘긴다.
				if(request.getParameter("combo1").equals("SELCON") && sheet2 != null ){
					hdrvos  =  doMakeHdrVO2(sheet1, sheet2, repairExpensePlanINVO);
					repairExpensePlanGRPVO.setCustomMnrPlnHdrVOS(hdrvos);
				} else {
					hdrvos  =  doMakeHdrVO(sheet1, repairExpensePlanINVO);
					repairExpensePlanGRPVO.setCustomMnrPlnHdrVOS(hdrvos);
				}
				dtlvos   =  doMakeDtlVO(sheet1, sheet2, repairExpensePlanINVO, request.getParameter("mnr_pln_yr"));
				repairExpensePlanGRPVO.setCustomMnrPlnDtlVOS(dtlvos);
			
			}
	
		}
		
        event.setRepairExpensePlanGRPVO(repairExpensePlanGRPVO);
		request.setAttribute("Event", event);

		return  event;
	}
	
	
	/**
	 * 화면에서 넘어온 그리드 Hdr데이터를 DB데이터 구조에 맞도록 변환해주는 메소드
	 * 
	 */
    private CustomMnrPlnHdrVO[] doMakeHdrVO(Screen0112VO[] sheet1, RepairExpensePlanINVO   repairExpensePlanINVO ){
    	int arrSize = sheet1.length;
    	CustomMnrPlnHdrVO[] hdrArr = new CustomMnrPlnHdrVO[arrSize];
    	CustomMnrPlnHdrVO   hdr    = new CustomMnrPlnHdrVO();
		hdr.setMnrPlnFlg(repairExpensePlanINVO.getMnrPlnFlg());
		hdr.setIbflag(sheet1[0].getIbflag());
		hdr.setMnrPlnYr(repairExpensePlanINVO.getMnrPlnYr());
		hdr.setMnrPlnOfcCd(repairExpensePlanINVO.getMnrPlnOfcCd());
		hdr.setCtrlOfcCd(sheet1[0].getOffice());
		hdr.setMnrPlnSeq(sheet1[0].getMnrPlnSeq());
		hdrArr[0] = hdr;
	    	
    	return hdrArr;
    }
    
	/**
	 * Plan Office가 SELCON일때, 화면에서 넘어온 그리드 Hdr데이터를 DB데이터 구조에 맞도록 변환해주는 메소드
	 * 
	 */
    private CustomMnrPlnHdrVO[] doMakeHdrVO2(Screen0112VO[] sheet1, Screen0112VO[] sheet2, RepairExpensePlanINVO repairExpensePlanINVO){
    	
    	int arrSize = sheet2.length+1;
    	
    	//CustomMnrPlnHdrVO[] hdrArr = new CustomMnrPlnHdrVO[arrSize];
    	CustomMnrPlnHdrVO[] hdrArr = null;
    	CustomMnrPlnHdrVO   hdr    = new CustomMnrPlnHdrVO();
    	
    	List<CustomMnrPlnHdrVO> hdrArrList = new ArrayList<CustomMnrPlnHdrVO>();
    	
    	
    	hdr.setMnrPlnFlg(repairExpensePlanINVO.getMnrPlnFlg());
		hdr.setIbflag(sheet1[0].getIbflag());
		hdr.setMnrPlnYr(repairExpensePlanINVO.getMnrPlnYr());
		hdr.setMnrPlnOfcCd(repairExpensePlanINVO.getMnrPlnOfcCd());
		hdr.setCtrlOfcCd(sheet1[0].getOffice());
		hdr.setMnrPlnSeq(sheet1[0].getMnrPlnSeq());
		hdr.setMnrPlnGrpNo(sheet1[0].getMnrPlnGrpNo());

		hdrArrList.add(hdr);
		//hdrArr[0] = hdr;
		
		for(int i = 1; i < arrSize; i++){

			if(!"SELCON".equals(sheet2[i-1].getOffice())){
				hdr    = new CustomMnrPlnHdrVO();
				
				hdr.setMnrPlnFlg(repairExpensePlanINVO.getMnrPlnFlg());
				hdr.setIbflag(sheet2[i-1].getIbflag());
				hdr.setMnrPlnYr(sheet2[i-1].getMnrPlnYr());
				hdr.setMnrPlnOfcCd(sheet2[i-1].getMnrPlnOfcCd());
				hdr.setCtrlOfcCd(sheet2[i-1].getOffice());
				hdr.setMnrPlnSeq(sheet2[i-1].getMnrPlnSeq());
				hdr.setMnrPlnGrpNo(sheet2[i-1].getMnrPlnGrpNo());
	
				hdrArrList.add(hdr);
		//		hdrArr[i] = hdr;
			}
		}
		
		hdrArr = new CustomMnrPlnHdrVO[hdrArrList.size()];
		for(int i = 0 ; i < hdrArrList.size() ; i++){
			hdrArr[i] = (CustomMnrPlnHdrVO)hdrArrList.get(i);
		}

    	return hdrArr;
    }
 
    
    /*
	 * 화면에서 넘어온 그리드 Dtl 데이터를 DB데이터 구조에 맞도록 변환해주는 메소드
	 * 
	 */
    private CustomMnrPlnDtlVO[] doMakeDtlVO(Screen0112VO[] vo1, Screen0112VO[] vo2, RepairExpensePlanINVO   repairExpensePlanINVO,String sMnrPlnYr){
    	int arrSize =  6 ;
    	
    	if(vo2 != null) arrSize = arrSize + (vo2.length * 6); // hdr 갯수 : 6  와 dtl * 6의 합 
    	CustomMnrPlnDtlVO[]  dtlArr = new CustomMnrPlnDtlVO[arrSize];
    	

    	Screen0112VO sheet1 = vo1[0];
    	for(int i = 0; i < 6; i++){
    		CustomMnrPlnDtlVO dtl = new CustomMnrPlnDtlVO();
    		dtl.setIbflag(sheet1.getIbflag());
    		dtl.setCtrlOfcCd(sheet1.getOffice());
    		dtl.setOfcTpCd(sheet1.getOfcTpCd());
    		dtl.setMnrPlnYr(sMnrPlnYr);
    		dtl.setMnrPlnOfcHdrCd(repairExpensePlanINVO.getMnrPlnOfcCd());
    		dtl.setMnrPlnOfcCd(sheet1.getMnrPlnOfcCd());
    		dtl.setDelall(repairExpensePlanINVO.getDelall());
    		
    		if(i == 0){
    			dtl.setAcctCd("511511");
	    		dtl.setMnrPlnAmt(nvl(sheet1.getP511511()));
    		}else if(i == 1){
    			dtl.setAcctCd("511521");
	    		dtl.setMnrPlnAmt(nvl(sheet1.getP511521()));
    		}else if(i == 2){
    			dtl.setAcctCd("511531");
	    		dtl.setMnrPlnAmt(nvl(sheet1.getP511531()));
    		}else if(i == 3){
    			dtl.setAcctCd("511541");
	    		dtl.setMnrPlnAmt(nvl(sheet1.getP511541()));
    		}else if(i == 4){
    			dtl.setAcctCd("511551");
	    		dtl.setMnrPlnAmt(nvl(sheet1.getP511551()));
    		}else if(i == 5){
    			dtl.setAcctCd("511561");
	    		dtl.setMnrPlnAmt(nvl(sheet1.getP511561()));
    		}
    		dtl.setMnrPlnSeq(sheet1.getMnrPlnSeq());
    		
    		dtlArr[i] = dtl;
        }
        
        int x = 6;
        if(vo2 == null) return dtlArr;
    	for(int j = 0; j < vo2.length; j++){
    		Screen0112VO sheet2 = vo2[j];
    		if(sheet2 == null) break;
    		CustomMnrPlnDtlVO dtl = null;
    		for(int i = 0; i < 6; i++){
    			
    			dtl = new CustomMnrPlnDtlVO();
    			dtl.setIbflag(sheet2.getIbflag());
    			
    			dtl.setCtrlOfcCd(sheet2.getOffice());
    			dtl.setOfcTpCd(sheet2.getOfcTpCd());
    			dtl.setMnrPlnYr(sheet2.getMnrPlnYr());
    			dtl.setMnrPlnOfcCd(sheet2.getMnrPlnOfcCd());
    			dtl.setMnrPlnOfcHdrCd(sheet2.getMnrPlnOfcHdrCd());
    			
    			dtl.setOfcTpHdrCd(sheet2.getOfcTpHdrCd());
    			dtl.setMnrPlnHdrSeq(sheet2.getMnrPlnHdrSeq());

    			dtl.setMnrPlnYr(sMnrPlnYr);
    			
        		dtl.setDelall((repairExpensePlanINVO.getDelall()));


	    		if(i == 0){
	    			dtl.setAcctCd("511511");
		    		dtl.setMnrPlnAmt(nvl(sheet2.getP511511()));
	    		}else if(i == 1){
	    			dtl.setAcctCd("511521");
		    		dtl.setMnrPlnAmt(nvl(sheet2.getP511521()));
	    		}else if(i == 2){
	    			dtl.setAcctCd("511531");
		    		dtl.setMnrPlnAmt(nvl(sheet2.getP511531()));
	    		}else if(i == 3){
	    			dtl.setAcctCd("511541");
		    		dtl.setMnrPlnAmt(nvl(sheet2.getP511541()));
	    		}else if(i == 4){
	    			dtl.setAcctCd("511551");
		    		dtl.setMnrPlnAmt(nvl(sheet2.getP511551()));
	    		}else if(i == 5){
	    			dtl.setAcctCd("511561");
		    		dtl.setMnrPlnAmt(nvl(sheet2.getP511561()));
	    		}
	    		dtl.setMnrPlnSeq(sheet2.getMnrPlnSeq());
	    		dtl.setMnrPlnDtlSeq(sheet2.getMnrPlnDtlSeq());
	    		dtlArr[x] = dtl;
	    		x++;
    		}	

	    }
    	return dtlArr;
    }
    /*
     * 변수에 값을 검사하여 null값이면 ""를 반환한다.
     */
    private String nvl(String str){
    	String rtn = "";
    	if(str == null) rtn = "";
    	else rtn = str;
    	
    	return rtn;
    }
	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}


}