/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.ManualSurchargeVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmChgTaxFlgVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration.ScOftAutoRatingDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ExchangeRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargeOftFrightListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargePercentBaseChargeListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmCurrencyVO;

/**
 * OPUS-ScOftAutoRatingBC Business Logic Command Interface<br>
 * - OPUS-ScOftAutoRatingBC business logic handling<br>
 * 
 * @author
 * @see Esm_bkg_0269EventResponse reference
 * @since J2EE 1.6
 */
public class ScOftAutoRatingBCImpl extends BasicCommandSupport implements ScOftAutoRatingBC{

	
	// Database Access Object
	private transient ScOftAutoRatingDBDAO dbDao = null;

	/**
	 * BlRatingBCImpl object creation<br>
	 * BlRatingDBDAO creation<br>
	 */
	public ScOftAutoRatingBCImpl() {
		dbDao = new ScOftAutoRatingDBDAO();
	}

	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about booking
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScETCOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd ) throws EventException{
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchScETCOftAutoratingList(bkgNo, caFlag, scNo, rtAplyDt, scpCd, cmdtCd);
			return mangageAmount(list1); // getting AMOUT value from Final Amout logic
			//return list1;
//			return dbDao.searchScETCOftAutoratingList(bkgNo, caFlag, scpCd, cmdtCd, rtAplyDt);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about booking
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd ) throws EventException{
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchScOftAutoratingList(bkgNo, caFlag, scNo, rtAplyDt, scpCd, cmdtCd);
			return mangageAmount(list1); // getting AMOUT value from Final Amout logic
			//return list1;
//			return dbDao.searchScETCOftAutoratingList(bkgNo, caFlag, scpCd, cmdtCd, rtAplyDt);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about SC no corresponding to booking no
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTAEOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd) throws EventException{
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchScTAEOftAutoratingList(bkgNo, caFlag, scNo, rtAplyDt, scpCd, cmdtCd);
			return mangageAmount(list1); // getting AMOUT value from Final Amout logic
			//return  list1;
//			 return dbDao.searchScTAEOftAutoratingList(bkgNo,caFlag,scpCd, cmdtCd, rtAplyDt);
			 
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about ScTAWOft SC no corresponding to booking no
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTAWOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt , String scpCd ,String cmdtCd) throws EventException{
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchScTAWOftAutoratingList(bkgNo, caFlag, scNo, rtAplyDt, scpCd, cmdtCd );
			return mangageAmount(list1); // getting AMOUT value from Final Amout logic
			//return dbDao.searchScTAWOftAutoratingList(bkgNo,caFlag,scpCd, cmdtCd, rtAplyDt);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about ScTPSOft SC no corresponding to booking no
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
 	 * @return List<SearchScTAEOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTPSOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt,String scpCd ,String cmdtCd) throws EventException{
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchScTPSOftAutoratingList(bkgNo,caFlag,scNo,rtAplyDt,scpCd, cmdtCd);
			return mangageAmount(list1); //getting AMOUT value from Final Amout logic
			//return  list1;
//			return  dbDao.searchScTPSOftAutoratingList(bkgNo,caFlag,scpCd, cmdtCd);

			 
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about searchSurchargeAutoratingList corresponding to booking no
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
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about searchSurchargeAutoratingList corresponding to booking no
	 * @param ScOftAutoratingListVO vo
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingList(ScOftAutoratingListVO vo ) throws EventException{
		
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchSurchargeAutoratingList(vo);
			BigDecimal chgAmt ;
			BigDecimal chkAmt ;
			for(int i = 0; i<list1.size(); i++){
					if(!"PC".equals(list1.get(i).getRatUtCd())){
						String chgUtAmt = JSPUtil.getNullNoTrim(list1.get(i).getChgUtAmt(),"0.0");
						String rateAsQty = JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0.0");
						String amt = JSPUtil.getNullNoTrim(list1.get(i).getChgAmt(),"0.0");
						
						chkAmt = new BigDecimal(chgUtAmt).multiply(new BigDecimal(rateAsQty));
						chgAmt = new BigDecimal(amt);
						if(chkAmt.compareTo(chgAmt) != 0){
							log.error("chgUtAmt: "+Double.parseDouble(chgUtAmt));
							log.error("rateAsQty "+Double.parseDouble(rateAsQty));
							log.error("Surcharge BKG: "+list1.get(i).getBkgNo()+" PER["+list1.get(i).getRatUtCd()+"]"+" Amount["+list1.get(i).getChgAmt()+"]"+" RATE["+list1.get(i).getChgUtAmt()+"]"+" RATEAS["+list1.get(i).getRatAsQty()+"]");	
						}
					}
			}
			for(int i = 0; i< list1.size(); i++){
				list1.get(i).setFnlFrtRtAmt(vo.getFnlFrtRtAmt());
			}
//			return manageSurcharge(list1);
			
			list1 = manageTaxSurcharge(list1, vo.getsvcScpCd(), vo.getRtAplyDt());
			
			return list1;
//			return dbDao.searchSurchargeAutoratingList(bkgNo,caFlag,scpCd, cmdtCd, ctrtTpCd );

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmBkg0269  surchargePercentBaseChargeList retrieve event process<br>
	 * Surcharge AutoRating BaseChargeList retrieve  
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
	 * EsmBkg0269 surchargeautorating retrieve event process<br>
	 * BKG_AUTO_RT_OCN_FRT_TMP retrieve 
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
	 * EsmBkg0269 surchargeautorating registering event process<br>
	 * Surcharge AutoRating registering
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
	 * EsmBkg0269 calculate Total Amount at SearchScOftAutoratingListVO <br>
	 * SearchScOftAutoratingListVO  mangageAmount calculation
	 * @param List<SearchScOftAutoratingListVO> list1
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	
	private List<SearchScOftAutoratingListVO> mangageAmount(List<SearchScOftAutoratingListVO> list1) throws EventException {
		
		/*** OARB OA ( +, - calculation SKIP!)*/
		/*

		1. Apply the amount if value exists at RT_ARB_FRT_RT_AMT

		2. OA_FNL_FRT_RT_AMT : 200

		3. (1) TYP : * 0.8 ==> 200 * 0.8 = 160
		   (2) RAC : 
		   (3) RAP : + 200 ==> SKIP! = 160
		   (4) RAR : * 1.2 ==> 160 * 1.2 = 192
		   (5) DOR : 
		   (6) RAS (RT_RAS_FRT_RT_AMT)

		*** THR RT ( +, - calculation)

		*** DARB DA ( +, - calculation SKIP!)

		*** FINAL RATE = OARB + THR + DARB
		*/
		
		int i = 0;
		int k = 0;
		k = list1.size();
		
		/* OARB + THR + DARB = FNL AMOUNT in case of TPE
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
		
		// array creation
		for(i=0; i< list1.size(); i++){
			sbList2.append(0<i ? ", " : " ");
		}
		list2 = sbList2.toString();
		
		String[] fnl_frt_rt_amt = list2.split(","); // return total amount
		       
		// array creation
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
		double rt_ras_frt_rt_amt[]                = new double [k];		//RT_RAS_FRT_RT_AMT       
		String[] rt_arb_bkg_conv_tp_cd           = list2.split(",");	//RT_ARB_BKG_CONV_TP_CD   
		String[] rt_arb_note_conv_tp_cd          = list2.split(",");	//RT_ARB_NOTE_CONV_TP_CD  
		String[] rt_arb_rt_op_cd                 = list2.split(",");	//RT_ARB_RT_OP_CD         
		String[] rt_arb_curr_cd                  = list2.split(",");	//RT_ARB_CURR_CD          
		double rt_arb_frt_rt_amt[]                = new double [k];		//RT_ARB_FRT_RT_AMT       
		String[] rt_add_bkg_conv_tp_cd           = list2.split(",");	//RT_ADD_BKG_CONV_TP_CD       
		String[] rt_add_note_conv_tp_cd          = list2.split(",");	//RT_ADD_NOTE_CONV_TP_CD  
		String[] rt_add_rt_op_cd                 = list2.split(",");	//RT_ADD_RT_OP_CD         
		String[] rt_add_curr_cd                  = list2.split(",");	//RT_ADD_CURR_CD          
		double rt_add_frt_rt_amt[]                = new double [k];		//RT_ADD_FRT_RT_AMT       
		String[] oa_rap_bkg_conv_tp_cd           = list2.split(",");	//OA_RAP_BKG_CONV_TP_CD      
		String[] oa_rap_note_conv_tp_cd          = list2.split(",");	//OA_RAP_NOTE_CONV_TP_CD  
		String[] oa_rap_rt_op_cd                 = list2.split(",");	//OA_RAP_RT_OP_CD         
		String[] oa_rap_curr_cd                  = list2.split(",");	//OA_RAP_CURR_CD          
		double oa_rap_frt_rt_amt[]                = new double [k];     //OA_RAP_FRT_RT_AMT       
//		String[] oa_rar_bkg_conv_tp_cd           = list2.split(",");	//OA_RAR_BKG_CONV_TP_CD       
//		String[] oa_rar_note_conv_tp_cd          = list2.split(",");	//OA_RAR_NOTE_CONV_TP_CD  
//		String[] oa_rar_rt_op_cd                 = list2.split(",");	//OA_RAR_RT_OP_CD         
//		String[] oa_rar_curr_cd                  = list2.split(",");	//OA_RAR_CURR_CD          
//		double oa_rar_frt_rt_amt[]                = new double [k];		//OA_RAR_FRT_RT_AMT       
		String[] oa_dor_bkg_conv_tp_cd           = list2.split(",");	//OA_DOR_BKG_CONV_TP_CD   
//		String[] oa_dor_note_conv_tp_cd          = list2.split(",");	//OA_DOR_NOTE_CONV_TP_CD  
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
//		String[] da_rar_bkg_conv_tp_cd           = list2.split(",");	//DA_RAR_BKG_CONV_TP_CD   
//		String[] da_rar_note_conv_tp_cd          = list2.split(",");	//DA_RAR_NOTE_CONV_TP_CD  
//		String[] da_rar_da_op_cd                 = list2.split(",");	//DA_RAR_DA_OP_CD         
//		String[] da_rar_curr_cd                  = list2.split(",");	//DA_RAR_CURR_CD          
//		double da_rar_frt_rt_amt[]                = new double [k];		//DA_RAR_FRT_RT_AMT       
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



		for(i=0; i< list1.size(); i++){ // getting value at Final Amount
			//float defalut 0
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
			rt_arb_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtArbCurrCd()," ");             //rt_arb_curr_cd               
			rt_arb_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtArbFrtRtAmt(), "0"));           //rt_arb_frt_rt_amt
			rt_add_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getRtAddBkgConvTpCd()," ");      //rt_add_bkg_conv_tp_cd         
			rt_add_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getRtAddNoteConvTpCd()," ");       //rt_add_note_conv_tp_cd       
			rt_add_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getRtAddRtOpCd()," ");             //rt_add_rt_op_cd              
			rt_add_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getRtAddCurrCd()," ");           //rt_add_curr_cd               
			rt_add_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getRtAddFrtRtAmt(),"0"));           //rt_add_frt_rt_amt            
			oa_rap_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getOaRapBkgConvTpCd()," ");      //oa_rap_bkg_conv_tp_cd             
			oa_rap_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getOaRapNoteConvTpCd()," ");       //oa_rap_note_conv_tp_cd       
			oa_rap_rt_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getOaRapRtOpCd()," ");            //oa_rap_rt_op_cd              
			oa_rap_curr_cd[i]            = JSPUtil.getNullNoTrim(list1.get(i).getOaRapCurrCd()," ");            //oa_rap_curr_cd                
			oa_rap_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getOaRapFrtRtAmt(),"0"));           //oa_rap_frt_rt_amt            
//			oa_rar_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getOaRarBkgConvTpCd()," ");        //oa_rar_bkg_conv_tp_cd             
//			oa_rar_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getOaRarNoteConvTpCd()," ");      //oa_rar_note_conv_tp_cd       
//			oa_rar_rt_op_cd [i]          = JSPUtil.getNullNoTrim(list1.get(i).getOaRarRtOpCd()," ");            //oa_rar_rt_op_cd              
//			oa_rar_curr_cd [i]           = JSPUtil.getNullNoTrim(list1.get(i).getOaRarCurrCd()," ");           //oa_rar_curr_cd                
//			oa_rar_frt_rt_amt[i]         = Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getOaRarFrtRtAmt(),"0"));           //oa_rar_frt_rt_amt            
			oa_dor_bkg_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getOaDorBkgConvTpCd()," ");        //oa_dor_bkg_conv_tp_cd            
//			oa_dor_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getOaDorNoteConvTpCd()," ");       //oa_dor_note_conv_tp_cd       
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
//			da_rar_bkg_conv_tp_cd[i]     = JSPUtil.getNullNoTrim(list1.get(i).getDaRarBkgConvTpCd()," ");       //da_rar_bkg_conv_tp_cd             
//			da_rar_note_conv_tp_cd[i]    = JSPUtil.getNullNoTrim(list1.get(i).getDaRarNoteConvTpCd()," ");       //da_rar_note_conv_tp_cd       
//			da_rar_da_op_cd[i]           = JSPUtil.getNullNoTrim(list1.get(i).getDaRarDaOpCd()," ");            //da_rar_da_op_cd         
//			da_rar_curr_cd [i]           = JSPUtil.getNullNoTrim(list1.get(i).getDaRarCurrCd()," ");            //da_rar_curr_cd          
//			da_rar_frt_rt_amt[i]         =  Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(i).getDaRarFrtRtAmt(),"0"));           //da_rar_frt_rt_amt       
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
		log.debug("-------------------------------------START-------------------------------------");
		for (i=0; i< list1.size();i++){ 
			/* OIH */
			if((int)oi_fnl_frt_rt_amt[i] != 0){
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
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] * rt_rap_frt_rt_amt[i];		
					}
					else if(rt_rap_rt_op_cd[i].equals("/")) {
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] / rt_rap_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_rar_bkg_conv_tp_cd[i]) && !"+".equals(rt_rar_rt_op_cd[i]) && !"-".equals(rt_rar_rt_op_cd[i])){
					if("*".equals(rt_rar_rt_op_cd[i])){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] * rt_rar_frt_rt_amt[i];
					}
					else if("/".equals(rt_rar_rt_op_cd[i])){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] / rt_rar_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_dor_bkg_conv_tp_cd[i]) && !"+".equals(rt_dor_rt_op_cd[i]) && !"-".equals(rt_dor_rt_op_cd[i])){
					if("*".equals(rt_dor_rt_op_cd[i])){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] * rt_dor_frt_rt_amt[i];
					}
					else if("/".equals(rt_dor_rt_op_cd[i])){ 
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] / rt_dor_frt_rt_amt[i];
					}
				}
			}
			//OARB 
			if((int)rt_arb_frt_rt_amt[i] != 0){ 
				oarb_fnl_amt[i] = rt_arb_frt_rt_amt[i]; 
				oa_fnl_frt_rt_amt[i] = rt_arb_frt_rt_amt[i];
			}else{ 
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
 
//			if((int)rt_fnl_frt_rt_amt[i] > 0) {
			
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
//			}		
			if((int)rt_add_frt_rt_amt[i] != 0){ // DARB
				darb_fnl_amt[i] = rt_add_frt_rt_amt[i];
				da_fnl_frt_rt_amt[i] = rt_add_frt_rt_amt[i];
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
					else if("/".equals(rt_rar_rt_op_cd[i])){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] / rt_rar_frt_rt_amt[i]; 
					}
				}
				if("C".equals(rt_add_bkg_conv_tp_cd[i]) &&!"+".equals(rt_add_rt_op_cd[i]) && !"-".equals(rt_add_rt_op_cd[i])){
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
				if("C".equals(rt_rar_bkg_conv_tp_cd[i]) && !"+".equals(rt_rar_rt_op_cd[i]) && !"-".equals(rt_rar_rt_op_cd[i])){
					if("*".equals(rt_rar_rt_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] * rt_rar_frt_rt_amt[i];
					}
					else if("/".equals(rt_rar_rt_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] / rt_rar_frt_rt_amt[i];
					}
				}
				if("C".equals(rt_add_bkg_conv_tp_cd[i]) && !"+".equals(rt_add_rt_op_cd[i]) && !"-".equals(rt_add_rt_op_cd[i])){
					if("*".equals(rt_add_rt_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] * rt_add_frt_rt_amt[i];
					}
					else if("/".equals(rt_add_rt_op_cd[i])){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] / rt_add_frt_rt_amt[i];
					}
				}
			}
			
			if("TPW".equals(list1.get(0).getSvcScpCd())||"ACW".equals(list1.get(0).getSvcScpCd())||"MXW".equals(list1.get(0).getSvcScpCd())
				||"TAE".equals(list1.get(0).getSvcScpCd())||"ASE".equals(list1.get(0).getSvcScpCd())||"MME".equals(list1.get(0).getSvcScpCd())
				||"SAS".equals(list1.get(0).getSvcScpCd())||"CLS".equals(list1.get(0).getSvcScpCd())||"CLN".equals(list1.get(0).getSvcScpCd())
				||"BRE".equals(list1.get(0).getSvcScpCd())||"CAS".equals(list1.get(0).getSvcScpCd())||"CAN".equals(list1.get(0).getSvcScpCd())){
					if("C".equals(oa_typ_bkg_conv_tp_cd[i])){
						if(("+".equals(oa_typ_rt_op_cd[i]) && "0.0".equals(oa_typ_frt_rt_amt[i]+""))
							||("-".equals(oa_typ_rt_op_cd[i]) && "0.0".equals(oa_typ_frt_rt_amt[i]+""))
							||("*".equals(oa_typ_rt_op_cd[i]) && "1.0".equals(oa_typ_frt_rt_amt[i]+""))
							||("/".equals(oa_typ_rt_op_cd[i]) && "1.0".equals(oa_typ_frt_rt_amt[i]+""))){
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
						if(("+".equals(rt_typ_rt_op_cd[i]) && "0.0".equals(rt_typ_frt_rt_amt[i]+""))
							||("-".equals(rt_typ_rt_op_cd[i]) && "0.0".equals(rt_typ_frt_rt_amt[i]+""))
							||("*".equals(rt_typ_rt_op_cd[i]) && "1.0".equals(rt_typ_frt_rt_amt[i]+""))
							||("/".equals(rt_typ_rt_op_cd[i]) && "1.0".equals(rt_typ_frt_rt_amt[i]+""))){
							log.debug("do not calculation");
						}else{
							//THR
							log.debug("thr row1  "+thr_fnl_amt[i]);
							log.debug("thr row1~~"+rt_fnl_frt_rt_amt[i]);
							thr_fnl_amt[i] = this.runPointProcess(1,thr_fnl_amt[i]);
							log.debug("thr row11  "+thr_fnl_amt[i]);
						}
						
					}
					if("C".equals(da_typ_bkg_conv_tp_cd[i])){
						if(("+".equals(da_typ_da_op_cd[i]) && "0.0".equals(da_typ_frt_rt_amt[i]+""))
							||("-".equals(da_typ_da_op_cd[i]) && "0.0".equals(da_typ_frt_rt_amt[i]+""))
							||("*".equals(da_typ_da_op_cd[i]) && "1.0".equals(da_typ_frt_rt_amt[i]+""))
							||("/".equals(da_typ_da_op_cd[i]) && "1.0".equals(da_typ_frt_rt_amt[i]+""))){
							log.debug("do not calculation");
						}else{
							//DARB
							log.debug("darb row1  "+darb_fnl_amt[i]);
							darb_fnl_amt[i] = this.runPointProcess(1,da_fnl_frt_rt_amt[i]);
							log.debug("darb row2  "+darb_fnl_amt[i]);
							//DIH
							log.debug("dih row3  "+di_fnl_frt_rt_amt[i]);
							di_fnl_frt_rt_amt[i] = this.runPointProcess(1,di_fnl_frt_rt_amt[i]);
							log.debug("dih row4  "+di_fnl_frt_rt_amt[i]);
						}
					}
					
			}else if("TPE".equals(list1.get(0).getSvcScpCd())||"ACE".equals(list1.get(0).getSvcScpCd())||"MXE".equals(list1.get(0).getSvcScpCd())){
					if("C".equals(oa_typ_bkg_conv_tp_cd[i])){
							if(("+".equals(oa_typ_rt_op_cd[i]) && "0.0".equals(oa_typ_frt_rt_amt[i]+""))
								||("-".equals(oa_typ_rt_op_cd[i]) && "0.0".equals(oa_typ_frt_rt_amt[i]+""))
								||("*".equals(oa_typ_rt_op_cd[i]) && "1.0".equals(oa_typ_frt_rt_amt[i]+""))
								||("/".equals(oa_typ_rt_op_cd[i]) && "1.0".equals(oa_typ_frt_rt_amt[i]+""))){
								log.debug("do not calculation");
							}else{
								//OIH
								log.debug("1 row  " +oi_fnl_frt_rt_amt[i]);
								oi_fnl_frt_rt_amt[i] = this.runPointProcess(3,oi_fnl_frt_rt_amt[i]);
								log.debug("11 row  " +oi_fnl_frt_rt_amt[i]);
								//OARB
								log.debug("2 row  " +oa_fnl_frt_rt_amt[i]);
								oarb_fnl_amt[i] = this.runPointProcess(3,oa_fnl_frt_rt_amt[i]);
								log.debug("22 row  " +oa_fnl_frt_rt_amt[i]);
							}
					}
					if("C".equals(rt_typ_bkg_conv_tp_cd[i])){
							if(("+".equals(rt_typ_rt_op_cd[i]) && "0.0".equals(rt_typ_frt_rt_amt[i]+""))
								||("-".equals(rt_typ_rt_op_cd[i]) && "0.0".equals(rt_typ_frt_rt_amt[i]+""))
								||("*".equals(rt_typ_rt_op_cd[i]) && "1.0".equals(rt_typ_frt_rt_amt[i]+""))
								||("/".equals(rt_typ_rt_op_cd[i]) && "1.0".equals(rt_typ_frt_rt_amt[i]+""))){
								log.debug("do not calculation");
							}else{
								//THR
								log.debug("3 row  " +thr_fnl_amt[i]);
								thr_fnl_amt[i] = this.runPointProcess(3,thr_fnl_amt[i]);
								log.debug("33 row  " +thr_fnl_amt[i]);
							}
					}
					if("C".equals(da_typ_bkg_conv_tp_cd[i])){
							if(("+".equals(da_typ_da_op_cd[i]) && "0.0".equals(da_typ_frt_rt_amt[i]+""))
								||("-".equals(da_typ_da_op_cd[i]) && "0.0".equals(da_typ_frt_rt_amt[i]+""))
								||("*".equals(da_typ_da_op_cd[i]) && "1.0".equals(da_typ_frt_rt_amt[i]+""))
								||("/".equals(da_typ_da_op_cd[i]) && "1.0".equals(da_typ_frt_rt_amt[i]+""))){
								log.debug("do not calculation");
							}else{
								//DIH
								log.debug("4 row  " +di_fnl_frt_rt_amt[i]);
								di_fnl_frt_rt_amt[i] = this.runPointProcess(3,di_fnl_frt_rt_amt[i]);
								log.debug("44 row  " +di_fnl_frt_rt_amt[i]);
								//DAR
								log.debug("5 row  " +da_fnl_frt_rt_amt[i]);
								darb_fnl_amt[i] = this.runPointProcess(3,da_fnl_frt_rt_amt[i]);
								log.debug("55 row  " +da_fnl_frt_rt_amt[i]);	
							}
					}
			}else{
				oi_fnl_frt_rt_amt[i] = (double)Math.round(oi_fnl_frt_rt_amt[i] +0.005d);
				oarb_fnl_amt[i] = (double)Math.round(oarb_fnl_amt[i] + 0.005d);
				thr_fnl_amt[i]  = (double)Math.round(thr_fnl_amt[i] +0.005d);
				darb_fnl_amt[i] = (double)Math.round(darb_fnl_amt[i]+0.005d);
				di_fnl_frt_rt_amt[i] = (double)Math.round(di_fnl_frt_rt_amt[i] +0.005d);
			}
			
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

			fnl_frt_rt_amt[i] = String.valueOf(oi_fnl_frt_rt_amt[i] + oarb_fnl_amt[i]+ thr_fnl_amt[i]+darb_fnl_amt[i]+di_fnl_frt_rt_amt[i]);
			log.debug("not conversion amount!"+ fnl_frt_rt_amt[i]);
			/* ToT Amount Set VO  */
			list1.get(i).setFnlFrtRtAmt(fnl_frt_rt_amt[i]);
			log.error("S/C~BKG :"+(list1.get(i).getBkgNo())+"AMT: "+list1.get(i).getFnlFrtRtAmt());
			log.debug("-------------------------------------END-------------------------------------");
		}
		return list1;
	}
	
	/**
	 * EsmBkg0269 SearchScOftAutoratingListVO Surcharge is applied to each CHARGE CODE as percent<br>
	 * SearchScOftAutoratingListVO  Surcharge is applied as percent
	 * 
	 * @param List<SearchScOftAutoratingListVO> list1
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> manageSurcharge(List<SearchScOftAutoratingListVO> list1) throws EventException {
		
		List<SearchSurchargePercentBaseChargeListVO> list = searchSurchargePercentBaseChargeList();
		
		List<SearchSurchargeOftFrightListVO> list2 = searchSurchargeOftFrightList();
		
		int chgCnt = list1.size(); // Surcharge Size
		//int bse_chg_cnt = list.size();
		
		//list1  Surcharge retrieve result
		//list   PRI_SCG_PCT_BSE_CHG code value
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
			
			log.debug("getMaxOftCmbSeq~~"+(int)Double.parseDouble(list2.get(0).getMaxOftCmbSeq()));
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
												// Type, exp_amt, rat_as_qty
												totAmt[r] = this.exceptionSurchargeTax(1, expAmt[u],(int)Double.parseDouble(list1.get(i).getRatAsQty()));
											}
										}
									}else if(list1.get(i).getChgCd().equals("VTT")){
										for(int t = 0; t < list1.size(); t++){
											if(list1.get(t).getPorCntCd().equals("VN")){
												if(list1.get(t).getChgCd().equals("OTH")|list1.get(t).getChgCd().equals("ORC") && list1.get(t).getCurrCd().equals("USD")){
													expAmt[t] += Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(t).getChgAmt(),"0"));
													// Type, exp_amt, rat_as_qty
													totAmt[r] += this.exceptionSurchargeTax(2, expAmt[t], (int)Double.parseDouble(list1.get(i).getRatAsQty()));
												}
											}
											if(list1.get(t).getDelCntCd().equals("VN")){
												if(list1.get(t).getChgCd().equals("DTH")|list1.get(t).getChgCd().equals("DDC") && list1.get(t).getCurrCd().equals("USD")){
													expAmt[t] += Double.parseDouble(JSPUtil.getNullNoTrim(list1.get(t).getChgAmt(),"0"));
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
						if(curr_cd[i].equals("BUC")|curr_cd[i].equals("FRC")){
							totAmt[i] = this.runPointProcess(2, totAmt[i]);
						}else{
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
	 * return after calculating result value according to the phase of Conditions <br>
	 * @param type,amount
	 * @exception 
	 */
	 private int runPointProcess(int type, Object amount){
		 String tmpAmount 	= String.valueOf(amount).trim();
		 log.debug("String tmpAmount="+tmpAmount);
		 double  fAmount 	= Double.parseDouble(tmpAmount);
		 log.debug("double  fAmount="+fAmount);
		 int len  			= tmpAmount.length();	
		 log.debug("int len="+len);
		 int point 			= tmpAmount.indexOf(".");
		 log.debug("int point="+point);
		 //[START]//
		 if(point>0){ 
			 int sPoint = point-1;
			 int ePoint = point+2;
			 tmpAmount = tmpAmount.substring(sPoint,ePoint);
		 
		 }else{
			 tmpAmount = tmpAmount.substring(len-1);
		 }
		//[END]//
		 
		 double  dAmount = Double.parseDouble(tmpAmount);
		 log.debug("runPointProcess dAmount="+dAmount);
		 log.debug("runPointProcess type="+type);
			
		//[START]//

		 switch (type) {

		case 1:
			// (0.0d < dAmount && dAmount <= 5.0d)  
			if (0 < Double.compare(dAmount, 0.0d) && 0 >= Double.compare(dAmount,5.0d)) {
				fAmount = (double) Math.floor(fAmount * 0.1d);
				log.debug("~~~~"+fAmount);
				fAmount = fAmount * 10d + 5d;
				log.debug("~~~~!"+fAmount);
			} else {
				fAmount = (double) Math.floor(fAmount);
				fAmount = Math.round(fAmount * 0.1d) * 10d;
			}
			break;
			
		case 2:
			// (0.5d > dAmount)
			if (0 > Double.compare(dAmount, 0.5d)){
				fAmount = (double) Math.floor(fAmount);
			} else {
				fAmount = Math.round(fAmount);
			}
			break;
			
		case 3:
			// (0.0d <= dAmount && dAmount < 2.5d)
			if (0 <= Double.compare(dAmount,0.0d) && 0 > Double.compare(dAmount, 2.5d)){
				fAmount = (double) Math.floor(fAmount * 0.1d);
				fAmount = fAmount * 10d ;// 복원
			// (2.5d <= dAmount && dAmount < 7.5d)
			}else if (0 <= Double.compare(dAmount,2.5d) && 0 > Double.compare(dAmount, 7.5d)){
				fAmount = (double) Math.floor(fAmount * 0.1d);
				fAmount = fAmount * 10d + 5d;
			// (7.5d <= dAmount )				
			}else if (0 <= Double.compare(dAmount,7.5d)){
				fAmount = (double) Math.floor(fAmount);
				fAmount = Math.round(fAmount * 0.1d) * 10d;
			}
			break;
			// 
		default:
			break;
		}
		//[END]//
		 
		 return (int)fAmount;
	 }
	 
	 private int exceptionSurchargeTax(int type, double amount, int qty ){
		 switch(type) {
		 
		 // VDT 
		 case 1:
			 amount = amount /(100 - qty ) * qty;
			 amount = (double) Math.round(amount + 0.5d);
			 break;
			 
	     // VTT POR = VN 
		 //	(OTH+ORC) /(1-VTT rate) X VTT rate
		 case 2:
			 amount = (1- qty) * qty ;
			 amount = (double) Math.round(amount + 0.05d);
			 break;
			 
	     // VTT DEL = VN
		 //	(DTH+DDC) /(1-VTT rate) X VTT rate
		 case 3:
			 amount = (1- qty) * qty ;
			 amount = (double) Math.round(amount + 0.05d);
			 break;
			 
		 default:
			 
			break;
		 }
		 return (int)amount;
	 }
	 
	/**
	 * EsmBkg0256 Re-Audit<br>
	 * Backend로 수행하기 위해 Global Temp 테이블을 삭제시켜줌.
	 * 
	 * @author KIM TAE KYOUNG
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
		
	/**
	 * TAX Surcharge rehandling
	 * 
	 * @param List<SearchScOftAutoratingListVO> list
	 * @param String svcScpCd
	 * @param String rtAplyDt
	 * @return List<SearchScOftAutoratingListVO>
	 */
	public List<SearchScOftAutoratingListVO> manageTaxSurcharge(List<SearchScOftAutoratingListVO> list, String svcScpCd, String rtAplyDt) throws EventException {
		try {
 			List<SearchScOftAutoratingListVO> taxList = new ArrayList<SearchScOftAutoratingListVO>();	//TAX 	charge
			List<SearchScOftAutoratingListVO> chgList = new ArrayList<SearchScOftAutoratingListVO>();	//TAX 를 제외한 charge
			List<SearchScOftAutoratingListVO> noCalcList = new ArrayList<SearchScOftAutoratingListVO>();	//계산제외 로직 charge
			BookingUtil utilBC = new BookingUtil();

			if(list.size()==0) return list;
			log.debug("*******manageTaxSurcharge start list=>"+list.size()+"<<");
			String chgCd 	= null;
			String currCd	= null;
			double dChgAmt = 0.0;
			double dTmpAmt = 0.0;
			double dExChgAmt = 0.0;
			double dUtChgAmt = 0.0;
			double dRateAsQty = 0.0;
			String exRate = "";
			String frtTermCd = null;
			MdmCurrencyVO mdmCurrencyVO = new MdmCurrencyVO();
			String dpPrcsKnt = "";
			String pctBseCd = "";
			MdmChgTaxFlgVO mdmChgTaxFlgVO = new MdmChgTaxFlgVO();

			for(int i=0; i<list.size(); i++){
				SearchScOftAutoratingListVO tmpVO = list.get(i);
				
				if(tmpVO.getInclTaxFlg() == null){
					tmpVO.setInclTaxFlg("N");
				}
				
				if("I".equals(tmpVO.getFrtInclXcldDivCd()) || "E".equals(tmpVO.getFrtInclXcldDivCd())){
					noCalcList.add(tmpVO);
					continue;
				}
				
				//소수점 dpPrcsKnt 자릿수 만큼 반올림 처리 chg_ut_amt, chg_amt
				mdmCurrencyVO = utilBC.searchDpPrcsKntByCur(tmpVO.getCurrCd());
				if(mdmCurrencyVO.getCurrCd() == null)			dpPrcsKnt = "2";
				else											dpPrcsKnt = mdmCurrencyVO.getDpPrcsKnt();
				
				dTmpAmt = Double.parseDouble(JSPUtil.getNullNoTrim(tmpVO.getChgUtAmt(),"0"));
				dTmpAmt = Math.round(dTmpAmt * Math.pow(10, Double.parseDouble(dpPrcsKnt))) / Math.pow(10, Double.parseDouble(dpPrcsKnt));
				tmpVO.setChgUtAmt(String.valueOf(dTmpAmt));
				dTmpAmt = Double.parseDouble(JSPUtil.getNullNoTrim(tmpVO.getChgAmt(),"0"));
				dTmpAmt = Math.round(dTmpAmt * Math.pow(10, Double.parseDouble(dpPrcsKnt))) / Math.pow(10, Double.parseDouble(dpPrcsKnt));
				tmpVO.setChgAmt(String.valueOf(dTmpAmt));
				
				//tax 이면 veitnam tax 인지 check
				mdmChgTaxFlgVO = utilBC.searchChgTaxFlg(tmpVO.getChgCd());
				
				tmpVO.setTaxCntCd(mdmChgTaxFlgVO.getTaxCntCd());
				
				log.debug("******* charge=>"+tmpVO.getInclOftFlg()+"/"+tmpVO.getInGaFlg()+"/"+tmpVO.getFrtInclXcldDivCd()+"/"+tmpVO.getTaxFlg()+"/"+tmpVO.getTaxCntCd()+"/"+tmpVO.getFrtTermCd()+"/"+tmpVO.getCurrCd()+"/"+tmpVO.getChgCd()+"/"+tmpVO.getChgUtAmt()+"/"+tmpVO.getRatAsQty()+"/"+tmpVO.getRatUtCd()+"/"+tmpVO.getChgAmt()+"<<");
				if("Y".equals(tmpVO.getTaxFlg())){
					taxList.add(tmpVO);
				}else{
					chgList.add(tmpVO);
				}
			}
			
			if(taxList.isEmpty()) return list;
			
//			log.debug("before taxList.................."+taxList.size());
			//tax charge 중복 제거
			List<SearchScOftAutoratingListVO> tmpTaxList = new ArrayList<SearchScOftAutoratingListVO>();		//distinct tax charge code list
			boolean isChk = false;
			
			for(int i=0; i<taxList.size(); i++){
				isChk = false;
				if(i==0){
					tmpTaxList.add(taxList.get(i));
					continue;
				}
				
				for(int j=0; j<i; j++){
					if(taxList.get(i).getChgCd().equals(taxList.get(j).getChgCd())
							&& taxList.get(i).getFrtTermCd().equals(taxList.get(j).getFrtTermCd())
							&& taxList.get(i).getRatUtCd().equals(taxList.get(j).getRatUtCd()))
						isChk=true;
				}
				if(!isChk){
					if(!tmpTaxList.contains(taxList.get(i))){
						tmpTaxList.add(taxList.get(i));			//tax charge list
					}
					
//					for(SearchScOftAutoratingListVO tmpVO: tmpTaxList){
//						if(tmpVO.getChgCd().equals(taxList.get(i).getChgCd())
//								&& tmpVO.getFrtTermCd().equals(taxList.get(i).getFrtTermCd()))
//							isChk=true;
//					}
//					if(!isChk)		tmpTaxList.add(taxList.get(i));		//tax charge list
				}
			}
			log.debug("before   taxList...................."+taxList.size());
			log.debug("after tmpTaxList...................."+tmpTaxList.size());
			taxList = tmpTaxList;
			
			
			List<String> taxChgs = new ArrayList<String>();
			for(SearchScOftAutoratingListVO vo : taxList){
				taxChgs.add(vo.getChgCd());
			} 
			////////////////////////////////////////////[ search surcharge ]/////////////////////////////////////////////////////////////////////////
			String bkgNo = list.get(0).getBkgNo();
			List<String> taxTmpChg = new ArrayList<String>();
			List<String> chgTmp    = new ArrayList<String>();
			for(SearchScOftAutoratingListVO chgVO: chgList)
			{
				chgTmp.add(chgVO.getCurrCd());
			}
			
			List<ExchangeRateVO> xchList = utilBC.searchAllXchRate(bkgNo, chgTmp);
			int chgCnt = 0;			//manualSurcharge에 해당하는 전체 charge count
			int chgExCnt = 0;		//manualSurcharge에 해당하는 전체 charge 중 exRate 존재하는 갯수
			boolean isExRate = false;	//tax charge 별 exRate 존재여부 체크
			String useExRate = "N";
			List<String> chgCurrs = new ArrayList<String>();		//no tax chg currency
			List<String> chgExCurrs = new ArrayList<String>();		//tax chg currency

			////////////////////////////////////////////[ main logic ]/////////////////////////////////////////////////////////////////////////
			String locCurrCd = "";
			List<SearchScOftAutoratingListVO> newTaxList = new ArrayList<SearchScOftAutoratingListVO>();	//new tax list
			for(SearchScOftAutoratingListVO taxVO: taxList){
				isExRate = false;
				dExChgAmt = 0.0;
				dChgAmt   = 0.0;
				chgCnt = 0;
				chgExCnt = 0;
				useExRate = "N";
				
				if("PC".equals(taxVO.getRatUtCd())){
					taxTmpChg = new ArrayList<String>();
					taxTmpChg.add(taxVO.getChgCd());

					List<ExchangeRateVO> arCurrList = utilBC.searchArCurByTaxChg(bkgNo, taxTmpChg);
					
					//1. LOCAL CURRENCY ---- search ar_currency(PRE_CURR, COL_CURR)
					for(ExchangeRateVO exvo: arCurrList)
					{
						if("P".equals(taxVO.getFrtTermCd()))
						{
							locCurrCd = exvo.getPreCurr();
							break;
						}else if("C".equals(taxVO.getFrtTermCd()))
						{
							locCurrCd = exvo.getColCurr();
							break;
						}
					}

					//Vietnam tax check
					String n3ptyLocCd = "";
					String n3ptyCntCd = "";
//					String taxCntCd	  = "";

					chgCurrs = new ArrayList<String>();
					chgExCurrs = new ArrayList<String>();
					
					//2. useExRate, chgCurrs by TAX CHARGE 
					//   2-1. manaulSurcharge
					//   2-2. searchAllXchRate
					for(SearchScOftAutoratingListVO chgVO: chgList)
					{                                                                                                                                                   
						if(!taxVO.getFrtTermCd().equals(chgVO.getFrtTermCd()))		continue;
						
						if(null==chgVO.getN3ptyRcvOfcCd()){
							log.debug("n3ptyRcvOfcCd is NULL.....");
						}else{
							if("".equals(chgVO.getN3ptyRcvOfcCd())){
								log.debug("n3ptyRcvOfcCd is space.....");
							}else{
								n3ptyLocCd = utilBC.searchLocCdByOfcCd(chgVO.getN3ptyRcvOfcCd());
								n3ptyCntCd = "";
								
								if(n3ptyLocCd!=null){
									if(n3ptyLocCd.length()>2){
										n3ptyCntCd = n3ptyLocCd.substring(0, 2);
									}
								}
								log.debug("[taxCntCd]"+taxVO.getTaxCntCd()+"[n3ptyCntCd]"+n3ptyCntCd);
								if(n3ptyCntCd.length()>1){
//									if("VN".equals(taxVO.getTaxCntCd()) && "VN".equals(n3ptyCntCd))	continue;
									if("VN".equals(taxVO.getTaxCntCd()))	continue;
								}
							}
						}
						
						List<String> chgTmpCds = new ArrayList<String>();
						chgTmpCds.add(chgVO.getChgCd());
						List<ManualSurchargeVO> srcChgList = utilBC.manualSurcharge(rtAplyDt, svcScpCd, taxTmpChg, chgTmpCds);
						if(srcChgList != null && srcChgList.size()>0)
						{
							chgCnt++;
							if(!chgCurrs.contains(chgVO.getCurrCd())){
								chgCurrs.add(chgVO.getCurrCd());
							}
							
							//3. search inv_xch_rt 
							for(ExchangeRateVO xchVO: xchList)
							{
								//curr_cd, l_curr_cd, type
								if(xchVO.getCurrCd().equals(chgVO.getCurrCd()) 
								   && xchVO.getLCurrCd().equals(locCurrCd) 
								   && xchVO.getType().equals(chgVO.getFrtTermCd()))
								{
									isExRate = true;
									chgExCnt++;
									if(!chgExCurrs.contains(chgVO.getCurrCd())){
										chgExCurrs.add(chgVO.getCurrCd());
									}
								}
							}
						}
					}
					
					log.debug("[tax_chg/isExRate/chg_count/chg_ex_count/chg_curr_size]"+taxVO.getChgCd()+"/"+isExRate+"/"+chgCnt+"/"+chgExCnt+"/"+chgCurrs.size());
					if(isExRate && (chgCnt == chgExCnt)){
						useExRate = "Y";
					}
					//////////////////////////////////////////////////////////////////////////////////////////////
					if("Y".equals(useExRate))
					{
						log.debug("****IS TAX CAL STAR <<<<<<<<<<<<<<<<<<<"+taxVO.getChgCd());
						for(int i=0; i< chgExCurrs.size(); i++)
						{
							
							dExChgAmt = 0.0;
							dChgAmt   = 0.0;

							log.debug("[CHARGE CURR_CD]("+i+")"+chgExCurrs.get(i));
							for(SearchScOftAutoratingListVO chgVO: chgList)
							{                                                                                                                                                   
								if(!taxVO.getFrtTermCd().equals(chgVO.getFrtTermCd()))	continue;
								if(!chgExCurrs.get(i).equals(chgVO.getCurrCd()))		continue;
								
								if(null==chgVO.getN3ptyRcvOfcCd()){
									log.debug("n3ptyOfcCd is null..........");
								}else{
									if("".equals(chgVO.getN3ptyRcvOfcCd())){

										log.debug("n3ptyOfcCd is space..........");
									}else{
										n3ptyLocCd = utilBC.searchLocCdByOfcCd(chgVO.getN3ptyRcvOfcCd());
										n3ptyCntCd = "";
										
										if(n3ptyLocCd!=null){
											if(n3ptyLocCd.length()>2){
												n3ptyCntCd = n3ptyLocCd.substring(0, 2);
											}
										}
										
										log.debug("[taxCntCd]"+taxVO.getTaxCntCd()+"[n3ptyCntCd]"+n3ptyCntCd);
										if(n3ptyCntCd.length()>1){
//											if("VN".equals(taxVO.getTaxCntCd()) && "VN".equals(n3ptyCntCd))	continue;
											if("VN".equals(taxVO.getTaxCntCd()))	continue;
										}
									}
								}
								
//								if("C".equals(chgVO.getFrtTermCd())){
								List<String> chgTmpCds = new ArrayList<String>();
								chgTmpCds.add(chgVO.getChgCd());
								List<ManualSurchargeVO> srcChgList = utilBC.manualSurcharge(rtAplyDt, svcScpCd, taxTmpChg, chgTmpCds);
								if(srcChgList != null && srcChgList.size()>0)
								{
									pctBseCd = srcChgList.get(0).getPctBseCd();
									//3. search inv_xch_rt 
									for(ExchangeRateVO xchVO: xchList)
									{
										if(xchVO.getCurrCd().equals(chgVO.getCurrCd()) 
									       && xchVO.getLCurrCd().equals(locCurrCd) 
									       && chgVO.getFrtTermCd().equals(xchVO.getType()))
										{
											dChgAmt += Double.parseDouble(JSPUtil.getNullNoTrim(chgVO.getChgAmt(),"0"));
											exRate  = xchVO.getInvXchRt();
										}
									}
								}
							}
							//end of SearchScOftAutoratingListVO......
							
							
							SearchScOftAutoratingListVO newVO = new SearchScOftAutoratingListVO();
							
							newVO.setBkgNo(taxVO.getBkgNo());
							newVO.setFrtInclXcldDivCd(taxVO.getFrtInclXcldDivCd());
							newVO.setDeTermCd(taxVO.getDeTermCd());
							newVO.setRcvTermCd(taxVO.getRcvTermCd());
							newVO.setChgCd(taxVO.getChgCd());
							newVO.setFrtTermCd(taxVO.getFrtTermCd());
							newVO.setCgoTpCd(taxVO.getCgoTpCd());
							newVO.setRatUtCd(taxVO.getRatUtCd());
							newVO.setOftCmbSeq(taxVO.getOftCmbSeq());
							newVO.setTaxFlg(taxVO.getTaxFlg());
							newVO.setTaxCntCd(taxVO.getTaxCntCd());
							newVO.setInclTaxFlg(taxVO.getInclTaxFlg());
							newVO.setRatAsQty(taxVO.getRatAsQty());
							newVO.setImdgClssCd(taxVO.getImdgClssCd());

							/////////////////////////////////////////////////////
							//sum of currency start......
							//chgUtAmt, chgAmt, CurrCd, PctBseCd
							dChgAmt = dChgAmt * Double.parseDouble(JSPUtil.getNullNoTrim(exRate,"0"));		// 환율 계산.
							dExChgAmt = dChgAmt * Double.parseDouble(JSPUtil.getNullNoTrim(taxVO.getRatAsQty(),"0"));
							dExChgAmt = dExChgAmt / 100;
							log.debug("****exRate>>"+chgExCurrs.get(i)+"/"+locCurrCd+"/"+exRate+"<<");
							
							newVO.setChgUtAmt(String.valueOf(dChgAmt));
							newVO.setChgAmt(String.valueOf(dExChgAmt));
							newVO.setCurrCd(locCurrCd);
							newVO.setPctBseCd(pctBseCd);
							log.debug("****IS TAX CAL..=>"+newVO.getChgCd()+"/"+newVO.getChgUtAmt()+"/"+newVO.getCurrCd()+"/"+newVO.getRatAsQty()+"/"+newVO.getChgAmt()+"<<");
							
							newTaxList.add(newVO);
						}
						//end of currency ......
					}else{
						log.debug("****IS NO TAX CAL STAR <<<<<<<<<<<<<<<<<<<"+taxVO.getChgCd());
						for(int i=0; i< chgCurrs.size(); i++)
						{
							dChgAmt   = 0.0;
							locCurrCd = chgCurrs.get(i);
							log.debug("[CHARGE CURR_CD]("+i+")"+chgCurrs.get(i));
							for(SearchScOftAutoratingListVO chgVO: chgList)
							{                                                                                                                                                   
								if(!taxVO.getFrtTermCd().equals(chgVO.getFrtTermCd()))	continue;
								if(!chgCurrs.get(i).equals(chgVO.getCurrCd()))			continue;
								
								if(null==chgVO.getN3ptyRcvOfcCd()){
									log.debug("n3ptyOfcCd is null..........");
								}else{
									if("".equals(chgVO.getN3ptyRcvOfcCd())){

										log.debug("n3ptyOfcCd is space..........");
									}else{
										n3ptyLocCd = utilBC.searchLocCdByOfcCd(chgVO.getN3ptyRcvOfcCd());
										n3ptyCntCd = "";
										
										if(n3ptyLocCd!=null){
											if(n3ptyLocCd.length()>2){
												n3ptyCntCd = n3ptyLocCd.substring(0, 2);
											}
										}
										
										log.debug("[taxCntCd]"+taxVO.getTaxCntCd()+"[n3ptyCntCd]"+n3ptyCntCd);
										if(n3ptyCntCd.length()>1){
//											if("VN".equals(taxVO.getTaxCntCd()) && "VN".equals(n3ptyCntCd))	continue;
											if("VN".equals(taxVO.getTaxCntCd()))	continue;
										}
									}
								}
								
								List<String> chgTmpCds = new ArrayList<String>();
								chgTmpCds.add(chgVO.getChgCd());
								List<ManualSurchargeVO> srcChgList = utilBC.manualSurcharge(rtAplyDt, svcScpCd, taxTmpChg, chgTmpCds);
								if(srcChgList != null && srcChgList.size()>0)
								{
									pctBseCd = srcChgList.get(0).getPctBseCd();
									dChgAmt += Double.parseDouble(JSPUtil.getNullNoTrim(chgVO.getChgAmt(),"0"));
								}
							}
							//end of SearchScOftAutoratingListVO......
							
							//sum of currency start......
							//chgUtAmt, chgAmt, CurrCd, PctBseCd
							taxVO.setChgUtAmt(String.valueOf(dChgAmt));
							dChgAmt = dChgAmt * Double.parseDouble(JSPUtil.getNullNoTrim(taxVO.getRatAsQty(),"0"));
							dChgAmt = dChgAmt / 100;
							
							taxVO.setChgAmt(String.valueOf(dChgAmt));
							taxVO.setPctBseCd(pctBseCd);
							log.debug("****IS NO TAX CAL..=>"+taxVO.getChgCd()+"/"+taxVO.getChgUtAmt()+"/"+taxVO.getCurrCd()+"/"+taxVO.getRatAsQty()+"/"+taxVO.getChgAmt()+"<<");
							
							
							SearchScOftAutoratingListVO newVO = new SearchScOftAutoratingListVO();
							
							newVO.setBkgNo(taxVO.getBkgNo());
							newVO.setFrtInclXcldDivCd(taxVO.getFrtInclXcldDivCd());
							newVO.setDeTermCd(taxVO.getDeTermCd());
							newVO.setRcvTermCd(taxVO.getRcvTermCd());
							newVO.setChgCd(taxVO.getChgCd());
							newVO.setFrtTermCd(taxVO.getFrtTermCd());
							newVO.setCgoTpCd(taxVO.getCgoTpCd());
							newVO.setRatUtCd(taxVO.getRatUtCd());
							newVO.setOftCmbSeq(taxVO.getOftCmbSeq());
							newVO.setTaxFlg(taxVO.getTaxFlg());
							newVO.setTaxCntCd(taxVO.getTaxCntCd());
							newVO.setInclTaxFlg(taxVO.getInclTaxFlg());
							newVO.setRatAsQty(taxVO.getRatAsQty());
							newVO.setImdgClssCd(taxVO.getImdgClssCd());
							
							////////////////////////////////////////////////////////////////////
							newVO.setChgUtAmt(taxVO.getChgUtAmt());
							newVO.setChgAmt(taxVO.getChgAmt());
							newVO.setCurrCd(locCurrCd);
							newVO.setPctBseCd(taxVO.getPctBseCd());
							
							newTaxList.add(newVO);
						}
						//end of currency ......
					}
				}else{
					SearchScOftAutoratingListVO newVO = new SearchScOftAutoratingListVO();
					
					newVO.setBkgNo(taxVO.getBkgNo());
					newVO.setFrtInclXcldDivCd(taxVO.getFrtInclXcldDivCd());
					newVO.setDeTermCd(taxVO.getDeTermCd());
					newVO.setRcvTermCd(taxVO.getRcvTermCd());
					newVO.setChgCd(taxVO.getChgCd());
					newVO.setFrtTermCd(taxVO.getFrtTermCd());
					newVO.setCgoTpCd(taxVO.getCgoTpCd());
					newVO.setRatUtCd(taxVO.getRatUtCd());
					newVO.setOftCmbSeq(taxVO.getOftCmbSeq());
					newVO.setTaxFlg(taxVO.getTaxFlg());
					newVO.setTaxCntCd(taxVO.getTaxCntCd());
					newVO.setInclTaxFlg(taxVO.getInclTaxFlg());
					newVO.setRatAsQty(taxVO.getRatAsQty());
					newVO.setImdgClssCd(taxVO.getImdgClssCd());
					newVO.setChgUtAmt(taxVO.getChgUtAmt());
					newVO.setChgAmt(taxVO.getChgAmt());
					newVO.setCurrCd(taxVO.getCurrCd());
					newVO.setPctBseCd(taxVO.getPctBseCd());
					newTaxList.add(newVO);
				}
			}
			for(int kk=0; kk<newTaxList.size(); kk++){
				log.debug("****newTaxList debug..=>"+newTaxList.get(kk).getChgCd()+"/"+newTaxList.get(kk).getChgUtAmt()+"/"+newTaxList.get(kk).getCurrCd()+"/"+newTaxList.get(kk).getChgAmt()+"<<");
			}
//			
			
			/////////////////////////////////////////////// [중복제거용 LIST 생성 [CHG_CD, CURR_CD, FRT_TERM_CD ] //////////////////////////////////////////////////////////////////////
			//중복제거용 List 생성---CHG_CD, CURR_CD, FRT_TERM_CD -- exchange Rate가 되면 sum을 할 계획
			List<SearchScOftAutoratingListVO> calcChgList2 = new ArrayList<SearchScOftAutoratingListVO>();	//중복제거용 List
			boolean isCheck = false;
			String ratUtCd = "";

			if(newTaxList!=null && newTaxList.size()>0){
				for(int i=0; i<newTaxList.size(); i++){
					SearchScOftAutoratingListVO vo = new SearchScOftAutoratingListVO();
					isCheck = false;
					chgCd 		= newTaxList.get(i).getChgCd();
					currCd 		= newTaxList.get(i).getCurrCd();
					frtTermCd 	= newTaxList.get(i).getFrtTermCd();
					ratUtCd		= newTaxList.get(i).getRatUtCd();
					
					if(i==0){
						vo.setChgCd(chgCd);
						vo.setCurrCd(currCd);
						vo.setFrtTermCd(frtTermCd);
						vo.setRatUtCd(ratUtCd);
						
						calcChgList2.add(vo);
//						log.debug("******* calcChgList2 =>"+vo.getCurrCd()+"/"+vo.getChgCd()+"/"+vo.getFrtTermCd()+"<<");
						continue;
					}
					
					for(int j=0; j<i; j++){
						if(chgCd.equals(newTaxList.get(j).getChgCd()) 
								&& currCd.equals(newTaxList.get(j).getCurrCd())	
								&& frtTermCd.equals(newTaxList.get(j).getFrtTermCd())
								&& ratUtCd.equals(newTaxList.get(j).getRatUtCd()))
						{
							isCheck=true;		//중복코드가 존재한다.
							break;
						}
					}
					if(!isCheck){
						vo.setChgCd(chgCd);
						vo.setCurrCd(currCd);
						vo.setFrtTermCd(frtTermCd);
						vo.setRatUtCd(ratUtCd);
						
						if(!calcChgList2.contains(vo)){
							calcChgList2.add(vo);			//tax charge list
						}
//						log.debug("******* calcChgList2 =>"+vo.getCurrCd()+"/"+vo.getChgCd()+"/"+vo.getFrtTermCd()+"<<");
					}
				}
			}
			/////////////////////////////////////////////// [sum chgUtAmt, sum chgAmt ] //////////////////////////////////////////////////////////////////////
			List<SearchScOftAutoratingListVO> calcChgList3 = new ArrayList<SearchScOftAutoratingListVO>();	//tax 별 sum list

			for(SearchScOftAutoratingListVO taxCalVO2 : calcChgList2){		//for.... calcChgList2 [CHG_CD, CURR_CD, FRT_TERM_CD]
				log.debug("******* calcChgList2 =>"+taxCalVO2.getCurrCd()+"/"+taxCalVO2.getChgCd()+"/"+taxCalVO2.getFrtTermCd()+"<<");
				dUtChgAmt = 0.0;
				dRateAsQty = 0.0;
				chgCd 		= taxCalVO2.getChgCd();
				currCd 		= taxCalVO2.getCurrCd();
				frtTermCd 	= taxCalVO2.getFrtTermCd();
				ratUtCd		= taxCalVO2.getRatUtCd();
				
				SearchScOftAutoratingListVO taxCalVO3 = new SearchScOftAutoratingListVO();
				//tax calculation - exchange rate
				if(newTaxList!=null && newTaxList.size()>0){
//					for(SearchScOftAutoratingListVO taxCalVO : newTaxList){	//for... original calcChgList
					for(int i=0; i<newTaxList.size(); i++){
						SearchScOftAutoratingListVO taxCalVO = newTaxList.get(i);
						if(chgCd.equals(taxCalVO.getChgCd()) 
								&& currCd.equals(taxCalVO.getCurrCd())	
								&& frtTermCd.equals(taxCalVO.getFrtTermCd())
								&& ratUtCd.equals(taxCalVO.getRatUtCd()))
						{
							log.debug("******* newTaxList taxCalVO=>"+taxCalVO.getFrtTermCd()+"/"+taxCalVO.getCurrCd()+"/"+taxCalVO.getTaxFlg()+"/"+taxCalVO.getChgCd()+"/"+taxCalVO.getChgUtAmt()+"/"+taxCalVO.getRatAsQty()+"/"+taxCalVO.getRatUtCd()+"/"+taxCalVO.getChgAmt()+"/"+taxCalVO.getPctBseCd()+"<<");
							taxCalVO3 = new SearchScOftAutoratingListVO();
							taxCalVO3 = (SearchScOftAutoratingListVO)taxCalVO.clone(); 
							dUtChgAmt += Double.parseDouble(JSPUtil.getNullNoTrim(taxCalVO.getChgUtAmt(),"0"));
							dRateAsQty = Double.parseDouble(JSPUtil.getNullNoTrim(taxCalVO.getRatAsQty(),"0"));
//							log.debug("******* equal taxCalVO=>"+taxCalVO.getFrtTermCd()+"/"+taxCalVO.getCurrCd()+"/"+taxCalVO.getTaxFlg()+"/"+taxCalVO.getChgCd()+"/"+taxCalVO.getChgUtAmt()+"/"+taxCalVO.getRatAsQty()+"/"+taxCalVO.getRatUtCd()+"/"+taxCalVO.getChgAmt()+"/"+taxCalVO.getPctBseCd()+"<<");
	//						log.debug("******* sumCharge =>"+chgCd+"/"+currCd+"/"+dUtChgAmt+"/"+dChgAmt+"<<");
						}
					}
				}
				
				if(dUtChgAmt == 0)		continue;

				
				//소수점 dpPrcsKnt 자릿수 만큼 반올림 처리
				mdmCurrencyVO = utilBC.searchDpPrcsKntByCur(taxCalVO2.getCurrCd());
				if(mdmCurrencyVO.getCurrCd() == null)			dpPrcsKnt = "2";
				else											dpPrcsKnt = mdmCurrencyVO.getDpPrcsKnt();
				
				
				if("PC".equals(ratUtCd)){
					dUtChgAmt = Math.round(dUtChgAmt * Math.pow(10, Double.parseDouble(dpPrcsKnt))) / Math.pow(10, Double.parseDouble(dpPrcsKnt));
					dChgAmt = ( dUtChgAmt * dRateAsQty) /100;
					dChgAmt = Math.round(dChgAmt * Math.pow(10, Double.parseDouble(dpPrcsKnt))) / Math.pow(10, Double.parseDouble(dpPrcsKnt));
				}else{
					dUtChgAmt = Math.round(dUtChgAmt * Math.pow(10, Double.parseDouble(dpPrcsKnt))) / Math.pow(10, Double.parseDouble(dpPrcsKnt));
					dChgAmt = ( dUtChgAmt * dRateAsQty) ;
					dChgAmt = Math.round(dChgAmt * Math.pow(10, Double.parseDouble(dpPrcsKnt))) / Math.pow(10, Double.parseDouble(dpPrcsKnt));
				}
				
				taxCalVO3.setChgUtAmt(String.valueOf(dUtChgAmt));
				taxCalVO3.setChgAmt(String.valueOf(dChgAmt));
				log.debug("******* sumTaxCharge =>"+taxCalVO3.getFrtTermCd()+"/"+taxCalVO3.getCurrCd()+"/"+taxCalVO3.getTaxFlg()+"/"+taxCalVO3.getChgCd()+"/"+taxCalVO3.getChgUtAmt()+"/"+taxCalVO3.getRatAsQty()+"/"+taxCalVO3.getRatUtCd()+"/"+taxCalVO3.getChgAmt()+"/"+taxCalVO3.getPctBseCd()+"<<");
				
				calcChgList3.add(taxCalVO3);								//add...... calcChgList3        SUM(ChgUtAmt),SUM(ChgAmt)
				
				chgList.add(taxCalVO3);
//				log.debug("******* end =<<");
			}
			for(SearchScOftAutoratingListVO noCalcVO : noCalcList){
				chgList.add(noCalcVO);
			}
			
			log.debug("******* after list=>"+chgList.size()+"<<");
			return chgList;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmBkg007908 save event process<br>
	 * tax exchange rate charge calculation
	 * @param BkgChgRateVO[] bkgChgRateVOs
	 * @param String bkgNo
	 * @param String svcScpCd
	 * @param String rtAplyDt
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchTaxSurchargeList(BkgChgRateVO[] bkgChgRateVOs, String bkgNo, String svcScpCd, String rtAplyDt) throws EventException{
		List<SearchScOftAutoratingListVO> list1 = new ArrayList<SearchScOftAutoratingListVO>();
		List<SearchScOftAutoratingListVO> list2 = new ArrayList<SearchScOftAutoratingListVO>();
		
		try{
			if(bkgChgRateVOs == null || bkgChgRateVOs.length==0)		return null;
			
			for(int i=0; i<bkgChgRateVOs.length; i++){
				SearchScOftAutoratingListVO searchScOftAutoratingListVO = new SearchScOftAutoratingListVO();
				
//				if("I".equals(bkgChgRateVOs[i].getInclOftFlg()) || "E".equals(bkgChgRateVOs[i].getInclOftFlg()))
//					continue;
				
				
//				if(!"D".equals(bkgChgRateVOs[i].getIbflag())){
					searchScOftAutoratingListVO = new SearchScOftAutoratingListVO();
					searchScOftAutoratingListVO.setBkgNo(bkgNo);
					searchScOftAutoratingListVO.setFrtTermCd(bkgChgRateVOs[i].getFrtTermCd());
					searchScOftAutoratingListVO.setCurrCd(bkgChgRateVOs[i].getCurrCd());
					searchScOftAutoratingListVO.setTaxFlg(bkgChgRateVOs[i].getTaxFlg());
					searchScOftAutoratingListVO.setChgCd(bkgChgRateVOs[i].getChgCd());
					searchScOftAutoratingListVO.setChgUtAmt(bkgChgRateVOs[i].getChgUtAmt());
					searchScOftAutoratingListVO.setRatAsQty(bkgChgRateVOs[i].getRatAsQty());
					searchScOftAutoratingListVO.setRatUtCd(bkgChgRateVOs[i].getRatUtCd());
					searchScOftAutoratingListVO.setChgAmt(bkgChgRateVOs[i].getChgAmt());
					searchScOftAutoratingListVO.setFrtInclXcldDivCd(bkgChgRateVOs[i].getInclOftFlg()); 
					searchScOftAutoratingListVO.setCgoTpCd(bkgChgRateVOs[i].getCgoCateCd());
					searchScOftAutoratingListVO.setRcvTermCd(bkgChgRateVOs[i].getRcvTermCd());
					searchScOftAutoratingListVO.setDeTermCd(bkgChgRateVOs[i].getDeTermCd());
					searchScOftAutoratingListVO.setN3ptyRcvOfcCd(bkgChgRateVOs[i].getN3ptyRcvOfcCd());
					
					list1.add(searchScOftAutoratingListVO);
//				}
			}
			
			
			log.debug("IN LINE ----------->"+list1.size());
			
			list2 = manageTaxSurcharge(list1, svcScpCd, rtAplyDt);
			log.debug("OUT LINE ----------->"+list2.size());
			
//		} catch (DAOException ex) {
//			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list2;
		
	}
	
	/**
	 * EsmBKg0739 management event process<br>
	 * calling fare calculation service about searchSurchargeAutoratingList corresponding to booking no(Inclue OFT,return Exclue OFT) <br>
	 * @param ScOftAutoratingListVO vo
	 * @param SearchScOftAutoratingListVO[] vos
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingInclTaxList(ScOftAutoratingListVO vo, SearchScOftAutoratingListVO[] vos) throws EventException{
	
		try {
			List<SearchScOftAutoratingListVO> list1 = dbDao.searchSurchargeAutoratingList(vo);
			BigDecimal chgAmt ;
			BigDecimal chkAmt ;
			for(int i = 0; i<list1.size(); i++){
					if(!"PC".equals(list1.get(i).getRatUtCd())){
						String chgUtAmt = JSPUtil.getNullNoTrim(list1.get(i).getChgUtAmt(),"0.0");
						String rateAsQty = JSPUtil.getNullNoTrim(list1.get(i).getRatAsQty(),"0.0");
						String amt = JSPUtil.getNullNoTrim(list1.get(i).getChgAmt(),"0.0");
						
						chkAmt = new BigDecimal(chgUtAmt).multiply(new BigDecimal(rateAsQty));
						chgAmt = new BigDecimal(amt);
						if(chkAmt.compareTo(chgAmt) != 0){
							log.error("chgUtAmt: "+Double.parseDouble(chgUtAmt));
							log.error("rateAsQty "+Double.parseDouble(rateAsQty));
							log.error("Surcharge BKG: "+list1.get(i).getBkgNo()+" PER["+list1.get(i).getRatUtCd()+"]"+" Amount["+list1.get(i).getChgAmt()+"]"+" RATE["+list1.get(i).getChgUtAmt()+"]"+" RATEAS["+list1.get(i).getRatAsQty()+"]");	
						}
					}
			}
			for(int i = 0; i< list1.size(); i++){
				list1.get(i).setFnlFrtRtAmt(vo.getFnlFrtRtAmt());
			}
			for(int i = 0; i< vos.length; i++){
				list1.add(vos[i]);
			}
//			return manageSurcharge(list1);
			
			list1 = manageTaxSurcharge(list1, vo.getsvcScpCd(), vo.getRtAplyDt());
			
			//exclude 'OFT'
			List<SearchScOftAutoratingListVO> list2 = new ArrayList<SearchScOftAutoratingListVO>();
			
			for(int i = 0; i < list1.size(); i++){
				if(list1.get(i).getInclTaxFlg().equals("Y")){
					continue;
				}
				list2.add(list1.get(i));
			}
			
			return list2;
//			return dbDao.searchSurchargeAutoratingList(bkgNo,caFlag,scpCd, cmdtCd, ctrtTpCd );

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	
	}
	

}