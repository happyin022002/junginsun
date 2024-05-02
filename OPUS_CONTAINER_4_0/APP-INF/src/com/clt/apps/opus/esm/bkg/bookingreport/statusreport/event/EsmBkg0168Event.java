/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmBkg0168Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.24
*@LastModifier : KyoungIl Moon
*@LastVersion : 1.0
* 2016.03.24 KyoungIl Moon 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmDashboardVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0168 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0168HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KyoungIl Moon
 * @see ESM_BKG_0168HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0168Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VgmDashboardVO infoVO = null;
	/** Table Value Object Multi Data 처리 */
	private VgmDashboardVO[] infoVOs = null;
	private String saveFlg = null;
	
	public VgmDashboardVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(VgmDashboardVO infoVO) {
		this.infoVO = infoVO;
	}

	public VgmDashboardVO[] getInfoVOs() {
		VgmDashboardVO[] rtnVOs = null;
		if(this.infoVOs != null){
			rtnVOs= Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(VgmDashboardVO[] infoVOs) {
		if(infoVOs != null){
			VgmDashboardVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}
	
	public String getSaveFlg(){
		return saveFlg;
	}
	
	public void setSaveFlg(String saveFlg){
		this.saveFlg = saveFlg;
	}

	public EsmBkg0168Event(){}
	
	private static final long serialVersionUID = 1L;
	
	
}