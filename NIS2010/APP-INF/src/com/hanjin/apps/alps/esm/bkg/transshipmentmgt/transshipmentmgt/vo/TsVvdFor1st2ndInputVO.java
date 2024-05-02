/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TsVvdFor1st2ndInputVO.java
*@FileTitle : TsVvdFor1st2ndInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2010.01.08 최영희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TsVvdFor1st2ndInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TsVvdFor1st2ndInputVO> models = new ArrayList<TsVvdFor1st2ndInputVO>();
	
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String locYdCd = null;
	/* Column Info */
	private String vpsDtFlag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TsVvdFor1st2ndInputVO() {}

	public TsVvdFor1st2ndInputVO(String ibflag, String pagerows, String locCd, String vpsEtdDt, String locYdCd, String vpsDtFlag) {
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.vpsEtdDt = vpsEtdDt;
		this.locYdCd = locYdCd;
		this.vpsDtFlag = vpsDtFlag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("loc_yd_cd", getLocYdCd());
		this.hashColumns.put("vps_dt_flag", getVpsDtFlag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("loc_yd_cd", "locYdCd");
		this.hashFields.put("vps_dt_flag", "vpsDtFlag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return locYdCd
	 */
	public String getLocYdCd() {
		return this.locYdCd;
	}
	
	/**
	 * Column Info
	 * @return vpsDtFlag
	 */
	public String getVpsDtFlag() {
		return this.vpsDtFlag;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param locYdCd
	 */
	public void setLocYdCd(String locYdCd) {
		this.locYdCd = locYdCd;
	}
	
	/**
	 * Column Info
	 * @param vpsDtFlag
	 */
	public void setVpsDtFlag(String vpsDtFlag) {
		this.vpsDtFlag = vpsDtFlag;
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
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setLocYdCd(JSPUtil.getParameter(request, prefix + "loc_yd_cd", ""));
		setVpsDtFlag(JSPUtil.getParameter(request, prefix + "vps_dt_flag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TsVvdFor1st2ndInputVO[]
	 */
	public TsVvdFor1st2ndInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TsVvdFor1st2ndInputVO[]
	 */
	public TsVvdFor1st2ndInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TsVvdFor1st2ndInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] locYdCd = (JSPUtil.getParameter(request, prefix	+ "loc_yd_cd", length));
			String[] vpsDtFlag = (JSPUtil.getParameter(request, prefix	+ "vps_dt_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TsVvdFor1st2ndInputVO();
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (locYdCd[i] != null)
					model.setLocYdCd(locYdCd[i]);
				if (vpsDtFlag[i] != null)
					model.setVpsDtFlag(vpsDtFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTsVvdFor1st2ndInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TsVvdFor1st2ndInputVO[]
	 */
	public TsVvdFor1st2ndInputVO[] getTsVvdFor1st2ndInputVOs(){
		TsVvdFor1st2ndInputVO[] vos = (TsVvdFor1st2ndInputVO[])models.toArray(new TsVvdFor1st2ndInputVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locYdCd = this.locYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsDtFlag = this.vpsDtFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
