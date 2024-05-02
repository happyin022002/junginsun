/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ModelManageBackEndJob.java
*@FileTitle : SMP Season Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.06
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.05.06 진마리아
* 1.0 Creation
* 
* History
* 2013.05.06 [CHM-201324211-01] 프로젝트 안정화 및 HELP DESK - SMP Season Creation 배치->backend로 변경
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.03.17 [CHM-20142960] SMP/Allocation control보완 요청 - 재생성 로직 추가
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.basic.BSAYearlyPlanBC;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration.ModelManageDBDAO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustCtrlGrpVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SearchModelManageListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcMdlVerMstVO;

/**
 * - ALPS-Target VVD 에 대한 BackEndJob<br>
 *
 * @author CHOI SUNGMIN
 * @see BSAYearlyPlanBC
 * @since J2EE 1.6
 */
public class ModelManageBackEndJob  extends BackEndCommandSupport{

	private static final long serialVersionUID = 7869461307221308362L;
	
	private ModelManageDBDAO dbDao = new ModelManageDBDAO();
	private ModelManageBC command = new ModelManageBCImpl();
	private String jobType = "Creation";
	private SpcMdlVerMstVO spcMdlVerMstVO;
	private CustCtrlGrpVO[] custCtrlGrpVOs;
	private SearchModelManageListVO[] searchModelManageListVOs;
	private SignOnUserAccount account;
	
	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param SpcMdlVerMstVO SpcMdlVerMstVO
	 * @return 
	 * @exception
	 */	
	public void setSpcMdlVerMstVO(SpcMdlVerMstVO spcMdlVerMstVO) {
		this.spcMdlVerMstVO = spcMdlVerMstVO;
	}
	
