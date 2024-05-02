/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerOnOffhireBCImpl.java
*@FileTitle : Output Alive EQ Master Data for Owned Equipment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.09.01 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration.AssetsAuditMgtDBDAO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsAuditDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsAuditVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsSmryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAsetAudVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAverageUsingDayVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqMftPlanListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqMftPlanOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAsetDpcAmtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EquipmentManagement Business Logic Basic Command implementation<br>
 * - ALPS-EquipmentManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ho Sun Lee
 * @see EES_MST_0032EventResponse,AssetsAuditMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AssetsAuditMgtBCImpl extends BasicCommandSupport implements AssetsAuditMgtBC 
{

	// Database Access Object
	private transient AssetsAuditMgtDBDAO dbDao = null;

	/**
	 * ContainerOnOffhireDBDAO를 생성한다.<br>
	 */
	public AssetsAuditMgtBCImpl() 
	{
		dbDao  = new AssetsAuditMgtDBDAO();
	}

    /**
     * EES_MST_0032 : Version Retrieve <br>
     * Output Alive EQ Master Data for Owned Equipment을 Month와 Eq Type에 따라 Version을 조회 합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0032
	 * @category searchAssetsAuditVersionListBasic   
     * @param  EqAsetAudVO  eqAsetAudVO
     * @return List<EqAsetAudVO>
     * @throws EventException
     */
    public List<EqAsetAudVO> searchAssetsAuditVersionListBasic(EqAsetAudVO  eqAsetAudVO) throws EventException{
		try {
			return dbDao.searchAssetsAuditVersionListData(eqAsetAudVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Output Alive EQ Master Data for Owned Equipment"}).getMessage(),ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Output Alive EQ Master Data for Owned Equipment"}).getMessage(),de);
		}  
	}
    
    /**
     * EES_MST_0032 : Retrieve <br> 
     * Output Alive EQ Master Data for Owned Equipment 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0032
	 * @category searchAssetsAuditResultListBasic   
     * @param  EqAsetAudVO  eqAsetAudVO
     * @return AssetsAuditVO
     * @throws EventException
     */
    public AssetsAuditVO searchAssetsAuditResultListBasic(EqAsetAudVO  eqAsetAudVO) throws EventException{
		try {
			AssetsAuditVO assetsAuditVO = new AssetsAuditVO(); 
			
			EqAsetAudVO leqAsetAudVO = dbDao.searchAssetsAuditData (eqAsetAudVO);
			assetsAuditVO.setEqAsetAudVO(leqAsetAudVO);
			
			if("A".equals(eqAsetAudVO.getRsltCd())){
				List<EqAsetDpcAmtVO> eqAsetDpcAmtVOs = dbDao.searchAssetsDepreciatedAmtListData(eqAsetAudVO);
				assetsAuditVO.setEqAsetDpcAmtVOs(eqAsetDpcAmtVOs);
			}else{
				List<AssetsAuditDetailVO> assetsAuditDetailVOs = dbDao.searchAssetsAuditResultListData(eqAsetAudVO);
				assetsAuditVO.setAssetsAuditDetailVOs(assetsAuditDetailVOs);
			}
			return assetsAuditVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Output Alive EQ Master Data for Owned Equipment"}).getMessage(),ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Output Alive EQ Master Data for Owned Equipment"}).getMessage(),de);
		}   	
    }
    
	/**
	 * ees_mst_0032 : save <br>
	 * Output Alive EQ Master Data for Owned Equipment을 Remark 저장합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0032
	 * @category modifyAssetsAuditResultBasic    
	 * @param AssetsAuditDetailVO[] assetsAuditDetailVOs
	 * @param SignOnUserAccount		account
	 * @exception EventException
	 */	    
    public void modifyAssetsAuditResultBasic(AssetsAuditDetailVO[] assetsAuditDetailVOs, SignOnUserAccount account) throws EventException {
		List<AssetsAuditDetailVO> tmpAssetsAuditDetailVOs = new ArrayList<AssetsAuditDetailVO>();
		List<AssetsAuditDetailVO> updateVoList = new ArrayList<AssetsAuditDetailVO>();
		
		try {
			if(assetsAuditDetailVOs != null)
			{
				for ( int i=0; i<assetsAuditDetailVOs.length; i++ ) 
				{
					AssetsAuditDetailVO lassetsAuditDetailVO = new AssetsAuditDetailVO();
					if (assetsAuditDetailVOs[i].getIbflag().equals("U")){
						assetsAuditDetailVOs[i].setUpdUsrId(account.getUsr_id());
						assetsAuditDetailVOs[i].setYrMon(assetsAuditDetailVOs[0].getYrMon());
						assetsAuditDetailVOs[i].setEqType(assetsAuditDetailVOs[0].getEqType());
						assetsAuditDetailVOs[i].setVerNo(assetsAuditDetailVOs[0].getVerNo());
						updateVoList.add(assetsAuditDetailVOs[i]);
						tmpAssetsAuditDetailVOs.add(i,lassetsAuditDetailVO);
					} else {
						tmpAssetsAuditDetailVOs.add(i,assetsAuditDetailVOs[i]);
					}
				}

				dbDao.modifyAssetsAuditData(updateVoList.get(0));  //Master				
				if (updateVoList.size() > 0){
					dbDao.modifyAssetsAuditResultData(updateVoList);   //Detail
				}
			}				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Status Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Status Update"}).getMessage(),de);
		}
    }
    
    /**
	 * 연도별 자산 집계현황을 조회한다.<br>
	 *  
	 * @author J.H.Min
	 * @category EES_MST_0041
	 * @category searchAssetsSmryListBasic  
	 *  
	 * @param AssetsOptionVO assetsOptionVO
	 * @return List<AssetsSmryVO>
	 * @exception EventException
	 */
	public List<AssetsSmryVO> searchAssetsSmryListBasic(AssetsOptionVO assetsOptionVO) throws EventException {
		String lstmCd = assetsOptionVO.getLstmCd();
		if(lstmCd.equals("AL")||lstmCd.equals("LT")||lstmCd.equals("ST")){
			if(lstmCd.equals("AL")){
				assetsOptionVO.setLstmCd("ALL");
			}
			try {
					return dbDao.searchAssetsSmryLeaseListData(assetsOptionVO);
				} catch (DAOException ex) {
					throw new EventException(new ErrorHandler("MST00013", new String[]{"Assets Smry List Search"}).getMessage(),ex);			
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("MST00013", new String[]{"Assets Smry List Search"}).getMessage(),ex);			
				}		
		}else{
			try {
				return dbDao.searchAssetsSmryOwnListData(assetsOptionVO);
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("MST00013", new String[]{"Assets Smry List Search"}).getMessage(),ex);			
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("MST00013", new String[]{"Assets Smry List Search"}).getMessage(),ex);			
			}
		}
	}

    /**
	 * 연도별 자산 현황을 장비별로 상세 조회한다.<br>
	 *  
	 * @author kjo
	 * @category EES_MST_0041
	 * @category searchAssetsDetailListBasic  
	 *  
	 * @param AssetsOptionVO assetsOptionVO
	 * @return List<AssetsDetailVO>
	 * @exception EventException
	 */
	public List<AssetsDetailVO> searchAssetsDetailListBasic(AssetsOptionVO assetsOptionVO) throws EventException {
		String lstmCd = assetsOptionVO.getLstmCd();
		if(lstmCd.equals("AL")||lstmCd.equals("LT")||lstmCd.equals("ST")){
			if(lstmCd.equals("AL")){
				assetsOptionVO.setLstmCd("ALL");
			}
			try {
				return dbDao.searchAssetsDetailLeaseListData(assetsOptionVO);
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("MST00013", new String[]{"Assets Detail List Search"}).getMessage(),ex);			
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("MST00013", new String[]{"Assets Detail List Search"}).getMessage(),ex);			
			}
		}else{
			try {
				return dbDao.searchAssetsDetailOwnListData(assetsOptionVO);
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("MST00013", new String[]{"Assets Detail List Search"}).getMessage(),ex);			
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("MST00013", new String[]{"Assets Detail List Search"}).getMessage(),ex);			
			}		
		}
	}
	
    /**
     * EES_MST_0045 : retreive <br>
     * Container Average using Day by TP/SZ을 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0032
	 * @category searchEqAverageUsingDayBasic  
     * @param  EqAverageUsingDayVO eqAverageUsingDayVO
     * @return List<EqAverageUsingDayVO>
     * @throws EventException
     */
    public List<EqAverageUsingDayVO> searchEqAverageUsingDayBasic(EqAverageUsingDayVO  eqAverageUsingDayVO) throws EventException{
		try {
			return dbDao.searchEqAverageUsingDayData(eqAverageUsingDayVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Average using Day by TP/SZ"}).getMessage(),ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Average using Day by TP/SZ"}).getMessage(),de);
		}
	}
    
    /**
	 * 연도별 신조장비 제작 Serial Range를 Kind of Eq별로 조회한다.<br>
	 * 
	 * @author NKJH
	 * @category EES_MST_0048,EES_MST_0049
	 * @category searchEqManufacturePlanListBasic  
	 * 
	 * @param EqMftPlanOptionVO eqMftPlanOptionVO
	 * @return List<EqMftPlanListVO>
	 * @exception EventException
	 */			
	public List<EqMftPlanListVO> searchEqManufacturePlanListBasic(EqMftPlanOptionVO eqMftPlanOptionVO) throws EventException{
		try {
			return dbDao.searchEqManufacturePlanListData(eqMftPlanOptionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Manufacture Plan List Search"}).getMessage(),ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Manufacture Plan Search"}).getMessage(),ex);			
		}	
	}
	
	
	/**
	 * 연도별 신조장비 제작 Serial Range를 Kind of Eq별로 저장,수정,삭제한다.<br>
	 * 
	 * @author NKJH
	 * @category EES_MST_0048
	 * @category manageEqManufacturePlanListBasic  
	 * 
	 * @param EqMftPlanListVO[] eqMftPlanListVOs
	 * @param SignOnUserAccount account
	 * @return List<EqMftPlanListVO>
	 * @exception EventException
	 */	 		
	public List<EqMftPlanListVO> manageEqManufacturePlanListBasic(EqMftPlanListVO[] eqMftPlanListVOs, SignOnUserAccount account) throws EventException{
		List<EqMftPlanListVO> list = new ArrayList<EqMftPlanListVO>();	;
		try {
			List<EqMftPlanListVO> insertVoList = new ArrayList<EqMftPlanListVO>();
			List<EqMftPlanListVO> updateVoList = new ArrayList<EqMftPlanListVO>();			
			List<EqMftPlanListVO> deleteVoList = new ArrayList<EqMftPlanListVO>();			
			List<EqMftPlanListVO> rtnVo = new ArrayList<EqMftPlanListVO>();	
			
			
			String sFlag = "";
			
			for ( int i=0; i<eqMftPlanListVOs.length; i++ ) {
				sFlag = eqMftPlanListVOs[i].getIbflag();
				if (sFlag.equals("I") || sFlag.equals("U")){
					rtnVo = dbDao.searchEqMftPlnInfoData(eqMftPlanListVOs[i]);
					String sRmk = "";
					if (rtnVo.size() > 0){
							for(int t=0; t<rtnVo.size(); t++){
								sRmk= sRmk+ rtnVo.get(t).getRmk()+"\n";
							}
							eqMftPlanListVOs[i].setRmk(sRmk);
						   list.add(eqMftPlanListVOs[i]);
						}
				}
				if ( sFlag.equals("I") && rtnVo.size() == 0){	
					eqMftPlanListVOs[i].setCreUsrId(account.getUsr_id());					
					eqMftPlanListVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(eqMftPlanListVOs[i]);	
				}else if ( sFlag.equals("U")&& rtnVo.size() == 0){
					eqMftPlanListVOs[i].setUpdUsrId(account.getUsr_id());
					
					updateVoList.add(eqMftPlanListVOs[i]);
				}else if ( eqMftPlanListVOs[i].getIbflag().equals("D")){
					deleteVoList.add(eqMftPlanListVOs[i]);						
				} 
			}		
			if ( insertVoList.size() > 0) {
				dbDao.addMstEqMftPlnListData(insertVoList);
			}	
			if ( updateVoList.size() > 0) {
				dbDao.modifyMstEqMftPlnListData(updateVoList);
			}			
			if ( deleteVoList.size() > 0) {
				dbDao.removeMstEqMftPlnListData(deleteVoList);
			}						
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Manufacture Plan Save"}).getMessage(),ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Manufacture Plan Save"}).getMessage(),ex);			
		}
		return list;
	}
}	