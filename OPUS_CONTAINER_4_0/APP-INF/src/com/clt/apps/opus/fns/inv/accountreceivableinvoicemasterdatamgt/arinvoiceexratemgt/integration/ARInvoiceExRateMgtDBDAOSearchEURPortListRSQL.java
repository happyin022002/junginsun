/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchEURPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchEURPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceExRateMgtDBDAOSearchEURPortListRSQL 
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchEURPortListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etda_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etda_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchEURPortListRSQL").append("\n"); 
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
		query.append("SELECT 	'' IO_BND_CD," ).append("\n"); 
		query.append("		B.VPS_PORT_CD VPS_PORT_CD, " ).append("\n"); 
		query.append("		(B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD) VVD_CD ," ).append("\n"); 
		query.append("		'' SVC_SCP_CD," ).append("\n"); 
		query.append("		'ETA' ETDA_CD," ).append("\n"); 
		query.append("		TO_CHAR(B.VPS_ETA_DT,'yyyymmdd') ETDA_DT," ).append("\n"); 
		query.append("		MAX(A.INV_XCH_RT) INV_XCH_RT , --2010-01-09 ivs_xch_rt 뺌" ).append("\n"); 
		query.append("        B.CLPT_SEQ" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD B,INV_VVD_XCH_RT A" ).append("\n"); 
		query.append("WHERE A.VSL_CD(+) = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO(+) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD(+) = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.PORT_CD(+) = B.VPS_PORT_CD" ).append("\n"); 
		query.append("AND A.LOCL_CURR_CD(+) = @[locl_curr_cd]" ).append("\n"); 
		query.append("AND A.CHG_CURR_CD(+) = 'USD'" ).append("\n"); 
		query.append("AND B.VPS_ETA_DT BETWEEN TO_DATE(@[etda_dt_fm],'YYYYMMDD') AND TO_DATE(@[etda_dt_to],'YYYYMMDD') + 0.99999 --20100126 " ).append("\n"); 
		query.append("AND B.VPS_PORT_CD IN (SELECT LOC_CD FROM MDM_LOCATION  WHERE CONTI_CD ='E')  --20100129" ).append("\n"); 
		query.append("AND NVL(B.SKD_CNG_STS_CD,'N') <>'S' --20100129" ).append("\n"); 
		query.append("AND (B.CLPT_SEQ,b.VSL_CD,b.SKD_VOY_NO,b.SKD_DIR_CD) in (" ).append("\n"); 
		query.append("						SELECT MIN(CLPT_SEQ) CLPT_SEQ,VSL_CD,SKD_VOY_NO,SKD_DIR_CD FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("						 WHERE VPS_PORT_CD IN (SELECT LOC_CD FROM MDM_LOCATION  WHERE CONTI_CD ='E')" ).append("\n"); 
		query.append("						   AND NVL(SKD_CNG_STS_CD,'N') <>'S'" ).append("\n"); 
		query.append("						   AND VPS_PORT_CD NOT LIKE 'IL%'" ).append("\n"); 
		query.append("						 GROUP BY VSL_CD,SKD_VOY_NO,SKD_DIR_CD )" ).append("\n"); 
		query.append("GROUP BY B.VPS_PORT_CD, B.VSL_CD,B.SKD_VOY_NO,B.SKD_DIR_CD, B.VPS_ETA_DT,B.CLPT_SEQ" ).append("\n"); 

	}
}