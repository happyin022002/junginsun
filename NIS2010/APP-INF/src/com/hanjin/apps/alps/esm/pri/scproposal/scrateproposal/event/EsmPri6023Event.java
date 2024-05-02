/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6023Event.java
*@FileTitle : PRS- Cost Detail - Pre CM/OP Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.07 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriPrsCostListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6023HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriPrsCostListVO[] rsltPriPrsCostListVOs = null;

	
	
	public EsmPri6023Event(){}
	 
	
	public void setRsltPriPrsCostListVOS(RsltPriPrsCostListVO[] rsltPriPrsCostListVOs){
		this. rsltPriPrsCostListVOs = rsltPriPrsCostListVOs;
	}
	public RsltPriPrsCostListVO[] getRsltPriPrsCostListVOS(){
		return rsltPriPrsCostListVOs;
	}	

}