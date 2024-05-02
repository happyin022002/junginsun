/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0421Event.java
*@FileTitle : Restuffing Reason
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.04.30 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.UsAmsLocationListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CtmMvmtXchRsnVO;


/**
 * EES_CTM_0421 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0421HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김상수
 * @see EES_CTM_0421HTMLAction 참조
 * @since J2EE 1.5
 * 2009.4.30
 */
public class EesCtm0421Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmMvmtXchRsnVO ctmMvmtXchRsnVO = null;
	
	private CtmMvmtXchRsnVO[] ctmMvmtXchRsnVOs = null;

	public EesCtm0421Event(){}

	public void setCtmMvmtXchRsnVO(CtmMvmtXchRsnVO ctmMvmtXchRsnVO){
		this. ctmMvmtXchRsnVO = ctmMvmtXchRsnVO;
	}

	public CtmMvmtXchRsnVO getCtmMvmtXchRsnVO(){
		return ctmMvmtXchRsnVO;
	}
	
	public void setCtmMvmtXchRsnVOS(CtmMvmtXchRsnVO[] ctmMvmtXchRsnVOs){
		if (ctmMvmtXchRsnVOs != null) {
			CtmMvmtXchRsnVO[] tmpVOs = new CtmMvmtXchRsnVO[ctmMvmtXchRsnVOs.length];
			System.arraycopy(ctmMvmtXchRsnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmMvmtXchRsnVOs = tmpVOs;
		}
	}

	public CtmMvmtXchRsnVO[] getCtmMvmtXchRsnVOS(){
		CtmMvmtXchRsnVO[] tmpVOs = null;
		if (this.ctmMvmtXchRsnVOs != null) {
			tmpVOs = new CtmMvmtXchRsnVO[ctmMvmtXchRsnVOs.length];
			System.arraycopy(ctmMvmtXchRsnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}