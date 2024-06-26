/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CreateUploadFileInfoVO.java
*@FileTitle : 3자구상 Settlement Request 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2006-10-27 Kim Jin-seung 1.0 최초 생성
* 2009-12-02 Sun, CHOI     1.1 ALPS Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.fileupload.vo;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - 모든 업무에서 공통으로 사용하는 PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author Sun, CHOI
 * @since J2EE 1.4
 */
public final class CreateUploadFileInfoVO implements java.io.Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private String       ibflag       = "";
	private String       page_rows    = "";
	private String       file_no      = "";
	private String       file_no_seq  = "";
	private String       file_lgc_nm  = "";
	private String       file_phys_nm = "";
	private String       file_path_nm = "";
	private String       file_sz_capa = "";
	private String       cre_usr_id   = "";
	private String       cre_dt       = "";
	private String       upd_usr_id   = "";
	private String       upd_dt       = "";

	public CreateUploadFileInfoVO(){}

	public CreateUploadFileInfoVO(
			String       ibflag      ,
			String       page_rows   ,
			String       file_no     ,
			String       file_no_seq ,
			String       file_lgc_nm ,
			String       file_phys_nm,
			String       file_path_nm,
			String       file_sz_capa,
			String       cre_usr_id  ,
			String       cre_dt      ,
			String       upd_usr_id  ,
			String       upd_dt      ){
		this.ibflag       = ibflag      ;
		this.page_rows    = page_rows   ;
		this.file_no      = file_no     ;
		this.file_no_seq  = file_no_seq ;
		this.file_lgc_nm  = file_lgc_nm ;
		this.file_phys_nm = file_phys_nm;
		this.file_path_nm = file_path_nm;
		this.file_sz_capa = file_sz_capa;
		this.cre_usr_id   = cre_usr_id  ;
		this.cre_dt       = cre_dt      ;
		this.upd_usr_id   = upd_usr_id  ;
		this.upd_dt       = upd_dt      ;
	}

	// getter method is proceeding ..
	public String       getIbflag      (){	return ibflag      	;	}
	public String       getPage_rows   (){	return page_rows   	;	}
	public String       getFile_no     (){	return file_no     	;	}
	public String       getFile_no_seq (){	return file_no_seq 	;	}
	public String       getFile_lgc_nm (){	return file_lgc_nm  ;	}
	public String       getFile_phys_nm (){	return file_phys_nm ;	}
	public String       getFile_path_nm(){	return file_path_nm	;	}
	public String       getFile_sz_capa(){	return file_sz_capa	;	}
	public String       getCre_usr_id  (){	return cre_usr_id  	;	}
	public String       getCre_dt      (){	return cre_dt      	;	}
	public String       getUpd_usr_id  (){	return upd_usr_id  	;	}
	public String       getUpd_dt      (){	return upd_dt      	;	}

	// setter method is proceeding ..
	public void setIbflag      ( String       ibflag       ){	this.ibflag       = ibflag      	;	}
	public void setPage_rows   ( String       page_rows    ){	this.page_rows    = page_rows   	;	}
	public void setFile_no     ( String       file_no      ){	this.file_no      = file_no     	;	}
	public void setFile_no_seq ( String       file_no_seq  ){	this.file_no_seq  = file_no_seq 	;	}
	public void setFile_lgc_nm ( String       file_lgc_nm  ){	this.file_lgc_nm  = file_lgc_nm     ;	}
	public void setFile_phys_nm( String       file_phys_nm ){	this.file_phys_nm = file_phys_nm    ;	}
	public void setFile_path_nm( String       file_path_nm ){	this.file_path_nm = file_path_nm	;	}
	public void setFile_sz_capa( String       file_sz_capa ){	this.file_sz_capa = file_sz_capa	;	}
	public void setCre_usr_id  ( String       cre_usr_id   ){	this.cre_usr_id   = cre_usr_id  	;	}
	public void setCre_dt      ( String       cre_dt       ){	this.cre_dt       = cre_dt      	;	}
	public void setUpd_usr_id  ( String       upd_usr_id   ){	this.upd_usr_id   = upd_usr_id  	;	}
	public void setUpd_dt      ( String       upd_dt       ){	this.upd_dt       = upd_dt      	;	}

	public static CreateUploadFileInfoVO fromRequest(HttpServletRequest request) {
		CreateUploadFileInfoVO model = new CreateUploadFileInfoVO();
		try {
			model.setIbflag      	(JSPUtil.getParameter(request, "ibflag      		".trim(), ""));
			model.setPage_rows   	(JSPUtil.getParameter(request, "page_rows   		".trim(), ""));
			model.setFile_no     	(JSPUtil.getParameter(request, "file_no     		".trim(), ""));
			model.setFile_no_seq 	(JSPUtil.getParameter(request, "file_no_seq 		".trim(), ""));
			model.setFile_lgc_nm    (JSPUtil.getParameter(request, "file_lgc_nm     	".trim(), ""));
			model.setFile_phys_nm   (JSPUtil.getParameter(request, "file_phys_nm     	".trim(), ""));
			model.setFile_path_nm	(JSPUtil.getParameter(request, "file_path_nm		".trim(), ""));
			model.setFile_sz_capa	(JSPUtil.getParameter(request, "file_sz_capa		".trim(), ""));
			model.setCre_usr_id  	(JSPUtil.getParameter(request, "cre_usr_id  		".trim(), ""));
			model.setCre_dt      	(JSPUtil.getParameter(request, "cre_dt      		".trim(), ""));
			model.setUpd_usr_id  	(JSPUtil.getParameter(request, "upd_usr_id  		".trim(), ""));
			model.setUpd_dt      	(JSPUtil.getParameter(request, "upd_dt      		".trim(), ""));
		} catch (Exception ex) {
			//throw new Exception(ex.getMessage());
		}
		return model;
	}
	public static Collection fromRequest(HttpServletRequest request, int length) {
		CreateUploadFileInfoVO model = null;
		Collection models = new ArrayList();
		try {
			String[] ibflag       =  (JSPUtil.getParameter(request, "ibflag      		".trim(), length));
			String[] page_rows    =  (JSPUtil.getParameter(request, "page_rows   		".trim(), length));
			String[] file_no      =  (JSPUtil.getParameter(request, "file_no     		".trim(), length));
			String[] file_no_seq  =  (JSPUtil.getParameter(request, "file_no_seq 		".trim(), length));
			String[] file_lgc_nm  =  (JSPUtil.getParameter(request, "file_lgc_nm     	".trim(), length));
			String[] file_phys_nm =  (JSPUtil.getParameter(request, "file_phys_nm     	".trim(), length));
			String[] file_path_nm =  (JSPUtil.getParameter(request, "file_path_nm		".trim(), length));
			String[] file_sz_capa =  (JSPUtil.getParameter(request, "file_sz_capa		".trim(), length));
			String[] cre_usr_id   =  (JSPUtil.getParameter(request, "cre_usr_id  		".trim(), length));
			String[] cre_dt       =  (JSPUtil.getParameter(request, "cre_dt      		".trim(), length));
			String[] upd_usr_id   =  (JSPUtil.getParameter(request, "upd_usr_id  		".trim(), length));
			String[] upd_dt       =  (JSPUtil.getParameter(request, "upd_dt      		".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new CreateUploadFileInfoVO();
				model.setIbflag      		  (ibflag      	[i]);
				model.setPage_rows   		  (page_rows   	[i]);
				model.setFile_no     		  (file_no     	[i]);
				model.setFile_no_seq 		  (file_no_seq 	[i]);
				model.setFile_lgc_nm     	  (file_lgc_nm  [i]);
				model.setFile_phys_nm     	  (file_phys_nm [i]);
				model.setFile_path_nm		  (file_path_nm	[i]);
				model.setFile_sz_capa		  (file_sz_capa	[i]);
				model.setCre_usr_id  		  (cre_usr_id  	[i]);
				model.setCre_dt      		  (cre_dt      	[i]);
				model.setUpd_usr_id  		  (upd_usr_id  	[i]);
				model.setUpd_dt      		  (upd_dt      	[i]);
				models.add(model);
			}
		} catch (Exception ex) {
		}
		return models;
	}
	public static Collection fromRequestGrid(HttpServletRequest request, String prefix) {
		CreateUploadFileInfoVO model = null;
		Collection models = new ArrayList();
		int length = request.getParameterValues(prefix+"ibflag")==null?0:request.getParameterValues(prefix+"ibflag").length;
		try {
			String[] ibflag       =  (JSPUtil.getParameter(request, prefix + "ibflag      		".trim(), length));
			String[] page_rows    =  (JSPUtil.getParameter(request, prefix + "page_rows   		".trim(), length));
			String[] file_no      =  (JSPUtil.getParameter(request, prefix + "file_no     		".trim(), length));
			String[] file_no_seq  =  (JSPUtil.getParameter(request, prefix + "file_no_seq 		".trim(), length));
			String[] file_lgc_nm  =  (JSPUtil.getParameter(request, prefix + "file_lgc_nm     	".trim(), length));
			String[] file_phys_nm =  (JSPUtil.getParameter(request, prefix + "file_phys_nm     	".trim(), length));
			String[] file_path_nm =  (JSPUtil.getParameter(request, prefix + "file_path_nm		".trim(), length));
			String[] file_sz_capa =  (JSPUtil.getParameter(request, prefix + "file_sz_capa		".trim(), length));
			String[] cre_usr_id   =  (JSPUtil.getParameter(request, prefix + "cre_usr_id  		".trim(), length));
			String[] cre_dt       =  (JSPUtil.getParameter(request, prefix + "cre_dt      		".trim(), length));
			String[] upd_usr_id   =  (JSPUtil.getParameter(request, prefix + "upd_usr_id  		".trim(), length));
			String[] upd_dt       =  (JSPUtil.getParameter(request, prefix + "upd_dt      		".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new CreateUploadFileInfoVO();
				model.setIbflag      		  ( ibflag      	[i]);
				model.setPage_rows   		  ( page_rows   	[i]);
				model.setFile_no     		  ( file_no     	[i]);
				model.setFile_no_seq 		  ( file_no_seq 	[i]);
				model.setFile_lgc_nm     	  ( file_lgc_nm     [i]);
				model.setFile_phys_nm     	  ( file_phys_nm    [i]);
				model.setFile_path_nm		  ( file_path_nm	[i]);
				model.setFile_sz_capa		  ( file_sz_capa	[i]);
				model.setCre_usr_id  		  ( cre_usr_id  	[i]);
				model.setCre_dt      		  ( cre_dt      	[i]);
				model.setUpd_usr_id  		  ( upd_usr_id  	[i]);
				model.setUpd_dt      		  ( upd_dt      	[i]);
				models.add(model);
			}
		} catch (Exception ex) {
		}
		return models;
	}

	// toString() method is overriding ..
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space="                              ";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr=null;
				try {
					arr = (String[]) field[i].get(this);
				}catch(Exception ex) {
					arr=new String[1];
					arr[0]=String.valueOf(field[i].get(this));
				}
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0,30).concat("= ") + arr[j] +"\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {}
		return ret.toString();
	}

}
