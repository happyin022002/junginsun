/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerSealNoCreationGRPVO.java
*@FileTitle : ContainerSealNoCreationGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.20
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.06.20 김영오
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
*                                      - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
*                                      - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo;
import java.util.List;
/**
 * Container Seal No-Creation GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김영오
 * @since J2EE 1.6
 * @see
 */
public class ContainerSealNoCreationGRPVO {
	//조회조건을 받기위한
	private ContainerSealNoCreationVO ContainerSealNoCreationVO= null;
	//조회조건 및 단건 조회결과를 받기위한
	private List<ContainerSealNoCreationVO> containerSealNoCreationVOs = null;
	//다중 조회 결과를 받기위한
	private List<List<ContainerSealNoCreationVO>> listContainerSealNoCreationVOs = null;
	//CUD처리를 위한
	private ContainerSealNoCreationVO[] arrayContainerSealNoCreationVOs = null;

	public ContainerSealNoCreationVO getContainerSealNoCreationVO() {
		return ContainerSealNoCreationVO;
	}
	public void setContainerSealNoCreationVO(
		ContainerSealNoCreationVO containerSealNoCreationVO) {
			this.ContainerSealNoCreationVO = containerSealNoCreationVO;
	}
	public List<ContainerSealNoCreationVO> getContainerSealNoCreationVOs() {
		return containerSealNoCreationVOs;
	}
	public void setContainerSealNoCreationVOs(
		List<ContainerSealNoCreationVO> containerSealNoCreationVOs) {
			this.containerSealNoCreationVOs = containerSealNoCreationVOs;
	}
	public List<List<ContainerSealNoCreationVO>> getListContainerSealNoCreationVOs() {
		return listContainerSealNoCreationVOs;
	}
	public void setListContainerSealNoCreationVOs(
		List<List<ContainerSealNoCreationVO>> listContainerSealNoCreationVOs) {
			this.listContainerSealNoCreationVOs = listContainerSealNoCreationVOs;
	}
	public ContainerSealNoCreationVO[] getArrayContainerSealNoCreationVOs() {
		return arrayContainerSealNoCreationVOs;
	}
	public void setArrayContainerSealNoCreationVOs(
		ContainerSealNoCreationVO[] arrayContainerSealNoCreationVOs) {
			this.arrayContainerSealNoCreationVOs = arrayContainerSealNoCreationVOs;
	}


}
