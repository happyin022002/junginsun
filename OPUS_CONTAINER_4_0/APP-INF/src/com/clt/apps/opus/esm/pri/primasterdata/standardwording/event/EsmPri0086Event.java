/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0086Event.java
*@FileTitle : Standard Wording for S/C Notes - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.06 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.standardwording.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriScStndWdgVO;


/**
 * ESM_PRI_0086 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0086HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0086HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0086Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScStndWdgVO priScStndWdgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScStndWdgVO[] priScStndWdgVOs = null;

	public EsmPri0086Event(){}
	
	public void setPriScStndWdgVO(PriScStndWdgVO priScStndWdgVO){
		this. priScStndWdgVO = priScStndWdgVO;
	}

	public void setPriScStndWdgVOS(PriScStndWdgVO[] priScStndWdgVOs){
		if (priScStndWdgVOs != null) {
			PriScStndWdgVO[] tmpVOs = new PriScStndWdgVO[priScStndWdgVOs.length];
			System.arraycopy(priScStndWdgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScStndWdgVOs = tmpVOs;
		}
	}

	public PriScStndWdgVO getPriScStndWdgVO(){
		return priScStndWdgVO;
	}

	public PriScStndWdgVO[] getPriScStndWdgVOS(){
		PriScStndWdgVO[] tmpVOs = null;
		if (this.priScStndWdgVOs != null) {
			tmpVOs = new PriScStndWdgVO[priScStndWdgVOs.length];
			System.arraycopy(priScStndWdgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}