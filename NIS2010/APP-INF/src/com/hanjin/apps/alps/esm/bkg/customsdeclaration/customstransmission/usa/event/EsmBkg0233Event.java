/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0233Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.24
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.07.24 김도완
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaEDADetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaManifestListCondForEdiVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0233 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0233HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Do Wan
 * @see ESM_BKG_0233HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0233Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private UsaManifestListCondForEdiVO usaManifestListCondForEdiVO = null;
	private UsaEDADetailVO[] usaEDADetailVOs = null;

	public EsmBkg0233Event() {}

	public void setUsaManifestListCondForEdiVO(UsaManifestListCondForEdiVO usaManifestListCondForEdiVO) {
		this.usaManifestListCondForEdiVO = usaManifestListCondForEdiVO;
	}
	public UsaManifestListCondForEdiVO getUsaManifestListCondForEdiVO() {
		return usaManifestListCondForEdiVO;
	}


	public void setUsaEDADetailVOs(UsaEDADetailVO[] usaEDADetailVOs){
		if(usaEDADetailVOs != null){
			UsaEDADetailVO[] tmpVOs = Arrays.copyOf(usaEDADetailVOs, usaEDADetailVOs.length);
			this.usaEDADetailVOs = tmpVOs;
		}
	}
	public UsaEDADetailVO[] getUsaEDADetailVOs() {
		UsaEDADetailVO[] rtnVOs = null;
		if (this.usaEDADetailVOs != null) {
			rtnVOs = Arrays.copyOf(usaEDADetailVOs, usaEDADetailVOs.length);
		}
		return rtnVOs;
	}

}