/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TPBInterfaceEvent.java
*@FileTitle : 3자구상 Interface Test
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-20
*@LastModifier : O Wan-Ki
*@LastVersion : 1.0
* 2009-08-20 O Wan-Ki 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.tpbinterface.event;

import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * InterfaceTest에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - InterfaceTestHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author O Wan-Ki
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class TPBInterfaceEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** business mode flag Value */
	private String bizModeFlag = "";
	
	private boolean isSuccessful = false;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TPBInterfaceVO tpbInterfaceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TPBInterfaceVO[] tpbInterfaceVOs = null;
	
	public TPBInterfaceEvent(){}

	public String getBiz_mode_flag() {
		return bizModeFlag;
	}

	public void setBiz_mode_flag(String biz_mode_flag) {
		this.bizModeFlag = biz_mode_flag;
	}

	public TPBInterfaceVO getTpbInterfaceVO(){
		return tpbInterfaceVO;
	}

	public void setTpbInterfaceVO(TPBInterfaceVO tpbInterfaceVO) {
		this.tpbInterfaceVO = tpbInterfaceVO;
	}

	public TPBInterfaceVO[] getTpbInterfaceVOs() {
		return tpbInterfaceVOs;
	}

	public void setTpbInterfaceVOs(TPBInterfaceVO[] tpbInterfaceVOs) {
		this.tpbInterfaceVOs = tpbInterfaceVOs;
	}
	
	
	/**
	 * @return boolean
	 */
	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

}
