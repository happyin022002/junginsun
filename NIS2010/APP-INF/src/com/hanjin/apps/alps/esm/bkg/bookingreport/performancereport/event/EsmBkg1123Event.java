/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0620Event.java
*@FileTitle : TRO Status List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.13 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroEurStatusListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroStatusListInVO;


/**
 * ESM_BKG_0620 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0620HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0620HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg1123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TroEurStatusListInVO troEurStatusListInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TroEurStatusListInVO[] troEurStatusListInVOs = null;

	public EsmBkg1123Event(){}
	
	public void setTroEurStatusListInVO(TroEurStatusListInVO troEurStatusListInVO){
		this. troEurStatusListInVO = troEurStatusListInVO;
	}

//	public void setTroEurStatusListInVOS(TroEurStatusListInVO[] troEurStatusListInVOs){
//		this. troEurStatusListInVOs = troEurStatusListInVOs;
//	}

	public TroEurStatusListInVO getTroEurStatusListInVO(){
		return troEurStatusListInVO;
	}

//	public TroEurStatusListInVO[] getTroEurStatusListInVOS(){
//		return troEurStatusListInVOs;
//	}

	//2015.03.01 Secure Coding 적용 [CWE-495]
	public TroEurStatusListInVO[] getTroEurStatusListInVOS(){
		TroEurStatusListInVO[] rtnVOs = null;
		if (this.troEurStatusListInVOs != null) {
			rtnVOs = new TroEurStatusListInVO[troEurStatusListInVOs.length];
			System.arraycopy(troEurStatusListInVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	//2015.03.01 Secure Coding 적용[CWE-496]
	public void setTroEurStatusListInVOS(TroEurStatusListInVO[] troEurStatusListInVOs){
		if (troEurStatusListInVOs != null) {
			TroEurStatusListInVO[] tmpVOs = new TroEurStatusListInVO[troEurStatusListInVOs.length];
			System.arraycopy(troEurStatusListInVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.troEurStatusListInVOs = tmpVOs;
		}
	}			
}