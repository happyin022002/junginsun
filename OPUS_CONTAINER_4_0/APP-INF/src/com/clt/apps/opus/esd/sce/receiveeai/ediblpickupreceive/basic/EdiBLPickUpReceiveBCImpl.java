/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EdiBLPickUpReceiveBCImpl.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-04
*@LastModifier : 
*@LastVersion : 1.0
* 2014-11-01 
* 1.0 최초 생성
* 2010.11.01 김진승 [소스품질 보완] 중첩 try catch 보완 
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.integration.EdiBLPickUpReceiveDBDAO;
import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.vo.SearchEdiBLPickUpCntrNoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SCEM EDI BLPickUp Message
 * - SCEM EDI BLPickUp Message에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author
 * @see 
 * @since J2EE 1.4
 */
public class EdiBLPickUpReceiveBCImpl   extends BasicCommandSupport implements EdiBLPickUpReceiveBC {
	
	// Database Access Object
	private transient EdiBLPickUpReceiveDBDAO dbDao=null;
	/**
	 * Edi214ReceiveBCImpl 생성자
	 */	
    public EdiBLPickUpReceiveBCImpl(){
        dbDao = new EdiBLPickUpReceiveDBDAO();
    }
    
	/** OK
	 * BLPickUp MSG를 FF에서 분리 
	 * @param String str
	 * @return ArrayList<HashMap<String, String>>
	 * @exception EventException
	 */
	public ArrayList<HashMap<String, String>> getEDIBLPickUpDataFormat(String str) throws EventException {
		log.info("\n==========getEDIBLPickUpDataFormat  START=================================\n" );
		//Event eventResponse = new EsdSce0150Event();
		java.io.BufferedReader br = null;
		ArrayList<String> unitStrArrLst = new ArrayList<String>();   // {CNTR_MAIN 구분자로  잘라진  문자열의 ArrayList
		ArrayList<HashMap<String, String>> totalParamArrLst = new ArrayList<HashMap<String, String>>();
		
		try {
			//str = str.trim();

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
			//String[] arr_search_substr= {"{HDR","{CNTR_MAIN","{BKG_NO"};
			String[] arr_search_substr= {"{HDR","{BLPICKUP"};
			String msgStart = null; 
			HashMap<String, String> cntr 	= null;

			cntr 	= new HashMap<String, String>();


			/**
			 * HDR, BLPICKUP, BKGNO로 쪼개어 response에 담기
			 */			
			String buffer = null;
			String curr_blk = null;
			br = new java.io.BufferedReader(new java.io.StringReader(str));
			String[] tmp = null;
			
			
			//msgStart  추출  , "}BLPICKUP" 구분자로 입력 String 자르기
			//2015.04.17 소스품질 Bad 처리.
			//String tmpStr="";
			StringBuffer sb = new StringBuffer();
			while ((buffer=br.readLine()) != null){
				sb.append(buffer);
				sb.append("\n");
			
				//tmpStr =tmpStr+buffer+"\n";
				if (buffer!=null && !buffer.trim().equals("")){
					if (buffer.trim().startsWith("$$$MSGSTART:")){
						msgStart = buffer!=null&&!buffer.trim().equals("")&&buffer.length()>=("$$$MSGSTART:".length()+20)?buffer.substring(12,32).trim():"";
						log.debug(msgStart);
					}else if(buffer.trim().startsWith("}BLPICKUP")){
						unitStrArrLst.add(sb.toString());
						sb.delete(0, sb.length());
						//unitStrArrLst.add(tmpStr);
						//tmpStr="";
					}else{
						//tmpStr= buffer+"\n";
					}
						
				}
			}	
			
/*			StringTokenizer st = new StringTokenizer(str,"}CNTR_MAIN"); 
			while (st.hasMoreTokens()){
				//unitStrArrLst.add((String)st.nextToken());    
				
				log.info("\n==========st.nextToken  ===========================   "+st.nextToken() );
			}*/
			for(int i=0;i<unitStrArrLst.size();i++){
				log.info("\n==========unitStrArrLst "+i+"===========================   "+unitStrArrLst.get(i) );
			}
			Iterator<String> itr =unitStrArrLst.iterator();
		
			while(itr.hasNext()){
				//ArrayList bkgNoArrLst = new ArrayList();
				String tempStr =(String)itr.next();
				
				br = new java.io.BufferedReader(new java.io.StringReader(tempStr));
				cntr = new HashMap<String, String>();
				//BKG_NO의 반복횟수  계산
				while ((buffer=br.readLine()) != null){
					tmp=null;
					if (buffer!=null && !buffer.trim().equals("")){
						if (buffer.trim().startsWith("{")){
							curr_blk = buffer.trim();
						} else {
							if (curr_blk!=null && curr_blk.equals(arr_search_substr[0])){
								if ((tmp = buffer.trim().split(":"))!=null){ // && tmp.length==2){
									//HDR.put(tmp[0],tmp.length==2?tmp[1]:"");
									tmp = null;
								}
							} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[1]) && buffer!=null && !buffer.trim().equals(arr_search_substr[1])){
								if ((tmp = buffer.trim().split(":"))!=null){ // && tmp.length==2){
									cntr.put(tmp[0],tmp.length==2?tmp[1]:"");
									tmp = null;
								}
							} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[2]) && buffer!=null && !buffer.trim().equals(arr_search_substr[2])){
								if (buffer.trim().contains(":")){ // && tmp.length==2){
									tmp=buffer.trim().split(":");
									//bkgNoArrLst.add(tmp.length==2?tmp[1]:"");
								}
							}
						}
					}
					
