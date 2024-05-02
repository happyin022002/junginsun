/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0901Event.java
*@FileTitle : Remark Detail 조회/추가/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-22
*@LastModifier : Yaini
*@LastVersion : 1.0
* 2008-11-24 Yaini
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.event;

import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasOpfTdrAtchFileVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0912Event ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author Yaini
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0912Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EasOpfTdrAtchFileVO opfTdrAtchFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EasOpfTdrAtchFileVO[] opfTdrAtchFileVOs = null;

	public EsdEas0912Event(){}

	/**
	 * @return the opfTdrAtchFileVO
	 */
	public EasOpfTdrAtchFileVO getOpfTdrAtchFileVO() {
		return opfTdrAtchFileVO;
	}

	/**
	 * @param opfTdrAtchFileVO the opfTdrAtchFileVO to set
	 */
	public void setOpfTdrAtchFileVO(EasOpfTdrAtchFileVO opfTdrAtchFileVO) {
		this.opfTdrAtchFileVO = opfTdrAtchFileVO;
	}

	/**
	 * @return the opfTdrAtchFileVOs
	 */
	public EasOpfTdrAtchFileVO[] getOpfTdrAtchFileVOs() {
		EasOpfTdrAtchFileVO[] rtnVOs = null;
		if (this.opfTdrAtchFileVOs != null) {
			rtnVOs = new EasOpfTdrAtchFileVO[opfTdrAtchFileVOs.length];
			System.arraycopy(opfTdrAtchFileVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param opfTdrAtchFileVOs the opfTdrAtchFileVOs to set
	 */
	public void setOpfTdrAtchFileVOs(EasOpfTdrAtchFileVO[] opfTdrAtchFileVOs){
		if(opfTdrAtchFileVOs != null){
			EasOpfTdrAtchFileVO[] tmpVOs = new EasOpfTdrAtchFileVO[opfTdrAtchFileVOs.length];
			System.arraycopy(opfTdrAtchFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfTdrAtchFileVOs = tmpVOs;
		}
	}


}
