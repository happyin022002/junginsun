/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCOPInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.16 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCOPInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for searching for COP INFO
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCOPInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_por_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_del_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCOPInfoRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_NM POR_NAME," ).append("\n"); 
		query.append("LOC_CD POR_CODE," ).append("\n"); 
		query.append("DECODE(CNT_CD, 'US', 'D', 'K') POR_AMSQUAL," ).append("\n"); 
		query.append("LOC_AMS_PORT_CD POR_AMSPORT" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND LOC_CD = @[e_por_loc]" ).append("\n"); 
		query.append(")POR_LOC" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LO.LOC_NM POL_NAME," ).append("\n"); 
		query.append("BVD.POL_CD POL_CODE," ).append("\n"); 
		query.append("DECODE(LO.CNT_CD, 'US', 'D', 'K') POL_AMSQUAL," ).append("\n"); 
		query.append("LO.LOC_AMS_PORT_CD POL_AMSPORT" ).append("\n"); 
		query.append("FROM MDM_LOCATION LO," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("BKG_VVD BVD ," ).append("\n"); 
		query.append("VSK_VSL_SKD SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BVD.BKG_NO = @[e_bkg_no]" ).append("\n"); 
		query.append("AND BVD.POL_CD = @[e_pol_loc]" ).append("\n"); 
		query.append("AND SKD.VSL_CD(+) = BVD.VSL_CD" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO(+) = BVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD(+) = BVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS.VSL_CD(+) = BVD.VSL_CD" ).append("\n"); 
		query.append("AND VPS.SKD_VOY_NO(+) = BVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VPS.SKD_DIR_CD(+) = BVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD(+) = @[e_pol_loc]" ).append("\n"); 
		query.append("AND NVL(VPS.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND LO.LOC_CD(+) = @[e_pol_loc] -- VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")POL_LOC" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LO.LOC_NM POD_NAME," ).append("\n"); 
		query.append("BVD.POD_CD POD_CODE," ).append("\n"); 
		query.append("DECODE(LO.CNT_CD, 'US', 'D', 'K') POD_AMSQUAL," ).append("\n"); 
		query.append("LO.LOC_AMS_PORT_CD POD_AMSPORT" ).append("\n"); 
		query.append("FROM MDM_LOCATION LO," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("BKG_VVD BVD ," ).append("\n"); 
		query.append("VSK_VSL_SKD SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BVD.BKG_NO = @[e_bkg_no]" ).append("\n"); 
		query.append("AND BVD.POD_CD = @[e_pod_loc]" ).append("\n"); 
		query.append("AND VPS.VSL_CD(+) = BVD.VSL_CD" ).append("\n"); 
		query.append("AND VPS.SKD_VOY_NO(+) = BVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VPS.SKD_DIR_CD(+) = BVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD(+) = @[e_pod_loc]" ).append("\n"); 
		query.append("AND NVL(VPS.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND LO.LOC_CD(+) = @[e_pod_loc] --VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")POD_LOC" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_NM DEL_NAME," ).append("\n"); 
		query.append("LOC_CD DEL_CODE," ).append("\n"); 
		query.append("DECODE(CNT_CD, 'US', 'D', 'K') DEL_AMSQUAL," ).append("\n"); 
		query.append("LOC_AMS_PORT_CD DEL_AMSPORT" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND LOC_CD = @[e_del_loc]" ).append("\n"); 
		query.append(")DEL_LOC" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT TO_CHAR(E_T, 'YYYYMMDDHH24MI') POR_ETD," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(E_T, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, E_T, 'GMT'), 'YYYYMMDDHH24MI'))) POR_ETD_GMT ," ).append("\n"); 
		query.append("TO_CHAR(A_T, 'YYYYMMDDHH24MI') POR_ATD," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(A_T, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, A_T, 'GMT'), 'YYYYMMDDHH24MI'))) POR_ATD_GMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.E_T," ).append("\n"); 
		query.append("A.A_T," ).append("\n"); 
		query.append("A.NOD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROWNUM F_ROW," ).append("\n"); 
		query.append("DECODE(B.RCV_TERM_CD, 'D', ESTM_DT + 4/24, ESTM_DT) E_T," ).append("\n"); 
		query.append("CASE WHEN DECODE(B.RCV_TERM_CD, 'D', ACT_DT + 4/24, ACT_DT) IS NULL" ).append("\n"); 
		query.append("AND D.ACT_STS_CD = 'F' THEN DECODE(B.RCV_TERM_CD, 'D', ESTM_DT + 4/24, ESTM_DT) ELSE DECODE(B.RCV_TERM_CD, 'D', ACT_DT + 4/24, ACT_DT) END A_T ," ).append("\n"); 
		query.append("SUBSTR(H.POR_NOD_CD, 0, 5) NOD," ).append("\n"); 
		query.append("D.ACT_CD," ).append("\n"); 
		query.append("D.COP_DTL_SEQ" ).append("\n"); 
		query.append("FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("SCE_COP_DTL D," ).append("\n"); 
		query.append("BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append("AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("AND H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND ( (B.RCV_TERM_CD = 'D'" ).append("\n"); 
		query.append("AND D.ACT_CD = 'MOTZAD')" ).append("\n"); 
		query.append("OR (B.RCV_TERM_CD <> 'D'" ).append("\n"); 
		query.append("AND SUBSTR(D.ACT_CD, 5, 1) = 'D') )" ).append("\n"); 
		query.append("ORDER BY D.COP_DTL_SEQ ASC ) A" ).append("\n"); 
		query.append("WHERE F_ROW = 1 )" ).append("\n"); 
		query.append(")POR_DATE" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(E_T1, 'YYYYMMDDHH24MI') POL_ETA," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(E_T1, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, E_T1, 'GMT'), 'YYYYMMDDHH24MI'))) POL_ETA_GMT ," ).append("\n"); 
		query.append("TO_CHAR(A_T1, 'YYYYMMDDHH24MI') POL_ATA," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(A_T1, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, A_T1, 'GMT'), 'YYYYMMDDHH24MI'))) POL_ATA_GMT ," ).append("\n"); 
		query.append("TO_CHAR(E_T2, 'YYYYMMDDHH24MI') POL_ETD," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(E_T2, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, E_T2, 'GMT'), 'YYYYMMDDHH24MI'))) POL_ETD_GMT ," ).append("\n"); 
		query.append("TO_CHAR(A_T2, 'YYYYMMDDHH24MI') POL_ATD," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(A_T2, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, A_T2, 'GMT'), 'YYYYMMDDHH24MI'))) POL_ATD_GMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.BEF_ESTM_DT E_T1 ," ).append("\n"); 
		query.append("CASE WHEN A.BEF_ACT_DT IS NULL" ).append("\n"); 
		query.append("AND A.BEF_COP_STS = 'F' THEN A.BEF_ESTM_DT ELSE A.BEF_ACT_DT END A_T1 ," ).append("\n"); 
		query.append("A.AFT_ESTM_DT E_T2 ," ).append("\n"); 
		query.append("CASE WHEN A.AFT_ACT_CD IS NULL" ).append("\n"); 
		query.append("AND A.AFT_COP_STS = 'F' THEN A.AFT_ESTM_DT ELSE A.AFT_ACT_CD END A_T2 ," ).append("\n"); 
		query.append("A.BEF_NOD_CD NOD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BEF_ESTM_DT," ).append("\n"); 
		query.append("BEF_ACT_DT," ).append("\n"); 
		query.append("BEF_NOD_CD," ).append("\n"); 
		query.append("BEF_COP_STS," ).append("\n"); 
		query.append("AFT_ESTM_DT," ).append("\n"); 
		query.append("AFT_ACT_CD," ).append("\n"); 
		query.append("AFT_NOD_CD," ).append("\n"); 
		query.append("AFT_COP_STS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT STND_EDI_STS_CD," ).append("\n"); 
		query.append("D.ESTM_DT ," ).append("\n"); 
		query.append("LAG(D.ESTM_DT, 1) --  POL TEMINAL ARRIVAL" ).append("\n"); 
		query.append("OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) BEF_ESTM_DT ," ).append("\n"); 
		query.append("LAG(D.ACT_DT, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) BEF_ACT_DT ," ).append("\n"); 
		query.append("LAG(SUBSTR(D.NOD_CD, 1, 5), 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) BEF_NOD_CD ," ).append("\n"); 
		query.append("LAG(D.ACT_STS_CD, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) BEF_COP_STS ," ).append("\n"); 
		query.append("LEAD(D.ESTM_DT, 1) -- POL VESSLE DEPARTURE" ).append("\n"); 
		query.append("OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) AFT_ESTM_DT ," ).append("\n"); 
		query.append("LEAD(D.ACT_DT, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) AFT_ACT_CD ," ).append("\n"); 
		query.append("LEAD(SUBSTR(D.NOD_CD, 1, 5), 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) AFT_NOD_CD ," ).append("\n"); 
		query.append("LEAD(D.ACT_STS_CD, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) AFT_COP_STS" ).append("\n"); 
		query.append("FROM SCE_COP_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE STND_EDI_STS_CD = 'AEL' ) A )" ).append("\n"); 
		query.append(")POL_DATE" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("TO_CHAR(e_t1, 'YYYYMMDDHH24MI') POD_ETA" ).append("\n"); 
		query.append(",DECODE(nod, NULL, ''," ).append("\n"); 
		query.append("DECODE(e_t1, NULL, ''," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(nod, e_t1, 'GMT')," ).append("\n"); 
		query.append("'YYYYMMDDHH24MI'))) POD_ETA_GMT" ).append("\n"); 
		query.append(",TO_CHAR(a_t1, 'YYYYMMDDHH24MI') POD_ATA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",DECODE(nod, NULL, ''," ).append("\n"); 
		query.append("DECODE(a_t1, NULL, ''," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(nod, a_t1, 'GMT')," ).append("\n"); 
		query.append("'YYYYMMDDHH24MI'))) POD_ATA_GMT" ).append("\n"); 
		query.append(",TO_CHAR(e_t2, 'YYYYMMDDHH24MI') POD_ETD" ).append("\n"); 
		query.append(",DECODE(nod, NULL, ''," ).append("\n"); 
		query.append("DECODE(e_t2, NULL, ''," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(nod, e_t2, 'GMT')," ).append("\n"); 
		query.append("'YYYYMMDDHH24MI'))) POD_ETD_GMT" ).append("\n"); 
		query.append(",TO_CHAR(a_t2, 'YYYYMMDDHH24MI') POD_ATD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",DECODE(nod, NULL, ''," ).append("\n"); 
		query.append("DECODE(a_t2, NULL, ''," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(nod, a_t2, 'GMT')," ).append("\n"); 
		query.append("'YYYYMMDDHH24MI'))) POD_ATD_GMT" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 2009.11.04 hkoh 추가 START" ).append("\n"); 
		query.append("select   case when sub_act_cd = 'V' then a.bef_estm_dt0" ).append("\n"); 
		query.append("when sub_act_cd = 'W' then a.bef_estm_dt" ).append("\n"); 
		query.append("end  e_t1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",case when sub_act_cd = 'V' then case when  a.bef_act_dt0 is null and a.bef_cop_sts0 = 'F' then a.bef_estm_dt0 else a.bef_act_dt0 end" ).append("\n"); 
		query.append("when sub_act_cd = 'W' then case when  a.bef_act_dt  is null and a.bef_cop_sts  = 'F' then a.bef_estm_dt  else a.bef_act_dt  end" ).append("\n"); 
		query.append("end  a_t1" ).append("\n"); 
		query.append("-- 2009.11.04 hkoh 추가 END. 하단 주석처리" ).append("\n"); 
		query.append(",a.aft_estm_dt e_t2" ).append("\n"); 
		query.append(",case when a.aft_act_cd is null and a.aft_cop_sts = 'F' then a.aft_estm_dt" ).append("\n"); 
		query.append("else a.aft_act_cd" ).append("\n"); 
		query.append("end a_t2" ).append("\n"); 
		query.append(",a.bef_nod_cd nod" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select bef_estm_dt0, bef_act_dt0, bef_nod_cd0, bef_cop_sts0," ).append("\n"); 
		query.append("bef_estm_dt,  bef_act_dt,  bef_nod_cd,  bef_cop_sts," ).append("\n"); 
		query.append("aft_estm_dt,  aft_act_cd,  aft_nod_cd,  aft_cop_sts ," ).append("\n"); 
		query.append("sub_act_cd" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select      stnd_edi_sts_cd, SUBSTR(act_cd,3,1) sub_act_cd , d.estm_dt" ).append("\n"); 
		query.append("-- 2009.11.04 hkoh 추가 START" ).append("\n"); 
		query.append(",LAG(d.estm_dt, 2)              --  T/S Port Depature(Water)/ POD arraival (Vessel)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_estm_dt0" ).append("\n"); 
		query.append(",LAG(d.act_dt, 2)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_act_dt0" ).append("\n"); 
		query.append(",LAG(substr(d.nod_cd,1,5), 2)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_nod_cd0" ).append("\n"); 
		query.append(",LAG(d.act_sts_cd, 2)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_cop_sts0" ).append("\n"); 
		query.append("-- 2009.11.04 hkoh 추가 END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LAG(d.estm_dt, 1)              --  pod teminal arrival(Water)/ Berthing(Vessel)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_estm_dt" ).append("\n"); 
		query.append(",LAG(d.act_dt, 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_act_dt" ).append("\n"); 
		query.append(",LAG(substr(d.nod_cd,1,5), 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_nod_cd" ).append("\n"); 
		query.append(",LAG(d.act_sts_cd, 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) bef_cop_sts" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LEAD(d.estm_dt, 1)             -- pod vessle departure" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) aft_estm_dt" ).append("\n"); 
		query.append(",LEAD(d.act_dt, 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) aft_act_cd" ).append("\n"); 
		query.append(",LEAD(substr(d.nod_cd,1,5), 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) aft_nod_cd" ).append("\n"); 
		query.append(",LEAD(d.act_sts_cd, 1)" ).append("\n"); 
		query.append("OVER (PARTITION BY d.cop_no" ).append("\n"); 
		query.append("ORDER  BY d.cop_no, d.cop_dtl_seq) aft_cop_sts" ).append("\n"); 
		query.append("from    sce_cop_dtl d" ).append("\n"); 
		query.append("where   d.cop_no = @[e_cop_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where stnd_edi_sts_cd = 'UVD'" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")POD_DATE" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(E_T, 'YYYYMMDDHH24MI') DEL_ETA," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(E_T, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, E_T, 'GMT'), 'YYYYMMDDHH24MI'))) DEL_ETA_GMT ," ).append("\n"); 
		query.append("TO_CHAR(A_T, 'YYYYMMDDHH24MI') DEL_ATA," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(A_T, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, A_T, 'GMT'), 'YYYYMMDDHH24MI'))) DEL_ATA_GMT," ).append("\n"); 
		query.append("DEL_NOD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ESTM_DT E_T," ).append("\n"); 
		query.append("CASE WHEN ACT_DT IS NULL" ).append("\n"); 
		query.append("AND D.ACT_STS_CD = 'F' THEN ESTM_DT ELSE ACT_DT END A_T ," ).append("\n"); 
		query.append("SUBSTR(H.DEL_NOD_CD, 0, 5) NOD ," ).append("\n"); 
		query.append("D.NOD_CD DEL_NOD" ).append("\n"); 
		query.append("FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("SCE_COP_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append("AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("AND H.DEL_NOD_CD = D.NOD_CD" ).append("\n"); 
		query.append("AND SUBSTR(D.ACT_CD, 5, 1) = 'A'" ).append("\n"); 
		query.append("AND ROWNUM = 1 )" ).append("\n"); 
		query.append(")DEL_DATE" ).append("\n"); 

	}
}