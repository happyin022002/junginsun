/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchBasicTariffXSL01VO.java
*@FileTitle : SearchBasicTariffXSL01VO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2010.01.05 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

import java.lang.reflect.Field;
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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBasicTariffXSL01VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicTariffXSL01VO> models = new ArrayList<SearchBasicTariffXSL01VO>();
	
	/* Column Info */
	private String intgCdValDpSeqD = null;
	/* Column Info */
	private String intgCdValDpSeqE = null;
	/* Column Info */
	private String dmdtCntrTpNm = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String dmdtCgoTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String dmdtBzcTrfGrpNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String dmdtCgoTpCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String userOffice = null;
	/* Column Info */
	private String trfSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBasicTariffXSL01VO() {}

	public SearchBasicTariffXSL01VO(String ibflag, String pagerows, String svrId, String dmdtTrfCd, String trfSeq, String trfGrpSeq, String dmdtBzcTrfGrpNm, String effDt, String expDt, String userOffice, String dmdtCntrTpCd, String dmdtCgoTpCd, String dmdtCntrTpNm, String dmdtCgoTpNm, String intgCdValDpSeqD, String intgCdValDpSeqE) {
		this.intgCdValDpSeqD = intgCdValDpSeqD;
		this.intgCdValDpSeqE = intgCdValDpSeqE;
		this.dmdtCntrTpNm = dmdtCntrTpNm;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.dmdtCgoTpNm = dmdtCgoTpNm;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.expDt = expDt;
		this.trfGrpSeq = trfGrpSeq;
		this.dmdtCgoTpCd = dmdtCgoTpCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.userOffice = userOffice;
		this.trfSeq = trfSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("intg_cd_val_dp_seq_d", getIntgCdValDpSeqD());
		this.hashColumns.put("intg_cd_val_dp_seq_e", getIntgCdValDpSeqE());
		this.hashColumns.put("dmdt_cntr_tp_nm", getDmdtCntrTpNm());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("dmdt_cgo_tp_nm", getDmdtCgoTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("dmdt_bzc_trf_grp_nm", getDmdtBzcTrfGrpNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("dmdt_cgo_tp_cd", getDmdtCgoTpCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("user_office", getUserOffice());
		this.hashColumns.put("trf_seq", getTrfSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("intg_cd_val_dp_seq_d", "intgCdValDpSeqD");
		this.hashFields.put("intg_cd_val_dp_seq_e", "intgCdValDpSeqE");
		this.hashFields.put("dmdt_cntr_tp_nm", "dmdtCntrTpNm");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("dmdt_cgo_tp_nm", "dmdtCgoTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("dmdt_bzc_trf_grp_nm", "dmdtBzcTrfGrpNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("dmdt_cgo_tp_cd", "dmdtCgoTpCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("user_office", "userOffice");
		this.hashFields.put("trf_seq", "trfSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpSeqD
	 */
	public String getIntgCdValDpSeqD() {
		return this.intgCdValDpSeqD;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpSeqE
	 */
	public String getIntgCdValDpSeqE() {
		return this.intgCdValDpSeqE;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpNm
	 */
	public String getDmdtCntrTpNm() {
		return this.dmdtCntrTpNm;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpNm
	 */
	public String getDmdtCgoTpNm() {
		return this.dmdtCgoTpNm;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return dmdtBzcTrfGrpNm
	 */
	public String getDmdtBzcTrfGrpNm() {
		return this.dmdtBzcTrfGrpNm;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpCd
	 */
	public String getDmdtCgoTpCd() {
		return this.dmdtCgoTpCd;
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
	 * @return userOffice
	 */
	public String getUserOffice() {
		return this.userOffice;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
	}
	

	/**
	 * Column Info
	 * @param intgCdValDpSeqD
	 */
	public void setIntgCdValDpSeqD(String intgCdValDpSeqD) {
		this.intgCdValDpSeqD = intgCdValDpSeqD;
	}
	
	/**
	 * Column Info
	 * @param intgCdValDpSeqE
	 */
	public void setIntgCdValDpSeqE(String intgCdValDpSeqE) {
		this.intgCdValDpSeqE = intgCdValDpSeqE;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpNm
	 */
	public void setDmdtCntrTpNm(String dmdtCntrTpNm) {
		this.dmdtCntrTpNm = dmdtCntrTpNm;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpNm
	 */
	public void setDmdtCgoTpNm(String dmdtCgoTpNm) {
		this.dmdtCgoTpNm = dmdtCgoTpNm;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param dmdtBzcTrfGrpNm
	 */
	public void setDmdtBzcTrfGrpNm(String dmdtBzcTrfGrpNm) {
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpCd
	 */
	public void setDmdtCgoTpCd(String dmdtCgoTpCd) {
		this.dmdtCgoTpCd = dmdtCgoTpCd;
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
	 * @param userOffice
	 */
	public void setUserOffice(String userOffice) {
		this.userOffice = userOffice;
	}
	
	/**
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIntgCdValDpSeqD(JSPUtil.getParameter(request, "intg_cd_val_dp_seq_d", ""));
		setIntgCdValDpSeqE(JSPUtil.getParameter(request, "intg_cd_val_dp_seq_e", ""));
		setDmdtCntrTpNm(JSPUtil.getParameter(request, "dmdt_cntr_tp_nm", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, "dmdt_cntr_tp_cd", ""));
		setDmdtCgoTpNm(JSPUtil.getParameter(request, "dmdt_cgo_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setDmdtBzcTrfGrpNm(JSPUtil.getParameter(request, "dmdt_bzc_trf_grp_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, "trf_grp_seq", ""));
		setDmdtCgoTpCd(JSPUtil.getParameter(request, "dmdt_cgo_tp_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setUserOffice(JSPUtil.getParameter(request, "user_office", ""));
		setTrfSeq(JSPUtil.getParameter(request, "trf_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicTariffXSL01VO[]
	 */
	public SearchBasicTariffXSL01VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicTariffXSL01VO[]
	 */
	public SearchBasicTariffXSL01VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicTariffXSL01VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] intgCdValDpSeqD = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_seq_d", length));
			String[] intgCdValDpSeqE = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_seq_e", length));
			String[] dmdtCntrTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_nm", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] dmdtCgoTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] dmdtBzcTrfGrpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_trf_grp_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] dmdtCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] userOffice = (JSPUtil.getParameter(request, prefix	+ "user_office", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBasicTariffXSL01VO();
				if (intgCdValDpSeqD[i] != null)
					model.setIntgCdValDpSeqD(intgCdValDpSeqD[i]);
				if (intgCdValDpSeqE[i] != null)
					model.setIntgCdValDpSeqE(intgCdValDpSeqE[i]);
				if (dmdtCntrTpNm[i] != null)
					model.setDmdtCntrTpNm(dmdtCntrTpNm[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (dmdtCgoTpNm[i] != null)
					model.setDmdtCgoTpNm(dmdtCgoTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (dmdtBzcTrfGrpNm[i] != null)
					model.setDmdtBzcTrfGrpNm(dmdtBzcTrfGrpNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (dmdtCgoTpCd[i] != null)
					model.setDmdtCgoTpCd(dmdtCgoTpCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (userOffice[i] != null)
					model.setUserOffice(userOffice[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicTariffXSL01VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicTariffXSL01VO[]
	 */
	public SearchBasicTariffXSL01VO[] getSearchBasicTariffXSL01VOs(){
		SearchBasicTariffXSL01VO[] vos = (SearchBasicTariffXSL01VO[])models.toArray(new SearchBasicTariffXSL01VO[models.size()]);
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
		this.intgCdValDpSeqD = this.intgCdValDpSeqD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDpSeqE = this.intgCdValDpSeqE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpNm = this.dmdtCntrTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpNm = this.dmdtCgoTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcTrfGrpNm = this.dmdtBzcTrfGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpCd = this.dmdtCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOffice = this.userOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
