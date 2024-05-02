/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetRegularValueRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2010.03.16 김진주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim JinJoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetRegularValueRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getRegularValue
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetRegularValueRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obj_list_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetRegularValueRSQL").append("\n"); 
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
		query.append("SELECT   TO_CHAR(T1.dflt_val)" ).append("\n"); 
		query.append("FROM   pso_yd_chg_obj_list T1, pso_obj_list T2" ).append("\n"); 
		query.append("WHERE  T1.obj_list_no = T2.obj_list_no" ).append("\n"); 
		query.append("AND T1.yd_chg_no = @[yd_chg_no]" ).append("\n"); 
		query.append("AND T1.yd_chg_ver_seq = @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("AND T1.OBJ_LIST_NO = @[obj_list_no]" ).append("\n"); 
		query.append("AND ( T2.PSO_MEAS_UT_CD <> 12 or PSO_OBJ_LIST_TP_CD != 'M')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  ''''||NVL(T1.dflt_flg,'N')||''''" ).append("\n"); 
		query.append("FROM   pso_yd_chg_obj_list T1, pso_obj_list T2" ).append("\n"); 
		query.append("WHERE  T1.obj_list_no(+) = T2.obj_list_no" ).append("\n"); 
		query.append("AND T1.yd_chg_no(+) = @[yd_chg_no]" ).append("\n"); 
		query.append("AND T1.yd_chg_ver_seq(+) = @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("AND T2.OBJ_LIST_NO = @[obj_list_no]" ).append("\n"); 
		query.append("AND ( T2.PSO_MEAS_UT_CD =  12 AND T2.PSO_OBJ_LIST_TP_CD = 'M')" ).append("\n"); 

	}
}