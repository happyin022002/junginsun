package com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.basic;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.integration.FreeTimeDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo.IfFtCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo.IfFtVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTFreeTimeChargeCalculationUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

public class FreeTimeBCImpl extends BasicCommandSupport implements FreeTimeBC {

	private DMTFreeTimeChargeCalculationUtil ftChgCalcUtil = null;
	private transient FreeTimeDBDAO dbDao = null;
	
	/**
	 * FreeTimeBCImpl 객체 생성<br>
	 */
	public FreeTimeBCImpl() {
		ftChgCalcUtil = new DMTFreeTimeChargeCalculationUtil();
		dbDao = new FreeTimeDBDAO();
	}
	
	/**
	 * 화주가 납부해야될 최종 Demurrage 를 조회합니다. ( SCE 모듈에서만 호출 )
	 * 1) Inland Demurrage (DEL) 에 대한 FreeTime End Date 를 조회합니다.<br>
	 * 2) Inland Demurrage 가 없는 경우, Port Demurrage (POD) 를 조회합니다.<br>
	 * 
	 * 
	 * @param IfFtCondVO condVO
	 * @return IfFtVO
	 * @exception EventException
	 */	
	@Override
	public IfFtVO searchFtOfIbDm(IfFtCondVO condVO) throws EventException {
		
		IfFtVO ftVO = new IfFtVO();
		log.debug("\n\n[ searchFtOfIbDm ] input params :: \n" + condVO.toString());
		
		// 필수입력값에 대한 오류체크를 합니다.
		if (!checkInPara(condVO)) return null;
		
		try {
			IfFtCondVO ftCondVO = new IfFtCondVO();
			
			// 1. Demurrage 대상 조회
			if ("Y".equals(condVO.getInlndFlg())) {
				// 1) Inland Demurrage 조회요청일 경우
				ftCondVO = dbDao.searchInlndMvmtIbDem(condVO);
			}
			else {
				// 2) Port Demurrage 조회요청일 경우				
				ftCondVO = dbDao.searchPortInlndMvmtIbDem(condVO);	
			}

			// 2. Free Time 정보를 조회합니다.
			if (ftCondVO != null) {
				ftVO = ftChgCalcUtil.searchFtOfIbDm(ftCondVO);
				log.debug("\n\n[ searchFtOfIbDm ] calculate free time :: \n" + ftVO.toString());
			}
			else {
				String ftRmk = "Y".equals(condVO.getInlndFlg()) ? "Inland" : "Port";
				ftVO.setFtRmk("Movement info does not exist.(" + ftRmk + ")");
			}
		}
		catch(EventException ex) {
			String ftRmk = "[ searchFtOfIbDm( BIZ ) ][ BKG No. :: " + condVO.getBkgNo() + "][ CNTR No. ::" + condVO.getCntrNo() + "] Error occurred while searching freetime applied to container :: " + ex.getMessage();
			ftVO.setFtRmk(ftRmk);
		}		
		catch(DAOException ex) {
			String ftRmk = "[ searchFtOfIbDm( DAO ) ][ BKG No. :: " + condVO.getBkgNo() + "][ CNTR No. ::" + condVO.getCntrNo() + "] Error occurred while searching freetime applied to container :: " + ex.getMessage();
			ftVO.setFtRmk(ftRmk);			
		}		
		catch(Exception ex) {
			String ftRmk = "[ searchFtOfIbDm( OTHERS ) ][ BKG No. :: " + condVO.getBkgNo() + "][ CNTR No. ::" + condVO.getCntrNo() + "] Error occurred while searching freetime applied to container :: " + ex.getMessage();
			ftVO.setFtRmk(ftRmk);
		}	
		finally {
			if (!StringUtils.isEmpty(ftVO.getFtRmk())) {
				ftVO.setBkgNo(condVO.getBkgNo());
				ftVO.setCntrNo(condVO.getCntrNo());
			}
			
			// 4. 이력생성
			try {
				dbDao.addIfFtHis(ftVO);
			}
			catch(DAOException e) {
				log.error("\n\n[ addIfFtHis ( DAO ) ][ BKG No. :: " + ftVO.getBkgNo() + "][ CNTR No. ::" + ftVO.getCntrNo() + "] Error occurred while creating a history for freetime calculation request. :: " + e.getMessage());
			}
			catch(Exception e) {
				log.error("\n\n[ addIfFtHis ( OTHERS ) ][ BKG No. :: " + ftVO.getBkgNo() + "][ CNTR No. ::" + ftVO.getCntrNo() + "] Error occurred while creating a history for freetime calculation request. :: " + e.getMessage());
			}
		}

		// 5. 에러가 발생하지 않은 경우, 정상처리결과를 반환한다.
		return StringUtils.isEmpty(ftVO.getFtRmk()) ? ftVO : null;
	}
	
	/**
	 * 필수입력정보를 체크합니다.<br>
	 * 
	 * @param IfFtCondVO inVO
	 * @return boolean
	 */	
	private boolean checkInPara(IfFtCondVO inVO) {
		boolean isChk = true;
		
		if (StringUtils.isEmpty(inVO.getBkgNo())) {
			log.error("\n\n[ checkInPara ] Booking no. is not exist!!");
			isChk = false;
		}
		if (isChk) {
			if (StringUtils.isEmpty(inVO.getCntrNo())) {
				log.error("\n\n[ checkInPara ] (BKG No. : " + inVO.getBkgNo() + ") Container no. is not exist!!");
				isChk = false;
			}
		}
		
		return isChk;
	}
	
}
