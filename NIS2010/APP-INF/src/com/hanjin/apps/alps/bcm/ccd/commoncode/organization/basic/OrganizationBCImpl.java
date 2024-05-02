/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : organizationBCImpl.java
*@FileTitle : organization
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.organization.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.basic.CcdCommonBC;
import com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.basic.CcdCommonBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.integration.OrganizationDBDAO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfcAccGrpMapVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfcAccGrpVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfficeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.organization.vo.OfficeIfVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Organization Business Logic Command Interface<br>
 * An interface to the business logic for organization<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class OrganizationBCImpl extends BasicCommandSupport implements OrganizationBC {

	// Database Access Object
	private transient OrganizationDBDAO dbDao = null;
	

	/**
	 * organizationBCImpl object creation<br>
	 * Generate organizationDBDAO.<br>
	 */
	public OrganizationBCImpl() {
		dbDao = new OrganizationDBDAO();
	}

	/**
	 * BCM_CCD_0041 : Retrieve <br>
	 * Office Access Group Creation should look up the information you entered<br>
	 * 
	 * @param String sybSysCd
	 * @param String accGrpId
	 * @return List<OfcAccGrpVO>
	 * @exception EventException
	 */ 
	public List<OfcAccGrpVO> searchOfcAccGrp(String sybSysCd, String accGrpId) throws EventException{
		try {						
			return dbDao.searchOfcAccGrp(sybSysCd,accGrpId);
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0041 : Save <br>
	 * Input and retrieved Office Access Group Creation will add and modify information
	 * 
	 * @param OfcAccGrpVO[] ofcAccGrpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfcAccGrp(OfcAccGrpVO[] ofcAccGrpVOs,SignOnUserAccount account) throws EventException {
		// Auto-generated method stub
			try {			
			List<OfcAccGrpVO> insertSheetVoList = new ArrayList<OfcAccGrpVO>();
			List<OfcAccGrpVO> updateSheetVoList = new ArrayList<OfcAccGrpVO>();	
			List<OfcAccGrpVO> deleteSheetVoList = new ArrayList<OfcAccGrpVO>();		
			List<OfcAccGrpMapVO> deleteSheetMapVoList = new ArrayList<OfcAccGrpMapVO>();	
			
			OfcAccGrpMapVO ofcAccGrpMapVO = new OfcAccGrpMapVO();		
				
				if(ofcAccGrpVOs != null)	{				
					for ( int i=0; i<ofcAccGrpVOs.length; i++ ) {
						if ( ofcAccGrpVOs[i].getIbflag().equals("D")){
							//removeOfcAccGrp VO
							deleteSheetVoList.add(ofcAccGrpVOs[i]);					
							//removeOfcAccGrpMap VO
							ofcAccGrpMapVO.setSubSysCd(ofcAccGrpVOs[i].getSubSysCd());
							ofcAccGrpMapVO.setOfcGrpId(ofcAccGrpVOs[i].getOfcGrpId());
							deleteSheetMapVoList.add(ofcAccGrpMapVO);
							
							dbDao.removeOfcAccGrpMap(deleteSheetMapVoList);
							dbDao.removeOfcAccGrp(deleteSheetVoList);
						}else if ( ofcAccGrpVOs[i].getIbflag().equals("I")){
							ofcAccGrpVOs[i].setCreUsrId(account.getUsr_id());
							ofcAccGrpVOs[i].setUpdUsrId(account.getUsr_id());
							insertSheetVoList.add(ofcAccGrpVOs[i]);	
							dbDao.addOfcAccGrp(ofcAccGrpVOs[i]);						
						}else if ( ofcAccGrpVOs[i].getIbflag().equals("U")){
							ofcAccGrpVOs[i].setUpdUsrId(account.getUsr_id());
							updateSheetVoList.add(ofcAccGrpVOs[i]);		
						}
					}	
				}

				if ( updateSheetVoList.size() > 0 ) {
					dbDao.modifyOfcAccGrp(updateSheetVoList);
				}			
			
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * BCM_CCD_0042 : Retrieve <br>
	 * Input and retrieved Office Access Group Mapping(Pop-up) Creation will add and modify information.<br>
	 * 
	 * @param String sybSysCd
	 * @param String ofcGrpId
	 * @return List<OfcAccGrpMapVO>
	 * @exception EventException
	 */ 
	public List<OfcAccGrpMapVO> searchOfcAccGrpMap(String sybSysCd, String ofcGrpId) throws EventException{
		// Auto-generated method stub
		try {						
			return dbDao.searchOfcAccGrpMap(sybSysCd,ofcGrpId);
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0042 : Save <br>
	 * Input and retrieved Office Access Group Mapping(Pop-up) will add and modify information
	 * 
	 * @param OfcAccGrpMapVO[] ofcAccGrpMapVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */

	public void manageOfcAccGrpMap(OfcAccGrpMapVO[] ofcAccGrpMapVOs, SignOnUserAccount account) throws EventException {
		//Auto-generated method stub
			try {			
			List<OfcAccGrpMapVO> insertSheetVoList = new ArrayList<OfcAccGrpMapVO>();
			List<OfcAccGrpMapVO> updateSheetVoList = new ArrayList<OfcAccGrpMapVO>();	
			List<OfcAccGrpMapVO> deleteSheetVoList = new ArrayList<OfcAccGrpMapVO>();		
			
				if(ofcAccGrpMapVOs != null)	{
					for ( int i=0; i<ofcAccGrpMapVOs .length; i++ ) {
						if ( ofcAccGrpMapVOs[i].getIbflag().equals("I")){
							ofcAccGrpMapVOs[i].setCreUsrId(account.getUsr_id());
							ofcAccGrpMapVOs[i].setUpdUsrId(account.getUsr_id());
							insertSheetVoList.add(ofcAccGrpMapVOs[i]);	
						}else if ( ofcAccGrpMapVOs[i].getIbflag().equals("U")){
							ofcAccGrpMapVOs[i].setUpdUsrId(account.getUsr_id());
							updateSheetVoList.add(ofcAccGrpMapVOs[i]);		
						}else if ( ofcAccGrpMapVOs[i].getIbflag().equals("D")){
							deleteSheetVoList.add(ofcAccGrpMapVOs[i]);		
						}
					}	
				}

				if ( deleteSheetVoList.size() > 0 ) {
					dbDao.removeOfcAccGrpMap(deleteSheetVoList);
				}
				
				if ( updateSheetVoList.size() > 0 ) {
					dbDao.modifyOfcAccGrpMap(updateSheetVoList);
				}
				
				if ( insertSheetVoList.size() > 0 ) {						
					dbDao.addOfcAccGrpMap(insertSheetVoList);
				}					
			
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * BCM_CCD_0032 : Retrieve<br>
	 * To office code to query information. <br>
	 * 
	 * @param String ofcCd
	 * @return OfcAccGrpMapVO
	 * @exception EventException
	 */ 
	public List<OfficeVO> searchOfcCode(String ofcCd) throws EventException{
		//Auto-generated method stub
		try {						
			return dbDao.searchOfcCode(ofcCd);
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * BCM_CCD_0032 : Save <br>
	 * Input and retrieved Organization will add and modify information.<br>
	 * 
	 * @param OfficeVO ofcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfcCode(OfficeVO ofcVO, SignOnUserAccount account) throws EventException {
		CcdCommonBC ccdCommonBC = new CcdCommonBCImpl();
			try {
				if(ofcVO != null){
						if ( ofcVO.getIbflag().equals("I")){
							ofcVO.setCreUsrId(account.getUsr_id());
							ofcVO.setUpdUsrId(account.getUsr_id());
							ofcVO.setVndrCntCd(ofcVO.getVndrCntCd());
							ofcVO.setVndrSeq(ofcVO.getVndrSeq());
							dbDao.addOfcCode(ofcVO);
							ccdCommonBC.sendOfcToMdm(ofcVO.getOfcCd(), account.getUsr_id(), "C");
						}else if (ofcVO.getIbflag().equals("U")){
							ofcVO.setVndrCntCd(ofcVO.getVndrCntCd());
							ofcVO.setVndrSeq(ofcVO.getVndrSeq());
							ofcVO.setUpdUsrId(account.getUsr_id());
							dbDao.modifyOfcCode(ofcVO);
							ccdCommonBC.sendOfcToMdm(ofcVO.getOfcCd(), account.getUsr_id(), "U");
						}
						
						//manageOfcIf(ofcVO, account.getUsr_id()); 2018.01.23 Table 없음 
				}
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	


	/**
	 * Modify/save/delete event process<br>
	 * Organization (BCM_CCD_0032.do) For EAI I/F process<br>
	 * 
	 * @param OfficeVO ofcVO
	 * @param String account
	 * @exception EventException
	 */
	public void manageOfcIf(OfficeVO ofcVO,String account) throws EventException {		
		try {		
			OfficeIfVO officeifVO = new OfficeIfVO();
			String ofc_if_seq = "";
			
			//OFC_IF_SEQ 채번
			ofc_if_seq = searchOfcIfSeq();
			officeifVO.setOfcIfSeq(ofc_if_seq);

			officeifVO.setOfcCd(ofcVO.getOfcCd());
			officeifVO.setOfcEngNm(ofcVO.getOfcEngNm());
			officeifVO.setOfcLoclNm(ofcVO.getOfcLoclNm());
			officeifVO.setOfcAddr(ofcVO.getOfcAddr());
			officeifVO.setOfcZipCd(ofcVO.getOfcZipCd());
			officeifVO.setOfcKndCd(ofcVO.getOfcKndCd());
			officeifVO.setAgnKndCd(ofcVO.getAgnKndCd());
			officeifVO.setVndrCntCd(ofcVO.getVndrCntCd());
			officeifVO.setVndrSeq(ofcVO.getVndrSeq());
			officeifVO.setIntlPhnNo(ofcVO.getIntlPhnNo());
			officeifVO.setOfcPhnNo(ofcVO.getOfcPhnNo());
			officeifVO.setIntlFaxNo(ofcVO.getIntlFaxNo());
			officeifVO.setOfcFaxNo(ofcVO.getOfcFaxNo());
			officeifVO.setOfcRmk(ofcVO.getOfcRmk());
			officeifVO.setLocCd(ofcVO.getLocCd());
			officeifVO.setBilCurrCd(ofcVO.getBilCurrCd());
			officeifVO.setArCurrCd(ofcVO.getArCurrCd());
			officeifVO.setArCtrCd(ofcVO.getArCtrCd());
			officeifVO.setPrntOfcCd(ofcVO.getPrntOfcCd());
			officeifVO.setOpnDt(ofcVO.getOpnDt());
			officeifVO.setClzDt(ofcVO.getClzDt());
			officeifVO.setFincRgnCd(ofcVO.getFincRgnCd());
			officeifVO.setArOfcCd(ofcVO.getArOfcCd());
			officeifVO.setArHdQtrOfcCd(ofcVO.getArHdQtrOfcCd());
			officeifVO.setIbCrTermDys(ofcVO.getIbCrTermDys());
			officeifVO.setObCrTermDys(ofcVO.getObCrTermDys());
			officeifVO.setRepCustCntCd(ofcVO.getRepCustCntCd());
			officeifVO.setRepCustSeq(ofcVO.getRepCustSeq());
			officeifVO.setInvPfxCd(ofcVO.getInvPfxCd());
			officeifVO.setApOfcCd(ofcVO.getApOfcCd());
			officeifVO.setApCtrlOfcCd(ofcVO.getApCtrlOfcCd());
			officeifVO.setApCtrCd(ofcVO.getApCtrCd());
			officeifVO.setFxCurrRt(ofcVO.getFxCurrRt());
			officeifVO.setAsaCrTermDys(ofcVO.getAsaCrTermDys());
			officeifVO.setSoIfCd(ofcVO.getSoIfCd());
			officeifVO.setSlsOfcDivCd(ofcVO.getSlsOfcDivCd());
			officeifVO.setModiOfcCd(ofcVO.getModiOfcCd());
			officeifVO.setOfcCmmcCd(ofcVO.getOfcCmmcCd());
			officeifVO.setOfcTpCd(ofcVO.getOfcTpCd());
			officeifVO.setOfcUrl(ofcVO.getOfcUrl());
			officeifVO.setOfcRepEml(ofcVO.getOfcRepEml());
			officeifVO.setOfcSlsDeltFlg(ofcVO.getOfcSlsDeltFlg());
			officeifVO.setSubsCoFlg(ofcVO.getSubsCoFlg());
			officeifVO.setGlCtrCd(ofcVO.getGlCtrCd());
			officeifVO.setOfcLoclLangAddr(ofcVO.getOfcLoclLangAddr());
			officeifVO.setPpdPtyTpCd(ofcVO.getPpdPtyTpCd());
			//officeifVO.setModiCltOfcCd(ofcVO.getModiCltOfcCd());
			//officeifVO.setModiCtrlOfcCd(ofcVO.getModiCtrlOfcCd());
			
			officeifVO.setCreUsrId(account);
			officeifVO.setUpdUsrId(account);
			officeifVO.setDeltFlg(ofcVO.getDeltFlg());

			officeifVO.setEcomInsfId("OPECOM06");
			if("Y".equals(ofcVO.getEdiIfFlg())||"Y".equals(ofcVO.getDeltFlg())){
				officeifVO.setOpediInsfId("OPEDI02");
			}else{
				officeifVO.setOpediInsfId("");
			}
			

			if(ofcVO.getIbflag().equals("I")){
				officeifVO.setEcomInsfDvCd("I");
				officeifVO.setOpediInsfDvCd("I");
			}else if(ofcVO.getIbflag().equals("U")){
				if(ofcVO.getDeltFlg().equals("Y")){
					officeifVO.setEcomInsfDvCd("D");
					officeifVO.setOpediInsfDvCd("D");
				}else {
					officeifVO.setEcomInsfDvCd("U");
					officeifVO.setOpediInsfDvCd("U");
				}
			}

			dbDao.addOfcIf(officeifVO);
			dbDao.addOfcIbisIf(officeifVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}

	/**
	 * Organization EAI I/F 의 테이블(MDM_ORGANIZATION_IF)의 OFC_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0032)<br>
	 * Organization Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String ste_if_seq = "";
        
        try {
            rowSet=dbDao.searchOfcIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		ste_if_seq = rowSet.getString(1);
            	}
            }
            return ste_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
}