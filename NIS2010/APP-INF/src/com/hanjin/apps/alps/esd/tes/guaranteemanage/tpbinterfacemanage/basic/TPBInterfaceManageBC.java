/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBInterfaceManageBC.java
*@FileTitle : Guarantee TPB I/F
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.11.11 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.vo.SearchGuaranteeTPBIfDataVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesGnteHdrVO;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;

/**
 * ALPS-TPBInterfaceManage Business Logic Command Interface<br>
 * - ALPS-TPBInterfaceManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yOng hO lEE
 * @see GuarnateeManageSC 참조
 * @since J2EE 1.6
 */
public interface TPBInterfaceManageBC {

	/**
	 * [Guarantee TPB I/F]을 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchGuaranteeTPBIfDataVO>
	 * @exception EventException
	 */
	public List<SearchGuaranteeTPBIfDataVO> searchGuaranteeTPBIfData(GuaranteeCommonVO guaranteeCommonVO) throws EventException;
	
	/**
	 * [Guarantee TPB I/F]을 [Insert] 합니다.<br>
	 * 
	 * @param tesGnteHdrVO
	 * @param tesGnteCntrListVOs
	 * @param tesN3rdPtyIfVOs
	 * @return TesN3rdPtyIfVO[]
	 * @exception EventException
	 */
	public TesN3rdPtyIfVO[] searchRevVVDList(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, TesN3rdPtyIfVO[] tesN3rdPtyIfVOs) throws EventException;

	
	/**
	 * [Guarantee TPB I/F]을 [Insert] 합니다.<br>
	 * 
	 * @param tesGnteHdrVO
	 * @param tesGnteCntrListVOs
	 * @param tesN3rdPtyIfVOs
	 * @param account
	 * @return TesGnteCntrListVO[]
	 * @exception EventException
	 */
	public TesGnteCntrListVO[] addGuaranteeTPBIfData(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, TesN3rdPtyIfVO[] tesN3rdPtyIfVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [Guarantee TPB I/F]을 [Insert] 합니다.<br>
	 * 
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean sendGuaranteeTPBIfData(TesGnteCntrListVO[] tesGnteCntrListVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 * [Guarantee TPB I/F]을 [Update] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void updateGuaranteeTPBIfDataSts(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, SignOnUserAccount account) throws EventException;
	
}