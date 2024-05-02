/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOAddmultiSpaceAllocation0046CustHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.08 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOAddmultiSpaceAllocation0046CustHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * alloc copy시 aloc_cust_pol_pod 입력 후 history 생성
	  * 
	  * * 2013.06.26 진마리아 [CHM-201325016-01] 성수기 Alloc copy 기능 개발
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.22 [선반영] AES-SC관련 로직 추가
	  * 2014.08.12 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOAddmultiSpaceAllocation0046CustHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newVslVd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newSkdDirCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newSkdVoyNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOAddmultiSpaceAllocation0046CustHisCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_ALOC_CUST_HIS (" ).append("\n"); 
		query.append("    RLANE_CD              ," ).append("\n"); 
		query.append("    DIR_CD                ," ).append("\n"); 
		query.append("    VSL_CD                ," ).append("\n"); 
		query.append("    SKD_VOY_NO            ," ).append("\n"); 
		query.append("    SKD_DIR_CD            ," ).append("\n"); 
		query.append("    SLS_OFC_CD            ," ).append("\n"); 
		query.append("    POL_YD_CD             ," ).append("\n"); 
		query.append("    POD_YD_CD             ," ).append("\n"); 
		query.append("    TS_FLG                ," ).append("\n"); 
		query.append("    MNL_FLG               ," ).append("\n"); 
		query.append("    CUST_CNT_CD           ," ).append("\n"); 
		query.append("    CUST_SEQ              ," ).append("\n"); 
		query.append("    CTRT_NO               ," ).append("\n"); 
		query.append("    CUST_CTRL_CD          ," ).append("\n"); 
		query.append("    MODI_SEQ              ," ).append("\n"); 
		query.append("    REP_TRD_CD            ," ).append("\n"); 
		query.append("    REP_SUB_TRD_CD        ," ).append("\n"); 
		query.append("    TRD_CD                ," ).append("\n"); 
		query.append("    SUB_TRD_CD            ," ).append("\n"); 
		query.append("    IOC_CD                ," ).append("\n"); 
		query.append("    SLS_RHQ_CD            ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD        ," ).append("\n"); 
		query.append("    ASGN_TTL_QTY          ," ).append("\n"); 
		query.append("    ASGN_20FT_QTY         ," ).append("\n"); 
		query.append("    ASGN_40FT_QTY         ," ).append("\n"); 
		query.append("    ASGN_40FT_HC_QTY      ," ).append("\n"); 
		query.append("    ASGN_45FT_HC_QTY      ," ).append("\n"); 
		query.append("    ASGN_53FT_QTY         ," ).append("\n"); 
		query.append("    ASGN_RF_QTY           ," ).append("\n"); 
		query.append("    --20140812" ).append("\n"); 
		query.append("    ASGN_20FT_DRY_QTY     ," ).append("\n"); 
		query.append("    ASGN_40FT_DRY_QTY     ," ).append("\n"); 
		query.append("    ASGN_RD_QTY           ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ASGN_TTL_WGT          ," ).append("\n"); 
		query.append("    BKG_AVAL_TTL_QTY      ," ).append("\n"); 
		query.append("    BKG_AVAL_20FT_QTY     ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_QTY     ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_HC_QTY  ," ).append("\n"); 
		query.append("    BKG_AVAL_45FT_HC_QTY  ," ).append("\n"); 
		query.append("    BKG_AVAL_53FT_QTY     ," ).append("\n"); 
		query.append("    BKG_AVAL_RF_QTY       ," ).append("\n"); 
		query.append("    --20140812" ).append("\n"); 
		query.append("    BKG_AVAL_20FT_DRY_QTY ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_DRY_QTY ," ).append("\n"); 
		query.append("    BKG_AVAL_RD_QTY       ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    BKG_AVAL_TTL_WGT      ," ).append("\n"); 
		query.append("    ALOC_USR_ID           ," ).append("\n"); 
		query.append("    ALOC_GDT              ," ).append("\n"); 
		query.append("    CUST_SPC_GNTE_QTY     ," ).append("\n"); 
		query.append("    MODI_USR_ID           ," ).append("\n"); 
		query.append("    MODI_GDT              ," ).append("\n"); 
		query.append("    MNL_ALOC_RMK          ," ).append("\n"); 
		query.append("    IOC_TS_CD             ," ).append("\n"); 
		query.append("    FCAST_TTL_QTY         ," ).append("\n"); 
		query.append("    FCAST_40FT_HC_QTY     ," ).append("\n"); 
		query.append("    FCAST_45FT_HC_QTY     ," ).append("\n"); 
		query.append("    FCAST_53FT_QTY        ," ).append("\n"); 
		query.append("    FCAST_RF_QTY          ," ).append("\n"); 
		query.append("    --20140812" ).append("\n"); 
		query.append("    FCAST_20FT_DRY_QTY    ," ).append("\n"); 
		query.append("    FCAST_40FT_DRY_QTY    ," ).append("\n"); 
		query.append("    FCAST_RD_QTY          ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    FCAST_TTL_WGT         ," ).append("\n"); 
		query.append("    CTRT_FCAST_TTL_QTY    ," ).append("\n"); 
		query.append("    CTRT_FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("    CTRT_FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("    CTRT_FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("    CTRT_FCAST_RF_QTY     ," ).append("\n"); 
		query.append("    CTRT_FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("    USD_BKG_TTL_QTY       ," ).append("\n"); 
		query.append("    USD_BKG_20FT_QTY      ," ).append("\n"); 
		query.append("    USD_BKG_40FT_QTY      ," ).append("\n"); 
		query.append("    USD_BKG_40FT_HC_QTY   ," ).append("\n"); 
		query.append("    USD_BKG_45FT_HC_QTY   ," ).append("\n"); 
		query.append("    USD_BKG_53FT_QTY      ," ).append("\n"); 
		query.append("    USD_BKG_RF_QTY        ," ).append("\n"); 
		query.append("    --20140812" ).append("\n"); 
		query.append("    USD_BKG_20FT_DRY_QTY  ," ).append("\n"); 
		query.append("    USD_BKG_40FT_DRY_QTY  ," ).append("\n"); 
		query.append("    USD_BKG_RD_QTY        ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    USD_BKG_TTL_WGT       ," ).append("\n"); 
		query.append("    ALOC_LOD_QTY          ," ).append("\n"); 
		query.append("    ALOC_40FT_HC_QTY      ," ).append("\n"); 
		query.append("    ALOC_45FT_HC_QTY      ," ).append("\n"); 
		query.append("    ALOC_53FT_QTY         ," ).append("\n"); 
		query.append("    ALOC_RF_QTY           ," ).append("\n"); 
		query.append("    --20140812" ).append("\n"); 
		query.append("    ALOC_20FT_DRY_QTY     ," ).append("\n"); 
		query.append("    ALOC_40FT_DRY_QTY     ," ).append("\n"); 
		query.append("    ALOC_RD_QTY           ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ALOC_TTL_WGT          ," ).append("\n"); 
		query.append("    CRE_USR_ID            ," ).append("\n"); 
		query.append("    CRE_DT                ," ).append("\n"); 
		query.append("    UPD_USR_ID            ," ).append("\n"); 
		query.append("    UPD_DT                ," ).append("\n"); 
		query.append("    USA_BKG_MOD_CD        ," ).append("\n"); 
		query.append("    DEST_LOC_CD           " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH CTRT AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT A.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           A.POL_YD_CD," ).append("\n"); 
		query.append("           A.POD_YD_CD," ).append("\n"); 
		query.append("           A.IOC_TS_CD," ).append("\n"); 
		query.append("           B.CUST_CTRL_CD," ).append("\n"); 
		query.append("           FCAST_TTL_QTY," ).append("\n"); 
		query.append("           FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("           FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("           FCAST_53FT_QTY," ).append("\n"); 
		query.append("           FCAST_RF_QTY," ).append("\n"); 
		query.append("           FCAST_TTL_WGT" ).append("\n"); 
		query.append("         FROM SPC_CTRT_FCAST_CUST A," ).append("\n"); 
		query.append("              ( SELECT CUST_CNT_CD ," ).append("\n"); 
		query.append("                       CUST_SEQ    ," ).append("\n"); 
		query.append("                       CUST_CTRL_CD," ).append("\n"); 
		query.append("                       SC_NO       ," ).append("\n"); 
		query.append("                       RFA_NO" ).append("\n"); 
		query.append("                  FROM SPC_MDL_CUST_CTRL" ).append("\n"); 
		query.append("                 WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND (TRD_CD, COST_YRWK, VER_SEQ) IN ( SELECT /*+ INDEX_DESC (V XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                                TRD_CD, COST_YRWK, VER_SEQ" ).append("\n"); 
		query.append("                                                           FROM SPC_MDL_VER_MST V" ).append("\n"); 
		query.append("                                                          WHERE (  SELECT SUBSTR(SLS_YRMON, 1, 4)||COST_WK" ).append("\n"); 
		query.append("                                                                     FROM MAS_MON_VVD" ).append("\n"); 
		query.append("                                                                    WHERE DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                                                                      AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("                                                                      AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                                                                      AND VSL_CD     = @[newVslVd]" ).append("\n"); 
		query.append("                                                                      AND SKD_VOY_NO = @[newSkdVoyNo]" ).append("\n"); 
		query.append("                                                                      AND DIR_CD     = @[dir_cd]      ) BETWEEN VER_ST_YRWK AND VER_END_YRWK" ).append("\n"); 
		query.append("                                                            AND TRD_CD  = @[trd_cd]" ).append("\n"); 
		query.append("                                                            AND CFM_FLG = 'Y' " ).append("\n"); 
		query.append("                                                            AND ROWNUM  = 1 ) ) B" ).append("\n"); 
		query.append("        WHERE A.TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("          AND A.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("          AND A.VSL_CD          = @[newVslVd]" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO      = @[newSkdVoyNo]" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD      = @[newSkdDirCd]" ).append("\n"); 
		query.append("          AND A.CUST_CNT_CD     = B.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND A.CUST_SEQ        = B.CUST_SEQ" ).append("\n"); 
		query.append("          AND NVL(A.SC_NO, NVL(A.RFA_NO, 'X')) = NVL(B.SC_NO, NVL(B.RFA_NO, 'X'))" ).append("\n"); 
		query.append("          --AND DECODE(A.TRD_CD, 'AES', NVL(A.RFA_NO, 'X'), NVL(A.SC_NO, 'X')) = DECODE(A.TRD_CD, 'AES', NVL(B.RFA_NO, 'X'), NVL(B.SC_NO, 'X'))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  SELECT RLANE_CD    ," ).append("\n"); 
		query.append("         DIR_CD      ," ).append("\n"); 
		query.append("         VSL_CD      ," ).append("\n"); 
		query.append("         SKD_VOY_NO  ," ).append("\n"); 
		query.append("         SKD_DIR_CD  ," ).append("\n"); 
		query.append("         SLS_OFC_CD  ," ).append("\n"); 
		query.append("         POL_YD_CD   ," ).append("\n"); 
		query.append("         POD_YD_CD   ," ).append("\n"); 
		query.append("         TS_FLG      ," ).append("\n"); 
		query.append("         MNL_FLG     ," ).append("\n"); 
		query.append("         CUST_CNT_CD ," ).append("\n"); 
		query.append("         CUST_SEQ    ," ).append("\n"); 
		query.append("         CTRT_NO     ," ).append("\n"); 
		query.append("         CUST_CTRL_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT NVL(MAX(A.MODI_SEQ), 0) + 1" ).append("\n"); 
		query.append("             FROM SPC_ALOC_CUST_HIS A" ).append("\n"); 
		query.append("            WHERE A.RLANE_CD     = T1.rlane_cd" ).append("\n"); 
		query.append("              AND A.DIR_CD       = T1.dir_cd" ).append("\n"); 
		query.append("              AND A.VSL_CD       = T1.vsl_cd" ).append("\n"); 
		query.append("              AND A.SKD_VOY_NO   = T1.skd_voy_no" ).append("\n"); 
		query.append("              AND A.SKD_DIR_CD   = T1.skd_dir_cd" ).append("\n"); 
		query.append("              AND A.SLS_OFC_CD   = T1.sls_ofc_cd" ).append("\n"); 
		query.append("              AND A.POL_YD_CD    = T1.pol_yd_cd" ).append("\n"); 
		query.append("              AND A.POD_YD_CD    = T1.pod_yd_cd" ).append("\n"); 
		query.append("              AND A.TS_FLG       = T1.ts_flg" ).append("\n"); 
		query.append("              AND A.MNL_FLG      = T1.mnl_flg" ).append("\n"); 
		query.append("              AND A.CUST_CNT_CD  = NVL(T1.cust_cnt_cd, 'XX')" ).append("\n"); 
		query.append("              AND A.CUST_SEQ     = NVL(T1.cust_seq, '999999')" ).append("\n"); 
		query.append("              AND A.CUST_CTRL_CD = T1.cust_ctrl_cd" ).append("\n"); 
		query.append("              AND A.IOC_CD       = T1.IOC_CD" ).append("\n"); 
		query.append("              AND A.USA_BKG_MOD_CD = T1.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("              AND A.DEST_LOC_CD    = T1.DEST_LOC_CD" ).append("\n"); 
		query.append("              AND A.CTRT_NO        = T1.CTRT_NO" ).append("\n"); 
		query.append("         ) HIS_SEQ             ," ).append("\n"); 
		query.append("         REP_TRD_CD            ," ).append("\n"); 
		query.append("         REP_SUB_TRD_CD        ," ).append("\n"); 
		query.append("         TRD_CD                ," ).append("\n"); 
		query.append("         SUB_TRD_CD            ," ).append("\n"); 
		query.append("         IOC_CD                ," ).append("\n"); 
		query.append("         SLS_RHQ_CD            ," ).append("\n"); 
		query.append("         SLS_RGN_OFC_CD        ," ).append("\n"); 
		query.append("         ASGN_TTL_QTY          ," ).append("\n"); 
		query.append("         ASGN_20FT_QTY         ," ).append("\n"); 
		query.append("         ASGN_40FT_QTY         ," ).append("\n"); 
		query.append("         ASGN_40FT_HC_QTY      ," ).append("\n"); 
		query.append("         ASGN_45FT_HC_QTY      ," ).append("\n"); 
		query.append("         ASGN_53FT_QTY         ," ).append("\n"); 
		query.append("         ASGN_RF_QTY           ," ).append("\n"); 
		query.append("         --20140812" ).append("\n"); 
		query.append("         ASGN_20FT_DRY_QTY     ," ).append("\n"); 
		query.append("         ASGN_40FT_DRY_QTY     ," ).append("\n"); 
		query.append("         ASGN_RD_QTY           ," ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         ASGN_TTL_WGT          ," ).append("\n"); 
		query.append("         BKG_AVAL_TTL_QTY      ," ).append("\n"); 
		query.append("         BKG_AVAL_20FT_QTY     ," ).append("\n"); 
		query.append("         BKG_AVAL_40FT_QTY     ," ).append("\n"); 
		query.append("         BKG_AVAL_40FT_HC_QTY  ," ).append("\n"); 
		query.append("         BKG_AVAL_45FT_HC_QTY  ," ).append("\n"); 
		query.append("         BKG_AVAL_53FT_QTY     ," ).append("\n"); 
		query.append("         BKG_AVAL_RF_QTY       ," ).append("\n"); 
		query.append("         --20140812" ).append("\n"); 
		query.append("         BKG_AVAL_20FT_DRY_QTY ," ).append("\n"); 
		query.append("         BKG_AVAL_40FT_DRY_QTY ," ).append("\n"); 
		query.append("         BKG_AVAL_RD_QTY       ," ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         BKG_AVAL_TTL_WGT      ," ).append("\n"); 
		query.append("         ALOC_USR_ID           ," ).append("\n"); 
		query.append("         ALOC_GDT              ," ).append("\n"); 
		query.append("         0                     ," ).append("\n"); 
		query.append("         UPD_USR_ID            ," ).append("\n"); 
		query.append("         ALOC_GDT              ," ).append("\n"); 
		query.append("         MNL_ALOC_RMK          ," ).append("\n"); 
		query.append("         DECODE(TS_FLG, 'Y', 'T', IOC_CD)," ).append("\n"); 
		query.append("         FCAST_TTL_QTY         ," ).append("\n"); 
		query.append("         FCAST_40FT_HC_QTY     ," ).append("\n"); 
		query.append("         FCAST_45FT_HC_QTY     ," ).append("\n"); 
		query.append("         FCAST_53FT_QTY        ," ).append("\n"); 
		query.append("         FCAST_RF_QTY          ," ).append("\n"); 
		query.append("         --20140812" ).append("\n"); 
		query.append("         FCAST_20FT_DRY_QTY    ," ).append("\n"); 
		query.append("         FCAST_40FT_DRY_QTY    ," ).append("\n"); 
		query.append("         FCAST_RD_QTY          ," ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         FCAST_TTL_WGT         ," ).append("\n"); 
		query.append("         (SELECT NVL(FCAST_TTL_QTY   , 0) + NVL(FCAST_40FT_HC_QTY, 0) * 2" ).append("\n"); 
		query.append("            FROM CTRT C" ).append("\n"); 
		query.append("           WHERE C.SLS_RGN_OFC_CD = T1.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("             AND C.POL_YD_CD = T1.POL_YD_CD" ).append("\n"); 
		query.append("             AND C.POD_YD_CD = T1.POD_YD_CD" ).append("\n"); 
		query.append("             AND C.CUST_CTRL_CD = T1.CUST_CTRL_CD" ).append("\n"); 
		query.append("             AND C.IOC_TS_CD = DECODE(T1.TS_FLG, 'Y', 'T', T1.IOC_CD)" ).append("\n"); 
		query.append("         ) AS CTRT_FCAST_TTL_QTY," ).append("\n"); 
		query.append("         (SELECT FCAST_40FT_HC_QTY" ).append("\n"); 
		query.append("            FROM CTRT C" ).append("\n"); 
		query.append("           WHERE C.SLS_RGN_OFC_CD = T1.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("             AND C.POL_YD_CD = T1.POL_YD_CD" ).append("\n"); 
		query.append("             AND C.POD_YD_CD = T1.POD_YD_CD" ).append("\n"); 
		query.append("             AND C.CUST_CTRL_CD = T1.CUST_CTRL_CD" ).append("\n"); 
		query.append("             AND C.IOC_TS_CD = DECODE(T1.TS_FLG, 'Y', 'T', T1.IOC_CD)" ).append("\n"); 
		query.append("         ) AS CTRT_FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("         (SELECT FCAST_45FT_HC_QTY" ).append("\n"); 
		query.append("            FROM CTRT C" ).append("\n"); 
		query.append("           WHERE C.SLS_RGN_OFC_CD = T1.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("             AND C.POL_YD_CD = T1.POL_YD_CD" ).append("\n"); 
		query.append("             AND C.POD_YD_CD = T1.POD_YD_CD" ).append("\n"); 
		query.append("             AND C.CUST_CTRL_CD = T1.CUST_CTRL_CD" ).append("\n"); 
		query.append("             AND C.IOC_TS_CD = DECODE(T1.TS_FLG, 'Y', 'T', T1.IOC_CD)" ).append("\n"); 
		query.append("         ) AS CTRT_FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("         (SELECT FCAST_53FT_QTY" ).append("\n"); 
		query.append("            FROM CTRT C" ).append("\n"); 
		query.append("           WHERE C.SLS_RGN_OFC_CD = T1.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("             AND C.POL_YD_CD = T1.POL_YD_CD" ).append("\n"); 
		query.append("             AND C.POD_YD_CD = T1.POD_YD_CD" ).append("\n"); 
		query.append("             AND C.CUST_CTRL_CD = T1.CUST_CTRL_CD" ).append("\n"); 
		query.append("             AND C.IOC_TS_CD = DECODE(T1.TS_FLG, 'Y', 'T', T1.IOC_CD)" ).append("\n"); 
		query.append("         ) AS CTRT_FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("         (SELECT FCAST_RF_QTY" ).append("\n"); 
		query.append("            FROM CTRT C" ).append("\n"); 
		query.append("           WHERE C.SLS_RGN_OFC_CD = T1.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("             AND C.POL_YD_CD = T1.POL_YD_CD" ).append("\n"); 
		query.append("             AND C.POD_YD_CD = T1.POD_YD_CD" ).append("\n"); 
		query.append("             AND C.CUST_CTRL_CD = T1.CUST_CTRL_CD" ).append("\n"); 
		query.append("             AND C.IOC_TS_CD = DECODE(T1.TS_FLG, 'Y', 'T', T1.IOC_CD)" ).append("\n"); 
		query.append("         ) AS CTRT_FCAST_RF_QTY     ," ).append("\n"); 
		query.append("         (SELECT FCAST_TTL_WGT" ).append("\n"); 
		query.append("            FROM CTRT C" ).append("\n"); 
		query.append("           WHERE C.SLS_RGN_OFC_CD = T1.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("             AND C.POL_YD_CD = T1.POL_YD_CD" ).append("\n"); 
		query.append("             AND C.POD_YD_CD = T1.POD_YD_CD" ).append("\n"); 
		query.append("             AND C.CUST_CTRL_CD = T1.CUST_CTRL_CD" ).append("\n"); 
		query.append("             AND C.IOC_TS_CD = DECODE(T1.TS_FLG, 'Y', 'T', T1.IOC_CD)" ).append("\n"); 
		query.append("         ) AS CTRT_FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("         USD_BKG_TTL_QTY       ," ).append("\n"); 
		query.append("         USD_BKG_20FT_QTY      ," ).append("\n"); 
		query.append("         USD_BKG_40FT_QTY      ," ).append("\n"); 
		query.append("         USD_BKG_40FT_HC_QTY   ," ).append("\n"); 
		query.append("         USD_BKG_45FT_HC_QTY   ," ).append("\n"); 
		query.append("         USD_BKG_53FT_QTY      ," ).append("\n"); 
		query.append("         USD_BKG_RF_QTY        ," ).append("\n"); 
		query.append("         --20140812" ).append("\n"); 
		query.append("         USD_BKG_20FT_DRY_QTY  ," ).append("\n"); 
		query.append("         USD_BKG_40FT_DRY_QTY  ," ).append("\n"); 
		query.append("         USD_BKG_RD_QTY        ," ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         USD_BKG_TTL_WGT       ," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_TTL_QTY     , BKG_AVAL_TTL_QTY)     ," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_40FT_HC_QTY , BKG_AVAL_40FT_HC_QTY) ," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_45FT_HC_QTY , BKG_AVAL_45FT_HC_QTY) ," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_53FT_QTY    , BKG_AVAL_53FT_QTY)    ," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_RF_QTY      , BKG_AVAL_RF_QTY)      ," ).append("\n"); 
		query.append("         --20140812" ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_20FT_DRY_QTY, BKG_AVAL_20FT_DRY_QTY)," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_40FT_DRY_QTY, BKG_AVAL_40FT_DRY_QTY)," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_RD_QTY      , BKG_AVAL_RD_QTY)      ," ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_TTL_WGT     , BKG_AVAL_TTL_WGT)     ," ).append("\n"); 
		query.append("         @[upd_usr_id]," ).append("\n"); 
		query.append("         SYSDATE    ," ).append("\n"); 
		query.append("         @[upd_usr_id]," ).append("\n"); 
		query.append("         SYSDATE," ).append("\n"); 
		query.append("         --20140812" ).append("\n"); 
		query.append("         USA_BKG_MOD_CD," ).append("\n"); 
		query.append("         DEST_LOC_CD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("    FROM SPC_ALOC_CUST_POL_POD T1" ).append("\n"); 
		query.append("   WHERE RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("     AND DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("     AND VSL_CD       = @[newVslVd]" ).append("\n"); 
		query.append("     AND SKD_VOY_NO   = @[newSkdVoyNo]" ).append("\n"); 
		query.append("     AND SKD_DIR_CD   = @[newSkdDirCd]" ).append("\n"); 

	}
}
