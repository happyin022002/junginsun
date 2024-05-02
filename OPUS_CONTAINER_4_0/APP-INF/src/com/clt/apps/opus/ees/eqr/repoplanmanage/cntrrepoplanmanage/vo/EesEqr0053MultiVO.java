/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0053MultiVO.java
*@FileTitle : EesEqr0053MultiVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		Lee Byoung Hun				2009.09.08		1.0 최초 생성
*
*@LastModifyDate : 2009.09.08
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

public class EesEqr0053MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0053MultiVO> models = new ArrayList<EesEqr0053MultiVO>();
	
	/* Column Info */
	private String repoPlnId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String onfHirDivCd = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String cntrLstmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private List<String> cntrTpszCd = null;
	/* Column Info */
	private List<String> cntrQty = null;
	/* Column Info */
	private List<String> onfHirCostAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0053MultiVO() {}

	public EesEqr0053MultiVO(String ibflag, String pagerows, String repoPlnId, String plnYrwk, String plnSeq, String onfHirDivCd, String eccCd, String cntrLstmCd) {
		this.repoPlnId = repoPlnId;
		this.ibflag = ibflag;
		this.onfHirDivCd = onfHirDivCd;
		this.eccCd = eccCd;
		this.plnSeq = plnSeq;
		this.plnYrwk = plnYrwk;
		this.cntrLstmCd = cntrLstmCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("onf_hir_div_cd", getOnfHirDivCd());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("cntr_lstm_cd", getCntrLstmCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("onf_hir_div_cd", "onfHirDivCd");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("cntr_lstm_cd", "cntrLstmCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
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
	 * @return onfHirDivCd
	 */
	public String getOnfHirDivCd() {
		return this.onfHirDivCd;
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
	 * @return plnSeq
	 */
	public String getPlnSeq() {
		return this.plnSeq;
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
	 * @return cntrLstmCd
	 */
	public String getCntrLstmCd() {
		return this.cntrLstmCd;
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
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
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
	 * @param onfHirDivCd
	 */
	public void setOnfHirDivCd(String onfHirDivCd) {
		this.onfHirDivCd = onfHirDivCd;
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
	 * @param plnSeq
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
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
	 * @param cntrLstmCd
	 */
	public void setCntrLstmCd(String cntrLstmCd) {
		this.cntrLstmCd = cntrLstmCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @return the onfHirCostAmt
	 */
	public List<String> getOnfHirCostAmt() {
		return onfHirCostAmt;
	}

	/**
	 * @param onfHirCostAmt the onfHirCostAmt to set
	 */
	public void setOnfHirCostAmt(List<String> onfHirCostAmt) {
		this.onfHirCostAmt = onfHirCostAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOnfHirDivCd(JSPUtil.getParameter(request, "onf_hir_div_cd", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setCntrLstmCd(JSPUtil.getParameter(request, "cntr_lstm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0053MultiVO[]
	 */
	public EesEqr0053MultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0053MultiVO[]
	 */
	public EesEqr0053MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0053MultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] onfHirDivCd = (JSPUtil.getParameter(request, prefix	+ "onf_hir_div_cd", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] cntrLstmCd = (JSPUtil.getParameter(request, prefix	+ "cntr_lstm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0053MultiVO();
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (onfHirDivCd[i] != null)
					model.setOnfHirDivCd(onfHirDivCd[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (cntrLstmCd[i] != null)
					model.setCntrLstmCd(cntrLstmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0053MultiVOs();
	}
	
	/**
	 * EES_EQR_0053 컨테이너 수급 예측실적 및 정확도 조회 화면에서 사용함.
	 * 
	 * @param request
	 * @param pirfix
	 * @return
	 */
	public EesEqr0053MultiVO[] fromRequestGridArrayList(HttpServletRequest request,String pirfix) {
		EesEqr0053MultiVO model = null;
		int length = request.getParameterValues("ibflag").length;
		String[] prefix = null;
		
		if (!(pirfix.equals(""))){
        	prefix = pirfix.split(",");
        }else{
        }
		
		try {
			String[] ibflag         =  (JSPUtil.getParameter(request, "ibflag", length));
			String[] repo_pln_id    =  (JSPUtil.getParameter(request, "repo_pln_id", length));
			String[] pln_yrwk       =  (JSPUtil.getParameter(request, "pln_yrwk", length));
			String[] pln_seq       =  (JSPUtil.getParameter(request, "pln_seq", length));
			String[] onf_hir_div_cd =  (JSPUtil.getParameter(request, "onf_hir_div_cd", length));
			String[] ecc_cd         =  (JSPUtil.getParameter(request, "ecc_cd", length));
			String[] cntr_lstm_cd   =  (JSPUtil.getParameter(request, "cntr_lstm_cd", length));
			List<String[]> cntr_tpsz_cd_arr    =  new ArrayList<String[]>();
			List<String[]> cntr_qty_arr       	=  new ArrayList<String[]>();
			List<String[]> onf_hir_cost_amt_arr =  new ArrayList<String[]>();
			for (int k = 0 ; k < prefix.length ; k++) {
				String[] qtyArr = (JSPUtil.getParameter(request, prefix[k].toLowerCase() + "cntr_qty", length));
				String[] amtArr = (JSPUtil.getParameter(request, prefix[k].toLowerCase() + "onf_hir_cost_amt", length));
				
				cntr_tpsz_cd_arr.add(prefix);
				cntr_qty_arr.add(qtyArr);
				onf_hir_cost_amt_arr.add(amtArr);
			}
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0053MultiVO();
				model.setIbflag        		  ( ibflag        	[i]);
				model.setRepoPlnId   		  ( repo_pln_id   	[i]);
				model.setPlnYrwk      		  ( pln_yrwk      	[i]);
				model.setPlnSeq      		  ( pln_seq      	[i]);
				model.setOnfHirDivCd		  ( onf_hir_div_cd	[i]);
				model.setEccCd        		  ( ecc_cd        	[i]);
				model.setCntrLstmCd  		  ( cntr_lstm_cd  	[i]);
				
				List<String> cntr_tpsz_cd = new ArrayList<String>();
				List<String> cntr_qty = new ArrayList<String>();
				List<String> onf_hir_cost_amt = new ArrayList<String>();
				for (int k=0 ; k < prefix.length ; k++){
					String[] cntrQtyArr  = (String[])cntr_qty_arr.get(k);
					String[] onfHirCostAmtArr  = (String[])onf_hir_cost_amt_arr.get(k);
					
					cntr_tpsz_cd.add(prefix[k]);
					cntr_qty.add(cntrQtyArr[i]);
					onf_hir_cost_amt.add(onfHirCostAmtArr[i]);
				}
				model.setCntrTpszCd(cntr_tpsz_cd);
				model.setCntrQty(cntr_qty);
				model.setOnfHirCostAmt(onf_hir_cost_amt);
				
				models.add(model);
			}
		} catch (Exception ex) {
			return null;
		}
		return getEesEqr0053MultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0053MultiVO[]
	 */
	public EesEqr0053MultiVO[] getEesEqr0053MultiVOs(){
		EesEqr0053MultiVO[] vos = (EesEqr0053MultiVO[])models.toArray(new EesEqr0053MultiVO[models.size()]);
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
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onfHirDivCd = this.onfHirDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLstmCd = this.cntrLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
