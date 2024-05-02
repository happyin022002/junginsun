/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SitProRateAmountTTLVO.java
*@FileTitle : SitProRateAmountTTLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.12 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SitProRateAmountTTLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProRateAmountTTLVO> models = new ArrayList<SitProRateAmountTTLVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cctTotal = null;
	/* Column Info */
	private String totalCur = null;
	/* Column Info */
	private String ppdTotal = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SitProRateAmountTTLVO() {}

	public SitProRateAmountTTLVO(String ibflag, String pagerows, String ppdTotal, String cctTotal, String totalCur) {
		this.ibflag = ibflag;
		this.cctTotal = cctTotal;
		this.totalCur = totalCur;
		this.ppdTotal = ppdTotal;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cct_total", getCctTotal());
		this.hashColumns.put("total_cur", getTotalCur());
		this.hashColumns.put("ppd_total", getPpdTotal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cct_total", "cctTotal");
		this.hashFields.put("total_cur", "totalCur");
		this.hashFields.put("ppd_total", "ppdTotal");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return cctTotal
	 */
	public String getCctTotal() {
		return this.cctTotal;
	}
	
	/**
	 * Column Info
	 * @return totalCur
	 */
	public String getTotalCur() {
		return this.totalCur;
	}
	
	/**
	 * Column Info
	 * @return ppdTotal
	 */
	public String getPpdTotal() {
		return this.ppdTotal;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param cctTotal
	 */
	public void setCctTotal(String cctTotal) {
		this.cctTotal = cctTotal;
	}
	
	/**
	 * Column Info
	 * @param totalCur
	 */
	public void setTotalCur(String totalCur) {
		this.totalCur = totalCur;
	}
	
	/**
	 * Column Info
	 * @param ppdTotal
	 */
	public void setPpdTotal(String ppdTotal) {
		this.ppdTotal = ppdTotal;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCctTotal(JSPUtil.getParameter(request, "cct_total", ""));
		setTotalCur(JSPUtil.getParameter(request, "total_cur", ""));
		setPpdTotal(JSPUtil.getParameter(request, "ppd_total", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProRateAmountTTLVO[]
	 */
	public SitProRateAmountTTLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProRateAmountTTLVO[]
	 */
	public SitProRateAmountTTLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProRateAmountTTLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cctTotal = (JSPUtil.getParameter(request, prefix	+ "cct_total", length));
			String[] totalCur = (JSPUtil.getParameter(request, prefix	+ "total_cur", length));
			String[] ppdTotal = (JSPUtil.getParameter(request, prefix	+ "ppd_total", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SitProRateAmountTTLVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cctTotal[i] != null)
					model.setCctTotal(cctTotal[i]);
				if (totalCur[i] != null)
					model.setTotalCur(totalCur[i]);
				if (ppdTotal[i] != null)
					model.setPpdTotal(ppdTotal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProRateAmountTTLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProRateAmountTTLVO[]
	 */
	public SitProRateAmountTTLVO[] getSitProRateAmountTTLVOs(){
		SitProRateAmountTTLVO[] vos = (SitProRateAmountTTLVO[])models.toArray(new SitProRateAmountTTLVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctTotal = this.cctTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCur = this.totalCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdTotal = this.ppdTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
