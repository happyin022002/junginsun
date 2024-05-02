/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : vesselpositionpollingmanagement.java
*@FileTitle : Vessel Position Polling Update Background Job
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 임예지
*@LastVersion : 1.0
* 2014.05.12 임예지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.basic;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration.VesselPositionPollingManagementDBDAO;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.vo.PositionPollingDetailVO;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.vo.PositionPollingHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * Vessel Position Polling Insert & Update Back End Job Basic Command implementation<br>
 * @author LIM YE JI
 * @since J2EE 1.6
 */

public class VesselPositionPollingDetailUpdateBackEndJob extends BackEndCommandSupport{

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -3584808021250066053L;
	
	/**
	 * Position Polling Header에서 DLY_RCV_SEQ, RCV_DT 전달
	 */
	private PositionPollingHeaderVO positionPollingHeaderVO;
	/**
	 * EDI Flat File
	 */
	private String sRawFlatFile;
	
	
	/**
	 * Position Polling Header에서 DLY_RCV_SEQ, RCV_DT 전달
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 */
	public void setPositionPollingHeaderVO(PositionPollingHeaderVO positionPollingHeaderVO) {
		this.positionPollingHeaderVO = positionPollingHeaderVO;
	}
	
	/**
	 * EDI Flat File
	 * @param String sRawFlatFile
	 */
	public void setRawFlatFile(String sRawFlatFile) {
		this.sRawFlatFile = sRawFlatFile;
	}
	
	
	/**
	 * F/F FILE 수신받아 가공하여 Position Polling Detail에 INSERT, UPDATE 수행<br>
	 * @return Object
	 */
	public Object doStart() throws Exception {
		this.createPositionPollingDetailFromEdiBackEndJob(this.positionPollingHeaderVO, this.sRawFlatFile); 
		return null;
	}
	
