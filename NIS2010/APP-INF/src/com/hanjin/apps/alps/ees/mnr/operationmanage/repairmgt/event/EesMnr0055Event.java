/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0191Event.java
*@FileTitle : Repair History_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 09.07
*@LastModifier : 권영법 
*@LastVersion : 1.0
* 2009. 09.07 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.MnrOrderInfoBySparePartVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.SparePartWOINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
         
/** 
 * ESS_MNR_0191 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESS_MNR_0191HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 권영법 
 * @see EES_MNR_0194HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesMnr0055Event extends EventSupport {
    
	private static final long serialVersionUID = 1L;
	      
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SparePartWOINVO sparePartWOINVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	private MnrOrderInfoBySparePartVO[] mnrOrderInfoBySparePartVOs = null;
     
	public EesMnr0055Event(){}
    
	public SparePartWOINVO getSparePartWOINVO() {
		return sparePartWOINVO;
	}

	public void setSparePartWOINVO(
			SparePartWOINVO sparePartWOINVO) {
		this.sparePartWOINVO = sparePartWOINVO;
	}

	public MnrOrderInfoBySparePartVO[] getMnrOrderInfoBySparePartVOs() {
		return mnrOrderInfoBySparePartVOs;
	}

	public void setMnrOrderInfoBySparePartVOs(
			MnrOrderInfoBySparePartVO[] mnrOrderInfoBySparePartVOs) {
		this.mnrOrderInfoBySparePartVOs = mnrOrderInfoBySparePartVOs;
	}
}