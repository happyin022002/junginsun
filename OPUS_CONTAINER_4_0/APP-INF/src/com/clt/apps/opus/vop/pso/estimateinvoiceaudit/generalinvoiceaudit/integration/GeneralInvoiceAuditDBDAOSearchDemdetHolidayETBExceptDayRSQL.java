/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchDemdetHolidayETBExceptDayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
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

public class GeneralInvoiceAuditDBDAOSearchDemdetHolidayETBExceptDayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD/Port의 ETB를 이용하여 휴일인지 조회한다.
	  * ----------------------------------------------------------
	  * 2010.12.08 CHM-201007132-01 이석준 신규추가
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchDemdetHolidayETBExceptDayRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchDemdetHolidayETBExceptDayRSQL").append("\n"); 
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
		query.append("SELECT ''''||MAX(NVL(DD,'N'))||''''" ).append("\n"); 
		query.append("  FROM (SELECT DECODE(CNT,0,'N','Y') DD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                -- 휴일 등록을 한경우" ).append("\n"); 
		query.append("                SELECT /*+ NO_EXPAND INDEX_DESC ( D XPKDMT_HOLIDAY ) */" ).append("\n"); 
		query.append("                       COUNT(*) CNT" ).append("\n"); 
		query.append("                  FROM DMT_HOLIDAY D" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                     , MDM_LOCATION L" ).append("\n"); 
		query.append("                 WHERE D.HOL_YR         = TO_CHAR(V.VPS_ETB_DT, 'YYYY')" ).append("\n"); 
		query.append("                   AND D.CNT_CD         = SUBSTR(V.VPS_PORT_CD,1,2)" ).append("\n"); 
		query.append("                   AND D.HOL_DT         = TRUNC(V.VPS_ETB_DT)" ).append("\n"); 
		query.append("                   AND V.VSL_CD         = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                   AND V.SKD_VOY_NO     = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                   AND V.SKD_DIR_CD     = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("                   AND V.YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("                   AND V.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                   AND NVL(V.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                   AND V.VPS_PORT_CD = L.LOC_CD" ).append("\n"); 
		query.append("                   AND D.RGN_CD IN (L.RGN_CD        , ' ')" ).append("\n"); 
		query.append("                   AND D.STE_CD IN (L.STE_CD        , ' ')" ).append("\n"); 
		query.append("                   AND D.LOC_CD IN (V.VPS_PORT_CD   , ' ') " ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}