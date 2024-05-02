/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOMultiMarineTerminalInvoiceAccumulatedVolumeInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.12 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOMultiMarineTerminalInvoiceAccumulatedVolumeInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiMarineTerminalInvoiceAccumulatedVolumeInsert
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOMultiMarineTerminalInvoiceAccumulatedVolumeInsertCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("revisedVol_sum",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("revisedVol_minus",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOMultiMarineTerminalInvoiceAccumulatedVolumeInsertCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_SO_ACCM" ).append("\n"); 
		query.append("( vndr_seq" ).append("\n"); 
		query.append(",accm_seq" ).append("\n"); 
		query.append(",pay_vol_qty" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",locl_cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append(",locl_upd_dt" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(   @[vndr_seq]," ).append("\n"); 
		query.append("@[accm_seq]," ).append("\n"); 
		query.append("( @[pay_vol_qty] + @[revisedVol_sum] - @[revisedVol_minus])," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}