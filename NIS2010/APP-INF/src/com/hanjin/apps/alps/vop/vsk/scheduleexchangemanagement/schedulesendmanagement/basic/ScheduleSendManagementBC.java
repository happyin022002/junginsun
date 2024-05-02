package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.basic;

import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiHdrVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

public interface ScheduleSendManagementBC {

	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VskVslSkdVO vskVslSkdVO
	 * @param String sAllnCoCd
	 * @return String
	 * @exception EventException
	 */
	public String createEdiForScheduleExchangeCKYH(VskVslSkdVO vskVslSkdVO, String sAllnCoCd) throws EventException;

	
	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean sendEdiForScheduleExchangeCKYH(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException;
	
}
