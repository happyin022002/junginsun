/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiCntrMfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiCntrMfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiCntrMfRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiCntrMfRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_DESC' || CHR(10)" ).append("\n"); 
		query.append("|| 'D_CMDT:' || CHR(10)" ).append("\n"); 
		query.append("|| 'D_PUNIT:' || PCK_TP_CD || CHR(10)" ).append("\n"); 
		query.append("|| 'D_PKG:' || PCK_QTY || CHR(10)" ).append("\n"); 
		query.append("|| 'D_WGT:' || CNTR_MF_WGT || CHR(10)" ).append("\n"); 
		query.append("|| 'D_MEAS:' || MEAS_QTY || CHR(10)" ).append("\n"); 
		query.append("|| 'D_DESC:' || REPLACE(TO_CLOB(CNTR_MF_GDS_DESC), CHR(13)||CHR(10), ' ') || CHR(10)" ).append("\n"); 
		query.append("|| '{CUS_MARK' || CHR(10)" ).append("\n"); 
		query.append("|| 'D_MARK:' || REPLACE(TO_CLOB(CNTR_MF_MK_DESC), CHR(13)||CHR(10), CHR(10) || 'D_MARK:')|| CHR(10)" ).append("\n"); 
		query.append("|| '}CUS_MARK' || CHR(10)" ).append("\n"); 
		query.append("|| '}CNTR_DESC' || CHR(10)" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}