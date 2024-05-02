/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByCOABKGDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.04.11 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByCOABKGDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLocationMBByCOABKGData
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByCOABKGDataRSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("froms",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByCOABKGDataRSQL").append("\n"); 
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
		query.append("WITH LV_PARA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${tpsz_list} != '')" ).append("\n"); 
		query.append("#foreach ($user_tp_sz IN ${tpSzs})" ).append("\n"); 
		query.append("'$user_tp_sz' AS TS$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trade_cd} != '')" ).append("\n"); 
		query.append("#foreach ($user_trd_cd IN ${tradeCds})" ).append("\n"); 
		query.append("#if($velocityCount < $tradeCds.size())" ).append("\n"); 
		query.append("'$user_trd_cd' AS TRD$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_trd_cd' AS TRD$velocityCount" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("LV_DATA0 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  C.ECC_CD FM_LOC_CD,E.ECC_CD TO_LOC_CD," ).append("\n"); 
		query.append("DECODE(SUBSTR(A.SPCL_CNTR_TPSZ_CD,1,2),'RD',SUBSTR(A.SPCL_CNTR_TPSZ_CD,1,1)||SUBSTR(A.SPCL_CNTR_TPSZ_CD,3,1),A.SPCL_CNTR_TPSZ_CD) TPSZ," ).append("\n"); 
		query.append("A.TRD_CD," ).append("\n"); 
		query.append("ROUND(SUM(ROUND(A.BKG_QTY,0)),0) QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COA_BKG_EXPN_DTL_WK A , MDM_LOCATION B, MDM_EQ_ORZ_CHT C , MDM_LOCATION D, MDM_EQ_ORZ_CHT E" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${period} == 'W')" ).append("\n"); 
		query.append("AND SUBSTR(A.SLS_YRMON,1,4)||A.COST_WK BETWEEN REPLACE(@[froms], '-', '') AND REPLACE(@[tos], '-', '')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.SLS_YRMON BETWEEN REPLACE(@[froms], '-', '') AND REPLACE(@[tos], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND A.BKG_STS_CD    IN ('F','S',NULL)" ).append("\n"); 
		query.append("AND A.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("AND A.BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("#if (${trade_cd} != '')" ).append("\n"); 
		query.append("AND A.TRD_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach ($user_trd_cd IN ${tradeCds})" ).append("\n"); 
		query.append("#if($velocityCount < $tradeCds.size())" ).append("\n"); 
		query.append("'$user_trd_cd'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_trd_cd'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.BKG_POR_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND B.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("AND A.BKG_DEL_CD = D.LOC_CD" ).append("\n"); 
		query.append("AND D.SCC_CD = E.SCC_CD" ).append("\n"); 
		query.append("AND (C.ECC_CD IN (SELECT ECC_CD" ).append("\n"); 
		query.append("FROM CIM_COA_MTCH_BAK_LOC" ).append("\n"); 
		query.append("WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("OR E.ECC_CD IN (SELECT ECC_CD" ).append("\n"); 
		query.append("FROM CIM_COA_MTCH_BAK_LOC" ).append("\n"); 
		query.append("WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND USE_FLG = 'Y'))" ).append("\n"); 
		query.append("#if (${tpsz} == 'R')" ).append("\n"); 
		query.append("#if (${rdtype} == 'E')" ).append("\n"); 
		query.append("AND A.SPCL_CNTR_TPSZ_CD IN ('R2','R5')" ).append("\n"); 
		query.append("#elseif (${rdtype} == 'O')" ).append("\n"); 
		query.append("AND A.SPCL_CNTR_TPSZ_CD IN ('RD2','RD5')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.SPCL_CNTR_TPSZ_CD IN ('RD2','RD5','R2','R5')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${tpsz_list} != '')" ).append("\n"); 
		query.append("AND A.SPCL_CNTR_TPSZ_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach ($user_tp_sz IN ${tpSzs})" ).append("\n"); 
		query.append("#if($velocityCount < $tpSzs.size())" ).append("\n"); 
		query.append("'$user_tp_sz'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_tp_sz'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${soc} == 'E')" ).append("\n"); 
		query.append("AND A.SOC_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${soc} == 'O')" ).append("\n"); 
		query.append("AND A.SOC_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY C.ECC_CD,E.ECC_CD,A.SPCL_CNTR_TPSZ_CD,A.TRD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LV_DATA1 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT LOC_CD,TPSZ,TRD_CD,SUM(DECODE(SEQ,1,QTY,0)) IB_QTY, SUM(DECODE(SEQ,2,QTY,0)) OB_QTY" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT DECODE(SEQ,1,TO_LOC_CD,FM_LOC_CD) LOC_CD,TPSZ,SEQ,TRD_CD,SUM(QTY) QTY" ).append("\n"); 
		query.append("FROM LV_DATA0 , (SELECT LEVEL SEQ FROM DUAL CONNECT BY LEVEL<=2)" ).append("\n"); 
		query.append("GROUP BY DECODE(SEQ,1,TO_LOC_CD,FM_LOC_CD),TPSZ,SEQ,TRD_CD" ).append("\n"); 
		query.append("ORDER BY DECODE(SEQ,1,TO_LOC_CD,FM_LOC_CD),TPSZ,SEQ,TRD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE LOC_CD IN (SELECT ECC_CD" ).append("\n"); 
		query.append("FROM CIM_COA_MTCH_BAK_LOC" ).append("\n"); 
		query.append("WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("GROUP BY LOC_CD,TPSZ,TRD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LV_DATA2 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT LOC_CD," ).append("\n"); 
		query.append("IB_QTY0," ).append("\n"); 
		query.append("OB_QTY0," ).append("\n"); 
		query.append("CIM_MB_RAT_FNC(IB_QTY0,OB_QTY0,2) MB_QTY0," ).append("\n"); 
		query.append("#if (${trade_cd} != '')" ).append("\n"); 
		query.append("#foreach ($user_trd_cd IN ${tradeCds})" ).append("\n"); 
		query.append("#set ($tradeCount = $velocityCount)" ).append("\n"); 
		query.append("#foreach ($user_tp_sz IN ${tpSzs})" ).append("\n"); 
		query.append("#if($tradeCount == $tradeCds.size() && $velocityCount == $tpSzs.size())" ).append("\n"); 
		query.append("IB_QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("OB_QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("DECODE(SIGN(IB_QTY${tradeCount}_$velocityCount - OB_QTY${tradeCount}_$velocityCount),-1,DECODE(OB_QTY${tradeCount}_$velocityCount,0,0,(-1*IB_QTY${tradeCount}_$velocityCount)/OB_QTY${tradeCount}_$velocityCount),DECODE(IB_QTY${tradeCount}_$velocityCount,0,0,OB_QTY${tradeCount}_$velocityCount/IB_QTY${tradeCount}_$velocityCount))*100 MB_QTY${tradeCount}_$velocityCount" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("IB_QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("OB_QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("DECODE(SIGN(IB_QTY${tradeCount}_$velocityCount - OB_QTY${tradeCount}_$velocityCount),-1,DECODE(OB_QTY${tradeCount}_$velocityCount,0,0,(-1*IB_QTY${tradeCount}_$velocityCount)/OB_QTY${tradeCount}_$velocityCount),DECODE(IB_QTY${tradeCount}_$velocityCount,0,0,OB_QTY${tradeCount}_$velocityCount/IB_QTY${tradeCount}_$velocityCount))*100 MB_QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT LOC_CD," ).append("\n"); 
		query.append("SUM(IB_QTY) IB_QTY0," ).append("\n"); 
		query.append("SUM(OB_QTY) OB_QTY0," ).append("\n"); 
		query.append("#if (${trade_cd} != '')" ).append("\n"); 
		query.append("#foreach ($user_trd_cd IN ${tradeCds})" ).append("\n"); 
		query.append("#set ($tradeCount = $velocityCount)" ).append("\n"); 
		query.append("#foreach ($user_tp_sz IN ${tpSzs})" ).append("\n"); 
		query.append("#if($tradeCount == $tradeCds.size() && $velocityCount == $tpSzs.size())" ).append("\n"); 
		query.append("SUM(DECODE(TRD_CD,TRD${tradeCount},DECODE(TPSZ,TS$velocityCount,IB_QTY,0),0)) IB_QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("SUM(DECODE(TRD_CD,TRD${tradeCount},DECODE(TPSZ,TS$velocityCount,OB_QTY,0),0)) OB_QTY${tradeCount}_$velocityCount" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SUM(DECODE(TRD_CD,TRD${tradeCount},DECODE(TPSZ,TS$velocityCount,IB_QTY,0),0)) IB_QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("SUM(DECODE(TRD_CD,TRD${tradeCount},DECODE(TPSZ,TS$velocityCount,OB_QTY,0),0)) OB_QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM LV_DATA1 , LV_PARA B" ).append("\n"); 
		query.append("GROUP BY ROLLUP(LOC_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'HEADER' AS LOC_CD," ).append("\n"); 
		query.append("#if (${trade_cd} != '')" ).append("\n"); 
		query.append("'qty0,' ||" ).append("\n"); 
		query.append("#foreach ($user_trd_cd IN ${tradeCds})" ).append("\n"); 
		query.append("#set ($tradeCount = $velocityCount)" ).append("\n"); 
		query.append("#foreach ($user_tp_sz IN ${tpSzs})" ).append("\n"); 
		query.append("#if($tradeCount == $tradeCds.size() && $velocityCount == $tpSzs.size())" ).append("\n"); 
		query.append("'qty${tradeCount}_$velocityCount' AS DIV," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'qty${tradeCount}_$velocityCount,' ||" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("0 AS QTY0," ).append("\n"); 
		query.append("#if (${trade_cd} != '')" ).append("\n"); 
		query.append("#foreach ($user_trd_cd IN ${tradeCds})" ).append("\n"); 
		query.append("#set ($tradeCount = $velocityCount)" ).append("\n"); 
		query.append("#foreach ($user_tp_sz IN ${tpSzs})" ).append("\n"); 
		query.append("#if($tradeCount == $tradeCds.size() && $velocityCount == $tpSzs.size())" ).append("\n"); 
		query.append("0 AS QTY${tradeCount}_$velocityCount" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("0 AS QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_CD,DIV,QTY0," ).append("\n"); 
		query.append("#if (${trade_cd} != '')" ).append("\n"); 
		query.append("#foreach ($user_trd_cd IN ${tradeCds})" ).append("\n"); 
		query.append("#set ($tradeCount = $velocityCount)" ).append("\n"); 
		query.append("#foreach ($user_tp_sz IN ${tpSzs})" ).append("\n"); 
		query.append("#if($tradeCount == $tradeCds.size() && $velocityCount == $tpSzs.size())" ).append("\n"); 
		query.append("QTY${tradeCount}_$velocityCount" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT LOC_CD," ).append("\n"); 
		query.append("#if(${work_type} == 'MBD1')" ).append("\n"); 
		query.append("'M/B Ratio(%)' DIV," ).append("\n"); 
		query.append("MAX(ROUND(MB_QTY0,1)) QTY0," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DECODE(SEQ,1,'I/B',2,'O/B',3,'Balance',4,'M/B Ratio(%)') DIV," ).append("\n"); 
		query.append("MAX(DECODE(SEQ,1,IB_QTY0,2,OB_QTY0,3,IB_QTY0-OB_QTY0,4,ROUND(MB_QTY0,1))) QTY0," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trade_cd} != '')" ).append("\n"); 
		query.append("#foreach ($user_trd_cd IN ${tradeCds})" ).append("\n"); 
		query.append("#set ($tradeCount = $velocityCount)" ).append("\n"); 
		query.append("#foreach ($user_tp_sz IN ${tpSzs})" ).append("\n"); 
		query.append("#if($tradeCount == $tradeCds.size() && $velocityCount == $tpSzs.size())" ).append("\n"); 
		query.append("#if(${work_type} == 'MBD1')" ).append("\n"); 
		query.append("MAX(ROUND(MB_QTY${tradeCount}_$velocityCount,1)) QTY${tradeCount}_$velocityCount" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MAX(DECODE(SEQ,1,IB_QTY${tradeCount}_$velocityCount,2,OB_QTY${tradeCount}_$velocityCount,3,IB_QTY${tradeCount}_$velocityCount - OB_QTY${tradeCount}_$velocityCount,4,ROUND(MB_QTY${tradeCount}_$velocityCount,1))) QTY${tradeCount}_$velocityCount" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${work_type} == 'MBD1')" ).append("\n"); 
		query.append("MAX(ROUND(MB_QTY${tradeCount}_$velocityCount,1)) QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MAX(DECODE(SEQ,1,IB_QTY${tradeCount}_$velocityCount,2,OB_QTY${tradeCount}_$velocityCount,3,IB_QTY${tradeCount}_$velocityCount - OB_QTY${tradeCount}_$velocityCount,4,ROUND(MB_QTY${tradeCount}_$velocityCount,1))) QTY${tradeCount}_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM LV_DATA2 ," ).append("\n"); 
		query.append("#if(${work_type} == 'MBD1')" ).append("\n"); 
		query.append("(SELECT LEVEL SEQ FROM DUAL CONNECT BY LEVEL <=1) B" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(SELECT LEVEL SEQ FROM DUAL CONNECT BY LEVEL <=4) B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY LOC_CD,SEQ" ).append("\n"); 
		query.append("ORDER BY LOC_CD,SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}