/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TaiwanSearchEstimateDtVO.java
*@FileTitle : TaiwanSearchEstimateDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo;

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

public class TaiwanSearchEstimateDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaiwanSearchEstimateDtVO> models = new ArrayList<TaiwanSearchEstimateDtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String conVvd = null;
	/* Column Info */
	private String etdDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TaiwanSearchEstimateDtVO() {}

	public TaiwanSearchEstimateDtVO(String ibflag, String pagerows, String etaDt, String etdDt, String conVvd) {
		this.ibflag = ibflag;
		this.etaDt = etaDt;
		this.conVvd = conVvd;
		this.etdDt = etdDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("con_vvd", getConVvd());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("con_vvd", "conVvd");
		this.hashFields.put("etd_dt", "etdDt");
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
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return conVvd
	 */
	public String getConVvd() {
		return this.conVvd;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param conVvd
	 */
	public void setConVvd(String conVvd) {
		this.conVvd = conVvd;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setConVvd(JSPUtil.getParameter(request, prefix + "con_vvd", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaiwanSearchEstimateDtVO[]
	 */
	public TaiwanSearchEstimateDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TaiwanSearchEstimateDtVO[]
	 */
	public TaiwanSearchEstimateDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaiwanSearchEstimateDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] conVvd = (JSPUtil.getParameter(request, prefix	+ "con_vvd", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TaiwanSearchEstimateDtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (conVvd[i] != null)
					model.setConVvd(conVvd[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaiwanSearchEstimateDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaiwanSearchEstimateDtVO[]
	 */
	public TaiwanSearchEstimateDtVO[] getTaiwanSearchEstimateDtVOs(){
		TaiwanSearchEstimateDtVO[] vos = (TaiwanSearchEstimateDtVO[])models.toArray(new TaiwanSearchEstimateDtVO[models.size()]);
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
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conVvd = this.conVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
