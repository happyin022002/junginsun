/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AwkCostByCgoRoutVO.java
*@FileTitle : AwkCostByCgoRoutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.05
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.04.05 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo;

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
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AwkCostByCgoRoutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AwkCostByCgoRoutVO> models = new ArrayList<AwkCostByCgoRoutVO>();
	
	/* Column Info */
	private String cgoSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tCost = null;
	/* Column Info */
	private String nCost = null;
	/* Column Info */
	private String gCost = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String sCost = null;
	/* Column Info */
	private String aCost = null;
	/* Column Info */
	private String wCost = null;
	/* Column Info */
	private String routSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AwkCostByCgoRoutVO() {}

	public AwkCostByCgoRoutVO(String ibflag, String pagerows, String cgoSeq, String routSeq, String cntrQty, String nCost, String wCost, String gCost, String tCost, String sCost, String aCost) {
		this.cgoSeq = cgoSeq;
		this.ibflag = ibflag;
		this.tCost = tCost;
		this.nCost = nCost;
		this.gCost = gCost;
		this.cntrQty = cntrQty;
		this.sCost = sCost;
		this.aCost = aCost;
		this.wCost = wCost;
		this.routSeq = routSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_seq", getCgoSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("t_cost", getTCost());
		this.hashColumns.put("n_cost", getNCost());
		this.hashColumns.put("g_cost", getGCost());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("s_cost", getSCost());
		this.hashColumns.put("a_cost", getACost());
		this.hashColumns.put("w_cost", getWCost());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_seq", "cgoSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("t_cost", "tCost");
		this.hashFields.put("n_cost", "nCost");
		this.hashFields.put("g_cost", "gCost");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("s_cost", "sCost");
		this.hashFields.put("a_cost", "aCost");
		this.hashFields.put("w_cost", "wCost");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoSeq
	 */
	public String getCgoSeq() {
		return this.cgoSeq;
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
	 * @return tCost
	 */
	public String getTCost() {
		return this.tCost;
	}
	
	/**
	 * Column Info
	 * @return nCost
	 */
	public String getNCost() {
		return this.nCost;
	}
	
	/**
	 * Column Info
	 * @return gCost
	 */
	public String getGCost() {
		return this.gCost;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return sCost
	 */
	public String getSCost() {
		return this.sCost;
	}
	
	/**
	 * Column Info
	 * @return aCost
	 */
	public String getACost() {
		return this.aCost;
	}
	
	/**
	 * Column Info
	 * @return wCost
	 */
	public String getWCost() {
		return this.wCost;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @param cgoSeq
	 */
	public void setCgoSeq(String cgoSeq) {
		this.cgoSeq = cgoSeq;
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
	 * @param tCost
	 */
	public void setTCost(String tCost) {
		this.tCost = tCost;
	}
	
	/**
	 * Column Info
	 * @param nCost
	 */
	public void setNCost(String nCost) {
		this.nCost = nCost;
	}
	
	/**
	 * Column Info
	 * @param gCost
	 */
	public void setGCost(String gCost) {
		this.gCost = gCost;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param sCost
	 */
	public void setSCost(String sCost) {
		this.sCost = sCost;
	}
	
	/**
	 * Column Info
	 * @param aCost
	 */
	public void setACost(String aCost) {
		this.aCost = aCost;
	}
	
	/**
	 * Column Info
	 * @param wCost
	 */
	public void setWCost(String wCost) {
		this.wCost = wCost;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
		setCgoSeq(JSPUtil.getParameter(request, prefix + "cgo_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTCost(JSPUtil.getParameter(request, prefix + "t_cost", ""));
		setNCost(JSPUtil.getParameter(request, prefix + "n_cost", ""));
		setGCost(JSPUtil.getParameter(request, prefix + "g_cost", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setSCost(JSPUtil.getParameter(request, prefix + "s_cost", ""));
		setACost(JSPUtil.getParameter(request, prefix + "a_cost", ""));
		setWCost(JSPUtil.getParameter(request, prefix + "w_cost", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AwkCostByCgoRoutVO[]
	 */
	public AwkCostByCgoRoutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AwkCostByCgoRoutVO[]
	 */
	public AwkCostByCgoRoutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AwkCostByCgoRoutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoSeq = (JSPUtil.getParameter(request, prefix	+ "cgo_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tCost = (JSPUtil.getParameter(request, prefix	+ "t_cost", length));
			String[] nCost = (JSPUtil.getParameter(request, prefix	+ "n_cost", length));
			String[] gCost = (JSPUtil.getParameter(request, prefix	+ "g_cost", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] sCost = (JSPUtil.getParameter(request, prefix	+ "s_cost", length));
			String[] aCost = (JSPUtil.getParameter(request, prefix	+ "a_cost", length));
			String[] wCost = (JSPUtil.getParameter(request, prefix	+ "w_cost", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AwkCostByCgoRoutVO();
				if (cgoSeq[i] != null)
					model.setCgoSeq(cgoSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tCost[i] != null)
					model.setTCost(tCost[i]);
				if (nCost[i] != null)
					model.setNCost(nCost[i]);
				if (gCost[i] != null)
					model.setGCost(gCost[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (sCost[i] != null)
					model.setSCost(sCost[i]);
				if (aCost[i] != null)
					model.setACost(aCost[i]);
				if (wCost[i] != null)
					model.setWCost(wCost[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAwkCostByCgoRoutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AwkCostByCgoRoutVO[]
	 */
	public AwkCostByCgoRoutVO[] getAwkCostByCgoRoutVOs(){
		AwkCostByCgoRoutVO[] vos = (AwkCostByCgoRoutVO[])models.toArray(new AwkCostByCgoRoutVO[models.size()]);
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
		this.cgoSeq = this.cgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCost = this.tCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCost = this.nCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gCost = this.gCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCost = this.sCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCost = this.aCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wCost = this.wCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
