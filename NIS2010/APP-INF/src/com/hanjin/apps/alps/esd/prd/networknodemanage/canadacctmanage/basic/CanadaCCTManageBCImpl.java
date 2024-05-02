/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CanadaCCTManageBC.java
*@FileTitle : CanadaCCTManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : JunKun Lee
*@LastVersion : 1.0
*2012-06-18 JunKun Lee : Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청
*2012.11.02 정선용 [CHM-201221039] [PRD] Canada rail cut off 기능개선
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.event.EsdPrd0037Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration.CanadaCCTManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.vo.CanadaCCTManageVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmLocationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 2007611
 * @see ESD_PRD_0037EventResponse 참조
 * @since J2EE 1.4
 */
public class CanadaCCTManageBCImpl extends BasicCommandSupport implements CanadaCCTManageBC{

	// Database Access Object
	private transient CanadaCCTManageDBDAO dbDao = null;

	/**
	 * CCTmanageBCImpl 객체 생성<br>
	 * CCTmanageDBDAO를 생성한다.<br>
	 */
	public CanadaCCTManageBCImpl(){
		dbDao = new CanadaCCTManageDBDAO();
	}

	
	/**
	 * searchCanadaCCTManage
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<CanadaCCTManageVO> searchCanadaCCTManage(CanadaCCTManageVO vo) throws EventException {
		try{
			return dbDao.searchCanadaCCTManage(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * searchCanadaCCTInterval
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<CanadaCCTManageVO> searchCanadaCCTInterval(CanadaCCTManageVO vo) throws EventException {
		try{
			return dbDao.searchCanadaCCTInterval(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * searchMdmLocation
	 * @param event
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<MdmLocationVO> searchMdmLocation(EsdPrd0037Event event) throws EventException {
		try{
			return dbDao.searchMdmLocation(event);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * multiCanadaCCTManage
	 * @param canadaCCTManageVOs
	 * @param account
	 * @throws EventException
	 */
	@Override
	public void multiCanadaCCTManage(CanadaCCTManageVO[] canadaCCTManageVOs, SignOnUserAccount account) throws EventException {
		if(canadaCCTManageVOs == null) return;
		
		try {
			List<CanadaCCTManageVO> insertVoList = new ArrayList<CanadaCCTManageVO>();
			List<CanadaCCTManageVO> updateVoList = new ArrayList<CanadaCCTManageVO>();
			List<CanadaCCTManageVO> deleteVoList = new ArrayList<CanadaCCTManageVO>();
			
			for(int i=0; i<canadaCCTManageVOs.length; i++){
				if(canadaCCTManageVOs[i].getIbflag().equals("I")){
					canadaCCTManageVOs[i].setUpdUsrId(account.getUsr_id());
					
//					// validation
					
					insertVoList.add(canadaCCTManageVOs[i]);
				}else if(canadaCCTManageVOs[i].getIbflag().equals("U")){
					canadaCCTManageVOs[i].setUpdUsrId(account.getUsr_id());
					
//					// validation
					
					updateVoList.add(canadaCCTManageVOs[i]);
				}else if(canadaCCTManageVOs[i].getIbflag().equals("D")){
					canadaCCTManageVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(canadaCCTManageVOs[i]);
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.insertCanadaCCTManage(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.updateCanadaCCTManage(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.deleteCanadaCCTManage(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * POL, POR Duplication Check
	 * @param vos
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<CanadaCCTManageVO> checkDuplicateCanadaCCTManage(CanadaCCTManageVO[] vos) throws EventException {
		if(vos == null) return null;
		
		List<CanadaCCTManageVO> rstVos = new ArrayList<CanadaCCTManageVO>();
		try {
			for (int i = 0; i < vos.length; i++) {
				CanadaCCTManageVO chkVo = vos[i];
				if (chkVo.getIbflag().equals("I")) {
					// por nod 추가 로직
					if(chkVo.getPorNodCd() ==null || chkVo.getPorNodCd().equals("")) {
						chkVo.setPorNodCd(" ");
					}
					List<CanadaCCTManageVO> rst = dbDao.searchCanadaCCTManage(chkVo);
					if(rst != null && rst.size() > 0) {
						rstVos.add(chkVo);
						return rstVos;
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return rstVos;
	}

	/**
	 * POL  Check
	 * @param event
	 * @return List<MdmLocationVO>
	 * @throws EventException
	 */
	@Override
	public List<MdmLocationVO> searchPolNode(EsdPrd0037Event event)
		throws EventException {
			try{
				return dbDao.searchPolNode(event);
			}catch(DAOException ex){
				throw new EventException(ex.getMessage(), ex);
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
	}

	/**
	 * multiIntevalCCTManage
	 * @param CanadaCCTManageVO[] canadaCCTManageVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void multiIntevalCCTManage(CanadaCCTManageVO[] canadaCCTManageVOs,
			SignOnUserAccount account) throws EventException {
			if(canadaCCTManageVOs == null) return;
			
			try {
				List<CanadaCCTManageVO> updateVoList = new ArrayList<CanadaCCTManageVO>();
				
				for(int i=0; i<canadaCCTManageVOs.length; i++){
					if(canadaCCTManageVOs[i].getIbflag().equals("U")){
						canadaCCTManageVOs[i].setUpdUsrId(account.getUsr_id());
						
						updateVoList.add(canadaCCTManageVOs[i]);
					}
				}

				if(updateVoList.size() > 0){
					dbDao.updateCaCctItvalMgmt(updateVoList);
					dbDao.updateUsaCctItvalMgmt(updateVoList);
				}

			} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}
		
	}
	
	public String getAuthUsrYn(String usrId) throws EventException {
		try {
			return dbDao.getAuthUsrYn(usrId);
		} catch(DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
}
