/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBSInfoVO.java
*@FileTitle : SearchBSInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.12 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBSInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBSInfoVO> models = new ArrayList<SearchBSInfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vesslLaneCode = null;
	/* Column Info */
	private String vslBsaDrySubSpc = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslBsaUsdFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String toYearWeek = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String companyCode = null;
	/* Column Info */
	private String tradeCode = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslWgt = null;
	/* Column Info */
	private String fromYearWeek = null;
	/* Column Info */
	private String vslSpc = null;
	/* Column Info */
	private String vslBsaRfSubSpc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBSInfoVO() {}

	public SearchBSInfoVO(String ibflag, String pagerows, String fromYearWeek, String toYearWeek, String companyCode, String tradeCode, String vesslLaneCode, String vvd, String vslSpc, String vslWgt, String vslBsaRfSubSpc, String vslBsaDrySubSpc, String scnrId, String vslCd, String skdVoyNo, String skdDirCd, String vslBsaUsdFlg) {
		this.vslCd = vslCd;
		this.vesslLaneCode = vesslLaneCode;
		this.vslBsaDrySubSpc = vslBsaDrySubSpc;
		this.scnrId = scnrId;
		this.skdVoyNo = skdVoyNo;
		this.vslBsaUsdFlg = vslBsaUsdFlg;
		this.skdDirCd = skdDirCd;
		this.toYearWeek = toYearWeek;
		this.pagerows = pagerows;
		this.companyCode = companyCode;
		this.tradeCode = tradeCode;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.vslWgt = vslWgt;
		this.fromYearWeek = fromYearWeek;
		this.vslSpc = vslSpc;
		this.vslBsaRfSubSpc = vslBsaRfSubSpc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vessl_lane_code", getVesslLaneCode());
		this.hashColumns.put("vsl_bsa_dry_sub_spc", getVslBsaDrySubSpc());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_bsa_usd_flg", getVslBsaUsdFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("to_year_week", getToYearWeek());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("company_code", getCompanyCode());
		this.hashColumns.put("trade_code", getTradeCode());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_wgt", getVslWgt());
		this.hashColumns.put("from_year_week", getFromYearWeek());
		this.hashColumns.put("vsl_spc", getVslSpc());
		this.hashColumns.put("vsl_bsa_rf_sub_spc", getVslBsaRfSubSpc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vessl_lane_code", "vesslLaneCode");
		this.hashFields.put("vsl_bsa_dry_sub_spc", "vslBsaDrySubSpc");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_bsa_usd_flg", "vslBsaUsdFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("to_year_week", "toYearWeek");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("company_code", "companyCode");
		this.hashFields.put("trade_code", "tradeCode");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_wgt", "vslWgt");
		this.hashFields.put("from_year_week", "fromYearWeek");
		this.hashFields.put("vsl_spc", "vslSpc");
		this.hashFields.put("vsl_bsa_rf_sub_spc", "vslBsaRfSubSpc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vesslLaneCode
	 */
	public String getVesslLaneCode() {
		return this.vesslLaneCode;
	}
	
	/**
	 * Column Info
	 * @return vslBsaDrySubSpc
	 */
	public String getVslBsaDrySubSpc() {
		return this.vslBsaDrySubSpc;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslBsaUsdFlg
	 */
	public String getVslBsaUsdFlg() {
		return this.vslBsaUsdFlg;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return toYearWeek
	 */
	public String getToYearWeek() {
		return this.toYearWeek;
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
	 * @return companyCode
	 */
	public String getCompanyCode() {
		return this.companyCode;
	}
	
	/**
	 * Column Info
	 * @return tradeCode
	 */
	public String getTradeCode() {
		return this.tradeCode;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return vslWgt
	 */
	public String getVslWgt() {
		return this.vslWgt;
	}
	
	/**
	 * Column Info
	 * @return fromYearWeek
	 */
	public String getFromYearWeek() {
		return this.fromYearWeek;
	}
	
	/**
	 * Column Info
	 * @return vslSpc
	 */
	public String getVslSpc() {
		return this.vslSpc;
	}
	
	/**
	 * Column Info
	 * @return vslBsaRfSubSpc
	 */
	public String getVslBsaRfSubSpc() {
		return this.vslBsaRfSubSpc;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vesslLaneCode
	 */
	public void setVesslLaneCode(String vesslLaneCode) {
		this.vesslLaneCode = vesslLaneCode;
	}
	
	/**
	 * Column Info
	 * @param vslBsaDrySubSpc
	 */
	public void setVslBsaDrySubSpc(String vslBsaDrySubSpc) {
		this.vslBsaDrySubSpc = vslBsaDrySubSpc;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslBsaUsdFlg
	 */
	public void setVslBsaUsdFlg(String vslBsaUsdFlg) {
		this.vslBsaUsdFlg = vslBsaUsdFlg;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param toYearWeek
	 */
	public void setToYearWeek(String toYearWeek) {
		this.toYearWeek = toYearWeek;
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
	 * @param companyCode
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	/**
	 * Column Info
	 * @param tradeCode
	 */
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param vslWgt
	 */
	public void setVslWgt(String vslWgt) {
		this.vslWgt = vslWgt;
	}
	
	/**
	 * Column Info
	 * @param fromYearWeek
	 */
	public void setFromYearWeek(String fromYearWeek) {
		this.fromYearWeek = fromYearWeek;
	}
	
	/**
	 * Column Info
	 * @param vslSpc
	 */
	public void setVslSpc(String vslSpc) {
		this.vslSpc = vslSpc;
	}
	
	/**
	 * Column Info
	 * @param vslBsaRfSubSpc
	 */
	public void setVslBsaRfSubSpc(String vslBsaRfSubSpc) {
		this.vslBsaRfSubSpc = vslBsaRfSubSpc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVesslLaneCode(JSPUtil.getParameter(request, "vessl_lane_code", ""));
		setVslBsaDrySubSpc(JSPUtil.getParameter(request, "vsl_bsa_dry_sub_spc", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslBsaUsdFlg(JSPUtil.getParameter(request, "vsl_bsa_usd_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setToYearWeek(JSPUtil.getParameter(request, "to_year_week", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCompanyCode(JSPUtil.getParameter(request, "company_code", ""));
		setTradeCode(JSPUtil.getParameter(request, "trade_code", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslWgt(JSPUtil.getParameter(request, "vsl_wgt", ""));
		setFromYearWeek(JSPUtil.getParameter(request, "from_year_week", ""));
		setVslSpc(JSPUtil.getParameter(request, "vsl_spc", ""));
		setVslBsaRfSubSpc(JSPUtil.getParameter(request, "vsl_bsa_rf_sub_spc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBSInfoVO[]
	 */
	public SearchBSInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBSInfoVO[]
	 */
	public SearchBSInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBSInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vesslLaneCode = (JSPUtil.getParameter(request, prefix	+ "vessl_lane_code", length));
			String[] vslBsaDrySubSpc = (JSPUtil.getParameter(request, prefix	+ "vsl_bsa_dry_sub_spc", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslBsaUsdFlg = (JSPUtil.getParameter(request, prefix	+ "vsl_bsa_usd_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] toYearWeek = (JSPUtil.getParameter(request, prefix	+ "to_year_week", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] companyCode = (JSPUtil.getParameter(request, prefix	+ "company_code", length));
			String[] tradeCode = (JSPUtil.getParameter(request, prefix	+ "trade_code", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslWgt = (JSPUtil.getParameter(request, prefix	+ "vsl_wgt", length));
			String[] fromYearWeek = (JSPUtil.getParameter(request, prefix	+ "from_year_week", length));
			String[] vslSpc = (JSPUtil.getParameter(request, prefix	+ "vsl_spc", length));
			String[] vslBsaRfSubSpc = (JSPUtil.getParameter(request, prefix	+ "vsl_bsa_rf_sub_spc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBSInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vesslLaneCode[i] != null)
					model.setVesslLaneCode(vesslLaneCode[i]);
				if (vslBsaDrySubSpc[i] != null)
					model.setVslBsaDrySubSpc(vslBsaDrySubSpc[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslBsaUsdFlg[i] != null)
					model.setVslBsaUsdFlg(vslBsaUsdFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (toYearWeek[i] != null)
					model.setToYearWeek(toYearWeek[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (companyCode[i] != null)
					model.setCompanyCode(companyCode[i]);
				if (tradeCode[i] != null)
					model.setTradeCode(tradeCode[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslWgt[i] != null)
					model.setVslWgt(vslWgt[i]);
				if (fromYearWeek[i] != null)
					model.setFromYearWeek(fromYearWeek[i]);
				if (vslSpc[i] != null)
					model.setVslSpc(vslSpc[i]);
				if (vslBsaRfSubSpc[i] != null)
					model.setVslBsaRfSubSpc(vslBsaRfSubSpc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBSInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBSInfoVO[]
	 */
	public SearchBSInfoVO[] getSearchBSInfoVOs(){
		SearchBSInfoVO[] vos = (SearchBSInfoVO[])models.toArray(new SearchBSInfoVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesslLaneCode = this.vesslLaneCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBsaDrySubSpc = this.vslBsaDrySubSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBsaUsdFlg = this.vslBsaUsdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYearWeek = this.toYearWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.companyCode = this.companyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeCode = this.tradeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslWgt = this.vslWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromYearWeek = this.fromYearWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSpc = this.vslSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBsaRfSubSpc = this.vslBsaRfSubSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
