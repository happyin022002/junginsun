/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MasCntrRepoIdxItmVO.java
*@FileTitle : MasCntrRepoIdxItmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임옥영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class MasCntrRepoIdxItmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasCntrRepoIdxItmVO> models = new ArrayList<MasCntrRepoIdxItmVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String costRoutNo = null;
	/* Column Info */
	private String tzHrs = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String repoCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqRepoCrRto = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String perfCostAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String repoLvlGrpCd = null;
	/* Column Info */
	private String eccRccStsCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MasCntrRepoIdxItmVO() {}

	public MasCntrRepoIdxItmVO(String ibflag, String pagerows, String bkgNo, String cntrTpszCd, String stndCostCd, String costRoutNo, String eccCd, String eccRccStsCd, String tzHrs, String repoCostAmt, String perfCostAmt, String repoLvlGrpCd, String eqRepoCrRto, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.costRoutNo = costRoutNo;
		this.tzHrs = tzHrs;
		this.eccCd = eccCd;
		this.creDt = creDt;
		this.repoCostAmt = repoCostAmt;
		this.pagerows = pagerows;
		this.eqRepoCrRto = eqRepoCrRto;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.perfCostAmt = perfCostAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.repoLvlGrpCd = repoLvlGrpCd;
		this.eccRccStsCd = eccRccStsCd;
		this.updUsrId = updUsrId;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cost_rout_no", getCostRoutNo());
		this.hashColumns.put("tz_hrs", getTzHrs());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("repo_cost_amt", getRepoCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_repo_cr_rto", getEqRepoCrRto());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("perf_cost_amt", getPerfCostAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("repo_lvl_grp_cd", getRepoLvlGrpCd());
		this.hashColumns.put("ecc_rcc_sts_cd", getEccRccStsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cost_rout_no", "costRoutNo");
		this.hashFields.put("tz_hrs", "tzHrs");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("repo_cost_amt", "repoCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_repo_cr_rto", "eqRepoCrRto");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("perf_cost_amt", "perfCostAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("repo_lvl_grp_cd", "repoLvlGrpCd");
		this.hashFields.put("ecc_rcc_sts_cd", "eccRccStsCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
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
	 * @return costRoutNo
	 */
	public String getCostRoutNo() {
		return this.costRoutNo;
	}
	
	/**
	 * Column Info
	 * @return tzHrs
	 */
	public String getTzHrs() {
		return this.tzHrs;
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
	 * @return repoCostAmt
	 */
	public String getRepoCostAmt() {
		return this.repoCostAmt;
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
	 * @return eqRepoCrRto
	 */
	public String getEqRepoCrRto() {
		return this.eqRepoCrRto;
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
	 * @return perfCostAmt
	 */
	public String getPerfCostAmt() {
		return this.perfCostAmt;
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
	 * @return repoLvlGrpCd
	 */
	public String getRepoLvlGrpCd() {
		return this.repoLvlGrpCd;
	}
	
	/**
	 * Column Info
	 * @return eccRccStsCd
	 */
	public String getEccRccStsCd() {
		return this.eccRccStsCd;
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
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
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
	 * @param costRoutNo
	 */
	public void setCostRoutNo(String costRoutNo) {
		this.costRoutNo = costRoutNo;
	}
	
	/**
	 * Column Info
	 * @param tzHrs
	 */
	public void setTzHrs(String tzHrs) {
		this.tzHrs = tzHrs;
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
	 * @param repoCostAmt
	 */
	public void setRepoCostAmt(String repoCostAmt) {
		this.repoCostAmt = repoCostAmt;
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
	 * @param eqRepoCrRto
	 */
	public void setEqRepoCrRto(String eqRepoCrRto) {
		this.eqRepoCrRto = eqRepoCrRto;
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
	 * @param perfCostAmt
	 */
	public void setPerfCostAmt(String perfCostAmt) {
		this.perfCostAmt = perfCostAmt;
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
	 * @param repoLvlGrpCd
	 */
	public void setRepoLvlGrpCd(String repoLvlGrpCd) {
		this.repoLvlGrpCd = repoLvlGrpCd;
	}
	
	/**
	 * Column Info
	 * @param eccRccStsCd
	 */
	public void setEccRccStsCd(String eccRccStsCd) {
		this.eccRccStsCd = eccRccStsCd;
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
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCostRoutNo(JSPUtil.getParameter(request, "cost_rout_no", ""));
		setTzHrs(JSPUtil.getParameter(request, "tz_hrs", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRepoCostAmt(JSPUtil.getParameter(request, "repo_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqRepoCrRto(JSPUtil.getParameter(request, "eq_repo_cr_rto", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPerfCostAmt(JSPUtil.getParameter(request, "perf_cost_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setRepoLvlGrpCd(JSPUtil.getParameter(request, "repo_lvl_grp_cd", ""));
		setEccRccStsCd(JSPUtil.getParameter(request, "ecc_rcc_sts_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setStndCostCd(JSPUtil.getParameter(request, "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasCntrRepoIdxItmVO[]
	 */
	public MasCntrRepoIdxItmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasCntrRepoIdxItmVO[]
	 */
	public MasCntrRepoIdxItmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasCntrRepoIdxItmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] costRoutNo = (JSPUtil.getParameter(request, prefix	+ "cost_rout_no", length));
			String[] tzHrs = (JSPUtil.getParameter(request, prefix	+ "tz_hrs", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] repoCostAmt = (JSPUtil.getParameter(request, prefix	+ "repo_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqRepoCrRto = (JSPUtil.getParameter(request, prefix	+ "eq_repo_cr_rto", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] perfCostAmt = (JSPUtil.getParameter(request, prefix	+ "perf_cost_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] repoLvlGrpCd = (JSPUtil.getParameter(request, prefix	+ "repo_lvl_grp_cd", length));
			String[] eccRccStsCd = (JSPUtil.getParameter(request, prefix	+ "ecc_rcc_sts_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasCntrRepoIdxItmVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (costRoutNo[i] != null)
					model.setCostRoutNo(costRoutNo[i]);
				if (tzHrs[i] != null)
					model.setTzHrs(tzHrs[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (repoCostAmt[i] != null)
					model.setRepoCostAmt(repoCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqRepoCrRto[i] != null)
					model.setEqRepoCrRto(eqRepoCrRto[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (perfCostAmt[i] != null)
					model.setPerfCostAmt(perfCostAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (repoLvlGrpCd[i] != null)
					model.setRepoLvlGrpCd(repoLvlGrpCd[i]);
				if (eccRccStsCd[i] != null)
					model.setEccRccStsCd(eccRccStsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasCntrRepoIdxItmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasCntrRepoIdxItmVO[]
	 */
	public MasCntrRepoIdxItmVO[] getMasCntrRepoIdxItmVOs(){
		MasCntrRepoIdxItmVO[] vos = (MasCntrRepoIdxItmVO[])models.toArray(new MasCntrRepoIdxItmVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRoutNo = this.costRoutNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tzHrs = this.tzHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoCostAmt = this.repoCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoCrRto = this.eqRepoCrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfCostAmt = this.perfCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoLvlGrpCd = this.repoLvlGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccRccStsCd = this.eccRccStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
