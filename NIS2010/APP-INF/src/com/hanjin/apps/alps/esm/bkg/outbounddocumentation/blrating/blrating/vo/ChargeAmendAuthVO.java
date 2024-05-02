/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmendAuthVO.java
*@FileTitle : ChargeAmendAuthVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.21
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2015.01.21 김진주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김진주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeAmendAuthVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeAmendAuthVO> models = new ArrayList<ChargeAmendAuthVO>();
	
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String chgAmdRmk = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String authUseFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chgAmdRsnCd = null;
	/* Column Info */
	private String chgAmdSeq = null;
	/* Column Info */
	private String chgAmdRqstStsCd = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChargeAmendAuthVO() {}

	public ChargeAmendAuthVO(String ibflag, String pagerows, String bkgNo, String chgAmdSeq, String chgAmdRsnCd, String chgAmdRqstStsCd, String rqstOfcCd, String rqstUsrId, String rqstDt, String aproOfcCd, String aproDt, String authUseFlg, String chgAmdRmk, String creUsrId, String updUsrId) {
		this.rqstDt = rqstDt;
		this.rqstUsrId = rqstUsrId;
		this.aproOfcCd = aproOfcCd;
		this.chgAmdRmk = chgAmdRmk;
		this.aproDt = aproDt;
		this.authUseFlg = authUseFlg;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.chgAmdRsnCd = chgAmdRsnCd;
		this.chgAmdSeq = chgAmdSeq;
		this.chgAmdRqstStsCd = chgAmdRqstStsCd;
		this.rqstOfcCd = rqstOfcCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("chg_amd_rmk", getChgAmdRmk());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("auth_use_flg", getAuthUseFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chg_amd_rsn_cd", getChgAmdRsnCd());
		this.hashColumns.put("chg_amd_seq", getChgAmdSeq());
		this.hashColumns.put("chg_amd_rqst_sts_cd", getChgAmdRqstStsCd());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("chg_amd_rmk", "chgAmdRmk");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("auth_use_flg", "authUseFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chg_amd_rsn_cd", "chgAmdRsnCd");
		this.hashFields.put("chg_amd_seq", "chgAmdSeq");
		this.hashFields.put("chg_amd_rqst_sts_cd", "chgAmdRqstStsCd");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmdRmk
	 */
	public String getChgAmdRmk() {
		return this.chgAmdRmk;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return authUseFlg
	 */
	public String getAuthUseFlg() {
		return this.authUseFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return chgAmdRsnCd
	 */
	public String getChgAmdRsnCd() {
		return this.chgAmdRsnCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmdSeq
	 */
	public String getChgAmdSeq() {
		return this.chgAmdSeq;
	}
	
	/**
	 * Column Info
	 * @return chgAmdRqstStsCd
	 */
	public String getChgAmdRqstStsCd() {
		return this.chgAmdRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmdRmk
	 */
	public void setChgAmdRmk(String chgAmdRmk) {
		this.chgAmdRmk = chgAmdRmk;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param authUseFlg
	 */
	public void setAuthUseFlg(String authUseFlg) {
		this.authUseFlg = authUseFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param chgAmdRsnCd
	 */
	public void setChgAmdRsnCd(String chgAmdRsnCd) {
		this.chgAmdRsnCd = chgAmdRsnCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmdSeq
	 */
	public void setChgAmdSeq(String chgAmdSeq) {
		this.chgAmdSeq = chgAmdSeq;
	}
	
	/**
	 * Column Info
	 * @param chgAmdRqstStsCd
	 */
	public void setChgAmdRqstStsCd(String chgAmdRqstStsCd) {
		this.chgAmdRqstStsCd = chgAmdRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setChgAmdRmk(JSPUtil.getParameter(request, prefix + "chg_amd_rmk", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setAuthUseFlg(JSPUtil.getParameter(request, prefix + "auth_use_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChgAmdRsnCd(JSPUtil.getParameter(request, prefix + "chg_amd_rsn_cd", ""));
		setChgAmdSeq(JSPUtil.getParameter(request, prefix + "chg_amd_seq", ""));
		setChgAmdRqstStsCd(JSPUtil.getParameter(request, prefix + "chg_amd_rqst_sts_cd", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeAmendAuthVO[]
	 */
	public ChargeAmendAuthVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeAmendAuthVO[]
	 */
	public ChargeAmendAuthVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeAmendAuthVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] chgAmdRmk = (JSPUtil.getParameter(request, prefix	+ "chg_amd_rmk", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] authUseFlg = (JSPUtil.getParameter(request, prefix	+ "auth_use_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chgAmdRsnCd = (JSPUtil.getParameter(request, prefix	+ "chg_amd_rsn_cd", length));
			String[] chgAmdSeq = (JSPUtil.getParameter(request, prefix	+ "chg_amd_seq", length));
			String[] chgAmdRqstStsCd = (JSPUtil.getParameter(request, prefix	+ "chg_amd_rqst_sts_cd", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeAmendAuthVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (chgAmdRmk[i] != null)
					model.setChgAmdRmk(chgAmdRmk[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (authUseFlg[i] != null)
					model.setAuthUseFlg(authUseFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chgAmdRsnCd[i] != null)
					model.setChgAmdRsnCd(chgAmdRsnCd[i]);
				if (chgAmdSeq[i] != null)
					model.setChgAmdSeq(chgAmdSeq[i]);
				if (chgAmdRqstStsCd[i] != null)
					model.setChgAmdRqstStsCd(chgAmdRqstStsCd[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeAmendAuthVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeAmendAuthVO[]
	 */
	public ChargeAmendAuthVO[] getChargeAmendAuthVOs(){
		ChargeAmendAuthVO[] vos = (ChargeAmendAuthVO[])models.toArray(new ChargeAmendAuthVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdRmk = this.chgAmdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authUseFlg = this.authUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdRsnCd = this.chgAmdRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdSeq = this.chgAmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdRqstStsCd = this.chgAmdRqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
