/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchPortTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.30
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.09.30 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchPortTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD, Yard의 Port Type을 조회한다.
	  * 
	  * ============================
	  * History
	  * 2011.06.22 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성
	  * 2011.07.18 진마리아 CHM-201111882-01 [VOP-PSO] COA data I/F
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchPortTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchPortTypeRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN TURN_SKD_VOY_NO IS NULL THEN" ).append("\n"); 
		query.append("           'GENERAL'" ).append("\n"); 
		query.append("       ELSE CASE WHEN TURN_PORT_IND_CD IN ('Y', 'N') THEN" ).append("\n"); 
		query.append("                'TURNING'" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                'VIRTUAL'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       END PORT_TYPE" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD=SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO=SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD=SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND VPS_PORT_CD=@[vps_port_cd]" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ=@[clpt_ind_seq]" ).append("\n"); 

	}
}