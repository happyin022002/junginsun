/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVOCopyCSQL.java
*@FileTitle : CMPB Guideline Creation - Location Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.17 이승준
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

public class SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVOCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 헤더를 복사하여 등록
	  * </pre>
	  */
	public SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVOCopyCSQL(){
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
		params.put("note_hdr_seq_copy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd_copy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_ref_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.integration").append("\n"); 
		query.append("FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVOCopyCSQL").append("\n"); 
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
		query.append("insert into pri_sg_stnd_note_hdr (" ).append("\n"); 
		query.append("svc_scp_cd," ).append("\n"); 
		query.append("prc_cust_tp_cd," ).append("\n"); 
		query.append("note_hdr_seq," ).append("\n"); 
		query.append("eff_dt," ).append("\n"); 
		query.append("exp_dt," ).append("\n"); 
		query.append("note_ref_yr," ).append("\n"); 
		query.append("note_nm," ).append("\n"); 
		query.append("cfm_flg," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[svc_scp_cd]" ).append("\n"); 
		query.append(",	@[prc_cust_tp_cd]" ).append("\n"); 
		query.append(",	@[note_hdr_seq]" ).append("\n"); 
		query.append(",	TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_DATE(@[exp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[note_ref_yr]" ).append("\n"); 
		query.append(",	@[note_nm]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM  PRI_SG_STND_NOTE_HDR" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd_copy]" ).append("\n"); 
		query.append("AND   NOTE_HDR_SEQ = @[note_hdr_seq_copy]" ).append("\n"); 

	}
}