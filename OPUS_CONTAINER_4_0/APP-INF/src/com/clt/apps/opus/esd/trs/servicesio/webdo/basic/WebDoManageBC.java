/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : WebDoManageBC.java
 *@FileTitle : USA Delivery Order class 를 구동한다.
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-10-07
 *@LastModifier : Choi jonghyek
 *@LastVersion : 1.0
 * 2011-10-07 Choi jonghyek
 * 1.0 Creation
 * 2011.12.09 김종호 [CHM-201113793] [TRS] HJS Homepage Renewal - ALPS 외부 I/F 개발(Webservice)
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.webdo.basic;

import com.clt.apps.opus.esd.trs.servicesio.webdo.vo.IfSchemaVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * ALPS-Replanmanage Business Logic Command Interface<br>
 * - ALPS-Replanmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Choi jonghyek
 * @see IfSchemaVO
 * @since J2EE 1.6
 */
public interface WebDoManageBC {

	/**
	 * US Delivery Order Insert/Update
	 * 
	 * @param ifSchemaVO
	 * @return int
	 * @throws EventException
	 */
	public int multiUsDo(IfSchemaVO ifSchemaVO) throws EventException;
}