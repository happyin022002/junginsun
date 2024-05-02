/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortTariffMgtDBDAOsearchPortTariffDtlRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtDBDAOsearchPortTariffDtlRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPortTariffDtlRemark
	  * </pre>
	  */
	public PortTariffMgtDBDAOsearchPortTariffDtlRemarkRSQL(){
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtDBDAOsearchPortTariffDtlRemarkRSQL").append("\n"); 
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
		query.append("		  select  " ).append("\n"); 
		query.append("                  max(T2.DIFF_RMK)      AS PORT_TRF_RMK" ).append("\n"); 
		query.append("            from  PSO_CHARGE			T1" ).append("\n"); 
		query.append("                 ,PSO_CHG_DTL			T2" ).append("\n"); 
		query.append("           where  T1.ISS_CTY_CD = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("             and  T1.SO_SEQ = T2.SO_SEQ" ).append("\n"); 
		query.append("             and  T1.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("             and  T1.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("          group by T2.ISS_CTY_CD, T2.SO_SEQ, T2.ORG_SO_DTL_SEQ" ).append("\n"); 

	}
}