/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.18 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 헤더 수정   
	  * </pre>
	  */
	public SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_ref_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.integration").append("\n"); 
		query.append("FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("svc_scp_cd," ).append("\n"); 
		query.append("prc_cust_tp_cd," ).append("\n"); 
		query.append("note_hdr_seq," ).append("\n"); 
		query.append("to_char(eff_dt,'yyyy-mm-dd') as eff_dt," ).append("\n"); 
		query.append("to_char(exp_dt,'yyyy-mm-dd') as exp_dt," ).append("\n"); 
		query.append("note_ref_yr," ).append("\n"); 
		query.append("note_nm," ).append("\n"); 
		query.append("DECODE(cfm_flg,'N','No','Y','Yes',cfm_flg) AS cfm_flg," ).append("\n"); 
		query.append("cfm_usr_id," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append("from pri_sg_stnd_note_hdr" ).append("\n"); 
		query.append("where	svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${note_ref_yr} != '')" ).append("\n"); 
		query.append("and	note_ref_yr = @[note_ref_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${note_hdr_seq} != '')" ).append("\n"); 
		query.append("and	note_hdr_seq = @[note_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${note_hdr_seq} == '')" ).append("\n"); 
		query.append("#if (${eff_dt} != '')" ).append("\n"); 
		query.append("AND TO_CHAR(EFF_DT, 'YYYY-MM-DD') = @[eff_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${exp_dt} != '')" ).append("\n"); 
		query.append("AND TO_CHAR(EXP_DT, 'YYYY-MM-DD') = @[exp_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${note_hdr_seq} != '')" ).append("\n"); 
		query.append("ORDER BY EFF_DT DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${note_hdr_seq} == '')" ).append("\n"); 
		query.append("ORDER BY note_nm" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}