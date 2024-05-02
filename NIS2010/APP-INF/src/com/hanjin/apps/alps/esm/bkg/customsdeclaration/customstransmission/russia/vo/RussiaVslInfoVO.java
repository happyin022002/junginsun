/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaVslInfoVO.java
*@FileTitle : RussiaVslInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo;

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

public class RussiaVslInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RussiaVslInfoVO> models = new ArrayList<RussiaVslInfoVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String fstPortNm = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fstArrDt = null;
	/* Column Info */
	private String fstPort = null;
	/* Column Info */
	private String nationCd = null;
	/* Column Info */
	private String nationNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RussiaVslInfoVO() {}

	public RussiaVslInfoVO(String ibflag, String pagerows, String fstPortNm, String fstArrDt, String fstPort, String nationNm, String nationCd, String polCd, String podCd) {
		this.podCd = podCd;
		this.fstPortNm = fstPortNm;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.fstArrDt = fstArrDt;
		this.fstPort = fstPort;
		this.nationCd = nationCd;
		this.nationNm = nationNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("fst_port_nm", getFstPortNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fst_arr_dt", getFstArrDt());
		this.hashColumns.put("fst_port", getFstPort());
		this.hashColumns.put("nation_cd", getNationCd());
		this.hashColumns.put("nation_nm", getNationNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("fst_port_nm", "fstPortNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fst_arr_dt", "fstArrDt");
		this.hashFields.put("fst_port", "fstPort");
		this.hashFields.put("nation_cd", "nationCd");
		this.hashFields.put("nation_nm", "nationNm");
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
	 * @return fstPortNm
	 */
	public String getFstPortNm() {
		return this.fstPortNm;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return fstArrDt
	 */
	public String getFstArrDt() {
		return this.fstArrDt;
	}
	
	/**
	 * Column Info
	 * @return fstPort
	 */
	public String getFstPort() {
		return this.fstPort;
	}
	
	/**
	 * Column Info
	 * @return nationCd
	 */
	public String getNationCd() {
		return this.nationCd;
	}

	
	/**
	 * Column Info
	 * @return nationNm
	 */
	public String getNationNm() {
		return this.nationNm;
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
	 * @param fstPortNm
	 */
	public void setFstPortNm(String fstPortNm) {
		this.fstPortNm = fstPortNm;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param fstArrDt
	 */
	public void setFstArrDt(String fstArrDt) {
		this.fstArrDt = fstArrDt;
	}
	
	/**
	 * Column Info
	 * @param fstPort
	 */
	public void setFstPort(String fstPort) {
		this.fstPort = fstPort;
	}

	/**
	 * Column Info
	 * @param nationCd
	 */
	public void setNationCd(String nationCd) {
		this.nationCd = nationCd;
	}
	
	/**
	 * Column Info
	 * @param nationNm
	 */
	public void setNationNm(String nationNm) {
		this.nationNm = nationNm;
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
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFstPortNm(JSPUtil.getParameter(request, prefix + "fst_port_nm", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFstArrDt(JSPUtil.getParameter(request, prefix + "fst_arr_dt", ""));
		setFstPort(JSPUtil.getParameter(request, prefix + "fst_port", ""));
		setNationCd(JSPUtil.getParameter(request, prefix + "nation_cd", ""));
		setNationNm(JSPUtil.getParameter(request, prefix + "nation_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RussiaVslInfoVO[]
	 */
	public RussiaVslInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RussiaVslInfoVO[]
	 */
	public RussiaVslInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RussiaVslInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] fstPortNm = (JSPUtil.getParameter(request, prefix	+ "fst_port_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fstArrDt = (JSPUtil.getParameter(request, prefix	+ "fst_arr_dt", length));
			String[] fstPort = (JSPUtil.getParameter(request, prefix	+ "fst_port", length));
			String[] nationCd = (JSPUtil.getParameter(request, prefix	+ "nation_cd", length));
			String[] nationNm = (JSPUtil.getParameter(request, prefix	+ "nation_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RussiaVslInfoVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (fstPortNm[i] != null)
					model.setFstPortNm(fstPortNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fstArrDt[i] != null)
					model.setFstArrDt(fstArrDt[i]);
				if (fstPort[i] != null)
					model.setFstPort(fstPort[i]);
				if (nationCd[i] != null)
					model.setNationCd(nationCd[i]);
				if (nationNm[i] != null)
					model.setNationNm(nationNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRussiaVslInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RussiaVslInfoVO[]
	 */
	public RussiaVslInfoVO[] getRussiaVslInfoVOs(){
		RussiaVslInfoVO[] vos = (RussiaVslInfoVO[])models.toArray(new RussiaVslInfoVO[models.size()]);
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
		this.fstPortNm = this.fstPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fstArrDt = this.fstArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fstPort = this.fstPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nationCd = this.nationCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nationNm = this.nationNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
