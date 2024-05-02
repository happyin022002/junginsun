/*=========================================================
*Copyright(c) 20006 CyberLogitec
*@FileName : COPUpdateBC.java
*@FileTitle : COP Update
*Open Issues :
*Change history :
*@LastModifyDate : 20006-10-02
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 20006-10-02 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copupdate.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.copmanage.copupdate.vo.COPUpdateInfoVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * SCE Business Logic Command Interface<br>
 * - SCE에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seong-mun Kang
 * @see EsdSce0010EventResponse 참조
 * @since J2EE 1.4
 */
public interface COPUpdateBC  {

	/**
     * COP Detail Search 화면에 대한 MODIFY 이벤트 처리<br>
     * 
     * @param COPUpdateInfoVO inqVO
     * @return List<COPUpdateInfoVO>
     * @exception EventException
     */
	public List<COPUpdateInfoVO> modifyCOPDetailEstmActDT(COPUpdateInfoVO inqVO)  throws EventException ;


	
	
}