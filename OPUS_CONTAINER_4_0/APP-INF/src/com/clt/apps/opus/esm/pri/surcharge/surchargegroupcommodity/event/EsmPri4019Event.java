/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4019Event.java
*@FileTitle : GRI Commodity Group Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.06.05 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriScgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriScgGrpCmdtVO;


/**
 * ESM_PRI_4019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_4019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScgGrpCmdtDtlVO[] priScgGrpCmdtDtlVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScgGrpCmdtVO priScgGrpCmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScgGrpCmdtVO[] priScgGrpCmdtVOs = null;

	public EsmPri4019Event(){}
	
	public void setPriScgGrpCmdtDtlVO(PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO){
		this. priScgGrpCmdtDtlVO = priScgGrpCmdtDtlVO;
	}

	public void setPriScgGrpCmdtDtlVOS(PriScgGrpCmdtDtlVO[] priScgGrpCmdtDtlVOs){
		if (priScgGrpCmdtDtlVOs != null) {
			PriScgGrpCmdtDtlVO[] tmpVOs = new PriScgGrpCmdtDtlVO[priScgGrpCmdtDtlVOs.length];
			System.arraycopy(priScgGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgGrpCmdtDtlVOs = tmpVOs;
		}
	}

	public void setPriScgGrpCmdtVO(PriScgGrpCmdtVO priScgGrpCmdtVO){
		this. priScgGrpCmdtVO = priScgGrpCmdtVO;
	}

	public void setPriScgGrpCmdtVOS(PriScgGrpCmdtVO[] priScgGrpCmdtVOs){
		if (priScgGrpCmdtVOs != null) {
			PriScgGrpCmdtVO[] tmpVOs = new PriScgGrpCmdtVO[priScgGrpCmdtVOs.length];
			System.arraycopy(priScgGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgGrpCmdtVOs = tmpVOs;
		}
	}

	public PriScgGrpCmdtDtlVO getPriScgGrpCmdtDtlVO(){
		return priScgGrpCmdtDtlVO;
	}

	public PriScgGrpCmdtDtlVO[] getPriScgGrpCmdtDtlVOS(){
		PriScgGrpCmdtDtlVO[] tmpVOs = null;
		if (this.priScgGrpCmdtDtlVOs != null) {
			tmpVOs = new PriScgGrpCmdtDtlVO[priScgGrpCmdtDtlVOs.length];
			System.arraycopy(priScgGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriScgGrpCmdtVO getPriScgGrpCmdtVO(){
		return priScgGrpCmdtVO;
	}

	public PriScgGrpCmdtVO[] getPriScgGrpCmdtVOS(){
		PriScgGrpCmdtVO[] tmpVOs = null;
		if (this.priScgGrpCmdtVOs != null) {
			tmpVOs = new PriScgGrpCmdtVO[priScgGrpCmdtVOs.length];
			System.arraycopy(priScgGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}