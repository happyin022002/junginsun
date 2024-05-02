/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RuLabelManagementDBDAOsearchRuLabelAttachCntrmentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.02.12 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RuLabelManagementDBDAOsearchRuLabelAttachCntrmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cntr을 입력하여 조회하는 해당 cntr 값 추출
	  * </pre>
	  */
	public RuLabelManagementDBDAOsearchRuLabelAttachCntrmentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOsearchRuLabelAttachCntrmentListRSQL").append("\n"); 
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
		query.append("SELECT   MC.CNTR_NO" ).append("\n"); 
		query.append("       , MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , MC.AGMT_CTY_CD|| LTRIM(TO_CHAR(MC.AGMT_SEQ,'000000')) AGMT_NO" ).append("\n"); 
		query.append("       , MC.VNDR_SEQ  AS LESSOR" ).append("\n"); 
		query.append("       , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE MC.VNDR_SEQ = B.VNDR_SEQ) AS LESSOR_NM" ).append("\n"); 
		query.append("       , MC.CNTR_AUTH_NO  " ).append("\n"); 
		query.append("       , (SELECT  LA.LSE_CTRT_NO" ).append("\n"); 
		query.append("            FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("           WHERE LA.AGMT_CTY_CD = MC.AGMT_CTY_CD" ).append("\n"); 
		query.append("             AND LA.AGMT_SEQ    = MC.AGMT_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM         = 1) AS LSE_CTRT_NO" ).append("\n"); 
		query.append("       , MC.CRNT_YD_CD" ).append("\n"); 
		query.append("       , MC.CNMV_STS_CD" ).append("\n"); 
		query.append("       , TO_CHAR(MC.CNMV_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_DT" ).append("\n"); 
		query.append("       , DECODE(MC.FULL_FLG, 'Y', 'F', 'M') AS FULL_FLG" ).append("\n"); 
		query.append("       , MC.CNTR_STS_CD" ).append("\n"); 
		query.append("       , MC.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("       , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("            FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("           WHERE MC.MFTR_VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM               = 1) MFTR_VNDR_NM" ).append("\n"); 
		query.append("       , TO_CHAR(MC.MFT_DT, 'YYYY-MM-DD') AS MFT_DT" ).append("\n"); 
		query.append("       , DECODE(MC.RF_MKR_SEQ, 0, NULL, MC.RF_MKR_SEQ) RF_MKR_SEQ" ).append("\n"); 
		query.append("       , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("            FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("           WHERE MC.RF_MKR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM               = 1) RF_MKR_NM  " ).append("\n"); 
		query.append("       , MC.RF_MDL_NM" ).append("\n"); 
		query.append("       , MC.LSTM_CD" ).append("\n"); 
		query.append("  FROM MST_CONTAINER MC" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND MC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(" ORDER BY CRE_DT, UPD_DT" ).append("\n"); 

	}
}