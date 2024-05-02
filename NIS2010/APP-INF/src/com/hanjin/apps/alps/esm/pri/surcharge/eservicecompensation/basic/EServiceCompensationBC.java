/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EServiceCompensationBC.java
*@FileTitle : E-Service Compensation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.07.29 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.PriCmpnEsvcVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.MdmSvcScpLmtVO;

/**
 * ALPS-Eservicecompensation Business Logic Command Interface<br>
 * - ALPS-Eservicecompensation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author day-hoh Kim
 * @see Ems_pri_4009EventResponse 참조
 * @since J2EE 1.6
 */

public interface EServiceCompensationBC {

	/**
	 * E-SVC Compensation Creation, Inquiry의 리스트 조회<br>
	 * 
	 * @param PriCmpnEsvcVO priCmpnEsvcVO
	 * @return List<PriCmpnEsvcVO>
	 * @exception EventException
	 */
	public List<PriCmpnEsvcVO> searchEServiceCompensationList(PriCmpnEsvcVO priCmpnEsvcVO) throws EventException;
	
	/**
	 * E-SVC Compensation Creation의 event에 대한 origin, dest 콤보 조회<br>
	 * 
	 * @param MdmSvcScpLmtVO mdmSvcScpLmtVO
	 * @return List<MdmSvcScpLmtVO>
	 * @exception EventException
	 */
	public List<MdmSvcScpLmtVO> searchEServiceCompensationOrigiComboList(MdmSvcScpLmtVO mdmSvcScpLmtVO) throws EventException;
	
	/**
	 * E-SVC Compensation Creation의 event에 대한 SC No. 존재여부 조회<br>
	 *
	 * @param PriSpHdrVO priSpHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String searchEServiceCompensationSCNo(PriSpHdrVO priSpHdrVO) throws EventException;
	
	/**
	 * E-SVC Compensation Creation의 event에 대한 RFA NO. 존재여부 조회<br>
	 *
	 * @param PriRpHdrVO priRpHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String searchEServiceCompensationRFANo(PriRpHdrVO priRpHdrVO) throws EventException;

	/**
	 * E-SVC Compensation Creation의 event에 대한 저장 처리<br>
	 * 
	 * @param PriCmpnEsvcVO[] priCmpnEsvcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEServiceCompensation(PriCmpnEsvcVO[] priCmpnEsvcVOs, SignOnUserAccount account) throws EventException;
	
}