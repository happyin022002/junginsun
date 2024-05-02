/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BsaSltPrcVO.java
*@FileTitle : BsaSltPrcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.09.03 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaManageSltPrcSaveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaManageSltPrcSaveVO> models = new ArrayList<BsaManageSltPrcSaveVO>();
	
	/* Condition */
	private String txtSDate = null;
	private String txtEDate = null;
	private String cobTrade = null;
	private String cobLane  = null;
	private String cobDir	= null;
	private String rdoType	= null;
	private String crrCd2  = null;
	private String bsaOpJbCd2  = null;
	private String header2  = null;
	private String gsNo = null;
	private String rdoType2	= null;
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String subChtrBsaCapa = null;
	/* Column Info */
	private String crsChtrBsaCapa = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bsaSltPrcToDt = null;
	/* Column Info */
	private String joEvntDt = null;
	/* Column Info */
	private String bsaSltCostTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bsaSltPrcFmDt = null;
	/* Column Info */
	private String hjsBfrSubCapa = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String sltPrcSeq = null;
	/* Column Info */
	private String sltPrcSeqOrg = null;	
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String crrCdLen = null;
	/* Column Info */
	private String bsaOpJbCd = null;
	/* Column Info */
	private String bsaOpJbCdLen=null;
	/* Column Info */
	private String sltPrcCapa = null;
	
	/*sheet2 */
	/* Column Info */
	private String unit = null;
	
	/*sheet3 */
	/* Column Info */
	private String rateType = null;
			
	
	/* iterator List Info */
//	private List<HashMap<String, Object>> D_slt_prc_capa_A = new ArrayList<HashMap<String, Object>>();
	/* iterator List Info */
