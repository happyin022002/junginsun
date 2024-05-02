/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBlPprMgmtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.20 
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

public class BLIssuanceDBDAOAddBlPprMgmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOAddBlPprMgmtCSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBlPprMgmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_dtrb_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddBlPprMgmtCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CUST_BL_PPR_MGMT " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   DTRB_YR" ).append("\n"); 
		query.append("  ,RHQ_CD" ).append("\n"); 
		query.append("  ,OFC_CD" ).append("\n"); 
		query.append("  ,CUST_CNT_CD" ).append("\n"); 
		query.append("  ,CUST_SEQ" ).append("\n"); 
		query.append("  ,CUST_DTRB_KNT" ).append("\n"); 
		query.append("  ,FM_SER_NO" ).append("\n"); 
		query.append("  ,TO_SER_NO" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  @[dtrb_yr]" ).append("\n"); 
		query.append(" ,@[rhq_cd]" ).append("\n"); 
		query.append(" ,@[ofc_cd]" ).append("\n"); 
		query.append(" ,@[cust_cnt_cd]" ).append("\n"); 
		query.append(" ,@[cust_seq]" ).append("\n"); 
		query.append(" ,@[cust_dtrb_knt]" ).append("\n"); 
		query.append(" ,''" ).append("\n"); 
		query.append(" ,''" ).append("\n"); 
		query.append(" ,@[usr_id]" ).append("\n"); 
		query.append(" ,sysdate" ).append("\n"); 
		query.append(" ,@[usr_id]" ).append("\n"); 
		query.append(" ,sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}