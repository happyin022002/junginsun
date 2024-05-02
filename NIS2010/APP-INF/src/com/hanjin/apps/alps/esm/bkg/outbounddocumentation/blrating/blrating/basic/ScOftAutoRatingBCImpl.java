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
 * 2012.04.26 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
 * 2012.06.20 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 * 2012.09.21 조정민 [CHM-201220212] [ALPS] Charge - 소수점 OFT 레이팅시 조회 수정
 * 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가
 * 2013.01.02 김진주 [CHM-201222141] [오토레이팅 로직] OFT Conversion시 +/- 의 경우 rounding off 로직 제외
 * 2013.04.24 김진주 [CHM-201323001] [BKG/DOC - Revenud Audit System] S/C 적용 B/L 자동심사기능 개발
 * 2013.06.24 김진주 [CHM-201325180] S/C 오토레이팅 RULE CODE 로직 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.math.BigDecimal;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration.ScOftAutoRatingDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargeOftFrightListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargePercentBaseChargeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-ScOftAutoRatingBC Business Logic Command Interface<br>
 * - NIS2010-ScOftAutoRatingBC 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author LEE JINSEO
 * @see Esm_bkg_0269EventResponse 참조
 * @since J2EE 1.6
 */

public class ScOftAutoRatingBCImpl extends BasicCommandSupport implements ScOftAutoRatingBC{

	
	// Database Access Object
	private transient ScOftAutoRatingDBDAO dbDao = null;

