/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TaaOftAutoRatingBCImpl.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.27
 *@LastModifier : 김태경
 *@LastVersion : 1.0
 * 2009.12.27 김태경
 * 1.0 Creation
 * 2012.06.20 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 * 2012.11.29 조정민 [CHM-201221300] TAA 계약 존재시 bkg 생성및 변경시점 Rate 유무 체크 및 G/W 연계 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration.TaaOftAutoRatingDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-TaaOftAutoRating Business Logic Command Interface<br>
 * - NIS2010-TaaOftAutoRating 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Kim tae kyoung
 * @see Esm_bkg_1076EventResponse 참조
 * @since J2EE 1.6
 */

public class TaaOftAutoRatingBCImpl extends BasicCommandSupport implements TaaOftAutoRatingBC{

	
	// Database Access Object
	private transient TaaOftAutoRatingDBDAO dbDao = null;

	/**
	 * BlRatingBCImpl 객체 생성<br>
	 * BlRatingDBDAO를 생성한다.<br>
	 */
	public TaaOftAutoRatingBCImpl() {
		dbDao = new TaaOftAutoRatingDBDAO();
	}
	
	/**
	 * EsmBkg1076 조회 이벤트 처리<br>
	 * Booking TAEOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 Taa No중에서 구주향발 Cargo에 대한 운임 산정 서비스호출
	 * 
	 * @author Kim tae kyoung
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String taaNo
 	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchTaaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchTaaOftAutoratingListVO> searchTaaOftAutoratingList (String bkgNo, String caFlag,String taaNo, String rtAplyDt, String scpCd ,String cmdtCd) throws EventException {
		try {
			List<SearchTaaOftAutoratingListVO> list = dbDao.searchTaaOftAutoratingList(bkgNo, caFlag,taaNo, rtAplyDt, scpCd, cmdtCd);
			return manageAmount(list);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	
	/**
	 * EsmBkg1076 조회 이벤트 처리<br>
	 * Booking AsiaEurope AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 TAA No중에서 미주향발 Cargo에 대한 운임 산정 서비스호출
	 * 
	 * @author Kim tae kyoung
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @return List<SearchTaaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchTaaOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd,String cmdtCd, String ctrtTpCd) throws EventException {
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
	 * @param List<SearchTaaOftAutoratingListVO> list
	 * @return SearchTaaOftAutoratingListVO
	 * @exception EventException
	 */
	private List<SearchTaaOftAutoratingListVO> manageAmount(List<SearchTaaOftAutoratingListVO> list) throws EventException{
		
		int k = list.size();
		
		
		double oarb_fnl_amt[] = new double [k] ;  // OARB AMT
		double oa_fnl_frt_rt_amt[]   = new double [k] ; // OA AMT
		double fnl_frt_rt_amt [] = new double [k]; // Final AMT 
		double rt_fnl_frt_rt_amt [] = new double [k];  // THR AMT
		double rt_calc_frt_rt_amt [] = new double [k]; // CALC AMT 
		double rt_app_frt_rt_amt [] = new double [k]; // RT AMT
		double rt_typ_frt_rt_amt [] = new double [k]; // TYP AMT
		double rt_rac_frt_rt_amt [] = new double [k]; // RAC AMT
		
		double oa_typ_frt_rt_amt [] = new double [k];
		double oa_rac_frt_rt_amt [] = new double [k];
		double rt_arb_frt_rt_amt [] = new double [k];
		
		for(int j = 0; j< list.size(); j++){
			
			
			rt_fnl_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtFnlFrtRtAmt(),"0"));
			rt_calc_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtCalcFrtRtAmt(),"0"));
			rt_app_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtAppFrtRtAmt(),"0"));
			rt_typ_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtTypFrtRtAmt(),"0"));
			rt_rac_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtRacFrtRtAmt(),"0"));
			
			oa_fnl_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOaFnlFrtRtAmt(), "0")); //OA_FNL_FRT_RT_AMT
			oa_typ_frt_rt_amt[j] =  Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOaTypFrtRtAmt(),"0")); //oa_typ_frt_rt_amt 
			oa_rac_frt_rt_amt[j] =  Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOaRacFrtRtAmt(),"0")); //oa_rac_frt_rt_amt 
       
			rt_arb_frt_rt_amt[j]         = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtArbFrtRtAmt(), "0"));           //rt_arb_frt_rt_amt
			
		}
		
		for(int i = 0; i< list.size(); i++){
			
			log.debug("rt_fnl_frt_rt_amt"+rt_fnl_frt_rt_amt[i]);
			log.debug("rt_calc_frt_rt_amt"+rt_calc_frt_rt_amt[i]);
			log.debug("rt_app_frt_rt_amt"+rt_app_frt_rt_amt[i]);
			log.debug("rt_typ_frt_rt_amt"+rt_typ_frt_rt_amt[i]);
			log.debug("rt_rac_frt_rt_amt"+rt_rac_frt_rt_amt[i]);
			log.debug("fnl_frt_rt_amt!!"+fnl_frt_rt_amt[i]);
			
			if("F".equals(list.get(i).getRtArbRtApplTpCd())){
				oarb_fnl_amt[i] = rt_arb_frt_rt_amt[i]; // Fixed Amount인 경우 빠져나와 이값을 사용함 
				oa_fnl_frt_rt_amt[i] = rt_arb_frt_rt_amt[i];
			}else{ // conv_tp_cd 가 "C" 인 경우만 절차적으로 확인하여 AMT 값 구함 	
				
				if(list.get(i).getOaRacBkgConvTpCd().equals("C")){
					 if(list.get(i).getOaRacRtOpCd().equals("*")){
						 oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * oa_rac_frt_rt_amt[i];
					}
					else if(list.get(i).getOaRacRtOpCd().equals("/")){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / oa_rac_frt_rt_amt[i];
					}
				}
				
				if(list.get(i).getOaTypBkgConvTpCd().equals("C")){
					 if(list.get(i).getOaTypRtOpCd().equals("*")){
						 oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * oa_typ_frt_rt_amt[i];
					}
					else if(list.get(i).getOaTypRtOpCd().equals("/")){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / oa_typ_frt_rt_amt[i];
					}
				}
				oarb_fnl_amt[i] = oa_fnl_frt_rt_amt[i] ;
			}
			
			log.debug("************oarb_fnl_amt!!"+oarb_fnl_amt[i]);
			
			if(list.get(i).getRtTypBkgConvTpCd().equals("C")){
				if(list.get(i).getRtTypRtOpCd().equals("+")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_typ_frt_rt_amt[i];
				}
				else if(list.get(i).getRtTypRtOpCd().equals("-")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_typ_frt_rt_amt[i];
				}
				else if(list.get(i).getRtTypRtOpCd().equals("*")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_typ_frt_rt_amt[i];
				}
				else if(list.get(i).getRtTypRtOpCd().equals("/")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_typ_frt_rt_amt[i];
				}
			}
			log.debug("fnl_frt_rt_amt"+rt_fnl_frt_rt_amt[i]);
			if(list.get(i).getRtRacBkgConvTpCd().equals("C")){
				if(list.get(i).getRtTypRtOpCd().equals("+")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_rac_frt_rt_amt[i];
				}
				else if(list.get(i).getRtTypRtOpCd().equals("-")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_rac_frt_rt_amt[i];
				}
				else if(list.get(i).getRtTypRtOpCd().equals("*")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_rac_frt_rt_amt[i];
				}
				else if(list.get(i).getRtTypRtOpCd().equals("/")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_rac_frt_rt_amt[i];
				}
			}
			if(list.get(i).getRtAppBkgConvTpCd().equals("C")){
				if(list.get(i).getRtRacRtOpCd().equals("+")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_app_frt_rt_amt[i];
				}
				else if(list.get(i).getRtRacRtOpCd().equals("-")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_app_frt_rt_amt[i];
				}
				else if(list.get(i).getRtRacRtOpCd().equals("*")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_app_frt_rt_amt[i];
				}
				else if(list.get(i).getRtRacRtOpCd().equals("/")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_app_frt_rt_amt[i];
				}
			}

			/* ROUND  로직 적용  2010.01.03 */
			/* S/C 와 동일하게 SvcScpCd 별로 적용 한다  */
			/* ROUND 로직 재적용 2010.04.14 강성재씨 요청 
			 * RtTypBkgConvTpCd 이 C 가 아닌경우 Round 적용 하지 않음
			 * TYPE CONVERSION 일 때만 Round 적용 
			 * */
			

			if(list.get(0).getSvcScpCd().equals("TPW")|list.get(0).getSvcScpCd().equals("ACW")|list.get(0).getSvcScpCd().equals("MXW")
			  |list.get(0).getSvcScpCd().equals("TAE")|list.get(0).getSvcScpCd().equals("ASE")|list.get(0).getSvcScpCd().equals("MME")
			  |list.get(0).getSvcScpCd().equals("SAS")|list.get(0).getSvcScpCd().equals("CLS")|list.get(0).getSvcScpCd().equals("CLN")
			  |list.get(0).getSvcScpCd().equals("BRE")|list.get(0).getSvcScpCd().equals("CAS")|list.get(0).getSvcScpCd().equals("CAN")){
				/* +,- 는 0 이 아닌 Conv, *,/ 은 1 이 아닌경우 Conv 만 Round 적용 한다 */	
				/* TYPE CONVERSION 일 때만 Round 적용  */
				if("C".equals(list.get(i).getRtTypBkgConvTpCd())){
					if(("+".equals(list.get(i).getRtTypRtOpCd()) && "0".equals(list.get(i).getRtTypFrtRtAmt()))
					  ||("-".equals(list.get(i).getRtTypRtOpCd()) && "0".equals(list.get(i).getRtTypFrtRtAmt()))
					  ||("*".equals(list.get(i).getRtTypRtOpCd()) && "1".equals(list.get(i).getRtTypFrtRtAmt()))
					  ||("/".equals(list.get(i).getRtTypRtOpCd()) && "1".equals(list.get(i).getRtTypFrtRtAmt()))){
							//계산하지않음
						log.debug("do not calculation");
					}else{
						rt_fnl_frt_rt_amt[i] = this.runPointProcess(1,rt_fnl_frt_rt_amt[i]);
					}
				}
				/* +,- 는 0 이 아닌 Conv, *,/ 은 1 이 아닌경우 Conv 만 Round 적용 한다 */	
			}else if(list.get(0).getSvcScpCd().equals("TPE")|list.get(0).getSvcScpCd().equals("ACE")|list.get(0).getSvcScpCd().equals("MXE")){
				
				if("C".equals(list.get(i).getOaTypBkgConvTpCd())){
					if("+".equals(list.get(i).getOaRacRtOpCd()) ||"-".equals(list.get(i).getOaRacRtOpCd())
						||("*".equals(list.get(i).getOaRacRtOpCd()) && "1.0".equals(oa_typ_frt_rt_amt[i]+""))
						||("/".equals(list.get(i).getOaRacRtOpCd()) && "1.0".equals(oa_typ_frt_rt_amt[i]+""))){
							//계산하지않음
						log.debug("do not calculation");
					}else{
						log.debug("2 row  " +oa_fnl_frt_rt_amt[i]);
						oarb_fnl_amt[i] = this.runPointProcess(3,oa_fnl_frt_rt_amt[i]);
						log.debug("22 row  " +oa_fnl_frt_rt_amt[i]);
					}
				}
				/* TYPE CONVERSION 일 때만 Round 적용  */
				if("C".equals(list.get(i).getRtTypBkgConvTpCd())){
					if (("+".equals(list.get(i).getRtTypRtOpCd()) && "0".equals(list.get(i).getRtTypFrtRtAmt()))
							  ||("-".equals(list.get(i).getRtTypRtOpCd()) && "0".equals(list.get(i).getRtTypFrtRtAmt()))
							  ||("*".equals(list.get(i).getRtTypRtOpCd()) && "1".equals(list.get(i).getRtTypFrtRtAmt()))
							  ||("/".equals(list.get(i).getRtTypRtOpCd()) && "1".equals(list.get(i).getRtTypFrtRtAmt()))) {
						//계산하지않음
						log.debug("do not calculation");
					} else {
						rt_fnl_frt_rt_amt[i] = this.runPointProcess(3,rt_fnl_frt_rt_amt[i]);
					}
				}
			}else{
				/* Defalut 로 소수점 2째자리에서 Round 처리 한다 */
				rt_fnl_frt_rt_amt[i]  = (double)Math.round(rt_fnl_frt_rt_amt[i] +0.005d);
				oarb_fnl_amt[i] = (double)Math.round(oarb_fnl_amt[i] +0.005d);
			}

			fnl_frt_rt_amt[i] =  rt_fnl_frt_rt_amt[i] ;
			list.get(i).setOaCalcFrtRtAmt(String.valueOf(oarb_fnl_amt[i]));
			list.get(i).setRtCalcFrtRtAmt(String.valueOf(fnl_frt_rt_amt[i]));
			fnl_frt_rt_amt[i] = fnl_frt_rt_amt[i] + oarb_fnl_amt[i];
			list.get(i).setFnlFrtRtAmt(String.valueOf(fnl_frt_rt_amt[i]));
			list.get(i).setCalcCtrtTpCd("T");//계산시 사용된 Contract Type Setting. 추후 심사에서 사용
				
		}
		return list ;
		
	}
	
	/**
	 * runPointProcess	
	 * 조건구간에 따른 결과값을 계산해서 리턴한다.<br>
	 * @param type,amount
	 * @exception 
	 */
	 private int runPointProcess(int type, Object amount){
		 String tmpAmount 	= String.valueOf(amount).trim();
		 log.debug("String tmpAmount="+tmpAmount);
		 double  fAmount 	= Double.parseDouble(tmpAmount);
		 log.debug("double  fAmount="+fAmount);
		 int len  			= tmpAmount.length();	 //문자열길이
		 log.debug("int len="+len);
		 int point 			= tmpAmount.indexOf(".");//point 존재 
		 log.debug("int point="+point);
		 //[START]------------- 	구간 값 설정 	 -------------//
		 if(point>0){ // point 존재 
			 int sPoint = point-1;
			 int ePoint = point+2;
			 tmpAmount = tmpAmount.substring(sPoint,ePoint);
		 
		 }else{// point 미존재 
			 tmpAmount = tmpAmount.substring(len-1);
		 }
		//[END]------------- 	구간 값 설정	  -------------//
		 
		 double  dAmount = Double.parseDouble(tmpAmount);
		 log.debug("runPointProcess dAmount="+dAmount);
			
		//[START]------------- 조건구간에 따른  구분  설정  -------------//

		 switch (type) {
		 
		 	// 1. OFT인경우 [ 0 초과 5 이하인 경우 = 5] ~ [5 초과 10 이하인 경우= 0]
		case 1:
			// (0.0d < dAmount && dAmount <= 5.0d) R4J 결함 복구 
			if (0 < Double.compare(dAmount, 0.0d) && 0 >= Double.compare(dAmount, 5.0d)){
				fAmount = (double) Math.floor(fAmount * 0.1d);// 소숫점만든후 절삭
				log.debug("~~~~"+fAmount);
				fAmount = fAmount * 10d + 5d;// 복원후 5 더하기
				log.debug("~~~~!"+fAmount);
			} else {
				fAmount = (double) Math.floor(fAmount);// 소숫점 절삭
				fAmount = Math.round(fAmount * 0.1d) * 10d;// 소숫점만든후 반올림후 다시 복원
			}
			break;
			
			// 2. BUC,FRC [ 0.5미만일경우 소숫점 버림 ,0.5 이상인경우 반올림 
		case 2:
			// (0.5d > dAmount) R4J 결함 복구 
			if (0 > Double.compare(dAmount,0.5d)){
				fAmount = (double) Math.floor(fAmount);// 소숫점 절삭
			} else {
				fAmount = Math.round(fAmount);// 반올림
			}
			break;
			
			// 3. BUC,FRC 이외의 조건일경우  0 이상  2.5 미만 =0 ,02.5이상  7.5 미만 =5 ,7.5 이상=반올림
			// 4. TPE,ACE,MXE 0이상~ 2.5미만= 0, 2.5이상 ~7.5미만 =5 , 7.5이상 = 반올림 0
		case 3:
			// (0.0d <= dAmount && dAmount < 2.5d) R4J 결함 복구
			if (0 <= Double.compare(dAmount,0.0d) && 0 > Double.compare(dAmount, 2.5d)){
				fAmount = (double) Math.floor(fAmount * 0.1d);// 소숫점만든후 절삭
				fAmount = fAmount * 10d ;// 복원
			// (2.5d <= dAmount && dAmount < 7.5d) R4J 결함 복구				
			}else if (0 <= Double.compare(dAmount,2.5d) && 0 > Double.compare(dAmount, 7.5d)){
				fAmount = (double) Math.floor(fAmount * 0.1d);// 소숫점만든후 절삭
				fAmount = fAmount * 10d + 5d;// 복원후 5 더하기
			//	(7.5d <= dAmount ) R4J 결함 복구					
			}else if ( 0 <= Double.compare(dAmount,7.5d)){
				fAmount = (double) Math.floor(fAmount);// 소숫점 절삭
				fAmount = Math.round(fAmount * 0.1d) * 10d;// 소숫점만든후 반올림후 다시 복원
			}
			break;
			// 
		case 4:
						
			break;
		default:
			break;
		}
		//[END]------------- 조건구간에 따른  구분  설정  -------------//
		 
		 return (int)fAmount;
	 }
	 
	 
		/**
		 * EsmBkg007901 searchPreCheckRtAplyDt 조회 이벤트 처리
		 * Taa OFT계산 가능 여부를 확인하기를 위해 Rate Application Date를 YYYYMMDD 형식으로 조회
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
				throw new EventException((String) new ErrorHandler("BKG00629").getUserMessage(),ex);
			} catch (Exception ex) {
				throw new EventException((String) new ErrorHandler("BKG00629").getUserMessage(),ex);
			}
			
		}

		
		/**
		 * EsmBkg007901 checkOftRateMatch 조회 이벤트 처리
		 * Taa OFT계산결과를 체크한다.
		 * @param String bkgNo
		 * @param String caFlg
		 * @return String
		 * @throws EventException
		 */
		public String checkOftRateMatch(String bkgNo, String caFlg) throws EventException{
			try {
				return dbDao.checkOftRateMatch(bkgNo,caFlg);
				 
			} catch (DAOException ex) {
				throw new EventException((String) new ErrorHandler("BKG00629").getUserMessage(),ex);
			} catch (Exception ex) {
				throw new EventException((String) new ErrorHandler("BKG00629").getUserMessage(),ex);
			}
			
		}
}