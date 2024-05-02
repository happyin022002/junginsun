/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0057Event.java
*@FileTitle : Tariff Condition List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.06
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.04 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.event;


import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.vo.ComTesTrfCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TES_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민 
 * @see EsdTes0057Event 참조
 * @since J2EE 1.6
 */

public class EsdTes0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComTesTrfCondVO	comTesTrfCondVO	= null;
	
	/** Table Value Object Multi Data 처리 */
	private ComTesTrfCondVO[]	comTesTrfCondVOs	= null;

	public EsdTes0057Event(){}

	public ComTesTrfCondVO getComTesTrfCondVO() {
		return comTesTrfCondVO;
	}

	public void setComTesTrfCondVO(ComTesTrfCondVO comTesTrfCondVO) {
		this.comTesTrfCondVO = comTesTrfCondVO;
	}

	public ComTesTrfCondVO[] getComTesTrfCondVOs() {
		return comTesTrfCondVOs;
	}

	public void setComTesTrfCondVOs(ComTesTrfCondVO[] comTesTrfCondVOs) {
		this.comTesTrfCondVOs = comTesTrfCondVOs;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



}