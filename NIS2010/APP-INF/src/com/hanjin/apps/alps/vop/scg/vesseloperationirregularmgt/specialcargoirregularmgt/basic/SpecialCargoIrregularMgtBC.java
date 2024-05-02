/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoIrregularMgtBC.java
*@FileTitle : SPCL CGO Irregular Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.29 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.BKGOutputVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.CNTRInfoInputVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.CNTRInfoVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrrFileListVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoVO;
import com.hanjin.syscommon.common.table.MdmCarrierVO;

/**
 * ALPS-Vesseloperationirregularmgt Business Logic Command Interface<br>
 * - ALPS-Vesseloperationirregularmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HyunUk Kim
 * @see Vop_scg_0013EventResponse 참조
 * @since J2EE 1.6
 */

public interface SpecialCargoIrregularMgtBC {
	
	/**
	 * SPCL CGO Irregular 을 조회 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @return IrregularVO
	 * @exception EventException
	 */	
	public IrregularVO searchIrregular(IrregularVO irregularVO) throws EventException;
	
	/**
	 * SPCL CGO Irregular 의 Supporting Documents or Pictures 를 조회 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @return List<IrrFileListVO>
	 * @exception EventException
	 */	
	public List<IrrFileListVO> searchIrrFileList(IrregularVO irregularVO) throws EventException;
	
	/**
	 * SPCL CGO Irregular 을 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @param keys List<String>
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */	
	public void manageIrregular(IrregularVO irregularVO, List<String> keys, SignOnUserAccount account) throws EventException;
	
	/**
	 * SPCL CGO Irregular 을 삭제 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @exception EventException
	 */	
	public void removeIrregular(IrregularVO irregularVO) throws EventException;
	
	/**
	 * SPCL CGO Irregular 의 Booking 정보 를 조회 합니다. <br>
	 * 
	 * @param bkgBookingVO BkgBookingVO
	 * @return List<BKGOutputVO>
	 * @exception EventException
	 */	
	public List<BKGOutputVO> searchBKGInfo(BkgBookingVO bkgBookingVO) throws EventException;
	
	/**
	 * SPCL CGO Irregular 의 Container 를 조회 합니다. <br>
	 * 
	 * @param bkgBookingVO BkgBookingVO
	 * @return List<CNTRInfoVO>
	 * @exception EventException
	 */
	public List<CNTRInfoVO> searchCNTRList(BkgBookingVO bkgBookingVO) throws EventException;
	
	/**
	 * SPCL CGO Irregular 의 Container 정보 를 조회 합니다. <br>
	 * 
	 * @param cNTRInfoInputVO   CNTRInfoInputVO
	 * @return List<CNTRInfoVO>
	 * @exception EventException
	 */
	public List<CNTRInfoVO> searchCNTRInfo(CNTRInfoInputVO cNTRInfoInputVO) throws EventException;
	
	/**
	 * SPCL CGO Irregular List 를 조회 합니다. <br>
	 * 
	 * @param irregularsVO IrregularsVO
	 * @return List<IrregularsVO>
	 * @exception EventException
	 */	
	public List<IrregularsVO> searchIrrHistList(IrregularsVO irregularsVO) throws EventException;
	
	/**
	 * SPCL CGO Irregular List 의 Lane 을 조회 합니다. <br>
	 * 
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */	
	public List<MdmVslSvcLaneVO> searchIrrLaneList() throws EventException;
	
	/**
	 * SPCL CGO Irregular List 의 Vessel 을 조회 합니다. <br>
	 * 
	 * @return List<MdmVslCntrVO>
	 * @exception EventException
	 */	
	public List<MdmVslCntrVO> searchIrrVslList() throws EventException;
	
	/**
	 * SPCL CGO Irregular List 의 Vessel Operator 를 조회 합니다. <br>
	 * 
	 * @return List<MdmCarrierVO>
	 * @exception EventException
	 */	
	public List<MdmCarrierVO> searchIrrVslOprList() throws EventException;
	
	/**
	 * SPCL CGO Irregular List 의 Cargo Operator 를 조회 합니다. <br>
	 * 
	 * @return List<MdmCarrierVO>
	 * @exception EventException
	 */	
	public List<MdmCarrierVO> searchIrrCgoOprList() throws EventException;
	
	/**
	 * SPCL CGO Irregular List 의 Class 를 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgClssCdVO>
	 * @exception EventException
	 */	
	public List<ScgImdgClssCdVO> searchIrrClassList() throws EventException;
	
	/**
	 * SPCL CGO Irregular List 의 Class Comp 를 조회 합니다. <br>
	 * 
	 * @param scgImdgClssCdVO ScgImdgClssCdVO
	 * @return List<ScgImdgCompGrpVO>
	 * @exception EventException
	 */	
	public List<ScgImdgCompGrpVO> searchIrrClassCompList(ScgImdgClssCdVO scgImdgClssCdVO) throws EventException;
	
	/**
	 * SPCL CGO Irregular List 의 Un No. 를 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgUnNoVO>
	 * @exception EventException
	 */	
	public List<ScgImdgUnNoVO> searchIrrUnNoList() throws EventException;
	
	/**
	 * SPCL CGO Irregular List 의 Location 을 조회 합니다. <br>
	 * 
	 * @param mdmLocationVO MdmLocationVO
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */	
	public List<MdmLocationVO> searchIrrPortCdList(MdmLocationVO mdmLocationVO) throws EventException;
	
}