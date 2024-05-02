/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOcheckDoublePayInvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2013.01.23 서관영
* 1.0 Creation
* 2013.01.24 SKY    CHM-201322525    Invoice creation 중복 account code 체크 로직 추가
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seo Kwan Young
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
	  * Double  Pay Check : VVD/YD_CD/COST_CD/COST_OFC 내에서 기존 Invoice가 존재하는지 유무 체크
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
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
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
		query.append("SELECT INV_NO " ).append("\n"); 
		query.append("FROM PSO_CHARGE PC, PSO_CHG_DTL PCD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PC.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND PC.COST_OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("AND PC.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND PCD.LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("AND PCD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND PCD.SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("AND PCD.SKD_DIR_CD =  @[skd_dir_cd]" ).append("\n"); 
		query.append("AND PC.ISS_CTY_CD = PCD.ISS_CTY_CD" ).append("\n"); 
		query.append("AND PC.SO_SEQ = PCD.SO_SEQ" ).append("\n"); 
		query.append("GROUP BY INV_NO" ).append("\n"); 

	}
}