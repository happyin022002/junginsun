/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchMonthlyTgtOrzCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchMonthlyTgtOrzCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CommonDBDAOSearchMonthlyTgtOrzCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_orz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_ofc_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stageText",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetGrp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qta_mst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_ofc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchMonthlyTgtOrzCdListRSQL").append("\n"); 
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
		query.append("SELECT  CODE  " ).append("\n"); 
		query.append("         , @[stageText] || '|' || INTG_CD_VAL_DP_DESC ||  '|' || GDT AS TEXT " ).append("\n"); 
		query.append("FROM (   " ).append("\n"); 
		query.append(" 	SELECT  DAT_CRE_STEP_CD || '-' || TGT_ORZ_CD AS CODE  " ).append("\n"); 
		query.append("         ,A.TGT_ORZ_CD || A.DAT_CRE_STEP_CD AS JOIN_CODE  " ).append("\n"); 
		query.append("         , MAX(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', SMRY_CRE_GDT, @[tgt_ofc_cd1] ), 'YYYY-MM-DD HH24:MI')) AS GDT " ).append("\n"); 
		query.append(" 	FROM SAQ_MON_QTA_ADJ_SMRY_HDR A   " ).append("\n"); 
		query.append(" 	WHERE  A.SAQ_TGT_GRP_CD LIKE @[targetGrp] || '%'  " ).append("\n"); 
		query.append("        AND A.TGT_ORZ_CD = @[tgt_orz_cd]  " ).append("\n"); 
		query.append("        AND A.BSE_YR = @[year]  " ).append("\n"); 
		query.append("        AND A.BSE_QTR_CD = @[bse_qtr_cd]  " ).append("\n"); 
		query.append("#if (${qta_mst_ver_no} != '')" ).append("\n"); 
		query.append("        AND A.QTA_MST_VER_NO = @[qta_mst_ver_no]  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("		#if (${stage} == 'SQ' )" ).append("\n"); 
		query.append("			AND DAT_CRE_STEP_CD < '08' 	" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND DAT_CRE_STEP_CD = '08' 	" ).append("\n"); 
		query.append("		#end				" ).append("\n"); 
		query.append("        AND ( A.TGT_OFC_CD='000000' OR A.TGT_OFC_CD=@[tgt_ofc_cd1] OR A.TGT_OFC_CD=@[tgt_ofc_cd2]  OR DECODE(@[tgt_orz_cd],'B',1,0) =1 )   " ).append("\n"); 
		query.append(" 	GROUP BY  DAT_CRE_STEP_CD || '-' || TGT_ORZ_CD	,A.TGT_ORZ_CD || A.DAT_CRE_STEP_CD 			  " ).append("\n"); 
		query.append(")  HDR " ).append("\n"); 
		query.append(",COM_INTG_CD_DTL COM  				" ).append("\n"); 
		query.append("WHERE   COM.INTG_CD_ID = 'CD01322' AND COM.INTG_CD_VAL_CTNT = JOIN_CODE " ).append("\n"); 
		query.append("ORDER BY CODE" ).append("\n"); 

	}
}