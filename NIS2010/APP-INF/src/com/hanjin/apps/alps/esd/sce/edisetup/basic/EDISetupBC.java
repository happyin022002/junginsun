/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EDISetupBC.java
*@FileTitle : EDISetupBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-07
*@LastModifier : 전병석
*@LastVersion : 1.2
* 2009-09-07 전병석
* 1.0 최초 생성
* 2009-10-06 
* 1.2 버전 생성 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edisetup.basic;


import com.hanjin.framework.core.layer.event.EventException;

/**
 * ENIS-SCEM Business Logic Command Interface<br>
 * - ENIS-SCEM에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yongcheonshin
 * @see EdiSendEventResponse 참조
 * @since J2EE 1.4
 */

public interface EDISetupBC {
	    /** EAI receive ESD031 로직 처리 - edi cgo standard status table sync
	     * @param  String str
	     * @throws EventException
	     */
	   public void syncEdi_cgo_stnd_sts(String str) throws EventException; 
	    
	    /** EAI receive ESD032 로직 처리 - edi group table sync
	     * @param  String str
	     * @throws EventException
	     */
	    public void syncEdi_group(String str) throws EventException; 
	    
	    /** EAI receive ESD033 로직 처리 - edi grp cgo table sync
	     * @param  String str
	     * @throws EventException
	     */
	    public void syncEdi_grp_cgo(String str) throws EventException; 
	    
	    /** EAI receive ESD034 로직 처리 - edi group customer table sync
	     * @param  String str
	     * @throws EventException
	     */
	    public void syncEdi_grp_cust(String str) throws EventException; 
	}
