/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AssetsAuditMgtBC.java
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

import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsAuditDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsAuditVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsSmryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAsetAudVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAverageUsingDayVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqMftPlanListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqMftPlanOptionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Equipmentmanagement Business Logic Command Interface<br>
 * - ALPS-Equipmentmanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ho Sun Lee
 * @see Ees_mst_0032EventResponse 참조
 * @since J2EE 1.6
 */

public interface AssetsAuditMgtBC {

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
    public List<EqAsetAudVO> searchAssetsAuditVersionListBasic(EqAsetAudVO  eqAsetAudVO) throws EventException;
    
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
    public AssetsAuditVO searchAssetsAuditResultListBasic(EqAsetAudVO  eqAsetAudVO) throws EventException;
    
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
    public void modifyAssetsAuditResultBasic(AssetsAuditDetailVO[] assetsAuditDetailVOs, SignOnUserAccount account) throws EventException;
    
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
	public List<AssetsSmryVO> searchAssetsSmryListBasic(AssetsOptionVO assetsOptionVO) throws EventException;	

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
	public List<AssetsDetailVO> searchAssetsDetailListBasic(AssetsOptionVO assetsOptionVO) throws EventException;
	
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
    public List<EqAverageUsingDayVO> searchEqAverageUsingDayBasic(EqAverageUsingDayVO eqAverageUsingDayVO) throws EventException;    
    
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
	public List<EqMftPlanListVO> searchEqManufacturePlanListBasic(EqMftPlanOptionVO eqMftPlanOptionVO) throws EventException;
	
	
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
	public List<EqMftPlanListVO> manageEqManufacturePlanListBasic(EqMftPlanListVO[] eqMftPlanListVOs, SignOnUserAccount account) throws EventException;
}