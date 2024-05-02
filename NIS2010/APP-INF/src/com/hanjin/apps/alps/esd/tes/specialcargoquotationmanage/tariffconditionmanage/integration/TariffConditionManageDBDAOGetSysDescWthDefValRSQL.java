/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TariffConditionManageDBDAOGetSysDescWthDefValRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffConditionManageDBDAOGetSysDescWthDefValRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 유효성 확인 위한 CONDITION식 추출
	  * </pre>
	  */
	public TariffConditionManageDBDAOGetSysDescWthDefValRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration").append("\n"); 
		query.append("FileName : TariffConditionManageDBDAOGetSysDescWthDefValRSQL").append("\n"); 
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
		query.append("LTRIM(MAX(SYS_CONNECT_BY_PATH(OBJ_NM,' ')),' ') SYS_DESC_WTH_DEFVAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM ROW_ID," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN D.TML_COND_DTL_TP_CD IN ('O')" ).append("\n"); 
		query.append("THEN DECODE(O.TML_VAL_TP_CD,'S',NVL(O.DFLT_CTNT,O.OBJ_LIST_ABBR_NM),'N',NVL(O.DFLT_VAL,TO_NUMBER('')),'')" ).append("\n"); 
		query.append("WHEN D.TML_COND_DTL_TP_CD IN ('P')" ).append("\n"); 
		query.append("THEN O.OBJ_LIST_ABBR_NM" ).append("\n"); 
		query.append("WHEN D.TML_COND_DTL_TP_CD IN ('C')" ).append("\n"); 
		query.append("THEN D.COND_OPR_VAL_CTNT" ).append("\n"); 
		query.append("END OBJ_NM" ).append("\n"); 
		query.append("FROM TES_TRF_COND C, TES_TRF_COND_DTL D, TES_OBJ_LIST O" ).append("\n"); 
		query.append("WHERE C.COND_NO =  @[cond_no]" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND D.COND_DTL_USE_TP_CD = 'S'" ).append("\n"); 
		query.append("AND C.COND_NO = D.COND_NO" ).append("\n"); 
		query.append("AND D.OBJ_LIST_NO = O.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("AND NVL(O.DELT_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("START WITH ROW_ID = 1" ).append("\n"); 

	}
}