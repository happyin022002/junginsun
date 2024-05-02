/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TRS_AGMT_DIST.java
*@FileTitle : Distance Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-31 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.event;

import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;


/**
 * @author soli
 * @see 
 * @since JESS 1.0
 */
public final class TRS_AGMT_DIST_VO implements java.io.Serializable {

	private String             ibflag             = "";
	private String             page_rows          = "";
	private String             fm_nod_cd          = "";
	private String             fm_nod_cd_sub          = "";
	private String             to_nod_cd          = "";
	private String             to_nod_cd_sub          = "";
	private String             dist_meas_ut_cd    = "";
	private String             bzc_dist           = "";
	private String             conv_meas_ut_cd    = "";
	private String             conv_dist          = "";
	private String             fm_nod_zip_cd_ctnt = "";
	private String             to_nod_zip_cd_ctnt = "";
	private String             cre_ofc_cd         = "";
	private String             cre_usr_id         = "";
	private String             cre_dt             = "";
	private String             upd_usr_id         = "";
	private String             upd_dt             = "";

	/**
	 *   생성자
	 */
	public TRS_AGMT_DIST_VO(){}

	/**
	 * @param ibflag
	 * @param page_rows
	 * @param fm_nod_cd
	 * @param fm_nod_cd_sub
	 * @param to_nod_cd
	 * @param to_nod_cd_sub
	 * @param dist_meas_ut_cd
	 * @param bzc_dist
	 * @param conv_meas_ut_cd
	 * @param conv_dist
	 * @param fm_nod_zip_cd_ctnt
	 * @param to_nod_zip_cd_ctnt
	 * @param cre_ofc_cd
	 * @param cre_usr_id
	 * @param cre_dt
	 * @param upd_usr_id
	 * @param upd_dt
	 */
	public TRS_AGMT_DIST_VO(
			String             ibflag            ,
			String             page_rows         ,
			String             fm_nod_cd         ,
			String             fm_nod_cd_sub         ,
			String             to_nod_cd         ,
			String             to_nod_cd_sub         ,
			String             dist_meas_ut_cd   ,
			String             bzc_dist          ,
			String             conv_meas_ut_cd   ,
			String             conv_dist         ,
			String             fm_nod_zip_cd_ctnt,
			String             to_nod_zip_cd_ctnt,
			String             cre_ofc_cd        ,
			String             cre_usr_id        ,
			String             cre_dt            ,
			String             upd_usr_id        ,
			String             upd_dt            ){
		this.ibflag             = ibflag            ;
		this.page_rows          = page_rows         ;
		this.fm_nod_cd          = fm_nod_cd         ;
		this.fm_nod_cd_sub          = fm_nod_cd_sub         ;
		this.to_nod_cd          = to_nod_cd         ;
		this.to_nod_cd_sub          = to_nod_cd_sub         ;
		this.dist_meas_ut_cd    = dist_meas_ut_cd   ;
		this.bzc_dist           = bzc_dist          ;
		this.conv_meas_ut_cd    = conv_meas_ut_cd   ;
		this.conv_dist          = conv_dist         ;
		this.fm_nod_zip_cd_ctnt = fm_nod_zip_cd_ctnt;
		this.to_nod_zip_cd_ctnt = to_nod_zip_cd_ctnt;
		this.cre_ofc_cd         = cre_ofc_cd        ;
		this.cre_usr_id         = cre_usr_id        ;
		this.cre_dt             = cre_dt            ;
		this.upd_usr_id         = upd_usr_id        ;
		this.upd_dt             = upd_dt            ;
	}

	// getter method is proceeding ..
	public String             getIbflag            (){	return ibflag            	;	}
	public String             getPage_rows         (){	return page_rows         	;	}
	public String             getFm_nod_cd         (){	return fm_nod_cd         	;	}
	public String             getFm_nod_cd_sub         (){	return fm_nod_cd_sub         	;	}
	public String             getTo_nod_cd         (){	return to_nod_cd         	;	}
	public String             getTo_nod_cd_sub         (){	return to_nod_cd_sub         	;	}
	public String             getDist_meas_ut_cd   (){	return dist_meas_ut_cd   	;	}
	public String             getBzc_dist          (){	return bzc_dist          	;	}
	public String             getConv_meas_ut_cd   (){	return conv_meas_ut_cd   	;	}
	public String             getConv_dist         (){	return conv_dist         	;	}
	public String             getFm_nod_zip_cd_ctnt(){	return fm_nod_zip_cd_ctnt	;	}
	public String             getTo_nod_zip_cd_ctnt(){	return to_nod_zip_cd_ctnt	;	}
	public String             getCre_ofc_cd        (){	return cre_ofc_cd        	;	}
	public String             getCre_usr_id        (){	return cre_usr_id        	;	}
	public String             getCre_dt            (){	return cre_dt            	;	}
	public String             getUpd_usr_id        (){	return upd_usr_id        	;	}
	public String             getUpd_dt            (){	return upd_dt            	;	}

