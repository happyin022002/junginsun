/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgVgmWgtVO.java
*@FileTitle : BkgVgmWgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgVgmWgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgVgmWgtVO> models = new ArrayList<BkgVgmWgtVO>();
	
	/* Column Info */
	private String esigCoNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vgmSeq = null;
	/* Column Info */
	private String upldFlg = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vgmClzFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String xterVgmRqstCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String upldDt = null;
	/* Column Info */
	private String vgmWgtUpdDt = null;
	/* Column Info */
	private String vgmWgtUpdUsrId = null;
	/* Column Info */
	private String cntrTareWgt = null;
	/* Column Info */
	private String wgtTpCd = null;
	/* Column Info */
	private String vgmUpldStsCd = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String xterVgmDocId = null;
	/* Column Info */
	private String xterVgmRqstSeq = null;
	/* Column Info */
	private String vgmTp = null;
	/* Column Info */
	private String vgmBkgNo = null;
	/* Column Info */
	private String vgmEdiTpCd = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String polCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgVgmWgtVO() {}

	public BkgVgmWgtVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String creUsrId, String creDt, String updUsrId, String updDt, String vgmWgt, String vgmWgtUtCd, String vgmClzFlg, String vgmWgtUpdDt, String vgmWgtUpdUsrId, String xterVgmRqstCd, String ifFlg, String vgmSeq, String esigCoNm, String usrId, String upldFlg, String upldDt, String cntrTareWgt, String wgtTpCd, String vgmUpldStsCd, String xterSndrId, String xterVgmDocId, String xterVgmRqstSeq, String vgmTp,String vgmBkgNo, String vgmEdiTpCd, String refNo, String polCd) {
		this.esigCoNm = esigCoNm;
		this.updDt = updDt;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.creDt = creDt;
		this.vgmSeq = vgmSeq;
		this.upldFlg = upldFlg;
		this.ifFlg = ifFlg;
		this.vgmWgt = vgmWgt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.vgmClzFlg = vgmClzFlg;
		this.usrId = usrId;
		this.cntrNo = cntrNo;
		this.xterVgmRqstCd = xterVgmRqstCd;
		this.updUsrId = updUsrId;
		this.upldDt = upldDt;
		this.vgmWgtUpdDt = vgmWgtUpdDt;
		this.vgmWgtUpdUsrId = vgmWgtUpdUsrId;
		this.cntrTareWgt = cntrTareWgt;
		this.wgtTpCd = wgtTpCd;
		this.vgmUpldStsCd = vgmUpldStsCd;
		this.xterSndrId = xterSndrId;
		this.xterVgmDocId = xterVgmDocId;
		this.xterVgmRqstSeq = xterVgmRqstSeq;
		this.vgmTp = vgmTp;
		this.vgmBkgNo = vgmBkgNo;
		this.vgmEdiTpCd = vgmEdiTpCd;
		this.refId = refId;
		this.polCd = polCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("esig_co_nm", getEsigCoNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vgm_seq", getVgmSeq());
		this.hashColumns.put("upld_flg", getUpldFlg());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vgm_clz_flg", getVgmClzFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("xter_vgm_rqst_cd", getXterVgmRqstCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upld_dt", getUpldDt());
		this.hashColumns.put("vgm_wgt_upd_dt", getVgmWgtUpdDt());
		this.hashColumns.put("vgm_wgt_upd_usr_id", getVgmWgtUpdUsrId());
		this.hashColumns.put("cntr_tare_wgt", getCntrTareWgt());
		this.hashColumns.put("wgt_tp_cd", getWgtTpCd());
		this.hashColumns.put("vgm_upld_sts_cd", getVgmUpldStsCd());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("xter_vgm_doc_id", getXterVgmDocId());
		this.hashColumns.put("xter_vgm_rqst_seq", getXterVgmRqstSeq());
		this.hashColumns.put("vgm_tp", getVgmTp());
		this.hashColumns.put("vgm_bkg_no", getVgmBkgNo());
		this.hashColumns.put("vgm_edi_tp_cd", getVgmEdiTpCd());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("pol_cd", getPolCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("esig_co_nm", "esigCoNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vgm_seq", "vgmSeq");
		this.hashFields.put("upld_flg", "upldFlg");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vgm_clz_flg", "vgmClzFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("xter_vgm_rqst_cd", "xterVgmRqstCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upld_dt", "upldDt");
		this.hashFields.put("vgm_wgt_upd_dt", "vgmWgtUpdDt");
		this.hashFields.put("vgm_wgt_upd_usr_id", "vgmWgtUpdUsrId");
		this.hashFields.put("cntr_tare_wgt", "cntrTareWgt");
		this.hashFields.put("wgt_tp_cd", "wgtTpCd");
		this.hashFields.put("vgm_upld_sts_cd", "vgmUpldStsCd");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("xter_vgm_doc_id", "xterVgmDocId");
		this.hashFields.put("xter_vgm_rqst_seq", "xterVgmRqstSeq");
		this.hashFields.put("vgm_tp", "vgmTp");
		this.hashFields.put("vgm_bkg_no", "vgmBkgNo");
		this.hashFields.put("vgm_edi_tp_cd", "vgmEdiTpCd");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("pol_cd", "polCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return esigCoNm
	 */
	public String getEsigCoNm() {
		return this.esigCoNm;
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
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
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
	 * @return vgmSeq
	 */
	public String getVgmSeq() {
		return this.vgmSeq;
	}
	
	/**
	 * Column Info
	 * @return upldFlg
	 */
	public String getUpldFlg() {
		return this.upldFlg;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return vgmClzFlg
	 */
	public String getVgmClzFlg() {
		return this.vgmClzFlg;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return xterVgmRqstCd
	 */
	public String getXterVgmRqstCd() {
		return this.xterVgmRqstCd;
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
	 * @return upldDt
	 */
	public String getUpldDt() {
		return this.upldDt;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUpdDt
	 */
	public String getVgmWgtUpdDt() {
		return this.vgmWgtUpdDt;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUpdUsrId
	 */
	public String getVgmWgtUpdUsrId() {
		return this.vgmWgtUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntrTareWgt
	 */
	public String getCntrTareWgt() {
		return this.cntrTareWgt;
	}
	
	/**
	 * Column Info
	 * @return wgtTpCd
	 */
	public String getWgtTpCd() {
		return this.wgtTpCd;
	}
	
	/**
	 * Column Info
	 * @return vgmUpldStsCd
	 */
	public String getVgmUpldStsCd() {
		return this.vgmUpldStsCd;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 * Column Info
	 * @return xterVgmDocId
	 */
	public String getXterVgmDocId() {
		return this.xterVgmDocId;
	}
	
	/**
	 * Column Info
	 * @return xterVgmRqstSeq
	 */
	public String getXterVgmRqstSeq() {
		return this.xterVgmRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return vgmTp
	 */
	public String getVgmTp() {
		return this.vgmTp;
	}
	
	/**
	 * Column Info
	 * @return vgmBkgNo
	 */
	public String getVgmBkgNo() {
		return this.vgmBkgNo;
	}
	
	/**
	 * Column Info
	 * @return vgmEdiTpCd
	 */
	public String getVgmEdiTpCd() {
		return this.vgmEdiTpCd;
	}
	
	/**
	 * Column Info
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @param esigCoNm
	 */
	public void setEsigCoNm(String esigCoNm) {
		this.esigCoNm = esigCoNm;
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
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
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
	 * @param vgmSeq
	 */
	public void setVgmSeq(String vgmSeq) {
		this.vgmSeq = vgmSeq;
	}
	
	/**
	 * Column Info
	 * @param upldFlg
	 */
	public void setUpldFlg(String upldFlg) {
		this.upldFlg = upldFlg;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param vgmClzFlg
	 */
	public void setVgmClzFlg(String vgmClzFlg) {
		this.vgmClzFlg = vgmClzFlg;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param xterVgmRqstCd
	 */
	public void setXterVgmRqstCd(String xterVgmRqstCd) {
		this.xterVgmRqstCd = xterVgmRqstCd;
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
	 * @param upldDt
	 */
	public void setUpldDt(String upldDt) {
		this.upldDt = upldDt;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUpdDt
	 */
	public void setVgmWgtUpdDt(String vgmWgtUpdDt) {
		this.vgmWgtUpdDt = vgmWgtUpdDt;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUpdUsrId
	 */
	public void setVgmWgtUpdUsrId(String vgmWgtUpdUsrId) {
		this.vgmWgtUpdUsrId = vgmWgtUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntrTareWgt
	 */
	public void setCntrTareWgt(String cntrTareWgt) {
		this.cntrTareWgt = cntrTareWgt;
	}
	
	/**
	 * Column Info
	 * @param wgtTpCd
	 */
	public void setWgtTpCd(String wgtTpCd) {
		this.wgtTpCd = wgtTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmUpldStsCd
	 */
	public void setVgmUpldStsCd(String vgmUpldStsCd) {
		this.vgmUpldStsCd = vgmUpldStsCd;
	}
	
	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * Column Info
	 * @param xterVgmDocId
	 */
	public void setXterVgmDocId(String xterVgmDocId) {
		this.xterVgmDocId = xterVgmDocId;
	}
	
	/**
	 * Column Info
	 * @param xterVgmRqstSeq
	 */
	public void setXterVgmRqstSeq(String xterVgmRqstSeq) {
		this.xterVgmRqstSeq = xterVgmRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param vgmTp
	 */
	public void setVgmTp(String vgmTp) {
		this.vgmTp = vgmTp;
	}
	
	/**
	 * Column Info
	 * @param vgmBkgNo
	 */
	public void setVgmBkgNo(String vgmBkgNo) {
		this.vgmBkgNo = vgmBkgNo;
	}
	
	/**
	 * Column Info
	 * @param vgmEdiTpCd
	 */
	public void setVgmEdiTpCd(String vgmEdiTpCd) {
		this.vgmEdiTpCd = vgmEdiTpCd;
	}

	/**
	 * Column Info
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setEsigCoNm(JSPUtil.getParameter(request, prefix + "esig_co_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVgmSeq(JSPUtil.getParameter(request, prefix + "vgm_seq", ""));
		setUpldFlg(JSPUtil.getParameter(request, prefix + "upld_flg", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVgmClzFlg(JSPUtil.getParameter(request, prefix + "vgm_clz_flg", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setXterVgmRqstCd(JSPUtil.getParameter(request, prefix + "xter_vgm_rqst_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpldDt(JSPUtil.getParameter(request, prefix + "upld_dt", ""));
		setVgmWgtUpdDt(JSPUtil.getParameter(request, prefix + "vgm_wgt_upd_dt", ""));
		setVgmWgtUpdUsrId(JSPUtil.getParameter(request, prefix + "vgm_wgt_upd_usr_id", ""));
		setCntrTareWgt(JSPUtil.getParameter(request, prefix + "cntr_tare_wgt", ""));
		setWgtTpCd(JSPUtil.getParameter(request, prefix + "wgt_tp_cd", ""));
		setVgmUpldStsCd(JSPUtil.getParameter(request, prefix + "vgm_upld_sts_cd", ""));
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setXterVgmDocId(JSPUtil.getParameter(request, prefix + "xter_vgm_doc_id", ""));
		setXterVgmRqstSeq(JSPUtil.getParameter(request, prefix + "xter_vgm_rqst_seq", ""));
		setVgmTp(JSPUtil.getParameter(request, prefix + "vgm_tp", ""));
		setVgmBkgNo(JSPUtil.getParameter(request, prefix + "vgm_bkg_no", ""));
		setVgmEdiTpCd(JSPUtil.getParameter(request, prefix + "vgm_edi_tp_cd", ""));
		setRefId(JSPUtil.getParameter(request, prefix + "ref_id", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgVgmWgtVO[]
	 */
	public BkgVgmWgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgVgmWgtVO[]
	 */
	public BkgVgmWgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgVgmWgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] esigCoNm = (JSPUtil.getParameter(request, prefix	+ "esig_co_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vgmSeq = (JSPUtil.getParameter(request, prefix	+ "vgm_seq", length));
			String[] upldFlg = (JSPUtil.getParameter(request, prefix	+ "upld_flg", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vgmClzFlg = (JSPUtil.getParameter(request, prefix	+ "vgm_clz_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] xterVgmRqstCd = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_rqst_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] upldDt = (JSPUtil.getParameter(request, prefix	+ "upld_dt", length));
			String[] vgmWgtUpdDt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_upd_dt", length));
			String[] vgmWgtUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_upd_usr_id", length));
			String[] cntrTareWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_tare_wgt", length));
			String[] wgtTpCd = (JSPUtil.getParameter(request, prefix	+ "wgt_tp_cd", length));
			String[] vgmUpldStsCd = (JSPUtil.getParameter(request, prefix	+ "vgm_upld_sts_cd", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] xterVgmDocId = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_doc_id", length));
			String[] xterVgmRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_rqst_seq", length));
			String[] vgmTp = (JSPUtil.getParameter(request, prefix	+ "vgm_tp", length));
			String[] vgmBkgNo = (JSPUtil.getParameter(request, prefix	+ "vgm_bkg_no", length));
			String[] vgmEdiTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_edi_tp_cd", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgVgmWgtVO();
				if (esigCoNm[i] != null)
					model.setEsigCoNm(esigCoNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vgmSeq[i] != null)
					model.setVgmSeq(vgmSeq[i]);
				if (upldFlg[i] != null)
					model.setUpldFlg(upldFlg[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vgmClzFlg[i] != null)
					model.setVgmClzFlg(vgmClzFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (xterVgmRqstCd[i] != null)
					model.setXterVgmRqstCd(xterVgmRqstCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (upldDt[i] != null)
					model.setUpldDt(upldDt[i]);
				if (vgmWgtUpdDt[i] != null)
					model.setVgmWgtUpdDt(vgmWgtUpdDt[i]);
				if (vgmWgtUpdUsrId[i] != null)
					model.setVgmWgtUpdUsrId(vgmWgtUpdUsrId[i]);
				if (cntrTareWgt[i] != null)
					model.setCntrTareWgt(cntrTareWgt[i]);
				if (wgtTpCd[i] != null)
					model.setWgtTpCd(wgtTpCd[i]);
				if (vgmUpldStsCd[i] != null)
					model.setVgmUpldStsCd(vgmUpldStsCd[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (xterVgmDocId[i] != null)
					model.setXterVgmDocId(xterVgmDocId[i]);
				if (xterVgmRqstSeq[i] != null)
					model.setXterVgmRqstSeq(xterVgmRqstSeq[i]);
				if (vgmTp[i] != null)
					model.setVgmTp(vgmTp[i]);
				if (vgmBkgNo[i] != null)
					model.setVgmBkgNo(vgmBkgNo[i]);
				if (vgmEdiTpCd[i] != null)
					model.setVgmEdiTpCd(vgmEdiTpCd[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgVgmWgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgVgmWgtVO[]
	 */
	public BkgVgmWgtVO[] getBkgVgmWgtVOs(){
		BkgVgmWgtVO[] vos = (BkgVgmWgtVO[])models.toArray(new BkgVgmWgtVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.esigCoNm = this.esigCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmSeq = this.vgmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldFlg = this.upldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzFlg = this.vgmClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmRqstCd = this.xterVgmRqstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldDt = this.upldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUpdDt = this.vgmWgtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUpdUsrId = this.vgmWgtUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTareWgt = this.cntrTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtTpCd = this.wgtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmUpldStsCd = this.vgmUpldStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmDocId = this.xterVgmDocId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmRqstSeq = this.xterVgmRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmTp = this.vgmTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmBkgNo = this.vgmBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmEdiTpCd = this.vgmEdiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
