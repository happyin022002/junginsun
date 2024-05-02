/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ConsortiumVoyageMgtBCImpl.java
 *@FileTitle : ConsortiumVoyageMgtBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.09.29
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.09.29 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration.VesselScheduleMgtDBDAO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.integration.ConsortiumVoyageMgtDBDAO;
import com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.vo.ConsortiumVoyageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * SchedulePlanningOperation Business Logic Basic Command implementation<br>
 * - Handling business logic of SchedulePlanningOperation<br>
 * 
 * @author
 * @see UI_VSK-0018EventResponse,VesselScheduleMgtBC, DAO
 * @since J2EE 1.4
 */ 

public class ConsortiumVoyageMgtBCImpl extends BasicCommandSupport implements ConsortiumVoyageMgtBC {

	// Database Access Object
	private transient ConsortiumVoyageMgtDBDAO 	dbDao 	= null;
	private transient VesselScheduleMgtDBDAO 	dbDao2 	= null;
	// :: VIPS START ::
	private List<VskVslPortSkdVO> mVslPortSkdList = new ArrayList<VskVslPortSkdVO>();
	
	private List<VskVslSkdVO> mVskVslSkdList   = new ArrayList<VskVslSkdVO>();
	
	public List<VskVslPortSkdVO> getVslPortSkdList() {
		return this.mVslPortSkdList;
	}

	public List<VskVslSkdVO> getVskVslSkdList() {
		return this.mVskVslSkdList;
	}
	
	/**
	 * ConsortiumVoyageMgtBCImpl object creation<br>
	 * Creating ConsortiumVoyageMgtDBDAO<br>
	 */
	public ConsortiumVoyageMgtBCImpl() {
		dbDao 	= new ConsortiumVoyageMgtDBDAO	();
		dbDao2 	= new VesselScheduleMgtDBDAO	();
//		eaiDao = new VesselScheduleMgtEAIDAO();
		// initialize
		this.mVslPortSkdList = new ArrayList<VskVslPortSkdVO>();
	}
	// :: VIPS END ::

