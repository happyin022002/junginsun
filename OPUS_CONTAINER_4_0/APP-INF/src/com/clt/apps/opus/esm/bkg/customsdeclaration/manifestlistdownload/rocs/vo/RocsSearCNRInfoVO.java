/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsSearCNRInfoVO.java
*@FileTitle : RocsSearCNRInfoVO
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

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsSearCNRInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearCNRInfoVO> models = new ArrayList<RocsSearCNRInfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String demFreeDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsDeclUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String brthCtnt = null;
	/* Column Info */
	private String ntfyLtrCtnt = null;
	/* Column Info */
	private String vvdNumber = null;
	/* Column Info */
	private String vslCallRefNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsSearCNRInfoVO() {}

	public RocsSearCNRInfoVO(String ibflag, String pagerows, String vslCallRefNo, String vslCd, String skdVoyNo, String skdDirCd, String vslEngNm, String demFreeDt, String brthCtnt, String ntfyLtrCtnt, String cstmsDeclUsrId, String creDt, String vpsEtaDt, String vvdNumber) {
		this.vslCd = vslCd;
		this.demFreeDt = demFreeDt;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.vpsEtaDt = vpsEtaDt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.cstmsDeclUsrId = cstmsDeclUsrId;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.brthCtnt = brthCtnt;
		this.ntfyLtrCtnt = ntfyLtrCtnt;
		this.vvdNumber = vvdNumber;
		this.vslCallRefNo = vslCallRefNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dem_free_dt", getDemFreeDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_decl_usr_id", getCstmsDeclUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("brth_ctnt", getBrthCtnt());
		this.hashColumns.put("ntfy_ltr_ctnt", getNtfyLtrCtnt());
		this.hashColumns.put("vvd_number", getVvdNumber());
		this.hashColumns.put("vsl_call_ref_no", getVslCallRefNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dem_free_dt", "demFreeDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_decl_usr_id", "cstmsDeclUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("brth_ctnt", "brthCtnt");
		this.hashFields.put("ntfy_ltr_ctnt", "ntfyLtrCtnt");
		this.hashFields.put("vvd_number", "vvdNumber");
		this.hashFields.put("vsl_call_ref_no", "vslCallRefNo");
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
	 * @return demFreeDt
	 */
	public String getDemFreeDt() {
		return this.demFreeDt;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return cstmsDeclUsrId
	 */
	public String getCstmsDeclUsrId() {
		return this.cstmsDeclUsrId;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
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
	 * @return ntfyLtrCtnt
	 */
	public String getNtfyLtrCtnt() {
		return this.ntfyLtrCtnt;
	}
	
	/**
	 * Column Info
	 * @return vvdNumber
	 */
	public String getVvdNumber() {
		return this.vvdNumber;
	}
	
	/**
	 * Column Info
	 * @return vslCallRefNo
	 */
	public String getVslCallRefNo() {
		return this.vslCallRefNo;
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
	 * @param demFreeDt
	 */
	public void setDemFreeDt(String demFreeDt) {
		this.demFreeDt = demFreeDt;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param cstmsDeclUsrId
	 */
	public void setCstmsDeclUsrId(String cstmsDeclUsrId) {
		this.cstmsDeclUsrId = cstmsDeclUsrId;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
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
	 * @param ntfyLtrCtnt
	 */
	public void setNtfyLtrCtnt(String ntfyLtrCtnt) {
		this.ntfyLtrCtnt = ntfyLtrCtnt;
	}
	
	/**
	 * Column Info
	 * @param vvdNumber
	 */
	public void setVvdNumber(String vvdNumber) {
		this.vvdNumber = vvdNumber;
	}
	
	/**
	 * Column Info
	 * @param vslCallRefNo
	 */
	public void setVslCallRefNo(String vslCallRefNo) {
		this.vslCallRefNo = vslCallRefNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setDemFreeDt(JSPUtil.getParameter(request, "dem_free_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCstmsDeclUsrId(JSPUtil.getParameter(request, "cstms_decl_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setBrthCtnt(JSPUtil.getParameter(request, "brth_ctnt", ""));
		setNtfyLtrCtnt(JSPUtil.getParameter(request, "ntfy_ltr_ctnt", ""));
		setVvdNumber(JSPUtil.getParameter(request, "vvd_number", ""));
		setVslCallRefNo(JSPUtil.getParameter(request, "vsl_call_ref_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearCNRInfoVO[]
	 */
	public RocsSearCNRInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearCNRInfoVO[]
	 */
	public RocsSearCNRInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearCNRInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] demFreeDt = (JSPUtil.getParameter(request, prefix	+ "dem_free_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] cstmsDeclUsrId = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] brthCtnt = (JSPUtil.getParameter(request, prefix	+ "brth_ctnt".trim(), length));
			String[] ntfyLtrCtnt = (JSPUtil.getParameter(request, prefix	+ "ntfy_ltr_ctnt".trim(), length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number".trim(), length));
			String[] vslCallRefNo = (JSPUtil.getParameter(request, prefix	+ "vsl_call_ref_no".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearCNRInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (demFreeDt[i] != null)
					model.setDemFreeDt(demFreeDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsDeclUsrId[i] != null)
					model.setCstmsDeclUsrId(cstmsDeclUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (brthCtnt[i] != null)
					model.setBrthCtnt(brthCtnt[i]);
				if (ntfyLtrCtnt[i] != null)
					model.setNtfyLtrCtnt(ntfyLtrCtnt[i]);
				if (vvdNumber[i] != null)
					model.setVvdNumber(vvdNumber[i]);
				if (vslCallRefNo[i] != null)
					model.setVslCallRefNo(vslCallRefNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearCNRInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearCNRInfoVO[]
	 */
	public RocsSearCNRInfoVO[] getRocsSearCNRInfoVOs(){
		RocsSearCNRInfoVO[] vos = (RocsSearCNRInfoVO[])models.toArray(new RocsSearCNRInfoVO[models.size()]);
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
		this.demFreeDt = this.demFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclUsrId = this.cstmsDeclUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthCtnt = this.brthCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyLtrCtnt = this.ntfyLtrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNumber = this.vvdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallRefNo = this.vslCallRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
