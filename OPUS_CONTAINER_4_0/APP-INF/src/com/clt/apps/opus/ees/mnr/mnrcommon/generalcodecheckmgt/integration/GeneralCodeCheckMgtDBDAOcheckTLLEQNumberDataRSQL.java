/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOcheckTLLEQNumberDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.12.03 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungBuebKwon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOcheckTLLEQNumberDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkTLLEQNumberData
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOcheckTLLEQNumberDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOcheckTLLEQNumberDataRSQL").append("\n"); 
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
		query.append("SELECT ESV.EQ_NO AS CD_ID," ).append("\n"); 
		query.append("NVL((SELECT 'Aleady Total Loss Processed'" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL MTD" ).append("\n"); 
		query.append("WHERE MTD.RQST_EQ_NO = ESV.EQ_NO" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("#if(${ttl_no} != 'NEW' && ${ttl_no} != '')" ).append("\n"); 
		query.append("AND MTD.TTL_LSS_NO <> @[ttl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("), 'OK') AS CD_DESC" ).append("\n"); 
		query.append("FROM MNR_EQ_STS_V ESV" ).append("\n"); 
		query.append("WHERE ESV.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND ESV.EQ_TYPE = @[eq_type]" ).append("\n"); 
		query.append("AND ESV.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND ESV.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}