/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SalesRepVO.java
*@FileTitle : SalesRepVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.28  
* 1.0 Creation
=========================================================*/
 
package com.clt.apps.opus.bcm.ccd.commoncode.salesrepresentative.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SalesRepVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SalesRepVO> models = new ArrayList<SalesRepVO>();
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String empeCd = null;
	/* Column Info */
	private String ibSrepFlg = null;
	/* Column Info */
	private String sexCd = null;
	/* Column Info */
	private String srepEml = null;
	/* Column Info */
	private String mphnNo = null;
	/* Column Info */
	private String obSrepFlg = null;
	/* Column Info */
	private String intlMphnNo = null;
	/* Column Info */
	private String srepAbbrNm = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcTeamCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String modiSrepCd = null;
	private String creUsrId = null;
	private String creDt = null;
	private String updUsrId = null;
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SalesRepVO() {}

	public SalesRepVO(String ibflag, String pagerows, String cntCd, String ofcCd, String srepNm, String ofcTeamCd, String sexCd, String srepAbbrNm, String ibSrepFlg, String obSrepFlg, String srepCd, String empeCd, String srepEml, String intlMphnNo, String deltFlg, String mphnNo, String userId, String rqstNo, String modiSrepCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.deltFlg = deltFlg;
		this.empeCd = empeCd;
		this.ibSrepFlg = ibSrepFlg;
		this.sexCd = sexCd;
		this.srepEml = srepEml;
		this.mphnNo = mphnNo;
		this.obSrepFlg = obSrepFlg;
		this.intlMphnNo = intlMphnNo;
		this.srepAbbrNm = srepAbbrNm;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.ofcTeamCd = ofcTeamCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.srepNm = srepNm;
		this.userId = userId;
		this.cntCd = cntCd;
		this.rqstNo = rqstNo;
		this.modiSrepCd = modiSrepCd;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("empe_cd", getEmpeCd());
		this.hashColumns.put("ib_srep_flg", getIbSrepFlg());
		this.hashColumns.put("sex_cd", getSexCd());
		this.hashColumns.put("srep_eml", getSrepEml());
		this.hashColumns.put("mphn_no", getMphnNo());
		this.hashColumns.put("ob_srep_flg", getObSrepFlg());
		this.hashColumns.put("intl_mphn_no", getIntlMphnNo());
		this.hashColumns.put("srep_abbr_nm", getSrepAbbrNm());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_team_cd", getOfcTeamCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("modi_srep_cd", getModiSrepCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("empe_cd", "empeCd");
		this.hashFields.put("ib_srep_flg", "ibSrepFlg");
		this.hashFields.put("sex_cd", "sexCd");
		this.hashFields.put("srep_eml", "srepEml");
		this.hashFields.put("mphn_no", "mphnNo");
		this.hashFields.put("ob_srep_flg", "obSrepFlg");
		this.hashFields.put("intl_mphn_no", "intlMphnNo");
		this.hashFields.put("srep_abbr_nm", "srepAbbrNm");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_team_cd", "ofcTeamCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("rqst_no", "rqst_no");
		this.hashFields.put("modi_srep_cd", "modiSrepCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
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
	 * @return empeCd
	 */
	public String getEmpeCd() {
		return this.empeCd;
	}
	
	/**
	 * Column Info
	 * @return ibSrepFlg
	 */
	public String getIbSrepFlg() {
		return this.ibSrepFlg;
	}
	
	/**
	 * Column Info
	 * @return sexCd
	 */
	public String getSexCd() {
		return this.sexCd;
	}
	
	/**
	 * Column Info
	 * @return srepEml
	 */
	public String getSrepEml() {
		return this.srepEml;
	}
	
	/**
	 * Column Info
	 * @return mphnNo
	 */
	public String getMphnNo() {
		return this.mphnNo;
	}
	
	/**
	 * Column Info
	 * @return obSrepFlg
	 */
	public String getObSrepFlg() {
		return this.obSrepFlg;
	}
	
	/**
	 * Column Info
	 * @return intlMphnNo
	 */
	public String getIntlMphnNo() {
		return this.intlMphnNo;
	}
	
	/**
	 * Column Info
	 * @return srepAbbrNm
	 */
	public String getSrepAbbrNm() {
		return this.srepAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return ofcTeamCd
	 */
	public String getOfcTeamCd() {
		return this.ofcTeamCd;
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
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Request Number
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}

	/**
	 * Column Info
	 * @return modiSrepCd
	 */
	public String getModiSrepCd() {
		return this.modiSrepCd;
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
	 * @param empeCd
	 */
	public void setEmpeCd(String empeCd) {
		this.empeCd = empeCd;
	}
	
	/**
	 * Column Info
	 * @param ibSrepFlg
	 */
	public void setIbSrepFlg(String ibSrepFlg) {
		this.ibSrepFlg = ibSrepFlg;
	}
	
	/**
	 * Column Info
	 * @param sexCd
	 */
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	
	/**
	 * Column Info
	 * @param srepEml
	 */
	public void setSrepEml(String srepEml) {
		this.srepEml = srepEml;
	}
	
	/**
	 * Column Info
	 * @param mphnNo
	 */
	public void setMphnNo(String mphnNo) {
		this.mphnNo = mphnNo;
	}
	
	/**
	 * Column Info
	 * @param obSrepFlg
	 */
	public void setObSrepFlg(String obSrepFlg) {
		this.obSrepFlg = obSrepFlg;
	}
	
	/**
	 * Column Info
	 * @param intlMphnNo
	 */
	public void setIntlMphnNo(String intlMphnNo) {
		this.intlMphnNo = intlMphnNo;
	}
	
	/**
	 * Column Info
	 * @param srepAbbrNm
	 */
	public void setSrepAbbrNm(String srepAbbrNm) {
		this.srepAbbrNm = srepAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param ofcTeamCd
	 */
	public void setOfcTeamCd(String ofcTeamCd) {
		this.ofcTeamCd = ofcTeamCd;
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
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Request Number
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	/**
	 * Column Info
	 * @param modiSrepCd
	 */
	public void setModiSrepCd(String modiSrepCd) {
		this.modiSrepCd = modiSrepCd;
	}
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEmpeCd(JSPUtil.getParameter(request, prefix + "empe_cd", ""));
		setIbSrepFlg(JSPUtil.getParameter(request, prefix + "ib_srep_flg", ""));
		setSexCd(JSPUtil.getParameter(request, prefix + "sex_cd", ""));
		setSrepEml(JSPUtil.getParameter(request, prefix + "srep_eml", ""));
		setMphnNo(JSPUtil.getParameter(request, prefix + "mphn_no", ""));
		setObSrepFlg(JSPUtil.getParameter(request, prefix + "ob_srep_flg", ""));
		setIntlMphnNo(JSPUtil.getParameter(request, prefix + "intl_mphn_no", ""));
		setSrepAbbrNm(JSPUtil.getParameter(request, prefix + "srep_abbr_nm", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcTeamCd(JSPUtil.getParameter(request, prefix + "ofc_team_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setRqstNo(JSPUtil.getParameter(request, prefix + "rqstNo", ""));
		setModiSrepCd(JSPUtil.getParameter(request, prefix + "modi_srep_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SalesRepVO[]
	 */
	public SalesRepVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SalesRepVO[]
	 */
	public SalesRepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SalesRepVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] empeCd = (JSPUtil.getParameter(request, prefix	+ "empe_cd", length));
			String[] ibSrepFlg = (JSPUtil.getParameter(request, prefix	+ "ib_srep_flg", length));
			String[] sexCd = (JSPUtil.getParameter(request, prefix	+ "sex_cd", length));
			String[] srepEml = (JSPUtil.getParameter(request, prefix	+ "srep_eml", length));
			String[] mphnNo = (JSPUtil.getParameter(request, prefix	+ "mphn_no", length));
			String[] obSrepFlg = (JSPUtil.getParameter(request, prefix	+ "ob_srep_flg", length));
			String[] intlMphnNo = (JSPUtil.getParameter(request, prefix	+ "intl_mphn_no", length));
			String[] srepAbbrNm = (JSPUtil.getParameter(request, prefix	+ "srep_abbr_nm", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcTeamCd = (JSPUtil.getParameter(request, prefix	+ "ofc_team_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqstNo", length));
			String[] modiSrepCd = (JSPUtil.getParameter(request, prefix	+ "modi_srep_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SalesRepVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (empeCd[i] != null)
					model.setEmpeCd(empeCd[i]);
				if (ibSrepFlg[i] != null)
					model.setIbSrepFlg(ibSrepFlg[i]);
				if (sexCd[i] != null)
					model.setSexCd(sexCd[i]);
				if (srepEml[i] != null)
					model.setSrepEml(srepEml[i]);
				if (mphnNo[i] != null)
					model.setMphnNo(mphnNo[i]);
				if (obSrepFlg[i] != null)
					model.setObSrepFlg(obSrepFlg[i]);
				if (intlMphnNo[i] != null)
					model.setIntlMphnNo(intlMphnNo[i]);
				if (srepAbbrNm[i] != null)
					model.setSrepAbbrNm(srepAbbrNm[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcTeamCd[i] != null)
					model.setOfcTeamCd(ofcTeamCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (modiSrepCd[i] != null)
					model.setModiSrepCd(modiSrepCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSalesRepVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SalesRepVO[]
	 */
	public SalesRepVO[] getSalesRepVOs(){
		SalesRepVO[] vos = (SalesRepVO[])models.toArray(new SalesRepVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empeCd = this.empeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSrepFlg = this.ibSrepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sexCd = this.sexCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepEml = this.srepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mphnNo = this.mphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepFlg = this.obSrepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlMphnNo = this.intlMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepAbbrNm = this.srepAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTeamCd = this.ofcTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiSrepCd = this.modiSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
