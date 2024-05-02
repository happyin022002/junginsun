/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DeleteInquiryParmVO.java
*@FileTitle : DeleteInquiryParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.15 황효근 
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

public class DeleteInquiryParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DeleteInquiryParmVO> models = new ArrayList<DeleteInquiryParmVO>();
	
	/* Column Info */
	private String ofcFlg = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String dtFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String grpFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String specCd = null;
	
	/* Column Info */
	private String ofcCdDeltRsnCdList = null;
	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DeleteInquiryParmVO() {}

	public DeleteInquiryParmVO(String ibflag, String pagerows, String dtFlg, String fmDt, String toDt, String ofcFlg, String ofcCd, String grpFlg, String delCd, String ofcCdDeltRsnCdList, String specCd) {
		this.ofcFlg = ofcFlg;
		this.toDt = toDt;
		this.dtFlg = dtFlg;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.fmDt = fmDt;
		this.grpFlg = grpFlg;
		this.delCd = delCd;
		this.ofcCdDeltRsnCdList = ofcCdDeltRsnCdList;
		this.pagerows = pagerows;
		this.specCd = specCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_flg", getOfcFlg());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("dt_flg", getDtFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("grp_flg", getGrpFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ofc_cd_delt_rsn_cd_list", getOfcCdDeltRsnCdList());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spec_cd", getSpecCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_flg", "ofcFlg");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("dt_flg", "dtFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("grp_flg", "grpFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ofc_cd_delt_rsn_cd_list", "ofcCdDeltRsnCdList");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spec_cd", "specCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcFlg
	 */
	public String getOfcFlg() {
		return this.ofcFlg;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return dtFlg
	 */
	public String getDtFlg() {
		return this.dtFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return grpFlg
	 */
	public String getGrpFlg() {
		return this.grpFlg;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	/**
	 * Column Info
	 * @return ofcCdDeltRsnCdList
	 */
	public String getOfcCdDeltRsnCdList() {
		return this.ofcCdDeltRsnCdList;
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
	 * @param ofcFlg
	 */
	public void setOfcFlg(String ofcFlg) {
		this.ofcFlg = ofcFlg;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param dtFlg
	 */
	public void setDtFlg(String dtFlg) {
		this.dtFlg = dtFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param grpFlg
	 */
	public void setGrpFlg(String grpFlg) {
		this.grpFlg = grpFlg;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	/**
	 * Column Info
	 * @param ofcCdDeltRsnCdList
	 */
	public void setOfcCdDeltRsnCdList(String ofcCdDeltRsnCdList) {
		this.ofcCdDeltRsnCdList = ofcCdDeltRsnCdList;
	}
	
	public String getSpecCd() {
		return specCd;
	}

	public void setSpecCd(String specCd) {
		this.specCd = specCd;
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
		setOfcFlg(JSPUtil.getParameter(request, "ofc_flg", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setDtFlg(JSPUtil.getParameter(request, "dt_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setGrpFlg(JSPUtil.getParameter(request, "grp_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setOfcCdDeltRsnCdList(JSPUtil.getParameter(request, "ofc_cd_delt_rsn_cd_list", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSpecCd(JSPUtil.getParameter(request, "spec_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DeleteInquiryParmVO[]
	 */
	public DeleteInquiryParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DeleteInquiryParmVO[]
	 */
	public DeleteInquiryParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DeleteInquiryParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_flg", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] dtFlg = (JSPUtil.getParameter(request, prefix	+ "dt_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] grpFlg = (JSPUtil.getParameter(request, prefix	+ "grp_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ofcCdDeltRsnCdList = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_delt_rsn_cd_list", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] specCd = (JSPUtil.getParameter(request, prefix	+ "spec_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DeleteInquiryParmVO();
				if (ofcFlg[i] != null)
					model.setOfcFlg(ofcFlg[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (dtFlg[i] != null)
					model.setDtFlg(dtFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (grpFlg[i] != null)
					model.setGrpFlg(grpFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ofcCdDeltRsnCdList[i] != null)
					model.setOfcCdDeltRsnCdList(ofcCdDeltRsnCdList[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (specCd[i] != null)
					model.setSpecCd(specCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDeleteInquiryParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DeleteInquiryParmVO[]
	 */
	public DeleteInquiryParmVO[] getDeleteInquiryParmVOs(){
		DeleteInquiryParmVO[] vos = (DeleteInquiryParmVO[])models.toArray(new DeleteInquiryParmVO[models.size()]);
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
		this.ofcFlg = this.ofcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtFlg = this.dtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlg = this.grpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdDeltRsnCdList = this.ofcCdDeltRsnCdList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specCd = this.specCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