	public void setCustCtrlGrpVOs(CustCtrlGrpVO[] custCtrlGrpVOs) {
		if (custCtrlGrpVOs != null) {
			CustCtrlGrpVO[] tmpVOs = new CustCtrlGrpVO[custCtrlGrpVOs.length];
			System.arraycopy(custCtrlGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.custCtrlGrpVOs = tmpVOs;
		}
	}
	public void setSignOnUserAccount(SignOnUserAccount account){
		this.account = account;
	}
	public void setSearchModelManageListVOs(SearchModelManageListVO[] searchModelManageListVOs) {
		if (searchModelManageListVOs != null) {
			SearchModelManageListVO[] tmpVOs = new SearchModelManageListVO[searchModelManageListVOs.length];
			System.arraycopy(searchModelManageListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchModelManageListVOs = tmpVOs;
		}
	}
	
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	/**
	 * BackEndJob 실행 - 프로시져 호출 <br>
	 *  
	 * @return ParamProcedureVO
	 * @exception Exception
	 */	
	@Override
	public Object doStart() throws Exception {
		// TODO Auto-generated method stub
		try{
			
			// Creation 시 수행.
			if ( jobType.equals("Creation") ) {
				
				String nowSeason = dbDao.searchNowSeason(); //(java에서 주차를 구하면 시스템시간으로 구해짐)
				spcMdlVerMstVO.setCostYrwk(nowSeason);
				spcMdlVerMstVO.setVerSeq("1");
				String existFlg = dbDao.searchSeasonExist(spcMdlVerMstVO);
				
				if("Y".equals(existFlg)){
					dbDao.deleteSmpByTable(spcMdlVerMstVO, "SPC_MDL_CUST_REV_LANE");
					dbDao.deleteSmpByTable(spcMdlVerMstVO, "SPC_MDL_CUST_CTRL_GRP");
					dbDao.deleteSmpByTable(spcMdlVerMstVO, "SPC_MDL_CUST_CTRL");
					dbDao.deleteSmpByTable(spcMdlVerMstVO, "SPC_MDL_VER_MST");
				}
				
				dbDao.addNewSeason(spcMdlVerMstVO);
				
				//해당 season에서 사용할 control group을 저장합니다.
				List<CustCtrlGrpVO> insertVOList = new ArrayList<CustCtrlGrpVO>();
				for(CustCtrlGrpVO vo : custCtrlGrpVOs){
					vo.setTrdCd(spcMdlVerMstVO.getTrdCd());
					vo.setCostYrwk(nowSeason);
					vo.setCreUsrId(spcMdlVerMstVO.getCreUsrId());
					insertVOList.add(vo);
				}
				if(insertVOList.size()>0){
					dbDao.addCustCtrlGrp(insertVOList);
				}
				
				// Creation, Regeneration 공통으로 수행
				// 생성하는 season의 pfmc 기간에 이미 생성된 pfmc가 있으면, 삭제 후 재생성합니다.
				dbDao.deleteCustPerf(spcMdlVerMstVO);
				int addCnt = dbDao.addCustPerf(spcMdlVerMstVO);
				
				if(addCnt == 0){
					throw new DAOException("Performance is not exist.");
				}				
			} else if( jobType.equals("Regeneration") ) {
				// Regeneration 시 수행.
				dbDao.updateSeasonPerfWeek(spcMdlVerMstVO);
				
				// Creation, Regeneration 공통으로 수행
				// 생성하는 season의 pfmc 기간에 이미 생성된 pfmc가 있으면, 삭제 후 재생성합니다.
				dbDao.deleteCustPerf(spcMdlVerMstVO);
				int addCnt = dbDao.addCustPerf(spcMdlVerMstVO);
				
				if(addCnt == 0){
					throw new DAOException("Performance is not exist.");
				}				
			} else if (jobType.equals("Save") ) {
				command.manageSpaceManagementPlan(searchModelManageListVOs, account);
			} else if (jobType.equals("Copy") ) {	
			    SpcMdlVerMstVO newSpcMdlVerMstVO = new SpcMdlVerMstVO();
                String nowSeason = dbDao.searchNowSeason(); //(java에서 주차를 구하면 시스템시간으로 구해짐)
                newSpcMdlVerMstVO.setCostYrwk(nowSeason);
                newSpcMdlVerMstVO.setVerSeq("1");
                newSpcMdlVerMstVO.setTrdCd(spcMdlVerMstVO.getTrdCd());
                newSpcMdlVerMstVO.setCreUsrId(spcMdlVerMstVO.getCreUsrId());
                newSpcMdlVerMstVO.setUpdUsrId(spcMdlVerMstVO.getCreUsrId());
                String existFlg = dbDao.searchSeasonExist(newSpcMdlVerMstVO);
                if("Y".equals(existFlg)){
                    dbDao.deleteSmpByTable(newSpcMdlVerMstVO, "SPC_MDL_CUST_REV_LANE");
                    dbDao.deleteSmpByTable(newSpcMdlVerMstVO, "SPC_MDL_CUST_CTRL_GRP");
                    dbDao.deleteSmpByTable(newSpcMdlVerMstVO, "SPC_MDL_CUST_CTRL");
                    dbDao.deleteSmpByTable(newSpcMdlVerMstVO, "SPC_MDL_VER_MST");
                }
                
                //SPC_MDL_CUST_PERF season에 1개 version없음 - regeneration 로직수행

                newSpcMdlVerMstVO.setPerfStYrwk(spcMdlVerMstVO.getPerfStYrwk());
                newSpcMdlVerMstVO.setPerfEndYrwk(spcMdlVerMstVO.getPerfEndYrwk());
                // Regeneration 시 수행.
                dbDao.updateSeasonPerfWeek(newSpcMdlVerMstVO);
                // Creation, Regeneration 공통으로 수행
                // 생성하는 season의 pfmc 기간에 이미 생성된 pfmc가 있으면, 삭제 후 재생성합니다.
                dbDao.deleteCustPerf(newSpcMdlVerMstVO);
                int addCnt = dbDao.addCustPerf(newSpcMdlVerMstVO);
                
                
                
                //SPC_MDL_VER_MST
                dbDao.addNewSeason(newSpcMdlVerMstVO);
 
                
                String trade = spcMdlVerMstVO.getTrdCd();
                String season = spcMdlVerMstVO.getCostYrwk() ;
                String verSeq = spcMdlVerMstVO.getVerSeq();
                String newVerSeq = "1";

                //SPC_MDL_CUST_CTRL_GRP season에 1개 version없음
                dbDao.copyCustCtrlGrp(trade, season, nowSeason, spcMdlVerMstVO.getCreUsrId()) ;


                //SPC_MDL_CUST_CTRL
                //2.최신버전의 account 정보를 그대로 insert
                dbDao.copyModelshipAcct(trade, season, verSeq,nowSeason, newVerSeq, spcMdlVerMstVO.getCreUsrId());
 
                
                
                
                //SPC_MDL_CUST_REV_LANE
 
                //4.기version의 REV_LANE 데이터를 전부 copy
                dbDao.copyModelRevLane(trade, season, verSeq,nowSeason, newVerSeq, spcMdlVerMstVO.getCreUsrId());
                
                
			}
			

			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
}
