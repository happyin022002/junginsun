/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoReceiptBC.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectSpclCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgDgCgoInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DeclarantCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ImdgPckDescVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ScgImdgUnNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SearchDgCancelInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.StwgCgoApplVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo.ScgVvdDgCgoCxlRqstVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ScgVvdAproRqstVO;

/**
 * OPUS-Specialcargobookingconduct Business Logic Command Interface<br>
 * - OPUS-Specialcargobookingconduct<br>
 *
 * @author Lee Byung Kyu
 * @see Esm_bkg_0055EventResponse
 * @since J2EE 1.6 
 */

public interface SpecialCargoReceiptBC {

	/**
	 * handling event to search<br>
	 *  SpecialCargoReceipt<br>
	 * 
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @return AwkCgoApplVO 
	 * @exception EventException
	 */
	public AwkCgoApplVO searchAwkCargo(String bkgNo, String blNo, String caFlg) throws EventException;

	/**
	 * handling event to search<br>
	 *  SpecialCargoReceipt<br>
	 *  
	 * @param String bkgNo
	 * @param String caFlg
	 * @return AwkCgoApplVO
	 * @exception EventException
	 */
	public AwkCgoApplVO searchAwkDim(String bkgNo, String caFlg) throws EventException;
	
	/**
	 * handling event to search<br>
	 *  SpecialCargoReceipt<br>
	 *  
	 * @param String bkgNo
	 * @param String awkCgoSeq
	 * @param String caFlg
	 * @return AwkCgoApplVO
	 * @exception EventException
	 */
	public AwkCgoApplVO searchDimension(String bkgNo, String awkCgoSeq, String caFlg) throws EventException;

	/**
	 * handling event to save<br>
	 *  SpecialCargoReceipt<br>
	 *  
	 * @param AwkCgoApplVO awkCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageAwkCargo(AwkCgoApplVO awkCgoApplVO, String caFlg) throws EventException;
	
	/**
	 * handling event to search<br>
	 * Specialcargoreceipt (ESM_BKG_0200)<br>
	 *
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @return DgCgoApplVO
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgCargo(String bkgNo, String blNo, String caFlg) throws EventException;
	
	/**
	 * handling event to search<br>
	 * Specialcargoreceipt (ESM_BKG_1045)<br>
	 *
	 * @param String code
	 * @param String desc
	 * @param String pckTpCd
	 * @return DgCgoApplVO
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgPackage(String code, String desc, String pckTpCd) throws EventException;
		
	/**
	 * handling event to search<br>
	 * Specialcargoreceipt (ESM_BKG_0204)<br>
	 *
	 * @param ScgImdgUnNoVO scgImdgUnNoVO
	 * @return DgCgoApplVO
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgUnNumber(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException;
	
	/**
	 * handling event to search<br>
	 * Specialcargoreceipt (ESM_BKG_0754)<br>
	 *
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrTpszCd
	 * @param String caFlg
	 * @return DgCgoApplVO
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgSequence(String bkgNo, String cntrNo, String cntrTpszCd, String caFlg) throws EventException;
	
	/**
	 *handling event to save<br>
	 *  SpecialCargoReceipt<br>
	 *  
	 * @param DgCgoApplVO dgCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageDgCargo(DgCgoApplVO dgCgoApplVO, String caFlg) throws EventException;
		
	
	/**
	 * handling event to search<br>
	 * Specialcargoreceipt<br>
	 *
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @return RfCgoApplVO
	 * @exception EventException
	 */
	public RfCgoApplVO searchRfCargo(String bkgNo, String blNo, String caFlg) throws EventException;
	
	
	
	/**
	 * handling event to save<br>
	 *  SpecialCargoReceipt<br>
	 *  
	 * @param RfCgoApplVO rfCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRfCargo(RfCgoApplVO rfCgoApplVO, String caFlg) throws EventException;
	
	/**
	 * handling event to search<br>
	 * Specialcargoreceipt<br>
	 *
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @return BbCgoApplVO
	 * @exception EventException
	 */
	public BbCgoApplVO searchBbCargo(String bkgNo, String blNo, String caFlg) throws EventException;
	
