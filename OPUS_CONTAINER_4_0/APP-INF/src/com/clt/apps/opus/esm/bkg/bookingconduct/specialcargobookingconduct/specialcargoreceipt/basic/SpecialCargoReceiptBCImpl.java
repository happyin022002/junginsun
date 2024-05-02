/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoReceiptBCImpl.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate :  
*@LastModifier : 
*@LastVersion : 1.0

* ------------------------------------------------------*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectSpclCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration.SpecialCargoReceiptDBDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkDimVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgDgCgoInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgDgDeclVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgVvdVO;
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
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.StwgAproInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.StwgCgoApplVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo.ScgVvdDgCgoCxlRqstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgStwgCgoVO;
import com.clt.syscommon.common.table.MdmPckTpVO;
import com.clt.syscommon.common.table.ScgVvdAproRqstVO;

/**
 * OPUS-SpecialCargoBookingConduct Business Logic Basic Command implementation<br>
 * handling logic transaction - OPUS-SpecialCargoBookingConduct.<br>
 *
 * @author Lee Byung Kyu
 * @see ESM_BKG_0055EventResponse,SpecialCargoReceiptBC 
 * @since J2EE 1.6 
 */
public class SpecialCargoReceiptBCImpl extends BasicCommandSupport implements SpecialCargoReceiptBC {

	// Database Access Object
	private transient SpecialCargoReceiptDBDAO dbDao = null;

