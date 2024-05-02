/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOApPeriodChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 조병연
*@LastVersion : 1.0
* 2012.03.20 조병연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JO BYEANG YEAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOApPeriodChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TargetVVD 의 수정가능 여부를 해당 account year month의 마감여부로 결정한다
	  * close되면 수정불가
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOApPeriodChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOApPeriodChkRSQL").append("\n"); 
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
		query.append("SELECT CLZ_STS_CD AS CODE" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("               '1' AS SEQ," ).append("\n"); 
		query.append("               MAX(CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("       FROM    AP_PERIOD A" ).append("\n"); 
		query.append("       WHERE   SYS_DIV_CD   = DECODE(AR_AP_DIV_CD, 'R', '18', '19')" ).append("\n"); 
		query.append("       AND     EFF_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("       AND     AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("       AND     OFC_CD = (SELECT X.AP_OFC_CD" ).append("\n"); 
		query.append("                         FROM   MDM_ORGANIZATION X" ).append("\n"); 
		query.append("                         WHERE  X.OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("               '2' AS SEQ," ).append("\n"); 
		query.append("               MAX(CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("       FROM    AP_PERIOD A" ).append("\n"); 
		query.append("       WHERE   SYS_DIV_CD   = DECODE(AR_AP_DIV_CD, 'R', '18', '19')" ).append("\n"); 
		query.append("       AND     EFF_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("       AND     AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("       AND     OFC_CD = (SELECT X.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                         FROM   MDM_ORGANIZATION X," ).append("\n"); 
		query.append("                                MDM_ORGANIZATION Y" ).append("\n"); 
		query.append("                         WHERE  X.OFC_CD = Y.AP_OFC_CD" ).append("\n"); 
		query.append("                         AND    Y.OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("       ORDER BY 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE  CLZ_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}