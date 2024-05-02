/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineDBDAOPriDestCmpbGlineRoutPntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.01 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMPBGuidelineDBDAOPriDestCmpbGlineRoutPntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * point Dest select
	  * </pre>
	  */
	public CMPBGuidelineDBDAOPriDestCmpbGlineRoutPntVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration").append("\n"); 
		query.append("FileName : CMPBGuidelineDBDAOPriDestCmpbGlineRoutPntVORSQL").append("\n"); 
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
		query.append("A.SVC_SCP_CD" ).append("\n"); 
		query.append(",	A.CRE_OFC_CD" ).append("\n"); 
		query.append(",	A.GLINE_SEQ" ).append("\n"); 
		query.append(",	A.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",	A.BSE_SEQ" ).append("\n"); 
		query.append(",	A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",	A.ROUT_PNT_SEQ" ).append("\n"); 
		query.append(",	A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",	A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",	A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",	DECODE(A.ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("'G',                                                 --GROUP LOCATION" ).append("\n"); 
		query.append("(SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_CMPB_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'R'," ).append("\n"); 
		query.append("(SELECT RGN_NM                                       --REGION" ).append("\n"); 
		query.append("FROM MDM_REGION" ).append("\n"); 
		query.append("WHERE RGN_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'C',                                                --COUNTRY" ).append("\n"); 
		query.append("(SELECT CNT_NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)," ).append("\n"); 
		query.append("'L',                                                --LOCATION" ).append("\n"); 
		query.append("(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append(",	(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("AND   INTG_CD_VAL_CTNT = A.RCV_DE_TERM_CD) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_ROUT_PNT A" ).append("\n"); 
		query.append("WHERE	A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND	A.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND	A.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("AND	A.BSE_SEQ = @[bse_seq]" ).append("\n"); 
		query.append("AND	A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("ORDER BY DECODE(A.ROUT_PNT_LOC_TP_CD, 'C', '1', 'R', '2','G', '3', 'L', '4'), A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 

	}
}