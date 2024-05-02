package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiHdrVO;
import com.hanjin.framework.core.layer.event.EventException;

public interface ScheduleReceiveManagementBC {


	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param String sFlatFile
	 * @return List<VslSkdXchEdiHdrVO>
	 * @exception EventException
	 */
	public List<VslSkdXchEdiHdrVO> createEdiLogFromScheduleExchangeCKYH(String sFlatFile) throws EventException;

	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @exception EventException
	 */
	public void modifyEdiLogFromScheduleExchangeCKYH(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException;
	
	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @exception EventException
	 */
	public void updateCoastalSchedulebyEDICKYH(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException;
	
	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @return VslSkdXchEdiHdrVO
	 * @exception EventException
	 */
	public VslSkdXchEdiHdrVO selectVesselScheduleExchangeEdiHdr(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException;
	
	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String checkScheduleMappingProcRemark(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException;	

	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @return List<VslSkdXchEdiDtlVO>
	 * @exception EventException
	 */
	public List<VslSkdXchEdiDtlVO> selectVesselScheduleExchangeEdiDtlList(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException;
	
	
}