	public void createPositionPollingDetailFromEdiBackEndJob(PositionPollingHeaderVO positionPollingHeaderVO, String sRawFlatFile) throws EventException{
		
		VesselPositionPollingManagementDBDAO dbDao 						= new VesselPositionPollingManagementDBDAO();
		String 								sDlyRcvSeq					= null;
		String								sRcvDt						= null;
		
		try{
//			################ EDI MQ 메세지 원본 컬럼단위로 쪼개기 ################
			ArrayList<String>	arrFlatFileList		= new ArrayList<String>();
			StringTokenizer		stFlatFileList		= new StringTokenizer(sRawFlatFile, "\n");

			int rowFileSize	= 0;
			
			while(stFlatFileList.hasMoreTokens()){
				arrFlatFileList.add(stFlatFileList.nextToken());
				rowFileSize++;
			}
			
			log.info("\n\n ::=========================================================================::");
			log.info("\n\n ::2014505:: flat file size ["+rowFileSize+"]\n\n");
			log.info("\n\n ::=========================================================================::");
			
			
			if(arrFlatFileList == null || arrFlatFileList.size() == 0)	return;
			
			sRcvDt											= positionPollingHeaderVO.getRcvDt();
			sDlyRcvSeq										= positionPollingHeaderVO.getDlyRcvSeq();
			String						sTmpArrElement[]	= new String[8];
			String						tmp					= null;
			
			for(int i=2; i<arrFlatFileList.size(); i++){
				
				log.info("\n\n ::=========================================================================::");
				log.info("\n\n ::2014505:: i ["+i+"] :: arrFlatFileList ["+arrFlatFileList.get(i)+"]\n\n");
				log.info("\n\n ::=========================================================================::");				
				
				sTmpArrElement	= arrFlatFileList.get(i).trim().split(",");
				
				PositionPollingDetailVO		tmpDtlVO		= new PositionPollingDetailVO();
				
				for(int j=0; j<sTmpArrElement.length; j++){
					
					if(j==0){
						tmpDtlVO.setCallSgnNo(sTmpArrElement[j]);
					}else if(j==1){
						
						tmpDtlVO.setLloydNo(JSPUtil.replace(sTmpArrElement[j], "\"", ""));
					}else if(j==2){
						tmpDtlVO.setVslEngNm(JSPUtil.replace(sTmpArrElement[j],"\"", ""));
					}else if(j==3){
						tmpDtlVO.setPlngGenGdt(JSPUtil.replace(JSPUtil.replace(JSPUtil.replace(JSPUtil.replace(sTmpArrElement[j], "GMT", ""), " ", ""),"/",""),":",""));
						
					}else if(j==4){
						tmp = sTmpArrElement[j];
						if(tmp.indexOf("N") > 0){
							tmp = JSPUtil.replace(tmp, "N", "");
						}else if(tmp.indexOf("S") > 0){
							tmp = JSPUtil.replace(tmp, "S", "");
							tmp = String.valueOf(Float.parseFloat(tmp)*(-1));
						}else{
							tmp = "";
						}
						tmpDtlVO.setVslLat(tmp);
					}else if(j==5){
						tmp = sTmpArrElement[j];
						if(tmp.indexOf("E") > 0){
							tmp = JSPUtil.replace(tmp, "E", "");
						}else if(tmp.indexOf("W") > 0){
							tmp = JSPUtil.replace(tmp, "W", "");
							tmp = String.valueOf(Float.parseFloat(tmp)*(-1));
						}else{
							tmp = "";
						}
						tmpDtlVO.setVslLon(tmp);
					}else if(j==6){
						tmpDtlVO.setVslSpd(sTmpArrElement[j]);
					}else if(j==7){
						tmpDtlVO.setVslProgDirCtnt(sTmpArrElement[j]);
					}
					
					//::INSERT::VSK_VSL_PSN_PLNG_DTL:://////////////////////////////////////////
					tmpDtlVO.setRcvDt			(sRcvDt		);
					tmpDtlVO.setDlyRcvSeq		(sDlyRcvSeq	);
					
				}
				//::END OF INNER FOR LOOP:://
				//::INSERT::VSK_VSL_PSN_PLNG_DTL:://////////////////////////////////////////
				dbDao.createPositionPollingDetailList	(tmpDtlVO);
				///////////////////////////////////////////////////////////////////////////////
				
				continue;	
			}
			//::END OF OUTER FOR LOOP:://

			
//			################ 1. VSK_VSL_PSN_PLNG_DTL에서  Total detail data List 추출################
			List<PositionPollingDetailVO> tmpSelectDtlVOs 	= dbDao.selectPositionPollingDetailList(positionPollingHeaderVO);
			
			List<PositionPollingDetailVO> tmpUpdateDtlVOs	= new ArrayList<PositionPollingDetailVO>();
			
			//ROW별로 VO에 담기 시작
			for(int i=0; i<tmpSelectDtlVOs.size(); i++){
				
				PositionPollingDetailVO tempDtlVO = new PositionPollingDetailVO();
				tempDtlVO = tmpSelectDtlVOs.get(i);
			
//			################ 2. List에서 각 VO별 Voyage No, Direction CD 추출 ################
				PositionPollingDetailVO 		tempDtlVvdVO = dbDao.selectPositionPollingDetailVvd(tempDtlVO);
				tempDtlVO.setSkdVoyNo			(tempDtlVvdVO.getSkdVoyNo			());
				tempDtlVO.setSkdDirCd			(tempDtlVvdVO.getSkdDirCd			());
				
//			################ 3. List에서 각 VO별 Previous POL data 값 추출 ################
				PositionPollingDetailVO 		tempDtlPreVO = dbDao.selectPositionPollingDetailPre(tempDtlVO);
				tempDtlVO.setVslPreLat			(tempDtlPreVO.getVslPreLat			());
				tempDtlVO.setVslPreLon			(tempDtlPreVO.getVslPreLon			());
				tempDtlVO.setVslPreSpd			(tempDtlPreVO.getVslPreSpd			());
				tempDtlVO.setVslPreProgDirCtnt	(tempDtlPreVO.getVslPreProgDirCtnt	());
				tempDtlVO.setPlngGenDiffHrs		(tempDtlPreVO.getPlngGenDiffHrs		());
				
//			################ 4. List에서 각 VO별 Pre Lat, Pre Lon, Lat, Lon 값 추출 Distance 계산 ################

				String psnDist = this.calculatePositionPollingDistance(tempDtlVO);
				
				if(psnDist != null) tempDtlVO.setVslPlngDist(String.valueOf(psnDist));
				
				tmpUpdateDtlVOs.add(tempDtlVO);
				
				dbDao.updatePositionPollingDetailList(tempDtlVO);
				
				continue;	
			}
			
//			################ 5. VO List에 담아서 VSK_VSL_PSN_PLNG_DTL에 Update  ################
			PositionPollingHeaderVO		tmpUpdDtVO          = new PositionPollingHeaderVO();
			tmpUpdDtVO.setRcvDt		(sRcvDt		);
			tmpUpdDtVO.setDlyRcvSeq	(sDlyRcvSeq	);
			
			dbDao.updatePositionPollingUpateDate(tmpUpdDtVO);

		}catch(DAOException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PositionPollingDetailVO를 받아 거리값을 계산한다.
	 * @param PositionPollingDetailVO tmpDetailVO
	 * @return String
	 * @exception EventException
	 */
	//VSL_LAT, VSL_LON, VSL_PRE_LAT, VSL_PRE_LON 전달 받아 DISTANCE 계산
	private static double	d2r = Math.PI / 180;
	private String calculatePositionPollingDistance(PositionPollingDetailVO tmpDetailVO) throws EventException{
		
	try{
			if(tmpDetailVO.getVslLon() == null || "".equals(tmpDetailVO.getVslLon())
					|| tmpDetailVO.getVslLat() == null || "".equals(tmpDetailVO.getVslLat())
					|| tmpDetailVO.getVslPreLon() == null || "".equals(tmpDetailVO.getVslPreLon())
					|| tmpDetailVO.getVslPreLat() == null || "".equals(tmpDetailVO.getVslPreLat()))
			return null;
				

			double	sEndPsnLon = Double.parseDouble(tmpDetailVO.getVslLon());
			double	sEndPsnLat = Double.parseDouble(tmpDetailVO.getVslLat());
			double	sStartPsnLon = Double.parseDouble(tmpDetailVO.getVslPreLon());
			double	sStartPsnLat = Double.parseDouble(tmpDetailVO.getVslPreLat());
			
			
			double dLon = (sEndPsnLon - sStartPsnLon) * d2r;
	        double dLat = (sEndPsnLat - sStartPsnLat) * d2r;
			
	        double a = Math.pow(Math.sin(dLat / 2.0), 2) + Math.cos(sStartPsnLat * d2r) * Math.cos(sEndPsnLat * d2r) * Math.pow(Math.sin(dLon / 2.0), 2);
	        double c = Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)) * 2;
	        double psnDist = (c * 6378)/1.852;

	        //positionPollingDetailVO.setVslPlngDist(String.valueOf(psnDist));
	        
	        log.info("+++++++++++++++LYJLYJ+++++++++++Distance["+psnDist+"]+++++++++");
	        return String.valueOf(psnDist);
				
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
	
	}
}
