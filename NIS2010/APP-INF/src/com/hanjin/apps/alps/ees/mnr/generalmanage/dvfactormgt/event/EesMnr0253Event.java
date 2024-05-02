/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EssMnr0253Event.java
*@FileTitle : Container Seal No-Creation
*Open Issues :	ALPS [EES_MNR_0253]Container Seal No-Creation 를 조회, 등록,수정,삭제하는 화면
*Change history :
*@LastModifyDate : 2011.06.20
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.03.30 김영오
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
*                                      - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
*                                      - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealNoCreationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_MNR_0253 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0253HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김영오
 * @see EES_MNR_0253HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesMnr0253Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	public EesMnr0253Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ContainerSealNoCreationVO containerSealNoCreationVO = null;

	/** Table Value Object Multi Data 처리 */
	private ContainerSealNoCreationVO[] containerSealNoCreationVOs = null;


	public ContainerSealNoCreationVO getContainerSealNoCreationVO() {
		return containerSealNoCreationVO;
	}

	public void setContainerSealNoCreationVO(
		ContainerSealNoCreationVO containerSealNoCreationVO) {
			this.containerSealNoCreationVO = containerSealNoCreationVO;
	}


	public ContainerSealNoCreationVO[] getContainerSealNoCreationVOs() {
		return containerSealNoCreationVOs;
	}

	public void setContainerSealNoCreationVOs(
		ContainerSealNoCreationVO[] containerSealNoCreationVOs) {
			this.containerSealNoCreationVOs = containerSealNoCreationVOs;
	}


}