	/**
	 * BlRatingBCImpl 객체 생성<br>
	 * BlRatingDBDAO를 생성한다.<br>
	 */
	public ScOftAutoRatingBCImpl() {
		dbDao = new ScOftAutoRatingDBDAO();
	}

	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 ScETCOft SC No에 대한 운임 산정 서비스호출 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @param String audTpCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScETCOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd, String audTpCd ) throws EventException{
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchScETCOftAutoratingList(bkgNo, caFlag, scNo, rtAplyDt, scpCd, cmdtCd, audTpCd);
			return mangageAmount(list1); // Final Amout 로직에서 AMOUT 값 가져옴
			//return list1;
//			return dbDao.searchScETCOftAutoratingList(bkgNo, caFlag, scpCd, cmdtCd, rtAplyDt);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 SC No에 대한 운임 산정 서비스호출 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @param String audTpCd 

	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTAEOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd, String audTpCd) throws EventException{
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchScTAEOftAutoratingList(bkgNo, caFlag, scNo, rtAplyDt, scpCd, cmdtCd, audTpCd);
			return mangageAmount(list1); // Final Amout 로직에서 AMOUT 값 가져옴
			//return  list1;
//			 return dbDao.searchScTAEOftAutoratingList(bkgNo,caFlag,scpCd, cmdtCd, rtAplyDt);
			 
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 ScTAWOft SC No에 대한 운임 산정 서비스호출
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @param String audTpCd
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTAWOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt , String scpCd ,String cmdtCd, String audTpCd) throws EventException{
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchScTAWOftAutoratingList(bkgNo, caFlag, scNo, rtAplyDt, scpCd, cmdtCd, audTpCd );
			return mangageAmount(list1); // Final Amout 로직에서 AMOUT 값 가져옴
			//return dbDao.searchScTAWOftAutoratingList(bkgNo,caFlag,scpCd, cmdtCd, rtAplyDt);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 ScTPSOft  SC No에 대한 운임 산정 서비스호출 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @param String audTpCd 
 	 * @return List<SearchScTAEOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTPSOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt,String scpCd ,String cmdtCd, String audTpCd) throws EventException{
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchScTPSOftAutoratingList(bkgNo,caFlag,scNo,rtAplyDt,scpCd, cmdtCd, audTpCd);
			return mangageAmount(list1); // Final Amout 로직에서 AMOUT 값 가져옴
			//return  list1;
//			return  dbDao.searchScTPSOftAutoratingList(bkgNo,caFlag,scpCd, cmdtCd);

			 
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 searchSurchargeAutoratingList 에 대한 운임 산정 서비스호출 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @param String ctrtTpCd 
	 * @param String rtaplydt
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd ,String cmdtCd, String ctrtTpCd,String rtaplydt ) throws EventException{
		
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchSurchargeAutoratingList(bkgNo, caFlag, scpCd, cmdtCd, ctrtTpCd, rtaplydt);
//			return manageSurcharge(list1);
			return list1;
//			return dbDao.searchSurchargeAutoratingList(bkgNo,caFlag,scpCd, cmdtCd, ctrtTpCd );

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking ScOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 searchSurchargeAutoratingList 에 대한 운임 산정 서비스호출 
	 * @author LEE JIN SEO
	 * @param ScOftAutoratingListVO vo
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingList(ScOftAutoratingListVO vo ) throws EventException{
		
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchSurchargeAutoratingList(vo);
			/* 2010.04.19 Surcharge 가  비정상적으로 
			 * 입력 되는 Case 경우가 있어  Error 로그 삽입
			 */
			int k = 0;
			k = list1.size();
			BigDecimal chgAmt ;
			BigDecimal chkAmt ;
			for(int i = 0; i<list1.size(); i++){
					if(!"PC".equals(list1.get(i).getRatUtCd())){
						String chgUtAmt = JSPUtil.getNullNoTrim(list1.get(i).getChgUtAmt(),"0.0");
						String rateAsQty = JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0.0");
						String amt = JSPUtil.getNullNoTrim(list1.get(i).getChgAmt(),"0.0");
						
						chkAmt = new BigDecimal(chgUtAmt).multiply(new BigDecimal(rateAsQty));
						chgAmt = new BigDecimal(amt);
//						log.error("SSS1 "+chkAmt.toString()+"=="+chgAmt.toString()+"?"+chkAmt.compareTo(chgAmt));
						/* Rate 와  Rate As 곱한 금액과 Surcharge 에서 넘겨주는 Total 금액이 다를 경우 Error 로그를 삽입 */
						if(chkAmt.compareTo(chgAmt) != 0){
							log.debug("chgUtAmt: "+Double.parseDouble(chgUtAmt));
							log.debug("rateAsQty "+Double.parseDouble(rateAsQty));
							log.debug("Surcharge BKG: "+list1.get(i).getBkgNo()+" PER["+list1.get(i).getRatUtCd()+"]"+" Amount["+list1.get(i).getChgAmt()+"]"+" RATE["+list1.get(i).getChgUtAmt()+"]"+" RATEAS["+list1.get(i).getRatAsQty()+"]");	
						}
					}
			}
			for(int i = 0; i< list1.size(); i++){
				list1.get(i).setFnlFrtRtAmt(vo.getFnlFrtRtAmt());
			}
			/* PC 계산을 로직에서 쿼리로 커버하여 해당 로직 주석 처리*/
//			return manageSurcharge(list1);
			return list1;
//			return dbDao.searchSurchargeAutoratingList(bkgNo,caFlag,scpCd, cmdtCd, ctrtTpCd );

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	

	/**
	 * Tariff 만으로 계산된 Surcharge Rating 결과를 조회
     *
	 * @author LEE JIN SEO
	 * @param ScOftAutoratingListVO vo
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	
	public List<SearchScOftAutoratingListVO> searchTariffSurchargeAutoratingList(ScOftAutoratingListVO vo ) throws EventException{
		
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchTariffSurchargeAutoratingList(vo);
			/* 2010.04.19 Surcharge 가  비정상적으로 
			 * 입력 되는 Case 경우가 있어  Error 로그 삽입
			 */
			int k = 0;
			k = list1.size();
			BigDecimal chgAmt ;
			BigDecimal chkAmt ;
			for(int i = 0; i<list1.size(); i++){
					if(!"PC".equals(list1.get(i).getRatUtCd())){
						String chgUtAmt = JSPUtil.getNullNoTrim(list1.get(i).getChgUtAmt(),"0.0");
						String rateAsQty = JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0.0");
						String amt = JSPUtil.getNullNoTrim(list1.get(i).getChgAmt(),"0.0");
						
						chkAmt = new BigDecimal(chgUtAmt).multiply(new BigDecimal(rateAsQty));
						chgAmt = new BigDecimal(amt);
//						log.error("SSS1 "+chkAmt.toString()+"=="+chgAmt.toString()+"?"+chkAmt.compareTo(chgAmt));
						/* Rate 와  Rate As 곱한 금액과 Surcharge 에서 넘겨주는 Total 금액이 다를 경우 Error 로그를 삽입 */
						if(chkAmt.compareTo(chgAmt) != 0){
							log.debug("chgUtAmt: "+Double.parseDouble(chgUtAmt));
							log.debug("rateAsQty "+Double.parseDouble(rateAsQty));
							log.debug("Surcharge BKG: "+list1.get(i).getBkgNo()+" PER["+list1.get(i).getRatUtCd()+"]"+" Amount["+list1.get(i).getChgAmt()+"]"+" RATE["+list1.get(i).getChgUtAmt()+"]"+" RATEAS["+list1.get(i).getRatAsQty()+"]");	
						}
					}
			}
			for(int i = 0; i< list1.size(); i++){
				list1.get(i).setFnlFrtRtAmt(vo.getFnlFrtRtAmt());
			}
			
			return list1;

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmBkg0269  surchargePercentBaseChargeList 조회  이벤트 처리<br>
	 * Surcharge  AutoRating BaseChargeList 조회  
	 * @author LEE JIN SEO
	 * @return List<SearchSurchargePercentBaseChargeListVO>
	 * @exception EventException
	 */
	public List<SearchSurchargePercentBaseChargeListVO> searchSurchargePercentBaseChargeList() throws EventException{
		try{
			return dbDao.searchSurchargePercentBaseChargeList();
			
		}catch (DAOException ex){
			throw new EventException(ex.getMessage(),ex);
		}catch (Exception ex){
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * EsmBkg0269 surchargeautorating 조회 이벤트 처리<br>
	 * BKG_AUTO_RT_OCN_FRT_TMP 조회 
	 * @author LEE JIN SEO
	 * @return List<SearchSurchargeOftFrightListVO>
	 * @exception EventException
	 */
	private List <SearchSurchargeOftFrightListVO> searchSurchargeOftFrightList() throws EventException{
		try{
			return dbDao.searchSurchargeOftFrightList();
			
		}catch (DAOException ex){
			throw new EventException(ex.getMessage(),ex);
		}catch (Exception ex){
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * EsmBkg0269 surchargeautorating 등록  이벤트 처리<br>
	 * Surcharge  AutoRating 등록
	 * @author LEE JIN SEO
	 * 
	 * @param SearchScOftAutoratingListVO[] vos
	 * @param String usrID
	 * @exception EventException
	 */
	public void manageScInformList(SearchScOftAutoratingListVO[] vos, String usrId) throws EventException {
		try {
			for ( int i=0 ; i < vos.length ; i++) {
				if ( vos[i].getIbflag().equals("U")){

					dbDao.addSurchargreAutoratingList(vos[i],  usrId);					
				}
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
		
	}
	/**
	 * EsmBkg0269 SearchScOftAutoratingListVO 에서 Total Amount 를 계산 합니다.<br>
	 * SearchScOftAutoratingListVO  mangageAmount 계산
	 * 
	 * @author kim tae kyoung
	 * @param List<SearchScOftAutoratingListVO> list1
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	
	private List<SearchScOftAutoratingListVO> mangageAmount(List<SearchScOftAutoratingListVO> list1) throws EventException {
		
		/*** OARB OA ( +, - 계산 SKIP!)*/
		/*

		1. RT_ARB_FRT_RT_AMT 에 값이 있으면 이 금액 그대로 적용하고 끝

		2. OA_FNL_FRT_RT_AMT : 200

		3. (1) TYP : * 0.8 ==> 200 * 0.8 = 160
		   (2) RAC : 
		   (3) RAP : + 200 ==> SKIP! = 160
		   (4) RAR : * 1.2 ==> 160 * 1.2 = 192
		   (5) DOR : 
		   (6) RAS (RT_RAS_FRT_RT_AMT) 순서대로 계산

		*** THR RT ( +, - 계산함)

		*** DARB DA ( +, - 계산 SKIP!)

		*** FINAL RATE = OARB + THR + DARB 이러면 끝
		*/
		
		int i = 0;
		int k = 0;
		k = list1.size();
		
		/* TPE 의 경우 OARB + THR + DARB 만 합산하여 FNL AMOUNT 를 구함
		 * 쿼리 Row 별로 계산하므로 double 및 String 배열로 선언하여 계산 
		 */
				
		double oarb_fnl_amt[] = new double [k] ;  // OARB AMT
		double thr_fnl_amt[]  = new double [k] ; // THR AMT
		double darb_fnl_amt[] = new double [k] ; // DARB AMT
		
		double rt_fnl_frt_rt_amt[]   = new double [k] ; // RT AMT
		double oa_fnl_frt_rt_amt[]   = new double [k] ; // OA AMT
		double da_fnl_frt_rt_amt[]   = new double [k] ; // DA AMT
		double da_rac_frt_rt_amt[]   = new double [k] ; //DA_RAC_FRT_RT_AMT     
		double di_fnl_frt_rt_amt[]   = new double [k] ; //DI_FNL_FRT_RT_AMT
		double oi_fnl_frt_rt_amt[]	 = new double [k] ; //OI_FNL_FRT_RT_AMT
		
	
		StringBuilder sbList2 = new StringBuilder();
		String list2 = "";
		
		// 배열 생성
		for(i=0; i< list1.size(); i++){
			sbList2.append(0<i ? ", " : " ");
		}
		list2 = sbList2.toString();
		
		String[] fnl_frt_rt_amt = list2.split(","); // return total amount
		       
		// 배열 생성
		String[] rt_rap_bkg_conv_tp_cd		= list2.split(",");			//RT_RAP_BKG_CONV_TP_CD       
		String[] rt_rap_note_conv_tp_cd         = list2.split(",");		//RT_RAP_NOTE_CONV_TP_CD  
		String[] rt_rap_rt_op_cd                = list2.split(",");		//RT_RAP_RT_OP_CD         
		String[] rt_rap_curr_cd                 = list2.split(",");		//RT_RAP_CURR_CD          
		double rt_rap_frt_rt_amt[]               = new double [k];		//RT_RAP_FRT_RT_AMT       
		String[] rt_rar_bkg_conv_tp_cd          = list2.split(",");		//RT_RAR_BKG_CONV_TP_CD   
		String[] rt_rar_note_conv_tp_cd         = list2.split(",");		//RT_RAR_NOTE_CONV_TP_CD  
		String[] rt_rar_rt_op_cd                = list2.split(",");		//RT_RAR_RT_OP_CD         
		String[] rt_rar_curr_cd                 = list2.split(",");		//RT_RAR_CURR_CD          
		double rt_rar_frt_rt_amt[]               = new double [k];		//RT_RAR_FRT_RT_AMT       
		String[] rt_dor_bkg_conv_tp_cd          = list2.split(",");		//RT_DOR_BKG_CONV_TP_CD    
		String[] rt_dor_note_conv_tp_cd         = list2.split(",");		//RT_DOR_NOTE_CONV_TP_CD  
		String[] rt_dor_rt_op_cd                = list2.split(",");		//RT_DOR_RT_OP_CD         
		String[] rt_dor_curr_cd                 = list2.split(",");		//RT_DOR_CURR_CD          
		double rt_dor_frt_rt_amt[]               = new double [k];		//RT_DOR_FRT_RT_AMT       
		String[] rt_typ_bkg_conv_tp_cd          = list2.split(",");		//RT_TYP_BKG_CONV_TP_CD   
		String[] rt_typ_note_conv_tp_cd          = list2.split(",");	//RT_TYP_NOTE_CONV_TP_CD  
		String[] rt_typ_rt_op_cd                 = list2.split(",");	//RT_TYP_RT_OP_CD         
		String[] rt_typ_curr_cd                  = list2.split(",");	//RT_TYP_CURR_CD          
		double rt_typ_frt_rt_amt[]                = new double [k];		//RT_TYP_FRT_RT_AMT       
		String[] rt_app_bkg_conv_tp_cd           = list2.split(",");	//RT_APP_BKG_CONV_TP_CD   
		String[] rt_app_note_conv_tp_cd          = list2.split(",");	//RT_APP_NOTE_CONV_TP_CD  
		String[] rt_app_rt_op_cd                 = list2.split(",");	//RT_APP_RT_OP_CD         
		String[] rt_app_curr_cd                  = list2.split(",");	//RT_APP_CURR_CD          
		double rt_app_frt_rt_amt[]                = new double [k];		//RT_APP_FRT_RT_AMT       
		String[] rt_ras_bkg_conv_tp_cd           = list2.split(",");	//RT_RAS_BKG_CONV_TP_CD       
		String[] rt_ras_note_conv_tp_cd          = list2.split(",");	//RT_RAS_NOTE_CONV_TP_CD  
		String[] rt_ras_rt_op_cd                 = list2.split(",");	//RT_RAS_RT_OP_CD         
		String[] rt_ras_curr_cd                  = list2.split(",");	//RT_RAS_CURR_CD          
		double rt_ras_frt_rt_amt[]               = new double [k];		//RT_RAS_FRT_RT_AMT       
		String[] rt_arb_bkg_conv_tp_cd           = list2.split(",");	//RT_ARB_BKG_CONV_TP_CD   
		String[] rt_arb_note_conv_tp_cd          = list2.split(",");	//RT_ARB_NOTE_CONV_TP_CD  
		String[] rt_arb_rt_op_cd                 = list2.split(",");	//RT_ARB_RT_OP_CD         
		String[] rt_arb_rt_appl_tp_cd            = list2.split(",");	//RT_ARB_RT_APPL_TP_CD   
		String[] rt_arb_curr_cd                  = list2.split(",");	//RT_ARB_CURR_CD          
		double rt_arb_frt_rt_amt[]               = new double [k];		//RT_ARB_FRT_RT_AMT       
		String[] rt_add_bkg_conv_tp_cd           = list2.split(",");	//RT_ADD_BKG_CONV_TP_CD       
		String[] rt_add_note_conv_tp_cd          = list2.split(",");	//RT_ADD_NOTE_CONV_TP_CD  
		String[] rt_add_rt_op_cd                 = list2.split(",");	//RT_ADD_RT_OP_CD   
		String[] rt_add_rt_appl_tp_cd            = list2.split(",");	//RT_ADD_RT_APPL_TP_CD        
		String[] rt_add_curr_cd                  = list2.split(",");	//RT_ADD_CURR_CD          
		double rt_add_frt_rt_amt[]                = new double [k];		//RT_ADD_FRT_RT_AMT       
		String[] oa_rap_bkg_conv_tp_cd           = list2.split(",");	//OA_RAP_BKG_CONV_TP_CD      
		String[] oa_rap_note_conv_tp_cd          = list2.split(",");	//OA_RAP_NOTE_CONV_TP_CD  
		String[] oa_rap_rt_op_cd                 = list2.split(",");	//OA_RAP_RT_OP_CD         
		String[] oa_rap_curr_cd                  = list2.split(",");	//OA_RAP_CURR_CD          
		double oa_rap_frt_rt_amt[]                = new double [k];     //OA_RAP_FRT_RT_AMT       
		String[] oa_rar_bkg_conv_tp_cd           = list2.split(",");	//OA_RAR_BKG_CONV_TP_CD       
		String[] oa_rar_note_conv_tp_cd          = list2.split(",");	//OA_RAR_NOTE_CONV_TP_CD  
		String[] oa_rar_rt_op_cd                 = list2.split(",");	//OA_RAR_RT_OP_CD         
		String[] oa_rar_curr_cd                  = list2.split(",");	//OA_RAR_CURR_CD          
		double oa_rar_frt_rt_amt[]                = new double [k];		//OA_RAR_FRT_RT_AMT       
		String[] oa_dor_bkg_conv_tp_cd           = list2.split(",");	//OA_DOR_BKG_CONV_TP_CD   
		String[] oa_dor_note_conv_tp_cd          = list2.split(",");	//OA_DOR_NOTE_CONV_TP_CD  
		String[] oa_dor_rt_op_cd                 = list2.split(",");	//OA_DOR_RT_OP_CD         
		String[] oa_dor_curr_cd                  = list2.split(",");	//OA_DOR_CURR_CD          
		double oa_dor_frt_rt_amt[]                = new double [k];		//OA_DOR_FRT_RT_AMT       
		String[] oa_typ_bkg_conv_tp_cd           = list2.split(",");	//OA_TYP_BKG_CONV_TP_CD       
		String[] oa_typ_note_conv_tp_cd          = list2.split(",");	//OA_TYP_NOTE_CONV_TP_CD  
		String[] oa_typ_rt_op_cd                 = list2.split(",");	//OA_TYP_RT_OP_CD         
		String[] oa_typ_curr_cd                  = list2.split(",");	//OA_TYP_CURR_CD          
		double oa_typ_frt_rt_amt[]                = new double [k];		//OA_TYP_FRT_RT_AMT       
		String[] da_rap_bkg_conv_tp_cd           = list2.split(",");	//DA_RAP_BKG_CONV_TP_CD   
		String[] da_rap_note_conv_tp_cd          = list2.split(",");	//DA_RAP_NOTE_CONV_TP_CD  
		String[] da_rap_da_op_cd                 = list2.split(",");	//DA_RAP_DA_OP_CD         
		String[] da_rap_curr_cd                  = list2.split(",");	//DA_RAP_CURR_CD          
		double da_rap_frt_rt_amt[]                = new double [k];		//DA_RAP_FRT_RT_AMT       
		String[] da_rar_bkg_conv_tp_cd           = list2.split(",");	//DA_RAR_BKG_CONV_TP_CD   
		String[] da_rar_note_conv_tp_cd          = list2.split(",");	//DA_RAR_NOTE_CONV_TP_CD  
		String[] da_rar_da_op_cd                 = list2.split(",");	//DA_RAR_DA_OP_CD         
		String[] da_rar_curr_cd                  = list2.split(",");	//DA_RAR_CURR_CD          
		double da_rar_frt_rt_amt[]                = new double [k];		//DA_RAR_FRT_RT_AMT       
		String[] da_dor_bkg_conv_tp_cd           = list2.split(",");	//DA_DOR_BKG_CONV_TP_CD   
		String[] da_dor_note_conv_tp_cd          = list2.split(",");	//DA_DOR_NOTE_CONV_TP_CD  
		String[] da_dor_da_op_cd                 = list2.split(",");	//DA_DOR_DA_OP_CD         
		String[] da_dor_curr_cd                  = list2.split(",");	//DA_DOR_CURR_CD          
		double da_dor_frt_rt_amt[]                = new double [k];		//DA_DOR_FRT_RT_AMT       
		String[] da_typ_bkg_conv_tp_cd           = list2.split(",");	//DA_TYP_BKG_CONV_TP_CD      
		String[] da_typ_note_conv_tp_cd          = list2.split(",");	//DA_TYP_NOTE_CONV_TP_CD  
		String[] da_typ_da_op_cd                 = list2.split(",");	//DA_TYP_DA_OP_CD         
		String[] da_typ_curr_cd                  = list2.split(",");	//DA_TYP_CURR_CD          
		double da_typ_frt_rt_amt[]                = new double [k];		//DA_TYP_FRT_RT_AMT
		String[] oa_rac_bkg_conv_tp_cd     		= list2.split(","); 	//OA_RAC_BKG_CONV_TP_CD      
		String[] oa_rac_note_conv_tp_cd         = list2.split(",");  	//OA_RAC_NOTE_CONV_TP_CD    
		String[] oa_rac_rt_op_cd                = list2.split(",");  	//OA_RAC_RT_OP_CD           
		String[] oa_rac_curr_cd                 = list2.split(",");  	//OA_RAC_CURR_CD            
		double oa_rac_frt_rt_amt[]               = new double [k];  	//OA_RAC_FRT_RT_AMT         
		String[] rt_rac_bkg_conv_tp_cd          = list2.split(",");  	//RT_RAC_BKG_CONV_TP_CD          
		String[] rt_rac_note_conv_tp_cd         = list2.split(",");  	//RT_RAC_NOTE_CONV_TP_CD    
		String[] rt_rac_rt_op_cd                = list2.split(",");  	//RT_RAC_RT_OP_CD           
		String[] rt_rac_curr_cd                 = list2.split(",");  	//RT_RAC_CURR_CD            
		double rt_rac_frt_rt_amt[]               = new double [k];  	//RT_RAC_FRT_RT_AMT         
		String[] da_rac_bkg_conv_tp_cd          = list2.split(",");  	//DA_RAC_BKG_CONV_TP_CD       
		String[] da_rac_note_conv_tp_cd         = list2.split(",");  	//DA_RAC_NOTE_CONV_TP_CD    
		String[] da_rac_da_op_cd                = list2.split(",");  	//DA_RAC_DA_OP_CD           
		String[] da_rac_curr_cd                 = list2.split(",");  	//DA_RAC_CURR_CD           



		for(i=0; i< list1.size(); i++){ // Final Amount 에서 사용할 변수 다 받아옴
			//float 으로 선언된 부분은 defalut 0  값을 가지도록 함 
			rt_fnl_frt_rt_amt[i]		 = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtFnlFrtRtAmt(), "0")); //RT_FNL_FRT_RT_AMT
			da_fnl_frt_rt_amt[i]		 = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getDaFnlFrtRtAmt(), "0")); //DA_FNL_FRT_RT_AMT
			oa_fnl_frt_rt_amt[i]		 = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getOaFnlFrtRtAmt(), "0")); //OA_FNL_FRT_RT_AMT
			rt_rap_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getRtRapBkgConvTpCd(), " ");	//rt_rap_bkg_conv_tp_cd   
			rt_rap_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getRtRapNoteConvTpCd(), " ");   //rt_rap_note_conv_tp_cd  
			rt_rap_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getRtRapRtOpCd()," ");         //rt_rap_rt_op_cd         
			rt_rap_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtRapCurrCd()," ");          //rt_rap_curr_cd 
			rt_rap_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtRapFrtRtAmt(), "0"));   //rt_rap_frt_rt_amt
			rt_rar_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getRtRarBkgConvTpCd(), " ");   //rt_rar_bkg_conv_tp_cd   
			rt_rar_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getRtRarNoteConvTpCd()," ");    //rt_rar_note_conv_tp_cd  
			rt_rar_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getRtRarRtOpCd()," ");          //rt_rar_rt_op_cd         
			rt_rar_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtRarCurrCd()," ");              //rt_rar_curr_cd          
			rt_rar_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtRarFrtRtAmt(), "0"));   //rt_rar_frt_rt_amt       
			rt_dor_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getRtDorBkgConvTpCd()," ");       //rt_dor_bkg_conv_tp_cd   
			rt_dor_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getRtDorNoteConvTpCd()," ");      //rt_dor_note_conv_tp_cd  
			rt_dor_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getRtDorRtOpCd()," ");           //rt_dor_rt_op_cd         
			rt_dor_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtDorCurrCd()," ");             //rt_dor_curr_cd          
			rt_dor_frt_rt_amt[i]        =  Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtDorFrtRtAmt(), "0"));   //rt_dor_frt_rt_amt       
			rt_typ_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getRtTypBkgConvTpCd()," ");    //rt_typ_bkg_conv_tp_cd   
			rt_typ_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getRtTypNoteConvTpCd()," ");      //rt_typ_note_conv_tp_cd  
			rt_typ_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getRtTypRtOpCd()," ");           //rt_typ_rt_op_cd         
			rt_typ_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtTypCurrCd()," ");             //rt_typ_curr_cd          
			rt_typ_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtTypFrtRtAmt(), "0"));   //rt_typ_frt_rt_amt       
			rt_app_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getRtAppBkgConvTpCd()," ");           //rt_app_bkg_conv_tp_cd   
			rt_app_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getRtAppNoteConvTpCd()," ");      //rt_app_note_conv_tp_cd  
			rt_app_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getRtAppRtOpCd()," ");             //rt_app_rt_op_cd         
			rt_app_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtAppCurrCd()," ");             //rt_app_curr_cd          
			rt_app_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtAppFrtRtAmt(), "0"));    //rt_app_frt_rt_amt       
			rt_ras_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getRtRasBkgConvTpCd()," ");      //rt_ras_bkg_conv_tp_cd   
			rt_ras_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getRtRasNoteConvTpCd()," ");       //rt_ras_note_conv_tp_cd       
			rt_ras_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getRtRasRtOpCd()," ");            //rt_ras_rt_op_cd                 
			rt_ras_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtRasCurrCd()," ");             //rt_ras_curr_cd                 
			rt_ras_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtRasFrtRtAmt(),"0"));     //rt_ras_frt_rt_amt             
			rt_arb_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getRtArbBkgConvTpCd()," ");        //rt_arb_bkg_conv_tp_cd          
			rt_arb_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getRtArbNoteConvTpCd()," ");       //rt_arb_note_conv_tp_cd       
			rt_arb_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getRtArbRtOpCd()," ");             //rt_arb_rt_op_cd              
			rt_arb_rt_appl_tp_cd[i]      = JSPUtil.getNullNoTrim(list1.get(i).getRtArbRtApplTpCd()," ");         //rt_arb_rt_appl_tp_cd              
			rt_arb_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtArbCurrCd()," ");             //rt_arb_curr_cd               
			rt_arb_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtArbFrtRtAmt(), "0"));           //rt_arb_frt_rt_amt
			rt_add_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getRtAddBkgConvTpCd()," ");      //rt_add_bkg_conv_tp_cd         
			rt_add_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getRtAddNoteConvTpCd()," ");       //rt_add_note_conv_tp_cd       
			rt_add_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getRtAddRtOpCd()," ");             //rt_add_rt_op_cd                
			rt_add_rt_appl_tp_cd[i]      = JSPUtil.getNullNoTrim(list1.get(i).getRtAddRtApplTpCd()," ");         //rt_add_rt_appl_tp_cd             
			rt_add_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtAddCurrCd()," ");           //rt_add_curr_cd               
			rt_add_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtAddFrtRtAmt(),"0"));           //rt_add_frt_rt_amt            
			oa_rap_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getOaRapBkgConvTpCd()," ");      //oa_rap_bkg_conv_tp_cd             
			oa_rap_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getOaRapNoteConvTpCd()," ");       //oa_rap_note_conv_tp_cd       
			oa_rap_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getOaRapRtOpCd()," ");            //oa_rap_rt_op_cd              
			oa_rap_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getOaRapCurrCd()," ");            //oa_rap_curr_cd                
			oa_rap_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getOaRapFrtRtAmt(),"0"));           //oa_rap_frt_rt_amt            
			oa_rar_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getOaRarBkgConvTpCd()," ");        //oa_rar_bkg_conv_tp_cd             
			oa_rar_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getOaRarNoteConvTpCd()," ");      //oa_rar_note_conv_tp_cd       
			oa_rar_rt_op_cd [i]          = JSPUtil.getNullNoTrim(list1.get(i).getOaRarRtOpCd()," ");            //oa_rar_rt_op_cd              
			oa_rar_curr_cd [i]           = JSPUtil.getNullNoTrim(list1.get(i).getOaRarCurrCd()," ");           //oa_rar_curr_cd                
			oa_rar_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getOaRarFrtRtAmt(),"0"));           //oa_rar_frt_rt_amt            
			oa_dor_bkg_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getOaDorBkgConvTpCd()," ");        //oa_dor_bkg_conv_tp_cd            
			oa_dor_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getOaDorNoteConvTpCd()," ");       //oa_dor_note_conv_tp_cd       
			oa_dor_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getOaDorRtOpCd()," ");           //oa_dor_rt_op_cd              
			oa_dor_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getOaDorCurrCd()," ");             //oa_dor_curr_cd                
			oa_dor_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getOaDorFrtRtAmt(),"0"));           //oa_dor_frt_rt_amt            
			oa_typ_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getOaTypBkgConvTpCd()," ");        //oa_typ_bkg_conv_tp_cd          
			oa_typ_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getOaTypNoteConvTpCd()," ");       //oa_typ_note_conv_tp_cd       
			oa_typ_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getOaTypRtOpCd()," ");             //oa_typ_rt_op_cd              
			oa_typ_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getOaTypCurrCd()," ");             //oa_typ_curr_cd                
			oa_typ_frt_rt_amt[i]         =  Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getOaTypFrtRtAmt(),"0"));            //oa_typ_frt_rt_amt            
			da_rap_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getDaRapBkgConvTpCd()," ");       //da_rap_bkg_conv_tp_cd            
			da_rap_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getDaRapNoteConvTpCd()," ");       //da_rap_note_conv_tp_cd       
			da_rap_da_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getDaRapDaOpCd()," ");            //da_rap_da_op_cd              
			da_rap_curr_cd [i]           = JSPUtil.getNullNoTrim(list1.get(i).getDaRapCurrCd()," ");             //da_rap_curr_cd                
			da_rap_frt_rt_amt[i]         =  Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getDaRapFrtRtAmt(),"0"));            //da_rap_frt_rt_amt            
			da_rar_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getDaRarBkgConvTpCd()," ");       //da_rar_bkg_conv_tp_cd             
			da_rar_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getDaRarNoteConvTpCd()," ");       //da_rar_note_conv_tp_cd       
			da_rar_da_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getDaRarDaOpCd()," ");            //da_rar_da_op_cd         
			da_rar_curr_cd [i]           = JSPUtil.getNullNoTrim(list1.get(i).getDaRarCurrCd()," ");            //da_rar_curr_cd          
			da_rar_frt_rt_amt[i]         =  Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getDaRarFrtRtAmt(),"0"));           //da_rar_frt_rt_amt       
			da_dor_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getDaDorBkgConvTpCd()," ");       //da_dor_bkg_conv_tp_cd   
			da_dor_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getDaDorNoteConvTpCd()," ");     //da_dor_note_conv_tp_cd  
			da_dor_da_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getDaDorDaOpCd()," ");           //da_dor_da_op_cd         
			da_dor_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getDaDorCurrCd()," ");             //da_dor_curr_cd          
			da_dor_frt_rt_amt[i]         =  Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getDaDorFrtRtAmt(),"0"));            //da_dor_frt_rt_amt       
			da_typ_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getDaTypBkgConvTpCd()," ");     //da_typ_bkg_conv_tp_cd   
			da_typ_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getDaTypNoteConvTpCd()," ");      //da_typ_note_conv_tp_cd  
			da_typ_da_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getDaTypDaOpCd()," ");            //da_typ_da_op_cd         
			da_typ_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getDaTypCurrCd()," ");              //da_typ_curr_cd          
			da_typ_frt_rt_amt[i]         =  Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getDaTypFrtRtAmt(),"0"));          //da_typ_frt_rt_amt
			oa_rac_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getOaRacBkgConvTpCd()," ");		//oa_rac_bkg_conv_tp_cd      
			oa_rac_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getOaRacNoteConvTpCd()," ");              //oa_rac_note_conv_tp_cd    
			oa_rac_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getOaRacRtOpCd()," ");             //oa_rac_rt_op_cd           
			oa_rac_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getOaRacCurrCd()," ");              //oa_rac_curr_cd            
			oa_rac_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getOaRacFrtRtAmt(),"0"));              //oa_rac_frt_rt_amt         
			rt_rac_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getRtRacBkgConvTpCd()," ");             //rt_rac_bkg_conv_tp_cd       
			rt_rac_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getRtRacNoteConvTpCd()," ");              //rt_rac_note_conv_tp_cd    
			rt_rac_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getRtRacRtOpCd()," ");              //rt_rac_rt_op_cd           
			rt_rac_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtRacCurrCd()," ");            //rt_rac_curr_cd            
			rt_rac_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtRacFrtRtAmt(), "0"));              //rt_rac_frt_rt_amt         
			da_rac_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getDaRacBkgConvTpCd()," ");             //da_rac_bkg_conv_tp_cd       
			da_rac_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getDaRacNoteConvTpCd()," ");             //da_rac_note_conv_tp_cd    
			da_rac_da_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getDaRacDaOpCd()," ");              //da_rac_da_op_cd           
			da_rac_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getDaRacCurrCd()," ");            //da_rac_curr_cd            
			da_rac_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getDaRacFrtRtAmt(), "0"));              //da_rac_frt_rt_amt
			di_fnl_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getDiFnlFrtRtAmt(), "0"));  	 //DI_FNL_FRT_RT_AMT
			oi_fnl_frt_rt_amt[i]	     = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getOiFnlFrtRtAmt(), "0"));	 //OI_FNL_FRT_RT_AMT
			
		}
		/* 모든 conv_tp_cd 시리즈 Value 가 C 일 경우 Conversion 이 되었다고  판단 한다 */
		log.debug("-------------------------------------START-------------------------------------");
		for (i=0; i< list1.size();i++){ //row 갯수로 값을 가져옴 (list1  = row)
			/* OIH */
			if((int)oi_fnl_frt_rt_amt[i] != 0){ //OI FNL AMT 금액이 0이 아닐경우 Amount 로직 적용
				if("C".equals(oa_typ_bkg_conv_tp_cd[i]) && !"+".equals(oa_typ_rt_op_cd[i]) && !"-".equals(oa_typ_rt_op_cd[i])){
					if("*".equals(oa_typ_rt_op_cd[i])){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] * oa_typ_frt_rt_amt[i];
					}
					else if("/".equals(oa_typ_rt_op_cd[i])){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] / oa_typ_frt_rt_amt[i];
					}
				}
				if("C".equals(oa_rac_bkg_conv_tp_cd[i]) && !"+".equals(oa_rac_rt_op_cd[i]) && !"-".equals(oa_rac_rt_op_cd[i])){
					if("*".equals(oa_rac_rt_op_cd[i])){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] * oa_rac_frt_rt_amt[i];
					}
					else if("/".equals(oa_rac_rt_op_cd[i])){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] / oa_rac_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_rap_bkg_conv_tp_cd[i]) && !"+".equals(rt_rap_rt_op_cd[i]) && !"-".equals(rt_rap_rt_op_cd[i])){
					if(rt_rap_rt_op_cd[i].equals("*")) {
						oi_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * rt_rap_frt_rt_amt[i];		
					}
					else if(rt_rap_rt_op_cd[i].equals("/")) {
						oi_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / rt_rap_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_rar_bkg_conv_tp_cd[i]) && !"+".equals(rt_rar_rt_op_cd[i]) && !"-".equals(rt_rar_rt_op_cd[i])){
					if("*".equals(rt_rar_rt_op_cd[i])){
						oi_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * rt_rar_frt_rt_amt[i];
					}
					else if("/".equals(rt_rar_rt_op_cd[i])){
						oi_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / rt_rar_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_dor_bkg_conv_tp_cd[i]) && !"+".equals(rt_dor_rt_op_cd[i]) && !"-".equals(rt_dor_rt_op_cd[i])){
					if("*".equals(rt_dor_rt_op_cd[i])){
						oi_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * rt_dor_frt_rt_amt[i];
					}
					else if("/".equals(rt_dor_rt_op_cd[i])){ 
						oi_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / rt_dor_frt_rt_amt[i];
					}
				}
			}
			//OARB 
