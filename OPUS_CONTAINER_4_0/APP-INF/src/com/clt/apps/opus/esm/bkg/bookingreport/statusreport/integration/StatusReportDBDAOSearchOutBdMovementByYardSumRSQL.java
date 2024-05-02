/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOSearchOutBdMovementByYardSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchOutBdMovementByYardSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outbound Container Movement Status by Yard[ESM_BKG_0619]
	  * </pre>
	  */
	public StatusReportDBDAOSearchOutBdMovementByYardSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_bkg_rqst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_trns_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_1_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_1_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchOutBdMovementByYardSumRSQL").append("\n"); 
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
		query.append("SELECT ORG_YD_CD " ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OP' AND CNTR_TPSZ_CD_MV = 'D2' THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OP_DR2" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OP' AND CNTR_TPSZ_CD_MV != 'D2' AND INSTR(CNTR_TPSZ_CD_MV,'D') > 0  THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OP_DR4" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OP' AND CNTR_TPSZ_CD_MV = 'R2' THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OP_RF2" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OP' AND CNTR_TPSZ_CD_MV != 'R2' AND INSTR(CNTR_TPSZ_CD_MV,'R') > 0  THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OP_RF4" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OC' AND CNTR_TPSZ_CD_MV = 'D2' THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OC_DR2" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OC' AND CNTR_TPSZ_CD_MV != 'D2' AND INSTR(CNTR_TPSZ_CD_MV,'D') > 0  THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OC_DR4" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OC' AND CNTR_TPSZ_CD_MV = 'R2' THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OC_RF2" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OC' AND CNTR_TPSZ_CD_MV != 'R2' AND INSTR(CNTR_TPSZ_CD_MV,'R') > 0  THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OC_RF4" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN (CNMV_STS_CD = 'EN' OR CNMV_STS_CD = 'TN') AND CNTR_TPSZ_CD_MV = 'D2' THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) ETN_DR2" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN (CNMV_STS_CD = 'EN' OR CNMV_STS_CD = 'TN') AND CNTR_TPSZ_CD_MV != 'D2' AND INSTR(CNTR_TPSZ_CD_MV,'D') > 0  THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) ETN_DR4" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN (CNMV_STS_CD = 'EN' OR CNMV_STS_CD = 'TN') AND CNTR_TPSZ_CD_MV = 'R2' THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) ETN_RF2" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN (CNMV_STS_CD = 'EN' OR CNMV_STS_CD = 'TN') AND CNTR_TPSZ_CD_MV != 'R2' AND INSTR(CNTR_TPSZ_CD_MV,'R') > 0  THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) ETN_RF4" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'MT' AND CNTR_TPSZ_CD_MV = 'D2' THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) MT_DR2" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'MT' AND CNTR_TPSZ_CD_MV != 'D2' AND INSTR(CNTR_TPSZ_CD_MV,'D') > 0  THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) MT_DR4" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'MT' AND CNTR_TPSZ_CD_MV = 'R2' THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) MT_RF2" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'MT' AND CNTR_TPSZ_CD_MV != 'R2' AND INSTR(CNTR_TPSZ_CD_MV,'R') > 0  THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) MT_RF4" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OT' AND CNTR_TPSZ_CD_MV = 'D2' THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OT_DR2" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OT' AND CNTR_TPSZ_CD_MV != 'D2' AND INSTR(CNTR_TPSZ_CD_MV,'D') > 0  THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OT_DR4" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OT' AND CNTR_TPSZ_CD_MV = 'R2' THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OT_RF2" ).append("\n"); 
		query.append("      ,SUM(CASE" ).append("\n"); 
		query.append("           WHEN CNMV_STS_CD = 'OT' AND CNTR_TPSZ_CD_MV != 'R2' AND INSTR(CNTR_TPSZ_CD_MV,'R') > 0  THEN" ).append("\n"); 
		query.append("            CNTR_VOL_QTY" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            0" ).append("\n"); 
		query.append("           END) OT_RF4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   (SELECT DISTINCT VB.TRUNK_VVD" ).append("\n"); 
		query.append("                       ,VB.BKG_NO" ).append("\n"); 
		query.append("                       ,VB.BKG_STS_CD" ).append("\n"); 
		query.append("                       ,VB.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                       ,VB.POR_CD" ).append("\n"); 
		query.append("                       ,VB.POD_CD" ).append("\n"); 
		query.append("                       ,VB.POL_CD" ).append("\n"); 
		query.append("                       ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       ,A.OP_CNTR_QTY" ).append("\n"); 
		query.append("                       ,B.RCV_TERM_CD" ).append("\n"); 
		query.append("                       ,B.DE_TERM_CD" ).append("\n"); 
		query.append("                       ,B.CNTR_NO" ).append("\n"); 
		query.append("                       ,B.CNTR_TPSZ_CD CNTR_TPSZ_CD_MV" ).append("\n"); 
		query.append("                       ,B.EQ_SUBST_TPSZ_CD" ).append("\n"); 
		query.append("                       ,B.ADV_SHTG_CD" ).append("\n"); 
		query.append("					   ,B.CNTR_VOL_QTY" ).append("\n"); 
		query.append("                       ,CASE" ).append("\n"); 
		query.append("                        WHEN (DECODE(BK.BKG_STS_CD,'X',''," ).append("\n"); 
		query.append("				                DECODE((SELECT COP.COP_STS_CD FROM SCE_COP_HDR COP WHERE COP.BKG_NO = B.BKG_NO AND COP.CNTR_NO = B.CNTR_NO AND COP.COP_STS_CD <> 'X'),'F','MT'," ).append("\n"); 
		query.append("					                (SELECT MST.CNMV_STS_CD FROM MST_CONTAINER MST WHERE MST.CNTR_NO = B.CNTR_NO)))) IN ('OP', 'OC', 'EN', 'TN', 'MT') THEN" ).append("\n"); 
		query.append("                         (DECODE(BK.BKG_STS_CD,'X',''," ).append("\n"); 
		query.append("				                DECODE((SELECT COP.COP_STS_CD FROM SCE_COP_HDR COP WHERE COP.BKG_NO = B.BKG_NO AND COP.CNTR_NO = B.CNTR_NO AND COP.COP_STS_CD <> 'X'),'F','MT'," ).append("\n"); 
		query.append("					                (SELECT MST.CNMV_STS_CD FROM MST_CONTAINER MST WHERE MST.CNTR_NO = B.CNTR_NO))))" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                         'OT'" ).append("\n"); 
		query.append("                        END CNMV_STS_CD" ).append("\n"); 
		query.append("                       ,B.ORG_YD_CD" ).append("\n"); 
		query.append("        FROM   BKG_WORK_V VB" ).append("\n"); 
		query.append("        ,      BKG_QUANTITY A" ).append("\n"); 
		query.append("        ,      VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("        ,      BKG_CONTAINER B" ).append("\n"); 
		query.append("        ,      BKG_BOOKING BK" ).append("\n"); 
		query.append("        ,      CTM_MOVEMENT MOVE" ).append("\n"); 
		query.append("        ,      SCE_CLM SC" ).append("\n"); 
		query.append("        WHERE  VB.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("        AND    V.VSL_CD(+) = VB.KEY_VSL_CD " ).append("\n"); 
		query.append("        AND    V.SKD_VOY_NO(+) = VB.KEY_SKD_VOY_NO " ).append("\n"); 
		query.append("        AND    V.SKD_DIR_CD(+) = VB.KEY_SKD_DIR_CD " ).append("\n"); 
		query.append("        AND    (DECODE(VB.PRE_1_POL_CD, NULL, VB.TRUNK_POL, VB.PRE_1_POL_CD) = V.VPS_PORT_CD(+)) " ).append("\n"); 
		query.append("        AND    VB.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("        AND    B.CNTR_NO = MOVE.CNTR_NO(+) " ).append("\n"); 
		query.append("        AND    B.CNMV_YR = MOVE.CNMV_YR(+) " ).append("\n"); 
		query.append("        AND    B.CNMV_ID_NO = MOVE.CNMV_ID_NO(+) " ).append("\n"); 
		query.append("        AND    A.BKG_NO = B.BKG_NO(+) " ).append("\n"); 
		query.append("        AND    A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD(+) " ).append("\n"); 
		query.append("        AND    B.CNTR_NO = SC.CNTR_NO(+) " ).append("\n"); 
		query.append("        AND    B.CNMV_YR = SC.CNMV_YR(+) " ).append("\n"); 
		query.append("        AND    B.CNMV_ID_NO = SC.CNMV_ID_NO(+) " ).append("\n"); 
		query.append("        AND    B.CNMV_CYC_NO = SC.CLM_SEQ(+) " ).append("\n"); 
		query.append("        AND    (VB.BKG_STS_CD = 'F' OR VB.BKG_STS_CD = 'W' OR VB.BKG_STS_CD = 'A') " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("AND   VB.KEY_VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND   VB.KEY_SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND   VB.KEY_SKD_DIR_CD =  SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_inc_sub} == 'Y') " ).append("\n"); 
		query.append("		AND VB.BKG_OFC_CD IN (" ).append("\n"); 
		query.append("      		SELECT OFC_CD  " ).append("\n"); 
		query.append("      		FROM   MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("      		START WITH MO.OFC_CD = NVL(@[bkg_ofc_cd],VB.BKG_OFC_CD)" ).append("\n"); 
		query.append("      		CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("		AND   VB.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_dt_fr} != '' || ${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("AND VB.BKG_CRE_DT BETWEEN TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD') AND TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${bkg_dt_fr} != '') " ).append("\n"); 
		query.append("AND VB.BKG_CRE_DT <= TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${bkg_dt_to} != '') " ).append("\n"); 
		query.append("AND VB.BKG_CRE_DT >= TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("AND VB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND  VB.KEY_POL_CD  LIKE RTRIM(@[pol_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("AND  VB.POR_CD LIKE RTRIM(@[por_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rcv_term_cd} != '') " ).append("\n"); 
		query.append("AND B.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${de_term_cd} != '') " ).append("\n"); 
		query.append("AND VB.DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_yd_cd} != '') " ).append("\n"); 
		query.append("AND B.ORG_YD_CD LIKE  @[org_yd_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chk_lt_type} == 'L') " ).append("\n"); 
		query.append("AND  VB.KEY_POL_CD = VB.POL_CD	--L/T Local  " ).append("\n"); 
		query.append("#elseif (${chk_lt_type} == 'T') " ).append("\n"); 
		query.append("AND  VB.KEY_POL_CD <> VB.POL_CD	--T/S" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_cfm_flg} != '') " ).append("\n"); 
		query.append("AND B.CNTR_CFM_FLG = @[cntr_cfm_flg]  --Booking Container의 Tab의 Confirm 정보 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '') " ).append("\n"); 
		query.append("AND VB.BKG_STS_CD = @[bkg_sts_cd]  	--예약 현황 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pre_1_vvd} != '') " ).append("\n"); 
		query.append("AND VB.PRE_1_VVD LIKE @[pre_1_vvd] || '%'	--pre_vvd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pre_1_pol_cd} != '') " ).append("\n"); 
		query.append("AND VB.PRE_1_POL_CD = @[pre_1_pol_cd]		--pre_pol       " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${xter_bkg_rqst_cd} != '') " ).append("\n"); 
		query.append("AND VB.XTER_BKG_RQST_CD = @[xter_bkg_rqst_cd]	--BKG Kind " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} == 'Y') " ).append("\n"); 
		query.append("AND B.CNMV_STS_CD = 'OC'	--O/C Status    Container Status가 OC인 항목 조회" ).append("\n"); 
		query.append("#elseif (${cnmv_sts_cd} == 'N') " ).append("\n"); 
		query.append("AND B.CNMV_STS_CD != 'OC'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != '') " ).append("\n"); 
		query.append("AND BK.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]	 --화물 종류All, Full, Empty로 구분 (Cargo Type 코드 참고)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dest_trns_svc_mod_cd} != '') " ).append("\n"); 
		query.append("AND VB.DEST_TRNS_SVC_MOD_CD = @[dest_trns_svc_mod_cd]	--Service Mode" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("--1.'SHPR'" ).append("\n"); 
		query.append("#if (${cust_tp_cd} == 'S') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  SUBSTR(VB.SHIPPER,1,2) = @[cust_cnt_cd] " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND	  VB.SHIPPER LIKE @[cust_cnt_cd] || @[cust_seq] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("AND	  VB.SHPR_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("--2.'CNEE'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'C') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  SUBSTR(VB.CONSIGNEE,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND	  VB.CONSIGNEE LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("AND	  VB.CONSIGNEE_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--3.'NTFY'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'N') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  SUBSTR(VB.NTFY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND	  VB.NTFY LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("AND	  VB.NTFY_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--4.'ANFY'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'A') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  SUBSTR(VB.ANTY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND	  VB.ANTY LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("AND	  VB.ANTY_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--5.'FWDR'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  SUBSTR(VB.FFDR,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND	  VB.FFDR LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("AND	  VB.FFDR_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--6.'선택하지 않았을때..'" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  	(SUBSTR(VB.SHIPPER,1,2) = @[cust_cnt_cd] OR	" ).append("\n"); 
		query.append("		SUBSTR(VB.CONSIGNEE,1,2)= @[cust_cnt_cd] OR" ).append("\n"); 
		query.append("		SUBSTR(VB.NTFY,1,2) = @[cust_cnt_cd] OR" ).append("\n"); 
		query.append("		SUBSTR(VB.ANTY,1,2) = @[cust_cnt_cd] OR " ).append("\n"); 
		query.append("		SUBSTR(VB.FFDR,1,2) = @[cust_cnt_cd])" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND		(VB.SHIPPER = @[cust_cnt_cd] || @[cust_seq] OR	" ).append("\n"); 
		query.append("		VB.CONSIGNEE = @[cust_cnt_cd] || @[cust_seq] OR" ).append("\n"); 
		query.append("		VB.NTFY = @[cust_cnt_cd]|| @[cust_seq] OR" ).append("\n"); 
		query.append("		VB.ANTY = @[cust_cnt_cd]|| @[cust_seq] OR " ).append("\n"); 
		query.append("		VB.FFDR = @[cust_cnt_cd]|| @[cust_seq])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("AND		(VB.SHPR_NAME = @[cust_nm] OR	" ).append("\n"); 
		query.append("		VB.CONSIGNEE_NAME = @[cust_nm] OR" ).append("\n"); 
		query.append("		VB.NTFY_NAME = @[cust_nm] OR" ).append("\n"); 
		query.append("		VB.ANTY_NAME = @[cust_nm] OR " ).append("\n"); 
		query.append("		VB.FFDR_NAME = @[cust_nm])		" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) T" ).append("\n"); 
		query.append("GROUP  BY ORG_YD_CD" ).append("\n"); 
		query.append("ORDER  BY ORG_YD_CD" ).append("\n"); 

	}
}