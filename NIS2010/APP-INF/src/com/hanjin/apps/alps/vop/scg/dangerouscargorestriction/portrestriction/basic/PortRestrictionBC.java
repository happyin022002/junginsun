/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionBC.java
*@FileTitle : DG Restriction by Port (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.26 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestriction2VO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionDtlVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictonOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.VopScg004ContainVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Dangerouscargorestriction Business Logic Command Interface<br>
 * - ALPS-Dangerouscargorestriction에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jang kang cheol
 * @see Vop_scg_0005EventResponse 참조
 * @since J2EE 1.6
 */

public interface PortRestrictionBC {

 
    /**
     * Port Restriction 저장 처리 <br>
     * 
     * @param  VopScg004ContainVO vopScg004ContainVO
     * @param  SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */    
	public String managePortRestriction(VopScg004ContainVO vopScg004ContainVO,SignOnUserAccount signOnUserAccount) throws EventException;

    /**
     * 
     * Port Restriction 삭제 처리 <br>
     * 
     * @param PortRestrictonOptionVO portRestrictonOptionVO
     * @throws EventException
     */   	
	public void removePortRestriction(PortRestrictonOptionVO  portRestrictonOptionVO  ) throws EventException;
 
    /**
     * 
     * Port Restriction 조회<br>
     * 
     * @param PortRestrictonOptionVO portRestrictonOptionVO
     * @return List<PortRestrictionVO> 
     * @throws EventException
     */ 
	public List<PortRestrictionVO> searchPortRestriction (PortRestrictonOptionVO portRestrictonOptionVO)  throws EventException;
 
    /**
     * 
     * Port Restriction에 대한 저장된 정보를 조회한다.  <br>
     * 
     * @param PortRestrictonOptionVO portRestrictonOptionVO
     * @return List<PortRestrictionDtlVO> 
     * @throws EventException
     */ 
	public List<PortRestrictionDtlVO> searchPortRestrictionDetail(PortRestrictonOptionVO portRestrictonOptionVO)  throws EventException;
	
	/**
     * UnNo, Seq 로 Class Cd 구하기 <br>
     * 
     * @param  String unno
     * @param  String seq
     * @return String[]
     * @throws EventException
     */ 
	public String[] getImdgClssCd(  String unno, String seq)  throws EventException;
	/**
	 * SAVE DG Restrictions by Port 기존 Port Restriction의  Save As 처리<br>
     *  
     * @param  PortRestrictionVO portRestrictionVO
     * @param  PortRestrictionVO[] portRestrictionVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @return int
     * @throws EventException
     * @author jang kang cheol
     */ 
	public int managePortRestrictionSaveAs(PortRestrictionVO portRestrictionVO,PortRestrictionVO[] portRestrictionVOs ,SignOnUserAccount signOnUserAccount) throws EventException;	
	
	/**
	 * Port & VSL OPR’s Carrier Restriction En-route 메인 조회 <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<ScgImdgCrrRstrVO> 
     * @throws EventException
     */ 
	/*
	public List<ScgImdgCrrRstrVO> searchCarrierEnRouteList(PortRestrictionOptionVO portRestrictionOptionVO) throws EventException;	
	*/
	
	/**
	 * Port & VSL OPR’s Port Restriction En-route 메인 조회 <br>

     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<PortRestrictionOptionVO> 
     * @throws EventException
     */
	/*
	public List<PortRestrictionOptionVO> searchPortEnRouteList(PortRestrictionOptionVO portRestrictionOptionVO) throws EventException;	
	*/
	
    /**
     * 
     * DG Prohibition Summary by Port 을 조회 합니다.<br>
     * 
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return List<PortRestrictionVO> 
     * @throws EventException
     */ 
    public List<PortRestrictionVO> searchPortRestrictionSummary(PortRestrictonOptionVO portRestrictonOptionVO) throws EventException;

    /**
     * 
     * DG Restriction Summary by Port 을 조회 합니다.<br>
     * 
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return List<PortRestrictionVO> 
     * @throws EventException
     */ 
    public List<PortRestriction2VO> searchPortRestrictionSummary2(PortRestrictonOptionVO portRestrictonOptionVO) throws EventException;
}