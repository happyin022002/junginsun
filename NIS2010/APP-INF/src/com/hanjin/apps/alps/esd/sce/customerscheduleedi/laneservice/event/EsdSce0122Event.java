/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0122Event.java
*@FileTitle : Lane Service
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.12.18 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.vo.SearchLaneServiceVO;


/**
 * ESD_SCE_122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_122HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see ESD_SCE_122HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce0122Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private SearchLaneServiceVO laneServiceVO = null;
	
	private SearchLaneServiceVO[] laneServiceVOs = null;
	
	private String          partnerName;
	
	private String          custTrdPrnrId;

	public EsdSce0122Event(){}

	/**
	 * @return the laneServiceVO
	 */
	public SearchLaneServiceVO getSearchLaneServiceVO() {
		return laneServiceVO;
	}

	/**
	 * @param laneServiceVO the laneServiceVO to set
	 */
	public void setSearchLaneServiceVO(SearchLaneServiceVO laneServiceVO) {
		this.laneServiceVO = laneServiceVO;
	}

	/**
	 * @return the laneServiceVOs
	 */
	public SearchLaneServiceVO[] getSearchLaneServiceVOs() {
		return laneServiceVOs;
	}

	/**
	 * @param laneServiceVOs the laneServiceVOs to set
	 */
	public void setSearchLaneServiceVOs(SearchLaneServiceVO[] laneServiceVOs) {
		this.laneServiceVOs = laneServiceVOs;
	}

	/**
	 * @return the partnerName
	 */
	public String getPartnerName() {
		return partnerName;
	}

	/**
	 * @return the custTrdPrnrId
	 */
	public String getPartnerId() {
		return custTrdPrnrId;
	}

	/**
	 * @param custTrdPrnrId the custTrdPrnrId to set
	 */
	public void setPartnerId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
	}

	/**
	 * @param partnerName the partnerName to set
	 */
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	
	/**
	 * ESD_PRD_122Event's putValue
	 * @param key
	 * @param value void
	 */
	public void putValue(String key, Object value){
		if(key==null) return;
		this.setAttribute(key, value);
	}
	
	public String getString(String key){
		Object tmp = this.getObject(key);
		return (tmp==null) ? "" : (String)tmp;
	}

	public Object getObject(String key){
		return (key==null) ? null : this.getAttribute(key);
	}
	
}