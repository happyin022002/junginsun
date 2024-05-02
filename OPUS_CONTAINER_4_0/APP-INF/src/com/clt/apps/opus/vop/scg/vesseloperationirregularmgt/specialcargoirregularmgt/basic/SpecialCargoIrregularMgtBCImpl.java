/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoIrregularMgtBCImpl.java
*@FileTitle : SPCL CGO Irregular Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration.SpecialCargoIrregularMgtDBDAO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.BKGOutputVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.CNTRInfoInputVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.CNTRInfoVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrrCntrVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrrFileListVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularsVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;
import com.clt.syscommon.common.table.ScgImdgUnNoVO;

/**
 * OPUS-VesselOperationIrregularMgt Business Logic Basic Command implementation<br>
 * - Handling business transactions of OPUS-VesselOperationIrregularMgt<br>
 *
 * @author
 * @see VOP_SCG_0013EventResponse,SpecialCargoIrregularMgtBC
 * @since J2EE 1.6
 */
public class SpecialCargoIrregularMgtBCImpl extends BasicCommandSupport implements SpecialCargoIrregularMgtBC {

	// Database Access Object
	private transient SpecialCargoIrregularMgtDBDAO dbDao = null;

	/**
	 * SpecialCargoIrregularMgtBCImpl object creation<br>
	 * SpecialCargoIrregularMgtDBDAO creation<br>
	 */
	public SpecialCargoIrregularMgtBCImpl() {
		dbDao = new SpecialCargoIrregularMgtDBDAO();
	}
	/**
	 * SPCL CGO Irregular retrieve <br>
	 * 
	 * @param irregularVO   IrregularVO
	 * @return IrregularVO
	 * @exception EventException
	 */
	public IrregularVO searchIrregular(IrregularVO irregularVO) throws EventException {
		try {
			//1. Irregular Max Sequence retrieve
			int irregularMaxSeq = dbDao.searchIrregularMaxSeq(irregularVO);
			
			irregularVO.setSpclCgoIrrSeq(Integer.toString(--irregularMaxSeq));
			IrregularVO rsltIrrVO = dbDao.searchIrregular(irregularVO);
			List<IrrCntrVO> rsltIrrCntrVOl = dbDao.searchIrrCntrList(irregularVO);
			
			rsltIrrVO.setIrrCntrVOL(rsltIrrCntrVOl);
			
			return rsltIrrVO;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular's Supporting Documents or Pictures retrieve <br>
	 * 
	 * @param irregularVO   IrregularVO
	 * @return List<IrrFileListVO>
	 * @exception EventException
	 */
	public List<IrrFileListVO> searchIrrFileList(IrregularVO irregularVO) throws EventException {
		try {
			return dbDao.searchIrrFileList(irregularVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Supporting Documents or Pictures"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Supporting Documents or Pictures"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular create,modify,delete <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @param keys List<String>
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageIrregular(IrregularVO irregularVO, List<String> keys, SignOnUserAccount account) throws EventException{
		try {
			
			if ( irregularVO != null ) {				
				irregularVO.setCreUsrId(account.getUsr_id());
				irregularVO.setUpdUsrId(account.getUsr_id());
				if ( irregularVO.getSpclCgoIrrSeq() != null && !"".equals(irregularVO.getSpclCgoIrrSeq())) {
					dbDao.modifyIrregular(irregularVO);
				} else {
					//1. Irregular Max Sequence retrieve
					IrregularVO optionIrregularVO = new IrregularVO();
					optionIrregularVO.setVslCd(irregularVO.getVslCd());
					optionIrregularVO.setSkdVoyNo(irregularVO.getSkdVoyNo());
					optionIrregularVO.setSkdDirCd(irregularVO.getSkdDirCd());
					int irregularMaxSeq = dbDao.searchIrregularMaxSeq(optionIrregularVO);
					
					irregularVO.setSpclCgoIrrSeq(Integer.toString(irregularMaxSeq));
					dbDao.addIrregular(irregularVO);
				}
				
				IrrCntrVO[] irrCntrVOs = irregularVO.getIrrCntrVOS();
				
				if(irrCntrVOs != null) {
					List<IrrCntrVO> insertVoList1 = new ArrayList<IrrCntrVO>();
					List<IrrCntrVO> updateVoList1 = new ArrayList<IrrCntrVO>();
					List<IrrCntrVO> deleteVoList1 = new ArrayList<IrrCntrVO>();
					
					//2. Irregular Container Max Sequence retrieve
					int irrCntrMaxSeq = dbDao.searchIrrCntrMaxSeq(irregularVO);
					
					for ( int i=0; i<irrCntrVOs .length; i++ ) {
						
						irrCntrVOs[i].setVslCd(irregularVO.getVslCd());
						irrCntrVOs[i].setSkdVoyNo(irregularVO.getSkdVoyNo());
						irrCntrVOs[i].setSkdDirCd(irregularVO.getSkdDirCd());
						irrCntrVOs[i].setSpclCgoIrrSeq(irregularVO.getSpclCgoIrrSeq());					
						
						if ( irrCntrVOs[i].getIbflag().equals("I")){
							irrCntrVOs[i].setSpclCgoIrrCntrSeq(Integer.toString(irrCntrMaxSeq++));
							irrCntrVOs[i].setCreUsrId(account.getUsr_id());
							irrCntrVOs[i].setUpdUsrId(account.getUsr_id());
							insertVoList1.add(irrCntrVOs[i]);
						} else if ( irrCntrVOs[i].getIbflag().equals("U")){
							irrCntrVOs[i].setUpdUsrId(account.getUsr_id());
							updateVoList1.add(irrCntrVOs[i]);
						} else if ( irrCntrVOs[i].getIbflag().equals("D")){
							deleteVoList1.add(irrCntrVOs[i]);
						}
					}
					
					if ( deleteVoList1.size() > 0 ) {
						dbDao.removeIrrCntr(deleteVoList1);
					}
					
					if ( insertVoList1.size() > 0 ) {
						dbDao.addIrrCntr(irregularVO, insertVoList1);
					}
					
					if ( updateVoList1.size() > 0 ) {
						dbDao.modifyIrrCntr(irregularVO, updateVoList1);
					}
				}
				
				IrrFileListVO[] irrFileListVOs = irregularVO.getIrrFileListVOS();
				
				//FILE UPLOAD KEY
				Iterator<String> keyArr = null;			
				if(keys != null) keyArr = keys.iterator();
				
				if(irrFileListVOs != null) {
					List<IrrFileListVO> insertVoList2 = new ArrayList<IrrFileListVO>();
					List<IrrFileListVO> updateVoList2 = new ArrayList<IrrFileListVO>();
					List<IrrFileListVO> deleteVoList2 = new ArrayList<IrrFileListVO>();
					
					//3. Irregular File List Max Sequence retrieve
					int irrFileListMaxSeq = dbDao.searchIrrFileListMaxSeq(irregularVO);
					
					for ( int i=0; i<irrFileListVOs .length; i++ ) {
						
						//FILE UPLOAD KEY SETTING
						if(keyArr != null) {
							if("Y".equals(irrFileListVOs[i].getFileSetYn()) && keyArr.hasNext()) 
								irrFileListVOs[i].setFileSavId(keyArr.next());	 
						}
						
						irrFileListVOs[i].setVslCd(irregularVO.getVslCd());
						irrFileListVOs[i].setSkdVoyNo(irregularVO.getSkdVoyNo());
						irrFileListVOs[i].setSkdDirCd(irregularVO.getSkdDirCd());
						irrFileListVOs[i].setSpclCgoIrrSeq(irregularVO.getSpclCgoIrrSeq());					
						
						if ( irrFileListVOs[i].getIbflag().equals("I")){
							irrFileListVOs[i].setSpclCgoIrrFileSeq(Integer.toString(irrFileListMaxSeq++));
							irrFileListVOs[i].setCreUsrId(account.getUsr_id());
							irrFileListVOs[i].setUpdUsrId(account.getUsr_id());
							insertVoList2.add(irrFileListVOs[i]);
						} else if ( irrFileListVOs[i].getIbflag().equals("U")){
							irrFileListVOs[i].setUpdUsrId(account.getUsr_id());
							updateVoList2.add(irrFileListVOs[i]);
						} else if ( irrFileListVOs[i].getIbflag().equals("D")){
							deleteVoList2.add(irrFileListVOs[i]);
						}
					}
					
					if ( deleteVoList2.size() > 0 ) {
						dbDao.removeIrrFile(deleteVoList2);
					}
					
					if ( insertVoList2.size() > 0 ) {
						dbDao.addIrrFile(insertVoList2);
					}
					
					if ( updateVoList2.size() > 0 ) {
						dbDao.modifyIrrFile(updateVoList2);
					}
				}
			}

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular delete <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @exception EventException
	 */
	public void removeIrregular(IrregularVO irregularVO) throws EventException{
		try {
			
			if ( irregularVO != null) {
				List<IrrCntrVO> deleteVoList1 = new ArrayList<IrrCntrVO>();
				List<IrrFileListVO> deleteVoList2 = new ArrayList<IrrFileListVO>();
				
				String vslCd 		 = irregularVO.getVslCd();
				String skdDirCd 	 = irregularVO.getSkdDirCd();
				String skdVoyNo      = irregularVO.getSkdVoyNo();
				String spclCgoIrrSeq = irregularVO.getSpclCgoIrrSeq();
				
				//1. Container info delete
				IrrCntrVO irrCntrVO = new IrrCntrVO();
				
				irrCntrVO.setVslCd(vslCd);
				irrCntrVO.setSkdDirCd(skdDirCd);
				irrCntrVO.setSkdVoyNo(skdVoyNo);
				irrCntrVO.setSpclCgoIrrSeq(spclCgoIrrSeq);
				irrCntrVO.setSpclCgoIrrCntrSeq("");
				
				deleteVoList1.add(irrCntrVO);
				dbDao.removeIrrCntr(deleteVoList1);
				
				//2. File info delete
				IrrFileListVO irrFileListVO = new IrrFileListVO();
				
				irrFileListVO.setVslCd(vslCd);
				irrFileListVO.setSkdDirCd(skdDirCd);
				irrFileListVO.setSkdVoyNo(skdVoyNo);
				irrFileListVO.setSpclCgoIrrSeq(spclCgoIrrSeq);
				irrFileListVO.setSpclCgoIrrFileSeq("");
				
				deleteVoList2.add(irrFileListVO);
				dbDao.removeIrrFile(deleteVoList2);
				
				//3. Irregular info delete
				dbDao.removeIrregular(irregularVO);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular's Booking info retrieve <br>
	 * 
	 * @param bkgBookingVO   BkgBookingVO
	 * @return List<BKGOutputVO>
	 * @exception EventException
	 */
	public List<BKGOutputVO> searchBKGInfo(BkgBookingVO bkgBookingVO) throws EventException {
		try {
			return dbDao.searchBKGInfo(bkgBookingVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Booking Infomation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Booking Infomation"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular's Container retrieve <br>
	 * 
	 * @param bkgBookingVO   BkgBookingVO
	 * @return List<CNTRInfoVO>
	 * @exception EventException
	 */
	public List<CNTRInfoVO> searchCNTRList(BkgBookingVO bkgBookingVO) throws EventException {
		try {
			return dbDao.searchCNTRList(bkgBookingVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Container"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Container"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular's Container info retrieve <br>
	 * 
	 * @param cNTRInfoInputVO   CNTRInfoInputVO
	 * @return List<CNTRInfoVO>
	 * @exception EventException
	 */
	public List<CNTRInfoVO> searchCNTRInfo(CNTRInfoInputVO cNTRInfoInputVO) throws EventException {
		try {
			return dbDao.searchCNTRInfo(cNTRInfoInputVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Container"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Container"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular List retrieve <br>
	 * 
	 * @param irregularsVO
	 * @return List<IrregularsVO>
	 * @exception EventException
	 */
	public List<IrregularsVO> searchIrrHistList(IrregularsVO irregularsVO) throws EventException {
		try {
			return dbDao.searchIrrHistList(irregularsVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Irregular"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular List's Lane retrieve <br>
	 * 
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchIrrLaneList() throws EventException {
		try {
			return dbDao.searchIrrLaneList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular List's Vessel retrieve <br>
	 * 
	 * @return List<MdmVslCntrVO>
	 * @exception EventException
	 */
	public List<MdmVslCntrVO> searchIrrVslList() throws EventException {
		try {
			return dbDao.searchIrrVslList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Operator"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Operator"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular List's Vessel Operator retrieve <br>
	 * 
	 * @return List<MdmCarrierVO>
	 * @exception EventException
	 */
	public List<MdmCarrierVO> searchIrrVslOprList() throws EventException {
		try {
			return dbDao.searchIrrVslOprList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Operator"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Operator"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular List's Cargo Operator retrieve <br>
	 * 
	 * @return List<MdmCarrierVO>
	 * @exception EventException
	 */
	public List<MdmCarrierVO> searchIrrCgoOprList() throws EventException {
		try {
			return dbDao.searchIrrCgoOprList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Operator"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Operator"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular List's Class retrieve <br>
	 * 
	 * @return List<ScgImdgClssCdVO>
	 * @exception EventException
	 */
	public List<ScgImdgClssCdVO> searchIrrClassList() throws EventException {
		try {
			return dbDao.searchIrrClassList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Class Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Class Code"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular List's Class Comp retrieve <br>
	 * 
	 * @param scgImdgClssCdVO ScgImdgClssCdVO
	 * @return List<ScgImdgCompGrpVO>
	 * @exception EventException
	 */
	public List<ScgImdgCompGrpVO> searchIrrClassCompList(ScgImdgClssCdVO scgImdgClssCdVO) throws EventException {
		try {
			return dbDao.searchIrrClassCompList(scgImdgClssCdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Class Compatiblity"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Class Compatiblity"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular List's Un No. retrieve <br>
	 * 
	 * @return List<ScgImdgUnNoVO>
	 * @exception EventException
	 */
	public List<ScgImdgUnNoVO> searchIrrUnNoList() throws EventException {
		try {
			return dbDao.searchIrrUnNoList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"UN No."}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Un No."}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Irregular List's Location retrieve <br>
	 * 
	 * @param mdmLocationVO MdmLocationVO
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchIrrPortCdList(MdmLocationVO mdmLocationVO) throws EventException {
		try {
			return dbDao.searchIrrPortCdList(mdmLocationVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Location"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Location"}).getMessage(), ex);
		}
	}
	
}