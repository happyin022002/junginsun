/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CondSearchVesselStatusListVO.java
*@FileTitle : CondSearchVesselStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.27 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CondSearchVesselStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchVesselStatusListVO> models = new ArrayList<CondSearchVesselStatusListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String insurTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String insurVslOshpCd = null;
	/* Column Info */
	private String insurCvrgCd = null;
	/* Column Info */
	private String insurEffDt = null;
	/* Column Info */
	private String insurVslTpCd = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String insurExpDt = null;
	/* Column Info */
	private String insurPeriod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondSearchVesselStatusListVO() {}

	public CondSearchVesselStatusListVO(String ibflag, String pagerows, String insurPeriod, String insurTpCd, String vslCd, String vslEngNm, String insurClmPtyNo, String insurEffDt, String insurExpDt, String insurVslTpCd, String insurVslOshpCd, String insurCvrgCd) {
		this.vslCd = vslCd;
		this.insurTpCd = insurTpCd;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.insurVslOshpCd = insurVslOshpCd;
		this.insurCvrgCd = insurCvrgCd;
		this.insurEffDt = insurEffDt;
		this.insurVslTpCd = insurVslTpCd;
		this.insurClmPtyNo = insurClmPtyNo;
		this.insurExpDt = insurExpDt;
		this.insurPeriod = insurPeriod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("insur_tp_cd", getInsurTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("insur_vsl_oshp_cd", getInsurVslOshpCd());
		this.hashColumns.put("insur_cvrg_cd", getInsurCvrgCd());
		this.hashColumns.put("insur_eff_dt", getInsurEffDt());
		this.hashColumns.put("insur_vsl_tp_cd", getInsurVslTpCd());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("insur_exp_dt", getInsurExpDt());
		this.hashColumns.put("insur_period", getInsurPeriod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("insur_tp_cd", "insurTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("insur_vsl_oshp_cd", "insurVslOshpCd");
		this.hashFields.put("insur_cvrg_cd", "insurCvrgCd");
		this.hashFields.put("insur_eff_dt", "insurEffDt");
		this.hashFields.put("insur_vsl_tp_cd", "insurVslTpCd");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("insur_exp_dt", "insurExpDt");
		this.hashFields.put("insur_period", "insurPeriod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return insurTpCd
	 */
	public String getInsurTpCd() {
		return this.insurTpCd;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return insurVslOshpCd
	 */
	public String getInsurVslOshpCd() {
		return this.insurVslOshpCd;
	}
	
	/**
	 * Column Info
	 * @return insurCvrgCd
	 */
	public String getInsurCvrgCd() {
		return this.insurCvrgCd;
	}
	
	/**
	 * Column Info
	 * @return insurEffDt
	 */
	public String getInsurEffDt() {
		return this.insurEffDt;
	}
	
	/**
	 * Column Info
	 * @return insurVslTpCd
	 */
	public String getInsurVslTpCd() {
		return this.insurVslTpCd;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return insurExpDt
	 */
	public String getInsurExpDt() {
		return this.insurExpDt;
	}
	
	/**
	 * Column Info
	 * @return insurPeriod
	 */
	public String getInsurPeriod() {
		return this.insurPeriod;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param insurTpCd
	 */
	public void setInsurTpCd(String insurTpCd) {
		this.insurTpCd = insurTpCd;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param insurVslOshpCd
	 */
	public void setInsurVslOshpCd(String insurVslOshpCd) {
		this.insurVslOshpCd = insurVslOshpCd;
	}
	
	/**
	 * Column Info
	 * @param insurCvrgCd
	 */
	public void setInsurCvrgCd(String insurCvrgCd) {
		this.insurCvrgCd = insurCvrgCd;
	}
	
	/**
	 * Column Info
	 * @param insurEffDt
	 */
	public void setInsurEffDt(String insurEffDt) {
		this.insurEffDt = insurEffDt;
	}
	
	/**
	 * Column Info
	 * @param insurVslTpCd
	 */
	public void setInsurVslTpCd(String insurVslTpCd) {
		this.insurVslTpCd = insurVslTpCd;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param insurExpDt
	 */
	public void setInsurExpDt(String insurExpDt) {
		this.insurExpDt = insurExpDt;
	}
	
	/**
	 * Column Info
	 * @param insurPeriod
	 */
	public void setInsurPeriod(String insurPeriod) {
		this.insurPeriod = insurPeriod;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setInsurTpCd(JSPUtil.getParameter(request, "insur_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setInsurVslOshpCd(JSPUtil.getParameter(request, "insur_vsl_oshp_cd", ""));
		setInsurCvrgCd(JSPUtil.getParameter(request, "insur_cvrg_cd", ""));
		setInsurEffDt(JSPUtil.getParameter(request, "insur_eff_dt", ""));
		setInsurVslTpCd(JSPUtil.getParameter(request, "insur_vsl_tp_cd", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, "insur_clm_pty_no", ""));
		setInsurExpDt(JSPUtil.getParameter(request, "insur_exp_dt", ""));
		setInsurPeriod(JSPUtil.getParameter(request, "insur_period", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchVesselStatusListVO[]
	 */
	public CondSearchVesselStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchVesselStatusListVO[]
	 */
	public CondSearchVesselStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchVesselStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] insurTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] insurVslOshpCd = (JSPUtil.getParameter(request, prefix	+ "insur_vsl_oshp_cd", length));
			String[] insurCvrgCd = (JSPUtil.getParameter(request, prefix	+ "insur_cvrg_cd", length));
			String[] insurEffDt = (JSPUtil.getParameter(request, prefix	+ "insur_eff_dt", length));
			String[] insurVslTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_vsl_tp_cd", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] insurExpDt = (JSPUtil.getParameter(request, prefix	+ "insur_exp_dt", length));
			String[] insurPeriod = (JSPUtil.getParameter(request, prefix	+ "insur_period", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchVesselStatusListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (insurTpCd[i] != null)
					model.setInsurTpCd(insurTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (insurVslOshpCd[i] != null)
					model.setInsurVslOshpCd(insurVslOshpCd[i]);
				if (insurCvrgCd[i] != null)
					model.setInsurCvrgCd(insurCvrgCd[i]);
				if (insurEffDt[i] != null)
					model.setInsurEffDt(insurEffDt[i]);
				if (insurVslTpCd[i] != null)
					model.setInsurVslTpCd(insurVslTpCd[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (insurExpDt[i] != null)
					model.setInsurExpDt(insurExpDt[i]);
				if (insurPeriod[i] != null)
					model.setInsurPeriod(insurPeriod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondSearchVesselStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondSearchVesselStatusListVO[]
	 */
	public CondSearchVesselStatusListVO[] getCondSearchVesselStatusListVOs(){
		CondSearchVesselStatusListVO[] vos = (CondSearchVesselStatusListVO[])models.toArray(new CondSearchVesselStatusListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurTpCd = this.insurTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurVslOshpCd = this.insurVslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurCvrgCd = this.insurCvrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurEffDt = this.insurEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurVslTpCd = this.insurVslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurExpDt = this.insurExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPeriod = this.insurPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
