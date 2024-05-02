/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * flat file Stowage 정보를 가져온다.
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL").append("\n"); 
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
		query.append("--PKUP_NAME - 공란" ).append("\n"); 
		query.append("--STWG_REQ        " ).append("\n"); 
		query.append("--STWG_REMARK          " ).append("\n"); 
		query.append("--BLKSTWG" ).append("\n"); 
		query.append("--RD_IND" ).append("\n"); 
		query.append("--MT_IND" ).append("\n"); 
		query.append("--SOC_IND" ).append("\n"); 
		query.append("--RF_RRE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT JB.SNACCS_TML_EDI_STWG_CD  STWG_REQ " ).append("\n"); 
		query.append(",UPPER(JB.XTER_RMK) 			  STWG_REMARK" ).append("\n"); 
		query.append("--,BLCK_STWG_CD 				  BLKSTWG    --AS-IS" ).append("\n"); 
		query.append("--TO-BE" ).append("\n"); 
		query.append(",CASE WHEN C.CRR_CD='SML' THEN JB.BLCK_STWG_CD" ).append("\n"); 
		query.append(" ELSE (" ).append("\n"); 
		query.append(" SELECT ATTR_CTNT3   --SJA block Stowage Code" ).append("\n"); 
		query.append("FROM BKG_VVD V" ).append("\n"); 
		query.append("     ,VSK_VSL_SKD VS " ).append("\n"); 
		query.append("     ,BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("     ,BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE V.BKG_NO = JB.BKG_NO" ).append("\n"); 
		query.append("AND   VS.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND   VS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND   VS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   H.HRD_CDG_ID='JP_TML_EDI_SJA_BS_CD'" ).append("\n"); 
		query.append("AND   H.ATTR_CTNT1=VS.ACT_CRR_CD" ).append("\n"); 
		query.append("AND   H.ATTR_CTNT2=DECODE(VS.ACT_CRR_CD,'NYK','ALL',VS.VSL_SLAN_CD)" ).append("\n"); 
		query.append("AND   B.BKG_NO=V.BKG_NO" ).append("\n"); 
		query.append("AND   ( (SUBSTR(B.BKG_NO,1,2) IN ('US','CA','MX') AND   H.ATTR_CTNT4=B.POD_CD)" ).append("\n"); 
		query.append("     OR (VS.VSL_SLAN_CD='KPS' AND H.ATTR_CTNT2=VS.VSL_SLAN_CD AND H.ATTR_CTNT4='ALL') )" ).append("\n"); 
		query.append(" ) END BLKSTWG" ).append("\n"); 
		query.append("--,JB.DRY_CGO_FLG					RD_IND" ).append("\n"); 
		query.append(", ( SELECT CASE WHEN SUBSTR(CNTR_TPSZ_CD,1,1) = 'R' AND SUBSTR(EQ_SUBST_CNTR_TPSZ_CD,1,1) = 'D' AND OP_CNTR_QTY = EQ_SUBST_CGO_QTY THEN 'Y'" ).append("\n"); 
		query.append("                ELSE 'N' END DRY_CGO_FLG" ).append("\n"); 
		query.append("      FROM BKG_QUANTITY" ).append("\n"); 
		query.append("     WHERE BKG_NO = JB.BKG_NO" ).append("\n"); 
		query.append("       AND CNTR_TPSZ_CD = @[cntr_tpsz_cd] ) RD_IND" ).append("\n"); 
		query.append(",JB.MCNTR_FLG					MT_IND" ).append("\n"); 
		query.append(",JB.SOC_FLG						SOC_IND" ).append("\n"); 
		query.append(",JB.RF_CNTR_PRE_CLNG_FLG		RF_RRE" ).append("\n"); 
		query.append("FROM BKG_TML_EDI_JP_BL JB, MDM_VSL_CNTR C" ).append("\n"); 
		query.append("WHERE JB.BKG_NO=@[bkg_no]  " ).append("\n"); 
		query.append("AND JB.BKG_SKD_SEQ=0" ).append("\n"); 
		query.append("AND C.VSL_CD = JB.VSL_CD" ).append("\n"); 

	}
}