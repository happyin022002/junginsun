/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommodityBCImpl.java
*@FileTitle : CommodityBCImpl
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.commodity.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.ccd.commoncode.commodity.integration.CommodityDBDAO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.CommodityVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.CustPackageTypeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.GrpCommodityVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.PackageTypeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.RepCommodityVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * common code Business Logic Command Interface<br>
 * An interface to the business logic for common code<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class CommodityBCImpl extends BasicCommandSupport implements CommodityBC {

	// Database Access Object
	private transient CommodityDBDAO dbDao = null;

	/**
	 * commodityBCImpl object creation<br>
	 * Generate commodityDBDAO.<br>
	 */
	public CommodityBCImpl() {
		dbDao = new CommodityDBDAO();
	}
	
	/**
	 * Group Commodity information retrieve<br>
	 * 
	 * @param String grpCmdtCd
	 * @return List<GrpCommodityVO>
	 * @exception EventException
	 */
	public List<GrpCommodityVO> searchGroupCommodity(String grpCmdtCd) throws EventException {
		try {
			return dbDao.searchGroupCommodity(grpCmdtCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Group Commodity  multi event process(adding /chainging)<br>
	 * 
	 * @param grpCmdtVOs GrpCommodityVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageGroupCommodity(GrpCommodityVO[] grpCmdtVOs, String usrId) throws EventException{
		try {
				List<GrpCommodityVO> addVoList = new ArrayList<GrpCommodityVO>();
				List<GrpCommodityVO> modifyVoList = new ArrayList<GrpCommodityVO>();

				if(grpCmdtVOs[0].getIbflag().equals("I")) {
					grpCmdtVOs[0].setCreUsrId(usrId);
					addVoList.add(grpCmdtVOs[0]);

				} else if(grpCmdtVOs[0].getIbflag().equals("U")) {
					grpCmdtVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(grpCmdtVOs[0]);
				}

			//data adding
			if(addVoList.size() > 0) {
				dbDao.addGroupCommodity(addVoList);
			}
			
			//date changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyGroupCommodity(modifyVoList);
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
	 * Rep Commodity information retrieve<br>
	 * 
	 * @param String repCmdtCd
	 * @return List<RepCommodityVO>
	 * @exception EventException
	 */
	public List<RepCommodityVO> searchRepCommodity(String repCmdtCd) throws EventException {
		try {
			return dbDao.searchRepCommodity(repCmdtCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Rep Commodity  multi event process(adding /chainging)<br>
	 * 
	 * @param repCmdtVOs RepCommodityVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageRepCommodity(RepCommodityVO[] repCmdtVOs, String usrId) throws EventException{
		try {
				List<RepCommodityVO> addVoList = new ArrayList<RepCommodityVO>();
				List<RepCommodityVO> modifyVoList = new ArrayList<RepCommodityVO>();

				if(repCmdtVOs[0].getIbflag().equals("I")) {
					repCmdtVOs[0].setCreUsrId(usrId);
					addVoList.add(repCmdtVOs[0]);

				} else if(repCmdtVOs[0].getIbflag().equals("U")) {
					repCmdtVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(repCmdtVOs[0]);
				}

			//data adding
			if(addVoList.size() > 0) {
				dbDao.addRepCommodity(addVoList);
			}
			
			//data changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyRepCommodity(modifyVoList);
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
	 * Commodity information retrieve<br>
	 * 
	 * @param String cmdtCd
	 * @return List<CommodityVO>
	 * @exception EventException
	 */
	public List<CommodityVO> searchCommodity(String cmdtCd) throws EventException {
		try {
			return dbDao.searchCommodity(cmdtCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Commodity information retrieve<br>
	 * 
	 * @param rqstNo String
	 * @return List<CommodityVO>
	 * @exception EventException
	 */
	public List<CommodityVO> searchCommodityRqst(String rqstNo) throws EventException {
		try {
			return dbDao.searchCommodityRqst(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Commodity  multi event process(adding /chainging)<br>
	 * 
	 * @param cmdtVOs CommodityVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCommodity(CommodityVO[] cmdtVOs, String usrId) throws EventException{
		try {
				List<CommodityVO> addVoList = new ArrayList<CommodityVO>();
				List<CommodityVO> modifyVoList = new ArrayList<CommodityVO>();

				if(cmdtVOs[0].getIbflag().equals("I")) {
					cmdtVOs[0].setCreUsrId(usrId);
					addVoList.add(cmdtVOs[0]);

				} else if(cmdtVOs[0].getIbflag().equals("U")) {
					cmdtVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(cmdtVOs[0]);
				}

			//data adding
			if(addVoList.size() > 0) {
				dbDao.addCommodity(addVoList);
			}
			
			//data changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyCommodity(modifyVoList);
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
	 * Commodity  multi event process(adding /chainging)<br>
	 * 
	 * @param cmdtVOs CommodityVO[]
	 * @param usrId String
	 * @param rqstNo String
	 * @exception EventException
	 */
	public void manageCommodityRqst(CommodityVO[] cmdtVOs, String usrId, String rqstNo) throws EventException{
		try {
				List<CommodityVO> addVoList = new ArrayList<CommodityVO>();
				List<CommodityVO> modifyVoList = new ArrayList<CommodityVO>();
				
				cmdtVOs[0].setRqstNo(rqstNo);
				
				if(cmdtVOs[0].getIbflag().equals("I")) {
					cmdtVOs[0].setCreUsrId(usrId);
					addVoList.add(cmdtVOs[0]);

				} else if(cmdtVOs[0].getIbflag().equals("U")) {
					cmdtVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(cmdtVOs[0]);
				}

			//data adding
			if(addVoList.size() > 0) {
				dbDao.addCommodityRqst(addVoList);
			}
			
			//data changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyCommodityRqst(modifyVoList);
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
	 * Customer Package Type information retrieve<br>
	 * 
	 * @param String pckCd
	 * @param String cstmsCntCd
	 * @return List<CustPackageTypeVO>
	 * @exception EventException
	 */
	public List<CustPackageTypeVO> searchCustPackageType(String pckCd, String cstmsCntCd) throws EventException {
		try {
			return dbDao.searchCustPackageType(pckCd, cstmsCntCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Customer Package Type  multi event process(adding /chainging)<br>
	 * 
	 * @param custPackTypeVOs CustPackageTypeVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCustPackageType(CustPackageTypeVO[] custPackTypeVOs, String usrId) throws EventException{
		try {
				List<CustPackageTypeVO> addVoList = new ArrayList<CustPackageTypeVO>();
				List<CustPackageTypeVO> modifyVoList = new ArrayList<CustPackageTypeVO>();

				if(custPackTypeVOs[0].getIbflag().equals("I")) {
					custPackTypeVOs[0].setCreUsrId(usrId);
					addVoList.add(custPackTypeVOs[0]);

				} else if(custPackTypeVOs[0].getIbflag().equals("U")) {
					custPackTypeVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(custPackTypeVOs[0]);
				}

			//data adding
			if(addVoList.size() > 0) {
				dbDao.addCustPackageType(addVoList);
			}
			
			//data changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyCustPackageType(modifyVoList);
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
	 * Package Type information retrieve<br>
	 * 
	 * @param String pckCd
	 * @return List<PackageTypeVO>
	 * @exception EventException
	 */
	public List<PackageTypeVO> searchPackageType(String pckCd) throws EventException {
		try {
			return dbDao.searchPackageType(pckCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Package Type  multi event process(adding /chainging)<br>
	 * 
	 * @param packTypeVOs PackageTypeVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void managePackageType(PackageTypeVO[] packTypeVOs, String usrId) throws EventException{
		try {
				List<PackageTypeVO> addVoList = new ArrayList<PackageTypeVO>();
				List<PackageTypeVO> modifyVoList = new ArrayList<PackageTypeVO>();

				if(packTypeVOs[0].getIbflag().equals("I")) {
					packTypeVOs[0].setCreUsrId(usrId);
					addVoList.add(packTypeVOs[0]);

				} else if(packTypeVOs[0].getIbflag().equals("U")) {
					packTypeVOs[0].setUpdUsrId(usrId);
					modifyVoList.add(packTypeVOs[0]);
				}

			//data adding
			if(addVoList.size() > 0) {
				dbDao.addPackageType(addVoList);
			}
			
			//data changing
			if(modifyVoList.size() > 0) {
				dbDao.modifyPackageType(modifyVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}