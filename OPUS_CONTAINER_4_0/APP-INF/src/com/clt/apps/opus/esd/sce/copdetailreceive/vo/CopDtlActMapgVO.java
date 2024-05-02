/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDtlActMapgVO.java
*@FileTitle : CopDtlActMapgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copdetailreceive.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class CopDtlActMapgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CopDtlActMapgVO> models = new ArrayList<CopDtlActMapgVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String stndEdiStsCd = null;
	/* Column Info */
	private String actStsMapgCd = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info of VSK ACT*/
	private String preCopNo = null;
	/* Column Info of VSK ACT*/
	private String preCopDtlSeq = null;
	/* Column Info of VSK ACT*/
	private String nxtCopNo = null;
	/* Column Info of VSK ACT*/
	private String nxtCopDtlSeq = null;	
	/* Column Info of VSK ACT*/
	private String actDt = null;	
	/* Column Info of VSK ACT*/
	private String mstCopNo = null;	
	/* Column Info of VSK ACT*/
	private String bkgNo = null;	
	/* Column Info of VSK ACT*/
	private String cntrNo = null;	
	/* Column Info of VSK ACT*/
	private String copStsCd = null;	
	/* Column Info of 214 */
	private String soCd = null;
	/* Column Info of 214 */
	private String soSeq = null;
	/* Column Info of 214 */
	private String creUsrId = null;
	/* Column Info of 214 */
	private String updUsrId = null;
	/* Column Info of replan 315 */
	private String rplnBatSndFlg = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CopDtlActMapgVO() {}

	public CopDtlActMapgVO(String ibflag, String pagerows, String copNo, String copDtlSeq, String nodCd, String actStsCd, String actRcvTpCd, String actStsMapgCd, String vslCd, String skdVoyNo, String skdDirCd, String stndEdiStsCd, String actCd, String lvl, String preCopNo, String preCopDtlSeq, String nxtCopNo, String nxtCopDtlSeq, String actDt, String mstCopNo, String bkgNo, String cntrNo, String copStsCd, String soCd, String soSeq, String creUsrId, String updUsrId, String rplnBatSndFlg) {
		this.vslCd = vslCd;
		this.actCd = actCd;
		this.actRcvTpCd = actRcvTpCd;
		this.copNo = copNo;
		this.skdVoyNo = skdVoyNo;
		this.stndEdiStsCd = stndEdiStsCd;
		this.actStsMapgCd = actStsMapgCd;
		this.copDtlSeq = copDtlSeq;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.actStsCd = actStsCd;
		this.ibflag = ibflag;
		this.lvl = lvl;
		this.nodCd = nodCd;
		this.preCopNo = preCopNo;
		this.preCopDtlSeq = preCopDtlSeq;
		this.nxtCopNo = nxtCopNo;
		this.nxtCopDtlSeq = preCopDtlSeq;
		this.actDt = actDt;
		this.mstCopNo = mstCopNo;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.copStsCd = copStsCd;
		this.soCd = soCd;
		this.soSeq = soSeq;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.rplnBatSndFlg = rplnBatSndFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("stnd_edi_sts_cd", getStndEdiStsCd());
		this.hashColumns.put("act_sts_mapg_cd", getActStsMapgCd());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_sts_cd", getActStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("pre_cop_no", getPreCopNo());
		this.hashColumns.put("pre_cop_dtl_seq", getPreCopDtlSeq());
		this.hashColumns.put("nxt_cop_no", getNxtCopNo());
		this.hashColumns.put("nxt_cop_dtl_seq", getNxtCopDtlSeq());
		this.hashColumns.put("act_dt", getNxtCopDtlSeq());
		this.hashColumns.put("mst_cop_no", getMstCopNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("so_cd", getCntrNo());
		this.hashColumns.put("so_seq", getCopStsCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rpln_bat_snd_flg", getRplnBatSndFlg());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("stnd_edi_sts_cd", "stndEdiStsCd");
		this.hashFields.put("act_sts_mapg_cd", "actStsMapgCd");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_sts_cd", "actStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("pre_cop_no", "preCopNo");
		this.hashFields.put("pre_cop_dtl_seq", "preCopDtlSeq");
		this.hashFields.put("nxt_cop_no", "nxtCopNo");
		this.hashFields.put("nxt_cop_dtl_seq", "nxtCopDtlSeq");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("mst_cop_no", "mstCopNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("so_cd", "soCd");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rpln_bat_snd_flg", "rplnBatSndFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return actRcvTpCd
	 */
	public String getActRcvTpCd() {
		return this.actRcvTpCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return stndEdiStsCd
	 */
	public String getStndEdiStsCd() {
		return this.stndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return actStsCd
	 */
	public String getActStsCd() {
		return this.actStsCd;
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
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	
	/**
	 * Column Info of VSK ACT
	 * @return preCopNo
	 */
	public String getPreCopNo() {
		return this.preCopNo;
	}
	
	
	/**
	 * Column Info of VSK ACT
	 * @return preCopDtlSeq
	 */
	public String getPreCopDtlSeq() {
		return this.preCopDtlSeq;
	}
	
	
	/**
	 * Column Info of VSK ACT
	 * @return nxtCopNo
	 */
	public String getNxtCopNo() {
		return this.nxtCopNo;
	}
	
	
	/**
	 * Column Info of VSK ACT
	 * @return nxtCopDtlSeq
	 */
	public String getNxtCopDtlSeq() {
		return this.nxtCopDtlSeq;
	}
	
	/**
	 * Column Info of VSK ACT
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info of VSK ACT
	 * @return mstCopNo
	 */
	public String getMstCopNo() {
		return this.mstCopNo;
	}	
	
	/**
	 * Column Info of VSK ACT
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}	
	
	/**
	 * Column Info of VSK ACT
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}	
	
	/**
	 * Column Info of VSK ACT
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}	
	
	/**
	 * Column Info of 214
	 * @return soCd
	 */
	public String getSoCd() {
		return this.soCd;
	}	
	
	/**
	 * Column Info of 214
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}	
	
	/**
	 * Column Info of 214
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info of 214
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	 
	/**
	 * Column Info of replan 315
	 * @return rplnBatSndFlg
	 */
	public String getRplnBatSndFlg() {
		return rplnBatSndFlg;
	}

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param actRcvTpCd
	 */
	public void setActRcvTpCd(String actRcvTpCd) {
		this.actRcvTpCd = actRcvTpCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param stndEdiStsCd
	 */
	public void setStndEdiStsCd(String stndEdiStsCd) {
		this.stndEdiStsCd = stndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param actStsCd
	 */
	public void setActStsCd(String actStsCd) {
		this.actStsCd = actStsCd;
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
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info of VSK ACT
	 * @param preCopNo
	 */
	public void setPreCopNo(String preCopNo) {
		this.preCopNo = preCopNo;
	}
	
	/**
	 * Column Info of VSK ACT
	 * @param preCopDtlSeq
	 */
	public void setPreCopDtlSeq(String preCopDtlSeq) {
		this.preCopDtlSeq = preCopDtlSeq;
	}
	
	/**
	 * Column Info of VSK ACT
	 * @param nxtCopNo
	 */
	public void setNxtCopNo(String nxtCopNo) {
		this.nxtCopNo = nxtCopNo;
	}
	
	/**
	 * Column Info of VSK ACT
	 * @param nxtCopDtlSeq
	 */
	public void setNxtCopDtlSeq(String nxtCopDtlSeq) {
		this.nxtCopDtlSeq = nxtCopDtlSeq;
	}
	
	/**
	 * Column Info of VSK ACT
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info of VSK ACT
	 * @param mstCopNo
	 */
	public void setMstCopNo(String mstCopNo) {
		this.mstCopNo = mstCopNo;
	}
	
	/**
	 * Column Info of VSK ACT
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info of VSK ACT
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	
	/**
	 * Column Info of VSK ACT
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info of 214
	 * @param soCd
	 */
	public void setSoCd(String soCd) {
		this.soCd = soCd;
	}
	
	
	/**
	 * Column Info of 214
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info of 214
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.soSeq = creUsrId;
	}
	
	/**
	 * Column Info of 214
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info of replan 315
	 * @param rplnBatSndFlg
	 */
	public void setRplnBatSndFlg(String rplnBatSndFlg) {
		this.rplnBatSndFlg = rplnBatSndFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, "act_rcv_tp_cd", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setStndEdiStsCd(JSPUtil.getParameter(request, "stnd_edi_sts_cd", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, "act_sts_mapg_cd", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, "cop_dtl_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActStsCd(JSPUtil.getParameter(request, "act_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLvl(JSPUtil.getParameter(request, "lvl", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setPreCopNo(JSPUtil.getParameter(request, "pre_cop_no", ""));
		setPreCopDtlSeq(JSPUtil.getParameter(request, "pre_cop_dtl_seq", ""));
		setNxtCopNo(JSPUtil.getParameter(request, "nxt_cop_no", ""));
		setNxtCopDtlSeq(JSPUtil.getParameter(request, "nxt_cop_dtl_seq", ""));
		setActDt(JSPUtil.getParameter(request, "act_dt", ""));
		setMstCopNo(JSPUtil.getParameter(request, "mst_cop_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCopStsCd(JSPUtil.getParameter(request, "cop_sts_cd", ""));
		setSoCd(JSPUtil.getParameter(request, "so_cd", ""));
		setSoSeq(JSPUtil.getParameter(request, "so_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRplnBatSndFlg(JSPUtil.getParameter(request, "rpln_bat_snd_flg", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CopDtlActMapgVO[]
	 */
	public CopDtlActMapgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CopDtlActMapgVO[]
	 */
	public CopDtlActMapgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CopDtlActMapgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] stndEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "stnd_edi_sts_cd", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_mapg_cd", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actStsCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] preCopNo = (JSPUtil.getParameter(request, prefix	+ "pre_cop_no", length));
			String[] preCopDtlSeq = (JSPUtil.getParameter(request, prefix	+ "pre_cop_dtl_seq", length));
			String[] nxtCopNo = (JSPUtil.getParameter(request, prefix	+ "nxt_cop_no", length));
			String[] nxtCopDtlSeq = (JSPUtil.getParameter(request, prefix	+ "nxt_cop_dtl_seq", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] mstCopNo = (JSPUtil.getParameter(request, prefix	+ "mst_cop_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] soCd = (JSPUtil.getParameter(request, prefix	+ "so_cd", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rplnBatSndFlg = (JSPUtil.getParameter(request, prefix	+ "rpln_bat_snd_flg", length));			
			
			for (int i = 0; i < length; i++) {
				model = new CopDtlActMapgVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (stndEdiStsCd[i] != null)
					model.setStndEdiStsCd(stndEdiStsCd[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actStsCd[i] != null)
					model.setActStsCd(actStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (preCopNo[i] != null)
					model.setPreCopNo(preCopNo[i]);
				if (preCopDtlSeq[i] != null)
					model.setPreCopDtlSeq(preCopDtlSeq[i]);
				if (nxtCopNo[i] != null)
					model.setNxtCopNo(nxtCopNo[i]);
				if (nxtCopDtlSeq[i] != null)
					model.setNxtCopDtlSeq(nxtCopDtlSeq[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (mstCopNo[i] != null)
					model.setMstCopNo(mstCopNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (soCd[i] != null)
					model.setSoCd(soCd[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rplnBatSndFlg[i] != null)
					model.setRplnBatSndFlg(rplnBatSndFlg[i]);				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCopDtlActMapgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CopDtlActMapgVO[]
	 */
	public CopDtlActMapgVO[] getCopDtlActMapgVOs(){
		CopDtlActMapgVO[] vos = (CopDtlActMapgVO[])models.toArray(new CopDtlActMapgVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndEdiStsCd = this.stndEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsCd = this.actStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCopNo = this.preCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCopDtlSeq = this.preCopDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtCopNo = this.nxtCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtCopDtlSeq = this.nxtCopDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCopNo = this.mstCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCd = this.soCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnBatSndFlg = this.rplnBatSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
