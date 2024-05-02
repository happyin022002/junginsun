/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonVO.java
*@FileTitle : DMTCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.06.22 황효근 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * @author Administrator
 *
 */
public class DMTCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	
	private List<TariffNameVO> tariffNameVOs = null;
	
	private String userTariffType = null;
	
	

	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getColumnValues()
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getFieldNames()
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the tariffNameVOs
	 */
	public List<TariffNameVO> getTariffNameVOs() {
		return tariffNameVOs;
	}

	/**
	 * @param tariffNameVOs the tariffNameVOs to set
	 */
	public void setTariffNameVOs(List<TariffNameVO> tariffNameVOs) {
		this.tariffNameVOs = tariffNameVOs;
	}

	/**
	 * @return the userTariffType
	 */
	public String getUserTariffType() {
		return userTariffType;
	}

	/**
	 * @param userTariffType the userTariffType to set
	 */
	public void setUserTariffType(String userTariffType) {
		this.userTariffType = userTariffType;
	}
	
	
	

}
