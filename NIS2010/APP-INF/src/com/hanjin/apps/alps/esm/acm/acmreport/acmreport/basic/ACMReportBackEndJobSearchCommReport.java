/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMReportBackEndJobSearchCommReport
*@FileTitle : ACMReportBackEndJobSearchCommReport
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.10.09 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration.ACMReportDBDAO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CommReportVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * @author KIM Sang-Soo
 * @see ESM_AGT_0037 EventResponse, ACMReportBackEndJobSearchCommReport 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ACMReportBackEndJobSearchCommReport extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	private CommReportVO commReportVO;
	// Database Access Object
	private ACMReportDBDAO dbDao = new ACMReportDBDAO();

	/**
	 * 데이터 세팅
	 *
	 * @param CommReportVO ediErrVO
	 * @param account
	 */
	public void setCommReportVO(CommReportVO commReportVO) {
		this.commReportVO = commReportVO;
	}

	/**
	 * BackEndJob Resut
	 * @return List<CommReportVO>
	 * @throws Exception
	 */
	public List<CommReportVO> doStart() throws Exception {
		String reportItem = this.commReportVO.getReportItem();
		try {
			if (reportItem.length() > 1) {
				List<String> tempArray = new ArrayList<String>();
				if (reportItem.indexOf("|bl_no|") > -1) tempArray.add("INF.BL_NO");
				if (reportItem.indexOf("|bkg_no|") > -1) tempArray.add("AGN.BKG_NO");
				if (reportItem.indexOf("|io_bnd_cd|") > -1) tempArray.add("AGN.IO_BND_CD");
				if (reportItem.indexOf("|comm_vvd|") > -1) tempArray.add("AGN.AC_VSL_CD||AGN.AC_SKD_VOY_NO||AGN.AC_SKD_DIR_CD");
				if (reportItem.indexOf("|rev_vvd|") > -1) tempArray.add("INF.REV_VVD_CD");
				if (reportItem.indexOf("|sail_arr_dt|") > -1) tempArray.add("AGN.SAIL_ARR_DT");
				if (reportItem.indexOf("|por_cd|") > -1) tempArray.add("INF.POR_CD");
				if (reportItem.indexOf("|pol_cd|") > -1) tempArray.add("INF.POL_CD");
				if (reportItem.indexOf("|pod_cd|") > -1) tempArray.add("INF.POD_CD");
				if (reportItem.indexOf("|del_cd|") > -1) tempArray.add("INF.DEL_CD");
				if (reportItem.indexOf("|trd_cd|") > -1) tempArray.add("INF.TRD_CD");
				if (reportItem.indexOf("|rlane_cd|") > -1) tempArray.add("INF.RLANE_CD");
				if (reportItem.indexOf("|dir_cd|") > -1) tempArray.add("AGN.AC_SKD_DIR_CD");
				
				if (tempArray.size() > 0) {
					String tempReportItem = tempArray.toString();
					tempReportItem = tempReportItem.substring(1, tempReportItem.length()-1);
					this.commReportVO.setReportItem(tempReportItem);
				}
			}
			return dbDao.searchCommReport(this.commReportVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}