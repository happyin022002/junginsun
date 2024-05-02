/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOCheckRegisteredYardOrCostOrVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.26 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOCheckRegisteredYardOrCostOrVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard/Cost/Vendor의 INV_OFC 등록 여부
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOCheckRegisteredYardOrCostOrVendorRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOCheckRegisteredYardOrCostOrVendorRSQL").append("\n"); 
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
		query.append("SELECT  MAX(X.IS_YD)   IS_YD" ).append("\n"); 
		query.append(",MAX(X.IS_COST) IS_COST" ).append("\n"); 
		query.append(",MAX(X.IS_VNDR) IS_VNDR" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT NVL(MAX(1), 0) IS_YD" ).append("\n"); 
		query.append(",0              IS_COST" ).append("\n"); 
		query.append(",0              IS_VNDR" ).append("\n"); 
		query.append("FROM   PSO_INV_OFC_YD A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 0              IS_YD" ).append("\n"); 
		query.append(",NVL(MAX(1), 0) IS_COST" ).append("\n"); 
		query.append(",0              IS_VNDR" ).append("\n"); 
		query.append("FROM   PSO_INV_OFC_COST A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    A.LGS_COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 0              IS_YD" ).append("\n"); 
		query.append(",0              IS_COST" ).append("\n"); 
		query.append(",NVL(MAX(1), 0) IS_VNDR" ).append("\n"); 
		query.append("FROM   PSO_INV_OFC_VNDR A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}