/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0008Event.java
*@FileTitle : Budget Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.06.29 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.BudCreVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VSK_VSL_SKD;


/**
 * VOP_PSO-0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VSK_VSL_SKD vskVslSkd = null;
	
	/** Table Value Object Multi Data 처리 */
	private VSK_VSL_SKD[] vskVslSkds = null;

	/** 예산 년도 */
	private String budgetYear = null;

	/** 조회 조건 Start DT*/
	private String startDt;

	/** 조건 End Dt*/
	private String endDt;
	
	private BudCreVO[] budCreVOs = null;
	
	public BudCreVO[] getBudCreVOs() {
		BudCreVO[] tmpVOs = null;
		if (this.budCreVOs != null) {
			tmpVOs = new BudCreVO[budCreVOs.length];
			System.arraycopy(budCreVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setBudCreVOs(BudCreVO[] budCreVOs) {
		if (budCreVOs != null) {
			BudCreVO[] tmpVOs = new BudCreVO[budCreVOs.length];
			System.arraycopy(budCreVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.budCreVOs = tmpVOs;
		}
	}

	public String getEndDt() {
		return endDt;
	}

	public String getStartDt() {
		return startDt;
	}

	/**
	 * 예산 연도 getter
	 * @return budgetYear
	 */
	public String getBudgetYear() {
		return budgetYear;
	}

	public VopPso0008Event(){}
	
	public void setVSK_VSL_SKD(VSK_VSL_SKD vskVslSkd){
		this. vskVslSkd = vskVslSkd;
	}

	public void setVSK_VSL_SKDS(VSK_VSL_SKD[] vskVslSkds){
		if (vskVslSkds != null) {
			VSK_VSL_SKD[] tmpVOs = new VSK_VSL_SKD[vskVslSkds.length];
			System.arraycopy(vskVslSkds, 0, tmpVOs, 0, tmpVOs.length);
			this.vskVslSkds = tmpVOs;
		}
	}

	public VSK_VSL_SKD getVSK_VSL_SKD(){
		return vskVslSkd;
	}

	public VSK_VSL_SKD[] getVSK_VSL_SKDS(){
		VSK_VSL_SKD[] tmpVOs = null;
		if (this.vskVslSkds != null) {
			tmpVOs = new VSK_VSL_SKD[vskVslSkds.length];
			System.arraycopy(vskVslSkds, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 예산연도 Setter
	 * @param budgetYear
	 */
	public void setBudgetYear(String budgetYear) {
		// TODO Auto-generated method stub
		this.budgetYear = budgetYear;
		
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

}