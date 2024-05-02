/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0081Event.java
*@FileTitle : Loading Port Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.25 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.LoadingQtyVO;


/**
 * FNS_JOO_0081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0081HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0081Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LoadingQtyVO loadingQtyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LoadingQtyVO[] loadingQtyVOs = null;

	public FnsJoo0081Event(){}
	
	public void setLoadingQtyVO(LoadingQtyVO loadingQtyVO){
		this. loadingQtyVO = loadingQtyVO;
	}

	public void setLoadingQtyVOS(LoadingQtyVO[] loadingQtyVOs){
		if (loadingQtyVOs != null) {
			LoadingQtyVO[] tmpVOs = new LoadingQtyVO[loadingQtyVOs.length];
			System.arraycopy(loadingQtyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.loadingQtyVOs = tmpVOs;
		}		
	}

	public LoadingQtyVO getLoadingQtyVO(){
		return loadingQtyVO;
	}

	public LoadingQtyVO[] getLoadingQtyVOS(){
		LoadingQtyVO[] rtnVOs = null;
		if (this.loadingQtyVOs != null) {
			rtnVOs = new LoadingQtyVO[loadingQtyVOs.length];
			System.arraycopy(loadingQtyVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}