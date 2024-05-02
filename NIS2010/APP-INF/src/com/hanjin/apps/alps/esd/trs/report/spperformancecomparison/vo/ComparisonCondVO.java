/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ComparisonCondVO.java
*@FileTitle : ComparisonCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.06.03 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComparisonCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComparisonCondVO> models = new ArrayList<ComparisonCondVO>();
	
	/* Column Info */
	private String selTransmode = null;
	/* Column Info */
	private String hidToDate = null;
	/* Column Info */
	private String hidViaNode = null;
	/* Column Info */
	private String hidToNode = null;
	/* Column Info */
	private String selInputOffice = null;
	/* Column Info */
	private String selCostmode = null;
	/* Column Info */
	private String selWono = null;
	/* Column Info */
	private String selCntrno = null;
	/* Column Info */
	private String selBkgno = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hidFromNode = null;
	/* Column Info */
	private String selBound = null;
	/* Column Info */
	private String selSotype = null;
	/* Column Info */
	private String selSono = null;
	/* Column Info */
	private String hidDoorNode = null;
	/* Column Info */
	private String selSpoption = null;
	/* Column Info */
	private String hidFromDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ComparisonCondVO() {}

	public ComparisonCondVO(String ibflag, String pagerows, String hidFromDate, String hidToDate, String hidFromNode, String hidViaNode, String hidToNode, String hidDoorNode, String selInputOffice, String selSotype, String selCostmode, String selTransmode, String selBound, String selBkgno, String selCntrno, String selSono, String selWono, String selSpoption) {
		this.selTransmode = selTransmode;
		this.hidToDate = hidToDate;
		this.hidViaNode = hidViaNode;
		this.hidToNode = hidToNode;
		this.selInputOffice = selInputOffice;
		this.selCostmode = selCostmode;
		this.selWono = selWono;
		this.selCntrno = selCntrno;
		this.selBkgno = selBkgno;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.hidFromNode = hidFromNode;
		this.selBound = selBound;
		this.selSotype = selSotype;
		this.selSono = selSono;
		this.hidDoorNode = hidDoorNode;
		this.selSpoption = selSpoption;
		this.hidFromDate = hidFromDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sel_transmode", getSelTransmode());
		this.hashColumns.put("hid_to_date", getHidToDate());
		this.hashColumns.put("hid_via_node", getHidViaNode());
		this.hashColumns.put("hid_to_node", getHidToNode());
		this.hashColumns.put("sel_input_office", getSelInputOffice());
		this.hashColumns.put("sel_costmode", getSelCostmode());
		this.hashColumns.put("sel_wono", getSelWono());
		this.hashColumns.put("sel_cntrno", getSelCntrno());
		this.hashColumns.put("sel_bkgno", getSelBkgno());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hid_from_node", getHidFromNode());
		this.hashColumns.put("sel_bound", getSelBound());
		this.hashColumns.put("sel_sotype", getSelSotype());
		this.hashColumns.put("sel_sono", getSelSono());
		this.hashColumns.put("hid_door_node", getHidDoorNode());
		this.hashColumns.put("sel_spoption", getSelSpoption());
		this.hashColumns.put("hid_from_date", getHidFromDate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sel_transmode", "selTransmode");
		this.hashFields.put("hid_to_date", "hidToDate");
		this.hashFields.put("hid_via_node", "hidViaNode");
		this.hashFields.put("hid_to_node", "hidToNode");
		this.hashFields.put("sel_input_office", "selInputOffice");
		this.hashFields.put("sel_costmode", "selCostmode");
		this.hashFields.put("sel_wono", "selWono");
		this.hashFields.put("sel_cntrno", "selCntrno");
		this.hashFields.put("sel_bkgno", "selBkgno");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hid_from_node", "hidFromNode");
		this.hashFields.put("sel_bound", "selBound");
		this.hashFields.put("sel_sotype", "selSotype");
		this.hashFields.put("sel_sono", "selSono");
		this.hashFields.put("hid_door_node", "hidDoorNode");
		this.hashFields.put("sel_spoption", "selSpoption");
		this.hashFields.put("hid_from_date", "hidFromDate");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return selTransmode
	 */
	public String getSelTransmode() {
		return this.selTransmode;
	}
	
	/**
	 * Column Info
	 * @return hidToDate
	 */
	public String getHidToDate() {
		return this.hidToDate;
	}
	
	/**
	 * Column Info
	 * @return hidViaNode
	 */
	public String getHidViaNode() {
		return this.hidViaNode;
	}
	
	/**
	 * Column Info
	 * @return hidToNode
	 */
	public String getHidToNode() {
		return this.hidToNode;
	}
	
	/**
	 * Column Info
	 * @return selInputOffice
	 */
	public String getSelInputOffice() {
		return this.selInputOffice;
	}
	
	/**
	 * Column Info
	 * @return selCostmode
	 */
	public String getSelCostmode() {
		return this.selCostmode;
	}
	
	/**
	 * Column Info
	 * @return selWono
	 */
	public String getSelWono() {
		return this.selWono;
	}
	
	/**
	 * Column Info
	 * @return selCntrno
	 */
	public String getSelCntrno() {
		return this.selCntrno;
	}
	
	/**
	 * Column Info
	 * @return selBkgno
	 */
	public String getSelBkgno() {
		return this.selBkgno;
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
	 * @return hidFromNode
	 */
	public String getHidFromNode() {
		return this.hidFromNode;
	}
	
	/**
	 * Column Info
	 * @return selBound
	 */
	public String getSelBound() {
		return this.selBound;
	}
	
	/**
	 * Column Info
	 * @return selSotype
	 */
	public String getSelSotype() {
		return this.selSotype;
	}
	
	/**
	 * Column Info
	 * @return selSono
	 */
	public String getSelSono() {
		return this.selSono;
	}
	
	/**
	 * Column Info
	 * @return hidDoorNode
	 */
	public String getHidDoorNode() {
		return this.hidDoorNode;
	}
	
	/**
	 * Column Info
	 * @return selSpoption
	 */
	public String getSelSpoption() {
		return this.selSpoption;
	}
	
	/**
	 * Column Info
	 * @return hidFromDate
	 */
	public String getHidFromDate() {
		return this.hidFromDate;
	}
	

	/**
	 * Column Info
	 * @param selTransmode
	 */
	public void setSelTransmode(String selTransmode) {
		this.selTransmode = selTransmode;
	}
	
	/**
	 * Column Info
	 * @param hidToDate
	 */
	public void setHidToDate(String hidToDate) {
		this.hidToDate = hidToDate;
	}
	
	/**
	 * Column Info
	 * @param hidViaNode
	 */
	public void setHidViaNode(String hidViaNode) {
		this.hidViaNode = hidViaNode;
	}
	
	/**
	 * Column Info
	 * @param hidToNode
	 */
	public void setHidToNode(String hidToNode) {
		this.hidToNode = hidToNode;
	}
	
	/**
	 * Column Info
	 * @param selInputOffice
	 */
	public void setSelInputOffice(String selInputOffice) {
		this.selInputOffice = selInputOffice;
	}
	
	/**
	 * Column Info
	 * @param selCostmode
	 */
	public void setSelCostmode(String selCostmode) {
		this.selCostmode = selCostmode;
	}
	
	/**
	 * Column Info
	 * @param selWono
	 */
	public void setSelWono(String selWono) {
		this.selWono = selWono;
	}
	
	/**
	 * Column Info
	 * @param selCntrno
	 */
	public void setSelCntrno(String selCntrno) {
		this.selCntrno = selCntrno;
	}
	
	/**
	 * Column Info
	 * @param selBkgno
	 */
	public void setSelBkgno(String selBkgno) {
		this.selBkgno = selBkgno;
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
	 * @param hidFromNode
	 */
	public void setHidFromNode(String hidFromNode) {
		this.hidFromNode = hidFromNode;
	}
	
	/**
	 * Column Info
	 * @param selBound
	 */
	public void setSelBound(String selBound) {
		this.selBound = selBound;
	}
	
	/**
	 * Column Info
	 * @param selSotype
	 */
	public void setSelSotype(String selSotype) {
		this.selSotype = selSotype;
	}
	
	/**
	 * Column Info
	 * @param selSono
	 */
	public void setSelSono(String selSono) {
		this.selSono = selSono;
	}
	
	/**
	 * Column Info
	 * @param hidDoorNode
	 */
	public void setHidDoorNode(String hidDoorNode) {
		this.hidDoorNode = hidDoorNode;
	}
	
	/**
	 * Column Info
	 * @param selSpoption
	 */
	public void setSelSpoption(String selSpoption) {
		this.selSpoption = selSpoption;
	}
	
	/**
	 * Column Info
	 * @param hidFromDate
	 */
	public void setHidFromDate(String hidFromDate) {
		this.hidFromDate = hidFromDate;
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
		setSelTransmode(JSPUtil.getParameter(request, prefix + "sel_transmode", ""));
		setHidToDate(JSPUtil.getParameter(request, prefix + "hid_to_date", ""));
		setHidViaNode(JSPUtil.getParameter(request, prefix + "hid_via_node", ""));
		setHidToNode(JSPUtil.getParameter(request, prefix + "hid_to_node", ""));
		setSelInputOffice(JSPUtil.getParameter(request, prefix + "sel_input_office", ""));
		setSelCostmode(JSPUtil.getParameter(request, prefix + "sel_costmode", ""));
		setSelWono(JSPUtil.getParameter(request, prefix + "sel_wono", ""));
		setSelCntrno(JSPUtil.getParameter(request, prefix + "sel_cntrno", ""));
		setSelBkgno(JSPUtil.getParameter(request, prefix + "sel_bkgno", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHidFromNode(JSPUtil.getParameter(request, prefix + "hid_from_node", ""));
		setSelBound(JSPUtil.getParameter(request, prefix + "sel_bound", ""));
		setSelSotype(JSPUtil.getParameter(request, prefix + "sel_sotype", ""));
		setSelSono(JSPUtil.getParameter(request, prefix + "sel_sono", ""));
		setHidDoorNode(JSPUtil.getParameter(request, prefix + "hid_door_node", ""));
		setSelSpoption(JSPUtil.getParameter(request, prefix + "sel_spoption", ""));
		setHidFromDate(JSPUtil.getParameter(request, prefix + "hid_from_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComparisonCondVO[]
	 */
	public ComparisonCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComparisonCondVO[]
	 */
	public ComparisonCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComparisonCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] selTransmode = (JSPUtil.getParameter(request, prefix	+ "sel_transmode", length));
			String[] hidToDate = (JSPUtil.getParameter(request, prefix	+ "hid_to_date", length));
			String[] hidViaNode = (JSPUtil.getParameter(request, prefix	+ "hid_via_node", length));
			String[] hidToNode = (JSPUtil.getParameter(request, prefix	+ "hid_to_node", length));
			String[] selInputOffice = (JSPUtil.getParameter(request, prefix	+ "sel_input_office", length));
			String[] selCostmode = (JSPUtil.getParameter(request, prefix	+ "sel_costmode", length));
			String[] selWono = (JSPUtil.getParameter(request, prefix	+ "sel_wono", length));
			String[] selCntrno = (JSPUtil.getParameter(request, prefix	+ "sel_cntrno", length));
			String[] selBkgno = (JSPUtil.getParameter(request, prefix	+ "sel_bkgno", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hidFromNode = (JSPUtil.getParameter(request, prefix	+ "hid_from_node", length));
			String[] selBound = (JSPUtil.getParameter(request, prefix	+ "sel_bound", length));
			String[] selSotype = (JSPUtil.getParameter(request, prefix	+ "sel_sotype", length));
			String[] selSono = (JSPUtil.getParameter(request, prefix	+ "sel_sono", length));
			String[] hidDoorNode = (JSPUtil.getParameter(request, prefix	+ "hid_door_node", length));
			String[] selSpoption = (JSPUtil.getParameter(request, prefix	+ "sel_spoption", length));
			String[] hidFromDate = (JSPUtil.getParameter(request, prefix	+ "hid_from_date", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComparisonCondVO();
				if (selTransmode[i] != null)
					model.setSelTransmode(selTransmode[i]);
				if (hidToDate[i] != null)
					model.setHidToDate(hidToDate[i]);
				if (hidViaNode[i] != null)
					model.setHidViaNode(hidViaNode[i]);
				if (hidToNode[i] != null)
					model.setHidToNode(hidToNode[i]);
				if (selInputOffice[i] != null)
					model.setSelInputOffice(selInputOffice[i]);
				if (selCostmode[i] != null)
					model.setSelCostmode(selCostmode[i]);
				if (selWono[i] != null)
					model.setSelWono(selWono[i]);
				if (selCntrno[i] != null)
					model.setSelCntrno(selCntrno[i]);
				if (selBkgno[i] != null)
					model.setSelBkgno(selBkgno[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hidFromNode[i] != null)
					model.setHidFromNode(hidFromNode[i]);
				if (selBound[i] != null)
					model.setSelBound(selBound[i]);
				if (selSotype[i] != null)
					model.setSelSotype(selSotype[i]);
				if (selSono[i] != null)
					model.setSelSono(selSono[i]);
				if (hidDoorNode[i] != null)
					model.setHidDoorNode(hidDoorNode[i]);
				if (selSpoption[i] != null)
					model.setSelSpoption(selSpoption[i]);
				if (hidFromDate[i] != null)
					model.setHidFromDate(hidFromDate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComparisonCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComparisonCondVO[]
	 */
	public ComparisonCondVO[] getComparisonCondVOs(){
		ComparisonCondVO[] vos = (ComparisonCondVO[])models.toArray(new ComparisonCondVO[models.size()]);
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
		this.selTransmode = this.selTransmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidToDate = this.hidToDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidViaNode = this.hidViaNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidToNode = this.hidToNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selInputOffice = this.selInputOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selCostmode = this.selCostmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selWono = this.selWono .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selCntrno = this.selCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selBkgno = this.selBkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFromNode = this.hidFromNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selBound = this.selBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selSotype = this.selSotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selSono = this.selSono .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidDoorNode = this.hidDoorNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selSpoption = this.selSpoption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFromDate = this.hidFromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
