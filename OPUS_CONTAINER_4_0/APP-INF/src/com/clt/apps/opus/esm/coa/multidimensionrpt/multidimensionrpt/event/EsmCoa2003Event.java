/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmCoa2003Event.java
*@FileTitle : P/L Report Item Management 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.18
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.18 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.PnlRptItemVO;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_COA_2003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_2003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-Sun Moon
 * @see ESM_COA_2003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa2003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PnlRptItemVO pnlRptItemVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PnlRptItemVO[] pnlRptItemVOs = null;

	public EsmCoa2003Event(){}
	
	public void setPnlRptItemVO(PnlRptItemVO pnlRptItemVO){
		this. pnlRptItemVO = pnlRptItemVO;
	}
	
	//SJH.20150507.소스품질
	public void setPnlRptItemVOS(PnlRptItemVO[] pnlRptItemVOs){
		if(pnlRptItemVOs != null){
			PnlRptItemVO[] tmpVOs = Arrays.copyOf(pnlRptItemVOs, pnlRptItemVOs.length);
			this.pnlRptItemVOs = tmpVOs;
		}
	}

	public PnlRptItemVO getPnlRptItemVO(){
		return pnlRptItemVO;
	}
	
	//SJH.20150507.소스품질
	public PnlRptItemVO[] getPnlRptItemVOS(){
		PnlRptItemVO[] rtnVOs = null;
		if (this.pnlRptItemVOs != null) {
			rtnVOs = Arrays.copyOf(pnlRptItemVOs, pnlRptItemVOs.length);
		}
		return rtnVOs;
	}

}