//	private List<HashMap<String, Object>> D_slt_prc_capa_B = new ArrayList<HashMap<String, Object>>();	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaManageSltPrcSaveVO() {}

	public BsaManageSltPrcSaveVO(
			String ibflag,			String pagerows,		String trdCd, 			String rlaneCd, 
			String dirCd, 			String bsaSltCostTpCd, 	String sltPrcSeq, 		String vvdCd, 
			String bsaSltPrcFmDt, 	String bsaSltPrcToDt, 	String hjsBfrSubCapa, 	String subChtrBsaCapa, 
			String crsChtrBsaCapa, 	String joEvntDt, 		String creUsrId, 		String creDt, 
			String updUsrId, 		String updDt, 			String crrCd, 			String bsaOpJbCd, 
			String sltPrcCapa,		String crrCdLen,		String bsaOpJbCdLen,	String sltPrcSeqOrg,
			String crrCd2, 			String bsaOpJbCd2,      String currCd,
			String unit,			String rdoType2,		String rateType) 
	{
		this.updDt 			= updDt;
		this.subChtrBsaCapa = subChtrBsaCapa;
		this.crsChtrBsaCapa = crsChtrBsaCapa;
		this.creDt 			= creDt;
		this.trdCd 			= trdCd;
		this.rlaneCd 		= rlaneCd;
		this.bsaSltPrcToDt 	= bsaSltPrcToDt;
		this.joEvntDt 		= joEvntDt;
		this.bsaSltCostTpCd = bsaSltCostTpCd;
		this.pagerows 		= pagerows;
		this.creUsrId 		= creUsrId;
		this.ibflag 		= ibflag;
		this.vvdCd 			= vvdCd;
		this.bsaSltPrcFmDt 	= bsaSltPrcFmDt;
		this.hjsBfrSubCapa 	= hjsBfrSubCapa;
		this.dirCd 			= dirCd;
		this.sltPrcSeq 		= sltPrcSeq;
		this.updUsrId 		= updUsrId;
		this.crrCd 			= crrCd;
		this.bsaOpJbCd 		= bsaOpJbCd;
		this.sltPrcCapa 	= sltPrcCapa;	
		this.crrCdLen		= crrCdLen;
		this.bsaOpJbCdLen	= bsaOpJbCdLen;
		this.crrCd2	        = crrCd2;
		this.bsaOpJbCd2	    = bsaOpJbCd2;
		this.sltPrcSeqOrg	= sltPrcSeqOrg;
		this.currCd	        = currCd;
		
		this.unit			= unit;
		this.rdoType2		= rdoType2;
		this.rateType		= rateType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		
		this.hashColumns.put("slt_prc_seq", getSltPrcSeq());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bsa_slt_prc_fm_dt", getBsaSltPrcFmDt());
		this.hashColumns.put("bsa_slt_prc_to_dt", getBsaSltPrcToDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		
		this.hashColumns.put("bsa_slt_cost_tp_cd", getBsaSltCostTpCd());
		
		this.hashColumns.put("hjs_bfr_sub_capa", getHjsBfrSubCapa());
		this.hashColumns.put("sub_chtr_bsa_capa", getSubChtrBsaCapa());
		this.hashColumns.put("crs_chtr_bsa_capa", getCrsChtrBsaCapa());
		
		this.hashColumns.put("jo_evnt_dt", getJoEvntDt());
		
		this.hashColumns.put("bsa_op_jb_cd", getBsaOpJbCd());
		this.hashColumns.put("crr_cd", getCrrCd());		
		this.hashColumns.put("slt_prc_capa", getSltPrcCapa());
		
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("rdotype2", getRdoType2());
		
		this.hashColumns.put("rate_type", getRateType());
	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sub_chtr_bsa_capa", "subChtrBsaCapa");
		this.hashFields.put("crs_chtr_bsa_capa", "crsChtrBsaCapa");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bsa_slt_prc_to_dt", "bsaSltPrcToDt");
		this.hashFields.put("jo_evnt_dt", "joEvntDt");
		this.hashFields.put("bsa_slt_cost_tp_cd", "bsaSltCostTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bsa_slt_prc_fm_dt", "bsaSltPrcFmDt");
		this.hashFields.put("hjs_bfr_sub_capa", "hjsBfrSubCapa");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("slt_prc_seq", "sltPrcSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("bsa_op_jb_cd", "bsaOpJbCd");
		this.hashFields.put("slt_prc_capa", "sltPrcCapa");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("rate_type", "rateType");
		this.hashFields.put("curr_cd", "currCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return subChtrBsaCapa
	 */
	public String getSubChtrBsaCapa() {
		return this.subChtrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return crsChtrBsaCapa
	 */
	public String getCrsChtrBsaCapa() {
		return this.crsChtrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrcToDt
	 */
	public String getBsaSltPrcToDt() {
		return this.bsaSltPrcToDt;
	}
	
	/**
	 * Column Info
	 * @return joEvntDt
	 */
	public String getJoEvntDt() {
		return this.joEvntDt;
	}
	
	/**
	 * Column Info
	 * @return bsaSltCostTpCd
	 */
	public String getBsaSltCostTpCd() {
		return this.bsaSltCostTpCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrcFmDt
	 */
	public String getBsaSltPrcFmDt() {
		return this.bsaSltPrcFmDt;
	}
	
	/**
	 * Column Info
	 * @return hjsBfrSubCapa
	 */
	public String getHjsBfrSubCapa() {
		return this.hjsBfrSubCapa;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return sltPrcSeq
	 */
	public String getSltPrcSeq() {
		return this.sltPrcSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public String getCrrCd() {
		return crrCd;
	}
	
	/**
	 * Column Info
	 * @param bsaOpJbCd
	 */
	public String getBsaOpJbCd() {
		return bsaOpJbCd;
	}
	
	/**
	 * Column Info
	 * @param sltPrcCapa
	 */
	public String getSltPrcCapa() {
		return sltPrcCapa;
	}
	
	/**
	 * Column Info
	 * @param sltPrcCapa
	 */	
	public String getCrrCdLen() {
		return crrCdLen;
	}
	
	/**
	 * Column Info
	 * @param sltPrcCapa
	 */
	public String getBsaOpJbCdLen() {
		return bsaOpJbCdLen;
	}
		
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param subChtrBsaCapa
	 */
	public void setSubChtrBsaCapa(String subChtrBsaCapa) {
		this.subChtrBsaCapa = subChtrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param crsChtrBsaCapa
	 */
	public void setCrsChtrBsaCapa(String crsChtrBsaCapa) {
		this.crsChtrBsaCapa = crsChtrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrcToDt
	 */
	public void setBsaSltPrcToDt(String bsaSltPrcToDt) {
		this.bsaSltPrcToDt = bsaSltPrcToDt;
	}
	
	/**
	 * Column Info
	 * @param joEvntDt
	 */
	public void setJoEvntDt(String joEvntDt) {
		this.joEvntDt = joEvntDt;
	}
	
	/**
	 * Column Info
	 * @param bsaSltCostTpCd
	 */
	public void setBsaSltCostTpCd(String bsaSltCostTpCd) {
		this.bsaSltCostTpCd = bsaSltCostTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrcFmDt
	 */
	public void setBsaSltPrcFmDt(String bsaSltPrcFmDt) {
		this.bsaSltPrcFmDt = bsaSltPrcFmDt;
	}
	
	/**
	 * Column Info
	 * @param hjsBfrSubCapa
	 */
	public void setHjsBfrSubCapa(String hjsBfrSubCapa) {
		this.hjsBfrSubCapa = hjsBfrSubCapa;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param sltPrcSeq
	 */
	public void setSltPrcSeq(String sltPrcSeq) {
		this.sltPrcSeq = sltPrcSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param bsaOpJbCd
	 */
	public void setBsaOpJbCd(String bsaOpJbCd) {
		this.bsaOpJbCd = bsaOpJbCd;
	}
	
	/**
	 * Column Info
	 * @param sltPrcCapa
	 */
	public void setSltPrcCapa(String sltPrcCapa) {
		this.sltPrcCapa = sltPrcCapa;
	}
	
	/**
	 * Column Info
	 * @param sltPrcCapa
	 */
	public void setCrrCdLen(String crrCdLen) {
		this.crrCdLen = crrCdLen;
	}
	
	/**
	 * Column Info
	 * @param sltPrcCapa
	 */
	public void setBsaOpJbCdLen(String bsaOpJbCdLen) {
		this.bsaOpJbCdLen = bsaOpJbCdLen;
	}
	

	public String getCrrCd2() {
		return crrCd2;
	}

	public void setCrrCd2(String crrCd2) {
		this.crrCd2 = crrCd2;
	}

	public String getBsaOpJbCd2() {
		return bsaOpJbCd2;
	}

	public void setBsaOpJbCd2(String bsaOpJbCd2) {
		this.bsaOpJbCd2 = bsaOpJbCd2;
	}

	
	
	public String getHeader2() {
		return header2;
	}

	public void setHeader2(String header2) {
		this.header2 = header2;
	}

	public String getTxtSDate() {
		return txtSDate;
	}

	public void setTxtSDate(String txtSDate) {
		this.txtSDate = txtSDate;
	}

	public String getTxtEDate() {
		return txtEDate;
	}

	public void setTxtEDate(String txtEDate) {
		this.txtEDate = txtEDate;
	}

	public String getCobTrade() {
		return cobTrade;
	}

	public void setCobTrade(String cobTrade) {
		this.cobTrade = cobTrade;
	}

	public String getCobLane() {
		return cobLane;
	}

	public void setCobLane(String cobLane) {
		this.cobLane = cobLane;
	}

	public String getCobDir() {
		return cobDir;
	}

	public void setCobDir(String cobDir) {
		this.cobDir = cobDir;
	}

	public String getRdoType() {
		return rdoType;
	}

	public void setRdoType(String rdoType) {
		this.rdoType = rdoType;
	}
	
	public String getSltPrcSeqOrg() {
		return sltPrcSeqOrg;
	}

	public void setSltPrcSeqOrg(String sltPrcSeqOrg) {
		this.sltPrcSeqOrg = sltPrcSeqOrg;
	}
	

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getGsNo() {
		return gsNo;
	}

	public void setGsNo(String gsNo) {
		this.gsNo = gsNo;
	}
	
	public String getRdoType2() {
		return rdoType2;
	}

	public void setRdoType2(String rdoType2) {
		this.rdoType2 = rdoType2;
	}
	
	
	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	
	/**
	 * Column Info
	 * @param currCd
	 */
	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPagerows		(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag		(JSPUtil.getParameter(request, "ibflag", ""));
//		setSltPrcSeq	(JSPUtil.getParameter(request, "M_slt_prc_seq", ""));
//		setVvdCd		(JSPUtil.getParameter(request, "M_vvd_cd", ""));
//		setBsaSltPrcFmDt(JSPUtil.getParameter(request, "M_bsa_slt_prc_fm_dt", ""));
//		setBsaSltPrcToDt(JSPUtil.getParameter(request, "M_bsa_slt_prc_to_dt", ""));
//		
//		setTrdCd		(JSPUtil.getParameter(request, "M_trd_cd", ""));
//		setRlaneCd		(JSPUtil.getParameter(request, "M_rlane_cd", ""));
//		setDirCd		(JSPUtil.getParameter(request, "M_dir_cd", ""));
//		
//		setBsaSltCostTpCd	(JSPUtil.getParameter(request, "M_bsa_slt_cost_tp_cd", ""));		
//		setHjsBfrSubCapa	(JSPUtil.getParameter(request, "M_hjs_bfr_sub_capa", ""));
//		setSubChtrBsaCapa	(JSPUtil.getParameter(request, "M_sub_chtr_bsa_capa", ""));
//		setCrsChtrBsaCapa	(JSPUtil.getParameter(request, "M_crs_chtr_bsa_capa", ""));
//		
//		setJoEvntDt			(JSPUtil.getParameter(request, "jo_evnt_dt", ""));
//		setCreUsrId			(JSPUtil.getParameter(request, "cre_usr_id", ""));
//		setCreDt			(JSPUtil.getParameter(request, "cre_dt", ""));
//		setUpdUsrId			(JSPUtil.getParameter(request, "upd_usr_id", ""));
//		setUpdDt			(JSPUtil.getParameter(request, "upd_dt", ""));
//		
//				
		setCrrCd2			(JSPUtil.getParameter(request, "crr_cd", ""));
//		setSltPrcCapa		(JSPUtil.getParameter(request, "slt_Prc_Capa", ""));
		setBsaOpJbCd2		(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
		
		setCrrCdLen			(JSPUtil.getParameter(request, "crr_cd_len", ""));
		setBsaOpJbCdLen		(JSPUtil.getParameter(request, "bsa_op_jb_cd_len", ""));
		setHeader2			(JSPUtil.getParameter(request, "header2", ""));	
		
		setTxtEDate(JSPUtil.getParameter(request, "txtEDate", ""));
		setCobLane(JSPUtil.getParameter(request, "cobLane", ""));
		setRdoType(JSPUtil.getParameter(request, "rdoType", ""));
		setTxtSDate(JSPUtil.getParameter(request, "txtSDate", ""));
		setCobDir(JSPUtil.getParameter(request, "cobDir", ""));
		setCobTrade(JSPUtil.getParameter(request, "cobTrade", ""));
				
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaSltPrcVO[]
	 */
	public BsaManageSltPrcSaveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaSltPrcVO[]
	 */
	public BsaManageSltPrcSaveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaManageSltPrcSaveVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  		
  		setCrrCd2			(JSPUtil.getParameter(request, "crr_cd", ""));
		setBsaOpJbCd2		(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
		
		setRdoType2(JSPUtil.getParameter(request, "rdoType2", ""));
		
		setHeader2(JSPUtil.getParameter(request, "header2", ""));
		setGsNo(JSPUtil.getParameter(request, "gsno", ""));
		
		String[] arrBsaOpJbCd = null;
		String[] arrCrrCd = null;
		
		if (getBsaOpJbCd2().length()>0) { 
			bsaOpJbCd2 = getBsaOpJbCd2().substring(1); 
		}
		if (getCrrCd2().length()>0){ 
			crrCd2 = getCrrCd2().substring(1); 
		}
		
		if (gsNo.equals("1")){
			if(bsaOpJbCd2 != null && !bsaOpJbCd2.equals("") && crrCd2 != null && !crrCd2.equals("")){				
				arrBsaOpJbCd = 	bsaOpJbCd2.split("[|]");
				arrCrrCd	 =  crrCd2.split("[|]");
			}
		}else if (gsNo.equals("2") || gsNo.equals("3")){
			if(header2 != null && !header2.equals("") ){	
				arrCrrCd	 =  header2.split("[|]");
			}
		}
		
		try {
			
			String[] pagerows 		= (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag 		= (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sltPrcSeq 		= (JSPUtil.getParameter(request, prefix	+ "M_slt_prc_seq", length));
			String[] sltPrcSeqOrg	= (JSPUtil.getParameter(request, prefix	+ "M_slt_prc_seq_org", length));
			String[] vvdCd 			= (JSPUtil.getParameter(request, prefix	+ "M_vvd_cd", length));
			
			String[] bsaSltPrcFmDt 	= (JSPUtil.getParameter(request, prefix	+ "M_bsa_slt_prc_fm_dt", length));
			String[] bsaSltPrcToDt 	= (JSPUtil.getParameter(request, prefix	+ "M_bsa_slt_prc_to_dt", length));
			String[] trdCd 			= (JSPUtil.getParameter(request, prefix	+ "M_trd_cd", length));
			String[] rlaneCd 		= (JSPUtil.getParameter(request, prefix	+ "M_rlane_cd", length));
			String[] dirCd 			= (JSPUtil.getParameter(request, prefix	+ "M_dir_cd", length));
			String[] currCd 		= (JSPUtil.getParameter(request, prefix	+ "M_curr_cd", length));
			String[] bsaSltCostTpCd = (JSPUtil.getParameter(request, prefix	+ "M_bsa_slt_cost_tp_cd", length));
			String[] hjsBfrSubCapa 	= (JSPUtil.getParameter(request, prefix	+ "M_hjs_bfr_sub_capa", length));
			String[] subChtrBsaCapa = (JSPUtil.getParameter(request, prefix	+ "M_sub_chtr_bsa_capa", length));
			String[] crsChtrBsaCapa = (JSPUtil.getParameter(request, prefix	+ "M_crs_chtr_bsa_capa", length));
			
//			String[] crrCd 			= (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
//			String[] sltPrcCapa 	= (JSPUtil.getParameter(request, prefix	+ "slt_Prc_Capa", length));
//			String[] bsaOpJbCd 		= (JSPUtil.getParameter(request, prefix	+ "bsa_Op_Jb_Cd", length));
			
			String[] unit 			= (JSPUtil.getParameter(request, prefix	+ "M_unit", length));
			
			String[] rateType 		= (JSPUtil.getParameter(request, prefix	+ "M_rate_type", length));
			
			String[] joEvntDt 		= (JSPUtil.getParameter(request, prefix	+ "jo_evnt_dt", length));
			String[] creUsrId 		= (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt 			= (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId 		= (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt 			= (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dSltPrcCapa =null;
								
			if (gsNo.equals("1")){			
				for (int i = 0; i < length; i++) {
					for (int j= 0; j <arrCrrCd.length; j++ ){
						model = new BsaManageSltPrcSaveVO();
						String[] D_slt_prc_capa_temp = (JSPUtil.getParameter(request, "D_slt_prc_capa"+j, length));
						if (updDt[i] != null)					model.setUpdDt(updDt[i]);
						if (subChtrBsaCapa[i] != null)			model.setSubChtrBsaCapa(subChtrBsaCapa[i]);
						if (crsChtrBsaCapa[i] != null)			model.setCrsChtrBsaCapa(crsChtrBsaCapa[i]);
						if (creDt[i] != null)					model.setCreDt(creDt[i]);
						if (trdCd[i] != null)					model.setTrdCd(trdCd[i]);
						if (rlaneCd[i] != null)					model.setRlaneCd(rlaneCd[i]);
						if (bsaSltPrcToDt[i] != null)			model.setBsaSltPrcToDt(bsaSltPrcToDt[i]);
						if (joEvntDt[i] != null)				model.setJoEvntDt(joEvntDt[i]);
						if (bsaSltCostTpCd[i] != null)			model.setBsaSltCostTpCd(bsaSltCostTpCd[i]);
						if (pagerows[i] != null)				model.setPagerows(pagerows[i]);
						if (creUsrId[i] != null)				model.setCreUsrId(creUsrId[i]);
						if (ibflag[i] != null)					model.setIbflag(ibflag[i]);
						if (vvdCd[i] != null)					model.setVvdCd(vvdCd[i]);
						if (bsaSltPrcFmDt[i] != null)			model.setBsaSltPrcFmDt(bsaSltPrcFmDt[i]);
						if (hjsBfrSubCapa[i] != null)			model.setHjsBfrSubCapa(hjsBfrSubCapa[i]);
						if (dirCd[i] != null)					model.setDirCd(dirCd[i]);
						if (sltPrcSeq[i] != null)				model.setSltPrcSeq(sltPrcSeq[i]);
						if (sltPrcSeqOrg[i] != null)			model.setSltPrcSeqOrg(sltPrcSeqOrg[i]);
						if (updUsrId[i] != null)				model.setUpdUsrId(updUsrId[i]);
						if (arrCrrCd != null)					model.setCrrCd(arrCrrCd[j]);
						if (arrBsaOpJbCd != null)				model.setBsaOpJbCd(arrBsaOpJbCd[j]);					
						if (D_slt_prc_capa_temp !=null)			model.setSltPrcCapa(D_slt_prc_capa_temp[i]);
						if (currCd[i] != null)					model.setCurrCd(currCd[i]);
						
						models.add(model);
					}
				}
			}else if (gsNo.equals("2") || gsNo.equals("3")){
				
				for (int i = 0; i < length; i++) {	
						String   sltPrcCapa ="";
						model = new BsaManageSltPrcSaveVO();
						if (updDt[i] != null)					model.setUpdDt(updDt[i]);
						if (subChtrBsaCapa[i] != null)			model.setSubChtrBsaCapa(subChtrBsaCapa[i]);
						if (crsChtrBsaCapa[i] != null)			model.setCrsChtrBsaCapa(crsChtrBsaCapa[i]);
						if (creDt[i] != null)					model.setCreDt(creDt[i]);
						if (trdCd[i] != null)					model.setTrdCd(trdCd[i]);
						if (rlaneCd[i] != null)					model.setRlaneCd(rlaneCd[i]);
						if (bsaSltPrcToDt[i] != null)			model.setBsaSltPrcToDt(bsaSltPrcToDt[i]);
						if (bsaSltCostTpCd[i] != null)			model.setBsaSltCostTpCd(bsaSltCostTpCd[i]);
						if (pagerows[i] != null)				model.setPagerows(pagerows[i]);
						if (creUsrId[i] != null)				model.setCreUsrId(creUsrId[i]);
						if (ibflag[i] != null)					model.setIbflag(ibflag[i]);
						if (vvdCd[i] != null)					model.setVvdCd(vvdCd[i]);
						if (bsaSltPrcFmDt[i] != null)			model.setBsaSltPrcFmDt(bsaSltPrcFmDt[i]);
						if (hjsBfrSubCapa[i] != null)			model.setHjsBfrSubCapa(hjsBfrSubCapa[i]);
						if (dirCd[i] != null)					model.setDirCd(dirCd[i]);
						if (sltPrcSeq[i] != null)				model.setSltPrcSeq(sltPrcSeq[i]);
						if (sltPrcSeqOrg[i] != null)			model.setSltPrcSeqOrg(sltPrcSeqOrg[i]);
						if (updUsrId[i] != null)				model.setUpdUsrId(updUsrId[i]);
						if (arrCrrCd != null)					model.setCrrCd("|"+header2);
						if (arrBsaOpJbCd != null)				model.setBsaOpJbCd(arrBsaOpJbCd[i]);
						if (currCd[i] != null)					model.setCurrCd(currCd[i]);
						
						for (int j= 0; j <arrCrrCd.length; j++ ){
							
							dSltPrcCapa = (JSPUtil.getParameter(request, "D_slt_prc_capa"+j, length));
							sltPrcCapa = sltPrcCapa + "|"+dSltPrcCapa[i];
						}
						if (sltPrcCapa != null)				model.setSltPrcCapa(sltPrcCapa);
						
						/*sheet2*/
						if (unit[i] !=null)						model.setUnit(unit[i]);
						if (rdoType2 !=null)					model.setRdoType2(rdoType2);
						
						/*sheet3*/
						if (rateType[i] !=null)					model.setRateType(rateType[i]);
						models.add(model);
				}
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaSltPrcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaSltPrcVO[]
	 */
	public BsaManageSltPrcSaveVO[] getBsaSltPrcVOs(){
		BsaManageSltPrcSaveVO[] vos = (BsaManageSltPrcSaveVO[])models.toArray(new BsaManageSltPrcSaveVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subChtrBsaCapa = this.subChtrBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsChtrBsaCapa = this.crsChtrBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrcToDt = this.bsaSltPrcToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joEvntDt = this.joEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltCostTpCd = this.bsaSltCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrcFmDt = this.bsaSltPrcFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBfrSubCapa = this.hjsBfrSubCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltPrcSeq = this.sltPrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
