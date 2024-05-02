/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionBC.java
*@FileTitle : VSL OPR's Restriction on DG (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.09 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.basic;

import java.util.List;

import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionOptionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.PortRestrictionOptionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.ScgImdgCrrRstrVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Dangerouscargorestriction Business Logic Command Interface<br>
 * - OPUS-Dangerouscargorestriction에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jang kang cheol
 * @see Vop_scg_0009EventResponse 참조
 * @since J2EE 1.6
 */

public interface CarrierRestrictionBC {
 
 
	/**
	 * 
     * Carrier Restirction 메인 조회 <br>
     * 
	 * @param  CarrierRestrictionOptionVO carrierRestrictionOptionVO
	 * @return List<CarrierRestrictionVO>
     * @throws EventException
	 */
	public  List<CarrierRestrictionVO>  searchCarrierRestriction(CarrierRestrictionOptionVO carrierRestrictionOptionVO ) throws EventException;
 
 
    /**
     * 
     * VOP_SCG_0009 Carrier Restiction SAVE 처리 <br>
     * 
     * @param  CarrierRestrictionOptionVO carrierRestrictionOptionVO
     * @param  signOnUserAccount SignOnUserAccount 
     * @throws EventException
     */
	public void manageCarrierRestriction(  CarrierRestrictionOptionVO carrierRestrictionOptionVO,SignOnUserAccount signOnUserAccount) throws EventException;
 
	/**
	 * Port & VSL OPR’s Carrier Restriction En-route 메인 조회 <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<ScgImdgCrrRstrVO> 
     * @throws EventException
     */ 
	public List<ScgImdgCrrRstrVO> searchCarrierEnRouteList(PortRestrictionOptionVO portRestrictionOptionVO) throws EventException;	
	
	/**
	 * Port & VSL OPR’s Port Restriction En-route 메인 조회 <br>

     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<PortRestrictionOptionVO> 
     * @throws EventException
     */ 
	public List<PortRestrictionOptionVO> searchPortEnRouteList(PortRestrictionOptionVO portRestrictionOptionVO) throws EventException;	
	
	/**
	 * Port & VSL OPR’s Port Restriction En-route 메인 조회 <br>

     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<PortRestrictionOptionVO> 
     * @throws EventException
     */ 
	public List<PortRestrictionOptionVO> searchPortRotnSeq(PortRestrictionOptionVO portRestrictionOptionVO) throws EventException;	
	
 

}