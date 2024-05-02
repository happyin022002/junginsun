/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TransferOrderIssueDBDAOBkgTroActRepExtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOBkgTroActRepExtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0905_tab2 master select sql
	  * </pre>
	  */
	public TransferOrderIssueDBDAOBkgTroActRepExtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_act_rep_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOBkgTroActRepExtVORSQL").append("\n"); 
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
		query.append("SELECT 'E' TRO_ACT_CUST_KND_CD," ).append("\n"); 
		query.append("       REP.OFC_CD," ).append("\n"); 
		query.append("       REP.TRO_ACT_REP_SEQ," ).append("\n"); 
		query.append("       REP.TRO_ACT_REP_NM" ).append("\n"); 
		query.append("  FROM BKG_TRO_ACT_REP REP," ).append("\n"); 
		query.append("       BKG_TRO_ACT_CUST CUST" ).append("\n"); 
		query.append(" WHERE REP.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND CUST.TRO_ACT_CUST_KND_CD(+) = 'E'" ).append("\n"); 
		query.append("   AND REP.TRO_ACT_REP_SEQ = CUST.TRO_ACT_REP_SEQ(+)" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("   AND REP.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tro_act_rep_nm} != '') " ).append("\n"); 
		query.append("  AND UPPER(REP.TRO_ACT_REP_NM) like UPPER(@[tro_act_rep_nm])||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("  AND CUST.LOC_CD(+) = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}