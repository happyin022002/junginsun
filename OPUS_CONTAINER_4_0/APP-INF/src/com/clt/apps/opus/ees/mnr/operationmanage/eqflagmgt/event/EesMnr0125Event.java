/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0125Event.java
*@FileTitle : Damage Histroy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation 
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**  
 * EES_MNR_0125 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0125HTMLAction에서 작성<br> 
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *  
 * @author park myoung sin  
 * @see EES_MNR_0125HTMLAction 참조 
 * @since J2EE 1.4 
 */  
   
public class EesMnr0125Event extends EventSupport {
	public EQFlagListINVO getEQFlagListINVO() {
		return eQFlagListINVO;
	}

	public void setEQFlagListINVO(EQFlagListINVO flagListINVO) {
		eQFlagListINVO = flagListINVO;
	}

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EQFlagListINVO eQFlagListINVO = null;
	 
}
