/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchOfficeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchOfficeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 유저의 소속 office 정보 조회
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchOfficeInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchOfficeInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[ofc_lvl_tp], 'QUERY', SOI.OFC_INQ_LVL_CD, SOI.OFC_ENTR_LVL_CD) OFC_ENTR_LVL_CD" ).append("\n"); 
		query.append("     , NVL(MO.AR_OFC_CD, MO.OFC_CD) AS AR_OFC_CD" ).append("\n"); 
		query.append("	 , NVL(SOI.OTS_CD, 'ARO') AS OTS_CD" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION  MO," ).append("\n"); 
		query.append("       SCO_OFC_INFO  SOI" ).append("\n"); 
		query.append("WHERE  MO.OFC_CD = @[usr_ofc_cd]" ).append("\n"); 
		query.append("AND    MO.AR_OFC_CD = SOI.OFC_CD(+)" ).append("\n"); 

	}
}