/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UtilBC.java
*@FileTitle : ESD_SPE_COM
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.util.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.common.util.vo.UtillVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface UtilBC {


	/**
	 * RHQ Office 를 조회합니다.<br>
	 * 
	 * @param UtillVO UtillVO
	 * @return List<UtillVO>
	 * @exception EventException
	 */
	public List<UtillVO> searchRhqOfc(UtillVO utillVO) throws EventException;
	
	/**
	 * 지역별 Office 를 조회합니다.<br>
	 * 
	 * @param UtillVO UtillVO
	 * @return List<UtillVO>
	 * @exception EventException
	 */
	public List<UtillVO> searchOfc(UtillVO utillVO) throws EventException;

	/**
	 * 공통코드 값을 조회한다.<br>
	 * 
	 * @param UtillVO UtillVO
	 * @return List<UtillVO>
	 * @exception EventException
	 */
	public List<UtillVO> searchComCode(UtillVO utillVO) throws EventException;
	
	
	/**
	 * 공통코드 값을 조회한다 구분자를 텝 으로 코드와 명을 붙여온다.<br>
	 * 
	 * @param UtillVO UtillVO
	 * @return List<UtillVO>
	 * @exception EventException
	 */
	public List<UtillVO> searchComCode2(UtillVO utillVO) throws EventException;
	
	
	/**
	 * 공통코드 값을 조회한다. 코드와 명을 붙여서 조회한다.<br>
	 * 
	 * @param UtillVO UtillVO
	 * @return List<UtillVO>
	 * @exception EventException
	 */
	public List<UtillVO> searchComCode3(UtillVO utillVO) throws EventException;
	
	/**
	 * 사용자가 입력한 Control Office 코드가 존재하는 값인지 조회한다..<br>
	 * 
	 * @param UtillVO UtillVO
	 * @return List<UtillVO>
	 * @exception EventException
	 */
	public List<UtillVO> searchOfcChk(UtillVO utillVO) throws EventException;	
	
	/**
	 * 사용자가 입력한 Vender 코드로 조회한다.<br>
	 * 
	 * @param UtillVO UtillVO
	 * @return List<UtillVO>
	 * @exception EventException
	 */
	public List<UtillVO> searchVender(UtillVO utillVO) throws EventException;	
	
	/**
	 * 사용자가 입력한 USER 코드로 조회한다.<br>
	 * 
	 * @param UtillVO UtillVO
	 * @return List<UtillVO>
	 * @exception EventException
	 */
	public List<UtillVO> searchUser(UtillVO utillVO) throws EventException;	
	
	/**
	 * 사용자가 입력한 Terminal 코드로 조회한다.<br>
	 * 
	 * @param UtillVO UtillVO
	 * @return List<UtillVO>
	 * @exception EventException
	 */
	public List<UtillVO> searchTerminal(UtillVO utillVO) throws EventException;	
	

}