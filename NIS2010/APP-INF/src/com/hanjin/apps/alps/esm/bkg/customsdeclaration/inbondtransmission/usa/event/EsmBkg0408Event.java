/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0533Event.java
*@FileTitle : Paperless MIB Generate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.20 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0408 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0408HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Dowan
 * @see ESM_BKG_0408HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0408Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object 조회 조건  */
	private UsaInbondManifestListCondVO usaInbondManifestListCondVO = null;
	
	/** Table Value Object 단건 처리  */
	private UsaInbondManifestListVO usaInbondManifestListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsaInbondManifestListVO[] usaInbondManifestListVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsaInbondManifestDetailListVO[] usaInbondManifestDetailListVOs = null;

	/** backEndJob key. */
	private String key = "";
	
	public EsmBkg0408Event(){}
	
	public void setUsaInbondManifestListCondVO(UsaInbondManifestListCondVO usaInbondManifestListCondVO){
		this. usaInbondManifestListCondVO = usaInbondManifestListCondVO;
	}
	
	public void setUsaInbondManifestListVO(UsaInbondManifestListVO usaInbondManifestListVO){
		this. usaInbondManifestListVO = usaInbondManifestListVO;
	}

	public void setUsaInbondManifestListVOS(UsaInbondManifestListVO[] usaInbondManifestListVOs){
		if(usaInbondManifestListVOs != null){
			UsaInbondManifestListVO[] tmpVOs = Arrays.copyOf(usaInbondManifestListVOs, usaInbondManifestListVOs.length);
			this.usaInbondManifestListVOs = tmpVOs;
		}
	}

	public void setUsaInbondManifestDetailListVOS(UsaInbondManifestDetailListVO[] usaInbondManifestDetailListVOs){
		if(usaInbondManifestDetailListVOs != null){
			UsaInbondManifestDetailListVO[] tmpVOs = Arrays.copyOf(usaInbondManifestDetailListVOs, usaInbondManifestDetailListVOs.length);
			this.usaInbondManifestDetailListVOs = tmpVOs;
		}
	}
	
	public UsaInbondManifestListCondVO getUsaInbondManifestListCondVO(){
		return usaInbondManifestListCondVO;
	}

	public UsaInbondManifestListVO getUsaInbondManifestListVO(){
		return usaInbondManifestListVO;
	}

	public UsaInbondManifestListVO[] getUsaInbondManifestListVOS(){
		UsaInbondManifestListVO[] rtnVOs = null;
		if (this.usaInbondManifestListVOs != null) {
			rtnVOs = Arrays.copyOf(usaInbondManifestListVOs, usaInbondManifestListVOs.length);
		}
		return rtnVOs;
	}

	public UsaInbondManifestDetailListVO[] getUsaInbondManifestDetailListVOS(){
		UsaInbondManifestDetailListVO[] rtnVOs = null;
		if (this.usaInbondManifestDetailListVOs != null) {
			rtnVOs = Arrays.copyOf(usaInbondManifestDetailListVOs, usaInbondManifestDetailListVOs.length);
		}
		return rtnVOs;
	}	

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}	
}