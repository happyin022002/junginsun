/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchCntrforNewBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2013.01.23 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
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
		params.put("bkg_skd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      ,BKG_SKD_SEQ" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,SUM(CNTR_VOL_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("      ,MAX(PCK_TP_CD) PCK_TP_CD" ).append("\n"); 
		query.append("      ,SUM(PCK_QTY)" ).append("\n"); 
		query.append("      ,SUM(CNTR_WGT)" ).append("\n"); 
		query.append("      ,DECODE(NVL(MAX(WGT_UT_CD),'KGS'),'LBS','LBR','KGS','KGM',MAX(WGT_UT_CD) ) WGT_UT_CD" ).append("\n"); 
		query.append("      ,SUM(MEAS_QTY)" ).append("\n"); 
		query.append("      ,DECODE(NVL(MAX(MEAS_UT_CD),'CBM'),'CMF','FTQ','MTQ')" ).append("\n"); 
		query.append("      ,CNTR_PRT_FLG" ).append("\n"); 
		query.append("      ,MAX(CNTR_PRT_SEQ) CNTR_PRT_SEQ" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("(SELECT (SELECT MIN(BKG_NO)" ).append("\n"); 
		query.append("          FROM BKG_QUANTITY" ).append("\n"); 
		query.append("         WHERE BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("       ) BKG_NO ," ).append("\n"); 
		query.append("       @[bkg_skd_seq] BKG_SKD_SEQ ," ).append("\n"); 
		query.append("       NVL(BC.CNTR_NO,'T.B.N'|| rownum) CNTR_NO ," ).append("\n"); 
		query.append("       NVL(BC.CNTR_TPSZ_CD,Q.CNTR_TPSZ_CD) CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("       Q.OP_CNTR_QTY CNTR_VOL_QTY," ).append("\n"); 
		query.append("       MC.CNTR_TPSZ_ISO_CD ," ).append("\n"); 
		query.append("       NVL(BC.PCK_TP_CD,bl.PCK_TP_CD) PCK_TP_CD," ).append("\n"); 
		query.append("       NVL(BC.PCK_QTY,BL.PCK_QTY)  PCK_QTY," ).append("\n"); 
		query.append("       NVL(BC.CNTR_WGT,BL.ACT_WGT) CNTR_WGT," ).append("\n"); 
		query.append("       NVL(BC.WGT_UT_CD,BL.WGT_UT_CD) WGT_UT_CD  ," ).append("\n"); 
		query.append("       NVL(BC.MEAS_QTY,BL.MEAS_QTY) MEAS_QTY  ," ).append("\n"); 
		query.append("       NVL(BC.MEAS_UT_CD,BL.MEAS_UT_CD) MEAS_UT_CD ," ).append("\n"); 
		query.append("       CASE WHEN TRUNC(NVL(CNTR_VOL_QTY,OP_CNTR_QTY)) = NVL(CNTR_VOL_QTY,OP_CNTR_QTY) THEN 'N' ELSE 'Y' END  CNTR_PRT_FLG, " ).append("\n"); 
		query.append("       NVL(BC.CNTR_PRT_SEQ,'0') CNTR_PRT_SEQ" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER BC ," ).append("\n"); 
		query.append("       BKG_BL_DOC BL," ).append("\n"); 
		query.append("       BKG_QUANTITY Q," ).append("\n"); 
		query.append("       MDM_CNTR_TP_SZ MC" ).append("\n"); 
		query.append(" WHERE Q.BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("   AND MC.CNTR_TPSZ_CD=Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   AND Q.BKG_NO=BC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND Q.CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("   AND Q.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND Q.CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BKG_NO, BKG_SKD_SEQ, CNTR_NO, CNTR_TPSZ_CD, CNTR_TPSZ_ISO_CD, CNTR_PRT_FLG" ).append("\n"); 

	}
}