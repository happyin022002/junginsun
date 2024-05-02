/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation
 * 2012.03.08 김진주 [CHM-201216674] 오토레이팅 결과 Display 로직 보완
 * 2012.06.20 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 * 2012.12.18 김진주 [CHM-201220395-04] Add-on management T/F
 * 2013.01.25 김진주 [CHM-201322627] [RFA Information보완] Final 계산값 및 DTL 화면 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration.RfaOftAutoRatingDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgCntrVgmInfoListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-RfaOftAutoRating Business Logic Command Interface<br>
 * - NIS2010-RfaOftAutoRating 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author LEE JINSEO
 * @see Esm_bkg_0739EventResponse 참조
 * @since J2EE 1.6
 */

public class RfaOftAutoRatingBCImpl extends BasicCommandSupport implements RfaOftAutoRatingBC{

	
	// Database Access Object
	private transient RfaOftAutoRatingDBDAO dbDao = null;

	/**
	 * BlRatingBCImpl 객체 생성<br>
	 * BlRatingDBDAO를 생성한다.<br>
	 */
	public RfaOftAutoRatingBCImpl() {
		dbDao = new RfaOftAutoRatingDBDAO();
	}
	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking TAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 RFA No중에서 구주향발 Cargo에 대한 운임 산정 서비스호출
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
 	 * @param String rfaNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchRfaOftAutoratingList (String bkgNo, String caFlag,String rfaNo, String rtAplyDt , String scpCd ,String cmdtCd) throws EventException {
		try {
			List<SearchRfaOftAutoratingListVO> list = dbDao.searchRfaOftAutoratingList(bkgNo, caFlag, rfaNo, rtAplyDt, scpCd, cmdtCd);
			return manageAmount(list);
//			return dbDao.searchRfaOftAutoratingList(bkgNo,caFlag,scpCd,cmdtCd,Rtaplydt);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking TAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 RFA No중에서 구주향발 Cargo에 대한 운임 산정 서비스호출
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
 	 * @param String rfaNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchRfaFICOftAutoratingList (String bkgNo, String caFlag,String rfaNo, String rtAplyDt , String scpCd ,String cmdtCd) throws EventException {
		try {
			List<SearchRfaOftAutoratingListVO> list = dbDao.searchRfaFICOftAutoratingList(bkgNo, caFlag, rfaNo, rtAplyDt, scpCd, cmdtCd);
			return manageAmount(list);
//			return dbDao.searchRfaOftAutoratingList(bkgNo,caFlag,scpCd,cmdtCd,Rtaplydt);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking RFA AEE Oft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 RFA No중에서 구주향발 Cargo에 대한 운임 산정 서비스호출
	 * 
	 * @author JJ
	 * @param String bkgNo
	 * @param String caFlag
 	 * @param String rfaNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchRfaAEEOftAutoratingList (String bkgNo, String caFlag,String rfaNo, String rtAplyDt , String scpCd ,String cmdtCd) throws EventException {
		try {
			List<SearchRfaOftAutoratingListVO> list = dbDao.searchRfaAEEOftAutoratingList(bkgNo, caFlag, rfaNo, rtAplyDt, scpCd, cmdtCd);
			return manageAmount(list);
//			return dbDao.searchRfaOftAutoratingList(bkgNo,caFlag,scpCd,cmdtCd,Rtaplydt);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking RFA AEW Oft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 RFA No중에서 구주향발 Cargo에 대한 운임 산정 서비스호출
	 * 
	 * @author JJ
	 * @param String bkgNo
	 * @param String caFlag
 	 * @param String rfaNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchRfaAEWOftAutoratingList (String bkgNo, String caFlag,String rfaNo, String rtAplyDt , String scpCd ,String cmdtCd) throws EventException {
		try {
			List<SearchRfaOftAutoratingListVO> list = dbDao.searchRfaAEWOftAutoratingList(bkgNo, caFlag, rfaNo, rtAplyDt, scpCd, cmdtCd);
			return manageAmount(list);
//			return dbDao.searchRfaOftAutoratingList(bkgNo,caFlag,scpCd,cmdtCd,Rtaplydt);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 구주 Hinterland 업무 개선 T/F 
	 * AEE, AEW Scope에 대해 신규 적용되는 Autorating 로직 적용 기준일자를 확인하여
	 * 신규 로직으로 Rating할지의 여부를 조회한다.
	 * @author JJ
 	 * @param String Rtaplydt
 	 * @param String bkgNo
 	 * @param String caFlg
	 * @return String
	 * @exception EventException
	 */
	public String searchHinterlandApplyFlag(String rtAplyDt, String bkgNo, String caFlg) throws EventException{
		try {
			return dbDao.searchHinterlandApplyFlag(rtAplyDt, bkgNo, caFlg);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Booking AsiaEurope AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 RFA No중에서 미주향발 Cargo에 대한 운임 산정 서비스호출
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd,String cmdtCd, String ctrtTpCd) throws EventException {
		try {
			return dbDao.searchSurchargeAutoratingList(bkgNo,caFlag,scpCd, cmdtCd, ctrtTpCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * manageAmount
	 * 
	 * @param List<SearchRfaOftAutoratingListVO> list
	 * @return SearchRfaOftAutoratingListVO
	 * @exception EventException
	 */
	private List<SearchRfaOftAutoratingListVO> manageAmount(List<SearchRfaOftAutoratingListVO> list) throws EventException{
		
		int k = list.size();
		

		double fnl_frt_rt_amt [] = new double [k]; // Final AMT 
		double rt_fnl_frt_rt_amt [] = new double [k];  // THR AMT
		double oa_fnl_frt_amt [] = new double [k]; // OARB AMT 
		double da_fnl_frt_amt [] = new double [k]; // DARB AMT
		double oi_fnl_frt_amt [] = new double [k]; // OARB AMT 
		double di_fnl_frt_amt [] = new double [k]; // DARB AMT
		double rt_app_frt_rt_amt [] = new double [k]; // RT
		double rt_ras_frt_rt_amt [] = new double [k];
		String rtMtchPattCd[] = new String [k]; // Pattern Code
		
		for(int j = 0; j< list.size(); j++){
			rt_fnl_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtFnlFrtRtAmt(),"0"));
			rt_ras_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtRasFrtRtAmt(),"0"));
			oa_fnl_frt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOaFnlFrtRtAmt(),"0"));
			da_fnl_frt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getDaFnlFrtRtAmt(),"0"));
			oi_fnl_frt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOiFnlFrtRtAmt(),"0"));
			di_fnl_frt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getDiFnlFrtRtAmt(),"0"));
			rtMtchPattCd[j] = list.get(j).getRtMtchPattCd();
		}
		
		for(int i = 0; i< list.size(); i++){

			if(list.get(i).getRtAppBkgConvTpCd().equals("C")){
				if(list.get(i).getRtAppRtOpCd().equals("+")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_app_frt_rt_amt[i];
				}else if(list.get(i).getRtAppRtOpCd().equals("-")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_app_frt_rt_amt[i];
				}else if(list.get(i).getRtAppRtOpCd().equals("*")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_app_frt_rt_amt[i];
				}else if(list.get(i).getRtAppRtOpCd().equals("/")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_app_frt_rt_amt[i];
				}
			}
			if(list.get(i).getRtRasBkgConvTpCd().equals("C")){
				if(list.get(i).getRtRasRtOpCd().equals("+")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_ras_frt_rt_amt[i];
				}else if(list.get(i).getRtRasRtOpCd().equals("-")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_ras_frt_rt_amt[i];
				}else if(list.get(i).getRtRasRtOpCd().equals("*")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_ras_frt_rt_amt[i];
				}else if(list.get(i).getRtRasRtOpCd().equals("/")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_ras_frt_rt_amt[i];
				}
			}
			log.debug("!!rt_fnl_frt_rt_amt"+rt_fnl_frt_rt_amt[i]);
			log.debug("!!oa_fnl_frt_amt"+oa_fnl_frt_amt[i]);
			log.debug("!!da_fnl_frt_amt"+da_fnl_frt_amt[i]);
			log.debug("!!oi_fnl_frt_amt"+oi_fnl_frt_amt[i]);
			log.debug("!!di_fnl_frt_amt"+di_fnl_frt_amt[i]);
			
			if("000000".equals(rtMtchPattCd[i].substring(1, 7))){
				fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i];
			}else if("000".equals(rtMtchPattCd[i].substring(1,4))){
				fnl_frt_rt_amt[i] = da_fnl_frt_amt[i] + di_fnl_frt_amt[i] + rt_fnl_frt_rt_amt[i] ;
			}else if("000".equals(rtMtchPattCd[i].substring(4,7))){
				fnl_frt_rt_amt[i] = oa_fnl_frt_amt[i] + oi_fnl_frt_amt[i] + rt_fnl_frt_rt_amt[i] ;
			}else{
				fnl_frt_rt_amt[i] = oa_fnl_frt_amt[i] + da_fnl_frt_amt[i] + oi_fnl_frt_amt[i] + di_fnl_frt_amt[i] + rt_fnl_frt_rt_amt[i] ;
			}
			
			
			/* [CHM-201216674] 오토레이팅 결과 Display 로직 보완
			 * 소수점 아래 둘째 자리에서 반올림 하도록 변경*/
			oa_fnl_frt_amt[i] = Double.parseDouble(String.format("%.2f", oa_fnl_frt_amt[i]));
			oi_fnl_frt_amt[i] = Double.parseDouble(String.format("%.2f", oi_fnl_frt_amt[i]));
			rt_fnl_frt_rt_amt[i]  = Double.parseDouble(String.format("%.2f", rt_fnl_frt_rt_amt[i]));
			da_fnl_frt_amt[i] = Double.parseDouble(String.format("%.2f", da_fnl_frt_amt[i]));
			di_fnl_frt_amt[i] = Double.parseDouble(String.format("%.2f", di_fnl_frt_amt[i]));
			fnl_frt_rt_amt[i] = Double.parseDouble(String.format("%.2f", fnl_frt_rt_amt[i]));

			log.debug("!!fnl_frt_rt_amt"+fnl_frt_rt_amt[i]);
//			list.get(i).setRtCalcFrtRtAmt(String.valueOf(rt_fnl_frt_rt_amt[i]).substring(0, String.valueOf(rt_fnl_frt_rt_amt[i]).indexOf(".")));
			list.get(i).setRtCalcFrtRtAmt(String.valueOf(rt_fnl_frt_rt_amt[i]));
			list.get(i).setOaCalcFrtRtAmt(String.valueOf(oa_fnl_frt_amt[i]));
			list.get(i).setDaCalcFrtRtAmt(String.valueOf(da_fnl_frt_amt[i]));
			list.get(i).setOiCalcFrtRtAmt(String.valueOf(oa_fnl_frt_amt[i]));
			list.get(i).setDiCalcFrtRtAmt(String.valueOf(da_fnl_frt_amt[i]));
			list.get(i).setFnlFrtRtAmt(String.valueOf(fnl_frt_rt_amt[i]));
			list.get(i).setCalcCtrtTpCd("R"); //계산시 사용된 Contract Type Setting. 추후 심사에서 사용
			
		}
//		list1.get(i).setFnlFrtRtAmt(fnl_frt_rt_amt[i].substring(0,fnl_frt_rt_amt[i].indexOf(".")));
		
		
		
