/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AddSceEdiSndRsltVO.java
*@FileTitle : AddSceEdiSndRsltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.18 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AddSceEdiSndRsltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AddSceEdiSndRsltVO> models = new ArrayList<AddSceEdiSndRsltVO>();
	
	/* Column Info */
	private String gmtDt = null;
	/* Column Info */
	private String ediStsCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediSndRsvDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String manFlg = null;
	/* Column Info */
	private String ediSndYrmondy = null;
	/* Column Info */
	private String pkupEdi322No = null;
	/* Column Info */
	private String ediSndRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String nod = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String ediSndKnt = null;
	/* Column Info */
	private String ediSubStsCd = null;
	/* Column Info */
	private String poNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ediSndSeq = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String rsltFlag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ediSndItvalHr = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String ediSndTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AddSceEdiSndRsltVO() {}

	public AddSceEdiSndRsltVO(String ibflag, String pagerows, String ediGrpCd, String ediStsCd, String ediSubStsCd, String bkgNo, String cntrNo, String poNo, String ediSndKnt, String blNo, String nodCd, String actDt, String manFlg, String ediSndRmk, String ediSndTpCd, String creUsrId, String creDt, String updUsrId, String updDt, String ediSndYrmondy, String ediSndSeq, String pkupEdi322No, String ediSndRsvDt, String trunkVvd, String gmtDt, String fltFileRefNo, String rsltFlag, String nod, String ediSndItvalHr, String copNo) {
		this.gmtDt = gmtDt;
		this.ediStsCd = ediStsCd;
		this.copNo = copNo;
		this.creDt = creDt;
		this.trunkVvd = trunkVvd;
		this.fltFileRefNo = fltFileRefNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ediSndRsvDt = ediSndRsvDt;
		this.ibflag = ibflag;
		this.manFlg = manFlg;
		this.ediSndYrmondy = ediSndYrmondy;
		this.pkupEdi322No = pkupEdi322No;
		this.ediSndRmk = ediSndRmk;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.nod = nod;
		this.ediGrpCd = ediGrpCd;
		this.ediSndKnt = ediSndKnt;
		this.ediSubStsCd = ediSubStsCd;
		this.poNo = poNo;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.ediSndSeq = ediSndSeq;
		this.actDt = actDt;
		this.rsltFlag = rsltFlag;
		this.cntrNo = cntrNo;
		this.ediSndItvalHr = ediSndItvalHr;
		this.nodCd = nodCd;
		this.ediSndTpCd = ediSndTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gmt_dt", getGmtDt());
		this.hashColumns.put("edi_sts_cd", getEdiStsCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("edi_snd_rsv_dt", getEdiSndRsvDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("man_flg", getManFlg());
		this.hashColumns.put("edi_snd_yrmondy", getEdiSndYrmondy());
		this.hashColumns.put("pkup_edi_322_no", getPkupEdi322No());
		this.hashColumns.put("edi_snd_rmk", getEdiSndRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("nod", getNod());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("edi_snd_knt", getEdiSndKnt());
		this.hashColumns.put("edi_sub_sts_cd", getEdiSubStsCd());
		this.hashColumns.put("po_no", getPoNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("edi_snd_seq", getEdiSndSeq());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("rslt_flag", getRsltFlag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("edi_snd_itval_hr", getEdiSndItvalHr());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("edi_snd_tp_cd", getEdiSndTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gmt_dt", "gmtDt");
		this.hashFields.put("edi_sts_cd", "ediStsCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("edi_snd_rsv_dt", "ediSndRsvDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("man_flg", "manFlg");
		this.hashFields.put("edi_snd_yrmondy", "ediSndYrmondy");
		this.hashFields.put("pkup_edi_322_no", "pkupEdi322No");
		this.hashFields.put("edi_snd_rmk", "ediSndRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("nod", "nod");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("edi_snd_knt", "ediSndKnt");
		this.hashFields.put("edi_sub_sts_cd", "ediSubStsCd");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("edi_snd_seq", "ediSndSeq");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("rslt_flag", "rsltFlag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("edi_snd_itval_hr", "ediSndItvalHr");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("edi_snd_tp_cd", "ediSndTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return gmtDt
	 */
	public String getGmtDt() {
		return this.gmtDt;
	}
	
	/**
	 * Column Info
	 * @return ediStsCd
	 */
	public String getEdiStsCd() {
		return this.ediStsCd;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
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
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
	}
	
	/**
	 * Column Info
	 * @return fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return this.fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return ediSndRsvDt
	 */
	public String getEdiSndRsvDt() {
		return this.ediSndRsvDt;
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
	 * @return manFlg
	 */
	public String getManFlg() {
		return this.manFlg;
	}
	
	/**
	 * Column Info
	 * @return ediSndYrmondy
	 */
	public String getEdiSndYrmondy() {
		return this.ediSndYrmondy;
	}
	
	/**
	 * Column Info
	 * @return pkupEdi322No
	 */
	public String getPkupEdi322No() {
		return this.pkupEdi322No;
	}
	
	/**
	 * Column Info
	 * @return ediSndRmk
	 */
	public String getEdiSndRmk() {
		return this.ediSndRmk;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return nod
	 */
	public String getNod() {
		return this.nod;
	}
	
	/**
	 * Column Info
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndKnt
	 */
	public String getEdiSndKnt() {
		return this.ediSndKnt;
	}
	
	/**
	 * Column Info
	 * @return ediSubStsCd
	 */
	public String getEdiSubStsCd() {
		return this.ediSubStsCd;
	}
	
	/**
	 * Column Info
	 * @return poNo
	 */
	public String getPoNo() {
		return this.poNo;
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
	 * @return ediSndSeq
	 */
	public String getEdiSndSeq() {
		return this.ediSndSeq;
	}
	
	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return rsltFlag
	 */
	public String getRsltFlag() {
		return this.rsltFlag;
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
	 * @return ediSndItvalHr
	 */
	public String getEdiSndItvalHr() {
		return this.ediSndItvalHr;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndTpCd
	 */
	public String getEdiSndTpCd() {
		return this.ediSndTpCd;
	}
	

	/**
	 * Column Info
	 * @param gmtDt
	 */
	public void setGmtDt(String gmtDt) {
		this.gmtDt = gmtDt;
	}
	
	/**
	 * Column Info
	 * @param ediStsCd
	 */
	public void setEdiStsCd(String ediStsCd) {
		this.ediStsCd = ediStsCd;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
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
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * Column Info
	 * @param fltFileRefNo
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param ediSndRsvDt
	 */
	public void setEdiSndRsvDt(String ediSndRsvDt) {
		this.ediSndRsvDt = ediSndRsvDt;
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
	 * @param manFlg
	 */
	public void setManFlg(String manFlg) {
		this.manFlg = manFlg;
	}
	
	/**
	 * Column Info
	 * @param ediSndYrmondy
	 */
	public void setEdiSndYrmondy(String ediSndYrmondy) {
		this.ediSndYrmondy = ediSndYrmondy;
	}
	
	/**
	 * Column Info
	 * @param pkupEdi322No
	 */
	public void setPkupEdi322No(String pkupEdi322No) {
		this.pkupEdi322No = pkupEdi322No;
	}
	
	/**
	 * Column Info
	 * @param ediSndRmk
	 */
	public void setEdiSndRmk(String ediSndRmk) {
		this.ediSndRmk = ediSndRmk;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param nod
	 */
	public void setNod(String nod) {
		this.nod = nod;
	}
	
	/**
	 * Column Info
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndKnt
	 */
	public void setEdiSndKnt(String ediSndKnt) {
		this.ediSndKnt = ediSndKnt;
	}
	
	/**
	 * Column Info
	 * @param ediSubStsCd
	 */
	public void setEdiSubStsCd(String ediSubStsCd) {
		this.ediSubStsCd = ediSubStsCd;
	}
	
	/**
	 * Column Info
	 * @param poNo
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
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
	 * @param ediSndSeq
	 */
	public void setEdiSndSeq(String ediSndSeq) {
		this.ediSndSeq = ediSndSeq;
	}
	
	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param rsltFlag
	 */
	public void setRsltFlag(String rsltFlag) {
		this.rsltFlag = rsltFlag;
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
	 * @param ediSndItvalHr
	 */
	public void setEdiSndItvalHr(String ediSndItvalHr) {
		this.ediSndItvalHr = ediSndItvalHr;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndTpCd
	 */
	public void setEdiSndTpCd(String ediSndTpCd) {
		this.ediSndTpCd = ediSndTpCd;
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
		setGmtDt(JSPUtil.getParameter(request, prefix + "gmt_dt", ""));
		setEdiStsCd(JSPUtil.getParameter(request, prefix + "edi_sts_cd", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, prefix + "flt_file_ref_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEdiSndRsvDt(JSPUtil.getParameter(request, prefix + "edi_snd_rsv_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setManFlg(JSPUtil.getParameter(request, prefix + "man_flg", ""));
		setEdiSndYrmondy(JSPUtil.getParameter(request, prefix + "edi_snd_yrmondy", ""));
		setPkupEdi322No(JSPUtil.getParameter(request, prefix + "pkup_edi_322_no", ""));
		setEdiSndRmk(JSPUtil.getParameter(request, prefix + "edi_snd_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNod(JSPUtil.getParameter(request, prefix + "nod", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, prefix + "edi_grp_cd", ""));
		setEdiSndKnt(JSPUtil.getParameter(request, prefix + "edi_snd_knt", ""));
		setEdiSubStsCd(JSPUtil.getParameter(request, prefix + "edi_sub_sts_cd", ""));
		setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEdiSndSeq(JSPUtil.getParameter(request, prefix + "edi_snd_seq", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setRsltFlag(JSPUtil.getParameter(request, prefix + "rslt_flag", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setEdiSndItvalHr(JSPUtil.getParameter(request, prefix + "edi_snd_itval_hr", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setEdiSndTpCd(JSPUtil.getParameter(request, prefix + "edi_snd_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AddSceEdiSndRsltVO[]
	 */
	public AddSceEdiSndRsltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AddSceEdiSndRsltVO[]
	 */
	public AddSceEdiSndRsltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AddSceEdiSndRsltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] gmtDt = (JSPUtil.getParameter(request, prefix	+ "gmt_dt", length));
			String[] ediStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_sts_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ediSndRsvDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_rsv_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] manFlg = (JSPUtil.getParameter(request, prefix	+ "man_flg", length));
			String[] ediSndYrmondy = (JSPUtil.getParameter(request, prefix	+ "edi_snd_yrmondy", length));
			String[] pkupEdi322No = (JSPUtil.getParameter(request, prefix	+ "pkup_edi_322_no", length));
			String[] ediSndRmk = (JSPUtil.getParameter(request, prefix	+ "edi_snd_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] nod = (JSPUtil.getParameter(request, prefix	+ "nod", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] ediSndKnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_knt", length));
			String[] ediSubStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_sub_sts_cd", length));
			String[] poNo = (JSPUtil.getParameter(request, prefix	+ "po_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ediSndSeq = (JSPUtil.getParameter(request, prefix	+ "edi_snd_seq", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] rsltFlag = (JSPUtil.getParameter(request, prefix	+ "rslt_flag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ediSndItvalHr = (JSPUtil.getParameter(request, prefix	+ "edi_snd_itval_hr", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] ediSndTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_snd_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AddSceEdiSndRsltVO();
				if (gmtDt[i] != null)
					model.setGmtDt(gmtDt[i]);
				if (ediStsCd[i] != null)
					model.setEdiStsCd(ediStsCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ediSndRsvDt[i] != null)
					model.setEdiSndRsvDt(ediSndRsvDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (manFlg[i] != null)
					model.setManFlg(manFlg[i]);
				if (ediSndYrmondy[i] != null)
					model.setEdiSndYrmondy(ediSndYrmondy[i]);
				if (pkupEdi322No[i] != null)
					model.setPkupEdi322No(pkupEdi322No[i]);
				if (ediSndRmk[i] != null)
					model.setEdiSndRmk(ediSndRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (nod[i] != null)
					model.setNod(nod[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (ediSndKnt[i] != null)
					model.setEdiSndKnt(ediSndKnt[i]);
				if (ediSubStsCd[i] != null)
					model.setEdiSubStsCd(ediSubStsCd[i]);
				if (poNo[i] != null)
					model.setPoNo(poNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ediSndSeq[i] != null)
					model.setEdiSndSeq(ediSndSeq[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (rsltFlag[i] != null)
					model.setRsltFlag(rsltFlag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ediSndItvalHr[i] != null)
					model.setEdiSndItvalHr(ediSndItvalHr[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (ediSndTpCd[i] != null)
					model.setEdiSndTpCd(ediSndTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAddSceEdiSndRsltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AddSceEdiSndRsltVO[]
	 */
	public AddSceEdiSndRsltVO[] getAddSceEdiSndRsltVOs(){
		AddSceEdiSndRsltVO[] vos = (AddSceEdiSndRsltVO[])models.toArray(new AddSceEdiSndRsltVO[models.size()]);
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
		this.gmtDt = this.gmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStsCd = this.ediStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndRsvDt = this.ediSndRsvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manFlg = this.manFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndYrmondy = this.ediSndYrmondy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupEdi322No = this.pkupEdi322No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndRmk = this.ediSndRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nod = this.nod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndKnt = this.ediSndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSubStsCd = this.ediSubStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo = this.poNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndSeq = this.ediSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltFlag = this.rsltFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndItvalHr = this.ediSndItvalHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndTpCd = this.ediSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
