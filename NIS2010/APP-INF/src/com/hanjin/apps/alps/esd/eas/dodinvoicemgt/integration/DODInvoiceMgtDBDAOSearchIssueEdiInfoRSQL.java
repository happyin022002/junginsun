/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchIssueEdiInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchIssueEdiInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchIssueEdiInfo
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchIssueEdiInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dod_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchIssueEdiInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(M.MRN_BL_TS_CD,'E','E','I','I','O') IMEX_CD" ).append("\n"); 
		query.append("      ,M.MF_REF_NO||M.MRN_CHK_NO||NVL(M.MF_SEQ_NO,'') MRNMSN_NO" ).append("\n"); 
		query.append("      ,D.BL_NO" ).append("\n"); 
		query.append("      ,D.BKG_NO" ).append("\n"); 
		query.append("      ,M.VSL_CD" ).append("\n"); 
		query.append("      ,M.SKD_VOY_NO||M.SKD_DIR_CD VSL_VOY_DIR" ).append("\n"); 
		query.append("      ,B.POL_CD POL_LOC" ).append("\n"); 
		query.append("      ,B.POD_CD POD_LOC" ).append("\n"); 
		query.append("      ,B.DEL_CD DEL_LOC" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(S.VPS_ETA_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("        WHERE S.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("        AND   S.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND   S.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND   S.VPS_PORT_CD= V.POD_CD" ).append("\n"); 
		query.append("        AND   S.CLPT_IND_SEQ= 1      ) ETA" ).append("\n"); 
		query.append("      ,'' ETD" ).append("\n"); 
		query.append("      ,(SELECT DECODE(D.INV_CURR_CD,'USD',G.USD_KRW_XCH_RT,'')" ).append("\n"); 
		query.append("        FROM GL_MON_XCH_RT G" ).append("\n"); 
		query.append("        WHERE G.CURR_CD='USD'" ).append("\n"); 
		query.append("        AND   G.ACCT_XCH_RT_YRMON=DECODE(D.AR_IF_FLG,'N',TO_CHAR(D.CRE_DT,'YYYYMM'),'Y',TO_CHAR(D.AR_IF_DT,'YYYYMM'))  " ).append("\n"); 
		query.append("        AND   G.DELT_FLG= 'N'" ).append("\n"); 
		query.append("        AND   G.ACCT_XCH_RT_LVL='1'  " ).append("\n"); 
		query.append("       ) CUR_RATE" ).append("\n"); 
		query.append("      ,DECODE(D.INV_CURR_CD,'USD',DECODE(D.AR_IF_FLG,'N',TO_CHAR(D.CRE_DT,'YYYYMM'),'Y',TO_CHAR(D.AR_IF_DT,'YYYYMM')),'') CUR_DT " ).append("\n"); 
		query.append("FROM EAS_DOD_INV_MN D, BKG_BOOKING B, BKG_VVD V, BKG_CSTMS_KR_MF_SEQ_NO M" ).append("\n"); 
		query.append("WHERE D.DOD_INV_NO = @[dod_inv_no]  " ).append("\n"); 
		query.append("AND   B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND   V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND   V.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("AND   M.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("AND   M.MF_CFM_FLG(+)   = 'Y'" ).append("\n"); 
		query.append("AND   M.MRN_BL_TS_CD(+) = 'I'" ).append("\n"); 
		query.append("AND   Not Exists ( SELECT 'X' FROM BKG_CSTMS_KR_MF_SEQ_NO SEQ " ).append("\n"); 
		query.append("                   WHERE SEQ.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                   AND   SEQ.MF_CFM_FLG   = 'Y' " ).append("\n"); 
		query.append("                   AND   SEQ.MRN_BL_TS_CD = 'I'" ).append("\n"); 
		query.append("                   AND   SEQ.CFM_DT > M.CFM_DT )" ).append("\n"); 

	}
}