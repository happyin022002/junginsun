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
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event;

import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmCountryVO;


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
		if(locationVOs != null){
			LocationVO[] tmpVOs = new LocationVO[locationVOs.length];
			System.arraycopy(locationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.locationVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this. locationVOs = locationVOs;
	}

	public LocationVO getLocationVO(){
		return locationVO;
	}

	public LocationVO[] getLocationVOS(){
		LocationVO[] rtnVOs =  null;
		if(this.locationVOs != null){
			rtnVOs = new LocationVO[locationVOs.length];
			System.arraycopy(locationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return locationVOs;
	}
	
	public void setMdmCountryVO(MdmCountryVO mdmCountryVO){
		this.mdmCountryVO = mdmCountryVO;
	}

	public void setMdmCountryVOS(MdmCountryVO[] mdmCountryVOs){
		if(mdmCountryVOs != null){
			MdmCountryVO[] tmpVOs = new MdmCountryVO[mdmCountryVOs.length];
			System.arraycopy(mdmCountryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmCountryVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.mdmCountryVOs = mdmCountryVOs;
	}

	public MdmCountryVO getMdmCountryVO(){
		return mdmCountryVO;
	}

	public MdmCountryVO[] getMdmCountryVOS(){
		MdmCountryVO[] rtnVOs =  null;
		if(this.mdmCountryVOs != null){
			rtnVOs = new MdmCountryVO[mdmCountryVOs.length];
			System.arraycopy(mdmCountryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.16
		//return mdmCountryVOs;
	}
	
	

}