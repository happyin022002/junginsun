/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0156HTMLAction.java
*@FileTitle : COD Application at BKG Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.27 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.BkgCodVO;
import com.hanjin.syscommon.common.table.BkgCodVvdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingcorrection 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingCorrectionSC로 실행요청<br>
 * - BookingCorrectionSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Yeoung Hee
 * @see BookingCorrectionEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0156HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0156HTMLAction 객체를 생성
	 */
	public ESM_BKG_0156HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingCorrectionEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0156Event event = new EsmBkg0156Event();
		
		
		if(command.isCommand(FormCommand.DEFAULT)
			  ||command.isCommand(FormCommand.SEARCH)
			  ||command.isCommand(FormCommand.COMMAND01) //seq
			  ||command.isCommand(FormCommand.COMMAND02) //request
			  ||command.isCommand(FormCommand.COMMAND03) //cancel
			  ||command.isCommand(FormCommand.COMMAND04) //code 
			  ||command.isCommand(FormCommand.REMOVE)) {
			event.setBkgBlNoVO		((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setCodAuthVO		((CodAuthVO)getVO(request,CodAuthVO.class)); 
			event.setCodRqstSeq		(JSPUtil.getParameter(request, "cod_rqst_seq"));		
			event.setPopFlg			(JSPUtil.getParameter(request, "popFlg"));
			event.setChgRmk			(JSPUtil.getParameter(request, "chgRmk"));
			event.setCodRqstRsnCd	(JSPUtil.getParameter(request, "cod_rqst_rsn_cd"));
			event.setBdrFlag		(JSPUtil.getParameter(request, "bdr_flag"));
			event.setRobFlag		(JSPUtil.getParameter(request, "rob_flag"));
			event.setRgnCd			(JSPUtil.getParameter(request, "rgn_cd")); 
//		}else if(command.isCommand(FormCommand.SEARCH)){
//			event.setBkgBlNoVO		((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
//			event.setCodRqstSeq		(JSPUtil.getParameter(request, "cod_rqst_seq"));
//			event.setCodAuthVO		((CodAuthVO)getVO(request,CodAuthVO.class));
//			event.setPopFlg			(JSPUtil.getParameter(request, "popFlg"));
//			event.setCodRemark		(JSPUtil.getParameter(request, "codRemark"));
//			event.setCodRjctRsnRmk	(JSPUtil.getParameter(request, "codRjctRsnRmk"));
//			event.setOldBkgNo		(JSPUtil.getParameter(request, "oldBkgNo"));
//			event.setOldBlNo		(JSPUtil.getParameter(request, "oldBlNo"));
//			event.setOldCodRqstSeq	(JSPUtil.getParameter(request, "oldCodRqstSeq"));
//			event.setCodStsCd		(JSPUtil.getParameter(request, "codStsCd"));
//			event.setChgRmk			(JSPUtil.getParameter(request, "chgRmk"));
//			event.setBdrFlag		(JSPUtil.getParameter(request, "bdr_flag"));
//			event.setRgnCd			(JSPUtil.getParameter(request, "rgn_cd"));
		}else if(command.isCommand(FormCommand.COMMAND06)    //complete c/a
				||command.isCommand(FormCommand.COMMAND09)   //rehandling port
				||command.isCommand(FormCommand.COMMAND10)   //start c/a
				||command.isCommand(FormCommand.COMMAND11)   //manual request
				||command.isCommand(FormCommand.COMMAND12)   //manual approve
				||command.isCommand(FormCommand.COMMAND13)	 //manual cancel
				||command.isCommand(FormCommand.COMMAND14)){ //search RSO
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setCodAuthVO((CodAuthVO)getVO(request, CodAuthVO.class));
			event.setCodRqstSeq(JSPUtil.getParameter(request, "cod_rqst_seq"));
			event.setCodStsCd  (JSPUtil.getParameter(request, "codStsCd"));
			event.setCodRhndPortCd(JSPUtil.getParameter(request, "cod_rhnd_port_cd"));

			BkgCodVO bkgCodVO = new BkgCodVO();
			bkgCodVO.setCodMnlFlg(JSPUtil.getParameter(request, "cod_mnl_flg"));
			bkgCodVO.setCodStsCd (JSPUtil.getParameter(request, "codStsCd"));

			List<BkgCodVO>bkgCodVOList = new ArrayList<BkgCodVO>();
			bkgCodVOList.add(bkgCodVO);
						
			CodVO codVO = new CodVO();
			codVO.setBkgCodVO(bkgCodVOList);
			event.setCodVO(codVO);
			if(command.isCommand(FormCommand.COMMAND06)){ //complete c/a
				event.setCodStsCd("F");	
			} else if(command.isCommand(FormCommand.COMMAND11)){ //manual request
				event.setCodStsCd("R");					
			} else if(command.isCommand(FormCommand.COMMAND12)){ //manual approve
				event.setCodStsCd("Y");					
			} else if(command.isCommand(FormCommand.COMMAND13)){ //complete c/a
				event.setCodStsCd("C");	
			}	
		}else if(command.isCommand(FormCommand.ADD)
				||command.isCommand(FormCommand.MODIFY)    //save
				||command.isCommand(FormCommand.COMMAND05) //calc
				||command.isCommand(FormCommand.COMMAND07) //confirm
				||command.isCommand(FormCommand.COMMAND08) ){ //p/c
			event.setBkgBlNoVO		((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setCodAuthVO		((CodAuthVO)getVO(request, CodAuthVO.class));
			event.setCodRqstSeq		(JSPUtil.getParameter(request, "cod_rqst_seq"));
			event.setPopFlg			(JSPUtil.getParameter(request, "popFlg"));
			event.setCodRemark		(JSPUtil.getParameter(request, "codRemark"));
			event.setCodRqstRsnCd	(JSPUtil.getParameter(request, "cod_rqst_rsn_cd"));
			event.setBdrFlag		(JSPUtil.getParameter(request, "bdr_flag"));
			event.setRobFlag		(JSPUtil.getParameter(request, "rob_flag"));
			event.setChgRmk			(JSPUtil.getParameter(request, "chgRmk"));
			event.setRgnCd			(JSPUtil.getParameter(request, "rgn_cd"));
			event.setCaRsnCd		(JSPUtil.getParameter(request, "ca_rsn_cd"));
			event.setCaRemark		(JSPUtil.getParameter(request, "ca_remark"));
			event.setCodStsCd       (JSPUtil.getParameter(request, "codStsCd"));
			
			CodVO codVO = new CodVO();
			List<CodCntrVO>codCntrVOList = new ArrayList<CodCntrVO>();
			List<BkgCodVO>bkgCodVOList = new ArrayList<BkgCodVO>();
			
			//bkg_cod Setting 
			BkgCodVO bkgCodVO = new BkgCodVO();
			bkgCodVO.setBkgNo		(JSPUtil.getParameter(request, "bkg_no"));
			bkgCodVO.setCodRqstSeq	(JSPUtil.getParameter(request, "cod_rqst_seq"));
			bkgCodVO.setCodStsCd	(JSPUtil.getParameter(request, "codStsCd"));
			bkgCodVO.setCodRqstRsnCd(JSPUtil.getParameter(request, "cod_rqst_rsn_cd"));
			bkgCodVO.setRgnCd		(JSPUtil.getParameter(request, "rgn_cd"));
			bkgCodVO.setOldVslCd	(JSPUtil.getParameter(request, "oldVslCd"));
			bkgCodVO.setOldSkdVoyNo	(JSPUtil.getParameter(request, "oldSkdVoyNo").trim());
			bkgCodVO.setOldSkdDirCd	(JSPUtil.getParameter(request, "oldSkdDirCd").trim());
			bkgCodVO.setOldPorYdCd	(JSPUtil.getParameter(request, "oldPorYdCd").trim());
			bkgCodVO.setOldPolYdCd	(JSPUtil.getParameter(request, "oldPolYdCd").trim());
			bkgCodVO.setOldPodYdCd	(JSPUtil.getParameter(request, "oldPodYdCd").trim());
			bkgCodVO.setOldDelYdCd	(JSPUtil.getParameter(request, "oldDelYdCd").trim());
			bkgCodVO.setNewVslCd	(JSPUtil.getParameter(request, "newVslCd").trim());
			bkgCodVO.setNewSkdVoyNo	(JSPUtil.getParameter(request, "newSkdVoyNo").trim());
			bkgCodVO.setNewSkdDirCd	(JSPUtil.getParameter(request, "newSkdDirCd").trim());
			bkgCodVO.setNewPorYdCd	(JSPUtil.getParameter(request, "newPorYdCd").trim());
			bkgCodVO.setNewPolYdCd	(JSPUtil.getParameter(request, "newPolYdCd").trim());
			bkgCodVO.setNewPodYdCd	(JSPUtil.getParameter(request, "newPodYdCd").trim());
			bkgCodVO.setNewDelYdCd	(JSPUtil.getParameter(request, "newDelYdCd").trim());
			bkgCodVO.setNewDeTermCd	(JSPUtil.getParameter(request, "newDeTermCd").trim());
			
			bkgCodVO.setCodRhndPortCd  ((JSPUtil.getParameter(request, "cod_rhnd_port_cd").length()>0) ? JSPUtil.getParameter(request, "cod_rhnd_port_cd").substring(0,5):"");
			bkgCodVO.setCodRhndPortYdCd((JSPUtil.getParameter(request, "cod_rhnd_port_cd").length()==7)? JSPUtil.getParameter(request, "cod_rhnd_port_cd"):"");
			bkgCodVO.setCodAuthFlg		(JSPUtil.getParameter(request, "cod_auth_flg"));
			bkgCodVO.setCodRjctCd		(JSPUtil.getParameter(request, "cod_rjct_cd"));
			bkgCodVO.setCodRjctRsnRmk	(JSPUtil.getParameter(request, "codRjctRsnRmk"));
			bkgCodVO.setPctlNo			(JSPUtil.getParameter(request, "pctl_no"));
			bkgCodVO.setDiffRmk			(JSPUtil.getParameter(request, "codRemark"));
			bkgCodVO.setCodMnlFlg		(JSPUtil.getParameter(request, "cod_mnl_flg"));
			//bkgCodVO.setCodIssDt(codIssDt);
			//bkgCodVO.setCodCngCostRmk(codCngCostRmk);
			//bkgCodVO.setCodChgTtlCostAmt(codChgTtlCostAmt);
			//bkgCodVO.setCodTrfCostAmt(codTrfCostAmt);
			//bkgCodVO.setCodFnlCostAmt(codFnlCostAmt);
			
			bkgCodVOList.add(bkgCodVO);
			codVO.setBkgCodVO(bkgCodVOList);
			 
			//bkg_cod_vvd Setting
			codVO.setBkgOldCodVvdVOs((BkgCodVvdVO[])getVOs(request, BkgCodVvdVO.class,"sheet6_"));
			codVO.setBkgNewCodVvdVOs((BkgCodVvdVO[])getVOs(request, BkgCodVvdVO.class,"sheet7_"));
			log.debug("\n action new route length:"+codVO.getBkgNewCodVvdVOs().length 
			         +"\n action old route length:"+codVO.getBkgOldCodVvdVOs().length);
			//bkg_cod_cntr Setting
			int length = request.getParameterValues("sheet1_ibflag").length;
			String[] strChk 		= JSPUtil.getParameter(request, "sheet1_chk", 			length);
			String[] strCntr 		= JSPUtil.getParameter(request, "sheet1_cntr_no", 		length);
			String[] strStwg 		= JSPUtil.getParameter(request, "sheet1_cntr_stwg_no", 	length);
			
			String[] strCntrTpszCd	= JSPUtil.getParameter(request, "sheet1_cntr_tpsz_cd", 	length);
			String[] strCntrWgt		= JSPUtil.getParameter(request, "sheet1_cntr_wgt", 		length);
			String[] strWgtUtCd		= JSPUtil.getParameter(request, "sheet1_wgt_ut_cd", 	length);
			String[] strDcgoFlg		= JSPUtil.getParameter(request, "sheet1_dcgo_flg", 		length);
			String[] strBbCgoFlg	= JSPUtil.getParameter(request, "sheet1_bb_cgo_flg", 	length);
			String[] strAwkCgoFlg	= JSPUtil.getParameter(request, "sheet1_awk_cgo_flg", 	length);
			String[] strRcFlg		= JSPUtil.getParameter(request, "sheet1_rc_flg", 		length);
			String[] strSocFlg		= JSPUtil.getParameter(request, "sheet1_soc_flg", 		length);
			
			for(int i=0;i<length;i++){
				CodCntrVO codCntrVO = new CodCntrVO();
				codCntrVO.setChk		((strChk[i].equals("1"))? "Y":"N"); 
				codCntrVO.setCntrNo		(strCntr[i]);
				codCntrVO.setCntrStwgNo	(strStwg[i]);
				codCntrVO.setCntrTpszCd	(strCntrTpszCd	[i]);
				codCntrVO.setCntrWgt	(strCntrWgt		[i]);
				codCntrVO.setWgtUtCd	(strWgtUtCd		[i]);
				codCntrVO.setDcgoFlg	((strDcgoFlg	[i].equals("1"))? "Y":"N"); 
				codCntrVO.setBbCgoFlg	((strBbCgoFlg	[i].equals("1"))? "Y":"N"); 
				codCntrVO.setAwkCgoFlg	((strAwkCgoFlg	[i].equals("1"))? "Y":"N"); 
				codCntrVO.setRcFlg		((strRcFlg		[i].equals("1"))? "Y":"N"); 
				codCntrVO.setSocFlg		((strSocFlg		[i].equals("1"))? "Y":"N"); 
				codCntrVOList.add(codCntrVO);
			}
			codVO.setCodCntrVO(codCntrVOList);
			
			//bkg_cod_cost Setting
			codVO.setBkgCodCostVOs((BkgCodCostVO[])getVOs(request,BkgCodCostVO.class,"sheet3_"));
			
			event.setCodVO(codVO);			
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