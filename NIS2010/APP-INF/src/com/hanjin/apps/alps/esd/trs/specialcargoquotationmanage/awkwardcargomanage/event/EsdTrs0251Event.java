/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTrs0251Event.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.07
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.07 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.event;


import com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.vo.TrsAwkCgoTrfMngVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TRS_0251 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_0251HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see EsdTrs0251Event 참조
 * @since J2EE 1.6
 */

public class EsdTrs0251Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TrsAwkCgoTrfMngVO	trsAwkCgoTrfMngVO	= null;
	
	/** Table Value Object Multi Data 처리 */
	private TrsAwkCgoTrfMngVO[]	trsAwkCgoTrfMngVOs	= null;

	public EsdTrs0251Event(){}

	public TrsAwkCgoTrfMngVO getTrsAwkCgoTrfMngVO() {
		return trsAwkCgoTrfMngVO;
	}

	public void setTrsAwkCgoTrfMngVO(TrsAwkCgoTrfMngVO trsAwkCgoTrfMngVO) {
		this.trsAwkCgoTrfMngVO = trsAwkCgoTrfMngVO;
	}

	public TrsAwkCgoTrfMngVO[] getTrsAwkCgoTrfMngVOs() {
		return trsAwkCgoTrfMngVOs;
	}

	public void setTrsAwkCgoTrfMngVOs(TrsAwkCgoTrfMngVO[] trsAwkCgoTrfMngVOs) {
		this.trsAwkCgoTrfMngVOs = trsAwkCgoTrfMngVOs;
	}

	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}




}