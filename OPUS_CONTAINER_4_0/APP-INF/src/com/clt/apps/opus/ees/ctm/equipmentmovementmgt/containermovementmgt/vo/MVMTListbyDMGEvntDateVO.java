/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MVMTListbyDMGEvntDateVO.java
*@FileTitle : MVMTListbyDMGEvntDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class MVMTListbyDMGEvntDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MVMTListbyDMGEvntDateVO> models = new ArrayList<MVMTListbyDMGEvntDateVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String nextEvntDt = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dmgUnflgDt = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String cntrEvntDt = null;
	/* Column Info */
	private String dmgFlgDt = null;
	/* Column Info */
	private String dmg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MVMTListbyDMGEvntDateVO() {}

	public MVMTListbyDMGEvntDateVO(String ibflag, String pagerows, String cnmvYr, String cnmvIdNo, String orgYdCd, String cntrTpszCd, String cntrEvntDt, String mvmtCreTpCd, String mvmtStsCd, String nextEvntDt, String cntrDmgFlg, String dmgFlgDt, String dmgUnflgDt, String dmg) {
		this.pagerows = pagerows;
		this.orgYdCd = orgYdCd;
		this.ibflag = ibflag;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.nextEvntDt = nextEvntDt;
		this.mvmtStsCd = mvmtStsCd;
		this.cnmvIdNo = cnmvIdNo;
		this.cntrTpszCd = cntrTpszCd;
		this.dmgUnflgDt = dmgUnflgDt;
		this.cntrDmgFlg = cntrDmgFlg;
		this.cnmvYr = cnmvYr;
		this.cntrEvntDt = cntrEvntDt;
		this.dmgFlgDt = dmgFlgDt;
		this.dmg = dmg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("next_evnt_dt", getNextEvntDt());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("cntr_evnt_dt", getCntrEvntDt());
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());
		this.hashColumns.put("dmg", getDmg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("next_evnt_dt", "nextEvntDt");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cntr_evnt_dt", "cntrEvntDt");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg", "dmg");
		return this.hashFields;
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
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
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
	 * @return mvmtCreTpCd
	 */
	public String getMvmtCreTpCd() {
		return this.mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return nextEvntDt
	 */
	public String getNextEvntDt() {
		return this.nextEvntDt;
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
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
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
	 * @return dmgUnflgDt
	 */
	public String getDmgUnflgDt() {
		return this.dmgUnflgDt;
	}
	
	/**
	 * Column Info
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
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
	 * @return cntrEvntDt
	 */
	public String getCntrEvntDt() {
		return this.cntrEvntDt;
	}
	
	/**
	 * Column Info
	 * @return dmgFlgDt
	 */
	public String getDmgFlgDt() {
		return this.dmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @return dmg
	 */
	public String getDmg() {
		return this.dmg;
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
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
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
	 * @param mvmtCreTpCd
	 */
	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param nextEvntDt
	 */
	public void setNextEvntDt(String nextEvntDt) {
		this.nextEvntDt = nextEvntDt;
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
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
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
	 * @param dmgUnflgDt
	 */
	public void setDmgUnflgDt(String dmgUnflgDt) {
		this.dmgUnflgDt = dmgUnflgDt;
	}
	
	/**
	 * Column Info
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
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
	 * @param cntrEvntDt
	 */
	public void setCntrEvntDt(String cntrEvntDt) {
		this.cntrEvntDt = cntrEvntDt;
	}
	
	/**
	 * Column Info
	 * @param dmgFlgDt
	 */
	public void setDmgFlgDt(String dmgFlgDt) {
		this.dmgFlgDt = dmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @param dmg
	 */
	public void setDmg(String dmg) {
		this.dmg = dmg;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, prefix + "mvmt_cre_tp_cd", ""));
		setNextEvntDt(JSPUtil.getParameter(request, prefix + "next_evnt_dt", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request, prefix + "dmg_unflg_dt", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, prefix + "cntr_dmg_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setCntrEvntDt(JSPUtil.getParameter(request, prefix + "cntr_evnt_dt", ""));
		setDmgFlgDt(JSPUtil.getParameter(request, prefix + "dmg_flg_dt", ""));
		setDmg(JSPUtil.getParameter(request, prefix + "dmg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MVMTListbyDMGEvntDateVO[]
	 */
	public MVMTListbyDMGEvntDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MVMTListbyDMGEvntDateVO[]
	 */
	public MVMTListbyDMGEvntDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MVMTListbyDMGEvntDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] nextEvntDt = (JSPUtil.getParameter(request, prefix	+ "next_evnt_dt", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dmgUnflgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_unflg_dt", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] cntrEvntDt = (JSPUtil.getParameter(request, prefix	+ "cntr_evnt_dt", length));
			String[] dmgFlgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_flg_dt", length));
			String[] dmg = (JSPUtil.getParameter(request, prefix	+ "dmg", length));
			
			for (int i = 0; i < length; i++) {
				model = new MVMTListbyDMGEvntDateVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (nextEvntDt[i] != null)
					model.setNextEvntDt(nextEvntDt[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dmgUnflgDt[i] != null)
					model.setDmgUnflgDt(dmgUnflgDt[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (cntrEvntDt[i] != null)
					model.setCntrEvntDt(cntrEvntDt[i]);
				if (dmgFlgDt[i] != null)
					model.setDmgFlgDt(dmgFlgDt[i]);
				if (dmg[i] != null)
					model.setDmg(dmg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMVMTListbyDMGEvntDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MVMTListbyDMGEvntDateVO[]
	 */
	public MVMTListbyDMGEvntDateVO[] getMVMTListbyDMGEvntDateVOs(){
		MVMTListbyDMGEvntDateVO[] vos = (MVMTListbyDMGEvntDateVO[])models.toArray(new MVMTListbyDMGEvntDateVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextEvntDt = this.nextEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt = this.dmgUnflgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrEvntDt = this.cntrEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt = this.dmgFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmg = this.dmg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
