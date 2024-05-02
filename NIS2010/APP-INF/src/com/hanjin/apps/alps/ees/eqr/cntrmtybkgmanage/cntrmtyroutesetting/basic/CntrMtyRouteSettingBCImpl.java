/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyRouteSettingBCImpl.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history : 최초등록
*@LastModifyDate : 2013.07.30
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2013.07.30 두기민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.integration.CntrMtyRouteSettingDBDAO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo.EesEqr1019GRPVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo.EesEqr1019RouteSettingVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-RepoPlanManage Business Logic Basic Command implementation<br>
 * - ALPS-RepoPlanManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 두기민
 * @see EES_EQR_1019HTMLAction,CntrMtyRouteSettingBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrMtyRouteSettingBCImpl extends BasicCommandSupport implements CntrMtyRouteSettingBC {

	// Database Access Object
	private transient CntrMtyRouteSettingDBDAO dbDao = null;

	/**
	 * CntrMtyRouteSettingBCImpl 객체 생성<br>
	 * CntrMtyRouteSettingDBDAO 생성한다.<br>
	 */
	public CntrMtyRouteSettingBCImpl() {
		dbDao = new CntrMtyRouteSettingDBDAO();
	}
	
	/**
	 * [EES_EQR_1019 : ] MTY BKG ROUTE SETTING 화면 수정.<br>
	 * 
	 * @param EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public EesEqr1019GRPVO searchCntrMtyRouteSettingList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws EventException {
		
		// GROUPVO 생성
		EesEqr1019GRPVO grpVo = new EesEqr1019GRPVO();
		
		try {
			//Status Code List를 조회한다.
			List<EesEqr1019RouteSettingVO> list = dbDao.searchCntrMtyRouteSettingList(eesEqr1019RouteSettingVO);
			
			grpVo.setEesEqr1019RouteSettingVO(list);
			return grpVo;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * [EES_EQR_1019 : ] MTY BKG ROUTE SETTING TP/SZ 조회.<br>
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return EesEqr1019GRPVO
	 * @exception EventException
	 * 
	 */
	public EesEqr1019GRPVO searchCntrTpSzList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws EventException {
		
		// GROUPVO 생성
		EesEqr1019GRPVO grpVo = new EesEqr1019GRPVO();
		
		try {
			//Status Code List를 조회한다.
			List<EesEqr1019RouteSettingVO> list = dbDao.searchCntrTpSzList(eesEqr1019RouteSettingVO);
			
			grpVo.setEesEqr1019RouteSettingVO(list);
			return grpVo;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * MTY BKG ROUTE SETTING Location 유효성 조회. <br> 
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return int
	 * @exception EventException
	 */
	public int checkLocationByGroupCode(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws EventException {
		int count = 0;
        try {
        	count = dbDao.checkLocationByGroupCode(eesEqr1019RouteSettingVO);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
        return count;
	}
	
	/**
	 * MTY BKG ROUTE SETTING Rcc에 따른 Lcc_cd 조회(사용안함) <br> 
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLocationByRccCode(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws EventException {
		String rccCd = "N";
		int cnt = 0;
        try {
        	cnt = dbDao.checkLocationDuplication(eesEqr1019RouteSettingVO);
        	
        	if(cnt == 0){
        		rccCd = dbDao.searchLocationByRccCode(eesEqr1019RouteSettingVO);
        	}else{
        		rccCd = "M";
        	}
        
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
        return rccCd;
	}
	
	/**
	 * [EES_EQR_1019 : ] MTY BKG ROUTE SETTING 화면 수정.<br>
	 * 
	 * @param EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCntrMtyRouteSettingList(EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOs, SignOnUserAccount account) throws EventException {
		try {
			

			String ibflag = null;
			String usrId			= account.getUsr_id();
			
			if(eesEqr1019RouteSettingVOs != null && eesEqr1019RouteSettingVOs.length > 0){				
				for ( int i=0; i< eesEqr1019RouteSettingVOs.length; i++ ) {					

					ibflag 		= eesEqr1019RouteSettingVOs[i].getIbflag();
					
					EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO 		= new EesEqr1019RouteSettingVO();
					ObjectCloner.build(eesEqr1019RouteSettingVOs[i], eesEqr1019RouteSettingVO);
					eesEqr1019RouteSettingVO.setUsrId(usrId);
					
					String bkgFlg = eesEqr1019RouteSettingVO.getMtyBkgDsabilFlg();
					String bkgSplitFlg = eesEqr1019RouteSettingVO.getMtySplitBkgDsabilFlg();
					
					if("0".equals(bkgFlg)){
						eesEqr1019RouteSettingVO.setMtyBkgDsabilFlg("N");
					}else{
						eesEqr1019RouteSettingVO.setMtyBkgDsabilFlg("Y");
					}
					
					if("0".equals(bkgSplitFlg)){
						eesEqr1019RouteSettingVO.setMtySplitBkgDsabilFlg("N");
					}else{
						eesEqr1019RouteSettingVO.setMtySplitBkgDsabilFlg("Y");
					}
				
					if("D".equals(ibflag)){
						dbDao.deleteCntrTpSzList(eesEqr1019RouteSettingVO);
						dbDao.deleteCntrMtyRouteSettingList(eesEqr1019RouteSettingVO);
					}else{
						dbDao.modifyCntrMtyRouteSettingList(eesEqr1019RouteSettingVO);
					}
				}
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [EES_EQR_1018 : ]<br>
	 * BKG 구간정보 입력/수정/삭제
	 * @param eesEqr1018multiVOs	EesEqr1018MultiVO[] 
	 * @param account				SignOnUserAccount 
	 * @exception EventException
	 */
	public void modifyCntrTpSzList(EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOs, SignOnUserAccount account) throws EventException {
		try {
			
			String ibflag = null;
			String usrId			= account.getUsr_id();
			
			if(eesEqr1019RouteSettingVOs != null && eesEqr1019RouteSettingVOs.length > 0){		
				EesEqr1019RouteSettingVO deletVO 		= new EesEqr1019RouteSettingVO();
				ObjectCloner.build(eesEqr1019RouteSettingVOs[0], deletVO);
				
				for ( int i=0; i< eesEqr1019RouteSettingVOs.length; i++ ) {					

					ibflag 		= eesEqr1019RouteSettingVOs[i].getChkFlg();
					EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO = new EesEqr1019RouteSettingVO();
					ObjectCloner.build(eesEqr1019RouteSettingVOs[i], eesEqr1019RouteSettingVO);
					eesEqr1019RouteSettingVO.setUsrId(usrId);
					if("1".endsWith(ibflag)){
						dbDao.addCntrTpSzList(eesEqr1019RouteSettingVO);
					}else{
						dbDao.deleteBKGCntrTpSzList(eesEqr1019RouteSettingVO);
					}
				}
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}