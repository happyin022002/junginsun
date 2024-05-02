/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandCstmsVvdInfoCondVO.java
*@FileTitle : NewZealandCstmsVvdInfoCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NewZealandCstmsVvdInfoCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NewZealandCstmsVvdInfoCondVO> models = new ArrayList<NewZealandCstmsVvdInfoCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String ssrNo = null;
	/* Column Info */
	private String vvdNm = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public NewZealandCstmsVvdInfoCondVO() {}

	public NewZealandCstmsVvdInfoCondVO(String ibflag, String pagerows, String vvd, String etaDt, String pol, String pod, String vvdNm, String ssrNo) {
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.etaDt = etaDt;
		this.pol = pol;
		this.ssrNo = ssrNo;
		this.vvdNm = vvdNm;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("ssr_no", getSsrNo());
		this.hashColumns.put("vvd_nm", getVvdNm());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("ssr_no", "ssrNo");
		this.hashFields.put("vvd_nm", "vvdNm");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return ssrNo
	 */
	public String getSsrNo() {
		return this.ssrNo;
	}
	
	/**
	 * Column Info
	 * @return vvdNm
	 */
	public String getVvdNm() {
		return this.vvdNm;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param ssrNo
	 */
	public void setSsrNo(String ssrNo) {
		this.ssrNo = ssrNo;
	}
	
	/**
	 * Column Info
	 * @param vvdNm
	 */
	public void setVvdNm(String vvdNm) {
		this.vvdNm = vvdNm;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setSsrNo(JSPUtil.getParameter(request, prefix + "ssr_no", ""));
		setVvdNm(JSPUtil.getParameter(request, prefix + "vvd_nm", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NewZealandCstmsVvdInfoCondVO[]
	 */
	public NewZealandCstmsVvdInfoCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NewZealandCstmsVvdInfoCondVO[]
	 */
	public NewZealandCstmsVvdInfoCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NewZealandCstmsVvdInfoCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] ssrNo = (JSPUtil.getParameter(request, prefix	+ "ssr_no", length));
			String[] vvdNm = (JSPUtil.getParameter(request, prefix	+ "vvd_nm", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new NewZealandCstmsVvdInfoCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (ssrNo[i] != null)
					model.setSsrNo(ssrNo[i]);
				if (vvdNm[i] != null)
					model.setVvdNm(vvdNm[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNewZealandCstmsVvdInfoCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NewZealandCstmsVvdInfoCondVO[]
	 */
	public NewZealandCstmsVvdInfoCondVO[] getNewZealandCstmsVvdInfoCondVOs(){
		NewZealandCstmsVvdInfoCondVO[] vos = (NewZealandCstmsVvdInfoCondVO[])models.toArray(new NewZealandCstmsVvdInfoCondVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssrNo = this.ssrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNm = this.vvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
