/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_053HTMLAction.java
*@FileTitle : 항로_구간별 물량 Forecast 생성/조회/변경 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-07
*@LastModifier : Park Eun Ju
*@LastVersion : 1.0
* 2006-09-07 Park Eun Ju
* 1.0 최초 생성
* 2009.03.31 박은주 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.CreateSimDailyHireVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.CoaSimBnkCostVO;
import com.clt.syscommon.common.table.CoaSimCtrbMgnCostVO;
import com.clt.syscommon.common.table.CoaSimDlyHirVO;
import com.clt.syscommon.common.table.CoaSimPortChgVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.coa 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LaneSimulationSC로 실행요청<br>
 * - LaneSimulationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Park Eun Ju
 * @see EsmCoa0053Event 참조
 * @since J2EE 1.6
 */
public class ESM_COA_0053HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
    /**
     * ESM_COA_0053HTMLAction 객체를 생성
     */
    public ESM_COA_0053HTMLAction() {
    	//
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmCoa0053Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmCoa0053Event event = new EsmCoa0053Event();
    	HashMap hash = new HashMap();
    	hash = Utils.requestToHashMap(request);
  	    event.setSearchSimConditionVO((SearchSimConditionVO)getVO(request, SearchSimConditionVO .class));
  	    if(command.isCommand(FormCommand.MULTI01)){				//Step3: Tab1 : CM_Route Summary Save
  	    	event.setSimCtrbMgnCostVOS((CoaSimCtrbMgnCostVO[])getVOs(request, CoaSimCtrbMgnCostVO.class));
  	    	CoaSimCtrbMgnCostVO[] vo = event.getSimCtrbMgnCostVOS();
  	    	String sim_dt = request.getParameter("f_sim_dt");
  	    	String sim_no = request.getParameter("f_sim_no");
  	    	String sect_no = request.getParameter("f_sect_no");
  	    	String sgrp_cost_cd = request.getParameter("f_sgrp_cost_cd");
  	    	String[] pod_cd = request.getParameter("f_tml_cd").split("[|]");
  	    	String[] pol_cd = request.getParameter("f_tml_cd").split("[|]");
  	    	String[] ibflag = Utils.requestToArray(request,"ibflag");
  	    	CoaSimCtrbMgnCostVO[] vo2 = new CoaSimCtrbMgnCostVO[vo.length*pod_cd.length];
  	    	int i = 0;
  	    	for(int j=0;j<pol_cd.length; j++){
  	    		for(int k=0; k<pod_cd.length; k++){
  	    			String[] cgo_var_uc_amt = Utils.requestToArray(request,pod_cd[k]);
  	    			String[] vol_cost = Utils.requestToArray(request,"vol_"+pod_cd[k]);
  	    			vo2[i] = new CoaSimCtrbMgnCostVO();
  	    			vo2[i].setIbflag(ibflag[j]);
  	    			vo2[i].setSimDt(sim_dt);
  	    			vo2[i].setSimNo(sim_no);
  	    			vo2[i].setSectNo(sect_no);
  	    			vo2[i].setSgrpCostCd(sgrp_cost_cd);
  	    			vo2[i].setPolCd(pol_cd[j]);
  	    			vo2[i].setPodCd(pod_cd[k]);
  	    			vo2[i].setCgoVarUcAmt(cgo_var_uc_amt[j]);
  	    			vo2[i].setCgoVarAmt((Float.parseFloat(cgo_var_uc_amt[j].equals("")?"0":cgo_var_uc_amt[j]) * Float.parseFloat(vol_cost[j].equals("")?"0":vol_cost[j]))+"");
  	    			i++;
  	    		}
  	    	}
  	    	event.setSimCtrbMgnCostVOS(vo2);
  	    } else if(command.isCommand(FormCommand.MULTI02)){				//Step3: Tab2 : Port Charge Save
  	  	    event.setSimPortChgVOS((CoaSimPortChgVO[])getVOs(request, CoaSimPortChgVO .class));
  	    } else if(command.isCommand(FormCommand.MULTI03) ||				//Step3: Tab3 : Bunker Cost Save
  	    		  command.isCommand(FormCommand.MULTI06)				//Step3: Tab3 : Bunker Cost Basic
  	             ){
  	    	event.setSimBnkCostVOS((CoaSimBnkCostVO[])getVOs(request, CoaSimBnkCostVO .class));
  	    } else if(command.isCommand(FormCommand.SEARCHLIST05)) {		//Step3: Tab3 : Hire/Tc Layup search
  	    	String sim_dt = request.getParameter("f_sim_dt");
  	    	String sim_no = request.getParameter("f_sim_no");
  	    	String header = request.getParameter("f_op_header").substring(1,request.getParameter("f_op_header").length());
  	    	CoaSimCtrbMgnCostVO vo2 = new CoaSimCtrbMgnCostVO();
  	    	vo2.setSimDt(sim_dt);
  	    	vo2.setSimNo(sim_no);
  	    	vo2.setPodCd(header);
  	    	event.setCoaSimCtrbMgnCostVO(vo2);
  	    } else if(command.isCommand(FormCommand.MULTI07)){			//Step3: Tab2 : Hire/Tc Layup creation
  	  	    event.setCreateSimDailyHireVO((CreateSimDailyHireVO)getVO(request, CreateSimDailyHireVO .class));
  	    } else if(command.isCommand(FormCommand.MULTI04)){			//Step3: Tab2 : Hire/Tc Layup creation
  	    	event.setCreateSimDailyHireVO((CreateSimDailyHireVO)getVO(request, CreateSimDailyHireVO .class));
  	    	event.setSimDlyHirVOS((CoaSimDlyHirVO[])getVOs(request, CoaSimDlyHirVO.class));
  	    	CoaSimDlyHirVO[] vo = event.getSimDlyHirVOS();
  	    	String sim_dt = request.getParameter("f_sim_dt");
  	    	String sim_no = request.getParameter("f_sim_no");
  	    	String lyp_flg = request.getParameter("f_layup_flg");
  	    	String[] header = request.getParameter("f_op_header").substring(1).split("[|]");
  	    	String[] ibflag = Utils.requestToArray(request,"ibflag");
  	    	String[] vslcd =  Utils.requestToArray(request,"vsl_cd");
  	    	String[] lyp_cost_amt = Utils.requestToArray(request,"lyp_cost_amt");
  	    	String[] vsl_dly_uc_amt = Utils.requestToArray(request,"vsl_dly_uc_amt");
  	    	CoaSimDlyHirVO[] vo2 = new CoaSimDlyHirVO[vo.length*header.length];
  	    	int i = 0;
  	    	for(int j=0;j<ibflag.length; j++){
  	    		for(int k=0; k<header.length; k++){
  	    			String[] vsl_dly_cost_amt = Utils.requestToArray(request,header[k]);
  	    			vo2[i] = new CoaSimDlyHirVO();
  	    			vo2[i].setIbflag(ibflag[j]);
  	    			vo2[i].setSimDt(sim_dt);
  	    			vo2[i].setSimNo(sim_no);
  	    			vo2[i].setSgrpCostCd(header[k]);
  	    			vo2[i].setVslCd(vslcd[j]);
  	    			vo2[i].setVslDlyCostAmt(vsl_dly_cost_amt[j]);	
  	    			vo2[i].setLypFlg(lyp_flg);
  	    			vo2[i].setLypCostAmt(lyp_cost_amt[j]);
  	    			vo2[i].setVslDlyUcAmt(vsl_dly_uc_amt[j]);
  	    			i++;
  	    		}
  	    	} 
  	    	event.setSimDlyHirVOS(vo2);
  	    }else if(command.isCommand(FormCommand.SEARCHLIST06) || command.isCommand(FormCommand.SEARCHLIST07) || command.isCommand(FormCommand.MULTI08)) {		//Step3: Tab3 : NwCost List
  	    	String sim_dt = request.getParameter("f_sim_dt");
  	    	String sim_no = request.getParameter("f_sim_no");
  	    	String header = request.getParameter("f_op_header").substring(1,request.getParameter("f_op_header").length());
  	    	CoaSimCtrbMgnCostVO vo2 = new CoaSimCtrbMgnCostVO();
  	    	vo2.setSimDt(sim_dt);
  	    	vo2.setSimNo(sim_no);
  	    	vo2.setPodCd(header);
  	    	event.setCoaSimCtrbMgnCostVO(vo2);
    	}else{
    		event.setSearchSimLaneListConditionVO((SearchSimLaneListConditionVO)getVO(request, SearchSimLaneListConditionVO .class));
    	}
        return  event;
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