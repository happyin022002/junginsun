/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManagerDBDAOVerifyECCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2010.01.07 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManagerDBDAOVerifyECCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * From Nod와 To Nod가 동일 ECC_CD인지 확인
	  * </pre>
	  */
	public SingleTransportationSOManagerDBDAOVerifyECCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManagerDBDAOVerifyECCRSQL").append("\n"); 
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
		query.append("SELECT 'X' ECC_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append(",   MDM_LOCATION   B" ).append("\n"); 
		query.append(",  (SELECT" ).append("\n"); 
		query.append("YD_CD" ).append("\n"); 
		query.append(",   LOC_CD" ).append("\n"); 
		query.append("FROM MDM_YARD Y" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("Y.YD_CD = @[fm_nod_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LSE_CO_YD_CD" ).append("\n"); 
		query.append(",   SUBSTR(LSE_CO_YD_CD, 1, 5)" ).append("\n"); 
		query.append("FROM MDM_LSE_CO_YD L" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("L.LSE_CO_YD_CD = @[fm_nod_cd]" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append(",   MDM_LOCATION   B" ).append("\n"); 
		query.append(",  (SELECT" ).append("\n"); 
		query.append("YD_CD" ).append("\n"); 
		query.append(",   LOC_CD" ).append("\n"); 
		query.append("FROM MDM_YARD Y" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("Y.YD_CD = @[to_nod_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LSE_CO_YD_CD" ).append("\n"); 
		query.append(",   SUBSTR(LSE_CO_YD_CD, 1, 5)" ).append("\n"); 
		query.append("FROM MDM_LSE_CO_YD L" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("L.LSE_CO_YD_CD = @[to_nod_cd]" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("WHERE AA.ECC_CD = BB.ECC_CD" ).append("\n"); 

	}
}