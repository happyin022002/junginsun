/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOGetYearlyVesselCallPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOGetYearlyVesselCallPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 당해년도 특정 port의 모든 선박(feeder 제외)의 calling count
	  * 2014.3.05 이윤정 [선반영] VPS_ETB_DT 기준 변경 (해당연도 1월1일 ~ 현재일)
	  * 2014.04.21 SKY [선반영] 조회 시점 VVD의 대상 Port의 ETB 기준으로 count를 할 수 있도록
	  * 로직 수정
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * [2015.12.03]MDM_VSL_CNTR.FDR_DIV_CD 조건 주석처리.
	  * [2015.03.18]Default 0 추가.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOGetYearlyVesselCallPortRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOGetYearlyVesselCallPortRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(COUNT(*),0), 0, 0, MAX(RNUM)) RNUM /*2015.03.18 Default 0 처리*/" ).append("\n"); 
		query.append("  FROM (SELECT ROW_NUMBER() OVER (ORDER BY VPS_ETA_DT) RNUM" ).append("\n"); 
		query.append("             , T1.VSL_CD" ).append("\n"); 
		query.append("             , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("             , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("             , T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("             , T2.VPS_PORT_CD" ).append("\n"); 
		query.append("             , T2.YD_CD" ).append("\n"); 
		query.append("             , T2.VPS_ETA_DT" ).append("\n"); 
		query.append("             , T2.VPS_ETB_DT" ).append("\n"); 
		query.append("             , T2.VPS_ETD_DT" ).append("\n"); 
		query.append("          FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("             , VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("             , MDM_VSL_CNTR T3" ).append("\n"); 
		query.append("             , MDM_VSL_SVC_LANE T4" ).append("\n"); 
		query.append("             , (SELECT VP.VSL_CD" ).append("\n"); 
		query.append("                     , VP.VPS_PORT_CD" ).append("\n"); 
		query.append("                     , MAX(TO_DATE(TO_CHAR(VP.VPS_ETB_DT,'YYYY')||'0101','YYYYMMDD')) MAX_VPS_ETB_DT" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD VP" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND VP.VSL_CD        = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                   AND VP.SKD_VOY_NO    = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                   AND VP.SKD_DIR_CD    = SUBSTR(@[vvd],9)" ).append("\n"); 
		query.append("                   AND VP.VPS_PORT_CD   = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("                   AND VP.YD_CD         = @[yd_cd]" ).append("\n"); 
		query.append("                   AND VP.CLPT_IND_SEQ  = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                   AND NVL(VP.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                 GROUP BY VP.VSL_CD" ).append("\n"); 
		query.append("                     , VP.VPS_PORT_CD" ).append("\n"); 
		query.append("                ) V" ).append("\n"); 
		query.append("         WHERE T1.VSL_CD        = T2.VSL_CD" ).append("\n"); 
		query.append("           AND T1.SKD_VOY_NO    = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND T1.SKD_DIR_CD    = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND T1.VSL_CD        = T3.VSL_CD" ).append("\n"); 
		query.append("           AND T1.VSL_SLAN_CD   = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND T2.VPS_PORT_CD   = V.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND T2.VPS_ETB_DT BETWEEN V.MAX_VPS_ETB_DT AND SYSDATE" ).append("\n"); 
		query.append("           AND T2.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("           AND NVL(T2.SKD_CNG_STS_CD,' ')   <> 'S'" ).append("\n"); 
		query.append("           AND NVL(T2.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND T4.VSL_SVC_TP_CD             <> 'O'" ).append("\n"); 
		query.append("       ) T" ).append("\n"); 
		query.append(" WHERE T.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND T.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND T.SKD_DIR_CD = SUBSTR(@[vvd],9)" ).append("\n"); 

	}
}