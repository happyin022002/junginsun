/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArOfcApplDtVO.java
*@FileTitle : ArOfcApplDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.23 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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

public class ArOfcApplDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArOfcApplDtVO> models = new ArrayList<ArOfcApplDtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aplyDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String cutOffAplyDtTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArOfcApplDtVO() {}

	public ArOfcApplDtVO(String ibflag, String pagerows, String cutOffAplyDtTpCd, String aplyDt, String arOfcCd) {
		this.ibflag = ibflag;
		this.aplyDt = aplyDt;
		this.arOfcCd = arOfcCd;
		this.cutOffAplyDtTpCd = cutOffAplyDtTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aply_dt", getAplyDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cut_off_aply_dt_tp_cd", getCutOffAplyDtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aply_dt", "aplyDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cut_off_aply_dt_tp_cd", "cutOffAplyDtTpCd");
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
	 * @return aplyDt
	 */
	public String getAplyDt() {
		return this.aplyDt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cutOffAplyDtTpCd
	 */
	public String getCutOffAplyDtTpCd() {
		return this.cutOffAplyDtTpCd;
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
	 * @param aplyDt
	 */
	public void setAplyDt(String aplyDt) {
		this.aplyDt = aplyDt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cutOffAplyDtTpCd
	 */
	public void setCutOffAplyDtTpCd(String cutOffAplyDtTpCd) {
		this.cutOffAplyDtTpCd = cutOffAplyDtTpCd;
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
		setAplyDt(JSPUtil.getParameter(request, "aply_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setCutOffAplyDtTpCd(JSPUtil.getParameter(request, "cut_off_aply_dt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArOfcApplDtVO[]
	 */
	public ArOfcApplDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArOfcApplDtVO[]
	 */
	public ArOfcApplDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArOfcApplDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aplyDt = (JSPUtil.getParameter(request, prefix	+ "aply_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] cutOffAplyDtTpCd = (JSPUtil.getParameter(request, prefix	+ "cut_off_aply_dt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArOfcApplDtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aplyDt[i] != null)
					model.setAplyDt(aplyDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (cutOffAplyDtTpCd[i] != null)
					model.setCutOffAplyDtTpCd(cutOffAplyDtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArOfcApplDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArOfcApplDtVO[]
	 */
	public ArOfcApplDtVO[] getArOfcApplDtVOs(){
		ArOfcApplDtVO[] vos = (ArOfcApplDtVO[])models.toArray(new ArOfcApplDtVO[models.size()]);
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
		this.aplyDt = this.aplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cutOffAplyDtTpCd = this.cutOffAplyDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
