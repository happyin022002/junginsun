/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OptimizeddistancemgtBC.java
*@FileTitle : Yard Group (Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.12
*@LastModifier : 정운
*@LastVersion : 1.0
* 2014.02.12 정운
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.OptimizedDistanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.YardGroupVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Optimizeddistancemgt Business Logic Command Interface<br>
 * - NIS2010-Optimizeddistancemgt 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Un Jeong
 * @see Ui_vsk-9515EventResponse 참조
 * @since J2EE 1.4
 */

public interface OptimizeddistancemgtBC { 

	/**
	 * 해당 Port에 관련된 Yard Group을 조회합니다.
	 * 
	 * @param  YardGroupVO yardGroupVO
	 * @return List<YardGroupVO>
	 * @exception EventException
	 */
	public List<YardGroupVO> searchYardGroupList(YardGroupVO yardGroupVO) throws EventException;

	/**
	 * 해당 Port에 관련된 Yard Group을 저장합니다.
	 * 
	 * @param YardGroupVO[] yardGroupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageYardGroupList	(YardGroupVO[] yardGroupVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 해당 Port에 따른 Yard Group Combo List를 조회합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchYardGroupCombo(OptimizedDistanceVO optimizedDistanceVO) throws EventException;
	
	/**
	 * 해당 Port에 따른 Optimized Distance 정보를 조회 합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchOptimizedDistance(OptimizedDistanceVO optimizedDistanceVO) throws EventException;
	
	/**
	 * Optimized Distance 정보를 저장합니다.
	 * 
	 * @param  OptimizedDistanceVO[] optimizedDistanceVOs
	 * @param  List<String> keys
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOptimizedDistance	(OptimizedDistanceVO[] optimizedDistanceVOs, List<String> keys, SignOnUserAccount account) throws EventException;
	
	/**
	 * 해당 Port에 따른 Yard Group Combo List를 조회합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchSlipForOptimizedDistance(OptimizedDistanceVO optimizedDistanceVO) throws EventException;
	
	/**
	 * To Port입력 시에 해당 Distance 정보를 조회합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchToPortDistance(OptimizedDistanceVO optimizedDistanceVO) throws EventException;
	
	/**
	 * VMS Short 클릭 시 Target 정보를  조회 합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchTargetVmsShort(OptimizedDistanceVO optimizedDistanceVO) throws EventException;
	
	/**
	 * VMS Short 클릭 시 popup에서 plt_stn_desc정보를 조회합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchVmsShortPltStnDesc(OptimizedDistanceVO optimizedDistanceVO) throws EventException;
	
	
	
	
}