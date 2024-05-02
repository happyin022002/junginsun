/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1048Event.java
*@FileTitle : ESM_BKG-1048
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 오동현
*@LastVersion : 1.0
* 2009.08.18 오동현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestSendDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaTransmitHistCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-1048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  OH DONG HYUN
 * @see ESM_BKG-1047HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1048Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChinaTransmitHistCondVO chinaTransmitHistCondVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChinaManifestSendDetailListVO[] chinaManifestSendDetailListVOs  = null;

	private String ediRefId = null;
	private String podCd = null;

	public EsmBkg1048Event() {}

	public void setChinaTransmitHistCondVO(ChinaTransmitHistCondVO chinaTransmitHistCondVO) {
		this.chinaTransmitHistCondVO = chinaTransmitHistCondVO;
	}

	public ChinaTransmitHistCondVO getChinaTransmitHistCondVO() {
		return chinaTransmitHistCondVO;
	}

	public void setChinaManifestSendDetailListVOs(ChinaManifestSendDetailListVO[] chinaManifestSendDetailListVOs) {
		if (chinaManifestSendDetailListVOs != null) {
			ChinaManifestSendDetailListVO[] tmpVOs = Arrays.copyOf(chinaManifestSendDetailListVOs, chinaManifestSendDetailListVOs.length);
			this.chinaManifestSendDetailListVOs = tmpVOs;
		}
	}

	public ChinaManifestSendDetailListVO[] getChinaManifestSendDetailListVO() {
		ChinaManifestSendDetailListVO[] rtnVOs = null;
		if (this.chinaManifestSendDetailListVOs != null) {
			rtnVOs = Arrays.copyOf(chinaManifestSendDetailListVOs, chinaManifestSendDetailListVOs.length);
		}
		return rtnVOs;
	}

	public void setEdiRefId(String ediRefId) {
		this.ediRefId = ediRefId;
	}

	public String getEdiRefId() {
		return ediRefId;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public String getPodCd() {
		return podCd;
	}




}