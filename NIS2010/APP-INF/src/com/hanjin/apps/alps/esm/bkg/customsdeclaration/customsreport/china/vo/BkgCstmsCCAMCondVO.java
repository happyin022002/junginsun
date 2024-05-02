/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCstmsCCAMCondVO.java
*@FileTitle : BkgCstmsCCAMCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo;

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

public class BkgCstmsCCAMCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsCCAMCondVO> models = new ArrayList<BkgCstmsCCAMCondVO>();
	
	/* Column Info */
	private String pVvd = null;
	/* Column Info */
	private String pFromMt = null;
	/* Column Info */
	private String pLane = null;
	/* Column Info */
	private String pToDt = null;
	/* Column Info */
	private String pToMt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pPol = null;
	/* Column Info */
	private String pFromDt = null;
	/* Column Info */
	private String pPod = null;
	/* Column Info */
	private String pPolYd = null;
	/* Column Info */
	private String pBOfcCd = null;
	/* Column Info */
	private String pRhqGb = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCstmsCCAMCondVO() {}

	public BkgCstmsCCAMCondVO(String ibflag, String pagerows, String pVvd, String pPol, String pFromMt, String pFromDt, String pLane, String pPolYd, String pBOfcCd, String pToDt, String pRhqGb, String pToMt, String rhq, String pPod) {
		this.pVvd = pVvd;
		this.pFromMt = pFromMt;
		this.pLane = pLane;
		this.pToDt = pToDt;
		this.pToMt = pToMt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.pPol = pPol;
		this.pFromDt = pFromDt;
		this.pPod = pPod;
		this.pPolYd = pPolYd;
		this.pBOfcCd = pBOfcCd;
		this.pRhqGb = pRhqGb;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_vvd", getPVvd());
		this.hashColumns.put("p_from_mt", getPFromMt());
		this.hashColumns.put("p_lane", getPLane());
		this.hashColumns.put("p_to_dt", getPToDt());
		this.hashColumns.put("p_to_mt", getPToMt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_pol", getPPol());
		this.hashColumns.put("p_from_dt", getPFromDt());
		this.hashColumns.put("p_pod", getPPod());
		this.hashColumns.put("p_pol_yd", getPPolYd());
		this.hashColumns.put("p_b_ofc_cd", getPBOfcCd());
		this.hashColumns.put("p_rhq_gb", getPRhqGb());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_vvd", "pVvd");
		this.hashFields.put("p_from_mt", "pFromMt");
		this.hashFields.put("p_lane", "pLane");
		this.hashFields.put("p_to_dt", "pToDt");
		this.hashFields.put("p_to_mt", "pToMt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_pol", "pPol");
		this.hashFields.put("p_from_dt", "pFromDt");
		this.hashFields.put("p_pod", "pPod");
		this.hashFields.put("p_pol_yd", "pPolYd");
		this.hashFields.put("p_b_ofc_cd", "pBOfcCd");
		this.hashFields.put("p_rhq_gb", "pRhqGb");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pVvd
	 */
	public String getPVvd() {
		return this.pVvd;
	}
	
	/**
	 * Column Info
	 * @return pFromMt
	 */
	public String getPFromMt() {
		return this.pFromMt;
	}
	
	/**
	 * Column Info
	 * @return pLane
	 */
	public String getPLane() {
		return this.pLane;
	}
	
	/**
	 * Column Info
	 * @return pToDt
	 */
	public String getPToDt() {
		return this.pToDt;
	}
	
	/**
	 * Column Info
	 * @return pToMt
	 */
	public String getPToMt() {
		return this.pToMt;
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
	 * @return pPol
	 */
	public String getPPol() {
		return this.pPol;
	}
	
	/**
	 * Column Info
	 * @return pFromDt
	 */
	public String getPFromDt() {
		return this.pFromDt;
	}
	
	/**
	 * Column Info
	 * @return pPod
	 */
	public String getPPod() {
		return this.pPod;
	}
	
	/**
	 * Column Info
	 * @return pPolYd
	 */
	public String getPPolYd() {
		return this.pPolYd;
	}
	
	/**
	 * Column Info
	 * @return pBOfcCd
	 */
	public String getPBOfcCd() {
		return this.pBOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pRhqGb
	 */
	public String getPRhqGb() {
		return this.pRhqGb;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	/**
	 * Column Info
	 * @param pVvd
	 */
	public void setPVvd(String pVvd) {
		this.pVvd = pVvd;
	}
	
	/**
	 * Column Info
	 * @param pFromMt
	 */
	public void setPFromMt(String pFromMt) {
		this.pFromMt = pFromMt;
	}
	
	/**
	 * Column Info
	 * @param pLane
	 */
	public void setPLane(String pLane) {
		this.pLane = pLane;
	}
	
	/**
	 * Column Info
	 * @param pToDt
	 */
	public void setPToDt(String pToDt) {
		this.pToDt = pToDt;
	}
	
	/**
	 * Column Info
	 * @param pToMt
	 */
	public void setPToMt(String pToMt) {
		this.pToMt = pToMt;
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
	 * @param pPol
	 */
	public void setPPol(String pPol) {
		this.pPol = pPol;
	}
	
	/**
	 * Column Info
	 * @param pFromDt
	 */
	public void setPFromDt(String pFromDt) {
		this.pFromDt = pFromDt;
	}
	
	/**
	 * Column Info
	 * @param pPod
	 */
	public void setPPod(String pPod) {
		this.pPod = pPod;
	}
	
	/**
	 * Column Info
	 * @param pPolYd
	 */
	public void setPPolYd(String pPolYd) {
		this.pPolYd = pPolYd;
	}
	
	/**
	 * Column Info
	 * @param pBOfcCd
	 */
	public void setPBOfcCd(String pBOfcCd) {
		this.pBOfcCd = pBOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pRhqGb
	 */
	public void setPRhqGb(String pRhqGb) {
		this.pRhqGb = pRhqGb;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
		setPVvd(JSPUtil.getParameter(request, prefix + "p_vvd", ""));
		setPFromMt(JSPUtil.getParameter(request, prefix + "p_from_mt", ""));
		setPLane(JSPUtil.getParameter(request, prefix + "p_lane", ""));
		setPToDt(JSPUtil.getParameter(request, prefix + "p_to_dt", ""));
		setPToMt(JSPUtil.getParameter(request, prefix + "p_to_mt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPPol(JSPUtil.getParameter(request, prefix + "p_pol", ""));
		setPFromDt(JSPUtil.getParameter(request, prefix + "p_from_dt", ""));
		setPPod(JSPUtil.getParameter(request, prefix + "p_pod", ""));
		setPPolYd(JSPUtil.getParameter(request, prefix + "p_pol_yd", ""));
		setPBOfcCd(JSPUtil.getParameter(request, prefix + "p_b_ofc_cd", ""));
		setPRhqGb(JSPUtil.getParameter(request, prefix + "p_rhq_gb", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsCCAMCondVO[]
	 */
	public BkgCstmsCCAMCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsCCAMCondVO[]
	 */
	public BkgCstmsCCAMCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsCCAMCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pVvd = (JSPUtil.getParameter(request, prefix	+ "p_vvd", length));
			String[] pFromMt = (JSPUtil.getParameter(request, prefix	+ "p_from_mt", length));
			String[] pLane = (JSPUtil.getParameter(request, prefix	+ "p_lane", length));
			String[] pToDt = (JSPUtil.getParameter(request, prefix	+ "p_to_dt", length));
			String[] pToMt = (JSPUtil.getParameter(request, prefix	+ "p_to_mt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pPol = (JSPUtil.getParameter(request, prefix	+ "p_pol", length));
			String[] pFromDt = (JSPUtil.getParameter(request, prefix	+ "p_from_dt", length));
			String[] pPod = (JSPUtil.getParameter(request, prefix	+ "p_pod", length));
			String[] pPolYd = (JSPUtil.getParameter(request, prefix	+ "p_pol_yd", length));
			String[] pBOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_b_ofc_cd", length));
			String[] pRhqGb = (JSPUtil.getParameter(request, prefix	+ "p_rhq_gb", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsCCAMCondVO();
				if (pVvd[i] != null)
					model.setPVvd(pVvd[i]);
				if (pFromMt[i] != null)
					model.setPFromMt(pFromMt[i]);
				if (pLane[i] != null)
					model.setPLane(pLane[i]);
				if (pToDt[i] != null)
					model.setPToDt(pToDt[i]);
				if (pToMt[i] != null)
					model.setPToMt(pToMt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pPol[i] != null)
					model.setPPol(pPol[i]);
				if (pFromDt[i] != null)
					model.setPFromDt(pFromDt[i]);
				if (pPod[i] != null)
					model.setPPod(pPod[i]);
				if (pPolYd[i] != null)
					model.setPPolYd(pPolYd[i]);
				if (pBOfcCd[i] != null)
					model.setPBOfcCd(pBOfcCd[i]);
				if (pRhqGb[i] != null)
					model.setPRhqGb(pRhqGb[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsCCAMCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsCCAMCondVO[]
	 */
	public BkgCstmsCCAMCondVO[] getBkgCstmsCCAMCondVOs(){
		BkgCstmsCCAMCondVO[] vos = (BkgCstmsCCAMCondVO[])models.toArray(new BkgCstmsCCAMCondVO[models.size()]);
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
		this.pVvd = this.pVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFromMt = this.pFromMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLane = this.pLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pToDt = this.pToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pToMt = this.pToMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPol = this.pPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFromDt = this.pFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPod = this.pPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolYd = this.pPolYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBOfcCd = this.pBOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRhqGb = this.pRhqGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
