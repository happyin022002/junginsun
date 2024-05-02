/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PkupNtcHrVO.java
*@FileTitle : PkupNtcHrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.10.15 박미옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PkupNtcHrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNtcHrVO> models = new ArrayList<PkupNtcHrVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String pkupNtcFomCd = null;
	/* Column Info */
	private String ntcBseHrs = null;
	/* Column Info */
	private String pkupNtcSndTpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pkupNtcSeq = null;
	/* Column Info */
	private String ntcSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ntcCondCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupNtcHrVO() {}

	public PkupNtcHrVO(String ibflag, String pagerows, String pkupNtcSndTpCd, String ofcCd, String delCd, String pkupNtcSeq, String pkupNtcFomCd, String ntcSeq, String ntcBseHrs, String ntcCondCd, String mvmtStsCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.pkupNtcFomCd = pkupNtcFomCd;
		this.ntcBseHrs = ntcBseHrs;
		this.pkupNtcSndTpCd = pkupNtcSndTpCd;
		this.delCd = delCd;
		this.creDt = creDt;
		this.pkupNtcSeq = pkupNtcSeq;
		this.ntcSeq = ntcSeq;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.mvmtStsCd = mvmtStsCd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.ntcCondCd = ntcCondCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pkup_ntc_fom_cd", getPkupNtcFomCd());
		this.hashColumns.put("ntc_bse_hrs", getNtcBseHrs());
		this.hashColumns.put("pkup_ntc_snd_tp_cd", getPkupNtcSndTpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pkup_ntc_seq", getPkupNtcSeq());
		this.hashColumns.put("ntc_seq", getNtcSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ntc_cond_cd", getNtcCondCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pkup_ntc_fom_cd", "pkupNtcFomCd");
		this.hashFields.put("ntc_bse_hrs", "ntcBseHrs");
		this.hashFields.put("pkup_ntc_snd_tp_cd", "pkupNtcSndTpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pkup_ntc_seq", "pkupNtcSeq");
		this.hashFields.put("ntc_seq", "ntcSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ntc_cond_cd", "ntcCondCd");
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
	 * @return pkupNtcFomCd
	 */
	public String getPkupNtcFomCd() {
		return this.pkupNtcFomCd;
	}
	
	/**
	 * Column Info
	 * @return ntcBseHrs
	 */
	public String getNtcBseHrs() {
		return this.ntcBseHrs;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcSndTpCd
	 */
	public String getPkupNtcSndTpCd() {
		return this.pkupNtcSndTpCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcSeq
	 */
	public String getPkupNtcSeq() {
		return this.pkupNtcSeq;
	}
	
	/**
	 * Column Info
	 * @return ntcSeq
	 */
	public String getNtcSeq() {
		return this.ntcSeq;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return ntcCondCd
	 */
	public String getNtcCondCd() {
		return this.ntcCondCd;
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
	 * @param pkupNtcFomCd
	 */
	public void setPkupNtcFomCd(String pkupNtcFomCd) {
		this.pkupNtcFomCd = pkupNtcFomCd;
	}
	
	/**
	 * Column Info
	 * @param ntcBseHrs
	 */
	public void setNtcBseHrs(String ntcBseHrs) {
		this.ntcBseHrs = ntcBseHrs;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcSndTpCd
	 */
	public void setPkupNtcSndTpCd(String pkupNtcSndTpCd) {
		this.pkupNtcSndTpCd = pkupNtcSndTpCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcSeq
	 */
	public void setPkupNtcSeq(String pkupNtcSeq) {
		this.pkupNtcSeq = pkupNtcSeq;
	}
	
	/**
	 * Column Info
	 * @param ntcSeq
	 */
	public void setNtcSeq(String ntcSeq) {
		this.ntcSeq = ntcSeq;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ntcCondCd
	 */
	public void setNtcCondCd(String ntcCondCd) {
		this.ntcCondCd = ntcCondCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPkupNtcFomCd(JSPUtil.getParameter(request, "pkup_ntc_fom_cd", ""));
		setNtcBseHrs(JSPUtil.getParameter(request, "ntc_bse_hrs", ""));
		setPkupNtcSndTpCd(JSPUtil.getParameter(request, "pkup_ntc_snd_tp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPkupNtcSeq(JSPUtil.getParameter(request, "pkup_ntc_seq", ""));
		setNtcSeq(JSPUtil.getParameter(request, "ntc_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setNtcCondCd(JSPUtil.getParameter(request, "ntc_cond_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNtcHrVO[]
	 */
	public PkupNtcHrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNtcHrVO[]
	 */
	public PkupNtcHrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNtcHrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] pkupNtcFomCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_fom_cd", length));
			String[] ntcBseHrs = (JSPUtil.getParameter(request, prefix	+ "ntc_bse_hrs", length));
			String[] pkupNtcSndTpCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_snd_tp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pkupNtcSeq = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_seq", length));
			String[] ntcSeq = (JSPUtil.getParameter(request, prefix	+ "ntc_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ntcCondCd = (JSPUtil.getParameter(request, prefix	+ "ntc_cond_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNtcHrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pkupNtcFomCd[i] != null)
					model.setPkupNtcFomCd(pkupNtcFomCd[i]);
				if (ntcBseHrs[i] != null)
					model.setNtcBseHrs(ntcBseHrs[i]);
				if (pkupNtcSndTpCd[i] != null)
					model.setPkupNtcSndTpCd(pkupNtcSndTpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pkupNtcSeq[i] != null)
					model.setPkupNtcSeq(pkupNtcSeq[i]);
				if (ntcSeq[i] != null)
					model.setNtcSeq(ntcSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ntcCondCd[i] != null)
					model.setNtcCondCd(ntcCondCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNtcHrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNtcHrVO[]
	 */
	public PkupNtcHrVO[] getPkupNtcHrVOs(){
		PkupNtcHrVO[] vos = (PkupNtcHrVO[])models.toArray(new PkupNtcHrVO[models.size()]);
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
		this.pkupNtcFomCd = this.pkupNtcFomCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcBseHrs = this.ntcBseHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcSndTpCd = this.pkupNtcSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcSeq = this.pkupNtcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSeq = this.ntcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcCondCd = this.ntcCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
