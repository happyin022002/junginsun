/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfVolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfVolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfVolRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfVolRSQL").append("\n"); 
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
		query.append("SELECT UNLD_TP_CD, WHF_VOL_DC_CD, WHF_RT, " ).append("\n"); 
		query.append("       SUM(WHF_RT_AMT) AS WHF_RT_AMT," ).append("\n"); 
		query.append("       SUM(RTON_WGT) AS RTON_WFT," ).append("\n"); 
		query.append("       SUM(EXPT_TON_WGT) AS EXPT_TON_WGT," ).append("\n"); 
		query.append("       MF_REF_NO," ).append("\n"); 
		query.append("       EDI_MSG_SND_ID," ).append("\n"); 
		query.append("       WHF_PAY_DT, " ).append("\n"); 
		query.append("       WHF_NTC_DT," ).append("\n"); 
		query.append("       WHF_USR_NM, " ).append("\n"); 
		query.append("       WHF_CUST_KND_CD, " ).append("\n"); 
		query.append("       PORT_NM, " ).append("\n"); 
		query.append("       SUM(NTC_AMT) AS NTC_AMT," ).append("\n"); 
		query.append("       SUM(RDUC_AMT) AS RDUC_AMT," ).append("\n"); 
		query.append("       SUM(COMM_AMT) AS COMM_AMT" ).append("\n"); 
		query.append("  FROM BKG_KR_WHF_VOL" ).append("\n"); 
		query.append(" WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND WHF_BND_CD IN (DECODE(@[whf_bnd_cd], 'IN', 'II','ON', 'OO', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IT','ON', 'OT', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IM','ON', 'OM', @[whf_bnd_cd]))" ).append("\n"); 
		query.append(" GROUP BY UNLD_TP_CD, WHF_VOL_DC_CD, WHF_RT, " ).append("\n"); 
		query.append("       MF_REF_NO," ).append("\n"); 
		query.append("       EDI_MSG_SND_ID," ).append("\n"); 
		query.append("       WHF_PAY_DT, " ).append("\n"); 
		query.append("       WHF_NTC_DT," ).append("\n"); 
		query.append("       WHF_USR_NM, " ).append("\n"); 
		query.append("       WHF_CUST_KND_CD, " ).append("\n"); 
		query.append("       PORT_NM" ).append("\n"); 

	}
}