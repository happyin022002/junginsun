/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : ESM_SPC_0030HTMLAction.java
*@FileTitle : SPACE MANAGEMENT PLAN (NEW)
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.03.19 송민석
* 1.0 Creation
* 
* History
* 2018.03.19 송민석 [CSR #3462] 기존 H/O, RHQ, L/OFC 3단계로 진행 되던 업무를 H/O에서 통합 관리하도록 수정함 이에 ESM_SPC_0090을 copy해서 새로운 화면으로 만듬
* 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustCtrlGrpVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SearchModelManageListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.SpcMdlExptWkVO;
import com.hanjin.syscommon.common.table.SpcMdlVerMstVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.modelmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ModelManageSC로 실행요청<br>
 * - ModelManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Maria Chin
 * @see ModelManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0090HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0030HTMLAction 객체를 생성
	 */
	public ESM_SPC_0090HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ModelManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0090Event event = new EsmSpc0090Event();
//		SearchModelManageListVO searchModelManageListVO = new SearchModelManageListVO();

		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)){
			event.setSearchModelManageListVO((SearchModelManageListVO)getVO(request, SearchModelManageListVO .class));
		} 
		else if(command.isCommand(FormCommand.SEARCH02)){
			event.setSearchModelManageListVO((SearchModelManageListVO)getVO(request, SearchModelManageListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}
		else if(command.isCommand(FormCommand.SEARCH05)){
			event.setSearchModelManageListVO((SearchModelManageListVO)getVO(request, SearchModelManageListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)){
			event.setSearchModelManageListVO((SearchModelManageListVO)getVO(request, SearchModelManageListVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI)){
			event.setSearchModelManageListVOs((SearchModelManageListVO[])getVOs(request, SearchModelManageListVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI01)){ //CONFIRM
            String exptWk = request.getParameter("expt_yrwk");
            if( exptWk != null && exptWk.length() != 0){
                exptWk=exptWk.trim();
                String[] arr = exptWk.split(",");
                List<SpcMdlExptWkVO> exptWkArr = new ArrayList<SpcMdlExptWkVO>(); 
                for(int i =0 ; i < arr.length;i++){
                    SpcMdlExptWkVO vo = new SpcMdlExptWkVO();
                    vo.setTrdCd(request.getParameter("trade"));
                    vo.setCostYrwk(request.getParameter("cost_yrwk"));
                    vo.setVerSeq(request.getParameter("ver_seq"));
                    vo.setExptYrwk( arr[i]) ;
                    vo.setDtlSeq(String.valueOf(i+1));
                    exptWkArr.add(vo);
                }
                event.setSpcMdlExptWkVOList(exptWkArr);
                
            }
			SpcMdlVerMstVO spcMdlVerMstVO = new SpcMdlVerMstVO();
	        //SpcMdlExptWkVO[] exptWk = new SpcMdlExptWkVO[];

			spcMdlVerMstVO.setTrdCd(request.getParameter("trade"));
			spcMdlVerMstVO.setCostYrwk(request.getParameter("cost_yrwk"));
			spcMdlVerMstVO.setVerSeq(request.getParameter("ver_seq"));
			spcMdlVerMstVO.setVerStYrwk(request.getParameter("from"));
			spcMdlVerMstVO.setVerEndYrwk(request.getParameter("to"));
			
			
			event.setSpcMdlVerMstVO(spcMdlVerMstVO);
		}
		else if(command.isCommand(FormCommand.MULTI02)){ //CREATION
		    String exptWk = request.getParameter("expt_yrwk");
            if( exptWk != null && exptWk.length() != 0){
                exptWk=exptWk.trim();
                String[] arr = exptWk.split(",");
                List<SpcMdlExptWkVO> exptWkArr = new ArrayList<SpcMdlExptWkVO>(); 
                for(int i =0 ; i < arr.length;i++){
                    SpcMdlExptWkVO vo = new SpcMdlExptWkVO();
                    vo.setTrdCd(request.getParameter("trade"));
                    vo.setCostYrwk(request.getParameter("cost_yrwk"));
                    vo.setVerSeq(request.getParameter("ver_seq"));
                    vo.setExptYrwk( arr[i]) ;
                    vo.setDtlSeq(String.valueOf(i+1));

                    exptWkArr.add(vo);
                }
                event.setSpcMdlExptWkVOList(exptWkArr);
                
            }
			SpcMdlVerMstVO spcMdlVerMstVO = new SpcMdlVerMstVO();
			spcMdlVerMstVO.setTrdCd(request.getParameter("trade"));
			spcMdlVerMstVO.setPerfStYrwk(request.getParameter("from"));
			spcMdlVerMstVO.setPerfEndYrwk(request.getParameter("to"));
			event.setSpcMdlVerMstVO(spcMdlVerMstVO);
			event.setCustCtrlGrpVOs((CustCtrlGrpVO[])getVOs(request, CustCtrlGrpVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI03)){ //REVIVE
			event.setSearchModelManageListVO((SearchModelManageListVO)getVO(request, SearchModelManageListVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI04)){ // REGENERATION
			SpcMdlVerMstVO spcMdlVerMstVO = new SpcMdlVerMstVO();
			spcMdlVerMstVO.setTrdCd(request.getParameter("trade"));
			spcMdlVerMstVO.setCostYrwk(request.getParameter("cost_yrwk"));
			spcMdlVerMstVO.setVerSeq(request.getParameter("ver_seq"));
			spcMdlVerMstVO.setPerfStYrwk(request.getParameter("from"));
			spcMdlVerMstVO.setPerfEndYrwk(request.getParameter("to"));
			
			event.setSpcMdlVerMstVO(spcMdlVerMstVO);
		}
		else if(command.isCommand(FormCommand.MULTI05)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}
        else if(command.isCommand(FormCommand.MULTI06)){ //COPY
 
            SpcMdlVerMstVO spcMdlVerMstVO = new SpcMdlVerMstVO();
  
            spcMdlVerMstVO.setTrdCd(request.getParameter("trade"));
            spcMdlVerMstVO.setCostYrwk(request.getParameter("cost_yrwk"));
            spcMdlVerMstVO.setVerSeq(request.getParameter("ver_seq"));
            spcMdlVerMstVO.setPerfStYrwk(request.getParameter("from"));
            spcMdlVerMstVO.setPerfEndYrwk(request.getParameter("to"));
            event.setSpcMdlVerMstVO(spcMdlVerMstVO);

            
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