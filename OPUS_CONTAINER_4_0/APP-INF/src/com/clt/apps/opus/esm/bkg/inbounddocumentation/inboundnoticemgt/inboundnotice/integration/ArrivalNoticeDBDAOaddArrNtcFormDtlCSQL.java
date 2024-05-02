/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOaddArrNtcFormDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOaddArrNtcFormDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Arrival Notice Detail Form insert
	  * </pre>
	  */
	public ArrivalNoticeDBDAOaddArrNtcFormDtlCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("an_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("an_fom_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("impt_ntc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO BKG_ARR_NTC_WD_DTL (" ).append("\n"); 
		query.append("AN_SEQ" ).append("\n"); 
		query.append(", AN_FOM_CD" ).append("\n"); 
		query.append(", ADDR_CTNT" ).append("\n"); 
		query.append(", IMPT_NTC_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[an_seq]" ).append("\n"); 
		query.append(", @[an_fom_cd]" ).append("\n"); 
		query.append(", @[addr_ctnt]" ).append("\n"); 
		query.append(", @[impt_ntc_rmk]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOaddArrNtcFormDtlCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}