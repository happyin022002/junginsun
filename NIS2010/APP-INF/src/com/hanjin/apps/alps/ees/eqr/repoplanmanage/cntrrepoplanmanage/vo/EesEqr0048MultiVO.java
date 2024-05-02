/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0048MultiVO.java
*@FileTitle : EesEqr0048MultiVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.09.21		1.0 최초 생성
*
*@LastModifyDate : 2009.09.21
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0048MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0048MultiVO> models = new ArrayList<EesEqr0048MultiVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String toEccCd = null;
	/* Column Info */
	private String tablenm = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmEccCd = null;
	/* Column Info */
	private String toEtaDt = null;
	/* Column Info */
	private String fmEtdDt = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private List<String> cntrTpszCd = null;
	/* Column Info */
	private List<String> cntrQty = null;
	/* Column Info */
	private List<String> costAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0048MultiVO() {}

	public EesEqr0048MultiVO(String ibflag, String pagerows, String repoPlnId, String plnYrwk, String trspModCd, String item, String vslLaneCd, String vslCd, String skdVoyNo, String skdDirCd, String fmEccCd, String toEccCd, String fmEtdDt, String toEtaDt, String tablenm) {
		this.vslCd = vslCd;
		this.toEccCd = toEccCd;
		this.tablenm = tablenm;
		this.skdVoyNo = skdVoyNo;
		this.plnYrwk = plnYrwk;
		this.trspModCd = trspModCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.repoPlnId = repoPlnId;
		this.vslLaneCd = vslLaneCd;
		this.ibflag = ibflag;
		this.fmEccCd = fmEccCd;
		this.toEtaDt = toEtaDt;
		this.fmEtdDt = fmEtdDt;
		this.item = item;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("to_ecc_cd", getToEccCd());
		this.hashColumns.put("tablenm", getTablenm());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_ecc_cd", getFmEccCd());
		this.hashColumns.put("to_eta_dt", getToEtaDt());
		this.hashColumns.put("fm_etd_dt", getFmEtdDt());
		this.hashColumns.put("item", getItem());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("to_ecc_cd", "toEccCd");
		this.hashFields.put("tablenm", "tablenm");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_ecc_cd", "fmEccCd");
		this.hashFields.put("to_eta_dt", "toEtaDt");
		this.hashFields.put("fm_etd_dt", "fmEtdDt");
		this.hashFields.put("item", "item");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return toEccCd
	 */
	public String getToEccCd() {
		return this.toEccCd;
	}
	
	/**
	 * Column Info
	 * @return tablenm
	 */
	public String getTablenm() {
		return this.tablenm;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
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
	 * @return fmEccCd
	 */
	public String getFmEccCd() {
		return this.fmEccCd;
	}
	
	/**
	 * Column Info
	 * @return toEtaDt
	 */
	public String getToEtaDt() {
		return this.toEtaDt;
	}
	
	/**
	 * Column Info
	 * @return fmEtdDt
	 */
	public String getFmEtdDt() {
		return this.fmEtdDt;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param toEccCd
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}
	
	/**
	 * Column Info
	 * @param tablenm
	 */
	public void setTablenm(String tablenm) {
		this.tablenm = tablenm;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
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
	 * @param fmEccCd
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
	}
	
	/**
	 * Column Info
	 * @param toEtaDt
	 */
	public void setToEtaDt(String toEtaDt) {
		this.toEtaDt = toEtaDt;
	}
	
	/**
	 * Column Info
	 * @param fmEtdDt
	 */
	public void setFmEtdDt(String fmEtdDt) {
		this.fmEtdDt = fmEtdDt;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * @return the cntrTpszCd
	 */
	public List<String> getCntrTpszCd() {
		return cntrTpszCd;
	}

	/**
	 * @param cntrTpszCd the cntrTpszCd to set
	 */
	public void setCntrTpszCd(List<String> cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * @return the cntrQty
	 */
	public List<String> getCntrQty() {
		return cntrQty;
	}

	/**
	 * @param cntrQty the cntrQty to set
	 */
	public void setCntrQty(List<String> cntrQty) {
		this.cntrQty = cntrQty;
	}

	/**
	 * @return the costAmt
	 */
	public List<String> getCostAmt() {
		return costAmt;
	}

	/**
	 * @param costAmt the costAmt to set
	 */
	public void setCostAmt(List<String> costAmt) {
		this.costAmt = costAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setToEccCd(JSPUtil.getParameter(request, "to_ecc_cd", ""));
		setTablenm(JSPUtil.getParameter(request, "tablenm", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setVslLaneCd(JSPUtil.getParameter(request, "vsl_lane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmEccCd(JSPUtil.getParameter(request, "fm_ecc_cd", ""));
		setToEtaDt(JSPUtil.getParameter(request, "to_eta_dt", ""));
		setFmEtdDt(JSPUtil.getParameter(request, "fm_etd_dt", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0048MultiVO[]
	 */
	public EesEqr0048MultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0048MultiVO[]
	 */
	public EesEqr0048MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0048MultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] toEccCd = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd", length));
			String[] tablenm = (JSPUtil.getParameter(request, prefix	+ "tablenm", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmEccCd = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd", length));
			String[] toEtaDt = (JSPUtil.getParameter(request, prefix	+ "to_eta_dt", length));
			String[] fmEtdDt = (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0048MultiVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (toEccCd[i] != null)
					model.setToEccCd(toEccCd[i]);
				if (tablenm[i] != null)
					model.setTablenm(tablenm[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmEccCd[i] != null)
					model.setFmEccCd(fmEccCd[i]);
				if (toEtaDt[i] != null)
					model.setToEtaDt(toEtaDt[i]);
				if (fmEtdDt[i] != null)
					model.setFmEtdDt(fmEtdDt[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0048MultiVOs();
	}
	
	/**
	 * EES_EQR_0048 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 화면에서 사용함.
	 * 
	 * @param request
	 * @param pirfix
	 * @return
	 */
	public EesEqr0048MultiVO[] fromRequestGridArrayList(HttpServletRequest request, String pirfix) {
		EesEqr0048MultiVO model = null;
		int length = request.getParameterValues("ibflag").length;
		String[] prefix = null;
		
		if (!(pirfix.equals(""))){
        	prefix = pirfix.split(",");
        }
		
		try {
			String[] ibflag             =  (JSPUtil.getParameter(request, "ibflag", length));
			String[] repo_pln_id        =  (JSPUtil.getParameter(request, "repo_pln_id", length));
			String[] pln_yrwk           =  (JSPUtil.getParameter(request, "pln_yrwk", length));
			String[] trsp_mod_cd        =  (JSPUtil.getParameter(request, "trsp_mod_cd", length));
			String[] item        		=  (JSPUtil.getParameter(request, "item", length));
			String[] vsl_lane_cd        =  (JSPUtil.getParameter(request, "vsl_lane_cd", length));
			String[] vvd             	=  (JSPUtil.getParameter(request, "vvd", length));
			String[] fm_ecc_cd          =  (JSPUtil.getParameter(request, "fm_ecc_cd", length));
			String[] to_ecc_cd          =  (JSPUtil.getParameter(request, "to_ecc_cd", length));
			String[] fm_etd_dt          =  (JSPUtil.getParameter(request, "fm_etd_dt", length));
			String[] to_eta_dt          =  (JSPUtil.getParameter(request, "to_eta_dt", length));
			String[] tablenm            =  (JSPUtil.getParameter(request, "tablenm", length));
			List<String[]> cntr_tpsz_cd_arr    =  new ArrayList<String[]>();
			List<String[]> cntr_qty_arr       	=  new ArrayList<String[]>();
			List<String[]> cost_amt_arr =  new ArrayList<String[]>();
			for (int k = 0 ; k < prefix.length ; k++) {
				String[] qtyArr = (JSPUtil.getParameter(request, prefix[k].toLowerCase() + "cntr_qty", length));
				String[] amtArr = (JSPUtil.getParameter(request, prefix[k].toLowerCase() + "cost_amt", length));
				
				cntr_tpsz_cd_arr.add(prefix);
				cntr_qty_arr.add(qtyArr);
				cost_amt_arr.add(amtArr);
			}
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0048MultiVO();
				
				model.setIbflag            		  ( ibflag            	[i]);
				model.setRepoPlnId       		  ( repo_pln_id       	[i]);
				model.setPlnYrwk          		  ( pln_yrwk          	[i]);
				
				if(tablenm[i].equals("EQR_VSL_LODG_DCHG_PLN")){
					model.setVslLaneCd       		  ( vsl_lane_cd       	[i]);					
					model.setVslCd            		  ( vvd[i].substring(0,4));
					model.setSkdVoyNo        		  ( vvd[i].substring(4,vvd[i].length()-1));
					model.setSkdDirCd        		  ( vvd[i].substring(vvd[i].length()-1,vvd[i].length()));
				}else{
					model.setVslLaneCd       		  ("");					
					model.setVslCd            		  ("");
					model.setSkdVoyNo        		  ("");
					model.setSkdDirCd        		  ("");
				}
				
				model.setFmEtdDt         		  ( fm_etd_dt         	[i]);
				model.setToEtaDt         		  ( to_eta_dt         	[i]);
				model.setFmEccCd         		  ( fm_ecc_cd         	[i]);					
				model.setToEccCd         		  ( to_ecc_cd         	[i]);
				model.setTrspModCd       		  ( trsp_mod_cd       	[i]);
				model.setItem       		  	  ( item       	[i]);
				model.setTablenm            		  ( tablenm            	[i]);
				
				List<String> cntr_tpsz_cd = new ArrayList<String>();
				List<String> cntr_qty = new ArrayList<String>();
				List<String> cost_amt = new ArrayList<String>();
				for (int k=0 ; k < prefix.length ; k++){
					String[] cntrQtyArr  = (String[])cntr_qty_arr.get(k);
					String[] costAmtArr  = (String[])cost_amt_arr.get(k);
					
					cntr_tpsz_cd.add(prefix[k]);
					cntr_qty.add(cntrQtyArr[i]);
					cost_amt.add(costAmtArr[i]);
				}
				model.setCntrTpszCd(cntr_tpsz_cd);
				model.setCntrQty(cntr_qty);
				model.setCostAmt(cost_amt);
				
				models.add(model);
			}
		} catch (Exception ex) {
			return null;
		}
		return getEesEqr0048MultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0048MultiVO[]
	 */
	public EesEqr0048MultiVO[] getEesEqr0048MultiVOs(){
		EesEqr0048MultiVO[] vos = (EesEqr0048MultiVO[])models.toArray(new EesEqr0048MultiVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCd = this.toEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tablenm = this.tablenm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCd = this.fmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtaDt = this.toEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt = this.fmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
