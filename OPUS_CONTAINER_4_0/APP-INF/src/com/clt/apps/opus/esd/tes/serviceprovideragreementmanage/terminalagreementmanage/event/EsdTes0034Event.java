/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes0034Event.java
*@FileTitle : Terminal Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-08
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-08 jongbaemoon
* 1.0 최초 생성
* 
*@LastModifyDate : 2009.08.24
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.24 yOng hO lEE
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.TesAgreementManageCommonVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlAgmtAplyDyVO;
import com.clt.syscommon.common.table.TesTmlAgmtDgCgoClssVO;
import com.clt.syscommon.common.table.TesTmlAgmtDtlVO;
import com.clt.syscommon.common.table.TesTmlAgmtHdrVO;
import com.clt.syscommon.common.table.TesTmlAgmtThrpCostVO;
import com.clt.syscommon.common.table.TesTmlAgmtTpSzVO;
import com.clt.syscommon.common.table.TesTmlAgmtVrfyMzdVO;
import com.clt.syscommon.common.table.TesTmlSoAccmCostVO;
import com.clt.syscommon.common.table.TesTmlSoAccmMzdVO;
import com.clt.syscommon.common.table.TesTmlSoAccmYdVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;




/**
 * ESD_TES_034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 * 
 * ESD_TES_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_0034HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTes0034Event extends EventSupport {

	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesCommonVO 					tesCommonVO							= null;
	private TesAgreementManageCommonVO 		tesAgreementManageCommonVO			= null;
	private TesTmlAgmtHdrVO 				tesTmlAgmtHdrVO						= null;
	private TesTmlAgmtDtlVO 				tesTmlAgmtDtlVO						= null;
	private TesTmlAgmtDgCgoClssVO			tesTmlAgmtDgCgoClssVO				= null;
	private TesTmlAgmtAplyDyVO				tesTmlAgmtAplyDyVO					= null;
	private TesTmlAgmtThrpCostVO			tesTmlAgmtThrpCostVO				= null;
	private TesTmlAgmtTpSzVO				tesTmlAgmtTpSzVO					= null;
	private TesTmlAgmtVrfyMzdVO				tesTmlAgmtVrfyMzdVO					= null;
	private TesTmlSoAccmMzdVO				tesTmlSoAccmMzdVO					= null;
	private TesTmlSoAccmCostVO				tesTmlSoAccmCostVO					= null;
	private TesTmlSoAccmYdVO				tesTmlSoAccmYdVO					= null;
	private TesTmlSoHdrVO					tesTmlSoHdrVO					= null;
	
	/** Table Value Object Multi Data 처리 */
	private TesCommonVO[]					tesCommonVOs						= null;
	private TesAgreementManageCommonVO[]	tesAgreementManageCommonVOs			= null;
	private TesTmlAgmtHdrVO[] 				tesTmlAgmtHdrVOs					= null;
	private TesTmlAgmtDtlVO[] 				tesTmlAgmtDtlVOs					= null;
	private TesTmlAgmtDgCgoClssVO[]			tesTmlAgmtDgCgoClssVOs				= null;
	private TesTmlAgmtAplyDyVO[]			tesTmlAgmtAplyDyVOs					= null;
	private TesTmlAgmtThrpCostVO[]			tesTmlAgmtThrpCostVOs				= null;
	private TesTmlAgmtTpSzVO[]				tesTmlAgmtTpSzVOs					= null;
	private TesTmlAgmtVrfyMzdVO[]			tesTmlAgmtVrfyMzdVOs				= null;
	private TesTmlSoAccmMzdVO[]				tesTmlSoAccmMzdVOs					= null;
	private TesTmlSoAccmCostVO[]			tesTmlSoAccmCostVOs					= null;
	private TesTmlSoAccmYdVO[]				tesTmlSoAccmYdVOs					= null;

	public EsdTes0034Event(){}

	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}

	public void setTesCommonVO(TesCommonVO tesCommonVO) {
		this.tesCommonVO = tesCommonVO;
	}

	public TesAgreementManageCommonVO getTesAgreementManageCommonVO() {
		return tesAgreementManageCommonVO;
	}

	public void setTesAgreementManageCommonVO(
			TesAgreementManageCommonVO tesAgreementManageCommonVO) {
		this.tesAgreementManageCommonVO = tesAgreementManageCommonVO;
	}

	public TesTmlAgmtHdrVO getTesTmlAgmtHdrVO() {
		return tesTmlAgmtHdrVO;
	}

	public void setTesTmlAgmtHdrVO(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) {
		this.tesTmlAgmtHdrVO = tesTmlAgmtHdrVO;
	}

	public TesTmlAgmtDtlVO getTesTmlAgmtDtlVO() {
		return tesTmlAgmtDtlVO;
	}

	public void setTesTmlAgmtDtlVO(TesTmlAgmtDtlVO tesTmlAgmtDtlVO) {
		this.tesTmlAgmtDtlVO = tesTmlAgmtDtlVO;
	}

	public TesTmlAgmtDgCgoClssVO getTesTmlAgmtDgCgoClssVO() {
		return tesTmlAgmtDgCgoClssVO;
	}

	public void setTesTmlAgmtDgCgoClssVO(TesTmlAgmtDgCgoClssVO tesTmlAgmtDgCgoClssVO) {
		this.tesTmlAgmtDgCgoClssVO = tesTmlAgmtDgCgoClssVO;
	}

	public TesTmlAgmtAplyDyVO getTesTmlAgmtAplyDyVO() {
		return tesTmlAgmtAplyDyVO;
	}

	public void setTesTmlAgmtAplyDyVO(TesTmlAgmtAplyDyVO tesTmlAgmtAplyDyVO) {
		this.tesTmlAgmtAplyDyVO = tesTmlAgmtAplyDyVO;
	}

	public TesTmlAgmtThrpCostVO getTesTmlAgmtThrpCostVO() {
		return tesTmlAgmtThrpCostVO;
	}

	public void setTesTmlAgmtThrpCostVO(TesTmlAgmtThrpCostVO tesTmlAgmtThrpCostVO) {
		this.tesTmlAgmtThrpCostVO = tesTmlAgmtThrpCostVO;
	}

	public TesTmlAgmtTpSzVO getTesTmlAgmtTpSzVO() {
		return tesTmlAgmtTpSzVO;
	}

	public void setTesTmlAgmtTpSzVO(TesTmlAgmtTpSzVO tesTmlAgmtTpSzVO) {
		this.tesTmlAgmtTpSzVO = tesTmlAgmtTpSzVO;
	}

	public TesTmlAgmtVrfyMzdVO getTesTmlAgmtVrfyMzdVO() {
		return tesTmlAgmtVrfyMzdVO;
	}

	public void setTesTmlAgmtVrfyMzdVO(TesTmlAgmtVrfyMzdVO tesTmlAgmtVrfyMzdVO) {
		this.tesTmlAgmtVrfyMzdVO = tesTmlAgmtVrfyMzdVO;
	}

	public TesTmlSoAccmMzdVO getTesTmlSoAccmMzdVO() {
		return tesTmlSoAccmMzdVO;
	}

	public void setTesTmlSoAccmMzdVO(TesTmlSoAccmMzdVO tesTmlSoAccmMzdVO) {
		this.tesTmlSoAccmMzdVO = tesTmlSoAccmMzdVO;
	}

	public TesTmlSoAccmCostVO getTesTmlSoAccmCostVO() {
		return tesTmlSoAccmCostVO;
	}

	public void setTesTmlSoAccmCostVO(TesTmlSoAccmCostVO tesTmlSoAccmCostVO) {
		this.tesTmlSoAccmCostVO = tesTmlSoAccmCostVO;
	}

	public TesTmlSoAccmYdVO getTesTmlSoAccmYdVO() {
		return tesTmlSoAccmYdVO;
	}

	public void setTesTmlSoAccmYdVO(TesTmlSoAccmYdVO tesTmlSoAccmYdVO) {
		this.tesTmlSoAccmYdVO = tesTmlSoAccmYdVO;
	}

	public TesCommonVO[] getTesCommonVOs() {
		TesCommonVO[] rtnVOs = null;
		if (this.tesCommonVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesCommonVOs, tesCommonVOs.length);
		}
		return rtnVOs;
	}

	public void setTesCommonVOs(TesCommonVO[] tesCommonVOs){
		if(tesCommonVOs != null){
			TesCommonVO[] tmpVOs = java.util.Arrays.copyOf(tesCommonVOs, tesCommonVOs.length);
			this.tesCommonVOs = tmpVOs;
		}
	}

	public TesAgreementManageCommonVO[] getTesAgreementManageCommonVOs() {
		TesAgreementManageCommonVO[] rtnVOs = null;
		if (this.tesAgreementManageCommonVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesAgreementManageCommonVOs, tesAgreementManageCommonVOs.length);
		}
		return rtnVOs;
	}

	public void setTesAgreementManageCommonVOs(TesAgreementManageCommonVO[] tesAgreementManageCommonVOs){
		if(tesAgreementManageCommonVOs != null){
			TesAgreementManageCommonVO[] tmpVOs = java.util.Arrays.copyOf(tesAgreementManageCommonVOs, tesAgreementManageCommonVOs.length);
			this.tesAgreementManageCommonVOs = tmpVOs;
		}
	}

	public TesTmlAgmtHdrVO[] getTesTmlAgmtHdrVOs() {
		TesTmlAgmtHdrVO[] rtnVOs = null;
		if (this.tesTmlAgmtHdrVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesTmlAgmtHdrVOs, tesTmlAgmtHdrVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlAgmtHdrVOs(TesTmlAgmtHdrVO[] tesTmlAgmtHdrVOs){
		if(tesTmlAgmtHdrVOs != null){
			TesTmlAgmtHdrVO[] tmpVOs = java.util.Arrays.copyOf(tesTmlAgmtHdrVOs, tesTmlAgmtHdrVOs.length);
			this.tesTmlAgmtHdrVOs = tmpVOs;
		}
	}

	public TesTmlAgmtDtlVO[] getTesTmlAgmtDtlVOs() {
		TesTmlAgmtDtlVO[] rtnVOs = null;
		if (this.tesTmlAgmtDtlVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesTmlAgmtDtlVOs, tesTmlAgmtDtlVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlAgmtDtlVOs(TesTmlAgmtDtlVO[] tesTmlAgmtDtlVOs){
		if(tesTmlAgmtDtlVOs != null){
			TesTmlAgmtDtlVO[] tmpVOs = java.util.Arrays.copyOf(tesTmlAgmtDtlVOs, tesTmlAgmtDtlVOs.length);
			this.tesTmlAgmtDtlVOs = tmpVOs;
		}
	}

	public TesTmlAgmtDgCgoClssVO[] getTesTmlAgmtDgCgoClssVOs() {
		TesTmlAgmtDgCgoClssVO[] rtnVOs = null;
		if (this.tesTmlAgmtDgCgoClssVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesTmlAgmtDgCgoClssVOs, tesTmlAgmtDgCgoClssVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlAgmtDgCgoClssVOs(TesTmlAgmtDgCgoClssVO[] tesTmlAgmtDgCgoClssVOs){
		if(tesTmlAgmtDgCgoClssVOs != null){
			TesTmlAgmtDgCgoClssVO[] tmpVOs = java.util.Arrays.copyOf(tesTmlAgmtDgCgoClssVOs, tesTmlAgmtDgCgoClssVOs.length);
			this.tesTmlAgmtDgCgoClssVOs = tmpVOs;
		}
	}

	public TesTmlAgmtAplyDyVO[] getTesTmlAgmtAplyDyVOs() {
		TesTmlAgmtAplyDyVO[] rtnVOs = null;
		if (this.tesTmlAgmtAplyDyVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesTmlAgmtAplyDyVOs, tesTmlAgmtAplyDyVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlAgmtAplyDyVOs(TesTmlAgmtAplyDyVO[] tesTmlAgmtAplyDyVOs){
		if(tesTmlAgmtAplyDyVOs != null){
			TesTmlAgmtAplyDyVO[] tmpVOs = java.util.Arrays.copyOf(tesTmlAgmtAplyDyVOs, tesTmlAgmtAplyDyVOs.length);
			this.tesTmlAgmtAplyDyVOs = tmpVOs;
		}
	}

	public TesTmlAgmtThrpCostVO[] getTesTmlAgmtThrpCostVOs() {
		TesTmlAgmtThrpCostVO[] rtnVOs = null;
		if (this.tesTmlAgmtThrpCostVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesTmlAgmtThrpCostVOs, tesTmlAgmtThrpCostVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlAgmtThrpCostVOs(TesTmlAgmtThrpCostVO[] tesTmlAgmtThrpCostVOs){
		if(tesTmlAgmtThrpCostVOs != null){
			TesTmlAgmtThrpCostVO[] tmpVOs = java.util.Arrays.copyOf(tesTmlAgmtThrpCostVOs, tesTmlAgmtThrpCostVOs.length);
			this.tesTmlAgmtThrpCostVOs = tmpVOs;
		}
	}

	public TesTmlAgmtTpSzVO[] getTesTmlAgmtTpSzVOs() {
		TesTmlAgmtTpSzVO[] rtnVOs = null;
		if (this.tesTmlAgmtTpSzVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesTmlAgmtTpSzVOs, tesTmlAgmtTpSzVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlAgmtTpSzVOs(TesTmlAgmtTpSzVO[] tesTmlAgmtTpSzVOs){
		if(tesTmlAgmtTpSzVOs != null){
			TesTmlAgmtTpSzVO[] tmpVOs = java.util.Arrays.copyOf(tesTmlAgmtTpSzVOs, tesTmlAgmtTpSzVOs.length);
			this.tesTmlAgmtTpSzVOs = tmpVOs;
		}
	}

	public TesTmlAgmtVrfyMzdVO[] getTesTmlAgmtVrfyMzdVOs() {
		TesTmlAgmtVrfyMzdVO[] rtnVOs = null;
		if (this.tesTmlAgmtVrfyMzdVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesTmlAgmtVrfyMzdVOs, tesTmlAgmtVrfyMzdVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlAgmtVrfyMzdVOs(TesTmlAgmtVrfyMzdVO[] tesTmlAgmtVrfyMzdVOs){
		if(tesTmlAgmtVrfyMzdVOs != null){
			TesTmlAgmtVrfyMzdVO[] tmpVOs = java.util.Arrays.copyOf(tesTmlAgmtVrfyMzdVOs, tesTmlAgmtVrfyMzdVOs.length);
			this.tesTmlAgmtVrfyMzdVOs = tmpVOs;
		}
	}

	public TesTmlSoAccmMzdVO[] getTesTmlSoAccmMzdVOs() {
		TesTmlSoAccmMzdVO[] rtnVOs = null;
		if (this.tesTmlSoAccmMzdVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesTmlSoAccmMzdVOs, tesTmlSoAccmMzdVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlSoAccmMzdVOs(TesTmlSoAccmMzdVO[] tesTmlSoAccmMzdVOs){
		if(tesTmlSoAccmMzdVOs != null){
			TesTmlSoAccmMzdVO[] tmpVOs = java.util.Arrays.copyOf(tesTmlSoAccmMzdVOs, tesTmlSoAccmMzdVOs.length);
			this.tesTmlSoAccmMzdVOs = tmpVOs;
		}
	}

	public TesTmlSoAccmCostVO[] getTesTmlSoAccmCostVOs() {
		TesTmlSoAccmCostVO[] rtnVOs = null;
		if (this.tesTmlSoAccmCostVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesTmlSoAccmCostVOs, tesTmlSoAccmCostVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlSoAccmCostVOs(TesTmlSoAccmCostVO[] tesTmlSoAccmCostVOs){
		if(tesTmlSoAccmCostVOs != null){
			TesTmlSoAccmCostVO[] tmpVOs = java.util.Arrays.copyOf(tesTmlSoAccmCostVOs, tesTmlSoAccmCostVOs.length);
			this.tesTmlSoAccmCostVOs = tmpVOs;
		}
	}

	public TesTmlSoAccmYdVO[] getTesTmlSoAccmYdVOs() {
		TesTmlSoAccmYdVO[] rtnVOs = null;
		if (this.tesTmlSoAccmYdVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesTmlSoAccmYdVOs, tesTmlSoAccmYdVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlSoAccmYdVOs(TesTmlSoAccmYdVO[] tesTmlSoAccmYdVOs){
		if(tesTmlSoAccmYdVOs != null){
			TesTmlSoAccmYdVO[] tmpVOs = java.util.Arrays.copyOf(tesTmlSoAccmYdVOs, tesTmlSoAccmYdVOs.length);
			this.tesTmlSoAccmYdVOs = tmpVOs;
		}
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}
	
	
//	/** tes_tml_agmt_aply_dy Table  Value Object */
//	private TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy = null;
//
//	/** tes_tml_agmt_aply_dys Multi Action을 위한 Collection */
//	private Collection tes_tml_agmt_aply_dys = null;
//
//	/** tes_tml_agmt_dg_cgo_clss Table  Value Object */
//	private TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss = null;
//
//	/** tes_tml_agmt_dg_cgo_clsss Multi Action을 위한 Collection */
//	private Collection tes_tml_agmt_dg_cgo_clsss = null;
//
//	/** tes_tml_agmt_dtl Table  Value Object */
//	private TES_TML_AGMT_DTL tes_tml_agmt_dtl = null;
//
//	/** tes_tml_agmt_dtls Multi Action을 위한 Collection */
//	private Collection tes_tml_agmt_dtls = null;
//
//	/** tes_tml_agmt_hdr Table  Value Object */
//	private TES_TML_AGMT_HDR tes_tml_agmt_hdr = null;
//
//	/** tes_tml_agmt_hdrs Multi Action을 위한 Collection */
//	private Collection tes_tml_agmt_hdrs = null;
//
//	/** tes_tml_agmt_thrp_cost Table  Value Object */
//	private TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost = null;
//
//	/** tes_tml_agmt_thrp_costs Multi Action을 위한 Collection */
//	private Collection tes_tml_agmt_thrp_costs = null;
//
//	/** tes_tml_agmt_tp_sz Table  Value Object */
//	private TES_TML_AGMT_TP_SZ tes_tml_agmt_tp_sz = null;
//
//	/** tes_tml_agmt_tp_szs Multi Action을 위한 Collection */
//	private Collection tes_tml_agmt_tp_szs = null;
//
//	/** tes_tml_so_accm_mzd Table  Value Object */
//	private TES_TML_SO_ACCM_MZD tes_tml_so_accm_mzd = null;
//
//	/** tes_tml_so_accm_mzds Multi Action을 위한 Collection */
//	private Collection tes_tml_so_accm_mzds = null;
//
//	/** tes_tml_so_accm_yd Table  Value Object */
//	private TES_TML_SO_ACCM_YD tes_tml_so_accm_yd = null;
//
//	/** tes_tml_so_accm_yds Multi Action을 위한 Collection */
//	private Collection tes_tml_so_accm_yds = null;
//	
//	/** tes_tml_so_accm_yds Multi Action을 위한 Collection */
//	private Collection terminalagreement_vos = null;
//	
//	/** tes_tml_agmt_vrfy_mzd Table  Value Object */
//	private TES_TML_AGMT_VRFY_MZD tes_tml_agmt_vrfy_mzd = null;
//	
//	/** tes_tml_agmt_vrfy_mzds Multi Action을 위한 Collection */
//	private Collection tes_tml_agmt_vrfy_mzds = null;	
//	
//    /** amend_cd 변수 (Form 객체) */
//    private String amend_cd = null;
//    private String tml_agmt_ofc_no = null;
//    private String tp_szflg = null;	
//    
//    private java.util.HashMap param_map = null;
//
//	public EsdTes0034Event(){}
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, String amend_cd , String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;		
//    }
//	
//	public EsdTes0034Event(TES_TML_AGMT_HDR tes_tml_agmt_hdr, TES_TML_AGMT_DTL tes_tml_agmt_dtl, String amend_cd , String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;		
//    }	
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, String amend_cd , String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;		
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, String amend_cd , String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;		
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, String amend_cd , String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;		
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, String amend_cd , String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;		
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, String amend_cd , String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;		
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, String amend_cd , String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, Collection tes_tml_agmt_hdrs, String amend_cd, String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_hdrs = tes_tml_agmt_hdrs;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, Collection tes_tml_agmt_hdrs, TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost, String amend_cd, String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_hdrs = tes_tml_agmt_hdrs;
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, Collection tes_tml_agmt_hdrs, TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost, Collection tes_tml_agmt_thrp_costs, String amend_cd, String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_hdrs = tes_tml_agmt_hdrs;
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//		this.tes_tml_agmt_thrp_costs = tes_tml_agmt_thrp_costs;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, Collection tes_tml_agmt_hdrs, TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost, Collection tes_tml_agmt_thrp_costs, TES_TML_AGMT_TP_SZ tes_tml_agmt_tp_sz, String amend_cd, String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_hdrs = tes_tml_agmt_hdrs;
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//		this.tes_tml_agmt_thrp_costs = tes_tml_agmt_thrp_costs;
//		this.tes_tml_agmt_tp_sz = tes_tml_agmt_tp_sz;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, Collection tes_tml_agmt_hdrs, TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost, Collection tes_tml_agmt_thrp_costs, TES_TML_AGMT_TP_SZ tes_tml_agmt_tp_sz, Collection tes_tml_agmt_tp_szs, String amend_cd, String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_hdrs = tes_tml_agmt_hdrs;
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//		this.tes_tml_agmt_thrp_costs = tes_tml_agmt_thrp_costs;
//		this.tes_tml_agmt_tp_sz = tes_tml_agmt_tp_sz;
//		this.tes_tml_agmt_tp_szs = tes_tml_agmt_tp_szs;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, Collection tes_tml_agmt_hdrs, TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost, Collection tes_tml_agmt_thrp_costs, TES_TML_AGMT_TP_SZ tes_tml_agmt_tp_sz, Collection tes_tml_agmt_tp_szs, TES_TML_SO_ACCM_MZD tes_tml_so_accm_mzd, String amend_cd, String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_hdrs = tes_tml_agmt_hdrs;
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//		this.tes_tml_agmt_thrp_costs = tes_tml_agmt_thrp_costs;
//		this.tes_tml_agmt_tp_sz = tes_tml_agmt_tp_sz;
//		this.tes_tml_agmt_tp_szs = tes_tml_agmt_tp_szs;
//		this.tes_tml_so_accm_mzd = tes_tml_so_accm_mzd;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, Collection tes_tml_agmt_hdrs, TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost, Collection tes_tml_agmt_thrp_costs, TES_TML_AGMT_TP_SZ tes_tml_agmt_tp_sz, Collection tes_tml_agmt_tp_szs, TES_TML_SO_ACCM_MZD tes_tml_so_accm_mzd, Collection tes_tml_so_accm_mzds, String amend_cd, String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_hdrs = tes_tml_agmt_hdrs;
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//		this.tes_tml_agmt_thrp_costs = tes_tml_agmt_thrp_costs;
//		this.tes_tml_agmt_tp_sz = tes_tml_agmt_tp_sz;
//		this.tes_tml_agmt_tp_szs = tes_tml_agmt_tp_szs;
//		this.tes_tml_so_accm_mzd = tes_tml_so_accm_mzd;
//		this.tes_tml_so_accm_mzds = tes_tml_so_accm_mzds;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, Collection tes_tml_agmt_hdrs, TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost, Collection tes_tml_agmt_thrp_costs, TES_TML_AGMT_TP_SZ tes_tml_agmt_tp_sz, Collection tes_tml_agmt_tp_szs, TES_TML_SO_ACCM_MZD tes_tml_so_accm_mzd, Collection tes_tml_so_accm_mzds, TES_TML_SO_ACCM_YD tes_tml_so_accm_yd, String amend_cd, String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_hdrs = tes_tml_agmt_hdrs;
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//		this.tes_tml_agmt_thrp_costs = tes_tml_agmt_thrp_costs;
//		this.tes_tml_agmt_tp_sz = tes_tml_agmt_tp_sz;
//		this.tes_tml_agmt_tp_szs = tes_tml_agmt_tp_szs;
//		this.tes_tml_so_accm_mzd = tes_tml_so_accm_mzd;
//		this.tes_tml_so_accm_mzds = tes_tml_so_accm_mzds;
//		this.tes_tml_so_accm_yd = tes_tml_so_accm_yd;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//    }
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, Collection tes_tml_agmt_aply_dys, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, Collection tes_tml_agmt_hdrs, TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost, Collection tes_tml_agmt_thrp_costs, TES_TML_AGMT_TP_SZ tes_tml_agmt_tp_sz, Collection tes_tml_agmt_tp_szs, TES_TML_SO_ACCM_MZD tes_tml_so_accm_mzd, Collection tes_tml_so_accm_mzds, TES_TML_SO_ACCM_YD tes_tml_so_accm_yd, Collection tes_tml_so_accm_yds, String amend_cd, String tml_agmt_ofc_no) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_hdrs = tes_tml_agmt_hdrs;
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//		this.tes_tml_agmt_thrp_costs = tes_tml_agmt_thrp_costs;
//		this.tes_tml_agmt_tp_sz = tes_tml_agmt_tp_sz;
//		this.tes_tml_agmt_tp_szs = tes_tml_agmt_tp_szs;
//		this.tes_tml_so_accm_mzd = tes_tml_so_accm_mzd;
//		this.tes_tml_so_accm_mzds = tes_tml_so_accm_mzds;
//		this.tes_tml_so_accm_yd = tes_tml_so_accm_yd;
//		this.tes_tml_so_accm_yds = tes_tml_so_accm_yds;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//    }
//	
//	public EsdTes0034Event(Collection tes_tml_agmt_aply_dys, Collection tes_tml_agmt_dg_cgo_clsss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, Collection tes_tml_agmt_dtls, TES_TML_AGMT_HDR tes_tml_agmt_hdr, Collection tes_tml_agmt_vrfy_mzds, Collection terminalagreement_vos, String amend_cd, String tml_agmt_ofc_no, java.util.HashMap param_map) {
//		this.tes_tml_agmt_aply_dys = tes_tml_agmt_aply_dys;		
//		this.tes_tml_agmt_dg_cgo_clsss = tes_tml_agmt_dg_cgo_clsss;		
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_dtls = tes_tml_agmt_dtls;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_vrfy_mzds = tes_tml_agmt_vrfy_mzds;
//		this.terminalagreement_vos = terminalagreement_vos;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//		this.param_map = param_map;
//    }	
//
//	public EsdTes0034Event(TES_TML_AGMT_APLY_DY tes_tml_agmt_aply_dy, TES_TML_AGMT_DG_CGO_CLSS tes_tml_agmt_dg_cgo_clss, TES_TML_AGMT_DTL tes_tml_agmt_dtl, TES_TML_AGMT_HDR tes_tml_agmt_hdr, TES_TML_AGMT_THRP_COST tes_tml_agmt_thrp_cost, TES_TML_AGMT_TP_SZ tes_tml_agmt_tp_sz, TES_TML_SO_ACCM_MZD tes_tml_so_accm_mzd, TES_TML_SO_ACCM_YD tes_tml_so_accm_yd, String amend_cd, String tml_agmt_ofc_no, java.util.HashMap param_map) {
//		this.tes_tml_agmt_aply_dy = tes_tml_agmt_aply_dy;
//		this.tes_tml_agmt_dg_cgo_clss = tes_tml_agmt_dg_cgo_clss;
//		this.tes_tml_agmt_dtl = tes_tml_agmt_dtl;
//		this.tes_tml_agmt_hdr = tes_tml_agmt_hdr;
//		this.tes_tml_agmt_thrp_cost = tes_tml_agmt_thrp_cost;
//		this.tes_tml_agmt_tp_sz = tes_tml_agmt_tp_sz;
//		this.tes_tml_so_accm_mzd = tes_tml_so_accm_mzd;
//		this.tes_tml_so_accm_yd = tes_tml_so_accm_yd;
//		this.amend_cd = amend_cd;
//		this.tml_agmt_ofc_no = tml_agmt_ofc_no;
//		this.param_map = param_map;
//    }
//	
//	public EsdTes0034Event(TES_TML_AGMT_VRFY_MZD tes_tml_agmt_vrfy_mzd) {
//		this.tes_tml_agmt_vrfy_mzd = tes_tml_agmt_vrfy_mzd;
//    }
//	
//	public EsdTes0034Event(TES_TML_AGMT_VRFY_MZD tes_tml_agmt_vrfy_mzd, Collection tes_tml_agmt_vrfy_mzds, HashMap param_map) {
//		this.tes_tml_agmt_vrfy_mzds = tes_tml_agmt_vrfy_mzds;
//		this.tes_tml_agmt_vrfy_mzd = tes_tml_agmt_vrfy_mzd;
//		this.param_map = param_map;
//    }		
//
//	public TES_TML_AGMT_APLY_DY getTES_TML_AGMT_APLY_DY(){
//		return tes_tml_agmt_aply_dy;
//	}
//
//	public Collection getTES_TML_AGMT_APLY_DYS(){
//		return tes_tml_agmt_aply_dys;
//	}
//
//	public TES_TML_AGMT_DG_CGO_CLSS getTES_TML_AGMT_DG_CGO_CLSS(){
//		return tes_tml_agmt_dg_cgo_clss;
//	}
//
//	public Collection getTES_TML_AGMT_DG_CGO_CLSSS(){
//		return tes_tml_agmt_dg_cgo_clsss;
//	}
//
//	public TES_TML_AGMT_DTL getTES_TML_AGMT_DTL(){
//		return tes_tml_agmt_dtl;
//	}
//
//	public Collection getTES_TML_AGMT_DTLS(){
//		return tes_tml_agmt_dtls;
//	}
//
//	public TES_TML_AGMT_HDR getTES_TML_AGMT_HDR(){
//		return tes_tml_agmt_hdr;
//	}
//
//	public Collection getTES_TML_AGMT_HDRS(){
//		return tes_tml_agmt_hdrs;
//	}
//
//	public TES_TML_AGMT_THRP_COST getTES_TML_AGMT_THRP_COST(){
//		return tes_tml_agmt_thrp_cost;
//	}
//
//	public Collection getTES_TML_AGMT_THRP_COSTS(){
//		return tes_tml_agmt_thrp_costs;
//	}
//
//	public TES_TML_AGMT_TP_SZ getTES_TML_AGMT_TP_SZ(){
//		return tes_tml_agmt_tp_sz;
//	}
//
//	public Collection getTES_TML_AGMT_TP_SZS(){
//		return tes_tml_agmt_tp_szs;
//	}
//
//	public TES_TML_SO_ACCM_MZD getTES_TML_SO_ACCM_MZD(){
//		return tes_tml_so_accm_mzd;
//	}
//
//	public Collection getTES_TML_SO_ACCM_MZDS(){
//		return tes_tml_so_accm_mzds;
//	}
//
//	public TES_TML_SO_ACCM_YD getTES_TML_SO_ACCM_YD(){
//		return tes_tml_so_accm_yd;
//	}
//
//	public Collection getTES_TML_SO_ACCM_YDS(){
//		return tes_tml_so_accm_yds;
//	}
//	
//	public TES_TML_AGMT_VRFY_MZD getTES_TML_AGMT_VRFY_MZD(){
//		return tes_tml_agmt_vrfy_mzd;
//	}
//
//	public Collection getTES_TML_AGMT_VRFY_MZDS(){
//		return tes_tml_agmt_vrfy_mzds;
//	}	
//	
//	public Collection getTerminalAgreement_VOS(){
//		return terminalagreement_vos;
//	}	
//
//    public String getAmend_cd(){
//        return amend_cd;
//    }
//    
//    public String getTml_agmt_ofc_no(){
//        return tml_agmt_ofc_no;
//    }
//    
//    public String getTp_szflg(){
//        return tp_szflg;
//    }
//    
//    public HashMap getParam_map(){
//        return param_map;
//    }   
//	
//	public String getEventName() {
//		return "EsdTes0034Event";
//	}
//
//	public String toString() {
//		return "EsdTes0034Event";
//	}

}
