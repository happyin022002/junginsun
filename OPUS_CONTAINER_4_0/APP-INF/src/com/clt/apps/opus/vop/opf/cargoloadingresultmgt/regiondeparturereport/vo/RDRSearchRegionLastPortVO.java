/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RDRSearchRegionLastPortVO.java
*@FileTitle : RDRSearchRegionLastPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.29
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.06.29 이준범 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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
 * @author 이준범
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRSearchRegionLastPortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRSearchRegionLastPortVO> models = new ArrayList<RDRSearchRegionLastPortVO>();
	
	/* Column Info */
	private String val = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String callInd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String name = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRSearchRegionLastPortVO() {}

	public RDRSearchRegionLastPortVO(String ibflag, String pagerows, String region, String val, String name, String ydCd, String callInd, String clptSeq) {
		this.val = val;
		this.region = region;
		this.clptSeq = clptSeq;
		this.callInd = callInd;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.name = name;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("val", getVal());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("call_ind", getCallInd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("val", "val");
		this.hashFields.put("region", "region");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("call_ind", "callInd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("name", "name");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return val
	 */
	public String getVal() {
		return this.val;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 * Column Info
	 * @return callInd
	 */
	public String getCallInd() {
		return this.callInd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
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
	 * @param val
	 */
	public void setVal(String val) {
		this.val = val;
	}
	
	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * Column Info
	 * @param callInd
	 */
	public void setCallInd(String callInd) {
		this.callInd = callInd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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
		setVal(JSPUtil.getParameter(request, prefix + "val", ""));
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setCallInd(JSPUtil.getParameter(request, prefix + "call_ind", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRSearchRegionLastPortVO[]
	 */
	public RDRSearchRegionLastPortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRSearchRegionLastPortVO[]
	 */
	public RDRSearchRegionLastPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRSearchRegionLastPortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] val = (JSPUtil.getParameter(request, prefix	+ "val", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] callInd = (JSPUtil.getParameter(request, prefix	+ "call_ind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRSearchRegionLastPortVO();
				if (val[i] != null)
					model.setVal(val[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (callInd[i] != null)
					model.setCallInd(callInd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRSearchRegionLastPortVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRSearchRegionLastPortVO[]
	 */
	public RDRSearchRegionLastPortVO[] getRDRSearchRegionLastPortVOs(){
		RDRSearchRegionLastPortVO[] vos = (RDRSearchRegionLastPortVO[])models.toArray(new RDRSearchRegionLastPortVO[models.size()]);
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
		this.val = this.val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callInd = this.callInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
