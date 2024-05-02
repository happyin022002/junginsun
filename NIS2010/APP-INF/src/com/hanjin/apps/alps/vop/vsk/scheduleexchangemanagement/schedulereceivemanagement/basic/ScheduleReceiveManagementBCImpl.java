package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration.ScheduleReceiveManagementDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration.ScheduleSendManagementDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiHdrVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

public class ScheduleReceiveManagementBCImpl extends BasicCommandSupport implements ScheduleReceiveManagementBC {
	
	// Database Access Object
	private transient ScheduleReceiveManagementDBDAO 		dbDao 	= null;
	private transient ScheduleSendManagementDBDAO 			dbDao1 	= null;

	/**
	 * VesselScheduleMgtBCImpl 객체 생성<br>
	 * VesselScheduleMgtDBDAO를 생성한다.<br>
	 */
	public ScheduleReceiveManagementBCImpl() {
		dbDao 	= new ScheduleReceiveManagementDBDAO	();
		dbDao1 	= new ScheduleSendManagementDBDAO		();
	}


	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param String sFlatFile
	 * @return List<VslSkdXchEdiHdrVO>
	 * @exception EventException
	 */
	public List<VslSkdXchEdiHdrVO> createEdiLogFromScheduleExchangeCKYH(String sRawFlatFile) throws EventException{
		
		List<VslSkdXchEdiHdrVO>		vslSkdXchEdiHdrVOs	= new ArrayList<VslSkdXchEdiHdrVO>();
		List<VslSkdXchEdiDtlVO>		vslSkdXchEdiDtlVOs	= new ArrayList<VslSkdXchEdiDtlVO>();
		
		String 						sEdiSeq				= null;
		
		try{
			
//			################ MQ 메세지 원본 컬럼단위로 쪼개기 ################
			ArrayList<String>	arrFlatFileList		= new ArrayList<String>();
			StringTokenizer		stFlatFileList		= new StringTokenizer(sRawFlatFile, "\n");
			
			while(stFlatFileList.hasMoreTokens()){
				arrFlatFileList.add(stFlatFileList.nextToken());
			}
			
			if(arrFlatFileList == null || arrFlatFileList.size() == 0)	return null;

			sEdiSeq						=	dbDao1.createScheduleExchangeEdiSeq();
			
			VslSkdXchEdiHdrVO			tmpHdrVO			= new VslSkdXchEdiHdrVO();
			VslSkdXchEdiDtlVO			tmpDtlVO			= null;
			
			String						sTmpSkdVoyNo		= null;
			String						sTmpSkdDirCd		= null;
			String						sTmpAllnCoCd		= null;
			
			String						sTmpHdrMsg			= null;
			String						sTmpArrElement[]	= new String[2];	
			
			for(int i=0; i<arrFlatFileList.size(); i++){
				
				////String		sTmpArrElement[1]		= arrFlatFileList.get(i);
				if(i==0){
					sTmpHdrMsg	= arrFlatFileList.get(i);
				}else{
					sTmpArrElement	= arrFlatFileList.get(i).trim().split(":");
				}
				
				String		sPreElement		= "";
				String		sPostElement	= "";
				
				for(int j=0; j<sTmpArrElement.length; j++){
					if(j==0)	sPreElement		= sTmpArrElement[j];
					if(j==1)	sPostElement	= sTmpArrElement[j];
				}
				
				//::header message:://
				//if(i==0)	sbHdrMsg.append(sPreElement).append(sPostElement);
				
				log.info("\n ========::2007816::======= arr inx ["+i+"] :: ["+sPreElement+"] --:-- ["+sPostElement+"]\n");
				
				if(i==0){
					tmpHdrVO.setEdiHdrMsg(sTmpHdrMsg);
				}else if("FUNC_CD".equals(sPreElement)){
					tmpHdrVO.setEdiFuncCdCtnt(sPostElement);		//FUNC_CD		:	N
				}else if("CO_CD".equals(sPreElement)){
					tmpHdrVO.setCoCdCtnt(sPostElement);				//CO_CD			:	SML
					sTmpAllnCoCd	= sPostElement;
				}else if("VSL_SLAN_CD".equals(sPreElement)){
					tmpHdrVO.setVslSlanCdCtnt(sPostElement);		//VSL_SLAN_CD	:	CAX
				}else if("SKD_CNG_STS_CD".equals(sPreElement)){
					tmpHdrVO.setSkdCngStsCdCtnt(sPostElement);		//SKD_CNG_STS_CD:	S
				}else if("VSL_CD".equals(sPreElement)){
					tmpHdrVO.setVslCdCtnt(sPostElement);			//VSL_CD		:	KCIB
				}else if("CALLSIGN".equals(sPreElement)){
					tmpHdrVO.setCallSgnNo(sPostElement);			//CALLSIGN		:	DSQL8
				}else if("SKD_VOYAGE_NO".equals(sPreElement)){
					tmpHdrVO.setSkdVoyNoCtnt(sPostElement);			//SKD_VOYAGE_NO	:	0030
					
					sTmpSkdVoyNo	= sPostElement;
					
				}else if("SKD_DIR_CD".equals(sPreElement)){
					tmpHdrVO.setSkdDirCdCtnt(sPostElement);			//SKD_DIR_CD	:	E
					
					sTmpSkdDirCd	= sPostElement;
										
				}else if("AR_DR_IND".equals(sPreElement)){
					tmpHdrVO.setArrDepIndCdCtnt(sPostElement);		//AR_DR_IND		:	ARV
				}else if("LLOYDS_CD".equals(sPreElement)){
					tmpHdrVO.setLloydNo(sPostElement);				//LLOYDS_CD		:	9247558
				}else if("VSL_ENG_NM".equals(sPreElement)){
					tmpHdrVO.setVslEngNm(sPostElement);				//VSL_ENG_NM	:	CHICAGO BRIDGE
				}else if("PIC_NM".equals(sPreElement)){
					tmpHdrVO.setPicNm(sPostElement);				//PIC_NM		:	HONG GIL DONG
				}else if("CONTACT_TYPE".equals(sPreElement)){
					tmpHdrVO.setPicCntcTpCd(sPostElement);			//CONTACT_TYPE	:	TE
				}else if("CONTACT_NO".equals(sPreElement)){
					tmpHdrVO.setPicCntcNo(sPostElement);			//CONTACT_NO	:	82-2-1234-5678
				}else if("REMARK".equals(sPreElement)){
					tmpHdrVO.setEdiRmk(sPostElement);				//REMARK		:	
					
				//::----------------------------------------------------------------------------------:://
				}else if("{VSL_SKD".equals(sPreElement)){
					tmpDtlVO	= new VslSkdXchEdiDtlVO();			//----------{VSL_SKD
					
					tmpDtlVO.setSkdVoyNoCtnt(sTmpSkdVoyNo);
					tmpDtlVO.setSkdDirCdCtnt(sTmpSkdDirCd);
					
					tmpDtlVO.setSkdEdiRcvSeq(sEdiSeq);
					tmpDtlVO.setCoCdCtnt	(sTmpAllnCoCd);
					
				}else if("LOC_IND".equals(sPreElement)){
					tmpDtlVO.setLocIndCdCtnt(sPostElement);			//LOC_IND		:	153
				}else if("CAL_IND_SEQ".equals(sPreElement)){
					tmpDtlVO.setClptIndSeqCtnt(sPostElement);		//CAL_IND_SEQ	:	1
				}else if("CLPT_SEQ".equals(sPreElement)){
					tmpDtlVO.setClptSeqCtnt(sPostElement);			//CLPT_SEQ		:	1
				}else if("LOC_CD".equals(sPreElement)){
					tmpDtlVO.setVpsPortCdCtnt(sPostElement);		//LOC_CD		:	KRPUS
				}else if("LOC_DESC".equals(sPreElement)){
					tmpDtlVO.setVpsPortNm(sPostElement);			//LOC_DESC		:	PUSAN
				}else if("LOC_ETA".equals(sPreElement)){
					tmpDtlVO.setVpsEtaDtCtnt(sPostElement);			//LOC_ETA		:	200701010000
				}else if("LOC_ETB".equals(sPreElement)){
					tmpDtlVO.setVpsEtbDtCtnt(sPostElement);			//LOC_ETB		:	200701010000
				}else if("LOC_ETD".equals(sPreElement)){
					tmpDtlVO.setVpsEtdDtCtnt(sPostElement);			//LOC_ETD		:	200701010000
				}else if("LOC_ATA".equals(sPreElement)){
					tmpDtlVO.setActArrDtCtnt(sPostElement);			//LOC_ATA		:	200701010000
				}else if("LOC_ATB".equals(sPreElement)){
					tmpDtlVO.setActBrthDtCtnt(sPostElement);		//LOC_ATB		:	200701010000
				}else if("LOC_ATD".equals(sPreElement)){
					tmpDtlVO.setActDepDtCtnt(sPostElement);			//LOC_ATD		:	200701010000
				}else if("}VSL_SKD".equals(sPreElement)){
					vslSkdXchEdiDtlVOs.add(tmpDtlVO);				//}VSL_SKD----------------------
				}
				
			}
			
			//::INSERT::VSK_VSL_SKD_XCH_EDI_HDR:://////////////////////////////////////////
			
			tmpHdrVO.setSkdEdiRcvSeq	(sEdiSeq	);
			vslSkdXchEdiHdrVOs.add		(tmpHdrVO	);
			
			//---------------------------------------------------------------------------//
			
			dbDao.createScheduleExchangeHeader		(vslSkdXchEdiHdrVOs);
			///////////////////////////////////////////////////////////////////////////////
			
			//::INSERT::VSK_VSL_SKD_XCH_EDI_DTL:://////////////////////////////////////////
			dbDao.createScheduleExchangeDetailList	(vslSkdXchEdiDtlVOs);
			///////////////////////////////////////////////////////////////////////////////
			
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return vslSkdXchEdiHdrVOs;
	}


	/**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @return VslSkdXchEdiHdrVO
	 * @exception EventException
	 */
	public VslSkdXchEdiHdrVO selectVesselScheduleExchangeEdiHdr(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException {
		try {
			return dbDao.selectVesselScheduleExchangeEdiHdr(vslSkdXchEdiHdrVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} 
	}


	/**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @return List<VslSkdXchEdiDtlVO>
	 * @exception EventException
	 */
	public List<VslSkdXchEdiDtlVO> selectVesselScheduleExchangeEdiDtlList(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException {
		try {
			return dbDao.selectVesselScheduleExchangeEdiDtlList(vslSkdXchEdiHdrVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} 
	}



	/**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String checkScheduleMappingProcRemark(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException {
		try {
			return dbDao.checkScheduleMappingProcRemark(vslSkdXchEdiHdrVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 시스템 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} 
	}
	
	
	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @return boolean
	 * @exception EventException
	 */
	public void modifyEdiLogFromScheduleExchangeCKYH(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException{
		
		List<VslSkdXchEdiHdrVO>		vslSkdXchEdiHdrVOs	= new ArrayList<VslSkdXchEdiHdrVO>();
		
		try{

			//-----------------------------------------------------------------------------//

			//::UPDATE::VSK_VSL_SKD_XCH_EDI_HDR::////////////////////////////////////////////
			vslSkdXchEdiHdrVOs.add(vslSkdXchEdiHdrVO);
			dbDao.modifyScheduleExchangeHeader		(vslSkdXchEdiHdrVOs);

			//-----------------------------------------------------------------------------//
			
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * Vessel Schedule Exchange Header
	 *
	 * @param VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO
	 * @return boolean
	 * @exception EventException
	 */
	public void updateCoastalSchedulebyEDICKYH(VslSkdXchEdiHdrVO vslSkdXchEdiHdrVO) throws EventException{
			
		try{

			//-----------------------------------------------------------------------------//
			List<VslSkdXchEdiHdrVO>		vslSkdXchEdiHdrVOs	= new ArrayList<VslSkdXchEdiHdrVO>();
			vslSkdXchEdiHdrVOs.add(vslSkdXchEdiHdrVO);

			//::SELECT::VSK_VSL_SKD_XCH_EDI_HDR::////////////////////////////////////////////
			dbDao.updateCoastalSchedulebyEDICKYH	(vslSkdXchEdiHdrVOs);
			//-----------------------------------------------------------------------------//
			
			//log.info("\n ::2007816::BCImpl:: update count is ["+upCnt[0]+"] \n");
			
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}	
	
}
