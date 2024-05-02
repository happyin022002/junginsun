/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0087Event.java
*@FileTitle : Reason for Excluding from TPR (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.14 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;
import com.hanjin.syscommon.common.table.OpfTmlProdRptRsnCdVO;


/**
 * vop_opf_0087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  vop_opf_0087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji Seok Woo
 * @see vop_opf_0087HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf0087Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVOs = null;

	public VopOpf0087Event(){}
	
	public void setOpfTmlProdRptRsnCdVO(OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVO){
		this. opfTmlProdRptRsnCdVO = opfTmlProdRptRsnCdVO;
	}

	public void setOpfTmlProdRptRsnCdVOS(OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVOs){
		if (opfTmlProdRptRsnCdVOs != null) {
			OpfTmlProdRptRsnCdVO[] tmpVOs = new OpfTmlProdRptRsnCdVO[opfTmlProdRptRsnCdVOs.length];
			System.arraycopy(opfTmlProdRptRsnCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfTmlProdRptRsnCdVOs = tmpVOs;
		}
	}

	public OpfTmlProdRptRsnCdVO getOpfTmlProdRptRsnCdVO(){
		return opfTmlProdRptRsnCdVO;
	}

	public OpfTmlProdRptRsnCdVO[] getOpfTmlProdRptRsnCdVOS(){
		OpfTmlProdRptRsnCdVO[] rtnVOs = null;

 		if (this.opfTmlProdRptRsnCdVOs != null) {
 			rtnVOs = new OpfTmlProdRptRsnCdVO[opfTmlProdRptRsnCdVOs.length];
 			System.arraycopy(opfTmlProdRptRsnCdVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

}