/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetAnchoringHourRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.06
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2014.03.06 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YOUNJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetAnchoringHourRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 해당 TDR 에서 Anchoring Hour을 구한다.
	  * ====================================================================
	  * 2011.04.05 CHM-201109983-01 진마리아 Anchoring Hours 로직을 시간 단위로 계산하도록 로직 수정
	  * 2014.03.06 CHM-201429135 이윤정 [PSO] Tariff simulation 로직 수정 - Achoring hour ( VSK_ACT_PORT_SKD 에 미존재 시 FCM_DEP_RPT 에서 조회)
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetAnchoringHourRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetAnchoringHourRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(SIGN(VAL),-1, 0, VAL), 0) -- 없으면 무조건 0 처리 요청 받음" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT MAX(" ).append("\n"); 
		query.append("               ROUND(" ).append("\n"); 
		query.append("--                   (NVL(BFR_BRTH_ANK_OFF_DT - BFR_BRTH_ANK_DRP_DT,0)" ).append("\n"); 
		query.append("--                  + NVL( AFT_UNBRTH_ANK_OFF_DT - AFT_UNBRTH_ANK_DRP_DT,0)) * 24, 2)" ).append("\n"); 
		query.append("                   (NVL(NVL(T1.BFR_BRTH_ANK_OFF_DT,T2.BFR_BRTH_ANK_OFF_DT) - NVL(T1.BFR_BRTH_ANK_DRP_DT,T2.BFR_BRTH_ANK_DRP_DT),0)" ).append("\n"); 
		query.append("                  + NVL(NVL(T1.AFT_UNBRTH_ANK_OFF_DT,T2.AFT_UNBRTH_ANK_OFF_DT) - NVL(T1.AFT_UNBRTH_ANK_DRP_DT,T2.AFT_UNBRTH_ANK_DRP_DT),0)) * 24, 2)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ) VAL" ).append("\n"); 
		query.append("    FROM VSK_ACT_PORT_SKD T1, FCM_DEP_RPT T2" ).append("\n"); 
		query.append("    WHERE (T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("                                                SELECT VSL_CD, " ).append("\n"); 
		query.append("                                                    DECODE(TURN_PORT_IND_CD, 'Y', SKD_VOY_NO, 'N', SKD_VOY_NO, TURN_SKD_VOY_NO) SKD_VOY_NO," ).append("\n"); 
		query.append("                                                    DECODE(TURN_PORT_IND_CD, 'Y', SKD_DIR_CD, 'N', SKD_DIR_CD, TURN_SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                                AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                                AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("                                                AND VPS_PORT_CD = SUBSTR(@[yd_cd], 1, 5))" ).append("\n"); 
		query.append("    AND T1.VPS_PORT_CD = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("    AND	T1.VSL_CD		    = T2.VSL_CD		    (+)" ).append("\n"); 
		query.append("    AND	T1.SKD_VOY_NO		= T2.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("    AND	T1.SKD_DIR_CD		= T2.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("    AND	T1.VPS_PORT_CD		= T2.DEP_PORT_CD	(+)" ).append("\n"); 
		query.append("    AND	T1.CLPT_IND_SEQ		= T2.CLPT_IND_SEQ	(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}