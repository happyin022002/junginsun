/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOSearchVndrRqstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchVndrRqstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor Create Request 목록을 조회
	  * </pre>
	  */
	public PartnerDBDAOSearchVndrRqstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchVndrRqstListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (SELECT ROWNUM AS NO" ).append("\n"); 
		query.append("	 		 , B.*" ).append("\n"); 
		query.append("  		  FROM (SELECT A.MDM_VNDR_RQST_SEQ AS RQST_NO" ).append("\n"); 
		query.append("		 	 		 , TO_CHAR(A.RQST_DT, 'YYYY-MM-DD HH24:MI') AS RQST_DT" ).append("\n"); 
		query.append("		 	 		 , A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("			 		 , A.VNDR_LOCL_LANG_NM" ).append("\n"); 
		query.append("		 	 		 , A.ENG_ADDR" ).append("\n"); 
		query.append("			 		 , A.BLK_FLG" ).append("\n"); 
		query.append("		 	 		 , A.OFC_CD" ).append("\n"); 
		query.append("		 	 		 , A.LOC_CD" ).append("\n"); 
		query.append("			 		 , A.RGST_NO" ).append("\n"); 
		query.append("		 	 		 , A.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("		 	 		 , A.PAY_TERM_TP_CD" ).append("\n"); 
		query.append("		 	 		 , A.PAY_MZD_CD" ).append("\n"); 
		query.append("		 	 		 , A.INV_CURR_CD" ).append("\n"); 
		query.append("		 	 		 , A.VNDR_CNT_CD" ).append("\n"); 
		query.append("		 	 		 , A.VNDR_SEQ  " ).append("\n"); 
		query.append("             		 , A.RFND_PSDO_CUST_CD" ).append("\n"); 
		query.append("			 		 , A.LOCL_LANG_ADDR " ).append("\n"); 
		query.append("			 		 , A.CHK_DE_ADDR1 " ).append("\n"); 
		query.append("			 		 , A.CHK_DE_ADDR2 " ).append("\n"); 
		query.append("			 		 , A.CHK_DE_ADDR3 " ).append("\n"); 
		query.append("             		 , A.CRE_DT" ).append("\n"); 
		query.append("             		 , A.CRE_USR_ID" ).append("\n"); 
		query.append("             		 , A.UPD_DT" ).append("\n"); 
		query.append("             		 , A.UPD_USR_ID" ).append("\n"); 
		query.append("		 	 		 , CASE WHEN MST_RQST_STS_CD = 'N' THEN 'Saved'" ).append("\n"); 
		query.append("			 		 		WHEN MST_RQST_STS_CD = 'R' THEN 'Rejected'" ).append("\n"); 
		query.append("						  	WHEN MST_RQST_STS_CD = 'P' THEN 'Requested'" ).append("\n"); 
		query.append("			 			   	WHEN VNDR_CNT_CD IS NOT NULL THEN 'Approved'" ).append("\n"); 
		query.append("						   	WHEN MST_RQST_STS_CD = 'A' THEN 'Approved'" ).append("\n"); 
		query.append("			   	   		   	ELSE 'Saved'" ).append("\n"); 
		query.append("					  	END AS DELT_FLG " ).append("\n"); 
		query.append("          		  FROM MDM_VNDR_RQST A" ).append("\n"); 
		query.append("     	 		 WHERE 1=1" ).append("\n"); 
		query.append("#if (${rqst_no} != '')" ).append("\n"); 
		query.append("	   	 	       AND A.MDM_VNDR_RQST_SEQ = @[rqst_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_nm} != '')" ).append("\n"); 
		query.append("	   	   		   AND A.VNDR_LGL_ENG_NM LIKE '%' || UPPER(@[vndr_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if	(${ofc_cd} != '')" ).append("\n"); 
		query.append("	   	   		   AND A.OFC_CD LIKE '%' || UPPER(@[ofc_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '' && ${delt_flg} != 'ALL')" ).append("\n"); 
		query.append("	   	   		   AND A.MST_RQST_STS_CD = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_fm_dt} != '')" ).append("\n"); 
		query.append("       	   		   AND A.CRE_DT >= TO_DATE(@[rqst_fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_to_dt} != '')" ).append("\n"); 
		query.append("	   	   		   AND A.CRE_DT <= TO_DATE(@[rqst_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         		 ORDER BY A.CRE_DT DESC, A.RQST_DT DESC, A.MDM_VNDR_RQST_SEQ" ).append("\n"); 
		query.append("			   ) B" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}