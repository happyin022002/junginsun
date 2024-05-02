/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayerInfoParamVO.java
*@FileTitle : PayerInfoParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.11.05 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PayerInfoParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayerInfoParamVO> models = new ArrayList<PayerInfoParamVO>();
	
	/* Column Info */
	private String sPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sCustGubun = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String sPodCntCd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String sCustCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PayerInfoParamVO() {}

	public PayerInfoParamVO(String ibflag, String pagerows, String sCustCd, String sOfcCd, String sBkgNo, String sPodCd, String sPodCntCd, String sCustGubun) {
		this.sPodCd = sPodCd;
		this.ibflag = ibflag;
		this.sCustGubun = sCustGubun;
		this.sBkgNo = sBkgNo;
		this.sPodCntCd = sPodCntCd;
		this.sOfcCd = sOfcCd;
		this.sCustCd = sCustCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_pod_cd", getSPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_cust_gubun", getSCustGubun());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("s_pod_cnt_cd", getSPodCntCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("s_cust_cd", getSCustCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_pod_cd", "sPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_cust_gubun", "sCustGubun");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("s_pod_cnt_cd", "sPodCntCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sPodCd
	 */
	public String getSPodCd() {
		return this.sPodCd;
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
	 * @return sCustGubun
	 */
	public String getSCustGubun() {
		return this.sCustGubun;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @return sPodCntCd
	 */
	public String getSPodCntCd() {
		return this.sPodCntCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sCustCd
	 */
	public String getSCustCd() {
		return this.sCustCd;
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
	 * @param sPodCd
	 */
	public void setSPodCd(String sPodCd) {
		this.sPodCd = sPodCd;
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
	 * @param sCustGubun
	 */
	public void setSCustGubun(String sCustGubun) {
		this.sCustGubun = sCustGubun;
	}
	
	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param sPodCntCd
	 */
	public void setSPodCntCd(String sPodCntCd) {
		this.sPodCntCd = sPodCntCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sCustCd
	 */
	public void setSCustCd(String sCustCd) {
		this.sCustCd = sCustCd;
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
		setSPodCd(JSPUtil.getParameter(request, "s_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSCustGubun(JSPUtil.getParameter(request, "s_cust_gubun", ""));
		setSBkgNo(JSPUtil.getParameter(request, "s_bkg_no", ""));
		setSPodCntCd(JSPUtil.getParameter(request, "s_pod_cnt_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, "s_ofc_cd", ""));
		setSCustCd(JSPUtil.getParameter(request, "s_cust_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayerInfoParamVO[]
	 */
	public PayerInfoParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayerInfoParamVO[]
	 */
	public PayerInfoParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayerInfoParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sPodCd = (JSPUtil.getParameter(request, prefix	+ "s_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sCustGubun = (JSPUtil.getParameter(request, prefix	+ "s_cust_gubun", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] sPodCntCd = (JSPUtil.getParameter(request, prefix	+ "s_pod_cnt_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] sCustCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PayerInfoParamVO();
				if (sPodCd[i] != null)
					model.setSPodCd(sPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sCustGubun[i] != null)
					model.setSCustGubun(sCustGubun[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (sPodCntCd[i] != null)
					model.setSPodCntCd(sPodCntCd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (sCustCd[i] != null)
					model.setSCustCd(sCustCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayerInfoParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayerInfoParamVO[]
	 */
	public PayerInfoParamVO[] getPayerInfoParamVOs(){
		PayerInfoParamVO[] vos = (PayerInfoParamVO[])models.toArray(new PayerInfoParamVO[models.size()]);
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
		this.sPodCd = this.sPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustGubun = this.sCustGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPodCntCd = this.sPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd = this.sCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
