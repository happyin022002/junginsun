/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : EsdPrd0039Event.java
 *@FileTitle :  VGM CCT History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016-09-27
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PrdTmlVgmCctHisVO;

/**
 * ESD_PRD_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdPrd0039Event extends EventSupport {
	private static final long serialVersionUID = 6333237295305704560L;

	private PrdTmlVgmCctHisVO prdTmlVgmCctHisVO;

	public PrdTmlVgmCctHisVO getPrdTmlVgmCctHisVO() {
		return prdTmlVgmCctHisVO;
	}

	public void setPrdTmlVgmCctHisVO(PrdTmlVgmCctHisVO prdTmlVgmCctHisVO) {
		this.prdTmlVgmCctHisVO = prdTmlVgmCctHisVO;
	}
}
