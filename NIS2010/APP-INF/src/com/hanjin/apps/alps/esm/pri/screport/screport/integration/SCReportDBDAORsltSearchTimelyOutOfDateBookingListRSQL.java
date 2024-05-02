/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCReportDBDAORsltSearchTimelyOutOfDateBookingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchTimelyOutOfDateBookingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전체 대상 BKG 중 Batch Result 가 F (Fail) 인 목록조회
	  * </pre>
	  */
	public SCReportDBDAORsltSearchTimelyOutOfDateBookingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchTimelyOutOfDateBookingListRSQL").append("\n"); 
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
		query.append("SELECT O.REGION" ).append("\n"); 
		query.append(" ,B.CTRT_OFC_CD" ).append("\n"); 
		query.append(" ,B.CTRT_SREP_CD" ).append("\n"); 
		query.append(" ,B.BKG_NO" ).append("\n"); 
		query.append(" ,B.VSL_CD ||B.SKD_VOY_NO ||B.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(" ,B.SC_NO" ).append("\n"); 
		query.append(" ,B.RFA_NO" ).append("\n"); 
		query.append(" ,B.TAA_NO" ).append("\n"); 
		query.append(" ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03188' AND INTG_CD_VAL_CTNT = R.RT_CHK_RSLT_CD) RT_CHK_RSLT_CD" ).append("\n"); 
		query.append(" ,B.SVC_SCP_CD -- 여기서부터는 참고 정보" ).append("\n"); 
		query.append(" ,B.BKG_OFC_CD" ).append("\n"); 
		query.append(" ,B.PORT_CLZ_DT" ).append("\n"); 
		query.append(" ,R.RT_APLY_DT" ).append("\n"); 
		query.append(" ,B.BKG_CRE_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING B" ).append("\n"); 
		query.append("    ,BKG_RATE R" ).append("\n"); 
		query.append("    ,BKG_OFC_LVL_V O" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_from_dt} != '' && ${bkg_to_dt} != '') " ).append("\n"); 
		query.append("  AND B.PORT_CLZ_DT BETWEEN TO_DATE(@[bkg_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[bkg_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("  AND B.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("  AND B.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("  AND B.SKD_DIR_CD = SUBSTR(@[vvd],9,4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("  AND R.RT_CHK_DT IS NOT NULL -- 결과가 생성되지 않은 경우 제외" ).append("\n"); 
		query.append("  AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("  AND B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("  AND B.VSL_CD NOT IN ('SMXX','SMYY','SMZZ') --pseudo VSL 제외" ).append("\n"); 
		query.append("  AND B.CTRT_OFC_CD =O.OFC_CD" ).append("\n"); 
		query.append("  AND B.CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("  AND B.CTRT_SREP_CD = @[ctrt_srep_cd]" ).append("\n"); 
		query.append("  AND R.RT_CHK_RSLT_CD = 'F' -- 결과가 fail" ).append("\n"); 
		query.append("ORDER BY O.REGION, B.SVC_SCP_CD, B.BKG_OFC_CD, B.SC_NO, B.RFA_NO, B.TAA_NO, B.BKG_NO" ).append("\n"); 

	}
}