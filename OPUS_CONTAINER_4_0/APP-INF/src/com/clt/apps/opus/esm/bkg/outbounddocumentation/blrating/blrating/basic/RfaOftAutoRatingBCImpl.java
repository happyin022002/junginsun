/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion :
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration.RfaOftAutoRatingDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-RfaOftAutoRating Business Logic Basic Command implementation<br>
 * - OPUS-RfaOftAutoRating handling business transaction.<br>
 * 
 * @author
 * @see
 * @since J2EE 1.6
 */

public class RfaOftAutoRatingBCImpl extends BasicCommandSupport implements RfaOftAutoRatingBC{

	
	// Database Access Object
	private transient RfaOftAutoRatingDBDAO dbDao = null;
	
	/**
	 * Generating BlRatingBCImpl Object<br>
	 * Generating BlRatingDBDAO<br>
	 */
	public RfaOftAutoRatingBCImpl() {
		dbDao = new RfaOftAutoRatingDBDAO();
	}
	
	/**
	 *  Handling retrieving event of EsmBkg0739<br>
	 * 
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
	 *  Handling retrieving event of EsmBkg0739<br>
	 * 
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
		double oi_fnl_frt_amt [] = new double [k]; // OIH AMT 
		double di_fnl_frt_amt [] = new double [k]; // DIH AMT
		double rt_app_frt_rt_amt [] = new double [k]; // RT
		double rt_ras_frt_rt_amt [] = new double [k];
		
		for(int j = 0; j< list.size(); j++){
			rt_fnl_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtFnlFrtRtAmt(),"0"));
			rt_ras_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtRasFrtRtAmt(),"0"));
			oa_fnl_frt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOaFnlFrtRtAmt(),"0"));
			da_fnl_frt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getDaFnlFrtRtAmt(),"0"));
			oi_fnl_frt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOiFnlFrtRtAmt(),"0"));
			di_fnl_frt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getDiFnlFrtRtAmt(),"0"));
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
			
			fnl_frt_rt_amt[i] = oi_fnl_frt_amt[i] + di_fnl_frt_amt[i] + oa_fnl_frt_amt[i] + da_fnl_frt_amt[i] + rt_fnl_frt_rt_amt[i] ;
			
			
			oa_fnl_frt_amt[i] = (double)Math.round(oa_fnl_frt_amt[i] + 0.005d);
			oi_fnl_frt_amt[i] = (double)Math.round(oi_fnl_frt_amt[i] + 0.005d);
			rt_fnl_frt_rt_amt[i]  = (double)Math.round(rt_fnl_frt_rt_amt[i] +0.005d);
			da_fnl_frt_amt[i] = (double)Math.round(da_fnl_frt_amt[i]+0.005d);
			di_fnl_frt_amt[i] = (double)Math.round(di_fnl_frt_amt[i]+0.005d);
			fnl_frt_rt_amt[i] = (double)Math.round(fnl_frt_rt_amt[i]+0.005d);
			
			log.debug("!!fnl_frt_rt_amt"+fnl_frt_rt_amt[i]);
//			list.get(i).setRtCalcFrtRtAmt(String.valueOf(rt_fnl_frt_rt_amt[i]).substring(0, String.valueOf(rt_fnl_frt_rt_amt[i]).indexOf(".")));
			list.get(i).setRtCalcFrtRtAmt(String.valueOf(rt_fnl_frt_rt_amt[i]));
			list.get(i).setOaCalcFrtRtAmt(String.valueOf(oa_fnl_frt_amt[i]));
			list.get(i).setDaCalcFrtRtAmt(String.valueOf(da_fnl_frt_amt[i]));
			list.get(i).setOiCalcFrtRtAmt(String.valueOf(oi_fnl_frt_amt[i]));
			list.get(i).setDiCalcFrtRtAmt(String.valueOf(di_fnl_frt_amt[i]));
			list.get(i).setFnlFrtRtAmt(String.valueOf(fnl_frt_rt_amt[i]));
			
		}
//		list1.get(i).setFnlFrtRtAmt(fnl_frt_rt_amt[i].substring(0,fnl_frt_rt_amt[i].indexOf(".")));
		
		
		
		return list ;
		
	}	
}