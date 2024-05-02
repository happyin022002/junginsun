/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOsearchTransCmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.05
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.05 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOsearchTransCmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOsearchTransCmRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOsearchTransCmRSQL").append("\n"); 
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
		query.append("SELECT LPAD(ROWNUM, 4, '0') AS CM_SEQ" ).append("\n"); 
		query.append("      ,CM.PCK_QTY           AS CM_PKG_NO" ).append("\n"); 
		query.append("      ,NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_PCK_TP_CONV AA" ).append("\n"); 
		query.append("             WHERE AA.CNT_CD  = 'EU'" ).append("\n"); 
		query.append("               AND AA.RCVR_ID = 'EU'" ).append("\n"); 
		query.append("               AND AA.PCK_TP_CD = CM.PCK_TP_CD" ).append("\n"); 
		query.append("           ),CM.PCK_TP_CD)  AS CM_PKG_CD" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(CM.CNTR_MF_DESC, CHR(13)||CHR(10),' '), CHR(13), ' '), CHR(10), ' ') AS CM_DESC" ).append("\n"); 
		query.append("      ,CM.CNTR_MF_WGT       AS CM_WGT" ).append("\n"); 
		query.append("      ,CM.WGT_UT_CD         AS CM_WGT_U" ).append("\n"); 
		query.append("      ,CM.CNTR_NO           AS CM_CNTR_NO" ).append("\n"); 
		query.append("      ,DECODE( CM.DECL_FLG, 'Y', 'T1', 'C' ) AS T1_IND " ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ANR_CMDT CM" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ANR_BL   BL" ).append("\n"); 
		query.append(" WHERE BL.VSL_CD     = CM.VSL_CD" ).append("\n"); 
		query.append("   AND BL.SKD_VOY_NO = CM.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND BL.SKD_DIR_CD = CM.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND BL.BKG_NO     = CM.BKG_NO" ).append("\n"); 
		query.append("   AND BL.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("   AND BL.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND BL.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND BL.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 

	}
}