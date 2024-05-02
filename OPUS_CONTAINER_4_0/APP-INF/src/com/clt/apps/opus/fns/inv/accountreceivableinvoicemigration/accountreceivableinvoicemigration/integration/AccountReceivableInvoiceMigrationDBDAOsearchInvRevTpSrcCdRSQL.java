/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOsearchInvRevTpSrcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
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

public class AccountReceivableInvoiceMigrationDBDAOsearchInvRevTpSrcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountReceivableInvoiceMigrationDBDAOsearchInvRevTpSrcCdRSQL
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOsearchInvRevTpSrcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOsearchInvRevTpSrcCdRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[chg_cd], 'TVA', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MOC', 'XXX')" ).append("\n"); 
		query.append("                       , 'CTX', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MOC', DECODE(SUBSTR(LOC_CD,1,2),'JP','XXX',@[rev_tp_cd]||@[rev_src_cd]))" ).append("\n"); 
		query.append("                       , 'CDX', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MOC', DECODE(SUBSTR(LOC_CD,1,2),'JP','XXX',@[rev_tp_cd]||@[rev_src_cd]))" ).append("\n"); 
		query.append("                       , 'GST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MOC', DECODE(SUBSTR(LOC_CD,1,2),'IN','XXX',@[rev_tp_cd]||@[rev_src_cd]))" ).append("\n"); 
		query.append("                       , 'AST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MOC', DECODE(SUBSTR(LOC_CD,1,2),'AU','XXX',@[rev_tp_cd]||@[rev_src_cd]))" ).append("\n"); 
		query.append("                       , 'VDT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MOC', DECODE(SUBSTR(LOC_CD,1,2),'VN','XXX',@[rev_tp_cd]||@[rev_src_cd]))" ).append("\n"); 
		query.append("                       , 'VTT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MOC', DECODE(SUBSTR(LOC_CD,1,2),'VN','XXX',@[rev_tp_cd]||@[rev_src_cd]))" ).append("\n"); 
		query.append("                       , 'VRT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MOC', DECODE(SUBSTR(LOC_CD,1,2),'VN','XXX',@[rev_tp_cd]||@[rev_src_cd]))" ).append("\n"); 
		query.append("                       , 'FAC', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MOC', 'XXX')" ).append("\n"); 
		query.append("                       ,        DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MSO', 'XXX', 'MTP', 'XXX', @[rev_tp_cd]||@[rev_src_cd])) INV_REV_TP_SRC_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION A " ).append("\n"); 
		query.append(" WHERE A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}