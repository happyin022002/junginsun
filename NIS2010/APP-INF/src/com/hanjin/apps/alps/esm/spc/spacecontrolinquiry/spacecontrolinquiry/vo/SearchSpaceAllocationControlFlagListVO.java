/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchSpaceAllocationControlFlagListVO.java
*@FileTitle : SearchSpaceAllocationControlFlagListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.03
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.11.03 신자영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 신자영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceAllocationControlFlagListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocationControlFlagListVO> models = new ArrayList<SearchSpaceAllocationControlFlagListVO>();
	
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String hc40 = null;
	/* Column Info */
	private String ctrlAcct = null;
	/* Column Info */
	private String ctrlD2 = null;
	/* Column Info */
	private String ft53 = null;
	/* Column Info */
	private String ctrlUsa = null;
	/* Column Info */
	private String ctrlD4 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hc45 = null;
	/* Column Info */
	private String ctrlRd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String reefer = null;
	/* Column Info */
	private String volume = null;
	/* Column Info */
	private String polPod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSpaceAllocationControlFlagListVO() {}

	public SearchSpaceAllocationControlFlagListVO(String ibflag, String pagerows, String polPod, String hc40, String hc45, String ft53, String reefer, String weight, String volume, String ctrlD2, String ctrlD4, String ctrlRd, String ctrlAcct, String ctrlUsa) {
		this.weight = weight;
		this.hc40 = hc40;
		this.ctrlAcct = ctrlAcct;
		this.ctrlD2 = ctrlD2;
		this.ft53 = ft53;
		this.ctrlUsa = ctrlUsa;
		this.ctrlD4 = ctrlD4;
		this.pagerows = pagerows;
		this.hc45 = hc45;
		this.ctrlRd = ctrlRd;
		this.ibflag = ibflag;
		this.reefer = reefer;
		this.volume = volume;
		this.polPod = polPod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("hc40", getHc40());
		this.hashColumns.put("ctrl_acct", getCtrlAcct());
		this.hashColumns.put("ctrl_d2", getCtrlD2());
		this.hashColumns.put("ft53", getFt53());
		this.hashColumns.put("ctrl_usa", getCtrlUsa());
		this.hashColumns.put("ctrl_d4", getCtrlD4());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hc45", getHc45());
		this.hashColumns.put("ctrl_rd", getCtrlRd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("reefer", getReefer());
		this.hashColumns.put("volume", getVolume());
		this.hashColumns.put("pol_pod", getPolPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("weight", "weight");
		this.hashFields.put("hc40", "hc40");
		this.hashFields.put("ctrl_acct", "ctrlAcct");
		this.hashFields.put("ctrl_d2", "ctrlD2");
		this.hashFields.put("ft53", "ft53");
		this.hashFields.put("ctrl_usa", "ctrlUsa");
		this.hashFields.put("ctrl_d4", "ctrlD4");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hc45", "hc45");
		this.hashFields.put("ctrl_rd", "ctrlRd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("reefer", "reefer");
		this.hashFields.put("volume", "volume");
		this.hashFields.put("pol_pod", "polPod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return weight
	 */
	public String getWeight() {
		return this.weight;
	}
	
	/**
	 * Column Info
	 * @return hc40
	 */
	public String getHc40() {
		return this.hc40;
	}
	
	/**
	 * Column Info
	 * @return ctrlAcct
	 */
	public String getCtrlAcct() {
		return this.ctrlAcct;
	}
	
	/**
	 * Column Info
	 * @return ctrlD2
	 */
	public String getCtrlD2() {
		return this.ctrlD2;
	}
	
	/**
	 * Column Info
	 * @return ft53
	 */
	public String getFt53() {
		return this.ft53;
	}
	
	/**
	 * Column Info
	 * @return ctrlUsa
	 */
	public String getCtrlUsa() {
		return this.ctrlUsa;
	}
	
	/**
	 * Column Info
	 * @return ctrlD4
	 */
	public String getCtrlD4() {
		return this.ctrlD4;
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
	 * @return hc45
	 */
	public String getHc45() {
		return this.hc45;
	}
	
	/**
	 * Column Info
	 * @return ctrlRd
	 */
	public String getCtrlRd() {
		return this.ctrlRd;
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
	 * @return reefer
	 */
	public String getReefer() {
		return this.reefer;
	}
	
	/**
	 * Column Info
	 * @return volume
	 */
	public String getVolume() {
		return this.volume;
	}
	
	/**
	 * Column Info
	 * @return polPod
	 */
	public String getPolPod() {
		return this.polPod;
	}
	

	/**
	 * Column Info
	 * @param weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	/**
	 * Column Info
	 * @param hc40
	 */
	public void setHc40(String hc40) {
		this.hc40 = hc40;
	}
	
	/**
	 * Column Info
	 * @param ctrlAcct
	 */
	public void setCtrlAcct(String ctrlAcct) {
		this.ctrlAcct = ctrlAcct;
	}
	
	/**
	 * Column Info
	 * @param ctrlD2
	 */
	public void setCtrlD2(String ctrlD2) {
		this.ctrlD2 = ctrlD2;
	}
	
	/**
	 * Column Info
	 * @param ft53
	 */
	public void setFt53(String ft53) {
		this.ft53 = ft53;
	}
	
	/**
	 * Column Info
	 * @param ctrlUsa
	 */
	public void setCtrlUsa(String ctrlUsa) {
		this.ctrlUsa = ctrlUsa;
	}
	
	/**
	 * Column Info
	 * @param ctrlD4
	 */
	public void setCtrlD4(String ctrlD4) {
		this.ctrlD4 = ctrlD4;
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
	 * @param hc45
	 */
	public void setHc45(String hc45) {
		this.hc45 = hc45;
	}
	
	/**
	 * Column Info
	 * @param ctrlRd
	 */
	public void setCtrlRd(String ctrlRd) {
		this.ctrlRd = ctrlRd;
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
	 * @param reefer
	 */
	public void setReefer(String reefer) {
		this.reefer = reefer;
	}
	
	/**
	 * Column Info
	 * @param volume
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	/**
	 * Column Info
	 * @param polPod
	 */
	public void setPolPod(String polPod) {
		this.polPod = polPod;
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
		setWeight(JSPUtil.getParameter(request, prefix + "weight", ""));
		setHc40(JSPUtil.getParameter(request, prefix + "hc40", ""));
		setCtrlAcct(JSPUtil.getParameter(request, prefix + "ctrl_acct", ""));
		setCtrlD2(JSPUtil.getParameter(request, prefix + "ctrl_d2", ""));
		setFt53(JSPUtil.getParameter(request, prefix + "ft53", ""));
		setCtrlUsa(JSPUtil.getParameter(request, prefix + "ctrl_usa", ""));
		setCtrlD4(JSPUtil.getParameter(request, prefix + "ctrl_d4", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHc45(JSPUtil.getParameter(request, prefix + "hc45", ""));
		setCtrlRd(JSPUtil.getParameter(request, prefix + "ctrl_rd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setReefer(JSPUtil.getParameter(request, prefix + "reefer", ""));
		setVolume(JSPUtil.getParameter(request, prefix + "volume", ""));
		setPolPod(JSPUtil.getParameter(request, prefix + "pol_pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceAllocationControlFlagListVO[]
	 */
	public SearchSpaceAllocationControlFlagListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceAllocationControlFlagListVO[]
	 */
	public SearchSpaceAllocationControlFlagListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceAllocationControlFlagListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] hc40 = (JSPUtil.getParameter(request, prefix	+ "hc40", length));
			String[] ctrlAcct = (JSPUtil.getParameter(request, prefix	+ "ctrl_acct", length));
			String[] ctrlD2 = (JSPUtil.getParameter(request, prefix	+ "ctrl_d2", length));
			String[] ft53 = (JSPUtil.getParameter(request, prefix	+ "ft53", length));
			String[] ctrlUsa = (JSPUtil.getParameter(request, prefix	+ "ctrl_usa", length));
			String[] ctrlD4 = (JSPUtil.getParameter(request, prefix	+ "ctrl_d4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hc45 = (JSPUtil.getParameter(request, prefix	+ "hc45", length));
			String[] ctrlRd = (JSPUtil.getParameter(request, prefix	+ "ctrl_rd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] reefer = (JSPUtil.getParameter(request, prefix	+ "reefer", length));
			String[] volume = (JSPUtil.getParameter(request, prefix	+ "volume", length));
			String[] polPod = (JSPUtil.getParameter(request, prefix	+ "pol_pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocationControlFlagListVO();
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (hc40[i] != null)
					model.setHc40(hc40[i]);
				if (ctrlAcct[i] != null)
					model.setCtrlAcct(ctrlAcct[i]);
				if (ctrlD2[i] != null)
					model.setCtrlD2(ctrlD2[i]);
				if (ft53[i] != null)
					model.setFt53(ft53[i]);
				if (ctrlUsa[i] != null)
					model.setCtrlUsa(ctrlUsa[i]);
				if (ctrlD4[i] != null)
					model.setCtrlD4(ctrlD4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hc45[i] != null)
					model.setHc45(hc45[i]);
				if (ctrlRd[i] != null)
					model.setCtrlRd(ctrlRd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (reefer[i] != null)
					model.setReefer(reefer[i]);
				if (volume[i] != null)
					model.setVolume(volume[i]);
				if (polPod[i] != null)
					model.setPolPod(polPod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceAllocationControlFlagListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceAllocationControlFlagListVO[]
	 */
	public SearchSpaceAllocationControlFlagListVO[] getSearchSpaceAllocationControlFlagListVOs(){
		SearchSpaceAllocationControlFlagListVO[] vos = (SearchSpaceAllocationControlFlagListVO[])models.toArray(new SearchSpaceAllocationControlFlagListVO[models.size()]);
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
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc40 = this.hc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlAcct = this.ctrlAcct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD2 = this.ctrlD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft53 = this.ft53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlUsa = this.ctrlUsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD4 = this.ctrlD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc45 = this.hc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRd = this.ctrlRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reefer = this.reefer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volume = this.volume .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPod = this.polPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
