/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SceAdminManageDBDAOSearchRplnCopsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.01.04 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOSearchRplnCopsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * replan 하기 위한 COP 들을 조회한다.
	  * </pre>
	  */
	public SceAdminManageDBDAOSearchRplnCopsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpln_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpln_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpln_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpln_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpln_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpln_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOSearchRplnCopsRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("select " ).append("\n"); 
		query.append("	cop_no," ).append("\n"); 
		query.append("	bkg_no," ).append("\n"); 
		query.append("	mst_cop_no," ).append("\n"); 
		query.append("	cntr_no," ).append("\n"); 
		query.append("	pctl_no" ).append("\n"); 
		query.append("from sce_cop_hdr" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("	1=1" ).append("\n"); 
		query.append("	#if(${rpln_bkg_no} != '')" ).append("\n"); 
		query.append("    	and bkg_no = @[rpln_bkg_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${rpln_bkg_no} != '')" ).append("\n"); 
		query.append("    	and bkg_no = @[rpln_bkg_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${rpln_bl_no} != '')" ).append("\n"); 
		query.append("    	and bkg_no = (select bkg_no from bkg_booking where bl_no = @[rpln_bl_no])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${rpln_cop_no} != '')" ).append("\n"); 
		query.append("    	and cop_no = @[rpln_cop_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${rpln_cntr_no} != '')" ).append("\n"); 
		query.append("    	and cntr_no = @[rpln_cntr_no]" ).append("\n"); 
		query.append("		and cre_dt between to_date(@[rpln_fm_dt], 'yyyyMMdd') and to_date(@[rpln_to_dt], 'yyyyMMdd')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${rpln_fm_dt} != '' && ${rpln_to_dt} != '')" ).append("\n"); 
		query.append("		and cre_dt between to_date(@[rpln_fm_dt], 'yyyyMMdd') and to_date(@[rpln_to_dt], 'yyyyMMdd')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	and cop_sts_cd != 'X'" ).append("\n"); 

	}
}