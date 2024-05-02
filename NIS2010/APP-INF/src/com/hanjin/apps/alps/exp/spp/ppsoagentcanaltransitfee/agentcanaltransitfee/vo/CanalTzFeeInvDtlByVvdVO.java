/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CanalTzFeeInvDtlByVvdVO.java
*@FileTitle : CanalTzFeeInvDtlByVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.13
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 2012.03.13 Park Yeon-Jin 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo;

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
 * @author Park Yeon-Jin
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTzFeeInvDtlByVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzFeeInvDtlByVvdVO> models = new ArrayList<CanalTzFeeInvDtlByVvdVO>();
	
	/* Column Info */
	private String rqstAmt = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fileUpldNm = null;
	/* Column Info */
	private String aseq = null;
	/* Column Info */
	private String psoBztpCd = null;
	/* Column Info */
	private String sq = null;
	/* Column Info */
	private String callSeq = null;
	/* Column Info */
	private String lgsCostCdClssLvl = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String level = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String dseq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String creditsAmt = null;
	/* Column Info */
	private String lgsCostFullNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTzFeeInvDtlByVvdVO() {}

	public CanalTzFeeInvDtlByVvdVO(String ibflag, String pagerows, String vndrSeq, String psoBztpCd, String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String callSeq, String lgsCostCd, String lgsCostFullNm, String creditsAmt, String rqstAmt, String diffRmk, String sq, String aseq, String dseq, String level, String lgsCostCdClssLvl, String fileSavId, String fileUpldNm) {
		this.rqstAmt = rqstAmt;
		this.fileSavId = fileSavId;
		this.vslCd = vslCd;
		this.fileUpldNm = fileUpldNm;
		this.aseq = aseq;
		this.psoBztpCd = psoBztpCd;
		this.sq = sq;
		this.callSeq = callSeq;
		this.lgsCostCdClssLvl = lgsCostCdClssLvl;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.level = level;
		this.diffRmk = diffRmk;
		this.dseq = dseq;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.lgsCostCd = lgsCostCd;
		this.creditsAmt = creditsAmt;
		this.lgsCostFullNm = lgsCostFullNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_amt", getRqstAmt());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("file_upld_nm", getFileUpldNm());
		this.hashColumns.put("aseq", getAseq());
		this.hashColumns.put("pso_bztp_cd", getPsoBztpCd());
		this.hashColumns.put("sq", getSq());
		this.hashColumns.put("call_seq", getCallSeq());
		this.hashColumns.put("lgs_cost_cd_clss_lvl", getLgsCostCdClssLvl());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("level", getLevel());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("dseq", getDseq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("credits_amt", getCreditsAmt());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_amt", "rqstAmt");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("file_upld_nm", "fileUpldNm");
		this.hashFields.put("aseq", "aseq");
		this.hashFields.put("pso_bztp_cd", "psoBztpCd");
		this.hashFields.put("sq", "sq");
		this.hashFields.put("call_seq", "callSeq");
		this.hashFields.put("lgs_cost_cd_clss_lvl", "lgsCostCdClssLvl");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("level", "level");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("dseq", "dseq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("credits_amt", "creditsAmt");
		this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstAmt
	 */
	public String getRqstAmt() {
		return this.rqstAmt;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
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
	 * @return fileUpldNm
	 */
	public String getFileUpldNm() {
		return this.fileUpldNm;
	}
	
	/**
	 * Column Info
	 * @return aseq
	 */
	public String getAseq() {
		return this.aseq;
	}
	
	/**
	 * Column Info
	 * @return psoBztpCd
	 */
	public String getPsoBztpCd() {
		return this.psoBztpCd;
	}
	
	/**
	 * Column Info
	 * @return sq
	 */
	public String getSq() {
		return this.sq;
	}
	
	/**
	 * Column Info
	 * @return callSeq
	 */
	public String getCallSeq() {
		return this.callSeq;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCdClssLvl
	 */
	public String getLgsCostCdClssLvl() {
		return this.lgsCostCdClssLvl;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return level
	 */
	public String getLevel() {
		return this.level;
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
	 * @return dseq
	 */
	public String getDseq() {
		return this.dseq;
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
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return creditsAmt
	 */
	public String getCreditsAmt() {
		return this.creditsAmt;
	}
	
	/**
	 * Column Info
	 * @return lgsCostFullNm
	 */
	public String getLgsCostFullNm() {
		return this.lgsCostFullNm;
	}
	

	/**
	 * Column Info
	 * @param rqstAmt
	 */
	public void setRqstAmt(String rqstAmt) {
		this.rqstAmt = rqstAmt;
	}
	
	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
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
	 * @param fileUpldNm
	 */
	public void setFileUpldNm(String fileUpldNm) {
		this.fileUpldNm = fileUpldNm;
	}
	
	/**
	 * Column Info
	 * @param aseq
	 */
	public void setAseq(String aseq) {
		this.aseq = aseq;
	}
	
	/**
	 * Column Info
	 * @param psoBztpCd
	 */
	public void setPsoBztpCd(String psoBztpCd) {
		this.psoBztpCd = psoBztpCd;
	}
	
	/**
	 * Column Info
	 * @param sq
	 */
	public void setSq(String sq) {
		this.sq = sq;
	}
	
	/**
	 * Column Info
	 * @param callSeq
	 */
	public void setCallSeq(String callSeq) {
		this.callSeq = callSeq;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCdClssLvl
	 */
	public void setLgsCostCdClssLvl(String lgsCostCdClssLvl) {
		this.lgsCostCdClssLvl = lgsCostCdClssLvl;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
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
	 * @param dseq
	 */
	public void setDseq(String dseq) {
		this.dseq = dseq;
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
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param creditsAmt
	 */
	public void setCreditsAmt(String creditsAmt) {
		this.creditsAmt = creditsAmt;
	}
	
	/**
	 * Column Info
	 * @param lgsCostFullNm
	 */
	public void setLgsCostFullNm(String lgsCostFullNm) {
		this.lgsCostFullNm = lgsCostFullNm;
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
		setRqstAmt(JSPUtil.getParameter(request, prefix + "rqst_amt", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setFileUpldNm(JSPUtil.getParameter(request, prefix + "file_upld_nm", ""));
		setAseq(JSPUtil.getParameter(request, prefix + "aseq", ""));
		setPsoBztpCd(JSPUtil.getParameter(request, prefix + "pso_bztp_cd", ""));
		setSq(JSPUtil.getParameter(request, prefix + "sq", ""));
		setCallSeq(JSPUtil.getParameter(request, prefix + "call_seq", ""));
		setLgsCostCdClssLvl(JSPUtil.getParameter(request, prefix + "lgs_cost_cd_clss_lvl", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLevel(JSPUtil.getParameter(request, prefix + "level", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setDseq(JSPUtil.getParameter(request, prefix + "dseq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setCreditsAmt(JSPUtil.getParameter(request, prefix + "credits_amt", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzFeeInvDtlByVvdVO[]
	 */
	public CanalTzFeeInvDtlByVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzFeeInvDtlByVvdVO[]
	 */
	public CanalTzFeeInvDtlByVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzFeeInvDtlByVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_amt", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fileUpldNm = (JSPUtil.getParameter(request, prefix	+ "file_upld_nm", length));
			String[] aseq = (JSPUtil.getParameter(request, prefix	+ "aseq", length));
			String[] psoBztpCd = (JSPUtil.getParameter(request, prefix	+ "pso_bztp_cd", length));
			String[] sq = (JSPUtil.getParameter(request, prefix	+ "sq", length));
			String[] callSeq = (JSPUtil.getParameter(request, prefix	+ "call_seq", length));
			String[] lgsCostCdClssLvl = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd_clss_lvl", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] dseq = (JSPUtil.getParameter(request, prefix	+ "dseq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] creditsAmt = (JSPUtil.getParameter(request, prefix	+ "credits_amt", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzFeeInvDtlByVvdVO();
				if (rqstAmt[i] != null)
					model.setRqstAmt(rqstAmt[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fileUpldNm[i] != null)
					model.setFileUpldNm(fileUpldNm[i]);
				if (aseq[i] != null)
					model.setAseq(aseq[i]);
				if (psoBztpCd[i] != null)
					model.setPsoBztpCd(psoBztpCd[i]);
				if (sq[i] != null)
					model.setSq(sq[i]);
				if (callSeq[i] != null)
					model.setCallSeq(callSeq[i]);
				if (lgsCostCdClssLvl[i] != null)
					model.setLgsCostCdClssLvl(lgsCostCdClssLvl[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (level[i] != null)
					model.setLevel(level[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (dseq[i] != null)
					model.setDseq(dseq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (creditsAmt[i] != null)
					model.setCreditsAmt(creditsAmt[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzFeeInvDtlByVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzFeeInvDtlByVvdVO[]
	 */
	public CanalTzFeeInvDtlByVvdVO[] getCanalTzFeeInvDtlByVvdVOs(){
		CanalTzFeeInvDtlByVvdVO[] vos = (CanalTzFeeInvDtlByVvdVO[])models.toArray(new CanalTzFeeInvDtlByVvdVO[models.size()]);
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
		this.rqstAmt = this.rqstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileUpldNm = this.fileUpldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aseq = this.aseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoBztpCd = this.psoBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sq = this.sq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSeq = this.callSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCdClssLvl = this.lgsCostCdClssLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dseq = this.dseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creditsAmt = this.creditsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
