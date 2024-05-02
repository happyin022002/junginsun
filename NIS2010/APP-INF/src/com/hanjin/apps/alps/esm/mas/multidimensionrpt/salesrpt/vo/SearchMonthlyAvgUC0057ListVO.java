/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyAvgUC0057ListVO.java
*@FileTitle : SearchMonthlyAvgUC0057ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.13 김기식 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo;

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
 * @author 김기식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyAvgUC0057ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyAvgUC0057ListVO> models = new ArrayList<SearchMonthlyAvgUC0057ListVO>();
	
	/* Column Info */
	private String rev = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String tpszCode = null;
	/* Column Info */
	private String revPodCd = null;
	/* Column Info */
	private String revPolCd = null;
	/* Column Info */
	private String load = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String cmCost = null;
	/* Column Info */
	private String opCost = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyAvgUC0057ListVO() {}

	public SearchMonthlyAvgUC0057ListVO(String ibflag, String pagerows, String revPolCd, String revPodCd, String rlaneCd, String tpszCode, String load, String rev, String cmCost, String cm, String opCost, String op) {
		this.rev = rev;
		this.ibflag = ibflag;
		this.op = op;
		this.cm = cm;
		this.tpszCode = tpszCode;
		this.revPodCd = revPodCd;
		this.revPolCd = revPolCd;
		this.load = load;
		this.rlaneCd = rlaneCd;
		this.cmCost = cmCost;
		this.opCost = opCost;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev", getRev());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("tpsz_code", getTpszCode());
		this.hashColumns.put("rev_pod_cd", getRevPodCd());
		this.hashColumns.put("rev_pol_cd", getRevPolCd());
		this.hashColumns.put("load", getLoad());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cm_cost", getCmCost());
		this.hashColumns.put("op_cost", getOpCost());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev", "rev");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("op", "op");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("tpsz_code", "tpszCode");
		this.hashFields.put("rev_pod_cd", "revPodCd");
		this.hashFields.put("rev_pol_cd", "revPolCd");
		this.hashFields.put("load", "load");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cm_cost", "cmCost");
		this.hashFields.put("op_cost", "opCost");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rev
	 */
	public String getRev() {
		return this.rev;
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
	 * @return op
	 */
	public String getOp() {
		return this.op;
	}
	
	/**
	 * Column Info
	 * @return cm
	 */
	public String getCm() {
		return this.cm;
	}
	
	/**
	 * Column Info
	 * @return tpszCode
	 */
	public String getTpszCode() {
		return this.tpszCode;
	}
	
	/**
	 * Column Info
	 * @return revPodCd
	 */
	public String getRevPodCd() {
		return this.revPodCd;
	}
	
	/**
	 * Column Info
	 * @return revPolCd
	 */
	public String getRevPolCd() {
		return this.revPolCd;
	}
	
	/**
	 * Column Info
	 * @return load
	 */
	public String getLoad() {
		return this.load;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return cmCost
	 */
	public String getCmCost() {
		return this.cmCost;
	}
	
	/**
	 * Column Info
	 * @return opCost
	 */
	public String getOpCost() {
		return this.opCost;
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
	 * @param rev
	 */
	public void setRev(String rev) {
		this.rev = rev;
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
	 * @param op
	 */
	public void setOp(String op) {
		this.op = op;
	}
	
	/**
	 * Column Info
	 * @param cm
	 */
	public void setCm(String cm) {
		this.cm = cm;
	}
	
	/**
	 * Column Info
	 * @param tpszCode
	 */
	public void setTpszCode(String tpszCode) {
		this.tpszCode = tpszCode;
	}
	
	/**
	 * Column Info
	 * @param revPodCd
	 */
	public void setRevPodCd(String revPodCd) {
		this.revPodCd = revPodCd;
	}
	
	/**
	 * Column Info
	 * @param revPolCd
	 */
	public void setRevPolCd(String revPolCd) {
		this.revPolCd = revPolCd;
	}
	
	/**
	 * Column Info
	 * @param load
	 */
	public void setLoad(String load) {
		this.load = load;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param cmCost
	 */
	public void setCmCost(String cmCost) {
		this.cmCost = cmCost;
	}
	
	/**
	 * Column Info
	 * @param opCost
	 */
	public void setOpCost(String opCost) {
		this.opCost = opCost;
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
		setRev(JSPUtil.getParameter(request, "rev", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOp(JSPUtil.getParameter(request, "op", ""));
		setCm(JSPUtil.getParameter(request, "cm", ""));
		setTpszCode(JSPUtil.getParameter(request, "tpsz_code", ""));
		setRevPodCd(JSPUtil.getParameter(request, "rev_pod_cd", ""));
		setRevPolCd(JSPUtil.getParameter(request, "rev_pol_cd", ""));
		setLoad(JSPUtil.getParameter(request, "load", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setCmCost(JSPUtil.getParameter(request, "cm_cost", ""));
		setOpCost(JSPUtil.getParameter(request, "op_cost", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyAvgUC0057ListVO[]
	 */
	public SearchMonthlyAvgUC0057ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyAvgUC0057ListVO[]
	 */
	public SearchMonthlyAvgUC0057ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyAvgUC0057ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rev = (JSPUtil.getParameter(request, prefix	+ "rev", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] tpszCode = (JSPUtil.getParameter(request, prefix	+ "tpsz_code", length));
			String[] revPodCd = (JSPUtil.getParameter(request, prefix	+ "rev_pod_cd", length));
			String[] revPolCd = (JSPUtil.getParameter(request, prefix	+ "rev_pol_cd", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] cmCost = (JSPUtil.getParameter(request, prefix	+ "cm_cost", length));
			String[] opCost = (JSPUtil.getParameter(request, prefix	+ "op_cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyAvgUC0057ListVO();
				if (rev[i] != null)
					model.setRev(rev[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (tpszCode[i] != null)
					model.setTpszCode(tpszCode[i]);
				if (revPodCd[i] != null)
					model.setRevPodCd(revPodCd[i]);
				if (revPolCd[i] != null)
					model.setRevPolCd(revPolCd[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (cmCost[i] != null)
					model.setCmCost(cmCost[i]);
				if (opCost[i] != null)
					model.setOpCost(opCost[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyAvgUC0057ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyAvgUC0057ListVO[]
	 */
	public SearchMonthlyAvgUC0057ListVO[] getSearchMonthlyAvgUC0057ListVOs(){
		SearchMonthlyAvgUC0057ListVO[] vos = (SearchMonthlyAvgUC0057ListVO[])models.toArray(new SearchMonthlyAvgUC0057ListVO[models.size()]);
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
		this.rev = this.rev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCode = this.tpszCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPodCd = this.revPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPolCd = this.revPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCost = this.cmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCost = this.opCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
