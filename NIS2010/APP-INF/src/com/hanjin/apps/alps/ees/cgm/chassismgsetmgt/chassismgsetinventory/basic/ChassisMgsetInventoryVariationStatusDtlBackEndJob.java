/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryVariationStatusDtlBackEndJob.java
*@FileTitle : EES_CGM_1103 Status Change 인벤토리 조회(detail) BackEndJob impl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.16 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration.ChassisMgsetInventoryDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlMGTVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * NIS2010-ChassisMgsetMgt Business Logic Basic Command implementation<br>
 * - NIS2010-ChassisMgsetMgt EES_CGM_1103  Status Change 인벤토리 조회(detail) 관련한 BACKEND에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Chae-Shung Cho
 * @see ChassisMgsetInventoryVariationStatusDtlBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ChassisMgsetInventoryVariationStatusDtlBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private ChassisMgsetInventoryDBDAO dbDao;

	private CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO;

	/**
	 * BackEndJob시작전 VO 객체를 세팅한다.  [EES_CGM_1102] <br>
	 *  
	 * @param cHSInventoryByVariationINVO CHSInventoryByVariationINVO 
	 */		
	public void setCHSInventoryByVariationDtlINVO(CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO) {
		this.cHSInventoryByVariationDtlINVO = cHSInventoryByVariationDtlINVO;
	}

	
	/**
	 * Status Change 인벤토리 조회(summary). [EES_CGM_1103]<br>
	 * 
	 * @return List<CHSInventoryByVariationDtlMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	public List<CHSInventoryByVariationDtlMGTVO> doStart() throws Exception
	{
		this.dbDao = new ChassisMgsetInventoryDBDAO();
		try {
			// String crntLocCd = chsInventoryByStaydaysINVO.getCrntLocCd();
			/*
			if(crntLocCd != null && !crntLocCd.equals("")){
				crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setCrntLocCd(crntLocCd);
			}*/
			String tmp_inq_fm_dys = cHSInventoryByVariationDtlINVO.getInqFmDys();
			String tmp_inq_to_dys = cHSInventoryByVariationDtlINVO.getInqToDys();
			
			tmp_inq_fm_dys = tmp_inq_fm_dys.replaceAll("-", "");
			tmp_inq_to_dys = tmp_inq_to_dys.replaceAll("-", "");
			
			cHSInventoryByVariationDtlINVO.setInqFmDys(tmp_inq_fm_dys);
			cHSInventoryByVariationDtlINVO.setInqToDys(tmp_inq_to_dys);
			
			return dbDao.searchCHSInventoryByVariationDtlListData(cHSInventoryByVariationDtlINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	
	}
}