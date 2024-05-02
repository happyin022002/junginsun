/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DeleteInquiryByOfficeVO.java
*@FileTitle : DeleteInquiryByOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.27
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.27 황효근 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DeleteInquiryByOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DeleteInquiryByOfficeVO> models = new ArrayList<DeleteInquiryByOfficeVO>();
	
	/* Column Info */
	private String intgCdValDpSeq = null;
	/* Column Info */
	private String dmofSum = null;
	/* Column Info */
	private String cticSum = null;
	/* Column Info */
	private String dmifSum = null;
	/* Column Info */
	private String dticSum = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String deltRsnDesc = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String dtocSum = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctocSum = null;
	/* Column Info */
	private String ttlCntr = null;
	/* Column Info */
	private String deltRsnCd = null;
	/* Column Info */
	private String deltSpecRsnCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DeleteInquiryByOfficeVO() {}

	public DeleteInquiryByOfficeVO(String ibflag, String pagerows, String ofcCd, String deltRsnCd, String deltRsnDesc, String intgCdValDpSeq, String dmifSum, String dmofSum, String dticSum, String dtocSum, String cticSum, String ctocSum, String ttlCntr, String deltSpecRsnCd) {
		this.intgCdValDpSeq = intgCdValDpSeq;
		this.dmofSum = dmofSum;
		this.cticSum = cticSum;
		this.dmifSum = dmifSum;
		this.dticSum = dticSum;
		this.pagerows = pagerows;
		this.deltRsnDesc = deltRsnDesc;
		this.ofcCd = ofcCd;
		this.dtocSum = dtocSum;
		this.ibflag = ibflag;
		this.ctocSum = ctocSum;
		this.ttlCntr = ttlCntr;
		this.deltRsnCd = deltRsnCd;
		this.deltSpecRsnCd = deltSpecRsnCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("intg_cd_val_dp_seq", getIntgCdValDpSeq());
		this.hashColumns.put("dmof_sum", getDmofSum());
		this.hashColumns.put("ctic_sum", getCticSum());
		this.hashColumns.put("dmif_sum", getDmifSum());
		this.hashColumns.put("dtic_sum", getDticSum());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("delt_rsn_desc", getDeltRsnDesc());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("dtoc_sum", getDtocSum());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctoc_sum", getCtocSum());
		this.hashColumns.put("ttl_cntr", getTtlCntr());
		this.hashColumns.put("delt_rsn_cd", getDeltRsnCd());
		this.hashColumns.put("delt_spec_rsn_cd", getDeltSpecRsnCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("intg_cd_val_dp_seq", "intgCdValDpSeq");
		this.hashFields.put("dmof_sum", "dmofSum");
		this.hashFields.put("ctic_sum", "cticSum");
		this.hashFields.put("dmif_sum", "dmifSum");
		this.hashFields.put("dtic_sum", "dticSum");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("delt_rsn_desc", "deltRsnDesc");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("dtoc_sum", "dtocSum");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctoc_sum", "ctocSum");
		this.hashFields.put("ttl_cntr", "ttlCntr");
		this.hashFields.put("delt_rsn_cd", "deltRsnCd");
		this.hashFields.put("delt_spec_rsn_cd", "deltSpecRsnCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpSeq
	 */
	public String getIntgCdValDpSeq() {
		return this.intgCdValDpSeq;
	}
	
	/**
	 * Column Info
	 * @return dmofSum
	 */
	public String getDmofSum() {
		return this.dmofSum;
	}
	
	/**
	 * Column Info
	 * @return cticSum
	 */
	public String getCticSum() {
		return this.cticSum;
	}
	
	/**
	 * Column Info
	 * @return dmifSum
	 */
	public String getDmifSum() {
		return this.dmifSum;
	}
	
	/**
	 * Column Info
	 * @return dticSum
	 */
	public String getDticSum() {
		return this.dticSum;
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
	 * @return deltRsnDesc
	 */
	public String getDeltRsnDesc() {
		return this.deltRsnDesc;
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
	 * @return dtocSum
	 */
	public String getDtocSum() {
		return this.dtocSum;
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
	 * @return ctocSum
	 */
	public String getCtocSum() {
		return this.ctocSum;
	}
	
	/**
	 * Column Info
	 * @return ttlCntr
	 */
	public String getTtlCntr() {
		return this.ttlCntr;
	}
	
	/**
	 * Column Info
	 * @return deltRsnCd
	 */
	public String getDeltRsnCd() {
		return this.deltRsnCd;
	}
	

	/**
	 * Column Info
	 * @param intgCdValDpSeq
	 */
	public void setIntgCdValDpSeq(String intgCdValDpSeq) {
		this.intgCdValDpSeq = intgCdValDpSeq;
	}
	
	/**
	 * Column Info
	 * @param dmofSum
	 */
	public void setDmofSum(String dmofSum) {
		this.dmofSum = dmofSum;
	}
	
	/**
	 * Column Info
	 * @param cticSum
	 */
	public void setCticSum(String cticSum) {
		this.cticSum = cticSum;
	}
	
	/**
	 * Column Info
	 * @param dmifSum
	 */
	public void setDmifSum(String dmifSum) {
		this.dmifSum = dmifSum;
	}
	
	/**
	 * Column Info
	 * @param dticSum
	 */
	public void setDticSum(String dticSum) {
		this.dticSum = dticSum;
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
	 * @param deltRsnDesc
	 */
	public void setDeltRsnDesc(String deltRsnDesc) {
		this.deltRsnDesc = deltRsnDesc;
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
	 * @param dtocSum
	 */
	public void setDtocSum(String dtocSum) {
		this.dtocSum = dtocSum;
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
	 * @param ctocSum
	 */
	public void setCtocSum(String ctocSum) {
		this.ctocSum = ctocSum;
	}
	
	/**
	 * Column Info
	 * @param ttlCntr
	 */
	public void setTtlCntr(String ttlCntr) {
		this.ttlCntr = ttlCntr;
	}
	
	/**
	 * Column Info
	 * @param deltRsnCd
	 */
	public void setDeltRsnCd(String deltRsnCd) {
		this.deltRsnCd = deltRsnCd;
	}
	
	public String getDeltSpecRsnCd() {
		return deltSpecRsnCd;
	}

	public void setDeltSpecRsnCd(String deltSpecRsnCd) {
		this.deltSpecRsnCd = deltSpecRsnCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIntgCdValDpSeq(JSPUtil.getParameter(request, "intg_cd_val_dp_seq", ""));
		setDmofSum(JSPUtil.getParameter(request, "dmof_sum", ""));
		setCticSum(JSPUtil.getParameter(request, "ctic_sum", ""));
		setDmifSum(JSPUtil.getParameter(request, "dmif_sum", ""));
		setDticSum(JSPUtil.getParameter(request, "dtic_sum", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDeltRsnDesc(JSPUtil.getParameter(request, "delt_rsn_desc", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setDtocSum(JSPUtil.getParameter(request, "dtoc_sum", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtocSum(JSPUtil.getParameter(request, "ctoc_sum", ""));
		setTtlCntr(JSPUtil.getParameter(request, "ttl_cntr", ""));
		setDeltRsnCd(JSPUtil.getParameter(request, "delt_rsn_cd", ""));
		setDeltSpecRsnCd(JSPUtil.getParameter(request, "delt_spec_rsn_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DeleteInquiryByOfficeVO[]
	 */
	public DeleteInquiryByOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DeleteInquiryByOfficeVO[]
	 */
	public DeleteInquiryByOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DeleteInquiryByOfficeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] intgCdValDpSeq = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_seq", length));
			String[] dmofSum = (JSPUtil.getParameter(request, prefix	+ "dmof_sum", length));
			String[] cticSum = (JSPUtil.getParameter(request, prefix	+ "ctic_sum", length));
			String[] dmifSum = (JSPUtil.getParameter(request, prefix	+ "dmif_sum", length));
			String[] dticSum = (JSPUtil.getParameter(request, prefix	+ "dtic_sum", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] deltRsnDesc = (JSPUtil.getParameter(request, prefix	+ "delt_rsn_desc", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] dtocSum = (JSPUtil.getParameter(request, prefix	+ "dtoc_sum", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctocSum = (JSPUtil.getParameter(request, prefix	+ "ctoc_sum", length));
			String[] ttlCntr = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr", length));
			String[] deltRsnCd = (JSPUtil.getParameter(request, prefix	+ "delt_rsn_cd", length));
			String[] deltSpecRsnCd = (JSPUtil.getParameter(request, prefix	+ "delt_spec_rsn_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DeleteInquiryByOfficeVO();
				if (intgCdValDpSeq[i] != null)
					model.setIntgCdValDpSeq(intgCdValDpSeq[i]);
				if (dmofSum[i] != null)
					model.setDmofSum(dmofSum[i]);
				if (cticSum[i] != null)
					model.setCticSum(cticSum[i]);
				if (dmifSum[i] != null)
					model.setDmifSum(dmifSum[i]);
				if (dticSum[i] != null)
					model.setDticSum(dticSum[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (deltRsnDesc[i] != null)
					model.setDeltRsnDesc(deltRsnDesc[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (dtocSum[i] != null)
					model.setDtocSum(dtocSum[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctocSum[i] != null)
					model.setCtocSum(ctocSum[i]);
				if (ttlCntr[i] != null)
					model.setTtlCntr(ttlCntr[i]);
				if (deltRsnCd[i] != null)
					model.setDeltRsnCd(deltRsnCd[i]);
				if (deltSpecRsnCd[i] != null)
					model.setDeltSpecRsnCd(deltSpecRsnCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDeleteInquiryByOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DeleteInquiryByOfficeVO[]
	 */
	public DeleteInquiryByOfficeVO[] getDeleteInquiryByOfficeVOs(){
		DeleteInquiryByOfficeVO[] vos = (DeleteInquiryByOfficeVO[])models.toArray(new DeleteInquiryByOfficeVO[models.size()]);
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
		this.intgCdValDpSeq = this.intgCdValDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmofSum = this.dmofSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cticSum = this.cticSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmifSum = this.dmifSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dticSum = this.dticSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltRsnDesc = this.deltRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtocSum = this.dtocSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctocSum = this.ctocSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntr = this.ttlCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltRsnCd = this.deltRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltSpecRsnCd = this.deltSpecRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
