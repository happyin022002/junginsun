/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MDM_CUST_REP.java
*@FileTitle : 사용자 관리6
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-12
*@LastModifier : you_mok_lee
*@LastVersion : 1.0
* 2015-05-12 you_mok_lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - 모든 업무에서 공통으로 사용하는 PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author Kildong_hong6
 * @since J2EE 1.4
 */
public final class MdmCustRep implements java.io.Serializable {

	private String                ibflag                = "";
	private String                page_rows             = "";
	private String                cust_cnt_cd           = "";
	private String                cust_seq              = "";
	private String                ofc_cd       			= "";
	private String                io_bnd_cd          	= "";
	private String                auto_inv_flg    		= "";
	private String                hjs_cust_svc_pic_tp_cd= "";
	private String                hjs_ref_no            = "";
	private String                cust_ref_no_flg       = "";
	private String                locl_chg_flg         	= "";
	private String                hjs_ref_eml           = "";
	private String                delt_flg              = "";
	private String                eai_evnt_dt           = "";
	private String                eai_if_id           	= "";
	private String                cre_usr_id            = "";
	private String                cre_dt                = "";
	private String                upd_usr_id            = "";
	private String                upd_dt                = "";
	private String                auto_inv_eml          = "";


	public MdmCustRep(){}

	public MdmCustRep(
			String                ibflag                ,
			String                page_rows             ,
			String                cust_cnt_cd           ,
			String                cust_seq              ,
			String                ofc_cd       			,
			String                io_bnd_cd          	,
			String                auto_inv_flg    		,
			String                hjs_cust_svc_pic_tp_cd,
			String                hjs_ref_no            ,
			String                cust_ref_no_flg       ,
			String                locl_chg_flg         	,
			String                hjs_ref_eml           ,
			String                delt_flg              ,
			String                eai_evnt_dt           ,
			String                eai_if_id           	,
			String                cre_usr_id            ,
			String                cre_dt                ,
			String                upd_usr_id            ,
			String                upd_dt                ,
			String                auto_inv_eml        ){
		this.ibflag                	= ibflag               	;
		this.page_rows             	= page_rows            	;
		this.cust_cnt_cd           	= cust_cnt_cd          	;
		this.cust_seq              	= cust_seq              ;
		this.ofc_cd       			= ofc_cd                ;
		this.io_bnd_cd          	= io_bnd_cd             ;
		this.auto_inv_flg    		= auto_inv_flg          ;
		this.hjs_cust_svc_pic_tp_cd	= hjs_cust_svc_pic_tp_cd;
		this.hjs_ref_no            	= hjs_ref_no            ;
		this.cust_ref_no_flg       	= cust_ref_no_flg       ;
		this.locl_chg_flg         	= locl_chg_flg          ;
		this.hjs_ref_eml           	= hjs_ref_eml           ;
		this.delt_flg              	= delt_flg              ;
		this.eai_evnt_dt           	= eai_evnt_dt           ;
		this.eai_if_id           	= eai_if_id             ;
		this.cre_usr_id            	= cre_usr_id            ;
		this.cre_dt                	= cre_dt               	;
		this.upd_usr_id            	= upd_usr_id            ;
		this.upd_dt                	= upd_dt               	;
		this.auto_inv_eml          	= auto_inv_eml          ;
	}

	// getter method is proceeding ..
	
	public String                getIbflag                	(){	return ibflag               	;	}
	public String                getPage_rows             	(){	return page_rows               	;	}
	public String                getCust_cnt_cd           	(){	return cust_cnt_cd              ;	}
	public String                getCust_seq              	(){	return cust_seq               	;	}
	public String                getOfc_cd       			(){	return ofc_cd               	;	}
	public String                getIo_bnd_cd          		(){	return io_bnd_cd               	;	}
	public String                getAuto_inv_flg    		(){	return auto_inv_flg             ;	}
	public String                getHjs_cust_svc_pic_tp_cd	(){	return hjs_cust_svc_pic_tp_cd   ;	}
	public String                getHjs_ref_no            	(){	return hjs_ref_no               ;	}
	public String                getCust_ref_no_flg       	(){	return cust_ref_no_flg          ;	}
	public String                getLocl_chg_flg         	(){	return locl_chg_flg             ;	}
	public String                getHjs_ref_eml           	(){	return hjs_ref_eml              ;	}
	public String                getDelt_flg              	(){	return delt_flg                	;	}
	public String                getEai_evnt_dt           	(){	return eai_evnt_dt              ;	}
	public String                getEai_if_id           	(){	return eai_if_id               	;	}
	public String                getCre_usr_id            	(){	return cre_usr_id               ;	}
	public String                getCre_dt                	(){	return cre_dt               	;	}
	public String                getUpd_usr_id            	(){	return upd_usr_id               ;	}
	public String                getUpd_dt                	(){	return upd_dt               	;	}
	public String                getAuto_inv_eml          	(){	return auto_inv_eml             ;	}

