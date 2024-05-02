/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoReceiptBC.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
* 1.48 2011.05.03 이재위 [CHM-201108912] [Booking] AWK 화물의 weight Check 로직 생성 요청
* 2011.07.05 이일민 [CHM-201111757-01] [Special Cargo:Request로직] Group VVD assign, Next VVD Assign통한 자동 재승인요청
* 2011.10.21 변종건 [CHM-201113466-01] DG Cargo Application 기능 보완 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectSpclCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ImdgPckDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SegrGrpVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ScgVvdAproRqstVO;

/**
 * ALPS-Specialcargobookingconduct Business Logic Command Interface<br>
 * - ALPS-Specialcargobookingconduct에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Byung Kyu
 * @see Esm_bkg_0055EventResponse 참조
 * @since J2EE 1.6
 */

public interface SpecialCargoReceiptBC {

	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @return AwkCgoApplVO 
	 * @exception EventException
	 */
	public AwkCgoApplVO searchAwkCargo(String bkgNo, String blNo, String caFlg) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 조회 이벤트 처리<br>
	 *  
	 * @param String bkgNo
	 * @param String caFlg
	 * @return AwkCgoApplVO
	 * @exception EventException
	 */
	public AwkCgoApplVO searchAwkDim(String bkgNo, String caFlg) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 조회 이벤트 처리<br>
	 *  
	 * @param String bkgNo
	 * @param String awkCgoSeq
	 * @param String caFlg
	 * @return AwkCgoApplVO
	 * @exception EventException
	 */
	public AwkCgoApplVO searchDimension(String bkgNo, String awkCgoSeq, String caFlg) throws EventException;

	/**
	 * 저장 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 저장 이벤트 처리<br>
	 *  
	 * @param AwkCgoApplVO awkCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageAwkCargo(AwkCgoApplVO awkCgoApplVO, String caFlg) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Specialcargoreceipt (ESM_BKG_0200)화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @param boolean searchCntrFlag
	 * @return DgCgoApplVO
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgCargo(String bkgNo, String blNo, String caFlg, boolean searchCntrFlag) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Specialcargoreceipt (ESM_BKG_0200)화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @param boolean searchCntrFlag
	 * @return DgCgoApplVO
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgCargoFromOldBkg(String bkgNo, String blNo, String caFlg, boolean searchCntrFlag) throws EventException;

	
	/**
	 * 조회 이벤트 처리<br>
	 * Specialcargoreceipt (ESM_BKG_1045)화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param String code
	 * @param String desc
	 * @param String pckTpCd
	 * @return DgCgoApplVO
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgPackage(String code, String desc, String pckTpCd) throws EventException;
		
	/**
	 * 조회 이벤트 처리<br>
	 * Specialcargoreceipt (ESM_BKG_0204)화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param String bkgNo
	 * @param String unNo
	 * @param String imdgClass
	 * @param String prpShpNm
	 * @return DgCgoApplVO
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgUnNumber(String bkgNo, String unNo, String imdgClass, String prpShpNm) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Specialcargoreceipt (ESM_BKG_0754)화면에 대한 조회 이벤트 처리<br>
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
	 * 저장 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 저장 이벤트 처리<br>
	 *  
	 * @param DgCgoApplVO dgCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageDgCargo(DgCgoApplVO dgCgoApplVO, String caFlg) throws EventException;
		
	
	/**
	 * 조회 이벤트 처리<br>
	 * Specialcargoreceipt화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @return RfCgoApplVO
	 * @exception EventException
	 */
	public RfCgoApplVO searchRfCargo(String bkgNo, String blNo, String caFlg) throws EventException;
	
	
	
	/**
	 * 저장 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 저장 이벤트 처리<br>
	 *  
	 * @param RfCgoApplVO rfCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRfCargo(RfCgoApplVO rfCgoApplVO, String caFlg) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Specialcargoreceipt화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @return BbCgoApplVO
	 * @exception EventException
	 */
	public BbCgoApplVO searchBbCargo(String bkgNo, String blNo, String caFlg) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 저장 이벤트 처리<br>
	 *  
	 * @param BbCgoApplVO bbCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageBbCargo(BbCgoApplVO bbCgoApplVO, String caFlg) throws EventException;
	
	
	
