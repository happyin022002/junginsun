/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CEDEXCodeMgtDBDAOsearchComponentCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.08.11 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CEDEXCodeMgtDBDAOsearchComponentCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회   
	  * </pre>
	  */
	public CEDEXCodeMgtDBDAOsearchComponentCodeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration").append("\n"); 
		query.append("FileName : CEDEXCodeMgtDBDAOsearchComponentCodeListDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_CMPO_NM," ).append("\n"); 
		query.append("A.EQ_CMPO_CD," ).append("\n"); 
		query.append("A.EQ_CMPO_GRP_TP_CD," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.EQ_KND_CD," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.EQ_CMPO_NUM_ISO_CD," ).append("\n"); 
		query.append("A.EQ_PRNT_CMPO_GRP_TP_CD," ).append("\n"); 
		query.append("A.EQ_CMPO_DESC," ).append("\n"); 
		query.append("A.EQ_PRNT_CMPO_CD," ).append("\n"); 
		query.append("NVL(CNTR_CMPO_FLG,'N') AS CNTR_CMPO_FLG," ).append("\n"); 
		query.append("NVL(CHSS_CMPO_FLG,'N') AS CHSS_CMPO_FLG," ).append("\n"); 
		query.append("NVL(MGST_CMPO_FLG,'N') AS MGST_CMPO_FLG" ).append("\n"); 
		query.append("FROM MNR_EQ_CMPO_CD A" ).append("\n"); 
		query.append("WHERE A.EQ_CMPO_GRP_TP_CD = @[eq_cmpo_grp_tp_cd]" ).append("\n"); 
		query.append("#if (${key_value} != 'All')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_cmpo_grp_tp_cd} == '1')" ).append("\n"); 
		query.append("AND A.EQ_CMPO_CD = @[key_value]" ).append("\n"); 
		query.append("#elseif (${eq_cmpo_grp_tp_cd} == '2')" ).append("\n"); 
		query.append("AND A.EQ_PRNT_CMPO_CD = @[key_value]" ).append("\n"); 
		query.append("#elseif (${eq_cmpo_grp_tp_cd} == '3')" ).append("\n"); 
		query.append("AND A.EQ_PRNT_CMPO_CD IN ( SELECT EQ_CMPO_CD" ).append("\n"); 
		query.append("FROM MNR_EQ_CMPO_CD" ).append("\n"); 
		query.append("WHERE EQ_CMPO_GRP_TP_CD = '2'" ).append("\n"); 
		query.append("AND EQ_PRNT_CMPO_CD = @[key_value]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}