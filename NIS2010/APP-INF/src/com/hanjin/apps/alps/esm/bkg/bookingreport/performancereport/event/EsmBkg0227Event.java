/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0227Event.java
*@FileTitle : e-Booking And S/I Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.24 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiPfmcInVO;


/**
 * ESM_BKG_0227 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0227HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0227HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0227Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EBkgSiPfmcInVO eBkgSiPfmcInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EBkgSiPfmcInVO[] eBkgSiPfmcInVOs = null;

	public EsmBkg0227Event(){}
	
	public void setEBkgSiPfmcInVO(EBkgSiPfmcInVO eBkgSiPfmcInVO){
		this. eBkgSiPfmcInVO = eBkgSiPfmcInVO;
	}

	public void setEBkgSiPfmcInVOS(EBkgSiPfmcInVO[] eBkgSiPfmcInVOs){
		if(eBkgSiPfmcInVOs != null){
			EBkgSiPfmcInVO[] tmpVOs = new EBkgSiPfmcInVO[eBkgSiPfmcInVOs.length];
			System.arraycopy(eBkgSiPfmcInVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eBkgSiPfmcInVOs = tmpVOs;
		}
	}

	public EBkgSiPfmcInVO getEBkgSiPfmcInVO(){
		return eBkgSiPfmcInVO;
	}

	public EBkgSiPfmcInVO[] getEBkgSiPfmcInVOS(){
		EBkgSiPfmcInVO[] rtnVOs = null;
		if (this.eBkgSiPfmcInVOs != null) {
			rtnVOs = new EBkgSiPfmcInVO[eBkgSiPfmcInVOs.length];
			System.arraycopy(eBkgSiPfmcInVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	
}