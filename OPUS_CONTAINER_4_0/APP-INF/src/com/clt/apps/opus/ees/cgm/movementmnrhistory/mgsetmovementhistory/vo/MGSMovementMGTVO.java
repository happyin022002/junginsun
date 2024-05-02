/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : chassisMovementMGTVO.java
*@FileTitle : chassisMovementMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.10.19 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSMovementMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSMovementMGTVO> models = new ArrayList<MGSMovementMGTVO>();
	
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mvmtDt2 = null;
	/* Column Info */
	private String destYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mgstOwnrCoCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String gateIoCd = null;
	/* Column Info */
	private String cntrOwnrCoCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mvmtCoCd = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String mvmtRsnCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Column Info */
	private String sysSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MGSMovementMGTVO() {}

	public MGSMovementMGTVO(String ibflag, String pagerows, String bkgNoSplit, String bkgNo, String cnmvYr, String sysSeq, String updUsrId, String updDt, String cntrNo, String cnmvIdNo, String vndrSeq, String cntrOwnrCoCd, String ydCd, String chssNo, String diffRmk, String mvmtCoCd, String gateIoCd, String mvmtRsnCd, String creDt, String creUsrId, String mgstOwnrCoCd, String mgstNo, String mvmtDt, String mvmtDt2, String mvmtStsCd, String destYdCd) {
		this.chssNo = chssNo;
		this.creDt = creDt;
		this.mvmtDt2 = mvmtDt2;
		this.destYdCd = destYdCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.mgstOwnrCoCd = mgstOwnrCoCd;
		this.updUsrId = updUsrId;
		this.gateIoCd = gateIoCd;
		this.cntrOwnrCoCd = cntrOwnrCoCd;
		this.updDt = updDt;
		this.mvmtCoCd = mvmtCoCd;
		this.bkgNoSplit = bkgNoSplit;
		this.mgstNo = mgstNo;
		this.cnmvIdNo = cnmvIdNo;
		this.mvmtRsnCd = mvmtRsnCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.mvmtStsCd = mvmtStsCd;
		this.diffRmk = diffRmk;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.cnmvYr = cnmvYr;
		this.mvmtDt = mvmtDt;
		this.sysSeq = sysSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mvmt_dt2", getMvmtDt2());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mgst_ownr_co_cd", getMgstOwnrCoCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("gate_io_cd", getGateIoCd());
		this.hashColumns.put("cntr_ownr_co_cd", getCntrOwnrCoCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mvmt_co_cd", getMvmtCoCd());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("mvmt_rsn_cd", getMvmtRsnCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("sys_seq", getSysSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mvmt_dt2", "mvmtDt2");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mgst_ownr_co_cd", "mgstOwnrCoCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("gate_io_cd", "gateIoCd");
		this.hashFields.put("cntr_ownr_co_cd", "cntrOwnrCoCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mvmt_co_cd", "mvmtCoCd");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("mvmt_rsn_cd", "mvmtRsnCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("sys_seq", "sysSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
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
	 * @return mvmtDt2
	 */
	public String getMvmtDt2() {
		return this.mvmtDt2;
	}
	
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
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
	 * @return mgstOwnrCoCd
	 */
	public String getMgstOwnrCoCd() {
		return this.mgstOwnrCoCd;
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
	 * @return gateIoCd
	 */
	public String getGateIoCd() {
		return this.gateIoCd;
	}
	
	/**
	 * Column Info
	 * @return cntrOwnrCoCd
	 */
	public String getCntrOwnrCoCd() {
		return this.cntrOwnrCoCd;
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
	 * @return mvmtCoCd
	 */
	public String getMvmtCoCd() {
		return this.mvmtCoCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtRsnCd
	 */
	public String getMvmtRsnCd() {
		return this.mvmtRsnCd;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
	}
	
	/**
	 * Column Info
	 * @return sysSeq
	 */
	public String getSysSeq() {
		return this.sysSeq;
	}
	

	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
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
	 * @param mvmtDt2
	 */
	public void setMvmtDt2(String mvmtDt2) {
		this.mvmtDt2 = mvmtDt2;
	}
	
	/**
	 * Column Info
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
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
	 * @param mgstOwnrCoCd
	 */
	public void setMgstOwnrCoCd(String mgstOwnrCoCd) {
		this.mgstOwnrCoCd = mgstOwnrCoCd;
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
	 * @param gateIoCd
	 */
	public void setGateIoCd(String gateIoCd) {
		this.gateIoCd = gateIoCd;
	}
	
	/**
	 * Column Info
	 * @param cntrOwnrCoCd
	 */
	public void setCntrOwnrCoCd(String cntrOwnrCoCd) {
		this.cntrOwnrCoCd = cntrOwnrCoCd;
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
	 * @param mvmtCoCd
	 */
	public void setMvmtCoCd(String mvmtCoCd) {
		this.mvmtCoCd = mvmtCoCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtRsnCd
	 */
	public void setMvmtRsnCd(String mvmtRsnCd) {
		this.mvmtRsnCd = mvmtRsnCd;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
	}
	
	/**
	 * Column Info
	 * @param sysSeq
	 */
	public void setSysSeq(String sysSeq) {
		this.sysSeq = sysSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMvmtDt2(JSPUtil.getParameter(request, "mvmt_dt2", ""));
		setDestYdCd(JSPUtil.getParameter(request, "dest_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMgstOwnrCoCd(JSPUtil.getParameter(request, "mgst_ownr_co_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setGateIoCd(JSPUtil.getParameter(request, "gate_io_cd", ""));
		setCntrOwnrCoCd(JSPUtil.getParameter(request, "cntr_ownr_co_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMvmtCoCd(JSPUtil.getParameter(request, "mvmt_co_cd", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setMgstNo(JSPUtil.getParameter(request, "mgst_no", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setMvmtRsnCd(JSPUtil.getParameter(request, "mvmt_rsn_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setMvmtDt(JSPUtil.getParameter(request, "mvmt_dt", ""));
		setSysSeq(JSPUtil.getParameter(request, "sys_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return chassisMovementMGTVO[]
	 */
	public MGSMovementMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return chassisMovementMGTVO[]
	 */
	public MGSMovementMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSMovementMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mvmtDt2 = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt2", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mgstOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "mgst_ownr_co_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] gateIoCd = (JSPUtil.getParameter(request, prefix	+ "gate_io_cd", length));
			String[] cntrOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_ownr_co_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mvmtCoCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_co_cd", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] mvmtRsnCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_rsn_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] sysSeq = (JSPUtil.getParameter(request, prefix	+ "sys_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSMovementMGTVO();
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mvmtDt2[i] != null)
					model.setMvmtDt2(mvmtDt2[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mgstOwnrCoCd[i] != null)
					model.setMgstOwnrCoCd(mgstOwnrCoCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (gateIoCd[i] != null)
					model.setGateIoCd(gateIoCd[i]);
				if (cntrOwnrCoCd[i] != null)
					model.setCntrOwnrCoCd(cntrOwnrCoCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mvmtCoCd[i] != null)
					model.setMvmtCoCd(mvmtCoCd[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (mvmtRsnCd[i] != null)
					model.setMvmtRsnCd(mvmtRsnCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (sysSeq[i] != null)
					model.setSysSeq(sysSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getchassisMovementMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return chassisMovementMGTVO[]
	 */
	public MGSMovementMGTVO[] getchassisMovementMGTVOs(){
		MGSMovementMGTVO[] vos = (MGSMovementMGTVO[])models.toArray(new MGSMovementMGTVO[models.size()]);
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
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt2 = this.mvmtDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstOwnrCoCd = this.mgstOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateIoCd = this.gateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOwnrCoCd = this.cntrOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCoCd = this.mvmtCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRsnCd = this.mvmtRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSeq = this.sysSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
