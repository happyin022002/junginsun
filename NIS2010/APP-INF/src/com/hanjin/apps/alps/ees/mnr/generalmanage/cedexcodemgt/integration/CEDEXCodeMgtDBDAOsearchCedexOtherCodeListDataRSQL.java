/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtDBDAOsearchCedexOtherCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.28 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 함형석
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CEDEXCodeMgtDBDAOsearchCedexOtherCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCedexOtherCodeListData
	  * </pre>
	  */
	public CEDEXCodeMgtDBDAOsearchCedexOtherCodeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cedex_otr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cedex_otr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.integration").append("\n"); 
		query.append("FileName : CEDEXCodeMgtDBDAOsearchCedexOtherCodeListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.EQ_CEDEX_OTR_TP_CD," ).append("\n"); 
		query.append("A.EQ_CEDEX_OTR_CD," ).append("\n"); 
		query.append("A.EQ_CEDEX_OTR_NUM_CD," ).append("\n"); 
		query.append("A.EQ_CEDEX_OTR_CD_NM," ).append("\n"); 
		query.append("A.EQ_CEDEX_OTR_CD_DESC," ).append("\n"); 
		query.append("A.EQ_KND_CD," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append("FROM MNR_CEDEX_OTR_CD A" ).append("\n"); 
		query.append("WHERE	A.EQ_CEDEX_OTR_TP_CD = @[eq_cedex_otr_tp_cd]" ).append("\n"); 
		query.append("#if (${eq_cedex_otr_cd} != 'All')" ).append("\n"); 
		query.append("AND	A.EQ_CEDEX_OTR_CD = @[eq_cedex_otr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}