/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrsInterfaceBC.java
*@FileTitle : TrsInterface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-19
*@LastModifier : changgyu kim
*@LastVersion : 1.0
* 2007-01-19 changgyu kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.common.online.basic;

import com.clt.framework.core.layer.event.EventException;

/**
 * SCEM Business Logic Command Interface<br>
 * - SCEM에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author changgyu kim
 * @see 
 * @since J2EE 1.4
 */
public interface TrsInterfaceBC {	

	/**
     * S/O Status Upate<br>
     * 
     * @param vo TransportationVo
     * @exception EventException
     */
//	public TrsInterfaceEventResponse modifyTrsStatus(TrsInterfaceEvent vo) throws EventException;
	
	
	/** Batch Server Restart 시호출되어지는 Function 비정상 종료 데이터 다시 원복.
     * @throws EventException
     */
    public void modifyTbPatch() throws EventException;
	
	/**
     * Cost Group call<br>
     * 
     * @param bkg_no String
     * @param bkg_no_split String
     * @param cntr_no String
     * @param cop_no String
     * @param usr_id String
     * @exception EventException
     */
//	public void modifyCost(String bkg_no, String bkg_no_split, String cntr_no, String cop_no, String usr_id) throws EventException;
}
