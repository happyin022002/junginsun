/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AssetBCImpl.java
*@FileTitle : AssetBCImpl
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.asset.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.ccd.commoncode.asset.integration.AssetDBDAO;
import com.clt.apps.opus.bcm.ccd.commoncode.asset.vo.ContainerSizeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.asset.vo.ContainerTypeSizeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.asset.vo.ContainerTypeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.asset.vo.ContainerVesselVO;
import com.clt.apps.opus.bcm.ccd.commoncode.asset.vo.ContainerVesselIfVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * Asset Business Logic Command Interface<br>
 * An interface to the business logic for Asset<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class AssetBCImpl extends BasicCommandSupport implements AssetBC {

	// Database Access Object
	private transient AssetDBDAO dbDao = null;

	/**
	 * assetBCImpl object creation<br>
	 * Generate assetDBDAO.<br>
	 */
	public AssetBCImpl() {
		dbDao = new AssetDBDAO();
	}
	
	/**
	 * Container Type retrieve<br>
	 * 
	 * @param String cntrTpCd
	 * @return List<ContainerTypeVO>
	 * @exception EventException
	 */
	public List<ContainerTypeVO> searchContainerType(String cntrTpCd) throws EventException {
		try {
			return dbDao.searchContainerType(cntrTpCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Container Type  multi event process(adding/changing)<br>
	 * 
	 * @param containerTypeVOs ContainerTypeVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageContainerType(ContainerTypeVO[] containerTypeVOs, String usrId) throws EventException{
		try {
				List<ContainerTypeVO> addVoList = new ArrayList<ContainerTypeVO>();
				List<ContainerTypeVO> modifyVoList = new ArrayList<ContainerTypeVO>();

				if(containerTypeVOs[0].getIbflag().equals("I")) {
					containerTypeVOs[0].setCreUsrId(usrId);
					addVoList.add(containerTypeVOs[0]);

				} else if(containerTypeVOs[0].getIbflag().equals("U")) {
					containerTypeVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(containerTypeVOs[0]);
				}

			//date adding
			if(addVoList.size() > 0) {
				dbDao.addContainerType(addVoList);
			}
			
			//date changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyContainerType(modifyVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Container Size retrieve<br>
	 * 
	 * @param String cntrSzCd
	 * @return List<ContainerSizeVO>
	 * @exception EventException
	 */
	public List<ContainerSizeVO> searchContainerSize(String cntrSzCd) throws EventException {
		try {
			return dbDao.searchContainerSize(cntrSzCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Container Size  multi event process(adding/changing)<br>
	 * 
	 * @param containerSizeVOs ContainerSizeVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageContainerSize(ContainerSizeVO[] containerSizeVOs, String usrId) throws EventException{
		try {
				List<ContainerSizeVO> addVoList = new ArrayList<ContainerSizeVO>();
				List<ContainerSizeVO> modifyVoList = new ArrayList<ContainerSizeVO>();

				if(containerSizeVOs[0].getIbflag().equals("I")) {
					containerSizeVOs[0].setCreUsrId(usrId);
					addVoList.add(containerSizeVOs[0]);

				} else if(containerSizeVOs[0].getIbflag().equals("U")) {
					containerSizeVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(containerSizeVOs[0]);
				}

			//date adding
			if(addVoList.size() > 0) {
				dbDao.addContainerSize(addVoList);
			}
			
			//date changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyContainerSize(modifyVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Container Type Size retrieve<br>
	 * 
	 * @param String cntrTpSzCd
	 * @return List<ContainerTypeSizeVO>
	 * @exception EventException
	 */
	public List<ContainerTypeSizeVO> searchContainerTypeSize(String cntrTpSzCd) throws EventException {
		try {
			return dbDao.searchContainerTypeSize(cntrTpSzCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Container Type Size  multi event process(adding/changing)<br>
	 * 
	 * @param containerTypeSizeVOs ContainerTypeSizeVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageContainerTypeSize(ContainerTypeSizeVO[] containerTypeSizeVOs, String usrId) throws EventException{
		try {
				List<ContainerTypeSizeVO> addVoList = new ArrayList<ContainerTypeSizeVO>();
				List<ContainerTypeSizeVO> modifyVoList = new ArrayList<ContainerTypeSizeVO>();

				if(containerTypeSizeVOs[0].getIbflag().equals("I")) {
					containerTypeSizeVOs[0].setCreUsrId(usrId);
					addVoList.add(containerTypeSizeVOs[0]);

				} else if(containerTypeSizeVOs[0].getIbflag().equals("U")) {
					containerTypeSizeVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(containerTypeSizeVOs[0]);
				}

			//date adding
			if(addVoList.size() > 0) {
				dbDao.addContainerTypeSize(addVoList);
			}
			
			//date changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyContainerTypeSize(modifyVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Container Vessel retrieve<br>
	 * 
	 * @param String vslCd
	 * @return List<ContainerVesselVO>
	 * @exception EventException
	 */
	public List<ContainerVesselVO> searchContainerVessel(String vslCd) throws EventException {
		try {
			return dbDao.searchContainerVessel(vslCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Container Vessel retrieve<br>
	 * 
	 * @param String rqstNo
	 * @return List<ContainerVesselVO>
	 * @exception EventException
	 */
	public List<ContainerVesselVO> searchContainerVesselRqst(String rqstNo) throws EventException {
		try {
			return dbDao.searchContainerVesselRqst(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Container Vessel  multi event process(adding/changing)<br>
	 * 
	 * @param containerVesselVOs ContainerVesselVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageContainerVessel(ContainerVesselVO[] containerVesselVOs, String usrId) throws EventException{
		try {
				List<ContainerVesselVO> addVoList = new ArrayList<ContainerVesselVO>();
				List<ContainerVesselVO> modifyVoList = new ArrayList<ContainerVesselVO>();
				

				if(containerVesselVOs[0].getIbflag().equals("I")) {
					containerVesselVOs[0].setCreUsrId(usrId);
					addVoList.add(containerVesselVOs[0]);

				} else if(containerVesselVOs[0].getIbflag().equals("U")) {
					containerVesselVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(containerVesselVOs[0]);
				}

			//date adding
			if(addVoList.size() > 0) {
				dbDao.addContainerVessel(addVoList);
			}
			
			//date changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyContainerVessel(modifyVoList);
			}
			
			manageContainerVesselIf(containerVesselVOs, usrId);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Container Vessel  multi event process(adding/changing)<br>
	 * 
	 * @param containerVesselVOs ContainerVesselVO[]
	 * @param usrId String
	 * @param rqstNo String
	 * @exception EventException
	 */
	public void manageContainerVesselRqst(ContainerVesselVO[] containerVesselVOs, String usrId, String rqstNo) throws EventException{
		try {
				List<ContainerVesselVO> addVoList = new ArrayList<ContainerVesselVO>();
				List<ContainerVesselVO> modifyVoList = new ArrayList<ContainerVesselVO>();
				
				containerVesselVOs[0].setRqstNo(rqstNo);
				
				if(containerVesselVOs[0].getIbflag().equals("I")) {
					containerVesselVOs[0].setCreUsrId(usrId);
					addVoList.add(containerVesselVOs[0]);

				} else if(containerVesselVOs[0].getIbflag().equals("U")) {
					containerVesselVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(containerVesselVOs[0]);
				}

			if(addVoList.size() > 0) {
				dbDao.addContainerVesselRqst(addVoList);
			}
			
			if(modifyVoList.size() > 0) {
				dbDao.modifyContainerVesselRqst(modifyVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Modify/save/delete event process<br>
	 * Container Vessel (BCM_CCD_0008.do) For EAI I/F process<br>
	 * 
	 * @param ContainerVesselVO[] containerVesselVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageContainerVesselIf(ContainerVesselVO[] containerVesselVOs, String usrId) throws EventException {		
		try {		
			ContainerVesselIfVO containervesselifVO = new ContainerVesselIfVO();
			String vsl_cntr_if_seq = "";
			
			//VSL_CNTR_IF_SEQ 채번
			vsl_cntr_if_seq = searchContainerVesselIfSeq();
			containervesselifVO.setVslCntrIfSeq(vsl_cntr_if_seq);

			containervesselifVO.setVslCd(containerVesselVOs[0].getVslCd());
			containervesselifVO.setVslClssFlg(containerVesselVOs[0].getVslClssFlg());
			containervesselifVO.setVslEngNm(containerVesselVOs[0].getVslEngNm());
			containervesselifVO.setVslLoclNm(containerVesselVOs[0].getVslLoclNm());
			containervesselifVO.setFoilCapa(containerVesselVOs[0].getFoilCapa());
			containervesselifVO.setDoilCapa(containerVesselVOs[0].getDoilCapa());
			containervesselifVO.setFrshWtrCapa(containerVesselVOs[0].getFrshWtrCapa());
			containervesselifVO.setCallSgnNo(containerVesselVOs[0].getCallSgnNo());
			containervesselifVO.setRgstNo(containerVesselVOs[0].getRgstNo());
			containervesselifVO.setPhnNo(containerVesselVOs[0].getPhnNo());
			containervesselifVO.setFaxNo(containerVesselVOs[0].getFaxNo());
			containervesselifVO.setTlxNo(containerVesselVOs[0].getTlxNo());
			containervesselifVO.setVslEml(containerVesselVOs[0].getVslEml());
			containervesselifVO.setPiclbDesc(containerVesselVOs[0].getPiclbDesc());
			containervesselifVO.setRgstPortCd(containerVesselVOs[0].getRgstPortCd());
			containervesselifVO.setClssNoRgstAreaNm(containerVesselVOs[0].getClssNoRgstAreaNm());
			containervesselifVO.setVslClssNo(containerVesselVOs[0].getVslClssNo());
			containervesselifVO.setVslBldrNm(containerVesselVOs[0].getVslBldrNm());
			containervesselifVO.setLoaLen(containerVesselVOs[0].getLoaLen());
			containervesselifVO.setLbpLen(containerVesselVOs[0].getLbpLen());
			containervesselifVO.setVslWdt(containerVesselVOs[0].getVslWdt());
			containervesselifVO.setVslDpth(containerVesselVOs[0].getVslDpth());
			containervesselifVO.setSmrDrftHgt(containerVesselVOs[0].getSmrDrftHgt());
			containervesselifVO.setDwtWgt(containerVesselVOs[0].getDwtWgt());
			containervesselifVO.setLgtShpTongWgt(containerVesselVOs[0].getLgtShpTongWgt());
			containervesselifVO.setGrsRgstTongWgt(containerVesselVOs[0].getGrsRgstTongWgt());
			containervesselifVO.setNetRgstTongWgt(containerVesselVOs[0].getNetRgstTongWgt());
			containervesselifVO.setPnmGtWgt(containerVesselVOs[0].getPnmGtWgt());
			containervesselifVO.setPnmNetTongWgt(containerVesselVOs[0].getPnmNetTongWgt());
			containervesselifVO.setSuzGtWgt(containerVesselVOs[0].getSuzGtWgt());
			containervesselifVO.setSuzNetTongWgt(containerVesselVOs[0].getSuzNetTongWgt());
			containervesselifVO.setMnEngMkrNm(containerVesselVOs[0].getMnEngMkrNm());
			containervesselifVO.setMnEngTpDesc(containerVesselVOs[0].getMnEngTpDesc());
			containervesselifVO.setMnEngBhpPwr(containerVesselVOs[0].getMnEngBhpPwr());
			containervesselifVO.setVslOwnIndCd(containerVesselVOs[0].getVslOwnIndCd());
			containervesselifVO.setVslRgstCntCd(containerVesselVOs[0].getVslRgstCntCd());
			containervesselifVO.setVslBldCd(containerVesselVOs[0].getVslBldCd());
			containervesselifVO.setCrrCd(containerVesselVOs[0].getCrrCd());
			containervesselifVO.setFdrDivCd(containerVesselVOs[0].getFdrDivCd());
			containervesselifVO.setVslSvcSpd(containerVesselVOs[0].getVslSvcSpd());
			containervesselifVO.setMaxSpd(containerVesselVOs[0].getMaxSpd());
			containervesselifVO.setEcnSpd(containerVesselVOs[0].getEcnSpd());
			containervesselifVO.setCrwKnt(containerVesselVOs[0].getCrwKnt());
			containervesselifVO.setCntrDznCapa(containerVesselVOs[0].getCntrDznCapa());
			containervesselifVO.setCntrOpCapa(containerVesselVOs[0].getCntrOpCapa());
			containervesselifVO.setCntrPnmCapa(containerVesselVOs[0].getCntrPnmCapa());
			containervesselifVO.setCntrVslClssCapa(containerVesselVOs[0].getCntrVslClssCapa());
			containervesselifVO.setRfRcptKnt(containerVesselVOs[0].getRfRcptKnt());
			containervesselifVO.setRfRcptMaxKnt(containerVesselVOs[0].getRfRcptMaxKnt());
			containervesselifVO.setFbdCapa(containerVesselVOs[0].getFbdCapa());
			containervesselifVO.setDplCapa(containerVesselVOs[0].getDplCapa());
			containervesselifVO.setBlstTnkCapa(containerVesselVOs[0].getBlstTnkCapa());
			containervesselifVO.setFoilCsm(containerVesselVOs[0].getFoilCsm());
			containervesselifVO.setDoilCsm(containerVesselVOs[0].getDoilCsm());
			containervesselifVO.setFrshWtrCsm(containerVesselVOs[0].getFrshWtrCsm());
			containervesselifVO.setMnEngRpmPwr(containerVesselVOs[0].getMnEngRpmPwr());
			containervesselifVO.setGnrRpmPwr(containerVesselVOs[0].getGnrRpmPwr());
			containervesselifVO.setVslHgt(containerVesselVOs[0].getVslHgt());
			containervesselifVO.setRgstDt(containerVesselVOs[0].getRgstDt());
			containervesselifVO.setVslEdiNm(containerVesselVOs[0].getVslEdiNm());
			containervesselifVO.setCoCd(containerVesselVOs[0].getCoCd());
			containervesselifVO.setVslClzDt(containerVesselVOs[0].getVslClzDt());
			containervesselifVO.setVslCreOfcCd(containerVesselVOs[0].getVslCreOfcCd());
			containervesselifVO.setVslDeltOfcCd(containerVesselVOs[0].getVslDeltOfcCd());
			containervesselifVO.setVslBldAreaNm(containerVesselVOs[0].getVslBldAreaNm());
			containervesselifVO.setGnrMkrNm(containerVesselVOs[0].getGnrMkrNm());
			containervesselifVO.setGnrTpDesc(containerVesselVOs[0].getGnrTpDesc());
			containervesselifVO.setGnrBhpPwr(containerVesselVOs[0].getGnrBhpPwr());
			containervesselifVO.setBwthstMkrNm(containerVesselVOs[0].getBwthstMkrNm());
			containervesselifVO.setBwthstTpDesc(containerVesselVOs[0].getBwthstTpDesc());
			containervesselifVO.setBwthstBhpPwr(containerVesselVOs[0].getBwthstBhpPwr());
			containervesselifVO.setBwthstRpmPwr(containerVesselVOs[0].getBwthstRpmPwr());
			containervesselifVO.setLloydNo(containerVesselVOs[0].getLloydNo());
			containervesselifVO.setVslLnchDt(containerVesselVOs[0].getVslLnchDt());
			containervesselifVO.setVslDeDt(containerVesselVOs[0].getVslDeDt());
			containervesselifVO.setVslKelLyDt(containerVesselVOs[0].getVslKelLyDt());
			containervesselifVO.setVslHlNo(containerVesselVOs[0].getVslHlNo());
			containervesselifVO.setTtlTeuKnt(containerVesselVOs[0].getTtlTeuKnt());
			containervesselifVO.setVslHtchKnt(containerVesselVOs[0].getVslHtchKnt());
			containervesselifVO.setVslHldKnt(containerVesselVOs[0].getVslHldKnt());
			containervesselifVO.setVslRmk(containerVesselVOs[0].getVslRmk());
			containervesselifVO.setIntlTongCertiFlg(containerVesselVOs[0].getIntlTongCertiFlg());
			containervesselifVO.setMadnVoySuzNetTongWgt(containerVesselVOs[0].getMadnVoySuzNetTongWgt());
			//containervesselifVO.setEaiEvntDt(containerVesselVOs[0].getEaiEvntDt());
			//containervesselifVO.setEaiIfId(containerVesselVOs[0].getEaiIfId());
			containervesselifVO.setModiVslCd(containerVesselVOs[0].getModiVslCd());
			containervesselifVO.setModiVslOprTpCd(containerVesselVOs[0].getModiVslOprTpCd());
			
			containervesselifVO.setCreUsrId(usrId);
			containervesselifVO.setUpdUsrId(usrId);
			containervesselifVO.setDeltFlg(containerVesselVOs[0].getDeltFlg());

			containervesselifVO.setEcomInsfId("OPECOM05");
			containervesselifVO.setOcediInsfId("OCEDI04");

			if(containerVesselVOs[0].getIbflag().equals("I")){
				containervesselifVO.setEcomInsfDvCd("I");
				containervesselifVO.setOcediInsfDvCd("I");
			}else if(containerVesselVOs[0].getIbflag().equals("U")){
				if(containerVesselVOs[0].getDeltFlg().equals("Y")){
					containervesselifVO.setEcomInsfDvCd("D");
					containervesselifVO.setOcediInsfDvCd("D");
				}else {
					containervesselifVO.setEcomInsfDvCd("U");
					containervesselifVO.setOcediInsfDvCd("U");
				}
			}

			dbDao.addContainerVesselIf(containervesselifVO);
			dbDao.addContainerVesselIbisIf(containervesselifVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}

	/**
	 * MDM_VSL_CNTR_IF EAI I/F 의 테이블(MDM_VSL_CNTR_IF)의 VSL_CNTR_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0018)<br>
	 * Container Vessel Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerVesselIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String vsl_cntr_if_seq = "";
        
        try {
            rowSet=dbDao.searchContainerVesselIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		vsl_cntr_if_seq = rowSet.getString(1);
            	}
            }
            return vsl_cntr_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
}