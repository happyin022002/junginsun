/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EdiHoldStatusReceiveBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-25
*@LastModifier : 
*@LastVersion : 1.0
* 2013-06-25
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.integration.EdiHoldStatusReceiveDBDAO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
/**
 * ALPS-SCEM EDI Hold Status Message
 * - ALPS-SCEM EDI Hold Status Message 에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author Sang-Jun Kwon
 * @see 
 * @since J2EE 1.4
 */
public class EdiHoldStatusReceiveBCImpl extends BasicCommandSupport implements EdiHoldStatusReceiveBC {
	
	// Database Access Object
	private transient EdiHoldStatusReceiveDBDAO dbDao=null;
	/**
	 * EdiHoldStatusReceiveBCImpl 생성자
	 */	
    public EdiHoldStatusReceiveBCImpl(){
        dbDao = new EdiHoldStatusReceiveDBDAO();
    }
    
	/**
	 * Hold Status Header MSG를 FF에서 분리 
	 * @param String str
	 * @return HashMap<String, String>
	 * @exception EventException
	 */
	public HashMap<String, String> getHoldStatusHeaderdData(String str) throws EventException {
		log.info("\n==========getHoldStatusHeaderdData  START=================================\n" );

		HashMap<String,String> hdr = new HashMap<String,String>();
		String[] ediStr = str.split("\n");
		int hdrEnd = 10;
		
		try {
			
			for( int i = 0; i<hdrEnd; i++){				
				String[] itemStr = ediStr[i].split(":");

				if( "SENDER_ID".equals(itemStr[0])){
					if( itemStr[1].length() > 0){
						hdr.put("SENDER_ID", itemStr[1]);
					}					
				}else if( "SEND_DATE".equals(itemStr[0])){
					if( itemStr[1].length() > 0){
						hdr.put("SEND_DATE", itemStr[1]);
					}					
				}else if("SEND_TIME".equals(itemStr[0])){
					if( itemStr[1].length() > 0){
						hdr.put("SEND_TIME", itemStr[1]);
					}
				}else if("REF_NO".equals(itemStr[0])){
					if( itemStr[1].length() > 0){
						hdr.put("REF_NO", itemStr[1]);
					}
				}
			}

		} catch (Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		return hdr;
	}
	
	/**
	 * Hold Status Release MSG를 FF에서 분리 
	 * @param String str
	 * @return HashMap<String, String>
	 * @exception EventException
	 */
	public HashMap<String, String>[] getHoldStatusReleaseData(String str) throws EventException {
		log.info("\n==========getHoldStatusReleaseData  START=================================\n" );

		HashMap<String,String>[] release = null;
		String tag_nm = "RELEASE";
		
		try {
			
			release = getTagUnitData(str, tag_nm);			

		} catch (Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}			
			
		return release;			
	}
	
	/**
	 * Hold Status Data를 Insert/Update 처리한다.
	 * @param HashMap<String, String> hdr
	 * @param HashMap<String, String> rel
	 * @exception EventException
	 */
	public void updateHoldStatus(HashMap<String, String> hdr, HashMap<String, String> rel) throws EventException {
		log.info("\n==========updateHoldStatus  START=================================\n" );
		log.info("hdr = "+hdr );
		log.info("rel = "+rel );
		
		// Header Data START
		String sender_id = hdr.get("SENDER_ID");
		String send_date = hdr.get("SEND_DATE");
		String send_time = hdr.get("SEND_TIME");
		String ref_no = hdr.get("REF_NO");
		// Header Data END
		log.info("sender_id = "+sender_id);
		log.info("send_date = "+send_date);
		log.info("send_time = "+send_time);
		log.info("ref_no = "+ref_no);
		// Release Data START
		String bkg_no = rel.get("BL_NO");
		if(bkg_no.substring(0, 4).equals("SMLM")){
			bkg_no = bkg_no.substring(4, bkg_no.length());	
		}
		log.info("bkg_no.substring(0, 4) = "+bkg_no.substring(0, 4));
		log.info("bkg_no.substring(4, bkg_no.length()) = "+bkg_no.substring(4, bkg_no.length()));
		String cntr_pref = rel.get("CNTR_PREF");
		String c_cntr_no = rel.get("CNTR_NO");
		String cntr_chk = rel.get("CNTR_CHK");		
		String cntr_no = cntr_pref+c_cntr_no+cntr_chk;
		String ssco_scac = rel.get("SSCO_SCAC");		
		String hold_sts_customs = rel.get("HOLD_STS_CUSTOMS");
		String hold_sts_customs_date = rel.get("HOLD_STS_CUSTOMS_DATE");
		String hold_sts_customs_time = rel.get("HOLD_STS_CUSTOMS_TIME");
		String hold_sts_usda = rel.get("HOLD_STS_USDA");
		String hold_sts_usda_date = rel.get("HOLD_STS_USDA_DATE");
		String hold_sts_usda_time = rel.get("HOLD_STS_USDA_TIME");
		String hold_sts_carrier = rel.get("HOLD_STS_CARRIER");
		String hold_sts_carrier_date = rel.get("HOLD_STS_CARRIER_DATE");
		String hold_sts_carrier_time = rel.get("HOLD_STS_CARRIER_TIME");
		String hold_sts_terminal = rel.get("HOLD_STS_TERMINAL");
		String hold_sts_terminal_date = rel.get("HOLD_STS_TERMINAL_DATE");
		String hold_sts_terminal_time = rel.get("HOLD_STS_TERMINAL_TIME");
		String last_release_date = rel.get("LAST_RELEASE_DATE");
		String last_release_time = rel.get("LAST_RELEASE_TIME");
		// Release Data END
		
		log.info("bkg_no = "+bkg_no);
		log.info("cntr_pref = "+cntr_pref);
		log.info("c_cntr_no = "+c_cntr_no);
		log.info("cntr_chk = "+cntr_chk);		
		log.info("cntr_no = "+cntr_no);
		log.info("ssco_scac = "+ssco_scac);		
		log.info("hold_sts_customs = "+hold_sts_customs);
		log.info("hold_sts_customs_date = "+hold_sts_customs_date);
		log.info("hold_sts_customs_time = "+hold_sts_customs_time);
		log.info("hold_sts_usda = "+hold_sts_usda);
		log.info("hold_sts_usda_date = "+hold_sts_usda_date);
		log.info("hold_sts_usda_time = "+hold_sts_usda_time);
		log.info("hold_sts_carrier = "+hold_sts_carrier);
		log.info("hold_sts_carrier_date = "+hold_sts_carrier_date);
		log.info("hold_sts_carrier_time = "+hold_sts_carrier_time);
		log.info("hold_sts_terminal = "+hold_sts_terminal);
		log.info("hold_sts_terminal_date = "+hold_sts_terminal_date);
		log.info("hold_sts_terminal_time = "+hold_sts_terminal_time);
		log.info("last_release_date = "+last_release_date);
		log.info("last_release_time = "+last_release_time);
		
		int rCnt = 0;
		
		try{
			HashMap<String, String> param = new HashMap<String, String>();
			
			param.put("sender_id",sender_id);
			param.put("send_date",send_date);
			param.put("send_time",send_time);
			param.put("ref_no",ref_no);			
			param.put("bkg_no",bkg_no); 
			param.put("cntr_no",cntr_no);
			param.put("ssco_scac",ssco_scac);
			param.put("hold_sts_customs",hold_sts_customs);
			param.put("hold_sts_customs_date",hold_sts_customs_date);
			param.put("hold_sts_customs_time",hold_sts_customs_time);
			param.put("hold_sts_usda",hold_sts_usda);
			param.put("hold_sts_usda_date",hold_sts_usda_date);
			param.put("hold_sts_usda_time",hold_sts_usda_time);			
			param.put("hold_sts_carrier",hold_sts_carrier);
			param.put("hold_sts_carrier_date",hold_sts_carrier_date);
			param.put("hold_sts_carrier_time",hold_sts_carrier_time);			
			param.put("hold_sts_terminal",hold_sts_terminal);
			param.put("hold_sts_terminal_date",hold_sts_terminal_date);
			param.put("hold_sts_terminal_time",hold_sts_terminal_time);			
			param.put("last_release_date",last_release_date);
			param.put("last_release_time",last_release_time);
			
			//1. 기존에 수신된 내역이 있는지 확인한다.
			rCnt = dbDao.searchHoldStatusData(bkg_no, cntr_no);
			log.info("searchHoldStatusData rCnt = "+rCnt );
			//2. SCE_RAIL_HLD_STS 테이블에 CU 처리.
			if(rCnt > 0){
				log.info("updateHoldStatusData START" );
				dbDao.updateHoldStatusData(param);
			}else{
				log.info("createHoldStatusData START" );
				dbDao.createHoldStatusData(param);
			}
			
			//3. SCE_RAIL_HLD_STS_HIS에 수신 History를 저장한다.
			log.info("createHoldStatusHistoryData START" );
			dbDao.createHoldStatusHistoryData(param);

		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
	}



	/**
	 * F/F을 parse method로 해당 tag만 대상으로 DATA 분리해 내기
	 * 
	 * @param str_ff
	 * @param tag_nm
	 * @return HashMap<String,String>[]
	 * @throws EventException
	 */
	private HashMap<String,String>[] getTagUnitData(String str_ff, String tag_nm) throws EventException {	
		
		log.debug("\n @@ tag_nm:"+JSPUtil.getNull(tag_nm)+" @@ \n");
		
		HashMap<String,String>[] hms = null;
		java.io.BufferedReader br = null;
		java.io.StringReader sr = null;
		
		try {
			int cnt_tag = 0;

			if (tag_nm!=null && !tag_nm.trim().equals("")){
				
				for (int j=str_ff.indexOf("{"+tag_nm,0); 
				 		str_ff!=null && !str_ff.trim().equals("") && str_ff.indexOf("{"+tag_nm)!=-1 && str_ff.indexOf("{"+tag_nm,j)!=-1; 
				 			j=(str_ff.indexOf("{"+tag_nm,j)!=-1)?str_ff.indexOf("{"+tag_nm,j)+tag_nm.length():j++) 
				{
					cnt_tag++;
				}
				log.debug("\n cnt_dtl:"+(cnt_tag));
				
				if (cnt_tag>0){
					log.debug("\n  1  \n");
					hms = new HashMap[cnt_tag];
	
					/**
					 * <중> 이미 현 단계 전에 '{~' 와 '}~' 의 유효성 검사가 완료되었다는 전제하에 진행한다.
					 * tag_nm 단위로 쪼개어 담기
					 */			
					String buffer = null;
					String curr_blk = null;
					sr = new java.io.StringReader(str_ff);
					br = new java.io.BufferedReader(sr);
					int idx_hm = 0;
					while ((buffer=br.readLine())!=null && hms!=null && hms.length>0){
						if (buffer!=null && !buffer.trim().equals("")){
							if (buffer.trim().startsWith("{"+tag_nm)){
								curr_blk = buffer.trim();
								if (tag_nm!=null && buffer.trim().equals("{"+tag_nm.trim())) {
									hms[idx_hm] = new HashMap<String,String>();
								}
							} else if (buffer.trim().startsWith("}"+tag_nm)){
								if (buffer!=null && buffer.trim().equals("}"+tag_nm.trim())) {
									if (idx_hm<=cnt_tag){
										++idx_hm;
										curr_blk = null;
									}
								}
							} else {
								if (curr_blk!=null && curr_blk.equals("{"+tag_nm) && buffer!=null && !buffer.trim().equals("{"+tag_nm)){
									if (buffer!=null && !buffer.trim().equals("") && buffer.trim().indexOf(":") > 0){
										if (hms[idx_hm]!=null){
											hms[idx_hm].put(buffer.trim().substring(0,buffer.trim().indexOf(":")),buffer.trim().substring(buffer.trim().indexOf(":")+1));	
										}
									}
								}
							}
						}
					}
				}
				
				//test
				log.debug("\n EdiHoldStatusReceiveBCImpl getTagUnitData after getTagUnitData() -> hms.length: "+(hms!=null?hms.length:0)+" \n");

			} else {
				log.error("\n No tag name found exception!!! \n");
				throw new EventException("No tag name found exception!!!");
			}

			log.debug("\n eeeee -  EdiHoldStatusReceiveBCImpl-getTagUnitData~~~~~ \n");

		} catch (java.io.IOException e){
			log.error(e.getMessage());
			try {
				if (sr!=null) {
					sr.close();
				}
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
			throw new EventException(e.getMessage());
		} catch (Exception e){
			log.error(e.getMessage());
			try {
				if (sr!=null) {
					sr.close();
				}
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
			throw new EventException(e.getMessage());
		} finally {
			try {
				if (sr!=null) {
					sr.close();
				}
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
		}
		return hms;
	}
}