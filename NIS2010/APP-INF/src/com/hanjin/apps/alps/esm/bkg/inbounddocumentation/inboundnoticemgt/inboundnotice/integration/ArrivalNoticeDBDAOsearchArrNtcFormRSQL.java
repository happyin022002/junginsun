/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcFormRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.08.20 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcFormRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Arrival Notice Form Inquery
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcFormRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcFormRSQL").append("\n"); 
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
		query.append("AN_SEQ" ).append("\n"); 
		query.append(",	AN_TP_CD" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	CHN_AGN_CD" ).append("\n"); 
		query.append(",	LOCL_LANG_FLG" ).append("\n"); 
		query.append(",	ARR_PRV_FOM_CD" ).append("\n"); 
		query.append(",	ECLZ_BL_CPY_FLG" ).append("\n"); 
		query.append(",	ADDR_CTNT" ).append("\n"); 
		query.append(",	IMPT_NTC_RMK" ).append("\n"); 
		query.append(",	BANK_IN_ACCT_CTNT" ).append("\n"); 
		query.append("FROM BKG_ARR_NTC_WD a" ).append("\n"); 
		query.append("WHERE A.AN_TP_CD = 'ARN'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.POD_CD = '*'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chn_agn_cd} != '')" ).append("\n"); 
		query.append("AND A.CHN_AGN_CD = @[chn_agn_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.CHN_AGN_CD = '*'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}