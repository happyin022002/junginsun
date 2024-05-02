/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOSearchLocStateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOSearchLocStateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location State
	  * </pre>
	  */
	public CustMainDBDAOSearchLocStateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchLocStateRSQL").append("\n"); 
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
		query.append("SELECT MS.IDA_STE_CD" ).append("\n"); 
		query.append("	, MS.STE_NM" ).append("\n"); 
		query.append("	, (SELECT CTCD.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CTCD WHERE MS.STE_CD = ML.STE_CD AND CTCD.INTG_CD_ID = 'CD03556' AND MS.IDA_TERR_DIV_CD = CTCD.INTG_CD_VAL_CTNT AND ROWNUM = 1) IDA_TERR_DIV_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION ML" ).append("\n"); 
		query.append("     ,MDM_STATE MS" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND ML.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND ML.DELT_FLG ='N'" ).append("\n"); 
		query.append("AND MS.DELT_FLG = 'N' " ).append("\n"); 
		query.append("AND ML.STE_CD = MS.STE_CD" ).append("\n"); 
		query.append("AND SUBSTR(ML.LOC_CD,1,2) = MS.CNT_CD" ).append("\n"); 

	}
}