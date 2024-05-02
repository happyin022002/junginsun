/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOmodifyPsoChargeStausUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.02.18 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOmodifyPsoChargeStausUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyPsoChargeStaus
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOmodifyPsoChargeStausUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pso_chg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOmodifyPsoChargeStausUSQL").append("\n"); 
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
		query.append("UPDATE PSO_CHARGE SET" ).append("\n"); 
		query.append("PSO_CHG_STS_CD = @[pso_chg_sts_cd]," ).append("\n"); 
		query.append("INV_RGST_NO = @[inv_rgst_no]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
		query.append("#if(${iss_city_cd}!=''&&${so_seq}!='')" ).append("\n"); 
		query.append("AND ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("AND	SO_SEQ = @[so_seq]" ).append("\n"); 
		query.append("#elseif(${vndr_seq} != '' && ${yd_cd} != '' && ${inv_no} != '')" ).append("\n"); 
		query.append("AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ISS_CTY_CD = (SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("ISS_CTY_CD FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("WHERE T1.ISS_CTY_CD = SUBSTR(@[inv_ofc_cd], 1, 3)" ).append("\n"); 
		query.append("AND T1.SO_SEQ >= 0" ).append("\n"); 
		query.append("AND ROWNUM<=1)" ).append("\n"); 
		query.append("AND	SO_SEQ = (SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("SO_SEQ FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("WHERE T1.ISS_CTY_CD = SUBSTR(@[inv_ofc_cd], 1, 3)" ).append("\n"); 
		query.append("AND T1.SO_SEQ >= 0" ).append("\n"); 
		query.append("AND ROWNUM<=1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}