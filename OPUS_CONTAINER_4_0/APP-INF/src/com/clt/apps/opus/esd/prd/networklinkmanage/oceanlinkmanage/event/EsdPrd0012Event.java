/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0012Event.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-19
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-19 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0012Event extends EventSupport {

	private static final long serialVersionUID = -7940801899037015142L;
	
	private SearchOceanLinkVO searchOceanLinkVO = null;
	private SearchOceanLinkVO[] searchOceanLinkVOs = null;
	private SaveOceanLinkVO[] saveOceanLinkVOs = null;
	private String backEndJobKey = null;

	/**
	 * 
	 * @return
	 */
	public SearchOceanLinkVO getSearchOceanLinkVO() {
		return searchOceanLinkVO;
	}

	/**
	 * 
	 * @param searchOceanLinkVO
	 */
	public void setSearchOceanLinkVO(SearchOceanLinkVO searchOceanLinkVO) {
		this.searchOceanLinkVO = searchOceanLinkVO;
	}

	/**
	 * 
	 * @return
	 */
	public SaveOceanLinkVO[] getSaveOceanLinkVOs() {
		SaveOceanLinkVO[] tmpVOs = null;
		if (this.saveOceanLinkVOs != null) {
			tmpVOs = new SaveOceanLinkVO[this.saveOceanLinkVOs.length];
			System.arraycopy(this.saveOceanLinkVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param saveOceanLinkVOs
	 */
	public void setSaveOceanLinkVOs(SaveOceanLinkVO[] saveOceanLinkVOs) {
		if (saveOceanLinkVOs != null) {
			SaveOceanLinkVO[] tmpVOs = new SaveOceanLinkVO[saveOceanLinkVOs.length];
			System.arraycopy(saveOceanLinkVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.saveOceanLinkVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public SearchOceanLinkVO[] getSearchOceanLinkVOs() {
		SearchOceanLinkVO[] tmpVOs = null;
		if (this.searchOceanLinkVOs != null) {
			tmpVOs = new SearchOceanLinkVO[this.searchOceanLinkVOs.length];
			System.arraycopy(this.searchOceanLinkVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchOceanLinkVOs
	 */
	public void setSearchOceanLinkVOs(SearchOceanLinkVO[] searchOceanLinkVOs) {
		if (searchOceanLinkVOs != null) {
			SearchOceanLinkVO[] tmpVOs = new SearchOceanLinkVO[searchOceanLinkVOs.length];
			System.arraycopy(searchOceanLinkVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchOceanLinkVOs = tmpVOs;
		}
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

	/**
	 * 
	 * @return
	 */
	public String getBackEndJobKey() {
		return backEndJobKey;
	}

	/**
	 * 
	 * @param backEndJobKey
	 */
	public void setBackEndJobKey(String backEndJobKey) {
		this.backEndJobKey = backEndJobKey;
	}

}
