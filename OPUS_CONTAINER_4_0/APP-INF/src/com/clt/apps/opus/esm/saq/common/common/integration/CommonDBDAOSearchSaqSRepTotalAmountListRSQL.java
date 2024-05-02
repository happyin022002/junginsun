/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqSRepTotalAmountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSaqSRepTotalAmountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기 S.Rep : T/B/L/RGN Volumn & Rev & CM Total Amount 조회
	  * </pre>
	  */
	public CommonDBDAOSearchSaqSRepTotalAmountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqtaRlseVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qtaTgtCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlaneCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dirCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgnOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqSRepTotalAmountListRSQL").append("\n"); 
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
		query.append("SELECT  SUM(LOD_QTY) || '|' || ROUND(SUM(LOD_QTY * GRS_RPB_REV)) || '|' ||   			    " ).append("\n"); 
		query.append("        ROUND(SUM(LOD_QTY * GRS_RPB_REV - LOD_QTY * RA_CM_UC_AMT))	AS  CODE ,			    " ).append("\n"); 
		query.append("        SUM(LOD_QTY) || '|' || ROUND(SUM(LOD_QTY * GRS_RPB_REV)) || '|' ||   			    " ).append("\n"); 
		query.append("        ROUND(SUM(LOD_QTY * GRS_RPB_REV - LOD_QTY * RA_CM_UC_AMT))	AS  TEXT  			    " ).append("\n"); 
		query.append("FROM    SAQ_MON_CFM_QTA                                                                      " ).append("\n"); 
		query.append("WHERE   1 = 1                                                                                " ).append("\n"); 
		query.append("AND     MQTA_RLSE_VER_NO    = @[mqtaRlseVerNo]                                                              " ).append("\n"); 
		query.append("AND     QTA_TGT_CD          = @[qtaTgtCd]                                                              " ).append("\n"); 
		query.append("AND     TRD_CD              = @[trdCd]                                                              " ).append("\n"); 
		query.append("AND     RLANE_CD 			LIKE @[rlaneCd] || '%'                                                   " ).append("\n"); 
		query.append("AND     DIR_CD              = @[dirCd]                                                              " ).append("\n"); 
		query.append("AND     RGN_OFC_CD          = @[rgnOfcCd]                                                              " ).append("\n"); 
		query.append("GROUP BY                                                                                     " ).append("\n"); 
		query.append("        BSE_YR      ,                                                                        " ).append("\n"); 
		query.append("        BSE_QTR_CD  ,                                                                        " ).append("\n"); 
		query.append("        TRD_CD      ,                                                                        " ).append("\n"); 
		query.append("		#if (${rlaneCd} != '' )" ).append("\n"); 
		query.append("		        RLANE_CD    ,                                                                        " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        DIR_CD      ,                                                                        " ).append("\n"); 
		query.append("        RGN_OFC_CD        " ).append("\n"); 

	}
}