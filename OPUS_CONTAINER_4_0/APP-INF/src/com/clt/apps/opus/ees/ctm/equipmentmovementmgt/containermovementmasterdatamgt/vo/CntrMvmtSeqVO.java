/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CntrMvmtSeqVO.java
*@FileTitle : CntrMvmtSeqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrMvmtSeqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrMvmtSeqVO> models = new ArrayList<CntrMvmtSeqVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvEndPsnFlg = null;
	/* Column Info */
	private String cnmvLvlNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cnmvStPsnFlg = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrMvmtSeqVO() {}

	public CntrMvmtSeqVO(String ibflag, String pagerows, String bkgCgoTpCd, String mvmtStsCd, String cnmvLvlNo, String cnmvStPsnFlg, String cnmvEndPsnFlg, String fcntrFlg, String updUsrId, String updDt, String creUsrId, String creDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.mvmtStsCd = mvmtStsCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.ibflag = ibflag;
		this.cnmvEndPsnFlg = cnmvEndPsnFlg;
		this.cnmvLvlNo = cnmvLvlNo;
		this.creDt = creDt;
		this.cnmvStPsnFlg = cnmvStPsnFlg;
		this.fcntrFlg = fcntrFlg;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_end_psn_flg", getCnmvEndPsnFlg());
		this.hashColumns.put("cnmv_lvl_no", getCnmvLvlNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cnmv_st_psn_flg", getCnmvStPsnFlg());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_end_psn_flg", "cnmvEndPsnFlg");
		this.hashFields.put("cnmv_lvl_no", "cnmvLvlNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cnmv_st_psn_flg", "cnmvStPsnFlg");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
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
	 * @return cnmvEndPsnFlg
	 */
	public String getCnmvEndPsnFlg() {
		return this.cnmvEndPsnFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvLvlNo
	 */
	public String getCnmvLvlNo() {
		return this.cnmvLvlNo;
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
	 * @return cnmvStPsnFlg
	 */
	public String getCnmvStPsnFlg() {
		return this.cnmvStPsnFlg;
	}
	
	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param cnmvEndPsnFlg
	 */
	public void setCnmvEndPsnFlg(String cnmvEndPsnFlg) {
		this.cnmvEndPsnFlg = cnmvEndPsnFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvLvlNo
	 */
	public void setCnmvLvlNo(String cnmvLvlNo) {
		this.cnmvLvlNo = cnmvLvlNo;
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
	 * @param cnmvStPsnFlg
	 */
	public void setCnmvStPsnFlg(String cnmvStPsnFlg) {
		this.cnmvStPsnFlg = cnmvStPsnFlg;
	}
	
	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnmvEndPsnFlg(JSPUtil.getParameter(request, prefix + "cnmv_end_psn_flg", ""));
		setCnmvLvlNo(JSPUtil.getParameter(request, prefix + "cnmv_lvl_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCnmvStPsnFlg(JSPUtil.getParameter(request, prefix + "cnmv_st_psn_flg", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrMvmtSeqVO[]
	 */
	public CntrMvmtSeqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrMvmtSeqVO[]
	 */
	public CntrMvmtSeqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrMvmtSeqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvEndPsnFlg = (JSPUtil.getParameter(request, prefix	+ "cnmv_end_psn_flg", length));
			String[] cnmvLvlNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_lvl_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cnmvStPsnFlg = (JSPUtil.getParameter(request, prefix	+ "cnmv_st_psn_flg", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrMvmtSeqVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvEndPsnFlg[i] != null)
					model.setCnmvEndPsnFlg(cnmvEndPsnFlg[i]);
				if (cnmvLvlNo[i] != null)
					model.setCnmvLvlNo(cnmvLvlNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cnmvStPsnFlg[i] != null)
					model.setCnmvStPsnFlg(cnmvStPsnFlg[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrMvmtSeqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrMvmtSeqVO[]
	 */
	public CntrMvmtSeqVO[] getCntrMvmtSeqVOs(){
		CntrMvmtSeqVO[] vos = (CntrMvmtSeqVO[])models.toArray(new CntrMvmtSeqVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEndPsnFlg = this.cnmvEndPsnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvLvlNo = this.cnmvLvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStPsnFlg = this.cnmvStPsnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
