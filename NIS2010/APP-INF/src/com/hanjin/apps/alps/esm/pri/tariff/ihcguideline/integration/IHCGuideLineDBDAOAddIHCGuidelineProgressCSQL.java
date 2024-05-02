/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCGuideLineDBDAOAddIHCGuidelineProgressCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.05
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.11.05 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOAddIHCGuidelineProgressCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * add IHCGuideline Progress
	  * </pre>
	  */
	public IHCGuideLineDBDAOAddIHCGuidelineProgressCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_prop_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOAddIHCGuidelineProgressCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_IHC_PROG (" ).append("\n"); 
		query.append("            SVC_SCP_CD" ).append("\n"); 
		query.append("          , ORG_DEST_TP_CD  " ).append("\n"); 
		query.append("          , IHC_TRF_NO" ).append("\n"); 
		query.append("          , AMDT_SEQ" ).append("\n"); 
		query.append("          , PROG_SEQ" ).append("\n"); 
		query.append("          , FIC_PROP_STS_CD" ).append("\n"); 
		query.append("          , PROG_OFC_CD" ).append("\n"); 
		query.append("          , PROG_USR_ID" ).append("\n"); 
		query.append("          , PROG_DT" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     VALUES (" ).append("\n"); 
		query.append("            @[svc_scp_cd]" ).append("\n"); 
		query.append("          , @[org_dest_tp_cd]  " ).append("\n"); 
		query.append("          , @[ihc_trf_no]   " ).append("\n"); 
		query.append("          , @[amdt_seq]" ).append("\n"); 
		query.append("          , ( SELECT NVL(MAX(PROG_SEQ)+1, 1)" ).append("\n"); 
		query.append("                FROM PRI_TRF_IHC_PROG" ).append("\n"); 
		query.append("               WHERE 1 = 1" ).append("\n"); 
		query.append("                 AND SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("                 AND IHC_TRF_NO = @[ihc_trf_no] " ).append("\n"); 
		query.append("                 AND AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          , @[fic_prop_sts_cd]" ).append("\n"); 
		query.append("          , @[prog_ofc_cd]" ).append("\n"); 
		query.append("          , @[prog_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          , @[cre_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          , @[upd_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}