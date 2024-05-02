/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1018ConditionVO.java
*@FileTitle : EesEqr1018ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.06  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo;

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
 * 관련 Event 에서 생성, 서버실행시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr1018ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1018ConditionVO> models = new ArrayList<EesEqr1018ConditionVO>();
	
	/* Column Info */
	private String divdate = null;
	/* Column Info */
	private String divname = null;
	/* Column Info */
	private String fromlocation = null;
	/* Column Info */
	private String todate = null;
	/* Column Info */
	private String tpszall = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String divflag = null;
	/* Column Info */
	private String vvdname = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String itemname = null;
	/* Column Info */
	private String fromdate = null;
	/* Column Info */
	private String tolocation = null;
	/* Column Info */
	private String fromstatus = null;
	/* Column Info */
	private String tostatus = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1018ConditionVO() {}

	public EesEqr1018ConditionVO(String ibflag, String pagerows, String divflag, String divdate, String fromdate, String todate, String vvdname, String fromstatus, String fromlocation, String tostatus, String tolocation, String lane, String itemname, String divname, String tpszall) {
		this.divdate = divdate;
		this.divname = divname;
		this.fromlocation = fromlocation;
		this.todate = todate;
		this.tpszall = tpszall;
		this.pagerows = pagerows;
		this.lane = lane;
		this.divflag = divflag;
		this.vvdname = vvdname;
		this.ibflag = ibflag;
		this.itemname = itemname;
		this.fromdate = fromdate;
		this.tolocation = tolocation;
		this.fromstatus = fromstatus;
		this.tostatus = tostatus;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("divdate", getDivDate());
		this.hashColumns.put("divname", getDivname());
		this.hashColumns.put("fromlocation", getFromlocation());
		this.hashColumns.put("todate", getTodate());
		this.hashColumns.put("tpszall", getTpszall());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("divflag", getDivFlag());
		this.hashColumns.put("vvdname", getVvdName());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("itemname", getItemname());
		this.hashColumns.put("fromdate", getFromdate());
		this.hashColumns.put("tolocation", getTolocation());
		this.hashColumns.put("fromstatus", getFromstatus());
		this.hashColumns.put("tostatus", getTostatus());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("divdate", "divdate");
		this.hashFields.put("divname", "divname");
		this.hashFields.put("fromlocation", "fromlocation");
		this.hashFields.put("todate", "todate");
		this.hashFields.put("tpszall", "tpszall");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("divflag", "divflag");
		this.hashFields.put("vvdname", "vvdname");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("itemname", "itemname");
		this.hashFields.put("fromdate", "fromdate");
		this.hashFields.put("tolocation", "tolocation");
		this.hashFields.put("fromstatus", "fromstatus");
		this.hashFields.put("tostatus", "tostatus");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return divdate
	 */
	public String getDivDate() {
		return this.divdate;
	}
	
	/**
	 * Column Info
	 * @return divname
	 */
	public String getDivname() {
		return this.divname;
	}
	
	/**
	 * Column Info
	 * @return fromlocation
	 */
	public String getFromlocation() {
		return this.fromlocation;
	}
	
	/**
	 * Column Info
	 * @return todate
	 */
	public String getTodate() {
		return this.todate;
	}
	
	/**
	 * Column Info
	 * @return tpszall
	 */
	public String getTpszall() {
		return this.tpszall;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return divflag
	 */
	public String getDivFlag() {
		return this.divflag;
	}
	
	/**
	 * Column Info
	 * @return vvdname
	 */
	public String getVvdName() {
		return this.vvdname;
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
	 * @return itemname
	 */
	public String getItemname() {
		return this.itemname;
	}
	
	/**
	 * Column Info
	 * @return fromdate
	 */
	public String getFromdate() {
		return this.fromdate;
	}
	
	/**
	 * Column Info
	 * @return tolocation
	 */
	public String getTolocation() {
		return this.tolocation;
	}
	
	/**
	 * Column Info
	 * @return fromstatus
	 */
	public String getFromstatus() {
		return this.fromstatus;
	}
	
	/**
	 * Column Info
	 * @return tostatus
	 */
	public String getTostatus() {
		return this.tostatus;
	}
	

	/**
	 * Column Info
	 * @param divdate
	 */
	public void setDivDate(String divdate) {
		this.divdate = divdate;
	}
	
	/**
	 * Column Info
	 * @param divname
	 */
	public void setDivname(String divname) {
		this.divname = divname;
	}
	
	/**
	 * Column Info
	 * @param fromlocation
	 */
	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}
	
	/**
	 * Column Info
	 * @param todate
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	/**
	 * Column Info
	 * @param tpszall
	 */
	public void setTpszall(String tpszall) {
		this.tpszall = tpszall;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param divflag
	 */
	public void setDivFlag(String divflag) {
		this.divflag = divflag;
	}
	
	/**
	 * Column Info
	 * @param vvdname
	 */
	public void setVvdName(String vvdname) {
		this.vvdname = vvdname;
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
	 * @param itemname
	 */
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	/**
	 * Column Info
	 * @param fromdate
	 */
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	
	/**
	 * Column Info
	 * @param tolocation
	 */
	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}
	
	/**
	 * Column Info
	 * @param fromstatus
	 */
	public void setFromstatus(String fromstatus) {
		this.fromstatus = fromstatus;
	}
	
	/**
	 * Column Info
	 * @param tostatus
	 */
	public void setTostatus(String tostatus) {
		this.tostatus = tostatus;
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
		setDivDate(JSPUtil.getParameter(request, prefix + "divdate", ""));
		setDivname(JSPUtil.getParameter(request, prefix + "divname", ""));
		setFromlocation(JSPUtil.getParameter(request, prefix + "fromlocation", ""));
		setTodate(JSPUtil.getParameter(request, prefix + "todate", ""));
		setTpszall(JSPUtil.getParameter(request, prefix + "tpszall", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setDivFlag(JSPUtil.getParameter(request, prefix + "divflag", ""));
		setVvdName(JSPUtil.getParameter(request, prefix + "vvdname", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setItemname(JSPUtil.getParameter(request, prefix + "itemname", ""));
		setFromdate(JSPUtil.getParameter(request, prefix + "fromdate", ""));
		setTolocation(JSPUtil.getParameter(request, prefix + "tolocation", ""));
		setFromstatus(JSPUtil.getParameter(request, prefix + "fromstatus", ""));
		setTostatus(JSPUtil.getParameter(request, prefix + "tostatus", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1018ConditionVO[]
	 */
	public EesEqr1018ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1018ConditionVO[]
	 */
	public EesEqr1018ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1018ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] divdate = (JSPUtil.getParameter(request, prefix	+ "divdate", length));
			String[] divname = (JSPUtil.getParameter(request, prefix	+ "divname", length));
			String[] fromlocation = (JSPUtil.getParameter(request, prefix	+ "fromlocation", length));
			String[] todate = (JSPUtil.getParameter(request, prefix	+ "todate", length));
			String[] tpszall = (JSPUtil.getParameter(request, prefix	+ "tpszall", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] divflag = (JSPUtil.getParameter(request, prefix	+ "divflag", length));
			String[] vvdname = (JSPUtil.getParameter(request, prefix	+ "vvdname", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] itemname = (JSPUtil.getParameter(request, prefix	+ "itemname", length));
			String[] fromdate = (JSPUtil.getParameter(request, prefix	+ "fromdate", length));
			String[] tolocation = (JSPUtil.getParameter(request, prefix	+ "tolocation", length));
			String[] fromstatus = (JSPUtil.getParameter(request, prefix	+ "fromstatus", length));
			String[] tostatus = (JSPUtil.getParameter(request, prefix	+ "tostatus", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1018ConditionVO();
				if (divdate[i] != null)
					model.setDivDate(divdate[i]);
				if (divname[i] != null)
					model.setDivname(divname[i]);
				if (fromlocation[i] != null)
					model.setFromlocation(fromlocation[i]);
				if (todate[i] != null)
					model.setTodate(todate[i]);
				if (tpszall[i] != null)
					model.setTpszall(tpszall[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (divflag[i] != null)
					model.setDivFlag(divflag[i]);
				if (vvdname[i] != null)
					model.setVvdName(vvdname[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (itemname[i] != null)
					model.setItemname(itemname[i]);
				if (fromdate[i] != null)
					model.setFromdate(fromdate[i]);
				if (tolocation[i] != null)
					model.setTolocation(tolocation[i]);
				if (fromstatus[i] != null)
					model.setFromstatus(fromstatus[i]);
				if (tostatus[i] != null)
					model.setTostatus(tostatus[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1018ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1018ConditionVO[]
	 */
	public EesEqr1018ConditionVO[] getEesEqr1018ConditionVOs(){
		EesEqr1018ConditionVO[] vos = (EesEqr1018ConditionVO[])models.toArray(new EesEqr1018ConditionVO[models.size()]);
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
		this.divdate = this.divdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divname = this.divname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromlocation = this.fromlocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todate = this.todate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszall = this.tpszall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divflag = this.divflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdname = this.vvdname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemname = this.itemname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromdate = this.fromdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tolocation = this.tolocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromstatus = this.fromstatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tostatus = this.tostatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
