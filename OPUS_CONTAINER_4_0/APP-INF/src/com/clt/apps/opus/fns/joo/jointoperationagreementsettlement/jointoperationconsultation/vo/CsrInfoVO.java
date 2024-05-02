/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CsrInfoVO.java
*@FileTitle : CsrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.12.16 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CsrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CsrInfoVO> models = new ArrayList<CsrInfoVO>();
	
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String csrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String frDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CsrInfoVO() {}

	public CsrInfoVO(String ibflag, String pagerows, String gubun, String frDt, String toDt, String slpOfcCd, String csrNo, String updUsrId) {
		this.toDt = toDt;
		this.csrNo = csrNo;
		this.ibflag = ibflag;
		this.gubun = gubun;
		this.frDt = frDt;
		this.updUsrId = updUsrId;
		this.slpOfcCd = slpOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
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
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
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
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
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
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setFrDt(JSPUtil.getParameter(request, "fr_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CsrInfoVO[]
	 */
	public CsrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CsrInfoVO[]
	 */
	public CsrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CsrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CsrInfoVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCsrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CsrInfoVO[]
	 */
	public CsrInfoVO[] getCsrInfoVOs(){
		CsrInfoVO[] vos = (CsrInfoVO[])models.toArray(new CsrInfoVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
