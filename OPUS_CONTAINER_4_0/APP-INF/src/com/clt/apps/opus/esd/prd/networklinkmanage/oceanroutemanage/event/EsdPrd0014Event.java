/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0014Event.java
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
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0014Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EsdPrd0014Event() {
	}

	SearchConditionVO searchConditionVO = null;
	SearchOceanRouteListVO searchOceanRouteListVO = null;
	SearchConditionVO[] searchConditionVOs = null;
	SearchOceanRouteListVO[] searchOceanRouteListVOs = null;
	SaveOceanRouteVO[] saveOceanRouteVOs = null;

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
	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	/**
	 * 
	 * @param searchConditionVO
	 */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchOceanRouteListVO getSearchOceanRouteListVO() {
		return searchOceanRouteListVO;
	}

	/**
	 * 
	 * @param searchOceanRouteListVO
	 */
	public void setSearchOceanRouteListVO(SearchOceanRouteListVO searchOceanRouteListVO) {
		this.searchOceanRouteListVO = searchOceanRouteListVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchConditionVO[] getSearchConditionVOs() {
		SearchConditionVO[] tmpVOs = null;
		if (this.searchConditionVOs != null) {
			tmpVOs = new SearchConditionVO[this.searchConditionVOs.length];
			System.arraycopy(this.searchConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchConditionVOs
	 */
	public void setSearchConditionVOs(SearchConditionVO[] searchConditionVOs) {
		if (searchConditionVOs != null) {
			SearchConditionVO[] tmpVOs = new SearchConditionVO[searchConditionVOs.length];
			System.arraycopy(searchConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchConditionVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @return
	 */
	public SearchOceanRouteListVO[] getSearchOceanRouteListVOs() {
		SearchOceanRouteListVO[] tmpVOs = null;
		if (this.searchOceanRouteListVOs != null) {
			tmpVOs = new SearchOceanRouteListVO[this.searchOceanRouteListVOs.length];
			System.arraycopy(this.searchOceanRouteListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchOceanRouteListVOs
	 */
	public void setSearchOceanRouteListVOs(SearchOceanRouteListVO[] searchOceanRouteListVOs) {
		if (searchOceanRouteListVOs != null) {
			SearchOceanRouteListVO[] tmpVOs = new SearchOceanRouteListVO[searchOceanRouteListVOs.length];
			System.arraycopy(searchOceanRouteListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchOceanRouteListVOs = tmpVOs;
		}
	}

	/**
	 * 
	 * @param val
	 * @return
	 */
	public String getString(String val) {
		return "";
	}

	/**
	 * 
	 * @param val
	 * @return
	 */
	public int getInt(String val) {
		return -1;
	}

	/**
	 * 
	 * @param val
	 * @return
	 */
	public String[] getObject(String val) {
		String[] a = new String[1];
		return a;
	}
}
