/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSendDBDAOAddEmlSndRsltCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.18
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.18 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VskEmailSendDBDAOAddEmlSndRsltCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * email 송신 결과를 SCE_EML_SND_RSLT 에 subscriber 별로 저장 한다.
	  * </pre>
	  */
	public VskEmailSendDBDAOAddEmlSndRsltCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_rslt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subsc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_rslt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_jb_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.integration").append("\n"); 
		query.append("FileName : VskEmailSendDBDAOAddEmlSndRsltCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_EML_SND_RSLT (" ).append("\n"); 
		query.append("EML_JB_ID," ).append("\n"); 
		query.append("SVC_ST_DT," ).append("\n"); 
		query.append("SVC_END_DT," ).append("\n"); 
		query.append("EML_GRP_ID," ).append("\n"); 
		query.append("SUBSC_SEQ," ).append("\n"); 
		query.append("EML_EVNT_DT," ).append("\n"); 
		query.append("EML_EVNT_HR," ).append("\n"); 
		query.append("EML_EVNT_MNT," ).append("\n"); 
		query.append("EML_CTNT," ).append("\n"); 
		query.append("EML_SND_RSLT_FLG," ).append("\n"); 
		query.append("EML_SND_RSLT_RMK," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("VSL_SLAN_CD," ).append("\n"); 
		query.append("TO_PORT_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[eml_jb_id]," ).append("\n"); 
		query.append("@[svc_st_dt]," ).append("\n"); 
		query.append("@[svc_end_dt]," ).append("\n"); 
		query.append("@[eml_grp_id]," ).append("\n"); 
		query.append("@[subsc_seq]," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYYMMDD')," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'HH24')," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'MI')," ).append("\n"); 
		query.append("@[eml_ctnt]," ).append("\n"); 
		query.append("@[eml_snd_rslt_flg]," ).append("\n"); 
		query.append("@[eml_snd_rslt_rmk]," ).append("\n"); 
		query.append("'SYSTEM'," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("'SYSTEM'," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[vsl_slan_cd]," ).append("\n"); 
		query.append("@[to_port_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}