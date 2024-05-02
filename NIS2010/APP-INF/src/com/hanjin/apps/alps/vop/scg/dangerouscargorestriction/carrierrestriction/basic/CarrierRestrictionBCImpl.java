/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionBCImpl.java
*@FileTitle : VSL OPR's Restriction on DG (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.09 장강철
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2012.04.20 서석진 [CHM-201216960-01] Vessl Operator내 파일첨부 기능 추가
* 처리내역 :첨부파일 팝업화면과 팝업화면에서 파일등록,삭제 기능 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration.CarrierRestrictionDBDAO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.FileVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.PortRestrictionOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.ScgImdgCrrRstrVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.VopScg0009ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-DangerousCargoRestriction Business Logic Basic Command implementation<br>
 * - ALPS-DangerousCargoRestriction에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0009EventResponse,CarrierRestrictionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CarrierRestrictionBCImpl extends BasicCommandSupport implements CarrierRestrictionBC {

	// Database Access Object
	private transient CarrierRestrictionDBDAO dbDao = null;

	/**
	 * CarrierRestrictionBCImpl 객체 생성<br>
	 * CarrierRestrictionDBDAO를 생성한다.<br>
	 */
	public CarrierRestrictionBCImpl() {
		dbDao = new CarrierRestrictionDBDAO();
	}
 
	
    /**
     * 
     * VOP_SCG_0009 Carrier Restiction SAVE 처리 <br>
     * 
     * @param  CarrierRestrictionOptionVO carrierRestrictionOptionVO
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void manageCarrierRestriction(CarrierRestrictionOptionVO carrierRestrictionOptionVO, SignOnUserAccount signOnUserAccount)
			throws EventException {

		List<CarrierRestrictionVO> returnVoList = 	new ArrayList<CarrierRestrictionVO>();
		VopScg0009ConditionVO cond = carrierRestrictionOptionVO.getCondition();
		try {
			List<CarrierRestrictionVO> insertVoList = new ArrayList<CarrierRestrictionVO>();
			List<CarrierRestrictionVO> updateVoList = new ArrayList<CarrierRestrictionVO>();
			List<CarrierRestrictionVO> deleteVoList = new ArrayList<CarrierRestrictionVO>();
			
			String optClass = cond.getOptclass();
			CarrierRestrictionVO[] pCarrierRestrictionVO = null;
			String sImdgUnNoNullCheck  = "";
			if( cond.getOptclass().equals("class")  ){
				pCarrierRestrictionVO = carrierRestrictionOptionVO.getClassCarrierRestrictionVOs();
				sImdgUnNoNullCheck = "Y";
			}
			if( cond.getOptclass().equals("unno")  ){
				pCarrierRestrictionVO = carrierRestrictionOptionVO.getUnnoCarrierRestrictionVOs();				
			}
			 
			//2015.08.17 Secure Coding 적용 [CWE-476] Null Dereferencing
			if(pCarrierRestrictionVO != null){
				for ( int i=0; i<pCarrierRestrictionVO .length; i++ ) {
					pCarrierRestrictionVO[i].setVslOprTpCd( cond.getCrrCd() );
	 
					if ( pCarrierRestrictionVO[i].getIbflag().equals("U")){
						pCarrierRestrictionVO[i].setUpdUsrId(signOnUserAccount.getUsr_id());
						updateVoList.add(pCarrierRestrictionVO[i]);
					} else if ( pCarrierRestrictionVO[i].getIbflag().equals("D")){
						deleteVoList.add(pCarrierRestrictionVO[i]);
					}
				}
				 
	 
	 
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyCarrierRestriction(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeCarrierRestriction(deleteVoList, optClass);
				}
	            for ( int i=0; i<pCarrierRestrictionVO .length; i++ ) {
	                pCarrierRestrictionVO[i].setVslOprTpCd( cond.getCrrCd() );
	                if ( pCarrierRestrictionVO[i].getIbflag().equals("I")){
	        
	                    pCarrierRestrictionVO[i].setCreUsrId(signOnUserAccount.getUsr_id());
	                    pCarrierRestrictionVO[i].setImdgUnNoNull(   sImdgUnNoNullCheck  );
	                    List<CarrierRestrictionVO> checkRestrictionVO 
	                                           =   dbDao.getImdgCrrRstrVO( pCarrierRestrictionVO[i]  );
	                    //imdg_un_no_null
	                    /****************************Carrier Seq 추출.***********************************/
	                    if( checkRestrictionVO.size() == 0  ){
	                        pCarrierRestrictionVO[i].setImdgCrrRstrSeq( dbDao.getImdgCrrRstrSeq(  pCarrierRestrictionVO[i].getVslOprTpCd()  ) );
	                    }else{
	                        carrierRestrictionOptionVO.setMsgCode("SCG50005");
	                        carrierRestrictionOptionVO.setMsgCodeNm(pCarrierRestrictionVO[i].getImdgCrrRstrExptCd()+"|"+pCarrierRestrictionVO[i].getSlanCd()+"|");
	                        return;  
	                    }
	                    dbDao.addCarrierRestriction(pCarrierRestrictionVO[i]);                  
	                    insertVoList.add(pCarrierRestrictionVO[i]);
	                }
	                if ( !pCarrierRestrictionVO[i].getIbflag().equals("D")   ){
	                    pCarrierRestrictionVO[i].setIbflag("R");
	                    returnVoList.add(pCarrierRestrictionVO[i]);
	                }                
	            }
			}			
			
            carrierRestrictionOptionVO.setList(returnVoList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Carrier Restiction"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Carrier Restiction"}).getMessage(), ex);
        }
		
		
	}
 
    /**
     * 
     * Carrier Restirction 메인 조회 <br>
     *
     * @param  CarrierRestrictionOptionVO carrierRestrictionOptionVO
     * @return List<CarrierRestrictionVO>
     * @throws EventException
     */
	public List<CarrierRestrictionVO>  searchCarrierRestriction(CarrierRestrictionOptionVO carrierRestrictionOptionVO) throws EventException {
 
		VopScg0009ConditionVO vopScg0009ConditionVO = carrierRestrictionOptionVO.getCondition();
 
		try {
             return dbDao.searchCarrierRestriction( vopScg0009ConditionVO );        
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restiction"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restiction"}).getMessage(), ex);
        }
        
	}	 
 
    /**
     * Port & VSL OPR’s Carrier Restriction En-route 메인 조회 <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<ScgImdgCrrRstrVO> 
     * @throws EventException
     */ 
    public List<ScgImdgCrrRstrVO> searchCarrierEnRouteList(
            PortRestrictionOptionVO portRestrictionOptionVO) throws EventException {
        try {
            return dbDao.searchCarrierEnRouteList(portRestrictionOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restriction En-route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restriction En-route"}).getMessage(), ex);
        }
    }

    /**
     * Port & VSL OPR’s Port Restriction En-route 메인 조회 <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<PortRestrictionOptionVO> 
     * @throws EventException
     */ 
    public List<PortRestrictionOptionVO> searchPortEnRouteList(
            PortRestrictionOptionVO portRestrictionOptionVO) throws EventException {
        try {
            return dbDao.searchPortEnRouteList(portRestrictionOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port & VSL OPR’s Port Restriction En-route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port & VSL OPR’s Port Restriction En-route"}).getMessage(), ex);
        }
    }

    /**
     * Port & VSL OPR’s Port Restriction En-route 메인 조회 <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<PortRestrictionOptionVO> 
     * @throws EventException
     */ 
    public List<PortRestrictionOptionVO> searchPortRotnSeq(
            PortRestrictionOptionVO portRestrictionOptionVO) throws EventException {
        try {
            return dbDao.searchPortRotnSeq(portRestrictionOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port & VSL OPR’s Port Restriction En-route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port & VSL OPR’s Port Restriction En-route"}).getMessage(), ex);
        }
    }
    
    /**
	 * Vessel Operator's Restriction on DG file 을 조회 합니다. <br>
	 * 
	 * @param  String vslOprTpCd
	 * @return List<FileVO>
	 * @exception EventException
	 */
	public List<FileVO> searchFileList(String vslOprTpCd) throws EventException {
		try {
			return dbDao.searchFileList(vslOprTpCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
        }
	}

	/**
	 * Vessel Operator's Restriction on DG file 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param FileVO[] fileVOs
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFile(FileVO[] fileVOs, List<String> keys, SignOnUserAccount account) throws EventException{
		try {
			//FILE UPLOAD KEY값
			Iterator<String> keyArr = null;			
			if(keys != null) keyArr = keys.iterator();

			List<FileVO> insertVoList = new ArrayList<FileVO>();			
			List<FileVO> deleteVoList = new ArrayList<FileVO>();

			for ( int i=0; i<fileVOs.length; i++ ) {
				//FILE UPLOAD KEY값 SETTING하기
				if(keyArr != null) {
					if("Y".equals(fileVOs[i].getFileSetYn()) && keyArr.hasNext()) 
						fileVOs[i].setFileSavId(keyArr.next());	 
				}
				
				if ( fileVOs[i].getIbflag().equals("I")){
					String maxSeq = searchFileSeq(fileVOs[i].getVslOprTpCd());
					int seq = Integer.parseInt(maxSeq)+i;
					fileVOs[i].setCreUsrId(account.getUsr_id());
					fileVOs[i].setUpdUsrId(account.getUsr_id());
					fileVOs[i].setImdgCrrRstrFileSeq(seq+"");
					
					insertVoList.add(fileVOs[i]); 				
				} else if ( fileVOs[i].getIbflag().equals("D")){
					fileVOs[i].setUpdUsrId(account.getUsr_id());
					
					deleteVoList.add(fileVOs[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeFile(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addFile(insertVoList);
			}

			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
        }
	}
	

	/**
	 * 첨부파일 이름 검색<br>

	 * @param String crrCd
     * @return String
     * @throws EventException
     */
	public String searchFileName(String crrCd) throws EventException {
		try {
			return dbDao.searchFileName(crrCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 첨부파일의 max seq 값을 검색<br>

	 * @param String vslOprTpCd
     * @return String
     * @throws EventException
     */
	public String searchFileSeq(String vslOprTpCd) throws EventException {
		try {
			return dbDao.searchFileSeq(vslOprTpCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",new String[]{"Vessel Operator's Restriction on DG"}).getMessage(), ex);
		}
	}
	

	
}
 