/*=========================================================
 *Copyright(c) 2008 CyberLogitec
 *@FileName : MessageUtil.java
 *@FileTitle : MessageUtil
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008.12.23
 *@LastModifier : 정인선
 *@LastVersion : 1.0
 * 2008.12.23 정인선
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.common.sms;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmVO;
import com.hanjin.framework.component.attachment.file.upload.FileUploadSaver;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.MultipartRequest;
import com.hanjin.framework.component.util.file.ModuleMetaData;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.TblSubmitQueueVO;
import com.hanjin.syscommon.common.sms.integration.SmsDAO;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * NIS2010-MessageUtil.
 * 
 * @author Jung_InSun
 * @see MessagesDBDAO
 * @since J2EE 1.4
 */
public class SmsUtil {
	
	/**
	  * 업무시스템에서 SMS  발송하기 위한 메소드..
	 * @param sndNm	보내는사람 이름
	 * @param sndrId	보내는사람 아이디
	 * @param rcvNm	받는사람 이름
	 * @param rcvrId	받는사람 아이디
	 * @param content	메시지 내용
	 * @return		메시지 ID
	 */
	static List<TblSubmitQueueVO> metadatas = new ArrayList<TblSubmitQueueVO>();

	/**
	 * 
	 * SmsUtil send기능
	 * @param tblSubmitQueueVO
	 * @return
	 * @throws Exception
	 */
	public static String send(TblSubmitQueueVO tblSubmitQueueVO) throws Exception{
		try {
			String dateTime = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			String cmpMsgId = dateTime;
			tblSubmitQueueVO.setCmpMsgId(cmpMsgId);
			tblSubmitQueueVO.setUsrId(SiteConfigFactory.getWhenNullThrowException("COM.SMS.ID"));	
			tblSubmitQueueVO.setSavedFg(SiteConfigFactory.getWhenNullThrowException("COM.SMS.SAVE"));	

			if(tblSubmitQueueVO.getUsedCd()==null)tblSubmitQueueVO.setUsedCd("00");
			if(tblSubmitQueueVO.getContentCnt()==null)tblSubmitQueueVO.setContentCnt("0");
			if(tblSubmitQueueVO.getReservedFg()==null)tblSubmitQueueVO.setReservedFg("I");
			if(tblSubmitQueueVO.getSmsGb()==null)tblSubmitQueueVO.setSmsGb("1");
			if(tblSubmitQueueVO.getAssignCd()==null)tblSubmitQueueVO.setAssignCd("00000");
	
			SmsDAO.insertSms(tblSubmitQueueVO);
		} catch (Exception e) {
			Logger.getLogger(e.getMessage());
			throw e;
		}
		return tblSubmitQueueVO.getCmpMsgId();
	}
	
}
