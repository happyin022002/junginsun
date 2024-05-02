/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocCustHis42CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.04
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.04 신자영
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

public class SpaceAllocationManageDBDAOMultiSpcAlocCustHis42CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_ALOC_CUST_POL_POD 의 지정된 ibflag 값에 따라 SPC_ALOC_CUST_HIS DB에 반영한다.(입력)
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.22 [선반영] AES-SC관련 로직 추가
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocCustHis42CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("account_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("us_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocCustHis42CSQL").append("\n"); 
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
		query.append("    ASGN_TTL_WGT          ," ).append("\n"); 
		query.append("    BKG_AVAL_TTL_QTY      ," ).append("\n"); 
		query.append("    BKG_AVAL_20FT_QTY     ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_QTY     ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_HC_QTY  ," ).append("\n"); 
		query.append("    BKG_AVAL_45FT_HC_QTY  ," ).append("\n"); 
		query.append("    BKG_AVAL_53FT_QTY     ," ).append("\n"); 
		query.append("    BKG_AVAL_RF_QTY       ," ).append("\n"); 
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
		query.append("    USD_BKG_TTL_WGT       ," ).append("\n"); 
		query.append("    ALOC_LOD_QTY          ," ).append("\n"); 
		query.append("    ALOC_40FT_HC_QTY      ," ).append("\n"); 
		query.append("    ALOC_45FT_HC_QTY      ," ).append("\n"); 
		query.append("    ALOC_53FT_QTY         ," ).append("\n"); 
		query.append("    ALOC_RF_QTY           ," ).append("\n"); 
		query.append("    ALOC_TTL_WGT          ," ).append("\n"); 
		query.append("    -- 2014.08.17 컬럼 추가" ).append("\n"); 
		query.append("    ALOC_20FT_DRY_QTY	  ," ).append("\n"); 
		query.append("    ALOC_40FT_DRY_QTY	  ," ).append("\n"); 
		query.append("    ALOC_RD_QTY			  ," ).append("\n"); 
		query.append("    CRE_USR_ID            ," ).append("\n"); 
		query.append("    CRE_DT                ," ).append("\n"); 
		query.append("    UPD_USR_ID            ," ).append("\n"); 
		query.append("    UPD_DT		  ," ).append("\n"); 
		query.append("    -- 2014.07.28 컬럼 추가" ).append("\n"); 
		query.append("    -- CUST_CNT_CD," ).append("\n"); 
		query.append("    -- CUST_SEQ," ).append("\n"); 
		query.append("    USA_BKG_MOD_CD," ).append("\n"); 
		query.append("    DEST_LOC_CD," ).append("\n"); 
		query.append("    ASGN_20FT_DRY_QTY," ).append("\n"); 
		query.append("    ASGN_40FT_DRY_QTY," ).append("\n"); 
		query.append("    ASGN_RD_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("    FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("    FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("    FCAST_RD_QTY," ).append("\n"); 
		query.append("    USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("    USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("    USD_BKG_RD_QTY " ).append("\n"); 
		query.append(")" ).append("\n"); 
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
		query.append("           SELECT NVL(MAX(MODI_SEQ), 0) + 1" ).append("\n"); 
		query.append("             FROM SPC_ALOC_CUST_HIS" ).append("\n"); 
		query.append("            WHERE RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("              AND DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("              AND VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("              AND SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("              AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("              AND SLS_OFC_CD   = @[sls_ofc_cd]" ).append("\n"); 
		query.append("              AND POL_YD_CD    = @[pol_cd]" ).append("\n"); 
		query.append("              AND POD_YD_CD    = @[pod_cd]" ).append("\n"); 
		query.append("              AND TS_FLG       = @[ts_flg]" ).append("\n"); 
		query.append("              AND MNL_FLG      = @[mnl_flg]" ).append("\n"); 
		query.append("              AND CUST_CTRL_CD = @[cust_ctrl_cd]" ).append("\n"); 
		query.append("              AND IOC_CD       = DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I')" ).append("\n"); 
		query.append("              AND USA_BKG_MOD_CD = DECODE(@[us_mod], 'OTHERS', 'OTH',  @[us_mod])" ).append("\n"); 
		query.append("              AND DEST_LOC_CD  = DECODE(NVL(@[del_cd], 'XXXXX'), '1', 'XXXXX', 'OTHERS', 'XXXXX', NVL(@[del_cd], '00000'))" ).append("\n"); 
		query.append("              AND CUST_CNT_CD  = DECODE(@[account_cd], 'OTHERS', 'XX', SUBSTR(@[account_cd], 1, 2))" ).append("\n"); 
		query.append("              AND CUST_SEQ     = DECODE(@[account_cd], 'OTHERS', '999999', SUBSTR(@[account_cd], 3, 6))" ).append("\n"); 
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
		query.append("         ASGN_TTL_WGT          ," ).append("\n"); 
		query.append("         BKG_AVAL_TTL_QTY      ," ).append("\n"); 
		query.append("         BKG_AVAL_20FT_QTY     ," ).append("\n"); 
		query.append("         BKG_AVAL_40FT_QTY     ," ).append("\n"); 
		query.append("         BKG_AVAL_40FT_HC_QTY  ," ).append("\n"); 
		query.append("         BKG_AVAL_45FT_HC_QTY  ," ).append("\n"); 
		query.append("         BKG_AVAL_53FT_QTY     ," ).append("\n"); 
		query.append("         BKG_AVAL_RF_QTY       ," ).append("\n"); 
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
		query.append("         FCAST_TTL_WGT         ," ).append("\n"); 
		query.append("         CTRT_FCAST_TTL_QTY    ," ).append("\n"); 
		query.append("         CTRT_FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("         CTRT_FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("         CTRT_FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("         CTRT_FCAST_RF_QTY     ," ).append("\n"); 
		query.append("         CTRT_FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("         USD_BKG_TTL_QTY       ," ).append("\n"); 
		query.append("         USD_BKG_20FT_QTY      ," ).append("\n"); 
		query.append("         USD_BKG_40FT_QTY      ," ).append("\n"); 
		query.append("         USD_BKG_40FT_HC_QTY   ," ).append("\n"); 
		query.append("         USD_BKG_45FT_HC_QTY   ," ).append("\n"); 
		query.append("         USD_BKG_53FT_QTY      ," ).append("\n"); 
		query.append("         USD_BKG_RF_QTY        ," ).append("\n"); 
		query.append("         USD_BKG_TTL_WGT       ," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_TTL_QTY    , BKG_AVAL_TTL_QTY)    ," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_40FT_HC_QTY, BKG_AVAL_40FT_HC_QTY)," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_45FT_HC_QTY, BKG_AVAL_45FT_HC_QTY)," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_53FT_QTY   , BKG_AVAL_53FT_QTY)   ," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_RF_QTY     , BKG_AVAL_RF_QTY)     ," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_TTL_WGT    , BKG_AVAL_TTL_WGT)    ," ).append("\n"); 
		query.append("		 -- 2014.08.17 컬럼 추가" ).append("\n"); 
		query.append("	     DECODE(MNL_ALOC_RMK, '3', ASGN_20FT_DRY_QTY, BKG_AVAL_20FT_DRY_QTY)," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_40FT_DRY_QTY, BKG_AVAL_40FT_DRY_QTY)," ).append("\n"); 
		query.append("         DECODE(MNL_ALOC_RMK, '3', ASGN_RD_QTY      , BKG_AVAL_RD_QTY)      ," ).append("\n"); 
		query.append("         CRE_USR_ID," ).append("\n"); 
		query.append("         CRE_DT    ," ).append("\n"); 
		query.append("         UPD_USR_ID," ).append("\n"); 
		query.append("         UPD_DT    ," ).append("\n"); 
		query.append("         -- 2014.07.28 컬럼 추가" ).append("\n"); 
		query.append("    	 -- CUST_CNT_CD," ).append("\n"); 
		query.append("    	 -- CUST_SEQ," ).append("\n"); 
		query.append("         USA_BKG_MOD_CD," ).append("\n"); 
		query.append("         DEST_LOC_CD," ).append("\n"); 
		query.append("         ASGN_20FT_DRY_QTY," ).append("\n"); 
		query.append("         ASGN_40FT_DRY_QTY," ).append("\n"); 
		query.append("         ASGN_RD_QTY," ).append("\n"); 
		query.append("         BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("         BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("         BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("         FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("         FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("         FCAST_RD_QTY," ).append("\n"); 
		query.append("         USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("         USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("         USD_BKG_RD_QTY " ).append("\n"); 
		query.append("    FROM SPC_ALOC_CUST_POL_POD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT SUM(NVL(FCAST_TTL_QTY    , 0) + NVL(FCAST_40FT_HC_QTY, 0) * 2) AS CTRT_FCAST_TTL_QTY," ).append("\n"); 
		query.append("                  SUM(NVL(FCAST_40FT_HC_QTY, 0)) AS CTRT_FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("                  SUM(NVL(FCAST_45FT_HC_QTY, 0)) AS CTRT_FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("                  SUM(NVL(FCAST_53FT_QTY   , 0)) AS CTRT_FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("                  SUM(NVL(FCAST_RF_QTY     , 0)) AS CTRT_FCAST_RF_QTY     ," ).append("\n"); 
		query.append("                  SUM(NVL(FCAST_TTL_WGT    , 0)) AS CTRT_FCAST_TTL_WGT" ).append("\n"); 
		query.append("             FROM SPC_CTRT_FCAST_CUST A," ).append("\n"); 
		query.append("                  ( SELECT CUST_CNT_CD ," ).append("\n"); 
		query.append("                           CUST_SEQ    ," ).append("\n"); 
		query.append("                           CUST_CTRL_CD," ).append("\n"); 
		query.append("                           SC_NO       ," ).append("\n"); 
		query.append("                           RFA_NO" ).append("\n"); 
		query.append("                      FROM SPC_MDL_CUST_CTRL" ).append("\n"); 
		query.append("                     WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND (TRD_CD, COST_YRWK, VER_SEQ) IN ( SELECT /*+ INDEX_DESC (V XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                                    TRD_CD, COST_YRWK, VER_SEQ" ).append("\n"); 
		query.append("                                                               FROM SPC_MDL_VER_MST V" ).append("\n"); 
		query.append("                                                              WHERE (  SELECT SUBSTR(SLS_YRMON, 1, 4)||COST_WK" ).append("\n"); 
		query.append("                                                                         FROM MAS_MON_VVD" ).append("\n"); 
		query.append("                                                                        WHERE DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                                                                          AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("                                                                          AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                                                                          AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                                                                          AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                                          AND DIR_CD     = @[dir_cd]      ) BETWEEN VER_ST_YRWK AND VER_END_YRWK" ).append("\n"); 
		query.append("                                                                AND TRD_CD  = @[trd_cd]" ).append("\n"); 
		query.append("                                                                AND CFM_FLG = 'Y' " ).append("\n"); 
		query.append("                                                                AND ROWNUM  = 1 ) ) B" ).append("\n"); 
		query.append("            WHERE A.TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("              AND A.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("              AND A.IOC_TS_CD       = DECODE(@[ts_flg], 'Y', 'T', DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I'))" ).append("\n"); 
		query.append("              AND A.VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("              AND A.SKD_VOY_NO      = @[skd_voy_no]" ).append("\n"); 
		query.append("              AND A.SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("              AND A.SLS_RGN_OFC_CD  = @[sls_ofc_cd]" ).append("\n"); 
		query.append("              AND A.POL_YD_CD       = @[pol_cd]" ).append("\n"); 
		query.append("              AND A.POD_YD_CD       = @[pod_cd]" ).append("\n"); 
		query.append("              AND A.CUST_CNT_CD     = B.CUST_CNT_CD" ).append("\n"); 
		query.append("              AND A.CUST_SEQ        = B.CUST_SEQ" ).append("\n"); 
		query.append("              AND NVL(A.SC_NO, NVL(A.RFA_NO, 'X')) = NVL(B.SC_NO, NVL(B.RFA_NO, 'X'))" ).append("\n"); 
		query.append("              AND B.CUST_CTRL_CD    = @[cust_ctrl_cd]" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("   WHERE RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("     AND DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("     AND VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("     AND SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("     AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("     AND SLS_OFC_CD   = @[sls_ofc_cd]" ).append("\n"); 
		query.append("     AND POL_YD_CD    = @[pol_cd]" ).append("\n"); 
		query.append("     AND POD_YD_CD    = @[pod_cd]" ).append("\n"); 
		query.append("     AND TS_FLG       = @[ts_flg]" ).append("\n"); 
		query.append("     AND MNL_FLG      = @[mnl_flg]" ).append("\n"); 
		query.append("     AND CUST_CTRL_CD = @[cust_ctrl_cd]" ).append("\n"); 
		query.append("     AND IOC_CD       = DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I')" ).append("\n"); 
		query.append("     AND USA_BKG_MOD_CD = DECODE(@[us_mod], 'OTHERS', 'OTH',  @[us_mod])" ).append("\n"); 
		query.append("     AND DEST_LOC_CD  = DECODE(NVL(@[del_cd], 'XXXXX'), '1', 'XXXXX', 'OTHERS', 'XXXXX', NVL(@[del_cd], '00000'))" ).append("\n"); 
		query.append("     AND CUST_CNT_CD  = DECODE(@[account_cd], 'OTHERS', 'XX', SUBSTR(@[account_cd], 1, 2))" ).append("\n"); 
		query.append("     AND CUST_SEQ     = DECODE(@[account_cd], 'OTHERS', '999999', SUBSTR(@[account_cd], 3, 6))" ).append("\n"); 
		query.append("     AND CTRT_NO      = @[ctrt_no]" ).append("\n"); 

	}
}
