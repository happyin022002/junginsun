/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : IHCGuideLineUpload7014BackEndJob.java
 *@FileTitle : Upload Backendjob 으로 실행
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.06.10
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 *2013.07.26 전윤주 [CHM-201325898] Dry 일 경우 신규 Tariff 입력 시 40' AMT를 기준으로 Loc.Group을 할당해주는 로직 추가
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration.IHCGuideLineDBDAO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.PriTrfIHCRtVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * Upload Backendjob 으로 실행한다. 
 * 
 * @author 서미진
 * @see IHCGuideLineDBDAO
 * @since J2EE 1.6
 */
public class IHCGuideLineUpload7014BackEndJob extends BackEndCommandSupport{ 
	private static final long serialVersionUID = 7869461307221308362L;
	
	private IHCGuideLineDBDAO dao = new IHCGuideLineDBDAO();
	
	private IHCDetailVO iHCDetailVO;
	private PriTrfIHCRtVO[] priTrfIHCRtVOs;
	
	public IHCDetailVO getIHCDetailVO() {
		return iHCDetailVO;
	}

	public void setIHCDetailVO(IHCDetailVO iHCDetailVO) {
		this.iHCDetailVO = iHCDetailVO;
	}

	public PriTrfIHCRtVO[] getPriTrfIHCRtVOs() {
		return priTrfIHCRtVOs;
	}

	public void setPriTrfIHCRtVOs(PriTrfIHCRtVO[] priTrfIHCRtVOs) {
		this.priTrfIHCRtVOs = priTrfIHCRtVOs;
	}
	/**
	 * IHC Tariff - Load Excel upload 
	 * 
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List doStart() throws Exception {
		try{
			//업로드 전 remark 를 null로 업데이트 함
			dao.modifyIHCDetailAll(iHCDetailVO);
			
			//엑셀 업로드
			if (priTrfIHCRtVOs != null) {
				for(int i=0; i<priTrfIHCRtVOs.length; i++){
					priTrfIHCRtVOs[i].setSvcScpCd(iHCDetailVO.getSvcScpCd());
					priTrfIHCRtVOs[i].setIhcTrfNo(iHCDetailVO.getIhcTrfNo());
					priTrfIHCRtVOs[i].setIhcCgoTpCd(iHCDetailVO.getIhcCgoTpCd());
					priTrfIHCRtVOs[i].setOrgDestTpCd(iHCDetailVO.getOrgDestTpCd());
					priTrfIHCRtVOs[i].setAmdtSeq(iHCDetailVO.getAmdtSeq());
					priTrfIHCRtVOs[i].setCreUsrId(iHCDetailVO.getCreUsrId());
					priTrfIHCRtVOs[i].setUpdUsrId(iHCDetailVO.getUpdUsrId());
					dao.uploadIHCCreation(priTrfIHCRtVOs[i]);	
					
					if (iHCDetailVO.getIhcCgoTpCd().equals("DR")){ // Dry만 loc.group 신규 할당
						dao.addIHCGuidelineDetailLocGroup(iHCDetailVO); //신규 입력된 Tariff에 대해 Loc.group 업데이트
					}
				}
			}
			
			//엑셀 업로드 후 기존 data 삭제
			dao.removeIHCDetailAll(iHCDetailVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
	
}