/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : RDFaxSendEAIDAO.java
 *@FileTitle : RDFaxSendEAIDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-06
 *@LastModifier : Lee Sang-Woo
 *@LastVersion : 1.0
 * 2007-02-06 Lee Sang-Woo
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.integration;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.vo.SearchPreDispatchSentHistoryVO;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.support.layer.integration.EAIDAOSupport;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see EAIDAOSupport
 * @since J2EE 1.4
 */
public class RDFaxSendEAIDAO extends EAIDAOSupport {

	private ArrayList faxresponseArray = null;

	/**
	 * 멀티 이벤트 처리<br>
	 * PreDisPatchHistory의 event에 대한 멀티 이벤트 처리<br>
	 * PreDisPatchHistory MESSAGE Send FAX
	 * 
	 * @param paramList
	 * @return
	 */
	public ArrayList faxEdiSend(List<SearchPreDispatchSentHistoryVO> paramList) {
		String sys_cd = "TRS";
		String app_cd = "ESD_TRS_0026B.mrd";
		String batch_ind = "N";
		String title = "";
		String param = "";
		String rcv_info = "";
		String sctrl_ofc_cd = "";
		String sctrl_user_id = "";

		ArrayList arr_fax = new ArrayList();
		SearchPreDispatchSentHistoryVO preVO = null;
		ArrayList arr_faxresponse = new ArrayList();

		String sfax_snd1_no = "";
		String sfax_snd2_no = "";
		String sfax_snd3_no = "";

		String vndr_seq = "";
		String pvndr_seq = "";
		try {
			for (int p = 0; p < paramList.size(); p++) {

				preVO = (SearchPreDispatchSentHistoryVO) paramList.get(p);

				vndr_seq = preVO.getVndrSeq();
				sctrl_ofc_cd = preVO.getCreOfcCd();
				sctrl_user_id = preVO.getUpdUsrId();

				if (!(vndr_seq.equals(pvndr_seq))) {
					// Vendor Seq, 배치실행 하루전일
					param = "[" + vndr_seq + "][" + preVO.getBatExeDt() + "]";
					title = "NYK LINE(Vendor#: " + vndr_seq + ")";
					if (preVO.getDisN1stFaxNo() != null && !"".equals(preVO.getDisN1stFaxNo())) {
						param = param + "[" + preVO.getDisN1stFaxNo() + "][" + preVO.getDisN1stEml() + "]";
						FaxMetaInfo info = new FaxMetaInfo(sys_cd, app_cd, batch_ind, title, param, rcv_info + ";" + preVO.getDisN1stFaxNo(), sctrl_ofc_cd, sctrl_user_id);
						sfax_snd1_no = FaxUtility.registerDB(info);
						sfax_snd1_no = info.getSndNo();
						arr_fax.add(info);
					}
					if ((preVO.getDisN2ndFaxNo() != null) && (!"".equals(preVO.getDisN2ndFaxNo()))) {
						param = param + "[" + preVO.getDisN2ndFaxNo() + "][" + preVO.getDisN2ndEml() + "]";
						FaxMetaInfo info = new FaxMetaInfo(sys_cd, app_cd, batch_ind, title, param, rcv_info + ";" + preVO.getDisN2ndFaxNo(), sctrl_ofc_cd, sctrl_user_id);
						FaxUtility.registerDB(info);
						sfax_snd2_no = info.getSndNo();
						arr_fax.add(info);
					}
					if (preVO.getDisN3rdFaxNo() != null && !"".equals(preVO.getDisN3rdFaxNo())) {
						param = param + "[" + preVO.getDisN3rdFaxNo() + "][" + preVO.getDisN3rdEml() + "]";
						FaxMetaInfo info = new FaxMetaInfo(sys_cd, app_cd, batch_ind, title, param, rcv_info + ";" + preVO.getDisN3rdFaxNo(), sctrl_ofc_cd, sctrl_user_id);
						FaxUtility.registerDB(info);
						sfax_snd3_no = info.getSndNo();
						arr_fax.add(info);
					}
				}
				if (preVO.getDisN1stFaxNo() != null && !preVO.getDisN1stFaxNo().equals("")) {
					preVO.setFaxSnd1No(sfax_snd1_no);
				}
				if (preVO.getDisN2ndFaxNo() != null && !preVO.getDisN2ndFaxNo().equals("")) {
					preVO.setFaxSnd2No(sfax_snd2_no);
				}
				if (preVO.getDisN3rdFaxNo() != null && !preVO.getDisN3rdFaxNo().equals("")) {
					preVO.setFaxSnd3No(sfax_snd3_no);
				}
				arr_faxresponse.add(preVO);
				this.setFaxresponse_array(arr_faxresponse);
				pvndr_seq = vndr_seq;
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return this.getFaxresponse_array();
	}

	/**
	 * @param arraylist
	 */
	private void setFaxresponse_array(ArrayList faxresponse_array) {
		this.faxresponseArray = faxresponse_array;
	}

	/**
	 * @return response ArrayList
	 */
	public ArrayList getFaxresponse_array() {
		return faxresponseArray;
	}
}
