/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NoteConversionBCOmpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2013.08.21 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.basic;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.integration.NoteConversionDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.RsltPriNoteConvGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.RsltPriNoteConvGrpLocVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.NoteConversionGroupLocationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriNoteConvGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriNoteConvGrpLocVO;

/**
 * NIS2010-Surcharge Business Logic Basic Command implementation<br>
 * - NIS2010-Surcharge에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_4004EventResponse,SurchargeGroupLocationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class NoteConversionBCImpl extends BasicCommandSupport implements NoteConversionBC {

	// Database Access Object
	private transient NoteConversionDBDAO dbDao = null;

	/**
	 * SurchargeGroupLocationBCImpl 객체 생성<br>
	 * ${DAO}DAO를 생성한다.<br>
	 */
	public NoteConversionBCImpl() {
		dbDao = new NoteConversionDBDAO();
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Note Conversion GroupLocation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param NoteConversionGroupLocationVO noteConversionGroupLocationVO
	 * @return NoteConversionGroupLocationVO
	 * @exception EventException
	 */
	public NoteConversionGroupLocationVO searchGroupLocationList(NoteConversionGroupLocationVO noteConversionGroupLocationVO) throws EventException {
		try {

			//Group Location, detail
			List<RsltPriNoteConvGrpLocVO> rsltPriNoteConvGrpLocVOList 		= new ArrayList<RsltPriNoteConvGrpLocVO>();
			List<RsltPriNoteConvGrpLocDtlVO> rsltPriNoteConvGrpLocDtlVOList 	= new ArrayList<RsltPriNoteConvGrpLocDtlVO>();
			
			String searchGubun = "";
			PriNoteConvGrpLocVO priNoteConvGrpLocVO 		= new PriNoteConvGrpLocVO();
			PriNoteConvGrpLocDtlVO priNoteConvGrpLocDtlVO = new PriNoteConvGrpLocDtlVO();
			
			//param으로 넘어온  vo를 각 vo로 셋한다
			searchGubun = noteConversionGroupLocationVO.getSearchGubun();
			priNoteConvGrpLocVO = noteConversionGroupLocationVO.getPriNoteConvGrpLocVO();
			priNoteConvGrpLocDtlVO = noteConversionGroupLocationVO.getPriNoteConvGrpLocDtlVO();
			
			//각 리스트를 받아서  vo에 담는다
			if("1".equals(searchGubun)) {
				rsltPriNoteConvGrpLocVOList 	= dbDao.searchGroupLocationList(priNoteConvGrpLocVO);
				noteConversionGroupLocationVO.setRsltPriNoteConvGrpLocVOList(rsltPriNoteConvGrpLocVOList);
			}	
			else if("2".equals(searchGubun)) {
				rsltPriNoteConvGrpLocDtlVOList 	= dbDao.searchGroupLocationDetailList(priNoteConvGrpLocDtlVO);
				noteConversionGroupLocationVO.setRsltPriNoteConvGrpLocDtlVOList(rsltPriNoteConvGrpLocDtlVOList);
			}			
			
			return noteConversionGroupLocationVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Note Conversion GroupLocation화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param NoteConversionGroupLocationVO noteConversionGroupLocationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageGroupLocation(NoteConversionGroupLocationVO noteConversionGroupLocationVO, SignOnUserAccount account) throws EventException{
		try {
		
			//vo에서 Group Location, detail을 뺀다
			PriNoteConvGrpLocVO[] priNoteConvGrpLocVOs 		= noteConversionGroupLocationVO.getPriNoteConvGrpLocVOs();
			PriNoteConvGrpLocDtlVO[] priNoteConvGrpLocDtlVOs 	= noteConversionGroupLocationVO.getPriNoteConvGrpLocDtlVOs();
			
			//Group Location
			List<PriNoteConvGrpLocVO> insertVoList = new ArrayList<PriNoteConvGrpLocVO>();
			List<PriNoteConvGrpLocVO> updateVoList = new ArrayList<PriNoteConvGrpLocVO>();
			List<PriNoteConvGrpLocVO> deleteVoList = new ArrayList<PriNoteConvGrpLocVO>();
			//Group Locationdetail 
			List<PriNoteConvGrpLocDtlVO> insertDtlVoList = new ArrayList<PriNoteConvGrpLocDtlVO>();
			List<PriNoteConvGrpLocDtlVO> updateDtlVoList = new ArrayList<PriNoteConvGrpLocDtlVO>();
			List<PriNoteConvGrpLocDtlVO> deleteDtlVoList = new ArrayList<PriNoteConvGrpLocDtlVO>();

			
			////////////////////////////Group Location / detail 저장/////////////////////////////////////	
			
			//Group Location
			for (int i = 0; priNoteConvGrpLocVOs != null && i < priNoteConvGrpLocVOs.length; i++) {
				
				if ( priNoteConvGrpLocVOs[i].getIbflag().equals("I")){
					priNoteConvGrpLocVOs[i].setCreUsrId(account.getUsr_id());
					priNoteConvGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priNoteConvGrpLocVOs[i]);
				} else if ( priNoteConvGrpLocVOs[i].getIbflag().equals("U")){
					priNoteConvGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priNoteConvGrpLocVOs[i]);
				} else if ( priNoteConvGrpLocVOs[i].getIbflag().equals("D")){
					priNoteConvGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priNoteConvGrpLocVOs[i]);
					//본문별 디테일 삭제
					dbDao.removeGroupLocationDetail(priNoteConvGrpLocVOs[i]);
					//디테일을 이미 삭제 했으므로 널로 세팅
					priNoteConvGrpLocDtlVOs = null;
				}
				
			}
			
			//detail
			for (int i = 0; priNoteConvGrpLocDtlVOs != null && i < priNoteConvGrpLocDtlVOs.length; i++) {
				
				if ( priNoteConvGrpLocDtlVOs[i].getIbflag().equals("I")) {
					priNoteConvGrpLocDtlVOs[i].setCreUsrId(account.getUsr_id());
					priNoteConvGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(priNoteConvGrpLocDtlVOs[i]);
				} else if ( priNoteConvGrpLocDtlVOs[i].getIbflag().equals("U")){
					priNoteConvGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priNoteConvGrpLocDtlVOs[i]);
				} else if ( priNoteConvGrpLocDtlVOs[i].getIbflag().equals("D")){
					deleteDtlVoList.add(priNoteConvGrpLocDtlVOs[i]);
				}
			}
			
			
			if (insertVoList.size() > 0) {
				dbDao.addGroupLocation(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addGroupLocationDetail(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyGroupLocation(updateVoList);
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeGroupLocationDetail(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeGroupLocation(deleteVoList);
			}
			
		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
}