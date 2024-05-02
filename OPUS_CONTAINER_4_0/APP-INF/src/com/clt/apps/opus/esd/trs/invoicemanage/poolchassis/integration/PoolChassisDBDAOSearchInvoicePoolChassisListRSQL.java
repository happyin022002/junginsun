/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolChassisDBDAOSearchInvoicePoolChassisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.08.11 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisDBDAOSearchInvoicePoolChassisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inovice Pool chassis 리스트를 조회
	  * </pre>
	  */
	public PoolChassisDBDAOSearchInvoicePoolChassisListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration ").append("\n"); 
		query.append("FileName : PoolChassisDBDAOSearchInvoicePoolChassisListRSQL").append("\n"); 
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
		query.append("SELECT INV_NO" ).append("\n"); 
		query.append(",INV_VNDR_SEQ" ).append("\n"); 
		query.append(",SUB_INV_SEQ" ).append("\n"); 
		query.append(",TRSP_POOL_CHSS_QTY" ).append("\n"); 
		query.append(",TRSP_POOL_CHSS_INV_AMT" ).append("\n"); 
		query.append(",TRSP_POOL_CHSS_TAX_AMT" ).append("\n"); 
		query.append(",TO_CHAR(HNDL_PRD_FM_DT, 'YYYYMMDD') HNDL_PRD_FM_DT" ).append("\n"); 
		query.append(",TO_CHAR(HNDL_PRD_TO_DT, 'YYYYMMDD') HNDL_PRD_TO_DT" ).append("\n"); 
		query.append("FROM TRS_TRSP_POOL_CHSS_INV" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND INV_VNDR_SEQ = @[paymt_sp_cd]" ).append("\n"); 

	}
}