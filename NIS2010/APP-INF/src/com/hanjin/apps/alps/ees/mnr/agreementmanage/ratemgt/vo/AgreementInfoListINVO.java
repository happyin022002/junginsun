/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementInfoListINVO.java
*@FileTitle : AgreementInfoListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.06.30 함형석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgreementInfoListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgreementInfoListINVO> models = new ArrayList<AgreementInfoListINVO>();
	
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String agmtEqType = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String arHdQtrCd = null;
	/* Column Info */
	private String agmtOfcCd = null;
	/* Column Info */
	private String agmtFmDt = null;
	/* Column Info */
	private String agmtToDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgreementInfoListINVO() {}

	public AgreementInfoListINVO(String ibflag, String pagerows, String agmtEqType, String agmtOfcCd, String agmtFmDt, String agmtToDt, String vndrSeq, String costOfcCd, String arHdQtrCd) {
		this.ibflag = ibflag;
		this.costOfcCd = costOfcCd;
		this.agmtEqType = agmtEqType;
		this.vndrSeq = vndrSeq;
		this.arHdQtrCd = arHdQtrCd;
		this.agmtOfcCd = agmtOfcCd;
		this.agmtFmDt = agmtFmDt;
		this.agmtToDt = agmtToDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("agmt_eq_type", getAgmtEqType());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ar_hd_qtr_cd", getArHdQtrCd());
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
		this.hashColumns.put("agmt_fm_dt", getAgmtFmDt());
		this.hashColumns.put("agmt_to_dt", getAgmtToDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("agmt_eq_type", "agmtEqType");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ar_hd_qtr_cd", "arHdQtrCd");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("agmt_fm_dt", "agmtFmDt");
		this.hashFields.put("agmt_to_dt", "agmtToDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtEqType
	 */
	public String getAgmtEqType() {
		return this.agmtEqType;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrCd
	 */
	public String getArHdQtrCd() {
		return this.arHdQtrCd;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCd
	 */
	public String getAgmtOfcCd() {
		return this.agmtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtFmDt
	 */
	public String getAgmtFmDt() {
		return this.agmtFmDt;
	}
	
	/**
	 * Column Info
	 * @return agmtToDt
	 */
	public String getAgmtToDt() {
		return this.agmtToDt;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtEqType
	 */
	public void setAgmtEqType(String agmtEqType) {
		this.agmtEqType = agmtEqType;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrCd
	 */
	public void setArHdQtrCd(String arHdQtrCd) {
		this.arHdQtrCd = arHdQtrCd;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCd
	 */
	public void setAgmtOfcCd(String agmtOfcCd) {
		this.agmtOfcCd = agmtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtFmDt
	 */
	public void setAgmtFmDt(String agmtFmDt) {
		this.agmtFmDt = agmtFmDt;
	}
	
	/**
	 * Column Info
	 * @param agmtToDt
	 */
	public void setAgmtToDt(String agmtToDt) {
		this.agmtToDt = agmtToDt;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setAgmtEqType(JSPUtil.getParameter(request, "agmt_eq_type", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setArHdQtrCd(JSPUtil.getParameter(request, "ar_hd_qtr_cd", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request, "agmt_ofc_cd", ""));
		setAgmtFmDt(JSPUtil.getParameter(request, "agmt_fm_dt", ""));
		setAgmtToDt(JSPUtil.getParameter(request, "agmt_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgreementInfoListINVO[]
	 */
	public AgreementInfoListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgreementInfoListINVO[]
	 */
	public AgreementInfoListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgreementInfoListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] agmtEqType = (JSPUtil.getParameter(request, prefix	+ "agmt_eq_type", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] arHdQtrCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_cd", length));
			String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cd", length));
			String[] agmtFmDt = (JSPUtil.getParameter(request, prefix	+ "agmt_fm_dt", length));
			String[] agmtToDt = (JSPUtil.getParameter(request, prefix	+ "agmt_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgreementInfoListINVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (agmtEqType[i] != null)
					model.setAgmtEqType(agmtEqType[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (arHdQtrCd[i] != null)
					model.setArHdQtrCd(arHdQtrCd[i]);
				if (agmtOfcCd[i] != null)
					model.setAgmtOfcCd(agmtOfcCd[i]);
				if (agmtFmDt[i] != null)
					model.setAgmtFmDt(agmtFmDt[i]);
				if (agmtToDt[i] != null)
					model.setAgmtToDt(agmtToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgreementInfoListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgreementInfoListINVO[]
	 */
	public AgreementInfoListINVO[] getAgreementInfoListINVOs(){
		AgreementInfoListINVO[] vos = (AgreementInfoListINVO[])models.toArray(new AgreementInfoListINVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtEqType = this.agmtEqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrCd = this.arHdQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd = this.agmtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFmDt = this.agmtFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtToDt = this.agmtToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
