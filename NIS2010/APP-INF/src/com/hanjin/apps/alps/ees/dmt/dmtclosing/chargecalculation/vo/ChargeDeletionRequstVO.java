/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChargeDeletionRequstVO.java
*@FileTitle : ChargeDeletionRequstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.18
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.07.18 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeDeletionRequstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeDeletionRequstVO> models = new ArrayList<ChargeDeletionRequstVO>();
	
	/* Column Info */
	private String dmtOfcCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String chgDeltProcSts = null;
	/* Column Info */
	private String chgDeltUsrId = null;
	/* Column Info */
	private String chgDeltPathCd = null;
	/* Column Info */
	private String vvdCd = null;
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeDeletionRequstVO() {}

	public ChargeDeletionRequstVO(String ibflag, String pagerows, String dmtOfcCd, String fmDt, String toDt, String bkgNo, String aproOfcCd, String dmdtTrfCd, String chgDeltProcSts, String chgDeltUsrId, String chgDeltPathCd, String vvdCd) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.dmtOfcCd = dmtOfcCd;
		this.fmDt = fmDt;
		this.toDt = toDt;
		this.bkgNo = bkgNo;
		this.aproOfcCd = aproOfcCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.chgDeltProcSts = chgDeltProcSts;
		this.chgDeltUsrId = chgDeltUsrId;
		this.chgDeltPathCd = chgDeltPathCd;
		this.vvdCd = vvdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmt_ofc_cd", getDmtOfcCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("chg_delt_proc_sts", getChgDeltProcSts());
		this.hashColumns.put("chg_delt_usr_id", getChgDeltUsrId());
		this.hashColumns.put("chg_delt_path_cd", getChgDeltPathCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");		
		this.hashFields.put("dmt_ofc_cd", "dmtOfcCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("chg_delt_proc_sts", "chgDeltProcSts");
		this.hashFields.put("chg_delt_usr_id", "chgDeltUsrId");
		this.hashFields.put("chg_delt_path_cd", "chgDeltPathCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		
		return this.hashFields;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return dmtOfcCd
	 */
	public String getDmtOfcCd() {
		return this.dmtOfcCd;
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
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return chgDeltProcSts
	 */
	public String getChgDeltProcSts() {
		return chgDeltProcSts;
	}	

	/**
	 * Column Info
	 * @return chgDeltUsrId
	 */
	public String getChgDeltUsrId() {
		return chgDeltUsrId;
	}
	
	/**
	 * Column Info
	 * @return chgDeltPathCd
	 */
	public String getChgDeltPathCd() {
		return chgDeltPathCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return vvdCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param dmtOfcCd
	 */
	public void setDmtOfcCd(String dmtOfcCd) {
		this.dmtOfcCd = dmtOfcCd;
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
	 * @return aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return chgDeltProcSts
	 */
	public void setChgDeltProcSts(String chgDeltProcSts) {
		this.chgDeltProcSts = chgDeltProcSts;
	}
	
	/**
	 * Column Info
	 * @return chgDeltUsrId
	 */
	public void setChgDeltUsrId(String chgDeltUsrId) {
		this.chgDeltUsrId = chgDeltUsrId;
	}	
	
	/**
	 * Column Info
	 * @return chgDeltPathCd
	 */
	public void setChgDeltPathCd(String chgDeltPathCd) {
		this.chgDeltPathCd = chgDeltPathCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));		
		setDmtOfcCd(JSPUtil.getParameter(request, prefix + "dmt_ofc_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setAproOfcCd(JSPUtil.getParameter(request, "apro_ofc_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setChgDeltProcSts(JSPUtil.getParameter(request, prefix + "chg_delt_proc_sts", ""));
		setChgDeltUsrId(JSPUtil.getParameter(request, prefix + "chg_delt_usr_id", ""));
		setChgDeltPathCd(JSPUtil.getParameter(request, prefix + "chg_delt_path_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeDeletionRequstVO[]
	 */
	public ChargeDeletionRequstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeDeletionRequstVO[]
	 */
	public ChargeDeletionRequstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeDeletionRequstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "dmt_ofc_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] chgDeltProcSts = (JSPUtil.getParameter(request, prefix	+ "chg_delt_proc_sts", length));
			String[] chgDeltUsrId = (JSPUtil.getParameter(request, prefix	+ "chg_delt_usr_id", length));
			String[] chgDeltPathCd = (JSPUtil.getParameter(request, prefix	+ "chg_delt_path_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeDeletionRequstVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);				
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (dmtOfcCd[i] != null)
					model.setDmtOfcCd(dmtOfcCd[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (chgDeltProcSts[i] != null)
					model.setChgDeltProcSts(chgDeltProcSts[i]);
				if (chgDeltUsrId[i] != null)
					model.setChgDeltUsrId(chgDeltUsrId[i]);
				if (chgDeltPathCd[i] != null)
					model.setChgDeltPathCd(chgDeltPathCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeDeletionRequstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeDeletionRequstVO[]
	 */
	public ChargeDeletionRequstVO[] getChargeDeletionRequstVOs(){
		ChargeDeletionRequstVO[] vos = (ChargeDeletionRequstVO[])models.toArray(new ChargeDeletionRequstVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtOfcCd = this.dmtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltProcSts = this.chgDeltProcSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltUsrId = this.chgDeltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltPathCd = this.chgDeltPathCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
