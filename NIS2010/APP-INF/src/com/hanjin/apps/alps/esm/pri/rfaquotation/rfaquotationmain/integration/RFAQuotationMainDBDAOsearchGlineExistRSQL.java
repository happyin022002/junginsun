/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAQuotationMainDBDAOsearchGlineExistRSQL.java
*@FileTitle : RFA Quotation Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.07 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAQuotationMainDBDAOsearchGlineExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * gline copy 시 데이터가 존재하는지 조회
	  * </pre>
	  */
	public RFAQuotationMainDBDAOsearchGlineExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration").append("\n"); 
		query.append("FileName : RFAQuotationMainDBDAOsearchGlineExistRSQL").append("\n"); 
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
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       NVL(SIGN(NVL(A1.LOC_CHK,0)),0) AS LOC_CHK" ).append("\n"); 
		query.append(",       NVL(SIGN(DECODE(A2.SVC_SCP_CD,'TPW',0, NVL(A2.CMDT_CHK,0))),0) AS CMDT_CHK" ).append("\n"); 
		query.append(",       NVL(SIGN(DECODE(A3.SVC_SCP_CD,'TPW',NVL(A3.CMDT_TPW_CHK,0),0)),0) AS CMDT_TPW_CHK" ).append("\n"); 
		query.append(",       NVL(SIGN(NVL(A4.RATE_CHK,0)),0) AS RATE_CHK" ).append("\n"); 
		query.append(",       '' AS CMDT_TPW_MST" ).append("\n"); 
		query.append(",       '' AS GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(",       '' AS EFF_DT" ).append("\n"); 
		query.append(",       '' AS EXP_DT" ).append("\n"); 
		query.append(",       '' AS PRC_CUST_TP_CD" ).append("\n"); 
		query.append(",       '' AS NEW_GRP_CMDT_SEQ" ).append("\n"); 
		query.append(",       '' AS UPD_USR_ID" ).append("\n"); 
		query.append(",       '' AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",       '' AS CMDT_TPW_DTL" ).append("\n"); 
		query.append(",       '' AS NEW_GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(",       '' AS CRE_USR_ID" ).append("\n"); 
		query.append(",       '' AS GRP_CMDT_SEQ" ).append("\n"); 
		query.append(",       '' AS QTTN_NO" ).append("\n"); 
		query.append(",       '' AS QTTN_VER_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY B.EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM  PRI_RG_MN B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND    TO_CHAR(B.EFF_DT,'YYYY-MM-DD') <= @[eff_dt]" ).append("\n"); 
		query.append("AND    TO_CHAR(B.EXP_DT,'YYYY-MM-DD') >= @[eff_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 
		query.append(") A0," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--GRP LOCATION" ).append("\n"); 
		query.append("SELECT  A.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A.GLINE_SEQ" ).append("\n"); 
		query.append(",       COUNT(A.SVC_SCP_CD) AS LOC_CHK" ).append("\n"); 
		query.append("FROM    PRI_RG_GRP_LOC A" ).append("\n"); 
		query.append(",       PRI_RG_GRP_LOC_DTL B" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND     A.GRP_LOC_SEQ = B.GRP_LOC_SEQ" ).append("\n"); 
		query.append("AND     (A.SVC_SCP_CD, A.GLINE_SEQ) = ( SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY B.EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM  PRI_RG_MN B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND    TO_CHAR(B.EFF_DT,'YYYY-MM-DD') <= @[eff_dt]" ).append("\n"); 
		query.append("AND    TO_CHAR(B.EXP_DT,'YYYY-MM-DD') >= @[eff_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY A.SVC_SCP_CD, A.GLINE_SEQ" ).append("\n"); 
		query.append(") A1," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--GRP COMMODITY" ).append("\n"); 
		query.append("SELECT  A.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A.GLINE_SEQ" ).append("\n"); 
		query.append(",       COUNT(A.SVC_SCP_CD) AS CMDT_CHK" ).append("\n"); 
		query.append("FROM    PRI_RG_GRP_CMDT A" ).append("\n"); 
		query.append(",       PRI_RG_GRP_CMDT_DTL B" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND     A.GRP_CMDT_SEQ = B.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("AND     (A.SVC_SCP_CD, A.GLINE_SEQ) = (" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY B.EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM  PRI_RG_MN B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND    TO_CHAR(B.EFF_DT,'YYYY-MM-DD') <= @[eff_dt]" ).append("\n"); 
		query.append("AND    TO_CHAR(B.EXP_DT,'YYYY-MM-DD') >= @[eff_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY A.SVC_SCP_CD, A.GLINE_SEQ" ).append("\n"); 
		query.append(") A2," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--GRP TPW COMMODITY" ).append("\n"); 
		query.append("SELECT  A.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A.GLINE_SEQ" ).append("\n"); 
		query.append(",       COUNT(A.SVC_SCP_CD) AS CMDT_TPW_CHK" ).append("\n"); 
		query.append("FROM    PRI_RG_GRP_CMDT A" ).append("\n"); 
		query.append(",       PRI_RG_GRP_CMDT_DTL B" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("AND     A.GRP_CMDT_SEQ = B.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("AND     (A.SVC_SCP_CD, A.GLINE_SEQ) = (" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY B.EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM  PRI_RG_MN B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND    TO_CHAR(B.EFF_DT,'YYYY-MM-DD') <= @[eff_dt]" ).append("\n"); 
		query.append("AND    TO_CHAR(B.EXP_DT,'YYYY-MM-DD') >= @[eff_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY A.SVC_SCP_CD, A.GLINE_SEQ" ).append("\n"); 
		query.append(") A3," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- RATE" ).append("\n"); 
		query.append("SELECT  NVL(A.SVC_SCP_CD,'') AS SVC_SCP_CD" ).append("\n"); 
		query.append(",       NVL(A.GLINE_SEQ,'') AS GLINE_SEQ" ).append("\n"); 
		query.append(",       COUNT(A.SVC_SCP_CD) AS RATE_CHK" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_HDR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND     (A.SVC_SCP_CD, A.GLINE_SEQ) = (" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append(",       GLINE_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.GLINE_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY B.EFF_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM  PRI_RG_MN B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   B.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND    TO_CHAR(B.EFF_DT,'YYYY-MM-DD') <= @[eff_dt]" ).append("\n"); 
		query.append("AND    TO_CHAR(B.EXP_DT,'YYYY-MM-DD') >= @[eff_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT C" ).append("\n"); 
		query.append("WHERE C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   C.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   C.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_ROUT D" ).append("\n"); 
		query.append("WHERE D.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   D.GLINE_SEQ = A.GLINE_SEQ" ).append("\n"); 
		query.append("AND   D.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_PNT E" ).append("\n"); 
		query.append("WHERE E.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   E.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND   E.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   E.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_ROUT_VIA F" ).append("\n"); 
		query.append("WHERE F.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   F.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND   F.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   F.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM  PRI_RG_RT H" ).append("\n"); 
		query.append("WHERE H.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   H.GLINE_SEQ = D.GLINE_SEQ" ).append("\n"); 
		query.append("AND   H.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND   H.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY A.SVC_SCP_CD,A.GLINE_SEQ" ).append("\n"); 
		query.append(") A4" ).append("\n"); 
		query.append("WHERE   A0.SVC_SCP_CD = A1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A0.GLINE_SEQ = A1.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     A0.SVC_SCP_CD = A2.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A0.GLINE_SEQ = A2.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     A0.SVC_SCP_CD = A2.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A0.GLINE_SEQ = A2.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     A0.SVC_SCP_CD = A3.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A0.GLINE_SEQ = A3.GLINE_SEQ(+)" ).append("\n"); 
		query.append("AND     A0.SVC_SCP_CD = A4.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND     A0.GLINE_SEQ = A4.GLINE_SEQ(+)" ).append("\n"); 

	}
}