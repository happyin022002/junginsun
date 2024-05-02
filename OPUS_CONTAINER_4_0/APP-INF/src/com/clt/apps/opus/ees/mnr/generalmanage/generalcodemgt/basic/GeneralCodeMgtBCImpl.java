/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtBCImpl.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.integration.GeneralCodeMgtDBDAO;
import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.vo.CustomMnrGenCdVO;
import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.vo.GeneralCodeMgtGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.management.opus.codemanagement.vo.CodeMgmtDtlVO;
import com.clt.syscommon.management.opus.codemanagement.vo.CodeMgmtMstVO;
        
/**
 * COM-GeneralManage Business Logic Basic Command implementation<br>
 * - COM-GeneralManage for business logic dispose<br>
 *
 * @author
 * @see Ees_mnr_0009EventResponse,CEDEXCodeMgtBC, DAO Class
 * @since J2EE 1.4   
 */        
    
public class GeneralCodeMgtBCImpl extends BasicCommandSupport implements GeneralCodeMgtBC {

	// Database Access Object
	private transient GeneralCodeMgtDBDAO dbDao = null; 

	/** 
	 * GeneralCodeMgtBCImpl creating object<br>
	 * GeneralCodeMgtDBDAO creating object<br>
	 */    
	public GeneralCodeMgtBCImpl() {  
		dbDao = new GeneralCodeMgtDBDAO();
	}

