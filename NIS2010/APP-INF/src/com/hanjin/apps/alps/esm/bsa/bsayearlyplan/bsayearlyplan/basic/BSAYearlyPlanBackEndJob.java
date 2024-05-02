/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanBackEndJob.java
*@FileTitle : BSA Creation/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.26
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.01.26 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration.BSAYearlyPlanDBDAO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.ParamCoaMonVvdYryPlnVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.ParamProcedureVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.RsltCoaMonVvdYryPlnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * - ALPS-Target VVD 에 대한 BackEndJob<br>
 *
 * @author CHOI SUNGMIN
 * @see BSAYearlyPlanBC
 * @since J2EE 1.6
 */
public class BSAYearlyPlanBackEndJob  extends BackEndCommandSupport{

	private static final long serialVersionUID = 7869461307221308362L;
	
	private  BSAYearlyPlanDBDAO dbDao = new BSAYearlyPlanDBDAO();
	
	private ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO;
	
	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO
	 * @return 
	 * @exception
	 */	
	public void setCoaMonVvdYryPlnVO(ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO) {
		this.paramCoaMonVvdYryPlnVO = paramCoaMonVvdYryPlnVO;
	}
	
	/**
	 * BackEndJob 실행 - 프로시져 호출 <br>
	 *  
	 * @return ParamProcedureVO
	 * @exception Exception
	 */	
	@Override
	public ParamProcedureVO doStart() throws Exception {
		// TODO Auto-generated method stub
		ParamProcedureVO vo = new ParamProcedureVO();
		try {			
			String inYear 		= paramCoaMonVvdYryPlnVO.getFYear();
			String inFmWk 		= paramCoaMonVvdYryPlnVO.getFFmWk();
			String inToWk 		= paramCoaMonVvdYryPlnVO.getFToWk();
	
			String inTrdCd 		= paramCoaMonVvdYryPlnVO.getFSeltrade();
			String inRlaneCd 	= paramCoaMonVvdYryPlnVO.getFSelrlane();
			String inIocCd 		= paramCoaMonVvdYryPlnVO.getFSelioc();
			String inVslCd 		= paramCoaMonVvdYryPlnVO.getFVslCd();
			String inSkdVoyNo 	= paramCoaMonVvdYryPlnVO.getFSkdVoyNo();
			String inDirCd 		= paramCoaMonVvdYryPlnVO.getFDirCd();
			String inUserId		= paramCoaMonVvdYryPlnVO.getCreUsrId();
			String inDuration 	= String.valueOf((Integer.parseInt(inToWk) - Integer.parseInt(inFmWk)) + 1);
			
			//COA_CREATE_YRY_TARGET_VVD_PRC /////////////////////////////////////////
			ParamProcedureVO createProcVO = new ParamProcedureVO();
			createProcVO.setInYear(inYear);
			createProcVO.setInFmWk(inFmWk);
			createProcVO.setInDuration(inDuration);
			createProcVO.setInTrdCd(inTrdCd);
			createProcVO.setInRlaneCd(inRlaneCd);
			createProcVO.setInIocCd(inIocCd);
			createProcVO.setInVslCd(inVslCd);
			createProcVO.setInSkdVoyNo(inSkdVoyNo);
			createProcVO.setInDirCd(inDirCd);
			createProcVO.setInUserId(inUserId);
			
			ParamProcedureVO createRsltVO = new ParamProcedureVO();
			createRsltVO = dbDao.createYearlyPlanTargetVVD(createProcVO);
			
			if(!createRsltVO.getPErrorCode().equalsIgnoreCase("00000")) {
				//BackEndJob Status Code 에 따른 메세지를 JS 에서 사용함
				//아래부분의 에러메세지는 무의미 - 단지 THROW 만 실행
				throw new DAOException(new ErrorHandler("","BackEndJob Request Fail!").getMessage());		
				
			}			   
			vo.setPErrorCode(createRsltVO.getPErrorCode());
			vo.setPErrorMsg(createRsltVO.getPErrorMsg());
			///////////////////////////////////////////////////////////////////////////
			
    		//COA_CREATE_YRY_TARGET_VVD_PRC ///////////////////////////////////////////
    		ParamProcedureVO updateProcVO = new ParamProcedureVO();
    		updateProcVO.setPYear(inYear);
    		updateProcVO.setPFmWk(inFmWk);
    		updateProcVO.setPToWk(inToWk);
    		updateProcVO.setPTrdCd(inTrdCd);
    		updateProcVO.setPRlaneCd(inRlaneCd);
    		updateProcVO.setPIocCd(inIocCd);
    		updateProcVO.setPVslCd(inVslCd);
    		updateProcVO.setPSkdVoyNo(inSkdVoyNo);
    		updateProcVO.setPDirCd(inDirCd);
    		updateProcVO.setPUsrId(inUserId);
    		
        	ParamProcedureVO updateRsltVO = new ParamProcedureVO();
        	updateRsltVO = dbDao.createYearlyPlanTargetVVDUpdate(updateProcVO);
        	
			if(!updateRsltVO.getPErrCd().equalsIgnoreCase("00000")) {
				//BackEndJob Status Code 에 따른 메세지를 JS 에서 사용함
				//아래부분의 에러메세지는 무의미 - 단지 THROW 만 실행
				throw new DAOException(new ErrorHandler("","BackEndJob Request Fail!").getMessage());
			}

			vo.setPErrCd(updateRsltVO.getPErrCd());
			vo.setPErrMsg(updateRsltVO.getPErrMsg());
            ///////////////////////////////////////////////////////////////////////////
			
			// COA_VSL_RGST중 stnd_ldb_capa가 0인것의 정보를 조회한다. //////////////////////
            List<RsltCoaMonVvdYryPlnVO> list = dbDao.searchVslRgstCount(paramCoaMonVvdYryPlnVO);
                        
           
            String vslCd = "";
        	for(int i=0; list.size() > 0 && i < list.size(); i++) {
        		vslCd = vslCd + "[" + list.get(i).getVslCd() + "]";
        	}
            vo.setPVslCd(vslCd)	;                        
            ///////////////////////////////////////////////////////////////////////////
            
			return vo;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}
