/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageBCImpl.java
*@FileTitle : Customer List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration.CustomerInfoManageDBDAO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustCoverTeamVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.MoreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamActivityInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustHistVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustPreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchKeyManVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerCodeGroupingVO;	// SHKIM 0215
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustomerGroupCodeVO;			// SHKIM 0215
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCustAddrVO;

/**
 * ALPS-GeneralInfoManage Business Logic Command Interface<br>
 * - ALPS-GeneralInfoManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author NAMKOONGJINHO
 * @see CustomerInfoManageBCImpl
 * @since J2EE 1.6
 */
public class CustomerInfoManageBCImpl extends BasicCommandSupport implements CustomerInfoManageBC {

	// Database Access Object
	private transient CustomerInfoManageDBDAO dbDao = null;

	/**
	 * CustomerInfoManageBCImpl 객체 생성<br>
	 * CustomerInfoManageDBDAO를 생성한다.<br>
	 */
	public CustomerInfoManageBCImpl() {
		dbDao = new CustomerInfoManageDBDAO();
	}
	
	/**
	 * ESM_SAM_0001 : Retrieve<br>
	 * Customer 정보를 조회<br><br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<SearchCustomerVO >
	 * @exception EventException
	 */
	public List<SearchCustomerVO > searchCustomerList(SearchCustomerVO  searchCustomerVO ) throws EventException {
		try {
			return dbDao.searchCustomerList(searchCustomerVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Basic Info 정보를 조회<br><br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<SearchCustomerVO >
	 * @exception EventException
	 */
	public List<SearchCustomerVO > searchCustomerInfo(SearchCustomerVO  searchCustomerVO ) throws EventException {
		try {
			return dbDao.searchCustomerInfo(searchCustomerVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * KeyMan 정보를 조회<br><br>
	 * 
	 * @param String  customerCode
	 * @return List<SearchKeyManVO >
	 * @exception EventException
	 */
	public List<SearchKeyManVO > searchKeyManList(String  customerCode ) throws EventException {
		try {
			return dbDao.searchKeyManList(customerCode);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Address 정보를 조회<br><br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<MdmCustAddrVO >
	 * @exception EventException
	 */
	public List<MdmCustAddrVO > searchAddressList(SearchCustomerVO  searchCustomerVO ) throws EventException {
		try {
			return dbDao.searchAddressList(searchCustomerVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Preference&Needs 정보를 조회<br><br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<SamCustPreInfoVO >
	 * @exception EventException
	 */
	public List<SamCustPreInfoVO > searchCustomerPreferenceInfo(SearchCustomerVO  searchCustomerVO )throws EventException {
		try {
			return dbDao.searchCustomerPreferenceInfo(searchCustomerVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Coverage Team 정보를 조회<br><br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<CustCoverTeamVO >
	 * @exception EventException
	 */
	public List<CustCoverTeamVO > searchCustCoverList(SearchCustomerVO  searchCustomerVO )throws EventException {
		try {
			return dbDao.searchCustCoverList(searchCustomerVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * Activity 정보를 조회<br><br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<SamActivityInfoVO >
	 * @exception EventException
	 */
	public List<SamActivityInfoVO > searchCustActvityList(SearchCustomerVO  searchCustomerVO )throws EventException {
		try {
			return dbDao.searchCustActvityList(searchCustomerVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * More Info 정보를 조회<br><br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<MoreInfoVO >
	 * @exception EventException
	 */
	public List<MoreInfoVO > searchMoreInfo(SearchCustomerVO  searchCustomerVO )throws EventException {
		try {
			return dbDao.searchMoreInfo(searchCustomerVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_SAM_0002 : Retrieve<br>
	 * History 정보를 조회<br><br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<SamCustHistVO >
	 * @exception EventException
	 */
	public List<SamCustHistVO > searchCustHistList(SearchCustomerVO  searchCustomerVO )throws EventException {
		try {
			return dbDao.searchCustHistList(searchCustomerVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	/**
	 * ESM_SAM_0010 : Retrieve<br>
	 * MDM_CUSTOMER 정보를 조회<br><br>
	 * 
	 * @param SearchCustomerCodeGroupingVO  searchCustomerCodeGroupingVO
	 * @return List<SearchCustomerCodeGroupingVO >
	 * @exception EventException
	 */
	public List<SearchCustomerCodeGroupingVO > searchCustomerCodeGrouping(SearchCustomerCodeGroupingVO  searchCustomerCodeGroupingVO )throws EventException {
		try {
			return dbDao.searchCustomerCodeGrouping(searchCustomerCodeGroupingVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	/**
	 * ESM_SAM_0903 : Retrieve<br>
	 * MDM_CUSTOMER 정보를 조회<br><br> 
	 * 
	 * @param CustomerGroupCodeVO  customerGroupCodeVO 
	 * @return List<CustomerGroupCodeVO >
	 * @exception EventException
	 */
	public List<CustomerGroupCodeVO> searchCustomerGroupCode(CustomerGroupCodeVO customerGroupCodeVO) throws EventException {
		try {
			return dbDao.searchCustomerGroupCode(customerGroupCodeVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
	}
	
	
	/**
	 * [ESM_SAM_0002]On_Change<br>
	 * CustCd 별 화면 권한 조회
	 * @param SearchCustomerVO searchCustomerVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String checkPermission(SearchCustomerVO searchCustomerVO, SignOnUserAccount account) throws EventException {

		try {
			searchCustomerVO.setUserId(account.getUsr_id());
			return dbDao.checkPermission(searchCustomerVO);
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	

	/**
	 * ESM_SAM_0002 : Save<br>
	 * Preference&Needs 정보를 추가, 변경, 삭제<br><br>
	 * 
	 * @param SamCustPreInfoVO[] samCustPreInfoVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void manageCustomerPreferenceInfo(SamCustPreInfoVO[] samCustPreInfoVOS, SignOnUserAccount account) throws EventException {
		
		try{
			List<SamCustPreInfoVO> insertVoList = new ArrayList<SamCustPreInfoVO>();
			List<SamCustPreInfoVO> updateVoList = new ArrayList<SamCustPreInfoVO>();
			List<SamCustPreInfoVO> deleteVoList = new ArrayList<SamCustPreInfoVO>();

			
			for(int i=0; i<samCustPreInfoVOS.length; i++){
				if(samCustPreInfoVOS[i].getIbflag().equals("I")){
					samCustPreInfoVOS[i].setUserId(account.getUsr_id());
					insertVoList.add(samCustPreInfoVOS[i]);
				}
				else if ( samCustPreInfoVOS[i].getIbflag().equals("U")){
					samCustPreInfoVOS[i].setUserId(account.getUsr_id());
					updateVoList.add(samCustPreInfoVOS[i]);
				}
				else if ( samCustPreInfoVOS[i].getIbflag().equals("D")){
					samCustPreInfoVOS[i].setUserId(account.getUsr_id());
					deleteVoList.add(samCustPreInfoVOS[i]);
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.addCustomerPreferenceInfo(insertVoList);
		}
		
		if(updateVoList.size() > 0){
			dbDao.modifyCustomerPreferenceInfo(updateVoList);
		}
		
		if(deleteVoList.size() > 0){
			dbDao.removeCustomerPreferenceInfo(deleteVoList);
		}
		
	}
	catch(DAOException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler(ex).getMessage());
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler(ex).getMessage());
    }
}
	
	

        
		
	/**
	 * ESM_SAM_0002 : Save<br>
	 * Coverage Team 정보를 추가, 변경, 삭제<br><br>
	 * 
	 * @param CustCoverTeamVO[] custCoverTeamVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCoverInfo(CustCoverTeamVO[] custCoverTeamVOS, SignOnUserAccount account) throws EventException {
		try{
			List<CustCoverTeamVO> insertVoList = new ArrayList<CustCoverTeamVO>();
			List<CustCoverTeamVO> updateVoList = new ArrayList<CustCoverTeamVO>();
			List<CustCoverTeamVO> deleteVoList = new ArrayList<CustCoverTeamVO>();
			
			for(int i=0; i<custCoverTeamVOS.length; i++){
				if(custCoverTeamVOS[i].getOpCd().equals("I")){
					custCoverTeamVOS[i].setUserId(account.getUsr_id());
					insertVoList.add(custCoverTeamVOS[i]);
				}
				else if ( custCoverTeamVOS[i].getOpCd().equals("U")){
					custCoverTeamVOS[i].setUserId(account.getUsr_id());
					updateVoList.add(custCoverTeamVOS[i]);
				}
				else if (custCoverTeamVOS[i].getOpCd().equals("D")){
					custCoverTeamVOS[i].setUserId(account.getUsr_id());
					deleteVoList.add(custCoverTeamVOS[i]);
				}
			}
			
			if(deleteVoList.size() > 0){
				dbDao.removeCustCoverInfo(deleteVoList);
			}
			
			if(insertVoList.size() > 0){
				dbDao.addCustCoverInfo(insertVoList);
			}
			
			if(updateVoList.size() > 0){
				dbDao.modifyCustCoverInfo(updateVoList);
			}
			
		}
		catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * More Info 정보를 변경<br><br>
	 * 
	 * @param MoreInfoVO[] moreInfoVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMoreInfo(MoreInfoVO[] moreInfoVOS, SignOnUserAccount account) throws EventException {
		
		try{
			List<MoreInfoVO> updateVoList = new ArrayList<MoreInfoVO>();

			for(int i=0; i<moreInfoVOS.length; i++){
				moreInfoVOS[i].setUserId(account.getUsr_id());
					updateVoList.add(moreInfoVOS[i]);
			}
				dbDao.modifyMoreInfo(updateVoList);
		}
		catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * History 정보를 추가<br><br>
	 * 
	 * @param SamCustHistVO samCustHistVO
	 * @param SignOnUserAccount account
	 * @param List<SearchCustomerVO> oldList
	 * @param List<SearchCustomerVO> newList
	 * @exception EventException
	 */
	public void manageCustHistList(SamCustHistVO samCustHistVO, SignOnUserAccount account, List<SearchCustomerVO> oldList,  List<SearchCustomerVO> newList) throws EventException {
		
		try{
			SearchCustomerVO oldCustomerInfo = oldList.get(0);
			SearchCustomerVO newCustomerInfo = newList.get(0);
			if(oldCustomerInfo != newCustomerInfo){
				
			
				String oldValues[] = new String[20];
				String newValues[] = new String[20];
				
				oldValues[0]  = oldCustomerInfo.getCustLglEngNm();
				oldValues[1]  = oldCustomerInfo.getOfcCd();
				oldValues[2]  = oldCustomerInfo.getCustStsCd();
				oldValues[3]  = oldCustomerInfo.getCustNm();
				oldValues[3]  = oldCustomerInfo.getSrepCd();
				oldValues[4]  = oldCustomerInfo.getCntrCustTpCd();
				oldValues[5]  = oldCustomerInfo.getIndivCorpDivCd();
				oldValues[6]  = oldCustomerInfo.getLocCd();
				oldValues[7]  = oldCustomerInfo.getCustRgstNo();
				oldValues[8]  = oldCustomerInfo.getKeyAcctFlg();
				oldValues[9]  = oldCustomerInfo.getCustGrpId();
				oldValues[10] = oldCustomerInfo.getMltTrdAcctFlg();
				oldValues[11] = oldCustomerInfo.getCreUsrId();
				oldValues[12] = oldCustomerInfo.getOfcEngNm();
				oldValues[13] = oldCustomerInfo.getSrepNm();
				oldValues[14] = oldCustomerInfo.getPhnNo();
				oldValues[15] = oldCustomerInfo.getFaxNo();
				oldValues[16] = oldCustomerInfo.getCustEml();
				oldValues[17] = oldCustomerInfo.getBzetAddr();
				oldValues[18] = oldCustomerInfo.getUsrNm();
				oldValues[19] = oldCustomerInfo.getCreOfcCd();
				
				newValues[0]  = newCustomerInfo.getCustLglEngNm();
				newValues[1]  = newCustomerInfo.getOfcCd();
				newValues[2]  = newCustomerInfo.getCustStsCd();
				newValues[3]  = newCustomerInfo.getCustNm();
				newValues[3]  = newCustomerInfo.getSrepCd();
				newValues[4]  = newCustomerInfo.getCntrCustTpCd();
				newValues[5]  = newCustomerInfo.getIndivCorpDivCd();
				newValues[6]  = newCustomerInfo.getLocCd();
				newValues[7]  = newCustomerInfo.getCustRgstNo();
				newValues[8]  = newCustomerInfo.getKeyAcctFlg();
				newValues[9]  = newCustomerInfo.getCustGrpId();
				newValues[10] = newCustomerInfo.getMltTrdAcctFlg();
				newValues[11] = newCustomerInfo.getCreUsrId();
				newValues[12] = newCustomerInfo.getOfcEngNm();
				newValues[13] = newCustomerInfo.getSrepNm();
				newValues[14] = newCustomerInfo.getPhnNo();
				newValues[15] = newCustomerInfo.getFaxNo();
				newValues[16] = newCustomerInfo.getCustEml();
				newValues[17] = newCustomerInfo.getBzetAddr();
				newValues[18] = newCustomerInfo.getUsrNm();
				newValues[19] = newCustomerInfo.getCreOfcCd();

				
				for( int i=0 ; i<newValues.length ; i++){
					
					if(oldValues[i].equals(newValues[i]) == false ){
						
						samCustHistVO.setUserId(account.getUsr_id());
						samCustHistVO.setACngItmCd(Integer.toString(i));
						samCustHistVO.setANewValDesc(newValues[i]);
						samCustHistVO.setAOldValDesc(oldValues[i]);
						dbDao.addCustHistList(samCustHistVO);
					}
				}
			}
		}
		catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * [ESM_SAM_0004] CustomerPFMCGroupDetail 조회<br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<SearchCustomerGrpVO >
	 * @exception EventException
	 */
	
	public List<SearchCustomerVO> searchCustomerPFMCGroupDetail(SearchCustomerVO searchCustomerVO) throws EventException {
		try {
			return dbDao.searchCustomerPFMCGroupDetail(searchCustomerVO);
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * [ESM_SAM_0004]On_Change<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchGroupCustomerName(SearchCustomerVO searchCustomerVO) throws EventException {

		try {
			return dbDao.searchGroupCustomerName(searchCustomerVO);
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	
	/**
	 * BCM_CCD_0035 : manage<br>
	 * Check Sales Rep Code 
	 * @param String custCd 
	 * @param String srepCd
	 * @return String
	 * @exception EventException
	 */
	public String checkSalesRepCode(String custCd, String srepCd) throws EventException {
		DBRowSet rowSet = null;
		String check = "";
		try {
			rowSet = dbDao.checkSalesRepCode(custCd, srepCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
	
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * BCM_CCD_0035 : manage<br>
	 * Manage Sales Rep Info 
	 * @param MdmCustomerVO[] mdmCustomerVOS
	 * @param String checkSalesRepCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSalesRepInfo(MdmCustomerVO[] mdmCustomerVOS, String checkSalesRepCd, SignOnUserAccount account)throws EventException {

		try{
			List<MdmCustomerVO> updateList = new ArrayList<MdmCustomerVO>();
			List<MdmCustomerVO> updateVoList = new ArrayList<MdmCustomerVO>();
			List<MdmCustomerVO> insertVoList = new ArrayList<MdmCustomerVO>();
			mdmCustomerVOS[0].setUpdUsrId(account.getUsr_id());
			mdmCustomerVOS[0].setCreUsrId(account.getUsr_id());

			updateList.add(mdmCustomerVOS[0]);
			dbDao.modifyPrimaryFlg(updateList);
			if(!checkSalesRepCd.equals("")){
				updateVoList.add(mdmCustomerVOS[0]);
				dbDao.modifyAfterPrimaryFlg(updateVoList);

			}else{
				insertVoList.add(mdmCustomerVOS[0]);
				dbDao.addPrimaryFlg(insertVoList);

			}

		}
		catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_SAM_0011 : Retrieve<br>
	 * Group Code에 해당하는 Customer Detail 정보를 조회합니다.<br>
	 * 
	 * @param CustomerGroupCodeVO customerGroupCodeVO
	 * @return List<CustomerGroupCodeVO>
	 * @exception EventException
	 */	
	public List<CustomerGroupCodeVO> searchCustomerGroupCodeDetail(CustomerGroupCodeVO customerGroupCodeVO)throws EventException {
		try {
			return dbDao.searchCustomerGroupCodeDetail(customerGroupCodeVO );
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
	}
	
	/**
	 * ESM_SAM_0001 : Save<br>
	 * 변경된 Sales Rep 정보를 저장한다.<br><br>
	 * 
	 * @param SearchCustomerVO[] searchCustomerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSalesRepAdjustment(SearchCustomerVO[] searchCustomerVOs, SignOnUserAccount account) throws EventException{
		try{
			List<SearchCustomerVO> updateVoList     = new ArrayList<SearchCustomerVO>();
			
			// Primary가 변경된 경우에는 MDM_customer Table의 sales rep을 변경해주어야 한다.
			for(int i=0; i<searchCustomerVOs.length; i++){
				if(searchCustomerVOs[i].getIbflag().equals("U") && !searchCustomerVOs[i].getSalesRep().equals(searchCustomerVOs[i].getPreSrepCd())){
					searchCustomerVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(searchCustomerVOs[i]);		
				}
			}
			
			if(updateVoList.size() > 0){
				dbDao.addSalesRepAdjustment(updateVoList);
			}
			
			if(updateVoList.size() > 0){
				dbDao.modifySalesRepAdjustment(updateVoList);
			}
			
		}
		catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	
	/**
	 * ESM_SAM_0001 : SAVE<br>
	 * 해당 Customer에 Primary Sales Rep이 있는지 확인.<br><br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return boolean
	 * @exception EventException
	 */
	public String checkPrmrySalesRep(SearchCustomerVO searchCustomerVO) throws EventException {
		DBRowSet rowSet = null;
		String srepCd = "";
		try {
			rowSet = dbDao.checkPrmrySalesRep(searchCustomerVO);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		srepCd = rowSet.getString(1);
            	}
            }
            return srepCd;
	
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}

}