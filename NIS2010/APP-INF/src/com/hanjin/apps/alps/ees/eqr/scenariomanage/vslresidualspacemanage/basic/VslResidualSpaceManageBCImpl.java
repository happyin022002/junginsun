/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslResidualSpaceManageBCImpl.java
*@FileTitle : VslResidualSpaceManageBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.06 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.integration.VslResidualSpaceManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0014ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0060ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchBSInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchBSPortInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchVslRsdlSpaceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrBsaPortVO;
import com.hanjin.syscommon.common.table.EqrScnrBsaVvdVO;
import com.hanjin.syscommon.common.table.EqrScnrVslRsdlCapaVO;

/**
 * ALPS-ScenarioManage Business Logic Basic Command implementation<br>
 * - ALPS-ScenarioManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0060EventResponse,VslResidualSpaceManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class VslResidualSpaceManageBCImpl extends BasicCommandSupport implements VslResidualSpaceManageBC {

	// Database Access Object
	private transient VslResidualSpaceManageDBDAO dbDao = null;

	/**
	 * VslResidualSpaceManageBCImpl 객체 생성<br>
	 * VslResidualSpaceManageDBDAO를 생성한다.<br>
	 */
	public VslResidualSpaceManageBCImpl() {
		dbDao = new VslResidualSpaceManageDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * VslResidualSpaceManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condiVO  EesEqr0014ConditionVO
	 * @return List<SearchBSInfoVO>
	 * @exception EventException
	 */
	public List<SearchBSInfoVO> searchBSInfo(EesEqr0014ConditionVO condiVO) throws EventException {
		List<SearchBSInfoVO> list = null;
		
		try {
			list=dbDao.searchBSInfo(condiVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VslResidualSpaceManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condiVO  EesEqr0014ConditionVO
	 * @return List<SearchBSPortInfoVO>
	 * @exception EventException
	 */
	public List<SearchBSPortInfoVO> searchBSPortInfo(EesEqr0014ConditionVO condiVO) throws EventException {
		List<SearchBSPortInfoVO> list = null;
		
		try {
			 list = dbDao.searchBSPortInfo(condiVO);
			 return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * 추가 이벤트 처리<br>
	 * EES_EQR_014 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param vos EqrScnrBsaVvdVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
     */
	@SuppressWarnings("unchecked")
	public void modifyBSAInfo(EqrScnrBsaVvdVO[] vos , SignOnUserAccount account) throws EventException {
		boolean isUpdate = false;	        
	    boolean isDelete = false;
		try {
			List updModels 	= new ArrayList();
			List delvvdModels 	= new ArrayList();
			List delportModels 	= new ArrayList();
			String user_id		= account.getUsr_id();
			int rowCount = (vos ==null) ? 0 : vos.length ;
			for (int i =0 ; i < rowCount ; i++){
				EqrScnrBsaVvdVO  vo = vos[i];
				if("U".equals(vo.getIbflag())){
					isUpdate =true;
					HashMap<String, Object> param = new HashMap<String, Object>();
					param.putAll(vo.getColumnValues());
					param.put("vsl_spc", vo.getVslSpc());
					param.put("vsl_wgt", vo.getVslWgt());
					param.put("vsl_bsa_dry_sub_spc", vo.getVslBsaDrySubSpc());
					param.put("vsl_bsa_rf_sub_spc", vo.getVslBsaRfSubSpc());
					param.put("user_id", user_id);
					updModels.add(param);
				}else if("D".equals(vo.getIbflag())){
					isDelete = true;
					HashMap<String, Object> param = new HashMap<String, Object>();
					param.putAll(vo.getColumnValues());
					delvvdModels.add(param);
					delportModels.add(param);
				}
			}
			 
			
	        if( isUpdate ){
	        	dbDao.modifyBSAInfo(updModels);
	        }
	        if( isDelete ){
	        	dbDao.deleteBSAInfoVvd(delvvdModels);
	        	dbDao.deleteBSAInfoPort(delportModels);
	        }
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 추가 이벤트 처리<br>
	 * EES_EQR_014 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param vos EqrScnrBsaVvdVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
     */
	@SuppressWarnings("unchecked")
	public void modifyBSAPortInfo(EqrScnrBsaPortVO[] vos , SignOnUserAccount account) throws EventException {
		boolean isInsert = false ;      
	    boolean isDelete = false;   
	    int ki =1;
	       
		try {
			List insModels 	= new ArrayList();
			List delModels 	= new ArrayList();
			String user_id	= account.getUsr_id();
        	int rowCount = (vos ==null) ? 0 : vos.length ;
        	
        	if(rowCount > 0){        		
        		EqrScnrBsaPortVO checkVO = vos[0];
        		
        		if(checkVO.getChecked() != null && checkVO.getChecked().equals("N")){
        			isDelete = true;
        			HashMap<String, String> checkparam = new HashMap<String, String>();
        			checkparam.putAll(checkVO.getColumnValues());
        			delModels.add(checkparam);
        			for(int i = 0 ; i < rowCount ; i++){
        				EqrScnrBsaPortVO vo = vos[i];
        				if(!"D".equals(vo.getIbflag())){
        					isInsert = true;
	        				HashMap<String, Object> param = new HashMap<String, Object>();
	        				param.putAll(vo.getColumnValues());
	        				param.put("vsl_port_call_seq", Integer.toString(ki));
	        				param.put("user_id", user_id);
	        				param.put("vsl_port_spc", vo.getVslPortSpc());
	        				param.put("vsl_port_avg_wgt", vo.getVslPortAvgWgt());
	        				
	        				ki++;
	        				insModels.add(param);
        				}
        			}
        		}else{
        			isDelete = true;
        			
        			HashMap<String, String> checkparam = new HashMap<String, String>();
        			checkparam.putAll(checkVO.getColumnValues());
        			delModels.add(checkparam);
        			for(int i = 0 ; i < rowCount ; i++){
        				EqrScnrBsaPortVO vo = vos[i];
        				if(!"D".equals(vo.getIbflag())){
        					isInsert = true;
	        				HashMap<String, Object> param = new HashMap<String, Object>();
	        				param.putAll(vo.getColumnValues());
	        				param.put("vsl_port_call_seq", Integer.toString(ki));
	        				param.put("user_id", user_id);
	        				param.put("vsl_port_spc", vo.getVslPortSpc());
	        				param.put("vsl_port_avg_wgt", vo.getVslPortAvgWgt());
	        				
	        				ki++;
	        				insModels.add(param);
        				}
        			}
        			
        			/*// 수정된 데이터에 데해서만 수정한다. modify by ChungEunHo 09.11.17
        			 * 하위 소스는  hanjin senator 가 동시에 수정되도록 하는 소스임  param.put("co_cd", company_code); 만 추가하여 동일 프로세스를 타게함
        			
        			*/
        			
        		}        		
        	}
                     
            if( isDelete ) {
            	dbDao.deleteBSAPortInfo(delModels);
            }
            if( isInsert ){
            	dbDao.insertBSAPortInfo(insModels);
            }
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Search ]<br>
	 * 
	 * @param EesEqr0060ConditionVO eesEqr0060ConditionVO
	 * @return List<SearchVslRsdlSpaceVO>
	 * @exception EventException
	 */
	public List<SearchVslRsdlSpaceVO> searchVslResidualSpaceManage(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws EventException {
		try {
			return dbDao.searchVslResidualSpaceManage(eesEqr0060ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Lane 체크해서 VVD 가져오기]<br>
	 * 
	 * @param EesEqr0060ConditionVO eesEqr0060ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchVslResidualSpaceLaneInfo(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws EventException {
		try {
			return dbDao.searchVslResidualSpaceLaneInfo(eesEqr0060ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - 해당 VVD Click시 VVD SPC 값 체크해서 보여주기.]<br>
	 * 
	 * @param EesEqr0060ConditionVO eesEqr0060ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchVslResidualSpaceVvdInfo(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws EventException {
		try {
			return dbDao.searchVslResidualSpaceVvdInfo(eesEqr0060ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Ecc 체크.]<br>
	 * 
	 * @param EesEqr0060ConditionVO eesEqr0060ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchVslResidualSpaceEccInfo(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws EventException {
		try {
			return dbDao.searchVslResidualSpaceEccInfo(eesEqr0060ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Insert, Update, Delete ]<br>
	 * 
	 * @param EqrScnrVslRsdlCapaVO[] eqrScnrVslRsdlCapaVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyVslResidualSpaceManage(EqrScnrVslRsdlCapaVO[] eqrScnrVslRsdlCapaVO, SignOnUserAccount account) throws EventException{
		try {
			List<EqrScnrVslRsdlCapaVO> insertVoList = new ArrayList<EqrScnrVslRsdlCapaVO>();
			List<EqrScnrVslRsdlCapaVO> updateVoList = new ArrayList<EqrScnrVslRsdlCapaVO>();
			List<EqrScnrVslRsdlCapaVO> deleteVoList = new ArrayList<EqrScnrVslRsdlCapaVO>();

			for ( int i=0; i<eqrScnrVslRsdlCapaVO .length; i++ ) {
				
				if ( eqrScnrVslRsdlCapaVO[i].getIbflag().equals("I")){
					eqrScnrVslRsdlCapaVO[i].setCreUsrId(account.getUsr_id());
					eqrScnrVslRsdlCapaVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(eqrScnrVslRsdlCapaVO[i]);
				} else if ( eqrScnrVslRsdlCapaVO[i].getIbflag().equals("U")){
					eqrScnrVslRsdlCapaVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrScnrVslRsdlCapaVO[i]);
				} else if ( eqrScnrVslRsdlCapaVO[i].getIbflag().equals("D")){
					deleteVoList.add(eqrScnrVslRsdlCapaVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmodifyVslResidualSpaceManage(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymodifyVslResidualSpaceManage(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemodifyVslResidualSpaceManage(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}