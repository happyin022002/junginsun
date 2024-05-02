/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeasePlanDBDAOLongTermCNTRDeliveryPlanListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.03
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.12.03 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeasePlanDBDAOLongTermCNTRDeliveryPlanListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * L/T Lease CNTR Delivery Plan & Update 조회 쿼리 
	  *  2010.12.03 [CHM-201007443-01] 남궁진호 Ref No 항목 추가
	  * </pre>
	  */
	public LeasePlanDBDAOLongTermCNTRDeliveryPlanListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAOLongTermCNTRDeliveryPlanListRSQL").append("\n"); 
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
		query.append("	  AA.PLN_YR" ).append("\n"); 
		query.append("	, AA.PLN_SEQ" ).append("\n"); 
		query.append("	, AA.AGMT_NO" ).append("\n"); 
		query.append("	, AA.AGMT_CTY_CD" ).append("\n"); 
		query.append("	, AA.AGMT_SEQ" ).append("\n"); 
		query.append("    , BB.REF_NO" ).append("\n"); 
		query.append("	, AA.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("	, AA.DE_YRMON" ).append("\n"); 
		query.append("	, AA.DEL_CD" ).append("\n"); 
		query.append("	, AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, AA.DE_QTY" ).append("\n"); 
		query.append("    , AA.PLN_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT ROW_NUMBER() OVER (ORDER BY A.PLN_YR, A.AGMT_CTY_CD, A.AGMT_SEQ, DEL_CD, CNTR_TPSZ_CD, DE_YRMON, DE_QTY DESC) AS NO" ).append("\n"); 
		query.append("		, A.PLN_YR" ).append("\n"); 
		query.append("		, A.PLN_SEQ" ).append("\n"); 
		query.append("		, A.AGMT_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("		, A.AGMT_CTY_CD" ).append("\n"); 
		query.append("		, A.AGMT_SEQ" ).append("\n"); 
		query.append("		, A.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("		, A.DE_YRMON" ).append("\n"); 
		query.append("		, A.DEL_CD" ).append("\n"); 
		query.append("		, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, A.DE_QTY" ).append("\n"); 
		query.append("        , A.PLN_RMK" ).append("\n"); 
		query.append("	FROM  LSE_LONG_TERM_DE_PLN A" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${pln_yr} != '') " ).append("\n"); 
		query.append("	AND A.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '') " ).append("\n"); 
		query.append("	AND	A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '') " ).append("\n"); 
		query.append("	AND	A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mft_vndr_seq} != '') " ).append("\n"); 
		query.append("	AND	A.MFT_VNDR_SEQ = @[mft_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	) AA," ).append("\n"); 
		query.append("LSE_AGREEMENT BB" ).append("\n"); 
		query.append("WHERE AA.AGMT_SEQ = BB.AGMT_SEQ" ).append("\n"); 
		query.append(" AND  AA.AGMT_CTY_CD = BB.AGMT_CTY_CD" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append(" AND AA.NO BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}