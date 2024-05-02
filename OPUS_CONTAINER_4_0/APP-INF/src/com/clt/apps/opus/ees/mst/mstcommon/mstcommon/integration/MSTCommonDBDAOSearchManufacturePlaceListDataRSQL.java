/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MSTCommonDBDAOSearchManufacturePlaceListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MSTCommonDBDAOSearchManufacturePlaceListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchManufacturePlaceListDataRSQL
	  * </pre>
	  */
	public MSTCommonDBDAOSearchManufacturePlaceListDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration").append("\n"); 
		query.append("FileName : MSTCommonDBDAOSearchManufacturePlaceListDataRSQL").append("\n"); 
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
		query.append("WITH PARAM" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("SELECT @[loc_cd] CODE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.MNR_CD_ID  CODE,A.MNR_CD_DP_DESC CODE_NM" ).append("\n"); 
		query.append("FROM  MNR_GEN_CD A, PARAM P" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("AND A.MNR_CD_ID = P.CODE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.PRNT_CD_ID ='POM'" ).append("\n"); 
		query.append("ORDER BY A.MNR_CD_ID" ).append("\n"); 

	}
}