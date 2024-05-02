/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterStandardPrimeCostDAOFmsStndHirBseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.23 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterStandardPrimeCostDAOFmsStndHirBseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hire Creation Select
	  * </pre>
	  */
	public TCharterStandardPrimeCostDAOFmsStndHirBseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hb_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration").append("\n"); 
		query.append("FileName : TCharterStandardPrimeCostDAOFmsStndHirBseRSQL").append("\n"); 
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
		query.append("SELECT A.FLET_CTRT_NO," ).append("\n"); 
		query.append("A.HB_YRMON," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("B.VSL_ENG_NM," ).append("\n"); 
		query.append("C.VSL_CNT_CD," ).append("\n"); 
		query.append("A.VSL_DZND_CAPA," ).append("\n"); 
		query.append("A.BSE_14TON_VSL_CAPA," ).append("\n"); 
		query.append("A.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("A.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("A.VSL_DZND_TTL_QTY," ).append("\n"); 
		query.append("A.BSE_14TON_VSL_TTL_QTY," ).append("\n"); 
		query.append("A.HIR_RT_TTL_AMT," ).append("\n"); 
		query.append("(A.HIR_RT_TTL_AMT / A.VSL_DZND_TTL_QTY) MAX_TEU_RT_AMT," ).append("\n"); 
		query.append("DECODE(D.HIR_APLY_FLG,'Y', TRUNC((A.HIR_RT_TTL_AMT / A.VSL_DZND_TTL_QTY) * A.VSL_DZND_CAPA, 2)," ).append("\n"); 
		query.append("(A.HIR_RT_N1ST_AMT + A.HIR_RT_N2ND_AMT)) STND_MAX_HIR_AMT," ).append("\n"); 
		query.append("DECODE(D.HIR_APLY_FLG,'Y', TRUNC((A.HIR_RT_TTL_AMT / A.VSL_DZND_TTL_QTY) * A.VSL_DZND_CAPA, 2)," ).append("\n"); 
		query.append("(A.HIR_RT_N1ST_AMT + A.HIR_RT_N2ND_AMT)) STND_MAX_HIR_AMT1," ).append("\n"); 
		query.append("DECODE(D.HIR_APLY_FLG,'Y', (A.HIR_RT_N1ST_AMT + A.HIR_RT_N2ND_AMT) -" ).append("\n"); 
		query.append("(TRUNC((A.HIR_RT_TTL_AMT / A.VSL_DZND_TTL_QTY) * A.VSL_DZND_CAPA, 2))," ).append("\n"); 
		query.append("0) DIFF_STND_MAX_HIR_AMT," ).append("\n"); 
		query.append("DECODE(D.HIR_APLY_FLG,'Y', (A.HIR_RT_N1ST_AMT + A.HIR_RT_N2ND_AMT) -" ).append("\n"); 
		query.append("(TRUNC((A.HIR_RT_TTL_AMT / A.VSL_DZND_TTL_QTY) * A.VSL_DZND_CAPA, 2))," ).append("\n"); 
		query.append("0) DIFF_STND_MAX_HIR_AMT1," ).append("\n"); 
		query.append("(A.HIR_RT_TTL_AMT / A.BSE_14TON_VSL_TTL_QTY) TEU_14TON_RT_AMT," ).append("\n"); 
		query.append("DECODE(D.HIR_APLY_FLG,'Y',TRUNC((A.HIR_RT_TTL_AMT / A.BSE_14TON_VSL_TTL_QTY) * A.BSE_14TON_VSL_CAPA, 2)," ).append("\n"); 
		query.append("(A.HIR_RT_N1ST_AMT + A.HIR_RT_N2ND_AMT)) STND_14TON_HIR_AMT," ).append("\n"); 
		query.append("DECODE(D.HIR_APLY_FLG,'Y',TRUNC((A.HIR_RT_TTL_AMT / A.BSE_14TON_VSL_TTL_QTY) * A.BSE_14TON_VSL_CAPA, 2)," ).append("\n"); 
		query.append("(A.HIR_RT_N1ST_AMT + A.HIR_RT_N2ND_AMT)) STND_14TON_HIR_AMT1," ).append("\n"); 
		query.append("DECODE(D.HIR_APLY_FLG,'Y', (A.HIR_RT_N1ST_AMT + A.HIR_RT_N2ND_AMT) -" ).append("\n"); 
		query.append("(TRUNC((A.HIR_RT_TTL_AMT / A.BSE_14TON_VSL_TTL_QTY) * A.BSE_14TON_VSL_CAPA, 2))," ).append("\n"); 
		query.append("0) DIFF_STND_14TON_HIR_AMT," ).append("\n"); 
		query.append("DECODE(D.HIR_APLY_FLG,'Y', (A.HIR_RT_N1ST_AMT + A.HIR_RT_N2ND_AMT) -" ).append("\n"); 
		query.append("(TRUNC((A.HIR_RT_TTL_AMT / A.BSE_14TON_VSL_TTL_QTY) * A.BSE_14TON_VSL_CAPA, 2))," ).append("\n"); 
		query.append("0) DIFF_STND_14TON_HIR_AMT1," ).append("\n"); 
		query.append("NVL((SELECT MKT_RT_AMT" ).append("\n"); 
		query.append("FROM FMS_MKT_RT" ).append("\n"); 
		query.append("WHERE MKT_RT_YRMON = @[hb_yrmon]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND A.VSL_DZND_CAPA BETWEEN RNG_FM_QTY AND RNG_TO_QTY" ).append("\n"); 
		query.append("AND ROWNUM = 1),0) MKT_RT_AMT," ).append("\n"); 
		query.append("C.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("DECODE(E.FLET_CTRT_NO,NULL,'I','U') SAVE_TYPE" ).append("\n"); 
		query.append("FROM FMS_STND_HIR_BSE A," ).append("\n"); 
		query.append("MDM_VSL_CNTR B," ).append("\n"); 
		query.append("FMS_CONTRACT C," ).append("\n"); 
		query.append("FMS_TEU_RNG D," ).append("\n"); 
		query.append("FMS_STND_HIR E" ).append("\n"); 
		query.append("WHERE A.HB_YRMON = @[hb_yrmon]" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND A.VSL_DZND_CAPA BETWEEN D.RNG_FM_QTY AND D.RNG_TO_QTY" ).append("\n"); 
		query.append("AND D.RNG_YR = SUBSTR(@[hb_yrmon],1,4)" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = E.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("AND A.HB_YRMON = E.HB_YRMON(+)" ).append("\n"); 
		query.append("AND A.VSL_CD = E.VSL_CD(+)" ).append("\n"); 
		query.append("ORDER BY C.FLET_CTRT_TP_CD, A.VSL_DZND_CAPA, A.VSL_CD" ).append("\n"); 

	}
}