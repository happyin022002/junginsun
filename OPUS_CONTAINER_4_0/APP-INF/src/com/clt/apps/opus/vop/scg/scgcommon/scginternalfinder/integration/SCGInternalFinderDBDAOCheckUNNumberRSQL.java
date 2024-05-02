/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCGInternalFinderDBDAOCheckUNNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGInternalFinderDBDAOCheckUNNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkUNNumber 및 조회한다.
	  * </pre>
	  */
	public SCGInternalFinderDBDAOCheckUNNumberRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_amdt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOCheckUNNumberRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    IMDG_UN_NO, MAX(CFR_FLG) AS CFR_FLG" ).append("\n"); 
		query.append(",	MAX(IMDG_UN_NO_SEQ)+1 AS IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append(",	MAX(IMDG_UN_NO_SEQ) AS IMDG_UN_NO_SEQ_MAX " ).append("\n"); 
		query.append(",	MIN(IMDG_UN_NO_SEQ) AS IMDG_UN_NO_SEQ_MIN " ).append("\n"); 
		query.append(",	(SELECT COUNT(IMDG_UN_NO_SEQ) FROM SCG_IMDG_UN_NO" ).append("\n"); 
		query.append("     WHERE	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("     #if (${cfr_flg} != '') " ).append("\n"); 
		query.append("         AND NVL(CFR_FLG,'F') = 'Y'--[cfr_flg]" ).append("\n"); 
		query.append("     #else" ).append("\n"); 
		query.append("         AND NVL(CFR_FLG,'F') <> 'Y'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${imdg_amdt_no} != '' && ${cfr_flg} == '')" ).append("\n"); 
		query.append("         AND IMDG_AMDT_NO = @[imdg_amdt_no]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     )         AS IMDG_UN_NO_SEQ_CNT" ).append("\n"); 
		query.append(",   NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,'GMT'), SYSDATE) AS UPD_DT" ).append("\n"); 
		query.append("--CFR_FLG" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO" ).append("\n"); 
		query.append("WHERE	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("#if (${cfr_flg} != '') " ).append("\n"); 
		query.append("AND NVL(CFR_FLG,'F') = 'Y'--[cfr_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NVL(CFR_FLG,'F') <> 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_amdt_no} != '' && ${cfr_flg} == '') " ).append("\n"); 
		query.append("AND IMDG_AMDT_NO = @[imdg_amdt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY IMDG_UN_NO" ).append("\n"); 

	}
}