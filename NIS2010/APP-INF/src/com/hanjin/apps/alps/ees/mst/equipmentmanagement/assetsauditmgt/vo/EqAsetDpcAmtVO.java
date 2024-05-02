/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EqAsetDpcAmtVO.java
*@FileTitle : EqAsetDpcAmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqAsetDpcAmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqAsetDpcAmtVO> models = new ArrayList<EqAsetDpcAmtVO>();
	
	/* Column Info */
	private String alpsAmt = null;
	/* Column Info */
	private String faQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String alpsQty = null;
	/* Column Info */
	private String faAvg = null;
	/* Column Info */
	private String faAmt = null;
	/* Column Info */
	private String alpsAvg = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqAsetDpcAmtVO() {}

	public EqAsetDpcAmtVO(String ibflag, String pagerows, String eqTpszCd, String alpsQty, String alpsAmt, String alpsAvg, String faQty, String faAmt, String faAvg) {
		this.alpsAmt = alpsAmt;
		this.faQty = faQty;
		this.ibflag = ibflag;
		this.alpsQty = alpsQty;
		this.faAvg = faAvg;
		this.faAmt = faAmt;
		this.alpsAvg = alpsAvg;
		this.eqTpszCd = eqTpszCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("alps_amt", getAlpsAmt());
		this.hashColumns.put("fa_qty", getFaQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("alps_qty", getAlpsQty());
		this.hashColumns.put("fa_avg", getFaAvg());
		this.hashColumns.put("fa_amt", getFaAmt());
		this.hashColumns.put("alps_avg", getAlpsAvg());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("alps_amt", "alpsAmt");
		this.hashFields.put("fa_qty", "faQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("alps_qty", "alpsQty");
		this.hashFields.put("fa_avg", "faAvg");
		this.hashFields.put("fa_amt", "faAmt");
		this.hashFields.put("alps_avg", "alpsAvg");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return alpsAmt
	 */
	public String getAlpsAmt() {
		return this.alpsAmt;
	}
	
	/**
	 * Column Info
	 * @return faQty
	 */
	public String getFaQty() {
		return this.faQty;
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
	 * @return alpsQty
	 */
	public String getAlpsQty() {
		return this.alpsQty;
	}
	
	/**
	 * Column Info
	 * @return faAvg
	 */
	public String getFaAvg() {
		return this.faAvg;
	}
	
	/**
	 * Column Info
	 * @return faAmt
	 */
	public String getFaAmt() {
		return this.faAmt;
	}
	
	/**
	 * Column Info
	 * @return alpsAvg
	 */
	public String getAlpsAvg() {
		return this.alpsAvg;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @param alpsAmt
	 */
	public void setAlpsAmt(String alpsAmt) {
		this.alpsAmt = alpsAmt;
	}
	
	/**
	 * Column Info
	 * @param faQty
	 */
	public void setFaQty(String faQty) {
		this.faQty = faQty;
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
	 * @param alpsQty
	 */
	public void setAlpsQty(String alpsQty) {
		this.alpsQty = alpsQty;
	}
	
	/**
	 * Column Info
	 * @param faAvg
	 */
	public void setFaAvg(String faAvg) {
		this.faAvg = faAvg;
	}
	
	/**
	 * Column Info
	 * @param faAmt
	 */
	public void setFaAmt(String faAmt) {
		this.faAmt = faAmt;
	}
	
	/**
	 * Column Info
	 * @param alpsAvg
	 */
	public void setAlpsAvg(String alpsAvg) {
		this.alpsAvg = alpsAvg;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
		setAlpsAmt(JSPUtil.getParameter(request, prefix + "alps_amt", ""));
		setFaQty(JSPUtil.getParameter(request, prefix + "fa_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAlpsQty(JSPUtil.getParameter(request, prefix + "alps_qty", ""));
		setFaAvg(JSPUtil.getParameter(request, prefix + "fa_avg", ""));
		setFaAmt(JSPUtil.getParameter(request, prefix + "fa_amt", ""));
		setAlpsAvg(JSPUtil.getParameter(request, prefix + "alps_avg", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqAsetDpcAmtVO[]
	 */
	public EqAsetDpcAmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqAsetDpcAmtVO[]
	 */
	public EqAsetDpcAmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqAsetDpcAmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] alpsAmt = (JSPUtil.getParameter(request, prefix	+ "alps_amt", length));
			String[] faQty = (JSPUtil.getParameter(request, prefix	+ "fa_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] alpsQty = (JSPUtil.getParameter(request, prefix	+ "alps_qty", length));
			String[] faAvg = (JSPUtil.getParameter(request, prefix	+ "fa_avg", length));
			String[] faAmt = (JSPUtil.getParameter(request, prefix	+ "fa_amt", length));
			String[] alpsAvg = (JSPUtil.getParameter(request, prefix	+ "alps_avg", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqAsetDpcAmtVO();
				if (alpsAmt[i] != null)
					model.setAlpsAmt(alpsAmt[i]);
				if (faQty[i] != null)
					model.setFaQty(faQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (alpsQty[i] != null)
					model.setAlpsQty(alpsQty[i]);
				if (faAvg[i] != null)
					model.setFaAvg(faAvg[i]);
				if (faAmt[i] != null)
					model.setFaAmt(faAmt[i]);
				if (alpsAvg[i] != null)
					model.setAlpsAvg(alpsAvg[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqAsetDpcAmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqAsetDpcAmtVO[]
	 */
	public EqAsetDpcAmtVO[] getEqAsetDpcAmtVOs(){
		EqAsetDpcAmtVO[] vos = (EqAsetDpcAmtVO[])models.toArray(new EqAsetDpcAmtVO[models.size()]);
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
		this.alpsAmt = this.alpsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faQty = this.faQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsQty = this.alpsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faAvg = this.faAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faAmt = this.faAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsAvg = this.alpsAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
