/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOModifyMarineTerminalInvoiceAccumulatedVolumeInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.07 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOModifyMarineTerminalInvoiceAccumulatedVolumeInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyMarineTerminalInvoiceAccumulatedVolumeInsert
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOModifyMarineTerminalInvoiceAccumulatedVolumeInsertCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration ").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOModifyMarineTerminalInvoiceAccumulatedVolumeInsertCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_SO_ACCM(" ).append("\n"); 
		query.append("VNDR_SEQ" ).append("\n"); 
		query.append(",ACCM_SEQ" ).append("\n"); 
		query.append(",PAY_VOL_QTY" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")VALUES(			      @[vndr_seq]  									-- VNDR_SEQ" ).append("\n"); 
		query.append(", @[accm_seq] 									-- ACCM_SEQ" ).append("\n"); 
		query.append(", replace(@[pay_vol_qty],',')  					-- PAY_VOL_QTY" ).append("\n"); 
		query.append(", @[cre_usr_id]  								-- CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE										-- CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id]  								-- UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE ) -- UPD_DT" ).append("\n"); 

	}
}