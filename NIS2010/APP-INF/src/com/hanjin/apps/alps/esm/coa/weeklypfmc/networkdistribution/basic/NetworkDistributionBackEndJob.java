/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkDistributionBackEndJob.java
*@FileTitle : Allocation Results
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2014.03.21 최성민
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration.NetworkDistributionDBDAO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * - ALPS-Target VVD 에 대한 BackEndJob<br>
 *
 * @author CHOI SUNGMIN
 * @see NetworkDistributionBC
 * @since J2EE 1.6
 */
public class NetworkDistributionBackEndJob  extends BackEndCommandSupport{

	private static final long serialVersionUID = -1025934322799161288L;

	private  NetworkDistributionDBDAO dbDao = new NetworkDistributionDBDAO();
	
	private SearchConditionVO searchVo;
	private NetworkDistributionCommonVO vo;
	private SignOnUserAccount account;
	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param SearchConditionVO searchConditionVO
	 * @param String commandId
	 * @param SignOnUserAccount account
	 * @return 
	 * @exception
	 */	
	public void setNetworkVO(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) {
		this.searchVo = searchVo;
		this.vo = vo;
		this.account = account;
	}
	
	/**
	 * BackEndJob 실행 - 프로시져 호출 <br>
	 *  
	 * @return WeeklyCMCommonVO
	 * @exception Exception
	 */	
	@Override
	public WeeklyCMCommonVO doStart() throws Exception {
		WeeklyCMCommonVO reVo = new WeeklyCMCommonVO();
		
		try {	
			if(searchVo.getFInout().equalsIgnoreCase("ESM_COA_0106")) {			//Allocation Results - Apply to P/L 
				reVo = applyToPL();
			} else if(searchVo.getFInout().equalsIgnoreCase("ESM_COA_0108")) {	//Allocation Results(Commitment Base) - Apply to P/L 
				reVo = applyToPL();
			}
			
			return reVo;			
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * ESM_COA_106,ESM_COA_108: APPLY 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return NetworkCostCommonVO
	 * @exception DAOException
	 */
    private WeeklyCMCommonVO applyToPL() throws EventException{
        try{          
        	
        	List<HashMap<String, String>> createList  = new ArrayList<HashMap<String, String>>();
        	List<HashMap<String, String>> createList2 = new ArrayList<HashMap<String, String>>();
        	List<HashMap<String, String>> createList3 = new ArrayList<HashMap<String, String>>();
        	List<HashMap<String, String>> updateList  = new ArrayList<HashMap<String, String>>();

            //----------------------------------------------------
            HashMap<String, String> param = new HashMap<String, String>();
            if (!searchVo.getFSeltrade().equals("")){
                param.put("trd_cd", searchVo.getFSeltrade());
            }
            if (!searchVo.getFSelrlane().equals("")){
                param.put("rlane_cd", searchVo.getFSelrlane());
            }
            if (!searchVo.getFSelioc().equals("")){
                param.put("ioc_cd", searchVo.getFSelioc());
            }
            if (!searchVo.getFVslCd().equals("")){
                param.put("vsl_cd", searchVo.getFVslCd());
            }
            if (!searchVo.getFSkdVoyNo().equals("")){
                param.put("skd_voy_no", searchVo.getFSkdVoyNo());
            }
            if (!searchVo.getFDirCd().equals("")){
                param.put("dir_cd", searchVo.getFDirCd());
            }
            if (searchVo.getFChkprd().equals("M")){
                if(!searchVo.getFFmMon().equals("")){
                    param.put("cost_yrmon_s", searchVo.getFYear() + searchVo.getFFmMon());
                    param.put("cost_yrmon_e", searchVo.getFYear() + searchVo.getFToMon());
                }else{
                    param.put("cost_yrmon", searchVo.getFYear());
                }

            } else if (searchVo.getFChkprd().equals("W")) {
                param.put("sls_yrmon", searchVo.getFYear() + "%");
                if(!searchVo.getFFmWk().equals("")){
                    param.put("cost_wk_s", searchVo.getFFmWk());
                    param.put("cost_wk_e", searchVo.getFToWk());
                }
            }
            
            if (!searchVo.getFOpView().equals("")){
                param.put("f_op_view", searchVo.getFOpView());
            }
            
            param.put("upd_usr_id", account.getUsr_id());
            param.put("cre_usr_id", account.getUsr_id());
            
            createList.add(param);  
            createList2.add(param);
            createList3.add(param);
            updateList.add(param);

            vo.setMultiCreateList (createList );
            vo.setMultiCreateList2(createList2);
            vo.setMultiCreateList3(createList3);
            vo.setMultiUpdateList (updateList );
            
            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("trd_cd"      , searchVo.getFSeltrade());
            vParam.put("rlane_cd"    , searchVo.getFSelrlane());
            vParam.put("ioc_cd"      , searchVo.getFSelioc()  );
            vParam.put("vsl_cd"      , searchVo.getFVslCd()   );
            vParam.put("skd_voy_no"  , searchVo.getFSkdVoyNo());
            vParam.put("dir_cd"      , searchVo.getFDirCd()   );
            vParam.put("priod"       , searchVo.getFChkprd()  );
            vParam.put("fmMonth"     , searchVo.getFFmMon()   );
            vParam.put("fmWeek"      , searchVo.getFFmWk()    );
            vParam.put("f_op_view"   , searchVo.getFOpView()  );
            vParam.put("f_inout"   	 , searchVo.getFInout()   );
            vo.setIndirectVariableValues(vParam);            

            //[DB 실행]
            if (searchVo.getFOpView().equals("OP4") || searchVo.getFOpView().equals("OP6") ){
				dbDao.applyToPLOP4(vo);
			} else{
				 dbDao.applyToPL(vo);
			}
            
            //############################################################################
            
//            vo.setErrorCode("00000");
//            vo.setErrorMsg("OK!");            
            WeeklyCMCommonVO returnVo = new WeeklyCMCommonVO();
            returnVo.setErrorCode("00000");
            
            return returnVo; // "SUCCESS"
        } catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }	

}