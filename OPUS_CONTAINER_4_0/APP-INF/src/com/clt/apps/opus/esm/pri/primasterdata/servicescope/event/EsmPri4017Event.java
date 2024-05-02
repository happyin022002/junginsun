/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4017Event.java
*@FileTitle : Service Scope Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.07 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.servicescope.event;

import com.clt.apps.opus.esm.pri.primasterdata.servicescope.vo.CstSvcScpVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmSvcScpLaneVO;
import com.clt.syscommon.common.table.MdmSvcScpLmtVO;
import com.clt.syscommon.common.table.MdmSvcScpVO;


/**
 * ESM_PRI_4017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CstSvcScpVO cstSvcScpVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmSvcScpLmtVO mdmSvcScpLmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmSvcScpLmtVO[] mdmSvcScpLmtVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmSvcScpLaneVO mdmSvcScpLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmSvcScpLaneVO[] mdmSvcScpLaneVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmSvcScpVO mdmSvcScpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmSvcScpVO[] mdmSvcScpVOs = null;

	public EsmPri4017Event(){}
	
	public void setCstSvcScpVO(CstSvcScpVO cstSvcScpVO){
		this. cstSvcScpVO = cstSvcScpVO; 
	}
	
	public void setMdmSvcScpLmtVO(MdmSvcScpLmtVO mdmSvcScpLmtVO){
		this. mdmSvcScpLmtVO = mdmSvcScpLmtVO;
	}

	public void setMdmSvcScpLmtVOS(MdmSvcScpLmtVO[] mdmSvcScpLmtVOs){
		if (mdmSvcScpLmtVOs != null) {
			MdmSvcScpLmtVO[] tmpVOs = new MdmSvcScpLmtVO[mdmSvcScpLmtVOs.length];
			System.arraycopy(mdmSvcScpLmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmSvcScpLmtVOs = tmpVOs;
		}

	}

	public void setMdmSvcScpLaneVO(MdmSvcScpLaneVO mdmSvcScpLaneVO){
		this. mdmSvcScpLaneVO = mdmSvcScpLaneVO;
	}

	public void setMdmSvcScpLaneVOS(MdmSvcScpLaneVO[] mdmSvcScpLaneVOs){
		if (mdmSvcScpLaneVOs != null) {
			MdmSvcScpLaneVO[] tmpVOs = new MdmSvcScpLaneVO[mdmSvcScpLaneVOs.length];
			System.arraycopy(mdmSvcScpLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmSvcScpLaneVOs = tmpVOs;
		}
	}

	public void setMdmSvcScpVO(MdmSvcScpVO mdmSvcScpVO){
		this. mdmSvcScpVO = mdmSvcScpVO;
	}

	public void setMdmSvcScpVOS(MdmSvcScpVO[] mdmSvcScpVOs){
		if (mdmSvcScpVOs != null) {
			MdmSvcScpVO[] tmpVOs = new MdmSvcScpVO[mdmSvcScpVOs.length];
			System.arraycopy(mdmSvcScpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmSvcScpVOs = tmpVOs;
		}
	}
	
	public CstSvcScpVO getCstSvcScpVO(){
		return cstSvcScpVO;
	}
	
	public MdmSvcScpLmtVO getMdmSvcScpLmtVO(){
		return mdmSvcScpLmtVO;
	}

	public MdmSvcScpLmtVO[] getMdmSvcScpLmtVOS(){
		MdmSvcScpLmtVO[] tmpVOs = null;
		if (this.mdmSvcScpLmtVOs != null) {
			tmpVOs = new MdmSvcScpLmtVO[mdmSvcScpLmtVOs.length];
			System.arraycopy(mdmSvcScpLmtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public MdmSvcScpLaneVO getMdmSvcScpLaneVO(){
		return mdmSvcScpLaneVO;
	}

	public MdmSvcScpLaneVO[] getMdmSvcScpLaneVOS(){
		MdmSvcScpLaneVO[] tmpVOs = null;
		if (this.mdmSvcScpLaneVOs != null) {
			tmpVOs = new MdmSvcScpLaneVO[mdmSvcScpLaneVOs.length];
			System.arraycopy(mdmSvcScpLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public MdmSvcScpVO getMdmSvcScpVO(){
		return mdmSvcScpVO;
	}

	public MdmSvcScpVO[] getMdmSvcScpVOS(){
		MdmSvcScpVO[] tmpVOs = null;
		if (this.mdmSvcScpVOs != null) {
			tmpVOs = new MdmSvcScpVO[mdmSvcScpVOs.length];
			System.arraycopy(mdmSvcScpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
}