/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManageBCAbst.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-01-04
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.util;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
//import com.hanjin.framework.core.layer.event.EventResponse;
//import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * ENIS-ESD Business Logic Basic Command implementation<br>
 * - ENIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see TESeBillingManageBC 참조
 * @since J2EE 1.4
 */
public class TESeBillingManageFFParseSTRImpl implements TESeBillingManageFFParse {

	protected static Logger log = Logger.getLogger(TESeBillingManageFFParseSTRImpl.class.getName());

	/**
	 * TESeBillingManageBizUtil 구현 
	 * 
	 */
	public TESeBillingManageFFParseSTRImpl(){
	}
	
	/**
	 * F/F을 parse method로 해당 tag만 대상으로 DATA 분리해 내기
	 * 
	 * @param str_ff
	 * @param tag_nm
	 * @return Object
	 * @throws EventException
	 */
	public Object getTagUnitData(String str_ff, String tag_nm) throws EventException {	
		log.debug("\n BBBB -  TESeBillingManageFFParseUtilSTRImpl-getTagUnitData~~~~~ \n");
		
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
				log.debug("\n TESeBillingManageFFParseUtilSTRImpl getTagUnitData after getTagUnitData() -> hms.length: "+(hms!=null?hms.length:0)+" \n");

			} else {
				log.error("\n No tag name found exception!!! \n");
				throw new EventException("No tag name found exception!!!");
			}

			log.debug("\n eeeee -  TESeBillingManageFFParseUtilSTRImpl-getTagUnitData~~~~~ \n");

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