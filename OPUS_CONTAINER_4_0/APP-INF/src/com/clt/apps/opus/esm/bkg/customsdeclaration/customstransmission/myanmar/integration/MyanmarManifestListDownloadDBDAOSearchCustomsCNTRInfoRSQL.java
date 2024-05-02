/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MyanmarManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomsCNTRInfo
	  * </pre>
	  */
	public MyanmarManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration").append("\n"); 
		query.append("FileName : MyanmarManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL").append("\n"); 
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
		query.append("SELECT BC.CNTR_NO     CNTR_NBR" ).append("\n"); 
		query.append(",(SELECT ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT H WHERE BC.CNTR_TPSZ_CD = H.ATTR_CTNT1 AND H.HRD_CDG_ID = 'MYANMAR_CNTR_CD')   CNTR_TYPE    " ).append("\n"); 
		query.append(",DECODE(BC.CNMV_STS_CD,'TS','6',DECODE(CM.OB_CNTR_FLG,'Y','2','3')) CNTR_STATUS         -- 2-Export 3-Import 6-Transhipment" ).append("\n"); 
		query.append(",DECODE(BC.CNTR_PRT_FLG,'N','5','Y','4') CNTR_FM_IND                                    -- 4-Empty  5-Full" ).append("\n"); 
		query.append(",BC.CNTR_WGT    CNTR_G_WGT" ).append("\n"); 
		query.append(",BC.WGT_UT_CD   CNTR_G_WGT_UNIT" ).append("\n"); 
		query.append(",MC.CNTR_TPSZ_TARE_WGT  CNTR_T_WGT" ).append("\n"); 
		query.append(",CASE WHEN MC.CNTR_TPSZ_TARE_WGT IS NOT NULL THEN 'KGM' ELSE '' END   CNTR_T_WGT_UNIT     --TARE WGT UNIT 기준 문의!!" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("	FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   WHERE INTG_CD_ID = 'CD00764'" ).append("\n"); 
		query.append("	 AND (APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("	 AND INTG_CD_VAL_CTNT = BC.RCV_TERM_CD)" ).append("\n"); 
		query.append("			||'/'||" ).append("\n"); 
		query.append("(SELECT  INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("   FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("  WHERE  INTG_CD_ID = 'CD00765'" ).append("\n"); 
		query.append("    AND  (APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("    AND  INTG_CD_VAL_CTNT = BC.DE_TERM_CD)	CNTR_MVMT_TYPE	" ).append("\n"); 
		query.append(",BC.PCK_QTY" ).append("\n"); 
		query.append(",(SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = BC.PCK_TP_CD) PCK_TP_CD" ).append("\n"); 
		query.append(",DECODE(BC.SOC_FLG,'Y','SOC','COC')	CNTR_EQ_SUP_CD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC, CTM_MOVEMENT CM, MDM_CNTR_TP_SZ MC" ).append("\n"); 
		query.append("WHERE BC.BKG_NO = @[bkg_no]     " ).append("\n"); 
		query.append("AND   BC.CNTR_NO = @[cntr_no]   " ).append("\n"); 
		query.append("AND   CM.CNTR_NO(+) = BC.CNTR_NO" ).append("\n"); 
		query.append("AND   CM.CNMV_YR(+) = BC.CNMV_YR" ).append("\n"); 
		query.append("AND   CM.CNMV_ID_NO(+) = BC.CNMV_ID_NO" ).append("\n"); 
		query.append("AND   CM.CNMV_CYC_NO(+) = BC.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND   MC.CNTR_TPSZ_CD(+) = BC.CNTR_TPSZ_CD" ).append("\n"); 

	}
}