/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PreventionInfoVO.java
*@FileTitle : PreventionInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.01.20 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PreventionInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreventionInfoVO> models = new ArrayList<PreventionInfoVO>();
	
	/* Column Info */
	private String clmPrveDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String clmPrveDivCd = null;
	/* Column Info */
	private String clmPrveNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clmPrveReadKnt = null;
	/* Column Info */
	private String clmPrveDivNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String clmPrveSubjNm = null;
	/* Column Info */
	private String clmAreaCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PreventionInfoVO() {}

	public PreventionInfoVO(String ibflag, String pagerows, String clmPrveNo, String clmPrveDivCd, String clmPrveDivNm, String effDt, String expDt, String creOfcCd, String clmAreaCd, String clmPrveSubjNm, String clmPrveDesc, String clmPrveReadKnt, String creUsrId, String creDt) {
		this.clmPrveDesc = clmPrveDesc;
		this.creDt = creDt;
		this.clmPrveDivCd = clmPrveDivCd;
		this.clmPrveNo = clmPrveNo;
		this.pagerows = pagerows;
		this.clmPrveReadKnt = clmPrveReadKnt;
		this.clmPrveDivNm = clmPrveDivNm;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.creUsrId = creUsrId;
		this.creOfcCd = creOfcCd;
		this.expDt = expDt;
		this.clmPrveSubjNm = clmPrveSubjNm;
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("clm_prve_desc", getClmPrveDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("clm_prve_div_cd", getClmPrveDivCd());
		this.hashColumns.put("clm_prve_no", getClmPrveNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clm_prve_read_knt", getClmPrveReadKnt());
		this.hashColumns.put("clm_prve_div_nm", getClmPrveDivNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("clm_prve_subj_nm", getClmPrveSubjNm());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("clm_prve_desc", "clmPrveDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("clm_prve_div_cd", "clmPrveDivCd");
		this.hashFields.put("clm_prve_no", "clmPrveNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clm_prve_read_knt", "clmPrveReadKnt");
		this.hashFields.put("clm_prve_div_nm", "clmPrveDivNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("clm_prve_subj_nm", "clmPrveSubjNm");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return clmPrveDesc
	 */
	public String getClmPrveDesc() {
		return this.clmPrveDesc;
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
	 * @return clmPrveDivCd
	 */
	public String getClmPrveDivCd() {
		return this.clmPrveDivCd;
	}
	
	/**
	 * Column Info
	 * @return clmPrveNo
	 */
	public String getClmPrveNo() {
		return this.clmPrveNo;
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
	 * @return clmPrveReadKnt
	 */
	public String getClmPrveReadKnt() {
		return this.clmPrveReadKnt;
	}
	
	/**
	 * Column Info
	 * @return clmPrveDivNm
	 */
	public String getClmPrveDivNm() {
		return this.clmPrveDivNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return clmPrveSubjNm
	 */
	public String getClmPrveSubjNm() {
		return this.clmPrveSubjNm;
	}
	
	/**
	 * Column Info
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
	}
	

	/**
	 * Column Info
	 * @param clmPrveDesc
	 */
	public void setClmPrveDesc(String clmPrveDesc) {
		this.clmPrveDesc = clmPrveDesc;
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
	 * @param clmPrveDivCd
	 */
	public void setClmPrveDivCd(String clmPrveDivCd) {
		this.clmPrveDivCd = clmPrveDivCd;
	}
	
	/**
	 * Column Info
	 * @param clmPrveNo
	 */
	public void setClmPrveNo(String clmPrveNo) {
		this.clmPrveNo = clmPrveNo;
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
	 * @param clmPrveReadKnt
	 */
	public void setClmPrveReadKnt(String clmPrveReadKnt) {
		this.clmPrveReadKnt = clmPrveReadKnt;
	}
	
	/**
	 * Column Info
	 * @param clmPrveDivNm
	 */
	public void setClmPrveDivNm(String clmPrveDivNm) {
		this.clmPrveDivNm = clmPrveDivNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param clmPrveSubjNm
	 */
	public void setClmPrveSubjNm(String clmPrveSubjNm) {
		this.clmPrveSubjNm = clmPrveSubjNm;
	}
	
	/**
	 * Column Info
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
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
		setClmPrveDesc(JSPUtil.getParameter(request, prefix + "clm_prve_desc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setClmPrveDivCd(JSPUtil.getParameter(request, prefix + "clm_prve_div_cd", ""));
		setClmPrveNo(JSPUtil.getParameter(request, prefix + "clm_prve_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClmPrveReadKnt(JSPUtil.getParameter(request, prefix + "clm_prve_read_knt", ""));
		setClmPrveDivNm(JSPUtil.getParameter(request, prefix + "clm_prve_div_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setClmPrveSubjNm(JSPUtil.getParameter(request, prefix + "clm_prve_subj_nm", ""));
		setClmAreaCd(JSPUtil.getParameter(request, prefix + "clm_area_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreventionInfoVO[]
	 */
	public PreventionInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreventionInfoVO[]
	 */
	public PreventionInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreventionInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] clmPrveDesc = (JSPUtil.getParameter(request, prefix	+ "clm_prve_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] clmPrveDivCd = (JSPUtil.getParameter(request, prefix	+ "clm_prve_div_cd", length));
			String[] clmPrveNo = (JSPUtil.getParameter(request, prefix	+ "clm_prve_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clmPrveReadKnt = (JSPUtil.getParameter(request, prefix	+ "clm_prve_read_knt", length));
			String[] clmPrveDivNm = (JSPUtil.getParameter(request, prefix	+ "clm_prve_div_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] clmPrveSubjNm = (JSPUtil.getParameter(request, prefix	+ "clm_prve_subj_nm", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreventionInfoVO();
				if (clmPrveDesc[i] != null)
					model.setClmPrveDesc(clmPrveDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (clmPrveDivCd[i] != null)
					model.setClmPrveDivCd(clmPrveDivCd[i]);
				if (clmPrveNo[i] != null)
					model.setClmPrveNo(clmPrveNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clmPrveReadKnt[i] != null)
					model.setClmPrveReadKnt(clmPrveReadKnt[i]);
				if (clmPrveDivNm[i] != null)
					model.setClmPrveDivNm(clmPrveDivNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (clmPrveSubjNm[i] != null)
					model.setClmPrveSubjNm(clmPrveSubjNm[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreventionInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreventionInfoVO[]
	 */
	public PreventionInfoVO[] getPreventionInfoVOs(){
		PreventionInfoVO[] vos = (PreventionInfoVO[])models.toArray(new PreventionInfoVO[models.size()]);
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
		this.clmPrveDesc = this.clmPrveDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPrveDivCd = this.clmPrveDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPrveNo = this.clmPrveNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPrveReadKnt = this.clmPrveReadKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPrveDivNm = this.clmPrveDivNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPrveSubjNm = this.clmPrveSubjNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
