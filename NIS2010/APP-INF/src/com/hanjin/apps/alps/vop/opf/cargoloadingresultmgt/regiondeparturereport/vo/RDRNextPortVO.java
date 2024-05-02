/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRNextPortVO.java
*@FileTitle : RDRNextPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.12.21 장석현 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRNextPortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRNextPortVO> models = new ArrayList<RDRNextPortVO>();
	
	/* Column Info */
	private String etaCanal = null;
	/* Column Info */
	private String eta = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nextCanal = null;
	/* Column Info */
	private String nextPort = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRNextPortVO() {}

	public RDRNextPortVO(String ibflag, String pagerows, String nextPort, String eta, String nextCanal, String etaCanal) {
		this.etaCanal = etaCanal;
		this.eta = eta;
		this.ibflag = ibflag;
		this.nextCanal = nextCanal;
		this.nextPort = nextPort;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta_canal", getEtaCanal());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("next_canal", getNextCanal());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta_canal", "etaCanal");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("next_canal", "nextCanal");
		this.hashFields.put("next_port", "nextPort");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etaCanal
	 */
	public String getEtaCanal() {
		return this.etaCanal;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
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
	 * @return nextCanal
	 */
	public String getNextCanal() {
		return this.nextCanal;
	}
	
	/**
	 * Column Info
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
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
	 * @param etaCanal
	 */
	public void setEtaCanal(String etaCanal) {
		this.etaCanal = etaCanal;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
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
	 * @param nextCanal
	 */
	public void setNextCanal(String nextCanal) {
		this.nextCanal = nextCanal;
	}
	
	/**
	 * Column Info
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
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
		setEtaCanal(JSPUtil.getParameter(request, "eta_canal", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNextCanal(JSPUtil.getParameter(request, "next_canal", ""));
		setNextPort(JSPUtil.getParameter(request, "next_port", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRNextPortVO[]
	 */
	public RDRNextPortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRNextPortVO[]
	 */
	public RDRNextPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRNextPortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etaCanal = (JSPUtil.getParameter(request, prefix	+ "eta_canal", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nextCanal = (JSPUtil.getParameter(request, prefix	+ "next_canal", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRNextPortVO();
				if (etaCanal[i] != null)
					model.setEtaCanal(etaCanal[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nextCanal[i] != null)
					model.setNextCanal(nextCanal[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRNextPortVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRNextPortVO[]
	 */
	public RDRNextPortVO[] getRDRNextPortVOs(){
		RDRNextPortVO[] vos = (RDRNextPortVO[])models.toArray(new RDRNextPortVO[models.size()]);
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
		this.etaCanal = this.etaCanal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextCanal = this.nextCanal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
