/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwllNtfcExptItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwllNtfcExptItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDwllNtfcExptItem
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwllNtfcExptItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwllNtfcExptItemRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    A.SC_NO" ).append("\n"); 
		query.append(",   @[cust_cd] AS CUST_CD" ).append("\n"); 
		query.append(",   A.CTRT_PTY_NM" ).append("\n"); 
		query.append(",  CASE WHEN SIGN(DECODE(TML_DWLL_FLG,'Y',1,0) + DECODE(ENR_DWLL_FLG,'Y',1,0) + DECODE(DEST_DWLL_FLG,'Y',1,0) + DECODE(VSL_DLAY_FLG,'Y',1,0)) = 0 THEN NULL" ).append("\n"); 
		query.append("            ELSE TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', CTRT_EFF_DT, GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd])), 'YYYYMMDD')" ).append("\n"); 
		query.append("        END EFF_DT" ).append("\n"); 
		query.append(",  CASE WHEN SIGN(DECODE(TML_DWLL_FLG,'Y',1,0) + DECODE(ENR_DWLL_FLG,'Y',1,0) + DECODE(DEST_DWLL_FLG,'Y',1,0) + DECODE(VSL_DLAY_FLG,'Y',1,0)) = 0 THEN NULL" ).append("\n"); 
		query.append("            WHEN TO_EFF_DT >= '99991230' THEN TO_EFF_DT" ).append("\n"); 
		query.append("            ELSE TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', CTRT_EXP_DT, GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd])), 'YYYYMMDD')" ).append("\n"); 
		query.append("        END EXP_DT" ).append("\n"); 
		query.append(",   DECODE(TML_DWLL_FLG,'Y',1,0) TML_DWLL_FLG" ).append("\n"); 
		query.append(",   DECODE(ENR_DWLL_FLG,'Y',1,0) ENR_DWLL_FLG" ).append("\n"); 
		query.append(",   DECODE(DEST_DWLL_FLG,'Y',1,0) DEST_DWLL_FLG" ).append("\n"); 
		query.append(",   DECODE(VSL_DLAY_FLG,'Y',1,0) VSL_DLAY_FLG" ).append("\n"); 
		query.append(",   DWLL_EXPT_RMK, EXPT_SET_USR_ID, TO_CHAR(EXPT_SET_DT, 'YYYY-MM-DD HH24:MI:SS') EXPT_SET_DT" ).append("\n"); 
		query.append(",   (SELECT U.USR_NM FROM COM_USER U WHERE U.USR_ID = SEXP.EXPT_SET_USR_ID) EXPT_SET_USR_NAME" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    *" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            ROW_NUMBER() OVER ( PARTITION BY CUST_CNT_CD, CUST_SEQ ORDER BY HDR.CRE_DT DESC, PTY.AMDT_SEQ DESC) SEL_SEQ" ).append("\n"); 
		query.append("        ,   PTY.PROP_NO" ).append("\n"); 
		query.append("        ,   PTY.AMDT_SEQ" ).append("\n"); 
		query.append("        ,   HDR.SC_NO" ).append("\n"); 
		query.append("        ,   PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("        ,   PTY.CUST_SEQ" ).append("\n"); 
		query.append("        ,   PTY.CTRT_PTY_NM" ).append("\n"); 
		query.append("        ,   PTY.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("        , CTRT_EFF_DT" ).append("\n"); 
		query.append("        , CTRT_EXP_DT" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("        ,   PRI_SP_HDR HDR" ).append("\n"); 
		query.append("        ,   PRI_SP_DUR DUR" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND PTY.PRC_CTRT_PTY_TP_CD='C'" ).append("\n"); 
		query.append("        AND SUBSTR(HDR.SC_NO, 1,3) IN ('AEF', 'AEN', 'ANW','ASE','AWE','ASW', 'AWN', 'GLO', 'SAN', 'SAS', 'CEN','ANW','CEF','MME')" ).append("\n"); 
		query.append("        AND HDR.PROP_NO = PTY.PROP_NO    " ).append("\n"); 
		query.append("        AND PTY.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("        AND PTY.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE SEL_SEQ=1" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append(",   SCE_DWLL_NTFC_CUST_EXPT SEXP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SEXP.DWLL_CUST_CNT_CD = A.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND SEXP.DWLL_CUST_SEQ = A.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND SEXP.DWLL_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND SEXP.DWLL_CUST_SEQ = SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("ORDER BY A.SC_NO" ).append("\n"); 

	}
}