/*=========================================================
 *Copyright(c) 2008 CyberLogitec
 *@FileName : ScheduleUtil.java
 *@FileTitle : ScheduleUtil
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.30
 *@LastModifier : 김정훈
 *@LastVersion : 1.0
 * 2009.06.30 김정훈
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.common.ibsheet;

import com.hanjin.syscommon.common.ibsheet.dao.IbSheetDBDAO;

/**
 * 
 * @author 김정훈
 * @see IbSheetDBDAO
 * @since J2EE 1.4
 */
public class IbSheetUtil {
	/**
	 *  log 객체
	 */
	protected transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());

	/**
	 *  MenuDBDAO 객체
	 */
	private transient IbSheetDBDAO ibdao = null;

	/**
	 *  MenuUtil 객체
	 */
	private static IbSheetUtil instance = new IbSheetUtil();

	/**
	 * 기능 : MenuUtil getInstance()<p>
	 * 2. 처리개요 :  <p>
	 *    - 객체생성시에 instance를 만들고 공유한다. <p>
	 * 3. 주의사항 : <p>
	 * @return 
	 *
	 **/
	public static IbSheetUtil getInstance() {
		return instance;
	}

	/**
	 * 기능 : CodeUtil 생성자<p>
	 *
	 **/
	private IbSheetUtil() {
		ibdao = new IbSheetDBDAO();
	}

	/** 
	 * 기능 : IB시트 세팅 정보 저장
	 *
	 * @param usr_id
	 * @param scrn_id
	 * @param sh_id
	 * @param hdr_desc
	 * @param hdr_len_ctnt
	 * @throws Exception
	 **/
	public void saveIbSetting(String usr_id, String scrn_id, String sh_id, String hdr_desc ,String  hdr_len_ctnt) throws Exception {
		boolean bExist = false;

		try {
			bExist = ibdao.chkExist(usr_id, scrn_id, sh_id);
			
			if(bExist) {
				ibdao.updIbSetting(usr_id, scrn_id, sh_id, hdr_desc, hdr_len_ctnt);
			} else {
				ibdao.saveIbSetting(usr_id, scrn_id, sh_id, hdr_desc, hdr_len_ctnt);
			}
			
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	/**
	 * 기능 : IB시트 세팅 정보 삭제
	 *
	 * @param usr_id
	 * @param scrn_id
	 * @param sh_id
	 * @throws Exception
	 **/
	public void delIbSetting(String usr_id, String scrn_id, String sh_id) throws Exception {
		try {
			ibdao.delIbSetting(usr_id, scrn_id, sh_id);
			
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	/**
	 * 기능 : IB시트 세팅 정보 조회
	 *
	 * @param usr_id
	 * @param scrn_id
	 * @param sh_id
	 * @return String
	 * @throws Exception
	 **/
	public String searchIbSetting(String usr_id, String scrn_id, String sh_id) throws Exception {
		String sRtn = "";
		try {
			sRtn = ibdao.searchIbSetting(usr_id, scrn_id, sh_id);
			
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
		return sRtn;
		
		
	}
}
