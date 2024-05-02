/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountSeparateMUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.09.30 이정혜
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountSeparateMUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RecalculateRevisedVolumeCountSeparateM
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountSeparateMUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountSeparateMUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SO_DTL D" ).append("\n"); 
		query.append("SET D.RVIS_VOL_QTY = (SELECT SUM(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.INV_GATE_IN_DT IS NOT NULL AND REPLACE(@[fm_prd_dt],'-') IS NOT NULL AND LENGTH(REPLACE(@[fm_prd_dt],'-'))=8" ).append("\n"); 
		query.append("THEN DECODE(SIGN(REPLACE(@[fm_prd_dt],'-')||'0000'-TO_CHAR(A.INV_GATE_IN_DT,'YYYYMMDDHH24MI')),1,0,DECODE(A.RVIS_GATE_IN_FLG,'Y',0,1))" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) +" ).append("\n"); 
		query.append("SUM(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.INV_GATE_OUT_DT IS NOT NULL AND REPLACE(@[fm_prd_dt],'-') IS NOT NULL AND LENGTH(REPLACE(@[fm_prd_dt],'-'))=8" ).append("\n"); 
		query.append("THEN DECODE(A.RVIS_GATE_OUT_FLG,'Y',0,1)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END)  RVIS_VOL_QTY" ).append("\n"); 
		query.append("FROM TES_TML_SO_RVIS_LIST A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND A.TML_SO_DTL_SEQ = @[tml_so_dtl_seq])," ).append("\n"); 
		query.append("D.CALC_VOL_QTY = (SELECT SUM(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.INV_GATE_IN_DT IS NOT NULL AND REPLACE(@[fm_prd_dt],'-') IS NOT NULL AND LENGTH(REPLACE(@[fm_prd_dt],'-'))=8" ).append("\n"); 
		query.append("THEN DECODE(SIGN(REPLACE(@[fm_prd_dt],'-')||'0000'-TO_CHAR(A.INV_GATE_IN_DT,'YYYYMMDDHH24MI')),1,0,DECODE(A.RVIS_GATE_IN_FLG,'Y',0,1))" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) +" ).append("\n"); 
		query.append("SUM(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.INV_GATE_OUT_DT IS NOT NULL AND REPLACE(@[fm_prd_dt],'-') IS NOT NULL AND LENGTH(REPLACE(@[fm_prd_dt],'-'))=8" ).append("\n"); 
		query.append("THEN DECODE(A.RVIS_GATE_OUT_FLG,'Y',0,1)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END)  RVIS_VOL_QTY" ).append("\n"); 
		query.append("FROM TES_TML_SO_RVIS_LIST A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND A.TML_SO_DTL_SEQ = @[tml_so_dtl_seq])," ).append("\n"); 
		query.append("D.INV_AMT = ( D.CTRT_RT *  (SELECT SUM(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.INV_GATE_IN_DT IS NOT NULL AND REPLACE(@[fm_prd_dt],'-') IS NOT NULL AND LENGTH(REPLACE(@[fm_prd_dt],'-'))=8" ).append("\n"); 
		query.append("THEN DECODE(SIGN(REPLACE(@[fm_prd_dt],'-')||'0000'-TO_CHAR(A.INV_GATE_IN_DT,'YYYYMMDDHH24MI')),1,0,DECODE(A.RVIS_GATE_IN_FLG,'Y',0,1))" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END) +" ).append("\n"); 
		query.append("SUM(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.INV_GATE_OUT_DT IS NOT NULL AND REPLACE(@[fm_prd_dt],'-') IS NOT NULL AND LENGTH(REPLACE(@[fm_prd_dt],'-'))=8" ).append("\n"); 
		query.append("THEN DECODE(A.RVIS_GATE_OUT_FLG,'Y',0,1)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END)  RVIS_VOL_QTY" ).append("\n"); 
		query.append("FROM TES_TML_SO_RVIS_LIST A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND A.TML_SO_DTL_SEQ = @[tml_so_dtl_seq]))" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND D.TML_SO_DTL_SEQ = @[tml_so_dtl_seq]" ).append("\n"); 

	}
}