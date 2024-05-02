/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SimPortList retrieve
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimPortListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimPortListRSQL").append("\n"); 
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
		query.append("SELECT '' DEL_CHK" ).append("\n"); 
		query.append(",DECODE(NVL(C1.TML_CD,'XXXXXXX'), C1.TML_CD, 'R', 'I') STS_CD" ).append("\n"); 
		query.append(",C2.PORT_SEQ" ).append("\n"); 
		query.append(",C3.SLAN_CD" ).append("\n"); 
		query.append(",C3.SKD_DIR_CD" ).append("\n"); 
		query.append(",SUBSTR(C1.TML_CD,1,5) PORT_CD" ).append("\n"); 
		query.append(",SUBSTR(C1.TML_CD,6,7) PORT_YD" ).append("\n"); 
		query.append(",C4.YD_NM TMNL_NAME" ).append("\n"); 
		query.append(",NVL(C1.TURN_PORT_IND_CD,'Y') TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",NVL(DECODE(C1.TURN_PORT_IND_CD,'F', '0', C1.PORT_DYS),0) PORT_DYS" ).append("\n"); 
		query.append(",NVL(DECODE(C1.TURN_PORT_IND_CD,'F', '0', C1.SEA_DYS),0) SEA_DYS" ).append("\n"); 
		query.append(",NVL(C1.PORT_USD_AMT,0) PORT_USD_AMT" ).append("\n"); 
		query.append(",NVL(C1.ETB_DY_NO,0) ETB_DY_NO" ).append("\n"); 
		query.append(",NVL(C1.ETB_DY_CD,'MON') ETB_DY_CD" ).append("\n"); 
		query.append(",NVL(C1.ETB_TM_HRMNT,'00:00') ETB_TM_HRMNT" ).append("\n"); 
		query.append(",NVL(C1.ETD_DY_NO,0) ETD_DY_NO" ).append("\n"); 
		query.append(",NVL(C1.ETD_DY_CD,'MON') ETD_DY_CD" ).append("\n"); 
		query.append(",NVL(C1.ETD_TM_HRMNT,'00:00') ETD_TM_HRMNT" ).append("\n"); 
		query.append(",C1.LNK_DIST" ).append("\n"); 
		query.append(",C1.MNVR_IN_HRS" ).append("\n"); 
		query.append(",C1.MNVR_OUT_HRS" ).append("\n"); 
		query.append(",C1.LNK_SPD" ).append("\n"); 
		query.append(",C1.TZTM_HRS" ).append("\n"); 
		query.append(",C1.SEA_BUF_HRS" ).append("\n"); 
		query.append(",C1.ACT_WRK_HRS" ).append("\n"); 
		query.append(",C1.PORT_BUF_HRS" ).append("\n"); 
		query.append(",C1.IB_IPCGO_QTY" ).append("\n"); 
		query.append(",C1.OB_IPCGO_QTY" ).append("\n"); 
		query.append(",C1.IB_OCN_CGO_QTY" ).append("\n"); 
		query.append(",DECODE(NVL(C1.OB_OCN_CGO_QTY,0),0,DECODE(C2.PORT_SEQ, C2.MAX_SEQ, 0, C2.QTY2),C1.OB_OCN_CGO_QTY) OB_OCN_CGO_QTY -- VOLUME" ).append("\n"); 
		query.append(",C1.TML_PROD_QTY" ).append("\n"); 
		query.append(",C1.CRN_KNT" ).append("\n"); 
		query.append(",C1.VSL_DBL_CALL_SEQ" ).append("\n"); 
		query.append(",C1.PORT_SEQ" ).append("\n"); 
		query.append(",'' AS ZD" ).append("\n"); 
		query.append(",C1.SIM_DT" ).append("\n"); 
		query.append(",C1.SIM_NO" ).append("\n"); 
		query.append(",C2.VOL_CNT  ---" ).append("\n"); 
		query.append(",C3.EXTD_LANE_FLG" ).append("\n"); 
		query.append(",C1.BZC_VSL_SPD STND_SVC_SPD" ).append("\n"); 
		query.append(",NVL(C1.TURN_PORT_FLG,'Y') TURN_PORT_FLG" ).append("\n"); 
		query.append(",C1.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append(",C1.SEA_BUF_SPD" ).append("\n"); 
		query.append(",'' ROW_NUM" ).append("\n"); 
		query.append(",C1.TML_CD" ).append("\n"); 
		query.append(",C1.CRE_USR_ID" ).append("\n"); 
		query.append(",C1.UPD_USR_ID" ).append("\n"); 
		query.append(",C3.SVC_DUR_DYS" ).append("\n"); 
		query.append(",C3.BRTH_ITVAL_DYS" ).append("\n"); 
		query.append(",'' VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",'' VSL_CNT" ).append("\n"); 
		query.append(",'' MAX_SPEED" ).append("\n"); 
		query.append(",'' MIN_SPEED" ).append("\n"); 
		query.append("FROM MAS_SIM_TML_INFO C1" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",TML_CD" ).append("\n"); 
		query.append(",PORT_CD" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",PORT_SEQ" ).append("\n"); 
		query.append(",VOL_CNT" ).append("\n"); 
		query.append(",QTY" ).append("\n"); 
		query.append(",MAX_SEQ" ).append("\n"); 
		query.append(",DECODE(PORT_SEQ, MAX_SEQ, MIN_SEQ, PORT_SEQ) GG" ).append("\n"); 
		query.append(",SUM(QTY) OVER(PARTITION BY DECODE(PORT_SEQ, MAX_SEQ, MIN_SEQ, PORT_SEQ)) QTY2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B1.SIM_DT" ).append("\n"); 
		query.append(",B1.SIM_NO" ).append("\n"); 
		query.append(",B1.TML_CD" ).append("\n"); 
		query.append(",B2.PORT_CD" ).append("\n"); 
		query.append(",B1.SKD_DIR_CD" ).append("\n"); 
		query.append(",B1.PORT_SEQ" ).append("\n"); 
		query.append(",B2.VOL_CNT -- VOLUME 이 입력되고 나면 포트정보를 수정하지 못하도록 함" ).append("\n"); 
		query.append(",SUM(B2.PORT_PAIR_LOD_QTY/B2.FREQ_NO) QTY" ).append("\n"); 
		query.append(",MIN(B1.PORT_SEQ) OVER() MIN_SEQ" ).append("\n"); 
		query.append(",MAX(B1.PORT_SEQ) OVER() MAX_SEQ" ).append("\n"); 
		query.append("FROM MAS_SIM_TML_INFO B1" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A1.SIM_DT" ).append("\n"); 
		query.append(",A1.SIM_NO" ).append("\n"); 
		query.append(",A1.SKD_DIR_CD" ).append("\n"); 
		query.append(",DECODE(A3.NUM, 1, 'POL', 2, 'POD') CODE" ).append("\n"); 
		query.append(",DECODE(A3.NUM, 1, A2.POL_CD, 2, A2.POD_CD) PORT_CD" ).append("\n"); 
		query.append(",A2.PORT_PAIR_LOD_QTY" ).append("\n"); 
		query.append(",sum(A2.PORT_PAIR_LOD_QTY) over () VOL_CNT" ).append("\n"); 
		query.append(",A1.FREQ_NO" ).append("\n"); 
		query.append("FROM MAS_SIM_SVC_LANE A1" ).append("\n"); 
		query.append(",MAS_SIM_VOL_PRJ A2" ).append("\n"); 
		query.append(",(SELECT CPY_NO NUM" ).append("\n"); 
		query.append("FROM COM_CPY_NO" ).append("\n"); 
		query.append("WHERE CPY_NO BETWEEN 1 AND 2" ).append("\n"); 
		query.append(") A3" ).append("\n"); 
		query.append("WHERE A1.SIM_DT = A2.SIM_DT(+)" ).append("\n"); 
		query.append("AND A1.SIM_NO  = A2.SIM_NO(+)" ).append("\n"); 
		query.append("AND A1.SECT_NO = A2.SECT_NO(+)" ).append("\n"); 
		query.append("AND A1.SIM_DT  = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A1.SIM_NO  = @[f_sim_no]" ).append("\n"); 
		query.append(") B2" ).append("\n"); 
		query.append("WHERE B1.SIM_DT = B2.SIM_DT(+)" ).append("\n"); 
		query.append("AND B1.SIM_NO = B2.SIM_NO(+)" ).append("\n"); 
		query.append("--AND SUBSTR(B1.TML_CD,1,5) = B2.PORT_CD(+)" ).append("\n"); 
		query.append("AND B1.TML_CD like B2.PORT_CD||'%'" ).append("\n"); 
		query.append("AND B1.SKD_DIR_CD         = B2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND B1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND B1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("GROUP BY B1.SIM_DT" ).append("\n"); 
		query.append(",B1.SIM_NO" ).append("\n"); 
		query.append(",B1.TML_CD" ).append("\n"); 
		query.append(",B2.PORT_CD" ).append("\n"); 
		query.append(",B1.SKD_DIR_CD" ).append("\n"); 
		query.append(",B1.PORT_SEQ" ).append("\n"); 
		query.append(",B2.VOL_CNT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") C2" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT DISTINCT A1.SIM_DT, A1.SIM_NO, A2.SLAN_CD,A1.SKD_DIR_CD, MIN(A1.SECT_NO) SEQ, A2.EXTD_LANE_FLG, A2.SVC_DUR_DYS, A2.BRTH_ITVAL_DYS" ).append("\n"); 
		query.append("FROM MAS_SIM_SVC_LANE A1" ).append("\n"); 
		query.append(",MAS_SIM_INFO A2" ).append("\n"); 
		query.append("WHERE A1.SIM_DT = A2.SIM_DT" ).append("\n"); 
		query.append("AND A1.SIM_NO = A2.SIM_NO" ).append("\n"); 
		query.append("AND A1.SIM_DT = @[f_sim_dt]" ).append("\n"); 
		query.append("AND A1.SIM_NO = @[f_sim_no]" ).append("\n"); 
		query.append("GROUP BY A1.SIM_DT, A1.SIM_NO, A2.SLAN_CD, A1.SKD_DIR_CD , A2.EXTD_LANE_FLG, A2.SVC_DUR_DYS, A2.BRTH_ITVAL_DYS" ).append("\n"); 
		query.append(") C3" ).append("\n"); 
		query.append(",MDM_YARD C4" ).append("\n"); 
		query.append("WHERE C1.SIM_DT      = C2.SIM_DT(+)" ).append("\n"); 
		query.append("AND C1.SIM_NO      = C2.SIM_NO(+)" ).append("\n"); 
		query.append("AND C1.TML_CD      = C2.TML_CD(+)" ).append("\n"); 
		query.append("AND C1.SKD_DIR_CD  = C2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND C1.SIM_DT(+)   = C3.SIM_DT" ).append("\n"); 
		query.append("AND C1.SIM_NO(+)   = C3.SIM_NO" ).append("\n"); 
		query.append("AND C1.SKD_DIR_CD(+) = C3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C3.SIM_DT      = @[f_sim_dt]" ).append("\n"); 
		query.append("AND C3.SIM_NO      = @[f_sim_no]" ).append("\n"); 
		query.append("AND C1.TML_CD      = C4.YD_CD(+)" ).append("\n"); 
		query.append("ORDER BY C1.PORT_SEQ" ).append("\n"); 

	}
}