/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ReceiveOwnBkgCancelRequestMgtBCImpl.java
 *@FileTitle : ReceiveOwnBkgCancelRequestMgtBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.19
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.19 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.basic;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.integration.ReceiveOwnBkgCancelRequestMgtDBDAO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo.ScgVvdDgCgoCxlRqstVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo.CxlRqstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * Receive Own Bkg Cancel Request Mgt Basic Command implementation<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.6
 */
public class ReceiveOwnBkgCancelRequestMgtBCImpl extends BasicCommandSupport implements ReceiveOwnBkgCancelRequestMgtBC{
	// Database Access Object
	private transient ReceiveOwnBkgCancelRequestMgtDBDAO      dbDao   = null;
	
	/**
	 * ReceiveEdiFromPartnerLinesMgtBCImpl object creation<br>
	 * ReceiveEdiFromParnterLinesMgtDBDAO creation<br>
	 */
	public ReceiveOwnBkgCancelRequestMgtBCImpl() {
		dbDao   = new ReceiveOwnBkgCancelRequestMgtDBDAO();
	}
	
	/**
	 * SCG_VVD_DG_CGO_CXL_RQST SAVE <br>
	 * 
	 * @param List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs
	 * @exception EventException
	 */
	public void addScgVvdDgCgoCxlRqst(List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs) throws EventException {
					
		for (ScgVvdDgCgoCxlRqstVO scgVvdDgCgoCxlRqstVO : scgVvdDgCgoCxlRqstVOs) {
			
			String sequence = "";
			try {
				sequence = String.valueOf(dbDao.searchSequence());
			} catch (DAOException e) {
				log.error(e.getMessage());
				throw new EventException(new ErrorHandler("").getMessage(), e);
			}
			
			scgVvdDgCgoCxlRqstVO.setDcgoCxlRqstSeq(sequence);
			scgVvdDgCgoCxlRqstVO.setRqstVrfyRsltCd("N");		//:set default value:://
			try{
				dbDao.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVO);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SCG_VVD_DG_CGO_CXL_RQST SAVE "}).getMessage(), ex);
			}
			
			try{
				
				/***********************************************************
				 * booking 별로 
				 * 1.FlatFile생성
				 * 2.로그테이블에 Insert
				 * 3.EDI 전송
				 ***********************************************************/
				Map<String, String> map = new HashMap<String, String>();
				
				/*
				 * DG CANCEL 일경우 부킹의 BKG_DG_CGO DATA가 없어야함
				 * BOOKING CANCEL일 경우 BKG_DG_CGO COUNT CHECK
				 * DATA가 있으면 오류 메시지 업데이트 
				 */
				map.put("bkg_no", scgVvdDgCgoCxlRqstVO.getBkgNo());
				String 	dgCount 	= dbDao.searchDgCgoCnt(map);
				int		iDgCount	= 0;
				iDgCount			= Integer.parseInt(dgCount);
				
				if ("DG".equals(scgVvdDgCgoCxlRqstVO.getCxlCgoKndCd())) {
					if (iDgCount>0) {
						map.put("rqst_vrfy_rslt_cd" , "Y");
						map.put("rqst_vrfy_rslt_rmk", "Dangrous Cargo(Seq) Count [" + iDgCount + "]");
						map.put("upd_usr_id"        , scgVvdDgCgoCxlRqstVO.getUpdUsrId());
						map.put("dcgo_cxl_rqst_seq" , sequence);
							    		
						//update 
						dbDao.modifyScgVvdDgCgoCxlRqst(map);
					}
				} else if ("BK".equals(scgVvdDgCgoCxlRqstVO.getCxlCgoKndCd())) {
					if (iDgCount > 0) {
						map.put("rqst_vrfy_rslt_cd" , "Y");
						map.put("rqst_vrfy_rslt_rmk", "Dangrous Cargo(Seq) Count [" + iDgCount + "]");
						map.put("upd_usr_id"        , scgVvdDgCgoCxlRqstVO.getUpdUsrId());
						map.put("dcgo_cxl_rqst_seq" , sequence);
							    		
						//update 
						dbDao.modifyScgVvdDgCgoCxlRqst(map);
					}
				}
				
				List <CxlRqstVO> cxlRqstVOs 	= dbDao.searchScgVvdKey(scgVvdDgCgoCxlRqstVO);
			
				for(CxlRqstVO tmpVO:cxlRqstVOs){
					tmpVO.setDcgoCxlRqstSeq		(sequence);
					tmpVO.setCxlCgoKndCd		(scgVvdDgCgoCxlRqstVO.getCxlCgoKndCd	());
					tmpVO.setCxlCgoRqstDt		(scgVvdDgCgoCxlRqstVO.getCxlCgoRqstDt	());
					tmpVO.setCxlCgoRsn			(scgVvdDgCgoCxlRqstVO.getCxlCgoRsn		());
					tmpVO.setUpdUsrId			(scgVvdDgCgoCxlRqstVO.getUpdUsrId		());
					
					dbDao.modifyScgVvdAproRqst	(tmpVO	);
				}
				
			} catch (Exception ex) {
				log.error(ex.getMessage());
				throw new EventException(new ErrorHandler("").getMessage(), ex);
			}
		}
	}
}
