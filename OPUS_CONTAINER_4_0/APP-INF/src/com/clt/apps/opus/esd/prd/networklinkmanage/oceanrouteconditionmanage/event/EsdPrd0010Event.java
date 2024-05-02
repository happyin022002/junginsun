/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0010Event.java
 *@FileTitle : Carrier별 이용터미널 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-09
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-09 jungsunyoung
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchEmbargoVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jungsunyoung
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0010Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private SearchEmbargoVO searchEmbargoVO = null;
	private SearchEmbargoVO[] searchEmbargoVOs = null;

	/**
	 * 
	 * @return
	 */
	public SearchEmbargoVO getSearchEmbargoVO() {
		return searchEmbargoVO;
	}

	/**
	 * 
	 * @param searchEmbargoVO
	 */
	public void setSearchEmbargoVO(SearchEmbargoVO searchEmbargoVO) {
		this.searchEmbargoVO = searchEmbargoVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchEmbargoVO[] getSearchEmbargoVOs() {
		SearchEmbargoVO[] tmpVOs = null;
		if (this.searchEmbargoVOs != null) {
			tmpVOs = new SearchEmbargoVO[this.searchEmbargoVOs.length];
			System.arraycopy(this.searchEmbargoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchEmbargoVOs
	 */
	public void setSearchEmbargoVOs(SearchEmbargoVO[] searchEmbargoVOs) {
		if (searchEmbargoVOs != null) {
			SearchEmbargoVO[] tmpVOs = new SearchEmbargoVO[searchEmbargoVOs.length];
			System.arraycopy(searchEmbargoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchEmbargoVOs = tmpVOs;
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
}
