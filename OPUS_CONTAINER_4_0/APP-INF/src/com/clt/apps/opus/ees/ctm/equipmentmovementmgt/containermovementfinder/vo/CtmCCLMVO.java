/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CtmCCLMVO.java
*@FileTitle : CtmCCLMVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.18 우경민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 우경민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CtmCCLMVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CtmCCLMVO> models = new ArrayList<CtmCCLMVO>();
	
	/* Column Info */
	private String clmSghtAbbrNm = null;
	/* Column Info */
	private String trspModTpCd = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String depSteCd = null;
	/* Column Info */
	private String depDt = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fcarNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trnNo = null;
	/* Column Info */
	private String clmCrrNm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String arrSteCd = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String depLocNm = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String arrLocNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CtmCCLMVO() {}

	public CtmCCLMVO(String ibflag, String pagerows, String fullMtyCd, String clmSghtAbbrNm, String arrLocNm, String arrSteCd, String arrDt, String clmCrrNm, String trspModTpCd, String depLocNm, String depSteCd, String depDt, String trnNo, String fcarNo, String cntrNo, String cnmvYr, String cnmvIdNo) {
		this.clmSghtAbbrNm = clmSghtAbbrNm;
		this.trspModTpCd = trspModTpCd;
		this.arrDt = arrDt;
		this.depSteCd = depSteCd;
		this.depDt = depDt;
		this.cnmvIdNo = cnmvIdNo;
		this.pagerows = pagerows;
		this.fcarNo = fcarNo;
		this.ibflag = ibflag;
		this.trnNo = trnNo;
		this.clmCrrNm = clmCrrNm;
		this.cntrNo = cntrNo;
		this.arrSteCd = arrSteCd;
		this.fullMtyCd = fullMtyCd;
		this.depLocNm = depLocNm;
		this.cnmvYr = cnmvYr;
		this.arrLocNm = arrLocNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("clm_sght_abbr_nm", getClmSghtAbbrNm());
		this.hashColumns.put("trsp_mod_tp_cd", getTrspModTpCd());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("dep_ste_cd", getDepSteCd());
		this.hashColumns.put("dep_dt", getDepDt());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fcar_no", getFcarNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trn_no", getTrnNo());
		this.hashColumns.put("clm_crr_nm", getClmCrrNm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("arr_ste_cd", getArrSteCd());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("dep_loc_nm", getDepLocNm());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("arr_loc_nm", getArrLocNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("clm_sght_abbr_nm", "clmSghtAbbrNm");
		this.hashFields.put("trsp_mod_tp_cd", "trspModTpCd");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("dep_ste_cd", "depSteCd");
		this.hashFields.put("dep_dt", "depDt");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fcar_no", "fcarNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trn_no", "trnNo");
		this.hashFields.put("clm_crr_nm", "clmCrrNm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("arr_ste_cd", "arrSteCd");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("dep_loc_nm", "depLocNm");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("arr_loc_nm", "arrLocNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return clmSghtAbbrNm
	 */
	public String getClmSghtAbbrNm() {
		return this.clmSghtAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return trspModTpCd
	 */
	public String getTrspModTpCd() {
		return this.trspModTpCd;
	}
	
	/**
	 * Column Info
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}
	
	/**
	 * Column Info
	 * @return depSteCd
	 */
	public String getDepSteCd() {
		return this.depSteCd;
	}
	
	/**
	 * Column Info
	 * @return depDt
	 */
	public String getDepDt() {
		return this.depDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
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
	 * @return fcarNo
	 */
	public String getFcarNo() {
		return this.fcarNo;
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
	 * @return trnNo
	 */
	public String getTrnNo() {
		return this.trnNo;
	}
	
	/**
	 * Column Info
	 * @return clmCrrNm
	 */
	public String getClmCrrNm() {
		return this.clmCrrNm;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return arrSteCd
	 */
	public String getArrSteCd() {
		return this.arrSteCd;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return depLocNm
	 */
	public String getDepLocNm() {
		return this.depLocNm;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return arrLocNm
	 */
	public String getArrLocNm() {
		return this.arrLocNm;
	}
	

	/**
	 * Column Info
	 * @param clmSghtAbbrNm
	 */
	public void setClmSghtAbbrNm(String clmSghtAbbrNm) {
		this.clmSghtAbbrNm = clmSghtAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param trspModTpCd
	 */
	public void setTrspModTpCd(String trspModTpCd) {
		this.trspModTpCd = trspModTpCd;
	}
	
	/**
	 * Column Info
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}
	
	/**
	 * Column Info
	 * @param depSteCd
	 */
	public void setDepSteCd(String depSteCd) {
		this.depSteCd = depSteCd;
	}
	
	/**
	 * Column Info
	 * @param depDt
	 */
	public void setDepDt(String depDt) {
		this.depDt = depDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
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
	 * @param fcarNo
	 */
	public void setFcarNo(String fcarNo) {
		this.fcarNo = fcarNo;
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
	 * @param trnNo
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}
	
	/**
	 * Column Info
	 * @param clmCrrNm
	 */
	public void setClmCrrNm(String clmCrrNm) {
		this.clmCrrNm = clmCrrNm;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param arrSteCd
	 */
	public void setArrSteCd(String arrSteCd) {
		this.arrSteCd = arrSteCd;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param depLocNm
	 */
	public void setDepLocNm(String depLocNm) {
		this.depLocNm = depLocNm;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param arrLocNm
	 */
	public void setArrLocNm(String arrLocNm) {
		this.arrLocNm = arrLocNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setClmSghtAbbrNm(JSPUtil.getParameter(request, "clm_sght_abbr_nm", ""));
		setTrspModTpCd(JSPUtil.getParameter(request, "trsp_mod_tp_cd", ""));
		setArrDt(JSPUtil.getParameter(request, "arr_dt", ""));
		setDepSteCd(JSPUtil.getParameter(request, "dep_ste_cd", ""));
		setDepDt(JSPUtil.getParameter(request, "dep_dt", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFcarNo(JSPUtil.getParameter(request, "fcar_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrnNo(JSPUtil.getParameter(request, "trn_no", ""));
		setClmCrrNm(JSPUtil.getParameter(request, "clm_crr_nm", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setArrSteCd(JSPUtil.getParameter(request, "arr_ste_cd", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setDepLocNm(JSPUtil.getParameter(request, "dep_loc_nm", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setArrLocNm(JSPUtil.getParameter(request, "arr_loc_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtmCCLMVO[]
	 */
	public CtmCCLMVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CtmCCLMVO[]
	 */
	public CtmCCLMVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmCCLMVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] clmSghtAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clm_sght_abbr_nm", length));
			String[] trspModTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_tp_cd", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] depSteCd = (JSPUtil.getParameter(request, prefix	+ "dep_ste_cd", length));
			String[] depDt = (JSPUtil.getParameter(request, prefix	+ "dep_dt", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fcarNo = (JSPUtil.getParameter(request, prefix	+ "fcar_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trnNo = (JSPUtil.getParameter(request, prefix	+ "trn_no", length));
			String[] clmCrrNm = (JSPUtil.getParameter(request, prefix	+ "clm_crr_nm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] arrSteCd = (JSPUtil.getParameter(request, prefix	+ "arr_ste_cd", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] depLocNm = (JSPUtil.getParameter(request, prefix	+ "dep_loc_nm", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] arrLocNm = (JSPUtil.getParameter(request, prefix	+ "arr_loc_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CtmCCLMVO();
				if (clmSghtAbbrNm[i] != null)
					model.setClmSghtAbbrNm(clmSghtAbbrNm[i]);
				if (trspModTpCd[i] != null)
					model.setTrspModTpCd(trspModTpCd[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (depSteCd[i] != null)
					model.setDepSteCd(depSteCd[i]);
				if (depDt[i] != null)
					model.setDepDt(depDt[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fcarNo[i] != null)
					model.setFcarNo(fcarNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trnNo[i] != null)
					model.setTrnNo(trnNo[i]);
				if (clmCrrNm[i] != null)
					model.setClmCrrNm(clmCrrNm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (arrSteCd[i] != null)
					model.setArrSteCd(arrSteCd[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (depLocNm[i] != null)
					model.setDepLocNm(depLocNm[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (arrLocNm[i] != null)
					model.setArrLocNm(arrLocNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCtmCCLMVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtmCCLMVO[]
	 */
	public CtmCCLMVO[] getCtmCCLMVOs(){
		CtmCCLMVO[] vos = (CtmCCLMVO[])models.toArray(new CtmCCLMVO[models.size()]);
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
		this.clmSghtAbbrNm = this.clmSghtAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModTpCd = this.trspModTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depSteCd = this.depSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDt = this.depDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcarNo = this.fcarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnNo = this.trnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCrrNm = this.clmCrrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSteCd = this.arrSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLocNm = this.depLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLocNm = this.arrLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
