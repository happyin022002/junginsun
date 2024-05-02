/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOcheckDoublePayInvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOcheckDoublePayInvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check Double pay
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOcheckDoublePayInvRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOcheckDoublePayInvRSQL").append("\n"); 
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
		query.append("WITH V_DATA AS (" ).append("\n"); 
		query.append("    SELECT INV_NO" ).append("\n"); 
		query.append("      FROM PSO_CHARGE PC" ).append("\n"); 
		query.append("         , PSO_CHG_DTL PCD" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND PC.VNDR_SEQ      = @[vndr_seq]" ).append("\n"); 
		query.append("       AND PC.COST_OFC_CD   = @[cost_ofc_cd]" ).append("\n"); 
		query.append("       AND PC.YD_CD         = @[yd_cd]" ).append("\n"); 
		query.append("       AND PCD.LGS_COST_CD  = @[cost_cd]" ).append("\n"); 
		query.append("       AND PCD.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("       AND PCD.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND PCD.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("       AND PCD.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("       AND PC.ISS_CTY_CD    = PCD.ISS_CTY_CD" ).append("\n"); 
		query.append("       AND PC.SO_SEQ        = PCD.SO_SEQ" ).append("\n"); 
		query.append("     GROUP BY INV_NO" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT INV_NO" ).append("\n"); 
		query.append("  FROM V_DATA A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.INV_NO <> @[inv_no]" ).append("\n"); 

	}
}