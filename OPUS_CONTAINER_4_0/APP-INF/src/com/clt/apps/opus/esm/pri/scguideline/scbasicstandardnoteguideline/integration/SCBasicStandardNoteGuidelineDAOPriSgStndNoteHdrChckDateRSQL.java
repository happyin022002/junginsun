/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrChckDateRSQL.java
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

public class SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrChckDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기간이 겹치지 않는지 체크
	  * </pre>
	  */
	public SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrChckDateRSQL(){
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
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("note_ref_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.integration").append("\n"); 
		query.append("FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrChckDateRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(*) AS CHK" ).append("\n"); 
		query.append("FROM PRI_SG_STND_NOTE_HDR" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${prc_cust_tp_cd} != '')" ).append("\n"); 
		query.append("AND	  PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_cust_tp_cd} == '')" ).append("\n"); 
		query.append("AND	  PRC_CUST_TP_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	TO_CHAR(EFF_DT, 'YYYY-MM-DD') = @[eff_dt]" ).append("\n"); 
		query.append("AND	NOTE_REF_YR = @[note_ref_yr]" ).append("\n"); 
		query.append("#if (${note_hdr_seq} != '')" ).append("\n"); 
		query.append("AND	NOTE_HDR_SEQ <> @[note_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}