/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : AgreementNoticeUtil.java
* @FileTitle : Agreement Notice Util
* Open Issues :
* Change history :
* @LastModifyDate : 2016-04-26
* @LastModifier : yoo
* @LastVersion : 1.0
* * 1.0 최초 생성
* *----------------------------------------------------------
* History
* 2016.04.26 yoo 
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.bizcommon.agreementnotice.integration.AgreementNoticeDBDAO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * AgreementNoticeUtil <br>
 * Process AgreementNoticeUtil <br>
 * 
 * @author yoo
 * @see 
 * @since J2EE 1.4
 */
public class AgreementNoticeUtil {
	/**
     *  log 객체
     */
    protected transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());
    
	/**
	 * AgreementNoticeUtil 객체 생성<br>
	 */
	public AgreementNoticeUtil(){}

	/**
	 * 화면서 가져온 usr정보를 delim로 쪼개고 쪼갠 결과 배열값에서 빈칸에 해당하는 '#'는 제거한다.
	 * @param src
	 * @param delim
	 * @return String[]
	 */
    public static String[] getStringToArray(String src, String delim) {
        String[] retval = null;
        StringTokenizer st = new StringTokenizer(src, delim);
        int count = st.countTokens();
        retval = new String[count];
        for (int i=0; i<count; i++) {
        	retval[i] = JSPUtil.replace(st.nextToken(),"#","");
        }
        return retval;
    }
	
    /**
     * 쪼개기
     * @param str
     * @return List<String>
     */
	public static List<String> replaceStrToList(String str) {
		ArrayList<String>  array = new ArrayList<String>();
		StringTokenizer tokenTpszcd = new StringTokenizer(str,"|");
		while (tokenTpszcd.hasMoreTokens()) {
			array.add(tokenTpszcd.nextToken());
		}
		return array;
	}
	
	/**
	 * Authorization 설정 정보 조회 처리
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String searchUsrMaxKnt() throws Exception {
		AgreementNoticeDBDAO dbDao = new AgreementNoticeDBDAO();
		try {
			return dbDao.searchUsrMaxKnt();
		} catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}		
	}	
	
	/**
	 * NTC 내부 순서SEQ 변환 처리용
	 * @param seq
	 * @return String
	 */
	public static String conv_job_cd_seq(String seq){
		String retval = "";
		if (seq.equals("1")){
			retval = seq + "st";
		} else if (seq.equals("2")){
			retval = seq + "nd";
		} else if (seq.equals("3")){
			retval = seq + "rd";
		} else {
			retval = seq + "th";
		}		
		return retval;
	}	

}
