/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchOneTimeSndHistVO.java
*@FileTitle : SearchOneTimeSndHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.dwellnotification.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOneTimeSndHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOneTimeSndHistVO> models = new ArrayList<SearchOneTimeSndHistVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String subscEml = null;
	/* Column Info */
	private String sndOptCd = null;
	/* Column Info */
	private String dwllTmTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOneTimeSndHistVO() {}

	public SearchOneTimeSndHistVO(String ibflag, String pagerows, String cntrNo, String bkgNo, String emlSndDt, String custCd, String subscEml, String dwllTmTpCd, String sndOptCd) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.emlSndDt = emlSndDt;
		this.custCd = custCd;
		this.cntrNo = cntrNo;
		this.subscEml = subscEml;
		this.sndOptCd = sndOptCd;
		this.dwllTmTpCd = dwllTmTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("subsc_eml", getSubscEml());
		this.hashColumns.put("snd_opt_cd", getSndOptCd());
		this.hashColumns.put("dwll_tm_tp_cd", getDwllTmTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("subsc_eml", "subscEml");
		this.hashFields.put("snd_opt_cd", "sndOptCd");
		this.hashFields.put("dwll_tm_tp_cd", "dwllTmTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
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
	 * @return subscEml
	 */
	public String getSubscEml() {
		return this.subscEml;
	}
	
	/**
	 * Column Info
	 * @return sndOptCd
	 */
	public String getSndOptCd() {
		return this.sndOptCd;
	}
	
	/**
	 * Column Info
	 * @return dwllTmTpCd
	 */
	public String getDwllTmTpCd() {
		return this.dwllTmTpCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
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
	 * @param subscEml
	 */
	public void setSubscEml(String subscEml) {
		this.subscEml = subscEml;
	}
	
	/**
	 * Column Info
	 * @param sndOptCd
	 */
	public void setSndOptCd(String sndOptCd) {
		this.sndOptCd = sndOptCd;
	}
	
	/**
	 * Column Info
	 * @param dwllTmTpCd
	 */
	public void setDwllTmTpCd(String dwllTmTpCd) {
		this.dwllTmTpCd = dwllTmTpCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSubscEml(JSPUtil.getParameter(request, prefix + "subsc_eml", ""));
		setSndOptCd(JSPUtil.getParameter(request, prefix + "snd_opt_cd", ""));
		setDwllTmTpCd(JSPUtil.getParameter(request, prefix + "dwll_tm_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOneTimeSndHistVO[]
	 */
	public SearchOneTimeSndHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOneTimeSndHistVO[]
	 */
	public SearchOneTimeSndHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOneTimeSndHistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] subscEml = (JSPUtil.getParameter(request, prefix	+ "subsc_eml", length));
			String[] sndOptCd = (JSPUtil.getParameter(request, prefix	+ "snd_opt_cd", length));
			String[] dwllTmTpCd = (JSPUtil.getParameter(request, prefix	+ "dwll_tm_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOneTimeSndHistVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (subscEml[i] != null)
					model.setSubscEml(subscEml[i]);
				if (sndOptCd[i] != null)
					model.setSndOptCd(sndOptCd[i]);
				if (dwllTmTpCd[i] != null)
					model.setDwllTmTpCd(dwllTmTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOneTimeSndHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOneTimeSndHistVO[]
	 */
	public SearchOneTimeSndHistVO[] getSearchOneTimeSndHistVOs(){
		SearchOneTimeSndHistVO[] vos = (SearchOneTimeSndHistVO[])models.toArray(new SearchOneTimeSndHistVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscEml = this.subscEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOptCd = this.sndOptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllTmTpCd = this.dwllTmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
