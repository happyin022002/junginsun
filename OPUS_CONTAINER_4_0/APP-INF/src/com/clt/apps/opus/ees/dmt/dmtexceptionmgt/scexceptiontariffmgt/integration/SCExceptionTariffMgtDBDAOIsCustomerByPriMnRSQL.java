/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOIsCustomerByPriMnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.05
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.08.05 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOIsCustomerByPriMnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pri에 Customer가 존재하는지 체크한다
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOIsCustomerByPriMnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOIsCustomerByPriMnRSQL").append("\n"); 
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
		query.append("SELECT    COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM    PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append("WHERE   SP_PTY.PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("AND SP_PTY.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT  /*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */ AMDT_SEQ" ).append("\n"); 
		query.append("	FROM    PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("	WHERE   PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("	AND ROWNUM     = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SP_PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ = @[cust_seq]" ).append("\n"); 

	}
}