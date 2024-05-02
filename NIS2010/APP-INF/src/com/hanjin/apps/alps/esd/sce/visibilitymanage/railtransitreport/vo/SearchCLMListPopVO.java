/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCLMListPopVO.java
*@FileTitle : SearchCLMListPopVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.09.11 이중환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCLMListPopVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCLMListPopVO> models = new ArrayList<SearchCLMListPopVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String arrDate = null;
	/* Column Info */
	private String clmSghtAbbrNm = null;
	/* Column Info */
	private String trspModTpCd = null;
	/* Column Info */
	private String clmSeq = null;
	/* Column Info */
	private String toSteCd = null;
	/* Column Info */
	private String fmSteCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String fcarNo = null;
	/* Column Info */
	private String trnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String clmCrrNm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String arrSteCd = null;
	/* Column Info */
	private String depLocNm = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String arrTime = null;
	/* Column Info */
	private String cnmvYr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCLMListPopVO() {}

	public SearchCLMListPopVO(String ibflag, String pagerows, String cntrNo, String cnmvYr, String cnmvIdNo, String clmSeq, String cntrTpszCd, String fullMtyCd, String clmSghtAbbrNm, String locCd, String arrSteCd, String arrDate, String arrTime, String clmCrrNm, String trspModTpCd, String fmNodCd, String fmSteCd, String toNodCd, String toSteCd, String depLocNm, String trnNo, String fcarNo) {
		this.toNodCd = toNodCd;
		this.arrDate = arrDate;
		this.clmSghtAbbrNm = clmSghtAbbrNm;
		this.trspModTpCd = trspModTpCd;
		this.clmSeq = clmSeq;
		this.toSteCd = toSteCd;
		this.fmSteCd = fmSteCd;
		this.pagerows = pagerows;
		this.cnmvIdNo = cnmvIdNo;
		this.fmNodCd = fmNodCd;
		this.fcarNo = fcarNo;
		this.trnNo = trnNo;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.clmCrrNm = clmCrrNm;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.arrSteCd = arrSteCd;
		this.depLocNm = depLocNm;
		this.fullMtyCd = fullMtyCd;
		this.arrTime = arrTime;
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("arr_date", getArrDate());
		this.hashColumns.put("clm_sght_abbr_nm", getClmSghtAbbrNm());
		this.hashColumns.put("trsp_mod_tp_cd", getTrspModTpCd());
		this.hashColumns.put("clm_seq", getClmSeq());
		this.hashColumns.put("to_ste_cd", getToSteCd());
		this.hashColumns.put("fm_ste_cd", getFmSteCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("fcar_no", getFcarNo());
		this.hashColumns.put("trn_no", getTrnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("clm_crr_nm", getClmCrrNm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("arr_ste_cd", getArrSteCd());
		this.hashColumns.put("dep_loc_nm", getDepLocNm());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("arr_time", getArrTime());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("arr_date", "arrDate");
		this.hashFields.put("clm_sght_abbr_nm", "clmSghtAbbrNm");
		this.hashFields.put("trsp_mod_tp_cd", "trspModTpCd");
		this.hashFields.put("clm_seq", "clmSeq");
		this.hashFields.put("to_ste_cd", "toSteCd");
		this.hashFields.put("fm_ste_cd", "fmSteCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("fcar_no", "fcarNo");
		this.hashFields.put("trn_no", "trnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("clm_crr_nm", "clmCrrNm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("arr_ste_cd", "arrSteCd");
		this.hashFields.put("dep_loc_nm", "depLocNm");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("arr_time", "arrTime");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return arrDate
	 */
	public String getArrDate() {
		return this.arrDate;
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
	 * @return clmSeq
	 */
	public String getClmSeq() {
		return this.clmSeq;
	}
	
	/**
	 * Column Info
	 * @return toSteCd
	 */
	public String getToSteCd() {
		return this.toSteCd;
	}
	
	/**
	 * Column Info
	 * @return fmSteCd
	 */
	public String getFmSteCd() {
		return this.fmSteCd;
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
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return fcarNo
	 */
	public String getFcarNo() {
		return this.fcarNo;
	}
	
	/**
	 * Column Info
	 * @return trnNo
	 */
	public String getTrnNo() {
		return this.trnNo;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return depLocNm
	 */
	public String getDepLocNm() {
		return this.depLocNm;
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
	 * @return arrTime
	 */
	public String getArrTime() {
		return this.arrTime;
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
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param arrDate
	 */
	public void setArrDate(String arrDate) {
		this.arrDate = arrDate;
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
	 * @param clmSeq
	 */
	public void setClmSeq(String clmSeq) {
		this.clmSeq = clmSeq;
	}
	
	/**
	 * Column Info
	 * @param toSteCd
	 */
	public void setToSteCd(String toSteCd) {
		this.toSteCd = toSteCd;
	}
	
	/**
	 * Column Info
	 * @param fmSteCd
	 */
	public void setFmSteCd(String fmSteCd) {
		this.fmSteCd = fmSteCd;
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
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param fcarNo
	 */
	public void setFcarNo(String fcarNo) {
		this.fcarNo = fcarNo;
	}
	
	/**
	 * Column Info
	 * @param trnNo
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param depLocNm
	 */
	public void setDepLocNm(String depLocNm) {
		this.depLocNm = depLocNm;
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
	 * @param arrTime
	 */
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setArrDate(JSPUtil.getParameter(request, "arr_date", ""));
		setClmSghtAbbrNm(JSPUtil.getParameter(request, "clm_sght_abbr_nm", ""));
		setTrspModTpCd(JSPUtil.getParameter(request, "trsp_mod_tp_cd", ""));
		setClmSeq(JSPUtil.getParameter(request, "clm_seq", ""));
		setToSteCd(JSPUtil.getParameter(request, "to_ste_cd", ""));
		setFmSteCd(JSPUtil.getParameter(request, "fm_ste_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setFcarNo(JSPUtil.getParameter(request, "fcar_no", ""));
		setTrnNo(JSPUtil.getParameter(request, "trn_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setClmCrrNm(JSPUtil.getParameter(request, "clm_crr_nm", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setArrSteCd(JSPUtil.getParameter(request, "arr_ste_cd", ""));
		setDepLocNm(JSPUtil.getParameter(request, "dep_loc_nm", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setArrTime(JSPUtil.getParameter(request, "arr_time", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCLMListPopVO[]
	 */
	public SearchCLMListPopVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCLMListPopVO[]
	 */
	public SearchCLMListPopVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCLMListPopVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] arrDate = (JSPUtil.getParameter(request, prefix	+ "arr_date", length));
			String[] clmSghtAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clm_sght_abbr_nm", length));
			String[] trspModTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_tp_cd", length));
			String[] clmSeq = (JSPUtil.getParameter(request, prefix	+ "clm_seq", length));
			String[] toSteCd = (JSPUtil.getParameter(request, prefix	+ "to_ste_cd", length));
			String[] fmSteCd = (JSPUtil.getParameter(request, prefix	+ "fm_ste_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] fcarNo = (JSPUtil.getParameter(request, prefix	+ "fcar_no", length));
			String[] trnNo = (JSPUtil.getParameter(request, prefix	+ "trn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] clmCrrNm = (JSPUtil.getParameter(request, prefix	+ "clm_crr_nm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] arrSteCd = (JSPUtil.getParameter(request, prefix	+ "arr_ste_cd", length));
			String[] depLocNm = (JSPUtil.getParameter(request, prefix	+ "dep_loc_nm", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] arrTime = (JSPUtil.getParameter(request, prefix	+ "arr_time", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCLMListPopVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (arrDate[i] != null)
					model.setArrDate(arrDate[i]);
				if (clmSghtAbbrNm[i] != null)
					model.setClmSghtAbbrNm(clmSghtAbbrNm[i]);
				if (trspModTpCd[i] != null)
					model.setTrspModTpCd(trspModTpCd[i]);
				if (clmSeq[i] != null)
					model.setClmSeq(clmSeq[i]);
				if (toSteCd[i] != null)
					model.setToSteCd(toSteCd[i]);
				if (fmSteCd[i] != null)
					model.setFmSteCd(fmSteCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (fcarNo[i] != null)
					model.setFcarNo(fcarNo[i]);
				if (trnNo[i] != null)
					model.setTrnNo(trnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (clmCrrNm[i] != null)
					model.setClmCrrNm(clmCrrNm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (arrSteCd[i] != null)
					model.setArrSteCd(arrSteCd[i]);
				if (depLocNm[i] != null)
					model.setDepLocNm(depLocNm[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (arrTime[i] != null)
					model.setArrTime(arrTime[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCLMListPopVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCLMListPopVO[]
	 */
	public SearchCLMListPopVO[] getSearchCLMListPopVOs(){
		SearchCLMListPopVO[] vos = (SearchCLMListPopVO[])models.toArray(new SearchCLMListPopVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDate = this.arrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmSghtAbbrNm = this.clmSghtAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModTpCd = this.trspModTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmSeq = this.clmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSteCd = this.toSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSteCd = this.fmSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcarNo = this.fcarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnNo = this.trnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCrrNm = this.clmCrrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSteCd = this.arrSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLocNm = this.depLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTime = this.arrTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
