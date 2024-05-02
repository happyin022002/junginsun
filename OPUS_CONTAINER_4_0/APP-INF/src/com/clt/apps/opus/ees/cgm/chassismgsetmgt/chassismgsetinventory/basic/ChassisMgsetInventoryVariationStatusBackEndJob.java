/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryVariationStatusBackEndJob.java
*@FileTitle : EES_CGM_1102 Status Change 인벤토리 조회(summary) BackEndJob impl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.16 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration.ChassisMgsetInventoryDBDAO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationMGTVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;



/**
 * opus-ChassisMgsetMgt Business Logic Basic Command implementation<br>
 * - opus-ChassisMgsetMgt EES_CGM_1102 Status Change 인벤토리 조회(summary) 관련한 BACKEND에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Chae-Shung Cho
 * @see ChassisMgsetInventoryVariationStatusBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ChassisMgsetInventoryVariationStatusBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private ChassisMgsetInventoryDBDAO dbDao;

	private CHSInventoryByVariationINVO cHSInventoryByVariationINVO;

	/**
	 * BackEndJob시작전 VO 객체를 세팅한다.  [EES_CGM_1102] <br>
	 *  
	 * @param cHSInventoryByVariationINVO CHSInventoryByVariationINVO 
	 */		
	public void setCHSInventoryByVariationINVO(CHSInventoryByVariationINVO cHSInventoryByVariationINVO) {
		this.cHSInventoryByVariationINVO = cHSInventoryByVariationINVO;
	}

	
	/**
	 * Status Change 인벤토리 조회(summary). [EES_CGM_1102]<br>
	 * 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	
	public List<CHSInventoryByVariationMGTVO> doStart() throws Exception
	{
		this.dbDao = new ChassisMgsetInventoryDBDAO();
		try {
			// String crntLocCd = chsInventoryByStaydaysINVO.getCrntLocCd();
			/*
			if(crntLocCd != null && !crntLocCd.equals("")){
				crntLocCd = "'" + crntLocCd.replaceAll(",", "','") + "'";
				chsInventoryByStaydaysINVO.setCrntLocCd(crntLocCd);
			}*/
			String tmp_inq_fm_dys = cHSInventoryByVariationINVO.getInqFmDys();
			String tmp_inq_to_dys = cHSInventoryByVariationINVO.getInqToDys();
			
			tmp_inq_fm_dys = tmp_inq_fm_dys.replaceAll("-", "");
			tmp_inq_to_dys = tmp_inq_to_dys.replaceAll("-", "");
			
			cHSInventoryByVariationINVO.setInqFmDys(tmp_inq_fm_dys);
			cHSInventoryByVariationINVO.setInqToDys(tmp_inq_to_dys);
			
			return dbDao.searchCHSInventoryByVariationStsData(cHSInventoryByVariationINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	
	}
}