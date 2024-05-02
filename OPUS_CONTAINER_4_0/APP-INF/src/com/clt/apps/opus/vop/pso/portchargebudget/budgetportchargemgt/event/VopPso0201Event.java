/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0201Event.java
*@FileTitle : Expense Plan Per VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.06 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.BudEstDtlCondVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PsoMsaVO;


/**
 * VOP_PSO-0201 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0201HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0201HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0201Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaVO psoMsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;

	/** 팝업조회조건 yyyyMm*/
	private String yyyyMm = "";

	/** 팝업조회조건 vvdCd*/
	private String vvdCd = "";

	/** acctNo */
	private String acctNo = "";
	/** laneCd */
	private String laneCd = "";
	
	/**
	 * laneCd의 getter
	 * @return
	 */
	public String getLaneCd() {
		return laneCd;
	}
	/** creDtFr */
	private String creDtFr = "";
	/**
	 * creDtFr의 getter
	 * @return
	 */
	public String getCreDtFr() {
		return creDtFr;
	}
	/** creDtTo */
	private String creDtTo = "";

	/** 조회 용 VO **/
	private BudEstDtlCondVO budEstDtlCondVO;
	
	/**
	 * 조회 조건 VO getter
	 * @return
	 */
	public BudEstDtlCondVO getBudEstDtlCondVO() {
		return budEstDtlCondVO;
	}

	/**
	 * creDtTo 의 getter
	 * @return
	 */
	public String getCreDtTo() {
		return creDtTo;
	}

	/**
	 * acctNo의 getter
	 * @return
	 */
	public String getAcctNo() {
		return acctNo;
	}

	public VopPso0201Event(){}
	
	/**
	 * yyyyMm getter
	 * @return
	 */
	public String getYyyyMm() {
		// TODO Auto-generated method stub
		return this.yyyyMm;
	}
	/**
	 * yyyyMm setter
	 * @param yyyyMm
	 */
	public void setYyyyMm(String yyyyMm) {
		this.yyyyMm = yyyyMm;
	}

	/**
	 * vvdCd setter
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	/**
	 * vvdCd getter
	 * @return
	 */
	public String getVvdCd() {
		// TODO Auto-generated method stub
		return this.vvdCd;
	}
	
	public void setPsoMsaVO(PsoMsaVO psoMsaVO){
		this. psoMsaVO = psoMsaVO;
	}

	public void setPsoMsaVOS(PsoMsaVO[] psoMsaVOs){
		if (psoMsaVOs != null) {
			PsoMsaVO[] tmpVOs = new PsoMsaVO[psoMsaVOs.length];
			System.arraycopy(psoMsaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.psoMsaVOs = tmpVOs;
		}
	}

	public PsoMsaVO getPsoMsaVO(){
		return psoMsaVO;
	}

	public PsoMsaVO[] getPsoMsaVOS(){
		PsoMsaVO[] tmpVOs = null;
		if (this.psoMsaVOs != null) {
			tmpVOs = new PsoMsaVO[psoMsaVOs.length];
			System.arraycopy(psoMsaVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * acctNo의 setter
	 * @param acctNo
	 */
	public void setAcctNo(String acctNo) {
		// TODO Auto-generated method stub
		this.acctNo  = acctNo;
	}
	/**
	 * laneCd 의 setter
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		// TODO Auto-generated method stub
		this.laneCd = laneCd;
	}
	/**
	 * creDtFr의 setter
	 * @param creDtFr
	 */
	public void setCreDtFr(String creDtFr) {
		// TODO Auto-generated method stub
		this.creDtFr = creDtFr;
	}
	/**
	 * creDtTo의 setter
	 * @param creDtTo
	 */
	public void setCreDtTo(String creDtTo) {
		// TODO Auto-generated method stub
		this.creDtTo = creDtTo;		
	}

	/**
	 * 조회 조건 VO setter
	 * @param budEstDtlCondVO
	 */
	public void setBudEstDtlCondVO(BudEstDtlCondVO budEstDtlCondVO) {
		// TODO Auto-generated method stub
		this.budEstDtlCondVO = budEstDtlCondVO;
	}

	

}