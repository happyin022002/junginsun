/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOcheckTurningPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
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

public class GeneralInvoiceAuditDBDAOcheckTurningPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkTurningPort
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOcheckTurningPortRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOcheckTurningPortRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(1), 0)" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append(" WHERE VSL_CD           = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO       = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD       = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("   AND YD_CD            = @[yd_cd]" ).append("\n"); 
		query.append("#if (${clpt_ind_seq} != '') " ).append("\n"); 
		query.append("   AND CLPT_IND_SEQ     = @[clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("   AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("   AND NVL(VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 

	}
}