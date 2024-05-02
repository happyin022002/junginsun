/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0221Event.java
*@FileTitle : Port Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.05.12 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmCountryVO;


/**
 * VOP_VSK_0221 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0221HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0221HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0221Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LocationVO locationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LocationVO[] locationVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCountryVO mdmCountryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCountryVO[] mdmCountryVOs = null;

	public VopVsk0221Event(){}
	
	public void setLocationVO(LocationVO locationVO){
		this. locationVO = locationVO;
	}

	public void setLocationVOS(LocationVO[] locationVOs){
		if (locationVOs != null) {
			LocationVO[] tmpVOs = Arrays.copyOf(locationVOs, locationVOs.length);
			this.locationVOs = tmpVOs;
		} // end if
	}

	public LocationVO getLocationVO(){
		return locationVO;
	}

	public LocationVO[] getLocationVOS(){
		LocationVO[] rtnVOs = null;
		if (this.locationVOs != null) {
			rtnVOs = Arrays.copyOf(this.locationVOs, this.locationVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public void setMdmCountryVO(MdmCountryVO mdmCountryVO){
		this.mdmCountryVO = mdmCountryVO;
	}

	public void setMdmCountryVOS(MdmCountryVO[] mdmCountryVOs){
		if (mdmCountryVOs != null) {
			MdmCountryVO[] tmpVOs = Arrays.copyOf(mdmCountryVOs, mdmCountryVOs.length);
			this.mdmCountryVOs = tmpVOs;
		} // end if
	}

	public MdmCountryVO getMdmCountryVO(){
		return mdmCountryVO;
	}

	public MdmCountryVO[] getMdmCountryVOS(){
		MdmCountryVO[] rtnVOs = null;
		if (this.mdmCountryVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmCountryVOs, this.mdmCountryVOs.length);
		} // end if
		return rtnVOs;
	}
	
	

}