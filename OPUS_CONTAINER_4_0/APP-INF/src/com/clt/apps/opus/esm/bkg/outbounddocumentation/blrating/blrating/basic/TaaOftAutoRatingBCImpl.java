/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TaaOftAutoRatingBCImpl.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration.TaaOftAutoRatingDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-TaaOftAutoRating Business Logic Command Interface<br>
 * - OPUS-TaaOftAutoRating biz Logic Interface<br>
 * 
 * @author
 * @see Esm_bkg_1076EventResponse reference
 * @since J2EE 1.6
 */

public class TaaOftAutoRatingBCImpl extends BasicCommandSupport implements TaaOftAutoRatingBC{

	
	// Database Access Object
	private transient TaaOftAutoRatingDBDAO dbDao = null;

	/**
	 * BlRatingBCImpl objects creation<br>
	 * BlRatingDBDAO creation<br>
	 */
	public TaaOftAutoRatingBCImpl() {
		dbDao = new TaaOftAutoRatingDBDAO();
	}
	
	/**
	 * Searching the US Cargo rating <br>
	 * 
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
	 * Searching the US Cargo rating
	 * 
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
		
		
		String fnl_frt_rt_amt [] = new String [k]; // Final AMT
		
		double rt_fnl_frt_rt_amt [] = new double [k];  // THR AMT
		double rt_calc_frt_rt_amt [] = new double [k]; // CALC AMT 
		double rt_app_frt_rt_amt [] = new double [k]; // RT AMT
		double rt_typ_frt_rt_amt [] = new double [k]; // TYP AMT
		double rt_rac_frt_rt_amt [] = new double [k]; // RAC AMT
		double oa_fnl_frt_rt_amt [] = new double [k]; // OARB AMT 
		double da_fnl_frt_rt_amt [] = new double [k]; // DARB AMT
		double oi_fnl_frt_rt_amt [] = new double [k]; // OIH AMT 
		double di_fnl_frt_rt_amt [] = new double [k]; // DIH AMT
		double oa_typ_frt_rt_amt [] = new double [k]; // TYP AMT
		double oa_rac_frt_rt_amt [] = new double [k]; // RAC AMT
		double da_typ_frt_rt_amt [] = new double [k]; // TYP AMT
		double da_rac_frt_rt_amt [] = new double [k]; // RAC AMT
		
		for(int j = 0; j< list.size(); j++){
			rt_fnl_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtFnlFrtRtAmt(),"0"));
			rt_calc_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtCalcFrtRtAmt(),"0"));
			rt_app_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtAppFrtRtAmt(),"0"));
			rt_typ_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtTypFrtRtAmt(),"0"));
			rt_rac_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getRtRacFrtRtAmt(),"0"));
			oa_fnl_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOaFnlFrtRtAmt(),"0"));
			da_fnl_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getDaFnlFrtRtAmt(),"0"));
			oi_fnl_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOiFnlFrtRtAmt(),"0"));
			di_fnl_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getDiFnlFrtRtAmt(),"0"));

			oa_typ_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOaTypFrtRtAmt(),"0"));
			oa_rac_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getOaRacFrtRtAmt(),"0"));
			da_typ_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getDaTypFrtRtAmt(),"0"));
			da_rac_frt_rt_amt[j] = Double.parseDouble(JSPUtil.getNullNoTrim(list.get(j).getDaRacFrtRtAmt(),"0"));
		}
		
		for(int i = 0; i< list.size(); i++){
			
			 
			/* OIH */
			if((int)oi_fnl_frt_rt_amt[i] != 0){
				if("C".equals(list.get(i).getOaTypBkgConvTpCd()) && !"+".equals(list.get(i).getOaTypRtOpCd()) && !"-".equals(list.get(i).getOaTypRtOpCd())){
					if("*".equals(list.get(i).getOaTypRtOpCd())){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] * oa_typ_frt_rt_amt[i];
					}
					else if("/".equals(list.get(i).getOaTypRtOpCd())){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] / oa_typ_frt_rt_amt[i];
					}
				}
				if("C".equals(list.get(i).getOaRacBkgConvTpCd()) && !"+".equals(list.get(i).getOaRacRtOpCd()) && !"-".equals(list.get(i).getOaRacRtOpCd())){
					if("*".equals(list.get(i).getOaRacRtOpCd())){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] * oa_rac_frt_rt_amt[i];
					}
					else if("/".equals(list.get(i).getOaRacRtOpCd())){
						oi_fnl_frt_rt_amt[i] = oi_fnl_frt_rt_amt[i] / oa_rac_frt_rt_amt[i];
					}
				}
			}
			//OARB 
			if((int)oa_fnl_frt_rt_amt[i] != 0){
				if("C".equals(list.get(i).getOaTypBkgConvTpCd()) && !"+".equals(list.get(i).getOaTypRtOpCd()) && !"-".equals(list.get(i).getOaTypRtOpCd())){
					if("*".equals(list.get(i).getOaTypRtOpCd())){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * oa_typ_frt_rt_amt[i] ;
					}
					else if("/".equals(list.get(i).getOaTypRtOpCd())){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / oa_typ_frt_rt_amt[i] ;
					}
				}
				if("C".equals(list.get(i).getOaRacBkgConvTpCd()) && !"+".equals(list.get(i).getOaRacRtOpCd()) && !"-".equals(list.get(i).getOaRacRtOpCd())){
					if("*".equals(list.get(i).getOaRacRtOpCd())){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] * oa_rac_frt_rt_amt[i] ;
					}else if("/".equals(list.get(i).getOaRacRtOpCd())){
						oa_fnl_frt_rt_amt[i] = oa_fnl_frt_rt_amt[i] / oa_rac_frt_rt_amt[i] ;
					}
				}
			}
			//DARB 
			if((int)da_fnl_frt_rt_amt[i] != 0){
				if("C".equals(list.get(i).getDaTypBkgConvTpCd()) && !"+".equals(list.get(i).getDaTypRtOpCd()) && !"-".equals(list.get(i).getDaTypRtOpCd())){
					if("*".equals(list.get(i).getDaTypRtOpCd())){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] * da_typ_frt_rt_amt[i] ;
					}
					else if("/".equals(list.get(i).getDaTypRtOpCd())){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] / da_typ_frt_rt_amt[i] ;
					}
				}
				if("C".equals(list.get(i).getDaRacBkgConvTpCd()) && !"+".equals(list.get(i).getDaRacRtOpCd()) && !"-".equals(list.get(i).getDaRacRtOpCd())){
					if("*".equals(list.get(i).getDaRacRtOpCd())){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] * da_rac_frt_rt_amt[i] ;
					}else if("/".equals(list.get(i).getDaRacRtOpCd())){
						da_fnl_frt_rt_amt[i] = da_fnl_frt_rt_amt[i] / da_rac_frt_rt_amt[i] ;
					}
				}
			}
			/* DIH */
			if((int)di_fnl_frt_rt_amt[i] != 0){
				if("C".equals(list.get(i).getDaTypBkgConvTpCd()) && !"+".equals(list.get(i).getDaTypRtOpCd()) && !"-".equals(list.get(i).getDaTypRtOpCd())){
					if("*".equals(list.get(i).getDaTypRtOpCd())){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] * da_typ_frt_rt_amt[i];
					}
					else if("/".equals(list.get(i).getOaTypRtOpCd())){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] / da_typ_frt_rt_amt[i];
					}
				}
				if("C".equals(list.get(i).getDaRacBkgConvTpCd()) && !"+".equals(list.get(i).getDaRacRtOpCd()) && !"-".equals(list.get(i).getDaRacRtOpCd())){
					if("*".equals(list.get(i).getDaRacRtOpCd())){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] * da_rac_frt_rt_amt[i];
					}
					else if("/".equals(list.get(i).getDaRacRtOpCd())){
						di_fnl_frt_rt_amt[i] = di_fnl_frt_rt_amt[i] / da_rac_frt_rt_amt[i];
					}
				}
			}
			
			log.debug("rt_fnl_frt_rt_amt"+rt_fnl_frt_rt_amt[i]);
			log.debug("rt_calc_frt_rt_amt"+rt_calc_frt_rt_amt[i]);
			log.debug("rt_app_frt_rt_amt"+rt_app_frt_rt_amt[i]);
			log.debug("rt_typ_frt_rt_amt"+rt_typ_frt_rt_amt[i]);
			log.debug("rt_rac_frt_rt_amt"+rt_rac_frt_rt_amt[i]);
			//THR
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
				if(list.get(i).getRtRacRtOpCd().equals("+")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_rac_frt_rt_amt[i];
				}
				else if(list.get(i).getRtRacRtOpCd().equals("-")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_rac_frt_rt_amt[i];
				}
				else if(list.get(i).getRtRacRtOpCd().equals("*")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_rac_frt_rt_amt[i];
				}
				else if(list.get(i).getRtRacRtOpCd().equals("/")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_rac_frt_rt_amt[i];
				}
			}
			if(list.get(i).getRtAppBkgConvTpCd().equals("C")){
				if(list.get(i).getRtAppRtOpCd().equals("+")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] + rt_app_frt_rt_amt[i];
				}
				else if(list.get(i).getRtAppRtOpCd().equals("-")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] - rt_app_frt_rt_amt[i];
				}
				else if(list.get(i).getRtAppRtOpCd().equals("*")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] * rt_app_frt_rt_amt[i];
				}
				else if(list.get(i).getRtAppRtOpCd().equals("/")){
					rt_fnl_frt_rt_amt[i] = rt_fnl_frt_rt_amt[i] / rt_app_frt_rt_amt[i];
				}
			}

			oi_fnl_frt_rt_amt[i] = (double)Math.round(oi_fnl_frt_rt_amt[i] +0.005d);
			oa_fnl_frt_rt_amt[i] = (double)Math.round(oa_fnl_frt_rt_amt[i] +0.005d);
			rt_fnl_frt_rt_amt[i] = (double)Math.round(rt_fnl_frt_rt_amt[i] +0.005d);
			da_fnl_frt_rt_amt[i] = (double)Math.round(da_fnl_frt_rt_amt[i] +0.005d);
			di_fnl_frt_rt_amt[i] = (double)Math.round(di_fnl_frt_rt_amt[i] +0.005d);
			
			//OIH
			list.get(i).setOiCalcFrtRtAmt(String.valueOf(oi_fnl_frt_rt_amt[i]));
			//OARB
			list.get(i).setOaCalcFrtRtAmt(String.valueOf(oa_fnl_frt_rt_amt[i]));
			//THR
			list.get(i).setRtCalcFrtRtAmt(String.valueOf(rt_fnl_frt_rt_amt[i]));
			//DARB
			list.get(i).setDaCalcFrtRtAmt(String.valueOf(da_fnl_frt_rt_amt[i]));
			//DIH
			list.get(i).setDiCalcFrtRtAmt(String.valueOf(di_fnl_frt_rt_amt[i]));

			fnl_frt_rt_amt[i] = String.valueOf(oi_fnl_frt_rt_amt[i] + oa_fnl_frt_rt_amt[i]+ rt_fnl_frt_rt_amt[i]+da_fnl_frt_rt_amt[i]+di_fnl_frt_rt_amt[i]);
			log.debug("not conversion amount!"+ fnl_frt_rt_amt[i]);
			/* ToT Amount Set VO  */
			list.get(i).setFnlFrtRtAmt(fnl_frt_rt_amt[i]);
				
		}
		return list ;
		
	}
	
