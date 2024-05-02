/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BangladeshManifestListDownloadBCImpl.java
*@FileTitle : Bangladesh Cargo Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 전창현
*@LastVersion : 1.0
* 2009.10.06 전창현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.integration.BangladeshManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListInboundVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListOutboundVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Subin
 * @see 각 DAO 클래스 참조  
 * @since J2EE 1.4
 */
public class BangladeshManifestListDownloadBCImpl  extends ManifestListDownloadBCImpl {
	
	// Database Access Object
	private transient BangladeshManifestListDownloadDBDAO dbDao = null;
	
	/**
	 * BangladeshManifestListDownloadBCImpl 객체 생성<br>
	 * BangladeshManifestListDownloadDBDAO 생성한다.<br>
	 */
	public BangladeshManifestListDownloadBCImpl() {
		dbDao = new BangladeshManifestListDownloadDBDAO();
	}	

	/**
	 * 세관에 신고할 대상 Manifest 정보(Download 받을 데이터)를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try {
			BangladeshManifestListCondVO condVO = (BangladeshManifestListCondVO)manifestListCondVO;
			List<ManifestListDetailVO> list = null;
			List<ManifestListDetailVO> returnList = new ArrayList<ManifestListDetailVO>();
			
			if(condVO.getIoFlag().equals("I")){
				List<BangladeshManifestListInboundVO> tempList = new ArrayList<BangladeshManifestListInboundVO>();
				BangladeshManifestListInboundVO inboundVO = null;
				BangladeshManifestListInboundVO tempVO = null;
				BangladeshManifestListInboundVO tempVO2 = null;
				
				
				// B/L list 조회
				list = dbDao.searchManifestList(condVO);
				for(int i=0; i<list.size(); i++){
					returnList.add((BangladeshManifestListInboundVO)list.get(i));
				}
	
				String lineNo = "";
				String blNo = "";
				String strWgt = null;
	
				int totalQty = 0;
				float totalWgt = 0;
	
				for(int i=0; i<list.size(); i++){
					inboundVO = (BangladeshManifestListInboundVO)list.get(i);
					if( !(lineNo.equals(inboundVO.getLineNo()) && blNo.equals(inboundVO.getBlNo())) ){
	
						// 이전 VO의 LineNo,BlNo 와 다를 경우 현재 VO의 데이터로 할당한다.
						lineNo = inboundVO.getLineNo();
						blNo = inboundVO.getBlNo();
						tempList.clear();
						totalQty = 0;
						totalWgt = 0;
	
						// 현재 VO의  LineNo,BlNo 와 동일한 데이터 VO만 tempList에 담는다.
						for(int j=i; j<list.size(); j++){
							inboundVO = (BangladeshManifestListInboundVO)list.get(j);
							if( lineNo.equals(inboundVO.getLineNo()) && blNo.equals(inboundVO.getBlNo()) ){
								tempList.add((BangladeshManifestListInboundVO)inboundVO.clone());
							}
							else{
								// 다른 데이터가 나오면 for문 빠져나감
								break;
							}
						}
	
						for(int k=0; k<tempList.size(); k++){
							tempVO = (BangladeshManifestListInboundVO)tempList.get(k).clone();
	
							// Qty, Container Weight 계산
							totalQty += Integer.parseInt(tempVO.getQty());
							totalWgt += Float.parseFloat(tempVO.getCntrWgt());
	
							if(k == 0){
								tempVO2 = tempVO;
							}
							else{
								tempVO.setLineNo("");
								tempVO.setBlNo("");
								tempVO.setQty("");
								tempVO.setDescription("");
								tempVO.setMarks("");
								tempVO.setGoodsDesc("");
								tempVO.setGoodsDate("");
								tempVO.setConsLice("");
								tempVO.setConsNm("");
								tempVO.setNotyLice("");
								tempVO.setNotyNm("");
								tempVO.setBlGrossWgt("");
							}
	
							// 중복 데이터를 지운 VO를 returnList 에 담는다.
							returnList.add((ManifestListDetailVO)tempVO);
						}
	
						// Qty, Container Weight 값 세팅
						if(tempVO2 != null){
							tempVO2.setQty(Integer.toString(totalQty));
						}						
						strWgt = Float.toString(totalWgt);
						if(strWgt.substring(strWgt.indexOf(".")).length() == 2) strWgt = strWgt.concat("0");
						if(tempVO2 != null){
							tempVO2.setBlGrossWgt(strWgt+" "+tempVO2.getCntrUtCd());
						}
					}
				}

			}
			else if(condVO.getIoFlag().equals("O")){
				
				// B/L list 조회
				list = dbDao.searchManifestList(condVO);
				for(int i=0; i<list.size(); i++){
					returnList.add((BangladeshManifestListOutboundVO)list.get(i));
				}
				
			}
			
			return 	returnList;
			
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
        }
	}
	
	/**
	 * 세관에 신고할 대상 Manifest 정보(Download 받을 데이터)를 삭제/입력한다.<br>
	 * 
	 * @param ManifestModificationVO manifestModificationVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
    public void manageManifest(ManifestModificationVO manifestModificationVO, SignOnUserAccount account) throws EventException {
		try {
			BangladeshManifestModificationVO modiVO = (BangladeshManifestModificationVO)manifestModificationVO;
			
			if(modiVO.getIoFlag().equals("I")){
				
				List<BangladeshManifestListInboundVO> inboundVoList = new ArrayList<BangladeshManifestListInboundVO>();
				BangladeshManifestListInboundVO inboundVO = modiVO.getBangladeshManifestListInboundVOs()[0];
				
				dbDao.removeManifestList(inboundVO.getVvd(), inboundVO.getPodCd());
				
				for(int i=0; i<modiVO.getBangladeshManifestListInboundVOs().length; i++){
					inboundVO = modiVO.getBangladeshManifestListInboundVOs()[i];
					inboundVO.setCreUsrId(account.getUsr_id());
					inboundVO.setUpdUsrId(account.getUsr_id());
					inboundVoList.add(inboundVO);
				}
				dbDao.addManifestList(inboundVoList);
			}
			else if(modiVO.getIoFlag().equals("O")){
				
				List<BangladeshManifestListOutboundVO> outboundVoList = new ArrayList<BangladeshManifestListOutboundVO>();
				BangladeshManifestListOutboundVO outboundVO = modiVO.getBangladeshManifestListOutboundVOs()[0];
				
				dbDao.removeObManifestList(outboundVO.getVvd(), outboundVO.getPolCd());
				
				for(int i=0; i<modiVO.getBangladeshManifestListOutboundVOs().length; i++){
					outboundVO = modiVO.getBangladeshManifestListOutboundVOs()[i];
					outboundVO.setCreUsrId(account.getUsr_id());
					outboundVO.setUpdUsrId(account.getUsr_id());
					outboundVoList.add(outboundVO);
				}
				dbDao.addObManifestList(outboundVoList);
				
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	
    }
	
}

