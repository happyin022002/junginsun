/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0083Event.java
*@FileTitle : Office Mapping Management
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.16
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.11.16 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CustomSearchOfficeMappingManagementVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jongkyu Weon
 * @see FNS_JOO_0083HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0083Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO = null;
	
	private JooCodeParamVO jooCodeParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomSearchOfficeMappingManagementVO[] customSearchOfficeMappingManagementVOs = null;

	public FnsJoo0083Event(){}

	public CustomSearchOfficeMappingManagementVO getCustomSearchOfficeMappingManagementVO() {
		return customSearchOfficeMappingManagementVO;
	}

	public void setCustomSearchOfficeMappingManagementVO(
			CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO) {
		this.customSearchOfficeMappingManagementVO = customSearchOfficeMappingManagementVO;
	}

	public CustomSearchOfficeMappingManagementVO[] getCustomSearchOfficeMappingManagementVOs() {
		CustomSearchOfficeMappingManagementVO[] rtnVOs = null;
		if (this.customSearchOfficeMappingManagementVOs != null) {
			rtnVOs = new CustomSearchOfficeMappingManagementVO[customSearchOfficeMappingManagementVOs.length];
			System.arraycopy(customSearchOfficeMappingManagementVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setCustomSearchOfficeMappingManagementVOs(
			CustomSearchOfficeMappingManagementVO[] customSearchOfficeMappingManagementVOs) {
		if (customSearchOfficeMappingManagementVOs != null) {
			CustomSearchOfficeMappingManagementVO[] tmpVOs = new CustomSearchOfficeMappingManagementVO[customSearchOfficeMappingManagementVOs.length];
			System.arraycopy(customSearchOfficeMappingManagementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customSearchOfficeMappingManagementVOs = tmpVOs;
		}				
	}

	public JooCodeParamVO getJooCodeParamVO() {
		return jooCodeParamVO;
	}

	public void setJooCodeParamVO(JooCodeParamVO jooCodeParamVO) {
		this.jooCodeParamVO = jooCodeParamVO;
	}
}