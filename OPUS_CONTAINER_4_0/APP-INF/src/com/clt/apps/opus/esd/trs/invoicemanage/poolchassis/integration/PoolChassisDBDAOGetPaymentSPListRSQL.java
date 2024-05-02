/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolChassisDBDAOGetPaymentSPListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.08.11 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisDBDAOGetPaymentSPListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payment VNDR Info을 가져온다
	  * </pre>
	  */
	public PoolChassisDBDAOGetPaymentSPListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration").append("\n"); 
		query.append("FileName : PoolChassisDBDAOGetPaymentSPListRSQL").append("\n"); 
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
		query.append("SELECT CHSS_POOL_CD" ).append("\n"); 
		query.append(",INV_VNDR_SEQ" ).append("\n"); 
		query.append(",CHSS_POOL_NM" ).append("\n"); 
		query.append(",VNDR_CNT_CD" ).append("\n"); 
		query.append(",INV_PAY_VNDR_NM" ).append("\n"); 
		query.append("FROM TRS_TRSP_CHSS_POOL" ).append("\n"); 
		query.append("WHERE CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}