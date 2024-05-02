/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtBCImpl.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.30 서창열
* 1.0 Creation
* 
* History
* 2010.10.05 유혁 CHM-201006264-01 Session User ID 설정로직 변경
* 2011.07.07 진마리아 CHM-201111838-01 Split 21-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
* 2015.07.20 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration.ProformaScheduleMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.BunkerCostVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.HireBaseVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdBerthWdoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpSumVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdHisGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdRequestVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PortExpenseVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdHisVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasSimInfoVO;
import com.hanjin.syscommon.common.table.MasSimTmlInfoVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskPfCallPortVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;
import com.hanjin.syscommon.common.table.VskSltPrcDtlVO;
import com.hanjin.syscommon.common.table.VskSltPrcPortDtlVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;
 

/**
 * NIS2010-SchedulePlanningOperation Business Logic Basic Command implementation<br>
 * - NIS2010-SchedulePlanningOperation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SEO CHANG YUL
 * @see UI_VSK-0241EventResponse,ProformaScheduleMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ProformaScheduleMgtBCImpl extends BasicCommandSupport implements ProformaScheduleMgtBC {

	// Database Access Object
	private transient ProformaScheduleMgtDBDAO dbDao = null;

	/**
	 * ProformaScheduleMgtBCImpl 객체 생성<br>
	 * ProformaScheduleMgtDBDAO를 생성한다.<br>
	 */
	public ProformaScheduleMgtBCImpl() {
		dbDao = new ProformaScheduleMgtDBDAO();
	}
	/**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param PfSkdTypeHelpVO pfSkdTypeHelpVO
	 * @return List<PfSkdTypeHelpVO>
	 * @exception EventException
	 */
	public List<PfSkdTypeHelpVO> searchPfTpHelp(PfSkdTypeHelpVO pfSkdTypeHelpVO) throws EventException {
		try {
			return dbDao.searchPfTpHelp(pfSkdTypeHelpVO);
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
	 * 등록된 Proforma SKD 정보를 조회한다.
	 * 
	 * @param VskPfSkdHisVO vskPfSkdHisVO
	 * @return PfSkdHisGRPVO
	 * @exception EventException
	 */
	public PfSkdHisGRPVO searchPfSkdHis(VskPfSkdHisVO vskPfSkdHisVO) throws EventException {
		PfSkdHisGRPVO grpVO = new PfSkdHisGRPVO();
		try {
			
			List<VskPfSkdHisVO> vskPfSkdHisVOs = dbDao.searchPfSkdHis(vskPfSkdHisVO);
			//2009 11 26 수정요청 - Lim VVD까지 보여 달라 요청
			List<VskVslSkdVO> vskVslSkdVOs = dbDao.searchVslSkdByPfSkd(vskPfSkdHisVO);
			
			grpVO.setVskPfSkdHisVOs(vskPfSkdHisVOs);
			grpVO.setVskVslSkdVOs(vskVslSkdVOs);
			
			return grpVO;
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
	 * 등록된 Proforma SKD 정보를 조회한다.
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
	 * 등록된 Proforma SKD 정보를 조회한다.
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
	 * 등록된 Proforma SKD 정보를 조회한다.
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
				if(!"EGSUZ".equals(vskPfSkdDtlVOs.get(i).getPortCd()) || !"PAPAC".equals(vskPfSkdDtlVOs.get(i).getPortCd())){
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
	 * P/F SKD Settlement 정보를 조회한다.<br>
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
				
				//2009 09 30 임창빈 수석 수정요청 : 
				//Maximum Speed,P/F Speed,Speed (Incl. buffer),Total Buffer Ratio,Sea buffer Ratio,Port buffer Ratio,P/F Speed Ratio,Buffer Speed Ratio
				//기존의 쿼리에서 계산되어서 가져오는 방법에서  화면에 마지막 로우의 숨긴 데이타를 빼고 계산한다
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
				
				//마지막 로우는 계산에서 제한다
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
				//Manu In은  마지막 로우는 보여준다
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
			
			//2009 12 30 임창빈 수석 요청
			//L/F,RPB,G.REV,OP 데이타를 조회한다
//			List<CoaSimRsltVO> coaSimRsltVOs = dbDao.searchCoaSimRslt(pfSkdRequestVO);
//			CoaSimRsltVO coaSimRsltVO =  new CoaSimRsltVO();
//			
//			if(coaSimRsltVOs != null && coaSimRsltVOs.size() > 0){
//				coaSimRsltVO.setTot(coaSimRsltVOs.get(0).getTot());
//				coaSimRsltVO.setLf(coaSimRsltVOs.get(0).getLf());
//				coaSimRsltVO.setRpb(coaSimRsltVOs.get(0).getRpb());
//				coaSimRsltVO.setRev(coaSimRsltVOs.get(0).getRev());
//				coaSimRsltVO.setOp(coaSimRsltVOs.get(0).getOp());
//			}
			
			grpVO.setVskPfSkdVO(vskPfSkdVO);
			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
//			grpVO.setCoaSimRsltVO(coaSimRsltVO);
			
			return grpVO;
			
			
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였을 경우
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/*
	 * CHM-201006264-01 Session User ID 설정로직 변경 getCre_Usr_id() -> getUsr_id()
	 */
	/**
	 * P/F SKD Settlement의 Settlement을 저장한다.<br>
	 * 
	 * @param PfSkdGRPVO pfSkdGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmSimScnr(PfSkdGRPVO pfSkdGRPVO, SignOnUserAccount account) throws EventException{
		try {
			VskPfSkdVO vskPfSkdVO = pfSkdGRPVO.getVskPfSkdVO();
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = pfSkdGRPVO.getVskPfSkdDtlVOs();

			String tempVslLlanCd 	= vskPfSkdVO.getVslSlanCd();
			String tempPfSvcTpCd 	= vskPfSkdVO.getPfSvcTpCd();
			String firstDirCd 		= vskPfSkdDtlVOs.get(0).getSkdDirCd();
			String pfSkdStsCd 		= vskPfSkdDtlVOs.get(0).getPfSkdStsCd();
			//String uiEvent = vskPfSkdDtlVOs.get(0).getUiEvent();
			String eventname = pfSkdGRPVO.getVskPfSkdDtlVOs().get(0).getUiEvent();
		
			// 입력된 Yard Code가 MDM_YARD에 등록되여 있는지 확인한다.
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
			
			//Settlement : 0001 => COA의 데이타를  조회한다
			//Creation : 0003 => 기존의  Trunk만 Creation 하던 업무에서 Feeder도 같이 오퍼레이션한다
			//Feeder : 0053 => Feeder만 오퍼레이션한다
			//이 세가지 업무를 여기서 같이 Save 하므로 해당 Lane의 서비스 타입 업무를 조회후 
			//Trunker와 Feeder의 저장 오퍼레이션을 나눈다
			
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
			
			//Trunker일때만 체크한다
			int checkPfSkdCnt = dbDao.checkPfSkd(tempVslLlanCd,tempPfSvcTpCd);
			int checkVskSkdCnt = 0;
			
			
			
			if("O".equals(vslSvcTpCdVal)|| eventname.equals("0053")){
				//Feeder일 경우
				checkVskSkdCnt = 0;
			}else{
				//pf_skd에 대한 중복 체크를 한다
				//Trunk일 경우
				
				checkVskSkdCnt = dbDao.checkVslSkdByPfSkd(tempVslLlanCd,tempPfSvcTpCd);
			}
			
			
			
			
			String[] dirCdArr = null;
			
			//[Proform Scedule이 있을 경우, Vessl Schedule에서 사용할 경우] 
			//입력 된 Class 정보 화 조회한 Class 정보가 다르면 Exception
			//같으면 Master Data의 Vsl Class,laneCd,PfType외에 화면에 있는 항목을 업테이트 한다
			if(checkPfSkdCnt > 0 && checkVskSkdCnt > 0  ){
				String inputN1VslCd = vskPfSkdVO.getN1stVslClssCd();
				String searchN1VslCd = null;
				if (checkVskPfSkdVOs != null) {
					searchN1VslCd = checkVskPfSkdVOs.get(0).getN1stVslClssCd();
				}
				String inputN2VslCd = vskPfSkdVO.getN2ndVslClssCd();
				String searchN2VslCd = null;
				if (checkVskPfSkdVOs != null) {
					searchN2VslCd = checkVskPfSkdVOs.get(0).getN2ndVslClssCd();
				}
				String inputN3VslCd = vskPfSkdVO.getN3rdVslClssCd();
				String searchN3VslCd = null;
				if (checkVskPfSkdVOs != null) {
					searchN3VslCd = checkVskPfSkdVOs.get(0).getN3rdVslClssCd();
				}
				
				if(inputN1VslCd.equals(searchN1VslCd) &&
				   inputN2VslCd.equals(searchN2VslCd) &&
				   inputN3VslCd.equals(searchN3VslCd)){
					
					vskPfSkdVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyVskPfSkdMstInfo(vskPfSkdVO);
				}else{
					throw new EventException(new ErrorHandler("VSK10034").getMessage());
				}
			}else{
				//Dirction에 대한 체크를 한다
				//E => W,W => E
				int firstPos = 0;
				int secondPos = 0;
				int checkDirCd = 0;
				dirCdArr = new String[2];
				dirCdArr[0] = firstDirCd;
				
				if (vskPfSkdDtlVOs != null) {
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
				
				// 2009 09 23 임창빈수석 - 고객 김기원 과장 요청
				//Trunk / Feeder 간  Direction Check 로직을 구분함
				// 1.Trunk 일 경우 모두 첵크함
				// 2.Feeder일 경우
				// 2-1 : 입력된  Direction Code 갯수가 1개일 경우.
				// 		2-1-2 : 해당 Lane Direction Sequence 확인을 필요가 없음.(단방향일 경우 )
				// 2-2 : 입력된  Direction Code 갯수가 2개일 경우.
				//		 2-2-2 : 해당 Lane Direction Sequence 확인을 필요가 함.(양방향일 경우 )
				
				//Feeder일 경우
				//Trunk이지만 FDR_DIV_CD가 'O'인 경우
				if("O".equals(vslSvcTpCdVal) ||eventname.equals("0053")||
						(!"O".equals(vslSvcTpCdVal) && "O".equals(fdrDivCd))){
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
					
				//Trunk일 경우	
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
				
				// 2010.01.28 임창빈
				// Vsk_VSL_PORT_SKD 테이블에 NOT NULL 컬럼 초기화 작업 시작..
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
				// VSK_VSL_PORT_SKD 테이블에 NOT NULL 컬럼 초기화 작업 종료..
				
				vskPfSkdVO.setCreUsrId(account.getUsr_id());
				vskPfSkdVO.setUpdUsrId(account.getUsr_id());
				
				if( eventname.equals("0053") && !"O".equals(vslSvcTpCdVal)){
					int vslcnt = Integer.parseInt(vskPfSkdVO.getSvcDurDys());
					vskPfSkdVO.setN1stVslClssKnt(Integer.toString(vslcnt/7));
					vskPfSkdVO.setBrthItvalDys("7");
				}
				
				if(checkPfSkdCnt == 0){
					//2009 12 15 임창빈수석 요청
					//0053에서 조회를 하지 않고 입력을 했을 경우
					//해당하는 필드의 데이타가 생성되지 않음
					dbDao.addVskPfSkd(vskPfSkdVO);
				}else{
					dbDao.modifyVskPfSkd(vskPfSkdVO);
					//VSK_PF_SKD_DTL 테이블을 삭제한다
					//우리는 업데이트시 Detail 정보를 삭제하고 신규생성한다
					dbDao.removeVskPfSkdDtl(tempVslLlanCd,tempPfSvcTpCd);
				}
				
				int firstSkdDirPos = 0;
				String firstSkdDirCd = "";
				String[] skdDirCdArr = new String[2];
				skdDirCdArr[0] = firstSkdDirCd;
				int secondSkdDirPos = 0;
				
				if (vskPfSkdDtlVOs != null) {
					//단방향이면 false, 양방향이면 true;
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
					
					/** Remove logic of setting first port to turning port */
					//::2014-05-09:://vskPfSkdDtlVOs.get(firstSkdDirPos).setTurnPortFlg	("Y");
					vskPfSkdDtlVOs.get(firstSkdDirPos).setTurnPortIndCd	("N");
					
					//2009 12 11 임창빈수석 요청
					//Direction이 바뀌더라도 TurnPortFlg,TurnPortIndCd를 Y로 셋팅하지 않음
					//유저가 입력한 포트의 TurnPortFlg,TurnPortIndCd를 Y로 셋팅
					//vskPfSkdDtlVOs.get(secondSkdDirPos).setTurnPortFlg("Y");
					//vskPfSkdDtlVOs.get(secondSkdDirPos).setTurnPortIndCd("Y");
					
					//마지막 로우의 ETD와 DIST,SEA SPEED등 데이타 초기화
					VskPfSkdDtlVO  lastVO = vskPfSkdDtlVOs.get(vskPfSkdDtlVOs.size()-1);
					//첫번째 로우의 Terminal Code를 마지막 로우에 셋팅한다
					lastVO.setTurnPortFlg("N");
					lastVO.setTurnPortIndCd("F");
//					lastVO.setEtdDyNo(Integer.toString(Integer.parseInt(vskPfSkdDtlVOs.get(0).getEtdDyNo()) + Integer.parseInt(lastVO.getEtbDyNo())));
					lastVO.setEtdDyNo(Integer.toString(
					        Integer.parseInt(vskPfSkdDtlVOs.get(0).getEtdDyNo()) 
					        - Integer.parseInt(vskPfSkdDtlVOs.get(0).getEtbDyNo())  
					        + Integer.parseInt(lastVO.getEtbDyNo()))
					        );

					vskPfSkdDtlVOs.set(vskPfSkdDtlVOs.size()-1, lastVO);					
				}
		
				if (vskPfSkdDtlVOs != null) {
					for(int i=0; i<vskPfSkdDtlVOs.size(); i++){
						if(!"D".equals(vskPfSkdDtlVOs.get(i).getIbflag())){
							
							VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOs.get(i);
							int portRotnSeq = i+1; 
							vskPfSkdDtlVO.setPortRotnSeq(Integer.toString(portRotnSeq));
							vskPfSkdDtlVO.setYdCd(vskPfSkdDtlVO.getPortCd()+vskPfSkdDtlVO.getYdCd());
							vskPfSkdDtlVO.setCreUsrId(account.getUsr_id());
							vskPfSkdDtlVO.setUpdUsrId(account.getUsr_id());
							
		
							dbDao.addVskPfSkdDtl(vskPfSkdDtlVO);
						}
					}
				}
			}
			
			//신규입력일때는 히스토를 남기지 않는다
			//Feeder일때는 히스트로를 남기지 않는다
			//2009 11 25 임수석 신규입력일때도 히스토리를 남긴다
			//if(checkPfSkdCnt > 0 && !("O".equals(vslSvcTpCdVal))){
			if(!("O".equals(vslSvcTpCdVal))){
				VskPfSkdHisVO vskPfSkdHisVO = new VskPfSkdHisVO();
				
				vskPfSkdHisVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
				vskPfSkdHisVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
				vskPfSkdHisVO.setSimDt(vskPfSkdVO.getSimDt());
				vskPfSkdHisVO.setSimNo(vskPfSkdVO.getSimNo());			
				vskPfSkdHisVO.setDiffRmk(vskPfSkdVO.getPfSkdRmk());
				//2009 10 12 Lim 수석 화면에서  상태값 관리
				//DECODE(PF_SKD_STS_CD,'A','Settlement','B','Manual Creation','C','Manual Update') AS HISTORY
				// PF_SKD_STS_CD : A => Settlement에서 신규 저장할 경우
				// PF_SKD_STS_CD : B => Creation에서 신규 저장할 경우
				// PF_SKD_STS_CD : C => Creation에서 수정 저장할 경우
				
				// Creation에서 Save 할 경우
				if("B".equals(pfSkdStsCd)){
					//해당하는 Lane_Cd, Pf_Svc_Tp_Cd가  신규저장인지 수정인지
					if(checkPfSkdCnt > 0){
						vskPfSkdHisVO.setPfSkdStsCd("C");
					}else{
						vskPfSkdHisVO.setPfSkdStsCd(pfSkdStsCd);
					}
				}
				//Settlement에서 Save 할 경우
				else{
					vskPfSkdHisVO.setPfSkdStsCd(pfSkdStsCd);
				}
				
				vskPfSkdHisVO.setCreUsrId(account.getUsr_id());
				vskPfSkdHisVO.setUpdUsrId(account.getUsr_id());
				
				//VSK_PF_SKD_HID 이력 테이블에 이력을 남긴다
				dbDao.addVskPfSkdHis(vskPfSkdHisVO);
			}
			
			//마스터 정보(VSK_PF_SKD)를 수정할 경우
			//해당 LANE의 STANDARD FLAG를 N으로 수정하여 저장할 경우 
			//STANDARD FLAG 반드시 필요하므로 searchPfStandardCount 메서드에서 해당 LANE에 대한 PF_TYPE_CD의 STANDARD FLAG를
			//찾아 UPDATE한다 
			int returnCnt = dbDao.searchPfStandardCount(vskPfSkdVO);
			
			if(returnCnt > 1 || returnCnt == 0){
				dbDao.modifyVskPfSkd(vskPfSkdVO,returnCnt);
			}
			
			//dirCdArr[0], dirCdArr[1] 이 같은값, 즉 단방향인 경우는 만들지 않는다.
			//::jskjskjsk::2013-04-03 문자열비교 메소드변경 != >> equals ::dirCdArr[0] != dirCdArr[1]:://
			if(dirCdArr != null && !dirCdArr[0].equals(dirCdArr[1]))
			{
				VskPfCallPortVO vskPfCallPortVO = new VskPfCallPortVO();
				vskPfCallPortVO.setVslSlanCd	(vskPfSkdVO.getVslSlanCd()	);
				vskPfCallPortVO.setPfSvcTpCd	(vskPfSkdVO.getPfSvcTpCd()	);
				// CHM-201006264-01
				// vskPfCallPortVO.setCreUsrId(account.getCre_usr_id());
				vskPfCallPortVO.setCreUsrId		(account.getUsr_id		()	);
				dbDao.removeVskPfCallPort		(vskPfCallPortVO			);
				dbDao.addVskPfCallPort			(vskPfCallPortVO			);
			}
			
			//신규추가
			//modifyCoaSimSts(simDt , simNo , simStsCd);
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
					String etbDyNo 		= rtnDetailVOs.get(i).getEtbDyNo();
					String etbDyCd 		= rtnDetailVOs.get(i).getEtbDyCd();
					String etbTmHrmnt 	= rtnDetailVOs.get(i).getEtbTmHrmnt();
					String etbPortCd 	= rtnDetailVOs.get(i).getPortCd();
					
					String n1ActWrkHrs 	= rtnDetailVOs.get(i).getActWrkHrs();
					String n1PortBufHrs = rtnDetailVOs.get(i).getPortBufHrs();

					HashMap<String, String> etdParamM = new HashMap<String, String>();
					etdParamM.put("etbDyNo"		, etbDyNo		);
					etdParamM.put("etbDyCd"		, etbDyCd		);
					etdParamM.put("etbTmHrmnt"	, etbTmHrmnt	);
					etdParamM.put("actWrkHrs"	, n1ActWrkHrs	);
					etdParamM.put("portBufHrs"	, n1PortBufHrs	);
					etdParamM.put("portCd"		, etbPortCd		);
					
					HashMap<String, String> valM = calETDTime(etdParamM);
					String calNo 	= (String)valM.get("ratDay");
					String calWeek 	= (String)valM.get("calWeek");
					String ratTm 	= (String)valM.get("ratTm");

					rtnDetailVOs.get(i).setEtdDyNo		(calNo	);
					rtnDetailVOs.get(i).setEtdDyCd		(calWeek);
					rtnDetailVOs.get(i).setEtdTmHrmnt	(ratTm	);
					
					/** Remove logic of setting first port to turning port */
					//::2014-05-09:://rtnDetailVOs.get(i).setTurnPortFlg("Y");
					rtnDetailVOs.get(i).setTurnPortIndCd("N");
					
					//Sea Time 계산
					double dLnkDist 	= Double.parseDouble((rtnDetailVOs.get(i).getLnkDist()));  	//DISTANCE
					double dLnkSpd 		= Double.parseDouble((rtnDetailVOs.get(i).getLnkSpd()));  	//SEA SPEED
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
					double dWorkHurs = Double.parseDouble(rtnDetailVOs.get(i).getActWrkHrs());
					if(0  == Double.compare(dWorkHurs,0)){
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
							bWorkingHur = bigWorkingHur.setScale(0,BigDecimal.ROUND_HALF_UP);	
							rtnDetailVOs.get(i).setActWrkHrs(bWorkingHur.toString());
						}						
					}					
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
					double dWorkHurs = Double.parseDouble(rtnDetailVOs.get(i).getActWrkHrs());
					if(0  == Double.compare(dWorkHurs,0)){
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
							bWorkingHur = bigWorkingHur.setScale(0,BigDecimal.ROUND_HALF_UP);	
							rtnDetailVOs.get(i).setActWrkHrs(bWorkingHur.toString());
						}
					}
					
											
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
			
			/** Remove logic of setting first port to turning port */
			//::2014-05-09:://rtnDetailVOs.get(firstPos).setTurnPortFlg("Y");
			//::2014-05-09:://rtnDetailVOs.get(firstPos).setTurnPortIndCd("Y");
			
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
	 * P/F SKD Settlement Simulation 이벤트 처리<br>
	 * ProformaScheduleMgt의 ETDTime 구하는 메소드 <br>
	 * 
	 * @param HashMap<String, String> paramMap
	 * @return HashMap<String, String>
	 * @exception EventException
	 */
	private HashMap<String, String> calETDTime(HashMap<String, String> paramMap)throws EventException{

		HashMap<String,String> hMap = new HashMap<String,String>();
		float totTm = 0;
		
		StringBuffer sbTempSetbTm	= new StringBuffer();
		
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
			
			//if(tempSetbTm.length() < 2){
			//	tempSetbTm = "0"+tempSetbTm;
			//}
			
			if(tempSetbTm.length() < 2){
				sbTempSetbTm.append("0");
				sbTempSetbTm.append(tempSetbTm);
			}else{
				sbTempSetbTm.append(tempSetbTm);
			}
			
			int ietbTm = Integer.parseInt(tempSetbTm);
			
			// 임시 코드
			// setbTm의 30분 단위 처리 로직 없으므로 추가
			// ":"이나 "."이 왜 필요한지 체크해서 제거 및 관련 소스 변경
			float fEtbMin = 0f;
			String tempSetbMin = setbTm.replace(".", "").replace(":", "").substring(2);
			if("30".equals(tempSetbMin)){
				fEtbMin = 0.5f; 
			}
			
			String tempActWrkHrs = (String)paramMap.get("actWrkHrs");
			tempActWrkHrs = tempActWrkHrs.replace(".3", ".5");
			float fworkTm = Float.parseFloat(tempActWrkHrs);
			String tempPortBufHrs = (String)paramMap.get("portBufHrs");
			tempPortBufHrs = tempPortBufHrs.replace(".3", ".5");
			float fportTm = Float.parseFloat(tempPortBufHrs);
	
			totTm = ietbTm + fworkTm + fportTm + fEtbMin;
			int itotTm = (int)totTm;
			float totSec = totTm - itotTm;
			
			int ratDay = itotTm / 24;
			int ratTm = itotTm % 24;
	
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
	 * P/F SKD Settlement Simulation 이벤트 처리<br>
	 * ProformaScheduleMgt의 calETBTime 구하는 메소드 <br>
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
	
			int ratDay = itotTm / 24;
			int ratTm = itotTm % 24;
							
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
	 * P/F SKD Settlement Simulation 이벤트 처리<br>
	 * ProformaScheduleMgt의 NEXT PORT의 요일을 구하는 메서드 <br>
	 * 
	 * @param HashMap paramMap
	 * @return HashMap
	 * @exception EventException
	 */
	private String getCalWeek(String dyCd, int tmVal, String portCd) throws EventException{
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
			if(tmVal < 0){
				throw new EventException(new ErrorHandler("VSK10041",new String[]{portCd}).getUserMessage());
			}
			nextPos = currPos + tmVal;
			nextPos = nextPos % 7;
			reVal = dayCd[nextPos];
			
			return reVal;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10041").getMessage(), ex);
		}
	}

	/**
	 * P/F SKD Creation AutoSimulation 이벤트 처리<br>
	 * ProformaScheduleMgt의 event에 대한 AutoSimulation 이벤트 처리<br>
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
	
					//command.searchPortPairInfo의 파라미터
					//port_cd = 현재 로우의 port_cd
					//pod_loc_cd = 다음 로우의 port_cd
					
					list = dbDao.searchPortPairInfo(paramVo);
					
					if(list != null && list.size() != 0){
						VskPfSkdDtlVO resultV0 = list.get(0);
				
						//searchPortPairInfo 리턴 값을 셋팅한다
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
					//첫번째 로우 이후의 공식
					//ETB = SEATIME(전차수) + SEA BUFFER(전차수)+(MANU/IN(전차수)+MANU/OUT(전차수))+ZD(현재차수(ZD)-전차수(ZD))+ETD(전차수)
					
					//command.searchPortPairInfo의 파라미터
					//port_cd = 현재 로우의 port_cd
					//pod_loc_cd = 다음 로우의 port_cd
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
						
						//searchPortPairInfo 리턴 값을 셋팅한다
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
	 * Slot Price  정보를 조회한다.<br>
	 *  ProformaScheduleMgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return SlotPriceGRPVO
	 * @exception EventException
	 */
	public SlotPriceGRPVO searchSlotPrice(SlotPriceGRPVO slotPriceGRPVO) throws EventException {
		
		SlotPriceGRPVO rtnGrpVO = new SlotPriceGRPVO();
		
		try {
			SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
			String vslSlanCd = slotPriceVO.getVslSlanCd();
			String pfSvcTpCd = slotPriceVO.getPfSvcTpCd();
			String sltPrcWrkYr = slotPriceVO.getSltPrcWrkYr();
			String bseQtrCd = slotPriceVO.getBseQtrCd();

			//R/Voyage,Sea Time, Maneuvering, Port Time, Service Speed 데이타  ETC_DATA롤 셋팅
			List<PfSkdVO> psSkdVO = searchPfSkd(vslSlanCd,pfSvcTpCd,"","");
			if(psSkdVO == null || psSkdVO.size() == 0){
				throw new EventException(new ErrorHandler("VSK10020").getMessage());
			}else{
				rtnGrpVO.setPfSkdVOs(psSkdVO);
				//Slot Price조회(vsl class, bunker price)
				int  iOldBunkerPirce =  dbDao.searchOldBunkerPrice(slotPriceGRPVO);
				//기생성 Slot Price가 없을 경우 - 신규
				// vsl_classs는 pfskd에서 가져오고 bunker _price는  searchBunkerPriceDaliy에서 가져온다		
				if(iOldBunkerPirce == -1){
					//pf_skd에 vsl_class가 등록되었는지 확인
					
					SlotPriceVO paramVO = new SlotPriceVO();
					paramVO.setVslSlanCd(vslSlanCd);
					paramVO.setPfSvcTpCd(pfSvcTpCd);
					paramVO.setSltPrcWrkYr(sltPrcWrkYr);
					paramVO.setBseQtrCd(bseQtrCd);
					
					//pf_skd의 vsl class가 있으면 파라미터로 셋팅하고
					//없으면 searchVslClssByVskd 찾은 vsl_class로 파리미터를 사용한다
					if("".equals(psSkdVO.get(0).getN1stVslClssCd())
						&& "".equals(psSkdVO.get(0).getN2ndVslClssCd())
						&& "".equals(psSkdVO.get(0).getN3rdVslClssCd())){
						
						//입력받은 분기[기간] 동안에 운항했던 선박에 투입 척수을 조회하고, Vessel Class를 최대 3개를 조회한다.
						List<String> vslCsls = dbDao.searchVslClssByVskd(slotPriceGRPVO);
					    //vsl class가 존재하면 New PortExpense에서 사용하고 pf_skd에도 셋팅하여
						//화면에 보여준다
						if(vslCsls.size() > 0){
							if(vslCsls.size() == 1){
								//psSkdVO.get(0).setN1stVslClssCd(vslCsls.get(0));
								paramVO.setN1stVslClssCd(vslCsls.get(0));
							}else if(vslCsls.size() == 2){
								//psSkdVO.get(0).setN1stVslClssCd(vslCsls.get(0));
								//psSkdVO.get(0).setN2ndVslClssCd(vslCsls.get(1));
								paramVO.setN1stVslClssCd(vslCsls.get(0));
								paramVO.setN2ndVslClssCd(vslCsls.get(1));
							}else{
								//psSkdVO.get(0).setN1stVslClssCd(vslCsls.get(0));
								//psSkdVO.get(0).setN2ndVslClssCd(vslCsls.get(1));
								//psSkdVO.get(0).setN3rdVslClssCd(vslCsls.get(2));
								paramVO.setN1stVslClssCd(vslCsls.get(0));
								paramVO.setN2ndVslClssCd(vslCsls.get(1));
								paramVO.setN3rdVslClssCd(vslCsls.get(2));
							}
						}else{
							throw new EventException(new ErrorHandler("VSK10025").getUserMessage());
						}
					}else{
						paramVO.setN1stVslClssCd(psSkdVO.get(0).getN1stVslClssCd());
						paramVO.setN2ndVslClssCd(psSkdVO.get(0).getN2ndVslClssCd());
						paramVO.setN3rdVslClssCd(psSkdVO.get(0).getN3rdVslClssCd());
						paramVO.setN1stVslClssKnt(psSkdVO.get(0).getN1stVslClssKnt());
						paramVO.setN2ndVslClssKnt(psSkdVO.get(0).getN2ndVslClssKnt());
						paramVO.setN3rdVslClssKnt(psSkdVO.get(0).getN3rdVslClssKnt());
						
					}
					paramVO.setEventNav("R");	
					slotPriceGRPVO.setSlotPriceVO(paramVO);
					
					//NEW PORT EXPENSE
					List<PortExpenseVO> rtnNewPortExpenseVOs = dbDao.searchNewPortExpence(slotPriceGRPVO);
					rtnGrpVO.setPortExpenseVOs(rtnNewPortExpenseVOs);
					
					//NEW BUNER PRICE DAILY
					SlotPriceVO rtnNewBunkerPriceVO = new SlotPriceVO();
					int  iBunkerPriceDailly = dbDao.searchBunkerPriceDaliy(slotPriceGRPVO);
					rtnNewBunkerPriceVO.setBnkPrc(Integer.toString(iBunkerPriceDailly));
					//INSERT 와 UPDATE를 상태관리를 위해 
					rtnNewBunkerPriceVO.setEventNav("I");
					rtnNewBunkerPriceVO.setVslSlanCd(vslSlanCd);
					rtnNewBunkerPriceVO.setPfSvcTpCd(pfSvcTpCd);
					rtnNewBunkerPriceVO.setSltPrcWrkYr(sltPrcWrkYr);
					rtnNewBunkerPriceVO.setBseQtrCd(bseQtrCd);
					rtnNewBunkerPriceVO.setN1stVslClssCd(paramVO.getN1stVslClssCd());
					rtnNewBunkerPriceVO.setN1stVslClssKnt(paramVO.getN1stVslClssKnt());
					rtnNewBunkerPriceVO.setN2ndVslClssCd(paramVO.getN2ndVslClssCd());
					rtnNewBunkerPriceVO.setN2ndVslClssKnt(paramVO.getN2ndVslClssKnt());
					rtnNewBunkerPriceVO.setN3rdVslClssCd(paramVO.getN3rdVslClssCd());
					rtnNewBunkerPriceVO.setN3rdVslClssKnt(paramVO.getN3rdVslClssKnt());
					rtnGrpVO.setSlotPriceVO(rtnNewBunkerPriceVO);
					
					//NEW BUNKER COST
					int iSltPrcWrkYr = Integer.parseInt(sltPrcWrkYr) - 1;
					String pastSltPrcWrkYr =  Integer.toString(iSltPrcWrkYr);
					paramVO.setVpsEtaFmDt(pastSltPrcWrkYr+"0101");
					paramVO.setVpsEtaToDt(pastSltPrcWrkYr+"1231");
					paramVO.setBnkPrc(Integer.toString(iBunkerPriceDailly));
					slotPriceGRPVO.setSlotPriceVO(paramVO);
					
					//NEW HIRE BASE
					List<HireBaseVO> rtnNewHireBaseVO = dbDao.searchNewHireBase(slotPriceGRPVO);

					//Hire Base의 Declared Capacity의 값을 가져와서 
					//Hire/Teu(Owner) 와 Hire/Teu(Charter)을 곱해서
					//OWNR_HIR_TTL_AMT,CHRG_HIR_TTL_AMT의 값을 셋팅한다
					double declaredCata1 = 0;
					double declaredCata2 = 0;
					double declaredCata3 = 0;
					double hireTeuOwner1 = 0;
					double hireTeuOwner2 = 0;
					double hireTeuOwner3 = 0;
					double hireTeuCharter1 = 0;
					double hireTeuCharter2 = 0;
					double hireTeuCharter3 = 0;
					double ownrHirTtlAmt1 = 0;
					double ownrHirTtlAmt2 = 0;
					double ownrHirTtlAmt3 = 0;
					double chrgHirTtlAmt1 = 0;
					double chrgHirTtlAmt2 = 0;
					double chrgHirTtlAmt3 = 0;
					if(VSKGeneralUtil.isNotNull(rtnNewHireBaseVO.get(0).getVslCsl1())){
						declaredCata1 = Double.parseDouble(rtnNewHireBaseVO.get(0).getVslCsl1());
					}
					if(VSKGeneralUtil.isNotNull(rtnNewHireBaseVO.get(0).getVslCsl2())){
						declaredCata2 = Double.parseDouble(rtnNewHireBaseVO.get(0).getVslCsl2());
						if(0 == Double.compare(declaredCata2,0)){
							rtnNewHireBaseVO.get(0).setVslCsl2("");
						}
					}
					
					if(VSKGeneralUtil.isNotNull(rtnNewHireBaseVO.get(0).getVslCsl3())){
						declaredCata3 = Double.parseDouble(rtnNewHireBaseVO.get(0).getVslCsl3());
						if(0 == Double.compare(declaredCata3,0)){
							rtnNewHireBaseVO.get(0).setVslCsl3("");
						}
					}
					if(VSKGeneralUtil.isNotNull(rtnNewHireBaseVO.get(1).getVslCsl1())){
						hireTeuOwner1 = Double.parseDouble(rtnNewHireBaseVO.get(1).getVslCsl1());
					}
					if(VSKGeneralUtil.isNotNull(rtnNewHireBaseVO.get(1).getVslCsl2())){
						hireTeuOwner2 = Double.parseDouble(rtnNewHireBaseVO.get(1).getVslCsl2());
					}
					if(VSKGeneralUtil.isNotNull(rtnNewHireBaseVO.get(1).getVslCsl3())){
						hireTeuOwner3 = Double.parseDouble(rtnNewHireBaseVO.get(1).getVslCsl3());
					}
					if(VSKGeneralUtil.isNotNull(rtnNewHireBaseVO.get(2).getVslCsl1())){
						hireTeuCharter1 = Double.parseDouble(rtnNewHireBaseVO.get(2).getVslCsl1());
					}
					if(VSKGeneralUtil.isNotNull(rtnNewHireBaseVO.get(2).getVslCsl2())){
						hireTeuCharter2 = Double.parseDouble(rtnNewHireBaseVO.get(2).getVslCsl2());
					}
					if(VSKGeneralUtil.isNotNull(rtnNewHireBaseVO.get(2).getVslCsl3())){
						hireTeuCharter3 = Double.parseDouble(rtnNewHireBaseVO.get(2).getVslCsl3());
					}

					HireBaseVO ownrHirTtlAmtVO = new HireBaseVO();
					HireBaseVO chrgHirTtlAmtVO = new HireBaseVO();
					BigDecimal bOwnrHirTtlAmt1 = null;
					BigDecimal bOwnrHirTtlAmt2 = null;
					BigDecimal bOwnrHirTtlAmt3 = null;
					BigDecimal bchrgHirTtlAmt1 = null;
					BigDecimal bchrgHirTtlAmt2 = null;
					BigDecimal bchrgHirTtlAmt3 = null;
					if( 0 < Double.compare(declaredCata1,0) && 0 < Double.compare(hireTeuOwner1,0)){
						ownrHirTtlAmt1 = declaredCata1 * hireTeuOwner1;
						BigDecimal  bigOwnrHirTtlAmt1 = new BigDecimal(ownrHirTtlAmt1);
						bOwnrHirTtlAmt1 = bigOwnrHirTtlAmt1.setScale(1,BigDecimal.ROUND_HALF_UP);
						ownrHirTtlAmtVO.setVslCsl1(bOwnrHirTtlAmt1.toString());
					}
					
					if( 0 < Double.compare(declaredCata2,0) && 0 < Double.compare(hireTeuOwner2,0)){
						ownrHirTtlAmt2 = declaredCata2 * hireTeuOwner2;
						BigDecimal  bigOwnrHirTtlAmt2 = new BigDecimal(ownrHirTtlAmt2);
						bOwnrHirTtlAmt2 = bigOwnrHirTtlAmt2.setScale(1,BigDecimal.ROUND_HALF_UP);
						ownrHirTtlAmtVO.setVslCsl2(bOwnrHirTtlAmt2.toString());
					}
					
					if( 0 < Double.compare(declaredCata3,0) && 0 < Double.compare(hireTeuOwner3,0)){
						ownrHirTtlAmt3 = declaredCata3 * hireTeuOwner3;
						BigDecimal  bigOwnrHirTtlAmt3 = new BigDecimal(ownrHirTtlAmt3);
						bOwnrHirTtlAmt3 = bigOwnrHirTtlAmt3.setScale(1,BigDecimal.ROUND_HALF_UP);
						ownrHirTtlAmtVO.setVslCsl3(bOwnrHirTtlAmt3.toString());
					}
					
					rtnNewHireBaseVO.add(3, ownrHirTtlAmtVO);
					
					if( 0 < Double.compare(declaredCata1,0) && 0 < Double.compare(hireTeuCharter1,0)){
						chrgHirTtlAmt1 = declaredCata1 * hireTeuCharter1;
						BigDecimal  bigChrgHirTtlAmt1 = new BigDecimal(chrgHirTtlAmt1);
						bchrgHirTtlAmt1 = bigChrgHirTtlAmt1.setScale(1,BigDecimal.ROUND_HALF_UP);
						chrgHirTtlAmtVO.setVslCsl1(bchrgHirTtlAmt1.toString());
					}
					
					if( 0 < Double.compare(declaredCata2,0) && 0 < Double.compare(hireTeuCharter2,0)){
						chrgHirTtlAmt2 = declaredCata2 * hireTeuCharter2;
						BigDecimal  bigChrgHirTtlAmt2 = new BigDecimal(chrgHirTtlAmt2);
						bchrgHirTtlAmt2 = bigChrgHirTtlAmt2.setScale(1,BigDecimal.ROUND_HALF_UP);
						chrgHirTtlAmtVO.setVslCsl2(bchrgHirTtlAmt2.toString());
					}
					
					if( 0 < Double.compare(declaredCata3,0) && 0 < Double.compare(hireTeuCharter3,0)){
						chrgHirTtlAmt3 = declaredCata3 * hireTeuCharter3;
						BigDecimal  bigChrgHirTtlAmt3 = new BigDecimal(chrgHirTtlAmt3);
						bchrgHirTtlAmt3 = bigChrgHirTtlAmt3.setScale(1,BigDecimal.ROUND_HALF_UP);
						chrgHirTtlAmtVO.setVslCsl3(bchrgHirTtlAmt3.toString());
					}
					
					rtnNewHireBaseVO.add(4, chrgHirTtlAmtVO);					
					rtnGrpVO.setHireBaseVOs(rtnNewHireBaseVO);
					
					
					//vsl_class 1번째 SUB TOTAL
					//Port Expense의 Total Port Cost + Bunker Cost의 Total Bunker Charge + Hire Base의 Hire/TEU(Owner,Charter)의 합
					double dVslClsPortTot1 = 0;
					double dVslClsPortTot2 = 0;
					double dVslClsPortTot3 = 0;
					//Port Expense의 Total Port Cost
					if(rtnNewPortExpenseVOs != null && rtnNewPortExpenseVOs.size() > 0){
						for(int k=0; k<rtnNewPortExpenseVOs.size(); k++){
							if(rtnNewPortExpenseVOs.get(k).getVslClass01() != null && !"".equals(rtnNewPortExpenseVOs.get(k).getVslClass01())){
								dVslClsPortTot1 += Double.parseDouble(rtnNewPortExpenseVOs.get(k).getVslClass01());
							}
							if(rtnNewPortExpenseVOs.get(k).getVslClass02() != null && !"".equals(rtnNewPortExpenseVOs.get(k).getVslClass02())){
								dVslClsPortTot2 += Double.parseDouble(rtnNewPortExpenseVOs.get(k).getVslClass02());
							}
							if(rtnNewPortExpenseVOs.get(k).getVslClass03() != null && !"".equals(rtnNewPortExpenseVOs.get(k).getVslClass03())){
								dVslClsPortTot3 += Double.parseDouble(rtnNewPortExpenseVOs.get(k).getVslClass03());
							}
						}
					}
					
					// Bunker Cost의 Total Bunker Charge
					double dVslClsBunkerTot1 = 0;
					double dVslClsBunkerTot2 = 0;
					double dVslClsBunkerTot3 = 0;
					
					//Hire Base
					double dVslClsHirTot1 = 0;  
					double dVslClsHirTot2 = 0;
					double dVslClsHirTot3 = 0;
					double dDeclCapa1 = 0;
					double dDeclCapa2 = 0;
					double dDeclCapa3 = 0;
					int posCnt = 0;
					if(rtnNewHireBaseVO != null && rtnNewHireBaseVO.size() > 0){
						for(int i=0; i<rtnNewHireBaseVO.size(); i++){
							HireBaseVO valueVO = rtnNewHireBaseVO.get(i);
							String ownerFlag = valueVO.getVslOwnrFlg();
							if("Y".equals(ownerFlag)){
								posCnt = i;
							}
						}
						
						if(rtnNewHireBaseVO.get(posCnt).getVslCsl1() != null && !"".equals(rtnNewHireBaseVO.get(posCnt).getVslCsl1())){
							dVslClsHirTot1 = Double.parseDouble(rtnNewHireBaseVO.get(posCnt).getVslCsl1());
							dDeclCapa1 = Double.parseDouble(rtnNewHireBaseVO.get(0).getVslCsl1());
						}
						
						if(rtnNewHireBaseVO.get(posCnt).getVslCsl2() != null && 0 < Double.compare(declaredCata2,0)){
							dVslClsHirTot2 = Double.parseDouble(rtnNewHireBaseVO.get(posCnt).getVslCsl2());
							dDeclCapa2 = Double.parseDouble(rtnNewHireBaseVO.get(1).getVslCsl2());
						}
						
						if(rtnNewHireBaseVO.get(posCnt).getVslCsl3() != null && !"".equals(rtnNewHireBaseVO.get(posCnt).getVslCsl3())){
							dVslClsHirTot3 = Double.parseDouble(rtnNewHireBaseVO.get(posCnt).getVslCsl3());
							dDeclCapa3 = Double.parseDouble(rtnNewHireBaseVO.get(2).getVslCsl3());
						}
					}					
					
					double dSubTotVslCsl1 = dVslClsPortTot1 + dVslClsBunkerTot1 + dVslClsHirTot1;
					double dSubTotVslCsl2 = dVslClsPortTot2 + dVslClsBunkerTot2 + dVslClsHirTot2;
					double dSubTotVslCsl3 = dVslClsPortTot3 + dVslClsBunkerTot3 + dVslClsHirTot3;
					double dSubTot = dSubTotVslCsl1 + dSubTotVslCsl2 + dSubTotVslCsl3;
					int velClsCnt = 0;
					
					//PF_SKD이나 searchVslClssByVskd에서 조회한 VSL_CLS의 갯수를 체크한다
					if(VSKGeneralUtil.isNotNull(paramVO.getN1stVslClssCd()) && !"".equals(paramVO.getN1stVslClssCd())){
						velClsCnt = velClsCnt+1;
					}
					
					if(VSKGeneralUtil.isNotNull(paramVO.getN2ndVslClssCd()) && !"".equals(paramVO.getN2ndVslClssCd())){
						velClsCnt = velClsCnt+1;
					}
					
					if(VSKGeneralUtil.isNotNull(paramVO.getN3rdVslClssCd()) && !"".equals(paramVO.getN3rdVslClssCd())){
						velClsCnt = velClsCnt+1;
					}
					
					//Slot Price 산출
					List<SlotPriceVO> rtnNewSlotPriceVOs = new ArrayList<SlotPriceVO>();
					for(int i=0; i<3; i++){
						SlotPriceVO valueVO = new SlotPriceVO();
						rtnNewSlotPriceVOs.add(i, valueVO);
					}

					BigDecimal bRSubTotVslCls1 = null;
					BigDecimal bSubTotVslCls1 = new BigDecimal(dSubTotVslCsl1);
					bRSubTotVslCls1 = bSubTotVslCls1.setScale(2,BigDecimal.ROUND_HALF_UP);
					rtnNewSlotPriceVOs.get(0).setVslCsl1(bRSubTotVslCls1.toString());
					
					BigDecimal bRSubTotVslCls2 = null;
					BigDecimal bSubTotVslCls2 = new BigDecimal(dSubTotVslCsl2);
					bRSubTotVslCls2 = bSubTotVslCls2.setScale(2,BigDecimal.ROUND_HALF_UP);
					rtnNewSlotPriceVOs.get(0).setVslCsl2(bRSubTotVslCls2.toString());
					
					BigDecimal bRSubTotVslCls3 = null;
					BigDecimal bSubTotVslCls3 = new BigDecimal(dSubTotVslCsl3);
					bRSubTotVslCls3 = bSubTotVslCls3.setScale(2,BigDecimal.ROUND_HALF_UP);
					rtnNewSlotPriceVOs.get(0).setVslCsl3(bRSubTotVslCls3.toString());
					
					if(velClsCnt > 0){
						BigDecimal bRSubTot = null;
						BigDecimal bSubTot = new BigDecimal(dSubTot/velClsCnt);
						bRSubTot = bSubTot.setScale(2,BigDecimal.ROUND_HALF_UP);
						rtnNewSlotPriceVOs.get(0).setSlotSum(bRSubTot.toString());
					}else{
						rtnNewSlotPriceVOs.get(0).setSlotSum("0");
					}
					
					//Slot Price(Round)
					double dSlotRou1 = 0;
					double dSlotRou2 = 0;
					double dSlotRou3 = 0;
					double dSlotTot = 0;
					
					if(0 < Double.compare(dSubTotVslCsl1,0) && 0 < Double.compare(dDeclCapa1,0)){
						dSlotRou1 = dSubTotVslCsl1/dDeclCapa1;
					}
					
					if(0 < Double.compare(dSubTotVslCsl2,0) && 0 < Double.compare(dDeclCapa2,0)){
						dSlotRou2 = dSubTotVslCsl2/dDeclCapa2;
					}
					
					if(0 < Double.compare(dSubTotVslCsl3,0) && 0 < Double.compare(dDeclCapa3,0)){
						dSlotRou3 = dSubTotVslCsl3/dDeclCapa3;
					}
						 
					dSlotTot = dSlotRou1 + dSlotRou2 + dSlotRou3;
					
					BigDecimal bRSlotRou1 = null;
					BigDecimal bSlotRou1 = new BigDecimal(dSlotRou1);
					bRSlotRou1 = bSlotRou1.setScale(2,BigDecimal.ROUND_HALF_UP);
					rtnNewSlotPriceVOs.get(1).setVslCsl1(bRSlotRou1.toString());
					
					BigDecimal bRSlotRou2 = null;
					BigDecimal bSlotRou2 = new BigDecimal(dSlotRou2);
					bRSlotRou2 = bSlotRou2.setScale(2,BigDecimal.ROUND_HALF_UP);
					rtnNewSlotPriceVOs.get(1).setVslCsl2(bRSlotRou2.toString());
					
					BigDecimal bRSlotRou3 = null;
					BigDecimal bSlotRou3 = new BigDecimal(dSlotRou3);
					bRSlotRou3 = bSlotRou3.setScale(2,BigDecimal.ROUND_HALF_UP);
					rtnNewSlotPriceVOs.get(1).setVslCsl3(bRSlotRou3.toString());
					
					if(velClsCnt > 0){
						BigDecimal bRSlotRou = null;
						BigDecimal bSlotRou = new BigDecimal(dSlotTot/velClsCnt);
						bRSlotRou = bSlotRou.setScale(2,BigDecimal.ROUND_HALF_UP);
						rtnNewSlotPriceVOs.get(1).setSlotSum(bRSlotRou.toString());
					}else{
						rtnNewSlotPriceVOs.get(1).setSlotSum("0");
					}
					
					//Slot Price(LEG)
					double dSlotLeg1 = 0; 
					double dSlotLeg2 = 0; 
					double dSlotLeg3 = 0; 
					double dSlotLegTot = 0; 
					if(0 < Double.compare(dSlotRou1,0)){	
						dSlotLeg1 = dSlotRou1/2;
					}
					
					if(0 < Double.compare(dSlotRou2,0)){	
						dSlotLeg2 = dSlotRou2/2;
					}
					
					if(0 < Double.compare(dSlotRou3,0)){	
						dSlotLeg3 = dSlotRou3/2;
					}
					
					dSlotLegTot = dSlotLeg1 + dSlotLeg2 + dSlotLeg3;
					
					BigDecimal bRSlotLeg1 = null;
					BigDecimal bSlotLeg1 = new BigDecimal(dSlotLeg1);
					bRSlotLeg1 = bSlotLeg1.setScale(2,BigDecimal.ROUND_HALF_UP);
					rtnNewSlotPriceVOs.get(2).setVslCsl1(bRSlotLeg1.toString());
					
					BigDecimal bRSlotLeg2 = null;
					BigDecimal bSlotLeg2 = new BigDecimal(dSlotLeg2);
					bRSlotLeg2 = bSlotLeg2.setScale(2,BigDecimal.ROUND_HALF_UP);
					rtnNewSlotPriceVOs.get(2).setVslCsl2(bRSlotLeg2.toString());
					
					BigDecimal bRSlotLeg3 = null;
					BigDecimal bSlotLeg3 = new BigDecimal(dSlotLeg3);
					bRSlotLeg3 = bSlotLeg3.setScale(2,BigDecimal.ROUND_HALF_UP);
					rtnNewSlotPriceVOs.get(2).setVslCsl3(bRSlotLeg3.toString());
					
					if(velClsCnt > 0){
						BigDecimal bRSlotLegTot = null;
						BigDecimal bSlotLegTot = new BigDecimal(dSlotLegTot/velClsCnt);
						bRSlotLegTot = bSlotLegTot.setScale(2,BigDecimal.ROUND_HALF_UP);					
						rtnNewSlotPriceVOs.get(2).setSlotSum(bRSlotLegTot.toString());
					}else{
						rtnNewSlotPriceVOs.get(2).setSlotSum("0");
					}
					
					rtnGrpVO.setSlotPriceVOs(rtnNewSlotPriceVOs);
					

				//기생성 Slot Price가 있을 경우 vsl class는 slot price 테이블의 데이타를 보여준다
				}else{
					//기 등록된 Slot Price 정보를 확인하고, Bunker Price 값을 조회한다.
					SlotPriceVO rtnSlotPriceVO = new SlotPriceVO();
					rtnSlotPriceVO.setBnkPrc(Integer.toString(iOldBunkerPirce));
					//INSERT 와 UPDATE를 상태관리를 위해 
					rtnSlotPriceVO.setEventNav("U");
					rtnSlotPriceVO.setVslSlanCd(vslSlanCd);
					rtnSlotPriceVO.setPfSvcTpCd(pfSvcTpCd);
					rtnSlotPriceVO.setSltPrcWrkYr(sltPrcWrkYr);
					rtnSlotPriceVO.setBseQtrCd(bseQtrCd);
					
					//OLD Bunker Expense를 조회
					List<PortExpenseVO> rtnPortExpenseVOs = dbDao.searchOldPortExpence(slotPriceGRPVO);
					//기 등록된 Slot Price인 경우  Slot Price 테이블에서 데이타를 조회한다
					rtnSlotPriceVO.setN1stVslClssCd(rtnPortExpenseVOs.get(0).getVslClass01());
					rtnSlotPriceVO.setN1stVslClssKnt(rtnPortExpenseVOs.get(0).getClassCnt01());
					rtnSlotPriceVO.setN2ndVslClssCd(rtnPortExpenseVOs.get(0).getVslClass02());
					rtnSlotPriceVO.setN2ndVslClssKnt(rtnPortExpenseVOs.get(0).getClassCnt02());
					rtnSlotPriceVO.setN3rdVslClssCd(rtnPortExpenseVOs.get(0).getVslClass03());
					rtnSlotPriceVO.setN3rdVslClssKnt(rtnPortExpenseVOs.get(0).getClassCnt03());
					rtnGrpVO.setSlotPriceVO(rtnSlotPriceVO);
					rtnGrpVO.setPortExpenseVOs(rtnPortExpenseVOs);
					
					//OLD Bunker Coat를 조회
					List<BunkerCostVO> rtnBunkerCostVOs = dbDao.searchOldBunkerCost(slotPriceGRPVO);
					rtnGrpVO.setBunkerCostVOs(rtnBunkerCostVOs);
					
					//OLD Hire Base를 조회
					List<HireBaseVO> rtnHireBaseVOs = dbDao.searchOldHireBase(slotPriceGRPVO);
					if("Y".equals(rtnHireBaseVOs.get(0).getVslOwnrFlg())){
						for(int i=0; i<rtnHireBaseVOs.size(); i++){
							rtnHireBaseVOs.get(i).setVslOwnrFlg("N");
						}
						rtnHireBaseVOs.get(1).setVslOwnrFlg("Y");
					}else{
						for(int i=0; i<rtnHireBaseVOs.size(); i++){
							rtnHireBaseVOs.get(i).setVslOwnrFlg("N");
						}
						rtnHireBaseVOs.get(2).setVslOwnrFlg("Y");
					}
					rtnGrpVO.setHireBaseVOs(rtnHireBaseVOs);
					
					
					//OLD SLOT PRICE를 조회
					List<SlotPriceVO> rtnSlotPriceVOs = dbDao.searchOldSlotPrice(slotPriceGRPVO);
					rtnGrpVO.setSlotPriceVOs(rtnSlotPriceVOs);
				}
			}
			
			return rtnGrpVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Slot Price  정보를 조회한다.<br>
	 *  ProformaScheduleMgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @return SlotPriceGRPVO
	 * @exception EventException
	 */
	public SlotPriceGRPVO calSlotPrice(SlotPriceGRPVO slotPriceGRPVO) throws EventException {	
			//Return 할 GRPVO
			SlotPriceGRPVO rtnGrpVO = new SlotPriceGRPVO();
		
		try {
			//Master Data
			SlotPriceVO slotPriceVO = slotPriceGRPVO.getSlotPriceVO();
			rtnGrpVO.setSlotPriceVO(slotPriceVO);
			// Port Expense
			List<PortExpenseVO> portExpenseVOs = slotPriceGRPVO.getPortExpenseVOs();
			List<PortExpenseVO> rtnPortExpenseVOs = new ArrayList<PortExpenseVO>();
			//Bunker Cost
			List<BunkerCostVO> bunkerCostVOs = slotPriceGRPVO.getBunkerCostVOs();
			List<BunkerCostVO> rrnBunkerCostVOs = new ArrayList<BunkerCostVO>();
			//Hire Base
			List<HireBaseVO> hisrBaseVOs = slotPriceGRPVO.getHireBaseVOs();
			
			String sltPrcWrkYr = slotPriceVO.getSltPrcWrkYr();
			String bseQtrCd = slotPriceVO.getBseQtrCd();
			String n1stVslClssCd = slotPriceVO.getN1stVslClssCd();
			String n2ndVslClssCd = slotPriceVO.getN2ndVslClssCd();
			String n3rdVslClssCd = slotPriceVO.getN3rdVslClssCd();	
			
			//Port Expense의 GRID를 VESSEL CLASS와 PORT_CD,YD_CD로 재 조회한다 
			for(int i=0; i<portExpenseVOs.size(); i++){
				if(!"D".equals(portExpenseVOs.get(i).getIbflag())){
					PortExpenseVO paramVO = portExpenseVOs.get(i);			
					paramVO.setVslClass01(n1stVslClssCd);
					paramVO.setVslClass02(n2ndVslClssCd);
					paramVO.setVslClass03(n3rdVslClssCd);
					paramVO.setSltPrcWrkYr(sltPrcWrkYr);
					paramVO.setBseQtrCd(bseQtrCd);
					
					List<PortExpenseVO> portExpenseTempVOs = dbDao.searchPortExpenceByClass(paramVO);

					if(portExpenseTempVOs != null && portExpenseTempVOs.size() > 0){
						PortExpenseVO portExpenseTempVO = new PortExpenseVO();
						if(VSKGeneralUtil.isNotNull(portExpenseTempVOs.get(0).getSumClass01())){
							portExpenseTempVO.setSumClass01(portExpenseTempVOs.get(0).getSumClass01());
						}else{
							portExpenseTempVO.setSumClass01("0");
						}
						
						if(VSKGeneralUtil.isNotNull(portExpenseTempVOs.get(0).getSumClass02())){
							portExpenseTempVO.setSumClass02(portExpenseTempVOs.get(0).getSumClass02());
						}else{
							portExpenseTempVO.setSumClass02("0");
						}
						
						if(VSKGeneralUtil.isNotNull(portExpenseTempVOs.get(0).getSumClass03())){
							portExpenseTempVO.setSumClass03(portExpenseTempVOs.get(0).getSumClass03());
						}else{
							portExpenseTempVO.setSumClass03("0");
						}
						
						if(VSKGeneralUtil.isNotNull(portExpenseTempVOs.get(0).getClassAvg())){
							portExpenseTempVO.setClassAvg(portExpenseTempVOs.get(0).getClassAvg());
						}else{
							portExpenseTempVO.setClassAvg("0");
						}
						
						portExpenseTempVO.setPortCd(portExpenseVOs.get(i).getPortCd());
						portExpenseTempVO.setYdCd(portExpenseVOs.get(i).getYdCd());
						portExpenseTempVO.setSkdDirCd(portExpenseVOs.get(i).getSkdDirCd());
						portExpenseTempVO.setClptSeq(portExpenseVOs.get(i).getClptSeq());

						rtnPortExpenseVOs.add(portExpenseTempVO);
					}
				}
			}
			rtnGrpVO.setPortExpenseVOs(rtnPortExpenseVOs);
			
			//화면에 입력한 Sea Time, Maneuvering, Port time의 Days의 데이타로 
			//Bunker Cost의 MFO(Sea), MFO(MAN), MFO(Port), Total MFO, Total Bunker Charge를 Vessel Class별로 계산한다
			double seaDayd = Double.parseDouble(slotPriceVO.getSeaDay());
			double maneDayd = Double.parseDouble(slotPriceVO.getManeDay());
			double portDayd = Double.parseDouble(slotPriceVO.getPortDay());
			double bnkPrcd =  Double.parseDouble(slotPriceVO.getBnkPrc());
			double vslCls1Vald = 0;
			double vslCls2Vald = 0;
			double vslCls3Vald = 0;
			double mfo_sea_cls1d = 0;
			double mfo_sea_cls2d = 0;
			double mfo_sea_cls3d = 0;
			double mfo_man_cls1d = 0;
			double mfo_man_cls2d = 0;
			double mfo_man_cls3d = 0;
			double mfo_port_cls1d = 0;
			double mfo_port_cls2d = 0;
			double mfo_port_cls3d = 0;
			double total_mfo_cls1d = 0;
			double total_mfo_cls2d = 0;
			double total_mfo_cls3d = 0;
			double bunker_charge_cls1d = 0;
			double bunker_charge_cls2d = 0;
			double bunker_charge_cls3d = 0;
			int velClsCnt = 0;
			
			//Calculation 후 계산 된 데이타를 입력한 VO List를 생성한다
			for(int i=0; i<6; i++){
				BunkerCostVO bunkerCostVO = new BunkerCostVO();
				rrnBunkerCostVOs.add(bunkerCostVO);
				
			}

			//첫번째  로우 Daily Com.Bunker 셋팅
			BunkerCostVO firstRow = new BunkerCostVO();
			firstRow.setLeftHeader("Daily Com.Bunker");
			
			//화면에서 넘어온 첫번재 데이타를 담는다
			if(VSKGeneralUtil.isNotNull(n1stVslClssCd) && !"".equals(n1stVslClssCd)){
				firstRow.setVslCsl1(bunkerCostVOs.get(0).getVslCsl1());
				firstRow.setBunkerCoat1(bunkerCostVOs.get(0).getBunkerCoat1());
			}
		
			if(VSKGeneralUtil.isNotNull(n2ndVslClssCd) && !"".equals(n2ndVslClssCd)){
				firstRow.setVslCsl2(bunkerCostVOs.get(0).getVslCsl2());
				firstRow.setBunkerCoat2(bunkerCostVOs.get(0).getBunkerCoat2());
			}
			
			if(VSKGeneralUtil.isNotNull(n3rdVslClssCd) && !"".equals(n3rdVslClssCd)){
				firstRow.setVslCsl3(bunkerCostVOs.get(0).getVslCsl3());
				firstRow.setBunkerCoat2(bunkerCostVOs.get(0).getBunkerCoat3());
			}
			firstRow.setTtlAvg(bunkerCostVOs.get(0).getTtlAvg());
			
			rrnBunkerCostVOs.set(0, firstRow);
			
			
			//첫번재 Vessel Class가 정해지고 Bunker Cost의 첫번재 Vessel Class Daily Com.Bunker 입력한 데이타
			if(VSKGeneralUtil.isNotNull(n1stVslClssCd) && !"".equals(n1stVslClssCd)){
				//첫번재 Vessel Class의 입력 값과 Sea Time의 Days을 계산한다 -> MFO(Sea)
				vslCls1Vald = Double.parseDouble(bunkerCostVOs.get(0).getVslCsl1());
				mfo_sea_cls1d = vslCls1Vald * seaDayd;
				BigDecimal rtn_mfo_sea_cls1big = null;
				BigDecimal mfo_sea_cls1big = new BigDecimal(mfo_sea_cls1d);
				rtn_mfo_sea_cls1big = mfo_sea_cls1big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(1).setVslCsl1(rtn_mfo_sea_cls1big.toString());
				
				//첫번재 Vessel Class의 입력 값과 Maneuvering의 Days을 계산한다 -> MFO(MAN)
				mfo_man_cls1d = vslCls1Vald * maneDayd;
				BigDecimal rtn_mfo_man_cls1big = null;
				BigDecimal mfo_man_cls1big = new BigDecimal(mfo_man_cls1d);
				rtn_mfo_man_cls1big = mfo_man_cls1big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(2).setVslCsl1(rtn_mfo_man_cls1big.toString());
				
				//첫번재 Vessel Class의 입력 값과 Port Time의 Days을 계산한다 -> MFO(Port)
				mfo_port_cls1d = vslCls1Vald * portDayd;
				BigDecimal rtn_mfo_port_cls1big = null;
				BigDecimal mfo_port_cls1big = new BigDecimal(mfo_port_cls1d);
				rtn_mfo_port_cls1big = mfo_port_cls1big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(3).setVslCsl1(rtn_mfo_port_cls1big.toString());
				
				//Total MFO = MFO(Sea)+MFO(MAN)+MFO(Port)
				total_mfo_cls1d = mfo_sea_cls1d+mfo_man_cls1d+mfo_port_cls1d;
				BigDecimal rtn_total_mfo_cls1big = null;
				BigDecimal total_mfo_cls1big = new BigDecimal(total_mfo_cls1d);
				rtn_total_mfo_cls1big = total_mfo_cls1big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(4).setVslCsl1(rtn_total_mfo_cls1big.toString());
				
				//Total Bunker Charge = Total MFO * Bunker /Price
				bunker_charge_cls1d = total_mfo_cls1d * bnkPrcd;
				BigDecimal rtn_bunker_charge_cls1big = null;
				BigDecimal bunker_charge_cls1big = new BigDecimal(bunker_charge_cls1d);
				rtn_bunker_charge_cls1big = bunker_charge_cls1big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(5).setVslCsl1(rtn_bunker_charge_cls1big.toString());
				
				velClsCnt = velClsCnt +1;

			}
			
			//두번재 Vessel Class가 정해지고 Bunker Cost의 두번재 Vessel Class Daily Com.Bunker 입력한 데이타
			if(VSKGeneralUtil.isNotNull(n2ndVslClssCd) && !"".equals(n2ndVslClssCd)){
				//두번재 Vessel Class의 입력 값과 Sea Time의 Days을 계산한다 -> MFO(Sea)
				vslCls2Vald = Double.parseDouble(bunkerCostVOs.get(0).getVslCsl2());
				mfo_sea_cls2d = vslCls2Vald * seaDayd;
				BigDecimal rtn_mfo_sea_cls2big = null;
				BigDecimal mfo_sea_cls2big = new BigDecimal(mfo_sea_cls2d);
				rtn_mfo_sea_cls2big = mfo_sea_cls2big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(1).setVslCsl2(rtn_mfo_sea_cls2big.toString());
				
				//두번재 Vessel Class의 입력 값과 Maneuvering의 Days을 계산한다 -> MFO(MAN)
				mfo_man_cls2d = vslCls2Vald * maneDayd;
				BigDecimal rtn_mfo_man_cls2big = null;
				BigDecimal mfo_man_cls2big = new BigDecimal(mfo_man_cls2d);
				rtn_mfo_man_cls2big = mfo_man_cls2big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(2).setVslCsl2(rtn_mfo_man_cls2big.toString());
				
				//두번재 Vessel Class의 입력 값과 Port Time의 Days을 계산한다 -> MFO(Port)
				mfo_port_cls2d = vslCls2Vald * portDayd;
				BigDecimal rtn_mfo_port_cls2big = null;
				BigDecimal mfo_port_cls2big = new BigDecimal(mfo_port_cls2d);
				rtn_mfo_port_cls2big = mfo_port_cls2big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(3).setVslCsl2(rtn_mfo_port_cls2big.toString());
				
				//Total MFO = MFO(Sea)+MFO(MAN)+MFO(Port)
				total_mfo_cls2d = mfo_sea_cls2d+mfo_man_cls2d+mfo_port_cls2d;
				BigDecimal rtn_total_mfo_cls2big = null;
				BigDecimal total_mfo_cls2big = new BigDecimal(total_mfo_cls2d);
				rtn_total_mfo_cls2big = total_mfo_cls2big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(4).setVslCsl2(rtn_total_mfo_cls2big.toString());
				
				//Total Bunker Charge = Total MFO * Bunker /Price
				bunker_charge_cls2d = total_mfo_cls2d * bnkPrcd;
				BigDecimal rtn_bunker_charge_cls2big = null;
				BigDecimal bunker_charge_cls2big = new BigDecimal(bunker_charge_cls2d);
				rtn_bunker_charge_cls2big = bunker_charge_cls2big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(5).setVslCsl2(rtn_bunker_charge_cls2big.toString());
				
				velClsCnt = velClsCnt +1;
			}
			
			//세번재 Vessel Class가 정해지고 Bunker Cost의 세번재 Vessel Class Daily Com.Bunker 입력한 데이타
			if(VSKGeneralUtil.isNotNull(n3rdVslClssCd) && !"".equals(n3rdVslClssCd)){
				//세번재 Vessel Class의 입력 값과 Sea Time의 Days을 계산한다 -> MFO(Sea)
				vslCls3Vald = Double.parseDouble(bunkerCostVOs.get(0).getVslCsl3());
				mfo_sea_cls3d = vslCls3Vald * seaDayd;
				BigDecimal rtn_mfo_sea_cls3big = null;
				BigDecimal mfo_sea_cls3big = new BigDecimal(mfo_sea_cls3d);
				rtn_mfo_sea_cls3big = mfo_sea_cls3big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(1).setVslCsl3(rtn_mfo_sea_cls3big.toString());
				
				//세번재 Vessel Class의 입력 값과 Maneuvering의 Days을 계산한다 -> MFO(MAN)
				mfo_man_cls3d = vslCls3Vald * maneDayd;
				BigDecimal rtn_mfo_man_cls3big = null;
				BigDecimal mfo_man_cls3big = new BigDecimal(mfo_man_cls3d);
				rtn_mfo_man_cls3big = mfo_man_cls3big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(2).setVslCsl3(rtn_mfo_man_cls3big.toString());
				
				//세번재 Vessel Class의 입력 값과 Port Time의 Days을 계산한다 -> MFO(Port)
				mfo_port_cls3d = vslCls3Vald * portDayd;
				BigDecimal rtn_mfo_port_cls3big = null;
				BigDecimal mfo_port_cls3big = new BigDecimal(mfo_port_cls3d);
				rtn_mfo_port_cls3big = mfo_port_cls3big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(3).setVslCsl3(rtn_mfo_port_cls3big.toString());
				
				//Total MFO = MFO(Sea)+MFO(MAN)+MFO(Port)
				total_mfo_cls3d = mfo_sea_cls3d+mfo_man_cls3d+mfo_port_cls3d;
				BigDecimal rtn_total_mfo_cls3big = null;
				BigDecimal total_mfo_cls3big = new BigDecimal(total_mfo_cls3d);
				rtn_total_mfo_cls3big = total_mfo_cls3big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(4).setVslCsl3(rtn_total_mfo_cls3big.toString());
				
				//Total Bunker Charge = Total MFO * Bunker /Price
				bunker_charge_cls3d = total_mfo_cls3d * bnkPrcd;
				BigDecimal rtn_bunker_charge_cls3big = null;
				BigDecimal bunker_charge_cls3big = new BigDecimal(bunker_charge_cls3d);
				rtn_bunker_charge_cls3big = bunker_charge_cls3big.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(5).setVslCsl3(rtn_bunker_charge_cls3big.toString());
				
				velClsCnt = velClsCnt +1;
			}
			
			//Total Average-입력한 Vessel Class의 갯수에 따라 Average를 개산한다
			//예) 두개의 Vessel Class를 입력하면 (첫번째 MFO(Sea) + 두번째 MFO(Sea)) /2
			//Daily Com.Bunker Average
			if(velClsCnt == 1){
				double daily_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(0).getVslCsl1());
				
				BigDecimal rtn_dailyTemp = null;
				BigDecimal dailyTemp = new BigDecimal(daily_cls1dTemp);
				rtn_dailyTemp = dailyTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(0).setTtlAvg(rtn_dailyTemp.toString());
			}else if(velClsCnt == 2){
				double daily_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(0).getVslCsl1());
				double daily_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(0).getVslCsl2());
				
				double daily_sum = (daily_cls1dTemp + daily_cls2dTemp)/2;
				BigDecimal rtn_dailyTemp = null;
				BigDecimal dailyTemp = new BigDecimal(daily_sum);
				rtn_dailyTemp = dailyTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(0).setTtlAvg(rtn_dailyTemp.toString());
			}else{
				double daily_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(0).getVslCsl1());
				double daily_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(0).getVslCsl2());
				double daily_cls3dTemp = Double.parseDouble(rrnBunkerCostVOs.get(0).getVslCsl3());
				
				double daily_sum = (daily_cls1dTemp + daily_cls2dTemp + daily_cls3dTemp)/3;
				BigDecimal rtn_dailyTemp = null;
				BigDecimal dailyTemp = new BigDecimal(daily_sum);
				rtn_dailyTemp = dailyTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(0).setTtlAvg(rtn_dailyTemp.toString());
			}
			
			//Total Average-입력한 Vessel Class의 갯수에 따라 Average를 개산한다
			//예) 두개의 Vessel Class를 입력하면 (첫번째 MFO(Sea) + 두번째 MFO(Sea)) /2
			//MFO(Sea) Total Average
			if(velClsCnt == 1){
				double mfo_sea_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(1).getVslCsl1());
				
				BigDecimal rtn_mfo_seaTemp = null;
				BigDecimal mfo_seaTemp = new BigDecimal(mfo_sea_cls1dTemp);
				rtn_mfo_seaTemp = mfo_seaTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(1).setTtlAvg(rtn_mfo_seaTemp.toString());
			}else if(velClsCnt == 2){
				double mfo_sea_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(1).getVslCsl1());
				double mfo_sea_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(1).getVslCsl2());
				
				double mfo_sea_sum = (mfo_sea_cls1dTemp + mfo_sea_cls2dTemp)/2;
				BigDecimal rtn_mfo_seaTemp = null;
				BigDecimal mfo_seaTemp = new BigDecimal(mfo_sea_sum);
				rtn_mfo_seaTemp = mfo_seaTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(1).setTtlAvg(rtn_mfo_seaTemp.toString());
			}else{
				double mfo_sea_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(1).getVslCsl1());
				double mfo_sea_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(1).getVslCsl2());
				double mfo_sea_cls3dTemp = Double.parseDouble(rrnBunkerCostVOs.get(1).getVslCsl3());
				
				double mfo_sea_sum = (mfo_sea_cls1dTemp + mfo_sea_cls2dTemp + mfo_sea_cls3dTemp)/3;
				BigDecimal rtn_mfo_seaTemp = null;
				BigDecimal mfo_seaTemp = new BigDecimal(mfo_sea_sum);
				rtn_mfo_seaTemp = mfo_seaTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(1).setTtlAvg(rtn_mfo_seaTemp.toString());
			}
			
			//MFO(MAN) Total Average
			if(velClsCnt == 1){
				double mfo_man_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(2).getVslCsl1());
				
				BigDecimal rtn_mfo_manTemp = null;
				BigDecimal mfo_manTemp = new BigDecimal(mfo_man_cls1dTemp);
				rtn_mfo_manTemp = mfo_manTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(2).setTtlAvg(rtn_mfo_manTemp.toString());
			}else if(velClsCnt == 2){
				double mfo_man_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(2).getVslCsl1());
				double mfo_man_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(2).getVslCsl2());
				
				double mfo_man_sum = (mfo_man_cls1dTemp + mfo_man_cls2dTemp)/2;
				BigDecimal rtn_mfo_manTemp = null;
				BigDecimal mfo_manTemp = new BigDecimal(mfo_man_sum);
				rtn_mfo_manTemp = mfo_manTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(2).setTtlAvg(rtn_mfo_manTemp.toString());
			}else{
				double mfo_man_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(2).getVslCsl1());
				double mfo_man_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(2).getVslCsl2());
				double mfo_man_cls3dTemp = Double.parseDouble(rrnBunkerCostVOs.get(2).getVslCsl3());
				
				double mfo_man_sum = (mfo_man_cls1dTemp + mfo_man_cls2dTemp + mfo_man_cls3dTemp)/3;
				BigDecimal rtn_mfo_manTemp = null;
				BigDecimal mfo_manTemp = new BigDecimal(mfo_man_sum);
				rtn_mfo_manTemp = mfo_manTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(2).setTtlAvg(rtn_mfo_manTemp.toString());
			}
			
			//MFO(Port) Total Average
			if(velClsCnt == 1){
				double mfo_port_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(3).getVslCsl1());
				
				BigDecimal rtn_mfo_portTemp = null;
				BigDecimal mfo_portTemp = new BigDecimal(mfo_port_cls1dTemp);
				rtn_mfo_portTemp = mfo_portTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(3).setTtlAvg(rtn_mfo_portTemp.toString());
			}else if(velClsCnt == 2){
				double mfo_port_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(3).getVslCsl1());
				double mfo_port_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(3).getVslCsl2());
				
				double mfo_port_sum = (mfo_port_cls1dTemp + mfo_port_cls2dTemp)/2;
				BigDecimal rtn_mfo_portTemp = null;
				BigDecimal mfo_portTemp = new BigDecimal(mfo_port_sum);
				rtn_mfo_portTemp = mfo_portTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(3).setTtlAvg(rtn_mfo_portTemp.toString());
			}else{
				double mfo_port_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(3).getVslCsl1());
				double mfo_port_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(3).getVslCsl2());
				double mfo_port_cls3dTemp = Double.parseDouble(rrnBunkerCostVOs.get(3).getVslCsl3());
				
				double mfo_port_sum = (mfo_port_cls1dTemp + mfo_port_cls2dTemp + mfo_port_cls3dTemp)/3;
				BigDecimal rtn_mfo_portTemp = null;
				BigDecimal mfo_portTemp = new BigDecimal(mfo_port_sum);
				rtn_mfo_portTemp = mfo_portTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(3).setTtlAvg(rtn_mfo_portTemp.toString());
			}
			
			//Total MFO Total Average
			if(velClsCnt == 1){
				double tot_mfo_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(4).getVslCsl1());
				
				BigDecimal rtn_tot_mfoTemp = null;
				BigDecimal tot_mfoTemp = new BigDecimal(tot_mfo_cls1dTemp);
				rtn_tot_mfoTemp = tot_mfoTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(4).setTtlAvg(rtn_tot_mfoTemp.toString());
			}else if(velClsCnt == 2){
				double tot_mfo_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(4).getVslCsl1());
				double tot_mfo_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(4).getVslCsl2());
				
				double tot_mfo_sum = (tot_mfo_cls1dTemp + tot_mfo_cls2dTemp)/2;
				BigDecimal rtn_tot_mfoTemp = null;
				BigDecimal tot_mfoTemp = new BigDecimal(tot_mfo_sum);
				rtn_tot_mfoTemp = tot_mfoTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(4).setTtlAvg(rtn_tot_mfoTemp.toString());
			}else{
				double tot_mfo_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(4).getVslCsl1());
				double tot_mfo_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(4).getVslCsl2());
				double tot_mfo_cls3dTemp = Double.parseDouble(rrnBunkerCostVOs.get(4).getVslCsl3());
				
				double tot_mfo_sum = (tot_mfo_cls1dTemp + tot_mfo_cls2dTemp + tot_mfo_cls3dTemp)/3;
				BigDecimal rtn_tot_mfoTemp = null;
				BigDecimal tot_mfoTemp = new BigDecimal(tot_mfo_sum);
				rtn_tot_mfoTemp = tot_mfoTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(4).setTtlAvg(rtn_tot_mfoTemp.toString());
			}
			
			//Total Bunker Charge -  Total Average
			if(velClsCnt == 1){
				double tot_chg_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(5).getVslCsl1());
				
				BigDecimal rtn_tot_chgTemp = null;
				BigDecimal tot_chgTemp = new BigDecimal(tot_chg_cls1dTemp);
				rtn_tot_chgTemp = tot_chgTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(5).setTtlAvg(rtn_tot_chgTemp.toString());
			}else if(velClsCnt == 2){
				double tot_chg_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(5).getVslCsl1());
				double tot_chg_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(5).getVslCsl2());
				
				double tot_chg_sum = (tot_chg_cls1dTemp + tot_chg_cls2dTemp)/2;
				BigDecimal rtn_tot_chgTemp = null;
				BigDecimal tot_chgTemp = new BigDecimal(tot_chg_sum);
				rtn_tot_chgTemp = tot_chgTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(5).setTtlAvg(rtn_tot_chgTemp.toString());
			}else{
				double tot_chg_cls1dTemp = Double.parseDouble(rrnBunkerCostVOs.get(5).getVslCsl1());
				double tot_chg_cls2dTemp = Double.parseDouble(rrnBunkerCostVOs.get(5).getVslCsl2());
				double tot_chg_cls3dTemp = Double.parseDouble(rrnBunkerCostVOs.get(5).getVslCsl3());
				
				double tot_chg_sum = (tot_chg_cls1dTemp + tot_chg_cls2dTemp + tot_chg_cls3dTemp)/3;
				BigDecimal rtn_tot_chgTemp = null;
				BigDecimal tot_chgTemp = new BigDecimal(tot_chg_sum);
				rtn_tot_chgTemp = tot_chgTemp.setScale(1,BigDecimal.ROUND_HALF_UP);
				rrnBunkerCostVOs.get(5).setTtlAvg(rtn_tot_chgTemp.toString());
			}
			
			rtnGrpVO.setBunkerCostVOs(rrnBunkerCostVOs);
			
			//Hire Base의 Declared Capacity의 데이터로
			//R/Voyage Days,Declared Capacity 와 조회된 데이타 중 선택한(Owner or Charter) 데이타로     
			//Hire/Teu(Owner) ,Hire/Teu(Charter)을 곱해서
			//OWNR_HIR_TTL_AMT,CHRG_HIR_TTL_AMT의 값을 셋팅한다
			
			List<HireBaseVO> rtnNewHireBaseVO= dbDao.searchHireBaseByDznCapa(slotPriceGRPVO);
			//R/Voyage Days
			double durDayd = Double.parseDouble(slotPriceVO.getDurDay());
			double hireTeuOwner1 = 0;
			double hireTeuOwner2 = 0;
			double hireTeuOwner3 = 0;
			double hireTeuCharter1 = 0;
			double hireTeuCharter2 = 0;
			double hireTeuCharter3 = 0;
			double ownrHirTtlAmt1 = 0;
			double ownrHirTtlAmt2 = 0;
			double ownrHirTtlAmt3 = 0;
			double chrgHirTtlAmt1 = 0;
			double chrgHirTtlAmt2 = 0;
			double chrgHirTtlAmt3 = 0;

			if(VSKGeneralUtil.isNotNull(n1stVslClssCd) && !"".equals(n1stVslClssCd)){
				//hireTeuOwner1 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl1()) * Double.parseDouble(rtnNewHireBaseVO.get(1).getVslCsl1());
				hireTeuOwner1 = Double.parseDouble(rtnNewHireBaseVO.get(1).getVslCsl1());
				//hireTeuCharter1 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl1()) * Double.parseDouble(rtnNewHireBaseVO.get(2).getVslCsl1());
				hireTeuCharter1 = Double.parseDouble(rtnNewHireBaseVO.get(2).getVslCsl1());
				
				BigDecimal rtn_owner_cls1big = null;
				BigDecimal owner_cls1big = new BigDecimal(hireTeuOwner1);
				rtn_owner_cls1big = owner_cls1big.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(1).setVslCsl1(rtn_owner_cls1big.toString());
				
				BigDecimal rtn_charter_cls1big = null;
				BigDecimal charter_cls1big = new BigDecimal(hireTeuCharter1);
				rtn_charter_cls1big = charter_cls1big.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(2).setVslCsl1(rtn_charter_cls1big.toString());
				
			}
			
			if(VSKGeneralUtil.isNotNull(n2ndVslClssCd) && !"".equals(n2ndVslClssCd)){
				//hireTeuOwner2 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl2()) * Double.parseDouble(rtnNewHireBaseVO.get(1).getVslCsl2());
				hireTeuOwner2 = Double.parseDouble(rtnNewHireBaseVO.get(1).getVslCsl2());
				//hireTeuCharter2 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl2()) * Double.parseDouble(rtnNewHireBaseVO.get(2).getVslCsl2());
				hireTeuCharter2 = Double.parseDouble(rtnNewHireBaseVO.get(2).getVslCsl2());
				
				BigDecimal rtn_owner_cls2big = null;
				BigDecimal owner_cls2big = new BigDecimal(hireTeuOwner2);
				rtn_owner_cls2big = owner_cls2big.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(1).setVslCsl2(rtn_owner_cls2big.toString());
				
				BigDecimal rtn_charter_cls2big = null;
				BigDecimal charter_cls2big = new BigDecimal(hireTeuCharter2);
				rtn_charter_cls2big = charter_cls2big.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(2).setVslCsl2(rtn_charter_cls2big.toString());
			}
			
			if(VSKGeneralUtil.isNotNull(n3rdVslClssCd) && !"".equals(n3rdVslClssCd)){
				//hireTeuOwner3 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl3()) * Double.parseDouble(rtnNewHireBaseVO.get(1).getVslCsl3());
				hireTeuOwner3 = Double.parseDouble(rtnNewHireBaseVO.get(1).getVslCsl3());
				//hireTeuCharter3 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl3()) * Double.parseDouble(rtnNewHireBaseVO.get(2).getVslCsl3());
				hireTeuCharter3 = Double.parseDouble(rtnNewHireBaseVO.get(2).getVslCsl3());
				
				BigDecimal rtn_owner_cls3big = null;
				BigDecimal owner_cls3big = new BigDecimal(hireTeuOwner3);
				rtn_owner_cls3big = owner_cls3big.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(1).setVslCsl3(rtn_owner_cls3big.toString());
				
				BigDecimal rtn_charter_cls3big = null;
				BigDecimal charter_cls3big = new BigDecimal(hireTeuCharter3);
				rtn_charter_cls3big = charter_cls3big.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(2).setVslCsl3(rtn_charter_cls3big.toString());
			}
			
			//Hire/TEU TTL AMT = OWNR_HIR_TTL_AMT
			//Declared Capacity * Hire/TEU(Owner)
			if(VSKGeneralUtil.isNotNull(n1stVslClssCd) && !"".equals(n1stVslClssCd)){
				ownrHirTtlAmt1 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl1()) * Double.parseDouble(hisrBaseVOs.get(1).getVslCsl1());
				chrgHirTtlAmt1 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl1()) * Double.parseDouble(hisrBaseVOs.get(2).getVslCsl1());
				
				BigDecimal owner_hir_ttl_amtcls1big = null;
				BigDecimal owner_hir_ttl_amt = new BigDecimal(ownrHirTtlAmt1);
				owner_hir_ttl_amtcls1big = owner_hir_ttl_amt.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(3).setVslCsl1(owner_hir_ttl_amtcls1big.toString());
				
				BigDecimal chrg_hir_ttl_amt_cls1big = null;
				BigDecimal chrg_hir_ttl_amt = new BigDecimal(chrgHirTtlAmt1);
				chrg_hir_ttl_amt_cls1big = chrg_hir_ttl_amt.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(4).setVslCsl1(chrg_hir_ttl_amt_cls1big.toString());
			}
			
			if(VSKGeneralUtil.isNotNull(n2ndVslClssCd) && !"".equals(n2ndVslClssCd)){
				ownrHirTtlAmt2 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl2()) * Double.parseDouble(hisrBaseVOs.get(1).getVslCsl2());
				chrgHirTtlAmt2 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl2()) * Double.parseDouble(hisrBaseVOs.get(2).getVslCsl2());
				
				BigDecimal owner_hir_ttl_amtcls2big = null;
				BigDecimal owner_hir_ttl_amt = new BigDecimal(ownrHirTtlAmt2);
				owner_hir_ttl_amtcls2big = owner_hir_ttl_amt.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(3).setVslCsl2(owner_hir_ttl_amtcls2big.toString());
				
				BigDecimal chrg_hir_ttl_amt_cls2big = null;
				BigDecimal chrg_hir_ttl_amt = new BigDecimal(chrgHirTtlAmt2);
				chrg_hir_ttl_amt_cls2big = chrg_hir_ttl_amt.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(4).setVslCsl2(chrg_hir_ttl_amt_cls2big.toString());
			}
			
			if(VSKGeneralUtil.isNotNull(n3rdVslClssCd) && !"".equals(n3rdVslClssCd)){
				ownrHirTtlAmt3 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl2()) * Double.parseDouble(hisrBaseVOs.get(1).getVslCsl2());
				chrgHirTtlAmt3 = durDayd * Double.parseDouble(hisrBaseVOs.get(0).getVslCsl2()) * Double.parseDouble(hisrBaseVOs.get(2).getVslCsl2());
				
				BigDecimal owner_hir_ttl_amtcls3big = null;
				BigDecimal owner_hir_ttl_amt = new BigDecimal(ownrHirTtlAmt3);
				owner_hir_ttl_amtcls3big = owner_hir_ttl_amt.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(3).setVslCsl3(owner_hir_ttl_amtcls3big.toString());
				
				BigDecimal chrg_hir_ttl_amt_cls3big = null;
				BigDecimal chrg_hir_ttl_amt = new BigDecimal(chrgHirTtlAmt3);
				chrg_hir_ttl_amt_cls3big = chrg_hir_ttl_amt.setScale(1,BigDecimal.ROUND_HALF_UP);
				hisrBaseVOs.get(4).setVslCsl3(chrg_hir_ttl_amt_cls3big.toString());
			}
			
			//Hire Base 데이타 초기화
			//Vessel Class에 따라 Hire Base를  재조정한다
			//예) 첫번째와두번째의 Vessel Class만 Calculation하면 
			// 세번째 Hire Base는  데이타를 출력하지 않는다
			if(velClsCnt == 1){
				hisrBaseVOs.get(0).setVslCsl2("");
				hisrBaseVOs.get(1).setVslCsl2("0");
				hisrBaseVOs.get(2).setVslCsl2("0");
				hisrBaseVOs.get(3).setVslCsl2("0");
				hisrBaseVOs.get(4).setVslCsl2("0");
				hisrBaseVOs.get(0).setVslCsl3("");
				hisrBaseVOs.get(1).setVslCsl3("0");
				hisrBaseVOs.get(2).setVslCsl3("0");
				hisrBaseVOs.get(3).setVslCsl3("0");
				hisrBaseVOs.get(4).setVslCsl3("0");
			}else if(velClsCnt == 2){
				hisrBaseVOs.get(0).setVslCsl3("");
				hisrBaseVOs.get(1).setVslCsl3("0");
				hisrBaseVOs.get(2).setVslCsl3("0");
				hisrBaseVOs.get(3).setVslCsl3("0");
				hisrBaseVOs.get(4).setVslCsl3("0");
			}
			
			

			rtnGrpVO.setHireBaseVOs(hisrBaseVOs);
			
			//Slot Price 계산
			//vsl_class 1번째 SUB TOTAL
			//Port Expense의 Total Port Cost + Bunker Cost의 Total Bunker Charge + Hire Base의 Hire/TEU(Owner,Charter)의 합
			double dVslClsPortTot1 = 0;
			double dVslClsPortTot2 = 0;
			double dVslClsPortTot3 = 0;
			//Port Expense의 Total Port Cost
			if(rtnPortExpenseVOs != null && rtnPortExpenseVOs.size() > 0){
				for(int k=0; k<rtnPortExpenseVOs.size(); k++){
					if(rtnPortExpenseVOs.get(k).getSumClass01() != null && !"".equals(rtnPortExpenseVOs.get(k).getSumClass01())){
						dVslClsPortTot1 += Double.parseDouble(rtnPortExpenseVOs.get(k).getSumClass01());
					}
					if(rtnPortExpenseVOs.get(k).getSumClass02() != null && !"".equals(rtnPortExpenseVOs.get(k).getSumClass02())){
						dVslClsPortTot2 += Double.parseDouble(rtnPortExpenseVOs.get(k).getSumClass02());
					}
					if(rtnPortExpenseVOs.get(k).getSumClass03() != null && !"".equals(rtnPortExpenseVOs.get(k).getSumClass03())){
						dVslClsPortTot3 += Double.parseDouble(rtnPortExpenseVOs.get(k).getSumClass03());
					}
				}
			}
			
			// Bunker Cost의 Total Bunker Charge
			double dVslClsBunkerTot1 = 0;
			double dVslClsBunkerTot2 = 0;
			double dVslClsBunkerTot3 = 0;
			if(rrnBunkerCostVOs != null && rrnBunkerCostVOs.size() > 0){
				if(rrnBunkerCostVOs.get(5).getVslCsl1() != null && !"".equals(rrnBunkerCostVOs.get(5).getVslCsl1())){
					dVslClsBunkerTot1 = Double.parseDouble(rrnBunkerCostVOs.get(5).getVslCsl1());
				}
				if(rrnBunkerCostVOs.get(5).getVslCsl2() != null && !"".equals(rrnBunkerCostVOs.get(5).getVslCsl2())){
					dVslClsBunkerTot2 = Double.parseDouble(rrnBunkerCostVOs.get(5).getVslCsl2());
				}
				
				if(rrnBunkerCostVOs.get(5).getVslCsl3() != null && !"".equals(rrnBunkerCostVOs.get(5).getVslCsl3())){
					dVslClsBunkerTot3 = Double.parseDouble(rrnBunkerCostVOs.get(5).getVslCsl3());
				}
			}
			
			//Hire Base
			double dVslClsHirTot1 = 0;  
			double dVslClsHirTot2 = 0;
			double dVslClsHirTot3 = 0;
			double dDeclCapa1 = 0;
			double dDeclCapa2 = 0;
			double dDeclCapa3 = 0;
			int posCnt = 0;
			if(hisrBaseVOs != null && hisrBaseVOs.size() > 0){
				for(int i=0; i<hisrBaseVOs.size(); i++){
					HireBaseVO valueVO = hisrBaseVOs.get(i);
					String ownerFlag = valueVO.getVslOwnrFlg();					
					if("Y".equals(ownerFlag)){
						posCnt = i;
					}
				}
				
				if(hisrBaseVOs.get(posCnt).getVslCsl1() != null && !"".equals(hisrBaseVOs.get(posCnt).getVslCsl1())){
					dVslClsHirTot1 = Double.parseDouble(hisrBaseVOs.get(posCnt).getVslCsl1());
					dDeclCapa1 = Double.parseDouble(hisrBaseVOs.get(0).getVslCsl1());				
				}
				
				if(hisrBaseVOs.get(posCnt).getVslCsl2() != null && !"".equals(hisrBaseVOs.get(posCnt).getVslCsl2())){
					dVslClsHirTot2 = Double.parseDouble(hisrBaseVOs.get(posCnt).getVslCsl2());
					if(VSKGeneralUtil.isNotNull(hisrBaseVOs.get(0).getVslCsl2())){
						dDeclCapa2 = Double.parseDouble(hisrBaseVOs.get(0).getVslCsl2());
					}
				}
				
				if(hisrBaseVOs.get(posCnt).getVslCsl3() != null && !"".equals(hisrBaseVOs.get(posCnt).getVslCsl3())){
					dVslClsHirTot3 = Double.parseDouble(hisrBaseVOs.get(posCnt).getVslCsl3());
					if(VSKGeneralUtil.isNotNull(hisrBaseVOs.get(0).getVslCsl3())){
						dDeclCapa3 = Double.parseDouble(hisrBaseVOs.get(0).getVslCsl3());
					}
				}
			}

			double dSubTotVslCsl1 = dVslClsPortTot1 + dVslClsBunkerTot1 + dVslClsHirTot1;
			double dSubTotVslCsl2 = dVslClsPortTot2 + dVslClsBunkerTot2 + dVslClsHirTot2;
			double dSubTotVslCsl3 = dVslClsPortTot3 + dVslClsBunkerTot3 + dVslClsHirTot3;
			double dSubTot = dSubTotVslCsl1 + dSubTotVslCsl2 + dSubTotVslCsl3;
			
			//Slot Price 산출
			//Sub Total = 해당 Vess Class의 sum(Port Expense) + Bunker Cost의 Total Buner Charge + Hire Base의 (Owner,Charter)의 선택 한 데이타 
			List<SlotPriceVO> rtnSlotPriceVOs = new ArrayList<SlotPriceVO>();
			for(int i=0; i<3; i++){
				SlotPriceVO valueVO = new SlotPriceVO();
				rtnSlotPriceVOs.add(i, valueVO);
			}
			if(VSKGeneralUtil.isNotNull(n1stVslClssCd) && !"".equals(n1stVslClssCd)){
				BigDecimal bRSubTotVslCls1 = null;
				BigDecimal bSubTotVslCls1 = new BigDecimal(dSubTotVslCsl1);
				bRSubTotVslCls1 = bSubTotVslCls1.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(0).setVslCsl1(bRSubTotVslCls1.toString());
			}
			
			if(VSKGeneralUtil.isNotNull(n2ndVslClssCd) && !"".equals(n2ndVslClssCd)){
				BigDecimal bRSubTotVslCls2 = null;
				BigDecimal bSubTotVslCls2 = new BigDecimal(dSubTotVslCsl2);
				bRSubTotVslCls2 = bSubTotVslCls2.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(0).setVslCsl2(bRSubTotVslCls2.toString());
			}
			
			if(VSKGeneralUtil.isNotNull(n3rdVslClssCd) && !"".equals(n3rdVslClssCd)){
				BigDecimal bRSubTotVslCls3 = null;
				BigDecimal bSubTotVslCls3 = new BigDecimal(dSubTotVslCsl3);
				bRSubTotVslCls3 = bSubTotVslCls3.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(0).setVslCsl3(bRSubTotVslCls3.toString());
			}
			
			if(velClsCnt == 1){
				BigDecimal bRSubTot = null;
				BigDecimal bSubTot = new BigDecimal(dSubTot);
				bRSubTot = bSubTot.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(0).setSlotSum(bRSubTot.toString());
			}else if(velClsCnt == 2){
				BigDecimal bRSubTot = null;
				BigDecimal bSubTot = new BigDecimal(dSubTot/2);
				bRSubTot = bSubTot.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(0).setSlotSum(bRSubTot.toString());
			}else if(velClsCnt == 3){
				BigDecimal bRSubTot = null;
				BigDecimal bSubTot = new BigDecimal(dSubTot/3);
				bRSubTot = bSubTot.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(0).setSlotSum(bRSubTot.toString());
			}
			
			//Slot Price(Round)
			double dSlotRou1 = 0;
			double dSlotRou2 = 0;
			double dSlotRou3 = 0;
			double dSlotTot = 0;
			
			if(VSKGeneralUtil.isNotNull(n1stVslClssCd) && !"".equals(n1stVslClssCd)){
				//dSlotRou1 = dSubTotVslCsl1/dDeclCapa1;	
				if(Double.compare(dDeclCapa1, 0) == 0){
					dSlotRou1	= 0;
				}else{
					dSlotRou1 	= dSubTotVslCsl1/dDeclCapa1;	
				}
			}
			
			if(VSKGeneralUtil.isNotNull(n2ndVslClssCd) && !"".equals(n2ndVslClssCd)){
				//dSlotRou2 = dSubTotVslCsl2/dDeclCapa2;
				if(Double.compare(dDeclCapa2, 0) == 0){
					dSlotRou2	= 0;
				}else{
					dSlotRou2 	= dSubTotVslCsl2/dDeclCapa2;	
				}
			}
			
			if(VSKGeneralUtil.isNotNull(n3rdVslClssCd) && !"".equals(n3rdVslClssCd)){
				//dSlotRou3 = dSubTotVslCsl3/dDeclCapa3;
				if(Double.compare(dDeclCapa3, 0) == 0){
					dSlotRou3	= 0;
				}else{
					dSlotRou3 	= dSubTotVslCsl3/dDeclCapa3;	
				}				
			}
			
			dSlotTot = dSlotRou1 + dSlotRou2 + dSlotRou3;

			if(VSKGeneralUtil.isNotNull(n1stVslClssCd) && !"".equals(n1stVslClssCd)){
				BigDecimal bRSlotRou1 = null;
				BigDecimal bSlotRou1 = new BigDecimal(dSlotRou1);
				bRSlotRou1 = bSlotRou1.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(1).setVslCsl1(bRSlotRou1.toString());
			}
			
			if(VSKGeneralUtil.isNotNull(n2ndVslClssCd) && !"".equals(n2ndVslClssCd)){
				BigDecimal bRSlotRou2 = null;
				BigDecimal bSlotRou2 = new BigDecimal(dSlotRou2);
				bRSlotRou2 = bSlotRou2.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(1).setVslCsl2(bRSlotRou2.toString());
			}
			
			if(VSKGeneralUtil.isNotNull(n3rdVslClssCd) && !"".equals(n3rdVslClssCd)){
				BigDecimal bRSlotRou3 = null;
				BigDecimal bSlotRou3 = new BigDecimal(dSlotRou3);
				bRSlotRou3 = bSlotRou3.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(1).setVslCsl3(bRSlotRou3.toString());
			}
			
			if(velClsCnt == 1){
				BigDecimal bRSlotRou = null;
				BigDecimal bSlotRou = new BigDecimal(dSlotTot);
				bRSlotRou = bSlotRou.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(1).setSlotSum(bRSlotRou.toString());
			}else if(velClsCnt == 2){
				BigDecimal bRSlotRou = null;
				BigDecimal bSlotRou = new BigDecimal(dSlotTot/2);
				bRSlotRou = bSlotRou.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(1).setSlotSum(bRSlotRou.toString());
			}else if(velClsCnt == 3){
				BigDecimal bRSlotRou = null;
				BigDecimal bSlotRou = new BigDecimal(dSlotTot/3);
				bRSlotRou = bSlotRou.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(1).setSlotSum(bRSlotRou.toString());
			}
			
			//Slot Price(LEG)
			double dSlotLeg1 = 0; 
			double dSlotLeg2 = 0; 
			double dSlotLeg3 = 0; 
			double dSlotLegTot = 0; 
			if(0 < Double.compare(dSlotRou1,0)){	
				dSlotLeg1 = dSlotRou1/2;
			}
			
			if(0 < Double.compare(dSlotRou2,0)){	
				dSlotLeg2 = dSlotRou2/2;
			}
			
			if(0 < Double.compare(dSlotRou3,0)){	
				dSlotLeg3 = dSlotRou3/2;
			}
			
			dSlotLegTot = dSlotLeg1 + dSlotLeg2 + dSlotLeg3;
			
			if(VSKGeneralUtil.isNotNull(n1stVslClssCd) && !"".equals(n1stVslClssCd)){
				BigDecimal bRSlotLeg1 = null;
				BigDecimal bSlotLeg1 = new BigDecimal(dSlotLeg1);
				bRSlotLeg1 = bSlotLeg1.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(2).setVslCsl1(bRSlotLeg1.toString());
			}
			
			if(VSKGeneralUtil.isNotNull(n2ndVslClssCd) && !"".equals(n2ndVslClssCd)){
				BigDecimal bRSlotLeg2 = null;
				BigDecimal bSlotLeg2 = new BigDecimal(dSlotLeg2);
				bRSlotLeg2 = bSlotLeg2.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(2).setVslCsl2(bRSlotLeg2.toString());
			}
			
			if(VSKGeneralUtil.isNotNull(n3rdVslClssCd) && !"".equals(n3rdVslClssCd)){
				BigDecimal bRSlotLeg3 = null;
				BigDecimal bSlotLeg3 = new BigDecimal(dSlotLeg3);
				bRSlotLeg3 = bSlotLeg3.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(2).setVslCsl3(bRSlotLeg3.toString());
			}
			
			if(velClsCnt == 1){
				BigDecimal bRSlotLegTot = null;
				BigDecimal bSlotLegTot = new BigDecimal(dSlotLegTot);
				bRSlotLegTot = bSlotLegTot.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(2).setSlotSum(bRSlotLegTot.toString());
			}else if(velClsCnt == 2){
				BigDecimal bRSlotLegTot = null;
				BigDecimal bSlotLegTot = new BigDecimal(dSlotLegTot/2);
				bRSlotLegTot = bSlotLegTot.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(2).setSlotSum(bRSlotLegTot.toString());
			}else if(velClsCnt == 3){
				BigDecimal bRSlotLegTot = null;
				BigDecimal bSlotLegTot = new BigDecimal(dSlotLegTot/3);
				bRSlotLegTot = bSlotLegTot.setScale(2,BigDecimal.ROUND_HALF_UP);
				rtnSlotPriceVOs.get(2).setSlotSum(bRSlotLegTot.toString());
			}
			
			rtnGrpVO.setSlotPriceVOs(rtnSlotPriceVOs);

			return rtnGrpVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	
	/**
	 * Slot Price 정보를 저장한다.<br>
	 *  Slot Price 대한 저장 이벤트 처리<br>
	 * 
	 * @param SlotPriceGRPVO slotPriceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSlotPrice(SlotPriceGRPVO slotPriceGRPVO, SignOnUserAccount account) throws EventException{
		try {
			// Master Data
			SlotPriceVO masterVO = slotPriceGRPVO.getSlotPriceVO();
			//Port Expense
			List<PortExpenseVO> portExpenseVOs = slotPriceGRPVO.getPortExpenseVOs();
			//Bunker Cost
			List<BunkerCostVO> bunkerCostVOs = slotPriceGRPVO.getBunkerCostVOs();
			//Hire Base
			List<HireBaseVO> hireBaseVOs = slotPriceGRPVO.getHireBaseVOs();
			
			String n1stVslClssCd = masterVO.getN1stVslClssCd();
			String n2ndVslClssCd = masterVO.getN2ndVslClssCd();
			String n3rdVslClssCd = masterVO.getN3rdVslClssCd();
			double peAmtcls1 = 0;
			double peAmtcls2 = 0;
			double peAmtcls3 = 0;
			BigDecimal peAmtBigCls1 = null;
			BigDecimal peAmtBigCls2 = null;
			BigDecimal peAmtBigCls3 = null;
			
			for(int i=0; i<portExpenseVOs.size(); i++){
				if(VSKGeneralUtil.isNotNull(n1stVslClssCd) && !"".equals(n1stVslClssCd)){
					peAmtcls1 +=  Double.parseDouble(portExpenseVOs.get(i).getSumClass01());
				}
				if(VSKGeneralUtil.isNotNull(n2ndVslClssCd) && !"".equals(n2ndVslClssCd)){
					peAmtcls2 +=  Double.parseDouble(portExpenseVOs.get(i).getSumClass02());
				}
				if(VSKGeneralUtil.isNotNull(n3rdVslClssCd) && !"".equals(n3rdVslClssCd)){
					peAmtcls3 +=  Double.parseDouble(portExpenseVOs.get(i).getSumClass03());
				}
			}
			
			BigDecimal peAmtBigCls1Temp = new BigDecimal(peAmtcls1);
			peAmtBigCls1 = peAmtBigCls1Temp.setScale(3,BigDecimal.ROUND_HALF_UP);
			
			BigDecimal peAmtBigCls2Temp = new BigDecimal(peAmtcls2);
			peAmtBigCls2 = peAmtBigCls2Temp.setScale(3,BigDecimal.ROUND_HALF_UP);
			
			BigDecimal peAmtBigCls3Temp = new BigDecimal(peAmtcls3);
			peAmtBigCls3 = peAmtBigCls3Temp.setScale(3,BigDecimal.ROUND_HALF_UP);
			
			
			
			String vslOwnerFlg = "";
			if("1".equals(hireBaseVOs.get(2).getVslOwnrFlg())){
				vslOwnerFlg = "Y";
			}else{
				vslOwnerFlg = "N";
			}
			
			//Slot Price
			List<SlotPriceVO> slotPriceVOs = slotPriceGRPVO.getSlotPriceVOs();
			//paramVO
			SlotPriceGRPVO paramVO = new SlotPriceGRPVO();
			
			String[] vslClsArr = new String[3];
		
			if(!"".equals(masterVO.getN1stVslClssCd())){
				vslClsArr[0] = masterVO.getN1stVslClssCd();
			}
			if(!"".equals(masterVO.getN2ndVslClssCd())){
				vslClsArr[1] = masterVO.getN2ndVslClssCd();
			}			
			if(!"".equals(masterVO.getN3rdVslClssCd())){
				vslClsArr[2] = masterVO.getN3rdVslClssCd();
			}

			masterVO.setCreUsrId(account.getUsr_id());
			paramVO.setSlotPriceVO(masterVO);
			
			//VSK_SLT_PRC_PORT_DTL 삭제한다
			dbDao.removeVskSltPrcPortDtl(paramVO);
			
			//VSK_SLT_PRC_DTL 삭제한다  
			dbDao.removeVskSltPrcDtl(paramVO);
			
			//VSK_SLT_PRC 삭제한다  
			dbDao.removeVskSltPrc(paramVO);
			
			//VSK_SLT_PRC 테이블에 신규 입력한다
			dbDao.addVskSltPrc(paramVO);
			//VSK_SLT_PRC_DTL 테이블에 신규 입력한다
			for(int i=0; i<vslClsArr.length; i++){
				if(i == 0){			
					if(vslClsArr[i] != null && !"".equals(vslClsArr[i])){
						// Bunker Cost
						VskSltPrcDtlVO vskSltPrcDtlVO1 = new VskSltPrcDtlVO();
						vskSltPrcDtlVO1.setVslSlanCd(masterVO.getVslSlanCd());
						vskSltPrcDtlVO1.setPfSvcTpCd(masterVO.getPfSvcTpCd());
						vskSltPrcDtlVO1.setSltPrcWrkYr(masterVO.getSltPrcWrkYr());
						vskSltPrcDtlVO1.setBseQtrCd(masterVO.getBseQtrCd());
						vskSltPrcDtlVO1.setVslClssCd(masterVO.getN1stVslClssCd());
						vskSltPrcDtlVO1.setVslClssKnt(masterVO.getN1stVslClssKnt());//
						vskSltPrcDtlVO1.setCntrDznCapa(hireBaseVOs.get(0).getVslCsl1());
						vskSltPrcDtlVO1.setPeAmt(peAmtBigCls1.toString());
						vskSltPrcDtlVO1.setDlyBnkCsmQty(bunkerCostVOs.get(0).getVslCsl1());
						vskSltPrcDtlVO1.setMtxFoilSeaDyQty("0");
						vskSltPrcDtlVO1.setMtxFoilSeaTtlQty(bunkerCostVOs.get(1).getVslCsl1());
						vskSltPrcDtlVO1.setMtxFoilMnvrDyQty("0");
						vskSltPrcDtlVO1.setMtxFoilMnvrTtlQty(bunkerCostVOs.get(2).getVslCsl1());
						vskSltPrcDtlVO1.setMtxFoilPortDyQty("0");
						vskSltPrcDtlVO1.setMtxFoilPortTtlQty(bunkerCostVOs.get(3).getVslCsl1());
						vskSltPrcDtlVO1.setMtxFoilTtlQty(bunkerCostVOs.get(4).getVslCsl1());
						vskSltPrcDtlVO1.setBnkExpnAmt(bunkerCostVOs.get(5).getVslCsl1());
						// Hire Base
						vskSltPrcDtlVO1.setVslOwnrFlg(vslOwnerFlg);
						vskSltPrcDtlVO1.setOwnrHirTeuAmt(hireBaseVOs.get(1).getVslCsl1());
						vskSltPrcDtlVO1.setOwnrHirTtlAmt(hireBaseVOs.get(3).getVslCsl1());
						vskSltPrcDtlVO1.setChrgHirTeuAmt(hireBaseVOs.get(2).getVslCsl1());
						vskSltPrcDtlVO1.setChrgHirTtlAmt(hireBaseVOs.get(4).getVslCsl1());

						// Slot Price
						vskSltPrcDtlVO1.setSltPrcTtlAmt(slotPriceVOs.get(0).getVslCsl1());
						vskSltPrcDtlVO1.setSltPrcRndAmt(slotPriceVOs.get(1).getVslCsl1());
						vskSltPrcDtlVO1.setSltPrcOneWyAmt(slotPriceVOs.get(2).getVslCsl1());

						vskSltPrcDtlVO1.setCreUsrId(account.getUsr_id());

						//VSK_SLT_PRC 테이블에 신규 입력한다
						paramVO.setVskSltPrcDtlVO(vskSltPrcDtlVO1);
						dbDao.addVskSltPrcDtl(paramVO);	
					}
				}else if(i == 1){					
					if(vslClsArr[i] != null && !"".equals(vslClsArr[i])){
						// Bunker Cost
						VskSltPrcDtlVO vskSltPrcDtlVO2 = new VskSltPrcDtlVO();
						vskSltPrcDtlVO2.setVslSlanCd(masterVO.getVslSlanCd());
						vskSltPrcDtlVO2.setPfSvcTpCd(masterVO.getPfSvcTpCd());
						vskSltPrcDtlVO2.setSltPrcWrkYr(masterVO.getSltPrcWrkYr());
						vskSltPrcDtlVO2.setBseQtrCd(masterVO.getBseQtrCd());
						vskSltPrcDtlVO2.setVslClssCd(masterVO.getN2ndVslClssCd());
						vskSltPrcDtlVO2.setVslClssKnt(masterVO.getN2ndVslClssKnt());
						vskSltPrcDtlVO2.setCntrDznCapa(hireBaseVOs.get(0).getVslCsl2());
						vskSltPrcDtlVO2.setPeAmt(peAmtBigCls2.toString());
						vskSltPrcDtlVO2.setDlyBnkCsmQty(bunkerCostVOs.get(0).getVslCsl2());
						vskSltPrcDtlVO2.setMtxFoilSeaDyQty("0");
						vskSltPrcDtlVO2.setMtxFoilSeaTtlQty(bunkerCostVOs.get(1).getVslCsl2());
						vskSltPrcDtlVO2.setMtxFoilMnvrDyQty("0");
						vskSltPrcDtlVO2.setMtxFoilMnvrTtlQty(bunkerCostVOs.get(2).getVslCsl2());
						vskSltPrcDtlVO2.setMtxFoilPortDyQty("0");
						vskSltPrcDtlVO2.setMtxFoilPortTtlQty(bunkerCostVOs.get(3).getVslCsl2());
						vskSltPrcDtlVO2.setMtxFoilTtlQty(bunkerCostVOs.get(4).getVslCsl2());
						vskSltPrcDtlVO2.setBnkExpnAmt(bunkerCostVOs.get(5).getVslCsl2());
						// Hire Base
						vskSltPrcDtlVO2.setVslOwnrFlg(vslOwnerFlg);
						vskSltPrcDtlVO2.setOwnrHirTeuAmt(hireBaseVOs.get(1).getVslCsl2());
						vskSltPrcDtlVO2.setOwnrHirTtlAmt(hireBaseVOs.get(3).getVslCsl2());
						vskSltPrcDtlVO2.setChrgHirTeuAmt(hireBaseVOs.get(2).getVslCsl2());
						vskSltPrcDtlVO2.setChrgHirTtlAmt(hireBaseVOs.get(4).getVslCsl2());
						
						// Slot Price
						vskSltPrcDtlVO2.setSltPrcTtlAmt(slotPriceVOs.get(0).getVslCsl2());
						vskSltPrcDtlVO2.setSltPrcRndAmt(slotPriceVOs.get(1).getVslCsl2());
						vskSltPrcDtlVO2.setSltPrcOneWyAmt(slotPriceVOs.get(2).getVslCsl2());
						vskSltPrcDtlVO2.setCreUsrId(account.getUsr_id());

						//VSK_SLT_PRC 테이블에 신규 입력한다
						paramVO.setVskSltPrcDtlVO(vskSltPrcDtlVO2);
						dbDao.addVskSltPrcDtl(paramVO);	
					}
				}else if(i == 2){					
					if(vslClsArr[i] != null && !"".equals(vslClsArr[i])){
						// Bunker Cost
						VskSltPrcDtlVO vskSltPrcDtlVO3 = new VskSltPrcDtlVO();
						vskSltPrcDtlVO3.setVslSlanCd(masterVO.getVslSlanCd());
						vskSltPrcDtlVO3.setPfSvcTpCd(masterVO.getPfSvcTpCd());
						vskSltPrcDtlVO3.setSltPrcWrkYr(masterVO.getSltPrcWrkYr());
						vskSltPrcDtlVO3.setBseQtrCd(masterVO.getBseQtrCd());
						vskSltPrcDtlVO3.setVslClssCd(masterVO.getN3rdVslClssCd());
						vskSltPrcDtlVO3.setVslClssKnt(masterVO.getN3rdVslClssKnt());
						vskSltPrcDtlVO3.setCntrDznCapa(hireBaseVOs.get(0).getVslCsl3());
						vskSltPrcDtlVO3.setPeAmt(peAmtBigCls3.toString());
						vskSltPrcDtlVO3.setDlyBnkCsmQty(bunkerCostVOs.get(0).getVslCsl3());
						vskSltPrcDtlVO3.setMtxFoilSeaDyQty("0");
						vskSltPrcDtlVO3.setMtxFoilSeaTtlQty(bunkerCostVOs.get(1).getVslCsl3());
						vskSltPrcDtlVO3.setMtxFoilMnvrDyQty("0");
						vskSltPrcDtlVO3.setMtxFoilMnvrTtlQty(bunkerCostVOs.get(2).getVslCsl3());
						vskSltPrcDtlVO3.setMtxFoilPortDyQty("0");
						vskSltPrcDtlVO3.setMtxFoilPortTtlQty(bunkerCostVOs.get(3).getVslCsl3());
						vskSltPrcDtlVO3.setMtxFoilTtlQty(bunkerCostVOs.get(4).getVslCsl3());
						vskSltPrcDtlVO3.setBnkExpnAmt(bunkerCostVOs.get(5).getVslCsl3());
						// Hire Base
						vskSltPrcDtlVO3.setVslOwnrFlg(vslOwnerFlg);
						vskSltPrcDtlVO3.setOwnrHirTeuAmt(hireBaseVOs.get(1).getVslCsl3());
						vskSltPrcDtlVO3.setOwnrHirTtlAmt(hireBaseVOs.get(3).getVslCsl3());
						vskSltPrcDtlVO3.setChrgHirTeuAmt(hireBaseVOs.get(2).getVslCsl3());
						vskSltPrcDtlVO3.setChrgHirTtlAmt(hireBaseVOs.get(4).getVslCsl3());
						
						// Slot Price
						vskSltPrcDtlVO3.setSltPrcTtlAmt(slotPriceVOs.get(0).getVslCsl3());
						vskSltPrcDtlVO3.setSltPrcRndAmt(slotPriceVOs.get(1).getVslCsl3());
						vskSltPrcDtlVO3.setSltPrcOneWyAmt(slotPriceVOs.get(2).getVslCsl3());
						vskSltPrcDtlVO3.setCreUsrId(account.getUsr_id());

						//VSK_SLT_PRC 테이블에 신규 입력한다
						paramVO.setVskSltPrcDtlVO(vskSltPrcDtlVO3);
						dbDao.addVskSltPrcDtl(paramVO);	
					}
				}
			}
			
			for(int i=0; i<vslClsArr.length; i++){
				if(i == 0){
					if(vslClsArr[i] != null && !"".equals(vslClsArr[i])){
						for(int k=0; k<portExpenseVOs.size(); k++){
							VskSltPrcPortDtlVO vskSltPrcPortDtlVO = new VskSltPrcPortDtlVO();
							vskSltPrcPortDtlVO.setVslSlanCd(masterVO.getVslSlanCd());
							vskSltPrcPortDtlVO.setPfSvcTpCd(masterVO.getPfSvcTpCd());
							vskSltPrcPortDtlVO.setSltPrcWrkYr(masterVO.getSltPrcWrkYr());
							vskSltPrcPortDtlVO.setBseQtrCd(masterVO.getBseQtrCd());
							vskSltPrcPortDtlVO.setVslClssCd(vslClsArr[i]);
							vskSltPrcPortDtlVO.setPortCd(portExpenseVOs.get(k).getPortCd());
							vskSltPrcPortDtlVO.setSkdDirCd(portExpenseVOs.get(k).getSkdDirCd());
							vskSltPrcPortDtlVO.setClptSeq(portExpenseVOs.get(k).getClptSeq());
							vskSltPrcPortDtlVO.setPortRotnSeq(Integer.toString(k));
							vskSltPrcPortDtlVO.setYdCd(portExpenseVOs.get(k).getPortCd()+portExpenseVOs.get(k).getYdCd());
							vskSltPrcPortDtlVO.setPeAmt(portExpenseVOs.get(k).getSumClass01());
							vskSltPrcPortDtlVO.setCreUsrId(account.getUsr_id());
							paramVO.setVskSltPrcPortDtlVO(vskSltPrcPortDtlVO);

							dbDao.addVskSltPrcPortDtl(paramVO);	
						}
					}
				}else if(i == 1){
					if(vslClsArr[i] != null && !"".equals(vslClsArr[i])){
						for(int k=0; k<portExpenseVOs.size(); k++){
							VskSltPrcPortDtlVO vskSltPrcPortDtlVO = new VskSltPrcPortDtlVO();
							vskSltPrcPortDtlVO.setVslSlanCd(masterVO.getVslSlanCd());
							vskSltPrcPortDtlVO.setPfSvcTpCd(masterVO.getPfSvcTpCd());
							vskSltPrcPortDtlVO.setSltPrcWrkYr(masterVO.getSltPrcWrkYr());
							vskSltPrcPortDtlVO.setBseQtrCd(masterVO.getBseQtrCd());
							vskSltPrcPortDtlVO.setVslClssCd(vslClsArr[i]);
							vskSltPrcPortDtlVO.setPortCd(portExpenseVOs.get(k).getPortCd());
							vskSltPrcPortDtlVO.setSkdDirCd(portExpenseVOs.get(k).getSkdDirCd());
							vskSltPrcPortDtlVO.setClptSeq(portExpenseVOs.get(k).getClptSeq());
							vskSltPrcPortDtlVO.setPortRotnSeq(Integer.toString(k));
							vskSltPrcPortDtlVO.setYdCd(portExpenseVOs.get(k).getPortCd()+portExpenseVOs.get(k).getYdCd());
							vskSltPrcPortDtlVO.setPeAmt(portExpenseVOs.get(k).getSumClass02());
							vskSltPrcPortDtlVO.setCreUsrId(account.getUsr_id());
							paramVO.setVskSltPrcPortDtlVO(vskSltPrcPortDtlVO);
							
							dbDao.addVskSltPrcPortDtl(paramVO);	
						}
					}
				}else if(i == 2){
					if(vslClsArr[i] != null && !"".equals(vslClsArr[i])){
						for(int k=0; k<portExpenseVOs.size(); k++){
							VskSltPrcPortDtlVO vskSltPrcPortDtlVO = new VskSltPrcPortDtlVO();
							vskSltPrcPortDtlVO.setVslSlanCd(masterVO.getVslSlanCd());
							vskSltPrcPortDtlVO.setPfSvcTpCd(masterVO.getPfSvcTpCd());
							vskSltPrcPortDtlVO.setSltPrcWrkYr(masterVO.getSltPrcWrkYr());
							vskSltPrcPortDtlVO.setBseQtrCd(masterVO.getBseQtrCd());
							vskSltPrcPortDtlVO.setVslClssCd(vslClsArr[i]);
							vskSltPrcPortDtlVO.setPortCd(portExpenseVOs.get(k).getPortCd());
							vskSltPrcPortDtlVO.setSkdDirCd(portExpenseVOs.get(k).getSkdDirCd());
							vskSltPrcPortDtlVO.setClptSeq(portExpenseVOs.get(k).getClptSeq());
							vskSltPrcPortDtlVO.setPortRotnSeq(Integer.toString(k));
							vskSltPrcPortDtlVO.setYdCd(portExpenseVOs.get(k).getPortCd()+portExpenseVOs.get(k).getYdCd());
							vskSltPrcPortDtlVO.setPeAmt(portExpenseVOs.get(k).getSumClass03());
							vskSltPrcPortDtlVO.setCreUsrId(account.getUsr_id());
							paramVO.setVskSltPrcPortDtlVO(vskSltPrcPortDtlVO);

							dbDao.addVskSltPrcPortDtl(paramVO);
						}
					}
				}
			}

			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
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
	
	/**
	 * FROM, TO PORT간에 DISTANCE, ZD(ZONE DESCRIPTION), CRANE 수, 터미널 생산성 정보를 조회한다.<br>
	 *  ProformaScheduleMgt화면에 대한 조회 이벤트 처리<br>
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
	 * P/F SKD Settlement의 PF_SKD을 삭제한다.<br>
	 *  ProformaScheduleMgt화면에 대한 삭제 이벤트 처리<br>
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
			
			//Creation : 0003 => 기존의  Trunk만 Creation 하던 업무에서 Feeder도 같이 오퍼레이션한다
			//Feeder : 0053 => Feeder만 오퍼레이션한다
			//이 두가지 업무를 여기서 같이 Remove 하므로 해당 Lane의 서비스 타입 업무를 조회후 
			//Trunker와 Feeder의 저장 오퍼레이션을 나눈다
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

			//Trunker일때만 체크한다
			int checkVskSkdCnt = 0;
			if("O".equals(vslSvcTpCdVal)){
				//Feeder일 경우
				checkVskSkdCnt = 0;
			}else{
				//Trunk일 경우
				//VSL_SKD에 화면에서 입력받은 VSL_SLAN_CD,PF_TYPE_CD로  
				//해당 PROFORMA을 사용하는지 체크한다
				checkVskSkdCnt = dbDao.checkVslSkdByPfSkd(tempVslLlanCd,tempPfSvcTpCd);
				
				//해당 PROFORMA를 사용하면 메세지를 리턴하고 SKIP한다 
				if(checkVskSkdCnt > 0){
					throw new EventException(new ErrorHandler("VSK10034").getMessage());
				}
			}
			//해당 PROFORMA를 사용하지 않으면  	
			VskPfSkdHisVO vskPfSkdHisVO = new VskPfSkdHisVO();
			
			vskPfSkdHisVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
			vskPfSkdHisVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
			vskPfSkdHisVO.setSimDt(vskPfSkdVO.getSimDt());
			vskPfSkdHisVO.setSimNo(vskPfSkdVO.getSimNo());
			vskPfSkdHisVO.setDiffRmk(vskPfSkdVO.getPfSkdRmk());
			vskPfSkdHisVO.setCreUsrId(account.getUsr_id());
			vskPfSkdHisVO.setUpdUsrId(account.getUsr_id());
			
			//VSK_PF_SKD_HID 이력 테이블에 이력을 남긴다
			dbDao.addVskPfSkdHis(vskPfSkdHisVO);
			
			// VSK_PF_CALL_PORT 테이블을 삭제한다.
			VskPfCallPortVO vskPfCallPortVO = new VskPfCallPortVO();
			vskPfCallPortVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
			vskPfCallPortVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
			dbDao.removeVskPfCallPort(vskPfCallPortVO);
			
			//VSK_PF_SKD_DTL 테이블을 삭제한다
			dbDao.removeVskPfSkdDtl(tempVslLlanCd,tempPfSvcTpCd);
			
			//VSK_PF_SKD 테이블을 삭제한다
			dbDao.removeVskPfSkd(tempVslLlanCd,tempPfSvcTpCd);
			
			//Standard Flag을 체크한다
			int returnCntq = dbDao.searchPfStandardCount(vskPfSkdVO);
			
			//Standard P/F Schedule 없을 경우
			if(returnCntq == 0){
				List<VskPfSkdVO> vskPfSkdVOs = dbDao.searchPfSkdNewest(vskPfSkdVO);				
				if(vskPfSkdVOs != null && vskPfSkdVOs.size() > 0){
					VskPfSkdVO updateVO = vskPfSkdVOs.get(0);
					//VSK_PF_SKD을 상세 정보를 UPDATE한다				
					//dbDao.modifyVskPfSkdMstInfo(updateVO);
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
	 * P/F Type Cd가 존재하는지 여부를 조회한다.<br>
	 *  ProformaScheduleMgt화면에 대한 P/F Type Cd에 대한 체크 이벤트 처리<br>
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
	 * P/F SKD Creation Row Delete 이벤트 처리<br>
	 * ProformaScheduleMgt의 선택한 로우(들)을 삭제하고 존재하는 포트에 대한 정보를 재 조합한다.<br>
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
					//2009 12 02 임수석 요청
					//Row Delete시 Delete된 로우는 제외하고 나머지 포트로 
					//그리드를 재 조합한다
					//Distance,Sea Time은 공통이고
					//첫번째 로우의 turn_port_flg = Y,turn_port_ind_cd = N으로 셋팅한다
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
		
						//command.searchPortPairInfo의 파라미터
						//port_cd = 현재 로우의 port_cd
						//pod_loc_cd = 다음 로우의 port_cd
						
						list = dbDao.searchPortPairInfo(paramVo);
						
						if(list != null && list.size() != 0){
							VskPfSkdDtlVO resultV0 = list.get(0);
					
							//searchPortPairInfo 리턴 값을 셋팅한다
							detailVOs.get(i).setLnkDist(resultV0.getLnkDist());
							
							//Sea Time 계산
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
							
							/** Remove logic of setting first port to turning port */
							//::2014-05-09:://detailVOs.get(i).setTurnPortFlg("Y");
							detailVOs.get(i).setTurnPortIndCd("N");
							
						}
						
					}else if(voCnt - i  > 1){
						//첫번째 로우 이후의 공식
						
						//command.searchPortPairInfo의 파라미터
						//port_cd = 현재 로우의 port_cd
						//pod_loc_cd = 다음 로우의 port_cd
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
							
							//searchPortPairInfo 리턴 값을 셋팅한다
							detailVOs.get(i).setLnkDist(resultV0.getLnkDist());
							
							//Sea Time 계산
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
		
				/** Remove logic of setting first port to turning port */
				//::2014-05-09:://detailVOs.get(secondSkdDirPos).setTurnPortFlg("Y");
				//::2014-05-09:://detailVOs.get(secondSkdDirPos).setTurnPortIndCd("Y");
	
				VskPfSkdDtlVO  lastVO = detailVOs.get(detailVOs.size()-1);
				//첫번째 로우의 Terminal Code를 마지막 로우에 셋팅한다
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
     * VSK 모듈에서 데이터를 받아서 Sim 테이블에 저장한다.
     * 
     * @param pfSkdGRPVO PfSkdGRPVO
     * @param ind Strig [I:신규,U:수정]
     * @param account
     * @return List<CoaSimInfoVO>
     * @throws EventException
     */
    public List<MasSimInfoVO> createCoaSimRqst(PfSkdGRPVO pfSkdGRPVO, String ind, SignOnUserAccount account) throws EventException{
    	SearchSimLaneListConditionVO searchVo = new SearchSimLaneListConditionVO();
    	Map<String, Object> param = new HashMap<String, Object>();
    	List<MasSimTmlInfoVO> list = new ArrayList<MasSimTmlInfoVO>();
//    	ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
    	
    	
    	MasSimTmlInfoVO tmlVo = null;
    	DBRowSet rowSet = null;
    	String v_sim_no = "";
    	String v_sim_dt = "";
    	int cnt = 0;
    	
    	
    	//VSK 개발
    	VskPfSkdVO vskPfSkdVO = pfSkdGRPVO.getVskPfSkdVO();
		List<VskPfSkdDtlVO> vskPfSkdDtlVOs = pfSkdGRPVO.getVskPfSkdDtlVOs();
    	try {
    		MasSimTmlInfoVO[] vo = new MasSimTmlInfoVO[vskPfSkdDtlVOs.size()];
    		int len = vskPfSkdDtlVOs.size();

    		for(int i=0; i<len;i++){
    			if(i == len-1){
    				vo[i] = new MasSimTmlInfoVO();
    				int simNoLen = vskPfSkdVO.getSimNo().length();
    				String tempSimNo = vskPfSkdVO.getSimNo();
    				if(simNoLen == 1){
    					tempSimNo = "00"+tempSimNo;
    				}else if(simNoLen == 2){
    					tempSimNo = "0"+tempSimNo;
    				}
        			vo[i].setSimNo(tempSimNo);
        			vo[i].setVslSlanCd(vskPfSkdVO.getVslSlanCd());
        			vo[i].setSimDt(vskPfSkdVO.getSimDt());
        			vo[i].setTmlCd(vskPfSkdDtlVOs.get(i).getPortCd()+vskPfSkdDtlVOs.get(i).getYdCd());
        			vo[i].setSkdDirCd(vskPfSkdDtlVOs.get(i).getSkdDirCd());
        			vo[i].setVslDblCallSeq(vskPfSkdDtlVOs.get(i).getClptSeq());
        			vo[i].setPortSeq(Integer.toString((i+1)));
        			vo[i].setPortDys("0");	
        			vo[i].setSeaDys("0");
        			vo[i].setTurnPortIndCd(vskPfSkdDtlVOs.get(i).getTurnPortIndCd());
        			vo[i].setBzcVslSpd("0");
        			vo[i].setCreUsrId(account.getUsr_id());
        			vo[i].setUpdUsrId(account.getUsr_id());
        			vo[i].setCrnKnt(vskPfSkdDtlVOs.get(i).getCrnKnt());
        			vo[i].setEtbDyNo(vskPfSkdDtlVOs.get(i).getEtbDyNo());
        			vo[i].setEtbDyCd(vskPfSkdDtlVOs.get(i).getEtbDyCd());
        			vo[i].setEtbTmHrmnt(vskPfSkdDtlVOs.get(i).getEtbTmHrmnt());
        			vo[i].setEtdDyNo(vskPfSkdDtlVOs.get(i).getEtdDyNo());
        			vo[i].setEtdDyCd(vskPfSkdDtlVOs.get(i).getEtdDyCd());
        			vo[i].setEtdTmHrmnt(vskPfSkdDtlVOs.get(i).getEtdTmHrmnt());
        			vo[i].setLnkSpd(vskPfSkdDtlVOs.get(i).getLnkSpd());
        			vo[i].setSeaBufSpd(vskPfSkdDtlVOs.get(i).getSeaBufSpd());
        			vo[i].setLnkDist(vskPfSkdDtlVOs.get(i).getLnkDist());
        			vo[i].setTztmHrs(vskPfSkdDtlVOs.get(i).getTztmHrs());
        			vo[i].setSeaBufHrs(vskPfSkdDtlVOs.get(i).getSeaBufHrs());
        			vo[i].setMnvrInHrs(vskPfSkdDtlVOs.get(i).getMnvrInHrs());
        			vo[i].setMnvrOutHrs(vskPfSkdDtlVOs.get(i).getMnvrOutHrs());
        			vo[i].setPortBufHrs(vskPfSkdDtlVOs.get(i).getPortBufHrs());
        			vo[i].setActWrkHrs(vskPfSkdDtlVOs.get(i).getActWrkHrs());
        			vo[i].setTmlProdQty(vskPfSkdDtlVOs.get(i).getTmlProdQty());
        			vo[i].setIbIpcgoQty(vskPfSkdDtlVOs.get(i).getIbIpcgoQty());
        			vo[i].setIbOcnCgoQty(vskPfSkdDtlVOs.get(i).getIbOcnCgoQty());
        			vo[i].setObIpcgoQty(vskPfSkdDtlVOs.get(i).getObIpcgoQty());
        			vo[i].setObOcnCgoQty(vskPfSkdDtlVOs.get(i).getObOcnCgoQty());
        			vo[i].setTurnPortFlg(vskPfSkdDtlVOs.get(i).getTurnPortFlg());
        			vo[i].setCallYdIndSeq(vskPfSkdDtlVOs.get(i).getCallYdIndSeq());
        			vo[i].setPortUsdAmt("0");
        			vo[i].setPortCd(vskPfSkdDtlVOs.get(i).getPortCd());
        			vo[i].setSvcDurDys(vskPfSkdDtlVOs.get(i).getSvcDurDys());
    			}else{
    				vo[i] = new MasSimTmlInfoVO();
    				int simNoLen = vskPfSkdVO.getSimNo().length();
    				String tempSimNo = vskPfSkdVO.getSimNo();
    				if(simNoLen == 1){
    					tempSimNo = "00"+tempSimNo;
    				}else if(simNoLen == 2){
    					tempSimNo = "0"+tempSimNo;
    				}
        			vo[i].setSimNo(tempSimNo);
        			vo[i].setSimDt(vskPfSkdVO.getSimDt());
        			vo[i].setVslSlanCd(vskPfSkdVO.getVslSlanCd());
        			vo[i].setTmlCd(vskPfSkdDtlVOs.get(i).getPortCd()+vskPfSkdDtlVOs.get(i).getYdCd());
        			vo[i].setSkdDirCd(vskPfSkdDtlVOs.get(i).getSkdDirCd());
        			vo[i].setVslDblCallSeq(vskPfSkdDtlVOs.get(i).getClptSeq());
        			vo[i].setPortCd(vskPfSkdDtlVOs.get(i).getPortCd());
        			vo[i].setSvcDurDys(vskPfSkdDtlVOs.get(i).getSvcDurDys());
        			//vo[i].setPortSeq(vskPfSkdDtlVOs.get(i).getPortRotnSeq());
        			vo[i].setPortSeq(Integer.toString((i+1)));
        			//현재 포트의 Working H + Port Buffer
        			double dSumPortDys = Double.parseDouble(vskPfSkdDtlVOs.get(i).getActWrkHrs()) + Double.parseDouble(vskPfSkdDtlVOs.get(i).getPortBufHrs());
        			if( 0 < Double.compare(dSumPortDys,0)){
        				double dTempPortDys = dSumPortDys / 24;
        				double iTempDys = 0;
        				BigDecimal bigTempPortDys = null;
        				BigDecimal bigPortDys = new BigDecimal(dTempPortDys);
        				bigTempPortDys = bigPortDys.setScale(1,bigPortDys.ROUND_HALF_UP);
        				iTempDys = bigTempPortDys.doubleValue();
        				vo[i].setPortDys(Double.toString(iTempDys));	
        			}else{
        				vo[i].setPortDys("0");	
        			}
        			//SEA_DYS  = MNVR_OUT_HRS(현재 포트) + MNVR_IN_HRS(다음 포트) + TZTM_HRS(현재 포트) + SEA_BUF_HRS(현재 포트) + (현재 포트 ZD - 다음 포트 ZD )
        			double dSumSeaDys = Double.parseDouble(vskPfSkdDtlVOs.get(i).getTztmHrs()) + Double.parseDouble(vskPfSkdDtlVOs.get(i).getSeaBufHrs())
        								+ Double.parseDouble(vskPfSkdDtlVOs.get(i).getMnvrOutHrs())+ Double.parseDouble(vskPfSkdDtlVOs.get(i+1).getMnvrInHrs()) 
        								+ (Double.parseDouble(vskPfSkdDtlVOs.get(i).getZd())) - Double.parseDouble((vskPfSkdDtlVOs.get(i+1).getZd()));
        			
        			if(0 < Double.compare(dSumSeaDys,0)){
        				double dTempSeaDys = dSumSeaDys / 24;
        				double dSeaDys = 0;
        				BigDecimal bigTempSeaDys = null;
        				BigDecimal bigSeaDys = new BigDecimal(dTempSeaDys);
        				bigTempSeaDys = bigSeaDys.setScale(1,bigSeaDys.ROUND_HALF_UP);
        				dSeaDys = bigTempSeaDys.doubleValue();
        				vo[i].setSeaDys(Double.toString(dSeaDys));
        			}else{
        				vo[i].setSeaDys("0");
        			}
        			vo[i].setTurnPortIndCd(vskPfSkdDtlVOs.get(i).getTurnPortIndCd());
        			vo[i].setBzcVslSpd("0");
        			vo[i].setCreUsrId(account.getUsr_id());
        			vo[i].setUpdUsrId(account.getUsr_id());
        			vo[i].setCrnKnt(vskPfSkdDtlVOs.get(i).getCrnKnt());
        			vo[i].setEtbDyNo(vskPfSkdDtlVOs.get(i).getEtbDyNo());
        			vo[i].setEtbDyCd(vskPfSkdDtlVOs.get(i).getEtbDyCd());
        			vo[i].setEtbTmHrmnt(vskPfSkdDtlVOs.get(i).getEtbTmHrmnt());
        			vo[i].setEtdDyNo(vskPfSkdDtlVOs.get(i).getEtdDyNo());
        			vo[i].setEtdDyCd(vskPfSkdDtlVOs.get(i).getEtdDyCd());
        			vo[i].setEtdTmHrmnt(vskPfSkdDtlVOs.get(i).getEtdTmHrmnt());
        			vo[i].setLnkSpd(vskPfSkdDtlVOs.get(i).getLnkSpd());
        			vo[i].setSeaBufSpd(vskPfSkdDtlVOs.get(i).getSeaBufSpd());
        			vo[i].setLnkDist(vskPfSkdDtlVOs.get(i).getLnkDist());
        			vo[i].setTztmHrs(vskPfSkdDtlVOs.get(i).getTztmHrs());
        			vo[i].setSeaBufHrs(vskPfSkdDtlVOs.get(i).getSeaBufHrs());
        			vo[i].setMnvrInHrs(vskPfSkdDtlVOs.get(i).getMnvrInHrs());
        			vo[i].setMnvrOutHrs(vskPfSkdDtlVOs.get(i).getMnvrOutHrs());
        			vo[i].setPortBufHrs(vskPfSkdDtlVOs.get(i).getPortBufHrs());
        			vo[i].setActWrkHrs(vskPfSkdDtlVOs.get(i).getActWrkHrs());
        			vo[i].setTmlProdQty(vskPfSkdDtlVOs.get(i).getTmlProdQty());
        			vo[i].setIbIpcgoQty(vskPfSkdDtlVOs.get(i).getIbIpcgoQty());
        			vo[i].setIbOcnCgoQty(vskPfSkdDtlVOs.get(i).getIbOcnCgoQty());
        			vo[i].setObIpcgoQty(vskPfSkdDtlVOs.get(i).getObIpcgoQty());
        			vo[i].setObOcnCgoQty(vskPfSkdDtlVOs.get(i).getObOcnCgoQty());
        			vo[i].setTurnPortFlg(vskPfSkdDtlVOs.get(i).getTurnPortFlg());
        			vo[i].setCallYdIndSeq(vskPfSkdDtlVOs.get(i).getCallYdIndSeq());
        			vo[i].setPortUsdAmt("0");
    			}
    		}
    		
    		if(vo != null){
	    		tmlVo = vo[0];
	    		if (ind.equals("U")){// 1. ind = U 일경우  Report까지 생성되었는지 체크하여  있으면 에러 발생
	    			searchVo.setFSimDt(tmlVo.getSimDt());
	    			searchVo.setFSimNo(tmlVo.getSimNo());
	    			param.put("sim_dt", tmlVo.getSimDt());
	    			param.put("sim_no", tmlVo.getSimNo());
	    			param.put("svc_dur_dys", vskPfSkdVO.getSvcDurDys());
	    			param.put("pf_skd_rmk", vskPfSkdVO.getPfSkdRmk());

//	    			searchVo.setFSimDt("20090713");
//	    			searchVo.setFSimNo("001");
//	    			param.put("sim_dt", "20090713");
//	    			param.put("sim_no", "001");
	    			cnt = dbDao.searchSimProCount(searchVo);
	    			if(cnt>0){	// 1-1. I/F 후 수지분석을 진행했으면 에러 발생
//	    				throw new DAOException(new ErrorHandler("COA00025",errMessage).getMessage());
	    				//---> 예제 : throw new EventException("수지분석 진행 중 입니다.");
	    				//throw new EventException("수지분석 진행 중 입니다.");
	    				throw new EventException(new ErrorHandler("COA00032").getMessage());
	    			} else {	// 1-2. 작업을 하지 않았으면 coa_sim_tml_info 테이블에 데이터 Update
		    			
	    				param.put("vsl_slan_cd", tmlVo.getVslSlanCd());
		    			param.put("svc_dur_dys", tmlVo.getSvcDurDys());
		    			param.put("pf_skd_rmk", vskPfSkdVO.getPfSkdRmk());
		    			
	    				for(int i=0; i<vo.length; i++){
//		    				vo[i].setSimDt("20090713");
//		    				vo[i].setSimNo("001");
//		    				vo[i].setCreUsrId(account.getUsr_id());
//		    				vo[i].setUpdUsrId(account.getUsr_id());
		    				
		        			vo[i].setVslSlanCd(vskPfSkdVO.getVslSlanCd());
		    				vo[i].setUpdUsrId(account.getUsr_id());
		    				vo[i].setSvcDurDys(vskPfSkdVO.getSvcDurDys()); 
		        			vo[i].setBrthItvalDys(vskPfSkdVO.getBrthItvalDys());
		    				vo[i].setPfSkdRmk(vskPfSkdVO.getPfSkdRmk());
		    				
		    				vo[i].setN1stVslClssCd(vskPfSkdVO.getN1stVslClssCd());
		        			vo[i].setN1stVslClssKnt(vskPfSkdVO.getN1stVslClssKnt());
		        			vo[i].setN2ndVslClssCd(vskPfSkdVO.getN2ndVslClssCd());
		        			vo[i].setN2ndVslClssKnt(vskPfSkdVO.getN2ndVslClssKnt());
		        			vo[i].setN3rdVslClssCd(vskPfSkdVO.getN3rdVslClssCd());
		        			vo[i].setN3rdVslClssKnt(vskPfSkdVO.getN3rdVslClssKnt());
		    				list.add(vo[i]);
		    			}
		    			dbDao.createCoaSimRqst(param, list, ind);
	    			}
	    		} else {
	    			// 2. ind = I 일경우 Sim number를 새로 부여해서 데이터를 입력
	    			//    COPY : [COA_SIM_INFO, COA_SIM_SVC_LANE, COA_SIM_VSL_SET_INFO]
	    			//    INSERT : [COA_SIM_TML_INFO]
	    			
	    			// Max Sim Number를 조회한다.
	    			v_sim_no = dbDao.searchMaxSimNo(); 
	    			v_sim_dt = JSPUtil.getKSTDate().replaceAll("/", "");
					log.debug(" v_sim_dt : " + v_sim_dt);	    			
					log.debug(" v_sim_no : " + v_sim_no);
					
//	    			param.put("f_sim_dt", "20090413");
//	    			param.put("f_sim_no", "001");
	    			param.put("f_sim_dt", tmlVo.getSimDt());
	    			param.put("f_sim_no", tmlVo.getSimNo());
	    			param.put("vsl_slan_cd", tmlVo.getVslSlanCd());
	    			param.put("svc_dur_dys", tmlVo.getSvcDurDys());
	    			param.put("usr_id", account.getUsr_id());
	    			param.put("sim_dt", v_sim_dt);
	    			param.put("sim_no", v_sim_no);

	    			for(int i=0; i<vo.length; i++){
//	    				vo[i].setSimDt("20090413");
//	    				vo[i].setSimNo("001");
	    				vo[i].setSimDt(v_sim_dt);
	    				vo[i].setSimNo(v_sim_no);
	        			vo[i].setVslSlanCd(vskPfSkdVO.getVslSlanCd());
	    				vo[i].setCreUsrId(account.getUsr_id());
	    				vo[i].setUpdUsrId(account.getUsr_id());
	    				vo[i].setSvcDurDys(vskPfSkdVO.getSvcDurDys()); 
	        			vo[i].setBrthItvalDys(vskPfSkdVO.getBrthItvalDys());
//	    				vo[i].setPfSkdRmk(vskPfSkdVO.getPfSkdRmk());
	    				
	        			vo[i].setN1stVslClssCd(vskPfSkdVO.getN1stVslClssCd());
	        			vo[i].setN1stVslClssKnt(vskPfSkdVO.getN1stVslClssKnt());
	        			vo[i].setN2ndVslClssCd(vskPfSkdVO.getN2ndVslClssCd());
	        			vo[i].setN2ndVslClssKnt(vskPfSkdVO.getN2ndVslClssKnt());
	        			vo[i].setN3rdVslClssCd(vskPfSkdVO.getN3rdVslClssCd());
	        			vo[i].setN3rdVslClssKnt(vskPfSkdVO.getN3rdVslClssKnt());
	    				list.add(vo[i]);
	    				
	    			}
	    			dbDao.createCoaSimRqst(param, list, ind);
	    			// COA_SIM_INFO에 신규로 입력한 정보를 조회하여 리턴한다
	    			rowSet = dbDao.searchSimulationNo(v_sim_dt,v_sim_no);
	    		}
	    		
    		}
    		
    		if (rowSet != null){
    			return (List)RowSetUtil.rowSetToVOs(rowSet, MasSimInfoVO .class);
    		}else {
    			return null;
    		}
    		
        } catch (EventException ex) {
            throw ex; 
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
    		throw new EventException(de.getMessage());
    	} catch(Exception e){
    		log.error("err "+e.toString(),e);
    		throw new EventException(e.getMessage());
    	} 
    }
}

    /*================================================================================================================*/

	
	
