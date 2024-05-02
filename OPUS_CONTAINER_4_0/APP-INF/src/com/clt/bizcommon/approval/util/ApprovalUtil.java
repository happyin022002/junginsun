/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : CommodityDBDAO.java
* @FileTitle : Commodity정보조회(공통 Popup)
* Open Issues :
* Change history :
* @LastModifyDate : 2006-08-03
* @LastModifier : sungseok, choi
* @LastVersion : 1.0
* 2006-08-03 sungseok, choi
* 1.0 최초 생성
=========================================================*/
package com.clt.bizcommon.approval.util;

import java.util.List;

import com.clt.bizcommon.approval.integration.ApprovalDBDAO;
import com.clt.bizcommon.approval.vo.ApprovalRouteVO;
import com.clt.bizcommon.approval.vo.ApprovalStaffVO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.syscommon.common.table.ComAproCsrDtlVO;
import com.clt.syscommon.common.table.ComAproRqstHdrVO;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;

/**
 * ApprovalUtil <br>
 * Process ApprovalUtil <br>
 * 
 * @author sungseok, choi
 * @see 
 * @since J2EE 1.4
 */
public class ApprovalUtil {
	/**
     *  log 객체
     */
    protected transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());
    
	/**
	 * ApprovalUtil 객체 생성<br>
	 */
	public ApprovalUtil() { }
	
	/**
	 * CSR 결재요청 정보 생성
	 * @param ComAproRqstHdrVO header
	 * @param ComAproRqstRoutVO route
	 * @param ComAproCsrDtlVO csr
	 * @throws Exception 
	 */
	public void saveCsrApro(ComAproRqstHdrVO header, ComAproRqstRoutVO route, ComAproCsrDtlVO csr) throws Exception {
		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		try {
			header.setCrntAproSeq("1");			
			String newAproNo = dbDao.searchNewAproRqstNo();
			header.setAproRqstNo(newAproNo);
			//결재요청 헤더 정보를 생성합니다.
			dbDao.addApprovalHeader(header);
			
			route.setAproRqstNo(header.getAproRqstNo());
			route.setCreUsrId(header.getCreUsrId());

			//결재요청 결재권자 정보를 생성합니다.
			dbDao.addApprovalRoute(route);
			csr.setAproRqstNo(header.getAproRqstNo());
			//결재요청 CSR상세내용 테이블 생성 
			dbDao.addApprovalCsr(csr);
		} catch(DAOException de) {
			throw new Exception(de.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * 결재요청디테일에 저장할 apro_step 정보를 저장하기위한 셋팅을 한다.
	 * @param String apro_step
	 * @return COM_APRO_RQST_ROUT[]
	 * @throws Exception
	 */
	public ComAproRqstRoutVO[] convertApprovalRoute(String apro_step) throws Exception {
		
		ComAproRqstRoutVO[] route = null;
		
		try {
			if(apro_step != null && !apro_step.equals("")) {
				String[] arr_apro_step = apro_step.split(" - ");
				
				route = new ComAproRqstRoutVO[arr_apro_step.length];
				for(int i=0; i<arr_apro_step.length; i++) {
					String[] arr_unit_apro_step = arr_apro_step[i].split("/");
					
					route[i] = new ComAproRqstRoutVO();
					route[i].setAproRqstSeq(arr_unit_apro_step[0]);
					route[i].setAproUsrId(arr_unit_apro_step[1]);
					route[i].setAproUsrNm(arr_unit_apro_step[2]);
					route[i].setAproOfcCd(arr_unit_apro_step[3]);
					
					if(arr_unit_apro_step.length == 5)
						route[i].setAproUsrJbTitNm(arr_unit_apro_step[4]);
				}
			}
			
		} catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
		return route;
	}
	
	/**
	 * @param ofc_cd
	 * @param sub_sys_cd
	 * @return
	 * @throws Exception 
	 */
	public static String getApprovalRoute(String ofc_cd, String sub_sys_cd) throws Exception {
		
		ApprovalStaffVO approvalStaffVO =  new ApprovalStaffVO();
		ApprovalRouteVO approvalRouteVO = new ApprovalRouteVO();;
		
		StringBuffer sRtn = new StringBuffer();		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		List<ApprovalRouteVO> list = null;
		
		try {
			approvalStaffVO.setOfcCd(ofc_cd);
			approvalStaffVO.setSubSysCd(sub_sys_cd);
			
			String aproRoutSeq = dbDao.searchApprovalRouteSeq(approvalStaffVO);
			
			if(!"".equals(aproRoutSeq)) {
				approvalRouteVO.setAproRoutSeq(aproRoutSeq);
			}
			list = dbDao.searchApprovalRouteUtilList(approvalRouteVO);
			
			for(int i=0; i < list.size(); i++){
				if(i != 0) {
					sRtn.append(" - ");
				}
				
				approvalRouteVO = list.get(i);
				
				sRtn.append(approvalRouteVO.getAproSeq());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrId());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrNm());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproOfcCd());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrJbTitNm());
			}
			
		} catch(DAOException de) {
			throw new Exception(de.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return sRtn.toString();
	}
	
	/**
	 * 
	 * @param String ofc_cd
	 * @param String sub_sys_cd
	 * @return String
	 * @throws Exception
	 */
	public static String getApprovalRoute1(String ofc_cd, String sub_sys_cd) throws Exception {
		ApprovalStaffVO approvalStaffVO = new ApprovalStaffVO();
		ApprovalRouteVO approvalRouteVO = new ApprovalRouteVO();;
		
		StringBuffer sRtn = new StringBuffer();		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		List<ApprovalRouteVO> list = null;
		
		try {
			approvalStaffVO.setOfcCd(ofc_cd);
			approvalStaffVO.setSubSysCd(sub_sys_cd);
			
			String aproRoutSeq = dbDao.searchApprovalRouteSeq(approvalStaffVO);
			
			if(!"".equals(aproRoutSeq)) {
				approvalRouteVO.setAproRoutSeq(aproRoutSeq);
			}
			list = dbDao.searchApprovalRouteUtilList(approvalRouteVO);
			
			for(int i=0; i < list.size(); i++){
				approvalRouteVO = list.get(i);
				
				if(approvalRouteVO.getAproUsrJbTitNm().equals("")){
					sRtn.append("");
				}else{
					sRtn.append(approvalRouteVO.getAproUsrJbTitNm());
					sRtn.append("/");
				}
				sRtn.append(approvalRouteVO.getAproUsrNm());
				break;
			}
		} catch(DAOException de) {
			throw new Exception(de.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return sRtn.toString();
	}
	
	
	/**
	 * CSR번호로 ApprovalStep을 조회한다.
	 * @param String csrNo
	 * @return String
	 * @throws Exception
	 */
	public static String getApprovalRouteByCsrNo(String csrNo) throws Exception {
		
		ApprovalRouteVO approvalRouteVO = new ApprovalRouteVO();;
		
		StringBuffer sRtn = new StringBuffer();		
		ApprovalDBDAO dbDao = new ApprovalDBDAO();
		
		List<ApprovalRouteVO> list = null;
		
		try {
			list = dbDao.searchApprovalRouteListByCsrNo(csrNo);
			
			for(int i=0; i < list.size(); i++){
				if(i != 0) {
					sRtn.append(" - ");
				}
				
				approvalRouteVO = list.get(i);
				
				sRtn.append(approvalRouteVO.getAproSeq());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrId());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrNm());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproOfcCd());
				sRtn.append("/");
				sRtn.append(approvalRouteVO.getAproUsrJbTitNm());
			}
			
		} catch(DAOException de) {
			throw new Exception(de.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return sRtn.toString();
	}
	
}
