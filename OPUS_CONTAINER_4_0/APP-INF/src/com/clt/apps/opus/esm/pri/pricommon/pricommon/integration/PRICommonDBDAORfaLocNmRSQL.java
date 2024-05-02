/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORfaLocNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.08.31 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORfaLocNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Location이름 조회
	  * </pre>
	  */
	public PRICommonDBDAORfaLocNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc4",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORfaLocNmRSQL").append("\n"); 
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
		query.append("SELECT A.LOC_CD AS CD" ).append("\n"); 
		query.append(",A.LOC_NM AS NM" ).append("\n"); 
		query.append(",A.SCONTI_CD AS ETC1" ).append("\n"); 
		query.append(",(SELECT SCONTI_NM" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT" ).append("\n"); 
		query.append("WHERE SCONTI_CD = A.SCONTI_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS ETC2" ).append("\n"); 
		query.append("FROM MDM_LOCATION A" ).append("\n"); 
		query.append("WHERE A.LOC_CD = @[cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND (@[etc4] IS NULL OR @[etc4] = 'B' OR EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP_LMT S" ).append("\n"); 
		query.append("WHERE S.RGN_CD = A.RGN_CD" ).append("\n"); 
		query.append("AND S.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND S.ORG_DEST_CD = @[etc4]" ).append("\n"); 
		query.append("AND S.DELT_FLG = 'N'))" ).append("\n"); 

	}
}