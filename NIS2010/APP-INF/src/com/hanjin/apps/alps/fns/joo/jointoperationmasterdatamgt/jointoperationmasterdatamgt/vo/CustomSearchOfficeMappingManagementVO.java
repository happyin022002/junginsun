/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomSearchOfficeMappingManagementVO.java
*@FileTitle : CustomSearchOfficeMappingManagementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.24
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.11.24 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomSearchOfficeMappingManagementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomSearchOfficeMappingManagementVO> models = new ArrayList<CustomSearchOfficeMappingManagementVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cngOfcCd = null;
	/* Column Info */
	private String ofcCdRhq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String cngOfcRhq = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String ofcCngRmk = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomSearchOfficeMappingManagementVO() {}

	public CustomSearchOfficeMappingManagementVO(String ibflag, String pagerows, String ofcCd, String ofcCdRhq, String cngOfcCd, String cngOfcRhq, String effDt, String expDt, String ofcCngRmk, String deltFlg, String updDt, String updUsrId, String creDt, String creUsrId) {
		this.updDt = updDt;
		this.cngOfcCd = cngOfcCd;
		this.ofcCdRhq = ofcCdRhq;
		this.deltFlg = deltFlg;
		this.cngOfcRhq = cngOfcRhq;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.expDt = expDt;
		this.ofcCngRmk = ofcCngRmk;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cng_ofc_cd", getCngOfcCd());
		this.hashColumns.put("ofc_cd_rhq", getOfcCdRhq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cng_ofc_rhq", getCngOfcRhq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ofc_cng_rmk", getOfcCngRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cng_ofc_cd", "cngOfcCd");
		this.hashFields.put("ofc_cd_rhq", "ofcCdRhq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cng_ofc_rhq", "cngOfcRhq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ofc_cng_rmk", "ofcCngRmk");
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
	 * @return cngOfcCd
	 */
	public String getCngOfcCd() {
		return this.cngOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCdRhq
	 */
	public String getOfcCdRhq() {
		return this.ofcCdRhq;
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
	 * @return cngOfcRhq
	 */
	public String getCngOfcRhq() {
		return this.cngOfcRhq;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return ofcCngRmk
	 */
	public String getOfcCngRmk() {
		return this.ofcCngRmk;
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
	 * @param cngOfcCd
	 */
	public void setCngOfcCd(String cngOfcCd) {
		this.cngOfcCd = cngOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCdRhq
	 */
	public void setOfcCdRhq(String ofcCdRhq) {
		this.ofcCdRhq = ofcCdRhq;
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
	 * @param cngOfcRhq
	 */
	public void setCngOfcRhq(String cngOfcRhq) {
		this.cngOfcRhq = cngOfcRhq;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCngRmk
	 */
	public void setOfcCngRmk(String ofcCngRmk) {
		this.ofcCngRmk = ofcCngRmk;
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
		setCngOfcCd(JSPUtil.getParameter(request, prefix + "cng_ofc_cd", ""));
		setOfcCdRhq(JSPUtil.getParameter(request, prefix + "ofc_cd_rhq", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCngOfcRhq(JSPUtil.getParameter(request, prefix + "cng_ofc_rhq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setOfcCngRmk(JSPUtil.getParameter(request, prefix + "ofc_cng_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomSearchOfficeMappingManagementVO[]
	 */
	public CustomSearchOfficeMappingManagementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomSearchOfficeMappingManagementVO[]
	 */
	public CustomSearchOfficeMappingManagementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomSearchOfficeMappingManagementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cngOfcCd = (JSPUtil.getParameter(request, prefix	+ "cng_ofc_cd", length));
			String[] ofcCdRhq = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_rhq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] cngOfcRhq = (JSPUtil.getParameter(request, prefix	+ "cng_ofc_rhq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] ofcCngRmk = (JSPUtil.getParameter(request, prefix	+ "ofc_cng_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomSearchOfficeMappingManagementVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cngOfcCd[i] != null)
					model.setCngOfcCd(cngOfcCd[i]);
				if (ofcCdRhq[i] != null)
					model.setOfcCdRhq(ofcCdRhq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (cngOfcRhq[i] != null)
					model.setCngOfcRhq(cngOfcRhq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (ofcCngRmk[i] != null)
					model.setOfcCngRmk(ofcCngRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomSearchOfficeMappingManagementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomSearchOfficeMappingManagementVO[]
	 */
	public CustomSearchOfficeMappingManagementVO[] getCustomSearchOfficeMappingManagementVOs(){
		CustomSearchOfficeMappingManagementVO[] vos = (CustomSearchOfficeMappingManagementVO[])models.toArray(new CustomSearchOfficeMappingManagementVO[models.size()]);
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
		this.cngOfcCd = this.cngOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdRhq = this.ofcCdRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngOfcRhq = this.cngOfcRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCngRmk = this.ofcCngRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
