/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CanalTzFeeEstDtlByVvdVO.java
*@FileTitle : CanalTzFeeEstDtlByVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.15
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 2012.03.15 Park Yeon-Jin 
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

public class CanalTzFeeEstDtlByVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzFeeEstDtlByVvdVO> models = new ArrayList<CanalTzFeeEstDtlByVvdVO>();
	
	/* Column Info */
	private String rqstAmt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String psoBztpCd = null;
	/* Column Info */
	private String callSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String lgsCostFullNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTzFeeEstDtlByVvdVO() {}

	public CanalTzFeeEstDtlByVvdVO(String ibflag, String pagerows, String vndrSeq, String psoBztpCd, String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String callSeq, String lgsCostCd, String lgsCostFullNm, String rqstAmt, String diffRmk) {
		this.rqstAmt = rqstAmt;
		this.vslCd = vslCd;
		this.psoBztpCd = psoBztpCd;
		this.callSeq = callSeq;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.lgsCostCd = lgsCostCd;
		this.lgsCostFullNm = lgsCostFullNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_amt", getRqstAmt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pso_bztp_cd", getPsoBztpCd());
		this.hashColumns.put("call_seq", getCallSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_amt", "rqstAmt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pso_bztp_cd", "psoBztpCd");
		this.hashFields.put("call_seq", "callSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return callSeq
	 */
	public String getCallSeq() {
		return this.callSeq;
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
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param callSeq
	 */
	public void setCallSeq(String callSeq) {
		this.callSeq = callSeq;
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
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setPsoBztpCd(JSPUtil.getParameter(request, prefix + "pso_bztp_cd", ""));
		setCallSeq(JSPUtil.getParameter(request, prefix + "call_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzFeeEstDtlByVvdVO[]
	 */
	public CanalTzFeeEstDtlByVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzFeeEstDtlByVvdVO[]
	 */
	public CanalTzFeeEstDtlByVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzFeeEstDtlByVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_amt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] psoBztpCd = (JSPUtil.getParameter(request, prefix	+ "pso_bztp_cd", length));
			String[] callSeq = (JSPUtil.getParameter(request, prefix	+ "call_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzFeeEstDtlByVvdVO();
				if (rqstAmt[i] != null)
					model.setRqstAmt(rqstAmt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (psoBztpCd[i] != null)
					model.setPsoBztpCd(psoBztpCd[i]);
				if (callSeq[i] != null)
					model.setCallSeq(callSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzFeeEstDtlByVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzFeeEstDtlByVvdVO[]
	 */
	public CanalTzFeeEstDtlByVvdVO[] getCanalTzFeeEstDtlByVvdVOs(){
		CanalTzFeeEstDtlByVvdVO[] vos = (CanalTzFeeEstDtlByVvdVO[])models.toArray(new CanalTzFeeEstDtlByVvdVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoBztpCd = this.psoBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSeq = this.callSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