	// setter method is proceeding ..
	public void setIbflag            ( String             ibflag             ){	this.ibflag             = ibflag            	;	}
	public void setPage_rows         ( String             page_rows          ){	this.page_rows          = page_rows         	;	}
	public void setFm_nod_cd         ( String             fm_nod_cd          ){	this.fm_nod_cd          = fm_nod_cd         	;	}
	public void setFm_nod_cd_sub         ( String             fm_nod_cd_sub          ){	this.fm_nod_cd_sub         = fm_nod_cd_sub         	;	}
	public void setTo_nod_cd         ( String             to_nod_cd          ){	this.to_nod_cd          = to_nod_cd         	;	}
	public void setTo_nod_cd_sub         ( String             to_nod_cd_sub          ){	this.to_nod_cd_sub          = to_nod_cd_sub         	;	}
	public void setDist_meas_ut_cd   ( String             dist_meas_ut_cd    ){	this.dist_meas_ut_cd    = dist_meas_ut_cd   	;	}
	public void setBzc_dist          ( String             bzc_dist           ){	this.bzc_dist           = bzc_dist          	;	}
	public void setConv_meas_ut_cd   ( String             conv_meas_ut_cd    ){	this.conv_meas_ut_cd    = conv_meas_ut_cd   	;	}
	public void setConv_dist         ( String             conv_dist          ){	this.conv_dist          = conv_dist         	;	}
	public void setFm_nod_zip_cd_ctnt( String             fm_nod_zip_cd_ctnt ){	this.fm_nod_zip_cd_ctnt = fm_nod_zip_cd_ctnt	;	}
	public void setTo_nod_zip_cd_ctnt( String             to_nod_zip_cd_ctnt ){	this.to_nod_zip_cd_ctnt = to_nod_zip_cd_ctnt	;	}
	public void setCre_ofc_cd        ( String             cre_ofc_cd         ){	this.cre_ofc_cd         = cre_ofc_cd        	;	}
	public void setCre_usr_id        ( String             cre_usr_id         ){	this.cre_usr_id         = cre_usr_id        	;	}
	public void setCre_dt            ( String             cre_dt             ){	this.cre_dt             = cre_dt            	;	}
	public void setUpd_usr_id        ( String             upd_usr_id         ){	this.upd_usr_id         = upd_usr_id        	;	}
	public void setUpd_dt            ( String             upd_dt             ){	this.upd_dt             = upd_dt            	;	}

