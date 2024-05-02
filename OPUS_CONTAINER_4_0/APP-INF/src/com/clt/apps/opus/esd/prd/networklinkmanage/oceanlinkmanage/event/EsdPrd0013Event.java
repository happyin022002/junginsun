/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0013Event.java
 *@FileTitle : OceanLink Mnage (EQ)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-26
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-26 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkRHQVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkRHQVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kim kwijin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0013Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private SearchOceanLinkRHQVO searchOceanLinkRHQVO = null;
	private SaveOceanLinkRHQVO[] saveOceanLinkRHQVOs = null;

	/**
	 * 
	 * @return
	 */
	public SaveOceanLinkRHQVO[] getSaveOceanLinkRHQVOs() {
		SaveOceanLinkRHQVO[] tmpVOs = null;
		if (this.saveOceanLinkRHQVOs != null) {
			tmpVOs = new SaveOceanLinkRHQVO[this.saveOceanLinkRHQVOs.length];
			System.arraycopy(this.saveOceanLinkRHQVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param saveOceanLinkRHQVOs
	 */
	public void setSaveOceanLinkRHQVOs(SaveOceanLinkRHQVO[] saveOceanLinkRHQVOs) {
		if (saveOceanLinkRHQVOs != null) {
			SaveOceanLinkRHQVO[] tmpVOs = new SaveOceanLinkRHQVO[saveOceanLinkRHQVOs.length];
			System.arraycopy(saveOceanLinkRHQVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.saveOceanLinkRHQVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public SearchOceanLinkRHQVO getSearchOceanLinkRHQVO() {
		return searchOceanLinkRHQVO;
	}

	/**
	 * 
	 * @param searchOceanLinkRHQVO
	 */
	public void setSearchOceanLinkRHQVO(SearchOceanLinkRHQVO searchOceanLinkRHQVO) {
		this.searchOceanLinkRHQVO = searchOceanLinkRHQVO;
	}

	/**
	 * 
	 * @param arg1
	 * @return
	 */
	public String getString(String arg1) {
		return "";
	}

	/**
	 * 
	 * @param arg1
	 * @return
	 */
	public String[] getObject(String arg1) {
		return new String[1];
	}
}