	// setter method is proceeding ..
	
	public void setIbflag                	( String                ibflag                	){	this.ibflag               	=	ibflag			;	}
	public void setPage_rows             	( String                page_rows             	){	this.page_rows              =	page_rows		;	}
	public void setCust_cnt_cd           	( String                cust_cnt_cd           	){	this.cust_cnt_cd            = cust_cnt_cd		;	}
	public void setCust_seq              	( String                cust_seq              	){	this.cust_seq               =	cust_seq		;	}
	public void setOfc_cd       			( String                ofc_cd                	){	this.ofc_cd               	=	ofc_cd			;	}
	public void setIo_bnd_cd          		( String                io_bnd_cd               ){	this.io_bnd_cd              =	io_bnd_cd		;	}
	public void setAuto_inv_flg    			( String                auto_inv_flg            ){	this.auto_inv_flg           = auto_inv_flg		;	}
	public void setHjs_cust_svc_pic_tp_cd	( String                hjs_cust_svc_pic_tp_cd  ){	this.hjs_cust_svc_pic_tp_cd = hjs_cust_svc_pic_tp_cd;	}
	public void setHjs_ref_no            	( String                hjs_ref_no              ){	this.hjs_ref_no             = hjs_ref_no		;	}
	public void setCust_ref_no_flg       	( String                cust_ref_no_flg         ){	this.cust_ref_no_flg        = cust_ref_no_flg	;	}
	public void setLocl_chg_flg         	( String                locl_chg_flg            ){	this.locl_chg_flg           = locl_chg_flg		;	}
	public void setHjs_ref_eml           	( String                hjs_ref_eml             ){	this.hjs_ref_eml            = hjs_ref_eml		;	}
	public void setDelt_flg              	( String                delt_flg                ){	this.delt_flg               =	delt_flg		;	}
	public void setEai_evnt_dt           	( String                eai_evnt_dt             ){	this.eai_evnt_dt            = eai_evnt_dt		;	}
	public void setEai_if_id           		( String                eai_if_id               ){	this.eai_if_id              =	eai_if_id		;	}
	public void setCre_usr_id            	( String                cre_usr_id              ){	this.cre_usr_id             = cre_usr_id		;	}
	public void setCre_dt                	( String                cre_dt                	){	this.cre_dt               	=	cre_dt			;	}
	public void setUpd_usr_id            	( String                upd_usr_id              ){	this.upd_usr_id             = upd_usr_id		;	}
	public void setUpd_dt                	( String                upd_dt                	){	this.upd_dt               	=	upd_dt			;	}
	public void setAuto_inv_eml          	( String                auto_inv_eml            ){	this.auto_inv_eml           = auto_inv_eml		;	}
	
	
	public static MdmCustRep fromRequest(HttpServletRequest request) {
		MdmCustRep model = new MdmCustRep();
		try {
			model.setIbflag                	(JSPUtil.getParameter(request, "ibflag                	".trim(), ""));
			model.setPage_rows             	(JSPUtil.getParameter(request, "page_rows             	".trim(), ""));
			model.setCust_cnt_cd           	(JSPUtil.getParameter(request, "cust_cnt_cd           	".trim(), ""));
			model.setCust_seq              	(JSPUtil.getParameter(request, "cust_seq              	".trim(), ""));
			model.setOfc_cd       			(JSPUtil.getParameter(request, "ofc_cd                	".trim(), ""));
			model.setIo_bnd_cd          	(JSPUtil.getParameter(request, "io_bnd_cd               ".trim(), ""));
			model.setAuto_inv_flg    		(JSPUtil.getParameter(request, "auto_inv_flg            ".trim(), ""));
			model.setHjs_cust_svc_pic_tp_cd	(JSPUtil.getParameter(request, "hjs_cust_svc_pic_tp_cd  ".trim(), ""));
			model.setHjs_ref_no            	(JSPUtil.getParameter(request, "hjs_ref_no              ".trim(), ""));
			model.setCust_ref_no_flg       	(JSPUtil.getParameter(request, "cust_ref_no_flg         ".trim(), ""));
			model.setLocl_chg_flg         	(JSPUtil.getParameter(request, "locl_chg_flg            ".trim(), ""));
			model.setHjs_ref_eml           	(JSPUtil.getParameter(request, "hjs_ref_eml             ".trim(), ""));
			model.setDelt_flg              	(JSPUtil.getParameter(request, "delt_flg                ".trim(), ""));
			model.setEai_evnt_dt           	(JSPUtil.getParameter(request, "eai_evnt_dt             ".trim(), ""));
			model.setEai_if_id           	(JSPUtil.getParameter(request, "eai_if_id               ".trim(), ""));
			model.setCre_usr_id            	(JSPUtil.getParameter(request, "cre_usr_id              ".trim(), ""));
			model.setCre_dt                	(JSPUtil.getParameter(request, "cre_dt                	".trim(), ""));
			model.setUpd_usr_id            	(JSPUtil.getParameter(request, "upd_usr_id              ".trim(), ""));
			model.setUpd_dt                	(JSPUtil.getParameter(request, "upd_dt                	".trim(), ""));
			model.setAuto_inv_eml          	(JSPUtil.getParameter(request, "auto_inv_eml            ".trim(), ""));			
			
		} catch (Exception ex) {
			//throw new Exception(ex.getMessage());
		}
		return model;
	}
	public static Collection fromRequest(HttpServletRequest request, int length) {
		MdmCustRep model = null;
		Collection models = new ArrayList();
		try {
			
			String[] ibflag                	=   (JSPUtil.getParameter(request, "ibflag                	".trim(), length));
			String[] page_rows             	=   (JSPUtil.getParameter(request, "page_rows             	".trim(), length));
			String[] cust_cnt_cd           	=   (JSPUtil.getParameter(request, "cust_cnt_cd           	".trim(), length));
			String[] cust_seq              	=   (JSPUtil.getParameter(request, "cust_seq              	".trim(), length));
			String[] ofc_cd       			=   (JSPUtil.getParameter(request, "ofc_cd                	".trim(), length));
			String[] io_bnd_cd          	=   (JSPUtil.getParameter(request, "io_bnd_cd               ".trim(), length));
			String[] auto_inv_flg    		=   (JSPUtil.getParameter(request, "auto_inv_flg            ".trim(), length));
			String[] hjs_cust_svc_pic_tp_cd	=   (JSPUtil.getParameter(request, "hjs_cust_svc_pic_tp_cd  ".trim(), length));
			String[] hjs_ref_no            	=   (JSPUtil.getParameter(request, "hjs_ref_no              ".trim(), length));
			String[] cust_ref_no_flg       	=   (JSPUtil.getParameter(request, "cust_ref_no_flg         ".trim(), length));
			String[] locl_chg_flg         	=   (JSPUtil.getParameter(request, "locl_chg_flg            ".trim(), length));
			String[] hjs_ref_eml           	=   (JSPUtil.getParameter(request, "hjs_ref_eml             ".trim(), length));
			String[] delt_flg              	=   (JSPUtil.getParameter(request, "delt_flg                ".trim(), length));
			String[] eai_evnt_dt           	=   (JSPUtil.getParameter(request, "eai_evnt_dt             ".trim(), length));
			String[] eai_if_id           	=   (JSPUtil.getParameter(request, "eai_if_id               ".trim(), length));
			String[] cre_usr_id            	=   (JSPUtil.getParameter(request, "cre_usr_id              ".trim(), length));
			String[] cre_dt                	=   (JSPUtil.getParameter(request, "cre_dt                	".trim(), length));
			String[] upd_usr_id            	=   (JSPUtil.getParameter(request, "upd_usr_id              ".trim(), length));
			String[] upd_dt                	=   (JSPUtil.getParameter(request, "upd_dt                	".trim(), length));
			String[] auto_inv_eml          	=   (JSPUtil.getParameter(request, "auto_inv_eml            ".trim(), length));		
			
			for (int i = 0; i < length; i++) {
				model = new MdmCustRep();
				
				model.setIbflag                		(ibflag                		[i]);
				model.setPage_rows             		(page_rows             		[i]);
				model.setCust_cnt_cd           		(cust_cnt_cd           		[i]);
				model.setCust_seq              		(cust_seq              		[i]);
				model.setOfc_cd       				(ofc_cd                		[i]);
				model.setIo_bnd_cd          		(io_bnd_cd               	[i]);
				model.setAuto_inv_flg    			(auto_inv_flg            	[i]);
				model.setHjs_cust_svc_pic_tp_cd		(hjs_cust_svc_pic_tp_cd  	[i]);
				model.setHjs_ref_no            		(hjs_ref_no              	[i]);
				model.setCust_ref_no_flg       		(cust_ref_no_flg         	[i]);
				model.setLocl_chg_flg         		(locl_chg_flg            	[i]);
				model.setHjs_ref_eml           		(hjs_ref_eml             	[i]);
				model.setDelt_flg              		(delt_flg                	[i]);
				model.setEai_evnt_dt           		(eai_evnt_dt             	[i]);
				model.setEai_if_id           		(eai_if_id               	[i]);
				model.setCre_usr_id            		(cre_usr_id              	[i]);
				model.setCre_dt                		(cre_dt                		[i]);
				model.setUpd_usr_id            		(upd_usr_id              	[i]);
				model.setUpd_dt                		(upd_dt                		[i]);
				model.setAuto_inv_eml          		(auto_inv_eml            	[i]);		
				
				models.add(model);
			}
		} catch (Exception ex) {
		}
		return models;
	}
	public static Collection fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmCustRep model = null;
		Collection models = new ArrayList();
		int length = request.getParameterValues("ibflag").length;
		try {
			String[] ibflag                	=   (JSPUtil.getParameter(request, prefix + "ibflag                	".trim(), length));
			String[] page_rows             	=   (JSPUtil.getParameter(request, prefix + "page_rows             	".trim(), length));
			String[] cust_cnt_cd           	=   (JSPUtil.getParameter(request, prefix + "cust_cnt_cd           	".trim(), length));
			String[] cust_seq              	=   (JSPUtil.getParameter(request, prefix + "cust_seq              	".trim(), length));
			String[] ofc_cd       			=   (JSPUtil.getParameter(request, prefix + "ofc_cd                	".trim(), length));
			String[] io_bnd_cd          	=   (JSPUtil.getParameter(request, prefix + "io_bnd_cd               ".trim(), length));
			String[] auto_inv_flg    		=   (JSPUtil.getParameter(request, prefix + "auto_inv_flg            ".trim(), length));
			String[] hjs_cust_svc_pic_tp_cd	=   (JSPUtil.getParameter(request, prefix + "hjs_cust_svc_pic_tp_cd  ".trim(), length));
			String[] hjs_ref_no            	=   (JSPUtil.getParameter(request, prefix + "hjs_ref_no              ".trim(), length));
			String[] cust_ref_no_flg       	=   (JSPUtil.getParameter(request, prefix + "cust_ref_no_flg         ".trim(), length));
			String[] locl_chg_flg         	=   (JSPUtil.getParameter(request, prefix + "locl_chg_flg            ".trim(), length));
			String[] hjs_ref_eml           	=   (JSPUtil.getParameter(request, prefix + "hjs_ref_eml             ".trim(), length));
			String[] delt_flg              	=   (JSPUtil.getParameter(request, prefix + "delt_flg                ".trim(), length));
			String[] eai_evnt_dt           	=   (JSPUtil.getParameter(request, prefix + "eai_evnt_dt             ".trim(), length));
			String[] eai_if_id           	=   (JSPUtil.getParameter(request, prefix + "eai_if_id               ".trim(), length));
			String[] cre_usr_id            	=   (JSPUtil.getParameter(request, prefix + "cre_usr_id              ".trim(), length));
			String[] cre_dt                	=   (JSPUtil.getParameter(request, prefix + "cre_dt                	".trim(), length));
			String[] upd_usr_id            	=   (JSPUtil.getParameter(request, prefix + "upd_usr_id              ".trim(), length));
			String[] upd_dt                	=   (JSPUtil.getParameter(request, prefix + "upd_dt                	".trim(), length));
			String[] auto_inv_eml          	=   (JSPUtil.getParameter(request, prefix + "auto_inv_eml            ".trim(), length));	
			
			for (int i = 0; i < length; i++) {
				model = new MdmCustRep();
				
				model.setIbflag                		(ibflag                		[i]);
				model.setPage_rows             		(page_rows             		[i]);
				model.setCust_cnt_cd           		(cust_cnt_cd           		[i]);
				model.setCust_seq              		(cust_seq              		[i]);
				model.setOfc_cd       				(ofc_cd                		[i]);
				model.setIo_bnd_cd          		(io_bnd_cd               	[i]);
				model.setAuto_inv_flg    			(auto_inv_flg            	[i]);
				model.setHjs_cust_svc_pic_tp_cd		(hjs_cust_svc_pic_tp_cd  	[i]);
				model.setHjs_ref_no            		(hjs_ref_no              	[i]);
				model.setCust_ref_no_flg       		(cust_ref_no_flg         	[i]);
				model.setLocl_chg_flg         		(locl_chg_flg            	[i]);
				model.setHjs_ref_eml           		(hjs_ref_eml             	[i]);
				model.setDelt_flg              		(delt_flg                	[i]);
				model.setEai_evnt_dt           		(eai_evnt_dt             	[i]);
				model.setEai_if_id           		(eai_if_id               	[i]);
				model.setCre_usr_id            		(cre_usr_id              	[i]);
				model.setCre_dt                		(cre_dt                		[i]);
				model.setUpd_usr_id            		(upd_usr_id              	[i]);
				model.setUpd_dt                		(upd_dt                		[i]);
				model.setAuto_inv_eml          		(auto_inv_eml            	[i]);	
				
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
