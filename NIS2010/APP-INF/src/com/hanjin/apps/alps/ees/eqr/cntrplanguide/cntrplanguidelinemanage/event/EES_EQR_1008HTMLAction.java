/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Container Guideline Manage
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1     1.0      	SHIN DONG IL						2013.05.27		 Creation
*
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1008ConditionVO;

import com.hanjin.syscommon.common.table.EqrCtrlGlineHdrVO;
import com.hanjin.syscommon.common.table.EqrCtrlLodgGlineVO;
import com.hanjin.syscommon.common.table.EqrCtrlDchgGlineVO;
import com.hanjin.syscommon.common.table.EqrCtrlDchgGlineValVO;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행요청<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */
public class EES_EQR_1008HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	

	/**
	 * EES_EQR_0059HTMLAction 객체를 생성
	 */
	public EES_EQR_1008HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1008Event event = new EesEqr1008Event();
		
		EesEqr1008ConditionVO eesEqr1008ConditionVO = new EesEqr1008ConditionVO(); 
		
		eesEqr1008ConditionVO = (EesEqr1008ConditionVO)getVO(request, EesEqr1008ConditionVO .class);
		
		eesEqr1008ConditionVO.setSEtaDt(eesEqr1008ConditionVO.getSEtaDt().replaceAll("-",""));
		eesEqr1008ConditionVO.setSEffStDt(eesEqr1008ConditionVO.getSEffStDt().replaceAll("-",""));
		eesEqr1008ConditionVO.setSEffEndDt(eesEqr1008ConditionVO.getSEffEndDt().replaceAll("-",""));
		eesEqr1008ConditionVO.setMainPage(request.getParameter("main_page"));

		
		event.setEesEqr1008ConditionVO(eesEqr1008ConditionVO);

		
		// Sheet1 update, insert, delete 정보를 받기
		if(command.isCommand(FormCommand.MULTI)){//Save
			String cntr_tpsz_cd = request.getParameter("cntr_tpsz_cd");
			String usr_id = request.getParameter("usr_id");
			String[] cntr_tpsz_arr = cntr_tpsz_cd.split(",");

			String[] trd_cd		 	= request.getParameterValues("trd_cd");
			String[] sub_trd_cd	 	= request.getParameterValues("sub_trd_cd");
			String[] vsl_lane_cd	 	= request.getParameterValues("vsl_lane_cd");
			String[] pol_cd	     	= request.getParameterValues("pol_cd");
			String[] pod_cd	     	= request.getParameterValues("pod_cd");
	
			String[] repo_gline_rmk = request.getParameterValues("repo_gline_rmk");
			String[] eff_end_dt 	= request.getParameterValues("eff_end_dt");
			String[] cfm_flg 	 	= request.getParameterValues("cfm_flg");
			String[] eff_st_dt	 	= request.getParameterValues("eff_st_dt");
			String[] eq_gline_seq	= request.getParameterValues("eq_gline_seq");
			String[] vsl_cd     	= request.getParameterValues("vsl_cd");
			String[] skd_voy_no 	= request.getParameterValues("skd_voy_no");
			String[] skd_dir_cd 	= request.getParameterValues("skd_dir_cd");
			String[] sort_id 	 	= request.getParameterValues("sort_id");
			String[] ibflag 	 	= request.getParameterValues("ibflag");
			
			if(sort_id.length > 0){
				//EQR GUIDELINE HEADER VO
				
				List<EqrCtrlGlineHdrVO> 	eqrCtrlGlineHdrVOs 		= new ArrayList<EqrCtrlGlineHdrVO>();
				//EQR LOADING GUIDELINE VO

				List<EqrCtrlLodgGlineVO> 	eqrCtrlLodgGlineVOs 	= new ArrayList<EqrCtrlLodgGlineVO>();
				//EQR DISCHARGING VO

				List<EqrCtrlDchgGlineVO> 	eqrCtrlDchgGlineVOs 	= new ArrayList<EqrCtrlDchgGlineVO>();
				//EQR DISCHARGING VALUE VO

				List<EqrCtrlDchgGlineValVO> eqrCtrlDchgGlineValVOs 	= new ArrayList<EqrCtrlDchgGlineValVO>();
				
				String cntr_tpsz="";

				String[] pri_seq = new String[cntr_tpsz_arr.length];
				
				for(int i = 0; i < sort_id.length; i++){
					
					if(sort_id[i].equals("1")){// Guideline Header(EQR_CTRL_GLINE_HDR DATA)
						
						EqrCtrlGlineHdrVO eqrCtrlGlineHdrVO	= new EqrCtrlGlineHdrVO();
						String confirm_flg ="";
						
						eqrCtrlGlineHdrVO.setTrdCd(trd_cd[i]);
						eqrCtrlGlineHdrVO.setSubTrdCd(sub_trd_cd[i]);
						eqrCtrlGlineHdrVO.setVslLaneCd(vsl_lane_cd[i]);
						eqrCtrlGlineHdrVO.setEqGlineSeq(eq_gline_seq[i]);
						eqrCtrlGlineHdrVO.setVslCd(vsl_cd[i]);
						eqrCtrlGlineHdrVO.setSkdVoyNo(skd_voy_no[i]);
						eqrCtrlGlineHdrVO.setSkdDirCd(skd_dir_cd[i]);
						eqrCtrlGlineHdrVO.setPolCd(pol_cd[i]);
						eqrCtrlGlineHdrVO.setEffStDt(eff_st_dt[i]);
						eqrCtrlGlineHdrVO.setEffEndDt(eff_end_dt[i]);
						if(cfm_flg[i].equals("0")){
							confirm_flg = "N";
						}else if(cfm_flg[i].equals("1")){
							confirm_flg = "Y";
						}
						eqrCtrlGlineHdrVO.setCfmFlg(confirm_flg);
						eqrCtrlGlineHdrVO.setRepoGlineRmk(repo_gline_rmk[i]);
						eqrCtrlGlineHdrVO.setCreUsrId(usr_id);
						eqrCtrlGlineHdrVO.setUpdUsrId(usr_id);
						eqrCtrlGlineHdrVO.setIbflag(ibflag[i]);
						eqrCtrlGlineHdrVO.setSortId(sort_id[i]);
						
						for(int a=0;a<cntr_tpsz_arr.length;a++){
							cntr_tpsz =cntr_tpsz_arr[a]+"_ut"; //PRIORITY SEQ
							pri_seq[a]= (request.getParameterValues(cntr_tpsz))[i];
						}

						eqrCtrlGlineHdrVOs.add(eqrCtrlGlineHdrVO); // EQR_CTRL_GLINE_HDR VO
						
					}else if(sort_id[i].equals("2")){//CONTAINER LOADING DATA
						for(int a=0;a<cntr_tpsz_arr.length;a++){// CONTAINER TYPE SIZE별로 데이터 취합
							
							EqrCtrlLodgGlineVO eqrCtrlLodgGlineVO = new EqrCtrlLodgGlineVO();
							
							eqrCtrlLodgGlineVO.setTrdCd(trd_cd[i]);
							eqrCtrlLodgGlineVO.setSubTrdCd(sub_trd_cd[i]);
							eqrCtrlLodgGlineVO.setVslLaneCd(vsl_lane_cd[i]);
							eqrCtrlLodgGlineVO.setEqGlineSeq(eq_gline_seq[i]);
							eqrCtrlLodgGlineVO.setCntrTpszCd(cntr_tpsz_arr[a].toUpperCase());
							
							eqrCtrlLodgGlineVO.setPrioSeq(pri_seq[a]);

							cntr_tpsz =cntr_tpsz_arr[a]+"_ut";//EQ GUIDELINE TP CD (%,BOX, REST)

							eqrCtrlLodgGlineVO.setEqGlineTpCd((request.getParameterValues(cntr_tpsz))[i]);
							
							cntr_tpsz =cntr_tpsz_arr[a]+"_qty";
							eqrCtrlLodgGlineVO.setEqGlineVal((request.getParameterValues(cntr_tpsz))[i]);
							
							eqrCtrlLodgGlineVO.setCreUsrId(usr_id);
							eqrCtrlLodgGlineVO.setUpdUsrId(usr_id);
							
							eqrCtrlLodgGlineVO.setIbflag(ibflag[i]);
							eqrCtrlLodgGlineVO.setSortId(sort_id[i]);
							
							eqrCtrlLodgGlineVOs.add(eqrCtrlLodgGlineVO);
						}
					}else if(sort_id[i].equals("3")){ // CONTAINER DISCHARGING DATA
						
						EqrCtrlDchgGlineVO eqrCtrlDchgGlineVO = new EqrCtrlDchgGlineVO();
						
						eqrCtrlDchgGlineVO.setTrdCd(trd_cd[i]);
						eqrCtrlDchgGlineVO.setSubTrdCd(sub_trd_cd[i]);
						eqrCtrlDchgGlineVO.setVslLaneCd(vsl_lane_cd[i]);
						eqrCtrlDchgGlineVO.setEqGlineSeq(eq_gline_seq[i]);
						eqrCtrlDchgGlineVO.setPodCd(pod_cd[i]);
						eqrCtrlDchgGlineVO.setCreUsrId(usr_id);
						eqrCtrlDchgGlineVO.setUpdUsrId(usr_id);
						eqrCtrlDchgGlineVO.setIbflag(ibflag[i]);
						eqrCtrlDchgGlineVO.setSortId(sort_id[i]);
						
						eqrCtrlDchgGlineVOs.add(eqrCtrlDchgGlineVO); 
						
						for(int b=0;b<cntr_tpsz_arr.length;b++){ // CONTAINER TYPE SIZE별로 데이터 취합
							
							EqrCtrlDchgGlineValVO eqrCtrlDchgGlineValVO	= new EqrCtrlDchgGlineValVO();
							
							eqrCtrlDchgGlineValVO.setTrdCd(trd_cd[i]);
							eqrCtrlDchgGlineValVO.setSubTrdCd(sub_trd_cd[i]);
							eqrCtrlDchgGlineValVO.setVslLaneCd(vsl_lane_cd[i]);
							eqrCtrlDchgGlineValVO.setEqGlineSeq(eq_gline_seq[i]);
							eqrCtrlDchgGlineValVO.setPodCd(pod_cd[i]);
							eqrCtrlDchgGlineValVO.setCntrTpszCd(cntr_tpsz_arr[b].toUpperCase());
							
							cntr_tpsz =cntr_tpsz_arr[b]+"_ut";
							eqrCtrlDchgGlineValVO.setEqGlineTpCd((request.getParameterValues(cntr_tpsz))[i]);
							
							cntr_tpsz =cntr_tpsz_arr[b]+"_qty";
							eqrCtrlDchgGlineValVO.setEqGlineVal((request.getParameterValues(cntr_tpsz))[i]);
							
							eqrCtrlDchgGlineValVO.setCreUsrId(usr_id);
							eqrCtrlDchgGlineValVO.setUpdUsrId(usr_id);
							
							eqrCtrlDchgGlineValVO.setIbflag(ibflag[i]);
							eqrCtrlDchgGlineValVO.setSortId(sort_id[i]);
							
							eqrCtrlDchgGlineValVOs.add(eqrCtrlDchgGlineValVO);
						}
					}
				}//end for(int i = 0; i < sort_id.length; i++)
				event.setEqrCtrlGlineHdrVOs(eqrCtrlGlineHdrVOs);
				event.setEqrCtrlLodgGlineVOs(eqrCtrlLodgGlineVOs);
				event.setEqrCtrlDchgGlineVOs(eqrCtrlDchgGlineVOs);
				event.setEqrCtrlDchgGlineValVOs(eqrCtrlDchgGlineValVOs);
			}//end if(sort_id.length > 0)
			
		}else if(command.isCommand(FormCommand.SEARCH02)){

		  eesEqr1008ConditionVO.setTrade(request.getParameter("str_trd_cd"));
		  eesEqr1008ConditionVO.setSubtrade(request.getParameter("str_sub_trd_cd"));
		  eesEqr1008ConditionVO.setLane(request.getParameter("str_vsl_lane_cd"));
		  eesEqr1008ConditionVO.setEqGlineSeq(request.getParameter("str_eq_gline_seq"));

		  event.setEesEqr1008ConditionVO(eesEqr1008ConditionVO);
		  
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