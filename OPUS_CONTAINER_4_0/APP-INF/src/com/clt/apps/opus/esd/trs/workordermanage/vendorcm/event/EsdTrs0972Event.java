/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EsdTrs0072Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.vo.JoEdiRcvMsgVO;
import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.vo.SearchJoEdiRcvMsgListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * 
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0972Event extends EventSupport {
	/**
	 * 
	 */
	private JoEdiRcvMsgVO paramVo = null;

	private SearchJoEdiRcvMsgListVO[] searchJoEdiRcvMsgListVOs;

	/**
	 * 
	 * @return
	 */
	public JoEdiRcvMsgVO getParamVo() {
		return paramVo;
	}

	/**
	 * 
	 * @param paramVo
	 */
	public void setParamVo(JoEdiRcvMsgVO paramVo) {
		this.paramVo = paramVo;
	}

	/**
	 * 
	 * @return
	 */
	public SearchJoEdiRcvMsgListVO[] getSearchJoEdiRcvMsgListVOs() {
		SearchJoEdiRcvMsgListVO[] tmpVo = null;
		if (this.searchJoEdiRcvMsgListVOs != null) {
			tmpVo = Arrays.copyOf(this.searchJoEdiRcvMsgListVOs, this.searchJoEdiRcvMsgListVOs.length);
		}
		return tmpVo;
	}

	/**
	 * 
	 * @param searchJoEdiRcvMsgListVOs
	 */
	public void setSearchJoEdiRcvMsgListVOs(SearchJoEdiRcvMsgListVO[] searchJoEdiRcvMsgListVOs) {
		if (searchJoEdiRcvMsgListVOs != null) {
			SearchJoEdiRcvMsgListVO[] tmpVOs = Arrays.copyOf(searchJoEdiRcvMsgListVOs, searchJoEdiRcvMsgListVOs.length);
			this.searchJoEdiRcvMsgListVOs = tmpVOs;
		}
	}

}
