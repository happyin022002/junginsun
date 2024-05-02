/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORsltTotLocListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.27 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltTotLocListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location
	  * Station
	  * Country
	  * Region
	  * </pre>
	  */
	public PRICommonDBDAORsltTotLocListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltTotLocListRSQL").append("\n"); 
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
		query.append("#if (${cd_length} == '5')" ).append("\n"); 
		query.append("SELECT LOC_CD CD" ).append("\n"); 
		query.append(", LOC_NM NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD= @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG ='N'" ).append("\n"); 
		query.append("#elseif (${cd_length} == '2')" ).append("\n"); 
		query.append("SELECT CNT_CD CD" ).append("\n"); 
		query.append(", CNT_NM NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${cd_length} == '3')" ).append("\n"); 
		query.append("SELECT RGN_CD CD" ).append("\n"); 
		query.append(", RGN_NM NM" ).append("\n"); 
		query.append("FROM MDM_REGION" ).append("\n"); 
		query.append("WHERE RGN_CD = @[cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${cd_length} == '4')" ).append("\n"); 
		query.append("#if (${group_cmd} == '2')" ).append("\n"); 
		query.append("SELECT PRC_GRP_LOC_CD 	CD" ).append("\n"); 
		query.append(", PRC_GRP_LOC_DESC NM" ).append("\n"); 
		query.append("FROM PRI_SG_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = @[cd]" ).append("\n"); 
		query.append("#elseif (${group_cmd} == '0')" ).append("\n"); 
		query.append("SELECT PRC_GRP_LOC_CD 	CD" ).append("\n"); 
		query.append(", PRC_GRP_LOC_DESC NM" ).append("\n"); 
		query.append("FROM PRI_RG_GRP_LOC" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("#if (${etc2} != '')" ).append("\n"); 
		query.append("AND (ORG_DEST_TP_CD = 'B' OR ORG_DEST_TP_CD = @[etc2])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = @[cd]" ).append("\n"); 
		query.append("#elseif (${group_cmd} == '3')" ).append("\n"); 
		query.append("SELECT A.PRC_GRP_LOC_CD   CD" ).append("\n"); 
		query.append(", A.PRC_GRP_LOC_DESC NM" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC A" ).append("\n"); 
		query.append(", ( SELECT DISTINCT SVC_SCP_CD, PROP_NO, AMDT_SEQ, GRP_LOC_SEQ" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("WHERE SRC_INFO_CD != 'AD' ) B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD		= B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.PROP_NO		= B.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ		= B.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.GRP_LOC_SEQ	= B.GRP_LOC_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD 	= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("AND A.PRC_GRP_LOC_CD = @[cd]" ).append("\n"); 
		query.append("#elseif (${group_cmd} == '1')" ).append("\n"); 
		query.append("SELECT A.PRC_GRP_LOC_CD   CD" ).append("\n"); 
		query.append(", A.PRC_GRP_LOC_DESC NM" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_LOC A" ).append("\n"); 
		query.append(", ( SELECT DISTINCT SVC_SCP_CD, PROP_NO, AMDT_SEQ, GRP_LOC_SEQ" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("WHERE SRC_INFO_CD != 'AD' ) B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD		= B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.PROP_NO		= B.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ		= B.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.GRP_LOC_SEQ	= B.GRP_LOC_SEQ" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD 	= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("#if (${etc2} != '')" ).append("\n"); 
		query.append("AND (A.ORG_DEST_TP_CD = 'B' OR A.ORG_DEST_TP_CD = @[etc2])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.PRC_GRP_LOC_CD = @[cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}