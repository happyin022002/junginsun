/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetRegularValueByObjectNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14 
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

public class GeneralInvoiceAuditDBDAOgetRegularValueByObjectNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Object No of Reqular Value Search
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetRegularValueByObjectNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetRegularValueByObjectNoRSQL").append("\n"); 
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
		query.append("SELECT T2.OBJ_LIST_NO" ).append("\n"); 
		query.append("     , TO_CHAR(T1.DFLT_VAL) AS DFLT_VAL" ).append("\n"); 
		query.append("  FROM PSO_YD_CHG_OBJ_LIST T1" ).append("\n"); 
		query.append("     , PSO_OBJ_LIST T2" ).append("\n"); 
		query.append(" WHERE T1.OBJ_LIST_NO       (+)= T2.OBJ_LIST_NO" ).append("\n"); 
		query.append("   AND T1.YD_CHG_NO         (+)= @[yd_chg_no]" ).append("\n"); 
		query.append("   AND T1.YD_CHG_VER_SEQ    (+)= @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("   AND T2.PSO_MEAS_UT_CD    <> 12" ).append("\n"); 
		query.append("   AND T2.OBJ_LIST_NO IN (" ).append("\n"); 
		query.append("#foreach($key IN ${obj_list_no}) #if($velocityCount < $obj_list_no.size()) '$key', #else '$key' #end #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" UNION" ).append("\n"); 
		query.append("SELECT T2.OBJ_LIST_NO" ).append("\n"); 
		query.append("     , ''''||NVL(T1.DFLT_FLG,'N')||'''' AS DFLT_VAL" ).append("\n"); 
		query.append("  FROM PSO_YD_CHG_OBJ_LIST T1" ).append("\n"); 
		query.append("     , PSO_OBJ_LIST T2" ).append("\n"); 
		query.append(" WHERE T1.OBJ_LIST_NO       (+)= T2.OBJ_LIST_NO" ).append("\n"); 
		query.append("   AND T1.YD_CHG_NO         (+)= @[yd_chg_no]" ).append("\n"); 
		query.append("   AND T1.YD_CHG_VER_SEQ    (+)= @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("   AND T2.PSO_MEAS_UT_CD     = 12" ).append("\n"); 
		query.append("   AND T2.OBJ_LIST_NO IN (" ).append("\n"); 
		query.append("#foreach($key IN ${obj_list_no2}) #if($velocityCount < $obj_list_no2.size()) '$key', #else '$key' #end #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}