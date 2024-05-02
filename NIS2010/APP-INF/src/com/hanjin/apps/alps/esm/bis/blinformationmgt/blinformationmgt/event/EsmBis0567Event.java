/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmBis0567Event.java
*@FileTitle : C/A Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.20 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BkgBlNoVO;


/**
 * ESM_BIS_0567 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BIS_0567HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BIS_0567HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBis0567Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private String    popFlg    = null;
	private String    oldBkgNo  = null;
	
	public EsmBis0567Event(){}
	
	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	/**
	 * @return the popFlg
	 */
	public String getPopFlg() {
		return popFlg;
	}

	/**
	 * @param popFlg the popFlg to set
	 */
	public void setPopFlg(String popFlg) {
		this.popFlg = popFlg;
	}

	/**
	 * @return the oldBkgNo
	 */
	public String getOldBkgNo() {
		return oldBkgNo;
	}

	/**
	 * @param oldBkgNo the oldBkgNo to set
	 */
	public void setOldBkgNo(String oldBkgNo) {
		this.oldBkgNo = oldBkgNo;
	}
}