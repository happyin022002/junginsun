/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBInterfaceManageBC.java
*@FileTitle : Guarantee TPB I/F
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.vo.SearchGuaranteeTPBIfDataVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesGnteHdrVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;

/**
 * TPBInterfaceManage Business Logic Command Interface<br>
 *
 * @author yOng hO lEE
 * @see GuarnateeManageSC
 * @since J2EE 1.6
 */
public interface TPBInterfaceManageBC {

	/**
	 * [Guarantee TPB I/F] [Select] <br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchGuaranteeTPBIfDataVO>
	 * @exception EventException
	 */
	public List<SearchGuaranteeTPBIfDataVO> searchGuaranteeTPBIfData(GuaranteeCommonVO guaranteeCommonVO) throws EventException;
	
	/**
	 * [Guarantee TPB I/F] [Insert] <br>
	 * 
	 * @param tesGnteHdrVO
	 * @param tesGnteCntrListVOs
	 * @param tesN3rdPtyIfVOs
	 * @return TesN3rdPtyIfVO[]
	 * @exception EventException
	 */
	public TesN3rdPtyIfVO[] searchRevVVDList(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, TesN3rdPtyIfVO[] tesN3rdPtyIfVOs) throws EventException;

	
	/**
	 * [Guarantee TPB I/F] [Insert] <br>
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
	 * [Guarantee TPB I/F] [Insert] <br>
	 * 
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean sendGuaranteeTPBIfData(TesGnteCntrListVO[] tesGnteCntrListVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 * [Guarantee TPB I/F] [Update] <br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void updateGuaranteeTPBIfDataSts(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, SignOnUserAccount account) throws EventException;
	
}