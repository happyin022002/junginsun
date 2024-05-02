/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOSearchPsoTgtVvdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.10.04 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOSearchPsoTgtVvdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_TGT_VVD 정보를 조회한다.
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOSearchPsoTgtVvdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOSearchPsoTgtVvdVORSQL").append("\n"); 
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
		query.append("SELECT * FROM PSO_TGT_VVD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PSO_BZTP_CD='2'" ).append("\n"); 
		query.append("AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO=@[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 

	}
}