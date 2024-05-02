/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.05.04 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see 
 * @since J2EE 1.4
 */

public class SCGroupLocationGuidelineDBDAORsltPriSgGrpLocExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GroupLocation Excel조회
	  * </pre>
	  */
	public SCGroupLocationGuidelineDBDAORsltPriSgGrpLocExcelRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT a.svc_scp_cd," ).append("\n"); 
		query.append("a.gline_seq," ).append("\n"); 
		query.append("a.grp_loc_seq," ).append("\n"); 
		query.append("b.grp_loc_dtl_seq," ).append("\n"); 
		query.append("a.prc_grp_loc_cd," ).append("\n"); 
		query.append("a.prc_grp_loc_desc," ).append("\n"); 
		query.append("b.loc_cd," ).append("\n"); 
		query.append("c.loc_nm," ).append("\n"); 
		query.append("c.sconti_cd," ).append("\n"); 
		query.append("(SELECT sconti_nm" ).append("\n"); 
		query.append("FROM mdm_subcontinent" ).append("\n"); 
		query.append("WHERE sconti_cd = c.sconti_cd" ).append("\n"); 
		query.append("AND rownum = 1) as sconti_nm" ).append("\n"); 
		query.append("FROM pri_sg_grp_loc a, pri_sg_grp_loc_dtl b, mdm_location c" ).append("\n"); 
		query.append("WHERE a.svc_scp_cd = b.svc_scp_cd(+)" ).append("\n"); 
		query.append("AND a.gline_seq = b.gline_seq(+)" ).append("\n"); 
		query.append("AND a.grp_loc_seq = b.grp_loc_seq(+)" ).append("\n"); 
		query.append("AND b.loc_cd = c.loc_cd(+)" ).append("\n"); 
		query.append("AND a.svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND a.gline_seq = @[gline_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.integration").append("\n"); 
		query.append("FileName : SCGroupLocationGuidelineDBDAORsltPriSgGrpLocExcelRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}