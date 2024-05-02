/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmChssPoolEvent.java
*@FileTitle : CGM_CHSS_POOL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.11 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * CGM_CHSS_POOL 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CGM_CHSS_POOLHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see CGM_CHSS_POOLHTMLAction 참조
 * @since J2EE 1.6
 */

public class CgmChssPoolEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CgmChssPoolINVO cgmChssPoolINVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CgmChssPoolMGTVO cgmChssPoolMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CgmChssPoolMGTVO[] cgmChssPoolMGTVOs = null;

	public CgmChssPoolEvent(){}

	/**
	 * @return the cgmChssPoolINVO
	 */
	public CgmChssPoolINVO getCgmChssPoolINVO() {
		return cgmChssPoolINVO;
	}

	/**
	 * @param cgmChssPoolINVO the cgmChssPoolINVO to set
	 */
	public void setCgmChssPoolINVO(CgmChssPoolINVO cgmChssPoolINVO) {
		this.cgmChssPoolINVO = cgmChssPoolINVO;
	}

	/**
	 * @return the cgmChssPoolMGTVO
	 */
	public CgmChssPoolMGTVO getCgmChssPoolMGTVO() {
		return cgmChssPoolMGTVO;
	}

	/**
	 * @param cgmChssPoolMGTVO the cgmChssPoolMGTVO to set
	 */
	public void setCgmChssPoolMGTVO(CgmChssPoolMGTVO cgmChssPoolMGTVO) {
		this.cgmChssPoolMGTVO = cgmChssPoolMGTVO;
	}

	/**
	 * @return the cgmChssPoolMGTVOs
	 */
	public CgmChssPoolMGTVO[] getCgmChssPoolMGTVOs() {
		return cgmChssPoolMGTVOs;
	}

	/**
	 * @param cgmChssPoolMGTVOs the cgmChssPoolMGTVOs to set
	 */
	public void setCgmChssPoolMGTVOs(CgmChssPoolMGTVO[] cgmChssPoolMGTVOs) {
		this.cgmChssPoolMGTVOs = cgmChssPoolMGTVOs;
	}
	

}