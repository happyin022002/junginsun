/*=========================================================
 *Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes9052Event.java
*@FileTitle : AWK Cargo Tariff Excel Upload-Basic
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event;


import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TES_9052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_9052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EsdTes9052Event 참조
 * @since J2EE 1.6
 */

public class EsdTes9052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesAwkCgoTrfMngVO	tesAwkCgoTrfMngVO	= null;
	
	/** Table Value Object Multi Data 처리 */
	private TesAwkCgoTrfMngVO[]	tesAwkCgoTrfMngVOs	= null;

	public EsdTes9052Event(){}

	public TesAwkCgoTrfMngVO getTesAwkCgoTrfMngVO() {
		return tesAwkCgoTrfMngVO;
	}

	public void setTesAwkCgoTrfMngVO(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO) {
		this.tesAwkCgoTrfMngVO = tesAwkCgoTrfMngVO;
	}

	public TesAwkCgoTrfMngVO[] getTesAwkCgoTrfMngVOs() {
		return tesAwkCgoTrfMngVOs;
	}

	public void setTesAwkCgoTrfMngVOs(TesAwkCgoTrfMngVO[] tesAwkCgoTrfMngVOs) {
		this.tesAwkCgoTrfMngVOs = tesAwkCgoTrfMngVOs;
	}

	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



}