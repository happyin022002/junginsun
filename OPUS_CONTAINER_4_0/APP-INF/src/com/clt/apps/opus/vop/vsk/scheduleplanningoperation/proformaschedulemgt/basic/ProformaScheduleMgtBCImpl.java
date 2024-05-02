/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtBCImpl.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration.ProformaScheduleMgtDBDAO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.CoaSimRsltVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdHisGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdRequestVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpSumVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpDtlVO;


import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdHisVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdBerthWdoVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskPfCallPortVO;
import com.clt.syscommon.common.table.VskPfSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;


/**
 * SchedulePlanningOperation Business Logic Basic Command implementation<br>
 * - Handling business logic of SchedulePlanningOperation <br>
 *
 * @author
 * @see UI_VSK-0241EventResponse,ProformaScheduleMgtBC, DAO
 * @since J2EE 1.4
 */

public class ProformaScheduleMgtBCImpl extends BasicCommandSupport implements ProformaScheduleMgtBC {

	// Database Access Object
	private transient ProformaScheduleMgtDBDAO dbDao = null;

	private List<VskPfSkdDtlVO> mVskPfSkdDtlList = new ArrayList<VskPfSkdDtlVO>();	
	private List<PfSkdVO> mPfSkdList   = new ArrayList<PfSkdVO>();
	
	public List<VskPfSkdDtlVO> getVskPfSkdDtlList() {
		return this.mVskPfSkdDtlList;
	}

	public List<PfSkdVO> getPfSkdList() {
		return this.mPfSkdList;
	}
	
