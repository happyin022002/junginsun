/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcNtmMrnRtnYdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
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

public class ArrivalNoticeDBDAOsearchArrNtcNtmMrnRtnYdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcNtmMrnRtnYdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcNtmMrnRtnYdRSQL").append("\n"); 
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
		query.append("SELECT CVSL.VSL_CD" ).append("\n"); 
		query.append("      ,CVSL.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,CVSL.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,CBL.BL_NO " ).append("\n"); 
		query.append("      ,CCNTR.BKG_NO" ).append("\n"); 
		query.append("      ,CCNTR.CNTR_NO " ).append("\n"); 
		query.append("      ,NVL(NCNTR.MVMT_REF_NO,'') VSL_MRN_NO" ).append("\n"); 
		query.append("      ,NVL(NCNTR.RTN_YD_CD,'')   MTY_RTN_YD_CD" ).append("\n"); 
		query.append("      ,NVL(TRANSLATE(NCNTR.MTY_RTN_YD_NM, CHR(10), ' '), YD.YD_NM) RTN_REF_NO" ).append("\n"); 
		query.append("      ,CVSL.VSL_CD || CVSL.SKD_VOY_NO || CVSL.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,'' POD_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_RTM_VSL CVSL" ).append("\n"); 
		query.append("          , BKG_CSTMS_RTM_BL CBL" ).append("\n"); 
		query.append("          , BKG_VVD		VDT" ).append("\n"); 
		query.append("          , BKG_VVD		VDU" ).append("\n"); 
		query.append("          , BKG_CSTMS_RTM_CNTR	CCNTR" ).append("\n"); 
		query.append("          , BKG_ARR_NTC_CNTR NCNTR" ).append("\n"); 
		query.append("          , MDM_YARD YD" ).append("\n"); 
		query.append("#if (${vvd_size} == '6')" ).append("\n"); 
		query.append("       ,(SELECT VSL_CD,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_ANR_VVD" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND SVC_RQST_NO = @[vvd]) REQTR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND CVSL.VSL_CALL_REF_STS_CD = 'Y'" ).append("\n"); 
		query.append("   AND CVSL.VSL_CALL_REF_NO	= CBL.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("   AND CBL.BKG_NO		  =	VDT.BKG_NO	" ).append("\n"); 
		query.append("   AND 'T'		      =	VDT.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("   AND 'NLRTM'		  =	VDT.POD_CD" ).append("\n"); 
		query.append("   AND CBL.BKG_NO		  =	VDU.BKG_NO	" ).append("\n"); 
		query.append("   AND 'U'	 	      =	VDU.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("   AND 'BEANR'		  =	VDU.POD_CD" ).append("\n"); 
		query.append("   AND CCNTR.BKG_NO		  =	CBL.BKG_NO	  " ).append("\n"); 
		query.append("   AND CCNTR.BKG_NO =  NCNTR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CCNTR.CNTR_NO =  NCNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND NCNTR.RTN_YD_CD = YD.YD_CD(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${vvd_size} == '6') " ).append("\n"); 
		query.append("   AND CVSL.VSL_CD = REQTR.VSL_CD" ).append("\n"); 
		query.append("   AND CVSL.SKD_VOY_NO = REQTR.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND CVSL.SKD_DIR_CD = REQTR.SKD_DIR_CD" ).append("\n"); 
		query.append("#else 	" ).append("\n"); 
		query.append("	AND CVSL.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND CVSL.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND CVSL.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   ORDER BY CCNTR.CNTR_NO" ).append("\n"); 

	}
}