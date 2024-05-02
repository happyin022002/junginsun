/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOsearchREVTypeSourceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOsearchREVTypeSourceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountReceivableInvoiceMigrationDBDAOsearchREVTypeSourceRSQL
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOsearchREVTypeSourceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("if_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOsearchREVTypeSourceRSQL").append("\n"); 
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
		query.append("#if (${if_tp_cd} == 'BKG') " ).append("\n"); 
		query.append("SELECT DECODE(ACCT_CD, '110821', 'M', '111091', 'M', '110611', 'B', 'B') REV_TP_CD " ).append("\n"); 
		query.append("	 , DECODE(ACCT_CD, '110821', 'DM', '111091', 'RD', '110611', 'BL', 'BL') REV_SRC_CD" ).append("\n"); 
		query.append("  FROM MIGADM.MIG_INV_BKG_IF_CHG" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_SEQ = @[bkg_seq]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT 'M' REV_TP_CD " ).append("\n"); 
		query.append("     , DECODE(@[if_src_cd], 'DEM','DM', 'DET','DT', SUBSTR(@[if_src_cd],2,2)) REV_SRC_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}