/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmTrndLineRptMtchVO.java
*@FileTitle : FcmTrndLineRptMtchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.25
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.25 진마리아 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.fcm.trendline.trendline.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmTrndLineRptMtchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmTrndLineRptMtchVO> models = new ArrayList<FcmTrndLineRptMtchVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rptMtchSeq = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String noonRptDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trndLineInclFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trndLineSeq = null;
	/* Column Info */
	private String trndLineXcldFlg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmTrndLineRptMtchVO() {}

	public FcmTrndLineRptMtchVO(String ibflag, String pagerows, String rptMtchSeq, String trndLineSeq, String vslCd, String skdVoyNo, String skdDirCd, String noonRptDt, String trndLineInclFlg, String trndLineXcldFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.rptMtchSeq = rptMtchSeq;
		this.vslCd = vslCd;
		this.noonRptDt = noonRptDt;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.trndLineInclFlg = trndLineInclFlg;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.trndLineSeq = trndLineSeq;
		this.trndLineXcldFlg = trndLineXcldFlg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rpt_mtch_seq", getRptMtchSeq());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("noon_rpt_dt", getNoonRptDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trnd_line_incl_flg", getTrndLineInclFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trnd_line_seq", getTrndLineSeq());
		this.hashColumns.put("trnd_line_xcld_flg", getTrndLineXcldFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rpt_mtch_seq", "rptMtchSeq");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("noon_rpt_dt", "noonRptDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trnd_line_incl_flg", "trndLineInclFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trnd_line_seq", "trndLineSeq");
		this.hashFields.put("trnd_line_xcld_flg", "trndLineXcldFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return rptMtchSeq
	 */
	public String getRptMtchSeq() {
		return this.rptMtchSeq;
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
	 * @return noonRptDt
	 */
	public String getNoonRptDt() {
		return this.noonRptDt;
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
	 * Column Info
	 * @return trndLineInclFlg
	 */
	public String getTrndLineInclFlg() {
		return this.trndLineInclFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return trndLineSeq
	 */
	public String getTrndLineSeq() {
		return this.trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @return trndLineXcldFlg
	 */
	public String getTrndLineXcldFlg() {
		return this.trndLineXcldFlg;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rptMtchSeq
	 */
	public void setRptMtchSeq(String rptMtchSeq) {
		this.rptMtchSeq = rptMtchSeq;
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
	 * @param noonRptDt
	 */
	public void setNoonRptDt(String noonRptDt) {
		this.noonRptDt = noonRptDt;
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
	 * Column Info
	 * @param trndLineInclFlg
	 */
	public void setTrndLineInclFlg(String trndLineInclFlg) {
		this.trndLineInclFlg = trndLineInclFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param trndLineSeq
	 */
	public void setTrndLineSeq(String trndLineSeq) {
		this.trndLineSeq = trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @param trndLineXcldFlg
	 */
	public void setTrndLineXcldFlg(String trndLineXcldFlg) {
		this.trndLineXcldFlg = trndLineXcldFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRptMtchSeq(JSPUtil.getParameter(request, prefix + "rpt_mtch_seq", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setNoonRptDt(JSPUtil.getParameter(request, prefix + "noon_rpt_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrndLineInclFlg(JSPUtil.getParameter(request, prefix + "trnd_line_incl_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTrndLineSeq(JSPUtil.getParameter(request, prefix + "trnd_line_seq", ""));
		setTrndLineXcldFlg(JSPUtil.getParameter(request, prefix + "trnd_line_xcld_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmTrndLineRptMtchVO[]
	 */
	public FcmTrndLineRptMtchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmTrndLineRptMtchVO[]
	 */
	public FcmTrndLineRptMtchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmTrndLineRptMtchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rptMtchSeq = (JSPUtil.getParameter(request, prefix	+ "rpt_mtch_seq", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] noonRptDt = (JSPUtil.getParameter(request, prefix	+ "noon_rpt_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trndLineInclFlg = (JSPUtil.getParameter(request, prefix	+ "trnd_line_incl_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] trndLineSeq = (JSPUtil.getParameter(request, prefix	+ "trnd_line_seq", length));
			String[] trndLineXcldFlg = (JSPUtil.getParameter(request, prefix	+ "trnd_line_xcld_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmTrndLineRptMtchVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rptMtchSeq[i] != null)
					model.setRptMtchSeq(rptMtchSeq[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (noonRptDt[i] != null)
					model.setNoonRptDt(noonRptDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trndLineInclFlg[i] != null)
					model.setTrndLineInclFlg(trndLineInclFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trndLineSeq[i] != null)
					model.setTrndLineSeq(trndLineSeq[i]);
				if (trndLineXcldFlg[i] != null)
					model.setTrndLineXcldFlg(trndLineXcldFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmTrndLineRptMtchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmTrndLineRptMtchVO[]
	 */
	public FcmTrndLineRptMtchVO[] getFcmTrndLineRptMtchVOs(){
		FcmTrndLineRptMtchVO[] vos = (FcmTrndLineRptMtchVO[])models.toArray(new FcmTrndLineRptMtchVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptMtchSeq = this.rptMtchSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noonRptDt = this.noonRptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineInclFlg = this.trndLineInclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineSeq = this.trndLineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineXcldFlg = this.trndLineXcldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
