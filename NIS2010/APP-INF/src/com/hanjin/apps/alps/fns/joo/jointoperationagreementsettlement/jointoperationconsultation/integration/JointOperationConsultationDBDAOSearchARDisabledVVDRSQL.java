/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSearchARDisabledVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.29 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSearchARDisabledVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSearchARDisabledVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSearchARDisabledVVDRSQL").append("\n"); 
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
		query.append("SELECT  AR.RLANE_CD" ).append("\n"); 
		query.append(",       AR.VSL_CD" ).append("\n"); 
		query.append(",       AR.SKD_VOY_NO" ).append("\n"); 
		query.append(",       AR.SKD_DIR_CD" ).append("\n"); 
		query.append(",       AR.RLANE_DIR_CD" ).append("\n"); 
		query.append(",       NVL2(MAX(SL.VSL_CD), 'Y','N') SLIP_YN" ).append("\n"); 
		query.append(",       AR.EAI_EVNT_DT" ).append("\n"); 
		query.append("FROM    AR_MST_REV_VVD AR, JOO_SLIP SL" ).append("\n"); 
		query.append("WHERE   AR.EAI_EVNT_DT BETWEEN TO_DATE( REPLACE(@[eai_evnt_dt], '-','')||'01', 'YYYYMMDD')" ).append("\n"); 
		query.append("AND LAST_DAY(TO_DATE( REPLACE(@[eai_evnt_dt], '-','')||'01', 'YYYYMMDD') )" ).append("\n"); 
		query.append("AND    (INSTR( AR.REV_YRMON, '9999' ) >0" ).append("\n"); 
		query.append("OR      LOWER( AR.REV_YRMON ) = 'null'" ).append("\n"); 
		query.append("OR      AR.REV_YRMON  IS NULL)" ).append("\n"); 
		query.append("AND     AR.SKD_DIR_CD  IN ('E','W','S','N')--벌크선을 제외하기 위함." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SL.VSL_CD(+)=AR.VSL_CD" ).append("\n"); 
		query.append("AND SL.SKD_VOY_NO(+) = AR.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SL.SKD_DIR_CD(+)= AR.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SL.REV_DIR_CD(+) = AR.RLANE_DIR_CD" ).append("\n"); 
		query.append("GROUP BY AR.RLANE_CD" ).append("\n"); 
		query.append(",        AR.VSL_CD" ).append("\n"); 
		query.append(",        AR.SKD_VOY_NO" ).append("\n"); 
		query.append(",        AR.SKD_DIR_CD" ).append("\n"); 
		query.append(",        AR.RLANE_DIR_CD" ).append("\n"); 
		query.append(",        AR.EAI_EVNT_DT" ).append("\n"); 
		query.append("ORDER BY AR.RLANE_CD" ).append("\n"); 
		query.append(",        AR.VSL_CD" ).append("\n"); 
		query.append(",        AR.SKD_VOY_NO" ).append("\n"); 
		query.append(",        AR.SKD_DIR_CD" ).append("\n"); 
		query.append(",        AR.RLANE_DIR_CD" ).append("\n"); 

	}
}