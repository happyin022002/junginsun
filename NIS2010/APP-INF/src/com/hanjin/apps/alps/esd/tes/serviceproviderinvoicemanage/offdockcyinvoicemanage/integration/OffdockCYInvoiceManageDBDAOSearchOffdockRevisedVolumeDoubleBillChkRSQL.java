/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchOffdockRevisedVolumeDoubleBillChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchOffdockRevisedVolumeDoubleBillChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revised Volume pop up Double Billing check
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchOffdockRevisedVolumeDoubleBillChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_gate_in_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_gate_out_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchOffdockRevisedVolumeDoubleBillChkRSQL").append("\n"); 
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
		query.append("SELECT NVL(COUNT(CNTR_NO),0) CNTR_CNT, @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT B.CNTR_NO" ).append("\n"); 
		query.append("    FROM TES_TML_SO_HDR A," ).append("\n"); 
		query.append("      TES_TML_SO_CNTR_LIST B" ).append("\n"); 
		query.append("    WHERE A.TML_SO_OFC_CTY_CD = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      AND A.TML_SO_SEQ = B.TML_SO_SEQ" ).append("\n"); 
		query.append("      AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("      AND A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("      AND B.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("      AND B.CNTR_STY_CD = @[cntr_sty_cd]" ).append("\n"); 
		query.append("      AND A.INV_NO <> @[inv_no]" ).append("\n"); 
		query.append("      AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND A.TML_INV_TP_CD = 'OF'" ).append("\n"); 
		query.append("      AND A.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("      AND ABS(MONTHS_BETWEEN(B.MVMT_GATE_IN_DT, TO_DATE(@[inv_gate_in_dt],'YYYYMMDDHH24MISS'))) <= 1" ).append("\n"); 
		query.append("      AND CASE WHEN (SIGN(A.TO_PRD_DT-A.FM_PRD_DT)>0" ).append("\n"); 
		query.append("          AND SIGN(replace(@[fm_prd_dt], '-')-A.TO_PRD_DT)>0)" ).append("\n"); 
		query.append("      OR (SIGN(A.TO_PRD_DT-A.FM_PRD_DT)>0" ).append("\n"); 
		query.append("          AND SIGN(A.FM_PRD_DT- replace(@[to_prd_dt], '-'))>0) THEN 'N' ELSE 'Y' END = 'Y'" ).append("\n"); 
		query.append("      AND CASE WHEN (SIGN(B.MVMT_GATE_OUT_DT-B.MVMT_GATE_IN_DT)>0" ).append("\n"); 
		query.append("          AND SIGN(TO_DATE(@[inv_gate_in_dt], 'YYYYMMDDHH24MISS')-B.MVMT_GATE_OUT_DT)>0)" ).append("\n"); 
		query.append("      OR (SIGN(B.MVMT_GATE_OUT_DT-B.MVMT_GATE_IN_DT)>0" ).append("\n"); 
		query.append("          AND SIGN(B.MVMT_GATE_IN_DT-TO_DATE(@[inv_gate_out_dt], 'YYYYMMDDHH24MISS'))>0) THEN 'N' ELSE 'Y' END = 'Y'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT B.CNTR_NO" ).append("\n"); 
		query.append("    FROM TES_TML_SO_HDR A," ).append("\n"); 
		query.append("      TES_TML_SO_RVIS_LIST B" ).append("\n"); 
		query.append("    WHERE A.TML_SO_OFC_CTY_CD = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      AND A.TML_SO_SEQ = B.TML_SO_SEQ" ).append("\n"); 
		query.append("      AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("      AND A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("      AND B.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("      AND B.CNTR_STY_CD = @[cntr_sty_cd]" ).append("\n"); 
		query.append("      AND A.INV_NO <> @[inv_no]" ).append("\n"); 
		query.append("      AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND A.TML_INV_TP_CD = 'OF'" ).append("\n"); 
		query.append("      AND A.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("      AND ABS(MONTHS_BETWEEN(B.INV_GATE_IN_DT, TO_DATE(@[inv_gate_in_dt],'YYYYMMDDHH24MISS'))) <= 1" ).append("\n"); 
		query.append("      AND CASE WHEN (SIGN(A.TO_PRD_DT-A.FM_PRD_DT)>0" ).append("\n"); 
		query.append("          AND SIGN(replace(@[fm_prd_dt], '-')-A.TO_PRD_DT)>0)" ).append("\n"); 
		query.append("      OR (SIGN(A.TO_PRD_DT-A.FM_PRD_DT)>0" ).append("\n"); 
		query.append("          AND SIGN(A.FM_PRD_DT- replace(@[to_prd_dt], '-'))>0) THEN 'N' ELSE 'Y' END = 'Y'" ).append("\n"); 
		query.append("      AND CASE WHEN (SIGN(B.INV_GATE_OUT_DT-B.INV_GATE_IN_DT)>0" ).append("\n"); 
		query.append("          AND SIGN(TO_DATE(@[inv_gate_in_dt], 'YYYYMMDDHH24MISS')-B.INV_GATE_OUT_DT)>0)" ).append("\n"); 
		query.append("      OR (SIGN(B.INV_GATE_OUT_DT-B.INV_GATE_IN_DT)>0" ).append("\n"); 
		query.append("          AND SIGN(B.INV_GATE_IN_DT-TO_DATE(@[inv_gate_out_dt], 'YYYYMMDDHH24MISS'))>0) THEN 'N' ELSE 'Y' END = 'Y' )" ).append("\n"); 

	}
}