//			if((int)rt_arb_frt_rt_amt[i] != 0){ // RT_ARB_FRT_RT_AMT 값이 0 이 아닐경우 OARB 값을 대체하여 사용 하고 0일 경우 Amount 로직을 적용한다
			if("F".equals(rt_arb_rt_appl_tp_cd[i])){
				oarb_fnl_amt[i] = rt_arb_frt_rt_amt[i]; // Fixed Amount인 경우 빠져나와 이값을 사용함 
				oa_fnl_frt_rt_amt[i] = rt_arb_frt_rt_amt[i];
			}else{ // conv_tp_cd 가 "C" 인 경우만 절차적으로 확인하여 AMT 값 구함 	
				if("C".equals(oa_typ_bkg_conv_tp_cd[i]) && !"+".equals(oa_typ_rt_op_cd[i]) && !"-".equals(oa_typ_rt_op_cd[i])){
					if("*".equals(oa_typ_rt_op_cd[i])){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * oa_typ_frt_rt_amt[i] ;
					}
					else if("/".equals(oa_typ_rt_op_cd[i])){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / oa_typ_frt_rt_amt[i] ;
					}
				}
				if("C".equals(oa_rac_bkg_conv_tp_cd[i]) && !"+".equals(oa_rac_rt_op_cd[i]) && !"-".equals(oa_rac_rt_op_cd[i])){
					if("*".equals(oa_rac_rt_op_cd[i])){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * oa_rac_frt_rt_amt[i] ;
					}else if("/".equals(oa_rac_rt_op_cd[i])){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / oa_rac_frt_rt_amt[i] ;
					}
				}
				if("C".equals(rt_rap_bkg_conv_tp_cd[i]) && !"+".equals(rt_rap_rt_op_cd[i]) && !"-".equals(rt_rap_rt_op_cd[i])){
					if("*".equals(rt_rap_rt_op_cd[i])) {
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * rt_rap_frt_rt_amt[i];		
					}
					else if("/".equals(rt_rap_rt_op_cd[i])) {
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / rt_rap_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_rar_bkg_conv_tp_cd[i]) && !"+".equals(rt_rar_rt_op_cd[i]) && !"-".equals(rt_rar_rt_op_cd[i])){
					if("*".equals(rt_rar_rt_op_cd[i])){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * rt_rar_frt_rt_amt[i];
					}
					else if("/".equals(rt_rar_rt_op_cd[i])){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / rt_rar_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_dor_bkg_conv_tp_cd[i]) && !"+".equals(rt_dor_rt_op_cd[i]) && !"-".equals(rt_dor_rt_op_cd[i])){
					if("*".equals(rt_dor_rt_op_cd[i])){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * rt_dor_frt_rt_amt[i];
					}
					else if("/".equals(rt_dor_rt_op_cd[i])){ 
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / rt_dor_frt_rt_amt[i];
					}
				}
				oarb_fnl_amt[i] = oa_fnl_frt_rt_amt[i] ;
			}
 
			if((int)rt_fnl_frt_rt_amt[i] > 0) { //THR 값이 0 이 아닐경우  Amount 로직을 적용한다
			
				if("C".equals(rt_typ_bkg_conv_tp_cd[i])){
					
					if("+".equals(rt_typ_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i]  = rt_fnl_frt_rt_amt[i]  + rt_typ_frt_rt_amt[i] ;
					}
					else if("-".equals(rt_typ_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i]  = rt_fnl_frt_rt_amt[i]  - rt_typ_frt_rt_amt[i] ;
					}
					else if("*".equals(rt_typ_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i]  = rt_fnl_frt_rt_amt[i]  * rt_typ_frt_rt_amt[i] ;
					}
					else if("/".equals(rt_typ_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i]  = rt_fnl_frt_rt_amt[i]  / rt_typ_frt_rt_amt[i] ;
					}
				}
				if("C".equals(rt_rac_bkg_conv_tp_cd[i])){
					if("+".equals(rt_rac_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_rac_frt_rt_amt[i];
					}
					else if("-".equals(rt_rac_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_rac_frt_rt_amt[i];
					}
					else if("*".equals(rt_rac_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_rac_frt_rt_amt[i];
					}
					else if("/".equals(rt_rac_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_rac_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_rap_bkg_conv_tp_cd[i])){
					if("+".equals(rt_rap_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_rap_frt_rt_amt[i];
					}
					else if ("-".equals(rt_rap_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_rap_frt_rt_amt[i];
					}
					else if ("*".equals(rt_rap_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_rap_frt_rt_amt[i];
					}
					else if ("/".equals(rt_rap_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_rap_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_rar_bkg_conv_tp_cd[i])){
					if("+".equals(rt_rar_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_rar_frt_rt_amt[i];
					}
					else if ("+".equals(rt_rar_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_rar_frt_rt_amt[i];
					}
					else if ("*".equals(rt_rar_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_rar_frt_rt_amt[i];
					}
					else if ("/".equals(rt_rar_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_rar_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_dor_bkg_conv_tp_cd[i])){
					if("+".equals(rt_dor_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_dor_frt_rt_amt[i];
					}
					else if ("-".equals(rt_dor_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_dor_frt_rt_amt[i];
					}
					else if ("*".equals(rt_dor_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_dor_frt_rt_amt[i];
					}
					else if ("/".equals(rt_dor_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_dor_frt_rt_amt[i];
					}
				}
				//RAS 는 THR 만 있음
				if("C".equals(rt_ras_bkg_conv_tp_cd[i])){
					if("+".equals(rt_ras_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_ras_frt_rt_amt[i];
					}
					else if("-".equals(rt_ras_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_ras_frt_rt_amt[i];
					}
					else if("*".equals(rt_ras_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_ras_frt_rt_amt[i];
					}
					else if("/".equals(rt_ras_rt_op_cd[i])){
						rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_ras_frt_rt_amt[i];
					}
				}
				thr_fnl_amt[i] = rt_fnl_frt_rt_amt[i];
			}		
			//OI FNL AMT 금액이 0이 아닐경우 Amount 로직 적용
			//if((int)rt_add_frt_rt_amt[i] != 0){ // DARB
			if("F".equals(rt_add_rt_appl_tp_cd[i])){
				darb_fnl_amt[i] = rt_add_frt_rt_amt[i]; // OARB 와 동일하게  Fixed Amount인 경우
				da_fnl_frt_rt_amt[i] = rt_add_frt_rt_amt[i]; // OARB 와 동일하게  darb_fnl_amt 값이 있으면 그냥 사용 하고 루프 빠져나옴
			}
			else{
				if("C".equals(da_typ_bkg_conv_tp_cd[i]) && !"+".equals(da_typ_da_op_cd[i]) && !"-".equals(da_typ_da_op_cd[i])){
					if("*".equals(da_typ_da_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] * da_typ_frt_rt_amt[i];
					}
					else if("/".equals(da_typ_da_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] / da_typ_frt_rt_amt[i];
					}
				}
				if("C".equals(da_rac_bkg_conv_tp_cd[i]) && !"+".equals(da_rac_da_op_cd[i]) && !"-".equals(da_rac_da_op_cd[i])){
					if("*".equals(da_rac_da_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] * da_rac_frt_rt_amt[i];
					}
					else if("/".equals(da_rac_da_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] / da_rac_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_rap_bkg_conv_tp_cd[i]) && !"+".equals(rt_rap_rt_op_cd[i]) && !"-".equals(rt_rap_rt_op_cd[i])){
					if("*".equals(rt_rap_rt_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] * rt_rap_frt_rt_amt[i];
					}
					else if("/".equals(rt_rap_rt_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] / rt_rap_frt_rt_amt[i]; 
					}
				}
				if("C".equals(rt_rar_bkg_conv_tp_cd[i]) &&!"+".equals(rt_rar_rt_op_cd[i]) && !"-".equals(rt_rar_rt_op_cd[i])){
					if("*".equals(rt_rar_rt_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] * rt_rar_frt_rt_amt[i];
					}
					else if("/".equals(rt_rap_rt_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] / rt_rar_frt_rt_amt[i]; 
					}
				}
				if("C".equals(rt_add_bkg_conv_tp_cd[i]) &&!"+".equals(rt_add_bkg_conv_tp_cd[i]) && !"-".equals(rt_add_bkg_conv_tp_cd[i])){
					if("*".equals(rt_add_rt_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] * rt_add_frt_rt_amt[i];
					}
					else if("/".equals(rt_add_rt_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] / rt_add_frt_rt_amt[i]; 
					}
				}
				darb_fnl_amt[i] = da_fnl_frt_rt_amt[i] ;
			}
			
			if((int)di_fnl_frt_rt_amt[i] != 0){
				if("C".equals(da_typ_bkg_conv_tp_cd[i]) && !"+".equals(da_typ_da_op_cd[i]) && !"-".equals(da_typ_da_op_cd[i])){	
					if("*".equals(da_typ_da_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] * da_typ_frt_rt_amt[i];
					}
					else if("/".equals(da_typ_da_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] * da_typ_frt_rt_amt[i];
					}
				}
				if("C".equals(da_rac_bkg_conv_tp_cd[i]) && !"+".equals(da_rac_da_op_cd[i]) && !"-".equals(da_rac_da_op_cd[i])){
					if("*".equals(da_rac_da_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] * da_rac_frt_rt_amt[i];
					}
					else if ("/".equals(da_rac_da_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] / da_rac_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_rap_bkg_conv_tp_cd[i]) && !"+".equals(rt_rap_rt_op_cd[i])&& !"-".equals(rt_rap_rt_op_cd[i])){
					if("*".equals(rt_rap_rt_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] * da_rap_frt_rt_amt[i];
					}
					else if("/".equals(rt_rap_rt_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] / da_rap_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_add_bkg_conv_tp_cd[i]) && !"+".equals(rt_add_bkg_conv_tp_cd[i]) && !"-".equals(rt_add_bkg_conv_tp_cd[i])){
					if("*".equals(rt_add_rt_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] * rt_add_frt_rt_amt[i];
					}
					else if("/".equals(rt_add_rt_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] / rt_add_frt_rt_amt[i];
					}
				}
			}
//			/* ROUND */
//			/*
//			 * Math.ceil 올림
//			 * Math.floor 내림
//			 * Math.round 반올림
//			 */
			/* ROUND 로직 재적용 2010.04.14 강성재씨 요청 
			 * RtTypBkgConvTpCd 이 C 가 아닌경우 Round 적용 하지 않음
			 * TYPE CONVERSION 일 때만 Round 적용 
			 * */
			
			if("TPW".equals(list1.get(0).getSvcScpCd())||"ACW".equals(list1.get(0).getSvcScpCd())||"MXW".equals(list1.get(0).getSvcScpCd())
				||"TAE".equals(list1.get(0).getSvcScpCd())||"ASE".equals(list1.get(0).getSvcScpCd())||"MME".equals(list1.get(0).getSvcScpCd())
				||"SAS".equals(list1.get(0).getSvcScpCd())||"CLS".equals(list1.get(0).getSvcScpCd())||"CLN".equals(list1.get(0).getSvcScpCd())
				||"BRE".equals(list1.get(0).getSvcScpCd())||"CAS".equals(list1.get(0).getSvcScpCd())||"CAN".equals(list1.get(0).getSvcScpCd())){
					if("C".equals(oa_typ_bkg_conv_tp_cd[i])){
						if("+".equals(oa_typ_rt_op_cd[i])||"-".equals(oa_typ_rt_op_cd[i])
							||("*".equals(oa_typ_rt_op_cd[i]) && "1.0".equals(oa_typ_frt_rt_amt[i]+""))
							||("/".equals(oa_typ_rt_op_cd[i]) && "1.0".equals(oa_typ_frt_rt_amt[i]+""))){
							//계산하지않음
							log.debug("do not calculation");
						}else{
							//OIH
							log.debug("OIH row0  "+oi_fnl_frt_rt_amt[i]);
							oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] - this.runPointProcess(1,oi_fnl_frt_rt_amt[i]);
							log.debug("OIH row00  "+oi_fnl_frt_rt_amt[i]);
							
							//OARB
							log.debug("OARB row0  "+oa_fnl_frt_rt_amt[i]);
							oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] - this.runPointProcess(1,oa_fnl_frt_rt_amt[i]);
							log.debug("OARB row00  "+oa_fnl_frt_rt_amt[i]);
						}					
					
					}
					if("C".equals(rt_typ_bkg_conv_tp_cd[i])){
						if("+".equals(rt_typ_rt_op_cd[i])||"-".equals(rt_typ_rt_op_cd[i])
							||("*".equals(rt_typ_rt_op_cd[i]) && "1.0".equals(rt_typ_frt_rt_amt[i]+""))
							||("/".equals(rt_typ_rt_op_cd[i]) && "1.0".equals(rt_typ_frt_rt_amt[i]+""))){
								//계산하지않음
							log.debug("do not calculation");
						}else{
							//THR
							// 1. TPW,ACW,MXW,TAE,ASE,MME,SAS,SAN,CLS,CLN,BRE,CAS,CAN [ 0 초과 5 이하인 경우 = 5] ~ [5 초과 10 이하인 경우= 0]
							log.debug("thr row1  "+thr_fnl_amt[i]);
							log.debug("thr row1~~"+rt_fnl_frt_rt_amt[i]);
							thr_fnl_amt[i] = this.runPointProcess(1,thr_fnl_amt[i]);
							log.debug("thr row11  "+thr_fnl_amt[i]);
						}
						
					}
					if("C".equals(da_typ_bkg_conv_tp_cd[i])){
						if("+".equals(da_typ_da_op_cd[i])||"-".equals(da_typ_da_op_cd[i])
							||("*".equals(da_typ_da_op_cd[i]) && "1.0".equals(da_typ_frt_rt_amt[i]+""))
							||("/".equals(da_typ_da_op_cd[i]) && "1.0".equals(da_typ_frt_rt_amt[i]+""))){
								//계산하지않음
							log.debug("do not calculation");
						}else{
							//DARB
							// 1. TPW,ACW,MXW,TAE,ASE,MME,SAS,SAN,CLS,CLN,BRE,CAS,CAN [ 0 초과 5 이하인 경우 = 5] ~ [5 초과 10 이하인 경우= 0]
							log.debug("darb row1  "+darb_fnl_amt[i]);
							darb_fnl_amt[i] = this.runPointProcess(1,da_fnl_frt_rt_amt[i]);
							log.debug("darb row2  "+darb_fnl_amt[i]);
							//DIH
							// 1. TPW,ACW,MXW,TAE,ASE,MME,SAS,SAN,CLS,CLN,BRE,CAS,CAN [ 0 초과 5 이하인 경우 = 5] ~ [5 초과 10 이하인 경우= 0]
							log.debug("dih row3  "+di_fnl_frt_rt_amt[i]);
							di_fnl_frt_rt_amt[i] = this.runPointProcess(1,di_fnl_frt_rt_amt[i]);
							log.debug("dih row4  "+di_fnl_frt_rt_amt[i]);
						}
					}
					
			}else if("TPE".equals(list1.get(0).getSvcScpCd())||"ACE".equals(list1.get(0).getSvcScpCd())||"MXE".equals(list1.get(0).getSvcScpCd())){
					if("C".equals(oa_typ_bkg_conv_tp_cd[i])){
							if("+".equals(oa_typ_rt_op_cd[i]) ||"-".equals(oa_typ_rt_op_cd[i])
								||("*".equals(oa_typ_rt_op_cd[i]) && "1.0".equals(oa_typ_frt_rt_amt[i]+""))
								||("/".equals(oa_typ_rt_op_cd[i]) && "1.0".equals(oa_typ_frt_rt_amt[i]+""))){
									//계산하지않음
								log.debug("do not calculation");
							}else{
								//OIH
								//3. BUC,FRC 이외의 조건일경우  0 이상  2.5 미만 =0 ,02.5이상  7.5 미만 =5 ,7.5 이상=반올림
								log.debug("1 row  " +oi_fnl_frt_rt_amt[i]);
								oi_fnl_frt_rt_amt[i] = this.runPointProcess(3,oi_fnl_frt_rt_amt[i]);
								log.debug("11 row  " +oi_fnl_frt_rt_amt[i]);
								//OARB
								//3. BUC,FRC 이외의 조건일경우  0 이상  2.5 미만 =0 ,02.5이상  7.5 미만 =5 ,7.5 이상=반올림
								log.debug("2 row  " +oa_fnl_frt_rt_amt[i]);
								oarb_fnl_amt[i] = this.runPointProcess(3,oa_fnl_frt_rt_amt[i]);
								log.debug("22 row  " +oa_fnl_frt_rt_amt[i]);
							}
					}
					if("C".equals(rt_typ_bkg_conv_tp_cd[i])){
							if("+".equals(rt_typ_rt_op_cd[i]) ||"-".equals(rt_typ_rt_op_cd[i])
								||("*".equals(rt_typ_rt_op_cd[i]) && "1.0".equals(rt_typ_frt_rt_amt[i]+""))
								||("/".equals(rt_typ_rt_op_cd[i]) && "1.0".equals(rt_typ_frt_rt_amt[i]+""))){
									//계산하지않음
								log.debug("do not calculation");
							}else{
								//THR
								//3. BUC,FRC 이외의 조건일경우  0 이상  2.5 미만 =0 ,02.5이상  7.5 미만 =5 ,7.5 이상=반올림
								log.debug("3 row  " +thr_fnl_amt[i]);
								thr_fnl_amt[i] = this.runPointProcess(3,thr_fnl_amt[i]);
								log.debug("33 row  " +thr_fnl_amt[i]);
							}
					}
					if("C".equals(da_typ_bkg_conv_tp_cd[i])){
							if("+".equals(da_typ_da_op_cd[i]) ||"-".equals(da_typ_da_op_cd[i])
								||("*".equals(da_typ_da_op_cd[i]) && "1.0".equals(da_typ_frt_rt_amt[i]+""))
								||("/".equals(da_typ_da_op_cd[i]) && "1.0".equals(da_typ_frt_rt_amt[i]+""))){
									//계산하지않음
								log.debug("do not calculation");
							}else{
								//DIH
								//3. BUC,FRC 이외의 조건일경우  0 이상  2.5 미만 =0 ,02.5이상  7.5 미만 =5 ,7.5 이상=반올림
								log.debug("4 row  " +di_fnl_frt_rt_amt[i]);
								di_fnl_frt_rt_amt[i] = this.runPointProcess(3,di_fnl_frt_rt_amt[i]);
								log.debug("44 row  " +di_fnl_frt_rt_amt[i]);
								//DAR
								//3. BUC,FRC 이외의 조건일경우  0 이상  2.5 미만 =0 ,02.5이상  7.5 미만 =5 ,7.5 이상=반올림
								log.debug("5 row  " +da_fnl_frt_rt_amt[i]);
								darb_fnl_amt[i] = this.runPointProcess(3,da_fnl_frt_rt_amt[i]);
								log.debug("55 row  " +da_fnl_frt_rt_amt[i]);	
							}
					}
			}else{
                oi_fnl_frt_rt_amt[i] = Double.parseDouble(String.format("%.2f", oi_fnl_frt_rt_amt[i]));
                oarb_fnl_amt[i] = Double.parseDouble(String.format("%.2f", oarb_fnl_amt[i]));
                thr_fnl_amt[i]  = Double.parseDouble(String.format("%.2f", thr_fnl_amt[i]));
                darb_fnl_amt[i] = Double.parseDouble(String.format("%.2f", darb_fnl_amt[i]));
                di_fnl_frt_rt_amt[i] = Double.parseDouble(String.format("%.2f", di_fnl_frt_rt_amt[i]));
			}
			
			//Calc 값을 VO 에 각각 셋팅함
			//OIH
			list1.get(i).setOiCalcFrtRtAmt(String.valueOf(oi_fnl_frt_rt_amt[i]));
			//OARB
			list1.get(i).setOaCalcFrtRtAmt(String.valueOf(oarb_fnl_amt[i]));
			//THR
			list1.get(i).setRtCalcFrtRtAmt(String.valueOf(thr_fnl_amt[i]));
			//DARB
			list1.get(i).setDaCalcFrtRtAmt(String.valueOf(darb_fnl_amt[i]));
			//DIH
			list1.get(i).setDiCalcFrtRtAmt(String.valueOf(di_fnl_frt_rt_amt[i]));
			//계산시 사용된 Contract Type Setting. 추후 심사에서 사용
			list1.get(i).setCalcCtrtTpCd("S");

			// 쿼리에서 0으로 가져오는 FINAL AMT 를 로직으로 AMT 값을 가져와 셋팅함 
			fnl_frt_rt_amt[i] = String.valueOf(oi_fnl_frt_rt_amt[i] + oarb_fnl_amt[i]+ thr_fnl_amt[i]+darb_fnl_amt[i]+di_fnl_frt_rt_amt[i]);
			log.debug("not conversion amount!"+ fnl_frt_rt_amt[i]);
			/* ToT Amount Set VO  */
			list1.get(i).setFnlFrtRtAmt(fnl_frt_rt_amt[i]);
			log.debug("S/C~BKG :"+(list1.get(i).getBkgNo())+"AMT: "+list1.get(i).getFnlFrtRtAmt());
			log.debug("-------------------------------------END-------------------------------------");
		}
		return list1;
	}
	
	/**
	 * EsmBkg0269 SearchScOftAutoratingListVO 에서 Surcharge 에서 CHARGE CODE 별로 PERCENT 로 적용<br>
	 * SearchScOftAutoratingListVO  Surcharge 에서 PERCENT로 적용
	 * 
	 * @author kim tae kyoung
	 * @param List<SearchScOftAutoratingListVO> list1
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	
	public List<SearchScOftAutoratingListVO> manageSurcharge(List<SearchScOftAutoratingListVO> list1) throws EventException {
		
		List<SearchSurchargePercentBaseChargeListVO> list = searchSurchargePercentBaseChargeList();
		
		List<SearchSurchargeOftFrightListVO> list2 = searchSurchargeOftFrightList();
		
		int chgCnt = list1.size(); // Surcharge 의 Size
		//int bse_chg_cnt = list.size(); // PRI_SCG_PCT_BSE_CHG 테이블 의 row 갯수
		
		//list1  Surcharge 에서 조회된 결과 
		//list   PRI_SCG_PCT_BSE_CHG 의 코드 값
		//float chg_ut_amt[] = new float[chgCnt];
		//float chg_amt [] = new float[chgCnt];
		//float rat_as_qty [] = new float[chgCnt];
		double totAmt []  = new double[chgCnt];
		double calAmt []  = new double[chgCnt];
		double expAmt [] =  new double[chgCnt];
		
		double oftAmt[] = new double[chgCnt];
		double oarAmt[] = new double[chgCnt];
		double darAmt[] = new double[chgCnt];
		double oihAmt[] = new double[chgCnt];
		double dihAmt[] = new double[chgCnt];
		
		StringBuilder sbList = new StringBuilder();
		String list4 = "";
		
		for (int i = 0; i< list1.size(); i++){
			sbList.append(0<i ? ", " : " ");
		}
		list4 = sbList.toString();
		
		String [] curr_cd = list4.split(",");
		log.debug("-------------------------------------START PC-------------------------------------");
		//SearchScOftAutoratingListVO 에 값이 없으면 실행 하지 않는다 
		// 로직으로 SUM AMOUNT 가 어려워 TEMP TABLE SELECT 시 쿼리로 AMOUNT 값을 셋팅한 값을 가져온다 
		if(list1.size() > 0){
			
			for (int i = 0; i<list2.size(); i++){

				if(list2.get(i).getChgCd().equals("OFT")){	
					oftAmt[i] = (int)Double.parseDouble(JSPUtil.getNullNoTrim(list2.get(i).getSumAmount(),"0"));
				}
				if(list2.get(i).getChgCd().equals("OAR")){
					oarAmt[i] = (int)Double.parseDouble(JSPUtil.getNullNoTrim(list2.get(i).getSumAmount(),"0"));
				}
				if(list2.get(i).getChgCd().equals("DAR")){
					darAmt[i] = (int)Double.parseDouble(JSPUtil.getNullNoTrim(list2.get(i).getSumAmount(),"0"));
				}
				if(list2.get(i).getChgCd().equals("OIH")){
					oihAmt[i] = (int)Double.parseDouble(JSPUtil.getNullNoTrim(list2.get(i).getSumAmount(),"0"));
				}
				if(list2.get(i).getChgCd().equals("DIH")){
					dihAmt[i] = (int)Double.parseDouble(JSPUtil.getNullNoTrim(list2.get(i).getSumAmount(),"0"));
				}
			}
			
			/* 1. Surcharge 결과의 갯수에 따라 FOR 문을 돌린다 ( 특정 CHG_CD 에 대해서 PRI_SCG_PCT_BSE_CHG 갯수 만큼 적용 하기 위해))
			 * 2. IF 문에서 특정 CHG_CD 를 가져온다.(PC 체크로직)
			 * 3. IF CHG_CD (PC) 가 있다면   PCT_BSE_CD 로 PRI_SCG_PCT_BSE_CHG 를 찾는다.
			 *    FOR 문에서 Surcharge 결과의 갯수 기준으로 PRI_SCG_PCT_BSE_CHG 의 값을 찾도록 구성 
			 * 4. FOR 문으로 PCT_BSE_CD 에 해당되는 CHG_CD 값을 찾는다
			 * 5. IF 문에서 PRI_SCG_PCT_BSE_CHG 에 PCT_BSE_CD 가 있는지 찾는다  
			 * 6. Surcharge 결과 만큼 For 문을 실행 한다
			 * 7. totAmt 는 PRI_SCG_PCT_BSE_CHG 갯수만큼 찾아서 surcharge 결과이  매칭 되는값만 더함 
			 * 8. CURR_CD, AMT 값도 구하여  셋팅 해준다 
			 * */
			
			//쿼리에서 MAX 값을 가져옴
			log.debug("getMaxOftCmbSeq~~"+(int)Double.parseDouble(list2.get(0).getMaxOftCmbSeq()));
			//MaxOftCmbSeq 는 Autorating 과 RAS 의 경우를 내부적으로 구분하기 위해서 사용 
			//
			for(int r = 0 ; r < (int)Double.parseDouble(list2.get(0).getMaxOftCmbSeq()); r++){
				for(int i = 0 ; i < list1.size(); i++){
					if(list1.get(i).getRatUtCd().equals("PC")){
						for(int j = 0 ; j < list.size(); j++){
							if(list1.get(i).getPctBseCd().equals(list.get(j).getPctBseCd())){
								if(list.get(j).getChgCd().equals("OFT")){
									totAmt[i] += oftAmt[r] ;
									calAmt[i] += oftAmt[r] * Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0")) / 100;
									curr_cd [i] = list1.get(r).getCurrCd();
								}else if(list.get(j).getChgCd().equals("OAR")){
									totAmt[r] += oarAmt[i] ;
									calAmt[r] += oarAmt[i] * Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0")) / 100;
										curr_cd [i] = list1.get(r).getCurrCd();
								}else if(list.get(j).getChgCd().equals("DAR")){
									totAmt[r] += darAmt[i] ;
									calAmt[r] += darAmt[i] * Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0")) / 100;
									curr_cd [i] = list1.get(r).getCurrCd();
								}else if(list.get(j).getChgCd().equals("OIH")){
									totAmt[r] += oihAmt[i] ;
									calAmt[r] += oihAmt[i] * Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0")) / 100;
									curr_cd [i] = list1.get(r).getCurrCd();
								}else if(list.get(j).getChgCd().equals("DIH")){
									totAmt[r] += dihAmt[i] ;
									calAmt[r] += dihAmt[i] * Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0")) / 100;
									curr_cd [i] = list1.get(r).getCurrCd();
								}else if (list.get(j).getChgCd().equals(list1.get(i).getChgCd())){
									if(list1.get(i).getChgCd().equals("VDT")){
										for(int u = 0; u <list1.size(); u++){
											if(list1.get(u).getChgCd().equals("DHF")|list1.get(u).getChgCd().equals("DDF") && list1.get(u).getCurrCd().equals("VND")){
												expAmt[u] += Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(u).getChgAmt(),"0"));
												// Charge Code 가  VDT 이고 DHF, DDF Code 값 중 VND Currency code를 가진 경우에 한함
												// Type, exp_amt, rat_as_qty
												totAmt[r] = this.exceptionSurchargeTax(1, expAmt[u],(int)Double.parseDouble(list1.get(i).getRatAsQty()));
											}
										}
									}else if(list1.get(i).getChgCd().equals("VTT")){
										for(int t = 0; t < list1.size(); t++){
											if(list1.get(t).getPorCntCd().equals("VN")){
												if(list1.get(t).getChgCd().equals("OTH")|list1.get(t).getChgCd().equals("ORC") && list1.get(t).getCurrCd().equals("USD")){
													expAmt[t] += Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(t).getChgAmt(),"0"));
													// Charge Code 가 VTT 이고 POR 이 VN 인 OTH,ORC 의 총금액 ( USD 만 )
													// Type, exp_amt, rat_as_qty
													totAmt[r] += this.exceptionSurchargeTax(2, expAmt[t], (int)Double.parseDouble(list1.get(i).getRatAsQty()));
												}
											}
											if(list1.get(t).getDelCntCd().equals("VN")){
												if(list1.get(t).getChgCd().equals("DTH")|list1.get(t).getChgCd().equals("DDC") && list1.get(t).getCurrCd().equals("USD")){
													expAmt[t] += Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(t).getChgAmt(),"0"));
													// Charge Code 가 VTT 이고 POR 이 VN 인 OTH,ORC 의 총금액 ( USD 만 )
													// Type, exp_amt, rat_as_qty
													totAmt[r] += this.exceptionSurchargeTax(2, expAmt[t], (int)Double.parseDouble(list1.get(i).getRatAsQty()));
												}
											}
										}
									}else{
										totAmt[r] += Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(j).getChgAmt(),"0"));
										calAmt[r] += Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(j).getChgAmt(),"0")) * Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0")) / 100;
										curr_cd [i] = list1.get(r).getCurrCd();
									}
								}else{
									for(int h = 0; h < list1.size(); h++){
										if(list.get(j).getChgCd().equals(list1.get(h).getChgCd())){
//											log.debug("CHG_CD~~~~~"+list.get(j).getChgCd());
											totAmt[i] += Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(h).getChgAmt(),"0"));
//											log.debug("CHG_CD AMOUNT="+totAmt[i]+" rowcount="+i);
											calAmt[i] += Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(h).getChgAmt(),"0")) * Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0")) / 100;
//											log.debug("totAmt~~~~~~~####"+totAmt[i]);
											curr_cd [i] = list1.get(h).getCurrCd();
										}
									}
								}					
							}
						}
						//Surcharge Round 로직  (X)  소수점 셋째자리에서 반올림 로직 기본임					
						// 2. BUC,FRC [ 0.5미만일경우 소숫점 버림 ,0.5 이상인경우 반올림 
						if(curr_cd[i].equals("BUC")|curr_cd[i].equals("FRC")){
							totAmt[i] = this.runPointProcess(2, totAmt[i]);
						}else{
							//소수점 셋째자리에서 반올림 로직 기본임
							totAmt[i] = (double)Math.round(totAmt[i]+0.005d);
						}
						log.debug("CACACACF~~~~~"+totAmt[i]);
						list1.get(i).setChgUtAmt(String.valueOf(totAmt[i]));
						list1.get(i).setCurrCd(curr_cd[i]);
						list1.get(i).setChgAmt(String.valueOf(calAmt[i]));
						log.debug("CAF~~~~~~~~~~~~~~~~~"+list1.get(i).getCurrCd());
						log.debug("CAF~~~~~~~~~~~~~~~~~"+list1.get(i).getChgCd());
						log.debug("CAF~~~~~~~~~~~~~~~~~"+list1.get(i).getChgUtAmt());
						log.debug("CAF~~~~~~~~~~~~~~~~~"+list1.get(i).getChgAmt());
					}
				}
			}
		}
		log.debug("-------------------------------------END PC-------------------------------------");
		return list1;
		
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
		 log.debug("runPointProcess type="+type);
			
		//[START]------------- 조건구간에 따른  구분  설정  -------------//

		 switch (type) {

		 	// 1. OFT인경우 [ 0 초과 5 이하인 경우 = 5] ~ [5 초과 10 이하인 경우= 0]
		case 1:
			// (0.0d < dAmount && dAmount <= 5.0d) R4J 결함 복구  
			if (0 < Double.compare(dAmount, 0.0d) && 0 >= Double.compare(dAmount,5.0d)) {
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
			// (0.5d > dAmount)  R4J 결함 복구  
			if (0 > Double.compare(dAmount, 0.5d)){
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
			// (7.5d <= dAmount ) R4J 결함 복구				
			}else if (0 <= Double.compare(dAmount,7.5d)){
				fAmount = (double) Math.floor(fAmount);// 소숫점 절삭
				fAmount = Math.round(fAmount * 0.1d) * 10d;// 소숫점만든후 반올림후 다시 복원
			}
			break;
			// 
		default:
			break;
		}
		//[END]------------- 조건구간에 따른  구분  설정  -------------//
		 
		 return (int)fAmount;
	 }
	 
	 private int exceptionSurchargeTax(int type, double amount, int qty ){
		 switch(type) {
		 	
		   // VDT Case 1
		   // DHF, DDF Code 값중  VND Currency Code 를 가진 경우에 한함
		   // 1. [DHF+DDF] 총액 / (100%- VDT %) X VDT % 적용
		   // 2. [DHF+DDF] 총액 / (100%- VDT %) X VDT % 적용
		   // 3. 적용 결과는 소수점 아래 첫째 자리에서 반올림 표기. (계산 결과. 101.794812-> 102) 
		   // 4. 예제) VND로 된 DHF+DDF의 총액이 VND 100이고 VDT가 3% 인 경우 
		   // VND 100 / (100% - 3%) X 3% = 2.91 = VND 2.90
		 
		   
		   // VTT 
		   // 1. O/Bound 화물의 경우
		   // - POR의 Location이 "VN" country code이며
		   // - OTH,ORC Code 총 금액 대상
		   // 2. I/Bound 화물의 경우
		   // - DEL의 Location이 "VN" country code이며
		   // - DTH, DDC Code 총 금액 대상
		   //  ※ 공통 사항 : USD 화폐인 경우에 한함

		 
		 
		 // VDT 
		 case 1:
			 amount = amount /(100 - qty ) * qty;
			 amount = (double) Math.round(amount + 0.5d);// 소숫점만든후 절삭
			 break;
			 
	     // VTT POR = VN 
		 //	(OTH+ORC) /(1-VTT 요율) X VTT 요율
		 case 2:
			 amount = (1- qty) * qty ;
			 amount = (double) Math.round(amount + 0.05d);// 소숫점만든후 절삭
			 break;
			 
	     // VTT DEL = VN
		 //	(DTH+DDC) /(1-VTT 요율) X VTT 요율
		 case 3:
			 amount = (1- qty) * qty ;
			 amount = (double) Math.round(amount + 0.05d);// 소숫점만든후 절삭
			 break;
			 
		 default:
			 
			break;
		 }
		 return (int)amount;
	 }
	 
	/**
	 * EsmBkg007901 searchPreCheckRtAplyDt 조회 이벤트 처리
	 * SC OFT계산 가능 여부를 확인하기를 위해 Rate Application Date를 YYYYMMDD 형식으로 조회
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
	 * SC OFT계산결과를 체크한다.
	 * @param String bkgNo
	 * @param String caFlg 
	 * @return String
	 * @throws EventException
	 */
	public String checkOftRateMatch(String bkgNo ,String caFlg) throws EventException{
		try {
			return dbDao.checkOftRateMatch(bkgNo,caFlg);
			 
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("BKG00629").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("BKG00629").getUserMessage(),ex);
		}
		
	}
	
	
	/**
	 * EsmBkg0256 Re-Audit<br>
	 * Backend로 수행하기 위해 Global Temp 테이블을 삭제시켜줌.
	 * 
	 * @author JIN JOO KIM
	 * @exception EventException
	 */
	public void manageAutoratingTempTables() throws EventException {
		try {
			dbDao.manageAutoratingTempTables();		

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
		
	}
}

