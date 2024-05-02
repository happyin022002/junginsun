/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ComboVO.java
*@FileTitle : ComboVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.09.30 이행지 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.common.vo;

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
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComboVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComboVO> models = new ArrayList<ComboVO>();
	
	/* Column Info */
	private String toMon = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String fmMon = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmWk = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bsaOpCd = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String toWk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComboVO() {}

	public ComboVO(String ibflag, String pagerows, String vvdCd, String trdCd, String bsaOpCd, String portCd, String code, String gubun, String year, String fmMon, String toMon, String fmWk, String toWk) {
		this.toMon = toMon;
		this.gubun = gubun;
		this.trdCd = trdCd;
		this.code = code;
		this.fmMon = fmMon;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fmWk = fmWk;
		this.vvdCd = vvdCd;
		this.bsaOpCd = bsaOpCd;
		this.year = year;
		this.portCd = portCd;
		this.toWk = toWk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_mon", getToMon());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("fm_mon", getFmMon());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_wk", getFmWk());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bsa_op_cd", getBsaOpCd());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("to_wk", getToWk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_mon", "toMon");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("code", "code");
		this.hashFields.put("fm_mon", "fmMon");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_wk", "fmWk");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bsa_op_cd", "bsaOpCd");
		this.hashFields.put("year", "year");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("to_wk", "toWk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toMon
	 */
	public String getToMon() {
		return this.toMon;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return fmMon
	 */
	public String getFmMon() {
		return this.fmMon;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return fmWk
	 */
	public String getFmWk() {
		return this.fmWk;
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
	 * @return bsaOpCd
	 */
	public String getBsaOpCd() {
		return this.bsaOpCd;
	}
	
	/**
	 * Column Info
	 * @return year
	 */
	public String getYear() {
		return this.year;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return toWk
	 */
	public String getToWk() {
		return this.toWk;
	}
	

	/**
	 * Column Info
	 * @param toMon
	 */
	public void setToMon(String toMon) {
		this.toMon = toMon;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param fmMon
	 */
	public void setFmMon(String fmMon) {
		this.fmMon = fmMon;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param fmWk
	 */
	public void setFmWk(String fmWk) {
		this.fmWk = fmWk;
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
	 * @param bsaOpCd
	 */
	public void setBsaOpCd(String bsaOpCd) {
		this.bsaOpCd = bsaOpCd;
	}
	
	/**
	 * Column Info
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param toWk
	 */
	public void setToWk(String toWk) {
		this.toWk = toWk;
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
		setToMon(JSPUtil.getParameter(request, prefix + "to_mon", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setFmMon(JSPUtil.getParameter(request, prefix + "fm_mon", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmWk(JSPUtil.getParameter(request, prefix + "fm_wk", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setBsaOpCd(JSPUtil.getParameter(request, prefix + "bsa_op_cd", ""));
		setYear(JSPUtil.getParameter(request, prefix + "year", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setToWk(JSPUtil.getParameter(request, prefix + "to_wk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComboVO[]
	 */
	public ComboVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComboVO[]
	 */
	public ComboVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComboVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toMon = (JSPUtil.getParameter(request, prefix	+ "to_mon", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] fmMon = (JSPUtil.getParameter(request, prefix	+ "fm_mon", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmWk = (JSPUtil.getParameter(request, prefix	+ "fm_wk", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] bsaOpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_cd", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] toWk = (JSPUtil.getParameter(request, prefix	+ "to_wk", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComboVO();
				if (toMon[i] != null)
					model.setToMon(toMon[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (fmMon[i] != null)
					model.setFmMon(fmMon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmWk[i] != null)
					model.setFmWk(fmWk[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (bsaOpCd[i] != null)
					model.setBsaOpCd(bsaOpCd[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (toWk[i] != null)
					model.setToWk(toWk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComboVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComboVO[]
	 */
	public ComboVO[] getComboVOs(){
		ComboVO[] vos = (ComboVO[])models.toArray(new ComboVO[models.size()]);
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
		this.toMon = this.toMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMon = this.fmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWk = this.fmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpCd = this.bsaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWk = this.toWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
