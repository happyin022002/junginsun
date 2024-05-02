package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.basic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration.ScheduleSendManagementDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration.ScheduleSendManagementEAIDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiHdrVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

public class ScheduleSendManagementBCImpl extends BasicCommandSupport implements ScheduleSendManagementBC {
	

	// Database Access Object
	private transient ScheduleSendManagementDBDAO 		dbDao 	= null;
	private transient ScheduleSendManagementEAIDAO 		eaiDao 	= null;

	/**
	 * VesselScheduleMgtBCImpl 객체 생성<br>
	 * VesselScheduleMgtDBDAO를 생성한다.<br>
	 */
	public ScheduleSendManagementBCImpl() {
		dbDao 	= new ScheduleSendManagementDBDAO		();
		eaiDao 	= new ScheduleSendManagementEAIDAO		();
	}
	
	
	
	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VskVslSkdVO vskVslSkdVO
	 * @param String sAllnCoCd
	 * @return String
	 * @exception EventException
	 */
	public String createEdiForScheduleExchangeCKYH(VskVslSkdVO vskVslSkdVO, String sAllnCoCd) throws EventException{
		
		String 						sEdiSeq				= null;
		//List<VskVslSkdVO>			vskVslSkdVOs		= new ArrayList<VskVslSkdVO>();
		
		//List<VslSkdXchEdiHdrVO>		vslSkdXchEdiHdrVOs	= new ArrayList<VslSkdXchEdiHdrVO>();
		//List<VslSkdXchEdiDtlVO>		vslSkdXchEdiDtlVOs	= new ArrayList<VslSkdXchEdiDtlVO>();
		
		try{
			
			//vskVslSkdVOs.add(vskVslSkdVO);
			
			sEdiSeq	=	dbDao.createScheduleExchangeEdiSeq();
			
			log.info("\n\n ======== ::2007816::============== seq ["+sEdiSeq+"]\n");
			
			
			//::INSERT::VSK_VSL_SKD_XCH_EDI_HDR:://////////////////////////////////////////
			VslSkdXchEdiHdrVO			tmpHdrVO	= new VslSkdXchEdiHdrVO();
			//---------------------------------------------------------------------------//
			tmpHdrVO.setVslCdCtnt		(vskVslSkdVO.getVslCd		()	);
			tmpHdrVO.setSkdVoyNoCtnt	(vskVslSkdVO.getSkdVoyNo	()	);
			tmpHdrVO.setSkdDirCdCtnt	(vskVslSkdVO.getSkdDirCd	()	);
			tmpHdrVO.setSkdEdiRcvSeq	(sEdiSeq						);
			//------------------------------------------------------------//
			tmpHdrVO.setCoCdCtnt		(sAllnCoCd						);
			//---------------------------------------------------------------------------//
			/**************************************************************************** 
			 * EDI HEADER
			 * --------------------------------------------------------------------------
			 * $$$MSGSTART:SMCU                SND                 IFTSAI    ENT04110877629 <<== "SENDER(20)+RECEIVER(20)+MSG(10)+REFNO(14)"	
			 */

			String ediHeaderSeq	= new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
			log.info("\n\n ======== ::2007816::============== seq ["+ediHeaderSeq+"]\n");
			
			ediHeaderSeq		= sEdiSeq;

			StringBuffer sbEdiHeaderMsg	= new StringBuffer();
			////sbEdiHeaderMsg.append		("$$$MSGSTART:SMCU                SND                 IFTSAI    ENT");
			////old::bEdiHeaderMsg.append		(ediHeaderSeq.substring(6, 17));
			sbEdiHeaderMsg.append		(ediHeaderSeq					);
			
			tmpHdrVO.setEdiHdrMsg		(sbEdiHeaderMsg.toString	()	);
			//---------------------------------------------------------------------------//
			tmpHdrVO.setCreUsrId		(vskVslSkdVO.getCreUsrId	()	);
			tmpHdrVO.setUpdUsrId		(vskVslSkdVO.getUpdUsrId	()	);
			//---------------------------------------------------------------------------//
			
			////vslSkdXchEdiHdrVOs.add		(tmpHdrVO);
			dbDao.createScheduleExchangeHeader		(tmpHdrVO);
			///////////////////////////////////////////////////////////////////////////////
			
			//::INSERT::VSK_VSL_SKD_XCH_EDI_DTL:://////////////////////////////////////////
			VslSkdXchEdiDtlVO			tmpHdrVO2	= new VslSkdXchEdiDtlVO();
			tmpHdrVO2.setVslCdCtnt		(vskVslSkdVO.getVslCd		()	);
			tmpHdrVO2.setSkdVoyNoCtnt	(vskVslSkdVO.getSkdVoyNo	()	);
			tmpHdrVO2.setSkdDirCdCtnt	(vskVslSkdVO.getSkdDirCd	()	);
			tmpHdrVO2.setSkdEdiRcvSeq	(sEdiSeq						);
			tmpHdrVO2.setCreUsrId		(vskVslSkdVO.getCreUsrId	()	);
			tmpHdrVO2.setUpdUsrId		(vskVslSkdVO.getUpdUsrId	()	);
			//------------------------------------------------------------//
			tmpHdrVO2.setCoCdCtnt		(sAllnCoCd						);
			//------------------------------------------------------------//
			
			////vslSkdXchEdiDtlVOs.add		(tmpHdrVO2);
			dbDao.createScheduleExchangeDetailList	(tmpHdrVO2);
			///////////////////////////////////////////////////////////////////////////////
			
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return sEdiSeq;
	}

	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean sendEdiForScheduleExchangeCKYH(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException{
		
		boolean 					isSuccess				= false;
		
		VslSkdXchEdiHdrVO			rtnVslSkdXchEdiHdrVO	= null;
		List<VslSkdXchEdiDtlVO>		rtnVslSkdXchEdiDtlVOs	= null;
		
		try{

			//-----------------------------------------------------------------------------//

			//::SELECT::VSK_VSL_SKD_XCH_EDI_HDR::////////////////////////////////////////////
			rtnVslSkdXchEdiHdrVO	= dbDao.searchScheduleExchangeHeader		(vslSkdXchEdiHdrVO);
			
			if(rtnVslSkdXchEdiHdrVO == null)	return false;

			//::SELECT::VSK_VSL_SKD_XCH_EDI_DTL::////////////////////////////////////////////
			rtnVslSkdXchEdiDtlVOs	= dbDao.searchScheduleExchangeDetailList	(vslSkdXchEdiHdrVO);
			
			if(rtnVslSkdXchEdiDtlVOs == null)	return false;
			//-----------------------------------------------------------------------------//
			
			isSuccess				= eaiDao.sendEdiForScheduleExchangeCKYH	(rtnVslSkdXchEdiHdrVO, rtnVslSkdXchEdiDtlVOs);

			//-----------------------------------------------------------------------------//
			
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isSuccess;
	}
	
	
}
