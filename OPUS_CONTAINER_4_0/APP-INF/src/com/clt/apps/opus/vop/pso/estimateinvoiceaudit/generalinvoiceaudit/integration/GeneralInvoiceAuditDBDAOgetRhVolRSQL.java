/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetRhVolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetRhVolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 Rehandling Volume을 구한다.
	  * [2015.09.09]TON > TEU(D2외 사이즈 카운터 *2)
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetRhVolRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetRhVolRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(DECODE(CNTR_SIZE,'2',1,2)),0)" ).append("\n"); 
		query.append("  FROM TDR_CNTR_DETAIL" ).append("\n"); 
		query.append(" WHERE VSL_CD   = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND DIR_CD   = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND PORT_CD  = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("   AND CALL_IND = @[clpt_ind_seq]" ).append("\n"); 
		query.append("   AND PRECELL IS NOT NULL" ).append("\n"); 
		query.append("   AND STATUS   = 'ST'" ).append("\n"); 

	}
}