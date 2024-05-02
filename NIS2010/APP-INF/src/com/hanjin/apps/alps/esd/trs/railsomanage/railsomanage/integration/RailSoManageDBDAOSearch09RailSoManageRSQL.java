/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailSoManageDBDAOSearch09RailSoManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.08
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.12.08 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch09RailSoManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail Empty SO 대상 상세조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch09RailSoManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrlOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch09RailSoManageRSQL").append("\n"); 
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
		query.append("#set(${refId}=${refId})" ).append("\n"); 
		query.append("#set(${eqTpSzCd}=${eqTpSzCd})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach(${key} IN ${arrNo})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.REPO_PLN_ID," ).append("\n"); 
		query.append("X.PLN_YRWK," ).append("\n"); 
		query.append("X.REF_ID," ).append("\n"); 
		query.append("X.REF_SEQ," ).append("\n"); 
		query.append("X.REPO_PURP_RMK," ).append("\n"); 
		query.append("X.VSL_LANE_CD SLAN_CD," ).append("\n"); 
		query.append("DECODE(X.SO_IF_DIV_CD, 'O', 'CN', 'F', 'CF', 'ER') TRSP_MTY_COST_MOD_CD," ).append("\n"); 
		query.append("'M' CGO_TP_CD," ).append("\n"); 
		query.append("DECODE(X.SO_IF_DIV_CD, 'O', 'On-Hire', 'F', 'Off-Hire', 'Empty Repo') TRSP_COST_DTL_MOD_NAME," ).append("\n"); 
		query.append("X.CNTR_NO EQ_NO," ).append("\n"); 
		query.append("X.CNTR_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("SUBSTR(X.FM_YD_CD, 1, 5) FM_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(X.FM_YD_CD, 6) FM_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(X.TO_YD_CD, 1, 5) TO_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(X.TO_YD_CD, 6) TO_NOD_YARD," ).append("\n"); 
		query.append("(CTMM.CTRT_OFC_CTY_CD||CTMM.CTRT_SEQ) LESSOR," ).append("\n"); 
		query.append("Y.LSTM_CD," ).append("\n"); 
		query.append("Y.IMDT_EXT_FLG," ).append("\n"); 
		query.append("Y.OWNR_CO_CD OWNR_CO_CD," ).append("\n"); 
		query.append("Y.CNTR_USE_CO_CD EQ_USED," ).append("\n"); 
		query.append("Y.CNMV_STS_CD MOVEMENT_STS," ).append("\n"); 
		query.append("Y.CRNT_YD_CD CREATION_YARD," ).append("\n"); 
		query.append("TO_CHAR(Y.CNMV_DT, 'YYYYMMDD') EVENT_DATE," ).append("\n"); 
		query.append("X.SO_RQST_DT TRSP_MTY_RQST_DT," ).append("\n"); 
		query.append("X.VSL_CD," ).append("\n"); 
		query.append("X.SKD_VOY_NO," ).append("\n"); 
		query.append("X.SKD_DIR_CD," ).append("\n"); 
		query.append("'' INTER_RMK," ).append("\n"); 
		query.append("'' SPCL_INSTR_RMK," ).append("\n"); 
		query.append("'' TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("Z.RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("Z.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("Z.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("Z.ROUT_SEQ, Z.ROUT_PLN_CD," ).append("\n"); 
		query.append("Z.INLND_ROUT_RMK," ).append("\n"); 
		query.append("NVL(Z.ROUT_DTL_SEQ, 0) ROUT_DTL_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_REPO_EXE_SO_IF X," ).append("\n"); 
		query.append("MST_CONTAINER Y," ).append("\n"); 
		query.append("CTM_MOVEMENT CTMM," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.REPO_PLN_ID," ).append("\n"); 
		query.append("A.PLN_YRWK," ).append("\n"); 
		query.append("A.REF_ID," ).append("\n"); 
		query.append("A.REF_SEQ," ).append("\n"); 
		query.append("A.REPO_PURP_RMK," ).append("\n"); 
		query.append("A.VSL_LANE_CD SLAN_CD," ).append("\n"); 
		query.append("A.SO_IF_DIV_CD TRSP_MTY_COST_MOD_CD," ).append("\n"); 
		query.append("DECODE(A.SO_IF_DIV_CD, 'O', 'On-Hire', 'F', 'Off-Hire', 'Empty Repo') TRSP_COST_DTL_MOD_NAME," ).append("\n"); 
		query.append("A.CNTR_NO EQ_NO," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("SUBSTR(A.FM_YD_CD, 1, 5) FM_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(A.FM_YD_CD, 6) FM_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(A.TO_YD_CD, 1, 5) TO_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(A.TO_YD_CD, 6) TO_NOD_YARD," ).append("\n"); 
		query.append("(CTM.CTRT_OFC_CTY_CD||CTM.CTRT_SEQ) LESSOR," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("B.IMDT_EXT_FLG," ).append("\n"); 
		query.append("B.OWNR_CO_CD OWNR_CO_CD," ).append("\n"); 
		query.append("B.CNTR_USE_CO_CD EQ_USED," ).append("\n"); 
		query.append("B.CNMV_STS_CD MOVEMENT_STS," ).append("\n"); 
		query.append("B.CRNT_YD_CD CREATION_YARD," ).append("\n"); 
		query.append("TO_CHAR(B.CNMV_DT, 'YYYYMMDD') EVENT_DATE," ).append("\n"); 
		query.append("A.SO_RQST_DT TRSP_MTY_RQST_DT," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("MST.INLND_ROUT_INV_BIL_PATT_CD RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("MST.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("MST.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("MST.ROUT_SEQ," ).append("\n"); 
		query.append("MST.ROUT_PLN_CD," ).append("\n"); 
		query.append("MST.INLND_ROUT_RMK," ).append("\n"); 
		query.append("DECODE(COUNT(DTL.ROUT_DTL_SEQ)," ).append("\n"); 
		query.append("SUBSTR(MST.INLND_ROUT_INV_BIL_PATT_CD, 2, 1)," ).append("\n"); 
		query.append("SUBSTR(MST.INLND_ROUT_INV_BIL_PATT_CD, 2, 1), '0') ROUT_DTL_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_REPO_EXE_SO_IF A," ).append("\n"); 
		query.append("MST_CONTAINER B," ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST MST," ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL DTL," ).append("\n"); 
		query.append("CTM_MOVEMENT CTM," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("C.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("C.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("C.ROUT_SEQ," ).append("\n"); 
		query.append("C.PRIO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(A.PRIO_SEQ) OVER (PARTITION BY A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD) MIN_CNT," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_SEQ, A.PRIO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CNT," ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ, TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(ROUT_SEQ) OVER (PARTITION BY ROUT_ORG_NOD_CD,  ROUT_DEST_NOD_CD, ROUT_SEQ) CNT," ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ, TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL DTL" ).append("\n"); 
		query.append("WHERE EXISTS" ).append("\n"); 
		query.append("(SELECT 'X' FROM EQR_REPO_EXE_SO_IF A" ).append("\n"); 
		query.append("WHERE A.FM_YD_CD = DTL.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   A.TO_YD_CD = DTL.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("AND   A.EQ_CTRL_OFC_CD = @[sctrlOfcCd]" ).append("\n"); 
		query.append("AND   A.REF_ID = ${refId.get($key)}" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = ${eqTpSzCd.get($key)}" ).append("\n"); 
		query.append("AND   A.TRSP_MOD_CD = 'R'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND   TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ, TRSP_MOD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CNT = 1" ).append("\n"); 
		query.append("AND   TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   A.ROUT_DEST_NOD_CD= B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   A.ROUT_SEQ        = B.ROUT_SEQ" ).append("\n"); 
		query.append("AND   NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   A.PCTL_IO_BND_CD  = 'M'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE C.MIN_CNT = C.PRIO_SEQ" ).append("\n"); 
		query.append(") CHK_MST," ).append("\n"); 
		query.append("MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   MST.ROUT_ORG_NOD_CD = CHK_MST.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   MST.ROUT_DEST_NOD_CD = CHK_MST.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   MST.ROUT_SEQ = CHK_MST.ROUT_SEQ" ).append("\n"); 
		query.append("AND   B.CNTR_NO = CTM.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   B.CNMV_YR = CTM.CNMV_YR(+)" ).append("\n"); 
		query.append("AND   B.CNMV_ID_NO = CTM.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("AND   NVL(MST.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   DTL.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("AND   A.WO_EXE_FLG = 'N'" ).append("\n"); 
		query.append("AND   A.WO_RQST_FLG = 'Y'" ).append("\n"); 
		query.append("AND   A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("AND   A.EQ_CTRL_OFC_CD = @[sctrlOfcCd]" ).append("\n"); 
		query.append("AND   A.REF_ID = ${refId.get($key)}" ).append("\n"); 
		query.append("AND   A.FM_YD_CD = DTL.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   A.TO_YD_CD = DTL.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = ${eqTpSzCd.get($key)}" ).append("\n"); 
		query.append("AND   A.CO_CD = 'H'" ).append("\n"); 
		query.append("AND   MST.ROUT_ORG_NOD_CD = DTL.ROUT_ORG_NOD_CD(+)" ).append("\n"); 
		query.append("AND   MST.ROUT_DEST_NOD_CD = DTL.ROUT_DEST_NOD_CD(+)" ).append("\n"); 
		query.append("AND   MST.ROUT_SEQ = DTL.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND   MST.PCTL_IO_BND_CD  = 'M'" ).append("\n"); 
		query.append("AND   SUBSTR(A.FM_YD_CD, 1, 5) = LOC.LOC_CD" ).append("\n"); 
		query.append("AND   EXISTS (SELECT 1 FROM MDM_COUNTRY CNTY WHERE CNTY.CNT_CD != 'MX' AND LOC.CONTI_CD = 'M' AND A.TRSP_MOD_CD = 'R' AND LOC.CNT_CD = CNTY.CNT_CD)" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.REPO_PLN_ID," ).append("\n"); 
		query.append("A.PLN_YRWK," ).append("\n"); 
		query.append("A.REF_ID," ).append("\n"); 
		query.append("A.REF_SEQ," ).append("\n"); 
		query.append("A.REPO_PURP_RMK," ).append("\n"); 
		query.append("A.VSL_LANE_CD," ).append("\n"); 
		query.append("A.SO_IF_DIV_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.FM_YD_CD," ).append("\n"); 
		query.append("A.TO_YD_CD," ).append("\n"); 
		query.append("CTM.CTRT_OFC_CTY_CD," ).append("\n"); 
		query.append("CTM.CTRT_SEQ," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("B.IMDT_EXT_FLG," ).append("\n"); 
		query.append("B.OWNR_CO_CD," ).append("\n"); 
		query.append("B.CNTR_USE_CO_CD," ).append("\n"); 
		query.append("B.CNMV_STS_CD," ).append("\n"); 
		query.append("B.CRNT_YD_CD," ).append("\n"); 
		query.append("B.CNMV_DT," ).append("\n"); 
		query.append("A.SO_RQST_DT," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("MST.INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("MST.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("MST.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("MST.ROUT_SEQ," ).append("\n"); 
		query.append("MST.ROUT_PLN_CD," ).append("\n"); 
		query.append("MST.INLND_ROUT_RMK" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("WHERE X.WO_EXE_FLG = 'N'" ).append("\n"); 
		query.append("AND   X.WO_RQST_FLG = 'Y'" ).append("\n"); 
		query.append("AND   X.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("AND   X.CO_CD = 'H'" ).append("\n"); 
		query.append("AND   X.EQ_CTRL_OFC_CD = @[sctrlOfcCd]" ).append("\n"); 
		query.append("AND   X.REF_ID = ${refId.get($key)}" ).append("\n"); 
		query.append("AND   X.CNTR_TPSZ_CD = ${eqTpSzCd.get($key)}" ).append("\n"); 
		query.append("AND   X.CNTR_NO = Y.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   X.REPO_PLN_ID = Z.REPO_PLN_ID(+)" ).append("\n"); 
		query.append("AND   X.PLN_YRWK = Z.PLN_YRWK(+)" ).append("\n"); 
		query.append("AND   X.REF_ID = Z.REF_ID(+)" ).append("\n"); 
		query.append("AND   X.REF_SEQ = Z.REF_SEQ(+)" ).append("\n"); 
		query.append("AND   Y.CNTR_NO = CTMM.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   Y.CNMV_YR = CTMM.CNMV_YR(+)" ).append("\n"); 
		query.append("AND   Y.CNMV_ID_NO = CTMM.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.REPO_PLN_ID," ).append("\n"); 
		query.append("X.PLN_YRWK," ).append("\n"); 
		query.append("X.REF_ID," ).append("\n"); 
		query.append("X.REF_SEQ," ).append("\n"); 
		query.append("X.REPO_PURP_RMK," ).append("\n"); 
		query.append("X.VSL_LANE_CD SLAN_CD," ).append("\n"); 
		query.append("X.SO_IF_DIV_CD TRSP_MTY_COST_MOD_CD," ).append("\n"); 
		query.append("'M' CGO_TP_CD," ).append("\n"); 
		query.append("DECODE(X.SO_IF_DIV_CD, 'O', 'On-Hire', 'F', 'Off-Hire', 'Empty Repo') TRSP_COST_DTL_MOD_NAME," ).append("\n"); 
		query.append("X.CNTR_NO EQ_NO," ).append("\n"); 
		query.append("X.CNTR_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("SUBSTR(X.FM_YD_CD, 1, 5) FM_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(X.FM_YD_CD, 6) FM_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(X.TO_YD_CD, 1, 5) TO_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(X.TO_YD_CD, 6) TO_NOD_YARD," ).append("\n"); 
		query.append("(CTMM.CTRT_OFC_CTY_CD||CTMM.CTRT_SEQ) LESSOR," ).append("\n"); 
		query.append("Y.LSTM_CD," ).append("\n"); 
		query.append("Y.IMDT_EXT_FLG," ).append("\n"); 
		query.append("Y.OWNR_CO_CD OWNR_CO_CD," ).append("\n"); 
		query.append("Y.CNTR_USE_CO_CD EQ_USED," ).append("\n"); 
		query.append("Y.CNMV_STS_CD MOVEMENT_STS," ).append("\n"); 
		query.append("Y.CRNT_YD_CD CREATION_YARD," ).append("\n"); 
		query.append("TO_CHAR(Y.CNMV_DT, 'YYYYMMDD') EVENT_DATE," ).append("\n"); 
		query.append("X.SO_RQST_DT TRSP_MTY_RQST_DT," ).append("\n"); 
		query.append("X.VSL_CD," ).append("\n"); 
		query.append("X.SKD_VOY_NO," ).append("\n"); 
		query.append("X.SKD_DIR_CD," ).append("\n"); 
		query.append("'' INTER_RMK," ).append("\n"); 
		query.append("'' SPCL_INSTR_RMK," ).append("\n"); 
		query.append("'' TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("Z.RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("Z.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("Z.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("Z.ROUT_SEQ, Z.ROUT_PLN_CD," ).append("\n"); 
		query.append("Z.INLND_ROUT_RMK," ).append("\n"); 
		query.append("NVL(Z.ROUT_DTL_SEQ, 0) ROUT_DTL_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_REPO_EXE_SO_IF X," ).append("\n"); 
		query.append("MST_CONTAINER Y," ).append("\n"); 
		query.append("CTM_MOVEMENT CTMM," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.REPO_PLN_ID," ).append("\n"); 
		query.append("A.PLN_YRWK," ).append("\n"); 
		query.append("A.REF_ID," ).append("\n"); 
		query.append("A.REF_SEQ," ).append("\n"); 
		query.append("A.REPO_PURP_RMK," ).append("\n"); 
		query.append("A.VSL_LANE_CD SLAN_CD," ).append("\n"); 
		query.append("A.SO_IF_DIV_CD TRSP_MTY_COST_MOD_CD," ).append("\n"); 
		query.append("DECODE(A.SO_IF_DIV_CD, 'O', 'On-Hire', 'F', 'Off-Hire', 'Empty Repo') TRSP_COST_DTL_MOD_NAME," ).append("\n"); 
		query.append("A.CNTR_NO EQ_NO," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("SUBSTR(A.FM_YD_CD, 1, 5) FM_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(A.FM_YD_CD, 6) FM_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(A.TO_YD_CD, 1, 5) TO_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(A.TO_YD_CD, 6) TO_NOD_YARD," ).append("\n"); 
		query.append("(CTM.CTRT_OFC_CTY_CD||CTM.CTRT_SEQ) LESSOR," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("B.IMDT_EXT_FLG," ).append("\n"); 
		query.append("B.OWNR_CO_CD OWNR_CO_CD," ).append("\n"); 
		query.append("B.CNTR_USE_CO_CD EQ_USED," ).append("\n"); 
		query.append("B.CNMV_STS_CD MOVEMENT_STS," ).append("\n"); 
		query.append("B.CRNT_YD_CD CREATION_YARD," ).append("\n"); 
		query.append("TO_CHAR(B.CNMV_DT, 'YYYYMMDD') EVENT_DATE," ).append("\n"); 
		query.append("A.SO_RQST_DT TRSP_MTY_RQST_DT," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("MST.INLND_ROUT_INV_BIL_PATT_CD RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("MST.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("MST.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("MST.ROUT_SEQ," ).append("\n"); 
		query.append("MST.ROUT_PLN_CD," ).append("\n"); 
		query.append("MST.INLND_ROUT_RMK," ).append("\n"); 
		query.append("DECODE(COUNT(DTL.ROUT_DTL_SEQ)," ).append("\n"); 
		query.append("SUBSTR(MST.INLND_ROUT_INV_BIL_PATT_CD, 2, 1)," ).append("\n"); 
		query.append("SUBSTR(MST.INLND_ROUT_INV_BIL_PATT_CD, 2, 1), '0') ROUT_DTL_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_REPO_EXE_SO_IF A," ).append("\n"); 
		query.append("MST_CONTAINER B," ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST MST," ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL DTL," ).append("\n"); 
		query.append("CTM_MOVEMENT CTM," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("C.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("C.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("C.ROUT_SEQ," ).append("\n"); 
		query.append("C.PRIO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(A.PRIO_SEQ) OVER (PARTITION BY A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD) MIN_CNT," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_SEQ, A.PRIO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CNT," ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ, TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(ROUT_SEQ) OVER (PARTITION BY ROUT_ORG_NOD_CD,  ROUT_DEST_NOD_CD, ROUT_SEQ) CNT," ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ, TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL DTL" ).append("\n"); 
		query.append("WHERE EXISTS" ).append("\n"); 
		query.append("(SELECT 'X' FROM EQR_REPO_EXE_SO_IF A" ).append("\n"); 
		query.append("WHERE A.FM_YD_CD = DTL.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   A.TO_YD_CD = DTL.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("AND   A.EQ_CTRL_OFC_CD = @[sctrlOfcCd]" ).append("\n"); 
		query.append("AND   A.REF_ID = ${refId.get($key)}" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = ${eqTpSzCd.get($key)}" ).append("\n"); 
		query.append("AND   A.TRSP_MOD_CD = 'R'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND   TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ, TRSP_MOD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CNT = 1" ).append("\n"); 
		query.append("AND   TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   A.ROUT_DEST_NOD_CD= B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   A.ROUT_SEQ        = B.ROUT_SEQ" ).append("\n"); 
		query.append("AND   NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   A.PCTL_IO_BND_CD  = 'M'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE C.MIN_CNT = C.PRIO_SEQ" ).append("\n"); 
		query.append(") CHK_MST," ).append("\n"); 
		query.append("MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   MST.ROUT_ORG_NOD_CD = CHK_MST.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   MST.ROUT_DEST_NOD_CD = CHK_MST.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   MST.ROUT_SEQ = CHK_MST.ROUT_SEQ" ).append("\n"); 
		query.append("AND   B.CNTR_NO = CTM.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   B.CNMV_YR = CTM.CNMV_YR(+)" ).append("\n"); 
		query.append("AND   B.CNMV_ID_NO = CTM.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("AND   NVL(MST.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   DTL.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("AND   A.WO_EXE_FLG = 'N'" ).append("\n"); 
		query.append("AND   A.WO_RQST_FLG = 'Y'" ).append("\n"); 
		query.append("AND   A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("AND   A.EQ_CTRL_OFC_CD = @[sctrlOfcCd]" ).append("\n"); 
		query.append("AND   A.REF_ID = ${refId.get($key)}" ).append("\n"); 
		query.append("AND   A.FM_YD_CD = DTL.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND   A.TO_YD_CD = DTL.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = ${eqTpSzCd.get($key)}" ).append("\n"); 
		query.append("AND   A.CO_CD = 'H'" ).append("\n"); 
		query.append("AND   MST.ROUT_ORG_NOD_CD = DTL.ROUT_ORG_NOD_CD(+)" ).append("\n"); 
		query.append("AND   MST.ROUT_DEST_NOD_CD = DTL.ROUT_DEST_NOD_CD(+)" ).append("\n"); 
		query.append("AND   MST.ROUT_SEQ = DTL.ROUT_SEQ(+)" ).append("\n"); 
		query.append("AND   MST.PCTL_IO_BND_CD  = 'M'" ).append("\n"); 
		query.append("AND   SUBSTR(A.FM_YD_CD, 1, 5) = LOC.LOC_CD" ).append("\n"); 
		query.append("AND   EXISTS (SELECT 1 FROM MDM_COUNTRY CNTY WHERE CNTY.CNT_CD != 'MX' AND LOC.CONTI_CD = 'M' AND A.TRSP_MOD_CD = 'R' AND LOC.CNT_CD = CNTY.CNT_CD)" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.REPO_PLN_ID," ).append("\n"); 
		query.append("A.PLN_YRWK," ).append("\n"); 
		query.append("A.REF_ID," ).append("\n"); 
		query.append("A.REF_SEQ," ).append("\n"); 
		query.append("A.REPO_PURP_RMK," ).append("\n"); 
		query.append("A.VSL_LANE_CD," ).append("\n"); 
		query.append("A.SO_IF_DIV_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.FM_YD_CD," ).append("\n"); 
		query.append("A.TO_YD_CD," ).append("\n"); 
		query.append("CTM.CTRT_OFC_CTY_CD," ).append("\n"); 
		query.append("CTM.CTRT_SEQ," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("B.IMDT_EXT_FLG," ).append("\n"); 
		query.append("B.OWNR_CO_CD," ).append("\n"); 
		query.append("B.CNTR_USE_CO_CD," ).append("\n"); 
		query.append("B.CNMV_STS_CD," ).append("\n"); 
		query.append("B.CRNT_YD_CD," ).append("\n"); 
		query.append("B.CNMV_DT," ).append("\n"); 
		query.append("A.SO_RQST_DT," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("MST.INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("MST.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("MST.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("MST.ROUT_SEQ," ).append("\n"); 
		query.append("MST.ROUT_PLN_CD," ).append("\n"); 
		query.append("MST.INLND_ROUT_RMK" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("WHERE X.WO_EXE_FLG = 'N'" ).append("\n"); 
		query.append("AND   X.WO_RQST_FLG = 'Y'" ).append("\n"); 
		query.append("AND   X.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("AND   X.CO_CD = 'H'" ).append("\n"); 
		query.append("AND   X.EQ_CTRL_OFC_CD = @[sctrlOfcCd]" ).append("\n"); 
		query.append("AND   X.REF_ID = ${refId.get($key)}" ).append("\n"); 
		query.append("AND   X.CNTR_TPSZ_CD = ${eqTpSzCd.get($key)}" ).append("\n"); 
		query.append("AND   X.CNTR_NO = Y.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   X.REPO_PLN_ID = Z.REPO_PLN_ID(+)" ).append("\n"); 
		query.append("AND   X.PLN_YRWK = Z.PLN_YRWK(+)" ).append("\n"); 
		query.append("AND   X.REF_ID = Z.REF_ID(+)" ).append("\n"); 
		query.append("AND   X.REF_SEQ = Z.REF_SEQ(+)" ).append("\n"); 
		query.append("AND   Y.CNTR_NO = CTMM.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   Y.CNMV_YR = CTMM.CNMV_YR(+)" ).append("\n"); 
		query.append("AND   Y.CNMV_ID_NO = CTMM.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}