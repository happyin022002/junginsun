/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : Edi322ReceiveBCImpl.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-01
*@LastModifier : 
*@LastVersion : 1.0
* 2009-11-01 
* 1.0 최초 생성
* 2010.11.01 김진승 [소스품질 보완] 중첩 try catch 보완 
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.edi322receive.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.integration.Edi322ReceiveDBDAO;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.vo.SearchEdi322ActDatRcvDtVO;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.vo.SearchEdi322BkgNoVO;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.vo.SearchEdi322CntrNoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SCEM EDI 322 Message
 * - SCEM EDI 322 Message에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author
 * @see 
 * @since J2EE 1.4
 */
public class Edi322ReceiveBCImpl   extends BasicCommandSupport implements Edi322ReceiveBC {
	
	private transient Edi322ReceiveDBDAO dbDao=null;
	/**
	 * Edi214ReceiveBCImpl 생성자
	 */	
    public Edi322ReceiveBCImpl(){
        dbDao = new Edi322ReceiveDBDAO();
    }
    
	/**
	 * 322 MSG를 FF에서 분리 
	 * @param String str
	 * @return ArrayList<HashMap<String, String>>
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<HashMap<String, String>> getEDI322DataFormat(String str) throws EventException {
		log.info("\n==========getEDI322DataFormat  START=================================\n" );

		java.io.BufferedReader br = null;
		ArrayList unitStrArrLst = new ArrayList();   // {CNTR_MAIN 구분자로  잘라진  문자열의 ArrayList
		ArrayList<HashMap<String, String>> totalParamArrLst = new ArrayList();
		
		try {

			/**
			 * 유효성 검사 : { } 앞뒤 확인, 쌍으로 왔는지 등 + HDR 1X, CNTR_LIST MX, DTL MX의 배열 생성
			 */
//			if (str.indexOf("{TES_EDI_SO_HDR")!=str.lastIndexOf("{TES_EDI_SO_HDR") && 
//				str.indexOf("}TES_EDI_SO_HDR")!=str.lastIndexOf("}TES_EDI_SO_HDR")) {
//				throw new EventException("181818181");
//			}

			/**
			 * HDR, CNTR_LIST, DTL로 쪼개어 담을 배열의 크기 구하기 - Table명을 나중에 DB에서 불러오게 해도 된다.
			 */
			String[] arr_search_substr= {"{HDR","{CNTR_MAIN","{BKG_NO"};
			String msgStart = null;
			HashMap<String, String> cntr 	= null;

			cntr 	= new HashMap<String, String>();

			/**
			 * HDR, cntr, BKGNO로 쪼개어 response에 담기
			 */			
			String buffer = null;
			String curr_blk = null;
			br = new java.io.BufferedReader(new java.io.StringReader(str));
			String[] tmp = null;
			
			
			//msgStart  추출  , "}CNTR_MAIN" 구분자로 입력 String 자르기
			StringBuffer sb = new StringBuffer();
			while ((buffer=br.readLine()) != null){
				sb.append(buffer);
				sb.append("\n");
				
				if (buffer!=null && !buffer.trim().equals("")){
					if (buffer.trim().startsWith("$$$MSGSTART:")){
						msgStart = buffer!=null&&!buffer.trim().equals("")&&buffer.length()>=("$$$MSGSTART:".length()+20)?buffer.substring(12,32).trim():"";
						log.debug(msgStart);
					}else if(buffer.trim().startsWith("}CNTR_MAIN")){
						unitStrArrLst.add(sb.toString());
						sb.delete(0, sb.length());
					}else{
					}
						
				}
			}	
			
			for(int i=0;i<unitStrArrLst.size();i++){
				log.info("\n==========unitStrArrLst "+i+"===========================   "+unitStrArrLst.get(i) );
			}
			Iterator itr =unitStrArrLst.iterator();
		
