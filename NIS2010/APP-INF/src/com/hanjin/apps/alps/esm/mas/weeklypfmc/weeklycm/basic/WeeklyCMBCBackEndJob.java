/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WeeklyCMBCBackEndJob.java
*@FileTitle : Target VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.02
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.06.02 최성민
* 1.0 Creation
* 
* 2012.07.18 이석준 [CHM-201219046-01] [MAS] Target VVD 배치 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.ProcedureParamVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration.WeeklyCMDBDAO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.BsaProcedureParamVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchVslRgstCountVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchYrWkDuVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * - ALPS-Target VVD 에 대한 BackEndJob<br>
 *
 * @author CHOI SUNGMIN
 * @see WeeklyCMBC
 * @since J2EE 1.6
 */
public class WeeklyCMBCBackEndJob  extends BackEndCommandSupport{

	private static final long serialVersionUID = -1025934322799161288L;

	private  WeeklyCMDBDAO dbDao = new WeeklyCMDBDAO();
	
	private SearchConditionVO searchConditionVO;
	private SignOnUserAccount account;
	private String commandId;
	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param SearchConditionVO searchConditionVO
	 * @param String commandId
	 * @param SignOnUserAccount account
	 * @return 
	 * @exception
	 */	
	public void setWeeklyCMVO(SearchConditionVO searchConditionVO, String commandId, SignOnUserAccount account) {
		this.searchConditionVO = searchConditionVO;
		this.account = account;
		this.commandId = commandId;
	}
	
