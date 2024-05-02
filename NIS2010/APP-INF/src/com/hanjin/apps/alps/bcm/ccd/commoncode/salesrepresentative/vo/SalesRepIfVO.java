/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : SalesRepIfVO.java
*@FileTitle : SalesRepIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo;

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
public class SalesRepIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SalesRepIfVO> models = new ArrayList<SalesRepIfVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String srepCd = null;

	/* Column Info */
	private String mstOfcId = null;

	/* Column Info */
	private String ofcCd = null;

	/* Column Info */
	private String srepNm = null;

	/* Column Info */
	private String ofcMstTmId = null;

	/* Column Info */
	private String ofcTeamCd = null;

	/* Column Info */
	private String sxCd = null;

	/* Column Info */
	private String srepAbbrNm = null;

	/* Column Info */
	private String ibSrepFlg = null;

	/* Column Info */
	private String obSrepFlg = null;

	/* Column Info */
	private String empeCd = null;

	/* Column Info */
	private String srepEml = null;

	/* Column Info */
	private String intlMphnNo = null;

	/* Column Info */
	private String mphnNo = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String updDt = null;

	/* Column Info */
	private String stsCd = null;

	/* Column Info */
	private String oMstOfcId = null;

	/* Column Info */
	private String oOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SalesRepIfVO() {}

	public SalesRepIfVO(String ibflag, String pagerows, String srepCd, String mstOfcId, String ofcCd, String srepNm, String ofcMstTmId, String ofcTeamCd, String sxCd, String srepAbbrNm, String ibSrepFlg, String obSrepFlg, String empeCd, String srepEml, String intlMphnNo, String mphnNo, String creUsrId, String creDt, String updUsrId, String updDt, String stsCd, String oMstOfcId, String oOfcCd) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.srepCd = srepCd;
		this.mstOfcId = mstOfcId;
		this.ofcCd = ofcCd;
		this.srepNm = srepNm;
		this.ofcMstTmId = ofcMstTmId;
		this.ofcTeamCd = ofcTeamCd;
		this.sxCd = sxCd;
		this.srepAbbrNm = srepAbbrNm;
		this.ibSrepFlg = ibSrepFlg;
		this.obSrepFlg = obSrepFlg;
		this.empeCd = empeCd;
		this.srepEml = srepEml;
		this.intlMphnNo = intlMphnNo;
		this.mphnNo = mphnNo;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.stsCd = stsCd;
		this.oMstOfcId = oMstOfcId;
		this.oOfcCd = oOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("mst_ofc_id", getMstOfcId());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("ofc_mst_tm_id", getOfcMstTmId());
		this.hashColumns.put("ofc_team_cd", getOfcTeamCd());
		this.hashColumns.put("sx_cd", getSxCd());
		this.hashColumns.put("srep_abbr_nm", getSrepAbbrNm());
		this.hashColumns.put("ib_srep_flg", getIbSrepFlg());
		this.hashColumns.put("ob_srep_flg", getObSrepFlg());
		this.hashColumns.put("empe_cd", getEmpeCd());
		this.hashColumns.put("srep_eml", getSrepEml());
		this.hashColumns.put("intl_mphn_no", getIntlMphnNo());
		this.hashColumns.put("mphn_no", getMphnNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("o_mst_ofc_id", getOMstOfcId());
		this.hashColumns.put("o_ofc_cd", getOOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("mst_ofc_id", "mstOfcId");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("ofc_mst_tm_id", "ofcMstTmId");
		this.hashFields.put("ofc_team_cd", "ofcTeamCd");
		this.hashFields.put("sx_cd", "sxCd");
		this.hashFields.put("srep_abbr_nm", "srepAbbrNm");
		this.hashFields.put("ib_srep_flg", "ibSrepFlg");
		this.hashFields.put("ob_srep_flg", "obSrepFlg");
		this.hashFields.put("empe_cd", "empeCd");
		this.hashFields.put("srep_eml", "srepEml");
		this.hashFields.put("intl_mphn_no", "intlMphnNo");
		this.hashFields.put("mphn_no", "mphnNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("o_mst_ofc_id", "oMstOfcId");
		this.hashFields.put("o_ofc_cd", "oOfcCd");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * 
	 * @return String srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 *
	 * @param String mstOfcId
	 */
	public void setMstOfcId(String mstOfcId) {
		this.mstOfcId = mstOfcId;
	}
	
	/**
	 * 
	 * @return String mstOfcId
	 */
	public String getMstOfcId() {
		return this.mstOfcId;
	}
	
	/**
	 *
	 * @param String ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 
	 * @return String ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 *
	 * @param String srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * 
	 * @return String srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 *
	 * @param String ofcMstTmId
	 */
	public void setOfcMstTmId(String ofcMstTmId) {
		this.ofcMstTmId = ofcMstTmId;
	}
	
	/**
	 * 
	 * @return String ofcMstTmId
	 */
	public String getOfcMstTmId() {
		return this.ofcMstTmId;
	}
	
	/**
	 *
	 * @param String ofcTeamCd
	 */
	public void setOfcTeamCd(String ofcTeamCd) {
		this.ofcTeamCd = ofcTeamCd;
	}
	
	/**
	 * 
	 * @return String ofcTeamCd
	 */
	public String getOfcTeamCd() {
		return this.ofcTeamCd;
	}
	
	/**
	 *
	 * @param String sxCd
	 */
	public void setSxCd(String sxCd) {
		this.sxCd = sxCd;
	}
	
	/**
	 * 
	 * @return String sxCd
	 */
	public String getSxCd() {
		return this.sxCd;
	}
	
	/**
	 *
	 * @param String srepAbbrNm
	 */
	public void setSrepAbbrNm(String srepAbbrNm) {
		this.srepAbbrNm = srepAbbrNm;
	}
	
	/**
	 * 
	 * @return String srepAbbrNm
	 */
	public String getSrepAbbrNm() {
		return this.srepAbbrNm;
	}
	
	/**
	 *
	 * @param String ibSrepFlg
	 */
	public void setIbSrepFlg(String ibSrepFlg) {
		this.ibSrepFlg = ibSrepFlg;
	}
	
	/**
	 * 
	 * @return String ibSrepFlg
	 */
	public String getIbSrepFlg() {
		return this.ibSrepFlg;
	}
	
	/**
	 *
	 * @param String obSrepFlg
	 */
	public void setObSrepFlg(String obSrepFlg) {
		this.obSrepFlg = obSrepFlg;
	}
	
	/**
	 * 
	 * @return String obSrepFlg
	 */
	public String getObSrepFlg() {
		return this.obSrepFlg;
	}
	
	/**
	 *
	 * @param String empeCd
	 */
	public void setEmpeCd(String empeCd) {
		this.empeCd = empeCd;
	}
	
	/**
	 * 
	 * @return String empeCd
	 */
	public String getEmpeCd() {
		return this.empeCd;
	}
	
	/**
	 *
	 * @param String srepEml
	 */
	public void setSrepEml(String srepEml) {
		this.srepEml = srepEml;
	}
	
	/**
	 * 
	 * @return String srepEml
	 */
	public String getSrepEml() {
		return this.srepEml;
	}
	
	/**
	 *
	 * @param String intlMphnNo
	 */
	public void setIntlMphnNo(String intlMphnNo) {
		this.intlMphnNo = intlMphnNo;
	}
	
	/**
	 * 
	 * @return String intlMphnNo
	 */
	public String getIntlMphnNo() {
		return this.intlMphnNo;
	}
	
	/**
	 *
	 * @param String mphnNo
	 */
	public void setMphnNo(String mphnNo) {
		this.mphnNo = mphnNo;
	}
	
	/**
	 * 
	 * @return String mphnNo
	 */
	public String getMphnNo() {
		return this.mphnNo;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 *
	 * @param String stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * 
	 * @return String stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 *
	 * @param String oMstOfcId
	 */
	public void setOMstOfcId(String oMstOfcId) {
		this.oMstOfcId = oMstOfcId;
	}
	
	/**
	 * 
	 * @return String oMstOfcId
	 */
	public String getOMstOfcId() {
		return this.oMstOfcId;
	}
	
	/**
	 *
	 * @param String oOfcCd
	 */
	public void setOOfcCd(String oOfcCd) {
		this.oOfcCd = oOfcCd;
	}
	
	/**
	 * 
	 * @return String oOfcCd
	 */
	public String getOOfcCd() {
		return this.oOfcCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setMstOfcId(JSPUtil.getParameter(request, prefix + "mst_ofc_id", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setOfcMstTmId(JSPUtil.getParameter(request, prefix + "ofc_mst_tm_id", ""));
		setOfcTeamCd(JSPUtil.getParameter(request, prefix + "ofc_team_cd", ""));
		setSxCd(JSPUtil.getParameter(request, prefix + "sx_cd", ""));
		setSrepAbbrNm(JSPUtil.getParameter(request, prefix + "srep_abbr_nm", ""));
		setIbSrepFlg(JSPUtil.getParameter(request, prefix + "ib_srep_flg", ""));
		setObSrepFlg(JSPUtil.getParameter(request, prefix + "ob_srep_flg", ""));
		setEmpeCd(JSPUtil.getParameter(request, prefix + "empe_cd", ""));
		setSrepEml(JSPUtil.getParameter(request, prefix + "srep_eml", ""));
		setIntlMphnNo(JSPUtil.getParameter(request, prefix + "intl_mphn_no", ""));
		setMphnNo(JSPUtil.getParameter(request, prefix + "mphn_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setOMstOfcId(JSPUtil.getParameter(request, prefix + "o_mst_ofc_id", ""));
		setOOfcCd(JSPUtil.getParameter(request, prefix + "o_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SalesRepIfVO[]
	 */
	public SalesRepIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SalesRepIfVO[]
	 */
	public SalesRepIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SalesRepIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] mstOfcId = (JSPUtil.getParameter(request, prefix	+ "mst_ofc_id", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] ofcMstTmId = (JSPUtil.getParameter(request, prefix	+ "ofc_mst_tm_id", length));
			String[] ofcTeamCd = (JSPUtil.getParameter(request, prefix	+ "ofc_team_cd", length));
			String[] sxCd = (JSPUtil.getParameter(request, prefix	+ "sx_cd", length));
			String[] srepAbbrNm = (JSPUtil.getParameter(request, prefix	+ "srep_abbr_nm", length));
			String[] ibSrepFlg = (JSPUtil.getParameter(request, prefix	+ "ib_srep_flg", length));
			String[] obSrepFlg = (JSPUtil.getParameter(request, prefix	+ "ob_srep_flg", length));
			String[] empeCd = (JSPUtil.getParameter(request, prefix	+ "empe_cd", length));
			String[] srepEml = (JSPUtil.getParameter(request, prefix	+ "srep_eml", length));
			String[] intlMphnNo = (JSPUtil.getParameter(request, prefix	+ "intl_mphn_no", length));
			String[] mphnNo = (JSPUtil.getParameter(request, prefix	+ "mphn_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] oMstOfcId = (JSPUtil.getParameter(request, prefix	+ "o_mst_ofc_id", length));
			String[] oOfcCd = (JSPUtil.getParameter(request, prefix	+ "o_ofc_cd", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SalesRepIfVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (srepCd[i] != null) 
					model.setSrepCd(srepCd[i]);
				if (mstOfcId[i] != null) 
					model.setMstOfcId(mstOfcId[i]);
				if (ofcCd[i] != null) 
					model.setOfcCd(ofcCd[i]);
				if (srepNm[i] != null) 
					model.setSrepNm(srepNm[i]);
				if (ofcMstTmId[i] != null) 
					model.setOfcMstTmId(ofcMstTmId[i]);
				if (ofcTeamCd[i] != null) 
					model.setOfcTeamCd(ofcTeamCd[i]);
				if (sxCd[i] != null) 
					model.setSxCd(sxCd[i]);
				if (srepAbbrNm[i] != null) 
					model.setSrepAbbrNm(srepAbbrNm[i]);
				if (ibSrepFlg[i] != null) 
					model.setIbSrepFlg(ibSrepFlg[i]);
				if (obSrepFlg[i] != null) 
					model.setObSrepFlg(obSrepFlg[i]);
				if (empeCd[i] != null) 
					model.setEmpeCd(empeCd[i]);
				if (srepEml[i] != null) 
					model.setSrepEml(srepEml[i]);
				if (intlMphnNo[i] != null) 
					model.setIntlMphnNo(intlMphnNo[i]);
				if (mphnNo[i] != null) 
					model.setMphnNo(mphnNo[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				if (stsCd[i] != null) 
					model.setStsCd(stsCd[i]);
				if (oMstOfcId[i] != null) 
					model.setOMstOfcId(oMstOfcId[i]);
				if (oOfcCd[i] != null) 
					model.setOOfcCd(oOfcCd[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSalesRepIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SalesRepIfVO[]
	 */
	public SalesRepIfVO[] getSalesRepIfVOs(){
		SalesRepIfVO[] vos = (SalesRepIfVO[])models.toArray(new SalesRepIfVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstOfcId = this.mstOfcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcMstTmId = this.ofcMstTmId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTeamCd = this.ofcTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sxCd = this.sxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepAbbrNm = this.srepAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSrepFlg = this.ibSrepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepFlg = this.obSrepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empeCd = this.empeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepEml = this.srepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlMphnNo = this.intlMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mphnNo = this.mphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oMstOfcId = this.oMstOfcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oOfcCd = this.oOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}