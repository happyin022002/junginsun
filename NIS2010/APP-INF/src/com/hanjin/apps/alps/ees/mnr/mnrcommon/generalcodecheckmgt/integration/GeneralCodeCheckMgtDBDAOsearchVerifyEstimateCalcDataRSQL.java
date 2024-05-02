/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOsearchVerifyEstimateCalcDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.03 
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

public class GeneralCodeCheckMgtDBDAOsearchVerifyEstimateCalcDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------------------------------------------------------------------------------------
	  * searchVerifyEstimateCalcData
	  * 2014-04-30 Jonghee HAN Repair Estimates Creation Calculation Bug Fix - ORDER BY Phrase Added
	  * --------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOsearchVerifyEstimateCalcDataRSQL(){
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
		query.append("FileName : GeneralCodeCheckMgtDBDAOsearchVerifyEstimateCalcDataRSQL").append("\n"); 
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
		query.append("SELECT   A.TMP_SEQ" ).append("\n"); 
		query.append("       , A.TMP_DTL_SEQ" ).append("\n"); 
		query.append("       , A.INP_MSG1" ).append("\n"); 
		query.append("       , A.INP_MSG2" ).append("\n"); 
		query.append("       , A.INP_MSG3" ).append("\n"); 
		query.append("       , A.INP_MSG4" ).append("\n"); 
		query.append("       , A.INP_MSG5" ).append("\n"); 
		query.append("       , A.INP_MSG6" ).append("\n"); 
		query.append("       , A.INP_MSG7" ).append("\n"); 
		query.append("       , A.INP_MSG8" ).append("\n"); 
		query.append("       , A.INP_MSG9" ).append("\n"); 
		query.append("       , A.INP_MSG10" ).append("\n"); 
		query.append("       , DECODE(A.INP_MSG11, NULL, A.INP_MSG16, 0, A.INP_MSG16, A.INP_MSG11) AS INP_MSG11" ).append("\n"); 
		query.append("       , DECODE(A.INP_MSG12, NULL, A.INP_MSG18, 0, A.INP_MSG18, A.INP_MSG12) AS INP_MSG12" ).append("\n"); 
		query.append("       , DECODE(A.INP_MSG13, NULL, A.INP_MSG28, 0, A.INP_MSG28, A.INP_MSG13) AS INP_MSG13" ).append("\n"); 
		query.append("       , DECODE(A.INP_MSG14, NULL, A.INP_MSG17, 0, A.INP_MSG17, A.INP_MSG14) AS INP_MSG14" ).append("\n"); 
		query.append("       , DECODE(A.INP_MSG15, NULL, A.INP_MSG29, 0, A.INP_MSG29, A.INP_MSG15) AS INP_MSG15" ).append("\n"); 
		query.append("       , A.INP_MSG16" ).append("\n"); 
		query.append("       , A.INP_MSG17" ).append("\n"); 
		query.append("       , A.INP_MSG18" ).append("\n"); 
		query.append("       , A.INP_MSG19" ).append("\n"); 
		query.append("       , A.INP_MSG20" ).append("\n"); 
		query.append("       , A.INP_MSG21" ).append("\n"); 
		query.append("       , A.INP_MSG22" ).append("\n"); 
		query.append("       , A.INP_MSG23" ).append("\n"); 
		query.append("       , A.INP_MSG24" ).append("\n"); 
		query.append("       , A.INP_MSG25" ).append("\n"); 
		query.append("       , A.INP_MSG26" ).append("\n"); 
		query.append("       , A.INP_MSG27" ).append("\n"); 
		query.append("       , A.INP_MSG28" ).append("\n"); 
		query.append("       , A.INP_MSG29" ).append("\n"); 
		query.append("       , A.INP_MSG30" ).append("\n"); 
		query.append("FROM     MNR_DAT_VRFY A" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("ORDER BY A.TMP_SEQ, A.TMP_DTL_SEQ" ).append("\n"); 

	}
}