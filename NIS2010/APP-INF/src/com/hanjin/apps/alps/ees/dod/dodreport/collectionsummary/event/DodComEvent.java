/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DodComEvent.java   
*@FileTitle : Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-20
*@LastModifier : Won-Ki Eo
*@LastVersion : 1.0
* 2016-05-20 Won-Ki Eo
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event;

import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.OfficeByRHQVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.OfficeCommonVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.OfficeSubVO;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * DodComEvent PDTO(Data Transfer Object including Parameters)<br>
 * @author Won-Ki Eo
 * @see EventSupport 참조 
 * @since J2EE 1.4
 */
public class DodComEvent extends EventSupport {

	private static final long serialVersionUID = -1909705464706058031L;
	
	private OfficeByRHQVO officeByRHQVO = null;
	private OfficeCommonVO officeCommonVO = null;
	private OfficeSubVO officeSubVO = null;



	public OfficeCommonVO getOfficeCommonVO() {
		return officeCommonVO;
	}

	public void setOfficeCommonVO(OfficeCommonVO officeCommonVO) {
		this.officeCommonVO = officeCommonVO;
	}

	public OfficeByRHQVO getOfficeByRHQVO() {
		return officeByRHQVO;
	}

	public void setOfficeByRHQVO(OfficeByRHQVO officeByRHQVO) {
		this.officeByRHQVO = officeByRHQVO;
	}

	public OfficeSubVO getOfficeSubVO() {
		return officeSubVO;
	}

	public void setOfficeSubVO(OfficeSubVO officeSubVO) {
		this.officeSubVO = officeSubVO;
	}
	
}