	/**
	 * handling event to save<br>
	 *  SpecialCargoReceipt<br>
	 *  
	 * @param BbCgoApplVO bbCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageBbCargo(BbCgoApplVO bbCgoApplVO, String caFlg) throws EventException;
	
	
	
	/**
	 * handling to Request <br>
	 *  SpecialCargoReceipt<br>
	 *  
	 * @param SpclCgoAproApplVO spclCgoAproApplVO
	 * @return strResult
	 * @exception EventException
	 */
	public String manageSpclCgoApro(SpclCgoAproApplVO spclCgoAproApplVO) throws EventException;
	
	
	/**
	 * handling event to search<br>
	 *  SpecialCargoReceipt<br>
	 *  
	 * SpecialCargoReceipt imdgPckCd, imdgPckTpCd(ESM_BKG_0498)
	 * @param 	String imdgPckCd
	 * @param 	String imdgPckTpCd
	 * @return ImdgPckDescVO
	 * @exception EventException
	 */
	public ImdgPckDescVO searchImdgPckDesc(String imdgPckCd, String imdgPckTpCd) throws EventException;
	
	
	/**
	 * handling to Request <br>
	 *  SpecialCargoReceipt<br>
	 *  
	 * @param String bkgNo
	 * @param String aproCd
	 * @param String cgoSeq
	 * @param String spclCgoTp
	 * @param String rqstUsrId
	 * @exception EventException
	 */
	public void modifyAproStatus(String bkgNo, String aproCd, String cgoSeq, String spclCgoTp, String rqstUsrId) throws EventException;
	
	
	
	/**
	 * handling event to search<br>
	 * Specialcargoreceipt - handling event to search<br>
	 *
	 * @param String bkgNo
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */
	public ScgVvdAproRqstVO[] searchBkgVvd(String bkgNo) throws EventException;
	
	/**
	 * handling event to search<br>
	 *  Special cargo searching VVD information to request of Special cargo in T/S<br>
	 *
	 * @param String bkgNo
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */
	public ScgVvdAproRqstVO[] searchBkgVvdTs(String bkgNo) throws EventException;
	/**
	 * copying Special Cargo data<br>
	 * 
	 * @param String copyModeCd
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO[] targetBkg
	 * @param List<SelectSpclCgoVO> selectSpclCgoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copySpclCgoByBkg(String copyModeCd,BkgBlNoVO sourceBkg,BkgBlNoVO[] targetBkg,List<SelectSpclCgoVO> selectSpclCgoVO, SignOnUserAccount account) throws EventException;

    /**
     * function which is for copying  Special Cargo when container is copied or moved.
     * 
     * @param CntrCopyVO cntrCopyVO
     * @param String copyModeCd
     */
    public void copySpclCgoByCntr(CntrCopyVO cntrCopyVO, String copyModeCd) throws EventException;

    /**
     * @param String bkgNo
     * @param String cntrNo
     * @param String seq
     */
    public void removeSpclCgoByCntr(String bkgNo, String cntrNo, String seq) throws EventException;

	/**
	 * copying table which is related with special cargo for C/A
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param  		String copyTypeCd
	 * @exception 	EventException
	 */
	public void createSpclCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * deleting table which is related with special cargo for C/A
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;

	/**
	 * modifying RD Term of Special Cargo
	 * 
	 * @author 		
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @param  		String rcvTermCd
	 * @param  		String deTermCd
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifySpclRDTerm(BkgBlNoVO bkgBlNoVO, String rcvTermCd , String deTermCd , SignOnUserAccount account) throws EventException;

	/**
	 * modifying information of Danger Cargo in case of doing special request because of pre-checking
	 * 
	 * @author 		Ryu DaeYoung
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @param  		String spclRqstDesc
	 * @param		String dcgoSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyDgSpclRqstByVvdChange(BkgBlNoVO bkgBlNoVO, String spclRqstDesc, String dcgoSeq, SignOnUserAccount account) throws EventException;

	/**
	 * handling event to search<br>
	 *  searching VVD information to request of Special cargo in C/A <br>
	 *
	 * @param String bkgNo
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */	
	public ScgVvdAproRqstVO[] searchBkgVvdCa(String bkgNo) throws EventException;
	
	/**
	 * Segration No 콤보 셋팅을 위해 SCG_IMDG_SEGR_GRP 데이터를 조회한다.
	 * 
	 * @return      List<BkgComboVO>
	 * @exception 	EventException
	 */
	public List<BkgComboVO> searchSegrGrpList() throws EventException;

	/**
	 * 
	 * @param bkgNo
	 * @param caFlg
	 * @return
	 * @throws EventException
	 */
	public StwgCgoApplVO searchStwgCargo(String bkgNo, String caFlg) throws EventException;

	/**	 
	 * ESM_BKG_0090 saving logic
	 * @param StwgCgoApplVO stwgCgoApplVO
	 * @param String caFlg 
	 * @exception EventException
	 */
	public void manageStwgCargo(StwgCgoApplVO stwgCgoApplVO, String caFlg) throws EventException;

