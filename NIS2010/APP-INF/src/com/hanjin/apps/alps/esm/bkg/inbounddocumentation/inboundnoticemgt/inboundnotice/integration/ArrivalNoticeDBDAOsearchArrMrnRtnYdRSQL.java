/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrMrnRtnYdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2010.03.23 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrMrnRtnYdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrMrnRtnYdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrMrnRtnYdRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,(SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = ACNTR.BKG_NO) AS BL_NO " ).append("\n"); 
		query.append("      ,ACNTR.BKG_NO" ).append("\n"); 
		query.append("      ,ACNTR.CNTR_NO " ).append("\n"); 
		query.append("      ,NVL(NCNTR.MVMT_REF_NO,'') VSL_MRN_NO" ).append("\n"); 
		query.append("      ,NVL(NCNTR.RTN_YD_CD,'')   MTY_RTN_YD_CD" ).append("\n"); 
		query.append("      ,NVL(TRANSLATE(NCNTR.MTY_RTN_YD_NM, CHR(13)||CHR(10), ' '), YD.YD_NM) RTN_REF_NO" ).append("\n"); 
		query.append("      ,VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("	  ,'' POD_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ANR_CNTR ACNTR" ).append("\n"); 
		query.append("       ,BKG_ARR_NTC_CNTR NCNTR" ).append("\n"); 
		query.append("       ,MDM_YARD YD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_size} == '6')" ).append("\n"); 
		query.append("       ,(SELECT VSL_CD,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_ANR_VVD" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND SVC_RQST_NO = @[vvd]) REQTR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_size} == '6') " ).append("\n"); 
		query.append("   AND VSL_CD = REQTR.VSL_CD" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = REQTR.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = REQTR.SKD_DIR_CD" ).append("\n"); 
		query.append("#else 	" ).append("\n"); 
		query.append("	AND VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND ACNTR.BKG_NO =  NCNTR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ACNTR.CNTR_NO =  NCNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND NCNTR.RTN_YD_CD = YD.YD_CD(+)" ).append("\n"); 
		query.append("   ORDER BY ACNTR.CNTR_NO" ).append("\n"); 

	}
}