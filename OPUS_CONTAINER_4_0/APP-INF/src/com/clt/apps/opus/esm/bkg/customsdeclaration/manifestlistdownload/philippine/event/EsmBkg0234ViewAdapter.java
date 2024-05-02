/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0234ViewAdapter.java
 *@FileTitle : PhilippineManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.20 임재택
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.event;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
 * @author lim jae taek
 * @see ESM_BKG_0234HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0234ViewAdapter extends ViewAdapter {

	/**
	 * SC에서 받은 파일이름을 가지고 .DBF파일생성 및 로컬로 다운작업
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return String
	 */
	@SuppressWarnings("unused")
	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
		//GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		Object filename = eventResponse.getCustomData("filekey");
		//String savedName = "ABCDE.dbf";
		String contents =  (String)filename;
		String savedName = contents.substring(5);
		//String contents =  "c:/ABCDE1.dbf";
		BufferedOutputStream outs = null;
		FileInputStream fr = null;
		BufferedInputStream br = null;
		try {
			File file = new File(contents);
			if (!(file.exists() && file.isFile())) {
				log.info("No File");
				return null;
			}

			fr = new FileInputStream(file);
			br = new BufferedInputStream(fr);

			byte[] b = new byte[(int) file.length()];
			int len = 0;
			 
			response.reset();
			response.setContentType("application/smnet");
			String strClient = request.getHeader("user-agent");

			if (strClient.indexOf("MSIE 5.5") != -1) {
				response.setHeader("Content-Type",
						"doesn/matter; charset=euc-kr");
				response.setHeader("Content-Disposition", "filename="
						+ savedName + "; charset=euc-kr");
			} else {
				response.setHeader("Content-Type",
						"application/octet-stream; charset=euc-kr");
				response.setHeader("Content-Disposition",
						"attachment;filename=" + savedName + ";");
			}
			outs = new BufferedOutputStream(response.getOutputStream());

			if ((len = br.read(b, 0, b.length)) != -1) {
				response.setHeader("Content-Length", "" + b.length);
				outs.write(b);
			}
			outs.flush();
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				outs.close();
			} catch (FileNotFoundException e) {
				log.error(e);
			} catch (IOException e) {
				log.error(e);
			}
			try {
				br.close();
			} catch (FileNotFoundException e) {
				log.error(e);
			} catch (IOException e) {
				log.error(e);
			}
			try {
				fr.close();
			} catch (FileNotFoundException e) {
				log.error(e);
			} catch (IOException e) {
				log.error(e);
			}
		}
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
