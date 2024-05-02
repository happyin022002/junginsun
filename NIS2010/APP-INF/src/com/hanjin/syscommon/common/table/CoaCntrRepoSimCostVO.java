/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CoaCntrRepoSimCostVO.java
*@FileTitle : CoaCntrRepoSimCostVO
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

public class CoaCntrRepoSimCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoaCntrRepoSimCostVO> models = new ArrayList<CoaCntrRepoSimCostVO>();
	
	/* Column Info */
	private String porEccCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fnlMtySimCostAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String delEccCd = null;
	/* Column Info */
	private String eqRepoCrRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mtySimCostAmt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CoaCntrRepoSimCostVO() {}

	public CoaCntrRepoSimCostVO(String ibflag, String pagerows, String costYrmon, String porEccCd, String delEccCd, String cntrTpszCd, String eqRepoCrRto, String mtySimCostAmt, String fnlMtySimCostAmt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.porEccCd = porEccCd;
		this.updDt = updDt;
		this.fnlMtySimCostAmt = fnlMtySimCostAmt;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.delEccCd = delEccCd;
		this.eqRepoCrRto = eqRepoCrRto;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.costYrmon = costYrmon;
		this.cntrTpszCd = cntrTpszCd;
		this.mtySimCostAmt = mtySimCostAmt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_ecc_cd", getPorEccCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("fnl_mty_sim_cost_amt", getFnlMtySimCostAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("del_ecc_cd", getDelEccCd());
		this.hashColumns.put("eq_repo_cr_rto", getEqRepoCrRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("mty_sim_cost_amt", getMtySimCostAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_ecc_cd", "porEccCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("fnl_mty_sim_cost_amt", "fnlMtySimCostAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("del_ecc_cd", "delEccCd");
		this.hashFields.put("eq_repo_cr_rto", "eqRepoCrRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mty_sim_cost_amt", "mtySimCostAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porEccCd
	 */
	public String getPorEccCd() {
		return this.porEccCd;
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
	 * @return fnlMtySimCostAmt
	 */
	public String getFnlMtySimCostAmt() {
		return this.fnlMtySimCostAmt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return delEccCd
	 */
	public String getDelEccCd() {
		return this.delEccCd;
	}
	
	/**
	 * Column Info
	 * @return eqRepoCrRto
	 */
	public String getEqRepoCrRto() {
		return this.eqRepoCrRto;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return mtySimCostAmt
	 */
	public String getMtySimCostAmt() {
		return this.mtySimCostAmt;
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
	 * @param porEccCd
	 */
	public void setPorEccCd(String porEccCd) {
		this.porEccCd = porEccCd;
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
	 * @param fnlMtySimCostAmt
	 */
	public void setFnlMtySimCostAmt(String fnlMtySimCostAmt) {
		this.fnlMtySimCostAmt = fnlMtySimCostAmt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param delEccCd
	 */
	public void setDelEccCd(String delEccCd) {
		this.delEccCd = delEccCd;
	}
	
	/**
	 * Column Info
	 * @param eqRepoCrRto
	 */
	public void setEqRepoCrRto(String eqRepoCrRto) {
		this.eqRepoCrRto = eqRepoCrRto;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param mtySimCostAmt
	 */
	public void setMtySimCostAmt(String mtySimCostAmt) {
		this.mtySimCostAmt = mtySimCostAmt;
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
		setPorEccCd(JSPUtil.getParameter(request, "por_ecc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setFnlMtySimCostAmt(JSPUtil.getParameter(request, "fnl_mty_sim_cost_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDelEccCd(JSPUtil.getParameter(request, "del_ecc_cd", ""));
		setEqRepoCrRto(JSPUtil.getParameter(request, "eq_repo_cr_rto", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setMtySimCostAmt(JSPUtil.getParameter(request, "mty_sim_cost_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CoaCntrRepoSimCostVO[]
	 */
	public CoaCntrRepoSimCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CoaCntrRepoSimCostVO[]
	 */
	public CoaCntrRepoSimCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CoaCntrRepoSimCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porEccCd = (JSPUtil.getParameter(request, prefix	+ "por_ecc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fnlMtySimCostAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_mty_sim_cost_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] delEccCd = (JSPUtil.getParameter(request, prefix	+ "del_ecc_cd", length));
			String[] eqRepoCrRto = (JSPUtil.getParameter(request, prefix	+ "eq_repo_cr_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] mtySimCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_sim_cost_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CoaCntrRepoSimCostVO();
				if (porEccCd[i] != null)
					model.setPorEccCd(porEccCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fnlMtySimCostAmt[i] != null)
					model.setFnlMtySimCostAmt(fnlMtySimCostAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (delEccCd[i] != null)
					model.setDelEccCd(delEccCd[i]);
				if (eqRepoCrRto[i] != null)
					model.setEqRepoCrRto(eqRepoCrRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mtySimCostAmt[i] != null)
					model.setMtySimCostAmt(mtySimCostAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCoaCntrRepoSimCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CoaCntrRepoSimCostVO[]
	 */
	public CoaCntrRepoSimCostVO[] getCoaCntrRepoSimCostVOs(){
		CoaCntrRepoSimCostVO[] vos = (CoaCntrRepoSimCostVO[])models.toArray(new CoaCntrRepoSimCostVO[models.size()]);
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
		this.porEccCd = this.porEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMtySimCostAmt = this.fnlMtySimCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEccCd = this.delEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoCrRto = this.eqRepoCrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtySimCostAmt = this.mtySimCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
