/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0997HTMLAction.java
*@FileTitle : COD Comfirm Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.08.06 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CopySplitBkgEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectSpclCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitQtyVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
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

public class ESM_BKG_0997HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0997HTMLAction 객체를 생성
	 */
	public ESM_BKG_0997HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingCorrectionEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0997Event event = new EsmBkg0997Event();
		

		if(command.isCommand(FormCommand.DEFAULT)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setCodRqstSeq(JSPUtil.getParameter(request, "cod_rqst_seq"));
			event.setCodFlag(JSPUtil.getParameter(request, "codflag"));
			event.setBkgCodVvdVOs((BkgCodVvdVO[])getVOs(request, BkgCodVvdVO.class,"sheet7_"));
			event.setCodCntrNo(JSPUtil.getParameter(request, "codCntrNo"));
			event.setCodDg(JSPUtil.getParameter(request, "codDg"));
			event.setCodBb(JSPUtil.getParameter(request, "codBb"));
			event.setCodAk(JSPUtil.getParameter(request, "codAk"));
			event.setCodRf(JSPUtil.getParameter(request, "codRF"));
			event.setCodRqstRsnCd(JSPUtil.getParameter(request, "cod_rqst_rsn_cd"));
			
		}else if(command.isCommand(FormCommand.SEARCH)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setCodRqstSeq(JSPUtil.getParameter(request, "cod_rqst_seq"));
			event.setCodFlag(JSPUtil.getParameter(request, "codflag"));
			event.setCodCntrNo(JSPUtil.getParameter(request, "codCntrNo"));
			event.setCodDg(JSPUtil.getParameter(request, "codDg"));
			event.setCodBb(JSPUtil.getParameter(request, "codBb"));
			event.setCodAk(JSPUtil.getParameter(request, "codAk"));
			event.setCodRf(JSPUtil.getParameter(request, "codRF"));
			event.setCodRqstRsnCd(JSPUtil.getParameter(request, "cod_rqst_rsn_cd"));
			
			int length = request.getParameterValues("codVslCd").length;
			String[] arrCodVslCd = JSPUtil.getParameter(request, "codVslCd", length);
			String[] arrCodPodClptIndSeq = JSPUtil.getParameter(request, "codPodClptIndSeq", length);
			String[] arrCodSkdVoyNo = JSPUtil.getParameter(request, "codSkdVoyNo", length);
			String[] arrCodVslSeq = JSPUtil.getParameter(request, "codVslSeq", length);
			String[] arrCodSkdDirCd = JSPUtil.getParameter(request, "codSkdDirCd", length);
			String[] arrCodBkgNo = JSPUtil.getParameter(request, "codBkgNo", length);
			String[] arrCodCodRqstSeq = JSPUtil.getParameter(request, "codCodRqstSeq", length);
			String[] arrCodSlanCd = JSPUtil.getParameter(request, "codSlanCd", length);
			String[] arrCodPolYdCd = JSPUtil.getParameter(request, "codPolYdCd", length);
			String[] arrCodPolClptIndSeq = JSPUtil.getParameter(request, "codPolClptIndSeq", length);
			String[] arrCodVslPrePstCd = JSPUtil.getParameter(request, "codVslPrePstCd", length);
			String[] arrCodPodYdCd = JSPUtil.getParameter(request, "codPodYdCd", length);
			String[] arrCodVvdOpCd = JSPUtil.getParameter(request, "codVvdOpCd", length);
			List<BkgCodVvdVO> bkgCodVvdVOList= new ArrayList<BkgCodVvdVO>();
			for(int i=0;i<length;i++){
				BkgCodVvdVO bkgCodVvdVO = new BkgCodVvdVO();
				bkgCodVvdVO.setVslCd(arrCodVslCd[i]);
				bkgCodVvdVO.setPodClptIndSeq(arrCodPodClptIndSeq[i]);
				bkgCodVvdVO.setSkdVoyNo(arrCodSkdVoyNo[i]);
				bkgCodVvdVO.setVslSeq(arrCodVslSeq[i]);
				bkgCodVvdVO.setSkdDirCd(arrCodSkdDirCd[i]);
				bkgCodVvdVO.setBkgNo(arrCodBkgNo[i]);
				bkgCodVvdVO.setCodRqstSeq(arrCodCodRqstSeq[i]);
				bkgCodVvdVO.setSlanCd(arrCodSlanCd[i]);
				bkgCodVvdVO.setPolYdCd(arrCodPolYdCd[i]);
				bkgCodVvdVO.setPolClptIndSeq(arrCodPolClptIndSeq[i]);
				bkgCodVvdVO.setVslPrePstCd(arrCodVslPrePstCd[i]);
				bkgCodVvdVO.setPodYdCd(arrCodPodYdCd[i]);
				bkgCodVvdVO.setVvdOpCd(arrCodVvdOpCd[i]);
				bkgCodVvdVOList.add(bkgCodVvdVO);
			}
			event.setBkgCodVvdVO(bkgCodVvdVOList);
			
		}else if(command.isCommand(FormCommand.MULTI)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setSourceBkg((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setBkgCodVvdVOs((BkgCodVvdVO[])getVOs(request, BkgCodVvdVO.class,"sheet5_"));
			event.setCodFlag(JSPUtil.getParameter(request, "codflag"));
			event.setCodRqstSeq(JSPUtil.getParameter(request, "cod_rqst_seq"));
			event.setCodRqstRsnCd(JSPUtil.getParameter(request, "cod_rqst_rsn_cd"));
			event.setCodFlag(JSPUtil.getParameter(request, "codflag"));
			event.setTvvd(JSPUtil.getParameter(request, "newVslCd")
					      +JSPUtil.getParameter(request, "newSkdVoyNo")
					      +JSPUtil.getParameter(request, "newSkdDirCd"));
			event.setCaRsnCd(JSPUtil.getParameter(request, "ca_rsn_cd"));
			event.setCaRemark(JSPUtil.getParameter(request, "ca_remark"));
			
			SplitBkgVO splitBkgVO = new SplitBkgVO();
			List<CopySplitBkgEtcVO>copySplitBkgEtcVOList = new ArrayList<CopySplitBkgEtcVO>();
			List<SplitBlInfoVO> splitBlInfoVOList = new ArrayList<SplitBlInfoVO>();
			SplitBlInfoVO[] splitBlInfoVOs = null;
			List<SplitQtyVO>splitQtyVOList = new ArrayList<SplitQtyVO>();
			List<SelectCntrVO>selectCntrVOList = new ArrayList<SelectCntrVO>();
			List<SelectTroVO>selectTroVOList = new ArrayList<SelectTroVO>();
			List<SelectSpclCgoVO>selectSpclCgoVOList = new ArrayList<SelectSpclCgoVO>();
			
			copySplitBkgEtcVOList.add((CopySplitBkgEtcVO)getVO(request, CopySplitBkgEtcVO.class));
			/**
			 * localTime 임시적으로 시스템 날짜 사용
			 */
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date currentTime = new Date();
	        String localTime=formatter.format(currentTime);
	        copySplitBkgEtcVOList.get(0).setLocaltime(localTime);
			
			//Split
			splitBlInfoVOs=(SplitBlInfoVO[])getVOs(request,SplitBlInfoVO.class,"sheet2_");
			BkgBlNoVO[] sTargetBkg =null;
			if (copySplitBkgEtcVOList.get(0).getSplitreason().toUpperCase().equals("M")){
				sTargetBkg = new BkgBlNoVO[splitBlInfoVOs.length-1];
				for(int i=1;i<splitBlInfoVOs.length;i++){
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
					
					bkgBlNoVO.setBkgNo(splitBlInfoVOs[i].getBkgNo());
					bkgBlNoVO.setBlNo(splitBlInfoVOs[i].getBlNo()); 
					sTargetBkg[i-1]=bkgBlNoVO;
					splitBlInfoVOList.add(splitBlInfoVOs[i]);
				}
			}else{
				sTargetBkg = new BkgBlNoVO[splitBlInfoVOs.length];
				for(int i=0;i<splitBlInfoVOs.length;i++){
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
					
					bkgBlNoVO.setBkgNo(splitBlInfoVOs[i].getBkgNo());
					bkgBlNoVO.setBlNo(splitBlInfoVOs[i].getBlNo()); 
					sTargetBkg[i]=bkgBlNoVO;
					splitBlInfoVOList.add(splitBlInfoVOs[i]);
				}
			}
			
			//Target BkgNo
			event.setTargetBkg(sTargetBkg);
			
			//Qty
			String[] arrSplitNo = null;
			String [] arrData=null;
			String qtySplitNo= JSPUtil.getParameter(request, "qtySplitNo");
			arrSplitNo= qtySplitNo.split("~");
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
					if (!strTmpBkg.equals(arrData[3])){
						strTmpBkg=arrData[3];
						selectSpclCgoVO.setSpclCagoFlag("D");
						selectSpclCgoVO.setCntrNo(arrData[0]);
						selectSpclCgoVO.setSpclCagoSeq(arrData[1]);
						selectSpclCgoVO.setSplitNo(arrData[2]);
						selectSpclCgoVO.setSplitreason(JSPUtil.getParameter(request, "splitreason"));
						selectSpclCgoVO.setBkg_no(arrData[3]);
						selectSpclCgoVOList.add(selectSpclCgoVO);
					}
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
					if (!strTmpBkg.equals(arrData[3])){
						strTmpBkg=arrData[3];
						selectSpclCgoVO.setSpclCagoFlag("R");
						selectSpclCgoVO.setCntrNo(arrData[0]);
						selectSpclCgoVO.setSpclCagoSeq(arrData[1]);
						selectSpclCgoVO.setSplitNo(arrData[2]);
						selectSpclCgoVO.setSplitreason(JSPUtil.getParameter(request, "splitreason"));
						selectSpclCgoVO.setBkg_no(arrData[3]);
						selectSpclCgoVOList.add(selectSpclCgoVO);
					}
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
					if (!strTmpBkg.equals(arrData[3])){
						strTmpBkg=arrData[3];
						selectSpclCgoVO.setSpclCagoFlag("A");
						selectSpclCgoVO.setCntrNo(arrData[0]);
						selectSpclCgoVO.setSpclCagoSeq(arrData[1]);
						selectSpclCgoVO.setSplitNo(arrData[2]);
						selectSpclCgoVO.setSplitreason(JSPUtil.getParameter(request, "splitreason"));
						selectSpclCgoVO.setBkg_no(arrData[3]);
						selectSpclCgoVOList.add(selectSpclCgoVO);
					}
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
					if (!strTmpBkg.equals(arrData[3])){
						strTmpBkg=arrData[3];
						selectSpclCgoVO.setSpclCagoFlag("B");
						//selectSpclCgoVO.setCntrNo(arrData[0]);
						selectSpclCgoVO.setSpclCagoSeq(arrData[1]);
						selectSpclCgoVO.setSplitNo(arrData[2]);
						selectSpclCgoVO.setSplitreason(JSPUtil.getParameter(request, "splitreason"));
						selectSpclCgoVO.setBkg_no(arrData[3]);
						selectSpclCgoVOList.add(selectSpclCgoVO);
					}
				}
			}
			//Tro
			String troSplitNo= JSPUtil.getParameter(request, "troSplitNo");
			arrSplitNo=null;
			strTmpBkg="";
			if (troSplitNo.length()>1){
				arrSplitNo= troSplitNo.split("~");
				for (int idx=0;idx<arrSplitNo.length;idx++){
					SelectTroVO selectTroVO = new SelectTroVO();
					arrData=null;
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
			
			splitBkgVO.setCopySplitBkgEtcVO(copySplitBkgEtcVOList);
			splitBkgVO.setSplitBlInfoVO(splitBlInfoVOList);
			splitBkgVO.setSplitQtyVO(splitQtyVOList);
			splitBkgVO.setSelectCntrVO(selectCntrVOList);
			splitBkgVO.setSelectSpclCgoVO(selectSpclCgoVOList);
			splitBkgVO.setSelectTroVO(selectTroVOList);
			event.setSplitBkgVO(splitBkgVO);
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