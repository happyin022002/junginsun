/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0621Event.java
*@FileTitle : TRO Status List (USA)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2014.06.13 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroStatusListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroUsaStatusListInVO;


/**
 * ESM_BKG_0621 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0621HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0621HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0621Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TroUsaStatusListInVO troUsaStatusListInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TroUsaStatusListInVO[] troUsaStatusListInVOs = null;

	public EsmBkg0621Event(){}
	
	public void setTroUsaStatusListInVO(TroUsaStatusListInVO troUsaStatusListInVO){
		this. troUsaStatusListInVO = troUsaStatusListInVO;
	}

	public void setTroUsaStatusListInVOS(TroUsaStatusListInVO[] troUsaStatusListInVOs){
		if(troUsaStatusListInVOs != null){
			TroUsaStatusListInVO[] tmpVOs = new TroUsaStatusListInVO[troUsaStatusListInVOs.length];
			System.arraycopy(troUsaStatusListInVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.troUsaStatusListInVOs = tmpVOs;
		}
	}

	public TroUsaStatusListInVO getTroUsaStatusListInVO(){
		return troUsaStatusListInVO;
	}

	public TroUsaStatusListInVO[] getTroUsaStatusListInVOS(){
		TroUsaStatusListInVO[] rtnVOs = null;
		if (this.troUsaStatusListInVOs != null) {
			rtnVOs = new TroUsaStatusListInVO[troUsaStatusListInVOs.length];
			System.arraycopy(troUsaStatusListInVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
		

}