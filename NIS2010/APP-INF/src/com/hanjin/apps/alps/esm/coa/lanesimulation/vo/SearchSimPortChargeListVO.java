/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSimPortChargeListVO.java
*@FileTitle : SearchSimPortChargeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.05.03 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.lanesimulation.vo;

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
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimPortChargeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimPortChargeListVO> models = new ArrayList<SearchSimPortChargeListVO>();
	
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String portTrfAmt = null;
	/* Column Info */
	private String cnlFeeAmt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String tmlCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimPortChargeListVO() {}

	public SearchSimPortChargeListVO(String ibflag, String pagerows, String simDt, String simNo, String portCd, String ydCd, String tmlCd, String portSeq, String vslClssCapa, String portTrfAmt, String cnlFeeAmt) {
		this.portSeq = portSeq;
		this.ibflag = ibflag;
		this.portTrfAmt = portTrfAmt;
		this.cnlFeeAmt = cnlFeeAmt;
		this.ydCd = ydCd;
		this.simDt = simDt;
		this.vslClssCapa = vslClssCapa;
		this.portCd = portCd;
		this.simNo = simNo;
		this.tmlCd = tmlCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("port_trf_amt", getPortTrfAmt());
		this.hashColumns.put("cnl_fee_amt", getCnlFeeAmt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port_trf_amt", "portTrfAmt");
		this.hashFields.put("cnl_fee_amt", "cnlFeeAmt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return portTrfAmt
	 */
	public String getPortTrfAmt() {
		return this.portTrfAmt;
	}
	
	/**
	 * Column Info
	 * @return cnlFeeAmt
	 */
	public String getCnlFeeAmt() {
		return this.cnlFeeAmt;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return simDt
	 */
	public String getSimDt() {
		return this.simDt;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
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
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
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
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param portTrfAmt
	 */
	public void setPortTrfAmt(String portTrfAmt) {
		this.portTrfAmt = portTrfAmt;
	}
	
	/**
	 * Column Info
	 * @param cnlFeeAmt
	 */
	public void setCnlFeeAmt(String cnlFeeAmt) {
		this.cnlFeeAmt = cnlFeeAmt;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param simDt
	 */
	public void setSimDt(String simDt) {
		this.simDt = simDt;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
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
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
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
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPortTrfAmt(JSPUtil.getParameter(request, prefix + "port_trf_amt", ""));
		setCnlFeeAmt(JSPUtil.getParameter(request, prefix + "cnl_fee_amt", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setSimDt(JSPUtil.getParameter(request, prefix + "sim_dt", ""));
		setVslClssCapa(JSPUtil.getParameter(request, prefix + "vsl_clss_capa", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setSimNo(JSPUtil.getParameter(request, prefix + "sim_no", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimPortChargeListVO[]
	 */
	public SearchSimPortChargeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimPortChargeListVO[]
	 */
	public SearchSimPortChargeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimPortChargeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] portTrfAmt = (JSPUtil.getParameter(request, prefix	+ "port_trf_amt", length));
			String[] cnlFeeAmt = (JSPUtil.getParameter(request, prefix	+ "cnl_fee_amt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "sim_dt", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimPortChargeListVO();
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (portTrfAmt[i] != null)
					model.setPortTrfAmt(portTrfAmt[i]);
				if (cnlFeeAmt[i] != null)
					model.setCnlFeeAmt(cnlFeeAmt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimPortChargeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimPortChargeListVO[]
	 */
	public SearchSimPortChargeListVO[] getSearchSimPortChargeListVOs(){
		SearchSimPortChargeListVO[] vos = (SearchSimPortChargeListVO[])models.toArray(new SearchSimPortChargeListVO[models.size()]);
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
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTrfAmt = this.portTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlFeeAmt = this.cnlFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