					totalParamArrLst.add(cntr);
				}			
				/*curr_blk = null;
				log.info("\n==========bkgNoArrLst.size=========================== "+bkgNoArrLst.size());
				
				for(int i=0; i<bkgNoArrLst.size();i++){
					br = new java.io.BufferedReader(new java.io.StringReader(tempStr));
					cntr = new HashMap();
					
					while ((buffer=br.readLine()) != null){
						//tmp=null;
						if (buffer!=null && !buffer.trim().equals("")){
							if (buffer.trim().startsWith("{")){
								curr_blk = buffer.trim();
							} else {
								if (curr_blk!=null && curr_blk.equals(arr_search_substr[0])){
									if ((tmp = buffer.trim().split(":"))!=null){ // && tmp.length==2){
										//HDR.put(tmp[0],tmp.length==2?tmp[1]:"");
										log.debug(" --- a ");
									}
								} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[1]) && buffer!=null && !buffer.trim().equals(arr_search_substr[1])){
									if ((tmp = buffer.trim().split(":"))!=null){ // && tmp.length==2){
										cntr.put(tmp[0],tmp.length==2?tmp[1]:"");
										log.debug(" --- b ");
									}
								} else if (curr_blk!=null && curr_blk.equals(arr_search_substr[2]) && buffer!=null && !buffer.trim().equals(arr_search_substr[2])){
									if ((tmp = buffer.trim().split(":"))!=null){ // && tmp.length==2){
										//bkgNO.put(tmp[0],tmp.length==2?tmp[1]:"");
										log.debug(" --- c ");
									}
								} 
							}
						}
					}
					
					//cntr.put("BKG_NO", (String)bkgNoArrLst.get(i));  //BKG_NO 저장
					//cntr.put("SNDR_ID", cntr.get("TMNL_ID"));  //SNDR_ID 저장, SCE_ACT_RCV_IF에  ACT_CD로 I/F
					
					log.info("\n==========Impl BLPickUp  START=================================\n" +							
							" CNTR_NBR: "+cntr.get("CNTR_NBR") +"\n" +							
							" YARD_CD: "+cntr.get("YARD_CD") +"\n" +							
							" SYS_DT: "+cntr.get("SYS_DT") +"\n" +							
							" EVENT_STS: "+cntr.get("EVENT_STS") +"\n" +							
							" BL_NBR: "+cntr.get("BL_NBR") +"\n" +							
							" PICK_NBR: "+cntr.get("PICK_NBR") +"\n" +							
							"==========BLPickUp  END=================================" +"\n" +
							"");
					totalParamArrLst.add(cntr);
					
					//임시 데이타 
					//cntr.put("RAIL_DEST_N1ST_ETA_DT", "20091120010101");  
				}*/				
			}
			//br.close();

/*			((EsdSce0085EventResponse)eventResponse).setHDR(HDR);
			((EsdSce0085EventResponse)eventResponse).setCNTR(cntr);
			((EsdSce0085EventResponse)eventResponse).setLOC(LOC);*/

			} catch (Exception e){
				log.error(e.getMessage());
				try {if (br!=null)br.close();
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
				throw new EventException(e.getMessage());
		}
		//createEDIBLPickUpTmpData(totalParamArrLst);
		return totalParamArrLst;
	}

	/**OK
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEdiBLPickUpCntrNoVO searchEdiBLPickUpCntrNoVO
	 * @return List<SearchEdiBLPickUpCntrNoVO>
	 * @exception EventException
	 */
	public List<SearchEdiBLPickUpCntrNoVO> searchEdiBLPickUpCntrNoVO(SearchEdiBLPickUpCntrNoVO searchEdiBLPickUpCntrNoVO) throws EventException {
		List<SearchEdiBLPickUpCntrNoVO> list = null;
		try {
			list = dbDao.searchEdiBLPickUpCntrNoVO(searchEdiBLPickUpCntrNoVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}	
		return list;
	}		

	/**OK
	 * INSERT INTO EDIBLPickUpMSG 
	 * @param Map<String, String> param
	 * @exception EventException
	 */	
	public void createEDIBLPickUpTmpData(Map<String, String> param) throws EventException {
		try {
			dbDao.createEDIBLPickUpTmpData(param);	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}	

	}		
			
	/**OK
	 * create EDIBLPickUpMsg If
	 * 
	 * @param Map<String, String> param
	 * @exception EventException
	 */
	public void createEDIBLPickUpMsgIf(Map<String, String> param) throws EventException {
		try {
			dbDao.createEDIBLPickUpMsgIf(param);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	 
}