	/**
	 * ProformaScheduleMgtBCImpl object creation<br>
	 * Creating ProformaScheduleMgtDBDAO<br>
	 */
	public ProformaScheduleMgtBCImpl() {
		dbDao = new ProformaScheduleMgtDBDAO();
		this.mVskPfSkdDtlList =  new ArrayList<VskPfSkdDtlVO>();
		this.mPfSkdList = new ArrayList<PfSkdVO>();
	}
	/**
	 * Retrieving registeredProforma Type
	 * 
	 * @param PfSkdTypeHelpVO pfSkdTypeHelpVO
	 * @return List<PfSkdTypeHelpVO>
	 * @exception EventException
	 */
	public List<PfSkdTypeHelpVO> searchPfTpHelp(PfSkdTypeHelpVO pfSkdTypeHelpVO) throws EventException {
		try {
			return dbDao.searchPfTpHelp(pfSkdTypeHelpVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} 
	}
	
	/**
	 * Retrieving registered Proforma SKD
	 * 
	 * @param VskPfSkdHisVO vskPfSkdHisVO
	 * @return PfSkdHisGRPVO
	 * @exception EventException
	 */
	public PfSkdHisGRPVO searchPfSkdHis(VskPfSkdHisVO vskPfSkdHisVO) throws EventException {
		PfSkdHisGRPVO grpVO = new PfSkdHisGRPVO();
		try {
			
			List<VskPfSkdHisVO> vskPfSkdHisVOs = dbDao.searchPfSkdHis(vskPfSkdHisVO);
			List<VskVslSkdVO> vskVslSkdVOs = dbDao.searchVslSkdByPfSkd(vskPfSkdHisVO);
			
			grpVO.setVskPfSkdHisVOs(vskPfSkdHisVOs);
			grpVO.setVskVslSkdVOs(vskVslSkdVOs);
			
			return grpVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} 
	}
	
	/**
	* Retrieving registered Proforma SKD
	* 
	* @param PfSkdVO pfSkdVO
	* @return List<PfSkdVO>
	* @throws EventException
	*/
	public List<PfSkdVO> searchPfSkdHAS(PfSkdVO pfSkdVO) throws EventException {
		try {
			if("F".equals(pfSkdVO.getVslSvcTpCd())){
				pfSkdVO.setVslSvcTpCd("");
			}
			
			return dbDao.searchPfSkdHAS(pfSkdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} 
	}
	
	/**
	 * Retrieving registered Proforma SKD
	 * 
	 * @param String laneCd
	 * @param String pfSvcTpCd
	 * @param String vslSvcTpCd
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPfSkd(String laneCd, String pfSvcTpCd, String vslSvcTpCd) throws EventException {
		return searchPfSkd(laneCd, pfSvcTpCd, vslSvcTpCd, "");
	}
	
	/**
	 * Retrieving registered Proforma SKD
	 * 
	 * @param String laneCd
	 * @param String pfSvcTpCd
	 * @param String vslSvcTpCd
	 * @param String slanStndFlg
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPfSkd(String laneCd, String pfSvcTpCd, String vslSvcTpCd, String slanStndFlg) throws EventException {
		PfSkdVO pfSkdVO = new PfSkdVO();
		pfSkdVO.setVslSlanCd(laneCd);
		pfSkdVO.setPfSvcTpCd(pfSvcTpCd);
		
		if(!"F".equals(vslSvcTpCd)){
			pfSkdVO.setVslSvcTpCd(vslSvcTpCd);
		}
		
		pfSkdVO.setSlanStndFlg(slanStndFlg);
//		List<PfSkdVO> pfSkdVOList = dbDao.searchPfSkd(pfSkdVO);
		
		return searchPfSkd(pfSkdVO);
	}
	
	/**
	 * Retrieving registered Proforma SKD
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @throws EventException
	 */
	public List<PfSkdVO> searchPfSkd(PfSkdVO pfSkdVO) throws EventException {
		try {
			if("F".equals(pfSkdVO.getVslSvcTpCd())){
				pfSkdVO.setVslSvcTpCd("");
			}
			
			return dbDao.searchPfSkd(pfSkdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} 
	}
	
	/**
	 * Retrieving registered Proforma SKD
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @throws EventException
	 */
	public List<PfSkdVO> searchPfSkdInclFinalVirPortList(PfSkdVO pfSkdVO) throws EventException {
		
		try {
		
			if("F".equals(pfSkdVO.getVslSvcTpCd())){
				pfSkdVO.setVslSvcTpCd("");
			}
			
			return dbDao.searchPfSkdInclFinalVirPortList(pfSkdVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} 
	}
	
	/**
	 * Retrieving P/F SKD Settlement
	 * 
	 * @param PfSkdRequestVO pfSkdRequestVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO searchRqstSimScnr(PfSkdRequestVO pfSkdRequestVO) throws EventException {
		try {
			PfSkdGRPVO grpVO = new PfSkdGRPVO();
			VskPfSkdVO vskPfSkdVO = new VskPfSkdVO();
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = new ArrayList<VskPfSkdDtlVO>();
		
			List<PfSkdRequestVO> reVO = dbDao.searchRqstSimScnr(pfSkdRequestVO);		
			
			if(reVO.size() != 0 && reVO != null){
				vskPfSkdVO.setVslSlanCd(reVO.get(0).getVslSlanCd());
				
				vskPfSkdVO.setPfSvcTpCd(reVO.get(0).getPfSvcTpCd());
				vskPfSkdVO.setSlanStndFlg(reVO.get(0).getSlanStndFlg());
				vskPfSkdVO.setSvcDurDys(reVO.get(0).getSvcDurDys());
				vskPfSkdVO.setStndSvcSpd(reVO.get(0).getStndSvcSpd());
				vskPfSkdVO.setBrthItvalDys(reVO.get(0).getBrthItvalDys());
				
				vskPfSkdVO.setMmlUsdFlg(reVO.get(0).getMmlUsdFlg());
				vskPfSkdVO.setSimDt(reVO.get(0).getSimDt());
				vskPfSkdVO.setSimNo(reVO.get(0).getSimNo());
				vskPfSkdVO.setN1stVslClssCd(reVO.get(0).getN1stVslClssCd());
				vskPfSkdVO.setN1stVslClssKnt(reVO.get(0).getN1stVslClssKnt());
				
				vskPfSkdVO.setN2ndVslClssCd(reVO.get(0).getN2ndVslClssCd());
				vskPfSkdVO.setN2ndVslClssKnt(reVO.get(0).getN2ndVslClssKnt());
				vskPfSkdVO.setN3rdVslClssCd(reVO.get(0).getN3rdVslClssCd());
				vskPfSkdVO.setN3rdVslClssKnt(reVO.get(0).getN3rdVslClssKnt());
				vskPfSkdVO.setClptKnt(reVO.get(0).getClptKnt());
				
				vskPfSkdVO.setTtlDist(reVO.get(0).getTtlDist());
				vskPfSkdVO.setMaxSpd(reVO.get(0).getMaxSpd());
				vskPfSkdVO.setAvgSpd(reVO.get(0).getAvgSpd());
				vskPfSkdVO.setDeltFlg(reVO.get(0).getDeltFlg());
				vskPfSkdVO.setPfSkdRmk(reVO.get(0).getPfSkdRmk());
				
				for(int i=0; i<reVO.size(); i++){
					VskPfSkdDtlVO vskPfSkdDtlVO = new VskPfSkdDtlVO();
					vskPfSkdDtlVO.setRowSeq(reVO.get(i).getRowSeq());
					vskPfSkdDtlVO.setVslSlanCd(reVO.get(i).getVslSlanCd());
					
					vskPfSkdDtlVO.setPfSvcTpCd(reVO.get(i).getPfSvcTpCd());
					vskPfSkdDtlVO.setPortCd(reVO.get(i).getPortCd());
					vskPfSkdDtlVO.setSkdDirCd(reVO.get(i).getSkdDirCd());
					vskPfSkdDtlVO.setClptSeq(reVO.get(i).getClptSeq());
					vskPfSkdDtlVO.setPortRotnSeq(reVO.get(i).getPortRotnSeq());
					
					vskPfSkdDtlVO.setYdCd(reVO.get(i).getYdCd());
					vskPfSkdDtlVO.setCallYdIndSeq(reVO.get(i).getCallYdIndSeq());
					vskPfSkdDtlVO.setTurnPortFlg(reVO.get(i).getTurnPortFlg());
					vskPfSkdDtlVO.setTurnPortIndCd(reVO.get(i).getTurnPortIndCd());
					vskPfSkdDtlVO.setEtbDyCd(reVO.get(i).getEtbDyCd());
					
					vskPfSkdDtlVO.setEtbDyNo(reVO.get(i).getEtbDyNo());
					vskPfSkdDtlVO.setEtbTmHrmnt(reVO.get(i).getEtbTmHrmnt());
					vskPfSkdDtlVO.setEtdDyCd(reVO.get(i).getEtdDyCd());
					vskPfSkdDtlVO.setEtdDyNo(reVO.get(i).getEtdDyNo());
					vskPfSkdDtlVO.setEtdTmHrmnt(reVO.get(i).getEtdTmHrmnt());
					
					vskPfSkdDtlVO.setLnkDist(reVO.get(i).getLnkDist());
					vskPfSkdDtlVO.setLnkSpd(reVO.get(i).getLnkSpd());
					vskPfSkdDtlVO.setTztmHrs(reVO.get(i).getTztmHrs());
					vskPfSkdDtlVO.setSeaBufHrs(reVO.get(i).getSeaBufHrs());
					vskPfSkdDtlVO.setSeaBufSpd(reVO.get(i).getSeaBufSpd());
					
					vskPfSkdDtlVO.setMnvrInHrs(reVO.get(i).getMnvrInHrs());
					vskPfSkdDtlVO.setMnvrOutHrs(reVO.get(i).getMnvrOutHrs());
					vskPfSkdDtlVO.setIbIpcgoQty(reVO.get(i).getIbIpcgoQty());
					vskPfSkdDtlVO.setIbOcnCgoQty(reVO.get(i).getIbOcnCgoQty());
					vskPfSkdDtlVO.setObIpcgoQty(reVO.get(i).getObIpcgoQty());
					
					vskPfSkdDtlVO.setObOcnCgoQty(reVO.get(i).getObOcnCgoQty());
					vskPfSkdDtlVO.setTmlProdQty(reVO.get(i).getTmlProdQty());
					vskPfSkdDtlVO.setCrnKnt(reVO.get(i).getCrnKnt());
					vskPfSkdDtlVO.setActWrkHrs(reVO.get(i).getActWrkHrs());
					vskPfSkdDtlVO.setPortBufHrs(reVO.get(i).getPortBufHrs());
					
					vskPfSkdDtlVO.setZd(reVO.get(i).getZd());
					/*
					vskPfSkdDtlVO.setTotMaxSpd(reVO.get(i).getTotMaxSpd());
					vskPfSkdDtlVO.setTotAvgSpd(reVO.get(i).getTotAvgSpd());
					vskPfSkdDtlVO.setBufSpd(reVO.get(i).getSeaBufSpd());

					
					vskPfSkdDtlVO.setTotBufRat(reVO.get(i).getTotBufRat());
					vskPfSkdDtlVO.setSeaBufRat(reVO.get(i).getSeaBufRat());
					vskPfSkdDtlVO.setPortBufRat(reVO.get(i).getPortBufRat());
					vskPfSkdDtlVO.setPfSpdRat(reVO.get(i).getPfSpdRat());
					vskPfSkdDtlVO.setBufSpdRat(reVO.get(i).getBufSpdRat());
					*/
					vskPfSkdDtlVO.setMinMaxSpd(reVO.get(i).getMinMaxSpd());
					vskPfSkdDtlVO.setCheckWkTm(reVO.get(i).getCheckWkTm());
					vskPfSkdDtlVO.setCraneWkTm(reVO.get(i).getCraneWkTm());
					vskPfSkdDtlVO.setMdmSkdDirCd(reVO.get(i).getMdmSkdDirCd());					

					vskPfSkdDtlVOs.add(vskPfSkdDtlVO);
					
				}
				
				//when calculate, except last row
				double cnt = reVO.size()-1;
				//SEA SPEED TOTLAL
				double totLinkSpd = 0;
				//SEA BUFFER SPEED TOTAL
				double totBufSpd = 0;
				//SEA BUFFER TOTAL
				double totSeaBufHrs = 0;
				//SEA TIME TOTAL
				double totSeaTime = 0;
				//MANU IN HRS TOTAL
				double totMnvrInHrs = 0;
				//MANU OUT HRS TOTAL
				double totMnvrOutHrs = 0;
				//WORKING HOUR TOTAL
				double totActWrkHrs = 0;
				//PORT BUFFER HRS TOTLA
				double totPortBufHrs = 0;
				//VSL CALSS MAX SPD
				double dMinMaxSpd = 0;
				//MAX SPEED
				float totMaxSpd = 0;
				//P/F SPEED
				float totAvgSpd = 0;
				BigDecimal bufSpd = null;
				BigDecimal totBufRat = null;
				BigDecimal seaBufRat = null;
				BigDecimal portBufRat = null;
				BigDecimal pfSpdRat = null;
				BigDecimal bufSpdRat = null;

				float max = 0;
				for(int k=0; k<reVO.size()-1; k++){
					
					if(Float.compare(Float.parseFloat(reVO.get(k).getLnkSpd()), max)>0){
						max = Float.parseFloat(reVO.get(k).getLnkSpd());
					}
					
					if(reVO.get(k).getLnkSpd() != null && !"".equals(reVO.get(k).getLnkSpd())){
						totLinkSpd 	+= Float.parseFloat(reVO.get(k).getLnkSpd());
					}
					if(reVO.get(k).getSeaBufSpd() != null && !"".equals(reVO.get(k).getSeaBufSpd())){
						totBufSpd += Float.parseFloat(reVO.get(k).getSeaBufSpd());
					}
					if(reVO.get(k).getSeaBufHrs() != null && !"".equals(reVO.get(k).getSeaBufHrs())){
						totSeaBufHrs += Float.parseFloat(reVO.get(k).getSeaBufHrs());
					}
					if(reVO.get(k).getTztmHrs() != null && !"".equals(reVO.get(k).getTztmHrs())){
						totSeaTime += Float.parseFloat(reVO.get(k).getTztmHrs());
					}
					if(reVO.get(k+1).getMnvrInHrs() != null && !"".equals(reVO.get(k+1).getMnvrInHrs())){
						totMnvrInHrs += Float.parseFloat(reVO.get(k+1).getMnvrInHrs());
					}
					if(reVO.get(k).getMnvrOutHrs() != null && !"".equals(reVO.get(k).getMnvrOutHrs())){
						totMnvrOutHrs += Float.parseFloat(reVO.get(k).getMnvrOutHrs());
					}
					if(reVO.get(k).getActWrkHrs() != null && !"".equals(reVO.get(k).getActWrkHrs())){
						totActWrkHrs += Float.parseFloat(reVO.get(k).getActWrkHrs());
					}
					if(reVO.get(k).getPortBufHrs() != null && !"".equals(reVO.get(k).getPortBufHrs())){
						totPortBufHrs += Float.parseFloat(reVO.get(k).getPortBufHrs());
					}
					
				}
				//Showing Manu In at Last Row
				totMnvrInHrs = totMnvrInHrs + Float.parseFloat(reVO.get(reVO.size()-1).getMnvrInHrs());
				//Max Speed
				totMaxSpd = max;
				//Avg Speed
				totAvgSpd = Math.round(totLinkSpd/cnt);
				//Vsl Class Min_Max_Speed
				dMinMaxSpd = totBufSpd/cnt;//Math.round(totBufSpd/cnt);
				//Sea Buffer Speed
				double tempBufSpd = Double.parseDouble(reVO.get(0).getSeaBufSpd());
				BigDecimal bigBufSpd = new BigDecimal(tempBufSpd);
				bufSpd = bigBufSpd.setScale(1,BigDecimal.ROUND_HALF_UP);
				
				double tempTotBufRat = (totBufSpd+totSeaBufHrs)/(totSeaTime+totSeaBufHrs+totMnvrInHrs+totMnvrOutHrs+totActWrkHrs)*100;
				if(Double.toString(tempTotBufRat).equals("NaN") || Double.toString(tempTotBufRat).equals("Infinity")){
					tempTotBufRat = 0;
		        }
				BigDecimal bigTotBufRat = new BigDecimal(tempTotBufRat);
				totBufRat = bigTotBufRat.setScale(2,BigDecimal.ROUND_HALF_UP);
				
		
		        double tempSeaBufRat = totBufSpd/(totSeaTime+totSeaBufHrs+totMnvrInHrs+totMnvrOutHrs)*100;
		        if(Double.toString(tempSeaBufRat).equals("NaN") || Double.toString(tempSeaBufRat).equals("Infinity")){
		        	tempSeaBufRat = 0;
		        }
		        BigDecimal bigSeaBufRat = new BigDecimal(tempSeaBufRat);
		        seaBufRat = bigSeaBufRat.setScale(2,BigDecimal.ROUND_HALF_UP);
		        
		        double tempPortBufRat = totPortBufHrs/(totActWrkHrs+totPortBufHrs)*100;
		        if(Double.toString(tempPortBufRat).equals("NaN") || Double.toString(tempPortBufRat).equals("Infinity")){
		        	tempPortBufRat = 0;
		        }
		        BigDecimal bigPortBufRat = new BigDecimal(tempPortBufRat);
		        portBufRat = bigPortBufRat.setScale(2,BigDecimal.ROUND_HALF_UP);
		
		        double tempPfSpdRat = totAvgSpd/dMinMaxSpd*100;
		        if(Double.toString(tempPfSpdRat).equals("NaN") || Double.toString(tempPfSpdRat).equals("Infinity")){
		        	tempPfSpdRat = 0;
		        }
		        BigDecimal bigPfSpdRat = new BigDecimal(tempPfSpdRat);        
		        pfSpdRat = bigPfSpdRat.setScale(2,BigDecimal.ROUND_HALF_UP);
		        
		        double tempBufSpdRat = (totLinkSpd/(totSeaTime+totSeaBufHrs))/dMinMaxSpd*100;
		        if(Double.toString(tempBufSpdRat).equals("NaN") || Double.toString(tempBufSpdRat).equals("Infinity")){
		        	tempBufSpdRat = 0;
		        }
		        BigDecimal bigBufSpdRat = new BigDecimal(tempBufSpdRat);
		        bufSpdRat = bigBufSpdRat.setScale(2,BigDecimal.ROUND_HALF_UP);
		
				
		        vskPfSkdDtlVOs.get(0).setTotMaxSpd(Float.toString(totMaxSpd));
		        vskPfSkdDtlVOs.get(0).setTotAvgSpd(Float.toString(totAvgSpd));
		        vskPfSkdDtlVOs.get(0).setBufSpd(bufSpd.toString());
		        vskPfSkdDtlVOs.get(0).setTotBufRat(totBufRat.toString());
		        vskPfSkdDtlVOs.get(0).setSeaBufRat(seaBufRat.toString());
		        vskPfSkdDtlVOs.get(0).setPortBufRat(portBufRat.toString());
		        vskPfSkdDtlVOs.get(0).setPfSpdRat(pfSpdRat.toString());
		        vskPfSkdDtlVOs.get(0).setBufSpdRat(bufSpdRat.toString());
				
				
			}
			
			List<CoaSimRsltVO> coaSimRsltVOs = dbDao.searchCoaSimRslt(pfSkdRequestVO);
			CoaSimRsltVO coaSimRsltVO =  new CoaSimRsltVO();
			if(coaSimRsltVOs != null && coaSimRsltVOs.size() > 0){
				coaSimRsltVO.setTot(coaSimRsltVOs.get(0).getTot());
				coaSimRsltVO.setLf(coaSimRsltVOs.get(0).getLf());
				coaSimRsltVO.setRpb(coaSimRsltVOs.get(0).getRpb());
				coaSimRsltVO.setRev(coaSimRsltVOs.get(0).getRev());
				coaSimRsltVO.setOp(coaSimRsltVOs.get(0).getOp());
			}
			
			grpVO.setVskPfSkdVO(vskPfSkdVO);
			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
			grpVO.setCoaSimRsltVO(coaSimRsltVO);
			
			return grpVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * P/F SKD Settlement의 Settlement을 저장한다.<br>
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmSimScnr(PfSkdGRPVO pfSkdGRPVO, SignOnUserAccount account) throws EventException{
		try {
			VskPfSkdVO vskPfSkdVO 	= pfSkdGRPVO.getVskPfSkdVO();
			List<VskPfSkdDtlVO> 	vskPfSkdDtlVOs = pfSkdGRPVO.getVskPfSkdDtlVOs();

			String tempVslLlanCd 	= vskPfSkdVO.getVslSlanCd();
			String tempPfSvcTpCd 	= vskPfSkdVO.getPfSvcTpCd();
			String firstDirCd 		= vskPfSkdDtlVOs.get(0).getSkdDirCd();
			String pfSkdStsCd 		= vskPfSkdDtlVOs.get(0).getPfSkdStsCd();
			//String uiEvent = vskPfSkdDtlVOs.get(0).getUiEvent();
			
		
			// Checking input Yard Code is exist in MDM_YARD 
			String	ydCd		= "";
			int		checkCnt	= 0;
			
			if (vskPfSkdDtlVOs != null && vskPfSkdDtlVOs.size() > 0) {
				for(int i = 0 ; i < vskPfSkdDtlVOs.size() ;i++) {
					ydCd 		= vskPfSkdDtlVOs.get(i).getPortCd() + vskPfSkdDtlVOs.get(i).getYdCd();					
					checkCnt	= dbDao.checkYard(ydCd);				
					
					if (checkCnt == 0 ) {						
						String[] errMsgs = new String[]{ydCd};						
						throw new EventException((new ErrorHandler("VSK10057", errMsgs)).getMessage());
					} 						
				}
			}
			
			//Settlement : 0001 => COA
			//Creation : 0003 => Trunk, Feeder
			//Feeder : 0053 => Feeder
			//Thus Retrieving Service Type of Lane, then divide Saving logic to Trunk and Feeder 
			
			List<PfSkdVO> checkVskPfSkdVOs = searchPfSkd(tempVslLlanCd,tempPfSvcTpCd,"","");
			String vslSvcTpCdVal = "";
			String fdrDivCd = "";
			
			if(checkVskPfSkdVOs != null && checkVskPfSkdVOs.size() > 0){
				vslSvcTpCdVal = checkVskPfSkdVOs.get(0).getVslSvcTpCd();
				fdrDivCd = checkVskPfSkdVOs.get(0).getFdrDivCd();
			}else{
				MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
				mdmVslSvcLaneVO.setVslSlanCd(tempVslLlanCd);
				List<MdmVslSvcLaneVO> rtnmdmVslSvcLaneVOs = dbDao.searchSvcLaneList(mdmVslSvcLaneVO);
				if(rtnmdmVslSvcLaneVOs != null && rtnmdmVslSvcLaneVOs.size() > 0){
					vslSvcTpCdVal = rtnmdmVslSvcLaneVOs.get(0).getVslSvcTpCd();
					fdrDivCd = rtnmdmVslSvcLaneVOs.get(0).getFdrDivCd();
				}
			}
			
			//Checking in case of Trunk
			int checkPfSkdCnt = dbDao.checkPfSkd(tempVslLlanCd,tempPfSvcTpCd);
			int checkVskSkdCnt = 0;
			
			if("O".equals(vslSvcTpCdVal)){
				//in case of Feeder
				checkVskSkdCnt = 0;
			}else{
				//Checking duplicate of pf_skd
				//in case of Trunk
				
				checkVskSkdCnt = dbDao.checkVslSkdByPfSkd(tempVslLlanCd,tempPfSvcTpCd);
			}
			
			String[] dirCdArr = null;
			
			//[in case Proform Scedule is exist or using in Vessel Schedule] 
			//if inputted class and retrieved class are different, Exception
			//if same, updating data of Master Data except Vsl Class,laneCd,PfType
			if(checkVskPfSkdVOs != null && checkVskPfSkdVOs.size() > 0 && checkPfSkdCnt > 0 && checkVskSkdCnt > 0  ){
				String inputN1VslCd = vskPfSkdVO.getN1stVslClssCd();
				String searchN1VslCd = checkVskPfSkdVOs.get(0).getN1stVslClssCd();
				String inputN2VslCd = vskPfSkdVO.getN2ndVslClssCd();
				String searchN2VslCd = checkVskPfSkdVOs.get(0).getN2ndVslClssCd();
				String inputN3VslCd = vskPfSkdVO.getN3rdVslClssCd();
				String searchN3VslCd = checkVskPfSkdVOs.get(0).getN3rdVslClssCd();
				
				if(inputN1VslCd.equals(searchN1VslCd) &&
				   inputN2VslCd.equals(searchN2VslCd) &&
				   inputN3VslCd.equals(searchN3VslCd)){
					
					vskPfSkdVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyVskPfSkdMstInfo(vskPfSkdVO);
					
					// IBIS START
					PfSkdVO pfSkdVO = new PfSkdVO();
					pfSkdVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
					pfSkdVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
					List<PfSkdVO> list  = dbDao.searchVslPfSkd(pfSkdVO);
					for(PfSkdVO row : list){
						this.mPfSkdList.add(row);
					}
					// IBIS END
					
				}else{
					throw new EventException(new ErrorHandler("VSK10034").getMessage());
				}
				
			}else{
				
				//Checking Direction
				//E => W,W => E
				int firstPos = 0;
				int secondPos = 0;
				int checkDirCd = 0;
				dirCdArr = new String[2];
				dirCdArr[0] = firstDirCd;
				
				if(vskPfSkdDtlVOs != null) {
					for(int i=1; i<vskPfSkdDtlVOs.size(); i++){				
						if(!vskPfSkdDtlVOs.get(i).getSkdDirCd().equals(firstDirCd)){
							firstPos = i;
							checkDirCd = 1;
							break;
						}
					}
				
					dirCdArr[1] = vskPfSkdDtlVOs.get(firstPos).getSkdDirCd();				
					for(int k=firstPos; k<vskPfSkdDtlVOs.size(); k++){
						if(!vskPfSkdDtlVOs.get(k).getSkdDirCd().equals(dirCdArr[1])){
							secondPos = k;
							checkDirCd = 2;
							break;
						}
					}
				}
				if(secondPos > 0){
					throw new EventException(new ErrorHandler("VSK10040").getMessage()); 
				}
				
				//in case of Feeder
				//in case of Trunk and FDR_DIV_CD = 'O'
				if("O".equals(vslSvcTpCdVal) ||	(!"O".equals(vslSvcTpCdVal) && "O".equals(fdrDivCd))){
					if(checkDirCd == 0){
						String rtnFlag = dbDao.checkLaneDirection(tempVslLlanCd,dirCdArr[0],1);
						
						if("N".equals(rtnFlag.substring(1,2))){
							String msg = vskPfSkdVO.getVslSlanCd()+"/"+dirCdArr[0];
							throw new EventException(new ErrorHandler("VSK10043",new String[]{msg}).getMessage());
						}else if("N".equals(rtnFlag.substring(2,3))){
							String msg = vskPfSkdVO.getVslSlanCd()+"/"+dirCdArr[0];
							throw new EventException(new ErrorHandler("VSK10044",new String[]{msg}).getMessage());
						}
					}else if(checkDirCd > 0){
						for(int j=0; j<dirCdArr.length; j++){				
							String rtnFlag = dbDao.checkLaneDirection(tempVslLlanCd,dirCdArr[j],j+1);
							
							if("N".equals(rtnFlag.substring(0, 1))){
								String msg = vskPfSkdVO.getVslSlanCd()+"/"+dirCdArr[j]+"/"+(j+1);
								throw new EventException(new ErrorHandler("VSK10042",new String[]{msg}).getMessage());
							}else if("N".equals(rtnFlag.substring(1,2))){
								String msg = vskPfSkdVO.getVslSlanCd()+"/"+dirCdArr[j];
								throw new EventException(new ErrorHandler("VSK10043",new String[]{msg}).getMessage());
							}else if("N".equals(rtnFlag.substring(2,3))){
								String msg = vskPfSkdVO.getVslSlanCd()+"/"+dirCdArr[j];
								throw new EventException(new ErrorHandler("VSK10044",new String[]{msg}).getMessage());
							}
						}
					}
					
				//in case of Trunk
				}else{
					for(int j=0; j<dirCdArr.length; j++){				
						String rtnFlag = dbDao.checkLaneDirection(tempVslLlanCd,dirCdArr[j],j+1);
						
						if("N".equals(rtnFlag.substring(0, 1))){
							String msg = vskPfSkdVO.getVslSlanCd()+"/"+dirCdArr[j]+"/"+(j+1);
							throw new EventException(new ErrorHandler("VSK10042",new String[]{msg}).getMessage());
						}else if("N".equals(rtnFlag.substring(1,2))){
							String msg = vskPfSkdVO.getVslSlanCd()+"/"+dirCdArr[j];
							throw new EventException(new ErrorHandler("VSK10043",new String[]{msg}).getMessage());
						}else if("N".equals(rtnFlag.substring(2,3))){
							String msg = vskPfSkdVO.getVslSlanCd()+"/"+dirCdArr[j];
							throw new EventException(new ErrorHandler("VSK10044",new String[]{msg}).getMessage());
						}
					}
				}
				
				if(vskPfSkdVO.getStndSvcSpd() == null || "".equals(vskPfSkdVO.getStndSvcSpd())){
					vskPfSkdVO.setStndSvcSpd("0");
				}
				if(vskPfSkdVO.getBrthItvalDys() == null || "".equals(vskPfSkdVO.getBrthItvalDys())){
					vskPfSkdVO.setBrthItvalDys("0");
				}
				if(vskPfSkdVO.getMmlUsdFlg() == null || "".equals(vskPfSkdVO.getMmlUsdFlg())){
					vskPfSkdVO.setMmlUsdFlg("N");
				}
//				if(vskPfSkdVO.getN1stVslClssCd() == null || "".equals(vskPfSkdVO.getN1stVslClssCd())){
//					vskPfSkdVO.setN1stVslClssCd("0");
//				}
				if(vskPfSkdVO.getN1stVslClssKnt() == null || "".equals(vskPfSkdVO.getN1stVslClssKnt())){
					vskPfSkdVO.setN1stVslClssKnt("0");
				}
//				if(vskPfSkdVO.getN2ndVslClssCd() == null || "".equals(vskPfSkdVO.getN2ndVslClssCd())){
//					vskPfSkdVO.setN2ndVslClssCd("0");
//				}
				if(vskPfSkdVO.getN2ndVslClssKnt() == null || "".equals(vskPfSkdVO.getN2ndVslClssKnt())){
					vskPfSkdVO.setN2ndVslClssKnt("0");
				}
//				if(vskPfSkdVO.getN3rdVslClssCd() == null || "".equals(vskPfSkdVO.getN3rdVslClssCd())){
//					vskPfSkdVO.setN3rdVslClssCd("0");
//				}
				if(vskPfSkdVO.getN3rdVslClssKnt() == null || "".equals(vskPfSkdVO.getN3rdVslClssKnt())){
					vskPfSkdVO.setN3rdVslClssKnt("0");
				}
				if(vskPfSkdVO.getClptKnt() == null || "".equals(vskPfSkdVO.getClptKnt())){
					vskPfSkdVO.setClptKnt("0");
				}
				if(vskPfSkdVO.getTtlDist() == null || "".equals(vskPfSkdVO.getTtlDist())){
					vskPfSkdVO.setTtlDist("0");
				}
				if(vskPfSkdVO.getMaxSpd() == null || "".equals(vskPfSkdVO.getMaxSpd())){
					vskPfSkdVO.setMaxSpd("0");
				}
				if(vskPfSkdVO.getAvgSpd() == null || "".equals(vskPfSkdVO.getAvgSpd())){
					vskPfSkdVO.setAvgSpd("0");
				}
				if(vskPfSkdVO.getDeltFlg() == null || "".equals(vskPfSkdVO.getDeltFlg())){
					vskPfSkdVO.setDeltFlg("N");
				}				
				
				vskPfSkdVO.setCreUsrId(account.getUsr_id());
				vskPfSkdVO.setUpdUsrId(account.getUsr_id());
				
				if(checkPfSkdCnt == 0){
					dbDao.addVskPfSkd		(vskPfSkdVO);
					
					// IBIS START
					PfSkdVO pfSkdVO = new PfSkdVO();
					pfSkdVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
					pfSkdVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
					List<PfSkdVO> list  = dbDao.searchVslPfSkd(pfSkdVO);
					for(PfSkdVO row : list){
						this.mPfSkdList.add(row);
					}
					// IBIS END
					
					/** Adding the function of saving service lane direction when creating proforma
					 *  2015-12-03 : by TOP
					 *  Improvement internally
					 * **/
					dbDao.addVskPfSkdDir	(vskPfSkdVO);
					
				}else{
					dbDao.modifyVskPfSkd	(vskPfSkdVO);
					
					// IBIS START
					PfSkdVO pfSkdVO = new PfSkdVO();
					pfSkdVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
					pfSkdVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
					List<PfSkdVO> list  = dbDao.searchVslPfSkd(pfSkdVO);
					for(PfSkdVO row : list){
						this.mPfSkdList.add(row);
					}
					
					VskPfSkdDtlVO  vskPfSkdDtlVO = new VskPfSkdDtlVO();
					vskPfSkdDtlVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
					vskPfSkdDtlVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
					List<VskPfSkdDtlVO> list2  = dbDao.searchVslPfSkdDtl(vskPfSkdDtlVO);
					for(VskPfSkdDtlVO row : list2){
						this.mVskPfSkdDtlList.add(row);
					}
					// IBIS END
					
					dbDao.removeVskPfSkdDtl	(tempVslLlanCd,tempPfSvcTpCd);
				}
				
				int firstSkdDirPos = 0;
				String firstSkdDirCd = "";
				String[] skdDirCdArr = new String[2];
				skdDirCdArr[0] = firstSkdDirCd;
				int secondSkdDirPos = 0;
				
				
				if(vskPfSkdDtlVOs != null){
					//one direction - false, two direction - true;
					for(int i=0; i<vskPfSkdDtlVOs.size(); i++){
						if(!"D".equals(vskPfSkdDtlVOs.get(i).getIbflag())){
							firstSkdDirCd = vskPfSkdDtlVOs.get(i).getSkdDirCd();
							firstSkdDirPos = i;
							break;
						}
					}					

					for(int i=1; i<vskPfSkdDtlVOs.size(); i++){				
						if(!vskPfSkdDtlVOs.get(i).getSkdDirCd().equals(firstSkdDirCd)){
							secondSkdDirPos = i;
							break;
						}
					}
				
				}

				if(secondSkdDirPos > 0){
					
					/****************************************************
					 * Release Turning Port Flat Limit for CCA Feeder
					 * 2014-08-06
					 * TOP
					 */
					if(!"O".equals(vslSvcTpCdVal)){
						vskPfSkdDtlVOs.get(firstSkdDirPos).setTurnPortFlg	("Y");
						vskPfSkdDtlVOs.get(firstSkdDirPos).setTurnPortIndCd	("N");						
					}
					
					//initializing ETD, DIST, SEA SPEED at last row
					VskPfSkdDtlVO  lastVO = vskPfSkdDtlVOs.get(vskPfSkdDtlVOs.size()-1);
					//setting Terminal Code of first row to last row
					lastVO.setTurnPortFlg("N");
					lastVO.setTurnPortIndCd("F");
					//when P/F SKD Creation, different of ETB-ETD are same at first port and last port
//					lastVO.setEtdDyNo(Integer.toString(Integer.parseInt(vskPfSkdDtlVOs.get(0).getEtdDyNo()) + Integer.parseInt(lastVO.getEtbDyNo())));
					lastVO.setEtdDyNo(Integer.toString(
					        Integer.parseInt(vskPfSkdDtlVOs.get(0).getEtdDyNo()) 
					        - Integer.parseInt(vskPfSkdDtlVOs.get(0).getEtbDyNo())  
					        + Integer.parseInt(lastVO.getEtbDyNo()))
					        );
					
					vskPfSkdDtlVOs.set(vskPfSkdDtlVOs.size()-1, lastVO);
				}
		
				
				if(vskPfSkdDtlVOs != null){

					for(int i=0; i<vskPfSkdDtlVOs.size(); i++){
						if(!"D".equals(vskPfSkdDtlVOs.get(i).getIbflag())){
							
							VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOs.get(i);
							int portRotnSeq = i+1; 
							vskPfSkdDtlVO.setPortRotnSeq(Integer.toString(portRotnSeq));
							vskPfSkdDtlVO.setYdCd		(vskPfSkdDtlVO.getPortCd()+vskPfSkdDtlVO.getYdCd());
							vskPfSkdDtlVO.setCreUsrId	(account.getUsr_id());
							vskPfSkdDtlVO.setUpdUsrId	(account.getUsr_id());
							
							dbDao.addVskPfSkdDtl		(vskPfSkdDtlVO);
							
							// IBIS START
							VskPfSkdDtlVO  dtlVO = new VskPfSkdDtlVO();
							dtlVO.setVslSlanCd(vskPfSkdDtlVO.getVslSlanCd());
							dtlVO.setPfSvcTpCd(vskPfSkdDtlVO.getPfSvcTpCd());
							dtlVO.setPortCd(vskPfSkdDtlVO.getPortCd());
							dtlVO.setSkdDirCd(vskPfSkdDtlVO.getSkdDirCd());
							dtlVO.setClptSeq(vskPfSkdDtlVO.getClptSeq());
							
							List<VskPfSkdDtlVO> list3  = dbDao.searchVslPfSkdDtl(dtlVO);
							for(VskPfSkdDtlVO row : list3){
								this.mVskPfSkdDtlList.add(row);
							}
							// IBIS END
							
						}
					}
					
				}

			}
			
			if(!("O".equals(vslSvcTpCdVal))){
				VskPfSkdHisVO vskPfSkdHisVO = new VskPfSkdHisVO();
				
				vskPfSkdHisVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
				vskPfSkdHisVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
				vskPfSkdHisVO.setSimDt(vskPfSkdVO.getSimDt());
				vskPfSkdHisVO.setSimNo(vskPfSkdVO.getSimNo());			
				vskPfSkdHisVO.setDiffRmk(vskPfSkdVO.getPfSkdRmk());
				
				// in case of saving in Creation
				if("B".equals(pfSkdStsCd)){
					//either the Lane_Cd, Pf_Svc_Tp_Cd are create or update
					if(checkPfSkdCnt > 0){
						vskPfSkdHisVO.setPfSkdStsCd("C");
					}else{
						vskPfSkdHisVO.setPfSkdStsCd(pfSkdStsCd);
					}
				}
				//in case of saving in Settlement
				else{
					vskPfSkdHisVO.setPfSkdStsCd(pfSkdStsCd);
				}
				
				vskPfSkdHisVO.setCreUsrId(account.getUsr_id());
				vskPfSkdHisVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addVskPfSkdHis(vskPfSkdHisVO);
			}
			
			int returnCnt = dbDao.searchPfStandardCount(vskPfSkdVO);
			
			if(returnCnt > 1 || returnCnt == 0){

				// IBIS START 
				PfSkdVO pfSkdVO = new PfSkdVO();
				pfSkdVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
				pfSkdVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
				if(returnCnt > 1){
					pfSkdVO.setPagerows("1");	
				}else{
					pfSkdVO.setPagerows("0");
				}
				
				
				List<PfSkdVO> list  = dbDao.searchVslPfSkd(pfSkdVO);
				for(PfSkdVO row : list){
					this.mPfSkdList.add(row);
				}
				// IBIS END
				
				dbDao.modifyVskPfSkd(vskPfSkdVO,returnCnt);

			}
			
			// in case dirCdArr[0] and dirCdArr[1] are same, do not create
			if (dirCdArr != null && dirCdArr[1].compareTo(dirCdArr[0])!=0){ //  if(dirCdArr!=null && (dirCdArr[0]!=dirCdArr[1])){ 
				VskPfCallPortVO vskPfCallPortVO = new VskPfCallPortVO();
				vskPfCallPortVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
				vskPfCallPortVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
				vskPfCallPortVO.setCreUsrId(account.getUsr_id());
				
				dbDao.removeVskPfCallPort	(vskPfCallPortVO);
				dbDao.addVskPfCallPort		(vskPfCallPortVO);
			}
			  
		} catch (EventException ex) {
			throw ex;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), de);
		}
	}
	
