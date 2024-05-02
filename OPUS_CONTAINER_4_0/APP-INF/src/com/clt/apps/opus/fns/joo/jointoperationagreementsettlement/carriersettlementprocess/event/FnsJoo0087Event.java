/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0087Event.java
*@FileTitle : Conversion Table
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.25 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionAndOptionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0087HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0087Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrConversionAndOptionVO cntrConversionAndOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrConversionAndOptionVO[] cntrConversionAndOptionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrConversionConditionVO cntrConversionConditionVO = null;

	public FnsJoo0087Event(){}

	public CntrConversionAndOptionVO getCntrConversionAndOptionVO() {
		return cntrConversionAndOptionVO;
	}

	public void setCntrConversionAndOptionVO(CntrConversionAndOptionVO cntrConversionAndOptionVO) {
		this.cntrConversionAndOptionVO = cntrConversionAndOptionVO;
	}

	public CntrConversionAndOptionVO[] getCntrConversionAndOptionVOs() {
		CntrConversionAndOptionVO[] tmpVOs = null;
		if (this.cntrConversionAndOptionVOs != null) {
			tmpVOs = new CntrConversionAndOptionVO[cntrConversionAndOptionVOs.length];
			System.arraycopy(cntrConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrConversionAndOptionVOs(CntrConversionAndOptionVO[] cntrConversionAndOptionVOs) {
		if (cntrConversionAndOptionVOs != null) {
			CntrConversionAndOptionVO[] tmpVOs = new CntrConversionAndOptionVO[cntrConversionAndOptionVOs.length];
			System.arraycopy(cntrConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrConversionAndOptionVOs = tmpVOs;
		}
	}

	public CntrConversionConditionVO getCntrConversionConditionVO() {
		return cntrConversionConditionVO;
	}

	public void setCntrConversionConditionVO(CntrConversionConditionVO cntrConversionConditionVO) {
		this.cntrConversionConditionVO = cntrConversionConditionVO;
	}
	

}