/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ChinaManifestListDownloadBackEndJob.java
 *@FileTitle : ChinaManifestListDownloadBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.08.25 이수빈
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration.ChinaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChnBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsChnAwkVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnCntrVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnCustVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnDgCgoVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnMkVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnRfVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnVvdVO;
import com.hanjin.syscommon.common.table.BkgCstmsSealNoVO;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Subin
 * @see ESM_BKG_0216EventResponse,ChinaManifestListDownloadBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ChinaManifestListDownloadBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestListDetailVO[] manifestListDetailVOs;
	private SignOnUserAccount account;

    // Database Access Object
    private transient ChinaManifestListDownloadDBDAO dbDao = new ChinaManifestListDownloadDBDAO();
    
	/**
	 * 다운로드 할 데이터 세팅
	 * 
	 * @param ManifestListDetailVO[] detailVOs
	 * @param SignOnUserAccount account
	 */
	public void setManifestListDetailVO(ManifestListDetailVO[] detailVOs, SignOnUserAccount account) {
		this.manifestListDetailVOs = detailVOs;
		this.account = account;
	}
	
	/**
	 * 세관에 적하목록을 신고하기 위해 B/L Manifest 정보를 세관 테이블로 Download 한다.<br>
	 * @return Object
	 * @exception EventException
	 */
	public Object doStart() throws EventException {
		try {
			ChinaManifestListDetailVO[] chinaManifestListDetailVOs = (ChinaManifestListDetailVO[])this.manifestListDetailVOs;
			ChinaManifestListDetailVO detailVO = chinaManifestListDetailVOs[0];
			
			String strVvd = detailVO.getVvd();
			String strTransMode = detailVO.getTransMode();
			String strLocCd = detailVO.getLocCd();
			String strBkgCgoTpCd = detailVO.getBkgCgoTpCd();
			
			ChnBlKeyVO chnBlKeyVO = null;
			List<ChnBlKeyVO> blKeyVOs = new ArrayList<ChnBlKeyVO>();

			List<String> bkgNoList = generateBkgNoList(chinaManifestListDetailVOs);
			List<String> blNoList = generateBlNoList(chinaManifestListDetailVOs);
				
			for(int i=0; i<bkgNoList.size(); i++){
				chnBlKeyVO = new ChnBlKeyVO();
				// 조회 데이터
				chnBlKeyVO.setVvd(strVvd);
				chnBlKeyVO.setTransMode(strTransMode);
				chnBlKeyVO.setLocCd(strLocCd);
				chnBlKeyVO.setBkgCgoTpCd(strBkgCgoTpCd);
				// insert 시 등록자 이름 저장
				chnBlKeyVO.setUsrId(account.getUsr_id());
				// select 시 조회 데이터
				chnBlKeyVO.setBkgNo(bkgNoList.get(i));
				// delete 시 조회 데이터
				chnBlKeyVO.setBlNo(blNoList.get(i));
				
				blKeyVOs.add(chnBlKeyVO);
			}
			
			String transMode = chinaManifestListDetailVOs[0].getTransMode();
	
			
			/*==============================================================*/
			/* VVD 기본 정보 GET -> Download                                  */
			/*==============================================================*/
			if("D".equals(transMode)){
				List<BkgCstmsChnVvdVO> bkgCstmsChnVvdVOs = dbDao.searchVslInfoList ( blKeyVOs );
				if(bkgCstmsChnVvdVOs.size() > 0){
					dbDao.removeVslInfoList ( blKeyVOs , transMode );
					dbDao.addVslInfoList ( bkgCstmsChnVvdVOs );
				}
			}
			else{
				BkgCstmsChnVvdVO bkgCstmsChnVvdVO = dbDao.searchVslInfo ( chnBlKeyVO );
				if(bkgCstmsChnVvdVO != null){
					dbDao.removeCncusVslInfo ( chnBlKeyVO , transMode );
					dbDao.addVslInfo ( bkgCstmsChnVvdVO );
				}
			}
			
			dbDao.removeBlAllList(blKeyVOs , transMode);
			dbDao.removeBlCustAllList(blKeyVOs , transMode);
			dbDao.removeBlCntrAllList(blKeyVOs , transMode);
			dbDao.removeBlCntrSealNoAllList(blKeyVOs , transMode);
			dbDao.removeBlMdList2(blKeyVOs , transMode);
			/*==============================================================*/
			/* BL 정보 GET -> Download                                       */
			/*==============================================================*/
			List<BkgCstmsChnBlVO> bkgCstmsChnBlVOs = dbDao.searchBlList ( blKeyVOs );
			
			if(bkgCstmsChnBlVOs.size() > 0){
				String[] blData = null;
				BkgCstmsChnBlVO chnBlVO = null;
				
				// 하나의 컬럼으로 넘어온 B/L 정보를 각각의 데이터로 잘라서 셋팅
				for(int i=0; i<bkgCstmsChnBlVOs.size(); i++){
					chnBlVO = bkgCstmsChnBlVOs.get(i);
					blData = chnBlVO.getBlNo().split("\t");
	
					chnBlVO.setBlNo(blData[1]);
					chnBlVO.setVslCd(blData[3]);
					chnBlVO.setSkdVoyNo(blData[4]);
					chnBlVO.setSkdDirCd(blData[5]);
					chnBlVO.setPortCd(blData[6]);
					chnBlVO.setBkgPolCd(blData[6]);
					chnBlVO.setBkgPodCd(blData[7]);
					chnBlVO.setPorCd(blData[8]);
					chnBlVO.setPolCd(blData[9]);
					chnBlVO.setPodCd(blData[10]);
					chnBlVO.setDelCd(blData[11]);
					chnBlVO.setBlIssDt(blData[12]);
					chnBlVO.setBlObrdDt(blData[13]);
					chnBlVO.setChnCstmsTrspModCd(blData[14]);
					chnBlVO.setRcvTermCd(blData[15]);
					chnBlVO.setDeTermCd(blData[16]);
					chnBlVO.setFrtTermCd(blData[17]);
					chnBlVO.setCstmsDesc(blData[18]);
					chnBlVO.setPckQty(blData[19]);
					chnBlVO.setPckTpCd(blData[20]);
					chnBlVO.setActWgt(blData[21]);
					chnBlVO.setWgtUtCd(blData[22]);
					chnBlVO.setMeasQty(blData[23]);
					chnBlVO.setMeasUtCd(blData[24]);
					chnBlVO.setBkgCgoTpCd(blData[25]);
					chnBlVO.setDcgoFlg(blData[26]);
					chnBlVO.setRcFlg(blData[27]);
					chnBlVO.setBlIssOfcCd(blData[28]);
					chnBlVO.setChnMfSndIndCd(blData[29]);
					chnBlVO.setBlPodEtaDt(blData[30]);
					chnBlVO.setPodYdCd(blData[31]);
					//chnBlVO.setPodRoutDesc(blData[31]);
					chnBlVO.setPodRoutDesc(dbDao.searchPodRoutDesc(chnBlVO));
					chnBlVO.setCreUsrId(chnBlKeyVO.getUsrId());
					chnBlVO.setUpdUsrId(chnBlKeyVO.getUsrId());
				}
				
				dbDao.removeBlList ( blKeyVOs , transMode );
				dbDao.removeBlDlHis ( blKeyVOs , transMode, account.getUsr_id());
				dbDao.addBlList ( bkgCstmsChnBlVOs );
				dbDao.addBlDlHis ( bkgCstmsChnBlVOs );
			}
	
			/*==============================================================*/
			/* CUST 정보 GET -> Download                                     */
			/*==============================================================*/
			List<BkgCstmsChnCustVO> bkgCstmsChnCustVOs = dbDao.searchBlCustList ( blKeyVOs );
			if(bkgCstmsChnCustVOs.size() > 0){
				dbDao.removeBlCustList ( blKeyVOs , transMode );
				dbDao.addBlCustList ( bkgCstmsChnCustVOs );
			}
	
			/*==============================================================*/
			/* CNTR 정보 GET -> Download                                     */
			/*==============================================================*/
			List<BkgCstmsChnCntrVO> bkgCstmsChnCntrVOs = dbDao.searchBkgCntr ( blKeyVOs );
			if(bkgCstmsChnCntrVOs.size() > 0){
				dbDao.removeBlCntrList ( blKeyVOs , transMode );
				dbDao.addBlCntrList ( bkgCstmsChnCntrVOs );
				
				// TO-BE 에서 별도로 분리된 BKG_CSTMS_SEAL_NO 테이블에 데이터 조회 및 다운로드
				List<BkgCstmsSealNoVO> bkgCstmsSealNoVOs = dbDao.searchBkgCntrSealNo ( blKeyVOs );
				if(bkgCstmsSealNoVOs.size() > 0){
					dbDao.removeBlCntrSealNoList ( blKeyVOs , transMode );
					dbDao.addBlCntrSealNoList ( bkgCstmsSealNoVOs );
				}
			}
	
			/*==============================================================*/
			/* Danger Cargo 정보 GET -> Download                             */
			/*==============================================================*/
			List<BkgCstmsChnDgCgoVO> bkgCstmsChnDgCgoVOs = dbDao.searchCntrDgList ( blKeyVOs );
			if(bkgCstmsChnDgCgoVOs.size() > 0){
				dbDao.removeBlCntrDgList ( blKeyVOs , transMode );
				dbDao.addBlCntrDgList ( bkgCstmsChnDgCgoVOs );
			}
	
			/*==============================================================*/
			/* Awkward 정보 GET -> Download                                  */
			/*==============================================================*/
			List<BkgCstmsChnAwkVO> bkgCstmsChnAwkVOs = dbDao.searchCntrAkList ( blKeyVOs );
			if(bkgCstmsChnAwkVOs.size() > 0){
				dbDao.removeBlCntrAkList ( blKeyVOs , transMode );
				dbDao.addBlCntrAkList ( bkgCstmsChnAwkVOs );
			}
	
			/*==============================================================*/
			/* Reefer Cargo 정보 GET -> Download                             */
			/*==============================================================*/
			List<BkgCstmsChnRfVO> bkgCstmsChnRfVOs = dbDao.searchCntrRfList ( blKeyVOs );
			if(bkgCstmsChnRfVOs.size() > 0){
				dbDao.removeBlCntrRfList ( blKeyVOs , transMode );
				dbDao.addBlCntrRfList ( bkgCstmsChnRfVOs );
			}
	
			/*==============================================================*/
			/* Mark Desc 정보 GET -> Download                                */
			/*==============================================================*/
			List<BkgCstmsChnMkVO> bkgCstmsChnMkVOs = dbDao.searchBlMdList ( blKeyVOs );
			
			if(bkgCstmsChnMkVOs.size() > 0){
				String[] blData = null;
				BkgCstmsChnMkVO chnMkVO = null;
	
				// 하나의 컬럼으로 넘어온 MK 정보를 각각의 데이터로 잘라서 셋팅
				for(int i=0; i<bkgCstmsChnMkVOs.size(); i++){
					chnMkVO = bkgCstmsChnMkVOs.get(i);
					blData = chnMkVO.getBlNo().split("\t");
					
					chnMkVO.setBlNo(blData[0]);
					chnMkVO.setBlMkSeq(blData[1]);
					chnMkVO.setChnMfSndIndCd(blData[2]);
				}
				dbDao.removeBlMdList ( blKeyVOs , transMode );
				dbDao.addBlMdList ( bkgCstmsChnMkVOs );
			}
			
			return null;
			
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}

    /**
     *  IN 절에 들어갈 BKG_NO 문자열로 생성
     *  IN 절에 데이터가 1000건 이상이면 ORA-1795 오류 발생하므로
     *  1000건씩 컴마로 연결된 문자열을 생성하여 넘긴다.
     *  
	 * @param ChinaManifestListDetailVO[] detailVOs
	 * @return List<String>
	 * @exception EventException
     */
	@SuppressWarnings("unchecked")
	private List<String> generateBkgNoList(ChinaManifestListDetailVO[] detailVOs) throws EventException {
		try {
			List<String> arrString = new ArrayList();  //BKG_NO
			StringBuffer sb = new StringBuffer();
			int bkgCnt = detailVOs.length;
			int quotaCnt = bkgCnt / 1000;
			int restCnt = bkgCnt % 1000;
			
			for (int i=1; i<=quotaCnt; i++) {
				sb.delete(0, sb.length());
				for (int j=i*1000-1000; j<i*1000; j++) {	
					if(j == i*1000-1000){
						sb.append("'").append(detailVOs[j].getBkgNo()).append("'");
					}else{
						sb.append(",'").append(detailVOs[j].getBkgNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}
			
			if(restCnt > 0){
				sb.delete(0, sb.length());
				for (int i=quotaCnt*1000; i<bkgCnt; i++) {	
					if(i == quotaCnt*1000){
						sb.append("'").append(detailVOs[i].getBkgNo()).append("'");
					}else{
						sb.append(",'").append(detailVOs[i].getBkgNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}
			
			return arrString;
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}

    /**
     *  IN 절에 들어갈 BL_NO 문자열로 생성
     *  IN 절에 데이터가 1000건 이상이면 ORA-1795 오류 발생하므로
     *  1000건씩 컴마로 연결된 문자열을 생성하여 넘긴다.
     *  
	 * @param ChinaManifestListDetailVO[] detailVOs
	 * @return List<String>
	 * @exception EventException
     */
	@SuppressWarnings("unchecked")
	private List<String> generateBlNoList(ChinaManifestListDetailVO[] detailVOs) throws EventException {
		try {
			List<String> arrString = new ArrayList();  //BKG_NO
			StringBuffer sb = new StringBuffer();
			int bkgCnt = detailVOs.length;
			int quotaCnt = bkgCnt / 1000;
			int restCnt = bkgCnt % 1000;
			
			for (int i=1; i<=quotaCnt; i++) {
				sb.delete(0, sb.length());
				for (int j=i*1000-1000; j<i*1000; j++) {	
					if(j == i*1000-1000){
						sb.append("'").append(detailVOs[j].getBlNo()).append("'");
					}else{
						sb.append(",'").append(detailVOs[j].getBlNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}
			
			if(restCnt > 0){
				sb.delete(0, sb.length());
				for (int i=quotaCnt*1000; i<bkgCnt; i++) {	
					if(i == quotaCnt*1000){
						sb.append("'").append(detailVOs[i].getBlNo()).append("'");
					}else{
						sb.append(",'").append(detailVOs[i].getBlNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}
			
			return arrString;
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}
}