/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmCoa0019Event.java
*@FileTitle : General Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.02.23 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.genexpense.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaDmdtN3rdPtyVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUGMIN
 * @see ESM_COA_0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVOs = null;

	public EsmCoa0019Event(){}
	
	public void setCoaDmdtN3rdPtyVO(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO){
		this. coaDmdtN3rdPtyVO = coaDmdtN3rdPtyVO;
	}
	//SJH.20150508.소스품질
	public void setCoaDmdtN3rdPtyVOS(CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVOs){
		if(coaDmdtN3rdPtyVOs != null){
			CoaDmdtN3rdPtyVO[] tmpVOs = Arrays.copyOf(coaDmdtN3rdPtyVOs, coaDmdtN3rdPtyVOs.length);
			this.coaDmdtN3rdPtyVOs = tmpVOs;
		}
	}

	public CoaDmdtN3rdPtyVO getCoaDmdtN3rdPtyVO(){
		return coaDmdtN3rdPtyVO;
	}
	//SJH.20150508.소스품질
	public CoaDmdtN3rdPtyVO[] getCoaDmdtN3rdPtyVOS(){
		CoaDmdtN3rdPtyVO[] rtnVOs = null;
		if (this.coaDmdtN3rdPtyVOs != null) {
			rtnVOs = Arrays.copyOf(coaDmdtN3rdPtyVOs, coaDmdtN3rdPtyVOs.length);
		}
		return rtnVOs;
	}

}