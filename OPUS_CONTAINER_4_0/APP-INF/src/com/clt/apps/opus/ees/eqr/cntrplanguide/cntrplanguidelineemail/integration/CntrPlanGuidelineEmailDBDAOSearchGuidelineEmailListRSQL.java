/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrPlanGuidelineEmailDBDAOSearchGuidelineEmailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineEmailDBDAOSearchGuidelineEmailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Email 수신자 목록 조회
	  * </pre>
	  */
	public CntrPlanGuidelineEmailDBDAOSearchGuidelineEmailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhqcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofccd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineEmailDBDAOSearchGuidelineEmailListRSQL").append("\n"); 
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
		query.append("SELECT A.GLINE_RCPT_USR_ID" ).append("\n"); 
		query.append("      ,B.USR_NM" ).append("\n"); 
		query.append("      ,C.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("      ,C.OFC_CD" ).append("\n"); 
		query.append("      ,A.GLINE_RCPT_EML " ).append("\n"); 
		query.append("FROM EQR_CTRL_GLINE_EML_RCPT A" ).append("\n"); 
		query.append("    ,COM_USER B" ).append("\n"); 
		query.append("    ,MDM_ORGANIZATION C" ).append("\n"); 
		query.append("WHERE A.GLINE_RCPT_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("AND   B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_rhqcd} != '' && ${f_rhqcd} != 'OTHER') " ).append("\n"); 
		query.append("AND C.AR_HD_QTR_OFC_CD = @[f_rhqcd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${f_rhqcd} == 'OTHER') " ).append("\n"); 
		query.append("AND C.AR_HD_QTR_OFC_CD NOT IN ('NYCNA','HAMUR','SHAAS','SINWA')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ofccd} != '' ) " ).append("\n"); 
		query.append("AND B.OFC_CD = @[f_ofccd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}