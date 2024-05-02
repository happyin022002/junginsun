/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementVersionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.01.08 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementVersionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement List Search
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementVersionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementVersionListRSQL").append("\n"); 
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
		query.append("SELECT AA.AGMT_NO" ).append("\n"); 
		query.append("     , AA.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , AA.AGMT_SEQ" ).append("\n"); 
		query.append("     , AA.AGMT_VER_SEQ" ).append("\n"); 
		query.append("     , AA.VNDR_SEQ" ).append("\n"); 
		query.append("     , AA.LSTM_CD" ).append("\n"); 
		query.append("     , AA.OFC_CD" ).append("\n"); 
		query.append("     , AA.REF_NO" ).append("\n"); 
		query.append("     , AA.VNDR_ABBR_NM" ).append("\n"); 
		query.append("     , AA.VNDR_NM" ).append("\n"); 
		query.append("     , AA.EFF_DT" ).append("\n"); 
		query.append("     , AA.EXP_DT" ).append("\n"); 
		query.append("     , AA.LSE_CTRT_NO" ).append("\n"); 
		query.append("     , AA.CRE_USR_ID" ).append("\n"); 
		query.append("     , AA.CRE_DT" ).append("\n"); 
		query.append("     , AA.UPD_USR_ID" ).append("\n"); 
		query.append("     , AA.UPD_DT" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("         SELECT ROW_NUMBER() OVER (ORDER BY A.AGMT_SEQ DESC) AS NO" ).append("\n"); 
		query.append("                , A.AGMT_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("                , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                , A.AGMT_SEQ" ).append("\n"); 
		query.append("                , B.AGMT_VER_SEQ" ).append("\n"); 
		query.append("                , B.VNDR_SEQ" ).append("\n"); 
		query.append("                , B.LSTM_CD" ).append("\n"); 
		query.append("                , B.OFC_CD" ).append("\n"); 
		query.append("                , B.REF_NO" ).append("\n"); 
		query.append("                , SUBSTR(C.VNDR_ABBR_NM,0,3) AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("                , C.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("                , TO_CHAR(B.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("                , TO_CHAR(B.EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("                , B.LSE_CTRT_NO" ).append("\n"); 
		query.append("                , B.CRE_USR_ID" ).append("\n"); 
		query.append("                , TO_CHAR(B.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("                , B.UPD_USR_ID" ).append("\n"); 
		query.append("                , TO_CHAR(B.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("           FROM   LSE_AGREEMENT A" ).append("\n"); 
		query.append("                , LSE_AGMT_VER B" ).append("\n"); 
		query.append("                , MDM_VENDOR C" ).append("\n"); 
		query.append("          WHERE  A.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("            AND    B.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("            AND    B.AGMT_SEQ = A.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '') " ).append("\n"); 
		query.append("                        AND A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '') " ).append("\n"); 
		query.append("                        AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("                        AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != '') " ).append("\n"); 
		query.append("                        AND A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) AA" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("WHERE AA.NO BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AA.AGMT_SEQ DESC" ).append("\n"); 
		query.append("       , AA.AGMT_VER_SEQ DESC" ).append("\n"); 

	}
}