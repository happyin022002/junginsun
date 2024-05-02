/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoValRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.07.29 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoValRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Costmer No 존재여부 체크
	  * </pre>
	  */
	public USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoValRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration").append("\n"); 
		query.append("FileName : USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoValRSQL").append("\n"); 
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
		query.append("SELECT 'OK' CHK" ).append("\n"); 
		query.append("FROM   TRS_TRSP_USA_ACT_CUST" ).append("\n"); 
		query.append("WHERE  NVL(act_cust_cnt_cd,' ') = nvl(SUBSTR(@[act_cust_cnt_cd],1,2),' ')" ).append("\n"); 
		query.append("AND    NVL(act_cust_seq,0)      = nvl(TO_number(SUBSTR(@[act_cust_cnt_cd],3,6)),0)" ).append("\n"); 
		query.append("AND    act_cust_bnd_cd          = @[act_cust_bnd_cd]" ).append("\n"); 
		query.append("AND    dor_nod_cd               = @[dor_nod_cd]" ).append("\n"); 

	}
}