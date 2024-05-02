/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GEMcommonEvent.java
 *@FileTitle : GEMCommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : GEM
 *@LastVersion : 1.0
 * 2009.04.16 GEM
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemcommon.event;

import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * GEMCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - GEM_COM_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author gem
 * @see GEM_COM_HTMLAction 참조
 * @since J2EE 1.4
 */

public class GemCommonEvent extends EventSupport {
	private static final long serialVersionUID = 1L;

	public GemCommonEvent() {
	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private OfficeMgtVO officeMgtVO = null;

	/** Table Value Object Multi Data 처리 */
	private OfficeMgtVO[] officeMgtVOs = null;

	public OfficeMgtVO getOfficeMgtVO() {
		return officeMgtVO;
	}

	public void setOfficeMgtVO(OfficeMgtVO officeMgtVO) {
		this.officeMgtVO = officeMgtVO;
	}

	public OfficeMgtVO[] getOfficeMgtVOs() {
		return officeMgtVOs;
	}

	public void setOfficeMgtVOs(OfficeMgtVO[] officeMgtVOs) {
		this.officeMgtVOs = officeMgtVOs;
	}

}