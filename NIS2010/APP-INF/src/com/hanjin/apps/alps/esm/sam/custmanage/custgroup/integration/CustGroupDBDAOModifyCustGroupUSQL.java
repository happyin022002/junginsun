/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustGroupDBDAOModifyCustGroupUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustGroupDBDAOModifyCustGroupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer gorup update
	  * </pre>
	  */
	public CustGroupDBDAOModifyCustGroupUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custgroup.integration").append("\n"); 
		query.append("FileName : CustGroupDBDAOModifyCustGroupUSQL").append("\n"); 
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
		query.append("#if (${ibflag} == 'I')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE MDM_CUSTOMER" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("   CUST_GRP_ID                         = @[cust_grp_id]                                                           " ).append("\n"); 
		query.append(",  UPD_USR_ID                          = @[upd_usr_id]                                                            " ).append("\n"); 
		query.append(",  UPD_DT                              = sysdate                                                                  " ).append("\n"); 
		query.append("WHERE CUST_CNT_CD    = substr(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ         = substr(@[cust_cd],3,6)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${ibflag} == 'D')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE MDM_CUSTOMER" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("   CUST_GRP_ID                         = NULL" ).append("\n"); 
		query.append(",  UPD_USR_ID                          = @[upd_usr_id]                                                            " ).append("\n"); 
		query.append(",  UPD_DT                              = sysdate                                                                  " ).append("\n"); 
		query.append("WHERE CUST_CNT_CD    = substr(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ         = substr(@[cust_cd],3,6)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE MDM_CUSTOMER" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("   CUST_GRP_ID                         = @[cust_grp_id]                                                           " ).append("\n"); 
		query.append(",  UPD_USR_ID                          = @[upd_usr_id]                                                            " ).append("\n"); 
		query.append(",  UPD_DT                              = sysdate                                                                  " ).append("\n"); 
		query.append("WHERE CUST_CNT_CD    = substr(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ         = substr(@[cust_cd],3,6)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}