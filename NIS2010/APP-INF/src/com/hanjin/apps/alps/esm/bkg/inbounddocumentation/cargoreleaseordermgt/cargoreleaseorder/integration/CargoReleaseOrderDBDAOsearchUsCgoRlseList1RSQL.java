/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchUsCgoRlseList1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchUsCgoRlseList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchUsCgoRlseList1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchUsCgoRlseList1RSQL").append("\n"); 
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
		query.append("SELECT BL_NO," ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("	   POR_CD," ).append("\n"); 
		query.append("       PCS_QTY," ).append("\n"); 
		query.append("       VVD_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       HUB_CD," ).append("\n"); 
		query.append("       LAST_UP_DT," ).append("\n"); 
		query.append("       FRT_CLT_FLG," ).append("\n"); 
		query.append("       F_LAST_DT," ).append("\n"); 
		query.append("       OBL_RDEM_FLG," ).append("\n"); 
		query.append("       O_LAST_DT," ).append("\n"); 
		query.append("       CSTMS_CLR_CD," ).append("\n"); 
		query.append("       C_LAST_DT," ).append("\n"); 
		query.append("       TML_SND," ).append("\n"); 
		query.append("       TML_LAST_DT," ).append("\n"); 
		query.append("       PRT_IND," ).append("\n"); 
		query.append("       CUST_NM," ).append("\n"); 
		query.append("       INTER_RMK," ).append("\n"); 
		query.append("       DO_HLD_FLG," ).append("\n"); 
		query.append("       OBL_TTL_KNT," ).append("\n"); 
		query.append("       ACT_POD_CD" ).append("\n"); 
		query.append("  FROM (     " ).append("\n"); 
		query.append("		SELECT M.BL_NO," ).append("\n"); 
		query.append("		       P.BKG_NO," ).append("\n"); 
		query.append("				P.POR_CD," ).append("\n"); 
		query.append("		       N.PCK_QTY PCS_QTY," ).append("\n"); 
		query.append("		       NVL(N.VSL_CD||N.SKD_VOY_NO||N.SKD_DIR_CD,P.VSL_CD||P.SKD_VOY_NO||P.SKD_DIR_CD) AS VVD_CD," ).append("\n"); 
		query.append("		       NVL(N.CSTMS_PORT_CD,P.POD_CD) AS POD_CD," ).append("\n"); 
		query.append("               P.POD_CD AS ACT_POD_CD," ).append("\n"); 
		query.append("		       NVL(N.DEL_CD,P.DEL_CD) AS DEL_CD," ).append("\n"); 
		query.append("		       N.HUB_LOC_CD HUB_CD," ).append("\n"); 
		query.append("		       M.LAST_UP_DT," ).append("\n"); 
		query.append("		       M.FRT_CLT_FLG," ).append("\n"); 
		query.append("		       M.F_LAST_DT," ).append("\n"); 
		query.append("		       M.OBL_RDEM_FLG," ).append("\n"); 
		query.append("		       M.O_LAST_DT," ).append("\n"); 
		query.append("		       M.CSTMS_CLR_CD," ).append("\n"); 
		query.append("		       M.C_LAST_DT," ).append("\n"); 
		query.append("		       M.MRN_TML_EDI_SND_CD TML_SND," ).append("\n"); 
		query.append("		       M.TML_LAST_DT," ).append("\n"); 
		query.append("		       G.PRT_IND," ).append("\n"); 
		query.append("		       SUBSTR(REPLACE(REPLACE(O.CUST_NM, CHR(34), CHR(34)||CHR(34)), CHR(13)||CHR(10), ' '), 1, 20) CUST_NM," ).append("\n"); 
		query.append("		       Q.INTER_RMK," ).append("\n"); 
		query.append("		       NVL(Q.DO_HLD_FLG,'N') AS DO_HLD_FLG," ).append("\n"); 
		query.append("		       R.BL_CPY_KNT AS OBL_TTL_KNT," ).append("\n"); 
		query.append("               '1' AS OS_FLG" ).append("\n"); 
		query.append("		  FROM" ).append("\n"); 
		query.append("		      (" ).append("\n"); 
		query.append("		        SELECT C.BL_NO," ).append("\n"); 
		query.append("		               TO_CHAR(GREATEST(NVL(C.FRT_CLT_LST_DT,TO_DATE('000101010001','YYYYMMDDHH24MI'))," ).append("\n"); 
		query.append("		                                NVL(C.OBL_RDEM_LST_DT,TO_DATE('000101010001','YYYYMMDDHH24MI'))," ).append("\n"); 
		query.append("		                                NVL(C.CSTMS_CLR_LST_DT,TO_DATE('000101010001','YYYYMMDDHH24MI'))),'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH') LAST_UP_DT," ).append("\n"); 
		query.append("		               C.FRT_CLT_FLG," ).append("\n"); 
		query.append("		               TO_CHAR(C.FRT_CLT_LST_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH') F_LAST_DT,          " ).append("\n"); 
		query.append("		               C.OBL_RDEM_FLG," ).append("\n"); 
		query.append("		               TO_CHAR(C.OBL_RDEM_LST_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH') O_LAST_DT," ).append("\n"); 
		query.append("		               C.CSTMS_CLR_CD," ).append("\n"); 
		query.append("		               TO_CHAR(C.CSTMS_CLR_LST_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH') C_LAST_DT," ).append("\n"); 
		query.append("		               C.MRN_TML_EDI_SND_CD," ).append("\n"); 
		query.append("		               TO_CHAR(C.MRN_TML_EDI_LST_SND_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH') TML_LAST_DT" ).append("\n"); 
		query.append("		          FROM BKG_CGO_RLSE C" ).append("\n"); 
		query.append("		         WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		     ) M," ).append("\n"); 
		query.append("		       (SELECT DECODE(COUNT(*),0,'N','Y') PRT_IND" ).append("\n"); 
		query.append("		          FROM BKG_CSTMS_ADV_BL   A," ).append("\n"); 
		query.append("		               BKG_CSTMS_ADV_CNTR B," ).append("\n"); 
		query.append("		               BKG_CSTMS_ADV_BL   C," ).append("\n"); 
		query.append("		               BKG_CSTMS_ADV_CNTR D," ).append("\n"); 
		query.append("		               BKG_BOOKING        E," ).append("\n"); 
		query.append("		               BKG_CSTMS_ADV_IBD  F" ).append("\n"); 
		query.append("		         WHERE A.CNT_CD     = 'US'" ).append("\n"); 
		query.append("		           AND A.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("		           AND A.CNT_CD     = B.CNT_CD" ).append("\n"); 
		query.append("		           AND A.BL_NO      = B.BL_NO" ).append("\n"); 
		query.append("		           AND A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("		           AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("		           AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("		           AND A.CSTMS_POL_CD = C.CSTMS_POL_CD" ).append("\n"); 
		query.append("		           AND A.CSTMS_POD_CD = C.CSTMS_POD_CD" ).append("\n"); 
		query.append("		           AND C.CNT_CD       = 'US'" ).append("\n"); 
		query.append("		           AND C.CNT_CD       = D.CNT_CD" ).append("\n"); 
		query.append("		           AND C.BL_NO        = D.BL_NO" ).append("\n"); 
		query.append("		           AND A.BL_NO        <> C.BL_NO" ).append("\n"); 
		query.append("		           AND B.CNTR_NO      = D.CNTR_NO" ).append("\n"); 
		query.append("		           AND C.BKG_NO       = E.BKG_NO" ).append("\n"); 
		query.append("		           AND E.BKG_STS_CD   <> 'X'" ).append("\n"); 
		query.append("		           AND C.CNT_CD       = F.CNT_CD" ).append("\n"); 
		query.append("		           AND C.BL_NO        = F.BL_NO" ).append("\n"); 
		query.append("		           AND C.MF_NO IS NULL) G," ).append("\n"); 
		query.append("		       BKG_CSTMS_ADV_BL   N," ).append("\n"); 
		query.append("		       BKG_CSTMS_ADV_CUST O," ).append("\n"); 
		query.append("		       BKG_BOOKING        P," ).append("\n"); 
		query.append("		       BKG_DO_REF         Q," ).append("\n"); 
		query.append("		       BKG_BL_ISS         R" ).append("\n"); 
		query.append("		 WHERE N.CNT_CD = 'US'" ).append("\n"); 
		query.append("		   AND M.BL_NO  = N.BL_NO" ).append("\n"); 
		query.append("		   AND O.CNT_CD = 'US'" ).append("\n"); 
		query.append("		   AND M.BL_NO  = O.BL_NO" ).append("\n"); 
		query.append("		   AND O.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("		   AND M.BL_NO  = P.BL_NO" ).append("\n"); 
		query.append("		   AND P.BKG_NO = Q.BKG_NO(+)" ).append("\n"); 
		query.append("		   AND R.BKG_NO(+) = P.BKG_NO" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT MAX(C.BL_NO)," ).append("\n"); 
		query.append("               MAX(C.BKG_NO)," ).append("\n"); 
		query.append("				MAX(C.POR_CD)," ).append("\n"); 
		query.append("               0," ).append("\n"); 
		query.append("               MAX(C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD)," ).append("\n"); 
		query.append("               MAX(C.POD_CD)," ).append("\n"); 
		query.append("               MAX(C.POD_CD)," ).append("\n"); 
		query.append("               MAX(C.DEL_CD)," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               MAX(TO_CHAR(GREATEST(NVL(D.FRT_CLT_LST_DT,TO_DATE('000101010001','YYYYMMDDHH24MI'))," ).append("\n"); 
		query.append("		                                NVL(D.OBL_RDEM_LST_DT,TO_DATE('000101010001','YYYYMMDDHH24MI'))," ).append("\n"); 
		query.append("		                                NVL(D.CSTMS_CLR_LST_DT,TO_DATE('000101010001','YYYYMMDDHH24MI'))),'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH')) LAST_UP_DT," ).append("\n"); 
		query.append("		       MAX(D.FRT_CLT_FLG) FRT_CLT_FLG," ).append("\n"); 
		query.append("		       MAX(TO_CHAR(D.FRT_CLT_LST_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH')) F_LAST_DT,          " ).append("\n"); 
		query.append("		       MAX(D.OBL_RDEM_FLG) OBL_RDEM_FLG," ).append("\n"); 
		query.append("		       MAX(TO_CHAR(D.OBL_RDEM_LST_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH')) O_LAST_DT," ).append("\n"); 
		query.append("		       NVL(MAX(D.CSTMS_CLR_CD),'X') CSTMS_CLR_CD," ).append("\n"); 
		query.append("		       MAX(TO_CHAR(D.CSTMS_CLR_LST_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH')) C_LAST_DT," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("		       MAX(Q.INTER_RMK)," ).append("\n"); 
		query.append("		       NVL(MAX(Q.DO_HLD_FLG),'N') AS DO_HLD_FLG," ).append("\n"); 
		query.append("               0," ).append("\n"); 
		query.append("               '2'" ).append("\n"); 
		query.append("          FROM BKG_BOOKING      C," ).append("\n"); 
		query.append("               BKG_CGO_RLSE     D," ).append("\n"); 
		query.append("		       BKG_DO_REF       Q," ).append("\n"); 
		query.append("		       BKG_BL_ISS       R" ).append("\n"); 
		query.append("         WHERE C.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("           AND SUBSTR(C.POL_CD,1,2) <> 'US'" ).append("\n"); 
		query.append("           AND C.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND C.BL_NO      = D.BL_NO(+)" ).append("\n"); 
		query.append("		   AND C.BKG_NO     = Q.BKG_NO(+)" ).append("\n"); 
		query.append("		   AND C.BKG_NO     = R.BKG_NO(+)" ).append("\n"); 
		query.append("         ORDER BY OS_FLG" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("  AND BL_NO > ' '" ).append("\n"); 

	}
}