	public static TRS_AGMT_DIST_VO fromRequest(HttpServletRequest request) {
		TRS_AGMT_DIST_VO model = new TRS_AGMT_DIST_VO();

			model.setIbflag            	(JSPUtil.getParameter(request, "ibflag            		".trim(), ""));
			model.setPage_rows         	(JSPUtil.getParameter(request, "page_rows         		".trim(), ""));
			model.setFm_nod_cd         	(JSPUtil.getParameter(request, "fm_nod_cd         		".trim(), ""));
			model.setFm_nod_cd_sub         	(JSPUtil.getParameter(request, "fm_nod_cd_sub         		".trim(), ""));
			model.setTo_nod_cd         	(JSPUtil.getParameter(request, "to_nod_cd         		".trim(), ""));
			model.setTo_nod_cd_sub         	(JSPUtil.getParameter(request, "to_nod_cd_sub         		".trim(), ""));
			model.setDist_meas_ut_cd   	(JSPUtil.getParameter(request, "dist_meas_ut_cd   		".trim(), ""));
			model.setBzc_dist          	(JSPUtil.getParameter(request, "bzc_dist          		".trim(), ""));
			model.setConv_meas_ut_cd   	(JSPUtil.getParameter(request, "conv_meas_ut_cd   		".trim(), ""));
			model.setConv_dist         	(JSPUtil.getParameter(request, "conv_dist         		".trim(), ""));
			model.setFm_nod_zip_cd_ctnt	(JSPUtil.getParameter(request, "fm_nod_zip_cd_ctnt		".trim(), ""));
			model.setTo_nod_zip_cd_ctnt	(JSPUtil.getParameter(request, "to_nod_zip_cd_ctnt		".trim(), ""));
			model.setCre_ofc_cd        	(JSPUtil.getParameter(request, "cre_ofc_cd        		".trim(), ""));
			model.setCre_usr_id        	(JSPUtil.getParameter(request, "cre_usr_id        		".trim(), ""));
			model.setCre_dt            	(JSPUtil.getParameter(request, "cre_dt            		".trim(), ""));
			model.setUpd_usr_id        	(JSPUtil.getParameter(request, "upd_usr_id        		".trim(), ""));
			model.setUpd_dt            	(JSPUtil.getParameter(request, "upd_dt            		".trim(), ""));

		return model;
	}
	public static Collection fromRequest(HttpServletRequest request, int length) {
		TRS_AGMT_DIST_VO model = null;
		Collection models = new ArrayList();

			String[] ibflag             =  (JSPUtil.getParameter(request, "ibflag            		".trim(), length));
			String[] page_rows          =  (JSPUtil.getParameter(request, "page_rows         		".trim(), length));
			String[] fm_nod_cd          =  (JSPUtil.getParameter(request, "fm_nod_cd         		".trim(), length));
			String[] fm_nod_cd_sub          =  (JSPUtil.getParameter(request, "fm_nod_cd_sub         		".trim(), length));
			String[] to_nod_cd          =  (JSPUtil.getParameter(request, "to_nod_cd         		".trim(), length));
			String[] to_nod_cd_sub          =  (JSPUtil.getParameter(request, "to_nod_cd_sub         		".trim(), length));
			String[] dist_meas_ut_cd    =  (JSPUtil.getParameter(request, "dist_meas_ut_cd   		".trim(), length));
			String[] bzc_dist           =  (JSPUtil.getParameter(request, "bzc_dist          		".trim(), length));
			String[] conv_meas_ut_cd    =  (JSPUtil.getParameter(request, "conv_meas_ut_cd   		".trim(), length));
			String[] conv_dist          =  (JSPUtil.getParameter(request, "conv_dist         		".trim(), length));
			String[] fm_nod_zip_cd_ctnt =  (JSPUtil.getParameter(request, "fm_nod_zip_cd_ctnt		".trim(), length));
			String[] to_nod_zip_cd_ctnt =  (JSPUtil.getParameter(request, "to_nod_zip_cd_ctnt		".trim(), length));
			String[] cre_ofc_cd         =  (JSPUtil.getParameter(request, "cre_ofc_cd        		".trim(), length));
			String[] cre_usr_id         =  (JSPUtil.getParameter(request, "cre_usr_id        		".trim(), length));
			String[] cre_dt             =  (JSPUtil.getParameter(request, "cre_dt            		".trim(), length));
			String[] upd_usr_id         =  (JSPUtil.getParameter(request, "upd_usr_id        		".trim(), length));
			String[] upd_dt             =  (JSPUtil.getParameter(request, "upd_dt            		".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new TRS_AGMT_DIST_VO();
				model.setIbflag            		  (ibflag            	[i]);
				model.setPage_rows         		  (page_rows         	[i]);
				model.setFm_nod_cd         		  (fm_nod_cd         	[i]);
				model.setFm_nod_cd_sub         		  (fm_nod_cd_sub         	[i]);
				model.setTo_nod_cd         		  (to_nod_cd         	[i]);
				model.setTo_nod_cd_sub         		  (to_nod_cd_sub         	[i]);
				model.setDist_meas_ut_cd   		  (dist_meas_ut_cd   	[i]);
				model.setBzc_dist          		  (bzc_dist          	[i]);
				model.setConv_meas_ut_cd   		  (conv_meas_ut_cd   	[i]);
				model.setConv_dist         		  (conv_dist         	[i]);
				model.setFm_nod_zip_cd_ctnt		  (fm_nod_zip_cd_ctnt	[i]);
				model.setTo_nod_zip_cd_ctnt		  (to_nod_zip_cd_ctnt	[i]);
				model.setCre_ofc_cd        		  (cre_ofc_cd        	[i]);
				model.setCre_usr_id        		  (cre_usr_id        	[i]);
				model.setCre_dt            		  (cre_dt            	[i]);
				model.setUpd_usr_id        		  (upd_usr_id        	[i]);
				model.setUpd_dt            		  (upd_dt            	[i]);
				models.add(model);
			}

		return models;
	}
	public static Collection fromRequestGrid(HttpServletRequest request, String prefix) {
		TRS_AGMT_DIST_VO model = null;
		Collection models = new ArrayList();
		int length = request.getParameterValues("ibflag").length;

			String[] ibflag             =  (JSPUtil.getParameter(request, prefix + "ibflag            		".trim(), length));
			String[] page_rows          =  (JSPUtil.getParameter(request, prefix + "page_rows         		".trim(), length));
			String[] fm_nod_cd          =  (JSPUtil.getParameter(request, prefix + "fm_nod_cd         		".trim(), length));
			String[] fm_nod_cd_sub          =  (JSPUtil.getParameter(request, prefix + "fm_nod_cd_sub         		".trim(), length));
			String[] to_nod_cd          =  (JSPUtil.getParameter(request, prefix + "to_nod_cd         		".trim(), length));
			String[] to_nod_cd_sub          =  (JSPUtil.getParameter(request, prefix + "to_nod_cd_sub         		".trim(), length));
			String[] dist_meas_ut_cd    =  (JSPUtil.getParameter(request, prefix + "dist_meas_ut_cd   		".trim(), length));
			String[] bzc_dist           =  (JSPUtil.getParameter(request, prefix + "bzc_dist          		".trim(), length));
			String[] conv_meas_ut_cd    =  (JSPUtil.getParameter(request, prefix + "conv_meas_ut_cd   		".trim(), length));
			String[] conv_dist          =  (JSPUtil.getParameter(request, prefix + "conv_dist         		".trim(), length));
			String[] fm_nod_zip_cd_ctnt =  (JSPUtil.getParameter(request, prefix + "fm_nod_zip_cd_ctnt		".trim(), length));
			String[] to_nod_zip_cd_ctnt =  (JSPUtil.getParameter(request, prefix + "to_nod_zip_cd_ctnt		".trim(), length));
			String[] cre_ofc_cd         =  (JSPUtil.getParameter(request, prefix + "cre_ofc_cd        		".trim(), length));
			String[] cre_usr_id         =  (JSPUtil.getParameter(request, prefix + "cre_usr_id        		".trim(), length));
			String[] cre_dt             =  (JSPUtil.getParameter(request, prefix + "cre_dt            		".trim(), length));
			String[] upd_usr_id         =  (JSPUtil.getParameter(request, prefix + "upd_usr_id        		".trim(), length));
			String[] upd_dt             =  (JSPUtil.getParameter(request, prefix + "upd_dt            		".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new TRS_AGMT_DIST_VO();
				model.setIbflag            		  ( ibflag            	[i]);
				model.setPage_rows         		  ( page_rows         	[i]);
				model.setFm_nod_cd         		  ( fm_nod_cd         	[i]);
				model.setFm_nod_cd_sub         		  ( fm_nod_cd_sub         	[i]);
				model.setTo_nod_cd         		  ( to_nod_cd         	[i]);
				model.setTo_nod_cd_sub         		  ( to_nod_cd_sub         	[i]);
				model.setDist_meas_ut_cd   		  ( dist_meas_ut_cd   	[i]);
				model.setBzc_dist          		  ( bzc_dist          	[i]);
				model.setConv_meas_ut_cd   		  ( conv_meas_ut_cd   	[i]);
				model.setConv_dist         		  ( conv_dist         	[i]);
				model.setFm_nod_zip_cd_ctnt		  ( fm_nod_zip_cd_ctnt	[i]);
				model.setTo_nod_zip_cd_ctnt		  ( to_nod_zip_cd_ctnt	[i]);
				model.setCre_ofc_cd        		  ( cre_ofc_cd        	[i]);
				model.setCre_usr_id        		  ( cre_usr_id        	[i]);
				model.setCre_dt            		  ( cre_dt            	[i]);
				model.setUpd_usr_id        		  ( upd_usr_id        	[i]);
				model.setUpd_dt            		  ( upd_dt            	[i]);
				models.add(model);
			}

		return models;
	}

	// toString() method is overriding ..
//	public String toString() {
//		StringBuffer ret = new StringBuffer();
//		Field[] field = this.getClass().getDeclaredFields();
//		String space="                              ";
//		try {
//			for (int i = 0; i < field.length; i++) {
//				String[] arr=null;
//				try {
//					arr = (String[]) field[i].get(this);
//				}catch(Exception ex) {
//					arr=new String[1];
//					arr[0]=String.valueOf(field[i].get(this));
//				}
//				if (arr != null) {
//					for (int j = 0; j < arr.length; j++) {
//						ret.append(field[i].getName().concat(space).substring(0,30).concat("= ") + arr[j] +"\n");
//					}
//				} else {
//					ret.append(field[i].getName() + " =  null \n");
//				}
//			}
//		} catch (Exception ex) {
//			
//		}
//		return ret.toString();
//	}

}
