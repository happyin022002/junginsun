/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0051Event.java
*@FileTitle : BOD, BOR Monthly Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.26
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.26 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGINSUN
 * @see ESM_FMS_0050HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0051Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** BnkYrmon Target Month */
	private String bnkYrmon = "";


	public EsmFms0051Event(){}
	
	public String getBnkYrmon() {
		return bnkYrmon;
	}

	public void setBnkYrmon(String bnkYrmon) {
		this.bnkYrmon = bnkYrmon;
	}

}
