/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOsearchVerifyToEstimateDtlDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOsearchVerifyToEstimateDtlDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVerifyToEstimateDtlData
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOsearchVerifyToEstimateDtlDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOsearchVerifyToEstimateDtlDataRSQL").append("\n"); 
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
		query.append("SELECT   A.INP_MSG1  AS EQ_LOC_CD" ).append("\n"); 
		query.append("       , A.INP_MSG2  AS EQ_CMPO_CD" ).append("\n"); 
		query.append("       , A.INP_MSG3  AS EQ_DMG_CD" ).append("\n"); 
		query.append("       , A.INP_MSG4  AS MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("       , A.INP_MSG5  AS EQ_RPR_CD" ).append("\n"); 
		query.append("       , A.INP_MSG7  AS TRF_DIV_CD" ).append("\n"); 
		query.append("       , A.INP_MSG8  AS VOL_TP_CD " ).append("\n"); 
		query.append("       , A.INP_MSG9  AS RPR_QTY" ).append("\n"); 
		query.append("       , A.INP_MSG10 AS RPR_SZ_NO" ).append("\n"); 
		query.append("       , LTRIM(TO_CHAR(A.INP_MSG11, '90.99')) AS RPR_LBR_HRS" ).append("\n"); 
		query.append("       , A.INP_MSG12 AS RPR_LBR_RT" ).append("\n"); 
		query.append("       , A.INP_MSG13 AS LBR_COST_AMT" ).append("\n"); 
		query.append("       , A.INP_MSG14 AS MTRL_COST_AMT" ).append("\n"); 
		query.append("       , A.INP_MSG15 AS MNR_WRK_AMT" ).append("\n"); 
		query.append("       , A.INP_MSG16 AS RPR_LBR_BZC_HRS" ).append("\n"); 
		query.append("       , A.INP_MSG17 AS LBR_MTRL_BZC_AMT" ).append("\n"); 
		query.append("       , A.INP_MSG18 AS RPR_LBR_BZC_RT" ).append("\n"); 
		query.append("       , A.INP_MSG19 AS COST_CD " ).append("\n"); 
		query.append("       , A.INP_MSG20 AS COST_DTL_CD" ).append("\n"); 
		query.append("       , A.INP_MSG21 AS MNR_LR_ACCT_FLG" ).append("\n"); 
		query.append("       , A.INP_MSG22 AS N3PTY_FLG" ).append("\n"); 
		query.append("       , A.INP_MSG23 AS N3PTY_BIL_LBR_HRS" ).append("\n"); 
		query.append("       , A.INP_MSG24 AS N3PTY_BIL_LBR_RT" ).append("\n"); 
		query.append("       , A.INP_MSG25 AS N3PTY_LBR_COST_AMT" ).append("\n"); 
		query.append("       , A.INP_MSG26 AS N3PTY_BIL_MTRL_COST_AMT" ).append("\n"); 
		query.append("       , A.INP_MSG27 AS N3PTY_BIL_AMT" ).append("\n"); 
		query.append("       , A.INP_MSG28 AS MNR_LBR_BZC_AMT" ).append("\n"); 
		query.append("       , A.INP_MSG29 AS MNR_AGMT_AMT  " ).append("\n"); 
		query.append("       , A.INP_MSG30 AS RPR_DTL_RMK 	     " ).append("\n"); 
		query.append("       , DECODE(A.INP_MSG4,'LE','Y','N') AS EQ_LOC_CD_CHK_FLG " ).append("\n"); 
		query.append("       , DECODE(A.INP_MSG4,'CE','Y','N') AS EQ_CMPO_CD_CHK_FLG " ).append("\n"); 
		query.append("       , DECODE(A.INP_MSG4,'DE','Y','N') AS EQ_DMG_CD_CHK_FLG " ).append("\n"); 
		query.append("       , DECODE(A.INP_MSG4,'RE','Y','N') AS EQ_RPR_CD_CHK_FLG " ).append("\n"); 
		query.append("FROM     MNR_DAT_VRFY A" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 

	}
}