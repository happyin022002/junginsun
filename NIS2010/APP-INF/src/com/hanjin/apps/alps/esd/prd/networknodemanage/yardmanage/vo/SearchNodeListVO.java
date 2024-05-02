/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchNodeListVO.java
*@FileTitle : SearchNodeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.10 노승배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 노승배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchNodeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNodeListVO> models = new ArrayList<SearchNodeListVO>();
	
	/* Column Info */
	private String nodeTypeDiv = null;
	/* Column Info */
	private String regionCode = null;
	/* Column Info */
	private String nodeName = null;
	/* Column Info */
	private String nodeRemark = null;
	/* Column Info */
	private String nodeCodeTop = null;
	/* Column Info */
	private String countryCode = null;
	/* Column Info */
	private String subcontiCode = null;
	/* Column Info */
	private String nodeTypeCode = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locationCodeTop = null;
	/* Column Info */
	private String nodeType = null;
	/* Column Info */
	private String nodeDiv = null;
	/* Column Info */
	private String contiCode = null;
	/* Column Info */
	private String nodeCode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchNodeListVO() {}

	public SearchNodeListVO(String ibflag, String pagerows, String nodeTypeCode, String nodeDiv, String nodeCode, String nodeName, String nodeType, String nodeRemark, String nodeCodeTop, String contiCode, String subcontiCode, String countryCode, String regionCode, String locationCodeTop, String nodeTypeDiv) {
		this.nodeTypeDiv = nodeTypeDiv;
		this.regionCode = regionCode;
		this.nodeName = nodeName;
		this.nodeRemark = nodeRemark;
		this.nodeCodeTop = nodeCodeTop;
		this.countryCode = countryCode;
		this.subcontiCode = subcontiCode;
		this.nodeTypeCode = nodeTypeCode;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locationCodeTop = locationCodeTop;
		this.nodeType = nodeType;
		this.nodeDiv = nodeDiv;
		this.contiCode = contiCode;
		this.nodeCode = nodeCode;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("node_type_div", getNodeTypeDiv());
		this.hashColumns.put("region_code", getRegionCode());
		this.hashColumns.put("node_name", getNodeName());
		this.hashColumns.put("node_remark", getNodeRemark());
		this.hashColumns.put("node_code_top", getNodeCodeTop());
		this.hashColumns.put("country_code", getCountryCode());
		this.hashColumns.put("subconti_code", getSubcontiCode());
		this.hashColumns.put("node_type_code", getNodeTypeCode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("location_code_top", getLocationCodeTop());
		this.hashColumns.put("node_type", getNodeType());
		this.hashColumns.put("node_div", getNodeDiv());
		this.hashColumns.put("conti_code", getContiCode());
		this.hashColumns.put("node_code", getNodeCode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("node_type_div", "nodeTypeDiv");
		this.hashFields.put("region_code", "regionCode");
		this.hashFields.put("node_name", "nodeName");
		this.hashFields.put("node_remark", "nodeRemark");
		this.hashFields.put("node_code_top", "nodeCodeTop");
		this.hashFields.put("country_code", "countryCode");
		this.hashFields.put("subconti_code", "subcontiCode");
		this.hashFields.put("node_type_code", "nodeTypeCode");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("location_code_top", "locationCodeTop");
		this.hashFields.put("node_type", "nodeType");
		this.hashFields.put("node_div", "nodeDiv");
		this.hashFields.put("conti_code", "contiCode");
		this.hashFields.put("node_code", "nodeCode");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nodeTypeDiv
	 */
	public String getNodeTypeDiv() {
		return this.nodeTypeDiv;
	}
	
	/**
	 * Column Info
	 * @return regionCode
	 */
	public String getRegionCode() {
		return this.regionCode;
	}
	
	/**
	 * Column Info
	 * @return nodeName
	 */
	public String getNodeName() {
		return this.nodeName;
	}
	
	/**
	 * Column Info
	 * @return nodeRemark
	 */
	public String getNodeRemark() {
		return this.nodeRemark;
	}
	
	/**
	 * Column Info
	 * @return nodeCodeTop
	 */
	public String getNodeCodeTop() {
		return this.nodeCodeTop;
	}
	
	/**
	 * Column Info
	 * @return countryCode
	 */
	public String getCountryCode() {
		return this.countryCode;
	}
	
	/**
	 * Column Info
	 * @return subcontiCode
	 */
	public String getSubcontiCode() {
		return this.subcontiCode;
	}
	
	/**
	 * Column Info
	 * @return nodeTypeCode
	 */
	public String getNodeTypeCode() {
		return this.nodeTypeCode;
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
	 * @return locationCodeTop
	 */
	public String getLocationCodeTop() {
		return this.locationCodeTop;
	}
	
	/**
	 * Column Info
	 * @return nodeType
	 */
	public String getNodeType() {
		return this.nodeType;
	}
	
	/**
	 * Column Info
	 * @return nodeDiv
	 */
	public String getNodeDiv() {
		return this.nodeDiv;
	}
	
	/**
	 * Column Info
	 * @return contiCode
	 */
	public String getContiCode() {
		return this.contiCode;
	}
	
	/**
	 * Column Info
	 * @return nodeCode
	 */
	public String getNodeCode() {
		return this.nodeCode;
	}
	

	/**
	 * Column Info
	 * @param nodeTypeDiv
	 */
	public void setNodeTypeDiv(String nodeTypeDiv) {
		this.nodeTypeDiv = nodeTypeDiv;
	}
	
	/**
	 * Column Info
	 * @param regionCode
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
	/**
	 * Column Info
	 * @param nodeName
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	/**
	 * Column Info
	 * @param nodeRemark
	 */
	public void setNodeRemark(String nodeRemark) {
		this.nodeRemark = nodeRemark;
	}
	
	/**
	 * Column Info
	 * @param nodeCodeTop
	 */
	public void setNodeCodeTop(String nodeCodeTop) {
		this.nodeCodeTop = nodeCodeTop;
	}
	
	/**
	 * Column Info
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * Column Info
	 * @param subcontiCode
	 */
	public void setSubcontiCode(String subcontiCode) {
		this.subcontiCode = subcontiCode;
	}
	
	/**
	 * Column Info
	 * @param nodeTypeCode
	 */
	public void setNodeTypeCode(String nodeTypeCode) {
		this.nodeTypeCode = nodeTypeCode;
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
	 * @param locationCodeTop
	 */
	public void setLocationCodeTop(String locationCodeTop) {
		this.locationCodeTop = locationCodeTop;
	}
	
	/**
	 * Column Info
	 * @param nodeType
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	
	/**
	 * Column Info
	 * @param nodeDiv
	 */
	public void setNodeDiv(String nodeDiv) {
		this.nodeDiv = nodeDiv;
	}
	
	/**
	 * Column Info
	 * @param contiCode
	 */
	public void setContiCode(String contiCode) {
		this.contiCode = contiCode;
	}
	
	/**
	 * Column Info
	 * @param nodeCode
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNodeTypeDiv(JSPUtil.getParameter(request, "node_type_div", ""));
		setRegionCode(JSPUtil.getParameter(request, "region_code", ""));
		setNodeName(JSPUtil.getParameter(request, "node_name", ""));
		setNodeRemark(JSPUtil.getParameter(request, "node_remark", ""));
		setNodeCodeTop(JSPUtil.getParameter(request, "node_code_top", ""));
		setCountryCode(JSPUtil.getParameter(request, "country_code", ""));
		setSubcontiCode(JSPUtil.getParameter(request, "subconti_code", ""));
		setNodeTypeCode(JSPUtil.getParameter(request, "node_type_code", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocationCodeTop(JSPUtil.getParameter(request, "location_code_top", ""));
		setNodeType(JSPUtil.getParameter(request, "node_type", ""));
		setNodeDiv(JSPUtil.getParameter(request, "node_div", ""));
		setContiCode(JSPUtil.getParameter(request, "conti_code", ""));
		setNodeCode(JSPUtil.getParameter(request, "node_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNodeListVO[]
	 */
	public SearchNodeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNodeListVO[]
	 */
	public SearchNodeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNodeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nodeTypeDiv = (JSPUtil.getParameter(request, prefix	+ "node_type_div", length));
			String[] regionCode = (JSPUtil.getParameter(request, prefix	+ "region_code", length));
			String[] nodeName = (JSPUtil.getParameter(request, prefix	+ "node_name", length));
			String[] nodeRemark = (JSPUtil.getParameter(request, prefix	+ "node_remark", length));
			String[] nodeCodeTop = (JSPUtil.getParameter(request, prefix	+ "node_code_top", length));
			String[] countryCode = (JSPUtil.getParameter(request, prefix	+ "country_code", length));
			String[] subcontiCode = (JSPUtil.getParameter(request, prefix	+ "subconti_code", length));
			String[] nodeTypeCode = (JSPUtil.getParameter(request, prefix	+ "node_type_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locationCodeTop = (JSPUtil.getParameter(request, prefix	+ "location_code_top", length));
			String[] nodeType = (JSPUtil.getParameter(request, prefix	+ "node_type", length));
			String[] nodeDiv = (JSPUtil.getParameter(request, prefix	+ "node_div", length));
			String[] contiCode = (JSPUtil.getParameter(request, prefix	+ "conti_code", length));
			String[] nodeCode = (JSPUtil.getParameter(request, prefix	+ "node_code", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNodeListVO();
				if (nodeTypeDiv[i] != null)
					model.setNodeTypeDiv(nodeTypeDiv[i]);
				if (regionCode[i] != null)
					model.setRegionCode(regionCode[i]);
				if (nodeName[i] != null)
					model.setNodeName(nodeName[i]);
				if (nodeRemark[i] != null)
					model.setNodeRemark(nodeRemark[i]);
				if (nodeCodeTop[i] != null)
					model.setNodeCodeTop(nodeCodeTop[i]);
				if (countryCode[i] != null)
					model.setCountryCode(countryCode[i]);
				if (subcontiCode[i] != null)
					model.setSubcontiCode(subcontiCode[i]);
				if (nodeTypeCode[i] != null)
					model.setNodeTypeCode(nodeTypeCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locationCodeTop[i] != null)
					model.setLocationCodeTop(locationCodeTop[i]);
				if (nodeType[i] != null)
					model.setNodeType(nodeType[i]);
				if (nodeDiv[i] != null)
					model.setNodeDiv(nodeDiv[i]);
				if (contiCode[i] != null)
					model.setContiCode(contiCode[i]);
				if (nodeCode[i] != null)
					model.setNodeCode(nodeCode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNodeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNodeListVO[]
	 */
	public SearchNodeListVO[] getSearchNodeListVOs(){
		SearchNodeListVO[] vos = (SearchNodeListVO[])models.toArray(new SearchNodeListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.nodeTypeDiv = this.nodeTypeDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regionCode = this.regionCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeName = this.nodeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeRemark = this.nodeRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeCodeTop = this.nodeCodeTop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countryCode = this.countryCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subcontiCode = this.subcontiCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeTypeCode = this.nodeTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCodeTop = this.locationCodeTop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeType = this.nodeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeDiv = this.nodeDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCode = this.contiCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeCode = this.nodeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
