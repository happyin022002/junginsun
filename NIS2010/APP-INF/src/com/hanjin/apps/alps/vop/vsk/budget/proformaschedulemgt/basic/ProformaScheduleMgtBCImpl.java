/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtBCImpl.java
*@FileTitle : ProformaScheduleMgtBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
* 2015.07.20 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration.ProformaScheduleMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdHisVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskPfCallPortVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;
 
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
		
			// 입력된 Yard Code가 MDM_YARD에 등록되여 있는지 확인한다.
			String	ydCd		= "";
			int		checkCnt	= 0;
			
			boolean existSvcLane = false;

			//lyjlyj		
			existSvcLane = dbDao.checkExistSvcLane(tempVslLlanCd);
			
			
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
			
			if("O".equals(vslSvcTpCdVal)){
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
				
				if(existSvcLane == false){
					log.info("----------------------------------SVC LANE CODE is Not Exist in MDM------------------------------");
					log.info("----------------------------------------["+tempVslLlanCd+"]----------------------------------------");
					log.info("-------------------------------------------------------------------------------------------------");
				}else{
					if("O".equals(vslSvcTpCdVal) ||
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
				if(vskPfSkdVO.getN1stVslClssKnt() == null || "".equals(vskPfSkdVO.getN1stVslClssKnt())){
					vskPfSkdVO.setN1stVslClssKnt("0");
				}
				if(vskPfSkdVO.getN2ndVslClssKnt() == null || "".equals(vskPfSkdVO.getN2ndVslClssKnt())){
					vskPfSkdVO.setN2ndVslClssKnt("0");
				}
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
					vskPfSkdDtlVOs.get(firstSkdDirPos).setTurnPortFlg("Y");
					vskPfSkdDtlVOs.get(firstSkdDirPos).setTurnPortIndCd("N");
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
			if(existSvcLane == false){
				log.info("----------------------------------SVC LANE CODE is Not Exist in MDM------------------------------");
				log.info("----------------------------------------["+tempVslLlanCd+"]----------------------------------------");
				log.info("-------------------------------------------------------------------------------------------------");
			}else{
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
	//				dbDao.addVskPfSkdHis(vskPfSkdHisVO);
				}
			}
			//마스터 정보(VSK_PF_SKD)를 수정할 경우
			//해당 LANE의 STANDARD FLAG를 N으로 수정하여 저장할 경우 
			//STANDARD FLAG 반드시 필요하므로 searchPfStandardCount 메서드에서 해당 LANE에 대한 PF_TYPE_CD의 STANDARD FLAG를
			//찾아 UPDATE한다 
			int returnCnt = dbDao.searchPfStandardCount(vskPfSkdVO);
			
			if(returnCnt > 1 || returnCnt == 0){
				dbDao.modifyVskPfSkd(vskPfSkdVO,returnCnt);
			}
			
			// dirCdArr[0], dirCdArr[1] 이 같은값, 즉 단방향인 경우는 만들지 않는다.
//			if(dirCdArr!=null && (dirCdArr[0]!=dirCdArr[1])){
//				VskPfCallPortVO vskPfCallPortVO = new VskPfCallPortVO();
//				vskPfCallPortVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
//				vskPfCallPortVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
//				// CHM-201006264-01
//				// vskPfCallPortVO.setCreUsrId(account.getCre_usr_id());
//				vskPfCallPortVO.setCreUsrId(account.getUsr_id());
//				dbDao.removeVskPfCallPort(vskPfCallPortVO);
//				dbDao.addVskPfCallPort(vskPfCallPortVO);
//			}
			
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
//			dbDao.addVskPfSkdHis(vskPfSkdHisVO);
			
			// VSK_PF_CALL_PORT 테이블을 삭제한다.
			VskPfCallPortVO vskPfCallPortVO = new VskPfCallPortVO();
			vskPfCallPortVO.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
			vskPfCallPortVO.setPfSvcTpCd(vskPfSkdVO.getPfSvcTpCd());
//			dbDao.removeVskPfCallPort(vskPfCallPortVO);
			
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
							detailVOs.get(i).setTurnPortFlg("Y");
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
		
				detailVOs.get(secondSkdDirPos).setTurnPortFlg("Y");
				detailVOs.get(secondSkdDirPos).setTurnPortIndCd("Y");
				
	
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
			
			if(tempSetbTm.length() < 2){
				
				//::2014-04-18:://tempSetbTm = "0"+tempSetbTm;
				sbTempSetbTm.append("0");
				sbTempSetbTm.append(tempSetbTm);
				
			}else{
				
				sbTempSetbTm.append(tempSetbTm);
				
			}
			
			int ietbTm = Integer.parseInt(sbTempSetbTm.toString());
			
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
	 * Estimate VVD 정보를 조회합니다.
	 * 
	 * @param String vslCd
	 * @return List<VvdPortLaneOtherVO>
	 * @exception EventException
	 */
	public List<VvdPortLaneOtherVO> searchEstVvdList(String vslCd) throws EventException {
		try {
			return dbDao.searchEstVvdList(vslCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
}