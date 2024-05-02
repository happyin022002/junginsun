/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScqListDBDAOsearchAwkBbCgoQlistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqListDBDAOsearchAwkBbCgoQlistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Awkward & Break Bulk Cargo Quotation List 조회
	  * 
	  * * History
	  * 2013.06.26 이혜민 [CHM-201325215] Special cargo Quotation System 수정 요청 - Service Scope 화면대상 조회 조건 및 결과Grid 상에 추가
	  * 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
	  * </pre>
	  */
	public ScqListDBDAOsearchAwkBbCgoQlistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toperiod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmperiod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration").append("\n"); 
		query.append("FileName : ScqListDBDAOsearchAwkBbCgoQlistRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("SVC_SCP_CD " ).append("\n"); 
		query.append(",SCQ_RQST_NO" ).append("\n"); 
		query.append(",SCQ_VER_NO" ).append("\n"); 
		query.append(",PROG_STS_CD" ).append("\n"); 
		query.append(",RQST_OFC_CD" ).append("\n"); 
		query.append(",RQST_SREP_CD" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",RCV_TERM_CD" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",APRO_OFC_CD" ).append("\n"); 
		query.append(",TP_CD" ).append("\n"); 
		query.append(",PROG_SEQ" ).append("\n"); 
		query.append(",PROG_DT" ).append("\n"); 
		query.append(",(SELECT SREP_NM NM" ).append("\n"); 
		query.append("          FROM MDM_SLS_REP" ).append("\n"); 
		query.append("         WHERE SREP_CD      = T.RQST_SREP_CD" ).append("\n"); 
		query.append("           AND SREP_STS_CD  = 'N'" ).append("\n"); 
		query.append("           AND ROWNUM <= 1) AS SREP_NM" ).append("\n"); 
		query.append(",(SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("         WHERE CUST_CNT_CD  = T.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ     = T.CUST_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM <= 1) AS CUST_NM" ).append("\n"); 
		query.append(",ACT_CUST_NM" ).append("\n"); 
		query.append(",(SELECT CMDT_NM " ).append("\n"); 
		query.append("          FROM MDM_COMMODITY " ).append("\n"); 
		query.append("         WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND CMDT_CD = T.CMDT_CD" ).append("\n"); 
		query.append("           AND ROWNUM <= 1) AS CMDT_NM " ).append("\n"); 
		query.append(",STS_CD " ).append("\n"); 
		query.append(",MEAS_SYS_CD" ).append("\n"); 
		query.append(",RQST_USR_NM" ).append("\n"); 
		query.append(",RQST_DT" ).append("\n"); 
		query.append(",APRO_USR_NM" ).append("\n"); 
		query.append(",APRO_DT" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MN.SVC_SCP_CD " ).append("\n"); 
		query.append("     , MN.SCQ_RQST_NO                      " ).append("\n"); 
		query.append("     , MN.SCQ_VER_NO                       " ).append("\n"); 
		query.append("     , MN.PROG_STS_CD                      " ).append("\n"); 
		query.append("     , MN.RQST_OFC_CD                      " ).append("\n"); 
		query.append("     , MN.RQST_SREP_CD  " ).append("\n"); 
		query.append("     , MN.POR_CD                                            " ).append("\n"); 
		query.append("     , MN.POL_CD                                              " ).append("\n"); 
		query.append("     , MN.POD_CD" ).append("\n"); 
		query.append("     , MN.DEL_CD                                                " ).append("\n"); 
		query.append("     , MN.CUST_CNT_CD                      " ).append("\n"); 
		query.append("     , MN.CUST_SEQ                         " ).append("\n"); 
		query.append("     , MN.RCV_TERM_CD                      " ).append("\n"); 
		query.append("     , MN.DE_TERM_CD                       " ).append("\n"); 
		query.append("--     , TO_CHAR(MN.PROP_EFF_DT,'YYYY-MM-DD') AS PROP_EFF_DT                     " ).append("\n"); 
		query.append("--     , TO_CHAR(MN.PROP_EXP_DT,'YYYY-MM-DD') AS PROP_EXP_DT                     " ).append("\n"); 
		query.append("--     , TO_CHAR(MN.APRO_EFF_DT,'YYYY-MM-DD') AS APRO_EFF_DT                     " ).append("\n"); 
		query.append("--     , TO_CHAR(MN.APRO_EXP_DT,'YYYY-MM-DD') AS APRO_EXP_DT                     " ).append("\n"); 
		query.append("     , MN.DELT_FLG                         " ).append("\n"); 
		query.append("     , MN.APRO_OFC_CD                         " ).append("\n"); 
		query.append("     , MN.ACT_CUST_NM                      " ).append("\n"); 
		query.append("     , PG.SPCL_CGO_TP_CD TP_CD                  " ).append("\n"); 
		query.append("     , PG.PROG_SEQ                                               " ).append("\n"); 
		query.append("     , PG.PROG_DT " ).append("\n"); 
		query.append("     , CGO.CMDT_CD " ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID       = 'CD03161'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = MN.PROG_STS_CD" ).append("\n"); 
		query.append("           AND ROWNUM <= 1) AS STS_CD                                " ).append("\n"); 
		query.append("	 , NVL ( MN.MEAS_SYS_CD, 'M' ) AS MEAS_SYS_CD" ).append("\n"); 
		query.append("     ,(	SELECT	U.USR_NM" ).append("\n"); 
		query.append("       	FROM	PRI_SCQ_PROG P" ).append("\n"); 
		query.append("			,	COM_USER U" ).append("\n"); 
		query.append("		WHERE	P.PROG_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("		AND 	P.SCQ_RQST_NO = MN.SCQ_RQST_NO " ).append("\n"); 
		query.append("        AND		P.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("		AND		P.SPCL_CGO_TP_CD = 'AK' " ).append("\n"); 
		query.append("		AND 	P.PROG_SEQ = ( SELECT MAX ( X.PROG_SEQ ) FROM PRI_SCQ_PROG X WHERE X.SCQ_RQST_NO = P.SCQ_RQST_NO AND X.SCQ_VER_NO = P.SCQ_VER_NO AND X.SPCL_CGO_TP_CD = 'AK' AND X.PROG_STS_CD IN ( 'Q', 'O' ) )" ).append("\n"); 
		query.append("      ) AS RQST_USR_NM" ).append("\n"); 
		query.append("     ,(	SELECT	TO_CHAR ( P.PROG_DT, 'YYYY-MM-DD HH24:MI:SS' )" ).append("\n"); 
		query.append("       	FROM	PRI_SCQ_PROG P" ).append("\n"); 
		query.append("		WHERE	P.SCQ_RQST_NO = MN.SCQ_RQST_NO " ).append("\n"); 
		query.append("        AND		P.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("		AND		P.SPCL_CGO_TP_CD = 'AK' " ).append("\n"); 
		query.append("		AND 	P.PROG_SEQ = ( SELECT MAX ( X.PROG_SEQ ) FROM PRI_SCQ_PROG X WHERE X.SCQ_RQST_NO = P.SCQ_RQST_NO AND X.SCQ_VER_NO = P.SCQ_VER_NO AND X.SPCL_CGO_TP_CD = 'AK' AND X.PROG_STS_CD IN ( 'Q', 'O' ) )" ).append("\n"); 
		query.append("      ) AS RQST_DT" ).append("\n"); 
		query.append("     ,(	SELECT	U.USR_NM" ).append("\n"); 
		query.append("       	FROM	PRI_SCQ_PROG P" ).append("\n"); 
		query.append("			,	COM_USER U" ).append("\n"); 
		query.append("		WHERE	P.PROG_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("		AND 	P.SCQ_RQST_NO = MN.SCQ_RQST_NO " ).append("\n"); 
		query.append("        AND		P.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("		AND		P.SPCL_CGO_TP_CD = 'AK' " ).append("\n"); 
		query.append("		AND 	P.PROG_SEQ = ( SELECT MAX ( X.PROG_SEQ ) FROM PRI_SCQ_PROG X WHERE X.SCQ_RQST_NO = P.SCQ_RQST_NO AND X.SCQ_VER_NO = P.SCQ_VER_NO AND X.SPCL_CGO_TP_CD = 'AK' AND X.PROG_STS_CD IN ( 'A', 'R' ) )" ).append("\n"); 
		query.append("      ) AS APRO_USR_NM" ).append("\n"); 
		query.append("     ,(	SELECT	TO_CHAR ( P.PROG_DT, 'YYYY-MM-DD HH24:MI:SS' )" ).append("\n"); 
		query.append("       	FROM	PRI_SCQ_PROG P" ).append("\n"); 
		query.append("		WHERE	P.SCQ_RQST_NO = MN.SCQ_RQST_NO " ).append("\n"); 
		query.append("        AND		P.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("		AND		P.SPCL_CGO_TP_CD = 'AK' " ).append("\n"); 
		query.append("		AND 	P.PROG_SEQ = ( SELECT MAX ( X.PROG_SEQ ) FROM PRI_SCQ_PROG X WHERE X.SCQ_RQST_NO = P.SCQ_RQST_NO AND X.SCQ_VER_NO = P.SCQ_VER_NO AND X.SPCL_CGO_TP_CD = 'AK' AND X.PROG_STS_CD IN ( 'A', 'R' ) )" ).append("\n"); 
		query.append("      ) AS APRO_DT" ).append("\n"); 
		query.append("  FROM PRI_SCQ_AWK_MN MN                   " ).append("\n"); 
		query.append("     , PRI_SCQ_PROG PG        " ).append("\n"); 
		query.append("     , PRI_SCQ_AWK_CGO CGO" ).append("\n"); 
		query.append("  where 1=1     " ).append("\n"); 
		query.append("   AND PG.SCQ_RQST_NO = MN.SCQ_RQST_NO     " ).append("\n"); 
		query.append("   AND PG.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("   AND PG.SPCL_CGO_TP_CD = 'AK' " ).append("\n"); 
		query.append("   AND PG.SCQ_RQST_NO = CGO.SCQ_RQST_NO" ).append("\n"); 
		query.append("   AND PG.SCQ_VER_NO = CGO.SCQ_VER_NO" ).append("\n"); 
		query.append("   AND PG.SCQ_VER_NO = (SELECT MAX(SCQ_VER_NO) FROM PRI_SCQ_AWK_MN WHERE SCQ_RQST_NO = MN.SCQ_RQST_NO )" ).append("\n"); 
		query.append("   AND CGO.CGO_SEQ = (SELECT MIN(CGO_SEQ) FROM PRI_SCQ_AWK_CGO WHERE SCQ_RQST_NO = MN.SCQ_RQST_NO AND SCQ_VER_NO = MN.SCQ_VER_NO) " ).append("\n"); 
		query.append("   AND PG.PROG_SEQ = (SELECT MAX(PROG_SEQ) FROM PRI_SCQ_PROG WHERE SCQ_RQST_NO = MN.SCQ_RQST_NO AND SCQ_VER_NO = MN.SCQ_VER_NO AND SPCL_CGO_TP_CD = 'AK')" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   AND CGO.CMDT_CD LIKE @[cmdt_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '' and ${svc_scp_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND MN.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scq_rqst_no} != '')" ).append("\n"); 
		query.append("   AND MN.SCQ_RQST_NO LIKE @[scq_rqst_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND MN.RQST_OFC_CD LIKE @[rqst_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (PG.PROG_DT BETWEEN TO_DATE(REPLACE(@[fmperiod], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[toperiod], '-'), 'YYYYMMDD')+0.99999)" ).append("\n"); 
		query.append("#if (${rqst_srep_cd} != '' and ${rqst_srep_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND MN.RQST_SREP_CD = @[rqst_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '' and ${delt_flg} != 'ALL')" ).append("\n"); 
		query.append("   AND NVL(MN.DELT_FLG,'N') = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("   AND MN.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("   AND MN.CUST_SEQ = LTRIM(@[cust_seq],'0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("   AND MN.POR_CD LIKE @[por_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("   AND MN.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("   AND MN.POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("   AND MN.DEL_CD LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${apro_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND MN.APRO_OFC_CD LIKE @[apro_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_cd} != '' and ${tp_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND PG.SPCL_CGO_TP_CD = @[tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_nm} != '')" ).append("\n"); 
		query.append("   AND UPPER(MN.ACT_CUST_NM) LIKE '%'||UPPER(@[act_cust_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND MN.DELT_FLG||MN.SCQ_VER_NO||MN.PROG_STS_CD <> 'Y000Q'" ).append("\n"); 
		query.append("   AND MN.DELT_FLG||MN.SCQ_VER_NO||MN.PROG_STS_CD <> 'Y000S'" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MN.SVC_SCP_CD " ).append("\n"); 
		query.append("     , MN.SCQ_RQST_NO                      " ).append("\n"); 
		query.append("     , MN.SCQ_VER_NO                       " ).append("\n"); 
		query.append("     , MN.PROG_STS_CD                      " ).append("\n"); 
		query.append("     , MN.RQST_OFC_CD                      " ).append("\n"); 
		query.append("     , MN.RQST_SREP_CD                                               " ).append("\n"); 
		query.append("     , '' AS POR_CD                                          " ).append("\n"); 
		query.append("     , MN.POL_CD                                            " ).append("\n"); 
		query.append("     , MN.POD_CD                                                 " ).append("\n"); 
		query.append("     , '' AS DEL_CD                                          " ).append("\n"); 
		query.append("     , MN.CUST_CNT_CD                      " ).append("\n"); 
		query.append("     , MN.CUST_SEQ                         " ).append("\n"); 
		query.append("     , MN.RCV_TERM_CD                      " ).append("\n"); 
		query.append("     , MN.DE_TERM_CD                       " ).append("\n"); 
		query.append("--     , TO_CHAR(MN.PROP_EFF_DT,'YYYY-MM-DD') AS PROP_EFF_DT                     " ).append("\n"); 
		query.append("--     , TO_CHAR(MN.PROP_EXP_DT,'YYYY-MM-DD') AS PROP_EXP_DT                     " ).append("\n"); 
		query.append("--     , TO_CHAR(MN.APRO_EFF_DT,'YYYY-MM-DD') AS APRO_EFF_DT                     " ).append("\n"); 
		query.append("--     , TO_CHAR(MN.APRO_EXP_DT,'YYYY-MM-DD') AS APRO_EXP_DT                     " ).append("\n"); 
		query.append("     , MN.DELT_FLG                         " ).append("\n"); 
		query.append("     , MN.APRO_OFC_CD                         " ).append("\n"); 
		query.append("     , MN.ACT_CUST_NM                      " ).append("\n"); 
		query.append("     , PG.SPCL_CGO_TP_CD                   " ).append("\n"); 
		query.append("     , PG.PROG_SEQ                                                " ).append("\n"); 
		query.append("     , PG.PROG_DT  " ).append("\n"); 
		query.append("     , CGO.CMDT_CD  " ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID       = 'CD03161'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = MN.PROG_STS_CD" ).append("\n"); 
		query.append("           AND ROWNUM <= 1) AS STS_CD                                   " ).append("\n"); 
		query.append("	 , NVL ( MN.MEAS_SYS_CD, 'M' ) AS MEAS_SYS_CD" ).append("\n"); 
		query.append("     ,(	SELECT	U.USR_NM" ).append("\n"); 
		query.append("       	FROM	PRI_SCQ_PROG P" ).append("\n"); 
		query.append("			,	COM_USER U" ).append("\n"); 
		query.append("		WHERE	P.PROG_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("		AND 	P.SCQ_RQST_NO = MN.SCQ_RQST_NO " ).append("\n"); 
		query.append("        AND		P.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("		AND		P.SPCL_CGO_TP_CD = 'BB' " ).append("\n"); 
		query.append("		AND 	P.PROG_SEQ = ( SELECT MAX ( X.PROG_SEQ ) FROM PRI_SCQ_PROG X WHERE X.SCQ_RQST_NO = P.SCQ_RQST_NO AND X.SCQ_VER_NO = P.SCQ_VER_NO AND X.SPCL_CGO_TP_CD = 'BB' AND X.PROG_STS_CD IN ( 'Q', 'O' ) )" ).append("\n"); 
		query.append("      ) AS RQST_USR_NM" ).append("\n"); 
		query.append("     ,(	SELECT	TO_CHAR ( P.PROG_DT, 'YYYY-MM-DD HH24:MI:SS' )" ).append("\n"); 
		query.append("       	FROM	PRI_SCQ_PROG P" ).append("\n"); 
		query.append("		WHERE	P.SCQ_RQST_NO = MN.SCQ_RQST_NO " ).append("\n"); 
		query.append("        AND		P.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("		AND		P.SPCL_CGO_TP_CD = 'BB' " ).append("\n"); 
		query.append("		AND 	P.PROG_SEQ = ( SELECT MAX ( X.PROG_SEQ ) FROM PRI_SCQ_PROG X WHERE X.SCQ_RQST_NO = P.SCQ_RQST_NO AND X.SCQ_VER_NO = P.SCQ_VER_NO AND X.SPCL_CGO_TP_CD = 'BB' AND X.PROG_STS_CD IN ( 'Q', 'O' ) )" ).append("\n"); 
		query.append("      ) AS RQST_DT" ).append("\n"); 
		query.append("     ,(	SELECT	U.USR_NM" ).append("\n"); 
		query.append("       	FROM	PRI_SCQ_PROG P" ).append("\n"); 
		query.append("			,	COM_USER U" ).append("\n"); 
		query.append("		WHERE	P.PROG_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("		AND 	P.SCQ_RQST_NO = MN.SCQ_RQST_NO " ).append("\n"); 
		query.append("        AND		P.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("		AND		P.SPCL_CGO_TP_CD = 'BB' " ).append("\n"); 
		query.append("		AND 	P.PROG_SEQ = ( SELECT MAX ( X.PROG_SEQ ) FROM PRI_SCQ_PROG X WHERE X.SCQ_RQST_NO = P.SCQ_RQST_NO AND X.SCQ_VER_NO = P.SCQ_VER_NO AND X.SPCL_CGO_TP_CD = 'BB' AND X.PROG_STS_CD IN ( 'A', 'R' ) )" ).append("\n"); 
		query.append("      ) AS APRO_USR_NM" ).append("\n"); 
		query.append("     ,(	SELECT	TO_CHAR ( P.PROG_DT, 'YYYY-MM-DD HH24:MI:SS' )" ).append("\n"); 
		query.append("       	FROM	PRI_SCQ_PROG P" ).append("\n"); 
		query.append("		WHERE	P.SCQ_RQST_NO = MN.SCQ_RQST_NO " ).append("\n"); 
		query.append("        AND		P.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("		AND		P.SPCL_CGO_TP_CD = 'BB' " ).append("\n"); 
		query.append("		AND 	P.PROG_SEQ = ( SELECT MAX ( X.PROG_SEQ ) FROM PRI_SCQ_PROG X WHERE X.SCQ_RQST_NO = P.SCQ_RQST_NO AND X.SCQ_VER_NO = P.SCQ_VER_NO AND X.SPCL_CGO_TP_CD = 'BB' AND X.PROG_STS_CD IN ( 'A', 'R' ) )" ).append("\n"); 
		query.append("      ) AS APRO_DT" ).append("\n"); 
		query.append("  FROM PRI_SCQ_BB_MN MN                   " ).append("\n"); 
		query.append("     , PRI_SCQ_PROG PG      " ).append("\n"); 
		query.append("     , PRI_SCQ_BB_CGO CGO" ).append("\n"); 
		query.append(" where 1=1     " ).append("\n"); 
		query.append("   AND PG.SCQ_RQST_NO = MN.SCQ_RQST_NO     " ).append("\n"); 
		query.append("   AND PG.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("   AND PG.SPCL_CGO_TP_CD = 'BB' " ).append("\n"); 
		query.append("   AND PG.SCQ_RQST_NO = CGO.SCQ_RQST_NO" ).append("\n"); 
		query.append("   AND PG.SCQ_VER_NO = CGO.SCQ_VER_NO" ).append("\n"); 
		query.append("   AND PG.SCQ_VER_NO = (SELECT MAX(SCQ_VER_NO) FROM PRI_SCQ_BB_MN WHERE SCQ_RQST_NO = MN.SCQ_RQST_NO )" ).append("\n"); 
		query.append("   AND CGO.CGO_SEQ = (SELECT MIN(CGO_SEQ) FROM PRI_SCQ_BB_CGO WHERE SCQ_RQST_NO = MN.SCQ_RQST_NO AND SCQ_VER_NO = MN.SCQ_VER_NO) " ).append("\n"); 
		query.append("   AND PG.PROG_SEQ = (SELECT MAX(PROG_SEQ) FROM PRI_SCQ_PROG WHERE SCQ_RQST_NO = MN.SCQ_RQST_NO AND SCQ_VER_NO = MN.SCQ_VER_NO AND SPCL_CGO_TP_CD = 'BB')  " ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   AND CGO.CMDT_CD LIKE @[cmdt_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '' and ${svc_scp_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND MN.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scq_rqst_no} != '')" ).append("\n"); 
		query.append("   AND MN.SCQ_RQST_NO LIKE @[scq_rqst_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND MN.RQST_OFC_CD LIKE @[rqst_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (PG.PROG_DT BETWEEN TO_DATE(REPLACE(@[fmperiod], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[toperiod], '-'), 'YYYYMMDD')+0.99999)" ).append("\n"); 
		query.append("#if (${rqst_srep_cd} != '' and ${rqst_srep_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND MN.RQST_SREP_CD = @[rqst_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '' and ${delt_flg} != 'ALL')" ).append("\n"); 
		query.append("   AND NVL(MN.DELT_FLG,'N') = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("   AND MN.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("   AND MN.CUST_SEQ = LTRIM(@[cust_seq],'0')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("   AND MN.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("   AND MN.POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${apro_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND MN.APRO_OFC_CD LIKE @[apro_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_cd} != '' and ${tp_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND PG.SPCL_CGO_TP_CD = @[tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${act_cust_nm} != '')" ).append("\n"); 
		query.append("   AND MN.ACT_CUST_NM LIKE '%'||UPPER(@[act_cust_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND MN.DELT_FLG||MN.SCQ_VER_NO||MN.PROG_STS_CD <> 'Y000Q'" ).append("\n"); 
		query.append("   AND MN.DELT_FLG||MN.SCQ_VER_NO||MN.PROG_STS_CD <> 'Y000S'" ).append("\n"); 
		query.append(")  T " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${sts_cd} != '' and ${sts_cd} != 'ALL')" ).append("\n"); 
		query.append("AND STS_CD = @[sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SUBSTR(SCQ_RQST_NO,4,12) DESC" ).append("\n"); 

	}
}