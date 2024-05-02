/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0618Event.java
*@FileTitle : Loading Confirmation by Shipper (Fax / E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.25 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.LoadingConfirmationinVO;


/**
 * ESM_BKG_0618 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0618HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0618HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0618Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LoadingConfirmationinVO loadingConfirmationinVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LoadingConfirmationinVO[] loadingConfirmationinVOs = null;

	public EsmBkg0618Event(){}
	
	public void setLoadingConfirmationinVO(LoadingConfirmationinVO loadingConfirmationinVO){
		this. loadingConfirmationinVO = loadingConfirmationinVO;
	}

	public void setLoadingConfirmationinVOS(LoadingConfirmationinVO[] loadingConfirmationinVOs){
		if(loadingConfirmationinVOs != null){
			LoadingConfirmationinVO[] tmpVOs = new LoadingConfirmationinVO[loadingConfirmationinVOs.length];
			System.arraycopy(loadingConfirmationinVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.loadingConfirmationinVOs = tmpVOs;
		}
	}

	public LoadingConfirmationinVO getLoadingConfirmationinVO(){
		return loadingConfirmationinVO;
	}

	public LoadingConfirmationinVO[] getLoadingConfirmationinVOS(){
		LoadingConfirmationinVO[] rtnVOs = null;
		if (this.loadingConfirmationinVOs != null) {
			rtnVOs = new LoadingConfirmationinVO[loadingConfirmationinVOs.length];
			System.arraycopy(loadingConfirmationinVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	
}