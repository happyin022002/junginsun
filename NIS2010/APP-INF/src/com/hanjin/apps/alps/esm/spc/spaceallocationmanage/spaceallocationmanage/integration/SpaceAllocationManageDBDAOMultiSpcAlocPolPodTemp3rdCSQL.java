/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPodTemp3rdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.11.26 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPodTemp3rdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_ALOC_POL_POD의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)
	  * CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - 53FT 관련 필드 추가
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPodTemp3rdCSQL(){
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
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPodTemp3rdCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_ALOC_POL_POD (" ).append("\n"); 
		query.append("    RLANE_CD            ," ).append("\n"); 
		query.append("    DIR_CD              ," ).append("\n"); 
		query.append("    VSL_CD              ," ).append("\n"); 
		query.append("    SKD_VOY_NO          ," ).append("\n"); 
		query.append("    SKD_DIR_CD          ," ).append("\n"); 
		query.append("    SLS_OFC_CD          ," ).append("\n"); 
		query.append("    POL_YD_CD           ," ).append("\n"); 
		query.append("    POD_YD_CD           ," ).append("\n"); 
		query.append("    TS_FLG              ," ).append("\n"); 
		query.append("    MNL_FLG             ," ).append("\n"); 
		query.append("    REP_TRD_CD          ," ).append("\n"); 
		query.append("    REP_SUB_TRD_CD      ," ).append("\n"); 
		query.append("    TRD_CD              ," ).append("\n"); 
		query.append("    SUB_TRD_CD          ," ).append("\n"); 
		query.append("    IOC_CD              ," ).append("\n"); 
		query.append("    SLS_RHQ_CD          ," ).append("\n"); 
		query.append("    SLS_AQ_CD           ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD      ," ).append("\n"); 
		query.append("    ASGN_TTL_QTY        ," ).append("\n"); 
		query.append("    ASGN_20FT_QTY       ," ).append("\n"); 
		query.append("    ASGN_40FT_QTY       ," ).append("\n"); 
		query.append("    ASGN_40FT_HC_QTY    ," ).append("\n"); 
		query.append("    ASGN_45FT_HC_QTY    ," ).append("\n"); 
		query.append("    ASGN_53FT_QTY       ," ).append("\n"); 
		query.append("    ASGN_RF_QTY         ," ).append("\n"); 
		query.append("    ASGN_TTL_WGT        ," ).append("\n"); 
		query.append("    BKG_AVAL_TTL_QTY    ," ).append("\n"); 
		query.append("    BKG_AVAL_20FT_QTY   ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_QTY   ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_HC_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_53FT_QTY   ," ).append("\n"); 
		query.append("    BKG_AVAL_RF_QTY     ," ).append("\n"); 
		query.append("    BKG_AVAL_TTL_WGT    ," ).append("\n"); 
		query.append("    ALOC_USR_ID         ," ).append("\n"); 
		query.append("    MNL_ALOC_RMK        ," ).append("\n"); 
		query.append("    ALOC_GDT            ," ).append("\n"); 
		query.append("    CRE_USR_ID          ," ).append("\n"); 
		query.append("    CRE_DT              ," ).append("\n"); 
		query.append("    UPD_USR_ID          ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("    @[rlane_cd]  ," ).append("\n"); 
		query.append("    @[dir_cd]    ," ).append("\n"); 
		query.append("    @[vsl_cd]    ," ).append("\n"); 
		query.append("    @[skd_voy_no]," ).append("\n"); 
		query.append("    @[skd_dir_cd]," ).append("\n"); 
		query.append("    @[sls_ofc_cd]," ).append("\n"); 
		query.append("    @[pol_cd]    ," ).append("\n"); 
		query.append("    @[pod_cd]    ," ).append("\n"); 
		query.append("    @[ts_flg]    ," ).append("\n"); 
		query.append("    'Y'," ).append("\n"); 
		query.append("    SPC_GET_REP_TRD_FNC(@[rlane_cd])," ).append("\n"); 
		query.append("    SPC_GET_REP_SUB_TRD_FNC(@[rlane_cd])," ).append("\n"); 
		query.append("    SPC_GET_TRD_FNC(@[rlane_cd], SUBSTR(@[pol_cd], 1, 5), SUBSTR(@[pod_cd], 1, 5))," ).append("\n"); 
		query.append("    SPC_GET_SUB_TRD_FNC(@[rlane_cd], SUBSTR(@[pol_cd], 1, 5), SUBSTR(@[pod_cd], 1, 5))," ).append("\n"); 
		query.append("    SPC_GET_OCN_IPC_FNC(@[rlane_cd], SUBSTR(@[pol_cd], 1, 5), SUBSTR(@[pod_cd], 1, 5))," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("       SELECT N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("         FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("              MAS_MON_VVD C" ).append("\n"); 
		query.append("        WHERE O.OFC_CD     = @[sls_ofc_cd]" ).append("\n"); 
		query.append("          AND C.TRD_CD     = SPC_GET_TRD_FNC(@[rlane_cd], SUBSTR(@[pol_cd], 1, 5), SUBSTR(@[pod_cd], 1, 5))" ).append("\n"); 
		query.append("          AND C.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("          AND C.IOC_CD     = SPC_GET_OCN_IPC_FNC(@[rlane_cd], SUBSTR(@[pol_cd], 1, 5), SUBSTR(@[pod_cd], 1, 5))" ).append("\n"); 
		query.append("          AND C.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("          AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND C.DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("    )," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("       SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("         FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("              MAS_MON_VVD C" ).append("\n"); 
		query.append("        WHERE O.OFC_CD     = @[sls_ofc_cd]" ).append("\n"); 
		query.append("          AND C.TRD_CD     = SPC_GET_TRD_FNC(@[rlane_cd], SUBSTR(@[pol_cd], 1, 5), SUBSTR(@[pod_cd], 1, 5))" ).append("\n"); 
		query.append("          AND C.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("          AND C.IOC_CD     = SPC_GET_OCN_IPC_FNC(@[rlane_cd], SUBSTR(@[pol_cd], 1, 5), SUBSTR(@[pod_cd], 1, 5))" ).append("\n"); 
		query.append("          AND C.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("          AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND C.DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("    )," ).append("\n"); 
		query.append("    @[sls_ofc_cd]," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    '1'," ).append("\n"); 
		query.append("    CAST(SYS_EXTRACT_UTC(SYSTIMESTAMP) AS DATE)," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE      ," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
