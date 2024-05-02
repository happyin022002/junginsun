/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpeEGCreVO.java
*@FileTitle : SpeEGCreVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.26 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpeEGCreVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpeEGCreVO> models = new ArrayList<SpeEGCreVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String isflag = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String evSvcCateCode = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String gEvSvcCateCd = null;
	/* Column Info */
	private String gEgRhqCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* Column Info */
	private String egNm = null;
	/* Column Info */
	private String sSpCateCd = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String egOfcCd = null;
	/* Column Info */
	private String evSvcCateCd = null;
	/* Column Info */
	private String gEgOfcCd = null;
	/* Column Info */
	private String sEvSvcCateCd = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpeEGCreVO() {}

	public SpeEGCreVO(String ibflag, String pagerows, String sEgRhqCd, String sEgOfcCd, String sSpCateCd, String sEvSvcCateCd, String egId, String egRhqCd, String egOfcCd, String evSvcCateCd, String evSvcCateCode, String egNm, String ctrtOfcCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String isflag, String gEgRhqCd, String gEgOfcCd, String gEvSvcCateCd) {
		this.updDt = updDt;
		this.isflag = isflag;
		this.deltFlg = deltFlg;
		this.egRhqCd = egRhqCd;
		this.evSvcCateCode = evSvcCateCode;
		this.creDt = creDt;
		this.gEvSvcCateCd = gEvSvcCateCd;
		this.gEgRhqCd = gEgRhqCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.sEgOfcCd = sEgOfcCd;
		this.egNm = egNm;
		this.sSpCateCd = sSpCateCd;
		this.sEgRhqCd = sEgRhqCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.egOfcCd = egOfcCd;
		this.evSvcCateCd = evSvcCateCd;
		this.gEgOfcCd = gEgOfcCd;
		this.sEvSvcCateCd = sEvSvcCateCd;
		this.egId = egId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("isflag", getIsflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("ev_svc_cate_code", getEvSvcCateCode());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("g_ev_svc_cate_cd", getGEvSvcCateCd());
		this.hashColumns.put("g_eg_rhq_cd", getGEgRhqCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("s_sp_cate_cd", getSSpCateCd());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("eg_ofc_cd", getEgOfcCd());
		this.hashColumns.put("ev_svc_cate_cd", getEvSvcCateCd());
		this.hashColumns.put("g_eg_ofc_cd", getGEgOfcCd());
		this.hashColumns.put("s_ev_svc_cate_cd", getSEvSvcCateCd());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("isflag", "isflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("ev_svc_cate_code", "evSvcCateCode");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("g_ev_svc_cate_cd", "gEvSvcCateCd");
		this.hashFields.put("g_eg_rhq_cd", "gEgRhqCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("s_sp_cate_cd", "sSpCateCd");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("eg_ofc_cd", "egOfcCd");
		this.hashFields.put("ev_svc_cate_cd", "evSvcCateCd");
		this.hashFields.put("g_eg_ofc_cd", "gEgOfcCd");
		this.hashFields.put("s_ev_svc_cate_cd", "sEvSvcCateCd");
		this.hashFields.put("eg_id", "egId");
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
	 * @return isflag
	 */
	public String getIsflag() {
		return this.isflag;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return egRhqCd
	 */
	public String getEgRhqCd() {
		return this.egRhqCd;
	}
	
	/**
	 * Column Info
	 * @return evSvcCateCode
	 */
	public String getEvSvcCateCode() {
		return this.evSvcCateCode;
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
	 * @return gEvSvcCateCd
	 */
	public String getGEvSvcCateCd() {
		return this.gEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return gEgRhqCd
	 */
	public String getGEgRhqCd() {
		return this.gEgRhqCd;
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
	 * @return sEgOfcCd
	 */
	public String getSEgOfcCd() {
		return this.sEgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return egNm
	 */
	public String getEgNm() {
		return this.egNm;
	}
	
	/**
	 * Column Info
	 * @return sSpCateCd
	 */
	public String getSSpCateCd() {
		return this.sSpCateCd;
	}
	
	/**
	 * Column Info
	 * @return sEgRhqCd
	 */
	public String getSEgRhqCd() {
		return this.sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return egOfcCd
	 */
	public String getEgOfcCd() {
		return this.egOfcCd;
	}
	
	/**
	 * Column Info
	 * @return evSvcCateCd
	 */
	public String getEvSvcCateCd() {
		return this.evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return gEgOfcCd
	 */
	public String getGEgOfcCd() {
		return this.gEgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sEvSvcCateCd
	 */
	public String getSEvSvcCateCd() {
		return this.sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return egId
	 */
	public String getEgId() {
		return this.egId;
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
	 * @param isflag
	 */
	public void setIsflag(String isflag) {
		this.isflag = isflag;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param egRhqCd
	 */
	public void setEgRhqCd(String egRhqCd) {
		this.egRhqCd = egRhqCd;
	}
	
	/**
	 * Column Info
	 * @param evSvcCateCode
	 */
	public void setEvSvcCateCode(String evSvcCateCode) {
		this.evSvcCateCode = evSvcCateCode;
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
	 * @param gEvSvcCateCd
	 */
	public void setGEvSvcCateCd(String gEvSvcCateCd) {
		this.gEvSvcCateCd = gEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param gEgRhqCd
	 */
	public void setGEgRhqCd(String gEgRhqCd) {
		this.gEgRhqCd = gEgRhqCd;
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
	 * @param sEgOfcCd
	 */
	public void setSEgOfcCd(String sEgOfcCd) {
		this.sEgOfcCd = sEgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param egNm
	 */
	public void setEgNm(String egNm) {
		this.egNm = egNm;
	}
	
	/**
	 * Column Info
	 * @param sSpCateCd
	 */
	public void setSSpCateCd(String sSpCateCd) {
		this.sSpCateCd = sSpCateCd;
	}
	
	/**
	 * Column Info
	 * @param sEgRhqCd
	 */
	public void setSEgRhqCd(String sEgRhqCd) {
		this.sEgRhqCd = sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param egOfcCd
	 */
	public void setEgOfcCd(String egOfcCd) {
		this.egOfcCd = egOfcCd;
	}
	
	/**
	 * Column Info
	 * @param evSvcCateCd
	 */
	public void setEvSvcCateCd(String evSvcCateCd) {
		this.evSvcCateCd = evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param gEgOfcCd
	 */
	public void setGEgOfcCd(String gEgOfcCd) {
		this.gEgOfcCd = gEgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sEvSvcCateCd
	 */
	public void setSEvSvcCateCd(String sEvSvcCateCd) {
		this.sEvSvcCateCd = sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param egId
	 */
	public void setEgId(String egId) {
		this.egId = egId;
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
		setIsflag(JSPUtil.getParameter(request, prefix + "isflag", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEgRhqCd(JSPUtil.getParameter(request, prefix + "eg_rhq_cd", ""));
		setEvSvcCateCode(JSPUtil.getParameter(request, prefix + "ev_svc_cate_code", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setGEvSvcCateCd(JSPUtil.getParameter(request, prefix + "g_ev_svc_cate_cd", ""));
		setGEgRhqCd(JSPUtil.getParameter(request, prefix + "g_eg_rhq_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setSSpCateCd(JSPUtil.getParameter(request, prefix + "s_sp_cate_cd", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setEgOfcCd(JSPUtil.getParameter(request, prefix + "eg_ofc_cd", ""));
		setEvSvcCateCd(JSPUtil.getParameter(request, prefix + "ev_svc_cate_cd", ""));
		setGEgOfcCd(JSPUtil.getParameter(request, prefix + "g_eg_ofc_cd", ""));
		setSEvSvcCateCd(JSPUtil.getParameter(request, prefix + "s_ev_svc_cate_cd", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpeEGCreVO[]
	 */
	public SpeEGCreVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpeEGCreVO[]
	 */
	public SpeEGCreVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpeEGCreVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] isflag = (JSPUtil.getParameter(request, prefix	+ "isflag", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] evSvcCateCode = (JSPUtil.getParameter(request, prefix	+ "ev_svc_cate_code", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] gEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "g_ev_svc_cate_cd", length));
			String[] gEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "g_eg_rhq_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] sSpCateCd = (JSPUtil.getParameter(request, prefix	+ "s_sp_cate_cd", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] egOfcCd = (JSPUtil.getParameter(request, prefix	+ "eg_ofc_cd", length));
			String[] evSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "ev_svc_cate_cd", length));
			String[] gEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "g_eg_ofc_cd", length));
			String[] sEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "s_ev_svc_cate_cd", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpeEGCreVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (isflag[i] != null)
					model.setIsflag(isflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (evSvcCateCode[i] != null)
					model.setEvSvcCateCode(evSvcCateCode[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (gEvSvcCateCd[i] != null)
					model.setGEvSvcCateCd(gEvSvcCateCd[i]);
				if (gEgRhqCd[i] != null)
					model.setGEgRhqCd(gEgRhqCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (sSpCateCd[i] != null)
					model.setSSpCateCd(sSpCateCd[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (egOfcCd[i] != null)
					model.setEgOfcCd(egOfcCd[i]);
				if (evSvcCateCd[i] != null)
					model.setEvSvcCateCd(evSvcCateCd[i]);
				if (gEgOfcCd[i] != null)
					model.setGEgOfcCd(gEgOfcCd[i]);
				if (sEvSvcCateCd[i] != null)
					model.setSEvSvcCateCd(sEvSvcCateCd[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpeEGCreVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpeEGCreVO[]
	 */
	public SpeEGCreVO[] getSpeEGCreVOs(){
		SpeEGCreVO[] vos = (SpeEGCreVO[])models.toArray(new SpeEGCreVO[models.size()]);
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
		this.isflag = this.isflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evSvcCateCode = this.evSvcCateCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gEvSvcCateCd = this.gEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gEgRhqCd = this.gEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSpCateCd = this.sSpCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egOfcCd = this.egOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evSvcCateCd = this.evSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gEgOfcCd = this.gEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvSvcCateCd = this.sEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
