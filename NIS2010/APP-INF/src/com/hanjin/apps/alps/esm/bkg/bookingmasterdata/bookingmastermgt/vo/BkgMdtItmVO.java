/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgMdtItmVO.java
*@FileTitle : BkgMdtItmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgMdtItmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgMdtItmVO> models = new ArrayList<BkgMdtItmVO>();
	
	/* Column Info */
	private String itmCdMsl = null;
	/* Column Info */
	private String itmNmMsl = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String itmCdPoc = null;
	/* Column Info */
	private String itmCdPob = null;
	/* Column Info */
	private String itmNmPob = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String itmNmDep = null;
	/* Column Info */
	private String itmNmPoc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String itmNmPom = null;
	/* Column Info */
	private String itmNmPat = null;
	/* Column Info */
	private String itmNmInc = null;
	/* Column Info */
	private String itmCdPom = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String itmCdDep = null;
	/* Column Info */
	private String scExpDt = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String blIssNoteCtnt = null;
	/* Column Info */
	private String itmCdInv = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String mdtCustTpCd = null;
	/* Column Info */
	private String itmCdPat = null;
	/* Column Info */
	private String mdtItmRmk = null;
	/* Column Info */
	private String itmCdShp = null;
	/* Column Info */
	private String rfaExpDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String itmNmInv = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String itmCdInc = null;
	/* Column Info */
	private String bkgMdtItmCd = null;
	/* Column Info */
	private String itmNmLc = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String fcust = null;
	/* Column Info */
	private String mdtItmSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String itmNmShp = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String blIssNote = null;
	/* Column Info */
	private String itmCdLc = null;
	/* Column Info */
	private String bkgMdtCateCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgMdtItmVO() {}

	public BkgMdtItmVO(String ibflag, String pagerows, String porCd, String itmCdPoc, String itmCdPob, String itmNmDep, String svcScpCd, String itmNmPob, String itmNmPoc, String creDt, String itmNmPom, String itmNmPat, String itmNmInc, String itmCdPom, String itmCdDep, String scExpDt, String rfaNo, String polCd, String itmCdInv, String scNo, String mdtCustTpCd, String itmCdPat, String mdtItmRmk, String itmCdShp, String rfaExpDt, String custCntCd, String updUsrId, String updDt, String itmNmInv, String custGrpId, String itmCdInc, String bkgMdtItmCd, String itmNmLc, String delCd, String fcust, String itmNmShp, String custSeq, String mdtItmSeq, String podCd, String creUsrId, String blIssNote, String itmCdLc, String bkgMdtCateCd, String blIssNoteCtnt, String itmCdMsl, String itmNmMsl) {
		this.porCd = porCd;
		this.itmCdPoc = itmCdPoc;
		this.itmCdPob = itmCdPob;
		this.itmNmPob = itmNmPob;
		this.svcScpCd = svcScpCd;
		this.itmNmDep = itmNmDep;
		this.itmNmPoc = itmNmPoc;
		this.creDt = creDt;
		this.itmNmPom = itmNmPom;
		this.itmNmPat = itmNmPat;
		this.itmNmInc = itmNmInc;
		this.itmCdPom = itmCdPom;
		this.pagerows = pagerows;
		this.itmCdDep = itmCdDep;
		this.scExpDt = scExpDt;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.blIssNoteCtnt = blIssNoteCtnt;
		this.itmCdInv = itmCdInv;
		this.scNo = scNo;
		this.mdtCustTpCd = mdtCustTpCd;
		this.itmCdPat = itmCdPat;
		this.mdtItmRmk = mdtItmRmk;
		this.itmCdShp = itmCdShp;
		this.rfaExpDt = rfaExpDt;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.updDt = updDt;
		this.itmNmInv = itmNmInv;
		this.custGrpId = custGrpId;
		this.itmCdInc = itmCdInc;
		this.bkgMdtItmCd = bkgMdtItmCd;
		this.itmNmLc = itmNmLc;
		this.delCd = delCd;
		this.fcust = fcust;
		this.mdtItmSeq = mdtItmSeq;
		this.custSeq = custSeq;
		this.itmNmShp = itmNmShp;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.blIssNote = blIssNote;
		this.itmCdLc = itmCdLc;
		this.bkgMdtCateCd = bkgMdtCateCd;
		this.itmCdMsl = itmCdMsl;
		this.itmNmMsl = itmNmMsl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("itm_cd_poc", getItmCdPoc());
		this.hashColumns.put("itm_cd_pob", getItmCdPob());
		this.hashColumns.put("itm_nm_pob", getItmNmPob());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("itm_nm_dep", getItmNmDep());
		this.hashColumns.put("itm_nm_poc", getItmNmPoc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("itm_nm_pom", getItmNmPom());
		this.hashColumns.put("itm_nm_pat", getItmNmPat());
		this.hashColumns.put("itm_nm_inc", getItmNmInc());
		this.hashColumns.put("itm_cd_pom", getItmCdPom());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("itm_cd_dep", getItmCdDep());
		this.hashColumns.put("sc_exp_dt", getScExpDt());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bl_iss_note_ctnt", getBlIssNoteCtnt());
		this.hashColumns.put("itm_cd_inv", getItmCdInv());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("mdt_cust_tp_cd", getMdtCustTpCd());
		this.hashColumns.put("itm_cd_pat", getItmCdPat());
		this.hashColumns.put("mdt_itm_rmk", getMdtItmRmk());
		this.hashColumns.put("itm_cd_shp", getItmCdShp());
		this.hashColumns.put("rfa_exp_dt", getRfaExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("itm_nm_inv", getItmNmInv());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("itm_cd_inc", getItmCdInc());
		this.hashColumns.put("bkg_mdt_itm_cd", getBkgMdtItmCd());
		this.hashColumns.put("itm_nm_lc", getItmNmLc());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("fcust", getFcust());
		this.hashColumns.put("mdt_itm_seq", getMdtItmSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("itm_nm_shp", getItmNmShp());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bl_iss_note", getBlIssNote());
		this.hashColumns.put("itm_cd_lc", getItmCdLc());
		this.hashColumns.put("bkg_mdt_cate_cd", getBkgMdtCateCd());
		this.hashColumns.put("itm_cd_msl", getItmCdMsl());
		this.hashColumns.put("itm_nm_msl", getItmNmMsl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("itm_cd_poc", "itmCdPoc");
		this.hashFields.put("itm_cd_pob", "itmCdPob");
		this.hashFields.put("itm_nm_pob", "itmNmPob");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("itm_nm_dep", "itmNmDep");
		this.hashFields.put("itm_nm_poc", "itmNmPoc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("itm_nm_pom", "itmNmPom");
		this.hashFields.put("itm_nm_pat", "itmNmPat");
		this.hashFields.put("itm_nm_inc", "itmNmInc");
		this.hashFields.put("itm_cd_pom", "itmCdPom");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("itm_cd_dep", "itmCdDep");
		this.hashFields.put("sc_exp_dt", "scExpDt");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bl_iss_note_ctnt", "blIssNoteCtnt");
		this.hashFields.put("itm_cd_inv", "itmCdInv");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("mdt_cust_tp_cd", "mdtCustTpCd");
		this.hashFields.put("itm_cd_pat", "itmCdPat");
		this.hashFields.put("mdt_itm_rmk", "mdtItmRmk");
		this.hashFields.put("itm_cd_shp", "itmCdShp");
		this.hashFields.put("rfa_exp_dt", "rfaExpDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("itm_nm_inv", "itmNmInv");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("itm_cd_inc", "itmCdInc");
		this.hashFields.put("bkg_mdt_itm_cd", "bkgMdtItmCd");
		this.hashFields.put("itm_nm_lc", "itmNmLc");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("fcust", "fcust");
		this.hashFields.put("mdt_itm_seq", "mdtItmSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("itm_nm_shp", "itmNmShp");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bl_iss_note", "blIssNote");
		this.hashFields.put("itm_cd_lc", "itmCdLc");
		this.hashFields.put("bkg_mdt_cate_cd", "bkgMdtCateCd");
		this.hashFields.put("itm_cd_msl", "itmCdMsl");
		this.hashFields.put("itm_nm_msl", "itmNmMsl");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return itmCdMsl
	 */
	public String getItmCdMsl() {
		return this.itmCdMsl;
	}
	
	/**
	 * Column Info
	 * @return itmNmMsl
	 */
	public String getItmNmMsl() {
		return this.itmNmMsl;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return itmCdPoc
	 */
	public String getItmCdPoc() {
		return this.itmCdPoc;
	}
	
	/**
	 * Column Info
	 * @return itmCdPob
	 */
	public String getItmCdPob() {
		return this.itmCdPob;
	}
	
	/**
	 * Column Info
	 * @return itmNmPob
	 */
	public String getItmNmPob() {
		return this.itmNmPob;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return itmNmDep
	 */
	public String getItmNmDep() {
		return this.itmNmDep;
	}
	
	/**
	 * Column Info
	 * @return itmNmPoc
	 */
	public String getItmNmPoc() {
		return this.itmNmPoc;
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
	 * @return itmNmPom
	 */
	public String getItmNmPom() {
		return this.itmNmPom;
	}
	
	/**
	 * Column Info
	 * @return itmNmPat
	 */
	public String getItmNmPat() {
		return this.itmNmPat;
	}
	
	/**
	 * Column Info
	 * @return itmNmInc
	 */
	public String getItmNmInc() {
		return this.itmNmInc;
	}
	
	/**
	 * Column Info
	 * @return itmCdPom
	 */
	public String getItmCdPom() {
		return this.itmCdPom;
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
	 * @return itmCdDep
	 */
	public String getItmCdDep() {
		return this.itmCdDep;
	}
	
	/**
	 * Column Info
	 * @return scExpDt
	 */
	public String getScExpDt() {
		return this.scExpDt;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return blIssNoteCtnt
	 */
	public String getBlIssNoteCtnt() {
		return this.blIssNoteCtnt;
	}
	
	/**
	 * Column Info
	 * @return itmCdInv
	 */
	public String getItmCdInv() {
		return this.itmCdInv;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return mdtCustTpCd
	 */
	public String getMdtCustTpCd() {
		return this.mdtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return itmCdPat
	 */
	public String getItmCdPat() {
		return this.itmCdPat;
	}
	
	/**
	 * Column Info
	 * @return mdtItmRmk
	 */
	public String getMdtItmRmk() {
		return this.mdtItmRmk;
	}
	
	/**
	 * Column Info
	 * @return itmCdShp
	 */
	public String getItmCdShp() {
		return this.itmCdShp;
	}
	
	/**
	 * Column Info
	 * @return rfaExpDt
	 */
	public String getRfaExpDt() {
		return this.rfaExpDt;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return itmNmInv
	 */
	public String getItmNmInv() {
		return this.itmNmInv;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}
	
	/**
	 * Column Info
	 * @return itmCdInc
	 */
	public String getItmCdInc() {
		return this.itmCdInc;
	}
	
	/**
	 * Column Info
	 * @return bkgMdtItmCd
	 */
	public String getBkgMdtItmCd() {
		return this.bkgMdtItmCd;
	}
	
	/**
	 * Column Info
	 * @return itmNmLc
	 */
	public String getItmNmLc() {
		return this.itmNmLc;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return fcust
	 */
	public String getFcust() {
		return this.fcust;
	}
	
	/**
	 * Column Info
	 * @return mdtItmSeq
	 */
	public String getMdtItmSeq() {
		return this.mdtItmSeq;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return itmNmShp
	 */
	public String getItmNmShp() {
		return this.itmNmShp;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return blIssNote
	 */
	public String getBlIssNote() {
		return this.blIssNote;
	}
	
	/**
	 * Column Info
	 * @return itmCdLc
	 */
	public String getItmCdLc() {
		return this.itmCdLc;
	}
	
	/**
	 * Column Info
	 * @return bkgMdtCateCd
	 */
	public String getBkgMdtCateCd() {
		return this.bkgMdtCateCd;
	}
	
	/**
	 * Column Info
	 * @param itmCdMsl
	 */
	public void setItmCdMsl(String itmCdMsl) {
		this.itmCdMsl = itmCdMsl;
	}
	
	/**
	 * Column Info
	 * @param itmNmMsl
	 */
	public void setItmNmMsl(String itmNmMsl) {
		this.itmNmMsl = itmNmMsl;
	}

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param itmCdPoc
	 */
	public void setItmCdPoc(String itmCdPoc) {
		this.itmCdPoc = itmCdPoc;
	}
	
	/**
	 * Column Info
	 * @param itmCdPob
	 */
	public void setItmCdPob(String itmCdPob) {
		this.itmCdPob = itmCdPob;
	}
	
	/**
	 * Column Info
	 * @param itmNmPob
	 */
	public void setItmNmPob(String itmNmPob) {
		this.itmNmPob = itmNmPob;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param itmNmDep
	 */
	public void setItmNmDep(String itmNmDep) {
		this.itmNmDep = itmNmDep;
	}
	
	/**
	 * Column Info
	 * @param itmNmPoc
	 */
	public void setItmNmPoc(String itmNmPoc) {
		this.itmNmPoc = itmNmPoc;
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
	 * @param itmNmPom
	 */
	public void setItmNmPom(String itmNmPom) {
		this.itmNmPom = itmNmPom;
	}
	
	/**
	 * Column Info
	 * @param itmNmPat
	 */
	public void setItmNmPat(String itmNmPat) {
		this.itmNmPat = itmNmPat;
	}
	
	/**
	 * Column Info
	 * @param itmNmInc
	 */
	public void setItmNmInc(String itmNmInc) {
		this.itmNmInc = itmNmInc;
	}
	
	/**
	 * Column Info
	 * @param itmCdPom
	 */
	public void setItmCdPom(String itmCdPom) {
		this.itmCdPom = itmCdPom;
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
	 * @param itmCdDep
	 */
	public void setItmCdDep(String itmCdDep) {
		this.itmCdDep = itmCdDep;
	}
	
	/**
	 * Column Info
	 * @param scExpDt
	 */
	public void setScExpDt(String scExpDt) {
		this.scExpDt = scExpDt;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param blIssNoteCtnt
	 */
	public void setBlIssNoteCtnt(String blIssNoteCtnt) {
		this.blIssNoteCtnt = blIssNoteCtnt;
	}
	
	/**
	 * Column Info
	 * @param itmCdInv
	 */
	public void setItmCdInv(String itmCdInv) {
		this.itmCdInv = itmCdInv;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param mdtCustTpCd
	 */
	public void setMdtCustTpCd(String mdtCustTpCd) {
		this.mdtCustTpCd = mdtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param itmCdPat
	 */
	public void setItmCdPat(String itmCdPat) {
		this.itmCdPat = itmCdPat;
	}
	
	/**
	 * Column Info
	 * @param mdtItmRmk
	 */
	public void setMdtItmRmk(String mdtItmRmk) {
		this.mdtItmRmk = mdtItmRmk;
	}
	
	/**
	 * Column Info
	 * @param itmCdShp
	 */
	public void setItmCdShp(String itmCdShp) {
		this.itmCdShp = itmCdShp;
	}
	
	/**
	 * Column Info
	 * @param rfaExpDt
	 */
	public void setRfaExpDt(String rfaExpDt) {
		this.rfaExpDt = rfaExpDt;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param itmNmInv
	 */
	public void setItmNmInv(String itmNmInv) {
		this.itmNmInv = itmNmInv;
	}
	
	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param itmCdInc
	 */
	public void setItmCdInc(String itmCdInc) {
		this.itmCdInc = itmCdInc;
	}
	
	/**
	 * Column Info
	 * @param bkgMdtItmCd
	 */
	public void setBkgMdtItmCd(String bkgMdtItmCd) {
		this.bkgMdtItmCd = bkgMdtItmCd;
	}
	
	/**
	 * Column Info
	 * @param itmNmLc
	 */
	public void setItmNmLc(String itmNmLc) {
		this.itmNmLc = itmNmLc;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param fcust
	 */
	public void setFcust(String fcust) {
		this.fcust = fcust;
	}
	
	/**
	 * Column Info
	 * @param mdtItmSeq
	 */
	public void setMdtItmSeq(String mdtItmSeq) {
		this.mdtItmSeq = mdtItmSeq;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param itmNmShp
	 */
	public void setItmNmShp(String itmNmShp) {
		this.itmNmShp = itmNmShp;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param blIssNote
	 */
	public void setBlIssNote(String blIssNote) {
		this.blIssNote = blIssNote;
	}
	
	/**
	 * Column Info
	 * @param itmCdLc
	 */
	public void setItmCdLc(String itmCdLc) {
		this.itmCdLc = itmCdLc;
	}
	
	/**
	 * Column Info
	 * @param bkgMdtCateCd
	 */
	public void setBkgMdtCateCd(String bkgMdtCateCd) {
		this.bkgMdtCateCd = bkgMdtCateCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setItmCdPoc(JSPUtil.getParameter(request, prefix + "itm_cd_poc", ""));
		setItmCdPob(JSPUtil.getParameter(request, prefix + "itm_cd_pob", ""));
		setItmNmPob(JSPUtil.getParameter(request, prefix + "itm_nm_pob", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setItmNmDep(JSPUtil.getParameter(request, prefix + "itm_nm_dep", ""));
		setItmNmPoc(JSPUtil.getParameter(request, prefix + "itm_nm_poc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setItmNmPom(JSPUtil.getParameter(request, prefix + "itm_nm_pom", ""));
		setItmNmPat(JSPUtil.getParameter(request, prefix + "itm_nm_pat", ""));
		setItmNmInc(JSPUtil.getParameter(request, prefix + "itm_nm_inc", ""));
		setItmCdPom(JSPUtil.getParameter(request, prefix + "itm_cd_pom", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setItmCdDep(JSPUtil.getParameter(request, prefix + "itm_cd_dep", ""));
		setScExpDt(JSPUtil.getParameter(request, prefix + "sc_exp_dt", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBlIssNoteCtnt(JSPUtil.getParameter(request, prefix + "bl_iss_note_ctnt", ""));
		setItmCdInv(JSPUtil.getParameter(request, prefix + "itm_cd_inv", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setMdtCustTpCd(JSPUtil.getParameter(request, prefix + "mdt_cust_tp_cd", ""));
		setItmCdPat(JSPUtil.getParameter(request, prefix + "itm_cd_pat", ""));
		setMdtItmRmk(JSPUtil.getParameter(request, prefix + "mdt_itm_rmk", ""));
		setItmCdShp(JSPUtil.getParameter(request, prefix + "itm_cd_shp", ""));
		setRfaExpDt(JSPUtil.getParameter(request, prefix + "rfa_exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setItmNmInv(JSPUtil.getParameter(request, prefix + "itm_nm_inv", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setItmCdInc(JSPUtil.getParameter(request, prefix + "itm_cd_inc", ""));
		setBkgMdtItmCd(JSPUtil.getParameter(request, prefix + "bkg_mdt_itm_cd", ""));
		setItmNmLc(JSPUtil.getParameter(request, prefix + "itm_nm_lc", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setFcust(JSPUtil.getParameter(request, prefix + "fcust", ""));
		setMdtItmSeq(JSPUtil.getParameter(request, prefix + "mdt_itm_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setItmNmShp(JSPUtil.getParameter(request, prefix + "itm_nm_shp", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBlIssNote(JSPUtil.getParameter(request, prefix + "bl_iss_note", ""));
		setItmCdLc(JSPUtil.getParameter(request, prefix + "itm_cd_lc", ""));
		setBkgMdtCateCd(JSPUtil.getParameter(request, prefix + "bkg_mdt_cate_cd", ""));
		setItmCdMsl(JSPUtil.getParameter(request, prefix + "itm_cd_msl", ""));
		setItmNmMsl(JSPUtil.getParameter(request, prefix + "itm_nm_msl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgMdtItmVO[]
	 */
	public BkgMdtItmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgMdtItmVO[]
	 */
	public BkgMdtItmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgMdtItmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] itmCdPoc = (JSPUtil.getParameter(request, prefix	+ "itm_cd_poc", length));
			String[] itmCdPob = (JSPUtil.getParameter(request, prefix	+ "itm_cd_pob", length));
			String[] itmNmPob = (JSPUtil.getParameter(request, prefix	+ "itm_nm_pob", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] itmNmDep = (JSPUtil.getParameter(request, prefix	+ "itm_nm_dep", length));
			String[] itmNmPoc = (JSPUtil.getParameter(request, prefix	+ "itm_nm_poc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] itmNmPom = (JSPUtil.getParameter(request, prefix	+ "itm_nm_pom", length));
			String[] itmNmPat = (JSPUtil.getParameter(request, prefix	+ "itm_nm_pat", length));
			String[] itmNmInc = (JSPUtil.getParameter(request, prefix	+ "itm_nm_inc", length));
			String[] itmCdPom = (JSPUtil.getParameter(request, prefix	+ "itm_cd_pom", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] itmCdDep = (JSPUtil.getParameter(request, prefix	+ "itm_cd_dep", length));
			String[] scExpDt = (JSPUtil.getParameter(request, prefix	+ "sc_exp_dt", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] blIssNoteCtnt = (JSPUtil.getParameter(request, prefix	+ "bl_iss_note_ctnt", length));
			String[] itmCdInv = (JSPUtil.getParameter(request, prefix	+ "itm_cd_inv", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] mdtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "mdt_cust_tp_cd", length));
			String[] itmCdPat = (JSPUtil.getParameter(request, prefix	+ "itm_cd_pat", length));
			String[] mdtItmRmk = (JSPUtil.getParameter(request, prefix	+ "mdt_itm_rmk", length));
			String[] itmCdShp = (JSPUtil.getParameter(request, prefix	+ "itm_cd_shp", length));
			String[] rfaExpDt = (JSPUtil.getParameter(request, prefix	+ "rfa_exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] itmNmInv = (JSPUtil.getParameter(request, prefix	+ "itm_nm_inv", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] itmCdInc = (JSPUtil.getParameter(request, prefix	+ "itm_cd_inc", length));
			String[] bkgMdtItmCd = (JSPUtil.getParameter(request, prefix	+ "bkg_mdt_itm_cd", length));
			String[] itmNmLc = (JSPUtil.getParameter(request, prefix	+ "itm_nm_lc", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] fcust = (JSPUtil.getParameter(request, prefix	+ "fcust", length));
			String[] mdtItmSeq = (JSPUtil.getParameter(request, prefix	+ "mdt_itm_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] itmNmShp = (JSPUtil.getParameter(request, prefix	+ "itm_nm_shp", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] blIssNote = (JSPUtil.getParameter(request, prefix	+ "bl_iss_note", length));
			String[] itmCdLc = (JSPUtil.getParameter(request, prefix	+ "itm_cd_lc", length));
			String[] bkgMdtCateCd = (JSPUtil.getParameter(request, prefix	+ "bkg_mdt_cate_cd", length));
			String[] itmCdMsl = (JSPUtil.getParameter(request, prefix	+ "itm_cd_msl", length));
			String[] itmNmMsl = (JSPUtil.getParameter(request, prefix	+ "itm_nm_msl", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgMdtItmVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (itmCdPoc[i] != null)
					model.setItmCdPoc(itmCdPoc[i]);
				if (itmCdPob[i] != null)
					model.setItmCdPob(itmCdPob[i]);
				if (itmNmPob[i] != null)
					model.setItmNmPob(itmNmPob[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (itmNmDep[i] != null)
					model.setItmNmDep(itmNmDep[i]);
				if (itmNmPoc[i] != null)
					model.setItmNmPoc(itmNmPoc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (itmNmPom[i] != null)
					model.setItmNmPom(itmNmPom[i]);
				if (itmNmPat[i] != null)
					model.setItmNmPat(itmNmPat[i]);
				if (itmNmInc[i] != null)
					model.setItmNmInc(itmNmInc[i]);
				if (itmCdPom[i] != null)
					model.setItmCdPom(itmCdPom[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (itmCdDep[i] != null)
					model.setItmCdDep(itmCdDep[i]);
				if (scExpDt[i] != null)
					model.setScExpDt(scExpDt[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (blIssNoteCtnt[i] != null)
					model.setBlIssNoteCtnt(blIssNoteCtnt[i]);
				if (itmCdInv[i] != null)
					model.setItmCdInv(itmCdInv[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (mdtCustTpCd[i] != null)
					model.setMdtCustTpCd(mdtCustTpCd[i]);
				if (itmCdPat[i] != null)
					model.setItmCdPat(itmCdPat[i]);
				if (mdtItmRmk[i] != null)
					model.setMdtItmRmk(mdtItmRmk[i]);
				if (itmCdShp[i] != null)
					model.setItmCdShp(itmCdShp[i]);
				if (rfaExpDt[i] != null)
					model.setRfaExpDt(rfaExpDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (itmNmInv[i] != null)
					model.setItmNmInv(itmNmInv[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (itmCdInc[i] != null)
					model.setItmCdInc(itmCdInc[i]);
				if (bkgMdtItmCd[i] != null)
					model.setBkgMdtItmCd(bkgMdtItmCd[i]);
				if (itmNmLc[i] != null)
					model.setItmNmLc(itmNmLc[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (fcust[i] != null)
					model.setFcust(fcust[i]);
				if (mdtItmSeq[i] != null)
					model.setMdtItmSeq(mdtItmSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (itmNmShp[i] != null)
					model.setItmNmShp(itmNmShp[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (blIssNote[i] != null)
					model.setBlIssNote(blIssNote[i]);
				if (itmCdLc[i] != null)
					model.setItmCdLc(itmCdLc[i]);
				if (bkgMdtCateCd[i] != null)
					model.setBkgMdtCateCd(bkgMdtCateCd[i]);
				if (itmCdMsl[i] != null)
					model.setItmCdMsl(itmCdMsl[i]);
				if (itmNmMsl[i] != null)
					model.setItmNmMsl(itmNmMsl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgMdtItmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgMdtItmVO[]
	 */
	public BkgMdtItmVO[] getBkgMdtItmVOs(){
		BkgMdtItmVO[] vos = (BkgMdtItmVO[])models.toArray(new BkgMdtItmVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdPoc = this.itmCdPoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdPob = this.itmCdPob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNmPob = this.itmNmPob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNmDep = this.itmNmDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNmPoc = this.itmNmPoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNmPom = this.itmNmPom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNmPat = this.itmNmPat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNmInc = this.itmNmInc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdPom = this.itmCdPom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdDep = this.itmCdDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExpDt = this.scExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssNoteCtnt = this.blIssNoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdInv = this.itmCdInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdtCustTpCd = this.mdtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdPat = this.itmCdPat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdtItmRmk = this.mdtItmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdShp = this.itmCdShp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExpDt = this.rfaExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNmInv = this.itmNmInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdInc = this.itmCdInc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMdtItmCd = this.bkgMdtItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNmLc = this.itmNmLc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcust = this.fcust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdtItmSeq = this.mdtItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNmShp = this.itmNmShp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssNote = this.blIssNote .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdLc = this.itmCdLc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMdtCateCd = this.bkgMdtCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdMsl = this.itmCdMsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNmMsl = this.itmNmMsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
