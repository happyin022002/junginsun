/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdTrs0939Event.java
 *@FileTitle : STCC Code Restriction
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsStccCdRstrVO;

/**
 * ESD_TRS_0939 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0939HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0939Event extends EventSupport {
	private static final long serialVersionUID = 2848589710777118678L;

	private TrsStccCdRstrVO searchVo = null;

	private int iPage = 1;

	public TrsStccCdRstrVO getSearchVo() {
		return searchVo;
	}

	public void setSearchVo(TrsStccCdRstrVO searchVo) {
		this.searchVo = searchVo;
	}

	public int getiPage() {
		return iPage;
	}

	public void setiPage(int iPage) {
		this.iPage = iPage;
	}
}