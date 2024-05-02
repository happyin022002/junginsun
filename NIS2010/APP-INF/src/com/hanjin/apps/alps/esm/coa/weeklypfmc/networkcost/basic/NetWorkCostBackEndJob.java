/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetWorkCostBackEndJob.java
*@FileTitle : NetWorkCostBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2013.06.26 박찬민
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.basic;

import com.hanjin.apps.alps.esm.coa.common.vo.ProcedureParamVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration.WeeklyCMDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * - ALPS-NetWorkCost 에 대한 BackEndJob<br>
 *
 * @author PARK CHAN MIN
 * @see NetWorkCostBC
 * @since J2EE 1.6
 */
public class NetWorkCostBackEndJob  extends BackEndCommandSupport{

	private static final long serialVersionUID = -1025934322799161288L;

	private  WeeklyCMDBDAO dbDao = new WeeklyCMDBDAO();
	
	private ProcedureParamVO procedureParamVO;
	private String jobId;
	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param SearchConditionVO searchConditionVO
	 * @param String commandId
	 * @return 
	 * @exception
	 */	
	public void setNetWorkCostVO(ProcedureParamVO procedureParamVO, String jobId) {
		this.procedureParamVO = procedureParamVO;
		this.jobId = jobId;
	}
	
	/**
	 * BackEndJob 실행 - 프로시져 호출 <br>
	 *  
	 * @return NetworkCostCommonVO
	 * @exception Exception
	 */	
	@Override
	public NetworkCostCommonVO doStart() throws Exception {
		NetworkCostCommonVO vo = new NetworkCostCommonVO();
		
		try {	
			if(jobId.equalsIgnoreCase("createNWCreForVVD")) {	//MULTI02 - VVD Creation
				vo = createNWCreForVVD();
			}              
			return vo;			
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	
	/**
     * @return NetworkCostCommonVO
     * @exception EventException
     */
	private NetworkCostCommonVO createNWCreForVVD() throws EventException{
		NetworkCostCommonVO vo = new NetworkCostCommonVO();
        try{
        	
        	
    		String out_err_cd	= "";
    		String out_err_msg  = "";
			
			ProcedureParamVO resultVO = new ProcedureParamVO();

			resultVO = dbDao.createNtwkCostALL(procedureParamVO);
			
			if(resultVO != null){

    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createNWCreForVVD Result :: " + out_err_cd);
                log.debug("createNWCreForVVD Result :: " + out_err_msg);
                log.debug("==========================================================================");

                if(out_err_cd.trim().equals("00000")){
                	out_err_cd = "00000";
                	out_err_msg = "Create Success!!";
                }
            }

			vo.setErrorCode(out_err_cd);
        	vo.setErrorMsg(out_err_msg);
            
            return vo;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
}