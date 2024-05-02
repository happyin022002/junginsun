/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FcmEstmWkCsmIfVO.java
*@FileTitle : FcmEstmWkCsmIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.22 진마리아 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/*
SELECT
 '' BSE_YRMON
,'' BSE_WK
,'' VSL_CD
,'' SKD_VOY_NO
,'' SKD_DIR_CD
,'' FCM_ESTM_WRK_DT
,'' FCM_ESTM_WRK_SEQ
,'' TRD_CD
,'' SUB_TRD_CD
,'' FOIL_ESTM_CSM_WGT
,'' DOIL_ESTM_CSM_WGT
,'' CRE_USR_ID
,'' CRE_DT
,'' UPD_USR_ID
,'' UPD_DT
FROM DUAL
*/

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmEstmWkCsmIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmEstmWkCsmIfVO> models = new ArrayList<FcmEstmWkCsmIfVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doilEstmCsmWgt = null;
	/* Column Info */
	private String bseYrmon = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcmEstmWrkSeq = null;
	/* Column Info */
	private String fcmEstmWrkDt = null;
	/* Column Info */
	private String foilEstmCsmWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmEstmWkCsmIfVO() {}

	public FcmEstmWkCsmIfVO(String ibflag, String pagerows, String bseYrmon, String bseWk, String vslCd, String skdVoyNo, String skdDirCd, String fcmEstmWrkDt, String fcmEstmWrkSeq, String trdCd, String subTrdCd, String foilEstmCsmWgt, String doilEstmCsmWgt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.trdCd = trdCd;
		this.bseWk = bseWk;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.doilEstmCsmWgt = doilEstmCsmWgt;
		this.bseYrmon = bseYrmon;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.fcmEstmWrkSeq = fcmEstmWrkSeq;
		this.fcmEstmWrkDt = fcmEstmWrkDt;
		this.foilEstmCsmWgt = foilEstmCsmWgt;
		this.updUsrId = updUsrId;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("doil_estm_csm_wgt", getDoilEstmCsmWgt());
		this.hashColumns.put("bse_yrmon", getBseYrmon());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcm_estm_wrk_seq", getFcmEstmWrkSeq());
		this.hashColumns.put("fcm_estm_wrk_dt", getFcmEstmWrkDt());
		this.hashColumns.put("foil_estm_csm_wgt", getFoilEstmCsmWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("doil_estm_csm_wgt", "doilEstmCsmWgt");
		this.hashFields.put("bse_yrmon", "bseYrmon");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcm_estm_wrk_seq", "fcmEstmWrkSeq");
		this.hashFields.put("fcm_estm_wrk_dt", "fcmEstmWrkDt");
		this.hashFields.put("foil_estm_csm_wgt", "foilEstmCsmWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
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
	 * @return doilEstmCsmWgt
	 */
	public String getDoilEstmCsmWgt() {
		return this.doilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return bseYrmon
	 */
	public String getBseYrmon() {
		return this.bseYrmon;
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
	 * @return fcmEstmWrkSeq
	 */
	public String getFcmEstmWrkSeq() {
		return this.fcmEstmWrkSeq;
	}
	
	/**
	 * Column Info
	 * @return fcmEstmWrkDt
	 */
	public String getFcmEstmWrkDt() {
		return this.fcmEstmWrkDt;
	}
	
	/**
	 * Column Info
	 * @return foilEstmCsmWgt
	 */
	public String getFoilEstmCsmWgt() {
		return this.foilEstmCsmWgt;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
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
	 * @param doilEstmCsmWgt
	 */
	public void setDoilEstmCsmWgt(String doilEstmCsmWgt) {
		this.doilEstmCsmWgt = doilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param bseYrmon
	 */
	public void setBseYrmon(String bseYrmon) {
		this.bseYrmon = bseYrmon;
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
	 * @param fcmEstmWrkSeq
	 */
	public void setFcmEstmWrkSeq(String fcmEstmWrkSeq) {
		this.fcmEstmWrkSeq = fcmEstmWrkSeq;
	}
	
	/**
	 * Column Info
	 * @param fcmEstmWrkDt
	 */
	public void setFcmEstmWrkDt(String fcmEstmWrkDt) {
		this.fcmEstmWrkDt = fcmEstmWrkDt;
	}
	
	/**
	 * Column Info
	 * @param foilEstmCsmWgt
	 */
	public void setFoilEstmCsmWgt(String foilEstmCsmWgt) {
		this.foilEstmCsmWgt = foilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDoilEstmCsmWgt(JSPUtil.getParameter(request, prefix + "doil_estm_csm_wgt", ""));
		setBseYrmon(JSPUtil.getParameter(request, prefix + "bse_yrmon", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcmEstmWrkSeq(JSPUtil.getParameter(request, prefix + "fcm_estm_wrk_seq", ""));
		setFcmEstmWrkDt(JSPUtil.getParameter(request, prefix + "fcm_estm_wrk_dt", ""));
		setFoilEstmCsmWgt(JSPUtil.getParameter(request, prefix + "foil_estm_csm_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmEstmWkCsmIfVO[]
	 */
	public FcmEstmWkCsmIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmEstmWkCsmIfVO[]
	 */
	public FcmEstmWkCsmIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmEstmWkCsmIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doilEstmCsmWgt = (JSPUtil.getParameter(request, prefix	+ "doil_estm_csm_wgt", length));
			String[] bseYrmon = (JSPUtil.getParameter(request, prefix	+ "bse_yrmon", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcmEstmWrkSeq = (JSPUtil.getParameter(request, prefix	+ "fcm_estm_wrk_seq", length));
			String[] fcmEstmWrkDt = (JSPUtil.getParameter(request, prefix	+ "fcm_estm_wrk_dt", length));
			String[] foilEstmCsmWgt = (JSPUtil.getParameter(request, prefix	+ "foil_estm_csm_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmEstmWkCsmIfVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doilEstmCsmWgt[i] != null)
					model.setDoilEstmCsmWgt(doilEstmCsmWgt[i]);
				if (bseYrmon[i] != null)
					model.setBseYrmon(bseYrmon[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcmEstmWrkSeq[i] != null)
					model.setFcmEstmWrkSeq(fcmEstmWrkSeq[i]);
				if (fcmEstmWrkDt[i] != null)
					model.setFcmEstmWrkDt(fcmEstmWrkDt[i]);
				if (foilEstmCsmWgt[i] != null)
					model.setFoilEstmCsmWgt(foilEstmCsmWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmEstmWkCsmIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmEstmWkCsmIfVO[]
	 */
	public FcmEstmWkCsmIfVO[] getFcmEstmWkCsmIfVOs(){
		FcmEstmWkCsmIfVO[] vos = (FcmEstmWkCsmIfVO[])models.toArray(new FcmEstmWkCsmIfVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilEstmCsmWgt = this.doilEstmCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrmon = this.bseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcmEstmWrkSeq = this.fcmEstmWrkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcmEstmWrkDt = this.fcmEstmWrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilEstmCsmWgt = this.foilEstmCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
