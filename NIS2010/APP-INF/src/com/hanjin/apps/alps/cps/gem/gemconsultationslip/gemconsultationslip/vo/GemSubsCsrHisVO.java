/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GemSubsCsrHisVO.java
*@FileTitle : GemSubsCsrHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo;

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

public class GemSubsCsrHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemSubsCsrHisVO> models = new ArrayList<GemSubsCsrHisVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String aproUsrJbTitNm = null;
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String subsCsrNo = null;
	/* Column Info */
	private String gwAproRsltCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String gwAproUrlCtnt = null;
	/* Column Info */
	private String gwCsrRqstId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String subsCsrAproHisSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String autoMnlFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GemSubsCsrHisVO() {}

	public GemSubsCsrHisVO(String ibflag, String pagerows, String subsCsrAproHisSeq, String subsCsrNo, String autoMnlFlg, String ioBndCd, String gwCsrRqstId, String gwAproUrlCtnt, String gwAproRsltCd, String aproUsrId, String aproUsrNm, String aproUsrJbTitNm, String aproRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.aproUsrJbTitNm = aproUsrJbTitNm;
		this.aproRmk = aproRmk;
		this.subsCsrNo = subsCsrNo;
		this.gwAproRsltCd = gwAproRsltCd;
		this.creDt = creDt;
		this.aproUsrNm = aproUsrNm;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.gwAproUrlCtnt = gwAproUrlCtnt;
		this.gwCsrRqstId = gwCsrRqstId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.aproUsrId = aproUsrId;
		this.subsCsrAproHisSeq = subsCsrAproHisSeq;
		this.updUsrId = updUsrId;
		this.autoMnlFlg = autoMnlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("apro_usr_jb_tit_nm", getAproUsrJbTitNm());
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("subs_csr_no", getSubsCsrNo());
		this.hashColumns.put("gw_apro_rslt_cd", getGwAproRsltCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gw_apro_url_ctnt", getGwAproUrlCtnt());
		this.hashColumns.put("gw_csr_rqst_id", getGwCsrRqstId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("subs_csr_apro_his_seq", getSubsCsrAproHisSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("auto_mnl_flg", getAutoMnlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("apro_usr_jb_tit_nm", "aproUsrJbTitNm");
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("subs_csr_no", "subsCsrNo");
		this.hashFields.put("gw_apro_rslt_cd", "gwAproRsltCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gw_apro_url_ctnt", "gwAproUrlCtnt");
		this.hashFields.put("gw_csr_rqst_id", "gwCsrRqstId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("subs_csr_apro_his_seq", "subsCsrAproHisSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("auto_mnl_flg", "autoMnlFlg");
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
	 * @return aproUsrJbTitNm
	 */
	public String getAproUsrJbTitNm() {
		return this.aproUsrJbTitNm;
	}
	
	/**
	 * Column Info
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}
	
	/**
	 * Column Info
	 * @return subsCsrNo
	 */
	public String getSubsCsrNo() {
		return this.subsCsrNo;
	}
	
	/**
	 * Column Info
	 * @return gwAproRsltCd
	 */
	public String getGwAproRsltCd() {
		return this.gwAproRsltCd;
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
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return gwAproUrlCtnt
	 */
	public String getGwAproUrlCtnt() {
		return this.gwAproUrlCtnt;
	}
	
	/**
	 * Column Info
	 * @return gwCsrRqstId
	 */
	public String getGwCsrRqstId() {
		return this.gwCsrRqstId;
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
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return subsCsrAproHisSeq
	 */
	public String getSubsCsrAproHisSeq() {
		return this.subsCsrAproHisSeq;
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
	 * @return autoMnlFlg
	 */
	public String getAutoMnlFlg() {
		return this.autoMnlFlg;
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
	 * @param aproUsrJbTitNm
	 */
	public void setAproUsrJbTitNm(String aproUsrJbTitNm) {
		this.aproUsrJbTitNm = aproUsrJbTitNm;
	}
	
	/**
	 * Column Info
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
	}
	
	/**
	 * Column Info
	 * @param subsCsrNo
	 */
	public void setSubsCsrNo(String subsCsrNo) {
		this.subsCsrNo = subsCsrNo;
	}
	
	/**
	 * Column Info
	 * @param gwAproRsltCd
	 */
	public void setGwAproRsltCd(String gwAproRsltCd) {
		this.gwAproRsltCd = gwAproRsltCd;
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
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param gwAproUrlCtnt
	 */
	public void setGwAproUrlCtnt(String gwAproUrlCtnt) {
		this.gwAproUrlCtnt = gwAproUrlCtnt;
	}
	
	/**
	 * Column Info
	 * @param gwCsrRqstId
	 */
	public void setGwCsrRqstId(String gwCsrRqstId) {
		this.gwCsrRqstId = gwCsrRqstId;
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
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param subsCsrAproHisSeq
	 */
	public void setSubsCsrAproHisSeq(String subsCsrAproHisSeq) {
		this.subsCsrAproHisSeq = subsCsrAproHisSeq;
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
	 * @param autoMnlFlg
	 */
	public void setAutoMnlFlg(String autoMnlFlg) {
		this.autoMnlFlg = autoMnlFlg;
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
		setAproUsrJbTitNm(JSPUtil.getParameter(request, prefix + "apro_usr_jb_tit_nm", ""));
		setAproRmk(JSPUtil.getParameter(request, prefix + "apro_rmk", ""));
		setSubsCsrNo(JSPUtil.getParameter(request, prefix + "subs_csr_no", ""));
		setGwAproRsltCd(JSPUtil.getParameter(request, prefix + "gw_apro_rslt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGwAproUrlCtnt(JSPUtil.getParameter(request, prefix + "gw_apro_url_ctnt", ""));
		setGwCsrRqstId(JSPUtil.getParameter(request, prefix + "gw_csr_rqst_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setSubsCsrAproHisSeq(JSPUtil.getParameter(request, prefix + "subs_csr_apro_his_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAutoMnlFlg(JSPUtil.getParameter(request, prefix + "auto_mnl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemSubsCsrHisVO[]
	 */
	public GemSubsCsrHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemSubsCsrHisVO[]
	 */
	public GemSubsCsrHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemSubsCsrHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] aproUsrJbTitNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_jb_tit_nm", length));
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] subsCsrNo = (JSPUtil.getParameter(request, prefix	+ "subs_csr_no", length));
			String[] gwAproRsltCd = (JSPUtil.getParameter(request, prefix	+ "gw_apro_rslt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] gwAproUrlCtnt = (JSPUtil.getParameter(request, prefix	+ "gw_apro_url_ctnt", length));
			String[] gwCsrRqstId = (JSPUtil.getParameter(request, prefix	+ "gw_csr_rqst_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] subsCsrAproHisSeq = (JSPUtil.getParameter(request, prefix	+ "subs_csr_apro_his_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] autoMnlFlg = (JSPUtil.getParameter(request, prefix	+ "auto_mnl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemSubsCsrHisVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (aproUsrJbTitNm[i] != null)
					model.setAproUsrJbTitNm(aproUsrJbTitNm[i]);
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (subsCsrNo[i] != null)
					model.setSubsCsrNo(subsCsrNo[i]);
				if (gwAproRsltCd[i] != null)
					model.setGwAproRsltCd(gwAproRsltCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (gwAproUrlCtnt[i] != null)
					model.setGwAproUrlCtnt(gwAproUrlCtnt[i]);
				if (gwCsrRqstId[i] != null)
					model.setGwCsrRqstId(gwCsrRqstId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (subsCsrAproHisSeq[i] != null)
					model.setSubsCsrAproHisSeq(subsCsrAproHisSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (autoMnlFlg[i] != null)
					model.setAutoMnlFlg(autoMnlFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemSubsCsrHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemSubsCsrHisVO[]
	 */
	public GemSubsCsrHisVO[] getGemSubsCsrHisVOs(){
		GemSubsCsrHisVO[] vos = (GemSubsCsrHisVO[])models.toArray(new GemSubsCsrHisVO[models.size()]);
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
		this.aproUsrJbTitNm = this.aproUsrJbTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCsrNo = this.subsCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwAproRsltCd = this.gwAproRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwAproUrlCtnt = this.gwAproUrlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwCsrRqstId = this.gwCsrRqstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCsrAproHisSeq = this.subsCsrAproHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoMnlFlg = this.autoMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
