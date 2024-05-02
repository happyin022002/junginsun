/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortSelectPopupDBDAOMdmCountryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.04.13 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.portselectpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSelectPopupDBDAOMdmCountryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_COUNTRY 테이블 조회
	  * </pre>
	  */
	public PortSelectPopupDBDAOMdmCountryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.portselectpopup.integration").append("\n"); 
		query.append("FileName : PortSelectPopupDBDAOMdmCountryVORSQL").append("\n"); 
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
		query.append("	CNT_CD," ).append("\n"); 
		query.append("	CNT_NM," ).append("\n"); 
		query.append("	SCONTI_CD," ).append("\n"); 
		query.append("	CURR_CD," ).append("\n"); 
		query.append("	FRGN_VAT_FLG," ).append("\n"); 
		query.append("	ZN_DIV_BSEL_CD," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("	DELT_FLG," ).append("\n"); 
		query.append("	EAI_EVNT_DT," ).append("\n"); 
		query.append("	BKG_ADDR_ORD_CD," ).append("\n"); 
		query.append("	BKG_ADDR_ORD_DESC" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CNT_CD" ).append("\n"); 

	}
}