	/**
	 * BackEndJob 실행 - 프로시져 호출 <br>
	 *  
	 * @return WeeklyCMCommonVO
	 * @exception Exception
	 */	
	@Override
	public WeeklyCMCommonVO doStart() throws Exception {
		WeeklyCMCommonVO vo = new WeeklyCMCommonVO();
		
		try {	
			if(commandId.equalsIgnoreCase("183")) {			//MULTI03 - BSA & VVD Creation 
				vo = dailyBatch();
			} else if(commandId.equalsIgnoreCase("184")) {	//MULTI04 - Create T/S Q`ty
				vo = createTSQty();
			} else if(commandId.equalsIgnoreCase("182")) {	//MULTI02 - VVD Creation
				vo = createTargetVVD();
			}              
			return vo;			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0029 : 수동배치 처리 #1<br>
	 *
	 * @return WeeklyCMCommonVO
	 * @exception Exception
	 */
	private WeeklyCMCommonVO dailyBatch() throws Exception {		
		
		try {	
			WeeklyCMCommonVO vo = new WeeklyCMCommonVO();
			
    		String inYr 		= searchConditionVO.getFYear();
    		String inFmMon 		= searchConditionVO.getFFmMon();
    		String inToMon 		= searchConditionVO.getFToMon();
    		String inFmWk 		= searchConditionVO.getFFmWk();
    		String inToWk 		= searchConditionVO.getFToWk();
    		String inMonOrWk	= searchConditionVO.getFChkprd();
    
    		String inTrdCd 		= searchConditionVO.getFSeltrade();
    		String inRlaneCd 	= searchConditionVO.getFSelrlane();
    		String inIocCd 		= "";
    		String inVslCd 		= "";
    		String inSkdVoyNo 	= "";
    		String inDirCd 		= searchConditionVO.getFDirCd();
    		String inUserId		= account.getUsr_id();
    		//String out_err_cd	= "";
    		//String out_err_msg	= "";
    		String duration = "0";

			//########### [batchBc.searchYrWkDu()] ########################### [START]
			ProcedureParamVO durationParamVO = new ProcedureParamVO();
        	durationParamVO.setInYr(inYr);
        	durationParamVO.setInFmWk(inFmWk);
        	durationParamVO.setInToWk(inToWk);
        	durationParamVO.setInFmMon(inFmMon);
        	durationParamVO.setInToMon(inToMon);
        	durationParamVO.setInMonOrWk(searchConditionVO.getFChkprd());
        	
        	SearchYrWkDuVO yrWkduList = dbDao.searchYrWkDu(durationParamVO);
			duration = yrWkduList.getCnt(); // duration : 수행 결과가 정상인지를 판별하기 위한 변수
			
			//########### [batchBc.searchYrWkDu()] ########################### [END]
			if (!duration.equals("0")) {                    
                ProcedureParamVO procedureParamVO = new ProcedureParamVO();
    			procedureParamVO.setInYr		(inYr);
    			procedureParamVO.setInFmMon		(inFmMon);
    			procedureParamVO.setInToMon		(inToMon);
    			procedureParamVO.setInFmWk		(inFmWk);
    			procedureParamVO.setInToWk		(inToWk);
    			procedureParamVO.setInMonOrWk	(inMonOrWk);
    			procedureParamVO.setInFmStep	("1");
    			procedureParamVO.setInAllFlg	("N");
    			procedureParamVO.setInInd		("BSA");
    			procedureParamVO.setInMssChkFlg	("N");
    			procedureParamVO.setInTrdCd		(inTrdCd);
    			procedureParamVO.setInRlaneCd	(inRlaneCd);
    			procedureParamVO.setInIocCd		(inIocCd);
    			procedureParamVO.setInVslCd		(inVslCd);
    			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
    			procedureParamVO.setInDirCd		(inDirCd);
    			procedureParamVO.setInStndCostCd(null);
    			procedureParamVO.setInUserId	(inUserId);
    			procedureParamVO.setInLogLvl	("9");
    			
    			ProcedureParamVO resultVO = new ProcedureParamVO();
    			resultVO = dbDao.createNtwkCostALL(procedureParamVO);
                
    			log.debug("==========================================================================");
                log.debug("dailyBatch-createTargetVVD Result Error Code: " + resultVO.getOutErrCd());
                log.debug("dailyBatch-createTargetVVD Result Error Message: " + resultVO.getOutErrMsg());
                log.debug("==========================================================================");

    			vo.setErrorCode(resultVO.getOutErrCd());
    			vo.setErrorMsg(resultVO.getOutErrMsg());
    			
    			if(!resultVO.getOutErrCd().equalsIgnoreCase("00000")) {
    				//BackEndJob Status Code 에 따른 메세지를 JS 에서 사용함
    				//아래부분의 에러메세지는 무의미 - 단지 THROW 만 실행
    				throw new DAOException(new ErrorHandler("","BackEndJob Request Fail!").getMessage());		
    				
    			}	
    			
    			
    			
    			if(resultVO.getOutErrCd().equalsIgnoreCase("00000")) {    			
					//########### [batchBc.dailyBatch()] ########################### [START]
					// 대상항차 생성 - 대상항차 보정 - 운항일수 생성
	            	
    				BsaProcedureParamVO bsaProcedureParam = new BsaProcedureParamVO();
    				bsaProcedureParam.setPYear		(inYr);
    				bsaProcedureParam.setPWeek		(inFmWk);
    				bsaProcedureParam.setPDuration	(duration);
    				bsaProcedureParam.setPStep		("4");
    				bsaProcedureParam.setPOnlyStep	("N");
    				bsaProcedureParam.setPBsa		("BSA");
    				bsaProcedureParam.setPTrdCd		(inTrdCd);
    				bsaProcedureParam.setPRlaneCd	(inRlaneCd);
    				bsaProcedureParam.setPIocCd		(inIocCd);
    				bsaProcedureParam.setPVslCd		(inVslCd); 
    				bsaProcedureParam.setPSkdVoyNo	(inSkdVoyNo);
    				bsaProcedureParam.setPDirCd		(inDirCd);
    				bsaProcedureParam.setPUserId	(inUserId);
    				
    				BsaProcedureParamVO bsaResult = new BsaProcedureParamVO();
    				bsaResult = dbDao.bsaDailyBatch(bsaProcedureParam);
    				
    				log.debug("==========================================================================");
 	                log.debug("dailyBatch-BSA Result Error Code: " + bsaResult.getPErrCd());
 	                log.debug("dailyBatch-BSA Result Error Message: " + bsaResult.getPErrMsg());
 	                log.debug("==========================================================================");

    				vo.setErrorCode(bsaResult.getPErrCd());
        			vo.setErrorMsg(bsaResult.getPErrMsg());
        			
    				if(!bsaResult.getPErrCd().equalsIgnoreCase("00000")) {
    					//BackEndJob Status Code 에 따른 메세지를 JS 에서 사용함
    					//아래부분의 에러메세지는 무의미 - 단지 THROW 만 실행
    					throw new DAOException(new ErrorHandler("","BackEndJob Request Fail!").getMessage());
    				}
	            }
			}
            
			return vo;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 Create 이벤트 처리(ESM_MAS_0029)<p>
	 * 2. 처리개요 : <p>
	 *    - 주간 대상항차관리에 대한 Create처리<br>
	 *
	 * @return WeeklyCMCommonVO
	 * @exception Exception
	 */		
	private WeeklyCMCommonVO createTSQty() throws Exception {
		
		try {	
			WeeklyCMCommonVO vo = new WeeklyCMCommonVO();

    		String inYr 		= searchConditionVO.getFYear();
    		String inFmMon 		= searchConditionVO.getFFmMon();
    		String inToMon 		= searchConditionVO.getFToMon();
    		String inFmWk 		= searchConditionVO.getFFmWk();
    		String inToWk 		= searchConditionVO.getFToWk();
    		String inMonOrWk	= searchConditionVO.getFChkprd();
    
    		String inTrdCd 		= searchConditionVO.getFSeltrade();
    		String inRlaneCd 	= searchConditionVO.getFSelrlane();
    		String inVslCd 		= searchConditionVO.getFVslCd();
    		String inSkdVoyNo 	= searchConditionVO.getFSkdVoyNo();
    		String inDirCd 		= searchConditionVO.getFDirCd();
    		String inUserId		= account.getUsr_id();
    		String inIocCd 		= searchConditionVO.getFSelioc();
    		String inMssChkFlg	= "Y";
    		//String out_err_cd	= "";
    		//String out_err_msg	= "";
            
            ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInFmStep	("2");
			procedureParamVO.setInAllFlg	("N");
			procedureParamVO.setInInd		("");
			procedureParamVO.setInMssChkFlg	(inMssChkFlg);
			procedureParamVO.setInTrdCd		(inTrdCd);
			procedureParamVO.setInRlaneCd	(inRlaneCd);
			procedureParamVO.setInIocCd		(inIocCd);
			procedureParamVO.setInVslCd		(inVslCd);
			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
			procedureParamVO.setInDirCd		(inDirCd);
			procedureParamVO.setInStndCostCd(null);
			procedureParamVO.setInUserId	(inUserId);
			procedureParamVO.setInLogLvl	("9");
			
			ProcedureParamVO resultVO = new ProcedureParamVO();
			resultVO = dbDao.createNtwkCostALL(procedureParamVO);

			log.debug("==========================================================================");
            log.debug("createTSQty Result Error Code: " + resultVO.getOutErrCd());
            log.debug("createTSQty Result Error Message: " + resultVO.getOutErrMsg());
            log.debug("==========================================================================");

			vo.setErrorCode(resultVO.getOutErrCd());
			vo.setErrorMsg(resultVO.getOutErrMsg());
			
			if(!resultVO.getOutErrCd().equalsIgnoreCase("00000")) {
				//BackEndJob Status Code 에 따른 메세지를 JS 에서 사용함
				//아래부분의 에러메세지는 무의미 - 단지 THROW 만 실행
				throw new DAOException(new ErrorHandler("","BackEndJob Request Fail!").getMessage());		
				
			}			 
            
			return vo;			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	  /**
     * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 Create 이벤트 처리(ESM_MAS_029)<p>
     * 2. 처리개요 : <p>
     *    - 주간 대상항차관리에 대한 Create처리
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.23<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     *
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
	private WeeklyCMCommonVO createTargetVVD() throws EventException{
		WeeklyCMCommonVO vo = new WeeklyCMCommonVO();

        try{
        	String type			= searchConditionVO.getFTypeCd();
    		String inYr 		= searchConditionVO.getFYear();
    		String inFmMon 		= searchConditionVO.getFFmMon();
    		String inToMon 		= searchConditionVO.getFToMon();
    		String inFmWk 		= searchConditionVO.getFFmWk();
    		String inToWk 		= searchConditionVO.getFToWk();
    		String inMonOrWk	= searchConditionVO.getFChkprd();
    
    		String inTrdCd 		= searchConditionVO.getFSeltrade();
    		String inRlaneCd 	= searchConditionVO.getFSelrlane();
    		String inIocCd 		= searchConditionVO.getFSelioc();
    		String inVslCd 		= searchConditionVO.getFVslCd();
    		String inSkdVoyNo 	= searchConditionVO.getFSkdVoyNo();
    		String inDirCd 		= searchConditionVO.getFDirCd();
    		String inUserId		= account.getUsr_id();
    		String inMssChkFlg	= "";
    		String inInd		= "";
    		String out_err_cd	= "";
    		String out_err_msg	= "";
    		//String result 		= "";
    		StringBuffer sb = new StringBuffer();
    		
    		if ( type.equals("MAS") ){
    			inMssChkFlg = "N";
    			inInd		= "MAS";
    		} else if (type.equals("BSA") ){
    			inMssChkFlg = "N";
    			inInd		= "BSA";    			
    		}
            
            ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInFmStep	("1");
			procedureParamVO.setInAllFlg	("N");
			procedureParamVO.setInInd		(inInd);
			procedureParamVO.setInMssChkFlg	(inMssChkFlg);
			procedureParamVO.setInTrdCd		(inTrdCd);
			procedureParamVO.setInRlaneCd	(inRlaneCd);
			procedureParamVO.setInIocCd		(inIocCd);
			procedureParamVO.setInVslCd		(inVslCd);
			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
			procedureParamVO.setInDirCd		(inDirCd);
			procedureParamVO.setInStndCostCd(null);
			procedureParamVO.setInUserId	(inUserId);
			procedureParamVO.setInLogLvl	("9");
			
			ProcedureParamVO resultVO = new ProcedureParamVO();

			resultVO = dbDao.createNtwkCostALL(procedureParamVO);
            
            if(resultVO != null){
    			
    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createTargetVVD Result Error Code: " + out_err_cd);
                log.debug("createTargetVVD Result Error Message: " + out_err_msg);
                log.debug("==========================================================================");

                if(out_err_cd.trim().equals("00000")){
                	out_err_cd = "00000";
                	out_err_msg = "Create Success!!";  	
                } else {
                	throw new DAOException(new ErrorHandler("MAS00025",out_err_cd).getMessage());
                }
            }

			// MAS_VSL_RGST중 stnd_ldb_capa가 0인것의 정보를 조회한다.
			// 20072023일 변경...위내용과 조금 달라졌음...
            List<SearchVslRgstCountVO> list = dbDao.searchVslRgstCount(searchConditionVO);
            
        	for(int i=0; list.size() > 0 && i < list.size(); i++) {
        		sb.append("[");
        		sb.append(((SearchVslRgstCountVO)list.get(i)).getVslCd());
        		sb.append("]");
        		//result = result + "[" + ((SearchVslRgstCountVO)list.get(i)).getVslCd() + "]";
        	}

        	vo.setErrorCode(out_err_cd);
        	vo.setErrorMsg(out_err_msg);
        	vo.setReturnVslCd(sb==null?"":sb.toString());

            return vo;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
}