/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBasicTariffSummaryParamVO.java
*@FileTitle : SearchBasicTariffSummaryParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.22 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBasicTariffSummaryParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicTariffSummaryParamVO> models = new ArrayList<SearchBasicTariffSummaryParamVO>();
	
	/* Column Info */
	private String validity3 = null;
	/* Column Info */
	private String validity2 = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String dmdtTrfCdIn = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String dmdtTrfCdList = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String validity1 = null;
	/* Column Info */
	private String dmdtTrfGrpTpCd1 = null;
	/* Column Info */
	private String dmdtTrfGrpTpCd2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmdtDeTermCd = null;
	/* Column Info */
	private String dmdtDeTermNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBasicTariffSummaryParamVO() {}

	public SearchBasicTariffSummaryParamVO(String ibflag, String pagerows, String svrId, String cntCd, String contiCd, String dmdtTrfCdIn, String dmdtTrfCdList, String dmdtTrfGrpTpCd1, String dmdtTrfGrpTpCd2, String validity1, String validity2, String validity3, String dmdtDeTermCd, String dmdtDeTermNm) {
		this.validity3 = validity3;
		this.validity2 = validity2;
		this.contiCd = contiCd;
		this.svrId = svrId;
		this.dmdtTrfCdIn = dmdtTrfCdIn;
		this.ibflag = ibflag;
		this.dmdtTrfCdList = dmdtTrfCdList;
		this.cntCd = cntCd;
		this.validity1 = validity1;
		this.dmdtTrfGrpTpCd1 = dmdtTrfGrpTpCd1;
		this.dmdtTrfGrpTpCd2 = dmdtTrfGrpTpCd2;
		this.pagerows = pagerows;
		this.dmdtDeTermCd = dmdtDeTermCd;
		this.dmdtDeTermNm = dmdtDeTermNm;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("validity3", getValidity3());
		this.hashColumns.put("validity2", getValidity2());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("dmdt_trf_cd_in", getDmdtTrfCdIn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_trf_cd_list", getDmdtTrfCdList());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("validity1", getValidity1());
		this.hashColumns.put("dmdt_trf_grp_tp_cd1", getDmdtTrfGrpTpCd1());
		this.hashColumns.put("dmdt_trf_grp_tp_cd2", getDmdtTrfGrpTpCd2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmdt_de_term_cd", getDmdtDeTermCd());
		this.hashColumns.put("dmdt_de_term_nm", getDmdtDeTermNm());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("validity3", "validity3");
		this.hashFields.put("validity2", "validity2");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("dmdt_trf_cd_in", "dmdtTrfCdIn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_trf_cd_list", "dmdtTrfCdList");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("validity1", "validity1");
		this.hashFields.put("dmdt_trf_grp_tp_cd1", "dmdtTrfGrpTpCd1");
		this.hashFields.put("dmdt_trf_grp_tp_cd2", "dmdtTrfGrpTpCd2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmdt_de_term_cd", "dmdtDeTermCd");
		this.hashFields.put("dmdt_de_term_nm", "dmdtDeTermNm");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return validity3
	 */
	public String getValidity3() {
		return this.validity3;
	}
	
	/**
	 * Column Info
	 * @return validity2
	 */
	public String getValidity2() {
		return this.validity2;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCdIn
	 */
	public String getDmdtTrfCdIn() {
		return this.dmdtTrfCdIn;
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
	 * @return dmdtTrfCdList
	 */
	public String getDmdtTrfCdList() {
		return this.dmdtTrfCdList;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return validity1
	 */
	public String getValidity1() {
		return this.validity1;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfGrpTpCd1
	 */
	public String getDmdtTrfGrpTpCd1() {
		return this.dmdtTrfGrpTpCd1;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfGrpTpCd2
	 */
	public String getDmdtTrfGrpTpCd2() {
		return this.dmdtTrfGrpTpCd2;
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
	 * @return dmdtDeTermCd
	 */
	public String getDmdtDeTermCd() {
		return this.dmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */
	public String getDmdtDeTermNm() {
		return this.dmdtDeTermNm;
	}

	/**
	 * Column Info
	 * @param validity3
	 */
	public void setValidity3(String validity3) {
		this.validity3 = validity3;
	}
	
	/**
	 * Column Info
	 * @param validity2
	 */
	public void setValidity2(String validity2) {
		this.validity2 = validity2;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCdIn
	 */
	public void setDmdtTrfCdIn(String dmdtTrfCdIn) {
		this.dmdtTrfCdIn = dmdtTrfCdIn;
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
	 * @param dmdtTrfCdList
	 */
	public void setDmdtTrfCdList(String dmdtTrfCdList) {
		this.dmdtTrfCdList = dmdtTrfCdList;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param validity1
	 */
	public void setValidity1(String validity1) {
		this.validity1 = validity1;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfGrpTpCd1
	 */
	public void setDmdtTrfGrpTpCd1(String dmdtTrfGrpTpCd1) {
		this.dmdtTrfGrpTpCd1 = dmdtTrfGrpTpCd1;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfGrpTpCd2
	 */
	public void setDmdtTrfGrpTpCd2(String dmdtTrfGrpTpCd2) {
		this.dmdtTrfGrpTpCd2 = dmdtTrfGrpTpCd2;
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
	 * @param dmdtDeTermCd
	 */
	public void setDmdtDeTermCd(String dmdtDeTermCd) {
		this.dmdtDeTermCd = dmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermNm
	 */
	public void setDmdtDeTermNm(String dmdtDeTermNm) {
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setValidity3(JSPUtil.getParameter(request, "validity3", ""));
		setValidity2(JSPUtil.getParameter(request, "validity2", ""));
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setDmdtTrfCdIn(JSPUtil.getParameter(request, "dmdt_trf_cd_in", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDmdtTrfCdList(JSPUtil.getParameter(request, "dmdt_trf_cd_list", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setValidity1(JSPUtil.getParameter(request, "validity1", ""));
		setDmdtTrfGrpTpCd1(JSPUtil.getParameter(request, "dmdt_trf_grp_tp_cd1", ""));
		setDmdtTrfGrpTpCd2(JSPUtil.getParameter(request, "dmdt_trf_grp_tp_cd2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDmdtDeTermCd(JSPUtil.getParameter(request, "dmdt_de_term_cd", ""));
		setDmdtDeTermNm(JSPUtil.getParameter(request, "dmdt_de_term_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicTariffSummaryParamVO[]
	 */
	public SearchBasicTariffSummaryParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicTariffSummaryParamVO[]
	 */
	public SearchBasicTariffSummaryParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicTariffSummaryParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] validity3 = (JSPUtil.getParameter(request, prefix	+ "validity3".trim(), length));
			String[] validity2 = (JSPUtil.getParameter(request, prefix	+ "validity2".trim(), length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd".trim(), length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id".trim(), length));
			String[] dmdtTrfCdIn = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd_in".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] dmdtTrfCdList = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd_list".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] validity1 = (JSPUtil.getParameter(request, prefix	+ "validity1".trim(), length));
			String[] dmdtTrfGrpTpCd1 = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_grp_tp_cd1".trim(), length));
			String[] dmdtTrfGrpTpCd2 = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_grp_tp_cd2".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] dmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_cd", length));
			String[] dmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBasicTariffSummaryParamVO();
				if (validity3[i] != null)
					model.setValidity3(validity3[i]);
				if (validity2[i] != null)
					model.setValidity2(validity2[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (dmdtTrfCdIn[i] != null)
					model.setDmdtTrfCdIn(dmdtTrfCdIn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtTrfCdList[i] != null)
					model.setDmdtTrfCdList(dmdtTrfCdList[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (validity1[i] != null)
					model.setValidity1(validity1[i]);
				if (dmdtTrfGrpTpCd1[i] != null)
					model.setDmdtTrfGrpTpCd1(dmdtTrfGrpTpCd1[i]);
				if (dmdtTrfGrpTpCd2[i] != null)
					model.setDmdtTrfGrpTpCd2(dmdtTrfGrpTpCd2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmdtDeTermCd[i] != null)
					model.setDmdtDeTermCd(dmdtDeTermCd[i]);
				if (dmdtDeTermNm[i] != null)
					model.setDmdtDeTermNm(dmdtDeTermNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicTariffSummaryParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicTariffSummaryParamVO[]
	 */
	public SearchBasicTariffSummaryParamVO[] getSearchBasicTariffSummaryParamVOs(){
		SearchBasicTariffSummaryParamVO[] vos = (SearchBasicTariffSummaryParamVO[])models.toArray(new SearchBasicTariffSummaryParamVO[models.size()]);
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
		this.validity3 = this.validity3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validity2 = this.validity2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCdIn = this.dmdtTrfCdIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCdList = this.dmdtTrfCdList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validity1 = this.validity1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfGrpTpCd1 = this.dmdtTrfGrpTpCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfGrpTpCd2 = this.dmdtTrfGrpTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermCd = this.dmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermNm = this.dmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
