/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0202Event.java
*@FileTitle : Tire Purchase Report by Item
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.01 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseByItemINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseByItemVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0202 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0202HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0202HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0202Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TirePurcharseByItemINVO tirePurcharseByItemINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TirePurcharseByItemVO[] tirePurcharseByItemVOs = null;

	public EesMnr0202Event(){}
	
	public void setTirePurcharseByItemINVO(TirePurcharseByItemINVO tirePurcharseByItemINVO){
		this. tirePurcharseByItemINVO = tirePurcharseByItemINVO;
	}

	public void setTirePurcharseByItemVOS(TirePurcharseByItemVO[] tirePurcharseByItemVOs){
		if(tirePurcharseByItemVOs != null){
			TirePurcharseByItemVO[] tmpVOs = java.util.Arrays.copyOf(tirePurcharseByItemVOs, tirePurcharseByItemVOs.length);
			this.tirePurcharseByItemVOs = tmpVOs;
		}
	}

	public TirePurcharseByItemINVO getTirePurcharseByItemINVO(){
		return tirePurcharseByItemINVO;
	}

	public TirePurcharseByItemVO[] getTirePurcharseByItemVOS(){
		TirePurcharseByItemVO[] rtnVOs = null;
		if (this.tirePurcharseByItemVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tirePurcharseByItemVOs, tirePurcharseByItemVOs.length);
		}
		return rtnVOs;
	}

}