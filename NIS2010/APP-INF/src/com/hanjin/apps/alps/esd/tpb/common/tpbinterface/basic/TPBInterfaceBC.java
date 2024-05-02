/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBInterfaceBC.java
*@FileTitle : 3자구상 Interface (Receive; Source=>TPB)
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-20
*@LastModifier : O Wan-Ki
*@LastVersion : 1.0
* 2009-08-20 O Wan-Ki 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic;

import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ENIS-ESD Business Logic Command Interface<br>
 * - ENIS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author O Wan-Ki
 * @see -
 * @since J2EE 1.4
 */
public interface TPBInterfaceBC  {

	/**
	 * TES로부터 Interface Data Receiving 처리<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTESTPB(TPBInterfaceVO[] tpbInterfaceVO) throws EventException;

	/**
	 * TRS로부터 Interface Data Receiving 처리<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTRSTPB(TPBInterfaceVO[] tpbInterfaceVO) throws EventException;

	/**
	 * TES로부터 Interface Data Receiving 처리<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTESTPB(TPBInterfaceVO[] tpbInterfaceVO, SignOnUserAccount account) throws EventException;

	/**
	 * TRS로부터 Interface Data Receiving 처리<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTRSTPB(TPBInterfaceVO[] tpbInterfaceVO, SignOnUserAccount account) throws EventException;

	/**
	 * MNR로부터 Interface Data Receiving 처리<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createMNRTPB(TPBInterfaceVO[] tpbInterfaceVO) throws EventException;
	
	/**
	 * MNR로부터 Interface Data Receiving 처리<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createMNRTPB(TPBInterfaceVO[] tpbInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * TES로부터 I/F된 대상 Delete 여부 Flag 조회 처리<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchTpbTesDltFlg(TPBInterfaceVO[] tpbInterfaceVO) throws EventException;

}