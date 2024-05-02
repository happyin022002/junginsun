/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PCFStatusInfoInputVO.java
*@FileTitle : PCFStatusInfoInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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

public class PCFStatusInfoInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PCFStatusInfoInputVO> models = new ArrayList<PCFStatusInfoInputVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String toAtdDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chnAgnCd = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String fmAtdDt = null;
	/* Column Info */
	private String tmnlCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PCFStatusInfoInputVO() {}

	public PCFStatusInfoInputVO(String ibflag, String pagerows, String vvdCd, String polCd, String fmAtdDt, String toAtdDt, String tmnlCd, String chnAgnCd, String reDivrCd) {
		this.pagerows = pagerows;
		this.vvdCd = vvdCd;
		this.polCd = polCd;
		this.toAtdDt = toAtdDt;
		this.ibflag = ibflag;
		this.chnAgnCd = chnAgnCd;
		this.reDivrCd = reDivrCd;
		this.fmAtdDt = fmAtdDt;
		this.tmnlCd = tmnlCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("to_atd_dt", getToAtdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chn_agn_cd", getChnAgnCd());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("fm_atd_dt", getFmAtdDt());
		this.hashColumns.put("tmnl_cd", getTmnlCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("to_atd_dt", "toAtdDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chn_agn_cd", "chnAgnCd");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("fm_atd_dt", "fmAtdDt");
		this.hashFields.put("tmnl_cd", "tmnlCd");
		return this.hashFields;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return toAtdDt
	 */
	public String getToAtdDt() {
		return this.toAtdDt;
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
	 * @return chnAgnCd
	 */
	public String getChnAgnCd() {
		return this.chnAgnCd;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return fmAtdDt
	 */
	public String getFmAtdDt() {
		return this.fmAtdDt;
	}
	
	/**
	 * Column Info
	 * @return tmnlCd
	 */
	public String getTmnlCd() {
		return this.tmnlCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param toAtdDt
	 */
	public void setToAtdDt(String toAtdDt) {
		this.toAtdDt = toAtdDt;
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
	 * @param chnAgnCd
	 */
	public void setChnAgnCd(String chnAgnCd) {
		this.chnAgnCd = chnAgnCd;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param fmAtdDt
	 */
	public void setFmAtdDt(String fmAtdDt) {
		this.fmAtdDt = fmAtdDt;
	}
	
	/**
	 * Column Info
	 * @param tmnlCd
	 */
	public void setTmnlCd(String tmnlCd) {
		this.tmnlCd = tmnlCd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setToAtdDt(JSPUtil.getParameter(request, prefix + "to_atd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChnAgnCd(JSPUtil.getParameter(request, prefix + "chn_agn_cd", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setFmAtdDt(JSPUtil.getParameter(request, prefix + "fm_atd_dt", ""));
		setTmnlCd(JSPUtil.getParameter(request, prefix + "tmnl_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PCFStatusInfoInputVO[]
	 */
	public PCFStatusInfoInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PCFStatusInfoInputVO[]
	 */
	public PCFStatusInfoInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PCFStatusInfoInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] toAtdDt = (JSPUtil.getParameter(request, prefix	+ "to_atd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chnAgnCd = (JSPUtil.getParameter(request, prefix	+ "chn_agn_cd", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] fmAtdDt = (JSPUtil.getParameter(request, prefix	+ "fm_atd_dt", length));
			String[] tmnlCd = (JSPUtil.getParameter(request, prefix	+ "tmnl_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PCFStatusInfoInputVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (toAtdDt[i] != null)
					model.setToAtdDt(toAtdDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chnAgnCd[i] != null)
					model.setChnAgnCd(chnAgnCd[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (fmAtdDt[i] != null)
					model.setFmAtdDt(fmAtdDt[i]);
				if (tmnlCd[i] != null)
					model.setTmnlCd(tmnlCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPCFStatusInfoInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PCFStatusInfoInputVO[]
	 */
	public PCFStatusInfoInputVO[] getPCFStatusInfoInputVOs(){
		PCFStatusInfoInputVO[] vos = (PCFStatusInfoInputVO[])models.toArray(new PCFStatusInfoInputVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAtdDt = this.toAtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnAgnCd = this.chnAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAtdDt = this.fmAtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlCd = this.tmnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
