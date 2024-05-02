/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MstContainerInfoVO.java
*@FileTitle : MstContainerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.09
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2010.09.09 나상보
* 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.09 나상보 [CHM-201005675-01] Split 01-M&R SYSTEM에서 Damage Flag 자동 제거
 *                   MST_CONTAINER 조회시 dmg_flg컬럼 추가
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * @author 나상보
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MstContainerInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<MstContainerInfoVO> models = new ArrayList<MstContainerInfoVO>();

	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String coCreFlg = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String preStsFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String uclmLsDivCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String compDt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String evntDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public MstContainerInfoVO() {}

	public MstContainerInfoVO(String ibflag, String pagerows, String agmtSeq, String cnmvDt, String crntYdCd, String coCreFlg, String aciacDivCd, String cnmvStsCd, String uclmLsDivCd, String cntrTpszCd, String agmtCtyCd, String imdtExtFlg, String lstmCd, String evntDt, String svrId, String compDt, String preStsFlg, String dmgFlg) {
		this.agmtSeq = agmtSeq;
		this.cnmvDt = cnmvDt;
		this.crntYdCd = crntYdCd;
		this.dmgFlg = dmgFlg;
		this.coCreFlg = coCreFlg;
		this.aciacDivCd = aciacDivCd;
		this.preStsFlg = preStsFlg;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.uclmLsDivCd = uclmLsDivCd;
		this.cntrTpszCd = cntrTpszCd;
		this.agmtCtyCd = agmtCtyCd;
		this.imdtExtFlg = imdtExtFlg;
		this.compDt = compDt;
		this.lstmCd = lstmCd;
		this.evntDt = evntDt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("co_cre_flg", getCoCreFlg());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("pre_sts_flg", getPreStsFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("comp_dt", getCompDt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("evnt_dt", getEvntDt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("co_cre_flg", "coCreFlg");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("pre_sts_flg", "preStsFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("comp_dt", "compDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("evnt_dt", "evntDt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}

	/**
	 * Column Info
	 * @return cnmvDt
	 */
	public String getCnmvDt() {
		return this.cnmvDt;
	}

	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}

	/**
	 * Column Info
	 * @return dmgFlg
	 */
	public String getDmgFlg() {
		return this.dmgFlg;
	}

	/**
	 * Column Info
	 * @return coCreFlg
	 */
	public String getCoCreFlg() {
		return this.coCreFlg;
	}

	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}

	/**
	 * Column Info
	 * @return preStsFlg
	 */
	public String getPreStsFlg() {
		return this.preStsFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}

	/**
	 * Column Info
	 * @return uclmLsDivCd
	 */
	public String getUclmLsDivCd() {
		return this.uclmLsDivCd;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}

	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}

	/**
	 * Column Info
	 * @return compDt
	 */
	public String getCompDt() {
		return this.compDt;
	}

	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}


	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * Column Info
	 * @param cnmvDt
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
	}

	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}

	/**
	 * Column Info
	 * @param dmgFlg
	 */
	public void setDmgFlg(String dmgFlg) {
		this.dmgFlg = dmgFlg;
	}

	/**
	 * Column Info
	 * @param coCreFlg
	 */
	public void setCoCreFlg(String coCreFlg) {
		this.coCreFlg = coCreFlg;
	}

	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}

	/**
	 * Column Info
	 * @param preStsFlg
	 */
	public void setPreStsFlg(String preStsFlg) {
		this.preStsFlg = preStsFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}

	/**
	 * Column Info
	 * @param uclmLsDivCd
	 */
	public void setUclmLsDivCd(String uclmLsDivCd) {
		this.uclmLsDivCd = uclmLsDivCd;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}

	/**
	 * Column Info
	 * @param compDt
	 */
	public void setCompDt(String compDt) {
		this.compDt = compDt;
	}

	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setCnmvDt(JSPUtil.getParameter(request, prefix + "cnmv_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request, prefix + "dmg_flg", ""));
		setCoCreFlg(JSPUtil.getParameter(request, prefix + "co_cre_flg", ""));
		setAciacDivCd(JSPUtil.getParameter(request, prefix + "aciac_div_cd", ""));
		setPreStsFlg(JSPUtil.getParameter(request, prefix + "pre_sts_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request, prefix + "uclm_ls_div_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setCompDt(JSPUtil.getParameter(request, prefix + "comp_dt", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MstContainerInfoVO[]
	 */
	public MstContainerInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return MstContainerInfoVO[]
	 */
	public MstContainerInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MstContainerInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] coCreFlg = (JSPUtil.getParameter(request, prefix	+ "co_cre_flg", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] preStsFlg = (JSPUtil.getParameter(request, prefix	+ "pre_sts_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] uclmLsDivCd = (JSPUtil.getParameter(request, prefix	+ "uclm_ls_div_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] compDt = (JSPUtil.getParameter(request, prefix	+ "comp_dt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));

			for (int i = 0; i < length; i++) {
				model = new MstContainerInfoVO();
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (coCreFlg[i] != null)
					model.setCoCreFlg(coCreFlg[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (preStsFlg[i] != null)
					model.setPreStsFlg(preStsFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (uclmLsDivCd[i] != null)
					model.setUclmLsDivCd(uclmLsDivCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (compDt[i] != null)
					model.setCompDt(compDt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMstContainerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MstContainerInfoVO[]
	 */
	public MstContainerInfoVO[] getMstContainerInfoVOs(){
		MstContainerInfoVO[] vos = (MstContainerInfoVO[])models.toArray(new MstContainerInfoVO[models.size()]);
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
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCreFlg = this.coCreFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsFlg = this.preStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd = this.uclmLsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compDt = this.compDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
