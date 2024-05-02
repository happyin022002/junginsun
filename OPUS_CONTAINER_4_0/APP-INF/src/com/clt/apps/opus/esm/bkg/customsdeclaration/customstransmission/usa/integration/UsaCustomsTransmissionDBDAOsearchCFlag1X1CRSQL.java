/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCFlag1X1CRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCFlag1X1CRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCFlag1X1C
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCFlag1X1CRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCFlag1X1CRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN HOLD_QTY = 0 AND REMV_QTY = 0 THEN 'Y'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("        END CFLAG" ).append("\n"); 
		query.append("  FROM (SELECT NVL(SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_H_CD', RS.CNTR_QTY)),0) HOLD_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(CD.CSTMS_DIV_ID, 'CARGO_RLS_R_CD', RS.CNTR_QTY)),0) REMV_QTY" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("              ,BKG_CSTMS_CD_CONV_CTNT CD" ).append("\n"); 
		query.append("         WHERE RS.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND RS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           AND RS.CNT_CD   = CD.CNT_CD(+)" ).append("\n"); 
		query.append("           AND RS.DSPO_CD  = CD.ATTR_CTNT3(+)" ).append("\n"); 
		query.append("           AND NVL(RS.RSND_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("           AND RS.BL_NVOCC_TP_CD = 'M'" ).append("\n"); 
		query.append("           AND CD.CSTMS_DIV_ID IN ('CARGO_RLS_H_CD', 'CARGO_RLS_R_CD')" ).append("\n"); 
		query.append("           AND RS.DSPO_CD <> '1X'" ).append("\n"); 
		query.append("        ORDER BY RS.CSTMS_SEQ" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}