	/**
	 * P/F SKD Settlement ,Creation의 M/Simulation의 정보를 조회한다.<br>
	 *  ProformaScheduleMgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO calPfSkdManual(PfSkdGRPVO pfSkdGRPVO) throws EventException {
		try {
			
			//Master Data  : PF_SKD Table VO
			VskPfSkdVO masterVO = pfSkdGRPVO.getVskPfSkdVO();
			//화면 그리드의 원본 데이타를 담은 VO
			List<VskPfSkdDtlVO> detailVOs = pfSkdGRPVO.getVskPfSkdDtlVOs();

			//화면에서 ibFlag가 Delete로 삭제된 데이타를 제외한 나머지 데이타로 다시 시뮬레이션을
			//하고 화면에 리턴 시킬 VO
			List<VskPfSkdDtlVO> rtnDetailVOs = new ArrayList<VskPfSkdDtlVO>();
			
			PfSkdGRPVO returnVO = new PfSkdGRPVO();
			
			//Vsl Class의 최대 Min 값을 가져온다
			VskPfSkdDtlVO vskPfSkdDtlVO= detailVOs.get(0);
			//String minMaxSpd = vskPfSkdDtlVO.getMinMaxSpd();
			String minMaxSpd = vskPfSkdDtlVO.getMinMaxSpd();
			minMaxSpd = VSKGeneralUtil.getCheckNullToString(minMaxSpd);
			minMaxSpd = minMaxSpd.replace(" ", "");
			
			
			if(minMaxSpd == null || "".equals(minMaxSpd) || "0.00".equals(minMaxSpd)){
				minMaxSpd = "1";
			}
				
			String eventNav = vskPfSkdDtlVO.getEventNav();
	
			for(int i=0; i<detailVOs.size(); i++){

				if(!"D".equals(detailVOs.get(i).getIbflag())){
					rtnDetailVOs.add(detailVOs.get(i));
				}
			}
			
			for(int i=0; i<rtnDetailVOs.size(); i++){
				//첫번째 로우의 ETD 시간을 구한다
				if(i == 0){							
					// 첫번째 ETD 구하는 공식 : 당차수 ETB + Working H + Port Buffer
					String etbDyNo = rtnDetailVOs.get(i).getEtbDyNo();
					String etbDyCd = rtnDetailVOs.get(i).getEtbDyCd();
					String etbTmHrmnt = rtnDetailVOs.get(i).getEtbTmHrmnt();
					String etbPortCd = rtnDetailVOs.get(i).getPortCd();
					
					String n1ActWrkHrs = rtnDetailVOs.get(i).getActWrkHrs();
					String n1PortBufHrs = rtnDetailVOs.get(i).getPortBufHrs();

					HashMap<String, String> etdParamM = new HashMap<String, String>();
					etdParamM.put("etbDyNo",etbDyNo);
					etdParamM.put("etbDyCd",etbDyCd);
					etdParamM.put("etbTmHrmnt",etbTmHrmnt);
					etdParamM.put("actWrkHrs",n1ActWrkHrs);
					etdParamM.put("portBufHrs",n1PortBufHrs);
					etdParamM.put("portCd",etbPortCd);
					
					HashMap<String, String> valM = calETDTime(etdParamM);
					String calNo = (String)valM.get("ratDay");
					String calWeek = (String)valM.get("calWeek");
					String ratTm = (String)valM.get("ratTm");

					rtnDetailVOs.get(i).setEtdDyNo(calNo);
					rtnDetailVOs.get(i).setEtdDyCd(calWeek);
					rtnDetailVOs.get(i).setEtdTmHrmnt(ratTm);
					rtnDetailVOs.get(i).setTurnPortFlg("Y");
					rtnDetailVOs.get(i).setTurnPortIndCd("N");
					
					//Sea Time 계산
					double dLnkDist = Double.parseDouble((rtnDetailVOs.get(i).getLnkDist()));  //DISTANCE
					double dLnkSpd = Double.parseDouble((rtnDetailVOs.get(i).getLnkSpd()));  //SEA SPEED
					double dTempTztmHrs = 0;
					BigDecimal bTztmHrs = null;
					if( 0 < Double.compare(dLnkDist,0) && 0 < Double.compare(dLnkSpd,0)){
						dTempTztmHrs = dLnkDist / dLnkSpd;
						BigDecimal  bigTztmHrs = new BigDecimal(dTempTztmHrs);
						bTztmHrs = bigTztmHrs.setScale(0,BigDecimal.ROUND_HALF_UP);			
						rtnDetailVOs.get(i).setTztmHrs(bTztmHrs.toString());
					}
					
					//Sea Buffer Spd 계산 
					double dSeaBuffer = Double.parseDouble((detailVOs.get(i).getSeaBufHrs())); //Sea Buffer
					double dTempVal = dTempTztmHrs + dSeaBuffer;
					double dTempSeaBufSpd = 0;
					BigDecimal bSeaBufSpd = null;
					if( 0 < Double.compare(dLnkDist,0) && 0 < Double.compare(dTempVal,0)){
						dTempSeaBufSpd = dLnkDist / dTempVal;
						BigDecimal  bigSeaBufSpd = new BigDecimal(dTempSeaBufSpd);
						bSeaBufSpd = bigSeaBufSpd.setScale(2,BigDecimal.ROUND_HALF_UP);	
						rtnDetailVOs.get(i).setSeaBufSpd(bSeaBufSpd.toString());
					}
					
					
					//Working Hour = 전체 물량 (IPC In + IPC Out + Ocean In + Ocean Out ) / 터미널 생산성으로 표시
					//20091012 임창빈수석 Working Hours가 0 이면 전체 물량 (IPC In + IPC Out + Ocean In + Ocean Out ) / 터미널 생산성으로 표시 으로
					//0보다 크면 계산하지 않고 그대로 출력
//					double dWorkHurs = Double.parseDouble(rtnDetailVOs.get(i).getActWrkHrs());
					//if(0  == Double.compare(dWorkHurs,0)){
						int iIbIpcgoQty = Integer.parseInt(rtnDetailVOs.get(i).getIbIpcgoQty());
						int iObIpcgoQty = Integer.parseInt(rtnDetailVOs.get(i).getObIpcgoQty());
						int iIbOcnCgoQty = Integer.parseInt(rtnDetailVOs.get(i).getIbOcnCgoQty());
						int iObOcnCgoQty = Integer.parseInt(rtnDetailVOs.get(i).getObOcnCgoQty());
						double dTotCgoQty = (double)(iIbIpcgoQty+iObIpcgoQty+iIbOcnCgoQty+iObOcnCgoQty);
						double dTmlProdQty = Double.parseDouble(rtnDetailVOs.get(i).getTmlProdQty());

						double dTempWorkingHur = 0;
						BigDecimal bWorkingHur = null;
						if( 0 < Double.compare(dTotCgoQty,0) && 0 < Double.compare(dTmlProdQty,0)){
							dTempWorkingHur = dTotCgoQty/dTmlProdQty;							
							BigDecimal  bigWorkingHur = new BigDecimal(dTempWorkingHur);
							bWorkingHur = bigWorkingHur.setScale(1,BigDecimal.ROUND_HALF_UP);	
							rtnDetailVOs.get(i).setActWrkHrs(bWorkingHur.toString());
							
							HashMap<String, String> etdParamM2 = new HashMap<String, String>();
							etdParamM2.put("etbDyNo",etbDyNo);
							etdParamM2.put("etbDyCd",etbDyCd);
							etdParamM2.put("etbTmHrmnt",etbTmHrmnt);
							etdParamM2.put("actWrkHrs",bWorkingHur.toString());
							etdParamM2.put("portBufHrs",n1PortBufHrs);
							etdParamM2.put("portCd",etbPortCd);
							
							HashMap<String, String> valM2 = calETDTime(etdParamM2);
							String calNo2 = (String)valM2.get("ratDay");
							String calWeek2 = (String)valM2.get("calWeek");
							String ratTm2 = (String)valM2.get("ratTm");

							rtnDetailVOs.get(i).setEtdDyNo(calNo2);
							rtnDetailVOs.get(i).setEtdDyCd(calWeek2);
							rtnDetailVOs.get(i).setEtdTmHrmnt(ratTm2);
							rtnDetailVOs.get(i).setTurnPortFlg("Y");
							rtnDetailVOs.get(i).setTurnPortIndCd("N");
						}						
					//}					
					//minMaxSpd = resultV0.getLnkSpd();
					rtnDetailVOs.get(i).setMinMaxSpd(minMaxSpd);
					rtnDetailVOs.get(i).setEventNav("A");
			
				}else{
					//첫번째 로우 이후의 공식
					//ETB = SEATIME(전차수) + SEA BUFFER(전차수)+(MANU/IN(전차수)+MANU/OUT(전차수))+ZD(현재차수(ZD)-전차수(ZD))+ETD(전차수)
					//2009.09.22 임창빈 수석 업무 수정
					//ETB = SEATIME(전차수) + SEA BUFFER(전차수)+(MANU/IN(현재차수)+MANU/OUT(전차수))+ZD(현재차수(ZD)-전차수(ZD))+ETD(전차수)
					String tztmHrs = rtnDetailVOs.get(i-1).getTztmHrs();
				    String seaBufHrs = rtnDetailVOs.get(i-1).getSeaBufHrs();
					String mnvrInHrs = rtnDetailVOs.get(i).getMnvrInHrs();
					String mnvrOutHrs = rtnDetailVOs.get(i-1).getMnvrOutHrs();
					String portCd = rtnDetailVOs.get(i-1).getPortCd();

					String postZd = rtnDetailVOs.get(i-1).getZd();
					if(postZd == null || postZd.equals("")){
						postZd = "0";
					}
					String currZd = rtnDetailVOs.get(i).getZd();
					if(currZd == null || currZd.equals("")){
						currZd = "0";
					}
					String etdDyNo = rtnDetailVOs.get(i-1).getEtdDyNo();
					String etdDyCd = rtnDetailVOs.get(i-1).getEtdDyCd();
					String etdTmHrmnt = rtnDetailVOs.get(i-1).getEtdTmHrmnt();
					etdTmHrmnt = etdTmHrmnt.replace(":", ".");

					HashMap<String, String> paramMap = new HashMap<String, String>();
					paramMap.put("tztmHrs", tztmHrs);
					paramMap.put("seaBufHrs", seaBufHrs);
					paramMap.put("mnvrInHrs", mnvrInHrs);
					paramMap.put("mnvrOutHrs", mnvrOutHrs);
					paramMap.put("postZd", postZd);
					paramMap.put("currZd", currZd);
					paramMap.put("etdDyNo", etdDyNo);
					paramMap.put("etdDyCd", etdDyCd);
					paramMap.put("etdTmHrmnt", etdTmHrmnt);
					paramMap.put("portCd", portCd);					
					HashMap<String, String> etbValM = calETBTime(paramMap);
					String calEtbDyCd = (String)etbValM.get("etbDyCd");
					String calEtbDyNo = (String)etbValM.get("etbDyNo");
					String calEtbTmHrmnt = (String)etbValM.get("etbTmHrmnt");
					
					VskPfSkdDtlVO tempEtbVO = rtnDetailVOs.get(i);
					tempEtbVO.setEtbDyNo(calEtbDyNo);
					tempEtbVO.setEtbDyCd(calEtbDyCd);
					tempEtbVO.setEtbTmHrmnt(calEtbTmHrmnt);
					rtnDetailVOs.set(i, tempEtbVO);
					
					String etbDyNo = rtnDetailVOs.get(i).getEtbDyNo();
					String etbDyCd = rtnDetailVOs.get(i).getEtbDyCd();
					String etbTmHrmnt = rtnDetailVOs.get(i).getEtbTmHrmnt();
					etbTmHrmnt = etbTmHrmnt.replace(":", ".");
					
					String actWrkHrs = rtnDetailVOs.get(i).getActWrkHrs();
					String portBufHrs = rtnDetailVOs.get(i).getPortBufHrs();
									
					HashMap<String, String> etdParamM = new HashMap<String, String>();
					etdParamM.put("etbDyNo",etbDyNo);
					etdParamM.put("etbDyCd",etbDyCd);
					etdParamM.put("etbTmHrmnt",etbTmHrmnt);
					etdParamM.put("actWrkHrs",actWrkHrs);
					etdParamM.put("portBufHrs",portBufHrs);
					etdParamM.put("portCd",portCd);
					HashMap<String, String> valM = calETDTime(etdParamM);
					String calNo = (String)valM.get("ratDay");
					String calWeek = (String)valM.get("calWeek");
					String ratTm = (String)valM.get("ratTm");
					VskPfSkdDtlVO tempEtdVO = rtnDetailVOs.get(i);
					tempEtdVO.setEtdDyNo(calNo);
					tempEtdVO.setEtdDyCd(calWeek);
					tempEtdVO.setEtdTmHrmnt(ratTm);
					tempEtdVO.setTurnPortIndCd(tempEtdVO.getTurnPortFlg());
					rtnDetailVOs.set(i, tempEtdVO);
					
					//Sea Time 계산
					double dLnkDist = Double.parseDouble((rtnDetailVOs.get(i).getLnkDist()));  //DISTANCE
					double dLnkSpd = Double.parseDouble((rtnDetailVOs.get(i).getLnkSpd()));  //SEA SPEED
					double dTempTztmHrs = 0;
					BigDecimal bTztmHrs = null;
					if( 0 < Double.compare(dLnkDist,0) && 0 < Double.compare(dLnkSpd,0)){
						dTempTztmHrs = dLnkDist / dLnkSpd;
						BigDecimal  bigTztmHrs = new BigDecimal(dTempTztmHrs);
						bTztmHrs = bigTztmHrs.setScale(0,BigDecimal.ROUND_HALF_UP);			
						rtnDetailVOs.get(i).setTztmHrs(bTztmHrs.toString());
					}
			
					//Sea Buffer Spd 계산 
					double dSeaBuffer = Double.parseDouble((rtnDetailVOs.get(i).getSeaBufHrs())); //Sea Buffer
					double dTempVal = dTempTztmHrs + dSeaBuffer;
					double dTempSeaBufSpd = 0;
					BigDecimal bSeaBufSpd = null;
					if( 0 < Double.compare(dLnkDist,0) && 0 < Double.compare(dTempVal,0)){
						dTempSeaBufSpd = dLnkDist / dTempVal;
						BigDecimal  bigSeaBufSpd = new BigDecimal(dTempSeaBufSpd);
						bSeaBufSpd = bigSeaBufSpd.setScale(2,BigDecimal.ROUND_HALF_UP);	
						rtnDetailVOs.get(i).setSeaBufSpd(bSeaBufSpd.toString());
					}
					
					//Working Hour = 전체 물량 (IPC In + IPC Out + Ocean In + Ocean Out ) / 터미널 생산성으로 표시
					//20091012 임창빈수석 Working Hours가 0 이면 전체 물량 (IPC In + IPC Out + Ocean In + Ocean Out ) / 터미널 생산성으로 표시 으로
					//0보다 크면 계산하지 않고 그대로 출력
//					double dWorkHurs = Double.parseDouble(rtnDetailVOs.get(i).getActWrkHrs());
					//if(0  == Double.compare(dWorkHurs,0)){
						//Working Hour = 전체 물량 (IPC In + IPC Out + Ocean In + Ocean Out ) / 터미널 생산성으로 표시
						int iIbIpcgoQty = Integer.parseInt(rtnDetailVOs.get(i).getIbIpcgoQty());
						int iObIpcgoQty = Integer.parseInt(rtnDetailVOs.get(i).getObIpcgoQty());
						int iIbOcnCgoQty = Integer.parseInt(rtnDetailVOs.get(i).getIbOcnCgoQty());
						int iObOcnCgoQty = Integer.parseInt(rtnDetailVOs.get(i).getObOcnCgoQty());
						double dTotCgoQty = (double)(iIbIpcgoQty+iObIpcgoQty+iIbOcnCgoQty+iObOcnCgoQty);
						double dTmlProdQty = Double.parseDouble(rtnDetailVOs.get(i).getTmlProdQty());
						
						double dTempWorkingHur = 0;
						BigDecimal bWorkingHur = null;
						if( 0 < Double.compare(dTotCgoQty,0) && 0 < Double.compare(dTmlProdQty,0)){
							dTempWorkingHur = dTotCgoQty/dTmlProdQty;
							BigDecimal  bigWorkingHur = new BigDecimal(dTempWorkingHur);
							bWorkingHur = bigWorkingHur.setScale(1,BigDecimal.ROUND_HALF_UP);
							rtnDetailVOs.get(i).setActWrkHrs(bWorkingHur.toString());
							
							HashMap<String, String> etdParamM2 = new HashMap<String, String>();
							etdParamM2.put("etbDyNo",etbDyNo);
							etdParamM2.put("etbDyCd",etbDyCd);
							etdParamM2.put("etbTmHrmnt",etbTmHrmnt);
							etdParamM2.put("actWrkHrs",bWorkingHur.toString());
							etdParamM2.put("portBufHrs",portBufHrs);
							etdParamM2.put("portCd",portCd);
							HashMap<String, String> valM2 = calETDTime(etdParamM2);
							
							String calNo2 = (String)valM2.get("ratDay");
							String calWeek2 = (String)valM2.get("calWeek");
							String ratTm2 = (String)valM2.get("ratTm");
							VskPfSkdDtlVO tempEtdVO2 = rtnDetailVOs.get(i);
							tempEtdVO2.setEtdDyNo(calNo2);
							tempEtdVO2.setEtdDyCd(calWeek2);
							tempEtdVO2.setEtdTmHrmnt(ratTm2);
							tempEtdVO2.setTurnPortIndCd(tempEtdVO2.getTurnPortFlg());
							rtnDetailVOs.set(i, tempEtdVO2);
						}
					//}
					
											
					//minMaxSpd = resultV0.getLnkSpd();
					rtnDetailVOs.get(i).setMinMaxSpd(minMaxSpd);

				}
			}
			
			String firstDirCd = rtnDetailVOs.get(0).getSkdDirCd();
			String[] dirCdArr = new String[2];
			dirCdArr[0] = firstDirCd;
			int firstPos = 0;
			
			for(int i=1; i<rtnDetailVOs.size(); i++){				
				if(!rtnDetailVOs.get(i).getSkdDirCd().equals(firstDirCd)){
					firstPos = i;
					break;
				}
			}
			rtnDetailVOs.get(firstPos).setTurnPortFlg("Y");
			rtnDetailVOs.get(firstPos).setTurnPortIndCd("Y");
			
			//마지막 로우의 ETD와 DIST,SEA SPEED등 데이타 초기화
			VskPfSkdDtlVO  lastVO = rtnDetailVOs.get(rtnDetailVOs.size()-1);
			//첫번째 로우의 Terminal Code를 마지막 로우에 셋팅한다
			lastVO.setYdCd(rtnDetailVOs.get(0).getYdCd());
			lastVO.setTurnPortFlg("N");
			lastVO.setTurnPortIndCd("F");
			rtnDetailVOs.set(rtnDetailVOs.size()-1, lastVO);

			if("A".equals(eventNav)){
				double cnt = rtnDetailVOs.size()-1;
				double totLinkSpd = 0;
				double totBufSpd = 0;
				double totSeaBufHrs = 0;
				double totSeaTime = 0;
				double totMnvrInHrs = 0;
				double totMnvrOutHrs = 0;
				double totActWrkHrs = 0;
				double totPortBufHrs = 0;
				double dMinMaxSpd = Double.parseDouble(minMaxSpd);
				float totMaxSpd = 0;
				float totAvgSpd = 0;
				double totStndSvcSpd = 0;
				BigDecimal bufSpd = null;
				BigDecimal totBufRat = null;
				BigDecimal seaBufRat = null;
				BigDecimal portBufRat = null;
				BigDecimal pfSpdRat = null;
				BigDecimal bufSpdRat = null;
				BigDecimal stndSvcStdBig = null;
				
				
				float max = 0;
				for(int k=0; k<rtnDetailVOs.size()-1; k++){
					
					
					// 품질오류. float 비교는 compare 연산자로 처리
					//if(Float.parseFloat(detailVOs.get(k).getLnkSpd()) > max){
					if(Float.compare(Float.parseFloat(rtnDetailVOs.get(k).getLnkSpd()), max)>0){
						max = Float.parseFloat(rtnDetailVOs.get(k).getLnkSpd());
					}
					
					totLinkSpd 	+= Float.parseFloat(rtnDetailVOs.get(k).getLnkSpd());
					
					totBufSpd += Float.parseFloat(rtnDetailVOs.get(k).getSeaBufSpd());
					totSeaBufHrs += Float.parseFloat(rtnDetailVOs.get(k).getSeaBufHrs());
					totSeaTime += Float.parseFloat(rtnDetailVOs.get(k).getTztmHrs());
					
					totMnvrInHrs += Float.parseFloat(rtnDetailVOs.get(k+1).getMnvrInHrs());
					
					totMnvrOutHrs += Float.parseFloat(rtnDetailVOs.get(k).getMnvrOutHrs());					
					totActWrkHrs += Float.parseFloat(rtnDetailVOs.get(k).getActWrkHrs());
					totPortBufHrs += Float.parseFloat(rtnDetailVOs.get(k).getPortBufHrs());
				}
					
					
				totMaxSpd = max;
				totAvgSpd = Math.round(totLinkSpd/cnt);
				totStndSvcSpd = totLinkSpd/cnt;
				double tempBufSpd = totBufSpd/cnt;//Math.round(totBufSpd/cnt);
				if(Double.toString(tempBufSpd).equals("NaN") || Double.toString(tempBufSpd).equals("Infinity")){
					tempBufSpd = 0;
		        }
				BigDecimal bigBufSpd = new BigDecimal(tempBufSpd);
				bufSpd = bigBufSpd.setScale(1,BigDecimal.ROUND_HALF_UP);
				
				double tempTotBufRat = (totBufSpd+totSeaBufHrs)/(totSeaTime+totSeaBufHrs+totMnvrInHrs+totMnvrOutHrs+totActWrkHrs)*100;
				if(Double.toString(tempTotBufRat).equals("NaN") || Double.toString(tempTotBufRat).equals("Infinity")){
					tempTotBufRat = 0;
		        }
				BigDecimal bigTotBufRat = new BigDecimal(tempTotBufRat);
				totBufRat = bigTotBufRat.setScale(2,BigDecimal.ROUND_HALF_UP);
				
		
		        double tempSeaBufRat = totBufSpd/(totSeaTime+totSeaBufHrs+totMnvrInHrs+totMnvrOutHrs)*100;
		        if(Double.toString(tempSeaBufRat).equals("NaN") || Double.toString(tempSeaBufRat).equals("Infinity")){
		        	tempSeaBufRat = 0;
		        }
		        BigDecimal bigSeaBufRat = new BigDecimal(tempSeaBufRat);
		        seaBufRat = bigSeaBufRat.setScale(2,BigDecimal.ROUND_HALF_UP);
		        
		        double tempPortBufRat = totPortBufHrs/(totActWrkHrs+totPortBufHrs)*100;
		        if(Double.toString(tempPortBufRat).equals("NaN") || Double.toString(tempPortBufRat).equals("Infinity")){
		        	tempPortBufRat = 0;
		        }
		        BigDecimal bigPortBufRat = new BigDecimal(tempPortBufRat);
		        portBufRat = bigPortBufRat.setScale(2,BigDecimal.ROUND_HALF_UP);
		
		        //::2015-04-19 =>> 2015-05-27:by TOP:://double tempPfSpdRat = totAvgSpd/dMinMaxSpd*100;
		        double tempPfSpdRat	= 0.0d;
//		        if(Double.compare(totMaxSpd, 0.0d) > 0)	tempPfSpdRat	= totAvgSpd/totMaxSpd*100;
		        if(totMaxSpd > 0 && Double.compare(totMaxSpd, 0.0d) > 0){
		        	BigDecimal bdTotMaxSpd = new BigDecimal(String.valueOf(totMaxSpd));
		        	BigDecimal bdTotAvgSpd = new BigDecimal(String.valueOf(totAvgSpd));
		            BigDecimal bdDftValue = new BigDecimal("100");
		        	tempPfSpdRat = bdDftValue.multiply(bdTotAvgSpd.divide(bdTotMaxSpd, 5, BigDecimal.ROUND_HALF_UP)).doubleValue();
		        }
		        ////////////////////////////////////////////////////////////////////////////////////////////////////
		        
		        if(Double.toString(tempPfSpdRat).equals("NaN") || Double.toString(tempPfSpdRat).equals("Infinity")){
		        	tempPfSpdRat = 0;
		        }
		        BigDecimal bigPfSpdRat = new BigDecimal(tempPfSpdRat);        
		        pfSpdRat = bigPfSpdRat.setScale(2,BigDecimal.ROUND_HALF_UP);
		        
		        double tempBufSpdRat = (totLinkSpd/(totSeaTime+totSeaBufHrs))/dMinMaxSpd*100;
		        if(Double.toString(tempBufSpdRat).equals("NaN") || Double.toString(tempBufSpdRat).equals("Infinity")){
		        	tempBufSpdRat = 0;
		        }
		        BigDecimal bigBufSpdRat = new BigDecimal(tempBufSpdRat);
		        bufSpdRat = bigBufSpdRat.setScale(2,BigDecimal.ROUND_HALF_UP);
		
		        BigDecimal bigStndSvcSpd = new BigDecimal(totStndSvcSpd);
		        stndSvcStdBig = bigStndSvcSpd.setScale(1, BigDecimal.ROUND_HALF_UP);
		        
				rtnDetailVOs.get(0).setTotMaxSpd(Float.toString(totMaxSpd));
				rtnDetailVOs.get(0).setTotAvgSpd(Float.toString(totAvgSpd));
				rtnDetailVOs.get(0).setBufSpd(bufSpd.toString());
				rtnDetailVOs.get(0).setTotBufRat(totBufRat.toString());
				rtnDetailVOs.get(0).setSeaBufRat(seaBufRat.toString());
				rtnDetailVOs.get(0).setPortBufRat(portBufRat.toString());
				rtnDetailVOs.get(0).setPfSpdRat(pfSpdRat.toString());
				rtnDetailVOs.get(0).setBufSpdRat(bufSpdRat.toString());
				masterVO.setStndSvcSpd(stndSvcStdBig.toString());
			}
			
			for(int i=0; i<rtnDetailVOs.size(); i++){
				VskPfSkdDtlVO gangVO = rtnDetailVOs.get(i);
				gangVO.setEtbTmHrmnt(gangVO.getEtbTmHrmnt().replace(":", ""));
				
				List<VskPfSkdDtlVO> rtnGangVOs = dbDao.searchVosiGangInfo(gangVO);
				if(rtnGangVOs != null && rtnGangVOs.size() > 0){
					rtnDetailVOs.get(i).setCheckWkTm(rtnGangVOs.get(0).getCheckWkTm());
					rtnDetailVOs.get(i).setCraneWkTm(rtnGangVOs.get(0).getCraneWkTm());
					
				}
			}
			
			returnVO.setVskPfSkdVO(masterVO);
			returnVO.setVskPfSkdDtlVOs(rtnDetailVOs);
			
			return returnVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	
	/**
	 * P/F SKD Settlement Simulation<br>
	 * Calculating ETD Time of ProformaScheduleMgt
	 * 
	 * @param HashMap<String, String> paramMap
	 * @return HashMap<String, String>
	 * @exception EventException
	 */
	private HashMap<String, String> calETDTime(HashMap<String, String> paramMap)throws EventException{

		HashMap<String,String> hMap = new HashMap<String,String>();
		float totTm = 0;
		try{
			String portCd = (String)paramMap.get("portCd");
			int ietbDyNo = Integer.parseInt((String)paramMap.get("etbDyNo"));
			String setbDyCd = (String)paramMap.get("etbDyCd");
			String setbTm = (String)paramMap.get("etbTmHrmnt");
			String tempSetbTm = setbTm.substring(0,2).replace(".", "");
			
			int checkSetDyCd = setbDyCd.indexOf("-");
			int checkEtdTmHrmnt = tempSetbTm.indexOf("-");

			if(checkSetDyCd == 1 || checkEtdTmHrmnt == 1){
				throw new EventException(new ErrorHandler("VSK10041",new String[]{portCd}).getMessage());
			}
			
			if(tempSetbTm.length() < 2){
				tempSetbTm = "0"+tempSetbTm;
			}
			int ietbTm = Integer.parseInt(tempSetbTm);
			String tempActWrkHrs = (String)paramMap.get("actWrkHrs");
			tempActWrkHrs = tempActWrkHrs.replace(".3", ".5");
			float fworkTm = Float.parseFloat(tempActWrkHrs);
			String tempPortBufHrs = (String)paramMap.get("portBufHrs");
			tempPortBufHrs = tempPortBufHrs.replace(".3", ".5");
			float fportTm = Float.parseFloat(tempPortBufHrs);
			float tempSetbMin = Float.parseFloat(setbTm.replace(".", "").substring(2,4)) / 60;
			
			totTm = ietbTm + tempSetbMin + fworkTm + fportTm;
			int itotTm = (int)totTm;
			float totSec = totTm - itotTm;
			
			//int ratDay = itotTm / 24;
			//int ratTm = itotTm % 24;
			
			int ratDay = (itotTm >= 0) ? itotTm / 24 : (-24 + itotTm) / 24;			
			int ratTm = (itotTm >= 0) ? itotTm % 24 : 24 + itotTm;
			
			String ratSec = "0";
			if(0 > Double.compare(totSec, 0.5)){
				if(ratTm < 10){
					String ratTmF =  ratSec + ratTm + ":00";				
					hMap.put("ratTm", ratTmF);
				}else{				
					String ratTmF =  ratTm  +":00";
					hMap.put("ratTm", ratTmF);	
				}
				
			}else if(0 == Double.compare(totSec, 0.5)){
				if(ratTm < 10){
					//String ratTmF = (Integer.toString(ratTm)+":30");
					String ratTmF = ratSec + ratTm+":30";
					hMap.put("ratTm", ratTmF);
				}else{
					String ratTmF = (Integer.toString(ratTm)+":30");
					hMap.put("ratTm", ratTmF);
				}
				
			}else{		
				if(ratTm < 10){
					//String ratTmF = ratTm + Integer.parseInt("1") + ":00";
					int ratTmTemp = ratTm + Integer.parseInt("1");					
					if(ratTmTemp < 10){
						String ratTmF = ratSec +(ratTm + 1) + ":00";			
						hMap.put("ratTm", ratTmF);					
					}else{
						String ratTmF = ratTm + Integer.parseInt("1") + ":00";
						hMap.put("ratTm", ratTmF);
					}
				}else{
					String ratTmF = ratTm + Integer.parseInt("1") + ":00";
					hMap.put("ratTm", ratTmF);
				}
			}		
			
			ietbDyNo = ietbDyNo+ratDay;
			
			hMap.put("ratDay", Integer.toString(ietbDyNo));
			String calWeek = getCalWeek(setbDyCd, ratDay, portCd);
			hMap.put("calWeek", calWeek);
			return hMap;
		}catch (EventException ex) {
			throw ex;
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * P/F SKD Settlement Simulation<br>
	 * Calculating ETB Time of ProformaScheduleMgt
	 * 
	 * @param HashMap<String, String> paramMap
	 * @return HashMap<String, String>
	 * @exception EventException
	 */
private HashMap<String, String> calETBTime(HashMap<String, String> paramMap) throws EventException{
		
		HashMap<String,String> hMap = new HashMap<String,String>();
		float totTm = 0;
		int etbDyNo = 0;
		
		try{			
			String portCd = (String)paramMap.get("portCd");
			String tempTztmHrs = (String)paramMap.get("tztmHrs");
			tempTztmHrs = tempTztmHrs.replace(".3", ".5");
			float ftztmHrs = Float.parseFloat(tempTztmHrs);
			String tempSeaBufHrs = (String)paramMap.get("seaBufHrs");
			tempSeaBufHrs = tempSeaBufHrs.replace(".3", ".5");
			float fseaBufHrs = Float.parseFloat(tempSeaBufHrs);
			String tempMnvrInHrs = (String)paramMap.get("mnvrInHrs");
			tempMnvrInHrs = tempMnvrInHrs.replace(".3", ".5");
			float fmnvrInHrs = Float.parseFloat(tempMnvrInHrs);
			String tempMnvrOutHrs = (String)paramMap.get("mnvrOutHrs");
			tempMnvrOutHrs = tempMnvrOutHrs.replace(".3", ".5");
			float fmnvrOutHrs = Float.parseFloat(tempMnvrOutHrs);
			
			float fpostZd = Float.parseFloat((String)paramMap.get("postZd"));
			float fcurrZd = Float.parseFloat((String)paramMap.get("currZd"));
			int ietdDyNo = Integer.parseInt((String)paramMap.get("etdDyNo")); 
			String setdDyCd = (String)paramMap.get("etdDyCd");
			String tempEtdTmHrmnt = (String)paramMap.get("etdTmHrmnt");
			int checkSetDyCd = setdDyCd.indexOf("-");
			int checkEtdTmHrmnt = tempEtdTmHrmnt.indexOf("-");

			if(checkSetDyCd == 1 || checkEtdTmHrmnt == 1){
				throw new EventException(new ErrorHandler("VSK10041",new String[]{portCd}).getMessage());
			}
			tempEtdTmHrmnt = tempEtdTmHrmnt.replace(".3", ".5");
			float fegdTmHrmnt = Float.parseFloat(tempEtdTmHrmnt);
	
			totTm = ftztmHrs+fseaBufHrs+(fmnvrInHrs+fmnvrOutHrs)+(fcurrZd-fpostZd)+fegdTmHrmnt;
			
			int itotTm = (int)totTm;
			float totSec = totTm - itotTm;
	
			//int ratDay = itotTm / 24;
			//int ratTm = itotTm % 24;
			
			int ratDay = (itotTm >= 0) ? itotTm / 24 : (-24 + itotTm) / 24;			
			int ratTm = (itotTm >= 0) ? itotTm % 24 : 24 + itotTm;
			
			String ratSec = "0";
			if(0 > Double.compare(totSec, 0.5)){
				if(ratTm < 10){
					String ratTmF =  ratSec + ratTm + ":00";				
					hMap.put("etbTmHrmnt", ratTmF);
				}else{				
					String ratTmF =  ratTm  +":00";
					hMap.put("etbTmHrmnt", ratTmF);	
				}
			}else if(0 == Double.compare(totSec, 0.5)){
				if(ratTm < 10){
					String ratTmF = ratSec + ratTm+":30";
					hMap.put("etbTmHrmnt", ratTmF);
				}else{
					String ratTmF = (Integer.toString(ratTm)+":30");
					hMap.put("etbTmHrmnt", ratTmF);
				}
			}else{
				if(ratTm < 10){
					int ratTmTemp = ratTm + Integer.parseInt("1");					
					if(ratTmTemp < 10){
						String ratTmF = ratSec +(ratTm + 1) + ":00";			
						hMap.put("etbTmHrmnt", ratTmF);					
					}else{
						String ratTmF = ratTm + Integer.parseInt("1") + ":00";
						hMap.put("etbTmHrmnt", ratTmF);
					}
				}else{
					String ratTmF = ratTm + Integer.parseInt("1") + ":00";
					hMap.put("etbTmHrmnt", ratTmF);
				}
			}		
			
			etbDyNo = ietdDyNo+ratDay;
					
			String calWeek = getCalWeek(setdDyCd, ratDay, portCd);
			hMap.put("etbDyNo", Integer.toString(etbDyNo));
			hMap.put("etbDyCd", calWeek);
			return hMap;
		}catch (EventException ex) {
			throw ex;	
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10041").getMessage(), ex);
		}
	}
	
	/**
	 * P/F SKD Settlement Simulation<br>
	 * Calculating Next Port of ProformaScheduleMgt
	 * 
	 * @param HashMap paramMap
	 * @return HashMap
	 * @exception EventException
	 */
	private String getCalWeek(String dyCd, int tmVal, String portCd) throws Exception{
		try{
			String[] dayCd = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
			String reVal = "";
			int currPos = 0;
			int nextPos = 0;
			for(int i=0; i<dayCd.length; i++){
				if(dayCd[i].equals(dyCd)){
					currPos = i;
				}
			}
			//if(tmVal < 0){
			//	throw new EventException(new ErrorHandler("VSK10041",new String[]{portCd}).getUserMessage());
			//}
			nextPos = currPos + tmVal;
			nextPos = nextPos % 7;
			reVal = dayCd[nextPos];
			
			return reVal;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10041").getMessage(), ex);
		}
	}

	/**
	 * P/F SKD Creation AutoSimulation
	 * AutoSimulation of ProformaScheduleMgt
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdGRPVO
	 * @exception EventException
	 */
	public PfSkdGRPVO calPfSkdAuto(PfSkdGRPVO pfSkdGRPVO) throws EventException {
		try{
			VskPfSkdVO masterVO = pfSkdGRPVO.getVskPfSkdVO();
			List<VskPfSkdDtlVO> detailVOs = pfSkdGRPVO.getVskPfSkdDtlVOs();
			
			PfSkdGRPVO returnGRPVO = new PfSkdGRPVO();
			
//			String minMaxSpd = "";
	
			String firVslCd = masterVO.getN1stVslClssCd();
			String secVslCd = "";
			String thrVslCd = "";
			
			if(VSKGeneralUtil.isNotNull(masterVO.getN2ndVslClssCd())){
				secVslCd = masterVO.getN2ndVslClssCd();
			}
			
			if(VSKGeneralUtil.isNotNull(masterVO.getN3rdVslClssCd())){
				thrVslCd = masterVO.getN3rdVslClssCd();
			}
			
			int voCnt = detailVOs.size();
			List<VskPfSkdDtlVO> list = null;
		
			for(int i=0; i<detailVOs.size(); i++){
				if(i == 0){
					PfSkdVO paramVo = new PfSkdVO();
					paramVo.setN1stVslClssCd(firVslCd);
					paramVo.setN2ndVslClssCd(secVslCd);
					paramVo.setN3rdVslClssCd(thrVslCd);
					
					String postPortCd = detailVOs.get(i).getPortCd();
					String postYdcd = detailVOs.get(i).getYdCd();
					String nextPortCd = detailVOs.get(i+1).getPortCd();
					String paramYdCd = postPortCd+postYdcd;
					String paramLocCd = nextPortCd;
					
					paramVo.setPortCd(postPortCd);
					paramVo.setYdCd(paramYdCd);
					paramVo.setPodLocCd(paramLocCd);
	
					
					list = dbDao.searchPortPairInfo(paramVo);
					
					if(list != null && list.size() != 0){
						VskPfSkdDtlVO resultV0 = list.get(0);
				
						//setting return of searchPortPairInfo
						detailVOs.get(i).setLnkDist(resultV0.getLnkDist());
						detailVOs.get(i).setZd(resultV0.getFmZd());
						detailVOs.get(i+1).setZd(resultV0.getToZd());
						detailVOs.get(i).setMnvrInHrs(resultV0.getMnvrInHrs());
						detailVOs.get(i).setMnvrOutHrs(resultV0.getMnvrOutHrs());
						detailVOs.get(i).setPortBufHrs(resultV0.getPortBufHrs());				
						detailVOs.get(i).setLnkSpd(resultV0.getLnkSpd());					
						detailVOs.get(i).setCrnKnt(resultV0.getCrnKnt());
						detailVOs.get(i).setTmlProdQty(resultV0.getTmlProdQty());
						
					}
				}else if(voCnt - i  > 1){
					//after first row
					//ETB = SEATIME(pre) + SEA BUFFER(pre)+(MANU/IN(pre)+MANU/OUT(pre))+ZD(now(ZD)-pre(ZD))+ETD(pre)
					
					PfSkdVO paramVo = new PfSkdVO();
					paramVo.setN1stVslClssCd(firVslCd);
					paramVo.setN2ndVslClssCd(secVslCd);
					paramVo.setN3rdVslClssCd(thrVslCd);
	
					String postPortCd = detailVOs.get(i).getPortCd();
					String postYdcd = detailVOs.get(i).getYdCd();
					String nextPortCd = detailVOs.get(i+1).getPortCd();
					String paramYdCd = postPortCd+postYdcd;
					String paramLocCd = nextPortCd;
					
					paramVo.setPortCd(postPortCd);
					paramVo.setYdCd(paramYdCd);
					paramVo.setPodLocCd(paramLocCd);
					
					list = dbDao.searchPortPairInfo(paramVo);
					
					if(list != null && list.size() != 0){
						VskPfSkdDtlVO resultV0 = list.get(0);
						
						//setting return value of searchPortPairInfo
						detailVOs.get(i).setLnkDist(resultV0.getLnkDist());
						detailVOs.get(i).setZd(resultV0.getFmZd());
						detailVOs.get(i+1).setZd(resultV0.getToZd());
						detailVOs.get(i).setMnvrInHrs(resultV0.getMnvrInHrs());
						detailVOs.get(i).setMnvrOutHrs(resultV0.getMnvrOutHrs());
						detailVOs.get(i).setPortBufHrs(resultV0.getPortBufHrs());
						detailVOs.get(i).setLnkSpd(resultV0.getLnkSpd());
						detailVOs.get(i).setCrnKnt(resultV0.getCrnKnt());
						detailVOs.get(i).setTmlProdQty(resultV0.getTmlProdQty());	
						
					}
				}else{
					
				}
			}

			returnGRPVO.setVskPfSkdVO(masterVO);
			returnGRPVO.setVskPfSkdDtlVOs(detailVOs);

			return  calPfSkdManual(returnGRPVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Distance of FROM, TO PORT, ZD(ZONE DESCRIPTION), CRANE count, terminal productivity
	 * 
	 * @param List<PfSkdVO> pfSkdVOs
	 * @return List<PfSkdVO>
	 * @exception EventException
	 */
	public List<PfSkdVO> searchPortInfo(List<PfSkdVO> pfSkdVOs) throws EventException {
		List<PfSkdVO> rtnPfSkdVOs = new ArrayList<PfSkdVO>();

		try {
			for(int i=0; i<pfSkdVOs.size(); i++){
				PfSkdVO pfSkdVO  = pfSkdVOs.get(i);
				List<PfSkdVO>  rtnVOs = dbDao.searchPortInfo(pfSkdVO);
				PfSkdVO valVO = new PfSkdVO();
				valVO = rtnVOs.get(0);
				rtnPfSkdVOs.add(valVO);
			}
			
			return rtnPfSkdVOs;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * Deleting PF SKD of P/F SKD Settlement
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removePfSkd(VskPfSkdVO vskPfSkdVO, SignOnUserAccount account) throws EventException{
		try {
			
			String tempVslLlanCd = vskPfSkdVO.getVslSlanCd();
			String tempPfSvcTpCd = vskPfSkdVO.getPfSvcTpCd();
			String vslSvcTpCdVal = "";
			
			//Settlement : 0001 => COA
			//Creation : 0003 => Trunk, Feeder
			//Feeder : 0053 => Feeder
			//Thus Retrieving Service Type of Lane, then divide Saving logic to Trunk and Feeder 
			List<PfSkdVO> checkVskPfSkdVOs = searchPfSkd(tempVslLlanCd,tempPfSvcTpCd,"","");
			
			if(checkVskPfSkdVOs != null && checkVskPfSkdVOs.size() > 0){
				vslSvcTpCdVal = checkVskPfSkdVOs.get(0).getVslSvcTpCd();
			}else{
				MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
				mdmVslSvcLaneVO.setVslSlanCd(tempVslLlanCd);
				List<MdmVslSvcLaneVO> rtnmdmVslSvcLaneVOs = dbDao.searchSvcLaneList(mdmVslSvcLaneVO);
				if(rtnmdmVslSvcLaneVOs != null && rtnmdmVslSvcLaneVOs.size() > 0){
					vslSvcTpCdVal = rtnmdmVslSvcLaneVOs.get(0).getVslSvcTpCd();
				}
			}

			//Checking in case of Trunk
			int checkVskSkdCnt = 0;
			if("O".equals(vslSvcTpCdVal)){
				//in case of Feeder
				checkVskSkdCnt = 0;
			}else{
				//in case of Trunk
				//Checking Proforma use with VSL_SLAN_CD,PF_TYPE_CD
				checkVskSkdCnt = dbDao.checkVslSkdByPfSkd(tempVslLlanCd,tempPfSvcTpCd);
				
				//in case the PF use, returning message and skip 
				if(checkVskSkdCnt > 0){
					throw new EventException(new ErrorHandler("VSK10034").getMessage());
				}
			}
			//in case the PF use not	
			VskPfSkdHisVO vskPfSkdHisVO = new VskPfSkdHisVO();
			
			vskPfSkdHisVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
			vskPfSkdHisVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
			vskPfSkdHisVO.setSimDt(vskPfSkdVO.getSimDt());
			vskPfSkdHisVO.setSimNo(vskPfSkdVO.getSimNo());
			vskPfSkdHisVO.setDiffRmk(vskPfSkdVO.getPfSkdRmk());
			vskPfSkdHisVO.setCreUsrId(account.getUsr_id());
			vskPfSkdHisVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addVskPfSkdHis(vskPfSkdHisVO);
			
			VskPfCallPortVO vskPfCallPortVO = new VskPfCallPortVO();
			vskPfCallPortVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
			vskPfCallPortVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
			dbDao.removeVskPfCallPort(vskPfCallPortVO);
			
			
			// IBIS START
			PfSkdVO pfSkdVO = new PfSkdVO();
			pfSkdVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
			pfSkdVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
			List<PfSkdVO> list  = dbDao.searchVslPfSkd(pfSkdVO);
			for(PfSkdVO row : list){
				this.mPfSkdList.add(row);
			}
			
			VskPfSkdDtlVO  vskPfSkdDtlVO = new VskPfSkdDtlVO();
			vskPfSkdDtlVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
			vskPfSkdDtlVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
			List<VskPfSkdDtlVO> list2  = dbDao.searchVslPfSkdDtl(vskPfSkdDtlVO);
			for(VskPfSkdDtlVO row : list2){
				this.mVskPfSkdDtlList.add(row);
			}
			// IBIS END
			
			/** Adding the function of removing service lane direction when deleting proforma 
			 *  2015-12-03 : by TOP
			 *  Improvement internally
			 * **/
			dbDao.removeVskPfSkdDir	(tempVslLlanCd,tempPfSvcTpCd);
			
			dbDao.removeVskPfSkdDtl	(tempVslLlanCd,tempPfSvcTpCd);
			
			dbDao.removeVskPfSkd	(tempVslLlanCd,tempPfSvcTpCd);
			
			//Checking Standard Flag
			int returnCntq = dbDao.searchPfStandardCount(vskPfSkdVO);
			
			//Standard P/F Schedule not exist
			if(returnCntq == 0){
				List<VskPfSkdVO> vskPfSkdVOs = dbDao.searchPfSkdNewest(vskPfSkdVO);				
				if(vskPfSkdVOs != null && vskPfSkdVOs.size() > 0){
					
					// IBIS START 
					PfSkdVO pfSkdVO2 = new PfSkdVO();
					pfSkdVO2.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
					pfSkdVO2.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
					pfSkdVO2.setPagerows(String.valueOf(returnCntq));
					
					List<PfSkdVO> list3  = dbDao.searchVslPfSkd(pfSkdVO2);
					for(PfSkdVO row : list3){
						this.mPfSkdList.add(row);
					}
					// IBIS END
					
					VskPfSkdVO updateVO = vskPfSkdVOs.get(0);
					dbDao.modifyVskPfSkd(updateVO,returnCntq);
				}
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		}
	}
	
	/**
	 * Retrieving P/F Type CD is exist
	 * 
	 * @param VskPfSkdVO vskPfSkdVO
	 * @return String
	 * @exception EventException
	 */
	public String checkPfType(VskPfSkdVO vskPfSkdVO) throws EventException {
//		List<PfSkdVO> rtnPfSkdVOs = new ArrayList<PfSkdVO>();
		String pfTypeCdData = "";

		try {
			if(vskPfSkdVO != null){
				pfTypeCdData = dbDao.checkPfType(vskPfSkdVO);;
			}
			
			return pfTypeCdData;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Deleting selected row(s) of ProformaScheduleMgt, recombining information of existed ports
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return List<VskPfSkdDtlVO>
	 * @exception EventException
	 */
	public List<VskPfSkdDtlVO> calRowDelete(PfSkdGRPVO pfSkdGRPVO) throws EventException {
		try{
			VskPfSkdVO masterVO = pfSkdGRPVO.getVskPfSkdVO();
			List<VskPfSkdDtlVO> detailVOs = pfSkdGRPVO.getVskPfSkdDtlVOs();
			
			String firVslCd = masterVO.getN1stVslClssCd();
			String secVslCd = "";
			String thrVslCd = "";
			
			if(VSKGeneralUtil.isNotNull(masterVO.getN2ndVslClssCd())){
				secVslCd = masterVO.getN2ndVslClssCd();
			}
			
			if(VSKGeneralUtil.isNotNull(masterVO.getN3rdVslClssCd())){
				thrVslCd = masterVO.getN3rdVslClssCd();
			}
			
			int voCnt = detailVOs.size();
			List<VskPfSkdDtlVO> list = null;
			
			if(detailVOs != null && detailVOs.size() > 0){
				for(int i=0; i<detailVOs.size(); i++){
					if(i == 0){
						PfSkdVO paramVo = new PfSkdVO();
						paramVo.setN1stVslClssCd(firVslCd);
						paramVo.setN2ndVslClssCd(secVslCd);
						paramVo.setN3rdVslClssCd(thrVslCd);
						
						String postPortCd = detailVOs.get(i).getPortCd();
						String postYdcd = detailVOs.get(i).getYdCd();
						String nextPortCd = detailVOs.get(i+1).getPortCd();
						String paramYdCd = postPortCd+postYdcd;
						String paramLocCd = nextPortCd;
						
						paramVo.setPortCd(postPortCd);
						paramVo.setYdCd(paramYdCd);
						paramVo.setPodLocCd(paramLocCd);
		
						list = dbDao.searchPortPairInfo(paramVo);
						
						if(list != null && list.size() != 0){
							VskPfSkdDtlVO resultV0 = list.get(0);
					
							//setting return of searchPortPairInfo
							detailVOs.get(i).setLnkDist(resultV0.getLnkDist());
							
							//Calculating Sea Time
							double dLnkDist = Double.parseDouble((detailVOs.get(i).getLnkDist()));  //DISTANCE
							double dLnkSpd = Double.parseDouble((detailVOs.get(i).getLnkSpd()));  //SEA SPEED
							double dTempTztmHrs = 0;
							BigDecimal bTztmHrs = null;
							if( 0 < Double.compare(dLnkDist,0) && 0 < Double.compare(dLnkSpd,0)){
								dTempTztmHrs = dLnkDist / dLnkSpd;
								BigDecimal  bigTztmHrs = new BigDecimal(dTempTztmHrs);
								bTztmHrs = bigTztmHrs.setScale(0,BigDecimal.ROUND_HALF_UP);			
								detailVOs.get(i).setTztmHrs(bTztmHrs.toString());
							}
							detailVOs.get(i).setTurnPortFlg("Y");
							detailVOs.get(i).setTurnPortIndCd("N");
							
						}
					}else if(voCnt - i  > 1){
						//after first row
						PfSkdVO paramVo = new PfSkdVO();
						paramVo.setN1stVslClssCd(firVslCd);
						paramVo.setN2ndVslClssCd(secVslCd);
						paramVo.setN3rdVslClssCd(thrVslCd);
		
						String postPortCd = detailVOs.get(i).getPortCd();
						String postYdcd = detailVOs.get(i).getYdCd();
						String nextPortCd = detailVOs.get(i+1).getPortCd();
						String paramYdCd = postPortCd+postYdcd;
						String paramLocCd = nextPortCd;
						
						paramVo.setPortCd(postPortCd);
						paramVo.setYdCd(paramYdCd);
						paramVo.setPodLocCd(paramLocCd);
						
						list = dbDao.searchPortPairInfo(paramVo);
						
						if(list != null && list.size() != 0){
							VskPfSkdDtlVO resultV0 = list.get(0);
							
							//setting return of searchPortPairInfo
							detailVOs.get(i).setLnkDist(resultV0.getLnkDist());
							
							//Calculating Sea Time
							double dLnkDist = Double.parseDouble((detailVOs.get(i).getLnkDist()));  //DISTANCE
							double dLnkSpd = Double.parseDouble((detailVOs.get(i).getLnkSpd()));  //SEA SPEED
							double dTempTztmHrs = 0;
							BigDecimal bTztmHrs = null;
							if( 0 < Double.compare(dLnkDist,0) && 0 < Double.compare(dLnkSpd,0)){
								dTempTztmHrs = dLnkDist / dLnkSpd;
								BigDecimal  bigTztmHrs = new BigDecimal(dTempTztmHrs);
								bTztmHrs = bigTztmHrs.setScale(0,BigDecimal.ROUND_HALF_UP);			
								detailVOs.get(i).setTztmHrs(bTztmHrs.toString());
							}
						}
					}
				}
				
				String firstSkdDirCd = "";
				if(detailVOs.size()>0){
					firstSkdDirCd = detailVOs.get(0).getSkdDirCd();
				}
	
				String[] skdDirCdArr = new String[2];
				skdDirCdArr[0] = firstSkdDirCd;
				int secondSkdDirPos = 0;
				
				for(int j=1; j<detailVOs.size(); j++){				
					if(!detailVOs.get(j).getSkdDirCd().equals(firstSkdDirCd)){
						secondSkdDirPos = j;
						break;
					}
				}
		
				detailVOs.get(secondSkdDirPos).setTurnPortFlg("Y");
				detailVOs.get(secondSkdDirPos).setTurnPortIndCd("Y");
				
	
				VskPfSkdDtlVO  lastVO = detailVOs.get(detailVOs.size()-1);
				//setting Terminal Code of first row to last row
				lastVO.setTurnPortFlg("N");
				lastVO.setTurnPortIndCd("F");
				detailVOs.set(detailVOs.size()-1, lastVO);
			}

			return  detailVOs;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}	
	
	/**
	 * BERTH WINDOW 정보를 조회한다.<br>
	 * 
	 * @param List<VskPfSkdDtlVO> vskPfSkdDtlVOs
	 * @return List<PfSkdBerthWdoVO>
	 * @exception EventException
	 */
	public List<PfSkdBerthWdoVO> searchPfSkdBerthWdo(List<VskPfSkdDtlVO> vskPfSkdDtlVOs) throws EventException {
		List<PfSkdBerthWdoVO> pfSkdBerthWdoVOs = new ArrayList<PfSkdBerthWdoVO>();
		try {
			for(int i=0; i<vskPfSkdDtlVOs.size(); i++){
				if(!"EGSCA".equals(vskPfSkdDtlVOs.get(i).getPortCd()) || !"PAPCA".equals(vskPfSkdDtlVOs.get(i).getPortCd())){
					List<PfSkdBerthWdoVO> rtnVOs = dbDao.searchPfSkdBerthWdo(vskPfSkdDtlVOs.get(i));
					for(int k=0; k<rtnVOs.size(); k++){
						pfSkdBerthWdoVOs.add(rtnVOs.get(k));
					}
				}
			}
			
			return pfSkdBerthWdoVOs;
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
	 * EOTP Creation의 정보를 조회한다.<br>
	 *  EOTP Creation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdEotpGRPVO
	 * @exception EventException
	 */
	public PfSkdEotpGRPVO searchPfSkdEotpSum(PfSkdGRPVO pfSkdGRPVO) throws EventException {
		try {

			PfSkdEotpGRPVO returnVO = new PfSkdEotpGRPVO();
			List<PfSkdEotpSumVO> summaryVO = new ArrayList<PfSkdEotpSumVO>();
			List<PfSkdEotpDtlVO> detailVO = new ArrayList<PfSkdEotpDtlVO>();
			
			VskPfSkdVO vskPfSkdVO = pfSkdGRPVO.getVskPfSkdVO();
			List<VskPfSkdDtlVO> vskPfSkdDtlVOsTemp = pfSkdGRPVO.getVskPfSkdDtlVOs();
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = new ArrayList<VskPfSkdDtlVO>();
			
			//2009 09 29 임창빈수석 요청사항  - 기존  메인화면의 그리드 turn_Port_Ind_Cd는 마지막 로우가 'F'였으나
			//EOTP 팝업을 띄우기 위해 기존 메인화면의 데이타에서 ADD ROW를 하고 EOTP 팝업을 부를 시
			//turn_Port_Ind_Cd는 마지막 로우만 F로 해서 조회를 가능하도록 한다
			//0001의 그리드의 데이타와 EOTP의 데이타는 다르기 때문  - 0001은 VSL_SLAN_CD와 PF_TYPE_CD의 조회지만
			//EOTP는 순수하게 각 포트 페어간의 데이타 이므로 가능.
//			for(int i=0; i<vskPfSkdDtlVOsTemp.size(); i++){
//				String turnPortIndCd = vskPfSkdDtlVOsTemp.get(i).getTurnPortIndCd();
//				if(!"F".equals(turnPortIndCd)){
//					vskPfSkdDtlVOs.add(vskPfSkdDtlVOsTemp.get(i));
//				}
//			}
			
			for(int i=0; i<vskPfSkdDtlVOsTemp.size()-1; i++){
				vskPfSkdDtlVOs.add(vskPfSkdDtlVOsTemp.get(i));
			}

			int cnt = vskPfSkdDtlVOs.size();
			
			for(int k=0; k<cnt; k++){
				PfSkdEotpSumVO tempSummaryVO = new PfSkdEotpSumVO();
				tempSummaryVO.setPortcd(vskPfSkdDtlVOs.get(k).getPortCd());
				summaryVO.add(k, tempSummaryVO);
			}
			
			for(int i=0; i<cnt; i++){
				PfSkdEotpSumVO paramVO = null;
				if(i == cnt-1){
					paramVO = new PfSkdEotpSumVO();
					
					paramVO.setBfPortCd(vskPfSkdDtlVOs.get(i).getPortCd());
					paramVO.setToPortCd(vskPfSkdDtlVOs.get(0).getPortCd());
					paramVO.setIbIpcgoQty(vskPfSkdDtlVOs.get(i).getIbIpcgoQty());
					paramVO.setObIpcgoQty(vskPfSkdDtlVOs.get(i).getObIpcgoQty());
					paramVO.setIbOcnCgoQty(vskPfSkdDtlVOs.get(i).getIbOcnCgoQty());
					paramVO.setObOcnCgoQty(vskPfSkdDtlVOs.get(i).getObOcnCgoQty());
					paramVO.setTmlProdQty(vskPfSkdDtlVOs.get(i).getTmlProdQty());
					paramVO.setPortBufHrs(vskPfSkdDtlVOs.get(i).getPortBufHrs());
					paramVO.setLnkDist(vskPfSkdDtlVOs.get(i).getLnkDist());
					paramVO.setLnkSpd(vskPfSkdDtlVOs.get(i).getLnkSpd());
					paramVO.setSeaBufHrs(vskPfSkdDtlVOs.get(i).getSeaBufHrs());
					paramVO.setHistYr(vskPfSkdVO.getPfSkdRmk());
					paramVO.setN1stVslClssCd(vskPfSkdVO.getN1stVslClssCd());
					paramVO.setN2ndVslClssCd(vskPfSkdVO.getN2ndVslClssCd());
					paramVO.setN3rdVslClssCd(vskPfSkdVO.getN3rdVslClssCd());
			
				}else{
					 paramVO = new PfSkdEotpSumVO();

					paramVO.setBfPortCd(vskPfSkdDtlVOs.get(i).getPortCd());
					paramVO.setToPortCd(vskPfSkdDtlVOs.get(i+1).getPortCd());
					paramVO.setIbIpcgoQty(vskPfSkdDtlVOs.get(i).getIbIpcgoQty());
					paramVO.setObIpcgoQty(vskPfSkdDtlVOs.get(i).getObIpcgoQty());
					paramVO.setIbOcnCgoQty(vskPfSkdDtlVOs.get(i).getIbOcnCgoQty());
					paramVO.setObOcnCgoQty(vskPfSkdDtlVOs.get(i).getObOcnCgoQty());
					paramVO.setTmlProdQty(vskPfSkdDtlVOs.get(i).getTmlProdQty());
					paramVO.setPortBufHrs(vskPfSkdDtlVOs.get(i).getPortBufHrs());
					paramVO.setLnkDist(vskPfSkdDtlVOs.get(i).getLnkDist());
					paramVO.setLnkSpd(vskPfSkdDtlVOs.get(i).getLnkSpd());
					paramVO.setSeaBufHrs(vskPfSkdDtlVOs.get(i).getSeaBufHrs());
					paramVO.setHistYr(vskPfSkdVO.getPfSkdRmk());
					paramVO.setN1stVslClssCd(vskPfSkdVO.getN1stVslClssCd());
					paramVO.setN2ndVslClssCd(vskPfSkdVO.getN2ndVslClssCd());
					paramVO.setN3rdVslClssCd(vskPfSkdVO.getN3rdVslClssCd());
				
				}
				List<PfSkdEotpSumVO> rtnSummaryVOs = dbDao.searchPfSkdEotpSum(paramVO);

				if(rtnSummaryVOs != null && rtnSummaryVOs.size() > 0){
					summaryVO.get(i).setTtlCnt(rtnSummaryVOs.get(0).getTtlCnt());
					summaryVO.get(i).setOnTmCnt(rtnSummaryVOs.get(0).getOnTmCnt());
					summaryVO.get(i).setOnTmRt(rtnSummaryVOs.get(0).getOnTmRt());
					summaryVO.get(i).setEotpCnt(rtnSummaryVOs.get(0).getEotpCnt());
					summaryVO.get(i).setEotpRt01(rtnSummaryVOs.get(0).getEotpRt01());
					summaryVO.get(i).setEotpRt02(rtnSummaryVOs.get(0).getEotpRt02());
				}
			}
			
			returnVO.setPfSkdEotpSummaryVOs(summaryVO);
			
			PfSkdEotpSumVO paramVO = new PfSkdEotpSumVO();
			
			paramVO.setBfPortCd		(vskPfSkdDtlVOs.get(0).getPortCd());
			paramVO.setToPortCd		(vskPfSkdDtlVOs.get(0+1).getPortCd());
			paramVO.setIbIpcgoQty	(vskPfSkdDtlVOs.get(0).getIbIpcgoQty());
			paramVO.setObIpcgoQty	(vskPfSkdDtlVOs.get(0).getObIpcgoQty());
			paramVO.setIbOcnCgoQty	(vskPfSkdDtlVOs.get(0).getIbOcnCgoQty());
			paramVO.setObOcnCgoQty	(vskPfSkdDtlVOs.get(0).getObOcnCgoQty());
			paramVO.setTmlProdQty	(vskPfSkdDtlVOs.get(0).getTmlProdQty());
			paramVO.setPortBufHrs	(vskPfSkdDtlVOs.get(0).getPortBufHrs());
			paramVO.setLnkDist		(vskPfSkdDtlVOs.get(0).getLnkDist());
			paramVO.setLnkSpd		(vskPfSkdDtlVOs.get(0).getLnkSpd());
			paramVO.setSeaBufHrs	(vskPfSkdDtlVOs.get(0).getSeaBufHrs());
			paramVO.setActWrkHrs	(vskPfSkdDtlVOs.get(0).getActWrkHrs());
			
			paramVO.setHistYr		(vskPfSkdVO.getPfSkdRmk());
			paramVO.setN1stVslClssCd(vskPfSkdVO.getN1stVslClssCd());
			paramVO.setN2ndVslClssCd(vskPfSkdVO.getN2ndVslClssCd());
			paramVO.setN3rdVslClssCd(vskPfSkdVO.getN3rdVslClssCd());			
			
			List<PfSkdEotpDtlVO> rtnDetailVOs = dbDao.searchPfSkdEotpDtl(paramVO);
			
			if(rtnDetailVOs != null && rtnDetailVOs.size() > 0){
				for(int i=0; i<rtnDetailVOs.size(); i++){
					PfSkdEotpDtlVO tempDetailVO = new PfSkdEotpDtlVO();
										
					tempDetailVO.setOnTm		(rtnDetailVOs.get(i).getOnTm());
					tempDetailVO.setOnTmYn		(rtnDetailVOs.get(i).getOnTmYn());

					tempDetailVO.setVslClass	(rtnDetailVOs.get(i).getVslClass());
					tempDetailVO.setVvd			(rtnDetailVOs.get(i).getVvd());

					tempDetailVO.setOldPortTm	(rtnDetailVOs.get(i).getOldPortTm());
					tempDetailVO.setNewPortTm	(rtnDetailVOs.get(i).getNewPortTm());
					tempDetailVO.setNewPortBufTm(rtnDetailVOs.get(i).getNewPortBufTm());

					tempDetailVO.setNewSeaTm1	(rtnDetailVOs.get(i).getNewSeaTm1());
					tempDetailVO.setNewSeaBufTm	(rtnDetailVOs.get(i).getNewSeaBufTm());
					tempDetailVO.setActSailTm	(rtnDetailVOs.get(i).getActSailTm());

					tempDetailVO.setLnkDist		(rtnDetailVOs.get(i).getLnkDist());
					tempDetailVO.setMaxSpd		(rtnDetailVOs.get(i).getMaxSpd());
					tempDetailVO.setActSpd		(rtnDetailVOs.get(i).getActSpd());

					tempDetailVO.setRecoveryTm	(rtnDetailVOs.get(i).getRecoveryTm());

					tempDetailVO.setChkEotp01	(rtnDetailVOs.get(i).getChkEotp01());
					tempDetailVO.setEotp01		(rtnDetailVOs.get(i).getEotp01());
					tempDetailVO.setChkEotp02	(rtnDetailVOs.get(i).getChkEotp02());
					tempDetailVO.setEotp02		(rtnDetailVOs.get(i).getEotp02());
					
					detailVO.add(i, tempDetailVO);
				}
				
				returnVO.setPfSkdEotpDetailVOs(detailVO);
			}
			
			return returnVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	/**
	 * EOTP Creation의 정보를 조회한다.<br>
	 *  EOTP Creation화면에 대한 Detail조회 이벤트 처리<br>
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @return PfSkdEotpGRPVO
	 * @exception EventException
	 */
	public PfSkdEotpGRPVO searchPfSkdEotpDtl(PfSkdGRPVO pfSkdGRPVO) throws EventException {
		try {

			PfSkdEotpGRPVO returnVO = new PfSkdEotpGRPVO();
			List<PfSkdEotpDtlVO> detailVO = new ArrayList<PfSkdEotpDtlVO>();
			
			VskPfSkdVO vskPfSkdVO = pfSkdGRPVO.getVskPfSkdVO();
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = pfSkdGRPVO.getVskPfSkdDtlVOs();

			int cnt = vskPfSkdDtlVOs.size();
			int rowPos = Integer.parseInt(vskPfSkdVO.getPagerows());
			String tempPostCd = vskPfSkdVO.getCreUsrId();
			int bfPortCdPos = 0;
			int toPortCdPos = 0;

			for(int i=0; i<cnt; i++){
				String pfSkdPortCd = vskPfSkdDtlVOs.get(i).getPortCd();

				if(rowPos == i){
					if(tempPostCd.equals(pfSkdPortCd)){
						bfPortCdPos = i;
					}
				}
			}
			
			if(bfPortCdPos == cnt -1){
				toPortCdPos = 0;
			}else{
				toPortCdPos = bfPortCdPos + 1;
			}

			PfSkdEotpSumVO paramVO = new PfSkdEotpSumVO();
			paramVO.setBfPortCd			(vskPfSkdDtlVOs.get(bfPortCdPos).getPortCd());
			paramVO.setToPortCd			(vskPfSkdDtlVOs.get(toPortCdPos).getPortCd());
			paramVO.setIbIpcgoQty		(vskPfSkdDtlVOs.get(bfPortCdPos).getIbIpcgoQty());
			paramVO.setObIpcgoQty		(vskPfSkdDtlVOs.get(bfPortCdPos).getObIpcgoQty());
			paramVO.setIbOcnCgoQty		(vskPfSkdDtlVOs.get(bfPortCdPos).getIbOcnCgoQty());
			paramVO.setObOcnCgoQty		(vskPfSkdDtlVOs.get(bfPortCdPos).getObOcnCgoQty());
			paramVO.setTmlProdQty		(vskPfSkdDtlVOs.get(bfPortCdPos).getTmlProdQty());
			paramVO.setPortBufHrs		(vskPfSkdDtlVOs.get(bfPortCdPos).getPortBufHrs());
			paramVO.setLnkDist			(vskPfSkdDtlVOs.get(bfPortCdPos).getLnkDist());
			paramVO.setLnkSpd			(vskPfSkdDtlVOs.get(bfPortCdPos).getLnkSpd());
			paramVO.setSeaBufHrs		(vskPfSkdDtlVOs.get(bfPortCdPos).getSeaBufHrs());
			paramVO.setActWrkHrs		(vskPfSkdDtlVOs.get(bfPortCdPos).getActWrkHrs());
			paramVO.setHistYr			(vskPfSkdVO.getPfSkdRmk());
			paramVO.setN1stVslClssCd	(vskPfSkdVO.getN1stVslClssCd());
			paramVO.setN2ndVslClssCd	(vskPfSkdVO.getN2ndVslClssCd());
			paramVO.setN3rdVslClssCd	(vskPfSkdVO.getN3rdVslClssCd());
			
			List<PfSkdEotpDtlVO> rtnDetailVOs = dbDao.searchPfSkdEotpDtl(paramVO);
			
			if(rtnDetailVOs != null && rtnDetailVOs.size() > 0){
				for(int i=0; i<rtnDetailVOs.size(); i++){
					PfSkdEotpDtlVO tempDetailVO = new PfSkdEotpDtlVO();
					
					tempDetailVO.setOnTm		(rtnDetailVOs.get(i).getOnTm());
					tempDetailVO.setOnTmYn		(rtnDetailVOs.get(i).getOnTmYn());

					tempDetailVO.setVslClass	(rtnDetailVOs.get(i).getVslClass());
					tempDetailVO.setVvd			(rtnDetailVOs.get(i).getVvd());

					tempDetailVO.setOldPortTm	(rtnDetailVOs.get(i).getOldPortTm());
					tempDetailVO.setNewPortTm	(rtnDetailVOs.get(i).getNewPortTm());
					tempDetailVO.setNewPortBufTm(rtnDetailVOs.get(i).getNewPortBufTm());

					tempDetailVO.setNewSeaTm1	(rtnDetailVOs.get(i).getNewSeaTm1());
					tempDetailVO.setNewSeaBufTm	(rtnDetailVOs.get(i).getNewSeaBufTm());
					tempDetailVO.setActSailTm	(rtnDetailVOs.get(i).getActSailTm());

					tempDetailVO.setLnkDist		(rtnDetailVOs.get(i).getLnkDist());
					tempDetailVO.setMaxSpd		(rtnDetailVOs.get(i).getMaxSpd());
					tempDetailVO.setActSpd		(rtnDetailVOs.get(i).getActSpd());

					tempDetailVO.setRecoveryTm	(rtnDetailVOs.get(i).getRecoveryTm());

					tempDetailVO.setChkEotp01	(rtnDetailVOs.get(i).getChkEotp01());
					tempDetailVO.setEotp01		(rtnDetailVOs.get(i).getEotp01());
					tempDetailVO.setChkEotp02	(rtnDetailVOs.get(i).getChkEotp02());
					tempDetailVO.setEotp02		(rtnDetailVOs.get(i).getEotp02());
					
					detailVO.add(i, tempDetailVO);
				}
				
				returnVO.setPfSkdEotpDetailVOs(detailVO);
			}
			return returnVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
}