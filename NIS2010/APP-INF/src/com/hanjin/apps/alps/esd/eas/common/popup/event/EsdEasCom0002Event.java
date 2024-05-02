/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : 
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2011-09-30
*@LastModifier : Kim Yong Jin
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.eas.common.popup.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.eas.common.util.RequestDataSet;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.eas.transportmanage.vo.DOFChgColInqmanageListVO;

/**
 * ESD_EAS_COM_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_EAS_COM_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Yong Jin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdEasCom0002Event extends EventSupport {

	private DOFChgColInqmanageListVO dOFChgColInqmanageListVo = null;
	
	private DOFChgColInqmanageListVO[] dOFChgColInqmanageListVos = null;	
	
//	private String ctrlOfcCd = null;
	
	/**
	 * EsdEasCom0002Event 초기 클래스 생성
	 */
	public EsdEasCom0002Event(){}
	
	public DOFChgColInqmanageListVO getDOFChgColInqmanageListVo() {
		return dOFChgColInqmanageListVo;
	}

	public void setDOFChgColInqmanageListVo(DOFChgColInqmanageListVO dOFChgColInqmanageListVo) {
		this.dOFChgColInqmanageListVo = dOFChgColInqmanageListVo;
	}
	
	public DOFChgColInqmanageListVO[] getDOFChgColInqmanageListVos() {
		DOFChgColInqmanageListVO[] rtnVOs = null;
		if (this.dOFChgColInqmanageListVos != null) {
			rtnVOs = new DOFChgColInqmanageListVO[dOFChgColInqmanageListVos.length];
			System.arraycopy(dOFChgColInqmanageListVos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setDOFChgColInqmanageListVos(DOFChgColInqmanageListVO[] dOFChgColInqmanageListVos){
		if(dOFChgColInqmanageListVos != null){
			DOFChgColInqmanageListVO[] tmpVOs = new DOFChgColInqmanageListVO[dOFChgColInqmanageListVos.length];
			System.arraycopy(dOFChgColInqmanageListVos, 0, tmpVOs, 0, tmpVOs.length);
			this.dOFChgColInqmanageListVos = tmpVOs;
		}
	}
	
//	public String getCtrl_ofc_cd() {
//		return ctrlOfcCd;
//	}


//	public void setCtrl_ofc_cd(String ctrl_ofc_cd) {
//		this.ctrlOfcCd = ctrl_ofc_cd;
//	}

	public String getEventName() {
		return "EsdEasCom0002Event";
	}

	public String toString() {
		return "EsdEasCom0002Event";
	}

}
