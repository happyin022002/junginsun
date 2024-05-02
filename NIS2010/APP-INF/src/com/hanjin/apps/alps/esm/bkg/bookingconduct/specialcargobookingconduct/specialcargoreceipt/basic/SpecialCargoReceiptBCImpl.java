/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoReceiptBCImpl.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2011.01.11 이일민 [] 1월 6일자 R4J 관련 수정
* 2011.03.28 변종건 [CHM-201109427-01] [BKG] BKG Main 화면에서 Special(Reefer) cargo 변경 시 PSA로 변경 내용 I/F 요청
* 2011.05.03 이재위 [CHM-201108912] [Booking] AWK 화물의 weight Check 로직 생성 요청
* 2011.07.05 이일민 [CHM-201111757-01] [Special Cargo:Request로직] Group VVD assign, Next VVD Assign통한 자동 재승인요청
* 2011.10.21 변종건 [CHM-201113466-01] DG Cargo Application 기능 보완 요청
* 2012.05.22 김종호 [CHM-201217443][BKG]Special Cargo Reject건 자동이메일전송기능
* 2012.06.18 조정민 [CHM-201217472] [BKG] BKG/DOC Validation Rule 정리 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectSpclCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration.SpecialCargoReceiptDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration.SpecialCargoReceiptEAIDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkDimVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ImdgPckDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SegrGrpVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpecialCargoRjEmlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
//import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmPckTpVO;
import com.hanjin.syscommon.common.table.ScgVvdAproRqstVO;

