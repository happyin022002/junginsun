/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0083Event.java
*@FileTitle : Node Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.20 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0083HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0083Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private NodeListVO nodeListVO = null;
	private NodeListInputVO nodeListInputVO = null;

	/** Table Value Object Multi Data 처리 */
	private NodeListVO[] nodeListVOs = null;

	public EsmBkg0083Event(){}

	public void setNodeListVO(NodeListVO nodeListVO){
		this. nodeListVO = nodeListVO;
	}

	public void setNodeListInputVO(NodeListInputVO nodeListInputVO){
		this. nodeListInputVO = nodeListInputVO;
	}

	public void setNodeListVOS(NodeListVO[] nodeListVOs){
		this. nodeListVOs = nodeListVOs;
	}

	public NodeListVO getNodeListVO(){
		return nodeListVO;
	}

	public NodeListVO[] getNodeListVOs(){
		return nodeListVOs;
	}

	public NodeListInputVO getNodeListInputVO(){
		return nodeListInputVO;
	}
	
	private LocationListInputVO locationListInputVO = null;
	
	public LocationListInputVO getLocationListInputVO(){
		return locationListInputVO;
	}
	
	public void setLocationListInputVO(LocationListInputVO locationListInputVO){
		this. locationListInputVO = locationListInputVO;
	}
}