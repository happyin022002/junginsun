/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsdTes9310Event.java
*@FileTitle : Notice on Old Invoice & CSR of TES
*Open Issues :
*Change history :
*@LastModifyDate : 2010-11-15
*@LastModifier : KimYongJin
*@LastVersion : 1.0
* 2010-11-15 KimYongJin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 * TESInvoiceCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9310HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimYongJin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9310Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesTmlSoHdrVO		tesTmlSoHdrVO		= null;


	/** Table Value Object Multi Data 처리 */
	private TesTmlSoHdrVO[]			tesTmlSoHdrVOs		= null;

	public EsdTes9310Event(){}
	
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO){
		this. tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVOS(TesTmlSoHdrVO[] tesTmlSoHdrVOs){
		this. tesTmlSoHdrVOs = tesTmlSoHdrVOs;
	}

	public TesTmlSoHdrVO getTesTmlSoHdrVO(){
		return tesTmlSoHdrVO;
	}

	public TesTmlSoHdrVO[] getTesTmlSoHdrVOS(){
		return tesTmlSoHdrVOs;
	}

}