	/**	 
	 *  Check key information is updated or not to conduct auto request.
	 * @param DgCgoApplVO dgCgoApplVO
	 * @return      String 
	 * @exception EventException
	 */
	public String manageDGAutoRequest(DgCgoApplVO dgCgoApplVO) throws EventException;

	/**
	 * searching DG data<br>
	 *  SpecialCargoReceipt(ESM_BKG_0200)<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<DgCgoListVO> 
	 * @exception EventException
	 */
	public List<DgCgoListVO> searchDgList(String bkgNo, String caFlg) throws EventException;

	/**
	 * manageDgBkgCancel<br>
	 * call BKG cancel of spc module about DG<br>
	 * 
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @param List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs
	 * @param String cxlCgoRsn
	 * @return List<ScgVvdDgCgoCxlRqstVO> 
	 * @exception EventException
	 */
	public List<ScgVvdDgCgoCxlRqstVO> manageDgBkgCancel(String bkgNo, SignOnUserAccount account, List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs, String cxlCgoRsn) throws EventException;

	/**
	 * manageDgDgCancel<br>
	 * call DG cancel of spc module about DG<br>
	 * 
	 * @param List<SearchDgCancelInfoVO> dgCancelInfo
	 * @param SignOnUserAccount account
	 * @param List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs
	 * @param String cxlCgoRsn
	 * @return List<ScgVvdDgCgoCxlRqstVO> 
	 * @exception EventException
	 */
	public List<ScgVvdDgCgoCxlRqstVO> manageDgDgCancel(List<SearchDgCancelInfoVO> dgCancelInfo, SignOnUserAccount account, List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs, String cxlCgoRsn) throws EventException;

	/**
	 * Search the DG cancel information before data change<br>
	 * 
	 * @param String bkgNo
	 * @return List<SearchDgCancelInfoVO> 
	 * @exception EventException
	 */
	public List<SearchDgCancelInfoVO> searchDgCancelInfo(String bkgNo) throws EventException;

	/**
	 * Search the list of IMDG_AMDT_NO<br>
	 * 
	 * @return String 
	 * @exception EventException
	 */
	public String searchImdgAmdtNo() throws EventException;
	
	
	/**
	 * Search Declarant<br>
	 *
	 * @param BkgDgCgoInfoVO dgCgoInfoVO
	 * @return List<DeclarantCustomerInfoVO>
	 * @throws EventException
	 */
	public List<DeclarantCustomerInfoVO> searchDeclarantCustomer(BkgDgCgoInfoVO dgCgoInfoVO) throws EventException;
	
	/**
	 * DG Shipper, DG Consignee 정보를 저장한다.<br>
	 * 
	 * @param DeclarantCustomerInfoVO declarantCustomerInfoVO
	 * @param DgCntrVO[] dgCntrVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageDeclarantCustomer(DeclarantCustomerInfoVO declarantCustomerInfoVO, DgCntrVO[] dgCntrVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * DG Cargo 데이터 존재여부 체크
	 * @param String bkgNo
	 * @param String dcgoSeq
	 * @param String caFlg
	 * @return String
	 * @throws EventException
	 */
	public String searchDgCargoSeq(String bkgNo, String dcgoSeq, String caFlg) throws EventException;
	
	/**
	 * 
	 *  Update approve status of Reefer cargo<br>
	 * 
	 * @param String bkgNo
	 * @param String aproCd
	 * @param String cgoSeq
	 * @param String rqstusrId
	 * @exception EventException
	 */
	public void modifyRfAproStatus(String bkgNo, String aproCd, String cgoSeq, String rqstusrId) throws EventException;

	/**
	 * Search data to check special request or not<br>
	 *
	 * @param String bkgNo
	 * @return PreRestrictionInputVO
	 * @throws DAOException
	 */
	public PreRestrictionInputVO searchDgForSpecialRequestCheck(String bkgNo) throws EventException;

	/**
	 * Search representative DG approval code of target booking
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchDgAproCd(String bkgNo) throws EventException;

	/**
	 * Search DG information to request data to SCG.<br>
	 * @param String bkgNo
	 * @return SpclReqInVO[]
	 * @throws EventException
	 */
	public SpclReqInVO[] searchDgForRequest(String bkgNo) throws EventException;
	
	/**
	 *  Return list of DG container.<br>
	 * 
	 * @param String bkgNo
	 * @return List<DgCntrVO> 
	 * @exception EventException
	 */
	public List<DgCntrVO> searchDgCntrList(String bkgNo) throws EventException;

}