	/**
	 * Request 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 Request 이벤트 처리<br>
	 *  
	 * @param SpclCgoAproApplVO spclCgoAproApplVO
	 * @return strResult
	 * @exception EventException
	 */
	public String manageSpclCgoApro(SpclCgoAproApplVO spclCgoAproApplVO) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 조회 이벤트 처리<br>
	 *  
	 * SpecialCargoReceipt imdgPckCd, imdgPckTpCd로 정보 조회.(ESM_BKG_0498)
	 * @param 	String imdgPckCd
	 * @param 	String imdgPckTpCd
	 * @return ImdgPckDescVO
	 * @exception EventException
	 */
	public ImdgPckDescVO searchImdgPckDesc(String imdgPckCd, String imdgPckTpCd) throws EventException;
	
	
	/**
	 * Request 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 Request 이벤트 처리<br>
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
	 * 조회 이벤트 처리<br>
	 * Specialcargoreceipt 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param String bkgNo
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */
	public ScgVvdAproRqstVO[] searchBkgVvd(String bkgNo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * T/S 화면에서 vvd 재지정시 Special cargo 재 request를 위한 vvd 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @param List<String> paramVvds
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */
	public ScgVvdAproRqstVO[] searchBkgVvdTs(String bkgNo, List<String> paramVvds) throws EventException;
	/**
	 * Special Cargo data를 복사한다.<br>
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
     * 컨테이너 Copy/Move 시 Special Cargo 복사를 위한 함수.
     * 
     * @param cntrCopyVO
     * @author 김영출
     */
    public void copySpclCgoByCntr(CntrCopyVO cntrCopyVO) throws EventException;

    /**
     * @param String bkgNo
     * @param String cntrNo
     * @param String seq
     */
    public void removeSpclCgoByCntr(String bkgNo, String cntrNo, String seq) throws EventException;

	/**
	 * C/A를 위해 special cargo 관련 table을 복사한다.
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param  		String copyTypeCd
	 * @exception 	EventException
	 */
	public void createSpclCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * C/A를 위해 special cargo 관련 table을 삭제한다.
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;

	/**
	 * Special Cargo의 RD Term을 수정한다.
	 * 
	 * @author 		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @param  		String rcvTermCd
	 * @param  		String deTermCd
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifySpclRDTerm(BkgBlNoVO bkgBlNoVO, String rcvTermCd , String deTermCd , SignOnUserAccount account) throws EventException;

	/**
	 * VVD 변경시 prechecking 때문에 special request를 하게될 경우 Danger Cargo 정보를 수정한다.
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
	 * 조회 이벤트 처리<br>
	 * C/A 화면에서 vvd 재지정시 Special cargo 재 request를 위한 vvd 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */	
	public ScgVvdAproRqstVO[] searchBkgVvdCa(String bkgNo) throws EventException;

	/**
	 * SAVE 전에 GRS_MAX_WGT를 체크한다.(ESM_BKG_0055) <br>
	 * 
	 * @param  		String bkgNo
	 * @param		String cntrNo
	 * @param		String grsWgt
	 * @param		String cntrTpszCd
	 * @param		String wgtUtCd
 	 * @return  	EventResponse
	 * @exception 	EventException
	 */
	public EventResponse searchGrsMaxWgt(String bkgNo, String cntrNo, String grsWgt, String cntrTpszCd, String wgtUtCd) throws EventException;
	
	/**
	 * 유사한 화학적 특성을 갖는 위험물 격리군(Segregation Groups) (ESM_BKG_0200 ComboList) 조회.<br>
	 * 
	 * @return List<SegrGrpVO>
	 * @throws EventException
	 */
	public List<SegrGrpVO> searchSegrGrp() throws EventException;
	
	/**
	 * IMDG UN NUMBER의 SPECIAL PROVISION No (ESM_BKG_0200) 조회.<br>
	 * 
	 * @param unNo
	 * @param unNoSeq
	 * @return String
	 * @throws EventException
	 */
	public String searchSpclProviNo(String unNo, String unNoSeq) throws EventException;

	/**
	 * DG CARGO의 UN No에 해당하는 Stowage Code를 조회한다 <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchImdgUnNoStwgCateCd(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 *  Booking에 해당하는 CLL VVD를 조회한다<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchCLLVVD(String bkgNo) throws EventException;
	
	/**
	 * Special Cargo에 대한 Validation Check
	 * @param cgoType
	 * @param bkgNo
	 * @return
	 * @throws EventException
	 */
	public String validateSpCgo(String cgoType, String bkgNo) throws EventException;
}
