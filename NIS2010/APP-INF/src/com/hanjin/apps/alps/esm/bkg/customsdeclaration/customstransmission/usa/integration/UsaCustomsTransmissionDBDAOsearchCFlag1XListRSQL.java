/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCFlag1XListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.31
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.10.31 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCFlag1XListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCFlag1XList
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCFlag1XListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCFlag1XListRSQL").append("\n"); 
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
		query.append("#if (${rail} == 'RAIL')" ).append("\n"); 
		query.append("SELECT RS.BL_NO" ).append("\n"); 
		query.append("      ,RS.CSTMS_SEQ" ).append("\n"); 
		query.append("      ,RS.DSPO_CD" ).append("\n"); 
		query.append("      ,TO_NUMBER(TO_CHAR(RS.RCV_DT, 'YYYYMMDDHH24MISS')) AS ARR_DT" ).append("\n"); 
		query.append("      ,DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_H_CD', 'H') AS HOLD_FLG" ).append("\n"); 
		query.append("      ,DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_R_CD', 'R') AS REMV_FLG" ).append("\n"); 
		query.append("      ,DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_H_CD', CD.ATTR_CTNT4) AS REMV_CD" ).append("\n"); 
		query.append("      ,RS.CNTR_QTY" ).append("\n"); 
		query.append("FROM  ( SELECT CNT_CD, BL_NO, CSTMS_SEQ, RCV_DT, CNTR_NO, CNTR_QTY, DSPO_CD, CSTMS_CLR_CD" ).append("\n"); 
		query.append("		FROM  BKG_CSTMS_ADV_CNTR_RSLT " ).append("\n"); 
		query.append("        UNION ALL   " ).append("\n"); 
		query.append("        SELECT 'US', @[bl_no], 10000, sysdate, @[in_cntr], TO_NUMBER(@[icr_qty]), @[icr_code]," ).append("\n"); 
		query.append("		'' from dual  -- 수신 데이터가 선입력 되지 않아 UNION ALL처리" ).append("\n"); 
		query.append("       ) RS" ).append("\n"); 
		query.append("      ,BKG_CSTMS_CD_CONV_CTNT CD" ).append("\n"); 
		query.append("WHERE RS.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND RS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND RS.CNT_CD   = CD.CNT_CD(+)" ).append("\n"); 
		query.append("   AND RS.DSPO_CD  = CD.ATTR_CTNT3(+)" ).append("\n"); 
		query.append("   AND CD.CSTMS_DIV_ID IN ('CARGO_RLS_H_CD', 'CARGO_RLS_R_CD')" ).append("\n"); 
		query.append("   AND EXISTS (" ).append("\n"); 
		query.append("               SELECT 'X'" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_ADV_RSLT" ).append("\n"); 
		query.append("               WHERE RS.CNT_CD=CNT_CD" ).append("\n"); 
		query.append("                 AND RS.BL_NO = BL_NO" ).append("\n"); 
		query.append("                 AND DSPO_CD='1X'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("ORDER BY RS.CSTMS_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT RS.BL_NO" ).append("\n"); 
		query.append("      ,RS.CSTMS_SEQ" ).append("\n"); 
		query.append("      ,RS.DSPO_CD" ).append("\n"); 
		query.append("      ,TO_NUMBER(TO_CHAR(RS.ARR_DT, 'YYYYMMDDHH24MISS')) AS ARR_DT" ).append("\n"); 
		query.append("      ,DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_H_CD', 'H') AS HOLD_FLG" ).append("\n"); 
		query.append("      ,DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_R_CD', 'R') AS REMV_FLG" ).append("\n"); 
		query.append("      ,DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_H_CD', CD.ATTR_CTNT4) AS REMV_CD" ).append("\n"); 
		query.append("      ,RS.CNTR_QTY" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("      ,BKG_CSTMS_CD_CONV_CTNT CD" ).append("\n"); 
		query.append(" WHERE RS.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND RS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND RS.CNT_CD   = CD.CNT_CD(+)" ).append("\n"); 
		query.append("   AND RS.DSPO_CD  = CD.ATTR_CTNT3(+)" ).append("\n"); 
		query.append("   AND NVL(RS.RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND RS.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("   AND CD.CSTMS_DIV_ID IN ('CARGO_RLS_H_CD', 'CARGO_RLS_R_CD')" ).append("\n"); 
		query.append("   AND EXISTS (" ).append("\n"); 
		query.append("               SELECT 'X'" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_ADV_RSLT" ).append("\n"); 
		query.append("                WHERE RS.CNT_CD=CNT_CD" ).append("\n"); 
		query.append("                  AND RS.BL_NO = BL_NO" ).append("\n"); 
		query.append("                  AND DSPO_CD='1X'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("ORDER BY RS.CSTMS_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}