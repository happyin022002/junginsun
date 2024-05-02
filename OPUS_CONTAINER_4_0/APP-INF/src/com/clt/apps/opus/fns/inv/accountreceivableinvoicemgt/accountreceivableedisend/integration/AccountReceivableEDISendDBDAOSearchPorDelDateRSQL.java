/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchPorDelDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchPorDelDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Por Del Date
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchPorDelDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchPorDelDateRSQL").append("\n"); 
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
		query.append("#if (${act_cd} == 'R')" ).append("\n"); 
		query.append("    MIN(TO_CHAR(B.ESTM_DT, 'YYYYMMDDHH24MI')) ESTM_DT" ).append("\n"); 
		query.append("    , MIN(TO_CHAR(B.ACT_DT, 'YYYYMMDDHH24MI')) ACT_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    MAX(TO_CHAR(B.ESTM_DT, 'YYYYMMDDHH24MI')) ESTM_DT" ).append("\n"); 
		query.append("    , MAX(TO_CHAR(B.ACT_DT, 'YYYYMMDDHH24MI')) ACT_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("     SCE_COP_DTL B," ).append("\n"); 
		query.append("     BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND A.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#if (${act_cd} == 'R')" ).append("\n"); 
		query.append("    AND B.ACT_CD = 'FOTMAD'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND B.ACT_CD = DECODE(C.DE_TERM_CD, 'Y', 'FITMDO', 'FITZAD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}