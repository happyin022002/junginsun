/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocscrnVO.java
*@FileTitle : RocscrnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.04 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CrnVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocscrnVO extends CrnVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocscrnVO> models = new ArrayList<RocscrnVO>();
	
	/* Column Info */
	private String demFreeDt = null;
	/* Column Info */
	private String crnNumber = null;
	/* Column Info */
	private String fcrnNumber = null;
	 
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String brthCtnt = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String ntfyLtrCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cstmsDeclUserId = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String vvdNumber = null;
	/* Page Number */
	private String userOfcCd = null;
	
	private String vslCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocscrnVO() {}

	public RocscrnVO(String ibflag, String pagerows, String crnNumber, String vvdNumber, 
			String vslEngNm, String vpsEtaDt, String demFreeDt, String ntfyLtrCtnt, 
			String cstmsDeclUserId, String creDt, String brthCtnt,String userOfcCd,
			String vslCd, String skdVoyNo, String skdDirCd,String vpsEtdDt,String fcrnNumber) {
		this.demFreeDt = demFreeDt;
		this.crnNumber = crnNumber;
		this.fcrnNumber = fcrnNumber;
		this.ibflag = ibflag;
		this.brthCtnt = brthCtnt;
		this.vslEngNm = vslEngNm;
		this.ntfyLtrCtnt = ntfyLtrCtnt;
		this.creDt = creDt;
		this.cstmsDeclUserId = cstmsDeclUserId;
		this.vpsEtaDt = vpsEtaDt;
		this.vpsEtdDt = vpsEtdDt;
		this.vvdNumber = vvdNumber;
		this.userOfcCd = userOfcCd;
		this.pagerows = pagerows;
		this.skdDirCd = skdDirCd;
		this.skdVoyNo = skdVoyNo;
		this.vslCd = vslCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dem_free_dt", getDemFreeDt());
		this.hashColumns.put("vsl_call_ref_no", getCrnNumber());
		this.hashColumns.put("frm_crn_number", getFCrnNumber());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("brth_ctnt", getBrthCtnt());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("ntfy_ltr_ctnt", getNtfyLtrCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cstms_decl_usr_id", getCstmsDeclUserId());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("vvd_number", getVvdNumber());
		this.hashColumns.put("user_ofc_cd", getuserOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_cd", getVslCd());		 
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dem_free_dt", "demFreeDt");
		this.hashFields.put("vsl_call_ref_no", "crnNumber");
		this.hashFields.put("frm_crn_number", "fcrnNumber");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("brth_ctnt", "brthCtnt");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("ntfy_ltr_ctnt", "ntfyLtrCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cstms_decl_usr_id", "cstmsDeclUserId");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("vvd_number", "vvdNumber");
		this.hashColumns.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_cd", "vslCd");		 
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return demFreeDt
	 */
	public String getDemFreeDt() {
		return this.demFreeDt;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getuserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return crnNumber
	 */
	public String getCrnNumber() {
		return this.crnNumber;
	}
	/**
	 * Column Info
	 * @return crnNumber
	 */
	public String getFCrnNumber() {
		return this.fcrnNumber;
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
	 * @return brthCtnt
	 */
	public String getBrthCtnt() {
		return this.brthCtnt;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return ntfyLtrCtnt
	 */
	public String getNtfyLtrCtnt() {
		return this.ntfyLtrCtnt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclUserId
	 */
	public String getCstmsDeclUserId() {
		return this.cstmsDeclUserId;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vvdNumber
	 */
	public String getVvdNumber() {
		return this.vvdNumber;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	public String getVslCd() {
		return this.vslCd;
	}
	 
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param demFreeDt
	 */
	public void setuserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	

	/**
	 * Column Info
	 * @param demFreeDt
	 */
	public void setDemFreeDt(String demFreeDt) {
		this.demFreeDt = demFreeDt;
	}
	
	/**
	 * Column Info
	 * @param crnNumber
	 */
	public void setCrnNumber(String crnNumber) {
		this.crnNumber = crnNumber;
	}
	/**
	 * Column Info
	 * @param crnNumber
	 */
	public void setFCrnNumber(String fcrnNumber) {
		this.fcrnNumber = fcrnNumber;
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
	 * @param brthCtnt
	 */
	public void setBrthCtnt(String brthCtnt) {
		this.brthCtnt = brthCtnt;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param ntfyLtrCtnt
	 */
	public void setNtfyLtrCtnt(String ntfyLtrCtnt) {
		this.ntfyLtrCtnt = ntfyLtrCtnt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclUserId
	 */
	public void setCstmsDeclUserId(String cstmsDeclUserId) {
		this.cstmsDeclUserId = cstmsDeclUserId;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vvdNumber
	 */
	public void setVvdNumber(String vvdNumber) {
		this.vvdNumber = vvdNumber;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	 
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
		//this.skdDirCd=true;
	}
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
		//this.skdVoyNo=true;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDemFreeDt(JSPUtil.getParameter(request, "dem_free_dt", ""));
		setCrnNumber(JSPUtil.getParameter(request, "vsl_call_ref_no", ""));
		setFCrnNumber(JSPUtil.getParameter(request, "frm_crn_number", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBrthCtnt(JSPUtil.getParameter(request, "brth_ctnt", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setNtfyLtrCtnt(JSPUtil.getParameter(request, "ntfy_ltr_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCstmsDeclUserId(JSPUtil.getParameter(request, "cstms_decl_user_id", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setVvdNumber(JSPUtil.getParameter(request, "vvd_number", ""));
		setuserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));		 
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocscrnVO[]
	 */
	public RocscrnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocscrnVO[]
	 */
	public RocscrnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocscrnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] demFreeDt = (JSPUtil.getParameter(request, prefix	+ "dem_free_dt".trim(), length));
			String[] crnNumber = (JSPUtil.getParameter(request, prefix	+ "vsl_call_ref_no".trim(), length));
			String[] fcrnNumber = (JSPUtil.getParameter(request, prefix	+ "frm_crn_number".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] brthCtnt = (JSPUtil.getParameter(request, prefix	+ "brth_ctnt".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] ntfyLtrCtnt = (JSPUtil.getParameter(request, prefix	+ "ntfy_ltr_ctnt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] cstmsDeclUserId = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_user_id".trim(), length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt".trim(), length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt".trim(), length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number".trim(), length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));			
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));			 
			
			for (int i = 0; i < length; i++) {
				model = new RocscrnVO();
				if (demFreeDt[i] != null)
					model.setDemFreeDt(demFreeDt[i]);
				if (crnNumber[i] != null)
					model.setCrnNumber(crnNumber[i]);
				if (fcrnNumber[i] != null)
					model.setFCrnNumber(fcrnNumber[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (brthCtnt[i] != null)
					model.setBrthCtnt(brthCtnt[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (ntfyLtrCtnt[i] != null)
					model.setNtfyLtrCtnt(ntfyLtrCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cstmsDeclUserId[i] != null)
					model.setCstmsDeclUserId(cstmsDeclUserId[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtaDt(vpsEtdDt[i]);
				if (vvdNumber[i] != null)
					model.setVvdNumber(vvdNumber[i]);
				if (userOfcCd[i] != null)
					model.setuserOfcCd(userOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);				 	
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);				 
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocscrnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocscrnVO[]
	 */
	public RocscrnVO[] getRocscrnVOs(){
		RocscrnVO[] vos = (RocscrnVO[])models.toArray(new RocscrnVO[models.size()]);
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
		this.demFreeDt = this.demFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnNumber = this.crnNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcrnNumber = this.fcrnNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthCtnt = this.brthCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyLtrCtnt = this.ntfyLtrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclUserId = this.cstmsDeclUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNumber = this.vvdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");				
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
