/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRBookingInterface.java
*@FileTitle : BDRBookingInterface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.10.30 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bdrbookinginterface.bdrbookinginterface.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bdrbookinginterface.bdrbookinginterface.vo.BdrBkgNoVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * BDR Booking Setting 을 위한 비즈니스 인터페이스<br>
 *
 * @author Ilmin Lee
 * @see 
 * @since J2EE 1.4
 */
public interface BDRBookingInterfaceBC {

	/**
	 * manageBdrBookingList
	 * 
	 * @return List<BdrBkgNoVO>
	 * @exception EventException
	 */
	public List<BdrBkgNoVO> manageBdrBookingList() throws EventException;

	/**
	 * manageBdrBookingListTest
	 * 
	 * @return List<BdrBkgNoVO>
	 * @exception EventException
	 */
	public List<BdrBkgNoVO> manageBdrBookingListTest() throws EventException;

	/**
	 * setupFocByObl
	 * 
	 * @param List<BdrBkgNoVO>
	 * @exception EventException
	 */
	public void setupFocByOblAutoBdr(List<BdrBkgNoVO> bdrBkgNoList) throws EventException;
}
