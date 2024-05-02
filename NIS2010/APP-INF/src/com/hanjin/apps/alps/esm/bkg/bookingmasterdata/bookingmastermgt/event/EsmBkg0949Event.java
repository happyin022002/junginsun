/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0949Event.java
*@FileTitle : booking master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.07.14 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetListVO;


/**
 * ESM_BKG_0949 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0949HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0949HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0949Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgdocClzSetVO bkgdocClzSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgdocClzSetVO[] bkgdocClzSetVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgdocClzSetListVO bkgdocClzSetListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgdocClzSetListVO[] bkgdocClzSetListVOs = null;

	public EsmBkg0949Event(){}
	
	public void setBkgdocClzSetVO(BkgdocClzSetVO bkgdocClzSetVO){
		this. bkgdocClzSetVO = bkgdocClzSetVO;
	}

	public void setBkgdocClzSetVOS(BkgdocClzSetVO[] bkgdocClzSetVOs){
		this. bkgdocClzSetVOs = bkgdocClzSetVOs;
	}

	public void setBkgdocClzSetListVO(BkgdocClzSetListVO bkgdocClzSetListVO){
		this. bkgdocClzSetListVO = bkgdocClzSetListVO;
	}

	public void setBkgdocClzSetListVOS(BkgdocClzSetListVO[] bkgdocClzSetListVOs){
		this. bkgdocClzSetListVOs = bkgdocClzSetListVOs;
	}

	public BkgdocClzSetVO getBkgdocClzSetVO(){
		return bkgdocClzSetVO;
	}

	public BkgdocClzSetVO[] getBkgdocClzSetVOS(){
		return bkgdocClzSetVOs;
	}

	public BkgdocClzSetListVO getBkgdocClzSetListVO(){
		return bkgdocClzSetListVO;
	}

	public BkgdocClzSetListVO[] getBkgdocClzSetListVOS(){
		return bkgdocClzSetListVOs;
	}

}