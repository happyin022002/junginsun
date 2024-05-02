/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0099HTMLAction.java
*@FileTitle : Booking Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.18 최영희
* 1.0 Creation
* -------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CopySplitBkgEtcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectSpclCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitQtyVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Yeoung Hee
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0099HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0099HTMLAction 객체를 생성
	 */
	public ESM_BKG_0099HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0099Event event = new EsmBkg0099Event();


		if(command.isCommand(FormCommand.DEFAULT) ||command.isCommand(FormCommand.SEARCH)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}else if(command.isCommand(FormCommand.COMMAND01)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}else if(command.isCommand(FormCommand.MULTI)||command.isCommand(FormCommand.COMMAND05)){ //split
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setSourceBkg((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setCodFlag (JSPUtil.getParameter(request, "codflag"));
			event.setCaRsnCd (JSPUtil.getParameter(request, "caRsnCd"));
			event.setCaRemark(JSPUtil.getParameter(request, "caRemark"));
			event.setTroTp   (JSPUtil.getParameter(request, "troTp"));
			if(command.isCommand(FormCommand.COMMAND05)){
				event.setCurrSplitBkg(JSPUtil.getParameter(request, "currSplitBkg"));
				event.setLastTarget(JSPUtil.getParameter(request, "lastTarget"));
			}
			
			List<CopySplitBkgEtcVO>copySplitBkgEtcVOList = new ArrayList<CopySplitBkgEtcVO>();
			copySplitBkgEtcVOList.add((CopySplitBkgEtcVO)getVO(request, CopySplitBkgEtcVO.class));
			//Split
			SplitBlInfoVO[] splitBlInfoVOs = null;
			splitBlInfoVOs=(SplitBlInfoVO[])getVOs(request,SplitBlInfoVO.class,"sheet2_");
			BkgBlNoVO[] sTargetBkg = new BkgBlNoVO[splitBlInfoVOs.length];
			
			List<SplitBlInfoVO> splitBlInfoVOList = new ArrayList<SplitBlInfoVO>();
			for(int i=0;i<splitBlInfoVOs.length;i++){
				BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
				
				bkgBlNoVO.setBkgNo(splitBlInfoVOs[i].getBkgNo());
				bkgBlNoVO.setBlNo(splitBlInfoVOs[i].getBlNo()); 
				sTargetBkg[i]=bkgBlNoVO;
				splitBlInfoVOList.add(splitBlInfoVOs[i]);
			}
			 
			//Target BkgNo
			event.setTargetBkg(sTargetBkg);
			
			//Qty
			String[] arrSplitNo = null;
			String [] arrData=null;
			String qtySplitNo= JSPUtil.getParameter(request, "qtySplitNo");
			arrSplitNo= qtySplitNo.split("~");
			List<SplitQtyVO>splitQtyVOList = new ArrayList<SplitQtyVO>();
			for (int idx=0;idx<arrSplitNo.length;idx++){
				SplitQtyVO splitQtyVO = new SplitQtyVO();
				arrData=null;
				arrData=arrSplitNo[idx].split(":");
				splitQtyVO.setCntrTpszCd(arrData[0]);
				splitQtyVO.setOpCntrQty(arrData[1]);
				splitQtyVO.setSplitNo(arrData[2]);
				splitQtyVOList.add(splitQtyVO);
			}
			//Cntr
			String cntrSplitNo= JSPUtil.getParameter(request, "cntrSplitNo");
			arrSplitNo=null;
			arrSplitNo= cntrSplitNo.split("~");
			List<SelectCntrVO>selectCntrVOList = new ArrayList<SelectCntrVO>();
			if (arrSplitNo[0].length()>1){
				for (int idx=0;idx<arrSplitNo.length;idx++){
					SelectCntrVO selectCntrVO = new SelectCntrVO();
					arrData=null;
					arrData=arrSplitNo[idx].split(":");
					selectCntrVO.setCntr_no(arrData[0]);
					selectCntrVO.setSplitNo(arrData[1]);
					selectCntrVO.setBkg_no(arrData[2]);
					if(arrData.length==4){
						selectCntrVO.setAdv_shtg_cd(arrData[3]);
					}else{
						selectCntrVO.setAdv_shtg_cd("");
					}
					selectCntrVOList.add(selectCntrVO);
				}
			}

			List<SelectSpclCgoVO>selectSpclCgoVOList = new ArrayList<SelectSpclCgoVO>();
			//Special Cargo Dg
			String dgCntrSplitNo= JSPUtil.getParameter(request, "dgCntrSplitNo");
			arrSplitNo=null;
			String strTmpBkg="";
			if (dgCntrSplitNo.length()>1){
				arrSplitNo= dgCntrSplitNo.split("~");
				for (int idx=0;idx<arrSplitNo.length;idx++){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					arrData=null;
					arrData=arrSplitNo[idx].split(":");
//					if (!strTmpBkg.equals(arrData[3])){
						strTmpBkg=arrData[3];
						selectSpclCgoVO.setSpclCagoFlag("D");
						selectSpclCgoVO.setCntrNo(arrData[0]);
						selectSpclCgoVO.setSpclCagoSeq(arrData[1]);
						selectSpclCgoVO.setSplitNo(arrData[2]);
						selectSpclCgoVO.setSplitreason(JSPUtil.getParameter(request, "splitreason"));
						selectSpclCgoVO.setBkg_no(arrData[3]);
						selectSpclCgoVO.setKeepDgRefNo(arrData[4]);
						selectSpclCgoVOList.add(selectSpclCgoVO);
//					} 
				}
			}
			//Special Cargo Rf
			String rfCntrSplitNo= JSPUtil.getParameter(request, "rfCntrSplitNo");
			arrSplitNo=null;
			strTmpBkg="";
			if (rfCntrSplitNo.length()>1){
				arrSplitNo= rfCntrSplitNo.split("~");
				for (int idx=0;idx<arrSplitNo.length;idx++){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					arrData=null;
					arrData=arrSplitNo[idx].split(":"); 
//					if (!strTmpBkg.equals(arrData[3])){
						strTmpBkg=arrData[3];
						selectSpclCgoVO.setSpclCagoFlag("R");
						selectSpclCgoVO.setCntrNo(arrData[0]);
						selectSpclCgoVO.setSpclCagoSeq(arrData[1]);
						selectSpclCgoVO.setSplitNo(arrData[2]);
						selectSpclCgoVO.setSplitreason(JSPUtil.getParameter(request, "splitreason"));
						selectSpclCgoVO.setBkg_no(arrData[3]);
						selectSpclCgoVOList.add(selectSpclCgoVO);
//					}
				}
			}
			//Special Cargo Ak
			String akCntrSplitNo= JSPUtil.getParameter(request, "akCntrSplitNo");
			arrSplitNo=null;
			strTmpBkg="";
			if (akCntrSplitNo.length()>1){
				arrSplitNo= akCntrSplitNo.split("~");
				for (int idx=0;idx<arrSplitNo.length;idx++){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					arrData=null;
					arrData=arrSplitNo[idx].split(":");
//					if (!strTmpBkg.equals(arrData[3])){
						strTmpBkg=arrData[3];
						selectSpclCgoVO.setSpclCagoFlag("A");
						selectSpclCgoVO.setCntrNo(arrData[0]);
						selectSpclCgoVO.setSpclCagoSeq(arrData[1]);
						selectSpclCgoVO.setSplitNo(arrData[2]);
						selectSpclCgoVO.setSplitreason(JSPUtil.getParameter(request, "splitreason"));
						selectSpclCgoVO.setBkg_no(arrData[3]);
						selectSpclCgoVOList.add(selectSpclCgoVO);
//					}
				}
			}
			//Special Cargo BB
			String bbCntrSplitNo= JSPUtil.getParameter(request, "bbCntrSplitNo");
			arrSplitNo=null;
			strTmpBkg="";
			if (bbCntrSplitNo.length()>1){
				arrSplitNo= bbCntrSplitNo.split("~");
				for (int idx=0;idx<arrSplitNo.length;idx++){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					arrData=null;
					arrData=arrSplitNo[idx].split(":");
//					if (!strTmpBkg.equals(arrData[3])){
						strTmpBkg=arrData[3];
						selectSpclCgoVO.setSpclCagoFlag("B");
						//selectSpclCgoVO.setCntrNo(arrData[0]);
						selectSpclCgoVO.setSpclCagoSeq(arrData[1]);
						selectSpclCgoVO.setSplitNo(arrData[2]);
						selectSpclCgoVO.setSplitreason(JSPUtil.getParameter(request, "splitreason"));
						selectSpclCgoVO.setBkg_no(arrData[3]);
						selectSpclCgoVOList.add(selectSpclCgoVO);
//					}
				}
			}
			//Special Cargo Stowage
			arrSplitNo=null;
			strTmpBkg="";
			if(copySplitBkgEtcVOList.get(0).getStwgCd().equals("on")){
				for(int i=0;i<splitBlInfoVOs.length;i++){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					selectSpclCgoVO.setSpclCagoFlag("S");
					selectSpclCgoVO.setSplitNo("1"); //Stowage does not relate to container
					selectSpclCgoVO.setBkg_no(splitBlInfoVOs[i].getBkgNo());
					selectSpclCgoVO.setSplitreason(JSPUtil.getParameter(request, "splitreason"));
					selectSpclCgoVOList.add(selectSpclCgoVO);
				}			
			}
			
			//Tro
			String troSplitNo= JSPUtil.getParameter(request, "troSplitNo");
			arrSplitNo=null;
			strTmpBkg="";
			List<SelectTroVO>selectTroVOList = new ArrayList<SelectTroVO>();
			if (troSplitNo.length()>1){
				arrSplitNo= troSplitNo.split("~");
				for (int idx=0;idx<arrSplitNo.length;idx++){
					SelectTroVO selectTroVO = new SelectTroVO();
					arrData=null;
					log.debug("tro:!!!!:"+arrSplitNo[idx]);
					
					arrData=arrSplitNo[idx].split(":");
					if (!strTmpBkg.equals(arrData[3])){
						strTmpBkg=arrData[3];
						selectTroVO.setTroSeq(arrData[0]);
						selectTroVO.setTroSubSeq(arrData[1]);
						selectTroVO.setSplitNo(arrData[2]);
						selectTroVO.setSplitDel(JSPUtil.getParameter(request, "splitdel"));
						selectTroVO.setBkg_no(arrData[3]);
						selectTroVOList.add(selectTroVO);
					}
				}
			}

			SplitBkgVO splitBkgVO = new SplitBkgVO();
			splitBkgVO.setCopySplitBkgEtcVO(copySplitBkgEtcVOList);
			splitBkgVO.setSplitBlInfoVO(splitBlInfoVOList);
			splitBkgVO.setSplitQtyVO(splitQtyVOList);
			splitBkgVO.setSelectCntrVO(selectCntrVOList);
			splitBkgVO.setSelectSpclCgoVO(selectSpclCgoVOList);
			splitBkgVO.setSelectTroVO(selectTroVOList);
			event.setSplitBkgVO(splitBkgVO);
		}else if(command.isCommand(FormCommand.COMMAND02)){//searchSplitRoute
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setSourceBkg((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setPcIdx(JSPUtil.getParameterAsInt(request, "pcIdx", 0));			

			List<CopySplitBkgEtcVO>copySplitBkgEtcVOList = new ArrayList<CopySplitBkgEtcVO>();
			copySplitBkgEtcVOList.add((CopySplitBkgEtcVO)getVO(request, CopySplitBkgEtcVO.class));
			
			//Split
			SplitBlInfoVO[] splitBlInfoVOs = null;
			splitBlInfoVOs=(SplitBlInfoVO[])getVOs(request,SplitBlInfoVO.class,"sheet2_");
			
			List<SplitBlInfoVO> splitBlInfoVOList = new ArrayList<SplitBlInfoVO>();
			splitBlInfoVOList.add(splitBlInfoVOs[event.getPcIdx()]);
			
			log.debug(splitBlInfoVOList.size()+"==="+splitBlInfoVOList.get(0).getTvvd());
			
			//Qty
			String[] arrSplitNo = null;
			String [] arrData=null;
			String qtySplitNo= JSPUtil.getParameter(request, "qtySplitNo");
			arrSplitNo= qtySplitNo.split("~");
			List<SplitQtyVO>splitQtyVOList = new ArrayList<SplitQtyVO>();
			for (int idx=0;idx<arrSplitNo.length;idx++){
				SplitQtyVO splitQtyVO = new SplitQtyVO();
				arrData=null;
				arrData=arrSplitNo[idx].split(":");
				splitQtyVO.setCntrTpszCd(arrData[0]);
				splitQtyVO.setOpCntrQty(arrData[1]);
				splitQtyVO.setSplitNo(arrData[2]);
				splitQtyVOList.add(splitQtyVO);
			}

			SplitBkgVO splitBkgVO = new SplitBkgVO();
			splitBkgVO.setSplitBlInfoVO(splitBlInfoVOList);
			splitBkgVO.setSplitQtyVO(splitQtyVOList);
			splitBkgVO.setCopySplitBkgEtcVO(copySplitBkgEtcVOList);
			event.setSplitBkgVO(splitBkgVO);
		}else if(command.isCommand(FormCommand.COMMAND03)){//searchSplitTsRoute
			event.setPcIdx(JSPUtil.getParameterAsInt(request, "pcIdx", 0));			
			
			//Split
			SplitBlInfoVO[] splitBlInfoVOs = null;
			splitBlInfoVOs=(SplitBlInfoVO[])getVOs(request,SplitBlInfoVO.class,"sheet2_");
			
			List<SplitBlInfoVO> splitBlInfoVOList = new ArrayList<SplitBlInfoVO>();
			splitBlInfoVOList.add(splitBlInfoVOs[event.getPcIdx()]);

			SplitBkgVO splitBkgVO = new SplitBkgVO();
			splitBkgVO.setSplitBlInfoVO(splitBlInfoVOList);
			event.setSplitBkgVO(splitBkgVO);			
		} else if(command.isCommand(FormCommand.SEARCH01)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setSourceBkg((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setCodFlag (JSPUtil.getParameter(request, "codflag"));
			event.setCaRsnCd (JSPUtil.getParameter(request, "caRsnCd"));
			event.setCaRemark(JSPUtil.getParameter(request, "caRemark"));
			event.setTroTp   (JSPUtil.getParameter(request, "troTp"));
			
			List<CopySplitBkgEtcVO>copySplitBkgEtcVOList = new ArrayList<CopySplitBkgEtcVO>();
			copySplitBkgEtcVOList.add((CopySplitBkgEtcVO)getVO(request, CopySplitBkgEtcVO.class));
			//Split
			SplitBlInfoVO[] splitBlInfoVOs = null;
			splitBlInfoVOs=(SplitBlInfoVO[])getVOs(request,SplitBlInfoVO.class,"sheet2_");
			BkgBlNoVO[] sTargetBkg = new BkgBlNoVO[splitBlInfoVOs.length];
			
			List<SplitBlInfoVO> splitBlInfoVOList = new ArrayList<SplitBlInfoVO>();
			for(int i=0;i<splitBlInfoVOs.length;i++){
				BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
				
				bkgBlNoVO.setBkgNo(splitBlInfoVOs[i].getBkgNo());
				bkgBlNoVO.setBlNo(splitBlInfoVOs[i].getBlNo()); 
				if ( splitBlInfoVOs[i].getPctlNo().length() != 0 ){
					bkgBlNoVO.setPctlNo(splitBlInfoVOs[i].getPctlNo());
				} else {					
					bkgBlNoVO.setPctlNo(JSPUtil.getParameter(request, "pctl_no"));
				}
				sTargetBkg[i]=bkgBlNoVO;
				splitBlInfoVOList.add(splitBlInfoVOs[i]);
			}
			 
			//Target BkgNo
			event.setTargetBkg(sTargetBkg);
			

			SplitBkgVO splitBkgVO = new SplitBkgVO();
			splitBkgVO.setCopySplitBkgEtcVO(copySplitBkgEtcVOList);
			splitBkgVO.setSplitBlInfoVO(splitBlInfoVOList);
			event.setSplitBkgVO(splitBkgVO);
		}

		request.setAttribute("Event", event);

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