/**
 * ALPS-SpecialCargoBookingConduct Business Logic Basic Command implementation<br>
 * - ALPS-SpecialCargoBookingConduct에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Byung Kyu
 * @see ESM_BKG_0055EventResponse,SpecialCargoReceiptBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SpecialCargoReceiptBCImpl extends BasicCommandSupport implements SpecialCargoReceiptBC {

	// Database Access Object
	private transient SpecialCargoReceiptDBDAO dbDao = null;
	private transient SpecialCargoReceiptEAIDAO eaiDao = null;

	/**
	 * SpecialCargoReceiptBCImpl 객체 생성<br>
	 * SpecialCargoReceiptDBDAO를 생성한다.<br>
	 */
	public SpecialCargoReceiptBCImpl() {
		dbDao = new SpecialCargoReceiptDBDAO();
		eaiDao = new SpecialCargoReceiptEAIDAO();
	}
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
	public AwkCgoApplVO searchAwkCargo(String bkgNo, String blNo, String caFlg) throws EventException {

		AwkCgoApplVO awkCgoApplVO = new AwkCgoApplVO();		
		String spclTp = "AWK";
		
        try {
                awkCgoApplVO.setBkgAwkCgo(dbDao.searchAwkCgoList(bkgNo, caFlg));                
                awkCgoApplVO.setAwkBkgInfo(dbDao.searchAwkBkgInfo(bkgNo, caFlg));
                awkCgoApplVO.setAwkAproInfo(dbDao.searchAwkApproval(bkgNo, caFlg));
                awkCgoApplVO.setCntrTypzQty(dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg));                
                awkCgoApplVO.setCntrCombo(dbDao.searchCntrList(bkgNo, spclTp, caFlg));
                awkCgoApplVO.setBkgAwkDim(dbDao.searchAwkDimDtl(bkgNo, caFlg));				
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        return awkCgoApplVO;
    }
	
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return AwkCgoApplVO 
	 * @exception EventException
	 */
	public AwkCgoApplVO searchAwkDim(String bkgNo, String caFlg) throws EventException {

		AwkCgoApplVO awkCgoApplVO = new AwkCgoApplVO();
		
        try {       	
        	awkCgoApplVO.setBkgAwkDim(dbDao.searchAwkDimDtl(bkgNo, caFlg));                
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
        return awkCgoApplVO;
    }
	
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
	public AwkCgoApplVO searchDimension(String bkgNo, String awkCgoSeq, String caFlg) throws EventException {

		AwkCgoApplVO awkCgoApplVO = new AwkCgoApplVO();
		
        try {       	
        	awkCgoApplVO.setBkgAwkDim(dbDao.searchDimension(bkgNo, awkCgoSeq, caFlg));                
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        return awkCgoApplVO;
    }
	
	
	/**	 
	 * ESM_BKG_0055 화면 저장 로직
	 * @param AwkCgoApplVO awkCgoApplVO 
	 * @param String caFlg 
	 * @exception EventException
	 */
	public void manageAwkCargo(AwkCgoApplVO awkCgoApplVO, String caFlg) throws EventException{
		
		BkgAwkCgoVO[] bkgAwkCgoVOs = awkCgoApplVO.getBkgAwkCgoVOs();
		BkgAwkDimVO[] bkgAwkDimVOs = awkCgoApplVO.getBkgAwkDimVOs();		
		SignOnUserAccount account = awkCgoApplVO.getAccount();
		BookingUtil utilCmd = new BookingUtil();	
		String user_id 	= account.getUsr_id();	//user id		
		String upd_dt 	= account.getUpd_dt();	//create date
		String bkgNo = awkCgoApplVO.getBkgNo();
		String uiId = awkCgoApplVO.getUiId();		
//		String spclTp = "AWK";		
		int cnt = 0;
		
		try {
			List<BkgAwkCgoVO> addVoList = new ArrayList<BkgAwkCgoVO>();
			List<BkgAwkCgoVO> modifyVoList = new ArrayList<BkgAwkCgoVO>();
			List<BkgAwkCgoVO> removeVoList = new ArrayList<BkgAwkCgoVO>();			
			List<BkgAwkDimVO> addVoList1 = new ArrayList<BkgAwkDimVO>();			
			List<BkgAwkDimVO> removeVoList1 = new ArrayList<BkgAwkDimVO>();	
			
//			if(!"ESM_BKG_0229".equals(uiId)){
//				dbDao.searchAwkApproval(bkgNo, caFlg);
//	        	dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg);
//			} else {	
			if("ESM_BKG_0229".equals(uiId)){
				List<BkgAwkDimVO> bkgAwkDimVoList = new ArrayList<BkgAwkDimVO>();
				bkgAwkDimVoList = dbDao.searchAwkDimDtl(bkgNo, caFlg);
				if(bkgAwkDimVoList.size()>0){
					bkgAwkDimVOs = new BkgAwkDimVO[bkgAwkDimVoList.size()];
					for(int i=0;i<bkgAwkDimVoList.size();i++){ 
						bkgAwkDimVOs[i] = bkgAwkDimVoList.get(i);
					}
				} else {
//					bkgAwkDimVOs = new BkgAwkDimVO[1];
					bkgAwkDimVOs = new BkgAwkDimVO[] {new BkgAwkDimVO() };
					bkgAwkDimVOs[0] = new BkgAwkDimVO();
					bkgAwkDimVOs[0].setBkgNo(bkgNo);
					bkgAwkDimVOs[0].setIbflag("X");
				}
			}
        	
			if(bkgAwkCgoVOs != null){
				for ( int i=0; i<bkgAwkCgoVOs.length; i++ ) {
					if ( bkgAwkCgoVOs[i].getIbflag().equals("I")){						
						cnt = cnt + 1;						
						if(!bkgAwkCgoVOs[i].getAwkDcgoSeq().equals("") && !bkgAwkCgoVOs[i].getAwkDcgoSeq().equals("0") && bkgAwkCgoVOs[i].getAwkDcgoSeq() != null){							
							String dgSn = bkgAwkCgoVOs[i].getAwkDcgoSeq();							
							if(dbDao.searchDgSn(bkgNo, dgSn, caFlg) == null){							
								throw new EventException((String)new ErrorHandler("BKG00529", new String[] {"DG Container S/N. Seq["+cnt+"]"}).getMessage());
							}
						}	

						if( bkgAwkCgoVOs[i].getPckTpCd().trim().length() > 0){							
							String pkgCd = bkgAwkCgoVOs[i].getPckTpCd();							
							if(utilCmd.searchPkgType(pkgCd).getPckCd() == null || utilCmd.searchPkgType(pkgCd).getPckCd().equals("")){								
								throw new EventException((String)new ErrorHandler("BKG00530", new String[] {"Package Type Code. Seq["+cnt+"]"}).getMessage());
							}					
						}						
//						if(bkgAwkCgoVOs[i].getCmdtCd() != null){			
						if( bkgAwkCgoVOs[i].getCmdtCd().trim().length() > 0){		
							String cmdtCd = bkgAwkCgoVOs[i].getCmdtCd();							
							if(utilCmd.searchMdmCmdtDesc(cmdtCd).equalsIgnoreCase("")){								
								throw new EventException((String)new ErrorHandler("BKG00010", new String[] {"Commodity Code. Seq["+cnt+"]"}).getMessage());
							}							
						}						
						addVoList.add(bkgAwkCgoVOs[i]);
						bkgAwkCgoVOs[i].setCreUsrId(user_id);
						bkgAwkCgoVOs[i].setUpdUsrId(user_id);
						bkgAwkCgoVOs[i].setUpdDt(upd_dt);						
					} else if ( bkgAwkCgoVOs[i].getIbflag().equals("U")){
						//eBKG에서는 request, approve, reject에 대해서는 update하지 않음
						if("ESM_BKG_0229".equals(uiId)){
							if("Y".equals(bkgAwkCgoVOs[i].getSpclCgoAproCd())||"A".equals(bkgAwkCgoVOs[i].getSpclCgoAproCd())||"R".equals(bkgAwkCgoVOs[i].getSpclCgoAproCd())){
								continue;
							}
						}
						cnt = cnt + 1;						
						if(!bkgAwkCgoVOs[i].getAwkDcgoSeq().equals("") && !bkgAwkCgoVOs[i].getAwkDcgoSeq().equals("0") && bkgAwkCgoVOs[i].getAwkDcgoSeq() != null){						
							String dgSn = bkgAwkCgoVOs[i].getAwkDcgoSeq();
							if(dbDao.searchDgSn(bkgNo, dgSn, caFlg) == null){	
								
								throw new EventException((String)new ErrorHandler("BKG00529", new String[] {"DG Container S/N. Seq["+cnt+"]"}).getMessage());
							}							
						}						
						if(bkgAwkCgoVOs[i].getPckTpCd() != null && bkgAwkCgoVOs[i].getPckTpCd().trim().length() > 0 ){							
							String pkgCd = bkgAwkCgoVOs[i].getPckTpCd();				
							MdmPckTpVO sPckCd = utilCmd.searchPkgType(pkgCd);
							if(sPckCd == null || sPckCd.getPckCd().equals("")){													
								throw new EventException((String)new ErrorHandler("BKG00530", new String[] {"Package Type Code. Seq["+cnt+"]"}).getMessage());
							}							
						}						
						if(bkgAwkCgoVOs[i].getCmdtCd() != null && bkgAwkCgoVOs[i].getCmdtCd().trim().length() > 0){							
							String cmdtCd = bkgAwkCgoVOs[i].getCmdtCd();							
							if(utilCmd.searchMdmCmdtDesc(cmdtCd) == null || utilCmd.searchMdmCmdtDesc(cmdtCd).equals("")){														
								throw new EventException((String)new ErrorHandler("BKG00010", new String[] {"Commodity Code. Seq["+cnt+"]"}).getMessage());
							}							
						}						
						modifyVoList.add(bkgAwkCgoVOs[i]);
						bkgAwkCgoVOs[i].setCreUsrId(user_id);
						bkgAwkCgoVOs[i].setUpdUsrId(user_id);						
						bkgAwkCgoVOs[i].setUpdDt(upd_dt);
					} else if ( bkgAwkCgoVOs[i].getIbflag().equals("D")){						
						removeVoList.add(bkgAwkCgoVOs[i]);
					} 
				}				
				if(addVoList.size() > 0){
					if("ESM_BKG_0229".equals(uiId)){
						for(int awkIdx = 0;awkIdx < addVoList.size();awkIdx++){
							addVoList.get(awkIdx).setBkgNo(bkgNo);
						}
						dbDao.addBkgAwkCgoByXter(addVoList, caFlg);
					} else {
						dbDao.addBkgAwkCgo(addVoList, uiId, caFlg);
					}
					dbDao.modifyDgAwkSeq1(addVoList, caFlg);
					dbDao.modifyDgAwkSeq2(addVoList, caFlg);
				}
				if(modifyVoList.size() > 0){
					if("ESM_BKG_0229".equals(uiId)){
						for(int awkIdx = 0;awkIdx < modifyVoList.size();awkIdx++){
							modifyVoList.get(awkIdx).setBkgNo(bkgNo);
						}
						dbDao.modifyBkgAwkCgoByXter(modifyVoList, caFlg);
					} else {
						dbDao.modifyBkgAwkCgo(modifyVoList, uiId, caFlg);
					}
					dbDao.modifyDgAwkSeq1(modifyVoList, caFlg);
					dbDao.modifyDgAwkSeq2(modifyVoList, caFlg);
				}
				if(removeVoList.size() > 0){			
					//FK 관계로 AWK_DIM Insert
					removeVoList1.add(bkgAwkDimVOs[0]);
					dbDao.removeBkgAwkDim(removeVoList1, caFlg);	
					dbDao.removeBkgAwkCgo(removeVoList, caFlg);
					dbDao.modifyDgAwkSeq1(modifyVoList, caFlg);
				}				
			}		
			
			// AWK_DIM Insert
			if(bkgAwkDimVOs != null){
				for ( int j=0; j<bkgAwkDimVOs.length; j++ ) {								
					if (  bkgAwkDimVOs[j].getIbflag() != null && bkgAwkDimVOs[j].getIbflag().trim().length() > 0 && bkgAwkDimVOs[j].getIbflag().equals("I")){						
						addVoList1.add(bkgAwkDimVOs[j]);
						bkgAwkDimVOs[j].setCreUsrId(user_id);
						bkgAwkDimVOs[j].setUpdUsrId(user_id);
					} 
				}
				
				if(addVoList1.size() > 0)
					dbDao.addBkgAwkDim(addVoList1, caFlg);
			}
		} catch (EventException ex) {   
		   throw ex;	
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("FMS01306", new String[] {}).getMessage(), de);
			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);       
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt(ESM_BKG_0200)화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @param boolean searchCntrFlag
	 * @return DgCgoApplVO 
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgCargo(String bkgNo, String blNo, String caFlg, boolean searchCntrFlag) throws EventException {
		
		DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();
		String spclTp = "DG";
        try {
                dgCgoApplVO.setBkgDgCgoInfo(dbDao.searchDgCgoList(bkgNo, caFlg));
                dgCgoApplVO.setDgCgoList(dbDao.searchDgList(bkgNo, caFlg));
                dgCgoApplVO.setDgBkgInfo(dbDao.searchDgBkgInfo(bkgNo, caFlg));
                dgCgoApplVO.setDgAproInfo(dbDao.searchDgApproval(bkgNo, caFlg));
                // 이전 bkgNo와 현재 bkgNo가 틀린경우 Container 정보 조회.
                if(searchCntrFlag){
	                dgCgoApplVO.setCntrTypzQty(dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg));                
	                dgCgoApplVO.setCntrCombo(dbDao.searchCntrList(bkgNo, spclTp, caFlg));
                }
                dgCgoApplVO.setCntrInfoList(dbDao.searchCntrInfoList(bkgNo, caFlg));                
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        return dgCgoApplVO;
    }

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0735 화면에 대한 Copy From Old Booking 조회 이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @param boolean searchCntrFlag
	 * @return DgCgoApplVO 
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgCargoFromOldBkg(String bkgNo, String blNo, String caFlg, boolean searchCntrFlag) throws EventException {
		
		DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();
        try {
                dgCgoApplVO.setBkgDgCgoInfo(dbDao.searchDgCgoList(bkgNo, caFlg));
                dgCgoApplVO.setDgCgoList(dbDao.searchDgList(bkgNo, caFlg));
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        return dgCgoApplVO;
    }
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt화면(ESM_BKG_1045)에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String code
	 * @param String desc
	 * @param String pckTpCd
	 * @return DgCgoApplVO
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgPackage(String code, String desc, String pckTpCd) throws EventException {
		
		DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();
		
        try {                                 
        	dgCgoApplVO.setDgPackage(dbDao.searchDgPackage(code, desc, pckTpCd));                
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);         
        }
        return dgCgoApplVO;
    }
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @param String unNo
	 * @param String imdgClass
	 * @param String prpShpNm
	 * @return DgCgoApplVO 
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgUnNumber(String bkgNo, String unNo, String imdgClass, String prpShpNm) throws EventException {

		DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();
		
        try {                                
        	dgCgoApplVO.setScgImdgUnNo(dbDao.searchDgUnNumber(bkgNo, unNo, imdgClass, prpShpNm));                
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        return dgCgoApplVO;
    }
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에서 DG 시퀀스 조회시 이벤트 처리<br> 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrTpszCd
	 * @param String caFlg
	 * @return DgCgoApplVO 
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgSequence(String bkgNo, String cntrNo, String cntrTpszCd, String caFlg) throws EventException {

		DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();
		
        try {                               
        	dgCgoApplVO.setBkgDgCgoInfo(dbDao.searchDgSequence(bkgNo, cntrNo, cntrTpszCd, caFlg));                
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        return dgCgoApplVO;
    }
	
	/**	 
	 * ESM_BKG_0200 화면 저장이벤트 처리
	 * @param DgCgoApplVO dgCgoApplVO 
	 * @param String caFlg  
	 * @exception EventException
	 */
	public void manageDgCargo(DgCgoApplVO dgCgoApplVO, String caFlg) throws EventException{
		
		DgCgoListVO[] dgCgoListVOs = dgCgoApplVO.getDgCgoListVOs();
		SignOnUserAccount account = dgCgoApplVO.getAccount();
		BookingUtil utilCmd = new BookingUtil();	
		String user_id 	= account.getUsr_id();	//user id		
		String upd_dt 	= account.getUpd_dt();	//create date
		String bkgNo = dgCgoApplVO.getBkgNo();
		String uiId = dgCgoApplVO.getUiId();		
//		String spclTp = "DG";	
		int cnt = 0;
		
		try {
			List<DgCgoListVO> addVoList = new ArrayList<DgCgoListVO>();
			List<DgCgoListVO> modifyVoList = new ArrayList<DgCgoListVO>();
			List<DgCgoListVO> removeVoList = new ArrayList<DgCgoListVO>();			
//			dbDao.searchDgApproval(bkgNo, caFlg);
//        	dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg);
			
			if(dgCgoListVOs != null){				
				for ( int i=0; i<dgCgoListVOs.length; i++ ) {
					if ( dgCgoListVOs[i].getIbflag().equals("I")){
						cnt = cnt + 1;
						if(!dgCgoListVOs[i].getInImdgPckCd1().equals("") && !dgCgoListVOs[i].getInImdgPckCd1().equals("0")){							
							String dgPkgTpCd = dgCgoListVOs[i].getInImdgPckCd1();							
							if(!utilCmd.searchPkgTypeForDg(dgPkgTpCd).equals("1")){						
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"1st Inner Package Code. Seq["+cnt+"]"}).getMessage());
							}
						}						
						if(!dgCgoListVOs[i].getInImdgPckCd2().equals("") && !dgCgoListVOs[i].getInImdgPckCd2().equals("0")){							
							String dgPkgTpCd = dgCgoListVOs[i].getInImdgPckCd2();							
							if(!utilCmd.searchPkgTypeForDg(dgPkgTpCd).equals("1")){							
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"2st Inner Package Code. Seq["+cnt+"]"}).getMessage());
							}
						}						
						if(!dgCgoListVOs[i].getOutImdgPckCd1().equals("") && !dgCgoListVOs[i].getOutImdgPckCd1().equals("0")){							
							String dgPkgTpCd = dgCgoListVOs[i].getOutImdgPckCd1();							
							if(!utilCmd.searchPkgTypeForDg(dgPkgTpCd).equals("1")){						
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"1st Outer Package Code. Seq["+cnt+"]"}).getMessage());
							}
						}						
						if(!dgCgoListVOs[i].getOutImdgPckCd2().equals("") && !dgCgoListVOs[i].getOutImdgPckCd2().equals("0")){							
							String dgPkgTpCd = dgCgoListVOs[i].getOutImdgPckCd2();							
							if(!utilCmd.searchPkgTypeForDg(dgPkgTpCd).equals("1")){
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"2st Outer Package Code. Seq["+cnt+"]"}).getMessage());
							}
						}						
						if(!dgCgoListVOs[i].getImdgUnNo().equals("") && !dgCgoListVOs[i].getImdgUnNo().equals("0")){							
							String unNo = dgCgoListVOs[i].getImdgUnNo();							
							if(!dbDao.searchUnNoIno(unNo).equals("1")){
								throw new EventException(new ErrorHandler("COM12242", new String[] {"Un No. Seq["+cnt+"]"}).getMessage());
							}
						}
						if (dgCgoListVOs[i].getFlshPntCdoTemp() != null && dgCgoListVOs[i].getFlshPntCdoTemp().length() > 0) {
							if(Float.compare(Float.parseFloat(dgCgoListVOs[i].getFlshPntCdoTemp()), -273.0F) < 0){
//							if(Float.parseFloat(dgCgoListVOs[i].getFlshPntCdoTemp()) < -273.0){
								throw new EventException((String) new ErrorHandler("BKG00651", new String[] { "Flash Point Celsius Temperature: "+ dgCgoListVOs[i].getFlshPntCdoTemp()}).getMessage());
							}
						}
						
						// SHA EXPO기간 중 D/G화물 선적제한 요청 2010.04.09 
						// 2010.09.24 메시지 DB에서 조회 후 처리- ATTR_CTNT6 메시지 등록 : 가능한 조건별로 메세지 다른게 처리 가능, 시간 까지 관리 가능
						
						if( 1 == 1 ){	
							
							String imdgUnNo = dgCgoListVOs[i].getImdgUnNo();
							String imdgClssCd = dgCgoListVOs[i].getImdgClssCd();
							String seq =  dgCgoListVOs[i].getDcgoSeq();
							String imdgUnNoSeq = dgCgoListVOs[i].getImdgUnNoSeq(); //양동훈
							log.debug("\n###################### getImdgUnNo" + imdgUnNo);
							log.debug("\n###################### seq" + seq);
							log.debug("\n###################### bkgNo" + bkgNo);
							
							String msg = dbDao.searchChnProhibit(bkgNo, seq, imdgUnNo, imdgClssCd);
							
							if(dbDao.searchChnProhibit(bkgNo, seq, imdgUnNo, imdgClssCd).length() > 0){
								throw new EventException(new ErrorHandler(msg, new String[]{}).getMessage());
							}
							//Un NO.가 4자리가 아닐 때 validation
							if(imdgUnNo.length()<4){
								throw new EventException((String) new ErrorHandler("BKG95090", new String[] {}).getMessage());
							}
							//UN NO. seq가 0일 때 validation
							if("0".equals(imdgUnNoSeq)){
								throw new EventException((String) new ErrorHandler("BKG95091", new String[] {}).getMessage());
							}
						}
						addVoList.add(dgCgoListVOs[i]);
						dgCgoListVOs[i].setCreUsrId(user_id);
						dgCgoListVOs[i].setUpdUsrId(user_id);
						dgCgoListVOs[i].setUpdDt(upd_dt);												
					} else if ( dgCgoListVOs[i].getIbflag().equals("U")){		
						//eBKG에서는 request, approve, reject에 대해서는 update하지 않음
						if("ESM_BKG_0229".equals(uiId)){
							if("Y".equals(dgCgoListVOs[i].getSpclCgoAproCd())||"A".equals(dgCgoListVOs[i].getSpclCgoAproCd())||"R".equals(dgCgoListVOs[i].getSpclCgoAproCd())){
								continue;
							}
						}				
						cnt = cnt + 1;						
						if(!dgCgoListVOs[i].getInImdgPckCd1().equals("") && !dgCgoListVOs[i].getInImdgPckCd1().equals("0")){							
							String dgPkgTpCd = dgCgoListVOs[i].getInImdgPckCd1();							
							if(!utilCmd.searchPkgTypeForDg(dgPkgTpCd).equals("1")){
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"1st Inner Package Code. Seq["+cnt+"]"}).getMessage());
							}
						}						
						if(!dgCgoListVOs[i].getInImdgPckCd2().equals("") && !dgCgoListVOs[i].getInImdgPckCd2().equals("0")){							
							String dgPkgTpCd = dgCgoListVOs[i].getInImdgPckCd2();							
							if(!utilCmd.searchPkgTypeForDg(dgPkgTpCd).equals("1")){
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"2st Inner Package Code. Seq["+cnt+"]"}).getMessage());
							}
						}						
						if(!dgCgoListVOs[i].getOutImdgPckCd1().equals("") && !dgCgoListVOs[i].getOutImdgPckCd1().equals("0")){							
							String dgPkgTpCd = dgCgoListVOs[i].getOutImdgPckCd1();							
							if(!utilCmd.searchPkgTypeForDg(dgPkgTpCd).equals("1")){
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"1st Outer Package Code. Seq["+cnt+"]"}).getMessage());
							}
						}						
						if(!dgCgoListVOs[i].getOutImdgPckCd2().equals("") && !dgCgoListVOs[i].getOutImdgPckCd2().equals("0")){							
							String dgPkgTpCd = dgCgoListVOs[i].getOutImdgPckCd2();							
							if(!utilCmd.searchPkgTypeForDg(dgPkgTpCd).equals("1")){
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"2st Outer Package Code. Seq["+cnt+"]"}).getMessage());
							}
						}						
						if(!dgCgoListVOs[i].getImdgUnNo().equals("") && !dgCgoListVOs[i].getImdgUnNo().equals("0")){							
							String unNo = dgCgoListVOs[i].getImdgUnNo();							
							if(!dbDao.searchUnNoIno(unNo).equals("1")){
								throw new EventException(new ErrorHandler("COM12242", new String[] {"Un No. Seq["+cnt+"]"}).getMessage());
							}
						}
						if (dgCgoListVOs[i].getFlshPntCdoTemp() != null && dgCgoListVOs[i].getFlshPntCdoTemp().length() > 0) {
							if(Float.compare(Float.parseFloat(dgCgoListVOs[i].getFlshPntCdoTemp()), -273.0F) < 0){
//							if(Float.parseFloat(dgCgoListVOs[i].getFlshPntCdoTemp()) < -273.0){
								throw new EventException((String) new ErrorHandler("BKG00651", new String[] { "Flash Point Celsius Temperature: "+ dgCgoListVOs[i].getFlshPntCdoTemp()}).getMessage());
							} 
						}
						// SHA EXPO기간 중 D/G화물 선적제한 요청 2010.04.09 
						// 2010.09.24 메시지 DB에서 조회 후 처리 - ATTR_CTNT6 메시지 등록 : 가능한 조건별로 메세지 다른게 처리 가능, 시간 까지 관리 가능
						if( 1 == 1 ){	
							
							String imdgUnNo = dgCgoListVOs[i].getImdgUnNo();
							String imdgClssCd = dgCgoListVOs[i].getImdgClssCd();
							String seq =  dgCgoListVOs[i].getDcgoSeq();
							String imdgUnNoSeq = dgCgoListVOs[i].getImdgUnNoSeq();//양동훈
							
							log.debug("\n###################### getImdgUnNo" + imdgUnNo);
							log.debug("\n###################### seq" + seq);
							log.debug("\n###################### bkgNo" + bkgNo);
							
							String msg = dbDao.searchChnProhibit(bkgNo, seq, imdgUnNo, imdgClssCd);
							
							if(dbDao.searchChnProhibit(bkgNo, seq, imdgUnNo, imdgClssCd).length() > 0){
								throw new EventException(new ErrorHandler(msg, new String[]{}).getMessage());
							}
							//Un NO.가 4자리가 아닐 때 validation
							if(imdgUnNo.length()<4){
								throw new EventException((String) new ErrorHandler("BKG95090", new String[] {}).getMessage());
							}
							//UN NO. seq가 0일 때 validation
							if("0".equals(imdgUnNoSeq)){
								throw new EventException((String) new ErrorHandler("BKG95091", new String[] {}).getMessage());
							}
						}
						modifyVoList.add(dgCgoListVOs[i]);
						dgCgoListVOs[i].setCreUsrId(user_id);
						dgCgoListVOs[i].setUpdUsrId(user_id);						
						dgCgoListVOs[i].setUpdDt(upd_dt);						
					} else if ( dgCgoListVOs[i].getIbflag().equals("D")){						
						removeVoList.add(dgCgoListVOs[i]);							
					} 
				}				
				if(addVoList.size() > 0){
					if("ESM_BKG_0229".equals(uiId)){
						for(int dgIdx = 0;dgIdx < addVoList.size();dgIdx++){
							addVoList.get(dgIdx).setBkgNo(bkgNo);
						}
						dbDao.addDgCgoListByXter(addVoList, caFlg);						
					} else {
						dbDao.addDgCgoList(addVoList, uiId, caFlg);
					}
				}
				if(modifyVoList.size() > 0){
					if("ESM_BKG_0229".equals(uiId)){
						for(int dgIdx = 0;dgIdx < modifyVoList.size();dgIdx++){
							modifyVoList.get(dgIdx).setBkgNo(bkgNo);
						}
						dbDao.modifyDgCgoListByXter(modifyVoList, caFlg);						
					} else {
						dbDao.modifyDgCgoList(modifyVoList, uiId, caFlg);
					}
				}
				if(removeVoList.size() > 0){
					dbDao.removeDgCgoList(removeVoList, caFlg);					
				}				
			}				
		} catch (EventException ex) {   
			throw ex;		
		} catch (DAOException de) {			
			throw new EventException(new ErrorHandler("FMS01306", new String[] {}).getMessage(), de);
		} catch (Exception de) {			
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);       
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @return RfCgoApplVO 
	 * @exception EventException
	 */
	public RfCgoApplVO searchRfCargo(String bkgNo, String blNo, String caFlg) throws EventException {

		RfCgoApplVO rfCgoApplVO = new RfCgoApplVO();		
		String spclTp = "RF";
		
        try {
                rfCgoApplVO.setBkgRfCgoVO(dbDao.searchRfCgoList(bkgNo, caFlg));                
                rfCgoApplVO.setRfBkgInfoVO(dbDao.searchRfBkgInfo(bkgNo, caFlg));
                rfCgoApplVO.setRfAproInfoVO(dbDao.searchRfApproval(bkgNo, caFlg));
                rfCgoApplVO.setCntrTypzQty(dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg));                
                rfCgoApplVO.setCntrCombo(dbDao.searchCntrList(bkgNo, spclTp, caFlg));                
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);  
        }
        return rfCgoApplVO;
    }
	
	/**	 
	 * ESM_BKG_0498 화면 저장 이벤트 처리
	 * @param RfCgoApplVO rfCgoApplVO 
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRfCargo(RfCgoApplVO rfCgoApplVO, String caFlg) throws EventException{
		
		BkgRfCgoVO[] bkgRfCgoVOs = rfCgoApplVO.getBkgRfCgoVOs();	
		SignOnUserAccount account = rfCgoApplVO.getAccount();
		BookingUtil utilCmd = new BookingUtil();	
		String user_id 	= account.getUsr_id();	//user id		
		String upd_dt 	= account.getUpd_dt();	//create date
		String bkgNo = rfCgoApplVO.getBkgNo();
		String uiId = rfCgoApplVO.getUiId();		
//		String spclTp = "RF";		
		int cnt = 0;
		
		try {
			List<BkgRfCgoVO> addVoList = new ArrayList<BkgRfCgoVO>();
			List<BkgRfCgoVO> modifyVoList = new ArrayList<BkgRfCgoVO>();
			List<BkgRfCgoVO> removeVoList = new ArrayList<BkgRfCgoVO>();									
//			dbDao.searchRfApproval(bkgNo, caFlg);
//			dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg);      	
       	
			if(bkgRfCgoVOs != null){
				for ( int i=0; i<bkgRfCgoVOs.length; i++ ) {
					
					// E-booking 에서는 pwr_spl_cbl_flg 값이 "Y" 로 들어옴 
					if(bkgRfCgoVOs[i]!= null && (bkgRfCgoVOs[i].getPwrSplCblFlg().equals("1") || bkgRfCgoVOs[i].getPwrSplCblFlg().equals("Y")) ){
						bkgRfCgoVOs[i].setPwrSplCblFlg("Y");
					}else{
						bkgRfCgoVOs[i].setPwrSplCblFlg("N");
					}
					
					if ( bkgRfCgoVOs[i].getIbflag().equals("I")){
						cnt = cnt + 1;						
						if(!bkgRfCgoVOs[i].getRfDcgoSeq().equals("") && !bkgRfCgoVOs[i].getRfDcgoSeq().equals("0") && bkgRfCgoVOs[i].getRfDcgoSeq() != null){							
							String dgSn = bkgRfCgoVOs[i].getRfDcgoSeq();							
							if(dbDao.searchDgSn(bkgNo, dgSn, caFlg) == null){
								throw new EventException(new ErrorHandler("BKG00529", new String[] {"DG Container S/N. Seq["+cnt+"]"}).getMessage());
							}
						}						
						if(!bkgRfCgoVOs[i].getPckTpCd().equals("")){							
							String pkgCd = bkgRfCgoVOs[i].getPckTpCd();		
							MdmPckTpVO mv = utilCmd.searchPkgType(pkgCd);
							if(mv == null || mv.getPckCd().equals("")){
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"Package Type Code. Seq["+cnt+"]"}).getMessage());
							}							
						}						
						if(bkgRfCgoVOs[i].getCmdtCd() != null){							
							String cmdtCd = bkgRfCgoVOs[i].getCmdtCd();							
							if(utilCmd.searchMdmCmdtDesc(cmdtCd) == null || utilCmd.searchMdmCmdtDesc(cmdtCd).equals("")){
								throw new EventException(new ErrorHandler("BKG00010", new String[] {"Commodity Code. Seq["+cnt+"]"}).getMessage());
							}							
						}
						if (bkgRfCgoVOs[i].getCbmPerHrQty() != null && bkgRfCgoVOs[i].getCbmPerHrQty().length() > 0) {
							if(Integer.parseInt(bkgRfCgoVOs[i].getCbmPerHrQty()) < 0){
								throw new EventException((String) new ErrorHandler("BKG00651", new String[] { "CBM Per Hour Quantity: "+ bkgRfCgoVOs[i].getCbmPerHrQty()}).getMessage());
							}
						}
						addVoList.add(bkgRfCgoVOs[i]);
						bkgRfCgoVOs[i].setCreUsrId(user_id);
						bkgRfCgoVOs[i].setUpdUsrId(user_id);
						bkgRfCgoVOs[i].setUpdDt(upd_dt);						
					} else if ( bkgRfCgoVOs[i].getIbflag().equals("U")){
						//eBKG에서는 request, approve, reject에 대해서는 update하지 않음
						if("ESM_BKG_0229".equals(uiId)){
							if("Y".equals(bkgRfCgoVOs[i].getSpclCgoAproCd())||"A".equals(bkgRfCgoVOs[i].getSpclCgoAproCd())||"R".equals(bkgRfCgoVOs[i].getSpclCgoAproCd())){
								continue;
							}
						}										
						cnt = cnt + 1;						
						if(!bkgRfCgoVOs[i].getRfDcgoSeq().equals("") && !bkgRfCgoVOs[i].getRfDcgoSeq().equals("0") && bkgRfCgoVOs[i].getRfDcgoSeq() != null){											
							String dgSn = bkgRfCgoVOs[i].getRfDcgoSeq();							
							if(dbDao.searchDgSn(bkgNo, dgSn, caFlg) == null){
								throw new EventException(new ErrorHandler("BKG00529", new String[] {"DG Container S/N. Seq["+cnt+"]"}).getMessage());
							}							
						}						
						if(!bkgRfCgoVOs[i].getPckTpCd().equals("")){							
							String pkgCd = bkgRfCgoVOs[i].getPckTpCd();
							MdmPckTpVO mv = utilCmd.searchPkgType(pkgCd);
							if(mv == null || mv.getPckCd().equals("")){
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"Package Type Code. Seq["+cnt+"]"}).getMessage());
							}							
						}						
//						if(bkgRfCgoVOs[i].getCmdtCd() != null){							
						if(!bkgRfCgoVOs[i].getCmdtCd().equals("")){	
							String cmdtCd = bkgRfCgoVOs[i].getCmdtCd();							
							if(utilCmd.searchMdmCmdtDesc(cmdtCd) == null || utilCmd.searchMdmCmdtDesc(cmdtCd).equals("")){
								throw new EventException(new ErrorHandler("BKG00010", new String[] {"Commodity Code. Seq["+cnt+"]"}).getMessage());
							}							
						}							
						if (bkgRfCgoVOs[i].getCbmPerHrQty() != null && bkgRfCgoVOs[i].getCbmPerHrQty().length() > 0) {
							if(Integer.parseInt(bkgRfCgoVOs[i].getCbmPerHrQty()) < 0){
								throw new EventException((String) new ErrorHandler("BKG00651", new String[] { "CBM Per Hour Quantity: "+ bkgRfCgoVOs[i].getCbmPerHrQty()}).getMessage());
							}
						}
						modifyVoList.add(bkgRfCgoVOs[i]);
						bkgRfCgoVOs[i].setCreUsrId(user_id);
						bkgRfCgoVOs[i].setUpdUsrId(user_id);						
						bkgRfCgoVOs[i].setUpdDt(upd_dt);
					} else if ( bkgRfCgoVOs[i].getIbflag().equals("D")){
						removeVoList.add(bkgRfCgoVOs[i]);						
					} 
				}				
				if(addVoList.size() > 0){
					if("ESM_BKG_0229".equals(uiId)){
						for(int rfIdx = 0;rfIdx < addVoList.size();rfIdx++){
							addVoList.get(rfIdx).setBkgNo(bkgNo);
						}
						dbDao.addBkgRfCgoByXter(addVoList, caFlg);						
					} else {
						dbDao.addBkgRfCgo(addVoList, uiId, caFlg);
					}
					dbDao.modifyDgRfSeq1(addVoList, caFlg);
					dbDao.modifyDgRfSeq2(addVoList, caFlg);					
				}
				if(modifyVoList.size() > 0){
					if("ESM_BKG_0229".equals(uiId)){
						for(int rfIdx = 0;rfIdx < modifyVoList.size();rfIdx++){
							modifyVoList.get(rfIdx).setBkgNo(bkgNo);
						}
						dbDao.modifyBkgRfCgoByXter(modifyVoList, caFlg);						
					} else {
						dbDao.modifyBkgRfCgo(modifyVoList, uiId, caFlg);
						
						dbDao.modifyPsaCntrTemp(modifyVoList);	//2011.03.28 변종건 [CHM-201109427-01]
					}
					dbDao.modifyDgRfSeq1(modifyVoList, caFlg);
					dbDao.modifyDgRfSeq2(modifyVoList, caFlg);					
				}
				if(removeVoList.size() > 0){
					dbDao.removeBkgRfCgo(removeVoList, caFlg);
					dbDao.modifyDgRfSeq1(modifyVoList, caFlg);										
				}				
			}
		} catch (EventException ex) {   
			throw ex;	
		} catch (DAOException de) {			
			throw new EventException(new ErrorHandler("FMS01306", new String[] {}).getMessage(), de);
		} catch (Exception de) {			
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);       
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  SpecialCargoReceipt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @return BbCgoApplVO 
	 * @exception EventException
	 */
	public BbCgoApplVO searchBbCargo(String bkgNo, String blNo, String caFlg) throws EventException {

		BbCgoApplVO bbCgoApplVO = new BbCgoApplVO();		
		String spclTp = "BB";
		
        try {
                bbCgoApplVO.setBkgBbCgoVO(dbDao.searchBbCgoList(bkgNo, caFlg));                
                bbCgoApplVO.setBbBkgInfoVO(dbDao.searchBbBkgInfo(bkgNo, caFlg));
                bbCgoApplVO.setBbAproInfoVO(dbDao.searchBbApproval(bkgNo, caFlg));
                bbCgoApplVO.setBbCntrListVO(dbDao.searchBbCgoCntrList(bkgNo, caFlg));
                bbCgoApplVO.setCntrTypzQty(dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg));                
                bbCgoApplVO.setCntrCombo(dbDao.searchCntrList(bkgNo, spclTp, caFlg));                 
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);    
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);      
        }
        return bbCgoApplVO;
    }
	
	/**	 
	 * ESM_BKG_0106 화면 저장이벤트 처리
	 * @param BbCgoApplVO bbCgoApplVO
	 * @param String caFlg 	
	 * @exception EventException
	 */
	public void manageBbCargo(BbCgoApplVO bbCgoApplVO, String caFlg) throws EventException{
		
		BkgBbCgoVO[] bkgBbCgoVOs = bbCgoApplVO.getBkgBbCgoVOs();		
		SignOnUserAccount account = bbCgoApplVO.getAccount();
		BookingUtil utilCmd = new BookingUtil();	
		String user_id 	= account.getUsr_id();	//user id		
		String upd_dt 	= account.getUpd_dt();	//create date
		String bkgNo = bbCgoApplVO.getBkgNo();
		String uiId = bbCgoApplVO.getUiId();
		//String ovrVoidSltQty = bbCgoApplVO.getOvrVoidSltQty();;		
//		String spclTp = "BB";		
		int cnt = 0;
		
		try {
			List<BkgBbCgoVO> addVoList = new ArrayList<BkgBbCgoVO>();
			List<BkgBbCgoVO> modifyVoList = new ArrayList<BkgBbCgoVO>();
			List<BkgBbCgoVO> removeVoList = new ArrayList<BkgBbCgoVO>();									
//			dbDao.searchBbApproval(bkgNo, caFlg);
//			dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg); 			
			      	
			if(bkgBbCgoVOs != null){
				for ( int i=0; i<bkgBbCgoVOs.length; i++ ) {
					if ( bkgBbCgoVOs[i].getIbflag().equals("I")){						
						cnt = cnt + 1;					
						if(!bkgBbCgoVOs[i].getBbDcgoSeq().equals("") && !bkgBbCgoVOs[i].getBbDcgoSeq().equals("0") && bkgBbCgoVOs[i].getBbDcgoSeq() != null){							
							String dgSn = bkgBbCgoVOs[i].getBbDcgoSeq();							
							if(dbDao.searchDgSn(bkgNo, dgSn, caFlg) == null){
								throw new EventException(new ErrorHandler("BKG00529", new String[] {"DG Container S/N. Seq["+cnt+"]"}).getMessage());
							}
						}						
						if(!bkgBbCgoVOs[i].getPckTpCd().equals("")){							
							String pkgCd = bkgBbCgoVOs[i].getPckTpCd();	
							MdmPckTpVO pVO = utilCmd.searchPkgType(pkgCd);
							if( pVO == null || pVO.getPckCd().equals("")){
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"Package Type Code. Seq["+cnt+"]"}).getMessage());
							}							
						}						

						if(!"ESM_BKG_0229".equals(uiId)){
							if(bkgBbCgoVOs[i].getCmdtCd() != null){							
								String cmdtCd = bkgBbCgoVOs[i].getCmdtCd();		
								String r_cmdtCd = utilCmd.searchMdmCmdtDesc(cmdtCd);
								if(r_cmdtCd == null || r_cmdtCd.equals("")){
									throw new EventException(new ErrorHandler("BKG00010", new String[] {"Commodity Code. Seq["+cnt+"]"}).getMessage());
								}							
							}
						}
						if(bkgBbCgoVOs[i].getDeTermCd() != null){
							// D:door, Y:yard, M:mixed, S:CFS, T:Tackle, I:Free IN(I)
							// H:Haulage(삭제됨), F:Free(?)
							if(!"D".equals(bkgBbCgoVOs[i].getDeTermCd()) && !"Y".equals(bkgBbCgoVOs[i].getDeTermCd()) 
									&& !"M".equals(bkgBbCgoVOs[i].getDeTermCd()) && !"S".equals(bkgBbCgoVOs[i].getDeTermCd()) 
									&& !"H".equals(bkgBbCgoVOs[i].getDeTermCd()) && !"T".equals(bkgBbCgoVOs[i].getDeTermCd()) 
									&& !"F".equals(bkgBbCgoVOs[i].getDeTermCd()) && !"I".equals(bkgBbCgoVOs[i].getDeTermCd()) 
									&& !"O".equals(bkgBbCgoVOs[i].getDeTermCd())){
								throw new EventException((String) new ErrorHandler("BKG00651", new String[] {"Delivery Term Code: "+ bkgBbCgoVOs[i].getDeTermCd()}).getMessage());							
							}
						}
						addVoList.add(bkgBbCgoVOs[i]);
						bkgBbCgoVOs[i].setCreUsrId(user_id);
						bkgBbCgoVOs[i].setUpdUsrId(user_id);
						bkgBbCgoVOs[i].setUpdDt(upd_dt);						
					} else if ( bkgBbCgoVOs[i].getIbflag().equals("U")){						
						cnt = cnt + 1;						
						if(!bkgBbCgoVOs[i].getBbDcgoSeq().equals("") && !bkgBbCgoVOs[i].getBbDcgoSeq().equals("0") && bkgBbCgoVOs[i].getBbDcgoSeq() != null){							
							String dgSn = bkgBbCgoVOs[i].getBbDcgoSeq();							
							if(dbDao.searchDgSn(bkgNo, dgSn, caFlg)== null){
								throw new EventException(new ErrorHandler("BKG00529", new String[] {"DG Container S/N. Seq["+cnt+"]"}).getMessage());
							}
						}		
						if(!bkgBbCgoVOs[i].getPckTpCd().equals("")){							
							String pkgCd = bkgBbCgoVOs[i].getPckTpCd();		
							MdmPckTpVO pVO = utilCmd.searchPkgType(pkgCd);
							if( pVO == null || pVO.getPckCd().equals("")){
								throw new EventException(new ErrorHandler("BKG00530", new String[] {"Package Type Code. Seq["+cnt+"]"}).getMessage());
							}
						}					
						if(!"ESM_BKG_0229".equals(uiId)){
							if(bkgBbCgoVOs[i].getCmdtCd() != null){							
								String cmdtCd = bkgBbCgoVOs[i].getCmdtCd();	
								String r_cmdtCd = utilCmd.searchMdmCmdtDesc(cmdtCd);
								if( r_cmdtCd== null || r_cmdtCd.equals("")){
									throw new EventException(new ErrorHandler("BKG00010", new String[] {"Commodity Code. Seq["+cnt+"]"}).getMessage());								
								}							
							}
						}
						if(bkgBbCgoVOs[i].getDeTermCd() != null){
							// D:door, Y:yard, M:mixed, S:CFS, T:Tackle, I:Free IN(I)
							// H:Haulage(삭제됨), F:Free(?)
							if(!"D".equals(bkgBbCgoVOs[i].getDeTermCd()) && !"Y".equals(bkgBbCgoVOs[i].getDeTermCd()) 
									&& !"M".equals(bkgBbCgoVOs[i].getDeTermCd()) && !"S".equals(bkgBbCgoVOs[i].getDeTermCd()) 
									&& !"H".equals(bkgBbCgoVOs[i].getDeTermCd()) && !"T".equals(bkgBbCgoVOs[i].getDeTermCd()) 
									&& !"F".equals(bkgBbCgoVOs[i].getDeTermCd()) && !"I".equals(bkgBbCgoVOs[i].getDeTermCd()) 
									&& !"O".equals(bkgBbCgoVOs[i].getDeTermCd())){
								throw new EventException((String) new ErrorHandler("BKG00651", new String[] {"Delivery Term Code: "+ bkgBbCgoVOs[i].getDeTermCd()}).getMessage());							
							}
						}
						modifyVoList.add(bkgBbCgoVOs[i]);
						bkgBbCgoVOs[i].setCreUsrId(user_id);
						bkgBbCgoVOs[i].setUpdUsrId(user_id);						
						bkgBbCgoVOs[i].setUpdDt(upd_dt);						
					} else if ( bkgBbCgoVOs[i].getIbflag().equals("D")){						
						removeVoList.add(bkgBbCgoVOs[i]);										
					} 
				}				
				if(addVoList.size() > 0){
					if("ESM_BKG_0229".equals(uiId)){
						dbDao.addBkgBbCgoByXter(addVoList, caFlg);
					} else {
						dbDao.addBkgBbCgo(addVoList, caFlg);
					}
					dbDao.modifyDgBbSeq1(addVoList, caFlg);
					dbDao.modifyDgBbSeq2(addVoList, caFlg);					
				} 
				if(modifyVoList.size() > 0){
					if("ESM_BKG_0229".equals(uiId)){
						dbDao.modifyBkgBbCgoByXter(modifyVoList, caFlg);
					} else {
						dbDao.modifyBkgBbCgo(modifyVoList, caFlg);
					}
					dbDao.modifyDgBbSeq1(modifyVoList, caFlg);
					dbDao.modifyDgBbSeq2(modifyVoList, caFlg);					
				}
				if(removeVoList.size() > 0){
					dbDao.removeBkgBbCgo(removeVoList, caFlg);
					dbDao.modifyDgBbSeq1(modifyVoList, caFlg);										
				}				
			}
		} catch (EventException ex) {
		   throw ex;		  	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00010",new String[]{}).getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);     
		}
	}
	
	
	/**	 
	 * SpecialCargo 연동 처리 로직
	 * @param SpclCgoAproApplVO spclCgoAproApplVO 
	 * @return strResult
	 * @exception EventException
	 */
	public String manageSpclCgoApro(SpclCgoAproApplVO spclCgoAproApplVO) throws EventException{
		
		BookingUtil utilBC = new BookingUtil();		
		SpclReqInVO[] spclReqInVOs = spclCgoAproApplVO.getSpclReqInVOs();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();		
		String strResult = "";		  
//		String bdr_flg = "";		
		String slan_cd = "";	
		String rqstUsrId = spclCgoAproApplVO.getAccount().getUsr_id();
		
		try {				
			bkgBlNoVO.setBkgNo(spclCgoAproApplVO.getBkgNo());			
//			bdr_flg = utilBC.searchBdrFlgByBkg(bkgBlNoVO);			
			// searchBrdFlgByBkg	
			
//			log.debug("bdr_flg======="+bdr_flg);

//			if(!bdr_flg.equals("N")){				
//				strResult = "1"; //error code
//				
//			}else {				
			
			
				if (spclCgoAproApplVO.getSpclCgoTp().equals("D")) {
					slan_cd = dbDao.searchBkgVvdSlane(spclCgoAproApplVO.getBkgNo());					
					if (slan_cd.equals("EBX") || slan_cd.equals("SNA")) {
						strResult = "1"; //error code					
					}else {	
						log.debug("spclReqInVOs==============>"+spclReqInVOs);
						for(int i=0; i< spclReqInVOs.length; i++){	
							if(!spclReqInVOs[i].getAproCd().equals(""))
								utilBC.addBkgLog("SPCL_APRO", "bkg_no : " + spclCgoAproApplVO.getBkgNo(),
										  "manageSpclCgoApro ===>"
										  + " spclCgoTp : " + spclCgoAproApplVO.getSpclCgoTp()
										  + " aproCd : " + spclReqInVOs[i].getAproCd()
										  + " cgoSeq : " + spclReqInVOs[i].getCargoSeq()
										  + " rqstusrId :" + rqstUsrId);
//							log.error("bkg_no : " + spclCgoAproApplVO.getBkgNo()
//									  + " aproCd : " + spclCgoAproApplVO.getSpclCgoTp()
//									  + " aproCd : " + spclReqInVOs[i].getAproCd()
//									  + " time" + DateTime.getTimeStampString());
							if(!spclReqInVOs[i].getAproCd().equals("")){
								dbDao.modifyDgReq(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getDcgoSeq(), rqstUsrId);	
							}
						}
					}
				}else{					
					for(int i=0; i< spclReqInVOs.length; i++){		
						if(!spclReqInVOs[i].getAproCd().equals(""))
							utilBC.addBkgLog("SPCL_APRO", "bkg_no : " + spclCgoAproApplVO.getBkgNo(),
									  "manageSpclCgoApro ===>"
									  + " spclCgoTp : " + spclCgoAproApplVO.getSpclCgoTp()
									  + " aproCd : " + spclReqInVOs[i].getAproCd()
									  + " cgoSeq : " + spclReqInVOs[i].getCargoSeq()
									  + " rqstusrId :" + rqstUsrId);
//						log.error("bkg_no : " + spclCgoAproApplVO.getBkgNo()
//								  + " aproCd : " + spclCgoAproApplVO.getSpclCgoTp()
//								  + " aproCd : " + spclReqInVOs[i].getAproCd()
//								  + " time" + DateTime.getTimeStampString());
						
						if(spclCgoAproApplVO.getSpclCgoTp().equals("A") && !spclReqInVOs[i].getAproCd().equals("")){							
							dbDao.modifyAwkReq(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getAwkCgoSeq(), rqstUsrId);							
						}						
						if(spclCgoAproApplVO.getSpclCgoTp().equals("B") && !spclReqInVOs[i].getAproCd().equals("")){							
							dbDao.modifyBbReq(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getBbCgoSeq(), rqstUsrId);							
						}						
						if(spclCgoAproApplVO.getSpclCgoTp().equals("R") && !spclReqInVOs[i].getAproCd().equals("")){							
							dbDao.modifyRfReq(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getRcSeq(), rqstUsrId);
						}							
					}
//				}
			}			
			//return dbDao.searchSRouteFromList(spclReqInVO);
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);    
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);    
		}			
		return strResult;
	}
	
	/**
	 * 
	 *  SCG에 대한 연동 이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @param String aproCd
	 * @param String cgoSeq
	 * @param String spclCgoTp
	 * @param String rqstusrId
	 * @exception EventException
	 */
	public void modifyAproStatus(String bkgNo, String aproCd, String cgoSeq, String spclCgoTp, String rqstusrId) throws EventException {
			
		SpecialCargoRjEmlVO spcgoRjEmlVO = null;
		BookingUtil utilBC = new BookingUtil();
		try {			
			
			// 해당 Bkg에 대한 Reject 개수를 구함
			int rjCnt = dbDao.searchSpRejectCnt(bkgNo, spclCgoTp);

			utilBC.addBkgLog("SPCL_APRO", bkgNo,
					  "modifyAproStatus ===>"
					  + " spclCgoTp : " + spclCgoTp
					  + " aproCd : " + aproCd
					  + " cgoSeq : " + cgoSeq
					  + " rqstusrId :" + rqstusrId);
//			log.error("SCG APRO ====> bkg_no : " + bkgNo
//					  + " aproCd : " + aproCd
//					  + " cgoSeq : " + cgoSeq
//					  + " spclCgoTp : " + spclCgoTp
//					  + " rqstusrId :" + rqstusrId);
			
				if(spclCgoTp.equals("A")){				
					dbDao.modifyAwkReq(bkgNo, aproCd, cgoSeq, "");
				}			
				if(spclCgoTp.equals("B")){				
					dbDao.modifyBbReq(bkgNo, aproCd, cgoSeq, "");						
				}			
				if(spclCgoTp.equals("R")){				
					dbDao.modifyRfReq(bkgNo, aproCd, cgoSeq, "");
				}			
				if(spclCgoTp.equals("D")){				
					dbDao.modifyDgReq(bkgNo, aproCd, cgoSeq, "");
				}

			if(rjCnt == 0 && "N".equals(aproCd)){ //승인거절 시
				//email 발송용 data 조회
				log.debug("@@@@@@ SpecialCargoReceiptBCImpl : start sendSpRejectMail");
				spcgoRjEmlVO = dbDao.sendSpRejectMail(bkgNo,spclCgoTp);
				
				//email 발송
				log.debug("@@@@@@ SpecialCargoReceiptBCImpl : start sending mail");
				String sndId = eaiDao.sendRjEmail(spcgoRjEmlVO);
				log.debug("@@@@@@ SpecialCargoReceiptBCImpl : finish sending mail. sndId = "+sndId);
			}
			
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);     
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
	}  
	
	/**
	 * 
	 *  SpecialCargoReceipt화면에 대한 연동 이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @return ScgVvdAproRqstVO[] 
	 * @exception EventException
	 */
	public ScgVvdAproRqstVO[] searchBkgVvd(String bkgNo) throws EventException {		
		ScgVvdAproRqstVO[] scgVvdAproRqstVOs = null;
		List<BkgVvdVO> bkgVvdVOs = new ArrayList<BkgVvdVO>();
		
        try {                                 
        	bkgVvdVOs = dbDao.searchBkgVvd(bkgNo);        	
        	//scgVvdAproRqstVOs = new ScgVvdAproRqstVO[bkgVvdVOs.size()];   
        	//scgVvdAproRqstVOs = new ScgVvdAproRqstVO[1];  
        	
        	/*
        	int k = 0;
        	
        	for (int i=0; i < bkgVvdVOs.size(); i++) {        		
        		
        		if(!bkgVvdVOs.get(i).getVslPrePstCd().equals("S") && !bkgVvdVOs.get(i).getVslPrePstCd().equals("U")){
        			k++;
        		}
        		
        		
        		if(bkgVvdVOs.get(i).getVslPrePstCd().equals("S")){        			
        			throw new EventException(new ErrorHandler("BKG08106", new String[] {}).getMessage());
        		}       
        		 		
        	}        	
        	*/
        	
        	log.debug("12345====="+bkgVvdVOs);
        	log.debug("bkgVvdVOs.size()====="+bkgVvdVOs.size());
        	
        	if(bkgVvdVOs.size() < 1){
        		
        		throw new EventException(new ErrorHandler("BKG08122", new String[] {}).getMessage());
        	}
        	
//        	Query 에서 처리함
//        	for (int i=0; i < bkgVvdVOs.size(); i++) {        		        		
//        		
//        		if(bkgVvdVOs.get(i).getVslCd().equals("")){        			
//        			throw new EventException(new ErrorHandler("BKG08106", new String[] {}).getMessage());
//        		}       
//        		 		
//        	}   
        		
        	if(bkgVvdVOs.size() > 0){
        		
	        	scgVvdAproRqstVOs = new ScgVvdAproRqstVO[bkgVvdVOs.size()];  
	        	
	        	int j = 0;
	        	
	        	for (int i=0; i < bkgVvdVOs.size(); i++) {  	        		
	        			
	        		scgVvdAproRqstVOs[j] = new ScgVvdAproRqstVO();
	        		scgVvdAproRqstVOs[j].setIbflag("I");
	        		scgVvdAproRqstVOs[j].setBkgNo(bkgVvdVOs.get(i).getBkgNo());
	        		scgVvdAproRqstVOs[j].setVslPrePstCd(bkgVvdVOs.get(i).getVslPrePstCd());
	        		scgVvdAproRqstVOs[j].setVslSeq(bkgVvdVOs.get(i).getVslSeq());
	        		scgVvdAproRqstVOs[j].setVslCd(bkgVvdVOs.get(i).getVslCd());
	        		scgVvdAproRqstVOs[j].setSkdVoyNo(bkgVvdVOs.get(i).getSkdVoyNo());
	        		scgVvdAproRqstVOs[j].setSkdDirCd(bkgVvdVOs.get(i).getSkdDirCd());
	        		scgVvdAproRqstVOs[j].setPolCd(bkgVvdVOs.get(i).getPolCd());
	        		scgVvdAproRqstVOs[j].setPolClptIndSeq(bkgVvdVOs.get(i).getPolClptIndSeq());
	        		scgVvdAproRqstVOs[j].setPodCd(bkgVvdVOs.get(i).getPodCd());
	        		scgVvdAproRqstVOs[j].setPodClptIndSeq(bkgVvdVOs.get(i).getPodClptIndSeq());
	        		scgVvdAproRqstVOs[j].setCreUsrId(bkgVvdVOs.get(i).getCreUsrId());
	        		scgVvdAproRqstVOs[j].setCreDt(bkgVvdVOs.get(i).getCreDt());
	        		scgVvdAproRqstVOs[j].setUpdUsrId(bkgVvdVOs.get(i).getUpdUsrId());
	        		scgVvdAproRqstVOs[j].setUpdDt(bkgVvdVOs.get(i).getUpdDt());        		
	        		scgVvdAproRqstVOs[j].setPolYdCd(bkgVvdVOs.get(i).getPolYdCd());
	        		scgVvdAproRqstVOs[j].setPodYdCd(bkgVvdVOs.get(i).getPodYdCd());
	        		scgVvdAproRqstVOs[j].setSlanCd(bkgVvdVOs.get(i).getSlanCd());
	        		j++;
	        	
	        	}    
        	}
        } catch(DAOException ex) {
        	
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);    
        } catch(Exception ex) {        	
        	throw new EventException(ex.getMessage(), ex);
        }
        return scgVvdAproRqstVOs;
    }

	/**
	 * 조회 이벤트 처리<br>
	 * T/S 화면에서 vvd 재지정시 Special cargo 재 request를 위한 vvd 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @param List<String> paramVvds
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */
	public ScgVvdAproRqstVO[] searchBkgVvdTs(String bkgNo, List<String> paramVvds) throws EventException {		
		ScgVvdAproRqstVO[] scgVvdAproRqstVOs = null;
		List<BkgVvdVO> bkgVvdVOs = new ArrayList<BkgVvdVO>();
		
        try {                                 
        	bkgVvdVOs = dbDao.searchBkgVvdTs(bkgNo, paramVvds);
        	
        	if(bkgVvdVOs.size() < 1){    
	        	scgVvdAproRqstVOs = new ScgVvdAproRqstVO[0];
	        	return scgVvdAproRqstVOs;
        	}
        	
        	if(bkgVvdVOs.size() > 0){        		
	        	scgVvdAproRqstVOs = new ScgVvdAproRqstVO[bkgVvdVOs.size()];
	        	
	        	int j = 0;
	        	for (int i=0; i < bkgVvdVOs.size(); i++) {
	        		scgVvdAproRqstVOs[j] = new ScgVvdAproRqstVO();
	        		scgVvdAproRqstVOs[j].setIbflag("I");
	        		scgVvdAproRqstVOs[j].setBkgNo(bkgVvdVOs.get(i).getBkgNo());
	        		scgVvdAproRqstVOs[j].setVslPrePstCd(bkgVvdVOs.get(i).getVslPrePstCd());
	        		scgVvdAproRqstVOs[j].setVslSeq(bkgVvdVOs.get(i).getVslSeq());
	        		scgVvdAproRqstVOs[j].setVslCd(bkgVvdVOs.get(i).getVslCd());
	        		scgVvdAproRqstVOs[j].setSkdVoyNo(bkgVvdVOs.get(i).getSkdVoyNo());
	        		scgVvdAproRqstVOs[j].setSkdDirCd(bkgVvdVOs.get(i).getSkdDirCd());
	        		scgVvdAproRqstVOs[j].setPolCd(bkgVvdVOs.get(i).getPolCd());
	        		scgVvdAproRqstVOs[j].setPolClptIndSeq(bkgVvdVOs.get(i).getPolClptIndSeq());
	        		scgVvdAproRqstVOs[j].setPodCd(bkgVvdVOs.get(i).getPodCd());
	        		scgVvdAproRqstVOs[j].setPodClptIndSeq(bkgVvdVOs.get(i).getPodClptIndSeq());
	        		scgVvdAproRqstVOs[j].setCreUsrId(bkgVvdVOs.get(i).getCreUsrId());
	        		scgVvdAproRqstVOs[j].setCreDt(bkgVvdVOs.get(i).getCreDt());
	        		scgVvdAproRqstVOs[j].setUpdUsrId(bkgVvdVOs.get(i).getUpdUsrId());
	        		scgVvdAproRqstVOs[j].setUpdDt(bkgVvdVOs.get(i).getUpdDt());        		
	        		scgVvdAproRqstVOs[j].setPolYdCd(bkgVvdVOs.get(i).getPolYdCd());
	        		scgVvdAproRqstVOs[j].setPodYdCd(bkgVvdVOs.get(i).getPodYdCd());
	        		scgVvdAproRqstVOs[j].setSlanCd(bkgVvdVOs.get(i).getSlanCd());
	        		j++;	        	
	        	}    
        	}
        } catch(DAOException ex) {        	
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);    
        } catch(Exception ex) {        	
        	throw new EventException(ex.getMessage(), ex);
        }
        return scgVvdAproRqstVOs;
    }	
	/**
	 * 조회 이벤트 처리<br>
	 * C/A 화면에서 vvd 재지정시 Special cargo 재 request를 위한 vvd 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */	
	public ScgVvdAproRqstVO[] searchBkgVvdCa(String bkgNo) throws EventException{
		ScgVvdAproRqstVO[] scgVvdAproRqstVOs = null;
		List<BkgVvdVO> bkgVvdVOs = new ArrayList<BkgVvdVO>();
		
        try {                                 
        	bkgVvdVOs = dbDao.searchBkgVvdCa(bkgNo);        
        	
        	if(bkgVvdVOs.size() < 1){    
	        	scgVvdAproRqstVOs = new ScgVvdAproRqstVO[0];
	        	return scgVvdAproRqstVOs;
        	}
        	
        	if(bkgVvdVOs.size() > 0){        		
	        	scgVvdAproRqstVOs = new ScgVvdAproRqstVO[bkgVvdVOs.size()];
	        	
	        	int j = 0;
	        	for (int i=0; i < bkgVvdVOs.size(); i++) {
	        		scgVvdAproRqstVOs[j] = new ScgVvdAproRqstVO();
	        		scgVvdAproRqstVOs[j].setIbflag("I");
	        		scgVvdAproRqstVOs[j].setBkgNo(bkgVvdVOs.get(i).getBkgNo());
	        		scgVvdAproRqstVOs[j].setVslPrePstCd(bkgVvdVOs.get(i).getVslPrePstCd());
	        		scgVvdAproRqstVOs[j].setVslSeq(bkgVvdVOs.get(i).getVslSeq());
	        		scgVvdAproRqstVOs[j].setVslCd(bkgVvdVOs.get(i).getVslCd());
	        		scgVvdAproRqstVOs[j].setSkdVoyNo(bkgVvdVOs.get(i).getSkdVoyNo());
	        		scgVvdAproRqstVOs[j].setSkdDirCd(bkgVvdVOs.get(i).getSkdDirCd());
	        		scgVvdAproRqstVOs[j].setPolCd(bkgVvdVOs.get(i).getPolCd());
	        		scgVvdAproRqstVOs[j].setPolClptIndSeq(bkgVvdVOs.get(i).getPolClptIndSeq());
	        		scgVvdAproRqstVOs[j].setPodCd(bkgVvdVOs.get(i).getPodCd());
	        		scgVvdAproRqstVOs[j].setPodClptIndSeq(bkgVvdVOs.get(i).getPodClptIndSeq());
	        		scgVvdAproRqstVOs[j].setCreUsrId(bkgVvdVOs.get(i).getCreUsrId());
	        		scgVvdAproRqstVOs[j].setCreDt(bkgVvdVOs.get(i).getCreDt());
	        		scgVvdAproRqstVOs[j].setUpdUsrId(bkgVvdVOs.get(i).getUpdUsrId());
	        		scgVvdAproRqstVOs[j].setUpdDt(bkgVvdVOs.get(i).getUpdDt());        		
	        		scgVvdAproRqstVOs[j].setPolYdCd(bkgVvdVOs.get(i).getPolYdCd());
	        		scgVvdAproRqstVOs[j].setPodYdCd(bkgVvdVOs.get(i).getPodYdCd());
	        		scgVvdAproRqstVOs[j].setSlanCd(bkgVvdVOs.get(i).getSlanCd());
	        		j++;	        	
	        	}    
        	}
        } catch(DAOException ex) {        	
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);    
        } catch(Exception ex) {        	
        	throw new EventException(ex.getMessage(), ex);
        }
        return scgVvdAproRqstVOs;
	}
	/**
	 * SpecialCargo imdgPckCd, imdgPckTpCd로 정보 조회.(ESM_BKG_0206)
	 *	 
	 * @param 	String imdgPckCd
	 * @param 	String imdgPckTpCd
	 * @return  ImdgPckDescVO
	 * @exception EventException
	 */
	public ImdgPckDescVO searchImdgPckDesc(String imdgPckCd, String imdgPckTpCd) throws EventException {
		try {
			return dbDao.searchImdgPckDesc(imdgPckCd, imdgPckTpCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		}
	}
	
	
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
	public void copySpclCgoByBkg(String copyModeCd,BkgBlNoVO sourceBkg,BkgBlNoVO[] targetBkg,List<SelectSpclCgoVO> selectSpclCgoVO,SignOnUserAccount account) throws EventException{
		try {
			if(copyModeCd.equals("M")){ // Combine일때
				if ( targetBkg != null ) {
	            	// Split과 같이 메소드를 사용하므로 Combine시에는 targetBkg가 sourceBkg이고
	            	// sourceBkg가 targetbkg의 역할을 함.
					for(int i=0;i<targetBkg.length;i++){
						dbDao.copyDgCgoByBkg(targetBkg[i], sourceBkg, copyModeCd, account);
						dbDao.copyRfCgoByBkg(targetBkg[i], sourceBkg, copyModeCd, account);
						dbDao.copyAkCgoByBkg(targetBkg[i], sourceBkg, copyModeCd, account);
						dbDao.copyAkDimByBkg(targetBkg[i], sourceBkg, copyModeCd, account);
						dbDao.copyBBCgoByBkg(targetBkg[i], sourceBkg, copyModeCd, account);
					}
				}
				// 원본 bkg의 spcl cargo의 cntr volume을 matching되는 container의 volumn과 같게 update한다.
				dbDao.modifyBkgDgCgoVol(sourceBkg, account);
				dbDao.modifyBkgRfCgoVol(sourceBkg, account);
				dbDao.modifyBkgAwkCgoVol(sourceBkg, account);
			} else if(copyModeCd.equals("S")){
				for(int i=0;i<targetBkg.length;i++){
					log.debug("진행중인 bkg:"+targetBkg[i].getBkgNo());			
					if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){	
						for(int icnt=0;icnt<selectSpclCgoVO.size();icnt++){
							log.debug("처리대상 bkg:["+selectSpclCgoVO.get(icnt).getBkg_no()+"] check 여부 :[" + (selectSpclCgoVO.get(icnt).getSplitNo().length()>0 ? "Y":"N") +"]");
							log.debug("select Cntr:["+selectSpclCgoVO.get(icnt).getCntrNo()+"] SpclCagoSeq:[" + selectSpclCgoVO.get(icnt).getSpclCagoSeq()+"]");
							if(selectSpclCgoVO.get(icnt).getBkg_no().equals(targetBkg[i].getBkgNo())
								&& selectSpclCgoVO.get(icnt).getSplitNo().length()>0){
								if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("D")){ //DG Copy
									dbDao.copyDgCgoBySplit(sourceBkg, targetBkg[i], selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq(), account);
								}else if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("R")){ //RF Copy
									dbDao.copyRfCgoBySplit(sourceBkg, targetBkg[i], selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq(), account);
								}else if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("A")){ //AK Copy
									dbDao.copyAkCgoBySplit(sourceBkg, targetBkg[i], selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq(), account);
									dbDao.copyAkDimBySplit(sourceBkg, targetBkg[i], selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq(), account);
								}else if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("B")){ //BB Copy
									dbDao.copyBbCgoBySplit(sourceBkg, targetBkg[i], selectSpclCgoVO.get(icnt).getSpclCagoSeq(), account);
								}	
							}
						}
					}
				}
				for(int icnt=0;icnt<selectSpclCgoVO.size();icnt++){
					if (selectSpclCgoVO.get(icnt).getSplitreason().equals("C")){
						//원본bkg에 변경이 있을시
						if(sourceBkg.getBkgNo().equals(selectSpclCgoVO.get(icnt).getBkg_no())
							&& selectSpclCgoVO.get(icnt).getSplitNo().length()<1){ 
							if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("D")){
								dbDao.removeBkgDgCgo(sourceBkg, selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq());
							}else if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("R")){
								dbDao.removeBkgRfCgo(sourceBkg, selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq());
							}else if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("A")){
								dbDao.removeBkgAwkDim(sourceBkg, selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq());
								dbDao.removeBkgAwkCgo(sourceBkg, selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq());
							}else if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("B")){
								dbDao.removeBkgBbCgo(sourceBkg, selectSpclCgoVO.get(icnt).getSpclCagoSeq());
							}
						}
					}
				}
				
				// 원본 bkg의 spcl cargo의 cntr volume을 matching되는 container의 volumn과 같게 update한다.
				dbDao.modifyBkgDgCgoVol(sourceBkg, account);
				dbDao.modifyBkgRfCgoVol(sourceBkg, account);
				dbDao.modifyBkgAwkCgoVol(sourceBkg, account);
			} else if(copyModeCd.equals("C")){			
				// 20090914 김병규 추가
				for(int i = 0; i < selectSpclCgoVO.size() ; i++){
					if("D".equals(selectSpclCgoVO.get(i).getSpclCagoFlag())){
						dbDao.copyDgCgoByBkg(sourceBkg, targetBkg[0], copyModeCd, account);
					}else if("R".equals(selectSpclCgoVO.get(i).getSpclCagoFlag())){
						dbDao.copyRfCgoByBkg(sourceBkg, targetBkg[0], copyModeCd, account);
					}else if("A".equals(selectSpclCgoVO.get(i).getSpclCagoFlag())){
						dbDao.copyAkCgoByBkg(sourceBkg, targetBkg[0], copyModeCd, account);
					}else if("B".equals(selectSpclCgoVO.get(i).getSpclCagoFlag())){
						dbDao.copyBBCgoByBkg(sourceBkg, targetBkg[0], copyModeCd, account);
					}
				}				
			}
            
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

    /**
     * 컨테이너 Copy/Move 시 Special Cargo 복사를 위한 함수.
     * 
     * @param CntrCopyVO cntrCopyVO
     * @author 김영출
     */
    public void copySpclCgoByCntr(CntrCopyVO cntrCopyVO) throws EventException {
        //
        try {
            dbDao.copyAkCgoByCntr(cntrCopyVO);
            dbDao.copyAkDimByCntr(cntrCopyVO);
            dbDao.copyDgCgoByCntr(cntrCopyVO);
            dbDao.copyRfCgoByCntr(cntrCopyVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
    }
    
    /**
     * @param String bkgNo
     * @param String cntrNo
     * @param String seq
     */
    public void removeSpclCgoByCntr(String bkgNo, String cntrNo, String seq) throws EventException{
        //
        try {
            dbDao.removeAwkDimByCntr(bkgNo, cntrNo, seq);
            dbDao.removeAwkCgoByCntr(bkgNo, cntrNo, seq);
            dbDao.removeDgCgoByCntr(bkgNo, cntrNo, seq);
            dbDao.removeRfCgoByCntr(bkgNo, cntrNo, seq);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
    }
    
	/**
	 * C/A를 위해 special cargo 관련 table을 복사한다.
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void createSpclCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			if ("BKG".equals(copyTypeCd)) {
				//01. 
				dbDao.removeDgCA   (bkgBlNoVO, copyTypeCd);
				//02. 
				dbDao.removeRfCA   (bkgBlNoVO, copyTypeCd);
				//03. 
				dbDao.removeAkDimCA(bkgBlNoVO, copyTypeCd);
				//04.  
				dbDao.removeAkCA   (bkgBlNoVO, copyTypeCd);
				//05. 
				dbDao.removeBbCA   (bkgBlNoVO, copyTypeCd);
			}

			//01. 
			dbDao.createDgCA   (bkgBlNoVO, copyTypeCd);
			//02. 
			dbDao.createRfCA   (bkgBlNoVO, copyTypeCd);
			//03. 
			dbDao.createAkCA   (bkgBlNoVO, copyTypeCd);
			//04. 			
			dbDao.createAkDimCA(bkgBlNoVO, copyTypeCd);
			//05. 
			dbDao.createBbCA   (bkgBlNoVO, copyTypeCd);
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
	}    
	
	/**
	 * C/A를 위해 special cargo 관련 table을 삭제한다.
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param		String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			//01. 
			dbDao.removeAkDimCA(bkgBlNoVO, copyTypeCd);				
			//02. 
			dbDao.removeAkCA   (bkgBlNoVO, copyTypeCd);				
			//03. 
			dbDao.removeBbCA   (bkgBlNoVO, copyTypeCd);
			//04.  
			dbDao.removeRfCA   (bkgBlNoVO, copyTypeCd);
			//05. 
			dbDao.removeDgCA   (bkgBlNoVO, copyTypeCd);
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
	}  

	/**
	 * Special Cargo의 RD Term을 수정한다.
	 * 
	 * @author 		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @param  		String rcvTermCd
	 * @param  		String deTermCd
	 * @param       	SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifySpclRDTerm(BkgBlNoVO bkgBlNoVO, String rcvTermCd , String deTermCd , SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyAwkRDTerm(bkgBlNoVO, rcvTermCd, deTermCd, account);
			dbDao.modifyBbRDTerm(bkgBlNoVO, rcvTermCd, deTermCd, account);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
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
	public void modifyDgSpclRqstByVvdChange(BkgBlNoVO bkgBlNoVO, String spclRqstDesc, String dcgoSeq, SignOnUserAccount account) throws EventException{
		try {
			dbDao.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, dcgoSeq, account);	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * SAVE 전에 GRS_MAX_WGT를 체크한다. (ESM_BKG_0055)
	 * 
	 * @author 		Jay Lee
	 * @param  		String bkgNo
	 * @param		String cntrNo
	 * @param		String grsWgt
	 * @param		String cntrTpszCd
	 * @param     String wgtUtCd
 	 * @return  	EventResponse
	 * @exception 	EventException
	 */
	public EventResponse searchGrsMaxWgt(String bkgNo, String cntrNo, String grsWgt, String cntrTpszCd, String wgtUtCd) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		String wgtResult[] = null;
		String wgtInfoFlg = null;
		String cntrTpSzInfoFlg = null;
		String cntrTpSzWgt = null;
		try{
			wgtResult = dbDao.searchGrsMaxWgt(bkgNo,cntrNo,grsWgt,cntrTpszCd, wgtUtCd);
			if(wgtResult != null){
				wgtInfoFlg = wgtResult[0];
				cntrTpSzInfoFlg = wgtResult[1];
				cntrTpSzWgt = wgtResult[2];
				
				eventResponse.setETCData("wgt_pass", wgtInfoFlg);				
				eventResponse.setETCData("cntr_tp_sz_pass", cntrTpSzInfoFlg);
				eventResponse.setETCData("cntr_tp_sz_wgt", cntrTpSzWgt);
			}
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
        return eventResponse;
	}
	
	/**
	 * 유사한 화학적 특성을 갖는 위험물 격리군(Segregation Groups) (ESM_BKG_0200 ComboList) 조회.<br>
	 * 
	 * @return List<SegrGrpVO>
	 * @throws EventException
	 */
	public List<SegrGrpVO> searchSegrGrp() throws EventException {
		List<SegrGrpVO> segrGrpOutVO = new ArrayList<SegrGrpVO>();
		try{
			segrGrpOutVO = dbDao.searchSegrGrp();
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
        return segrGrpOutVO;
	}
	
	/**
	 * IMDG UN NUMBER의 SPECIAL PROVISION No (ESM_BKG_0200) 조회.<br>
	 * 
	 * @param unNo
	 * @param unNoSeq
	 * @return String
	 * @throws EventException
	 */
	public String searchSpclProviNo(String unNo, String unNoSeq) throws EventException {
		String spclProviNo = "";
		try{
			spclProviNo = dbDao.searchSpclProviNo(unNo, unNoSeq);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
        return spclProviNo;
	}

	/**
	 * DG CARGO의 UN No에 해당하는 Stowage Code를 조회한다 <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchImdgUnNoStwgCateCd(BkgBlNoVO bkgBlNoVO) throws EventException{
		String imdgUnNoStwgCateCd = "";
		try{
			imdgUnNoStwgCateCd = dbDao.searchImdgUnNoStwgCateCd(bkgBlNoVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
        return imdgUnNoStwgCateCd;
	}

	/**
	 *  Booking에 해당하는 CLL VVD를 조회한다<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchCLLVVD(String bkgNo) throws EventException {
		
		String cllVvd = "";
		
        try {                                 
        	cllVvd = dbDao.searchCLLVVD(bkgNo);              
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);         
        }
        return cllVvd;
    }
	
	/**
	 * Special Cargo에 대한 Validation Check
	 * @param cgoType
	 * @param bkgNo
	 * @return
	 * @throws EventException
	 */
	public String validateSpCgo(String cgoType, String bkgNo) throws EventException {
		String validMsg = "";
		
		// Dangerous Cargo
		if("D".equals(cgoType)){
			
			try{
				// UN No에 해당되는 SUB Label이 설정되지 않거나, 맞지 않은 값이 설정되었는지 여부를 체크한다.
				validMsg = dbDao.validateDGSubLabelByUNNo(bkgNo);
	        } catch(DAOException ex) {
	        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
	        } catch(Exception ex) {
	        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);         
	        }
		}
		
		
		return validMsg;
	}
}