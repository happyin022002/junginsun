/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOSearchCntrMtyBkgContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Bkg 의 Container List를 조회(BKG_CONTAINER 추출)
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchCntrMtyBkgContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgContainerListRSQL").append("\n"); 
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
		query.append("SELECT MC.CNTR_NO" ).append("\n"); 
		query.append("      ,MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,MC.LSTM_CD" ).append("\n"); 
		query.append("      ,CM.MVMT_STS_CD  --CNMV_STS_CD," ).append("\n"); 
		query.append("      ,MC.VNDR_ABBR_NM " ).append("\n"); 
		query.append("      ,MC.CNTR_USE_CO_CD " ).append("\n"); 
		query.append("      ,MC.DMG_FLG" ).append("\n"); 
		query.append("      ,MC.CNTR_HNGR_RCK_CD -- CNTR_HNGR_RCK_FLG," ).append("\n"); 
		query.append("      ,MC.CNTR_HNGR_BAR_ATCH_KNT -- CNTR_HNGR_BAR_FLG," ).append("\n"); 
		query.append("      ,MC.RFUB_FLG" ).append("\n"); 
		query.append("      ,MC.DISP_FLG" ).append("\n"); 
		query.append("      ,MC.PLST_FLR_FLG " ).append("\n"); 
		query.append("      ,MC.IMDT_EXT_FLG" ).append("\n"); 
		query.append("      ,MC.RF_TP_CD_C " ).append("\n"); 
		query.append("      ,MC.RF_TP_CD_H" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT  CM" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT MC.CNTR_NO," ).append("\n"); 
		query.append("               MC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               MC.LSTM_CD," ).append("\n"); 
		query.append("               MC.CNMV_STS_CD," ).append("\n"); 
		query.append("               MV.VNDR_ABBR_NM ," ).append("\n"); 
		query.append("               DECODE(MC.CNTR_USE_CO_CD,'H','SML','SEN') CNTR_USE_CO_CD ," ).append("\n"); 
		query.append("               MC.DMG_FLG," ).append("\n"); 
		query.append("               MC.CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("               MC.CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("               MC.RFUB_FLG," ).append("\n"); 
		query.append("               MC.DISP_FLG," ).append("\n"); 
		query.append("               MC.PLST_FLR_FLG ," ).append("\n"); 
		query.append("               MC.IMDT_EXT_FLG," ).append("\n"); 
		query.append("               DECODE(MC.RF_TP_CD, 'C', 'Y') RF_TP_CD_C ," ).append("\n"); 
		query.append("               DECODE(MC.RF_TP_CD, 'H', 'Y') RF_TP_CD_H ," ).append("\n"); 
		query.append("               MC.CRNT_YD_CD" ).append("\n"); 
		query.append("        FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("            ,MDM_VENDOR    MV" ).append("\n"); 
		query.append("            ,BKG_CONTAINER BC" ).append("\n"); 
		query.append("        WHERE MC.VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("        AND   MC.ACIAC_DIV_CD <> 'I'  --Active한 것만 가져온다" ).append("\n"); 
		query.append("        AND   BC.BKG_NO = @[bkgno]" ).append("\n"); 
		query.append("        AND   MC.CNTR_NO = BC.CNTR_NO             " ).append("\n"); 
		query.append("    ) MC" ).append("\n"); 
		query.append("WHERE CM.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("AND  (CM.CNMV_YR, CM.CNMV_SEQ, CM.CNMV_SPLIT_NO) = (" ).append("\n"); 
		query.append("                                                      SELECT /*+index_desc(a XUK1CTM_MOVEMENT) */ " ).append("\n"); 
		query.append("                                                             CNMV_YR" ).append("\n"); 
		query.append("                                                            ,CNMV_SEQ" ).append("\n"); 
		query.append("                                                            ,CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                                                      FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("                                                      WHERE A.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("                                                      AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 

	}
}