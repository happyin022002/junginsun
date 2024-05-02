/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualBatchResultManualInputListVO.java
*@FileTitle : SearchAccrualBatchResultManualInputListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.26 전재홍 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전재홍
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualBatchResultManualInputListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchResultManualInputListVO> models = new ArrayList<SearchAccrualBatchResultManualInputListVO>();
	
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String estmCostAmtI = null;
	/* Column Info */
	private String estmCostAmtH = null;
	/* Column Info */
	private String estmCostAmtK = null;
	/* Column Info */
	private String estmCostAmtJ = null;
	/* Column Info */
	private String estmCostAmtD = null;
	/* Column Info */
	private String estmCostAmtG = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String estmCostAmtF = null;
	/* Column Info */
	private String actCostAmtB = null;
	/* Column Info */
	private String actCostAmtA = null;
	/* Column Info */
	private String estmCostAmtA = null;
	/* Column Info */
	private String estmCostAmtB = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCostAmtD = null;
	/* Column Info */
	private String estmCostAmtC = null;
	/* Column Info */
	private String actCostAmtC = null;
	/* Column Info */
	private String actCostAmtF = null;
	/* Column Info */
	private String actCostAmtH = null;
	/* Column Info */
	private String actCostAmtG = null;
	/* Column Info */
	private String ibflagF = null;
	/* Column Info */
	private String ibflagG = null;
	/* Column Info */
	private String ibflagH = null;
	/* Column Info */
	private String ibflagI = null;
	/* Column Info */
	private String ibflagJ = null;
	/* Column Info */
	private String ibflagK = null;
	/* Column Info */
	private String ibflagD = null;
	/* Column Info */
	private String ibflagC = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String ibflagB = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String ibflagA = null;
	/* Column Info */
	private String actCostAmtK = null;
	/* Column Info */
	private String actCostAmtI = null;
	/* Column Info */
	private String actCostAmtJ = null;
	/* Column Info */
	private String acclCostAmtJ = null;
	/* Column Info */
	private String acclCostAmtK = null;
	/* Column Info */
	private String acclCostAmtH = null;
	/* Column Info */
	private String acclCostAmtI = null;
	/* Column Info */
	private String acclCostAmtF = null;
	/* Column Info */
	private String acclCostAmtG = null;
	/* Column Info */
	private String acclCostAmtD = null;
	/* Column Info */
	private String acclCostAmtB = null;
	/* Column Info */
	private String acclCostAmtC = null;
	/* Column Info */
	private String acclCostAmtA = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchResultManualInputListVO() {}

	public SearchAccrualBatchResultManualInputListVO(String ibflag, String pagerows, String exeYrmon, String revYrmon, String ibflagA, String estmCostAmtA, String actCostAmtA, String acclCostAmtA, String ibflagB, String estmCostAmtB, String actCostAmtB, String acclCostAmtB, String ibflagC, String estmCostAmtC, String actCostAmtC, String acclCostAmtC, String ibflagD, String estmCostAmtD, String actCostAmtD, String acclCostAmtD, String ibflagF, String estmCostAmtF, String actCostAmtF, String acclCostAmtF, String ibflagG, String estmCostAmtG, String actCostAmtG, String acclCostAmtG, String ibflagH, String estmCostAmtH, String actCostAmtH, String acclCostAmtH, String ibflagI, String estmCostAmtI, String actCostAmtI, String acclCostAmtI, String ibflagJ, String estmCostAmtJ, String actCostAmtJ, String acclCostAmtJ, String ibflagK, String estmCostAmtK, String actCostAmtK, String acclCostAmtK) {
		this.estmCostAmtI = estmCostAmtI;
		this.estmCostAmtH = estmCostAmtH;
		this.estmCostAmtK = estmCostAmtK;
		this.estmCostAmtJ = estmCostAmtJ;
		this.estmCostAmtD = estmCostAmtD;
		this.estmCostAmtG = estmCostAmtG;
		this.pagerows = pagerows;
		this.estmCostAmtF = estmCostAmtF;
		this.actCostAmtB = actCostAmtB;
		this.actCostAmtA = actCostAmtA;
		this.estmCostAmtA = estmCostAmtA;
		this.estmCostAmtB = estmCostAmtB;
		this.ibflag = ibflag;
		this.actCostAmtD = actCostAmtD;
		this.estmCostAmtC = estmCostAmtC;
		this.actCostAmtC = actCostAmtC;
		this.actCostAmtF = actCostAmtF;
		this.actCostAmtH = actCostAmtH;
		this.actCostAmtG = actCostAmtG;
		this.ibflagF = ibflagF;
		this.ibflagG = ibflagG;
		this.ibflagH = ibflagH;
		this.ibflagI = ibflagI;
		this.ibflagJ = ibflagJ;
		this.ibflagK = ibflagK;
		this.ibflagD = ibflagD;
		this.ibflagC = ibflagC;
		this.revYrmon = revYrmon;
		this.ibflagB = ibflagB;
		this.exeYrmon = exeYrmon;
		this.ibflagA = ibflagA;
		this.actCostAmtK = actCostAmtK;
		this.actCostAmtI = actCostAmtI;
		this.actCostAmtJ = actCostAmtJ;
		this.acclCostAmtJ = acclCostAmtJ;
		this.acclCostAmtK = acclCostAmtK;
		this.acclCostAmtH = acclCostAmtH;
		this.acclCostAmtI = acclCostAmtI;
		this.acclCostAmtF = acclCostAmtF;
		this.acclCostAmtG = acclCostAmtG;
		this.acclCostAmtD = acclCostAmtD;
		this.acclCostAmtB = acclCostAmtB;
		this.acclCostAmtC = acclCostAmtC;
		this.acclCostAmtA = acclCostAmtA;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("estm_cost_amt_i", getEstmCostAmtI());
		this.hashColumns.put("estm_cost_amt_h", getEstmCostAmtH());
		this.hashColumns.put("estm_cost_amt_k", getEstmCostAmtK());
		this.hashColumns.put("estm_cost_amt_j", getEstmCostAmtJ());
		this.hashColumns.put("estm_cost_amt_d", getEstmCostAmtD());
		this.hashColumns.put("estm_cost_amt_g", getEstmCostAmtG());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("estm_cost_amt_f", getEstmCostAmtF());
		this.hashColumns.put("act_cost_amt_b", getActCostAmtB());
		this.hashColumns.put("act_cost_amt_a", getActCostAmtA());
		this.hashColumns.put("estm_cost_amt_a", getEstmCostAmtA());
		this.hashColumns.put("estm_cost_amt_b", getEstmCostAmtB());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cost_amt_d", getActCostAmtD());
		this.hashColumns.put("estm_cost_amt_c", getEstmCostAmtC());
		this.hashColumns.put("act_cost_amt_c", getActCostAmtC());
		this.hashColumns.put("act_cost_amt_f", getActCostAmtF());
		this.hashColumns.put("act_cost_amt_h", getActCostAmtH());
		this.hashColumns.put("act_cost_amt_g", getActCostAmtG());
		this.hashColumns.put("ibflag_f", getIbflagF());
		this.hashColumns.put("ibflag_g", getIbflagG());
		this.hashColumns.put("ibflag_h", getIbflagH());
		this.hashColumns.put("ibflag_i", getIbflagI());
		this.hashColumns.put("ibflag_j", getIbflagJ());
		this.hashColumns.put("ibflag_k", getIbflagK());
		this.hashColumns.put("ibflag_d", getIbflagD());
		this.hashColumns.put("ibflag_c", getIbflagC());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("ibflag_b", getIbflagB());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("ibflag_a", getIbflagA());
		this.hashColumns.put("act_cost_amt_k", getActCostAmtK());
		this.hashColumns.put("act_cost_amt_i", getActCostAmtI());
		this.hashColumns.put("act_cost_amt_j", getActCostAmtJ());
		this.hashColumns.put("accl_cost_amt_j", getAcclCostAmtJ());
		this.hashColumns.put("accl_cost_amt_k", getAcclCostAmtK());
		this.hashColumns.put("accl_cost_amt_h", getAcclCostAmtH());
		this.hashColumns.put("accl_cost_amt_i", getAcclCostAmtI());
		this.hashColumns.put("accl_cost_amt_f", getAcclCostAmtF());
		this.hashColumns.put("accl_cost_amt_g", getAcclCostAmtG());
		this.hashColumns.put("accl_cost_amt_d", getAcclCostAmtD());
		this.hashColumns.put("accl_cost_amt_b", getAcclCostAmtB());
		this.hashColumns.put("accl_cost_amt_c", getAcclCostAmtC());
		this.hashColumns.put("accl_cost_amt_a", getAcclCostAmtA());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("estm_cost_amt_i", "estmCostAmtI");
		this.hashFields.put("estm_cost_amt_h", "estmCostAmtH");
		this.hashFields.put("estm_cost_amt_k", "estmCostAmtK");
		this.hashFields.put("estm_cost_amt_j", "estmCostAmtJ");
		this.hashFields.put("estm_cost_amt_d", "estmCostAmtD");
		this.hashFields.put("estm_cost_amt_g", "estmCostAmtG");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("estm_cost_amt_f", "estmCostAmtF");
		this.hashFields.put("act_cost_amt_b", "actCostAmtB");
		this.hashFields.put("act_cost_amt_a", "actCostAmtA");
		this.hashFields.put("estm_cost_amt_a", "estmCostAmtA");
		this.hashFields.put("estm_cost_amt_b", "estmCostAmtB");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cost_amt_d", "actCostAmtD");
		this.hashFields.put("estm_cost_amt_c", "estmCostAmtC");
		this.hashFields.put("act_cost_amt_c", "actCostAmtC");
		this.hashFields.put("act_cost_amt_f", "actCostAmtF");
		this.hashFields.put("act_cost_amt_h", "actCostAmtH");
		this.hashFields.put("act_cost_amt_g", "actCostAmtG");
		this.hashFields.put("ibflag_f", "ibflagF");
		this.hashFields.put("ibflag_g", "ibflagG");
		this.hashFields.put("ibflag_h", "ibflagH");
		this.hashFields.put("ibflag_i", "ibflagI");
		this.hashFields.put("ibflag_j", "ibflagJ");
		this.hashFields.put("ibflag_k", "ibflagK");
		this.hashFields.put("ibflag_d", "ibflagD");
		this.hashFields.put("ibflag_c", "ibflagC");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("ibflag_b", "ibflagB");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("ibflag_a", "ibflagA");
		this.hashFields.put("act_cost_amt_k", "actCostAmtK");
		this.hashFields.put("act_cost_amt_i", "actCostAmtI");
		this.hashFields.put("act_cost_amt_j", "actCostAmtJ");
		this.hashFields.put("accl_cost_amt_j", "acclCostAmtJ");
		this.hashFields.put("accl_cost_amt_k", "acclCostAmtK");
		this.hashFields.put("accl_cost_amt_h", "acclCostAmtH");
		this.hashFields.put("accl_cost_amt_i", "acclCostAmtI");
		this.hashFields.put("accl_cost_amt_f", "acclCostAmtF");
		this.hashFields.put("accl_cost_amt_g", "acclCostAmtG");
		this.hashFields.put("accl_cost_amt_d", "acclCostAmtD");
		this.hashFields.put("accl_cost_amt_b", "acclCostAmtB");
		this.hashFields.put("accl_cost_amt_c", "acclCostAmtC");
		this.hashFields.put("accl_cost_amt_a", "acclCostAmtA");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmtI
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmtI
	 */
	public String getEstmCostAmtI() {
		return this.estmCostAmtI;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmtH
	 */
	public String getEstmCostAmtH() {
		return this.estmCostAmtH;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmtK
	 */
	public String getEstmCostAmtK() {
		return this.estmCostAmtK;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmtJ
	 */
	public String getEstmCostAmtJ() {
		return this.estmCostAmtJ;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmtD
	 */
	public String getEstmCostAmtD() {
		return this.estmCostAmtD;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmtG
	 */
	public String getEstmCostAmtG() {
		return this.estmCostAmtG;
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
	 * @return estmCostAmtF
	 */
	public String getEstmCostAmtF() {
		return this.estmCostAmtF;
	}
	
	/**
	 * Column Info
	 * @return actCostAmtB
	 */
	public String getActCostAmtB() {
		return this.actCostAmtB;
	}
	
	/**
	 * Column Info
	 * @return actCostAmtA
	 */
	public String getActCostAmtA() {
		return this.actCostAmtA;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmtA
	 */
	public String getEstmCostAmtA() {
		return this.estmCostAmtA;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmtB
	 */
	public String getEstmCostAmtB() {
		return this.estmCostAmtB;
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
	 * @return actCostAmtD
	 */
	public String getActCostAmtD() {
		return this.actCostAmtD;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmtC
	 */
	public String getEstmCostAmtC() {
		return this.estmCostAmtC;
	}
	
	/**
	 * Column Info
	 * @return actCostAmtC
	 */
	public String getActCostAmtC() {
		return this.actCostAmtC;
	}
	
	/**
	 * Column Info
	 * @return actCostAmtF
	 */
	public String getActCostAmtF() {
		return this.actCostAmtF;
	}
	
	/**
	 * Column Info
	 * @return actCostAmtH
	 */
	public String getActCostAmtH() {
		return this.actCostAmtH;
	}
	
	/**
	 * Column Info
	 * @return actCostAmtG
	 */
	public String getActCostAmtG() {
		return this.actCostAmtG;
	}
	
	/**
	 * Column Info
	 * @return ibflagF
	 */
	public String getIbflagF() {
		return this.ibflagF;
	}
	
	/**
	 * Column Info
	 * @return ibflagG
	 */
	public String getIbflagG() {
		return this.ibflagG;
	}
	
	/**
	 * Column Info
	 * @return ibflagH
	 */
	public String getIbflagH() {
		return this.ibflagH;
	}
	
	/**
	 * Column Info
	 * @return ibflagI
	 */
	public String getIbflagI() {
		return this.ibflagI;
	}
	
	/**
	 * Column Info
	 * @return ibflagJ
	 */
	public String getIbflagJ() {
		return this.ibflagJ;
	}
	
	/**
	 * Column Info
	 * @return ibflagK
	 */
	public String getIbflagK() {
		return this.ibflagK;
	}
	
	/**
	 * Column Info
	 * @return ibflagD
	 */
	public String getIbflagD() {
		return this.ibflagD;
	}
	
	/**
	 * Column Info
	 * @return ibflagC
	 */
	public String getIbflagC() {
		return this.ibflagC;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return ibflagB
	 */
	public String getIbflagB() {
		return this.ibflagB;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return ibflagA
	 */
	public String getIbflagA() {
		return this.ibflagA;
	}
	
	/**
	 * Column Info
	 * @return actCostAmtK
	 */
	public String getActCostAmtK() {
		return this.actCostAmtK;
	}
	
	/**
	 * Column Info
	 * @return actCostAmtI
	 */
	public String getActCostAmtI() {
		return this.actCostAmtI;
	}
	
	/**
	 * Column Info
	 * @return actCostAmtJ
	 */
	public String getActCostAmtJ() {
		return this.actCostAmtJ;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmtJ
	 */
	public String getAcclCostAmtJ() {
		return this.acclCostAmtJ;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmtK
	 */
	public String getAcclCostAmtK() {
		return this.acclCostAmtK;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmtH
	 */
	public String getAcclCostAmtH() {
		return this.acclCostAmtH;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmtI
	 */
	public String getAcclCostAmtI() {
		return this.acclCostAmtI;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmtF
	 */
	public String getAcclCostAmtF() {
		return this.acclCostAmtF;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmtG
	 */
	public String getAcclCostAmtG() {
		return this.acclCostAmtG;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmtD
	 */
	public String getAcclCostAmtD() {
		return this.acclCostAmtD;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmtB
	 */
	public String getAcclCostAmtB() {
		return this.acclCostAmtB;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmtC
	 */
	public String getAcclCostAmtC() {
		return this.acclCostAmtC;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmtA
	 */
	public String getAcclCostAmtA() {
		return this.acclCostAmtA;
	}
	

	/**
	 * Column Info
	 * @param estmCostAmtI
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmtI
	 */
	public void setEstmCostAmtI(String estmCostAmtI) {
		this.estmCostAmtI = estmCostAmtI;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmtH
	 */
	public void setEstmCostAmtH(String estmCostAmtH) {
		this.estmCostAmtH = estmCostAmtH;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmtK
	 */
	public void setEstmCostAmtK(String estmCostAmtK) {
		this.estmCostAmtK = estmCostAmtK;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmtJ
	 */
	public void setEstmCostAmtJ(String estmCostAmtJ) {
		this.estmCostAmtJ = estmCostAmtJ;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmtD
	 */
	public void setEstmCostAmtD(String estmCostAmtD) {
		this.estmCostAmtD = estmCostAmtD;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmtG
	 */
	public void setEstmCostAmtG(String estmCostAmtG) {
		this.estmCostAmtG = estmCostAmtG;
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
	 * @param estmCostAmtF
	 */
	public void setEstmCostAmtF(String estmCostAmtF) {
		this.estmCostAmtF = estmCostAmtF;
	}
	
	/**
	 * Column Info
	 * @param actCostAmtB
	 */
	public void setActCostAmtB(String actCostAmtB) {
		this.actCostAmtB = actCostAmtB;
	}
	
	/**
	 * Column Info
	 * @param actCostAmtA
	 */
	public void setActCostAmtA(String actCostAmtA) {
		this.actCostAmtA = actCostAmtA;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmtA
	 */
	public void setEstmCostAmtA(String estmCostAmtA) {
		this.estmCostAmtA = estmCostAmtA;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmtB
	 */
	public void setEstmCostAmtB(String estmCostAmtB) {
		this.estmCostAmtB = estmCostAmtB;
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
	 * @param actCostAmtD
	 */
	public void setActCostAmtD(String actCostAmtD) {
		this.actCostAmtD = actCostAmtD;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmtC
	 */
	public void setEstmCostAmtC(String estmCostAmtC) {
		this.estmCostAmtC = estmCostAmtC;
	}
	
	/**
	 * Column Info
	 * @param actCostAmtC
	 */
	public void setActCostAmtC(String actCostAmtC) {
		this.actCostAmtC = actCostAmtC;
	}
	
	/**
	 * Column Info
	 * @param actCostAmtF
	 */
	public void setActCostAmtF(String actCostAmtF) {
		this.actCostAmtF = actCostAmtF;
	}
	
	/**
	 * Column Info
	 * @param actCostAmtH
	 */
	public void setActCostAmtH(String actCostAmtH) {
		this.actCostAmtH = actCostAmtH;
	}
	
	/**
	 * Column Info
	 * @param actCostAmtG
	 */
	public void setActCostAmtG(String actCostAmtG) {
		this.actCostAmtG = actCostAmtG;
	}
	
	/**
	 * Column Info
	 * @param ibflagF
	 */
	public void setIbflagF(String ibflagF) {
		this.ibflagF = ibflagF;
	}
	
	/**
	 * Column Info
	 * @param ibflagG
	 */
	public void setIbflagG(String ibflagG) {
		this.ibflagG = ibflagG;
	}
	
	/**
	 * Column Info
	 * @param ibflagH
	 */
	public void setIbflagH(String ibflagH) {
		this.ibflagH = ibflagH;
	}
	
	/**
	 * Column Info
	 * @param ibflagI
	 */
	public void setIbflagI(String ibflagI) {
		this.ibflagI = ibflagI;
	}
	
	/**
	 * Column Info
	 * @param ibflagJ
	 */
	public void setIbflagJ(String ibflagJ) {
		this.ibflagJ = ibflagJ;
	}
	
	/**
	 * Column Info
	 * @param ibflagK
	 */
	public void setIbflagK(String ibflagK) {
		this.ibflagK = ibflagK;
	}
	
	/**
	 * Column Info
	 * @param ibflagD
	 */
	public void setIbflagD(String ibflagD) {
		this.ibflagD = ibflagD;
	}
	
	/**
	 * Column Info
	 * @param ibflagC
	 */
	public void setIbflagC(String ibflagC) {
		this.ibflagC = ibflagC;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param ibflagB
	 */
	public void setIbflagB(String ibflagB) {
		this.ibflagB = ibflagB;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param ibflagA
	 */
	public void setIbflagA(String ibflagA) {
		this.ibflagA = ibflagA;
	}
	
	/**
	 * Column Info
	 * @param actCostAmtK
	 */
	public void setActCostAmtK(String actCostAmtK) {
		this.actCostAmtK = actCostAmtK;
	}
	
	/**
	 * Column Info
	 * @param actCostAmtI
	 */
	public void setActCostAmtI(String actCostAmtI) {
		this.actCostAmtI = actCostAmtI;
	}
	
	/**
	 * Column Info
	 * @param actCostAmtJ
	 */
	public void setActCostAmtJ(String actCostAmtJ) {
		this.actCostAmtJ = actCostAmtJ;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmtJ
	 */
	public void setAcclCostAmtJ(String acclCostAmtJ) {
		this.acclCostAmtJ = acclCostAmtJ;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmtK
	 */
	public void setAcclCostAmtK(String acclCostAmtK) {
		this.acclCostAmtK = acclCostAmtK;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmtH
	 */
	public void setAcclCostAmtH(String acclCostAmtH) {
		this.acclCostAmtH = acclCostAmtH;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmtI
	 */
	public void setAcclCostAmtI(String acclCostAmtI) {
		this.acclCostAmtI = acclCostAmtI;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmtF
	 */
	public void setAcclCostAmtF(String acclCostAmtF) {
		this.acclCostAmtF = acclCostAmtF;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmtG
	 */
	public void setAcclCostAmtG(String acclCostAmtG) {
		this.acclCostAmtG = acclCostAmtG;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmtD
	 */
	public void setAcclCostAmtD(String acclCostAmtD) {
		this.acclCostAmtD = acclCostAmtD;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmtB
	 */
	public void setAcclCostAmtB(String acclCostAmtB) {
		this.acclCostAmtB = acclCostAmtB;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmtC
	 */
	public void setAcclCostAmtC(String acclCostAmtC) {
		this.acclCostAmtC = acclCostAmtC;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmtA
	 */
	public void setAcclCostAmtA(String acclCostAmtA) {
		this.acclCostAmtA = acclCostAmtA;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEstmCostAmtI(JSPUtil.getParameter(request, "estm_cost_amt_i", ""));
		setEstmCostAmtH(JSPUtil.getParameter(request, "estm_cost_amt_h", ""));
		setEstmCostAmtK(JSPUtil.getParameter(request, "estm_cost_amt_k", ""));
		setEstmCostAmtJ(JSPUtil.getParameter(request, "estm_cost_amt_j", ""));
		setEstmCostAmtD(JSPUtil.getParameter(request, "estm_cost_amt_d", ""));
		setEstmCostAmtG(JSPUtil.getParameter(request, "estm_cost_amt_g", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEstmCostAmtF(JSPUtil.getParameter(request, "estm_cost_amt_f", ""));
		setActCostAmtB(JSPUtil.getParameter(request, "act_cost_amt_b", ""));
		setActCostAmtA(JSPUtil.getParameter(request, "act_cost_amt_a", ""));
		setEstmCostAmtA(JSPUtil.getParameter(request, "estm_cost_amt_a", ""));
		setEstmCostAmtB(JSPUtil.getParameter(request, "estm_cost_amt_b", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActCostAmtD(JSPUtil.getParameter(request, "act_cost_amt_d", ""));
		setEstmCostAmtC(JSPUtil.getParameter(request, "estm_cost_amt_c", ""));
		setActCostAmtC(JSPUtil.getParameter(request, "act_cost_amt_c", ""));
		setActCostAmtF(JSPUtil.getParameter(request, "act_cost_amt_f", ""));
		setActCostAmtH(JSPUtil.getParameter(request, "act_cost_amt_h", ""));
		setActCostAmtG(JSPUtil.getParameter(request, "act_cost_amt_g", ""));
		setIbflagF(JSPUtil.getParameter(request, "ibflag_f", ""));
		setIbflagG(JSPUtil.getParameter(request, "ibflag_g", ""));
		setIbflagH(JSPUtil.getParameter(request, "ibflag_h", ""));
		setIbflagI(JSPUtil.getParameter(request, "ibflag_i", ""));
		setIbflagJ(JSPUtil.getParameter(request, "ibflag_j", ""));
		setIbflagK(JSPUtil.getParameter(request, "ibflag_k", ""));
		setIbflagD(JSPUtil.getParameter(request, "ibflag_d", ""));
		setIbflagC(JSPUtil.getParameter(request, "ibflag_c", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setIbflagB(JSPUtil.getParameter(request, "ibflag_b", ""));
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setIbflagA(JSPUtil.getParameter(request, "ibflag_a", ""));
		setActCostAmtK(JSPUtil.getParameter(request, "act_cost_amt_k", ""));
		setActCostAmtI(JSPUtil.getParameter(request, "act_cost_amt_i", ""));
		setActCostAmtJ(JSPUtil.getParameter(request, "act_cost_amt_j", ""));
		setAcclCostAmtJ(JSPUtil.getParameter(request, "accl_cost_amt_j", ""));
		setAcclCostAmtK(JSPUtil.getParameter(request, "accl_cost_amt_k", ""));
		setAcclCostAmtH(JSPUtil.getParameter(request, "accl_cost_amt_h", ""));
		setAcclCostAmtI(JSPUtil.getParameter(request, "accl_cost_amt_i", ""));
		setAcclCostAmtF(JSPUtil.getParameter(request, "accl_cost_amt_f", ""));
		setAcclCostAmtG(JSPUtil.getParameter(request, "accl_cost_amt_g", ""));
		setAcclCostAmtD(JSPUtil.getParameter(request, "accl_cost_amt_d", ""));
		setAcclCostAmtB(JSPUtil.getParameter(request, "accl_cost_amt_b", ""));
		setAcclCostAmtC(JSPUtil.getParameter(request, "accl_cost_amt_c", ""));
		setAcclCostAmtA(JSPUtil.getParameter(request, "accl_cost_amt_a", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualBatchResultManualInputListVO[]
	 */
	public SearchAccrualBatchResultManualInputListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualBatchResultManualInputListVO[]
	 */
	public SearchAccrualBatchResultManualInputListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualBatchResultManualInputListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] estmCostAmtI = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt_i", length));
			String[] estmCostAmtH = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt_h", length));
			String[] estmCostAmtK = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt_k", length));
			String[] estmCostAmtJ = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt_j", length));
			String[] estmCostAmtD = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt_d", length));
			String[] estmCostAmtG = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt_g", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] estmCostAmtF = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt_f", length));
			String[] actCostAmtB = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt_b", length));
			String[] actCostAmtA = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt_a", length));
			String[] estmCostAmtA = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt_a", length));
			String[] estmCostAmtB = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt_b", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCostAmtD = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt_d", length));
			String[] estmCostAmtC = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt_c", length));
			String[] actCostAmtC = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt_c", length));
			String[] actCostAmtF = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt_f", length));
			String[] actCostAmtH = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt_h", length));
			String[] actCostAmtG = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt_g", length));
			String[] ibflagF = (JSPUtil.getParameter(request, prefix	+ "ibflag_f", length));
			String[] ibflagG = (JSPUtil.getParameter(request, prefix	+ "ibflag_g", length));
			String[] ibflagH = (JSPUtil.getParameter(request, prefix	+ "ibflag_h", length));
			String[] ibflagI = (JSPUtil.getParameter(request, prefix	+ "ibflag_i", length));
			String[] ibflagJ = (JSPUtil.getParameter(request, prefix	+ "ibflag_j", length));
			String[] ibflagK = (JSPUtil.getParameter(request, prefix	+ "ibflag_k", length));
			String[] ibflagD = (JSPUtil.getParameter(request, prefix	+ "ibflag_d", length));
			String[] ibflagC = (JSPUtil.getParameter(request, prefix	+ "ibflag_c", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] ibflagB = (JSPUtil.getParameter(request, prefix	+ "ibflag_b", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] ibflagA = (JSPUtil.getParameter(request, prefix	+ "ibflag_a", length));
			String[] actCostAmtK = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt_k", length));
			String[] actCostAmtI = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt_i", length));
			String[] actCostAmtJ = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt_j", length));
			String[] acclCostAmtJ = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt_j", length));
			String[] acclCostAmtK = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt_k", length));
			String[] acclCostAmtH = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt_h", length));
			String[] acclCostAmtI = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt_i", length));
			String[] acclCostAmtF = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt_f", length));
			String[] acclCostAmtG = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt_g", length));
			String[] acclCostAmtD = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt_d", length));
			String[] acclCostAmtB = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt_b", length));
			String[] acclCostAmtC = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt_c", length));
			String[] acclCostAmtA = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt_a", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchResultManualInputListVO();
				if (estmCostAmtI[i] != null)
					model.setEstmCostAmtI(estmCostAmtI[i]);
				if (estmCostAmtH[i] != null)
					model.setEstmCostAmtH(estmCostAmtH[i]);
				if (estmCostAmtK[i] != null)
					model.setEstmCostAmtK(estmCostAmtK[i]);
				if (estmCostAmtJ[i] != null)
					model.setEstmCostAmtJ(estmCostAmtJ[i]);
				if (estmCostAmtD[i] != null)
					model.setEstmCostAmtD(estmCostAmtD[i]);
				if (estmCostAmtG[i] != null)
					model.setEstmCostAmtG(estmCostAmtG[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (estmCostAmtF[i] != null)
					model.setEstmCostAmtF(estmCostAmtF[i]);
				if (actCostAmtB[i] != null)
					model.setActCostAmtB(actCostAmtB[i]);
				if (actCostAmtA[i] != null)
					model.setActCostAmtA(actCostAmtA[i]);
				if (estmCostAmtA[i] != null)
					model.setEstmCostAmtA(estmCostAmtA[i]);
				if (estmCostAmtB[i] != null)
					model.setEstmCostAmtB(estmCostAmtB[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCostAmtD[i] != null)
					model.setActCostAmtD(actCostAmtD[i]);
				if (estmCostAmtC[i] != null)
					model.setEstmCostAmtC(estmCostAmtC[i]);
				if (actCostAmtC[i] != null)
					model.setActCostAmtC(actCostAmtC[i]);
				if (actCostAmtF[i] != null)
					model.setActCostAmtF(actCostAmtF[i]);
				if (actCostAmtH[i] != null)
					model.setActCostAmtH(actCostAmtH[i]);
				if (actCostAmtG[i] != null)
					model.setActCostAmtG(actCostAmtG[i]);
				if (ibflagF[i] != null)
					model.setIbflagF(ibflagF[i]);
				if (ibflagG[i] != null)
					model.setIbflagG(ibflagG[i]);
				if (ibflagH[i] != null)
					model.setIbflagH(ibflagH[i]);
				if (ibflagI[i] != null)
					model.setIbflagI(ibflagI[i]);
				if (ibflagJ[i] != null)
					model.setIbflagJ(ibflagJ[i]);
				if (ibflagK[i] != null)
					model.setIbflagK(ibflagK[i]);
				if (ibflagD[i] != null)
					model.setIbflagD(ibflagD[i]);
				if (ibflagC[i] != null)
					model.setIbflagC(ibflagC[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (ibflagB[i] != null)
					model.setIbflagB(ibflagB[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (ibflagA[i] != null)
					model.setIbflagA(ibflagA[i]);
				if (actCostAmtK[i] != null)
					model.setActCostAmtK(actCostAmtK[i]);
				if (actCostAmtI[i] != null)
					model.setActCostAmtI(actCostAmtI[i]);
				if (actCostAmtJ[i] != null)
					model.setActCostAmtJ(actCostAmtJ[i]);
				if (acclCostAmtJ[i] != null)
					model.setAcclCostAmtJ(acclCostAmtJ[i]);
				if (acclCostAmtK[i] != null)
					model.setAcclCostAmtK(acclCostAmtK[i]);
				if (acclCostAmtH[i] != null)
					model.setAcclCostAmtH(acclCostAmtH[i]);
				if (acclCostAmtI[i] != null)
					model.setAcclCostAmtI(acclCostAmtI[i]);
				if (acclCostAmtF[i] != null)
					model.setAcclCostAmtF(acclCostAmtF[i]);
				if (acclCostAmtG[i] != null)
					model.setAcclCostAmtG(acclCostAmtG[i]);
				if (acclCostAmtD[i] != null)
					model.setAcclCostAmtD(acclCostAmtD[i]);
				if (acclCostAmtB[i] != null)
					model.setAcclCostAmtB(acclCostAmtB[i]);
				if (acclCostAmtC[i] != null)
					model.setAcclCostAmtC(acclCostAmtC[i]);
				if (acclCostAmtA[i] != null)
					model.setAcclCostAmtA(acclCostAmtA[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualBatchResultManualInputListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualBatchResultManualInputListVO[]
	 */
	public SearchAccrualBatchResultManualInputListVO[] getSearchAccrualBatchResultManualInputListVOs(){
		SearchAccrualBatchResultManualInputListVO[] vos = (SearchAccrualBatchResultManualInputListVO[])models.toArray(new SearchAccrualBatchResultManualInputListVO[models.size()]);
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
		this.estmCostAmtI = this.estmCostAmtI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmtH = this.estmCostAmtH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmtK = this.estmCostAmtK .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmtJ = this.estmCostAmtJ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmtD = this.estmCostAmtD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmtG = this.estmCostAmtG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmtF = this.estmCostAmtF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmtB = this.actCostAmtB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmtA = this.actCostAmtA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmtA = this.estmCostAmtA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmtB = this.estmCostAmtB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmtD = this.actCostAmtD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmtC = this.estmCostAmtC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmtC = this.actCostAmtC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmtF = this.actCostAmtF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmtH = this.actCostAmtH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmtG = this.actCostAmtG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflagF = this.ibflagF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflagG = this.ibflagG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflagH = this.ibflagH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflagI = this.ibflagI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflagJ = this.ibflagJ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflagK = this.ibflagK .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflagD = this.ibflagD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflagC = this.ibflagC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflagB = this.ibflagB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflagA = this.ibflagA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmtK = this.actCostAmtK .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmtI = this.actCostAmtI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmtJ = this.actCostAmtJ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmtJ = this.acclCostAmtJ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmtK = this.acclCostAmtK .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmtH = this.acclCostAmtH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmtI = this.acclCostAmtI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmtF = this.acclCostAmtF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmtG = this.acclCostAmtG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmtD = this.acclCostAmtD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmtB = this.acclCostAmtB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmtC = this.acclCostAmtC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmtA = this.acclCostAmtA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
