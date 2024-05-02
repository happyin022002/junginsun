/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0054Event.java
*@FileTitle : Tariff History-Shuttle
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.07
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.07 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event;


import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TES_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_0054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see EsdTes0054Event 참조
 * @since J2EE 1.6
 */

public class EsdTes0054Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesAwkCgoTrfMngVO	tesAwkCgoTrfMngVO	= null;
	
	/** Table Value Object Multi Data 처리 */
	private TesAwkCgoTrfMngVO[]	tesAwkCgoTrfMngVOs	= null;

	public EsdTes0054Event(){}

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