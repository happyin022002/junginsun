/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdTroInfoVO.java
*@FileTitle : PrdTroInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.12 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrdTroInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdTroInfoVO> models = new ArrayList<PrdTroInfoVO>();
	
	/* Column Info */
	private String troPkupCy = null;
	/* Column Info */
	private String troSubSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dorZone = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String haulage = null;
	/* Column Info */
	private String troRtnCy = null;
	/* Column Info */
	private String trMode = null;
	/* Column Info */
	private String areaContiCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrdTroInfoVO() {}

	public PrdTroInfoVO(String ibflag, String pagerows, String cntrNo, String dorZone, String haulage, String trMode, String troPkupCy, String troRtnCy, String troSeq, String troSubSeq, String areaContiCd) {
		this.troPkupCy = troPkupCy;
		this.troSubSeq = troSubSeq;
		this.ibflag = ibflag;
		this.dorZone = dorZone;
		this.troSeq = troSeq;
		this.cntrNo = cntrNo;
		this.haulage = haulage;
		this.troRtnCy = troRtnCy;
		this.trMode = trMode;
		this.areaContiCd = areaContiCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tro_pkup_cy", getTroPkupCy());
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dor_zone", getDorZone());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("haulage", getHaulage());
		this.hashColumns.put("tro_rtn_cy", getTroRtnCy());
		this.hashColumns.put("tr_mode", getTrMode());
		this.hashColumns.put("area_conti_cd", getAreaContiCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tro_pkup_cy", "troPkupCy");
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dor_zone", "dorZone");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("haulage", "haulage");
		this.hashFields.put("tro_rtn_cy", "troRtnCy");
		this.hashFields.put("tr_mode", "trMode");
		this.hashFields.put("area_conti_cd", "areaContiCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return troPkupCy
	 */
	public String getTroPkupCy() {
		return this.troPkupCy;
	}
	
	/**
	 * Column Info
	 * @return troSubSeq
	 */
	public String getTroSubSeq() {
		return this.troSubSeq;
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
	 * @return dorZone
	 */
	public String getDorZone() {
		return this.dorZone;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return haulage
	 */
	public String getHaulage() {
		return this.haulage;
	}
	
	/**
	 * Column Info
	 * @return troRtnCy
	 */
	public String getTroRtnCy() {
		return this.troRtnCy;
	}
	
	/**
	 * Column Info
	 * @return trMode
	 */
	public String getTrMode() {
		return this.trMode;
	}
	
	/**
	 * Column Info
	 * @return areaContiCd
	 */
	public String getAreaContiCd() {
		return this.areaContiCd;
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
	 * @param troPkupCy
	 */
	public void setTroPkupCy(String troPkupCy) {
		this.troPkupCy = troPkupCy;
	}
	
	/**
	 * Column Info
	 * @param troSubSeq
	 */
	public void setTroSubSeq(String troSubSeq) {
		this.troSubSeq = troSubSeq;
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
	 * @param dorZone
	 */
	public void setDorZone(String dorZone) {
		this.dorZone = dorZone;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param haulage
	 */
	public void setHaulage(String haulage) {
		this.haulage = haulage;
	}
	
	/**
	 * Column Info
	 * @param troRtnCy
	 */
	public void setTroRtnCy(String troRtnCy) {
		this.troRtnCy = troRtnCy;
	}
	
	/**
	 * Column Info
	 * @param trMode
	 */
	public void setTrMode(String trMode) {
		this.trMode = trMode;
	}
	
	/**
	 * Column Info
	 * @param areaContiCd
	 */
	public void setAreaContiCd(String areaContiCd) {
		this.areaContiCd = areaContiCd;
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
		setTroPkupCy(JSPUtil.getParameter(request, "tro_pkup_cy", ""));
		setTroSubSeq(JSPUtil.getParameter(request, "tro_sub_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDorZone(JSPUtil.getParameter(request, "dor_zone", ""));
		setTroSeq(JSPUtil.getParameter(request, "tro_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setHaulage(JSPUtil.getParameter(request, "haulage", ""));
		setTroRtnCy(JSPUtil.getParameter(request, "tro_rtn_cy", ""));
		setTrMode(JSPUtil.getParameter(request, "tr_mode", ""));
		setAreaContiCd(JSPUtil.getParameter(request, "area_conti_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdTroInfoVO[]
	 */
	public PrdTroInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrdTroInfoVO[]
	 */
	public PrdTroInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdTroInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] troPkupCy = (JSPUtil.getParameter(request, prefix	+ "tro_pkup_cy", length));
			String[] troSubSeq = (JSPUtil.getParameter(request, prefix	+ "tro_sub_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dorZone = (JSPUtil.getParameter(request, prefix	+ "dor_zone", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] haulage = (JSPUtil.getParameter(request, prefix	+ "haulage", length));
			String[] troRtnCy = (JSPUtil.getParameter(request, prefix	+ "tro_rtn_cy", length));
			String[] trMode = (JSPUtil.getParameter(request, prefix	+ "tr_mode", length));
			String[] areaContiCd = (JSPUtil.getParameter(request, prefix	+ "area_conti_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrdTroInfoVO();
				if (troPkupCy[i] != null)
					model.setTroPkupCy(troPkupCy[i]);
				if (troSubSeq[i] != null)
					model.setTroSubSeq(troSubSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dorZone[i] != null)
					model.setDorZone(dorZone[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (haulage[i] != null)
					model.setHaulage(haulage[i]);
				if (troRtnCy[i] != null)
					model.setTroRtnCy(troRtnCy[i]);
				if (trMode[i] != null)
					model.setTrMode(trMode[i]);
				if (areaContiCd[i] != null)
					model.setAreaContiCd(areaContiCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdTroInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdTroInfoVO[]
	 */
	public PrdTroInfoVO[] getPrdTroInfoVOs(){
		PrdTroInfoVO[] vos = (PrdTroInfoVO[])models.toArray(new PrdTroInfoVO[models.size()]);
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
		this.troPkupCy = this.troPkupCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSubSeq = this.troSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorZone = this.dorZone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulage = this.haulage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troRtnCy = this.troRtnCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trMode = this.trMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaContiCd = this.areaContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
