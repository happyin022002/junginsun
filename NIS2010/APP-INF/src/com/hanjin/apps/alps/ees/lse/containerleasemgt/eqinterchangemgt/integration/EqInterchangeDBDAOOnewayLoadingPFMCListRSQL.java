/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EqInterchangeDBDAOOnewayLoadingPFMCListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOOnewayLoadingPFMCListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 두기민 2016-04-08 Oneway Loading PFMC 조회
	  * </pre>
	  */
	public EqInterchangeDBDAOOnewayLoadingPFMCListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tos",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_dol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_dol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("froms",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOOnewayLoadingPFMCListRSQL").append("\n"); 
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
		query.append("SELECT * FROM" ).append("\n"); 
		query.append("(SELECT  BAT.CNTR_NO" ).append("\n"); 
		query.append("       ,BAT.CNTR_STS_SEQ" ).append("\n"); 
		query.append("       ,BAT.CNMV_YR" ).append("\n"); 
		query.append("       ,BAT.CNMV_ID_NO" ).append("\n"); 
		query.append("       ,BAT.AGMT_CTY_CD" ).append("\n"); 
		query.append("       ,BAT.AGMT_SEQ" ).append("\n"); 
		query.append("       ,BAT.BKG_NO" ).append("\n"); 
		query.append("       ,BAT.COST_ROUT_NO" ).append("\n"); 
		query.append("       ,BAT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,VEN.VNDR_ABBR_NM LESSOR" ).append("\n"); 
		query.append("       ,BAT.REF_NO" ).append("\n"); 
		query.append("       ,BAT.LSTM_CD" ).append("\n"); 
		query.append("       ,BAT.PRE_MVMT_STS_CD||'-'||BAT.MVMT_STS_CD MVMT" ).append("\n"); 
		query.append("       ,TO_CHAR(BAT.PRE_CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI') PRE_EVENTDATE" ).append("\n"); 
		query.append("       ,TO_CHAR(BAT.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI') CNMV_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(BAT.ONH_DT, 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(BAT.CNMV_EVNT_DT,'YYYYMMDDHH24MISS') CNTR_MV_DT" ).append("\n"); 
		query.append("       ,BAT.ONH_YD_CD ONH_YD" ).append("\n"); 
		query.append("       ,BAT.ONH_FREE_DYS FREE_DYS" ).append("\n"); 
		query.append("       ,NVL(BAT.USD_DYS,'0') USING_DAYS" ).append("\n"); 
		query.append("       ,BAT.SHPR_NM SHPR" ).append("\n"); 
		query.append("       ,BAT.CNEE_NM CNEE" ).append("\n"); 
		query.append("       ,BAT.OB_SLS_OFC_CD SLS_OFC" ).append("\n"); 
		query.append("       ,BAT.POR_CD POR" ).append("\n"); 
		query.append("       ,BAT.POL_CD POL" ).append("\n"); 
		query.append("       ,BAT.POD_CD POD" ).append("\n"); 
		query.append("       ,BAT.DEL_CD DEL" ).append("\n"); 
		query.append("       ,DECODE(LOLF.DEL_DOL_YN,NULL,BAT.DEL_DOL_FLG,LOLF.DEL_DOL_YN) DEL_DOL" ).append("\n"); 
		query.append("       ,BAT.POR_DOL_FLG POR_DOL" ).append("\n"); 
		query.append("       ,TO_CHAR(BAT.POL_ETD_DT, 'YYYY-MM-DD') ETD_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(BAT.POD_ETA_DT, 'YYYY-MM-DD') ETA_DT" ).append("\n"); 
		query.append("       ,BAT.TRD_CD TRD" ).append("\n"); 
		query.append("       ,BAT.RLANE_CD R_LANE" ).append("\n"); 
		query.append("       ,BAT.VVD" ).append("\n"); 
		query.append("       ,BAT.LON" ).append("\n"); 
		query.append("       ,BAT.PUC" ).append("\n"); 
		query.append("       ,BAT.PCR" ).append("\n"); 
		query.append("       ,BAT.LOF" ).append("\n"); 
		query.append("       ,BAT.DOC" ).append("\n"); 
		query.append("       ,BAT.DCR" ).append("\n"); 
		query.append("       ,BAT.ORG_YD_CD" ).append("\n"); 
		query.append("       ,BAT.MVMT_STS_CD" ).append("\n"); 
		query.append("       ,BAT.CUST_TP_CD CUST_TP" ).append("\n"); 
		query.append("       ,BAT.CUST_GRP_ID G_CUST_CD" ).append("\n"); 
		query.append("       ,BAT.CUST_GRP_NM G_CUST_NM" ).append("\n"); 
		query.append("       ,BAT.CNTR_DISP_FLG DISP_FLG" ).append("\n"); 
		query.append("       ,BAT.LODG_RCC_CD RCC_CD" ).append("\n"); 
		query.append("       ,BAT.LODG_LCC_CD LCC_CD" ).append("\n"); 
		query.append("       ,BAT.LODG_ECC_CD ECC_CD" ).append("\n"); 
		query.append("       ,BAT.LODG_SCC_CD SCC_CD" ).append("\n"); 
		query.append("       ,DECODE(MBEDW.CNTR_NO,NULL,'N','Y') MST_IF" ).append("\n"); 
		query.append("       ,DECODE(BAT.RFA_NO,NULL,BAT.SC_NO,BAT.RFA_NO) SC_RFA_NO" ).append("\n"); 
		query.append("       ,DECODE(BAT.RFA_NO,NULL,DECODE(BAT.CUST_SEQ,NULL,BAT.REAL_CUST_CNT_CD||RPAD('0',6,BAT.REAL_CUST_SEQ),BAT.CUST_CNT_CD||RPAD('0',6,BAT.CUST_SEQ)),BAT.CTRT_CUST_CNT_CD||RPAD('0',6,BAT.CTRT_CUST_SEQ)) CUST_NO" ).append("\n"); 
		query.append("       ,DECODE(BAT.RFA_NO,NULL,DECODE(BAT.CTRT_PTY_NM,NULL,BAT.REAL_CUST_NM,BAT.CTRT_PTY_NM),BAT.CUST_LGL_ENG_NM) CUST_NM" ).append("\n"); 
		query.append("       ,(SELECT /*+ INDEX_DESC ( MM XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("              MM.MVMT_STS_CD" ).append("\n"); 
		query.append("         FROM CTM_MOVEMENT MM" ).append("\n"); 
		query.append("        WHERE MM.CNTR_NO = BAT.CNTR_NO" ).append("\n"); 
		query.append("          AND MM.CTRT_SEQ = BAT.AGMT_SEQ  " ).append("\n"); 
		query.append("          AND ROWNUM = 1) AS CRR_MVMT_STS_CD" ).append("\n"); 
		query.append("      ,(SELECT /*+ INDEX_DESC ( MM XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("              TO_CHAR(MM.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("         FROM CTM_MOVEMENT MM" ).append("\n"); 
		query.append("        WHERE MM.CNTR_NO = BAT.CNTR_NO" ).append("\n"); 
		query.append("          AND MM.CTRT_SEQ = BAT.AGMT_SEQ  " ).append("\n"); 
		query.append("          AND ROWNUM = 1) AS CRR_CNMV_EVNT_DT  " ).append("\n"); 
		query.append("      ,(SELECT /*+ INDEX_DESC ( MM XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("              MM.ORG_YD_CD" ).append("\n"); 
		query.append("         FROM CTM_MOVEMENT MM" ).append("\n"); 
		query.append("        WHERE MM.CNTR_NO = BAT.CNTR_NO" ).append("\n"); 
		query.append("          AND MM.CTRT_SEQ = BAT.AGMT_SEQ  " ).append("\n"); 
		query.append("          AND ROWNUM = 1)  AS CRR_ORG_YD_CD  " ).append("\n"); 
		query.append("  FROM LSE_ONEWAY_LODG_PERF_BAT BAT, MDM_VENDOR VEN, LSE_ONEWAY_LOAD_PFMC LOLF, MAS_OFFH_BKG_LIST MBEDW" ).append("\n"); 
		query.append(" WHERE BAT.VNDR_SEQ = VEN.VNDR_SEQ" ).append("\n"); 
		query.append("   AND BAT.CNTR_NO = LOLF.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND BAT.AGMT_SEQ = LOLF.AGMT_SEQ(+)" ).append("\n"); 
		query.append("   AND BAT.LSTM_CD = LOLF.LSTM_CD(+)" ).append("\n"); 
		query.append("   AND BAT.CNTR_TPSZ_CD = LOLF.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("   AND BAT.BKG_NO = LOLF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BAT.CNMV_EVNT_DT= LOLF.CNMV_DT(+)" ).append("\n"); 
		query.append("   AND BAT.BKG_NO = MBEDW.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BAT.CNTR_NO = MBEDW.CNTR_NO(+)" ).append("\n"); 
		query.append("#if (${period} == 'D')" ).append("\n"); 
		query.append("    AND BAT.CNMV_EVNT_DT BETWEEN  TO_DATE(@[froms], 'YYYYMMDD') + .0 AND TO_DATE(@[tos], 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#elseif(${period} == 'M')" ).append("\n"); 
		query.append("    AND BAT.CNMV_EVNT_DT BETWEEN  TO_DATE(@[froms], 'YYYYMM') + .0 AND TO_DATE(@[tos], 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND BAT.CNMV_EVNT_DT	BETWEEN	( " ).append("\n"); 
		query.append("							SELECT TO_DATE(K.WK_ST_DT,'YYYYMMDD') + .0" ).append("\n"); 
		query.append("							FROM   EQR_WK_PRD K" ).append("\n"); 
		query.append("							WHERE  K.PLN_YR||K.PLN_WK = @[froms]" ).append("\n"); 
		query.append("							)	" ).append("\n"); 
		query.append("			AND				( " ).append("\n"); 
		query.append("							 SELECT TO_DATE(K.WK_END_DT,'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("							 FROM   EQR_WK_PRD K" ).append("\n"); 
		query.append("							 WHERE  K.PLN_YR||K.PLN_WK = @[tos]" ).append("\n"); 
		query.append("							) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mvmt} != '')" ).append("\n"); 
		query.append("    AND SUBSTR(@[mvmt],3,2) = BAT.PRE_MVMT_STS_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd} != '')" ).append("\n"); 
		query.append("    AND BAT.TRD_CD = @[trd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dpsl} != '')" ).append("\n"); 
		query.append("    AND BAT.CNTR_DISP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_tp} == 'OFC')" ).append("\n"); 
		query.append("    AND BAT.OB_SLS_OFC_CD = @[loc_to]" ).append("\n"); 
		query.append("#elseif(${loc_tp} == 'RCC')" ).append("\n"); 
		query.append("    AND BAT.LODG_RCC_CD = @[loc_to]" ).append("\n"); 
		query.append("#elseif(${loc_tp} == 'LCC')" ).append("\n"); 
		query.append("    AND BAT.LODG_LCC_CD = @[loc_to]" ).append("\n"); 
		query.append("#elseif(${loc_tp} == 'ECC')" ).append("\n"); 
		query.append("    AND BAT.LODG_ECC_CD = @[loc_to]" ).append("\n"); 
		query.append("#elseif(${loc_tp} == 'SCC')" ).append("\n"); 
		query.append("    AND BAT.LODG_SCC_CD = @[loc_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_dol} != '')" ).append("\n"); 
		query.append(" AND BAT.POR_DOL_FLG = @[por_dol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_seq} != '')" ).append("\n"); 
		query.append("AND BAT.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("   	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("   		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("   			'$key'," ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			'$key'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${del_dol} != '')" ).append("\n"); 
		query.append("  AND DEL_DOL = @[del_dol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_flg} != '')" ).append("\n"); 
		query.append("  AND MST_IF = @[if_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}