/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EstimateUploadGRPVO.java
*@FileTitle : EstimateUploadGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.19
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.19 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;


import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.framework.component.common.AbstractValueObject;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EstimateUploadGRPVO {

	private static final long serialVersionUID = 1L;

	private List<String> estimateUploadPK = null;

	/** Table Value Object Single Data 처리 */
	private EstimateUploadVO estimateUploadVO = null;

	/** Table Value Object Multi Data 처리 */
	private EstimateUploadVO[] estimateUploadVOs = null;

	private List<InterfaceGRPVO> interfaceGRPVOList = null;

	/**
	 * @return the estimateUploadPK
	 */
	public List<String> getEstimateUploadPK() {
		return estimateUploadPK;
	}

	public String getEstimateUploadPkStr() {
			return estimateUploadPK.toString().replaceAll("\\[", "").replaceAll("\\]", "");
	}

	/**
	 * @param estimateUploadPK the estimateUploadPK to set
	 */
	public void setEstimateUploadPK(List<String> estimateUploadPK) {
		this.estimateUploadPK = estimateUploadPK;
	}

	/**
	 * @return the estimateUploadVO
	 */
	public EstimateUploadVO getEstimateUploadVO() {
		return estimateUploadVO;
	}

	/**
	 * @param estimateUploadVO the estimateUploadVO to set
	 */
	public void setEstimateUploadVO(EstimateUploadVO estimateUploadVO) {
		this.estimateUploadVO = estimateUploadVO;
	}

	/**
	 * @return the estimateUploadVOs
	 */
	public EstimateUploadVO[] getEstimateUploadVOs() {
		return estimateUploadVOs;
	}

	/**
	 * @param estimateUploadVOs the estimateUploadVOs to set
	 */
	public void setEstimateUploadVOs(EstimateUploadVO[] estimateUploadVOs) {
		this.estimateUploadVOs = estimateUploadVOs;
	}

	/**
	 * @return the interfaceGRPVOList
	 */
	public List<InterfaceGRPVO> getInterfaceGRPVOList() {
		return interfaceGRPVOList;
	}

	/**
	 * @param interfaceGRPVOList the interfaceGRPVOList to set
	 */
	public void setInterfaceGRPVOList(List<InterfaceGRPVO> interfaceGRPVOList) {
		this.interfaceGRPVOList = interfaceGRPVOList;
	}
}
