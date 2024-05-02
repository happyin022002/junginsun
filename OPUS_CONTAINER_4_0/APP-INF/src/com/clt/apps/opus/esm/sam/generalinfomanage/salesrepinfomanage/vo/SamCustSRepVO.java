/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SamCustSRepVO.java
*@FileTitle : SamCustSRepVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.02.23 서미진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamCustSRepVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamCustSRepVO> models = new ArrayList<SamCustSRepVO>();
	
	/* Column Info */
	private String openPage = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String empeCd = null;
	/* Column Info */
	private String custOffice = null;
	/* Column Info */
	private String srepEml = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String srepPrmryFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcTeamCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ib = null;
	/* Column Info */
	private String ob = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String custStatus = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamCustSRepVO() {}

	public SamCustSRepVO(String ibflag, String pagerows, String srepCd, String srepEml, String srepNm, String empeCd, String ofcCd, String ofcTeamCd, String ib, String ob, String deltFlg, String openPage, String custOffice, String custCd, String custStatus, String srepPrmryFlg) {
		this.openPage = openPage;
		this.deltFlg = deltFlg;
		this.empeCd = empeCd;
		this.custOffice = custOffice;
		this.srepEml = srepEml;
		this.srepCd = srepCd;
		this.srepPrmryFlg = srepPrmryFlg;
		this.pagerows = pagerows;
		this.ofcTeamCd = ofcTeamCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.ib = ib;
		this.ob = ob;
		this.custCd = custCd;
		this.srepNm = srepNm;
		this.custStatus = custStatus;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("open_page", getOpenPage());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("empe_cd", getEmpeCd());
		this.hashColumns.put("cust_office", getCustOffice());
		this.hashColumns.put("srep_eml", getSrepEml());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("srep_prmry_flg", getSrepPrmryFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_team_cd", getOfcTeamCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ib", getIb());
		this.hashColumns.put("ob", getOb());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("cust_status", getCustStatus());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("open_page", "openPage");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("empe_cd", "empeCd");
		this.hashFields.put("cust_office", "custOffice");
		this.hashFields.put("srep_eml", "srepEml");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("srep_prmry_flg", "srepPrmryFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_team_cd", "ofcTeamCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ib", "ib");
		this.hashFields.put("ob", "ob");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("cust_status", "custStatus");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return openPage
	 */
	public String getOpenPage() {
		return this.openPage;
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
	 * @return custOffice
	 */
	public String getCustOffice() {
		return this.custOffice;
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
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return srepPrmryFlg
	 */
	public String getSrepPrmryFlg() {
		return this.srepPrmryFlg;
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
	 * @return ib
	 */
	public String getIb() {
		return this.ib;
	}
	
	/**
	 * Column Info
	 * @return ob
	 */
	public String getOb() {
		return this.ob;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return custStatus
	 */
	public String getCustStatus() {
		return this.custStatus;
	}
	

	/**
	 * Column Info
	 * @param openPage
	 */
	public void setOpenPage(String openPage) {
		this.openPage = openPage;
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
	 * @param custOffice
	 */
	public void setCustOffice(String custOffice) {
		this.custOffice = custOffice;
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
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param srepPrmryFlg
	 */
	public void setSrepPrmryFlg(String srepPrmryFlg) {
		this.srepPrmryFlg = srepPrmryFlg;
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
	 * @param ib
	 */
	public void setIb(String ib) {
		this.ib = ib;
	}
	
	/**
	 * Column Info
	 * @param ob
	 */
	public void setOb(String ob) {
		this.ob = ob;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param custStatus
	 */
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
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
		setOpenPage(JSPUtil.getParameter(request, prefix + "open_page", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEmpeCd(JSPUtil.getParameter(request, prefix + "empe_cd", ""));
		setCustOffice(JSPUtil.getParameter(request, prefix + "cust_office", ""));
		setSrepEml(JSPUtil.getParameter(request, prefix + "srep_eml", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setSrepPrmryFlg(JSPUtil.getParameter(request, prefix + "srep_prmry_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcTeamCd(JSPUtil.getParameter(request, prefix + "ofc_team_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIb(JSPUtil.getParameter(request, prefix + "ib", ""));
		setOb(JSPUtil.getParameter(request, prefix + "ob", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setCustStatus(JSPUtil.getParameter(request, prefix + "cust_status", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamCustSRepVO[]
	 */
	public SamCustSRepVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamCustSRepVO[]
	 */
	public SamCustSRepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamCustSRepVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] openPage = (JSPUtil.getParameter(request, prefix	+ "open_page", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] empeCd = (JSPUtil.getParameter(request, prefix	+ "empe_cd", length));
			String[] custOffice = (JSPUtil.getParameter(request, prefix	+ "cust_office", length));
			String[] srepEml = (JSPUtil.getParameter(request, prefix	+ "srep_eml", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] srepPrmryFlg = (JSPUtil.getParameter(request, prefix	+ "srep_prmry_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcTeamCd = (JSPUtil.getParameter(request, prefix	+ "ofc_team_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ib = (JSPUtil.getParameter(request, prefix	+ "ib", length));
			String[] ob = (JSPUtil.getParameter(request, prefix	+ "ob", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] custStatus = (JSPUtil.getParameter(request, prefix	+ "cust_status", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamCustSRepVO();
				if (openPage[i] != null)
					model.setOpenPage(openPage[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (empeCd[i] != null)
					model.setEmpeCd(empeCd[i]);
				if (custOffice[i] != null)
					model.setCustOffice(custOffice[i]);
				if (srepEml[i] != null)
					model.setSrepEml(srepEml[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (srepPrmryFlg[i] != null)
					model.setSrepPrmryFlg(srepPrmryFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcTeamCd[i] != null)
					model.setOfcTeamCd(ofcTeamCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ib[i] != null)
					model.setIb(ib[i]);
				if (ob[i] != null)
					model.setOb(ob[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (custStatus[i] != null)
					model.setCustStatus(custStatus[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamCustSRepVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamCustSRepVO[]
	 */
	public SamCustSRepVO[] getSamCustSRepVOs(){
		SamCustSRepVO[] vos = (SamCustSRepVO[])models.toArray(new SamCustSRepVO[models.size()]);
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
		this.openPage = this.openPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empeCd = this.empeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custOffice = this.custOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepEml = this.srepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepPrmryFlg = this.srepPrmryFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTeamCd = this.ofcTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ib = this.ib .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ob = this.ob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStatus = this.custStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
