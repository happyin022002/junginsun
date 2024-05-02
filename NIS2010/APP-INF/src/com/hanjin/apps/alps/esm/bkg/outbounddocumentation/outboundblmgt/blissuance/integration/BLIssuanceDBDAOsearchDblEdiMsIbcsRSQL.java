/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiMsIbcsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.29 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiMsIbcsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiMsIbcsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiMsIbcsRSQL").append("\n"); 
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
		query.append("SELECT 'MS_IBCS_NM1:'   || BKG_TOKEN_NL_FNC(NVL(CUST_NM,''), 1, '')   || CHR(10)||" ).append("\n"); 
		query.append("'MS_IBCS_NM2:'   || BKG_TOKEN_NL_FNC(NVL(CUST_NM,''), 2, '')   || CHR(10)||" ).append("\n"); 
		query.append("'MS_IBCS_ADDR1:' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR,''), 1, '') || CHR(10)||" ).append("\n"); 
		query.append("'MS_IBCS_ADDR2:' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR,''), 2, '') || CHR(10)||" ).append("\n"); 
		query.append("'MS_IBCS_ADDR3:' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR,''), 3, '') || CHR(10)||" ).append("\n"); 
		query.append("'MS_CUST_CD:'    || CUST_SEQ" ).append("\n"); 
		query.append("FROM   BKG_XTER_CUST" ).append("\n"); 
		query.append("WHERE  XTER_RQST_NO = @[ib_no]" ).append("\n"); 
		query.append("AND    XTER_CUST_TP_CD ='MS'" ).append("\n"); 
		query.append("AND    XTER_SNDR_ID = @[edi_receive_id]" ).append("\n"); 
		query.append("ORDER BY XTER_RQST_NO DESC" ).append("\n"); 

	}
}