	/**
	 * [EES_MNR_0009]Retrieving "M&R Other Code" data<br>
	 *
	 * @param GeneralCodeMgtGRPVO generalCodeMgtGRPVO
	 * @return GeneralCodeMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeMgtGRPVO searchGeneralCodeListBasic(GeneralCodeMgtGRPVO generalCodeMgtGRPVO) throws EventException {
		try { 
			//Retrieving multi data
			List<List<CustomMnrGenCdVO>> listCustomMnrGenCdVOs = new ArrayList<List<CustomMnrGenCdVO>>();
			
			generalCodeMgtGRPVO.getGeneralCodeMgtINVO().setMnrCdGrpNo("1");
			List<CustomMnrGenCdVO> customMnrGenCdV0 = dbDao.searchGeneralCodeListData(generalCodeMgtGRPVO.getGeneralCodeMgtINVO());
//			generalCodeMgtGRPVO.getGeneralCodeMgtINVO().setMnrCdGrpNo("2");
//			List<CustomMnrGenCdVO> customMnrGenCdV1 = dbDao.searchGeneralCodeListData(generalCodeMgtGRPVO.getGeneralCodeMgtINVO());
//			generalCodeMgtGRPVO.getGeneralCodeMgtINVO().setMnrCdGrpNo("3");
//			List<CustomMnrGenCdVO> customMnrGenCdV2 = dbDao.searchGeneralCodeListData(generalCodeMgtGRPVO.getGeneralCodeMgtINVO());
		                                        
			listCustomMnrGenCdVOs.add(customMnrGenCdV0);      
//			listCustomMnrGenCdVOs.add(customMnrGenCdV1);      
//			listCustomMnrGenCdVOs.add(customMnrGenCdV2);      
			                      
			generalCodeMgtGRPVO.setListCustomMnrGenCdVOs(listCustomMnrGenCdVOs);   
			return generalCodeMgtGRPVO;
			
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] searchGeneralCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] searchGeneralCodeListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0009]Retrieving "M&R Other Code" data<br>
	 *
	 * @param GeneralCodeMgtGRPVO generalCodeMgtGRPVO
	 * @return GeneralCodeMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeMgtGRPVO searchGeneralCodeBasic(GeneralCodeMgtGRPVO generalCodeMgtGRPVO) throws EventException {
		try { 
			//Retrieving multi data
			List<List<CustomMnrGenCdVO>> listCustomMnrGenCdVOs = new ArrayList<List<CustomMnrGenCdVO>>();
			
			List<CustomMnrGenCdVO> customMnrGenCdV0 = dbDao.searchGeneralCodeData(generalCodeMgtGRPVO.getGeneralCodeMgtINVO());                                        
			listCustomMnrGenCdVOs.add(customMnrGenCdV0);                        
			generalCodeMgtGRPVO.setListCustomMnrGenCdVOs(listCustomMnrGenCdVOs);   
			return generalCodeMgtGRPVO;
			
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] searchGeneralCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] searchGeneralCodeListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0009]Adding, modifying, deleting "M&R Other Code" data<br>
	 *
	 * @param GeneralCodeMgtGRPVO generalCodeMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGeneralCodeBasic(GeneralCodeMgtGRPVO generalCodeMgtGRPVO, SignOnUserAccount account) throws EventException{
		try {
			List<CustomMnrGenCdVO> insertVoList = new ArrayList<CustomMnrGenCdVO>();
			List<CustomMnrGenCdVO> updateVoList = new ArrayList<CustomMnrGenCdVO>();
			List<CustomMnrGenCdVO> deleteVoList = new ArrayList<CustomMnrGenCdVO>();

			for ( int i=0; i<generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs() .length; i++ ) {
				if ( generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].getIbflag().equals("I")){
					generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].setCreUsrId(account.getUsr_id());
					generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i]);
				} else if ( generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].getIbflag().equals("U")){
					generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i]);
				} else if ( generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i].getIbflag().equals("D")){
					deleteVoList.add(generalCodeMgtGRPVO.getArrayCustomMnrGenCdVOs()[i]);
				} 
			}  
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addGeneralCodeData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyGeneralCodeData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeGeneralCodeData(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] manageGeneralCodeBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] manageGeneralCodeBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0009]Adding, modifying, deleting "M&R Manage Code" data<br>
	 *
	 * @param List<CodeMgmtMstVO> codeMgmtMstVOs
	 * @exception EventException
	 */
	@Override
	public void manageIntgCdToMnrBasic(List<CodeMgmtMstVO> codeMgmtMstVOs) throws EventException {
		try {
			List<CustomMnrGenCdVO> insertVoList = new ArrayList<CustomMnrGenCdVO>();
			List<CustomMnrGenCdVO> updateVoList = new ArrayList<CustomMnrGenCdVO>();
			List<CustomMnrGenCdVO> deleteVoList = new ArrayList<CustomMnrGenCdVO>();
			
			int mnrCdDpSeq = Integer.parseInt(dbDao.searchMnrCdSeqData("SC"))+1;
			for(int i=0; i<codeMgmtMstVOs.size(); i++){
				CustomMnrGenCdVO customMnrGenCdVO = new CustomMnrGenCdVO();
				CodeMgmtMstVO codeMgmtMstVO = codeMgmtMstVOs.get(i);
				if("MNR".equals(codeMgmtMstVO.getOwnrSubSysCd())){
					if("I".equals(codeMgmtMstVO.getIbflag())){
						customMnrGenCdVO.setMnrCdId(codeMgmtMstVO.getIntgCdId());
						customMnrGenCdVO.setPrntCdId("SC");
						customMnrGenCdVO.setMnrCdDesc(codeMgmtMstVO.getIntgCdNm());
						customMnrGenCdVO.setMnrCdDpDesc(codeMgmtMstVO.getIntgCdNm());
						mnrCdDpSeq = mnrCdDpSeq + i;
						customMnrGenCdVO.setMnrCdDpSeq(mnrCdDpSeq+"");
						customMnrGenCdVO.setPairCdId(codeMgmtMstVO.getIntgCdId());
						customMnrGenCdVO.setPairCdDpDesc(codeMgmtMstVO.getIntgCdNm());
						customMnrGenCdVO.setPairCdDesc(codeMgmtMstVO.getIntgCdNm());
						customMnrGenCdVO.setPairRefCd("SC");
						customMnrGenCdVO.setPairDpSeq(mnrCdDpSeq+"");
						customMnrGenCdVO.setMnrCdGrpNo("2");
						customMnrGenCdVO.setMnrCdGrpTpCd("OT");
						customMnrGenCdVO.setAgmtUseFlg("N");
						customMnrGenCdVO.setDeltFlg("N");
						customMnrGenCdVO.setCreUsrId(codeMgmtMstVO.getCreUsrId());
						customMnrGenCdVO.setUpdUsrId(codeMgmtMstVO.getUpdUsrId());
						insertVoList.add(customMnrGenCdVO);
					}
					else if("U".equals(codeMgmtMstVO.getIbflag())){
						customMnrGenCdVO.setMnrCdDesc(codeMgmtMstVO.getIntgCdNm());
						customMnrGenCdVO.setMnrCdDpDesc(codeMgmtMstVO.getIntgCdNm());
						customMnrGenCdVO.setPairCdDpDesc(codeMgmtMstVO.getIntgCdNm());
						customMnrGenCdVO.setPairCdDesc(codeMgmtMstVO.getIntgCdNm());
						customMnrGenCdVO.setPairCdId(codeMgmtMstVO.getIntgCdId());
						customMnrGenCdVO.setPairRefCd("SC");
						customMnrGenCdVO.setMnrCdGrpNo("2");
						customMnrGenCdVO.setUpdUsrId(codeMgmtMstVO.getUpdUsrId());
						updateVoList.add(customMnrGenCdVO);
					}
					else if("D".equals(codeMgmtMstVO.getIbflag())){
						customMnrGenCdVO.setPairCdId(codeMgmtMstVO.getIntgCdId());
						customMnrGenCdVO.setPairRefCd("SC");
						customMnrGenCdVO.setMnrCdGrpNo("2");
						deleteVoList.add(customMnrGenCdVO);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addGeneralCodeData(insertVoList);;
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyIntgCdToMnrCdData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeIntgCdToMnrCdData(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] manageGeneralCodeBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] manageGeneralCodeBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0009]Adding, modifying, deleting "M&R Manage Code" data<br>
	 *
	 * @param List<CodeMgmtDtlVO> codeMgmtDtlVOs
	 * @exception EventException
	 */
	@Override
	public void manageIntgDtlCdToMnrBasic(List<CodeMgmtDtlVO> codeMgmtDtlVOs) throws EventException {
		try {
			List<CustomMnrGenCdVO> insertVoList = new ArrayList<CustomMnrGenCdVO>();
			List<CustomMnrGenCdVO> updateVoList = new ArrayList<CustomMnrGenCdVO>();
			List<CustomMnrGenCdVO> deleteVoList = new ArrayList<CustomMnrGenCdVO>();
			for(int i=0; i<codeMgmtDtlVOs.size(); i++){
				CustomMnrGenCdVO customMnrGenCdVO = new CustomMnrGenCdVO();
				CodeMgmtDtlVO CodeMgmtDtlVO = codeMgmtDtlVOs.get(i);
				String module = dbDao.searchIntgCdModuleData(CodeMgmtDtlVO.getIntgCdId());
				
				if("MNR".equals(module)){
					if("I".equals(CodeMgmtDtlVO.getIbflag())){
						customMnrGenCdVO.setMnrCdId(CodeMgmtDtlVO.getIntgCdValCtnt());
						customMnrGenCdVO.setPrntCdId(dbDao.searchMnrCdData(CodeMgmtDtlVO.getIntgCdId()));
						customMnrGenCdVO.setMnrCdDesc(CodeMgmtDtlVO.getIntgCdValDesc());
						customMnrGenCdVO.setMnrCdDpDesc(CodeMgmtDtlVO.getIntgCdValDpDesc());
						int mnrCdDpSeq = Integer.parseInt(dbDao.searchMnrCdSeqData(customMnrGenCdVO.getPrntCdId()))+1;
						if("".equals(CodeMgmtDtlVO.getIntgCdValDpSeq())||CodeMgmtDtlVO.getIntgCdValDpSeq()==null){
							customMnrGenCdVO.setMnrCdDpSeq(mnrCdDpSeq+"");
							customMnrGenCdVO.setPairDpSeq(mnrCdDpSeq+"");
						}else{
							customMnrGenCdVO.setMnrCdDpSeq(CodeMgmtDtlVO.getIntgCdValDpSeq());
							customMnrGenCdVO.setPairDpSeq(CodeMgmtDtlVO.getIntgCdValDpSeq());
						}
						customMnrGenCdVO.setPairCdId(CodeMgmtDtlVO.getIntgCdValCtnt());
						customMnrGenCdVO.setPairCdDpDesc(CodeMgmtDtlVO.getIntgCdValDpDesc());
						customMnrGenCdVO.setPairCdDesc(CodeMgmtDtlVO.getIntgCdValDesc());
						customMnrGenCdVO.setPairRefCd(CodeMgmtDtlVO.getIntgCdId());
						
						customMnrGenCdVO.setMnrCdGrpNo("3");
						customMnrGenCdVO.setMnrCdGrpTpCd("OT");
						customMnrGenCdVO.setAgmtUseFlg("N");
						customMnrGenCdVO.setDeltFlg("N");
						customMnrGenCdVO.setCreUsrId(CodeMgmtDtlVO.getCreUsrId());
						customMnrGenCdVO.setUpdUsrId(CodeMgmtDtlVO.getUpdUsrId());
						insertVoList.add(customMnrGenCdVO);
					}
					else if("U".equals(CodeMgmtDtlVO.getIbflag())){
						customMnrGenCdVO.setMnrCdDesc(CodeMgmtDtlVO.getIntgCdValDesc());
						customMnrGenCdVO.setMnrCdDpDesc(CodeMgmtDtlVO.getIntgCdValDpDesc());
						customMnrGenCdVO.setPairCdDpDesc(CodeMgmtDtlVO.getIntgCdValDpDesc());
						customMnrGenCdVO.setPairCdDesc(CodeMgmtDtlVO.getIntgCdValDesc());
						customMnrGenCdVO.setPairCdId(CodeMgmtDtlVO.getIntgCdValCtnt());
						customMnrGenCdVO.setPairRefCd(CodeMgmtDtlVO.getIntgCdId());
						customMnrGenCdVO.setMnrCdGrpNo("3");
						customMnrGenCdVO.setMnrCdDpSeq(CodeMgmtDtlVO.getIntgCdValDpSeq());
						customMnrGenCdVO.setUpdUsrId(CodeMgmtDtlVO.getUpdUsrId());
						updateVoList.add(customMnrGenCdVO);
					}
					else if("D".equals(CodeMgmtDtlVO.getIbflag())){
						customMnrGenCdVO.setPairCdId(CodeMgmtDtlVO.getIntgCdValCtnt());
						customMnrGenCdVO.setPairRefCd(CodeMgmtDtlVO.getIntgCdId());
						customMnrGenCdVO.setMnrCdGrpNo("3");
						deleteVoList.add(customMnrGenCdVO);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addGeneralCodeData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyIntgCdToMnrCdData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeIntgCdToMnrCdData(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] manageGeneralCodeBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0009] manageGeneralCodeBasic"}).getMessage(),ex);
		}
	}	
}