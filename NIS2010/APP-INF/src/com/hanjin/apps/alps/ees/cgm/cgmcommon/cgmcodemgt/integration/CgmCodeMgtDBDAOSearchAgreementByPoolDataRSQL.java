/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchAgreementByPoolDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.31
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchAgreementByPoolDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CgmCodeMgtDBSearchAgreemenByPoolData
	  * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	  * 2014.12.31 Chang Young Kim
	  * [CHM-201433507] EES_CGM_1124화면에서 AGMT_VER_NO가 Fix되어 있는 문제 수정
	  * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchAgreementByPoolDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchAgreementByPoolDataRSQL").append("\n"); 
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
		query.append("#if (${chss_pool_cd} == '') " ).append("\n"); 
		query.append("SELECT A.AGMT_OFC_CTY_CD      AS CODE1,   " ).append("\n"); 
		query.append("       LPAD(A.AGMT_SEQ,6,'0') AS CODE2," ).append("\n"); 
		query.append("       A.AGMT_REF_NO          AS CODE3," ).append("\n"); 
		query.append("       A.VNDR_SEQ             AS CODE4," ).append("\n"); 
		query.append("       B.VNDR_LGL_ENG_NM      AS DESC4," ).append("\n"); 
		query.append("       A.CHSS_POOL_CD         AS CODE5," ).append("\n"); 
		query.append("       A.CURR_CD              AS CODE6," ).append("\n"); 
		query.append("       A.AGMT_VER_NO          AS DESC1" ).append("\n"); 
		query.append("  FROM CGM_AGREEMENT A, MDM_VENDOR B" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("   AND A.LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.AGMT_LSTM_CD = @[agmt_lstm_cd]" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.AGMT_OFC_CTY_CD AS CODE1," ).append("\n"); 
		query.append("       A.AGMT_SEQ        AS CODE2," ).append("\n"); 
		query.append("       A.AGMT_REF_NO     AS CODE3," ).append("\n"); 
		query.append("       A.VNDR_SEQ        AS CODE4," ).append("\n"); 
		query.append("       B.VNDR_LGL_ENG_NM AS DESC4," ).append("\n"); 
		query.append("       A.CHSS_POOL_CD    AS CODE5," ).append("\n"); 
		query.append("       A.CURR_CD         AS CODE6," ).append("\n"); 
		query.append("       A.AGMT_VER_NO     AS DESC1" ).append("\n"); 
		query.append("  FROM CGM_AGREEMENT A, MDM_VENDOR B" ).append("\n"); 
		query.append(" WHERE @[chss_pool_cd] = A.CHSS_POOL_CD" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("   AND A.LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.AGMT_LSTM_CD = @[agmt_lstm_cd]" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}