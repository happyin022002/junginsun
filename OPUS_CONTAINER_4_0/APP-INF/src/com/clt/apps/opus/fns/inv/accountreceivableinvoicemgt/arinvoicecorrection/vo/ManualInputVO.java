/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualInputVO.java
*@FileTitle : ManualInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.27 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManualInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManualInputVO> models = new ArrayList<ManualInputVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String fmIfDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toIfDt = null;
	/* Column Info */
	private String trnkVvd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManualInputVO() {}

	public ManualInputVO(String ibflag, String pagerows, String fmIfDt, String toIfDt, String blSrcNo, String polCd, String podCd, String trnkVvd) {
		this.podCd = podCd;
		this.blSrcNo = blSrcNo;
		this.polCd = polCd;
		this.fmIfDt = fmIfDt;
		this.ibflag = ibflag;
		this.toIfDt = toIfDt;
		this.trnkVvd = trnkVvd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("fm_if_dt", getFmIfDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_if_dt", getToIfDt());
		this.hashColumns.put("trnk_vvd", getTrnkVvd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("fm_if_dt", "fmIfDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_if_dt", "toIfDt");
		this.hashFields.put("trnk_vvd", "trnkVvd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return fmIfDt
	 */
	public String getFmIfDt() {
		return this.fmIfDt;
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
	 * @return toIfDt
	 */
	public String getToIfDt() {
		return this.toIfDt;
	}
	
	/**
	 * Column Info
	 * @return trnkVvd
	 */
	public String getTrnkVvd() {
		return this.trnkVvd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param fmIfDt
	 */
	public void setFmIfDt(String fmIfDt) {
		this.fmIfDt = fmIfDt;
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
	 * @param toIfDt
	 */
	public void setToIfDt(String toIfDt) {
		this.toIfDt = toIfDt;
	}
	
	/**
	 * Column Info
	 * @param trnkVvd
	 */
	public void setTrnkVvd(String trnkVvd) {
		this.trnkVvd = trnkVvd;
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
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setFmIfDt(JSPUtil.getParameter(request, "fm_if_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToIfDt(JSPUtil.getParameter(request, "to_if_dt", ""));
		setTrnkVvd(JSPUtil.getParameter(request, "trnk_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManualInputVO[]
	 */
	public ManualInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManualInputVO[]
	 */
	public ManualInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManualInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] fmIfDt = (JSPUtil.getParameter(request, prefix	+ "fm_if_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toIfDt = (JSPUtil.getParameter(request, prefix	+ "to_if_dt", length));
			String[] trnkVvd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManualInputVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (fmIfDt[i] != null)
					model.setFmIfDt(fmIfDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toIfDt[i] != null)
					model.setToIfDt(toIfDt[i]);
				if (trnkVvd[i] != null)
					model.setTrnkVvd(trnkVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManualInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManualInputVO[]
	 */
	public ManualInputVO[] getManualInputVOs(){
		ManualInputVO[] vos = (ManualInputVO[])models.toArray(new ManualInputVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmIfDt = this.fmIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toIfDt = this.toIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvd = this.trnkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
