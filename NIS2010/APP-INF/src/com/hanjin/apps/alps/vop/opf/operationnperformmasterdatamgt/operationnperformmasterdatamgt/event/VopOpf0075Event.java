/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0075Event.java
*@FileTitle : Restow Reason Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.11 이선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event;
 
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;


/**
 * VOP_OPF-0075 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF-0075HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF-0075HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf0075Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfRstwgRsnCdVO opfRstwgRsnCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfRstwgRsnCdVO[] opfRstwgRsnCdVOs = null;

	public VopOpf0075Event(){}
	
	public void setOpfRstwgRsnCdVO(OpfRstwgRsnCdVO opfRstwgRsnCdVO){
		this. opfRstwgRsnCdVO = opfRstwgRsnCdVO;
	}

	public void setOpfRstwgRsnCdVOS(OpfRstwgRsnCdVO[] opfRstwgRsnCdVOs){
		if (opfRstwgRsnCdVOs != null) {
			OpfRstwgRsnCdVO[] tmpVOs = new OpfRstwgRsnCdVO[opfRstwgRsnCdVOs.length];
			System.arraycopy(opfRstwgRsnCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfRstwgRsnCdVOs = tmpVOs;
		}
	}

	public OpfRstwgRsnCdVO getOpfRstwgRsnCdVO(){
		return opfRstwgRsnCdVO;
	}

	public OpfRstwgRsnCdVO[] getOpfRstwgRsnCdVOS(){
		OpfRstwgRsnCdVO[] rtnVOs = null;

 		if (this.opfRstwgRsnCdVOs != null) {
 			rtnVOs = new OpfRstwgRsnCdVO[opfRstwgRsnCdVOs.length];
 			System.arraycopy(opfRstwgRsnCdVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

}