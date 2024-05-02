/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeManagementEvent.java
*@FileTitle : Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.07.02 정인선
* 1.0 Creation 
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.OfficeMappingVO;


/**
 * Office_Management 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  Office_ManagementHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung In Sun
 * @see Office_ManagementHTMLAction 참조
 * @since J2EE 1.6
 */

public class AdmSys0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OfficeMappingVO officeMappingVO = null;

	/** Table Value Object Multi Data 처리 */
	private OfficeMappingVO[] officeMappingVOs = null;

	/**
	 * @return the officeMappingVO
	 */
	public OfficeMappingVO getOfficeMappingVO() {
		return officeMappingVO;
	}

	/**
	 * @param officeMappingVO the officeMappingVO to set
	 */
	public void setOfficeMappingVO(OfficeMappingVO officeMappingVO) {
		this.officeMappingVO = officeMappingVO;
	}

	/**
	 * @return the officeMappingVOs
	 */
	public OfficeMappingVO[] getOfficeMappingVOs() {
		OfficeMappingVO[] rtnVOs = null;
		if(this.officeMappingVOs != null){
			rtnVOs = Arrays.copyOf(this.officeMappingVOs,this.officeMappingVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param officeMappingVOs the officeMappingVOs to set
	 */
	public void setOfficeMappingVOs(OfficeMappingVO[] officeMappingVOs) {
		if(officeMappingVOs != null){
			OfficeMappingVO[] tempVOs = Arrays.copyOf(officeMappingVOs, officeMappingVOs.length);
			this.officeMappingVOs = tempVOs;
		}	
	}

}