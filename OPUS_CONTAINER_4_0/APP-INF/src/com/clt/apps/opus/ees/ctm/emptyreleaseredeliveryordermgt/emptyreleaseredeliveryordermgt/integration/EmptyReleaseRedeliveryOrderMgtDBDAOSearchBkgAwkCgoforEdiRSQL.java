/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgAwkCgoforEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.02
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2014.12.02 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgAwkCgoforEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_AWK_CGO 테이블에서 EDI로 전송할 정보를 조회한다
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgAwkCgoforEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgAwkCgoforEdiRSQL").append("\n"); 
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
		query.append("SELECT BAC.OVR_BKWD_LEN" ).append("\n"); 
		query.append("      ,BAC.OVR_FWRD_LEN" ).append("\n"); 
		query.append("      ,BAC.OVR_HGT" ).append("\n"); 
		query.append("      ,BAC.OVR_LF_LEN" ).append("\n"); 
		query.append("      ,BAC.OVR_RT_LEN" ).append("\n"); 
		query.append("      ,BAC.OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("      ,BAC.TTL_DIM_LEN" ).append("\n"); 
		query.append("      ,BAC.TTL_DIM_WDT" ).append("\n"); 
		query.append("      ,BAC.TTL_DIM_HGT" ).append("\n"); 
		query.append("      ,BAC.GRS_WGT || BAC.WGT_UT_CD OVWGT" ).append("\n"); 
		query.append("      ,BAC.STWG_RQST_DESC" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD00582'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = BAC.WGT_UT_CD" ).append("\n"); 
		query.append("      ) GWGTUNIT" ).append("\n"); 
		query.append("      ,BAC.GRS_WGT GWGT" ).append("\n"); 
		query.append("      ,'KGS' TWGTUNIT" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("	  ,CASE WHEN (  SELECT TARE_WGT FROM MST_CNTR_SPEC" ).append("\n"); 
		query.append("                    WHERE CNTR_SPEC_NO = (SELECT CNTR_SPEC_NO FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no])) IS NOT NULL" ).append("\n"); 
		query.append("            THEN" ).append("\n"); 
		query.append("                    (SELECT TARE_WGT FROM MST_CNTR_SPEC" ).append("\n"); 
		query.append("                    WHERE CNTR_SPEC_NO = (SELECT CNTR_SPEC_NO FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no]))" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                    (SELECT CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                    WHERE CNTR_TPSZ_CD = (SELECT CNTR_TPSZ_CD FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no]))" ).append("\n"); 
		query.append("       END TWGT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	  ,(SELECT CNTR_TPSZ_TARE_WGT TARE_WGT FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("		WHERE CNTR_TPSZ_CD = (SELECT CNTR_TPSZ_CD FROM BKG_AWK_CGO WHERE BKG_NO = @[bkg_no] AND ROWNUM=1)" ).append("\n"); 
		query.append("	   ) TWGT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,BAC.CMDT_CD CMD" ).append("\n"); 
		query.append("      ,(SELECT CM.CMDT_NM" ).append("\n"); 
		query.append("          FROM MDM_COMMODITY CM" ).append("\n"); 
		query.append("         WHERE CM.CMDT_CD = BAC.CMDT_CD) CMDD" ).append("\n"); 
		query.append("  FROM BKG_AWK_CGO BAC" ).append("\n"); 
		query.append(" WHERE BAC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("   AND BAC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}