/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchCntrforNewBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchCntrforNewBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrforNewBkgInfo
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchCntrforNewBkgInfoRSQL(){
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_skd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchCntrforNewBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO, " ).append("\n"); 
		query.append("       BKG_SKD_SEQ," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       SUM(CNTR_VOL_QTY) AS CNTR_VOL_QTY," ).append("\n"); 
		query.append("       CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("       MAX(PCK_TP_CD) AS PCK_TP_CD," ).append("\n"); 
		query.append("       SUM(PCK_QTY)," ).append("\n"); 
		query.append("       SUM(CNTR_WGT)," ).append("\n"); 
		query.append("       DECODE(NVL(MAX(WGT_UT_CD), 'KGS'), 'LBS', 'LBR', 'KGS', 'KGM', MAX(WGT_UT_CD)) AS WGT_UT_CD," ).append("\n"); 
		query.append("       SUM(MEAS_QTY)," ).append("\n"); 
		query.append("       DECODE(NVL(MAX(MEAS_UT_CD), 'CBM'), 'CMF', 'FTQ', 'MTQ')," ).append("\n"); 
		query.append("       CNTR_PRT_FLG," ).append("\n"); 
		query.append("       MAX(CNTR_PRT_SEQ) AS CNTR_PRT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("       (SELECT (SELECT MIN(M_BQ.BKG_NO)" ).append("\n"); 
		query.append("                  FROM BKG_VVD M_BV," ).append("\n"); 
		query.append("                       BKG_QUANTITY M_BQ" ).append("\n"); 
		query.append("                 WHERE M_BV.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND M_BV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND M_BV.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND M_BV.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                   AND M_BQ.BKG_NO = M_BV.BKG_NO" ).append("\n"); 
		query.append("                   AND M_BQ.BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%') AS BKG_NO," ).append("\n"); 
		query.append("               @[bkg_skd_seq] AS BKG_SKD_SEQ," ).append("\n"); 
		query.append("               NVL(BC.CNTR_NO, 'T.B.N'|| ROWNUM) AS CNTR_NO," ).append("\n"); 
		query.append("               NVL(BC.CNTR_TPSZ_CD, Q.CNTR_TPSZ_CD) AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               Q.OP_CNTR_QTY AS CNTR_VOL_QTY," ).append("\n"); 
		query.append("               MC.CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("               NVL(BC.PCK_TP_CD, BL.PCK_TP_CD) AS PCK_TP_CD," ).append("\n"); 
		query.append("               NVL(BC.PCK_QTY, BL.PCK_QTY) AS PCK_QTY," ).append("\n"); 
		query.append("               NVL(BC.CNTR_WGT, BL.ACT_WGT) AS CNTR_WGT," ).append("\n"); 
		query.append("               NVL(BC.WGT_UT_CD, BL.WGT_UT_CD) AS WGT_UT_CD," ).append("\n"); 
		query.append("               NVL(BC.MEAS_QTY, BL.MEAS_QTY) AS MEAS_QTY," ).append("\n"); 
		query.append("               NVL(BC.MEAS_UT_CD, BL.MEAS_UT_CD) AS MEAS_UT_CD," ).append("\n"); 
		query.append("               'N' AS CNTR_PRT_FLG," ).append("\n"); 
		query.append("               NVL(BC.CNTR_PRT_SEQ, '0') AS CNTR_PRT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER BC," ).append("\n"); 
		query.append("               BKG_BL_DOC BL," ).append("\n"); 
		query.append("               BKG_VVD BV," ).append("\n"); 
		query.append("               BKG_QUANTITY Q," ).append("\n"); 
		query.append("               MDM_CNTR_TP_SZ MC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE Q.BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("           AND MC.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           AND Q.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND Q.CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("           AND Q.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("           AND BV.VSL_Cd = @[vsl_cd]" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND BV.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("           AND BL.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("           AND Q.CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("           AND Q.CNTR_TPSZ_CD NOT LIKE 'Q%')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY BKG_NO," ).append("\n"); 
		query.append("       BKG_SKD_SEQ," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("       CNTR_PRT_FLG" ).append("\n"); 

	}
}