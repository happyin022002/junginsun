/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0024Event.java
*@FileTitle :  Container Status Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.29 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrStatusCreationVO;
/**
 * EES_MST_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @return the cntrStatusCreationVO
	 */
	public CntrStatusCreationVO getCntrStatusCreationVO() {
		return cntrStatusCreationVO;
	}

	/**
	 * @param cntrStatusCreationVO the cntrStatusCreationVO to set
	 */
	public void setCntrStatusCreationVO(CntrStatusCreationVO cntrStatusCreationVO) {
		this.cntrStatusCreationVO = cntrStatusCreationVO;
	}

	/**
	 * @return the cntrStatusCreationVOs
	 */
	public CntrStatusCreationVO[] getCntrStatusCreationVOs() {
		return cntrStatusCreationVOs;
	}

	/**
	 * @param cntrStatusCreationVOs the cntrStatusCreationVOs to set
	 */
	public void setCntrStatusCreationVOs(
			CntrStatusCreationVO[] cntrStatusCreationVOs) {
		this.cntrStatusCreationVOs = cntrStatusCreationVOs;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrStatusCreationVO cntrStatusCreationVO = null;
	
	/** 검색결과 **/
	public CntrStatusCreationVO[] cntrStatusCreationVOs = null;	

}