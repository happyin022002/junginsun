/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArrivalNoticeDBDAOMdmCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOMdmCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOMdmCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd_ext",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOMdmCustomerRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_NL(A B C D) */  " ).append("\n"); 
		query.append("       A.CUST_CNT_CD || LPAD(A.CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("      ,CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,C.CTY_NM" ).append("\n"); 
		query.append("      ,C.BZET_ADDR" ).append("\n"); 
		query.append("      ,B.PHN_NO" ).append("\n"); 
		query.append("      ,B.FAX_NO" ).append("\n"); 
		query.append("      ,B.CUST_EML" ).append("\n"); 
		query.append("      ,CUST_STS_CD" ).append("\n"); 
		query.append("      ,DECODE(D.CUST_RLSE_CTRL_FLG,'N','NO','Y','YES',NULL,'NO',D.CUST_RLSE_CTRL_FLG) BOOKING_ALERT_TO_DATE" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,SREP_CD" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,A.CUST_SEQ" ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER      A" ).append("\n"); 
		query.append("      ,MDM_CUST_CNTC_PNT B" ).append("\n"); 
		query.append("      ,MDM_CUST_ADDR     C" ).append("\n"); 
		query.append("      ,MDM_CR_CUST       D" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND NVL(A.NMD_CUST_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("   AND B.CUST_CNT_CD    = A.CUST_CNT_CD " ).append("\n"); 
		query.append("   AND B.CUST_SEQ       = A.CUST_SEQ " ).append("\n"); 
		query.append("   AND C.CUST_CNT_CD    = A.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND C.CUST_SEQ       = A.CUST_SEQ " ).append("\n"); 
		query.append("   AND C.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("   AND D.CUST_CNT_CD(+) = A.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND D.CUST_SEQ(+)    = A.CUST_SEQ " ).append("\n"); 
		query.append("   AND B.PRMRY_CHK_FLG = 'Y'   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' ) " ).append("\n"); 
		query.append("  AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_seq} != '')   " ).append("\n"); 
		query.append("  AND A.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("  AND A.CUST_LGL_ENG_NM LIKE UPPER(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cnt_cd_ext} != '') " ).append("\n"); 
		query.append("  AND A.CUST_CNT_CD = @[cust_cnt_cd_ext]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')  " ).append("\n"); 
		query.append(" AND A.OFC_CD= UPPER(@[ofc_cd])" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_sts_cd} != '')  " ).append("\n"); 
		query.append(" AND A.CUST_STS_CD = UPPER(@[cust_sts_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ste_cd} != '')  " ).append("\n"); 
		query.append(" AND C.STE_CD = @[ste_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}