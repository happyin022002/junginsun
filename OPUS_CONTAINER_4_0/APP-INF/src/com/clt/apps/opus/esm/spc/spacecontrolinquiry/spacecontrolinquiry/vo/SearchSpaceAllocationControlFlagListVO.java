/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSpaceAllocationControlFlagListVO.java
*@FileTitle : SearchSpaceAllocationControlFlagListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.30
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.06.30 이상용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

import java.lang.reflect.Field;
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
 * @author 이상용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceAllocationControlFlagListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocationControlFlagListVO> models = new ArrayList<SearchSpaceAllocationControlFlagListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String hc40 = null;
	/* Column Info */
	private String reefer = null;
	/* Column Info */
	private String volume = null;
	/* Column Info */
	private String ft53 = null;
	/* Column Info */
	private String polPod = null;
	/* Column Info */
	private String hc45 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceAllocationControlFlagListVO() {}

	public SearchSpaceAllocationControlFlagListVO(String ibflag, String pagerows, String polPod, String hc40, String hc45, String ft53, String reefer, String weight, String volume) {
		this.ibflag = ibflag;
		this.weight = weight;
		this.hc40 = hc40;
		this.reefer = reefer;
		this.volume = volume;
		this.ft53 = ft53;
		this.polPod = polPod;
		this.hc45 = hc45;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("hc40", getHc40());
		this.hashColumns.put("reefer", getReefer());
		this.hashColumns.put("volume", getVolume());
		this.hashColumns.put("ft53", getFt53());
		this.hashColumns.put("pol_pod", getPolPod());
		this.hashColumns.put("hc45", getHc45());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("hc40", "hc40");
		this.hashFields.put("reefer", "reefer");
		this.hashFields.put("volume", "volume");
		this.hashFields.put("ft53", "ft53");
		this.hashFields.put("pol_pod", "polPod");
		this.hashFields.put("hc45", "hc45");
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
	 * @return ft53
	 */
	public String getFt53() {
		return this.ft53;
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
	 * @return hc45
	 */
	public String getHc45() {
		return this.hc45;
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
	 * @param ft53
	 */
	public void setFt53(String ft53) {
		this.ft53 = ft53;
	}
	
	/**
	 * Column Info
	 * @param polPod
	 */
	public void setPolPod(String polPod) {
		this.polPod = polPod;
	}
	
	/**
	 * Column Info
	 * @param hc45
	 */
	public void setHc45(String hc45) {
		this.hc45 = hc45;
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
		setWeight(JSPUtil.getParameter(request, prefix + "weight", ""));
		setHc40(JSPUtil.getParameter(request, prefix + "hc40", ""));
		setReefer(JSPUtil.getParameter(request, prefix + "reefer", ""));
		setVolume(JSPUtil.getParameter(request, prefix + "volume", ""));
		setFt53(JSPUtil.getParameter(request, prefix + "ft53", ""));
		setPolPod(JSPUtil.getParameter(request, prefix + "pol_pod", ""));
		setHc45(JSPUtil.getParameter(request, prefix + "hc45", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
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
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] hc40 = (JSPUtil.getParameter(request, prefix	+ "hc40", length));
			String[] reefer = (JSPUtil.getParameter(request, prefix	+ "reefer", length));
			String[] volume = (JSPUtil.getParameter(request, prefix	+ "volume", length));
			String[] ft53 = (JSPUtil.getParameter(request, prefix	+ "ft53", length));
			String[] polPod = (JSPUtil.getParameter(request, prefix	+ "pol_pod", length));
			String[] hc45 = (JSPUtil.getParameter(request, prefix	+ "hc45", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocationControlFlagListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (hc40[i] != null)
					model.setHc40(hc40[i]);
				if (reefer[i] != null)
					model.setReefer(reefer[i]);
				if (volume[i] != null)
					model.setVolume(volume[i]);
				if (ft53[i] != null)
					model.setFt53(ft53[i]);
				if (polPod[i] != null)
					model.setPolPod(polPod[i]);
				if (hc45[i] != null)
					model.setHc45(hc45[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc40 = this.hc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reefer = this.reefer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volume = this.volume .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft53 = this.ft53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPod = this.polPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc45 = this.hc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
