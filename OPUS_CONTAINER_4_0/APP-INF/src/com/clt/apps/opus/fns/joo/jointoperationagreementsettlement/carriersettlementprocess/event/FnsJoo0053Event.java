/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0053Event.java
*@FileTitle : Other VVD Check
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.23 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ManualStlVvdVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0053HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ManualStlVvdVO manualStlVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ManualStlVvdVO[] manualStlVvdVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ProcSettlementVO procSettlementVO = null;
	
	public FnsJoo0053Event(){}
	
	public void setManualStlVvdVO(ManualStlVvdVO manualStlVvdVO){
		this. manualStlVvdVO = manualStlVvdVO;
	}

	public void setManualStlVvdVOS(ManualStlVvdVO[] manualStlVvdVOs){
		if (manualStlVvdVOs != null) {
			ManualStlVvdVO[] tmpVOs = new ManualStlVvdVO[manualStlVvdVOs.length];
			System.arraycopy(manualStlVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.manualStlVvdVOs = tmpVOs;
		}
	}

	public ManualStlVvdVO getManualStlVvdVO(){
		return manualStlVvdVO;
	}

	public ManualStlVvdVO[] getManualStlVvdVOS(){
		ManualStlVvdVO[] tmpVOs = null;
		if (this.manualStlVvdVOs != null) {
			tmpVOs = new ManualStlVvdVO[manualStlVvdVOs.length];
			System.arraycopy(manualStlVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public ProcSettlementVO getProcSettlementVO() {
		return procSettlementVO;
	}

	public void setProcSettlementVO(ProcSettlementVO procSettlementVO) {
		this.procSettlementVO = procSettlementVO;
	}
}