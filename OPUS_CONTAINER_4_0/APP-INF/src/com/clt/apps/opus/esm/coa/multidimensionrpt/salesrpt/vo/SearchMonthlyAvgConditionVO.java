/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyAvgConditionVO.java
*@FileTitle : SearchMonthlyAvgConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.13 김기식 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyAvgConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyAvgConditionVO> models = new ArrayList<SearchMonthlyAvgConditionVO>();
	
	/* Column Info */
	private String fKind = null;
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String fPol = null;
	/* Column Info */
	private String fFrom = null;
	/* Column Info */
	private String fDeTerm = null;
	/* Column Info */
	private String fRcvTerm = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fRlane = null;
	/* Column Info */
	private String fTo = null;
	/* Column Info */
	private String fTpsz = null;
	/* Column Info */
	private String fProVw = null;
	/* Column Info */
	private String fPod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyAvgConditionVO() {}

	public SearchMonthlyAvgConditionVO(String ibflag, String pagerows, String fCostYrmon, String fFrom, String fTo, String fCntrTpszCd, String fKind, String fPol, String fPod, String fRlane, String fTpsz, String fProVw, String fRcvTerm, String fDeTerm) {
		this.fKind = fKind;
		this.fCostYrmon = fCostYrmon;
		this.fPol = fPol;
		this.fFrom = fFrom;
		this.fDeTerm = fDeTerm;
		this.fRcvTerm = fRcvTerm;
		this.fCntrTpszCd = fCntrTpszCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fRlane = fRlane;
		this.fTo = fTo;
		this.fTpsz = fTpsz;
		this.fProVw = fProVw;
		this.fPod = fPod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_kind", getFKind());
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("f_pol", getFPol());
		this.hashColumns.put("f_from", getFFrom());
		this.hashColumns.put("f_de_term", getFDeTerm());
		this.hashColumns.put("f_rcv_term", getFRcvTerm());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_rlane", getFRlane());
		this.hashColumns.put("f_to", getFTo());
		this.hashColumns.put("f_tpsz", getFTpsz());
		this.hashColumns.put("f_pro_vw", getFProVw());
		this.hashColumns.put("f_pod", getFPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_kind", "fKind");
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("f_pol", "fPol");
		this.hashFields.put("f_from", "fFrom");
		this.hashFields.put("f_de_term", "fDeTerm");
		this.hashFields.put("f_rcv_term", "fRcvTerm");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_rlane", "fRlane");
		this.hashFields.put("f_to", "fTo");
		this.hashFields.put("f_tpsz", "fTpsz");
		this.hashFields.put("f_pro_vw", "fProVw");
		this.hashFields.put("f_pod", "fPod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fKind
	 */
	public String getFKind() {
		return this.fKind;
	}
	
	/**
	 * Column Info
	 * @return fCostYrmon
	 */
	public String getFCostYrmon() {
		return this.fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return fPol
	 */
	public String getFPol() {
		return this.fPol;
	}
	
	/**
	 * Column Info
	 * @return fFrom
	 */
	public String getFFrom() {
		return this.fFrom;
	}
	
	/**
	 * Column Info
	 * @return fDeTerm
	 */
	public String getFDeTerm() {
		return this.fDeTerm;
	}
	
	/**
	 * Column Info
	 * @return fRcvTerm
	 */
	public String getFRcvTerm() {
		return this.fRcvTerm;
	}
	
	/**
	 * Column Info
	 * @return fCntrTpszCd
	 */
	public String getFCntrTpszCd() {
		return this.fCntrTpszCd;
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
	 * @return fRlane
	 */
	public String getFRlane() {
		return this.fRlane;
	}
	
	/**
	 * Column Info
	 * @return fTo
	 */
	public String getFTo() {
		return this.fTo;
	}
	
	/**
	 * Column Info
	 * @return fTpsz
	 */
	public String getFTpsz() {
		return this.fTpsz;
	}
	
	/**
	 * Column Info
	 * @return fProVw
	 */
	public String getFProVw() {
		return this.fProVw;
	}
	
	/**
	 * Column Info
	 * @return fPod
	 */
	public String getFPod() {
		return this.fPod;
	}
	

	/**
	 * Column Info
	 * @param fKind
	 */
	public void setFKind(String fKind) {
		this.fKind = fKind;
	}
	
	/**
	 * Column Info
	 * @param fCostYrmon
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param fPol
	 */
	public void setFPol(String fPol) {
		this.fPol = fPol;
	}
	
	/**
	 * Column Info
	 * @param fFrom
	 */
	public void setFFrom(String fFrom) {
		this.fFrom = fFrom;
	}
	
	/**
	 * Column Info
	 * @param fDeTerm
	 */
	public void setFDeTerm(String fDeTerm) {
		this.fDeTerm = fDeTerm;
	}
	
	/**
	 * Column Info
	 * @param fRcvTerm
	 */
	public void setFRcvTerm(String fRcvTerm) {
		this.fRcvTerm = fRcvTerm;
	}
	
	/**
	 * Column Info
	 * @param fCntrTpszCd
	 */
	public void setFCntrTpszCd(String fCntrTpszCd) {
		this.fCntrTpszCd = fCntrTpszCd;
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
	 * @param fRlane
	 */
	public void setFRlane(String fRlane) {
		this.fRlane = fRlane;
	}
	
	/**
	 * Column Info
	 * @param fTo
	 */
	public void setFTo(String fTo) {
		this.fTo = fTo;
	}
	
	/**
	 * Column Info
	 * @param fTpsz
	 */
	public void setFTpsz(String fTpsz) {
		this.fTpsz = fTpsz;
	}
	
	/**
	 * Column Info
	 * @param fProVw
	 */
	public void setFProVw(String fProVw) {
		this.fProVw = fProVw;
	}
	
	/**
	 * Column Info
	 * @param fPod
	 */
	public void setFPod(String fPod) {
		this.fPod = fPod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFKind(JSPUtil.getParameter(request, "f_kind", ""));
		setFCostYrmon(JSPUtil.getParameter(request, "f_cost_yrmon", ""));
		setFPol(JSPUtil.getParameter(request, "f_pol", ""));
		setFFrom(JSPUtil.getParameter(request, "f_from", ""));
		setFDeTerm(JSPUtil.getParameter(request, "f_de_term", ""));
		setFRcvTerm(JSPUtil.getParameter(request, "f_rcv_term", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, "f_cntr_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFRlane(JSPUtil.getParameter(request, "f_rlane", ""));
		setFTo(JSPUtil.getParameter(request, "f_to", ""));
		setFTpsz(JSPUtil.getParameter(request, "f_tpsz", ""));
		setFProVw(JSPUtil.getParameter(request, "f_pro_vw", ""));
		setFPod(JSPUtil.getParameter(request, "f_pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyAvgConditionVO[]
	 */
	public SearchMonthlyAvgConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyAvgConditionVO[]
	 */
	public SearchMonthlyAvgConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyAvgConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fKind = (JSPUtil.getParameter(request, prefix	+ "f_kind", length));
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] fPol = (JSPUtil.getParameter(request, prefix	+ "f_pol", length));
			String[] fFrom = (JSPUtil.getParameter(request, prefix	+ "f_from", length));
			String[] fDeTerm = (JSPUtil.getParameter(request, prefix	+ "f_de_term", length));
			String[] fRcvTerm = (JSPUtil.getParameter(request, prefix	+ "f_rcv_term", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fRlane = (JSPUtil.getParameter(request, prefix	+ "f_rlane", length));
			String[] fTo = (JSPUtil.getParameter(request, prefix	+ "f_to", length));
			String[] fTpsz = (JSPUtil.getParameter(request, prefix	+ "f_tpsz", length));
			String[] fProVw = (JSPUtil.getParameter(request, prefix	+ "f_pro_vw", length));
			String[] fPod = (JSPUtil.getParameter(request, prefix	+ "f_pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyAvgConditionVO();
				if (fKind[i] != null)
					model.setFKind(fKind[i]);
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (fPol[i] != null)
					model.setFPol(fPol[i]);
				if (fFrom[i] != null)
					model.setFFrom(fFrom[i]);
				if (fDeTerm[i] != null)
					model.setFDeTerm(fDeTerm[i]);
				if (fRcvTerm[i] != null)
					model.setFRcvTerm(fRcvTerm[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fRlane[i] != null)
					model.setFRlane(fRlane[i]);
				if (fTo[i] != null)
					model.setFTo(fTo[i]);
				if (fTpsz[i] != null)
					model.setFTpsz(fTpsz[i]);
				if (fProVw[i] != null)
					model.setFProVw(fProVw[i]);
				if (fPod[i] != null)
					model.setFPod(fPod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyAvgConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyAvgConditionVO[]
	 */
	public SearchMonthlyAvgConditionVO[] getSearchMonthlyAvgConditionVOs(){
		SearchMonthlyAvgConditionVO[] vos = (SearchMonthlyAvgConditionVO[])models.toArray(new SearchMonthlyAvgConditionVO[models.size()]);
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
		this.fKind = this.fKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPol = this.fPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFrom = this.fFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDeTerm = this.fDeTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRcvTerm = this.fRcvTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlane = this.fRlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTo = this.fTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTpsz = this.fTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProVw = this.fProVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPod = this.fPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
