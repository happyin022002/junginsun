/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOmodifySalesRepCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOmodifySalesRepCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Rep update
	  * </pre>
	  */
	public CustMainDBDAOmodifySalesRepCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOmodifySalesRepCodeUSQL").append("\n"); 
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
		query.append("#if (${ibflag} == 'U')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE BKG_CUST_SLS_REP" ).append("\n"); 
		query.append("	SET DP_SEQ = '0'," ).append("\n"); 
		query.append("		DELT_FLG = 'N'," ).append("\n"); 
		query.append("		SREP_CUST_CLSS_CD =  NVL(SREP_CUST_CLSS_CD,'C'), " ).append("\n"); 
		query.append("		UPD_USR_ID =  @[user_id]," ).append("\n"); 
		query.append("		UPD_DT =  SYSDATE" ).append("\n"); 
		query.append("	WHERE SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("	  AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	  AND CUST_SEQ = @[cust_seq] 	 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${ibflag} == 'D')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE BKG_CUST_SLS_REP" ).append("\n"); 
		query.append("	SET DELT_FLG = 'Y'," ).append("\n"); 
		query.append("	    UPD_USR_ID = @[user_id]," ).append("\n"); 
		query.append("		UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	WHERE SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("	  AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	  AND CUST_SEQ = @[cust_seq] 	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}