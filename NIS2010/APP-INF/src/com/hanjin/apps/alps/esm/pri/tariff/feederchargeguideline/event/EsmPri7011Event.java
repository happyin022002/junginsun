/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri7011Event.java
*@FileTitle : Add-on Tariff Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.21
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.05.21 SEO MI JIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRProgVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_7011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_7011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ESM_PRI_7011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri7011Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmPri7011Event(){}
	
	private FDRMainVO fDRMainVO = null;   
	
	private FDRDetailVO fDRDetailVO = null; 
	
	private FDRDetailVO[] fDRDetailVOs = null;   
	
	private FDRProgVO fDRProgVO = null;

	public FDRMainVO getfDRMainVO() {
		return fDRMainVO;
	}

	public void setfDRMainVO(FDRMainVO fDRMainVO) {
		this.fDRMainVO = fDRMainVO;
	}

	public FDRDetailVO getfDRDetailVO() {
		return fDRDetailVO;
	}

	public void setfDRDetailVO(FDRDetailVO fDRDetailVO) {
		this.fDRDetailVO = fDRDetailVO;
	}

	public FDRDetailVO[] getfDRDetailVOs() {
		FDRDetailVO[] rtnVOs = null;
		if (this.fDRDetailVOs != null) {
			rtnVOs = new FDRDetailVO[fDRDetailVOs.length];
			System.arraycopy(fDRDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setfDRDetailVOs(FDRDetailVO[] fDRDetailVOs){
		if(fDRDetailVOs != null){
			FDRDetailVO[] tmpVOs = new FDRDetailVO[fDRDetailVOs.length];
			System.arraycopy(fDRDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fDRDetailVOs = tmpVOs;
		}
	}

	public FDRProgVO getfDRProgVO() {
		return fDRProgVO;
	}

	public void setfDRProgVO(FDRProgVO fDRProgVO) {
		this.fDRProgVO = fDRProgVO;
	}

	
	
}