/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBInterfaceBC.java
*@FileTitle : 3rd Party Interface (Receive; Source=>TPB)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.tpbinterface.basic;

import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD Business Logic Command Interface<br>
 * ESD Business Logic Interface<br>
 *
 * @author 
 * @see -
 * @since J2EE 1.4
 */
public interface TPBInterfaceBC  {

	/**
	 * TES로부터 Interface Data Receiving process<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTESTPB(TPBInterfaceVO[] tpbInterfaceVO) throws EventException;

	/**
	 * Interface Data Receiving process<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTRSTPB(TPBInterfaceVO[] tpbInterfaceVO) throws EventException;

	/**
	 * Interface Data Receiving process<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTESTPB(TPBInterfaceVO[] tpbInterfaceVO, SignOnUserAccount account) throws EventException;

	/**
	 * Interface Data Receiving process<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createTRSTPB(TPBInterfaceVO[] tpbInterfaceVO, SignOnUserAccount account) throws EventException;

	/**
	 * Interface Data Receiving process<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createMNRTPB(TPBInterfaceVO[] tpbInterfaceVO) throws EventException;
	
	/**
	 * Interface Data Receiving process<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean createMNRTPB(TPBInterfaceVO[] tpbInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Flag retrieve<br>
	 * 
	 * @param TPBInterfaceVO[] tpbInterfaceVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchTpbTesDltFlg(TPBInterfaceVO[] tpbInterfaceVO) throws EventException;

}