			while(itr.hasNext()){
				ArrayList bkgNoArrLst = new ArrayList();
				String tempStr =(String)itr.next();
				
				br = new java.io.BufferedReader(new java.io.StringReader(tempStr));
				
				//BKG_NO의 반복횟수  계산
				while ((buffer=br.readLine()) != null){
					tmp=null;
					if (buffer!=null && !buffer.trim().equals("")){
						if (buffer.trim().startsWith("{")){
							curr_blk = buffer.trim();
						} else {
							if (curr_blk!=null && curr_blk.equals(arr_search_substr[0])){
								if ((tmp = buffer.trim().split(":"))!=null){
									tmp = null;
								}
							} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[1]) && buffer!=null && !buffer.trim().equals(arr_search_substr[1])){
								if ((tmp = buffer.trim().split(":"))!=null){
									tmp = null;
								}
							} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[2]) && buffer!=null && !buffer.trim().equals(arr_search_substr[2])){
								if (buffer.trim().contains(":")){
									tmp=buffer.trim().split(":");
									bkgNoArrLst.add(tmp.length==2?tmp[1]:"");
								}
							}
						}
					}
				}			
				curr_blk = null;
				log.info("\n==========bkgNoArrLst.size=========================== "+bkgNoArrLst.size());
				
				for(int i=0; i<bkgNoArrLst.size();i++){
					br = new java.io.BufferedReader(new java.io.StringReader(tempStr));
					cntr = new HashMap();
					
					while ((buffer=br.readLine()) != null){
						if (buffer!=null && !buffer.trim().equals("")){
							if (buffer.trim().startsWith("{")){
								curr_blk = buffer.trim();
							} else {
								if (curr_blk!=null && curr_blk.equals(arr_search_substr[0])){
									if ((tmp = buffer.trim().split(":"))!=null){
										log.debug(" --- a ");
									}
								} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[1]) && buffer!=null && !buffer.trim().equals(arr_search_substr[1])){
									if ((tmp = buffer.trim().split(":"))!=null){
										cntr.put(tmp[0],tmp.length==2?tmp[1]:"");
										log.debug(" --- b ");
									}
								} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[2]) && buffer!=null && !buffer.trim().equals(arr_search_substr[2])){
									if ((tmp = buffer.trim().split(":"))!=null){
										log.debug(" --- c ");
									}
								} 
							}
						}
					}
					
					cntr.put("BKG_NO", (String)bkgNoArrLst.get(i));  //BKG_NO 저장
					cntr.put("SNDR_ID", cntr.get("TMNL_ID"));  //SNDR_ID 저장, SCE_ACT_RCV_IF에  ACT_CD로 I/F
					
					log.info("\n==========Impl 322  START=================================\n" +
							" AREA: "+cntr.get("AREA") +"\n" +
							" MSG_ID: "+cntr.get("MSG_ID") +"\n" +
							" CNTR_NO: "+cntr.get("CNTR_NO") +"\n" +
							" TMNL_ID: "+cntr.get("TMNL_ID") +"\n" +
							" EVENT_YARD: "+cntr.get("EVENT_YARD") +"\n" +
							" EVENT_YARD_US: "+cntr.get("EVENT_YARD_US") +"\n" +
							" EVENT_DT: "+cntr.get("EVENT_DT") +"\n" +
							" EVNT_CTY_NM: "+cntr.get("EVNT_CTY_NM") +"\n" +
							" EVNT_STE_CD: "+cntr.get("EVNT_STE_CD") +"\n" +
							" RAIL_DEST_N1ST_ETA_DT: "+cntr.get("RAIL_DEST_N1ST_ETA_DT") +"\n" +
							" MVMT_STS: "+cntr.get("MVMT_STS") +"\n" +
							" EVENT_STS: "+cntr.get("EVENT_STS") +"\n" +
							" GATE_IO: "+cntr.get("GATE_IO") +"\n" +
							" FL_MT_IND: "+cntr.get("FL_MT_IND") +"\n" +
							" SIGHT_CD: "+cntr.get("SIGHT_CD") +"\n" +
							" CALLSIGN: "+cntr.get("CALLSIGN") +"\n" +
							" LLOYD_NO: "+cntr.get("LLOYD_NO") +"\n" +
							" BL_NO: "+cntr.get("BL_NO") +"\n" +
							" POL: "+cntr.get("POL") +"\n" +
							" POD: "+cntr.get("POD") +"\n" +
							" DEST_LOC: "+cntr.get("DEST_LOC") +"\n" +
							" DEST_NM: "+cntr.get("DEST_NM") +"\n" +
							" DEST_STS: "+cntr.get("DEST_STS") +"\n" +
							" DMG_FLAG: "+cntr.get("DMG_FLAG") +"\n" +
							" PICKUP_NO: "+cntr.get("PICKUP_NO") +"\n" +
							" MG_SET: "+cntr.get("MG_SET") +"\n" +
							" SUBSTITUTION: "+cntr.get("SUBSTITUTION") +"\n" +
							" CARRIER_COUNTRY: "+cntr.get("CARRIER_COUNTRY") +"\n" +
							" CARRIER_CD: "+cntr.get("CARRIER_CD") +"\n" +
							" TRANS_MODE: "+cntr.get("TRANS_MODE") +"\n" +
							" FLAT_CAR_NO: "+cntr.get("FLAT_CAR_NO") +"\n" +
							" HANGER_TAG: "+cntr.get("HANGER_TAG") +"\n" +
							" WAY_BILL_NO: "+cntr.get("WAY_BILL_NO") +"\n" +
							" DEL_TAG: "+cntr.get("DEL_TAG") +"\n" +
							" SEAL_NO: "+cntr.get("SEAL_NO") +"\n" +
							" BKG_NO: "+cntr.get("BKG_NO") +"\n" +
							" SNDR_ID: "+cntr.get("SNDR_ID") +"\n" +
							"==========322  END=================================" +"\n" +
							"");
					totalParamArrLst.add(cntr);
				}
			}

			} catch (Exception e){
				log.error(e.getMessage());
				try {if (br!=null)br.close();
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
				throw new EventException(e.getMessage());
		}
		return totalParamArrLst;
	}

	/**
	 * 322 MSG 임시 데이터를 생성한다
	 * 
	 * @param totalParamArrLst ArrayList
	 * @exception EventException - 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void createEDI322TmpData(ArrayList totalParamArrLst) throws EventException { 
		CopDetailReceiveBC command = null;
		HashMap<String, Object> param = null;

		try {
			command =new CopDetailReceiveBCImpl();
			param = new HashMap<String, Object>();
			
			Iterator itr =totalParamArrLst.iterator();
			while(itr.hasNext()){
				param =(HashMap)itr.next();
				createEDI322TmpDataUnit(command, param); 
			}	

		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}	

	/**
	 * 
	 * @param command
	 * @param param
	 */
	private void createEDI322TmpDataUnit(CopDetailReceiveBC command, HashMap<String, Object> param) {
		SearchEdi322CntrNoVO searchEdi322CntrNoVO = null;
		String cntrNo=null;
		
		try{
			param = new HashMap<String, Object>();
			searchEdi322CntrNoVO = new SearchEdi322CntrNoVO();
			
			cntrNo= ((String)param.get("CNTR_NO")).trim();

			//CNTR_NO 보정    11자리아닌경우
			if(cntrNo.length()==10  && !param.get("BKG_NO").equals("EMPTY REPO")){
				log.info("\n==========    cntrNo   10================================= " +cntrNo );
				searchEdi322CntrNoVO.setCntrNo(cntrNo);
				List<SearchEdi322CntrNoVO> result =dbDao.searchEdi322CntrNoVO(searchEdi322CntrNoVO);
				
				
				if(result.size()>0){
					cntrNo =result.get(0).getCntrNo();
					log.info("\n==========    cntrNo   10  --->    corrected cntrNo ============ " +cntrNo );
				}
				
			}else if(cntrNo.length() >11 && !param.get("BKG_NO").equals("EMPTY REPO")){
				cntrNo = cntrNo.substring(0,11);
			}
			param.put("CNTR_NO", cntrNo);     //보정된 CNTR_NO 넣기
			
			//EVENT_DT, CNTR_NO, EVENT_STS
			if(param.get("EVENT_DT")!=null && !param.get("EVENT_DT").equals("")
			 && param.get("CNTR_NO")!=null && !param.get("CNTR_NO").equals("")
			 && param.get("EVENT_STS")!=null && !param.get("EVENT_STS").equals("")){
				
				dbDao.createEDI322TmpData(param);	
				
				if(!param.get("BKG_NO").equals("EMPTY REPO") && 
				   (
				   param.get("EVENT_STS").equals("AL") || 
				   param.get("EVENT_STS").equals("RL") || 
				   param.get("EVENT_STS").equals("AR") ||
				   param.get("EVENT_STS").equals("UR") ||
				   param.get("EVENT_STS").equals("P")  
				   )){
					SearchEdi322BkgNoVO searchEdi322BkgNoVO = new SearchEdi322BkgNoVO();
					searchEdi322BkgNoVO.setCntrNo((String)param.get("CNTR_NO"));
					
					// 최신 컨테이너의 최신 BKG_NO 찾기 
					List<SearchEdi322BkgNoVO> resultSearchEdi322BkgNoVO= dbDao.searchEdi322BkgNo(searchEdi322BkgNoVO);
					
					SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
					sceActRcvIfVO.setActStsMapgCd((String)param.get("EVENT_STS")); //ACT_STS_MAPG_CD
					sceActRcvIfVO.setCntrNo((String)param.get("CNTR_NO")); //CNTR_NO
					if(param.get("EVENT_STS").equals("P")&&(((String)param.get("EVENT_YARD")).length()==0)){
						sceActRcvIfVO.setNodCd("XXXXXXX"); //NOD_CD
					}else{
						sceActRcvIfVO.setNodCd((String)param.get("EVENT_YARD")); //NOD_CD
					}	
					sceActRcvIfVO.setActDt((String)param.get("EVENT_DT")); //ACT_DT
					if(((String)param.get("SNDR_ID")).length()>6){
						sceActRcvIfVO.setActCd(((String)param.get("SNDR_ID")).substring(0, 6)); //ACT_CD
					}else if(((String)param.get("SNDR_ID")).length()==0){
						sceActRcvIfVO.setActCd("");
					}else{
						sceActRcvIfVO.setActCd((String)param.get("SNDR_ID")); //ACT_CD	
					}
					sceActRcvIfVO.setRailDestN1stEtaDt((String)param.get("RAIL_DEST_N1ST_ETA_DT")); //RAIL_DEST_N1ST_ETA_DT
					sceActRcvIfVO.setUpdUsrId((String)param.get("TMNL_ID"));
					sceActRcvIfVO.setCreUsrId((String)param.get("TMNL_ID"));
					
					// ACT_DAT_RCV_DT 구하기
					SearchEdi322ActDatRcvDtVO searchEdi322ActDatRcvDtVO = new SearchEdi322ActDatRcvDtVO();
					searchEdi322ActDatRcvDtVO.setEventYard((String)param.get("EVENT_YARD"));
					List<SearchEdi322ActDatRcvDtVO> resultSearchEdi322ActDatRcvDtVO= dbDao.searchEdi322ActDatRcvDt(searchEdi322ActDatRcvDtVO);
					log.info("\n==========    SearchEdi322ActDatRcvDtVO  ========================  "  +resultSearchEdi322ActDatRcvDtVO.size());
					if(resultSearchEdi322ActDatRcvDtVO.size()>0){
						String actDatRcvDt =resultSearchEdi322ActDatRcvDtVO.get(0).getActDatRcvDt();
						sceActRcvIfVO.setActDatRcvDt(actDatRcvDt);
						log.info("\n==========    sceActRcvIfVO.setActDatRcvDt("+actDatRcvDt+")  ========================  " );
					}
					log.info("\n==========    resultSearchEdi322BkgNoVO.size():"+resultSearchEdi322BkgNoVO.size());
					for(int i=0; i< resultSearchEdi322BkgNoVO.size();i++){
						String bkgNo= resultSearchEdi322BkgNoVO.get(i).getBkgNo();
						sceActRcvIfVO.setBkgNo(bkgNo);
						log.error("\n==========    create322SceIf 호출  searchEdi322BkgNo get BkgNo bkg# ["+bkgNo+"] sceActRcvIfVO.getBkgNo(): " +sceActRcvIfVO.getBkgNo());
						create322SceIfUnit(command, sceActRcvIfVO,bkgNo);
					}
					
				}
				//20100408 YARD값이 없는 경우 DIR IF SKIP!!
				if((param.get("EVENT_STS").equals("NT") || param.get("EVENT_STS").equals("NF") || 
						param.get("EVENT_STS").equals("FT")) && ((String)param.get("EVENT_YARD")).length()>0){
					dbDao.createEDI322MsgIf(param);
				}
			
			}
		
		}catch(DAOException e){
			log.error(e.getMessage());
			log.error("\n===========================   Error 322 Layout Start ==========================");
			log.error(param);
			log.error("\n===========================   Error 322 Layout End   ==========================");
		}
		
	}

	/**
	 * 
	 * @param command
	 * @param sceActRcvIfVO
	 * @param bkgNo
	 */
	private void create322SceIfUnit(CopDetailReceiveBC command, SceActRcvIfVO sceActRcvIfVO, String bkgNo) {
		try { 
			command.create322SceIf(sceActRcvIfVO,bkgNo);// 미작업
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEdi322CntrNoVO searchEdi322CntrNoVO
	 * @return List<SearchEdi322CntrNoVO>
	 * @exception EventException
	 */
	public List<SearchEdi322CntrNoVO> searchEdi322CntrNoVO(SearchEdi322CntrNoVO searchEdi322CntrNoVO) throws EventException {
		List<SearchEdi322CntrNoVO> list = null;

		try {
			list = dbDao.searchEdi322CntrNoVO(searchEdi322CntrNoVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}	
		return list;
	}		

	/**
	 * INSERT INTO EDI322MSG 
	 * @param Map<String, Object> param
	 * @exception EventException
	 */	
	public void createEDI322TmpData(Map<String, Object> param) throws EventException {
		try {
			dbDao.createEDI322TmpData(param);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}	

	}		
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEdi322BkgNoVO searchEdi322BkgNoVO
	 * @return List<SearchEdi322BkgNoVO>
	 * @exception EventException
	 */
	public List<SearchEdi322BkgNoVO> searchEdi322BkgNo(SearchEdi322BkgNoVO searchEdi322BkgNoVO) throws EventException {
		List<SearchEdi322BkgNoVO> list = null;
		try {
			list = dbDao.searchEdi322BkgNo(searchEdi322BkgNoVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return list;
	}			
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEdi322ActDatRcvDtVO searchEdi322ActDatRcvDtVO
	 * @return List<SearchEdi322ActDatRcvDtVO>
	 * @exception EventException
	 */
	public List<SearchEdi322ActDatRcvDtVO> searchEdi322ActDatRcvDt(SearchEdi322ActDatRcvDtVO searchEdi322ActDatRcvDtVO) throws EventException {
		List<SearchEdi322ActDatRcvDtVO> list = null;

		try {
			list = dbDao.searchEdi322ActDatRcvDt(searchEdi322ActDatRcvDtVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

		return list;
	}	
	
	/**
	 * create EDI322Msg If
	 * 
	 * @param Map<String, Object> param
	 * @exception EventException
	 */
	public void createEDI322MsgIf(Map<String, Object> param) throws EventException {
		try {
			dbDao.createEDI322MsgIf(param);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
}
