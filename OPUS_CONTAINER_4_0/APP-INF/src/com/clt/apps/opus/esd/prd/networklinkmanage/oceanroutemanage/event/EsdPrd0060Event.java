/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0060Event.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-22
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-22 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteMultiCreationVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteSingleCreationVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_060 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_060HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0060Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EsdPrd0060Event() {
	}

	private SearchOceanRouteMultiCreationVO searchOceanRouteMultiCreationVO = null;
	private SearchOceanRouteMultiCreationVO[] searchOceanRouteMultiCreationVOs = null;

	private SaveOceanRouteVO saveOceanRouteVO = null;
	private SaveOceanRouteVO[] saveOceanRouteVOs = null;

	private SearchOceanRouteSingleCreationVO searchOceanRouteSingleCreationVO = null;
	private SearchOceanRouteSingleCreationVO[] searchOceanRouteSingleCreationVOs = null;

	public SearchOceanRouteSingleCreationVO getSearchOceanRouteSingleCreationVO() {
		return searchOceanRouteSingleCreationVO;
	}

	public void setSearchOceanRouteSingleCreationVO(SearchOceanRouteSingleCreationVO searchOceanRouteSingleCreationVO) {
		this.searchOceanRouteSingleCreationVO = searchOceanRouteSingleCreationVO;
	}

	public SearchOceanRouteSingleCreationVO[] getSearchOceanRouteSingleCreationVOs() {
		SearchOceanRouteSingleCreationVO[] tmpVOs = null;
		if (this.searchOceanRouteSingleCreationVOs != null) {
			tmpVOs = new SearchOceanRouteSingleCreationVO[this.searchOceanRouteSingleCreationVOs.length];
			System.arraycopy(this.searchOceanRouteSingleCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setSearchOceanRouteSingleCreationVOs(SearchOceanRouteSingleCreationVO[] searchOceanRouteSingleCreationVOs) {
		if (searchOceanRouteSingleCreationVOs != null) {
			SearchOceanRouteSingleCreationVO[] tmpVOs = new SearchOceanRouteSingleCreationVO[searchOceanRouteSingleCreationVOs.length];
			System.arraycopy(searchOceanRouteSingleCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchOceanRouteSingleCreationVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public SaveOceanRouteVO[] getSaveOceanRouteVOs() {
		SaveOceanRouteVO[] tmpVOs = null;
		if (this.saveOceanRouteVOs != null) {
			tmpVOs = new SaveOceanRouteVO[this.saveOceanRouteVOs.length];
			System.arraycopy(this.saveOceanRouteVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param saveOceanRouteVOs
	 */
	public void setSaveOceanRouteVOs(SaveOceanRouteVO[] saveOceanRouteVOs) {
		if (saveOceanRouteVOs != null) {
			SaveOceanRouteVO[] tmpVOs = new SaveOceanRouteVO[saveOceanRouteVOs.length];
			System.arraycopy(saveOceanRouteVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.saveOceanRouteVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public SaveOceanRouteVO getSaveOceanRouteVO() {
		return saveOceanRouteVO;
	}

	/**
	 * 
	 * @param saveOceanRouteVO
	 */
	public void setSaveOceanRouteVO(SaveOceanRouteVO saveOceanRouteVO) {
		this.saveOceanRouteVO = saveOceanRouteVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchOceanRouteMultiCreationVO getSearchOceanRouteMultiCreationVO() {
		return searchOceanRouteMultiCreationVO;
	}

	/**
	 * 
	 * @param searchOceanRouteMultiCreationVO
	 */
	public void setSearchOceanRouteMultiCreationVO(SearchOceanRouteMultiCreationVO searchOceanRouteMultiCreationVO) {
		this.searchOceanRouteMultiCreationVO = searchOceanRouteMultiCreationVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchOceanRouteMultiCreationVO[] getSearchOceanRouteMultiCreationVOs() {
		SearchOceanRouteMultiCreationVO[] tmpVOs = null;
		if (this.searchOceanRouteMultiCreationVOs != null) {
			tmpVOs = new SearchOceanRouteMultiCreationVO[this.searchOceanRouteMultiCreationVOs.length];
			System.arraycopy(this.searchOceanRouteMultiCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchOceanRouteMultiCreationVOs
	 */
	public void setSearchOceanRouteMultiCreationVOs(SearchOceanRouteMultiCreationVO[] searchOceanRouteMultiCreationVOs) {
		if (searchOceanRouteMultiCreationVOs != null) {
			SearchOceanRouteMultiCreationVO[] tmpVOs = new SearchOceanRouteMultiCreationVO[searchOceanRouteMultiCreationVOs.length];
			System.arraycopy(searchOceanRouteMultiCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchOceanRouteMultiCreationVOs = tmpVOs;
		}
	}

	/**
	 * 에러 안나게하기 위해 임시로
	 * 
	 * @param arg1
	 * @return
	 */
	public String getString(String arg1) {
		return "";
	}

	/**
	 * 에러 안나게하기 위해 임시로
	 * 
	 * @param arg1
	 * @return
	 */
	public String[] getObject(String arg1) {
		return new String[1];
	}
}
