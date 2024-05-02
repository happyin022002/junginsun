/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0058ViewAdapter.java
 *@FileTitle : EsmBkg0058ViewAdapter
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.03
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.09.03 이수빈
 * 1.0 Creation\
 * 
 * 2011.08.08 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * FileDownLoad을 위한 ViewAdapter.
 * 
 * @author Lee Subin
 * @see ESM_BKG_0058HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0508ViewAdapter extends ViewAdapter {

	/**
	 * SC에서 받은 파일이름으로 .TXT 파일 생성 후 로컬로 저장
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return String
	 */
	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
//		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
//		Object filename = eventResponse.getCustomData("filePath");
//		String contents =  (String)filename;
//		String savedName = contents.substring(5);
//		
//		BufferedOutputStream outs = null;
//		FileInputStream fr = null;
//		BufferedInputStream br = null;
//		
//		File file = null;
//		try {
//			file = new File(contents);
//			if (!(file.exists() && file.isFile())) {
//				log.info("No File");
//				return null;
//			}
//
//			fr = new FileInputStream(file);
//			br = new BufferedInputStream(fr);
//
//			byte[] b = new byte[(int) file.length()];
//			@SuppressWarnings("unused")
//			int len = 0;
//			 
//			response.reset();
//			response.setContentType("application/smnet");
//			String strClient = request.getHeader("user-agent");
//
//			if (strClient.indexOf("MSIE 5.5") != -1) {
//				response.setHeader("Content-Type", "doesn/matter; charset=euc-kr");
//				response.setHeader("Content-Disposition", "filename=" + savedName + "; charset=euc-kr");
//			} else {
//				response.setHeader("Content-Type", "application/octet-stream; charset=euc-kr");
//				response.setHeader("Content-Disposition", "attachment;filename=" + savedName + ";");
//			}
//			outs = new BufferedOutputStream(response.getOutputStream());
//
//			if ((len = br.read(b, 0, b.length)) != -1) {
//				response.setHeader("Content-Length", "" + b.length);
//				outs.write(b);
//			}
//			outs.flush();
//		} catch (IOException e) {
//			log.error(e);
//		} catch (Exception e) {
//			log.error(e);
//		} finally {
//			try {
//				outs.close();
//			} catch (IOException e) {
//				log.error(e);
//			}
//			try {
//				br.close();
//			} catch (IOException e) {
//				log.error(e);
//			}
//			try {
//				fr.close();
//			} catch (IOException e) {
//				log.error(e);
//			}
//			try {
//				if(file.exists() && file.isFile()){
//					file.delete();
//				}
//			} catch (Exception e) {
//				log.error(e);
//			}
//		}
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clt.framework.core.controller.ViewAdapter#makeDataTag(java.util
	 * .List, java.lang.String)
	 */
	@Override
	protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clt.framework.core.controller.ViewAdapter#makeDataTag(com.clt
	 * .framework.component.rowset.DBRowSet, java.lang.String)
	 */
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		return null;
	}
}
