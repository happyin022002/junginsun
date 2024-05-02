/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0051Event.java
*@FileTitle : AWK Cargo Basic Tariff Management
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.04
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.04 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event;


import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TES_0051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_0051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see EsdTes0051Event 참조
 * @since J2EE 1.6
 */

public class EsdTes0051Event extends EventSupport {

private static final long serialVersionUID = 1L;
	
	private	String	exlFormFlg = "";
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesAwkCgoTrfMngVO	tesAwkCgoTrfMngVO	= null;
	
	/** Table Value Object Multi Data 처리 */
	private TesAwkCgoTrfMngVO[]	tesAwkCgoTrfMngVOs	= null;

	public EsdTes0051Event(){}

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
	
	/**
	 * @return the exlFormFlg
	 */
	public String getExlFormFlg() {
		return exlFormFlg;
	}

	/**
	 * @param exlFormFlg the exlFormFlg to set
	 */
	public void setExlFormFlg(String exlFormFlg) {
		this.exlFormFlg = exlFormFlg;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



}