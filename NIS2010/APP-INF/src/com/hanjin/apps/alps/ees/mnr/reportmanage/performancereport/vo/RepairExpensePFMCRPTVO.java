/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairExpensePFMCRPTVO.java
*@FileTitle : RepairExpensePFMCRPTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairExpensePFMCRPTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairExpensePFMCRPTVO> models = new ArrayList<RepairExpensePFMCRPTVO>();
	
	/* Column Info */
	private String pln511561 = null;
	/* Column Info */
	private String pln511551 = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String pln511541 = null;
	/* Column Info */
	private String pfmc511531 = null;
	/* Column Info */
	private String pfmc511521 = null;
	/* Column Info */
	private String pfmc511541 = null;
	/* Column Info */
	private String pfmc511561 = null;
	/* Column Info */
	private String pfmc511551 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String pfmc511511 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pln511521 = null;
	/* Column Info */
	private String pln511511 = null;
	/* Column Info */
	private String pln511531 = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairExpensePFMCRPTVO() {}

	public RepairExpensePFMCRPTVO(String ibflag, String pagerows, String pln511561, String pln511551, String pln511541, String pfmc511531, String pfmc511521, String pfmc511541, String pfmc511561, String pfmc511551, String currCd, String ofcCd, String pfmc511511, String pln511521, String pln511511, String pln511531, String rhq) {
		this.pln511561 = pln511561;
		this.pln511551 = pln511551;
		this.currCd = currCd;
		this.pln511541 = pln511541;
		this.pfmc511531 = pfmc511531;
		this.pfmc511521 = pfmc511521;
		this.pfmc511541 = pfmc511541;
		this.pfmc511561 = pfmc511561;
		this.pfmc511551 = pfmc511551;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.pfmc511511 = pfmc511511;
		this.ibflag = ibflag;
		this.pln511521 = pln511521;
		this.pln511511 = pln511511;
		this.pln511531 = pln511531;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pln_511561", getPln511561());
		this.hashColumns.put("pln_511551", getPln511551());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pln_511541", getPln511541());
		this.hashColumns.put("pfmc_511531", getPfmc511531());
		this.hashColumns.put("pfmc_511521", getPfmc511521());
		this.hashColumns.put("pfmc_511541", getPfmc511541());
		this.hashColumns.put("pfmc_511561", getPfmc511561());
		this.hashColumns.put("pfmc_511551", getPfmc511551());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("pfmc_511511", getPfmc511511());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pln_511521", getPln511521());
		this.hashColumns.put("pln_511511", getPln511511());
		this.hashColumns.put("pln_511531", getPln511531());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pln_511561", "pln511561");
		this.hashFields.put("pln_511551", "pln511551");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pln_511541", "pln511541");
		this.hashFields.put("pfmc_511531", "pfmc511531");
		this.hashFields.put("pfmc_511521", "pfmc511521");
		this.hashFields.put("pfmc_511541", "pfmc511541");
		this.hashFields.put("pfmc_511561", "pfmc511561");
		this.hashFields.put("pfmc_511551", "pfmc511551");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pfmc_511511", "pfmc511511");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pln_511521", "pln511521");
		this.hashFields.put("pln_511511", "pln511511");
		this.hashFields.put("pln_511531", "pln511531");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pln511561
	 */
	public String getPln511561() {
		return this.pln511561;
	}
	
	/**
	 * Column Info
	 * @return pln511551
	 */
	public String getPln511551() {
		return this.pln511551;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return pln511541
	 */
	public String getPln511541() {
		return this.pln511541;
	}
	
	/**
	 * Column Info
	 * @return pfmc511531
	 */
	public String getPfmc511531() {
		return this.pfmc511531;
	}
	
	/**
	 * Column Info
	 * @return pfmc511521
	 */
	public String getPfmc511521() {
		return this.pfmc511521;
	}
	
	/**
	 * Column Info
	 * @return pfmc511541
	 */
	public String getPfmc511541() {
		return this.pfmc511541;
	}
	
	/**
	 * Column Info
	 * @return pfmc511561
	 */
	public String getPfmc511561() {
		return this.pfmc511561;
	}
	
	/**
	 * Column Info
	 * @return pfmc511551
	 */
	public String getPfmc511551() {
		return this.pfmc511551;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return pfmc511511
	 */
	public String getPfmc511511() {
		return this.pfmc511511;
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
	 * @return pln511521
	 */
	public String getPln511521() {
		return this.pln511521;
	}
	
	/**
	 * Column Info
	 * @return pln511511
	 */
	public String getPln511511() {
		return this.pln511511;
	}
	
	/**
	 * Column Info
	 * @return pln511531
	 */
	public String getPln511531() {
		return this.pln511531;
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
	 * @param pln511561
	 */
	public void setPln511561(String pln511561) {
		this.pln511561 = pln511561;
	}
	
	/**
	 * Column Info
	 * @param pln511551
	 */
	public void setPln511551(String pln511551) {
		this.pln511551 = pln511551;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param pln511541
	 */
	public void setPln511541(String pln511541) {
		this.pln511541 = pln511541;
	}
	
	/**
	 * Column Info
	 * @param pfmc511531
	 */
	public void setPfmc511531(String pfmc511531) {
		this.pfmc511531 = pfmc511531;
	}
	
	/**
	 * Column Info
	 * @param pfmc511521
	 */
	public void setPfmc511521(String pfmc511521) {
		this.pfmc511521 = pfmc511521;
	}
	
	/**
	 * Column Info
	 * @param pfmc511541
	 */
	public void setPfmc511541(String pfmc511541) {
		this.pfmc511541 = pfmc511541;
	}
	
	/**
	 * Column Info
	 * @param pfmc511561
	 */
	public void setPfmc511561(String pfmc511561) {
		this.pfmc511561 = pfmc511561;
	}
	
	/**
	 * Column Info
	 * @param pfmc511551
	 */
	public void setPfmc511551(String pfmc511551) {
		this.pfmc511551 = pfmc511551;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param pfmc511511
	 */
	public void setPfmc511511(String pfmc511511) {
		this.pfmc511511 = pfmc511511;
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
	 * @param pln511521
	 */
	public void setPln511521(String pln511521) {
		this.pln511521 = pln511521;
	}
	
	/**
	 * Column Info
	 * @param pln511511
	 */
	public void setPln511511(String pln511511) {
		this.pln511511 = pln511511;
	}
	
	/**
	 * Column Info
	 * @param pln511531
	 */
	public void setPln511531(String pln511531) {
		this.pln511531 = pln511531;
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
		setPln511561(JSPUtil.getParameter(request, "pln_511561", ""));
		setPln511551(JSPUtil.getParameter(request, "pln_511551", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPln511541(JSPUtil.getParameter(request, "pln_511541", ""));
		setPfmc511531(JSPUtil.getParameter(request, "pfmc_511531", ""));
		setPfmc511521(JSPUtil.getParameter(request, "pfmc_511521", ""));
		setPfmc511541(JSPUtil.getParameter(request, "pfmc_511541", ""));
		setPfmc511561(JSPUtil.getParameter(request, "pfmc_511561", ""));
		setPfmc511551(JSPUtil.getParameter(request, "pfmc_511551", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setPfmc511511(JSPUtil.getParameter(request, "pfmc_511511", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPln511521(JSPUtil.getParameter(request, "pln_511521", ""));
		setPln511511(JSPUtil.getParameter(request, "pln_511511", ""));
		setPln511531(JSPUtil.getParameter(request, "pln_511531", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairExpensePFMCRPTVO[]
	 */
	public RepairExpensePFMCRPTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairExpensePFMCRPTVO[]
	 */
	public RepairExpensePFMCRPTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairExpensePFMCRPTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pln511561 = (JSPUtil.getParameter(request, prefix	+ "pln_511561", length));
			String[] pln511551 = (JSPUtil.getParameter(request, prefix	+ "pln_511551", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] pln511541 = (JSPUtil.getParameter(request, prefix	+ "pln_511541", length));
			String[] pfmc511531 = (JSPUtil.getParameter(request, prefix	+ "pfmc_511531", length));
			String[] pfmc511521 = (JSPUtil.getParameter(request, prefix	+ "pfmc_511521", length));
			String[] pfmc511541 = (JSPUtil.getParameter(request, prefix	+ "pfmc_511541", length));
			String[] pfmc511561 = (JSPUtil.getParameter(request, prefix	+ "pfmc_511561", length));
			String[] pfmc511551 = (JSPUtil.getParameter(request, prefix	+ "pfmc_511551", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] pfmc511511 = (JSPUtil.getParameter(request, prefix	+ "pfmc_511511", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pln511521 = (JSPUtil.getParameter(request, prefix	+ "pln_511521", length));
			String[] pln511511 = (JSPUtil.getParameter(request, prefix	+ "pln_511511", length));
			String[] pln511531 = (JSPUtil.getParameter(request, prefix	+ "pln_511531", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairExpensePFMCRPTVO();
				if (pln511561[i] != null)
					model.setPln511561(pln511561[i]);
				if (pln511551[i] != null)
					model.setPln511551(pln511551[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (pln511541[i] != null)
					model.setPln511541(pln511541[i]);
				if (pfmc511531[i] != null)
					model.setPfmc511531(pfmc511531[i]);
				if (pfmc511521[i] != null)
					model.setPfmc511521(pfmc511521[i]);
				if (pfmc511541[i] != null)
					model.setPfmc511541(pfmc511541[i]);
				if (pfmc511561[i] != null)
					model.setPfmc511561(pfmc511561[i]);
				if (pfmc511551[i] != null)
					model.setPfmc511551(pfmc511551[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (pfmc511511[i] != null)
					model.setPfmc511511(pfmc511511[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pln511521[i] != null)
					model.setPln511521(pln511521[i]);
				if (pln511511[i] != null)
					model.setPln511511(pln511511[i]);
				if (pln511531[i] != null)
					model.setPln511531(pln511531[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairExpensePFMCRPTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairExpensePFMCRPTVO[]
	 */
	public RepairExpensePFMCRPTVO[] getRepairExpensePFMCRPTVOs(){
		RepairExpensePFMCRPTVO[] vos = (RepairExpensePFMCRPTVO[])models.toArray(new RepairExpensePFMCRPTVO[models.size()]);
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
		this.pln511561 = this.pln511561 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pln511551 = this.pln511551 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pln511541 = this.pln511541 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc511531 = this.pfmc511531 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc511521 = this.pfmc511521 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc511541 = this.pfmc511541 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc511561 = this.pfmc511561 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc511551 = this.pfmc511551 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc511511 = this.pfmc511511 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pln511521 = this.pln511521 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pln511511 = this.pln511511 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pln511531 = this.pln511531 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
