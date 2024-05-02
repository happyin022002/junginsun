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
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.integration.BangladeshManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListInboundVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListOutboundVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Subin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class BangladeshManifestListDownloadBCImpl extends BasicCommandSupport implements BangladeshManifestListDownloadBC {


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
				BangladeshManifestListInboundVO inboundVO = new BangladeshManifestListInboundVO();
				BangladeshManifestListInboundVO tempVO = new BangladeshManifestListInboundVO();


				// B/L list 조회
				list = dbDao.searchManifestList(condVO);
				for(int i=0; i<list.size(); i++){
					returnList.add((BangladeshManifestListInboundVO)list.get(i));
				}

				String lineNo = "";
				String blNo = "";

				for(int i=0; i<list.size(); i++){
					inboundVO = (BangladeshManifestListInboundVO)list.get(i);
					if( !(lineNo.equals(inboundVO.getLineNo()) && blNo.equals(inboundVO.getBlNo())) ){

						// 이전 VO의 LineNo,BlNo 와 다를 경우 현재 VO의 데이터로 할당한다.
						lineNo = inboundVO.getLineNo();
						blNo = inboundVO.getBlNo();
						tempList.clear();

						// 현재 VO의  LineNo,BlNo 와 동일한 데이터 VO만 tempList에 담는다.
						for(int j=i; j<list.size(); j++){
							inboundVO = (BangladeshManifestListInboundVO)list.get(j);
							if( lineNo.equals(inboundVO.getLineNo()) && blNo.equals(inboundVO.getBlNo()) ){
								tempList.add((BangladeshManifestListInboundVO)inboundVO.clone());
							} else{
								// 다른 데이터가 나오면 for문 빠져나감
								break;
							}
						}

						for(int k=0; k<tempList.size(); k++){
							tempVO = (BangladeshManifestListInboundVO)tempList.get(k).clone();
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

							// 중복 데이터를 지운 VO를 returnList 에 담는다.
							returnList.add((ManifestListDetailVO)tempVO);
						}
					}
				}

			} else if(condVO.getIoFlag().equals("O")){

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

