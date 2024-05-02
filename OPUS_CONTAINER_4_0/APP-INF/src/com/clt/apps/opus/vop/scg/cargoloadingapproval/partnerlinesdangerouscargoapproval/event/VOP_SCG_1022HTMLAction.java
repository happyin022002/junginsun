/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_1022HTMLAction.java
*@FileTitle : Dangerous CGO Application Details for Partner Lines
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.26 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event;

import java.util.List
;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstFileVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.clt.framework.component.attachment.file.upload.FileUpload;
import com.clt.framework.component.attachment.file.upload.FileUploadException;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.scg.cargoloadingapproval 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingApprovalSC로 실행요청<br>
 * - CargoLoadingApprovalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HyunUk Kim
 * @see CargoLoadingApprovalEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_1022HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_1022HTMLAction 객체를 생성
	 */
	public VOP_SCG_1022HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingApprovalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	VopScg1022Event event = new VopScg1022Event();
		
		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			
			try {
				FileUpload fileUpload = new FileUpload(request,"SCG", SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}

			event.setKeys((List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
        }
		
		FormCommand command = FormCommand.fromRequest(request);
		String[] prefixs = request.getParameterValues("IBPREFIX");
		

		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.SEARCH03)) {
			event.setScgPrnrAproRqstVO((ScgPrnrAproRqstVO)getVO(request, ScgPrnrAproRqstVO .class));
		} else if(command.isCommand(FormCommand.MULTI)) {
			ScgPrnrAproRqstVO[]     scgPrnrAproRqstVOs     = (ScgPrnrAproRqstVO[])getVOs	(request, ScgPrnrAproRqstVO.class		, prefixs[0]);
			ScgPrnrAproRqstCgoVO[]  scgPrnrAproRqstCgoVOs  = (ScgPrnrAproRqstCgoVO[])getVOs	(request, ScgPrnrAproRqstCgoVO.class	, prefixs[1]);
			ScgPrnrAproRqstFileVO[] scgPrnrAproRqstFileVOs = (ScgPrnrAproRqstFileVO[])getVOs(request, ScgPrnrAproRqstFileVO.class	, prefixs[2]);
			
			PartnerApprovalRequestVO partnerApprovalRequestVO = (PartnerApprovalRequestVO)getVO(request, PartnerApprovalRequestVO .class);
			log.debug(" ************************scgPrnrAproRqstVOs START ********************************");
			for(int i = 0; i< scgPrnrAproRqstVOs.length; i++) {
				log.debug("upd_dt"+ scgPrnrAproRqstVOs[i].getUpdDt());
				log.debug("spcl_cgo_rqst_seq"+ scgPrnrAproRqstVOs[i].getSpclCgoRqstSeq());
				log.debug("prnr_cgo_rqst_seq"+ scgPrnrAproRqstVOs[i].getPrnrCgoRqstSeq());
				
				log.debug("vsl_cd"+ scgPrnrAproRqstVOs[i].getVslCd());
				log.debug("rgn_shp_opr_cd"+ scgPrnrAproRqstVOs[i].getRgnShpOprCd());
				log.debug("eta_dt"+ scgPrnrAproRqstVOs[i].getEtaDt());
				log.debug("cre_dt"+ scgPrnrAproRqstVOs[i].getCreDt());
				log.debug("skd_voy_no"+ scgPrnrAproRqstVOs[i].getSkdVoyNo());
				log.debug("crr_cd"+ scgPrnrAproRqstVOs[i].getCrrCd());
				log.debug("skd_dir_cd"+ scgPrnrAproRqstVOs[i].getSkdDirCd());
				log.debug("pagerows"+ scgPrnrAproRqstVOs[i].getPagerows());
				log.debug("bkg_ref_no"+ scgPrnrAproRqstVOs[i].getBkgRefNo());
				log.debug("pod_cd"+ scgPrnrAproRqstVOs[i].getPodCd());
				log.debug("cgo_opr_cd"+ scgPrnrAproRqstVOs[i].getCgoOprCd());
				log.debug("cre_usr_id"+ scgPrnrAproRqstVOs[i].getCreUsrId());
				log.debug("dg_flg"+ scgPrnrAproRqstVOs[i].getDgFlg());
				log.debug("ibflag"+ scgPrnrAproRqstVOs[i].getIbflag());
				log.debug("pol_cd"+ scgPrnrAproRqstVOs[i].getPolCd());
				log.debug("slan_cd"+ scgPrnrAproRqstVOs[i].getSlanCd());
				log.debug("awk_flg"+ scgPrnrAproRqstVOs[i].getAwkFlg());
				log.debug("upd_usr_id"+ scgPrnrAproRqstVOs[i].getUpdUsrId());
				log.debug("dcgo_ref_no"+ scgPrnrAproRqstVOs[i].getDcgoRefNo());
			}
			log.debug(" ************************scgPrnrAproRqstVOs END ********************************");
			
			log.debug(" ************************scgPrnrAproRqstCgoVOs START ********************************");
			for(int i = 0; i< scgPrnrAproRqstVOs.length; i++) {
				log.debug("n3rd_imdg_subs_rsk_lbl_cd==>" +   scgPrnrAproRqstCgoVOs[i].getN3rdImdgSubsRskLblCd());
				log.debug("spcl_cgo_rqst_seq==>" +   scgPrnrAproRqstCgoVOs[i].getSpclCgoRqstSeq());
				log.debug("prnr_cgo_rqst_seq==>" +   scgPrnrAproRqstCgoVOs[i].getPrnrCgoRqstSeq());
				
				log.debug("imdg_un_no_seq==>" +   scgPrnrAproRqstCgoVOs[i].getImdgUnNoSeq());
				log.debug("imdg_subs_rsk_lbl_rmk==>" +   scgPrnrAproRqstCgoVOs[i].getImdgSubsRskLblRmk());
				log.debug("rada_skd_no==>" +   scgPrnrAproRqstCgoVOs[i].getRadaSkdNo());
				log.debug("n4th_imdg_subs_rsk_lbl_cd==>" +   scgPrnrAproRqstCgoVOs[i].getN4thImdgSubsRskLblCd());
				log.debug("pagerows==>" +   scgPrnrAproRqstCgoVOs[i].getPagerows());
				log.debug("imdg_comp_grp_cd==>" +   scgPrnrAproRqstCgoVOs[i].getImdgCompGrpCd());
				log.debug("cntr_tpsz_cd==>" +   scgPrnrAproRqstCgoVOs[i].getCntrTpszCd());
				log.debug("imdg_un_no==>" +   scgPrnrAproRqstCgoVOs[i].getImdgUnNo());
				log.debug("upd_usr_id==>" +   scgPrnrAproRqstCgoVOs[i].getUpdUsrId());
				log.debug("hcdg_flg==>" +   scgPrnrAproRqstCgoVOs[i].getHcdgFlg());
				log.debug("auth_ofc_cd==>" +   scgPrnrAproRqstCgoVOs[i].getAuthOfcCd());
				log.debug("hcdg_intmd_bc_rstr_desc==>" +   scgPrnrAproRqstCgoVOs[i].getHcdgIntmdBcRstrDesc());
				log.debug("spcl_cgo_cate_cd==>" +   scgPrnrAproRqstCgoVOs[i].getSpclCgoCateCd());
				log.debug("skd_voy_no==>" +   scgPrnrAproRqstCgoVOs[i].getSkdVoyNo());
				log.debug("void_slt_qty==>" +   scgPrnrAproRqstCgoVOs[i].getVoidSltQty());
				log.debug("pod_cd==>" +   scgPrnrAproRqstCgoVOs[i].getPodCd());
				log.debug("hgt_ovr_dim_len==>" +   scgPrnrAproRqstCgoVOs[i].getHgtOvrDimLen());
				log.debug("intmd_n2nd_imdg_pck_desc==>" +   scgPrnrAproRqstCgoVOs[i].getIntmdN2ndImdgPckDesc());
				log.debug("rada_amt==>" +   scgPrnrAproRqstCgoVOs[i].getRadaAmt());
				log.debug("net_explo_wgt==>" +   scgPrnrAproRqstCgoVOs[i].getNetExploWgt());
				log.debug("cmdt_desc==>" +   scgPrnrAproRqstCgoVOs[i].getCmdtDesc());
				log.debug("awk_flg==>" +   scgPrnrAproRqstCgoVOs[i].getAwkFlg());
				log.debug("emer_rspn_gid_no==>" +   scgPrnrAproRqstCgoVOs[i].getEmerRspnGidNo());
				log.debug("auth_usr_id==>" +   scgPrnrAproRqstCgoVOs[i].getAuthUsrId());
				log.debug("cnee_dtl_desc==>" +   scgPrnrAproRqstCgoVOs[i].getCneeDtlDesc());
				log.debug("imdg_clss_cd==>" +   scgPrnrAproRqstCgoVOs[i].getImdgClssCd());
				log.debug("emer_cntc_phn_no==>" +   scgPrnrAproRqstCgoVOs[i].getEmerCntcPhnNo());
				log.debug("imdg_pck_grp_cd==>" +   scgPrnrAproRqstCgoVOs[i].getImdgPckGrpCd());
				log.debug("meas_tp_cd==>" +   scgPrnrAproRqstCgoVOs[i].getMeasTpCd());
				log.debug("flsh_pnt_cdo_temp==>" +   scgPrnrAproRqstCgoVOs[i].getFlshPntCdoTemp());
				log.debug("imdg_lmt_qty_meas_ut_cd==>" +   scgPrnrAproRqstCgoVOs[i].getImdgLmtQtyMeasUtCd());
				log.debug("intmd_n2nd_imdg_pck_qty==>" +   scgPrnrAproRqstCgoVOs[i].getIntmdN2ndImdgPckQty());
				log.debug("intmd_n1st_imdg_pck_qty==>" +   scgPrnrAproRqstCgoVOs[i].getIntmdN1stImdgPckQty());
				log.debug("n1st_imdg_subs_rsk_lbl_cd==>" +   scgPrnrAproRqstCgoVOs[i].getN1stImdgSubsRskLblCd());
				log.debug("imdg_lmt_qty==>" +   scgPrnrAproRqstCgoVOs[i].getImdgLmtQty());
				log.debug("in_n1st_imdg_pck_cd==>" +   scgPrnrAproRqstCgoVOs[i].getInN1stImdgPckCd());
				log.debug("out_n2nd_imdg_pck_qty==>" +   scgPrnrAproRqstCgoVOs[i].getOutN2ndImdgPckQty());
				log.debug("ems_no==>" +   scgPrnrAproRqstCgoVOs[i].getEmsNo());
				log.debug("max_in_pck_qty==>" +   scgPrnrAproRqstCgoVOs[i].getMaxInPckQty());
				log.debug("in_n2nd_imdg_pck_desc==>" +   scgPrnrAproRqstCgoVOs[i].getInN2ndImdgPckDesc());
				log.debug("intmd_n1st_imdg_pck_cd==>" +   scgPrnrAproRqstCgoVOs[i].getIntmdN1stImdgPckCd());
				log.debug("pck_tp_cd==>" +   scgPrnrAproRqstCgoVOs[i].getPckTpCd());
				log.debug("spcl_stwg_rqst_desc==>" +   scgPrnrAproRqstCgoVOs[i].getSpclStwgRqstDesc());
				log.debug("slan_cd==>" +   scgPrnrAproRqstCgoVOs[i].getSlanCd());
				log.debug("diff_rmk==>" +   scgPrnrAproRqstCgoVOs[i].getDiffRmk());
				log.debug("out_n2nd_imdg_pck_desc==>" +   scgPrnrAproRqstCgoVOs[i].getOutN2ndImdgPckDesc());
				log.debug("auth_sts_cd==>" +   scgPrnrAproRqstCgoVOs[i].getAuthStsCd());
				log.debug("out_n1st_imdg_pck_cd==>" +   scgPrnrAproRqstCgoVOs[i].getOutN1stImdgPckCd());
				log.debug("vsl_cd==>" +   scgPrnrAproRqstCgoVOs[i].getVslCd());
				log.debug("ttl_dim_wdt==>" +   scgPrnrAproRqstCgoVOs[i].getTtlDimWdt());
				log.debug("psa_no==>" +   scgPrnrAproRqstCgoVOs[i].getPsaNo());
				log.debug("in_n2nd_imdg_pck_qty==>" +   scgPrnrAproRqstCgoVOs[i].getInN2ndImdgPckQty());
				log.debug("dcgo_sts_cd==>" +   scgPrnrAproRqstCgoVOs[i].getDcgoStsCd());
				log.debug("emer_cntc_pson_nm==>" +   scgPrnrAproRqstCgoVOs[i].getEmerCntcPsonNm());
				log.debug("out_n2nd_imdg_pck_cd==>" +   scgPrnrAproRqstCgoVOs[i].getOutN2ndImdgPckCd());
				log.debug("imdg_spcl_provi_no==>" +   scgPrnrAproRqstCgoVOs[i].getImdgSpclProviNo());
				log.debug("crr_cd==>" +   scgPrnrAproRqstCgoVOs[i].getCrrCd());
				log.debug("lf_sd_ovr_dim_len==>" +   scgPrnrAproRqstCgoVOs[i].getLfSdOvrDimLen());
				log.debug("pol_cd==>" +   scgPrnrAproRqstCgoVOs[i].getPolCd());
				log.debug("in_n2nd_imdg_pck_cd==>" +   scgPrnrAproRqstCgoVOs[i].getInN2ndImdgPckCd());
				log.debug("fwrd_ovr_dim_len==>" +   scgPrnrAproRqstCgoVOs[i].getFwrdOvrDimLen());
				log.debug("wgt_ut_cd==>" +   scgPrnrAproRqstCgoVOs[i].getWgtUtCd());
				log.debug("in_n1st_imdg_pck_qty==>" +   scgPrnrAproRqstCgoVOs[i].getInN1stImdgPckQty());
				log.debug("mrn_polut_flg==>" +   scgPrnrAproRqstCgoVOs[i].getMrnPolutFlg());
				log.debug("cntr_ref_no==>" +   scgPrnrAproRqstCgoVOs[i].getCntrRefNo());
				log.debug("auth_dt==>" +   scgPrnrAproRqstCgoVOs[i].getAuthDt());
				log.debug("net_wgt==>" +   scgPrnrAproRqstCgoVOs[i].getNetWgt());
				log.debug("spcl_cntr_seq==>" +   scgPrnrAproRqstCgoVOs[i].getSpclCntrSeq());
				log.debug("ttl_dim_hgt==>" +   scgPrnrAproRqstCgoVOs[i].getTtlDimHgt());
				log.debug("cre_usr_id==>" +   scgPrnrAproRqstCgoVOs[i].getCreUsrId());
				log.debug("cgo_lcl_flg==>" +   scgPrnrAproRqstCgoVOs[i].getCgoLclFlg());
				log.debug("hzd_desc==>" +   scgPrnrAproRqstCgoVOs[i].getHzdDesc());
				log.debug("ttl_dim_len==>" +   scgPrnrAproRqstCgoVOs[i].getTtlDimLen());
				log.debug("cgo_rqst_dt==>" +   scgPrnrAproRqstCgoVOs[i].getCgoRqstDt());
				log.debug("emer_rspn_gid_chr_no==>" +   scgPrnrAproRqstCgoVOs[i].getEmerRspnGidChrNo());
				log.debug("apro_ref_no==>" +   scgPrnrAproRqstCgoVOs[i].getAproRefNo());
				log.debug("emer_temp_ctnt==>" +   scgPrnrAproRqstCgoVOs[i].getEmerTempCtnt());
				log.debug("grs_wgt==>" +   scgPrnrAproRqstCgoVOs[i].getGrsWgt());
				log.debug("rt_sd_ovr_dim_len==>" +   scgPrnrAproRqstCgoVOs[i].getRtSdOvrDimLen());
				log.debug("spcl_cgo_seq==>" +   scgPrnrAproRqstCgoVOs[i].getSpclCgoSeq());
				log.debug("cre_dt==>" +   scgPrnrAproRqstCgoVOs[i].getCreDt());
				log.debug("rada_trsp_no==>" +   scgPrnrAproRqstCgoVOs[i].getRadaTrspNo());
				log.debug("max_in_pck_tp_cd==>" +   scgPrnrAproRqstCgoVOs[i].getMaxInPckTpCd());
				log.debug("rada_ut_cd==>" +   scgPrnrAproRqstCgoVOs[i].getRadaUtCd());
				log.debug("ibflag==>" +   scgPrnrAproRqstCgoVOs[i].getIbflag());
				log.debug("intmd_n1st_imdg_pck_desc==>" +   scgPrnrAproRqstCgoVOs[i].getIntmdN1stImdgPckDesc());
				log.debug("imdg_expt_qty_cd==>" +   scgPrnrAproRqstCgoVOs[i].getImdgExptQtyCd());
				log.debug("certi_no==>" +   scgPrnrAproRqstCgoVOs[i].getCertiNo());
				log.debug("meas_qty==>" +   scgPrnrAproRqstCgoVOs[i].getMeasQty());
				log.debug("pck_qty==>" +   scgPrnrAproRqstCgoVOs[i].getPckQty());
				log.debug("out_n1st_imdg_pck_qty==>" +   scgPrnrAproRqstCgoVOs[i].getOutN1stImdgPckQty());
				log.debug("hcdg_pck_rstr_desc==>" +   scgPrnrAproRqstCgoVOs[i].getHcdgPckRstrDesc());
				log.debug("in_n1st_imdg_pck_desc==>" +   scgPrnrAproRqstCgoVOs[i].getInN1stImdgPckDesc());
				log.debug("intmd_n2nd_imdg_pck_cd==>" +   scgPrnrAproRqstCgoVOs[i].getIntmdN2ndImdgPckCd());
				log.debug("imdg_expt_qty_flg==>" +   scgPrnrAproRqstCgoVOs[i].getImdgExptQtyFlg());
				log.debug("n2nd_imdg_subs_rsk_lbl_cd==>" +   scgPrnrAproRqstCgoVOs[i].getN2ndImdgSubsRskLblCd());
				log.debug("upd_dt==>" +   scgPrnrAproRqstCgoVOs[i].getUpdDt());
				log.debug("clod_flg==>" +   scgPrnrAproRqstCgoVOs[i].getClodFlg());
				log.debug("bkwd_ovr_dim_len==>" +   scgPrnrAproRqstCgoVOs[i].getBkwdOvrDimLen());
				log.debug("imdg_co_grp_cd==>" +   scgPrnrAproRqstCgoVOs[i].getImdgCoGrpCd());
				log.debug("skd_dir_cd==>" +   scgPrnrAproRqstCgoVOs[i].getSkdDirCd());
				log.debug("bkg_ref_no==>" +   scgPrnrAproRqstCgoVOs[i].getBkgRefNo());
				log.debug("dg_flg==>" +   scgPrnrAproRqstCgoVOs[i].getDgFlg());
				log.debug("cgo_opr_cd==>" +   scgPrnrAproRqstCgoVOs[i].getCgoOprCd());
				log.debug("ctrl_temp_ctnt==>" +   scgPrnrAproRqstCgoVOs[i].getCtrlTempCtnt());
				log.debug("hcdg_tnk_rstr_desc==>" +       scgPrnrAproRqstCgoVOs[i].getHcdgTnkRstrDesc());
				log.debug("out_n1st_imdg_pck_desc==>" +   scgPrnrAproRqstCgoVOs[i].getOutN1stImdgPckDesc());
				log.debug("prp_shp_nm==>" +               scgPrnrAproRqstCgoVOs[i].getPrpShpNm());
				log.debug("imdg_lmt_qty_flg==>" +         scgPrnrAproRqstCgoVOs[i].getImdgLmtQtyFlg());
			}
			log.debug(" ************************scgPrnrAproRqstCgoVOs END ********************************");

			partnerApprovalRequestVO.setMode(request.getParameter("mode"));
			partnerApprovalRequestVO.setScgPrnrAproRqstVOs(scgPrnrAproRqstVOs);
			partnerApprovalRequestVO.setScgPrnrAproRqstCgoVOs(scgPrnrAproRqstCgoVOs);
			partnerApprovalRequestVO.setScgPrnrAproRqstFileVOs(scgPrnrAproRqstFileVOs);
			
			event.setPartnerApprovalRequestVO(partnerApprovalRequestVO);
		} else if(command.isCommand(FormCommand.MODIFY)) {
			event.setScgPrnrAproRqstVO((ScgPrnrAproRqstVO)getVO(request, ScgPrnrAproRqstVO.class));
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