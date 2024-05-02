/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MnrMovementEmailSendHistoryVO.java
*@FileTitle : MnrMovementEmailSendHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2016.04.21 홍성필 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo;

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
 * @author 홍성필  
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MnrMovementEmailSendHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MnrMovementEmailSendHistoryVO> models = new ArrayList<MnrMovementEmailSendHistoryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cnmvEvntEndDt = null;
	/* Column Info */
	private String emlSndAddr = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cnmvEvntStDt = null;
	/* Column Info */
	private String today = null;
	/* Column Info */
	private String jbId = null;
	/* Column Info */
	private String cntrTpszCdCtnt = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String emlSndFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mvmtStsCdCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNoCtnt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MnrMovementEmailSendHistoryVO() {}

	public MnrMovementEmailSendHistoryVO(String ibflag, String pagerows, String jbId, String cnmvEvntStDt, String cnmvEvntEndDt, String mvmtStsCdCtnt, String orgYdCd, String cntrNoCtnt, String cntrTpszCdCtnt, String emlSndFlg, String emlSndDt, String emlSndAddr, String creUsrId, String creDt, String updUsrId, String updDt, String today) {
		this.updDt = updDt;
		this.cnmvEvntEndDt = cnmvEvntEndDt;
		this.emlSndAddr = emlSndAddr;
		this.emlSndDt = emlSndDt;
		this.creDt = creDt;
		this.cnmvEvntStDt = cnmvEvntStDt;
		this.today = today;
		this.jbId = jbId;
		this.cntrTpszCdCtnt = cntrTpszCdCtnt;
		this.orgYdCd = orgYdCd;
		this.emlSndFlg = emlSndFlg;
		this.pagerows = pagerows;
		this.mvmtStsCdCtnt = mvmtStsCdCtnt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntrNoCtnt = cntrNoCtnt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cnmv_evnt_end_dt", getCnmvEvntEndDt());
		this.hashColumns.put("eml_snd_addr", getEmlSndAddr());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cnmv_evnt_st_dt", getCnmvEvntStDt());
		this.hashColumns.put("today", getToday());
		this.hashColumns.put("jb_id", getJbId());
		this.hashColumns.put("cntr_tpsz_cd_ctnt", getCntrTpszCdCtnt());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("eml_snd_flg", getEmlSndFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mvmt_sts_cd_ctnt", getMvmtStsCdCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no_ctnt", getCntrNoCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cnmv_evnt_end_dt", "cnmvEvntEndDt");
		this.hashFields.put("eml_snd_addr", "emlSndAddr");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cnmv_evnt_st_dt", "cnmvEvntStDt");
		this.hashFields.put("today", "today");
		this.hashFields.put("jb_id", "jbId");
		this.hashFields.put("cntr_tpsz_cd_ctnt", "cntrTpszCdCtnt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("eml_snd_flg", "emlSndFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mvmt_sts_cd_ctnt", "mvmtStsCdCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no_ctnt", "cntrNoCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return cnmvEvntEndDt
	 */
	public String getCnmvEvntEndDt() {
		return this.cnmvEvntEndDt;
	}
	
	/**
	 * Column Info
	 * @return emlSndAddr
	 */
	public String getEmlSndAddr() {
		return this.emlSndAddr;
	}
	
	/**
	 * Column Info
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
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
	 * @return cnmvEvntStDt
	 */
	public String getCnmvEvntStDt() {
		return this.cnmvEvntStDt;
	}
	
	/**
	 * Column Info
	 * @return today
	 */
	public String getToday() {
		return this.today;
	}
	
	/**
	 * Column Info
	 * @return jbId
	 */
	public String getJbId() {
		return this.jbId;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCdCtnt
	 */
	public String getCntrTpszCdCtnt() {
		return this.cntrTpszCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg
	 */
	public String getEmlSndFlg() {
		return this.emlSndFlg;
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
	 * @return mvmtStsCdCtnt
	 */
	public String getMvmtStsCdCtnt() {
		return this.mvmtStsCdCtnt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntrNoCtnt
	 */
	public String getCntrNoCtnt() {
		return this.cntrNoCtnt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvEvntEndDt
	 */
	public void setCnmvEvntEndDt(String cnmvEvntEndDt) {
		this.cnmvEvntEndDt = cnmvEvntEndDt;
	}
	
	/**
	 * Column Info
	 * @param emlSndAddr
	 */
	public void setEmlSndAddr(String emlSndAddr) {
		this.emlSndAddr = emlSndAddr;
	}
	
	/**
	 * Column Info
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
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
	 * @param cnmvEvntStDt
	 */
	public void setCnmvEvntStDt(String cnmvEvntStDt) {
		this.cnmvEvntStDt = cnmvEvntStDt;
	}
	
	/**
	 * Column Info
	 * @param today
	 */
	public void setToday(String today) {
		this.today = today;
	}
	
	/**
	 * Column Info
	 * @param jbId
	 */
	public void setJbId(String jbId) {
		this.jbId = jbId;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCdCtnt
	 */
	public void setCntrTpszCdCtnt(String cntrTpszCdCtnt) {
		this.cntrTpszCdCtnt = cntrTpszCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg
	 */
	public void setEmlSndFlg(String emlSndFlg) {
		this.emlSndFlg = emlSndFlg;
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
	 * @param mvmtStsCdCtnt
	 */
	public void setMvmtStsCdCtnt(String mvmtStsCdCtnt) {
		this.mvmtStsCdCtnt = mvmtStsCdCtnt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntrNoCtnt
	 */
	public void setCntrNoCtnt(String cntrNoCtnt) {
		this.cntrNoCtnt = cntrNoCtnt;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCnmvEvntEndDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_end_dt", ""));
		setEmlSndAddr(JSPUtil.getParameter(request, prefix + "eml_snd_addr", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCnmvEvntStDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_st_dt", ""));
		setToday(JSPUtil.getParameter(request, prefix + "today", ""));
		setJbId(JSPUtil.getParameter(request, prefix + "jb_id", ""));
		setCntrTpszCdCtnt(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd_ctnt", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setEmlSndFlg(JSPUtil.getParameter(request, prefix + "eml_snd_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMvmtStsCdCtnt(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrNoCtnt(JSPUtil.getParameter(request, prefix + "cntr_no_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MnrMovementEmailSendHistoryVO[]
	 */
	public MnrMovementEmailSendHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrMovementEmailSendHistoryVO[]
	 */
	public MnrMovementEmailSendHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrMovementEmailSendHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cnmvEvntEndDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_end_dt", length));
			String[] emlSndAddr = (JSPUtil.getParameter(request, prefix	+ "eml_snd_addr", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cnmvEvntStDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_st_dt", length));
			String[] today = (JSPUtil.getParameter(request, prefix	+ "today", length));
			String[] jbId = (JSPUtil.getParameter(request, prefix	+ "jb_id", length));
			String[] cntrTpszCdCtnt = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd_ctnt", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] emlSndFlg = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mvmtStsCdCtnt = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNoCtnt = (JSPUtil.getParameter(request, prefix	+ "cntr_no_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrMovementEmailSendHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cnmvEvntEndDt[i] != null)
					model.setCnmvEvntEndDt(cnmvEvntEndDt[i]);
				if (emlSndAddr[i] != null)
					model.setEmlSndAddr(emlSndAddr[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cnmvEvntStDt[i] != null)
					model.setCnmvEvntStDt(cnmvEvntStDt[i]);
				if (today[i] != null)
					model.setToday(today[i]);
				if (jbId[i] != null)
					model.setJbId(jbId[i]);
				if (cntrTpszCdCtnt[i] != null)
					model.setCntrTpszCdCtnt(cntrTpszCdCtnt[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (emlSndFlg[i] != null)
					model.setEmlSndFlg(emlSndFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mvmtStsCdCtnt[i] != null)
					model.setMvmtStsCdCtnt(mvmtStsCdCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNoCtnt[i] != null)
					model.setCntrNoCtnt(cntrNoCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrMovementEmailSendHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MnrMovementEmailSendHistoryVO[]
	 */
	public MnrMovementEmailSendHistoryVO[] getMnrMovementEmailSendHistoryVOs(){
		MnrMovementEmailSendHistoryVO[] vos = (MnrMovementEmailSendHistoryVO[])models.toArray(new MnrMovementEmailSendHistoryVO[models.size()]);
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
		this.cnmvEvntEndDt = this.cnmvEvntEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndAddr = this.emlSndAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntStDt = this.cnmvEvntStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.today = this.today .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbId = this.jbId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdCtnt = this.cntrTpszCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg = this.emlSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCdCtnt = this.mvmtStsCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoCtnt = this.cntrNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
