/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchLoCalDateInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchLoCalDateInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLoCalDateInfoData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchLoCalDateInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchLoCalDateInfoDataRSQL").append("\n"); 
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
		query.append("	TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' ),SYSDATE,@[ofc_cd]),'YYYY-MM-DD') AS LOC_TIME," ).append("\n"); 
		query.append("	CASE WHEN TO_NUMBER(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' ),SYSDATE,@[ofc_cd]),'HH24')) < 8 THEN 'N'   --8시부터" ).append("\n"); 
		query.append("		 WHEN TO_NUMBER(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' ),SYSDATE,@[ofc_cd]),'HH24')) > 19 THEN 'N'       --7까지" ).append("\n"); 
		query.append("		 ELSE 'Y' END AS WORKENABLE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}