/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0217Event.java
*@FileTitle : M&R Colleague Tree
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.ColleagueTreeGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.event.EES_MNR_0112HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author chung young hun
 * @see EES_MNR_0112HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0217Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ColleagueTreeGRPVO colleagueTreeGRPVO ;
	


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



	public ColleagueTreeGRPVO getColleagueTreeGRPVO() {
		return colleagueTreeGRPVO;
	}



	public void setColleagueTreeGRPVO(ColleagueTreeGRPVO colleagueTreeGRPVO) {
		this.colleagueTreeGRPVO = colleagueTreeGRPVO;
	}


	
	

}