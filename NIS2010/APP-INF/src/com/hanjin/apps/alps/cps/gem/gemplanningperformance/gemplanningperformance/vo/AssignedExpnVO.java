/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanningVO.java
*@FileTitle : PlanningVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.14 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 진윤오
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class AssignedExpnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AssignedExpnVO> models = new ArrayList<AssignedExpnVO>();
	
	/* Column Info */
	private String octAmt = null;
	/* Column Info */
	private String novAmt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String janAmt = null;
	/* Column Info */
	private String assigned = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String mayAmt = null;
	/* Column Info */
	private String augAmt = null;
	/* Column Info */
	private String genExpnItmDesc = null;
	/* Column Info */
	private String febAmt = null;
	/* Column Info */
	private String marAmt = null;
	/* Column Info */
	private String decAmt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String julAmt = null;
	/* Column Info */
	private String sepAmt = null;
	/* Column Info */
	private String junAmt = null;
	/* Column Info */
	private String transferable = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String aprAmt = null;
	/* Column Info */
	private String genExpnItmNo = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AssignedExpnVO() {}

	public AssignedExpnVO(String ibflag, String pagerows, String genExpnItmDesc, String genExpnRqstNo, String ofcCd, String genExpnItmNo, String genExpnCd, String janAmt, String febAmt, String marAmt, String aprAmt, String mayAmt, String junAmt, String julAmt, String augAmt, String sepAmt, String octAmt, String novAmt, String decAmt, String currCd, String assigned, String transferable) {
		this.octAmt = octAmt;
		this.novAmt = novAmt;
		this.ibflag = ibflag;
		this.ofcCd = ofcCd;
		this.janAmt = janAmt;
		this.assigned = assigned;
		this.genExpnRqstNo = genExpnRqstNo;
		this.mayAmt = mayAmt;
		this.augAmt = augAmt;
		this.genExpnItmDesc = genExpnItmDesc;
		this.febAmt = febAmt;
		this.marAmt = marAmt;
		this.decAmt = decAmt;
		this.genExpnCd = genExpnCd;
		this.currCd = currCd;
		this.julAmt = julAmt;
		this.sepAmt = sepAmt;
		this.junAmt = junAmt;
		this.transferable = transferable;
		this.pagerows = pagerows;
		this.aprAmt = aprAmt;
		this.genExpnItmNo = genExpnItmNo;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("oct_amt", getOctAmt());
		this.hashColumns.put("nov_amt", getNovAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("jan_amt", getJanAmt());
		this.hashColumns.put("assigned", getAssigned());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("may_amt", getMayAmt());
		this.hashColumns.put("aug_amt", getAugAmt());
		this.hashColumns.put("gen_expn_itm_desc", getGenExpnItmDesc());
		this.hashColumns.put("feb_amt", getFebAmt());
		this.hashColumns.put("mar_amt", getMarAmt());
		this.hashColumns.put("dec_amt", getDecAmt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("jul_amt", getJulAmt());
		this.hashColumns.put("sep_amt", getSepAmt());
		this.hashColumns.put("jun_amt", getJunAmt());
		this.hashColumns.put("transferable", getTransferable());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("apr_amt", getAprAmt());
		this.hashColumns.put("gen_expn_itm_no", getGenExpnItmNo());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("oct_amt", "octAmt");
		this.hashFields.put("nov_amt", "novAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("jan_amt", "janAmt");
		this.hashFields.put("assigned", "assigned");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("may_amt", "mayAmt");
		this.hashFields.put("aug_amt", "augAmt");
		this.hashFields.put("gen_expn_itm_desc", "genExpnItmDesc");
		this.hashFields.put("feb_amt", "febAmt");
		this.hashFields.put("mar_amt", "marAmt");
		this.hashFields.put("dec_amt", "decAmt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("jul_amt", "julAmt");
		this.hashFields.put("sep_amt", "sepAmt");
		this.hashFields.put("jun_amt", "junAmt");
		this.hashFields.put("transferable", "transferable");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("apr_amt", "aprAmt");
		this.hashFields.put("gen_expn_itm_no", "genExpnItmNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return octAmt
	 */
	public String getOctAmt() {
		return this.octAmt;
	}
	
	/**
	 * Column Info
	 * @return novAmt
	 */
	public String getNovAmt() {
		return this.novAmt;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return janAmt
	 */
	public String getJanAmt() {
		return this.janAmt;
	}
	
	/**
	 * Column Info
	 * @return assigned
	 */
	public String getAssigned() {
		return this.assigned;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return this.genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @return mayAmt
	 */
	public String getMayAmt() {
		return this.mayAmt;
	}
	
	/**
	 * Column Info
	 * @return augAmt
	 */
	public String getAugAmt() {
		return this.augAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnItmDesc
	 */
	public String getGenExpnItmDesc() {
		return this.genExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @return febAmt
	 */
	public String getFebAmt() {
		return this.febAmt;
	}
	
	/**
	 * Column Info
	 * @return marAmt
	 */
	public String getMarAmt() {
		return this.marAmt;
	}
	
	/**
	 * Column Info
	 * @return decAmt
	 */
	public String getDecAmt() {
		return this.decAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
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
	 * @return julAmt
	 */
	public String getJulAmt() {
		return this.julAmt;
	}
	
	/**
	 * Column Info
	 * @return sepAmt
	 */
	public String getSepAmt() {
		return this.sepAmt;
	}
	
	/**
	 * Column Info
	 * @return junAmt
	 */
	public String getJunAmt() {
		return this.junAmt;
	}
	
	/**
	 * Column Info
	 * @return transferable
	 */
	public String getTransferable() {
		return this.transferable;
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
	 * @return aprAmt
	 */
	public String getAprAmt() {
		return this.aprAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnItmNo
	 */
	public String getGenExpnItmNo() {
		return this.genExpnItmNo;
	}
	

	/**
	 * Column Info
	 * @param octAmt
	 */
	public void setOctAmt(String octAmt) {
		this.octAmt = octAmt;
	}
	
	/**
	 * Column Info
	 * @param novAmt
	 */
	public void setNovAmt(String novAmt) {
		this.novAmt = novAmt;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param janAmt
	 */
	public void setJanAmt(String janAmt) {
		this.janAmt = janAmt;
	}
	
	/**
	 * Column Info
	 * @param assigned
	 */
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstNo
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @param mayAmt
	 */
	public void setMayAmt(String mayAmt) {
		this.mayAmt = mayAmt;
	}
	
	/**
	 * Column Info
	 * @param augAmt
	 */
	public void setAugAmt(String augAmt) {
		this.augAmt = augAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnItmDesc
	 */
	public void setGenExpnItmDesc(String genExpnItmDesc) {
		this.genExpnItmDesc = genExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @param febAmt
	 */
	public void setFebAmt(String febAmt) {
		this.febAmt = febAmt;
	}
	
	/**
	 * Column Info
	 * @param marAmt
	 */
	public void setMarAmt(String marAmt) {
		this.marAmt = marAmt;
	}
	
	/**
	 * Column Info
	 * @param decAmt
	 */
	public void setDecAmt(String decAmt) {
		this.decAmt = decAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
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
	 * @param julAmt
	 */
	public void setJulAmt(String julAmt) {
		this.julAmt = julAmt;
	}
	
	/**
	 * Column Info
	 * @param sepAmt
	 */
	public void setSepAmt(String sepAmt) {
		this.sepAmt = sepAmt;
	}
	
	/**
	 * Column Info
	 * @param junAmt
	 */
	public void setJunAmt(String junAmt) {
		this.junAmt = junAmt;
	}
	
	/**
	 * Column Info
	 * @param transferable
	 */
	public void setTransferable(String transferable) {
		this.transferable = transferable;
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
	 * @param aprAmt
	 */
	public void setAprAmt(String aprAmt) {
		this.aprAmt = aprAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnItmNo
	 */
	public void setGenExpnItmNo(String genExpnItmNo) {
		this.genExpnItmNo = genExpnItmNo;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOctAmt(JSPUtil.getParameter(request, "oct_amt", ""));
		setNovAmt(JSPUtil.getParameter(request, "nov_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setJanAmt(JSPUtil.getParameter(request, "jan_amt", ""));
		setAssigned(JSPUtil.getParameter(request, "assigned", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setMayAmt(JSPUtil.getParameter(request, "may_amt", ""));
		setAugAmt(JSPUtil.getParameter(request, "aug_amt", ""));
		setGenExpnItmDesc(JSPUtil.getParameter(request, "gen_expn_itm_desc", ""));
		setFebAmt(JSPUtil.getParameter(request, "feb_amt", ""));
		setMarAmt(JSPUtil.getParameter(request, "mar_amt", ""));
		setDecAmt(JSPUtil.getParameter(request, "dec_amt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setJulAmt(JSPUtil.getParameter(request, "jul_amt", ""));
		setSepAmt(JSPUtil.getParameter(request, "sep_amt", ""));
		setJunAmt(JSPUtil.getParameter(request, "jun_amt", ""));
		setTransferable(JSPUtil.getParameter(request, "transferable", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAprAmt(JSPUtil.getParameter(request, "apr_amt", ""));
		setGenExpnItmNo(JSPUtil.getParameter(request, "gen_expn_itm_no", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return PlanningVO[]
	 */
	public AssignedExpnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PlanningVO[]
	 */
	public AssignedExpnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AssignedExpnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] octAmt = (JSPUtil.getParameter(request, prefix	+ "oct_amt".trim(), length));
			String[] novAmt = (JSPUtil.getParameter(request, prefix	+ "nov_amt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] janAmt = (JSPUtil.getParameter(request, prefix	+ "jan_amt".trim(), length));
			String[] assigned = (JSPUtil.getParameter(request, prefix	+ "assigned".trim(), length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no".trim(), length));
			String[] mayAmt = (JSPUtil.getParameter(request, prefix	+ "may_amt".trim(), length));
			String[] augAmt = (JSPUtil.getParameter(request, prefix	+ "aug_amt".trim(), length));
			String[] genExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_desc".trim(), length));
			String[] febAmt = (JSPUtil.getParameter(request, prefix	+ "feb_amt".trim(), length));
			String[] marAmt = (JSPUtil.getParameter(request, prefix	+ "mar_amt".trim(), length));
			String[] decAmt = (JSPUtil.getParameter(request, prefix	+ "dec_amt".trim(), length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] julAmt = (JSPUtil.getParameter(request, prefix	+ "jul_amt".trim(), length));
			String[] sepAmt = (JSPUtil.getParameter(request, prefix	+ "sep_amt".trim(), length));
			String[] junAmt = (JSPUtil.getParameter(request, prefix	+ "jun_amt".trim(), length));
			String[] transferable = (JSPUtil.getParameter(request, prefix	+ "transferable".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] aprAmt = (JSPUtil.getParameter(request, prefix	+ "apr_amt".trim(), length));
			String[] genExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_no".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AssignedExpnVO();
				if (octAmt[i] != null)
					model.setOctAmt(octAmt[i]);
				if (novAmt[i] != null)
					model.setNovAmt(novAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (janAmt[i] != null)
					model.setJanAmt(janAmt[i]);
				if (assigned[i] != null)
					model.setAssigned(assigned[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (mayAmt[i] != null)
					model.setMayAmt(mayAmt[i]);
				if (augAmt[i] != null)
					model.setAugAmt(augAmt[i]);
				if (genExpnItmDesc[i] != null)
					model.setGenExpnItmDesc(genExpnItmDesc[i]);
				if (febAmt[i] != null)
					model.setFebAmt(febAmt[i]);
				if (marAmt[i] != null)
					model.setMarAmt(marAmt[i]);
				if (decAmt[i] != null)
					model.setDecAmt(decAmt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (julAmt[i] != null)
					model.setJulAmt(julAmt[i]);
				if (sepAmt[i] != null)
					model.setSepAmt(sepAmt[i]);
				if (junAmt[i] != null)
					model.setJunAmt(junAmt[i]);
				if (transferable[i] != null)
					model.setTransferable(transferable[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (aprAmt[i] != null)
					model.setAprAmt(aprAmt[i]);
				if (genExpnItmNo[i] != null)
					model.setGenExpnItmNo(genExpnItmNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPlanningVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return PlanningVO[]
	 */
	public AssignedExpnVO[] getPlanningVOs(){
		AssignedExpnVO[] vos = (AssignedExpnVO[])models.toArray(new AssignedExpnVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.octAmt = this.octAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.novAmt = this.novAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.janAmt = this.janAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assigned = this.assigned .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mayAmt = this.mayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.augAmt = this.augAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmDesc = this.genExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.febAmt = this.febAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marAmt = this.marAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.decAmt = this.decAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.julAmt = this.julAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepAmt = this.sepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.junAmt = this.junAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transferable = this.transferable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprAmt = this.aprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmNo = this.genExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
