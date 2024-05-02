/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CimEqSplsDfctStsVO.java
*@FileTitle : CimEqSplsDfctStsVO
*Open Issues : 장비 과부족현황 Mailing (2014.03 ~ 2014.04)
*Change history :
*@LastModifyDate : 2014.03.27
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2014.03.27 Chang Young Kim
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class CimEqSplsDfctStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CimEqSplsDfctStsVO> models = new ArrayList<CimEqSplsDfctStsVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mvmtCoCd = null;
	/* Column Info */
	private String mbBalQty = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rdFlg = null;
	/* Column Info */
	private String ibQty = null;
	/* Column Info */
	private String splsDfctStsCtnt = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String tgtYrwk = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tnRoutFlg = null;
	/* Column Info */
	private String mbRtoQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String obQty = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String enrFlg = null;
	/* Column Info */
	private String stsRmk = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CimEqSplsDfctStsVO() {}

	public CimEqSplsDfctStsVO(String ibflag, String pagerows, String tgtYrwk, String eccCd, String cntrTpszCd, String fullMtyCd, String socFlg, String rdFlg, String enrFlg, String mvmtCoCd, String tnRoutFlg, String ibQty, String obQty, String mbRtoQty, String mbBalQty, String splsDfctStsCtnt, String cfmFlg, String stsRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.mvmtCoCd = mvmtCoCd;
		this.mbBalQty = mbBalQty;
		this.eccCd = eccCd;
		this.creDt = creDt;
		this.rdFlg = rdFlg;
		this.ibQty = ibQty;
		this.splsDfctStsCtnt = splsDfctStsCtnt;
		this.cfmFlg = cfmFlg;
		this.pagerows = pagerows;
		this.socFlg = socFlg;
		this.tgtYrwk = tgtYrwk;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.tnRoutFlg = tnRoutFlg;
		this.mbRtoQty = mbRtoQty;
		this.cntrTpszCd = cntrTpszCd;
		this.obQty = obQty;
		this.fullMtyCd = fullMtyCd;
		this.enrFlg = enrFlg;
		this.stsRmk = stsRmk;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mvmt_co_cd", getMvmtCoCd());
		this.hashColumns.put("mb_bal_qty", getMbBalQty());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rd_flg", getRdFlg());
		this.hashColumns.put("ib_qty", getIbQty());
		this.hashColumns.put("spls_dfct_sts_ctnt", getSplsDfctStsCtnt());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("tgt_yrwk", getTgtYrwk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tn_rout_flg", getTnRoutFlg());
		this.hashColumns.put("mb_rto_qty", getMbRtoQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ob_qty", getObQty());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("enr_flg", getEnrFlg());
		this.hashColumns.put("sts_rmk", getStsRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mvmt_co_cd", "mvmtCoCd");
		this.hashFields.put("mb_bal_qty", "mbBalQty");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rd_flg", "rdFlg");
		this.hashFields.put("ib_qty", "ibQty");
		this.hashFields.put("spls_dfct_sts_ctnt", "splsDfctStsCtnt");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("tgt_yrwk", "tgtYrwk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tn_rout_flg", "tnRoutFlg");
		this.hashFields.put("mb_rto_qty", "mbRtoQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ob_qty", "obQty");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("enr_flg", "enrFlg");
		this.hashFields.put("sts_rmk", "stsRmk");
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
	 * @return mvmtCoCd
	 */
	public String getMvmtCoCd() {
		return this.mvmtCoCd;
	}
	
	/**
	 * Column Info
	 * @return mbBalQty
	 */
	public String getMbBalQty() {
		return this.mbBalQty;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
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
	 * @return rdFlg
	 */
	public String getRdFlg() {
		return this.rdFlg;
	}
	
	/**
	 * Column Info
	 * @return ibQty
	 */
	public String getIbQty() {
		return this.ibQty;
	}
	
	/**
	 * Column Info
	 * @return splsDfctStsCtnt
	 */
	public String getSplsDfctStsCtnt() {
		return this.splsDfctStsCtnt;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
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
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return tgtYrwk
	 */
	public String getTgtYrwk() {
		return this.tgtYrwk;
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
	 * @return tnRoutFlg
	 */
	public String getTnRoutFlg() {
		return this.tnRoutFlg;
	}
	
	/**
	 * Column Info
	 * @return mbRtoQty
	 */
	public String getMbRtoQty() {
		return this.mbRtoQty;
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
	 * @return obQty
	 */
	public String getObQty() {
		return this.obQty;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return enrFlg
	 */
	public String getEnrFlg() {
		return this.enrFlg;
	}
	
	/**
	 * Column Info
	 * @return stsRmk
	 */
	public String getStsRmk() {
		return this.stsRmk;
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
	 * @param mvmtCoCd
	 */
	public void setMvmtCoCd(String mvmtCoCd) {
		this.mvmtCoCd = mvmtCoCd;
	}
	
	/**
	 * Column Info
	 * @param mbBalQty
	 */
	public void setMbBalQty(String mbBalQty) {
		this.mbBalQty = mbBalQty;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
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
	 * @param rdFlg
	 */
	public void setRdFlg(String rdFlg) {
		this.rdFlg = rdFlg;
	}
	
	/**
	 * Column Info
	 * @param ibQty
	 */
	public void setIbQty(String ibQty) {
		this.ibQty = ibQty;
	}
	
	/**
	 * Column Info
	 * @param splsDfctStsCtnt
	 */
	public void setSplsDfctStsCtnt(String splsDfctStsCtnt) {
		this.splsDfctStsCtnt = splsDfctStsCtnt;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
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
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param tgtYrwk
	 */
	public void setTgtYrwk(String tgtYrwk) {
		this.tgtYrwk = tgtYrwk;
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
	 * @param tnRoutFlg
	 */
	public void setTnRoutFlg(String tnRoutFlg) {
		this.tnRoutFlg = tnRoutFlg;
	}
	
	/**
	 * Column Info
	 * @param mbRtoQty
	 */
	public void setMbRtoQty(String mbRtoQty) {
		this.mbRtoQty = mbRtoQty;
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
	 * @param obQty
	 */
	public void setObQty(String obQty) {
		this.obQty = obQty;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param enrFlg
	 */
	public void setEnrFlg(String enrFlg) {
		this.enrFlg = enrFlg;
	}
	
	/**
	 * Column Info
	 * @param stsRmk
	 */
	public void setStsRmk(String stsRmk) {
		this.stsRmk = stsRmk;
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
		setMvmtCoCd(JSPUtil.getParameter(request, prefix + "mvmt_co_cd", ""));
		setMbBalQty(JSPUtil.getParameter(request, prefix + "mb_bal_qty", ""));
		setEccCd(JSPUtil.getParameter(request, prefix + "ecc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRdFlg(JSPUtil.getParameter(request, prefix + "rd_flg", ""));
		setIbQty(JSPUtil.getParameter(request, prefix + "ib_qty", ""));
		setSplsDfctStsCtnt(JSPUtil.getParameter(request, prefix + "spls_dfct_sts_ctnt", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setTgtYrwk(JSPUtil.getParameter(request, prefix + "tgt_yrwk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTnRoutFlg(JSPUtil.getParameter(request, prefix + "tn_rout_flg", ""));
		setMbRtoQty(JSPUtil.getParameter(request, prefix + "mb_rto_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setObQty(JSPUtil.getParameter(request, prefix + "ob_qty", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setEnrFlg(JSPUtil.getParameter(request, prefix + "enr_flg", ""));
		setStsRmk(JSPUtil.getParameter(request, prefix + "sts_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CimEqSplsDfctStsVO[]
	 */
	public CimEqSplsDfctStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CimEqSplsDfctStsVO[]
	 */
	public CimEqSplsDfctStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CimEqSplsDfctStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mvmtCoCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_co_cd", length));
			String[] mbBalQty = (JSPUtil.getParameter(request, prefix	+ "mb_bal_qty", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rdFlg = (JSPUtil.getParameter(request, prefix	+ "rd_flg", length));
			String[] ibQty = (JSPUtil.getParameter(request, prefix	+ "ib_qty", length));
			String[] splsDfctStsCtnt = (JSPUtil.getParameter(request, prefix	+ "spls_dfct_sts_ctnt", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] tgtYrwk = (JSPUtil.getParameter(request, prefix	+ "tgt_yrwk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tnRoutFlg = (JSPUtil.getParameter(request, prefix	+ "tn_rout_flg", length));
			String[] mbRtoQty = (JSPUtil.getParameter(request, prefix	+ "mb_rto_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] obQty = (JSPUtil.getParameter(request, prefix	+ "ob_qty", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] enrFlg = (JSPUtil.getParameter(request, prefix	+ "enr_flg", length));
			String[] stsRmk = (JSPUtil.getParameter(request, prefix	+ "sts_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CimEqSplsDfctStsVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mvmtCoCd[i] != null)
					model.setMvmtCoCd(mvmtCoCd[i]);
				if (mbBalQty[i] != null)
					model.setMbBalQty(mbBalQty[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rdFlg[i] != null)
					model.setRdFlg(rdFlg[i]);
				if (ibQty[i] != null)
					model.setIbQty(ibQty[i]);
				if (splsDfctStsCtnt[i] != null)
					model.setSplsDfctStsCtnt(splsDfctStsCtnt[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (tgtYrwk[i] != null)
					model.setTgtYrwk(tgtYrwk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tnRoutFlg[i] != null)
					model.setTnRoutFlg(tnRoutFlg[i]);
				if (mbRtoQty[i] != null)
					model.setMbRtoQty(mbRtoQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (obQty[i] != null)
					model.setObQty(obQty[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (enrFlg[i] != null)
					model.setEnrFlg(enrFlg[i]);
				if (stsRmk[i] != null)
					model.setStsRmk(stsRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCimEqSplsDfctStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CimEqSplsDfctStsVO[]
	 */
	public CimEqSplsDfctStsVO[] getCimEqSplsDfctStsVOs(){
		CimEqSplsDfctStsVO[] vos = (CimEqSplsDfctStsVO[])models.toArray(new CimEqSplsDfctStsVO[models.size()]);
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
		this.mvmtCoCd = this.mvmtCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mbBalQty = this.mbBalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlg = this.rdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibQty = this.ibQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splsDfctStsCtnt = this.splsDfctStsCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtYrwk = this.tgtYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tnRoutFlg = this.tnRoutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mbRtoQty = this.mbRtoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obQty = this.obQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enrFlg = this.enrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsRmk = this.stsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