		return list ;
		
	}	
	
	
	/**
	 * searchPreCheckRtAplyDt 조회 이벤트 처리
	 * RFA OFT계산 가능 여부를 확인하기를 위해 Rate Application Date를 YYYYMMDD 형식으로 조회
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @throws EventException
	 */
	public String searchPreCheckRtAplyDt(String bkgNo ,String caFlg) throws EventException{
		try {
			
			return dbDao.searchPreCheckRtAplyDt(bkgNo,caFlg);
			 
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	
	/**
	 * checkOftRateMatch 조회 이벤트 처리
	 * RFA OFT계산결과를 체크한다.
	 * @param String bkgNo
	 * @param String caFlg 
	 * @return String
	 * @throws EventException
	 */
	public String checkOftRateMatch(String bkgNo ,String caFlg) throws EventException{
		try {
			
			return dbDao.checkOftRateMatch(bkgNo,caFlg);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	
	/**
     * RFA OFT 관련 운임 중 IHC 관련 VGM 확인 로직<br>
     * 현재는 India In/Out 관련 Route 에서만 확인하며, Rating 시에는 No Rate를 방지하기 위해 Audit일때만 사용하길 바람.

     * @author Kim Dong Ho
     * @param List<SearchRfaOftAutoratingListVO> rfaOftList, List<BkgCntrVgmInfoListVO> bkgVGMList
     * @return List<SearchRfaOftAutoratingListVO>
     * @exception EventException
     */
    public List<SearchRfaOftAutoratingListVO> checkVGMForIHCCorrection(List<SearchRfaOftAutoratingListVO> rfaOftList, List<BkgCntrVgmInfoListVO> bkgVGMList) throws EventException {
        try {
            
            //log.error("rfaOftList ==> [" + rfaOftList.toString() + "]");
            List<SearchRfaOftAutoratingListVO> rfaOftListFin = new ArrayList<SearchRfaOftAutoratingListVO>();
            
            for(int i = 0; i < rfaOftList.size(); i++) {
                SearchRfaOftAutoratingListVO rfaOftListVo = rfaOftList.get(i);
                
                String polCd = rfaOftListVo.getPolCd();
                String podCd = rfaOftListVo.getPodCd();
                
                if(polCd == null || "".equals(polCd)) {
                    polCd = rfaOftListVo.getPorCd();
                }
                
                if(podCd == null || "".equals(podCd)) {
                    podCd = rfaOftListVo.getDelCd();
                }
                
                // 인도 향/발이 아니면 무조건 List에 담는다. 
                if(!"IN".equals(polCd.substring(0, 2)) && !"IN".equals(podCd.substring(0, 2))) {
                    rfaOftListFin.add(rfaOftListVo);
                    continue;
                }
                
                // THRU Rate 는 무조건 List 에 담는다.
                if("000000".equals(rfaOftListVo.getRtMtchPattCd().substring(1, 7))) {
                    rfaOftListFin.add(rfaOftListVo);
                    continue;
                }
                
                double oa_min_cgo_wgt = 0.0;
                double oa_max_cgo_wgt = 0.0;
                double da_min_cgo_wgt = 0.0;
                double da_max_cgo_wgt = 0.0;
                
                if( ("".equals(rfaOftListVo.getOaMinCgoWgt()) || rfaOftListVo.getOaMinCgoWgt() == null)
                        && ("".equals(rfaOftListVo.getOaMaxCgoWgt()) || rfaOftListVo.getOaMaxCgoWgt() == null) ) {
                    oa_min_cgo_wgt = -99.9;
                    oa_max_cgo_wgt = -99.9;
                } else {
                    if ("".equals(rfaOftListVo.getOaMinCgoWgt()) || rfaOftListVo.getOaMinCgoWgt() == null) {
                        oa_min_cgo_wgt = 0.0;
                    } else {
                        oa_min_cgo_wgt = Double.parseDouble(rfaOftListVo.getOaMinCgoWgt());
                    }
                    
                    if ("".equals(rfaOftListVo.getOaMaxCgoWgt()) || rfaOftListVo.getOaMaxCgoWgt() == null) {
                        oa_max_cgo_wgt = 99.9;
                    } else {
                        oa_max_cgo_wgt = Double.parseDouble(rfaOftListVo.getOaMaxCgoWgt());
                    }
                } 
                
                if( ("".equals(rfaOftListVo.getDaMinCgoWgt()) || rfaOftListVo.getDaMinCgoWgt() == null)
                        && ("".equals(rfaOftListVo.getDaMaxCgoWgt()) || rfaOftListVo.getDaMaxCgoWgt() == null)) {
                    da_min_cgo_wgt = -99.9;
                    da_max_cgo_wgt = -99.9;
                } else { 
                    if ("".equals(rfaOftListVo.getDaMinCgoWgt()) || rfaOftListVo.getDaMinCgoWgt() == null) {
                        da_min_cgo_wgt = 0.0;
                    } else {
                        da_min_cgo_wgt = Double.parseDouble(rfaOftListVo.getDaMinCgoWgt());
                    }
                    
                    if ("".equals(rfaOftListVo.getDaMaxCgoWgt()) || rfaOftListVo.getDaMaxCgoWgt() == null) {
                        da_max_cgo_wgt = 99.9;
                    } else {
                        da_max_cgo_wgt = Double.parseDouble(rfaOftListVo.getDaMaxCgoWgt());
                    }
                }
                
                boolean isVGMMatch = false;
                int cnt = 0;
                for(int j = 0; j < bkgVGMList.size(); j++) {
                    BkgCntrVgmInfoListVO bkgCntrVgmListVo = bkgVGMList.get(j);
                    
                    // CNTR TP/SZ가 다르면 비교할 필요가 없다.
                    if(!bkgCntrVgmListVo.getCntrTpszCd().equals(rfaOftListVo.getCntrTpszCd())) {
                        continue;
                    }
                    
                    double vgm_wgt = Double.parseDouble(bkgCntrVgmListVo.getVgmWgt());
                    
                    if(   !"000".equals(rfaOftListVo.getRtMtchPattCd().substring(1, 4)) && (oa_min_cgo_wgt <= vgm_wgt && vgm_wgt < oa_max_cgo_wgt)
                       || !"000".equals(rfaOftListVo.getRtMtchPattCd().substring(4, 7)) && (da_min_cgo_wgt <= vgm_wgt && vgm_wgt < da_max_cgo_wgt) ) {
                        cnt++;
                        isVGMMatch = true;
                    }
                }
                
                // VGM에 해당되면 담는다.
                if(isVGMMatch) {
                    //rfaOftListVo.setOpCntrQty(Integer.toString(cnt));
                    rfaOftListFin.add(rfaOftListVo);
                }
            }
            
            //log.error("rfaOftListFin ==> [" + rfaOftListFin.toString() + "]");
            
            return rfaOftListFin;
            
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(),ex);
        }
    }
}