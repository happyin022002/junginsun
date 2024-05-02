/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0055Event.java
*@FileTitle : AWK Cargo Tariff Inquiry - Load/Unloading
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.12
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.12 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event;


import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TES_0055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_0055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see EsdTes0055Event 참조
 * @since J2EE 1.6
 */

public class EsdTes0055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesAwkCgoTrfMngVO	tesAwkCgoTrfMngVO	= null;
	
	/** Table Value Object Multi Data 처리 */
	private TesAwkCgoTrfMngVO[]	tesAwkCgoTrfMngVOs	= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AwkCgoExtraCostByRouteVO	awkCgoExtraCostByRouteVO	= null;
	
	/** Table Value Object Multi Data 처리 */
	private AwkCgoExtraCostByRouteVO[]	awkCgoExtraCostByRouteVOs	= null;

	public EsdTes0055Event(){}

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
	
	
	
	public AwkCgoExtraCostByRouteVO getAwkCgoExtraCostByRouteVO() {
		return awkCgoExtraCostByRouteVO;
	}

	public void setAwkCgoExtraCostByRouteVO(AwkCgoExtraCostByRouteVO awkCgoExtraCostByRouteVO) {
		this.awkCgoExtraCostByRouteVO = awkCgoExtraCostByRouteVO;
	}

	public AwkCgoExtraCostByRouteVO[] getAwkCgoExtraCostByRouteVOs() {
		return awkCgoExtraCostByRouteVOs;
	}

	public void setAwkCgoExtraCostByRouteVOs(AwkCgoExtraCostByRouteVO[] awkCgoExtraCostByRouteVOs) {
		this.awkCgoExtraCostByRouteVOs = awkCgoExtraCostByRouteVOs;
	}

	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



}