/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetCopyVO0163Tab01CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetCopyVO0163Tab01CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetCopyVO0163Tab01CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("copy_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("copy_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration").append("\n"); 
		query.append("FileName : MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetCopyVO0163Tab01CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_LOD_TGT_OFC(                                                                            " ).append("\n"); 
		query.append("                 BSE_YR    , BSE_QTR_CD , TRD_CD    , DIR_CD,                                               " ).append("\n"); 
		query.append("                 SLS_RHQ_CD, COND_STS_CD, CRE_USR_ID, CRE_DT,                                               " ).append("\n"); 
		query.append("                 UPD_USR_ID, UPD_DT  )                                                                      " ).append("\n"); 
		query.append("SELECT @[bse_yr], @[bse_qtr_cd], TRD_CD, DIR_CD, SLS_RHQ_CD, '0', @[cre_usr_id], SYSDATE, @[cre_usr_id], SYSDATE      " ).append("\n"); 
		query.append("  FROM SAQ_MON_LOD_TGT_OFC" ).append("\n"); 
		query.append("      ,SAQ_ORGANIZATION_V" ).append("\n"); 
		query.append(" WHERE BSE_YR     = @[copy_bse_yr]                                                                          " ).append("\n"); 
		query.append("   AND BSE_QTR_CD = @[copy_bse_qtr_cd]" ).append("\n"); 
		query.append("   AND LVL      = '2'" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND OFC_CD   = SLS_RHQ_CD" ).append("\n"); 

	}
}