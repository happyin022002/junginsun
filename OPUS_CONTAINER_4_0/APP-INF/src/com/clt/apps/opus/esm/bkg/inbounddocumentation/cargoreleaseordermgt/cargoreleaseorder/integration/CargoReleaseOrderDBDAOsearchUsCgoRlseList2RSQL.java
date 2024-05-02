/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchUsCgoRlseList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchUsCgoRlseList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchUsCgoRlseList2RSQL(){
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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_tml_edi_snd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchUsCgoRlseList2RSQL").append("\n"); 
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
		query.append("	 BL_NO" ).append("\n"); 
		query.append("	,BKG_NO" ).append("\n"); 
		query.append("	,PCS_QTY" ).append("\n"); 
		query.append("	,VVD_CD" ).append("\n"); 
		query.append("	,POD_CD" ).append("\n"); 
		query.append("	,DEL_CD" ).append("\n"); 
		query.append("	,HUB_CD" ).append("\n"); 
		query.append("	,LAST_UP_DT" ).append("\n"); 
		query.append("	,FRT_CLT_FLG" ).append("\n"); 
		query.append("	,F_LAST_DT" ).append("\n"); 
		query.append("	,OBL_RDEM_FLG" ).append("\n"); 
		query.append("	,O_LAST_DT" ).append("\n"); 
		query.append("	,CSTMS_CLR_CD" ).append("\n"); 
		query.append("	,C_LAST_DT" ).append("\n"); 
		query.append("	,TML_SND" ).append("\n"); 
		query.append("	,TML_LAST_DT" ).append("\n"); 
		query.append("	,PRT_IND" ).append("\n"); 
		query.append("	,CUST_NM" ).append("\n"); 
		query.append("	,INTER_RMK" ).append("\n"); 
		query.append("	,DO_HLD_FLG" ).append("\n"); 
		query.append("	,OBL_TTL_KNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append(" 			   RANK" ).append("\n"); 
		query.append("			  ,ROW_NUMBER() OVER (PARTITION BY BKG_NO ORDER BY RANK ASC) RNUM" ).append("\n"); 
		query.append("			  ,BL_NO" ).append("\n"); 
		query.append("		      ,BKG_NO" ).append("\n"); 
		query.append("			  ,PCS_QTY" ).append("\n"); 
		query.append("			  ,VVD_CD" ).append("\n"); 
		query.append("			  ,POD_CD" ).append("\n"); 
		query.append("			  ,DEL_CD" ).append("\n"); 
		query.append("			  ,HUB_CD" ).append("\n"); 
		query.append("			  ,LAST_UP_DT" ).append("\n"); 
		query.append("			  ,FRT_CLT_FLG" ).append("\n"); 
		query.append("		      ,F_LAST_DT" ).append("\n"); 
		query.append("			  ,OBL_RDEM_FLG" ).append("\n"); 
		query.append("			  ,O_LAST_DT" ).append("\n"); 
		query.append("			  ,CSTMS_CLR_CD" ).append("\n"); 
		query.append("			  ,C_LAST_DT" ).append("\n"); 
		query.append("			  ,TML_SND" ).append("\n"); 
		query.append("			  ,TML_LAST_DT" ).append("\n"); 
		query.append("			  ,PRT_IND" ).append("\n"); 
		query.append("			  ,CUST_NM" ).append("\n"); 
		query.append("			  ,INTER_RMK" ).append("\n"); 
		query.append("			  ,DO_HLD_FLG" ).append("\n"); 
		query.append("			  ,OBL_TTL_KNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT /*+ LEADING(M) USE_NL(M N O P Q R) */  " ).append("\n"); 
		query.append("			       1 RANK," ).append("\n"); 
		query.append("			       M.BL_NO," ).append("\n"); 
		query.append("			       P.BKG_NO," ).append("\n"); 
		query.append("			       N.PCK_QTY PCS_QTY," ).append("\n"); 
		query.append("			       N.VSL_CD||N.SKD_VOY_NO||N.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("			       NVL(P.POD_CD, N.CSTMS_PORT_CD) AS POD_CD," ).append("\n"); 
		query.append("			       N.DEL_CD," ).append("\n"); 
		query.append("			       N.HUB_LOC_CD HUB_CD," ).append("\n"); 
		query.append("			       M.LAST_UP_DT," ).append("\n"); 
		query.append("			       M.FRT_CLT_FLG," ).append("\n"); 
		query.append("			       M.F_LAST_DT," ).append("\n"); 
		query.append("			       M.OBL_RDEM_FLG," ).append("\n"); 
		query.append("			       M.O_LAST_DT," ).append("\n"); 
		query.append("			       M.CSTMS_CLR_CD," ).append("\n"); 
		query.append("			       M.C_LAST_DT," ).append("\n"); 
		query.append("			       M.MRN_TML_EDI_SND_CD TML_SND," ).append("\n"); 
		query.append("			       M.TML_LAST_DT," ).append("\n"); 
		query.append("			       ' '  PRT_IND," ).append("\n"); 
		query.append("			           SUBSTR(REPLACE(REPLACE(O.CUST_NM, CHR(34), CHR(34)||CHR(34)), CHR(10), ' '), 1, 20) CUST_NM," ).append("\n"); 
		query.append("			       Q.INTER_RMK," ).append("\n"); 
		query.append("			       NVL(Q.DO_HLD_FLG,'N') AS DO_HLD_FLG," ).append("\n"); 
		query.append("			       R.BL_CPY_KNT AS OBL_TTL_KNT" ).append("\n"); 
		query.append("			  FROM" ).append("\n"); 
		query.append("			      (" ).append("\n"); 
		query.append("			             SELECT  /*+ USE_NL(A C) */" ).append("\n"); 
		query.append("			               C.BL_NO," ).append("\n"); 
		query.append("			               TO_CHAR(GREATEST(NVL(C.FRT_CLT_LST_DT,TO_DATE('00010101000001','YYYYMMDDHH24MISS'))," ).append("\n"); 
		query.append("			                                NVL(C.OBL_RDEM_LST_DT,TO_DATE('00010101000001','YYYYMMDDHH24MISS'))," ).append("\n"); 
		query.append("			                                NVL(C.CSTMS_CLR_LST_DT,TO_DATE('00010101000001','YYYYMMDDHH24MISS'))),'DDMonRR HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') LAST_UP_DT," ).append("\n"); 
		query.append("			               C.FRT_CLT_FLG," ).append("\n"); 
		query.append("			               TO_CHAR(C.FRT_CLT_LST_DT, 'DDMonRR HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') F_LAST_DT," ).append("\n"); 
		query.append("			               C.OBL_RDEM_FLG," ).append("\n"); 
		query.append("			               TO_CHAR(C.OBL_RDEM_LST_DT, 'DDMonRR HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') O_LAST_DT," ).append("\n"); 
		query.append("			               C.CSTMS_CLR_CD," ).append("\n"); 
		query.append("			               TO_CHAR(C.CSTMS_CLR_LST_DT, 'DDMonRR HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') C_LAST_DT," ).append("\n"); 
		query.append("			               C.MRN_TML_EDI_SND_CD," ).append("\n"); 
		query.append("			               TO_CHAR(C.MRN_TML_EDI_LST_SND_DT, 'DDMonRR HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') TML_LAST_DT," ).append("\n"); 
		query.append("			               ROWNUM" ).append("\n"); 
		query.append("			               FROM " ).append("\n"); 
		query.append("			             BKG_CGO_RLSE C" ).append("\n"); 
		query.append("			      ) M," ).append("\n"); 
		query.append("			       BKG_CSTMS_ADV_BL   N," ).append("\n"); 
		query.append("			       BKG_CSTMS_ADV_CUST O," ).append("\n"); 
		query.append("			       BKG_BOOKING        P," ).append("\n"); 
		query.append("			       BKG_DO_REF         Q," ).append("\n"); 
		query.append("			       BKG_BL_ISS         R" ).append("\n"); 
		query.append("			 WHERE N.CNT_CD(+)     = 'US'" ).append("\n"); 
		query.append("			 " ).append("\n"); 
		query.append("			 #if (${vvd} != '') " ).append("\n"); 
		query.append("			   AND N.VSL_CD     = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("			   AND N.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("			   AND N.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("			 " ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			#if (${pod_cd} != '')   " ).append("\n"); 
		query.append("			   AND N.POD_CD     = @[pod_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			#if (${del_cd} != '')" ).append("\n"); 
		query.append("			   AND N.DEL_CD     = @[del_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			#if (${hub_loc_cd} != '')" ).append("\n"); 
		query.append("			   AND N.HUB_LOC_CD = @[hub_loc_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${mrn_tml_edi_snd_cd} != '')" ).append("\n"); 
		query.append("			   AND DECODE(NVL(M.MRN_TML_EDI_SND_CD,'N'), 'R', 'Y', 'N') = @[mrn_tml_edi_snd_cd] " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${frt_clt_flg} != '')" ).append("\n"); 
		query.append("			   AND DECODE(NVL(M.FRT_CLT_FLG       ,'N'), 'Y', 'Y', 'N') = @[frt_clt_flg]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${obl_rdem_flg} != '')" ).append("\n"); 
		query.append("			   AND DECODE(NVL(M.OBL_RDEM_FLG      ,'N'), 'Y', 'Y', 'N') = @[obl_rdem_flg]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cstms_clr_cd} != '')" ).append("\n"); 
		query.append("			   AND (CASE WHEN @[cstms_clr_cd] = 'J' THEN M.CSTMS_CLR_CD" ).append("\n"); 
		query.append("			          ELSE DECODE(M.CSTMS_CLR_CD,'E','Y','J','Y','T','Y','I','Y','W','Y','Y','Y','N') " ).append("\n"); 
		query.append("			     END) = @[cstms_clr_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("			 " ).append("\n"); 
		query.append("			   AND M.BL_NO  = N.BL_NO(+)" ).append("\n"); 
		query.append("			   AND O.CNT_CD(+) = 'US'" ).append("\n"); 
		query.append("			   AND M.BL_NO  = O.BL_NO(+)" ).append("\n"); 
		query.append("			   AND O.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("			   AND M.BL_NO  = P.BL_NO" ).append("\n"); 
		query.append("			   AND P.BKG_NO = Q.BKG_NO(+)" ).append("\n"); 
		query.append("			   AND R.BKG_NO(+) = P.BKG_NO" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("            UNION " ).append("\n"); 
		query.append("		         SELECT" ).append("\n"); 
		query.append("		               2 RANK," ).append("\n"); 
		query.append("		               BKG.BL_NO," ).append("\n"); 
		query.append("		               BKG.BKG_NO," ).append("\n"); 
		query.append("		               DOC.PCK_QTY," ).append("\n"); 
		query.append("		               VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD," ).append("\n"); 
		query.append("		               BKG.POD_CD," ).append("\n"); 
		query.append("		               BKG.DEL_CD," ).append("\n"); 
		query.append("		               ''," ).append("\n"); 
		query.append("		               TO_CHAR(GREATEST(NVL(RLSE.FRT_CLT_LST_DT,TO_DATE('000101010001','YYYYMMDDHH24MI'))," ).append("\n"); 
		query.append("				                                NVL(RLSE.OBL_RDEM_LST_DT,TO_DATE('000101010001','YYYYMMDDHH24MI'))," ).append("\n"); 
		query.append("				                                NVL(RLSE.CSTMS_CLR_LST_DT,TO_DATE('000101010001','YYYYMMDDHH24MI'))),'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH') LAST_UP_DT," ).append("\n"); 
		query.append("				       RLSE.FRT_CLT_FLG FRT_CLT_FLG," ).append("\n"); 
		query.append("				       TO_CHAR(RLSE.FRT_CLT_LST_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH') F_LAST_DT,          " ).append("\n"); 
		query.append("				       RLSE.OBL_RDEM_FLG OBL_RDEM_FLG," ).append("\n"); 
		query.append("				       TO_CHAR(RLSE.OBL_RDEM_LST_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH') O_LAST_DT," ).append("\n"); 
		query.append("				       NVL(RLSE.CSTMS_CLR_CD,'X') CSTMS_CLR_CD," ).append("\n"); 
		query.append("				       TO_CHAR(RLSE.CSTMS_CLR_LST_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH') C_LAST_DT," ).append("\n"); 
		query.append("  	                   RLSE.MRN_TML_EDI_SND_CD TML_SND," ).append("\n"); 
		query.append("					   TO_CHAR(RLSE.MRN_TML_EDI_LST_SND_DT,'DDMonRR HH24:MI','NLS_DATE_LANGUAGE=ENGLISH') TML_LAST_DT," ).append("\n"); 
		query.append("		               ''," ).append("\n"); 
		query.append("		               CUST.CUST_NM CUST_NM," ).append("\n"); 
		query.append("				       DREF.INTER_RMK," ).append("\n"); 
		query.append("				       NVL(DREF.DO_HLD_FLG,'N') AS DO_HLD_FLG," ).append("\n"); 
		query.append("		               0" ).append("\n"); 
		query.append("		            FROM BKG_VVD VVD" ).append("\n"); 
		query.append("		               , BKG_BOOKING BKG" ).append("\n"); 
		query.append("		               , BKG_CGO_RLSE RLSE" ).append("\n"); 
		query.append("		               , BKG_DO_REF  DREF" ).append("\n"); 
		query.append("		               , BKG_BL_ISS  ISS" ).append("\n"); 
		query.append("   					   , BKG_CUSTOMER  CUST" ).append("\n"); 
		query.append("				       , BKG_BL_DOC  DOC" ).append("\n"); 
		query.append("		           WHERE 1=1" ).append("\n"); 
		query.append("		          #if (${vvd} != '') " ).append("\n"); 
		query.append("		             AND VVD.VSL_CD     = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("		  			 AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("		  			 AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("		          #end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		          #if (${pod_cd} != '')   " ).append("\n"); 
		query.append("		             AND VVD.POD_CD     = @[pod_cd]" ).append("\n"); 
		query.append("		          #end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("				  #if (${del_cd} != '')" ).append("\n"); 
		query.append("         		     AND BKG.DEL_CD     = @[del_cd]" ).append("\n"); 
		query.append("		          #end" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("		         " ).append("\n"); 
		query.append("		#if (${mrn_tml_edi_snd_cd} != '')" ).append("\n"); 
		query.append("		   AND DECODE(NVL(RLSE.MRN_TML_EDI_SND_CD,'N'), 'R', 'Y', 'N') = @[mrn_tml_edi_snd_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${frt_clt_flg} != '')" ).append("\n"); 
		query.append("		   AND DECODE(NVL(RLSE.FRT_CLT_FLG       ,'N'), 'Y', 'Y', 'N') = @[frt_clt_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${obl_rdem_flg} != '')" ).append("\n"); 
		query.append("		   AND DECODE(NVL(RLSE.OBL_RDEM_FLG      ,'N'), 'Y', 'Y', 'N') = @[obl_rdem_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${cstms_clr_cd} != '')" ).append("\n"); 
		query.append("		   AND (CASE WHEN @[cstms_clr_cd] = 'J' THEN RLSE.CSTMS_CLR_CD" ).append("\n"); 
		query.append("		          ELSE DECODE(RLSE.CSTMS_CLR_CD,'E','Y','J','Y','T','Y','I','Y','W','Y','Y','Y','N') " ).append("\n"); 
		query.append("		     END) = @[cstms_clr_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		            AND VVD.BKG_NO     = BKG.BKG_NO" ).append("\n"); 
		query.append("		            AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("		            AND BKG.BL_NO      = RLSE.BL_NO(+)" ).append("\n"); 
		query.append("		            AND BKG.BKG_NO      = DREF.BKG_NO(+)" ).append("\n"); 
		query.append("		            AND BKG.BKG_NO      = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("    AND BKG.BKG_NO     = CUST.BKG_NO(+)" ).append("\n"); 
		query.append("    AND CUST.BKG_CUST_TP_CD(+) ='C'" ).append("\n"); 
		query.append("    AND BKG.BKG_NO     = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("    AND BKG.BKG_NO      = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("    AND BKG.BKG_NO     = CUST.BKG_NO(+)" ).append("\n"); 
		query.append("    AND CUST.BKG_CUST_TP_CD(+) ='C'" ).append("\n"); 
		query.append("    AND BKG.BKG_NO     = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("	WHERE RNUM = 1" ).append("\n"); 

	}
}