	/**
	 * SpecialCargoReceiptBCImpl <br>
	 * SpecialCargoReceiptDBDAO<br>
	 */
	public SpecialCargoReceiptBCImpl() {
		dbDao = new SpecialCargoReceiptDBDAO();
	}
	/**
	 * handling of searching event<br>
	 *  SpecialCargoReceipt<br>
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
	 * handling of searching event<br>
	 *  SpecialCargoReceipt<br>
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
	 * handling of searching event<br>
	 *  SpecialCargoReceipt<br>
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
	 * ESM_BKG_0055 saving logic
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
		String spclTp = "AWK";		
		int cnt = 0;
		
		try {
			List<BkgAwkCgoVO> addVoList = new ArrayList<BkgAwkCgoVO>();
			List<BkgAwkCgoVO> modifyVoList = new ArrayList<BkgAwkCgoVO>();
			List<BkgAwkCgoVO> removeVoList = new ArrayList<BkgAwkCgoVO>();			
			List<BkgAwkDimVO> addVoList1 = new ArrayList<BkgAwkDimVO>();			
			List<BkgAwkDimVO> removeVoList1 = new ArrayList<BkgAwkDimVO>();	
			
			if(!"ESM_BKG_0229".equals(uiId)){
				dbDao.searchAwkApproval(bkgNo, caFlg);
	        	dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg);
			} else {
				
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
//							if(utilCmd.searchPkgType(pkgCd).getPckCd() == null || utilCmd.searchPkgType(pkgCd).getPckCd().equals("")){								
							if(utilCmd.searchPkgType(pkgCd) == null || utilCmd.searchPkgType(pkgCd).getPckCd().equals("")){
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
						// do not update about requesting, approving, rejecting at eBKG
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
					// AWK_DIM Insert
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
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	
	/**
	 * handling of searching event<br>
	 *  SpecialCargoReceipt(ESM_BKG_0200)<br>
	 * 
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caFlg
	 * @return DgCgoApplVO 
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgCargo(String bkgNo, String blNo, String caFlg) throws EventException {

		DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();
		String spclTp = "DG";
        try {
                dgCgoApplVO.setBkgDgCgoInfo(dbDao.searchDgCgoList(bkgNo, caFlg));	//sheetObejects[1]
                dgCgoApplVO.setDgCgoList(dbDao.searchDgList(bkgNo, caFlg));			//sheetObejects[3]
                dgCgoApplVO.setDgBkgInfo(dbDao.searchDgBkgInfo(bkgNo, caFlg));		//sheetObejects[2]
                dgCgoApplVO.setDgAproInfo(dbDao.searchDgApproval(bkgNo, caFlg));
                dgCgoApplVO.setCntrTypzQty(dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg));  //sheetObejects[0]              
                dgCgoApplVO.setCntrCombo(dbDao.searchCntrList(bkgNo, spclTp, caFlg));	//sheetObejects[4]
                dgCgoApplVO.setCntrInfoList(dbDao.searchCntrInfoList(bkgNo, caFlg));                
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        return dgCgoApplVO;
    }
	
	/**
	 * handling of searching event<br>
	 *  SpecialCargoReceipt(ESM_BKG_1045)<br>
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
	 * handling of searching event<br>
	 *  SpecialCargoReceipt<br>
	 * 
	 * @param ScgImdgUnNoVO scgImdgUnNoVO
	 * @return DgCgoApplVO 
	 * @exception EventException
	 */
	public DgCgoApplVO searchDgUnNumber(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException {

		DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();
		
        try {                                
        	dgCgoApplVO.setScgImdgUnNo(dbDao.searchDgUnNumber(scgImdgUnNoVO));                
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        return dgCgoApplVO;
    }
	
	/**
	 * handling of searching event<br>
	 *  SpecialCargoReceipt<br> 
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
	 * ESM_BKG_0200  handling saving
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
		String ofc_cd   = account.getOfc_cd();
		String bkgNo = dgCgoApplVO.getBkgNo();
		String spclTp = "DG";	
		String uiId = dgCgoApplVO.getUiId();	
		String dgCntSeqOriginalOld = "";
		int cnt = 0;
		
		try {
			List<DgCgoListVO> addVoList = new ArrayList<DgCgoListVO>();
			List<DgCgoListVO> modifyVoList = new ArrayList<DgCgoListVO>();
			List<DgCgoListVO> removeVoList = new ArrayList<DgCgoListVO>();			
			List<DgCgoListVO> dgDeclList = new ArrayList<DgCgoListVO>();
			dbDao.searchDgApproval(bkgNo, caFlg);
        	dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg);
			
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
						
						// The D/G shipment should be limited in SHA EXPO
						//  registering message ATTR_CTNT6  : managing time and message 
						
						if( 1 == 1 ){	
							
							String imdgUnNo = dgCgoListVOs[i].getImdgUnNo();
							String imdgClssCd = dgCgoListVOs[i].getImdgClssCd();
							String seq =  dgCgoListVOs[i].getDcgoSeq();
							log.debug("\n###################### getImdgUnNo" + imdgUnNo);
							log.debug("\n###################### seq" + seq);
							log.debug("\n###################### bkgNo" + bkgNo);
							
							String msg = dbDao.searchChnProhibit(bkgNo, seq, imdgUnNo, imdgClssCd);
							
							if(dbDao.searchChnProhibit(bkgNo, seq, imdgUnNo, imdgClssCd).length() > 0){
								throw new EventException(new ErrorHandler(msg, new String[]{}).getMessage());
							}
						}
						addVoList.add(dgCgoListVOs[i]);
						dgCgoListVOs[i].setCreUsrId(user_id);
						dgCgoListVOs[i].setUpdUsrId(user_id);
						dgCgoListVOs[i].setUpdDt(upd_dt);		
						dgCgoListVOs[i].setOfcCd(ofc_cd);										
					} else if ( dgCgoListVOs[i].getIbflag().equals("U")){		
						// Prohibiting to update about requesting, approving, rejecting in eBKG
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
						// The D/G shipment should be limited in SHA EXPO
						//  registering message ATTR_CTNT6  : managing time and message 
						if( 1 == 1 ){	
							
							String imdgUnNo = dgCgoListVOs[i].getImdgUnNo();
							String imdgClssCd = dgCgoListVOs[i].getImdgClssCd();
							String seq =  dgCgoListVOs[i].getDcgoSeq();
							log.debug("\n###################### getImdgUnNo" + imdgUnNo);
							log.debug("\n###################### seq" + seq);
							log.debug("\n###################### bkgNo" + bkgNo);
							
							String msg = dbDao.searchChnProhibit(bkgNo, seq, imdgUnNo, imdgClssCd);
							
							if(dbDao.searchChnProhibit(bkgNo, seq, imdgUnNo, imdgClssCd).length() > 0){
								throw new EventException(new ErrorHandler(msg, new String[]{}).getMessage());
							}
						}
						modifyVoList.add(dgCgoListVOs[i]);
						dgCgoListVOs[i].setCreUsrId(user_id);
						dgCgoListVOs[i].setUpdUsrId(user_id);						
						dgCgoListVOs[i].setUpdDt(upd_dt);
						if(dgCgoListVOs[i].getDgCntrSeqOriginal()!=null){ // ESM_BKG_0229 is out of target.
							if(!dgCgoListVOs[i].getDgCntrSeqOriginal().equals(dgCntSeqOriginalOld)){ // Declarant data is per container. No need to execute multiple process on 1 container.
								dgDeclList.add(dgCgoListVOs[i]);
								dgCntSeqOriginalOld = dgCgoListVOs[i].getDgCntrSeqOriginal();
							}							
						}
					} else if ( dgCgoListVOs[i].getIbflag().equals("D")){						
						removeVoList.add(dgCgoListVOs[i]);							
						if(dgCgoListVOs[i].getDgCntrSeqOriginal()!=null){ 
							if(!dgCgoListVOs[i].getDgCntrSeqOriginal().equals(dgCntSeqOriginalOld)){
								dgDeclList.add(dgCgoListVOs[i]);						
								dgCntSeqOriginalOld = dgCgoListVOs[i].getDgCntrSeqOriginal();
							}
						}
					} 
				}				
				if(addVoList.size() > 0){
					log.debug(">>>>>>>>>>>>addList<<<<<<<<<<<<<<<");
					
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
					log.debug(">>>>>>>>>>>>modifyList<<<<<<<<<<<<<<<");
					if("ESM_BKG_0229".equals(uiId)){
						for(int dgIdx = 0;dgIdx < modifyVoList.size();dgIdx++){
							modifyVoList.get(dgIdx).setBkgNo(bkgNo);
						}
						dbDao.modifyDgCgoListByXter(modifyVoList, caFlg);						
					} else {
						dbDao.modifyDgCgoList(modifyVoList, uiId, caFlg);
						//Declarant의 container no를 수정한다.
						//Update BKG_DG_DECL based on dg_cntr_seq_original because system changes dg_cntr_seq
//						dbDao.modifyDeclCntr(modifyVoList);
						if(dgDeclList.size()>0){
							dbDao.modifyDeclCntr(dgDeclList);	
						}						
					}
				}
				if(removeVoList.size() > 0){
					log.debug(">>>>>>>>>>>>removeList<<<<<<<<<<<<<<<");
					dbDao.removeDgCgoList(removeVoList, caFlg);
					//Declarant를 삭제한다.
					//Delete from BKG_DG_DECL which does not match with BKG_DG_CGO
					if(dgDeclList.size()>0){
						dbDao.removeDecl(removeVoList);
					}
				}				
			}				
		} catch (EventException ee) {   
			throw ee;		
		} catch (DAOException de) {			
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
		} catch (Exception ex) {			
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	
	/**
	 * handling event to search<br>
	 *  SpecialCargoReceipt<br>
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
	 * ESM_BKG_0498 handling event to save
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
		String spclTp = "RF";		
		int cnt = 0;
		
		try {
			List<BkgRfCgoVO> addVoList = new ArrayList<BkgRfCgoVO>();
			List<BkgRfCgoVO> modifyVoList = new ArrayList<BkgRfCgoVO>();
			List<BkgRfCgoVO> removeVoList = new ArrayList<BkgRfCgoVO>();									
			dbDao.searchRfApproval(bkgNo, caFlg);
			dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg);      	
       	
			if(bkgRfCgoVOs != null){
				for ( int i=0; i<bkgRfCgoVOs.length; i++ ) {
					
					if(bkgRfCgoVOs[i]!= null && bkgRfCgoVOs[i].getPwrSplCblFlg().equals("1")){
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
						addVoList.add(bkgRfCgoVOs[i]);
						bkgRfCgoVOs[i].setCreUsrId(user_id);
						bkgRfCgoVOs[i].setUpdUsrId(user_id);
						bkgRfCgoVOs[i].setUpdDt(upd_dt);						
					} else if ( bkgRfCgoVOs[i].getIbflag().equals("U")){
						//Prohibiting to update about requesting, approving, rejecting in eBKG
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
					}
					dbDao.modifyDgRfSeq1(modifyVoList, caFlg);
					dbDao.modifyDgRfSeq2(modifyVoList, caFlg);					
				}
				if(removeVoList.size() > 0){
					dbDao.removeBkgRfCgo(removeVoList, caFlg);
					dbDao.modifyDgRfSeq1(modifyVoList, caFlg);										
				}				
			}
		} catch (EventException ee) {   
			throw ee;	
		} catch (DAOException de) {			
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
		} catch (Exception ex) {			
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	
	/**
	 * handling event to search<br>
	 *  SpecialCargoReceipt  handling event to search<br>
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
	 * ESM_BKG_0106  handling event to save
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
		//String ovrVoidSltQty = bbCgoApplVO.getOvrVoidSltQty();;		
		String spclTp = "BB";		
		int cnt = 0;
		
		try {
			List<BkgBbCgoVO> addVoList = new ArrayList<BkgBbCgoVO>();
			List<BkgBbCgoVO> modifyVoList = new ArrayList<BkgBbCgoVO>();
			List<BkgBbCgoVO> removeVoList = new ArrayList<BkgBbCgoVO>();									
			dbDao.searchBbApproval(bkgNo, caFlg);
			dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg); 			
			      	
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
						if(bkgBbCgoVOs[i].getCmdtCd() != null){							
							String cmdtCd = bkgBbCgoVOs[i].getCmdtCd();		
							String r_cmdtCd = utilCmd.searchMdmCmdtDesc(cmdtCd);
							if(r_cmdtCd == null || r_cmdtCd.equals("")){
								throw new EventException(new ErrorHandler("BKG00010", new String[] {"Commodity Code. Seq["+cnt+"]"}).getMessage());
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
						if(bkgBbCgoVOs[i].getCmdtCd() != null){							
							String cmdtCd = bkgBbCgoVOs[i].getCmdtCd();	
							String r_cmdtCd = utilCmd.searchMdmCmdtDesc(cmdtCd);
							if( r_cmdtCd== null || r_cmdtCd.equals("")){
								throw new EventException(new ErrorHandler("BKG00010", new String[] {"Commodity Code. Seq["+cnt+"]"}).getMessage());								
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
					dbDao.addBkgBbCgo(addVoList, caFlg);
					dbDao.modifyDgBbSeq1(addVoList, caFlg);
					dbDao.modifyDgBbSeq2(addVoList, caFlg);					
				}
				if(modifyVoList.size() > 0){
					dbDao.modifyBkgBbCgo(modifyVoList, caFlg);
					dbDao.modifyDgBbSeq1(modifyVoList, caFlg);
					dbDao.modifyDgBbSeq2(modifyVoList, caFlg);					
				}
				if(removeVoList.size() > 0){
					dbDao.removeBkgBbCgo(removeVoList, caFlg);
					dbDao.modifyDgBbSeq1(modifyVoList, caFlg);										
				}				
			}
		} catch (EventException ee) {   
		   throw ee;		  	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	
	
	/**	 
	 * SpecialCargo 
	 * @param SpclCgoAproApplVO spclCgoAproApplVO 
	 * @return strResult
	 * @exception EventException
	 */
	public String manageSpclCgoApro(SpclCgoAproApplVO spclCgoAproApplVO) throws EventException{
		
		BookingUtil utilBC = new BookingUtil();		
		SpclReqInVO[] spclReqInVOs = spclCgoAproApplVO.getSpclReqInVOs();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();		
		String strResult = "";		  
		String bdr_flg = "";		
		String slan_cd = "";	
		String rqstUsrId = spclCgoAproApplVO.getAccount().getUsr_id();
		
		try {				
			bkgBlNoVO.setBkgNo(spclCgoAproApplVO.getBkgNo());			
			bdr_flg = utilBC.searchBdrFlgByBkg(bkgBlNoVO);			
			// searchBrdFlgByBkg	
			
			log.debug("bdr_flg======="+bdr_flg);

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
							log.error("bkg_no : " + spclCgoAproApplVO.getBkgNo()
									  + " aproCd : " + spclCgoAproApplVO.getSpclCgoTp()
									  + " aproCd : " + spclReqInVOs[i].getAproCd()
									  + " time" + DateTime.getTimeStampString());
							
//							if(!spclReqInVOs[i].getAproCd().equals("")){
							if((!spclReqInVOs[i].getAproCd().equals("")) && (spclReqInVOs[i].getDcgoSeq().compareTo("0") > 0)){
								dbDao.modifyDgReq(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getDcgoSeq(), rqstUsrId);	
							}
						}
					}
				}else{					
					for(int i=0; i< spclReqInVOs.length; i++){		
						if(!spclReqInVOs[i].getAproCd().equals(""))
						log.error("bkg_no : " + spclCgoAproApplVO.getBkgNo()
								  + " aproCd : " + spclCgoAproApplVO.getSpclCgoTp()
								  + " aproCd : " + spclReqInVOs[i].getAproCd()
								  + " time" + DateTime.getTimeStampString());
						
//						if(spclCgoAproApplVO.getSpclCgoTp().equals("A") && !spclReqInVOs[i].getAproCd().equals("")){							
						if(spclCgoAproApplVO.getSpclCgoTp().equals("A") && !spclReqInVOs[i].getAproCd().equals("") && spclReqInVOs[i].getAwkCgoSeq().compareTo("0") > 0){							
							dbDao.modifyAwkReq(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getAwkCgoSeq(), rqstUsrId);							
						}						
//						if(spclCgoAproApplVO.getSpclCgoTp().equals("B") && !spclReqInVOs[i].getAproCd().equals("")){							
						if(spclCgoAproApplVO.getSpclCgoTp().equals("B") && !spclReqInVOs[i].getAproCd().equals("") && spclReqInVOs[i].getBbCgoSeq().compareTo("0") > 0){							
							dbDao.modifyBbReq(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getBbCgoSeq(), rqstUsrId);							
						}						
//						if(spclCgoAproApplVO.getSpclCgoTp().equals("R") && !spclReqInVOs[i].getAproCd().equals("")){							
						if(spclCgoAproApplVO.getSpclCgoTp().equals("R") && !spclReqInVOs[i].getAproCd().equals("") && spclReqInVOs[i].getRcSeq().compareTo("0") > 0){							
							dbDao.modifyRfReq(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getRcSeq(), rqstUsrId);
						}							
//						if(spclCgoAproApplVO.getSpclCgoTp().equals("S") && !spclReqInVOs[i].getAproCd().equals("")){							
						if(spclCgoAproApplVO.getSpclCgoTp().equals("S") && !spclReqInVOs[i].getAproCd().equals("") && spclReqInVOs[i].getStwgCgoSeq().compareTo("0") > 0){							
							dbDao.modifyStwgReq(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getStwgCgoSeq(), rqstUsrId);
							//update stowage data of bkg_booking
							dbDao.modifyBkgStwgInfo(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getStwgCgoSeq());
//							if(spclReqInVOs[i].getAproCd().equals("C")){
								//Cancel the confirmed data of BKG_BOOKING
//								dbDao.modifyBkgStwgInfo(spclCgoAproApplVO.getBkgNo(), spclReqInVOs[i].getAproCd(), spclReqInVOs[i].getStwgCgoSeq());
//							}
						}						
					}
//				}
			}			
			//return dbDao.searchSRouteFromList(spclReqInVO);
		} catch (EventException ee){
			throw ee;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}			 
		return strResult;
	}
	
	/**
	 * 
	 *  SCG<br>
	 * 
	 * @param String bkgNo
	 * @param String aproCd
	 * @param String cgoSeq
	 * @param String spclCgoTp
	 * @param String rqstusrId
	 * @exception EventException
	 */
	public void modifyAproStatus(String bkgNo, String aproCd, String cgoSeq, String spclCgoTp, String rqstusrId) throws EventException {
			
		try {			
			log.error("SCG APRO ====> bkg_no : " + bkgNo
					  + " aproCd : " + aproCd
					  + " cgoSeq : " + cgoSeq
					  + " spclCgoTp : " + spclCgoTp
					  + " rqstusrId :" + rqstusrId);
			
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
			if(spclCgoTp.equals("S")){				
				dbDao.modifyStwgReq(bkgNo, aproCd, cgoSeq, "");
				if(aproCd.equals("Y")){ //update stowage code of BKG_BOOKING after aprove
					dbDao.modifyBkgStwgInfo(bkgNo, aproCd, cgoSeq);
				}
			}			
        } catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
        }
	}  
	
	/**
	 * 
	 *  SpecialCargoReceipt<br>
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
        	
//        	Query 
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
        } catch(EventException ee) {
        	throw ee;
        } catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
        } catch(Exception ex) {        	
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
        }
        return scgVvdAproRqstVOs;
    }

	/**
	 * handling event to search<br>
	 *  in case of indicating VVD in T/S , searching vvd information to request Special cargo again <br>
	 *
	 * @param String bkgNo
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */
	public ScgVvdAproRqstVO[] searchBkgVvdTs(String bkgNo) throws EventException {		
		ScgVvdAproRqstVO[] scgVvdAproRqstVOs = null;
		List<BkgVvdVO> bkgVvdVOs = new ArrayList<BkgVvdVO>();
		
        try {                                 
        	bkgVvdVOs = dbDao.searchBkgVvdTs(bkgNo);        
        	
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
	 * handling event to search<br>
	 * in case of indicating VVD in C/A , searching vvd information to request Special cargo again <br>
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
	 * SpecialCargo - searching information by imdgPckCd and imdgPckTpCd.(ESM_BKG_0206)
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
	 * copying Special Cargo data<br>
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
			if(copyModeCd.equals("M")){ // in case of Combine
				if ( targetBkg != null ) {
	            	// in case of Combine, targetBkg is sourceBkg
	            	// sourceBkg has roll of targetbkg
					for(int i=0;i<targetBkg.length;i++){
						dbDao.copyDgCgoByBkg(targetBkg[i], sourceBkg, copyModeCd, account);
						dbDao.copyRfCgoByBkg(targetBkg[i], sourceBkg, copyModeCd, account);
						dbDao.copyAkCgoByBkg(targetBkg[i], sourceBkg, copyModeCd, account);
						dbDao.copyAkDimByBkg(targetBkg[i], sourceBkg, copyModeCd, account);
						dbDao.copyBBCgoByBkg(targetBkg[i], sourceBkg, copyModeCd, account);
					}
				}
				// updating cntr volume of spcl cargo which is in original BKG makes same as container volume
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
									dbDao.copyDgCgoBySplit(sourceBkg, targetBkg[i], selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq(), account, selectSpclCgoVO.get(icnt).getKeepDgRefNo());
								}else if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("R")){ //RF Copy
									dbDao.copyRfCgoBySplit(sourceBkg, targetBkg[i], selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq(), account);
								}else if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("A")){ //AK Copy
									dbDao.copyAkCgoBySplit(sourceBkg, targetBkg[i], selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq(), account);
									dbDao.copyAkDimBySplit(sourceBkg, targetBkg[i], selectSpclCgoVO.get(icnt).getCntrNo(), selectSpclCgoVO.get(icnt).getSpclCagoSeq(), account);
								}else if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("B")){ //BB Copy
									dbDao.copyBbCgoBySplit(sourceBkg, targetBkg[i], selectSpclCgoVO.get(icnt).getSpclCagoSeq(), account);
								}else if (selectSpclCgoVO.get(icnt).getSpclCagoFlag().equals("S")){ //ST Copy
									dbDao.copySsCgoBySplit(sourceBkg, targetBkg[i], account);
								}	
							}
						}
					}
				}
				for(int icnt=0;icnt<selectSpclCgoVO.size();icnt++){
					if (selectSpclCgoVO.get(icnt).getSplitreason().equals("C")){
						//in case of changing in original BKG
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
				
				// updating cntr volume of spcl cargo which is in original BKG makes same as container volume 
				dbDao.modifyBkgDgCgoVol(sourceBkg, account);
				dbDao.modifyBkgRfCgoVol(sourceBkg, account);
				dbDao.modifyBkgAwkCgoVol(sourceBkg, account);
			} else if(copyModeCd.equals("C")){			
				
				for(int i = 0; i < selectSpclCgoVO.size() ; i++){
					if("D".equals(selectSpclCgoVO.get(i).getSpclCagoFlag())){
						dbDao.copyDgCgoByBkg(sourceBkg, targetBkg[0], copyModeCd, account);
					}else if("R".equals(selectSpclCgoVO.get(i).getSpclCagoFlag())){
						dbDao.copyRfCgoByBkg(sourceBkg, targetBkg[0], copyModeCd, account);
					}else if("A".equals(selectSpclCgoVO.get(i).getSpclCagoFlag())){
						dbDao.copyAkCgoByBkg(sourceBkg, targetBkg[0], copyModeCd, account);
					}else if("B".equals(selectSpclCgoVO.get(i).getSpclCagoFlag())){
						dbDao.copyBBCgoByBkg(sourceBkg, targetBkg[0], copyModeCd, account);
					}else if("S".equals(selectSpclCgoVO.get(i).getSpclCagoFlag())){
						dbDao.copySsCgoByBkg(sourceBkg, targetBkg[0], copyModeCd, account);
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
     *   function which is for copying Special Cargo in case of moving and copying container
     * 
     * @param CntrCopyVO cntrCopyVO
     * @param String copyModeCd
     */
    public void copySpclCgoByCntr(CntrCopyVO cntrCopyVO, String copyModeCd) throws EventException {
        //
        try {
            dbDao.copyAkCgoByCntr(cntrCopyVO);
            dbDao.copyAkDimByCntr(cntrCopyVO);
            dbDao.copyDgCgoByCntr(cntrCopyVO, copyModeCd);
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
	 * copying table which is related with special cargo for C/A
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
				//06.  
				dbDao.removeSsCA   (bkgBlNoVO, copyTypeCd);
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
			//06. 
			dbDao.createSsCA   (bkgBlNoVO, copyTypeCd);
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
	}
	
	/**
	 * deleting table which is related with special cargo for C/A
	 * @author 		
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
			//06. 
			dbDao.removeSsCA   (bkgBlNoVO, copyTypeCd);	
			
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
	}  

	/**
	 *  modifying RD Term of Special Cargo
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
	 * modifying  Danger Cargo information in case of requesting special because of pre-checking
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
	 * Segration No 콤보 셋팅을 위해 SCG_IMDG_SEGR_GRP 데이터를 조회한다.
	 * 
	 * @return      List<BkgComboVO>
	 * @exception 	EventException
	 */
	public List<BkgComboVO> searchSegrGrpList() throws EventException{
		try {
			return dbDao.searchSegrGrpList();	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * 
	 * @param bkgNo
	 * @param caFlg
	 * @return
	 * @throws EventException
	 */
	public StwgCgoApplVO searchStwgCargo(String bkgNo, String caFlg) throws EventException {

		StwgCgoApplVO stwgCgoApplVO = new StwgCgoApplVO();		
		String spclTp = "SS";
		
        try {
//        	stwgCgoApplVO.setBkgAwkCgo(dbDao.searchAwkCgoList(bkgNo, caFlg));                
//        	stwgCgoApplVO.setAwkBkgInfo(dbDao.searchAwkBkgInfo(bkgNo, caFlg));
        	stwgCgoApplVO.setCntrTypzQty(dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg));  
        	stwgCgoApplVO.setstwgAproInfo(dbDao.searchStwgApproval(bkgNo, caFlg));             
        	stwgCgoApplVO.setStwgBkgInfo(dbDao.searchStwgBkgInfo(bkgNo, caFlg));              
//        	stwgCgoApplVO.setCntrCombo(dbDao.searchCntrList(bkgNo, spclTp, caFlg));
//        	stwgCgoApplVO.setBkgAwkDim(dbDao.searchAwkDimDtl(bkgNo, caFlg));				
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        return stwgCgoApplVO;
    }

	/**	 
	 * ESM_BKG_0090 saving logic
	 * @param StwgCgoApplVO stwgCgoApplVO
	 * @param String caFlg 
	 * @exception EventException
	 */
	public void manageStwgCargo(StwgCgoApplVO stwgCgoApplVO, String caFlg) throws EventException{
		
//		BkgBbCgoVO[] bkgBbCgoVOs = bbCgoApplVO.getBkgBbCgoVOs();		
		BkgStwgCgoVO[] bkgStwgCgoVOs = stwgCgoApplVO.getBkgStwgCgoVOs();		
		SignOnUserAccount account = stwgCgoApplVO.getAccount();
		StwgAproInfoVO currentStwgCgoApplVO = new StwgAproInfoVO();
//		BookingUtil utilCmd = new BookingUtil();	
		String user_id 	= account.getUsr_id();	//user id		
//		String upd_dt 	= account.getUpd_dt();	//create date
//		String bkgNo = stwgCgoApplVO.getBkgNo();
		//String ovrVoidSltQty = bbCgoApplVO.getOvrVoidSltQty();;		
//		String spclTp = "SS";	
		String uiId = stwgCgoApplVO.getUiId();	
//		int cnt = 0;
		
		try {
			if (bkgStwgCgoVOs != null){
				
				List<BkgStwgCgoVO> addVoList = new ArrayList<BkgStwgCgoVO>();
				List<BkgStwgCgoVO> modifyVoList = new ArrayList<BkgStwgCgoVO>();
				List<BkgStwgCgoVO> removeVoList = new ArrayList<BkgStwgCgoVO>();									
	//			dbDao.searchBbApproval(bkgNo, caFlg);
	//			dbDao.searchCntrTpszQty(bkgNo, spclTp, caFlg); 			
				      	
				currentStwgCgoApplVO = dbDao.searchStwgApproval(stwgCgoApplVO.getBkgNo(), caFlg);
				
				if (stwgCgoApplVO.getBkgStwgCgoVOs()[0].getStwgCd().equals("")){
					if (currentStwgCgoApplVO!=null){
						//delete
						removeVoList.add(bkgStwgCgoVOs[0]);
						dbDao.removeStwgCgoList(removeVoList, caFlg);
					}
				}else{
					if (currentStwgCgoApplVO.getBkgNo()!=null){
						//update
						modifyVoList.add(bkgStwgCgoVOs[0]);
						bkgStwgCgoVOs[0].setUpdUsrId(user_id);
						dbDao.modifyStwgCgoList(modifyVoList, uiId, caFlg);
						
					}else{
						//insert
						addVoList.add(bkgStwgCgoVOs[0]);
						bkgStwgCgoVOs[0].setCreUsrId(user_id);
						bkgStwgCgoVOs[0].setUpdUsrId(user_id);
						dbDao.addStwgCgoList(addVoList, uiId, caFlg);
					}
				}
			}
			 	  	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());    
		}
	}
	
	/**	 
	 * Check key information is updated or not to conduct auto request.
	 * @param DgCgoApplVO dgCgoApplVO
	 * @return      String 
	 * @exception EventException
	 */
	public String manageDGAutoRequest(DgCgoApplVO dgCgoApplVO) throws EventException{
		
		DgCgoListVO[] dgCgoListVOs = dgCgoApplVO.getDgCgoListVOs();
		String autoRequest = "N";
		
		try {

			if(dgCgoListVOs != null){
				for ( int i=0; i<dgCgoListVOs.length; i++ ) {
//					if (dgCgoListVOs[i].getIbflag().equals("I") || dgCgoListVOs[i].getIbflag().equals("D")){
					if ((dgCgoListVOs[i].getIbflag().equals("I") || dgCgoListVOs[i].getIbflag().equals("D")) && (!"C".equals(dgCgoListVOs[i].getSpclCgoAproCd()))){
						autoRequest = "Y";
						break;
					}else if ((dgCgoListVOs[i].getIbflag().equals("U")) && (!dgCgoListVOs[i].getSpclCgoAproCd().equals("C"))){
						if(dbDao.searchChangedDG(dgCgoListVOs[i]).equals("Y")){ // Check key information is updated or not
							autoRequest = "Y";
							break;
						}
					}
				}
			}
			
			return autoRequest;
						
		} catch (DAOException de) {			
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
		} catch (Exception ex) {			
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	/**
	 * searching DG data<br>
	 *  SpecialCargoReceipt(ESM_BKG_0200)<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<DgCgoListVO> 
	 * @exception EventException
	 */
	public List<DgCgoListVO> searchDgList(String bkgNo, String caFlg) throws EventException {

        try {
                return dbDao.searchDgList(bkgNo, caFlg);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        
    }

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
	public List<ScgVvdDgCgoCxlRqstVO> manageDgBkgCancel(String bkgNo, SignOnUserAccount account, List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs, String cxlCgoRsn) throws EventException {

		try {
        	ScgVvdDgCgoCxlRqstVO scgVvdDgCgoCxlRqstVO = new ScgVvdDgCgoCxlRqstVO();

    		scgVvdDgCgoCxlRqstVO.setBkgNo(bkgNo);
    		scgVvdDgCgoCxlRqstVO.setCxlCgoKndCd("BK");
    		scgVvdDgCgoCxlRqstVO.setCxlCgoRsn(cxlCgoRsn);
    		scgVvdDgCgoCxlRqstVO.setCreUsrId(account.getUsr_id());               
    		scgVvdDgCgoCxlRqstVO.setUpdUsrId(account.getUsr_id());
        	
        	scgVvdDgCgoCxlRqstVOs.add(scgVvdDgCgoCxlRqstVO);
        	
        	return scgVvdDgCgoCxlRqstVOs;
        	
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
	}

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
	public List<ScgVvdDgCgoCxlRqstVO> manageDgDgCancel(List<SearchDgCancelInfoVO> dgCancelInfo, SignOnUserAccount account, List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs, String cxlCgoRsn) throws EventException {

		try {
			for (int i =0; i < dgCancelInfo.size(); i++){
	        	ScgVvdDgCgoCxlRqstVO scgVvdDgCgoCxlRqstVO = new ScgVvdDgCgoCxlRqstVO();
	
	    		scgVvdDgCgoCxlRqstVO.setBkgNo(dgCancelInfo.get(i).getBkgNo());
	    		scgVvdDgCgoCxlRqstVO.setCxlCgoKndCd("DG");
	    		scgVvdDgCgoCxlRqstVO.setCxlCgoRsn(cxlCgoRsn);
	    		scgVvdDgCgoCxlRqstVO.setCreUsrId(account.getUsr_id());               
	    		scgVvdDgCgoCxlRqstVO.setUpdUsrId(account.getUsr_id());

	    		scgVvdDgCgoCxlRqstVO.setVslCd(dgCancelInfo.get(i).getVslCd());
	    		scgVvdDgCgoCxlRqstVO.setSkdVoyNo(dgCancelInfo.get(i).getSkdVoyNo());
	    		scgVvdDgCgoCxlRqstVO.setSkdDirCd(dgCancelInfo.get(i).getSkdDirCd());
	    		scgVvdDgCgoCxlRqstVO.setPolCd(dgCancelInfo.get(i).getPolCd());
	    		scgVvdDgCgoCxlRqstVO.setPolClptIndSeq(dgCancelInfo.get(i).getPolClptIndSeq());
	    		scgVvdDgCgoCxlRqstVO.setPolYdCd(dgCancelInfo.get(i).getPolYdCd());
	    		scgVvdDgCgoCxlRqstVO.setPodCd(dgCancelInfo.get(i).getPodCd());
	    		scgVvdDgCgoCxlRqstVO.setPodClptIndSeq(dgCancelInfo.get(i).getPodClptIndSeq());
	    		scgVvdDgCgoCxlRqstVO.setPodYdCd(dgCancelInfo.get(i).getPodYdCd());

	        	scgVvdDgCgoCxlRqstVOs.add(scgVvdDgCgoCxlRqstVO);
			}
        	return scgVvdDgCgoCxlRqstVOs;
        	
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
	}

	/**
	 * Search the DG cancel information before data change<br>
	 * 
	 * @param String bkgNo
	 * @return List<SearchDgCancelInfoVO> 
	 * @exception EventException
	 */
	public List<SearchDgCancelInfoVO> searchDgCancelInfo(String bkgNo) throws EventException {

        try {
                return dbDao.searchDgCancelInfo(bkgNo);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        
    }
	
	/**
	 * Search the list of IMDG_AMDT_NO<br>
	 * 
	 * @return String 
	 * @exception EventException
	 */
	public String searchImdgAmdtNo() throws EventException {

        try {
                return dbDao.searchImdgAmdtNo();
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        
    }
	/**
	 * Search Declarant<br>
	 *
	 * @param BkgDgCgoInfoVO dgCgoInfoVO
	 * @return List<DeclarantCustomerInfoVO>
	 * @throws EventException
	 */
	public List<DeclarantCustomerInfoVO> searchDeclarantCustomer(BkgDgCgoInfoVO dgCgoInfoVO) throws EventException {
		try {
            return dbDao.searchDeclarantCustomer(dgCgoInfoVO);
	    } catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
		} catch (Exception ex) {			
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
	    }
	}
	/**
	 * DG Shipper, DG Consignee 정보를 저장한다.<br>
	 * 
	 * @param DeclarantCustomerInfoVO declarantCustomerInfoVO
	 * @param DgCntrVO[] dgCntrVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageDeclarantCustomer(DeclarantCustomerInfoVO declarantCustomerInfoVO, DgCntrVO[] dgCntrVOs, SignOnUserAccount account) throws EventException {
		
		BkgDgDeclVO vo = new BkgDgDeclVO();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		BookingUtil utilCmd = new BookingUtil();	

		try {
			vo = new BkgDgDeclVO();
			bkgBlNoVO.setBkgNo(declarantCustomerInfoVO.getBkgNo());
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			
			BkgBlNoVO schBkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
        	
			if(schBkgBlNoVO != null){
				
				if(dgCntrVOs != null){
						vo = new BkgDgDeclVO();
						//Items per transaction 
						vo.setBkgNo(declarantCustomerInfoVO.getBkgNo());
						vo.setDeclNm(declarantCustomerInfoVO.getDeclNm());
						vo.setCntrCgoSeq("1");
						vo.setCreUsrId(account.getUsr_id());
						vo.setUpdUsrId(account.getUsr_id());

						for(DgCntrVO dgCntrVO : dgCntrVOs){
							//Items per Container 
							vo.setDgCntrSeq(dgCntrVO.getDgCntrSeq());
							
							//Shipper Items
							vo.setBkgCustTpCd("S");
							vo.setCustCntCd(declarantCustomerInfoVO.getShCustCntCd());
							vo.setCustSeq(declarantCustomerInfoVO.getShCustSeq());
							vo.setCustNm(declarantCustomerInfoVO.getShCustNm());
							vo.setCustAddr(declarantCustomerInfoVO.getShCustAddr());
							vo.setCustCtyNm(declarantCustomerInfoVO.getShCustCtyNm());
							vo.setCustSteCd(declarantCustomerInfoVO.getShCustSteCd());
							vo.setCstmsDeclCntCd(declarantCustomerInfoVO.getShCstmsDeclCntCd());
							vo.setCustZipId(declarantCustomerInfoVO.getShCustZipId());
							vo.setPhnNo(declarantCustomerInfoVO.getShPhnNo());
							vo.setCustFaxNo(declarantCustomerInfoVO.getShCustFaxNo());
							vo.setCustEml(declarantCustomerInfoVO.getShCustEml());

							if("Y".equals(dbDao.checkDeclarantCustomer(vo))){ //Check data exists or not
								dbDao.modifyDeclarantCustomer(vo,schBkgBlNoVO.getCaFlg());
							}else{
								dbDao.addDeclarantCustomer(vo,schBkgBlNoVO.getCaFlg());;								
							}
														
							//Consignee Items
							vo.setBkgCustTpCd("C");
							vo.setCustCntCd(declarantCustomerInfoVO.getCnCustCntCd());
							vo.setCustSeq(declarantCustomerInfoVO.getCnCustSeq());
							vo.setCustNm(declarantCustomerInfoVO.getCnCustNm());
							vo.setCustAddr(declarantCustomerInfoVO.getCnCustAddr());
							vo.setCustCtyNm(declarantCustomerInfoVO.getCnCustCtyNm());
							vo.setCustSteCd(declarantCustomerInfoVO.getCnCustSteCd());
							vo.setCstmsDeclCntCd(declarantCustomerInfoVO.getCnCstmsDeclCntCd());
							vo.setCustZipId(declarantCustomerInfoVO.getCnCustZipId());
							vo.setPhnNo(declarantCustomerInfoVO.getCnPhnNo());
							vo.setCustFaxNo(declarantCustomerInfoVO.getCnCustFaxNo());
							vo.setCustEml(declarantCustomerInfoVO.getCnCustEml());

							if("Y".equals(dbDao.checkDeclarantCustomer(vo))){ //Check data exists or not
								dbDao.modifyDeclarantCustomer(vo,schBkgBlNoVO.getCaFlg());
							}else{
								dbDao.addDeclarantCustomer(vo,schBkgBlNoVO.getCaFlg());;								
							}
						}
/*						
		//				SH_DG_DECL_SEQ
						if(null == declarantCustomerInfoVO.getShDgDeclSeq()||"".equals(declarantCustomerInfoVO.getShDgDeclSeq())){
							log.debug("------->1:");
//							vo = new BkgDgDeclVO();
//							vo.setBkgNo(declarantCustomerInfoVO.getBkgNo());
//							vo.setDcgoSeq(declarantCustomerInfoVO.getDcgoSeq());
	//						vo.setDgCntrSeq(declarantCustomerInfoVO.getDgCntrSeq());
							vo.setDgCntrSeq(dgCntrVO.getDgCntrSeq());					//Checked seq as update target
							vo.setCntrCgoSeq(declarantCustomerInfoVO.getCntrCgoSeq());
	//						vo.setCntrNo(declarantCustomerInfoVO.getCntrNo());
							vo.setCntrNo(dgCntrVO.getCntrNo());							//Checked seq as update target
							vo.setBkgCustTpCd("S");
							vo.setCustCntCd(declarantCustomerInfoVO.getShCustCntCd());
							vo.setCustSeq(declarantCustomerInfoVO.getShCustSeq());
							vo.setCustNm(declarantCustomerInfoVO.getShCustNm());
							vo.setCustAddr(declarantCustomerInfoVO.getShCustAddr());
							vo.setCustCtyNm(declarantCustomerInfoVO.getShCustCtyNm());
							vo.setCustSteCd(declarantCustomerInfoVO.getShCustSteCd());
							vo.setCstmsDeclCntCd(declarantCustomerInfoVO.getShCstmsDeclCntCd());
							vo.setCustZipId(declarantCustomerInfoVO.getShCustZipId());
							vo.setPhnNo(declarantCustomerInfoVO.getShPhnNo());
							vo.setCustFaxNo(declarantCustomerInfoVO.getShCustFaxNo());
							vo.setCustEml(declarantCustomerInfoVO.getShCustEml());
							vo.setCreUsrId(account.getUsr_id());
							vo.setUpdUsrId(account.getUsr_id());
							vo.setDeclNm(declarantCustomerInfoVO.getDeclNm());
							String checkYN = dbDao.checkDeclarantCustomer(vo);
		log.debug("------->checkyn:"+checkYN);
							if(!checkYN.equals("Y")){
		//						dbDao.create
								dbDao.addDeclarantCustomer(vo,schBkgBlNoVO.getCaFlg());
							}
						}else{
		//					dbDao.update
//							vo = new BkgDgDeclVO();
//							vo.setBkgNo(declarantCustomerInfoVO.getBkgNo());
//							vo.setDcgoSeq(declarantCustomerInfoVO.getDcgoSeq());
							log.debug("dcgo_seq>>>>"+declarantCustomerInfoVO.getDcgoSeq());
							log.debug("dcgo_seq>>>>"+vo.getDcgoSeq());
							vo.setDgDeclSeq(declarantCustomerInfoVO.getShDgDeclSeq());
							log.debug("sh_dg_decl_seq>>>>"+declarantCustomerInfoVO.getShDgDeclSeq());
							log.debug("sh_dg_decl_seq>>>>"+vo.getDgDeclSeq());
	//						vo.setDgCntrSeq(declarantCustomerInfoVO.getDgCntrSeq());
							vo.setDgCntrSeq(dgCntrVO.getDgCntrSeq());					//Checked seq as update target
							log.debug("dg_cntr_seq>>>>"+declarantCustomerInfoVO.getDgCntrSeq());
							log.debug("dg_cntr_seq>>>>"+vo.getDgCntrSeq());
							vo.setCntrCgoSeq(declarantCustomerInfoVO.getCntrCgoSeq());
	//						vo.setCntrNo(declarantCustomerInfoVO.getCntrNo());
							vo.setCntrNo(dgCntrVO.getCntrNo());							//Checked seq as update target
							vo.setBkgCustTpCd("S");
							vo.setCustCntCd(declarantCustomerInfoVO.getShCustCntCd());
							vo.setCustSeq(declarantCustomerInfoVO.getShCustSeq());
							vo.setCustNm(declarantCustomerInfoVO.getShCustNm());
							vo.setCustAddr(declarantCustomerInfoVO.getShCustAddr());
							vo.setCustCtyNm(declarantCustomerInfoVO.getShCustCtyNm());
							vo.setCustSteCd(declarantCustomerInfoVO.getShCustSteCd());
							vo.setCstmsDeclCntCd(declarantCustomerInfoVO.getShCstmsDeclCntCd());
							vo.setCustZipId(declarantCustomerInfoVO.getShCustZipId());
							vo.setPhnNo(declarantCustomerInfoVO.getShPhnNo());
							vo.setCustFaxNo(declarantCustomerInfoVO.getShCustFaxNo());
							vo.setCustEml(declarantCustomerInfoVO.getShCustEml());
							vo.setUpdUsrId(account.getUsr_id());
							vo.setDeclNm(declarantCustomerInfoVO.getDeclNm());
							dbDao.modifyDeclarantCustomer(vo,schBkgBlNoVO.getCaFlg());
							
						}
						vo = new BkgDgDeclVO();
						if(null == declarantCustomerInfoVO.getCnDgDeclSeq()||"".equals(declarantCustomerInfoVO.getCnDgDeclSeq())){
							log.debug("------->2:");
							vo = new BkgDgDeclVO();
							vo.setBkgNo(declarantCustomerInfoVO.getBkgNo());
							vo.setDcgoSeq(declarantCustomerInfoVO.getDcgoSeq());
	//						vo.setDgCntrSeq(declarantCustomerInfoVO.getDgCntrSeq());
							vo.setDgCntrSeq(dgCntrVO.getDgCntrSeq());					//Checked seq as update target
							vo.setCntrCgoSeq(declarantCustomerInfoVO.getCntrCgoSeq());
	//						vo.setCntrNo(declarantCustomerInfoVO.getCntrNo());
							vo.setCntrNo(dgCntrVO.getCntrNo());							//Checked seq as update target
							vo.setBkgCustTpCd("C");
							vo.setCustCntCd(declarantCustomerInfoVO.getCnCustCntCd());
							vo.setCustSeq(declarantCustomerInfoVO.getCnCustSeq());
							vo.setCustNm(declarantCustomerInfoVO.getCnCustNm());
							vo.setCustAddr(declarantCustomerInfoVO.getCnCustAddr());
							vo.setCustCtyNm(declarantCustomerInfoVO.getCnCustCtyNm());
							vo.setCustSteCd(declarantCustomerInfoVO.getCnCustSteCd());
							vo.setCstmsDeclCntCd(declarantCustomerInfoVO.getCnCstmsDeclCntCd());
							vo.setCustZipId(declarantCustomerInfoVO.getCnCustZipId());
							vo.setPhnNo(declarantCustomerInfoVO.getCnPhnNo());
							vo.setCustFaxNo(declarantCustomerInfoVO.getCnCustFaxNo());
							vo.setCustEml(declarantCustomerInfoVO.getCnCustEml());
							vo.setCreUsrId(account.getUsr_id());
							vo.setUpdUsrId(account.getUsr_id());
							vo.setDeclNm(declarantCustomerInfoVO.getDeclNm());
							
							String checkYN = dbDao.checkDeclarantCustomer(vo);
		log.debug("------->checkyn:"+checkYN);
							if(!checkYN.equals("Y")){
			//					dbDao.create
								dbDao.addDeclarantCustomer(vo,schBkgBlNoVO.getCaFlg());
							}
							
						}else{
		//					dbDao.update
							vo.setBkgNo(declarantCustomerInfoVO.getBkgNo());
							vo.setDcgoSeq(declarantCustomerInfoVO.getDcgoSeq());
							vo.setDgDeclSeq(declarantCustomerInfoVO.getCnDgDeclSeq());
	//						vo.setDgCntrSeq(declarantCustomerInfoVO.getDgCntrSeq());
							vo.setDgCntrSeq(dgCntrVO.getDgCntrSeq());					//Checked seq as update target
							vo.setCntrCgoSeq(declarantCustomerInfoVO.getCntrCgoSeq());
	//						vo.setCntrNo(declarantCustomerInfoVO.getCntrNo());
							vo.setCntrNo(dgCntrVO.getCntrNo());							//Checked seq as update target
							vo.setBkgCustTpCd("C");
							vo.setCustCntCd(declarantCustomerInfoVO.getCnCustCntCd());
							vo.setCustSeq(declarantCustomerInfoVO.getCnCustSeq());
							vo.setCustNm(declarantCustomerInfoVO.getCnCustNm());
							vo.setCustAddr(declarantCustomerInfoVO.getCnCustAddr());
							vo.setCustCtyNm(declarantCustomerInfoVO.getCnCustCtyNm());
							vo.setCustSteCd(declarantCustomerInfoVO.getCnCustSteCd());
							vo.setCstmsDeclCntCd(declarantCustomerInfoVO.getCnCstmsDeclCntCd());
							vo.setCustZipId(declarantCustomerInfoVO.getCnCustZipId());
							vo.setPhnNo(declarantCustomerInfoVO.getCnPhnNo());
							vo.setCustFaxNo(declarantCustomerInfoVO.getCnCustFaxNo());
							vo.setCustEml(declarantCustomerInfoVO.getCnCustEml());
							vo.setUpdUsrId(account.getUsr_id());
							vo.setDeclNm(declarantCustomerInfoVO.getDeclNm());
							dbDao.modifyDeclarantCustomer(vo,schBkgBlNoVO.getCaFlg());
						}
*/					
				}
			}	
		} catch (DAOException de) {			
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
		} catch (Exception ex) {			
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	
	/**
	 * DG Cargo 데이터 존재여부 체크
	 * @param String bkgNo
	 * @param String dcgoSeq
	 * @param String caFlg
	 * @return String
	 * @throws EventException
	 */
	public String searchDgCargoSeq(String bkgNo, String dcgoSeq, String caFlg) throws EventException{
		String dcgoYN = "N";
        try {
        	dcgoYN = dbDao.searchDgCargoSeq(bkgNo, dcgoSeq, caFlg);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
        return dcgoYN;
	}
	
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
	public void modifyRfAproStatus(String bkgNo, String aproCd, String cgoSeq, String rqstusrId) throws EventException {
		try {			
			dbDao.modifyRfReq(bkgNo, aproCd, cgoSeq, rqstusrId);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);     
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
	}
	
	/**
	 * Search data to check special request or not<br>
	 *
	 * @param String bkgNo
	 * @return PreRestrictionInputVO
	 * @throws DAOException
	 */
	public PreRestrictionInputVO searchDgForSpecialRequestCheck(String bkgNo) throws EventException {

        try {
                return dbDao.searchDgForSpecialRequestCheck(bkgNo);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
    }
	
	/**
	 * Search representative DG approval code of target booking
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchDgAproCd(String bkgNo) throws EventException{
        try {
        	return dbDao.searchDgAproCd(bkgNo);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
	}
	
	/**
	 * Search DG information to request data to SCG.<br>
	 * @param String bkgNo
	 * @return SpclReqInVO[]
	 * @throws EventException
	 */
	public SpclReqInVO[] searchDgForRequest(String bkgNo) throws EventException{
        try {
        	return dbDao.searchDgForRequest(bkgNo);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
        }
	}
	
	/**
	 *  Return list of DG container.<br>
	 * 
	 * @param String bkgNo
	 * @return List<DgCntrVO> 
	 * @exception EventException
	 */
	public List<DgCntrVO> searchDgCntrList(String bkgNo) throws EventException {

        try {
        	return dbDao.searchDgCntrList(bkgNo);	
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
        
    }

}
