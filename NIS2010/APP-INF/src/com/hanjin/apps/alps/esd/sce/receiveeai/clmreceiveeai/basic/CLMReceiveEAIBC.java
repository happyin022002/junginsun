/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : CLMReceiveEAIBC.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-01
*@LastModifier : 
*@LastVersion : 1.0
* 2009-11-01 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.receiveeai.clmreceiveeai.basic;

import java.util.ArrayList;

import com.hanjin.framework.core.layer.event.EventException;
/**
 * ENIS-SCEM EDI Clm Message
 * - ENIS-SCEM EDI Clm Message에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author 
 * @see EsdSce085Event 참조
 * @since J2EE 1.4
 */ 
public interface CLMReceiveEAIBC{
	
	/**
	 * CLM MSG를 FF에서 분리
	 * @param String inv
	 * @throws EventException
	 */
	public void getEDIClmDataFormat(String inv)throws EventException;
	
	/**
	 * create EDI CLM Temp Data
	 * @param ArrayList totalParamArrLst
	 * @throws EventException
	 */
	public void createEDIClmTmpData(ArrayList totalParamArrLst)throws EventException;

	
}