//	/**
//	 * runPointProcess	
//
//	 * @param type,amount
//	 * @exception 
//	 */
//	 private int runPointProcess(int type, Object amount){
//		 String tmpAmount 	= String.valueOf(amount).trim();
//		 log.debug("String tmpAmount="+tmpAmount);
//		 double  fAmount 	= Double.parseDouble(tmpAmount);
//		 log.debug("double  fAmount="+fAmount);
//		 int len  			= tmpAmount.length();	 
//		 log.debug("int len="+len);
//		 int point 			= tmpAmount.indexOf(".");
//		 log.debug("int point="+point);
//
//		 if(point>0){  
//			 int sPoint = point-1;
//			 int ePoint = point+2;
//			 tmpAmount = tmpAmount.substring(sPoint,ePoint);
//		 
//		 }else{ 
//			 tmpAmount = tmpAmount.substring(len-1);
//		 }
//		 
//		 double  dAmount = Double.parseDouble(tmpAmount);
//		 log.debug("runPointProcess dAmount="+dAmount);
//			
//
//		 switch (type) {
//		 
//		case 1:
//			if (0 < Double.compare(dAmount, 0.0d) && 0 >= Double.compare(dAmount, 5.0d)){
//				fAmount = (double) Math.floor(fAmount * 0.1d);
//				log.debug("~~~~"+fAmount);
//				fAmount = fAmount * 10d + 5d;
//				log.debug("~~~~!"+fAmount);
//			} else {
//				fAmount = (double) Math.floor(fAmount);
//				fAmount = Math.round(fAmount * 0.1d) * 10d;
//			}
//			break;
//			
//		case 2:
//			if (0 > Double.compare(dAmount,0.5d)){
//				fAmount = (double) Math.floor(fAmount);
//			} else {
//				fAmount = Math.round(fAmount);
//			}
//			break;
//			
//		case 3:
//			if (0 <= Double.compare(dAmount,0.0d) && 0 > Double.compare(dAmount, 2.5d)){
//				fAmount = (double) Math.floor(fAmount * 0.1d);
//				fAmount = fAmount * 10d ;
//			}else if (0 <= Double.compare(dAmount,2.5d) && 0 > Double.compare(dAmount, 7.5d)){
//				fAmount = (double) Math.floor(fAmount * 0.1d);
//				fAmount = fAmount * 10d + 5d;
//			}else if ( 0 <= Double.compare(dAmount,7.5d)){
//				fAmount = (double) Math.floor(fAmount);
//				fAmount = Math.round(fAmount * 0.1d) * 10d;
//			}
//			break;
//		case 4:
//						
//			break;
//		default:
//			break;
//		}
//		 
//		 return (int)fAmount;
//	 }
}