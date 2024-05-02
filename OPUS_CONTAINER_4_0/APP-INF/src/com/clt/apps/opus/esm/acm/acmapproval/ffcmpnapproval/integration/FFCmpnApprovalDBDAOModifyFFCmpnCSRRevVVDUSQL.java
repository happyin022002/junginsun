/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOModifyFFCmpnCSRRevVVDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnApprovalDBDAOModifyFFCmpnCSRRevVVDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyFFCmpnCSRRevVVD
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOModifyFFCmpnCSRRevVVDUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n"); 
		query.append("FileName : FFCmpnApprovalDBDAOModifyFFCmpnCSRRevVVDUSQL").append("\n"); 
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
		query.append("UPDATE  /*+ bypass_ujvc */" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT I.RLANE_CD ACM_RLANE_CD, I.REV_VVD_CD ACM_REV_VVD_CD, C.RLANE_CD COA_RLANE_CD, C.VSL_CD||C.SKD_VOY_NO||C.FINC_DIR_CD COA_REV_VVD_CD" ).append("\n"); 
		query.append("    FROM ACM_AGN_BKG_INFO I, COA_RGST_BKG C" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND I.BKG_NO = C.BKG_NO " ).append("\n"); 
		query.append("    AND I.REV_VVD_CD <> C.VSL_CD||C.SKD_VOY_NO||C.FINC_DIR_CD" ).append("\n"); 
		query.append("    AND I.BKG_NO IN (" ).append("\n"); 
		query.append("		      SELECT A.BKG_NO" ).append("\n"); 
		query.append("		        FROM ACM_FF_CMPN A, ACM_AGN_BKG_INFO B" ).append("\n"); 
		query.append("		       WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		         AND B.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("#if(${bl_no} != '')	" ).append("\n"); 
		query.append("			       AND A.BKG_NO	" ).append("\n"); 
		query.append("			        IN	" ).append("\n"); 
		query.append("			         ( $bl_no	" ).append("\n"); 
		query.append("			         )	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		         AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("		         AND A.VNDR_SEQ  = @[vndr_seq]" ).append("\n"); 
		query.append("				 AND B.BKG_STS_CD <> 'A'" ).append("\n"); 
		query.append("		         AND A.BKG_FF_CNT_CD||TO_CHAR(A.BKG_FF_SEQ,'FM000000') = @[ff_cnt_seq]" ).append("\n"); 
		query.append("		         AND A.AP_OFC_CD = @[ap_ofc_cd]" ).append("\n"); 
		query.append("		/* 날짜 조회 조건 */	" ).append("\n"); 
		query.append("		#if(${date_div} == 'B')	" ).append("\n"); 
		query.append("               AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("               AND B.BKG_CRE_DT	" ).append("\n"); 
		query.append("           BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("               AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("        #elseif(${date_div} == 'E')	" ).append("\n"); 
		query.append("               AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("               AND A.VSL_DEP_DT	" ).append("\n"); 
		query.append("           BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("               AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("        #elseif(${date_div} == 'C')	" ).append("\n"); 
		query.append("               AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("               AND A.UPD_DT	" ).append("\n"); 
		query.append("           BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("               AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("        #elseif(${date_div} == 'P')	" ).append("\n"); 
		query.append("               AND A.APRO_DT	" ).append("\n"); 
		query.append("           BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("               AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("        #elseif(${date_div} == 'I')	" ).append("\n"); 
		query.append("               AND A.IF_DT	" ).append("\n"); 
		query.append("           BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("               AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		         AND A.FF_CMPN_STS_CD IN ('CS', 'CM', 'CA')" ).append("\n"); 
		query.append("                                                 " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SET ACM_RLANE_CD   = COA_RLANE_CD " ).append("\n"); 
		query.append("   ,ACM_REV_VVD_CD = COA_REV_VVD_CD" ).append("\n"); 

	}
}