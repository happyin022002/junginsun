/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOGetPreviousCheckKey0075RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.23 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentRHQDBDAOGetPreviousCheckKey0075RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOGetPreviousCheckKey0075RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_quarter",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaStepCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOGetPreviousCheckKey0075RSQL").append("\n"); 
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
		query.append("SELECT  MDL.MQTA_MDL_VER_NO,					" ).append("\n"); 
		query.append("        MDL.SLS_FCAST_PUB_NO,                   " ).append("\n"); 
		query.append("        VER.SAQ_STS_CD,                         " ).append("\n"); 
		query.append("        VER.INCL_PORT_FLG                       " ).append("\n"); 
		query.append("FROM   SAQ_MON_QTA_STEP_VER VER,                " ).append("\n"); 
		query.append("       SAQ_MON_QTA_GLINE_VER GVR,               " ).append("\n"); 
		query.append("       SAQ_MON_QTA_MDL_EXE MDL                  " ).append("\n"); 
		query.append("WHERE  VER.MQTA_STEP_CD = @[mQtaStepCd]                   " ).append("\n"); 
		query.append("AND    VER.BSE_YR = @[year]                         " ).append("\n"); 
		query.append("AND    VER.BSE_QTR_CD = @[bse_quarter]                     " ).append("\n"); 
		query.append("AND    VER.TRD_CD = @[trade]                         " ).append("\n"); 
		query.append("AND    VER.DIR_CD = @[bound]                         " ).append("\n"); 
		query.append("AND    VER.MQTA_VER_NO = @[mQtaVerNo]                    " ).append("\n"); 
		query.append("AND    GVR.BSE_YR = VER.BSE_YR                  " ).append("\n"); 
		query.append("AND    GVR.BSE_QTR_CD = VER.BSE_QTR_CD          " ).append("\n"); 
		query.append("AND    GVR.SAQ_TGT_GRP_CD = @[trade_group]                 " ).append("\n"); 
		query.append("AND    GVR.GLINE_VER_NO = VER.GLINE_VER_NO      " ).append("\n"); 
		query.append("AND    MDL.MQTA_MDL_VER_NO = GVR.MQTA_MDL_VER_NO" ).append("\n"); 

	}
}