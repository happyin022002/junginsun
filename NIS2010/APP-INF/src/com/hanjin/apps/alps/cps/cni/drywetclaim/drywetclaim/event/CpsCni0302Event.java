/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsCni0302Event.java
*@FileTitle : Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event;

import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CondSearchStatusListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * CPS_CNI_0302 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CPS_CNI_0302HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see CPS_CNI_0302HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0302Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchStatusListVO condSearchStatusListVO = null;

	public CpsCni0302Event(){}
	
	public void setCondSearchStatusListVO(CondSearchStatusListVO condSearchStatusListVO){
		this. condSearchStatusListVO = condSearchStatusListVO;
	}

	public CondSearchStatusListVO getCondSearchStatusListVO(){
		return condSearchStatusListVO;
	}

}