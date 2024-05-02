/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TmnlPerformVO.java
*@FileTitle : TmnlPerformVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.03.02 장석현 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TmnlPerformVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TmnlPerformVO> models = new ArrayList<TmnlPerformVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String workGross = null;
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String avgClan = null;
	/* Column Info */
	private String gangGross = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totMvs = null;
	/* Column Info */
	private String gangProd = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String tmnlProd = null;
	/* Column Info */
	private String tdrQty = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TmnlPerformVO() {}

	public TmnlPerformVO(String ibflag, String pagerows, String rhq, String port, String yard, String lane, String month, String tdrQty, String totMvs, String workGross, String gangGross, String tmnlProd, String gangProd, String avgClan) {
		this.port = port;
		this.workGross = workGross;
		this.yard = yard;
		this.avgClan = avgClan;
		this.gangGross = gangGross;
		this.pagerows = pagerows;
		this.lane = lane;
		this.ibflag = ibflag;
		this.totMvs = totMvs;
		this.gangProd = gangProd;
		this.month = month;
		this.tmnlProd = tmnlProd;
		this.tdrQty = tdrQty;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("work_gross", getWorkGross());
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("avg_clan", getAvgClan());
		this.hashColumns.put("gang_gross", getGangGross());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot_mvs", getTotMvs());
		this.hashColumns.put("gang_prod", getGangProd());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("tmnl_prod", getTmnlProd());
		this.hashColumns.put("tdr_qty", getTdrQty());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("work_gross", "workGross");
		this.hashFields.put("yard", "yard");
		this.hashFields.put("avg_clan", "avgClan");
		this.hashFields.put("gang_gross", "gangGross");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot_mvs", "totMvs");
		this.hashFields.put("gang_prod", "gangProd");
		this.hashFields.put("month", "month");
		this.hashFields.put("tmnl_prod", "tmnlProd");
		this.hashFields.put("tdr_qty", "tdrQty");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return workGross
	 */
	public String getWorkGross() {
		return this.workGross;
	}
	
	/**
	 * Column Info
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}
	
	/**
	 * Column Info
	 * @return avgClan
	 */
	public String getAvgClan() {
		return this.avgClan;
	}
	
	/**
	 * Column Info
	 * @return gangGross
	 */
	public String getGangGross() {
		return this.gangGross;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return totMvs
	 */
	public String getTotMvs() {
		return this.totMvs;
	}
	
	/**
	 * Column Info
	 * @return gangProd
	 */
	public String getGangProd() {
		return this.gangProd;
	}
	
	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
	}
	
	/**
	 * Column Info
	 * @return tmnlProd
	 */
	public String getTmnlProd() {
		return this.tmnlProd;
	}
	
	/**
	 * Column Info
	 * @return tdrQty
	 */
	public String getTdrQty() {
		return this.tdrQty;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param workGross
	 */
	public void setWorkGross(String workGross) {
		this.workGross = workGross;
	}
	
	/**
	 * Column Info
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}
	
	/**
	 * Column Info
	 * @param avgClan
	 */
	public void setAvgClan(String avgClan) {
		this.avgClan = avgClan;
	}
	
	/**
	 * Column Info
	 * @param gangGross
	 */
	public void setGangGross(String gangGross) {
		this.gangGross = gangGross;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param totMvs
	 */
	public void setTotMvs(String totMvs) {
		this.totMvs = totMvs;
	}
	
	/**
	 * Column Info
	 * @param gangProd
	 */
	public void setGangProd(String gangProd) {
		this.gangProd = gangProd;
	}
	
	/**
	 * Column Info
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * Column Info
	 * @param tmnlProd
	 */
	public void setTmnlProd(String tmnlProd) {
		this.tmnlProd = tmnlProd;
	}
	
	/**
	 * Column Info
	 * @param tdrQty
	 */
	public void setTdrQty(String tdrQty) {
		this.tdrQty = tdrQty;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setWorkGross(JSPUtil.getParameter(request, prefix + "work_gross", ""));
		setYard(JSPUtil.getParameter(request, prefix + "yard", ""));
		setAvgClan(JSPUtil.getParameter(request, prefix + "avg_clan", ""));
		setGangGross(JSPUtil.getParameter(request, prefix + "gang_gross", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotMvs(JSPUtil.getParameter(request, prefix + "tot_mvs", ""));
		setGangProd(JSPUtil.getParameter(request, prefix + "gang_prod", ""));
		setMonth(JSPUtil.getParameter(request, prefix + "month", ""));
		setTmnlProd(JSPUtil.getParameter(request, prefix + "tmnl_prod", ""));
		setTdrQty(JSPUtil.getParameter(request, prefix + "tdr_qty", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TmnlPerformVO[]
	 */
	public TmnlPerformVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TmnlPerformVO[]
	 */
	public TmnlPerformVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TmnlPerformVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] workGross = (JSPUtil.getParameter(request, prefix	+ "work_gross", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] avgClan = (JSPUtil.getParameter(request, prefix	+ "avg_clan", length));
			String[] gangGross = (JSPUtil.getParameter(request, prefix	+ "gang_gross", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totMvs = (JSPUtil.getParameter(request, prefix	+ "tot_mvs", length));
			String[] gangProd = (JSPUtil.getParameter(request, prefix	+ "gang_prod", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] tmnlProd = (JSPUtil.getParameter(request, prefix	+ "tmnl_prod", length));
			String[] tdrQty = (JSPUtil.getParameter(request, prefix	+ "tdr_qty", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new TmnlPerformVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (workGross[i] != null)
					model.setWorkGross(workGross[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (avgClan[i] != null)
					model.setAvgClan(avgClan[i]);
				if (gangGross[i] != null)
					model.setGangGross(gangGross[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totMvs[i] != null)
					model.setTotMvs(totMvs[i]);
				if (gangProd[i] != null)
					model.setGangProd(gangProd[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (tmnlProd[i] != null)
					model.setTmnlProd(tmnlProd[i]);
				if (tdrQty[i] != null)
					model.setTdrQty(tdrQty[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTmnlPerformVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TmnlPerformVO[]
	 */
	public TmnlPerformVO[] getTmnlPerformVOs(){
		TmnlPerformVO[] vos = (TmnlPerformVO[])models.toArray(new TmnlPerformVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workGross = this.workGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgClan = this.avgClan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangGross = this.gangGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMvs = this.totMvs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangProd = this.gangProd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlProd = this.tmnlProd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tdrQty = this.tdrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
