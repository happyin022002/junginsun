/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchBasicTariffMonitorVO.java
*@FileTitle : SearchBasicTariffMonitorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBasicTariffMonitorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicTariffMonitorVO> models = new ArrayList<SearchBasicTariffMonitorVO>();
	
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgDest = null;
	/* Column Info */
	private String coverage = null;
	/* Column Info */
	private String dmdtDeTermNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String exist = null;
	/* Column Info */
	private String dmdtCgoTpDesc = null;
	/* Column Info */
	private String billExem = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtCntrTpDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String trfMngUsrId = null;
	/* Page Number */
	private String trfMngUsrNm = null;
	/* Page Number */
	private String picTeam = null;
	/* Page Number */
	private String trfCfmFlg = null;
	/* Column Info */
	private String toBeYn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchBasicTariffMonitorVO() {}

	public SearchBasicTariffMonitorVO(String ibflag, String pagerows, String dmdtTrfCd, String coverage, String orgDest, String dmdtDeTermNm, String dmdtCntrTpDesc, String dmdtCgoTpDesc, String exist, String billExem, String effDt, String expDt, String trfMngUsrId, String trfMngUsrNm, String picTeam, String trfCfmFlg, String toBeYn) {
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.orgDest = orgDest;
		this.coverage = coverage;
		this.dmdtDeTermNm = dmdtDeTermNm;
		this.expDt = expDt;
		this.exist = exist;
		this.dmdtCgoTpDesc = dmdtCgoTpDesc;
		this.billExem = billExem;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtCntrTpDesc = dmdtCntrTpDesc;
		this.pagerows = pagerows;
		this.trfMngUsrId = trfMngUsrId;
		this.trfMngUsrNm = trfMngUsrNm;
		this.picTeam = picTeam;
		this.trfCfmFlg = trfCfmFlg;
		this.toBeYn = toBeYn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_dest", getOrgDest());
		this.hashColumns.put("coverage", getCoverage());
		this.hashColumns.put("dmdt_de_term_nm", getDmdtDeTermNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("exist", getExist());
		this.hashColumns.put("dmdt_cgo_tp_desc", getDmdtCgoTpDesc());
		this.hashColumns.put("bill_exem", getBillExem());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_cntr_tp_desc", getDmdtCntrTpDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trf_mng_usr_id", getTrfMngUsrId());
		this.hashColumns.put("trf_mng_usr_nm", getTrfMngUsrNm());
		this.hashColumns.put("pic_team", getPicTeam());
		this.hashColumns.put("trf_cfm_flg", getTrfCfmFlg());
		this.hashColumns.put("to_be_yn", getToBeYn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_dest", "orgDest");
		this.hashFields.put("coverage", "coverage");
		this.hashFields.put("dmdt_de_term_nm", "dmdtDeTermNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("exist", "exist");
		this.hashFields.put("dmdt_cgo_tp_desc", "dmdtCgoTpDesc");
		this.hashFields.put("bill_exem", "billExem");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_cntr_tp_desc", "dmdtCntrTpDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trf_mng_usr_id", "trfMngUsrId");
		this.hashFields.put("trf_mng_usr_nm", "trfMngUsrNm");
		this.hashFields.put("pic_team", "picTeam");
		this.hashFields.put("trf_cfm_flg", "trfCfmFlg");
		this.hashFields.put("to_be_yn", "toBeYn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return orgDest
	 */
	public String getOrgDest() {
		return this.orgDest;
	}
	
	/**
	 * Column Info
	 * @return coverage
	 */
	public String getCoverage() {
		return this.coverage;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */
	public String getDmdtDeTermNm() {
		return this.dmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return exist
	 */
	public String getExist() {
		return this.exist;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpDesc
	 */
	public String getDmdtCgoTpDesc() {
		return this.dmdtCgoTpDesc;
	}
	
	/**
	 * Column Info
	 * @return billExem
	 */
	public String getBillExem() {
		return this.billExem;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpDesc
	 */
	public String getDmdtCntrTpDesc() {
		return this.dmdtCntrTpDesc;
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
	 * @param toBeYn
	 */
	public String getToBeYn() {
		return this.toBeYn;
	}

	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param orgDest
	 */
	public void setOrgDest(String orgDest) {
		this.orgDest = orgDest;
	}
	
	/**
	 * Column Info
	 * @param coverage
	 */
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermNm
	 */
	public void setDmdtDeTermNm(String dmdtDeTermNm) {
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param exist
	 */
	public void setExist(String exist) {
		this.exist = exist;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpDesc
	 */
	public void setDmdtCgoTpDesc(String dmdtCgoTpDesc) {
		this.dmdtCgoTpDesc = dmdtCgoTpDesc;
	}
	
	/**
	 * Column Info
	 * @param billExem
	 */
	public void setBillExem(String billExem) {
		this.billExem = billExem;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpDesc
	 */
	public void setDmdtCntrTpDesc(String dmdtCntrTpDesc) {
		this.dmdtCntrTpDesc = dmdtCntrTpDesc;
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
	 * @param toBeYn
	 */
	public void setToBeYn(String toBeYn) {
		this.toBeYn = toBeYn;
	}
	
	public String getTrfMngUsrId() {
		return trfMngUsrId;
	}

	public void setTrfMngUsrId(String trfMngUsrId) {
		this.trfMngUsrId = trfMngUsrId;
	}

	public String getTrfMngUsrNm() {
		return trfMngUsrNm;
	}

	public void setTrfMngUsrNm(String trfMngUsrNm) {
		this.trfMngUsrNm = trfMngUsrNm;
	}


	public String getPicTeam() {
		return picTeam;
	}

	public void setPicTeam(String picTeam) {
		this.picTeam = picTeam;
	}

	public String getTrfCfmFlg() {
		return trfCfmFlg;
	}

	public void setTrfCfmFlg(String trfCfmFlg) {
		this.trfCfmFlg = trfCfmFlg;
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
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgDest(JSPUtil.getParameter(request, prefix + "org_dest", ""));
		setCoverage(JSPUtil.getParameter(request, prefix + "coverage", ""));
		setDmdtDeTermNm(JSPUtil.getParameter(request, prefix + "dmdt_de_term_nm", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setExist(JSPUtil.getParameter(request, prefix + "exist", ""));
		setDmdtCgoTpDesc(JSPUtil.getParameter(request, prefix + "dmdt_cgo_tp_desc", ""));
		setBillExem(JSPUtil.getParameter(request, prefix + "bill_exem", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setDmdtCntrTpDesc(JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrfMngUsrId(JSPUtil.getParameter(request, prefix + "trf_mng_usr_id", ""));
		setTrfMngUsrNm(JSPUtil.getParameter(request, prefix + "trf_mng_usr_nm", ""));
		setPicTeam(JSPUtil.getParameter(request, prefix + "pic_team", ""));
		setTrfCfmFlg(JSPUtil.getParameter(request, prefix + "trf_cfm_flg", ""));
		setToBeYn(JSPUtil.getParameter(request, prefix + "to_be_yn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicTariffMonitorVO[]
	 */
	public SearchBasicTariffMonitorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicTariffMonitorVO[]
	 */
	public SearchBasicTariffMonitorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicTariffMonitorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgDest = (JSPUtil.getParameter(request, prefix	+ "org_dest", length));
			String[] coverage = (JSPUtil.getParameter(request, prefix	+ "coverage", length));
			String[] dmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] exist = (JSPUtil.getParameter(request, prefix	+ "exist", length));
			String[] dmdtCgoTpDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_desc", length));
			String[] billExem = (JSPUtil.getParameter(request, prefix	+ "bill_exem", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtCntrTpDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trfMngUsrId = (JSPUtil.getParameter(request, prefix	+ "trf_mng_usr_id", length));
			String[] trfMngUsrNm = (JSPUtil.getParameter(request, prefix	+ "trf_mng_usr_nm", length));
			String[] picTeam = (JSPUtil.getParameter(request, prefix	+ "pic_team", length));
			String[] trfCfmFlg = (JSPUtil.getParameter(request, prefix	+ "trf_cfm_flg", length));
			String[] toBeYn = (JSPUtil.getParameter(request, prefix	+ "to_be_yn", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBasicTariffMonitorVO();
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgDest[i] != null)
					model.setOrgDest(orgDest[i]);
				if (coverage[i] != null)
					model.setCoverage(coverage[i]);
				if (dmdtDeTermNm[i] != null)
					model.setDmdtDeTermNm(dmdtDeTermNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (exist[i] != null)
					model.setExist(exist[i]);
				if (dmdtCgoTpDesc[i] != null)
					model.setDmdtCgoTpDesc(dmdtCgoTpDesc[i]);
				if (billExem[i] != null)
					model.setBillExem(billExem[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dmdtCntrTpDesc[i] != null)
					model.setDmdtCntrTpDesc(dmdtCntrTpDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trfMngUsrId[i] != null)
					model.setTrfMngUsrId(trfMngUsrId[i]);
				if (trfMngUsrNm[i] != null)
					model.setTrfMngUsrNm(trfMngUsrNm[i]);
				if (picTeam[i] != null)
					model.setPicTeam(picTeam[i]);
				if (trfCfmFlg[i] != null)
					model.setTrfCfmFlg(trfCfmFlg[i]);
				if (toBeYn[i] != null)
					model.setToBeYn(toBeYn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicTariffMonitorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicTariffMonitorVO[]
	 */
	public SearchBasicTariffMonitorVO[] getSearchBasicTariffMonitorVOs(){
		SearchBasicTariffMonitorVO[] vos = (SearchBasicTariffMonitorVO[])models.toArray(new SearchBasicTariffMonitorVO[models.size()]);
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
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDest = this.orgDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coverage = this.coverage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermNm = this.dmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exist = this.exist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpDesc = this.dmdtCgoTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billExem = this.billExem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpDesc = this.dmdtCntrTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfMngUsrId = this.trfMngUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfMngUsrNm = this.trfMngUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picTeam = this.picTeam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCfmFlg = this.trfCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toBeYn = this.toBeYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
