/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchDwellVO.java
*@FileTitle : SearchDwellVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.30  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.dwellnotification.vo;

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

public class SearchDwellVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDwellVO> models = new ArrayList<SearchDwellVO>();
	
	/* Column Info */
	private String railDest = null;
	/* Column Info */
	private String cntrList = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String railSoFlg = null;
	/* Column Info */
	private String dwllTmTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sent = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String scNo2 = null;
	/* Column Info */
	private String searchDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchDwellVO() {}

	public SearchDwellVO(String ibflag, String pagerows, String vvd, String podCd, String sent, String bkgNo, String railDest, String cntrNo, String scNo, String scNo2, String dwllTmTpCd, String searchDt, String blNo, String railSoFlg, String delCd, String cntrNo1, String cntrList, String custCd, String propOfcCd, String ctrtOfcCd) {
		this.railDest = railDest;
		this.cntrList = cntrList;
		this.delCd = delCd;
		this.railSoFlg = railSoFlg;
		this.dwllTmTpCd = dwllTmTpCd;
		this.blNo = blNo;
		this.cntrNo1 = cntrNo1;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.sent = sent;
		this.bkgNo = bkgNo;
		this.propOfcCd = propOfcCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.custCd = custCd;
		this.cntrNo = cntrNo;
		this.scNo = scNo;
		this.scNo2 = scNo2;
		this.searchDt = searchDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rail_dest", getRailDest());
		this.hashColumns.put("cntr_list", getCntrList());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rail_so_flg", getRailSoFlg());
		this.hashColumns.put("dwll_tm_tp_cd", getDwllTmTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_no1", getCntrNo1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sent", getSent());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("sc_no2", getScNo2());
		this.hashColumns.put("search_dt", getSearchDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rail_dest", "railDest");
		this.hashFields.put("cntr_list", "cntrList");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rail_so_flg", "railSoFlg");
		this.hashFields.put("dwll_tm_tp_cd", "dwllTmTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_no1", "cntrNo1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sent", "sent");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("sc_no2", "scNo2");
		this.hashFields.put("search_dt", "searchDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return railDest
	 */
	public String getRailDest() {
		return this.railDest;
	}
	
	/**
	 * Column Info
	 * @return cntrList
	 */
	public String getCntrList() {
		return this.cntrList;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return railSoFlg
	 */
	public String getRailSoFlg() {
		return this.railSoFlg;
	}
	
	/**
	 * Column Info
	 * @return dwllTmTpCd
	 */
	public String getDwllTmTpCd() {
		return this.dwllTmTpCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo1
	 */
	public String getCntrNo1() {
		return this.cntrNo1;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return sent
	 */
	public String getSent() {
		return this.sent;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return scNo2
	 */
	public String getScNo2() {
		return this.scNo2;
	}
	
	/**
	 * Column Info
	 * @return searchDt
	 */
	public String getSearchDt() {
		return this.searchDt;
	}
	

	/**
	 * Column Info
	 * @param railDest
	 */
	public void setRailDest(String railDest) {
		this.railDest = railDest;
	}
	
	/**
	 * Column Info
	 * @param cntrList
	 */
	public void setCntrList(String cntrList) {
		this.cntrList = cntrList;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param railSoFlg
	 */
	public void setRailSoFlg(String railSoFlg) {
		this.railSoFlg = railSoFlg;
	}
	
	/**
	 * Column Info
	 * @param dwllTmTpCd
	 */
	public void setDwllTmTpCd(String dwllTmTpCd) {
		this.dwllTmTpCd = dwllTmTpCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo1
	 */
	public void setCntrNo1(String cntrNo1) {
		this.cntrNo1 = cntrNo1;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param sent
	 */
	public void setSent(String sent) {
		this.sent = sent;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param scNo2
	 */
	public void setScNo2(String scNo2) {
		this.scNo2 = scNo2;
	}
	
	/**
	 * Column Info
	 * @param searchDt
	 */
	public void setSearchDt(String searchDt) {
		this.searchDt = searchDt;
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
		setRailDest(JSPUtil.getParameter(request, prefix + "rail_dest", ""));
		setCntrList(JSPUtil.getParameter(request, prefix + "cntr_list", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setRailSoFlg(JSPUtil.getParameter(request, prefix + "rail_so_flg", ""));
		setDwllTmTpCd(JSPUtil.getParameter(request, prefix + "dwll_tm_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrNo1(JSPUtil.getParameter(request, prefix + "cntr_no1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSent(JSPUtil.getParameter(request, prefix + "sent", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setScNo2(JSPUtil.getParameter(request, prefix + "sc_no2", ""));
		setSearchDt(JSPUtil.getParameter(request, prefix + "search_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDwellVO[]
	 */
	public SearchDwellVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDwellVO[]
	 */
	public SearchDwellVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDwellVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] railDest = (JSPUtil.getParameter(request, prefix	+ "rail_dest", length));
			String[] cntrList = (JSPUtil.getParameter(request, prefix	+ "cntr_list", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] railSoFlg = (JSPUtil.getParameter(request, prefix	+ "rail_so_flg", length));
			String[] dwllTmTpCd = (JSPUtil.getParameter(request, prefix	+ "dwll_tm_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sent = (JSPUtil.getParameter(request, prefix	+ "sent", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] scNo2 = (JSPUtil.getParameter(request, prefix	+ "sc_no2", length));
			String[] searchDt = (JSPUtil.getParameter(request, prefix	+ "search_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDwellVO();
				if (railDest[i] != null)
					model.setRailDest(railDest[i]);
				if (cntrList[i] != null)
					model.setCntrList(cntrList[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (railSoFlg[i] != null)
					model.setRailSoFlg(railSoFlg[i]);
				if (dwllTmTpCd[i] != null)
					model.setDwllTmTpCd(dwllTmTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sent[i] != null)
					model.setSent(sent[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (scNo2[i] != null)
					model.setScNo2(scNo2[i]);
				if (searchDt[i] != null)
					model.setSearchDt(searchDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDwellVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDwellVO[]
	 */
	public SearchDwellVO[] getSearchDwellVOs(){
		SearchDwellVO[] vos = (SearchDwellVO[])models.toArray(new SearchDwellVO[models.size()]);
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
		this.railDest = this.railDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrList = this.cntrList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railSoFlg = this.railSoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllTmTpCd = this.dwllTmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sent = this.sent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo2 = this.scNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDt = this.searchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
