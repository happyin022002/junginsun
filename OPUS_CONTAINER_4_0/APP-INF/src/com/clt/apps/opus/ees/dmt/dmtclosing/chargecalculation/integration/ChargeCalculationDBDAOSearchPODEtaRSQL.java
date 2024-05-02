/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchPODEtaRSQL.java
*@FileTitle : Manual Batch by POD ETA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.03 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchPODEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POD ETA 날짜를 조회한다
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchPODEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchPODEtaRSQL").append("\n"); 
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
		query.append("SELECT	TO_CHAR(V.VPS_ETA_DT,'YYYYMMDD') VPS_ETA_DT" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE	V.VSL_CD		= SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND		V.SKD_VOY_NO	= SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND		V.SKD_DIR_CD	= SUBSTR(@[vvd_cd],9)" ).append("\n"); 
		query.append("AND		V.VPS_PORT_CD	= SUBSTR(@[fm_mvmt_yd_cd],1,5)" ).append("\n"); 
		query.append("AND		V.CLPT_IND_SEQ	= 1" ).append("\n"); 

	}
}