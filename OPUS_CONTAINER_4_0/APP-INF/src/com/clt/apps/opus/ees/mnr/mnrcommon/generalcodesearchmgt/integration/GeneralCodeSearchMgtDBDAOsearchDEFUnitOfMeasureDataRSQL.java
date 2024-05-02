/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchDEFUnitOfMeasureDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2010.01.21 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchDEFUnitOfMeasureDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDEFUnitOfMeasureData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchDEFUnitOfMeasureDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchDEFUnitOfMeasureDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_MEAS_UT_CD" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_HDR A" ).append("\n"); 
		query.append("WHERE A.EFF_DT =" ).append("\n"); 
		query.append("(SELECT MAX(C.EFF_DT)" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_HDR C" ).append("\n"); 
		query.append("WHERE C.MNR_TRF_STS_CD NOT IN ('SD','HD')" ).append("\n"); 
		query.append("AND   C.MNR_TRF_KND_CD = 'STD'" ).append("\n"); 
		query.append("AND   C.MNR_TRF_STS_CD = 'HA'" ).append("\n"); 
		query.append("AND   TO_CHAR(C.EFF_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("AND   C.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}