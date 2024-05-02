/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchTpbInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.06.03 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOsearchTpbInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchTpbInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchTpbInfoRSQL").append("\n"); 
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
		query.append("SELECT HCNTR.BKG_NO         AS BKG_NO           " ).append("\n"); 
		query.append("       ,HCNTR.NTC_SEQ        AS NTC_SEQ         " ).append("\n"); 
		query.append("       ,HCNTR.CNTR_NO        AS CNTR_NO   " ).append("\n"); 
		query.append("       ,MAX(BCNTR.CNMV_STS_CD)    AS CNMV_STS_CD" ).append("\n"); 
		query.append("       ,MAX(DECODE( NVL(SORD.BKG_NO,NVL(SORD.BKG_NO,'No')),'No','No','Yes')) AS IS_SO" ).append("\n"); 
		query.append("       ,MAX(DECODE(HCNTR.N3PTY_BIL_NO,NULL,'N','Y'))   AS N3PTY_BIL_YN  " ).append("\n"); 
		query.append("       ,MAX(HCNTR.N3PTY_BIL_NO)                     AS N3PTY_BIL_NO    " ).append("\n"); 
		query.append("       ,MAX(HCNTR.INCUR_CHG_AMT)  AS INCUR_CHG_AMT           " ).append("\n"); 
		query.append("       ,MAX(HCNTR.CRE_USR_ID)     AS CRE_USR_ID      " ).append("\n"); 
		query.append("       ,MAX(HCNTR.CRE_DT)         AS CRE_DT          " ).append("\n"); 
		query.append("       ,MAX(HCNTR.UPD_USR_ID)     AS UPD_USR_ID      " ).append("\n"); 
		query.append("       ,MAX(HCNTR.UPD_DT)         AS UPD_DT          " ).append("\n"); 
		query.append("       ,MAX(BCNTR.CNTR_TPSZ_CD)   AS CNTR_TPSZ_CD    " ).append("\n"); 
		query.append("FROM BKG_HLD_N3RD_PTY_BIL_CNTR HCNTR" ).append("\n"); 
		query.append("JOIN BKG_CONTAINER             BCNTR" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("     BCNTR.BKG_NO            = HCNTR.BKG_NO" ).append("\n"); 
		query.append("     AND BCNTR.CNTR_NO       = HCNTR.CNTR_NO  " ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("LEFT OUTER JOIN TRS_TRSP_SVC_ORD SORD" ).append("\n"); 
		query.append(" ON (" ).append("\n"); 
		query.append("     SORD.BKG_NO             = HCNTR.BKG_NO" ).append("\n"); 
		query.append("     AND SORD.EQ_NO          = HCNTR.CNTR_NO  " ).append("\n"); 
		query.append("     AND SORD.TRSP_BND_CD    = 'I'" ).append("\n"); 
		query.append("     AND SORD.TRSP_SO_STS_CD IN ('C', 'I', 'R') " ).append("\n"); 
		query.append("     AND SORD.DELT_FLG ='N'" ).append("\n"); 
		query.append("     AND ROWNUM =1" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("LEFT OUTER JOIN TRS_TRSP_RAIL_BIL_ORD TORD" ).append("\n"); 
		query.append(" ON (" ).append("\n"); 
		query.append("     TORD.BKG_NO             = HCNTR.BKG_NO" ).append("\n"); 
		query.append("     AND TORD.EQ_NO          = HCNTR.CNTR_NO  " ).append("\n"); 
		query.append("     AND TORD.TRSP_BND_CD    = 'I'" ).append("\n"); 
		query.append("     AND TORD.TRSP_SO_STS_CD IN ('C', 'I', 'R') " ).append("\n"); 
		query.append("     AND TORD.DELT_FLG ='N'" ).append("\n"); 
		query.append("     AND ROWNUM =1" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHERE  HCNTR.BKG_NO   = @[bkg_no] " ).append("\n"); 
		query.append("#if ( ${ntc_seq} != '')     " ).append("\n"); 
		query.append("AND    HCNTR.NTC_SEQ  = @[ntc_seq] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY HCNTR.BKG_NO,HCNTR.NTC_SEQ,HCNTR.CNTR_NO" ).append("\n"); 

	}
}