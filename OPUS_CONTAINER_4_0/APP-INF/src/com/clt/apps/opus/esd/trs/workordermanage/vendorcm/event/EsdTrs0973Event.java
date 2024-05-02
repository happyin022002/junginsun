/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EsdTrs0073Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.event;

import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.vo.JoEdiHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * 
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0973Event extends EventSupport {
	/**
	 * 
	 */
	private JoEdiHistoryVO paramVo = null;

	/**
	 * 
	 * @return
	 */
	public JoEdiHistoryVO getParamVo() {
		return paramVo;
	}

	/**
	 * 
	 * @param paramVo
	 */
	public void setParamVo(JoEdiHistoryVO paramVo) {
		this.paramVo = paramVo;
	}
}
