/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315CurrInfoIsCurrVvdVO.java
*@FileTitle : Edi315CurrInfoIsCurrVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2009.11.23 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315CurrInfoIsCurrVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315CurrInfoIsCurrVvdVO> models = new ArrayList<Edi315CurrInfoIsCurrVvdVO>();
	
	/* Column Info */
	private String currVvd = null;
	/* Column Info */
	private String rlyAmsport = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rlyPort = null;
	/* Column Info */
	private String lloydCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String rlyName = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String rlyAmsqual = null;
	/* Column Info */
	private String currBound = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315CurrInfoIsCurrVvdVO() {}

	public Edi315CurrInfoIsCurrVvdVO(String ibflag, String pagerows, String currBound, String currVvd, String vslNm, String vslCntCd, String lloydCd, String rlyName, String rlyPort, String rlyAmsqual, String rlyAmsport) {
		this.currVvd = currVvd;
		this.rlyAmsport = rlyAmsport;
		this.ibflag = ibflag;
		this.rlyPort = rlyPort;
		this.lloydCd = lloydCd;
		this.vslNm = vslNm;
		this.rlyName = rlyName;
		this.vslCntCd = vslCntCd;
		this.rlyAmsqual = rlyAmsqual;
		this.currBound = currBound;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_vvd", getCurrVvd());
		this.hashColumns.put("rly_amsport", getRlyAmsport());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rly_port", getRlyPort());
		this.hashColumns.put("lloyd_cd", getLloydCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("rly_name", getRlyName());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("rly_amsqual", getRlyAmsqual());
		this.hashColumns.put("curr_bound", getCurrBound());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_vvd", "currVvd");
		this.hashFields.put("rly_amsport", "rlyAmsport");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rly_port", "rlyPort");
		this.hashFields.put("lloyd_cd", "lloydCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("rly_name", "rlyName");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("rly_amsqual", "rlyAmsqual");
		this.hashFields.put("curr_bound", "currBound");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currVvd
	 */
	public String getCurrVvd() {
		return this.currVvd;
	}
	
	/**
	 * Column Info
	 * @return rlyAmsport
	 */
	public String getRlyAmsport() {
		return this.rlyAmsport;
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
	 * @return rlyPort
	 */
	public String getRlyPort() {
		return this.rlyPort;
	}
	
	/**
	 * Column Info
	 * @return lloydCd
	 */
	public String getLloydCd() {
		return this.lloydCd;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return rlyName
	 */
	public String getRlyName() {
		return this.rlyName;
	}
	
	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	
	/**
	 * Column Info
	 * @return rlyAmsqual
	 */
	public String getRlyAmsqual() {
		return this.rlyAmsqual;
	}
	
	/**
	 * Column Info
	 * @return currBound
	 */
	public String getCurrBound() {
		return this.currBound;
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
	 * @param currVvd
	 */
	public void setCurrVvd(String currVvd) {
		this.currVvd = currVvd;
	}
	
	/**
	 * Column Info
	 * @param rlyAmsport
	 */
	public void setRlyAmsport(String rlyAmsport) {
		this.rlyAmsport = rlyAmsport;
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
	 * @param rlyPort
	 */
	public void setRlyPort(String rlyPort) {
		this.rlyPort = rlyPort;
	}
	
	/**
	 * Column Info
	 * @param lloydCd
	 */
	public void setLloydCd(String lloydCd) {
		this.lloydCd = lloydCd;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param rlyName
	 */
	public void setRlyName(String rlyName) {
		this.rlyName = rlyName;
	}
	
	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}
	
	/**
	 * Column Info
	 * @param rlyAmsqual
	 */
	public void setRlyAmsqual(String rlyAmsqual) {
		this.rlyAmsqual = rlyAmsqual;
	}
	
	/**
	 * Column Info
	 * @param currBound
	 */
	public void setCurrBound(String currBound) {
		this.currBound = currBound;
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
		setCurrVvd(JSPUtil.getParameter(request, "curr_vvd", ""));
		setRlyAmsport(JSPUtil.getParameter(request, "rly_amsport", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRlyPort(JSPUtil.getParameter(request, "rly_port", ""));
		setLloydCd(JSPUtil.getParameter(request, "lloyd_cd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setRlyName(JSPUtil.getParameter(request, "rly_name", ""));
		setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
		setRlyAmsqual(JSPUtil.getParameter(request, "rly_amsqual", ""));
		setCurrBound(JSPUtil.getParameter(request, "curr_bound", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315CurrInfoIsCurrVvdVO[]
	 */
	public Edi315CurrInfoIsCurrVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315CurrInfoIsCurrVvdVO[]
	 */
	public Edi315CurrInfoIsCurrVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315CurrInfoIsCurrVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currVvd = (JSPUtil.getParameter(request, prefix	+ "curr_vvd", length));
			String[] rlyAmsport = (JSPUtil.getParameter(request, prefix	+ "rly_amsport", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rlyPort = (JSPUtil.getParameter(request, prefix	+ "rly_port", length));
			String[] lloydCd = (JSPUtil.getParameter(request, prefix	+ "lloyd_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] rlyName = (JSPUtil.getParameter(request, prefix	+ "rly_name", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] rlyAmsqual = (JSPUtil.getParameter(request, prefix	+ "rly_amsqual", length));
			String[] currBound = (JSPUtil.getParameter(request, prefix	+ "curr_bound", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315CurrInfoIsCurrVvdVO();
				if (currVvd[i] != null)
					model.setCurrVvd(currVvd[i]);
				if (rlyAmsport[i] != null)
					model.setRlyAmsport(rlyAmsport[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rlyPort[i] != null)
					model.setRlyPort(rlyPort[i]);
				if (lloydCd[i] != null)
					model.setLloydCd(lloydCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (rlyName[i] != null)
					model.setRlyName(rlyName[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (rlyAmsqual[i] != null)
					model.setRlyAmsqual(rlyAmsqual[i]);
				if (currBound[i] != null)
					model.setCurrBound(currBound[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315CurrInfoIsCurrVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315CurrInfoIsCurrVvdVO[]
	 */
	public Edi315CurrInfoIsCurrVvdVO[] getEdi315CurrInfoIsCurrVvdVOs(){
		Edi315CurrInfoIsCurrVvdVO[] vos = (Edi315CurrInfoIsCurrVvdVO[])models.toArray(new Edi315CurrInfoIsCurrVvdVO[models.size()]);
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
		this.currVvd = this.currVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyAmsport = this.rlyAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyPort = this.rlyPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydCd = this.lloydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyName = this.rlyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyAmsqual = this.rlyAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currBound = this.currBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
