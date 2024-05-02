/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_ADM_SYS_0013vent.java
*@FileTitle : 프로그램 매핑
*Open Issues :
*Change history :
*@LastModifyDate : 2013-04-23
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013-04-23 최덕우
* 1.0 최초 생성 
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import java.util.Arrays;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.MenuListVO;


/**
 * UI_ADM_SYS_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_ADM_SYS_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author DukWoo Choi
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class AdmSys0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MenuListVO menuListVO = null;

	/** Table Value Object Multi Data 처리 */
	private MenuListVO[] menuListVOs = null;

	/**
	 * @return the menuListVO
	 */
	public MenuListVO getMenuListVO() {
		return menuListVO;
	}

	/**
	 * @param menuListVO the menuListVO to set
	 */
	public void setMenuListVO(MenuListVO menuListVO) {
		this.menuListVO = menuListVO;
	}

	/**
	 * @return the menuListVOs
	 */
	public MenuListVO[] getMenuListVOs() {
		MenuListVO[] rtnVOs = null;
		if(this.menuListVOs != null){
			rtnVOs = Arrays.copyOf(this.menuListVOs, this.menuListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param menuListVOs the menuListVOs to set
	 */
	public void setMenuListVOs(MenuListVO[] menuListVOs) {
		if(menuListVOs != null){
			MenuListVO[] tempVOs = Arrays.copyOf(menuListVOs, menuListVOs.length);
			this.menuListVOs = tempVOs;
		}
	}		
}
