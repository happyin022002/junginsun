/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0035Event.java
 *@FileTitle : OceanRoute Manual Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-25
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanLaneVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0035Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EsdPrd0035Event() {
	}

	private String row = null;
	private String col = null;
	private String polContCd = null;
	private String podContCd = null;
	private SearchOceanLaneVO searchOceanLaneVO = null;
	private SearchOceanLaneVO[] searchOceanLaneVOs = null;

	/**
	 * 
	 * @return
	 */
	public String getRow() {
		return row;
	}

	/**
	 * 
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * 
	 * @return
	 */
	public String getCol() {
		return col;
	}

	/**
	 * 
	 * @param col
	 */
	public void setCol(String col) {
		this.col = col;
	}

	/**
	 * 
	 * @return
	 */
	public String getPolContCd() {
		return polContCd;
	}

	/**
	 * 
	 * @param polContCd
	 */
	public void setPolContCd(String polContCd) {
		this.polContCd = polContCd;
	}

	/**
	 * 
	 * @return
	 */
	public String getPodContCd() {
		return podContCd;
	}

	/**
	 * 
	 * @param pod_cont_cd
	 */
	public void setPodContCd(String podContCd) {
		this.podContCd = podContCd;
	}

	/**
	 * 
	 * @return
	 */
	public SearchOceanLaneVO getSearchOceanLaneVO() {
		return searchOceanLaneVO;
	}

	/**
	 * 
	 * @param searchOceanLaneVO
	 */
	public void setSearchOceanLaneVO(SearchOceanLaneVO searchOceanLaneVO) {
		this.searchOceanLaneVO = searchOceanLaneVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchOceanLaneVO[] getSearchOceanLaneVOs() {
		SearchOceanLaneVO[] tmpVOs = null;
		if (this.searchOceanLaneVOs != null) {
			tmpVOs = new SearchOceanLaneVO[this.searchOceanLaneVOs.length];
			System.arraycopy(this.searchOceanLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchOceanLaneVOs
	 */
	public void setSearchOceanLaneVOs(SearchOceanLaneVO[] searchOceanLaneVOs) {
		if (searchOceanLaneVOs != null) {
			SearchOceanLaneVO[] tmpVOs = new SearchOceanLaneVO[searchOceanLaneVOs.length];
			System.arraycopy(searchOceanLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchOceanLaneVOs = tmpVOs;
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
	public int getInt(String arg1) {
		return -1;
	}
}