	/**
	 * Retrieving Vessel Schedule of lane
	 * 
	 * @param ConsortiumVoyageVO consortiumVoyageVO
	 * @return List<ConsortiumVoyageVO>
	 * @exception EventException
	 */
	public List<ConsortiumVoyageVO> searchConsortiumVoyage(ConsortiumVoyageVO consortiumVoyageVO)
			throws EventException {
		try {
			return dbDao.searchConsortiumVoyage(consortiumVoyageVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * update from vsk_vsl_port_skd-side modifications to bkg_vvd 
	 * @param 		List<ConsortiumVoyageVO> consortiumVoyageVOs
	 * @throws 		EventException
	 */
	public void modifyConsortiumVoyage(List<ConsortiumVoyageVO> consortiumVoyageVOs) throws EventException{
		
		try {	
			
			/*
			 *  (Modified) 2015-10-08 Apply to Consortium Voyage Next VVD's First I/B Voyage Number. 
			 *  Applied by VVD (VVD 단위로 적용) 
			 */
			
			   String       chkVvd  					= "";
			   
			   VskVslPortSkdVO originPortParamVO 		= new VskVslPortSkdVO();
			   List<VskVslPortSkdVO> originPortVoList	= null;
			   List<List<VskVslPortSkdVO>>	originPortVoListList	= new ArrayList<List<VskVslPortSkdVO>>();
			   
			   for (int i = 0; i < consortiumVoyageVOs.size(); i++) {
				   
				    ConsortiumVoyageVO vo 	= new ConsortiumVoyageVO();
				    vo 						= consortiumVoyageVOs.get(i);
				    
				   String tmpVvd			= vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd();
				   
				    if("".equals(chkVvd) || !tmpVvd.equals(chkVvd)){
						originPortParamVO = new VskVslPortSkdVO();
						originPortParamVO.setVslCd		(vo.getVslCd	());
						originPortParamVO.setSkdVoyNo	(vo.getSkdVoyNo	());
						originPortParamVO.setSkdDirCd	(vo.getSkdDirCd	());
						originPortVoList = dbDao2.searchVskVslPortSkdByVirtualPort(originPortParamVO);	//Retrieving port info before current VVD save
									
						originPortVoListList.add(originPortVoList);
				    }
				   
				    chkVvd	= tmpVvd;
			   }
			
			   
			   String       curVvd  					= "";
			   String       preVvd  					= "";

			   List<ConsortiumVoyageVO>  VOs   			= null;
			   ConsortiumVoyageVO    ibCssmVo  			= new ConsortiumVoyageVO();
			   
			   for (int i = 0; i < consortiumVoyageVOs.size(); i++) {
				   
			    ConsortiumVoyageVO vo 	= new ConsortiumVoyageVO();
			    vo 						= consortiumVoyageVOs.get(i);
			    
			    curVvd 					= vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd();

				//================================================================================================================
				//[in case Data is changed after user retrieve START]
				if(originPortVoListList != null && originPortVoListList.size()>0){
					for(List<VskVslPortSkdVO> tmpVOList : originPortVoListList){
						if(tmpVOList != null && tmpVOList.size()>0){
							for(VskVslPortSkdVO tmpVO : tmpVOList){
								if(		vo.getVslCd		().equals(tmpVO.getVslCd		())
									&&	vo.getSkdVoyNo	().equals(tmpVO.getSkdVoyNo	())
									&&	vo.getSkdDirCd	().equals(tmpVO.getSkdDirCd	())
									&&	vo.getVpsPortCd	().equals(tmpVO.getVpsPortCd	()) 
									&& 	vo.getClptIndSeq().equals(tmpVO.getClptIndSeq	())
								)
								{
									
									log.info("\n\n =========== TOP.TOP.TOP ===========================\n\n");
									log.info("\n\n ===========  PORT << "+vo.getVpsPortCd()+vo.getClptIndSeq()+" >>  vo.getUpdDt() ["+vo.getUpdDt()+"] VS vskVslPortSkdVO.getUpdDt() ["+tmpVO.getUpdDt()+"] \n");
										
									if(!vo.getUpdDt().equals(tmpVO.getUpdDt())){
										throw new EventException(new ErrorHandler("VSK10077", new String[]{tmpVO.getUpdUsrId() + " "+tmpVO.getVpsPortCd()+" ("+tmpVO.getClptSeq()+") "}).getMessage());
									}
								}							
							}							
						}
					}
				}
				//[in case Data is changed after user retrieve END]
				//================================================================================================================


			    //:2016-04-18://String curVvd = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd();
			    if ("Y".equals(vo.getVoyAllSetFlg()) && vo.getVoyAllSetFlg() != null && (ibCssmVo.getIbCssmVoyNo() == null || "".equals(ibCssmVo.getIbCssmVoyNo()))) {
			     //ibCssmVo = new ConsortiumVoyageVO();
			     ibCssmVo.setVslCd  	(vo.getVslCd  		());
			     ibCssmVo.setSkdVoyNo 	(vo.getSkdVoyNo  	());
			     ibCssmVo.setSkdDirCd 	(vo.getSkdDirCd  	());
			     ibCssmVo.setIbCssmVoyNo(vo.getObCssmVoyNo 	());
			     ibCssmVo.setUpdUsrId	(vo.getUpdUsrId		());
			     
			    }
			    if (i == 0) {
			     VOs = new ArrayList<ConsortiumVoyageVO>();
			     VOs.add(vo);
			    }
			    // :: VIPS START ::
			    boolean msetting = false;
			    boolean usetting = false;
			    ////if (!preVvd.equals(curVvd) && i > 0) {
			    if (!preVvd.equals(curVvd)) {
			     dbDao.modifyConsortiumVoyage(VOs);
			     msetting = true;
			     if (ibCssmVo.getIbCssmVoyNo() != null && !"".equals(ibCssmVo.getIbCssmVoyNo())) {
			      dbDao.updateVirtualConsortiumVoyage(ibCssmVo);
			      usetting = true;
			      //ibCssmVo = null;
			      ibCssmVo.setVslCd  (null);
			      ibCssmVo.setSkdVoyNo (null);
			      ibCssmVo.setSkdDirCd (null);
			      ibCssmVo.setIbCssmVoyNo (null);
			     }
			     VOs = new ArrayList<ConsortiumVoyageVO>();
			     VOs.add(vo);
			    } else if (preVvd.equals(curVvd)) {
			     VOs.add(vo);
			    }
			    
			    if (i == consortiumVoyageVOs.size() - 1) {
			     dbDao.modifyConsortiumVoyage(VOs);
			     msetting = true;
			     if (ibCssmVo.getIbCssmVoyNo() != null && !"".equals(ibCssmVo.getIbCssmVoyNo()))
			      dbDao.updateVirtualConsortiumVoyage(ibCssmVo);
			      usetting = true;
			    }
			    preVvd = curVvd;
			   
			    if(msetting) { // 복수
					// System.out.println("VIPS[modifyConsortiumVoyage1]");
			    	List<String> vvds = new ArrayList<String>();
			    	for(ConsortiumVoyageVO cVO : VOs) {
						// duplication check(vessel info)
						String vvd = cVO.getVslCd() + cVO.getSkdVoyNo() + cVO.getSkdDirCd();
						if(!vvds.contains(vvd)) {
							
							VesselScheduleMgtDBDAO dbDaoTmp = new VesselScheduleMgtDBDAO();
				    		VskVslSkdVO vskVslSkd = new VskVslSkdVO();
				    		vskVslSkd.setVslCd(cVO.getVslCd());
				    		vskVslSkd.setSkdVoyNo(cVO.getSkdVoyNo());
				    		vskVslSkd.setSkdDirCd(cVO.getSkdDirCd());
				    		List<VskVslSkdVO> vskVslSkdList = dbDaoTmp.searchVskVslSkdByVVD(vskVslSkd);
							for(VskVslSkdVO row : vskVslSkdList) {
								this.mVskVslSkdList.add(row);
							}
						
				    		
				    		VskVslPortSkdVO port = new VskVslPortSkdVO();
				    		port.setVslCd(cVO.getVslCd());
				    		port.setSkdVoyNo(cVO.getSkdVoyNo());
				    		port.setSkdDirCd(cVO.getSkdDirCd());
				    		port.setVpsPortCd(cVO.getVpsPortCd());
				    		port.setClptIndSeq(cVO.getClptIndSeq());
				    		port.setTurnSkdVoyNo(cVO.getTurnSkdVoyNo());
				    		port.setTurnSkdDirCd(cVO.getTurnSkdDirCd());
				    		
				    		List<VskVslPortSkdVO> list = dbDaoTmp.searchVskVslPortSkdByVVD(port);
							for(VskVslPortSkdVO row : list) {
								this.mVslPortSkdList.add(row);
							}
				    		// 2016-01-15 VIPS START
								List<VskVslPortSkdVO> list2 = dbDaoTmp.searchTurningVVD(port);
								if(list2.size()>0){
									for(int j = 0; j < list2.size(); j++){
							    		vskVslSkd.setVslCd(list2.get(j).getVslCd());
							    		vskVslSkd.setSkdVoyNo(list2.get(j).getTurnSkdVoyNo());
							    		vskVslSkd.setSkdDirCd(list2.get(j).getTurnSkdDirCd());
							    		List<VskVslSkdVO> vskVslSkdList2 = dbDaoTmp.searchVskVslSkdByVVD(vskVslSkd);
										for(VskVslSkdVO row : vskVslSkdList2) {
											this.mVskVslSkdList.add(row);
										}
										
										port.setVslCd(list2.get(j).getVslCd());
										port.setSkdVoyNo(list2.get(j).getTurnSkdVoyNo());
										port.setSkdDirCd(list2.get(j).getTurnSkdDirCd());
										List<VskVslPortSkdVO> list3 = dbDaoTmp.searchVskVslPortSkdByVVD(port); 
										for(VskVslPortSkdVO row : list3) {
											this.mVslPortSkdList.add(row);
										}	
									}
								}
								vvds.add(vvd);
							}
			    		}
			    	}
			    
			    if(usetting) {//단수
					// System.out.println("VIPS[updateVirtualConsortiumVoyage1]");
			    	VesselScheduleMgtDBDAO dbDaoTmp = new VesselScheduleMgtDBDAO();
			    	
		    		VskVslSkdVO vskVslSkd = new VskVslSkdVO();
		    		vskVslSkd.setVslCd(ibCssmVo.getVslCd());
		    		vskVslSkd.setSkdVoyNo(ibCssmVo.getSkdVoyNo());
		    		vskVslSkd.setSkdDirCd(ibCssmVo.getSkdDirCd());
		    		List<VskVslSkdVO> vskVslSkdList = dbDaoTmp.searchVskVslSkdByVVD(vskVslSkd);
					for(VskVslSkdVO row : vskVslSkdList) {
						this.mVskVslSkdList.add(row);
					}
					
					VskVslPortSkdVO port = new VskVslPortSkdVO();
					port.setVslCd(ibCssmVo.getVslCd());
					port.setSkdVoyNo(ibCssmVo.getSkdVoyNo());
					port.setSkdDirCd(ibCssmVo.getSkdDirCd());
					
					List<VskVslPortSkdVO> list = dbDaoTmp.searchVskVslPortSkdByVVD(port);
					for(VskVslPortSkdVO row : list) {
						this.mVslPortSkdList.add(row);
					}
		    		// 2016-01-18 VIPS START
					List<VskVslPortSkdVO> list4 = dbDaoTmp.searchConnectedVirtualPort(port);
					if(list4.size()>0){
						for(int j = 0; j < list4.size(); j++){
							
							
				    		vskVslSkd.setVslCd(list4.get(j).getVslCd());
				    		vskVslSkd.setSkdVoyNo(list4.get(j).getTurnSkdVoyNo());
				    		vskVslSkd.setSkdDirCd(list4.get(j).getTurnSkdDirCd());
				    		List<VskVslSkdVO> vskVslSkdList2 = dbDaoTmp.searchVskVslSkdByVVD(vskVslSkd);
							for(VskVslSkdVO row : vskVslSkdList2) {
								this.mVskVslSkdList.add(row);
							}
							
							port.setVslCd(list4.get(j).getVslCd());
							port.setSkdVoyNo(list4.get(j).getTurnSkdVoyNo());
							port.setSkdDirCd(list4.get(j).getTurnSkdDirCd());
							List<VskVslPortSkdVO> list5 = dbDaoTmp.searchVskVslPortSkdByVVD(port); 
							for(VskVslPortSkdVO row : list5) {
								this.mVslPortSkdList.add(row);
								}	
							}
						}
						// 2016-01-18 VIPS END 
			    	}
				// :: VIPS END ::
			   	}

			
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage());
		}		
	}
	

	/**
	 * update from vsk_vsl_port_skd-side modifications to bkg_vvd 
	 * @param 		List<ConsortiumVoyageVO> consortiumVoyageVOs
	 * @throws 		EventException
	 */
	public void modifyConsortiumVoyageList(List<ConsortiumVoyageVO> consortiumVoyageVOs) throws EventException{
		
		try {	
			
			/*
			 *  (Modified) 2015-10-08 Apply to Consortium Voyage Next VVD's First I/B Voyage Number. 
			 *  Applied by VVD (VVD 단위로 적용) 
			 */
			   
			   
			   for (int i = 0; i < consortiumVoyageVOs.size(); i++) {
				   ConsortiumVoyageVO    cssmVo  		= new ConsortiumVoyageVO();
				   cssmVo								= consortiumVoyageVOs.get(i);
				   
				   dbDao.updateConsortiumVoyage			(cssmVo);

			   	}

			
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage());
		}		
	}

}
